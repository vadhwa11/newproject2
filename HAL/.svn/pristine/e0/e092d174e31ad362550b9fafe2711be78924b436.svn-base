package jkt.hms.agendapoints.controller;

import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.TO_DATE;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.agendapoints.handler.AgendaReportHandlerService;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.HMSUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class AgendaReportController extends MultiActionController {

	AgendaReportHandlerService agendaReportHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;

	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	String jsp = "";
	HttpSession session = null;
	String title = "";

	public ModelAndView showAgendaRegister(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "agendaRegister.jsp";
		Map<String, Object> map = new HashMap<String, Object>();
		map = agendaReportHandlerService.showAgendaRegister();
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printAgendaRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fromDate = null;
		Date toDate = null;
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
			parameters.put("fromdate", fromDate);
			parameters.put("todate", toDate);
			Map<String, Object> connectionMap = agendaReportHandlerService
					.getConnectionForReport();

			HMSUtil.generateReport("AgendaRegister", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView showMomRegister(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "momRegister.jsp";
		Map<String, Object> map = new HashMap<String, Object>();
		map = agendaReportHandlerService.showMomRegister();

		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printMomRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fromDate = null;
		Date toDate = null;
		String departmentId = "";
		String dept = "";
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
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals(""))) {
				departmentId = request.getParameter(DEPARTMENT_ID);

			}

			if (!departmentId.equals("")) {
				dept = " and mas_agenda_point_for_work_services.department_name="
						+ departmentId;
			}

			parameters.put("fromdate", fromDate);
			parameters.put("todate", toDate);
			parameters.put("dept", dept);
			Map<String, Object> connectionMap = agendaReportHandlerService
					.getConnectionForReport();

			HMSUtil.generateReport("momRegister", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public AgendaReportHandlerService getAgendaReportHandlerService() {
		return agendaReportHandlerService;
	}

	public void setAgendaReportHandlerService(
			AgendaReportHandlerService agendaReportHandlerService) {
		this.agendaReportHandlerService = agendaReportHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}
