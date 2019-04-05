package jkt.hms.medicalboard.controller;

import static jkt.hms.util.RequestConstants.AGGRAVATED_SERVICE_DESC;
import static jkt.hms.util.RequestConstants.AGGRAVATED_SERVICE_STATUS;
import static jkt.hms.util.RequestConstants.BOARD_PRESIDENT;
import static jkt.hms.util.RequestConstants.CEASED_DUTY_ON;
import static jkt.hms.util.RequestConstants.CLINICAL_SUMMARY;
import static jkt.hms.util.RequestConstants.DATE_OF_COMMISSIONING;
import static jkt.hms.util.RequestConstants.DATE_OF_ORIGIN;
import static jkt.hms.util.RequestConstants.DATE_OF_RECATEGORIZATION;
import static jkt.hms.util.RequestConstants.DISABILITY_ATTRIBUTABLE_DESC;
import static jkt.hms.util.RequestConstants.DISABILITY_ATTRIBUTABLE_STATUS;
import static jkt.hms.util.RequestConstants.DISTRICT;
import static jkt.hms.util.RequestConstants.HEIGHT;
import static jkt.hms.util.RequestConstants.INSTRUCTION_BY_PRESIDENT;
import static jkt.hms.util.RequestConstants.LOCAL_ADDRESS;
import static jkt.hms.util.RequestConstants.MEDICAL_BOARD_DETAILS_ID;
import static jkt.hms.util.RequestConstants.MEDICAL_BOARD_DETAILS_SRNO;
import static jkt.hms.util.RequestConstants.MEDICAL_BOARD_DISABILITIES;
import static jkt.hms.util.RequestConstants.MEDICAL_BOARD_PROCEEDINGS_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.MEDICAL_BOARD_PROCEEDINGS_UPDATE_JSP;
import static jkt.hms.util.RequestConstants.MEDICAL_CATEGORY_DURATION;
import static jkt.hms.util.RequestConstants.MEDICAL_CATEGORY_NAME;
import static jkt.hms.util.RequestConstants.MEDICAL_TYPE;
import static jkt.hms.util.RequestConstants.MEMBER_1_NAME;
import static jkt.hms.util.RequestConstants.MEMBER_2_NAME;
import static jkt.hms.util.RequestConstants.NEXT_MEDICAL_CATEGORISATION_DUE;
import static jkt.hms.util.RequestConstants.PAST_MEDICAL_HISTORY;
import static jkt.hms.util.RequestConstants.PLACE_OF_ORIGIN;
import static jkt.hms.util.RequestConstants.PLACE_OF_RECATEGORIZATION;
import static jkt.hms.util.RequestConstants.PRESENT_DISABLEMENT;
import static jkt.hms.util.RequestConstants.PREVIOUS_DISABLEMENT;
import static jkt.hms.util.RequestConstants.PREVIOUS_MEDICAL_CATEGORISATION;
import static jkt.hms.util.RequestConstants.PREVIOUS_MEDICAL_CATEGORISATION_DATE;
import static jkt.hms.util.RequestConstants.REASON_FOR_VARIATION;
import static jkt.hms.util.RequestConstants.RECORD_ADDRESS;
import static jkt.hms.util.RequestConstants.RESTRICTION_REGARDING_EMPLOYEMENT;
import static jkt.hms.util.RequestConstants.STATE;
import static jkt.hms.util.RequestConstants.WEIGHT;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hms.masters.business.MasMedicalBoardDetails;
import jkt.hms.medicalboard.handler.MedicalBoardProceedingUpdateHandlerService;
import jkt.hms.medicalboard.handler.MedicalBoardProceedingUpdateSearchHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MedicalBoardProceedingUpdateController extends
		MultiActionController {
	MedicalBoardProceedingUpdateHandlerService medicalBoardProceedingUpdateHandlerService = null;
	MedicalBoardProceedingUpdateSearchHandlerService medicalBoardProceedingUpdateSearchHandlerService = null;

	@SuppressWarnings("unchecked")
	public ModelAndView printMedicalBoard(HttpServletRequest request,
			HttpServletResponse response) {
		int Id = 1;
		Map<String, Object> parameters = new HashMap();
		Map<String, Object> connectionMap = medicalBoardProceedingUpdateHandlerService
				.getConnectionForReport();
		if (request.getParameter("Id") != null) {
			Id = Integer.parseInt(request.getParameter("Id"));

		}
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		parameters.put("Id", Id);

		try {

			HMSUtil.generateReport("medical_Board", parameters,
					(java.sql.Connection) connectionMap.get("con"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	private int medicalBoardProceedingsId;

	@SuppressWarnings( { "unchecked", "unchecked" })
	public ModelAndView showMedicalBoardUpdateJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "";
		Map map = new HashMap();
		String sampleCollectionDetailId = request
				.getParameter("sampleCollectionDetailId");

		int Id = Integer.parseInt(sampleCollectionDetailId);

		map = medicalBoardProceedingUpdateHandlerService
				.showMedicalBoardUpdateJsp(Id);
		setMedicalBoardProceedingsId(Integer.parseInt(request
				.getParameter("sampleCollectionDetailId")));
		jsp = MEDICAL_BOARD_PROCEEDINGS_UPDATE_JSP;

		jsp += ".jsp";
		// title = "complaint";
		map.put("contentJsp", jsp);
		// map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView medicalBoardUpdateToDatabase(
			HttpServletRequest request, HttpServletResponse response) {
		{
			Box box = HMSUtil.getBox(request);
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			String type = "";
			Date dateOfComminishning = new Date();
			String recordOfficeWithAddress = "";
			String pastMedicalHistory = "";
			String priorToPresentMedicalBoard = "";
			int boardPresident = 0;
			int member1Name = 0;
			int member2Name = 0;
			String weight = "";
			String height = "";
			String clinicalSummary = "";
			String disabilityAttributableStatus = "";
			String disabilityAttributableDesc = "";
			String disabilityAgrawatedStatus = "";
			String disabilityAgrawatedDesc = "";
			String medicalCategoryName = "";
			String medicalCategoryDuration = "";
			Date dateOfRectegorization = new Date();
			String placeOfRectegorization = "";
			String previousDisamblent = "0";
			String presentDisamblent = "0";
			String reasonForVariation = "";
			String restrictionRegardingEmployeement = "";
			String introductionByPresident = "";
			String message = "";
			String jsp = "";
			String title = "";
			int state = 0;
			int district = 0;
			String addressOnLeave = "";
			String medicalCategoryNameWithDuration = "";
			Date ceasedDutyOn = null;
			int Id = 0;

			List<MedicalBoardProceedingsDTO> mbUnfitExplanationList = new ArrayList<MedicalBoardProceedingsDTO>();
			List<MasMedicalBoardDetails> masMedicalBoardDetails = new ArrayList<MasMedicalBoardDetails>();
			Vector<String> v1 = box.getVector(MEDICAL_BOARD_DETAILS_ID);
			Vector<String> v2 = box.getVector(MEDICAL_BOARD_DISABILITIES);
			Vector<String> v3 = box.getVector(DATE_OF_ORIGIN);
			Vector<String> v4 = box.getVector(PREVIOUS_MEDICAL_CATEGORISATION);
			Vector<String> v5 = box
					.getVector(PREVIOUS_MEDICAL_CATEGORISATION_DATE);
			Vector<String> v6 = box.getVector(NEXT_MEDICAL_CATEGORISATION_DUE);
			Vector<String> v7 = box.getVector(PLACE_OF_ORIGIN);
			Vector<String> v8 = box.getVector(MEDICAL_BOARD_DETAILS_SRNO);

			for (int i = 0; i < v1.size(); i++) {
				MedicalBoardProceedingsDTO medicalBoardProceedingsDTO = new MedicalBoardProceedingsDTO();
				medicalBoardProceedingsDTO.setId(v1.get(i));
				medicalBoardProceedingsDTO.setDisability(v2.get(i));
				medicalBoardProceedingsDTO.setDateOfOrigin((v3.get(i)));

				medicalBoardProceedingsDTO.setPreviousMedicalCategorization(v4
						.get(i));
				medicalBoardProceedingsDTO
						.setPreviousMedicalCategorizationDate((v5.get(i)));
				medicalBoardProceedingsDTO.setNextMedicalCategorizationDate(v6
						.get(i));
				medicalBoardProceedingsDTO.setPlaceOfOrigin(v7.get(i));
				medicalBoardProceedingsDTO.setSrNo(v8.get(i));
				mbUnfitExplanationList.add(medicalBoardProceedingsDTO);

			}

			if (request.getParameter("Id") != null
					&& !(request.getParameter("Id").equals(""))) {
				Id = Integer.parseInt(request.getParameter("Id"));
				generalMap.put("Id", Id);
			}
			if (request.getParameter(MEDICAL_TYPE) != null
					&& !(request.getParameter(MEDICAL_TYPE).equals(""))) {
				type = request.getParameter(MEDICAL_TYPE);
				generalMap.put("type", type);

			}
			if (request.getParameter(DATE_OF_COMMISSIONING) != null
					&& !(request.getParameter(DATE_OF_COMMISSIONING).equals(""))) {
				dateOfComminishning = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(DATE_OF_COMMISSIONING));
				generalMap.put("dateOfComminishning", dateOfComminishning);
			}
			if (request.getParameter(RECORD_ADDRESS) != null
					&& !(request.getParameter(RECORD_ADDRESS).equals(""))) {
				recordOfficeWithAddress = request.getParameter(RECORD_ADDRESS);
				generalMap.put("recordOfficeWithAddress",
						recordOfficeWithAddress);
			}
			if (request.getParameter(LOCAL_ADDRESS) != null) {
				addressOnLeave = request.getParameter(LOCAL_ADDRESS);
				generalMap.put("addressOnLeave", addressOnLeave);
			}
			if (request.getParameter(DISTRICT) != null) {
				district = Integer.parseInt(request.getParameter(DISTRICT));
				generalMap.put("district", district);
			}
			if (request.getParameter(STATE) != null) {
				state = Integer.parseInt(request.getParameter(STATE));
				generalMap.put("state", state);
			}
			if (request
					.getParameter(RequestConstants.MEDICAL_CATEGORY_NAME_RECOMMENED_WITH_DURATION) != null) {
				medicalCategoryNameWithDuration = request
						.getParameter(RequestConstants.MEDICAL_CATEGORY_NAME_RECOMMENED_WITH_DURATION);
				generalMap.put("medicalCategoryNameWithDuration",
						medicalCategoryNameWithDuration);
			}
			if (request.getParameter(CEASED_DUTY_ON) != null
					&& !request.getParameter(CEASED_DUTY_ON).equalsIgnoreCase(
							"")) {
				ceasedDutyOn = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(CEASED_DUTY_ON));
				generalMap.put("ceasedDutyOn", ceasedDutyOn);
			}
			if (request.getParameter(PAST_MEDICAL_HISTORY) != null
					&& !(request.getParameter(PAST_MEDICAL_HISTORY).equals(""))) {
				pastMedicalHistory = request.getParameter(PAST_MEDICAL_HISTORY);
				generalMap.put("pastMedicalHistory", pastMedicalHistory);
			}

			if (request.getParameter(MEDICAL_CATEGORY_NAME) != null
					&& !(request.getParameter(MEDICAL_CATEGORY_NAME).equals(""))) {
				priorToPresentMedicalBoard = request
						.getParameter(MEDICAL_CATEGORY_NAME);
				generalMap.put("priorToPresentMedicalBoard",
						priorToPresentMedicalBoard);
			}
			if (request.getParameter(BOARD_PRESIDENT) != null
					&& !(request.getParameter(BOARD_PRESIDENT).equals(""))) {
				boardPresident = Integer.parseInt(request
						.getParameter(BOARD_PRESIDENT));
				generalMap.put("boardPresident", boardPresident);
			}
			if (request.getParameter(MEMBER_1_NAME) != null
					&& !(request.getParameter(MEMBER_1_NAME).equals(""))) {
				member1Name = Integer.parseInt(request
						.getParameter(MEMBER_1_NAME));
				generalMap.put("member1Name", member1Name);
			}
			if (request.getParameter(MEMBER_2_NAME) != null
					&& !(request.getParameter(MEMBER_2_NAME).equals(""))) {
				member2Name = Integer.parseInt(request
						.getParameter(MEMBER_2_NAME));
				generalMap.put("member2Name", member2Name);
			}
			if (request.getParameter(WEIGHT) != null
					&& !(request.getParameter(WEIGHT).equals(""))) {
				weight = request.getParameter(WEIGHT);
				generalMap.put("weight", weight);

			}
			if (request.getParameter(HEIGHT) != null
					&& !(request.getParameter(HEIGHT).equals(""))) {
				height = request.getParameter(HEIGHT);
				generalMap.put("height", height);
			}

			if (request.getParameter(CLINICAL_SUMMARY) != null
					&& !(request.getParameter(CLINICAL_SUMMARY).equals(""))) {
				clinicalSummary = request.getParameter(CLINICAL_SUMMARY);
				generalMap.put("clinicalSummary", clinicalSummary);

			}

			if (request.getParameter(DISABILITY_ATTRIBUTABLE_STATUS) != null
					&& !(request.getParameter(DISABILITY_ATTRIBUTABLE_STATUS)
							.equals(""))) {
				disabilityAttributableStatus = request
						.getParameter(DISABILITY_ATTRIBUTABLE_STATUS);
				generalMap.put("disabilityAttributableStatus",
						disabilityAttributableStatus);

			}
			if (request.getParameter(DISABILITY_ATTRIBUTABLE_DESC) != null
					&& !(request.getParameter(DISABILITY_ATTRIBUTABLE_DESC)
							.equals(""))) {
				disabilityAttributableDesc = request
						.getParameter(DISABILITY_ATTRIBUTABLE_DESC);
				generalMap.put("disabilityAttributableDesc",
						disabilityAttributableDesc);
			}
			if (request.getParameter(AGGRAVATED_SERVICE_STATUS) != null
					&& !(request.getParameter(AGGRAVATED_SERVICE_STATUS)
							.equals(""))) {
				disabilityAgrawatedStatus = request
						.getParameter(AGGRAVATED_SERVICE_STATUS);
				generalMap.put("disabilityAgrawatedStatus",
						disabilityAgrawatedStatus);

			}
			if (request.getParameter(AGGRAVATED_SERVICE_DESC) != null
					&& !(request.getParameter(AGGRAVATED_SERVICE_DESC)
							.equals(""))) {
				disabilityAgrawatedDesc = request
						.getParameter(AGGRAVATED_SERVICE_DESC);
				generalMap.put("disabilityAgrawatedDesc",
						disabilityAgrawatedDesc);
			}

			if (request.getParameter(MEDICAL_CATEGORY_NAME) != null
					&& !(request.getParameter(MEDICAL_CATEGORY_NAME).equals(""))) {
				medicalCategoryName = request
						.getParameter(MEDICAL_CATEGORY_NAME);
				generalMap.put("medicalCategoryName", medicalCategoryName);
			}

			if (request.getParameter(MEDICAL_CATEGORY_DURATION) != null
					&& !(request.getParameter(MEDICAL_CATEGORY_NAME).equals(""))) {
				medicalCategoryDuration = request
						.getParameter(MEDICAL_CATEGORY_DURATION);
				generalMap.put("medicalCategoryDuration",
						medicalCategoryDuration);

			}
			if (request.getParameter(DATE_OF_RECATEGORIZATION) != null
					&& !(request.getParameter(DATE_OF_RECATEGORIZATION)
							.equals(""))) {
				dateOfRectegorization = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(DATE_OF_RECATEGORIZATION));
				generalMap.put("dateOfRectegorization", dateOfRectegorization);
			}

			if (request.getParameter(PLACE_OF_RECATEGORIZATION) != null
					&& !(request.getParameter(PLACE_OF_RECATEGORIZATION)
							.equals(""))) {
				placeOfRectegorization = request
						.getParameter(PLACE_OF_RECATEGORIZATION);
				generalMap
						.put("placeOfRectegorization", placeOfRectegorization);
			}

			if (request.getParameter(PREVIOUS_DISABLEMENT) != null
					&& !(request.getParameter(PREVIOUS_DISABLEMENT).equals(""))) {
				previousDisamblent = request.getParameter(PREVIOUS_DISABLEMENT);
				generalMap.put("previousDisamblent", previousDisamblent);

			}
			if (request.getParameter(PRESENT_DISABLEMENT) != null
					&& !(request.getParameter(PRESENT_DISABLEMENT).equals(""))) {
				presentDisamblent = request.getParameter(PRESENT_DISABLEMENT);
				generalMap.put("presentDisamblent", presentDisamblent);

			}
			if (request.getParameter(REASON_FOR_VARIATION) != null
					&& !(request.getParameter(REASON_FOR_VARIATION).equals(""))) {
				reasonForVariation = request.getParameter(REASON_FOR_VARIATION);
				generalMap.put("reasonForVariation", reasonForVariation);
			}

			if (request.getParameter(RESTRICTION_REGARDING_EMPLOYEMENT) != null
					&& !(request
							.getParameter(RESTRICTION_REGARDING_EMPLOYEMENT)
							.equals(""))) {
				restrictionRegardingEmployeement = request
						.getParameter(RESTRICTION_REGARDING_EMPLOYEMENT);
				generalMap.put("restrictionRegardingEmployeement",
						restrictionRegardingEmployeement);
			}
			generalMap.put("detailList", masMedicalBoardDetails);
			generalMap.put("id", getMedicalBoardProceedingsId());
			generalMap.put("mbUnfitExplanationList", mbUnfitExplanationList);
			if (request.getParameter(INSTRUCTION_BY_PRESIDENT) != null
					&& !(request.getParameter(INSTRUCTION_BY_PRESIDENT)
							.equals(""))) {
				introductionByPresident = request
						.getParameter(INSTRUCTION_BY_PRESIDENT);
				generalMap.put("introductionByPresident",
						introductionByPresident);
			}

			generalMap.put("flag", true);

			boolean dataUpdated = false;
			dataUpdated = medicalBoardProceedingUpdateHandlerService
					.medicalBoardUpdateToDatabase(generalMap);
			if (dataUpdated == true) {
				message = "Record Updated Successfully !!";

			} else {
				message = "Record Cant Be Updated !!";

			}

			try {
				map = medicalBoardProceedingUpdateSearchHandlerService
						.showMedicalBoardSearchJsp();
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = MEDICAL_BOARD_PROCEEDINGS_SEARCH_JSP;
			title = "update Medical Board Processing";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("indexB", "map", map);

		}
	}

	public Integer getMedicalBoardProceedingsId() {
		return medicalBoardProceedingsId;
	}

	public void setMedicalBoardProceedingsId(
			Integer ctionTinstructionToCandidateIdoCandidateId) {
		this.medicalBoardProceedingsId = ctionTinstructionToCandidateIdoCandidateId;
	}

	public MedicalBoardProceedingUpdateHandlerService getMedicalBoardProceedingUpdateHandlerService() {
		return medicalBoardProceedingUpdateHandlerService;
	}

	public void setMedicalBoardProceedingUpdateHandlerService(
			MedicalBoardProceedingUpdateHandlerService medicalBoardProceedingUpdateHandlerService) {
		this.medicalBoardProceedingUpdateHandlerService = medicalBoardProceedingUpdateHandlerService;
	}

	/**
	 * @return the medicalBoardProceedingUpdateSearchHandlerService
	 */
	public MedicalBoardProceedingUpdateSearchHandlerService getMedicalBoardProceedingUpdateSearchHandlerService() {
		return medicalBoardProceedingUpdateSearchHandlerService;
	}

	/**
	 * @param medicalBoardProceedingUpdateSearchHandlerService
	 *            the medicalBoardProceedingUpdateSearchHandlerService to set
	 */
	public void setMedicalBoardProceedingUpdateSearchHandlerService(
			MedicalBoardProceedingUpdateSearchHandlerService medicalBoardProceedingUpdateSearchHandlerService) {
		this.medicalBoardProceedingUpdateSearchHandlerService = medicalBoardProceedingUpdateSearchHandlerService;
	}

}
