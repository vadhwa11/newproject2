package jkt.hms.laundry.controller;

import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.TO_DATE;

import java.math.BigDecimal;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.laundry.handler.LaundryHandlerService;
import jkt.hms.masters.business.CarDiaryEntry;
import jkt.hms.masters.business.MachineActivity;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasLaundryMachine;
import jkt.hms.masters.business.MasLinenWeight;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class LaundryController extends MultiActionController {
	// ----------------------------------------------------------------------------------------------------
	LaundryHandlerService laundryHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;

	public LaundryHandlerService getLaundryHandlerService() {
		return laundryHandlerService;
	}

	public void setLaundryHandlerService(
			LaundryHandlerService laundryHandlerService) {
		this.laundryHandlerService = laundryHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	// ------------------------------------------------------------------------------------------------------
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
	 * ----------------------------------- methods for Laundry
	 * Master-----------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showLaundryJsp(HttpServletRequest request,
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
		map = laundryHandlerService.showLaundryJsp();
		jsp = RequestConstants.LAUNDRY_MASTER;
		jsp += ".jsp";
		title = "Pool Category";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addLaundry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasLaundryMachine masLaundryMachine = new MasLaundryMachine();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String machineName = "";
		if (request.getParameter(RequestConstants.NAME) != null) {
			machineName = request.getParameter(RequestConstants.NAME);
		}
		//System.out.println("machineName    in con " + machineName);
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
		generalMap.put("machineName", machineName);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = laundryHandlerService.checkForExistingMasters(generalMap);

		List machineNameList = new ArrayList();

		if (listMap.get("duplicateGeneralNameList") != null) {
			machineNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if (machineNameList.size() == 0 || machineNameList == null) {

			masLaundryMachine.setMahineName(machineName);
			masLaundryMachine.setStatus("y");
			masLaundryMachine.setLastChgBy(changedBy);
			masLaundryMachine.setLastChgDate(currentDate);
			masLaundryMachine.setLastChgTime(currentTime);
			successfullyAdded = laundryHandlerService
					.addLaundry(masLaundryMachine);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if (machineNameList.size() != 0 || machineNameList != null) {

			message = "Machine Name already exists.";

		}

		try {
			map = laundryHandlerService.showLaundryJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RequestConstants.LAUNDRY_MASTER;
		title = "Add Laundry Machine Master";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editLaundry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String machineName = "";
		int laundryId = 0;
		String changedTime = "";
		Date changedDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			laundryId = Integer.parseInt(request.getParameter(COMMON_ID));
		}

		if (request.getParameter(RequestConstants.NAME) != null
				&& !(request.getParameter(RequestConstants.NAME).equals(""))) {
			machineName = request.getParameter(RequestConstants.NAME);
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

		generalMap.put("id", laundryId);
		generalMap.put("name", machineName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List<MasLaundryMachine> existingMachineNameList = (List<MasLaundryMachine>) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingMachineNameList.size() == 0) {
			dataUpdated = laundryHandlerService.editLaundry(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingMachineNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/laundry?method=showLaundryJsp";

		try {
			map = laundryHandlerService.showLaundryJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RequestConstants.LAUNDRY_MASTER;
		title = "update Laundry Machine Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView deleteLaundry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int laundryId = 0;
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
			laundryId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = laundryHandlerService
				.deleteLaundry(laundryId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/laundry?method=showLaundryJsp";

		try {
			map = laundryHandlerService.showLaundryJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RequestConstants.LAUNDRY_MASTER;
		title = "delete Laundry Machine Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchLaundry(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String machineName = null;
		String searchField = null;

		if (request.getParameter(RequestConstants.NAME) != null
				&& !(request.getParameter(RequestConstants.NAME).equals(""))) {
			machineName = request.getParameter(RequestConstants.NAME);
		}

		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		machineName = searchField;
		map = laundryHandlerService.searchLaundry(machineName);

		jsp = RequestConstants.LAUNDRY_MASTER;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("machineName", machineName);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -----------------------------------------method for Linen Machine
	 * Master----------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showLinenWeightJsp(HttpServletRequest request,
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
		map = laundryHandlerService.showLinenWeightJsp();
		jsp = RequestConstants.LINEN_WEIGHT_MASTER;
		jsp += ".jsp";
		title = "Pool Category";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addLinenWeight(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasLinenWeight masLinen = new MasLinenWeight();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		BigDecimal weight = null;
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}

		if (request.getParameter(RequestConstants.WEIGHT) != null
				&& !request.getParameter(RequestConstants.WEIGHT).equals("")) {
			weight = new BigDecimal(request
					.getParameter(RequestConstants.WEIGHT));

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
		generalMap.put("weight", weight);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List codeList = new ArrayList();
		List nameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			codeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			nameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((codeList.size() == 0 || codeList == null)
				&& (nameList.size() == 0 || nameList == null)) {
			masLinen.setItemCode(code);
			masLinen.setItemName(name);
			masLinen.setWeight(weight);
			masLinen.setStatus("y");
			masLinen.setLastChgBy(changedBy);
			masLinen.setLastChgDate(currentDate);
			masLinen.setLastChgTime(currentTime);
			successfullyAdded = laundryHandlerService.addLinenWeight(masLinen);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((codeList.size() != 0 || codeList != null)
				|| (nameList.size() != 0) || nameList != null) {
			if ((codeList.size() != 0 || codeList != null)
					&& (nameList.size() == 0 || nameList == null)) {

				message = "Item Code  already exists.";
			} else if ((nameList.size() != 0 || nameList != null)
					&& (codeList.size() == 0 || codeList == null)) {

				message = "Item Name already exists.";
			} else if ((codeList.size() != 0 || codeList != null)
					&& (nameList.size() != 0 || nameList != null)) {

				message = "Item Code and Item Name already exist.";
			}
		}

		try {
			map = laundryHandlerService.showLinenWeightJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RequestConstants.LINEN_WEIGHT_MASTER;
		title = "Add Linen Weight Master";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editLinenWeight(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String name = "";
		String code = "";
		BigDecimal weight = null;
		int linenId = 0;
		String changedTime = "";
		Date changedDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			linenId = Integer.parseInt(request.getParameter(COMMON_ID));
		}

		if (request.getParameter(RequestConstants.SEARCH_NAME) != null
				&& !(request.getParameter(RequestConstants.SEARCH_NAME)
						.equals(""))) {
			name = request.getParameter(RequestConstants.SEARCH_NAME);
		}
		if (request.getParameter(RequestConstants.CODE) != null
				&& !(request.getParameter(RequestConstants.CODE).equals(""))) {
			code = request.getParameter(RequestConstants.CODE);
		}
		if (request.getParameter(RequestConstants.WEIGHT) != null
				&& !request.getParameter(RequestConstants.WEIGHT).equals("")) {
			weight = new BigDecimal(request
					.getParameter(RequestConstants.WEIGHT));

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

		generalMap.put("id", linenId);
		generalMap.put("name", name);
		generalMap.put("code", code);
		generalMap.put("weight", weight);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List<MasLinenWeight> existingLinenWeightList = (List<MasLinenWeight>) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingLinenWeightList.size() == 0) {
			dataUpdated = laundryHandlerService.editLinenWeight(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingLinenWeightList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/laundry?method=showLinenWeightJsp";

		try {
			map = laundryHandlerService.showLinenWeightJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RequestConstants.LINEN_WEIGHT_MASTER;
		title = "update Linen Weight Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView deleteLinenWeight(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int linenId = 0;
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
			linenId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = laundryHandlerService.deleteLinenWeight(linenId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/laundry?method=showLinenWeightJsp";

		try {
			map = laundryHandlerService.showLinenWeightJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RequestConstants.LINEN_WEIGHT_MASTER;
		title = "delete Linen Weight Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchLinenWeight(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String linenCode = null;
		String linenName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			linenCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			linenName = request.getParameter(SEARCH_NAME);
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
			linenCode = searchField;
			linenName = null;

		} else {
			linenCode = null;
			linenName = searchField;
		}
		map = laundryHandlerService.searchLinenWeight(linenCode, linenName);

		jsp = RequestConstants.LINEN_WEIGHT_MASTER;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("linenCode", linenCode);
		map.put("linenName", linenName);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ----------------------------------method for Machine Activity
	 * Enter----------------------------------
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView showMachineActivityEntry(HttpServletRequest request,HttpServletResponse response) {
		String userName = "";
		String entryNo = "";
		int deptId = 0;
		int hospitalId = 0;
		session = request.getSession();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		map = laundryHandlerService.showMachineActivityEntry();
		entryNo = request.getParameter("entryNo");
		entryNo = laundryHandlerService.getEntryNumber(entryNo);
		//System.out.println("entryNo---> "+entryNo);
		if (entryNo != "") {
			map.put("entryNo", entryNo);
		}
		jsp = RequestConstants.MACHINE_ACTIVITY_ENTRY;
		jsp += ".jsp";
		title = "Machine Activity Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("entryNo", entryNo);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addMachineActivity(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MachineActivity machineActivity = new MachineActivity();
		Date currentDate = new Date();
		String entryNo = "";
		Date entryDate = new Date();
		Date activityDate = new Date();
		int machineName = 0;
		String timeOn = "";
		String timeOff = "";
		String totalTime = "";

		if (request.getParameter("entryNo") != null) {
			entryNo = request.getParameter("entryNo");
		}
		if (request.getParameter(RequestConstants.ENTRY_DATE) != null
				&& !(request.getParameter(RequestConstants.ENTRY_DATE)
						.equals(""))) {
			entryDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(RequestConstants.ENTRY_DATE));
		}
		if (request.getParameter(RequestConstants.MACHINE_NAME) != null
				&& !(request.getParameter(RequestConstants.MACHINE_NAME)
						.equals(""))) {
			machineName = Integer.parseInt(request
					.getParameter(RequestConstants.MACHINE_NAME));
		}
		if (request.getParameter(RequestConstants.ACTIVITY_DATE) != null
				&& !(request.getParameter(RequestConstants.ACTIVITY_DATE)
						.equals(""))) {
			activityDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(RequestConstants.ACTIVITY_DATE));
		}

		if (request.getParameter(RequestConstants.TIME_ON) != null) {
			timeOn = request.getParameter(RequestConstants.TIME_ON);
		}
		if (request.getParameter(RequestConstants.TIME_OFF) != null) {
			timeOff = request.getParameter(RequestConstants.TIME_OFF);
		}
		if (request.getParameter(RequestConstants.TOTAL_HOURS) != null) {
			totalTime = request.getParameter(RequestConstants.TOTAL_HOURS);
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

		boolean successfullyAdded = true;

		machineActivity.setActivityDate(activityDate);
		machineActivity.setEntryNo(entryNo);
		machineActivity.setEntryDate(entryDate);
		machineActivity.setTimeOff(timeOff);
		machineActivity.setTimeOn(timeOn);
		machineActivity.setTotalHrs(totalTime);
		MasLaundryMachine masLaundry = new MasLaundryMachine();
		masLaundry.setId(machineName);
		machineActivity.setMachine(masLaundry);
		machineActivity.setLastChgBy(changedBy);
		machineActivity.setLastChgDate(currentDate);
		machineActivity.setLastChgTime(currentTime);
		machineActivity.setStatus("y");
		successfullyAdded = laundryHandlerService.addMachineActivityEntry(machineActivity);
		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}

		try {
			Map<String, Object> diagMap = new HashMap<String, Object>();
			entryNo = laundryHandlerService.generateEntryNumber(diagMap);
			entryNo = request.getParameter("entryNo");
			entryNo = laundryHandlerService.getEntryNumber(entryNo);
			map = laundryHandlerService.showMachineActivityEntry();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RequestConstants.MACHINE_ACTIVITY_ENTRY;
		title = "Machine Activity Entry";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("entryNo", entryNo);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editMachineActivity(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		int machineActivityId = 0;
		Date currentDate = new Date();
		Date entryDate = new Date();
		Date activityDate = new Date();
		int machineName = 0;
		String timeOn = "";
		String timeOff = "";
		String totalTime = "";
		String entry = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			machineActivityId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(RequestConstants.ENTRY_NO) != null
				&& !(request.getParameter(RequestConstants.ENTRY_NO).equals(""))) {
			entry = request.getParameter(RequestConstants.ENTRY_NO);
		}
		if (request.getParameter(RequestConstants.ENTRY_DATE) != null
				&& !(request.getParameter(RequestConstants.ENTRY_DATE)
						.equals(""))) {
			entryDate = HMSUtil.dateFormatterddmmyy(request
					.getParameter(RequestConstants.ENTRY_DATE));
		}
		if (request.getParameter(RequestConstants.MACHINE_NAME) != null
				&& !(request.getParameter(RequestConstants.MACHINE_NAME)
						.equals(""))) {
			machineName = Integer.parseInt(request
					.getParameter(RequestConstants.MACHINE_NAME));
		}
		if (request.getParameter(RequestConstants.ACTIVITY_DATE) != null
				&& !(request.getParameter(RequestConstants.ACTIVITY_DATE)
						.equals(""))) {
			activityDate = HMSUtil.dateFormatterddmmyy(request
					.getParameter(RequestConstants.ACTIVITY_DATE));
		}

		if (request.getParameter(RequestConstants.TIME_ON) != null) {
			timeOn = request.getParameter(RequestConstants.TIME_ON);
		}
		if (request.getParameter(RequestConstants.TIME_OFF) != null) {
			timeOff = request.getParameter(RequestConstants.TIME_OFF);
		}
		if (request.getParameter(RequestConstants.TOTAL_HOURS) != null) {
			totalTime = request.getParameter(RequestConstants.TOTAL_HOURS);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}

		Date changedDate = null;
		String changedTime = null;
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(	"currentTime");
		generalMap.put("id", machineActivityId);
		generalMap.put("entryDate", entryDate);
		generalMap.put("machineName", machineName);
		generalMap.put("activityDate", activityDate);
		generalMap.put("timeOn", timeOn);
		generalMap.put("timeOff", timeOff);
		generalMap.put("totalTime", totalTime);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("entry", entry);
		//System.out.println("entry000------------------>"+entry);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		Map<String, Object> diagMap = new HashMap<String, Object>();
		// listMap =
		// commonMasterHandlerService.checkForExistingMasters(generalMap);
		// List<MachineActivity> existingLinenWeightList =
		// (List<MachineActivity>)
		// listMap.get("duplicateMastersList");
		boolean dataUpdated = false;
		// if (existingLinenWeightList.size() == 0)
		// {
		dataUpdated = laundryHandlerService.editMachineActivity(generalMap);
//		entryNo = laundryHandlerService.generateEntryNumber(diagMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant Be Updated !!";
		}
		// } else if (existingLinenWeightList.size() > 0)
		// {
		// message = "Name already exists.";
		// }
		url = "/hms/hms/laundry?method=showMachineActivityEntry";
		try {
			map = laundryHandlerService.showMachineActivityEntry();

		} catch (Exception e) {
			e.printStackTrace();
		}
		String entryNo = request.getParameter("entryNo");
		entryNo = laundryHandlerService.getEntryNumber(entryNo);
		if (entryNo != "") {
			map.put("entryNo", entryNo);
		}
		jsp = RequestConstants.MACHINE_ACTIVITY_ENTRY;
		title = "update Machine Activity Entry";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView deleteMachineActivity(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int machineActivityId = 0;
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
			machineActivityId = Integer.parseInt(request
					.getParameter(COMMON_ID));
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
		dataDeleted = laundryHandlerService.deleteMachineActivity(
				machineActivityId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/laundry?method=showMachineActivityEntry";

		try {
			map = laundryHandlerService.showMachineActivityEntry();

		} catch (Exception e) {
			e.printStackTrace();
		}
		String entryNo = request.getParameter("entryNo");
		entryNo = laundryHandlerService.getEntryNumber(entryNo);
		if (entryNo != "") {
			map.put("entryNo", entryNo);
		}
		jsp = RequestConstants.MACHINE_ACTIVITY_ENTRY;
		title = "delete Activity Entry";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchMachineActivity(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		Date entryDate = new Date();
		String entryId = "";
		if (request.getParameter(RequestConstants.DATE) != null
				&& !(request.getParameter(RequestConstants.DATE).equals(""))) {
			entryDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(RequestConstants.DATE));
			mapForDs.put("entryDate", entryDate);
		}
		if (request.getParameter(RequestConstants.ENTRY_ID) != null
				&& !(request.getParameter(RequestConstants.ENTRY_ID).equals(""))) {
			entryId = (request.getParameter(RequestConstants.ENTRY_ID));
			mapForDs.put("entryId", entryId);
		}
		map = laundryHandlerService.searchMachineActivity(entryId, entryDate);
		String entryNo = request.getParameter("entryNo");
		entryNo = laundryHandlerService.getEntryNumber(entryNo);
		if (entryNo != "") {
			map.put("entryNo", entryNo);
		}
		//System.out.println("entryNo---->"+entryNo);	
		jsp = RequestConstants.MACHINE_ACTIVITY_ENTRY;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("entryId", entryId);
		map.put("entryDate", entryDate);
		map.put("search", "search");
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showCarDiaryEntry(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		String entryNo = "";
		int deptId = 0;
		int hospitalId = 0;
		session = request.getSession();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		map = laundryHandlerService.showCarDiaryEntry();
		entryNo = request.getParameter("entryNo");
		entryNo = laundryHandlerService.getEntryNumberForDiaryEntry(entryNo);
		if (entryNo != "") {
			map.put("entryNo", entryNo);
		}
		
		jsp = RequestConstants.CAR_DIARY_ENTRY;
		jsp += ".jsp";
		title = "Car Diary Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("entryNo", entryNo);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addCarDiaryEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		CarDiaryEntry carDiaryEntry = new CarDiaryEntry();
		Date currentDate = new Date();
		String entryNo = "";
		Date entryDate = new Date();
		String specification = "";
		String fromPlace = "";
		String toPlace = "";
		BigDecimal totalKm = null;
		int deptId = 0;
		int hospitalId = 0;

		HttpSession session = request.getSession();

		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (request.getParameter("entryNo") != null) {
			entryNo = request.getParameter("entryNo");
		}
		if (request.getParameter(RequestConstants.ENTRY_DATE) != null
				&& !(request.getParameter(RequestConstants.ENTRY_DATE)
						.equals(""))) {
			entryDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(RequestConstants.ENTRY_DATE));
		}
		if (request.getParameter(RequestConstants.SPECIFICATION_OF_DUTY) != null
				&& !(request
						.getParameter(RequestConstants.SPECIFICATION_OF_DUTY)
						.equals(""))) {
			specification = (request
					.getParameter(RequestConstants.SPECIFICATION_OF_DUTY));
		}

		if (request.getParameter(RequestConstants.FROM_PLACE) != null) {
			fromPlace = request.getParameter(RequestConstants.FROM_PLACE);
		}
		if (request.getParameter(RequestConstants.TO_PLACE) != null) {
			toPlace = request.getParameter(RequestConstants.TO_PLACE);
		}
		if (request.getParameter(RequestConstants.TOTAL_KM) != null
				&& !request.getParameter(RequestConstants.TOTAL_KM).equals("")) {
			totalKm = new BigDecimal(request
					.getParameter(RequestConstants.TOTAL_KM));

		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
				
		String now = (String)request.getParameter(CHANGED_DATE);
		String Now = now.replace("-","/");
		if (request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
		}
		//System.out.println("request.getParameter(CHANGED_DATE)after --->" +currentDate+"::"+Now);
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		boolean successfullyAdded = true;

		carDiaryEntry.setEntryNo(entryNo);
		carDiaryEntry.setEntryDate(entryDate);
		carDiaryEntry.setSpecificationOfDuty(specification);
		carDiaryEntry.setToPlace(toPlace);
		carDiaryEntry.setFromPlace(fromPlace);
		carDiaryEntry.setTotalKm(totalKm);

		MasDepartment masDept = new MasDepartment();
		masDept.setId(deptId);
		carDiaryEntry.setDepartment(masDept);

		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		carDiaryEntry.setHospital(masHospital);
		carDiaryEntry.setLastChgBy(changedBy);
		carDiaryEntry.setLastChgDate(currentDate);
		carDiaryEntry.setLastChgTime(currentTime);
		carDiaryEntry.setStatus("y");
		//System.out.println("currentDate--->"+currentDate);
		successfullyAdded = laundryHandlerService.addCarDiaryEntry(carDiaryEntry);
		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}

		try {
			Map<String, Object> diagMap = new HashMap<String, Object>();
			String temp = laundryHandlerService.generateEntryNumberForDiaryEntry(diagMap);
			entryNo = request.getParameter("entryNo");
			entryNo = laundryHandlerService.getEntryNumberForDiaryEntry(entryNo);
			map = laundryHandlerService.showCarDiaryEntry();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RequestConstants.CAR_DIARY_ENTRY;
		title = "Car diary Entry";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("entryNo", entryNo);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------- method to delete car diary entry-----------------
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView deleteCarDiaryEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int carEntryId = 0;
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
			carEntryId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = laundryHandlerService.deleteCarDiaryEntry(carEntryId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/laundry?method=showCarDiaryEntry";

		try {
			map = laundryHandlerService.showCarDiaryEntry();

		} catch (Exception e) {
			e.printStackTrace();
		}
		String entryNo = request.getParameter("entryNo");
		entryNo = laundryHandlerService.getEntryNumberForDiaryEntry(entryNo);
		if (entryNo != "") {
			map.put("entryNo", entryNo);
		}
		jsp = RequestConstants.CAR_DIARY_ENTRY;
		title = "delete car Diary Entry";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editCarDiaryEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		int carEntryId = 0;
		Date currentDate = new Date();
		Date entryDate = new Date();
		String specification = "";
		String fromPlace = "";
		String toPlace = "";
		BigDecimal totalKm = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			carEntryId = Integer.parseInt(request.getParameter(COMMON_ID));
		}

		if (request.getParameter(RequestConstants.ENTRY_DATE) != null
				&& !(request.getParameter(RequestConstants.ENTRY_DATE)
						.equals(""))) {
			entryDate = HMSUtil.dateFormatterddmmyy(request
					.getParameter(RequestConstants.ENTRY_DATE));
		}
		if (request.getParameter(RequestConstants.SPECIFICATION_OF_DUTY) != null
				&& !(request
						.getParameter(RequestConstants.SPECIFICATION_OF_DUTY)
						.equals(""))) {
			specification = (request
					.getParameter(RequestConstants.SPECIFICATION_OF_DUTY));
		}

		if (request.getParameter(RequestConstants.FROM_PLACE) != null) {
			fromPlace = request.getParameter(RequestConstants.FROM_PLACE);
		}
		if (request.getParameter(RequestConstants.TO_PLACE) != null) {
			toPlace = request.getParameter(RequestConstants.TO_PLACE);
		}
		if (request.getParameter(RequestConstants.TOTAL_KM) != null
				&& !request.getParameter(RequestConstants.TOTAL_KM).equals("")) {
			totalKm = new BigDecimal(request
					.getParameter(RequestConstants.TOTAL_KM));

		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}

		String changedTime = null;
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("id", carEntryId);
		generalMap.put("entryDate", entryDate);
		generalMap.put("specification", specification);
		generalMap.put("fromPlace", fromPlace);
		generalMap.put("toPlace", toPlace);
		generalMap.put("totalKm", totalKm);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		// listMap =
		// commonMasterHandlerService.checkForExistingMasters(generalMap);
		// List<MachineActivity> existingLinenWeightList =
		// (List<MachineActivity>)
		// listMap.get("duplicateMastersList");
		boolean dataUpdated = false;
		// if (existingLinenWeightList.size() == 0)
		// {
		dataUpdated = laundryHandlerService.editCarDiaryEntry(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant Be Updated !!";
		}
		// } else if (existingLinenWeightList.size() > 0)
		// {
		// message = "Name already exists.";
		// }
		url = "/hms/hms/laundry?method=showCarDiaryEntry";

		try {
			map = laundryHandlerService.showCarDiaryEntry();

		} catch (Exception e) {
			e.printStackTrace();
		}
		String entryNo = request.getParameter("entryNo");
		entryNo = laundryHandlerService.getEntryNumberForDiaryEntry(entryNo);
		if (entryNo != "") {
			map.put("entryNo", entryNo);
		}
		jsp = RequestConstants.CAR_DIARY_ENTRY;
		title = "update Car Diary Entry";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchCarDiaryEntry(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Date entryDate = new Date();
		String entryId = "";
		if (request.getParameter(RequestConstants.DATE) != null
				&& !(request.getParameter(RequestConstants.DATE).equals(""))) {
			entryDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(RequestConstants.DATE));
			mapForDs.put("entryDate", entryDate);
		}
		if (request.getParameter(RequestConstants.ENTRY_ID) != null
				&& !(request.getParameter(RequestConstants.ENTRY_ID).equals(""))) {
			entryId = (request.getParameter(RequestConstants.ENTRY_ID));
			mapForDs.put("entryId", entryId);
		}
		
		map = laundryHandlerService.searchCarDiaryEntry(entryId, entryDate);
		String entryNo = request.getParameter("entryNo");
		entryNo = laundryHandlerService.getEntryNumberForDiaryEntry(entryNo);
		if (entryNo != "") {
			map.put("entryNo", entryNo);
		}
	
		jsp = RequestConstants.CAR_DIARY_ENTRY;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("entryNo", entryNo);
		map.put("entryDate", entryDate);
		map.put("search", "search");
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------------- method to show Daily work load entry
	 * ----------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showDailyWorkLoad(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String entryNo = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		map = laundryHandlerService.showDailyWorkLoad();
		entryNo = request.getParameter("entryNo");
		entryNo = laundryHandlerService.getEntryNumberForWorkLoad(entryNo);
		if (entryNo != "") {
			map.put("entryNo", entryNo);
		}
		jsp = RequestConstants.DAILY_WORK_LOAD;
		jsp += ".jsp";
		title = "Daily WOrk Load Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getItemListByAutocomplete(HttpServletRequest request,
			HttpServletResponse response) {

		session = request.getSession();
		String itemNameField = "";
		String autoHint = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("requiredField") != null) {
			itemNameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(itemNameField) != null) {
			autoHint = (request.getParameter(itemNameField));

		}
		dataMap.put("autoHint", autoHint);
		map = laundryHandlerService.getItemListByAutocomplete(dataMap);
		jsp = "resultForItem";
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchDailyWorkLoadEntry(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		Map<String, Object> diagMap = new HashMap<String, Object>();
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		Date entryDate = new Date();
		String entryNo = "";
		if (request.getParameter(RequestConstants.DATE) != null
				&& !(request.getParameter(RequestConstants.DATE).equals(""))) {
			entryDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(RequestConstants.DATE));
			diagMap.put("entryDate", entryDate);
		}
		if (request.getParameter(RequestConstants.ENTRY_ID) != null
				&& !(request.getParameter(RequestConstants.ENTRY_ID).equals(""))) {
			entryNo = (request.getParameter(RequestConstants.ENTRY_ID));
			diagMap.put("entryNo", entryNo);
		}
		//System.out.println("entryNo--->"+entryNo);
		map = laundryHandlerService.getDailyWorkLoad(entryNo, entryDate);
		if (entryNo != "") {
			map.put("entryNo", entryNo);
		}
		jsp = RequestConstants.SEARCH_DAILY_WORK_LOAD;
		jsp += ".jsp";
		title = "Daily Work Load Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ---------------------- method to add daily work load
	 * entry---------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView addDailyWorkLoadEntry(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		boolean saved = false;
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		String url = "";
		String entryNo = "";
		map = laundryHandlerService.addDailyWorkLoadEntry(box, dataMap);
		saved = (Boolean) map.get("saved");
		if (saved == true) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}
		String temp = laundryHandlerService.generateEntryNumberForDailyWorkLoad(diagMap);
		entryNo = request.getParameter("entryNo");
		entryNo = laundryHandlerService.getEntryNumberForWorkLoad(entryNo);
		map = laundryHandlerService.showDailyWorkLoad();
		if (entryNo != "") {
			map.put("entryNo", entryNo);
		}
		jsp = RequestConstants.DAILY_WORK_LOAD;
		jsp += ".jsp";
		title = "Daily Work Load Entry";
		url = "/hms/hms/laundry?method=showDailyWorkLoad";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("url", url);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public void fillItems(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String itemName = "";
		List<MasLinenWeight> itemList = new ArrayList<MasLinenWeight>();
		try {
			if (request.getParameter(RequestConstants.ITEM_NAME) != null) {
				itemName = request.getParameter(RequestConstants.ITEM_NAME);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("itemName", itemName);

		map = laundryHandlerService.fillItems(dataMap);
		if (map.get("itemList") != null) {
			itemList = (List<MasLinenWeight>) map.get("itemList");
		}
		StringBuffer sb = new StringBuffer();

		sb.append("<items>");
		for (MasLinenWeight masLinen : itemList) {
			sb.append("<item>");
			sb.append("<itemId>" + masLinen.getId() + "</itemId>");
			sb.append("<itemName>" + masLinen.getItemName() + "</itemName>");
			sb.append("</item>");
		}
		sb.append("</items>");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editDailyWorkLoadEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		boolean saved = false;
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		String url = "";
		String entryNo = "";
		map = laundryHandlerService.editDailyWorkLoadEntry(box, dataMap);
		saved = (Boolean) map.get("saved");
		if (saved == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Try Again !!";
		}

		map = laundryHandlerService.showDailyWorkLoad();
		entryNo = laundryHandlerService.generateEntryNumberForDiaryEntry(diagMap);
		entryNo = laundryHandlerService.getEntryNumberForWorkLoad(entryNo);
		if (entryNo != "") {
			map.put("entryNo", entryNo);
		}

		jsp = RequestConstants.DAILY_WORK_LOAD;
		jsp += ".jsp";
		title = "Daily Work Load Entry";
		url = "/hms/hms/laundry?method=showDailyWorkLoad";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("url", url);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ===============================METHODS FOR REPORTS
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView machineActivityRegister(HttpServletRequest request,
			HttpServletResponse response) {
		map = laundryHandlerService.showMachineActivityEntry();
		jsp = "machineActivityReport";
		jsp += ".jsp";
		title = "Machine Activity Register";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView carDiaryRegister(HttpServletRequest request,
			HttpServletResponse response) {
		jsp = "carDiaryReport";
		jsp += ".jsp";
		title = "Car diary Entry Register";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView dailyWorkRegister(HttpServletRequest request,
			HttpServletResponse response) {
		jsp = "dailyWorkLoadReport";
		jsp += ".jsp";
		title = "Daily Workload Register";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView workLoadRegisterDeptWise(HttpServletRequest request,
			HttpServletResponse response) {
		map = laundryHandlerService.showDailyWorkLoad();
		jsp = "dailyReportDeptWise";
		jsp += ".jsp";
		title = "Daily Workload Register Ward/Department wise";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView generateMachineActivityReport(
			HttpServletRequest request, HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();
		int machineName = 0;
		String query = "";
		Integer deptId = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//ServletContext context = request.getSession().getServletContext();

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
			}

			query = " where machine_activity.entry_date between '" + fromDate
					+ "' and '" + toDate + "'";

			if (request.getParameter(RequestConstants.MACHINE_NAME) != null
					&& !(request.getParameter(RequestConstants.MACHINE_NAME)
							.equals("0"))) {
				machineName = Integer.parseInt(request
						.getParameter(RequestConstants.MACHINE_NAME));
				query = query + " and machine_activity.`machine_id` = "
						+ machineName;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = laundryHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("machineName", machineName);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		try {

			HMSUtil.generateReport("machine_Activity_Register", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView generateCarDiaryReport(HttpServletRequest request,
			HttpServletResponse response) {
		Date fromDate = null;
		Date toDate = null;
		String query = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		/*
		 * try { if (request.getParameter(FROM_DATE) != null &&
		 * !(request.getParameter(FROM_DATE).equals(""))) { fromDate =
		 * sdf.format
		 * (HMSUtil.convertStringTypeDateToDateType(request.getParameter
		 * (FROM_DATE))); } //System.out.println("fromDate ---     " + fromDate);
		 * if (request.getParameter(TO_DATE) != null &&
		 * !(request.getParameter(TO_DATE).equals(""))) { toDate =
		 * sdf.format(HMSUtil
		 * .convertStringTypeDateToDateType(request.getParameter(TO_DATE))); }
		 */

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
			}

			query = " where car_diary_entry.entry_date between '" + fromDate
					+ "' and '" + toDate + "'";

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = laundryHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("QUERY", query);
		try {

			HMSUtil.generateReport("driver_car_diary_register", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView linenWeight(HttpServletRequest request,
			HttpServletResponse response) {

		String query = "";

		try {

			query = " select * from mas_linen_weight";

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = laundryHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("QUERY", query);
		try {

			HMSUtil.generateReport("linene_weight_master", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		@SuppressWarnings("unchecked")
	public ModelAndView generateDailyWorkReport(HttpServletRequest request,
			HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();
		String query = "";

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
			}

			query = " where  work_load_entry.entry_date between '" + fromDate
					+ "' and '" + toDate + "'";

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = laundryHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("QUERY", query);
		try {

			HMSUtil.generateReport("daily_workload_register", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView generateDailyReportDeptWise(HttpServletRequest request,
			HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();
		int deptId = 0;
		String query = "";

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
			}

			query = " where work_load_entry_detail.work_load_id.entry_date between '"
					+ fromDate + "' and '" + toDate + "'";

			if (request.getParameter(RequestConstants.DEPARTMENT_ID) != null
					&& !(request.getParameter(RequestConstants.DEPARTMENT_ID)
							.equals("0"))) {
				deptId = Integer.parseInt(request
						.getParameter(RequestConstants.DEPARTMENT_ID));
				//System.out.println("deptId :  " + deptId);
				query = query + " AND work_load_entry_detail.department_id = "
						+ deptId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = laundryHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("P_department_id", deptId);
		parameters.put("QUERY", query);
		try {

			HMSUtil.generateReport(
					"daily_workload_register_ward_departmentwise", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


//------------------------- Report BY mansi

@SuppressWarnings("unchecked")
public ModelAndView  laundryMachine(HttpServletRequest request,
		HttpServletResponse response) {

	String query = "";

	try {

		query = " select * from mas_laundry_machine";

	} catch (Exception e) {
		e.printStackTrace();
	}
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	detailsMap = laundryHandlerService.getConnectionForReport();
	Map<String, Object> parameters = new HashMap<String, Object>();
	parameters.put("QUERY", query);
	try {

		HMSUtil.generateReport("Mas_laundry_machine", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}
}
