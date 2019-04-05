package jkt.hms.medicalboard.controller;

import static jkt.hms.util.RequestConstants.APPEAL_MEDICALBOARD_EXAMINED;
import static jkt.hms.util.RequestConstants.BATCH_NO;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CHEST_NO;
import static jkt.hms.util.RequestConstants.ENTRY_DATE;
import static jkt.hms.util.RequestConstants.ENTRY_NO;
import static jkt.hms.util.RequestConstants.NAME;
import static jkt.hms.util.RequestConstants.RESULT_OF_APPEAL_MEDICALBOARD_DETAILS_SRNO;
import static jkt.hms.util.RequestConstants.RESULT_OF_APPEAL_MEDICALBOARD_JSP;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hms.masters.business.MbResultOfAppealMedicalboardMaster;
import jkt.hms.masters.business.MbResultOfAppealMedicalboardUnfitExpl;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.medicalboard.handler.ResultOfAppealMedicalboardHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ResultOfAppealMedicalboardController extends MultiActionController {
	private ResultOfAppealMedicalboardHandlerService resultOfAppealMedicalboardhandlerservice = null;
	private CommonMasterHandlerService commonMasterHandlerService = null;

	public ModelAndView showResultOfAppealMedicalboardJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String entryNo = "";
		String lastChangedBy = "";
		if (request.getParameter(CHANGED_BY) != null) {
			lastChangedBy = request.getParameter(CHANGED_BY);
		}
		map = resultOfAppealMedicalboardhandlerservice
				.showResultOfAppealMedicalboardJsp();
		entryNo = resultOfAppealMedicalboardhandlerservice
				.generateResultOfAppealMedicalboardNo(lastChangedBy);
		map.put("entryNo", entryNo);
		jsp = RESULT_OF_APPEAL_MEDICALBOARD_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addResultOfAppealMedicalboard(HttpServletRequest req,
			HttpServletResponse res) {
		Map<String, Object> map = new HashMap<String, Object>();
		String entryNo = "";
		String entryDate = null;
		String batchNo = "";
		String chestNo = "";
		String name = "";
		String appealMedicalboardExamined = "";
		String jsp = "";
		String title = "";
		String message = "";
		String lastChangedBy = "";
		String lastChangedTime = "";
		Date lastChangedDate = null;
		Map<String, Object> listMap = new HashMap<String, Object>();
		MbResultOfAppealMedicalboardMaster masResultOfAppealMedicalboard = new MbResultOfAppealMedicalboardMaster();
		// initializing box with the request to get the values from the inner
		// table
		Box box = HMSUtil.getBox(req);

		Map<String, Object> generalMap = new HashMap<String, Object>();
		List<MbResultOfAppealMedicalboardUnfitExpl> mbUnfitExplanationList = new ArrayList<MbResultOfAppealMedicalboardUnfitExpl>();

		// get the vector of values for each table input field. size of vector
		// will depend on the no of rows added

		Vector v1 = box.getVector("unfit");
		Vector v2 = box.getVector(RESULT_OF_APPEAL_MEDICALBOARD_DETAILS_SRNO);

		if (req.getParameter(ENTRY_NO) != null) {
			entryNo = req.getParameter(ENTRY_NO);

		}
		if (req.getParameter(ENTRY_DATE) != null) {
			entryDate = req.getParameter(ENTRY_DATE);
		}
		if (req.getParameter(BATCH_NO) != null) {
			batchNo = req.getParameter(BATCH_NO);
		}
		if (req.getParameter(CHEST_NO) != null) {
			chestNo = req.getParameter(CHEST_NO);
		}
		if (req.getParameter(NAME) != null) {
			name = req.getParameter(NAME);
		}
		if (req.getParameter(APPEAL_MEDICALBOARD_EXAMINED) != null) {
			appealMedicalboardExamined = req
					.getParameter(APPEAL_MEDICALBOARD_EXAMINED);
		}

		if (req.getParameter(CHANGED_BY) != null) {
			lastChangedBy = req.getParameter(CHANGED_BY);
		}
		if (req.getParameter(CHANGED_DATE) != null) {
			lastChangedDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(CHANGED_DATE));
		}
		if (req.getParameter(CHANGED_TIME) != null) {
			lastChangedTime = req.getParameter(CHANGED_TIME);
		}

		if (req.getParameter("title") != null) {
			title = req.getParameter("title");
		}
		for (int i = 0; i < v1.size(); i++) {
			MbResultOfAppealMedicalboardUnfitExpl mbResultOfAppealMedicalboardUnfitExpl = new MbResultOfAppealMedicalboardUnfitExpl();
			// setting the values in the POJO
			mbResultOfAppealMedicalboardUnfitExpl
					.setUnfitExplanation((String) v1.get(i));
			mbResultOfAppealMedicalboardUnfitExpl.setSrNo(Integer
					.parseInt((String) v2.get(i)));
			mbResultOfAppealMedicalboardUnfitExpl.setLastChgBy(lastChangedBy);
			mbResultOfAppealMedicalboardUnfitExpl
					.setLastChgDate(lastChangedDate);
			mbResultOfAppealMedicalboardUnfitExpl
					.setLastChgTime(lastChangedTime);
			mbResultOfAppealMedicalboardUnfitExpl.setStatus("y");
			// Adding POJO to list based on this list values will be updated in
			// the
			// data service
			mbUnfitExplanationList.add(mbResultOfAppealMedicalboardUnfitExpl);
		}
		if (entryNo.equalsIgnoreCase("")) {
			masResultOfAppealMedicalboard.setEntryNo(0);
		} else {
			masResultOfAppealMedicalboard.setEntryNo(Integer.parseInt(entryNo));
		}
		masResultOfAppealMedicalboard.setEntryDate(HMSUtil
				.convertStringTypeDateToDateType(entryDate));
		masResultOfAppealMedicalboard.setBatchNo(batchNo);
		masResultOfAppealMedicalboard.setChestNo(chestNo);
		masResultOfAppealMedicalboard.setName(name);
		masResultOfAppealMedicalboard
				.setAppealMedicalboardExamination(appealMedicalboardExamined);
		masResultOfAppealMedicalboard.setLastChgBy(lastChangedBy);
		masResultOfAppealMedicalboard.setLastChgDate(lastChangedDate);
		masResultOfAppealMedicalboard.setLastChgTime(lastChangedTime);
		masResultOfAppealMedicalboard.setStatus("y");
		generalMap.put("mbUnfitExplanationList", mbUnfitExplanationList);
		generalMap.put("masResultOfAppealMedicalboard",
				masResultOfAppealMedicalboard);
		List<MbResultOfAppealMedicalboardMaster> resultOfAppealMedicalboardList = new ArrayList<MbResultOfAppealMedicalboardMaster>();
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		if (listMap.get("duplicateGeneralCodeList") != null) {
			resultOfAppealMedicalboardList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		boolean successfullyAdded = false;

		if ((resultOfAppealMedicalboardList.size() == 0 || resultOfAppealMedicalboardList == null)) {
			successfullyAdded = resultOfAppealMedicalboardhandlerservice
					.addResultOfAppealMedicalboard(generalMap);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		}

		else if ((resultOfAppealMedicalboardList.size() != 0 || resultOfAppealMedicalboardList != null)) {

			if ((resultOfAppealMedicalboardList.size() != 0 || resultOfAppealMedicalboardList != null)) {

				message = "Record already exists.";
			} else if ((resultOfAppealMedicalboardList.size() == 0 || resultOfAppealMedicalboardList == null)) {

				message = "Record already exists.";
			} else if ((resultOfAppealMedicalboardList.size() != 0 || resultOfAppealMedicalboardList != null)) {

				message = "Record already exists.";
			}
		}

		if (successfullyAdded) {
			message = "Record Added Successfully!Do you want to print !!";
		} else {
			message = "Try Again !!";
		}

		try {
			map = resultOfAppealMedicalboardhandlerservice
					.showResultOfAppealMedicalboardJsp();
		} catch (Exception e) {
		}
		entryNo = resultOfAppealMedicalboardhandlerservice
				.generateResultOfAppealMedicalboardNo(lastChangedBy);
		map.put("entryNo", entryNo);
		jsp = RequestConstants.MEDICAL_BOARD_RESULT_MSG;
		title = "Result Of Appeal Medical Board Entry";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ResultOfAppealMedicalboardHandlerService getMinorworkdetailhandlerservice() {
		return resultOfAppealMedicalboardhandlerservice;
	}

	public void setResultOfAppealMedicalboardHandlerService(
			ResultOfAppealMedicalboardHandlerService resultOfAppealMedicalboardhandlerservice) {
		this.resultOfAppealMedicalboardhandlerservice = resultOfAppealMedicalboardhandlerservice;
	}

	/**
	 * @return the commonMasterHandlerService
	 */
	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	/**
	 * @param commonMasterHandlerService
	 *            the commonMasterHandlerService to set
	 */
	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}
