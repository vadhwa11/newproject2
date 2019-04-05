/**  
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * BillingController.java – 
 * Purpose of the class - This is for OP Billing. 
 * @author  Ritu Sahu 
 * Create Date: 1st Apr,2008   
 * Revision Date:      
 * Revision By: Purpose
 * @version 1.0  
 **/

package jkt.hms.billing.controller;

import static jkt.hms.util.RequestConstants.*;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.billing.handler.BillingHandlerService;
import jkt.hms.lab.handler.LabHandlerService;
import jkt.hms.masters.business.BlChargeSlipMain;
import jkt.hms.masters.business.BlOpBillHeader;
import jkt.hms.masters.business.BlPatientLedger;
import jkt.hms.masters.business.BlReceiptHeader;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasCaseType;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasCompany;
import jkt.hms.masters.business.MasComplaint;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasPatientType;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


public class BillingController extends MultiActionController {

	private static final String BILLING_RESPONSE_FOR_CHARGE_CODE_DETAIL_JSP = null;
	
	private static final String PAYABLE_AMOUNT = null;
	
	//private static final String MESSAGE_FOR_BILLING_JSP = null;
	LabHandlerService labHandlerService = null;
	
	BillingHandlerService billingHandlerService = null;
	String jsp=""; 
	/**
	 * --------------------------- Method to show IP Billing search jsp
	 * -----------------------------------
	 * 
	 */
	public ModelAndView showIpBillingSearchJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = IP_BILLING_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * --------------------------- Method to get hin no for billing search
	 * -----------------------------------
	 * 
	 */

	public ModelAndView getHinNoForBilling(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		String flag = "";
		List<Patient> hinNoList = new ArrayList<Patient>();
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			map.put("flag", flag);
		}
		hinNoList = billingHandlerService.getHinNo(serviceNo);
		if (hinNoList.size() > 0) {
			map.put("hinNoList", hinNoList);
		}
		String jsp = "populateHinNoForUpdate";

