package jkt.hms.masters.controller;

import static jkt.hms.util.RequestConstants.ACCOUNT_HEAD;
import static jkt.hms.util.RequestConstants.ADDRESS_1;
import static jkt.hms.util.RequestConstants.ADDRESS_2;
import static jkt.hms.util.RequestConstants.AGE;
import static jkt.hms.util.RequestConstants.AGE_UNIT;
import static jkt.hms.util.RequestConstants.APPOINTMENT_DATE;
import static jkt.hms.util.RequestConstants.BANK_ACCOUNT_CODE;
import static jkt.hms.util.RequestConstants.BANK_ACCOUNT_NUMBER;
import static jkt.hms.util.RequestConstants.BANK_CODE;
import static jkt.hms.util.RequestConstants.BASIC_PAY;
import static jkt.hms.util.RequestConstants.BLOOD_GROUP_ID;
import static jkt.hms.util.RequestConstants.BRAND_JSP;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMAND_ID;
import static jkt.hms.util.RequestConstants.COMMAND_JSP;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.COST_CENTER_ID;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DESIGNATION_ID;
import static jkt.hms.util.RequestConstants.EMAIL;
import static jkt.hms.util.RequestConstants.EMERGENCY_MOBILE;
import static jkt.hms.util.RequestConstants.EMERGENCY_PHONE;
import static jkt.hms.util.RequestConstants.EMPLOYEE_CATEGORY_ID;
import static jkt.hms.util.RequestConstants.EMPLOYEE_CODE;
import static jkt.hms.util.RequestConstants.EMPLOYEE_DEPENDENT_ADDRESS;
import static jkt.hms.util.RequestConstants.EMPLOYEE_DEPENDENT_DOB;
import static jkt.hms.util.RequestConstants.EMPLOYEE_DEPENDENT_JSP;
import static jkt.hms.util.RequestConstants.EMPLOYEE_GRADE;
import static jkt.hms.util.RequestConstants.EMPLOYEE_GRADE_ID;
import static jkt.hms.util.RequestConstants.EMPLOYEE_ID;
import static jkt.hms.util.RequestConstants.EMPLOYEE_JOB_CODE;
import static jkt.hms.util.RequestConstants.EMPLOYEE_JSP;
import static jkt.hms.util.RequestConstants.EMPLOYEE_PAY_ELEMENTS_JSP;
import static jkt.hms.util.RequestConstants.EMPLOYEE_PAY_STRUCTURE_JSP;
import static jkt.hms.util.RequestConstants.EMPLOYEE_PHOTO;
import static jkt.hms.util.RequestConstants.EMP_STATUS_ID;
import static jkt.hms.util.RequestConstants.EMP_STATUS_JSP;
import static jkt.hms.util.RequestConstants.FIRST_NAME;
import static jkt.hms.util.RequestConstants.FORMATION_JSP;
import static jkt.hms.util.RequestConstants.HIGH_VALUE_DRUG;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.JOIN_DATE;
import static jkt.hms.util.RequestConstants.LAST_NAME;
import static jkt.hms.util.RequestConstants.LOCAL_UNIT;
import static jkt.hms.util.RequestConstants.MANUFACTURER_ID;
import static jkt.hms.util.RequestConstants.MIDDLE_NAME;
import static jkt.hms.util.RequestConstants.MOBILE;
import static jkt.hms.util.RequestConstants.NAME_ITEM;
import static jkt.hms.util.RequestConstants.PAYMENT_MODE;
import static jkt.hms.util.RequestConstants.PAYROLL_ID;
import static jkt.hms.util.RequestConstants.PAY_AMOUNT;
import static jkt.hms.util.RequestConstants.PAY_ELEMENT_CODE;
import static jkt.hms.util.RequestConstants.PAY_ELEMENT_START_DATE;
import static jkt.hms.util.RequestConstants.PAY_ELEMENT_TYPE;
import static jkt.hms.util.RequestConstants.PAY_STR_FROM_DATE;
import static jkt.hms.util.RequestConstants.PAY_STR_TO_DATE;
import static jkt.hms.util.RequestConstants.PHONE;
import static jkt.hms.util.RequestConstants.RANK_CATEGORY_ID;
import static jkt.hms.util.RequestConstants.RANK_CATEGORY_JSP;
import static jkt.hms.util.RequestConstants.RANK_ID;
import static jkt.hms.util.RequestConstants.RANK_JSP;
import static jkt.hms.util.RequestConstants.RECORD_OFFICE_ADDRESS_JSP;
import static jkt.hms.util.RequestConstants.REFERRAL_DOCTOR_JSP;
import static jkt.hms.util.RequestConstants.REFERRAL_TYPE;
import static jkt.hms.util.RequestConstants.RELATION_ID;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.SERVICE_TYPE_ID;
import static jkt.hms.util.RequestConstants.STATION_ID;
import static jkt.hms.util.RequestConstants.STATION_JSP;
import static jkt.hms.util.RequestConstants.STATUS;
import static jkt.hms.util.RequestConstants.TELL_NO_OFFICE;
import static jkt.hms.util.RequestConstants.TELL_NO_RESIDENCE;
import static jkt.hms.util.RequestConstants.TITLE_ID;
import static jkt.hms.util.RequestConstants.TRADE_ID;
import static jkt.hms.util.RequestConstants.TRADE_JSP;
import static jkt.hms.util.RequestConstants.UNIT_ADDRESS;
import static jkt.hms.util.RequestConstants.UNIT_ID;
import static jkt.hms.util.RequestConstants.UNIT_JSP;
import static jkt.hms.util.RequestConstants.URL;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import jkt.hms.masters.business.HrEmployeePayElements;
import jkt.hms.masters.business.HrEmployeePayStructure;
import jkt.hms.masters.business.HrMasPayElement;
import jkt.hms.masters.business.HrMasPayroll;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasBloodGroup;
import jkt.hms.masters.business.MasCommand;
import jkt.hms.masters.business.MasCostCenter;
import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasDivision;
import jkt.hms.masters.business.MasEmpCategory;
import jkt.hms.masters.business.MasEmpStatus;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDependent;
import jkt.hms.masters.business.MasEmployeeType;
import jkt.hms.masters.business.MasFormation;
import jkt.hms.masters.business.MasGrade;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasManufacturer;
import jkt.hms.masters.business.MasMedicalCategory;
import jkt.hms.masters.business.MasOthersCategory;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRankCategory;
import jkt.hms.masters.business.MasRecordOfficeAddress;
import jkt.hms.masters.business.MasReferralDoctor;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasStation;
import jkt.hms.masters.business.MasStoreBrand;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.masters.handler.PersonnelMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import securityenc.EncryptPwd;

public class PersonnelMasterController extends MultiActionController {

	PersonnelMasterHandlerService personnelMasterHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	String jsp = "";
	String title = "";
	String message = "";
	String url = "";
	String code = "";
	String name = "";
	Date dob;
	String gender = "";
	String address = "";
	String jspName = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoPropertyAddress = "";
	String pojoName = "";
	String userName = "";
	String currentDate = "";
	String currentTime = "";
	HttpSession session = null;

	// --------------------------------- Employee
	// Status------------------------------------------------

