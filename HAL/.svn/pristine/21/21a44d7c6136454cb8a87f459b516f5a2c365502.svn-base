/**  
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Class DietController.java 
 * Purpose of the class - This is for Diet Module. 
 * @author  Ritu Sahu 
 * Create Date: 5th Sep,2008   
 * Revision Date:      
 * Revision By: Purpose
 * @version 1.0  
 **/
package jkt.hms.diet.controller;

import static jkt.hms.util.RequestConstants.DAILY_DIET_DEMAND_FOR_MONTH_REPORT_JSP;
import static jkt.hms.util.RequestConstants.DAILY_DIET_JSP;
import static jkt.hms.util.RequestConstants.DATE;
import static jkt.hms.util.RequestConstants.DEPARTMENT_NAME;
import static jkt.hms.util.RequestConstants.DIET_BREAKFAST_DISTRIBUTION_JSP;
import static jkt.hms.util.RequestConstants.DIET_CHANGE_JSP;
import static jkt.hms.util.RequestConstants.DIET_EXTRA_ITEM_FORMULA_JSP;
import static jkt.hms.util.RequestConstants.DIET_INDENT_ITEM_FORMULA_JSP;
import static jkt.hms.util.RequestConstants.DIET_MENU_ITEM_FORMULA_JSP;
import static jkt.hms.util.RequestConstants.FOR_DATE;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.INTERNAL_DEMAND_ISSUE_VOUCHER_JSP;
import static jkt.hms.util.RequestConstants.ITEM_ID;
import static jkt.hms.util.RequestConstants.ITEM_NAME;
import static jkt.hms.util.RequestConstants.MONTH;
import static jkt.hms.util.RequestConstants.MONTHLY_DIET_SUMMARY_REPORT_JSP;
import static jkt.hms.util.RequestConstants.RATION_TYPE;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.YEAR;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.diet.handler.DietHandlerService;
import jkt.hms.masters.business.DietExtraItemFormula;
import jkt.hms.masters.business.DietIndentItemFormula;
import jkt.hms.masters.business.MasDietIndentItem;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class DietController extends MultiActionController {

	DietHandlerService dietHandlerService = null;

	public DietHandlerService getDietHandlerService() {
		return dietHandlerService;
	}

	public void setDietHandlerService(DietHandlerService dietHandlerService) {
		this.dietHandlerService = dietHandlerService;
	}

	/**
	 * --------------------------- Method to show Menu Item Formula jsp
	 * -----------------------------------
	 * 
	 */

	public ModelAndView showMenuItemFormulaJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = dietHandlerService.showMenuItemFormulaJsp();
		String jsp = "";
		String title = "";
		jsp = DIET_MENU_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Menu Item Formula";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------------- Method to submit Menu Item Formula details
	 * -----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView addMenuItemFormula(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;

		Box box = HMSUtil.getBox(request);

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}

		map = dietHandlerService.addMenuItemFormula(box);

		boolean saved = false;
		String message = "";
		List<DietExtraItemFormula> existingList = new ArrayList<DietExtraItemFormula>();

		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (map.get("existingList") != null) {
			existingList = (List<DietExtraItemFormula>) map.get("existingList");
		}

		if (saved) {
			message = "Record Saved Successfully!!";
		} else {
			if (existingList.size() > 0) {
				message = "Record already exist!!";
			} else {
				message = "Try Again!";
			}
		}
		map = dietHandlerService.showMenuItemFormulaJsp();
		map.put("message", message);
		String jsp = "";
		String title = "";
		jsp = DIET_MENU_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Menu Item Formula";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	/**
	 * --------------------------- Method to Edit Menu Item Formula details
	 * -----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView editMenuItemFormula(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);

		datamap = dietHandlerService.editMenuItemFormula(box);
		HttpSession session = request.getSession();
		int hospitalId = 0;

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}

		boolean updated = false;
		String message = "";
		List<DietExtraItemFormula> existingList = new ArrayList<DietExtraItemFormula>();

		if (datamap.get("updated") != null) {
			updated = (Boolean) datamap.get("updated");
		}
		if (datamap.get("existingList") != null) {
			existingList = (List<DietExtraItemFormula>) datamap
					.get("existingList");
		}

		if (updated) {
			message = "Record Updated Successfully!!";
		} else {
			if (existingList.size() > 0) {
				message = "Record already exist!!";
			} else {
				message = "Try Again!";
			}
		}
		map = dietHandlerService.showMenuItemFormulaJsp();
		map.put("message", message);
		String jsp = "";
		String title = "";
		jsp = DIET_MENU_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Menu Item Formula";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------------- Method to delete Menu Item Formula details
	 * -----------------------------------
	 * 
	 */

	public ModelAndView deleteMenuItemFormula(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);

		map = dietHandlerService.deleteMenuItemFormula(box);
		boolean deleted = false;
		String message = "";
		if (map.get("deleted") != null) {
			deleted = (Boolean) map.get("deleted");
		}

		if (deleted) {
			message = "Record Inactivated Successfully!!";
		} else {
			message = "Try Again!";
		}
		map = dietHandlerService.showMenuItemFormulaJsp();
		map.put("message", message);
		String jsp = "";
		String title = "";
		jsp = DIET_MENU_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Menu Item Formula";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	/**
	 * --------------------------- Method to Search Menu Item Formula
	 * -----------------------------------
	 * 
	 */

	public ModelAndView searchMenuItemFormula(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String itemName = "";

		Box box = HMSUtil.getBox(request);

		itemName = box.getString(ITEM_NAME);
		map = dietHandlerService.searchMenuItemFormula(box);

		String jsp = "";
		String title = "";
		jsp = DIET_MENU_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Menu Item Formula";
		map.put("itemName", itemName);
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------------- Method to show Extra Item Formula jsp
	 * -----------------------------------
	 * 
	 */

	public ModelAndView showExtraItemFormulaJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = dietHandlerService.showExtraItemFormulaJsp();
		String jsp = "";
		String title = "";
		jsp = DIET_EXTRA_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Extra Item Formula";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------------- Method to submit Extra Item Formula details
	 * -----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView addExtraItemFormula(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;

		Box box = HMSUtil.getBox(request);

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}

		map = dietHandlerService.addExtraItemFormula(box);

		boolean saved = false;
		String message = "";
		List<DietExtraItemFormula> existingList = new ArrayList<DietExtraItemFormula>();

		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (map.get("existingList") != null) {
			existingList = (List<DietExtraItemFormula>) map.get("existingList");
		}

		if (saved) {
			message = "Record Saved Successfully!!";
		} else {
			if (existingList.size() > 0) {
				message = "Record already exist!!";
			} else {
				message = "Try Again!";
			}
		}
		map = dietHandlerService.showExtraItemFormulaJsp();
		map.put("message", message);
		String jsp = "";
		String title = "";
		jsp = DIET_EXTRA_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Extra Item Formula";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------------- Method to Edit Extra Item Formula details
	 * -----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView editExtraItemFormula(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);

		datamap = dietHandlerService.editExtraItemFormula(box);

		boolean updated = false;
		String message = "";
		List<DietExtraItemFormula> existingList = new ArrayList<DietExtraItemFormula>();

		if (datamap.get("updated") != null) {
			updated = (Boolean) datamap.get("updated");
		}
		if (datamap.get("existingList") != null) {
			existingList = (List<DietExtraItemFormula>) datamap
					.get("existingList");
		}
		if (updated) {
			message = "Record Updated Successfully!!";
		} else {
			if (existingList.size() > 0) {
				message = "Record already exist!!";
			} else {
				message = "Try Again!";
			}
		}
		map = dietHandlerService.showExtraItemFormulaJsp();
		map.put("message", message);
		String jsp = "";
		String title = "";
		jsp = DIET_EXTRA_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Extra Item Formula";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------------- Method to delete Extra Item Formula details
	 * -----------------------------------
	 * 
	 */

	public ModelAndView deleteExtraItemFormula(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);

		map = dietHandlerService.deleteExtraItemFormula(box);
		boolean deleted = false;
		String message = "";
		if (map.get("deleted") != null) {
			deleted = (Boolean) map.get("deleted");
		}

		if (deleted) {
			message = "Record Inactivated Successfully!!";
		} else {
			message = "Try Again!";
		}
		map = dietHandlerService.showExtraItemFormulaJsp();
		map.put("message", message);
		String jsp = "";
		String title = "";
		jsp = DIET_EXTRA_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Extra Item Formula";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	/**
	 * --------------------------- Method to Search Extra Item Formula
	 * -----------------------------------
	 * 
	 */

	public ModelAndView searchExtraItemFormula(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String itemName = "";

		Box box = HMSUtil.getBox(request);

		itemName = box.getString(ITEM_NAME);
		map = dietHandlerService.searchExtraItemFormula(box);

		String jsp = "";
		String title = "";
		jsp = DIET_EXTRA_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Extra Item Formula";
		map.put("itemName", itemName);
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------------- Method to show Indent Item Formula jsp
	 * -----------------------------------
	 * 
	 */

	public ModelAndView showIndentItemFormulaJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = dietHandlerService.showIndentItemFormulaJsp();
		String jsp = "";
		String title = "";
		jsp = DIET_INDENT_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Indent Item Formula";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------------- Method to submit Indent Item Formula details
	 * -----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView addIndentItemFormula(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;

		Box box = HMSUtil.getBox(request);

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}

		map = dietHandlerService.addIndentItemFormula(box);

		boolean saved = false;
		String message = "";
		List<DietIndentItemFormula> existingList = new ArrayList<DietIndentItemFormula>();

		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (map.get("existingList") != null) {
			existingList = (List<DietIndentItemFormula>) map
					.get("existingList");
		}

		if (saved) {
			message = "Record Saved Successfully!!";
		} else {
			if (existingList.size() > 0) {
				message = "Record already exist!!";
			} else {
				message = "Try Again!";
			}
		}
		map = dietHandlerService.showIndentItemFormulaJsp();
		map.put("message", message);
		String jsp = "";
		String title = "";
		jsp = DIET_INDENT_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Indent Item Formula";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	/**
	 * --------------------------- Method to Edit Indent Item Formula details
	 * -----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView editIndentItemFormula(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);

		datamap = dietHandlerService.editIndentItemFormula(box);
		HttpSession session = request.getSession();
		int hospitalId = 0;

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}

		boolean updated = false;
		String message = "";
		List<DietIndentItemFormula> existingList = new ArrayList<DietIndentItemFormula>();

		if (datamap.get("updated") != null) {
			updated = (Boolean) datamap.get("updated");
		}
		if (datamap.get("existingList") != null) {
			existingList = (List<DietIndentItemFormula>) datamap
					.get("existingList");
		}

		if (updated) {
			message = "Record Updated Successfully!!";
		} else {
			if (existingList.size() > 0) {
				message = "Record already exist!!";
			} else {
				message = "Try Again!";
			}
		}
		map = dietHandlerService.showIndentItemFormulaJsp();
		map.put("message", message);
		String jsp = "";
		String title = "";
		jsp = DIET_INDENT_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Indent Item Formula";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------------- Method to delete Indent Item Formula details
	 * -----------------------------------
	 * 
	 */

	public ModelAndView deleteIndentItemFormula(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);

		map = dietHandlerService.deleteIndentItemFormula(box);
		boolean deleted = false;
		String message = "";
		if (map.get("deleted") != null) {
			deleted = (Boolean) map.get("deleted");
		}

		if (deleted) {
			message = "Record Inactivated Successfully!!";
		} else {
			message = "Try Again!";
		}
		map = dietHandlerService.showIndentItemFormulaJsp();
		map.put("message", message);
		String jsp = "";
		String title = "";
		jsp = DIET_INDENT_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Indent Item Formula";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	/**
	 * --------------------------- Method to Search Indent Item Formula
	 * -----------------------------------
	 * 
	 */

	public ModelAndView searchIndentItemFormula(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String itemName = "";

		Box box = HMSUtil.getBox(request);

		itemName = box.getString(ITEM_NAME);
		map = dietHandlerService.searchIndentItemFormula(box);

		String jsp = "";
		String title = "";
		jsp = DIET_INDENT_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Indent Item Formula";
		map.put("itemName", itemName);
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------------- Method to Show Patient Diet Change Jsp
	 * -----------------------------------
	 * 
	 */

	public ModelAndView showPatientDietChangeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		int departmentId = 0;

		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
		}

		map = dietHandlerService.getPatientListForDietChange(departmentId);

		String jsp = "";
		jsp = DIET_CHANGE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------------- Method to Search Patient for Diet Change
	 * -----------------------------------
	 * 
	 */

	public ModelAndView searchDietDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);
		int departmentId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
			box.put("departmentId", departmentId);
		}

		map = dietHandlerService.searchDietDetails(box);

		String jsp = "";
		jsp = DIET_CHANGE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------------- Method to Update Patient diet details
	 * -----------------------------------
	 * 
	 */

	public ModelAndView updatePatientDietDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		int hospitalId = 0;

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			infoMap.put("hospitalId", hospitalId);
		}
		int departmentId = 0;
		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
			infoMap.put("departmentId", departmentId);
		}
		infoMap.put("request", request);
		map = dietHandlerService.updatePatientDietDetails(infoMap);
		boolean flag = false;
		if (map.get("flag") != null) {
			flag = (Boolean) map.get("flag");
		}
		String message = "";

		if (flag) {

			message = "Diet Details Saved Successfully!";
		} else {
			message = "Data cannot be saved!!";
		}
		map.put("message", message);
		String url = "/hms/hms/diet?method=showPatientDietChangeJsp";
		String jsp = "";
		jsp = "messageForDiet";
		jsp += ".jsp";
		map.put("dietChange", "dietChange");
		map.put("contentJsp", jsp);
		map.put("url", url);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------------- Method to Show Daily Diet & Extra Requisition
	 * jsp -----------------------------------
	 * 
	 */

	public ModelAndView showDailyDietExtraRequisitionJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int departmentId = 0;
		int hospitalId = 0;
		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
			infoMap.put("departmentId", departmentId);
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			infoMap.put("hospitalId", hospitalId);
		}
		map = dietHandlerService.getDetailsForDailyDietExtraRequ(infoMap);
		String jsp = "";
		jsp = DAILY_DIET_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------------- Method to Save Daily Diet & Extra Requisition
	 * details -----------------------------------
	 * 
	 */

	public ModelAndView saveDailyDietDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();
		int departmentId = 0;
		int hospitalId = 0;
		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
			box.put("departmentId", departmentId);
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		}
		map = dietHandlerService.saveDailyDietDetails(box);

		String forDate = box.getString(FOR_DATE);
		String jsp = "";
		jsp = "messageForDiet";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("forDate", forDate);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------------- Method to Show Internal Demand And issue
	 * Voucher jsp -----------------------------------
	 * 
	 */

	public ModelAndView showInternalDemandIssueVoucherJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		map = dietHandlerService.getDetailsForInternalDemand();
		String jsp = "";
		jsp = INTERNAL_DEMAND_ISSUE_VOUCHER_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------------- Method to get Indent Items for Internal
	 * Demand -----------------------------------
	 * 
	 */

	public ModelAndView getItemsForGrid(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDietIndentItem> itemList = new ArrayList<MasDietIndentItem>();
		String rationType = "";
		Box box = HMSUtil.getBox(request);

		rationType = box.getString(RATION_TYPE);

		itemList = dietHandlerService.getItemsForGrid(rationType);
		map.put("itemList", itemList);
		String jsp = "";
		jsp = "responseForItemGrid";
		return new ModelAndView(jsp, "map", map);
	}

	/**
	 * --------------------------- Method to save Internal Demand & Ration
	 * Details -----------------------------------
	 * 
	 */
	public ModelAndView saveInternalDemandRationDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		}
		map = dietHandlerService.saveInternalDemandRationDetails(box);

		String jsp = "";
		String url = "diet?method=showInternalDemandIssueVoucherJsp";
		jsp = "messageForDiet";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("url", url);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------------- Method to Show Breakfast Distribution jsp
	 * -----------------------------------
	 * 
	 */
	public ModelAndView showBreakfastDistributionJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		map = dietHandlerService.getDetailsForBreakfastSummary();

		String jsp = "";
		jsp = DIET_BREAKFAST_DISTRIBUTION_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getItemQtyForBreakfast(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int breakfastItemId = 0;
		int totalMessPatient = 0;
		int totalEggQty = 0;
		Box box = HMSUtil.getBox(request);

		breakfastItemId = box.getInt(ITEM_ID);
		totalMessPatient = box.getInt("totalPatient");
		totalEggQty = box.getInt("totalEggQty");
		map = dietHandlerService.getItemQtyForBreakfast(breakfastItemId);
		String jsp = "";
		jsp = "responseForDietItemQty";
		map.put("totalMessPatient", totalMessPatient);
		map.put("totalEggQty", totalEggQty);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView saveBreakastDistributionDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = 0;

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}

		map = dietHandlerService.saveBreakastDistributionDetails(box);
		String summaryDate = box.getString(DATE);
		String jsp = "";
		jsp = "messageForDiet";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("breakfast", "breakfast");
		map.put("summaryDate", summaryDate);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView updateDietDetailsForDailyDiet(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int departmentId = 0;
		int hospitalId = 0;
		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
			infoMap.put("departmentId", departmentId);
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			infoMap.put("hospitalId", hospitalId);
		}

		map = dietHandlerService.updateDietDetailsForDailyDiet(infoMap);

		String jsp = "";
		jsp = DAILY_DIET_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ---------------------------Method to Show Monthly Diet Summary Report Jsp
	 * -----------------------------------
	 * 
	 */

	public ModelAndView showMonthlyDietSummaryReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String extra = "";

		Box box = HMSUtil.getBox(request);

		extra = box.getString("extra");

		String jsp = "";
		jsp = MONTHLY_DIET_SUMMARY_REPORT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("extra", extra);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ---------------------------Common Method to print Monthly Diet Summary &
	 * Summary Of Extra For Month Report -----------------------------------
	 * 
	 */

	public ModelAndView printMonthlyDietSummaryReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String month = "";
		int year = 0;
		String extra = "";

		Box box = HMSUtil.getBox(request);

		month = box.getString(MONTH);
		year = box.getInt(YEAR);
		extra = box.getString("extra");

		detailsMap = dietHandlerService.getConnectionForReport();
		parameters.put("MONTH", month);
		parameters.put("YEAR", year);
		String reportName = "";
		if (extra.equals("yes")) {
			reportName = "Summary_Of_Extra_For_Month";
		} else {
			reportName = "Monthlydietsummary";
		}
		HMSUtil.generateReport(reportName, parameters, (Connection) detailsMap
				.get("conn"), response, getServletContext());

		return null;
	}

	/**
	 * ---------------------------Method to Daily Diet Demand for month Report
	 * Jsp -----------------------------------
	 * 
	 */

	public ModelAndView showDailyDietDemandForMonthJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String deptName = "";
		int departmentId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
		}

		String extra = "";
		Box box = HMSUtil.getBox(request);
		extra = box.getString("extra");

		deptName = dietHandlerService.getDepartmentName(departmentId);
		String jsp = "";
		jsp = DAILY_DIET_DEMAND_FOR_MONTH_REPORT_JSP;
		jsp += ".jsp";
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		map.put("extra", extra);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ---------------------------Common Method to print Daily Summary Of Extra
	 * For Month & Daily Diet Demand Report -----------------------------------
	 * 
	 */

	public ModelAndView printDailyDietDemandForMonthReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String month = "";
		int year = 0;
		String extra = "";

		Box box = HMSUtil.getBox(request);
		int departmentId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
		}

		month = box.getString(MONTH);
		year = box.getInt(YEAR);
		extra = box.getString("extra");

		detailsMap = dietHandlerService.getConnectionForReport();
		parameters.put("MONTH", month);
		parameters.put("YEAR", year);
		parameters.put("DEPART", departmentId);

		String reportName = "";

		if (extra.equals("yes")) {
			reportName = "Daily_Summary_Of_Extra_For_Month";
		} else {
			reportName = "Daily_Diet_Demand";
		}

		HMSUtil.generateReport(reportName, parameters, (Connection) detailsMap
				.get("conn"), response, getServletContext());

		return null;

	}

	public ModelAndView showLunchDinnerSummaryReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String therapeutic = "";

		Box box = HMSUtil.getBox(request);

		therapeutic = box.getString("therapeutic");

		String jsp = "";
		jsp = "dietLunchDinnerDistributionSummaryReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("therapeutic", therapeutic);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printLunchDinnerSummaryReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date date = new Date();
		String type = "";
		String therapeutic = "";

		Box box = HMSUtil.getBox(request);

		date = HMSUtil.convertStringTypeDateToDateType(box.getString(DATE));
		type = box.getString("type");
		therapeutic = box.getString("therapeutic");

		detailsMap = dietHandlerService.getConnectionForReport();
		parameters.put("DIETDATE", date);
		parameters.put("TYPE", type);

		String reportName = "";
		if (therapeutic.equals("no")) {
			reportName = "LunchDinnerDistributionSummary";
		} else {
			reportName = "LunchDinnerDistributionSummaryForTherapeutic";
		}
		try {
			HMSUtil.generateReport(reportName, parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		return null;

	}

	public ModelAndView printDailyDietAndExtraReqisitionReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date demandDate = new Date();
		Box box = HMSUtil.getBox(request);
		int departmentId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
		}

		demandDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString("date"));
		detailsMap = dietHandlerService.getConnectionForReport();
		parameters.put("DietSummaryDate", demandDate);
		parameters.put("departmentid", departmentId);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));

		try {
			HMSUtil.generateReport("MainDailyDietAndExtras", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		return null;

	}

	public ModelAndView showDietSummaryReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String flag = "";
		flag = box.getString("flag");

		String jsp = "";
		jsp = "dietSheetSummaryReport";
		jsp += ".jsp";
		map.put("flag", flag);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printDietSummaryReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date dietDate = new Date();
		String flag = "";
		Box box = HMSUtil.getBox(request);
		flag = box.getString("flag");
		dietDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString("date"));

		detailsMap = dietHandlerService.getConnectionForReport();
		parameters.put("PDiet_Date", dietDate);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		String reportName = "";
		if (flag.equals("dietSheetSummary")) {
			reportName = "DietSheetSummary";
		}
		if (flag.equals("breakfastSummary")) {
			reportName = "BreakFastSummary";
		}

		HMSUtil.generateReport(reportName, parameters, (Connection) detailsMap
				.get("conn"), response, getServletContext());

		return null;

	}

	public ModelAndView showDrssReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String jsp = "";
		jsp = "dietDrssReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printDrssRegisterReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();

		Box box = HMSUtil.getBox(request);

		fromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(FROM_DATE));
		toDate = HMSUtil
				.convertStringTypeDateToDateType(box.getString(TO_DATE));

		detailsMap = dietHandlerService.getConnectionForReport();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		HMSUtil.generateReport("drssRegister", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;

	}

	public ModelAndView showDailyDietSheetOfWardReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String deptName = "";
		int departmentId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
		}

		deptName = dietHandlerService.getDepartmentName(departmentId);
		String jsp = "";
		jsp = "dailyDietSheetOfWardReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("deptName", deptName);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printDailyDietSheetOfWardReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);
		int departmentId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
			box.put("deptId", departmentId);
		}
		int month = box.getInt(MONTH);
		int year = box.getInt(YEAR);
		String deptName = box.getString(DEPARTMENT_NAME);
		String monthName = box.getString("monthName");

		dietHandlerService.callProcedureFordailyDietSheet(box);

		detailsMap = dietHandlerService.getConnectionForReport();

		parameters.put("departmentId", departmentId);
		parameters.put("month", month);
		parameters.put("year", year);
		parameters.put("TitleReports", "Daily Diet Sheet Of " + deptName
				+ " for the month Of " + monthName + " " + year);

		try {
			HMSUtil.generateReport("DailyDietSheet", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		return null;

	}

	public ModelAndView showMontlyDietSheetReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String deptName = "";
		int departmentId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
		}

		deptName = dietHandlerService.getDepartmentName(departmentId);
		String jsp = "";
		jsp = "monthlyDietSheetOfWardReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("deptName", deptName);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printMonthlyDietSheetOfWardReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);
		int departmentId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
			box.put("deptId", departmentId);
		}
		int month = box.getInt(MONTH);
		int year = box.getInt(YEAR);
		String deptName = box.getString(DEPARTMENT_NAME);
		String monthName = box.getString("monthName");

		detailsMap = dietHandlerService.getConnectionForReport();

		parameters.put("departmentId", departmentId);
		parameters.put("month", month);
		parameters.put("year", year);
		parameters.put("TitleReports", "Monthly Diet Sheet Of " + deptName
				+ " for the month Of " + monthName + " " + year);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));

		try {
			HMSUtil.generateReport("MonthlyDietSheet", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		return null;

	}
}