		return new ModelAndView(jsp, "map", map);
	}

	/**
	 * --------------------------- Method to get Admission no for billing search
	 * -----------------------------------
	 * 
	 */

	public ModelAndView getAdNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hin = "";
		String flag = "";
		List<Inpatient> adNoList = new ArrayList<Inpatient>();
		if (request.getParameter(HIN_NO) != null) {
			hin = request.getParameter(HIN_NO);
		}
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			map.put("flag", flag);
		}
		adNoList = billingHandlerService.getAdNo(hin);
		if (adNoList.size() > 0) {
			map.put("adNoList", adNoList);
		}
		String jsp = "billingResponseForAdNo";

		return new ModelAndView(jsp, "map", map);
	}

	/**
	 * --------------------------- Method to get patient details for IP billing
	 * -----------------------------------
	 * 
	 */

	public ModelAndView getPatientDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String adNo = "";
		if (request.getParameter(AD_NO) != null) {
			adNo = request.getParameter(AD_NO);
		}

		map = billingHandlerService.getPatientDetails(adNo);
		detailsMap = billingHandlerService.getMainAndSubCharge();
		map.put("detailsMap", detailsMap);

		String includedJsp = IP_BILLING_PATIENT_DETAILS_JSP + ".jsp";
		map.put("includedJsp", includedJsp);
		String jsp = "";
		jsp = IP_BILLING_SEARCH_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * --------------------------- Method to get charge code for auto
	 * complete-----------------------------------
	 * 
	 */

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

		map = billingHandlerService.getChargeCode(parameterMap);

		String jsp = "";
		jsp = RESPONSE_FOR_CHARGE_CODE_GRID_JSP;

		return new ModelAndView(jsp, "map", map);
	}

	/**
	 * --------------------------- Method to fill details in grid for Charge
	 * code -----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public void fillItemsForChargeCode(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String chargeName = "";
		List chargeList = new ArrayList();
		try {
			if (request.getParameter("chargeName") != null) {
				chargeName = request.getParameter("chargeName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("chargeName", chargeName);

		map = billingHandlerService.fillItemsForChargeCode(dataMap);
		if (map.get("chargeList") != null) {
			chargeList = (List) map.get("chargeList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			MasChargeCode masChargeCode = (MasChargeCode) chargeList.get(0);
			int chargeId = masChargeCode.getId();
			Float amount = masChargeCode.getCharge();

			sb.append("<item>");
			sb.append("<chargeId>" + chargeId + "</chargeId>");
			if ((amount == null) || (amount.equals("")))
				sb.append("<amount>" + "-" + "</amount>");
			else
				sb.append("<amount>" + amount + "</amount>");
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
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * --------------------------- Method to submit billing details of a
	 * patient-----------------------------------
	 * 
	 */

	@SuppressWarnings( { "deprecation", "unchecked" })
	public ModelAndView submitBillingDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		String hinNo = "";
		int hinId = 0;
		int inpatientId = 0;
		BigDecimal billAmt = null;
		BigDecimal discountAmt = null;
		String date = "";
		String time = "";
		int pageNo = 1;
		int noOfRecords = 0;
		String buttonFlag = "";
		int chargeMainIdFromRequest = 0;

		List chargeList = new ArrayList();
		List qtyList = new ArrayList();
		List rateList = new ArrayList();
		List amountList = new ArrayList();
		List discountList = new ArrayList();
		List netAmountList = new ArrayList();

		HttpSession session = request.getSession();

		String userName = (String) session.getAttribute("userName");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");

		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			infoMap.put("hospitalId", hospitalId);
		}
		if (request.getParameter("chargeSlipMainId") != null) {
			chargeMainIdFromRequest = Integer.parseInt(request
					.getParameter("chargeSlipMainId"));
		}
		String adNo = "";
		if (request.getParameter(AD_NO) != null) {
			adNo = request.getParameter(AD_NO);
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}
		if (request.getParameter(HIN_ID) != null) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter(INPATIENT_ID) != null) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
		}
		if (request.getParameter(BILL_AMOUNT) != null) {
			billAmt = new BigDecimal(request.getParameter(BILL_AMOUNT));
		}
		if (request.getParameter(DISCOUNT_AMOUNT) != null
				&& !request.getParameter(DISCOUNT_AMOUNT).equals("")) {
			discountAmt = new BigDecimal(request.getParameter(DISCOUNT_AMOUNT));
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

		BlChargeSlipMain blChargeSlipMain = new BlChargeSlipMain();

		if (pageNo == 1) {
			Patient patient = new Patient();
			patient.setId(hinId);
			blChargeSlipMain.setHin(patient);

			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);
			blChargeSlipMain.setInpatient(inpatient);

			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			blChargeSlipMain.setHospital(hospital);

			int chargeSlipNo = 0;
			chargeSlipNo = billingHandlerService.getChargeSlipNo();
			blChargeSlipMain.setChargeSlipNo(chargeSlipNo);
			blChargeSlipMain.setBillAmt(billAmt);
			blChargeSlipMain.setDisAmt(discountAmt);
			blChargeSlipMain.setBillDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			blChargeSlipMain.setBillTime(time);
			blChargeSlipMain.setLastChgBy(userName);
			blChargeSlipMain.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			blChargeSlipMain.setLastChgTime(time);
			blChargeSlipMain.setStatus("y");
			infoMap.put("blChargeSlipMain", blChargeSlipMain);
		}
		infoMap.put("billAmt", billAmt);
		infoMap.put("discountAmt", discountAmt);
		String discount = "";

		try {

			for (int i = 1; i < noOfRecords; i++) {
				if (request.getParameter(CHARGE_CODE_ID + i) != null
						&& !request.getParameter(CHARGE_CODE_ID + i).equals("")) {
					chargeList.add(request.getParameter(CHARGE_CODE_ID + i));
				}
				if (request.getParameter(QUANTITY + i) != null
						&& !request.getParameter(QUANTITY + i).equals("")) {
					qtyList.add(request.getParameter(QUANTITY + i));
				}
				if (request.getParameter(AMOUNT + i) != null
						&& !request.getParameter(AMOUNT + i).equals("")) {
					amountList.add(request.getParameter(AMOUNT + i));
				}
				if (request.getParameter(RATE + i) != null
						&& !request.getParameter(RATE + i).equals("")) {
					rateList.add(request.getParameter(RATE + i));
				}
				if (request.getParameter(DISCOUNT + i) != null
						&& !request.getParameter(DISCOUNT + i).equals("")) {
					discount = request.getParameter(DISCOUNT + i);
				} else {
					discount = "0";
				}
				discountList.add(discount);
				if (request.getParameter(NET_AMOUNT + i) != null
						&& !request.getParameter(NET_AMOUNT + i).equals("")) {
					netAmountList.add(request.getParameter(NET_AMOUNT + i));
				}

			}
			infoMap.put("chargeMainIdFromRequest", chargeMainIdFromRequest);
			infoMap.put("chargeList", chargeList);
			infoMap.put("qtyList", qtyList);
			infoMap.put("rateList", rateList);
			infoMap.put("amountList", amountList);
			infoMap.put("discountList", discountList);
			infoMap.put("netAmountList", netAmountList);
			infoMap.put("userName", userName);
			infoMap.put("inpatientId", inpatientId);
			infoMap.put("hinId", hinId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean success = false;
		String jsp = "";
		String message = "";
		int chargeSlipMainId = 0;

		returnMap = billingHandlerService.submitBillingDetails(infoMap);
		if (returnMap.get("success") != null) {
			success = (Boolean) returnMap.get("success");
		}
		if (success) {
			if (buttonFlag.equals("next")) {
				pageNo++;
				message = "Billing has been done Successfully";
				map = billingHandlerService.getPatientDetails(adNo);
				detailsMap = billingHandlerService.getMainAndSubCharge();
				map.put("detailsMap", detailsMap);
				map.put("pageNo", pageNo);
				if (returnMap.get("chargeSlipMainId") != null) {
					chargeSlipMainId = (Integer) returnMap
							.get("chargeSlipMainId");
					map.put("chargeSlipMainId", chargeSlipMainId);
				}
				String includedJsp = IP_BILLING_PATIENT_DETAILS_JSP + ".jsp";
				map.put("includedJsp", includedJsp);
				jsp = IP_BILLING_SEARCH_JSP + ".jsp";
			} else {
				jsp = MESSAGE_FOR_ADT_JSP + ".jsp";
				pageNo++;
				message = "Billing has been done Successfully";
			}
		} else {
			jsp = MESSAGE_FOR_ADT_JSP + ".jsp";
			message = "Billing has not been done Successfully";
		}
		map.put("pageNo", pageNo);
		map.put("message", message);
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	/**
	 * --------------------------- Method to Show Search jsp for Patient Advance
	 * and Patient Final Settlement-----------------------------------
	 * 
	 */

	public ModelAndView showSearchJspForDepositAndSettlement(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = billingHandlerService.getDetailsForSearch();
		String jsp = "";
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}
		if (flag.equals("searchDeposit")) {
			jsp = SEARCH_PATIENT_FOR_ADVANCE_JSP + ".jsp";
		} else if (flag.equals("searchFinalSettlement")) {
			jsp = SEARCH_PATIENT_FOR_FINAL_SETTLEMENT_JSP + ".jsp";
		}
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * --------------------------- Method to search patient for advance and
	 * final settlement-----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatient(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();

		String serviceNo = "";
		String hinNo = "";
		int serviceTypeId = 0;
		int rankId = 0;
		int unitId = 0;
		String serPersonFName = "";
		String serPersonMName = "";
		String serPersonLName = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		int hinId = 0;
		String flag = "";
		try {
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(SERVICE_TYPE_ID) != null
					&& !(request.getParameter(SERVICE_TYPE_ID).equals("0"))) {
				serviceTypeId = Integer.parseInt(request
						.getParameter(SERVICE_TYPE_ID));
				mapForDs.put("serviceTypeId", serviceTypeId);
			}
			if (request.getParameter(RANK_ID) != null
					&& !(request.getParameter(RANK_ID).equals("0"))) {
				rankId = Integer.parseInt(request.getParameter(RANK_ID));
				mapForDs.put("rankId", rankId);
			}
			if (request.getParameter(UNIT_ID) != null
					&& !(request.getParameter(UNIT_ID).equals("0"))) {
				unitId = Integer.parseInt(request.getParameter(UNIT_ID));
				mapForDs.put("unitId", unitId);
			}
			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if (request.getParameter(S_MIDDLE_NAME) != null
					&& !(request.getParameter(S_MIDDLE_NAME).equals(""))) {
				serPersonMName = request.getParameter(S_MIDDLE_NAME);
				mapForDs.put("serPersonMName", serPersonMName);
			}
			if (request.getParameter(S_LAST_NAME) != null
					&& !(request.getParameter(S_LAST_NAME).equals(""))) {
				serPersonLName = request.getParameter(S_LAST_NAME);
				mapForDs.put("serPersonLName", serPersonLName);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(P_MIDDLE_NAME) != null
					&& !(request.getParameter(P_MIDDLE_NAME).equals(""))) {
				patientMName = request.getParameter(P_MIDDLE_NAME);
				mapForDs.put("patientMName", patientMName);
			}
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDs.put("patientLName", patientLName);
			}
			if (request.getParameter("hinId") != null) {
				hinId = Integer.parseInt(request.getParameter("hinId"));
				mapForDs.put("hinId", hinId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = billingHandlerService.getPatientDetails(mapForDs);

		String jsp = "";
		List<Patient> patientList = new ArrayList<Patient>();
		List<BlPatientLedger> previousDepositList = new ArrayList<BlPatientLedger>();
		if (patientMap.get("patientDetailsList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDetailsList");
		}
		if ((!hinNo.equals("") && patientList.size() > 0) || hinId != 0) {
			for (Patient patient : patientList) {
				if (patient.getPatientStatus().equals("In Patient")) {
					int inpatientId = 0;
					try {
						if (patient.getInpatients() != null) {
							Set<Inpatient> inpatientSet = patient
									.getInpatients();
							for (Inpatient inpatient : inpatientSet) {
								if (!inpatient.getAdStatus().equals("D")) {
									inpatientId = inpatient.getId();
								}
							}
						}
					} catch (RuntimeException e) {
						e.printStackTrace();
					}
					String receiptNo = "";
					String refundNo = "";
					if (flag.equals("deposit")) {
						receiptNo = billingHandlerService
								.getSeqNoForDisplay("RE");
						previousDepositList = billingHandlerService
								.getDepositOfPatient(inpatientId);
						map.put("previousDepositList", previousDepositList);
						map.put("receiptNo", receiptNo);
						jsp = DEPOSITS_JSP + ".jsp";
					} else if (flag.equals("finalSettlement")) {
						List<BlPatientLedger> patientLedgerList = new ArrayList<BlPatientLedger>();
						patientLedgerList = billingHandlerService
								.getTotalAdvAndBillAmt(inpatientId);
						if (patientLedgerList.size() > 0) {
							for (BlPatientLedger patientLedger : patientLedgerList) {
								BigDecimal totalChargeSlipAmt = null;
								BigDecimal totalAdvAmt = null;
								BigDecimal diffAmt = null;
								try {
									totalChargeSlipAmt = patientLedger
											.getTotalChargeSlipAmt();
								} catch (Exception e) {
									totalChargeSlipAmt = new BigDecimal(0);
								}
								try {
									totalAdvAmt = patientLedger
											.getTotalAdvAmt();
								} catch (Exception e) {
									totalAdvAmt = new BigDecimal(0);
								}
								try {
									diffAmt = totalChargeSlipAmt
											.subtract(totalAdvAmt);
								} catch (Exception e) {
									diffAmt = totalChargeSlipAmt;
								}
								map.put("diffAmt", diffAmt);
								if (diffAmt != null) {
									if (diffAmt.intValue() < 0) {
										refundNo = billingHandlerService
												.getSeqNoForDisplay("RF");
										map.put("refundNo", refundNo);
									} else if (diffAmt.intValue() >= 0) {
										receiptNo = billingHandlerService
												.getSeqNoForDisplay("RE");
										map.put("receiptNo", receiptNo);
									}
								}
							}
						}

						map.put("patientLedgerList", patientLedgerList);
						jsp = BILLING_FINAL_SETTLEMENT_JSP + ".jsp";
					}
				}
			}
		} else {
			map = billingHandlerService.getDetailsForSearch();
			if (flag.equals("deposit")) {
				jsp = SEARCH_PATIENT_FOR_ADVANCE_JSP + ".jsp";
			} else if (flag.equals("finalSettlement")) {
				jsp = SEARCH_PATIENT_FOR_FINAL_SETTLEMENT_JSP + ".jsp";
			}
		}

		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * --------------------------- Method to submit Deposit details of a
	 * patient-----------------------------------
	 * 
	 */

	public ModelAndView submitDepositDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		boolean saved = false;
		int hospitalId = 0;
		String userName = "";
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameterMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			parameterMap.put("userName", userName);
		}

		Box box = HMSUtil.getBox(request);
		parameterMap.put("box", box);

		map = billingHandlerService.submitDepositDetails(parameterMap);
		saved = (Boolean) map.get("saved");
		String message = "";
		if (saved) {
			message = "Deposit Information Saved Successfully.";
		} else {
			message = "Some Problem Occured.";
		}
		map.put("message", message);
		String jsp = MESSAGE_FOR_ADT_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * --------------------------- Method to submit Deposit details of a
	 * patient-----------------------------------
	 * 
	 */

	public ModelAndView submitBillingFinalSettlementDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		int hospitalId = 0;
		String userName = "";
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}

		map = billingHandlerService.submitBillingFinalSettlementDetails(box);
		saved = (Boolean) map.get("saved");
		String message = "";
		if (saved) {
			message = "Patient Final Settlement Information Saved Successfully.";
		} else {
			message = "Some Problem Occured.";
		}
		map.put("message", message);
		String jsp = MESSAGE_FOR_ADT_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAdvanceAndRefundSearchReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "advanceHsrSearchReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printAdvanceAndRefundHsrReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter("reportType") != null) {
			flag = request.getParameter("reportType");
		}

		detailsMap = billingHandlerService.getConnectionForReport();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		String fileName = "";
		if (flag.equals("advance")) {
			fileName = "Advance_of_HSR";
		} else {
			fileName = "Refund_of_HSR";
		}
		try {
			byte bytes[] = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport(fileName), parameters,
						(Connection) detailsMap.get("conn"));
			} catch (JRException e) {
				e.printStackTrace();
			}

			// response.setHeader("Content-Disposition",
			// "attachment; filename=RegistrationCard.pdf");
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
		return new ModelAndView("index");
	}

	private JasperReport getCompiledReport(String fileName) throws JRException {

		File reportFile = new File(getServletContext().getRealPath(
				"/reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile.getPath());

		return jasperReport;
	}

	public BillingHandlerService getBillingHandlerService() {
		return billingHandlerService;
	}

	public void setBillingHandlerService(
			BillingHandlerService billingHandlerService) {
		this.billingHandlerService = billingHandlerService;
	}
	
	public ModelAndView showPendingBillServicingJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		Box box=HMSUtil.getBox(request);
		box.put(HOSPITAL_ID, hospitalId);
		map = billingHandlerService.getPendingListOfPatient(box);
		String jsp = BILL_SERVICING_SEARCH_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPendingBillOtherPatientJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		Box box=HMSUtil.getBox(request);
		box.put(HOSPITAL_ID, hospitalId);
		map = billingHandlerService.getPendingListOfPatientOther(box);
		String jsp = "PendingBillOtherPatientJsp.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView getPatientDetailsForOpBilling(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		HttpSession  session=request.getSession();
		String hinNo = "";
		String orderNo = "";
		String tempBillNo = "";
		int orderId=0;
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			parameterMap.put("hinNo", hinNo);
			System.out.println("hinNo  "+hinNo);
		}
		if (request.getParameter("orderId") != null && !request.getParameter("orderId").trim().equals("")) {
			orderId = Integer.parseInt(request.getParameter("orderId"));
			parameterMap.put("orderId", orderId);
		}
		
		
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		String registered = request.getParameter("registered");
		parameterMap.put(HOSPITAL_ID, hospitalId);

		map = billingHandlerService
				.getPatientDetailsForOpBilling(parameterMap);
		map.put("registered", registered);

		String jsp = "";
		if ((registered.equals("yes") && map.get("patientList") != null)
				|| registered.equals("no")) {
			if (!orderNo.equals("")) {
				if (map.get("orderHdList") != null) {
					jsp = BILL_SERVICING_JSP + ".jsp";
				} else {
					String msg = "No Record Found.";
					map.put("msg", msg);
					jsp = BILL_SERVICING_SEARCH_JSP + ".jsp";
				}
			} 
			/*else if (!tempBillNo.equals("")) {
				if (map.get("tempBillList") != null) {
					jsp = BILL_SERVICING_JSP + ".jsp";
				} else {
					String msg = "No Record Found.";
					map.put("msg", msg);
					jsp = BILL_SERVICING_SEARCH_JSP + ".jsp";
				}
			} */
			else {
				jsp = BILL_SERVICING_JSP + ".jsp";
			}
			map.put("orderNo", orderNo);
		} else {
			String msg = "No Record Found.";
			map.put("message", msg);
			jsp = BILL_SERVICING_SEARCH_JSP + ".jsp";
		}
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView getOtherPatientDetailsForBilling(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		HttpSession  session=request.getSession();
		String hinNo = "";
		String orderNo = "";
		String tempBillNo = "";
		int orderId=0;
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			parameterMap.put("hinNo", hinNo);
			System.out.println("hinNo  "+hinNo);
		}
		/*if (request.getParameter("orderId") != null && !request.getParameter("orderId").trim().equals("")) {
			orderId = Integer.parseInt(request.getParameter("orderId"));
			parameterMap.put("orderId", orderId);
		}*/
		
		
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		String registered = request.getParameter("registered");
		parameterMap.put(HOSPITAL_ID, hospitalId);

		map = billingHandlerService
				.getOtherPatientDetailsForBilling(parameterMap);
		map.put("registered", registered);

		String jsp = "";
		if ((registered.equals("yes") && map.get("patientList") != null)
				|| registered.equals("no")) {
			if (!orderNo.equals("")) {
				if (map.get("orderHdList") != null) {
					jsp = "billServicingOtherPatients.jsp";
				} else {
					String msg = "No Record Found.";
					map.put("msg", msg);
					jsp =  "PendingBillOtherPatientJsp.jsp";
				}
			} 
			/*else if (!tempBillNo.equals("")) {
				if (map.get("tempBillList") != null) {
					jsp = BILL_SERVICING_JSP + ".jsp";
				} else {
					String msg = "No Record Found.";
					map.put("msg", msg);
					jsp = BILL_SERVICING_SEARCH_JSP + ".jsp";
				}
			} */
			else {
				jsp = "billServicingOtherPatients.jsp";
			}
			map.put("orderNo", orderNo);
		} else {
			String msg = "No Record Found.";
			map.put("message", msg);
			jsp =  "PendingBillOtherPatientJsp.jsp";
		}
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	
	
	public ModelAndView fillChargeCode(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession(); 
		Map<String, Object> map = new HashMap<String, Object>();
		String rowVal = request.getParameter("rowVal");
		int hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
		int hinId = 0;
		int schemeId=0;
		String chargeDiscription = "";
		if (request.getParameter("hin") != null) {
			hinId = Integer.parseInt(request.getParameter("hin"));
		}
		if (request.getParameter("schemeList") != null) {
			schemeId = Integer.parseInt(request.getParameter("schemeList"));
		}
		if (request.getParameter("charge" + rowVal) != null) {
			chargeDiscription = request.getParameter("charge" + rowVal);
		}
		Integer index1 = 0;
		index1 = chargeDiscription.lastIndexOf("[") + 1;

		int index2 = chargeDiscription.lastIndexOf("]");
		String chargeCode = chargeDiscription.substring(index1, index2);
		map = billingHandlerService.getChargeCodeDetails(chargeCode, hinId,schemeId,hospitalId);

		String jsp = "";
		jsp = BILLING_RESPONSE_FOR_CHARGE_CODE_DETAIL_JSP;

		map.put("rowVal", rowVal);
		map.put("contentJsp", jsp);
		map.put("type", request.getParameter("type"));
		return new ModelAndView(jsp, "map", map);

	}

	
	@SuppressWarnings("unchecked")
	public  ModelAndView submitBillServicingDetailsOtherPatients(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("Executtinngg g gggg");
		String remarks = "";
		if (request.getParameter("remarks") != null) {
			remarks = request.getParameter("remarks");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int chargeListLength = 0;
		int payListLength = 0;
		String discount = "";
		String proportionalDiscount = "";
		String hinNo = "";
		int visitNo = 0;
		int deptId = 0;
		List chargeList = new ArrayList();
		List qtyList = new ArrayList();
		List rateList = new ArrayList();
		List standardDeductionList = new ArrayList();
		List amountList = new ArrayList();
		List discountList = new ArrayList();
		List disPercentList = new ArrayList();

		List mainChargeList = new ArrayList();
		List subChargeList = new ArrayList();
		List orderDetailIdList = new ArrayList();
		List accountIdList = new ArrayList();
		List subAccountIdList = new ArrayList();
		List deptCodeList = new ArrayList();
		List deptIdList = new ArrayList();

		List payModeList = new ArrayList();
		List amtReceivedList = new ArrayList();
		List chqNoList = new ArrayList();
		List chqDateList = new ArrayList();
		List bankNameList = new ArrayList();
		String orderNo = "";
		int orderId = 0;
		int visitIdNew = 0;
		String flag = "";
		String userName = (String) session.getAttribute("userName");
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		int hospitalId = 0;
		int departmentId = 0;
		Users user = new Users();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			dataMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute("users") != null) {
			user = (Users) session.getAttribute("users");
			dataMap.put("userId", user.getId());
		}
		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);

		BlOpBillHeader opBillHeader = new BlOpBillHeader();
		opBillHeader.setRemarks(remarks);
		opBillHeader.setHospital(hospital);
		Patient patient = new Patient();
		Visit visit = new Visit();

		if (request.getParameter(HIN_ID) != null) {
			patient.setId(Integer.parseInt(request.getParameter(HIN_ID)));
			opBillHeader.setHin(patient);
			dataMap.put("hinId", Integer.parseInt(request.getParameter(HIN_ID)));
			opBillHeader.setPatientStatus("r");
		} else {
			opBillHeader.setPatientStatus("u");
		}
		if (request.getParameter(HIN_NO) != null) {
			opBillHeader.setHinNo(request.getParameter(HIN_NO));
			hinNo = request.getParameter(HIN_NO);
		}
		if (request.getParameter("paymentMethod") != null) {
			 flag=request.getParameter("paymentMethod");
			dataMap.put("flag", flag);
			System.out.println("flag"+flag);
		}
		

		if (request.getParameter(VISIT_ID) != null) {
			visit.setId(Integer.parseInt(request.getParameter(VISIT_ID)));
			opBillHeader.setVisit(visit);
		}

		if (request.getParameter("visitIdNew") != null
				&& !request.getParameter("visitIdNew").equalsIgnoreCase("")
				&& !request.getParameter("visitIdNew").equalsIgnoreCase("0")) {
			visitIdNew = Integer.parseInt(request.getParameter("visitIdNew"));
		}

		if (request.getParameter("billTakenBy") != null
				&& !(request.getParameter("billTakenBy").equals("0"))
				&& !request.getParameter("billTakenBy").equalsIgnoreCase("")) {
			int empId = Integer.parseInt(request.getParameter("billTakenBy"));
			MasEmployee employee = new MasEmployee();
			employee.setId(empId);
			opBillHeader.setConsultant(employee);
		}

		if (request.getParameter("companyId") != null
				&& !(request.getParameter("companyId").equals("0"))
				&& !(request.getParameter("companyId").equals("0"))) {
			MasCompany company = new MasCompany();
			company.setId(Integer.parseInt(request.getParameter("companyId")));
			opBillHeader.setCompany(company);
		}

		if (request.getParameter(ORDER_NO) != null) {
			orderNo = request.getParameter(ORDER_NO);
			dataMap.put("orderNo", orderNo);
		}
		if (request.getParameter(ORDER_BOOKING_ID) != null) {
			orderId = Integer.parseInt(request.getParameter(ORDER_BOOKING_ID));
			dataMap.put("orderId", orderId);
		}

		if (request.getParameter(PATIENT_NAME) != null) {
			opBillHeader.setPatientName(request.getParameter(PATIENT_NAME));
		}
		if (request.getParameter(AGE) != null) {
			opBillHeader.setAge(request.getParameter(AGE));
		}
		if (request.getParameter(GENDER) != null
				&& !(request.getParameter(GENDER).equals(""))
				&& !(request.getParameter(GENDER).equals("0"))) {
			MasAdministrativeSex administrativeSex = new MasAdministrativeSex();
			administrativeSex.setId(Integer.parseInt(request
					.getParameter(GENDER)));
			opBillHeader.setSex(administrativeSex);
		}
		if (request.getParameter(CONSULTING_DOCTOR) != null
				&& !(request.getParameter(CONSULTING_DOCTOR).equals(""))
				&& !(request.getParameter(CONSULTING_DOCTOR).equals("0"))) {
			opBillHeader.setConsultantName(request
					.getParameter(CONSULTING_DOCTOR));
		}
		if (request.getParameter("amountReceived1") != null) {
			opBillHeader.setBillAmt(new BigDecimal(request
					.getParameter("amountReceived1")));
		} else {
			opBillHeader.setBillAmt(new BigDecimal(0));
		}

		if (request.getParameter(ROUND_OF_VALUE) != null
				&& !(request.getParameter(ROUND_OF_VALUE).equals(""))) {
			opBillHeader.setRoundOff(new BigDecimal(request
					.getParameter(ROUND_OF_VALUE)));
		}
		if (request.getParameter("amountReceived1") != null
				&& !(request.getParameter("amountReceived1").equals(""))) {
			opBillHeader.setNetAmt(new BigDecimal(request
					.getParameter("amountReceived1")));
		}

		if (request.getParameter("registrationType") != null) {
			String registrationType = request.getParameter("registrationType");
			dataMap.put("registrationType", registrationType);
		}
		if (request.getParameter("hiddenValueCharge") != null) {
			chargeListLength = Integer.parseInt(request
					.getParameter("hiddenValueCharge"));
		}
		if (request.getParameter("hiddenValuePayment") != null) {
			payListLength = Integer.parseInt(request
					.getParameter("hiddenValuePayment"));
		}
		for (int i = 1; i <= chargeListLength; i++) {
			if (request.getParameter(CHARGE_CODE_ID + i) != null
					&& !request.getParameter(CHARGE_CODE_ID + i).equals("")) {
				chargeList.add(request.getParameter(CHARGE_CODE_ID + i));
			} else {
				chargeList.add("");
			}
			if (request.getParameter(QUANTITY + i) != null
					&& !request.getParameter(QUANTITY + i).equals("")) {
				qtyList.add(request.getParameter(QUANTITY + i));
			} else {
				qtyList.add("");
			}
			if (request.getParameter(AMOUNT + i) != null
					&& !request.getParameter(AMOUNT + i).equals("")) {
				amountList.add(request.getParameter(AMOUNT + i));
			} else {
				amountList.add("");
			}
			if (request.getParameter(RATE + i) != null
					&& !request.getParameter(RATE + i).equals("")) {
				rateList.add(request.getParameter(RATE + i));
			} else {
				rateList.add("");
			}

			if (request.getParameter(MAIN_CHARGECODE_ID + i) != null) {
				mainChargeList
						.add(request.getParameter(MAIN_CHARGECODE_ID + i));
			} else {
				mainChargeList.add("");
			}
			if (request.getParameter(SUB_CHARGECODE_ID + i) != null) {
				subChargeList.add(request.getParameter(SUB_CHARGECODE_ID + i));
			} else {
				subChargeList.add("");
			}
			if (request.getParameter(DG_ORDER_DETAIL_ID + i) != null) {
				orderDetailIdList.add(request.getParameter(DG_ORDER_DETAIL_ID
						+ i));
			} else {
				orderDetailIdList.add("");
			}
			

			System.out.println("DEPARTMENT_TYPE_CODE--"
					+ request.getParameter(DEPARTMENT_TYPE_CODE + i));
			if (request.getParameter(DEPARTMENT_TYPE_CODE + i) != null
					&& !request.getParameter(DEPARTMENT_TYPE_CODE + i).equals(
							"")) {
				deptCodeList
						.add(request.getParameter(DEPARTMENT_TYPE_CODE + i));
			} else {
				deptCodeList.add("");
			}
			if (request.getParameter(DEPARTMENT_ID + i) != null
					&& !request.getParameter(DEPARTMENT_ID + i).equals("0")) {
				deptIdList.add(request.getParameter(DEPARTMENT_ID + i));
			} else {
				deptIdList.add("");
			}
		}

	
			if (request.getParameter("avAdvAmtId") != null
					&& !(request.getParameter("avAdvAmtId").equals(""))) {
				opBillHeader.setAdvanceAdjustment(new BigDecimal(request
						.getParameter("avAdvAmtId")));
				dataMap.put("avAdvAmtId", request.getParameter("avAdvAmtId"));
			}
			opBillHeader.setPayStatus("P");
			if (request.getParameter("remainCId") != null
					&& !(request.getParameter("remainCId").equals(""))) {
				opBillHeader.setAdvanceAdjustment(new BigDecimal(request
						.getParameter("remainCId")));
				dataMap.put("remainCId", request.getParameter("remainCId"));
			}

			if (request.getParameter("balToBePiadId") != null
					&& !(request.getParameter("balToBePiadId").equals(""))) {
				opBillHeader.setPayableAmt(new BigDecimal(request
						.getParameter("balToBePiadId")));
				dataMap.put("payAmt", request.getParameter("balToBePiadId"));
			}

			if (request.getParameter("actualColAmtId") != null
					&& !(request.getParameter("actualColAmtId").equals(""))
					&& request.getParameter("balToBeRId") != null
					&& !(request.getParameter("balToBeRId").equals(""))) {
				if (request.getParameter("balToBeRId") != null
						&& request.getParameter("balToBeRId").equals("")) {
					opBillHeader.setActualCollectedAmt(new BigDecimal(request
							.getParameter("actualColAmtId")));
				} else {
					opBillHeader.setActualCollectedAmt(new BigDecimal(request
							.getParameter("actualColAmtId"))
							.subtract(new BigDecimal(request
									.getParameter("balToBeRId"))));
				}
			}

			if (request.getParameter("adjusetCreditId") != null
					&& !(request.getParameter("adjusetCreditId").equals(""))) {
				opBillHeader.setAdvanceAdjustment(new BigDecimal(request
						.getParameter("adjusetCreditId")));
			}

			if (request.getParameter("charityTransferId") != null
					&& !(request.getParameter("charityTransferId").equals(""))) {
				opBillHeader.setCharityRcvd(new BigDecimal(request
						.getParameter("charityTransferId")));
			}

			opBillHeader.setBillDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter(CHANGED_DATE)));
			opBillHeader.setBillTime(request.getParameter(CHANGED_TIME));
			int userId = user.getId();
			Users userObj = new Users();
			userObj.setId(userId);

			opBillHeader.setChangedBy(userObj);
			opBillHeader.setStatus("y");

			dataMap.put("opBillHeader", opBillHeader);
			int userId1 = user.getId();
			Users userObj1 = new Users();
			userObj.setId(userId1);

			if (request.getParameter("registrationType") != null) {
				String registrationType = request
						.getParameter("registrationType");
				dataMap.put("registrationType", registrationType);
			}

			if (request.getParameter("hiddenValueCharge") != null) {
				chargeListLength = Integer.parseInt(request
						.getParameter("hiddenValueCharge"));
			}
			if (request.getParameter("hiddenValuePayment") != null) {
				payListLength = Integer.parseInt(request
						.getParameter("hiddenValuePayment"));
			}

			for (int j = 1; j <= payListLength; j++) {
				if (request.getParameter(PAYMENT_MODE + j) != null
						&& !request.getParameter(PAYMENT_MODE + j).equals("")) {
					payModeList.add(request.getParameter(PAYMENT_MODE + j));
				} else {
					payModeList.add("");
				}
				if (request.getParameter(AMOUNT_RECEIVED + j) != null
						&& !request.getParameter(AMOUNT_RECEIVED + j)
								.equals("")) {
					amtReceivedList.add(request.getParameter(AMOUNT_RECEIVED
							+ j));
				} else {
					amtReceivedList.add("");
				}
				if (request.getParameter(CHEQUE_NO + j) != null
						&& !request.getParameter(CHEQUE_NO + j).equals("")) {
					chqNoList.add(request.getParameter(CHEQUE_NO + j));
				} else {
					chqNoList.add("");
				}
				if (request.getParameter(CHEQUE_DATE + j) != null
						&& !request.getParameter(CHEQUE_DATE + j).equals("")) {
					chqDateList.add(request.getParameter(CHEQUE_DATE + j));
				} else {
					chqDateList.add("");
				}
				if (request.getParameter(BANK_NAME + j) != null
						&& !request.getParameter(BANK_NAME + j).equals("")) {
					bankNameList.add(request.getParameter(BANK_NAME + j));
				} else {
					bankNameList.add("");
				}
			}
		
