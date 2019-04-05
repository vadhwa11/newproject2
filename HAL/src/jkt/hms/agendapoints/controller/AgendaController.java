package jkt.hms.agendapoints.controller;

import static jkt.hms.util.RequestConstants.AGENDA_POINT_JSP;
import static jkt.hms.util.RequestConstants.AGENDA_POINT_UPDATE_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.ENTRY_DATE;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.TO_DATE;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.agendapoints.handler.AgendaHandlerService;
import jkt.hms.masters.business.ApAgendaRequest;
import jkt.hms.masters.business.ApMeetingSchedule;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class AgendaController extends MultiActionController {

	private AgendaHandlerService agendaHandlerService = null;
	private CommonMasterHandlerService commonMasterHandlerService = null;

	public ModelAndView showMeetingScheduleJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "";
		String title = "";
		String message = "";
		String meetingNo = "";

		Map<String, Object> map = agendaHandlerService.showMeetingScheduleJsp();
		meetingNo = agendaHandlerService.generateMeetingNumber(meetingNo);
		jsp = RequestConstants.AGENDA_POINT_SEARCH_JSP;
		jsp += ".jsp";
		title = "Agenda Points";
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("meetingNo", meetingNo);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addAgendaMeetingSchedule(HttpServletRequest req,
			HttpServletResponse res) {
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = 0;
		String entryDate = null;
		String proposedFromTime = "";
		String proposedToTime = "";
		String venue = "";
		String meetingTitle = "";
		String chairedBy = "";
		String jsp = "";
		String title = "";
		String message = "";
		String lastChangedBy = "";
		String lastChangedTime = "";
		Date lastChangedDate = null;
		String meetingNo = "";
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List<String> selectedList = new ArrayList<String>();
		List<String> rejectedList = new ArrayList<String>();
		ApMeetingSchedule apMeetingSchedule = new ApMeetingSchedule();
		// initializing box with the request to get the values from the inner
		// table
		Box box = HMSUtil.getBox(req);
		Vector v1 = box.getVector("selectedId");
		Vector v2 = box.getVector("rejectedId");
		if ((v1 != null && v1.size() > 0) || (v2 != null && v2.size() > 0)) {
			if (req.getParameter(RequestConstants.PROPOSED_DATE) != null) {
				entryDate = req.getParameter(RequestConstants.PROPOSED_DATE);
				apMeetingSchedule.setProposedDate(HMSUtil
						.convertStringTypeDateToDateType(entryDate));
			}

			if (req.getParameter(RequestConstants.PROPOSED_TIME_FROM) != null) {
				proposedFromTime = req
						.getParameter(RequestConstants.PROPOSED_TIME_FROM);
				apMeetingSchedule.setProposedTimeFrom(proposedFromTime);
			}

			if (req.getParameter(RequestConstants.PROPOSED_TIME_TO) != null) {
				proposedToTime = req
						.getParameter(RequestConstants.PROPOSED_TIME_TO);
				apMeetingSchedule.setProposedTimeTo(proposedToTime);
			}
			if (req.getParameter(RequestConstants.MEETING_NO) != null) {
				meetingNo = req.getParameter(RequestConstants.MEETING_NO);
				apMeetingSchedule.setMeetingNo(meetingNo);
			}

			if (req.getParameter(RequestConstants.AGENDA_VENUE) != null) {
				venue = req.getParameter(RequestConstants.AGENDA_VENUE);
				apMeetingSchedule.setVenue(venue);
			}

			if (req.getParameter(RequestConstants.MEETING_TITLE) != null) {
				meetingTitle = req.getParameter(RequestConstants.MEETING_TITLE);
				apMeetingSchedule.setMeetingTitle(meetingTitle);
			}
			if (req.getParameter(RequestConstants.CHAIRED_BY) != null) {
				chairedBy = req.getParameter(RequestConstants.CHAIRED_BY);
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(Integer.parseInt(chairedBy));
				apMeetingSchedule.setChairedBy(masEmployee);
			}

			if (req.getParameter(CHANGED_BY) != null) {
				lastChangedBy = req.getParameter(CHANGED_BY);
				apMeetingSchedule.setLastChgBy(lastChangedBy);
			}
			if (req.getParameter(CHANGED_DATE) != null) {
				lastChangedDate = HMSUtil.dateFormatterDDMMYYYY(req
						.getParameter(CHANGED_DATE));
				apMeetingSchedule.setLastChgDate(lastChangedDate);
			}
			if (req.getParameter(CHANGED_TIME) != null) {
				lastChangedTime = req.getParameter(CHANGED_TIME);
				apMeetingSchedule.setLastChgTime(lastChangedTime);
			}
			if (req.getParameter("title") != null) {
				title = req.getParameter("title");
			}
			apMeetingSchedule.setStatus("s"); // s for meeting scheduled
			boolean successfullyAdded = false;
			generalMap.put("code", meetingNo);
			generalMap.put("pojoName", "ApMeetingSchedule");
			generalMap.put("pojoPropertyCode", "MeetingNo");
			Map listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);
			List meetingNoList = (List) listMap.get("duplicateGeneralCodeList");
			if (meetingNoList == null || meetingNoList.size() == 0) {
				generalMap.put("apMeetingSchedule", apMeetingSchedule);
				generalMap.put("box", box);
				successfullyAdded = agendaHandlerService
						.addMeetingScheduled(generalMap);
				message = "Record sucessfully added";
				generalMap.clear();
			} else if (successfullyAdded) {
				message = "Please try again";
			} else {
				message = "This meeting is already schedule";
			}
		} else {
			message = "You have not selected any Agenda Point Request! Please select a request!";
		}
		map = agendaHandlerService.showMeetingScheduleJsp();
		meetingNo = agendaHandlerService.generateMeetingNumber(meetingNo);
		jsp = RequestConstants.AGENDA_POINT_SEARCH_JSP;
		jsp += ".jsp";
		title = "Agenda Points Meeting Schedule";
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("meetingNo", meetingNo);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView editMeetingDetails(HttpServletRequest req,
			HttpServletResponse res) {
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = 0;
		String entryDate = null;
		String proposedFromTime = "";
		String proposedToTime = "";
		String actualDate = null;
		String actualFromTime = "";
		String actualToTime = "";
		String venue = "";
		String meetingTitle = "";
		String chairedBy = "";
		String actuallyChairedBy = "";
		String jsp = "";
		String title = "";
		String message = "";
		String lastChangedBy = "";
		String lastChangedTime = "";
		Date lastChangedDate = null;
		String meetingNo = "";
		String otherAttendees = "";
		int id = 0;
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List<String> selectedList = new ArrayList<String>();
		List<String> rejectedList = new ArrayList<String>();
		ApMeetingSchedule apMeetingSchedule = new ApMeetingSchedule();
		// initializing box with the request to get the values from the inner
		// table
		Box box = HMSUtil.getBox(req);
		Vector v1 = box.getVector(RequestConstants.EMPLOYEE_ID);
		Vector v2 = box.getVector(RequestConstants.EMPLOYEE_ID2);
		Vector v3 = box.getVector(RequestConstants.DECISION_IN_MEETING);
		Vector v4 = box.getVector(RequestConstants.ACTIONED_BY);
		Vector v5 = box.getVector(RequestConstants.ACTIONED_TO);

		// if((v1!=null && v1.size()>0) || (v2!=null && v2.size()>0)){
		if (req.getParameter(RequestConstants.ID) != null) {
			id = Integer.parseInt(req.getParameter(RequestConstants.ID));
			apMeetingSchedule.setId(id);
		}
		if (req.getParameter(RequestConstants.PROPOSED_DATE) != null) {
			entryDate = req.getParameter(RequestConstants.PROPOSED_DATE);
			apMeetingSchedule.setProposedDate(HMSUtil
					.convertStringTypeDateToDateType(entryDate));
		}

		if (req.getParameter(RequestConstants.PROPOSED_TIME_FROM) != null) {
			proposedFromTime = req
					.getParameter(RequestConstants.PROPOSED_TIME_FROM);
			apMeetingSchedule.setProposedTimeFrom(proposedFromTime);
		}
		if (req.getParameter(RequestConstants.MEETING_ACTAUL_DATE) != null) {
			actualDate = req.getParameter(RequestConstants.MEETING_ACTAUL_DATE);
			apMeetingSchedule.setActualMeetingDate(HMSUtil
					.convertStringTypeDateToDateType(actualDate));
		}

		if (req.getParameter(RequestConstants.MEETING_ACTAUL_TIME_FROM) != null) {
			actualFromTime = req
					.getParameter(RequestConstants.MEETING_ACTAUL_TIME_FROM);
			apMeetingSchedule.setActualTimeFrom(actualFromTime);
		}

		if (req.getParameter(RequestConstants.MEETING_ACTAUL_TIME_TO) != null) {
			actualToTime = req
					.getParameter(RequestConstants.MEETING_ACTAUL_TIME_TO);
			apMeetingSchedule.setActualTimeTo(actualToTime);
		}
		if (req.getParameter(RequestConstants.MEETING_NO) != null) {
			meetingNo = req.getParameter(RequestConstants.MEETING_NO);
			apMeetingSchedule.setMeetingNo(meetingNo);
		}

		if (req.getParameter(RequestConstants.AGENDA_VENUE) != null) {
			venue = req.getParameter(RequestConstants.AGENDA_VENUE);
			apMeetingSchedule.setVenue(venue);
		}

		if (req.getParameter(RequestConstants.MEETING_TITLE) != null) {
			meetingTitle = req.getParameter(RequestConstants.MEETING_TITLE);
			apMeetingSchedule.setMeetingTitle(meetingTitle);
		}
		if (req.getParameter(RequestConstants.CHAIRED_BY) != null) {
			actuallyChairedBy = req.getParameter(RequestConstants.CHAIRED_BY);
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(Integer.parseInt(actuallyChairedBy));
			apMeetingSchedule.setActualChairedBy(masEmployee);
		}
		if (req.getParameter(CHANGED_BY) != null) {
			lastChangedBy = req.getParameter(CHANGED_BY);
			apMeetingSchedule.setLastChgBy(lastChangedBy);
		}
		if (req.getParameter(CHANGED_DATE) != null) {
			lastChangedDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(CHANGED_DATE));
			apMeetingSchedule.setLastChgDate(lastChangedDate);
		}
		if (req.getParameter(CHANGED_TIME) != null) {
			lastChangedTime = req.getParameter(CHANGED_TIME);
			apMeetingSchedule.setLastChgTime(lastChangedTime);
		}
		if (req.getParameter(RequestConstants.MOM__ATTENDEES) != null) {
			otherAttendees = req.getParameter(RequestConstants.MOM__ATTENDEES);
			apMeetingSchedule.setOtherAttendees(otherAttendees);
		}

		if (req.getParameter("title") != null) {
			title = req.getParameter("title");
		}
		apMeetingSchedule.setStatus("c"); // c for meeting completed
		boolean successfullyAdded = false;
		generalMap.put("apMeetingSchedule", apMeetingSchedule);
		generalMap.put("box", box);
		successfullyAdded = agendaHandlerService
				.editMeetingScheduled(generalMap);
		if (successfullyAdded) {
			message = "Record sucessfully Updated";
			generalMap.clear();
		} else {
			message = "Please Try Again";
		}

		map = agendaHandlerService.showMeetingDetailSearchJsp();
		jsp = "ap_agendaReportMsg";
		jsp += ".jsp";
		title = "Agenda Points Meeting Schedule";
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("meetingNo", meetingNo);
		map.put("title", title);
		map.put("id", id);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showAgendaMeetingDetailsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		String meetingNo = "";
		int Id = 0;
		if (request.getParameter("Id") != null) {
			Id = Integer.parseInt(request.getParameter("Id"));
			//System.out.println("id---------" + Id);
		}
		map = agendaHandlerService.showMeetingDetailsJsp(Id);

		// the constant below initialized with search jsp
		jsp = RequestConstants.AGENDA_POINT_UPDATE_JSP;
		jsp += ".jsp";
		title = "Agenda Points Meeting Details";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showAgendaMeetingDetailSearchJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		int Id = 0;
		map = agendaHandlerService.showMeetingDetailSearchJsp();
		// the constant below initialized with search jsp
		jsp = AGENDA_POINT_UPDATE_SEARCH_JSP;
		jsp += ".jsp";
		title = "Agenda Points Meeting Details";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchAgendaMeetingDetailSearch(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		jkt.hms.agendapoints.controller.AgendaDTO agnedaDTO = new jkt.hms.agendapoints.controller.AgendaDTO();
		if (!request.getParameter(TO_DATE).equalsIgnoreCase("")
				&& request.getParameter(TO_DATE) != null) {
			agnedaDTO.setToDate(request.getParameter(TO_DATE));
		}
		if (!request.getParameter(FROM_DATE).equalsIgnoreCase("")
				&& request.getParameter(FROM_DATE) != null) {
			agnedaDTO.setFromDate(request.getParameter(FROM_DATE));
		}
		map = agendaHandlerService.searchAgendaMeetingDetailSearch(agnedaDTO);
		jsp = AGENDA_POINT_UPDATE_SEARCH_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/***************************************************************************
	 * *
	 * 
	 * 
	 * 
	 * 
	 * *************************************************************************
	 * ********************************
	 * 
	 * @param request
	 * @param response
	 * @return
	 */

	public ModelAndView showAgendaJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "";
		String title = "";
		String message = "";
		Map<String, Object> map = agendaHandlerService.showAgendaJsp();
		if (request.getParameter("message") != null) {
			message = request.getParameter("message");
		}
		jsp = AGENDA_POINT_JSP;
		jsp += ".jsp";
		title = "Agenda Points";
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchAgendaRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		String searchAgendaPoints = "";
		String jsp = "";

		Map<String, Object> generalMap = new HashMap();
		Map<String, Object> map = new HashMap();

		if (request.getParameter(RequestConstants.SEARCH_FIELD) != null) {
			searchAgendaPoints = request
					.getParameter(RequestConstants.SEARCH_FIELD);
		}

		generalMap.put("searchAgendaPoint", searchAgendaPoints);

		map = agendaHandlerService.searchAgendaRequest(generalMap);
		jsp = AGENDA_POINT_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addAgendaPointsRequest(HttpServletRequest req,
			HttpServletResponse res) {
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = 0;
		String entryDate = null;
		int empId = 0;
		String jsp = "";
		String title = "";
		String agendaPoint = "";
		String message = "";
		String lastChangedBy = "";
		String lastChangedTime = "";
		Date lastChangedDate = null;
		Map<String, Object> listMap = new HashMap<String, Object>();

		Map<String, Object> generalMap = new HashMap<String, Object>();
		ApAgendaRequest apAgendaRequest = new ApAgendaRequest();
		if (req.getParameter(ENTRY_DATE) != null) {
			entryDate = req.getParameter(ENTRY_DATE);
		}
		if (req.getParameter(RequestConstants.EMPLOYEE_ID) != null) {
			empId = Integer.parseInt(req
					.getParameter(RequestConstants.EMPLOYEE_ID));
		}

		if (req.getParameter(RequestConstants.AGENDA_POINTS_DETAILS) != null) {
			agendaPoint = req
					.getParameter(RequestConstants.AGENDA_POINTS_DETAILS);
			apAgendaRequest.setAgendaDetail(agendaPoint);
		}
		if (req.getParameter(RequestConstants.AGENDA_POINTS) != null) {
			agendaPoint = req.getParameter(RequestConstants.AGENDA_POINTS);
			apAgendaRequest.setAgendaPoint(agendaPoint);
		}
		if (req.getParameter(RequestConstants.DEPARTMENT_ID) != null) {
			deptId = Integer.parseInt(req
					.getParameter(RequestConstants.DEPARTMENT_ID));
		}
		if (req.getParameter(CHANGED_BY) != null) {
			lastChangedBy = req.getParameter(CHANGED_BY);
		}
		if (req.getParameter(CHANGED_DATE) != null) {
			lastChangedDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(CHANGED_DATE));
		}
		if (req.getParameter(CHANGED_TIME) != null) {
			lastChangedTime = req.getParameter(CHANGED_TIME);
		}
		if (req.getParameter("title") != null) {
			title = req.getParameter("title");
		}

		MasEmployee masEmployee = new MasEmployee();
		MasDepartment masDepartment = new MasDepartment();

		apAgendaRequest.setAgendaDate(HMSUtil
				.convertStringTypeDateToDateType(entryDate));
		masEmployee.setId(empId);
		apAgendaRequest.setEmpId(masEmployee);
		masDepartment.setId(deptId);
		apAgendaRequest.setDepartmentId(masDepartment);
		apAgendaRequest.setLastChgBy(lastChangedBy);
		apAgendaRequest.setLastChgDate(lastChangedDate);
		apAgendaRequest.setLastChgTime(lastChangedTime);
		apAgendaRequest.setStatus("o");

		generalMap.put("apAgendaRequest", apAgendaRequest);
		boolean successfullyAdded = agendaHandlerService
				.addAgendaPointsRequest(generalMap);

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}

		map = agendaHandlerService.showAgendaJsp();

		jsp = AGENDA_POINT_JSP;
		title = "Agenda Points Request";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editAgendaRequest(HttpServletRequest req,
			HttpServletResponse res) {
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = 0;
		String entryDate = null;
		int empId = 0;
		String jsp = "";
		String title = "";
		String agendaPoint = "";
		String message = "";
		String lastChangedBy = "";
		String lastChangedTime = "";
		Date lastChangedDate = null;
		int agendaPointId = 0;
		Map<String, Object> listMap = new HashMap<String, Object>();

		Map<String, Object> generalMap = new HashMap<String, Object>();
		if (req.getParameter(COMMON_ID) != null
				&& !(req.getParameter(COMMON_ID).equals(""))) {
			agendaPointId = Integer.parseInt(req.getParameter(COMMON_ID));
		}
		if (req.getParameter(ENTRY_DATE) != null) {
			entryDate = req.getParameter(ENTRY_DATE);
		}
		if (req.getParameter(RequestConstants.EMPLOYEE_ID) != null) {
			empId = Integer.parseInt(req
					.getParameter(RequestConstants.EMPLOYEE_ID));
		}

		if (req.getParameter(RequestConstants.AGENDA_POINTS_DETAILS) != null) {
			agendaPoint = req
					.getParameter(RequestConstants.AGENDA_POINTS_DETAILS);
		}

		if (req.getParameter(RequestConstants.DEPARTMENT_ID) != null) {
			deptId = Integer.parseInt(req
					.getParameter(RequestConstants.DEPARTMENT_ID));
		}
		if (req.getParameter(CHANGED_BY) != null) {
			lastChangedBy = req.getParameter(CHANGED_BY);
		}
		if (req.getParameter(CHANGED_DATE) != null) {
			lastChangedDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(CHANGED_DATE));
		}
		if (req.getParameter(CHANGED_TIME) != null) {
			lastChangedTime = req.getParameter(CHANGED_TIME);
		}
		if (req.getParameter("title") != null) {
			title = req.getParameter("title");
		}

		ApAgendaRequest apAgendaRequest = new ApAgendaRequest();
		MasEmployee masEmployee = new MasEmployee();
		MasDepartment masDepartment = new MasDepartment();
		apAgendaRequest.setAgendaPoint(agendaPoint);
		apAgendaRequest.setAgendaDate(HMSUtil
				.convertStringTypeDateToDateType(entryDate));
		masEmployee.setId(empId);
		apAgendaRequest.setEmpId(masEmployee);
		masDepartment.setId(deptId);
		apAgendaRequest.setDepartmentId(masDepartment);
		apAgendaRequest.setLastChgBy(lastChangedBy);
		apAgendaRequest.setLastChgDate(lastChangedDate);
		apAgendaRequest.setLastChgTime(lastChangedTime);
		apAgendaRequest.setStatus("o");
		apAgendaRequest.setId(agendaPointId);
		generalMap.put("apAgendaRequest", apAgendaRequest);
		boolean successfullyAdded = agendaHandlerService
				.editAgendaPointsRequest(generalMap);

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}

		map = agendaHandlerService.showAgendaJsp();

		jsp = AGENDA_POINT_JSP;
		title = "Agenda Points Request";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteAgendaRequest(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int agendaPointId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		String jsp = "";
		String title = "";

		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			agendaPointId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		generalMap.put("agendaPointId", agendaPointId);
		boolean dataDeleted = false;
		dataDeleted = agendaHandlerService.deleteAgendaRequest(generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}

		try {
			map = agendaHandlerService.showAgendaJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = AGENDA_POINT_JSP;
		title = "Agenda Point Request";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView printAgendaReport(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();

		int hospitalId = 1;
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		int Id = 1;
		Map<String, Object> parameters = new HashMap();
		Map<String, Object> connectionMap = agendaHandlerService
				.getConnectionForReport();
		if (request.getParameter("Id") != null) {
			Id = Integer.parseInt(request.getParameter("Id"));

		}
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		//System.out.println("Before" + Id);
		parameters.put("ID", Id);
		parameters.put("hospital_id", hospitalId);
		//System.out.println("After" + Id);
		try {

			HMSUtil.generateReport("meating_Agenda_report", parameters,
					(java.sql.Connection) connectionMap.get("con"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public AgendaHandlerService getAgendaHandlerService() {
		return agendaHandlerService;
	}

	public void setAgendaHandlerService(
			AgendaHandlerService agendaHandlerService) {
		this.agendaHandlerService = agendaHandlerService;
	}

	/**
	 * @return the commonMasterHandlerService
	 */
	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	/**
	 * @param commonMasterHandlerService
	 *            the commonMasterHandlerService to set
	 */
	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}