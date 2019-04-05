package jkt.hms.medicalboard.controller;

import static jkt.hms.util.RequestConstants.AD_NO;
import static jkt.hms.util.RequestConstants.AGE;
import static jkt.hms.util.RequestConstants.AGGRAVATED_SERVICE_DESC;
import static jkt.hms.util.RequestConstants.AGGRAVATED_SERVICE_STATUS;
import static jkt.hms.util.RequestConstants.BOARD_PRESIDENT;
import static jkt.hms.util.RequestConstants.CEASED_DUTY_ON;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CLINICAL_SUMMARY;
import static jkt.hms.util.RequestConstants.DATE_OF_COMMISSIONING;
import static jkt.hms.util.RequestConstants.DATE_OF_ORIGIN;
import static jkt.hms.util.RequestConstants.DATE_OF_RECATEGORIZATION;
import static jkt.hms.util.RequestConstants.DISABILITY_ATTRIBUTABLE_DESC;
import static jkt.hms.util.RequestConstants.DISABILITY_ATTRIBUTABLE_STATUS;
import static jkt.hms.util.RequestConstants.DISTRICT;
import static jkt.hms.util.RequestConstants.ENTRY_DATE;
import static jkt.hms.util.RequestConstants.ENTRY_NO;
import static jkt.hms.util.RequestConstants.HEIGHT;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.INSTRUCTION_BY_PRESIDENT;
import static jkt.hms.util.RequestConstants.LOCAL_ADDRESS;
import static jkt.hms.util.RequestConstants.MEDICAL_BOARD_DETAILS_ID;
import static jkt.hms.util.RequestConstants.MEDICAL_BOARD_DETAILS_SRNO;
import static jkt.hms.util.RequestConstants.MEDICAL_BOARD_DISABILITIES;
import static jkt.hms.util.RequestConstants.MEDICAL_BOARD_ERROR_MSG;
import static jkt.hms.util.RequestConstants.MEDICAL_BOARD_PROCEEDING_JSP;
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
import static jkt.hms.util.RequestConstants.P_FIRST_NAME;
import static jkt.hms.util.RequestConstants.P_LAST_NAME;
import static jkt.hms.util.RequestConstants.RANK_NAME;
import static jkt.hms.util.RequestConstants.REASON_FOR_VARIATION;
import static jkt.hms.util.RequestConstants.RECORD_ADDRESS;
import static jkt.hms.util.RequestConstants.RESTRICTION_REGARDING_EMPLOYEMENT;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.SERVICE_TYPE_NAME;
import static jkt.hms.util.RequestConstants.SEX;
import static jkt.hms.util.RequestConstants.STATE;
import static jkt.hms.util.RequestConstants.TRADE_NAME;
import static jkt.hms.util.RequestConstants.UNIT_NAME;
import static jkt.hms.util.RequestConstants.WEIGHT;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasMedicalBoardDetails;
import jkt.hms.masters.business.MasMedicalBoardProceedings;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.medicalboard.handler.MedicalBoardProceedingHandlerService;
import jkt.hms.medicalboard.handler.MedicalBoardProceedingSearchHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MedicalBoardProceedingController extends MultiActionController {
	private MedicalBoardProceedingHandlerService medicalBoardProceedingHandlerService = null;
	private CommonMasterHandlerService commonMasterHandlerService = null;
	private MedicalBoardProceedingSearchHandlerService medicalBoardProceedingSearchHandlerService = null;
	private int medicalBoardProceedingId;

	@SuppressWarnings("unchecked")
	public ModelAndView showMedicalBoardProceedingJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		String title = "";
		String userName = "";
		String medicalEntryNo = "";
		medicalEntryNo = medicalBoardProceedingHandlerService
				.generateMedicalEntryNumber(userName);
		if (request.getParameter("medicalBoardProceedingId") != null)
			setMedicalBoardProceedingId(Integer.parseInt(request
					.getParameter("medicalBoardProceedingId")));
		int Id = getMedicalBoardProceedingId();
		Map map = new HashMap();
		map = medicalBoardProceedingHandlerService
				.showMedicalBoardProceedingJsp(Id);
		jsp = MEDICAL_BOARD_PROCEEDING_JSP;
		jsp += ".jsp";
		title = "Medical Board Proceeding";
		map.put("contentJsp", jsp);
		map.put("medicalEntryNo", medicalEntryNo);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showMedicalBoardProceedingFroEmployeeJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		String title = "";
		String userName = "";
		String medicalEntryNo = "";
		medicalEntryNo = medicalBoardProceedingHandlerService
				.generateMedicalEntryNumber(userName);
		if (request.getParameter("medicalBoardProceedingId") != null)
			setMedicalBoardProceedingId(Integer.parseInt(request
					.getParameter("medicalBoardProceedingId")));
		int Id = getMedicalBoardProceedingId();
		Map map = new HashMap();
		map = medicalBoardProceedingHandlerService
				.showMedicalBoardProceedingForEmployeeJsp(Id);
		jsp = RequestConstants.MEDICAL_BOARD_PROCEEDING_FOR_EMPLOYEE_JSP;
		jsp += ".jsp";
		title = "Medical Board Proceeding";
		map.put("contentJsp", jsp);
		map.put("medicalEntryNo", medicalEntryNo);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addMedicalBoardProceeding(HttpServletRequest req,
			HttpServletResponse res) {
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String medicalType = "";
		Date dateOfCommissioning = null;
		String address = "";
		String pastMedicalHistory = "";
		String medicalCategoryName = "";
		String jspName = "";
		int boardPresident = 0;
		int member1Name = 0;
		int member2Name = 0;
		String medicalCategoryDuration = "";
		Date dateOfRecategorization = null;
		String placeOfRecategorization = "";
		int previousDisablement = 0;
		int presentDisablement = 0;
		String reasonForVariation = "";
		String restrictionRegardingEmployment = "";
		String instructionByPresident = "";
		String disabilityAttributableStatus = "";
		String disabilityAttributableDesc = "";
		String aggravatedServiceStatus = "";
		String aggravatedServiceDesc = "";
		int hinId = 0;
		String clinicalSummary = "";
		String medicalEntryNo = "";
		String weight = "";
		String height = "";
		Date entryDate = null;
		String jsp = "";
		String title = "";
		String message = "";
		String url = "";
		String viewPage = "";
		String pojoName = "";
		String pojoPropertyName = "";
		String currentTime = "";
		String lastChgBy = "";
		String lastChgTime = "";
		Date lastChgDate = null;
		Date currentDate = null;
		Date ceasedDutyOn = null;
		String status = "";
		String changeBy = "";
		String medicalBoardDisabilities = "";
		Date dateOfOrigin = null;
		String placeOfOrigin = "";
		String previousMedicalCategorisation = "";
		Date previousMedicalCategorisationDate = null;
		Date nextMedicalCategorisationDue = null;
		String rankName = "";
		String unitName = "";
		String tradeName = "";
		String pFirstName = "";
		String pLastName = "";
		String serviceNo = "";
		String serviceType = "";
		String hinNo = "";
		String adnNo = "";
		String sex = "";
		String age = "";
		String addressOnLeave = "";
		String pluse="";
		String bp ="";
		String localExam="";
		String ecg = "";
		String xRay = "";
		int district = 0;
		int state = 0;
		int sick_week = 0 ; 
		Date sick_date = null ; 
		HttpSession session = null;
		Box box = HMSUtil.getBox(req);
		MasMedicalBoardProceedings masMedicalBoardProceedings = new MasMedicalBoardProceedings();

		List<MasMedicalBoardDetails> masMedicalBoardDetails = new ArrayList<MasMedicalBoardDetails>();
		String medicalCategoryNameWithDuration = "";
		Vector<String> v1 = box.getVector(MEDICAL_BOARD_DETAILS_ID);
		Vector<String> v2 = box.getVector(MEDICAL_BOARD_DISABILITIES);
		Vector<String> v3 = box.getVector(DATE_OF_ORIGIN);
		Vector<String> v4 = box.getVector(PREVIOUS_MEDICAL_CATEGORISATION);
		Vector<String> v5 = box.getVector(PREVIOUS_MEDICAL_CATEGORISATION_DATE);
		Vector<String> v6 = box.getVector(NEXT_MEDICAL_CATEGORISATION_DUE);
		Vector<String> v7 = box.getVector(PLACE_OF_ORIGIN);
		Vector<String> v8 = box.getVector(MEDICAL_BOARD_DETAILS_SRNO);
		for (int i = 0; i < v2.size(); i++) {
			MasMedicalBoardDetails masMedicalBoardDetail = new MasMedicalBoardDetails();
			masMedicalBoardDetail.setDisabilities(v2.get(i));
			masMedicalBoardDetail.setDateOfOrigin(HMSUtil
					.convertStringTypeDateToDateType(v3.get(i)));
			masMedicalBoardDetail.setPreviousMedicalCategorisatrion(v4.get(i));
			masMedicalBoardDetail.setPreviousMedicalCategorisationDate(HMSUtil
					.convertStringTypeDateToDateType(v5.get(i)));
			masMedicalBoardDetail.setNextMedicalCategorisationDue(HMSUtil
					.convertStringTypeDateToDateType(v6.get(i)));
			masMedicalBoardDetail.setPlaceOfOrigin(v7.get(i));
			masMedicalBoardDetail.setSrNo(Integer.parseInt(v8.get(i)));
			masMedicalBoardDetails.add(masMedicalBoardDetail);
		}

		if (req.getParameter(MEDICAL_TYPE) != null) {
			medicalType = req.getParameter(MEDICAL_TYPE);
		}
		if (req.getParameter(DATE_OF_COMMISSIONING) != null) {
			dateOfCommissioning = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DATE_OF_COMMISSIONING));
		}
		if (req.getParameter(RECORD_ADDRESS) != null) {
			address = req.getParameter(RECORD_ADDRESS);
		}
		if (req.getParameter(PAST_MEDICAL_HISTORY) != null) {
			pastMedicalHistory = req.getParameter(PAST_MEDICAL_HISTORY);
		}
		if (req.getParameter(LOCAL_ADDRESS) != null) {
			addressOnLeave = req.getParameter(LOCAL_ADDRESS);
		}
		//System.out.println("addressOnLeave::" + addressOnLeave + "::address::"+ address);
		if (req.getParameter(DISTRICT) != null) {
			district = Integer.parseInt(req.getParameter(DISTRICT));
		}
		if (req.getParameter(STATE) != null) {
			state = Integer.parseInt(req.getParameter(STATE));
		}
		if (req.getParameter(MEDICAL_CATEGORY_NAME) != null) {
			medicalCategoryName = req.getParameter(MEDICAL_CATEGORY_NAME);
		}

		if (req.getParameter(RequestConstants.MEDICAL_CATEGORY_NAME_RECOMMENED_WITH_DURATION) != null) {
			medicalCategoryNameWithDuration = req.getParameter(RequestConstants.MEDICAL_CATEGORY_NAME_RECOMMENED_WITH_DURATION);
		}
		if (req.getParameter(BOARD_PRESIDENT) != null
				&& !req.getParameter(BOARD_PRESIDENT).equals("")) {
			boardPresident = Integer
					.parseInt(req.getParameter(BOARD_PRESIDENT));
		}

		if (req.getParameter(MEMBER_1_NAME) != null
				&& !req.getParameter(MEMBER_1_NAME).equals("")) {
			member1Name = Integer.parseInt(req.getParameter(MEMBER_1_NAME));
		}
		if (req.getParameter(MEMBER_2_NAME) != null
				&& !req.getParameter(MEMBER_2_NAME).equals("")) {
			member2Name = Integer.parseInt(req.getParameter(MEMBER_2_NAME));
		}

		if (req.getParameter(CLINICAL_SUMMARY) != null) {
			clinicalSummary = req.getParameter(CLINICAL_SUMMARY);
		}

		if (req.getParameter(DISABILITY_ATTRIBUTABLE_STATUS) != null) {
			disabilityAttributableStatus = req
					.getParameter(DISABILITY_ATTRIBUTABLE_STATUS);
		}

		if (req.getParameter(DISABILITY_ATTRIBUTABLE_DESC) != null) {
			disabilityAttributableDesc = req
					.getParameter(DISABILITY_ATTRIBUTABLE_DESC);
		}

		if (req.getParameter(AGGRAVATED_SERVICE_STATUS) != null) {
			aggravatedServiceStatus = req
					.getParameter(AGGRAVATED_SERVICE_STATUS);
		}

		if (req.getParameter(AGGRAVATED_SERVICE_DESC) != null) {
			aggravatedServiceDesc = req.getParameter(AGGRAVATED_SERVICE_DESC);
		}

		if (req.getParameter(MEDICAL_CATEGORY_DURATION) != null) {
			medicalCategoryDuration = req
					.getParameter(MEDICAL_CATEGORY_DURATION);
		}
		if (req.getParameter(DATE_OF_RECATEGORIZATION) != null
				&& !req.getParameter(DATE_OF_RECATEGORIZATION)
						.equalsIgnoreCase("")) {
			dateOfRecategorization = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DATE_OF_RECATEGORIZATION));
		}
		if (req.getParameter(PLACE_OF_RECATEGORIZATION) != null) {
			placeOfRecategorization = req
					.getParameter(PLACE_OF_RECATEGORIZATION);
		}

		if (req.getParameter(PREVIOUS_DISABLEMENT) != null
				&& !req.getParameter(PREVIOUS_DISABLEMENT).equals("")) {
			previousDisablement = Integer.parseInt(req
					.getParameter(PREVIOUS_DISABLEMENT));
		}

		if (req.getParameter(PRESENT_DISABLEMENT) != null
				&& !req.getParameter(PRESENT_DISABLEMENT).equals("")) {
			presentDisablement = Integer.parseInt(req
					.getParameter(PRESENT_DISABLEMENT));
		}

		if (req.getParameter(REASON_FOR_VARIATION) != null) {
			reasonForVariation = req.getParameter(REASON_FOR_VARIATION);
		}

		if (req.getParameter(WEIGHT) != null) {
			weight = req.getParameter(WEIGHT);
		}

		if (req.getParameter(HEIGHT) != null) {
			height = req.getParameter(HEIGHT);
		}
		if (req.getParameter(ENTRY_DATE) != null) {
			entryDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(ENTRY_DATE));
		}

		if (req.getParameter(P_FIRST_NAME) != null) {
			pFirstName = req.getParameter(P_FIRST_NAME);
		}

		if (req.getParameter(P_LAST_NAME) != null) {
			pLastName = req.getParameter(P_LAST_NAME);
		}

		if (req.getParameter(SERVICE_NO) != null) {
			serviceNo = req.getParameter(SERVICE_NO);
		}
		if (req.getParameter(ENTRY_NO) != null) {
			medicalEntryNo = req.getParameter(ENTRY_NO);
		}

		if (req.getParameter(SERVICE_TYPE_NAME) != null) {
			serviceType = req.getParameter(SERVICE_TYPE_NAME);
		}
		if (req.getParameter(HIN_NO) != null) {
			hinNo = req.getParameter(HIN_NO);
		}
		if (req.getParameter(AD_NO) != null) {
			adnNo = req.getParameter(AD_NO);
		}

		if (req.getParameter(SEX) != null) {
			sex = req.getParameter(SEX);
		}
		if (req.getParameter(AGE) != null) {
			age = req.getParameter(AGE);
		}
		if (req.getParameter(UNIT_NAME) != null) {
			unitName = req.getParameter(UNIT_NAME);
		}
		if (req.getParameter(TRADE_NAME) != null) {
			tradeName = req.getParameter(TRADE_NAME);
		}
		if (req.getParameter(RANK_NAME) != null) {
			rankName = req.getParameter(RANK_NAME);
		}
		if (req.getParameter(CEASED_DUTY_ON) != null
				&& !req.getParameter(CEASED_DUTY_ON).equalsIgnoreCase("")) {
			ceasedDutyOn = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(CEASED_DUTY_ON));
		}

		if (req.getParameter(RESTRICTION_REGARDING_EMPLOYEMENT) != null) {
			restrictionRegardingEmployment = req
					.getParameter(RESTRICTION_REGARDING_EMPLOYEMENT);
		}
		if (req.getParameter(INSTRUCTION_BY_PRESIDENT) != null) {
			instructionByPresident = req.getParameter(INSTRUCTION_BY_PRESIDENT);
		}

		if (req.getParameter(CHANGED_BY) != null
				&& !(req.getParameter(CHANGED_BY).equals(""))) {
			changeBy = req.getParameter(CHANGED_BY);
		}
		if (req.getParameter(CHANGED_DATE) != null
				&& !(req.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(CHANGED_DATE));
		}
		if (req.getParameter(CHANGED_TIME) != null
				&& !(req.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = req.getParameter(CHANGED_TIME);

		}
		if (req.getParameter("pluse") != null) {
			pluse = req.getParameter("pluse");
		}
		if (req.getParameter("bp") != null) {
			bp = req.getParameter("bp");
		}
		if (req.getParameter("localExam") != null) {
			localExam = req.getParameter("localExam");
		}
		if (req.getParameter("ecg") != null) {
			ecg = req.getParameter("ecg");
		}
		if (req.getParameter("XRay") != null) {
			xRay = req.getParameter("XRay");
		}
		if (req.getParameter("sick_date") != null && !req.getParameter("sick_date").equalsIgnoreCase("")) {
			sick_date = HMSUtil.dateFormatterDDMMYYYY(req.getParameter("sick_date"));
		}
		if (req.getParameter("sick_week") != null && !req.getParameter("sick_week").equalsIgnoreCase("")) {
			sick_week = Integer.parseInt(req.getParameter("sick_week"));
		}
		if (req.getParameter("title") != null) {
			title = req.getParameter("title");
		}
		generalMap.put("code", medicalEntryNo);
		// generalMap.put("name", betchNo);
		// generalMap.put("address", req.getParameter(TYPE_OF_ENTRY));

		// generalMap.put("pojoPropertyName", "BatchNo");
		generalMap.put("pojoPropertyCode", "EntryNo");
		// generalMap.put("pojoPropertyAddress", "TypeOfEntry");
		generalMap.put("pojoName", "MasMedicalBoardProceedings");

		Map listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		Boolean successfullyAdded = false;
		List codeList = (List) listMap.get("duplicateGeneralCodeList");
		// List nameList = (List) listMap.get("duplicateGeneralNameList");
		// List typeOfEntryList = (List)
		// listMap.get("duplicateGeneralAddressList");
		if (codeList != null && codeList.size() > 0) {
			message = "Entry No Already Exist!";
			jsp = MEDICAL_BOARD_ERROR_MSG;
		} else {
			masMedicalBoardProceedings.setEntryNo(medicalEntryNo);
			masMedicalBoardProceedings.setMedicalType(medicalType);
			masMedicalBoardProceedings
					.setDateOfCommissioning(dateOfCommissioning);
			masMedicalBoardProceedings.setAddress(address);
			masMedicalBoardProceedings
					.setPastMedicalHistory(pastMedicalHistory);
			masMedicalBoardProceedings.setMedicalCategory(medicalCategoryName);
			if (boardPresident != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(boardPresident);
				masMedicalBoardProceedings.setBoardPresident(masEmployee);
			}
			if (member1Name != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(member1Name);
				masMedicalBoardProceedings.setMember1Name(masEmployee);
			}
			if (member2Name != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(member2Name);
				masMedicalBoardProceedings.setMember2Name(masEmployee);
			}
			
			masMedicalBoardProceedings
					.setMedicalCategoryDuration(medicalCategoryDuration);
			masMedicalBoardProceedings
					.setDateOfRecategorization(dateOfRecategorization);
			masMedicalBoardProceedings
					.setPlaceOfRecategorization(placeOfRecategorization);
			masMedicalBoardProceedings
					.setPreviousDisablement(previousDisablement);
			masMedicalBoardProceedings
					.setPresentDisablement(presentDisablement);
			masMedicalBoardProceedings
					.setReasonsForVariation(reasonForVariation);
			masMedicalBoardProceedings
					.setRestrictionRegardingEmployment(restrictionRegardingEmployment);
			masMedicalBoardProceedings
					.setInstructionByPresident(instructionByPresident);
			masMedicalBoardProceedings
					.setDisabilityAttributableStatus(disabilityAttributableStatus);
			masMedicalBoardProceedings
					.setDisabilityAttributableDesc(disabilityAttributableDesc);
			masMedicalBoardProceedings
					.setAggravatedServiceStatus(aggravatedServiceStatus);
			masMedicalBoardProceedings
					.setAggravatedServiceDesc(aggravatedServiceDesc);
			masMedicalBoardProceedings.setWeight(weight);
			masMedicalBoardProceedings.setHeight(height);
			masMedicalBoardProceedings.setAdNo(adnNo);
			masMedicalBoardProceedings.setSex(sex);
			masMedicalBoardProceedings.setHinNo(hinNo);
			masMedicalBoardProceedings.setAge(age);
			masMedicalBoardProceedings.setServiceName(serviceType);
			masMedicalBoardProceedings.setServiceNo(serviceNo);
			masMedicalBoardProceedings.setRankName(rankName);
			masMedicalBoardProceedings.setUnitName(unitName);
			masMedicalBoardProceedings.setFirstName(pFirstName);
			masMedicalBoardProceedings.setLastName(pLastName);
			masMedicalBoardProceedings.setCeasedDutyOn(ceasedDutyOn);
			masMedicalBoardProceedings.setClinicalSummary(clinicalSummary);
			masMedicalBoardProceedings.setTradeName(tradeName);
			masMedicalBoardProceedings.setEntryDate(entryDate);
			masMedicalBoardProceedings.setLastChgBy(changeBy);
			masMedicalBoardProceedings.setLastChgDate(currentDate);
			masMedicalBoardProceedings.setLastChgTime(currentTime);
			masMedicalBoardProceedings.setStatus("y");
			masMedicalBoardProceedings
					.setMedicalCategoryWithDuration(medicalCategoryNameWithDuration);
			masMedicalBoardProceedings.setAddressOnLeave(addressOnLeave);
			if (state != 0) {
				MasState state1 = new MasState();
				state1.setId(state);
				masMedicalBoardProceedings.setState(state1);
			}
			if (district != 0) {
				MasDistrict district1 = new MasDistrict();
				district1.setId(district);
				masMedicalBoardProceedings.setCity(district1);
			}
			masMedicalBoardProceedings.setPluse(pluse);
			masMedicalBoardProceedings.setBp(bp);
			masMedicalBoardProceedings.setLocalExam(localExam);
			masMedicalBoardProceedings.setEcg(ecg);
			masMedicalBoardProceedings.setXRay(xRay);
			masMedicalBoardProceedings.setSickDate(sick_date);
			masMedicalBoardProceedings.setSickWeek(sick_week);
			successfullyAdded = medicalBoardProceedingHandlerService
					.addMedicalBoardProceeding(masMedicalBoardProceedings,
							masMedicalBoardDetails);
			if (successfullyAdded) {
				message = "Record Added Successfully! Do You Want To Print ?";
				jsp = RequestConstants.MEDICAL_BOARD_PROCEEDING_MSG;
			} else {
				message = "There is already an same entry exist for this Service No for this year!!";
				jsp = MEDICAL_BOARD_ERROR_MSG;
			}
		}
		int Id = getMedicalBoardProceedingId();
		map = medicalBoardProceedingHandlerService
				.showMedicalBoardProceedingJsp(Id);
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public MedicalBoardProceedingHandlerService getMedicalBoardProceedingHandlerService() {
		return medicalBoardProceedingHandlerService;
	}

	public void setMedicalBoardProceedingHandlerService(
			MedicalBoardProceedingHandlerService medicalBoardProceedingHandlerService) {
		this.medicalBoardProceedingHandlerService = medicalBoardProceedingHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	public int getMedicalBoardProceedingId() {
		return medicalBoardProceedingId;
	}

	public void setMedicalBoardProceedingId(int medicalBoardProceedingId) {
		this.medicalBoardProceedingId = medicalBoardProceedingId;
	}

	/**
	 * @return the medicalBoardProceedingSearchHandlerService
	 */
	public MedicalBoardProceedingSearchHandlerService getMedicalBoardProceedingSearchHandlerService() {
		return medicalBoardProceedingSearchHandlerService;
	}

	/**
	 * @param medicalBoardProceedingSearchHandlerService
	 *            the medicalBoardProceedingSearchHandlerService to set
	 */
	public void setMedicalBoardProceedingSearchHandlerService(
			MedicalBoardProceedingSearchHandlerService medicalBoardProceedingSearchHandlerService) {
		this.medicalBoardProceedingSearchHandlerService = medicalBoardProceedingSearchHandlerService;
	}

}
