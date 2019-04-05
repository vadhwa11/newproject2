package jkt.hms.hr.controller;

import static jkt.hms.util.RequestConstants.CALCULATION_SHEET_JSP;
import static jkt.hms.util.RequestConstants.DATA_SHEET;
import static jkt.hms.util.RequestConstants.DATA_SHEET_JSP;
import static jkt.hms.util.RequestConstants.DESCRIPTIVE_ROLL;
import static jkt.hms.util.RequestConstants.FAMILY_DETAILS;
import static jkt.hms.util.RequestConstants.FORM7_ENTRY_JSP;
import static jkt.hms.util.RequestConstants.FORM8_ENTRY_JSP;
import static jkt.hms.util.RequestConstants.FORM_356;
import static jkt.hms.util.RequestConstants.FORM_7;
import static jkt.hms.util.RequestConstants.FORM_8;
import static jkt.hms.util.RequestConstants.FORM_FIVE;
import static jkt.hms.util.RequestConstants.PERSONNEL_ENTRY_DETAILS_JSP;
import static jkt.hms.util.RequestConstants.PERSONNEL_SEARCH_FOR_CALCULATION_SHEET_JSP;
import static jkt.hms.util.RequestConstants.PERSONNEL_SEARCH_FOR_DATA_SHEET_JSP;
import static jkt.hms.util.RequestConstants.PERSONNEL_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.PERSONNEL_SEARCH__FOR_FORM7_JSP;
import static jkt.hms.util.RequestConstants.PERSONNEL_SEARCH__FOR_FORM8_JSP;
import static jkt.hms.util.RequestConstants.PERSONNEL_SEARCH__FOR_RETIREMENT_ENTRY_JSP;
import static jkt.hms.util.RequestConstants.RETIREMENT_ENTRY_JSP;
import static jkt.hms.util.RequestConstants.UPDATE_CALCULATION_SHEET_JSP;
import static jkt.hms.util.RequestConstants.UPDATE_DATA_SHEET_JSP;
import static jkt.hms.util.RequestConstants.UPDATE_FORM7_ENTRY_JSP;
import static jkt.hms.util.RequestConstants.UPDATE_FORM8_JSP;
import static jkt.hms.util.RequestConstants.UPDATE_PERSONNEL_SEARCH_FOR_CALCULATION_SHEET_JSP;
import static jkt.hms.util.RequestConstants.UPDATE_PERSONNEL_SEARCH_FOR_DATA_SHEET_JSP;
import static jkt.hms.util.RequestConstants.UPDATE_PERSONNEL_SEARCH_FOR_FORM7_JSP;
import static jkt.hms.util.RequestConstants.UPDATE_PERSONNEL_SEARCH_FOR_FORM8_JSP;
import static jkt.hms.util.RequestConstants.UPDATE_PERSONNEL_SEARCH_FOR_RETIREMENT_FORM_JSP;
import static jkt.hms.util.RequestConstants.UPDATE_PERSONNEL_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.UPDATE_RETIREMENT_ENTRY_FORM_JSP;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.hr.handler.PensionRelatedHandlerService;
import jkt.hms.masters.business.MasDesignation;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasPersonnelDetails;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class PensionRelatedController extends MultiActionController {
	PensionRelatedHandlerService pensionRelatedHandlerService = null;

	public PensionRelatedHandlerService getPensionRelatedHandlerService() {
		return pensionRelatedHandlerService;
	}

	public void setPensionRelatedHandlerService(
			PensionRelatedHandlerService pensionRelatedHandlerService) {
		this.pensionRelatedHandlerService = pensionRelatedHandlerService;
	}

	String jsp = "";
	String title = "";
	String message = " ";
	Map<String, Object> generalMap = new HashMap<String, Object>();
	HttpSession session = null;

	public ModelAndView showPersonnelEntryDetailsJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = pensionRelatedHandlerService.showPersonnelEntryDetailsJsp();
		jsp = PERSONNEL_ENTRY_DETAILS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}
	public void getRetAge() {
		//System.out.println("this is Ok");
		

	}

	public ModelAndView submitPersonnelEntryDetailsJsp(
		HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		Box box = HMSUtil.getBox(request);
		List<String> familyNameList = new ArrayList<String>();
		List<Integer> relationIdList = new ArrayList<Integer>();
		List<String> dateOfBirthList = new ArrayList<String>();
		List<String> isNomineeList = new ArrayList<String>();
		List<String> nomineePercentList = new ArrayList<String>();
		List<Integer> heightsList = new ArrayList<Integer>();
		List<String> identificationMarkList = new ArrayList<String>();

		int hdb = 1;
		if (Integer.parseInt(request.getParameter("hdb")) != 1) {
			hdb = Integer.parseInt(request.getParameter("hdb"));
		}
		//System.out.println("value of hdb=-======" + hdb);
		for (int i = 1; i <= hdb; i++) {
			String nomineePercent = "";
			int height = 0;
			String identificationMark = "";
			if (!request.getParameter("familyName" + i).equals("")) {
				String familyName = request.getParameter("familyName" + i);
				int relationId = Integer.parseInt(request
						.getParameter("relation" + i));
				String dateOfBirth = request.getParameter("dateOfBirth" + i);
				String isNominee = request.getParameter("isNominee" + i);
				if (request.getParameter("nomineePercent" + i) != null
						&& !request.getParameter("nomineePercent" + i).equals(
								""))
					nomineePercent = request.getParameter("nomineePercent" + i);
				if (request.getParameter("height" + i) != null
						&& !request.getParameter("height" + i).equals(""))
					height = Integer.parseInt(request
							.getParameter("height" + i));
				if (request.getParameter("identificationMark" + i) != null
						&& !request.getParameter("identificationMark" + i)
								.equals(""))
					identificationMark = request
							.getParameter("identificationMark" + i);

				//System.out.println("family name==" + familyName+ "==date of birh===" + dateOfBirth + "==isnominee==="	+ isNominee);
				//System.out.println("nomineePercent==" + nomineePercent+ "==height===" + height + "==identificationMark==="+ identificationMark);

				familyNameList.add(familyName);
				relationIdList.add(relationId);
				dateOfBirthList.add(dateOfBirth);
				isNomineeList.add(isNominee);
				nomineePercentList.add(nomineePercent);
				heightsList.add(height);
				identificationMarkList.add(identificationMark);

			}
		}
		dataMap.put("familyNameList", familyNameList);
		dataMap.put("relationIdList", relationIdList);
		dataMap.put("dateOfBirthList", dateOfBirthList);
		dataMap.put("isNomineeList", isNomineeList);
		dataMap.put("nomineePercentList", nomineePercentList);
		dataMap.put("heightsList", heightsList);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("identificationMarkList", identificationMarkList);

		dataMap = pensionRelatedHandlerService.submitPersonnelEntryDetailsJsp(box, dataMap);
		boolean successfullyAdded = (Boolean)dataMap.get("successfullyAdded");
		boolean alreadyAdded = (Boolean)dataMap.get("alreadyAdded");
		if (alreadyAdded) {
			message = "Data Already Exist";
		} else if(successfullyAdded)  {
			message= "Personnel Deatils Submitted Successfully!!";
			
		}else{
			message = "Error Occurred in submitting personnel Details!!!";
		}
		map = pensionRelatedHandlerService.showPersonnelEntryDetailsJsp();
		jsp = PERSONNEL_ENTRY_DETAILS_JSP;
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
		// return null;

	}
	

	public ModelAndView showPersonnelSearchJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = pensionRelatedHandlerService.getDataForPersonnelSearchJsp();
		jsp = PERSONNEL_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView personnelSearchJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String personnelName = "";
		int passNo = 0;
		int unitId = 0;
		int designationId = 0;
		if (request.getParameter("personnelName") != null
				&& !request.getParameter("personnelName").equals(""))
			personnelName = request.getParameter("personnelName");
		if (request.getParameter("passNo") != null
				&& !request.getParameter("passNo").equals(""))
			passNo = Integer.parseInt(request.getParameter("passNo"));

		if (request.getParameter("unitId") != null
				&& !request.getParameter("unitId").equals(""))
			unitId = Integer.parseInt(request.getParameter("unitId"));
		if (request.getParameter("designationId") != null
				&& !request.getParameter("designationId").equals(""))
			designationId = Integer.parseInt(request
					.getParameter("designationId"));

		dataMap.put("personnelName", personnelName);
		dataMap.put("unitId", unitId);
		dataMap.put("designationId", designationId);
		dataMap.put("passNo", passNo);

		if (request.getParameter("jspName") != null
				&& request.getParameter("jspName").equals("form7")) {
			dataMap.put("jspName", request.getParameter("jspName"));
			jsp = PERSONNEL_SEARCH__FOR_FORM7_JSP;
		}
		if (request.getParameter("jspName") != null
				&& request.getParameter("jspName").equals("form8")) {
			dataMap.put("jspName", request.getParameter("jspName"));
			jsp = PERSONNEL_SEARCH__FOR_FORM8_JSP;
		}
		if (request.getParameter("jspName") != null
				&& request.getParameter("jspName").equals("updateForm8")) {
			dataMap.put("jspName", request.getParameter("jspName"));
			jsp = UPDATE_PERSONNEL_SEARCH_FOR_FORM8_JSP;
		}
		if (request.getParameter("jspName") != null
				&& request.getParameter("jspName").equals(
						"updatePersonnelDetails")) {
			dataMap.put("jspName", request.getParameter("jspName"));
			jsp = PERSONNEL_SEARCH_JSP;
		}
		if (request.getParameter("jspName") != null
				&& request.getParameter("jspName").equals("retirementEntry")) {
			dataMap.put("jspName", request.getParameter("jspName"));
			jsp = PERSONNEL_SEARCH__FOR_RETIREMENT_ENTRY_JSP;
		}
		if (request.getParameter("jspName") != null
				&& request.getParameter("jspName").equals(
						"updateRetirementForm")) {
			dataMap.put("jspName", request.getParameter("jspName"));
			jsp = UPDATE_PERSONNEL_SEARCH_FOR_RETIREMENT_FORM_JSP;
		}

		map = pensionRelatedHandlerService
				.showPersonnelSearchForUpdatePersonnelAndForm7Jsp(dataMap);
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showUpdatePersonnelSearchJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int personnelId = Integer.parseInt(request.getParameter("personnelId"));
		dataMap.put("personnelId", personnelId);
		map = pensionRelatedHandlerService
				.showUpdatePersonnelSearchJsp(dataMap);
		jsp = UPDATE_PERSONNEL_SEARCH_JSP;
		jsp += ".jsp";
		map.put("personnelId", personnelId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView updatePersonnelEntryDetailsJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		List<String> familyNameList = new ArrayList<String>();
		List<Integer> relationIdList = new ArrayList<Integer>();
		List<String> dateOfBirthList = new ArrayList<String>();
		List<String> isNomineeList = new ArrayList<String>();
		List<String> nomineePercentList = new ArrayList<String>();
		List<Integer> heightsList = new ArrayList<Integer>();
		List<String> identificationMarkList = new ArrayList<String>();
		int personnelId = Integer.parseInt(request.getParameter("personnelId"));
		int hdb = 1;
		if (Integer.parseInt(request.getParameter("hdb")) != 1) {
			hdb = Integer.parseInt(request.getParameter("hdb"));
		}
		//System.out.println("value of hdb=-======" + hdb);
		for (int i = 1; i <= hdb; i++) {
			String nomineePercent = "";
			int height = 0;
			String identificationMark = "";
			if (!request.getParameter("familyName" + i).equals("")) {
				String familyName = request.getParameter("familyName" + i);
				int relationId = Integer.parseInt(request
						.getParameter("relation" + i));
				String dateOfBirth = request.getParameter("dateOfBirth" + i);
				String isNominee = request.getParameter("isNominee" + i);
				if (request.getParameter("nomineePercent" + i) != null
						&& !request.getParameter("nomineePercent" + i).equals(
								""))
					nomineePercent = request.getParameter("nomineePercent" + i);
				if (request.getParameter("height" + i) != null
						&& !request.getParameter("height" + i).equals(""))
					height = Integer.parseInt(request
							.getParameter("height" + i));
				if (request.getParameter("identificationMark" + i) != null
						&& !request.getParameter("identificationMark" + i)
								.equals(""))
					identificationMark = request
							.getParameter("identificationMark" + i);

				//System.out.println("family name==" + familyName+ "==date of birh===" + dateOfBirth + "==isnominee==="+ isNominee);
				//System.out.println("nomineePercent==" + nomineePercent+ "==height===" + height + "==identificationMark==="+ identificationMark);

				familyNameList.add(familyName);
				relationIdList.add(relationId);
				dateOfBirthList.add(dateOfBirth);
				isNomineeList.add(isNominee);
				nomineePercentList.add(nomineePercent);
				heightsList.add(height);
				identificationMarkList.add(identificationMark);

			}
		}
		dataMap.put("personnelId", personnelId);
		dataMap.put("familyNameList", familyNameList);
		dataMap.put("relationIdList", relationIdList);
		dataMap.put("dateOfBirthList", dateOfBirthList);
		dataMap.put("isNomineeList", isNomineeList);
		dataMap.put("nomineePercentList", nomineePercentList);
		dataMap.put("heightsList", heightsList);

		dataMap.put("identificationMarkList", identificationMarkList);

		dataMap = pensionRelatedHandlerService
				.updatePersonnelEntryDetailsJsp(box, dataMap);
		boolean successfullyAdded = (Boolean)dataMap.get("successfullyAdded");
		boolean alreadyAdded = (Boolean)dataMap.get("alreadyAdded");
		if (alreadyAdded) {
			message = "Data Already Exist";
		} else if(successfullyAdded)  {
			message= "Personnel Deatils Update Successfully!!";
			
		}else{
			message = "Error Occurred in submitting personnel Details!!!";
		}
		map = pensionRelatedHandlerService.getDataForPersonnelSearchJsp();
		jsp = PERSONNEL_SEARCH_JSP;
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
		// return null;

	}

	public ModelAndView showPersonnelSearchForCalculationSheetJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = pensionRelatedHandlerService.getDataForPersonnelSearchJsp();
		jsp = PERSONNEL_SEARCH_FOR_CALCULATION_SHEET_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView personnelSearchForCalculationSheetJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String personnelName = "";
		int passNo = 0;
		int unitId = 0;
		int designationId = 0;
		if (request.getParameter("personnelName") != null
				&& !request.getParameter("personnelName").equals(""))
			personnelName = request.getParameter("personnelName");
		if (request.getParameter("passNo") != null
				&& !request.getParameter("passNo").equals(""))
			passNo = Integer.parseInt(request.getParameter("passNo"));
		if (request.getParameter("unitId") != null
				&& !request.getParameter("unitId").equals(""))
			unitId = Integer.parseInt(request.getParameter("unitId"));
		if (request.getParameter("designationId") != null
				&& !request.getParameter("designationId").equals(""))
			designationId = Integer.parseInt(request
					.getParameter("designationId"));

		dataMap.put("personnelName", personnelName);
		dataMap.put("unitId", unitId);
		dataMap.put("designationId", designationId);
		dataMap.put("passNo", passNo);

		//System.out.println("request.getParameter(jspName==="+ request.getParameter("jspName"));
		if (request.getParameter("jspName") != null
				&& request.getParameter("jspName").equals("DataSheet")) {
			dataMap.put("jspName", request.getParameter("jspName"));
			map = pensionRelatedHandlerService.showPersonnelSearchJsp(dataMap);
			jsp = PERSONNEL_SEARCH_FOR_DATA_SHEET_JSP;
		} else {
			map = pensionRelatedHandlerService.showPersonnelSearchJsp(dataMap);
			jsp = PERSONNEL_SEARCH_FOR_CALCULATION_SHEET_JSP;
		}
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showCalculationSheet(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int personnelId = Integer.parseInt(request.getParameter("personnelId"));
		dataMap.put("personnelId", personnelId);
		map = pensionRelatedHandlerService
				.showPersonnelDetailsForCalculationSheet(dataMap);
		System.out
				.println("personnel Id in calculation sheet===" + personnelId);
		jsp = CALCULATION_SHEET_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView submitCalculationSheetDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		List<String> fromDateForOtherSList = new ArrayList<String>();
		List<String> toDateForOtherSList = new ArrayList<String>();
		List<Integer> totalOtherServiceYearsList = new ArrayList<Integer>();
		List<Integer> totalOtherServiceMonthsList = new ArrayList<Integer>();
		List<Integer> totalOtherServiceDaysList = new ArrayList<Integer>();
		List<String> fromDateForEolList = new ArrayList<String>();
		List<String> toDateForEolList = new ArrayList<String>();
		List<Integer> eolYearsList = new ArrayList<Integer>();
		List<Integer> eolMonthsList = new ArrayList<Integer>();
		List<Integer> eolDaysList = new ArrayList<Integer>();

		List<String> fromDateForEmolList = new ArrayList<String>();
		List<String> toDateForEmolList = new ArrayList<String>();
		List<BigDecimal> stagnList = new ArrayList<BigDecimal>();
		//pankaj
		List<BigDecimal> gradePayList = new ArrayList<BigDecimal>();
		List<BigDecimal> basicPayList = new ArrayList<BigDecimal>();
		List<BigDecimal> rankPayList = new ArrayList<BigDecimal>();
		List<BigDecimal> dpList = new ArrayList<BigDecimal>();
		List<BigDecimal> npaList = new ArrayList<BigDecimal>();
		List<BigDecimal> othersList = new ArrayList<BigDecimal>();
		List<BigDecimal> daList = new ArrayList<BigDecimal>();
		List<Integer> noOfMonthsList = new ArrayList<Integer>();
		List<BigDecimal> totalEmolList = new ArrayList<BigDecimal>();

		int hdb = 1;
		if (Integer.parseInt(request.getParameter("hdb")) != 1) {
			hdb = Integer.parseInt(request.getParameter("hdb"));
		}
		//System.out.println("value of hdb=-======" + hdb);
		for (int i = 1; i <= hdb; i++) {

			if (!request.getParameter("fromDate" + i).equals("")) {
				String fromDate = request.getParameter("fromDate" + i);
				String toDDate = request.getParameter("toDDate" + i);
				int otherServiceInYears = Integer.parseInt(request
						.getParameter("otherServiceInYears" + i));
				int otherServiceInMonths = Integer.parseInt(request
						.getParameter("otherServiceInMonths" + i));
				int otherServiceInDays = Integer.parseInt(request
						.getParameter("otherServiceInDays" + i));

				//System.out.println("fromDate name==" + fromDate+ "==toDDate o===" + toDDate+ "==otherServiceInDays===" + otherServiceInDays);

				fromDateForOtherSList.add(fromDate);
				toDateForOtherSList.add(toDDate);
				totalOtherServiceYearsList.add(otherServiceInYears);
				totalOtherServiceMonthsList.add(otherServiceInMonths);
				totalOtherServiceDaysList.add(otherServiceInDays);
			}
		}
		int eolValue = 1;
		if (Integer.parseInt(request.getParameter("eolValue")) != 1) {
			eolValue = Integer.parseInt(request.getParameter("eolValue"));
		}
		for (int i = 1; i <= eolValue; i++) {

			if (!request.getParameter("fromDateForEol" + i).equals("")) {
				String fromDateForEol = request.getParameter("fromDateForEol"
						+ i);
				String toDateForEol = request.getParameter("toDateForEOL" + i);
				int eolYears = Integer.parseInt(request.getParameter("eolYears"
						+ i));
				int eolMonths = Integer.parseInt(request
						.getParameter("eolMonths" + i));
				int eolDays = Integer.parseInt(request.getParameter("eolDays"
						+ i));

				//System.out.println("fromDateForEol==" + fromDateForEol+ "==eolDays===" + eolDays + "==toDateForEol==="+ toDateForEol);

				fromDateForEolList.add(fromDateForEol);
				toDateForEolList.add(toDateForEol);
				eolYearsList.add(eolYears);
				eolMonthsList.add(eolMonths);
				eolDaysList.add(eolDays);
			}
		}

		int emol = 1;
		if (Integer.parseInt(request.getParameter("emol")) != 1) {
			emol = Integer.parseInt(request.getParameter("emol"));
		}
		for (int i = 1; i <= emol; i++) {

			if (!request.getParameter("fromDateForEmolu" + i).equals("")) {
				String fromDateForEmolu = request
						.getParameter("fromDateForEmolu" + i);
				BigDecimal stagn = null;
				BigDecimal gradePay = null;
				BigDecimal rankPay = null;
				BigDecimal dp = null;
				BigDecimal npa = null;
				BigDecimal others = null;
				BigDecimal da = null;
				BigDecimal totalEmol = null;
				String toDateForEmolu = request.getParameter("toDateForEmolu"
						+ i);
				BigDecimal basicPay = new BigDecimal(request
						.getParameter("basicPay" + i));
				//pankaj
				if (request.getParameter("gradePay" + i) != null
						&& !request.getParameter("gradePay" + i).equals(""))
					gradePay = new BigDecimal(request.getParameter("gradePay" + i));
				else
					gradePay = new BigDecimal("0");
				//pankaj
				
				if (request.getParameter("stagn" + i) != null
						&& !request.getParameter("stagn" + i).equals(""))
					stagn = new BigDecimal(request.getParameter("stagn" + i));
				else
					stagn = new BigDecimal("0");
				
				
				if (request.getParameter("rankPay" + i) != null
						&& !request.getParameter("rankPay" + i).equals(""))
					rankPay = new BigDecimal(request
							.getParameter("rankPay" + i));
				else
					rankPay = new BigDecimal("0");
				if (request.getParameter("dp" + i) != null
						&& !request.getParameter("dp" + i).equals(""))
					dp = new BigDecimal(request.getParameter("dp" + i));
				else
					dp = new BigDecimal("0");
				if (request.getParameter("npa" + i) != null
						&& !request.getParameter("npa" + i).equals(""))
					npa = new BigDecimal(request.getParameter("npa" + i));
				else
					npa = new BigDecimal("0");
				if (request.getParameter("others" + i) != null
						&& !request.getParameter("others" + i).equals(""))
					others = new BigDecimal(request.getParameter("others" + i));
				else
					others = new BigDecimal("0");
				if (request.getParameter("da" + i) != null
						&& !request.getParameter("da" + i).equals(""))
					da = new BigDecimal(request.getParameter("da" + i));
				else
					da = new BigDecimal("0");
				if (request.getParameter("totalEmol" + i) != null
						&& !request.getParameter("totalEmol" + i).equals(""))
					totalEmol = new BigDecimal(request.getParameter("totalEmol"
							+ i));
				else
					totalEmol = new BigDecimal("0");

				int noOfMonths = Integer.parseInt(request
						.getParameter("noOfMonths" + i));

				//System.out.println("fromDateForEmolu==" + fromDateForEmolu+ "==toDateForEmolu===" + toDateForEmolu+ "==basicPay===" + basicPay + "===noOfMonths==="+ noOfMonths);
				//System.out.println("stagn==" + stagn + "==rankPay===" + rankPay+ "==dp===" + dp + "===npa===" + npa + "==others=="+ others + "==da===" + da + "===totalEmol==="+ totalEmol);

				fromDateForEmolList.add(fromDateForEmolu);
				toDateForEmolList.add(toDateForEmolu);
				basicPayList.add(basicPay);
				stagnList.add(stagn);
				//pankaj
				gradePayList.add(gradePay);
				rankPayList.add(rankPay);
				dpList.add(dp);
				npaList.add(npa);
				othersList.add(others);
				daList.add(da);
				totalEmolList.add(totalEmol);
				noOfMonthsList.add(noOfMonths);
			}
		}
		dataMap.put("fromDateForOtherSList", fromDateForOtherSList);
		dataMap.put("toDateForOtherSList", toDateForOtherSList);
		dataMap.put("totalOtherServiceYearsList", totalOtherServiceYearsList);
		dataMap.put("totalOtherServiceMonthsList", totalOtherServiceMonthsList);
		dataMap.put("totalOtherServiceDaysList", totalOtherServiceDaysList);
		dataMap.put("fromDateForEolList", fromDateForEolList);
		dataMap.put("toDateForEolList", toDateForEolList);
		dataMap.put("eolYearsList", eolYearsList);
		dataMap.put("eolMonthsList", eolMonthsList);
		dataMap.put("eolDaysList", eolDaysList);
		dataMap.put("fromDateForEmolList", fromDateForEmolList);

		dataMap.put("toDateForEmolList", toDateForEmolList);
		dataMap.put("basicPayList", basicPayList);
		dataMap.put("stagnList", stagnList);
		//pankaj
		dataMap.put("gradePayList", gradePayList);
		
		dataMap.put("rankPayList", rankPayList);
		dataMap.put("dpList", dpList);
		dataMap.put("npaList", npaList);
		dataMap.put("othersList", othersList);
		dataMap.put("daList", daList);
		dataMap.put("totalEmolList", totalEmolList);
		dataMap.put("noOfMonthsList", noOfMonthsList);

		boolean bool = pensionRelatedHandlerService
				.submitCalculationSheetDetails(box, dataMap);
		if (bool) {
			message = "Calculation Sheet Details Added Successfully!!";
		} else {
			message = "Error Occurred in Adding Calculation Sheet Details!!!";
		}
		map = pensionRelatedHandlerService.getDataForPersonnelSearchJsp();
		jsp = PERSONNEL_SEARCH_FOR_CALCULATION_SHEET_JSP;
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
		// return null;

	}

	public ModelAndView showUpdatePersonnelSearchForCalculationSheetJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = pensionRelatedHandlerService.getDataForPersonnelSearchJsp();
		jsp = UPDATE_PERSONNEL_SEARCH_FOR_CALCULATION_SHEET_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView updatePersonnelSearchForCalculationSheetJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String personnelName = "";
		int passNo = 0;
		int unitId = 0;
		int designationId = 0;
		if (request.getParameter("personnelName") != null
				&& !request.getParameter("personnelName").equals(""))
			personnelName = request.getParameter("personnelName");
		if (request.getParameter("passNo") != null
				&& !request.getParameter("passNo").equals(""))
			passNo = Integer.parseInt(request.getParameter("passNo"));
		if (request.getParameter("unitId") != null
				&& !request.getParameter("unitId").equals(""))
			unitId = Integer.parseInt(request.getParameter("unitId"));
		if (request.getParameter("designationId") != null
				&& !request.getParameter("designationId").equals(""))
			designationId = Integer.parseInt(request
					.getParameter("designationId"));

		System.out
				.println("pass no in updatePersonnelSearchForCalculationSheetJsp==="
						+ passNo);
		dataMap.put("personnelName", personnelName);
		dataMap.put("unitId", unitId);
		dataMap.put("designationId", designationId);
		dataMap.put("passNo", passNo);
		map = pensionRelatedHandlerService
				.showUpdatePersonnelSearchForCalculationSheet(dataMap);
		jsp = UPDATE_PERSONNEL_SEARCH_FOR_CALCULATION_SHEET_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showUpdateCalculationSheet(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int personnelId = Integer.parseInt(request.getParameter("personnelId"));
		dataMap.put("personnelId", personnelId);
		map = pensionRelatedHandlerService.showUpdateCalculationSheet(dataMap);
		System.out
				.println("personnel Id in calculation sheet===" + personnelId);
		jsp = UPDATE_CALCULATION_SHEET_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView updateCalculationSheet(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		List<String> fromDateForOtherSList = new ArrayList<String>();
		List<String> toDateForOtherSList = new ArrayList<String>();
		List<Integer> totalOtherServiceYearsList = new ArrayList<Integer>();
		List<Integer> totalOtherServiceMonthsList = new ArrayList<Integer>();
		List<Integer> totalOtherServiceDaysList = new ArrayList<Integer>();
		List<String> fromDateForEolList = new ArrayList<String>();
		List<String> toDateForEolList = new ArrayList<String>();
		List<Integer> eolYearsList = new ArrayList<Integer>();
		List<Integer> eolMonthsList = new ArrayList<Integer>();
		List<Integer> eolDaysList = new ArrayList<Integer>();

		List<String> fromDateForEmolList = new ArrayList<String>();
		List<String> toDateForEmolList = new ArrayList<String>();
		List<BigDecimal> stagnList = new ArrayList<BigDecimal>();
		List<BigDecimal> basicPayList = new ArrayList<BigDecimal>();
		List<BigDecimal> gradePayList = new ArrayList<BigDecimal>();
		
		List<BigDecimal> rankPayList = new ArrayList<BigDecimal>();
		List<BigDecimal> dpList = new ArrayList<BigDecimal>();
		List<BigDecimal> npaList = new ArrayList<BigDecimal>();
		List<BigDecimal> othersList = new ArrayList<BigDecimal>();
		List<BigDecimal> daList = new ArrayList<BigDecimal>();
		List<Integer> noOfMonthsList = new ArrayList<Integer>();
		List<BigDecimal> totalEmolList = new ArrayList<BigDecimal>();

		// int
		// personnelId=Integer.parseInt(request.getParameter("personnelId"));

		int hdb = 1;
		if (Integer.parseInt(request.getParameter("hdb")) != 1) {
			hdb = Integer.parseInt(request.getParameter("hdb"));
		}
		//System.out.println("value of hdb=-======" + hdb);
		//System.out.println("value of eol=-======"	+ Integer.parseInt(request.getParameter("eolValue")));
		//System.out.println("value of emoluments=-======"+ Integer.parseInt(request.getParameter("emol")));
		for (int i = 1; i <= hdb; i++) {

			if (!request.getParameter("fromDate" + i).equals("")) {
				String fromDate = request.getParameter("fromDate" + i);
				String toDDate = request.getParameter("toDDate" + i);
				int otherServiceInYears = Integer.parseInt(request
						.getParameter("otherServiceInYears" + i));
				int otherServiceInMonths = Integer.parseInt(request
						.getParameter("otherServiceInMonths" + i));
				int otherServiceInDays = Integer.parseInt(request
						.getParameter("otherServiceInDays" + i));

				//System.out.println("fromDate name==" + fromDate+ "==toDDate o===" + toDDate+ "==otherServiceInDays===" + otherServiceInDays);

				fromDateForOtherSList.add(fromDate);
				toDateForOtherSList.add(toDDate);
				totalOtherServiceYearsList.add(otherServiceInYears);
				totalOtherServiceMonthsList.add(otherServiceInMonths);
				totalOtherServiceDaysList.add(otherServiceInDays);
			}
		}
		int eolValue = 1;
		if (Integer.parseInt(request.getParameter("eolValue")) != 1) {
			eolValue = Integer.parseInt(request.getParameter("eolValue"));
		}
		for (int i = 1; i <= eolValue; i++) {

			if (!request.getParameter("fromDateForEol" + i).equals("")) {
				String fromDateForEol = request.getParameter("fromDateForEol"
						+ i);
				String toDateForEol = request.getParameter("toDateForEOL" + i);
				int eolYears = Integer.parseInt(request.getParameter("eolYears"
						+ i));
				int eolMonths = Integer.parseInt(request
						.getParameter("eolMonths" + i));
				int eolDays = Integer.parseInt(request.getParameter("eolDays"
						+ i));

				//System.out.println("fromDateForEol==" + fromDateForEol+ "==eolDays===" + eolDays + "==toDateForEol==="+ toDateForEol);

				fromDateForEolList.add(fromDateForEol);
				toDateForEolList.add(toDateForEol);
				eolYearsList.add(eolYears);
				eolMonthsList.add(eolMonths);
				eolDaysList.add(eolDays);
			}
		}

		int emol = 1;
		if (Integer.parseInt(request.getParameter("emol")) != 1) {
			emol = Integer.parseInt(request.getParameter("emol"));
		}
		for (int i = 1; i <= emol; i++) {

			if (!request.getParameter("fromDateForEmolu" + i).equals("")) {
				String fromDateForEmolu = request
						.getParameter("fromDateForEmolu" + i);
				BigDecimal stagn = null;
				BigDecimal rankPay = null;
				BigDecimal dp = null;
				BigDecimal npa = null;
				BigDecimal others = null;
				BigDecimal da = null;
				BigDecimal totalEmol = null;
				BigDecimal gradePay = null;
				
				String toDateForEmolu = request.getParameter("toDateForEmolu"
						+ i);
				BigDecimal basicPay = new BigDecimal(request
						.getParameter("basicPay" + i));
				
				if (request.getParameter("gradePay" + i) != null
						&& !request.getParameter("gradePay" + i).equals(""))
					gradePay = new BigDecimal(request.getParameter("gradePay" + i));
				else
					gradePay = new BigDecimal("0");
				if (request.getParameter("stagn" + i) != null
						&& !request.getParameter("stagn" + i).equals(""))
					stagn = new BigDecimal(request.getParameter("stagn" + i));
				else
					stagn = new BigDecimal("0");
				if (request.getParameter("rankPay" + i) != null
						&& !request.getParameter("rankPay" + i).equals(""))
					rankPay = new BigDecimal(request
							.getParameter("rankPay" + i));
				else
					rankPay = new BigDecimal("0");
				if (request.getParameter("dp" + i) != null
						&& !request.getParameter("dp" + i).equals(""))
					dp = new BigDecimal(request.getParameter("dp" + i));
				else
					dp = new BigDecimal("0");
				if (request.getParameter("npa" + i) != null
						&& !request.getParameter("npa" + i).equals(""))
					npa = new BigDecimal(request.getParameter("npa" + i));
				else
					npa = new BigDecimal("0");
				if (request.getParameter("others" + i) != null
						&& !request.getParameter("others" + i).equals(""))
					others = new BigDecimal(request.getParameter("others" + i));
				else
					others = new BigDecimal("0");
				if (request.getParameter("da" + i) != null
						&& !request.getParameter("da" + i).equals(""))
					da = new BigDecimal(request.getParameter("da" + i));
				else
					da = new BigDecimal("0");
				if (request.getParameter("totalEmol" + i) != null
						&& !request.getParameter("totalEmol" + i).equals(""))
					totalEmol = new BigDecimal(request.getParameter("totalEmol"
							+ i));
				else
					totalEmol = new BigDecimal("0");

				int noOfMonths = Integer.parseInt(request
						.getParameter("noOfMonths" + i));

				//System.out.println("fromDateForEmolu==" + fromDateForEmolu+ "==toDateForEmolu===" + toDateForEmolu+ "==basicPay===" + basicPay + "===noOfMonths==="+ noOfMonths);
				//System.out.println("stagn==" + stagn + "==rankPay===" + rankPay+ "==dp===" + dp + "===npa===" + npa + "==others=="+ others + "==da===" + da + "===totalEmol==="+ totalEmol);

				fromDateForEmolList.add(fromDateForEmolu);
				toDateForEmolList.add(toDateForEmolu);
				basicPayList.add(basicPay);
				gradePayList.add(gradePay);
				stagnList.add(stagn);
				rankPayList.add(rankPay);
				dpList.add(dp);
				npaList.add(npa);
				othersList.add(others);
				daList.add(da);
				totalEmolList.add(totalEmol);
				noOfMonthsList.add(noOfMonths);
			}
		}

		dataMap.put("fromDateForOtherSList", fromDateForOtherSList);
		dataMap.put("toDateForOtherSList", toDateForOtherSList);
		dataMap.put("totalOtherServiceYearsList", totalOtherServiceYearsList);
		dataMap.put("totalOtherServiceMonthsList", totalOtherServiceMonthsList);
		dataMap.put("totalOtherServiceDaysList", totalOtherServiceDaysList);
		dataMap.put("fromDateForEolList", fromDateForEolList);
		dataMap.put("toDateForEolList", toDateForEolList);
		dataMap.put("eolYearsList", eolYearsList);
		dataMap.put("eolMonthsList", eolMonthsList);
		dataMap.put("eolDaysList", eolDaysList);
		dataMap.put("fromDateForEmolList", fromDateForEmolList);

		dataMap.put("toDateForEmolList", toDateForEmolList);
		dataMap.put("basicPayList", basicPayList);
		dataMap.put("gradePayList", gradePayList);
		dataMap.put("stagnList", stagnList);
		dataMap.put("rankPayList", rankPayList);
		dataMap.put("dpList", dpList);
		dataMap.put("npaList", npaList);
		dataMap.put("othersList", othersList);
		dataMap.put("daList", daList);
		dataMap.put("totalEmolList", totalEmolList);
		dataMap.put("noOfMonthsList", noOfMonthsList);

		boolean bool = pensionRelatedHandlerService.updateCalculationSheet(box,
				dataMap);
		if (bool) {
			message = "Calculation Sheet Details Updated Successfully!!";
		} else {
			message = "Error Occurred in Updating Calculation Sheet Details!!!";
		}
		map = pensionRelatedHandlerService.getDataForPersonnelSearchJsp();
		jsp = UPDATE_PERSONNEL_SEARCH_FOR_CALCULATION_SHEET_JSP;
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
		// return null;

	}

	public ModelAndView showPersonnelSearchForDataSheetJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = pensionRelatedHandlerService.getDataForPersonnelSearchJsp();
		jsp = PERSONNEL_SEARCH_FOR_DATA_SHEET_JSP;
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showDataSheetJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int personnelId = Integer.parseInt(request.getParameter("personnelId"));
		dataMap.put("personnelId", personnelId);
		map = pensionRelatedHandlerService
				.showPersonnelDetailsForCalculationSheet(dataMap);
		//System.out.println("personnel Id in Data sheet===" + personnelId);
		jsp = DATA_SHEET_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView submitDataSheetJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);

		boolean bool = pensionRelatedHandlerService.submitDataSheetJsp(box);
		if (bool) {
			message = "Data Sheet Details Submitted Successfully!!";
		} else {
			message = "Error Occurred in submitting Data Sheet Details!!!";
		}
		map = pensionRelatedHandlerService.getDataForPersonnelSearchJsp();
		jsp = PERSONNEL_SEARCH_FOR_DATA_SHEET_JSP;
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
		// return null;

	}

	public ModelAndView showUpdatePersonnelSearchForDataSheetJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = pensionRelatedHandlerService.getDataForPersonnelSearchJsp();
		jsp = UPDATE_PERSONNEL_SEARCH_FOR_DATA_SHEET_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView updatePersonnelSearchForDataSheetJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String personnelName = "";
		int passNo = 0;
		int unitId = 0;
		int designationId = 0;
		if (request.getParameter("personnelName") != null
				&& !request.getParameter("personnelName").equals(""))
			personnelName = request.getParameter("personnelName");
		if (request.getParameter("passNo") != null
				&& !request.getParameter("passNo").equals(""))
			passNo = Integer.parseInt(request.getParameter("passNo"));
		if (request.getParameter("unitId") != null
				&& !request.getParameter("unitId").equals(""))
			unitId = Integer.parseInt(request.getParameter("unitId"));
		if (request.getParameter("designationId") != null
				&& !request.getParameter("designationId").equals(""))
			designationId = Integer.parseInt(request
					.getParameter("designationId"));

		System.out
				.println("pass no in updatePersonnelSearchForCalculationSheetJsp==="
						+ passNo);
		dataMap.put("personnelName", personnelName);
		dataMap.put("unitId", unitId);
		dataMap.put("designationId", designationId);
		dataMap.put("passNo", passNo);
		map = pensionRelatedHandlerService
				.showUpdatePersonnelSearchForDataSheet(dataMap);
		jsp = UPDATE_PERSONNEL_SEARCH_FOR_DATA_SHEET_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showUpdateDataSheetJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int personnelId = Integer.parseInt(request.getParameter("personnelId"));
		dataMap.put("personnelId", personnelId);
		map = pensionRelatedHandlerService.showUpdateDataSheet(dataMap);
		System.out
				.println("personnel Id in calculation sheet===" + personnelId);
		jsp = UPDATE_DATA_SHEET_JSP;
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
		// return null;

	}

	public ModelAndView updateDataSheet(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);

		boolean bool = pensionRelatedHandlerService.updateDataSheet(box);
		if (bool) {
			message = "Data Sheet Details updated Successfully!!";
		} else {
			message = "Error Occurred in Updating Data Sheet Details!!!";
		}
		map = pensionRelatedHandlerService.getDataForPersonnelSearchJsp();
		jsp = UPDATE_PERSONNEL_SEARCH_FOR_DATA_SHEET_JSP;
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
		// return null;

	}

	public ModelAndView showPersonnelSearchForForm7Jsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = pensionRelatedHandlerService.getDataForPersonnelSearchJsp();
		jsp = PERSONNEL_SEARCH__FOR_FORM7_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showForm7Jsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int personnelId = Integer.parseInt(request.getParameter("personnelId"));
		dataMap.put("personnelId", personnelId);
		map = pensionRelatedHandlerService
				.showPersonnelDetailsForForm7Entry(dataMap);
		//System.out.println("personnel Id in showForm7Jsp===" + personnelId);
		jsp = FORM7_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView submitForm7Entry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		List<String> fromDateList = new ArrayList<String>();
		List<String> toDateList = new ArrayList<String>();
		List<BigDecimal> payList = new ArrayList<BigDecimal>();
		List<Integer> noOfMonthsList = new ArrayList<Integer>();
		List<BigDecimal> personelPayList = new ArrayList<BigDecimal>();
		List<BigDecimal> averageEmolList = new ArrayList<BigDecimal>();

		int hdb = 1;
		if (Integer.parseInt(request.getParameter("hdb")) != 1) {
			hdb = Integer.parseInt(request.getParameter("hdb"));
		}
		//System.out.println("value of hdb=-======" + hdb);

		for (int i = 1; i <= hdb; i++) {

			if (!request.getParameter("fromDate" + i).equals("")) {
				BigDecimal personelPay = null;
				String fromDate = request.getParameter("fromDate" + i);
				String toDDate = request.getParameter("toDDate" + i);
				BigDecimal pay = new BigDecimal(request.getParameter("pay" + i));
				int noOfMonths = Integer.parseInt(request
						.getParameter("noOfMonths" + i));
				if (request.getParameter("personelPay" + i) != null
						&& !request.getParameter("personelPay" + i).equals("")) {
					personelPay = new BigDecimal(request
							.getParameter("personelPay" + i));
				} else {
					personelPay = new BigDecimal("0");
				}
				BigDecimal averageEmol = new BigDecimal(request
						.getParameter("averageEmol" + i));

				//System.out.println("fromDate name==" + fromDate+ "==toDDate o===" + toDDate + "==pay===" + pay);
				//System.out.println("noOfMonths==" + noOfMonths+ "==personelPay o===" + personelPay+ "==averageEmol===" + averageEmol);
				fromDateList.add(fromDate);
				toDateList.add(toDDate);
				payList.add(pay);
				noOfMonthsList.add(noOfMonths);
				personelPayList.add(personelPay);
				averageEmolList.add(averageEmol);

			}
		}
		dataMap.put("fromDateList", fromDateList);
		dataMap.put("toDateList", toDateList);
		dataMap.put("payList", payList);
		dataMap.put("noOfMonthsList", noOfMonthsList);
		dataMap.put("personelPayList", personelPayList);
		dataMap.put("averageEmolList", averageEmolList);

		boolean bool = pensionRelatedHandlerService.submitForm7Entry(box,
				dataMap);
		if (bool) {
			message = "Form 7 Details Submitted Successfully!!";
		} else {
			message = "Error Occurred in submitting Form 7 Details!!!";
		}
		map = pensionRelatedHandlerService.getDataForPersonnelSearchJsp();
		jsp = PERSONNEL_SEARCH__FOR_FORM7_JSP;
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
		// return null;

	}

	public ModelAndView showUpdatePersonnelSearchForForm7Jsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = pensionRelatedHandlerService.getDataForPersonnelSearchJsp();
		jsp = UPDATE_PERSONNEL_SEARCH_FOR_FORM7_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView updatePersonnelSearchForForm7(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String personnelName = "";
		int passNo = 0;
		int unitId = 0;
		int designationId = 0;
		if (request.getParameter("personnelName") != null
				&& !request.getParameter("personnelName").equals(""))
			personnelName = request.getParameter("personnelName");
		if (request.getParameter("passNo") != null
				&& !request.getParameter("passNo").equals(""))
			passNo = Integer.parseInt(request.getParameter("passNo"));

		if (request.getParameter("unitId") != null
				&& !request.getParameter("unitId").equals(""))
			unitId = Integer.parseInt(request.getParameter("unitId"));
		if (request.getParameter("designationId") != null
				&& !request.getParameter("designationId").equals(""))
			designationId = Integer.parseInt(request
					.getParameter("designationId"));

		dataMap.put("personnelName", personnelName);
		dataMap.put("unitId", unitId);
		dataMap.put("designationId", designationId);
		dataMap.put("passNo", passNo);

		map = pensionRelatedHandlerService
				.showUpdatePersonnelSearchForForm7(dataMap);
		jsp = UPDATE_PERSONNEL_SEARCH_FOR_FORM7_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showUpdateForm7Jsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int personnelId = Integer.parseInt(request.getParameter("personnelId"));
		dataMap.put("personnelId", personnelId);
		map = pensionRelatedHandlerService.showUpdateForm7Jsp(dataMap);
		System.out
				.println("personnel Id in calculation sheet===" + personnelId);
		jsp = UPDATE_FORM7_ENTRY_JSP;
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView updateForm7Entry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		List<String> fromDateList = new ArrayList<String>();
		List<String> toDateList = new ArrayList<String>();
		List<BigDecimal> payList = new ArrayList<BigDecimal>();
		List<Integer> noOfMonthsList = new ArrayList<Integer>();
		List<BigDecimal> personelPayList = new ArrayList<BigDecimal>();
		List<BigDecimal> averageEmolList = new ArrayList<BigDecimal>();
		int pensionForm7Id = Integer.parseInt(request
				.getParameter("pensionForm7Id"));
		int hdb = 1;
		if (Integer.parseInt(request.getParameter("hdb")) != 1) {
			hdb = Integer.parseInt(request.getParameter("hdb"));
		}
		//System.out.println("value of hdb=-======" + hdb);

		for (int i = 1; i <= hdb; i++) {

			if (!request.getParameter("fromDate" + i).equals("")) {
				BigDecimal personelPay = null;
				String fromDate = request.getParameter("fromDate" + i);
				String toDDate = request.getParameter("toDDate" + i);
				BigDecimal pay = new BigDecimal(request.getParameter("pay" + i));
				int noOfMonths = Integer.parseInt(request
						.getParameter("noOfMonths" + i));
				if (request.getParameter("personelPay" + i) != null
						&& !request.getParameter("personelPay" + i).equals("")) {
					personelPay = new BigDecimal(request
							.getParameter("personelPay" + i));
				} else {
					personelPay = new BigDecimal("0");
				}
				BigDecimal averageEmol = new BigDecimal(request
						.getParameter("averageEmol" + i));

				//System.out.println("fromDate name==" + fromDate+ "==toDDate o===" + toDDate + "==pay===" + pay);			
				//System.out.println("noOfMonths==" + noOfMonths+ "==personelPay o===" + personelPay+ "==averageEmol===" + averageEmol);

				fromDateList.add(fromDate);
				toDateList.add(toDDate);
				payList.add(pay);
				noOfMonthsList.add(noOfMonths);
				personelPayList.add(personelPay);
				averageEmolList.add(averageEmol);

			}
		}
		dataMap.put("fromDateList", fromDateList);
		dataMap.put("toDateList", toDateList);
		dataMap.put("payList", payList);
		dataMap.put("noOfMonthsList", noOfMonthsList);
		dataMap.put("personelPayList", personelPayList);
		dataMap.put("averageEmolList", averageEmolList);
		dataMap.put("pensionForm7Id", pensionForm7Id);
		boolean bool = pensionRelatedHandlerService.updateForm7Entry(box,
				dataMap);
		if (bool) {
			message = "Form 7 Details Updated Successfully!!";
		} else {
			message = "Error Occurred in Updating Form 7 Details!!!";
		}
		map = pensionRelatedHandlerService.getDataForPersonnelSearchJsp();
		jsp = UPDATE_PERSONNEL_SEARCH_FOR_FORM7_JSP;
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
		// return null;

	}

	public ModelAndView showPersonnelSearchForForm8Jsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = pensionRelatedHandlerService.getDataForPersonnelSearchJsp();
		jsp = PERSONNEL_SEARCH__FOR_FORM8_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showForm8Jsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int personnelId = Integer.parseInt(request.getParameter("personnelId"));
		dataMap.put("personnelId", personnelId);
		map = pensionRelatedHandlerService
				.showPersonnelDetailsForForm8Entry(dataMap);
		//System.out.println("personnel Id in showForm7Jsp===" + personnelId);
		jsp = FORM8_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView submitForm8Entry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);

		boolean bool = pensionRelatedHandlerService.submitForm8Entry(box);
		if (bool) {
			message = "Form 8 Details Submitted Successfully!!";
		} else {
			message = "Error Occurred in submitting Form 8 Details!!!";
		}
		map = pensionRelatedHandlerService.getDataForPersonnelSearchJsp();
		jsp = PERSONNEL_SEARCH__FOR_FORM8_JSP;
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
		// return null;

	}

	public ModelAndView showUpdatePersonnelSearchForForm8Jsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = pensionRelatedHandlerService.getDataForPersonnelSearchJsp();
		jsp = UPDATE_PERSONNEL_SEARCH_FOR_FORM8_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showUpdateForm8Jsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int personnelId = Integer.parseInt(request.getParameter("personnelId"));
		dataMap.put("personnelId", personnelId);
		map = pensionRelatedHandlerService.showUpdateForm8Jsp(dataMap);
		//System.out.println("personnel Id in showUpdateForm8Jsp==="+ personnelId);
		jsp = UPDATE_FORM8_JSP;
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView updateForm8Entry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);

		boolean bool = pensionRelatedHandlerService.updateForm8Entry(box);
		if (bool) {
			message = "Form 8 Details Updated Successfully!!";
		} else {
			message = "Error Occurred in updating Form 8 Details!!!";
		}
		map = pensionRelatedHandlerService.getDataForPersonnelSearchJsp();
		jsp = UPDATE_PERSONNEL_SEARCH_FOR_FORM8_JSP;
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
		// return null;

	}

	public ModelAndView showPersonnelSearchForRetirementEtryJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = pensionRelatedHandlerService.getDataForPersonnelSearchJsp();
		jsp = PERSONNEL_SEARCH__FOR_RETIREMENT_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showRetirementEntryFormJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int personnelId = Integer.parseInt(request.getParameter("personnelId"));
		dataMap.put("personnelId", personnelId);
		map = pensionRelatedHandlerService
				.showPersonnelDetailsForForm8Entry(dataMap);
		//System.out.println("personnel Id in RETIREMENT_ENTRY_JSP==="+ personnelId);
		jsp = RETIREMENT_ENTRY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView submitRetirementEntryForm(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);

		boolean bool = pensionRelatedHandlerService
				.submitRetirementEntryForm(box);
		if (bool) {
			message = "Retirement Entry Details Submitted Successfully!!";
		} else {
			message = "Eror Occurred in submittingRetirement Entry Details!!!";
		}
		map = pensionRelatedHandlerService.getDataForPersonnelSearchJsp();
		jsp = PERSONNEL_SEARCH__FOR_RETIREMENT_ENTRY_JSP;
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
		// return null;

	}

	public ModelAndView showUpdatePersonnelSearchForRetirementFormJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = pensionRelatedHandlerService.getDataForPersonnelSearchJsp();
		jsp = UPDATE_PERSONNEL_SEARCH_FOR_RETIREMENT_FORM_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showUpdateRetirementEntryFormJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int personnelId = Integer.parseInt(request.getParameter("personnelId"));
		dataMap.put("personnelId", personnelId);
		map = pensionRelatedHandlerService.showUpdateRetirementForm(dataMap);
		//System.out.println("personnel Id in RETIREMENT_ENTRY_JSP==="+ personnelId);
		jsp = UPDATE_RETIREMENT_ENTRY_FORM_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView updateRetirementEntryForm(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);

		boolean bool = pensionRelatedHandlerService
				.updateRetirementEntryForm(box);
		if (bool) {
			message = "Retirement Entry Details Updated Successfully!!";
		} else {
			message = "Eror Occurred in Updating Retirement Entry Details!!!";
		}
		map = pensionRelatedHandlerService.getDataForPersonnelSearchJsp();
		jsp = UPDATE_PERSONNEL_SEARCH_FOR_RETIREMENT_FORM_JSP;
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
		// return null;

	}

	// --------------------------------nidhi---------------------------

	public ModelAndView showDataSheetReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		jsp = DATA_SHEET;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView printDataSheetReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String query = "";
		int Passno = 0;
		String Name = "";

		if (request.getParameter("passNo") != null
				&& !request.getParameter("passNo").equals("")) {
			Passno = Integer.parseInt(request.getParameter("passNo"));
		}
		//System.out.println("passNo-- rttryr---" + Passno);
		if (request.getParameter("Name") != null) {
			Name = request.getParameter("Name");
		}
		//System.out.println("Name-------" + Name);

		// detailsMap = pensionRelatedHandlerService.getSubCharge();
		detailsMap = pensionRelatedHandlerService.getConnectionForReport();
		parameters.put("Passno", Passno);
		parameters.put("Name", Name);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/Reports/"));

		try {

			HMSUtil.generateReport("date_sheet", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView showDescriptiveRollJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		jsp = DESCRIPTIVE_ROLL;

		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView printDescriptiveRollJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String query = "";
		int Passno = 0;
		String Name = "";

		if (request.getParameter("passNo") != null
				&& !request.getParameter("passNo").equals("")) {
			Passno = Integer.parseInt(request.getParameter("passNo"));
		}

		//System.out.println("passNo-- rttryr---" + Passno);
		if (request.getParameter("Name") != null) {
			Name = request.getParameter("Name");
		}
		//System.out.println("Name-------" + Name);

		// detailsMap = pensionRelatedHandlerService.getSubCharge();
		detailsMap = pensionRelatedHandlerService.getConnectionForReport();
		parameters.put("Passno", Passno);
		parameters.put("Name", Name);

		try {

			HMSUtil.generateReport("descriptive_roll", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView showFamilyDetailsJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		jsp = FAMILY_DETAILS;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printFamilyDetailsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		int Passno = 0;
		String Name = "";

		if (request.getParameter("passNo") != null
				&& !request.getParameter("passNo").equals("")) {
			Passno = Integer.parseInt(request.getParameter("passNo"));
		}

		if (request.getParameter("Name") != null) {
			Name = request.getParameter("Name");
		}
		detailMap = pensionRelatedHandlerService.getConnectionForReport();
		parameters.put("Passno", Passno);
		parameters.put("Name", Name);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/Reports/"));

		try {
			HMSUtil.generateReport("Form_3_Family_Details", parameters,
					(Connection) detailMap.get("conn"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		return null;
	}

	public ModelAndView showFormFiveJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		jsp = FORM_FIVE;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printFormFiveJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		int Passno = 0;
		String Name = "";

		if (request.getParameter("passNo") != null
				&& !request.getParameter("passNo").equals("")) {
			Passno = Integer.parseInt(request.getParameter("passNo"));
		}

		if (request.getParameter("Name") != null) {
			Name = request.getParameter("Name");
		}
		detailMap = pensionRelatedHandlerService.getConnectionForReport();
		parameters.put("Passno", Passno);
		parameters.put("Name", Name);

		try {
			HMSUtil.generateReport("Form_5", parameters, (Connection) detailMap
					.get("conn"), response, getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		return null;
	}

	public ModelAndView showForm8ReportJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		jsp = FORM_8;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printForm8ReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		int Passno = 0;
		String Name = "";

		if (request.getParameter("passNo") != null
				&& !request.getParameter("passNo").equals("")) {
			Passno = Integer.parseInt(request.getParameter("passNo"));
		}

		if (request.getParameter("Name") != null) {
			Name = request.getParameter("Name");
		}
		detailMap = pensionRelatedHandlerService.getConnectionForReport();
		parameters.put("Passno", Passno);
		parameters.put("Name", Name);

		try {
			HMSUtil.generateReport("Form_8", parameters, (Connection) detailMap
					.get("conn"), response, getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		return null;
	}

	public ModelAndView showForm7ReportJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		jsp = FORM_7;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printForm7Jsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		int Passno = 0;
		String Name = "";

		if (request.getParameter("passNo") != null
				&& !request.getParameter("passNo").equals("")) {
			Passno = Integer.parseInt(request.getParameter("passNo"));
		}

		if (request.getParameter("Name") != null) {
			Name = request.getParameter("Name");
		}
		detailMap = pensionRelatedHandlerService.getConnectionForReport();
		parameters.put("Passno", Passno);
		parameters.put("Name", Name);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/Reports/"));
		try {
			HMSUtil.generateReport("Form_7", parameters, (Connection) detailMap
					.get("conn"), response, getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		return null;
	}

	public ModelAndView showForm356Jsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		jsp = FORM_356;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printForm356Jsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		int Passno = 0;
		String Name = "";

		if (request.getParameter("passNo") != null
				&& !request.getParameter("passNo").equals("")) {
			Passno = Integer.parseInt(request.getParameter("passNo"));
		}

		if (request.getParameter("Name") != null) {
			Name = request.getParameter("Name");
		}
		detailMap = pensionRelatedHandlerService.getConnectionForReport();
		parameters.put("Passno", Passno);
		parameters.put("Name", Name);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/Reports/"));

		try {
			HMSUtil.generateReport("Form_356", parameters,
					(Connection) detailMap.get("conn"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		return null;
	}
	public void checkEmployeeFromDB(HttpServletRequest request , HttpServletResponse response){
    	Map<String ,Object> returnMap = new HashMap<String , Object>();
    	MasPersonnelDetails masEmployee = null;
    	boolean flag =true;
    	List<MasPersonnelDetails> masEmployeeList = new ArrayList<MasPersonnelDetails>();
    	int unitId = 0;
    	String passNo ="";
    	if(request.getParameter("unitId")!=null && !request.getParameter("unitId").equals("") )
    	{
    		unitId = Integer.parseInt(request.getParameter("unitId"));
    	}
    	if(request.getParameter("passNo")!= null )
    	{
    		passNo=request.getParameter("passNo");
    	}
    	returnMap = pensionRelatedHandlerService.EmployeeExist(passNo, unitId);
    	masEmployeeList = (List<MasPersonnelDetails>)returnMap.get("masEmployeeList");
    	flag = (Boolean)returnMap.get("flag");
    	StringBuffer sb = new StringBuffer();
    	try{
    	sb.append("<?xml version='1.0' encoding='ISO-8859-1'?>");
    	sb.append("<items>");
    	sb.append("<item>");
    	if(flag==false){
    	masEmployee = masEmployeeList.get(0);	
    	sb.append("<personnelName>"+masEmployee.getPersonnelName()+"</personnelName>");
    	sb.append("<passNo>"+masEmployee.getPassNo()+"</passNo>");
    	sb.append("<unitName>"+masEmployee.getUnit().getUnitName()+"</unitName>");
    	}else{
    		sb.append("<personnelName></personnelName>");
        	sb.append("<passNo></passNo>");
        	sb.append("<unitName></unitName>");
    	}
    	sb.append("</item>");
    	sb.append("</items>");
    	response.setContentType("text/xml");
    	response.setHeader("Cache-Control", "no-cache");
    	//System.out.println("sb::"+sb.toString());
    	response.getWriter().write(sb.toString());
    	}catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
    	
    	
    }
	public void fillRetier(HttpServletRequest request,HttpServletResponse response) {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDesignation> designationList = new ArrayList<MasDesignation>();
		int designationId = 0;

		try {
			if (request.getParameter("designationId") != null) {
				designationId = Integer.parseInt(request.getParameter("designationId"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("designationId", designationId);
		map = pensionRelatedHandlerService.fillRetier(dataMap);
		if (map.get("designationList") != null) {
			designationList = (List) map.get("designationList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<items>");
			for (MasDesignation designation : designationList) {
				sb.append("<item>");
				if (designation.getGroup() != null) {
					sb.append("<retierYear>"
							+ designation.getGroup().getRetirementAge()
							+ "</retierYear>");
				} else {
					sb.append("<retierYear>-</retierYear>");
				}
				sb.append("</item>");
				break;
			}
			sb.append("</items>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<chargeCodes>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</chargeCodes>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	
	}


