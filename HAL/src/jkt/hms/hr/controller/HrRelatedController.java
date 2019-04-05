package jkt.hms.hr.controller;

import static jkt.hms.util.RequestConstants.DAILY_ROUTINE_ADDITION_JSP;
import static jkt.hms.util.RequestConstants.DAILY_ROUTINE_ENTRY_JSP;
import static jkt.hms.util.RequestConstants.DATE_OF_REPORTING;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DUTY_DISPLAY_FORM_JSP;
import static jkt.hms.util.RequestConstants.DUTY_EXEMPTION_ENTRY_JSP;
import static jkt.hms.util.RequestConstants.DUTY_EXEMPTION_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.FIRST_NAME;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.GUARD_DUTY_ADDITION_JSP;
import static jkt.hms.util.RequestConstants.GUARD_DUTY_ENTRY_JSP;
import static jkt.hms.util.RequestConstants.HR_DUTY_PERFORMED;
import static jkt.hms.util.RequestConstants.LAST_NAME;
import static jkt.hms.util.RequestConstants.LEAVE_FROM_DATE;
import static jkt.hms.util.RequestConstants.LEAVE_MAINTENANCE_ENTRY_JSP;
import static jkt.hms.util.RequestConstants.LEAVE_MAINTENANCE_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.LEAVE_PENDING_ENTRY_JSP;
import static jkt.hms.util.RequestConstants.LEAVE_PENDING_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.NIGHT_DUTY_ADDITION_JSP;
import static jkt.hms.util.RequestConstants.NIGHT_DUTY_ENTRY_JSP;
import static jkt.hms.util.RequestConstants.ORDERLY_DUTY_ADDITION_JSP;
import static jkt.hms.util.RequestConstants.ORDERLY_DUTY_ENTRY_JSP;
import static jkt.hms.util.RequestConstants.RANGE_FIRING_DUTY_ADDITION_JSP;
import static jkt.hms.util.RequestConstants.RANGE_FIRING_DUTY_ENTRY_JSP;
import static jkt.hms.util.RequestConstants.RANK_ID;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.UNIT_ID;
import static jkt.hms.util.RequestConstants.UPDATE_ARRIVAL_ENTRY_JSP;
import static jkt.hms.util.RequestConstants.UPDATE_ARRIVAL_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.WARD_DUTY_ADDITION_JSP;
import static jkt.hms.util.RequestConstants.WARD_DUTY_ENTRY_JSP;

import java.math.BigDecimal;
import java.sql.Connection;
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

