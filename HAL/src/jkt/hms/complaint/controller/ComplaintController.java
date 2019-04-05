package jkt.hms.complaint.controller;

import static jkt.hms.util.RequestConstants.BUILDING_NO;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMANDANT_REMARK_JSP;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.COMPLAINT_CRITERIA;
import static jkt.hms.util.RequestConstants.COMPLAINT_DATE;
import static jkt.hms.util.RequestConstants.COMPLAINT_DETAILS;
import static jkt.hms.util.RequestConstants.COMPLAINT_LOCATION;
import static jkt.hms.util.RequestConstants.COMPLAINT_NO;
import static jkt.hms.util.RequestConstants.COMPLAINT_REGISTER_JSP;
import static jkt.hms.util.RequestConstants.COMPLAINT_TIME;
import static jkt.hms.util.RequestConstants.COMPLAINT_TYPE;
import static jkt.hms.util.RequestConstants.COMPLAINT_TYPE_JSP;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DEPARTMENT_NAME;
import static jkt.hms.util.RequestConstants.DEPARTMENT_TYPE_ID;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.OLD_COMPLAINT_DATE;
import static jkt.hms.util.RequestConstants.OLD_COMPLAINT_NUMBER;
import static jkt.hms.util.RequestConstants.PDC_OVER;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.SERVICE_PERSON;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.WORK_COMPLETION_JSP;
import static jkt.hms.util.RequestConstants.WORK_NOT_COMPLETION_JSP;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.complaint.handler.ComplaintHandlerService;
import jkt.hms.masters.business.ComplaintRegister;
import jkt.hms.masters.business.MasComplaintRegister;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasSmq;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ComplaintController extends MultiActionController {

	private static final int Id = 0;
	private ComplaintHandlerService complaintHandlerService = null;
	private CommonMasterHandlerService commonMasterHandlerService = null;

	@SuppressWarnings("unchecked")
	public ModelAndView showComplaintTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		map = complaintHandlerService.showComplaintTypeJsp();
		jsp = COMPLAINT_TYPE_JSP;
		jsp += ".jsp";
		title = "ComplaintType";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchComplaintType(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String complaintTypeCode = null;
		String complaintTypeName = null;
		String searchField = null;
		String jsp = "";
		String title = "";

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			complaintTypeCode = request.getParameter(CODE);
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
			complaintTypeCode = searchField;
			complaintTypeName = null;
		} else {
			complaintTypeCode = null;
			complaintTypeName = searchField;
		}

		map = complaintHandlerService.searchComplaintType(complaintTypeCode,
				complaintTypeName);
		jsp = COMPLAINT_TYPE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("complaintTypeCode", complaintTypeCode);
		map.put("complaintTypeName", complaintTypeName);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView addComplaintType(HttpServletRequest request,
			HttpServletResponse response) {
		String complaintTypeCode = "";
		String complaintTypeName = "";
		int departmentName = 0;
		String pojoPropertyCode = "";
		String jsp = "";
		String title = "";
		String message = " ";
		String pojoName = "";
		String pojoPropertyName = "";
		String lstChangedTime = "";
		String lstChangedBy = "";
		Date lstChangedDate = new Date();

		Map<String, Object> map = new HashMap<String, Object>();
		MasComplaintsType masComplaintsType = new MasComplaintsType();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		if (request.getParameter(CODE) != null) {
			complaintTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			complaintTypeName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(DEPARTMENT_TYPE_ID) != null) {
			departmentName = Integer.parseInt(request
					.getParameter(DEPARTMENT_TYPE_ID));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			lstChangedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			lstChangedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			lstChangedTime = request.getParameter(CHANGED_TIME);
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
		dataMap.put("complaintTypeCode", complaintTypeCode);
		dataMap.put("complaintTypeName", complaintTypeName);
		dataMap.put("code", complaintTypeCode);
		dataMap.put("name", complaintTypeName);
		dataMap.put("departmentName", departmentName);
		dataMap.put("lstChangedBy", lstChangedBy);
		dataMap.put("lstChangedDate", lstChangedDate);
		dataMap.put("lstChangedTime", lstChangedTime);
		dataMap.put("pojoPropertyName", pojoPropertyName);
		dataMap.put("pojoPropertyCode", pojoPropertyCode);
		dataMap.put("pojoName", pojoName);
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		listMap = commonMasterHandlerService.checkForExistingMasters(dataMap);

		List complaintTypeCodeList = new ArrayList();
		List complaintTypeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			complaintTypeCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			complaintTypeNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((complaintTypeCodeList.size() == 0 || complaintTypeCodeList == null)
				&& (complaintTypeNameList.size() == 0 || complaintTypeNameList == null)) {
			masComplaintsType.setComplaintTypeCode(complaintTypeCode);
			masComplaintsType.setComplaintTypeName(complaintTypeName);

			masComplaintsType.setStatus("y");
			masComplaintsType.setLstChangedBy(lstChangedBy);
			masComplaintsType.setLstChangedDate(lstChangedDate);
			masComplaintsType.setLstChangedTime(lstChangedTime);
			map = complaintHandlerService.addComplaintType(dataMap);
			successfullyAdded = true;
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			}
		}

		else if ((complaintTypeCodeList.size() != 0 || complaintTypeCodeList != null)
				|| (complaintTypeNameList.size() != 0)
				|| complaintTypeNameList != null) {

			if ((complaintTypeCodeList.size() != 0 || complaintTypeCodeList != null)
					&& (complaintTypeNameList.size() == 0 || complaintTypeNameList == null)) {

				message = "Complaint Code  already exists.";
			} else if ((complaintTypeNameList.size() != 0 || complaintTypeNameList != null)
					&& (complaintTypeCodeList.size() == 0 || complaintTypeCodeList == null)) {

				message = "Complaint Name already exists.";
			} else if ((complaintTypeCodeList.size() != 0 || complaintTypeCodeList != null)
					&& (complaintTypeNameList.size() != 0 || complaintTypeNameList != null)) {

				message = "Complaint Code and Complaint Name already exist.";
			}
		}

		try {
			map = complaintHandlerService.showComplaintTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COMPLAINT_TYPE_JSP;
		title = "Complaint Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editComplaintType(HttpServletRequest request,
			HttpServletResponse response) {

		String complaintTypeCode = "";
		String complaintTypeName = "";
		String departmentName = "";

		String jsp = "";
		String title = "";
		String message = " ";

		String pojoName = "";
		String pojoPropertyName = "";

		HttpSession session = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();

		int complaintId = 0;
		String lstChangedTime = "";
		String lstChangedBy = "";
		Date lstChangedDate = new Date();

		complaintTypeCode = (String) session.getAttribute("complaintTypeCode");
		complaintTypeName = (String) session.getAttribute("complaintTypeName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			complaintId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			complaintTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			complaintTypeName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			lstChangedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			lstChangedTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			lstChangedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		String[] departmentIdArray = null;
		StringBuffer deptStr = new StringBuffer();

		if (request.getParameterValues(DEPARTMENT_TYPE_ID) != null
				&& request.getParameterValues(DEPARTMENT_TYPE_ID).length > 0) {
			departmentIdArray = (String[]) (request
					.getParameterValues(DEPARTMENT_TYPE_ID));

			for (int i = 0; i < departmentIdArray.length; i++) {
				deptStr.append(departmentIdArray[i]);
				deptStr.append(",");
			}
			deptStr.deleteCharAt(deptStr.length() - 1);
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
		lstChangedDate = new Date();
		lstChangedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", complaintId);
		generalMap.put("complaintTypeCode", complaintTypeCode);
		generalMap.put("complaintTypeName", complaintTypeName);
		generalMap.put("deptStr", deptStr.toString());
		generalMap.put("departmentName", departmentName);
		generalMap.put("lstChangedBy", lstChangedBy);
		generalMap.put("lstChangedDate", lstChangedDate);
		generalMap.put("lstChangedTime", lstChangedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyRemark", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingComplaintTypeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingComplaintTypeNameList.size() == 0) {

			dataUpdated = complaintHandlerService
					.editComplaintTypeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingComplaintTypeNameList.size() > 0) {

			message = "Name already exists.";
		}

		try {
			map = complaintHandlerService.showComplaintTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COMPLAINT_TYPE_JSP;
		title = "Edit Complaint type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteComplaintType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int complaintId = 0;
		String message = null;
		String lstChangedTime = "";
		String lstChangedBy = "";
		Date lstChangedDate = new Date();

		String jsp = "";
		String title = "";

		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			complaintId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			lstChangedBy = request.getParameter(CHANGED_BY);
		}
		lstChangedDate = new Date();
		lstChangedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("lstChangedBy", lstChangedBy);
		generalMap.put("lstChangedDate", lstChangedDate);
		generalMap.put("currentTime", lstChangedTime);
		boolean dataDeleted = false;
		dataDeleted = complaintHandlerService.deleteComplaintType(complaintId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}

		try {
			map = complaintHandlerService.showComplaintTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COMPLAINT_TYPE_JSP;
		title = "Delete Complaint Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView showComplaintRegisterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		String complaintEntryNo = "";
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		int empId = 0;
		if (users != null) {
			empId = users.getEmployee().getId();
		}
		map = complaintHandlerService.showComplaintRegisterJsp(empId);
		complaintEntryNo = complaintHandlerService.generateComplaintNo(infoMap);
		jsp = COMPLAINT_REGISTER_JSP;
		jsp += ".jsp";
		title = "ComplaintRegister";
		map.put("contentJsp", jsp);
		map.put("complaintEntryNo", complaintEntryNo);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchComplaintRegister(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String complaintNo = null;
		String complaintDesc = null;
		String searchField = null;
		String jsp = "";
		String title = "";

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			complaintNo = request.getParameter(CODE);
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
			complaintNo = searchField;
			complaintDesc = null;
		} else {
			complaintNo = null;
			complaintDesc = searchField;
		}
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		int empId = 0;
		if (users != null) {
			empId = users.getEmployee().getId();
		}
		map = complaintHandlerService.searchComplaintRegister(complaintNo,
				complaintDesc, empId);
		jsp = COMPLAINT_REGISTER_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("complaintNo", complaintNo);
		map.put("complaintDesc", complaintDesc);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView addComplaintRegister(HttpServletRequest request,
			HttpServletResponse response) {
		String complaintNo = "";
		int departmentName = 0;
		Date complaintDate = null;
		String complaintTime = "";
		int complaintType = 0;
		String complaintCriteria = "";
		String serviceNo = "";
		String personName = "";
		String oldComplaintNo = "";
		Date oldComplaintDate = null;
		int buildingNo = 0;
		String complaintDetails = "";
		String complaintLocation = "";

		String pojoPropertyCode = "";
		String jsp = "";
		String title = "";
		String message = " ";
		String pojoName = "";
		String pojoPropertyName = "";
		String lstChangedTime = "";
		String lstChangedBy = "";
		Date lstChangedDate = new Date();

		Map<String, Object> map = new HashMap<String, Object>();
		MasComplaintRegister masComplaintRegister = new MasComplaintRegister();
		int count = 0;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List<ComplaintRegister> complaintRegister = new ArrayList<ComplaintRegister>();

		Box box = HMSUtil.getBox(request);
		if (request.getParameter(COMPLAINT_CRITERIA) != null
				&& request.getParameter(COMPLAINT_CRITERIA).equalsIgnoreCase(
						"repeat")) {
			Vector<String> v1 = box.getVector(OLD_COMPLAINT_NUMBER);
			Vector<String> v2 = box.getVector(OLD_COMPLAINT_DATE);
			for (int i = 0; i < 3; i++) {
				ComplaintRegister compRegister = new ComplaintRegister();
				if (v1.get(i) != null && v1.get(i).equalsIgnoreCase(""))
					compRegister.setOldComplaintNo(v1.get(i));
				if (v2.get(i) != null && v2.get(i).equalsIgnoreCase(""))
					compRegister.setOldComplaintDate(HMSUtil
							.convertStringTypeDateToDateType(v2.get(i)));
				//System.out.println("old no" + compRegister.getOldComplaintNo());
				//System.out.println("old Date"+ compRegister.getOldComplaintDate());
				complaintRegister.add(compRegister);
			}

			for (int i = 0; i < v1.size(); i++) {
				if (!v1.get(i).toString().equals("")) {
					count++;
					//System.out.println("countyyyyyyyyy" + count);
				}
			}
		}
		//System.out.println("count" + count);
		if (count == 3) {
			masComplaintRegister.setStatus("r");
		} else {
			masComplaintRegister.setStatus("p");
		}

		if (request.getParameter(CODE) != null) {
			complaintNo = request.getParameter(CODE);
		}
		if (request.getParameter(COMPLAINT_NO) != null) {
			complaintNo = request.getParameter(COMPLAINT_NO);
		}
		if (request.getParameter(COMPLAINT_DATE) != null
				&& !(request.getParameter(COMPLAINT_DATE).equals(""))) {
			complaintDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(COMPLAINT_DATE));
		}
		if (request.getParameter(COMPLAINT_TIME) != null) {
			complaintTime = request.getParameter(COMPLAINT_TIME);
		}
		if (request.getParameter(COMPLAINT_LOCATION) != null) {
			complaintLocation = request.getParameter(COMPLAINT_LOCATION);
		}
		if (request.getParameter(DEPARTMENT_NAME) != null) {
			departmentName = Integer.parseInt(request
					.getParameter(DEPARTMENT_NAME));
		}

		if (request.getParameter(COMPLAINT_TYPE) != null) {
			complaintType = Integer.parseInt(request
					.getParameter(COMPLAINT_TYPE));
		}
		if (request.getParameter(COMPLAINT_CRITERIA) != null) {
			complaintCriteria = request.getParameter(COMPLAINT_CRITERIA);
		}
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (request.getParameter(SERVICE_PERSON) != null) {
			personName = request.getParameter(SERVICE_PERSON);
		}
		if (request.getParameter(BUILDING_NO) != null
				&& !request.getParameter(BUILDING_NO).equals("")) {
			buildingNo = Integer.parseInt(request.getParameter(BUILDING_NO));
		}
		if (request.getParameter(COMPLAINT_DETAILS) != null) {
			complaintDetails = request.getParameter(COMPLAINT_DETAILS);
		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			lstChangedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			lstChangedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			lstChangedTime = request.getParameter(CHANGED_TIME);
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
		generalMap.put("complaintNo", complaintNo);
		generalMap.put("complaintDate", complaintDate);
		generalMap.put("complaintTime", complaintTime);
		generalMap.put("complaintLocation", complaintLocation);
		generalMap.put("departmentName", departmentName);
		generalMap.put("complaintType", complaintType);
		generalMap.put("buildingNo", buildingNo);
		generalMap.put("personName", personName);
		generalMap.put("complaintDetails", complaintDetails);
		generalMap.put("complaintCriteria", complaintCriteria);
		generalMap.put("serviceNo", serviceNo);
		generalMap.put("lstChangedBy", lstChangedBy);
		generalMap.put("lstChangedDate", lstChangedDate);
		generalMap.put("lstChangedTime", lstChangedTime);
		generalMap.put("code", complaintNo);
		generalMap.put("pojoPropertyCode", "ComplaintNo");
		generalMap.put("pojoName", "MasComplaintRegister");
		generalMap.put("box", box);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List complaintNoList = new ArrayList();
		List complaintDescList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			complaintNoList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			complaintDescList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((complaintNoList.size() == 0 || complaintNoList == null)
				&& (complaintDescList.size() == 0 || complaintDescList == null)) {

			if (complaintType != 0) {
				MasComplaintsType masComplaintsType = new MasComplaintsType();
				masComplaintsType.setId(complaintType);
				masComplaintRegister.setComplaintType(masComplaintsType);
			}

			if (departmentName != 0) {
				MasDepartment masdepartment = new MasDepartment();
				masdepartment.setId(departmentName);
				masComplaintRegister.setDepartment(masdepartment);
			}

			if (buildingNo != 0) {
				MasSmq masSmq = new MasSmq();
				masSmq.setId(buildingNo);
				masComplaintRegister.setSmqNo(masSmq);
			}
			masComplaintRegister.setComplaintNo(complaintNo);
			masComplaintRegister.setComplaintDate(complaintDate);
			masComplaintRegister.setComplaintTime(complaintTime);
			masComplaintRegister.setComplaintLocation(complaintLocation);
			masComplaintRegister.setComplaintCriteria(complaintCriteria);
			masComplaintRegister.setServiceNo(serviceNo);

			masComplaintRegister.setServicePersonName(personName);
			masComplaintRegister.setComplaintDetails(complaintDetails);
			masComplaintRegister.setLstChangedBy(lstChangedBy);
			masComplaintRegister.setLstChangedDate(lstChangedDate);
			masComplaintRegister.setLstChangedTime(lstChangedTime);
			successfullyAdded = complaintHandlerService.addComplaintRegister(
					masComplaintRegister, complaintRegister);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((complaintNoList.size() != 0 || complaintNoList != null)
				|| (complaintDescList.size() != 0) || complaintDescList != null) {

			if ((complaintNoList.size() != 0 || complaintNoList != null)
					&& (complaintDescList.size() == 0 || complaintDescList == null)) {

				message = "Complaint No  already exists.";
			} else if ((complaintDescList.size() != 0 || complaintDescList != null)
					&& (complaintNoList.size() == 0 || complaintNoList == null)) {

				message = "Complaint Desc already exists.";
			} else if ((complaintNoList.size() != 0 || complaintNoList != null)
					&& (complaintDescList.size() != 0 || complaintDescList != null)) {

				message = "Complaint No and Complaint Desc already exist.";
			}
		}
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		int empId = 0;
		if (users != null) {
			empId = users.getEmployee().getId();
		}
		try {
			map = complaintHandlerService.showComplaintRegisterJsp(empId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String complaintEntryNo = "";
		Map<String, Object> infoMap = new HashMap<String, Object>();
		complaintEntryNo = complaintHandlerService.generateComplaintNo(infoMap);
		jsp = COMPLAINT_REGISTER_JSP;
		title = "Complaint Register";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("complaintEntryNo", complaintEntryNo);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	private int complaintId;

	public ModelAndView showWorkCompletionJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		int deptId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		map = complaintHandlerService.showWorkCompletionJsp();
		jsp = WORK_COMPLETION_JSP;
		jsp += ".jsp";
		title = "Work Completion";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showComandantRemarkJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		int deptId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		map = complaintHandlerService.showWorkCompletionJsp();
		jsp = COMMANDANT_REMARK_JSP;
		jsp += ".jsp";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchWorkCompletion(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String jsp = "";
		String title = "";
		int complaintType = 0;
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		String complaintNo = null;
		String complaintDesc = null;
		int deptId = 0;
		String pdcOver = "";

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			complaintNo = request.getParameter(CODE);
		}
		if (box.getInt(DEPARTMENT_ID) == 0) {

			box.put(DEPARTMENT_ID, (Integer) session.getAttribute("deptId"));
		}

		if (request.getParameter(DEPARTMENT_ID) != null
				&& !request.getParameter(DEPARTMENT_ID).equalsIgnoreCase("0")) {

			deptId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(COMPLAINT_TYPE) != null
				&& !request.getParameter(COMPLAINT_TYPE).equalsIgnoreCase("0")) {

			complaintType = Integer.parseInt(request
					.getParameter(COMPLAINT_TYPE));
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

			map.put("deptId", deptId);
			map.put("complaintType", complaintType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (searchRadio == 1) {
			complaintNo = searchField;
			complaintDesc = null;

		} else {
			complaintNo = null;
			complaintDesc = searchField;
		}
		if (request.getParameter(PDC_OVER) != null
				&& !(request.getParameter(PDC_OVER).equals(""))) {
			pdcOver = request.getParameter(PDC_OVER);
		}

		map = complaintHandlerService.searchWorkCompletion(complaintNo,
				complaintDesc, pdcOver, deptId, complaintType);
		jsp = WORK_COMPLETION_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("complaintNo", complaintNo);
		map.put("complaintDesc", complaintDesc);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView addWorkCompletion(HttpServletRequest request,
			HttpServletResponse response) {
		String manHrsSpent = "";
		String message = "";
		double costOfItems = 0.0;
		String allocatedTo = "";
		String currentTime = "";
		Date attendedDate = null;
		String adminRemarks = "";
		double totalCost = 0;
		String docketNo = "";
		Date completionDate = null;
		String attendedTime = "";
		String completionTime = "";
		String complaintNo = "";
		int complaintId = 0;
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		MasComplaintRegister masComplaintRegister = new MasComplaintRegister();
		Date pdc = null;

		if (!request.getParameter("complaintId").equals("")) {
			complaintId = Integer.parseInt(request.getParameter("complaintId"));
		}

		if (request.getParameter(RequestConstants.WORK_COMPLETION_DATE) != null
				&& !request.getParameter(RequestConstants.WORK_COMPLETION_DATE)
						.equalsIgnoreCase("")) {
			completionDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(RequestConstants.WORK_COMPLETION_DATE));
			masComplaintRegister.setCompletionDate(completionDate);
			masComplaintRegister.setStatus("c");
		}
		if (request.getParameter(RequestConstants.COMPLAINT_ATTENDED_DATE) != null
				&& !request.getParameter(
						RequestConstants.COMPLAINT_ATTENDED_DATE)
						.equalsIgnoreCase("")) {
			attendedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(RequestConstants.COMPLAINT_ATTENDED_DATE));
			masComplaintRegister.setComplaintAttandedDate(attendedDate);
		}

		if (request.getParameter(RequestConstants.PDC) != null) {
			pdc = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(RequestConstants.PDC));
			masComplaintRegister.setPdc(pdc);
			if (request.getParameter(RequestConstants.WORK_COMPLETION_DATE) != null
					&& !request.getParameter(
							RequestConstants.WORK_COMPLETION_DATE)
							.equalsIgnoreCase(""))
				masComplaintRegister.setStatus("y");
			else
				masComplaintRegister.setStatus("c");
		}

		if (request.getParameter(RequestConstants.COMPLAINT_NO) != null) {
			complaintNo = request.getParameter(RequestConstants.COMPLAINT_NO);
		}
		/*
		 * if (request.getParameter(RequestConstants.WORK_COMPLETION_TIME) !=
		 * null) { completionTime =
		 * request.getParameter(RequestConstants.WORK_COMPLETION_TIME); }
		 */
		if (request.getParameter(RequestConstants.WORK_COMPLETION_ALLOCATED_TO) != null) {
			allocatedTo = request
					.getParameter(RequestConstants.WORK_COMPLETION_ALLOCATED_TO);
			masComplaintRegister.setAllocatedTo(allocatedTo);
		}
		/*
		 * if (request.getParameter(RequestConstants.WORK_COMPLETION_MAN_HOURS)
		 * != null) { manHrsSpent =
		 * request.getParameter(RequestConstants.WORK_COMPLETION_MAN_HOURS); }
		 * if
		 * (request.getParameter(RequestConstants.WORK_COMPLETION_COST_OF_ITEMS)
		 * != null &&
		 * !request.getParameter(RequestConstants.WORK_COMPLETION_COST_OF_ITEMS
		 * ).equals("")) { costOfItems = new
		 * Double(request.getParameter(RequestConstants
		 * .WORK_COMPLETION_COST_OF_ITEMS)); } if
		 * (request.getParameter(RequestConstants.WORK_COMPLETION_TOTAL_COST) !=
		 * null &&
		 * !request.getParameter(RequestConstants.WORK_COMPLETION_TOTAL_COST
		 * ).equals("")) { totalCost = new
		 * Double(request.getParameter(RequestConstants
		 * .WORK_COMPLETION_TOTAL_COST)); }
		 */
		if (request.getParameter(RequestConstants.WORK_COMPLETION_DOCKET_NO) != null) {
			docketNo = request
					.getParameter(RequestConstants.WORK_COMPLETION_DOCKET_NO);
			masComplaintRegister.setDocketNo(docketNo);
		}
		if (request
				.getParameter(RequestConstants.WORK_COMPLETION_ADMIN_REMARKS) != null) {
			adminRemarks = request
					.getParameter(RequestConstants.WORK_COMPLETION_ADMIN_REMARKS);
			masComplaintRegister.setMesRemark(adminRemarks);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
			masComplaintRegister.setLstChangedBy(changedBy);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
			masComplaintRegister.setLstChangedDate(currentDate);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
			masComplaintRegister.setLstChangedTime(currentTime);
		}

		/*
		 * if (complaintId != 0) {
		 * 
		 * MasComplaintRegister masComplaintRegister = new
		 * MasComplaintRegister(); masComplaintRegister.setId(complaintId);
		 * MasComplaintRegister.setComplaint(masComplaintRegister); }
		 */

		// MasComplaintRegister.setCompletionTime(completionTime);

		// sWorkCompletion.setComplaintAttendedTime(attendedTime);

		// MasComplaintRegister.setManHrsSpent(manHrsSpent);
		// MasComplaintRegister.setCostOfItems(new BigDecimal(costOfItems));
		// MasComplaintRegister.setTotalCost(new BigDecimal(totalCost));

		generalMap.put("complaintId", complaintId);
		Boolean successfullyAdded = false;
		/*
		 * generalMap.put("code", complaintId);
		 * generalMap.put("pojoPropertyCode", "ComplaintRegisterId");
		 * generalMap.put("pojoName", "MasComplaintRegister"); listMap =
		 * commonMasterHandlerService.checkForExistingMasters(generalMap);
		 * 
		 * List complaintNoList = new ArrayList(); List complaintDescList = new
		 * ArrayList();
		 * 
		 * if (listMap.get("duplicateGeneralCodeList") != null) {
		 * complaintNoList = (List) listMap.get("duplicateGeneralCodeList"); }
		 * if (listMap.get("duplicateGeneralNameList") != null) {
		 * complaintDescList = (List) listMap.get("duplicateGeneralNameList"); }
		 * if(complaintNoList != null && complaintNoList.size()>0) { //
		 * successfullyAdded =
		 * complaintHandlerService.addWorkCompletion(MasComplaintRegister,
		 * generalMap); }
		 */
		successfullyAdded = complaintHandlerService.addWorkCompletion(
				masComplaintRegister, generalMap);

		if (successfullyAdded) {
			message = "Complaint details has been updated successfully for Complaint No- "
					+ complaintNo;
		} else {
			message = "Problem in adding Work Completion !";
		}
		String jsp = WORK_COMPLETION_JSP;
		jsp += ".jsp";
		Map<String, Object> map = complaintHandlerService
				.showWorkCompletionJsp();
		map.put("contentJsp", jsp);

		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ComplaintHandlerService getComplaintHandlerService() {
		return complaintHandlerService;
	}

	public void setComplaintHandlerService(
			ComplaintHandlerService complaintHandlerService) {
		this.complaintHandlerService = complaintHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	public ModelAndView getRecordsForWorkCompletion(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		int deptId = 0;
		int complaintType = 0;
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		/*
		 * if (box.getInt(DEPARTMENT_ID) == 0) {
		 * 
		 * box.put(DEPARTMENT_ID, (Integer) session.getAttribute("deptId")); }
		 */
		if (request.getParameter("deptId") != null) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
			//System.out.println("deptId" + deptId);
			map.put("deptId", deptId);

		}
		if (request.getParameter("complaintType") != null) {
			complaintType = Integer.parseInt(request
					.getParameter("complaintType"));
			//System.out.println("complaintType" + complaintType);
			map.put("complaintType", complaintType);
		}
		map = complaintHandlerService.getRecordsForWorkCompletion(map);
		jsp = WORK_COMPLETION_JSP;
		jsp += ".jsp";
		title = "Work Completion";
		// //System.out.println("box.getInt(DEPARTMENT_ID)==" +
		// box.getInt(DEPARTMENT_ID));
		map.put("departmentId", box.getInt(RequestConstants.DEPARTMENT_NAME));

		map.put("contentJsp", jsp);
		// map.put("deptIdinMap", box.getInt(DEPARTMENT_ID));
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showWorkNotCompletionJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		map = complaintHandlerService.showWorkNotCompletionJsp();
		jsp = WORK_NOT_COMPLETION_JSP;
		jsp += ".jsp";
		title = "Work Completion";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchWorkNotCompletion(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String jsp = "";
		String title = "";
		int complaintType = 0;
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		String complaintNo = null;
		String complaintDesc = null;
		int deptId = 0;
		String pdcOver = "";

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			complaintNo = request.getParameter(CODE);
		}
		if (box.getInt(DEPARTMENT_ID) == 0) {

			box.put(DEPARTMENT_ID, (Integer) session.getAttribute("deptId"));
		}

		if (request.getParameter(DEPARTMENT_ID) != null
				&& !request.getParameter(DEPARTMENT_ID).equalsIgnoreCase("0")) {

			deptId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(COMPLAINT_TYPE) != null
				&& !request.getParameter(COMPLAINT_TYPE).equalsIgnoreCase("0")) {

			complaintType = Integer.parseInt(request
					.getParameter(COMPLAINT_TYPE));
		}
		//System.out.println("deptId--- " + deptId);
		//System.out.println("complaintType--- " + complaintType);

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

			map.put("deptId", deptId);
			map.put("complaintType", complaintType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (searchRadio == 1) {
			complaintNo = searchField;
			complaintDesc = null;

		} else {
			complaintNo = null;
			complaintDesc = searchField;
		}
		if (request.getParameter(PDC_OVER) != null
				&& !(request.getParameter(PDC_OVER).equals(""))) {
			pdcOver = request.getParameter(PDC_OVER);
		}

		map = complaintHandlerService.searchWorkCompletion(complaintNo,
				complaintDesc, pdcOver, deptId, complaintType);

		jsp = WORK_NOT_COMPLETION_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("complaintNo", complaintNo);
		map.put("complaintDesc", complaintDesc);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showComplaintRegister(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "cm_complaintRegister.jsp";
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		int empId = 0;
		if (users != null) {
			empId = users.getEmployee().getId();
		}
		map = complaintHandlerService.showComplaintRegister(empId);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showWorkCompletionRegister(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "cm_workCompletionRegister.jsp";
		Map<String, Object> map = new HashMap<String, Object>();
		map = complaintHandlerService.showWorkCompletionRegister();
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView addCAdmRemark(HttpServletRequest request,
			HttpServletResponse response) {

		Date pdcDate = null;
		String pdcTime = "";
		String remarks = "";
		String commandentRemarks = "";
		String currentTime = "";
		String jspName = "";
		String pojoName = "";
		String message = "";
		String pojoPropertyName = "";
		String pojoPropertyCode = "";
		String pojoPropertyAddress = "";
		String title = "";
		int complaintId = 0;
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		// MasComplaintRegister MasComplaintRegister = new
		// MasComplaintRegister();
		Boolean successfullyAdded = false;
		if (!request.getParameter("complaintId").equals("")) {
			//System.out.println("in complaint id "+ request.getParameter("complaintId"));
			complaintId = Integer.parseInt(request.getParameter("complaintId"));
			//System.out.println("complaintId" + complaintId);

			/*
			 * if (request.getParameter(PDC_TIME) != null) { pdcTime =
			 * request.getParameter(PDC_TIME); } if
			 * (request.getParameter(PDC_DATE) != null &&
			 * !(request.getParameter(PDC_DATE).equals(""))) { pdcDate =
			 * HMSUtil.
			 * convertStringTypeDateToDateType(request.getParameter(PDC_DATE));
			 * }
			 */
			if (request.getParameter(RequestConstants.REMARKS) != null) {
				remarks = request.getParameter(RequestConstants.REMARKS);
			}
			/*
			 * if (request.getParameter(RequestConstants.COMMANDENT_REMARKS) !=
			 * null) { commandentRemarks =
			 * request.getParameter(RequestConstants.COMMANDENT_REMARKS); }
			 */
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
			/*
			 * if (request.getParameter("title") != null) { title =
			 * request.getParameter("title"); } if
			 * (request.getParameter("pojoName") != null) { pojoName =
			 * request.getParameter("pojoName"); } if
			 * (request.getParameter("pojoPropertyName") != null) {
			 * pojoPropertyName = request.getParameter("pojoPropertyName"); } if
			 * (request.getParameter("pojoPropertyCode") != null) {
			 * pojoPropertyCode = request.getParameter("pojoPropertyCode"); } if
			 * (request.getParameter("pojoPropertyAddress") != null) {
			 * pojoPropertyAddress =
			 * request.getParameter("pojoPropertyAddress"); }
			 */
			MasComplaintRegister masComplaintRegister = new MasComplaintRegister();

			if (complaintId != 0) {

				masComplaintRegister.setId(complaintId);
				// //System.out.println("iddddddd" +
				// MasComplaintRegister.getComplaintRegId().getId());
			}
			masComplaintRegister.setCadoRemark(remarks);
			masComplaintRegister.setLstChangedBy(changedBy);
			masComplaintRegister.setLstChangedDate(currentDate);
			masComplaintRegister.setLstChangedTime(currentTime);
			masComplaintRegister.setStatus("y");
			successfullyAdded = complaintHandlerService
					.addMasComplaintRegister(masComplaintRegister);
		}
		if (successfullyAdded) {
			message = "C Adm O's remark has been added sucessfully ";
		} else {
			message = "Problem in adding C Adm O's remark! Please try again";
		}
		String jsp = WORK_NOT_COMPLETION_JSP;
		jsp += ".jsp";
		Map<String, Object> map = complaintHandlerService
				.showWorkNotCompletionJsp();
		map.put("contentJsp", jsp);
		map.put("complaintId", complaintId);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView addCommandantRemark(HttpServletRequest request,
			HttpServletResponse response) {

		String remarks = "";
		String currentTime = "";
		String message = "";
		int complaintId = 0;
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		Boolean successfullyAdded = false;
		if (!request.getParameter("complaintId").equals("")) {
			//System.out.println("in complaint id "+ request.getParameter("complaintId"));
			complaintId = Integer.parseInt(request.getParameter("complaintId"));
			//System.out.println("complaintId" + complaintId);

			if (request.getParameter(RequestConstants.COMMANDENT_REMARKS) != null) {
				remarks = request
						.getParameter(RequestConstants.COMMANDENT_REMARKS);
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

			MasComplaintRegister masComplaintRegister = new MasComplaintRegister();

			if (complaintId != 0) {
				masComplaintRegister.setId(complaintId);
			}
			masComplaintRegister.setCommandantRemark(remarks);
			masComplaintRegister.setLstChangedBy(changedBy);
			masComplaintRegister.setLstChangedDate(currentDate);
			masComplaintRegister.setLstChangedTime(currentTime);
			masComplaintRegister.setStatus("y");
			successfullyAdded = complaintHandlerService
					.addCommandantRemark(masComplaintRegister);
		}
		if (successfullyAdded) {
			message = "Commandant remark has been added sucessfully ";
		} else {
			message = "Problem in adding C Adm O's remark! Please try again";
		}
		String jsp = COMMANDANT_REMARK_JSP;
		jsp += ".jsp";
		Map<String, Object> map = complaintHandlerService
				.showWorkCompletionJsp();
		map.put("contentJsp", jsp);
		map.put("complaintId", complaintId);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getRecordsForWorkNotCompletion(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		int deptId = 0;
		int complaintType = 0;
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		/*
		 * if (box.getInt(DEPARTMENT_ID) == 0) {
		 * 
		 * box.put(DEPARTMENT_ID, (Integer) session.getAttribute("deptId")); }
		 */
		if (request.getParameter("deptId") != null) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
			//System.out.println("deptId" + deptId);
			map.put("deptId", deptId);

		}
		if (request.getParameter("complaintType") != null) {
			complaintType = Integer.parseInt(request
					.getParameter("complaintType"));
			//System.out.println("complaintType" + complaintType);
			map.put("complaintType", complaintType);
		}
		map = complaintHandlerService.getRecordsForWorkNotCompletion(map);
		jsp = WORK_NOT_COMPLETION_JSP;
		jsp += ".jsp";
		title = "Work Not Completion";

		map.put("departmentId", box.getInt(RequestConstants.DEPARTMENT_NAME));

		map.put("contentJsp", jsp);

		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchCommandantRemark(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String jsp = "";
		String title = "";
		int complaintType = 0;
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		String complaintNo = null;
		String complaintDesc = null;
		int deptId = 0;
		String pdcOver = "";

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			complaintNo = request.getParameter(CODE);
		}
		if (box.getInt(DEPARTMENT_ID) == 0) {

			box.put(DEPARTMENT_ID, (Integer) session.getAttribute("deptId"));
		}

		if (request.getParameter(DEPARTMENT_ID) != null
				&& !request.getParameter(DEPARTMENT_ID).equalsIgnoreCase("0")) {

			deptId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(COMPLAINT_TYPE) != null
				&& !request.getParameter(COMPLAINT_TYPE).equalsIgnoreCase("0")) {

			complaintType = Integer.parseInt(request
					.getParameter(COMPLAINT_TYPE));
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

			map.put("deptId", deptId);
			map.put("complaintType", complaintType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (searchRadio == 1) {
			complaintNo = searchField;
			complaintDesc = null;

		} else {
			complaintNo = null;
			complaintDesc = searchField;
		}
		if (request.getParameter(PDC_OVER) != null
				&& !(request.getParameter(PDC_OVER).equals(""))) {
			pdcOver = request.getParameter(PDC_OVER);
		}

		map = complaintHandlerService.searchWorkCompletion(complaintNo,
				complaintDesc, pdcOver, deptId, complaintType);

		jsp = COMMANDANT_REMARK_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("complaintNo", complaintNo);
		map.put("complaintDesc", complaintDesc);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public void fillComplaintNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String complaintNo = "";
		try {
			if (request.getParameter("complaintNo") != null) {
				complaintNo = request.getParameter("complaintNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("complaintNo", complaintNo);
		StringBuffer sb = new StringBuffer();
		try {
			List<MasComplaintRegister> complaintList = new ArrayList<MasComplaintRegister>();
			map = complaintHandlerService.fillItemsForComplaintNo(dataMap);
			if (map.get("complaintList") != null) {
				complaintList = (List) map.get("complaintList");
			}

			sb.append("<items>");
			for (MasComplaintRegister masComplaintRegister : complaintList) {
				complaintNo = masComplaintRegister.getComplaintNo();
				String complaintDate = HMSUtil
						.convertDateToStringWithoutTime(masComplaintRegister
								.getComplaintDate());
				sb.append("<item>");
				sb.append("<complaintNo>" + complaintNo + "</complaintNo>");
				sb.append("<complaintDate>" + complaintDate
						+ "</complaintDate>");

				sb.append("</item>");
			}
			sb.append("</items>");

		} catch (Exception e) {
			e.printStackTrace();
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

	public ModelAndView printComplaintRegister(HttpServletRequest request,
			HttpServletResponse response) {

		byte[] bytes = null;
		//ServletContext context = request.getSession().getServletContext();
		// Map parameters = new HashMap();
		Map<String, Object> parameters = new HashMap();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fromDate = null;
		Date toDate = null;
		int complaintTypeId = 0;
		int status = 0;
		String stringvariable = "";
		String query = "";
		String complaint_status = "";
		String complaint_type = "";

		try {

			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter("complaint") != null
					&& !(request.getParameter("complaint").equals(""))) {
				complaintTypeId = Integer.parseInt(request
						.getParameter("complaint"));
			}

			if (complaintTypeId != 0) {
				query = " and mas_complaint_register.complaint_type="
						+ complaintTypeId;
			}
			if (request.getParameter("complaintTypeName") != null
					&& !(request.getParameter("complaintTypeName").equals(""))) {
				complaint_type = request.getParameter("complaintTypeName");
			} else {
				complaint_type = "All";
			}
			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals("0"))) {
				status = Integer.parseInt(request.getParameter(SELECTED_RADIO));
				if (status == 1) {
					query = query + " and mas_complaint_register.status = 'p'";
					complaint_status = "Pending";
				}
				if (status == 2) {
					query = query + " and mas_complaint_register.status = 'c'";
					complaint_status = "Accepted";
				}
				if (status == 3) {
					query = query
							+ " and (mas_complaint_register.status = 'p' or mas_complaint_register.status = 'c' or mas_complaint_register.status = 'r')";
					complaint_status = "All";
				}
			}

			parameters.put("fromDate", fromDate);
			parameters.put("toDate", toDate);
			parameters.put("complaint_type", complaint_type);
			parameters.put("complaint_status", complaint_status);
			parameters.put("QUERY", query);
			Map<String, Object> connectionMap = complaintHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("complaint_register", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printworkCompletionRegister(HttpServletRequest request,
			HttpServletResponse response) {

		{

			byte[] bytes = null;
			//ServletContext context = request.getSession().getServletContext();
			Map<String, Object> parameters = new HashMap();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date fromDate = null;
			Date toDate = null;
			String complaintId = "";
			String status = "";
			String stringvariable = "";
			String query = "";
			try {

				if (request.getParameter(FROM_DATE) != null
						&& !(request.getParameter(FROM_DATE).equals(""))) {
					fromDate = HMSUtil.convertStringTypeDateToDateType(request
							.getParameter(FROM_DATE));
				}
				if (request.getParameter(TO_DATE) != null
						&& !(request.getParameter(TO_DATE).equals(""))) {
					toDate = HMSUtil.convertStringTypeDateToDateType(request
							.getParameter(TO_DATE));
				}
				if (request.getParameter("complaint") != null
						&& !(request.getParameter("complaint").equals(""))) {
					complaintId = request.getParameter("complaint");
				}

				parameters.put("fromDate", fromDate);
				parameters.put("toDate", toDate);

				Map<String, Object> connectionMap = complaintHandlerService
						.getConnectionForReport();
				if (request.getParameter(SELECTED_RADIO) != null
						&& !(request.getParameter(SELECTED_RADIO).equals("0"))) {
					status = (request.getParameter(SELECTED_RADIO));
					if (status.equals("1")) {
						if (!complaintId.equals("")) {
							stringvariable = " and mas_complaint_register.complaint_type="
									+ complaintId;

						}
						// query =
						// " and mas_complaint_register.completion_date <= mas_complaint_register.complaint_date + 2 ";
						parameters.put("stringvariable", stringvariable);
						HMSUtil.generateReport("work_completion_register",
								parameters, (Connection) connectionMap
										.get("conn"), response,
								getServletContext());
					} else {
						if (!complaintId.equals("")) {
							stringvariable = "and mas_complaint_register.complaint_type="
									+ complaintId;
							parameters.put("stringvariable", stringvariable);
						}
						// query =
						// " and mas_complaint_register.completion_date >= mas_complaint_register.complaint_date + 3 ";
						parameters.put("stringvariable", stringvariable);
						HMSUtil.generateReport("work_not_completed",
								parameters, (Connection) connectionMap
										.get("conn"), response,
								getServletContext());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	}

}
