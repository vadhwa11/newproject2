package jkt.hms.agendapoints.controller;

import static jkt.hms.util.RequestConstants.AGENDA_NO;
import static jkt.hms.util.RequestConstants.AGENDA_POINT_UPDATE_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.TO_DATE;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hms.agendapoints.handler.AgendaPointUpdateSearchHandlerService;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class AgendaPointUpdateSearchController extends MultiActionController {
	private AgendaPointUpdateSearchHandlerService agendaPointUpdateSearchHandlerService = null;

	@SuppressWarnings("unchecked")
	public ModelAndView showAgendaPointSearchJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		//System.out.println("in controller");
		map = agendaPointUpdateSearchHandlerService.showAgendaPointSearchJsp();
		jsp += AGENDA_POINT_UPDATE_SEARCH_JSP;
		jsp += ".jsp";
		title = "Agenda Points update Search";
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
		AgendaPointUpdateSearchDTO agendaPointSearchDTO = new AgendaPointUpdateSearchDTO();
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

		map = agendaPointUpdateSearchHandlerService
				.searchAgendaPointSearch(agendaPointSearchDTO);
		jsp = AGENDA_POINT_UPDATE_SEARCH_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public AgendaPointUpdateSearchHandlerService getAgendaPointUpdateSearchHandlerService() {
		return agendaPointUpdateSearchHandlerService;
	}

	public void setAgendaPointUpdateSearchHandlerService(
			AgendaPointUpdateSearchHandlerService agendaPointUpdateSearchHandlerService) {
		this.agendaPointUpdateSearchHandlerService = agendaPointUpdateSearchHandlerService;
	}

}
