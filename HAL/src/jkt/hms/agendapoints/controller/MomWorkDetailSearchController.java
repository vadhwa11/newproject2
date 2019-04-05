package jkt.hms.agendapoints.controller;

import static jkt.hms.util.RequestConstants.AGENDA_NO;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.MOM_WORK_DETAIL_AGENDA_SEARCH;
import static jkt.hms.util.RequestConstants.TO_DATE;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hms.agendapoints.handler.MomWorkDetailSearchHandlerService;
import jkt.hms.masters.handler.CommonMasterHandlerService;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MomWorkDetailSearchController extends MultiActionController {
	MomWorkDetailSearchHandlerService momWorkDetailSearchHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();

	@SuppressWarnings("unchecked")
	public ModelAndView showMomWorkDetailSearchJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "";
		String title = "";
		map = momWorkDetailSearchHandlerService.showMomWorkDetailSearchJsp();

		jsp += MOM_WORK_DETAIL_AGENDA_SEARCH;

		jsp += ".jsp";
		title = "Mom Work Detail Search";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchMomWorkDetailSearch(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String momWorkDetailSearchCode = null;
		String momWorkDetailSearchName = null;
		String searchField = null;
		String jsp = "";
		String title = "";

		MomWorkDetailSearchDTO momWorkDetailSearchDTO = new MomWorkDetailSearchDTO();
		if (request.getParameter(TO_DATE) != null) {
			String date = request.getParameter(TO_DATE);

			momWorkDetailSearchDTO.setToDate(request.getParameter(TO_DATE));

		}

		if (request.getParameter(FROM_DATE) != null) {
			momWorkDetailSearchDTO.setFromDate(request.getParameter(FROM_DATE));

		}

		if (request.getParameter(AGENDA_NO) != null) {
			momWorkDetailSearchDTO.setMomAgendaNo(request
					.getParameter(AGENDA_NO));

		}

		map = momWorkDetailSearchHandlerService
				.searchMomWorkDetailSearch(momWorkDetailSearchDTO);
		jsp = MOM_WORK_DETAIL_AGENDA_SEARCH;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public MomWorkDetailSearchHandlerService getMomWorkDetailSearchHandlerService() {
		return momWorkDetailSearchHandlerService;
	}

	public void setMomWorkDetailSearchHandlerService(
			MomWorkDetailSearchHandlerService momWorkDetailSearchHandlerService) {
		this.momWorkDetailSearchHandlerService = momWorkDetailSearchHandlerService;
	}

}