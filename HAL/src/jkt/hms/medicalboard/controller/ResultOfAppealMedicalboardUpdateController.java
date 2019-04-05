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
import static jkt.hms.util.RequestConstants.RESULT_OF_APPEAL_MEDICALBOARDS_UPDATE_ID;
import static jkt.hms.util.RequestConstants.RESULT_OF_APPEAL_MEDICALBOARDS_UPDATE_JSP;
import static jkt.hms.util.RequestConstants.RESULT_OF_APPEAL_MEDICALBOARD_DETAILS_SRNO;
import static jkt.hms.util.RequestConstants.RESULT_OF_APPEAL_MEDICALBOARD_SEARCH_JSP;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hms.masters.business.MbResultOfAppealMedicalboardMaster;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.medicalboard.handler.ResultOfAppealMedicalboardSearchHandlerService;
import jkt.hms.medicalboard.handler.ResultOfAppealMedicalboardUpdateHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ResultOfAppealMedicalboardUpdateController extends
		MultiActionController {

	private ResultOfAppealMedicalboardUpdateHandlerService resultOfAppealMedicalboardsUpdateHandlerService = null;
	private CommonMasterHandlerService commonMasterHandlerService = null;
	private int resultOfAppealMedicalboardId;
	ResultOfAppealMedicalboardSearchHandlerService resultOfAppealMedicalboardSearchHandlerService = null;

	@SuppressWarnings("unchecked")
	public ModelAndView showResultOfAppealMedicalboardUpdateJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		String title = "";
		setResultOfAppealMedicalboardId(Integer.parseInt(request
				.getParameter("resultOfAppealMedicalboardId")));
		int Id = getResultOfAppealMedicalboardId();
		Map map = new HashMap();
		map = resultOfAppealMedicalboardsUpdateHandlerService
				.showResultOfAppealMedicalboardUpdateJsp(Id);
		jsp = RESULT_OF_APPEAL_MEDICALBOARDS_UPDATE_JSP;
		jsp += ".jsp";
		title = "Result of appeal medical board";
		map.put("Id", Id);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView printMedicalBoard(HttpServletRequest request,
			HttpServletResponse response) {
		int Id = 1;
		Map<String, Object> parameters = new HashMap();
		Map<String, Object> connectionMap = resultOfAppealMedicalboardsUpdateHandlerService
				.getConnectionForReport();
		if (request.getParameter("Id") != null) {
			Id = Integer.parseInt(request.getParameter("Id"));

			//System.out.println("ID" + Id);
		}

		parameters.put("id", Id);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		try {

			HMSUtil.generateReport("resultOfAppealMedicalBoardEntry",
					parameters, (java.sql.Connection) connectionMap.get("con"),
					response, getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editResultOfAppealMedicalboardUpdate(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String entryNo = "";
		String entryDate = null;
		String batchNo = "";
		String chestNo = "";
		String name = "";
		String appealMedicalboardExamined = "";
		String optToReport = "";
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

		Map<String, Object> generalMap = new HashMap<String, Object>();
		List<ResultOfAppealMedicalboardUpdateDTO> mbUnfitExplanationList = new ArrayList<ResultOfAppealMedicalboardUpdateDTO>();

		// get the vector of values for each table input field. size of vector
		// will depend on the no of rows added
		Box box = HMSUtil.getBox(request);
		Vector v1 = box.getVector("unfitExp");
		Vector v2 = box.getVector(RESULT_OF_APPEAL_MEDICALBOARDS_UPDATE_ID);
		Vector v3 = box.getVector(RESULT_OF_APPEAL_MEDICALBOARD_DETAILS_SRNO);
		if (request.getParameter(ENTRY_NO) != null) {
			entryNo = request.getParameter(ENTRY_NO);

		}
		if (request.getParameter(ENTRY_DATE) != null) {
			entryDate = request.getParameter(ENTRY_DATE);
		}
		if (request.getParameter(BATCH_NO) != null) {
			batchNo = request.getParameter(BATCH_NO);
		}
		if (request.getParameter(CHEST_NO) != null) {
			chestNo = request.getParameter(CHEST_NO);
		}
		if (request.getParameter(NAME) != null) {
			name = request.getParameter(NAME);
		}
		if (request.getParameter(CHANGED_BY) != null) {
			lastChangedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null) {
			lastChangedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null) {
			lastChangedTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter(APPEAL_MEDICALBOARD_EXAMINED) != null) {
			appealMedicalboardExamined = request
					.getParameter(APPEAL_MEDICALBOARD_EXAMINED);
		}

		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		for (int i = 0; i < v1.size(); i++) {
			ResultOfAppealMedicalboardUpdateDTO resultOfAppealMedicalboardSearchDTO = new ResultOfAppealMedicalboardUpdateDTO();
			// setting the values in the POJO
			resultOfAppealMedicalboardSearchDTO.setUnfitExplanation((String) v1
					.get(i));
			resultOfAppealMedicalboardSearchDTO.setId(v2.get(i).toString());
			resultOfAppealMedicalboardSearchDTO.setSrNo(Integer
					.parseInt((String) v3.get(i)));
			resultOfAppealMedicalboardSearchDTO.setLastChangedBy(lastChangedBy);
			resultOfAppealMedicalboardSearchDTO
					.setLastChangeDate(lastChangedDate);
			resultOfAppealMedicalboardSearchDTO
					.setLastChangeTime(lastChangedTime);
			resultOfAppealMedicalboardSearchDTO.setStatus("y");
			// Adding POJO to list based on this list values will be updated in
			// the
			// data service
			mbUnfitExplanationList.add(resultOfAppealMedicalboardSearchDTO);
		}
		masResultOfAppealMedicalboard.setEntryNo(Integer.parseInt(entryNo));
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
		generalMap.put("id", getResultOfAppealMedicalboardId());
		List<MbResultOfAppealMedicalboardMaster> resultOfAppealMedicalboardList = new ArrayList<MbResultOfAppealMedicalboardMaster>();
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		if (listMap.get("duplicateGeneralCodeList") != null) {
			resultOfAppealMedicalboardList = (List) listMap
					.get("duplicateGeneralCodeList");
		}

		boolean successfullyUpdated = false;

		if ((resultOfAppealMedicalboardList.size() == 0 || resultOfAppealMedicalboardList == null)) {
			successfullyUpdated = resultOfAppealMedicalboardsUpdateHandlerService
					.editResultOfAppealMedicalboardUpdateToDatabase(generalMap);
			if (successfullyUpdated) {
				message = "Record Updated Successfully !!";
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

		if (successfullyUpdated) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Try Again !!";
		}

		try {
			map = resultOfAppealMedicalboardSearchHandlerService
					.showResultOfAppealMedicalboardSearchJsp();
		} catch (Exception e) {
		}
		jsp = RESULT_OF_APPEAL_MEDICALBOARD_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ---------------------------------------------------------------------------------------------
	public ResultOfAppealMedicalboardUpdateHandlerService getResultOfAppealMedicalboardUpdateHandlerService() {
		return resultOfAppealMedicalboardsUpdateHandlerService;
	}

	public void setResultOfAppealMedicalboardUpdateHandlerService(
			ResultOfAppealMedicalboardUpdateHandlerService resultOfAppealMedicalboardsUpdateHandlerService) {
		this.resultOfAppealMedicalboardsUpdateHandlerService = resultOfAppealMedicalboardsUpdateHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	public Integer getResultOfAppealMedicalboardId() {
		return resultOfAppealMedicalboardId;
	}

	public void setResultOfAppealMedicalboardId(
			Integer resultOfAppealMedicalboardId) {
		this.resultOfAppealMedicalboardId = resultOfAppealMedicalboardId;
	}

	public ResultOfAppealMedicalboardSearchHandlerService getResultOfAppealMedicalboardSearchHandlerService() {
		return resultOfAppealMedicalboardSearchHandlerService;
	}

	public void setResultOfAppealMedicalboardSearchHandlerService(
			ResultOfAppealMedicalboardSearchHandlerService resultOfAppealMedicalboardSearchHandlerService) {
		this.resultOfAppealMedicalboardSearchHandlerService = resultOfAppealMedicalboardSearchHandlerService;
	}

}
