package jkt.hms.agendapoints.controller;

import static jkt.hms.util.RequestConstants.AGENDA_SUMMARY;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.MOM_DETAIL_AGAINST_AGENDA_JSP;
import static jkt.hms.util.RequestConstants.MOM_WORK_DETAIL_AGENDA_SEARCH;
import static jkt.hms.util.RequestConstants.MOM__ABSENTEES;
import static jkt.hms.util.RequestConstants.MOM__ACTUAL_ENDING_TIME;
import static jkt.hms.util.RequestConstants.MOM__ACTUAL_STARTED_TIME;
import static jkt.hms.util.RequestConstants.MOM__ATTENDEES;
import static jkt.hms.util.RequestConstants.MOM__CHAIRED_BY;
import static jkt.hms.util.RequestConstants.MOM__DATE;
import static jkt.hms.util.RequestConstants.MOM__MINTS_BY;
import static jkt.hms.util.RequestConstants.MOM__NO;
import static jkt.hms.util.RequestConstants.SUMMARY_OF_DISCUSSION;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.agendapoints.handler.MomDetailAgainstAgendaHandlerService;
import jkt.hms.agendapoints.handler.MomWorkDetailSearchHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MomDetailAgainstAgendaController extends MultiActionController {
	MomWorkDetailSearchHandlerService momworkdetailsearchhandlerservice = null;
	MomDetailAgainstAgendaHandlerService momdetailagainstagendahandlerservice = null;
	int id = 0;

	public ModelAndView showMomDetailAgainstAgendaJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		String momNo = "";
		Map map = new HashMap();
		String sampleCollectionDetailId = request
				.getParameter("sampleCollectionDetailId");
		setId(Integer.parseInt(sampleCollectionDetailId));
		String userName = "";
		if (request.getParameter(CHANGED_BY) != null) {
			userName = request.getParameter(CHANGED_BY);
		}
		momNo = momdetailagainstagendahandlerservice
				.generateMomNumber(userName);

		map = momdetailagainstagendahandlerservice
				.showMomDetailAgainstAgendaJsp(getId());
		map.put("momNo", momNo);
		jsp = MOM_DETAIL_AGAINST_AGENDA_JSP;

		jsp += ".jsp";
		// title = "complaint";

		map.put("contentJsp", jsp);
		// map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	public MomDetailAgainstAgendaHandlerService getMomDetailAgainstAgendaHandlerService() {
		return momdetailagainstagendahandlerservice;
	}

	public void setMomDetailAgainstAgendaHandlerService(
			MomDetailAgainstAgendaHandlerService momdetailagainstagendahandlerservice) {
		this.momdetailagainstagendahandlerservice = momdetailagainstagendahandlerservice;
	}

	public MomWorkDetailSearchHandlerService getMomWorkDetailSearchHandlerService() {
		return momworkdetailsearchhandlerservice;
	}

	public void setMomWorkDetailSearchHandlerService(
			MomWorkDetailSearchHandlerService momworkdetailsearchhandlerservice) {
		this.momworkdetailsearchhandlerservice = momworkdetailsearchhandlerservice;
	}

	public ModelAndView addMomDetailAgainstAgenda(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Vector v = box.getVector(SUMMARY_OF_DISCUSSION);
		HttpSession session = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();

		String momActualStartedTime = "";
		String momActualEndingTime = "";
		String momAttendees = "";
		String momAbsentees = "";
		String momChairedBy = "";
		String momMintsBy = "";
		String momAgendaSummary = "";
		String momDate = "";
		String momNo = "";
		String message = "";
		String url = "";
		String title = "";
		String jsp = "";

		if (request.getParameter(MOM__ATTENDEES) != null
				&& !(request.getParameter(MOM__ATTENDEES).equals(""))) {
			momAttendees = request.getParameter(MOM__ATTENDEES);

		}

		if (request.getParameter(MOM__NO) != null
				&& !(request.getParameter(MOM__NO).equals(""))) {
			momNo = request.getParameter(MOM__NO);

		}
		if (request.getParameter(MOM__ACTUAL_STARTED_TIME) != null
				&& !(request.getParameter(MOM__ACTUAL_STARTED_TIME).equals(""))) {
			momActualStartedTime = request
					.getParameter(MOM__ACTUAL_STARTED_TIME);

		}
		if (request.getParameter(MOM__ACTUAL_ENDING_TIME) != null
				&& !(request.getParameter(MOM__ACTUAL_ENDING_TIME).equals(""))) {
			momActualEndingTime = request.getParameter(MOM__ACTUAL_ENDING_TIME);

		}

		if (request.getParameter(MOM__ABSENTEES) != null
				&& !(request.getParameter(MOM__ABSENTEES).equals(""))) {
			momAbsentees = request.getParameter(MOM__ABSENTEES);

		}
		if (request.getParameter(MOM__CHAIRED_BY) != null
				&& !(request.getParameter(MOM__CHAIRED_BY).equals(""))) {
			momChairedBy = request.getParameter(MOM__CHAIRED_BY);

		}
		if (request.getParameter(MOM__MINTS_BY) != null
				&& !(request.getParameter(MOM__MINTS_BY).equals(""))) {
			momMintsBy = request.getParameter(MOM__MINTS_BY);

		}

		if (request.getParameter(AGENDA_SUMMARY) != null
				&& !(request.getParameter(AGENDA_SUMMARY).equals(""))) {
			momAgendaSummary = request.getParameter(AGENDA_SUMMARY);
		}
		if (request.getParameter(MOM__DATE) != null
				&& !(request.getParameter(MOM__DATE).equals(""))) {
			momDate = request.getParameter(MOM__DATE);
		}

		generalMap.put("Id", getId());

		generalMap.put("momNo", momNo);
		generalMap.put("momDate", momDate);
		generalMap.put("momActualStartedTime", momActualStartedTime);
		generalMap.put("momActualEndingTime", momActualEndingTime);
		generalMap.put("momAttendees", momAttendees);
		generalMap.put("momAbsentees", momAbsentees);
		generalMap.put("momChairedBy", momChairedBy);
		generalMap.put("momMintsBy", momMintsBy);
		generalMap.put("momAgendaSummary", momAgendaSummary);
		generalMap.put("v", v);

		generalMap.put("flag", true);

		boolean dataUpdated = false;
		dataUpdated = momdetailagainstagendahandlerservice
				.addMomDetailAgainstAgenda(generalMap);
		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";

		} else {
			message = "Record Cant Be Updated !!";

		}

		try {
			map = momworkdetailsearchhandlerservice
					.showMomWorkDetailSearchJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = MOM_WORK_DETAIL_AGENDA_SEARCH;
		title = "update update Mom Detail Agenda";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

}
