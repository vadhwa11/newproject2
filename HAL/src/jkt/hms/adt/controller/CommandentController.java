package jkt.hms.adt.controller;

import static jkt.hms.util.RequestConstants.BED_STATE;
import static jkt.hms.util.RequestConstants.TODAY_ADMISSION;
import static jkt.hms.util.RequestConstants.TODAY_SILDIL;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hms.adt.handler.CommandentHandlerService;
import jkt.hms.masters.business.Inpatient;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class CommandentController extends MultiActionController {

	CommandentHandlerService commandentHandlerService = null;

	/**
	 *---------------------------------------- Today Admission
	 * ------------------------------- made by Mansi Gagrani on 24-june-08
	 * 
	 **/

	public ModelAndView showTodayAdmissionJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		Date currentDate = new Date();
		int deptId = 0;
		if (request.getParameter("parent") != null
				&& !request.getParameter("parent").equals("0")) {
			deptId = Integer.parseInt(request.getParameter("parent"));
		}
		map.put("currentDate", currentDate);
		map.put("deptId", deptId);
		inpatientList = commandentHandlerService.showTodayAdmission(map);
		jsp = TODAY_ADMISSION;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("inpatientList", inpatientList);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 *---------------------------------------- Today SIL/DIL
	 * ------------------------------- made by Mansi Gagrani on 24-june-08
	 * 
	 **/

	public ModelAndView showTodaySILDILJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		List<Inpatient> silDilStatusList = new ArrayList<Inpatient>();
		Date currentDate = new Date();
		int deptId = 0;

		if (request.getParameter("parent") != null
				&& !request.getParameter("parent").equals("")) {
			deptId = Integer.parseInt(request.getParameter("parent"));
		}
		map.put("currentDate", currentDate);
		map.put("deptId", deptId);
		silDilStatusList = commandentHandlerService.showTodaySILDILJsp(map);
		jsp = TODAY_SILDIL;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("silDilStatusList", silDilStatusList);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 *---------------------------------------- ADT BED STATE
	 * ------------------------------- made by Priyanka Garg on 25-june-08
	 * 
	 * @return
	 */

	public ModelAndView showBedStateJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		Date currentDate = new Date();
		map.put("currentDate", currentDate);

		map = commandentHandlerService.showBedStateJsp(map);
		jsp = BED_STATE;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("indexB", "map", map);
	}

	public CommandentHandlerService getCommandentHandlerService() {
		return commandentHandlerService;
	}

	public void setCommandentHandlerService(
			CommandentHandlerService commandentHandlerService) {
		this.commandentHandlerService = commandentHandlerService;
	}
}