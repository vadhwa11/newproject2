package jkt.hms.lab.controller;

import static jkt.hms.util.RequestConstants.AD_NO;
import static jkt.hms.util.RequestConstants.ALL_ORDER_BOOKING_FOR_INPATIENT_VIEW_JSP;
import static jkt.hms.util.RequestConstants.ALL_TEST_IDS;
import static jkt.hms.util.RequestConstants.BLOOD_GROUP_ID;
import static jkt.hms.util.RequestConstants.CANCEL_ORDER_BOOKING_JSP;
import static jkt.hms.util.RequestConstants.CHARGE_CODE_ID;
import static jkt.hms.util.RequestConstants.CLINICAL_NOTE;
import static jkt.hms.util.RequestConstants.COLLECTED;
import static jkt.hms.util.RequestConstants.COLLECTION_CENTER_ID;
import static jkt.hms.util.RequestConstants.CONFIDENTIAL_ORDER_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.CONSULTING_DOCTOR;
import static jkt.hms.util.RequestConstants.CREATED_BY;
import static jkt.hms.util.RequestConstants.DEPARTMENR_WISE_SUMMARY;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DIAGNOSIS_NO;
import static jkt.hms.util.RequestConstants.DIAGNOSTIC_REGISTER_DIAGNOSIS_WISE;
import static jkt.hms.util.RequestConstants.DIAGNOSTIC_REGISTER_DOCTOR_WISE;
import static jkt.hms.util.RequestConstants.EMPLOYEE_ID;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;
import static jkt.hms.util.RequestConstants.INVESTIGATION_ID;
import static jkt.hms.util.RequestConstants.INVESTIGATION_ORDER_BOOKING;
import static jkt.hms.util.RequestConstants.INVESTIGATION_ORDER_BOOKING_FOR_UPDATE;
import static jkt.hms.util.RequestConstants.IPD_ORDER_BOOKING_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.LAB_DIAGNOSTIC_REGISTER_DAIGNOSIS_WISE;
import static jkt.hms.util.RequestConstants.LOGIN_NAME;
import static jkt.hms.util.RequestConstants.MAIN_CHARGECODE_ID;
import static jkt.hms.util.RequestConstants.MARITAL_STATUS_ID;
import static jkt.hms.util.RequestConstants.MESSAGE_FOR_SAMPLE;
import static jkt.hms.util.RequestConstants.MESSAGE_FOR_SAMPLE_LAB;
import static jkt.hms.util.RequestConstants.MESSAGE_SAMPLE_COLLECTION;
import static jkt.hms.util.RequestConstants.MSG_FOR_LAB;
import static jkt.hms.util.RequestConstants.MSG_ORDER_BOOKING;
import static jkt.hms.util.RequestConstants.OPD_INVESTIGATION_ORDER_BOOKING_FOR_UPDATE;
import static jkt.hms.util.RequestConstants.OP_ORDER_BOOKING_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.ORDER_BOOKING;
import static jkt.hms.util.RequestConstants.ORDER_BOOKING_ID;
import static jkt.hms.util.RequestConstants.ORDER_BOOKING_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.ORDER_NO;
import static jkt.hms.util.RequestConstants.ORDER_STATUS;
import static jkt.hms.util.RequestConstants.ORDER_STATUS_FOR_WARD_MANAGEMENT;
import static jkt.hms.util.RequestConstants.ORDER_STATUS_REPORT_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.PACKING_LIST;
import static jkt.hms.util.RequestConstants.PACKING_LIST_REPORT;
import static jkt.hms.util.RequestConstants.PATIENT_CONFIDENTIAL_DIAGNOSTIC_REGISTER;
import static jkt.hms.util.RequestConstants.PATIENT_DIAGNOSTIC_REGISTER;
import static jkt.hms.util.RequestConstants.PATIENT_TYPE;
import static jkt.hms.util.RequestConstants.PENDING_SAMPLE_COLLECTION;
import static jkt.hms.util.RequestConstants.PENDING_SAMPLE_VALIDATION;
import static jkt.hms.util.RequestConstants.PENDING_SAMPLE_VALIDATION_LAB;
import static jkt.hms.util.RequestConstants.PROVISIONAL_DIAG;
import static jkt.hms.util.RequestConstants.P_FIRST_NAME;
import static jkt.hms.util.RequestConstants.QUANTITY;
import static jkt.hms.util.RequestConstants.RANK_CATEGORY_ID;
import static jkt.hms.util.RequestConstants.RELATION_ID;
import static jkt.hms.util.RequestConstants.REMARKS;
import static jkt.hms.util.RequestConstants.RESPONSE_FOR_LAB_DIAG_NO;
import static jkt.hms.util.RequestConstants.RESPONSE_FOR_LAB_RESULT;
import static jkt.hms.util.RequestConstants.RESULT_ENTRY_REPORT_JSP;
import static jkt.hms.util.RequestConstants.RESULT_TYPE;
import static jkt.hms.util.RequestConstants.SAMPLE_ACCEPTANCE;
import static jkt.hms.util.RequestConstants.SAMPLE_ACCEPTANCE_LAB;
import static jkt.hms.util.RequestConstants.SAMPLE_COLLECTION;
import static jkt.hms.util.RequestConstants.SAMPLE_ID;
import static jkt.hms.util.RequestConstants.SECTION_ID;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.SERVICE_STATUS_ID;
import static jkt.hms.util.RequestConstants.SERVICE_TYPE_ID;
import static jkt.hms.util.RequestConstants.SEX_ID;
import static jkt.hms.util.RequestConstants.SUB_CHARGECODE_ID;
import static jkt.hms.util.RequestConstants.S_FIRST_NAME;
import static jkt.hms.util.RequestConstants.TEST_TYPE;
import static jkt.hms.util.RequestConstants.TOTAL_ORDER_BOOKED_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.TRADE_ID;
import static jkt.hms.util.RequestConstants.UNIT_ID;
import static jkt.hms.util.RequestConstants.UPDATE_ORDER_BOOKING;
import static jkt.hms.util.RequestConstants.VIEW_CONFIDENTIAL_TEST_DETAILS_REPORT;
import static jkt.hms.util.RequestConstants.VIEW_MULTIPLE_PARAMETER_STATUS;
import static jkt.hms.util.RequestConstants.VIEW_SENSITIVE_STATUS;
import static jkt.hms.util.RequestConstants.VIEW_SINGLE_PARAMETER_STATUS;
import static jkt.hms.util.RequestConstants.VIEW_TEMPLATE_STATUS;
import static jkt.hms.util.RequestConstants.VIEW_TEMPLATE_STATUS_FOR_LAB;
import static jkt.hms.util.RequestConstants.VIEW_TEST_DETAILS_FOR_CANCEL;
import static jkt.hms.util.RequestConstants.VIEW_TEST_DETAILS_FOR_CONFIDENTIAL_ORDERS;
import static jkt.hms.util.RequestConstants.VIEW_TEST_DETAILS_FOR_ORDER_NO;
import static jkt.hms.util.RequestConstants.VIEW_TEST_DETAILS_FOR_HIN_ID;
import static jkt.hms.util.RequestConstants.VIEW_TEST_DETAILS_REPORT_ORDER_STATUS;
import static jkt.hms.util.RequestConstants.VISIT_ID;
import static jkt.hms.util.RequestConstants.VISIT_NUMBER;
import static jkt.hms.util.RequestConstants.WARD_ID;
import static jkt.hms.util.RequestConstants.RANK_ID;
import static jkt.hms.util.RequestConstants.Empanelled;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import jkt.hms.lab.handler.LabHandlerService;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgOrderdt;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DgResultEntryDetail;
import jkt.hms.masters.business.DgResultEntryHeader;
import jkt.hms.masters.business.DgSampleCollectionDetails;
import jkt.hms.masters.business.DgSampleCollectionHeader;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class LabController extends MultiActionController {
	LabHandlerService labHandlerService = null;
	HttpSession session = null;
	String jsp = "";
	String title = "";
	String url = "";
	String url1 = "";
	String userName = null;
	String message = null;
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();

	// ------------------------Investigation
	// Requation------------------------------------
	
	public ModelAndView showOrderBookingJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String buttonFlag = "";
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		int inPatientId = Integer.parseInt(request.getParameter("parent"));
		String deptName = request.getParameter("deptName");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("inPatientId", inPatientId);
		map.put("deptId", deptId);

		if (request.getParameter("buttonFlag") != null) {
			buttonFlag = request.getParameter("buttonFlag");
			int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}

		map = labHandlerService.showOrderBookingJsp(map);
		String orderSeqNo = request.getParameter("orderSeqNo");
		orderSeqNo = labHandlerService.getOrderSeqForDisplay("ON");
		if (orderSeqNo != null) {
			map.put("orderSeqNo", orderSeqNo);
		}
		detailsMap = labHandlerService.getMainAndSubCharge();
		map.put("detailsMap", detailsMap);
		jsp = ORDER_BOOKING;
		jsp += ".jsp";
		title = "OrderBooking";
		map.put("deptName", deptName);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView showAllOrdersForInPatientJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String buttonFlag = "";
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		int inPatientId = Integer.parseInt(request.getParameter("parent"));
		String deptName = request.getParameter("deptName");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("inPatientId", inPatientId);
		map.put("deptId", deptId);

		if (request.getParameter("buttonFlag") != null) {
			buttonFlag = request.getParameter("buttonFlag");
			int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}

		map = labHandlerService.showOrderBookingJsp(map);
		String orderSeqNo = request.getParameter("orderSeqNo");
		orderSeqNo = labHandlerService.getOrderSeqForDisplay("ON");
		if (orderSeqNo != null) {
			map.put("orderSeqNo", orderSeqNo);
		}
		detailsMap = labHandlerService.getMainAndSubCharge();
		map.put("detailsMap", detailsMap);
		jsp = ALL_ORDER_BOOKING_FOR_INPATIENT_VIEW_JSP;
		jsp += ".jsp";
		title = "OrderBooking";
		map.put("deptName", deptName);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView getChargeCode(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		int subChargeCodeId = 0;
		int mainChargeCodeId = 0;
		String nameField = "";
		String autoHint = "";
		if (request.getParameter("requiredField") != null) {
			nameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(nameField) != null) {
			autoHint = (request.getParameter(nameField));
		}
		if (request.getParameter("subChargeCodeId") != null) {
			subChargeCodeId = Integer.parseInt(request
					.getParameter("subChargeCodeId"));
		}
		if (request.getParameter("mainChargeCodeId") != null) {
			mainChargeCodeId = Integer.parseInt(request
					.getParameter("mainChargeCodeId"));
		}
		parameterMap.put("subChargeCodeId", subChargeCodeId);
		parameterMap.put("mainChargeCodeId", mainChargeCodeId);
		parameterMap.put("autoHint", autoHint);

		map = labHandlerService.getChargeCode(parameterMap);
		String jsp = "";
		jsp = "responseForMainChargeCodeGrid";
		return new ModelAndView(jsp, "map", map);
	}

	public void fillItemsForChargeCode(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String chargeCode = "";
		Box box = HMSUtil.getBox(request);
		String responseChargeCode = "";
		List<DgMasInvestigation> chargeList = new ArrayList<DgMasInvestigation>();
		try {
			if (request.getParameter("chargeCode") != null) {
				chargeCode = request.getParameter("chargeCode");
			}
			responseChargeCode = chargeCode;
			StringTokenizer s1 = new StringTokenizer(chargeCode, "0");
			StringBuffer output_str1 = new StringBuffer();
			while (s1.hasMoreTokens()) {
				output_str1.append(s1.nextToken());
				if (s1.hasMoreTokens()) {
					output_str1.append("&");
				}
			}
			chargeCode = new String(output_str1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("chargeCode", chargeCode);

		map = labHandlerService.fillItemsForChargeCode(dataMap);
		if (map.get("chargeList") != null) {
			chargeList = (List) map.get("chargeList");
		}
		StringBuffer sb = new StringBuffer();
		/*
		 * try{ Thread.currentThread().sleep(20000); }catch(Exception
		 * exception){ exception.printStackTrace(); }
		 */
		sb.append("<items>");
		for (DgMasInvestigation masChargeCode : chargeList) {
			sb.append("<item>");
			sb.append("<chargeId>" + masChargeCode.getId() + "</chargeId>");
			sb.append("<chargeName>" + responseChargeCode + "</chargeName>");
			sb.append("<mainChargeId>"
					+ masChargeCode.getMainChargecode().getId()
					+ "</mainChargeId>");
			sb.append("<subChargeId>"
					+ masChargeCode.getSubChargecode().getId()
					+ "</subChargeId>");
			sb.append("</item>");
		}
		if (chargeList.size() == 0) {
			sb.append("<item>");
			sb.append("<chargeId>" + "NoMatch" + "</chargeId>");
			sb.append("<chargeName>" + "0" + "</chargeName>");
			sb.append("<mainChargeId>" + "0" + "</mainChargeId>");
			sb.append("<subChargeId>" + "0" + "</subChargeId>");
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
	public ModelAndView submitOrderBooking(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();

		HttpSession session = request.getSession();

		Box box = HMSUtil.getBox(request);
		int chargeMainIdFromRequest = 0;
		int noOfRecords = 0;
		int inpatientId = 0;
		int placedBy = 0;
		int pageNo = 1;
		int hinId = 0;
		int visitId = 0;
		int deptId = 0;
		String provisionalDiag = "";
		String buttonFlag = "";
		String clinicalNote = "";
		String orderSeqNo = "";
		String orderStatus = "";
		String createdBy = "";
		String testType = "";
		String hinNo = "";
		String visitNo = "";
		String date = "";
		String time = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTimeWithoutSc");
		List chargeList = new ArrayList();
		List qtyList = new ArrayList();
		List mainChargeList = new ArrayList();
		List subChargeList = new ArrayList();
		@SuppressWarnings("unused")
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		String deptYype = (String) session.getAttribute("deptType");
		if (request.getParameter(HIN_ID) != null) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter("dgOrderhdId") != null) {
			chargeMainIdFromRequest = Integer.parseInt(request
					.getParameter("dgOrderhdId"));
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}
		if (!request.getParameter(INPATIENT_ID).equals("0")) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
		}
		if (!request.getParameter(EMPLOYEE_ID).equals("0")) {
			placedBy = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		if (request.getParameter(TEST_TYPE) != null
				&& !(request.getParameter(TEST_TYPE).equals(""))) {
			testType = request.getParameter(TEST_TYPE);
		}
		if (request.getParameter(CLINICAL_NOTE) != null
				&& !(request.getParameter(CLINICAL_NOTE).equals(""))) {
			clinicalNote = request.getParameter(CLINICAL_NOTE);
		}
		if (request.getParameter(CREATED_BY) != null
				&& !(request.getParameter(CREATED_BY).equals(""))) {
			createdBy = request.getParameter(CREATED_BY);
		}
		if (request.getParameter(PROVISIONAL_DIAG) != null
				&& !(request.getParameter(PROVISIONAL_DIAG).equals(""))) {
			provisionalDiag = request.getParameter(PROVISIONAL_DIAG);
		}
		if (request.getParameter(ORDER_STATUS) != null
				&& !(request.getParameter(ORDER_STATUS).equals(""))) {
			orderStatus = request.getParameter(ORDER_STATUS);
		}
		if (request.getParameter("buttonFlag") != null) {
			buttonFlag = request.getParameter("buttonFlag");
		}
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
		}
		if (request.getParameter(ORDER_NO) != null) {
			orderSeqNo = request.getParameter(ORDER_NO);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			infoMap.put("userName", userName);
		}
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		DgOrderhd dgOrderhd = new DgOrderhd();
		if (pageNo == 1) {
			Patient patient = new Patient();
			patient.setId(hinId);
			dgOrderhd.setHin(patient);

			if (inpatientId != 0) {
				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				dgOrderhd.setInpatient(inpatient);
			}

			if (departmentId != 0) {
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				dgOrderhd.setDepartment(masDepartment);
			}
			if (visitId != 0) {
				Visit visit = new Visit();
				visit.setId(visitId);
				dgOrderhd.setVisit(visit);
			}
			if (hospitalId != 0) {
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				dgOrderhd.setHospital(masHospital);
			}
			if (placedBy != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(placedBy);
				dgOrderhd.setPrescribedBy(masEmployee);
			}

			dgOrderhd.setOrderNo(orderSeqNo);
			String temp = labHandlerService.generateOrderNumber(hospitalId);

			dgOrderhd.setProvisionalDiag(provisionalDiag);
			dgOrderhd.setTestType(testType);
			// dgOrderhd.setOrderStatus(orderStatus);
			dgOrderhd.setClinicalNote(clinicalNote);
			dgOrderhd.setOrderDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			dgOrderhd.setOrderTime(time);
			dgOrderhd.setCreatedby(createdBy);
			dgOrderhd.setCreatedon(HMSUtil
					.convertStringTypeDateToDateType(date));
			dgOrderhd.setLastChgTime(time);
			dgOrderhd.setLastChgBy(user);
			dgOrderhd.setPatientType("IP");
			dgOrderhd.setOrderStatus("C");
			// dgOrderhd.setLabOrderStatus("LP");
			dgOrderhd.setLabOrderStatus("LC");
			dgOrderhd.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			dgOrderhd.setLastChgTime(time);
			infoMap.put("dgOrderhd", dgOrderhd);
			infoMap.put("departmentId", departmentId);
			infoMap.put("hospitalId", hospitalId);
			infoMap.put("deptYype", deptYype);
			infoMap.put("hinId", hinId);
			infoMap.put("orderSeqNo", orderSeqNo);
		}
		try {

			// Vector quantity = box.getVector(QUANTITY);
			Vector charge_code_id = box.getVector(CHARGE_CODE_ID);
			Vector main_charge_id = box.getVector("mainCharge");
			Vector sub_charge_id = box.getVector("subCharge");
			String diagnosisNo = box.getString(DIAGNOSIS_NO);
			int counter = 0;

			for (int i = 0; i < charge_code_id.size(); i++) {
				// if (!charge_code_id.get(i).toString().equals(""))
				counter++;
			}
			noOfRecords = counter;
			for (int i = 0; i < noOfRecords; i++) {
				if (!charge_code_id.get(i).toString().equals("")) {
					chargeList.add(charge_code_id.get(i));
					mainChargeList.add(main_charge_id.get(i));
					subChargeList.add(sub_charge_id.get(i));
					// qtyList.add(quantity.get(i));
				}
			}
			if (infoMap.get("createdBy") != null) {
				createdBy = (String) infoMap.get("createdBy");
			}
			infoMap.put("chargeMainIdFromRequest", chargeMainIdFromRequest);
			infoMap.put("chargeList", chargeList);
			infoMap.put("qtyList", qtyList);
			infoMap.put("mainChargeList", mainChargeList);
			infoMap.put("subChargeList", subChargeList);
			infoMap.put("userId", userId);
			infoMap.put("createdBy", createdBy);

		} catch (Exception e) {
			e.printStackTrace();
		}
		infoMap.put("box", box);
		boolean success = false;
		String jsp = "";
		String message = "";
		int dgOrderhdId = 0;

		returnMap = labHandlerService
				.submitOrderBookingForInvestigation(infoMap);
		// //////////////////
		Integer dgOrderhdIdAftersave = (Integer) returnMap.get("dgOrderhdId");
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		infoMap.put("dgOrderhdIdAftersave", dgOrderhdIdAftersave);
		map = labHandlerService.submitSampleCollection(infoMap);
		// ///////////////////

		if (returnMap.get("success") != null) {
			success = (Boolean) returnMap.get("success");
		}
		if (returnMap.get("orderSeqNo") != null) {
			orderSeqNo = (String) returnMap.get("orderSeqNo");
		}
		if (returnMap.get("inpatientId") != null) {
			inpatientId = (Integer) returnMap.get("inpatientId");
		}
		map.put("inpatientId", inpatientId);
		if (success) {
			if (buttonFlag.equals("next")) {
				pageNo++;
				message = "Order Booking has been done Successfully !!Do you want to print ? ";
				map = labHandlerService
						.showOrderBookingForInvestigationJsp(visitId);
				detailsMap = labHandlerService.getMainAndSubCharge();
				map.put("detailsMap", detailsMap);
				map.put("pageNo", pageNo);
				if (returnMap.get("dgOrderhdId") != null) {
					dgOrderhdId = (Integer) returnMap.get("dgOrderhdId");
					map.put("dgOrderhdId", dgOrderhdId);
				}
				String includedJsp = ORDER_BOOKING + ".jsp";
				map.put("includedJsp", includedJsp);
				jsp = ORDER_BOOKING + ".jsp";
			} else {

				jsp = MSG_ORDER_BOOKING + ".jsp";
				pageNo++;
				message = "Order Booking has been done Successfully !!  Do you want to print ? ";
				map.put("deptType", deptYype);
				map.put("hinNo", hinNo);

			}
		} else {
			jsp = MSG_ORDER_BOOKING + ".jsp";
			message = " Try Again !!";
		}

		map.put("orderSeqNo", orderSeqNo);
		map.put("pageNo", pageNo);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// ----------------------OrderBooking For
	// Investigation----------------------------

	public ModelAndView showOpOrderBookingSearchJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		String jsp = OP_ORDER_BOOKING_SEARCH_JSP;
		jsp += ".jsp";
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getPatientNameForOrderBooking(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		String flag = "";
		List<Patient> patientList = new ArrayList<Patient>();
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			map.put("flag", flag);
		}
		patientList = labHandlerService.getPatientName(serviceNo);
		if (patientList.size() > 0) {
			map.put("patientList", patientList);
		}
		String jsp = "populatePatientName";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getVisitNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> visitNoList = new ArrayList<Visit>();
		int hinId = 0;
		if (request.getParameter(HIN_ID) != null) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		map.put("flag", "lab");
		visitNoList = labHandlerService.getVisitNo(hinId);
		String jsp = "lastVisitNo";
		map.put("visitNoList", visitNoList);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getPatientDetails(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		int visitNo = 0;
		int visitId = 0;
		String orderSeqNo = null;
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");

		if (request.getParameter(VISIT_NUMBER) != null) {
			visitNo = Integer.parseInt(request.getParameter(VISIT_NUMBER));
			map.put("visitNo", visitNo);
		}
		if (request.getParameter("visitId") != null) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
			map.put("visitId", visitId);
		}
		if (request.getParameter(ORDER_NO) != null) {
			orderSeqNo = (request.getParameter(ORDER_NO));
	
		}
		if (visitNo != 0) {
			map = labHandlerService
					.showOrderBookingForInvestigationJsp(visitNo);
		/*	if(orderSeqNo==null)
			orderSeqNo = labHandlerService.generateOrderNumber();
			if (orderSeqNo != null) {
				map.put("orderSeqNo", orderSeqNo);
			}*/
		}
		detailsMap = labHandlerService.getMainAndSubCharge();
		String includedJsp = INVESTIGATION_ORDER_BOOKING + ".jsp";

		jsp = OP_ORDER_BOOKING_SEARCH_JSP + ".jsp";
		map.put("deptName", deptName);
		map.put("includedJsp", includedJsp);
		map.put("detailsMap", detailsMap);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	// //////////////////////////////////////// Oder Booking For IPD
	public ModelAndView showIPDOrderBookingSearchJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		String deptName = "";
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");

		map = labHandlerService.getDetailsForIPDSearch();
		String jsp = IPD_ORDER_BOOKING_SEARCH_JSP;
		jsp += ".jsp";
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getPatientNameForIPDOrderBooking(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		String flag = "";
		List<Patient> patientList = new ArrayList<Patient>();
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			map.put("flag", flag);
		}
		patientList = labHandlerService.getIPDPatientName(serviceNo);
		if (patientList.size() > 0) {
			map.put("patientList", patientList);
		}
		String jsp = "populateIPDPatientName";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getInPatientId(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> visitNoList = new ArrayList<Visit>();
		int hinId = 0;
		if (request.getParameter(HIN_ID) != null) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		map.put("flag", "lab");
		visitNoList = labHandlerService.getVisitNo(hinId);
		String jsp = "lastVisitNo";
		map.put("visitNoList", visitNoList);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView searchPatientDetailsForIPD(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();

		HttpSession session = request.getSession();

		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		String hinNo = "";
		String adNo = "";
		String serviceNo = "";
		String jsp = "";
		String title = "";
		int wardId = 0;
		int inpatientId = 0;

		try {

			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(WARD_ID) != null
					&& !(request.getParameter(WARD_ID).equals("0"))) {
				wardId = Integer.parseInt(request.getParameter(WARD_ID));
				mapForDs.put("wardId", wardId);
			}
			if (request.getParameter("inpatientId") != null) {
				inpatientId = Integer.parseInt(request
						.getParameter("inpatientId"));
				mapForDs.put("inpatientId", inpatientId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		mapForDs.put("deptId", deptId);

		patientMap = labHandlerService
				.getPatientDetailsForIPDOrderBooking(mapForDs);

		if (patientMap.get("inpatientList") != null) {
			inpatientList = (List<Inpatient>) patientMap.get("inpatientList");
		}

		if ((!adNo.equals("") && inpatientList.size() > 0) || inpatientId != 0) {

			map.put("inPatientId", inpatientId);
			map.put("deptId", deptId);
			map.put("A&DNo", adNo);

			map = labHandlerService.showOrderBookingJsp(map);

			String orderSeqNo = request.getParameter("orderSeqNo");
			orderSeqNo = labHandlerService.getOrderSeqForDisplay("ON");
			if (orderSeqNo != null) {
				map.put("orderSeqNo", orderSeqNo);
			}
			detailsMap = labHandlerService.getMainAndSubCharge();
			map.put("detailsMap", detailsMap);
			jsp = ORDER_BOOKING;
			jsp += ".jsp";
			title = "OrderBooking";

			// /////////////////
		} else {
			map = labHandlerService.getDetailsForIPDSearch();
			jsp = IPD_ORDER_BOOKING_SEARCH_JSP + ".jsp";
		}

		map.put("deptName", patientMap.get("deptName"));
		map.put("patientMap", patientMap);
		map.put("title", title);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// /////////////////////////////////////////// End Order Booking For IPD

	public ModelAndView getPatientDetailsForOrderUpdate(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> detailsMapForOrder = new HashMap<String, Object>();
		Map<String, Object> detailsMapForMainAndSubCharge = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		DgOrderhd dgOrderhd = new DgOrderhd();
		String deptName = "";
		int visitNo = 0;
		int visitId = 0;
		int orderId = 0;
		int hinId = 0;
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");

		if (request.getParameter(VISIT_NUMBER) != null) {
			visitNo = Integer.parseInt(request.getParameter(VISIT_NUMBER));
			map.put("visitNo", visitNo);
		}
		if (request.getParameter(VISIT_ID) != null) {
			visitId = Integer.parseInt(request.getParameter(VISIT_ID));
			map.put("visitId", visitId);
		}
		if (request.getParameter("orderId") != null) {
			orderId = Integer.parseInt(request.getParameter("orderId"));
			map.put("orderId", orderId);
		}
		detailsMapForOrder = labHandlerService.getOrderDetails(map);

		if (detailsMapForOrder.get("dgOrderhd") != null) {
			dgOrderhd = (DgOrderhd) detailsMapForOrder.get("dgOrderhd");
			map.put("dgOrderhd", dgOrderhd);
			hinId = dgOrderhd.getHin().getId();
			if (detailsMapForOrder.get("visitNo") != null) {
				visitNo = (Integer) detailsMapForOrder.get("visitNo");
				detailsMap = labHandlerService.getPatientDetail(visitNo);
				map.put("detailsMap", detailsMap);
				map.put("detailsMapForOrder", detailsMapForOrder);

			}

		}
		if (visitNo != 0) {
			map.putAll(labHandlerService
					.showOrderBookingForInvestigationJsp(visitNo));
			String orderSeqNo = "";
			orderSeqNo = labHandlerService.getOrderSeqForDisplay("ON");
			if (orderSeqNo != null) {
				map.put("orderSeqNo", orderSeqNo);
			}
		}
		detailsMapForMainAndSubCharge = labHandlerService.getMainAndSubCharge();
		String includedJsp = "investigationOrderUpdate" + ".jsp";

		jsp = "opOrderUpdateSearch" + ".jsp";
		map.put("deptName", deptName);
		map.put("includedJsp", includedJsp);
		map.put("detailsMapForMainAndSubCharge", detailsMapForMainAndSubCharge);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	// ///////////////////////////////////////////// Method For QC
	// ////////////////////////////
	public ModelAndView getPatientDetailsForQC(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "1111";
		List<Patient> patientList = new ArrayList<Patient>();
		List<Visit> visitNoList = new ArrayList<Visit>();
		HttpSession session = request.getSession();

		patientList = labHandlerService.getPatientName(serviceNo);
		if (patientList.size() > 0) {
			map.put("patientList", patientList);
		}
		int hinId = 0;
		for (Iterator iterator = patientList.iterator(); iterator.hasNext();) {
			Patient patient = (Patient) iterator.next();
			hinId = patient.getId();
		}

		visitNoList = labHandlerService.getVisitNo(hinId);

		int previousVisitNo = 0;
		String maxSequenceNo = "";

		ArrayList visitNoSequenceList = new ArrayList();
		ArrayList visitIdSequenceList = new ArrayList();
		for (Visit visit : visitNoList) {
			previousVisitNo = visit.getVisitNo();
			visitNoSequenceList.add(previousVisitNo);
			visitIdSequenceList.add(visit.getId());
		}
		int visitId = 0;
		if (visitNoSequenceList.size() > 0) {
			maxSequenceNo = Collections.max(visitNoSequenceList).toString();
			visitId = (Integer) Collections.max(visitIdSequenceList);
		}

		String deptName = "";
		int visitNo = 0;

		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");

		visitNo = visitId;
		map.put("visitNo", visitNo);

		map.put("visitId", visitId);

		if (visitNo != 0) {
			map = labHandlerService
					.showOrderBookingForInvestigationJsp(visitNo);
			String orderSeqNo = "";
			orderSeqNo = labHandlerService.getOrderSeqForDisplay("ON");
			if (orderSeqNo != null) {
				map.put("orderSeqNo", orderSeqNo);
			}
		}

		detailsMap = labHandlerService.getMainAndSubCharge();
		String includedJsp = INVESTIGATION_ORDER_BOOKING + ".jsp";

		jsp = OP_ORDER_BOOKING_SEARCH_JSP + ".jsp";
		map.put("deptName", deptName);
		map.put("includedJsp", includedJsp);
		map.put("detailsMap", detailsMap);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	// ///////////////////////////////////////////////End Method For QC
	// ////////////////////////
	@SuppressWarnings("unchecked")
	public ModelAndView submitOrderBookingForInvestigation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int chargeMainIdFromRequest = 0;
		int noOfRecords = 0;
		int inpatientId = 0;
		int placedBy = 0;
		int pageNo = 1;
		int hinId = 0;
		int visitId = 0;
		String provisionalDiag = "";
		String buttonFlag = "";
		String clinicalNote = "";
		String orderSeqNo = "";
		String orderStatus = "";
		String createdBy = "";
		String testType = "";
		String hinNo = "";
		String visitNo = "";
		String date = "";
		String time = "";
		String serviceNo="";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTimeWithoutSc");
		List chargeList = new ArrayList();
		List qtyList = new ArrayList();
		List mainChargeList = new ArrayList();
		List subChargeList = new ArrayList();
		@SuppressWarnings("unused")
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		if (request.getParameter(HIN_ID) != null) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter("dgOrderhdId") != null) {
			chargeMainIdFromRequest = Integer.parseInt(request
					.getParameter("dgOrderhdId"));
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}
		if (request.getParameter(VISIT_NUMBER) != null) {
			visitNo = request.getParameter(VISIT_NUMBER);
		}
		if (request.getParameter(VISIT_ID) != null) {
			visitId = Integer.parseInt(request.getParameter(VISIT_ID));
		}
		if (request.getParameter("serviceNo") != null) {
			serviceNo = request.getParameter("serviceNo");
		}
		if (!request.getParameter(INPATIENT_ID).equals("")) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
		}
		if (!request.getParameter(EMPLOYEE_ID).equals("0")) {
			placedBy = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		if (request.getParameter(TEST_TYPE) != null
				&& !(request.getParameter(TEST_TYPE).equals(""))) {
			testType = request.getParameter(TEST_TYPE);
		}
		if (request.getParameter(CLINICAL_NOTE) != null
				&& !(request.getParameter(CLINICAL_NOTE).equals(""))) {
			clinicalNote = request.getParameter(CLINICAL_NOTE);
		}
		if (request.getParameter(CREATED_BY) != null
				&& !(request.getParameter(CREATED_BY).equals(""))) {
			createdBy = request.getParameter(CREATED_BY);
		}
		if (request.getParameter(PROVISIONAL_DIAG) != null
				&& !(request.getParameter(PROVISIONAL_DIAG).equals(""))) {
			provisionalDiag = request.getParameter(PROVISIONAL_DIAG);
		}
		if (request.getParameter(ORDER_STATUS) != null
				&& !(request.getParameter(ORDER_STATUS).equals(""))) {
			orderStatus = request.getParameter(ORDER_STATUS);
		}
		if (request.getParameter("buttonFlag") != null) {
			buttonFlag = request.getParameter("buttonFlag");
		}
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
		}
		if (request.getParameter(ORDER_NO) != null) {
			orderSeqNo = request.getParameter(ORDER_NO);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			infoMap.put("userName", userName);
		}
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		DgOrderhd dgOrderhd = new DgOrderhd();
		if (pageNo == 1) {
			Patient patient = new Patient();
			patient.setId(hinId);
			dgOrderhd.setHin(patient);

			if (inpatientId != 0) {
				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				dgOrderhd.setInpatient(inpatient);
			}

			if (departmentId != 0) {
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				dgOrderhd.setDepartment(masDepartment);
			}
			if (visitId != 0) {
				Visit visit = new Visit();
				visit.setId(visitId);
				dgOrderhd.setVisit(visit);
			}
			if (hospitalId != 0) {
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				dgOrderhd.setHospital(masHospital);
			}
			if (placedBy != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(placedBy);
				dgOrderhd.setPrescribedBy(masEmployee);
			}
			String temp = labHandlerService.generateOrderNumber(hospitalId);
			orderSeqNo=temp;
			dgOrderhd.setOrderNo(orderSeqNo);
			

			dgOrderhd.setProvisionalDiag(provisionalDiag);
			dgOrderhd.setTestType(testType);
			dgOrderhd.setOrderStatus(orderStatus);
			dgOrderhd.setClinicalNote(clinicalNote);
			dgOrderhd.setOrderDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			dgOrderhd.setOrderTime(time);
			dgOrderhd.setCreatedby(createdBy);
			dgOrderhd.setCreatedon(HMSUtil
					.convertStringTypeDateToDateType(date));
			dgOrderhd.setLastChgTime(time);
			dgOrderhd.setLastChgBy(user);
			dgOrderhd.setPatientType("OP");
			dgOrderhd.setTestType("Regular");
			dgOrderhd.setLabOrderStatus("P");
			dgOrderhd.setOrderStatus("P");
			
			dgOrderhd.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			dgOrderhd.setLastChgTime(time);
			infoMap.put("dgOrderhd", dgOrderhd);
			infoMap.put("departmentId", departmentId);
			infoMap.put("hospitalId", hospitalId);
			infoMap.put("hinId", hinId);
			infoMap.put("orderSeqNo", orderSeqNo);
		}
		try {

			Vector quantity = box.getVector(QUANTITY);
			Vector charge_code_id = box.getVector(CHARGE_CODE_ID);
			Vector main_charge_id = box.getVector("mainCharge");
			Vector sub_charge_id = box.getVector("subCharge");
			String diagnosisNo = box.getString(DIAGNOSIS_NO);
			int counter = 0;

			for (int i = 0; i < charge_code_id.size(); i++) {
				// if (!charge_code_id.get(i).toString().equals(""))
				counter++;
			}
			noOfRecords = counter;
			for (int i = 0; i < noOfRecords; i++) {
				if (!charge_code_id.get(i).toString().equals("")) {
					chargeList.add(charge_code_id.get(i));
					mainChargeList.add(main_charge_id.get(i));
					subChargeList.add(sub_charge_id.get(i));
					// qtyList.add(quantity.get(i));
				}
			}
			if (infoMap.get("createdBy") != null) {
				createdBy = (String) infoMap.get("createdBy");
			}
			infoMap.put("chargeMainIdFromRequest", chargeMainIdFromRequest);
			infoMap.put("chargeList", chargeList);
			infoMap.put("qtyList", qtyList);
			infoMap.put("mainChargeList", mainChargeList);
			infoMap.put("subChargeList", subChargeList);
			infoMap.put("userId", userId);
			infoMap.put("createdBy", createdBy);
		} catch (Exception e) {
			e.printStackTrace();
		}
		infoMap.put("box", box);
		boolean success = false;
		String jsp = "";
		String message = "";
		int dgOrderhdId = 0;

		returnMap = labHandlerService
				.submitOrderBookingForInvestigation(infoMap);

		// /////////////////////////////////////////
		Integer dgOrderhdIdAftersave = (Integer) returnMap.get("dgOrderhdId");
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		infoMap.put("dgOrderhdIdAftersave", dgOrderhdIdAftersave);
	//	map = labHandlerService.submitSampleCollection(infoMap);
		// /////////////////////////////////////////
		if (returnMap.get("success") != null) {
			success = (Boolean) returnMap.get("success");
		}
		if (returnMap.get("orderSeqNo") != null) {
			orderSeqNo = (String) returnMap.get("orderSeqNo");
		}
		if (success) {
			if (buttonFlag.equals("next")) {
				pageNo++;
				message = "Order Booking has been done Successfully !!Do you want to print ? ";
				map = labHandlerService
						.showOrderBookingForInvestigationJsp(visitId);
				detailsMap = labHandlerService.getMainAndSubCharge();
				map.put("detailsMap", detailsMap);
				map.put("pageNo", pageNo);
				if (returnMap.get("dgOrderhdId") != null) {
					dgOrderhdId = (Integer) returnMap.get("dgOrderhdId");
					map.put("dgOrderhdId", dgOrderhdId);
				}
				String includedJsp = INVESTIGATION_ORDER_BOOKING + ".jsp";
				map.put("includedJsp", includedJsp);
				jsp = OP_ORDER_BOOKING_SEARCH_JSP + ".jsp";
			} else {
				jsp = MSG_FOR_LAB + ".jsp";
				pageNo++;
				message = "Order Booking has been done Successfully !!  Do you want to print ? ";
				map.put("visitNo", visitNo);
				map.put("hinNo", hinNo);
				map.put("serviceNo", serviceNo);
			}
		} else {
			jsp = MSG_FOR_LAB + ".jsp";
			message = " Try Again !!";
		}
		map.put("orderSeqNo", orderSeqNo);
		map.put("pageNo", pageNo);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView updateOrderBookingForInvestigation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> detailsMapForOrder = new HashMap<String, Object>();

		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int chargeMainIdFromRequest = 0;
		int noOfRecords = 0;
		int inpatientId = 0;
		int placedBy = 0;
		int pageNo = 1;
		int hinId = 0;
		int visitId = 0;
		String provisionalDiag = "";
		String buttonFlag = "";
		String clinicalNote = "";
		String orderSeqNo = "";
		String orderStatus = "";
		String createdBy = "";
		String testType = "";
		String hinNo = "";
		String visitNo = "";
		String date = "";
		String time = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTimeWithoutSc");
		List chargeList = new ArrayList();
		List qtyList = new ArrayList();
		List mainChargeList = new ArrayList();
		List subChargeList = new ArrayList();
		@SuppressWarnings("unused")
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Map<String, Object> creationDetailsMap = new HashMap<String, Object>();

		if (request.getParameter(HIN_ID) != null) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter("dgOrderhdId") != null) {
			chargeMainIdFromRequest = Integer.parseInt(request
					.getParameter("dgOrderhdId"));
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}
		if (request.getParameter(VISIT_NUMBER) != null) {
			visitNo = request.getParameter(VISIT_NUMBER);
		}
		if (request.getParameter(VISIT_ID) != null) {
			visitId = Integer.parseInt(request.getParameter(VISIT_ID));
		}
		if (!request.getParameter(INPATIENT_ID).equals("")) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
		}
		if (!request.getParameter(EMPLOYEE_ID).equals("0")) {

			placedBy = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		if (request.getParameter(TEST_TYPE) != null
				&& !(request.getParameter(TEST_TYPE).equals(""))) {
			testType = request.getParameter(TEST_TYPE);
		}
		if (request.getParameter(CLINICAL_NOTE) != null
				&& !(request.getParameter(CLINICAL_NOTE).equals(""))) {
			clinicalNote = request.getParameter(CLINICAL_NOTE);
		}
		if (request.getParameter(CREATED_BY) != null
				&& !(request.getParameter(CREATED_BY).equals(""))) {
			createdBy = request.getParameter(CREATED_BY);
			creationDetailsMap.put("createdBy", createdBy);
		}
		if (request.getParameter(PROVISIONAL_DIAG) != null
				&& !(request.getParameter(PROVISIONAL_DIAG).equals(""))) {
			provisionalDiag = request.getParameter(PROVISIONAL_DIAG);
		}

		if (request.getParameter("buttonFlag") != null) {
			buttonFlag = request.getParameter("buttonFlag");
		}
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
		}
		if (request.getParameter(ORDER_NO) != null) {
			orderSeqNo = request.getParameter(ORDER_NO);
		}

		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			creationDetailsMap.put("userName", userName);
		}
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");

		}
		DgOrderhd dgOrderhd = new DgOrderhd();
		// delete all the data from the DgorderDt and DgOrderHd corresponding to
		// orderNo
		if (session.getAttribute("dgOrderhd") != null) {
			dgOrderhd = (DgOrderhd) session.getAttribute("dgOrderhd");

		}

		if (session.getAttribute("dgOrderhd") != null) {
			creationDetailsMap.put("originalDgOrderhd", (DgOrderhd) session
					.getAttribute("dgOrderhd"));
		}
		session.removeAttribute("dgOrderhd");
		creationDetailsMap.put("userName", userName);
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();

		if (pageNo == 1) {

			if (departmentId != 0) {
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				dgOrderhd.setDepartment(masDepartment);
			}

			if (placedBy != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(placedBy);
				dgOrderhd.setPrescribedBy(masEmployee);

			}

			dgOrderhd.setProvisionalDiag(provisionalDiag);
			dgOrderhd.setTestType(testType);

			dgOrderhd.setClinicalNote(clinicalNote);

			dgOrderhd.setLastChgTime(time);
			dgOrderhd.setLastChgBy(user);

			dgOrderhd.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));

			creationDetailsMap.put("dgOrderhd", dgOrderhd);
			creationDetailsMap.put("departmentId", departmentId);
			creationDetailsMap.put("hospitalId", hospitalId);
			creationDetailsMap.put("hinId", hinId);

		}
		try {

			Vector quantity = box.getVector(QUANTITY);
			Vector charge_code_id = box.getVector(CHARGE_CODE_ID);
			Vector main_charge_id = box.getVector("mainCharge");
			Vector sub_charge_id = box.getVector("subCharge");
			String diagnosisNo = box.getString(DIAGNOSIS_NO);
			int counter = 0;

			for (int i = 0; i < charge_code_id.size(); i++) {
				if (!charge_code_id.get(i).toString().equals(""))
					counter++;
			}
			noOfRecords = counter;
			for (int i = 0; i < noOfRecords; i++) {
				chargeList.add(charge_code_id.get(i));
				mainChargeList.add(main_charge_id.get(i));
				subChargeList.add(sub_charge_id.get(i));
				qtyList.add(quantity.get(i));
			}

			creationDetailsMap.put("chargeMainIdFromRequest",
					chargeMainIdFromRequest);
			creationDetailsMap.put("chargeList", chargeList);
			creationDetailsMap.put("qtyList", qtyList);
			creationDetailsMap.put("mainChargeList", mainChargeList);
			creationDetailsMap.put("subChargeList", subChargeList);
			creationDetailsMap.put("userId", userId);
			creationDetailsMap.put("createdBy", createdBy);
		} catch (Exception e) {
			e.printStackTrace();
		}
		creationDetailsMap.put("box", box);
		boolean success = false;
		String jsp = "";
		String message = "";
		int dgOrderhdId = 0;
		creationDetailsMap.put("newDgOrderhd", dgOrderhd);
		returnMap = labHandlerService.updateOrderDetails(creationDetailsMap);

		if (returnMap.get("success") != null) {
			success = (Boolean) returnMap.get("success");
		}

		if (success) {
			if (buttonFlag.equals("next")) {
				pageNo++;
				infoMap.put("orderId", dgOrderhd.getId());
				message = "Order Updation has been done Successfully !!Do you want to print ? ";
				detailsMapForOrder = labHandlerService.getOrderDetails(infoMap);
				detailsMap = labHandlerService.getMainAndSubCharge();
				map.put("detailsMap", detailsMap);
				map.put("pageNo", pageNo);
				if (returnMap.get("dgOrderhdId") != null) {
					dgOrderhdId = (Integer) returnMap.get("dgOrderhdId");
					map.put("dgOrderhdId", dgOrderhdId);
				}
				String includedJsp = INVESTIGATION_ORDER_BOOKING + ".jsp";
				map.put("includedJsp", includedJsp);
				jsp = OP_ORDER_BOOKING_SEARCH_JSP + ".jsp";
			} else {
				jsp = MSG_FOR_LAB + ".jsp";
				pageNo++;
				message = "Order Update has been done Successfully !!  Do you want to print ? ";

				map
						.put("visitNo", dgOrderhd.getVisit().getVisitNo()
								.toString());
				map.put("hinNo", dgOrderhd.getHin().getHinNo());
			}
		} else {
			jsp = MSG_FOR_LAB + ".jsp";
			message = " Try Again !!";
		}
		map.put("orderSeqNo", orderSeqNo);
		map.put("pageNo", pageNo);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printOrderBooking(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String query = "";

		try {

			if (request.getParameter("orderNo") != null
					&& (!request.getParameter("orderNo").equals(""))) {
				query = "where dg_orderhd.order_no = '"
						+ request.getParameter("orderNo") + "' ";
			}
			if (request.getParameter("visitNo") != null
					&& (!request.getParameter("visitNo").equals(""))) {
				query = query + "AND visit.visit_no = '"
						+ request.getParameter("visitNo") + "' ";
			}
			if (request.getParameter("hinNo") != null
					&& (!request.getParameter("hinNo").equals(""))) {
				query = query + "AND patient.hin_no = '"
						+ request.getParameter("hinNo") + "' ";
			}
			if (request.getParameter("inpatientId") != null
					&& (!request.getParameter("inpatientId").equals("0"))) {
				query = query + "AND inpatient.inpatient_id = "
						+ request.getParameter("inpatientId");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// detailsMap = labHandlerService.getSubCharge();
		detailsMap = labHandlerService.getConnectionForReport();
		parameters.put("QUERY", query);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		try {
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("dgInvestigationRequired"),
						parameters, (Connection) detailsMap.get("con"));

			} catch (JRException e) {

				e.printStackTrace();
			}
			response.setHeader("Content-Disposition", "inline; filename="
					+ "dgInvestigationRequired" + ".pdf");
			response.setContentType("application/pdf");
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

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		return null;
	}// ------------------------------Pending For Sample
		// Collection--------------------------------

	public ModelAndView printOrderBookingIPD(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String query = "";

		try {

			if (request.getParameter("orderNo") != null
					&& (!request.getParameter("orderNo").equals(""))) {
				query = "where dg_orderhd.`order_no` = '"
						+ request.getParameter("orderNo") + "' ";
			}
			if (request.getParameter("visitNo") != null
					&& (!request.getParameter("visitNo").equals(""))) {
				query = query + "AND visit.`visit_no` = '"
						+ request.getParameter("visitNo") + "' ";
			}
			if (request.getParameter("hinNo") != null
					&& (!request.getParameter("hinNo").equals(""))) {
				query = query + "AND patient.`hin_no` = '"
						+ request.getParameter("hinNo") + "' ";
			}
			if (request.getParameter("inpatientId") != null
					&& (!request.getParameter("inpatientId").equals("0"))) {
				query = query + "AND inpatient.`inpatient_id` = "
						+ request.getParameter("inpatientId");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// detailsMap = labHandlerService.getSubCharge();
		detailsMap = labHandlerService.getConnectionForReport();
		parameters.put("QUERY", query);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		/*
		 * try {
		 * 
		 * HMSUtil.generateReport("dgInvestigationRequiredIPD", parameters,
		 * (Connection) detailsMap.get("con"), response, getServletContext()); }
		 * catch (IllegalStateException e) { e.printStackTrace(); }
		 */
		try {
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("dgInvestigationRequiredIPD"),
						parameters, (Connection) detailsMap.get("con"));

			} catch (JRException e) {

				e.printStackTrace();
			}
			response.setHeader("Content-Disposition", "inline; filename="
					+ "dgInvestigationRequiredIPD" + ".pdf");
			response.setContentType("application/pdf");
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

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		// return new ModelAndView("index", "map", map);
		return null;
	}

	public ModelAndView showOrderBookingReportJsp(HttpServletRequest request,
			HttpServletResponse response) {

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map = labHandlerService.getDetailsForSearch(map);
		jsp = ORDER_BOOKING_SEARCH_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchOrdersDetail(HttpServletRequest request,
			HttpServletResponse response) {
		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> orderDetailMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientDiagnosisMap = new HashMap<String, Object>();

		String hinNo = "";
		int wardId = 0;
		String adNo = "";
		int inpatientId = 0;
		String serviceNo = "";

		try {

			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(WARD_ID) != null
					&& !(request.getParameter(WARD_ID).equals("0"))) {
				wardId = Integer.parseInt(request.getParameter(WARD_ID));
				mapForDs.put("wardId", wardId);
			}
			if (request.getParameter("inpatientId") != null) {
				inpatientId = Integer.parseInt(request
						.getParameter("inpatientId"));
				mapForDs.put("inpatientId", inpatientId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		orderDetailMap = labHandlerService
				.getAllOrderForOrderBookingReport(mapForDs);
		map = labHandlerService.getDetailsForSearch(mapForDs);
		jsp = ORDER_BOOKING_SEARCH_JSP + ".jsp";

		map.put("orderDetailMap", orderDetailMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printOrderBookingReportIpdOpd(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> mapForReportQuery = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		String query = "";
		String orderNoIdForReport = "";
		DgOrderhd dgOrderhd = new DgOrderhd();
		if (request.getParameter("orderNoIdForReport") != null
				&& !request.getParameter("orderNoIdForReport").equals("")) {
			orderNoIdForReport = request.getParameter("orderNoIdForReport");

			mapForDs.put("orderId", Integer.parseInt(orderNoIdForReport));
		}
		try {
			mapForReportQuery = labHandlerService.getOrderDetails(mapForDs);
			if (mapForReportQuery.get("dgOrderhd") != null) {
				dgOrderhd = (DgOrderhd) mapForReportQuery.get("dgOrderhd");
				if (dgOrderhd.getOrderNo() != null
						&& (!dgOrderhd.getOrderNo().equals(""))) {
					query = "where dg_orderhd.`order_no` = '"
							+ dgOrderhd.getOrderNo() + "' ";
				}
				if (dgOrderhd.getHin().getHinNo() != null
						&& (!dgOrderhd.getHin().getHinNo().equals(""))) {
					query = query + "AND patient.`hin_no` = '"
							+ dgOrderhd.getHin().getHinNo() + "' ";
				}
				if (dgOrderhd.getPatientType().equalsIgnoreCase("OP")) {
					if (dgOrderhd.getVisit().getVisitNo() != null
							&& (!dgOrderhd.getVisit().getVisitNo().equals(""))) {
						query = query + "AND visit.`visit_no` = '"
								+ dgOrderhd.getVisit().getVisitNo() + "' ";
					}

				} else {
					if (dgOrderhd.getInpatient().getId() != null
							&& (!dgOrderhd.getInpatient().getId().equals("0"))) {
						query = query + "AND inpatient.`inpatient_id` = "
								+ dgOrderhd.getInpatient().getId();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// detailsMap = labHandlerService.getSubCharge();
		detailsMap = labHandlerService.getConnectionForReport();
		parameters.put("QUERY", query);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		try {
			if (dgOrderhd.getPatientType().equalsIgnoreCase("OP")) {
				HMSUtil.generateReport("dgInvestigationRequired", parameters,
						(Connection) detailsMap.get("con"), response,
						getServletContext());
			} else {
				HMSUtil.generateReport("dgInvestigationRequiredIPD",
						parameters, (Connection) detailsMap.get("con"),
						response, getServletContext());
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	// ------------------------------Pending For Sample
	// Collection--------------------------------

	public ModelAndView showPendingSampleCollectionJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		detailsMap.put("deptId",  (Integer) session.getAttribute("deptId"));
		//detailsMap = labHandlerService.getDetailsForSearch(detailsMap);
		mapForDs.put("deptId",  (Integer) session.getAttribute("deptId"));
		mapForDs.put("hospitalId", (Integer) session.getAttribute("hospitalId"));
		mapForDs.put("requestFromMethod", "showPendingSampleCollectionJsp");
		// patientMap = labHandlerService.getSampleCollectionGrid(mapForDs);

		jsp = PENDING_SAMPLE_COLLECTION + ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatient(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = null;
		Date toDate = null;
		String serPersonFName = "";
		String patientFName = "";
		String orderStatus = "";
		String serviceNo = "";
		String hinNo = "";
		String adNo = "";
		String flag = "";
		String pType = "";
		int chargeCodeId = 0;
		int departmentId = 0;
		int inpatientId = 0;
		int subGroupId = 0;
		int sampleId = 0;
		int hinId = 0;
		String deptName = "";
		String deptType1="";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();
		
		detailsMap.put("deptId",  (Integer) session.getAttribute("deptId"));

		try {

			if (session.getAttribute("deptName") != null)
				deptName = (String) session.getAttribute("deptName");
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				mapForDs.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				mapForDs.put("toDate", toDate);
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				pType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("pType", pType);
			}
			
			
			if (request.getParameter("deptType1") != null
					&& !(request.getParameter("deptType1").equals(""))) {
				deptType1 = request.getParameter("deptType1");
				mapForDs.put("deptType1", deptType1);
			}
			
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));
				mapForDs.put("chargeCodeId", chargeCodeId);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subGroupId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subGroupId", subGroupId);
			}
			if (request.getParameter(SAMPLE_ID) != null
					&& !(request.getParameter(SAMPLE_ID).equals("0"))) {
				sampleId = Integer.parseInt(request.getParameter(SAMPLE_ID));
				mapForDs.put("sampleId", sampleId);
			}
			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				/*departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));*/
				mapForDs.put("departmentId", request.getParameter(DEPARTMENT_ID));
			}
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(ORDER_STATUS) != null
					&& !(request.getParameter(ORDER_STATUS).equals("0"))) {
				orderStatus = request.getParameter(ORDER_STATUS);
				mapForDs.put("orderStatus", orderStatus);
			}
			int orderId = 0;
			if (request.getParameter(ORDER_BOOKING_ID) != null
					&& !(request.getParameter(ORDER_BOOKING_ID).equals("0"))) {
				orderId = new Integer(request.getParameter(ORDER_BOOKING_ID));
				mapForDs.put("orderId", orderId);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		mapForDs.put("hospitalId", (Integer)session.getAttribute("hospitalId"));
		mapForDs.put("requestFromMethod", "searchPatient");
		patientMap = labHandlerService.getPatientDetails(mapForDs);
		String diagSeqNo = "";
		String jsp = "";
		List<DgOrderhd> patientList = new ArrayList<DgOrderhd>();
		if (patientMap.get("patientDetailList") != null) 
		{
			patientList = (List<DgOrderhd>) patientMap.get("patientDetailList");
		}
		
		boolean completedCollectionFlag=false;
		if (patientMap.get("completedCollectionFlag") != null) 
		{
			completedCollectionFlag = (Boolean) patientMap.get("completedCollectionFlag");
		}
		
		
		map = labHandlerService.getSampleCollectionDetails(mapForDs);
		
		if (map != null && map.get("dgOrderhdList") != null) {
			//diagSeqNo = labHandlerService.generateDiagNumber();
			diagSeqNo=(String)map.get("diagSeqNo");
			if(diagSeqNo!=null){
			map.put("diagSeqNo", diagSeqNo);
			}
						map.put("flag", flag);
			jsp = SAMPLE_COLLECTION + ".jsp";
		} else {
			mapForDs.put("deptId",  (Integer) session.getAttribute("deptId"));
			detailsMap = labHandlerService.getDetailsForSearch(mapForDs);
			if(flag.equalsIgnoreCase("RADIO")){
				jsp = PENDING_SAMPLE_VALIDATION + ".jsp";
			}else if(flag.equalsIgnoreCase("DIAG")){
				if(completedCollectionFlag == false)
				jsp = PENDING_SAMPLE_COLLECTION + ".jsp";
				
				if(completedCollectionFlag == true)
					jsp = "completedSampleCollectionList.jsp";
			}
		}
		map.put("box", box);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		
		map.put("deptType1", deptType1);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitSampleCollection(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		List<String> collectedCheck = new ArrayList<String>();
		List<String> quantityCheck = new ArrayList<String>();
		List<String> sampleIddCheck = new ArrayList<String>();
		List<String> remarksCheck = new ArrayList<String>();
		List<String> empanelledCheck = new ArrayList<String>();
		
		
		Box box = HMSUtil.getBox(request);
		boolean saved = false;
		int hospitalId = 0;
		

		String userName = "";
		int noOfRecords = 0;
		String diagSeqNo="";
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameterMap.put("hospitalId", hospitalId);
		}
		
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			parameterMap.put("userName", userName);
		}
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
			parameterMap.put("noOfRecords", noOfRecords);
		}
		if (request.getParameter("diagnosticNo") != null) {
			diagSeqNo = request.getParameter("diagnosticNo");
				}
		int visitId = 0;
		if (request.getParameter(VISIT_ID) != null) {
			visitId = Integer.parseInt(request.getParameter(VISIT_ID));
			parameterMap.put("visitId", visitId);
		}

		for (int i = 0; i < noOfRecords; i++) {
			if (request.getParameter(COLLECTED + i) != null
					&& !request.getParameter(COLLECTED + i).equals("")) {
				collectedCheck.add("y");
			} else {
				collectedCheck.add("n");
			}
		}
		
		for (int i = 0; i < noOfRecords; i++) {
			if (request.getParameter(Empanelled + i) != null
					&& !request.getParameter(Empanelled + i).equals("")) {
				empanelledCheck.add("y");
			} else {
				empanelledCheck.add("n");
			}
		}
		
		
		for (int i = 0; i < noOfRecords; i++) {
			if (request.getParameter(QUANTITY + i) != null
					&& !request.getParameter(QUANTITY + i).equals("")) {
				
				quantityCheck.add(request.getParameter(QUANTITY + i));
			} 
		}
		for (int i = 0; i < noOfRecords; i++) {
			if (request.getParameter(SAMPLE_ID + i) != null) {
				
						sampleIddCheck.add(request.getParameter(SAMPLE_ID + i));
			} 
		}
		for (int i = 0; i < noOfRecords; i++) {
						if (request.getParameter(REMARKS + i) != null
								&& !request.getParameter(REMARKS + i).equals("")) {
										
							remarksCheck.add(request.getParameter(REMARKS + i));
						} 
					}
		/**
		 * For Sample Collection Appointment'
		 * Added By Ritu
		 * Date: 14 March 2012
		 */
		List<String> appointmentCheck = new ArrayList<String>();
		List<String> appointmentDateCheck = new ArrayList<String>();
		
		for (int i = 0; i < noOfRecords; i++) {
			if (request.getParameter("appointment" + i) != null
					&& !request.getParameter("appointment"+i).equals("")) {
				appointmentCheck.add("y");
				appointmentDateCheck.add(request.getParameter("appointmentDate" + i));
			} else {
				appointmentCheck.add("n");
				appointmentDateCheck.add("");
			}
		}
		parameterMap.put("appointmentCheck", appointmentCheck);
		parameterMap.put("appointmentDateCheck", appointmentDateCheck);
		/**
		 * End
		 */
		parameterMap.put("quantityCheck", quantityCheck);
		parameterMap.put("sampleIddCheck", sampleIddCheck);
		parameterMap.put("collectedCheck", collectedCheck);
		parameterMap.put("empanelledCheck", empanelledCheck);
		parameterMap.put("remarksCheck", remarksCheck);
		parameterMap.put("diagSeqNo", diagSeqNo);
		int departmentId = box.getInt("departmentId");
		parameterMap.put("departmentId", departmentId);
		
		
		int hinId = box.getInt(HIN_ID);
		int orderHeaderId = 0;
		int newOrderId = 0;
		orderHeaderId = Integer
				.parseInt(request.getParameter(ORDER_BOOKING_ID));
		List<DgOrderhd> patientDetailList = new ArrayList<DgOrderhd>();

		patientDetailList = (List<DgOrderhd>) session
				.getAttribute("patientDetailList");

		String flag = "";
		if (patientDetailList.size() > 0) {
			for (Iterator iterator = patientDetailList.iterator(); iterator
					.hasNext();) {
				DgOrderhd dgOrderhd = (DgOrderhd) iterator.next();
				Set<DgOrderdt> dgOrderdtSet = dgOrderhd.getDgOrderdts();
				for (DgOrderdt orderDt : dgOrderdtSet) {
					if (orderDt.getMainChargecode().getDepartment()
							.getDepartmentType().getDepartmentTypeCode()
							.equalsIgnoreCase("DIAG")) {
						flag = "lab";
						break;
					}
				}
				if (flag.equals("lab")) {
					newOrderId = dgOrderhd.getId();
					if (newOrderId == orderHeaderId) {
						iterator.remove();
					}
				} else {
					iterator.remove();
				}
			}
		}
		Map<String, Object> patientMap = new HashMap<String, Object>();
		if (newOrderId != 0) {
			map = labHandlerService
					.getSampleCollectionDetailsForNext(newOrderId);
		}
		parameterMap.put("box", box);
		// diagSeqNo = labHandlerService.generateDiagNumber();
		// diagSeqNo = labHandlerService.generateDiagNumber(hinId);
		map = labHandlerService.submitSampleCollection(parameterMap);
		saved = (Boolean) map.get("saved");
		String messageTOBeVisibleToTheUser = "";
		String OrderNo = (String) map.get("OrderNo");
		if (saved) {
			String deptType = "";
			if(request.getParameter("deptType")!=null){
				deptType =request.getParameter("deptType");
			}
			if(deptType.equalsIgnoreCase("EC") || deptType.equalsIgnoreCase("Radio")){
				messageTOBeVisibleToTheUser = "Investigation Accepted.";
			}else{
				messageTOBeVisibleToTheUser = "Sample Collection Done Successfully and Order Reference Order No:"+OrderNo;
			}
		} else {
			messageTOBeVisibleToTheUser = "Some Problem Occured !! Try Again ..";
		}
		url = "/hms/hms/lab?method=showPendingSampleCollectionJsp";
		url1 = "/hms/hms/lab?method=showPendingSampleCollectionJsp";

		String jsp =  MESSAGE_SAMPLE_COLLECTION + ".jsp";

		map.put("orderHeaderId", orderHeaderId);
		map.put("newOrderId", newOrderId);
		map.put("url", url);
		map.put("url1", url1);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// ------------------------------Pending For Sample
	// Validation-------------------------------
	public ModelAndView showPendingSampleValidationJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		String deptType = "";
		int deptId = 0;
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		mapForDs.put("deptId", deptId);
		mapForDs.put("hospitalId", hospitalId);
		
		detailsMap = labHandlerService.getSampleValidationSearch();
		patientMap = labHandlerService.getSampleCollectionGrid(mapForDs);

//		patientMap = labHandlerService.getSampleValidationGrid(mapForDs);
		jsp = PENDING_SAMPLE_VALIDATION + ".jsp";
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("deptType", deptType);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPendingSampleValidationLabJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		String deptType = "";
		int deptId = 0;
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		/*
		 * if(session.getAttribute("boxForResultEntry") != null){
		 * session.removeAttribute("boxForResultEntry"); }
		 */
		/*
		 * if(session.getAttribute("boxForSampleValidation") != null){
		 * session.removeAttribute("boxForSampleValidation"); }
		 */

		mapForDs.put("deptId", deptId);
		mapForDs.put("loginDeptId", deptId);

		//detailsMap = labHandlerService.getDetailsForSearch(mapForDs);
		
		patientMap = labHandlerService.getSampleValidationLabGrid(mapForDs);
		jsp = PENDING_SAMPLE_VALIDATION_LAB + ".jsp";
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("deptType", deptType);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForValidation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = new Date();
		Date toDate = new Date();
		int chargeCodeId = 0;
		int departmentId = 0;
		int inpatientId = 0;
		int subGroupId = 0;
		int sampleId = 0;
		int hinId = 0;
		int deptId = 0;
		String serPersonFName = "";
		String patientFName = "";
		String serviceNo = "";
		String deptName = "";
		String deptType = "";
		String hinNo = "";
		String adNo = "";
		String flag = "";
		String pType = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();
		int uid = 0;
		try {
			if (session.getAttribute("deptName") != null)
				deptName = (String) session.getAttribute("deptName");
			if (session.getAttribute("deptType") != null) {
				deptType = (String) session.getAttribute("deptType");
			}
			if (session.getAttribute("users") != null) {
				Users user = (Users) session.getAttribute("users");
				uid = user.getId();
			}
			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
			}
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				mapForDs.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
				mapForDs.put("toDate", toDate);
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				pType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("pType", pType);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));
				mapForDs.put("chargeCodeId", chargeCodeId);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subGroupId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subGroupId", subGroupId);
			}
			if (request.getParameter(SAMPLE_ID) != null
					&& !(request.getParameter(SAMPLE_ID).equals("0"))) {
				sampleId = Integer.parseInt(request.getParameter(SAMPLE_ID));
				mapForDs.put("sampleId", sampleId);
			}
			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				mapForDs.put("departmentId", departmentId);
			}
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsp = "";

		int orderId = 0;
		if (request.getParameter("orderId") != null
				&& !(request.getParameter("orderId").equals("0"))) {
			orderId = new Integer(request.getParameter("orderId"));
			mapForDs.put("orderId", orderId);

		}
		if (orderId != 0) {
			map = labHandlerService.getSampleCollectionDetails(mapForDs);
			/*map = labHandlerService.getSampleValidationDetails(orderId, uid,
					deptId);*/
		}
		if (map != null && map.get("samplehdList") != null) {
			jsp = SAMPLE_ACCEPTANCE + ".jsp";
		} else {
			patientMap = labHandlerService
					.getPatientDetailsForValidation(mapForDs);
			detailsMap = labHandlerService.getDetailsForSearch(detailsMap);
			jsp = PENDING_SAMPLE_VALIDATION + ".jsp";
		}
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("deptType", deptType);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchPatientForSampleValidationLab(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = null;
		Date toDate = null;
		int chargeCodeId = 0;
		int orderByDepartmentId = 0;
		int inpatientId = 0;
		int subGroupId = 0;
		int sampleId = 0;
		int hinId = 0;
		int loginDeptId = 0;
		String serPersonFName = "";
		String patientFName = "";
		String serviceNo = "";
		String deptName = "";
		String deptType = "";
		String hinNo = "";
		String adNo = "";
		String diagSeqNo="";

		String pType = "";
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int uid = 0;
		String barCodeOrderNo="";

		try {
			if (session.getAttribute("deptName") != null) {
				deptName = (String) session.getAttribute("deptName");
			}
			if (session.getAttribute("deptType") != null) {
				deptType = (String) session.getAttribute("deptType");
			}
			if (session.getAttribute("users") != null) {
				Users user = (Users) session.getAttribute("users");
				uid = user.getId();
			}
			if (session.getAttribute("deptId") != null) {
				loginDeptId = (Integer) session.getAttribute("deptId");
				mapForDs.put("loginDeptId", loginDeptId);
			}
			
			
			int empId = 0;
			if (session.getAttribute("userId") != null) {
			empId = Integer.parseInt(session.getAttribute("userId").toString());

			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				mapForDs.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
				mapForDs.put("toDate", toDate);
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				pType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("pType", pType);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));
				mapForDs.put("chargeCodeId", chargeCodeId);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subGroupId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subGroupId", subGroupId);
			}
			if (request.getParameter(SAMPLE_ID) != null
					&& !(request.getParameter(SAMPLE_ID).equals("0"))) {
				sampleId = Integer.parseInt(request.getParameter(SAMPLE_ID));
				mapForDs.put("sampleId", sampleId);
			}
			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				orderByDepartmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				mapForDs.put("orderByDepartmentId", orderByDepartmentId);
			}
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(DIAGNOSIS_NO) != null
					&& !(request.getParameter(DIAGNOSIS_NO).equals("0"))) {
				diagSeqNo = request.getParameter(DIAGNOSIS_NO);
				mapForDs.put("diagSeqNo",diagSeqNo );
			}
			
			if (request.getParameter("barCodeOrderNo") != null)
			{
				barCodeOrderNo = request.getParameter("barCodeOrderNo");
				mapForDs.put("barCodeOrderNo",barCodeOrderNo );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = "";
		String combinedIds = "";
		if (request.getParameter("combinedIds") != null
				&& !(request.getParameter("combinedIds").equals(""))) {
			combinedIds = request.getParameter("combinedIds");
			mapForDs.put("combinedIds", combinedIds);
		}
		if (!combinedIds.equals("")) {
			map = labHandlerService.getSampleValidationDetailsLab(combinedIds,
					uid, loginDeptId);
		}
		if (map != null && map.get("sampleCollectionDtList") != null) {
			jsp = SAMPLE_ACCEPTANCE_LAB + ".jsp";
		} else {
			/*
			 * if(session.getAttribute("boxForSampleValidation") != null){
			 * session.removeAttribute("boxForSampleValidation");
			 * session.setAttribute("boxForSampleValidation",box); }else{
			 * session.setAttribute("boxForSampleValidation",box); }
			 */
			patientMap = labHandlerService
					.getPatientDetailsForValidationLab(mapForDs);
			mapForDs.put("deptId", session.getAttribute("deptId"));
			detailsMap = labHandlerService.getDetailsForSearch(mapForDs);
			jsp = PENDING_SAMPLE_VALIDATION_LAB + ".jsp";
		}
		map.put("uid", uid);
		map.put("deptId", loginDeptId);
		map.put("combinedIds", combinedIds);
		map.put("deptName", deptName);
		map.put("deptType", deptType);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchPatientBackButtonSampleValidationLab(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = new Date();
		Date toDate = new Date();
		int chargeCodeId = 0;
		int orderByDepartmentId = 0;
		int subGroupId = 0;
		int loginDeptId = 0;
		String serPersonFName = "";
		String patientFName = "";
		String serviceNo = "";
		String deptName = "";
		String deptType = "";
		String hinNo = "";
		String adNo = "";

		String pType = "";
		session = request.getSession();
		Box box = null;

		/*
		 * if(session.getAttribute("boxForSampleValidation") != null){ box =
		 * (Box)session.getAttribute("boxForSampleValidation"); }
		 */
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}
		if (session.getAttribute("deptId") != null) {
			loginDeptId = (Integer) session.getAttribute("deptId");
			mapForDs.put("loginDeptId", loginDeptId);
		}

		try {
			if (box != null) {
				if (box.getString(HIN_NO) != null
						&& !(box.getString(HIN_NO).equals(""))) {
					hinNo = box.getString(HIN_NO);
					mapForDs.put("hinNo", hinNo);
				}
				if (box.getString(FROM_DATE) != null
						&& !(box.getString(FROM_DATE).equals(""))) {
					fromDate = HMSUtil.dateFormatterDDMMYYYY(box
							.getString(FROM_DATE));
					mapForDs.put("fromDate", fromDate);
				}
				if (box.getString(TO_DATE) != null
						&& !(box.getString(TO_DATE).equals(""))) {
					toDate = HMSUtil.dateFormatterDDMMYYYY(box
							.getString(TO_DATE));
					mapForDs.put("toDate", toDate);
				}
				if (box.getString(PATIENT_TYPE) != null
						&& !(box.getString(PATIENT_TYPE).equals(""))) {
					pType = box.getString(PATIENT_TYPE);
					mapForDs.put("pType", pType);
				}

				if (request.getParameter(SERVICE_NO) != null
						&& !(request.getParameter(SERVICE_NO).equals(""))) {
					serviceNo = request.getParameter(SERVICE_NO);
					mapForDs.put("serviceNo", serviceNo);
				}

				if (box.getString(SUB_CHARGECODE_ID) != null
						&& !(box.getString(SUB_CHARGECODE_ID).equals(""))
						&& !(box.getString(SUB_CHARGECODE_ID).equals("0"))) {
					subGroupId = Integer.parseInt(box
							.getString(SUB_CHARGECODE_ID));
					mapForDs.put("subGroupId", subGroupId);
				}

				if (box.getString(CHARGE_CODE_ID) != null
						&& !(box.getString(CHARGE_CODE_ID).equals(""))
						&& !(box.getString(CHARGE_CODE_ID).equals("0"))) {
					chargeCodeId = Integer.parseInt(box
							.getString(CHARGE_CODE_ID));
					mapForDs.put("chargeCodeId", chargeCodeId);
				}

				if (box.getString(S_FIRST_NAME) != null
						&& !(box.getString(S_FIRST_NAME).equals(""))) {
					serPersonFName = box.getString(S_FIRST_NAME);
					mapForDs.put("serPersonFName", serPersonFName);
				}
				if (box.getString(P_FIRST_NAME) != null
						&& !(box.getString(P_FIRST_NAME).equals(""))) {
					patientFName = box.getString(P_FIRST_NAME);
					mapForDs.put("patientFName", patientFName);
				}
				if (box.getString(AD_NO) != null
						&& !(box.getString(AD_NO).equals(""))) {
					adNo = box.getString(AD_NO);
					mapForDs.put("adNo", adNo);
				}
				if (box.getString(DEPARTMENT_ID) != null
						&& !(box.getString(DEPARTMENT_ID).equals(""))
						&& !(box.getString(DEPARTMENT_ID).equals("0"))) {
					orderByDepartmentId = Integer.parseInt(box
							.getString(DEPARTMENT_ID));
					mapForDs.put("orderByDepartmentId", orderByDepartmentId);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = "";
		patientMap = labHandlerService
				.getPatientDetailsForValidationLab(mapForDs);
		detailsMap = labHandlerService.getDetailsForSearch(mapForDs);
		jsp = PENDING_SAMPLE_VALIDATION_LAB + ".jsp";

		map.put("deptId", loginDeptId);
		map.put("deptName", deptName);
		map.put("deptType", deptType);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView submitSampleAcceptance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		int hospitalId = 0;
		String userName = "";
		String deptType = "";
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameterMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			parameterMap.put("userName", userName);
		}
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}
		parameterMap.put("deptType", deptType);
		int counter = 0;
		if (request.getParameter("counter2") != null) {
			counter = Integer.parseInt(request.getParameter("counter2"));
		}
		List accepList = new ArrayList();
		List<Integer> acceptedIdList = new ArrayList<Integer>();

		List rejList = new ArrayList();
		Box box = HMSUtil.getBox(request);
		Vector chargeCodeId = box.getVector(CHARGE_CODE_ID);
		// int j = 1;
		for (int i = 1; i <= counter; i++) {

			// if(!disabled){
			if (request.getParameter("check" + i) != null) {
				acceptedIdList.add(Integer.parseInt((String) chargeCodeId
						.get(i - 1)));
				accepList.add("y");
			} else {
				accepList.add("n");
			}
			if (request.getParameter("check1" + i) != null) {
				rejList.add("y");
			} else {
				rejList.add("n");
			}

			// j++;
			// }
		}
		int sampleCollectionHeaderId = 0;
		int newSampleId = 0;
		sampleCollectionHeaderId = Integer.parseInt(request
				.getParameter("sampleCollectionHeaderId"));
		List<DgSampleCollectionHeader> patientDeatilList = new ArrayList<DgSampleCollectionHeader>();

		patientDeatilList = (List<DgSampleCollectionHeader>) session
				.getAttribute("patientDeatilList");

		if (patientDeatilList.size() > 0) {
			for (Iterator iterator = patientDeatilList.iterator(); iterator
					.hasNext();) {
				DgSampleCollectionHeader dgSampleCollectionHeader = (DgSampleCollectionHeader) iterator
						.next();
				newSampleId = dgSampleCollectionHeader.getId();
				if (newSampleId == sampleCollectionHeaderId) {
					iterator.remove();
				}
			}

		}
		Map<String, Object> patientMap = new HashMap<String, Object>();
		if (newSampleId != 0) {
			map = labHandlerService
					.getSampleValidationDetailsForNext(newSampleId);
		}
		parameterMap.put("accepList", accepList);
		parameterMap.put("acceptedIdList", acceptedIdList);
		parameterMap.put("rejList", rejList);

		parameterMap.put("box", box);
		boolean successfullyUpdated = false;
		successfullyUpdated = labHandlerService
				.submitSampleAcceptance(parameterMap);
		String messageTOBeVisibleToTheUser = "";
		if (successfullyUpdated) {
			if (deptType.equalsIgnoreCase("DIAG")) {
				messageTOBeVisibleToTheUser = "Sample validation Done Successfully !!";
			} else if (deptType.equalsIgnoreCase("RADIO")) {
				messageTOBeVisibleToTheUser = "Radiological Investigation Accepted Successfully!!";
			}
		} else {
			messageTOBeVisibleToTheUser = "Some Problem Occured! Try Again.";
		}
		url = "/hms/hms/lab?method=showPendingSampleValidationJsp";
		url1 = "/hms/hms/investigation?method=showPendingResultEntryJsp";
		String jsp = MESSAGE_FOR_SAMPLE + ".jsp";
		map.put("newSampleId", newSampleId);
		map.put("sampleCollectionHeaderId", sampleCollectionHeaderId);
		map.put("url", url);
		map.put("url1", url1);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitSampleAcceptanceLab(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		int hospitalId = 0;
		String userName = "";
		String deptType = "";
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameterMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			parameterMap.put("userName", userName);
		}
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}
		parameterMap.put("deptType", deptType);
		int counter = 0;
		String combinedIds = "";
		if (request.getParameter("counter2") != null) {
			counter = Integer.parseInt(request.getParameter("counter2"));
		}
		if (request.getParameter("combinedIds") != null) {
			combinedIds = request.getParameter("combinedIds");
		}

		List accepList = new ArrayList();
		List<Integer> acceptedIdList = new ArrayList<Integer>();

		List rejList = new ArrayList();
		Box box = HMSUtil.getBox(request);

		Vector chargeCodeId = box.getVector(CHARGE_CODE_ID);
		// int j = 1;
		for (int i = 1; i <= counter; i++) {

			// if(!disabled){
			if (request.getParameter("check" + i) != null) {
				acceptedIdList.add(Integer.parseInt((String) chargeCodeId
						.get(i - 1)));
				accepList.add("y");
			} else {
				accepList.add("n");
			}
			if (request.getParameter("rejectedCheckBox" + i) != null) {
				rejList.add("y");
			} else {
				rejList.add("n");
			}

			// j++;
			// }
		}

		String nextCombinedIds = "";
		if (!combinedIds.equals("")) {
			String[] idArrString = new String[0];
			idArrString = combinedIds.split(",");

			int subChargeIdTemp = Integer.parseInt(idArrString[1]);

			List<String> combinedListAll = new ArrayList<String>();
			combinedListAll = (List<String>) session
					.getAttribute("combinedListSampleValidationAll");

			if (combinedListAll.size() > 0) {
				combinedListAll.remove(combinedIds);
			}
			for (String combinedIdsFromList : combinedListAll) {
				String[] idArray = new String[0];
				idArray = combinedIdsFromList.split(",");

				int subChargeIdFromList = Integer.parseInt(idArray[1]);
				if (subChargeIdFromList == subChargeIdTemp) {
					nextCombinedIds = combinedIdsFromList;
					break;
				}
			}
		}
		parameterMap.put("accepList", accepList);
		parameterMap.put("acceptedIdList", acceptedIdList);
		parameterMap.put("rejList", rejList);

		parameterMap.put("box", box);

		boolean successfullyUpdated = false;
		successfullyUpdated = labHandlerService
				.submitSampleAcceptanceLab(parameterMap);
		String messageTOBeVisibleToTheUser = "";
		if (successfullyUpdated) {
			messageTOBeVisibleToTheUser = "Sample Collection Done Successfully !!";
		} else {
			messageTOBeVisibleToTheUser = "Some Problem Occured! Try Again.";
		}
		url = "/hms/hms/lab?method=searchPatientBackButtonSampleValidationLab";

		String jsp = MESSAGE_FOR_SAMPLE_LAB + ".jsp";
		map.put("nextCombinedIds", nextCombinedIds);
		map.put("combinedIds", combinedIds);
		map.put("url", url);
		map.put("url1", url1);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public void checkForExistingRadioId(HttpServletRequest request,
			HttpServletResponse response) {
		StringBuffer sb = new StringBuffer();
		Map<String, Object> diagNoDetailMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		String radioIdToCheck = "";
		Integer sampleCollectionIdToCheck = 0;

		if (request.getParameter("radioIdToCheck") != null) {
			radioIdToCheck = request.getParameter("radioIdToCheck");
			mapForDs.put("radioIdToCheck", radioIdToCheck);
		}
		if (request.getParameter("sampleCollectionIdToCheck") != null) {
			sampleCollectionIdToCheck = Integer.parseInt(request
					.getParameter("sampleCollectionIdToCheck"));
			mapForDs
					.put("sampleCollectionIdToCheck", sampleCollectionIdToCheck);
		}

		diagNoDetailMap = labHandlerService.checkForExistingSeqNo(mapForDs);

		sb.append("<radioIdFlag>");
		if (diagNoDetailMap.get("flag") != null
				&& ((String) diagNoDetailMap.get("flag"))
						.equalsIgnoreCase("FoundDuplicate")) {
			sb.append("<flagValue>" + "Duplicate" + "</flagValue>");
		}
		if (diagNoDetailMap.get("flag") != null
				&& ((String) diagNoDetailMap.get("flag"))
						.equalsIgnoreCase("NoDuplicateFound")) {
			sb.append("<flagValue>" + "NoDuplicate" + "</flagValue>");
		}
		sb.append("</radioIdFlag>");

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<radioIdFlags>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</radioIdFlags>");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// -----------------------Reports-----------------------------------
	public ModelAndView showPatientDiagnosticRegisterJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute("hospitalId") != null) {
			map.put("hospitalId", session.getAttribute("hospitalId"));
		}
		map = labHandlerService.showDiagnosticRegisterJsp(map);
		jsp = PATIENT_DIAGNOSTIC_REGISTER;
		jsp += ".jsp";
		title = "Diagnostic Register Doctor Wise";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showConfidentialDiagnosticRegister(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		map = labHandlerService.showDiagnosticRegisterJsp(map);
		jsp = PATIENT_CONFIDENTIAL_DIAGNOSTIC_REGISTER;
		jsp += ".jsp";
		title = "Diagnostic Register Doctor Wise";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPatientWiseFilmsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		map = labHandlerService.showPatientWiseFilmsJsp(map);
		jsp = "patientWiseFilms";
		jsp += ".jsp";
		title = "Films Patient Wise";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showMicrobiologySensitiveWiseReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		map = labHandlerService.showMicrobiologySensitiveWiseReportJsp(map);
		jsp = "microbiologySensitiveWiseReportJsp";
		jsp += ".jsp";
		title = "Films Patient Wise";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showDiagnosticRegisterDoctorWise(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		map = labHandlerService.showDiagnosticRegisterDoctorWise(map);
		jsp = DIAGNOSTIC_REGISTER_DOCTOR_WISE;
		jsp += ".jsp";
		title = "Diagnostic Register Doctor Wise";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showDiagnosticRegisterDiagnosisWise(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		Map requestMap = new HashMap();
		requestMap.put("deptId", deptId);
		map = labHandlerService.showDiagnosticRegisterDiagnosisWise(requestMap);
		jsp = DIAGNOSTIC_REGISTER_DIAGNOSIS_WISE;
		jsp += ".jsp";
		title = "Diagnostic Register Diagnosis Wise";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPackingListJsp(HttpServletRequest request,
			HttpServletResponse response) {
		map = labHandlerService.showPackingListJsp();
		jsp = PACKING_LIST;
		jsp += ".jsp";
		title = "Packing list";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	// -------------------------------Generates
	// reports------------------------------------------------

	// ------------------------------------ Patient Diagnostic Register
	// --------------------------
	public ModelAndView generatePatientDiagnosticRegister(
			HttpServletRequest request, HttpServletResponse response) {
		Date fromDate = null;
		Date toDate = null;
		int subChargeId = 0;
		int depart = 0;
		int departmentId = 0;
		String patient = "";
		String resultType = "";
		String query = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap1 = new HashMap<String, Object>();

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				// fromDate
				// =sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE)))
				// ;
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
				// mapForDs.put("toDate", toDate);

				// toDate =sdf.format(HMSUtil.convertStringTypeDateToDateType(
				// request.getParameter(TO_DATE))) ;
			}

			query = " where dg_result_entry_header.result_date between '"
					+ fromDate + "' and '" + toDate + "'";

			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				parameters.put("subChargeId", subChargeId);
				query = query
						+ " AND dg_result_entry_header.`sub_chargecode_id` = "
						+ subChargeId;
			}

			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				depart = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
				parameters.put("depart", depart);
				query = query + " AND dg_orderhd.`department_id` = " + depart;
			}

			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals("0"))) {
				patient = (request.getParameter(PATIENT_TYPE));
				parameters.put("patient", patient);
				query = query + " AND dg_orderhd.patient_type = '" + patient
						+ "'";
			}

			if (request.getParameter("resultType") != null
					&& !(request.getParameter("resultType").equals("0"))) {
				resultType = request.getParameter("resultType");
				parameters.put("resultType", resultType);
				query = query + " AND dg_result_entry_detail.`result_type` = '"
						+ resultType + "'";
			}

			if (session.getAttribute("deptId") != null) {
				departmentId = Integer.parseInt(""
						+ session.getAttribute("deptId"));
				parameters.put("departmentId", departmentId);
				query = query
						+ " AND dg_result_entry_header.`department_id` = "
						+ departmentId;
			}

			query = query + " AND dg_result_entry_header.`result_status` = 'A'";

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = labHandlerService.getConnectionForReport();

		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("QUERY", query);
		String appendedHtml = "";
		try {
			if (resultType.equals("t")) {
				detailsMap1 = labHandlerService
						.getDiagnosticRegister(parameters);
				// ServletContext conte
				/*
				 * String bytes1 =
				 * JasperRunManager.runReportToHtmlFile(getServletContext
				 * ().getRealPath("/reports/" + "patientDiagnosticRegisterTemp"
				 * + ".jasper"),parameters,(Connection)detailsMap.get("con"));
				 * InputStream is=new FileInputStream(bytes1); File
				 * temprory1=new File(bytes1); byte[] b3=new
				 * byte[(int)temprory1.length()]; int offset = 0; int numRead =
				 * 0; try { while ( (offset < b3.length) && (
				 * (numRead=is.read(b3, offset, b3.length-offset)) >= 0) ) {
				 * offset += numRead; } } catch (IOException e) {
				 * e.printStackTrace(); } try { is.close(); } catch (IOException
				 * e) { e.printStackTrace(); }
				 * //System.out.println("in appending html of result entry"
				 * +b3.length); appendedHtml = new String (b3);
				 */

				// HMSUtil.generateReport("patientDiagnosticRegisterTemp",
				// parameters, (Connection)detailsMap.get("con"), response,
				// getServletContext());

			} else {
				HMSUtil.generateReport("patientDiagnosticRegister", parameters,
						(Connection) detailsMap.get("con"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "nonConfidentialDiagnosticRegisterRadiology";
		map.put("detailsMap1", detailsMap1);
		map.put("parameters", parameters);
		map.put("appendedHtml", appendedHtml);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView generateConfidentialPatientDiagnosticRegister(
			HttpServletRequest request, HttpServletResponse response) {
		Date fromDate = null;
		Date toDate = null;
		int subChargeId = 0;
		int depart = 0;
		int departmentId = 0;
		String patient = "";
		String resultType = "";
		String query = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap1 = new HashMap<String, Object>();

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				// fromDate
				// =sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE)))
				// ;
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
				// mapForDs.put("toDate", toDate);

				// toDate =sdf.format(HMSUtil.convertStringTypeDateToDateType(
				// request.getParameter(TO_DATE))) ;
			}

			query = " where dg_result_entry_header.result_date between '"
					+ fromDate + "' and '" + toDate + "'";

			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				parameters.put("subChargeId", subChargeId);
				query = query
						+ " AND dg_result_entry_header.`sub_chargecode_id` = "
						+ subChargeId;
			}

			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				depart = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
				parameters.put("depart", depart);
				query = query + " AND dg_orderhd.`department_id` = " + depart;
			}

			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals("0"))) {
				patient = (request.getParameter(PATIENT_TYPE));
				parameters.put("patient", patient);
				query = query + " AND dg_orderhd.patient_type = '" + patient
						+ "'";
			}

			if (request.getParameter("resultType") != null
					&& !(request.getParameter("resultType").equals("0"))) {
				resultType = request.getParameter("resultType");
				parameters.put("resultType", resultType);
				query = query + " AND dg_result_entry_detail.`result_type` = '"
						+ resultType + "'";
			}

			if (session.getAttribute("deptId") != null) {
				departmentId = Integer.parseInt(""
						+ session.getAttribute("deptId"));
				parameters.put("departmentId", departmentId);
				query = query
						+ " AND dg_result_entry_header.`department_id` = "
						+ departmentId;
			}

			query = query + " AND dg_result_entry_header.`result_status` = 'A'";

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = labHandlerService.getConnectionForReport();

		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("QUERY", query);
		String appendedHtml = "";
		try {
			if (resultType.equals("t")) {
				detailsMap1 = labHandlerService
						.getDiagnosticRegister(parameters);
				// ServletContext conte
				/*
				 * String bytes1 =
				 * JasperRunManager.runReportToHtmlFile(getServletContext
				 * ().getRealPath("/reports/" + "patientDiagnosticRegisterTemp"
				 * + ".jasper"),parameters,(Connection)detailsMap.get("con"));
				 * InputStream is=new FileInputStream(bytes1); File
				 * temprory1=new File(bytes1); byte[] b3=new
				 * byte[(int)temprory1.length()]; int offset = 0; int numRead =
				 * 0; try { while ( (offset < b3.length) && (
				 * (numRead=is.read(b3, offset, b3.length-offset)) >= 0) ) {
				 * offset += numRead; } } catch (IOException e) {
				 * e.printStackTrace(); } try { is.close(); } catch (IOException
				 * e) { e.printStackTrace(); }
				 * //System.out.println("in appending html of result entry"
				 * +b3.length); appendedHtml = new String (b3);
				 */

				// HMSUtil.generateReport("patientDiagnosticRegisterTemp",
				// parameters, (Connection)detailsMap.get("con"), response,
				// getServletContext());

			} else {
				HMSUtil.generateReport("patientDiagnosticRegister", parameters,
						(Connection) detailsMap.get("con"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "confidentialDiagnosticRegister";
		map.put("detailsMap1", detailsMap1);
		map.put("parameters", parameters);
		map.put("appendedHtml", appendedHtml);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	// ------------------------------------ Patient Diagnostic Register
	// --------------------------
	public ModelAndView generatePatientDiagnosticRegisterLab(
			HttpServletRequest request, HttpServletResponse response) {
		Date fromDate = null;
		Date toDate = null;
		int subChargeId = 0;
		int depart = 0;
		int departmentId = 0;
		String patient = "";
		String resultType = "";
		String query = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap1 = new HashMap<String, Object>();
		Map<String, Object> resultDetailsMap = new HashMap<String, Object>();
		List<Map<String, Object>> resultDetailsMapList = new ArrayList<Map<String, Object>>();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				// fromDate
				// =sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE)))
				// ;
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
				// mapForDs.put("toDate", toDate);

				// toDate =sdf.format(HMSUtil.convertStringTypeDateToDateType(
				// request.getParameter(TO_DATE))) ;
			}

			query = " where dg_result_entry_header.result_date between '"
					+ fromDate + "' and '" + toDate + "'";

			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				parameters.put("subChargeId", subChargeId);
				query = query
						+ " AND dg_result_entry_header.sub_chargecode_id = "
						+ subChargeId;
			}

			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				depart = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
				parameters.put("depart", depart);
				query = query + " AND dg_orderhd.department_id = " + depart;
			}

			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals("0"))) {
				patient = (request.getParameter(PATIENT_TYPE));
				parameters.put("patient", patient);
				query = query + " AND dg_orderhd.patient_type = '" + patient
						+ "'";
			}

			if (request.getParameter("resultType") != null
					&& !(request.getParameter("resultType").equals("0"))) {
				resultType = request.getParameter("resultType");
				parameters.put("resultType", resultType);
				query = query + " AND dg_result_entry_detail.result_type = '"
						+ resultType + "'";
			}

			if (session.getAttribute("deptId") != null) {
				departmentId = Integer.parseInt(""
						+ session.getAttribute("deptId"));
				parameters.put("departmentId", departmentId);
				query = query
						+ " AND dg_result_entry_header.department_id = "
						+ departmentId;
			}

			query = query + " AND dg_result_entry_header.result_status = 'A'";

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = labHandlerService.getConnectionForReport();

		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("QUERY", query);
		parameters.put("hospitalId",hospitalId);
		Box box = HMSUtil.getBox(request);
		parameters.put("box", box);
		String appendedHtml = "";
		try {
			if (resultType.equalsIgnoreCase("m")) {
				detailsMap1 = labHandlerService
						.getDiagnosticRegisterForMultipleTestType(parameters);
				List<DgResultEntryHeader> dgMultipleResultdetailList = new ArrayList<DgResultEntryHeader>();
				if (detailsMap1.get("dgMultipleResultdetailList") != null) {
					dgMultipleResultdetailList = (List) detailsMap1
							.get("dgMultipleResultdetailList");
					for (DgResultEntryHeader dgResultEntryHeader : dgMultipleResultdetailList) {
						resultDetailsMap = labHandlerService
								.getResultEntryDetailsForMultipleResultType(
										dgResultEntryHeader.getId(), deptId);
						resultDetailsMapList.add(resultDetailsMap);
					}
					map.put("resultDetailsMapList", resultDetailsMapList);
				}
				jsp = "diagnosticRegisterLabMultipleTestType";
			} else {
				detailsMap1 = labHandlerService
						.getDiagnosticRegister(parameters);
				jsp = "diagnosticRegisterLab";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("detailsMap1", detailsMap1);
		map.put("parameters", parameters);
		map.put("appendedHtml", appendedHtml);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView generateMicrobiologySensitiveWise(
			HttpServletRequest request, HttpServletResponse response) {
		String fromDate = null;
		String toDate = null;
		Date fromDateDisp = null;
		Date toDateDisp = null;
		int departmentId = 0;
		int employeeId = 0;
		int subChargeId = 0;
		String patient = "";
		String query = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE)));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(TO_DATE)));
			}
			query = " where dg_result_entry_header.result_date between '"
					+ fromDate + "' AND '" + toDate + "'";

			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				// query = query +
				// " AND dg_result_entry_header.`sub_chargecode_id` = "+subChargeId;
			}
			if (request.getParameter(EMPLOYEE_ID) != null
					&& !(request.getParameter(EMPLOYEE_ID).equals(""))) {
				employeeId = Integer
						.parseInt(request.getParameter(EMPLOYEE_ID));
				// query = query +
				// " AND dg_result_entry_header.`result_verified_by` = "+employeeId;

			}

			if (session.getAttribute("deptId") != null) {
				departmentId = Integer.parseInt(""
						+ session.getAttribute("deptId"));
				// query = query +
				// " AND dg_result_entry_header.`department_id` = "+departmentId;
			}
			// query = query + " AND dg_result_entry_detail.`film_used` > '0' ";
			// query = query +
			// " AND dg_result_entry_header.`result_status` = 'A'";

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = labHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("QUERY", query);
		fromDateDisp = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter(FROM_DATE));
		toDateDisp = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter(TO_DATE));
		parameters.put("fromDate", fromDateDisp);
		parameters.put("toDate", toDateDisp);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		try {
			HMSUtil.generateReport("microSensitiveWise", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	public ModelAndView generatePatientWiseFilms(HttpServletRequest request,
			HttpServletResponse response) {
		String fromDate = null;
		String toDate = null;
		Date fromDateDisp = null;
		Date toDateDisp = null;
		int departmentId = 0;
		int employeeId = 0;
		int subChargeId = 0;
		int status = 0;
		String patient = "";
		String query = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();

		Map<String, Object> filmDetailsMap = new HashMap<String, Object>();

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE)));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(TO_DATE)));
			}
			query = " where dg_result_entry_header.result_date between '"
					+ fromDate + "' AND '" + toDate + "'";

			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				query = query
						+ " AND dg_result_entry_header.`sub_chargecode_id` = "
						+ subChargeId;
			}
			if (request.getParameter(EMPLOYEE_ID) != null
					&& !(request.getParameter(EMPLOYEE_ID).equals(""))) {
				employeeId = Integer
						.parseInt(request.getParameter(EMPLOYEE_ID));
				// query = query +
				// " AND dg_result_entry_header.`result_verified_by` = "+employeeId;

			}

			if (session.getAttribute("deptId") != null) {
				departmentId = Integer.parseInt(""
						+ session.getAttribute("deptId"));
				query = query
						+ " AND dg_result_entry_header.`department_id` = "
						+ departmentId;
			}
			query = query + " AND dg_film_detail.`film_used` > '0' ";
			query = query + " AND dg_result_entry_header.`result_status` = 'A'";

			// filmDetailsMap =
			// labHandlerService.getTotalFilmUsed(departmentId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = labHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("QUERY", query);
		// parameters.put("totalFilmUsed",totalFilmUsed);
		fromDateDisp = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter(FROM_DATE));
		toDateDisp = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter(TO_DATE));
		parameters.put("fromDate", fromDateDisp);
		parameters.put("toDate", toDateDisp);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		status = Integer.parseInt(request.getParameter(SELECTED_RADIO));
		try {
			if (status == 1) {
				HMSUtil.generateReport("filmsSummary", parameters,
						(Connection) detailsMap.get("con"), response,
						getServletContext());
			} else {
				HMSUtil.generateReport("patientWiseFilms", parameters,
						(Connection) detailsMap.get("con"), response,
						getServletContext());
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	// -------------------------for Diagnostic register Doctor
	// Wise-----------------------------

	public ModelAndView generateDiagnosticRegisterDoctorWise(
			HttpServletRequest request, HttpServletResponse response) {
		String fromDate = null;
		String toDate = null;
		int departmentId = 0;
		int employeeId = 0;
		int subChargeId = 0;
		String patient = "";
		String query = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE)));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(TO_DATE)));
			}

			query = " where dg_result_entry_header.result_date between to_date('"
					+ fromDate + "' ,'yyyy,mm,dd') and to_date('" + toDate + "' ,'yyyy,mm,dd')";

			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				query = query
						+ " AND dg_result_entry_header.sub_chargecode_id = "
						+ subChargeId;
			}

			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals("0"))) {
				patient = (request.getParameter(PATIENT_TYPE));
				query = query + " AND dg_orderhd.patient_type = '" + patient
						+ "'";
			}

			if (request.getParameter(EMPLOYEE_ID) != null
					&& !(request.getParameter(EMPLOYEE_ID).equals(""))) {
				employeeId = Integer
						.parseInt(request.getParameter(EMPLOYEE_ID));
				query = query
						+ " AND dg_result_entry_header.result_verified_by = "
						+ employeeId;

			}

			if (session.getAttribute("deptId") != null) {
				departmentId = Integer.parseInt(""
						+ session.getAttribute("deptId"));
				query = query
						+ " AND dg_result_entry_header.department_id = "
						+ departmentId;
			}

			query = query + " AND dg_result_entry_header.result_status = 'A'";
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = labHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();

		if (patient.equals("")) {
			parameters.put("patientType", "IPD/OPD");
		} else if (patient.equalsIgnoreCase("IP")) {
			parameters.put("patientType", "In Patient");
		} else if (patient.equalsIgnoreCase("OP")) {
			parameters.put("patientType", "Out Patient");
		}
		parameters.put("qry", query);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		try {
			HMSUtil.generateReport("diagnosticRegisterDoctorWise", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	// =====================================End
	// ====================================================================

	public ModelAndView generateDiagnosticRegisterDiagnosisWise(
			HttpServletRequest request, HttpServletResponse response) {

		String fromDate = null;
		String toDate = null;
		int chargeCodeId = 0;
		int subCharge = 0;
		int departmentId = 0;
		String query = "";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();
		Map<String, Object> parameters = new HashMap<String, Object>();
		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE)));
				parameters.put("fromDate", HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE)));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(TO_DATE)));
				parameters.put("toDate", HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(TO_DATE)));
			}
			query = " where dg_result_entry_header.result_date between to_date('"
					+ fromDate + "' ,'yyyy,mm,dd') and to_date('" + toDate + "' ,'yyyy,mm,dd')";

			if (session.getAttribute("deptId") != null) {
				departmentId = Integer.parseInt(""
						+ session.getAttribute("deptId"));
				query = query
						+ " AND dg_result_entry_header.department_id = "
						+ departmentId;
			}

			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subCharge = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				query = query
						+ " AND dg_result_entry_header.sub_chargecode_id = "
						+ subCharge;
			}

			if (request.getParameter(INVESTIGATION_ID) != null
					&& !(request.getParameter(INVESTIGATION_ID).equals(""))
					&& !(request.getParameter(INVESTIGATION_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(INVESTIGATION_ID));
				query = query
						+ " AND dg_result_entry_header.investigation_id = "
						+ chargeCodeId;
			}

			query = query + " AND dg_result_entry_header.result_status = 'A'";
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = labHandlerService.getConnectionForReport();

		parameters.put("QUERY", query);
		parameters.put("SUBREPORTPATH", getServletContext().getRealPath(
				"/reports/"));

		try {
			HMSUtil.generateReport(LAB_DIAGNOSTIC_REGISTER_DAIGNOSIS_WISE,
					parameters, (Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	// *************************Vishal Code End for
	// Reports*******************************************
	public ModelAndView generatePackingList(HttpServletRequest request,
			HttpServletResponse response) {

		String fromDate = null;
		String toDate = null;
		int mainCharge = 0;
		int subCharge = 0;
		int collectionCenter = 0;
		String patientType = null;
		String query = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE)));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(TO_DATE)));
			}
			if (request.getParameter(MAIN_CHARGECODE_ID) != null
					&& !(request.getParameter(MAIN_CHARGECODE_ID).equals("0"))) {
				mainCharge = Integer.parseInt(request
						.getParameter(MAIN_CHARGECODE_ID));
			}
			if (request.getParameter("subChargeCode_id") != null
					&& !(request.getParameter("subChargeCode_id").equals("0"))) {
				subCharge = Integer.parseInt(request
						.getParameter("subChargeCode_id"));
			}

			if (request.getParameter(COLLECTION_CENTER_ID) != null
					&& !(request.getParameter(COLLECTION_CENTER_ID).equals("0"))) {
				collectionCenter = Integer.parseInt(request
						.getParameter(COLLECTION_CENTER_ID));
			}
			query = " where dg_sample_collection_header.sample_collection_date between '"
					+ fromDate
					+ "' and '"
					+ toDate
					+ "' and dg_sample_collection_details.`order_status` = 'P' and  dg_sample_collection_details.`maincharge` = '"
					+ mainCharge
					+ "' and dg_sample_collection_details.`subcharge` = '"
					+ subCharge
					+ "' and  dg_sample_collection_details.`collection_center_id` = '"
					+ collectionCenter + "' ";

			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals("0"))) {
				patientType = (request.getParameter(PATIENT_TYPE));
				query = query + " AND dg_orderhd.`patient_type` = '"
						+ patientType + "'";
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = labHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("QUERY", query);
		try {
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport(PACKING_LIST_REPORT), parameters,
						(Connection) detailsMap.get("con"));

			} catch (JRException e) {

				e.printStackTrace();
			}
			response.setContentType("application/pdf");
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

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	// ------------------------------------ Diagnostic Register Doctor Wise
	// --------------------------
	public ModelAndView showDepartmentWiseSummary(HttpServletRequest request,
			HttpServletResponse response) {
		map = labHandlerService.showDepartmentWiseSummary();
		jsp = DEPARTMENR_WISE_SUMMARY;
		jsp += ".jsp";
		title = "Department Wise Summary";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateDepartmentWiseSummary(
			HttpServletRequest request, HttpServletResponse response) {
		String fromDate = null;
		String toDate = null;
		int collectionCenterId = 0;
		String query = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE)));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(TO_DATE)));
			}

			query = " where dg_sample_collection_header.sample_collection_date between '"
					+ fromDate
					+ "' and '"
					+ toDate
					+ "' and dg_sample_collection_header.`order_status` = 'A' ";

			if (request.getParameter(COLLECTION_CENTER_ID) != null
					&& !(request.getParameter(COLLECTION_CENTER_ID).equals("0"))) {
				collectionCenterId = Integer.parseInt(request
						.getParameter(COLLECTION_CENTER_ID));
				query = query
						+ " AND  dg_sample_collection_details.`collection_center_id` = "
						+ collectionCenterId;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = labHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("qry", query);
		try {
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("departmentWiseSummary"), parameters,
						(Connection) detailsMap.get("con"));

			} catch (JRException e) {

				e.printStackTrace();
			}
			response.setContentType("application/pdf");
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

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView getLabReportList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		try {
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				detailsMap.put("serviceNo", serviceNo);
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				detailsMap.put("hinNo", hinNo);
			}
			List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
			List<Object> hinNoList = new ArrayList<Object>();
			String flag = "";

			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (flag.equals("order")) {
				orderNoList = labHandlerService.getOrderNoList(detailsMap);
				map.put("orderNoList", orderNoList);
				jsp = RESPONSE_FOR_LAB_DIAG_NO;

			} else if (flag.equals("hin")) {
				hinNoList = labHandlerService.getHinNoList(serviceNo);
				map.put("hinNoList", hinNoList);

				jsp = "responseForLabPatientName";

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView getLabOrderReportList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		String orderNo = "";
		try {
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				detailsMap.put("serviceNo", serviceNo);
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				detailsMap.put("hinNo", hinNo);
			}
			if (request.getParameter(ORDER_NO) != null
					&& !(request.getParameter(ORDER_NO).equals(""))) {
				orderNo = request.getParameter(ORDER_NO);
				detailsMap.put("orderNo", orderNo);
			}
			List<Object> resultList = new ArrayList<Object>();
			List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
			String flag = "";

			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (flag.equals("result")) {
				resultList = labHandlerService.getResultList(detailsMap);
				map.put("resultList", resultList);
				jsp = RESPONSE_FOR_LAB_RESULT;

			} else if (flag.equals("order")) {
				orderNoList = labHandlerService.getOrderNoList(detailsMap);
				map.put("orderNoList", orderNoList);

				jsp = RESPONSE_FOR_LAB_DIAG_NO;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView showResultEntryReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = RESULT_ENTRY_REPORT_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public ModelAndView showResultEntryReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String orderNo = "";
		String serviceNo = "";
		String hinNo = "";
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (request.getParameter(ORDER_NO) != null) {
			orderNo = request.getParameter(ORDER_NO);
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = labHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("diagNo", orderNo);
		parameters.put("serviceNo", serviceNo);
		parameters.put("hinNo", hinNo);
		try {
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("resultEntryReport"), parameters,
						(Connection) detailsMap.get("con"));

			} catch (JRException e) {

				e.printStackTrace();
			}
			response.setContentType("application/pdf");
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

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView nextForSampleCollection(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailMap = new HashMap<String, Object>();
		String messageTOBeVisibleToTheUser = "";
		HttpSession session = request.getSession();
		String serviceNo = "";
		String hinNo = "";
		Box box = null;
		String pType = "";
		String serPersonFName = "";
		String patientFName = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String adNo = "";
		int chargeCodeId = 0;
		int departmentId = 0;
		int orderId = 0;
		int subChargeCodeId = 0;
		int subGroupId = 0;
		int inpatientId = 0;
		int sampleId = 0;
		String orderType = "";
		int hinId = 0;
		String diagnosisNo = "";
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		if (session.getAttribute("box") != null) {
			box = (Box) session.getAttribute("box");
		}

		if (box.getInt(INPATIENT_ID) != 0) {
			inpatientId = box.getInt(INPATIENT_ID);
			mapForDs.put("inpatientId", inpatientId);
		}
		if (box.get(PATIENT_TYPE) != null
				&& !(box.get(PATIENT_TYPE).equals(""))) {
			pType = box.get(PATIENT_TYPE);
			mapForDs.put("pType", pType);
		}
		if (box.getInt(CHARGE_CODE_ID) != 0) {
			chargeCodeId = box.getInt(request.getParameter(CHARGE_CODE_ID));
			mapForDs.put("chargeCodeId", chargeCodeId);
		}
		if (box.getInt(SUB_CHARGECODE_ID) != 0) {
			subGroupId = box.getInt(request.getParameter(SUB_CHARGECODE_ID));
			mapForDs.put("subGroupId", subGroupId);
		}
		if (box.getInt(SAMPLE_ID) != 0) {
			sampleId = box.getInt(request.getParameter(SAMPLE_ID));
			mapForDs.put("sampleId", sampleId);
		}
		if (box.get(HIN_NO) != null && !(box.get(HIN_NO).equals(""))) {
			hinNo = box.get(HIN_NO);
			mapForDs.put("hinNo", hinNo);
		}
		if (box.get(FROM_DATE) != null && !(box.get(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(box.get(FROM_DATE));
			mapForDs.put("fromDate", fromDate);
		}
		if (box.get(TO_DATE) != null && !(box.get(TO_DATE).equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(box.get(TO_DATE));
			mapForDs.put("toDate", toDate);
		}

		if (box.get(SERVICE_NO) != null && !(box.get(SERVICE_NO).equals(""))) {
			serviceNo = box.get(SERVICE_NO);
			mapForDs.put("serviceNo", serviceNo);
		}

		if (box.get(S_FIRST_NAME) != null
				&& !(box.get(S_FIRST_NAME).equals(""))) {
			serPersonFName = box.get(S_FIRST_NAME);
			mapForDs.put("serPersonFName", serPersonFName);
		}
		if (box.get(P_FIRST_NAME) != null
				&& !(box.get(P_FIRST_NAME).equals(""))) {
			patientFName = box.get(P_FIRST_NAME);
			mapForDs.put("patientFName", patientFName);
		}
		if (box.get(AD_NO) != null && !(box.get(AD_NO).equals(""))) {
			adNo = box.get(AD_NO);
			mapForDs.put("adNo", adNo);
		}

		if (box.getInt(DEPARTMENT_ID) != 0) {
			departmentId = box.getInt(DEPARTMENT_ID);
			mapForDs.put("departmentId", departmentId);
		}

		if (box.getInt(HIN_ID) != 0) {
			hinId = box.getInt(HIN_ID);
			mapForDs.put("hinId", hinId);
		}
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<DgOrderhd> patientDetailList = new ArrayList<DgOrderhd>();
		patientMap = labHandlerService.getPatientDetails(mapForDs);
		patientDetailList = (List<DgOrderhd>) session
				.getAttribute("patientDetailList");
		int orderHeaderId = 0;
		int newOrderId = 0;
		if (request.getParameter(ORDER_BOOKING_ID) != null) {
			orderHeaderId = Integer.parseInt(request
					.getParameter(ORDER_BOOKING_ID));
		}
		if (patientDetailList.size() > 0) {

			for (Iterator iterator = patientDetailList.iterator(); iterator
					.hasNext();) {
				DgOrderhd dgOrderhd = (DgOrderhd) iterator.next();
				newOrderId = dgOrderhd.getId();
				if (newOrderId == orderHeaderId) {
					iterator.remove();
				}
			}
		}

		Map<String, Object> map = new HashMap<String, Object>();
		Set<DgOrderdt> dgOrderDetailSet = new HashSet<DgOrderdt>();
		if (newOrderId != 0) {
			map = labHandlerService
					.getSampleCollectionDetailsForNext(newOrderId);
		}
		if (newOrderId == 0) {
			jsp = "messageForBackCollection" + ".jsp";
			messageTOBeVisibleToTheUser = "No Records Found !!";
		} else if (patientDetailList.size() > 0) {

			jsp = SAMPLE_COLLECTION + ".jsp";
		}
		map.put("newOrderId", newOrderId);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

		/*
		 * Map<String, Object>detailMap = new HashMap<String, Object>(); String
		 * messageTOBeVisibleToTheUser=""; HttpSession session =
		 * request.getSession(); String serviceNo = ""; String hinNo = ""; Box
		 * box = null; String pType=""; String serPersonFName = ""; String
		 * patientFName = ""; Date fromDate = new Date(); Date toDate = new
		 * Date(); String adNo=""; int chargeCodeId = 0; int departmentId=0; int
		 * orderId=0; int subChargeCodeId=0; int subGroupId = 0; int
		 * inpatientId=0; int sampleId= 0 ; String orderType=""; int hinId=0;
		 * String diagnosisNo=""; Map<String, Object> mapForDs = new
		 * HashMap<String, Object>(); if (session.getAttribute("box") != null){
		 * box = (Box) session.getAttribute("box"); }
		 * //System.out.println("box  in next method"+box);
		 * 
		 * if(box.getInt(INPATIENT_ID) != 0 ){ inpatientId=
		 * box.getInt(INPATIENT_ID) ; mapForDs.put("inpatientId", inpatientId);
		 * } if(box.get(PATIENT_TYPE) != null &&
		 * !(box.get(PATIENT_TYPE).equals(""))){ pType = box.get(PATIENT_TYPE);
		 * mapForDs.put("pType", pType); } if(box.getInt(CHARGE_CODE_ID) != 0){
		 * chargeCodeId = box.getInt(request.getParameter(CHARGE_CODE_ID)) ;
		 * mapForDs.put("chargeCodeId", chargeCodeId); }
		 * if(box.getInt(SUB_CHARGECODE_ID) != 0 ){ subGroupId=
		 * box.getInt(request.getParameter(SUB_CHARGECODE_ID)) ;
		 * mapForDs.put("subGroupId", subGroupId); } if(box.getInt(SAMPLE_ID) !=
		 * 0){ sampleId= box.getInt(request.getParameter(SAMPLE_ID)) ;
		 * mapForDs.put("sampleId", sampleId); } if(box.get(HIN_NO) != null &&
		 * !(box.get(HIN_NO).equals(""))){ hinNo = box.get(HIN_NO);
		 * mapForDs.put("hinNo", hinNo); } if(box.get(FROM_DATE) != null &&
		 * !(box.get(FROM_DATE).equals(""))){ fromDate =
		 * HMSUtil.dateFormatterDDMMYYYY(box.get(FROM_DATE));
		 * mapForDs.put("fromDate", fromDate); } if(box.get(TO_DATE) != null &&
		 * !(box.get(TO_DATE).equals(""))){ toDate=
		 * HMSUtil.dateFormatterDDMMYYYY(box.get(TO_DATE));
		 * mapForDs.put("toDate", toDate); }
		 * 
		 * if(box.get(SERVICE_NO) != null && !(box.get(SERVICE_NO).equals(""))){
		 * serviceNo = box.get(SERVICE_NO); mapForDs.put("serviceNo",
		 * serviceNo); }
		 * 
		 * if(box.get(S_FIRST_NAME) != null &&
		 * !(box.get(S_FIRST_NAME).equals(""))){ serPersonFName =
		 * box.get(S_FIRST_NAME); mapForDs.put("serPersonFName",
		 * serPersonFName); } if(box.get(P_FIRST_NAME) != null &&
		 * !(box.get(P_FIRST_NAME).equals(""))){ patientFName =
		 * box.get(P_FIRST_NAME); mapForDs.put("patientFName", patientFName); }
		 * if(box.get(AD_NO) != null && !(box.get(AD_NO).equals(""))){ adNo =
		 * box.get(AD_NO); mapForDs.put("adNo", adNo); }
		 * 
		 * if(box.getInt(DEPARTMENT_ID) != 0 ){
		 * departmentId=box.getInt(DEPARTMENT_ID) ; mapForDs.put("departmentId",
		 * departmentId); }
		 * 
		 * if(box.getInt(HIN_ID) != 0){ hinId=box.getInt(HIN_ID) ;
		 * mapForDs.put("hinId", hinId); } if(box.get(PATIENT_TYPE) != null &&
		 * !(box.get(PATIENT_TYPE).equals(""))){ orderType =
		 * box.get(PATIENT_TYPE); mapForDs.put("orderType", orderType);
		 * //System.out.println("orderType---"+hinNo); }
		 * 
		 * Map<String, Object> patientMap = new HashMap<String, Object>();
		 * List<DgOrderhd> patientList = new ArrayList<DgOrderhd>(); patientMap
		 * = labHandlerService.getPatientDetails(mapForDs); patientList =
		 * (List<DgOrderhd>)session.getAttribute("patientList"); int
		 * orderHeaderId = 0; int newOrderId=0;
		 * if(request.getParameter(ORDER_BOOKING_ID) != null){ orderHeaderId =
		 * Integer.parseInt(request.getParameter(ORDER_BOOKING_ID));
		 * //System.out.println("orderId----"+ORDER_BOOKING_ID); }
		 * if(patientList.size()>0){
		 * 
		 * for (Iterator iterator = patientList.iterator(); iterator.hasNext();)
		 * { DgOrderhd dgOrderhd = (DgOrderhd) iterator.next();
		 * newOrderId=dgOrderhd.getId(); if(newOrderId== orderHeaderId){
		 * iterator.remove(); } } }
		 * 
		 * Map<String, Object> map = new HashMap<String, Object>(); if(
		 * newOrderId != 0){ map =
		 * labHandlerService.getSampleCollectionDetailsForNext(newOrderId); }
		 * if(newOrderId == 0){ jsp = "messageForBackCollection"+".jsp";
		 * messageTOBeVisibleToTheUser = "No Records Found !!"; }else
		 * if(patientList.size()>0){
		 * 
		 * jsp = SAMPLE_COLLECTION+".jsp"; } map.put("orderHeaderId",
		 * orderHeaderId); map.put("messageTOBeVisibleToTheUser",
		 * messageTOBeVisibleToTheUser); map.put("contentJsp",jsp); return new
		 * ModelAndView("index", "map", map);
		 */
	}

	public ModelAndView nextForSampleValidation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailMap = new HashMap<String, Object>();
		String messageTOBeVisibleToTheUser = "";
		HttpSession session = request.getSession();
		String serviceNo = "";
		String hinNo = "";
		Box box = null;
		String pType = "";
		String serPersonFName = "";
		String patientFName = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String adNo = "";
		int chargeCodeId = 0;
		int departmentId = 0;
		int orderId = 0;
		int subChargeCodeId = 0;
		int subGroupId = 0;
		int inpatientId = 0;
		int sampleId = 0;
		String orderType = "";
		int hinId = 0;
		String diagnosisNo = "";
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		if (session.getAttribute("box") != null) {
			box = (Box) session.getAttribute("box");
		}

		if (box.getInt(INPATIENT_ID) != 0) {
			inpatientId = box.getInt(INPATIENT_ID);
			mapForDs.put("inpatientId", inpatientId);
		}
		if (box.get(PATIENT_TYPE) != null
				&& !(box.get(PATIENT_TYPE).equals(""))) {
			pType = box.get(PATIENT_TYPE);
			mapForDs.put("pType", pType);
		}
		if (box.getInt(CHARGE_CODE_ID) != 0) {
			chargeCodeId = box.getInt(request.getParameter(CHARGE_CODE_ID));
			mapForDs.put("chargeCodeId", chargeCodeId);
		}
		if (box.getInt(SUB_CHARGECODE_ID) != 0) {
			subGroupId = box.getInt(request.getParameter(SUB_CHARGECODE_ID));
			mapForDs.put("subGroupId", subGroupId);
		}
		if (box.getInt(SAMPLE_ID) != 0) {
			sampleId = box.getInt(request.getParameter(SAMPLE_ID));
			mapForDs.put("sampleId", sampleId);
		}
		if (box.get(HIN_NO) != null && !(box.get(HIN_NO).equals(""))) {
			hinNo = box.get(HIN_NO);
			mapForDs.put("hinNo", hinNo);
		}
		if (box.get(FROM_DATE) != null && !(box.get(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(box.get(FROM_DATE));
			mapForDs.put("fromDate", fromDate);
		}
		if (box.get(TO_DATE) != null && !(box.get(TO_DATE).equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(box.get(TO_DATE));
			mapForDs.put("toDate", toDate);
		}

		if (box.get(SERVICE_NO) != null && !(box.get(SERVICE_NO).equals(""))) {
			serviceNo = box.get(SERVICE_NO);
			mapForDs.put("serviceNo", serviceNo);
		}

		if (box.get(S_FIRST_NAME) != null
				&& !(box.get(S_FIRST_NAME).equals(""))) {
			serPersonFName = box.get(S_FIRST_NAME);
			mapForDs.put("serPersonFName", serPersonFName);
		}
		if (box.get(P_FIRST_NAME) != null
				&& !(box.get(P_FIRST_NAME).equals(""))) {
			patientFName = box.get(P_FIRST_NAME);
			mapForDs.put("patientFName", patientFName);
		}
		if (box.get(AD_NO) != null && !(box.get(AD_NO).equals(""))) {
			adNo = box.get(AD_NO);
			mapForDs.put("adNo", adNo);
		}

		if (box.getInt(DEPARTMENT_ID) != 0) {
			departmentId = box.getInt(DEPARTMENT_ID);
			mapForDs.put("departmentId", departmentId);
		}

		if (box.getInt(HIN_ID) != 0) {
			hinId = box.getInt(HIN_ID);
			mapForDs.put("hinId", hinId);
		}
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<DgSampleCollectionHeader> patientDeatilList = new ArrayList<DgSampleCollectionHeader>();
		patientMap = labHandlerService.getPatientDetailsForValidation(mapForDs);
		patientDeatilList = (List<DgSampleCollectionHeader>) session
				.getAttribute("patientDeatilList");
		int sampleCollectionHeaderId = 0;
		int newSampleId = 0;
		if (request.getParameter("sampleCollectionHeaderId") != null) {
			sampleCollectionHeaderId = Integer.parseInt(request
					.getParameter("sampleCollectionHeaderId"));
		}
		if (patientDeatilList.size() > 0) {

			for (Iterator iterator = patientDeatilList.iterator(); iterator
					.hasNext();) {
				DgSampleCollectionHeader dgSampleCollectionHeader = (DgSampleCollectionHeader) iterator
						.next();
				newSampleId = dgSampleCollectionHeader.getId();
				if (newSampleId == sampleCollectionHeaderId) {
					iterator.remove();
				}
			}
		}

		Map<String, Object> map = new HashMap<String, Object>();
		Set<DgSampleCollectionDetails> dgSampleDetailSet = new HashSet<DgSampleCollectionDetails>();
		if (newSampleId != 0) {
			map = labHandlerService
					.getSampleValidationDetailsForNext(newSampleId);
		}
		if (newSampleId == 0) {
			jsp = "messageForBackValidation" + ".jsp";
			messageTOBeVisibleToTheUser = "No Records Found !!";
		} else if (patientDeatilList.size() > 0) {

			jsp = SAMPLE_ACCEPTANCE + ".jsp";
		}
		map.put("newSampleId", newSampleId);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView nextForSampleValidationLab(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();

		// //////////////////////////
		Map<String, Object> detailMap = new HashMap<String, Object>();
		String messageTOBeVisibleToTheUser = "";
		Box box = null;
		String serviceNo = "";
		String hinNo = "";

		String pType = "";
		String serPersonFName = "";
		String patientFName = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String adNo = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		int hinId = 0;
		String diagnosisNo = "";
		int deptId = 0;
		int uid = 0;

		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			uid = user.getId();
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();

		String nextCombinedIds = "";
		String[] idsArray = new String[0];
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			mapForDs.put("deptId", deptId);
		}
		if (request.getParameter("nextCombinedIdsForSampleValidationLab") != null) {
			nextCombinedIds = request
					.getParameter("nextCombinedIdsForSampleValidationLab");
			mapForDs.put("resultId", nextCombinedIds);
		}
		if (!nextCombinedIds.equals("")) {
			map = labHandlerService.getSampleValidationDetailsLab(
					nextCombinedIds, uid, deptId);
			jsp = SAMPLE_ACCEPTANCE_LAB + ".jsp";
		} else {
			jsp = "messageForBackValidationLab" + ".jsp";
			messageTOBeVisibleToTheUser = "No Records Found.";
		}
		map.put("combinedIds", nextCombinedIds);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getUpdatableOrderListJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		String orderNo = "";
		int deptId = 0;
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		if (request.getParameter("orderNo") != null) {
			orderNo = request.getParameter("orderNo");
			mapForDs.put("orderNo", orderNo);
		}

		if (session.getAttribute("deptId") != null)
			deptId = (Integer) session.getAttribute("deptId");
		mapForDs.put("deptId", deptId);
		detailsMap = labHandlerService.getDetailsForOrderSearch();
		if (request.getParameter("orderNo") != null
				&& !request.getParameter("orderNo").equalsIgnoreCase("")) {
			patientMap = labHandlerService
					.getUpdatableOrdersGridForSingleOrder(mapForDs);
		} else {
			patientMap = labHandlerService.getUpdatableOrdersGrid(mapForDs);
		}
		jsp = "updatableOrderList.jsp";
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchPatientForOrderUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serPersonFName = "";
		String patientFName = "";
		String orderStatus = "";
		String serviceNo = "";
		String hinNo = "";
		String adNo = "";
		String flag = "";
		String pType = "";
		int chargeCodeId = 0;
		int departmentId = 0;
		int inpatientId = 0;
		int subGroupId = 0;
		int sampleId = 0;
		int hinId = 0;
		String deptName = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();

		try {

			if (session.getAttribute("deptName") != null)
				deptName = (String) session.getAttribute("deptName");
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				mapForDs.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
				mapForDs.put("toDate", toDate);
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				pType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("pType", pType);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));
				mapForDs.put("chargeCodeId", chargeCodeId);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subGroupId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subGroupId", subGroupId);
			}
			if (request.getParameter(SAMPLE_ID) != null
					&& !(request.getParameter(SAMPLE_ID).equals("0"))) {
				sampleId = Integer.parseInt(request.getParameter(SAMPLE_ID));
				mapForDs.put("sampleId", sampleId);
			}
			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				mapForDs.put("departmentId", departmentId);
			}
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(ORDER_STATUS) != null
					&& !(request.getParameter(ORDER_STATUS).equals("0"))) {
				orderStatus = request.getParameter(ORDER_STATUS);
				mapForDs.put("orderStatus", orderStatus);
			}
			int orderId = 0;
			if (request.getParameter(ORDER_BOOKING_ID) != null
					&& !(request.getParameter(ORDER_BOOKING_ID).equals("0"))) {
				orderId = new Integer(request.getParameter(ORDER_BOOKING_ID));
				mapForDs.put("orderId", orderId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = labHandlerService.getPatientDetails(mapForDs);
		String diagSeqNo = "";
		String jsp = "";
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDetailList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDetailList");

		}
		map = labHandlerService.getSampleCollectionDetails(mapForDs);
		if (map != null && map.get("dgOrderhdList") != null) {
			if (diagSeqNo != null) {
				map.put("diagSeqNo", diagSeqNo);
			}
			jsp = "updatableOrderList" + ".jsp";
		} else {
			detailsMap = labHandlerService.getDetailsForSearch(detailsMap);
			jsp = "updatableOrderList" + ".jsp";
		}
		map.put("box", box);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * public ModelAndView showSampleNo(HttpServletRequest
	 * request,HttpServletResponse response) { Map<String, Object> map = new
	 * HashMap<String, Object>();
	 * 
	 * String sampleSeqNo = "" ; int inc = 0; sampleSeqNo =
	 * labHandlerService.getSampleSeqForDisplay("SN");
	 * if(request.getParameter("inc")!= null){ inc =
	 * Integer.parseInt(request.getParameter("inc")); map.put("inc", inc); } jsp
	 * = RESPONCE_FOR_SAMPLE_NO; map.put("sampleSeqNo" , sampleSeqNo);
	 * map.put("contentJsp", jsp); map.put("title", title); return new
	 * ModelAndView(jsp, "map", map); }
	 */
	// -------------Jasper Compiled Report
	// --------------------------------------
	private JasperReport getCompiledReport(String fileName) throws JRException {

		File reportFile = new File(getServletContext().getRealPath(
				"/reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile.getPath());

		return jasperReport;
	}

	public ModelAndView cancelOrderBooking(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> orderNoDetailMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}

		HttpSession session = request.getSession();
		String deptName = "";
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		mapForDs.put("pType", "OP");
		orderNoDetailMap = labHandlerService
				.getOrderNoForCancelOrderList(mapForDs);

		String jsp = CANCEL_ORDER_BOOKING_JSP;
		jsp += ".jsp";

		map.put("orderNoDetailMap", orderNoDetailMap);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getPatientNameForUpdateOrderBooking(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		String flag = "";
		List<Patient> patientList = new ArrayList<Patient>();
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			map.put("flag", flag);
		}
		patientList = labHandlerService.getPatientName(serviceNo);
		if (patientList.size() > 0) {
			map.put("patientList", patientList);
		}
		String jsp = "populatePatientNameUpdateOrderBooking";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getOrderNoForCancelOrderBooking(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> orderNoDetailMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}
		HttpSession session = request.getSession();

		Date fromDate = new Date();
		Date toDate = new Date();

		String serviceNo = "";
		String hinNo = "";
		String deptName = "";
		String serPersonFName = "";
		String patientFName = "";
		String adNo = "";
		String pType = "";

		List<Visit> visitNoList = new ArrayList<Visit>();
		List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
		// /////////////////////////////////////////////////////
		try {
			if (session.getAttribute("deptName") != null) {
				deptName = (String) session.getAttribute("deptName");
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				mapForDs.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
				mapForDs.put("toDate", toDate);
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				pType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("pType", pType);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		orderNoDetailMap = labHandlerService
				.getOrderNoForCancelOrderList(mapForDs);

		String jsp = CANCEL_ORDER_BOOKING_JSP;
		jsp += ".jsp";
		map.put("orderNoDetailMap", orderNoDetailMap);
		map.put("orderNoList", orderNoList);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView viewTestDetailsForCanceling(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		String deptName = "";
		String jsp = "";

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}

		int dgOrderHdId = 0;
		if (request.getParameter("dgOrderHdId") != null) {
			dgOrderHdId = Integer.parseInt(request.getParameter("dgOrderHdId"));
			mapForDs.put("dgOrderHdId", dgOrderHdId);
		}

		detailsMap = labHandlerService.getTestDetailsForCancel(mapForDs);

		jsp = VIEW_TEST_DETAILS_FOR_CANCEL;
		jsp += ".jsp";

		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		map.put("detailsMap", detailsMap);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitCancelSelectedTests(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> cancelDetailsMap = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		String deptName = "";
		String jsp = "";

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}

		Box box = HMSUtil.getBox(request);
		Vector allTestIds = box.getVector(ALL_TEST_IDS);
		Vector idetifierOfId = box.getVector("idetifierOfId");
		Vector dgAllhdIdList = box.getVector(ORDER_BOOKING_ID);
		Vector chargeCodeIdList = box.getVector(CHARGE_CODE_ID);
		String dgOrderhdCommonId = box.getString("orderHeaderId");

		List<Integer> dgOrderdtIdList = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionDetailLabIdList = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionDetailIdList = new ArrayList<Integer>();
		List<Integer> cancelledChargeCodeIds = new ArrayList<Integer>();

		Set<Integer> dgSampleCollectionHeaderLabIdSet = new LinkedHashSet<Integer>();

		String dgOrderhdId = "";
		String dgSampleCollectionhdId = "";

		int counter = Integer.parseInt(request.getParameter("counter"));

		for (int i = 1; i <= counter; i++) {
			if (request.getParameter("cancelCheckSelected" + i) != null
					&& !request.getParameter("cancelCheckSelected" + i).equals(
							"")) {
				if ((idetifierOfId.get(i - 1)).toString().equalsIgnoreCase(
						"dgOrderdtId")) {
					dgOrderdtIdList.add(Integer.parseInt((String) allTestIds
							.get(i - 1)));
					dgOrderhdId = (String) dgAllhdIdList.get(i - 1);
				} else if ((idetifierOfId.get(i - 1)).toString()
						.equalsIgnoreCase("dgSampleCollectionDetailLabId")) {
					dgSampleCollectionDetailLabIdList.add(Integer
							.parseInt((String) allTestIds.get(i - 1)));
					dgSampleCollectionHeaderLabIdSet.add(Integer
							.parseInt((String) dgAllhdIdList.get(i - 1)));

				} else if ((idetifierOfId.get(i - 1)).toString()
						.equalsIgnoreCase("dgSampleCollectionDetailId")) {
					dgSampleCollectionDetailIdList.add(Integer
							.parseInt((String) allTestIds.get(i - 1)));
					dgSampleCollectionhdId = (String) dgAllhdIdList.get(i - 1);
					cancelledChargeCodeIds.add(Integer
							.parseInt((String) chargeCodeIdList.get(i - 1)));
				}
			}
		}
		mapForDs.put("dgOrderhdCommonId", dgOrderhdCommonId);
		mapForDs.put("dgOrderhdId", dgOrderhdId);
		mapForDs.put("dgSampleCollectionHeaderLabIdSet",
				dgSampleCollectionHeaderLabIdSet);
		mapForDs.put("dgSampleCollectionhdId", dgSampleCollectionhdId);

		mapForDs.put("dgOrderdtIdList", dgOrderdtIdList);
		mapForDs.put("dgSampleCollectionDetailLabIdList",
				dgSampleCollectionDetailLabIdList);
		mapForDs.put("dgSampleCollectionDetailIdList",
				dgSampleCollectionDetailIdList);
		mapForDs.put("cancelledChargeCodeIds", cancelledChargeCodeIds);

		if (dgOrderdtIdList.size() > 0) {
			cancelDetailsMap = labHandlerService
					.cancelTestsInDgOrderdt(mapForDs);
		}
		if (dgSampleCollectionDetailLabIdList.size() > 0) {
			cancelDetailsMap = labHandlerService
					.cancelTestsInDgSampleCollectionDetailLab(mapForDs);
		}
		if (dgSampleCollectionDetailIdList.size() > 0) {
			cancelDetailsMap = labHandlerService
					.cancelTestsInDgSampleCollectionDetail(mapForDs);
		}

		jsp = CANCEL_ORDER_BOOKING_JSP + ".jsp";
		map.put("deptName", deptName);

		map.put("detailsMap", detailsMap);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getPatientDetailsForUpdate(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		int orderId = 0;
		int visitId = 0;
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");

		if (request.getParameter(ORDER_NO) != null) {
			orderId = Integer.parseInt(request.getParameter(ORDER_NO));
			// map.put("orderNo", orderNo);
		}
		if (request.getParameter("visitId") != null) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
			// map.put("visitId", visitId);
		}
		if (orderId != 0) {

			map = labHandlerService.getDgOrderHd(orderId);
			// map =
			// labHandlerService.showOrderBookingForInvestigationJsp(orderNo);
			// String orderSeqNo = "";
			// orderSeqNo = labHandlerService.getOrderSeqForDisplay("ON");
			// if(orderSeqNo != null){
			// map.put("orderSeqNo", orderSeqNo);
			// }
		}
		detailsMap = labHandlerService.getMainAndSubCharge();
		String includedJsp = INVESTIGATION_ORDER_BOOKING_FOR_UPDATE + ".jsp";

		jsp = CANCEL_ORDER_BOOKING_JSP + ".jsp";
		map.put("deptName", deptName);
		map.put("includedJsp", includedJsp);
		map.put("detailsMap", detailsMap);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * public ModelAndView showTemplateHelpJsp(HttpServletRequest request
	 * ,HttpServletResponse response){ Map<String, Object> map = new
	 * HashMap<String, Object>();
	 * 
	 * String templateHelpPage = "";
	 * 
	 * templateHelpPage = "Template help Modified.htm";
	 * 
	 * map.put("message", message);
	 * map.put("templateHelpPage",templateHelpPage); map.put("title", title);
	 * 
	 * return new ModelAndView("index","map", map); }
	 */
	public ModelAndView showTemplateHelpJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String templateFileName = "Template help";
		templateFileName = templateFileName + ".doc";
		try {
			response.setContentType("application/msword");
			response.setHeader("Content-Disposition", "inline; filename="
					+ templateFileName);
			File f = new File(getServletContext().getRealPath(
					"/templateHelp/Template help.doc"));
			InputStream in = new FileInputStream(f);
			ServletOutputStream outs = response.getOutputStream();
			int bit = 256;
			while ((bit) >= 0) {
				bit = in.read();
				outs.write(bit);
			}
			outs.flush();
			outs.close();
			in.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return null;
	}

	public ModelAndView getOrderNoListForOrderStatus(
			HttpServletRequest request, HttpServletResponse response) {

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}
		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();

		int deptId = (Integer) session.getAttribute("deptId");
		int inPatientId = Integer.parseInt(request.getParameter("parent"));
		String deptName = request.getParameter("deptName");

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap.put("inPatientId", inPatientId);
		detailsMap.put("deptId", deptId);

		dgOrderhdList = labHandlerService.getOrderNoList(detailsMap);
		
		/**
		 * Get Physiotherapy details of inpatients
		 * Code By Ritu
		 */
		map = labHandlerService.getPhysiotherapyList(detailsMap);
		
		
		map.put("inPatientId", inPatientId);
		map.put("dgOrderhdList", dgOrderhdList);
		map.put("deptName", deptName);
		map.put("message", message);
		

		jsp = ORDER_STATUS_FOR_WARD_MANAGEMENT;
		jsp += ".jsp";
		title = "OrderBooking";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	
	}

	public ModelAndView viewAllTestForOrderNo(HttpServletRequest request,
			HttpServletResponse response) {
		List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> orderDetailMap = new HashMap<String, Object>();

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}

		HttpSession session = request.getSession();
		String deptName = "";
		String jsp = "";

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		//int dgOrderHdId = 0;
		int inPatientId = 0;
	/*	if (request.getParameter("dgOrderHdId") != null) {
			dgOrderHdId = Integer.parseInt(request.getParameter("dgOrderHdId"));
			mapForDs.put("dgOrderHdId", dgOrderHdId);
		}*/
		if (request.getParameter("hinId") != null) {
			int hinId = Integer.parseInt(request.getParameter("hinId"));
			mapForDs.put("hinId", hinId);
			map.put("hinId", hinId);
		}
		if (request.getParameter(INPATIENT_ID) != null) {
			inPatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			mapForDs.put("inPatientId", inPatientId);
		}

		// orderNoList = labHandlerService.getOrderNoList(mapForDs);

		//orderDetailMap = labHandlerService.getOrderDtMap(mapForDs);

		//jsp = VIEW_TEST_DETAILS_FOR_ORDER_NO;
		jsp = VIEW_TEST_DETAILS_FOR_HIN_ID;
		
	/*	map.put("orderDetailMap", orderDetailMap);
		map.put("orderNoList", orderNoList);*/
		
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView viewAllTestForOrderNo1(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Patient list = new Patient();
		List<DgOrderdt> dgOrderDtList = new ArrayList<DgOrderdt>();
		List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();
		List<DgSampleCollectionDetails> dgSampleCollectionDetailsList = new ArrayList<DgSampleCollectionDetails>();
		 List<Integer> sampleCollectionIdDtIds = new ArrayList<>();
		 List<Integer> resultEntryOrderDtIds = new ArrayList<>();
		Box box = HMSUtil.getBox(request);
		map.clear();
		box.put("hospitalId", hospitalId);

	
		map.put("box", box);
		map.put("PN", box.getInt("PN"));
		map.put("hinId", box.getInt("hinId"));
		
		map = labHandlerService.getOrderDtMap(map);

		if (map.get("dgOrderDtList") != null) {
			dgOrderDtList = (ArrayList) map.get("dgOrderDtList");
		}
		if (map.get("dgResultEntryDetailList") != null) {
			dgResultEntryDetailList = (ArrayList) map.get("dgResultEntryDetailList");
		}
		if (map.get("dgSampleCollectionDetailsList") != null) {
			dgSampleCollectionDetailsList = (ArrayList) map.get("dgSampleCollectionDetailsList");
		}

		if (map.get("sampleCollectionIdDtIds") != null) {
			sampleCollectionIdDtIds = (ArrayList) map.get("sampleCollectionIdDtIds");
		}
		if (map.get("resultEntryOrderDtIds") != null) {
			resultEntryOrderDtIds = (ArrayList) map.get("resultEntryOrderDtIds");
		}
		
		int totalRecords = 0;
		if (map.get("totalRecords") != null) {
			totalRecords = (Integer) map.get("totalRecords");
		}
		try {
			PrintWriter pw = response.getWriter();

			pw.write("[");
			int counter = 1;
			int i = 0;
			String status ="";
			String result = null;
			String UOM = null;
			String normalRange = null;
			String resultType = null;
			String orderStatus =null;
			String confidential = null;
			String rejectedReason = null;
			int resultHeaderId = 0;
			int orderNo =0;
			for (DgOrderdt dgOrderDt : dgOrderDtList) {
				 result = "";
				 UOM = "";
				 normalRange = "";
				 resultType="";
				status = "";
				orderStatus = "";
				confidential ="";
				rejectedReason = "";
				 orderNo =0;
				if(dgOrderDt.getOrderStatus().equalsIgnoreCase("p") && !sampleCollectionIdDtIds.contains(dgOrderDt.getId()))
				//if(dgOrderDt.getOrderStatus().equalsIgnoreCase("p"))
					status="Pending";
				else
				{
					if(resultEntryOrderDtIds.contains(dgOrderDt.getId()))
							{ 
						orderNo = dgOrderDt.getOrderhd().getId();
							Set<DgSampleCollectionDetails> dgCollection= dgOrderDt.getDgSampleCollectionDetails();
							for(DgSampleCollectionDetails dg:dgCollection)
							{
								Set<DgResultEntryDetail> dgResult= dg.getDgResultEntryDetails();
								for(DgResultEntryDetail dgResultEntryDetail:dgResult)
								{
								  if( dgResultEntryDetail.getResultDetailStatus().equalsIgnoreCase("P"))
									status="Provisional Result/Report";
									else if( dgResultEntryDetail.getResultDetailStatus().equalsIgnoreCase("A"))
									status="Result Status Validated";
								  
								  if(dgResultEntryDetail.getResultType().equalsIgnoreCase("s")){
									     result = dgResultEntryDetail.getResult();
										 UOM = dgResultEntryDetail.getUom()!=null ?dgResultEntryDetail.getUom().getUomName():"";
										 normalRange = dgResultEntryDetail.getInvestigation().getMinNormalValue() +"-"+ dgResultEntryDetail.getInvestigation().getMaxNormalValue();
								  }
								  else{
									  if(dgResultEntryDetail.getResultType().equalsIgnoreCase("m")){
									  resultType="m"; resultHeaderId = dgResultEntryDetail.getResultEntry().getId();}
									  else{
										  resultType="t"; resultHeaderId = dgResultEntryDetail.getId();}
									  orderStatus = dgResultEntryDetail.getResultDetailStatus();
									  if(dgResultEntryDetail.getInvestigation().getConfidential()!=null && !dgResultEntryDetail.getInvestigation().getConfidential().isEmpty())
									  confidential =dgResultEntryDetail.getInvestigation().getConfidential();
									  else
										  confidential="n";
										  
									 
								  }
								  break;
								}
						     }
						}
					
					else if(sampleCollectionIdDtIds.contains(dgOrderDt.getId()))
					{
						Set<DgSampleCollectionDetails> colSet= dgOrderDt.getDgSampleCollectionDetails();
						for( DgSampleCollectionDetails dgSampleCollectionDetails: colSet){
							if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("p"))
							{
								if(dgSampleCollectionDetails.getRejected() != null &&
										dgSampleCollectionDetails.getRejected().equalsIgnoreCase("y") ){
									status ="Sample is Rejected";
									rejectedReason = dgSampleCollectionDetails.getReason() != null?dgSampleCollectionDetails.getReason():"";
									
								}
							   else	
								status ="Pending For Sample Validation";
							}
								
							else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("E"))
								status="Result Entered";
							else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("A"))
								status="Sample Pending For Result Entry";
							else if(dgSampleCollectionDetails.getOrderStatus().equalsIgnoreCase("X"))
								status="Investigation Cancelled";
						}
					}
					
					/*for(DgSampleCollectionDetails collection: dgSampleCollectionDetailsList)
					{
						if(dgOrderDt.getId()==collection.getOrderdt().getId())
						{
							if(collection.getOrderStatus().equalsIgnoreCase("A"))
							{
								status ="Pending For Sample Validation";
							}
						}
					}*/
				}
				
				if (counter != dgOrderDtList.size()) {
					list = dgOrderDt.getOrderhd().getHin();
					String servicepatientName = "";
					String referredByName = "";
					String referredToName = "";
					if (list.getPFirstName() != null) {
						servicepatientName = list.getPFirstName();
					}

					if (list.getPMiddleName() != null) {
						servicepatientName = servicepatientName + " "
								+ list.getPMiddleName();
					}
					if (list.getPLastName() != null) {
						servicepatientName = servicepatientName + " "
								+ list.getPLastName();
					}
				
					result = result.trim().replace('\'', '#');
					result = result.trim().replace('"', '$');
					System.out.println("result"+result);
					pw.write("{\"Id\": \""
							+ dgOrderDt.getId()
		
							+ "\",\"name\": \""
							+ servicepatientName
							+ "\",\"name\": \""
							+ dgOrderDt.getInvestigation().getInvestigationName()
							+ "\",\"modality\": \""
							+ dgOrderDt.getChargeCode().getSubChargecode().getSubChargecodeName()
								+ "\",\"orderno\": \""
							+ dgOrderDt.getOrderhd().getOrderNo()
								+ "\",\"orderDate\": \""
							+ HMSUtil.convertDateToStringTypeDateOnly(dgOrderDt.getOrderhd().getOrderDate())
								+ "\",\"prescribedBy\": \""
							+ dgOrderDt.getOrderhd().getDepartment().getDepartmentName()
								+ "\",\"result\": \""
							+ result
								+ "\",\"UOM\": \""
							+ UOM
								+ "\",\"normalRange\": \""
							+ normalRange
									+ "\",\"investigationStatus\": \""
							+ status
							+ "\",\"resultType\": \""
							+ resultType
							+ "\",\"resultHeaderId\": \""
							+ resultHeaderId
							+ "\",\"orderStatus\": \""
							+ orderStatus
							+ "\",\"rejectedReason\": \""
							+ rejectedReason
							+ "\",\"confidential\": \""
							+ confidential
							+ "\",\"orderNo\": \""+ orderNo
							+ "\",\"totalRecords\":\"" + totalRecords + "\"},");
					 
				} else {
					list = dgOrderDt.getOrderhd().getHin();
					String servicepatientName = "";
					String referredByName = "";
					String referredToName = "";
					if (list.getPFirstName() != null) {
						servicepatientName = list.getPFirstName();
					}

					if (list.getPMiddleName() != null) {
						servicepatientName = servicepatientName + " "
								+ list.getPMiddleName();
					}
					if (list.getPLastName() != null) {
						servicepatientName = servicepatientName + " "
								+ list.getPLastName();
					}

					result = result.trim().replace("\"", "\"");
					System.out.println("result"+result);
					pw.write("{\"Id\": \""
							+ dgOrderDt.getId()
					
							+ "\",\"name\": \""
							+ dgOrderDt.getInvestigation().getInvestigationName()
							+ "\",\"modality\": \""
							+ dgOrderDt.getChargeCode().getSubChargecode().getSubChargecodeName()
								+ "\",\"orderno\": \""
							+ dgOrderDt.getOrderhd().getOrderNo()
								+ "\",\"orderDate\": \""
							+ HMSUtil.convertDateToStringTypeDateOnly(dgOrderDt.getOrderhd().getOrderDate())
								+ "\",\"prescribedBy\": \""
							+ dgOrderDt.getOrderhd().getDepartment().getDepartmentName()
								+ "\",\"result\": \""
							+ result
								+ "\",\"UOM\": \""
							+ UOM
								+ "\",\"normalRange\": \""
							+ normalRange
							+ "\",\"resultType\": \""
							+ resultType
							+ "\",\"resultHeaderId\": \""
							+ resultHeaderId
							+ "\",\"orderStatus\": \""
							+ orderStatus
							+ "\",\"confidential\": \""
							+ confidential
							+ "\",\"rejectedReason\": \""
							+ rejectedReason
									+ "\",\"investigationStatus\": \""
							+ status
							
						/*	+ "\",\"referredByName\": \""
							+ referredByName
							+ "\",\"referredToName\": \""
							+ referredToName
							+ "\",\"maritalStatus\": \""
							+ (list.getMaritalStatus() != null ? list
									.getMaritalStatus().getMaritalStatusName()
									: "-")
							+ "\",\"contactNo\":\""
							+ (list.getMobileNumber() != null ? list
									.getMobileNumber() : "")*/
							+ "\",\"orderNo\": \""+ orderNo
							+ "\",\"totalRecords\":\"" + totalRecords + "\"}");

				}

				counter++;
				i++;
				
			}

			pw.write("]");

		}

		catch (Exception e) {
			dgOrderDtList.clear();

			e.printStackTrace();
		}
		dgOrderDtList.clear();
		return null;

	}
	public ModelAndView selectViewAccOrderStatus(HttpServletRequest request,
			HttpServletResponse response) {

		List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> resultTypeDetailMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String appendedHtml = "";

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}

		HttpSession session = request.getSession();
		String deptName = "";
		String jsp = "";
		String resultType = "";
		String orderStatus = "";
		String result = "";
		Integer deptId = 0;
		String confidential = "";
		String rejectedStatus = "";

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		int dgMasInvestigationId = 0;
		int dgOrderdtId = 0;
		int dgResultEntryDetailId = 0;
		int dgResultEntryDetailLabId = 0;
		int dgSampleCollectionDetailLabId = 0;
		int dgResultEntryHeaderLabId = 0;
		int dgResultEntryHeaderSenLabId = 0;
		String rejReason = "";

		DgResultEntryDetail dgResultEntryDetail = null;
		List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();

		if (request.getParameter("dgMasInvestigationId") != null) {
			dgMasInvestigationId = Integer.parseInt(request
					.getParameter("dgMasInvestigationId"));
			mapForDs.put("dgMasInvestigationId", dgMasInvestigationId);
		}
		if (request.getParameter("resultType") != null) {
			resultType = request.getParameter("resultType");
			mapForDs.put("resultType", resultType);
		}
		if (request.getParameter("dgOrderdtId") != null) {
			dgOrderdtId = Integer.parseInt(request.getParameter("dgOrderdtId"));
			mapForDs.put("dgOrderdtId", dgOrderdtId);
		}
		if (request.getParameter("dgResultEntryDetailLabId") != null) {
			dgResultEntryDetailLabId = Integer.parseInt(request
					.getParameter("dgResultEntryDetailLabId"));
			mapForDs.put("dgResultEntryDetailId", dgResultEntryDetailLabId);
		}
		if (request.getParameter("dgResultEntryHeaderLabId") != null) {
			dgResultEntryHeaderLabId = Integer.parseInt(request
					.getParameter("dgResultEntryHeaderLabId"));
			mapForDs.put("dgResultEntryHeaderLabId", dgResultEntryHeaderLabId);
		}
		if (request.getParameter("dgSampleCollectionDetailLabId") != null) {
			dgSampleCollectionDetailLabId = Integer.parseInt(request
					.getParameter("dgSampleCollectionDetailLabId"));
			mapForDs.put("dgSampleCollectionDetailLabId",
					dgSampleCollectionDetailLabId);
		}
		if (request.getParameter("dgResultEntryHeaderSenLabId") != null) {
			dgResultEntryHeaderSenLabId = Integer.parseInt(request
					.getParameter("dgResultEntryHeaderSenLabId"));
			mapForDs.put("dgResultEntryHeaderSenLabId",
					dgResultEntryHeaderSenLabId);
		}
		if (request.getParameter("orderStatus") != null) {
			orderStatus = request.getParameter("orderStatus");
			mapForDs.put("orderStatus", orderStatus);
		}
		if (request.getParameter("confidential") != null) {
			confidential = request.getParameter("confidential");
			mapForDs.put("confidential", confidential);
		}
		if (request.getParameter("rejectedStatus") != null) {
			rejectedStatus = request.getParameter("rejectedStatus");
			mapForDs.put("rejectedStatus", rejectedStatus);
		}
		if (request.getParameter("rejReason") != null) {
			rejReason = request.getParameter("rejReason");
			mapForDs.put("rejReason", rejReason);
		}

		if (dgMasInvestigationId != 0) {
			if (orderStatus.equalsIgnoreCase("P")) {
				String[] orderStatusMsg = { "Sample is Not Collected." };

				map.put("orderStatusMsg", orderStatusMsg);
				jsp = "msgForOrderStatus";
			} else if (orderStatus.equalsIgnoreCase("C")) {
				String[] orderStatusMsg = { "Sample is Collected for This Test." };

				map.put("orderStatusMsg", orderStatusMsg);
				jsp = "msgForOrderStatus";
			} else if (orderStatus.equalsIgnoreCase("X")) {
				String[] orderStatusMsg = { "This Test is cancelled." };

				map.put("orderStatusMsg", orderStatusMsg);
				jsp = "msgForOrderStatus";
			}
		} else if (dgSampleCollectionDetailLabId != 0) {
			if (orderStatus.equalsIgnoreCase("P")) {
				if (rejectedStatus != null
						&& rejectedStatus.equalsIgnoreCase("y")) {
					if (rejReason != null && !rejReason.equals("")) {
						String[] orderStatusMsg = { "Sample is rejected (Reason :"
								+ rejReason + ")" };
						map.put("orderStatusMsg", orderStatusMsg);

					} else {
						String[] orderStatusMsg = { "Sample is rejected." };
						map.put("orderStatusMsg", orderStatusMsg);
					}
				} else {
					String[] orderStatusMsg = { "Sample is pending for validation For this Test."

					};

					/*
					 * String[] orderStatusMsg =
					 * {"Sample is collected For this Test."
					 * ,"But it is still pending for validation." };
					 */
					map.put("orderStatusMsg", orderStatusMsg);
				}
				jsp = "msgForOrderStatus";
			} else if (orderStatus.equalsIgnoreCase("A")) {
				String[] orderStatusMsg = {
						//"Sample is validated for this Test.",
						"Sample is still pending for result entry." };
				map.put("orderStatusMsg", orderStatusMsg);
				jsp = "msgForOrderStatus";
			} else if (orderStatus.equalsIgnoreCase("X")) {
				String[] orderStatusMsg = { "This Test is cancelled." };

				map.put("orderStatusMsg", orderStatusMsg);
				jsp = "msgForOrderStatus";
			}
		} else if (dgResultEntryHeaderLabId != 0) {
			map = labHandlerService.getResultEntryDetailsForLabOrderStatus(
					dgResultEntryHeaderLabId, deptId);
			if (confidential.equalsIgnoreCase("y")) {
				// || orderStatus.equalsIgnoreCase("P")){
				jsp = "msgForOrderStatus";
			} else {
				if (resultType.equalsIgnoreCase("m")) {
					jsp = VIEW_MULTIPLE_PARAMETER_STATUS;
				}
			}
		} else if (dgResultEntryHeaderSenLabId != 0) {
			map = labHandlerService.getResultEntryDetailsForLabOrderStatus(
					dgResultEntryHeaderSenLabId, deptId);
			if (confidential.equalsIgnoreCase("y")) {
				// || orderStatus.equalsIgnoreCase("P")){
				jsp = "msgForOrderStatus";
			} else {
				if (resultType.equalsIgnoreCase("v")) {
					jsp = VIEW_SENSITIVE_STATUS;
				}
			}
		} else if (dgResultEntryDetailLabId != 0) {
			if (resultType.equalsIgnoreCase("s")) {
				map = labHandlerService.getResultForRadiologyTest(mapForDs);
				if (map.get("dgResultEntryDetailList") != null) {
					dgResultEntryDetailList = (List) map
							.get("dgResultEntryDetailList");
				}
				if (dgResultEntryDetailList.size() > 0) {
					dgResultEntryDetail = dgResultEntryDetailList.get(0);
					result = dgResultEntryDetail.getResult();
					map.put("dgResultEntryDetail", dgResultEntryDetail);
					map.put("result", result);
				}
				if (confidential.equalsIgnoreCase("y")) {
					// || orderStatus.equalsIgnoreCase("P")){
					jsp = "msgForOrderStatus";
				} else {
					jsp = VIEW_SINGLE_PARAMETER_STATUS;
				}
			} else if (resultType.equalsIgnoreCase("t")) {
				try {
					map = labHandlerService.getResultForRadiologyTest(mapForDs);
					if (map.get("dgResultEntryDetailList") != null) {
						dgResultEntryDetailList = (List) map
								.get("dgResultEntryDetailList");
					}
					if (dgResultEntryDetailList.size() > 0) {
						dgResultEntryDetail = dgResultEntryDetailList.get(0);
						result = dgResultEntryDetail.getResult();
						map.put("dgResultEntryDetail", dgResultEntryDetail);
						map.put("result", result);

						InputStream is = new FileInputStream(
								getServletContext().getRealPath(
										"jsp/pdf/appendingHtml.html"));
						File temprory1 = new File(getServletContext()
								.getRealPath("jsp/pdf/appendingHtml.html"));
						byte[] b3 = new byte[(int) temprory1.length()];
						int offset = 0;
						int numRead = 0;
						try {
							while ((offset < b3.length)
									&& ((numRead = is.read(b3, offset,
											b3.length - offset)) >= 0)) {
								offset += numRead;
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
						try {
							is.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						appendedHtml = new String(b3);
						new File(getServletContext().getRealPath("/temp/"))
								.mkdir();
						if (request.getAttribute("secondRequest") == null) {

							File temprory = new File(getServletContext()
									.getRealPath("/temp/" + "temp.html"));
							FileOutputStream fos = null;
							try {
								fos = new FileOutputStream(getServletContext()
										.getRealPath("/temp/" + "temp.html"));
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							} catch (IllegalStateException e1) {
								e1.printStackTrace();
							}
							try {
								fos.write(dgResultEntryDetail.getResult()
										.getBytes());
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (confidential.equalsIgnoreCase("y")) {
					// || orderStatus.equalsIgnoreCase("P")){
					jsp = "msgForOrderStatus";
				} else {
					jsp = VIEW_TEMPLATE_STATUS_FOR_LAB;
				}
			}
		}
		if ((dgResultEntryDetailLabId != 0 || dgResultEntryHeaderSenLabId != 0 || dgResultEntryHeaderLabId != 0)) {
			// && !confidential.equals("y")){
			if (orderStatus.equalsIgnoreCase("P")) {
				String[] orderStatusMsg = {
						"This Test is still Pending For Result Validation.",
						//"Result is entered which is shown below" 
						};
				// String[] orderStatusMsg =
				// {"This Test is still Pending For Result Validation."};
				map.put("orderStatusMsg", orderStatusMsg);
			}
			if (!confidential.equals("y")) {
				if (orderStatus.equalsIgnoreCase("A")) {
					String[] orderStatusMsg = {
							"Result is validated for This Test.",
							//"Result entered is shown as below"
							};
					map.put("orderStatusMsg", orderStatusMsg);
				}
			} else if (confidential.equals("y")) {
				String[] orderStatusMsg = { "This Test result is confidential." };
				map.put("orderStatusMsg", orderStatusMsg);
			}
		}/*
		 * else if((dgResultEntryDetailLabId != 0 || dgResultEntryHeaderSenLabId
		 * != 0 || dgResultEntryHeaderLabId != 0) && confidential.equals("y")){
		 * String[] orderStatusMsg = {"This Test result is confidential."};
		 * map.put("orderStatusMsg", orderStatusMsg); }
		 */
		map.put("orderNoList", orderNoList);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);

		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView printResultForRadiology(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}

		HttpSession session = request.getSession();
		String deptName = "";
		String jsp = "";
		String resultType = "";
		String orderStatus = "";

		String appendedHtml = "";
		List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();
		DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
		String result = "";

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}

		int dgMasInvestigationId = 0;
		int dgOrderdtId = 0;
		int dgResultEntryDetailId = 0;
		int dgSampleCollectionDetailId = 0;
		boolean resultEntered = false;
		String confidential = "";
		String rejectedStatus = "";
		String rejReason = "";

		if (request.getParameter("resultType") != null) {
			resultType = request.getParameter("resultType");
			mapForDs.put("resultType", resultType);
		}
		if (request.getParameter("dgResultEntryDetailId") != null) {
			dgResultEntryDetailId = Integer.parseInt(request
					.getParameter("dgResultEntryDetailId"));
			mapForDs.put("dgResultEntryDetailId", dgResultEntryDetailId);
		}
		if (request.getParameter("dgSampleCollectionDetailId") != null) {
			dgSampleCollectionDetailId = Integer.parseInt(request
					.getParameter("dgSampleCollectionDetailId"));
			mapForDs.put("dgSampleCollectionDetailId",
					dgSampleCollectionDetailId);
		}
		if (request.getParameter("orderStatus") != null) {
			orderStatus = request.getParameter("orderStatus");
			mapForDs.put("orderStatus", orderStatus);
		}
		if (request.getParameter("confidential") != null) {
			confidential = request.getParameter("confidential");
			mapForDs.put("confidential", confidential);
		}

		if (request.getParameter("rejectedStatus") != null) {
			rejectedStatus = request.getParameter("rejectedStatus");
			mapForDs.put("rejectedStatus", rejectedStatus);
		}
		if (request.getParameter("rejReason") != null) {
			rejReason = request.getParameter("rejReason");
			mapForDs.put("rejReason", rejReason);
		}

		if (dgResultEntryDetailId != 0) {
			map = labHandlerService.getResultForRadiologyTest(mapForDs);

			if (map.get("dgResultEntryDetailList") != null) {
				dgResultEntryDetailList = (List) map
						.get("dgResultEntryDetailList");
			}
			if (dgResultEntryDetailList.size() > 0) {
				dgResultEntryDetail = dgResultEntryDetailList.get(0);
				result = dgResultEntryDetail.getResult();
				map.put("dgResultEntryDetail", dgResultEntryDetail);
				map.put("result", result);

				try {
					InputStream is = new FileInputStream(getServletContext()
							.getRealPath("jsp/pdf/appendingHtml.html"));
					File temprory1 = new File(getServletContext().getRealPath(
							"jsp/pdf/appendingHtml.html"));
					byte[] b3 = new byte[(int) temprory1.length()];
					int offset = 0;
					int numRead = 0;
					try {
						while ((offset < b3.length)
								&& ((numRead = is.read(b3, offset, b3.length
										- offset)) >= 0)) {
							offset += numRead;

						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					appendedHtml = new String(b3);
					new File(getServletContext().getRealPath("/temp/")).mkdir();
					if (request.getAttribute("secondRequest") == null) {
						File temprory = new File(getServletContext()
								.getRealPath("/temp/" + "temp.html"));
						FileOutputStream fos = null;
						try {
							fos = new FileOutputStream(getServletContext()
									.getRealPath("/temp/" + "temp.html"));
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						} catch (IllegalStateException e1) {
							e1.printStackTrace();
						}
						try {
							fos.write(dgResultEntryDetail.getResult()
									.getBytes());
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (resultType.equalsIgnoreCase("t")) {
				if (orderStatus.equalsIgnoreCase("P")) {
					String[] orderStatusMsg = { "This Test is still Pending For Report Validation." };
					/*
					 * String[] orderStatusMsg =
					 * {"This Test is still Pending For Report Validation."
					 * ,"Report is entered which is shown below"};
					 */
					map.put("orderStatusMsg", orderStatusMsg);
				} else if (orderStatus.equalsIgnoreCase("A")) {
					String[] orderStatusMsg = {
							"Report is validated for This Test.",
							"Report entered is shown as below" };
					map.put("orderStatusMsg", orderStatusMsg);
				}
			}
			resultEntered = true;
		}
		if (dgSampleCollectionDetailId != 0) {
			if (resultType.equalsIgnoreCase("t")) {
				if (orderStatus.equalsIgnoreCase("P")) {
					if (rejectedStatus != null
							&& rejectedStatus.equalsIgnoreCase("y")) {
						if (rejReason != null && !rejReason.equals("")) {
							String[] orderStatusMsg = { "This test is Rejected (Reason :."
									+ rejReason + ")" };
							map.put("orderStatusMsg", orderStatusMsg);
						} else {
							String[] orderStatusMsg = { "This test is Rejected." };
							map.put("orderStatusMsg", orderStatusMsg);
						}

					} else {
						String[] orderStatusMsg = { "This test is still pending for Acceptance Of Radiological Investigation." };
						map.put("orderStatusMsg", orderStatusMsg);
					}
				} else if (orderStatus.equalsIgnoreCase("A")) {
					String[] orderStatusMsg = { "This Test is Accepted For Radiological Investigation." };
					map.put("orderStatusMsg", orderStatusMsg);
				} else if (orderStatus.equalsIgnoreCase("X")) {
					String[] orderStatusMsg = { "This Test is Cancelled." };
					map.put("orderStatusMsg", orderStatusMsg);
				}
			}
		}
		if (resultEntered) {
			if (orderStatus.equalsIgnoreCase("P")) {
				// jsp = "msgForOrderStatus";
				jsp = VIEW_TEMPLATE_STATUS;
			} else if (orderStatus.equals("A")) {
				if (confidential.equalsIgnoreCase("y")) {
					String[] orderStatusMsg = { "This Test result is Confidential." };
					map.put("orderStatusMsg", orderStatusMsg);
					jsp = "msgForOrderStatus";
				} else {
					jsp = VIEW_TEMPLATE_STATUS;
				}
			}
		} else {
			jsp = "msgForOrderStatus";
		}

		map.put("deptName", deptName);
		map.put("appendedHtml", appendedHtml);
		map.put("contentJsp", jsp);
		map.put("resultEntered", resultEntered);

		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView showConfidentialOrderSearchJsp(
			HttpServletRequest request, HttpServletResponse response) {

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map = labHandlerService.getDetailsForSearch(map);
		jsp = CONFIDENTIAL_ORDER_SEARCH_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchConfidentialOrderDetails(
			HttpServletRequest request, HttpServletResponse response) {

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> orderDetailMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientDiagnosisMap = new HashMap<String, Object>();

		String hinNo = "";
		int wardId = 0;
		String adNo = "";
		int inpatientId = 0;
		String serviceNo = "";

		try {

			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(WARD_ID) != null
					&& !(request.getParameter(WARD_ID).equals("0"))) {
				wardId = Integer.parseInt(request.getParameter(WARD_ID));
				mapForDs.put("wardId", wardId);
			}
			if (request.getParameter("inpatientId") != null) {
				inpatientId = Integer.parseInt(request
						.getParameter("inpatientId"));
				mapForDs.put("inpatientId", inpatientId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		orderDetailMap = labHandlerService.getAllConfidentialOrders(mapForDs);
		map = labHandlerService.getDetailsForSearch(mapForDs);
		jsp = CONFIDENTIAL_ORDER_SEARCH_JSP + ".jsp";

		map.put("orderDetailMap", orderDetailMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView viewAllConfidentialTestForOrderNo(
			HttpServletRequest request, HttpServletResponse response) {
		List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> testDetailMap = new HashMap<String, Object>();

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}

		HttpSession session = request.getSession();
		String deptName = "";
		String jsp = "";

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}

		int dgOrderHdId = 0;
		int inPatientId = 0;
		if (request.getParameter("dgOrderHdId") != null) {
			dgOrderHdId = Integer.parseInt(request.getParameter("dgOrderHdId"));
			mapForDs.put("dgOrderHdId", dgOrderHdId);
		}

		// orderNoList = labHandlerService.getOrderNoList(mapForDs);

		testDetailMap = labHandlerService
				.getOrderDtForConfidentialTest(mapForDs);

		jsp = VIEW_TEST_DETAILS_FOR_CONFIDENTIAL_ORDERS;

		map.put("testDetailMap", testDetailMap);
		map.put("orderNoList", orderNoList);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);

		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView selectViewAccOrderStatusForConfidential(
			HttpServletRequest request, HttpServletResponse response) {
		List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> resultTypeDetailMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String appendedHtml = "";

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}

		HttpSession session = request.getSession();
		String deptName = "";
		String jsp = "";
		String resultType = "";
		String orderStatus = "";
		String result = "";
		Integer deptId = 0;
		String confidential = "";

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		int dgMasInvestigationId = 0;
		int dgOrderdtId = 0;
		int dgResultEntryDetailId = 0;
		int dgResultEntryDetailLabId = 0;
		int dgSampleCollectionDetailLabId = 0;
		int dgResultEntryHeaderLabId = 0;
		int dgResultEntryHeaderSenLabId = 0;

		DgResultEntryDetail dgResultEntryDetail = null;
		List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();

		if (request.getParameter("dgMasInvestigationId") != null) {
			dgMasInvestigationId = Integer.parseInt(request
					.getParameter("dgMasInvestigationId"));
			mapForDs.put("dgMasInvestigationId", dgMasInvestigationId);
		}
		if (request.getParameter("resultType") != null) {
			resultType = request.getParameter("resultType");
			mapForDs.put("resultType", resultType);
		}
		if (request.getParameter("dgOrderdtId") != null) {
			dgOrderdtId = Integer.parseInt(request.getParameter("dgOrderdtId"));
			mapForDs.put("dgOrderdtId", dgOrderdtId);
		}
		if (request.getParameter("dgResultEntryDetailLabId") != null) {
			dgResultEntryDetailLabId = Integer.parseInt(request
					.getParameter("dgResultEntryDetailLabId"));
			mapForDs.put("dgResultEntryDetailId", dgResultEntryDetailLabId);
		}
		if (request.getParameter("dgResultEntryHeaderLabId") != null) {
			dgResultEntryHeaderLabId = Integer.parseInt(request
					.getParameter("dgResultEntryHeaderLabId"));
			mapForDs.put("dgResultEntryHeaderLabId", dgResultEntryHeaderLabId);
		}
		if (request.getParameter("dgSampleCollectionDetailLabId") != null) {
			dgSampleCollectionDetailLabId = Integer.parseInt(request
					.getParameter("dgSampleCollectionDetailLabId"));
			mapForDs.put("dgSampleCollectionDetailLabId",
					dgSampleCollectionDetailLabId);
		}
		if (request.getParameter("dgResultEntryHeaderSenLabId") != null) {
			dgResultEntryHeaderSenLabId = Integer.parseInt(request
					.getParameter("dgResultEntryHeaderSenLabId"));
			mapForDs.put("dgResultEntryHeaderSenLabId",
					dgResultEntryHeaderSenLabId);
		}
		if (request.getParameter("orderStatus") != null) {
			orderStatus = request.getParameter("orderStatus");
			mapForDs.put("orderStatus", orderStatus);
		}
		if (request.getParameter("confidential") != null) {
			confidential = request.getParameter("confidential");
			mapForDs.put("confidential", confidential);
		}

		if (dgMasInvestigationId != 0) {
			if (orderStatus.equalsIgnoreCase("P")) {
				String[] orderStatusMsg = { "Sample is Not Collected." };

				map.put("orderStatusMsg", orderStatusMsg);
				jsp = "msgForOrderStatus";
			} else if (orderStatus.equalsIgnoreCase("C")) {
				String[] orderStatusMsg = { "Sample is Collected for This Test." };

				map.put("orderStatusMsg", orderStatusMsg);
				jsp = "msgForOrderStatus";
			} else if (orderStatus.equalsIgnoreCase("X")) {
				String[] orderStatusMsg = { "This Test is cancelled." };

				map.put("orderStatusMsg", orderStatusMsg);
				jsp = "msgForOrderStatus";
			}
		} else if (dgSampleCollectionDetailLabId != 0) {
			if (orderStatus.equalsIgnoreCase("P")) {
				String[] orderStatusMsg = { "Test is still pending for Sample validation."
				// ,"But it is still pending for Sample validation."
				};
				map.put("orderStatusMsg", orderStatusMsg);
				jsp = "msgForOrderStatus";
			} else if (orderStatus.equalsIgnoreCase("A")) {
				String[] orderStatusMsg = {
						"Sample is validated for this Test.",
						"Sample is still pending for result entry." };
				map.put("orderStatusMsg", orderStatusMsg);
				jsp = "msgForOrderStatus";
			} else if (orderStatus.equalsIgnoreCase("X")) {
				String[] orderStatusMsg = { "This Test is cancelled." };

				map.put("orderStatusMsg", orderStatusMsg);
				jsp = "msgForOrderStatus";
			}
		} else if (dgResultEntryHeaderLabId != 0) {
			map = labHandlerService.getResultEntryDetailsForLabOrderStatus(
					dgResultEntryHeaderLabId, deptId);
			// if(confidential.equalsIgnoreCase("y")){
			// jsp= "msgForOrderStatus";
			// }else{
			if (resultType.equalsIgnoreCase("m")) {
				jsp = VIEW_MULTIPLE_PARAMETER_STATUS;
			}
			// }
		} else if (dgResultEntryHeaderSenLabId != 0) {
			map = labHandlerService.getResultEntryDetailsForLabOrderStatus(
					dgResultEntryHeaderSenLabId, deptId);
			// if(confidential.equalsIgnoreCase("y")){
			// jsp = "msgForOrderStatus";
			// }else{
			if (resultType.equalsIgnoreCase("v")) {
				jsp = VIEW_SENSITIVE_STATUS;
			}
			// }
		} else if (dgResultEntryDetailLabId != 0) {
			if (resultType.equalsIgnoreCase("s")) {
				map = labHandlerService.getResultForRadiologyTest(mapForDs);
				if (map.get("dgResultEntryDetailList") != null) {
					dgResultEntryDetailList = (List) map
							.get("dgResultEntryDetailList");
				}
				if (dgResultEntryDetailList.size() > 0) {
					dgResultEntryDetail = dgResultEntryDetailList.get(0);
					result = dgResultEntryDetail.getResult();
					map.put("dgResultEntryDetail", dgResultEntryDetail);
					map.put("result", result);
				}
				// if(confidential.equalsIgnoreCase("y")){
				// jsp = "msgForOrderStatus";
				// }else{
				jsp = VIEW_SINGLE_PARAMETER_STATUS;
				// }
			} else if (resultType.equalsIgnoreCase("t")) {
				try {
					map = labHandlerService.getResultForRadiologyTest(mapForDs);
					if (map.get("dgResultEntryDetailList") != null) {
						dgResultEntryDetailList = (List) map
								.get("dgResultEntryDetailList");
					}
					if (dgResultEntryDetailList.size() > 0) {
						dgResultEntryDetail = dgResultEntryDetailList.get(0);
						result = dgResultEntryDetail.getResult();
						map.put("dgResultEntryDetail", dgResultEntryDetail);
						map.put("result", result);

						InputStream is = new FileInputStream(
								getServletContext().getRealPath(
										"jsp/pdf/appendingHtml.html"));
						File temprory1 = new File(getServletContext()
								.getRealPath("jsp/pdf/appendingHtml.html"));
						byte[] b3 = new byte[(int) temprory1.length()];
						int offset = 0;
						int numRead = 0;
						try {
							while ((offset < b3.length)
									&& ((numRead = is.read(b3, offset,
											b3.length - offset)) >= 0)) {
								offset += numRead;
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
						try {
							is.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						appendedHtml = new String(b3);
						new File(getServletContext().getRealPath("/temp/"))
								.mkdir();
						if (request.getAttribute("secondRequest") == null) {
							File temprory = new File(getServletContext()
									.getRealPath("/temp/" + "temp.html"));
							FileOutputStream fos = null;
							try {
								fos = new FileOutputStream(getServletContext()
										.getRealPath("/temp/" + "temp.html"));
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							} catch (IllegalStateException e1) {
								e1.printStackTrace();
							}
							try {
								fos.write(dgResultEntryDetail.getResult()
										.getBytes());
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				// if(confidential.equalsIgnoreCase("y")){
				// jsp ="msgForOrderStatus";
				// }else{
				jsp = VIEW_TEMPLATE_STATUS_FOR_LAB;
				// }
			}
		}
		if (dgResultEntryDetailLabId != 0 || dgResultEntryHeaderSenLabId != 0
				|| dgResultEntryHeaderLabId != 0) {
			if (orderStatus.equalsIgnoreCase("P")) {
				String[] orderStatusMsg = {
						"This Test is still Pending For Result Validation.",
						"Result is entered which is shown below" };
				map.put("orderStatusMsg", orderStatusMsg);
			} else if (orderStatus.equalsIgnoreCase("A")) {
				String[] orderStatusMsg = {
						"Result is validated for This Test.",
						"Result entered is shown as below" };
				map.put("orderStatusMsg", orderStatusMsg);
			}
		}
		map.put("orderNoList", orderNoList);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);

		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView printConfidentialResultForRadiology(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}

		HttpSession session = request.getSession();
		String deptName = "";
		String jsp = "";
		String resultType = "";
		String orderStatus = "";

		String appendedHtml = "";
		List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();
		DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
		String result = "";

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}

		int dgMasInvestigationId = 0;
		int dgOrderdtId = 0;
		int dgResultEntryDetailId = 0;
		int dgSampleCollectionDetailId = 0;
		boolean resultEntered = false;
		String confidential = "";

		if (request.getParameter("resultType") != null) {
			resultType = request.getParameter("resultType");
			mapForDs.put("resultType", resultType);
		}
		if (request.getParameter("dgResultEntryDetailId") != null) {
			dgResultEntryDetailId = Integer.parseInt(request
					.getParameter("dgResultEntryDetailId"));
			mapForDs.put("dgResultEntryDetailId", dgResultEntryDetailId);
		}
		if (request.getParameter("dgSampleCollectionDetailId") != null) {
			dgSampleCollectionDetailId = Integer.parseInt(request
					.getParameter("dgSampleCollectionDetailId"));
			mapForDs.put("dgSampleCollectionDetailId",
					dgSampleCollectionDetailId);
		}
		if (request.getParameter("orderStatus") != null) {
			orderStatus = request.getParameter("orderStatus");
			mapForDs.put("orderStatus", orderStatus);
		}
		if (request.getParameter("confidential") != null) {
			confidential = request.getParameter("confidential");
			mapForDs.put("confidential", confidential);
		}

		if (dgResultEntryDetailId != 0) {
			map = labHandlerService.getResultForRadiologyTest(mapForDs);

			if (map.get("dgResultEntryDetailList") != null) {
				dgResultEntryDetailList = (List) map
						.get("dgResultEntryDetailList");
			}
			if (dgResultEntryDetailList.size() > 0) {
				dgResultEntryDetail = dgResultEntryDetailList.get(0);
				result = dgResultEntryDetail.getResult();
				map.put("dgResultEntryDetail", dgResultEntryDetail);
				map.put("result", result);

				try {
					InputStream is = new FileInputStream(getServletContext()
							.getRealPath("jsp/pdf/appendingHtml.html"));
					File temprory1 = new File(getServletContext().getRealPath(
							"jsp/pdf/appendingHtml.html"));
					byte[] b3 = new byte[(int) temprory1.length()];
					int offset = 0;
					int numRead = 0;
					try {
						while ((offset < b3.length)
								&& ((numRead = is.read(b3, offset, b3.length
										- offset)) >= 0)) {
							offset += numRead;

						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					appendedHtml = new String(b3);
					new File(getServletContext().getRealPath("/temp/")).mkdir();
					if (request.getAttribute("secondRequest") == null) {
						File temprory = new File(getServletContext()
								.getRealPath("/temp/" + "temp.html"));
						FileOutputStream fos = null;
						try {
							fos = new FileOutputStream(getServletContext()
									.getRealPath("/temp/" + "temp.html"));
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						} catch (IllegalStateException e1) {
							e1.printStackTrace();
						}
						try {
							fos.write(dgResultEntryDetail.getResult()
									.getBytes());
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (resultType.equalsIgnoreCase("t")) {
				if (orderStatus.equalsIgnoreCase("P")) {
					String[] orderStatusMsg = {
							"This Test is still Pending For Report Validation.",
							"Report is entered which is shown below" };
					map.put("orderStatusMsg", orderStatusMsg);
				} else if (orderStatus.equalsIgnoreCase("A")) {
					String[] orderStatusMsg = {
							"Report is validated for This Test.",
							"Report entered is shown as below" };
					map.put("orderStatusMsg", orderStatusMsg);
				}
			}
			resultEntered = true;
		}
		if (dgSampleCollectionDetailId != 0) {
			if (resultType.equalsIgnoreCase("t")) {
				if (orderStatus.equalsIgnoreCase("P")) {
					String[] orderStatusMsg = { "This test is still pending for Acceptance Of Radiological Investigation." };
					map.put("orderStatusMsg", orderStatusMsg);
				} else if (orderStatus.equalsIgnoreCase("A")) {
					String[] orderStatusMsg = { "This Test is Accepted For Radiological Investigation." };
					map.put("orderStatusMsg", orderStatusMsg);
				} else if (orderStatus.equalsIgnoreCase("X")) {
					String[] orderStatusMsg = { "This Test is Cancelled." };
					map.put("orderStatusMsg", orderStatusMsg);
				}
			}
		}
		/*
		 * if(confidential.equalsIgnoreCase("y")){ String[] orderStatusMsg =
		 * {"This Test result is Confidential."}; map.put("orderStatusMsg",
		 * orderStatusMsg); jsp = "msgForOrderStatus"; }else{
		 */
		jsp = VIEW_TEMPLATE_STATUS;
		// }

		map.put("deptName", deptName);
		map.put("appendedHtml", appendedHtml);
		map.put("contentJsp", jsp);
		map.put("resultEntered", resultEntered);

		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView printConfidentialTestDetailsReport(
			HttpServletRequest request, HttpServletResponse response) {
		List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> orderDetailMap = new HashMap<String, Object>();
		List<DgResultEntryHeader> dgResultEntryHeaderLabList = new ArrayList<DgResultEntryHeader>();
		Map<String, Object> resultDetailsMap = new HashMap<String, Object>();
		List<Map<String, Object>> resultDetailsMapList = new ArrayList<Map<String, Object>>();
		int deptId = 0;
		HttpSession session = request.getSession();
		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		String deptName = "";
		String jsp = "";

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}

		int orderNoIdForReport = 0;
		int inPatientId = 0;
		if (request.getParameter("orderNoIdForReport") != null
				&& !(request.getParameter("orderNoIdForReport")).equals("")) {
			orderNoIdForReport = Integer.parseInt(request
					.getParameter("orderNoIdForReport"));
			mapForDs.put("orderIdForReport", orderNoIdForReport);
		}
		if (request.getParameter(INPATIENT_ID) != null) {
			inPatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			mapForDs.put("inPatientId", inPatientId);
		}

		orderDetailMap = labHandlerService.printOrderStatusReport(mapForDs);
		if (orderDetailMap.get("dgResultEntryHeaderLabList") != null) {
			dgResultEntryHeaderLabList = (List) orderDetailMap
					.get("dgResultEntryHeaderLabList");
			for (DgResultEntryHeader dgResultEntryHeader : dgResultEntryHeaderLabList) {
				resultDetailsMap = labHandlerService
						.getResultEntryDetailsForLabOrderStatus(
								dgResultEntryHeader.getId(), deptId);
				resultDetailsMapList.add(resultDetailsMap);
			}
			map.put("resultDetailsMapList", resultDetailsMapList);
		}

		jsp = VIEW_CONFIDENTIAL_TEST_DETAILS_REPORT;

		map.put("orderDetailMap", orderDetailMap);
		map.put("orderNoList", orderNoList);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);

		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView printOrderStatusReport(HttpServletRequest request,
			HttpServletResponse response) {
		List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> orderDetailMap = new HashMap<String, Object>();
		List<DgResultEntryHeader> dgResultEntryHeaderLabList = new ArrayList<DgResultEntryHeader>();
		Map<String, Object> resultDetailsMap = new HashMap<String, Object>();
		List<Map<String, Object>> resultDetailsMapList = new ArrayList<Map<String, Object>>();

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}

		HttpSession session = request.getSession();
		String deptName = "";
		String jsp = "";
		int deptId = 0;

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		int orderNoIdForReport = 0;
		int inPatientId = 0;
		if (request.getParameter("orderNoIdForReport") != null
				&& !(request.getParameter("orderNoIdForReport")).equals("")) {
			orderNoIdForReport = Integer.parseInt(request
					.getParameter("orderNoIdForReport"));
			mapForDs.put("orderIdForReport", orderNoIdForReport);
		}
		if (request.getParameter(INPATIENT_ID) != null) {
			inPatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			mapForDs.put("inPatientId", inPatientId);
		}

		orderDetailMap = labHandlerService.printOrderStatusReport(mapForDs);
		if (orderDetailMap.get("dgResultEntryHeaderLabList") != null) {
			dgResultEntryHeaderLabList = (List) orderDetailMap
					.get("dgResultEntryHeaderLabList");
			for (DgResultEntryHeader dgResultEntryHeader : dgResultEntryHeaderLabList) {
				resultDetailsMap = labHandlerService
						.getResultEntryDetailsForLabOrderStatus(
								dgResultEntryHeader.getId(), deptId);
				resultDetailsMapList.add(resultDetailsMap);
			}
			map.put("resultDetailsMapList", resultDetailsMapList);
		}

		jsp = VIEW_TEST_DETAILS_REPORT_ORDER_STATUS;

		map.put("orderDetailMap", orderDetailMap);
		map.put("orderNoList", orderNoList);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);

		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView submitSampleAcceptanceAddNewOrder(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();

		HttpSession session = request.getSession();

		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		String hinNo = "";
		String adNo = "";
		String serviceNo = "";
		String jsp = "";
		String title = "";
		String sampleCollectionHeaderPatientType = "";
		String flagForUpdate = "";
		String rejReason = "";

		int sampleCollDtId = 0;
		int wardId = 0;
		int inpatientId = 0;
		int orderHdId = 0;
		int sampleCollectionHeaderId = 0;

		try {

			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(WARD_ID) != null
					&& !(request.getParameter(WARD_ID).equals("0"))) {
				wardId = Integer.parseInt(request.getParameter(WARD_ID));
				mapForDs.put("wardId", wardId);
			}
			if (request.getParameter("inpatientId") != null) {
				inpatientId = Integer.parseInt(request
						.getParameter("inpatientId"));
				mapForDs.put("inpatientId", inpatientId);
			}
			if (request.getParameter("flagForUpdate") != null) {
				flagForUpdate = request.getParameter("flagForUpdate");
			}
			if (request.getParameter("sampleCollDtId") != null
					&& !request.getParameter("sampleCollDtId").equals("")) {
				sampleCollDtId = Integer.parseInt(request
						.getParameter("sampleCollDtId"));
			}
			if (request.getParameter("rejReason") != null
					&& !request.getParameter("rejReason").equals("")) {
				rejReason = (String) request.getParameter("rejReason");
			}

			if (flagForUpdate.equals("upatedOrderBooking")) {
				if (request.getParameter(ORDER_BOOKING_ID) != null
						&& !request.getParameter(ORDER_BOOKING_ID).equals("")) {
					orderHdId = Integer.parseInt(request
							.getParameter(ORDER_BOOKING_ID));
				}
				if (request.getParameter("sampleCollectionHeaderId") != null
						&& !request.getParameter("sampleCollectionHeaderId")
								.equals("")) {
					sampleCollectionHeaderId = Integer.parseInt(request
							.getParameter("sampleCollectionHeaderId"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		mapForDs.put("deptId", deptId);

		patientMap = labHandlerService
				.getPatientDetailsForIPDOrderBooking(mapForDs);

		if (patientMap.get("inpatientList") != null) {
			inpatientList = (List<Inpatient>) patientMap.get("inpatientList");
		}
		if (flagForUpdate.equals("upatedOrderBooking")) {
			map.put("inPatientId", inpatientId);
			map.put("deptId", deptId);
			map.put("A&DNo", adNo);
			map.put("flagForUpdate", flagForUpdate);
			map.put("orderHdId", orderHdId);
			map.put("sampleCollectionHeaderId", sampleCollectionHeaderId);

			map = labHandlerService.showOrderBookingJsp(map);

			// String orderSeqNo=request.getParameter("orderSeqNo");
			// orderSeqNo = labHandlerService.getOrderSeqForDisplay("ON");

			detailsMap = labHandlerService.getMainAndSubCharge();
			map.put("detailsMap", detailsMap);
			map.put("orderHdId", orderHdId);
			map.put("sampleCollectionHeaderId", sampleCollectionHeaderId);
			map.put("sampleCollDtId", sampleCollDtId);
			map.put("rejReason", rejReason);

			jsp = UPDATE_ORDER_BOOKING;
			jsp += ".jsp";
			title = "OrderBooking";

		} else if (flagForUpdate.equals("")) {
			if ((!adNo.equals("") && inpatientList.size() > 0)
					|| inpatientId != 0) {
				map.put("inPatientId", inpatientId);
				map.put("deptId", deptId);
				map.put("A&DNo", adNo);

				map = labHandlerService.showOrderBookingJsp(map);

				String orderSeqNo = request.getParameter("orderSeqNo");
				orderSeqNo = labHandlerService.getOrderSeqForDisplay("ON");
				if (orderSeqNo != null) {
					map.put("orderSeqNo", orderSeqNo);
				}
				detailsMap = labHandlerService.getMainAndSubCharge();
				map.put("detailsMap", detailsMap);
				jsp = ORDER_BOOKING;
				jsp += ".jsp";
				title = "OrderBooking";

				// /////////////////
			} else {
				map = labHandlerService.getDetailsForIPDSearch();
				jsp = IPD_ORDER_BOOKING_SEARCH_JSP + ".jsp";
			}
		}

		map.put("deptName", patientMap.get("deptName"));
		map.put("patientMap", patientMap);
		map.put("title", title);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addNewOrderForOPD(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();

		HttpSession session = request.getSession();

		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			map.put("deptId", deptId);
		}

		String hinNo = "";
		String adNo = "";
		String serviceNo = "";
		String jsp = "";
		String title = "";
		String deptName = "";
		String sampleCollectionHeaderPatientType = "";
		String flagForUpdate = "";
		String rejReason = "";

		int sampleCollDtId = 0;
		int wardId = 0;
		int visitNo = 0;
		int visitId = 0;
		int inpatientId = 0;
		int orderHdId = 0;
		int sampleCollectionHeaderId = 0;

		try {
			if (request.getParameter("sampleCollDtId") != null
					&& !request.getParameter("sampleCollDtId").equals("")) {
				sampleCollDtId = Integer.parseInt(request
						.getParameter("sampleCollDtId"));
			}
			if (request.getParameter("rejReason") != null
					&& !request.getParameter("rejReason").equals("")) {
				rejReason = (String) request.getParameter("rejReason");
			}
			if (request.getParameter("flagForUpdate") != null) {
				flagForUpdate = request.getParameter("flagForUpdate");
				map.put("flagForUpdate", flagForUpdate);
			}
			map.put("inpatientId", inpatientId);

			if (flagForUpdate.equals("upatedOrderBooking")) {
				if (request.getParameter(ORDER_BOOKING_ID) != null
						&& !request.getParameter(ORDER_BOOKING_ID).equals("")) {
					orderHdId = Integer.parseInt(request
							.getParameter(ORDER_BOOKING_ID));
					map.put("orderHdId", orderHdId);
				}
				if (request.getParameter("sampleCollectionHeaderId") != null
						&& !request.getParameter("sampleCollectionHeaderId")
								.equals("")) {
					sampleCollectionHeaderId = Integer.parseInt(request
							.getParameter("sampleCollectionHeaderId"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		mapForDs.put("deptId", deptId);

		/*
		 * if (session.getAttribute("deptName") != null) deptName
		 * =(String)session.getAttribute("deptName");
		 * 
		 * if(request.getParameter(VISIT_NUMBER) != null){ visitNo =
		 * Integer.parseInt(request.getParameter(VISIT_NUMBER));
		 * map.put("visitNo", visitNo); } if(request.getParameter(VISIT_ID) !=
		 * null){ visitId = Integer.parseInt(request.getParameter(VISIT_ID));
		 * map.put("visitId", visitId); }
		 */
		if (orderHdId != 0) {
			map = labHandlerService.showOrderBookingJsp(map);
			// map =
			// labHandlerService.showOrderBookingForInvestigationJsp(visitId);
		}
		detailsMap = labHandlerService.getMainAndSubCharge();
		jsp = OPD_INVESTIGATION_ORDER_BOOKING_FOR_UPDATE + ".jsp";

		// jsp = OP_ORDER_BOOKING_SEARCH_JSP+".jsp";
		map.put("deptName", deptName);
		map.put("dgOrderhdId", orderHdId);
		map.put("detailsMap", detailsMap);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("orderHdId", orderHdId);
		map.put("sampleCollectionHeaderId", sampleCollectionHeaderId);
		map.put("sampleCollDtId", sampleCollDtId);
		map.put("rejReason", rejReason);

		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateOrderBookingForIPD(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> rejectionDetailMap = new HashMap<String, Object>();

		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();

		HttpSession session = request.getSession();

		Box box = HMSUtil.getBox(request);
		int chargeMainIdFromRequest = 0;
		int noOfRecords = 0;
		int inpatientId = 0;
		int placedBy = 0;
		int pageNo = 1;
		int hinId = 0;
		int dgOrderhdId = 0;
		int sampleCollDtId = 0;
		int sampleCollectionHeaderId = 0;
		int visitId = 0;
		int uid = 0;
		int deptId = 0;
		String deptName = "";
		String deptType = "";
		String provisionalDiag = "";
		String buttonFlag = "";
		String clinicalNote = "";
		String orderSeqNo = "";
		String orderStatus = "";
		String createdBy = "";
		String testType = "";
		String hinNo = "";
		String visitNo = "";
		String date = "";
		String time = "";
		String rejReason = "";

		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTimeWithoutSc");
		List chargeList = new ArrayList();
		List qtyList = new ArrayList();
		List mainChargeList = new ArrayList();
		List subChargeList = new ArrayList();
		@SuppressWarnings("unused")
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		String deptYype = (String) session.getAttribute("deptType");

		if (request.getParameter(TEST_TYPE) != null
				&& !(request.getParameter(TEST_TYPE).equals(""))) {
			testType = request.getParameter(TEST_TYPE);
			infoMap.put("testType", testType);
		}
		if (request.getParameter(CLINICAL_NOTE) != null
				&& !(request.getParameter(CLINICAL_NOTE).equals(""))) {
			clinicalNote = request.getParameter(CLINICAL_NOTE);
			infoMap.put("clinicalNote", clinicalNote);
		}
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
			infoMap.put("noOfRecords", noOfRecords);
		}
		if (request.getParameter(CREATED_BY) != null
				&& !(request.getParameter(CREATED_BY).equals(""))) {
			createdBy = request.getParameter(CREATED_BY);
			infoMap.put("createdBy", createdBy);
		}
		if (request.getParameter(ORDER_NO) != null) {
			orderSeqNo = request.getParameter(ORDER_NO);
			infoMap.put("orderSeqNo", orderSeqNo);
		}
		if (request.getParameter("dgOrderhdId") != null) {
			dgOrderhdId = Integer.parseInt(request.getParameter("dgOrderhdId"));
			infoMap.put("dgOrderhdId", dgOrderhdId);
		}
		if (request.getParameter("rejReason") != null) {
			rejReason = (String) request.getParameter("rejReason");
			infoMap.put("rejReason", rejReason);
		}

		if (request.getParameter("sampleCollDtId") != null) {
			sampleCollDtId = Integer.parseInt(request
					.getParameter("sampleCollDtId"));
			infoMap.put("sampleCollDtId", sampleCollDtId);
		}
		if (request.getParameter("sampleCollectionHeaderId") != null) {
			sampleCollectionHeaderId = Integer.parseInt(request
					.getParameter("sampleCollectionHeaderId"));
			infoMap.put("sampleCollectionHeaderId", sampleCollectionHeaderId);
		}

		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			infoMap.put("userName", userName);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			infoMap.put("deptId", deptId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			uid = user.getId();
		}
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}

		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();

		infoMap.put("userId", userId);
		infoMap.put("orderSeqNo", orderSeqNo);

		try {

			// Vector quantity = box.getVector(QUANTITY);
			Vector charge_code_id = box.getVector(CHARGE_CODE_ID);
			Vector main_charge_id = box.getVector("mainCharge");
			Vector sub_charge_id = box.getVector("subCharge");
			String diagnosisNo = box.getString(DIAGNOSIS_NO);
			int counter = 0;

			for (int i = 0; i < charge_code_id.size(); i++) {
				// if (!charge_code_id.get(i).toString().equals(""))
				counter++;
			}
			noOfRecords = counter;
			for (int i = 0; i < noOfRecords; i++) {
				if (!charge_code_id.get(i).toString().equals("")) {
					chargeList.add(charge_code_id.get(i));
					mainChargeList.add(main_charge_id.get(i));
					subChargeList.add(sub_charge_id.get(i));
					// qtyList.add(quantity.get(i));
				}
			}

			infoMap.put("chargeList", chargeList);
			infoMap.put("qtyList", qtyList);
			infoMap.put("mainChargeList", mainChargeList);
			infoMap.put("subChargeList", subChargeList);
			infoMap.put("userId", userId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		infoMap.put("box", box);
		boolean success = false;
		String jsp = "";
		String message = "";

		returnMap = labHandlerService
				.updateOrderBookingForInvestigation(infoMap);

		// //////////////////
		map = labHandlerService.updateSampleCollection(infoMap);
		// ///////////////////
		rejectionDetailMap = labHandlerService.rejectSample(infoMap);

		if (returnMap.get("success") != null) {
			success = (Boolean) returnMap.get("success");
		}
		if (returnMap.get("orderSeqNo") != null) {
			orderSeqNo = (String) returnMap.get("orderSeqNo");
		}
		if (returnMap.get("inpatientId") != null) {
			inpatientId = (Integer) returnMap.get("inpatientId");
		}
		map.put("inpatientId", inpatientId);
		if (success) {
			if (sampleCollectionHeaderId != 0) {
				map = labHandlerService.getSampleValidationDetails(
						sampleCollectionHeaderId, uid, deptId);
			}
			if (map != null && map.get("samplehdList") != null) {
				jsp = SAMPLE_ACCEPTANCE + ".jsp";
			}

		} else {
			jsp = MSG_ORDER_BOOKING + ".jsp";
			message = " Try Again !!";
		}

		map.put("contentJsp", jsp);
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("deptType", deptType);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateOrderBookingForOPD(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> rejectionDetailMap = new HashMap<String, Object>();

		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();

		HttpSession session = request.getSession();

		Box box = HMSUtil.getBox(request);
		int chargeMainIdFromRequest = 0;
		int noOfRecords = 0;
		int inpatientId = 0;
		int placedBy = 0;
		int pageNo = 1;
		int hinId = 0;
		int dgOrderhdId = 0;
		int sampleCollDtId = 0;
		int sampleCollectionHeaderId = 0;
		int visitId = 0;
		int uid = 0;
		int deptId = 0;
		String deptName = "";
		String deptType = "";
		String provisionalDiag = "";
		String buttonFlag = "";
		String clinicalNote = "";
		String orderSeqNo = "";
		String orderStatus = "";
		String createdBy = "";
		String testType = "";
		String hinNo = "";
		String visitNo = "";
		String date = "";
		String time = "";
		String rejReason = "";

		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTimeWithoutSc");
		List chargeList = new ArrayList();
		List qtyList = new ArrayList();
		List mainChargeList = new ArrayList();
		List subChargeList = new ArrayList();
		@SuppressWarnings("unused")
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		String deptYype = (String) session.getAttribute("deptType");

		if (request.getParameter(TEST_TYPE) != null
				&& !(request.getParameter(TEST_TYPE).equals(""))) {
			testType = request.getParameter(TEST_TYPE);
			infoMap.put("testType", testType);
		}
		if (request.getParameter(CLINICAL_NOTE) != null
				&& !(request.getParameter(CLINICAL_NOTE).equals(""))) {
			clinicalNote = request.getParameter(CLINICAL_NOTE);
			infoMap.put("clinicalNote", clinicalNote);
		}
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
			infoMap.put("noOfRecords", noOfRecords);
		}
		if (request.getParameter(CREATED_BY) != null
				&& !(request.getParameter(CREATED_BY).equals(""))) {
			createdBy = request.getParameter(CREATED_BY);
			infoMap.put("createdBy", createdBy);
		}
		if (request.getParameter(ORDER_NO) != null) {
			orderSeqNo = request.getParameter(ORDER_NO);
			infoMap.put("orderSeqNo", orderSeqNo);
		}
		if (request.getParameter("dgOrderhdId") != null) {
			dgOrderhdId = Integer.parseInt(request.getParameter("dgOrderhdId"));
			infoMap.put("dgOrderhdId", dgOrderhdId);
		}
		if (request.getParameter("rejReason") != null) {
			rejReason = (String) request.getParameter("rejReason");
			infoMap.put("rejReason", rejReason);
		}

		if (request.getParameter("sampleCollDtId") != null) {
			sampleCollDtId = Integer.parseInt(request
					.getParameter("sampleCollDtId"));
			infoMap.put("sampleCollDtId", sampleCollDtId);
		}
		if (request.getParameter("sampleCollectionHeaderId") != null) {
			sampleCollectionHeaderId = Integer.parseInt(request
					.getParameter("sampleCollectionHeaderId"));
			infoMap.put("sampleCollectionHeaderId", sampleCollectionHeaderId);
		}

		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			infoMap.put("userName", userName);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			infoMap.put("deptId", deptId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			uid = user.getId();
		}
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}

		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();

		infoMap.put("userId", userId);
		infoMap.put("orderSeqNo", orderSeqNo);

		try {

			// Vector quantity = box.getVector(QUANTITY);
			Vector charge_code_id = box.getVector(CHARGE_CODE_ID);
			Vector main_charge_id = box.getVector("mainCharge");
			Vector sub_charge_id = box.getVector("subCharge");
			String diagnosisNo = box.getString(DIAGNOSIS_NO);
			int counter = 0;

			for (int i = 0; i < charge_code_id.size(); i++) {
				// if (!charge_code_id.get(i).toString().equals(""))
				counter++;
			}
			noOfRecords = counter;
			for (int i = 0; i < noOfRecords; i++) {
				if (!charge_code_id.get(i).toString().equals("")) {
					chargeList.add(charge_code_id.get(i));
					mainChargeList.add(main_charge_id.get(i));
					subChargeList.add(sub_charge_id.get(i));
					// qtyList.add(quantity.get(i));
				}
			}

			infoMap.put("chargeList", chargeList);
			infoMap.put("qtyList", qtyList);
			infoMap.put("mainChargeList", mainChargeList);
			infoMap.put("subChargeList", subChargeList);
			infoMap.put("userId", userId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		infoMap.put("box", box);
		boolean success = false;
		String jsp = "";
		String message = "";

		returnMap = labHandlerService
				.updateOrderBookingForInvestigation(infoMap);

		// //////////////////
		map = labHandlerService.updateSampleCollection(infoMap);
		// ///////////////////
		rejectionDetailMap = labHandlerService.rejectSample(infoMap);

		if (returnMap.get("success") != null) {
			success = (Boolean) returnMap.get("success");
		}
		if (returnMap.get("orderSeqNo") != null) {
			orderSeqNo = (String) returnMap.get("orderSeqNo");
		}
		if (returnMap.get("inpatientId") != null) {
			inpatientId = (Integer) returnMap.get("inpatientId");
		}
		map.put("inpatientId", inpatientId);
		if (success) {
			if (sampleCollectionHeaderId != 0) {
				map = labHandlerService.getSampleValidationDetails(
						sampleCollectionHeaderId, uid, deptId);
			}
			if (map != null && map.get("samplehdList") != null) {
				jsp = SAMPLE_ACCEPTANCE + ".jsp";
			}

		} else {
			jsp = MSG_ORDER_BOOKING + ".jsp";
			message = " Try Again !!";
		}

		map.put("contentJsp", jsp);
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("deptType", deptType);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showTotalOrderBookedReportSearch(
			HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}
		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		Map requestMap = new HashMap();
		requestMap.put("deptId", deptId);
		map = labHandlerService.showDiagnosticRegisterDiagnosisWise(requestMap);
		jsp = TOTAL_ORDER_BOOKED_SEARCH_JSP;
		jsp += ".jsp";
		title = "Total Order Booked";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showTotalOrderBookedReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		String query = "";
		int wardId = 0;
		String fromDate = null;
		String toDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int departmentId = 0;

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE)));
				parameters.put("fromDate", HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE)));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(TO_DATE)));
				parameters.put("toDate", HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(TO_DATE)));
			}
			query = " where dg_orderhd.order_date between '" + fromDate
					+ "' and '" + toDate + "'";

			if (request.getParameter(WARD_ID) != null
					&& !(request.getParameter(WARD_ID).equals("0"))) {
				wardId = Integer.parseInt(request.getParameter(WARD_ID));
				query = query + " and dg_orderhd.department_id ='" + wardId
						+ "'";
			}

			/*
			 * if (session.getAttribute("deptId") != null) { departmentId =
			 * Integer.parseInt("" + session.getAttribute("deptId")); query =
			 * query +
			 * " AND dg_sample_collection_header.`department_id` = "+departmentId
			 * ; }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		// detailsMap = labHandlerService.getSubCharge();
		detailsMap = labHandlerService.getConnectionForReport();
		parameters.put("QUERY", query);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		try {
			HMSUtil.generateReport("totalOrderBookingReport", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView showOrderStatusReportDepartmentWise(
			HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}
		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		Map requestMap = new HashMap();
		requestMap.put("deptId", deptId);

		map = labHandlerService.getMainAndSubCharge();
		jsp = ORDER_STATUS_REPORT_SEARCH_JSP;
		jsp += ".jsp";
		title = "Total Order Booked";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showOrderStatusBookedReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		String query = "";
		String fromDate = null;
		String toDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int departmentId = 0;
		int subChargeId = 0;
		int depart = 0;
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();

		try {
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				parameters.put("subChargeId", subChargeId);
				query = query
						+ " AND mas_sub_chargecode.`sub_chargecode_id` = "
						+ subChargeId;
				mapForDs.put("subChargeId", subChargeId);
			}
			if (request.getParameter(MAIN_CHARGECODE_ID) != null
					&& !(request.getParameter(MAIN_CHARGECODE_ID).equals("0"))) {
				depart = Integer.parseInt(request
						.getParameter(MAIN_CHARGECODE_ID));
				parameters.put("depart", depart);
				parameters.put("mainChargeCodeId", depart);
				mapForDs.put("mainChargeCodeId", depart);
				query = query
						+ " AND mas_main_chargecode.`main_chargecode_id` = "
						+ depart;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap = labHandlerService.getTotalCountDepartmentWise(mapForDs);
		detailsMap = labHandlerService.getConnectionForReport();

		parameters.put("pendingForSampleValidationListTotal", dataMap
				.get("pendingForSampleValidationListTotal"));
		parameters.put("pendingForResultEntryListTotal", dataMap
				.get("pendingForResultEntryListTotal"));
		parameters.put("pendingForResultValidationListTotal", dataMap
				.get("pendingForResultValidationListTotal"));
		parameters.put("currentTime", utilMap.get("currentTimeWithoutSc"));

		parameters.put("QUERY", query);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		try {
			HMSUtil.generateReport("orderStatusDetailsReport", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public LabHandlerService getLabHandlerService() {
		return labHandlerService;
	}

	public void setLabHandlerService(LabHandlerService labHandlerService) {
		this.labHandlerService = labHandlerService;
	}
	public ModelAndView resultPrintingJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		map = labHandlerService.showDiagnosticRegisterJsp(map);
		jsp = "patientResultPrinting";
		jsp += ".jsp";
		title = "Diagnostic Register Doctor Wise";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	} 
	public ModelAndView generatePrintResultForLab(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
        
		int srn = 0;
		String src = "";
		int id = 0;
		String crit = "";
		String deptName = "";
		int deptId = 0;
		String order_no = "";
		String resultType = "";

		session = request.getSession();

		/*
		 * if (request.getParameter(RESULT_NO) != null) { resultNo =
		 * request.getParameter(RESULT_NO); }
		 */
		if (request.getParameter(RESULT_TYPE) != null) {
			resultType = request.getParameter(RESULT_TYPE);
		}

		/*
		 * if (session.getAttribute("deptId") != null) { deptId =
		 * Integer.parseInt("" + session.getAttribute("deptId")); }
		 */

		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		try {
			if (request.getParameter("counta") != null) {
				srn = Integer.parseInt(request.getParameter("counta"));
			}
			src = ("OrderNo");
			if ((request.getParameter(src) != null)
					&& !(request.getParameter(src).equals(""))) {
				order_no = request.getParameter(src);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		detailsMap = labHandlerService.getConnectionForReport();
		parameters.put("order_no", order_no);
		parameters.put("resultType", resultType);
		parameters.put("dept_id", deptId);
		/*HMSUtil.generateReport("print_report1", parameters,(Connection) detailsMap.get("con"), response,
				getServletContext());*/
		HMSUtil.generateReport("viewResultEntryPrintOrderNoWiseLab", parameters,(Connection) detailsMap.get("con"), response,
				getServletContext());
				return null;
	}
	public ModelAndView printLabReport(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String orderNo = "";
		if((request.getParameter("orderNo"))!= null && !(request.getParameter("orderNo").equals("")))
		 {
			orderNo = request.getParameter("orderNo");
		 }
		detailsMap = labHandlerService.getConnectionForReport();
		parameters.put("orderNo", orderNo);
		HMSUtil.generateReport("viewResultEntryPrintOrderNoWiseLab", parameters,(Connection)detailsMap.get("con"), response, getServletContext());
		return null;
	}

	public ModelAndView showDiagnosticRegisterSummaryJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute("hospitalId") != null) {
			map.put("hospitalId", session.getAttribute("hospitalId"));
		}
		map = labHandlerService.showDiagnosticRegisterSummaryJsp(map);
		jsp = "diagnosticRegisterSummary";
		jsp += ".jsp";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView generateDiagnosticSummary(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int deptId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute("hospitalId") != null) {
			box.put("hospitalId", session.getAttribute("hospitalId"));
		}
		
		map  = labHandlerService.getDiagnosticSummary(box);
		
		map.put("contentJsp", jsp);
		return new ModelAndView("diagnosticRegisterSummaryReport", "map", map);
	}
	public ModelAndView showDiagnosticRegisterGraph(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = labHandlerService.getDiagnosticDetailstForGraph(box);
		List<Object[]> diagnosticRegisterList = new ArrayList<Object[]>();
		diagnosticRegisterList = (List<Object[]>)map.get("diagnosticRegisterList");
		String ENCODING = "ISO-8859-1";
		try {
			/**
			 * For updating settings xml file
			 */
			SAXBuilder  builder = new SAXBuilder();
			File xmlFile = new File(getServletContext().getRealPath("/jsp/chart/amcolumn_diagnostic_settings.xml"));

			Document doc = (Document) builder.build(xmlFile);
			Element rootNode = doc.getRootElement();

			Element graphs = rootNode.getChild("graphs");
			
			int graphsChildsNo = graphs.getChildren().size();
			
			if(graphsChildsNo >0) {
				for (int i = 0; i < graphsChildsNo; i++) {
					graphs.removeChild("graph");
				}
			}
			int j=0;
			for(Object[] objVal : diagnosticRegisterList) {
				Element graph = new Element("graph");
				graph.setAttribute("id", ""+j);
				graphs.addContent(graph);
				
				Element title = new Element("title").setText((String)objVal[3]);
				graph.addContent(title);
				j++;
			}
			

					
			
			XMLOutputter xmlOutput = new XMLOutputter();

			// display nice nice
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(doc, new FileWriter(getServletContext().getRealPath("/jsp/chart/amcolumn_diagnostic_settings.xml")));
			
			
			
			
			
			/**
			 * End
			 */
			
			
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(getServletContext().getRealPath(
							"/jsp/chart/amcolumn_diagnostics_data.xml")));
		
			out.write("<?xml version=\"1.0\" encoding=\"" + ENCODING
					+ "\"?>");
			out.write("<chart>");
			int i =0;
				out.write("<series>");
				out.write("<value xid='0'>OPD</value>");
				out.write("<value xid='1'>IPD</value>");
				out.write("<value xid='2'>Total</value>");
			
				out.write("</series>");
				out.write("<graphs>");
				int k=0;
				
				for(Object[] objVal : diagnosticRegisterList){
					out.write("<graph gid='"+k+"'>");
					out.write("<value xid='0' >"+objVal[0]+"</value>");
					out.write("<value xid='1' >"+objVal[1]+"</value>");
					out.write("<value xid='2' >"+objVal[2]+"</value>");
					out.write("</graph>");
					k++;
				}
				
				
			
				out.write("</graphs>");
				
			
			out.write("</chart>");
			out.close();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = "diagnosticRegisterGraph";
		
		return new ModelAndView(jsp,"map",map);
	}
	
	public ModelAndView showBloodDonorPanelJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		map = labHandlerService.showBloodDonorPanelJsp(hospitalId);
		String jsp ="bloodDonorPanel.jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public void generateBloodDonorPanelReport(HttpServletRequest request, HttpServletResponse response) {

		int bldGrpId = 0;
		int unitId = 0;
		int sex_id=0;
		int rank_id=0;
		String query = "";
		String pQry = "";
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap1 = new HashMap<String, Object>();

		if (request.getParameter(BLOOD_GROUP_ID) != null
				&& !(request.getParameter(BLOOD_GROUP_ID).equals("0"))) {
			bldGrpId = Integer.parseInt(request.getParameter(BLOOD_GROUP_ID));
			query = query + " and me.blood_group_id = " + bldGrpId;
			pQry = pQry + " and me.blood_group_id = " + bldGrpId;
		}
		if (request.getParameter(UNIT_ID) != null
				&& !(request.getParameter(UNIT_ID).equals("0"))) {
			unitId = Integer.parseInt(request.getParameter(UNIT_ID));
			query = query + " and me.unit_id = " + unitId;
			pQry = pQry + " and me.unit_id = " + unitId;
		}
		
		
		if(request.getParameter(RANK_ID)!=null && !(request.getParameter(RANK_ID).equals("0"))) {
			rank_id = Integer.parseInt(request.getParameter(RANK_ID));
			query += " and me.rank_id = " + rank_id;
			pQry += " and me.rank_id = " + rank_id;
		}

			if(request.getParameter(SEX_ID)!=null && !(request.getParameter(SEX_ID).equals("0"))) {
				sex_id = Integer.parseInt(request.getParameter(SEX_ID));
				query += " and me.gender_id = " + sex_id;
				pQry += " and me.sex_id = " + sex_id;
			}
		
		if (!(request.getParameter("fromAge").equals("")) && !(request.getParameter("fromAgeUnit").equals(""))
				&& !(request.getParameter("toAge").equals("")) && !(request.getParameter("toAgeUnit").equals(""))) {
			String fromAge = request.getParameter("fromAge");
			String toAge = request.getParameter("toAge");
	
			query +=" and substr(me.age,0,INSTR(me.age,' ')) >= " +request.getParameter("fromAge")+
					" and  substr(me.age,INSTR(me.age,' ')+1,length(me.age))= '" +request.getParameter("fromAgeUnit")+"'"+
					" and substr(me.age,0,INSTR(me.age,' ')) <= " +request.getParameter("toAge")+
					" and  substr(me.age,INSTR(me.age,' ')+1,length(me.age))='"+request.getParameter("toAgeUnit")+"'";
			
			pQry +=" and substr(me.age,0,INSTR(me.age,' ')) >= " +request.getParameter("fromAge")+
					" and  substr(me.age,INSTR(me.age,' ')+1,length(me.age))= '" +request.getParameter("fromAgeUnit")+"'"+
					" and substr(me.age,0,INSTR(me.age,' ')) <= " +request.getParameter("toAge")+
					" and  substr(me.age,INSTR(me.age,' ')+1,length(me.age))='"+request.getParameter("toAgeUnit")+"'";
			
		}
		String reportName= "";
		if(request.getParameter("relationType")!=null && request.getParameter("relationType").equals("self")){
			reportName= "BloodDonorPanel";
		}else if(request.getParameter("relationType")!=null && request.getParameter("relationType").equals("family")){
			reportName= "BloodDonorPanelFamily";
			if(request.getParameter(RELATION_ID)!=null && !(request.getParameter(RELATION_ID).equals("0"))){
				query += " and me.relation_id = " + Integer.parseInt(request.getParameter(RELATION_ID));
				pQry += " and me.relation_id = " + Integer.parseInt(request.getParameter(RELATION_ID));
			}
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = labHandlerService.getConnectionForReport();

		parameters.put("qry", query);
		parameters.put("pQry", pQry);
		try {
			HMSUtil.generateReport(reportName, parameters,
						(Connection) detailsMap.get("con"), response,
						getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void printDiagnosticNoBarcode(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
        
		int sampleId = 0;
	
		session = request.getSession();

		if (request.getParameter("sampleId") != null) {
			sampleId = Integer.parseInt(request.getParameter("sampleId"));
		}

		detailsMap = labHandlerService.getConnectionForReport();
		parameters.put("sampleId", sampleId);
	
		HMSUtil.generateReport("DiagnosticNoBarcode", parameters,(Connection) detailsMap.get("con"), response,
				getServletContext());
	}
	
	public ModelAndView showInvestigationRequisitionWaitingList(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		int deptId =  (Integer) session.getAttribute("deptId");
		map = labHandlerService.showInvestigationRequisitionWaitingList(hospitalId,deptId);
		
		String jsp ="investigationWaitingList.jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showInvestigationRequisitionJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = labHandlerService.showInvestigationRequisitionJsp(box);
		String jsp ="investigationRequisition.jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView submitInvestigationRequisition(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		box.put("hospitalId", hospitalId);
		box.put("deptId", (Integer) session.getAttribute("deptId"));
		Users users = (Users)session.getAttribute("users");
		box.put("userId", users.getId());
		box.put("userName", users.getUserName());
		map = labHandlerService.submitInvestigationRequisition(box);
		boolean saved = false;
		if(map.get("saved")!=null) {
			saved = (Boolean)map.get("saved");
		}
		if (saved) {
			message = "Investigation Requisition Details submitted successfully !!";
		} else {
			message = " Error Ocurred Please Try Again !!";
		}
		map.put("messageTOBeVisibleToTheUser", message);
		String jsp = "message.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView viewIpdTestForOrderNo(HttpServletRequest request,
			HttpServletResponse response) {
		List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> orderDetailMap = new HashMap<String, Object>();

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}

		HttpSession session = request.getSession();
		String deptName = "";
		String jsp = "";

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		int dgOrderHdId = 0;
		int inPatientId = 0;
		if (request.getParameter("dgOrderHdId") != null) {
			dgOrderHdId = Integer.parseInt(request.getParameter("dgOrderHdId"));
			mapForDs.put("dgOrderHdId", dgOrderHdId);
		}
		if (request.getParameter("hinId") != null) {
			int hinId = Integer.parseInt(request.getParameter("hinId"));
			mapForDs.put("hinId", hinId);
		}
		if (request.getParameter(INPATIENT_ID) != null) {
			inPatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			mapForDs.put("inPatientId", inPatientId);
		}
		if (request.getParameter("dischargeSummaryFlag") != null) {
			map.put("dischargeSummaryFlag", request.getParameter("dischargeSummaryFlag")) ;
		}
		// orderNoList = labHandlerService.getOrderNoList(mapForDs);

		orderDetailMap = labHandlerService.getOrderDtMap(mapForDs);

		jsp = "viewIpdTestDetailsForOrderNo";

		map.put("orderDetailMap", orderDetailMap);
		map.put("orderNoList", orderNoList);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);

		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getInvestigationDetailsForDischargeSummary(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		List<DgResultEntryDetail> invResultList = new ArrayList<DgResultEntryDetail>();
		
		int deptId = (Integer) session.getAttribute("deptId");
		int inPatientId = Integer.parseInt(request.getParameter("parent"));
		//String deptName = request.getParameter("deptName");

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap.put("inPatientId", inPatientId);
		detailsMap.put("deptId", deptId);

		map = labHandlerService.getInvestigationDetailsForDischargeSummary(detailsMap);
		map.put("inPatientId", inPatientId);
	//	map.put("invResultList", invResultList);
		//map.put("deptName", deptName);
		map.put("message", message);
		

		jsp = "investigationForDSPopup";
		
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
		
	}

	public ModelAndView getResponseForPhysiotherapyDetails(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		
		map = labHandlerService.getResponseForPhysiotherapyDetails(box);

		return new ModelAndView("responseIPDPhysiotherapyDetails", "map", map);
	}
	
	public ModelAndView printDiagnosticRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		String query = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		Integer subChargeId = 0;
		Integer depart = 0;
		String patient = "";
		String resultType = "";
		Integer departmentId = 0;
		int hospitalId = 0;
		String dFirst = "";
		String dMiddleName = "";
		String dLastName = "";
		String eFirst = "";
		String eMiddleName = "";
		String eLastName = "";
		String vFirst = "";
		String vMiddleName = "";
		String vLastName = "";
		String currentDate="";
		Date currentDate1 = new Date();
		

		try {

			currentDate = (String) utilMap.get("currentDate");
			
			currentDate1=HMSUtil.convertStringTypeDateToDateType(currentDate);
			
			departmentId = (Integer) session.getAttribute("deptId");
			hospitalId = (Integer) session.getAttribute("hospitalId");
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
			
			if (request.getParameter("subChargeId") != null) {
				subChargeId = Integer.parseInt(request.getParameter("subChargeId"));
			}
			if (request.getParameter("depart") != null) {
				depart = Integer.parseInt(request.getParameter("depart"));
			}
			if (request.getParameter("patient") != null) {
				patient =  request.getParameter("patient");
			}
			if (request.getParameter("resultType") != null) {
				resultType =  request.getParameter("resultType");
			}
		
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
			
			
			
		query=	"where dgh.result_date between '"+sdf.format(fromDate)+"' and '"+sdf.format(toDate)+"' " +
			" and dgh.result_status = 'A' and dgd.result_type = '"+resultType+"' and dgh.hospital_id="+hospitalId;

		
		
		
		if (subChargeId != 0) {
			query += " and dgh.sub_chargecode_id = "+subChargeId;
	}
	if (depart != 0) {
		query += " and mcc.department_id = "+depart;
	}
	if(box.getInt(SERVICE_TYPE_ID)!=0){
	//	crit = crit.createAlias("p.ServiceType", "st").add(Restrictions.eq("st.Id", box.getInt(SERVICE_TYPE_ID)));
		query += " and p.service_type_id = "+box.getInt(SERVICE_TYPE_ID);
	}
	if(box.getInt(SERVICE_STATUS_ID)!=0 ){
	//	crit = crit.createAlias("p.ServiceStatus", "ss").add(Restrictions.eq("ss.Id", box.getInt(SERVICE_STATUS_ID)));
		query += " and p.service_status_id = "+box.getInt(SERVICE_STATUS_ID);
	}
	if(box.getInt("fromRankId")!= 0 && box.getInt("toRankId")!=0){
	//	crit = crit.createAlias("p.Rank", "rank").add(Restrictions.between("rank.Id", box.getInt("fromRankId"),box.getInt("toRankId")));
		query += " and p.rank_id between  "+box.getInt("fromRankId")+" and "+box.getInt("toRankId");
	}
	if(box.getInt(RANK_CATEGORY_ID)!=0){
//		crit = crit.createAlias("rank.RankCategory", "rc").add(Restrictions.eq("rc.Id", box.getInt(RANK_CATEGORY_ID)));
		query += " and r.rank_category_id = "+box.getInt(RANK_CATEGORY_ID);
	}
	if(box.getInt(TRADE_ID)!=0 ){
//		crit = crit.createAlias("p.Trade", "tr").add(Restrictions.eq("tr.Id", box.getInt(TRADE_ID)));
		query += " and p.trade_id = "+box.getInt(TRADE_ID);
	}
	if(box.getInt(UNIT_ID)!=0){
//		crit = crit.createAlias("p.Unit", "u").add(Restrictions.eq("u.Id", box.getInt(UNIT_ID)));
		query += " and p.unit_id = "+box.getInt(UNIT_ID);
	}
	if(box.getInt(SECTION_ID)!=0){
//		crit = crit.createAlias("p.Section", "se").add(Restrictions.eq("se.Id", box.getInt(SECTION_ID)));
		query += " and p.section_id = "+box.getInt(SECTION_ID);
	}
	if(box.getInt(MARITAL_STATUS_ID)!=0){
//		crit = crit.createAlias("p.MaritalStatus", "ms").add(Restrictions.eq("ms.Id", box.getInt(MARITAL_STATUS_ID)));
		query += " and p.marital_status_id = "+box.getInt(MARITAL_STATUS_ID);
	}
	if(box.getInt(SEX_ID)!=0 ){
//		crit = crit.createAlias("p.Sex", "sex").add(Restrictions.eq("sex.Id", box.getInt(SEX_ID)));
		query += " and p.sex_id = "+box.getInt(SEX_ID);
	}
	if (!(box.getString(SERVICE_NO).equals(""))) {
//		crit = crit.add(Restrictions.eq("p.ServiceNo", box.getInt(SERVICE_NO)));
		query += " and p.service_no = '"+box.getString(SERVICE_NO)+"'";
	}
	if (!(box.getString("fromAge").equals("")) && !(box.getString("fromAgeUnit").equals(""))
			&& !(box.getString("toAge").equals("")) && !(box.getString("toAgeUnit").equals(""))) {
		String fromAge = box.getString("fromAge");
		String toAge = box.getString("toAge");
		query += " and substr(p.age,0,INSTR(p.age,' ')) >="+fromAge+" " +
				" and  substr(p.age,INSTR(p.age,' ')+1,length(p.age))='"+box.getString("fromAgeUnit")+"'" +
				" and substr(p.age,0,INSTR(p.age,' ')) <="+toAge+" " +
				" and  substr(p.age,INSTR(p.age,' ')+1,length(p.age))='"+box.getString("toAgeUnit")+"'";
	
	}
	if (!(box.getString("fromServ").equals("")) && !(box.getString("fromServUnit").equals(""))
			&& !(box.getString("toServ").equals("")) && !(box.getString("toServUnit").equals(""))) {
		String fromServ = box.getString("fromServ");
		String toServ = box.getString("toServ");
		query +="  p.service_years >="+fromServ+" " +
				" and  total_service_period='"+box.getString("fromServUnit")+"'" +
				" and p.service_years <="+toServ+" " +
				" and  total_service_period='"+box.getString("toServUnit")+"'";
		
	}
	if(box.getInt(CONSULTING_DOCTOR)!=0 ){
		query += " and pb.employee_id = "+box.getInt(CONSULTING_DOCTOR)+"";
	}
	if(box.getInt(INVESTIGATION_ID)!=0 ){
		query += " and dgh.investigation_id = "+box.getInt(INVESTIGATION_ID);
	}
	
	/*if ( !(box.getString("icd").equals(""))) {
		String icd = box.getString("icd");
		 int index1=icd.lastIndexOf("[");
		  int index2=icd.lastIndexOf("]");
		   index1++;
		   String icdCode =""+icd.substring(index1, index2);
		   query += " and icd.icd_code='"+icdCode+"'";
	
	}
	if (!(box.getString("icdNo").equals(""))) {
		query += " and icd.icd_code='"+box.getString("icdNo")+"'";
	}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		// detailsMap = labHandlerService.getSubCharge();
		detailsMap = labHandlerService.getConnectionForReport();
		parameters.put("query", query);
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("currentDate1", currentDate1);
		try {
			byte[] bytes = null;
			try {
				String reportName= "";
				if(resultType.equals("s")){
					reportName="diagnostic_register";
				}else{
					reportName= "diagnostic_register_multiple";
				}
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport(reportName),
						parameters, (Connection) detailsMap.get("con"));

			} catch (JRException e) {

				e.printStackTrace();
			}
			response.setHeader("Content-Disposition", "inline; filename="
					+ "dgInvestigationRequired" + ".pdf");
			response.setContentType("application/pdf");
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

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	
	
	public ModelAndView printDiagnosticRegisterSummary(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		List<MasHospital> hospitalNameList = new ArrayList<MasHospital>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		String query = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		Integer subChargeId = 0;
		Integer depart = 0;
		String patient = "";
		String resultType = "";
		Integer departmentId = 0;
		int hospitalId = 0;
		String dFirst = "";
		String dMiddleName = "";
		String dLastName = "";
		String eFirst = "";
		String eMiddleName = "";
		String eLastName = "";
		String vFirst = "";
		String vMiddleName = "";
		String vLastName = "";
		String currentDate="";
		Date currentDate1 = new Date();
		
		

		try {

			
			currentDate = (String) utilMap.get("currentDate");
			
			currentDate1=HMSUtil.convertStringTypeDateToDateType(currentDate);
			
			departmentId = (Integer) session.getAttribute("deptId");
			hospitalId = (Integer) session.getAttribute("hospitalId");
			String fromDate1 =sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
			String toDate1 = sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
			query=	"where dgh.result_date between '"+fromDate+"' and '"+toDate+"' and dgh.hospital_id ="+hospitalId;
			
			if(box.getInt(DEPARTMENT_ID)!=0) {
				query += " and mcc.department_id="+box.getInt(DEPARTMENT_ID);
			}
			if(box.getInt(SUB_CHARGECODE_ID)!=0) {
				query += " and inv.sub_chargecode_id="+box.getInt(SUB_CHARGECODE_ID);
			}
			if(box.getInt(INVESTIGATION_ID)!=0) {
				query += " and inv.investigation_id="+box.getInt(INVESTIGATION_ID);
			}
			
			query=" order by mcc.main_chargecode_name,scc.sub_chargecode_name,investigation_name";
		} catch (Exception e) {
			e.printStackTrace();
		}
		// detailsMap = labHandlerService.getSubCharge();
		detailsMap = labHandlerService.getConnectionForReport();
		
		dataMap = labHandlerService.getHospitalName(hospitalId);
		
		String hospitalName="";
		String hospitalAddress="";
		hospitalNameList=(List)dataMap.get("hospitalNameList");
		if(hospitalNameList.size()>0)
		{
			hospitalName=hospitalNameList.get(0).getHospitalName();
			hospitalAddress=hospitalNameList.get(0).getAddress();
		}
		parameters.put("hospitalName", hospitalName);
		parameters.put("hospitalAddress", hospitalAddress);
		parameters.put("query", query);
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("currentDate1", currentDate1);
		parameters.put("hospitalId", hospitalId);
		try {
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("diagnostic_register_summary"),
						parameters, (Connection) detailsMap.get("con"));

			} catch (JRException e) {

				e.printStackTrace();
			}
			response.setHeader("Content-Disposition", "inline; filename="
					+ "dgInvestigationRequired" + ".pdf");
			response.setContentType("application/pdf");
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

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	public ModelAndView viewPatientDocuments(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		String filename = null;
		String fileExtension = null;
		MultipartFormDataRequest mrequest = null;

		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Map<String, Object> uploadFileMap = new HashMap<String, Object>();

	//	String uploadURL = getServletContext().getRealPath("/upload/");
		String userHome = getServletContext().getRealPath("");
		String fileSeparator = System.getProperty("file.separator");
		String uploadURL = userHome.substring(0, userHome
				.lastIndexOf(fileSeparator))
				+ fileSeparator
				+ "HMSDocumentFolder"
				+ fileSeparator
				+ "upload" + fileSeparator;
		
		// String whiteList = "*.zip";
		// String whiteList = "*.jpg";

		// Long fileSizeLimit = 2097152l;

		/*
		 * List fileUploadedList = null; fileUploadedList =
		 * HMSUtil.uploadFile(mrequest,uploadURL, whiteList,
		 * box.getString("filename"));
		 * //System.out.println("fileUploadedList="+fileUploadedList.size());
		 * Boolean fileUploaded=false; if(fileUploadedList != null &&
		 * fileUploadedList.size()!=0) { fileUploaded = (Boolean)
		 * fileUploadedList.get(0); }
		 */
		box.put("uploadURL", uploadURL);
		StringTokenizer st1 = new StringTokenizer(box.getString("filename"),
				".");
		filename = st1.nextToken();
		fileExtension = st1.nextToken();

		box.put("filename", box.getString("filename"));
		try {
			if (fileExtension == "doc" || fileExtension == "docx") {
				response.setContentType("application/vnd.ms-word");
			} else if (fileExtension == "xls" || fileExtension == "xlsx") {
				response.setContentType("application/vnd.ms-excel");
			} else if (fileExtension == "pdf") {
				response.setContentType("application/pdf");
			} else if (fileExtension.trim().equalsIgnoreCase("txt")) {
				response.setContentType("text/plain");
			} else if (fileExtension.trim().equalsIgnoreCase("ppt")) {
				response.setContentType("application/ppt");
			} else if (fileExtension == "png") {
				response.setContentType("image/png");
			} else if (fileExtension == "jpeg") {
				response.setContentType("image/jpeg");
			} else if (fileExtension == "wbmp") {
				response.setContentType("image/vnd.wap.wbmp");
			} else if (fileExtension == "gif") {
				response.setContentType("image/gif");
			} else if (fileExtension == "jpg") {
				response.setContentType("image/jpg");
			} else {
				response.setContentType("application/octet-stream");
			}
			// set the header and also the Name by which user will be prompted
			// to save
			response.setHeader("Content-Disposition", "attachment;filename="
					+ java.net.URLEncoder.encode(box.getString("filename"))
					+ "");

			// System.out.println("box.getString(filename)==" + filename + "."+
			// fileExtension);
			// response.setContentType("image/"+fileExtension);
			// response.setHeader("Content-Disposition", "attachment;
			// filename="+filename+"."+fileExtension);

			File f = new File(uploadURL + "/" + filename + "." + fileExtension);
			InputStream in = new FileInputStream(f);
			response.getOutputStream().flush();
			ServletOutputStream outs = response.getOutputStream();

			long length = f.length();

			if (length > Integer.MAX_VALUE) {
				// File is too large
			}

			// Create the byte array to hold the data
			byte[] bytes = new byte[(int) length];

			int offset = 0;
			int numRead = 0;
			while (offset < bytes.length
					&& (numRead = in.read(bytes, offset, bytes.length - offset)) >= 0) {
				offset += numRead;
			}

			if (offset < bytes.length) {
			}
			outs.write(bytes);
			in.close();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		jsp = "opdViewPatientDoc";
		jsp += ".jsp";
		title = "Import CD";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	
	
	public void showLabHelp(HttpServletRequest request,HttpServletResponse response) {

		Box box = HMSUtil.getBox(request);
		String filename = null;
		String fileExtension = null;
		MultipartFormDataRequest mrequest = null;

		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Map<String, Object> uploadFileMap = new HashMap<String, Object>();

	//	String uploadURL = getServletContext().getRealPath("/upload/");
		String userHome = getServletContext().getRealPath("");
		String fileSeparator = System.getProperty("file.separator");
		String uploadURL = userHome
				+ fileSeparator
				+ "help"
				+ fileSeparator;
				
		
		// String whiteList = "*.zip";
		// String whiteList = "*.jpg";

		// Long fileSizeLimit = 2097152l;

		/*
		 * List fileUploadedList = null; fileUploadedList =
		 * HMSUtil.uploadFile(mrequest,uploadURL, whiteList,
		 * box.getString("filename"));
		 * //System.out.println("fileUploadedList="+fileUploadedList.size());
		 * Boolean fileUploaded=false; if(fileUploadedList != null &&
		 * fileUploadedList.size()!=0) { fileUploaded = (Boolean)
		 * fileUploadedList.get(0); }
		 */
		
		try {
			
			response.setContentType("application/pdf");
			
			response.setHeader("Content-Disposition", "attachment;filename="
					+ java.net.URLEncoder.encode("Laboratory.pdf")
					+ "");

			// System.out.println("box.getString(filename)==" + filename + "."+
			// fileExtension);
			// response.setContentType("image/"+fileExtension);
			// response.setHeader("Content-Disposition", "attachment;
			// filename="+filename+"."+fileExtension);

			File f = new File(uploadURL + "/Laboratory.pdf");
			InputStream in = new FileInputStream(f);
			response.getOutputStream().flush();
			ServletOutputStream outs = response.getOutputStream();

			long length = f.length();

			if (length > Integer.MAX_VALUE) {
				// File is too large
			}

			// Create the byte array to hold the data
			byte[] bytes = new byte[(int) length];

			int offset = 0;
			int numRead = 0;
			while (offset < bytes.length
					&& (numRead = in.read(bytes, offset, bytes.length - offset)) >= 0) {
				offset += numRead;
			}

			if (offset < bytes.length) {
			}
			outs.write(bytes);
			in.close();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	
	}
	
	public ModelAndView investigationResult(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap1 = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		Map<String, Object> resultDetailsMap = new HashMap<String, Object>();
		List<Map<String, Object>> resultDetailsMapList = new ArrayList<Map<String, Object>>(); 
		String query = "";
		int srn = 0;
		String src = "";
		int id = 0;
		String crit = "";
		String deptName = "";
		int deptId = 0;
		Box box=HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		box.put("deptId", deptId); 
		map.put("chargeCodeId", box.get("chargeCodeId"));
		try {   
				detailsMap1 = labHandlerService
						.investigationResult(box);

				map.put("detailsMap1", detailsMap1);
				map.put("deptName", deptName);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("investigationResultJspForOP", "map", map);
	}
	
	public ModelAndView showLabStatisTicsJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		String jsp = "";
		jsp = "labStatisticsDetails.jsp";
		map.put("contentJsp", jsp);
		
		return new ModelAndView("index","map",map);
	}
	public ModelAndView generateLABStatistics(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String,Object> map = new HashMap<String,Object>();
		HttpSession session = request.getSession();
		String deptName="";
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);		
		int deptId = (Integer) session.getAttribute("deptId");		
		List<StoreItemBatchStock> stockList = new ArrayList<StoreItemBatchStock>();		
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		String hospitalName = "HAL Hospital";
		box.put("hospitalName", hospitalName);		
		box.put("deptId", deptId);		
		if (session.getAttribute("deptName") != null) {
			deptName = session.getAttribute("deptName").toString();
			box.put("deptName", deptName);
		}
		
		String userHome = getServletContext().getRealPath("");	         
	    String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
	    map.put("path", imagePath);

		
		Date fromDate = null;
		Date toDate = null;
		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
			map.put("fromDate", fromDate);
		}
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
			map.put("toDate", toDate);
		}
		
		
		Map<String, Object> connectionMap = labHandlerService
				.getConnectionForReport();
		map.put("hospitalName", hospitalName);
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		
		HMSUtil.generateReport("labreport", map,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return null;

	}
	
	
	public ModelAndView showBackupSampleCollectionJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		detailsMap.put("deptId",  (Integer) session.getAttribute("deptId"));
		//detailsMap = labHandlerService.getDetailsForSearch(detailsMap);
		mapForDs.put("deptId",  (Integer) session.getAttribute("deptId"));
		mapForDs.put("hospitalId", (Integer) session.getAttribute("hospitalId"));
		mapForDs.put("requestFromMethod", "showPendingSampleCollectionJsp");
		//patientMap = labHandlerService.getSampleCollectionGrid(mapForDs);

		jsp = "backUpSampleCollection" + ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForBackUp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = null;
		Date toDate = null;
		
		String orderNo = "";
		String serviceNo = "";
		String hinNo = "";
		String adNo = "";
		String flag = "";
		String pType = "";
		int chargeCodeId = 0;
		int departmentId = 0;
		int inpatientId = 0;
		int subGroupId = 0;
		int sampleId = 0;
		int hinId = 0;
		String deptName = "";
		String deptType1="";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();
		
		detailsMap.put("deptId",  (Integer) session.getAttribute("deptId"));

		try {

			if (session.getAttribute("deptName") != null)
				deptName = (String) session.getAttribute("deptName");
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				mapForDs.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				mapForDs.put("toDate", toDate);
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				pType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("pType", pType);
			}
			
			
			if (request.getParameter("orderNo") != null
					&& !(request.getParameter("orderNo").equals(""))) {
				orderNo = request.getParameter("orderNo");
				mapForDs.put("orderNo", orderNo);
			}
			
			System.out.println("orderNo1="+orderNo);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		mapForDs.put("hospitalId", (Integer)session.getAttribute("hospitalId"));
		mapForDs.put("requestFromMethod", "searchPatient");
		patientMap = labHandlerService.getPatientDetailsforBackup(mapForDs);
		String diagSeqNo = "";
		String jsp = "";
		List<DgOrderhd> patientList = new ArrayList<DgOrderhd>();
		if (patientMap.get("patientDetailList") != null) 
		{
			patientList = (List<DgOrderhd>) patientMap.get("patientDetailList");
		}
		
		boolean completedCollectionFlag=false;
		if (patientMap.get("completedCollectionFlag") != null) 
		{
			completedCollectionFlag = (Boolean) patientMap.get("completedCollectionFlag");
		}
		
		
		map = labHandlerService.getSampleCollectionDetails(mapForDs);
		
		if (map != null && map.get("dgOrderhdList") != null) {
			//diagSeqNo = labHandlerService.generateDiagNumber();
			diagSeqNo=(String)map.get("diagSeqNo");
			if(diagSeqNo!=null){
			map.put("diagSeqNo", diagSeqNo);
			}
						map.put("flag", flag);
			jsp = SAMPLE_COLLECTION + ".jsp";
		} else {
			mapForDs.put("deptId",  (Integer) session.getAttribute("deptId"));
			detailsMap = labHandlerService.getDetailsForSearch(mapForDs);
			if(flag.equalsIgnoreCase("RADIO")){
				jsp = PENDING_SAMPLE_VALIDATION + ".jsp";
			}else if(flag.equalsIgnoreCase("DIAG")){
				if(completedCollectionFlag == false)
				jsp = PENDING_SAMPLE_COLLECTION + ".jsp";
				
				if(completedCollectionFlag == true)
					jsp = "completedSampleCollectionBackupList.jsp";
			}
		}
		map.put("box", box);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		
		map.put("deptType1", deptType1);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	
}