System.out.println("dfhsjdfhjdfh");
			
				BlReceiptHeader receiptHeader = new BlReceiptHeader();
				if (request.getParameter(HIN_ID) != null) {
					patient.setId(Integer.parseInt(request.getParameter(HIN_ID)));
					receiptHeader.setHin(patient);
				}
				/*if (request.getParameter(PAYABLE_AMOUNT) != null
						&& !(request.getParameter(PAYABLE_AMOUNT).equals(""))) {
					receiptHeader.setAmount(new BigDecimal(request
							.getParameter(PAYABLE_AMOUNT)));
				}*/

				if (request.getParameter(ROUND_OF_VALUE) != null
						&& !(request.getParameter(ROUND_OF_VALUE).equals(""))) {
					receiptHeader.setRoundOff(new BigDecimal(request
							.getParameter(ROUND_OF_VALUE)));
				}
				receiptHeader.setReceiptType("opb");
				receiptHeader.setReceiptDate(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(CHANGED_DATE)));
				receiptHeader
						.setReceiptTime(request.getParameter(CHANGED_TIME));
				receiptHeader.setHospital(hospital);
			

				receiptHeader.setChangedBy(userObj);
				dataMap.put("receiptHeader", receiptHeader);

		
		opBillHeader.setBillDate(HMSUtil
				.convertStringTypeDateToDateType(request
						.getParameter(CHANGED_DATE)));
		opBillHeader.setBillTime(request.getParameter(CHANGED_TIME));
		int userIds = user.getId();
		Users userObjs = new Users();
		userObjs.setId(userIds);

		opBillHeader.setChangedBy(userObj);
		opBillHeader.setStatus("y");

		dataMap.put("opBillHeader", opBillHeader);

		dataMap.put("userName", userName);
		dataMap.put("chargeList", chargeList);
		dataMap.put("mainChargeList", mainChargeList);
		dataMap.put("subChargeList", subChargeList);
		dataMap.put("discountList", discountList);

		dataMap.put("qtyList", qtyList);
		dataMap.put("rateList", rateList);
		dataMap.put("standardDeductionList", standardDeductionList);
		dataMap.put("amountList", amountList);

		dataMap.put("payModeList", payModeList);
		dataMap.put("amtReceivedList", amtReceivedList);
		dataMap.put("chqNoList", chqNoList);
		dataMap.put("chqDateList", chqDateList);
		dataMap.put("bankNameList", bankNameList);
		dataMap.put("orderDetailIdList", orderDetailIdList);
		dataMap.put("accountIdList", accountIdList);
		dataMap.put("subAccountIdList", subAccountIdList);
		dataMap.put("deptCodeList", deptCodeList);
		dataMap.put("deptIdList", deptIdList);
		dataMap.put("visitIdNew", visitIdNew);
		dataMap.put("deptIdNew11", 81);
	
		boolean saved = false;
		String message = "";
		map = billingHandlerService.submitBillServicingDetailsOtherPatients(dataMap);

		String printUrl = "";
		String url = "";
		String billNo = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (map.get("billNo") != null) {
			billNo = (String) map.get("billNo");
		}
		if (saved) {
			message = "Billing has been done successfully!! Bill No is "
					+ billNo ;
			printUrl = "submitForm('messageBilling','/hms/hms/billing?method=printBillPrintingServicingReport&billNo="
					+ billNo + "')";
			url = "submitForm('messageBilling','/hms/hms/billing?method=showBillServicingJsp')";
			map.put("printUrl", printUrl);
			map.put("url", url);

		} else {
			message = "Try Again!";
		}
		map.put("message", message);


		jsp ="messageForBillingOtherPatients.jsp";
		map.put("contentJsp", jsp);
		map.put("billtype", "servicing");
		map.put("billNo", billNo);

		map.put("hinNo", hinNo);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public  ModelAndView submitBillServicingDetails(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("Executtinngg g gggg");
		String remarks = "";
		if (request.getParameter("remarks") != null) {
			remarks = request.getParameter("remarks");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int chargeListLength = 0;
		int payListLength = 0;
		String discount = "";
		String proportionalDiscount = "";
		String hinNo = "";
		int visitNo = 0;
		int deptId = 0;
		List <String>chargeList = new ArrayList();
		List qtyList = new ArrayList();
		List rateList = new ArrayList();
		List standardDeductionList = new ArrayList();
		List amountList = new ArrayList();
		List discountList = new ArrayList();
		List disPercentList = new ArrayList();

		List mainChargeList = new ArrayList();
		List subChargeList = new ArrayList();
		List orderDetailIdList = new ArrayList();
		List accountIdList = new ArrayList();
		List subAccountIdList = new ArrayList();
		List deptCodeList = new ArrayList();
		List deptIdList = new ArrayList();

		List payModeList = new ArrayList();
		List amtReceivedList = new ArrayList();
		List chqNoList = new ArrayList();
		List chqDateList = new ArrayList();
		List bankNameList = new ArrayList();
		String orderNo = "";
		int orderId = 0;
		int visitIdNew = 0;
		String flag = "";
		String userName = (String) session.getAttribute("userName");
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		int hospitalId = 0;
		int departmentId = 0;
		Users user = new Users();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			dataMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute("users") != null) {
			user = (Users) session.getAttribute("users");
			dataMap.put("userId", user.getId());
		}
		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);

		BlOpBillHeader opBillHeader = new BlOpBillHeader();
		opBillHeader.setRemarks(remarks);
		opBillHeader.setHospital(hospital);
		Patient patient = new Patient();
		Visit visit = new Visit();

		if (request.getParameter(HIN_ID) != null) {
			patient.setId(Integer.parseInt(request.getParameter(HIN_ID)));
			opBillHeader.setHin(patient);
			dataMap.put("hinId", Integer.parseInt(request.getParameter(HIN_ID)));
			opBillHeader.setPatientStatus("r");
		} else {
			opBillHeader.setPatientStatus("u");
		}
		if (request.getParameter(HIN_NO) != null) {
			opBillHeader.setHinNo(request.getParameter(HIN_NO));
			hinNo = request.getParameter(HIN_NO);
		}
		if (request.getParameter("paymentMethod") != null) {
			 flag=request.getParameter("paymentMethod");
			dataMap.put("flag", flag);
			System.out.println("flag"+flag);
		}
		

		if (request.getParameter(VISIT_ID) != null) {
			visit.setId(Integer.parseInt(request.getParameter(VISIT_ID)));
			opBillHeader.setVisit(visit);
		}

		if (request.getParameter("visitIdNew") != null
				&& !request.getParameter("visitIdNew").equalsIgnoreCase("")
				&& !request.getParameter("visitIdNew").equalsIgnoreCase("0")) {
			visitIdNew = Integer.parseInt(request.getParameter("visitIdNew"));
		}

		if (request.getParameter(EMPLOYEE_ID) != null
				&& !(request.getParameter(EMPLOYEE_ID).equals("0"))
				&& !request.getParameter(EMPLOYEE_ID).equalsIgnoreCase("")) {
			int empId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			MasEmployee employee = new MasEmployee();
			employee.setId(empId);
			opBillHeader.setConsultant(employee);
		}

		if (request.getParameter("companyId") != null
				&& !(request.getParameter("companyId").equals("0"))
				&& !(request.getParameter("companyId").equals("0"))) {
			MasCompany company = new MasCompany();
			company.setId(Integer.parseInt(request.getParameter("companyId")));
			opBillHeader.setCompany(company);
		}

		if (request.getParameter(ORDER_NO) != null) {
			orderNo = request.getParameter(ORDER_NO);
			dataMap.put("orderNo", orderNo);
		}
		if (request.getParameter(ORDER_BOOKING_ID) != null) {
			orderId = Integer.parseInt(request.getParameter(ORDER_BOOKING_ID));
			dataMap.put("orderId", orderId);
		}

		if (request.getParameter(PATIENT_NAME) != null) {
			opBillHeader.setPatientName(request.getParameter(PATIENT_NAME));
		}
		if (request.getParameter(AGE) != null) {
			opBillHeader.setAge(request.getParameter(AGE));
		}
		if (request.getParameter(GENDER) != null
				&& !(request.getParameter(GENDER).equals(""))
				&& !(request.getParameter(GENDER).equals("0"))) {
			MasAdministrativeSex administrativeSex = new MasAdministrativeSex();
			administrativeSex.setId(Integer.parseInt(request
					.getParameter(GENDER)));
			opBillHeader.setSex(administrativeSex);
		}
		if (request.getParameter(CONSULTING_DOCTOR) != null
				&& !(request.getParameter(CONSULTING_DOCTOR).equals(""))
				&& !(request.getParameter(CONSULTING_DOCTOR).equals("0"))) {
			opBillHeader.setConsultantName(request
					.getParameter(CONSULTING_DOCTOR));
		}
		if (request.getParameter(BILL_AMOUNT) != null) {
			opBillHeader.setBillAmt(new BigDecimal(request
					.getParameter(BILL_AMOUNT)));
		} else {
			opBillHeader.setBillAmt(new BigDecimal(0));
		}

		if (request.getParameter(ROUND_OF_VALUE) != null
				&& !(request.getParameter(ROUND_OF_VALUE).equals(""))) {
			opBillHeader.setRoundOff(new BigDecimal(request
					.getParameter(ROUND_OF_VALUE)));
		}
		if (request.getParameter(TOTAL_AMOUNT) != null
				&& !(request.getParameter(TOTAL_AMOUNT).equals(""))) {
			opBillHeader.setNetAmt(new BigDecimal(request
					.getParameter(TOTAL_AMOUNT)));
		}

		if (request.getParameter("registrationType") != null) {
			String registrationType = request.getParameter("registrationType");
			dataMap.put("registrationType", registrationType);
		}
		if (request.getParameter("hiddenValueCharge") != null) {
			chargeListLength = Integer.parseInt(request
					.getParameter("hiddenValueCharge"));
		}
		if (request.getParameter("hiddenValuePayment") != null) {
			payListLength = Integer.parseInt(request
					.getParameter("hiddenValuePayment"));
		}
		
		
			
		for (int i = 1; i <= chargeListLength; i++) {
			
			if(request.getParameter("selectedCharge" + i) != null){

				if (request.getParameter(CHARGE_CODE_ID + i) != null
						&& !request.getParameter(CHARGE_CODE_ID + i).equals("")) {
					chargeList.add(request.getParameter(CHARGE_CODE_ID + i));

				} else {
					chargeList.add("");
				}
				if (request.getParameter(QUANTITY + i) != null
						&& !request.getParameter(QUANTITY + i).equals("")) {
					qtyList.add(request.getParameter(QUANTITY + i));
				} else {
					qtyList.add("");
				}
				if (request.getParameter(AMOUNT + i) != null
						&& !request.getParameter(AMOUNT + i).equals("")) {
					amountList.add(request.getParameter(AMOUNT + i));
				} else {
					amountList.add("");
				}
				if (request.getParameter(RATE + i) != null
						&& !request.getParameter(RATE + i).equals("")) {
					rateList.add(request.getParameter(RATE + i));
				} else {
					rateList.add("");
				}

				if (request.getParameter(MAIN_CHARGECODE_ID + i) != null) {
					mainChargeList
					.add(request.getParameter(MAIN_CHARGECODE_ID + i));
				} else {
					mainChargeList.add("");
				}
				if (request.getParameter(SUB_CHARGECODE_ID + i) != null) {
					subChargeList.add(request.getParameter(SUB_CHARGECODE_ID + i));
				} else {
					subChargeList.add("");
				}
				if (request.getParameter(DG_ORDER_DETAIL_ID + i) != null) {
					orderDetailIdList.add(request.getParameter(DG_ORDER_DETAIL_ID
							+ i));
				} else {
					orderDetailIdList.add("");
				}


				System.out.println("DEPARTMENT_TYPE_CODE--"
						+ request.getParameter(DEPARTMENT_TYPE_CODE + i));
				if (request.getParameter(DEPARTMENT_TYPE_CODE + i) != null
						&& !request.getParameter(DEPARTMENT_TYPE_CODE + i).equals(
								"")) {
					deptCodeList
					.add(request.getParameter(DEPARTMENT_TYPE_CODE + i));
				} else {
					deptCodeList.add("");
				}
				if (request.getParameter(DEPARTMENT_ID + i) != null
						&& !request.getParameter(DEPARTMENT_ID + i).equals("0")) {
					deptIdList.add(request.getParameter(DEPARTMENT_ID + i));
				} else {
					deptIdList.add("");
				}
			}
		}

			if (request.getParameter("avAdvAmtId") != null
					&& !(request.getParameter("avAdvAmtId").equals(""))) {
				opBillHeader.setAdvanceAdjustment(new BigDecimal(request
						.getParameter("avAdvAmtId")));
				dataMap.put("avAdvAmtId", request.getParameter("avAdvAmtId"));
			}
			opBillHeader.setPayStatus("P");
			if (request.getParameter("remainCId") != null
					&& !(request.getParameter("remainCId").equals(""))) {
				opBillHeader.setAdvanceAdjustment(new BigDecimal(request
						.getParameter("remainCId")));
				dataMap.put("remainCId", request.getParameter("remainCId"));
			}

			if (request.getParameter("balToBePiadId") != null
					&& !(request.getParameter("balToBePiadId").equals(""))) {
				opBillHeader.setPayableAmt(new BigDecimal(request
						.getParameter("balToBePiadId")));
				dataMap.put("payAmt", request.getParameter("balToBePiadId"));
			}

			if (request.getParameter("actualColAmtId") != null
					&& !(request.getParameter("actualColAmtId").equals(""))
					&& request.getParameter("balToBeRId") != null
					&& !(request.getParameter("balToBeRId").equals(""))) {
				if (request.getParameter("balToBeRId") != null
						&& request.getParameter("balToBeRId").equals("")) {
					opBillHeader.setActualCollectedAmt(new BigDecimal(request
							.getParameter("actualColAmtId")));
				} else {
					opBillHeader.setActualCollectedAmt(new BigDecimal(request
							.getParameter("actualColAmtId"))
							.subtract(new BigDecimal(request
									.getParameter("balToBeRId"))));
				}
			}

			if (request.getParameter("adjusetCreditId") != null
					&& !(request.getParameter("adjusetCreditId").equals(""))) {
				opBillHeader.setAdvanceAdjustment(new BigDecimal(request
						.getParameter("adjusetCreditId")));
			}

			if (request.getParameter("charityTransferId") != null
					&& !(request.getParameter("charityTransferId").equals(""))) {
				opBillHeader.setCharityRcvd(new BigDecimal(request
						.getParameter("charityTransferId")));
			}

			opBillHeader.setBillDate(HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter(CHANGED_DATE)));
			opBillHeader.setBillTime(request.getParameter(CHANGED_TIME));
			int userId = user.getId();
			Users userObj = new Users();
			userObj.setId(userId);

			opBillHeader.setChangedBy(userObj);
			opBillHeader.setStatus("y");

			dataMap.put("opBillHeader", opBillHeader);
			int userId1 = user.getId();
			Users userObj1 = new Users();
			userObj.setId(userId1);

			if (request.getParameter("registrationType") != null) {
				String registrationType = request
						.getParameter("registrationType");
				dataMap.put("registrationType", registrationType);
			}

			if (request.getParameter("hiddenValueCharge") != null) {
				chargeListLength = Integer.parseInt(request
						.getParameter("hiddenValueCharge"));
			}
			if (request.getParameter("hiddenValuePayment") != null) {
				payListLength = Integer.parseInt(request
						.getParameter("hiddenValuePayment"));
			}

			for (int j = 1; j <= payListLength; j++) {
				if (request.getParameter(PAYMENT_MODE + j) != null
						&& !request.getParameter(PAYMENT_MODE + j).equals("")) {
					payModeList.add(request.getParameter(PAYMENT_MODE + j));
				} else {
					payModeList.add("");
				}
				if (request.getParameter(AMOUNT_RECEIVED + j) != null
						&& !request.getParameter(AMOUNT_RECEIVED + j)
								.equals("")) {
					amtReceivedList.add(request.getParameter(AMOUNT_RECEIVED
							+ j));
				} else {
					amtReceivedList.add("");
				}
				if (request.getParameter(CHEQUE_NO + j) != null
						&& !request.getParameter(CHEQUE_NO + j).equals("")) {
					chqNoList.add(request.getParameter(CHEQUE_NO + j));
				} else {
					chqNoList.add("");
				}
				if (request.getParameter(CHEQUE_DATE + j) != null
						&& !request.getParameter(CHEQUE_DATE + j).equals("")) {
					chqDateList.add(request.getParameter(CHEQUE_DATE + j));
				} else {
					chqDateList.add("");
				}
				if (request.getParameter(BANK_NAME + j) != null
						&& !request.getParameter(BANK_NAME + j).equals("")) {
					bankNameList.add(request.getParameter(BANK_NAME + j));
				} else {
					bankNameList.add("");
				}
			}
		

			
				BlReceiptHeader receiptHeader = new BlReceiptHeader();
				if (request.getParameter(HIN_ID) != null) {
					patient.setId(Integer.parseInt(request.getParameter(HIN_ID)));
					receiptHeader.setHin(patient);
				}
				/*if (request.getParameter(PAYABLE_AMOUNT) != null
						&& !(request.getParameter(PAYABLE_AMOUNT).equals(""))) {
					receiptHeader.setAmount(new BigDecimal(request
							.getParameter(PAYABLE_AMOUNT)));
				}*/

				if (request.getParameter(ROUND_OF_VALUE) != null
						&& !(request.getParameter(ROUND_OF_VALUE).equals(""))) {
					receiptHeader.setRoundOff(new BigDecimal(request
							.getParameter(ROUND_OF_VALUE)));
				}
				receiptHeader.setReceiptType("opb");
				receiptHeader.setReceiptDate(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(CHANGED_DATE)));
				receiptHeader
						.setReceiptTime(request.getParameter(CHANGED_TIME));
				receiptHeader.setHospital(hospital);
			

				receiptHeader.setChangedBy(userObj);
				dataMap.put("receiptHeader", receiptHeader);

		
		opBillHeader.setBillDate(HMSUtil
				.convertStringTypeDateToDateType(request
						.getParameter(CHANGED_DATE)));
		opBillHeader.setBillTime(request.getParameter(CHANGED_TIME));
		int userIds = user.getId();
		Users userObjs = new Users();
		userObjs.setId(userIds);

		opBillHeader.setChangedBy(userObj);
		opBillHeader.setStatus("y");

		dataMap.put("opBillHeader", opBillHeader);

		dataMap.put("userName", userName);
		dataMap.put("chargeList", chargeList);
		dataMap.put("mainChargeList", mainChargeList);
		dataMap.put("subChargeList", subChargeList);
		dataMap.put("discountList", discountList);

		dataMap.put("qtyList", qtyList);
		dataMap.put("rateList", rateList);
		dataMap.put("standardDeductionList", standardDeductionList);
		dataMap.put("amountList", amountList);

		dataMap.put("payModeList", payModeList);
		dataMap.put("amtReceivedList", amtReceivedList);
		dataMap.put("chqNoList", chqNoList);
		dataMap.put("chqDateList", chqDateList);
		dataMap.put("bankNameList", bankNameList);
		dataMap.put("orderDetailIdList", orderDetailIdList);
		dataMap.put("accountIdList", accountIdList);
		dataMap.put("subAccountIdList", subAccountIdList);
		dataMap.put("deptCodeList", deptCodeList);
		dataMap.put("deptIdList", deptIdList);
		dataMap.put("visitIdNew", visitIdNew);
		dataMap.put("deptIdNew11", 81);
	
		boolean saved = false;
		String message = "";
		map = billingHandlerService.submitBillServicingDetails(dataMap);

		String printUrl = "";
		String url = "";
		String billNo = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (map.get("billNo") != null) {
			billNo = (String) map.get("billNo");
		}
		if (saved) {
			message = "Billing has been done successfully!! Bill No is "
					+ billNo + ". Do you want to print?";
			printUrl = "submitForm('messageBilling','/hms/hms/billing?method=printBillPrintingServicingReport&billNo="
					+ billNo + "')";
			url = "submitForm('messageBilling','/hms/hms/billing?method=showBillServicingJsp')";
			map.put("printUrl", printUrl);
			map.put("url", url);

		} else {
			message = "Try Again!";
		}
		map.put("message", message);


		jsp = MESSAGE_FOR_BILLING_JSP + ".jsp";
		map.put("contentJsp", jsp);
		map.put("billtype", "servicing");
		map.put("billNo", billNo);

		map.put("hinNo", hinNo);
		return new ModelAndView("index", "map", map);
	}

}