	public ModelAndView searchEmpStatus(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String empStatusCode = null;
		String empStatusName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			empStatusCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			empStatusName = request.getParameter(SEARCH_NAME);
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
			empStatusCode = searchField;
			empStatusName = null;

		} else {
			empStatusCode = null;
			empStatusName = searchField;
		}
		map = personnelMasterHandlerService.searchEmpStatus(empStatusCode,
				empStatusName);
		jsp = EMP_STATUS_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("empStatusCode", empStatusCode);
		map.put("empStatusName", empStatusName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showEmpStatusJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = personnelMasterHandlerService.showEmpStatusJsp();
		@SuppressWarnings("unused")
		ArrayList searchEmpStatusList = (ArrayList) map
				.get("searchEmpStatusList");
		jsp = EMP_STATUS_JSP;
		jsp += ".jsp";
		title = "Employee Status";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addEmpStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasEmpStatus masEmpStatus = new MasEmpStatus();
		String changedBy = "";
		Map listMap = new HashMap();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
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
		List empStatusCodeList = new ArrayList();
		List empStatusNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			empStatusCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			empStatusNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((empStatusCodeList.size() == 0 || empStatusCodeList == null)
				&& (empStatusNameList.size() == 0 || empStatusNameList == null)) {
			masEmpStatus.setEmpStatusCode(code);
			masEmpStatus.setEmpStatusName(name);
			masEmpStatus.setStatus("y");
			masEmpStatus.setLastChgBy(changedBy);
			masEmpStatus.setLastChgDate(currentDate);
			masEmpStatus.setLastChgTime(currentTime);
			successfullyAdded = personnelMasterHandlerService
					.addEmpStatus(masEmpStatus);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((empStatusCodeList.size() != 0 || empStatusCodeList != null)
				|| (empStatusNameList.size() != 0) || empStatusNameList != null) {

			if ((empStatusCodeList.size() != 0 || empStatusCodeList != null)
					&& (empStatusNameList.size() == 0 || empStatusNameList == null)) {

				message = "Employee Status Code  already exists.";
			} else if ((empStatusNameList.size() != 0 || empStatusNameList != null)
					&& (empStatusCodeList.size() == 0 || empStatusCodeList == null)) {

				message = "Employee Status Name already exists.";
			} else if ((empStatusCodeList.size() != 0 || empStatusCodeList != null)
					&& (empStatusNameList.size() != 0 || empStatusNameList != null)) {

				message = "Employee Status Code and Employee Status Name already exist.";
			}
		}
		url = "/hms/hms/personnel?method=showEmpStatusJsp";

		try {
			map = personnelMasterHandlerService.showEmpStatusJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = EMP_STATUS_JSP;
		title = "Add Employee Status";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editEmpStatus(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String empStatusCode = "";
		String empStatusName = "";
		int empStatusId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		empStatusCode = (String) session.getAttribute("empStatusCode");
		empStatusName = (String) session.getAttribute("empStatusName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			empStatusId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			empStatusCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			empStatusName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", empStatusId);
		generalMap.put("empStatusCode", empStatusCode);
		generalMap.put("name", empStatusName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingOccupationNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingOccupationNameList.size() == 0) {
			dataUpdated = personnelMasterHandlerService
					.editEmpStatusToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingOccupationNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/personnel?method=showEmpStatusJsp";
		try {
			map = personnelMasterHandlerService.showEmpStatusJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = EMP_STATUS_JSP;
		title = "Edit Employee Status";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteEmpStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int empStatusId = 0;
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
			empStatusId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = personnelMasterHandlerService.deleteEmpStatus(
				empStatusId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showEmpStatusJsp";
		try {
			map = personnelMasterHandlerService.showEmpStatusJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = EMP_STATUS_JSP;
		title = "Delete EmployeeStatus";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// --------------------------Employee Dependent
	// ---------------------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showEmployeeDependentJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = personnelMasterHandlerService
				.showEmployeeDependentJsp();
		@SuppressWarnings("unused")
		ArrayList searchEmployeeDependentList = (ArrayList) map
				.get("searchEmployeeDependentList");
		jsp = EMPLOYEE_DEPENDENT_JSP;
		jsp += ".jsp";
		title = "Employee Dependent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	
		
		public ModelAndView addEmployeeDependent(HttpServletRequest hrequest,
				HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasEmployeeDependent masEmployeeDependent = new MasEmployeeDependent();
		@SuppressWarnings("unused")
		int personnelcodeId = 0;
		int employeecodeId = 0;
		int relationcodeId = 0;
		
		String employeeDependentLName="";
		String employeeDependentMName="";
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String contactNo="";
		
		session = hrequest.getSession();
		Map<String, Object> userMap = new HashMap<String, Object>();
		MultipartFormDataRequest request = null;
	     if (MultipartFormDataRequest.isMultipartFormData(hrequest))
	        {
	             try
	             {
	                 request = new MultipartFormDataRequest(hrequest);
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
	     String filename = "";
	     String uploadURL="";
	     String comments = "";
	     String fileExtension=null;
	
		if (request.getParameter("employeeDependentMName") != null) {
			employeeDependentMName = request.getParameter("employeeDependentMName");
		}
		if (request.getParameter("employeeDependentLName") != null) {
			employeeDependentLName = request.getParameter("employeeDependentLName");
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		
		
		if (request.getParameter(EMPLOYEE_DEPENDENT_DOB) != null) {
			dob = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(EMPLOYEE_DEPENDENT_DOB));
		}
		
		if (request.getParameter("contactNo") != null) {
			contactNo = request.getParameter("contactNo");
		}
		if (request.getParameter(EMPLOYEE_DEPENDENT_ADDRESS) != null) {
			address = request.getParameter(EMPLOYEE_DEPENDENT_ADDRESS);
		}
		if (request.getParameter(HOSPITAL_ID) != null) {
			personnelcodeId = Integer.parseInt(request
					.getParameter(HOSPITAL_ID));
		}
		if (request.getParameter(EMPLOYEE_ID) != null) {
			employeecodeId = Integer
					.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		if (request.getParameter(RELATION_ID) != null) {
			relationcodeId = Integer
					.parseInt(request.getParameter(RELATION_ID));
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
		int hospitalId = 0;
		if (request.getParameter(HOSPITAL_ID) != null
				&& !(request.getParameter(HOSPITAL_ID).equals(""))) {
			hospitalId = Integer.parseInt(request.getParameter(HOSPITAL_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
//		if (request.getParameter("pojoName") != null) {
//			pojoName = request.getParameter("pojoName");
//		}
//		if (request.getParameter("pojoPropertyName") != null) {
//			pojoPropertyName = request.getParameter("pojoPropertyName");
//		}
//		if (request.getParameter("pojoPropertyCode") != null) {
//			pojoPropertyCode = request.getParameter("pojoPropertyCode");
//		}
//		if (request.getParameter("pojoPropertyAddress") != null) {
//			pojoPropertyAddress = request.getParameter("pojoPropertyAddress");
//		}
		//generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("employeecodeId", employeecodeId);
		generalMap.put("relationcodeId", relationcodeId);
		generalMap.put("address", address);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("flag","add");
/*		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyAddress", pojoPropertyAddress);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List employeeDependentCodeList = new ArrayList();
		List employeeDependentNameList = new ArrayList();
		@SuppressWarnings("unused")
		List employeeDependentDOBList = new ArrayList();
		@SuppressWarnings("unused")
		List employeeDependentGenderList = new ArrayList();
		@SuppressWarnings("unused")
		List employeeDependentAddressList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			employeeDependentCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			employeeDependentNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		if (listMap.get("duplicateGeneralDOBList") != null) {
			employeeDependentDOBList = (List) listMap
					.get("duplicateGeneralDOBList");
		}
		if (listMap.get("duplicateGeneralGenderList") != null) {
			employeeDependentGenderList = (List) listMap
					.get("duplicateGeneralGenderList");
		}
		if (listMap.get("duplicateGeneralAddressList") != null) {
			employeeDependentAddressList = (List) listMap
					.get("duplicateGeneralAddressList");
		}*/
		boolean successfullyAdded = false;

	/*	if ((employeeDependentCodeList.size() == 0 || employeeDependentCodeList == null)
				&& (employeeDependentNameList.size() == 0 || employeeDependentNameList == null)) {
				
				
			
	*/		
		List employeeDependentList = new ArrayList();
		listMap = personnelMasterHandlerService.checkForExisting(generalMap);

		if (listMap.get("employeeDependentList") != null) {
			employeeDependentList = (List) listMap
					.get("employeeDependentList");
		}
		if (employeeDependentList.size() == 0 || employeeDependentList == null){
			//masEmployeeDependent.setEmployeeDependentCode(code);
			masEmployeeDependent.setEmployeeDependentFName(name);
			masEmployeeDependent.setEmployeeDependentMName(employeeDependentMName);
			masEmployeeDependent.setEmployeeDependentLName(employeeDependentLName);
			masEmployeeDependent.setDateOfBirth(dob);
			
			if (request.getParameter(BLOOD_GROUP_ID) != null
					&& Integer.parseInt(request.getParameter(BLOOD_GROUP_ID)) != 0) {
				MasBloodGroup bloodGroup = new MasBloodGroup();
				bloodGroup.setId(Integer.parseInt(request
						.getParameter(BLOOD_GROUP_ID)));
				masEmployeeDependent.setBloodGroup(bloodGroup);
			}else{
				Map<String, Object> dataMap = new HashMap<String, Object>();
				
				Properties properties = new Properties();
				URL resourcePathHIC = Thread.currentThread().getContextClassLoader()
						.getResource("adt.properties");
				try {
					properties.load(resourcePathHIC.openStream());
				} catch (Exception e) {
					e.printStackTrace();
				}
				String bloodGroupCode = properties.getProperty("bloodGroupCodeForNA");
				map=personnelMasterHandlerService.getBloodGroupId(bloodGroupCode);
				
				int bloodGroupIdNA=(Integer)map.get("bloodGroupIdNA");
				MasBloodGroup bloodGroup = new MasBloodGroup();
				bloodGroup.setId(bloodGroupIdNA);
				masEmployeeDependent.setBloodGroup(bloodGroup);
				
			}
			if (request.getParameter("sexId") != null
					&& Integer.parseInt(request.getParameter("sexId")) != 0) {
				MasAdministrativeSex sex = new MasAdministrativeSex();
				sex.setId(Integer.parseInt(request.getParameter("sexId")));
				masEmployeeDependent.setGender(sex);
			}
			masEmployeeDependent.setAddress(address);

			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeecodeId);
			masEmployeeDependent.setEmployee(masEmployee);

			MasRelation masRelation = new MasRelation();
			masRelation.setId(relationcodeId);
			masEmployeeDependent.setRelation(masRelation);

			masEmployeeDependent.setStatus("y");
			masEmployeeDependent.setLastChgBy(changedBy);
			masEmployeeDependent.setLastChgDate(currentDate);
			masEmployeeDependent.setLastChgTime(currentTime);
			masEmployeeDependent.setContactNo(contactNo);
			MasHospital hospital = new MasHospital();
			System.out.println("hospitalId" + hospitalId);
			hospital.setId(hospitalId);
			masEmployeeDependent.setHospital(hospital);

			
			String flag="n";	
			if(request.getParameter("flag")!=null){
		      	 flag = (String)request.getParameter("flag");
		       }
		     if(request.getParameter("fileName")!= null && !request.getParameter("fileName").equals("")){
		         filename = request.getParameter("fileName");
		     
		     	 uploadURL = getServletContext().getRealPath("/UploadedDocuments/EMPDEPDENT/");
		     	userMap.put("uploadURL", uploadURL);
		    if(flag.equalsIgnoreCase("y"))
		    {    
		      
		            List fileUploadedList = null;           
		            userMap.put("filename", filename);
		            StringTokenizer strToken=new StringTokenizer(filename,".");
		            Long fileSizeLimit = RequestConstants.MAX_FILE_SIZE;
		            filename=strToken.nextToken();
		            fileExtension=strToken.nextToken();
		            String whiteList = "*."+fileExtension;             
		            fileUploadedList = HMSUtil.uploadFileMaintenance(request,uploadURL, whiteList,fileSizeLimit,filename);
		    }  } 
			
			successfullyAdded = personnelMasterHandlerService.addEmployeeDependent(masEmployeeDependent,userMap);

			if (successfullyAdded) {

				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}else{
			message = "Either Relation Name or Dependent Name already exist";
		}
			/*}

		else if ((employeeDependentCodeList.size() != 0 || employeeDependentCodeList != null)
				|| (employeeDependentNameList.size() != 0)
				|| employeeDependentNameList != null) {
			if ((employeeDependentCodeList.size() != 0 || employeeDependentCodeList != null)
					&& (employeeDependentNameList.size() == 0 || employeeDependentNameList == null)) {

				message = "EmployeeDependent Code  already exists.";
			} else if ((employeeDependentNameList.size() != 0 || employeeDependentNameList != null)
					&& (employeeDependentCodeList.size() == 0 || employeeDependentCodeList == null)) {

				message = "EmployeeDependent Description  already exists.";
			} else if ((employeeDependentCodeList.size() != 0 || employeeDependentCodeList != null)
					&& (employeeDependentNameList.size() != 0 || employeeDependentNameList != null)) {
				message = "EmployeeDependent Code and EmployeeDependent Description already exist.";
			}
		}*/
		url = "/hms/hms/personnel?method=showEmployeeDependentJsp";
		try {
			map = personnelMasterHandlerService.showEmployeeDependentJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = EMPLOYEE_DEPENDENT_JSP;
		title = "Add EmployeeDependent";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchEmployeeDependent(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String employeeDependentCode = null;
		String employeeDependentName = null;
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
			employeeDependentCode = searchField;
			employeeDependentName = null;

		} else {
			employeeDependentCode = null;
			employeeDependentName = searchField;
		}
		map = personnelMasterHandlerService.searchEmployeeDependent(employeeDependentCode, employeeDependentName);
		jsp = EMPLOYEE_DEPENDENT_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		//map.put("employeeDependentcodeCode", employeeDependentCode);
		map.put("employeeDependentcodeName", employeeDependentName);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editEmployeeDependent(HttpServletRequest hrequest,HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		
		String employeeDependentMName = "";
		String employeeDependentName = "";
		String employeeDependentLName = "";
		Date dob = new Date();
		int sexId = 0;
		int bloodGroupId = 0;
		String contactNo="";
		String employeeDependentAddress = "";
		int personnelcodeId = 0;
		int employeecodeId = 0;
		int relationcodeId = 0;
		int employeeDependentcodeId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		MultipartFormDataRequest request = null;
	     if (MultipartFormDataRequest.isMultipartFormData(hrequest))
	        {
	             try
	             {
	                 request = new MultipartFormDataRequest(hrequest);
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
	     String filename = "";
	     String uploadURL="";
	     String comments = "";
	     String fileExtension=null;
	   
	     	
	    	session = hrequest.getSession();
		if (request.getParameter(HOSPITAL_ID) != null
				&& !(request.getParameter(HOSPITAL_ID).equals(""))) {
			personnelcodeId = Integer.parseInt(request
					.getParameter(HOSPITAL_ID));
		}
		if (request.getParameter(EMPLOYEE_ID) != null
				&& !(request.getParameter(EMPLOYEE_ID).equals(""))) {
			employeecodeId = Integer
					.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		if (request.getParameter(RELATION_ID) != null
				&& !(request.getParameter(RELATION_ID).equals(""))) {
			relationcodeId = Integer
					.parseInt(request.getParameter(RELATION_ID));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			employeeDependentcodeId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
	/*	if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			employeeDependentCode = request.getParameter(CODE);
		}*/
		
		
		if (request.getParameter(BLOOD_GROUP_ID) != null
				&& Integer.parseInt(request.getParameter(BLOOD_GROUP_ID)) != 0
				&& !request.getParameter(BLOOD_GROUP_ID).equals("")) {
			bloodGroupId = Integer.parseInt(request
					.getParameter(BLOOD_GROUP_ID));
		}else{
			Map<String, Object> dataMap = new HashMap<String, Object>();
			
			Properties properties = new Properties();
			URL resourcePathHIC = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				properties.load(resourcePathHIC.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
			String bloodGroupCode = properties.getProperty("bloodGroupCodeForNA");
			dataMap=personnelMasterHandlerService.getBloodGroupId(bloodGroupCode);
			bloodGroupId=(Integer)dataMap.get("bloodGroupIdNA");
			
			
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			employeeDependentName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(EMPLOYEE_DEPENDENT_DOB) != null) {
			dob = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(EMPLOYEE_DEPENDENT_DOB));
		}
		if (request.getParameter("sexId") != null
				&& !(request.getParameter("sexId").equals("0"))) {
			sexId = Integer.parseInt(request
					.getParameter("sexId"));
		}
		if (request.getParameter("employeeDependentMName") != null) {
			employeeDependentMName = request.getParameter("employeeDependentMName");
		}
		if (request.getParameter("employeeDependentLName") != null) {
			employeeDependentLName = request.getParameter("employeeDependentLName");
		}
		if (request.getParameter("contactNo") != null) {
			contactNo = request.getParameter("contactNo");
		}
		if (request.getParameter(EMPLOYEE_DEPENDENT_ADDRESS) != null
				&& !(request.getParameter(EMPLOYEE_DEPENDENT_ADDRESS)
						.equals(""))) {
			employeeDependentAddress = request
					.getParameter(EMPLOYEE_DEPENDENT_ADDRESS);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
	/*	if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}*/
		
		
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		
	
		 
		generalMap.put("id", employeeDependentcodeId);
		//generalMap.put("employeeDependentCode", employeeDependentCode);
		generalMap.put("name", employeeDependentName);
		generalMap.put("employeeDependentMName", employeeDependentMName);
		generalMap.put("employeeDependentLName", employeeDependentLName);

		generalMap.put("employeeDependentDOB", dob);
		generalMap.put("sexId", sexId);
		generalMap.put("employeeDependentAddress", employeeDependentAddress);
		generalMap.put("personnelcodeId", personnelcodeId);
		generalMap.put("employeecodeId", employeecodeId);
		generalMap.put("bloodGroupId", bloodGroupId);
		generalMap.put("contactNo", contactNo);
		generalMap.put("relationcodeId", relationcodeId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		/*generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
*/
		generalMap.put("flag", "update");

		/*listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingEmployeeDependentNameList = (List) listMap
				.get("duplicateMastersList");
		*/
		List employeeDependentList = new ArrayList();
		listMap = personnelMasterHandlerService.checkForExisting(generalMap);

		if (listMap.get("employeeDependentList") != null) {
			employeeDependentList = (List) listMap
					.get("employeeDependentList");
		}
		
		String flag="n";	
		if(request.getParameter("fileName")!= null && !request.getParameter("fileName").equals("")){
		         filename = request.getParameter("fileName");
		     
		if(request.getParameter("flag")!=null){
	      	 flag = (String)request.getParameter("flag");
	       }
		
		     	 uploadURL = getServletContext().getRealPath("/UploadedDocuments/EMP/");
		     	
		     	
	    if(flag.equalsIgnoreCase("y"))
	    {    
	      
	            List fileUploadedList = null;           
	            generalMap.put("filename", filename);
	            StringTokenizer strToken=new StringTokenizer(filename,".");
	            Long fileSizeLimit = RequestConstants.MAX_FILE_SIZE;
	            filename=strToken.nextToken();
	            fileExtension=strToken.nextToken();
	            String whiteList = "*."+fileExtension;             
	            fileUploadedList = HMSUtil.uploadFileMaintenance(request,uploadURL, whiteList,fileSizeLimit,filename);
	    }  
		  }
		 generalMap.put("uploadURL", uploadURL);
		
		boolean dataUpdated = false;
		if (employeeDependentList.size() == 0) {
			dataUpdated = personnelMasterHandlerService
					.editEmployeeDependent(generalMap);
			
			if (dataUpdated == true) {
				message = "Record Updated Successfully !!";
			} else {
				message = "Record Cant Be Updated !!";
			}
		} else if (employeeDependentList.size() > 0) {
			message = "Either Relation Name or Dependent Name already exist";
		}
		url = "/hms/hms/personnel?method=showEmployeeDependentJsp";
		try {
			map = personnelMasterHandlerService.showEmployeeDependentJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = EMPLOYEE_DEPENDENT_JSP;
		title = "Edit Employee Dependent";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteEmployeeDependent(HttpServletRequest hrequest,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int employeeDependentcodeId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		session = hrequest.getSession();
		MultipartFormDataRequest request = null;
	     if (MultipartFormDataRequest.isMultipartFormData(hrequest))
	        {
	             try
	             {
	                 request = new MultipartFormDataRequest(hrequest);
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
	     String filename = "";
	     String uploadURL="";
	     String comments = "";
	     String fileExtension=null;
	     if(request.getParameter("fileName")!= null && !request.getParameter("fileName").equals("")){
	         filename = request.getParameter("fileName");
	     }
	     	 uploadURL = getServletContext().getRealPath("/UploadedDocuments/EMP/");
	     	generalMap.put("uploadURL", uploadURL);
	     	
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			employeeDependentcodeId = Integer.parseInt(request
					.getParameter(COMMON_ID));
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
		dataDeleted = personnelMasterHandlerService.deleteEmployeeDependent(
				employeeDependentcodeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showEmployeeDependentJsp";

		try {
			map = personnelMasterHandlerService.showEmployeeDependentJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = EMPLOYEE_DEPENDENT_JSP;
		title = "Delete EmployeeDependent";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ----------------------------------------
	// Employee-----------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showEmployeeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		Map<String, Object> map = personnelMasterHandlerService
				.showEmployeeJsp(hospitalId);
		jsp = EMPLOYEE_JSP;
		jsp += ".jsp";
		title = "Employee";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView searchEmployee(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapEmployee = new HashMap<String, Object>();
		String serviceNo = null;
		String firstName = null;
		String lastName = null;
		String searchField = null;
		session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
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
		}
		if (searchRadio == 1) {
			serviceNo = searchField;
			firstName = null;
			lastName = null;
		} else if (searchRadio == 2) {
			serviceNo = null;
			firstName = searchField;
			lastName = null;
		} else if (searchRadio == 3) {
			serviceNo = null;
			firstName = null;
			lastName = searchField;
		}

		map = personnelMasterHandlerService.searchEmployee(serviceNo,
				firstName, lastName, hospitalId);

		jsp = EMPLOYEE_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("serviceNo", serviceNo);
		map.put("firstName", firstName);
		map.put("lastName", lastName);

		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addEmployee(HttpServletRequest hrequest,
			HttpServletResponse response) {

		// System.out.println("In Con addEmployee  ======");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		MasEmployee masEmployee = new MasEmployee();
		String firstName = "";
		String middleName = "";
		String lastName = "";
		int titleId = 0;
		int departmentId = 0;
		int costCenterId = 0;
		int empStatusId = 0;
		int empCategoryId = 0;
		int gradeId = 0;
		int rankId = 0;
		int unitId = 0;
		int tradeId = 0;

		String remarks="";
		Date contract=new Date();
		Date extension=new Date();
		Date halJoiningDate = null;
		Date currDivisionJoiningDate = null;
		Date dob= null;
		
		int rankCategoryId = 0;
		int divisionId = 0;
		int empType = 0;
		String deptNo = "";
		String aadharCard = "";
		String localAddress = "";
		String perAddress = "";
		int localCountry = 0;
		int localState = 0;
		int localDistrict = 0;
		int perCountry = 0;
		int perState = 0;
		int perDistrict = 0;	

		String serviceNo = "";
		String emergencyTellNumber = "";
		String emergencyCellNumber = "";
		String residenceTellNumber = "";
		String officeTellNumber = "";
		Date appointmentDate = new Date();
		String jobCode = "";
		String email = "";
		String employeeUrl = "";
		String bankCode = "";
		String accounthead = "";
		String bankAccountCode = "";
		String bankAccountNumber = "";
		String employeePhoto = "";
		String changedBy = "";
		//String designation = "";
		Date joinDate = new Date();
		Date currentDate = new Date();
		session = hrequest.getSession();
		Map<String, Object> userMap = new HashMap<String, Object>();
		MultipartFormDataRequest request = null;
	     if (MultipartFormDataRequest.isMultipartFormData(hrequest))
	        {
	             try
	             {
	                 request = new MultipartFormDataRequest(hrequest);
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
	     String filename = "";
	     String uploadURL="";
	     String comments = "";
	     String fileExtension=null;
	
		/*
		 * if (request.getParameter(EMPLOYEE_CODE) != null) { code =
		 * request.getParameter(EMPLOYEE_CODE); }
		 */
		if (request.getParameter("rankCategoryId") != null
				&& !request.getParameter("rankCategoryId").equals("")) {
			rankCategoryId = Integer.parseInt(request.getParameter("rankCategoryId"));
		}
		if (request.getParameter("divisionId") != null
				&& !request.getParameter("divisionId").equals("0")) {
			divisionId = Integer.parseInt(request.getParameter("divisionId"));
		}
		if (request.getParameter("empType") != null
				&& !request.getParameter("empType").equals("")) {
			empType = Integer.parseInt(request.getParameter("empType"));
		}
		
		if (request.getParameter("currDivisionJoiningDate") != null
				&& !request.getParameter("currDivisionJoiningDate").equals("")) {
			currDivisionJoiningDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter("currDivisionJoiningDate"));
			
		}
		if (request.getParameter("contract") != null
				&& !request.getParameter("contract").equals("")) {
			contract =HMSUtil.dateFormatterDDMMYYYY(request.getParameter("contract"));
			
		}
		if (request.getParameter("extension") != null
				&& !request.getParameter("extension").equals("")) {
			extension =HMSUtil.dateFormatterDDMMYYYY(request.getParameter("extension"));
			
		}
		
		if (request.getParameter("remarks") != null) {
			remarks = request.getParameter("remarks");
		}		
		if (request.getParameter("halJoiningDate") != null
				&& !request.getParameter("halJoiningDate").equals("")) {
			halJoiningDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter("halJoiningDate"));
			
		}
		if (request.getParameter("dob") != null
				&& !request.getParameter("dob").equals("")) {
			dob = HMSUtil.dateFormatterDDMMYYYY(request.getParameter("dob"));
			
		}
		
		
		if (request.getParameter("deptNo") != null) {
			deptNo = request.getParameter("deptNo");
		}		

		if (request.getParameter("aadharCard") != null) {
			aadharCard = request.getParameter("aadharCard");
		}
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (request.getParameter(FIRST_NAME) != null) {
			firstName = request.getParameter(FIRST_NAME);
		}
		if (request.getParameter(MIDDLE_NAME) != null) {
			middleName = request.getParameter(MIDDLE_NAME);
		}
		if (request.getParameter(LAST_NAME) != null) {
			lastName = request.getParameter(LAST_NAME);
		}
		if (request.getParameter(EMPLOYEE_PHOTO) != null) {
			employeePhoto = request.getParameter(EMPLOYEE_PHOTO);
		}
		if (request.getParameter(TITLE_ID) != null
				&& !request.getParameter(TITLE_ID).equals("")) {
			titleId = Integer.parseInt(request.getParameter(TITLE_ID));
		}
		if (request.getParameter(EMPLOYEE_GRADE_ID) != null
				&& !request.getParameter(EMPLOYEE_GRADE_ID).equals("0")) {
			gradeId = Integer.parseInt(request.getParameter(EMPLOYEE_GRADE_ID));
		}
		if (request.getParameter(EMP_STATUS_ID) != null
				&& !request.getParameter(EMP_STATUS_ID).equals("0")) {
			empStatusId = Integer.parseInt(request.getParameter(EMP_STATUS_ID));
		}
		
		  if(!request.getParameter(RANK_ID).equals("0")) { 
			  rankId =  Integer.parseInt(request.getParameter(RANK_ID)); 
			  }
		
		if (!request.getParameter(EMPLOYEE_CATEGORY_ID).equals("0")
				&& !request.getParameter(EMPLOYEE_CATEGORY_ID).equals("")) {
			empCategoryId = Integer.parseInt(request
					.getParameter(EMPLOYEE_CATEGORY_ID));
		}
		
		if (request.getParameter("perState") != null	&& !request.getParameter("perState").equals("0")) {
			
			  perState =  Integer.parseInt(request.getParameter("perState")); 
			  }
		if (request.getParameter("localState") != null	&& !request.getParameter("localState").equals("0")) {
			
			  localState =  Integer.parseInt(request.getParameter("localState")); 
			  }
		  

			if (request.getParameter("localDistrict") != null	&& !request.getParameter("localDistrict").equals("0")) {
		  
			  localDistrict =  Integer.parseInt(request.getParameter("localDistrict")); 
			  }
			if (request.getParameter("perDistrict") != null	&& !request.getParameter("perDistrict").equals("0")) {
				   
			  perDistrict =  Integer.parseInt(request.getParameter("perDistrict")); 
			  }

			if (request.getParameter("localCountry") != null	&& !request.getParameter("localCountry").equals("0")) {
				
						  localCountry =  Integer.parseInt(request.getParameter("localCountry")); 
			  }
			if (request.getParameter("perCountry") != null	&& !request.getParameter("perCountry").equals("0")) {
				 
			  perCountry =  Integer.parseInt(request.getParameter("perCountry")); 
			  }
		  
		  

		if (!request.getParameter(DEPARTMENT_ID).equals("0")) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		/*String[] departmentIdArray = null;
		StringBuffer departmentStr = new StringBuffer();
		if (request.getParameterValues(DEPARTMENT_ID) != null
				&& !request.getParameterValues(DEPARTMENT_ID).equals("0")) {
			departmentIdArray = (String[]) (request
					.getParameterValues(DEPARTMENT_ID));
			for (int i = 0; i < departmentIdArray.length; i++) {
				departmentStr.append(departmentIdArray[i]);
				departmentStr.append(",");
			}
			departmentStr.deleteCharAt(departmentStr.length() - 1);
			userMap.put("departmentStr", departmentStr.toString());
		}*/
		userMap.put("departmentId", departmentId);
		if (request.getParameter(EMERGENCY_MOBILE) != null) {
			emergencyCellNumber = request.getParameter(EMERGENCY_MOBILE);
		}
		if (request.getParameter(TELL_NO_OFFICE) != null) {
			officeTellNumber = request.getParameter(TELL_NO_OFFICE);
		}
		if (request.getParameter(EMAIL) != null) {
			email = request.getParameter(EMAIL);
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
		int hospitalId = 0;
		if (request.getParameter(HOSPITAL_ID) != null
				&& !(request.getParameter(HOSPITAL_ID).equals(""))) {
			hospitalId = Integer.parseInt(request.getParameter(HOSPITAL_ID));
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
		
		String authorizedForHighValueMedicine="";
		if (request.getParameter(HIGH_VALUE_DRUG) != null) {
			authorizedForHighValueMedicine = request.getParameter(HIGH_VALUE_DRUG);
		}
		else{
			authorizedForHighValueMedicine="n";
		}
		
		// generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		generalMap.put("hospitalId", hospitalId);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		// System.out.println("listMap  "+listMap.size());
		List employeeCodeList = new ArrayList();
		List employeeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			employeeCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			employeeNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		System.out.println("employeeNameList.size()  "
				+ employeeNameList.size());
		if ((employeeNameList.size() == 0)) {

			// System.out.println("In Side if");
			// masEmployee.setEmployeeCode(code);
			masEmployee.setCurrentDivisionJoinDate(currDivisionJoiningDate);
			masEmployee.setHalJoinDate(halJoiningDate);
			masEmployee.setDateOfBirth(dob);
			masEmployee.setServiceNo(serviceNo);
			masEmployee.setFirstName(firstName);
			masEmployee.setLastName(lastName);
			masEmployee.setMiddleName(middleName);
			masEmployee.setAadharCard(aadharCard);
			masEmployee.setEmployeePhoto(employeePhoto);
			masEmployee.setBankAccountNumber(bankAccountNumber);
			masEmployee.setUrl(employeeUrl);
			masEmployee.setRemarks(remarks);	
			masEmployee.setContractDate(contract);
			masEmployee.setExtensionDate(extension);
			masEmployee.setDepartmentNo(deptNo);
			masEmployee.setAuthorizedForHighValueMedicine(authorizedForHighValueMedicine);
			if (perCountry != 0) {
				MasCountry masCountry = new MasCountry();
				masCountry.setId(perCountry);
				masEmployee.setPerCountry(masCountry);
			}
			
			if (localCountry != 0) {
				MasCountry masCountry = new MasCountry();
				masCountry.setId(localCountry);
				masEmployee.setLocalCountry(masCountry);
			}
			
			if (perState != 0) {
				MasState masState = new MasState();
				masState.setId(perState);
				masEmployee.setPerState(masState);
			}
			if (localState != 0) {
				MasState masState = new MasState();
				masState.setId(localState);
				masEmployee.setLocalState(masState);
			}
			
			
			if (perDistrict != 0) {
				MasDistrict masDistrict = new MasDistrict();
				masDistrict.setId(perDistrict);
				masEmployee.setPerDistrict(masDistrict);
			}
			if (localDistrict != 0) {
				MasDistrict masDistrict = new MasDistrict();
				masDistrict.setId(localDistrict);
				masEmployee.setLocalDistrict(masDistrict);
			}
			if (rankCategoryId != 0) {
				MasRankCategory masRankCategory = new MasRankCategory();
				masRankCategory.setId(rankCategoryId);
				masEmployee.setRankCategory(masRankCategory);
			}
			if (divisionId != 0) {
				MasDivision masDivision = new MasDivision();
				masDivision.setId(divisionId);
				masEmployee.setDivision(masDivision);
			}
			
			if (empType != 0) {
				MasEmployeeType masEmpType = new MasEmployeeType();
				masEmpType.setId(empType);
				masEmployee.setEmployeeType(masEmpType);
			}
			if (titleId != 0) {
				MasTitle masTitle = new MasTitle();
				masTitle.setId(titleId);
				masEmployee.setTitle(masTitle);
			}
			if (titleId != 0) {
				MasTitle masTitle = new MasTitle();
				masTitle.setId(titleId);
				masEmployee.setTitle(masTitle);
			}

			if (departmentId != 0) {
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				masEmployee.setDepartment(masDepartment);
			}
			if (empStatusId != 0) {
				MasEmpStatus masEmpStatus = new MasEmpStatus();
				masEmpStatus.setId(empStatusId);
				masEmployee.setEmployeeStatus(masEmpStatus);
			}

			if (costCenterId != 0) {
				MasCostCenter masCostCenter = new MasCostCenter();
				masCostCenter.setId(costCenterId);
				masEmployee.setCostCenter(masCostCenter);
			}

			if (empCategoryId != 0) {
				MasEmpCategory masEmpCategory = new MasEmpCategory();
				masEmpCategory.setId(empCategoryId);
				masEmployee.setEmpCategory(masEmpCategory);
			}
			if (gradeId != 0) {
				MasGrade masGrade = new MasGrade();
				masGrade.setId(gradeId);
				masEmployee.setGrade(masGrade);
			}

			if (rankId != 0) {
				MasRank masRank = new MasRank();
				masRank.setId(rankId);
				masEmployee.setRank(masRank);
			}
			if (unitId != 0) {
				MasUnit masUnit = new MasUnit();
				masUnit.setId(unitId);
				masEmployee.setUnit(masUnit);
			}
			if (tradeId != 0) {
				MasTrade masTrade = new MasTrade();
				masTrade.setId(tradeId);
				masEmployee.setTrade(masTrade);
			}
			if (request.getParameter(BLOOD_GROUP_ID) != null
					&& Integer.parseInt(request.getParameter(BLOOD_GROUP_ID)) != 0) {
				MasBloodGroup bloodGroup = new MasBloodGroup();
				bloodGroup.setId(Integer.parseInt(request
						.getParameter(BLOOD_GROUP_ID)));
				masEmployee.setBloodGroup(bloodGroup);
			}
			if (request.getParameter("sexId") != null
					&& Integer.parseInt(request.getParameter("sexId")) != 0) {
				MasAdministrativeSex sex = new MasAdministrativeSex();
				sex.setId(Integer.parseInt(request.getParameter("sexId")));
				masEmployee.setGender(sex);
			}
			if (request.getParameter("localAddress") != null) {
				localAddress=request.getParameter("localAddress");
				masEmployee.setLocalAddress(localAddress);
			}
			if (request.getParameter("perAddress") != null) {
				perAddress=request.getParameter("perAddress");
				masEmployee.setPerAddress(perAddress);
			}
			
			if (request.getParameter(AGE) != null) {
				if (request.getParameter(AGE_UNIT) != null) {
					String ageUnit = request.getParameter(AGE_UNIT);
					String age = request.getParameter(AGE).concat(" ")
							.concat(ageUnit);
					masEmployee.setAge(age);
				}
			}
			masEmployee.setJobCode(jobCode);
			masEmployee.setAppointmentDate(appointmentDate);
			masEmployee.setEmail(email);
			masEmployee.setTelNoEmergency(emergencyTellNumber);
			masEmployee.setCellNoEmergency(emergencyCellNumber);
			masEmployee.setTelNoResidence(residenceTellNumber);
			masEmployee.setTelNoOffice(officeTellNumber);
			masEmployee.setBankCode(bankCode);
			masEmployee.setAccountHead(accounthead);
			masEmployee.setJoinDate(joinDate);
			masEmployee.setBankAccountCode(bankAccountCode);

			int personnelId = (Integer) session.getAttribute(HOSPITAL_ID);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(personnelId);
			masEmployee.setHospital(masHospital);

			masEmployee.setStatus("y");
			masEmployee.setLastChgBy(changedBy);
			masEmployee.setLastChgDate(currentDate);
			masEmployee.setLastChgTime(currentTime);

			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			masEmployee.setHospital(hospital);
			String flag="n";	
			if(request.getParameter("flag")!=null){
		      	 flag = (String)request.getParameter("flag");
		       }
		     if(request.getParameter("fileName")!= null && !request.getParameter("fileName").equals("")){
		         filename = request.getParameter("fileName");
		     
		     	 uploadURL = getServletContext().getRealPath("/UploadedDocuments/EMP/");
		     	userMap.put("uploadURL", uploadURL);
		    if(flag.equalsIgnoreCase("y"))
		    {    
		      
		            List fileUploadedList = null;           
		            userMap.put("filename", filename);
		            StringTokenizer strToken=new StringTokenizer(filename,".");
		            Long fileSizeLimit = RequestConstants.MAX_FILE_SIZE;
		            filename=strToken.nextToken();
		            fileExtension=strToken.nextToken();
		            String whiteList = "*."+fileExtension;             
		            fileUploadedList = HMSUtil.uploadFileMaintenance(request,uploadURL, whiteList,fileSizeLimit,filename);
		    }  }  
			/**
			 * Room No for Doctors Added By Ritu on 12 March 2012
			 */
			if (request.getParameter("roomNo") != null
					&& !request.getParameter("roomNo").equals("")) {
				masEmployee.setRoomNo(Integer.parseInt(request
						.getParameter("roomNo")));
			}
			/*
			 * Code for User Creation Code by Mukesh Date 09 May 2012
			 */
			// String[] empGroupIdArray = null;
			String[] appGroupIdArray = null;
			/*
			 * if (request.getParameterValues("empGroupId") != null &&
			 * !(request.getParameterValues("empGroupId").equals(""))) {
			 * empGroupIdArray = (String[]) request
			 * .getParameterValues("empGroupId"); }
			 */

			String[] userDepartmentIdArray = null;
			if (request.getParameterValues("userDepartmentId") != null
					&& !(request.getParameterValues("userDepartmentId")
							.equals(""))) {
				userDepartmentIdArray = (String[]) request
						.getParameterValues("userDepartmentId");
			}
			if (request.getParameterValues("appGroupId") != null
					&& !(request.getParameterValues("appGroupId").equals(""))) {
				appGroupIdArray = (String[]) request
						.getParameterValues("appGroupId");
			}
			// loginRequired
			String loginRequired = "";

			if (request.getParameter("loginRequired") != null
					&& !request.getParameter("loginRequired").equals("")) {
				loginRequired = request.getParameter("loginRequired");
			} else {
				loginRequired = "n";
			}
			
			String password = "";
			if (request.getParameter(RequestConstants.PASSWORD) != null) {
				password = request.getParameter(RequestConstants.PASSWORD);
			}
			Users users = new Users();
			users.setLoginName(serviceNo);
			users.setUserName(serviceNo);
			users.setStatus("y");
			users.setLastChgBy(changedBy);
			users.setLastChgDate(currentDate);
			users.setLastChgTime(currentTime);
			users.setEmailAddress(email);
			/*
			 * MasEmployee masEmployee = new MasEmployee();
			 * masEmployee.setId(employeeId); users.setEmployee(masEmployee);
			 */
			// passwordDecoded = Base64.encode(password.getBytes());
			// users.setPassword(password);
			/*
			 * Changes in password encrypt
			 */

			// users.setPassword(HMSUtil.encryptPassword(password));
			try {
				users.setPassword(EncryptPwd.SHA1(password));
				users.setStatusSHA1("y");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			userMap.put("users", users);
			userMap.put("loginRequired", loginRequired);
			userMap.put("hospitalId", personnelId);
			userMap.put("changedBy", changedBy);
			userMap.put("currentDate", currentDate);
			userMap.put("currentTime", currentTime);
			/*
			 * List<UserEmpGroup> userEmpGroupList=new
			 * ArrayList<UserEmpGroup>(); for (int i = 0; i <
			 * empGroupIdArray.length; i++) { UserEmpGroup userEmpGroup = new
			 * UserEmpGroup(); userEmpGroup.setUser(users); EmpGroups empGroups
			 * = new EmpGroups();
			 * empGroups.setId(Integer.parseInt(empGroupIdArray[i]));
			 * userEmpGroup.setEmpGroup(empGroups); userEmpGroup.setStatus("y");
			 * userEmpGroup.setLastChgBy(changedBy);
			 * userEmpGroup.setLastChgDate(currentDate);
			 * userEmpGroup.setLastChgTime(currentTime);
			 * userEmpGroupList.add(userEmpGroup); //hbt.save(userEmpGroup); }
			 */
			// System.out.println("appGroupIdArray-PMC->"+appGroupIdArray.length);
			// userMap.put("userEmpGroupList", userEmpGroupList);

			/*
			 * Code for Modules Date 06 July 2012
			 */

			int counterMenu = 0;
			if (request.getParameter("counterMenu") != null
					&& !(request.getParameter("counterMenu").equals(""))) {
				counterMenu = Integer.parseInt(""
						+ request.getParameter("counterMenu"));

			}
			int templetCnt = 0;
			if (request.getParameter("templetCnt") != null
					&& !(request.getParameter("templetCnt").equals(""))) {
				templetCnt = Integer.parseInt(""
						+ request.getParameter("templetCnt"));

			}
			// System.out.println(counterMenu+"<--counterMenu-6209---templetCnt--->"+templetCnt);
			List<Integer> templetIdList = new ArrayList<Integer>();
			try {
				if (counterMenu > 0) {
					for (int ct = 1; ct <= counterMenu; ct++) {

						int templetId = 0;
						if (request.getParameter("templetId" + ct) != null) {
							templetId = Integer.parseInt(""
									+ request.getParameter("templetId" + ct));
						}
						if (templetId > 0) {
							templetIdList.add(templetId);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			userMap.put("templetIdList", templetIdList);
			/*
			 * End of Code for Modules Date 06 July 2012
			 */
			userMap.put("userDepartmentIdArray", userDepartmentIdArray);

			userMap.put("appGroupIdArray", appGroupIdArray);
			//userMap.put("departmentId", departmentId);

			successfullyAdded = personnelMasterHandlerService.addEmployee(
					masEmployee, userMap);
			if (successfullyAdded == true) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if (employeeNameList.size() != 0) {
			message = "Employee Code already exists.";

		}

		// System.out.println("message        "+message);
		url = "/hms/hms/personnel?method=showEmployeeJsp";
		try {
			int hospitalId1 = 0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId1 = (Integer) session.getAttribute("hospitalId");
			}
			map = personnelMasterHandlerService.showEmployeeJsp(hospitalId1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = EMPLOYEE_JSP;
		title = "Add Employee";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteEmployee1(HttpServletRequest hrequest,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		String[] departmentIdArray = null;
		StringBuffer departmentStr = new StringBuffer();
		String employeeCode = "";
		String firstName = "";
		String middleName = "";
		String lastName = "";
		int departmentId = 0;
		int divisionId=0;
		int costCenterId = 0;
		int empStatusId = 0;
		int empCategoryId = 0;
		int personnelId = 0;
		int gradeId = 0;
		int rankId = 0;
		int unitId = 0;
		int tradeId = 0;
		String serviceNo = "";
		String remarks="";
		Date contract=new Date();
		Date extension=new Date();
		
		String emergencyTellNumber = "";
		String emergencyCellNumber = "";
		String residenceTellNumber = "";
		String officeTellNumber = "";
		//String designation = "";
		Date appointmentDate = new Date();
		String jobCode = "";
		String changedBy = "";
		String email = "";
		String bankCode = "";
		String employeePhoto = "";
		String employeeUrl = "";
		String accountHead = "";
		int titleId = 0;
		String bankAccountCode = "";
		String grade = "";
		Date joinDate = new Date();
		Date changedDate = new Date();
		@SuppressWarnings("unused")
		String changedTime = "";
		int employeeId = 0;
		int bloodGroupId = 0;
		String bankAccountNumber = "";
		int sexId = 0;
		int localCountry = 0;
		int localState = 0;
		int localDistrict = 0;
		int perCountry = 0;
		int perState = 0;
		int perDistrict = 0;	
		Date halJoiningDate = null;
		Date currDivisionJoiningDate = null;
		Date dob= null;
		int rankCategoryId=0;
		session = hrequest.getSession();
		MultipartFormDataRequest request = null;
	     if (MultipartFormDataRequest.isMultipartFormData(hrequest))
	        {
	             try
	             {
	                 request = new MultipartFormDataRequest(hrequest);
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
	     String filename = "";
	     String uploadURL="";
	     String comments = "";
	     String fileExtension=null;
	     if(request.getParameter("fileName")!= null && !request.getParameter("fileName").equals("")){
	         filename = request.getParameter("fileName");
	     }
	     	 uploadURL = getServletContext().getRealPath("/UploadedDocuments/EMP/");
	     	generalMap.put("uploadURL", uploadURL);
	     	
	     	
	    	
		
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		if (request.getParameter("currDivisionJoiningDate") != null
				&& !request.getParameter("currDivisionJoiningDate").equals("")) {
			currDivisionJoiningDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter("currDivisionJoiningDate"));
			
		}
		if (request.getParameter("halJoiningDate") != null
				&& !request.getParameter("halJoiningDate").equals("")) {
			halJoiningDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter("halJoiningDate"));
			
		}
		if (request.getParameter("dob") != null
				&& !request.getParameter("dob").equals("")) {
			dob = HMSUtil.dateFormatterDDMMYYYY(request.getParameter("dob"));
			
		}
		if (request.getParameter("contract") != null
				&& !request.getParameter("contract").equals("")) {
			contract =HMSUtil.dateFormatterDDMMYYYY(request.getParameter("contract"));
			
		}
		if (request.getParameter("extension") != null
				&& !request.getParameter("extension").equals("")) {
			extension =HMSUtil.dateFormatterDDMMYYYY(request.getParameter("extension"));
			
		}
		
		if (request.getParameter("remarks") != null) {
			remarks = request.getParameter("remarks");
		}		
		
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			employeeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(EMPLOYEE_CODE) != null
				&& !(request.getParameter(EMPLOYEE_CODE).equals(""))) {
			employeeCode = request.getParameter(EMPLOYEE_CODE);
		}
		if (request.getParameter("divisionId") != null
				&& !request.getParameter("divisionId").equals("0")) {
			divisionId = Integer.parseInt(request.getParameter("divisionId"));
		}
		if (request.getParameter("rankCategoryId") != null
				&& !request.getParameter("rankCategoryId").equals("")) {
			rankCategoryId = Integer.parseInt(request.getParameter("rankCategoryId"));
		}
		  String aadharCard="";
		  if (request.getParameter("aadharCard") != null) {
				aadharCard = request.getParameter("aadharCard");
			}

			String authorizedForHighValueMedicine="";
			if (request.getParameter(HIGH_VALUE_DRUG) != null) {
				authorizedForHighValueMedicine = request.getParameter(HIGH_VALUE_DRUG);
			}
			else{
				authorizedForHighValueMedicine="n";
			}
		  
		  
		  if(!request.getParameter("perState").equals("0") && request.getParameter("perState") != null) { 
			  perState =  Integer.parseInt(request.getParameter("perState")); 
			  }
		  if(!request.getParameter("localState").equals("0") && request.getParameter("localState") != null) { 
			  localState =  Integer.parseInt(request.getParameter("localState")); 
			  }
		  

		  if(!request.getParameter("localDistrict").equals("0") && request.getParameter("localDistrict") != null) { 
			  localDistrict =  Integer.parseInt(request.getParameter("localDistrict")); 
			  }
		  if(!request.getParameter("perDistrict").equals("0") && request.getParameter("perDistrict") != null) { 
			  perDistrict =  Integer.parseInt(request.getParameter("perDistrict")); 
			  }

		  if(!request.getParameter("localCountry").equals("0") && request.getParameter("localCountry") != null) { 
			  localCountry =  Integer.parseInt(request.getParameter("localCountry")); 
			  }
		  if(!request.getParameter("perCountry").equals("0") && request.getParameter("perCountry") != null) { 
			  perCountry =  Integer.parseInt(request.getParameter("perCountry")); 
			  }
/*		if (request.getParameterValues(DEPARTMENT_ID) != null
				&& request.getParameterValues(DEPARTMENT_ID).length > 0) {
			departmentIdArray = (String[]) (request
					.getParameterValues(DEPARTMENT_ID));

			for (int i = 0; i < departmentIdArray.length; i++) {
				departmentStr.append(departmentIdArray[i]);
				departmentStr.append(",");
			}
			
			departmentStr.deleteCharAt(departmentStr.length() - 1);
		}*/
		String localAddress="";
		if (request.getParameter("localAddress") != null) {
			localAddress=request.getParameter("localAddress");
		}
		String perAddress="";
		if (request.getParameter("perAddress") != null) {
			perAddress=request.getParameter("perAddress");
		}
		
		//generalMap.put("departmentStr", departmentStr.toString());
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (!request.getParameter(TITLE_ID).equals("0")) {
			titleId = Integer.parseInt(request.getParameter(TITLE_ID));
		}
		if (request.getParameter(EMPLOYEE_JOB_CODE) != null) {
			jobCode = request.getParameter(EMPLOYEE_JOB_CODE);
		}
		if (request.getParameter(BANK_ACCOUNT_NUMBER) != null) {
			bankAccountNumber = request.getParameter(BANK_ACCOUNT_NUMBER);
		}
		if (request.getParameter(EMPLOYEE_GRADE) != null) {
			grade = request.getParameter(EMPLOYEE_GRADE);
		}
		if (request.getParameter(BANK_ACCOUNT_CODE) != null) {
			bankAccountCode = request.getParameter(BANK_ACCOUNT_CODE);
		}
		if (request.getParameter(ACCOUNT_HEAD) != null) {
			accountHead = request.getParameter(ACCOUNT_HEAD);
		}
		if (request.getParameter(BANK_CODE) != null) {
			bankCode = request.getParameter(BANK_CODE);
		}
		if (request.getParameter(EMERGENCY_PHONE) != null) {
			emergencyTellNumber = request.getParameter(EMERGENCY_PHONE);
		}
		if (request.getParameter(EMERGENCY_MOBILE) != null) {
			emergencyCellNumber = request.getParameter(EMERGENCY_MOBILE);
		}
		if (request.getParameter(TELL_NO_RESIDENCE) != null) {
			residenceTellNumber = request.getParameter(TELL_NO_RESIDENCE);
		}
		if (request.getParameter(TELL_NO_OFFICE) != null) {
			officeTellNumber = request.getParameter(TELL_NO_OFFICE);
		}
		if (request.getParameter(EMAIL) != null) {
			email = request.getParameter(EMAIL);
		}
		try {
			if (request.getParameter(APPOINTMENT_DATE) != null
					&& !(request.getParameter(APPOINTMENT_DATE)).equals("")) {
				appointmentDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(APPOINTMENT_DATE));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (request.getParameter(JOIN_DATE) != null
					&& !(request.getParameter(JOIN_DATE)).equals("")) {
				joinDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(JOIN_DATE));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if (!request.getParameter(EMPLOYEE_CATEGORY_ID).equals("0")) {
			empCategoryId = Integer.parseInt(request
					.getParameter(EMPLOYEE_CATEGORY_ID));
		}
		if (request.getParameter(DEPARTMENT_ID) != null
				&& !request.getParameter(DEPARTMENT_ID).equals("0")
				&& !request.getParameter(DEPARTMENT_ID).equals("")) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(COST_CENTER_ID) != null
				&& !request.getParameter(COST_CENTER_ID).equals("0")
				&& !request.getParameter(COST_CENTER_ID).equals("")) {
			costCenterId = Integer.parseInt(request
					.getParameter(COST_CENTER_ID));
		}
		if (request.getParameter(EMPLOYEE_GRADE_ID) != null
				&& !request.getParameter(EMPLOYEE_GRADE_ID).equals("0")
				&& !request.getParameter(EMPLOYEE_GRADE_ID).equals("")) {
			gradeId = Integer.parseInt(request.getParameter(EMPLOYEE_GRADE_ID));
		}
		if (request.getParameter(RANK_ID) != null
				&& !request.getParameter(RANK_ID).equals("0")
				&& !request.getParameter(RANK_ID).equals("")) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
		}
		/*if (request.getParameter(DESIGNATION_ID) != null) {
			designation = (String) request.getParameter(DESIGNATION_ID);
		}*/

	/*	if (!request.getParameter(UNIT_ID).equals("0")) {
			unitId = Integer.parseInt(request.getParameter(UNIT_ID));
		}*/
		if (request.getParameter(TRADE_ID) != null
				&& !request.getParameter(TRADE_ID).equals("0")
				&& !request.getParameter(TRADE_ID).equals("")) {
			tradeId = Integer.parseInt(request.getParameter(TRADE_ID));
		}
		if (request.getParameter(BLOOD_GROUP_ID) != null
				&& Integer.parseInt(request.getParameter(BLOOD_GROUP_ID)) != 0
				&& !request.getParameter(BLOOD_GROUP_ID).equals("")) {
			bloodGroupId = Integer.parseInt(request
					.getParameter(BLOOD_GROUP_ID));
		}
		if (request.getParameter("sexId") != null
				&& Integer.parseInt(request.getParameter("sexId")) != 0) {
			sexId = Integer.parseInt(request.getParameter("sexId"));
		}
		System.out.println(sexId);
		if (request.getParameter(FIRST_NAME) != null) {
			firstName = request.getParameter(FIRST_NAME);
		}
		if (request.getParameter(MIDDLE_NAME) != null) {
			middleName = request.getParameter(MIDDLE_NAME);
		}
		if (request.getParameter(LAST_NAME) != null) {
			lastName = request.getParameter(LAST_NAME);
		}
		if (request.getParameter(EMP_STATUS_ID) != null
				&& !request.getParameter(EMP_STATUS_ID).equals("0")
				&& !request.getParameter(EMP_STATUS_ID).equals("")) {
			empStatusId = Integer.parseInt(request.getParameter(EMP_STATUS_ID));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(EMPLOYEE_PHOTO) != null) {
			employeePhoto = request.getParameter(EMPLOYEE_PHOTO);
		}
		if (request.getParameter(URL) != null) {
			employeeUrl = request.getParameter(URL);
		}
		if (request.getParameter("localAddress") != null) {
			generalMap
					.put("localAddress", request.getParameter("localAddress"));
		}
		if (request.getParameter("roomNo") != null
				&& !(request.getParameter("roomNo").equals(""))) {
			generalMap.put("roomNo",
					Integer.parseInt(request.getParameter("roomNo")));
		}
		String age = "";
		if (request.getParameter(AGE) != null) {
			if (request.getParameter(AGE_UNIT) != null) {
				String ageUnit = request.getParameter(AGE_UNIT);
				age = request.getParameter(AGE).concat(" ").concat(ageUnit);
			}
		}
		
		/*String flag="n";	
		if(request.getParameter("flag")!=null){
	      	 flag = (String)request.getParameter("flag");
	       }
	    if(flag.equalsIgnoreCase("y"))
	    {    
	      
	            List fileUploadedList = null;           
	            generalMap.put("filename", filename);
	            StringTokenizer strToken=new StringTokenizer(filename,".");
	            Long fileSizeLimit = RequestConstants.MAX_FILE_SIZE;
	            filename=strToken.nextToken();
	            fileExtension=strToken.nextToken();
	            String whiteList = "*."+fileExtension;             
	            fileUploadedList = HMSUtil.uploadFileMaintenance(request,uploadURL, whiteList,fileSizeLimit,filename);
	    }  
	    */
		personnelId = (Integer) session.getAttribute(HOSPITAL_ID);

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", employeeId);
		generalMap.put("personnelId", personnelId);
		generalMap.put("titleId", titleId);
		generalMap.put("employeeCode", employeeCode);
		generalMap.put("serviceNo", serviceNo);
		generalMap.put("firstName", firstName);
		generalMap.put("middleName", middleName);
		generalMap.put("personnelId", personnelId);
		generalMap.put("lastName", lastName);
		generalMap.put("jobCode", jobCode);
		generalMap.put("bankCode", bankCode);
		generalMap.put("employeePhoto", employeePhoto);
		generalMap.put("employeeUrl", employeeUrl);
		generalMap.put("divisionId", divisionId);
		generalMap.put("localCountry", localCountry);
		generalMap.put("localDistrict", localDistrict);
		generalMap.put("localState", localState);
		generalMap.put("perCountry", perCountry);
		generalMap.put("perDistrict", perDistrict);
		generalMap.put("rankCategoryId", rankCategoryId);
		generalMap.put("remarks", remarks);
		generalMap.put("contract", contract);
		generalMap.put("extension", extension);
		generalMap.put("perState", perState);
		generalMap.put("currDivisionJoiningDate", currDivisionJoiningDate);
		generalMap.put("halJoiningDate", halJoiningDate);
		generalMap.put("dob", dob);
		generalMap.put("aadharCard", aadharCard);
		generalMap.put("emergencyTellNumber", emergencyTellNumber);
		generalMap.put("emergencyCellNumber", emergencyCellNumber);
		generalMap.put("residenceTellNumber", residenceTellNumber);
		generalMap.put("officeTellNumber", officeTellNumber);
		generalMap.put("email", email);
		generalMap.put("accountHead", accountHead);
		generalMap.put("appointmentDate", appointmentDate);
		generalMap.put("joinDate", joinDate);
		generalMap.put("gradeId", gradeId);
		generalMap.put("empCategoryId", empCategoryId);
		generalMap.put("tradeId", tradeId);
		generalMap.put("rankId", rankId);
		//generalMap.put("designation", designation);
		generalMap.put("unitId", unitId);
		generalMap.put("departmentId", departmentId);
		generalMap.put("empStatusId", empStatusId);
		generalMap.put("costCenterId", costCenterId);
		generalMap.put("grade", grade);
		generalMap.put("empStatusId", empStatusId);
		generalMap.put("bloodGroupId", bloodGroupId);
		generalMap.put("sexId", sexId);
		generalMap.put("age", age);
		generalMap.put("bankAccountNumber", bankAccountNumber);
		generalMap.put("bankAccountCode", bankAccountCode);
		
		 changedBy = (String)session.getAttribute("empName");
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("localAddress", localAddress);
		generalMap.put("perAddress", perAddress);
		generalMap.put("authorizedForHighValueMedicine",authorizedForHighValueMedicine);
		boolean dataUpdated = false;
		dataUpdated = personnelMasterHandlerService.deleteEmployee(employeeId, generalMap);
		if (dataUpdated == true) {
			message = "Record InActivated Successfully !!";
		} else {
			message = "Record Activated Be Updated !!";
		}
		url = "/hms/hms/personnel?method=showEmployeeJsp";
		try {
			map = personnelMasterHandlerService.showEmployeeJsp(personnelId);

		} catch (Exception e) {
			// System.out.println("Exception in showEmployeeJsp "+e);
		}
		jsp = EMPLOYEE_JSP;
		title = "update Employee";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView editEmployee(HttpServletRequest hrequest,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		String[] departmentIdArray = null;
		StringBuffer departmentStr = new StringBuffer();
		String employeeCode = "";
		String firstName = "";
		String middleName = "";
		String lastName = "";
		int departmentId = 0;
		int divisionId=0;
		int costCenterId = 0;
		int empStatusId = 0;
		int empCategoryId = 0;
		int personnelId = 0;
		int gradeId = 0;
		int rankId = 0;
		int unitId = 0;
		int tradeId = 0;
		String serviceNo = "";
		String emergencyTellNumber = "";
		String emergencyCellNumber = "";
		String residenceTellNumber = "";
		String officeTellNumber = "";
		//String designation = "";
		Date appointmentDate = new Date();
		String jobCode = "";
		String changedBy = "";
		String email = "";
		String bankCode = "";
		String employeePhoto = "";
		String employeeUrl = "";
		String accountHead = "";
		int titleId = 0;
		String bankAccountCode = "";
		String grade = "";
		Date joinDate = new Date();
		Date changedDate = new Date();
		@SuppressWarnings("unused")
		String changedTime = "";
		int employeeId = 0;
		int bloodGroupId = 0;
		String bankAccountNumber = "";
		int sexId = 0;
		int localCountry = 0;
		int localState = 0;
		int localDistrict = 0;
		int perCountry = 0;
		int perState = 0;
		int perDistrict = 0;
		int empTypeId = 0;	
		Date halJoiningDate = null;
		Date currDivisionJoiningDate = null;
		Date dob= null;
	int rankCategoryId=0;
	String remarks="";
	Date contract=new Date();
	Date extension=new Date();
	
		MultipartFormDataRequest request = null;
	     if (MultipartFormDataRequest.isMultipartFormData(hrequest))
	        {
	             try
	             {
	                 request = new MultipartFormDataRequest(hrequest);
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
	     String filename = "";
	     String uploadURL="";
	     String comments = "";
	     String fileExtension=null;
	   
	     	
	    	session = hrequest.getSession();
		
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		if (request.getParameter("currDivisionJoiningDate") != null
				&& !request.getParameter("currDivisionJoiningDate").equals("")) {
			currDivisionJoiningDate =HMSUtil.dateFormatterDDMMYYYY(request.getParameter("currDivisionJoiningDate"));
			
		}
		if (request.getParameter("halJoiningDate") != null
				&& !request.getParameter("halJoiningDate").equals("")) {
			halJoiningDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter("halJoiningDate"));
			
		}
		if (request.getParameter("dob") != null
				&& !request.getParameter("dob").equals("")) {
			dob = HMSUtil.dateFormatterDDMMYYYY(request.getParameter("dob"));
			
		}
		
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			employeeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(EMPLOYEE_CODE) != null
				&& !(request.getParameter(EMPLOYEE_CODE).equals(""))) {
			employeeCode = request.getParameter(EMPLOYEE_CODE);
		}
		if (request.getParameter("divisionId") != null
				&& !request.getParameter("divisionId").equals("0")) {
			divisionId = Integer.parseInt(request.getParameter("divisionId"));
		}
		 
		  String aadharCard="";
		  if (request.getParameter("aadharCard") != null) {
				aadharCard = request.getParameter("aadharCard");
			}

		  if (request.getParameter("contract") != null
					&& !request.getParameter("contract").equals("")) {
				contract =HMSUtil.dateFormatterDDMMYYYY(request.getParameter("contract"));
				
			}
			if (request.getParameter("extension") != null
					&& !request.getParameter("extension").equals("")) {
				extension =HMSUtil.dateFormatterDDMMYYYY(request.getParameter("extension"));
				
			}
			if (request.getParameter("remarks") != null) {
				remarks = request.getParameter("remarks");
			}
		  String authorizedForHighValueMedicine="";
			if (request.getParameter(HIGH_VALUE_DRUG) != null) {
				authorizedForHighValueMedicine = request.getParameter(HIGH_VALUE_DRUG);
			}
			else{
				authorizedForHighValueMedicine="n";
			}
		  
		  if(!request.getParameter("perState").equals("0") && request.getParameter("perState") != null) { 
			  perState =  Integer.parseInt(request.getParameter("perState")); 
			  }
		  if(!request.getParameter("localState").equals("0") && request.getParameter("localState") != null) { 
			  localState =  Integer.parseInt(request.getParameter("localState")); 
			  }
		  

		  if(!request.getParameter("localDistrict").equals("0") && request.getParameter("localDistrict") != null) { 
			  localDistrict =  Integer.parseInt(request.getParameter("localDistrict")); 
			  }
		  if(!request.getParameter("perDistrict").equals("0") && request.getParameter("perDistrict") != null) { 
			  perDistrict =  Integer.parseInt(request.getParameter("perDistrict")); 
			  }

		  if(!request.getParameter("localCountry").equals("0") && request.getParameter("localCountry") != null) { 
			  localCountry =  Integer.parseInt(request.getParameter("localCountry")); 
			  }
		  if(!request.getParameter("perCountry").equals("0") && request.getParameter("perCountry") != null) { 
			  perCountry =  Integer.parseInt(request.getParameter("perCountry")); 
			  }
		/*if (request.getParameterValues(DEPARTMENT_ID) != null
				&& request.getParameterValues(DEPARTMENT_ID).length > 0) {
			departmentIdArray = (String[]) (request
					.getParameterValues(DEPARTMENT_ID));

			for (int i = 0; i < departmentIdArray.length; i++) {
				departmentStr.append(departmentIdArray[i]);
				departmentStr.append(",");
			}
			
			departmentStr.deleteCharAt(departmentStr.length() - 1);
		}*/
		String localAddress="";
		if (request.getParameter("localAddress") != null) {
			localAddress=request.getParameter("localAddress");
		}
		String perAddress="";
		if (request.getParameter("perAddress") != null) {
			perAddress=request.getParameter("perAddress");
		}
		
	//	generalMap.put("departmentStr", departmentStr.toString());
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (!request.getParameter(TITLE_ID).equals("0")) {
			titleId = Integer.parseInt(request.getParameter(TITLE_ID));
		}
		if (request.getParameter(EMPLOYEE_JOB_CODE) != null) {
			jobCode = request.getParameter(EMPLOYEE_JOB_CODE);
		}
		if (request.getParameter(BANK_ACCOUNT_NUMBER) != null) {
			bankAccountNumber = request.getParameter(BANK_ACCOUNT_NUMBER);
		}
		if (request.getParameter(EMPLOYEE_GRADE) != null) {
			grade = request.getParameter(EMPLOYEE_GRADE);
		}
		if (request.getParameter(BANK_ACCOUNT_CODE) != null) {
			bankAccountCode = request.getParameter(BANK_ACCOUNT_CODE);
		}
		if (request.getParameter(ACCOUNT_HEAD) != null) {
			accountHead = request.getParameter(ACCOUNT_HEAD);
		}
		if (request.getParameter(BANK_CODE) != null) {
			bankCode = request.getParameter(BANK_CODE);
		}
		if (request.getParameter(EMERGENCY_PHONE) != null) {
			emergencyTellNumber = request.getParameter(EMERGENCY_PHONE);
		}
		if (request.getParameter(EMERGENCY_MOBILE) != null) {
			emergencyCellNumber = request.getParameter(EMERGENCY_MOBILE);
		}
		if (request.getParameter(TELL_NO_RESIDENCE) != null) {
			residenceTellNumber = request.getParameter(TELL_NO_RESIDENCE);
		}
		if (request.getParameter(TELL_NO_OFFICE) != null) {
			officeTellNumber = request.getParameter(TELL_NO_OFFICE);
		}
		if (request.getParameter(EMAIL) != null) {
			email = request.getParameter(EMAIL);
		}
		try {
			if (request.getParameter(APPOINTMENT_DATE) != null
					&& !(request.getParameter(APPOINTMENT_DATE)).equals("")) {
				appointmentDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(APPOINTMENT_DATE));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (request.getParameter(JOIN_DATE) != null
					&& !(request.getParameter(JOIN_DATE)).equals("")) {
				joinDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(JOIN_DATE));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if (!request.getParameter(EMPLOYEE_CATEGORY_ID).equals("0")) {
			empCategoryId = Integer.parseInt(request
					.getParameter(EMPLOYEE_CATEGORY_ID));
		}
		if (request.getParameter(DEPARTMENT_ID) != null
				&& !request.getParameter(DEPARTMENT_ID).equals("0")
				&& !request.getParameter(DEPARTMENT_ID).equals("")) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(COST_CENTER_ID) != null
				&& !request.getParameter(COST_CENTER_ID).equals("0")
				&& !request.getParameter(COST_CENTER_ID).equals("")) {
			costCenterId = Integer.parseInt(request
					.getParameter(COST_CENTER_ID));
		}
		if (request.getParameter(EMPLOYEE_GRADE_ID) != null
				&& !request.getParameter(EMPLOYEE_GRADE_ID).equals("0")
				&& !request.getParameter(EMPLOYEE_GRADE_ID).equals("")) {
			gradeId = Integer.parseInt(request.getParameter(EMPLOYEE_GRADE_ID));
		}
		if (request.getParameter(RANK_ID) != null
				&& !request.getParameter(RANK_ID).equals("0")
				&& !request.getParameter(RANK_ID).equals("")) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
		}
		
		if (request.getParameter(RANK_CATEGORY_ID) != null) {
			rankCategoryId = Integer.parseInt(request
					.getParameter(RANK_CATEGORY_ID));
		}
		/*if (request.getParameter(DESIGNATION_ID) != null) {
			designation = (String) request.getParameter(DESIGNATION_ID);
		}*/

	/*	if (!request.getParameter(UNIT_ID).equals("0")) {
			unitId = Integer.parseInt(request.getParameter(UNIT_ID));
		}*/
		if (request.getParameter(TRADE_ID) != null
				&& !request.getParameter(TRADE_ID).equals("0")
				&& !request.getParameter(TRADE_ID).equals("")) {
			tradeId = Integer.parseInt(request.getParameter(TRADE_ID));
		}
		if (request.getParameter(BLOOD_GROUP_ID) != null
				&& Integer.parseInt(request.getParameter(BLOOD_GROUP_ID)) != 0
				&& !request.getParameter(BLOOD_GROUP_ID).equals("")) {
			bloodGroupId = Integer.parseInt(request
					.getParameter(BLOOD_GROUP_ID));
		}
		if (request.getParameter("sexId") != null
				&& Integer.parseInt(request.getParameter("sexId")) != 0) {
			sexId = Integer.parseInt(request.getParameter("sexId"));
		}
		System.out.println(sexId);
		if (request.getParameter(FIRST_NAME) != null) {
			firstName = request.getParameter(FIRST_NAME);
		}
		if (request.getParameter(MIDDLE_NAME) != null) {
			middleName = request.getParameter(MIDDLE_NAME);
		}
		if (request.getParameter(LAST_NAME) != null) {
			lastName = request.getParameter(LAST_NAME);
		}
		if (request.getParameter(EMP_STATUS_ID) != null
				&& !request.getParameter(EMP_STATUS_ID).equals("0")
				&& !request.getParameter(EMP_STATUS_ID).equals("")) {
			empStatusId = Integer.parseInt(request.getParameter(EMP_STATUS_ID));
		}
		if (request.getParameter("empType") != null
				&& !request.getParameter("empType").equals("0")
				&& !request.getParameter("empType").equals("")) {
			empTypeId = Integer.parseInt(request.getParameter("empType"));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(EMPLOYEE_PHOTO) != null) {
			employeePhoto = request.getParameter(EMPLOYEE_PHOTO);
		}
		if (request.getParameter(URL) != null) {
			employeeUrl = request.getParameter(URL);
		}
		if (request.getParameter("localAddress") != null) {
			generalMap
					.put("localAddress", request.getParameter("localAddress"));
		}
		if (request.getParameter("roomNo") != null
				&& !(request.getParameter("roomNo").equals(""))) {
			generalMap.put("roomNo",
					Integer.parseInt(request.getParameter("roomNo")));
		}
		String age = "";
		if (request.getParameter(AGE) != null) {
			if (request.getParameter(AGE_UNIT) != null) {
				String ageUnit = request.getParameter(AGE_UNIT);
				age = request.getParameter(AGE).concat(" ").concat(ageUnit);
			}
		}
		
		
		if (request.getParameter("deptNo") != null && !request.getParameter("deptNo").trim().equals("")) {
			
			
			generalMap.put("deptNo", request.getParameter("deptNo"));
			
		}
		
		String flag="n";	
		if(request.getParameter("fileName")!= null && !request.getParameter("fileName").equals("")){
		         filename = request.getParameter("fileName");
		     
		if(request.getParameter("flag")!=null){
	      	 flag = (String)request.getParameter("flag");
	       }
		
		     	 uploadURL = getServletContext().getRealPath("/UploadedDocuments/EMP/");
		     	
		     	
	    if(flag.equalsIgnoreCase("y"))
	    {    
	      
	            List fileUploadedList = null;           
	            generalMap.put("filename", filename);
	            StringTokenizer strToken=new StringTokenizer(filename,".");
	            Long fileSizeLimit = RequestConstants.MAX_FILE_SIZE;
	            filename=strToken.nextToken();
	            fileExtension=strToken.nextToken();
	            String whiteList = "*."+fileExtension;             
	            fileUploadedList = HMSUtil.uploadFileMaintenance(request,uploadURL, whiteList,fileSizeLimit,filename);
	    }  
		  }
		 generalMap.put("uploadURL", uploadURL);
		personnelId = (Integer) session.getAttribute(HOSPITAL_ID);

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		
		
		if (request.getParameter("pf_no") != null && !request.getParameter("pf_no").trim().equals("")) {
			
			
			generalMap.put("pf_no", request.getParameter("pf_no"));
			
		}
		if (request.getParameter("pan_no") != null && !request.getParameter("pan_no").trim().equals("")) {
			
			
			generalMap.put("pan_no", request.getParameter("pan_no"));
			
		}
		if (request.getParameter("account_no") != null && !request.getParameter("account_no").trim().equals("")) {
			
			
			generalMap.put("account_no", request.getParameter("account_no"));
			
		}
		if (request.getParameter("bank_name") != null && !request.getParameter("bank_name").trim().equals("")) {
			
			
			generalMap.put("bank_name", request.getParameter("bank_name"));
			
		}
		
		
		
		
		generalMap.put("id", employeeId);
		
		generalMap.put("personnelId", personnelId);
		generalMap.put("empTypeId", empTypeId);
		generalMap.put("titleId", titleId);
		generalMap.put("employeeCode", employeeCode);
		generalMap.put("serviceNo", serviceNo);
		generalMap.put("firstName", firstName);
		generalMap.put("middleName", middleName);
		generalMap.put("personnelId", personnelId);
		generalMap.put("lastName", lastName);
		generalMap.put("jobCode", jobCode);
		generalMap.put("bankCode", bankCode);
		generalMap.put("employeePhoto", employeePhoto);
		generalMap.put("employeeUrl", employeeUrl);
		generalMap.put("divisionId", divisionId);
		generalMap.put("localCountry", localCountry);
		generalMap.put("localDistrict", localDistrict);
		generalMap.put("localState", localState);
		generalMap.put("perCountry", perCountry);
		generalMap.put("perDistrict", perDistrict);
		generalMap.put("perState", perState);
		generalMap.put("currDivisionJoiningDate", currDivisionJoiningDate);
		generalMap.put("halJoiningDate", halJoiningDate);
		generalMap.put("dob", dob);
		generalMap.put("aadharCard", aadharCard);
		generalMap.put("remarks", remarks);
		generalMap.put("contract", contract);
		generalMap.put("extension", extension);
		generalMap.put("emergencyTellNumber", emergencyTellNumber);
		generalMap.put("emergencyCellNumber", emergencyCellNumber);
		generalMap.put("residenceTellNumber", residenceTellNumber);
		generalMap.put("officeTellNumber", officeTellNumber);
		generalMap.put("email", email);
		generalMap.put("accountHead", accountHead);
		generalMap.put("appointmentDate", appointmentDate);
		generalMap.put("joinDate", joinDate);
		generalMap.put("gradeId", gradeId);
		generalMap.put("empCategoryId", empCategoryId);
		generalMap.put("tradeId", tradeId);
		generalMap.put("rankId", rankId);
		//generalMap.put("designation", designation);
		generalMap.put("unitId", unitId);
		generalMap.put("departmentId", departmentId);
		generalMap.put("empStatusId", empStatusId);
		generalMap.put("costCenterId", costCenterId);
		generalMap.put("grade", grade);
		generalMap.put("empStatusId", empStatusId);
		generalMap.put("bloodGroupId", bloodGroupId);
		generalMap.put("sexId", sexId);
		generalMap.put("age", age);
		generalMap.put("bankAccountNumber", bankAccountNumber);
		generalMap.put("bankAccountCode", bankAccountCode);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("localAddress", localAddress);
		generalMap.put("perAddress", perAddress);
		generalMap.put("rankCategoryId", rankCategoryId);
		generalMap.put("authorizedForHighValueMedicine",authorizedForHighValueMedicine);
		boolean dataUpdated = false;
		dataUpdated = personnelMasterHandlerService
				.editEmployeeToDatabase(generalMap);
		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Record Cant Be Updated !!";
		}
		url = "/hms/hms/personnel?method=showEmployeeJsp";
		try {
			map = personnelMasterHandlerService.showEmployeeJsp(personnelId);

		} catch (Exception e) {
			// System.out.println("Exception in showEmployeeJsp "+e);
		}
		jsp = EMPLOYEE_JSP;
		title = "update Employee";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteEmployee(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int employeeId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			employeeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		System.out.println("employeeId---in controller---"+employeeId);
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
		generalMap.put("employeeId", employeeId);
		boolean dataDeleted = false;
		dataDeleted = personnelMasterHandlerService.deleteEmployee(employeeId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showEmployeeJsp";
		try {
			map = personnelMasterHandlerService.showEmployeeJsp(hospitalId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = EMPLOYEE_JSP;
		title = "Delete Employee";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// -------------------------------------- Referral
	// Doctor--------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showReferralDoctorJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = personnelMasterHandlerService.showReferralDoctorJsp();
		@SuppressWarnings("unused")
		ArrayList searchReferralDoctorList = (ArrayList) map
				.get("searchReferralDoctorList");
		jsp = REFERRAL_DOCTOR_JSP;
		jsp += ".jsp";
		title = "ReferralDoctor";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addReferralDoctor(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasReferralDoctor masReferralDoctor = new MasReferralDoctor();
		int departmentId = 0;
		String changedBy = "";
		String address1 = "";
		String address2 = "";
		String phoneNo = "";
		String mobileNo = "";
		int referralType = 0;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer.valueOf(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(ADDRESS_1) != null) {
			address1 = request.getParameter(ADDRESS_1);
		}
		if (request.getParameter(ADDRESS_2) != null) {
			address2 = request.getParameter(ADDRESS_2);
		}
		if (request.getParameter(PHONE) != null) {
			phoneNo = request.getParameter(PHONE);
		}
		if (request.getParameter(MOBILE) != null) {
			mobileNo = request.getParameter(MOBILE);
		}
		if (request.getParameter(REFERRAL_TYPE) != null) {
			referralType = Integer.valueOf(request.getParameter(REFERRAL_TYPE));
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
		int hospitalId = 0;
		if (request.getParameter(HOSPITAL_ID) != null
				&& !(request.getParameter(HOSPITAL_ID).equals(""))) {
			hospitalId = Integer.parseInt(request.getParameter(HOSPITAL_ID));
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
		generalMap.put("name", name);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List referralDoctorNameList = new ArrayList();

		if (listMap.get("duplicateGeneralNameList") != null) {
			referralDoctorNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((referralDoctorNameList.size() == 0 || referralDoctorNameList == null)) {
			masReferralDoctor.setDoctorName(name);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			masReferralDoctor.setDepartment(masDepartment);

			masReferralDoctor.setAddress1(address1);
			masReferralDoctor.setAddress2(address2);
			masReferralDoctor.setPhoneNo(phoneNo);
			masReferralDoctor.setMobileNo(mobileNo);
			masReferralDoctor.setReferralType(referralType);
			masReferralDoctor.setStatus("y");
			masReferralDoctor.setLastChgBy(changedBy);
			masReferralDoctor.setLastChgDate(currentDate);
			masReferralDoctor.setLastChgTime(currentTime);

			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			masReferralDoctor.setHospital(hospital);

			successfullyAdded = personnelMasterHandlerService
					.addReferralDoctor(masReferralDoctor);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((referralDoctorNameList.size() != 0)
				|| referralDoctorNameList != null) {

			if ((referralDoctorNameList.size() != 0 || referralDoctorNameList != null)) {
				message = "Referral Doctor Name  already exists.";
			}
		}
		url = "/hms/hms/personnel?method=showReferralDoctorJsp";
		try {
			map = personnelMasterHandlerService.showReferralDoctorJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = REFERRAL_DOCTOR_JSP;
		title = "add ReferralDoctor";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchReferralDoctor(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String referralDoctorName = null;

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			referralDoctorName = request.getParameter(SEARCH_NAME);
		}
		map = personnelMasterHandlerService
				.searchReferralDoctor(referralDoctorName);
		jsp = REFERRAL_DOCTOR_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("referralDoctorName", referralDoctorName);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editReferralDoctor(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String referralDoctorName = "";
		int departmentId = 0;
		int referralDoctorId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		String address1 = "";
		String address2 = "";
		String phoneNo = "";
		String mobileNo = "";
		int referralType = 0;

		referralDoctorName = (String) session
				.getAttribute("referralDoctorName");
		if (request.getParameter(ADDRESS_1) != null) {
			address1 = request.getParameter(ADDRESS_1);
		}
		if (request.getParameter(ADDRESS_2) != null) {
			address2 = request.getParameter(ADDRESS_2);
		}
		if (request.getParameter(PHONE) != null) {
			phoneNo = request.getParameter(PHONE);
		}
		if (request.getParameter(MOBILE) != null) {
			mobileNo = request.getParameter(MOBILE);
		}
		if (request.getParameter(REFERRAL_TYPE) != null) {
			referralType = Integer.valueOf(request.getParameter(REFERRAL_TYPE));
		}

		if (request.getParameter(DEPARTMENT_ID) != null
				&& !(request.getParameter(DEPARTMENT_ID).equals(""))) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			referralDoctorId = Integer
					.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			referralDoctorName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", referralDoctorId);
		generalMap.put("name", referralDoctorName);
		generalMap.put("departmentId", departmentId);
		generalMap.put("addressOne", address1);
		generalMap.put("addressTwo", address2);
		generalMap.put("phoneNo", phoneNo);
		generalMap.put("mobileNo", mobileNo);
		generalMap.put("referralType", referralType);

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingReferralDoctorNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingReferralDoctorNameList.size() == 0) {
			dataUpdated = personnelMasterHandlerService
					.editReferralDoctorToDatabase(generalMap);
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
			url = "/hms/hms/personnel?method=showReferralDoctorJsp";
			try {
				map = personnelMasterHandlerService.showReferralDoctorJsp();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (existingReferralDoctorNameList.size() > 0) {

			message = "Name already exists.";
		}
		jsp = REFERRAL_DOCTOR_JSP;
		title = "edit ReferralDoctor";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteReferralDoctor(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int referralDoctorId = 0;
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
			referralDoctorId = Integer
					.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = personnelMasterHandlerService.deleteReferralDoctor(
				referralDoctorId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showReferralDoctorJsp";
		try {
			map = personnelMasterHandlerService.showReferralDoctorJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = REFERRAL_DOCTOR_JSP;
		title = "delete ReferralDoctor";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	// -----------------------------------Rank------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showRankJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = personnelMasterHandlerService.showRankJsp();
		jsp = RANK_JSP;
		jsp += ".jsp";
		title = "Rank";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addRank(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasRank masRank = new MasRank();
		//int serviceTypeId = 0;
		int rankCategoryId = 0;
		//int serviceStatusId = 0;
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(RANK_CATEGORY_ID) != null) {
			rankCategoryId = Integer.parseInt(request
					.getParameter(RANK_CATEGORY_ID));
		}
		/*if (request.getParameter(SERVICE_STATUS_ID) != null) {
			serviceStatusId = Integer.parseInt(request
					.getParameter(SERVICE_STATUS_ID));
		}
		if (request.getParameter(SERVICE_TYPE_ID) != null) {
			serviceTypeId = Integer.parseInt(request
					.getParameter(SERVICE_TYPE_ID));
		}*/
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
		List rankCodeList = new ArrayList();
		List rankNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			rankCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			rankNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((rankCodeList.size() == 0 || rankCodeList == null)
				&& (rankNameList.size() == 0 || rankNameList == null)) {
			masRank.setRankCode(code);
			masRank.setRankName(name);

		/*	MasServiceStatus masServiceStatus = new MasServiceStatus();
			masServiceStatus.setId(serviceStatusId);
			masRank.setServiceStatus(masServiceStatus);

			MasServiceType masServiceType = new MasServiceType();
			masServiceType.setId(serviceTypeId);
			masRank.setServiceType(masServiceType);*/

			MasRankCategory masRankCategory = new MasRankCategory();
			masRankCategory.setId(rankCategoryId);
			masRank.setRankCategory(masRankCategory);

			masRank.setStatus("y");
			masRank.setLastChgBy(changedBy);
			masRank.setLastChgDate(currentDate);
			masRank.setLastChgTime(currentTime);
			successfullyAdded = personnelMasterHandlerService.addRank(masRank);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((rankCodeList.size() != 0 || rankCodeList != null)
				|| (rankNameList.size() != 0) || rankNameList != null) {

			if ((rankCodeList.size() != 0 || rankCodeList != null)
					&& (rankNameList.size() == 0 || rankNameList == null)) {

				message = "Rank Code  already exists.";
			} else if ((rankNameList.size() != 0 || rankNameList != null)
					&& (rankCodeList.size() == 0 || rankCodeList == null)) {
				message = "Rank Name  already exists.";
			} else if ((rankCodeList.size() != 0 || rankCodeList != null)
					&& (rankNameList.size() != 0 || rankNameList != null)) {

				message = "Rank Code and Rank Name already exist.";
			}
		}

		url = "/hms/hms/personnel?method=showRankJsp";
		try {
			map = personnelMasterHandlerService.showRankJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RANK_JSP;
		title = "Add Rank";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchRank(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String rankCode = null;
		String rankName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			rankCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			rankName = request.getParameter(SEARCH_NAME);
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
			rankCode = searchField;
			rankName = null;

		} else {
			rankCode = null;
			rankName = searchField;
		}
		map = personnelMasterHandlerService.searchRank(rankCode, rankName);
		jsp = RANK_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("rankCode", rankCode);
		map.put("rankName", rankName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editRank(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String rankCode = "";
		String rankName = "";
		int rankCategoryId = 0;
		//int serviceStatusId = 0;
	//	int serviceTypeId = 0;
		int rankId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		/*if (request.getParameter(SERVICE_TYPE_ID) != null
				&& !(request.getParameter(SERVICE_TYPE_ID).equals(""))) {
			serviceTypeId = Integer.parseInt(request
					.getParameter(SERVICE_TYPE_ID));
		}*/
		if (request.getParameter(RANK_CATEGORY_ID) != null
				&& !(request.getParameter(RANK_CATEGORY_ID).equals(""))) {
			rankCategoryId = Integer.parseInt(request
					.getParameter(RANK_CATEGORY_ID));
		}
		/*if (request.getParameter(SERVICE_STATUS_ID) != null) {
			serviceStatusId = Integer.parseInt(request
					.getParameter(SERVICE_STATUS_ID));
		}*/
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			rankId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			rankCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			rankName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", rankId);
		generalMap.put("rankCode", rankCode);
		generalMap.put("name", rankName);
		generalMap.put("rankCategoryId", rankCategoryId);
		//generalMap.put("serviceStatusId", serviceStatusId);
	//	generalMap.put("serviceTypeId", serviceTypeId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingRankNameList = (List) listMap.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingRankNameList.size() == 0) {
			dataUpdated = personnelMasterHandlerService
					.editRankToDatabase(generalMap);
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
			url = "/hms/hms/personnel?method=showRankJsp";

			try {
				map = personnelMasterHandlerService.showRankJsp();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (existingRankNameList.size() > 0) {

			message = "Name already exists.";
		}
		jsp = RANK_JSP;
		title = "Edit Rank";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings({ "unchecked", "unchecked" })
	public ModelAndView deleteRank(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int rankId = 0;
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
			rankId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = personnelMasterHandlerService.deleteRank(rankId,
				generalMap);
		if (dataDeleted == true) {

			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showRankJsp";
		try {
			map = personnelMasterHandlerService.showRankJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RANK_JSP;
		title = "delete Rank";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// -----------------------------------formation
	// -------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showFormationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = personnelMasterHandlerService.showFormationJsp();
		@SuppressWarnings("unused")
		ArrayList searchFormationList = (ArrayList) map
				.get("searchFormationList");
		jsp = FORMATION_JSP;
		jsp += ".jsp";
		title = "Formation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addFormation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasFormation masFormation = new MasFormation();
		int serviceTypeId = 0;
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}

		if (request.getParameter(SERVICE_TYPE_ID) != null) {
			serviceTypeId = Integer.valueOf(request
					.getParameter(SERVICE_TYPE_ID));
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
		List formationCodeList = new ArrayList();
		List formationNameList = new ArrayList();
		if (listMap.get("duplicateGeneralCodeList") != null) {
			formationCodeList = (List) listMap.get("duplicateGeneralCodeList");

		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			formationNameList = (List) listMap.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;
		if ((formationCodeList.size() == 0 || formationCodeList == null)
				&& (formationNameList.size() == 0 || formationNameList == null))

		{
			masFormation.setFormationCode(code);
			masFormation.setFormationName(name);
			MasServiceType masServiceType = new MasServiceType();
			masServiceType.setId(serviceTypeId);
			masFormation.setServiceType(masServiceType);

			masFormation.setStatus("y");
			masFormation.setLastChgBy(changedBy);
			masFormation.setLastChgDate(currentDate);
			masFormation.setLastChgTime(currentTime);
			successfullyAdded = personnelMasterHandlerService
					.addFormation(masFormation);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((formationCodeList.size() != 0 || formationCodeList != null)
				|| (formationNameList.size() != 0) || formationNameList != null) {

			if ((formationCodeList.size() != 0 || formationCodeList != null)
					&& (formationNameList.size() == 0 || formationNameList == null)) {

				message = "Formation Code  already exists.";
			} else if ((formationNameList.size() != 0 || formationNameList != null)
					&& (formationCodeList.size() == 0 || formationCodeList == null)) {
				message = "Formation Name  already exists.";
			} else if ((formationCodeList.size() != 0 || formationCodeList != null)
					&& (formationNameList.size() != 0 || formationNameList != null)) {

				message = "Formation Code and Formation Name already exist.";
			}
		}
		url = "/hms/hms/personnel?method=showFormationJsp";
		try {
			map = personnelMasterHandlerService.showFormationJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = FORMATION_JSP;
		title = "Add Formation";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchFormation(HttpServletRequest request,
			HttpServletResponse response) throws

	ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String formationCode = null;
		String formationName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			formationCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			formationName = request.getParameter(SEARCH_NAME);
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
			formationCode = searchField;
			formationName = null;

		} else {
			formationCode = null;
			formationName = searchField;
		}
		map = personnelMasterHandlerService.searchFormation(formationCode,
				formationName);
		jsp = FORMATION_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);

		map.put("formationCode", formationCode);
		map.put("formationName", formationName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editFormation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String formationCode = "";
		String formationName = "";
		int serviceTypeId = 0;
		int formationId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		formationCode = (String) session.getAttribute("formationCode");
		formationName = (String) session.getAttribute("formationName");
		if (request.getParameter(SERVICE_TYPE_ID) != null
				&& !(request.getParameter(SERVICE_TYPE_ID).equals(""))) {
			serviceTypeId = Integer.parseInt(request
					.getParameter(SERVICE_TYPE_ID));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			formationId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			formationCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			formationName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", formationId);
		generalMap.put("formationCode", formationCode);
		generalMap.put("name", formationName);
		generalMap.put("serviceTypeId", serviceTypeId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingFormationNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingFormationNameList.size() == 0) {

			dataUpdated = personnelMasterHandlerService
					.editFormationToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingFormationNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/personnel?method=showFormationJsp";

		try {
			map = personnelMasterHandlerService.showFormationJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = FORMATION_JSP;
		title = "Edit Formation";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings({ "unchecked", "unchecked" })
	public ModelAndView deleteFormation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int formationId = 0;
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
			formationId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = personnelMasterHandlerService.deleteFormation(
				formationId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showFormationJsp";

		try {
			map = personnelMasterHandlerService.showFormationJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = FORMATION_JSP;
		title = "delete Formation";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ------------------------------------------------------ Trade
	// -----------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showTradeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = personnelMasterHandlerService.showTradeJsp();
		jsp = TRADE_JSP;
		jsp += ".jsp";
		title = "Trade";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addTrade(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasTrade masTrade = new MasTrade();

		int serviceTypeId = 0;
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(SERVICE_TYPE_ID) != null) {
			serviceTypeId = Integer.valueOf(request
					.getParameter(SERVICE_TYPE_ID));
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
		generalMap.put("name", name);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List tradeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralNameList") != null) {
			tradeNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((tradeNameList.size() == 0 || tradeNameList == null)) {
			masTrade.setTradeName(name);
			MasServiceType masServiceType = new MasServiceType();
			masServiceType.setId(serviceTypeId);
			masTrade.setServiceType(masServiceType);

			masTrade.setStatus("y");
			masTrade.setLastChgBy(changedBy);
			masTrade.setLastChgDate(currentDate);
			masTrade.setLastChgTime(currentTime);
			successfullyAdded = personnelMasterHandlerService
					.addTrade(masTrade);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((tradeNameList.size() != 0) || tradeNameList != null) {

			if ((tradeNameList.size() != 0 || tradeNameList != null)) {
				message = "Trade Name already exists.";
			}
		}
		url = "/hms/hms/personnel?method=showTradeJsp";
		try {
			map = personnelMasterHandlerService.showTradeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = TRADE_JSP;
		title = "Add Trade";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchTrade(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String tradeName = null;
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			tradeName = request.getParameter(SEARCH_NAME);

		}
		map = personnelMasterHandlerService.searchTrade(tradeName);

		jsp = TRADE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("tradeName", tradeName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editTrade(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String tradeName = "";
		int serviceTypeId = 0;
		int tradeId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		tradeName = (String) session.getAttribute("tradeName");
		if (request.getParameter(SERVICE_TYPE_ID) != null
				&& !(request.getParameter(SERVICE_TYPE_ID).equals(""))) {
			serviceTypeId = Integer.parseInt(request
					.getParameter(SERVICE_TYPE_ID));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			tradeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			tradeName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", tradeId);

		generalMap.put("name", tradeName);
		generalMap.put("serviceTypeId", serviceTypeId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingTradeNameList = (List) listMap.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingTradeNameList.size() == 0) {
			dataUpdated = personnelMasterHandlerService
					.editTradeToDatabase(generalMap);
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
			url = "/hms/hms/personnel?method=showTradeJsp";
			try {
				map = personnelMasterHandlerService.showTradeJsp();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (existingTradeNameList.size() > 0) {

			message = "Name already exists.";
		}
		jsp = TRADE_JSP;
		title = "Edit Trade";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings({ "unchecked", "unchecked" })
	public ModelAndView deleteTrade(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int tradeId = 0;
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
			tradeId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = personnelMasterHandlerService.deleteTrade(tradeId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showTradeJsp";
		try {
			map = personnelMasterHandlerService.showTradeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = TRADE_JSP;
		title = "delete Trade";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ------------------------------------------Unit
	// ----------------------------------

	public ModelAndView searchUnit(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String unitName = null;

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			unitName = request.getParameter(SEARCH_NAME);
		}
		map = personnelMasterHandlerService.searchUnit(unitName);
		jsp = UNIT_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("unitName", unitName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showUnitJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map map = new HashMap();
		map = personnelMasterHandlerService.showUnitJsp();
		// System.out.println("map  "+map.size());
		String jsp = UNIT_JSP;
		jsp += ".jsp";
		title = "Unit";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addUnit(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasUnit masUnit = new MasUnit();
		String unitAddress = "";
		String changedBy = "";
		String local = "";
		int stationId = 0;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(UNIT_ADDRESS) != null) {
			unitAddress = request.getParameter(UNIT_ADDRESS);
		}
		if (request.getParameter(STATION_ID) != null) {
			stationId = Integer.parseInt(request.getParameter(STATION_ID));
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(LOCAL_UNIT) != null) {
			masUnit.setLocalUnit("y");
		} else {
			masUnit.setLocalUnit("n");
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

		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List unitNameList = new ArrayList();
		if (listMap.get("duplicateGeneralNameList") != null) {
			unitNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((unitNameList.size() == 0 || unitNameList == null)
				&& (unitNameList.size() == 0 || unitNameList == null)) {
			masUnit.setUnitAddress(unitAddress);
			masUnit.setUnitName(name);

			MasStation station = new MasStation();
			station.setId(stationId);
			masUnit.setStation(station);

			masUnit.setStatus("y");
			masUnit.setLastChgBy(changedBy);
			masUnit.setLastChgDate(currentDate);
			masUnit.setLastChgTime(currentTime);
			successfullyAdded = personnelMasterHandlerService.addUnit(masUnit);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((unitNameList.size() != 0) || unitNameList != null) {
			if ((unitNameList.size() != 0 || unitNameList != null)) {
				message = "Unit Name already exists.";
			}
		}
		try {
			map = personnelMasterHandlerService.showUnitJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = UNIT_JSP;
		title = "Add Unit";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editUnit(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		MasUnit masUnit = new MasUnit();
		session = request.getSession();
		String unitAddress = "";
		String unitName = "";
		int unitId = 0;
		int stationId = 0;
		String local = "";
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			unitId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(STATION_ID) != null
				&& !(request.getParameter(STATION_ID).equals(""))) {
			stationId = Integer.parseInt(request.getParameter(STATION_ID));
		}
		if (request.getParameter(UNIT_ADDRESS) != null
				&& !(request.getParameter(UNIT_ADDRESS).equals(""))) {
			unitAddress = request.getParameter(UNIT_ADDRESS);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			unitName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(LOCAL_UNIT) != null) {
			local = "y";
		} else {
			local = "n";
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", unitId);
		generalMap.put("unitAddress", unitAddress);
		generalMap.put("stationId", stationId);
		generalMap.put("name", unitName);
		generalMap.put("local", local);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingOccupationNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingOccupationNameList.size() == 0) {
			dataUpdated = personnelMasterHandlerService
					.editUnitToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingOccupationNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/personnel?method=showUnitJsp";

		try {
			map = personnelMasterHandlerService.showUnitJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = UNIT_JSP;
		title = "update Unit";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteUnit(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int unitId = 0;
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
			unitId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = personnelMasterHandlerService.deleteUnit(unitId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showUnitJsp";

		try {
			map = personnelMasterHandlerService.showUnitJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = UNIT_JSP;
		title = "delete Unit";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ---------------------------RecordOfficeAddress--------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showRecordOfficeAddressJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = personnelMasterHandlerService.showRecordOfficeAddressJsp();
		jsp = RECORD_OFFICE_ADDRESS_JSP;
		jsp += ".jsp";
		title = "RecordOfficeAddress";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addRecordOfficeAddress(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasRecordOfficeAddress masRecordOfficeAddress = new MasRecordOfficeAddress();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int serviceTypeId = 0;
		String changedBy = "";

		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(SERVICE_TYPE_ID) != null) {
			serviceTypeId = Integer.parseInt(request
					.getParameter(SERVICE_TYPE_ID));
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

		generalMap.put("name", name);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List recordOfficeAddressList = new ArrayList();

		if (listMap.get("duplicateGeneralAddressList") != null) {
			recordOfficeAddressList = (List) listMap
					.get("duplicateGeneralAddressList");
		}
		boolean successfullyAdded = false;
		if (recordOfficeAddressList.size() == 0) {
			masRecordOfficeAddress.setAddress(address);

			MasServiceType masServiceType = new MasServiceType();
			masServiceType.setId(serviceTypeId);
			masRecordOfficeAddress.setServiceType(masServiceType);

			masRecordOfficeAddress.setStatus("y");
			masRecordOfficeAddress.setLastChgBy(changedBy);
			masRecordOfficeAddress.setLastChgDate(currentDate);
			masRecordOfficeAddress.setLastChgTime(currentTime);
			successfullyAdded = personnelMasterHandlerService
					.addRecordOfficeAddress(masRecordOfficeAddress);

			if (successfullyAdded) {

				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";

			}
		} else if ((recordOfficeAddressList.size() != 0)
				|| recordOfficeAddressList != null) {

			if ((recordOfficeAddressList.size() != 0 || recordOfficeAddressList != null)) {
				message = "Record Office Address already exists.";
			}
		}

		url = "/hms/hms/personnel?method=showRecordOfficeAddressJsp";
		try {
			map = personnelMasterHandlerService.showRecordOfficeAddressJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RECORD_OFFICE_ADDRESS_JSP;
		title = "Add Record Office Address";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchRecordOfficeAddress(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String recordOfficeAddress = "";

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			recordOfficeAddress = request.getParameter(SEARCH_NAME);
		}
		map = personnelMasterHandlerService
				.searchRecordOfficeAddress(recordOfficeAddress);
		jsp = RECORD_OFFICE_ADDRESS_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("recordOfficeAddress", recordOfficeAddress);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editRecordOfficeAddress(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String address = "";
		int serviceTypeId = 0;
		int recordOfficeAddressId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		if (request.getParameter(SERVICE_TYPE_ID) != null
				&& !(request.getParameter(SERVICE_TYPE_ID).equals(""))) {
			serviceTypeId = Integer.parseInt(request
					.getParameter(SERVICE_TYPE_ID));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			recordOfficeAddressId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("pojoPropertyAddress") != null) {
			pojoPropertyAddress = request.getParameter("pojoPropertyAddress");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("id", recordOfficeAddressId);
		generalMap.put("name", name);
		generalMap.put("serviceTypeId", serviceTypeId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyAddress", pojoPropertyAddress);
		generalMap.put("pojoName", pojoName);

		boolean dataUpdated = false;

		dataUpdated = personnelMasterHandlerService
				.editRecordOfficeAddress(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant be updated !!";
		}
		url = "/hms/hms/personnel?method=showRecordOfficeAddressJsp";

		try {
			map = personnelMasterHandlerService.showRecordOfficeAddressJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RECORD_OFFICE_ADDRESS_JSP;
		title = "Edit RecordOfficeAddress";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings({ "unchecked", "unchecked" })
	public ModelAndView deleteRecordOfficeAddress(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int recordOfficeAddressId = 0;
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
			recordOfficeAddressId = Integer.parseInt(request
					.getParameter(COMMON_ID));
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
		dataDeleted = personnelMasterHandlerService.deleteRecordOfficeAddress(
				recordOfficeAddressId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showRecordOfficeAddressJsp";
		try {
			map = personnelMasterHandlerService.showRecordOfficeAddressJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RECORD_OFFICE_ADDRESS_JSP;
		title = "delete RecordOfficeAddress";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ---------------------------Rank Category----------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showRankCategoryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = personnelMasterHandlerService.showRankCategoryJsp();
		@SuppressWarnings("unused")
		ArrayList searchRankCategoryList = (ArrayList) map
				.get("searchRankCategoryList");
		jsp = RANK_CATEGORY_JSP;
		jsp += ".jsp";
		title = "rankCategory";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchRankCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String rankCategoryCode = null;
		String rankCategoryName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			rankCategoryCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			rankCategoryName = request.getParameter(SEARCH_NAME);
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
			rankCategoryCode = searchField;
			rankCategoryName = null;
		} else {
			rankCategoryCode = null;
			rankCategoryName = searchField;
		}
		map = personnelMasterHandlerService.searchRankCategory(
				rankCategoryCode, rankCategoryName);
		jsp = RANK_CATEGORY_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("rankCategoryCode", rankCategoryCode);
		map.put("rankCategoryName", rankCategoryName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addRankCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasRankCategory masRankCategory = new MasRankCategory();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

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
		List rankCategoryCodeList = new ArrayList();
		List rankCategoryNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			rankCategoryCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			rankCategoryNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((rankCategoryCodeList.size() == 0 || rankCategoryCodeList == null)
				&& (rankCategoryNameList.size() == 0 || rankCategoryNameList == null)) {
			masRankCategory.setRankCategoryCode(code);
			masRankCategory.setRankCategoryName(name);
			masRankCategory.setStatus("y");
			masRankCategory.setLastChgBy(changedBy);
			masRankCategory.setLastChgDate(currentDate);
			masRankCategory.setLastChgTime(currentTime);
			successfullyAdded = personnelMasterHandlerService
					.addRankCategory(masRankCategory);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((rankCategoryCodeList.size() != 0 || rankCategoryCodeList != null)
				|| (rankCategoryNameList.size() != 0)
				|| rankCategoryNameList != null) {
			if ((rankCategoryCodeList.size() != 0 || rankCategoryCodeList != null)
					&& (rankCategoryNameList.size() == 0 || rankCategoryNameList == null)) {
				message = "Rank Category Code  already exists.";
			} else if ((rankCategoryNameList.size() != 0 || rankCategoryNameList != null)
					&& (rankCategoryCodeList.size() == 0 || rankCategoryCodeList == null)) {
				message = "Rank Category Name already exists.";
			} else if ((rankCategoryCodeList.size() != 0 || rankCategoryCodeList != null)
					&& (rankCategoryNameList.size() != 0 || rankCategoryNameList != null)) {
				message = "Rank Category Code and Rank Category Name already exist.";
			}

		}
		url = "/hms/hms/personnel?method=showRankCategoryJsp";
		try {
			map = personnelMasterHandlerService.showRankCategoryJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RANK_CATEGORY_JSP;
		title = "Add Rank Category";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editRankCategory(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String rankCategoryCode = "";
		String rankCategoryName = "";
		int rankCategoryId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		rankCategoryCode = (String) session.getAttribute("rankCategoryCode");

		rankCategoryName = (String) session.getAttribute("rankCategoryName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			rankCategoryId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			rankCategoryCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			rankCategoryName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", rankCategoryId);
		generalMap.put("rankCategoryCode", rankCategoryCode);
		generalMap.put("name", rankCategoryName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingRankCategoryNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingRankCategoryNameList.size() == 0) {

			dataUpdated = personnelMasterHandlerService
					.editRankCategoryToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingRankCategoryNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/personnel?method=showRankCategoryJsp";
		try {
			map = personnelMasterHandlerService.showRankCategoryJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RANK_CATEGORY_JSP;
		title = "update RankCategory";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteRankCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int rankCategoryId = 0;
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
			rankCategoryId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = personnelMasterHandlerService.deleteRankCategory(
				rankCategoryId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/personnel?method=showRankCategoryJsp";
		try {
			map = personnelMasterHandlerService.showRankCategoryJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RANK_CATEGORY_JSP;
		title = "Delete Rank Category";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// --------------------Brand
	// Report-------------------------------------------------------

	public ModelAndView reportBrand(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		parameters = personnelMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_Store_Brand", parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());
		return new ModelAndView("indexB", "map", map);

	}

	// ----------------------------Brand
	// ---------------------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showBrandJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		map = personnelMasterHandlerService.showBrandJsp(box);
		jsp = BRAND_JSP;
		jsp += ".jsp";
		title = "brand";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showBrandJspPopup(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		map = personnelMasterHandlerService.showBrandJsp(box);
		jsp = "brand_popup";
		title = "brand";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView searchBrand(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String brandCode = null;
		String brandName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			brandCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			brandName = request.getParameter(SEARCH_NAME);
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
			brandCode = searchField;
			brandName = null;

		} else {
			brandCode = null;
			brandName = searchField;
		}

		map = personnelMasterHandlerService.searchBrand(brandCode, brandName);
		jsp = BRAND_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("brandCode", brandCode);
		map.put("brandName", brandName);
		return new ModelAndView("indexB", "map", map);
	}

	/*@SuppressWarnings("unchecked")
	public ModelAndView addBrand(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		MasStoreBrand masBrand = new MasStoreBrand();
		// int itemGenericId = 0;
		String nomen = request.getParameter(NAME_ITEM);
		int index1 = nomen.lastIndexOf("[");
		int index2 = nomen.lastIndexOf("]");
		index1++;
		String pvms = nomen.substring(index1, index2).toString();
		int itemId = 0;
		itemId = personnelMasterHandlerService.getItemId(pvms);
		// System.out.println("ItemId ......>>>"+itemId);
		int manufacturerId = 0;
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		
		 * if (!request.getParameter(ITEM_GENERIC_ID) .equals("0")) {
		 * itemGenericId =
		 * Integer.valueOf(request.getParameter(ITEM_GENERIC_ID)); }
		 
		if (!request.getParameter(MANUFACTURER_ID).equals("0")) {
			manufacturerId = Integer.parseInt(request
					.getParameter(MANUFACTURER_ID));
		}
		
		 * if (!request.getParameter(ITEM_ID) .equals("0")) { itemId =
		 * Integer.valueOf(request.getParameter(ITEM_ID)); }
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
		List brandCodeList = new ArrayList();
		List brandNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			brandCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			brandNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((brandCodeList.size() == 0 || brandCodeList == null)
				&& (brandNameList.size() == 0 || brandNameList == null)) {
			masBrand.setBrandCode(code);
			masBrand.setBrandName(name);

			MasManufacturer masManufacturer = new MasManufacturer();
			masManufacturer.setId(manufacturerId);
			masBrand.setManufacturer(masManufacturer);

			
			 * MasStoreItemGeneric masStoreItemGeneric = new
			 * MasStoreItemGeneric(); masStoreItemGeneric.setId(itemGenericId);
			 * masBrand.setItemGeneric(masStoreItemGeneric);
			 

			MasStoreItem masStoreItem = new MasStoreItem();
			if (itemId != 0) {
				masStoreItem.setId(itemId);
				masBrand.setItem(masStoreItem);
				// System.out.println("Inside If ItemId");
			}

			masBrand.setStatus("y");
			masBrand.setLastChgBy(changedBy);
			masBrand.setLastChgDate(currentDate);
			masBrand.setLastChgTime(currentTime);
			successfullyAdded = personnelMasterHandlerService
					.addBrand(masBrand);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((brandCodeList.size() != 0 || brandCodeList != null)
				|| (brandNameList.size() != 0) || brandNameList != null) {
			if ((brandCodeList.size() != 0 || brandCodeList != null)
					&& (brandNameList.size() == 0 || brandNameList == null)) {
				message = "Brand Code  already exists.";
			} else if ((brandNameList.size() != 0 || brandNameList != null)
					&& (brandCodeList.size() == 0 || brandCodeList == null)) {
				message = "Brand Name already exists.";
			} else if ((brandCodeList.size() != 0 || brandCodeList != null)
					&& (brandNameList.size() != 0 || brandNameList != null)) {
				message = "Brand Code and Brand Name already exist.";
			}

		}
		try {
			map = personnelMasterHandlerService.showBrandJsp(box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BRAND_JSP;
		title = "Add Brand";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}*/
	@SuppressWarnings("unchecked")
	public ModelAndView addBrand(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		MasStoreBrand masBrand = new MasStoreBrand();
		
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

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
		List brandCodeList = new ArrayList();
		List brandNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			brandCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			brandNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((brandCodeList.size() == 0 || brandCodeList == null)
				&& (brandNameList.size() == 0 || brandNameList == null)) {
			masBrand.setBrandCode(code);
			masBrand.setBrandName(name);

			
			masBrand.setStatus("y");
			masBrand.setLastChgBy(changedBy);
			masBrand.setLastChgDate(currentDate);
			masBrand.setLastChgTime(currentTime);
			successfullyAdded = personnelMasterHandlerService
					.addBrand(masBrand);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((brandCodeList.size() != 0 || brandCodeList != null)
				|| (brandNameList.size() != 0) || brandNameList != null) {
			if ((brandCodeList.size() != 0 || brandCodeList != null)
					&& (brandNameList.size() == 0 || brandNameList == null)) {
				message = "Brand Code  already exists.";
			} else if ((brandNameList.size() != 0 || brandNameList != null)
					&& (brandCodeList.size() == 0 || brandCodeList == null)) {
				message = "Brand Name already exists.";
			} else if ((brandCodeList.size() != 0 || brandCodeList != null)
					&& (brandNameList.size() != 0 || brandNameList != null)) {
				message = "Brand Code and Brand Name already exist.";
			}

		}
		try {
			map = personnelMasterHandlerService.showBrandJsp(box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BRAND_JSP;
		title = "Add Brand";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView addBrandPopup(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		MasStoreBrand masBrand = new MasStoreBrand();
		// int itemGenericId = 0;
		String nomen = request.getParameter(NAME_ITEM);
		// System.out.println("-nomen----- > "+nomen);
		int index1 = nomen.lastIndexOf("[");
		int index2 = nomen.lastIndexOf("]");
		index1++;
		String name = "";
		String code = "";
		String pvms = nomen.substring(index1, index2).toString();
		int itemId = 0;
		// System.out.println("pvms::"+pvms);
		itemId = personnelMasterHandlerService.getItemId(pvms);
		/*
		 * System.out.println("ItemId ......>>>"+itemId); if(itemId!=0)
		 * box.put("itemId", itemId);
		 */
		int manufacturerId = 0;
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		/*
		 * if (!request.getParameter(ITEM_GENERIC_ID) .equals("0")) {
		 * itemGenericId =
		 * Integer.valueOf(request.getParameter(ITEM_GENERIC_ID)); }
		 */
		if (!request.getParameter(MANUFACTURER_ID).equals("0")) {
			manufacturerId = Integer.parseInt(request
					.getParameter(MANUFACTURER_ID));
		}
		/*
		 * if (!request.getParameter(ITEM_ID) .equals("0")) { itemId =
		 * Integer.valueOf(request.getParameter(ITEM_ID)); }
		 */if (request.getParameter(CHANGED_BY) != null
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
		// generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List brandCodeList = new ArrayList();
		List brandNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			brandCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			brandNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		/*
		 * if((brandCodeList.size() == 0 || brandCodeList == null) &&
		 * (brandNameList.size() == 0 || brandNameList == null)) {
		 */masBrand.setBrandCode(code);
		masBrand.setBrandName(name);

		MasManufacturer masManufacturer = new MasManufacturer();
		masManufacturer.setId(manufacturerId);
		masBrand.setManufacturer(masManufacturer);

		/*
		 * MasStoreItemGeneric masStoreItemGeneric = new MasStoreItemGeneric();
		 * masStoreItemGeneric.setId(itemGenericId);
		 * masBrand.setItemGeneric(masStoreItemGeneric);
		 */

		MasStoreItem masStoreItem = new MasStoreItem();
		if (itemId != 0) {
			masStoreItem.setId(itemId);
			masBrand.setItem(masStoreItem);
			// System.out.println("Inside If ItemId");
		}

		masBrand.setStatus("y");
		masBrand.setLastChgBy(changedBy);
		masBrand.setLastChgDate(currentDate);
		masBrand.setLastChgTime(currentTime);
		successfullyAdded = personnelMasterHandlerService.addBrand(masBrand);

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}
		/*
		 * } else if((brandCodeList.size() != 0 || brandCodeList != null) ||
		 * (brandNameList.size() != 0) || brandNameList != null) {
		 * if((brandCodeList.size() != 0 || brandCodeList != null) &&
		 * (brandNameList.size() == 0 || brandNameList == null)) { message =
		 * "Brand Code  already exists."; } else if((brandNameList.size() != 0
		 * || brandNameList != null) && (brandCodeList.size() == 0 ||
		 * brandCodeList == null) ){ message = "Brand Name already exists."; }
		 * else if((brandCodeList.size() != 0 || brandCodeList != null) &&
		 * (brandNameList.size() != 0 || brandNameList != null)){ message =
		 * "Brand Code and Brand Name already exist."; }
		 * 
		 * }
		 */
		try {
			map = personnelMasterHandlerService.showBrandJsp(box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "brand_popup";
		title = "Add Brand";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView(jsp, "map", map);
	}

	/*public ModelAndView editBrand(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String brandCode = "";
		String brandName = "";
		int brandId = 0;
		// int itemGenericId = 0;
		int manufacturerId = 0;
		String nomen = request.getParameter(NAME_ITEM);
		int index1 = nomen.lastIndexOf("[");
		int index2 = nomen.lastIndexOf("]");
		index1++;
		String pvms = nomen.substring(index1, index2).toString();
		int itemId = 0;
		itemId = personnelMasterHandlerService.getItemId(pvms);
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Date currentDate = null;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			brandId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			brandCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			brandName = request.getParameter(SEARCH_NAME);
		}
		
		 * if (!request.getParameter(ITEM_GENERIC_ID) .equals("0")) {
		 * itemGenericId =
		 * Integer.valueOf(request.getParameter(ITEM_GENERIC_ID)); }
		 
		if (!request.getParameter(MANUFACTURER_ID).equals("0")) {
			manufacturerId = Integer.valueOf(request
					.getParameter(MANUFACTURER_ID));
		}
		
		 * if (!request.getParameter(ITEM_ID) .equals("0")) { itemId =
		 * Integer.valueOf(request.getParameter(ITEM_ID)); }
		 
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
		generalMap.put("id", brandId);
		generalMap.put("brandCode", brandCode);
		generalMap.put("name", brandName);
		// generalMap.put("itemGenericId",itemGenericId);
		generalMap.put("manufacturerId", manufacturerId);
		generalMap.put("itemId", itemId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		// listMap =
		// commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingBrandNameList = new ArrayList();
		// List existingBrandNameList =
		// (List)listMap.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (brandId != 0) {

			dataUpdated = personnelMasterHandlerService
					.editBrandToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		}

		url = "/hms/hms/personnel?method=showBrandJsp";
		try {
			map = personnelMasterHandlerService.showBrandJsp(box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BRAND_JSP;
		title = "Update Brand";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}*/
	public ModelAndView editBrand(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String brandCode = "";
		String brandName = "";
		int brandId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Date currentDate = null;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			brandId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			brandCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			brandName = request.getParameter(SEARCH_NAME);
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
		generalMap.put("id", brandId);
		generalMap.put("brandCode", brandCode);
		generalMap.put("name", brandName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		// listMap =
		// commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingBrandNameList = new ArrayList();
		// List existingBrandNameList =
		// (List)listMap.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (brandId != 0) {

			dataUpdated = personnelMasterHandlerService
					.editBrandToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Record updated Successfully !!";
			} else {
				message = "Record Cant Be Updated !!";
			}
		}

		url = "/hms/hms/personnel?method=showBrandJsp";
		try {
			map = personnelMasterHandlerService.showBrandJsp(box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BRAND_JSP;
		title = "Update Brand";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editBrandPopup(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String brandCode = "";
		String brandName = "";
		int brandId = 0;
		// int itemGenericId = 0;
		int manufacturerId = 0;
		String nomen = request.getParameter(NAME_ITEM);
		int index1 = nomen.lastIndexOf("[");
		int index2 = nomen.lastIndexOf("]");
		index1++;
		String pvms = nomen.substring(index1, index2).toString();
		int itemId = 0;
		itemId = personnelMasterHandlerService.getItemId(pvms);
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Date currentDate = null;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			brandId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			brandCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			brandName = request.getParameter(SEARCH_NAME);
		}
		/*
		 * if (!request.getParameter(ITEM_GENERIC_ID) .equals("0")) {
		 * itemGenericId =
		 * Integer.valueOf(request.getParameter(ITEM_GENERIC_ID)); }
		 */
		if (!request.getParameter(MANUFACTURER_ID).equals("0")) {
			manufacturerId = Integer.valueOf(request
					.getParameter(MANUFACTURER_ID));
		}
		/*
		 * if (!request.getParameter(ITEM_ID) .equals("0")) { itemId =
		 * Integer.valueOf(request.getParameter(ITEM_ID)); }
		 */
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
		generalMap.put("id", brandId);
		generalMap.put("brandCode", brandCode);
		generalMap.put("name", brandName);
		// generalMap.put("itemGenericId",itemGenericId);
		generalMap.put("manufacturerId", manufacturerId);
		generalMap.put("itemId", itemId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingBrandNameList = (List) listMap.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingBrandNameList.size() == 0) {

			dataUpdated = personnelMasterHandlerService
					.editBrandToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingBrandNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/personnel?method=showBrandJsp";
		try {
			map = personnelMasterHandlerService.showBrandJsp(box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "brand_popup";
		title = "Update Brand";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView deleteBrand(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		int brandId = 0;
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
			brandId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = personnelMasterHandlerService.deleteBrand(brandId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/personnel?method=showBrandJsp";
		try {
			map = personnelMasterHandlerService.showBrandJsp(box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BRAND_JSP;
		title = "Delete Brand";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteBrandPopup(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		int brandId = 0;
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
			brandId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		// System.out.println("brand Id =============" + brandId);
		dataDeleted = personnelMasterHandlerService.deleteBrand(brandId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/personnel?method=showBrandJsp";
		try {
			map = personnelMasterHandlerService.showBrandJsp(box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BRAND_JSP;
		title = "Delete Brand";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView generateEmployeeLogin(HttpServletRequest request,
			HttpServletResponse response) {

		// =====To Update the Employee master====

		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> statusmap = new HashMap<String, Object>();

		String flag = "";
		String fname = null;
		String lname = null;
		String mname = null;
		String service = null;
		String status = null;

		String employeeCode = "";
		String firstName = "";
		String middleName = "";
		String lastName = "";
		int departmentId = 0;
		int costCenterId = 0;
		int empStatusId = 0;
		int empCategoryId = 0;
		int personnelId = 0;
		int gradeId = 0;
		int rankId = 0;
		int unitId = 0;
		int tradeId = 0;
		String serviceNo = "";
		String designation = "";
		String emergencyTellNumber = "";
		String emergencyCellNumber = "";
		String residenceTellNumber = "";
		String officeTellNumber = "";
		Date appointmentDate = new Date();
		String jobCode = "";
		String changedBy = "";
		String email = "";
		String bankCode = "";
		String employeePhoto = "";
		String employeeUrl = "";
		String accountHead = "";
		int titleId = 0;
		String bankAccountCode = "";
		String grade = "";
		Date joinDate = new Date();
		Date changedDate = new Date();
		@SuppressWarnings("unused")
		String changedTime = "";
		int employeeId = 0;
		String bankAccountNumber = "";
		session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			employeeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(EMPLOYEE_CODE) != null
				&& !(request.getParameter(EMPLOYEE_CODE).equals(""))) {
			employeeCode = request.getParameter(EMPLOYEE_CODE);
		}
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (!request.getParameter(TITLE_ID).equals("0")) {
			titleId = Integer.parseInt(request.getParameter(TITLE_ID));
		}
		if (request.getParameter(EMPLOYEE_JOB_CODE) != null) {
			jobCode = request.getParameter(EMPLOYEE_JOB_CODE);
		}
		if (request.getParameter(BANK_ACCOUNT_NUMBER) != null) {
			bankAccountNumber = request.getParameter(BANK_ACCOUNT_NUMBER);
		}
		if (request.getParameter(EMPLOYEE_GRADE) != null) {
			grade = request.getParameter(EMPLOYEE_GRADE);
		}
		if (request.getParameter(BANK_ACCOUNT_CODE) != null) {
			bankAccountCode = request.getParameter(BANK_ACCOUNT_CODE);
		}
		if (request.getParameter(ACCOUNT_HEAD) != null) {
			accountHead = request.getParameter(ACCOUNT_HEAD);
		}
		if (request.getParameter(BANK_CODE) != null) {
			bankCode = request.getParameter(BANK_CODE);
		}
		if (request.getParameter(EMERGENCY_PHONE) != null) {
			emergencyTellNumber = request.getParameter(EMERGENCY_PHONE);
		}
		if (request.getParameter(EMERGENCY_MOBILE) != null) {
			emergencyCellNumber = request.getParameter(EMERGENCY_MOBILE);
		}
		if (request.getParameter(TELL_NO_RESIDENCE) != null) {
			residenceTellNumber = request.getParameter(TELL_NO_RESIDENCE);
		}
		if (request.getParameter(TELL_NO_OFFICE) != null) {
			officeTellNumber = request.getParameter(TELL_NO_OFFICE);
		}
		if (request.getParameter(EMAIL) != null) {
			email = request.getParameter(EMAIL);
		}
		try {
			if (!request.getParameter(APPOINTMENT_DATE).trim()
					.equalsIgnoreCase("")
					&& request.getParameter(APPOINTMENT_DATE) != null) {
				appointmentDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(APPOINTMENT_DATE));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (!request.getParameter(JOIN_DATE).trim().equalsIgnoreCase("")
					&& request.getParameter(JOIN_DATE) != null) {
				joinDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(JOIN_DATE));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if (!request.getParameter(EMPLOYEE_CATEGORY_ID).trim()
				.equalsIgnoreCase("")
				&& !request.getParameter(EMPLOYEE_CATEGORY_ID).equals("0")) {
			empCategoryId = Integer.parseInt(request
					.getParameter(EMPLOYEE_CATEGORY_ID));
		}
		if (request.getParameter(DESIGNATION_ID) != null) {
			designation = (String) request.getParameter(DESIGNATION_ID);
		}

		if (!request.getParameter(DEPARTMENT_ID).trim().equalsIgnoreCase("")
				&& !request.getParameter(DEPARTMENT_ID).equals("0")) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (!request.getParameter(COST_CENTER_ID).trim().equalsIgnoreCase("")
				&& !request.getParameter(COST_CENTER_ID).equals("0")) {
			costCenterId = Integer.parseInt(request
					.getParameter(COST_CENTER_ID));
		}
		if (!request.getParameter(EMPLOYEE_GRADE_ID).trim()
				.equalsIgnoreCase("")
				&& !request.getParameter(EMPLOYEE_GRADE_ID).equals("0")) {
			gradeId = Integer.parseInt(request.getParameter(EMPLOYEE_GRADE_ID));
		}
		if (!request.getParameter(RANK_ID).trim().equalsIgnoreCase("")
				&& !request.getParameter(RANK_ID).equals("0")) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
		}
		if (!request.getParameter(UNIT_ID).trim().equalsIgnoreCase("")
				&& !request.getParameter(UNIT_ID).equals("0")) {
			unitId = Integer.parseInt(request.getParameter(UNIT_ID));
		}
		if (!request.getParameter(TRADE_ID).trim().equalsIgnoreCase("")
				&& !request.getParameter(TRADE_ID).equals("0")) {
			tradeId = Integer.parseInt(request.getParameter(TRADE_ID));
		}
		if (request.getParameter(FIRST_NAME) != null) {
			firstName = request.getParameter(FIRST_NAME);
		}
		if (request.getParameter(MIDDLE_NAME) != null) {
			middleName = request.getParameter(MIDDLE_NAME);
		}
		if (request.getParameter(LAST_NAME) != null) {
			lastName = request.getParameter(LAST_NAME);
		}
		if (!request.getParameter(EMP_STATUS_ID).trim().equalsIgnoreCase("")
				&& !request.getParameter(EMP_STATUS_ID).equals("0")) {
			empStatusId = Integer.parseInt(request.getParameter(EMP_STATUS_ID));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(EMPLOYEE_PHOTO) != null) {
			employeePhoto = request.getParameter(EMPLOYEE_PHOTO);
		}
		if (request.getParameter(URL) != null) {
			employeeUrl = request.getParameter(URL);
		}
		personnelId = (Integer) session.getAttribute(HOSPITAL_ID);

		if (request.getParameter(FIRST_NAME) != null) {
			fname = request.getParameter(FIRST_NAME);
		}
		if (request.getParameter(MIDDLE_NAME) != null) {
			mname = request.getParameter(MIDDLE_NAME);
		}
		if (request.getParameter(LAST_NAME) != null) {
			lname = request.getParameter(LAST_NAME);
		}
		if (request.getParameter(SERVICE_NO) != null) {
			service = request.getParameter(SERVICE_NO);
		}
		if (request.getParameter(STATUS) != null) {
			status = request.getParameter(STATUS);
		}
		if (!request.getParameter(DEPARTMENT_ID).trim().equalsIgnoreCase("")
				&& request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("id", employeeId);
		generalMap.put("personnelId", personnelId);
		generalMap.put("titleId", titleId);
		generalMap.put("employeeCode", employeeCode);
		generalMap.put("serviceNo", serviceNo);
		generalMap.put("firstName", firstName);
		generalMap.put("middleName", middleName);
		generalMap.put("personnelId", personnelId);
		generalMap.put("lastName", lastName);
		generalMap.put("jobCode", jobCode);
		generalMap.put("bankCode", bankCode);
		generalMap.put("employeePhoto", employeePhoto);
		generalMap.put("employeeUrl", employeeUrl);
		generalMap.put("emergencyTellNumber", emergencyTellNumber);
		generalMap.put("emergencyCellNumber", emergencyCellNumber);
		generalMap.put("residenceTellNumber", residenceTellNumber);
		generalMap.put("officeTellNumber", officeTellNumber);
		generalMap.put("email", email);
		generalMap.put("accountHead", accountHead);
		generalMap.put("appointmentDate", appointmentDate);
		generalMap.put("joinDate", joinDate);
		generalMap.put("gradeId", gradeId);
		generalMap.put("empCategoryId", empCategoryId);
		generalMap.put("designation", designation);
		generalMap.put("tradeId", tradeId);
		generalMap.put("rankId", rankId);
		generalMap.put("unitId", unitId);
		generalMap.put("departmentId", departmentId);
		generalMap.put("empStatusId", empStatusId);
		generalMap.put("costCenterId", costCenterId);
		generalMap.put("grade", grade);
		generalMap.put("empStatusId", empStatusId);
		generalMap.put("bankAccountNumber", bankAccountNumber);
		generalMap.put("bankAccountCode", bankAccountCode);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("hospitalId", hospitalId);
		boolean dataUpdated = false;
		dataUpdated = personnelMasterHandlerService
				.editEmployeeToDatabase(generalMap);
		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Record Cant Be Updated !!";
		}
		// System.out.println("message  "+message);

		// =============================

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("fname", fname);
		generalMap.put("mname", mname);
		generalMap.put("lname", lname);
		generalMap.put("service", service);
		generalMap.put("status", status);
		generalMap.put("departmentId", departmentId);

		statusmap = personnelMasterHandlerService.generateEmployeeLogin(
				employeeId, generalMap);

		message = (String) statusmap.get("dataStatus");

		// System.out.println("message ::::"+message);

		url = "/hms/hms/personnel?method=showEmployeeJsp";
		try {
			map = personnelMasterHandlerService.showEmployeeJsp(personnelId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = EMPLOYEE_JSP;
		title = "Delete Employee";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showMedicalCategoryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = personnelMasterHandlerService.showMedicalCategoryJsp();
		jsp = "medical_category";
		jsp += ".jsp";
		title = "Trade";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView addMedicalCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasMedicalCategory masMedicalCategory = new MasMedicalCategory();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

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

		generalMap.put("name", name);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List medicaCategoryNameList = new ArrayList();

		if (listMap.get("duplicateGeneralNameList") != null) {
			medicaCategoryNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		// System.out.println("medicaCategoryNameList========="+medicaCategoryNameList.size());
		boolean successfullyAdded = false;
		if ((medicaCategoryNameList.size() == 0 || medicaCategoryNameList == null)) {
			masMedicalCategory.setMedicalCategoryName(name);
			masMedicalCategory.setStatus("y");
			masMedicalCategory.setLastChgBy(changedBy);
			masMedicalCategory.setLastChgDate(currentDate);
			masMedicalCategory.setLastChgTime(currentTime);
			successfullyAdded = personnelMasterHandlerService
					.addMedicalCategory(masMedicalCategory);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((medicaCategoryNameList.size() != 0)
				|| medicaCategoryNameList != null) {

			message = "Rank Category Name already exists.";
		}

		url = "/hms/hms/personnel?method=showMedicalCategoryJsp";
		try {
			map = personnelMasterHandlerService.showMedicalCategoryJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "medical_category";
		title = "Add Medical Category";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editMedicalCategory(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String medicalCategoryName = "";
		int medicalCategoryId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		// rankCategoryCode=(String )session.getAttribute("rankCategoryCode");

		// rankCategoryName=(String )session.getAttribute("rankCategoryName");

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			medicalCategoryId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			medicalCategoryName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", medicalCategoryId);
		generalMap.put("name", medicalCategoryName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingMedicalCategoryNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingMedicalCategoryNameList.size() == 0) {

			dataUpdated = personnelMasterHandlerService
					.editMedicalCategory(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingMedicalCategoryNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/personnel?method=showMedicalCategoryJsp";
		try {
			map = personnelMasterHandlerService.showMedicalCategoryJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "medical_category";
		title = "update MedicalCategory";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteMedicalCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int medicalCategoryId = 0;
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
			medicalCategoryId = Integer.parseInt(request
					.getParameter(COMMON_ID));
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
		dataDeleted = personnelMasterHandlerService.deleteMedicalCategory(
				medicalCategoryId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/personnel?method=showMedicalCategoryJsp";
		try {
			map = personnelMasterHandlerService.showMedicalCategoryJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "medical_category";
		title = "Delete Medical Category";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchMedicalCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String medicalCategoryName = null;
		String searchField = null;

		/*
		 * if(request.getParameter(SEARCH_NAME) != null &&
		 * !(request.getParameter(SEARCH_NAME).equals(""))){ rankCategoryName =
		 * request.getParameter(SEARCH_NAME); }
		 */

		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				medicalCategoryName = request.getParameter(SEARCH_FIELD);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		map = personnelMasterHandlerService
				.searchMedicalCategory(medicalCategoryName);
		jsp = "medical_category";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("search", "search");
		map.put("medicalCategoryName", medicalCategoryName);
		return new ModelAndView("indexB", "map", map);
	}

	// end generate login
	/**
	 * showEmployeeTemplate
	 * 
	 * @author Mukesh Narayan Singh
	 * @param request
	 *            ,responsemap
	 * @return map
	 */
	public ModelAndView showEmployeeTemplate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetails = new HashMap<String, Object>();
		session = request.getSession();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		mapDetails.put("hospitalId", hospitalId);
		int empId = 0;
		if (request.getParameter("empId") != null
				&& !(request.getParameter("empId").equals(""))) {
			empId = Integer.parseInt("" + request.getParameter("empId"));

		}
		mapDetails.put("empId", empId);
		// MasTemplate
		map = personnelMasterHandlerService.showEmployeeTemplate(mapDetails);
		jsp = "employeeAssinedTempletResponse";
		title = "Show Employee Assined Templet";
		// map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showEmpSMCTransferJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int commandId = 0;
		int hospitalId = 0;

		commandId = (Integer) session.getAttribute("commandId");
		hospitalId = (Integer) session.getAttribute("hospitalId");
		datamap.put("hospitalId", hospitalId);
		datamap.put("commandId", commandId);

		map = personnelMasterHandlerService.showEmpSMCTransferJsp(datamap);

		String jsp = "SmcTransfer";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateEmployeeSMC(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		Map<String, Object> datamap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int commandId = 0;
		int hospitalId = 0;

		commandId = (Integer) session.getAttribute("commandId");
		hospitalId = (Integer) session.getAttribute("hospitalId");
		datamap.put("hospitalId", hospitalId);
		datamap.put("commandId", commandId);
		String userName = "";
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		box.put("userName", userName);
		map = personnelMasterHandlerService.updateEmployeeSMC(box);
		String message = "";
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}

		map = personnelMasterHandlerService.showEmpSMCTransferJsp(datamap);
		map.put("message", message);
		String jsp = "SmcTransfer";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchEmployeeForSMCTransfer(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int commandId = 0;
		int hospitalId = 0;
		if (request.getParameter("scommand") != null) {
			commandId = Integer.parseInt(request.getParameter("scommand"));
		}
		if (request.getParameter("sHospital") != null) {
			hospitalId = Integer.parseInt(request.getParameter("sHospital"));
		}
		datamap.put("hospitalId", hospitalId);
		datamap.put("commandId", commandId);
		String serviceNo = "";
		if (request.getParameter("serviceNo") != null) {
			serviceNo = request.getParameter("serviceNo");
		}
		datamap.put("serviceNo", serviceNo);
		map = personnelMasterHandlerService.showEmpSMCTransferJsp(datamap);

		String jsp = "SmcTransfer";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// ------------------------- Command Master By Mansi on 1st Aug
	// 2013------------------------------------------------

	public ModelAndView searchCommand(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String commandCode = null;
		String commandName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			commandCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			commandName = request.getParameter(SEARCH_NAME);
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
			commandCode = searchField;
			commandName = null;

		} else {
			commandCode = null;
			commandName = searchField;
		}
		map = personnelMasterHandlerService.searchCommand(commandCode,
				commandName);

		jsp = COMMAND_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("commandCode", commandCode);
		map.put("commandName", commandName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showCommandJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = personnelMasterHandlerService.showCommandJsp();
		@SuppressWarnings("unused")
		ArrayList searchCommandList = (ArrayList) map.get("searchCommandList");
		jsp = COMMAND_JSP;
		jsp += ".jsp";
		title = "Command";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addCommand(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasCommand masCommand = new MasCommand();

		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

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

		List commandCodeList = new ArrayList();
		List commandNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			commandCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			commandNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((commandCodeList.size() == 0 || commandCodeList == null)
				&& (commandNameList.size() == 0 || commandNameList == null)) {
			masCommand.setCommandCode(code);
			masCommand.setCommandName(name);
			masCommand.setStatus("y");

			Users user = (Users) session.getAttribute("users");
			masCommand.setLastChgBy(user);

			masCommand.setLastChgDate(currentDate);
			masCommand.setLastChgTime(currentTime);
			successfullyAdded = personnelMasterHandlerService
					.addCommand(masCommand);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((commandCodeList.size() != 0 || commandCodeList != null)
				|| (commandNameList.size() != 0) || commandNameList != null) {

			if ((commandCodeList.size() != 0 || commandCodeList != null)
					&& (commandNameList.size() == 0 || commandNameList == null)) {
				message = "Command Code  already exists.";
			} else if ((commandNameList.size() != 0 || commandNameList != null)
					&& (commandCodeList.size() == 0 || commandCodeList == null)) {
				message = "Command Name already exists.";
			} else if ((commandCodeList.size() != 0 || commandCodeList != null)
					&& (commandNameList.size() != 0 || commandNameList != null)) {
				message = "Command Code and Command Name already exist.";
			}
		}
		url = "/hms/hms/personnel?method=showCommandJsp";

		try {
			map = personnelMasterHandlerService.showCommandJsp();

		} catch (Exception e) {
			// System.out.println("Exception in  showCommandJsp "+e);
		}
		jsp = COMMAND_JSP;
		title = "Add command";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editCommand(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String commandCode = "";
		String commandName = "";
		int commandId = 0;
		String changedBy = "";
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			commandId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			commandCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			commandName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
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
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		generalMap.put("userId", userId);
		generalMap.put("id", commandId);
		generalMap.put("commandCode", commandCode);
		generalMap.put("name", commandName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingCommandNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingCommandNameList.size() == 0) {
			dataUpdated = personnelMasterHandlerService
					.editCommandToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingCommandNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/personnel?method=showCommandJsp";
		try {
			map = personnelMasterHandlerService.showCommandJsp();

		} catch (Exception e) {
			// System.out.println("Exception in  showCommandJsp "+e);
		}
		jsp = COMMAND_JSP;
		title = "Update command";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView deleteCommand(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int commandId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		generalMap.put("userId", userId);

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			commandId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = personnelMasterHandlerService.deleteCommand(commandId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showCommandJsp";
		try {
			map = personnelMasterHandlerService.showCommandJsp();

		} catch (Exception e) {
			// System.out.println("Exception in  showCommandJsp "+e);
		}
		jsp = COMMAND_JSP;
		title = "Delete command";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	// ------------------------- Station Master By Mansi on 1st Aug
	// 2013------------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showStationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = personnelMasterHandlerService.showStationJsp();
		@SuppressWarnings("unused")
		ArrayList searchStationList = (ArrayList) map.get("searchStationList");
		jsp = STATION_JSP;
		jsp += ".jsp";
		title = "Station";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addStation(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasStation masStation = new MasStation();

		int commandId = 0;
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}

		if (request.getParameter(COMMAND_ID) != null) {
			commandId = Integer.valueOf(request.getParameter(COMMAND_ID));

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
		List stationCodeList = new ArrayList();
		List stationNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			stationCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			stationNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((stationCodeList.size() == 0 || stationCodeList == null)
				&& (stationNameList.size() == 0 || stationNameList == null))

		{
			masStation.setStationCode(code);
			masStation.setStationName(name);
			MasCommand masCommand = new MasCommand();
			masCommand.setId(commandId);
			masStation.setCommand(masCommand);

			masStation.setStatus("y");

			Users user = (Users) session.getAttribute("users");
			masStation.setLastChgBy(user);

			masStation.setLastChgDate(currentDate);
			masStation.setLastChgTime(currentTime);
			successfullyAdded = personnelMasterHandlerService
					.addStation(masStation);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";

			}
		} else if ((stationCodeList.size() != 0 || stationCodeList != null)
				|| (stationNameList.size() != 0) || stationNameList != null) {

			if ((stationCodeList.size() != 0 || stationCodeList != null)
					&& (stationNameList.size() == 0 || stationNameList == null)) {

				message = "Station Code  already exists.";
			} else if ((stationNameList.size() != 0 || stationNameList != null)
					&& (stationCodeList.size() == 0 || stationCodeList == null)) {

				message = "Station Name  already exists.";
			} else if ((stationCodeList.size() != 0 || stationCodeList != null)
					&& (stationNameList.size() != 0 || stationNameList != null)) {

				message = "Station Code and Station Name already exist.";
			}
		}

		url = "/hms/hms/personnel?method=showStationJsp";

		try {
			map = personnelMasterHandlerService.showStationJsp();

		} catch (Exception e) {
			// System.out.println("Exception in  showStationJsp "+e);
		}
		jsp = STATION_JSP;
		title = "Add Station";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchStation(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String stationCode = null;
		String stationName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			stationCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			stationName = request.getParameter(SEARCH_NAME);
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
			stationCode = searchField;
			stationName = null;
		} else {
			stationCode = null;
			stationName = searchField;
		}
		map = personnelMasterHandlerService.searchStation(stationCode,
				stationName);

		jsp = STATION_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("stationCode", stationCode);
		map.put("stationName", stationName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editStation(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String stationCode = "";
		String stationName = "";
		int commandId = 0;
		int stationId = 0;
		String changedBy = "";

		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		if (request.getParameter(COMMAND_ID) != null
				&& !(request.getParameter(COMMAND_ID).equals(""))) {
			commandId = Integer.parseInt(request.getParameter(COMMAND_ID));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			stationId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			stationCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			stationName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
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

		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		generalMap.put("userId", userId);

		generalMap.put("id", stationId);
		generalMap.put("stationCode", stationCode);
		generalMap.put("name", stationName);
		generalMap.put("commandId", commandId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingStationNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingStationNameList.size() == 0) {
			dataUpdated = personnelMasterHandlerService
					.editStationToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingStationNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/personnel?method=showStationJsp";

		try {
			map = personnelMasterHandlerService.showStationJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = STATION_JSP;
		title = "Edit Station";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings({ "unchecked", "unchecked" })
	public ModelAndView deleteStation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int stationId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		generalMap.put("userId", userId);

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			stationId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = personnelMasterHandlerService.deleteStation(stationId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showStationJsp";
		try {
			map = personnelMasterHandlerService.showStationJsp();

		} catch (Exception e) {
			// System.out.println("Exception in  showStationJsp "+e);
		}
		jsp = STATION_JSP;
		title = "delete Station";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView getDepartmentList(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int divisionId = 0;
		
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			

			if (request.getParameter("divisionId") != null	&& !request.getParameter("divisionId").equals("0")) {
				divisionId = Integer.parseInt(request.getParameter("divisionId"));
			}
			
		
			dataMap.put("divisionId", divisionId);
		

			map = personnelMasterHandlerService.getDepartmentList(dataMap);
			
			jsp = "responseDepartmentList";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView getDepartmentMultiList(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int divisionId = 0;
		
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			

			if (request.getParameter("divisionId") != null	&& !request.getParameter("divisionId").equals("0")) {
				divisionId = Integer.parseInt(request.getParameter("divisionId"));
			}
			
		
			dataMap.put("divisionId", divisionId);
		

			map = personnelMasterHandlerService.getDepartmentList(dataMap);
			
			jsp = "responseDepartmentMultiList";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}
	
	
	public ModelAndView 	getDepartmentNoList(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int departmentId = 0;
		
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			

			if (request.getParameter("departmentId") != null	&& !request.getParameter("departmentId").equals("0")) {
				departmentId = Integer.parseInt(request.getParameter("departmentId"));
			}
			
		
			dataMap.put("departmentId", departmentId);
		

			map = personnelMasterHandlerService.getDepartmentNoList(dataMap);
			
			jsp = "responseDepartmentNoList";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getGradeList(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int rankCategoryId = 0;
		
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			

			if (request.getParameter(RANK_CATEGORY_ID) != null	&& !request.getParameter(RANK_CATEGORY_ID).equals("0")) {
				rankCategoryId = Integer.parseInt(request.getParameter(RANK_CATEGORY_ID));
			}
			
		
			dataMap.put("rankCategoryId", rankCategoryId);
		

			map = personnelMasterHandlerService.getGradeList(dataMap);
			
			jsp = "responseGradeList";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView getLocalStateList(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int localCountry = 0;
		
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			

			if (request.getParameter("localCountry") != null	&& !request.getParameter("localCountry").equals("0")) {
				localCountry = Integer.parseInt(request.getParameter("localCountry"));
			}
			
		
			dataMap.put("localCountry", localCountry);
		

			map = personnelMasterHandlerService.getLocalStateList(dataMap);
			
			jsp = "responseLocalStateList";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getLocalDistrictList(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int localState = 0;
		
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			

			if (request.getParameter("localState") != null	&& !request.getParameter("localState").equals("0")) {
				localState = Integer.parseInt(request.getParameter("localState"));
			}
			
		
			dataMap.put("localState", localState);
		

			map = personnelMasterHandlerService.getLocalDistrictList(dataMap);
			
			jsp = "responseLocalDistrictList";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getPerStateList(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int perCountry = 0;
		
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			

			if (request.getParameter("perCountry") != null	&& !request.getParameter("perCountry").equals("0")) {
				perCountry = Integer.parseInt(request.getParameter("perCountry"));
			}
			
		
			dataMap.put("perCountry", perCountry);
		

			map = personnelMasterHandlerService.getPerStateList(dataMap);
			
			jsp = "responsePerStateList";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}
	

	
	
	

	
	public ModelAndView getPerDistrictList(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int perState = 0;
		
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			

			if (request.getParameter("perState") != null	&& !request.getParameter("perState").equals("0")) {
				perState = Integer.parseInt(request.getParameter("perState"));
			}
			
		
			dataMap.put("perState", perState);
		

			map = personnelMasterHandlerService.getPerDistrictList(dataMap);
			
			jsp = "responsePerDistrictList";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getDepartmentForDisplay(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int employeeId = box.getInt("employeeId");
		int divisionId = 0;
	
		String divisionName="";
		if (request.getParameter("divisionName") != null	&& !request.getParameter("divisionName").equals("")) {
			divisionName = request.getParameter("divisionName");
		}
		dataMap.put("divisionName", divisionName);
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();

		map = personnelMasterHandlerService.getDeptDivisionNameList(dataMap);
		if(map.get("masDepartmentList")!=null){
			masDepartmentList = (List<MasDepartment>)map.get("masDepartmentList");
		}
		
		
		map = personnelMasterHandlerService.getDepartmentForDisplay(employeeId);
		map.put("masDepartmentList", masDepartmentList);
		String jsp = "responseForEmployeeDetails";
		map.put("employeeId", employeeId);
		return new ModelAndView(jsp, "map", map);
	}

	public void displayImage(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map=new HashMap<String,Object>();
		int  employeeId=Integer.parseInt(request.getParameter("employeeId"));
		
		map=personnelMasterHandlerService.displayImage(employeeId);
		//if(null !=map.get("imageObj")){
			OutputStream oImage = null;
			   try {
			       
			        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
			       oImage = response.getOutputStream();
			       if(map.get("imageObj")!=null)
			       {
			    	   
			    	   UploadDocuments item10 = (UploadDocuments)map.get("imageObj");
			    	   byte[] photo = item10.getPatientDocument();
			    	   oImage.write(photo);
			       }
			       else
			       {
			    	   File fi = new File(getServletContext().getRealPath("/jsp/images/photo_icon.png"));
			    	   byte[] fileContent=Files.readAllBytes(fi.toPath());
			    	 
						oImage.write(fileContent);
			       }
			       
			        oImage.flush();
			        oImage.close();
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
		  /*  UploadDocuments item10 = (UploadDocuments)map.get("imageObj");

		    try {
		        byte[] photo = item10.getPatientDocument();
		        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		       oImage = response.getOutputStream();
		        oImage.write(photo);
		        oImage.flush();
		        oImage.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }*/
		//}
		
	}
	public void displayImageEmployeeDependent(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map=new HashMap<String,Object>();
		int  employeeDependentId=Integer.parseInt(request.getParameter("employeeDependentId"));
		
		map=personnelMasterHandlerService.displayImageEmployeeDependent(employeeDependentId);
		//if(null !=map.get("imageObj")){
			OutputStream oImage = null;
		   

		    try {
		       
		        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		       oImage = response.getOutputStream();
		       if(map.get("imageObj")!=null)
		       {
		    	   
		    	   UploadDocuments item10 = (UploadDocuments)map.get("imageObj");
		    	   byte[] photo = item10.getPatientDocument();
		    	   oImage.write(photo);
		       }
		       else
		       {
		    	   File fi = new File(getServletContext().getRealPath("/jsp/images/photo_icon.png"));
		    	   byte[] fileContent=Files.readAllBytes(fi.toPath());
		    	 
					oImage.write(fileContent);
		       }
		       
		        oImage.flush();
		        oImage.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		//}
/*		
		}*/
		
	}
	
	public void displayImageCommon(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map=new HashMap<String,Object>();
		Box box = HMSUtil.getBox(request);
		
		map=personnelMasterHandlerService.displayImageCommon(box);
		OutputStream oImage = null;
		   

	    try {
	       
	        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	       oImage = response.getOutputStream();
	       if(map.get("imageObj")!=null)
	       {
	    	   
	    	   UploadDocuments item10 = (UploadDocuments)map.get("imageObj");
	    	   byte[] photo = item10.getPatientDocument();
	    	   oImage.write(photo);
	       }
	       else
	       {
	    	   File fi = new File(getServletContext().getRealPath("/jsp/images/photo_icon.png"));
	    	   byte[] fileContent=Files.readAllBytes(fi.toPath());
	    	 
				oImage.write(fileContent);
	       }
	       
	        oImage.flush();
	        oImage.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
	}
	
	public void checkEmpPBNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String empNo = "";
		String exists = "no";
		if (request.getParameter("empNo") != null) {
			empNo = (request.getParameter("empNo"));
		}
		System.out.println("empNo"+empNo);
		dataMap.put("empNo", empNo);
		dataMap.put("exists", exists);
		map = personnelMasterHandlerService.checkEmpPBNo(dataMap);
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
	public ModelAndView generateReportForEmployeeInformation(HttpServletRequest request,HttpServletResponse response)
	{
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		
		Map<String, Object> parameters = new HashMap();
		int hospitalId=0;
		try {
			if(session.getAttribute(HOSPITAL_ID)!=null)
			{
				hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
				//hospital.setId(hospitalId);
			}
			
			//String query = "Where mas_employee.status = 'y' and mas_employee.hospital_Id= "+hospitalId;
			String query = "Where UPPER(mas_employee.status) = 'Y' and mas_employee.hospital_Id= "+hospitalId;
		parameters.put("query", query);

		/*
		 * parameters.put("EmpId", EmpId); parameters.put("Dept",Dept);
		 * parameters.put("DesignationId",DesignationId);
		 * parameters.put("LocationId", LocationId);
		 */

		String userHome = getServletContext().getRealPath("");	         
        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
        parameters.put("path", imagePath);
		
		
		
		Map<String, Object> connectionMap = personnelMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_employee", parameters,
				(Connection) connectionMap.get("conn"), response,
				getServletContext());
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
		/*
	Map mapEmployee = (Map)session.getAttribute("mapEmployee");
	List<MasEmployee> searchEmployeeList = new ArrayList<MasEmployee>();
	if(mapEmployee.get("searchEmployeeList") != null){
		searchEmployeeList = (List)mapEmployee.get("searchEmployeeList");
	}
	
	byte[] bytes = null;
	ServletContext context = request.getSession().getServletContext();
	Map parameters = new HashMap();
	try
	{
		JasperReport jasperReport = HMSUtil.getCompiledReport(context, "employeeInformation");
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(searchEmployeeList);
		bytes = JasperRunManager.runReportToPdf(jasperReport,parameters,ds);
	}
	catch(Exception e)
	{
		e.printStackTrace(); 
	}
	String fileName = "employeeInformation_" + new Date();
	response.setContentType("application/pdf");
	response.setHeader("Content-Disposition","attachment;filename="+fileName);
	
	int b = bytes.length;
	response.setContentLength(b);
	try
	{
		ServletOutputStream ouputStream  = response.getOutputStream();
		
		ouputStream.write(bytes, 0, bytes.length);
		ouputStream.flush();
		ouputStream.close();
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
	return null;*/

}
	

	public ModelAndView showMonthlySuperannuatedReport(
			HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		Map<String, Object> map = personnelMasterHandlerService
				.showEmployeeJsp(hospitalId);
		jsp = "monthly_superannuated_report";
		jsp += ".jsp";
		title = "Employee";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);

	}
	
	
	public ModelAndView printMonthlySuperannuatedReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		int divisionId = 0;
		String serviceNo = "";
		int departmentId=0;
		int deptId=0;
		String query="";
		String  queryDept="";
		if (request.getParameter(SERVICE_NO) != null && !request.getParameter(SERVICE_NO).equals("")) {
			
			serviceNo = request.getParameter(SERVICE_NO);
			query += "and mas_employee.service_no  ='"+serviceNo+"'";
		}
		if (request.getParameter("divisionId") != null	&& !request.getParameter("divisionId").equals("0")) {
			divisionId = Integer.parseInt(request.getParameter("divisionId"));
			 query += "and d.division_id ="+divisionId;
		}
		/*if (!request.getParameter(DEPARTMENT_ID).equals("0")) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		String[] departmentIdArray = null;
		StringBuffer departmentStr = new StringBuffer();
		if (request.getParameterValues(DEPARTMENT_ID) != null
				&& !request.getParameterValues(DEPARTMENT_ID).equals("0")) {
			departmentIdArray = (String[]) (request
					.getParameterValues(DEPARTMENT_ID));
			for (int i = 0; i < departmentIdArray.length; i++) {
				departmentStr.append(departmentIdArray[i]);
				departmentStr.append(",");
			}
			departmentStr.deleteCharAt(departmentStr.length() - 1);
		
			
			
			StringTokenizer str = new StringTokenizer(departmentStr.toString(), ",");
			while (str.hasMoreTokens()) {

				deptId = Integer.parseInt(str.nextToken());
				queryDept = "and d.department_id in("+deptId+")";
				parameters.put("queryDept", queryDept);
				
				
				

			}
		}
		*/
		
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = personnelMasterHandlerService.getConnection();
		
    	String userHome = getServletContext().getRealPath("");	         
        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
        parameters.put("path", imagePath);

		parameters.put("query", query);
		
		parameters.put("queryDept", queryDept);

		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));

		HMSUtil.generateReport("monthly_superannated_report", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	
		
	}
	public ModelAndView showDependentAgeReport(
			HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		Map<String, Object> map = personnelMasterHandlerService
				.showEmployeeJsp(hospitalId);
		jsp = "dependent_age";
		jsp += ".jsp";
		title = "Employee";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);

	}
	
	
	public ModelAndView printDependentAgeReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		int fromAge = 0;
		int toAge=0;
		int divisionId=0;
		String query="";
		
		if (request.getParameter("fromAge") != null && !request.getParameter("fromAge").equals("")) {
			fromAge = Integer.parseInt(request.getParameter("fromAge"));
			
		}
		
			if (request.getParameter("toAge") != null && !request.getParameter("toAge").equals("")) {
			toAge = Integer.parseInt(request.getParameter("toAge"));
			
		}
		if (request.getParameter("divisionId") != null	&& !request.getParameter("divisionId").equals("0")) {
			divisionId = Integer.parseInt(request.getParameter("divisionId"));
			 query += "and d.division_id ="+divisionId;
		}
		
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = personnelMasterHandlerService.getConnection();
		
    	String userHome = getServletContext().getRealPath("");	         
        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
        parameters.put("path", imagePath);

		parameters.put("query", query);
    	parameters.put("fromAge", fromAge);
    	parameters.put("toAge", toAge);
		
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));

		HMSUtil.generateReport("dependent_age", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	
		
	}
	
	public ModelAndView showEmployeeAgeReport(
			HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		Map<String, Object> map = personnelMasterHandlerService
				.showEmployeeJsp(hospitalId);
		jsp = "employee_age";
		jsp += ".jsp";
		title = "Employee";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);

	}
	
	
	public ModelAndView printEmployeeAgeReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		int fromAge = 0;
		int toAge=0;
		int divisionId=0;
		String query="";
		

			if (request.getParameter("fromAge") != null && !request.getParameter("fromAge").equals("")) {
			fromAge = Integer.parseInt(request.getParameter("fromAge"));
			
		}
		
			if (request.getParameter("toAge") != null && !request.getParameter("toAge").equals("")) {
			toAge = Integer.parseInt(request.getParameter("toAge"));
			
		}
		if (request.getParameter("divisionId") != null	&& !request.getParameter("divisionId").equals("0")) {
			divisionId = Integer.parseInt(request.getParameter("divisionId"));
			 query += "and d.division_id ="+divisionId;
		}
		
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = personnelMasterHandlerService.getConnection();
		
    	String userHome = getServletContext().getRealPath("");	         
        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
        parameters.put("path", imagePath);
    	parameters.put("fromAge", fromAge);
    	parameters.put("toAge", toAge);
		parameters.put("query", query);
		
		
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));

		HMSUtil.generateReport("employee_age", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	
		
	}
	
	
	public ModelAndView showEmployeeDetailReport(
			HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		Map<String, Object> map = personnelMasterHandlerService
				.showEmployeeJsp(hospitalId);
		jsp = "employee_detail_report";
		jsp += ".jsp";
		title = "Employee";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);

	}
	
	
	public ModelAndView printEmployeeDetailReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		int empStatusId = 0;
		String serviceNo="";
		int divisionId=0;
		String query="";
		
		if (request.getParameter(EMP_STATUS_ID) != null && !request.getParameter(EMP_STATUS_ID).equals("0")) {
			empStatusId = Integer.parseInt(request.getParameter(EMP_STATUS_ID));
			 query += "and es.emp_status_id ="+empStatusId;
		}
		if (request.getParameter(SERVICE_NO) != null && !request.getParameter(SERVICE_NO).equals("")) {
			serviceNo = request.getParameter(SERVICE_NO);
			query += "and mas_employee.service_no  ='"+serviceNo+"'";
		}
		if (request.getParameter("divisionId") != null	&& !request.getParameter("divisionId").equals("0")) {
			divisionId = Integer.parseInt(request.getParameter("divisionId"));
			 query += "and d.division_id ="+divisionId;
		}
		
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = personnelMasterHandlerService.getConnection();
		
    	String userHome = getServletContext().getRealPath("");	         
        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
        parameters.put("path", imagePath);

		parameters.put("query", query);
		
		
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));

		HMSUtil.generateReport("emp_detail_report", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	
		
	}
	
	

	
	public ModelAndView showEmployeeDependentReport(
			HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		Map<String, Object> map = personnelMasterHandlerService
				.showEmployeeDependentReport(hospitalId);
		jsp = "employee_dependent_report";
		jsp += ".jsp";
		title = "Employee";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);

	}
	
	
	public ModelAndView printEmployeeDependentReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		int dependentId = 0;
		String serviceNo="";
		int divisionId=0;
		String query="";
		
		if (request.getParameter("dependentId") != null	&& !request.getParameter("dependentId").equals("0")) {
			dependentId = Integer.parseInt(request.getParameter("dependentId"));
			 query += "and MAS_EMPLOYEE_DEPENDENT.employee_dependent_id ="+dependentId;
		}
		if (request.getParameter(SERVICE_NO) != null && !request.getParameter(SERVICE_NO).equals("")) {
				serviceNo = request.getParameter(SERVICE_NO);
			query += "and mas_employee.service_no  ='"+serviceNo+"'";
		}
		if (request.getParameter("divisionId") != null	&& !request.getParameter("divisionId").equals("0")) {
			divisionId = Integer.parseInt(request.getParameter("divisionId"));
			 query += "and d.division_id ="+divisionId;
		}
		
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = personnelMasterHandlerService.getConnection();
		
    	String userHome = getServletContext().getRealPath("");	         
        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
        parameters.put("path", imagePath);

		parameters.put("query", query);
		
		
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));

		HMSUtil.generateReport("emp_dependent_detail", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;
	
		
	}
	// ---------------------------Others Category----------------------------
		@SuppressWarnings("unchecked")
		public ModelAndView showOthersCategoryJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			session = request.getSession();
			map = personnelMasterHandlerService.showOthersCategoryJsp();
			@SuppressWarnings("unused")
			ArrayList searchOthersCategoryList = (ArrayList) map
					.get("searchOthersCategoryList");
			jsp = "othersCategory";
			jsp += ".jsp";
			title = "othersCategory";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("indexB", "map", map);
		}

		public ModelAndView searchOthersCategory(HttpServletRequest request,
				HttpServletResponse response) throws ServletRequestBindingException {
			Map<String, Object> map = new HashMap<String, Object>();
			String othersCategoryCode = null;
			String othersCategoryName = null;
			String searchField = null;

			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				othersCategoryCode = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				othersCategoryName = request.getParameter(SEARCH_NAME);
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
				othersCategoryCode = searchField;
				othersCategoryName = null;
			} else {
				othersCategoryCode = null;
				othersCategoryName = searchField;
			}
			map = personnelMasterHandlerService.searchOthersCategory(
					othersCategoryCode, othersCategoryName);
			jsp = "othersCategory";
			jsp += ".jsp";
			map.put("search", "search");
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("othersCategoryCode", othersCategoryCode);
			map.put("othersCategoryName", othersCategoryName);
			return new ModelAndView("indexB", "map", map);
		}

		@SuppressWarnings("unchecked")
		public ModelAndView addOthersCategory(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			MasOthersCategory masOthersCategory = new MasOthersCategory();
			String changedBy = "";
			Map<String, Object> listMap = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Date currentDate = new Date();
			Users user = (Users) session.getAttribute("users");
			int userId = user.getId();
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
			List othersCategoryCodeList = new ArrayList();
			List othersCategoryNameList = new ArrayList();

			if (listMap.get("duplicateGeneralCodeList") != null) {
				othersCategoryCodeList = (List) listMap
						.get("duplicateGeneralCodeList");
			}
			if (listMap.get("duplicateGeneralNameList") != null) {
				othersCategoryNameList = (List) listMap
						.get("duplicateGeneralNameList");
			}
			boolean successfullyAdded = false;
			if ((othersCategoryCodeList.size() == 0 || othersCategoryCodeList == null)
					&& (othersCategoryNameList.size() == 0 || othersCategoryNameList == null)) {
				masOthersCategory.setCategoryCode(code);
				masOthersCategory.setCategoryName(name);
				masOthersCategory.setStatus("y");
				masOthersCategory.setLastChgBy(userId);
				masOthersCategory.setLastChgDate(currentDate);
				masOthersCategory.setLastChgTime(currentTime);
				successfullyAdded = personnelMasterHandlerService
						.addOthersCategory(masOthersCategory);

				if (successfullyAdded) {
					message = "Record Added Successfully !!";
				} else {
					message = "Try Again !!";
				}
			} else if ((othersCategoryCodeList.size() != 0 || othersCategoryCodeList != null)
					|| (othersCategoryNameList.size() != 0)
					|| othersCategoryNameList != null) {
				if ((othersCategoryCodeList.size() != 0 || othersCategoryCodeList != null)
						&& (othersCategoryNameList.size() == 0 || othersCategoryNameList == null)) {
					message = "Others Category Code  already exists.";
				} else if ((othersCategoryNameList.size() != 0 || othersCategoryNameList != null)
						&& (othersCategoryCodeList.size() == 0 || othersCategoryCodeList == null)) {
					message = "Others Category Name already exists.";
				} else if ((othersCategoryCodeList.size() != 0 || othersCategoryCodeList != null)
						&& (othersCategoryNameList.size() != 0 || othersCategoryNameList != null)) {
					message = "Others Category Code and Others Category Name already exist.";
				}

			}
			url = "/hms/hms/personnel?method=showOthersCategoryJsp";
			try {
				map = personnelMasterHandlerService.showOthersCategoryJsp();
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "othersCategory";
			title = "Add Others Category";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}

		public ModelAndView editOthersCategory(HttpServletRequest request,
				HttpServletResponse response) {

			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();

			session = request.getSession();
			String othersCategoryCode = "";
			String othersCategoryName = "";
			int othersCategoryId = 0;
			//String changedBy = "";
			Users user = (Users) session.getAttribute("users");
			int userId = user.getId();
			Date changedDate = null;
			String changedTime = "";
			othersCategoryCode = (String) session.getAttribute("othersCategoryCode");

			othersCategoryName = (String) session.getAttribute("othersCategoryName");
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				othersCategoryId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				othersCategoryCode = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				othersCategoryName = request.getParameter(SEARCH_NAME);
			}
			/*if (request.getParameter(CHANGED_BY) != null
					&& !(request.getParameter(CHANGED_BY).equals(""))) {
				changedBy = request.getParameter(CHANGED_BY);
			}*/
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

			generalMap.put("id", othersCategoryId);
			generalMap.put("othersCategoryCode", othersCategoryCode);
			generalMap.put("name", othersCategoryName);
			generalMap.put("userId", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			Map<String, Object> listMap = new HashMap<String, Object>();
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
			generalMap.put("flag", true);

			listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);
			List existingOthersCategoryNameList = (List) listMap
					.get("duplicateMastersList");

			boolean dataUpdated = false;
			if (existingOthersCategoryNameList.size() == 0) {

				dataUpdated = personnelMasterHandlerService
						.editOthersCategoryToDatabase(generalMap);

				if (dataUpdated == true) {
					message = "Data updated Successfully !!";
				} else {
					message = "Data Cant Be Updated !!";
				}
			} else if (existingOthersCategoryNameList.size() > 0) {
				message = "Name already exists.";
			}
			url = "/hms/hms/personnel?method=showOthersCategoryJsp";
			try {
				map = personnelMasterHandlerService.showOthersCategoryJsp();
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "othersCategory";
			title = "update OthersCategory";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);

		}

		public ModelAndView deleteOthersCategory(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			int othersCategoryId = 0;
			String message = null;
			//String changedBy = "";
			Users user = (Users) session.getAttribute("users");
			int userId = user.getId();
		
			String changedTime = "";
			Date changedDate = null;
			String flag = "";
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
				generalMap.put("flag", flag);
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				othersCategoryId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			if (request.getParameter("title") != null) {
				title = request.getParameter("title");
			}
		/*	if (request.getParameter(CHANGED_BY) != null
					&& !(request.getParameter(CHANGED_BY).equals(""))) {
				changedBy = request.getParameter(CHANGED_BY);
			}*/
			changedDate = new Date();
			changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");

			generalMap.put("userId", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			boolean dataDeleted = false;
			dataDeleted = personnelMasterHandlerService.deleteOthersCategory(
					othersCategoryId, generalMap);
			if (dataDeleted == true) {
				message = "Record is InActivated Successfully !!";
			} else {
				message = "Record is Activated Successfully !!";
			}
			url = "/hms/hms/personnel?method=showOthersCategoryJsp";
			try {
				map = personnelMasterHandlerService.showOthersCategoryJsp();
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "othersCategory";
			title = "Delete Others Category";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);
		}
		
		
		public void fillEmployee(HttpServletRequest request,
				HttpServletResponse response) {
			// ---- Retriving User Name,Hospital Id,Department Id from Session--

			String userName = "";
			int deptId = 0;
			int hospitalId = 0;
			int a_stock=0;
			HttpSession session = request.getSession();
			if (session.getAttribute("userName") != null)
				userName = (String) session.getAttribute("userName");
			if (session.getAttribute("hospitalId") != null)
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			if (session.getAttribute("deptId") != null)
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			// --------------------------------------------------------------------------------
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();

			Box box = HMSUtil.getBox(request);
			String itemNameField = "";
			String employeeNo = "";
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("employeeNo") != null) {
				employeeNo = (request.getParameter("employeeNo"));
			}
			dataMap.put("employeeNo", employeeNo);
			dataMap.put("deptId", deptId);
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			map = personnelMasterHandlerService.fillEmployee(dataMap);

			if (map.get("employeeList") != null) {
				employeeList = (List) map.get("employeeList");
			}
			
			StringBuffer sb = new StringBuffer();
			try {
				for (MasEmployee masEmployee : employeeList) {
					sb.append("<item>");
					sb.append("<empName>" + masEmployee.getFirstName() + "</empName>");
					/*if(!masEmployee.getMiddleName().equals("") && masEmployee.getLastName().equals("") && !masEmployee.getFirstName().equals("") ){
					sb.append("<empName>" + masEmployee.getFirstName()+" "+masEmployee.getMiddleName() + "</empName>");
					}
					else if(!masEmployee.getLastName().equals("") && masEmployee.getMiddleName().equals("") && !masEmployee.getFirstName().equals("") ){
						sb.append("<empName>" + masEmployee.getFirstName()+" "+masEmployee.getLastName() + "</empName>");
					}
					else if(!masEmployee.getLastName().equals("") && !masEmployee.getMiddleName().equals("") && !masEmployee.getFirstName().equals("") ){
						sb.append("<empName>" + masEmployee.getFirstName()+" "+masEmployee.getMiddleName() +" "+masEmployee.getLastName() + "</empName>");
					}
					else{
						sb.append("<empName>" + masEmployee.getFirstName() + "</empName>");
					}*/
				
					sb.append("<id>" + masEmployee.getId() + "</id>");
					sb.append("<empNo>" + masEmployee.getServiceNo() + "</empNo>");
				
					sb.append("</item>");
				}

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
		
		public ModelAndView getEmployeeList(
				HttpServletRequest request, HttpServletResponse response) {
			// --------------- Retriving User Name,Hospital Id,Department Id from
			// Session-----
			String userName = "";
			int deptId = 0;
			int hospitalId = 0;

			HttpSession session = request.getSession();
			if (session.getAttribute("userName") != null)
				userName = (String) session.getAttribute("userName");
			if (session.getAttribute("hospitalId") != null)
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			if (session.getAttribute("deptId") != null)
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			// --------------------------------------------------------------------------------
			String itemNameField = "";
			String autoHint = "";
			// int returnId = 0;
			Map<String, Object> dataMap = new HashMap<String, Object>();
			try {
				if (request.getParameter("requiredField") != null) {
					itemNameField = (request.getParameter("requiredField"));
				}
				if (request.getParameter(itemNameField) != null) {
					autoHint = (request.getParameter(itemNameField));
				}
				/*
				 * if (request.getParameter("returnId") != null) { returnId =
				 * Integer.parseInt(""+ (request.getParameter("returnId"))); }
				 */
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				dataMap.put("autoHint", autoHint);
				dataMap.put("deptId", deptId);
				dataMap.put("userName", userName);
				dataMap.put("hospitalId", hospitalId);
				// dataMap.put("returnId",returnId);

				map = personnelMasterHandlerService.getEmployeeList(dataMap);
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "resultForEmployee";
			return new ModelAndView(jsp, "map", map);
		}
	// --------------------------------------------------------------------------------------------
	public PersonnelMasterHandlerService getPersonnelMasterHandlerService() {
		return personnelMasterHandlerService;
	}

	public void setPersonnelMasterHandlerService(
			PersonnelMasterHandlerService personnelMasterHandlerService) {
		this.personnelMasterHandlerService = personnelMasterHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}
	
	public ModelAndView ReadImage(HttpServletRequest request, HttpServletResponse response) 
	{
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		Box box = HMSUtil.getBox(request);
		
		dataMap= personnelMasterHandlerService.ReadImage(box);
		return null;
	}
	

	
	public ModelAndView showOraclePage(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		//int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
		
		String jsp = "";
		jsp = "ReadImage.jsp";
		map.put("contentJsp", jsp);
		
		return new ModelAndView("index","map",map);
	}
	
	
	@SuppressWarnings("unchecked")
	public ModelAndView showEmployeeReadonlyJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		Map<String, Object> map = personnelMasterHandlerService
				.showEmployeeJsp(hospitalId);
		jsp = "employee_readonly";
		jsp += ".jsp";
		title = "Employee";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);

	}
	
	
	@SuppressWarnings("unchecked")
	public ModelAndView showEmployeeDependentReadonlyJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = personnelMasterHandlerService
				.showEmployeeDependentJsp();
		@SuppressWarnings("unused")
		ArrayList searchEmployeeDependentList = (ArrayList) map
				.get("searchEmployeeDependentList");
		jsp = "employeeDependent_readonly";
		jsp += ".jsp";
		title = "Employee Dependent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	
	// Rahul : Adding Employee pay structure 
	
	public ModelAndView showEmployeePayStructureJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession(true);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String centreId =""+session.getAttribute("hospitalId");
		dataMap.put("centreId",centreId);
		Map<String, Object> map = personnelMasterHandlerService.showEmployeePayStructureJsp(dataMap);
		jsp = EMPLOYEE_PAY_STRUCTURE_JSP;
		jsp += ".jsp";
		title = "Employee Pay Structure";
		
		map.put("contentJsp",jsp);
		map.put("title", title);
		
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView searchEmployeePayStructure(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();	
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Integer employeeId  = null;
		
		employeeId = new Integer(request.getParameter("employeeCodeSearch"));
		String centreId =""+session.getAttribute("hospitalId");
		dataMap.put("centreId",centreId);
		dataMap.put("employeeId",employeeId);
		map = personnelMasterHandlerService.searchEmployeePayStructure(dataMap);
		jsp = EMPLOYEE_PAY_STRUCTURE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView addEmployeePayStructure(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		
		Integer employeePayStructureId = 0;
		Integer employeeId = 0;
		Integer payrollId = 0;
		BigDecimal basicPay = new BigDecimal(0);
		String paymentMode = "";
		Date fromdate = null;
		Date toDate = null;
		
		session = request.getSession(true);
		
		if(request.getParameter(COMMON_ID) != null && !request.getParameter(COMMON_ID).equals("")) {
			employeePayStructureId =new Integer(request.getParameter(COMMON_ID));
		}
		if(request.getParameter(EMPLOYEE_ID) != null) {
			employeeId=new Integer(request.getParameter(EMPLOYEE_ID));
		}
		if(request.getParameter(PAYROLL_ID) != null) {
			payrollId = new Integer(request.getParameter(PAYROLL_ID));
		}
		if(request.getParameter(BASIC_PAY) != null) {
			basicPay= new BigDecimal(request.getParameter(BASIC_PAY));
		}
		if(request.getParameter(PAYMENT_MODE) != null) {
			paymentMode = request.getParameter(PAYMENT_MODE);
		}
		if(request.getParameter(PAY_STR_FROM_DATE) != null) {
			fromdate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(PAY_STR_FROM_DATE));
		}
		if(request.getParameter(PAY_STR_TO_DATE) != null) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(PAY_STR_TO_DATE));
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String centreId =""+session.getAttribute("hospitalId");
		dataMap.put("centreId",centreId);
		
		HrEmployeePayStructure employeePayStructure = null;
		if(employeePayStructureId.equals(0))
		{
			employeePayStructure = new HrEmployeePayStructure();
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			employeePayStructure.setEmployee(masEmployee);
		}
		else
		{
			employeePayStructure = personnelMasterHandlerService.getEmployeePayStructure(employeePayStructureId);
		}
		
		
		HrMasPayroll payroll = new HrMasPayroll();
		payroll.setId(payrollId);
		
		
		
		if(!payrollId.equals(0)){
		employeePayStructure.setPayroll(payroll);
		}
		
		if(!centreId.equals("0"))
		{
			MasHospital mh = new MasHospital();
			mh.setId(Integer.parseInt(centreId));
			employeePayStructure.setHospital(mh);
		}
		employeePayStructure.setBasicPay(basicPay);
		employeePayStructure.setPaymentMode(paymentMode);
		employeePayStructure.setFromDate(fromdate);
		employeePayStructure.setToDate(toDate);
		employeePayStructure.setStatus("y");
		
		
		personnelMasterHandlerService.addEmployeePayStructure(employeePayStructure);
		String message = "";
		if(employeePayStructureId.equals(0)){
			 message = "Pay Structure has been added for employee - "+ employeePayStructure.getEmployee().getFirstName() +" "+employeePayStructure.getEmployee().getLastName() ;
		}
		else
		{
			message = "Pay Structure has been updated for employee - "+ employeePayStructure.getEmployee().getFirstName() +" "+employeePayStructure.getEmployee().getLastName() ;
		}
		String jsp = EMPLOYEE_PAY_STRUCTURE_JSP;
		jsp+=".jsp";
		Map<String, Object> map = personnelMasterHandlerService.showEmployeePayStructureJsp(dataMap);
		map.put("contentJsp", jsp);
		map.put("message",message);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView deleteEmployeePayStructure(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int employeePayStructureId=0;
		String message = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			employeePayStructureId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
	
		
		Users user=null;
		if (session.getAttribute("users")!= null) {
			 user = (Users)session.getAttribute("users");
		
		}
		
		
		
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", user);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=personnelMasterHandlerService.deleteEmployeePayStructure(employeePayStructureId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showEmployeePayStructureJsp";
		
		try{
			Map<String, Object> dataMap = new HashMap<String, Object>();
			String centreId =""+session.getAttribute("hospitalId");
			dataMap.put("centreId",centreId);
			map = personnelMasterHandlerService.showEmployeePayStructureJsp(dataMap);
		   
		  }catch (Exception e) {
		   e.printStackTrace();
		  }
		  jsp=EMPLOYEE_PAY_STRUCTURE_JSP;
		  title="Delete Employee Pay Structure";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
}
	
	// Rahul Adding Pay Element of employee
	
	
	@SuppressWarnings("unchecked")
	public ModelAndView showEmployeePayElementJsp(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession(true);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String centreId =""+session.getAttribute("hospitalId");
		dataMap.put("centreId",centreId);
		Map<String, Object> map = personnelMasterHandlerService.showEmployeePayElementsJsp(dataMap);
		jsp = EMPLOYEE_PAY_ELEMENTS_JSP;
		jsp += ".jsp";
		title = "Employee Pay Elements";
		
		map.put("contentJsp",jsp);
		map.put("title", title);
		
		return new ModelAndView("index", "map", map);

	}
	
	public ModelAndView searchEmployeePayElement(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Map<String, Object> map= new HashMap<String, Object>();	
		Map<String, Object> mapEmployee = new HashMap<String, Object>();	
		Integer employeeId  = null;
		
		employeeId = new Integer(request.getParameter(EMPLOYEE_CODE));
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String centreId =""+session.getAttribute("hospitalId");
		dataMap.put("centreId",centreId);
		dataMap.put("employeeId",employeeId);
		map = personnelMasterHandlerService.searchEmployeePayElement(dataMap);

		jsp = EMPLOYEE_PAY_ELEMENTS_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp",jsp);
		map.put("title", title);
		//map.put("employeeCode",employeeCode);
		
	
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView addEmployeePayElement(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException 
	{
		Integer commonId = 0;
		Integer employeeId = 0;
		Integer payElementId = 0;
		BigDecimal payAmount = new BigDecimal(0);
		Date payElementStartDate = null;
		String  payElementType = "";
		
		
		session = request.getSession(true);
		if(request.getParameter(COMMON_ID) != null && request.getParameter(COMMON_ID)!="0") {
			commonId = new Integer(request.getParameter(COMMON_ID));
		}
		if(request.getParameter(EMPLOYEE_ID) != null) {
			employeeId=new Integer(request.getParameter(EMPLOYEE_ID));
		}
		if(request.getParameter(PAY_ELEMENT_CODE) != null) {
			payElementId = new Integer(request.getParameter(PAY_ELEMENT_CODE));
		}
		if(request.getParameter(PAY_AMOUNT) != null && !request.getParameter(PAY_AMOUNT).trim().equals("")) {
			payAmount = new BigDecimal(request.getParameter(PAY_AMOUNT));
		}
		if(request.getParameter(PAY_ELEMENT_START_DATE) != null) {
			payElementStartDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(PAY_ELEMENT_START_DATE));
		}
		if(request.getParameter(PAY_ELEMENT_TYPE) != null) {
			payElementType = request.getParameter(PAY_ELEMENT_TYPE);
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String centreId =""+session.getAttribute("hospitalId");
		dataMap.put("centreId",centreId);
		HrEmployeePayElements employeePayElement = null;
		HrEmployeePayElements employeePayElement2 = new HrEmployeePayElements();
		if(commonId.equals(0))
		{
			employeePayElement = new HrEmployeePayElements();
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
		    employeePayElement.setEmployee(masEmployee);
			
		}
		else
		{
			employeePayElement = personnelMasterHandlerService.getEmployeePayElement(commonId);
			
		}
		 
		if(!centreId.equals("0"))
		{
			MasHospital mh = new MasHospital();
			mh.setId(Integer.parseInt(centreId));
			employeePayElement.setCompany(mh);
			
		}
		System.out.println(payElementId);
		if(!payElementId.equals(0))
		{
			// Commenting below code by rahul due to no concept of FIX EPF in KSSC
			//add for PF calculation for fixed amount upto 678
			//Start condition
			/*if(payElementId.equals(8)){
				BigDecimal maxAmount = personnelMasterHandlerService.getPfMaxAmunt(8);
					if(payAmount.compareTo(maxAmount) > 0){
					BigDecimal paidAmt = new BigDecimal("0");
					paidAmt = payAmount.subtract(maxAmount);
					HrMasPayElement payElement = new HrMasPayElement();
					payElement.setId(payElementId);
					employeePayElement.setPayElement(payElement);
					employeePayElement.setPayAmount(maxAmount);
					employeePayElement.setPayElementType(payElementType);
					employeePayElement.setStartDate(payElementStartDate);
					employeePayElement.setStatus("y");
				
					//System.out.println("employeeId--"+employeeId);
					
					employeePayElement2 =  personnelMasterHandlerService.getEmployeePayElementForALPF(employeeId);
					
					
					MasEmployee masEmployee2 = new MasEmployee();
					masEmployee2.setId(employeeId);
					employeePayElement2.setEmployee(masEmployee2);
					HrMasPayElement payElement2 = new HrMasPayElement();
					payElement2.setId(17);
					employeePayElement2.setPayElement(payElement2);
					employeePayElement2.setPayAmount(paidAmt);
					employeePayElement2.setPayElementType("addition");
					employeePayElement2.setStartDate(payElementStartDate);
					employeePayElement2.setStatus("y");
				}
				else{
						HrMasPayElement payElement = new HrMasPayElement();
						payElement.setId(payElementId);
						employeePayElement.setPayElement(payElement);
						employeePayElement.setPayAmount(payAmount);
						employeePayElement.setPayElementType(payElementType);
						employeePayElement.setStartDate(payElementStartDate);
						employeePayElement.setStatus("y");
				}
			}
			*/
			//end condition
			
					HrMasPayElement payElement = new HrMasPayElement();
					payElement.setId(payElementId);
					employeePayElement.setPayElement(payElement);
					employeePayElement.setPayAmount(payAmount);
					employeePayElement.setPayElementType(payElementType);
					employeePayElement.setStartDate(payElementStartDate);
					employeePayElement.setStatus("y");
				
		}
		String message = "";
		Map returnMap = new HashMap();
		Map returnMap2 = new HashMap();
		try{
			 returnMap = personnelMasterHandlerService.addEmployeePayElement(employeePayElement);
			 /*if(payAmount.doubleValue() > 678.00){
				 returnMap2 = personnelMasterHandlerService.addEmployeePayElement(employeePayElement);
			 }*/
			 if(commonId.equals(0)){
			 			
				message = "Employee Pay Element has been added Successfully for employee -- " + employeePayElement.getEmployee().getFirstName()+" "+employeePayElement.getEmployee().getLastName();
			}
			else
			message = "Employee Pay Element has been modified Successfully for employee --" + employeePayElement.getEmployee().getFirstName()+" "+employeePayElement.getEmployee().getLastName(); 
		}
		catch (Exception e) {
			message = "Problem in the transaction !!";
			e.printStackTrace();
		}
		if(returnMap.get("messageForDuplicate")!=null)
		{
			message = (String)returnMap.get("messageForDuplicate");
		}
		map = personnelMasterHandlerService.returnSingleEmployeePayElement(employeeId);
		List<HrEmployeePayElements> searchEmployeePayElementsList  = new ArrayList<HrEmployeePayElements>();
		if(map.get("searchEmployeePayElementsList")!= null){
			searchEmployeePayElementsList = (List)map.get("searchEmployeePayElementsList");
		}
		//System.out.println("searchEmployeePayElementsList in after method====="+searchEmployeePayElementsList.size());
		
		String jsp = EMPLOYEE_PAY_ELEMENTS_JSP;
		jsp+=".jsp";
		Map<String, Object> map = personnelMasterHandlerService.showEmployeePayElementsJsp(dataMap);
		map.put("contentJsp", jsp);
		map.put("message", message);
		//map.put("searchEmployeePayElementsList", searchEmployeePayElementsList);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView deleteEmployeePayElement(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int employeePayElementId=0;
		String message = "";
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag =""; 
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag"); 
			generalMap.put("flag", flag);
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			employeePayElementId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		/*if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}*/
		Users user=null;
		if (session.getAttribute("users")!= null) {
			 user = (Users)session.getAttribute("users");
		
		}
		changedDate= new Date();
		changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 

		generalMap.put("changedBy", user);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted=false;
		dataDeleted=personnelMasterHandlerService.deleteEmployeePayElement(employeePayElementId,generalMap);
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}
		else{
			message="Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showEmployeePayElementJsp";
		
		try{
			Map<String, Object> dataMap = new HashMap<String, Object>();
			String centreId =""+session.getAttribute("hospitalId");
			dataMap.put("centreId",centreId);
			map = personnelMasterHandlerService.showEmployeePayElementsJsp(dataMap);
		   
		  }catch (Exception e) {
		   e.printStackTrace();
		  }
		  jsp=EMPLOYEE_PAY_ELEMENTS_JSP;
		  title="Delete Employee Pay Element";
		  jsp += ".jsp";
		  map.put("contentJsp", jsp);
		  map.put("title", title);
		  map.put("message", message);
		  return new ModelAndView("index", "map", map);
}
	

}