import jkt.hms.hr.handler.HrRelatedHandlerService;
import jkt.hms.masters.business.HrLeaveMaintenance;
import jkt.hms.masters.business.HrLeaveTypeMaster;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class HrRelatedController extends MultiActionController {

	HrRelatedHandlerService hrRelatedHandlerService = null;

	public HrRelatedHandlerService getHrRelatedHandlerService() {
		return hrRelatedHandlerService;
	}

	public void setHrRelatedHandlerService(
			HrRelatedHandlerService hrRelatedHandlerService) {
		this.hrRelatedHandlerService = hrRelatedHandlerService;
	}

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
	// Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	HttpSession session = null;
	String userName = "";

	/**
	 * ------------------ Leave Maintenance Entry ------------ added by Priyanka
	 * on 7th May 2009
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showLeaveMaintenanceSearchJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = hrRelatedHandlerService.showLeaveMaintenanceSearchJsp();
		jsp = LEAVE_MAINTENANCE_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView searchEmployeeForLeaveMaintenance(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		// Map<String, Object> enquiryMap = new HashMap<String, Object>();
		Map<String, Object> employeeMap = new HashMap<String, Object>();

		String serviceNo = "";
		int rankId = 0;
		String firstName = "";
		String lastName = "";
		@SuppressWarnings("unused")
		Box box = HMSUtil.getBox(request);
		try {
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				employeeMap.put("serviceNo", serviceNo);
			}
			if (!(request.getParameter(RANK_ID).equals("0"))) {
				rankId = Integer.parseInt(request.getParameter(RANK_ID));
				employeeMap.put("rankId", rankId);
			}
			if (request.getParameter(FIRST_NAME) != null
					&& !(request.getParameter(FIRST_NAME).equals(""))) {
				firstName = request.getParameter(FIRST_NAME);
				employeeMap.put("firstName", firstName);
			}
			if (request.getParameter(LAST_NAME) != null
					&& !(request.getParameter(LAST_NAME).equals(""))) {
				lastName = request.getParameter(LAST_NAME);
				employeeMap.put("lastName", lastName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		employeeMap = hrRelatedHandlerService
				.searchEmployeeForLeaveMaintenance(employeeMap);
		// map = enquiryHandlerService.getDetailsForEnquiry();

		String jsp = LEAVE_MAINTENANCE_SEARCH_JSP;
		jsp += ".jsp";
		map.put("employeeMap", employeeMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showLeaveMaintenanceEntryJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int empId = 0;
		String empName = "";
		if (request.getParameter("empId") != null
				&& !request.getParameter("empId").equals("")) {
			empId = Integer.parseInt(request.getParameter("empId"));
		}
		map = hrRelatedHandlerService.showLeaveMaintenanceEntryJsp(empId);
		jsp = LEAVE_MAINTENANCE_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView submitLeaveMaintenanceEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int empId = 0;
		String empName = "";
		HrLeaveMaintenance hrLeaveMaintenance = new HrLeaveMaintenance();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		if (request.getParameter("empId") != null
				&& !request.getParameter("empId").equals("")) {
			empId = Integer.parseInt(request.getParameter("empId"));
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(empId);
			hrLeaveMaintenance.setEmployee(masEmployee);
		}
		if (hospitalId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrLeaveMaintenance.setHospital(masHospital);
		}

		if (request.getParameter("leaveType") != null
				&& !request.getParameter("leaveType").equals("0")) {
			HrLeaveTypeMaster hrLeaveTypeMaster = new HrLeaveTypeMaster();
			hrLeaveTypeMaster.setId(Integer.parseInt(request
					.getParameter("leaveType")));
			hrLeaveMaintenance.setLeaveType(hrLeaveTypeMaster);
		}

		if (request.getParameter(LEAVE_FROM_DATE) != null
				&& !request.getParameter(LEAVE_FROM_DATE).equals("")) {
			hrLeaveMaintenance.setLeaveFrom(HMSUtil
					.convertStringTypeDateToDateType((request
							.getParameter(LEAVE_FROM_DATE))));
		}

		if (request.getParameter(DATE_OF_REPORTING) != null
				&& !request.getParameter(DATE_OF_REPORTING).equals("")) {
			hrLeaveMaintenance.setDateOfReporting(HMSUtil
					.convertStringTypeDateToDateType((request
							.getParameter(DATE_OF_REPORTING))));
		}

		hrLeaveMaintenance.setApprovedStatus("n");

		hrLeaveMaintenance.setRecommendedStatus("n");

		hrLeaveMaintenance.setApplicationDate(HMSUtil
				.convertStringTypeDateToDateType((request
						.getParameter("changedDate"))));

		if (request.getParameter("changedBy") != null
				&& !request.getParameter("changedBy").equals("")) {
			hrLeaveMaintenance.setLastChgBy(request.getParameter("changedBy"));
		}

		if (request.getParameter("changedDate") != null
				&& !request.getParameter("changedDate").equals("")) {
			hrLeaveMaintenance.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType((request
							.getParameter("changedDate"))));
		}

		if (request.getParameter("changedTime") != null
				&& !request.getParameter("changedTime").equals("")) {
			hrLeaveMaintenance.setLastChgTime(request
					.getParameter("changedTime"));
		}

		if (request.getParameter("totalLeave") != null
				&& !request.getParameter("totalLeave").equals("")) {
			hrLeaveMaintenance.setTotalLeave(new BigDecimal(request
					.getParameter("totalLeave")));
		}
		boolean successfullyAdded = false;
		successfullyAdded = hrRelatedHandlerService
				.submitLeaveMaintenanceEntry(hrLeaveMaintenance);

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";

		}
		map.put("message", message);
		jsp = LEAVE_MAINTENANCE_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	/**
	 * ------------------------------------- NIGHT DUTY ENTRY
	 * ------------------------------- started on 15th May 09 By Priyanka Garg
	 */

	public ModelAndView showNightDutyEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = hrRelatedHandlerService.showNightDutyEntryJsp();
		jsp = NIGHT_DUTY_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView showNightDutyAddJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		box.put("numOfRows", "10");
		map = hrRelatedHandlerService.getGridDataForEmployeeAdd(box);

		map.put("box", box);
		jsp = NIGHT_DUTY_ADDITION_JSP;
		title = "Night Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getGridDataForEmployeeAdd(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		box.put("numOfRows", "10");
		session = request.getSession();
		map = hrRelatedHandlerService.getGridDataForEmployeeAdd(box);
		jsp = NIGHT_DUTY_ADDITION_JSP;
		title = "Night Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView showNightDutyRecords(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		box.put("numOfRows", "10");
		map = hrRelatedHandlerService.getEmployeeDetailsForNightDuty(box);
		jsp = NIGHT_DUTY_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView getGridDataForEmployee(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = hrRelatedHandlerService.getGridDataForEmployee(box);
		jsp = NIGHT_DUTY_ENTRY_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView AddNightDutyEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		box.put("hospitalId", hospitalId);
		successfullyAdded = hrRelatedHandlerService.AddNightDutyEntry(box);

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
			map = hrRelatedHandlerService.getGridDataForEmployeeAdd(box);
		} else {
			message = "Try Again !!";

		}
		map.put("message", message);
		jsp = NIGHT_DUTY_ADDITION_JSP;
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getEmployeeLastDutyDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		map = hrRelatedHandlerService.getEmployeeLastDutyDetails(box);
		jsp = "hr_responseForNightAddition";
		title = "Night Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView updateNightDutyEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		successfullyAdded = hrRelatedHandlerService.updateNightDutyEntry(box);

		if (successfullyAdded) {
			message = "Record updated Successfully !!";
			map = hrRelatedHandlerService.getEmployeeDetailsForNightDuty(box);
		} else {
			message = "Try Again !!";

		}
		map.put("message", message);
		jsp = NIGHT_DUTY_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchNightDutyData(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = hrRelatedHandlerService.searchNightDutyData(box);
		jsp = NIGHT_DUTY_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	/**
	 * ------------------------------------- GUARD DUTY ENTRY
	 * ------------------------------- started on 27th May 09 By Priyanka Garg
	 */
	public ModelAndView showGuardDutyUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = HR_DUTY_PERFORMED;
		jsp = jsp + ".jsp";
		title = "Actual Duty Performed";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView showDutyPerformed(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = hrRelatedHandlerService.showDutyPerformed();
		jsp = HR_DUTY_PERFORMED;
		jsp = jsp + ".jsp";
		title = "Actual Duty Performed";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView searchDutyPerformed(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infomap = new HashMap<String, Object>();
		Date dutydate = null;
		String searchdutydate = "";
		String dutyType = "";
		if (request.getParameter("dutyDate") != null
				&& !request.getParameter("dutyDate").equals("")) {
			dutydate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter("dutyDate"));
			searchdutydate = request.getParameter("dutyDate");
		}
		if (request.getParameter("dutyType") != null
				&& !request.getParameter("dutyType").equals("")) {
			dutyType = (String) request.getParameter("dutyType");
		}
		//System.out.println("dutytype::se" + dutyType);
		infomap.put("dutyType", dutyType);
		infomap.put("dutyDate", dutydate);
		map = hrRelatedHandlerService.searchDutyPerformed(infomap);
		jsp = HR_DUTY_PERFORMED;
		jsp = jsp + ".jsp";
		title = "Search Guard Duty Performed";
		map.put("dutyType", dutyType);
		map.put("searchdutydate", searchdutydate);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView updateDutyPerformed(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalmap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		Vector<String> hrGuardDutyIds = box.getVector("hrGuardDutyAdded");
		boolean successfull = false;
		Date dutydate = null;
		String dutydateString = "";
		String message = "";
		if (request.getParameter("searchdutydate") != null
				&& !request.getParameter("searchdutydate").equals("")) {
			dutydate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter("searchdutydate"));
			dutydateString = request.getParameter("searchdutydate");
		}
		//System.out.println("dutydate" + dutydate);
		generalmap.put("box", box);
		generalmap.put("dutydate", dutydate);
		generalmap.put("hrGuardDutyIds", hrGuardDutyIds);
		successfull = hrRelatedHandlerService.updateDutyPerformed(generalmap);
		if (successfull) {
			message = message + "Record is Updated Successfully";
		} else {
			message = message + "try Again";
		}
		map = hrRelatedHandlerService.showDutyPerformed();
		jsp = HR_DUTY_PERFORMED;
		jsp = jsp + ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showGuardDutyEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = hrRelatedHandlerService.showGuardDutyEntryJsp();
		jsp = GUARD_DUTY_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView showGuardDutyAddJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		box.put("numOfRows", "10");
		map = hrRelatedHandlerService.getGridDataForGuardEmployeeAdd(box);
		// map.put("box",box);
		jsp = GUARD_DUTY_ADDITION_JSP;
		title = "Guard Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getGridDataForGuardEmployeeAdd(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		map = hrRelatedHandlerService.getGridDataForGuardEmployeeAdd(box);
		jsp = GUARD_DUTY_ADDITION_JSP;
		title = "Guard Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView showGuardDutyRecords(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		box.put("numOfRows", "10");
		map = hrRelatedHandlerService.getEmployeeDetailsForGuardDuty(box);
		jsp = GUARD_DUTY_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView getGridDataForGuardEmployee(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = hrRelatedHandlerService.getGridDataForGuardEmployee(box);
		jsp = GUARD_DUTY_ENTRY_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView AddGuardDutyEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		box.put("hospitalId", hospitalId);
		successfullyAdded = hrRelatedHandlerService.AddGuardDutyEntry(box);

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
			map = hrRelatedHandlerService
					.getEmployeeDetailsForGuardDutyAdd(box);
		} else {
			message = "Try Again !!";

		}
		map.put("message", message);
		jsp = GUARD_DUTY_ADDITION_JSP;
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getGuardEmployeeLastDutyDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		map = hrRelatedHandlerService.getGuardEmployeeLastDutyDetails(box);
		jsp = "hr_responseForGuardDutyAddition";
		title = "Guard Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView updateGuardDutyEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		successfullyAdded = hrRelatedHandlerService.updateGuardDutyEntry(box);

		if (successfullyAdded) {
			message = "Record updated Successfully !!";
			map = hrRelatedHandlerService.getEmployeeDetailsForGuardDuty(box);
		} else {
			message = "Try Again !!";

		}
		map.put("message", message);
		jsp = GUARD_DUTY_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchGuardDutyData(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = hrRelatedHandlerService.searchGuardDutyData(box);
		jsp = GUARD_DUTY_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	/**
	 * ------------------------------------- WARD DUTY ENTRY
	 * ------------------------------- started on 1st June 09 By Priyanka Garg
	 */

	public ModelAndView showWardDutyEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = hrRelatedHandlerService.showWardDutyEntryJsp();
		jsp = WARD_DUTY_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView showWardDutyAddJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		box.put("numOfRows", "10");
		map = hrRelatedHandlerService.getEmployeeDetailsForWardDutyAdd(box);
		map.put("box", box);
		jsp = WARD_DUTY_ADDITION_JSP;
		title = "Guard Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getGridDataForWardEmployeeAdd(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		map = hrRelatedHandlerService.getGridDataForWardEmployeeAdd(box);
		jsp = WARD_DUTY_ADDITION_JSP;
		title = "Guard Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView showWardDutyRecords(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		box.put("numOfRows", "10");
		map = hrRelatedHandlerService.getEmployeeDetailsForWardDuty(box);
		jsp = WARD_DUTY_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView getGridDataForWardEmployee(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = hrRelatedHandlerService.getGridDataForWardEmployee(box);
		jsp = WARD_DUTY_ENTRY_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView AddWardDutyEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		box.put("hospitalId", hospitalId);
		successfullyAdded = hrRelatedHandlerService.AddWardDutyEntry(box);

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
			map = hrRelatedHandlerService.getEmployeeDetailsForWardDutyAdd(box);
		} else {
			message = "Try Again !!";

		}
		map.put("message", message);
		jsp = WARD_DUTY_ADDITION_JSP;
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getWardEmployeeLastDutyDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		map = hrRelatedHandlerService.getWardEmployeeLastDutyDetails(box);
		jsp = WARD_DUTY_ADDITION_JSP;
		title = "Guard Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView updateWardDutyEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		successfullyAdded = hrRelatedHandlerService.updateWardDutyEntry(box);

		if (successfullyAdded) {
			message = "Record updated Successfully !!";
			map = hrRelatedHandlerService.getEmployeeDetailsForWardDuty(box);
		} else {
			message = "Try Again !!";

		}
		map.put("message", message);
		jsp = WARD_DUTY_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchWardDutyData(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = hrRelatedHandlerService.searchWardDutyData(box);
		jsp = WARD_DUTY_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	/**
	 * ------------------------------------- ORDERLY DUTY ENTRY
	 * ------------------------------- started on 2nd June 09 By Priyanka Garg
	 */

	public ModelAndView showOrderlyDutyEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = hrRelatedHandlerService.showOrderlyDutyEntryJsp();
		jsp = ORDERLY_DUTY_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView showOrderlyDutyAddJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		box.put("numOfRows", "10");
		map = hrRelatedHandlerService.getEmployeeDetailsForOrderlyDutyAdd(box);
		map.put("box", box);
		jsp = ORDERLY_DUTY_ADDITION_JSP;
		title = "Guard Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getGridDataForOrderlyEmployeeAdd(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		map = hrRelatedHandlerService.getGridDataForOrderlyEmployeeAdd(box);
		jsp = ORDERLY_DUTY_ADDITION_JSP;
		title = "Guard Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView showOrderlyDutyRecords(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		box.put("numOfRows", "10");
		map = hrRelatedHandlerService.getEmployeeDetailsForOrderlyDuty(box);
		jsp = ORDERLY_DUTY_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView getGridDataForOrderlyEmployee(
			HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = hrRelatedHandlerService.getGridDataForOrderlyEmployee(box);
		jsp = ORDERLY_DUTY_ENTRY_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView AddOrderlyDutyEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		box.put("hospitalId", hospitalId);
		successfullyAdded = hrRelatedHandlerService.AddOrderlyDutyEntry(box);

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
			map = hrRelatedHandlerService
					.getEmployeeDetailsForOrderlyDutyAdd(box);
		} else {
			message = "Try Again !!";

		}
		map.put("message", message);
		jsp = ORDERLY_DUTY_ADDITION_JSP;
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getOrderlyEmployeeLastDutyDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		map = hrRelatedHandlerService.getOrderlyEmployeeLastDutyDetails(box);
		jsp = ORDERLY_DUTY_ADDITION_JSP;
		title = "Guard Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView updateOrderlyDutyEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		successfullyAdded = hrRelatedHandlerService.updateOrderlyDutyEntry(box);

		if (successfullyAdded) {
			message = "Record updated Successfully !!";
			// map =
			// hrRelatedHandlerService.getEmployeeDetailsForOrderlyDuty(box);
		} else {
			message = "Try Again !!";

		}
		map.put("message", message);
		jsp = ORDERLY_DUTY_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchOrderlyDutyData(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = hrRelatedHandlerService.searchOrderlyDutyData(box);
		jsp = ORDERLY_DUTY_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	/**
	 * ------------------------------------- RANGE FIRING DUTY ENTRY
	 * ------------------------------- started on 9th June 09 By Priyanka Garg
	 */

	public ModelAndView showRangeFiringDutyEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = RANGE_FIRING_DUTY_ENTRY_JSP;
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
		map = hrRelatedHandlerService
				.getEmployeeDetailsForRangeFiringDutyAdd(box);
		map.put("box", box);
		jsp = RANGE_FIRING_DUTY_ADDITION_JSP;
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
		map = hrRelatedHandlerService.getGridDataForRangeFiringEmployeeAdd(box);
		jsp = RANGE_FIRING_DUTY_ADDITION_JSP;
		title = "Guard Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView showRangeFiringDutyRecords(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = hrRelatedHandlerService.getEmployeeDetailsForRangeFiringDuty(box);
		jsp = RANGE_FIRING_DUTY_ENTRY_JSP;
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
		map = hrRelatedHandlerService.getGridDataForRangeFiringEmployee(box);
		jsp = RANGE_FIRING_DUTY_ENTRY_JSP;
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
		successfullyAdded = hrRelatedHandlerService
				.AddRangeFiringDutyEntry(box);

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
			map = hrRelatedHandlerService
					.getEmployeeDetailsForRangeFiringDutyAdd(box);
		} else {
			message = "Try Again !!";

		}
		map.put("message", message);
		jsp = RANGE_FIRING_DUTY_ADDITION_JSP;
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
		successfullyAdded = hrRelatedHandlerService
				.updateRangeFiringDutyEntry(box);

		if (successfullyAdded) {
			message = "Record updated Successfully !!";
			map = hrRelatedHandlerService
					.getEmployeeDetailsForRangeFiringDuty(box);
		} else {
			message = "Try Again !!";

		}
		map.put("message", message);
		jsp = RANGE_FIRING_DUTY_ENTRY_JSP;
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
		map = hrRelatedHandlerService.searchRangeFiringDutyEntry(box);
		map.put("box", box);
		jsp = RANGE_FIRING_DUTY_ADDITION_JSP;
		title = "Guard Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	/**
	 * ------------------------------------- DUTY DISPLAY
	 * ------------------------------- started on 9th June 09 By Priyanka Garg
	 */

	public ModelAndView showDutyDisplayJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = DUTY_DISPLAY_FORM_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView searchDutyDisplay(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		box.put("numOfRows", "10");
		map = hrRelatedHandlerService.searchDutyDisplay(box);
		jsp = DUTY_DISPLAY_FORM_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	/**
	 * ------------------ Duty Exemption Entry ------------ added by Priyanka on
	 * 10th July 2009
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showDutyExemptionSearchJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = hrRelatedHandlerService.showDutyExemptionSearchJsp();
		jsp = DUTY_EXEMPTION_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView searchEmployeeForDutyExemption(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		// Map<String, Object> enquiryMap = new HashMap<String, Object>();
		Map<String, Object> employeeMap = new HashMap<String, Object>();

		String serviceNo = "";
		int rankId = 0;
		String firstName = "";
		String lastName = "";
		@SuppressWarnings("unused")
		Box box = HMSUtil.getBox(request);
		try {
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				employeeMap.put("serviceNo", serviceNo);
			}
			if (!(request.getParameter(RANK_ID).equals("0"))) {
				rankId = Integer.parseInt(request.getParameter(RANK_ID));
				employeeMap.put("rankId", rankId);
			}
			if (request.getParameter(FIRST_NAME) != null
					&& !(request.getParameter(FIRST_NAME).equals(""))) {
				firstName = request.getParameter(FIRST_NAME);
				employeeMap.put("firstName", firstName);
			}
			if (request.getParameter(LAST_NAME) != null
					&& !(request.getParameter(LAST_NAME).equals(""))) {
				lastName = request.getParameter(LAST_NAME);
				employeeMap.put("lastName", lastName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		employeeMap = hrRelatedHandlerService
				.searchEmployeeForDutyExemption(employeeMap);
		// map = enquiryHandlerService.getDetailsForEnquiry();

		String jsp = DUTY_EXEMPTION_SEARCH_JSP;
		jsp += ".jsp";
		map.put("employeeMap", employeeMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showDutyExemptionEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int empId = 0;
		String empName = "";
		if (request.getParameter("empId") != null
				&& !request.getParameter("empId").equals("")) {
			empId = Integer.parseInt(request.getParameter("empId"));
		}
		map = hrRelatedHandlerService.showDutyExemptionEntryJsp(empId);
		jsp = DUTY_EXEMPTION_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView submitDutyExemptionEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int empId = 0;
		String empName = "";
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		successfullyAdded = hrRelatedHandlerService
				.submitDutyExemptionEntry(box);

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";

		}
		map.put("message", message);
		jsp = DUTY_EXEMPTION_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	/**
	 * ------------------------------------- DAILY ROUTINE ENTRY
	 * ------------------------------- started on 14 July 09 By Priyanka Garg
	 */
	public ModelAndView showDailyRoutineEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = hrRelatedHandlerService.showDailyRoutineEntryJsp();

		jsp = DAILY_ROUTINE_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView showDailyRoutineAddJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		box.put("numOfRows", "10");
		map = hrRelatedHandlerService.getEmployeeDetailsForDailyRoutineAdd(box);
		map.put("box", box);
		jsp = DAILY_ROUTINE_ADDITION_JSP;
		title = "Guard Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getGridDataForDailyRoutineEmployeeAdd(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		map = hrRelatedHandlerService
				.getGridDataForDailyRoutineEmployeeAdd(box);
		jsp = DAILY_ROUTINE_ADDITION_JSP;
		title = "Guard Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView showDailyRoutineRecords(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		box.put("numOfRows", "10");
		map = hrRelatedHandlerService.getEmployeeDetailsForDailyRoutine(box);
		jsp = DAILY_ROUTINE_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView getGridDataForDailyRoutineEmployee(
			HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		//System.out.println("pageno in box=" + box.getInt("pageno"));
		Map<String, Object> map = new HashMap<String, Object>();
		map = hrRelatedHandlerService.getGridDataForDailyRoutineEmployee(box);
		jsp = DAILY_ROUTINE_ENTRY_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView AddDailyRoutineEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		box.put("hospitalId", hospitalId);
		successfullyAdded = hrRelatedHandlerService.AddDailyRoutineEntry(box);

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
			map = hrRelatedHandlerService
					.getEmployeeDetailsForDailyRoutineAdd(box);
		} else {
			message = "Try Again !!";

		}
		map.put("message", message);
		jsp = DAILY_ROUTINE_ADDITION_JSP;
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView updateDailyRoutineEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		successfullyAdded = hrRelatedHandlerService
				.updateDailyRoutineEntry(box);

		if (successfullyAdded) {
			message = "Record updated Successfully !!";
			map = hrRelatedHandlerService
					.getEmployeeDetailsForDailyRoutine(box);
		} else {
			message = "Try Again !!";

		}
		map.put("message", message);
		jsp = DAILY_ROUTINE_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchDailyRoutineEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		box.put("numOfRows", "10");
		//System.out.println("method in controller called");
		map = hrRelatedHandlerService.searchDailyRoutineEntry(box);
		map.put("box", box);
		jsp = DAILY_ROUTINE_ADDITION_JSP;
		title = "Guard Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView searchDailyRoutineDutyData(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = hrRelatedHandlerService.searchDailyRoutineDutyData(box);
		jsp = DAILY_ROUTINE_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	/**
	 * ------------------ Update Arrival Entry ------------ added by Priyanka on
	 * 16th July 2009
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showUpdateArrivalSearchJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = hrRelatedHandlerService.showUpdateArrivalSearchJsp();
		jsp = UPDATE_ARRIVAL_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView searchEmployeeForUpdateArrival(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		// Map<String, Object> enquiryMap = new HashMap<String, Object>();
		Map<String, Object> employeeMap = new HashMap<String, Object>();

		String serviceNo = "";
		int rankId = 0;
		String firstName = "";
		String lastName = "";
		@SuppressWarnings("unused")
		Box box = HMSUtil.getBox(request);
		try {
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				employeeMap.put("serviceNo", serviceNo);
			}
			if (!(request.getParameter(RANK_ID).equals("0"))) {
				rankId = Integer.parseInt(request.getParameter(RANK_ID));
				employeeMap.put("rankId", rankId);
			}
			if (request.getParameter(FIRST_NAME) != null
					&& !(request.getParameter(FIRST_NAME).equals(""))) {
				firstName = request.getParameter(FIRST_NAME);
				employeeMap.put("firstName", firstName);
			}
			if (request.getParameter(LAST_NAME) != null
					&& !(request.getParameter(LAST_NAME).equals(""))) {
				lastName = request.getParameter(LAST_NAME);
				employeeMap.put("lastName", lastName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		employeeMap = hrRelatedHandlerService
				.searchEmployeeForUpdateArrival(employeeMap);
		// map = enquiryHandlerService.getDetailsForEnquiry();

		String jsp = UPDATE_ARRIVAL_SEARCH_JSP;
		jsp += ".jsp";
		map.put("employeeMap", employeeMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showUpdateArrivalEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int empId = 0;
		String empName = "";
		if (request.getParameter("empId") != null
				&& !request.getParameter("empId").equals("")) {
			empId = Integer.parseInt(request.getParameter("empId"));
		}
		map = hrRelatedHandlerService.showUpdateArrivalEntryJsp(empId);
		jsp = UPDATE_ARRIVAL_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView submitUpdateArrivalEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int empId = 0;
		String empName = "";
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		successfullyAdded = hrRelatedHandlerService
				.submitUpdateArrivalEntry(box);

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";

		}
		map.put("message", message);
		jsp = UPDATE_ARRIVAL_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	/**
	 * ------------------------- LEAVE APPLICATION PENDING FOR RECCOMENDATION
	 * ------------------
	 */

	public ModelAndView searchEmployeeForLeavePending(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		// Map<String, Object> enquiryMap = new HashMap<String, Object>();
		Map<String, Object> employeeMap = new HashMap<String, Object>();

		String serviceNo = "";
		int rankId = 0;
		String firstName = "";
		String lastName = "";
		@SuppressWarnings("unused")
		Box box = HMSUtil.getBox(request);
		employeeMap = hrRelatedHandlerService
				.searchEmployeeForLeavePending(employeeMap);
		// //System.out.println("employeeList in cnt ---"+employeeList.size());
		// map = enquiryHandlerService.getDetailsForEnquiry();

		String jsp = LEAVE_PENDING_SEARCH_JSP;
		jsp += ".jsp";
		map.put("employeeMap", employeeMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showLeavePendingEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int empId = 0;
		String empName = "";
		if (request.getParameter("empId") != null
				&& !request.getParameter("empId").equals("")) {
			empId = Integer.parseInt(request.getParameter("empId"));
		}
		map = hrRelatedHandlerService.showLeavePendingEntryJsp(empId);
		jsp = LEAVE_PENDING_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView submitLeavePendingEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> employeeMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int leaveId = 0;
		Box box = HMSUtil.getBox(request);
		HrLeaveMaintenance hrLeaveMaintenance = new HrLeaveMaintenance();

		boolean successfullyAdded = false;
		successfullyAdded = hrRelatedHandlerService
				.submitLeavePendingEntry(box);

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";

		}
		employeeMap = hrRelatedHandlerService
				.searchEmployeeForLeavePending(employeeMap);
		map.put("message", message);
		map.put("employeeMap", employeeMap);
		jsp = LEAVE_PENDING_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	/**
	 * -------------------- METHODS FOR DELETION ---------------------------
	 */
	public ModelAndView deleteNightDutyEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		successfullyAdded = hrRelatedHandlerService.deleteNightDutyEntry(box);

		if (successfullyAdded) {
			message = "Record Deleted Successfully !!";
			map = hrRelatedHandlerService.getEmployeeDetailsForNightDuty(box);
		} else {
			message = "Try Again !!";

		}
		map.put("message", message);
		jsp = NIGHT_DUTY_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteGuardDutyEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		successfullyAdded = hrRelatedHandlerService.deleteGuardDutyEntry(box);

		if (successfullyAdded) {
			message = "Record Deleted Successfully !!";
			map = hrRelatedHandlerService.getEmployeeDetailsForGuardDuty(box);
		} else {
			message = "Try Again !!";

		}
		map.put("message", message);
		jsp = GUARD_DUTY_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteWardDutyEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		successfullyAdded = hrRelatedHandlerService.deleteWardDutyEntry(box);

		if (successfullyAdded) {
			message = "Record Deleted Successfully !!";
			map = hrRelatedHandlerService.getEmployeeDetailsForWardDuty(box);
		} else {
			message = "Try Again !!";

		}
		map.put("message", message);
		jsp = WARD_DUTY_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteOrderlyDutyEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		successfullyAdded = hrRelatedHandlerService.deleteOrderlyDutyEntry(box);

		if (successfullyAdded) {
			message = "Record Deleted Successfully !!";
			map = hrRelatedHandlerService.getEmployeeDetailsForOrderlyDuty(box);
		} else {
			message = "Try Again !!";

		}
		map.put("message", message);
		jsp = ORDERLY_DUTY_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteDailyRoutineDutyEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		successfullyAdded = hrRelatedHandlerService
				.deleteDailyRoutineDutyEntry(box);

		if (successfullyAdded) {
			message = "Record Deleted Successfully !!";
			map = hrRelatedHandlerService
					.getEmployeeDetailsForDailyRoutine(box);
		} else {
			message = "Try Again !!";

		}
		map.put("message", message);
		jsp = DAILY_ROUTINE_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------------- METHODS FOR SEARCH ON ADDITION POP UP SCREEN
	 * -------------------
	 */
	public ModelAndView searchNightDutyEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		box.put("numOfRows", "10");
		map = hrRelatedHandlerService.searchNightDutyEntry(box);
		map.put("box", box);
		jsp = NIGHT_DUTY_ADDITION_JSP;
		title = "Guard Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView searchGuardDutyEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		box.put("numOfRows", "10");
		map = hrRelatedHandlerService.searchGuardDutyEntry(box);
		map.put("box", box);
		jsp = GUARD_DUTY_ADDITION_JSP;
		title = "Guard Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView searchWardDutyEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		box.put("numOfRows", "10");
		map = hrRelatedHandlerService.searchWardDutyEntry(box);
		map.put("box", box);
		jsp = WARD_DUTY_ADDITION_JSP;
		title = "Guard Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView searchOrderlyDutyEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		box.put("numOfRows", "10");
		map = hrRelatedHandlerService.searchOrderlyDutyEntry(box);
		map.put("box", box);
		jsp = ORDERLY_DUTY_ADDITION_JSP;
		title = "Guard Duty Entry Addition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	/**
	 * ------------------------------------------------------------------------
	 * --------------------- ------------------------------------- REPORTS
	 * -----------------------------------------------
	 * --------------------------
	 * -------------------------------------------------------------------
	 */

	// ---------------------------- GUARD DUTY REPORT
	// ----------------------------------------------

	public ModelAndView showGuardDutyReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "hr_guardDutyReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generateGuardReport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		byte[] bytes = null;
		//ServletContext context = request.getSession().getServletContext();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		detailsMap = hrRelatedHandlerService.getConnectionForReport();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		try {
			HMSUtil.generateReport("HrGuardDuty", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;

	}

	// ---------------------------- NIGHT DUTY REPORT
	// ----------------------------------------------

	public ModelAndView showNightDutyReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "hr_nightDutyReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generateNightReport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		byte[] bytes = null;
		//ServletContext context = request.getSession().getServletContext();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		detailsMap = hrRelatedHandlerService.getConnectionForReport();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		try {
			HMSUtil.generateReport("HrNightDuty", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;

	}

	// ---------------------------- WARD DUTY REPORT
	// ----------------------------------------------

	public ModelAndView showWardDutyReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "hr_wardDutyReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generateWardReport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		byte[] bytes = null;
		//ServletContext context = request.getSession().getServletContext();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		detailsMap = hrRelatedHandlerService.getConnectionForReport();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		try {
			HMSUtil.generateReport("HrWardDuty", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;

	}

	// ---------------------------- ORDERLY DUTY REPORT
	// ----------------------------------------------

	public ModelAndView showOrderlyDutyReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "hr_orderlyDutyReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generateOrderlyReport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		byte[] bytes = null;
		//ServletContext context = request.getSession().getServletContext();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		detailsMap = hrRelatedHandlerService.getConnectionForReport();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		try {
			HMSUtil.generateReport("HrOrderlyDuty", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;

	}

	// ---------------------------- RANGE FIRING DUTY REPORT
	// ----------------------------------------------

	public ModelAndView showRangeFiringDutyReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "hr_rangeFiringDutyReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generateRangeFiringReport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		byte[] bytes = null;
		//ServletContext context = request.getSession().getServletContext();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String quarter = "";
		String dutyYear = "";
		if (request.getParameter("quarter") != null) {
			quarter = request.getParameter("quarter");
		}
		if (request.getParameter("year") != null) {
			dutyYear = request.getParameter("year");
		}
		detailsMap = hrRelatedHandlerService.getConnectionForReport();
		parameters.put("quarter", quarter);
		parameters.put("year", dutyYear);

		try {
			HMSUtil.generateReport("HrRangeFiringDuty", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;

	}

	// ---------------------------- NOMINAL ROLL REPORT
	// ----------------------------------------------

	public ModelAndView showNominalReportJsp(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		byte[] bytes = null;
		//ServletContext context = request.getSession().getServletContext();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		detailsMap = hrRelatedHandlerService.getConnectionForReport();

		try {
			HMSUtil.generateReport("HrNominalRoll", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;

	}

	// ---------------------------- ESTABLISHMENT STRENGTH REPORT
	// ----------------------------------------------

	public ModelAndView showEstablishmentReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = hrRelatedHandlerService.showEstablishmentReportJsp();
		String jsp = "hr_establishmentStrengthReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generateEstablishmentReport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		byte[] bytes = null;
		//ServletContext context = request.getSession().getServletContext();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		int unitId = 0;
		if (request.getParameter(UNIT_ID) != null) {
			unitId = Integer.parseInt(request.getParameter(UNIT_ID));
		}
		detailsMap = hrRelatedHandlerService.getConnectionForReport();
		parameters.put("unit", unitId);

		try {
			HMSUtil.generateReport("HrEstablishmentStrength", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;

	}

	// ---------------------------- DEPARTMENT WISE REPORT
	// ----------------------------------------------

	public ModelAndView showDepartmentWiseReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = hrRelatedHandlerService.showDepartmentWiseReportJsp();
		String jsp = "hr_departmentWise";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generateDepartmentWiseReport(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		byte[] bytes = null;
		//ServletContext context = request.getSession().getServletContext();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		int departmentId = 0;
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		detailsMap = hrRelatedHandlerService.getConnectionForReport();
		parameters.put("department", departmentId);

		try {
			HMSUtil.generateReport("HrDepartmentWise", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;

	}

	// ---------------------------- SPECIALITY WISE REPORT
	// ----------------------------------------------

	public ModelAndView showSpecialistWiseReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = hrRelatedHandlerService.showSpecialistWiseReportJsp();
		String jsp = "hr_specialityWise";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generateSpecialityWiseReport(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		byte[] bytes = null;
		//ServletContext context = request.getSession().getServletContext();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		int specialityId = 0;
		if (request.getParameter("specialityId") != null) {
			specialityId = Integer.parseInt(request
					.getParameter("specialityId"));
		}
		detailsMap = hrRelatedHandlerService.getConnectionForReport();
		parameters.put("speciality", specialityId);

		try {
			HMSUtil.generateReport("HrSpecialityWise", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;

	}

	// ---------------------------- RANK WISE REPORT
	// ----------------------------------------------

	public ModelAndView showRankWiseReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = hrRelatedHandlerService.showRankWiseReportJsp();
		String jsp = "hr_rankWise";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generateRankWiseReport(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		byte[] bytes = null;
		//ServletContext context = request.getSession().getServletContext();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		int rankId = 0;
		if (request.getParameter(RANK_ID) != null) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
		}
		detailsMap = hrRelatedHandlerService.getConnectionForReport();
		parameters.put("rank", rankId);

		try {
			HMSUtil.generateReport("HrRankWise", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;

	}

	// ---------------------------- ESTABLISHMENT/STRENGTH AS ON DATE REPORT
	// ----------------------------------------------

	public ModelAndView showEstablishmentAsOnDateReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = hrRelatedHandlerService.showEstablishmentReportJsp();
		String jsp = "hr_establishmentStrengthAsOnDateReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generateEstablishmentAsOnDateReport(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		byte[] bytes = null;
		//ServletContext context = request.getSession().getServletContext();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		String[] unitId = request.getParameterValues("unitId");
		String queryString = "";
		if (unitId != null) {
			Integer[] units = new Integer[unitId.length];
			queryString = "Select a.unit_name,b.establishment,a.strength,(a.strength-b.establishment) as surplus from "
					+ "(select hr_establishment_master.strength,mas_unit.unit_name,hr_establishment_master.unit_id from hr_establishment_master "
					+ "LEFT JOIN mas_unit ON hr_establishment_master.unit_id=mas_unit.unit_id "
					+ "where hr_establishment_master.unit_id in(";
			queryString = queryString + Integer.parseInt(unitId[0]);
			for (int i = 1; i < unitId.length; i++)
				queryString = queryString + "," + Integer.parseInt(unitId[i]);
			queryString = queryString
					+ "))as a, "
					+ "(SELECT count(*) as establishment,mas_employee.unit_id FROM mas_employee "
					+ "where unit_id in (";
			queryString = queryString + Integer.parseInt(unitId[0]);
			for (int i = 1; i < unitId.length; i++)
				queryString = queryString + "," + Integer.parseInt(unitId[i]);
			queryString = queryString
					+ ") group by mas_employee.unit_id)as b where a.unit_id=b.unit_id;";
		} else {
			detailsMap = hrRelatedHandlerService.showEstablishmentReportJsp();
			if (detailsMap.get("unitList") != null) {
				unitList = (List) detailsMap.get("unitList");
				queryString = "Select a.unit_name,b.establishment,a.strength,(a.strength-b.establishment) as surplus from "
						+ "(select hr_establishment_master.strength,mas_unit.unit_name,hr_establishment_master.unit_id from hr_establishment_master "
						+ "LEFT JOIN mas_unit ON hr_establishment_master.unit_id=mas_unit.unit_id "
						+ "where hr_establishment_master.unit_id in(";
				int sizeOfUnitList = 0;
				for (MasUnit masUnit : unitList) {
					sizeOfUnitList++;
					if (sizeOfUnitList == unitList.size())
						queryString = queryString + masUnit.getId();
					else
						queryString = queryString + masUnit.getId() + ",";
				}
				queryString = queryString
						+ "))as a, "
						+ "(SELECT count(*) as establishment,mas_employee.unit_id FROM mas_employee "
						+ "where unit_id in (";
				sizeOfUnitList = 0;
				for (MasUnit masUnit : unitList) {
					sizeOfUnitList++;
					if (sizeOfUnitList == unitList.size())
						queryString = queryString + masUnit.getId();
					else
						queryString = queryString + masUnit.getId() + ",";
				}
				queryString = queryString
						+ ") group by mas_employee.unit_id)as b where a.unit_id=b.unit_id;";
			}
		}
		// //System.out.println("SQL EXECUTED:"+queryString);
		detailsMap = hrRelatedHandlerService.getConnectionForReport();
		parameters.put("queryString", queryString);
		try {
			HMSUtil.generateReport("HrEstablishmentAsOnDate", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;

	}

}
