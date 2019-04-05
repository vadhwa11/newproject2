package jkt.hms.agendapoints.controller;

import static jkt.hms.util.RequestConstants.AGENDA_NO;
import static jkt.hms.util.RequestConstants.AGENDA_POINT_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.TO_DATE;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hms.agendapoints.handler.AgendaPointSearchHandlerService;
import jkt.hms.masters.handler.CommonMasterHandlerService;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class AgendaPointSearchController extends MultiActionController {
	AgendaPointSearchHandlerService agendaPointSearchHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;

	@SuppressWarnings("unchecked")
	public ModelAndView showAgendaPointSearchJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		map = agendaPointSearchHandlerService.showAgendaPointSearchJsp();
		jsp += AGENDA_POINT_SEARCH_JSP;
		jsp += ".jsp";
		title = "Agenda Points Search";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchAgendaPointSearch(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		AgendaPointSearchDTO agendaPointSearchDTO = new AgendaPointSearchDTO();
		if (request.getParameter(TO_DATE) != null
				&& !request.getParameter(TO_DATE).equalsIgnoreCase("")) {
			agendaPointSearchDTO.setToDate(request.getParameter(TO_DATE));
		}
		if (!request.getParameter(FROM_DATE).equalsIgnoreCase("")
				&& request.getParameter(FROM_DATE) != null) {
			agendaPointSearchDTO.setFromDate(request.getParameter(FROM_DATE));
		}

		if (!request.getParameter(AGENDA_NO).equalsIgnoreCase("")
				&& request.getParameter(AGENDA_NO) != null) {
			agendaPointSearchDTO.setAgendaNo(request.getParameter(AGENDA_NO));
		}

		map = agendaPointSearchHandlerService
				.searchAgendaPointSearch(agendaPointSearchDTO);
		jsp = AGENDA_POINT_SEARCH_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	public AgendaPointSearchHandlerService getAgendaPointSearchHandlerService() {
		return agendaPointSearchHandlerService;
	}

	public void setAgendaPointSearchHandlerService(
			AgendaPointSearchHandlerService agendaPointSearchHandlerService) {
		this.agendaPointSearchHandlerService = agendaPointSearchHandlerService;
	}

}