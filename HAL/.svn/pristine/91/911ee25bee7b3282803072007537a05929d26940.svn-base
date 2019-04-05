package jkt.hms.workservices.controller;

import static jkt.hms.util.RequestConstants.ALLOTMENT_AMOUNT;
import static jkt.hms.util.RequestConstants.ALLOTMENT_FILE_DATE;
import static jkt.hms.util.RequestConstants.ALLOTMENT_FILE_NO;
import static jkt.hms.util.RequestConstants.ALLOTMENT_OF_FUNDS_FOR_MINOR_WORKS_JSP;
import static jkt.hms.util.RequestConstants.ALLOTMENT_REMARKS;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.FINANCIAL_YEAR;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasAllotmentOfFundsForMinorWorks;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.HMSUtil;
import jkt.hms.workservices.handler.AllotmentOfFundsForMinorWorkHandler;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class AllotmentOfFundsForMinorWorkController extends
		MultiActionController {
	private AllotmentOfFundsForMinorWorkHandler allotmentOfFundsForMinorWorkHandler = null;
	private CommonMasterHandlerService commonMasterHandlerService = null;

	@SuppressWarnings("unchecked")
	public ModelAndView showAllotmentOfFundsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		map = allotmentOfFundsForMinorWorkHandler.showAllotmentOfFundsJsp();
		jsp += ALLOTMENT_OF_FUNDS_FOR_MINOR_WORKS_JSP;
		jsp += ".jsp";
		title = "WorkCategory";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchAllotmentOfFunds(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String allotmentFileNo = null;

		String searchField = null;
		String jsp = "";
		String title = "";

		if (request.getParameter(ALLOTMENT_FILE_NO) != null
				&& !(request.getParameter(ALLOTMENT_FILE_NO).equals(""))) {
			allotmentFileNo = request.getParameter(ALLOTMENT_FILE_NO);
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

			allotmentFileNo = searchField;

		}

		map = allotmentOfFundsForMinorWorkHandler
				.searchAllotmentOfFunds(allotmentFileNo);
		jsp = ALLOTMENT_OF_FUNDS_FOR_MINOR_WORKS_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("allotmentFileNo", allotmentFileNo);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addAllotmentOfFunds(HttpServletRequest request,
			HttpServletResponse response) {
		String financialYear = "";
		String allotmentFileNo = "";
		Date allotmentFileDate = null;
		Date currentDate = null;
		BigDecimal allotmentAmount = new BigDecimal(0);
		String remarks = "";
		String pojoPropertyCode = "";
		String jsp = "";
		String title = "";
		String message = " ";
		String pojoName = "";
		String pojoPropertyName = "";
		String currentTime = "";

		Map<String, Object> map = new HashMap<String, Object>();
		MasAllotmentOfFundsForMinorWorks masAllotmentOfFundsForMinorWorks = new MasAllotmentOfFundsForMinorWorks();
		List masMinorWorkProposalList = new ArrayList();

		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		if (request.getParameter(FINANCIAL_YEAR) != null
				&& !(request.getParameter(FINANCIAL_YEAR).equals(""))) {
			financialYear = request.getParameter(FINANCIAL_YEAR);
		}
		if (request.getParameter(ALLOTMENT_FILE_NO) != null
				&& !(request.getParameter(ALLOTMENT_FILE_NO).equals(""))) {
			allotmentFileNo = request.getParameter(ALLOTMENT_FILE_NO);
		}
		if (request.getParameter(ALLOTMENT_FILE_DATE) != null
				&& !(request.getParameter(ALLOTMENT_FILE_DATE).equals(""))) {
			allotmentFileDate = (HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(ALLOTMENT_FILE_DATE)));
			//System.out.println("allotmentFileDate" + allotmentFileDate);
		}
		if (request.getParameter(ALLOTMENT_AMOUNT) != null
				&& !(request.getParameter(ALLOTMENT_AMOUNT).equals(""))) {
			allotmentAmount = (new BigDecimal(request
					.getParameter(ALLOTMENT_AMOUNT)));
		}
		if (request.getParameter(ALLOTMENT_REMARKS) != null
				&& !(request.getParameter(ALLOTMENT_REMARKS).equals(""))) {
			remarks = request.getParameter(ALLOTMENT_REMARKS);
			//System.out.println("remarks" + remarks);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
			//System.out.println("currentDate" + currentDate);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		generalMap.put("financialYear", financialYear);
		generalMap.put("allotmentFileNo", allotmentFileNo);

		generalMap.put("allotmentFileDate", allotmentFileDate);
		generalMap.put("allotmentAmount", allotmentAmount);
		generalMap.put("remarks", remarks);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		boolean successfullyAdded = false;

		masAllotmentOfFundsForMinorWorks.setFinancialYear(financialYear);
		masAllotmentOfFundsForMinorWorks.setAllotmentFileNo(allotmentFileNo);
		masAllotmentOfFundsForMinorWorks
				.setAllotmentFileDate(allotmentFileDate);
		masAllotmentOfFundsForMinorWorks
				.setAllotmentFileAmount(allotmentAmount);
		masAllotmentOfFundsForMinorWorks.setRemarks(remarks);
		masAllotmentOfFundsForMinorWorks.setStatus("y");
		masAllotmentOfFundsForMinorWorks.setLastChangedBy(changedBy);
		masAllotmentOfFundsForMinorWorks.setLastChangedDate(currentDate);
		masAllotmentOfFundsForMinorWorks.setLastChangedTime(currentTime);
		generalMap.put("code", allotmentFileNo);
		generalMap.put("pojoPropertyCode", "AllotmentFileNo");
		generalMap.put("pojoName", "MasAllotmentOfFundsForMinorWorks");
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		// masMinorWorkProposalList = (List)
		// listMap.get("duplicateGeneralCodeList");
		if (masMinorWorkProposalList == null
				|| masMinorWorkProposalList.size() == 0) {
			successfullyAdded = allotmentOfFundsForMinorWorkHandler
					.addAllotmentOfFunds(masAllotmentOfFundsForMinorWorks);
			generalMap.clear();
		} else {
			message = "File No already exist !! ";
		}

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message += "Try Again !!";
		}

		try {
			map = allotmentOfFundsForMinorWorkHandler.showAllotmentOfFundsJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ALLOTMENT_OF_FUNDS_FOR_MINOR_WORKS_JSP;
		title = "Work Category";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editAllotmentOfFundsToDatabase(
			HttpServletRequest request, HttpServletResponse response) {

		String financialYear = "";
		String allotmentFileNo = "";
		String allotmentFileDate = "";
		String allotmentAmount = "";
		String remarks = "";

		String jsp = "";
		String title = "";
		String message = " ";

		HttpSession session = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();

		String changedBy = "";

		Date changedDate = null;
		String changedTime = "";
		int Id = 0;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			Id = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(FINANCIAL_YEAR) != null
				&& !(request.getParameter(FINANCIAL_YEAR).equals(""))) {
			financialYear = request.getParameter(FINANCIAL_YEAR);
			//System.out.println("financialYear" + financialYear);
		}
		if (request.getParameter(ALLOTMENT_FILE_NO) != null
				&& !(request.getParameter(ALLOTMENT_FILE_NO).equals(""))) {
			allotmentFileNo = request.getParameter(ALLOTMENT_FILE_NO);
		}
		if (request.getParameter(ALLOTMENT_FILE_DATE) != null
				&& !(request.getParameter(ALLOTMENT_FILE_DATE).equals(""))) {
			allotmentFileDate = request.getParameter(ALLOTMENT_FILE_DATE);
		}
		if (request.getParameter(ALLOTMENT_AMOUNT) != null
				&& !(request.getParameter(ALLOTMENT_AMOUNT).equals(""))) {
			allotmentAmount = request.getParameter(ALLOTMENT_AMOUNT);
		}
		if (request.getParameter(ALLOTMENT_REMARKS) != null
				&& !(request.getParameter(ALLOTMENT_REMARKS).equals(""))) {
			remarks = request.getParameter(ALLOTMENT_REMARKS);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", Id);
		generalMap.put("financialYear", financialYear);
		generalMap.put("allotmentFileNo", allotmentFileNo);
		generalMap.put("allotmentFileDate", allotmentFileDate);
		generalMap.put("allotmentAmount", allotmentAmount);
		generalMap.put("remarks", remarks);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);

		generalMap.put("flag", true);

		boolean dataUpdated = false;
		dataUpdated = allotmentOfFundsForMinorWorkHandler
				.editAllotmentOfFundsToDatabase(generalMap);
		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant be updated !!";
		}

		try {
			map = allotmentOfFundsForMinorWorkHandler.showAllotmentOfFundsJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ALLOTMENT_OF_FUNDS_FOR_MINOR_WORKS_JSP;
		title = "Edit Department type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteAllotmentOfFundsToDatabase(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int Id = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		String jsp = "";
		String title = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			Id = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = allotmentOfFundsForMinorWorkHandler
				.deleteAllotmentOfFundsToDatabase(Id, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		try {
			map = allotmentOfFundsForMinorWorkHandler.showAllotmentOfFundsJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ALLOTMENT_OF_FUNDS_FOR_MINOR_WORKS_JSP;
		title = "Delete Work Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	public AllotmentOfFundsForMinorWorkHandler getAllotmentOfFundsForMinorWorkHandler() {
		return allotmentOfFundsForMinorWorkHandler;
	}

	public void setAllotmentOfFundsForMinorWorkHandler(
			AllotmentOfFundsForMinorWorkHandler allotmentOfFundsForMinorWorkHandler) {
		this.allotmentOfFundsForMinorWorkHandler = allotmentOfFundsForMinorWorkHandler;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}
