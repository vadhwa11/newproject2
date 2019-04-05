/*
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * StoresController.java  
 * Purpose of the class -  This is the Controller for the Non-Expendable Stores Module
 * @authors  Deepti Tevatia
 * Create Date: 7th May,2008 
 * Revision Date:      
 * Revision By:  
 * @version 2.0
 */

package jkt.hms.stores.controller;

import static jkt.hms.util.RequestConstants.CONDEMNATION_JSP;
import static jkt.hms.util.RequestConstants.CONDEMNATION_NO;
import static jkt.hms.util.RequestConstants.CONDEMNATION_REPORT;
import static jkt.hms.util.RequestConstants.OPD_WAITING;
import static jkt.hms.util.RequestConstants.OPD_WAITING_LIST_JSP;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.stores.handler.NonExpendableNewStoresHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class NonExpendableNewStoresController extends MultiActionController {

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

	// Getters & Setters of Handler Service

	NonExpendableNewStoresHandlerService nonExpendableNewStoresHandlerService = null;

	public NonExpendableNewStoresHandlerService getNonExpendableNewStoresHandlerService() {
		return nonExpendableNewStoresHandlerService;
	}

	public void setNonExpendableNewStoresHandlerService(
			NonExpendableNewStoresHandlerService nonExpendableNewStoresHandlerService) {
		this.nonExpendableNewStoresHandlerService = nonExpendableNewStoresHandlerService;
	}

	// *******************************CONDEMNATION ENTRY
	// *********************************

	public ModelAndView showCondemnationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		String departmentName = "";
		int deptId = 0;
		int hospitalId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();

		if (session.getAttribute("departmentName") != null)
			departmentName = (String) session.getAttribute("departmentName");
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("departmentName", departmentName);

		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = nonExpendableNewStoresHandlerService.showCondemnationJsp(box,
				dataMap);

		jsp = CONDEMNATION_JSP;
		jsp = jsp + ".jsp";
		title = "Condemnation Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getWorkOrderDetails(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		int workId=box.getInt("workId");
		box.put("workId", workId);
		map = nonExpendableNewStoresHandlerService.getWorkOrderDetails(box);
		jsp = CONDEMNATION_JSP;
		jsp = jsp + ".jsp";
		title = "Condemnation Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getWorkOrderDataForDisplayGrid(
			HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = nonExpendableNewStoresHandlerService
				.getWorkOrderDataForDisplayGrid(box);
		jsp = CONDEMNATION_JSP;
		jsp = jsp + ".jsp";
		title = "Condemnation Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteGridItemsForCondemnation(
			HttpServletRequest request, HttpServletResponse response) {

		Box box = HMSUtil.getBox(request);
		map = nonExpendableNewStoresHandlerService
				.deleteGridItemsForCondemnation(box);
		jsp = CONDEMNATION_JSP;
		jsp += ".jsp";
		title = "Condemnation Deletion ";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateGridItemsInCondemnation(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = nonExpendableNewStoresHandlerService
				.updateGridItemsInCondemnation(box);
		jsp = CONDEMNATION_JSP;
		jsp += ".jsp";
		title = "Condemnation Updation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchCondemnation(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = nonExpendableNewStoresHandlerService.searchCondemnation(box);
		jsp = CONDEMNATION_JSP;
		jsp = jsp + ".jsp";
		title = "Condemnation Search";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveCondemnationEntry(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int hospitalId = 0;
		boolean saved = false;
		String message = "";
		String userName = "";
		String departmentName = "";
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("hospitalId") != null){
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		}
		int deptId = 0;
		if (session.getAttribute("deptId") != null){
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (session.getAttribute("departmentName") != null){
			departmentName = (String) session.getAttribute("departmentName");
		}
		if (session.getAttribute("userName") != null){
			userName = (String) session.getAttribute("userName");
		}
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("departmentName", departmentName);

		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
		map = nonExpendableNewStoresHandlerService.saveCondemnationEntry(box);
		if (map.get("succesfullyAdded") != null) {
			saved = (Boolean)map.get("succesfullyAdded");
		}
		if (saved) {
			map = nonExpendableNewStoresHandlerService.showCondemnationJsp(box,dataMap);
				message = "Condemnation Entry saved successfully";
				
				
			
		} else {
			map = nonExpendableNewStoresHandlerService.showCondemnationJsp(box,dataMap);
			message = "Error Occurred in Submitting Details.";
			
		}
		jsp = CONDEMNATION_JSP;
		jsp = jsp + ".jsp";
		title = "Condemnation Search";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}	


	public ModelAndView printCondemnationJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String condemnationNo = "";
		session = request.getSession();
		requestParameters.put("Dept_Id", session.getAttribute("deptId"));
		try {
			//System.out.println("condemnationNo--in controller->"+ condemnationNo);

			if (request.getParameter("IVNo") != null
					&& !(request.getParameter("IVNo").equals(""))) {
				condemnationNo = request.getParameter("IVNo");
				System.out.println("condemnationNo--in controller->"+ condemnationNo);
				requestParameters.put("Condemnation_No", condemnationNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("department==="+session.getAttribute("deptId"));
		Map<String, Object> connectionMap = nonExpendableNewStoresHandlerService
				.getConnectionForReport();
		byte[] bytes = null;

		try {
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport(CONDEMNATION_REPORT), requestParameters,
					(Connection) connectionMap.get("con"));
		} catch (JRException e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment; filename="
				+ CONDEMNATION_REPORT + ".pdf");
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

	private JasperReport getCompiledReport(String fileName) throws JRException {

		File reportFile = new File(getServletContext().getRealPath(
				"/reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile.getPath());

		return jasperReport;
	}

	// **************************** End of condemnation entry
	// ******************************

}
