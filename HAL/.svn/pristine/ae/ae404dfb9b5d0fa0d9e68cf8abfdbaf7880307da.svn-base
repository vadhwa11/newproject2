package jkt.hms.hrOrder.controller;

import static jkt.hms.util.RequestConstants.*;

import java.io.FileNotFoundException;
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

import jkt.hms.hrOrder.handler.HrOrderlyRoomHandlerService;
import jkt.hms.masters.business.EmpLeaveBalance;
import jkt.hms.masters.business.FamilyDetails;
import jkt.hms.masters.business.HrClassMaster;
import jkt.hms.masters.business.HrLeaveTypeMaster;
//import jkt.hms.masters.business.HrLivingInOutDetail;
import jkt.hms.masters.business.HrSpecialistMaster;
import jkt.hms.masters.business.HroEntry;
import jkt.hms.masters.business.HrorderlyLeaveAccount;
import jkt.hms.masters.business.HrorderlyLeaveApplication;
import jkt.hms.masters.business.HrorderlyLeavechoice;
import jkt.hms.masters.business.HrorderlyMessMaster;
import jkt.hms.masters.business.LeaveRestrictionEntry;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmpCategory;
import jkt.hms.masters.business.MasEmpStatus;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDependent;
import jkt.hms.masters.business.MasGrade;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasPorProgram;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.MovementInEntry;
import jkt.hms.masters.business.MovementInOtherPerson;
import jkt.hms.masters.business.MovementOutEntry;
import jkt.hms.masters.business.PostedOutEntry;
import jkt.hms.masters.business.ProposalForHroEntry;
import jkt.hms.masters.business.TrainClassGroup;
import jkt.hms.masters.business.UserDepartment;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class HrOrderlyRoomController extends MultiActionController {

	// --------------------------------------------------------------------------------------------------
	HrOrderlyRoomHandlerService hrOrderlyRoomHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;

	public HrOrderlyRoomHandlerService getHrOrderlyRoomHandlerService() {
		return hrOrderlyRoomHandlerService;
	}

	public void setHrOrderlyRoomHandlerService(
			HrOrderlyRoomHandlerService hrOrderlyRoomHandlerService) {
		this.hrOrderlyRoomHandlerService = hrOrderlyRoomHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	// --------------------------------------------------------------------------------------------------
	// ------------------------------------------general-----------------------------------------------------------//
	HttpSession session = null;
	String jsp = "";
	String message = "";
	String title = "";
	String code = "";
	String name = "";
	String currentDate = "";
	String currentTime = "";
	String changedBy = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	String url = "";
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();

	// ------------------------------------------general----------------------------------------------------------//

	/**
	 * -------------------------method to show POR Program master
	 * ----------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showPorJsp(HttpServletRequest request,
			HttpServletResponse response) {
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
		map = hrOrderlyRoomHandlerService.showPorJsp();
		jsp = POR_PROGRAM_JSP;
		jsp += ".jsp";
		title = "Pool Category";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -------------------------------------- method to add por program master
	 * ---------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView addPorProgram(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasPorProgram masporProgram = new MasPorProgram();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		Date fromDate = new Date();
		Date toDate = new Date();
		String porNumber = "";
		String remarks = "";

		if (request.getParameter(POR_NUMBER) != null) {
			porNumber = request.getParameter(POR_NUMBER);
		}
		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
		}

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TO_DATE));
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

		generalMap.put("code", code);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		boolean successfullyAdded = false;

		masporProgram.setFromDate(fromDate);
		masporProgram.setToDate(toDate);
		masporProgram.setRemarks(remarks);
		masporProgram.setPorNumber(porNumber);
		masporProgram.setLastChgBy(changedBy);
		masporProgram.setLastChgDate(currentDate);
		masporProgram.setLastChgTime(currentTime);
		masporProgram.setStatus("y");
		successfullyAdded = hrOrderlyRoomHandlerService
				.addPorProgram(masporProgram);
		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}

		try {
			map = hrOrderlyRoomHandlerService.showPorJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = POR_PROGRAM_JSP;
		title = "POR Program";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ---------------------------------------- method to update records of pr
	 * program master-----------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView editPorProgram(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		session = request.getSession();
		int porProgramId = 0;
		String changedTime = "";
		Date changedDate = null;
		String porNumber = "";
		String remarks = "";
		String status = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			porProgramId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(POR_NUMBER) != null) {
			porNumber = request.getParameter(POR_NUMBER);
		}
		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
		}
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TO_DATE));
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

		generalMap.put("id", porProgramId);
		generalMap.put("porNumber", porNumber);
		generalMap.put("remarks", remarks);
		generalMap.put("fromDate", fromDate);
		generalMap.put("toDate", toDate);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		boolean dataUpdated = false;
		dataUpdated = hrOrderlyRoomHandlerService.editPorProgram(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant Be Updated !!";
		}

		url = "/hms/hms/hrOrderly?method=showPorJsp";

		try {
			map = hrOrderlyRoomHandlerService.showPorJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = POR_PROGRAM_JSP;
		title = "update POR Program";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -------------------------------------- delete por
	 * program------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView deletePorProgram(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int porProgramId = 0;
		String message = null;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			porProgramId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hrOrderlyRoomHandlerService.deletePorProgram(
				porProgramId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hrOrderly?method=showPorJsp";

		try {
			map = hrOrderlyRoomHandlerService.showPorJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = POR_PROGRAM_JSP;
		title = "delete POR Program";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------------------------method to search pro program
	 * master--------------------------------------
	 */
	@SuppressWarnings("deprecation")
	public ModelAndView searchPorProgram(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String porNumber = null;
		String searchField = null;
		Date fromDateField = new Date();
		Date toDateField = new Date();
		if (request.getParameter(POR_NUMBER) != null
				&& !(request.getParameter(POR_NUMBER).equals(""))) {
			porNumber = request.getParameter(POR_NUMBER);
		}
		if (request.getParameter("fromDateField") != null) {
			fromDateField = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("fromDateField"));
		}
		//System.out.println("fromDateField :  " + fromDateField);
		if (request.getParameter("toDateField") != null) {
			toDateField = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("toDateField"));
		}
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		porNumber = searchField;
		map = hrOrderlyRoomHandlerService.searchPorProgram(porNumber,
				fromDateField, toDateField);
		jsp = POR_PROGRAM_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("porNumber", porNumber);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------------------- method to search for leave application
	 * entry-----------------------
	 */
	public ModelAndView showTrainClassGroupJsp(HttpServletRequest request , HttpServletResponse response){
		Map<String,Object> map = new HashMap<String,Object>();
		map=hrOrderlyRoomHandlerService.showTrainClassGroupJsp();
		jsp=TRAIN_CLASS_GROUP;
		jsp+=".jsp";
		title="Train Class Group";
		map.put("contentJsp",jsp);
		map.put("title",title);
		return new ModelAndView("indexB","map",map);
	}
	public ModelAndView searchTrainClassGroupJsp(HttpServletRequest request , HttpServletResponse response){
		Map<String,Object> map = new HashMap<String,Object>();
		String searchField="";
		if (request.getParameter(SEARCH_FIELD) != null && !request.getParameter(SEARCH_FIELD).equals("")) {
			searchField = request.getParameter(SEARCH_FIELD);
		}
		map=hrOrderlyRoomHandlerService.searchTrainClassGroupJsp(searchField);
		if(map.size()>0)
		{
			map.put("search","search");
		}
		jsp=TRAIN_CLASS_GROUP;
		jsp+=".jsp";
		title="Train Class Group";
		map.put("contentJsp",jsp);
		map.put("title",title);
		return new ModelAndView("indexB","map",map);
	}
	public ModelAndView addTrainClassGroupJsp(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String,Object> map = new HashMap<String,Object>();
		TrainClassGroup trainclassgroup = new TrainClassGroup();
         int rankCategoryId=0;
         String changedBy = "";
		boolean successfullyAdded=false;
		Map<String, Object> listMap=new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String[] deptIdArray = null; 
		StringBuffer deptStr = new StringBuffer();
		
		if (request.getParameter(RANK_CATEGORY) != null) {
			rankCategoryId = Integer.parseInt(request.getParameter(RANK_CATEGORY));
		}
		
		if (request.getParameterValues("TrainClasses") != null && !request.getParameterValues("TrainClasses").equals("0")) {
			deptIdArray = (String[])(request.getParameterValues("TrainClasses"));
			for (int i = 0; i < deptIdArray.length; i++) {
				deptStr.append(deptIdArray[i]);
				deptStr.append(",");
			}
			 deptStr.deleteCharAt(deptStr.length()-1);
			 generalMap.put("deptStr", deptStr.toString());
		}
		
		generalMap.put("rankCategoryId", rankCategoryId);
		
		
			successfullyAdded = hrOrderlyRoomHandlerService.addTrainClassGroupJsp(generalMap);		
			if(successfullyAdded){
				message="Record(s) Added Successfully !!";
			}else{
				message="Try Again !!";
			}
		

		try{
			map = hrOrderlyRoomHandlerService.showTrainClassGroupJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=TRAIN_CLASS_GROUP;
		title="Add Train Class";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView updateTrainClassGroupJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,Object> generalMap=new HashMap<String,Object>();
		boolean successfull=false;
		String message="";
		int rankCategoryId=0;
		String[] deptIdArray = null; 
		StringBuffer deptStr = new StringBuffer();
		if (request.getParameterValues("TrainClasses") != null && !request.getParameterValues("TrainClasses").equals("0")) {
			deptIdArray = (String[])(request.getParameterValues("TrainClasses"));
			for (int i = 0; i < deptIdArray.length; i++) {
				deptStr.append(deptIdArray[i]);
				deptStr.append(",");
			}
			 deptStr.deleteCharAt(deptStr.length()-1);
			 generalMap.put("deptStr", deptStr.toString());
		}
		if (request.getParameter(RANK_CATEGORY) != null) {
			rankCategoryId = Integer.parseInt(request.getParameter(RANK_CATEGORY));
		}
		generalMap.put("rankCategoryId",rankCategoryId);
		generalMap.put("deptIdArray",deptIdArray);
		
		successfull=hrOrderlyRoomHandlerService.updateTrainClassGroupJsp(generalMap);
		if(successfull)
		{
			message="Record is Updated Successfull";
		}else
		{
			message="Try Again";
		}
		//System.out.println("successfull::"+successfull);
		try{
			map = hrOrderlyRoomHandlerService.showTrainClassGroupJsp();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		jsp=TRAIN_CLASS_GROUP;
		title="Update Train Class";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView searchLeaveApplication(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		Date currentDate = HMSUtil.convertStringTypeDateToDateType(date);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		mapForDs.put("currentDate", currentDate);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		detailsMap = hrOrderlyRoomHandlerService
				.getDetailsForSearchForLeaveApplication(dataMap);
		String jsp = SEARCH_LEAVE_APPLICATION;
		jsp += ".jsp";

		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -------------------------method to
	 * search------------------------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView searchRecordsForLeaveApplication(
			HttpServletRequest request, HttpServletResponse response)
			throws FileNotFoundException, IllegalStateException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serPersonFName = "";
		String serPersonLName = "";
		String serviceNo = "";
		int rankId = 0;
		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		session = request.getSession();

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		Map<String, Object> dataMap = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

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
		if (request.getParameter(S_LAST_NAME) != null
				&& !(request.getParameter(S_LAST_NAME).equals(""))) {
			serPersonLName = request.getParameter(S_LAST_NAME);
			mapForDs.put("serPersonLName", serPersonLName);
		}
		//System.out.println("serPersonFName::"+serPersonFName+"::serPersonLName::"+serPersonLName);
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals("0"))) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
			mapForDs.put("rankId", rankId);
		}
		Map<String, Object> patientMap = new HashMap<String, Object>();
		patientMap = hrOrderlyRoomHandlerService.getEmployeeDetailsGrid(mapForDs);// for
		// MasEmpploye
		detailsMap = hrOrderlyRoomHandlerService.getDetailsForSearchForLeaveApplication(dataMap);// for
		// masRank
		jsp = SEARCH_LEAVE_APPLICATION + ".jsp";
		map.put("contentJsp", jsp);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		return new ModelAndView("indexB", "map", map);
	}

	// ///// Show Leave Application

	public ModelAndView showLeaveApplicationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrorderlyLeaveApplication> leaveApplicationList = new ArrayList<HrorderlyLeaveApplication>();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String entryNo = "";
		if (dataMap.get("leaveApplicationList") != null) {
			leaveApplicationList = (List<HrorderlyLeaveApplication>) dataMap
					.get("leaveApplicationList");
		}
		entryNo = hrOrderlyRoomHandlerService
				.generateLeaveApplicationEntryNumber(userName);
		//System.out.println("EntryNo" + entryNo);
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
		int Id = getEmployeeId();
		map = hrOrderlyRoomHandlerService.showLeaveApplicationJsp(Id);
		if(((List<HrorderlyLeaveApplication>)map.get("leaveApplicationList")).size()>0){
		jsp="checkPreviousLeave"	;
		}else{
		jsp = LEAVE_APPLICATION;
		}
		jsp += ".jsp";
		title = "Pool Category";
		map.put("contentJsp", jsp);
		map.put("entryNo", entryNo);
		map.put("title", title);
		map.put("leaveApplicationList", leaveApplicationList);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);
	}

	String entryNo = "";
	Date entryDate = null;
	Date leaveFromDate = null;
	Date dateOfReporting = null;
	String leaveDays = "";
	Date addlLeaveFromDate = null;
	Date addlLeaveToDate = null;
	String addlLeaveDays = "";
	String type = "";
	int id = 0;
	int leaveAppId = 0;
	int leaveId = 0;
	int requiredFrom = 0;
	int cityTo = 0;
	int rajdhaniUpto = 0;
	String availingLtc = "";
	String otherTrainsUpto = "";
	String drawingTransportAllowance = "";
	Integer ltcYear = 1;
	Integer previousYearLtcDetails = 1;
	String underTr = "";
	String trainClass = "";
	String ticketForSide = "";
	String returnJourneyValidUpto = "";
	String selectFamily = "";
	Date dob = null;
	Integer age = 1;
	String dependentPorNo = "";
	String fullName = "";
	String houseName = "";
	String village = "";
	String postOffice = "";
	String telegraphOffice = "";
	String policeStation = "";
	int state = 0;
	int districtName = 0;
	String pinCode = "";
	String telephoneNo = "";
	Integer leaveAvailed = 1;
	String daysOfCl = "";
	String setOfCVs = "";
	String nrs = "";
	String lstChangedBy = "";
	Date lstChangedDate = null;
	String lstChangedTime = "";
	private int employeeId;
	private int proposalId;
	private int hroId;
	private int postedId;
	private int hroEntryId;

	// /////// Add Leave Application

	public ModelAndView addLeaveApplication(HttpServletRequest req,
			HttpServletResponse res) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(req);
		int noOfRecords = 0;
		String userName = "";
		session = req.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");

		HrorderlyLeaveApplication hrorderlyLeaveApplication = new HrorderlyLeaveApplication();

		Map<String, Object> generalMap = new HashMap<String, Object>();

		List<FamilyDetails> familyDetails = new ArrayList<FamilyDetails>();

		Vector<String> v2 = box.getVector(FAMILY);
		Vector<String> v3 = box.getVector(DATE_OF_BIRTH);
		Vector<String> v4 = box.getVector(AGE);
		Vector<String> v5 = box.getVector(POR_NUMBER);
		//System.out.println("family::" + v2.size() + "dateofbirth::" + v3.size()+ "age::" + v4.size() + "por::" + v5.size());
		for (int i = 0; i < v2.size(); i++) {
			FamilyDetails familydetails = new FamilyDetails();
			familydetails.setSelectFamily(v2.get(i));
			if (!(v3.get(i).equals(""))) {
				familydetails.setDob(HMSUtil.dateFormatterDDMMYYYY(v3.get(i)));
			}
			familydetails.setAge(Integer.parseInt(v4.get(i)));
			familydetails.setDependentPorNo(v5.get(i));
			familyDetails.add(familydetails);
		}

		if (req.getParameter(LEAVE_TYPE) != null
				&& !(req.getParameter(LEAVE_TYPE).equals(""))) {
			leaveId = Integer.parseInt(req.getParameter(LEAVE_TYPE));
		}
		if (req.getParameter("id") != null
				&& !req.getParameter("id").equals("")) {
			id = Integer.parseInt(req.getParameter("id"));
		}
		//System.out.println("id value in addleaveapplication " + id);
		if (req.getParameter("leaveAppId") != null
				&& !req.getParameter("leaveAppId").equals("")) {
			leaveAppId = Integer.parseInt(req.getParameter("leaveAppId"));
		}
		//System.out.println("leaaveeeeapppId" + leaveAppId);

		if (req.getParameter(LEAVE_FROM_DATE) != null
				&& !(req.getParameter(LEAVE_FROM_DATE).equals(""))) {
			leaveFromDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(LEAVE_FROM_DATE));
		}
		if (req.getParameter(LEAVE_TO_DATE) != null
				&& !(req.getParameter(LEAVE_TO_DATE).equals(""))) {
			dateOfReporting = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(LEAVE_TO_DATE));
		}
		if (req.getParameter(LEAVE_DAYS) != null) {
			leaveDays = req.getParameter(LEAVE_DAYS);
		}
		if (req.getParameter(ENTRY_NO) != null) {
			entryNo = req.getParameter(ENTRY_NO);
		}
		if (req.getParameter(ENTRY_DATE) != null
				&& !(req.getParameter(ENTRY_DATE).equals("")))

		{
			entryDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(ENTRY_DATE));
		}
		if (req.getParameter(ADDL_LEAVE_FROM_DATE) != null
				&& !(req.getParameter(ADDL_LEAVE_FROM_DATE).equals("")))

		{
			addlLeaveFromDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(ADDL_LEAVE_FROM_DATE));
		}
		if (req.getParameter(ADDL_LEAVE_TO_DATE) != null
				&& !(req.getParameter(ADDL_LEAVE_TO_DATE).equals("")))

		{
			addlLeaveToDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(ADDL_LEAVE_TO_DATE));
		}
		if (req.getParameter(ADDL_LEAVE_DAYS) != null) {
			addlLeaveDays = req.getParameter(ADDL_LEAVE_DAYS);
		}

		if (req.getParameter(TYPE) != null) {
			type = req.getParameter(TYPE);
		}
		if (req.getParameter(REQUIRED_FROM) != null
				&& !(req.getParameter(REQUIRED_FROM).equals(""))) {
			requiredFrom = Integer.parseInt(req.getParameter(REQUIRED_FROM));
			//System.out.println("requierdfrom" + requiredFrom);
		}
		if (req.getParameter(CITY_TO) != null
				&& !(req.getParameter(CITY_TO).equals(""))) {
			cityTo = Integer.parseInt(req.getParameter(CITY_TO));
		}
		if (req.getParameter(RAJDHANI_UPTO) != null
				&& !(req.getParameter(RAJDHANI_UPTO).equals(""))) {
			rajdhaniUpto = Integer.parseInt(req.getParameter(RAJDHANI_UPTO));
			//System.out.println("rajdhani" + rajdhaniUpto);
		}
		if (req.getParameter(AVAILING_LTC) != null) {
			availingLtc = req.getParameter(AVAILING_LTC);
		}
		if (req.getParameter(OTHER_TRAINS_UPTO) != null) {
			otherTrainsUpto = req.getParameter(OTHER_TRAINS_UPTO);
		}
		if (req.getParameter(DRAWING_TRANSPORT_ALLOWANCE) != null) {
			drawingTransportAllowance = req
					.getParameter(DRAWING_TRANSPORT_ALLOWANCE);
		}
		if (req.getParameter(LTC_YEAR) != null
				&& req.getParameter(LTC_YEAR) != "") {
			ltcYear = Integer.parseInt(req.getParameter(LTC_YEAR));
		}
		if (req.getParameter(PREVIOUS_YEAR_LTC_DETAILS) != null
				&& req.getParameter(PREVIOUS_YEAR_LTC_DETAILS) != "") {
			previousYearLtcDetails = Integer.parseInt(req
					.getParameter(PREVIOUS_YEAR_LTC_DETAILS));
		}
		if (req.getParameter(UNDER_TR) != null) {
			underTr = req.getParameter(UNDER_TR);
		}
		if (req.getParameter(TRAIN_CLASS) != null) {
			trainClass = req.getParameter(TRAIN_CLASS);
		}
		if (req.getParameter(TICKET_FOR_SIDE) != null) {
			ticketForSide = req.getParameter(TICKET_FOR_SIDE);
		}
		if (req.getParameter(RETURN_JOURNEY_VALID_UPTO) != null) {
			returnJourneyValidUpto = req
					.getParameter(RETURN_JOURNEY_VALID_UPTO);
		}
		if (req.getParameter(FULL_NAME) != null) {
			fullName = req.getParameter(FULL_NAME);
		}
		if (req.getParameter(HOUSE_NAME) != null) {
			houseName = req.getParameter(HOUSE_NAME);
		}
		if (req.getParameter(VILLAGE) != null) {
			village = req.getParameter(VILLAGE);
		}
		if (req.getParameter(DISTRICT) != null
				&& !req.getParameter(DISTRICT).equals("")) {
			districtName = Integer.parseInt(req.getParameter(DISTRICT));

		}
		if (req.getParameter(STATE) != null
				&& !req.getParameter(STATE).equals("")) {
			state = Integer.parseInt(req.getParameter(STATE));
		}
		if (req.getParameter(POST_OFFICE) != null) {
			postOffice = req.getParameter(POST_OFFICE);
		}
		if (req.getParameter(POLICE_STATION) != null) {
			policeStation = req.getParameter(POLICE_STATION);
		}
		if (req.getParameter(TELEGRAPH_OFFICE) != null) {
			telegraphOffice = req.getParameter(TELEGRAPH_OFFICE);
		}
		if (req.getParameter(TELEPHONE_NO) != null) {
			telephoneNo = req.getParameter(TELEPHONE_NO);
		}
		if (req.getParameter(PINCODE) != null) {
			pinCode = req.getParameter(PINCODE);
		}
		if (req.getParameter(LEAVE_AVAILED) != null
				&& req.getParameter(LEAVE_AVAILED) != "") {
			leaveAvailed = Integer.parseInt(req.getParameter(LEAVE_AVAILED));
		}
		if (req.getParameter(DAYS_OF_CL) != null) {
			daysOfCl = req.getParameter(DAYS_OF_CL);
		}
		if (req.getParameter(SET_OF_CVs) != null) {
			setOfCVs = req.getParameter(SET_OF_CVs);
		}
		if (req.getParameter(NRS) != null) {
			nrs = req.getParameter(NRS);
		}
		if (req.getParameter(CHANGED_BY) != null
				&& !(req.getParameter(CHANGED_BY).equals(""))) {
			lstChangedBy = req.getParameter(CHANGED_BY);
		}
		if (req.getParameter(CHANGED_DATE) != null
				&& !(req.getParameter(CHANGED_DATE).equals(""))) {
			lstChangedDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(CHANGED_DATE));
		}
		if (req.getParameter(CHANGED_TIME) != null
				&& !(req.getParameter(CHANGED_TIME).equals(""))) {
			lstChangedTime = req.getParameter(CHANGED_TIME);
		}

		generalMap.put("leaveId", leaveId);
		generalMap.put("entryDate", entryDate);
		generalMap.put("leaveFromDate", leaveFromDate);
		generalMap.put("dateOfReporting", dateOfReporting);
		generalMap.put("leaveDays", leaveDays);
		generalMap.put("addlLeaveFromDate", addlLeaveFromDate);
		generalMap.put("addlLeaveToDate", addlLeaveToDate);
		generalMap.put("addlLeaveDays", addlLeaveDays);
		generalMap.put("requiredFrom", requiredFrom);
		generalMap.put("cityTo", cityTo);
		generalMap.put("rajdhaniUpto", rajdhaniUpto);
		generalMap.put("availingLtc", availingLtc);
		generalMap.put("otherTrainsUpto", otherTrainsUpto);
		generalMap.put("drawingTransportAllowance", drawingTransportAllowance);
		generalMap.put("ltcYear", ltcYear);
		generalMap.put("previousYearLtcDetails", previousYearLtcDetails);
		generalMap.put("underTr", underTr);
		generalMap.put("trainClass", trainClass);
		generalMap.put("ticketForSide", ticketForSide);
		generalMap.put("returnJourneyValidUpto", returnJourneyValidUpto);
		generalMap.put("fullName", fullName);
		generalMap.put("houseName", houseName);
		generalMap.put("village", village);
		generalMap.put("state", state);
		generalMap.put("districtName", districtName);
		generalMap.put("postOffice", postOffice);
		generalMap.put("policeStation", policeStation);
		generalMap.put("pinCode", pinCode);
		generalMap.put("telegraphOffice", telegraphOffice);
		generalMap.put("telephoneNo", telephoneNo);
		generalMap.put("leaveAvailed", leaveAvailed);
		generalMap.put("daysOfCl", daysOfCl);
		generalMap.put("entryNo", entryNo);
		generalMap.put("setOfCVs", setOfCVs);
		generalMap.put("nrs", nrs);
		generalMap.put("lstChangedBy", lstChangedBy);
		generalMap.put("lstChangedDate", lstChangedDate);
		generalMap.put("lstChangedTime", lstChangedTime);

		if (id != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(id);
			hrorderlyLeaveApplication.setEmployee(masEmployee);
		}

		hrorderlyLeaveApplication.setEntryNo(entryNo);
		hrorderlyLeaveApplication.setEntryDate(entryDate);

		if (leaveId != 0) {
			HrLeaveTypeMaster hrLeaveTypeMaster = new HrLeaveTypeMaster();
			hrLeaveTypeMaster.setId(leaveId);
			hrorderlyLeaveApplication.setLeave(hrLeaveTypeMaster);
		}

		if (requiredFrom != 0) {
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(requiredFrom);
			hrorderlyLeaveApplication.setRequiredFrom(masDistrict);
		}

		if (cityTo != 0) {
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(cityTo);
			hrorderlyLeaveApplication.setCityTo(masDistrict);
		}

		if (rajdhaniUpto != 0) {
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(rajdhaniUpto);
			hrorderlyLeaveApplication.setRajdhaniUpto(masDistrict);
		}

		if (districtName != 0) {
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(districtName);
			hrorderlyLeaveApplication.setDistrictName(masDistrict);
		}

		hrorderlyLeaveApplication.setLeaveFromDate(leaveFromDate);
		hrorderlyLeaveApplication.setDateOfReporting(dateOfReporting);
		hrorderlyLeaveApplication.setLeaveTotalDays(leaveDays);
		hrorderlyLeaveApplication.setAddlLeaveFromDate(addlLeaveFromDate);
		hrorderlyLeaveApplication.setAddlLeaveToDate(addlLeaveToDate);
		hrorderlyLeaveApplication.setAddlLeaveTotalDays(addlLeaveDays);
		hrorderlyLeaveApplication.setType(type);
		hrorderlyLeaveApplication.setAvailingLtc(availingLtc);
		hrorderlyLeaveApplication.setOtherTrainsUpto(otherTrainsUpto);
		hrorderlyLeaveApplication
				.setDrawingTransportAllowance(drawingTransportAllowance);
		hrorderlyLeaveApplication.setYear(ltcYear);
		hrorderlyLeaveApplication.setPreviousYear(previousYearLtcDetails);
		hrorderlyLeaveApplication.setUnderTr(underTr);
		hrorderlyLeaveApplication.setTrainClass(trainClass);
		hrorderlyLeaveApplication.setTicketForSide(ticketForSide);
		hrorderlyLeaveApplication
				.setReturnJourneyValidUpto(returnJourneyValidUpto);
		hrorderlyLeaveApplication.setFullName(fullName);
		hrorderlyLeaveApplication.setHouseName(houseName);
		hrorderlyLeaveApplication.setVillage(village);
		hrorderlyLeaveApplication.setPo(postOffice);
		hrorderlyLeaveApplication.setTelegraphOffice(telegraphOffice);
		hrorderlyLeaveApplication.setTelephoneNo(telephoneNo);
		hrorderlyLeaveApplication.setPoliceStation(policeStation);

		if (state != 0) {
			MasState masState = new MasState();
			masState.setId(state);
			hrorderlyLeaveApplication.setState(masState);
		}

		hrorderlyLeaveApplication.setSetOfCv(setOfCVs);
		hrorderlyLeaveApplication.setPin(pinCode);
		hrorderlyLeaveApplication.setLeaveAvailed(leaveAvailed);
		hrorderlyLeaveApplication.setDaysOfCl(daysOfCl);
		hrorderlyLeaveApplication.setNrs(nrs);
		hrorderlyLeaveApplication.setLstChangedBy(lstChangedBy);
		hrorderlyLeaveApplication.setLstChangedDate(lstChangedDate);
		hrorderlyLeaveApplication.setLstChangedTime(lstChangedTime);
		hrorderlyLeaveApplication.setStatus("y");
		hrorderlyLeaveApplication.setApprovedStatus("w");
		generalMap.put("id", id);
		Boolean successfullyAdded=false;
		map = hrOrderlyRoomHandlerService.addLeaveApplication(hrorderlyLeaveApplication, familyDetails,
						generalMap);

		String message = "";
		String jsp="";
		String entryNo="";
		if (((Boolean)map.get("successfullyAdded"))==true) {
			message = "Record Added Successfully !!";
			jsp = "printLeaveApplication";
			map.put("employee_id",id);
			
		} else {
			message = "Problem in adding Leave Application !";
			jsp = LEAVE_APPLICATION;
			map = hrOrderlyRoomHandlerService.showLeaveApplicationJsp(id);
			entryNo = hrOrderlyRoomHandlerService
			.generateLeaveApplicationEntryNumber(userName);
		}
				
		jsp += ".jsp";
		map.put("entryNo", entryNo);
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView showLeaveChoiceApprovalJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String userName = "";
		String title = "";
		map = hrOrderlyRoomHandlerService.showLeaveChoiceApprovalJsp();
		jsp += LEAVE_CHOICE_APPROVAL_JSP;
		jsp += ".jsp";
		title = "SearchLeaveChoiceApproval";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView updateLeaveChoiceApprovalJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String userName = "";
		String title = "";
		String message="";
		Box box = HMSUtil.getBox(request);
		boolean successfull=false;
		successfull = hrOrderlyRoomHandlerService.updateLeaveChoiceApprovalJsp(box);
		if(successfull)
		message="Record is Update Successfully";
		else
		message="try Again"	;
		map = hrOrderlyRoomHandlerService.showLeaveChoiceApprovalJsp();
		jsp += LEAVE_CHOICE_APPROVAL_JSP;
		jsp += ".jsp";
		title = "UpdateLeaveChoiceApproval";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView searchLeaveChoiceApprovalJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String selectedRadio = null;
		String searchfield = null;
		try {
			if (request.getParameter(SELECTED_RADIO) != null&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				selectedRadio = request.getParameter(SELECTED_RADIO);
			}
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchfield = request.getParameter(SEARCH_FIELD);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = hrOrderlyRoomHandlerService.searchLeaveChoiceApprovalJsp(selectedRadio,searchfield);
		jsp = LEAVE_CHOICE_APPROVAL_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("entryNo", entryNo);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView showLeaveApplicationPendingJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String userName = "";
		String title = "";
		map = hrOrderlyRoomHandlerService.showLeaveApplicationPendingJsp();
		jsp += LEAVE_APPLICATION_PENDING_JSP;
		jsp += ".jsp";
		title = "SearchLeaveRestriction";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editleaveAppPending(HttpServletRequest request,	HttpServletResponse response) {
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		String message = "";
		String entryDate = "";
		String fromPeriod = "";
		String toPeriod = "";
		String leaveType = "";
		String maxLeaveDays = "";
		String remarks = "";
		String lastChangedBy = "";
		Date lastChangedDate = null;
		String lastChangedTime = "";
		String pojoPropertyName = "";
		String pojoName = "";

		if (request.getParameter(ENTRY_DATE) != null
				&& !(request.getParameter(ENTRY_DATE).equals(""))) {
			entryDate = request.getParameter(ENTRY_DATE);
		}
		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromPeriod = request.getParameter(FROM_DATE);
		}
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toPeriod = request.getParameter(TO_DATE);
		}

		if (request.getParameter(LEAVE_TYPE) != null
				&& !(request.getParameter(LEAVE_TYPE).equals(""))) {
			leaveType = request.getParameter(LEAVE_TYPE);
		}
		if (request.getParameter(MAX_LEAVE_DAYS) != null
				&& !(request.getParameter(MAX_LEAVE_DAYS).equals(""))) {
			maxLeaveDays = request.getParameter(MAX_LEAVE_DAYS);
		}
		if (request.getParameter(REMARKS) != null
				&& !(request.getParameter(REMARKS).equals(""))) {
			remarks = request.getParameter(REMARKS);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			lastChangedBy = request.getParameter(CHANGED_BY);
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
		lastChangedDate = new Date();
		lastChangedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", leaveRestrictionId);
		generalMap.put("entryDate", entryDate);
		generalMap.put("fromDate", fromPeriod);
		generalMap.put("toDate", toPeriod);
		generalMap.put("leaveType", leaveType);
		generalMap.put("maxLeaveDays", maxLeaveDays);
		generalMap.put("remarks", remarks);
		generalMap.put("lastChangedBy", lastChangedBy);
		generalMap.put("currentDate", lastChangedDate);
		generalMap.put("currentTime", lastChangedTime);
		generalMap.put("pojoName", pojoName);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("title", title);

		generalMap.put("flag", true);

		boolean dataUpdated = false;
		dataUpdated = hrOrderlyRoomHandlerService
				.editLeaveRestrictionUpdateToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant be updated !!";
		}
		map = hrOrderlyRoomHandlerService.showLeaveRestrictionEntryJsp();
		jsp = LEAVE_RESTRICTION_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showSearchLeaveApplicationJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String userName = "";
		String title = "";
		map = hrOrderlyRoomHandlerService.showSearchLeaveApplicationJsp();
		jsp += SEARCH_LEAVE_APPLICATION_JSP;
		jsp += ".jsp";
		title = "SearchLeaveApplication";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchleaveApplication(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String entryNo = null;
		String serviceNo = null;
		try {
			if (request.getParameter(ENTRY_NO) != null
					&& !(request.getParameter(ENTRY_NO).equals(""))) {
				entryNo = request.getParameter(ENTRY_NO);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
			}
			//System.out.println("entryNo" + entryNo + "serviceNo" + serviceNo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = hrOrderlyRoomHandlerService.searchleaveApplication(entryNo,
				serviceNo);
		jsp = SEARCH_LEAVE_APPLICATION_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("entryNo", entryNo);
		return new ModelAndView("indexB", "map", map);
	}

	private int leaveApplicationId;

	public ModelAndView showLeaveApplicationUpdateJsp(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();

		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String entryNo = "";
		setLeaveApplicationId(Integer.parseInt(request.getParameter("LeaveAppID")));
		int Id = getLeaveApplicationId();
		map = hrOrderlyRoomHandlerService.showLeaveApplicationUpdateJsp(Id);

		jsp = LEAVE_APPLICATION_UPDATE;
		jsp += ".jsp";
		title = "Pool Category";
		map.put("contentJsp", jsp);
		map.put("entryNo", entryNo);
		map.put("title", title);
		map.put("Id", Id);

		return new ModelAndView("indexB", "map", map);
	}

	public int getLeaveApplicationId() {
		return leaveApplicationId;
	}

	public void setLeaveApplicationId(int leaveApplicationId) {
		this.leaveApplicationId = leaveApplicationId;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editLeaveApplicationUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		String message = "";
		String entryDate = "";
		int leaveType = 0;
		String fromDate = "";
		String toDate = "";
		String totalDays = "";
		String aLeaveFromDate = "";
		String aLeaveToDate = "";
		String aLeaveTotalDays = "";
		String type = "";
		int requiredFrom = 0;
		int cityTo = 0;
		int rajdhaniUpto = 0;
		String availingLtc = "";
		String otherTrainUpto = "";
		String drawingTransportAllowance = "";
		int ltcYear = 0;
		int previousYearLtcDetails = 0;
		String underTr = "";
		String class1 = "";
		String ticketForside = "";
		String returnJourneyValidUpto = "";
		String fullName = "";
		String houseName = "";
		String village = "";
		String po = "";
		String telegraphOffice = "";
		int districtName = 0;
		int state = 0;
		String pin = "";
		String telNo = "";
		String setOfCvs = "";
		String nrs = "";
		String lastChangedBy = "";
		Date lastChangedDate = null;
		String lastChangedTime = "";
		String pojoPropertyName = "";
		String pojoName = "";

		String selectFamily = "";
		String dob = "";
		String age = "";
		String dependentPorNo = "";
		int Id = 0;

		List<LeaveApplicationDTO> leaveApplicationDTOList = new ArrayList<LeaveApplicationDTO>();
		List<FamilyDetails> familyDetailsList = new ArrayList<FamilyDetails>();

		Vector<String> v2 = box.getVector(FAMILY);
		Vector<String> v3 = box.getVector(DATE_OF_BIRTH);
		Vector<String> v4 = box.getVector(AGE);
		Vector<String> v5 = box.getVector(POR_NUMBER);

		/*
		 * int count = box.getInt("counter");
		 * 
		 * for (int i = 0; i < v2.size(); i++) { FamilyDetails familyDetails =
		 * new FamilyDetails();
		 * familyDetails.setDob(HMSUtil.convertStringTypeDateToDateType
		 * (v2.get(i)));
		 * familyDetails.setAge(Integer.parseInt(v3.get(i).toString()));
		 * familyDetails.setDependentPorNo(v5.get(i)); }
		 * 
		 * 
		 * for (int i = 0; i < v2.size(); i++) { LeaveApplicationDTO
		 * leaveApplicationDTO = new LeaveApplicationDTO();
		 * leaveApplicationDTO.setId(v1.get(i)); if (!(v2.get(i).equals(""))) {
		 * leaveApplicationDTO.setDob(v2.get(i)); }
		 * leaveApplicationDTO.setAge(v3.get(i));
		 * leaveApplicationDTO.setSelectFamily(v4.get(i));
		 * leaveApplicationDTO.setDependentPorNo(v5.get(i));
		 * 
		 * leaveApplicationDTOList.add(leaveApplicationDTO);
		 *  }
		 */
		//System.out.println("leaveApplicationDTO1size"+ leaveApplicationDTOList.size());

		if (request.getParameter(ENTRY_DATE) != null
				&& !(request.getParameter(ENTRY_DATE).equals(""))) {
			entryDate = request.getParameter(ENTRY_DATE);
		}
		if (request.getParameter(LEAVE_TYPE) != null
				&& !(request.getParameter(LEAVE_TYPE).equals(""))) {
			leaveType = Integer.parseInt(request.getParameter(LEAVE_TYPE));
		}

		if (request.getParameter(LEAVE_FROM_DATE) != null
				&& !(request.getParameter(LEAVE_FROM_DATE).equals(""))) {
			fromDate = request.getParameter(LEAVE_FROM_DATE);
		}
		if (request.getParameter(LEAVE_TO_DATE) != null
				&& !(request.getParameter(LEAVE_TO_DATE).equals(""))) {
			toDate = request.getParameter(LEAVE_TO_DATE);
		}

		if (request.getParameter(LEAVE_DAYS) != null
				&& !(request.getParameter(LEAVE_DAYS).equals(""))) {
			totalDays = request.getParameter(LEAVE_DAYS);
		}
		if (request.getParameter(ADDL_LEAVE_FROM_DATE) != null
				&& !(request.getParameter(ADDL_LEAVE_FROM_DATE).equals(""))) {
			aLeaveFromDate = request.getParameter(ADDL_LEAVE_FROM_DATE);
		}
		if (request.getParameter(ADDL_LEAVE_TO_DATE) != null
				&& !(request.getParameter(ADDL_LEAVE_TO_DATE).equals(""))) {
			aLeaveToDate = request.getParameter(ADDL_LEAVE_TO_DATE);
		}
		if (request.getParameter(ADDL_LEAVE_DAYS) != null
				&& !(request.getParameter(ADDL_LEAVE_DAYS).equals(""))) {
			aLeaveTotalDays = request.getParameter(ADDL_LEAVE_DAYS);
		}
		if (request.getParameter(TYPE) != null
				&& !(request.getParameter(TYPE).equals(""))) {
			type = request.getParameter(TYPE);
		}
		if (request.getParameter(REQUIRED_FROM) != null
				&& !request.getParameter(REQUIRED_FROM).equals("")) {
			requiredFrom = Integer
					.parseInt(request.getParameter(REQUIRED_FROM));
			//System.out.println("requierdfrom" + requiredFrom);
		}
		if (request.getParameter(CITY_TO) != null
				&& !request.getParameter(CITY_TO).equals("")) {
			cityTo = Integer.parseInt(request.getParameter(CITY_TO));
		}
		if (request.getParameter(RAJDHANI_UPTO) != null
				&& !request.getParameter(RAJDHANI_UPTO).equals("")) {
			rajdhaniUpto = Integer
					.parseInt(request.getParameter(RAJDHANI_UPTO));
			//System.out.println("rajdhani" + rajdhaniUpto);
		}
		if (request.getParameter(AVAILING_LTC) != null
				&& !(request.getParameter(AVAILING_LTC).equals(""))) {
			availingLtc = request.getParameter(AVAILING_LTC);
		}

		if (request.getParameter(OTHER_TRAINS_UPTO) != null
				&& !(request.getParameter(OTHER_TRAINS_UPTO).equals(""))) {
			otherTrainUpto = request.getParameter(OTHER_TRAINS_UPTO);
		}

		if (request.getParameter(DRAWING_TRANSPORT_ALLOWANCE) != null
				&& !(request.getParameter(DRAWING_TRANSPORT_ALLOWANCE)
						.equals(""))) {
			drawingTransportAllowance = request
					.getParameter(DRAWING_TRANSPORT_ALLOWANCE);
		}
		if (request.getParameter(LTC_YEAR) != null
				&& request.getParameter(LTC_YEAR) != "") {
			ltcYear = Integer.parseInt(request.getParameter(LTC_YEAR));
		}
		if (request.getParameter(PREVIOUS_YEAR_LTC_DETAILS) != null
				&& request.getParameter(PREVIOUS_YEAR_LTC_DETAILS) != "") {
			previousYearLtcDetails = Integer.parseInt(request
					.getParameter(PREVIOUS_YEAR_LTC_DETAILS));
		}
		if (request.getParameter(UNDER_TR) != null
				&& !(request.getParameter(UNDER_TR).equals(""))) {
			underTr = request.getParameter(UNDER_TR);
		}
		if (request.getParameter(TRAIN_CLASS) != null
				&& !(request.getParameter(TRAIN_CLASS).equals(""))) {
			class1 = request.getParameter(TRAIN_CLASS);
		}
		if (request.getParameter(TICKET_FOR_SIDE) != null
				&& !(request.getParameter(TICKET_FOR_SIDE).equals(""))) {
			ticketForside = request.getParameter(TICKET_FOR_SIDE);
		}
		if (request.getParameter(RETURN_JOURNEY_VALID_UPTO) != null
				&& !(request.getParameter(RETURN_JOURNEY_VALID_UPTO).equals(""))) {
			returnJourneyValidUpto = request
					.getParameter(RETURN_JOURNEY_VALID_UPTO);
		}
		if (request.getParameter(FULL_NAME) != null
				&& !(request.getParameter(FULL_NAME).equals(""))) {
			fullName = request.getParameter(FULL_NAME);
		}
		if (request.getParameter(HOUSE_NAME) != null
				&& !(request.getParameter(HOUSE_NAME).equals(""))) {
			houseName = request.getParameter(HOUSE_NAME);
		}
		if (request.getParameter(VILLAGE) != null
				&& !(request.getParameter(VILLAGE).equals(""))) {
			village = request.getParameter(VILLAGE);
		}
		if (request.getParameter(POST_OFFICE) != null
				&& !(request.getParameter(POST_OFFICE).equals(""))) {
			po = request.getParameter(POST_OFFICE);
		}
		if (request.getParameter(TELEGRAPH_OFFICE) != null
				&& !(request.getParameter(TELEGRAPH_OFFICE).equals(""))) {
			telegraphOffice = request.getParameter(TELEGRAPH_OFFICE);
		}
		if (request.getParameter(DISTRICT) != null
				&& !request.getParameter(DISTRICT).equals("")) {
			districtName = Integer.parseInt(request.getParameter(DISTRICT));

		}
		if (request.getParameter(STATE) != null
				&& !request.getParameter(STATE).equals("")) {
			state = Integer.parseInt(request.getParameter(STATE));
		}
		if (request.getParameter(PINCODE) != null
				&& !(request.getParameter(PINCODE).equals(""))) {
			pin = request.getParameter(PINCODE);
		}
		if (request.getParameter(TELEPHONE_NO) != null
				&& !(request.getParameter(TELEPHONE_NO).equals(""))) {
			telNo = request.getParameter(TELEPHONE_NO);
		}
		if (request.getParameter(SET_OF_CVs) != null
				&& !(request.getParameter(SET_OF_CVs).equals(""))) {
			setOfCvs = request.getParameter(SET_OF_CVs);
		}
		if (request.getParameter(NRS) != null
				&& !(request.getParameter(NRS).equals(""))) {
			nrs = request.getParameter(nrs);
		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			lastChangedBy = request.getParameter(CHANGED_BY);
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
		if (request.getParameter("Id") != null
				&& !(request.getParameter("Id").equals(""))) {
			Id = Integer.parseInt(request.getParameter("Id"));
		}
		lastChangedDate = new Date();
		lastChangedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		//System.out.println("Id in ctrlaaaa== " + Id);

		for (int i = 0; i < v2.size(); i++) {
			FamilyDetails familydetails = new FamilyDetails();
			familydetails.setSelectFamily(v2.get(i));
			if (!(v3.get(i).equals(""))) {
				familydetails.setDob(HMSUtil.dateFormatterDDMMYYYY(v3.get(i)));
			}
			familydetails.setAge(Integer.parseInt(v4.get(i)));
			familydetails.setDependentPorNo(v5.get(i));
			familydetails.setLeaveApplication(Id);
			familyDetailsList.add(familydetails);

		}
		generalMap.put("Id", Id);
		generalMap.put("familyDetailsList", familyDetailsList);
		generalMap.put("entryDate", entryDate);
		generalMap.put("leaveType", leaveType);
		generalMap.put("fromDate", fromDate);
		generalMap.put("toDate", toDate);
		generalMap.put("totalDays", totalDays);
		generalMap.put("aLeaveFromDate", aLeaveFromDate);
		generalMap.put("aLeaveToDate", aLeaveToDate);
		generalMap.put("aLeaveTotalDays", aLeaveTotalDays);
		generalMap.put("type", type);
		generalMap.put("requiredFrom", requiredFrom);
		generalMap.put("cityTo", cityTo);
		generalMap.put("rajdhaniUpto", rajdhaniUpto);
		generalMap.put("availingLtc", availingLtc);
		generalMap.put("otherTrainUpto", otherTrainUpto);
		generalMap.put("drawingTransportAllowance", drawingTransportAllowance);
		generalMap.put("ltcYear", ltcYear);
		generalMap.put("previousYearLtcDetails", previousYearLtcDetails);
		generalMap.put("underTr", underTr);
		generalMap.put("class1", class1);
		generalMap.put("ticketForside", ticketForside);
		generalMap.put("returnJourneyValidUpto", returnJourneyValidUpto);
		generalMap.put("fullName", fullName);
		generalMap.put("houseName", houseName);
		generalMap.put("village", village);
		generalMap.put("po", po);
		generalMap.put("telegraphOffice", telegraphOffice);
		generalMap.put("districtName", districtName);
		generalMap.put("state", state);
		generalMap.put("pin", pin);
		generalMap.put("telNo", telNo);
		generalMap.put("setOfCvs", setOfCvs);
		generalMap.put("nrs", nrs);
		generalMap.put("leaveApplicationDTOList", leaveApplicationDTOList);

		generalMap.put("lastChangedBy", lastChangedBy);
		generalMap.put("currentDate", lastChangedDate);
		generalMap.put("currentTime", lastChangedTime);
		generalMap.put("pojoName", pojoName);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("title", title);
		generalMap.put("flag", true);

		boolean dataUpdated = false;
		dataUpdated = hrOrderlyRoomHandlerService
				.editLeaveApplicationUpdateToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant be updated !!";
		}
		map = hrOrderlyRoomHandlerService.showSearchLeaveApplicationJsp();
		jsp = SEARCH_LEAVE_APPLICATION_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView submitLeavePendingEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> employeeMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int leaveId = 0;
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		successfullyAdded = hrOrderlyRoomHandlerService.submitLeavePendingEntry(box);

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";

		}
		// employeeMap =
		// hrRelatedHandlerService.searchEmployeeForLeavePending(employeeMap);
		map = hrOrderlyRoomHandlerService.showLeaveApplicationPendingJsp();
		map.put("message", message);
		// map.put("employeeMap", employeeMap);
		jsp = LEAVE_APPLICATION_PENDING_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView addleaveAppPending(HttpServletRequest request,
			HttpServletResponse response) {
		//System.out.println("in controller");
		String approved = "";
		int approvedBy = 0;
		int leaveId = 0;
		Date approvedDate = null;
		String remarks = "";
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		EmpLeaveBalance empLeaveBalance = null;
		HttpSession session = request.getSession();

		if (request.getParameter(COMMON_ID) != null
				|| !request.getParameter(COMMON_ID).equals("")) {
			id = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (!request.getParameter("leaveId").equals("")) {
			leaveId = Integer.parseInt(request.getParameter("leaveId"));
			//System.out.println("leaveIDDDDDDDD" + leaveId);
		}

		if (id == 0) {
			empLeaveBalance = new EmpLeaveBalance();
			empLeaveBalance.setId(id);
		} else {
			empLeaveBalance = (EmpLeaveBalance) commonMasterHandlerService
					.loadObject(EmpLeaveBalance.class, id);
		}
		if (request.getParameter(APPROVED) != null) {
			approved = request.getParameter(APPROVED);
			//System.out.println("approved" + approved);
		}

		if (request.getParameter(APPROVED_BY) != null) {
			approvedBy = Integer.parseInt(request.getParameter(APPROVED_BY));
			//System.out.println("approveddddby" + approvedBy);
		}
		if (request.getParameter(APPROVED_DATE) != null) {
			approvedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(APPROVED_DATE));
		}
		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
			//System.out.println("remarks" + remarks);

		}

		if (leaveId != 0) {

			HrorderlyLeaveApplication hrorderlyLeaveApplication = new HrorderlyLeaveApplication();
			hrorderlyLeaveApplication.setId(leaveId);
			empLeaveBalance.setLeaveApp(hrorderlyLeaveApplication);
		}

		empLeaveBalance.setApproved(approved);
		empLeaveBalance.setApprovedBy(new MasEmployee(approvedBy));
		empLeaveBalance.setApprovedDate(approvedDate);
		empLeaveBalance.setRemarks(remarks);
		generalMap.put("leaveId", leaveId);
		Boolean successfullyAdded = hrOrderlyRoomHandlerService
				.addleaveAppPending(empLeaveBalance, generalMap);

		String message = "";

		if (successfullyAdded) {
			message = "Record Added Successfully!!";
		} else {
			message = "Problem in Adding Leave Restriction Entry Entry";
		}
		String entryNo = hrOrderlyRoomHandlerService
				.generateLeaveApplicationEntryNumber("userName");
		//System.out.println("entryno in addleaveApplication" + entryNo);

		String jsp = LEAVE_APPLICATION_PENDING_JSP;
		jsp += ".jsp";

		map = hrOrderlyRoomHandlerService.showLeaveApplicationPendingJsp();
		map.put("entryNo", entryNo);
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// // LEAVE RESTRICTION ENTRY

	public ModelAndView showLeaveRestrictionEntryJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String jsp = "";
		String userName = "";
		String title = "";
		String entryNo = "";
		entryNo = hrOrderlyRoomHandlerService
				.generateLeaveRestrictionEntryNumber(infoMap);
		map = hrOrderlyRoomHandlerService.showLeaveRestrictionEntryJsp();
		jsp += LEAVE_RESTRICTION_JSP;
		jsp += ".jsp";
		title = "LeaveRestrictionEntry";
		map.put("entryNo", entryNo);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	// method to add records from leave restriction entry

	public ModelAndView addLeaveRestrictionEntry(HttpServletRequest request,
			HttpServletResponse response) {
		String entryNo = "";
		Date entryDate = null;
		Date fromPeriod = null;
		Date toPeriod = null;
		int leaveType = 0;
		int maxLeaveDays = 0;
		String remarks = "";
		String lastChangedBy = "";
		Date lastChangedDate = null;
		String lastChangedTime = "";

		int id = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		LeaveRestrictionEntry leaveRestrictionEntry = new LeaveRestrictionEntry();
		if (request.getParameter("id") != null
				&& !request.getParameter("id").equals("")) {
			id = Integer.parseInt(request.getParameter("id"));
		}

		if (request.getParameter(ENTRY_NO) != null) {
			entryNo = request.getParameter(ENTRY_NO);

		}
		if (request.getParameter(ENTRY_DATE) != null) {
			entryDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(ENTRY_DATE));
		}
		if (request.getParameter(FROM_DATE) != null) {
			fromPeriod = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toPeriod = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(LEAVE_TYPE) != null) {
			leaveType = Integer.parseInt(request.getParameter(LEAVE_TYPE));

		}
		if (request.getParameter(MAX_LEAVE_DAYS) != null) {
			maxLeaveDays = Integer.parseInt(request
					.getParameter(MAX_LEAVE_DAYS));
		}
		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);

		}
		if (request.getParameter(CHANGED_BY) != null) {
			lastChangedBy = request.getParameter(CHANGED_BY);

		}

		if (request.getParameter(CHANGED_DATE) != null) {
			lastChangedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}

		if (request.getParameter(CHANGED_TIME) != null) {
			lastChangedTime = request.getParameter(CHANGED_TIME);
		}
		leaveRestrictionEntry.setEntryNo(entryNo);
		leaveRestrictionEntry.setId(id);
		leaveRestrictionEntry.setEntryDate(entryDate);
		leaveRestrictionEntry.setFromPeriod(fromPeriod);
		leaveRestrictionEntry.setToPeriod(toPeriod);

		if (leaveType != 0) {
			HrLeaveTypeMaster hrLeaveTypeMaster = new HrLeaveTypeMaster();
			hrLeaveTypeMaster.setId(leaveType);
			leaveRestrictionEntry.setLeave(hrLeaveTypeMaster);
		}

		leaveRestrictionEntry.setMaxLeaveDays(maxLeaveDays);
		leaveRestrictionEntry.setFromPeriod(fromPeriod);
		leaveRestrictionEntry.setLastChangedBy(lastChangedBy);
		leaveRestrictionEntry.setLastChangedDate(lastChangedDate);
		leaveRestrictionEntry.setLastChangedTime(lastChangedTime);
		leaveRestrictionEntry.setStatus("y");
		leaveRestrictionEntry.setRemarks(remarks);

		Boolean successfullyAdded = hrOrderlyRoomHandlerService
				.addLeaveRestrictionEntry(leaveRestrictionEntry);

		String message = "";

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Problem in adding Posted Out Entry !";
		}
		try {
			Map<String, Object> infoMap = new HashMap<String, Object>();
			entryNo = hrOrderlyRoomHandlerService
					.generateLeaveRestrictionEntryNumber(infoMap);
			map = hrOrderlyRoomHandlerService.showLeaveRestrictionEntryJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsp = LEAVE_RESTRICTION_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("entryNo", entryNo);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// method to show serch leave restriction jsp

	public ModelAndView showSearchLeaveRestrictionJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String userName = "";
		String title = "";
		map = hrOrderlyRoomHandlerService.showLeaveRestrictionEntryJsp();
		jsp += SEARCH_LEAVE_RESTRICTION_JSP;
		jsp += ".jsp";
		title = "SearchLeaveRestriction";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	private int leaveRestrictionId;

	public ModelAndView showLeaveRestrictionUpdateJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String userName = "";
		String title = "";
		setLeaveRestrictionId(Integer.parseInt(request
				.getParameter("leaveRestrictionId")));
		int Id = getLeaveRestrictionId();
		map = hrOrderlyRoomHandlerService.showLeaveRestrictionUpdateJsp(Id);
		jsp += UPDATE_LEAVE_RESTRICTION_JSP;
		jsp += ".jsp";
		title = "UpdateLeaveRestriction";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);
	}

	public Integer getLeaveRestrictionId() {
		return leaveRestrictionId;
	}

	public void setLeaveRestrictionId(Integer leaveRestrictionId) {
		this.leaveRestrictionId = leaveRestrictionId;
	}

	public ModelAndView searchleaveRestrictionEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String entryNo = null;
		Date entryDate = null;
		try {
			if (request.getParameter(ENTRY_NO) != null
					&& !(request.getParameter(ENTRY_NO).equals(""))) {
				entryNo = request.getParameter(ENTRY_NO);
			}
			if (request.getParameter(ENTRY_DATE) != null
					&& !(request.getParameter(ENTRY_DATE).equals(""))) {
				entryDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(ENTRY_DATE));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = hrOrderlyRoomHandlerService.searchLeaveRestrictionEntry(entryNo,
				entryDate);
		jsp = SEARCH_LEAVE_RESTRICTION_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("entryNo", entryNo);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editLeaveRestrictionUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		String message = "";
		Date entryDate = null;
		Date fromPeriod = null;
		Date toPeriod = null;
		int leaveType = 0;
		String maxLeaveDays = "";
		String remarks = "";
		String lastChangedBy = "";
		Date lastChangedDate = null;
		String lastChangedTime = "";
		String pojoPropertyName = "";
		String pojoName = "";

		if (request.getParameter(ENTRY_DATE) != null
				&& !(request.getParameter(ENTRY_DATE).equals(""))) {
			entryDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(ENTRY_DATE));
		}
		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromPeriod = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
		}

		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toPeriod = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TO_DATE));
		}

		if (request.getParameter(LEAVE_TYPE) != null
				&& !(request.getParameter(LEAVE_TYPE).equals(""))) {
			leaveType = Integer.parseInt(request.getParameter(LEAVE_TYPE));
		}
		if (request.getParameter(MAX_LEAVE_DAYS) != null
				&& !(request.getParameter(MAX_LEAVE_DAYS).equals(""))) {
			maxLeaveDays = request.getParameter(MAX_LEAVE_DAYS);
		}
		if (request.getParameter(REMARKS) != null
				&& !(request.getParameter(REMARKS).equals(""))) {
			remarks = request.getParameter(REMARKS);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			lastChangedBy = request.getParameter(CHANGED_BY);
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
		lastChangedDate = new Date();
		lastChangedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", leaveRestrictionId);
		generalMap.put("entryDate", entryDate);
		generalMap.put("fromPeriod", fromPeriod);
		generalMap.put("toDate", toPeriod);
		generalMap.put("leaveType", leaveType);
		generalMap.put("maxLeaveDays", maxLeaveDays);
		generalMap.put("remarks", remarks);
		generalMap.put("lastChangedBy", lastChangedBy);
		generalMap.put("currentDate", lastChangedDate);
		generalMap.put("currentTime", lastChangedTime);
		generalMap.put("pojoName", pojoName);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("title", title);

		generalMap.put("flag", true);

		boolean dataUpdated = false;
		dataUpdated = hrOrderlyRoomHandlerService
				.editLeaveRestrictionUpdateToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant be updated !!";
		}
		try {

			hrOrderlyRoomHandlerService.showSearchLeaveRestrictionJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = SEARCH_LEAVE_RESTRICTION_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// / Show Proposal For HRO

	public ModelAndView showProposalForHro(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String entryNo = "";
		Map<String, Object> diagMap = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		entryNo = hrOrderlyRoomHandlerService
				.generateProposalHroEntryNo(diagMap);
		if (entryNo != "") {
			map.put("entryNo", entryNo);
		}
		//System.out.println("entryno" + entryNo);
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		// map = hrOrderlyRoomHandlerService.showDepartment(deptId);
		map = hrOrderlyRoomHandlerService.showProposalForHro();

		jsp = PROPOSAL_HRO_ENTRY_JSP;
		jsp += ".jsp";
		title = "Proposal For HRo Entry";

		map.put("title", title);
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("entryNo", entryNo);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);
	}

	// // Add Proposal For HRO

	public ModelAndView addProposalForHro(HttpServletRequest request,
			HttpServletResponse response) {
		String entryNo = "";
		String departmentName = "";
		int employeeName = 0;
		Date entryDate = null;
		String subjectName = "";
		String subcontent = "";
		String textContent = "";

		Map<String, Object> map = new HashMap<String, Object>();
		ProposalForHroEntry proposalForHroEntry = new ProposalForHroEntry();
		String changed_by = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		if (request.getParameter(DEPARTMENT_NAME) != null) {
			departmentName = request.getParameter(DEPARTMENT_NAME);
		}
		if (request.getParameter(APPROVED_BY) != null) {
			employeeName = Integer.parseInt(request.getParameter(APPROVED_BY));
		}

		if (request.getParameter(ENTRY_NO) != null) {
			entryNo = request.getParameter(ENTRY_NO);
		}

		if (request.getParameter(ENTRY_DATE) != null) {
			entryDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(ENTRY_DATE));
		}
		if (request.getParameter(SUBJECT_NAME) != null) {
			subjectName = request.getParameter(SUBJECT_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null) {
			lstChangedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null) {
			lstChangedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}

		if (request.getParameter(CHANGED_TIME) != null) {
			lstChangedTime = request.getParameter(CHANGED_TIME);
		}

		if (request.getParameter(TEXT_CONTENT) != null) {
			textContent = request.getParameter(TEXT_CONTENT);
		}

		if (employeeName != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeName);
			proposalForHroEntry.setEmployeeName(masEmployee);
		}
		generalMap.put("entryNo", entryNo);
		generalMap.put("departmentName", departmentName);
		generalMap.put("employeeName", employeeName);
		generalMap.put("entryDate", entryDate);
		generalMap.put("subjectName", subjectName);
		generalMap.put("textContent", textContent);
		generalMap.put("lastChangedBy", lstChangedBy);
		generalMap.put("lastChangedDate", lstChangedDate);
		generalMap.put("lastChangedTime", lstChangedTime);

		proposalForHroEntry.setEntryNo(entryNo);
		proposalForHroEntry.setPropsalDate(entryDate);
		proposalForHroEntry.setDepartmentName(departmentName);
		proposalForHroEntry.setSubject(subjectName);
		proposalForHroEntry.setTextContent(textContent);
		proposalForHroEntry.setLstChangedBy(lstChangedBy);
		proposalForHroEntry.setLstChangedDate(lstChangedDate);
		proposalForHroEntry.setLstChangedTime(lstChangedTime);
		proposalForHroEntry.setStatus("y");
		proposalForHroEntry.setDispatch("p");

		Boolean successfullyAdded = hrOrderlyRoomHandlerService
				.addProposalForHro(proposalForHroEntry);

		String message = "";

		if (successfullyAdded) {
			message = "Record Added Successfully!!";
		} else {
			message = "Problem in HRO Entry";
		}

		try {
			map = hrOrderlyRoomHandlerService.showProposalForHro();

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> diagMap = new HashMap<String, Object>();
		entryNo = hrOrderlyRoomHandlerService
				.generateProposalHroEntryNo(diagMap);
		String jsp = PROPOSAL_HRO_ENTRY_JSP;
		jsp += ".jsp";
		map.put("entryNo", entryNo);
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// // Show HRO Entry

	public ModelAndView showHroEntry(HttpServletRequest request,
			HttpServletResponse response) {
		String entryNo = "";
		String serialNo="";
		String []generateSerialNo =null;
		session = request.getSession(true);
		Map<String, Object> diagMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		map = hrOrderlyRoomHandlerService.showHroEntry();
		entryNo = hrOrderlyRoomHandlerService.generateHroEntryNo(diagMap);
		diagMap = hrOrderlyRoomHandlerService.getPendingProposalList();
		generateSerialNo =entryNo.split("/");
		serialNo =""+generateSerialNo[0]+"/"+generateSerialNo[2];
		jsp = HRO_ENTRY_JSP;
		jsp += ".jsp";
		title = "HRO Entry";
		map.put("contentJsp", jsp);
		map.put("entryNo", entryNo);
		map.put("title", title);
		map.put("serialNo", serialNo);
		map.put("diagMap", diagMap);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView getPendingProposalList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String,Object>();
		map=hrOrderlyRoomHandlerService.getPendingProposalList();
		//System.out.println("in responce");
		jsp="responceForHroEntry";
		//map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
		
	}

	// // Add HRO Entry

	public ModelAndView addHroEntry(HttpServletRequest request,
			HttpServletResponse response) {
		String entryNo = "";
		String serialNo = "";
		String textContent = "";
		int commandantId=0;
		int adjudantId=0;
		String designation="";
		Date hroDate = null;
		Map<String, Object> map = new HashMap<String, Object>();
		HroEntry hroEntry = new HroEntry();
		String changed_by = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		if (request.getParameter(SERIAL_NO) != null) {
			serialNo = request.getParameter(SERIAL_NO);
		}
		if (request.getParameter(ENTRY_NO) != null) {
			entryNo = request.getParameter(ENTRY_NO);
		}

		if (request.getParameter(ENTRY_DATE) != null) {
			hroDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(ENTRY_DATE));
		}
		if (request.getParameter(TEXT_CONTENT) != null) {
			textContent = request.getParameter(TEXT_CONTENT);
		}
		if (request.getParameter(CHANGED_BY) != null) {
			lstChangedBy = request.getParameter(CHANGED_BY);
			//System.out.println("userName" + lstChangedBy);
		}
		if (request.getParameter(CHANGED_DATE) != null) {
			lstChangedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}

		if (request.getParameter(CHANGED_TIME) != null) {
			lstChangedTime = request.getParameter(CHANGED_TIME);
		}
		if(request.getParameter("commandantName")!=null && !request.getParameter("commandantName").equals(""))
		{
			commandantId=Integer.parseInt(request.getParameter("commandantName"));
		}
		if(request.getParameter("adjudantName")!=null && !request.getParameter("adjudantName").equals(""))
		{
			adjudantId=Integer.parseInt(request.getParameter("adjudantName"));
		}
        if(request.getParameter("designation")!=null)
        {
        	designation=request.getParameter("designation");
        }
		generalMap.put("entryNo", entryNo);
		generalMap.put("serialNo", serialNo);
		generalMap.put("entryDate", hroDate);
		generalMap.put("textContent", textContent);
		generalMap.put("lastChangedBy", lstChangedBy);
		generalMap.put("lstChangedDate", lstChangedDate);
		generalMap.put("lstChangedTime", lstChangedTime);

		hroEntry.setEntryNo(entryNo);
		hroEntry.setSerialNo(serialNo);
		hroEntry.setHroDate(hroDate);
		hroEntry.setTextContent(textContent);
		if(commandantId!=0){
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(commandantId);
			hroEntry.setNameOfCommandant(masEmployee);
		}
		if(adjudantId!=0){
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(adjudantId);
			hroEntry.setNameOfAdjudant(masEmployee);
		}
		hroEntry.setDesignation(designation);
		hroEntry.setLstChangedBy(lstChangedBy);
		hroEntry.setLstChangedDate(lstChangedDate);
		hroEntry.setLstChangedTime(lstChangedTime);
		hroEntry.setStatus("y");
        Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap = hrOrderlyRoomHandlerService
				.addHroEntry(hroEntry);

		String message = "";
		String jsp="";
		if (((Boolean)resultMap.get("successfullyAdded"))) {
			message = "Record Added Successfully !!";
			jsp="messageForHroEntry";
			map.put("hroEntryId",resultMap.get("Id") );
		} else {
			message = "Problem in adding Work Completion !";
			 jsp = HRO_ENTRY_JSP;
			 map = hrOrderlyRoomHandlerService.showHroEntry();
		}
		try {
			Map<String, Object> diagMap = new HashMap<String, Object>();
			
			entryNo = hrOrderlyRoomHandlerService.generateHroEntryNo(diagMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("entryNo", entryNo);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
    public ModelAndView printHroDetail(HttpServletRequest request , HttpServletResponse response ){
    	Map<String,Object> map = new HashMap<String,Object>();
    	Box box = HMSUtil.getBox(request);
    	map=hrOrderlyRoomHandlerService.printHroDetail(box);
    	String jsp="printHroEntry";
    	map.put("contentJsp", jsp);
    	return new ModelAndView(jsp,"map",map);
    }
	// / Method for Search Movement Out

	public ModelAndView searchMovementOut(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		Date currentDate = HMSUtil.convertStringTypeDateToDateType(date);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		mapForDs.put("currentDate", currentDate);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		detailsMap = hrOrderlyRoomHandlerService
				.getDetailsForSearchForMovementOut(dataMap);
		String jsp = SEARCH_MOVEMENT_OUT;
		jsp += ".jsp";

		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -------------------------method to
	 * search------------------------------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView searchRecordsForMovementOut(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {
		//System.out.println("searchRecordsForMovementOut");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serPersonFName = "";
		String serPersonLName = "";
		String serviceNo = "";
		int rankId = 0;
		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		session = request.getSession();

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		Map<String, Object> dataMap = new HashMap<String, Object>();
		infoMap.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
			infoMap.put("serviceNo", serviceNo);
		}
		if (request.getParameter(S_FIRST_NAME) != null
				&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
			serPersonLName = request.getParameter(S_FIRST_NAME);
			infoMap.put("serPersonLName", serPersonLName);
		}
		if (request.getParameter(S_LAST_NAME) != null
				&& !(request.getParameter(S_LAST_NAME).equals(""))) {
			serPersonFName = request.getParameter(S_LAST_NAME);
			infoMap.put("serPersonFName", serPersonFName);
		}
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals("0"))) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
			infoMap.put("rankId", rankId);
		}
		Map<String, Object> patientMap = new HashMap<String, Object>();
		patientMap = hrOrderlyRoomHandlerService
				.getMovementOutDetailsGrid(infoMap);
		
		jsp = SEARCH_MOVEMENT_OUT + ".jsp";
		map.put("contentJsp", jsp);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		return new ModelAndView("indexB", "map", map);
	}

	// / Method for Show Movement Out Jsp

	public ModelAndView showMovementOutJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		Map<String, Object> infomap = new HashMap<String, Object>();
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
		int Id = getEmployeeId();
		String employeecode=request.getParameter("employeecode");
		map = hrOrderlyRoomHandlerService.showMovementOutJsp(Id,employeecode);
		jsp = MOVEMENT_OUT_JSP;
		jsp += ".jsp";
		title = "Movement Out";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);
	}

	// / Method for Search Posted Out

	public ModelAndView searchPostedOut(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		Date currentDate = HMSUtil.convertStringTypeDateToDateType(date);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		mapForDs.put("currentDate", currentDate);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		detailsMap = hrOrderlyRoomHandlerService.getDetailsForSearchPostedOut(dataMap);
		String jsp = SEARCH_POSTED_OUT;
		jsp += ".jsp";

		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchRecordsForPostedOut(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> rankMap = new HashMap<String, Object>();
		String serPersonFName = "";
		String serPersonLName = "";
		String serviceNo = "";
		int rankId = 0;
		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		session = request.getSession();

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		Map<String, Object> dataMap = new HashMap<String, Object>();
		infoMap.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
			infoMap.put("serviceNo", serviceNo);
		}
		if (request.getParameter(S_FIRST_NAME) != null
				&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
			serPersonFName = request.getParameter(S_FIRST_NAME);
			infoMap.put("serPersonFName", serPersonFName);
		}
		if (request.getParameter(S_LAST_NAME) != null
				&& !(request.getParameter(S_LAST_NAME).equals(""))) {
			serPersonLName = request.getParameter(S_LAST_NAME);
			infoMap.put("serPersonLName", serPersonLName);
		}
		//System.out.println("fristNmae::::::" + serPersonFName	+ "Last name ::::::::::" + serPersonLName);
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals("0"))) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
			infoMap.put("rankId", rankId);
		}
		Map<String, Object> employeeMap = new HashMap<String, Object>();
		employeeMap = hrOrderlyRoomHandlerService
				.getPostedOutDetailsGrid(infoMap);
		rankMap = hrOrderlyRoomHandlerService
				.getDetailsForSearchPostedOut(dataMap);
		jsp = SEARCH_POSTED_OUT + ".jsp";
		map.put("contentJsp", jsp);
		map.put("patientMap", employeeMap);
		map.put("detailsMap", rankMap);
		return new ModelAndView("indexB", "map", map);
	}

	// / Method for Show Posted Out

	public ModelAndView showPostedOutJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		//String entryNo = "";
		Map<String, Object> infomap = new HashMap<String, Object>();

		// //System.out.println("EntryNo" + entryNo);
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
		int Id = getEmployeeId();
		map = hrOrderlyRoomHandlerService.showPostedOutJsp(Id);
		//entryNo = hrOrderlyRoomHandlerService.generatePostedOutEntryNo(infomap);
		jsp = POSTED_OUT_JSP;
		jsp += ".jsp";
		title = "Pool Category";
		map.put("contentJsp", jsp);
		//map.put("entryNo", entryNo);
		map.put("title", title);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);
	}

	// / Method for add Posted Out

	public ModelAndView addPostedOutEntry(HttpServletRequest request,
			HttpServletResponse response) {
		String entryNo = "";
		String porSlno = "";
		String authority = "";
		String remarks = "";
		Date appraisalReport = null;
		Date clearenceCompleted=null;
		String postedType = "";
		int postedoutId=0;
		int unitPostedTo = 0;
		Date postedDate = null;
		Date sors = null;
		int id = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		PostedOutEntry postedOutEntry = new PostedOutEntry();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		if (request.getParameter(POR_SLNO) != null)
		{
			porSlno = request.getParameter(POR_SLNO);
		}
		if (request.getParameter("id") != null&& !request.getParameter("id").equals(""))
		{
			id = Integer.parseInt(request.getParameter("id"));
		}
		if (request.getParameter(POSTED_TYPE) != null) {
			postedType = request.getParameter(POSTED_TYPE);
		}
		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
		}
		if (request.getParameter(ENTRY_NO) != null) {
			entryNo = request.getParameter(ENTRY_NO);
		}
		if (request.getParameter("postedoutId") != null && !request.getParameter("postedoutId").equals(""))
		{
			postedoutId = Integer.parseInt(request.getParameter("postedoutId"));
		}
		try {
			if (request.getParameter(APPRAISAL_REPORT) != null && request.getParameter(APPRAISAL_REPORT) != "") {
				appraisalReport = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(APPRAISAL_REPORT));
			}
			if (request.getParameter("clearenceCompleted") != null && request.getParameter("clearenceCompleted") != "") {
				clearenceCompleted=new Date();
				clearenceCompleted = HMSUtil.dateFormatterDDMMYYYY(request.getParameter("clearenceCompleted"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (request.getParameter(SORS) != null
				&& !(request.getParameter(SORS).equals(""))) {
			sors = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(SORS));
		}
		if (request.getParameter(UNIT_POSTED_TO) != null
				&& !request.getParameter(UNIT_POSTED_TO).equals("")) {
			unitPostedTo = Integer.parseInt(request
					.getParameter(UNIT_POSTED_TO));
		}
		if (request.getParameter(DATE) != null) {
			postedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DATE));
		}
		if (request.getParameter(AUTHORITY) != null) {
			authority = request.getParameter(AUTHORITY);
		}

		if (request.getParameter(CHANGED_BY) != null) {
			lstChangedBy = request.getParameter(CHANGED_BY);
			//System.out.println("userName" + lstChangedBy);
		}

		if (request.getParameter(CHANGED_DATE) != null) {
			lstChangedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}

		if (request.getParameter(CHANGED_TIME) != null) {
			lstChangedTime = request.getParameter(CHANGED_TIME);
		}
		if(postedoutId!=0){
			postedOutEntry.setId(postedoutId);
		}
        //System.out.println("postedoutId::::"+postedoutId);
		if (id != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(id);
			postedOutEntry.setEmployee(masEmployee);
		}
		if (unitPostedTo != 0) {
			MasUnit masUnit = new MasUnit();
			masUnit.setId(unitPostedTo);
			postedOutEntry.setUnitPostedTo(masUnit);
		}

		postedOutEntry.setPostedType(postedType);
		postedOutEntry.setEntryNo(entryNo);
		postedOutEntry.setPorSlno(porSlno);
		postedOutEntry.setAuthority(authority);
		postedOutEntry.setRemarks(remarks);

		postedOutEntry.setAppraisalReport(appraisalReport);
		postedOutEntry.setDate(postedDate);
		postedOutEntry.setSors(sors);
		postedOutEntry.setLstChangedBy(lstChangedBy);
		postedOutEntry.setLstChangedDate(lstChangedDate);
		postedOutEntry.setLstChangedTime(lstChangedTime);
		if(clearenceCompleted!=null){
		postedOutEntry.setStatus("y");
		postedOutEntry.setClearenceCompleted(clearenceCompleted);
		}else{
			postedOutEntry.setStatus("n");
		}

		map = hrOrderlyRoomHandlerService.addPostedOutEntry(postedOutEntry);

		String message = "";
		String jsp="";
		if ((Boolean)map.get("successfullyAdded")==true) {
			message = "Record Added Successfully !!";
			jsp="printClearence";
			//System.out.println("employee_id::::"+((PostedOutEntry)map.get("postedOutEntry")).getEmployee().getId()+"::::::rank:::"+((PostedOutEntry)map.get("postedOutEntry")).getEmployee().getRank().getRankCategory().getId());
			map.put("employee_id",((PostedOutEntry)map.get("postedOutEntry")).getEmployee().getId());
			map.put("rankCategoryId",((PostedOutEntry)map.get("postedOutEntry")).getEmployee().getRank().getRankCategory().getId());
		} else {
			message = "Problem in adding Posted Out Entry !";
			 jsp = POSTED_OUT_JSP;
			 map = hrOrderlyRoomHandlerService.showPostedOutJsp(id);
		}
		
		
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("entryNo", entryNo);
		return new ModelAndView("indexB", "map", map);
	}

	// //// Method for Show Pending List

	public ModelAndView showPendingListForHro(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		Map<String, Object> map = new HashMap<String, Object>();

		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		map = hrOrderlyRoomHandlerService.pendingListForHro();

		jsp = PENDING_LIST_JSP;
		jsp += ".jsp";
		title = "Pending List";
		map.put("contentJsp", jsp);
		map.put("entryNo", entryNo);
		map.put("title", title);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);
	}

	// / Method for Add Movement Out

	public ModelAndView addMovementOutEntry(HttpServletRequest request,
			HttpServletResponse response) {
		String movementType = "";
		int unitTo = 0;
		Date fromDate = null;
		Date toDate = null;
		String status = null;
		String fromTime = "";
		String toTime = "";
		String remarks = "";
		int id = 0;
		String employeecode=null;

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		MovementOutEntry movementOutEntry = new MovementOutEntry();
		MasEmployee masEmployee = new MasEmployee();
		MasUnit masUnit = new MasUnit();

		if (request.getParameter(MOVEMENT_TYPE) != null) {
			movementType = request.getParameter(MOVEMENT_TYPE);
		}
		if (request.getParameter("id") != null
				&& !request.getParameter("id").equals("")) {
			id = Integer.parseInt(request.getParameter("id"));
		}
		if (request.getParameter("employeecode") != null
				&& !request.getParameter("employeecode").equals("")) {
			employeecode = request.getParameter("employeecode");
		}
		if (request.getParameter(UNIT_TO) != null) {
			unitTo = Integer.parseInt(request.getParameter(UNIT_TO));
		}
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(FROM_TIME) != null) {
			fromTime = request.getParameter(FROM_TIME);
		}
		if (request.getParameter(TO_TIME) != null) {
			toTime = request.getParameter(TO_TIME);
		}
		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
		}
		if (request.getParameter(STATUS) != null) {
			status = request.getParameter(STATUS);
		}
		if (request.getParameter(CHANGED_BY) != null) {
			lstChangedBy = request.getParameter(CHANGED_BY);
			//System.out.println("userName" + lstChangedBy);
		}

		if (request.getParameter(CHANGED_DATE) != null) {
			lstChangedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}

		if (request.getParameter(CHANGED_TIME) != null) {
			lstChangedTime = request.getParameter(CHANGED_TIME);
		}

		if (id != 0) {
			masEmployee.setId(id);
			movementOutEntry.setEmployee(masEmployee);
		}

		if (unitTo != 0) {
			masUnit.setId(unitTo);
			movementOutEntry.setUnit(masUnit);
		}
		movementOutEntry.setMovementType(movementType);

		movementOutEntry.setFromDate(fromDate);
		movementOutEntry.setFromTime(fromTime);
		movementOutEntry.setToDate(toDate);
		movementOutEntry.setToTime(toTime);
		movementOutEntry.setRemarks(remarks);
		movementOutEntry.setLstChangedBy(lstChangedBy);
		movementOutEntry.setLstChangedDate(lstChangedDate);
		movementOutEntry.setLstChangedTime(lstChangedTime);
		movementOutEntry.setEmployeeCode(employeecode);
		movementOutEntry.setStatus("y");
		generalMap.put("id", id);
		generalMap.put("employeecode",employeecode);
		boolean successfullyAdded = hrOrderlyRoomHandlerService
				.addMovementOutEntry(movementOutEntry, generalMap);

		String message = "";

		if (successfullyAdded) {
			message = "Record Added Successfully!!";
		} else {
			message = "Problem in Adding Movement Out Entry";
		}

		try {
			map = hrOrderlyRoomHandlerService.showMovementOutJsp(id,employeecode);

		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsp = MOVEMENT_OUT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// / Method for Search Movement In

	public ModelAndView searchMovementIn(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		Date currentDate = HMSUtil.convertStringTypeDateToDateType(date);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		mapForDs.put("currentDate", currentDate);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		detailsMap = hrOrderlyRoomHandlerService
				.getDetailsForSearchForMovementOut(dataMap);
		String jsp = SEARCH_MOVEMENT_IN;
		jsp += ".jsp";

		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchRecordsForMovementIn(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serPersonFName = "";
		String serPersonLName = "";
		String serviceNo = "";
		int rankId = 0;
		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		session = request.getSession();

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		Map<String, Object> dataMap = new HashMap<String, Object>();
		infoMap.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
			infoMap.put("serviceNo", serviceNo);
		}
		if (request.getParameter(S_FIRST_NAME) != null
				&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
			serPersonLName = request.getParameter(S_FIRST_NAME);
			infoMap.put("serPersonLName", serPersonLName);
		}
		if (request.getParameter(S_LAST_NAME) != null
				&& !(request.getParameter(S_LAST_NAME).equals(""))) {
			serPersonFName = request.getParameter(S_LAST_NAME);
			infoMap.put("serPersonFName", serPersonFName);
		}
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals("0"))) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
			infoMap.put("rankId", rankId);
		}
		Map<String, Object> patientMap = new HashMap<String, Object>();
		patientMap = hrOrderlyRoomHandlerService
				.getMovementInDetailsGrid(infoMap);
		detailsMap = hrOrderlyRoomHandlerService
				.getDetailsForSearchForMovementIn(dataMap);
		jsp = SEARCH_MOVEMENT_IN + ".jsp";
		map.put("contentJsp", jsp);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		return new ModelAndView("indexB", "map", map);
	}

	// / Method for Show Movement In Jsp

	public ModelAndView showMovementInJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		Map<String, Object> infomap = new HashMap<String, Object>();
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
		int Id = getEmployeeId();
		String employeecode=request.getParameter("employeecode");
		map = hrOrderlyRoomHandlerService.showMovementInJsp(Id ,employeecode );
		jsp = MOVEMENT_IN_JSP;
		jsp += ".jsp";
		title = "Movement In";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);
	}

	// / Method for Add Movement In
	public ModelAndView showPersonnelFromOtherUnitJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = hrOrderlyRoomHandlerService.showPersonnelFromOtherUnitJsp();
		jsp = PERSON_FROM_OTHER_UNIT;
		jsp += ".jsp";
		title = "Personnel from other unit";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);

	}
	public ModelAndView addPersonnelFromOtherUnitJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		MovementInOtherPerson movementinotherperson =new MovementInOtherPerson();
		String firstName = "";
		String middleName = "";
		String lastName = "";
		int serviceTypeId=0;
		int postedUnitId=0;
		int titleId = 0;
		int departmentId = 0;
		int empStatusId = 0;
		int empCategoryId = 0;
		int gradeId = 0;
		int rankId = 0;
		int tradeId = 0;
		String serviceNo = "";
		String suffix = "";
		String prefix = "";
		String changedBy = "";
		Date currentDate = new Date();
		String year = null;
		if (request.getParameter(EMPLOYEE_CODE) != null) {
			code = request.getParameter(EMPLOYEE_CODE);
		}
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (request.getParameter(SUFFIX) != null) {
			suffix = request.getParameter(SUFFIX);
		}
		if (request.getParameter(PREFIX) != null) {
			prefix = request.getParameter(PREFIX);
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
		
		
		if (!request.getParameter(TITLE_ID).equals("0")) {
			titleId = Integer.parseInt(request.getParameter(TITLE_ID));
		}
		if (!request.getParameter(EMPLOYEE_GRADE_ID).equals("0")) {
			gradeId = Integer.parseInt(request.getParameter(EMPLOYEE_GRADE_ID));
		}
		
		if (!request.getParameter(RANK_ID).equals("0")) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
		}
		
		if (!request.getParameter(TRADE_ID).equals("0")) {
			tradeId = Integer.parseInt(request.getParameter(TRADE_ID));
		}
		if (!request.getParameter(EMPLOYEE_CATEGORY_ID).equals("0")) {
			empCategoryId = Integer.parseInt(request
					.getParameter(EMPLOYEE_CATEGORY_ID));
		}
		if (!request.getParameter(DEPARTMENT_ID).equals("0")) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
			String yearcurrent[] = request.getParameter(CHANGED_DATE)
					.split("/");
			year = yearcurrent[2];

		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		
		
		if (!request.getParameter(POSTED_UNIT_ID).equals("0")) {
			postedUnitId = Integer.parseInt(request
					.getParameter(POSTED_UNIT_ID));
		}
		if (!request.getParameter(SERVICE_TYPE_ID).equals("0")) {
			serviceTypeId = Integer.parseInt(request
					.getParameter(SERVICE_TYPE_ID));
		}
		
		boolean successfullyAdded = false;

		successfullyAdded = hrOrderlyRoomHandlerService.EmployeeExistForOtherPersonnel(
				serviceNo, serviceTypeId);
		if (successfullyAdded) {

			movementinotherperson.setEmployeeCode(code);
			movementinotherperson.setServiceNo(serviceNo);
			movementinotherperson.setFirstName(firstName);
			movementinotherperson.setLastName(lastName);
			movementinotherperson.setMiddleName(middleName);
			movementinotherperson.setMovementOutStatus("y");
			movementinotherperson.setMovementInStatus("n");
			
			if (titleId != 0) {
				MasTitle masTitle = new MasTitle();
				masTitle.setId(titleId);
				movementinotherperson.setTitle(masTitle);
			}

			if (departmentId != 0) {
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				movementinotherperson.setDepartment(masDepartment);
			}
			if (empStatusId != 0) {
				MasEmpStatus masEmpStatus = new MasEmpStatus();
				masEmpStatus.setId(empStatusId);
				movementinotherperson.setEmpStatus(masEmpStatus);
			}

			if (empCategoryId != 0) {
				MasEmpCategory masEmpCategory = new MasEmpCategory();
				masEmpCategory.setId(empCategoryId);
				movementinotherperson.setCategory(masEmpCategory);
			}
			if (gradeId != 0) {
				MasGrade masGrade = new MasGrade();
				masGrade.setId(gradeId);
				movementinotherperson.setGrade(masGrade);
			}

			if (rankId != 0) {
				MasRank masRank = new MasRank();
				masRank.setId(rankId);
				movementinotherperson.setRank(masRank);
			}
			if (postedUnitId != 0) {
				MasUnit masUnit = new MasUnit();
				masUnit.setId(postedUnitId);
				movementinotherperson.setPresentUnit(masUnit);
			}
			if (tradeId != 0) {
				MasTrade masTrade = new MasTrade();
				masTrade.setId(tradeId);
				movementinotherperson.setTrade(masTrade);
			}
			if(!prefix.equals(""))			
			movementinotherperson.setPrefix(prefix);
			movementinotherperson.setSuffix(suffix);
			movementinotherperson.setStatus("y");
			movementinotherperson.setLastChgBy(changedBy);
			movementinotherperson.setLastChgDate(currentDate);
			movementinotherperson.setLastChgTime(currentTime);

			if (serviceTypeId != 0) {
				MasServiceType masServiceType = new MasServiceType();
				masServiceType.setId(serviceTypeId);
				movementinotherperson.setServiceType(masServiceType);
			}
			
			infoMap.put("movementinotherperson", movementinotherperson);
			successfullyAdded = hrOrderlyRoomHandlerService.addPersonnelFromOtherUnitJsp(infoMap);
			if(successfullyAdded)
			{
				message="Employee Is Added";
			}

			
		} else {
			message = "Employee already exists.";

		}
		url = "/hms/hms/personnel?method=showEmployeeJsp";
		try {
			map = hrOrderlyRoomHandlerService.showPersonnelFromOtherUnitJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = PERSON_FROM_OTHER_UNIT;
		title = "Add Person From Other Unit";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView UpdatePersonFroOtherUnit(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		boolean successfull = false;
		String message="";
		successfull = hrOrderlyRoomHandlerService.UpdatePersonFroOtherUnit(box);
		if(successfull)
		{
			message="Person is Updated Successfull";
		}else
		{
			message="Person is not Updated Try Again !!";
		}
		map=hrOrderlyRoomHandlerService.showUpdatePersonnelFromOtherUnitJsp(Integer.parseInt(request.getParameter("personelId")));
		jsp =PERSON_FROM_OTHER_UNIT_UPDATE;
		title = "Update Person From Other Unit";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
		
	}
	public ModelAndView searchOtherPerson(HttpServletRequest request,
			HttpServletResponse response) {
		
		session = request.getSession();
		Map<String,Object> map = new HashMap<String,Object>();
		String jsp = SEARCH_OTHER_PERSON;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView searchOtherPersonUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = hrOrderlyRoomHandlerService.searchOtherPersonUpdate(box);
		jsp = SEARCH_OTHER_PERSON + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView showUpdatePersonnelFromOtherUnitJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int personelId=0;
		if(request.getParameter("personelId")!=null && !request.getParameter("personelId").equals(""))
			personelId=Integer.parseInt(request.getParameter("personelId"));
		Map<String, Object> map = hrOrderlyRoomHandlerService.showUpdatePersonnelFromOtherUnitJsp(personelId);
		jsp = PERSON_FROM_OTHER_UNIT_UPDATE;
		jsp += ".jsp";
		title = "Personnel from other unit";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);

	}
	public ModelAndView addMovementInEntry(HttpServletRequest request,
			HttpServletResponse response) {
		String movementType = "";
		int fromUnit = 0;
		Date fromDate = null;
		Date toDate = null;
		String fromTime = "";
		String toTime = "";
		String remarks = "";
		int id = 0;
		String employeecode=null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		MovementInEntry movementInEntry = new MovementInEntry();
		if (request.getParameter("id") != null
				&& !request.getParameter("id").equals("")) {
			id = Integer.parseInt(request.getParameter("id"));
		}
		if (request.getParameter("employeecode") != null) {
			employeecode = request.getParameter("employeecode");
		}
		if (request.getParameter(MOVEMENT_TYPE) != null) {
			movementType = request.getParameter(MOVEMENT_TYPE);
		}
		if (request.getParameter("fromUnitId") != null) {
			fromUnit = Integer.parseInt(request.getParameter("fromUnitId"));
		}
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null && !request.getParameter(TO_DATE).equals("")) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(FROM_TIME) != null) {
			fromTime = request.getParameter(FROM_TIME);
		}
		if (request.getParameter(TO_TIME) != null) {
			toTime = request.getParameter(TO_TIME);
		}
		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
		}
		if (request.getParameter(CHANGED_BY) != null) {
			lstChangedBy = request.getParameter(CHANGED_BY);
			//System.out.println("userName" + lstChangedBy);
		}

		if (request.getParameter(CHANGED_DATE) != null) {
			lstChangedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}

		if (request.getParameter(CHANGED_TIME) != null) {
			lstChangedTime = request.getParameter(CHANGED_TIME);
		}

		if (id != 0) {
			movementInEntry.setEmployee(id);
		}
		if (employeecode != null) {
			movementInEntry.setEmployeeCode(employeecode);
		}

		if (fromUnit != 0) {
			MasUnit masUnit = new MasUnit();
			masUnit.setId(fromUnit);
			movementInEntry.setFromUnit(masUnit);
		}

		movementInEntry.setMovementType(movementType);

		movementInEntry.setFromDate(fromDate);
		movementInEntry.setFromTime(fromTime);
		movementInEntry.setToDate(toDate);
		movementInEntry.setToTime(toTime);
		movementInEntry.setRemarks(remarks);
		movementInEntry.setLstChangedBy(lstChangedBy);
		movementInEntry.setLstChangedDate(lstChangedDate);
		movementInEntry.setLstChangedTime(lstChangedTime);
		movementInEntry.setStatus("y");
		generalMap.put("id", id);
		generalMap.put("employeecode",employeecode);

		Boolean successfullyAdded = hrOrderlyRoomHandlerService
				.addMovementInEntry(movementInEntry, generalMap);

		String message = "";

		if (successfullyAdded) {
			message = "Record Added Successfully!!";
		} else {
			message = "Problem in Adding Movement Out Entry";
		}
		try {
			map = hrOrderlyRoomHandlerService.showMovementInJsp(id,employeecode);

		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsp = MOVEMENT_IN_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printproposalForHro(HttpServletRequest request,
			HttpServletResponse response) {
		ServletContext context = request.getSession().getServletContext();
		Map<String, Object> parameters = new HashMap();
		String entryNo = "";
		try {

			if (request.getParameter("entryNo") != null) {
				entryNo = request.getParameter("entryNo");
				//System.out.println("entrynumber" + entryNo);
			}

			parameters.put("entryNo", entryNo);
			Map<String, Object> connectionMap = hrOrderlyRoomHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("proposal_for_hro", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printApplicationForCV(HttpServletRequest request,
			HttpServletResponse response) {
		ServletContext context = request.getSession().getServletContext();
		Map<String, Object> parameters = new HashMap();
		int empId = 0;
		try {

			if (request.getParameter("empId") != null) {
				empId = Integer.parseInt(request.getParameter("empId"));
				//System.out.println("empIDDDDDDDD" + empId);
			}

			parameters.put("empId", empId);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
			Map<String, Object> connectionMap = hrOrderlyRoomHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("ApplicationCVForFamily", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printIssueofFRW(HttpServletRequest request,
			HttpServletResponse response) {
		ServletContext context = request.getSession().getServletContext();
		Map<String, Object> parameters = new HashMap();
		int empId = 0;
		try {

			if (request.getParameter("empId") != null) {
				empId = Integer.parseInt(request.getParameter("empId"));
				//System.out.println("empIDDDDDDDD" + empId);
			}

			parameters.put("empId", empId);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
			Map<String, Object> connectionMap = hrOrderlyRoomHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("IssueOfFrwForLtc", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printHroEntry(HttpServletRequest request,
			HttpServletResponse response) {
		ServletContext context = request.getSession().getServletContext();
		Map<String, Object> parameters = new HashMap();
		String entryNo = "";
		try {

			if (request.getParameter("entryNo") != null) {
				entryNo = request.getParameter("entryNo");
				//System.out.println("entrynumber" + entryNo);
			}

			parameters.put("entryNo", entryNo);
			Map<String, Object> connectionMap = hrOrderlyRoomHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("hro_entry", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printClearanceCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		ServletContext context = request.getSession().getServletContext();
		Map<String, Object> parameters = new HashMap();
		Map<String, Object> connectionMap = hrOrderlyRoomHandlerService
				.getConnectionForReport();
		int empId = 0;
		String query = "";
		int abc = 0;
		try {

			if (request.getParameter("abc") != null) {
				abc = Integer.parseInt(request.getParameter("abc"));

				//System.out.println("abccccccc" + abc);
			}

			if (request.getParameter("empId") != null) {
				empId = Integer.parseInt(request.getParameter("empId"));

				//System.out.println("empccc" + empId);
			}

			if (abc >= 14) {
				parameters.put("empId", empId);
				parameters.put("rankId", abc);

				HMSUtil.generateReport("clearance_certificate-Airmen",
						parameters, (Connection) connectionMap.get("conn"),
						response, getServletContext());

			} else {
				parameters.put("empId", empId);
				parameters.put("rankId", abc);

				HMSUtil.generateReport("clearance_certificate-Officers",
						parameters, (Connection) connectionMap.get("conn"),
						response, getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	private int getEmployeeId() {
		return employeeId;
	}

	public ModelAndView searchProposalForHro(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String entryNo = null;
		String searchField = null;
		Date proposalDate = null;
		try {
			if (request.getParameter(ENTRY_NO) != null
					&& !(request.getParameter(ENTRY_NO).equals(""))) {
				entryNo = request.getParameter(ENTRY_NO);
			}
			if (request.getParameter(ENTRY_DATE) != null
					&& !(request.getParameter(ENTRY_DATE).equals(""))) {
				proposalDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(ENTRY_DATE));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = hrOrderlyRoomHandlerService.searchProposalForHRO(entryNo,
				proposalDate);
		jsp = SEARCH_PROPOSAL_FOR_HRO;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("entryNo", entryNo);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showProposalHroSearchJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> employeeMap = new HashMap<String, Object>();
		session = request.getSession();
		map = hrOrderlyRoomHandlerService.showProposalHroSearchJsp();
		jsp = SEARCH_PROPOSAL_FOR_HRO;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView searchPostedOutEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String entryNo = null;
		String serviceNo = null;
		String serPersonLName = "";
		String serPersonFName = "";
		int rankId = 1;

		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		session = request.getSession();

		try {

			if (request.getParameter(ENTRY_NO) != null
					&& !(request.getParameter(ENTRY_NO).equals(""))) {
				entryNo = request.getParameter(ENTRY_NO);
				//System.out.println("entryNo" + entryNo);

			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				//System.out.println("serviceNo" + serviceNo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map = hrOrderlyRoomHandlerService.searchPostedOutEntry(entryNo,
				serviceNo);

		jsp = SEARCH_POSTED_OUT_ENTRY + ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("entryNo", entryNo);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showPostedOutEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String entryNo = "";
		Map<String, Object> infomap = new HashMap<String, Object>();

		// //System.out.println("EntryNo" + entryNo);
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
		int Id = getEmployeeId();
		map = hrOrderlyRoomHandlerService.showPostedOutJsp(Id);
		entryNo = hrOrderlyRoomHandlerService.generatePostedOutEntryNo(infomap);
		jsp = POSTED_OUT_JSP;
		jsp += ".jsp";
		title = "Pool Category";
		map.put("contentJsp", jsp);
		map.put("entryNo", entryNo);
		map.put("title", title);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);
	}

	
	/**
	 * ------------------------------------- GUARD DUTY ENTRY -------------------------------
	 
	 */
	
	public ModelAndView showGuardDutyEntryJsp(HttpServletRequest request,HttpServletResponse response)
	{	Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = hrOrderlyRoomHandlerService.showGuardDutyEntryJsp();		
		jsp = GUARD_DUTY_ENTRY;
		jsp += ".jsp";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}
	public ModelAndView showGuardDutyAddJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		box.put("numOfRows", "10");
		map = hrOrderlyRoomHandlerService.getGridDataForGuardEmployeeAdd(box);
		map.put("box",box);
		jsp = GUARD_DUTY_ADDITION;
		title = "Guard Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}
	public ModelAndView showGuardDutyPerformed(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String,Object>();
		jsp=DUTY_PERFORMED;
		jsp = jsp +".jsp";
		title="Actual Duty Performed";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB","map",map);


	}
	public ModelAndView searchGuardDutyPerformed(HttpServletRequest request , HttpServletResponse response)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		Date dutydate=null;
		String searchdutydate="";
		if(request.getParameter("dutyDate")!=null && !request.getParameter("dutyDate").equals(""))
		{
			dutydate=HMSUtil.convertStringTypeDateToDateType(request.getParameter("dutyDate"));
			searchdutydate=request.getParameter("dutyDate");
		}
		map=hrOrderlyRoomHandlerService.searchGuardDutyPerformed(dutydate);
		jsp=DUTY_PERFORMED;
		jsp=jsp+".jsp";
		title="Search Guard Duty Performed";
		map.put("searchdutydate", searchdutydate);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB","map",map);
	}
	public ModelAndView updateGuardDutyPerformed(HttpServletRequest request , HttpServletResponse response)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> generalmap = new HashMap<String,Object>();
		Box box=HMSUtil.getBox(request);
		Vector<String> hrorderlyGuardDutyIds= box.getVector("hrorderlyGuardDutyAdded");
		boolean successfull=false;
		Date dutydate=null;
		String dutydateString=""; 
		String message="";
		if(request.getParameter("searchdutydate")!=null && !request.getParameter("searchdutydate").equals(""))
		{
			dutydate=HMSUtil.convertStringTypeDateToDateType(request.getParameter("searchdutydate"));
			dutydateString=request.getParameter("searchdutydate");
		}
		//System.out.println("dutydate"+dutydate);
		generalmap.put("box", box);
		generalmap.put("dutydate", dutydate);
		generalmap.put("hrorderlyGuardDutyIds",hrorderlyGuardDutyIds);
		successfull=hrOrderlyRoomHandlerService.updateGuardDutyPerformed(generalmap);
		if(successfull)
		{
			message=message+"Record is Updated Successfully";
		}else
		{
			message=message+"try Again";
		}
		jsp=DUTY_PERFORMED;
		jsp=jsp+".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB","map",map);
	}	
	
	public ModelAndView getGridDataForGuardEmployeeAdd(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		map = hrOrderlyRoomHandlerService.getGridDataForGuardEmployeeAdd(box);
		jsp = GUARD_DUTY_ADDITION;
		title = "Guard Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}
	public ModelAndView showGuardDutyRecords(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		box.put("numOfRows", "10");
		map = hrOrderlyRoomHandlerService.getEmployeeDetailsForGuardDuty(box);
		jsp = GUARD_DUTY_ENTRY;
		jsp += ".jsp";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}
	public ModelAndView getGridDataForGuardEmployee(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = hrOrderlyRoomHandlerService.getGridDataForGuardEmployee(box);
		jsp = GUARD_DUTY_ENTRY;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView AddGuardDutyEntry(HttpServletRequest request,HttpServletResponse response)
	{	Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId=(Integer)session.getAttribute("hospitalId");
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		box.put("hospitalId", hospitalId);
		successfullyAdded = hrOrderlyRoomHandlerService.AddGuardDutyEntry(box);

		if(successfullyAdded)
		{
			message="Record Added Successfully !!";
			map = hrOrderlyRoomHandlerService.getEmployeeDetailsForGuardDutyAdd(box);
		}
		else
		{				message="Try Again !!";

		}
		map.put("message",message);
		jsp = GUARD_DUTY_ADDITION;
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getGuardEmployeeLastDutyDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		map = hrOrderlyRoomHandlerService.getGuardEmployeeLastDutyDetails(box);
		jsp = "responseForGuardDutyAddition";
		title = "Guard Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}
	
	public ModelAndView updateGuardDutyEntry(HttpServletRequest request,HttpServletResponse response)
	{	Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		successfullyAdded = hrOrderlyRoomHandlerService.updateGuardDutyEntry(box);

		if(successfullyAdded)
		{
			message="Record updated Successfully !!";
			map = hrOrderlyRoomHandlerService.getEmployeeDetailsForGuardDuty(box);
		}
		else
		{				message="Try Again !!";

		}
		map.put("message",message);
		jsp = GUARD_DUTY_ENTRY;
		jsp += ".jsp";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView searchGuardDutyData(HttpServletRequest request,HttpServletResponse response)
	{	
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = hrOrderlyRoomHandlerService.searchGuardDutyData(box);
		jsp = GUARD_DUTY_ENTRY;
		jsp += ".jsp";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}
	public ModelAndView deleteGuardDutyEntry(HttpServletRequest request,HttpServletResponse response)
	{	Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		successfullyAdded = hrOrderlyRoomHandlerService.deleteGuardDutyEntry(box);

		if(successfullyAdded)
		{
			message="Record Deleted Successfully !!";
			map = hrOrderlyRoomHandlerService.getEmployeeDetailsForGuardDuty(box);
		}
		else
		{				message="Try Again !!";

		}
		map.put("message",message);
		jsp = GUARD_DUTY_ENTRY;
		jsp += ".jsp";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView searchGuardDutyEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		box.put("numOfRows", "10");
		map = hrOrderlyRoomHandlerService.searchGuardDutyEntry(box);
		map.put("box",box);
		jsp = GUARD_DUTY_ADDITION;
		title = "Guard Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}
	/**
	 * ------------------------------------- ORDERLY SGT DUTY ENTRY -------------------------------
	 
	 */
	
	public ModelAndView showOrderlyDutyEntryJsp(HttpServletRequest request,HttpServletResponse response)
	{	Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = hrOrderlyRoomHandlerService.showOrderlyDutyEntryJsp();		
		jsp =ORDERLY_DUTY_ENTRY;
		jsp += ".jsp";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}
	public ModelAndView showOrderlyDutyAddJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		box.put("numOfRows", "10");
		map = hrOrderlyRoomHandlerService.getGridDataForOrderlyEmployeeAdd(box);
		map.put("box",box);
		jsp = ORDERLY_DUTY_ADDITION;
		title = "Orderly SGT Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}
	
	public ModelAndView getGridDataForOrderlyEmployeeAdd(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		map = hrOrderlyRoomHandlerService.getGridDataForOrderlyEmployeeAdd(box);
		jsp = ORDERLY_DUTY_ADDITION;
		title = "Orderly SGT Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}
	public ModelAndView showOrderlyDutyRecords(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		box.put("numOfRows", "10");
		map = hrOrderlyRoomHandlerService.getEmployeeDetailsForOrderlyDuty(box);
		jsp = ORDERLY_DUTY_ENTRY;
		jsp += ".jsp";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}
	public ModelAndView getGridDataForOrderlyEmployee(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = hrOrderlyRoomHandlerService.getGridDataForOrderlyEmployee(box);
		jsp = ORDERLY_DUTY_ENTRY;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView AddOrderlyDutyEntry(HttpServletRequest request,HttpServletResponse response)
	{	Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId=(Integer)session.getAttribute("hospitalId");
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		box.put("hospitalId", hospitalId);
		successfullyAdded = hrOrderlyRoomHandlerService.AddOrderlyDutyEntry(box);

		if(successfullyAdded)
		{
			message="Record Added Successfully !!";
			map = hrOrderlyRoomHandlerService.getEmployeeDetailsForOrderlyDutyAdd(box);
		}
		else
		{				message="Try Again !!";

		}
		map.put("message",message);
		jsp = ORDERLY_DUTY_ADDITION;
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getOrderlyEmployeeLastDutyDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		map = hrOrderlyRoomHandlerService.getOrderlyEmployeeLastDutyDetails(box);
		jsp = "responseForSgtDutyAddition";
		title = "Orderly SGT Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}
	
	public ModelAndView updateOrderlyDutyEntry(HttpServletRequest request,HttpServletResponse response)
	{	Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		successfullyAdded = hrOrderlyRoomHandlerService.updateOrderlyDutyEntry(box);

		if(successfullyAdded)
		{
			message="Record updated Successfully !!";
			map = hrOrderlyRoomHandlerService.getEmployeeDetailsForOrderlyDuty(box);
		}
		else
		{				message="Try Again !!";

		}
		map.put("message",message);
		jsp = ORDERLY_DUTY_ENTRY;
		jsp += ".jsp";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView searchOrderlyDutyData(HttpServletRequest request,HttpServletResponse response)
	{	
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = hrOrderlyRoomHandlerService.searchOrderlyDutyData(box);
		jsp = ORDERLY_DUTY_ENTRY;
		jsp += ".jsp";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}
	public ModelAndView deleteOrderlyDutyEntry(HttpServletRequest request,HttpServletResponse response)
	{	Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		successfullyAdded = hrOrderlyRoomHandlerService.deleteOrderlyDutyEntry(box);

		if(successfullyAdded)
		{
			message="Record Deleted Successfully !!";
			map = hrOrderlyRoomHandlerService.getEmployeeDetailsForOrderlyDuty(box);
		}
		else
		{				message="Try Again !!";

		}
		map.put("message",message);
		jsp = ORDERLY_DUTY_ENTRY;
		jsp += ".jsp";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView searchOrderlyDutyEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		box.put("numOfRows", "10");
		map = hrOrderlyRoomHandlerService.searchOrderlyDutyEntry(box);
		map.put("box",box);
		jsp = ORDERLY_DUTY_ADDITION;
		title = "Orderly Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}
	/**
	 * ------------------------------------- ORDERLY OFFICER DUTY ENTRY -------------------------------
	 
	 */
	
	public ModelAndView showOfficerDutyEntryJsp(HttpServletRequest request,HttpServletResponse response)
	{	Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = hrOrderlyRoomHandlerService.showOfficerDutyEntryJsp();		
		jsp =ORDERLY_OFFICER_DUTY_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}
	public ModelAndView showOfficerDutyAddJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		box.put("numOfRows", "10");
		map = hrOrderlyRoomHandlerService.getGridDataForOfficerEmployeeAdd(box);
		map.put("box",box);
		jsp = ORDERLY_OFFICER_DUTY_ADDITION_JSP;
		title = "Orderly Officer Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}
	
	public ModelAndView getGridDataForOfficerEmployeeAdd(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		map = hrOrderlyRoomHandlerService.getGridDataForOfficerEmployeeAdd(box);
		jsp = ORDERLY_OFFICER_DUTY_ADDITION_JSP;
		title = "Orderly Officer Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}
	public ModelAndView showOfficerDutyRecords(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		box.put("numOfRows", "10");
		map = hrOrderlyRoomHandlerService.getEmployeeDetailsForOfficerDuty(box);
		jsp = ORDERLY_OFFICER_DUTY_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}
	public ModelAndView getGridDataForOfficerEmployee(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = hrOrderlyRoomHandlerService.getGridDataForOfficerEmployee(box);
		jsp = ORDERLY_OFFICER_DUTY_ENTRY_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView AddOfficerDutyEntry(HttpServletRequest request,HttpServletResponse response)
	{	Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId=(Integer)session.getAttribute("hospitalId");
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		box.put("hospitalId", hospitalId);
		successfullyAdded = hrOrderlyRoomHandlerService.AddOfficerDutyEntry(box);

		if(successfullyAdded)
		{
			message="Record Added Successfully !!";
			map = hrOrderlyRoomHandlerService.getEmployeeDetailsForOfficerDutyAdd(box);
		}
		else
		{				message="Try Again !!";

		}
		map.put("message",message);
		jsp = ORDERLY_OFFICER_DUTY_ADDITION_JSP;
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getOfficerEmployeeLastDutyDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		map = hrOrderlyRoomHandlerService.getOfficerEmployeeLastDutyDetails(box);
		jsp = "responseForOfficerDutyAddition";
		title = "Orderly Officer Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}
	
	public ModelAndView updateOfficerDutyEntry(HttpServletRequest request,HttpServletResponse response)
	{	Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		successfullyAdded = hrOrderlyRoomHandlerService.updateOfficerDutyEntry(box);

		if(successfullyAdded)
		{
			message="Record updated Successfully !!";
			map = hrOrderlyRoomHandlerService.getEmployeeDetailsForOfficerDuty(box);
		}
		else
		{				message="Try Again !!";

		}
		map.put("message",message);
		jsp = ORDERLY_OFFICER_DUTY_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView searchOfficerDutyData(HttpServletRequest request,HttpServletResponse response)
	{	
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = hrOrderlyRoomHandlerService.searchOfficerDutyData(box);
		jsp = ORDERLY_OFFICER_DUTY_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}
	public ModelAndView deleteOfficerDutyEntry(HttpServletRequest request,HttpServletResponse response)
	{	Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		successfullyAdded = hrOrderlyRoomHandlerService.deleteOfficerDutyEntry(box);

		if(successfullyAdded)
		{
			message="Record Deleted Successfully !!";
			map = hrOrderlyRoomHandlerService.getEmployeeDetailsForOfficerDuty(box);
		}
		else
		{				message="Try Again !!";

		}
		map.put("message",message);
		jsp = ORDERLY_OFFICER_DUTY_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView searchOfficerDutyEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		box.put("numOfRows", "10");
		map = hrOrderlyRoomHandlerService.searchOfficerDutyEntry(box);
		map.put("box",box);
		jsp = ORDERLY_OFFICER_DUTY_ADDITION_JSP;
		title = "Orderly Officer Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}
	
	/**
	 * ------------------------------------- RANGE FIRING DUTY ENTRY
	 */

	public ModelAndView showRangeFiringDutyEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = RANGE_FIRING_DUTY_ENTRY;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView showRangeFiringDutyAddJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		box.put("numOfRows", "10");
		map = hrOrderlyRoomHandlerService
				.getEmployeeDetailsForRangeFiringDutyAdd(box);
		map.put("box", box);
		jsp = RANGE_FIRING_DUTY_ADDITION;
		title = "Guard Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getGridDataForRangeFiringEmployeeAdd(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		map = hrOrderlyRoomHandlerService
				.getGridDataForRangeFiringEmployeeAdd(box);
		jsp = RANGE_FIRING_DUTY_ADDITION;
		title = "Guard Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView showRangeFiringDutyRecords(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = hrOrderlyRoomHandlerService
				.getEmployeeDetailsForRangeFiringDuty(box);
		jsp = RANGE_FIRING_DUTY_ENTRY;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView getGridDataForRangeFiringEmployee(
			HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = hrOrderlyRoomHandlerService
				.getGridDataForRangeFiringEmployee(box);
		jsp = RANGE_FIRING_DUTY_ENTRY;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView AddRangeFiringDutyEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		box.put("hospitalId", hospitalId);
		successfullyAdded = hrOrderlyRoomHandlerService
				.AddRangeFiringDutyEntry(box);

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
			map = hrOrderlyRoomHandlerService
					.getEmployeeDetailsForRangeFiringDutyAdd(box);
		} else {
			message = "Try Again !!";

		}
		map.put("message", message);
		jsp = RANGE_FIRING_DUTY_ADDITION;
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView updateRangeFiringDutyEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		successfullyAdded = hrOrderlyRoomHandlerService
				.updateRangeFiringDutyEntry(box);

		if (successfullyAdded) {
			message = "Record updated Successfully !!";
			map = hrOrderlyRoomHandlerService
					.getEmployeeDetailsForRangeFiringDuty(box);
		} else {
			message = "Try Again !!";

		}
		map.put("message", message);
		jsp = RANGE_FIRING_DUTY_ENTRY;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchRangeFiringDutyEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		box.put("numOfRows", "10");
		map = hrOrderlyRoomHandlerService.searchRangeFiringDutyEntry(box);
		map.put("box", box);
		jsp = RANGE_FIRING_DUTY_ADDITION;
		title = "Guard Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	// /////////// UPDATE PROPOSAL FOR HRO///////////////

	public ModelAndView showUpdateProposalJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		Map<String, Object> infomap = new HashMap<String, Object>();
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		setProposalId(Integer.parseInt(request.getParameter("proposalId")));
		int proposalId = getProposalId();
		map = hrOrderlyRoomHandlerService.showUpdateProposalJsp(proposalId);
		jsp = UPDATE_PROPOSAL_JSP;
		jsp += ".jsp";
		title = "Movement Out";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);
	}

	private void setProposalId(int proposalId) {
		this.proposalId = proposalId;
	}

	private int getProposalId() {
		return proposalId;
	}

	// /////////// UPDATE PROPOSAL FOR HRO///////////////

	public ModelAndView showUpdateHroEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		Map<String, Object> infomap = new HashMap<String, Object>();
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		setHroId(Integer.parseInt(request.getParameter("hroId")));
		int hroId = getHroId();
		map = hrOrderlyRoomHandlerService.showUpdateHroEntryJsp(hroId);
		jsp = UPDATE_HRO_ENTRY_JSP;
		jsp += ".jsp";
		title = "Movement Out";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);
	}

	private void setHroId(int hroId) {
		this.hroId = hroId;
	}

	private int getHroId() {
		return hroId;
	}

	public ModelAndView showHroSearchJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> employeeMap = new HashMap<String, Object>();
		session = request.getSession();
		map = hrOrderlyRoomHandlerService.showHroSearchEntry();
		jsp = SEARCH_HRO_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView searchHroEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String entryNo = null;
		String searchField = null;
		Date proposalDate = null;
		try {
			if (request.getParameter(ENTRY_NO) != null
					&& !(request.getParameter(ENTRY_NO).equals(""))) {
				entryNo = request.getParameter(ENTRY_NO);
				//System.out.println("entryNo" + entryNo);
			}
			if (request.getParameter(ENTRY_DATE) != null
					&& !(request.getParameter(ENTRY_DATE).equals(""))) {
				proposalDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(ENTRY_DATE));
				//System.out.println("dateeeeeeee" + proposalDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = hrOrderlyRoomHandlerService.searchHROEntry(entryNo, proposalDate);
		jsp = SEARCH_HRO_ENTRY_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("entryNo", entryNo);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView updateProposalForHro(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean SucessResult = false;
		String userName = "";
		String message = "";
		int hospitalId = 0;
		int deptId = 0;

		Box Box = HMSUtil.getBox(request);
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		SucessResult = hrOrderlyRoomHandlerService.updateProposalForHro(Box);
		map = hrOrderlyRoomHandlerService.pendingListForHro();
		if (SucessResult == true) {
			message = "Successfully Added";
		} else {
			message = "Not Successfully Added";
		}

		jsp = PENDING_LIST_JSP;
		jsp += ".jsp";
		title = "Pending List";
		map.put("contentJsp", jsp);
		map.put("entryNo", entryNo);
		map.put("title", title);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showUpdatePostedOutJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		Map<String, Object> infomap = new HashMap<String, Object>();
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		setPostedId(Integer.parseInt(request.getParameter("postedId")));
		int hroId = getPostedId();
		map = hrOrderlyRoomHandlerService.showUpdatePostedOutJsp(postedId);
		jsp = UPDATE_POSTED_OUT_JSP;
		jsp += ".jsp";
		title = "Movement Out";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);
	}

	private void setPostedId(int postedId) {
		this.postedId = postedId;
	}

	private int getPostedId() {
		return postedId;
	}

	public ModelAndView editPostedOutUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		String porSlno = "";
		String servoceNo = "";
		String authority = "";
		String remarks = "";
		Date appraisalReport = new Date();
		String postedType = "";
		int unitPostedTo = 0;
		Date postedDate = new Date();
		Date sors = new Date();
		int id = 1;
		String message = "";
		String entryDate = "";
		String lastChangedBy = "";
		Date lastChangedDate = null;
		String lastChangedTime = "";
		String pojoPropertyName = "";
		String pojoName = "";

		if (request.getParameter("id") != null
				&& !request.getParameter("id").equals(""))
			;
		{
			id = Integer.parseInt(request.getParameter("id"));
		}
		if (request.getParameter(POR_SLNO) != null) {
			porSlno = request.getParameter(POR_SLNO);
		}

		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
		}

		if (request.getParameter(POSTED_TYPE) != null) {
			postedType = request.getParameter(POSTED_TYPE);
		}
		try {
			if (request.getParameter(APPRAISAL_REPORT) != null
					&& request.getParameter(APPRAISAL_REPORT) != "") {
				appraisalReport = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(APPRAISAL_REPORT));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (request.getParameter(SORS) != null
				&& !(request.getParameter(SORS).equals(""))) {
			sors = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(SORS));
		}
		if (request.getParameter(UNIT_POSTED_TO) != null
				&& !request.getParameter(UNIT_POSTED_TO).equals("")) {
			unitPostedTo = Integer.parseInt(request
					.getParameter(UNIT_POSTED_TO));
		}

		if (request.getParameter(DATE) != null) {
			postedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DATE));
		}
		if (request.getParameter(AUTHORITY) != null) {
			authority = request.getParameter(AUTHORITY);
		}

		if (request.getParameter(CHANGED_BY) != null) {
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
		lastChangedDate = new Date();
		lastChangedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", id);
		generalMap.put("postedDate", postedDate);
		generalMap.put("porSlno", porSlno);
		generalMap.put("postedType", postedType);
		generalMap.put("appraisalReport", appraisalReport);
		generalMap.put("sors", sors);
		generalMap.put("unitPostedTo", unitPostedTo);
		generalMap.put("remarks", remarks);
		generalMap.put("authority", authority);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", lastChangedDate);
		generalMap.put("currentTime", lastChangedTime);
		generalMap.put("pojoName", pojoName);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("title", title);

		generalMap.put("flag", true);

		boolean dataUpdated = false;
		dataUpdated = hrOrderlyRoomHandlerService
				.editPostedOutUpdateToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant be updated !!";
		}
		try {
			String serviceNo = "";
			hrOrderlyRoomHandlerService
					.searchPostedOutEntry(entryNo, serviceNo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = SEARCH_POSTED_OUT;

		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editProposalHroUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> generalMap = new HashMap<String, Object>();
		ProposalForHroEntry proposalForHroEntry = new ProposalForHroEntry();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		int employeeName = 0;
		String textContent = "";
		String subjectName = "";
		int id = 1;
		String message = "";
		Date entryDate = null;
		String lastChangedBy = "";
		Date lastChangedDate = null;
		String lastChangedTime = "";
		String pojoPropertyName = "";
		String pojoName = "";

		if (request.getParameter(ENTRY_DATE) != null) {
			entryDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(ENTRY_DATE));
		}
		if (request.getParameter(SUBJECT_NAME) != null) {
			subjectName = request.getParameter(SUBJECT_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(TEXT_CONTENT) != null) {
			textContent = request.getParameter(TEXT_CONTENT);
		}

		if (request.getParameter(APPROVED_BY) != null) {
			employeeName = Integer.parseInt(request.getParameter(APPROVED_BY));
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
		lastChangedDate = new Date();
		lastChangedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", proposalId);
		generalMap.put("entryDate", entryDate);
		generalMap.put("employeeName", employeeName);
		generalMap.put("subjectName", subjectName);
		generalMap.put("textContent", textContent);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", lastChangedDate);
		generalMap.put("currentTime", lastChangedTime);
		generalMap.put("pojoName", pojoName);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("title", title);

		generalMap.put("flag", true);

		boolean dataUpdated = false;
		dataUpdated = hrOrderlyRoomHandlerService
				.editProposalHroUpdateToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant be updated !!";
		}
		try {

			hrOrderlyRoomHandlerService.showProposalHroSearchJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = SEARCH_PROPOSAL_FOR_HRO;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editHroEntryUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HroEntry hroEntry = new HroEntry();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String jsp = "";
		String title = "";

		String textContent = "";
		String subjectName = "";
		int id = 1;
		String message = "";
		Date entryDate = null;
		String lastChangedBy = "";
		Date lastChangedDate = null;
		String lastChangedTime = "";
		String pojoPropertyName = "";
		String pojoName = "";
		String serialNo = "";

		if (request.getParameter(SERIAL_NO) != null) {
			serialNo = request.getParameter(SERIAL_NO);
		}

		if (request.getParameter(ENTRY_DATE) != null) {
			entryDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(ENTRY_DATE));
		}
		if (request.getParameter(CHANGED_BY) != null) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(TEXT_CONTENT) != null) {
			textContent = request.getParameter(TEXT_CONTENT);
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
		lastChangedDate = new Date();
		lastChangedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", hroId);
		generalMap.put("entryDate", entryDate);

		generalMap.put("serialNo", serialNo);
		generalMap.put("textContent", textContent);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", lastChangedDate);
		generalMap.put("currentTime", lastChangedTime);
		generalMap.put("pojoName", pojoName);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("title", title);

		generalMap.put("flag", true);

		boolean dataUpdated = false;
		dataUpdated = hrOrderlyRoomHandlerService
				.editHroEntryToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant be updated !!";
		}
		try {

			hrOrderlyRoomHandlerService.showHroSearchEntry();
		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = SEARCH_HRO_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ///////////////Arrival of Employee /////////////////////
	public ModelAndView searchEmployee(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		Date currentDate = HMSUtil.convertStringTypeDateToDateType(date);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		mapForDs.put("currentDate", currentDate);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		detailsMap = hrOrderlyRoomHandlerService
				.getDetailsForSearchPostedOut(dataMap);
		String jsp = SEARCH_EMPLOYEE;
		jsp += ".jsp";
		map.put("rankList", detailsMap.get("rankList"));
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchRecordsForEmployeeUpdate(
			HttpServletRequest request, HttpServletResponse response)
			throws FileNotFoundException, IllegalStateException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> rankMap = new HashMap<String, Object>();
		String serPersonFName = "";
		String serPersonLName = "";
		String serviceNo = "";
		int rankId = 0;
		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		session = request.getSession();

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		Map<String, Object> dataMap = new HashMap<String, Object>();
		infoMap.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
			infoMap.put("serviceNo", serviceNo);
		}
		if (request.getParameter(S_FIRST_NAME) != null
				&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
			serPersonFName = request.getParameter(S_FIRST_NAME);
			infoMap.put("serPersonFName", serPersonFName);
		}
		if (request.getParameter(S_LAST_NAME) != null
				&& !(request.getParameter(S_LAST_NAME).equals(""))) {
			serPersonLName = request.getParameter(S_LAST_NAME);
			infoMap.put("serPersonLName", serPersonLName);
		}
		//System.out.println("fristNmae::::::" + serPersonFName	+ "Last name ::::::::::" + serPersonLName);
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals("0"))) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
			infoMap.put("rankId", rankId);
		}
		map = hrOrderlyRoomHandlerService.searchEmployee(infoMap);
		jsp = SEARCH_EMPLOYEE + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showEmployeeJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = hrOrderlyRoomHandlerService.showEmployeeJsp();
		jsp = EMPLOYEE_ARRIVAL_JSP;
		jsp += ".jsp";
		title = "Employee";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView showEmployeeUpdateJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("employeeId"));
		boolean arrival =false;
		if(request.getParameter("arrival")!=null){
			arrival=Boolean.parseBoolean(request.getParameter("arrival"));
		}
		System.out.println("::arrival::1::"+arrival);
		Map<String, Object> map = hrOrderlyRoomHandlerService
				.showEmployeeUpdateJsp(id);
		jsp = EMPLOYEE_UPDATE_JSP;
		jsp += ".jsp";
		title = "Employee";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("arrival", arrival);

		return new ModelAndView("indexB", "map", map);

	}
    public void checkEmployeeFromDB(HttpServletRequest request , HttpServletResponse response){
    	Map<String ,Object> returnMap = new HashMap<String , Object>();
    	MasEmployee masEmployee = null;
    	boolean flag =false;
    	List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
    	int serviceTypeId = 0;
    	String serviceNo ="";
    	if(request.getParameter("serviceType")!=null && !request.getParameter("serviceType").equals("") )
    	{
    		serviceTypeId = Integer.parseInt(request.getParameter("serviceType"));
    	}
    	if(request.getParameter("serviceNo")!= null )
    	{
    		serviceNo=request.getParameter("serviceNo");
    	}
    	returnMap = hrOrderlyRoomHandlerService.EmployeeExist(serviceNo, serviceTypeId);
    	masEmployeeList = (List<MasEmployee>)returnMap.get("masEmployeeList");
    	flag = (Boolean)returnMap.get("flag");
    	StringBuffer sb = new StringBuffer();
    	try{
    	sb.append("<?xml version='1.0' encoding='ISO-8859-1'?>");
    	sb.append("<Employees>");
    	sb.append("<employee>");
    	if(flag==false){
    	masEmployee = masEmployeeList.get(0);	
    	sb.append("<ServiceNo>"+masEmployee.getServiceNo()+"</ServiceNo>");
    	sb.append("<ServiceType>"+masEmployee.getServiceType().getServiceTypeName()+"</ServiceType>");
    	sb.append("<flag>"+flag+"</flag>");
    	sb.append("<FirstName>"+masEmployee.getFirstName()+"</FirstName>");
    	sb.append("<LastName>"+masEmployee.getLastName()+"</LastName>");
    	sb.append("<employeeId>"+masEmployee.getId()+"</employeeId>");
    	}else{
    		sb.append("<ServiceNo></ServiceNo>");
        	sb.append("<ServiceType></ServiceType>");
        	sb.append("<flag>"+flag+"</flag>");
        	sb.append("<FirstName></FirstName>");
        	sb.append("<LastName></LastName>");
        	sb.append("<employeeId></employeeId>");
    	}
    	sb.append("</employee>");
    	sb.append("</Employees>");
    	response.setContentType("text/xml");
    	response.setHeader("Cache-Control", "no-cache");
    	//System.out.println("sb::"+sb.toString());
    	response.getWriter().write(sb.toString());
    	}catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
    	
    	
    }
	@SuppressWarnings("unchecked")
	public ModelAndView addEmployee(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		MasEmployee masEmployee = new MasEmployee();
		HrorderlyLeavechoice hrorderlyleavechoice = new HrorderlyLeavechoice();
		//HrLivingInOutDetail hrLivingInOutDetail = new HrLivingInOutDetail();
		List<HrorderlyLeaveAccount> hrorderlyleaveaccountList = new ArrayList<HrorderlyLeaveAccount>();
		Box box = HMSUtil.getBox(request);
		int listsize = 0;
		int Leavetypeid = 0;
		int Aleaveaccount = 0;
		int Oleaveaccount = 0;
		String firstName = "";
		String middleName = "";
		String lastName = "";
		int titleId = 0;
		int departmentId =107;
		int empStatusId = 0;
		int empCategoryId = 0;
		int gradeId = 0;
		int rankId = 0;
		int unitId = 0;
		int tradeId = 0;
		String serviceNo = "";
		String suffix = "";
		String prefix = "";
		String emergencyTellNumber = "";
		String emergencyCellNumber = "";
		String residenceTellNumber = "";
		String officeTellNumber = "";
		Date appointmentDate = null;
		Date birthDate = null;
		Date dateOfMarriage = null;
		String jobCode = "";
		String email = "";
		String employeeUrl = "";
		String bankCode = "";
		String accounthead = "";
		String bankAccountCode = "";
		String bankAccountNumber = "";
		String employeePhoto = "";
		String changedBy = "";
		Date joinDate = null;
		Date currentDate = new Date();
		Date postedDate = null;
		Date torsDate = null;
		String vide = "";
		String porSlNo = "";
		String living = "";
		int postedUnitId = 0;
		int serviceTypeId = 0;
		Date livingInDate = null;
		Date livingOutDate = null;
		String rationMoneyDrawn = "";
		Date rationDrawnFrom = null;
		Date moneyDrawnFrom = null;
		int messId = 0;
		String onPrc = "";
		String arrivalReport = "";
		String disciplinePending = "";
		String disciplineRemarks = "";
		String leaveChoice1 = "0";
		String leaveChoice2 = "0";
		String year = null;
		
		List<MasEmployeeDependent> masEmployeeDependentList = new ArrayList<MasEmployeeDependent>();
		

		session = request.getSession();

		if (request.getParameter(EMPLOYEE_CODE) != null) {
			code = request.getParameter(EMPLOYEE_CODE);
		}
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (request.getParameter(SUFFIX) != null) {
			suffix = request.getParameter(SUFFIX);
		}
		if (request.getParameter(PREFIX) != null) {
			prefix = request.getParameter(PREFIX);
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

		if (request.getParameter(APPOINTMENT_DATE) != null
				&& !(request.getParameter(APPOINTMENT_DATE).equals(""))) {
			appointmentDate = new Date();
			appointmentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(APPOINTMENT_DATE));
					}
		
		if (request.getParameter(BIRTH_DATE) != null
				&& !(request.getParameter(BIRTH_DATE).equals(""))) {
			birthDate = new Date();
			birthDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(BIRTH_DATE));
		}
		
		
		
		if (request.getParameter(DATE_OF_MARRIAGE) != null
				&& !(request.getParameter(DATE_OF_MARRIAGE).equals(""))) {
			dateOfMarriage = new Date();
			dateOfMarriage = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DATE_OF_MARRIAGE));
		}
		
		if (request.getParameter(JOIN_DATE) != null
				&& !(request.getParameter(JOIN_DATE).equals(""))) {
			joinDate = new Date();
			joinDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(JOIN_DATE));
		}
		if (!request.getParameter(TITLE_ID).equals("0")) {
			titleId = Integer.parseInt(request.getParameter(TITLE_ID));
		}
		if (!request.getParameter(EMPLOYEE_GRADE_ID).equals("0")) {
			gradeId = Integer.parseInt(request.getParameter(EMPLOYEE_GRADE_ID));
		}

		if (!request.getParameter(EMP_STATUS_ID).equals("0")) {
			empStatusId = Integer.parseInt(request.getParameter(EMP_STATUS_ID));
		}
		if (!request.getParameter(RANK_ID).equals("0")) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
		}
		if (!request.getParameter(UNIT_ID).equals("0")) {
			unitId = Integer.parseInt(request.getParameter(UNIT_ID));
		}
		if (!request.getParameter(TRADE_ID).equals("0")) {
			tradeId = Integer.parseInt(request.getParameter(TRADE_ID));
		}
		if (!request.getParameter(EMPLOYEE_CATEGORY_ID).equals("0")) {
			empCategoryId = Integer.parseInt(request
					.getParameter(EMPLOYEE_CATEGORY_ID));
		}
		if (!request.getParameter(DEPARTMENT_ID).equals("0")) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
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
		if (request.getParameter(BANK_ACCOUNT_CODE) != null) {
			bankAccountCode = request.getParameter(BANK_ACCOUNT_CODE);
		}
		if (request.getParameter(ACCOUNT_HEAD) != null) {
			accounthead = request.getParameter(ACCOUNT_HEAD);
		}
		if (request.getParameter(BANK_CODE) != null) {
			bankCode = request.getParameter(BANK_CODE);
		}
		if (request.getParameter(EMAIL) != null) {
			email = request.getParameter(EMAIL);
		}
		if (request.getParameter(URL) != null) {
			employeeUrl = request.getParameter(URL);
		}
		if (request.getParameter(BANK_ACCOUNT_NUMBER) != null) {
			bankAccountNumber = request.getParameter(BANK_ACCOUNT_NUMBER);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
			String yearcurrent[] = request.getParameter(CHANGED_DATE)
					.split("/");
			year = yearcurrent[2];

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

		if (request.getParameter(POSTING_DATE) != null
				&& !(request.getParameter(POSTING_DATE).equals(""))) {
			postedDate = new Date();
			postedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(POSTING_DATE));
		}
		if (request.getParameter(TORS) != null
				&& !(request.getParameter(TORS).equals(""))) {
			torsDate = new Date();
			torsDate = HMSUtil
					.dateFormatterDDMMYYYY(request.getParameter(TORS));
		}
		if (request.getParameter(VIDE) != null) {
			vide = request.getParameter(VIDE);
		}
		if (request.getParameter(POR_SLNO) != null) {
			porSlNo = request.getParameter(POR_SLNO);
		}
		if (request.getParameter(LIVING) != null) {
			living = request.getParameter(LIVING);
			//hrLivingInOutDetail.setLivingInOutStatus(living);
		}
		if (!request.getParameter(POSTED_UNIT_ID).equals("0")) {
			postedUnitId = Integer.parseInt(request
					.getParameter(POSTED_UNIT_ID));
		}
		if (!request.getParameter(SERVICE_TYPE_ID).equals("0")) {
			serviceTypeId = Integer.parseInt(request
					.getParameter(SERVICE_TYPE_ID));
		}
		if (request.getParameter(LIVING_IN_DATE) != null
				&& !request.getParameter(LIVING_IN_DATE).equals("")) {
			livingInDate = new Date();
			livingInDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(LIVING_IN_DATE));

		}
		if (request.getParameter(LIVING_OUT_DATE) != null
				&& !request.getParameter(LIVING_OUT_DATE).equals("")) {
			livingOutDate = new Date();
			livingOutDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(LIVING_OUT_DATE));
		}
		if (request.getParameter(RATION_MONEY_DRAWN) != null) {
			rationMoneyDrawn = request.getParameter(RATION_MONEY_DRAWN);

		}
		if (request.getParameter(RATION_DRAWN_FROM) != null
				&& !request.getParameter(RATION_DRAWN_FROM).equals("")) {
			rationDrawnFrom = new Date();
			rationDrawnFrom = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(RATION_DRAWN_FROM));

		}
		if (request.getParameter(MONEY_DRAWN_FROM) != null
				&& !request.getParameter(MONEY_DRAWN_FROM).equals("")) {
			moneyDrawnFrom = new Date();
			moneyDrawnFrom = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(MONEY_DRAWN_FROM));
		}
		if (!request.getParameter(MESS_NAME).equals("0")) {
			messId = Integer.parseInt(request.getParameter(MESS_NAME));
		}

		if (request.getParameter(ON_PRC) != null) {
			onPrc = request.getParameter(ON_PRC);

		}

		if (request.getParameter(DISCIPLINE_PENDING) != null) {
			disciplinePending = request.getParameter(DISCIPLINE_PENDING);
		}
		if (request.getParameter(DISCIPLINE_REMARKS) != null) {
			disciplineRemarks = request.getParameter(DISCIPLINE_REMARKS);
		}
		if (request.getParameter(LEAVE_CHOICE_1) != null
				&& !request.getParameter(LEAVE_CHOICE_1).equals("0")) {
			leaveChoice1 = request.getParameter(LEAVE_CHOICE_1);

		}
		if (request.getParameter(LEAVE_CHOICE_2) != null
				&& !request.getParameter(LEAVE_CHOICE_2).equals("0")) {
			leaveChoice2 = request.getParameter(LEAVE_CHOICE_2);

		}

		boolean successfullyAdded = false;
		Map<String , Object> returnMap = null;

		returnMap = (Map<String , Object>) hrOrderlyRoomHandlerService.EmployeeExist(serviceNo, serviceTypeId);
		successfullyAdded = (Boolean)returnMap.get("flag");
		if (successfullyAdded) {

			masEmployee.setEmployeeCode(code);
			masEmployee.setServiceNo(serviceNo);
			masEmployee.setFirstName(firstName);
			masEmployee.setLastName(lastName);
			masEmployee.setMiddleName(middleName);
			masEmployee.setEmployeePhoto(employeePhoto);
			masEmployee.setBankAccountNumber(bankAccountNumber);
			masEmployee.setUrl(employeeUrl);
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

			if (messId != 0) {
				HrorderlyMessMaster mess = new HrorderlyMessMaster();
				mess.setId(messId);
				masEmployee.setMess(mess);
			}
			masEmployee.setPrefix(prefix);
			masEmployee.setSuffix(suffix);
			masEmployee.setJobCode(jobCode);
			masEmployee.setAppointmentDate(appointmentDate);
			masEmployee.setDateOfBirth(birthDate);
			masEmployee.setDateOfMarriage(dateOfMarriage);
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

			masEmployee.setLivingInDate(livingInDate);
			masEmployee.setLivingOutDate(livingOutDate);
			/*if(hrLivingInOutDetail.getLivingInOutStatus()!=null){
				if(hrLivingInOutDetail.getLivingInOutStatus().equals("0"))
				{
					hrLivingInOutDetail.setLivingFromDate(livingInDate);
				}else{
					hrLivingInOutDetail.setLivingFromDate(livingOutDate);
				}
			}*/
			masEmployee.setRationMoneyDrawn(rationMoneyDrawn);
			masEmployee.setRationDrawnFrom(rationDrawnFrom);
			masEmployee.setMoneyDrawnFrom(moneyDrawnFrom);
			masEmployee.setOnPrc(onPrc);

			masEmployee.setDisciplinePending(disciplinePending);
			masEmployee.setDisciplineRemarks(disciplineRemarks);

			masEmployee.setStatus("y");
			masEmployee.setLastChgBy(changedBy);
			masEmployee.setLastChgDate(currentDate);
			masEmployee.setLastChgTime(currentTime);

			hrorderlyleavechoice.setLeaveChoice1(leaveChoice1);
			hrorderlyleavechoice.setLeaveChoice2(leaveChoice2);
			hrorderlyleavechoice.setStatus("y");
			hrorderlyleavechoice.setLastChgBy(changedBy);
			hrorderlyleavechoice.setLastChgDate(currentDate);
			hrorderlyleavechoice.setLastChgTime(currentTime);
			hrorderlyleavechoice.setYear(year);
			//System.out.println("year:::::::::  " + year);

			if (postedUnitId != 0) {
				MasUnit masUnit1 = new MasUnit();
				masUnit1.setId(postedUnitId);
				masEmployee.setPostedUnit(masUnit1);
			}

			masEmployee.setPorSlNo(porSlNo);
			masEmployee.setPostedDate(postedDate);
			masEmployee.setTors(torsDate);
			masEmployee.setLivingInOut(living);
			masEmployee.setVide(vide);
			if (serviceTypeId != 0) {
				MasServiceType masServiceType = new MasServiceType();
				masServiceType.setId(serviceTypeId);
				masEmployee.setServiceType(masServiceType);
			}

			if (request.getParameter("hrleavetypemasterlist") != null
					&& !request.getParameter("hrleavetypemasterlist")
							.equals("")) {
				listsize = Integer.parseInt(request
						.getParameter("hrleavetypemasterlist"));
			}
			//System.out.println("listsize:::::::::::" + listsize);
			for (int i = 1; i <= listsize; i++) {
				String param1 = "LeaveType" + i;
				String param2 = "Carryleave" + i;
				String param3 = "Availed" + i;
				//System.out.println(param1 + param2 + param3);

				if (request.getParameter(param1) != null
						&& !request.getParameter(param1).equals("")) {
					HrorderlyLeaveAccount hrorderlyleaveaccount = new HrorderlyLeaveAccount();
					Leavetypeid = Integer
							.parseInt(request.getParameter(param1));
					if (request.getParameter(param2) != null
							&& !request.getParameter(param2).equals("")) {
						Oleaveaccount = Integer.parseInt(request
								.getParameter(param2));
					}
					if (request.getParameter(param3) != null
							&& !request.getParameter(param3).equals("")) {
						Aleaveaccount = Integer.parseInt(request
								.getParameter(param3));
					}
					//System.out.println("lLeaveType " + Leavetypeid+ "Cleaveaccount" + Aleaveaccount + "Oleaveaccount"+ Oleaveaccount);
					hrorderlyleaveaccount.setLeaveTypeId(Leavetypeid);
					hrorderlyleaveaccount.setOLeaveBalance(Oleaveaccount);
					hrorderlyleaveaccount.setLeaveAvailed(Aleaveaccount);
					hrorderlyleaveaccount.setStatus("y");
					hrorderlyleaveaccount.setYear(year);
					hrorderlyleaveaccount.setCLeaveBalance(0);
					hrorderlyleaveaccount.setChgBy(changedBy);
					hrorderlyleaveaccount.setChgDate(currentDate);
					hrorderlyleaveaccount.setChgTime(currentTime);
					hrorderlyleaveaccountList.add(hrorderlyleaveaccount);
				}
			}
			Vector relationOfDependent = box.getVector(FAMILY);
			Vector nameOfDependent = box.getVector(NAME);
			Vector dateOfBirthOfDependent = box.getVector(DATE_OF_BIRTH);
			MasRelation masRelation = null ;
			MasEmployeeDependent masEmployeeDependent = null ;
			//System.out.println("relationOfDependent:::"+relationOfDependent.size()+"::nameOfDependent::"+nameOfDependent.size()+":dateOfBirthOfDependent:"+dateOfBirthOfDependent.size());
			for(int i = 0 ; relationOfDependent.size()>i ; i++){
				if(!relationOfDependent.get(i).toString().equals("")){
					masRelation=new MasRelation();
					masRelation.setId(Integer.parseInt(relationOfDependent.get(i).toString()));
					masEmployeeDependent = new MasEmployeeDependent();
					masEmployeeDependent.setRelation(masRelation);
					masEmployeeDependent.setStatus("y");
					masEmployeeDependent.setEmployeeDependentName(nameOfDependent.get(i).toString().trim());
					if(!dateOfBirthOfDependent.get(i).toString().trim().equals(""))
					masEmployeeDependent.setDateOfBirth(HMSUtil.convertStringTypeDateToDateType(dateOfBirthOfDependent.get(i).toString().trim()));
					masEmployeeDependentList.add(masEmployeeDependent);
					
				}
			}
			
			infoMap.put("masEmployee", masEmployee);
			infoMap.put("hrorderlyleaveaccountList", hrorderlyleaveaccountList);
			infoMap.put("hrorderlyleavechoice", hrorderlyleavechoice);
			infoMap.put("masEmployeeDependentList", masEmployeeDependentList);
			//infoMap.put("hrLivingInOutDetail", hrLivingInOutDetail);
			 map = hrOrderlyRoomHandlerService.addEmployee(infoMap);
             
	         if (((Boolean)map.get("successfullyAdded")).equals(true))
	         {
	            message = "Record Added Successfully !!";
	            jsp = "printArrival";
	         } else
	         {
	            message = "Try Again !!";
	            jsp=EMPLOYEE_ARRIVAL_JSP;
	            map=hrOrderlyRoomHandlerService.showEmployeeJsp();
	         }
	         
	      } else
	      {
	         message = "Employee already exists.";
	         jsp=EMPLOYEE_ARRIVAL_JSP;
	         map=hrOrderlyRoomHandlerService.showEmployeeJsp();

	      }
		url = "/hms/hms/personnel?method=showEmployeeJsp";
		
		
		title = "Add Employee";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView editEmployee(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployeeDependent> masEmployeeDependentList = new ArrayList<MasEmployeeDependent>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List<HrorderlyLeaveAccount> hrorderlyleaveaccountList = new ArrayList<HrorderlyLeaveAccount>();
		int listsize = 0;
		int Leavetypeid = 0;
		int Aleaveaccount = 0;
		int Oleaveaccount = 0;
		String employeeCode = "";
		String firstName = "";
		String middleName = "";
		String lastName = "";
		String onPrc = "";
        int messId =0;
		int departmentId = 107;

		int empStatusId = 0;
		int empCategoryId = 0;
		int personnelId = 0;
		int gradeId = 0;
		int rankId = 0;
		int unitId = 0;
		int tradeId = 0;
		String leavechoiceid = null;

		String serviceNo = "";
		String suffix = "";
		String prefix = "";
		String emergencyTellNumber = "";
		String emergencyCellNumber = "";
		String residenceTellNumber = "";
		String officeTellNumber = "";
		Date appointmentDate = null;
		
		Date birthDate = null;
		Date dateOfMarriage = null;
		

		String changedBy = "";
		String email = "";
		String bankCode = "";
		String employeePhoto = "";
		String employeeUrl = "";
		String accountHead = "";
		String leaveChoice1 = "0";
		String leaveChoice2 = "0";
		int titleId = 0;
		String bankAccountCode = "";
		String grade = "";
		Date joinDate = null;
		Date changedDate = null;
		Date currentDate = new Date();
		Date LivingInDate = null;
		Date LivingOutDate = null;
		Date RationDrawnDate = null;
		Date MoneyDrawnDate = null;
		Date ArrivalCompleted=null;

		String changedTime = "";
		int employeeId = 0;
		String bankAccountNumber = "";

		Date postedDate = null;
		Date torsDate = null;
		String vide = "";
		String porSlNo = "";
		String living = "";
		String discipline = "";
		String disciplineRemarks = "";
		String RationMoneyDrawn = "";
		String year = null;
		int postedUnitId = 0;
		int serviceTypeId = 0;
		Box box = HMSUtil.getBox(request);
        boolean arrival = false;
		session = request.getSession();
		//System.out.println("in edit employee");
		int hospitalId = (Integer) session.getAttribute("hospitalId");

		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
			String yeararray[] = request.getParameter(CHANGED_DATE).split("/");
			year = yeararray[2];
		}
        
		if (request.getParameter("employeeId") != null
				&& !(request.getParameter("employeeId").equals(""))) {
			employeeId = Integer.parseInt(request.getParameter("employeeId"));
		}
		if (request.getParameter("leavechoiceid") != null
				&& !(request.getParameter("leavechoiceid").equals(""))) {
			leavechoiceid = request.getParameter("leavechoiceid");
		}
		if (request.getParameter(EMPLOYEE_CODE) != null
				&& !(request.getParameter(EMPLOYEE_CODE).equals(""))) {
			employeeCode = request.getParameter(EMPLOYEE_CODE);
		}
		/*if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
		}*/
		if (request.getParameter(SUFFIX) != null) {
			suffix = request.getParameter(SUFFIX);
		}
		if (request.getParameter("preFix") != null) {
			prefix = request.getParameter("preFix");
		}
		if (!request.getParameter(TITLE_ID).equals("0")
				&& request.getParameter(TITLE_ID) != null) {
			titleId = Integer.parseInt(request.getParameter(TITLE_ID));
			//System.out.println(" title   " + titleId);
		}

		if (request.getParameter(BANK_ACCOUNT_NUMBER) != null) {
			bankAccountNumber = request.getParameter(BANK_ACCOUNT_NUMBER);
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
		if (request.getParameter(APPOINTMENT_DATE) != null
				&& !request.getParameter(APPOINTMENT_DATE).equals("")) {
			appointmentDate = new Date();
			appointmentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(APPOINTMENT_DATE));
		}		
		
		if (request.getParameter(BIRTH_DATE) != null
				&& !(request.getParameter(BIRTH_DATE).equals(""))) {
			birthDate = new Date();
			birthDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(BIRTH_DATE));
			////System.out.println("111111111111111111111"+birthDate);
		}
						
		if (request.getParameter(DATE_OF_MARRIAGE) != null
				&& !(request.getParameter(DATE_OF_MARRIAGE).equals(""))) {
			dateOfMarriage = new Date();
			dateOfMarriage = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DATE_OF_MARRIAGE));
			////System.out.println("111111111111111222222222111111"+dateOfMarriage);
		}
				
		if (request.getParameter("arrivalCompleted") != null
				&& !request.getParameter("arrivalCompleted").equals("")) {
			ArrivalCompleted = new Date();
			ArrivalCompleted = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("arrivalCompleted"));
		}
		if (request.getParameter(JOIN_DATE) != null
				&& !request.getParameter(JOIN_DATE).equals("")) {
			joinDate = new Date();
			joinDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(JOIN_DATE));
		}
		if (!request.getParameter(EMPLOYEE_CATEGORY_ID).equals("0")) {
			empCategoryId = Integer.parseInt(request
					.getParameter(EMPLOYEE_CATEGORY_ID));
		}
		if (!request.getParameter(DEPARTMENT_ID).equals("0")) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}

		if (!request.getParameter(EMPLOYEE_GRADE_ID).equals("0")) {
			gradeId = Integer.parseInt(request.getParameter(EMPLOYEE_GRADE_ID));
		}
		if (!request.getParameter(RANK_ID).equals("0")) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
		}
		if (!request.getParameter(UNIT_ID).equals("0")) {
			unitId = Integer.parseInt(request.getParameter(UNIT_ID));
		}
		if (!request.getParameter(TRADE_ID).equals("0")) {
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
		if (!request.getParameter(EMP_STATUS_ID).equals("0")) {
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

		if (request.getParameter(POSTING_DATE) != null
				&& !(request.getParameter(POSTING_DATE).equals(""))) {
			postedDate = new Date();
			postedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(POSTING_DATE));
		}
		if (request.getParameter(TORS) != null
				&& !(request.getParameter(TORS).equals(""))) {
			torsDate = new Date();
			torsDate = HMSUtil
					.dateFormatterDDMMYYYY(request.getParameter(TORS));
		}
		if (request.getParameter(VIDE) != null) {
			vide = request.getParameter(VIDE);
		}
		if (request.getParameter(POR_SLNO) != null) {
			porSlNo = request.getParameter(POR_SLNO);
		}
		if (request.getParameter(LIVING) != null) {
			living = request.getParameter(LIVING);
		}

		if (request.getParameter(LIVING_IN_DATE) != null
				&& !(request.getParameter(LIVING_IN_DATE).equals(""))) {
			LivingInDate = new Date();
			LivingInDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(LIVING_IN_DATE));
		}
		if (request.getParameter(LIVING_OUT_DATE) != null
				&& !(request.getParameter(LIVING_OUT_DATE).equals(""))) {
			LivingOutDate = new Date();
			LivingOutDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(LIVING_OUT_DATE));
		}
		if (request.getParameter(RATION_MONEY_DRAWN) != null) {
			RationMoneyDrawn = request.getParameter(RATION_MONEY_DRAWN);
		}
		if (request.getParameter(RATION_DRAWN_FROM) != null
				&& !(request.getParameter(RATION_DRAWN_FROM).equals(""))) {
			RationDrawnDate = new Date();
			RationDrawnDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(RATION_DRAWN_FROM));
		}
		if (request.getParameter(MONEY_DRAWN_FROM) != null
				&& !(request.getParameter(MONEY_DRAWN_FROM).equals(""))) {
			MoneyDrawnDate = new Date();
			MoneyDrawnDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(MONEY_DRAWN_FROM));
		}

		if (request.getParameter(DISCIPLINE_PENDING).equals("0")) {
			discipline = "0";
		} else {
			discipline = "1";
		}

		if (!request.getParameter(DISCIPLINE_REMARKS).equals("")) {
			disciplineRemarks = request.getParameter(DISCIPLINE_REMARKS);
		}

		if (!request.getParameter(ON_PRC).equals("")) {
			onPrc = request.getParameter(ON_PRC);
		}

		if (request.getParameter(LEAVE_CHOICE_1) != null
				&& !request.getParameter(LEAVE_CHOICE_1).equals("0")) {
			leaveChoice1 = request.getParameter(LEAVE_CHOICE_1);
		}
		if (request.getParameter(LEAVE_CHOICE_2) != null
				&& !request.getParameter(LEAVE_CHOICE_2).equals("0")) {
			leaveChoice2 = request.getParameter(LEAVE_CHOICE_2);
		}

		if (!request.getParameter(POSTED_UNIT_ID).equals("0")) {
			postedUnitId = Integer.parseInt(request
					.getParameter(POSTED_UNIT_ID));
		}
		if (request.getParameter("arrival")!=null) {
			arrival = Boolean.parseBoolean(request.getParameter("arrival"));
		}
		if (!request.getParameter(MESS_NAME).equals("0")) {
			messId = Integer.parseInt(request.getParameter(MESS_NAME));
		}
		/*if (request.getParameter(SERVICE_TYPE_ID) !=null && !request.getParameter(SERVICE_TYPE_ID).equals("0")) {
			serviceTypeId = Integer.parseInt(request
					.getParameter(SERVICE_TYPE_ID));
		}*/
		personnelId = (Integer) session.getAttribute(HOSPITAL_ID);

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		if (request.getParameter("hrleavetypemasterlist") != null
				&& !request.getParameter("hrleavetypemasterlist").equals("")) {
			listsize = Integer.parseInt(request
					.getParameter("hrleavetypemasterlist"));
		}
		//System.out.println("listsize:::::::::::" + listsize);
		for (int i = 1; i <= listsize; i++) {
			String param1 = "LeaveType" + i;
			String param2 = "Carryleave" + i;
			String param3 = "Availed" + i;
			//System.out.println(param1 + param2 + param3);

			if (request.getParameter(param1) != null
					&& !request.getParameter(param1).equals("")) {
				HrorderlyLeaveAccount hrorderlyleaveaccount = new HrorderlyLeaveAccount();
				Leavetypeid = Integer.parseInt(request.getParameter(param1));
				if (request.getParameter(param2) != null
						&& !request.getParameter(param2).equals("")) {
					Oleaveaccount = Integer.parseInt(request
							.getParameter(param2));
				}
				if (request.getParameter(param3) != null
						&& !request.getParameter(param3).equals("")) {
					Aleaveaccount = Integer.parseInt(request
							.getParameter(param3));
				}
				//System.out.println("LeaveType " + Leavetypeid + "Cleaveaccount"+ Aleaveaccount + "Oleaveaccount" + Oleaveaccount);
				hrorderlyleaveaccount.setEmployeeId(employeeId);
				hrorderlyleaveaccount.setLeaveTypeId(Leavetypeid);
				hrorderlyleaveaccount.setOLeaveBalance(Oleaveaccount);
				hrorderlyleaveaccount.setLeaveAvailed(Aleaveaccount);
				hrorderlyleaveaccount.setStatus("y");
				hrorderlyleaveaccount.setYear(year);
				hrorderlyleaveaccount.setCLeaveBalance(0);
				hrorderlyleaveaccount.setChgBy(changedBy);
				hrorderlyleaveaccount.setChgDate(currentDate);
				hrorderlyleaveaccount.setChgTime(currentTime);
				hrorderlyleaveaccountList.add(hrorderlyleaveaccount);
			}
		}
		Vector relationOfDependent = box.getVector(FAMILY);
		Vector nameOfDependent = box.getVector(NAME);
		Vector dateOfBirthOfDependent = box.getVector(DATE_OF_BIRTH);
		MasRelation masRelation = null ;
		MasEmployeeDependent masEmployeeDependent = null ;
		//System.out.println("relationOfDependent:::"+relationOfDependent.size()+"::nameOfDependent::"+nameOfDependent.size()+":dateOfBirthOfDependent:"+dateOfBirthOfDependent.size());
		for(int i = 0 ; relationOfDependent.size()>i ; i++){
			if(!relationOfDependent.get(i).toString().equals("")){
				masRelation=new MasRelation();
				masRelation.setId(Integer.parseInt(relationOfDependent.get(i).toString()));
				masEmployeeDependent = new MasEmployeeDependent();
				masEmployeeDependent.setRelation(masRelation);
				masEmployeeDependent.setStatus("y");
				masEmployeeDependent.setEmployeeDependentName(nameOfDependent.get(i).toString().trim());
				if(!dateOfBirthOfDependent.get(i).toString().trim().equals(""))
				masEmployeeDependent.setDateOfBirth(HMSUtil.convertStringTypeDateToDateType(dateOfBirthOfDependent.get(i).toString().trim()));
				masEmployeeDependentList.add(masEmployeeDependent);
				
			}
		}
		generalMap.put("masEmployeeDependentList",masEmployeeDependentList);
		
		generalMap.put("hrorderlyleaveaccountList", hrorderlyleaveaccountList);
		generalMap.put("id", employeeId);
		generalMap.put("personnelId", personnelId);
		generalMap.put("titleId", titleId);
		generalMap.put("employeeCode", employeeCode);
		//generalMap.put("serviceNo", serviceNo);
		generalMap.put("suffix", suffix);
		generalMap.put("prefix", prefix);
		generalMap.put("firstName", firstName);
		generalMap.put("middleName", middleName);
		// generalMap.put("personnelId", personnelId);
		generalMap.put("lastName", lastName);

		generalMap.put("bankCode", bankCode);
		generalMap.put("employeePhoto", employeePhoto);
		generalMap.put("employeeUrl", employeeUrl);

		generalMap.put("emergencyCellNumber", emergencyCellNumber);
		generalMap.put("residenceTellNumber", residenceTellNumber);
		generalMap.put("officeTellNumber", officeTellNumber);
		generalMap.put("email", email);
		generalMap.put("accountHead", accountHead);
		generalMap.put("appointmentDate", appointmentDate);
		
		
		generalMap.put("birthDate", birthDate);
		generalMap.put("dateOfMarriage", dateOfMarriage);
			
		generalMap.put("joinDate", joinDate);
		generalMap.put("gradeId", gradeId);
		generalMap.put("empCategoryId", empCategoryId);
		generalMap.put("tradeId", tradeId);
		generalMap.put("rankId", rankId);
		generalMap.put("unitId", unitId);
		generalMap.put("departmentId", departmentId);
		generalMap.put("empStatusId", empStatusId);

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

		generalMap.put("postedDate", postedDate);
		generalMap.put("torsDate", torsDate);
		generalMap.put("vide", vide);
		generalMap.put("porSlNo", porSlNo);
		generalMap.put("living", living);
		generalMap.put("LivingInDate", LivingInDate);
		generalMap.put("LivingOutDate", LivingOutDate);
		generalMap.put("RationMoneyDrawn", RationMoneyDrawn);
		generalMap.put("RationDrawnDate", RationDrawnDate);
		generalMap.put("MoneyDrawnDate", MoneyDrawnDate);

		generalMap.put("discipline", discipline);
		generalMap.put("disciplineRemarks", disciplineRemarks);
		generalMap.put("onPrc", onPrc);

		generalMap.put("leaveChoice1", leaveChoice1);
		generalMap.put("leaveChoice2", leaveChoice2);
        generalMap.put("messId", messId);
		generalMap.put("postedUnitId", postedUnitId);
	//	generalMap.put("serviceTypeId", serviceTypeId);
		generalMap.put("year", year);
		generalMap.put("leavechoiceid", leavechoiceid);
		generalMap.put("ArrivalCompleted", ArrivalCompleted);
		//System.out.println("leavechoiceid  " + leavechoiceid);

		boolean dataUpdated = false;
		dataUpdated = hrOrderlyRoomHandlerService
				.editEmployeeToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Record Cant Be Updated !!";
		}
		url = "/hms/hms/personnel?method=showEmployeeJsp";
		try {
			System.out.println("::3::"+arrival);
			if(arrival){
				map = hrOrderlyRoomHandlerService.showEmployeeJsp();
				jsp = EMPLOYEE_ARRIVAL_JSP;
			}else{
			//map = hrOrderlyRoomHandlerService.showEmployeeUpdateJsp(employeeId);
			jsp = SEARCH_EMPLOYEE;
			}
		} catch (Exception e) {
			//System.out.println("Exception in showEmployeeJsp " + e);
		}
		
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
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter("employeeId") != null
				&& !(request.getParameter("employeeId").equals(""))) {
			employeeId = Integer.parseInt(request.getParameter("employeeId"));
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
		dataDeleted = hrOrderlyRoomHandlerService.deleteEmployee(employeeId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showEmployeeJsp";
		try {
			map = hrOrderlyRoomHandlerService.showEmployeeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = EMPLOYEE_ARRIVAL_JSP;
		title = "Delete Employee";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generateArrivalReport(HttpServletRequest request, HttpServletResponse response)
	   {
	      ServletContext context = request.getSession().getServletContext();
	      Map<String, Object> parameters = new HashMap();
	      Map<String, Object> connectionMap = hrOrderlyRoomHandlerService.getConnectionForReport();
	      int empId = 0;
	      String query = "";
	      int rankCategoryId = 0;
	      try
	      {

	        /* if (request.getParameter("rankCategoryId") != null)
	         {
	            rankCategoryId = Integer.parseInt((String)request.getParameter("rankCategoryId"));

	            //System.out.println("abccccccc" + rankCategoryId);
	         }*/

	         if (request.getParameter("employee_id") != null)
	         {
	            empId = Integer.parseInt((String)request.getParameter("employee_id"));

	            //System.out.println("empccc" + empId);
	         }
	         parameters.put("employee_id", empId);
	         parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
	         /*if (rankCategoryId == 1)
	         {
	         HMSUtil.generateReport("arrivalReport-Officers", parameters, (Connection) connectionMap.get("conn"), response,
	                  getServletContext());

	         } else
	         {
	            
	            HMSUtil.generateReport("arrivalReport-Airmen", parameters, (Connection) connectionMap.get("conn"),
	                  response, getServletContext());
	         }*/
	         
	         HMSUtil.generateReport("arrivalReport-Airmen", parameters, (Connection) connectionMap.get("conn"),
	                  response, getServletContext());
	      } catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return null;
	   }
	
	public ModelAndView generateArrivalReportOfficer(HttpServletRequest request, HttpServletResponse response)
	   {
	      ServletContext context = request.getSession().getServletContext();
	      Map<String, Object> parameters = new HashMap();
	      Map<String, Object> connectionMap = hrOrderlyRoomHandlerService.getConnectionForReport();
	      int empId = 0;
	      try
	      {

	         if (request.getParameter("employee_id") != null)
	         {
	            empId = Integer.parseInt((String)request.getParameter("employee_id"));
 	         }
	         parameters.put("employee_id", empId);
	         parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
	         HMSUtil.generateReport("arrivalReport-Officer", parameters, (Connection) connectionMap.get("conn"),
	                  response, getServletContext());
	      } catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return null;
	   }
	public ModelAndView generateArrivalReportBlank(HttpServletRequest request, HttpServletResponse response)
	   {
	      ServletContext context = request.getSession().getServletContext();
	      Map<String, Object> parameters = new HashMap();
	      Map<String, Object> connectionMap = hrOrderlyRoomHandlerService.getConnectionForReport();
	      try
	      {

	         parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
	         HMSUtil.generateReport("arrivalReport-Blank", parameters, (Connection) connectionMap.get("conn"),
	                  response, getServletContext());
	      } catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return null;
	   }
	
	public ModelAndView generateClearenceReport(HttpServletRequest request, HttpServletResponse response)
	   {
	      ServletContext context = request.getSession().getServletContext();
	      Map<String, Object> parameters = new HashMap();
	      Map<String, Object> connectionMap = hrOrderlyRoomHandlerService.getConnectionForReport();
	      int empId = 0;
	      String query = "";
	      int rankCategoryId = 0;
	      try
	      {

	         if (request.getParameter("rankCategoryId") != null)
	         {
	            rankCategoryId = Integer.parseInt((String)request.getParameter("rankCategoryId"));

	            //System.out.println("abccccccc" + rankCategoryId);
	         }

	         if (request.getParameter("employee_id") != null)
	         {
	            empId = Integer.parseInt((String)request.getParameter("employee_id"));

	            //System.out.println("empccc" + empId);
	         }
	         parameters.put("employee_id", empId);
	         parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
	         if (rankCategoryId == 1)
	         {
	         HMSUtil.generateReport("clearence-certificate-Officer", parameters, (Connection) connectionMap.get("conn"), response,
	                  getServletContext());

	         } else
	         {
	            
	            HMSUtil.generateReport("clearence-certificate-Airmen", parameters, (Connection) connectionMap.get("conn"),
	                  response, getServletContext());
	         }
	      } catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return null;
	   }
	public ModelAndView generateLeaveApplicationReport(HttpServletRequest request, HttpServletResponse response)
	   {
	      ServletContext context = request.getSession().getServletContext();
	      Map<String, Object> parameters = new HashMap();
	      Map<String, Object> connectionMap = hrOrderlyRoomHandlerService.getConnectionForReport();
	      int empId = 0;
	      String query = "";
	      int rankCategoryId = 0;
	      try
	      {

	         if (request.getParameter("rankCategoryId") != null)
	         {
	            rankCategoryId = Integer.parseInt((String)request.getParameter("rankCategoryId"));

	            //System.out.println("abccccccc" + rankCategoryId);
	         }

	         if (request.getParameter("empId") != null)
	         {
	            empId = Integer.parseInt((String)request.getParameter("empId"));

	            //System.out.println("empccc" + empId);
	         }
	         parameters.put("employee_id", empId);
	         parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
	         if (rankCategoryId == 1)
	         {
	         HMSUtil.generateReport("LeaveApplication-Officer", parameters, (Connection) connectionMap.get("conn"), response,
	                  getServletContext());

	         } else
	         {
	            
	            HMSUtil.generateReport("LeaveApplicationAirmen", parameters, (Connection) connectionMap.get("conn"),
	                  response, getServletContext());
	         }
	      } catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return null;
	   }

	// /////////// MONTHLY RATION ACCOUNTING

	public ModelAndView showMonthlyRationAccountingJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		jsp = MONTHLY_RATION_ACCOUNTING_JSP;
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView showMonthlyRationAccountingRecords(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = hrOrderlyRoomHandlerService
				.getEmployeeDetailsForMonthlyRationAccountingDuty(box);
		jsp = MONTHLY_RATION_ACCOUNTING_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}
	public ModelAndView getGridDataForMonthlyRationStrength(HttpServletRequest request , HttpServletResponse response)
	{
		Map<String , Object> map = new HashMap<String , Object>();
		Box box = HMSUtil.getBox(request);
		map = hrOrderlyRoomHandlerService.getGridDataForMonthlyRationStrength(box);
		jsp= MONTHLY_RATION_ACCOUNTING_JSP ;
		jsp +=".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB","map",map);
	}
	
	public ModelAndView getDetailsForEmployeeAbsence(HttpServletRequest request , HttpServletResponse response)
	{
		Map<String , Object> map = new HashMap<String , Object>();
		Box box = HMSUtil.getBox(request);
		map = hrOrderlyRoomHandlerService.getDetailsForEmployeeAbsence(box);
		jsp="monthlyRationAccountingDetail";
		jsp +=".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("monthlyRationAccountingDetail","map",map);
	
	}

	public ModelAndView updateMonthlyRationAccounting(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		successfullyAdded = hrOrderlyRoomHandlerService
				.updateMonthlyRationAccounting(box);

		if (successfullyAdded) {
			message = "Record updated Successfully !!";
		} else {
			message = "Try Again !!";

		}
		map.put("message", message);
		jsp = MONTHLY_RATION_ACCOUNTING_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView showPrintScreenForMonthlyRationAccounting(HttpServletRequest request , HttpServletResponse response ){
		Map<String , Object > map = new HashMap<String , Object >();
		String years ="";
		String months="";
		if(request.getParameter("year")!=null && !request.getParameter("year").equals("")){
			years=(String)request.getParameter("year");
		}
		if(request.getParameter("month")!=null && !request.getParameter("month").equals("")){
			months=(String)request.getParameter("month");
		}
		map.put("years", years);
		map.put("months", months);
		jsp="hr_monthly_ration_accounting_print.jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map); 
	}
	public void printMonthlyRationAccountingReports(HttpServletRequest request , HttpServletResponse response ){
		int monthlyRation = 0;
		int years =0;
		int months=0;
		String ReportName ="" ;
		Map<String , Object> parameters = new HashMap();
		Map<String, Object> connectionMap = hrOrderlyRoomHandlerService.getConnectionForReport();
		if(request.getParameter("monthlyRation")!=null && !request.getParameter("monthlyRation").equals(""))
		{
			monthlyRation=Integer.parseInt((String)request.getParameter("monthlyRation"));
		}
		if(request.getParameter("years")!=null && !request.getParameter("years").equals(""))
		{
			years=Integer.parseInt((String)request.getParameter("years"));
		}
		if(request.getParameter("months")!=null && !request.getParameter("months").equals(""))
		{
			months=Integer.parseInt((String)request.getParameter("months"));
		}
		//System.out.println("::1:::"+monthlyRation+"::2::"+years+"::3::"+months);
		if(monthlyRation!=0 && years!=0 && months!=0){
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		    parameters.put("year", years);
		    parameters.put("month", months);
	        if(monthlyRation==1){
	        ReportName="monthly_ration_accounting_airmen" ;
	        }
	        if(monthlyRation==2){
	        ReportName="monthly_ration_accounting_snco" ;	
	        }
	        if(monthlyRation==3){
		        ReportName="monthly_ration_accounting_airmen_td" ;	
		    }
	        if(monthlyRation==4){
		        ReportName="monthly_ration_accounting_snco_td" ;	
		        }
	        if(monthlyRation==5){
		        ReportName="consolidated_ration_summary_mess_wise" ;	
		        }
	        if(monthlyRation==6){
		        ReportName="daily_ration_summary" ;	
		        hrOrderlyRoomHandlerService.printRationSummaryDaily( months , years );
		        }
	        try
	        {

	           HMSUtil.generateReport(ReportName, parameters, (java.sql.Connection) connectionMap
	                 .get("conn"), response, getServletContext());

	        } catch (Exception e)
	        {
	           e.printStackTrace();
	        }
	}
		}

	// //////////////////// DELETE METHODS
	public ModelAndView showNominalRollRegisterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String userName = "";
		String title = "";
		jsp += NOMINAL_ROLL_REGISTER_JSP;
		jsp += ".jsp";
		title = "NominalRollRegister";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showRationSummaryMonthlyJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String userName = "";
		String title = "";
		jsp += RATION_SUMMARY_MONTHLY_JSP;
		jsp += ".jsp";
		title = "Ration Summary Monthly";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showLivingInRegisterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String userName = "";
		String title = "";
		jsp += LIVING_IN_REGISTER_JSP;
		jsp += ".jsp";
		title = "Living In Register";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showLivingOutRegisterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String userName = "";
		String title = "";
		jsp += LIVING_OUT_REGISTER_JSP;
		jsp += ".jsp";
		title = "Living Out Register";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printlivingInRegister(HttpServletRequest request,
			HttpServletResponse response) {
		ServletContext context = request.getSession().getServletContext();
		Map<String, Object> parameters = new HashMap();
		Date date = null;
		try {

			if (request.getParameter(DATE) != null) {
				date = HMSUtil
						.dateFormatterDDMMYYYY(request.getParameter(DATE));
			}

			parameters.put("date", date);
			Map<String, Object> connectionMap = hrOrderlyRoomHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("livingInRegister", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printlivingOutRegister(HttpServletRequest request,
			HttpServletResponse response) {
		ServletContext context = request.getSession().getServletContext();
		Map<String, Object> parameters = new HashMap();
		Date date = null;
		try {

			if (request.getParameter(DATE) != null) {
				date = HMSUtil
						.dateFormatterDDMMYYYY(request.getParameter(DATE));
			}

			parameters.put("date", date);
			Map<String, Object> connectionMap = hrOrderlyRoomHandlerService
					.getConnectionForReport();
			HMSUtil.generateReport("livingOutRegister", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// :::::::::::::::added by yogesh for hr master
	/**
	 * ------------------ Speciality Master ------------ added by Priyanka on
	 * 29th April 2009
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showSpecialityJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = hrOrderlyRoomHandlerService.showSpecialityJsp();
		@SuppressWarnings("unused")
		ArrayList searchCountryList = (ArrayList) map.get("searchCountryList");
		jsp = SPECIALITY_JSP;
		jsp += ".jsp";
		title = "Country";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addSpeciality(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HrSpecialistMaster hrSpecialistMaster = new HrSpecialistMaster();

		String changedBy = "";
		int tradeId = 0;
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
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
		if (request.getParameter(TRADE_NAME) != null
				&& !request.getParameter(TRADE_NAME).equals("")) {
			tradeId = Integer.parseInt(request.getParameter(TRADE_NAME));
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
		List specialityCodeList = new ArrayList();
		List specialityNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			specialityCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			specialityNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((specialityCodeList.size() == 0 || specialityCodeList == null)
				&& (specialityNameList.size() == 0 || specialityNameList == null))

		{
			hrSpecialistMaster.setSpecialistCode(code);
			hrSpecialistMaster.setSpecialistName(name);
			hrSpecialistMaster.setStatus("y");
			hrSpecialistMaster.setHospitalId(hospitalId);
			hrSpecialistMaster.setLastChgBy(changedBy);
			hrSpecialistMaster.setLastChgDate(currentDate);
			hrSpecialistMaster.setLastChgTime(currentTime);
			if (tradeId != 0) {
				MasTrade masTrade = new MasTrade();
				masTrade.setId(tradeId);
				hrSpecialistMaster.setTradeId(masTrade);

			}
			successfullyAdded = hrOrderlyRoomHandlerService
					.addSpeciality(hrSpecialistMaster);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";

			}
		} else if ((specialityCodeList.size() != 0 || specialityCodeList != null)
				|| (specialityNameList.size() != 0)
				|| specialityNameList != null) {

			if ((specialityCodeList.size() != 0 || specialityCodeList != null)
					&& (specialityNameList.size() == 0 || specialityNameList == null)) {

				message = "Speciality Code  already exists.";
			} else if ((specialityNameList.size() != 0 || specialityNameList != null)
					&& (specialityCodeList.size() == 0 || specialityCodeList == null)) {

				message = "Speciality Name  already exists.";
			} else if ((specialityCodeList.size() != 0 || specialityCodeList != null)
					&& (specialityNameList.size() != 0 || specialityNameList != null)) {

				message = "Speciality Code and Country Name already exist.";
			}
		}

		url = "/hms/hms/hrOrderly?method=showCountryJsp";

		try {
			map = hrOrderlyRoomHandlerService.showSpecialityJsp();

		} catch (Exception e) {
			//System.out.println("Exception in  showCountryJsp " + e);
		}
		jsp = SPECIALITY_JSP;
		title = "Add Speciality";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchSpeciality(HttpServletRequest request,
			HttpServletResponse response)

	{
		Map<String, Object> map = new HashMap<String, Object>();
		String code = null;
		String name = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			name = request.getParameter(SEARCH_NAME);
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
			code = searchField;
			name = null;
		} else {
			code = null;
			name = searchField;
		}
		map = hrOrderlyRoomHandlerService.searchSpeciality(code, name);

		jsp = SPECIALITY_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("code", code);
		map.put("name", name);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editSpeciality(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String code = "";
		String name = "";
		int id = 0;
		String changedBy = "";
		int tradeId = 0;
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			id = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter(TRADE_NAME) != null
				&& !request.getParameter(TRADE_NAME).equals("")) {
			tradeId = Integer.parseInt(request.getParameter(TRADE_NAME));
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

		generalMap.put("id", id);
		generalMap.put("tradeId", tradeId);
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingSpecialityNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingSpecialityNameList.size() == 0) {
			dataUpdated = hrOrderlyRoomHandlerService
					.editSpecialityToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingSpecialityNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hrOrderly?method=showSpecialtyJsp";

		try {
			map = hrOrderlyRoomHandlerService.showSpecialityJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SPECIALITY_JSP;
		title = "Edit Speciality";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public ModelAndView deleteSpeciality(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int id = 0;
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
			id = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hrOrderlyRoomHandlerService.deleteSpeciality(id,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showCountryJsp";
		try {
			map = hrOrderlyRoomHandlerService.showSpecialityJsp();

		} catch (Exception e) {
			//System.out.println("Exception in  showSpecialityJsp " + e);
		}
		jsp = SPECIALITY_JSP;
		title = "delete Speciality";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------ Mess Master ------------ added by Yogesh on 29th
	 * september 2009
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showMessMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = hrOrderlyRoomHandlerService.showMessJsp();
		jsp = MESS_JSP;
		jsp += ".jsp";
		title = "Country";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addMess(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HrorderlyMessMaster hrorderlyMessMaster = new HrorderlyMessMaster();

		String changedBy = "";
		int unitId = 0;
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
		int hospitalId=0;
		if(request.getParameter(HOSPITAL_ID) != null && !(request.getParameter(HOSPITAL_ID).equals(""))){
			hospitalId =Integer.parseInt(request.getParameter(HOSPITAL_ID)) ;
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(UNIT_NAME) != null
				&& !request.getParameter(UNIT_NAME).equals("")) {
			unitId = Integer.parseInt(request.getParameter(UNIT_NAME));
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
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List specialityCodeList = new ArrayList();
		List specialityNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			specialityCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			specialityNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((specialityCodeList.size() == 0 || specialityCodeList == null)
				&& (specialityNameList.size() == 0 || specialityNameList == null))

		{
			hrorderlyMessMaster.setMessCode(code);
			hrorderlyMessMaster.setMessName(name);
			hrorderlyMessMaster.setStatus("y");
			hrorderlyMessMaster.setLstChangedBy(changedBy);
			hrorderlyMessMaster.setLstChangedDate(currentDate);
			hrorderlyMessMaster.setLstChangedTime(currentTime);
			if (unitId != 0) {
				MasUnit masUnit = new MasUnit();
				masUnit.setId(unitId);
				hrorderlyMessMaster.setUnitId(masUnit);

			}
			MasHospital hospital= new MasHospital();
			hospital.setId(hospitalId);
			hrorderlyMessMaster.setHospital(hospital);
			
			successfullyAdded = hrOrderlyRoomHandlerService
					.addMess(hrorderlyMessMaster);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";

			}
		} else if ((specialityCodeList.size() != 0 || specialityCodeList != null)
				|| (specialityNameList.size() != 0)
				|| specialityNameList != null) {

			if ((specialityCodeList.size() != 0 || specialityCodeList != null)
					&& (specialityNameList.size() == 0 || specialityNameList == null)) {

				message = "Mess Code  already exists.";
			} else if ((specialityNameList.size() != 0 || specialityNameList != null)
					&& (specialityCodeList.size() == 0 || specialityCodeList == null)) {

				message = "Mess Name  already exists.";
			} else if ((specialityCodeList.size() != 0 || specialityCodeList != null)
					&& (specialityNameList.size() != 0 || specialityNameList != null)) {

				message = "Mess Code already exist.";
			}
		}

		url = "/hms/hms/hrOrderly?method=showCountryJsp";

		try {
			map = hrOrderlyRoomHandlerService.showMessJsp();

		} catch (Exception e) {
			//System.out.println("Exception in  showCountryJsp " + e);
		}
		jsp = MESS_JSP;
		title = "Add Mess";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchMess(HttpServletRequest request,
			HttpServletResponse response)

	{
		Map<String, Object> map = new HashMap<String, Object>();
		String code = null;
		String name = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			name = request.getParameter(SEARCH_NAME);
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
			code = searchField;
			name = null;
		} else {
			code = null;
			name = searchField;
		}
		map = hrOrderlyRoomHandlerService.searchMess(code, name);

		jsp = MESS_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("code", code);
		map.put("name", name);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editMess(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String code = "";
		String name = "";
		int id = 0;
		String changedBy = "";
		int unitId = 0;
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			id = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter(UNIT_NAME) != null
				&& !request.getParameter(UNIT_NAME).equals("")) {
			unitId = Integer.parseInt(request.getParameter(UNIT_NAME));
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

		generalMap.put("id", id);
		generalMap.put("unitId", unitId);
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingSpecialityNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingSpecialityNameList.size() == 0) {
			dataUpdated = hrOrderlyRoomHandlerService
					.editMessToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingSpecialityNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hrOrderly?method=showMessJsp";

		try {
			map = hrOrderlyRoomHandlerService.showMessJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = MESS_JSP;
		title = "Edit Mess";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public ModelAndView deleteMess(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int id = 0;
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
			id = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hrOrderlyRoomHandlerService.deleteMess(id, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showCountryJsp";
		try {
			map = hrOrderlyRoomHandlerService.showMessJsp();

		} catch (Exception e) {
			//System.out.println("Exception in  showMessJsp " + e);
		}
		jsp = MESS_JSP;
		title = "delete Mess";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------ Leave Choice Master ------------ added by Yogesh on
	 * 29th september 2009
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showLeaveChoiceJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = hrOrderlyRoomHandlerService.showLeaveChoiceJsp();
		jsp = LEAVE_CHOICE;
		jsp += ".jsp";
		title = "Country";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addLeaveChoice(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HrorderlyLeavechoice hrorderlyleavechoice = new HrorderlyLeavechoice();
		List<HrorderlyLeavechoice> hrorderlyleavechoiceList = new ArrayList<HrorderlyLeavechoice>();
		List<MasEmployee> masemployeeList = new ArrayList<MasEmployee>();
		Map<String, Object> checkmap = new HashMap<String, Object>();

		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String serviceNo = "";
		String serviceTypecode = null;
		String leavechoice1 = null;
		String leavechoice2 = null;
		String year = null;

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (request.getParameter(SERVICE_TYPE_CODE) != null) {
			serviceTypecode = request.getParameter(SERVICE_TYPE_CODE);
		}
		if (request.getParameter(LEAVE_CHOICE_1) != null) {
			leavechoice1 = request.getParameter(LEAVE_CHOICE_1);
		}
		if (request.getParameter(LEAVE_CHOICE_2) != null) {
			leavechoice2 = request.getParameter(LEAVE_CHOICE_2);
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
		int hospitalId=0;
		if(request.getParameter(HOSPITAL_ID) != null && !(request.getParameter(HOSPITAL_ID).equals(""))){
			hospitalId =Integer.parseInt(request.getParameter(HOSPITAL_ID)) ;
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(YEAR) != null
				&& !request.getParameter(YEAR).equals("")) {
			year = request.getParameter(YEAR);
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

		boolean successfullyAdded = false;
		checkmap = hrOrderlyRoomHandlerService.CheckEmployee(serviceNo,
				serviceTypecode);
		successfullyAdded = (Boolean) checkmap.get("flag");
		//System.out.println("successfullyAdded   " + successfullyAdded);
		if (successfullyAdded) {
			masemployeeList = (List) checkmap.get("masemployeeList");
			MasEmployee masemployee = (MasEmployee) masemployeeList.get(0);
			hrorderlyleavechoice.setEmployeeId(masemployee);
			hrorderlyleavechoice.setYear(year);
			hrorderlyleavechoice.setLeaveChoice1(leavechoice1);
			hrorderlyleavechoice.setLeaveChoice2(leavechoice2);
			hrorderlyleavechoice.setStatus("y");
			hrorderlyleavechoice.setLastChgBy(changedBy);
			hrorderlyleavechoice.setLastChgDate(currentDate);
			hrorderlyleavechoice.setLastChgTime(currentTime);

			
			MasHospital hospital= new MasHospital();
			hospital.setId(hospitalId);
			hrorderlyleavechoice.setHospital(hospital);
			
			hrorderlyleavechoiceList = (List) checkmap
					.get("hrorderlyleavechoiceList");
			boolean flag = true;
			successfullyAdded = false;
			if (hrorderlyleavechoiceList != null) {
				for (HrorderlyLeavechoice leavechoice : hrorderlyleavechoiceList) {
					if (leavechoice.getYear().equals(year)) {
						flag = false;
						break;
					}
				}
			}

			if (flag) {
				successfullyAdded = hrOrderlyRoomHandlerService
						.addLeaveChoice(hrorderlyleavechoice);
			} else {
				message = "Entry for a perticular Year is already made";
			}

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				if (flag) {
					message = "Try Again !!";
				}

			}
		} else {
			message = "employee does not exist";
		}

		url = "/hms/hms/hrOrderly?method=showCountryJsp";

		try {
			map = hrOrderlyRoomHandlerService.showLeaveChoiceJsp();

		} catch (Exception e) {
			//System.out.println("Exception in  showCountryJsp " + e);
		}
		jsp = LEAVE_CHOICE;
		title = "Add LeaveChoice";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchLeaveChoice(HttpServletRequest request,
			HttpServletResponse response)

	{
		Map<String, Object> map = new HashMap<String, Object>();
		String code = null;
		String name = null;
		String searchField = null;

		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			code = request.getParameter(SERVICE_NO);
		}
		if (request.getParameter(SERVICE_TYPE_CODE) != null
				&& !(request.getParameter(SERVICE_TYPE_CODE).equals(""))) {
			name = request.getParameter(SERVICE_TYPE_CODE);
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
			code = searchField;
			name = null;
		} else {
			code = null;
			name = searchField;
		}
		map = hrOrderlyRoomHandlerService.searchLeaveChoice(code, name);

		jsp = LEAVE_CHOICE;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("code", code);
		map.put("name", name);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editLeaveChoice(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> checkmap = new HashMap<String, Object>();
		List<MasEmployee> masemployeeList = new ArrayList<MasEmployee>();
		List<HrorderlyLeavechoice> hrorderlyleavechoiceList = new ArrayList<HrorderlyLeavechoice>();

		MasEmployee masemployee = new MasEmployee();

		session = request.getSession();
		String code = "";
		String name = "";
		int id = 0;
		String changedBy = "";
		Date currentDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		String serviceNo = null;
		String serviceTypecode = null;
		String leavechoice1 = null;
		String leavechoice2 = null;
		String year = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			id = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (request.getParameter(SERVICE_TYPE_CODE) != null
				&& !(request.getParameter(SERVICE_TYPE_CODE).equals(""))) {
			serviceTypecode = request.getParameter(SERVICE_TYPE_CODE);
		}
		if (request.getParameter(LEAVE_CHOICE_1) != null
				&& !(request.getParameter(LEAVE_CHOICE_1).equals(""))) {
			leavechoice1 = request.getParameter(LEAVE_CHOICE_1);
		}
		if (request.getParameter(LEAVE_CHOICE_2) != null
				&& !(request.getParameter(LEAVE_CHOICE_2).equals(""))) {
			leavechoice2 = request.getParameter(LEAVE_CHOICE_2);
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
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter(YEAR) != null
				&& !request.getParameter(YEAR).equals("")) {
			year = request.getParameter(YEAR);
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		boolean successfullyAdded = false;
		boolean flag = false;
		checkmap = hrOrderlyRoomHandlerService.CheckEmployee(serviceNo,
				serviceTypecode);
		successfullyAdded = (Boolean) checkmap.get("flag");
		hrorderlyleavechoiceList = (List) checkmap
				.get("hrorderlyleavechoiceList");
		//System.out.println("successfullyAdded   " + successfullyAdded);
		if (successfullyAdded) {
			for (HrorderlyLeavechoice hrorderlyleavechoice : hrorderlyleavechoiceList) {
				successfullyAdded = false;
				if (hrorderlyleavechoice.getYear().equals(year)) {
					hrorderlyleavechoice.setYear(year);
					hrorderlyleavechoice.setLeaveChoice1(leavechoice1);
					hrorderlyleavechoice.setLeaveChoice2(leavechoice2);
					hrorderlyleavechoice.setLastChgBy(changedBy);
					hrorderlyleavechoice.setLastChgDate(currentDate);
					hrorderlyleavechoice.setLastChgTime(changedTime);

					successfullyAdded = hrOrderlyRoomHandlerService
							.editLeaveChoiceToDatabase(hrorderlyleavechoice);
				} else {
					message = " Entered Year entry is not present ";
					flag = true;

				}
				//System.out.println("yeat " + year + "hrorderlyleavechoice  "+ hrorderlyleavechoice.getYear());

			}
		} else {
			message = "Employee does not exist";
		}

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			if (!flag)
				message = "Try Again !!";

		}

		url = "/hms/hms/hrOrderly?method=showLeaveChoiceJsp";

		try {
			map = hrOrderlyRoomHandlerService.showLeaveChoiceJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = LEAVE_CHOICE;
		title = "Edit Leave Choice ";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public ModelAndView deleteLeaveChoice(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int id = 0;
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
			id = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hrOrderlyRoomHandlerService.deleteLeaveChoice(id,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showCountryJsp";
		try {
			map = hrOrderlyRoomHandlerService.showLeaveChoiceJsp();

		} catch (Exception e) {
			//System.out.println("Exception in  showLeaveChoiceJsp " + e);
		}
		jsp = LEAVE_CHOICE;
		title = "delete LEAVE CHOICE";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------ Leave Type Master ------------ added by Priyanka on
	 * 4th May 2009
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showLeaveTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = hrOrderlyRoomHandlerService.showLeaveTypeJsp();
		@SuppressWarnings("unused")
		ArrayList searchLeaveTypeList = (ArrayList) map
				.get("searchLeaveTypeList");
		jsp = LEAVE_TYPE_JSP;
		jsp += ".jsp";
		title = "leaveType";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addLeaveType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HrLeaveTypeMaster hrLeaveTypeMaster = new HrLeaveTypeMaster();

		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int days = 0;
		String leaveType = "";
		String details = "";
		String status = "";
		status = request.getParameter(STATUS);
		if (request.getParameter(CODE) != null) {
			leaveType = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null) {
			details = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(DAYS) != null
				&& request.getParameter(DAYS) != "") {
			days = Integer.parseInt(request.getParameter(DAYS));
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
		generalMap.put("leaveType", leaveType);
		generalMap.put("details", details);
		generalMap.put("days", days);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List leaveTypeList = new ArrayList();
		List detailsList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			leaveTypeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			detailsList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((leaveTypeList.size() == 0 || leaveTypeList == null)
				&& (detailsList.size() == 0 || detailsList == null))

		{
			hrLeaveTypeMaster.setLeaveType(leaveType);
			hrLeaveTypeMaster.setDetails(details);
			hrLeaveTypeMaster.setDays(days);
			hrLeaveTypeMaster.setStatus(status);
			hrLeaveTypeMaster.setLastChgBy(changedBy);
			hrLeaveTypeMaster.setLastChgDate(currentDate);
			hrLeaveTypeMaster.setLastChgTime(currentTime);
			successfullyAdded = hrOrderlyRoomHandlerService
					.addLeaveType(hrLeaveTypeMaster);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";

			}
		} else if ((leaveTypeList.size() != 0 || leaveTypeList != null)
				|| (detailsList.size() != 0) || detailsList != null) {

			if ((leaveTypeList.size() != 0 || leaveTypeList != null)
					&& (detailsList.size() == 0 || detailsList == null)) {

				message = "Leave Code  already exists.";
			} else if ((detailsList.size() != 0 || detailsList != null)
					&& (leaveTypeList.size() == 0 || leaveTypeList == null)) {

				message = "Leave Name  already exists.";
			} else if ((leaveTypeList.size() != 0 || leaveTypeList != null)
					&& (detailsList.size() != 0 || detailsList != null)) {

				message = "Leave Code and Leave Name already exist.";
			}
		}

		url = "/hms/hms/hrOrderly?method=showLeaveTypeJsp";

		try {
			map = hrOrderlyRoomHandlerService.showLeaveTypeJsp();

		} catch (Exception e) {
			//System.out.println("Exception in  showLeaveTypeJsp " + e);
		}
		jsp = LEAVE_TYPE_JSP;
		title = "Add Leave Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchLeaveType(HttpServletRequest request,
			HttpServletResponse response)

	{
		Map<String, Object> map = new HashMap<String, Object>();
		String leaveType = null;
		String details = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			leaveType = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			details = request.getParameter(SEARCH_NAME);
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
			leaveType = searchField;
			details = null;
		} else {
			leaveType = null;
			details = searchField;
		}
		map = hrOrderlyRoomHandlerService.searchLeaveType(leaveType, details);

		jsp = LEAVE_TYPE_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("leaveType", leaveType);
		map.put("details", details);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editLeaveType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String leaveType = "";
		String details = "";
		String status = "";
		int days = 0;
		int id = 0;
		String changedBy = "";
		status = request.getParameter(STATUS);
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			id = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			leaveType = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			details = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(DAYS) != null
				&& !(request.getParameter(DAYS).equals(""))) {
			days = Integer.parseInt(request.getParameter(DAYS));
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

		generalMap.put("id", id);
		generalMap.put("leaveType", leaveType);
		generalMap.put("details", details);
		generalMap.put("days", days);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		generalMap.put("status", status);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingCourseNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingCourseNameList.size() == 0) {
			dataUpdated = hrOrderlyRoomHandlerService
					.editLeaveTypeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingCourseNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hrOrderly?method=showLeaveTypeJsp";

		try {
			map = hrOrderlyRoomHandlerService.showLeaveTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = LEAVE_TYPE_JSP;
		title = "Edit Leave Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public ModelAndView deleteLeaveType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int id = 0;
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
			id = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hrOrderlyRoomHandlerService.deleteLeaveType(id,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hrOrderly?method=showLeaveTypeJsp";
		try {
			map = hrOrderlyRoomHandlerService.showLeaveTypeJsp();

		} catch (Exception e) {
			//System.out.println("Exception in  showLeaveTypeJsp " + e);
		}
		jsp = LEAVE_TYPE_JSP;
		title = "delete Leave Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------ Class Master ------------ added by Priyanka on 8th
	 * July 2009
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showClassJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = hrOrderlyRoomHandlerService.showClassJsp();
		jsp = CLASS_JSP;
		jsp += ".jsp";
		title = "classMaster";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addClass(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HrClassMaster hrClassMaster = new HrClassMaster();

		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int specialityId = 0;

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(SPECIALITY_NAME) != null
				&& !request.getParameter(SPECIALITY_NAME).equals("0")) {
			specialityId = Integer.parseInt(request
					.getParameter(SPECIALITY_NAME));
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
		List classCodeList = new ArrayList();
		List classNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			classCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			classNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((classCodeList.size() == 0 || classCodeList == null)
				&& (classNameList.size() == 0 || classNameList == null))

		{
			hrClassMaster.setClassCode(code);
			hrClassMaster.setClassName(name);

			HrSpecialistMaster hrSpecialistMaster = new HrSpecialistMaster();
			hrSpecialistMaster.setId(specialityId);
			hrClassMaster.setSpeciality(hrSpecialistMaster);

			hrClassMaster.setStatus("y");
			hrClassMaster.setLastChgBy(changedBy);
			hrClassMaster.setLastChgDate(currentDate);
			hrClassMaster.setLastChgTime(currentTime);
			successfullyAdded = hrOrderlyRoomHandlerService
					.addClass(hrClassMaster);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";

			}
		} else if ((classCodeList.size() != 0 || classCodeList != null)
				|| (classNameList.size() != 0) || classNameList != null) {

			if ((classCodeList.size() != 0 || classCodeList != null)
					&& (classNameList.size() == 0 || classNameList == null)) {

				message = "Class Code  already exists.";
			} else if ((classNameList.size() != 0 || classNameList != null)
					&& (classCodeList.size() == 0 || classCodeList == null)) {

				message = "Class Name  already exists.";
			} else if ((classCodeList.size() != 0 || classCodeList != null)
					&& (classNameList.size() != 0 || classNameList != null)) {

				message = "Class Code and Class Name already exist.";
			}
		}

		url = "/hms/hms/hrOrderly?method=showClassJsp";

		try {
			map = hrOrderlyRoomHandlerService.showClassJsp();

		} catch (Exception e) {
			//System.out.println("Exception in  showClassJsp " + e);
		}
		jsp = CLASS_JSP;
		title = "Add Class";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchClass(HttpServletRequest request,
			HttpServletResponse response)

	{
		Map<String, Object> map = new HashMap<String, Object>();
		String code = null;
		String name = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			name = request.getParameter(SEARCH_NAME);
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
			code = searchField;
			name = null;
		} else {
			code = null;
			name = searchField;
		}
		map = hrOrderlyRoomHandlerService.searchClass(code, name);

		jsp = CLASS_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("code", code);
		map.put("name", name);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editClass(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String code = "";
		String name = "";
		int id = 0;
		int specialityId = 0;
		String changedBy = "";

		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			id = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(SPECIALITY_NAME) != null
				&& !request.getParameter(SPECIALITY_NAME).equals("0")) {
			specialityId = Integer.parseInt(request
					.getParameter(SPECIALITY_NAME));
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

		generalMap.put("id", id);
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("specialityId", specialityId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingClassNameList = (List) listMap.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingClassNameList.size() == 0) {
			dataUpdated = hrOrderlyRoomHandlerService
					.editClassToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingClassNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hrOrderly?method=showClassJsp";

		try {
			map = hrOrderlyRoomHandlerService.showClassJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CLASS_JSP;
		title = "Edit Class";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public ModelAndView deleteClass(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int id = 0;
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
			id = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = hrOrderlyRoomHandlerService.deleteClass(id, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showClassJsp";
		try {
			map = hrOrderlyRoomHandlerService.showClassJsp();

		} catch (Exception e) {
			//System.out.println("Exception in  showClassJsp " + e);
		}
		jsp = CLASS_JSP;
		title = "delete Class";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
	// :::::::::::::::;endded by yogesh forhr master
	//:::::::::::::::::Reports for duty 
	public ModelAndView showGuardDutyReportJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "hrOrderly_guardDuty_reportJsp";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}


	public ModelAndView generateGuardReport(HttpServletRequest request,HttpServletResponse response) 
	throws Exception {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		if(request.getParameter(FROM_DATE) != null){
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if(request.getParameter(TO_DATE) != null){
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}
		detailsMap = hrOrderlyRoomHandlerService.getConnectionForReport();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		
		try {
			HMSUtil.generateReport("HrorderlyGuardDuty",parameters,(Connection)detailsMap.get("conn"),response, getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;

	}
	public ModelAndView showOfficerDutyReportJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "hrOrderly_officerDuty_reportJsp";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}


	public ModelAndView generateOfficerReport(HttpServletRequest request,HttpServletResponse response) 
	throws Exception {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		if(request.getParameter(FROM_DATE) != null){
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if(request.getParameter(TO_DATE) != null){
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}
		detailsMap = hrOrderlyRoomHandlerService.getConnectionForReport();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		
		try {
			HMSUtil.generateReport("HrorderlyOfficerDuty",parameters,(Connection)detailsMap.get("conn"),response, getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;

	}
	public ModelAndView showSGTDutyReportJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "hrOrderly_SGTDuty_reportJsp";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}


	public ModelAndView generateSGTReport(HttpServletRequest request,HttpServletResponse response) 
	throws Exception {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		if(request.getParameter(FROM_DATE) != null){
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if(request.getParameter(TO_DATE) != null){
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}
		detailsMap = hrOrderlyRoomHandlerService.getConnectionForReport();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		
		try {
			HMSUtil.generateReport("HrorderlySGTDuty",parameters,(Connection)detailsMap.get("conn"),response, getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;

	}
	public ModelAndView showRangeFiringDutyReportJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "hrOrderly_Rangefiring_Duty";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}


	public ModelAndView generateRangeFiringReport(HttpServletRequest request,HttpServletResponse response) 
	throws Exception {
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String year = "";
		String quarter = "";
		String flag = "";
		if(request.getParameter("quarter") != null) {
			quarter = request.getParameter("quarter");
		}
		if(request.getParameter("year") != null){
			year = request.getParameter("year");
		}
		//System.out.println("quarter::"+quarter+"::year::"+year);
		detailsMap = hrOrderlyRoomHandlerService.getConnectionForReport();
		parameters.put("qaurter", quarter);
		parameters.put("year", year);
		
		try {
			HMSUtil.generateReport("HrorderlyRangeFiringDuty",parameters,(Connection)detailsMap.get("conn"),response, getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;

	}
	public ModelAndView showNominalRollReportForOfficer(HttpServletRequest request , HttpServletResponse reponse){
		Map<String,Object> map = new HashMap<String,Object>();
		//map=hrOrderlyRoomHandlerService.showNominalRollReportForOfficer();
		jsp="nominalRollJspForOfficer.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
		
	}
	
}
