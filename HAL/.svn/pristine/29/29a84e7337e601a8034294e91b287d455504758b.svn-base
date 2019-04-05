package jkt.hms.masters.controller;

import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CLASS_JSP;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.DAYS;
import static jkt.hms.util.RequestConstants.DUTY_JSP;
import static jkt.hms.util.RequestConstants.DUTY_NAME;
import static jkt.hms.util.RequestConstants.DUTY_TIME_JSP;
import static jkt.hms.util.RequestConstants.ESTABLISHMENT_JSP;
import static jkt.hms.util.RequestConstants.FROM_TIME;
import static jkt.hms.util.RequestConstants.LEAVE_TYPE_JSP;
import static jkt.hms.util.RequestConstants.MEDICAL_COURSE_JSP;
import static jkt.hms.util.RequestConstants.RANK_NAME;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.SPECIALITY_JSP;
import static jkt.hms.util.RequestConstants.SPECIALITY_NAME;
import static jkt.hms.util.RequestConstants.STRENGTH;
import static jkt.hms.util.RequestConstants.TO_TIME;
import static jkt.hms.util.RequestConstants.TYPE_OF_COURSE;
import static jkt.hms.util.RequestConstants.UNIT_NAME;
import static jkt.hms.util.RequestConstants.VALID_ON;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.HrClassMaster;
import jkt.hms.masters.business.HrDutyMaster;
import jkt.hms.masters.business.HrDutyTimeMaster;
import jkt.hms.masters.business.HrEstablishmentMaster;
import jkt.hms.masters.business.HrLeaveTypeMaster;
import jkt.hms.masters.business.HrMedicalCourseMaster;
import jkt.hms.masters.business.HrSpecialistMaster;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.masters.handler.HrRelatedMasterHandlerService;
import jkt.hms.util.HMSUtil;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class HrRelatedMasterController extends MultiActionController {

	HrRelatedMasterHandlerService hrRelatedMasterHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;

	public HrRelatedMasterHandlerService getHrRelatedMasterHandlerService() {
		return hrRelatedMasterHandlerService;
	}

	public void setHrRelatedMasterHandlerService(
			HrRelatedMasterHandlerService hrRelatedMasterHandlerService) {
		this.hrRelatedMasterHandlerService = hrRelatedMasterHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	// ---begin Code---
	/**
	 * ------- common variables declaration------
	 */
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
	String status = "";
	int id = 0;
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	HttpSession session = null;
	String userName = "";

	/**
	 * ------------------ Speciality Master ------------ added by Priyanka on
	 * 29th April 2009
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showSpecialityJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = hrRelatedMasterHandlerService.showSpecialityJsp();
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
			hrSpecialistMaster.setLastChgBy(changedBy);
			hrSpecialistMaster.setLastChgDate(currentDate);
			hrSpecialistMaster.setLastChgTime(currentTime);
			successfullyAdded = hrRelatedMasterHandlerService
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

		url = "/hms/hms/hrRelatedMaster?method=showCountryJsp";

		try {
			map = hrRelatedMasterHandlerService.showSpecialityJsp();

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
			HttpServletResponse response) throws ServletRequestBindingException {
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
		map = hrRelatedMasterHandlerService.searchSpeciality(code, name);

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
			dataUpdated = hrRelatedMasterHandlerService
					.editSpecialityToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingSpecialityNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hrRelatedMaster?method=showSpecialtyJsp";

		try {
			map = hrRelatedMasterHandlerService.showSpecialityJsp();

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
		dataDeleted = hrRelatedMasterHandlerService.deleteSpeciality(id,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showCountryJsp";
		try {
			map = hrRelatedMasterHandlerService.showSpecialityJsp();

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
	 * ------------------ Medical Course Master ------------ added by Priyanka
	 * on 30th April 2009
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showMedicalCourseJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = hrRelatedMasterHandlerService.showMedicalCourseJsp();
		@SuppressWarnings("unused")
		ArrayList searchMedicalCourseList = (ArrayList) map
				.get("searchMedicalCourseList");
		jsp = MEDICAL_COURSE_JSP;
		jsp += ".jsp";
		title = "Course";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addMedicalCourse(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HrMedicalCourseMaster hrMedicalCourseMaster = new HrMedicalCourseMaster();

		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String typeOfCourse = "";

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(TYPE_OF_COURSE) != null) {
			typeOfCourse = request.getParameter(TYPE_OF_COURSE);
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
		generalMap.put("typeOfCourse", typeOfCourse);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List courseCodeList = new ArrayList();
		List courseNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			courseCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			courseNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((courseCodeList.size() == 0 || courseCodeList == null)
				&& (courseNameList.size() == 0 || courseNameList == null))

		{
			hrMedicalCourseMaster.setCourseCode(code);
			hrMedicalCourseMaster.setCourseName(name);
			hrMedicalCourseMaster.setCourseType(typeOfCourse);
			hrMedicalCourseMaster.setStatus("y");
			hrMedicalCourseMaster.setLastChgBy(changedBy);
			hrMedicalCourseMaster.setLastChgDate(currentDate);
			hrMedicalCourseMaster.setLastChgTime(currentTime);
			successfullyAdded = hrRelatedMasterHandlerService
					.addMedicalCourse(hrMedicalCourseMaster);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";

			}
		} else if ((courseCodeList.size() != 0 || courseCodeList != null)
				|| (courseNameList.size() != 0) || courseNameList != null) {

			if ((courseCodeList.size() != 0 || courseCodeList != null)
					&& (courseNameList.size() == 0 || courseNameList == null)) {

				message = "course Code  already exists.";
			} else if ((courseNameList.size() != 0 || courseNameList != null)
					&& (courseCodeList.size() == 0 || courseCodeList == null)) {

				message = "course Name  already exists.";
			} else if ((courseCodeList.size() != 0 || courseCodeList != null)
					&& (courseNameList.size() != 0 || courseNameList != null)) {

				message = "course Code and course Name already exist.";
			}
		}

		url = "/hms/hms/hrRelatedMaster?method=showMedicalCourseJsp";

		try {
			map = hrRelatedMasterHandlerService.showMedicalCourseJsp();

		} catch (Exception e) {
			//System.out.println("Exception in  showMedicalCourseJsp " + e);
		}
		jsp = MEDICAL_COURSE_JSP;
		title = "Add Medical Course";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchMedicalCourse(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
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
		map = hrRelatedMasterHandlerService.searchMedicalCourse(code, name);

		jsp = MEDICAL_COURSE_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("code", code);
		map.put("name", name);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editMedicalCourse(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String code = "";
		String name = "";
		String typeOfCourse = "";
		int id = 0;
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
		if (request.getParameter(TYPE_OF_COURSE) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			typeOfCourse = request.getParameter(TYPE_OF_COURSE);
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
		generalMap.put("typeOfCourse", typeOfCourse);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingCourseNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingCourseNameList.size() == 0) {
			dataUpdated = hrRelatedMasterHandlerService
					.editMedicalCourseToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingCourseNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hrRelatedMaster?method=showMedicalCourseJsp";

		try {
			map = hrRelatedMasterHandlerService.showMedicalCourseJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = MEDICAL_COURSE_JSP;
		title = "Edit Speciality";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public ModelAndView deleteMedicalCourse(HttpServletRequest request,
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
		dataDeleted = hrRelatedMasterHandlerService.deleteMedicalCourse(id,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showMedicalCourseJsp";
		try {
			map = hrRelatedMasterHandlerService.showMedicalCourseJsp();

		} catch (Exception e) {
			//System.out.println("Exception in  showMedicalCourseJsp " + e);
		}
		jsp = MEDICAL_COURSE_JSP;
		title = "delete Medical Course";
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
		map = hrRelatedMasterHandlerService.showLeaveTypeJsp();
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

		if (request.getParameter(CODE) != null) {
			leaveType = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			details = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(DAYS) != null) {
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
			hrLeaveTypeMaster.setStatus("y");
			hrLeaveTypeMaster.setLastChgBy(changedBy);
			hrLeaveTypeMaster.setLastChgDate(currentDate);
			hrLeaveTypeMaster.setLastChgTime(currentTime);
			successfullyAdded = hrRelatedMasterHandlerService
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

				message = "course Code  already exists.";
			} else if ((detailsList.size() != 0 || detailsList != null)
					&& (leaveTypeList.size() == 0 || leaveTypeList == null)) {

				message = "course Name  already exists.";
			} else if ((leaveTypeList.size() != 0 || leaveTypeList != null)
					&& (detailsList.size() != 0 || detailsList != null)) {

				message = "course Code and course Name already exist.";
			}
		}

		url = "/hms/hms/hrRelatedMaster?method=showLeaveTypeJsp";

		try {
			map = hrRelatedMasterHandlerService.showLeaveTypeJsp();

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
			HttpServletResponse response) throws ServletRequestBindingException {
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
		map = hrRelatedMasterHandlerService.searchLeaveType(leaveType, details);

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
		int days = 0;
		int id = 0;
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
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingCourseNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingCourseNameList.size() == 0) {
			dataUpdated = hrRelatedMasterHandlerService
					.editLeaveTypeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingCourseNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hrRelatedMaster?method=showLeaveTypeJsp";

		try {
			map = hrRelatedMasterHandlerService.showLeaveTypeJsp();

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
		dataDeleted = hrRelatedMasterHandlerService.deleteLeaveType(id,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hrRelatedMaster?method=showLeaveTypeJsp";
		try {
			map = hrRelatedMasterHandlerService.showLeaveTypeJsp();

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
	 * ------------------ Duty Time Master ------------ added by Priyanka on 4th
	 * May 2009
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showDutyTimeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = hrRelatedMasterHandlerService.showDutyTimeJsp();
		@SuppressWarnings("unused")
		ArrayList searchDutyTimeList = (ArrayList) map
				.get("searchDutyTimeList");
		jsp = DUTY_TIME_JSP;
		jsp += ".jsp";
		title = "dutyTime";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addDutyTime(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HrDutyTimeMaster hrDutyTimeMaster = new HrDutyTimeMaster();

		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String code = "";
		String fromTime = "";
		String toTime = "";
		String validOn = "";
		String shiftType = "";
		int dutyId = 0;

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(FROM_TIME) != null) {
			fromTime = request.getParameter(FROM_TIME);
		}
		if (request.getParameter(TO_TIME) != null) {
			toTime = request.getParameter(TO_TIME);
		}
		if (request.getParameter(VALID_ON) != null) {
			validOn = request.getParameter(VALID_ON);
		}
		if (request.getParameter(DUTY_NAME) != null
				&& !request.getParameter(DUTY_NAME).equals("0")) {
			dutyId = Integer.parseInt(request.getParameter(DUTY_NAME));
		}
		if (request.getParameter("shift_type") != null) {
			shiftType = request.getParameter("shift_type");
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
		generalMap.put("fromTime", fromTime);
		generalMap.put("toTime", toTime);
		generalMap.put("validOn", validOn);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("shiftType", shiftType);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List leaveTypeList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			leaveTypeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		boolean successfullyAdded = false;
		if (leaveTypeList.size() == 0 || leaveTypeList == null)

		{
			hrDutyTimeMaster.setDutyCode(code);
			hrDutyTimeMaster.setDutyFromTime(fromTime);
			hrDutyTimeMaster.setDutyToTime(toTime);
			hrDutyTimeMaster.setValidOn(validOn);
			hrDutyTimeMaster.setDutyShiftType(shiftType);
			hrDutyTimeMaster.setStatus("y");

			HrDutyMaster hrDutyMaster = new HrDutyMaster();
			hrDutyMaster.setId(dutyId);
			hrDutyTimeMaster.setDuty(hrDutyMaster);

			hrDutyTimeMaster.setLastChgBy(changedBy);
			hrDutyTimeMaster.setLastChgDate(currentDate);
			hrDutyTimeMaster.setLastChgTime(currentTime);
			successfullyAdded = hrRelatedMasterHandlerService
					.addDutyTime(hrDutyTimeMaster);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";

			}
		} else if (leaveTypeList.size() != 0 || leaveTypeList != null) {

			message = "course Code  already exists.";
		}

		url = "/hms/hms/hrRelatedMaster?method=showDutyTimeJsp";

		try {
			map = hrRelatedMasterHandlerService.showDutyTimeJsp();

		} catch (Exception e) {
			//System.out.println("Exception in  showDutyTimeJsp " + e);
		}
		jsp = DUTY_TIME_JSP;
		title = "Add Duty Time";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchDutyTime(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String code = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			code = request.getParameter(CODE);
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
		}
		map = hrRelatedMasterHandlerService.searchDutyTime(code);

		jsp = DUTY_TIME_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("code", code);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editDutyTime(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String code = "";
		String fromTime = "";
		String toTime = "";
		String validOn = "";
		String shiftType = "";
		int id = 0;
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
		if (request.getParameter(FROM_TIME) != null
				&& !(request.getParameter(FROM_TIME).equals(""))) {
			fromTime = request.getParameter(FROM_TIME);
		}
		if (request.getParameter(TO_TIME) != null
				&& !(request.getParameter(TO_TIME).equals(""))) {
			toTime = request.getParameter(TO_TIME);
		}
		if (request.getParameter(VALID_ON) != null
				&& !(request.getParameter(VALID_ON).equals(""))) {
			validOn = request.getParameter(VALID_ON);
		}
		if (request.getParameter("shift_type") != null
				&& !(request.getParameter("shift_type").equals(""))) {
			shiftType = request.getParameter("shift_type");
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
		generalMap.put("fromTime", fromTime);
		generalMap.put("toTime", toTime);
		generalMap.put("validOn", validOn);
		generalMap.put("shiftType", shiftType);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingDutyNameList = (List) listMap.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingDutyNameList.size() == 0) {
			dataUpdated = hrRelatedMasterHandlerService
					.editDutyTimeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingDutyNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hrRelatedMaster?method=showDutyTimeJsp";

		try {
			map = hrRelatedMasterHandlerService.showDutyTimeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DUTY_TIME_JSP;
		title = "Edit Duty Time";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public ModelAndView deleteDutyTime(HttpServletRequest request,
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
		dataDeleted = hrRelatedMasterHandlerService.deleteDutyTime(id,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hrRelatedMaster?method=showDutyTimeJsp";
		try {
			map = hrRelatedMasterHandlerService.showDutyTimeJsp();

		} catch (Exception e) {
			//System.out.println("Exception in  showDutyTimeJsp " + e);
		}
		jsp = DUTY_TIME_JSP;
		title = "delete Duty Time";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------ Establishment Master ------------ added by Priyanka on
	 * 5th May 2009
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showEstablishmentJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = hrRelatedMasterHandlerService.showEstablishmentJsp();
		@SuppressWarnings("unused")
		ArrayList searchEstablishmentList = (ArrayList) map
				.get("searchEstablishmentList");
		jsp = ESTABLISHMENT_JSP;
		jsp += ".jsp";
		title = "establishment";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addEstablishment(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HrEstablishmentMaster hrEstablishmentMaster = new HrEstablishmentMaster();

		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int unitId = 0;
		int specialityId = 0;
		int rankId = 0;
		int strength = 0;
		int manningLevel = 0;

		if (request.getParameter(UNIT_NAME) != null
				&& !request.getParameter(UNIT_NAME).equals("0")) {
			unitId = Integer.parseInt(request.getParameter(UNIT_NAME));
		}
		if (request.getParameter(SPECIALITY_NAME) != null
				&& !request.getParameter(SPECIALITY_NAME).equals("0")) {
			specialityId = Integer.parseInt(request
					.getParameter(SPECIALITY_NAME));
		}
		if (request.getParameter(RANK_NAME) != null
				&& !request.getParameter(RANK_NAME).equals("0")) {
			rankId = Integer.parseInt(request.getParameter(RANK_NAME));
		}
		if (request.getParameter(STRENGTH) != null) {
			strength = Integer.parseInt(request.getParameter(STRENGTH));
		}
		if (request.getParameter("manningLevel") != null) {
			manningLevel = Integer.parseInt(request
					.getParameter("manningLevel"));
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
		generalMap.put("unitId", unitId);
		generalMap.put("specialityId", specialityId);
		generalMap.put("rankId", rankId);
		generalMap.put("strength", strength);
		generalMap.put("manningLevel", manningLevel);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		/*
		 * listMap =
		 * commonMasterHandlerService.checkForExistingMasters(generalMap); List
		 * leaveTypeList = new ArrayList();
		 * 
		 * if(listMap.get("duplicateGeneralCodeList") != null){ leaveTypeList =
		 * (List)listMap.get("duplicateGeneralCodeList"); }
		 */
		boolean successfullyAdded = false;
		/*
		 * if(leaveTypeList.size() == 0 || leaveTypeList == null)
		 * 
		 * {
		 */
		MasUnit masUnit = new MasUnit();
		masUnit.setId(unitId);
		hrEstablishmentMaster.setUnit(masUnit);

		HrSpecialistMaster hrSpecialistMaster = new HrSpecialistMaster();
		hrSpecialistMaster.setId(specialityId);
		hrEstablishmentMaster.setSpeciality(hrSpecialistMaster);

		MasRank masRank = new MasRank();
		masRank.setId(rankId);
		hrEstablishmentMaster.setRank(masRank);

		hrEstablishmentMaster.setStrength(strength);
		hrEstablishmentMaster.setManningLevel(manningLevel);
		hrEstablishmentMaster.setStatus("y");
		hrEstablishmentMaster.setLastChgBy(changedBy);
		hrEstablishmentMaster.setLastChgDate(currentDate);
		hrEstablishmentMaster.setLastChgTime(currentTime);
		successfullyAdded = hrRelatedMasterHandlerService
				.addEstablishment(hrEstablishmentMaster);

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";

		}
		/*
		 * } else if(leaveTypeList.size() != 0 || leaveTypeList != null) {
		 * 
		 * message = "course Code  already exists."; }
		 */

		url = "/hms/hms/hrRelatedMaster?method=showEstablishmentJsp";

		try {
			map = hrRelatedMasterHandlerService.showEstablishmentJsp();

		} catch (Exception e) {
			//System.out.println("Exception in  showEstablishmentJsp " + e);
		}
		jsp = ESTABLISHMENT_JSP;
		title = "Add Establishment Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchEstablishment(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String unitName = "";
		String specialityName = "";
		String searchField = null;
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
			unitName = searchField;
		} else if (searchRadio == 2) {
			specialityName = searchField;
		}
		map = hrRelatedMasterHandlerService.searchEstablishment(unitName,
				specialityName);

		jsp = ESTABLISHMENT_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("code", code);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editEstablishment(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();

		int id = 0;
		String changedBy = "";

		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		int unitId = 0;
		int specialityId = 0;
		int rankId = 0;
		int strength = 0;

		if (request.getParameter(UNIT_NAME) != null
				&& !request.getParameter(UNIT_NAME).equals("0")) {
			unitId = Integer.parseInt(request.getParameter(UNIT_NAME));
		}
		if (request.getParameter(SPECIALITY_NAME) != null
				&& !request.getParameter(SPECIALITY_NAME).equals("0")) {
			specialityId = Integer.parseInt(request
					.getParameter(SPECIALITY_NAME));
		}
		if (request.getParameter(RANK_NAME) != null
				&& !request.getParameter(RANK_NAME).equals("0")) {
			rankId = Integer.parseInt(request.getParameter(RANK_NAME));
		}
		if (request.getParameter(STRENGTH) != null) {
			strength = Integer.parseInt(request.getParameter(STRENGTH));
		}

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			id = Integer.parseInt(request.getParameter(COMMON_ID));
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
		generalMap.put("unitId", unitId);
		generalMap.put("specialityId", specialityId);
		generalMap.put("rankId", rankId);
		generalMap.put("strength", strength);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		boolean dataUpdated = false;
		/*
		 * listMap =
		 * commonMasterHandlerService.checkForExistingMasters(generalMap); List
		 * existingDutyNameList = (List)listMap.get("duplicateMastersList");
		 * boolean dataUpdated=false; if(existingDutyNameList.size() == 0) {
		 */
		dataUpdated = hrRelatedMasterHandlerService
				.editEstablishmentToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant Be Updated !!";
		}
		/*
		 * } else if(existingDutyNameList.size() > 0){ message =
		 * "Name already exists."; }
		 */
		url = "/hms/hms/hrRelatedMaster?method=showEstablishmentJsp";

		try {
			map = hrRelatedMasterHandlerService.showEstablishmentJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ESTABLISHMENT_JSP;
		title = "Edit Establishment Mater";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public ModelAndView deleteEstablishment(HttpServletRequest request,
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
		dataDeleted = hrRelatedMasterHandlerService.deleteEstablishment(id,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/hrRelatedMaster?method=showEstablishmentJsp";
		try {
			map = hrRelatedMasterHandlerService.showEstablishmentJsp();

		} catch (Exception e) {
			//System.out.println("Exception in  showEstablishmentJsp " + e);
		}
		jsp = ESTABLISHMENT_JSP;
		title = "delete Establishment Master";
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
		map = hrRelatedMasterHandlerService.showClassJsp();
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
			successfullyAdded = hrRelatedMasterHandlerService
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

		url = "/hms/hms/hrRelatedMaster?method=showClassJsp";

		try {
			map = hrRelatedMasterHandlerService.showClassJsp();

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
			HttpServletResponse response) throws ServletRequestBindingException {
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
		map = hrRelatedMasterHandlerService.searchClass(code, name);

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
			dataUpdated = hrRelatedMasterHandlerService
					.editClassToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingClassNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hrRelatedMaster?method=showClassJsp";

		try {
			map = hrRelatedMasterHandlerService.showClassJsp();

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
		dataDeleted = hrRelatedMasterHandlerService.deleteClass(id, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showClassJsp";
		try {
			map = hrRelatedMasterHandlerService.showClassJsp();

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

	/**
	 * ------------------ Duty Master ------------ added by Priyanka on 9th July
	 * 2009
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showDutyJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = hrRelatedMasterHandlerService.showDutyJsp();
		jsp = DUTY_JSP;
		jsp += ".jsp";
		title = "Country";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addDuty(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HrDutyMaster hrDutyMaster = new HrDutyMaster();

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
		List dutyCodeList = new ArrayList();
		List dutyNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			dutyCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			dutyNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((dutyCodeList.size() == 0 || dutyCodeList == null)
				&& (dutyNameList.size() == 0 || dutyNameList == null))

		{
			hrDutyMaster.setDutyCode(code);
			hrDutyMaster.setDutyName(name);
			hrDutyMaster.setStatus("y");
			hrDutyMaster.setLastChgBy(changedBy);
			hrDutyMaster.setLastChgDate(currentDate);
			hrDutyMaster.setLastChgTime(currentTime);
			successfullyAdded = hrRelatedMasterHandlerService
					.addDuty(hrDutyMaster);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";

			}
		} else if ((dutyCodeList.size() != 0 || dutyCodeList != null)
				|| (dutyNameList.size() != 0) || dutyNameList != null) {

			if ((dutyCodeList.size() != 0 || dutyCodeList != null)
					&& (dutyNameList.size() == 0 || dutyNameList == null)) {

				message = "Duty Code  already exists.";
			} else if ((dutyNameList.size() != 0 || dutyNameList != null)
					&& (dutyCodeList.size() == 0 || dutyCodeList == null)) {

				message = "Duty Name  already exists.";
			} else if ((dutyCodeList.size() != 0 || dutyCodeList != null)
					&& (dutyNameList.size() != 0 || dutyNameList != null)) {

				message = "Duty Code and Country Name already exist.";
			}
		}

		url = "/hms/hms/hrRelatedMaster?method=showCountryJsp";

		try {
			map = hrRelatedMasterHandlerService.showDutyJsp();

		} catch (Exception e) {
			//System.out.println("Exception in  showCountryJsp " + e);
		}
		jsp = DUTY_JSP;
		title = "Add Duty";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchDuty(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
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
		map = hrRelatedMasterHandlerService.searchDuty(code, name);

		jsp = DUTY_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("code", code);
		map.put("name", name);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editDuty(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String code = "";
		String name = "";
		int id = 0;
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
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingDutyNameList = (List) listMap.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingDutyNameList.size() == 0) {
			dataUpdated = hrRelatedMasterHandlerService
					.editDutyToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingDutyNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/hrRelatedMaster?method=showSpecialtyJsp";

		try {
			map = hrRelatedMasterHandlerService.showDutyJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DUTY_JSP;
		title = "Edit Duty";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public ModelAndView deleteDuty(HttpServletRequest request,
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
		dataDeleted = hrRelatedMasterHandlerService.deleteDuty(id, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showCountryJsp";
		try {
			map = hrRelatedMasterHandlerService.showDutyJsp();

		} catch (Exception e) {
			//System.out.println("Exception in  showDutyJsp " + e);
		}
		jsp = DUTY_JSP;
		title = "delete Duty";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

}