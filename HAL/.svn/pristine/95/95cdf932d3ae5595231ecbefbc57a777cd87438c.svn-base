/**  
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Class CssdController.java 
 *  
 * Tables Used: 
 * @author  Create Date: 20.05.2009  Name: Othivadivel K R 
 * Revision Date:      		Revision By: 
 * @version 1.0  
 * @see 
 **/

package jkt.hms.cssd.controller;

import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.CSSD_AUTOCLAVE_ENTRY_DETAIL_JSP;
import static jkt.hms.util.RequestConstants.CSSD_AUTOCLAVE_ENTRY_DETAIL_RESPONSE_JSP;
import static jkt.hms.util.RequestConstants.CSSD_AUTOCLAVE_ENTRY_JSP;
import static jkt.hms.util.RequestConstants.CSSD_AUTOCLAVE_MATERIAL_LIST;
import static jkt.hms.util.RequestConstants.CSSD_AUTOCLAVE_RECALL_JSP;
import static jkt.hms.util.RequestConstants.CSSD_AUTOCLAVE_RECALL_RESPONSE_JSP;
import static jkt.hms.util.RequestConstants.CSSD_AUTOCLAVE_RECEIPT_JSP;
import static jkt.hms.util.RequestConstants.CSSD_AUTOCLAVE_RECEIPT_RESPONSE_JSP;
import static jkt.hms.util.RequestConstants.CSSD_AUTOCLAVE_REQUEST_JSP;
import static jkt.hms.util.RequestConstants.CSSD_AUTOCLAVE_REQUEST_RECEIPT_REGISTER;
import static jkt.hms.util.RequestConstants.CSSD_AUTOCLAVE_REQUEST_RESPONSE_JSP;
import static jkt.hms.util.RequestConstants.CSSD_INSTRUMENT_MASTER_JSP;
import static jkt.hms.util.RequestConstants.CSSD_MATERIAL_MASTER_JSP;
import static jkt.hms.util.RequestConstants.CSSD_MATERIAL_STOCK_JSP;
import static jkt.hms.util.RequestConstants.CSSD_STOCK_RESPONSE_JSP;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.TO_DATE;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.cssd.handler.CssdHandlerService;
import jkt.hms.masters.business.CssdInstrumentMaster;
import jkt.hms.masters.business.CssdMaterialMaster;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class CssdController extends MultiActionController {

	CssdHandlerService cssdHandlerService = null;
	String jsp = "";
	String title = "";
	String userName = null;
	String message = null;
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = null;

	public void setCssdHandlerService(CssdHandlerService cssdHandlerService) {
		this.cssdHandlerService = cssdHandlerService;
	}

	public ModelAndView showInstrumentMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int deptId = 0;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		box.put("deptId", deptId);
		map = cssdHandlerService.showInstrumentMasterJsp(box);
		jsp = CSSD_INSTRUMENT_MASTER_JSP;
		jsp += ".jsp";
		title = "Instrument Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showMaterialMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int deptId = 0;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		box.put("deptId", deptId);
		map = cssdHandlerService.showMaterialMasterJsp(box);
		jsp = CSSD_MATERIAL_MASTER_JSP;
		jsp += ".jsp";
		title = "Material Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView addInstrumentMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		CssdInstrumentMaster cssdInstrumentMaster = new CssdInstrumentMaster();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		Date currentDate = new Date();
		String code = null;
		String name = null;
		String changedBy = null;
		String currentTime = null;
		String pojoName = null;
		String pojoPropertyName = null;
		String pojoPropertyCode = null;
		session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		box.put("deptId", deptId);
		code = box.getString(CODE);
		name = box.getString(SEARCH_NAME);
		changedBy = box.getString(CHANGED_BY);
		currentDate = HMSUtil
				.dateFormatterDDMMYYYY(box.getString(CHANGED_DATE));
		currentTime = box.getString(CHANGED_TIME);
		title = box.getString("title");
		pojoName = box.getString("pojoName");
		pojoPropertyName = box.getString("pojoPropertyName");
		pojoPropertyCode = box.getString("pojoPropertyCode");

		generalMap.put("code", code);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = cssdHandlerService.checkForExistingMasters(generalMap);

		List instrumentCodeList = new ArrayList();
		List instrumentNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			instrumentCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}

		if (listMap.get("duplicateGeneralNameList") != null) {
			instrumentNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((instrumentCodeList == null || instrumentCodeList.size() == 0)
				&& (instrumentNameList == null || instrumentNameList.size() == 0)) {
			cssdInstrumentMaster.setInstrumentCode(code);
			cssdInstrumentMaster.setInstrumentName(name);
			cssdInstrumentMaster.setDepartment(new MasDepartment(deptId));
			cssdInstrumentMaster.setStatus("y");
			cssdInstrumentMaster.setLastChgBy(changedBy);
			cssdInstrumentMaster.setLastChgDate(currentDate);
			cssdInstrumentMaster.setLastChgTime(currentTime);
			successfullyAdded = cssdHandlerService
					.addInstrumentMaster(cssdInstrumentMaster);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((instrumentNameList != null && instrumentNameList.size() != 0)) {
			message = "Instrument Name already exists.";
		} else if ((instrumentCodeList != null && instrumentCodeList.size() != 0)) {
			message = "Instrument Code already exists.";
		} else if ((instrumentCodeList != null || instrumentCodeList.size() != 0)
				&& (instrumentNameList != null || instrumentNameList.size() != 0)) {
			message = "Instrument Code & Name already exist.";
		}

		try {
			map = cssdHandlerService.showInstrumentMasterJsp(box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CSSD_INSTRUMENT_MASTER_JSP;
		title = "Add Instrument";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView addMaterialMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		CssdMaterialMaster cssdMaterialMaster = new CssdMaterialMaster();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		Date currentDate = new Date();
		String code = null;
		String name = null;
		String changedBy = null;
		String currentTime = null;
		String pojoName = null;
		String pojoPropertyName = null;
		String pojoPropertyCode = null;
		session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		box.put("deptId", deptId);
		code = box.getString(CODE);
		name = box.getString(SEARCH_NAME);
		changedBy = box.getString(CHANGED_BY);
		currentDate = HMSUtil
				.dateFormatterDDMMYYYY(box.getString(CHANGED_DATE));
		currentTime = box.getString(CHANGED_TIME);
		title = box.getString("title");
		pojoName = box.getString("pojoName");
		pojoPropertyName = box.getString("pojoPropertyName");
		pojoPropertyCode = box.getString("pojoPropertyCode");

		generalMap.put("code", code);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = cssdHandlerService.checkForExistingMasters(generalMap);

		List materialCodeList = new ArrayList();
		List materialNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			materialCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}

		if (listMap.get("duplicateGeneralNameList") != null) {
			materialNameList = (List) listMap.get("duplicateGeneralNameList");
		}

		boolean successfullyAdded = false;

		if ((materialCodeList == null || materialCodeList.size() == 0)
				&& (materialNameList == null || materialNameList.size() == 0)) {
			cssdMaterialMaster.setMaterialCode(code);
			cssdMaterialMaster.setMaterialName(name);
			cssdMaterialMaster.setDepartment(new MasDepartment(deptId));
			cssdMaterialMaster.setStatus("y");
			cssdMaterialMaster.setLastChgBy(changedBy);
			cssdMaterialMaster.setLastChgDate(currentDate);
			cssdMaterialMaster.setLastChgTime(currentTime);
			successfullyAdded = cssdHandlerService
					.addMaterialMaster(cssdMaterialMaster);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((materialNameList != null && materialNameList.size() != 0)) {
			message = "Material Name already exists.";
		} else if ((materialCodeList != null && materialCodeList.size() != 0)) {
			message = "Material Code already exists.";
		} else if ((materialCodeList != null || materialCodeList.size() != 0)
				&& (materialNameList != null || materialNameList.size() != 0)) {
			message = "Material Code & Name already exist.";
		}

		try {
			map = cssdHandlerService.showMaterialMasterJsp(box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CSSD_MATERIAL_MASTER_JSP;
		title = "Add Instrument";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchInstrumentMaster(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String instrumentMasterCode = null;
		String instrumentMasterName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			instrumentMasterCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			instrumentMasterName = request.getParameter(SEARCH_NAME);
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
			instrumentMasterCode = searchField;
			instrumentMasterName = null;

		} else {
			instrumentMasterCode = null;
			instrumentMasterName = searchField;
		}

		map.put("code", instrumentMasterCode);
		map.put("name", instrumentMasterName);

		map = cssdHandlerService.searchInstrumentMaster(map);

		jsp = CSSD_INSTRUMENT_MASTER_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchMaterialMaster(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String materialMasterCode = null;
		String materialMasterName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			materialMasterCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			materialMasterName = request.getParameter(SEARCH_NAME);
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
			materialMasterCode = searchField;
			materialMasterName = null;

		} else {
			materialMasterCode = null;
			materialMasterName = searchField;
		}

		map.put("code", materialMasterCode);
		map.put("name", materialMasterName);

		map = cssdHandlerService.searchMaterialMaster(map);

		jsp = CSSD_MATERIAL_MASTER_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editInstrumentMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		CssdInstrumentMaster cssdInstrumentMaster = new CssdInstrumentMaster();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		Date currentDate = new Date();
		String code = null;
		String name = null;
		String changedBy = null;
		String currentTime = null;
		String pojoName = null;
		String pojoPropertyName = null;
		String pojoPropertyCode = null;
		session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		box.put("deptId", deptId);
		code = box.getString(CODE);
		name = box.getString(SEARCH_NAME);
		changedBy = box.getString(CHANGED_BY);
		currentDate = HMSUtil
				.dateFormatterDDMMYYYY(box.getString(CHANGED_DATE));
		currentTime = box.getString(CHANGED_TIME);
		title = box.getString("title");
		pojoName = box.getString("pojoName");
		pojoPropertyName = box.getString("pojoPropertyName");
		pojoPropertyCode = box.getString("pojoPropertyCode");
		int id = box.getInt(COMMON_ID);

		generalMap.put("deptId", deptId);
		generalMap.put("id", id);
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = cssdHandlerService.checkForExistingMasters(generalMap);

		List instrumentCodeList = new ArrayList();
		List instrumentNameList = new ArrayList();

		if (listMap.get("duplicateGeneralNameList") != null) {
			instrumentNameList = (List) listMap.get("duplicateGeneralNameList");
		}

		boolean successfullyUpdated = false;

		if (instrumentNameList == null || instrumentNameList.size() == 0) {
			successfullyUpdated = cssdHandlerService
					.editInstrumentMaster(generalMap);
			if (successfullyUpdated) {
				message = "Record Updated Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((instrumentNameList != null && instrumentNameList.size() != 0)) {
			message = "Instrument Name already exists.";
		}

		try {
			map = cssdHandlerService.showInstrumentMasterJsp(box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CSSD_INSTRUMENT_MASTER_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editMaterialMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		CssdMaterialMaster cssdMaterialMaster = new CssdMaterialMaster();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		Date currentDate = new Date();
		String code = null;
		String name = null;
		String changedBy = null;
		String currentTime = null;
		String pojoName = null;
		String pojoPropertyName = null;
		String pojoPropertyCode = null;
		session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		box.put("deptId", deptId);
		code = box.getString(CODE);
		name = box.getString(SEARCH_NAME);
		changedBy = box.getString(CHANGED_BY);
		currentDate = HMSUtil
				.dateFormatterDDMMYYYY(box.getString(CHANGED_DATE));
		currentTime = box.getString(CHANGED_TIME);
		title = box.getString("title");
		pojoName = box.getString("pojoName");
		pojoPropertyName = box.getString("pojoPropertyName");
		pojoPropertyCode = box.getString("pojoPropertyCode");
		int id = box.getInt(COMMON_ID);

		generalMap.put("deptId", deptId);
		generalMap.put("id", id);
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = cssdHandlerService.checkForExistingMasters(generalMap);

		List materialCodeList = new ArrayList();
		List materialNameList = new ArrayList();

		if (listMap.get("duplicateGeneralNameList") != null) {
			materialNameList = (List) listMap.get("duplicateGeneralNameList");
		}

		boolean successfullyUpdated = false;

		if (materialNameList == null || materialNameList.size() == 0) {
			successfullyUpdated = cssdHandlerService
					.editMaterialMaster(generalMap);
			if (successfullyUpdated) {
				message = "Record Updated Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((materialNameList != null && materialNameList.size() != 0)) {
			message = "Material Name already exists.";
		}

		try {
			map = cssdHandlerService.showMaterialMasterJsp(box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CSSD_MATERIAL_MASTER_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteInstrumentMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> generalMap = new HashMap<String, Object>();
		String message = null;
		String changedTime = "";
		Date changedDate = null;
		String changedBy = null;
		String flag = "";
		int id = 0;
		String url;
		int deptId = 0;
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		box.put("deptId", deptId);
		generalMap.put("flag", box.get("flag"));
		id = box.getInt(COMMON_ID);
		title = box.getString("title");
		changedBy = box.getString(CHANGED_BY);
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("id", id);
		boolean dataDeleted = false;
		dataDeleted = cssdHandlerService.deleteInstrumentMaster(generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/cssd?method=showInstrumentMasterJsp";

		try {
			map = cssdHandlerService.showInstrumentMasterJsp(box);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CSSD_INSTRUMENT_MASTER_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteMaterialMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> generalMap = new HashMap<String, Object>();
		String message = null;
		String changedTime = "";
		Date changedDate = null;
		String changedBy = null;
		String flag = "";
		int id = 0;
		String url;
		int deptId = 0;
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		box.put("deptId", deptId);
		generalMap.put("flag", box.get("flag"));
		id = box.getInt(COMMON_ID);
		title = box.getString("title");
		changedBy = box.getString(CHANGED_BY);
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("id", id);
		boolean dataDeleted = false;
		dataDeleted = cssdHandlerService.deleteMaterialMaster(generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/cssd?method=showMaterialMasterJsp";

		try {
			map = cssdHandlerService.showMaterialMasterJsp(box);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CSSD_MATERIAL_MASTER_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showMaterialStockEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int deptId = 0;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		box.put("deptId", deptId);
		map = cssdHandlerService.showMaterialStockEntryJsp(box);
		jsp = CSSD_MATERIAL_STOCK_JSP;
		jsp += ".jsp";
		title = "Material Stock Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getMaterialNamesForAutocomplete(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		int deptId = 0;
		session = request.getSession();
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
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
		dataMap.put("deptId", deptId);
		map = cssdHandlerService.getMaterialNamesForAutocomplete(dataMap);
		jsp = "autocompleteResultForCssd";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView addAndRefreshGrid(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		if (session.getAttribute("deptId") != null)
			box.put("deptId", Integer.parseInt(""
					+ session.getAttribute("deptId")));
		Map<String, Object> map = new HashMap<String, Object>();
		map = cssdHandlerService.addAndRefreshGrid(box);
		map = cssdHandlerService.getStockGridData(box);
		jsp = CSSD_STOCK_RESPONSE_JSP;
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getStockGridData(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		if (session.getAttribute("deptId") != null)
			box.put("deptId", Integer.parseInt(""
					+ session.getAttribute("deptId")));
		Map<String, Object> map = new HashMap<String, Object>();
		map = cssdHandlerService.getStockGridData(box);
		jsp = CSSD_STOCK_RESPONSE_JSP;
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showAutoclaveRequestJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int deptId = 0;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		box.put("deptId", deptId);
		map = cssdHandlerService.showAutoclaveRequestJsp(box);
		jsp = CSSD_AUTOCLAVE_REQUEST_JSP;
		jsp += ".jsp";
		title = "Autoclave Request Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getAutoclaveRequestMaterialNamesForAutocomplete(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		int deptId = 0;
		session = request.getSession();
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
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
		dataMap.put("deptId", deptId);
		dataMap.put("orderNo", box.getString("orderNo"));
		map = cssdHandlerService
				.getAutoclaveRequestMaterialNamesForAutocomplete(dataMap);
		jsp = "autocompleteResultForCssd";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView addAndRefreshAutoclaveRequestGrid(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		if (session.getAttribute("deptId") != null)
			box.put("deptId", Integer.parseInt(""
					+ session.getAttribute("deptId")));
		Map<String, Object> map = new HashMap<String, Object>();
		map = cssdHandlerService.addAndRefreshAutoclaveRequestGrid(box);
		map = cssdHandlerService.getAutoclaveRequestStockGridData(box);
		jsp = CSSD_AUTOCLAVE_REQUEST_RESPONSE_JSP;
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getAutoclaveRequestStockGridData(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		if (session.getAttribute("deptId") != null)
			box.put("deptId", Integer.parseInt(""
					+ session.getAttribute("deptId")));
		Map<String, Object> map = new HashMap<String, Object>();
		map = cssdHandlerService.getAutoclaveRequestStockGridData(box);
		jsp = CSSD_AUTOCLAVE_REQUEST_RESPONSE_JSP;
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showAutoclaveEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int deptId = 0;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		box.put("deptId", deptId);
		map = cssdHandlerService.showAutoclaveEntryJsp(box);
		jsp = CSSD_AUTOCLAVE_ENTRY_JSP;
		jsp += ".jsp";
		title = "Autoclave Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showAutoclaveEntryDetailJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int deptId = 0;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		box.put("deptId", deptId);
		map = cssdHandlerService.showAutoclaveEntryDetailJsp(box);
		String batchNo = cssdHandlerService.generateBatchNo(userName);
		jsp = CSSD_AUTOCLAVE_ENTRY_DETAIL_JSP;
		jsp += ".jsp";
		title = "Autoclave Entry Detail";
		map.put("batchNo", batchNo);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getAutoclaveRequestEntryGridDataForAutoclaveEntry(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		if (session.getAttribute("deptId") != null)
			box.put("deptId", Integer.parseInt(""
					+ session.getAttribute("deptId")));
		Map<String, Object> map = new HashMap<String, Object>();
		map = cssdHandlerService
				.getAutoclaveRequestEntryGridDataForAutoclaveEntry(box);
		jsp = CSSD_AUTOCLAVE_ENTRY_DETAIL_RESPONSE_JSP;
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView submitEntryDetails(HttpServletRequest request,
			HttpServletResponse response) {
		int deptId = 0;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		map = cssdHandlerService.submitEntryDetails(box);
		map = cssdHandlerService.showAutoclaveEntryJsp(box);
		String batchNo = cssdHandlerService.generateBatchNo(userName);
		jsp = CSSD_AUTOCLAVE_ENTRY_JSP;
		jsp += ".jsp";
		title = "Autoclave Entry";
		map.put("batchNo", batchNo);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteCssdEntryGridItems(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map = cssdHandlerService.deleteCssdEntryGridItems(box);
		map = cssdHandlerService
				.getAutoclaveRequestEntryGridDataForAutoclaveEntry(box);
		jsp = CSSD_AUTOCLAVE_ENTRY_DETAIL_RESPONSE_JSP;
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showAutoclaveReceiptJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int deptId = 0;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		box.put("deptId", deptId);
		map = cssdHandlerService.showAutoclaveReceiptJsp(box);
		jsp = CSSD_AUTOCLAVE_RECEIPT_JSP;
		jsp += ".jsp";
		title = "Autoclave Receipt Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView addAndRefreshAutoclaveReceiptGrid(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		if (session.getAttribute("deptId") != null)
			box.put("deptId", Integer.parseInt(""
					+ session.getAttribute("deptId")));
		Map<String, Object> map = new HashMap<String, Object>();
		map = cssdHandlerService.addAndRefreshAutoclaveReceiptGrid(box);
		map = cssdHandlerService.getAutoclaveReceiptStockGridData(box);
		jsp = CSSD_AUTOCLAVE_RECEIPT_RESPONSE_JSP;
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getAutoclaveReceiptStockGridData(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		if (session.getAttribute("deptId") != null)
			box.put("deptId", Integer.parseInt(""
					+ session.getAttribute("deptId")));
		Map<String, Object> map = new HashMap<String, Object>();
		map = cssdHandlerService.getAutoclaveReceiptStockGridData(box);
		jsp = CSSD_AUTOCLAVE_RECEIPT_RESPONSE_JSP;
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView updateAutoclaveReceiptGridData(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		if (session.getAttribute("deptId") != null)
			box.put("deptId", Integer.parseInt(""
					+ session.getAttribute("deptId")));
		map = cssdHandlerService.updateAutoclaveReceiptGridData(box);
		map = cssdHandlerService.getAutoclaveReceiptStockGridData(box);
		jsp = CSSD_AUTOCLAVE_RECEIPT_RESPONSE_JSP;
		map.put("updateMsg", "Successfully Updated");
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showSterilizeRecallJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int deptId = 0;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		box.put("deptId", deptId);
		map = cssdHandlerService.getAutoclaveRecallGridData(box);
		jsp = CSSD_AUTOCLAVE_RECALL_JSP;
		jsp += ".jsp";
		title = "Autoclave Recall ";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getAutoclaveRecallGridData(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		if (session.getAttribute("deptId") != null)
			box.put("deptId", Integer.parseInt(""
					+ session.getAttribute("deptId")));
		Map<String, Object> map = new HashMap<String, Object>();
		map = cssdHandlerService.getAutoclaveRecallGridData(box);
		jsp = CSSD_AUTOCLAVE_RECALL_RESPONSE_JSP;
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView updateAutoclaveRecallGridData(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		if (session.getAttribute("deptId") != null)
			box.put("deptId", Integer.parseInt(""
					+ session.getAttribute("deptId")));
		map = cssdHandlerService.updateAutoclaveRecallGridData(box);
		map = cssdHandlerService.getAutoclaveRecallGridData(box);
		jsp = CSSD_AUTOCLAVE_RECALL_RESPONSE_JSP;
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showAutoclaveRequestReceiptRegister(
			HttpServletRequest request, HttpServletResponse response) {
		jsp = CSSD_AUTOCLAVE_REQUEST_RECEIPT_REGISTER;
		jsp += ".jsp";
		title = "Autoclave Request Receipt Register";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showAutoclaveMaterialList(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		if (session.getAttribute("deptId") != null)
			box.put("deptId", Integer.parseInt(""
					+ session.getAttribute("deptId")));
		map = cssdHandlerService.showAutoclaveMaterialList(box);
		jsp = CSSD_AUTOCLAVE_MATERIAL_LIST;
		jsp += ".jsp";
		title = "Autoclave Material List";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generateCssdRequestReceiptRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;

		session = request.getSession();
		requestParameters.put("deptId", session.getAttribute("deptId"));

		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
			requestParameters.put("fromDate", fromDate);
		}

		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
			requestParameters.put("toDate", toDate);
		}

		Map<String, Object> connectionMap = cssdHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("Cssd_Request_Receipt_Register",
				requestParameters, (Connection) connectionMap.get("con"),
				response, getServletContext());
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generateMaterialListDateWise(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;

		session = request.getSession();

		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
			requestParameters.put("fromDate", fromDate);
		}

		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
			requestParameters.put("toDate", toDate);
		}

		Map<String, Object> connectionMap = cssdHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("Cssd_Autoclaved_Material_Register",
				requestParameters, (Connection) connectionMap.get("con"),
				response, getServletContext());
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generateMaterialListLotWise(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		session = request.getSession();
		if (request.getParameter("lotNo") != null
				&& !(request.getParameter("lotNo").equals(""))) {
			requestParameters.put("lotNo", request.getParameter("lotNo")
					.toString());
		}

		Map<String, Object> connectionMap = cssdHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("Cssd_Autoclaved_Material_LotNo_Wise",
				requestParameters, (Connection) connectionMap.get("con"),
				response, getServletContext());
		return new ModelAndView("indexB", "map", map);
	}

}