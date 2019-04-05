/*
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * StoresController.java  
 * Purpose of the claas -  This is the Controller for Stores Module
 * @authors  Vivek
 * Create Date: 28th April,2008 
 * Revision Date:      
 * Revision By:  
 * @version 2.0
 */
package jkt.hms.stores.controller;

import static jkt.hms.util.RequestConstants.*;


import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasManufacturer;
import jkt.hms.masters.business.MasStoreAirForceDepot;
import jkt.hms.masters.business.MasStoreBrand;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreSection;
import jkt.hms.masters.business.StoreIndentM;
import jkt.hms.masters.business.StoreIndentSocTracker;
import jkt.hms.masters.business.StoreIndentT;
import jkt.hms.masters.business.StoreInternalIndentM;
import jkt.hms.masters.business.StoreIssueM;
import jkt.hms.masters.business.StoreIssueT;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.StorePoDetail;
import jkt.hms.stores.handler.NonExpandableHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.JKTRequestUtils;
import jkt.hms.util.RequestConstants;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class NonExpandableController extends MultiActionController {
	/*
	 * Instance variables
	 */
	HttpSession session = null;
	Map<String, Object> map = new HashMap<String, Object>();
	String jsp = "";
	String title = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	String userName = "";
	String currentDate = "";
	String currentTime = "";
	String message = "";
	String url = "";

	NonExpandableHandlerService nonExpandableHandlerService = null;

	// Common methods for NonExpandableController
	public NonExpandableHandlerService getNonExpandableHandlerService() {
		return nonExpandableHandlerService;
	}

	public void setNonExpandableHandlerService(
			NonExpandableHandlerService nonExpandableHandlerService) {
		this.nonExpandableHandlerService = nonExpandableHandlerService;
	}

	// /======================= getCompield report common
	// mthod========================
	private JasperReport getCompiledReport(String fileName) throws JRException {

		File reportFile = new File(getServletContext().getRealPath(
				"/reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile.getPath());

		return jasperReport;
	}

	// *********************************************************************************************************************
	// ------------------------------------Start of Methods Written By
	// Vivek------------------------------------------
	// ****************************************************************************************************************

	public ModelAndView getSectionWiseList(HttpServletRequest request,
			HttpServletResponse response) {
		int sectionId = 0;
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		Box box = HMSUtil.getBox(request);
		if (request.getParameter("sectionId") != null) {
			sectionId = Integer.parseInt(""
					+ (request.getParameter("sectionId")));
		}
		map = nonExpandableHandlerService.showIndentJspDepot(dataMap);

		jsp = INDENT_TO_DEPOT_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("sectionId", sectionId);
		return new ModelAndView("index", "map", map);
	}

	public void fillItemsForIndentToSOC(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session------
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
		// --------------------------------------------------------------------------------
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		BigDecimal stockIn = null;

		Box box = HMSUtil.getBox(request);
		String itemNameField = "";
		String pvmsNo = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("pvmsNo") != null) {
			pvmsNo = (request.getParameter("pvmsNo"));
		}
		dataMap.put("pvmsNo", pvmsNo);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		map = nonExpandableHandlerService.fillItemsForIndentToSOC(dataMap);
		if (map.get("itemList") != null) {
			itemList = (List) map.get("itemList");
		}
		if (map.get("brandList") != null) {
			brandList = (List) map.get("brandList");
		}
		if (map.get("stockIn") != null) {
			stockIn = new BigDecimal("" + map.get("stockIn"));
		}
		StringBuffer sb = new StringBuffer();
		try {
			for (MasStoreItem masStoreItem : itemList) {
				sb.append("<item>");
				sb.append("<id>" + masStoreItem.getId() + "</id>");
				sb.append("<pvms>" + masStoreItem.getPvmsNo() + "</pvms>");
				sb.append("<au>"
						+ masStoreItem.getItemConversion().getItemUnitName()
						+ "</au>");
				sb.append("<brands>");
				for (MasStoreBrand brand : brandList) {
					sb.append("<brand>");
					sb.append("<brandId>" + brand.getId() + "</brandId>");
					sb.append("<brandName>" + brand.getBrandName()
							+ "</brandName>");
					sb.append("</brand>");
				}
				sb.append("</brands>");
				sb.append("<stockIn>" + stockIn + "</stockIn>");
				sb.append("</item>");
			}

			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
			//System.out.println("sb =============================="+ sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// return new ModelAndView(jsp, "map", map);
	}

	public void getManufacturerNameInAjax(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		int brandId = 0;
		String manufacturerName = "";
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter(BRAND_ID) != null) {
			brandId = Integer.parseInt("" + (request.getParameter(BRAND_ID)));
		}
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("brandId", brandId);
		map = nonExpandableHandlerService.getManufacturerNameInAjax(dataMap);
		if (map.get("manufacturerName") != null) {
			manufacturerName = ("" + map.get("manufacturerName"));
		}
		int mId = 1;
		if (map.get("mId") != null) {
			mId = Integer.parseInt(("" + map.get("mId")));
		}
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<item>");
			sb.append("<manufacturerName>" + manufacturerName
					+ "</manufacturerName>");
			sb.append("<mId>" + mId + "</mId>");
			sb.append("</item>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
			//System.out.println("sb =============================="+ sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// return new ModelAndView(jsp, "map", map);
	}

	public void fillItemsForIssueToDepot(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		String itemNameField = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String pvmsNo = "";
		try {
			if (request.getParameter("requiredField") != null) {
				pvmsNo = URLDecoder.decode(request
						.getParameter("requiredField"), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		dataMap.put("pvmsNo", pvmsNo);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		map = nonExpandableHandlerService.fillItemsForIssueToDepot(dataMap);
		if (map.get("itemList") != null) {
			itemList = (List) map.get("itemList");
		}
		for (MasStoreItem masStoreItem : itemList) {
			//System.out.println("Name  " + masStoreItem.getNomenclature());
		}
		StringBuffer sb = new StringBuffer();
		for (MasStoreItem masStoreItem : itemList) {
			sb.append("<item>");
			sb.append("<id>" + masStoreItem.getId() + "</id>");
			sb.append("<pvms>" + masStoreItem.getPvmsNo() + "</pvms>");
			sb.append("<au>"
					+ masStoreItem.getItemConversion().getItemUnitName()
					+ "</au>");
			sb.append("<name>" + masStoreItem.getNomenclature() + "</name>");
			sb.append("</item>");
		}

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
			//System.out.println("sb =============================="+ sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// return new ModelAndView(jsp, "map", map);
	}

	// ----------------------------------------Final MMF For Projection To
	// DGAFMS--------------------------------------------------

	public void fillItemsCommon(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		String itemNameField = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String pvmsNo = "";
		try {
			if (request.getParameter("pvmsNo") != null) {
				pvmsNo = request.getParameter("pvmsNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		dataMap.put("pvmsNo", pvmsNo);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		map = nonExpandableHandlerService.fillItemsCommon(dataMap);
		if (map.get("itemList") != null) {
			itemList = (List) map.get("itemList");
		}
		for (MasStoreItem masStoreItem : itemList) {
			//System.out.println("Name  " + masStoreItem.getNomenclature());
		}
		StringBuffer sb = new StringBuffer();
		for (MasStoreItem masStoreItem : itemList) {
			sb.append("<item>");
			sb.append("<id>" + masStoreItem.getId() + "</id>");
			sb.append("<pvms>" + masStoreItem.getPvmsNo() + "</pvms>");
			sb.append("<au>"
					+ masStoreItem.getItemConversion().getItemUnitName()
					+ "</au>");
			sb.append("<name>" + masStoreItem.getNomenclature() + "</name>");
			sb.append("</item>");
		}

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
			//System.out.println("sb =============================="+ sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getItemListForMMFIndentModify(
			HttpServletRequest request, HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		String itemNameField = "";
		String autoHint = "";
		int mmfForTheYear = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			if (request.getParameter("mmfForTheYear") != null) {
				mmfForTheYear = Integer.parseInt(""
						+ (request.getParameter("mmfForTheYear")));
			}
			List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
			dataMap.put("autoHint", autoHint);
			dataMap.put("deptId", deptId);
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("mmfForTheYear", mmfForTheYear);

			map = nonExpandableHandlerService
					.getItemListForMMFIndentModify(dataMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "result";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getItemListForMMFIndent(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		String itemNameField = "";
		String autoHint = "";
		int mmfForTheYear = 2008;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			if (request.getParameter("mmfForTheYear") != null) {
				mmfForTheYear = Integer.parseInt(""
						+ (request.getParameter("mmfForTheYear")));
			}

			//System.out.println("mmfForTheYear  " + mmfForTheYear);
			List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
			dataMap.put("autoHint", autoHint);
			dataMap.put("deptId", deptId);
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("mmfForTheYear", mmfForTheYear);

			map = nonExpandableHandlerService.getItemListForMMFIndent(dataMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "result";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView checkYearExists(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int mmfForTheYear = 0;

		try {

			if (request.getParameter(RequestConstants.MMF_FOR_THE_YEAR) != null) {
				mmfForTheYear = Integer.parseInt(request
						.getParameter(RequestConstants.MMF_FOR_THE_YEAR));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (mmfForTheYear != 0) {
			dataMap.put("mmfForTheYear", mmfForTheYear);
			dataMap.put("deptId", deptId);
			map = nonExpandableHandlerService.checkYearExists(dataMap);
		}
		jsp = INDENT_JSP;
		jsp = jsp + ".jsp";
		title = "Indent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPrintIndentSocJsp(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map<String, Object> map = new HashMap<String, Object>();
		map = nonExpandableHandlerService.showPrintIndentDepotJsp();
		jsp = PRINT_INDENT_SOC_JSP;
		jsp = jsp + ".jsp";
		title = "Indent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView lockMMFIndent(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		int year = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		String messageTOBeVisibleToTheUser = "Record Not Locked";
		if (request.getParameter(RequestConstants.MMF_FOR_THE_YEAR) != null) {
			year = Integer.parseInt(request
					.getParameter(RequestConstants.MMF_FOR_THE_YEAR));
		}
		map = nonExpandableHandlerService.lockMMFIndent(year);
		if (map.get("messageTOBeVisibleToTheUser") != null) {
			messageTOBeVisibleToTheUser = ""
					+ map.get("messageTOBeVisibleToTheUser");
		}
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		jsp = INDENT_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showLockMMFIndent(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map<String, Object> map = new HashMap<String, Object>();
		map = nonExpandableHandlerService.showLockMMFIndent();
		jsp = LOCK_MMF_INDENT_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showPrintIndentDepotJsp(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map<String, Object> map = new HashMap<String, Object>();
		map = nonExpandableHandlerService.showPrintIndentDepotJsp();
		jsp = PRINT_INDENT_DEOPT_JSP;
		jsp = jsp + ".jsp";
		title = "Indent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView importMMFIndent(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int year = 0;
		String flag = "n";
		int indentId = 0;
		String messageTOBeVisibleToTheUser = "";
		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		try {
			if (request.getParameter(RequestConstants.MMF_FOR_THE_YEAR) != null) {
				year = Integer.parseInt(request
						.getParameter(RequestConstants.MMF_FOR_THE_YEAR));
			}
			dataMap.put("deptId", deptId);
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("userName", userName);
			dataMap.put("year", year);
			map = nonExpandableHandlerService.importMMFIndent(dataMap);
			if (map.get("flag") != null) {
				flag = ("" + map.get("flag"));
			}

		} catch (Exception e) {
			//System.out.println("In Controller");
			e.printStackTrace();
		}
		if (map.get("messageTOBeVisibleToTheUser") != null) {
			messageTOBeVisibleToTheUser = ""
					+ map.get("messageTOBeVisibleToTheUser");

		}
		jsp = INDENT_JSP;
		jsp = jsp + ".jsp";
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showImportMMFIndentJsp(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();

		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		map = nonExpandableHandlerService.showImportMMFIndentJsp(dataMap);
		jsp = IMPORT_MMF_INDENT;
		jsp = jsp + ".jsp";
		title = "Import MMF Indent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView printIndentSoc(HttpServletRequest request,
			HttpServletResponse response) {
		int indentId = 0;
		if (request.getParameter(INDENT_NO) != null
				&& !(request.getParameter(INDENT_NO).equals(""))) {
			indentId = Integer.parseInt(request.getParameter(INDENT_NO));
		}
		Map parameters = new HashMap();
		parameters = nonExpandableHandlerService.getIndentSocPrintMap(indentId);

		parameters.put("indentId", indentId);
		byte[] bytes = null;

		try {
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport(INDENT_TO_SOC_JASPER), parameters,
					(Connection) parameters.get("conn"));
		} catch (JRException e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment; filename="
				+ INDENT_TO_SOC_JASPER + ".pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printIndentDepotJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int indentId = 0;
		if (request.getParameter(INDENT_NO) != null
				&& !(request.getParameter(INDENT_NO).equals(""))) {
			indentId = Integer.parseInt(request.getParameter(INDENT_NO));
		}
		Map parameters = new HashMap();
		parameters = nonExpandableHandlerService
				.getIndentDepotPrintMap(indentId);

		parameters.put("indentId", indentId);
		byte[] bytes = null;

		try {
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport(INDENT_TO_DEPOT_JASPER), parameters,
					(Connection) parameters.get("conn"));
		} catch (JRException e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment; filename="
				+ INDENT_TO_DEPOT_JASPER + ".pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ModelAndView("index", "map", map);
	}

	/*
	 * This method is used for displaying MMF Indent Screen. In this we are
	 * making a call to data Service current year as Parameter. We get a list
	 * based on that. Here we are checking existence of current year MMF Indent.
	 * If MMF Indent is exists for Current Year ,we are displaying a message
	 * Otherwise are we will send the Data to Jsp with Current Year
	 */
	public ModelAndView showIndentJsp(HttpServletRequest request,
			HttpServletResponse response) {
		// Local Variable Declaration
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> indentMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		String date = (String) utilMap.get("currentDate");
		int year = Integer.parseInt(date.substring(6));
		String messageTOBeVisibleToTheUser = "";
		@SuppressWarnings("unused")
		int masterRecordExist = 0;
		int noOfRecordsAlreadyStored = 0;
		int indentId = 0;
		boolean flag = false;
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		// Method Body
		List<StoreIndentM> searchPanelIndentList = new ArrayList<StoreIndentM>();
		try {

			indentMap = nonExpandableHandlerService
					.checkExistenceOfCuurentYearIndent(year);
			if (flag) {
				jsp = INDENT_JSP;
				messageTOBeVisibleToTheUser = "For this Year	MMF Indent is Already there.If you want to change it,go to Search";
			} else {
				jsp = INDENT_JSP;
			}
			if ((session.getAttribute("itemList") == null)
					|| (session.getAttribute("sectionList") == null)) {
				map = nonExpandableHandlerService.showIndent();
				if (map.get("sectionList") != null) {
					sectionList = (List) map.get("sectionList");
					session.setAttribute("sectionList", sectionList);
				}
			}
			jsp = jsp + ".jsp";
			title = "Indent";
			if (indentMap.get("noOfRecordsAlreadyStored") != null)
				noOfRecordsAlreadyStored = Integer.parseInt(""
						+ indentMap.get("noOfRecordsAlreadyStored"));
			if (indentMap.get("indentId") != null)
				indentId = Integer.parseInt("" + indentMap.get("indentId"));
			if (indentMap.get("searchPanelIndentList") != null)
				searchPanelIndentList = (List) (indentMap
						.get("searchPanelIndentList"));

			map.put("searchPanelIndentList", searchPanelIndentList);
			map.put("noOfRecordsAlreadyStored", noOfRecordsAlreadyStored);
			map.put("indentId", indentId);
			map.put("contentJsp", jsp);
			map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
			map.put("title", title);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getItems(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		String itemNameField = "";
		String autoHint = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("requiredField") != null) {
			itemNameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(itemNameField) != null) {
			autoHint = (request.getParameter(itemNameField));
		}
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		dataMap.put("autoHint", autoHint);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		map = nonExpandableHandlerService.getItemListThroughAjax(dataMap);
		jsp = "result";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showIndentJspAF(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map<String, Object> map = new HashMap<String, Object>();
		map = nonExpandableHandlerService.showIndent();
		jsp = "indentOAFU";
		jsp = jsp + ".jsp";
		title = "Indent";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showIndentJspDepot(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		Map<String, Object> map = new HashMap<String, Object>();
		map = nonExpandableHandlerService.showIndentJspDepot(dataMap);
		jsp = INDENT_TO_DEPOT_NE_JSP;
		jsp = jsp + ".jsp";
		title = "Indent";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showIndentJspSOC(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		String jsp = "";
		try {
			map = nonExpandableHandlerService.showIndentJspSOC(dataMap);
		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = "indentToSocNe";
		jsp = jsp + ".jsp";
		title = "Indent";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView modifyIndent(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
		int pageNo = 1;
		jsp = INDENT_MODIFY;
		jsp += ".jsp";
		int radio_str = 0;
		if (request.getParameter(INDENT_IF_YEAR_EXISTS) != null) {
			radio_str = Integer.parseInt(request
					.getParameter(INDENT_IF_YEAR_EXISTS));
		}
		map = (Map) nonExpandableHandlerService.getIndentModifyMap(radio_str,
				pageNo);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("radio_str", radio_str);
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		itemList = nonExpandableHandlerService.getItemList();
		map.put("itemList", itemList);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView getHeader1(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		String jsp = "";
		int radioVal = 1;

		if (request.getParameter(RADIO_PVMS) != null) {

			radioVal = Integer.parseInt(request.getParameter(RADIO_PVMS));
			//System.out.println("radioval @@@@@@@@@@@@@222222 "+ request.getParameter(RADIO_PVMS));

		}

		if (radioVal == 1) {
			//System.out.println("1-----------------");
			jsp = "indent";
		} else if (radioVal == 2) {
			//System.out.println("2");
			jsp = "indentOAF";
		} else if (radioVal == 3) {
			//System.out.println("3");
			jsp = "indentBD";
		} else {
			//System.out.println("4");
			jsp = "socIndent";
		}
		map = nonExpandableHandlerService.showIndent();
		jsp += ".jsp";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getHeader(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		String jsp = "";
		int radioVal = 1;

		if (request.getParameter(RADIO_PVMS) != null) {

			radioVal = Integer.parseInt(request.getParameter(RADIO_PVMS));
			//System.out.println("radioval @@@@@@@@@@@@@222222 "+ request.getParameter(RADIO_PVMS));

		}

		if (radioVal == 1) {
			//System.out.println("1-----------------");
			jsp = "pvmsByDgrc";
		} else if (radioVal == 2) {
			//System.out.println("2");
			jsp = "indentByAf";
		} else if (radioVal == 3) {
			//System.out.println("3");
			jsp = "indentByDepot";
		} else {
			//System.out.println("4");
			jsp = "socIndent";
		}
		map = nonExpandableHandlerService.showIndent();
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchIndent(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		String fromDate = "";
		String toDate = "";
		String indentNo = "";
		int mmfYear = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> tempMap = new HashMap<String, Object>();
		Map<String, Object> searchFieldMap = new HashMap<String, Object>();
		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		try {
			if (request.getParameter(MMF_FOR_THE_YEAR) != null) {
				mmfYear = Integer.parseInt(request
						.getParameter(MMF_FOR_THE_YEAR));

			}
		} catch (Exception e) {
			//System.out.println("read   " + e);
		}

		searchFieldMap.put("mmfYear", mmfYear);
		try {
			tempMap = nonExpandableHandlerService.showIndent();
			if (tempMap.get("searchIndentList") != null)
				searchIndentList = (List) tempMap.get("searchIndentList");
			map = nonExpandableHandlerService.searchIndent(searchFieldMap);
			map.put("searchIndentList", searchIndentList);
		} catch (Exception e) {
			//System.out.println("eeeeeeeeeeeeeee    " + e);
			e.printStackTrace();
		}
		jsp = SEARCH_INDENT_JSP;
		jsp = jsp + ".jsp";
		title = "Indent";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchIndentSOC(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		jsp = MODIFY_INDENT_TO_SOC_NE_JSP;
		jsp += ".jsp";
		int indentId = 0;
		if (request.getParameter(INDENT_NO_FOR_SEARCH) != null) {
			indentId = Integer.parseInt(request
					.getParameter(INDENT_NO_FOR_SEARCH));
			dataMap.put("indentId", indentId);
			dataMap.put("deptId", deptId);
			map = (Map) nonExpandableHandlerService.searchIndentSOC(dataMap);
		}
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchIndentDepot(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {

		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
		int pageNo = 1;
		jsp = MODIFY_INDENT_TO_DEPOT_NE_JSP;
		jsp += ".jsp";
		int radio_str = 0;
		if (request.getParameter(INDENT_NO_FOR_SEARCH) != null) {
			radio_str = Integer.parseInt(request
					.getParameter(INDENT_NO_FOR_SEARCH));
			map = (Map) nonExpandableHandlerService.getIndentModifyMapForDepot(
					radio_str, pageNo);
		}
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("radio_str", radio_str);

		return new ModelAndView("index", "map", map);

	}

	public ModelAndView previousIndent(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		int indentId = 0;
		int indentNo = 0;
		Map infoMap = new HashMap();
		String previousPage = "yes";
		int pageNo = 1;
		try {
			if (request.getParameter("pageNo") != null) {
				pageNo = Integer.parseInt(request.getParameter("pageNo"));
				//System.out.println("pageNo       2==" + pageNo);
			}
			if (request.getParameter(INDENT_ID) != null) {
				indentId = Integer.parseInt(request.getParameter(INDENT_ID));
				//System.out.println("indentId       2==" + indentId);
			}
			if (request.getParameter(INDENT_NO) != null) {
				indentNo = Integer.parseInt(request.getParameter(INDENT_NO));
				//System.out.println("indentId       2==" + indentId);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		map = (Map) nonExpandableHandlerService.getIndentMAndT(indentId);
		jsp = "indent";
		jsp += ".jsp";
		//System.out.println("pageNo                    " + pageNo);

		map.put("indentId", indentId);
		map.put("maxIndentNo", indentNo);
		map.put("pageNo", pageNo);
		map.put("contentJsp", jsp);
		map.put("previousPage", previousPage);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * This method is used adding Header and Detail records to Indent. It is
	 * used for two operations(Next,Submit) based on the flag ie. buttonFlag
	 */
	public ModelAndView addNextOrSubmitIndent(HttpServletRequest request,
			HttpServletResponse response) {

		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Box box = HMSUtil.getBox(request);
		StoreIndentM storeIndentM = new StoreIndentM();
		@SuppressWarnings("unused")
		StoreIndentT storeIndentT = new StoreIndentT();
		String indentFrom = "";
		@SuppressWarnings("unused")
		Date indentDate = null;
		String indentTo = "";
		@SuppressWarnings("unused")
		int sectionId = 12;
		String nrs = "";
		int rows = 0;
		@SuppressWarnings("unused")
		String indentType = "p";
		int departmentId = 1;
		String encodedBy = "";
		Date encodedDate = null;
		String lastChgBy = "";
		@SuppressWarnings("unused")
		Date lastChgDate = null;
		String lastChgTime = "";
		String indentOption = "";
		String patientDetails = "";
		String justificationNiv = "";
		String pacJustification = "";
		String pacForeignAdd = "";
		String authority = "";
		String buttonName = "";
		int indentId = 0;
		int serialNo = 0;
		int itemId = 1;
		int stockIn = 0;
		int qtyInDemand = 0;
		int qtyInMmf = 0;
		int qtyReceived = 0;
		int radioVal = 0;
		int masDepartmentId = 1;
		int noOfRows = 0;
		BigDecimal unitRate = null;
		String brandName = "";
		int manufactureId = 1;
		String marketedBy = "";
		BigDecimal totalCost = null;
		Date lastReceiptDate = null;
		BigDecimal lastReceiptQty = null;
		Map<String, Object> infoMap = new HashMap<String, Object>();
		boolean flag = false;
		int pageNo = 1;
		String url = "";
		int mmfForTheYear = 0;
		String indentNo = "";

		if (request.getParameter(MMF_FOR_THE_YEAR) != null) {
			mmfForTheYear = Integer.parseInt(request
					.getParameter(MMF_FOR_THE_YEAR));
		}
		try {
			if (request.getParameter("buttonName") != null) {
				buttonName = request.getParameter("buttonName");
			}
			if (request.getParameter(CHANGED_DATE) != null) {
				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(request.getParameter(CHANGED_DATE)));
				lastChgDate = java.sql.Date.valueOf(date4MySQL);
			}
			if (request.getParameter(CHANGED_BY) != null) {
				lastChgBy = request.getParameter(CHANGED_BY);
			}
			if (request.getParameter(CHANGED_TIME) != null) {
				lastChgTime = request.getParameter(CHANGED_TIME);
			}

			if (request.getParameter(NO_OF_ROWS) != null) {
				noOfRows = Integer.parseInt(request.getParameter(NO_OF_ROWS));
			}
			if (request.getParameter("pageNo") != null) {
				pageNo = Integer.parseInt(request.getParameter("pageNo"));
				//System.out.println("pageNo       2==" + pageNo);
			}
			if (request.getParameter(INDENT_ID) != null) {
				indentId = Integer.parseInt(request.getParameter(INDENT_ID));
				//System.out.println("indentId       2==" + indentId);
			}
			if (request.getParameter(INDENT_NO) != null) {
				indentNo = (request.getParameter(INDENT_NO));
			}
			if (request.getParameter(RADIO_PVMS) != null) {

				radioVal = Integer.parseInt(request.getParameter(RADIO_PVMS));
				//System.out.println("radioval @@@@@@@@@@@@@222222 "+ request.getParameter(RADIO_PVMS));

			}
			if (radioVal == 1)
				indentType = "p";
			if (radioVal == 2)
				indentType = "a";
			if (radioVal == 3)
				indentType = "d";
			if (radioVal == 4) {
				indentType = "s";
				try {
					if (request.getParameter(DETAIL_OF_PATIENT) != null) {
						patientDetails = (request
								.getParameter(DETAIL_OF_PATIENT));
						//System.out.println("patientDetails       2=="	+ patientDetails);
					}
					if (request.getParameter(AUTHORITY) != null) {
						authority = (request.getParameter(AUTHORITY));
						//System.out.println("authority       2==" + authority);
					}
					if (request.getParameter(JUSTIFICATION) != null) {
						justificationNiv = (request.getParameter(JUSTIFICATION));
						//System.out.println("justificationNiv       2=="+ justificationNiv);
					}
					if (request.getParameter(GENERAL_DETAILS) != null) {
						pacJustification = (request
								.getParameter(GENERAL_DETAILS));
						//System.out.println("pacJustification       2=="+ pacJustification);
					}
					if (request.getParameter(ADDRESS_OF) != null) {
						pacForeignAdd = (request.getParameter(ADDRESS_OF));
						//System.out.println("pacForeignAdd       2=="+ pacForeignAdd);
					}
					//System.out.println("patientDetails       2=="	+ patientDetails);
					//System.out.println("authority       2==" + authority);
					//System.out.println("justificationNiv       2=="+ justificationNiv);
					//System.out.println("pacJustification       2=="+ pacJustification);
					//System.out.println("pacForeignAdd       2=="+ pacForeignAdd);
				} catch (Exception e) {
					//System.out.println("333333333333333333   " + e);
				}
			}
			if (request.getParameter(TYPE_OF_INDENT) != null) {
				indentOption = (request.getParameter(TYPE_OF_INDENT));
				if (Integer.parseInt(request.getParameter(TYPE_OF_INDENT)) == 1) {
					indentOption = "Monthly";
				} else {
					indentOption = "Yearly";
				}
			}

			if (pageNo != 1) {
				indentId = nonExpandableHandlerService
						.getIndentId((mmfForTheYear));
			}
			if (request.getParameter(INDENT_FROM) != null) {
				indentFrom = (request.getParameter(INDENT_FROM));
				//System.out.println("indentFrom       2==" + indentFrom);
			}
			if (request.getParameter(INDENT_TO) != null) {
				indentTo = (request.getParameter(INDENT_TO));
				//System.out.println("indentTo       2==" + indentTo);
			}

		} catch (Exception e) {
			//System.out.println("eee eee " + e);
			e.printStackTrace();
		}
		try {
			String te = "";

			if (request.getParameter(INDENT_DATE) != null) {
				te = (String) (request.getParameter(INDENT_DATE));
				//System.out.println("te  " + te);

				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(request.getParameter(INDENT_DATE)));
				indentDate = java.sql.Date.valueOf(date4MySQL);
			}
		} catch (Exception e) {
			//System.out.println("222222222222222222             " + e);
		}

		try {
			if (request.getParameter(NRS) != null) {
				nrs = (request.getParameter(NRS));
				//System.out.println("nrs       2==" + nrs);
			}
		} catch (Exception e) {
			//System.out.println("--------------------   " + e);
		}

		if (request.getParameter(NO_OF_ROWS) != null) {

			rows = Integer.parseInt(request.getParameter(NO_OF_ROWS));
			//System.out.println("rows       2==" + rows);
		}

		String headerStored = "no";

		if (pageNo == 1) {
			try {
				storeIndentM.setIndentNo(null);
				storeIndentM.setIndentDate(indentDate);
				storeIndentM.setRequiredForm(indentFrom);
				MasStoreSection masStoreSection = new MasStoreSection();
				masStoreSection.setId(sectionId);

				storeIndentM.setNrs(nrs);
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				storeIndentM.setDepartment(masDepartment);
				storeIndentM.setIndentType(indentType);
				storeIndentM.setEncodedBy(encodedBy);
				storeIndentM.setEncodedDate(indentDate);
				storeIndentM.setLastChgBy(lastChgBy);
				storeIndentM.setLastChgDate(indentDate);
				storeIndentM.setLastChgTime(lastChgTime);
				storeIndentM.setStatus("o");
				storeIndentM.setIndentOption(indentOption);
				storeIndentM.setSuppliedBy(null);
				storeIndentM.setPatientDetails(patientDetails);
				storeIndentM.setJustificationNiv(justificationNiv);
				storeIndentM.setPacJustification(pacJustification);
				storeIndentM.setPacForeignAdd(pacForeignAdd);
				storeIndentM.setAuthority(authority);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				storeIndentM.setHospital(masHospital);
				storeIndentM.setMmfForTheYear(mmfForTheYear);
				storeIndentM.setIndentNo(indentNo);
				storeIndentM.setImported("n");

			} catch (Exception e) {
				//System.out.println("Header " + e);
			}
		} else {

			headerStored = "yes";
			infoMap.put("headerStored", headerStored);
		}

		int length = 0;
		List<StoreIndentT> storeIndentTlist = new ArrayList<StoreIndentT>(10);
		try {
			int srNo[] = JKTRequestUtils.getRequiredIntParameters(request,
					SR_NO);
			int itemIdArray[] = JKTRequestUtils.getRequiredIntParameters(
					request, ITEM_ID);
			int qtyInMmyArray[] = JKTRequestUtils.getRequiredIntParameters(
					request, QTY_IN_MMF);

			//System.out.println("srNo[]   " + srNo.length);
			//System.out.println("itemIdArray[]   " + itemIdArray.length);
			//System.out.println("qtyInMmyArray[]   " + qtyInMmyArray.length);
			if (buttonName.equals("next")) {
				// if(buttonFlag != null){
				length = 8;
			} else {
				length = noOfRows;
			}
			for (int i = 0; i < length; i++) {

				if (itemIdArray[i] != 0) {
					StoreIndentT storeIndentTObj = new StoreIndentT();
					storeIndentTObj.setSerialNo(srNo[i]);

					MasStoreItem masItem = new MasStoreItem();
					masItem.setId(itemIdArray[i]);
					storeIndentTObj.setItem(masItem);

					storeIndentTObj.setStockIn(null);

					BigDecimal bigDecimal = new BigDecimal(qtyInMmyArray[i]);
					storeIndentTObj.setQtyInMmf(bigDecimal);
					storeIndentTObj.setQtyInDemand(null);
					storeIndentTObj.setQtyReceived(null);

					storeIndentTObj.setSection(null);
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(masDepartmentId);

					storeIndentTObj.setUnitRate(unitRate);
					storeIndentTObj.setBrand(null);

					MasManufacturer manufacturer = new MasManufacturer();
					manufacturer.setId(manufactureId);
					storeIndentTObj.setManufacture(manufacturer);
					storeIndentTObj.setMarketedBy(marketedBy);
					storeIndentTObj.setTotalCost(totalCost);
					storeIndentTObj.setLastReceiptDate(lastReceiptDate);
					storeIndentTObj.setLastReceiptQty(lastReceiptQty);

					// storeIndentTObj.setIndent();

					storeIndentTlist.add(storeIndentTObj);
				}
			}

		} catch (Exception e) {
			//System.out.println("699999999999999999999       " + e);
		}
		infoMap.put("pageNo", pageNo);
		infoMap.put("indentId", indentId);
		infoMap.put("deptId", deptId);
		infoMap.put("userName", userName);
		infoMap.put("hospitalId", hospitalId);
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		try {
			flag = nonExpandableHandlerService.addNextOrSubmitIndentToMMF(
					storeIndentM, storeIndentTlist, infoMap);
			indentId = nonExpandableHandlerService.getIndentId(mmfForTheYear);

		} catch (Exception e) {
			e.printStackTrace();
		}
		String messageTOBeVisibleToTheUser = "";
		if (flag) {
			messageTOBeVisibleToTheUser = "MMf Indent  Records Added Successfully";
		} else {
			messageTOBeVisibleToTheUser = "MMf Indent  Records Not Added Successfully";
		}
		if (buttonName.equals("next")) {
			jsp = INDENT_JSP;
		} else {
			jsp = STORES_MESSAGE_JSP;
			url = "/hms/hms/stores?method=showIndentJsp";
		}
		pageNo = pageNo + 1;
		jsp += ".jsp";
		map.put("indentOption", indentOption);
		map.put("indentId", indentId);
		map.put("pageNo", pageNo);
		map.put("contentJsp", jsp);
		map.put("mmfForTheYear", mmfForTheYear);
		map.put("url", url);
		itemList = nonExpandableHandlerService.getItemList();
		map.put("itemList", itemList);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * This method is used adding Header and Detail records to Indent To Indent.
	 * It is used for two operations(Next,Submit) based on the flag ie.
	 * buttonFlag
	 */
	public ModelAndView updateNextOrSubmitIndentToDepot(
			HttpServletRequest request, HttpServletResponse response)
			throws java.text.ParseException {

		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		/***********************************************************************
		 * Local Variable Declaration*
		 **********************************************************************/
		StoreIndentM storeIndentM = new StoreIndentM();
		StoreIndentT storeIndentT = new StoreIndentT();
		List<StoreIndentT> storeIndentTListForUpdate = new ArrayList<StoreIndentT>();
		List<StoreIndentT> storeIndentTListForAdd = new ArrayList<StoreIndentT>();
		Map<String, Object> masterAndDetailMap = new HashMap<String, Object>();
		List<StoreIndentT> gridIndentTList = new ArrayList<StoreIndentT>();
		StoreIndentM storeIndentMObj = new StoreIndentM();
		Map map2 = new HashMap();
		String indentNo = "";
		String indentFrom = "";
		Date indentDate = null;
		String indentTo = "";
		int sectionId = 12;
		String nrs = "";
		int rows = 0;
		String indentType = "d";
		int departmentId = 1;
		String encodedBy = "";
		Date encodedDate = null;
		String lastChgBy = "A";
		String lastChgTime = "";
		String indentOption = "";
		String patientDetails = "";
		String justificationNiv = "";
		String pacJustification = "";
		String pacForeignAdd = "";
		String authority = "";
		int indentId = 0;
		int serialNo = 0;
		int itemId = 1;
		int stockIn = 0;
		int qtyInDemand = 0;
		int qtyInMmf = 0;
		int qtyReceived = 0;
		int radioVal = 0;
		int totalRecords = 0;
		int mmfForTheYear = 0;
		int idArrayLength = 0;
		int length = 0;
		String messageTOBeVisibleToTheUser = "";
		// Grid related Variables
		int pageNo = 1;
		/** Represents Page No */
		String buttonName = "";
		/** Represents which button user clicked in JSP(Next/Submit) */
		String noDetailRecords = "no";
		/** Represents */
		String headerStored = "no";
		String url = "";
		Date lastChgDate = new Date();
		int noOfRows = 0;
		int supplyDepot = 0;
		String address = "";
		// Method Body

		try {
			/*******************************************************************
			 * Getting Header Information From JSP*
			 ******************************************************************/

			if (request.getParameter("buttonName") != null) {
				buttonName = request.getParameter("buttonName");
			}
			if (request.getParameter(INDENT_ID) != null) {
				indentId = Integer.parseInt(request.getParameter(INDENT_ID));
			}
			if (request.getParameter("noDetailRecords") != null) {
				noDetailRecords = (request.getParameter("noDetailRecords"));
			}
			if (request.getParameter(CHANGED_DATE) != null) {
				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(request.getParameter(CHANGED_DATE)));
				lastChgDate = java.sql.Date.valueOf(date4MySQL);
			}
			if (request.getParameter(CHANGED_BY) != null) {
				lastChgBy = request.getParameter(CHANGED_BY);
			}
			if (request.getParameter(CHANGED_TIME) != null) {
				lastChgTime = request.getParameter(CHANGED_TIME);
			}

			if (request.getParameter(NO_OF_ROWS) != null) {
				noOfRows = Integer.parseInt(request.getParameter(NO_OF_ROWS));
			}
			if (request.getParameter("pageNo") != null) {
				pageNo = Integer.parseInt(request.getParameter("pageNo"));
			}

			if (request.getParameter(INDENT_NO) != null) {
				indentNo = (request.getParameter(INDENT_NO));
			}
			if (request.getParameter(TYPE_OF_INDENT) != null) {
				indentOption = (request.getParameter(TYPE_OF_INDENT));
			}
			if (request.getParameter(INDENT_FROM) != null) {
				indentFrom = (request.getParameter(INDENT_FROM));
				//System.out.println("indentFrom       2==" + indentFrom);
			}
			if (request.getParameter(SUPPLY_DEPOT) != null) {
				supplyDepot = Integer.parseInt((request
						.getParameter(SUPPLY_DEPOT)));
			}
			if (request.getParameter(INDENT_DATE) != null) {
				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(request.getParameter(INDENT_DATE)));
				indentDate = java.sql.Date.valueOf(date4MySQL);
			}
			if (request.getParameter(NRS) != null) {
				nrs = (request.getParameter(NRS));
				//System.out.println("nrs       2==" + nrs);
			}
			if (request.getParameter(SECTION_ID) != null) {
				sectionId = Integer.parseInt(""
						+ request.getParameter(SECTION_ID));
			}
			if (request.getParameter(AUTHORITY) != null) {
				authority = (request.getParameter(AUTHORITY));
			}
			if (request.getParameter(ADDRESS) != null) {
				address = (request.getParameter(ADDRESS));
			}

		} catch (Exception e) {
			//System.out.println("eee eee " + e);
			e.printStackTrace();
		}
		if (pageNo == 1) {
			/*******************************************************************
			 * Storing the form(JSP) data in Header object * This operation
			 * performed only when page no is 1 *
			 ******************************************************************/
			try {
				storeIndentM.setId(indentId);
				storeIndentM.setIndentNo(indentNo);
				storeIndentM.setIndentDate(indentDate);
				storeIndentM.setRequiredForm(indentFrom);
				MasStoreAirForceDepot masStoreSupplier = new MasStoreAirForceDepot();
				masStoreSupplier.setId(supplyDepot);
				storeIndentM.setSuppliedBy(masStoreSupplier);
				MasStoreSection masStoreSection = new MasStoreSection();
				masStoreSection.setId(sectionId);
				storeIndentM.setSection(masStoreSection);
				storeIndentM.setNrs(nrs);
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				storeIndentM.setDepartment(masDepartment);
				storeIndentM.setIndentType(indentType);
				storeIndentM.setEncodedBy(encodedBy);
				storeIndentM.setEncodedDate(indentDate);
				storeIndentM.setLastChgBy(lastChgBy);
				storeIndentM.setLastChgDate(indentDate);
				storeIndentM.setLastChgTime(lastChgTime);
				storeIndentM.setStatus("o");
				storeIndentM.setIndentOption(indentOption);

				storeIndentM.setPatientDetails(patientDetails);
				storeIndentM.setJustificationNiv(justificationNiv);
				storeIndentM.setPacJustification(pacJustification);
				storeIndentM.setPacForeignAdd(pacForeignAdd);
				storeIndentM.setAuthority(authority);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				storeIndentM.setHospital(masHospital);
				storeIndentM.setMmfForTheYear(mmfForTheYear);
				storeIndentM.setIndentNo(indentNo);
				storeIndentM.setImported("n");
				storeIndentM.setPatientDetails(address);

			} catch (Exception e) {
				//System.out.println("Header " + e);
			}
		}
		try {

			if (noDetailRecords.equals("no")) {
				/***************************************************************
				 * Storing the form(JSP) data in Detail object *
				 **************************************************************/

				int srNo[] = JKTRequestUtils.getRequiredIntParameters(request,
						SR_NO);
				int idArray[] = JKTRequestUtils.getRequiredIntParameters(
						request, DETAIL_ID);
				idArrayLength = idArray.length;

				int itemIdArray[] = JKTRequestUtils.getRequiredIntParameters(
						request, ITEM_ID);
				String qtyInHandStringArray[] = JKTRequestUtils
						.getRequiredStringParameters(request, QTY_IN_HAND);
				String qtyInMmfArray[] = JKTRequestUtils
						.getRequiredStringParameters(request, QTY_IN_MMF);
				String qtyDemandArray[] = JKTRequestUtils
						.getRequiredStringParameters(request, QTY_DEMAND_TEMP);
				BigDecimal[] qtyInHandArray = new BigDecimal[10];
				int xxLegnt = qtyInHandStringArray.length;
				String cost[] = JKTRequestUtils.getRequiredStringParameters(
						request, COST);
				String remarks[] = JKTRequestUtils.getRequiredStringParameters(
						request, REMARKS);

				for (int i = 0; i < xxLegnt; i++) {
					BigDecimal val = new BigDecimal(qtyInHandStringArray[i]);
					qtyInHandArray[i] = val;
				}

				//System.out.println("idArrayLength   " + idArrayLength);
				length = srNo.length;
				for (int i = 0; i < length; i++) {
					if (idArrayLength > 0) {
						//System.out.println("idArrayLength 111   "+ idArrayLength);
						StoreIndentT storeIndentTObj = new StoreIndentT();
						storeIndentTObj.setId(idArray[i]);
						storeIndentTObj.setSerialNo(srNo[i]);
						MasStoreItem masItem = new MasStoreItem();
						masItem.setId(itemIdArray[i]);
						storeIndentTObj.setItem(masItem);
						storeIndentTObj.setStockIn(qtyInHandArray[i]);

						BigDecimal bigDecimal = new BigDecimal(qtyInMmfArray[i]);
						storeIndentTObj.setQtyInMmf(bigDecimal);
						BigDecimal bigDecimal2 = new BigDecimal(
								qtyDemandArray[i]);
						storeIndentTObj.setQtyInDemand(bigDecimal2);
						storeIndentTObj.setQtyReceived(null);

						storeIndentTObj.setSection(null);
						MasDepartment masDepartment = new MasDepartment();
						masDepartment.setId(deptId);
						StoreIndentM storeIndentM2 = new StoreIndentM();
						storeIndentM2.setId(indentId);
						storeIndentTObj.setIndent(storeIndentM2);
						BigDecimal unitRate = null;
						String brandName = "";
						int manufactureId = 1;
						String marketedBy = "";
						BigDecimal totalCost = null;
						Date lastReceiptDate = null;
						BigDecimal lastReceiptQty = null;

						storeIndentTObj.setUnitRate(unitRate);
						storeIndentTObj.setBrand(null);

						storeIndentTObj.setManufacture(null);
						storeIndentTObj.setMarketedBy(marketedBy);
						storeIndentTObj.setTotalCost(totalCost);
						storeIndentTObj.setLastReceiptDate(lastReceiptDate);
						storeIndentTObj.setLastReceiptQty(lastReceiptQty);
						if (!(cost[i].equals("0")) || (cost[i]) != null)
							storeIndentTObj
									.setTotalCost(new BigDecimal(cost[i]));
						if (!remarks.equals("emptyString"))
							storeIndentTObj.setRemarks(remarks[i]);

						storeIndentTListForUpdate.add(storeIndentTObj);
					} else {
						//System.out.println("idArrayLength 222   "	+ idArrayLength);
						if (itemIdArray[i] != 0) {
							StoreIndentT storeIndentTObj = new StoreIndentT();

							storeIndentTObj.setSerialNo(srNo[i]);

							MasStoreItem masItem = new MasStoreItem();
							masItem.setId(itemIdArray[i]);
							storeIndentTObj.setItem(masItem);

							storeIndentTObj.setStockIn(null);

							BigDecimal bigDecimal = new BigDecimal(
									qtyInMmfArray[i]);
							storeIndentTObj.setQtyInMmf(bigDecimal);
							storeIndentTObj.setQtyReceived(null);
							storeIndentTObj.setQtyInDemand(new BigDecimal(
									qtyDemandArray[i]));

							storeIndentTObj.setSection(null);

							MasDepartment masDepartment = new MasDepartment();
							masDepartment.setId(deptId);
							StoreIndentM storeIndentM2 = new StoreIndentM();
							storeIndentM2.setId(indentId);
							storeIndentTObj.setIndent(storeIndentM2);
							BigDecimal unitRate = null;
							String brandName = "";
							int manufactureId = 1;
							String marketedBy = "";
							BigDecimal totalCost = null;
							Date lastReceiptDate = null;
							BigDecimal lastReceiptQty = null;
							storeIndentTObj.setUnitRate(unitRate);
							storeIndentTObj.setBrand(null);

							storeIndentTObj.setManufacture(null);
							storeIndentTObj.setMarketedBy(marketedBy);
							storeIndentTObj.setTotalCost(totalCost);
							storeIndentTObj.setLastReceiptDate(lastReceiptDate);
							storeIndentTObj.setLastReceiptQty(lastReceiptQty);
							if (!(cost[i].equals("0")) || (cost[i]) != null)
								storeIndentTObj.setTotalCost(new BigDecimal(
										cost[i]));
							if (!remarks.equals("emptyString"))
								storeIndentTObj.setRemarks(remarks[i]);
							storeIndentTListForAdd.add(storeIndentTObj);
						}
					}
					idArrayLength--;
				}

			} else {
				int srNo[] = JKTRequestUtils.getRequiredIntParameters(request,
						SR_NO);
				int itemIdArray[] = JKTRequestUtils.getRequiredIntParameters(
						request, ITEM_ID);
				String qtyInMmyArray[] = JKTRequestUtils
						.getRequiredStringParameters(request, QTY_IN_MMF);
				String qtyDemandArray[] = JKTRequestUtils
						.getRequiredStringParameters(request, QTY_DEMAND_TEMP);
				String cost[] = JKTRequestUtils.getRequiredStringParameters(
						request, COST);
				String remarks[] = JKTRequestUtils.getRequiredStringParameters(
						request, REMARKS);
				length = srNo.length;
				for (int i = 0; i < length; i++) {
					//System.out.println("idArrayLength 333   " + i);
					if (itemIdArray[i] != 0) {
						StoreIndentT storeIndentTObj = new StoreIndentT();
						storeIndentTObj.setSerialNo(srNo[i]);
						MasStoreItem masItem = new MasStoreItem();
						masItem.setId(itemIdArray[i]);
						storeIndentTObj.setItem(masItem);

						storeIndentTObj.setStockIn(null);

						BigDecimal bigDecimal = new BigDecimal(qtyInMmyArray[i]);
						storeIndentTObj.setQtyInMmf(bigDecimal);
						storeIndentTObj.setQtyReceived(null);
						storeIndentTObj.setQtyInDemand(new BigDecimal(
								qtyDemandArray[i]));

						storeIndentTObj.setSection(null);

						MasDepartment masDepartment = new MasDepartment();
						masDepartment.setId(deptId);
						StoreIndentM storeIndentM2 = new StoreIndentM();
						storeIndentM2.setId(indentId);
						storeIndentTObj.setIndent(storeIndentM2);
						BigDecimal unitRate = null;
						String brandName = "";
						int manufactureId = 1;
						String marketedBy = "";
						BigDecimal totalCost = null;
						Date lastReceiptDate = null;
						BigDecimal lastReceiptQty = null;

						storeIndentTObj.setUnitRate(unitRate);
						storeIndentTObj.setBrand(null);

						storeIndentTObj.setManufacture(null);
						storeIndentTObj.setMarketedBy(marketedBy);
						storeIndentTObj.setTotalCost(totalCost);
						storeIndentTObj.setLastReceiptDate(lastReceiptDate);
						storeIndentTObj.setLastReceiptQty(lastReceiptQty);
						if (!(cost[i].equals("0")) || (cost[i]) != null)
							storeIndentTObj
									.setTotalCost(new BigDecimal(cost[i]));
						if (!remarks.equals("emptyString"))
							storeIndentTObj.setRemarks(remarks[i]);
						storeIndentTListForAdd.add(storeIndentTObj);
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		masterAndDetailMap.put("storeIndentTListForUpdate",
				storeIndentTListForUpdate);
		masterAndDetailMap
				.put("storeIndentTListForAdd", storeIndentTListForAdd);
		masterAndDetailMap.put("storeIndentM", storeIndentM);
		masterAndDetailMap.put("indentId", indentId);
		masterAndDetailMap.put("pageNo", pageNo);
		boolean flag = nonExpandableHandlerService
				.updateNextIndentToDepot(masterAndDetailMap);

		pageNo++;
		if (flag) {
			if (indentId != 0) {
				map = (Map) nonExpandableHandlerService
						.getIndentModifyMapForDepot(indentId, pageNo);
			}
			if (map.get("gridIndentTList") != null)
				gridIndentTList = (List<StoreIndentT>) map
						.get("gridIndentTList");

			if (gridIndentTList.size() == 0) {
				noDetailRecords = "yes";
				//System.out.println("88888888888888888888888888");
				//System.out.println(noDetailRecords);
				//System.out.println("88888888888888888888888888");
			}
			if ((gridIndentTList.size() != 0) || (buttonName.equals("next"))) {
				jsp = MODIFY_INDENT_TO_DEPOT_NE_JSP;
			}
			if ((buttonName.equals("submit"))) {
				jsp = MODIFY_INDENT_TO_DEPOT_NE_JSP;
				messageTOBeVisibleToTheUser = "Indent To Depot Records Updated Successfully";
				url = "/hms/hms/nonExp?method=showIndentJspDepot";
			}

		} else {
			jsp = MODIFY_INDENT_TO_DEPOT_NE_JSP;
			messageTOBeVisibleToTheUser = "Indent To Depot Records Not Updated Successfully";
			url = "/hms/hms/nonExp?method=showIndentJspDepot";
		}

		jsp += ".jsp";
		map.put("url", url);
		map.put("maxIndentNo", indentNo);
		map.put("indentId", indentId);
		map.put("pageNo", pageNo);
		map.put("contentJsp", jsp);
		map.put("noDetailRecords", noDetailRecords);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);

		map.put("indentNo", indentNo);
		map.put(" indentFrom", indentFrom);
		map.put("indentDate", indentDate);
		map.put("supplyDepot", supplyDepot);
		map.put("sectionId", sectionId);
		map.put("indentOption", indentOption);
		map.put("nrs", nrs);
		map.put("authority", authority);
		map.put("address", address);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getItemListForIndentToSOC(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		String itemNameField = "";
		String autoHint = "";
		int sectionId = 0;
		int indentId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			if (request.getParameter("section") != null) {
				sectionId = Integer.parseInt(""
						+ (request.getParameter("section")));
			}
			if (request.getParameter("indentId") != null) {
				indentId = Integer.parseInt(""
						+ (request.getParameter("indentId")));
			}
			List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
			dataMap.put("autoHint", autoHint);
			dataMap.put("deptId", deptId);
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("sectionId", sectionId);
			dataMap.put("indentId", indentId);

			map = nonExpandableHandlerService
					.getItemListForIndentToSOC(dataMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "result";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView updateNextOrSubmitIndent(HttpServletRequest request,
			HttpServletResponse response) throws java.text.ParseException {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------

		// Local Variable Declaration
		StoreIndentM storeIndentM = new StoreIndentM();
		StoreIndentT storeIndentT = new StoreIndentT();
		List<StoreIndentT> storeIndentTListForUpdate = new ArrayList<StoreIndentT>();
		List<StoreIndentT> storeIndentTListForAdd = new ArrayList<StoreIndentT>();
		Map<String, Object> masterAndDetailMap = new HashMap<String, Object>();
		List<StoreIndentT> gridIndentTList = new ArrayList<StoreIndentT>();
		Map map2 = new HashMap();
		String indentNo = "";
		String indentFrom = "";
		Date indentDate = null;
		String indentTo = "";
		int sectionId = 12;
		String nrs = "";
		int rows = 0;
		String indentType = "p";
		int departmentId = 1;
		String encodedBy = "";
		Date encodedDate = null;
		String lastChgBy = "A";
		String lastChgDate = null;
		String lastChgTime = "";
		String indentOption = "";
		String patientDetails = "";
		String justificationNiv = "";
		String pacJustification = "";
		String pacForeignAdd = "";
		String authority = "";
		int indentId = 0;
		int serialNo = 0;
		int itemId = 1;
		int stockIn = 0;
		int qtyInDemand = 0;
		int qtyInMmf = 0;
		int qtyReceived = 0;
		int radioVal = 0;
		int masDepartmentId = 1;
		Map infoMap = new HashMap();
		int totalRecords = 0;
		int mmfForTheYear = 0;
		int idArrayLength = 0;
		int length = 0;
		String messageTOBeVisibleToTheUser = "";
		// Grid related Variables
		int pageNo = 1;
		/** Represents Page No */
		String buttonName = "";
		/** Represents which button user clicked in JSP(Next/Submit) */
		String noDetailRecords = "no";
		/** Represents */
		String headerStored = "no";
		String url = "";
		// Method Body
		try {
			if (request.getParameter("pageNo") != null) {
				pageNo = Integer.parseInt(request.getParameter("pageNo"));

			}
			if (request.getParameter(NO_DETAIL_RECORDS) != null) {
				noDetailRecords = (request.getParameter(NO_DETAIL_RECORDS));

			}
			if (request.getParameter("totalRecords") != null) {
				totalRecords = Integer.parseInt(request
						.getParameter("totalRecords"));

			}
			if (request.getParameter(INDENT_ID) != null) {
				indentId = Integer.parseInt(request.getParameter(INDENT_ID));
			}

			if (request.getParameter("buttonName") != null) {
				buttonName = request.getParameter("buttonName");
			}
			if (request.getParameter(CHANGED_DATE) != null) {
				lastChgDate = request.getParameter(CHANGED_DATE);
			}
			if (request.getParameter(CHANGED_BY) != null) {
				lastChgBy = request.getParameter(CHANGED_BY);
			}
			if (request.getParameter(CHANGED_TIME) != null) {
				lastChgTime = request.getParameter(CHANGED_TIME);
			}
			//System.out.println("lastChgDate in C----------" + lastChgDate);
			//System.out.println("lastChgBy in C----------" + lastChgBy);
			//System.out.println("lastChgTime in C----------" + lastChgTime);
			masterAndDetailMap.put("pageNo", pageNo);
			masterAndDetailMap.put("lastChgDate", lastChgDate);
			masterAndDetailMap.put("lastChgBy", lastChgBy);
			masterAndDetailMap.put("lastChgTime", lastChgTime);
			masterAndDetailMap.put("indentId", indentId);

		} catch (Exception e) {
			//System.out.println("222222222222222222             " + e);
		}

		if (pageNo == 1) {

		} else {

			headerStored = "yes";
			infoMap.put("headerStored", headerStored);
		}

		try {
			if (noDetailRecords.equals("no")) {
				int idArray[] = JKTRequestUtils.getRequiredIntParameters(
						request, DETAIL_ID);
				idArrayLength = idArray.length;
				int srNo[] = JKTRequestUtils.getRequiredIntParameters(request,
						SR_NO);
				int itemIdArray[] = JKTRequestUtils.getRequiredIntParameters(
						request, ITEM_ID);
				String qtyInMmyArray[] = JKTRequestUtils
						.getRequiredStringParameters(request, QTY_IN_MMF);

				length = srNo.length;
				for (int i = 0; i < length; i++) {
					if (idArrayLength > 0) {
						//System.out.println("idArrayLength 111   "	+ idArrayLength);
						StoreIndentT storeIndentTObj = new StoreIndentT();
						storeIndentTObj.setId(idArray[i]);
						storeIndentTObj.setSerialNo(srNo[i]);
						MasStoreItem masItem = new MasStoreItem();
						masItem.setId(itemIdArray[i]);
						storeIndentTObj.setItem(masItem);
						storeIndentTObj.setStockIn(null);

						// StringBuffer output_str = new StringBuffer();
						// StringTokenizer s = new
						// StringTokenizer(qtyInMmyArray[i].toString(),".");
						BigDecimal bigDecimal = new BigDecimal(qtyInMmyArray[i]);
						storeIndentTObj.setQtyInMmf(bigDecimal);
						storeIndentTObj.setQtyInDemand(null);
						storeIndentTObj.setQtyReceived(null);

						MasDepartment masDepartment = new MasDepartment();
						masDepartment.setId(masDepartmentId);
						StoreIndentM storeIndentM2 = new StoreIndentM();
						storeIndentM2.setId(indentId);
						storeIndentTObj.setIndent(storeIndentM2);
						BigDecimal unitRate = null;
						String brandName = "";
						String marketedBy = "";
						BigDecimal totalCost = null;
						Date lastReceiptDate = null;
						BigDecimal lastReceiptQty = null;

						storeIndentTObj.setUnitRate(unitRate);
						storeIndentTObj.setBrand(null);

						storeIndentTObj.setManufacture(null);
						storeIndentTObj.setMarketedBy(marketedBy);
						storeIndentTObj.setTotalCost(totalCost);
						storeIndentTObj.setLastReceiptDate(lastReceiptDate);
						storeIndentTObj.setLastReceiptQty(lastReceiptQty);

						storeIndentTListForUpdate.add(storeIndentTObj);
					} else {
						//System.out.println("idArrayLength 222   "+ idArrayLength);
						if (itemIdArray[i] != 0) {
							StoreIndentT storeIndentTObj = new StoreIndentT();

							storeIndentTObj.setSerialNo(srNo[i]);

							MasStoreItem masItem = new MasStoreItem();
							masItem.setId(itemIdArray[i]);
							storeIndentTObj.setItem(masItem);
							BigDecimal bigDecimal = new BigDecimal(
									qtyInMmyArray[i]);
							storeIndentTObj.setQtyInMmf(bigDecimal);
							storeIndentTObj.setQtyInDemand(null);
							storeIndentTObj.setQtyReceived(null);
							storeIndentTObj.setSection(null);

							MasDepartment masDepartment = new MasDepartment();
							masDepartment.setId(masDepartmentId);
							StoreIndentM storeIndentM2 = new StoreIndentM();
							storeIndentM2.setId(indentId);
							storeIndentTObj.setIndent(storeIndentM2);
							BigDecimal unitRate = null;
							String brandName = "";
							int manufactureId = 0;
							String marketedBy = "";
							BigDecimal totalCost = null;
							Date lastReceiptDate = null;
							BigDecimal lastReceiptQty = null;
							storeIndentTObj.setUnitRate(unitRate);
							storeIndentTObj.setBrand(null);

							storeIndentTObj.setManufacture(null);
							storeIndentTObj.setMarketedBy(marketedBy);
							storeIndentTObj.setTotalCost(totalCost);
							storeIndentTObj.setLastReceiptDate(lastReceiptDate);
							storeIndentTObj.setLastReceiptQty(lastReceiptQty);
							storeIndentTListForAdd.add(storeIndentTObj);
						}
					}
					idArrayLength--;
				}

			} else {
				int srNo[] = JKTRequestUtils.getRequiredIntParameters(request,
						SR_NO);
				int itemIdArray[] = JKTRequestUtils.getRequiredIntParameters(
						request, ITEM_ID);
				String qtyInMmyArray[] = JKTRequestUtils
						.getRequiredStringParameters(request, QTY_IN_MMF);
				length = srNo.length;
				for (int i = 0; i < length; i++) {
					//System.out.println("idArrayLength 333   " + i);
					if (itemIdArray[i] != 0) {
						StoreIndentT storeIndentTObj = new StoreIndentT();
						storeIndentTObj.setSerialNo(srNo[i]);
						MasStoreItem masItem = new MasStoreItem();
						masItem.setId(itemIdArray[i]);
						storeIndentTObj.setItem(masItem);

						storeIndentTObj.setStockIn(null);
						BigDecimal bigDecimal = new BigDecimal(qtyInMmyArray[i]);
						storeIndentTObj.setQtyInMmf(bigDecimal);
						storeIndentTObj.setQtyInDemand(null);
						storeIndentTObj.setQtyReceived(null);
						storeIndentTObj.setSection(null);

						MasDepartment masDepartment = new MasDepartment();
						masDepartment.setId(masDepartmentId);
						StoreIndentM storeIndentM2 = new StoreIndentM();
						storeIndentM2.setId(indentId);
						storeIndentTObj.setIndent(storeIndentM2);
						BigDecimal unitRate = null;
						String brandName = "";
						int manufactureId = 0;
						String marketedBy = "";
						BigDecimal totalCost = null;
						Date lastReceiptDate = null;
						BigDecimal lastReceiptQty = null;

						storeIndentTObj.setUnitRate(unitRate);
						storeIndentTObj.setBrand(null);

						storeIndentTObj.setManufacture(null);
						storeIndentTObj.setMarketedBy(marketedBy);
						storeIndentTObj.setTotalCost(totalCost);
						storeIndentTObj.setLastReceiptDate(lastReceiptDate);
						storeIndentTObj.setLastReceiptQty(lastReceiptQty);
						storeIndentTListForAdd.add(storeIndentTObj);
					}
				}

			}

		} catch (Exception e) {
			//System.out.println("699999999999999999999       " + e);
			e.printStackTrace();
		}
		//System.out.println("storeIndentTListForUpdate     "+ storeIndentTListForUpdate.size());
		//System.out.println("storeIndentTListForAdd     "+ storeIndentTListForAdd.size());
		masterAndDetailMap.put("storeIndentTListForUpdate",
				storeIndentTListForUpdate);
		masterAndDetailMap
				.put("storeIndentTListForAdd", storeIndentTListForAdd);
		//System.out.println("indentId in Controller " + indentId);
		boolean flag = nonExpandableHandlerService
				.updateNextIndent(masterAndDetailMap);

		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		if (session.getAttribute("itemList") != null) {
			itemList = (List<MasStoreItem>) session.getAttribute("itemList");
			System.out
					.println("itemList                                           "
							+ itemList.size());
		}

		infoMap.put("pageNo", pageNo);
		infoMap.put("maxIndentNo", indentNo);
		infoMap.put("indentId", indentId);

		pageNo++;
		if (flag) {
			if (indentId != 0) {
				map = (Map) nonExpandableHandlerService.getIndentModifyMap(
						indentId, pageNo);

			}
			if (map.get("gridIndentTList") != null)
				gridIndentTList = (List<StoreIndentT>) map
						.get("gridIndentTList");

			if (gridIndentTList.size() == 0) {
				noDetailRecords = "yes";
			}
			if ((gridIndentTList.size() != 0) || (buttonName.equals("next"))) {
				jsp = INDENT_MODIFY;
			}
			if ((buttonName.equals("submit"))) {
				jsp = STORES_MESSAGE_JSP;
				messageTOBeVisibleToTheUser = "MMf Indent  Records Updated Successfully";
				url = "/hms/hms/stores?method=showIndentJsp";
			}

		} else {
			jsp = STORES_MESSAGE_JSP;
			messageTOBeVisibleToTheUser = "MMf Indent  Records Not Updated Successfully";
			url = "/hms/hms/stores?method=showIndentJsp";
		}
		itemList = nonExpandableHandlerService.getItemList();
		map.put("itemList", itemList);
		jsp += ".jsp";
		map.put("url", url);
		map.put("maxIndentNo", indentNo);
		map.put("indentId", indentId);
		map.put("pageNo", pageNo);
		map.put("contentJsp", jsp);
		map.put("noDetailRecords", noDetailRecords);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);

		return new ModelAndView("index", "map", map);
	}

	/*
	 * This method is used adding Header and Detail records to Indent To Depot.
	 * It is used for two operations(Next,Submit) based on the flag ie.
	 * buttonFlag
	 */
	public ModelAndView addNextOrSubmitIndentToDepot(
			HttpServletRequest request, HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		StoreIndentM storeIndentM = new StoreIndentM();
		@SuppressWarnings("unused")
		StoreIndentT storeIndentT = new StoreIndentT();
		String indentFrom = "";
		@SuppressWarnings("unused")
		Date indentDate = null;
		int supplyDepot = 0;
		@SuppressWarnings("unused")
		int sectionId = 12;
		String nrs = "";
		int rows = 0;
		@SuppressWarnings("unused")
		String indentType = "d";
		String encodedBy = "";
		Date encodedDate = null;
		String lastChgBy = "";
		@SuppressWarnings("unused")
		Date lastChgDate = null;
		String lastChgTime = "";
		String indentOption = "";
		String patientDetails = "";
		String justificationNiv = "";
		String pacJustification = "";
		String pacForeignAdd = "";
		String authority = "";
		String buttonName = "";
		int indentId = 0;
		int serialNo = 0;
		int itemId = 1;
		int stockIn = 0;
		int qtyInDemand = 0;
		int qtyInMmf = 0;
		int qtyReceived = 0;
		int radioVal = 0;
		int noOfRows = 0;
		BigDecimal unitRate = null;
		String brandName = "";
		int manufactureId = 1;
		String marketedBy = "";
		BigDecimal totalCost = null;
		Date lastReceiptDate = null;
		BigDecimal lastReceiptQty = null;
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String successfullyAdded = "no";
		int pageNo = 1;
		String url = "";
		int mmfForTheYear = 0;
		String indentNo = "";
		String address = "";
		try {
			if (request.getParameter("buttonName") != null) {
				buttonName = request.getParameter("buttonName");
			}
			if (request.getParameter(INDENT_ID) != null) {
				indentId = Integer.parseInt(request.getParameter(INDENT_ID));
			}

			if (request.getParameter(CHANGED_DATE) != null) {
				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(request.getParameter(CHANGED_DATE)));
				lastChgDate = java.sql.Date.valueOf(date4MySQL);
			}
			if (request.getParameter(CHANGED_BY) != null) {
				lastChgBy = request.getParameter(CHANGED_BY);
			}
			if (request.getParameter(CHANGED_TIME) != null) {
				lastChgTime = request.getParameter(CHANGED_TIME);
			}

			if (request.getParameter(NO_OF_ROWS) != null) {
				noOfRows = Integer.parseInt(request.getParameter(NO_OF_ROWS));
			}
			if (request.getParameter("pageNo") != null) {
				pageNo = Integer.parseInt(request.getParameter("pageNo"));
			}

			if (request.getParameter(INDENT_NO) != null) {
				indentNo = (request.getParameter(INDENT_NO));
			}
			if (request.getParameter(TYPE_OF_INDENT) != null) {
				indentOption = (request.getParameter(TYPE_OF_INDENT));
			}
			if (request.getParameter(INDENT_FROM) != null) {
				indentFrom = (request.getParameter(INDENT_FROM));
				//System.out.println("indentFrom       2==" + indentFrom);
			}
			if (request.getParameter(SUPPLY_DEPOT) != null) {
				supplyDepot = Integer.parseInt(request
						.getParameter(SUPPLY_DEPOT));
			}
			if (request.getParameter(INDENT_DATE) != null) {
				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(request.getParameter(INDENT_DATE)));
				indentDate = java.sql.Date.valueOf(date4MySQL);
			}
			if (request.getParameter(NRS) != null) {
				nrs = (request.getParameter(NRS));
				//System.out.println("nrs       2==" + nrs);
			}
			if (request.getParameter(SECTION_ID) != null) {
				sectionId = Integer.parseInt(""
						+ request.getParameter(SECTION_ID));
			}
			if (request.getParameter(AUTHORITY) != null) {
				authority = (request.getParameter(AUTHORITY));
			}
			if (request.getParameter(ADDRESS) != null) {
				address = (request.getParameter(ADDRESS));
			}

		} catch (Exception e) {
			//System.out.println("eee eee " + e);
			e.printStackTrace();
		}
		String headerStored = "no";

		if (pageNo == 1) {
			try {
				storeIndentM.setIndentNo(indentNo);
				storeIndentM.setIndentDate(indentDate);
				storeIndentM.setRequiredForm(indentFrom);
				MasStoreAirForceDepot masStoreSupplier = new MasStoreAirForceDepot();
				masStoreSupplier.setId(supplyDepot);
				storeIndentM.setSuppliedBy(masStoreSupplier);
				MasStoreSection masStoreSection = new MasStoreSection();
				masStoreSection.setId(sectionId);
				storeIndentM.setSection(masStoreSection);
				storeIndentM.setNrs(nrs);
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				storeIndentM.setDepartment(masDepartment);
				storeIndentM.setIndentType(indentType);
				storeIndentM.setEncodedBy(encodedBy);
				storeIndentM.setEncodedDate(indentDate);
				storeIndentM.setLastChgBy(lastChgBy);
				storeIndentM.setLastChgDate(indentDate);
				storeIndentM.setLastChgTime(lastChgTime);
				storeIndentM.setStatus("o");
				storeIndentM.setIndentOption(indentOption);

				storeIndentM.setPatientDetails(patientDetails);
				storeIndentM.setJustificationNiv(justificationNiv);
				storeIndentM.setPacJustification(pacJustification);
				storeIndentM.setPacForeignAdd(pacForeignAdd);
				storeIndentM.setAuthority(authority);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				storeIndentM.setHospital(masHospital);
				storeIndentM.setMmfForTheYear(mmfForTheYear);
				storeIndentM.setIndentNo(indentNo);
				storeIndentM.setImported("n");
				storeIndentM.setPatientDetails(address);

			} catch (Exception e) {
				//System.out.println("Header " + e);
			}
		} else {
			headerStored = "yes";
			infoMap.put("headerStored", headerStored);
		}

		int length = 0;
		List<StoreIndentT> storeIndentTlist = new ArrayList<StoreIndentT>(10);
		try {
			int srNo[] = JKTRequestUtils.getRequiredIntParameters(request,
					SR_NO);
			int departmentArray[] = JKTRequestUtils.getRequiredIntParameters(
					request, DEPARTMENT_ID_TEMP);
			int itemIdArray[] = JKTRequestUtils.getRequiredIntParameters(
					request, ITEM_ID);
			String qtyInHandStringArray[] = JKTRequestUtils
					.getRequiredStringParameters(request, QTY_IN_HAND);
			String qtyInMmfStringArray[] = JKTRequestUtils
					.getRequiredStringParameters(request, QTY_IN_MMF);
			String qtyDemandStringArray[] = JKTRequestUtils
					.getRequiredStringParameters(request, QTY_DEMAND_TEMP);

			String cost[] = JKTRequestUtils.getRequiredStringParameters(
					request, COST);
			String remarks[] = JKTRequestUtils.getRequiredStringParameters(
					request, REMARKS);
			BigDecimal[] qtyInHandArray = new BigDecimal[10];
			BigDecimal[] qtyDemandArray = new BigDecimal[10];
			BigDecimal[] qtyInMmfArray = new BigDecimal[10];
			int xxLegnt = qtyInHandStringArray.length;
			//System.out.println("xxLegnt" + xxLegnt);

			for (int i = 0; i < xxLegnt; i++) {
				BigDecimal val = new BigDecimal(qtyInMmfStringArray[i]);
				qtyInMmfArray[i] = val;
			}
			for (int i = 0; i < xxLegnt; i++) {
				BigDecimal val = new BigDecimal(qtyDemandStringArray[i]);
				qtyDemandArray[i] = val;
			}
			for (int i = 0; i < xxLegnt; i++) {
				BigDecimal val = new BigDecimal(qtyInHandStringArray[i]);
				qtyInHandArray[i] = val;
			}

			if (buttonName.equals("next")) {
				length = 8;
			} else {
				length = noOfRows;
			}
			for (int i = 0; i < length; i++) {

				if (itemIdArray[i] != 0) {
					StoreIndentT storeIndentTObj = new StoreIndentT();
					storeIndentTObj.setSerialNo(srNo[i]);

					MasStoreItem masItem = new MasStoreItem();
					masItem.setId(itemIdArray[i]);
					storeIndentTObj.setItem(masItem);
					storeIndentTObj.setStockIn(qtyInHandArray[i]);

					storeIndentTObj.setQtyInMmf(qtyInMmfArray[i]);
					storeIndentTObj.setQtyInDemand(qtyDemandArray[i]);
					storeIndentTObj.setQtyReceived(null);

					storeIndentTObj.setSection(null);
					storeIndentTObj.setStockIn(qtyInHandArray[i]);
					storeIndentTObj.setUnitRate(unitRate);
					storeIndentTObj.setBrand(null);
					MasManufacturer manufacturer = new MasManufacturer();
					manufacturer.setId(manufactureId);
					storeIndentTObj.setManufacture(manufacturer);
					storeIndentTObj.setMarketedBy(marketedBy);
					storeIndentTObj.setTotalCost(totalCost);
					storeIndentTObj.setLastReceiptDate(lastReceiptDate);
					storeIndentTObj.setLastReceiptQty(lastReceiptQty);

					if (!(cost[i].equals("0")) || (cost[i]) != null)
						storeIndentTObj.setTotalCost(new BigDecimal(cost[i]));
					if (!remarks.equals("emptyString"))
						storeIndentTObj.setRemarks(remarks[i]);
					storeIndentTlist.add(storeIndentTObj);
				}
			}

		} catch (Exception e) {
			//System.out.println("699999999999999999999       " + e);
		}
		try {
			dataMap.put("storeIndentM", storeIndentM);
			dataMap.put("storeIndentTlist", storeIndentTlist);
			dataMap.put("pageNo", pageNo);
			dataMap.put("indentId", indentId);
			dataMap.put("indentNo", indentNo);
			dataMap.put("deptId", deptId);
			map = (Map) nonExpandableHandlerService
					.addNextOrSubmitIndentToDepot(dataMap);
			if (map.get("indentId") != null)
				indentId = Integer.parseInt("" + map.get("indentId"));

			if (map.get("successfullyAdded") != null)
				successfullyAdded = "" + map.get("successfullyAdded");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String messageTOBeVisibleToTheUser = "";
		if (successfullyAdded.equals("yes")) {
			messageTOBeVisibleToTheUser = "Indent To Depot Records Added Successfully";
		} else {
			messageTOBeVisibleToTheUser = "Indent To Depot Records are Not Added";
		}

		pageNo = pageNo + 1;
		if (buttonName.equals("next")) {
			jsp = INDENT_TO_DEPOT_NE_JSP;
		} else {
			jsp = INDENT_TO_DEPOT_NE_JSP;
			url = "/hms/hms/nonExp?method=showIndentJspDepot";
		}
		map = nonExpandableHandlerService.showIndentJspDepot(dataMap);
		jsp += ".jsp";
		map.put("indentNo", indentNo);
		map.put(" indentFrom", indentFrom);
		map.put("indentDate", indentDate);
		map.put("supplyDepot", supplyDepot);
		map.put("sectionId", sectionId);
		map.put("indentOption", indentOption);
		map.put("nrs", nrs);
		map.put("authority", authority);
		map.put("address", address);
		map.put("indentOption", indentOption);
		map.put("pageNo", pageNo);
		map.put("contentJsp", jsp);
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getBrandListForSOCModify(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		int itemId = 0;
		int brandId = 0;
		int manuId = 0;
		int detailId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (request.getParameter("itemId") != null) {
				itemId = Integer.parseInt(request.getParameter("itemId"));
			}
			if (request.getParameter("brandId") != null) {
				brandId = Integer.parseInt(request.getParameter("brandId"));
			}
			if (request.getParameter("manuId") != null) {
				manuId = Integer.parseInt(request.getParameter("manuId"));
			}
			if (request.getParameter("detailId") != null) {
				detailId = Integer.parseInt(request.getParameter("detailId"));
			}
		} catch (Exception e) {
			//System.out.println("--");
			e.printStackTrace();
		}
		map = (Map) nonExpandableHandlerService.getBrandListForSOC(itemId,
				detailId);
		jsp = "modifyWindow";
		map.put("contentJsp", jsp);
		map.put("brandId", brandId);
		map.put("manuId", manuId);
		return new ModelAndView(jsp, "map", map);
	}

	/*
	 * This method is used adding Header and Detail records to Indent To SOC. It
	 * is used for two operations(Next,Submit) based on the flag ie. buttonFlag
	 */

	public ModelAndView getBrandListForSOC(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		int itemId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		if (request.getParameter("itemId") != null) {
			itemId = Integer.parseInt(request.getParameter("itemId"));
		}
		//System.out.println("itemId   " + itemId);
		map = (Map) nonExpandableHandlerService.getBrandListForSOC(itemId);
		jsp = "window";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView addNextOrSubmitIndentToSOC(HttpServletRequest request,
			HttpServletResponse response) throws ParseException {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		// --------------------------------------------------------------------------------
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("box", box);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("deptId", deptId);
		
		jsp += ".jsp";
		url = "/hms/hms/nonExp?method=showIndentJspSOC";
		map = (Map) nonExpandableHandlerService
				.addNextOrSubmitIndentToSOC(dataMap);
		String message="";
		if(request.getParameter("buttonName").equalsIgnoreCase("submit"))
		{ 
		   message="Record Save Successfully";
		//jsp = STORES_MESSAGE_JSP;
			jsp="messageForIndentDepot";
			jsp = jsp + ".jsp";
		}
		if(request.getParameter("buttonName").equalsIgnoreCase("next"))
		{System.out.println("For message checking-->indentToSocNe");
			jsp = "indentToSocNe";
			map.put("pageNo", 2);
			
			
		}
		
		if(request.getParameter("buttonName").equalsIgnoreCase("next"))
		{
			
			map.put("pageNo", 2);
			
		}
		/*if(request.getParameter("buttonName").equalsIgnoreCase("submit"))
		{
			map.put("pageNo", 1);
		}*/
		map.put("contentJsp", jsp);
		map.put("url", url);
		map.put("message",message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateIndentToSOC(HttpServletRequest request,
			HttpServletResponse response) throws ParseException {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		// --------------------------------------------------------------------------------
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("box", box);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("deptId", deptId);
		jsp = STORES_MESSAGE_JSP;
		jsp += ".jsp";
		url = "/hms/hms/nonExp?method=showIndentJspSOC";
		map = (Map) nonExpandableHandlerService.NextOrSubmit(dataMap);
		map.put("contentJsp", jsp);
		map.put("url", url);
		return new ModelAndView("index", "map", map);
	}

	public void fillItemsForIndentToDepot(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		String itemNameField = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String pvmsNo = "";
		List objectList = new ArrayList();
		try {
			if (request.getParameter("pvmsNo") != null) {
				pvmsNo = request.getParameter("pvmsNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		dataMap.put("pvmsNo", pvmsNo);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		map = nonExpandableHandlerService.fillItemsForIndentToDepot(dataMap);
		if (map.get("objectList") != null) {
			objectList = (List) map.get("objectList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
				Object[] object = (Object[]) iterator.next();

				sb.append("<item>");
				sb.append("<id>" + object[0] + "</id>");
				sb.append("<pvms>" + object[1] + "</pvms>");
				if ((object[6] == null) || (object[6].equals("")))
					sb.append("<oldPvms>" + 0 + "</oldPvms>");
				else
					sb.append("<oldPvms>" + object[6] + "</oldPvms>");
				sb.append("<au>" + object[8] + "</au>");
				//System.out.println(" object[4]  " + object[4]);
				if (object[4] == null)
					sb.append("<stock>" + 0 + "</stock>");
				else
					sb.append("<stock>" + new BigDecimal("" + object[4])
							+ "</stock>");
				if (object[5] == null)
					sb.append("<qtyInMMF>" + 0 + "</qtyInMMF>");
				else
					sb.append("<qtyInMMF>" + new BigDecimal("" + object[5])
							+ "</qtyInMMF>");

				if (object[9] == null)
					sb.append("<section>" + 0 + "</section>");
				else
					sb.append("<section>" + object[9] + "</section>");
				sb.append("</item>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
			//System.out.println("sb =============================="+ sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// return new ModelAndView(jsp, "map", map);
	}

	public void chackForItemExistence(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		//System.out.println("chackForItemExistence  ");
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		String itemNameField = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String pvmsNo = "";
		List objectList = new ArrayList();
		try {
			if (request.getParameter("pvmsNo") != null) {
				pvmsNo = request.getParameter("pvmsNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("chackForItemExistence  ");
		//System.out.println("pvmsNo  " + pvmsNo);
		dataMap.put("pvmsNo", pvmsNo);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		map = nonExpandableHandlerService.chackForItemExistence(dataMap);
		if (map.get("itemList") != null) {
			itemList = (List) map.get("itemList");
		}
		//System.out.println("itemList ======================== "+ itemList.size());
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<item>");
			if (itemList.size() != 0) {
				for (MasStoreItem masStoreItem : itemList) {
					sb.append("<id>" + masStoreItem.getId() + "</id>");
				}
			} else {
				sb.append("<id>" + 0 + "</id>");
			}
			sb.append("</item>");

		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
			//System.out.println("sb =============================="+ sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getItemListForIndentToDepot(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		String itemNameField = "";
		String autoHint = "";
		int sectionId = 0;
		int indentId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			if (request.getParameter("section") != null) {
				sectionId = Integer.parseInt(""
						+ (request.getParameter("section")));
			}
			if (request.getParameter("indentId") != null) {
				indentId = Integer.parseInt(""
						+ (request.getParameter("indentId")));
			}
			List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
			dataMap.put("autoHint", autoHint);
			dataMap.put("deptId", deptId);
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("sectionId", sectionId);
			dataMap.put("indentId", indentId);

			map = nonExpandableHandlerService
					.getItemListForIndentToDepot(dataMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "result";
		return new ModelAndView(jsp, "map", map);
	}

	// ----------------- End of Indent-------------------------

	// -------------------------------Start of Issue To Dispensary
	// (CIV)-------------------------

	public ModelAndView adjustLoanOut(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map map = new HashMap();
		Map dataMap = new HashMap();
		String messageTOBeVisibleToTheUser = "";
		int issueMId = 0;
		int toStoreId = 0;
		String successfullyAdded = "n";
		if (request.getParameter(ISSUE_ID) != null) {
			issueMId = Integer.parseInt(request.getParameter(ISSUE_ID));
		}
		if (request.getParameter(DEPARTMENT_ID_TEMP) != null) {
			toStoreId = Integer.parseInt(request
					.getParameter(DEPARTMENT_ID_TEMP));
		}
		jsp = RequestConstants.STORES_MESSAGE_JSP;
		dataMap.put("issueMId", issueMId);
		dataMap.put("toStoreId", toStoreId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		map = nonExpandableHandlerService.adjustLoanOut(dataMap);
		if (map.get("successfullyAdded") != null) {
			successfullyAdded = ("" + map.get("successfullyAdded"));
		}
		if (successfullyAdded.equals("y")) {
			messageTOBeVisibleToTheUser = "Records Adjusted Successfully";
		} else {
			messageTOBeVisibleToTheUser = "Records Not Adjusted ";
		}
		String url = "/hms/hms/stores?method=showIssueDispensaryJsp";
		map.put("contentJsp", jsp);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("url", url);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getDemandList(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		// Box box = HMSUtil.getBox(request);
		Map map = new HashMap();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int dispenceryId = 0;
		if ((request.getParameter(RequestConstants.DEPARTMENT_ID_TEMP) != null)
				&& (request.getParameter(RequestConstants.DEPARTMENT_ID_TEMP) != "")) {
			dispenceryId = Integer.parseInt(request
					.getParameter(RequestConstants.DEPARTMENT_ID_TEMP));
		}
		jsp = RequestConstants.DEMAND_LIST_AJAX_JSP;
		dataMap.put("dispenceryId", dispenceryId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		map = nonExpandableHandlerService.getDemandList(dataMap);
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView searchIssueCiv(HttpServletRequest request,
			HttpServletResponse response) {
		// //--------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Box box = HMSUtil.getBox(request);
		Map map = new HashMap();
		Map dataMap = new HashMap();
		int issueId = 0;
		if (request.getParameter(RequestConstants.ISSUE_UNIT_ID) != null) {
			issueId = Integer.parseInt(request
					.getParameter(RequestConstants.ISSUE_UNIT_ID));
		}

		jsp = RequestConstants.MODIFY_ISSUE_CIV;
		dataMap.put("issueId", issueId);
		box.put("deptId", deptId);
		map = nonExpandableHandlerService.searchIssueCiv(box);
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteIssueCivItems(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Box box = HMSUtil.getBox(request);
		Map map = new HashMap();
		Map dataMap = new HashMap();
		box.put("deptId", deptId);
		int issueId = 0;
		jsp = RequestConstants.SHOW_DELETE_POPUP_FOR_ISSUE;
		map = nonExpandableHandlerService.deleteIssueCivItems(box);
		// jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showDeleteIsuueCiv(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Box box = HMSUtil.getBox(request);
		Map map = new HashMap();
		Map dataMap = new HashMap();
		int issueId = 0;
		box.put("deptId", deptId);
		jsp = RequestConstants.SHOW_DELETE_POPUP_FOR_ISSUE;
		map = nonExpandableHandlerService.showDeleteIsuueCiv(box);
		// jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView openDeletePopupForIssueciv(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map map = new HashMap();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		map = nonExpandableHandlerService.openDeletePopupForIssueciv(dataMap);
		//System.out.println("map     " + map.size());
		jsp = RequestConstants.SHOW_DELETE_POPUP_FOR_ISSUE;

		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showIssueDispensaryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map map = new HashMap();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		map = nonExpandableHandlerService.showIssueDispensaryJsp(dataMap);
		//System.out.println("map     " + map.size());
		jsp = RequestConstants.DEPARTMENT_ISSUE_NE_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addNextOrSubmitIssue(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Box box = HMSUtil.getBox(request);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("box", box);
		dataMap.put("hospitalId", hospitalId);
		String messageType = "";
		String messageTOBeVisibleToTheUser = "";
		String buttonName = "";
		int pageNo = 1;
		int issueId = 0;

		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (request.getParameter("issueId") != null) {
			issueId = Integer.parseInt(request.getParameter("issueId"));
		}
		dataMap.put("issueId", issueId);
		dataMap.put("pageNo", pageNo);
		try {
			map = (Map) nonExpandableHandlerService
					.addNextOrSubmitIssue(dataMap);
			if (map.get("messageType") != null)
				messageType = "" + map.get("messageType");
			if (map.get("issueId") != null)
				issueId = Integer.parseInt(("" + map.get("issueId")));
			if (map.get("messageTOBeVisibleToTheUser") != null)
				messageTOBeVisibleToTheUser = ""
						+ map.get("messageTOBeVisibleToTheUser");
			if (request.getParameter("buttonName") != null) {
				buttonName = request.getParameter("buttonName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (messageType.equals("failure") || buttonName.equals("submit")) {
			//System.out.println("This is in If===================");
			jsp = STORES_MESSAGE_JSP;
			url = "/hms/hms/nonExp?method=showIssueDispensaryJsp";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
			map.put("messageType", messageType);
			map.put("url", url);

			return new ModelAndView("index", "map", map);

		} else {
			//System.out.println("This is in Else ===================");
			jsp = DEPARTMENT_ISSUE_NE_JSP;
		}
		pageNo = pageNo + 1;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("pageNo", pageNo);
		box.put("issueId", issueId);
		map.put("box", box);
		return new ModelAndView("index", "map", map);
	}

	
	
	
	public ModelAndView updateNextOrSubmitIssue(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Box box = HMSUtil.getBox(request);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("box", box);
		dataMap.put("hospitalId", hospitalId);
		String messageType = "";
		String messageTOBeVisibleToTheUser = "";
		String buttonName = "";
		int pageNo = 1;
		int issueId = 0;

		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (request.getParameter("issueId") != null) {
			issueId = Integer.parseInt(request.getParameter("issueId"));
		}
		dataMap.put("issueId", issueId);
		dataMap.put("pageNo", pageNo);
		try {
			map = (Map) nonExpandableHandlerService
					.updateNextOrSubmitIssue(dataMap);
			if (map.get("messageType") != null)
				messageType = "" + map.get("messageType");
			if (map.get("issueId") != null)
				issueId = Integer.parseInt(("" + map.get("issueId")));
			if (map.get("messageTOBeVisibleToTheUser") != null)
				messageTOBeVisibleToTheUser = ""
						+ map.get("messageTOBeVisibleToTheUser");
			if (request.getParameter("buttonName") != null) {
				buttonName = request.getParameter("buttonName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (messageType.equals("failure") || buttonName.equals("submit")) {
			//System.out.println("This is in If===================");
			jsp = STORES_MESSAGE_JSP;
			url = "/hms/hms/nonExp?method=showIssueDispensaryJsp";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
			map.put("messageType", messageType);
			map.put("url", url);

			return new ModelAndView("index", "map", map);

		} else {
			//System.out.println("This is in Else ===================");
			jsp = DEPARTMENT_ISSUE_NE_JSP;
		}
		pageNo = pageNo + 1;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("pageNo", pageNo);
		box.put("issueId", issueId);
		map.put("box", box);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView openItemBrandWindowJsp(HttpServletRequest request,
			HttpServletResponse response) throws ParseException {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		int itemId = 0;
		String qtyRequested = "";
		int rowVal = 0;
		int issuedItemId = 0;
		int issueId = 0;
		int detailId = 0;
		String issueNo = "";
		session = request.getSession();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter(RequestConstants.ITEM_ID) != null) {
			itemId = Integer.parseInt(request
					.getParameter(RequestConstants.ITEM_ID));
		}
		if (request.getParameter(RequestConstants.QTY_IN_REQUEST) != null) {
			qtyRequested = (request
					.getParameter(RequestConstants.QTY_IN_REQUEST));
		}
		if (request.getParameter("issueNo") != null) {
			issueNo = (request.getParameter("issueNo"));
		}

		if (request.getParameter("rowVal") != null) {
			rowVal = Integer.parseInt(request.getParameter("rowVal"));
			//System.out.println("Row Val " + rowVal);
		}
		if (request.getParameter("issuedItemId") != null) {
			issuedItemId = Integer.parseInt(request
					.getParameter("issuedItemId"));
			//System.out.println("issuedItemId " + issuedItemId);
		}
		if (request.getParameter("issueId") != null) {
			issueId = Integer.parseInt(request.getParameter("issueId"));
			//System.out.println("issueId " + issueId);
		}
		if (request.getParameter("detailId") != null) {
			detailId = Integer.parseInt(request.getParameter("detailId"));
			//System.out.println("detailId " + detailId);
		}
		dataMap.put("deptId", deptId);
		dataMap.put("itemId", issuedItemId);
		dataMap.put("issueNo", issueNo);
		map = nonExpandableHandlerService.getBrandMap(dataMap);
		map.put("qtyRequested", qtyRequested);
		map.put("itemId", itemId);
		map.put("issuedItemId", issuedItemId);
		map.put("rowVal", rowVal);
		map.put("issueId", issueId);
		map.put("detailId", detailId);
		map.put("issueNo", issueNo);
		jsp = RequestConstants.ITEM_BRAND_WINDOW_JSP;
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView searchInternalIndentDetails(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		int internalIndentId = 0;
		Box box = HMSUtil.getBox(request);
		String issueNo = "";

		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> tempMap = new HashMap<String, Object>();
		Map<String, Object> pageMap = new HashMap<String, Object>();
		// Header Information
		int approvedBy = 0;
		int requestedBy = 0;
		int issuedBy = 0;
		int issueId = 0;
		String refNo = "";
		int despenceryName = 0;
		String date = "";
		String time = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		String messageTOBeVisibleToTheUser = "";
		String messageType = "failure";
		try {
			if (request.getParameter(RequestConstants.REQUEST_NO) != null) {
				internalIndentId = Integer.parseInt(request
						.getParameter(RequestConstants.REQUEST_NO));
			}
			if (request.getParameter(RequestConstants.ISSUE_NO) != null) {
				issueNo = (request.getParameter(RequestConstants.ISSUE_NO));
			}

			if (request.getParameter(RequestConstants.APPROVED_BY) != null) {
				approvedBy = Integer.parseInt(""
						+ (request.getParameter(RequestConstants.APPROVED_BY)));
			}
			if (request.getParameter(RequestConstants.REQUEST_BY) != null) {
				requestedBy = Integer.parseInt(""
						+ request.getParameter(RequestConstants.REQUEST_BY));
			}
			if (request.getParameter(RequestConstants.ISSUED_BY) != null) {
				issuedBy = Integer.parseInt(""
						+ request.getParameter(RequestConstants.ISSUED_BY));
			}
			if (request.getParameter(RequestConstants.REFERENCE) != null) {
				refNo = (request.getParameter(RequestConstants.REFERENCE));
			}
			if (request.getParameter(RequestConstants.DEPARTMENT_ID_TEMP) != null) {
				despenceryName = Integer
						.parseInt(""
								+ request
										.getParameter(RequestConstants.DEPARTMENT_ID_TEMP));
			}
			if (request.getParameter(RequestConstants.ISSUE_NO) != null) {
				issueNo = (request.getParameter(RequestConstants.ISSUE_NO));
			}

			dataMap.put("internalIndentId", internalIndentId);
			dataMap.put("issueNo", issueNo);
			dataMap.put("approvedBy", approvedBy);
			dataMap.put("requestedBy", requestedBy);
			dataMap.put("issuedBy", issuedBy);
			dataMap.put("refNo", refNo);
			dataMap.put("despenceryName", despenceryName);
			dataMap.put("date", date);
			dataMap.put("time", time);
			dataMap.put("deptId", deptId);
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			tempMap = nonExpandableHandlerService
					.searchInternalIndentDetails(dataMap);
			if (tempMap.get("issueId") != null) {
				issueId = Integer.parseInt("" + tempMap.get("issueId"));
			}
			int pageNo = 1;
			pageMap.put("issueId", issueId);
			pageMap.put("pageNo", pageNo);
			pageMap.put("deptId", deptId);
			map = nonExpandableHandlerService.getIssueDetailPageByPage(pageMap);
			if (tempMap.get("messageTOBeVisibleToTheUser") != null)
				map.put("messageTOBeVisibleToTheUser", ""
						+ tempMap.get("messageTOBeVisibleToTheUser"));
			if (tempMap.get("messageType") != null)
				map.put("messageType", "" + tempMap.get("messageType"));
			//System.out.println("tempMap.get(messageTOBeVisibleToTheUser)"	+ tempMap.get(messageTOBeVisibleToTheUser));
		} catch (Exception e) {
			//System.out.println("searchInternalIndentDetails  in con" + e);
			e.printStackTrace();
		}
		jsp = RequestConstants.ISSUED_TO_DISPENSARY_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("internalIndentId", internalIndentId);
		map.put("max", issueNo);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addBrandDetails(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		List<StoreIssueT> storeIssueTList = new ArrayList<StoreIssueT>();
		BigDecimal[] qtyIssuedArray = new BigDecimal[100];
		BigDecimal[] qtyRequestedArray = new BigDecimal[100];
		Date[] expDateArray = new Date[100];
		Date expDate = new Date();
		StoreIssueM storeIssueM = new StoreIssueM();

		String requestType = "";
		String issueType = "";
		String docType = "";
		String issueNo = "";
		Date issueDate = new Date();
		int toStore = 0;
		int toDepot = 0;
		String requestNo = "";
		Date requestDate = new Date();
		int requestedBy = 0;
		int issuedBy = 0;
		int approvedBy = 0;
		StoreIssueM issueM = new StoreIssueM();
		int issueId = 0;
		int itemId = 0;
		int issuedItemId = 0;
		String docNo = "";
		Map dataMap = new HashMap();
		boolean flag = false;
		String messageTOBeVisibleToTheUser = "";
		String qtyInRequest = "";
		int detailId = 0;
		if (request.getParameter(RequestConstants.ISSUE_ID) != null) {
			issueId = Integer.parseInt((request
					.getParameter(RequestConstants.ISSUE_ID)));
		}
		if (request.getParameter(RequestConstants.ISSUE_NO) != null) {
			issueNo = ((request.getParameter(RequestConstants.ISSUE_NO)));
		}
		if (request.getParameter(RequestConstants.ITEM_ID) != null) {
			itemId = Integer.parseInt((request
					.getParameter(RequestConstants.ITEM_ID)));
		}
		if (request.getParameter(RequestConstants.ISSUE_ID) != null) {
			issuedItemId = Integer.parseInt((request
					.getParameter(RequestConstants.ISSUE_ID)));
			//System.out.println("issuedItemId   in controller  " + issuedItemId);
		}
		if (request.getParameter(RequestConstants.QTY_IN_REQUEST) != null) {
			qtyInRequest = ((request
					.getParameter(RequestConstants.QTY_IN_REQUEST)));
		}
		if (request.getParameter(RequestConstants.DETAIL_ID) != null) {
			detailId = Integer.parseInt((request
					.getParameter(RequestConstants.DETAIL_ID)));
			//System.out.println("detailId  in Controller " + detailId);
		}
		// issueId = (int) nonExpandableHandlerService.getIssueId(issueNo);
		if (issueId == 0) {
			try {
				if (request.getParameter(RequestConstants.REQUEST_TYPE) != null) {
					requestType = (request
							.getParameter(RequestConstants.REQUEST_TYPE));
				}
				if (request.getParameter(RequestConstants.ISSUE_TYPE) != null) {
					issueType = (request
							.getParameter(RequestConstants.ISSUE_TYPE));
				}

				if (request.getParameter(RequestConstants.DOC_TYPE) != null) {
					docType = (request.getParameter(RequestConstants.DOC_TYPE));
				}
				if (request.getParameter(RequestConstants.DOC_NO) != null) {
					docNo = (request.getParameter(RequestConstants.DOC_NO));
				}
				if (request.getParameter(RequestConstants.ISSUE_NO) != null) {
					issueNo = (request.getParameter(RequestConstants.ISSUE_NO));
				}
				if (request.getParameter(RequestConstants.ISSUE_DATE) != null) {

					SimpleDateFormat formatterIn = new SimpleDateFormat(
							"dd/MM/yyyy");
					SimpleDateFormat formatterOut = new SimpleDateFormat(
							"yyyy-MM-dd");
					String date4MySQL = formatterOut
							.format(formatterIn.parse(request
									.getParameter(RequestConstants.ISSUE_DATE)));
					issueDate = java.sql.Date.valueOf(date4MySQL);
				}
				if (request.getParameter(RequestConstants.DEPARTMENT_ID_TEMP) != null) {
					toStore = Integer.parseInt(request
							.getParameter(RequestConstants.DEPARTMENT_ID_TEMP));
				}
				if (request.getParameter(RequestConstants.DEPARTMENT_INDENT_ID) != null) {
					toDepot = Integer
							.parseInt(request
									.getParameter(RequestConstants.DEPARTMENT_INDENT_ID));
				}
				if (request.getParameter(RequestConstants.REQUEST_NO) != null) {
					requestNo = (request
							.getParameter(RequestConstants.REQUEST_NO));
				}
				if (request.getParameter(RequestConstants.REQUEST_DATE) != null) {

					SimpleDateFormat formatterIn = new SimpleDateFormat(
							"dd/MM/yyyy");
					SimpleDateFormat formatterOut = new SimpleDateFormat(
							"yyyy-MM-dd");
					String date4MySQL = formatterOut
							.format(formatterIn
									.parse(request
											.getParameter(RequestConstants.REQUEST_DATE)));
					requestDate = java.sql.Date.valueOf(date4MySQL);
				}
				if (request.getParameter(RequestConstants.REQUEST_BY) != null) {
					requestedBy = Integer.parseInt(request
							.getParameter(RequestConstants.REQUEST_BY));
				}
				if (request.getParameter(RequestConstants.ISSUED_BY) != null) {
					issuedBy = Integer.parseInt(request
							.getParameter(RequestConstants.ISSUED_BY));
				}
				if (request.getParameter(RequestConstants.APPROVED_BY) != null) {
					approvedBy = Integer.parseInt(request
							.getParameter(RequestConstants.APPROVED_BY));
				}

				issueM.setIssueType(issueType);
				issueM.setIssueNo(issueNo);
				issueM.setIssueDate(issueDate);

				MasDepartment department = new MasDepartment();
				department.setId(deptId);
				issueM.setDepartment(department);

				StoreInternalIndentM storeInternalIndentM = new StoreInternalIndentM();
				storeInternalIndentM.setId(toDepot);
				issueM.setToDepot(storeInternalIndentM);

				MasDepartment department2 = new MasDepartment();
				department2.setId(toStore);
				issueM.setToStore(department2);

				MasStoreAirForceDepot airForceDepot = new MasStoreAirForceDepot();
				airForceDepot.setId(toDepot);
				issueM.setToUnit(airForceDepot);

				issueM.setRequestDate(requestDate);

				MasEmployee employee = new MasEmployee();
				employee.setId(requestedBy);
				issueM.setRequestBy(employee);

				MasEmployee employee2 = new MasEmployee();
				employee2.setId(approvedBy);
				issueM.setApprovedBy(employee2);

				MasEmployee employee3 = new MasEmployee();
				employee3.setId(issuedBy);
				issueM.setIssuedBy(employee3);
				issueM.setStatus("o");
				issueM.setDocNo(docNo);
			} catch (Exception e) {
				//System.out.println("11111111 " + e);
			}
		}// end of if block
		else {
			// infoMap.put("issueId", issueId);
		}

		try {

			int itemIssuedIdArray[] = JKTRequestUtils.getRequiredIntParameters(
					request, RequestConstants.BRAND_ID);
			String remarksArray[] = JKTRequestUtils
					.getRequiredStringParameters(request,
							RequestConstants.REMARKS);

			String batchNoArray[] = JKTRequestUtils
					.getRequiredStringParameters(request,
							RequestConstants.BATCH_NO);
			String qtyIssuedTempArray[] = JKTRequestUtils
					.getRequiredStringParameters(request,
							RequestConstants.QTY_ISSUED);
			String expDateTempArray[] = JKTRequestUtils
					.getRequiredStringParameters(request,
							RequestConstants.EXPIRY_DATE);

			int qtyIssuedTempArrayLength = qtyIssuedTempArray.length;
			for (int i = 0; i < qtyIssuedTempArrayLength; i++) {
				BigDecimal val = new BigDecimal(qtyIssuedTempArray[i]);
				qtyIssuedArray[i] = val;
			}
			int expDateTempArrayLength = expDateTempArray.length;
			for (int i = 0; i < expDateTempArrayLength; i++) {
				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(expDateTempArray[i]));
				expDate = java.sql.Date.valueOf(date4MySQL);
				expDateArray[i] = expDate;
			}

			for (int i = 0; i < itemIssuedIdArray.length; i++) {

				if (!qtyIssuedArray[i].equals(new BigDecimal("0"))) {
					StoreIssueT storeIssueT = new StoreIssueT();

					MasStoreItem masStoreItem = new MasStoreItem();
					masStoreItem.setId(itemId);
					storeIssueT.setItem(masStoreItem);

					BigDecimal bigDecimal = new BigDecimal(qtyInRequest);
					storeIssueT.setQtyRequest(bigDecimal);

					MasStoreItem masStoreItem2 = new MasStoreItem();
					masStoreItem2.setId(issuedItemId);
					storeIssueT.setItemIssued(masStoreItem2);

					storeIssueT.setBatchNo(batchNoArray[i]);
					storeIssueT.setQtyIssued(qtyIssuedArray[i]);
					if (remarksArray[i].equals("emptyString"))
						storeIssueT.setRemarks("");
					else
						storeIssueT.setRemarks(remarksArray[i]);
					storeIssueT.setExpiryDate(expDateArray[i]);

					StoreIssueM issueM2 = new StoreIssueM();
					issueM2.setId(issueId);
					storeIssueT.setIssueM(issueM2);

					MasStoreBrand storeBrand = new MasStoreBrand();
					storeBrand.setId(itemIssuedIdArray[i]);
					storeIssueT.setBrand(storeBrand);
					storeIssueT.setSrNo(1);

					storeIssueTList.add(storeIssueT);

				}

			}
			dataMap.put("storeIssueTList", storeIssueTList);
			dataMap.put("issueId", issueId);
			dataMap.put("itemId", itemId);
			dataMap.put("detailId", detailId);
			dataMap.put("itemIssuedIdArray", itemIssuedIdArray);
			dataMap.put("qtyIssuedTempArray", qtyIssuedTempArray);
			dataMap.put("deptId", deptId);
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("issueNo", issueNo);
			flag = nonExpandableHandlerService.addBrandDetails(dataMap);
			//System.out.println("successfullyAdded     " + flag);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			messageTOBeVisibleToTheUser = "Records Added Succesfully";
		} else {
			messageTOBeVisibleToTheUser = "Records Not Added Succesfully";
		}
		//System.out.println("messageTOBeVisibleToTheUser  "+ messageTOBeVisibleToTheUser);
		jsp = RequestConstants.EXIT_WINDOW;
		// jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView addNextOrSubmitIssueToCiv(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		int internalIndentId = 0;
		String max = "";
		int pageNo = 0;
		int listSize = 0;
		Box box = HMSUtil.getBox(request);
		if (request.getParameter(RequestConstants.REQUEST_NO) != null) {
			internalIndentId = Integer.parseInt(request
					.getParameter(RequestConstants.REQUEST_NO));
		}
		if (request.getParameter(RequestConstants.PAGE_NO) != null) {
			pageNo = Integer.parseInt(request
					.getParameter(RequestConstants.PAGE_NO));
		}
		if (request.getParameter(RequestConstants.ISSUE_NO) != null) {
			max = (request.getParameter(RequestConstants.ISSUE_NO));
		}
		try {
			// map =
			// nonExpandableHandlerService.searchInternalIndentDetails(internalIndentId);
		} catch (Exception e) {
			//System.out.println("searchInternalIndentDetails  " + e);
		}
		jsp = RequestConstants.ISSUED_TO_DISPENSARY_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("internalIndentId", internalIndentId);
		map.put("max", max);
		map.put("pageNo", pageNo + 1);
		map.put("listSize", listSize);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateNextOrSubmitIssueToCiv(
			HttpServletRequest request, HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map map = new HashMap();
		Map pageMap = new HashMap();
		Box box = HMSUtil.getBox(request);
		int issueId = 0;
		int pageNo = 0;
		String buttonName = "next";
		String messageTOBeVisibleToTheUser = "";
		if (request.getParameter(RequestConstants.ISSUE_ID) != null) {
			issueId = Integer.parseInt(request
					.getParameter(RequestConstants.ISSUE_ID));
		}
		if (request.getParameter(RequestConstants.PAGE_NO) != null) {
			pageNo = Integer.parseInt(request
					.getParameter(RequestConstants.PAGE_NO));
		}
		if (request.getParameter("buttonName") != null) {
			buttonName = (request.getParameter("buttonName"));

		}
		if (buttonName.equals("next")) {
			pageMap.put("issueId", issueId);
			pageMap.put("pageNo", pageNo + 1);
			pageMap.put("deptId", deptId);
			pageMap.put("userName", userName);
			pageMap.put("hospitalId", hospitalId);
			map = nonExpandableHandlerService.getIssueDetailPageByPage(pageMap);
			//System.out.println("map     " + map.size());
			jsp = RequestConstants.MODIFY_ISSUE_CIV;
			if (map.get("issueTList") != null) {
				if (((List) map.get("issueTList")).size() < 8) {
					List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
					itemList = (List<MasStoreItem>) nonExpandableHandlerService
							.getItemList();
					map.put("itemList", itemList);
				}
			}
		} else {
			jsp = STORES_MESSAGE_JSP;
			messageTOBeVisibleToTheUser = "Issued Successfully";
			map.put("url", "stores?method=showIssueDispensaryJsp");
			map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		}
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("pageNo", pageNo + 1);
		map.put("box", box);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAdjustLoanOut(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		jsp = ADJUST_LOAN_OUT;
		jsp += ".jsp";
		int toStoreId = 0;
		int issueMId = 0;
		try {
			if (request.getParameter(DEPARTMENT_ID_TEMP) != null) {
				toStoreId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID_TEMP));
			}
			dataMap.put("toStoreId", toStoreId);
			dataMap.put("deptId", deptId);
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			map = nonExpandableHandlerService.getAdjustLoanOutMap(dataMap);

		} catch (Exception e) {
			//System.out.println("showAdjustLoanOut " + e);
			e.printStackTrace();
		}
		map.put("contentJsp", jsp);
		map.put("toStoreId", toStoreId);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPrintIssueToDispensary(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = nonExpandableHandlerService.showPrintIssueToDispensary();
		jsp = PRINT_ISSUE_TO_DISPENSARY;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printIssueToDispensary(HttpServletRequest request,
			HttpServletResponse response) {
		//System.out.println("printIndentSoc");
		int issue_m_id = 0;
		Map parameters = new HashMap();
		try {
			if (request.getParameter(ISSUE_NO) != null
					&& !(request.getParameter(ISSUE_NO).equals(""))) {
				issue_m_id = Integer.parseInt(request.getParameter(ISSUE_NO));
				//System.out.println("issue_m_id  " + issue_m_id);
			}

			parameters = nonExpandableHandlerService
					.getIssuePrintMap(issue_m_id);
			parameters.put("issue_m_id", issue_m_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		byte[] bytes = null;

		try {
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport(ISSUE_TO_DISPENSARY_JASSPER), parameters,
					(Connection) parameters.get("conn"));
		} catch (JRException e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment; filename="
				+ ISSUE_TO_DISPENSARY_JASSPER + ".pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getItemListForDepartmentIssueNE(
			HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("getItemListForIssueToDispensary");
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		String itemNameField = "";
		String autoHint = "";
		int issueId = 0;
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			//System.out.println(request.getParameter("issueId"));
			if ((request.getParameter("issueId") != null)) {
				issueId = Integer.parseInt(request.getParameter("issueId"));
			}

			List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
			dataMap.put("autoHint", autoHint);
			dataMap.put("deptId", deptId);
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("issueId", issueId);
			map = nonExpandableHandlerService
					.getItemListForDepartmentIssueNE(dataMap);
			jsp = "resultForLoanOutNe";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public void fillItemsForIssueToDispensary(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		BigDecimal stockIn = null;
		String serialNo = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		// --------------------------------------------------------------------------------
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List objectList = new ArrayList();
		String pvmsNo = "";
		try {
			if (request.getParameter("pvmsNo") != null) {
				pvmsNo = request.getParameter("pvmsNo");
			}

			List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
			List<StoreItemBatchStock> batchNoList = new ArrayList<StoreItemBatchStock>();
			dataMap.put("pvmsNo", pvmsNo);
			dataMap.put("deptId", deptId);
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			map = nonExpandableHandlerService
					.fillItemsForIssueToDispensary(dataMap);
			if (map.get("itemList") != null) {
				itemList = (List) map.get("itemList");
			}
			
			if (map.get("batchNoList") != null) {
				batchNoList = (List) map.get("batchNoList");
			}
			
			if (map.get("objectList") != null) {
				objectList = (List) map.get("objectList");
			}
			if (objectList.size() > 0)
				for (Iterator iterator = objectList.iterator(); iterator
						.hasNext();) {
					Object[] object = (Object[]) iterator.next();
					stockIn = new BigDecimal("" + object[0]);
					serialNo = "" + object[1];
				}
			for (MasStoreItem masStoreItem : itemList) {
				//System.out.println("Name  " + masStoreItem.getNomenclature());
			}
			StringBuffer sb = new StringBuffer();
			for (MasStoreItem masStoreItem : itemList) {
				sb.append("<item>");
				sb.append("<id>" + masStoreItem.getId() + "</id>");
				sb.append("<pvms>" + masStoreItem.getPvmsNo() + "</pvms>");
				if (masStoreItem.getItemConversion() != null) {
					sb.append("<au>"
							+ masStoreItem.getItemConversion()
									.getItemUnitName() + "</au>");
				} else {
					sb.append("<au>" + "NA" + "</au>");
				}
				sb
						.append("<name>" + masStoreItem.getNomenclature()
								+ "</name>");
				if (stockIn != null) {
					sb.append("<stockIn>" + stockIn + "</stockIn>");
				} else {
					sb.append("<stockIn>" + 0 + "</stockIn>");
				}
				sb.append("<serials>");
				for (StoreItemBatchStock stock : batchNoList) {
				sb.append("<serial>");
				sb.append("<stockId>" + stock.getId() + "</stockId>");
				sb.append("<serialNo>" + stock.getBatchNo()+ "</serialNo>");
				sb.append("</serial>");				
			}
				sb.append("</serials>");
				sb.append("</item>");
			}

			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");

			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
			//System.out.println("sb =============================="+ sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getStock(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		BigDecimal stockIn = null;
		String serialNo = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		// --------------------------------------------------------------------------------
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List objectList = new ArrayList();
		String pvmsNo = "";
		int stockId=0;
		try {
			if (request.getParameter("lotNo") != null) {
				stockId = Integer.parseInt(request.getParameter("lotNo"));
			}

			
			List<StoreItemBatchStock> stockList = new ArrayList<StoreItemBatchStock>();
			dataMap.put("stockId", stockId);
			dataMap.put("deptId", deptId);
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			map = nonExpandableHandlerService
					.getStock(dataMap);
			
			
			if (map.get("stockList") != null) {
				stockList = (List) map.get("stockList");
			}
			
				
			StringBuffer sb = new StringBuffer();
			for (StoreItemBatchStock stock : stockList) {
				sb.append("<item>");
				sb.append("<stockIn>" + stock.getClosingStock() + "</stockIn>");
				
				
				
				sb.append("</item>");
			}

			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");

			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
			//System.out.println("sb =============================="+ sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

	// -------------------------------End of Issue To Dispensary
	// (CIV)----------------------------------

	// ------------------Start of Issue To Dispensary In the form of
	// LOANOUT-----------------------
	public void fillItemsForIssueToLoanout(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String pvmsNo = "";
		try {
			if (request.getParameter("pvmsNo") != null) {
				pvmsNo = request.getParameter("pvmsNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		dataMap.put("pvmsNo", pvmsNo);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		map = nonExpandableHandlerService
				.fillItemsForIssueToDispensary(dataMap);
		if (map.get("itemList") != null) {
			itemList = (List) map.get("itemList");
		}
		for (MasStoreItem masStoreItem : itemList) {
			//System.out.println("Name  " + masStoreItem.getNomenclature());
		}
		StringBuffer sb = new StringBuffer();
		for (MasStoreItem masStoreItem : itemList) {
			sb.append("<item>");
			sb.append("<id>" + masStoreItem.getId() + "</id>");
			sb.append("<pvms>" + masStoreItem.getPvmsNo() + "</pvms>");
			sb.append("<au>"
					+ masStoreItem.getItemConversion().getItemUnitName()
					+ "</au>");
			sb.append("<name>" + masStoreItem.getNomenclature() + "</name>");
			sb.append("</item>");
		}

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
			//System.out.println("sb =============================="+ sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ModelAndView getItemListForLoanout(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		String itemNameField = "";
		String autoHint = "";
		int issueId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("requiredField") != null) {
			itemNameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(itemNameField) != null) {
			autoHint = (request.getParameter(itemNameField));
		}
		if (request.getParameter("issueId") != null) {
			issueId = Integer.parseInt((request.getParameter("issueId")));
		}

		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		dataMap.put("autoHint", autoHint);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("issueId", issueId);
		map = nonExpandableHandlerService
				.getItemListForIssueToDispensary(dataMap);
		jsp = "result";
		return new ModelAndView(jsp, "map", map);
	}

	// This method returnd a jsp which contails item list
	// based on the MmfIndent select Condition
	public ModelAndView getItemListForLoanoutByAutocomplete(
			HttpServletRequest request, HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		String itemNameField = "";
		String autoHint = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("requiredField") != null) {
			itemNameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(itemNameField) != null) {
			autoHint = (request.getParameter(itemNameField));
		}
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		dataMap.put("autoHint", autoHint);
		map = nonExpandableHandlerService
				.getItemListForLoanoutByAutocomplete(dataMap);
		jsp = "result";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView deleteIssueLoanoutItems(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Box box = HMSUtil.getBox(request);
		Map map = new HashMap();
		Map dataMap = new HashMap();

		int issueId = 0;
		jsp = RequestConstants.DELETE_POPUP_FOR_DEPARTMENT_ISSUE_NE;
		box.put("deptId", deptId);
		map = nonExpandableHandlerService.deleteIssueLoanoutItems(box);
		// jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showDeleteIsuueLoanout(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Box box = HMSUtil.getBox(request);
		Map map = new HashMap();
		Map dataMap = new HashMap();
		int issueId = 0;
		int departmentIdTemp = 0;
		if (request.getParameter(RequestConstants.DEPARTMENT_ID_TEMP) != null) {
			departmentIdTemp = Integer.parseInt(request
					.getParameter(RequestConstants.DEPARTMENT_ID_TEMP));
		}
		jsp = RequestConstants.DELETE_POPUP_FOR_DEPARTMENT_ISSUE_NE;
		box.put("deptId", deptId);
		map = nonExpandableHandlerService.showDeleteIsuueLoanout(box);
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView openDeletePopupForIssueLoanOut(
			HttpServletRequest request, HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		int departmentIdTemp = 0;
		Map dataMap = new HashMap();

		jsp = DELETE_POPUP_FOR_DEPARTMENT_ISSUE_NE;
		dataMap.put("deptId", deptId);
		map = nonExpandableHandlerService
				.openDeletePopupForIssueLoanOut(dataMap);
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView addNextOrSubmitIssueForLoanOut(
			HttpServletRequest request, HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map map = new HashMap();
		Map pageMap = new HashMap();
		Box box = HMSUtil.getBox(request);
		int issueId = 0;
		int pageNo = 0;
		String buttonName = "next";
		String messageTOBeVisibleToTheUser = "";
		buttonName = "" + box.get("buttonName");
		if (buttonName.equals("next")) {
			pageNo = Integer.parseInt("" + box.getInt("pageNo"));
			// map = nonExpandableHandlerService.showIssueDispensaryJsp();
			jsp = RequestConstants.ISSUED_TO_DISPENSARY_MANUAL_JSP;

		} else {
			jsp = STORES_MESSAGE_JSP;
			messageTOBeVisibleToTheUser = "Issued Successfully";
			map.put("url", "stores?method=showIssueDispensaryManualJsp");
			map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		}
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("pageNo", pageNo + 1);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addBrandDetailsForLoanOut(HttpServletRequest request,
			HttpServletResponse response) throws java.text.ParseException {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map map = new HashMap();
		Box box = HMSUtil.getBox(request);
		String messageTOBeVisibleToTheUser = "";
		box.put("hospitalId", hospitalId);
		box.put("deptId", deptId);
		map = nonExpandableHandlerService.addBrandDetailsForLoanOut(box);
		String successfullyAdded = "n";

		if (map.get("successfullyAdded") != null) {
			successfullyAdded = "" + map.get("successfullyAdded");
		}
		if (successfullyAdded.equals("y")) {
			messageTOBeVisibleToTheUser = "Records Added Succesfully";
		} else {
			messageTOBeVisibleToTheUser = "Records Not Added";
		}
		//System.out.println("messageTOBeVisibleToTheUser  "+ messageTOBeVisibleToTheUser);
		jsp = RequestConstants.EXIT_WINDOW;
		map.put("contentJsp", jsp);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView searchDepartmentIssueNE(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		int issueId = 0;
		if (request.getParameter(RequestConstants.ISSUE_ID) != null) {
			issueId = Integer.parseInt(request
					.getParameter(RequestConstants.ISSUE_ID));
		}
		Map map = new HashMap();
		Box box = HMSUtil.getBox(request);
		box.put("issueId", issueId);
		map = nonExpandableHandlerService.searchIssueLoanout(box);
		//jsp = RequestConstants.DEPARTMENT_ISSUE_NE_JSP;
		jsp=RequestConstants.UPDATE_DEPARTMENT_ISSUE_NE;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showIssueDispensaryManualJsp(
			HttpServletRequest request, HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map map = new HashMap();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		map = nonExpandableHandlerService.showIssueDispensaryManualJsp(dataMap);
		jsp = RequestConstants.ISSUED_TO_DISPENSARY_MANUAL_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView openItemBrandWindowJspForLoanOut(
			HttpServletRequest request, HttpServletResponse response)
			throws ParseException {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Box box = HMSUtil.getBox(request);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map map = new HashMap();
		int itemId = 0;
		int rowVal = 0;
		int departmentId = 1;

		if (request.getParameter(RequestConstants.ITEM_ID) != null) {
			itemId = Integer.parseInt(request
					.getParameter(RequestConstants.ITEM_ID));
			//System.out.println(" itemId          =" + itemId);
		}
		if (request.getParameter("rowVal") != null) {
			rowVal = Integer.parseInt(request.getParameter("rowVal"));
			//System.out.println("Row Val " + rowVal);
		}
		dataMap.put("itemId", itemId);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		map = nonExpandableHandlerService.getBrandMap(dataMap);
		map.put("rowVal", rowVal);
		jsp = RequestConstants.ITEM_BRAND_WINDOW_JSP_FOR_LOAN_OUT;
		return new ModelAndView(jsp, "map", map);
	}

	// ------------------End of Issue To Dispensary In the form of
	// LOANOUT-------------------------

	// ------------------Start of Issues To Other Units on Surplus
	// (CIV)-----------------------
	public ModelAndView deleteIssueToOtherUnits(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Box box = HMSUtil.getBox(request);
		Map map = new HashMap();
		Map dataMap = new HashMap();

		int issueId = 0;
		jsp = RequestConstants.SHOW_DELETE_POPUP_FOR_ISSUE_TO_OTHER_UNITS;
		map = nonExpandableHandlerService.deleteIssueToOtherUnitsItems(box);
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showDeleteIsuueToOtherUnits(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Box box = HMSUtil.getBox(request);
		Map map = new HashMap();
		Map dataMap = new HashMap();
		int issueId = 0;
		int departmentIdTemp = 1;
		if (request.getParameter(RequestConstants.DEPARTMENT_ID_TEMP) != null) {
			departmentIdTemp = Integer.parseInt(request
					.getParameter(RequestConstants.DEPARTMENT_ID_TEMP));
		}
		jsp = RequestConstants.SHOW_DELETE_POPUP_FOR_ISSUE_TO_OTHER_UNITS;
		map = nonExpandableHandlerService.showDeleteIsuueToOtherUnits(box);
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView openDeletePopupForIssueToOtherUnits(
			HttpServletRequest request, HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		int departmentIdTemp = 1;
		Map dataMap = new HashMap();
		if (request.getParameter(RequestConstants.DEPARTMENT_ID_TEMP) != null) {
			departmentIdTemp = Integer.parseInt(request
					.getParameter(RequestConstants.DEPARTMENT_ID_TEMP));
		}
		jsp = SHOW_DELETE_POPUP_FOR_ISSUE_TO_OTHER_UNITS;
		dataMap.put("departmentIdTemp", departmentIdTemp);
		map = nonExpandableHandlerService
				.openDeletePopupForIssueToOtherUnits(dataMap);
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView addNextOrSubmitIssueToOtherUnits(
			HttpServletRequest request, HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("userName", userName);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		Map map = new HashMap();
		Map pageMap = new HashMap();
		Box box = HMSUtil.getBox(request);
		int issueId = 0;
		int pageNo = 0;
		String buttonName = "next";
		String messageTOBeVisibleToTheUser = "";
		buttonName = "" + box.get("buttonName");
		if (buttonName.equals("next")) {
			pageNo = Integer.parseInt("" + box.getInt("pageNo"));
			map = nonExpandableHandlerService.showIssueToOtherUnitsJsp(dataMap);
			jsp = RequestConstants.ISSUED_TO_OTHER_UNITS_JSP;

		} else {
			jsp = STORES_MESSAGE_JSP;
			messageTOBeVisibleToTheUser = "Issued Successfully";
			map.put("url", "stores?method=showIssueToOtherUnitsJsp");
			map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		}
		//System.out.println("pageNo  " + pageNo);
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("pageNo", pageNo + 1);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addBrandDetailsToOtherUnits(HttpServletRequest request,
			HttpServletResponse response) throws java.text.ParseException {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map map = new HashMap();
		Box box = HMSUtil.getBox(request);
		String messageTOBeVisibleToTheUser = "";
		session = request.getSession();
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		box.put("hospitalId", hospitalId);
		box.put("deptId", deptId);
		map = nonExpandableHandlerService.addBrandDetailsToOtherUnits(box);
		String successfullyAdded = "n";

		if (map.get("successfullyAdded") != null) {
			successfullyAdded = "" + map.get("successfullyAdded");
		}
		if (successfullyAdded.equals("y")) {
			messageTOBeVisibleToTheUser = "Records Added Succesfully";
		} else {
			messageTOBeVisibleToTheUser = "Records Not Added";
		}

		jsp = RequestConstants.EXIT_WINDOW;
		map.put("contentJsp", jsp);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView searchIssueToOtherUnits(HttpServletRequest request,
			HttpServletResponse response) {
		Map map = new HashMap();
		Box box = HMSUtil.getBox(request);
		map = nonExpandableHandlerService.searchIssueToOtherUnits(box);
		jsp = RequestConstants.ISSUED_TO_OTHER_UNITS_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showIssueToOtherUnitsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map map = new HashMap();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("userName", userName);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);

		map = nonExpandableHandlerService.showIssueToOtherUnitsJsp(dataMap);
		jsp = RequestConstants.ISSUED_TO_OTHER_UNITS_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView openItemBrandWindowJspToOtherUnits(
			HttpServletRequest request, HttpServletResponse response)
			throws ParseException {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map map = new HashMap();
		int itemId = 0;
		int rowVal = 0;
		session = request.getSession();
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------

		if (request.getParameter(RequestConstants.ITEM_ID) != null) {
			itemId = Integer.parseInt(request
					.getParameter(RequestConstants.ITEM_ID));
			//System.out.println(" itemId          =" + itemId);
		}
		if (request.getParameter("rowVal") != null) {
			rowVal = Integer.parseInt(request.getParameter("rowVal"));
			//System.out.println("Row Val " + rowVal);
		}
		dataMap.put("deptId", deptId);
		dataMap.put("itemId", itemId);
		map = nonExpandableHandlerService.getBrandMap(dataMap);
		map.put("rowVal", rowVal);
		jsp = RequestConstants.ITEM_BRAND_WINDOW_JSP_TO_OTHER_UNITS;
		return new ModelAndView(jsp, "map", map);
	}

	// ------------------End of Issues To Other Units on Surplus
	// (CIV)-------------------------

	// ------------------Start of Issues To Other than Airforce Units
	// -----------------------
	public void fillItemsForIssueToOTAFU(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String pvmsNo = "";
		try {
			if (request.getParameter("pvmsNo") != null) {
				pvmsNo = request.getParameter("pvmsNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out
				.println("pvmsNo============================================================="
						+ pvmsNo);
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		dataMap.put("pvmsNo", pvmsNo);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		map = nonExpandableHandlerService.fillItemsForIssueToDepot(dataMap);
		if (map.get("itemList") != null) {
			itemList = (List) map.get("itemList");
		}
		for (MasStoreItem masStoreItem : itemList) {
			//System.out.println("Name  " + masStoreItem.getNomenclature());
		}
		StringBuffer sb = new StringBuffer();
		for (MasStoreItem masStoreItem : itemList) {
			sb.append("<item>");
			sb.append("<id>" + masStoreItem.getId() + "</id>");
			sb.append("<pvms>" + masStoreItem.getPvmsNo() + "</pvms>");
			sb.append("<au>"
					+ masStoreItem.getItemConversion().getItemUnitName()
					+ "</au>");
			sb.append("<name>" + masStoreItem.getNomenclature() + "</name>");
			sb.append("</item>");
		}

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
			//System.out.println("sb =============================="+ sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getItemListForIssueToOTAFU(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		String itemNameField = "";
		String autoHint = "";
		int issueId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("requiredField") != null) {
			itemNameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(itemNameField) != null) {
			autoHint = (request.getParameter(itemNameField));
		}
		if (request.getParameter("issueId") != null) {
			issueId = Integer.parseInt((request.getParameter("issueId")));
		}
		System.out
				.println("issueId                        issueId                       "
						+ issueId);
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		dataMap.put("autoHint", autoHint);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("issueId", issueId);
		map = nonExpandableHandlerService.getItemListForIssueToOTAFU(dataMap);
		jsp = "result";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView deleteIssueToOTAFU(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map map = new HashMap();
		Map dataMap = new HashMap();
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------

		int issueId = 0;
		jsp = RequestConstants.SHOW_DELETE_POPUP_FOR_ISSUE_OTAFU;
		box.put("deptId", deptId);
		map = nonExpandableHandlerService.deleteIssueToOTAFU(box);
		map.put("contentJsp", jsp);
		map.put("departmentIdTemp", deptId);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showDeleteIssueToOTAFU(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map map = new HashMap();
		Map dataMap = new HashMap();
		int issueId = 0;
		int departmentIdTemp = 0;
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		jsp = RequestConstants.SHOW_DELETE_POPUP_FOR_ISSUE_OTAFU;
		box.put("deptId", deptId);
		map = nonExpandableHandlerService.showDeleteIsuueToOTAFU(box);
		map.put("contentJsp", jsp);
		map.put("departmentIdTemp", departmentIdTemp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView openDeletePopupForIssueToOTAFU(
			HttpServletRequest request, HttpServletResponse response) {
		int departmentIdTemp = 0;
		Map dataMap = new HashMap();
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		jsp = SHOW_DELETE_POPUP_FOR_ISSUE_OTAFU;
		dataMap.put("deptId", deptId);
		map = nonExpandableHandlerService
				.openDeletePopupForIssueToOTAFU(dataMap);
		map.put("contentJsp", jsp);
		map.put("departmentIdTemp", departmentIdTemp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView addNextOrSubmitIssueToOTAFU(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("userName", userName);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);

		Map map = new HashMap();
		Map pageMap = new HashMap();
		Box box = HMSUtil.getBox(request);
		int issueId = 0;
		int pageNo = 0;
		String buttonName = "next";
		String messageTOBeVisibleToTheUser = "";
		buttonName = "" + box.get("buttonName");
		if (buttonName.equals("next")) {
			pageNo = Integer.parseInt("" + box.getInt("pageNo"));
			map = nonExpandableHandlerService.showIssueToOtherUnitsJsp(dataMap);
			jsp = RequestConstants.ISSUED_TO_OTAFU_JSP;

		} else {
			jsp = STORES_MESSAGE_JSP;
			messageTOBeVisibleToTheUser = "Issued Successfully";
			map.put("url", "stores?method=showIssueToOtherUnitsJsp");
			map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		}
		//System.out.println("pageNo  " + pageNo);
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("pageNo", pageNo + 1);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addBrandDetailsIssueToOTAFU(HttpServletRequest request,
			HttpServletResponse response) throws java.text.ParseException {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map map = new HashMap();
		Box box = HMSUtil.getBox(request);
		String messageTOBeVisibleToTheUser = "";
		session = request.getSession();

		box.put("hospitalId", hospitalId);
		box.put("deptId", deptId);
		map = nonExpandableHandlerService.addBrandDetailsToOTAFU(box);
		String successfullyAdded = "n";

		if (map.get("successfullyAdded") != null) {
			successfullyAdded = "" + map.get("successfullyAdded");
		}
		if (successfullyAdded.equals("y")) {
			messageTOBeVisibleToTheUser = "Records Added Succesfully";
		} else {
			messageTOBeVisibleToTheUser = "Records Not Added";
		}
		//System.out.println("messageTOBeVisibleToTheUser  "+ messageTOBeVisibleToTheUser);
		jsp = RequestConstants.EXIT_WINDOW;
		map.put("contentJsp", jsp);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView searchIssueToOTAFU(HttpServletRequest request,
			HttpServletResponse response) {
		Map map = new HashMap();
		Box box = HMSUtil.getBox(request);
		map = nonExpandableHandlerService.searchIssueToOTAFU(box);
		jsp = RequestConstants.ISSUED_TO_OTAFU_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showIssueToOTAFUJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map map = new HashMap();
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		dataMap.put("deptId", deptId);
		map = nonExpandableHandlerService.showIssueToOTAFUJsp(dataMap);
		jsp = RequestConstants.ISSUED_TO_OTAFU_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView openItemBrandWindowJspIssueToOTAFU(
			HttpServletRequest request, HttpServletResponse response)
			throws ParseException {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------

		Box box = HMSUtil.getBox(request);
		Map map = new HashMap();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int itemId = 0;
		int rowVal = 0;
		session = request.getSession();
		if (request.getParameter(RequestConstants.ITEM_ID) != null) {
			itemId = Integer.parseInt(request
					.getParameter(RequestConstants.ITEM_ID));
		}

		dataMap.put("deptId", deptId);
		dataMap.put("itemId", itemId);
		map = nonExpandableHandlerService.getBrandMap(dataMap);
		if (request.getParameter("rowVal") != null) {
			rowVal = Integer.parseInt(request.getParameter("rowVal"));
		}
		map.put("rowVal", rowVal);
		jsp = RequestConstants.ITEM_BRAND_WINDOW_JSP_TO_OTAFU;
		return new ModelAndView(jsp, "map", map);
	}

	// ------------------End of Issues To Other than Airforce
	// Units-------------------------

	// -----------------------------------------Start Of Indent Soc Tracker
	// methods---------------------------------

	/*
	 * This is the method used to show Indent Soc Tracker Page
	 */
	public ModelAndView getItemListForSocTracker(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int indentId = 0;
		try {
			if (request.getParameter(RequestConstants.INDENT_ID) != null) {
				indentId = Integer.parseInt(""
						+ request.getParameter(RequestConstants.INDENT_ID));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("indentId", indentId);
		try {
			map = nonExpandableHandlerService.getItemListForSocTracker(dataMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RequestConstants.AJAX_ITEM_LIST;
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);

	}

	/*
	 * This is the method used to show Indent Soc Tracker Page
	 */
	public ModelAndView getIndentListForSocTracker(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int selectedDepartmentId = 1;
		try {
			if (request.getParameter(RequestConstants.DEPARTMENT_ID_TEMP) != null) {
				selectedDepartmentId = Integer
						.parseInt(""
								+ request
										.getParameter(RequestConstants.DEPARTMENT_ID_TEMP));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("selectedDepartmentId", selectedDepartmentId);
		try {
			map = nonExpandableHandlerService
					.getIndentListForSocTracker(dataMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = AJAX_INDENT_LIST;
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);

	}

	/*
	 * This is the method used to show Indent Soc Tracker Page
	 */
	public ModelAndView showIndentSocTracker(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = nonExpandableHandlerService.showIndentSocTracker();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = INDENT_SOC_TRACKER;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	/*
	 * This is the method to get the map from store_indent_soc_tracker table
	 * based on the indentId,departmentId,nomenclature
	 */
	public ModelAndView getIndentSocTrackerDetails(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> idsMap = new HashMap<String, Object>();
		int indentId = 0;
		int toDepartmentId = 0;
		int itemId = 0;
		String nomenclature = "";

		if (request.getParameter(INDENT_ID) != null) {
			indentId = Integer.parseInt(request.getParameter(INDENT_ID));
		}
		if (request.getParameter(DEPARTMENT_ID) != null) {
			toDepartmentId = Integer.parseInt(request
					.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(ITEM_ID) != null) {
			itemId = Integer.parseInt("" + (request.getParameter(ITEM_ID)));
		}
		idsMap.put("indentId", indentId);
		idsMap.put("toDepartmentId", toDepartmentId);
		idsMap.put("itemId", itemId);

		map = nonExpandableHandlerService.getIndentSocTracker(idsMap);
		jsp = INDENT_SOC_TRACLER_DETAILS;
		// jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView(jsp, "map", map);

	}

	/*
	 * This is the method used to add or update the Indent Soc Tracker details
	 */
	public ModelAndView addOrUpdateIndentSocTracker(HttpServletRequest request,
			HttpServletResponse response) {

		StoreIndentSocTracker storeIndentSocTracker = new StoreIndentSocTracker();
		int indentId = 0;
		int departmentId = 1;
		int itemId = 0;
		String presentStatus = "";
		String remarks = "";
		String forwardToTc = "";
		String srNoAtAirhq = "";
		String forwardTcToAirhq = "";
		String forwardAirhqToDgafms = "";
		Date dateOfSoc = new Date();
		int indentSocTrackerId = 0;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String lastChgDate = (String) utilMap.get("currentDate");
		String lastChgTime = (String) utilMap.get("currentTime");
		String lastChgBy = "";
		String userName = "";
		session = request.getSession();
		int hospitalId = Integer.parseInt(""
				+ session.getAttribute("hospitalId"));
		String messageTOBeVisibleToTheUser = "";
		String buttonType = "";

		try {
			if (request.getParameter(NOMENCLATURE) != null) {
				itemId = Integer.parseInt(""
						+ (request.getParameter(NOMENCLATURE)));
			}
			if (request.getParameter("INDENT_SOC_TRACKER_ID") != null) {
				indentSocTrackerId = Integer.parseInt(request
						.getParameter("INDENT_SOC_TRACKER_ID"));
			}
			if (request.getParameter(INDENT_ID) != null) {
				indentId = Integer.parseInt(request.getParameter(INDENT_ID));
			}
			if (request.getParameter(DEPARTMENT_ID) != null) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
			}
			if (request.getParameter(PRESENT_STATUS) != null) {
				presentStatus = (request.getParameter(PRESENT_STATUS));
			}
			if (request.getParameter(REMARKS) != null) {
				remarks = (request.getParameter(REMARKS));
			}
			if (request.getParameter(FORWARD_TO_TC) != null) {
				forwardToTc = (request.getParameter(FORWARD_TO_TC));
			}
			if (request.getParameter(SOC_SR_NO_AT_AIRHQ) != null) {
				srNoAtAirhq = (request.getParameter(SOC_SR_NO_AT_AIRHQ));
			}
			if (request.getParameter(FORWARD_TC_TO_AIRHQ) != null) {
				forwardTcToAirhq = (request.getParameter(FORWARD_TC_TO_AIRHQ));
			}
			if (request.getParameter(FORWARD_AIRHQ_TO_DGAFMS) != null) {
				forwardAirhqToDgafms = (request
						.getParameter(FORWARD_AIRHQ_TO_DGAFMS));
			}
			if ((request.getParameter(DATE_OF_SOC_FORWARD) != null)
					|| (!(request.getParameter(DATE_OF_SOC_FORWARD).equals("")))) {
				dateOfSoc = (HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(DATE_OF_SOC_FORWARD)));
			}
		} catch (Exception e) {
			//System.out.println("eeeeeeee" + e);
		}

		try {
			if (indentSocTrackerId != 0)
				storeIndentSocTracker.setId(indentSocTrackerId);
			MasDepartment department = new MasDepartment();
			department.setId(departmentId);
			storeIndentSocTracker.setDepartment(department);

			StoreIndentM storeIndentM = new StoreIndentM();
			storeIndentM.setId(indentId);
			storeIndentSocTracker.setIndent(storeIndentM);

			storeIndentSocTracker.setPresentStatus(presentStatus);
			storeIndentSocTracker.setRemarks(remarks);
			storeIndentSocTracker.setForwardToTc(forwardToTc);
			storeIndentSocTracker.setSrNoAtAirhq(srNoAtAirhq);
			storeIndentSocTracker.setForwardTcToAirhq(forwardTcToAirhq);
			storeIndentSocTracker.setForwardAirhqToDgafms(forwardAirhqToDgafms);
			storeIndentSocTracker.setDateOfSoc(dateOfSoc);

			MasStoreItem item = new MasStoreItem();
			item.setId(itemId);
			storeIndentSocTracker.setItem(item);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			storeIndentSocTracker.setHospital(masHospital);
			storeIndentSocTracker.setLastChgBy(userName);
			storeIndentSocTracker.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(lastChgDate));
			storeIndentSocTracker.setLastChgTime(lastChgTime);

		} catch (Exception e) {
			//System.out.println("e " + e);
			e.printStackTrace();
		}

		boolean flag = nonExpandableHandlerService.addOrUpdateIndentSocTracker(
				storeIndentSocTracker, indentSocTrackerId);

		jsp = RequestConstants.STORES_MESSAGE_JSP;
		jsp += ".jsp";

		if (flag) {
			messageTOBeVisibleToTheUser = "Added Successfully ";
			map.put("contentJsp", jsp);
			map.put("url", "/hms/hms/stores?method=showIndentSocTracker");
			map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);

			return new ModelAndView("index", "map", map);
		} else {
			messageTOBeVisibleToTheUser = "Not Added";
			map.put("contentJsp", jsp);
			map.put("url", "/hms/hms/stores?method=showIndentSocTracker");
			map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);

			return new ModelAndView("index", "map", map);
		}

	}

	// -----------------------------------------End Of Indent Soc Tracker
	// methods---------------------------------

	// --------------------------------------------Vendor
	// Return-------------------------------------
	public ModelAndView getItemListForVendorReturn(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		String itemNameField = "";
		String autoHint = "";
		int sectionId = 0;
		int indentId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			if (request.getParameter("section") != null) {
				sectionId = Integer.parseInt(""
						+ (request.getParameter("section")));
			}
			if (request.getParameter("indentId") != null) {
				indentId = Integer.parseInt(""
						+ (request.getParameter("indentId")));
			}
			List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
			dataMap.put("autoHint", autoHint);
			dataMap.put("deptId", deptId);
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("sectionId", sectionId);
			dataMap.put("indentId", indentId);

			map = nonExpandableHandlerService
					.getItemListForVendorReturn(dataMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "resultForVendorReturn";
		return new ModelAndView(jsp, "map", map);
	}

	public void fillItemsForIndentToVendorReturn(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		String itemNameField = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String brandName = "";
		List objectList = new ArrayList();
		try {
			if (request.getParameter("brandName") != null) {
				brandName = request.getParameter("brandName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		dataMap.put("brandName", brandName);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		map = nonExpandableHandlerService
				.fillItemsForIndentToVendorReturn(dataMap);
		if (map.get("objectList") != null) {
			objectList = (List) map.get("objectList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
				Object[] object = (Object[]) iterator.next();

				sb.append("<item>");
				sb.append("<id>" + object[0] + "</id>");
				sb.append("<pvms>" + object[1] + "</pvms>");
				sb.append("<name>" + object[2] + "</name>");
				sb.append("<brandId>" + object[3] + "</brandId>");
				sb.append("</item>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
			//System.out.println("sb =============================="+ sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showVendorReturnJsp(HttpServletRequest request,
			HttpServletResponse response) {
		// Session-----
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
		// --------------------------------------------------------------------------------
		Box box = HMSUtil.getBox(request);
		String returnNo = "";
		int storeFyDocumentNoId = 0;
		session = request.getSession();
		String buttonFlag = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("deptId", deptId);
		if (request.getParameter("buttonFlag") != null) {
			buttonFlag = request.getParameter("buttonFlag");

			int pageNo = Integer.parseInt(request.getParameter("pageNo"));

			if (buttonFlag.equals("next")) {

				deptId = Integer.parseInt(request.getParameter("deptId"));
				if (request.getParameter("returnNo") != null) {
					returnNo = (String) request.getParameter("returnNo");
				}
				pageNo++;
				map.put("pageNo", pageNo);
				map.put("buttonFlag", buttonFlag);

			}
		}
		map = nonExpandableHandlerService.showVendorReturnJsp(map);

		jsp = VENDOR_RETURN_JSP;
		jsp += ".jsp";
		title = "Return From Dispensary";
		if (request.getParameter("storeFyDocumentNoId") != null) {
			storeFyDocumentNoId = Integer.parseInt(request
					.getParameter("storeFyDocumentNoId"));
			map.put("storeFyDocumentNoId", storeFyDocumentNoId);
		}
		map.put("returnNo", returnNo);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	/*
	 * method to open the pop up screen after selecting the brand name and
	 * window will populate the grid with the data and user can issue the
	 * quantity there onn the screen.
	 */
	public ModelAndView showStockDetailsForVendorReturn(
			HttpServletRequest request, HttpServletResponse response) {
		// Session-----
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
		// --------------------------------------------------------------------------------
		session = request.getSession();
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		int brandId = 0;
		int rowVal = 0;
		try {
			rowVal = Integer.parseInt(request.getParameter("rowVal"));
			String fromDateToDate = request.getParameter("fromDateToDate");
			brandId = Integer.parseInt(request.getParameter("brandId"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("deptId", deptId);
		map.put("brandId", brandId);
		map.put("rowVal", rowVal);
		map = nonExpandableHandlerService.showStockDetailsForVendorReturn(map);
		//		 
		jsp = STOCK_DETAILS_VENDOR_RETURN_JSP;
		// jsp += ".jsp";
		title = "Stock Details";
		map.put("deptId", deptId);
		map.put("date", date);
		map.put("time", time);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView submitVendorReturnDetails(HttpServletRequest request,
			HttpServletResponse response) {
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map<String, Object> map = new HashMap<String, Object>();
		List issQtyList = new ArrayList();
		List amountList = new ArrayList();
		List pvmsList = new ArrayList();
		List batchNumberList = new ArrayList();
		List brandNameList = new ArrayList();
		List expiryDateList = new ArrayList();
		List costPriceList = new ArrayList();
		List storeItemBatchStockIdList = new ArrayList();
		int vendorId = 0;
		int approvedById = 0;
		int returnById = 0;
		String remarks = "";
		String reason = "";
		String SONo = "";
		int itemId = 0;
		try {
			// String itemId = request.getParameter("itemId");
			String returnNo = request.getParameter(RETURN_NO);
			String returnDate = request.getParameter(RETURN_DATE);
			String referenceNo = request.getParameter(REFERENCE_NO);
			SONo = request.getParameter("SONo");

			if (request.getParameter(VENDOR_NAME) != null
					&& !request.getParameter(VENDOR_NAME).equals("0")) {
				vendorId = Integer.parseInt(request.getParameter(VENDOR_NAME));
			}
			if (request.getParameter("itemId") != null
					&& !request.getParameter("itemId").equals("0")) {
				itemId = Integer.parseInt(request.getParameter("itemId"));
			}

			if (request.getParameter(APPROVED_BY) != null
					&& !(request.getParameter(APPROVED_BY).equals("0"))) {
				approvedById = Integer.parseInt(request
						.getParameter(APPROVED_BY));
			}
			if (request.getParameter(RETURN_BY_ID) != null
					&& !(request.getParameter(RETURN_BY_ID).equals("0"))) {
				returnById = Integer.parseInt(request
						.getParameter(RETURN_BY_ID));
			}
			if (request.getParameter(REMARKS) != null) {
				remarks = request.getParameter(REMARKS);
			}
			if (request.getParameter(REASON) != null) {
				reason = request.getParameter(REASON);
			}
			int storeGrnReturnMId = Integer.parseInt(request
					.getParameter("storeGrnReturnMId"));

			int counter = Integer.parseInt(request.getParameter("counter"));
			//System.out.println("counter          " + counter);
			for (int i = 0; i < counter; i++) {
				String str = request.getParameter("issueQty" + i);
				//System.out.println("str  " + str);
				if (str.length() > 0) {
					issQtyList.add(request.getParameter("issueQty" + i));

					pvmsList.add(itemId);
					batchNumberList.add(request.getParameter("batchNo" + i));
					brandNameList.add(request.getParameter("brandId" + i));
					expiryDateList.add(request.getParameter("expiryDate" + i));
					costPriceList.add(request.getParameter("costprice" + i));
					storeItemBatchStockIdList.add(request
							.getParameter("storeItemBatchStockId" + i));
					amountList.add(request.getParameter("amount" + i));

				}
				map.put("hospitalId", hospitalId);
				map.put("deptId", deptId);
				map.put("returnNo", returnNo);
				map.put("returnDate", returnDate);
				map.put("referenceNo", referenceNo);
				map.put("approvedById", approvedById);
				map.put("returnById", returnById);
				map.put("remarks", remarks);
				map.put("reason", reason);

				map.put("userName", userName);
				map.put("pvmsList", pvmsList);
				map.put("batchNumberList", batchNumberList);
				map.put("brandNameList", brandNameList);
				map.put("expiryDateList", expiryDateList);
				map.put("issQtyList", issQtyList);
				map.put("costPriceList", costPriceList);
				map.put("amountList", amountList);
				map.put("SONo", SONo);
				map.put("storeItemBatchStockIdList", storeItemBatchStockIdList);
				map.put("storeGrnReturnMId", storeGrnReturnMId);
				map.put("vendorId", vendorId);
				map.put("itemId", itemId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean successfullyAdded = nonExpandableHandlerService
				.submitVendorReturnDetails(map);
		if (successfullyAdded) {
			message = "Stock  has been Updated Successfully !!";
		} else {
			message = "Error Ocurred Please Try Again!!";
		}
		jsp = STOCK_UPDATED_MESSAGE_JSP;

		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView showDeleteVendorReturn(HttpServletRequest request,
			HttpServletResponse response) {

		session = request.getSession();

		String returnNo = request.getParameter("returnNo");
		//System.out.println("returnNo          in c " + returnNo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("returnNo", returnNo);
		map = nonExpandableHandlerService.showDeleteVendorReturn(map);
		//		 

		jsp = DELETE_VENDOR_RETURN_JSP;

		title = "Delete Return From Dispensary";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView deleteStockDetailsVendorReturn(
			HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int returnTId = Integer.parseInt(request.getParameter("parent"));
		//System.out.println("returnTId  " + returnTId);
		map.put("returnTId", returnTId);
		boolean successfullyDeleted = nonExpandableHandlerService
				.deleteStockDetailsVendorReturn(map);

		if (successfullyDeleted) {
			message = "Stock  has been Deleted Successfully !!";
		} else {
			message = "Error Ocurred Please Try Again!!";
		}
		jsp = STOCK_UPDATED_MESSAGE_JSP;
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView searchVendorReturn(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String fromDate = "";
		String toDate = "";
		int supplierId = 0;
		String includedJsp = "";
		int returnId = 0;
		String jsp = SEARCH_VENDOR_RETURN_JSP;
		jsp += ".jsp";
		int deptId = 0;
		String returnNo = "";
		int storeFyDocumentNoId = 0;
		session = request.getSession();
		String buttonFlag = "";
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		int pageNo = 0;
		pageNo = Integer.parseInt(request.getParameter("pageNo"));
		//System.out.println("PAGE NO IN CON First   " + pageNo);
		pageNo++;
		if (request.getParameter("buttonFlag") != null) {
			buttonFlag = request.getParameter("buttonFlag");

			//System.out.println("value of button flag in controller==="+ buttonFlag);
			if (buttonFlag.equals("next")) {
				//System.out.println("IN NEXT BUTTON");
				deptId = Integer.parseInt(request.getParameter("deptId"));
				if (request.getParameter("returnNo") != null) {
					returnNo = (String) request.getParameter("returnNo");
				}
				map.put("pageNo", pageNo);
				map.put("deptId", deptId);
				map.put("buttonFlag", buttonFlag);
			}

		}
		infoMap = nonExpandableHandlerService.showVendorReturnJsp(map);

		Map<String, Object> searchFieldMap = new HashMap<String, Object>();
		try {
			if (request.getParameter(FROM_DATE) != null) {
				fromDate = request.getParameter(FROM_DATE);
			}
			if (request.getParameter(TO_DATE) != null) {
				toDate = request.getParameter(TO_DATE);
			}
			if (request.getParameter(VENDOR_RETURN_ID) != null) {
				returnId = Integer.parseInt(request
						.getParameter(VENDOR_RETURN_ID));

			}
		} catch (Exception e) {
			//System.out.println("ex p in c " + e);
		}

		searchFieldMap.put("fromDate", fromDate);
		searchFieldMap.put("toDate", toDate);
		searchFieldMap.put("returnId", returnId);
		//System.out.println("pageNo  in con pageNo  " + pageNo);
		searchFieldMap.put("pageNo", pageNo);

		if (searchFieldMap.size() != 0) {
			map = nonExpandableHandlerService
					.searchVendorReturn(searchFieldMap);
			//System.out.println("poMap  " + map.size());
			includedJsp = "done";
		} else {
			//System.out.println("Enter value ");
		}

		map.put("infoMap", infoMap);
		map.put("returnNo", returnNo);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("pageNo", pageNo);
		map.put("includedJsp", includedJsp);
		map.put("returnId", returnId);
		return new ModelAndView("index", "map", map);
	}

	// -------------------------Start of Disposal Entry <= Rs
	// 30------------------------------------------

	public ModelAndView showDisposalEntry(HttpServletRequest request,
			HttpServletResponse response) {
		// Session-----
		session = request.getSession();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		// --------------------------------------------------------------------------------
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		map = nonExpandableHandlerService.showDisposalEntry(dataMap);
		jsp = DISPOSAL_ENTRY_JSP;
		jsp = jsp + ".jsp";
		title = "Disposal Entry";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView importFromBOS(HttpServletRequest request,
			HttpServletResponse response) {
		// Session-----
		session = request.getSession();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		// --------------------------------------------------------------------------------
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		Box box = HMSUtil.getBox(request);
		int bosId = 0;
		String disposalNo = "";
		try {
			if (request.getParameter(DISPOSAL_NO) != null) {
				disposalNo = ("" + request.getParameter(DISPOSAL_NO));
			}
			if (request.getParameter(BOS_ID) != null) {
				bosId = Integer.parseInt("" + request.getParameter(BOS_ID));
			}
			dataMap.put("bosId", bosId);
			dataMap.put("box", box);
			map = nonExpandableHandlerService.importFromBOS(dataMap);
			jsp = DISPOSAL_ENTRY_JSP;
			jsp = jsp + ".jsp";
			title = "Disposal Entry";
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateCiv(HttpServletRequest request,
			HttpServletResponse response) {
		// Session-----
		session = request.getSession();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		// --------------------------------------------------------------------------------
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		int bosId = 0;
		if (request.getParameter(BOS_ID) != null) {
			bosId = Integer.parseInt("" + request.getParameter(BOS_ID));
		}
		dataMap.put("bosId", bosId);
		dataMap.put("box", box);
		map = nonExpandableHandlerService.generateCiv(dataMap);
		jsp = ISSUE_JSP_FOR_DISPOSAL;
		jsp = jsp + ".jsp";
		title = "Disposal Entry";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateIndent(HttpServletRequest request,
			HttpServletResponse response) {
		// Session-----
		session = request.getSession();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		// --------------------------------------------------------------------------------
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		int bosId = 0;
		String entryType = "";
		if (request.getParameter(BOS_ID) != null) {
			bosId = Integer.parseInt("" + request.getParameter(BOS_ID));
		}

		if (request.getParameter("entryType") != null) {
			entryType = ("" + request.getParameter("entryType"));
		}
		dataMap.put("bosId", bosId);
		dataMap.put("box", box);
		map = nonExpandableHandlerService.generateIndent(dataMap);
		jsp = INDENT_JSP_FOR_DISPOSAL;
		jsp = jsp + ".jsp";
		title = "Disposal Entry";
		map.put("entryType", entryType);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateDisposalEntry(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		Box box = HMSUtil.getBox(request);

		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
		box.put("userName", userName);
		map = nonExpandableHandlerService.updateDisposalEntry(box);
		jsp = DISPOSAL_ENTRY_JSP;
		jsp += ".jsp";
		title = "Store MMF";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView nextIndentForDisposal(HttpServletRequest request,
			HttpServletResponse response) {
		jsp = DISPOSAL_ENTRY_JSP;
		jsp += ".jsp";
		title = "Store MMF";
		map.put("contentJsp", jsp);
		map.put("title", title);
		Box box = HMSUtil.getBox(request);
		String messageType = "";
		String messageTOBeVisibleToTheUser = "";
		String url = "";
		int pageNo = 1;
		int indentId = 0;
		String entryType = "";
		if (request.getParameter("entryType") != null) {
			entryType = ("" + request.getParameter("entryType"));
		}
		if (box.get("pageNo") != null) {
			pageNo = Integer.parseInt("" + box.get("pageNo"));
		}
		if (box.get("indentId") != null) {
			indentId = Integer.parseInt("" + box.get("indentId"));
		}
		if (box.get("pageNo").equals("1")
				|| box.get("buttonName").equals("submit")) {
			map = nonExpandableHandlerService.saveHeaderForIndent(box);
		}
		if (box.get("buttonName").equals("submit")) {
			messageType = "success";
			messageTOBeVisibleToTheUser = "Added Successfully";
			if (entryType.equals("l"))
				url = "/hms/hms/nonExp?method=showDisposalEntry";
			else
				url = "/hms/hms/nonExp?method=showDisposalEntryGreaterThan30";
			map.put("url", url);
			map.put("messageType", messageType);
			map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
			jsp = STORES_MESSAGE_JSP;

		} else {
			jsp = INDENT_JSP_FOR_DISPOSAL;
			map = nonExpandableHandlerService.getIndentMapForDisposal(indentId,
					pageNo);
		}
		jsp += ".jsp";
		title = "Store MMF";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getDisposalData(HttpServletRequest request,
			HttpServletResponse response) {
		// Session-----
		session = request.getSession();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		// --------------------------------------------------------------------------------
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		Box box = HMSUtil.getBox(request);
		int bosId = 0;
		String disposalNo = "";
		try {
			if (request.getParameter(DISPOSAL_NO) != null) {
				disposalNo = ("" + request.getParameter(DISPOSAL_NO));
			}
			if (request.getParameter(BOS_ID) != null) {
				bosId = Integer.parseInt("" + request.getParameter(BOS_ID));
			}
			dataMap.put("bosId", bosId);
			dataMap.put("box", box);
			map = nonExpandableHandlerService.getDisposalData(dataMap);
			jsp = DISPOSAL_ENTRY_JSP;
			jsp = jsp + ".jsp";
			title = "Disposal Entry";
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getIssueDisposalData(HttpServletRequest request,
			HttpServletResponse response) {
		// Session-----
		session = request.getSession();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		// --------------------------------------------------------------------------------
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		int bosId = 0;
		if (request.getParameter(BOS_ID) != null) {
			bosId = Integer.parseInt("" + request.getParameter(BOS_ID));
		}
		dataMap.put("bosId", bosId);
		dataMap.put("box", box);
		map = nonExpandableHandlerService.getIssueDisposalData(dataMap);
		jsp = ISSUE_JSP_FOR_DISPOSAL;
		jsp = jsp + ".jsp";
		title = "Disposal Entry";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateIssueForDisposalEntry(HttpServletRequest request,
			HttpServletResponse response) {
		// Session-----
		session = request.getSession();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		// --------------------------------------------------------------------------------
		Box box = HMSUtil.getBox(request);

		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
		box.put("userName", userName);
		map = nonExpandableHandlerService.updateIssueForDisposalEntry(box);
		jsp = ISSUE_JSP_FOR_DISPOSAL;
		jsp += ".jsp";
		title = "Store MMF";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	// -------------------------End of Disposal Entry <= Rs
	// 30------------------------------------------

	// -------------------------Start of Disposal Entry > Rs
	// 30-------------------------------------
	public ModelAndView showDisposalEntryGreaterThan30(
			HttpServletRequest request, HttpServletResponse response) {
		// Session-----
		session = request.getSession();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		// --------------------------------------------------------------------------------
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		map = nonExpandableHandlerService.showDisposalEntry(dataMap);
		jsp = DISPOSAL_ENTRY_GREATER_THAN30_JSP;
		jsp = jsp + ".jsp";
		title = "Disposal Entry";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView importFromBOS2(HttpServletRequest request,
			HttpServletResponse response) {
		// Session-----
		session = request.getSession();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		// --------------------------------------------------------------------------------
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		Box box = HMSUtil.getBox(request);
		int bosId = 0;
		String disposalNo = "";
		try {
			if (request.getParameter(DISPOSAL_NO) != null) {
				disposalNo = ("" + request.getParameter(DISPOSAL_NO));
			}
			if (request.getParameter(BOS_ID) != null) {
				bosId = Integer.parseInt("" + request.getParameter(BOS_ID));
			}
			dataMap.put("bosId", bosId);
			dataMap.put("box", box);
			map = nonExpandableHandlerService.importFromBOS2(dataMap);
			jsp = DISPOSAL_ENTRY_GREATER_THAN30_JSP;
			jsp = jsp + ".jsp";
			title = "Disposal Entry";
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateDisposalEntry2(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		Box box = HMSUtil.getBox(request);

		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
		box.put("userName", userName);
		map = nonExpandableHandlerService.updateDisposalEntry2(box);
		jsp = DISPOSAL_ENTRY_GREATER_THAN30_JSP;
		jsp += ".jsp";
		title = "Store MMF";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	// -------------------------End of Disposal Entry > Rs
	// 30-----------------------------------------------
	// *********************************************************************************************************************
	// ------------------------------------End of Methods Written By
	// Vivek------------------------------------------
	// ****************************************************************************************************************

	// ****************************************************************************************************************
	// ------------------------------------------Start report by
	// Mansi----------------------------------------------//
	// ****************************************************************************************************************
	public ModelAndView printIndentToDepotJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String intentNo = null;
		session = request.getSession();
		requestParameters.put("DEPART", session.getAttribute("deptId"));

		try {
			if (request.getParameter(INDENT_NO) != null
					&& !(request.getParameter(INDENT_NO).equals(""))) {
				intentNo = request.getParameter(INDENT_NO);
				requestParameters.put("INDENT_NO", intentNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = nonExpandableHandlerService
				.getConnectionForReport();
		byte[] bytes = null;

		try {
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport(DOCUMENT_PRINT_OF_INDENT_OF_DEPT),
					requestParameters, (Connection) connectionMap.get("con"));
		} catch (JRException e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment; filename="
				+ DOCUMENT_PRINT_OF_INDENT_OF_DEPT + ".pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printSocToDepotJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		int intentId = 0;
		try {
			if (request.getParameter("indentId") != null
					&& !(request.getParameter("indentId").equals(""))) {
				intentId = Integer.parseInt(request.getParameter("indentId"));
				requestParameters.put("INDENT_ID", intentId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = nonExpandableHandlerService
				.getConnectionForReport();
		byte[] bytes = null;

		try {
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport(DOCUMENT_PRINT_OF_SOC),
					requestParameters, (Connection) connectionMap.get("con"));
		} catch (JRException e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment; filename="
				+ DOCUMENT_PRINT_OF_SOC + ".pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showHalfYearlyItemJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Half Yearly Item Report";
		jsp = HALF_YEARLY_ITEM_REPORT_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateHalfYearlyItemReport(
			HttpServletRequest request, HttpServletResponse response) {

		System.out
				.println("PurchaseOrderController.generateHalfYearlyItemReport()");
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		int hospitalId = 0;
		String hospitalName = "";
		session = request.getSession();
		requestParameters.put("DEPART", session.getAttribute("deptId"));
		try {
			/*
			 * if(session.getAttribute("hospitalId") != null) { hospitalId =
			 * (Integer)session.getAttribute("hospitalId"); hospitalName =
			 * nonExpandableHandlerService.getHospitalName(hospitalId);
			 * requestParameters.put("HOSP_NAME", hospitalName);
			 * //System.out.println
			 * ("Hosptial name in ABC Analysis REPORT----"+hospitalName); }
			 */
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("From_Date", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("To_Date", toDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = nonExpandableHandlerService
				.getConnectionForReport();
		//System.out.println("connectionMap.........."+ (Connection) connectionMap.get("con"));
		HMSUtil.generateReport(HALF_YEARLY_ITEM_REPORT, requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		//System.out.println("After generating the report......");
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAnnualAcquisitionPlanRegisterJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Annual Acquisition Plan Register Report";
		jsp = ANNUAL_ACQUISITION_PLAN_REGISTER_REPORT_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateAnnualAcquisitionPlanRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {

		System.out
				.println("PurchaseOrderController.generateAnnualAcquisitionPlanRegisterReport()");
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		int hospitalId = 0;
		String hospitalName = "";
		session = request.getSession();
		requestParameters.put("DEPART", session.getAttribute("deptId"));
		try {
			/*
			 * if(session.getAttribute("hospitalId") != null) { hospitalId =
			 * (Integer)session.getAttribute("hospitalId"); hospitalName =
			 * nonExpandableHandlerService.getHospitalName(hospitalId);
			 * requestParameters.put("HOSP_NAME", hospitalName);
			 * //System.out.println
			 * ("Hosptial name in ABC Analysis REPORT----"+hospitalName); }
			 */
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("From_Date", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("To_Date", toDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = nonExpandableHandlerService
				.getConnectionForReport();
		//System.out.println("connectionMap.........."+ (Connection) connectionMap.get("con"));
		HMSUtil.generateReport(ANNUAL_ACQUISITION_PLAN_REGISTER_REPORT,
				requestParameters, (Connection) connectionMap.get("con"),
				response, getServletContext());
		//System.out.println("After generating the report......");
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showImportedItemReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = nonExpandableHandlerService.showImportedReportJsp();
		title = "Imported Medical Equipment Register Report";
		jsp = IMPORTED_ITEM_REPORT_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAMCRegisterReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = nonExpandableHandlerService.showAMCRegisterJsp();
		title = "AMC Register";
		jsp = AMC_REPORT_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateAMCRegisterReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		int itemId = 0;
		Map<String, Object> connectionMap = nonExpandableHandlerService
				.getConnectionForReport();
		session = request.getSession();
		try {

			/*
			 * if(session.getAttribute("hospitalId") != null) { hospitalId =
			 * (Integer)session.getAttribute("hospitalId"); hospitalName =
			 * storesHandlerService.getHospitalName(hospitalId);
			 * requestParameters.put("HOSP_NAME", hospitalName);
			 * //System.out.println
			 * ("Hosptial name in ABC Analysis REPORT----"+hospitalName); }
			 */

			if (request.getParameter(PVMS_NO) != null
					&& !(request.getParameter(PVMS_NO).equals(""))) {
				itemId = Integer.parseInt(request.getParameter(PVMS_NO));

			}

			if (itemId == 0) {
				HMSUtil.generateReport("AMCReportAll", requestParameters,
						(Connection) connectionMap.get("con"), response,
						getServletContext());
			} else {
				requestParameters.put("PVMS_NO", itemId);
				HMSUtil.generateReport(AMC_REPORT, requestParameters,
						(Connection) connectionMap.get("con"), response,
						getServletContext());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAMCRegisterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = nonExpandableHandlerService.showAMCRegisterJsp();
		//System.out.println("masStoreItemList in Sontroller");
		jsp = AMC_REPORT_JSP;
		jsp = jsp + ".jsp";
		title = "AMC Register";
		map.put("contentJsp", jsp);
		//System.out.println("aMCReport----" + jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateAMCRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		JRDataSource ds = null;
		List itemList = null;
		Map<String, Object> connectionMap = nonExpandableHandlerService
				.getConnectionForReport();
		session = request.getSession();
		int pvms = 0;
		requestParameters.put("DEPART", session.getAttribute("deptId"));
		try {

			if (request.getParameter(PVMS_NO) != null
					&& !(request.getParameter(PVMS_NO).equals(""))) {
				pvms = Integer.parseInt(request.getParameter(PVMS_NO));
			}
			//System.out.println("pvms" + pvms);

			if ((pvms == 0)) {
				HMSUtil.generateReport("AMCReportAll", requestParameters,
						(Connection) connectionMap.get("con"), response,
						getServletContext());
			} else {

				requestParameters.put("PVMS_NO", pvms);
				HMSUtil.generateReport(AMC_REPORT, requestParameters,
						(Connection) connectionMap.get("con"), response,
						getServletContext());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showUnserviceableItemListReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "UnserviceableItemList";
		jsp = UNSERVICABLE_ITEM_REPORT_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateUnserviceableItemListReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;

		session = request.getSession();
		requestParameters.put("DEPART", session.getAttribute("deptId"));
		try {

			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("FROM_DATE", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("TO_DATE", toDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = nonExpandableHandlerService
				.getConnectionForReport();
		//System.out.println("connectionMap.........."+ (Connection) connectionMap.get("con"));
		HMSUtil.generateReport(UNSERVICABLE_ITEM_REPORT, requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		//System.out.println("After generating the report......");
		return new ModelAndView("index", "map", map);
	}

	// ****************************************************************************************************************
	// -----------------------------------------End report by
	// Mansi----------------------------------------------//
	// ****************************************************************************************************************

	// ================== method by abha
	public ModelAndView getItemListForImportedItemByAutocomplete(
			HttpServletRequest request, HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		String itemNameField = "";
		String autoHint = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("requiredField") != null) {
			itemNameField = (request.getParameter("requiredField"));
			//System.out.println("itemNameField   " + itemNameField);
		}
		if (request.getParameter(itemNameField) != null) {
			autoHint = (request.getParameter(itemNameField));
		}
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		dataMap.put("autoHint", autoHint);
		dataMap.put("deptId", deptId);
		map = nonExpandableHandlerService
				.getItemListForImportedItemByAutocomplete(dataMap);
		jsp = "result";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView generateImportedItemReport(HttpServletRequest request,
			HttpServletResponse response) {

		
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		
		
		Date fromDate = null;
		Date toDate = null;
		int departmentId = 0;
		int hospitalId = 0;	
		int loanOutNo = 0;
	

		session = request.getSession();
		
		if((session.getAttribute("deptId"))!= null && !(session.getAttribute("deptId").equals("")))
		{
			departmentId =  (Integer)(session.getAttribute("deptId"));
			requestParameters.put("departmentId",departmentId);
		}
		
		if((session.getAttribute("hospitalId"))!= null && !(session.getAttribute("hospitalId").equals("")))
		{
			hospitalId =  (Integer)(session.getAttribute("hospitalId"));
			requestParameters.put("hospitalId",hospitalId);
		}
		
		 
		try {

			 if(request.getParameter(FROM_DATE) != null && !(request.getParameter(FROM_DATE).equals("")))
			 {
			   fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			   requestParameters.put("fromDate", fromDate);
			 }
			 
			 if(request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals("")))
			 {
			   toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			   requestParameters.put("toDate", toDate);
			 }
			 
			if ((request.getParameter("loanOutNo")) != null && !(request.getParameter("loanOutNo").equals(""))) 
			{
				loanOutNo = (Integer.parseInt(request.getParameter("loanOutNo")));
				requestParameters.put("loanOutNo", loanOutNo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = nonExpandableHandlerService.getConnectionForReport();

		HMSUtil.generateReport("EquipmentLoanOutEntry", requestParameters, (Connection) connectionMap.get("con"),
				response, getServletContext());

		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView getItemListForMeScale(
			HttpServletRequest request, HttpServletResponse response) {

		Box box = HMSUtil.getBox(request);
		String itemNameField = "";
		String autoHint = "";
		int indentId = 0;
		int hospitalId = 0;
		int deptId = 0;
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("requiredField") != null) {
			itemNameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(itemNameField) != null)
		{
			autoHint = (request.getParameter(itemNameField));
		}
		
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		dataMap.put("autoHint", autoHint);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("indentId", indentId);
		dataMap.put("box", box);
		map = nonExpandableHandlerService.getItemListForMeScale(dataMap);
		jsp = "result";
		return new ModelAndView(jsp, "map", map);
	}
	
	public void fillItemsForMeScale(HttpServletRequest request,
			HttpServletResponse response) {
		//System.out.println("fillItemsForGrn  ");
		session = request.getSession();
		int deptId = 0;
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		Box box = HMSUtil.getBox(request);
		int poId = box.getInt("poId");
		//System.out.println("box in fillitemsforgrn " + box);
		String itemNameField = "";
		String nomenclature = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("requiredField") != null) {
			nomenclature = (request.getParameter("requiredField"));
		}
		//System.out.println("nomenclature" + nomenclature);
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<StorePoDetail> poList = new ArrayList<StorePoDetail>();
		dataMap.put("nomenclature", nomenclature);
		dataMap.put("deptId", deptId);
		dataMap.put("poId", poId);
		map = nonExpandableHandlerService.fillItemsForMeScale(dataMap);
		if (map.get("itemList") != null) {
			itemList = (List) map.get("itemList");
		}
		

		StringBuffer sb = new StringBuffer();
		try {
			for (MasStoreItem masStoreItem : itemList) {

				sb.append("<item>");
				sb.append("<id>" + masStoreItem.getId() + "</id>");
				sb.append("<pvms>" + masStoreItem.getPvmsNo() + "</pvms>");
				try {
					sb.append("<au>"
							+ masStoreItem.getItemConversion()
									.getPurchaseUnit().getUnitName() + "</au>");
				} catch (Exception e) {
					sb.append("<au>" + "-" + "</au>");
				}
				

				sb.append("</item>");
			}

			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
			//System.out.println("sb =============================="+ sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// return new ModelAndView(jsp, "map", map);
	}
	
	
	public ModelAndView showLoanOutJsp(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Map map = new HashMap();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		map = nonExpandableHandlerService.showLoanOutJsp(dataMap);
		//System.out.println("map     " + map.size());
		jsp = "loanOutJspForNe";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	
	
	public ModelAndView submitLoanOutForNe(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
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
		// --------------------------------------------------------------------------------
		Box box = HMSUtil.getBox(request);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("box", box);
		dataMap.put("hospitalId", hospitalId);
		String messageType = "";
		String messageTOBeVisibleToTheUser = "";
		String buttonName = "";
		


		
		
	
		try {
			map = (Map) nonExpandableHandlerService
					.submitLoanOutForNe(dataMap);
			if (map.get("messageType") != null)
				messageType = "" + map.get("messageType");
			
			if (map.get("messageTOBeVisibleToTheUser") != null)
				messageTOBeVisibleToTheUser = ""
						+ map.get("messageTOBeVisibleToTheUser");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			//System.out.println("This is in If===================");
			jsp = STORES_MESSAGE_JSP;
			url = "/hms/hms/nonExp?method=showLoanOutJsp";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
			map.put("messageType", messageType);
			map.put("url", url);

			return new ModelAndView("index", "map", map);

	}
	
	
	 public ModelAndView showSearchIndentToDepo(HttpServletRequest request,HttpServletResponse response) {
			// --- Retriving User Name,Hospital Id,Department Id from Session-----
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
			// --------------------------------------------------------------------------------
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("deptId", deptId);
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("userName", userName);
			Map<String, Object> map = new HashMap<String, Object>();
			map = nonExpandableHandlerService.showSearchIndentToDepo(dataMap);
			jsp = INDENT_TO_DEPOT_NE_JSP;
			jsp = jsp + ".jsp";
			title = "Indent";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("indexB", "map", map);
		}
	

}
