package jkt.hms.medicalboard.controller;

import static jkt.hms.util.RequestConstants.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hms.masters.business.MasMaritalStatus;
import jkt.hms.masters.business.MasMedicalBoardExaminationDetail;
import jkt.hms.masters.business.MasMedicalExaminationReportOnEntry;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.MbTypeOfEntryMaster;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.medicalboard.handler.MedicalExaminationBoardHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MedicalExaminationBoardController extends MultiActionController {
	private MedicalExaminationBoardHandlerService medicalExaminationBoardHandlerService = null;
	private CommonMasterHandlerService commonMasterHandlerService = null;

	@SuppressWarnings("unchecked")
	public ModelAndView showMedicalExaminationBoardJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		String medicalEntryNo = "";
		String medicalEntryNo1 = "";
		String userName = "";
		String userName1 = "";
		Map map = new HashMap();
		medicalEntryNo = medicalExaminationBoardHandlerService
				.generateMedicalEntryNumber(userName);
		medicalEntryNo1 = medicalExaminationBoardHandlerService
				.generateMedicalEntryNumber1(userName1);
		map = medicalExaminationBoardHandlerService
				.showMedicalExaminationBoardJsp();
		//jsp = MEDICAL_EXAMINATIN_BOARD_JSP;
		jsp = "mb_medicalBoardExaminationOnAnnual";
		jsp += ".jsp";
		// title = "complaint";
		map.put("medicalEntryNo", medicalEntryNo);
		map.put("medicalEntryNo1", medicalEntryNo1);
		map.put("contentJsp", jsp);
		// map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView showInitialMedicalExamReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		jsp = "mb_reportMedicalExamJsp";

		jsp += ".jsp";
		// title = "complaint";
		map.put("contentJsp", jsp);
		// map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addMedicalExaminationBoard(HttpServletRequest req,
			HttpServletResponse res) {

		String url = "";
		String yearlySerialNo = "";
		String monthlySerialNo = "";
		Date entryDate = null;
		Date medicinExamDate = null;
		String lastChangedBy = "";
		String lastChangedTime = "";
		Date lastChangedDate = null;
		Date surgeyDate = null;
		int typeOfEntry = 0;
		String betchNo = "";
		String chestNo = "";
		String rollNo = "";
		int medicalExamHeld = 0;
		String medicalStatus = "";
		String fullName = "";
		Date dateOfBirth = null;
		int maritialStatus = 0;
		String service = "";
		String pNo = "";
		String rank = "";
		String hoursOfFlown = "";
		String permanentAddress = "";
		String identification1 = "";
		String identification2 = "";
		String armsCrops = "";
		Date dateOfReporting = null;
		Date dateOfCompletion = null;
		Date documentForwardDate = null;
		String documentForwardTo = "";
		String fromWhereHeReport = "";
		int srNo = 0;
		String Relation = "";
		String age = "";
		String health = "";
		String couseOfDeath = "";
		String died = "";
		String hypertension = "";
		String heartDisease = "";
		String diabetes = "";
		String bleedingDisorder = "";
		String mentalDisease = "";
		String nightBlindness = "";

		String asthama = "";
		String dischargeFrom = "";
		String plesury = "";
		String earDieses = "";
		String rheumatism = "";
		String frequentCough = "";
		String chronicIndigestion = "";
		String nervousBrakdown = "";
		String kidenyBladder = "";
		String fitsFaintinngAttacks = "";
		String std = "";
		String serveHeadInjury = "";
		String joundice = "";
		String sickness = "";
		String breastDisease = "";
		String trachoma = "";
		String amenorrhoea = "";
		String nightbindness = "";
		String menirrhagia = "";
		String laserTeartement = "";
		String pregnancy = "";
		String abortion = "";
		String eyeDisease = "";
		String rejectedAsUnfit = "";
		String dischargeMedicallyUnfit = "";
		String adimmitedInHospitalFirIllness = "";
		String stateNature = "";
		String otherInform = "";
		BigDecimal height = new BigDecimal(0);
		BigDecimal weight = new BigDecimal(0);
		BigDecimal acceptableKg = new BigDecimal(0);
		BigDecimal leglength = new BigDecimal(0);
		String appereance = "";
		String albumin = "";
		String sugar = "";
		String spGraviry = "";
		String hbPercentage = "";
		String physique = "";
		String anyOtherInv = "";
		String skin = "";
		String abdomen = "";
		String heartSize = "";
		String sound = "";
		String rhythm = "";
		String arterialWalls = "";
		String pulseRates = "";
		String bp = "";
		String fullExpension = "";
		String rangeOfExpension = "";
		String selfBalR = "";
		String selfBalL = "";
		String speechMental = "";
		String endocrinCond = "";
		String otherAbnormalities = "";
		String medicinRemarks = "";
		String finger = "";
		String hand = "";
		String wrist = "";
		String elbows = "";
		String shoulderGridles = "";
		String cercival = "";
		String dorsalVertebrate = "";
		String hullux = "";
		String valgus = "";
		String riggus = "";
		String flatFeet = "";
		String joints = "";
		String pelvis = "";
		String gail = "";
		String lumberScaler = "";
		String roccyxVericose = "";
		String hydrocele = "";
		String varicocele = "";
		String underScende = "";
		String hemonhoids = "";
		String herinaMusic = "";
		String breasts = "";
		String surgeryRemarks = "";
		String respatorySystem = "";

		String withGlassesDistantR = "";
		String withglassesDistantL = "";
		String withGlassesNearR = "";
		String withGlassesNearL = "";
		String withGlassesNearCP = "";
		String withoutGlassesDistantR = "";
		String withoutGlassesDistantL = "";
		String withoutGlassesNearR = "";
		String withoutGlassesNearL = "";
		String withoutGlassesNearCP = "";
		BigDecimal convergenceCP = new BigDecimal(0);

		BigDecimal convergenceC = new BigDecimal(0);
		String accommodationR = "";
		String accommodationL = "";
		String eyeRemarks = "";
		Date eyeDate = null;
		BigDecimal hearingRFW = new BigDecimal(0);
		BigDecimal hearingLFW = new BigDecimal(0);
		BigDecimal hearingBothFW = new BigDecimal(0);
		BigDecimal hearingRCV = new BigDecimal(0);
		BigDecimal hearingLCV = new BigDecimal(0);
		BigDecimal hearingBothCV = new BigDecimal(0);

		String innerEarR = "";
		String innerEarL = "";
		String audiometryRecord = "";
		String nose = "";
		String throatEar = "";
		String earReamrks = "";
		Date earDate = null;
		String externalEarR = "";
		String externalEarL = "";
		String middleEarR = "";
		String middleEarL = "";
		String evidienceOfTrachoma = "";
		String binocular = "";
		String manifestHypermetropia = "";
		String coverTest = "";
		String diaphragmTest = "";
		String fundMedia = "";
		String fields = "";
		String nightVisualCapacity = "";

		String dentalRemarks = "";
		Date dentalDate = null;
		String menstrualHistory = "";
		int noOfPregnancy = 0;
		int noOfAbortion = 0;
		int noOfChildren = 0;
		Date lastCondinement = null;
		String vaginalDischarge = "";
		String prolapse = "";
		String usgAbortion = "";
		String gyanaecologyRemarks = "";
		Date gyanaecologyDate = null;
		String medicalBoardExamination = "";
		int medicalBoardExaminationPlace = 0;
		Date medicalBoardExaminationDate = null;
		String subsequentMedicalBoardExam = "";
		int subsequentMedicalBoardExamPlace = 0;
		Date subsequentMedicalBoardExamDate = null;
		String ApprovingAuthority = "";
		int ApprovingAuthorityPlace = 0;
		Date ApprovingAuthorityDate = null;
		String lmp = "";
		String totalTeeth = "";
		String totalDefectiveTeeth = "";
		String missingTeeth = "";
		String DenstalPoint = "";
		String unserviceableTeeth = "";

		String dur8 = "";
		String dur7 = "";
		String dur6 = "";
		String dur5 = "";
		String dur4 = "";
		String dur3 = "";
		String dur2 = "";
		String dur1 = "";
		String dul8 = "";
		String dul7 = "";
		String dul6 = "";
		String dul5 = "";
		String dul4 = "";
		String dul3 = "";
		String dul2 = "";
		String dul1 = "";
		String dlr8 = "";
		String dlr7 = "";
		String dlr6 = "";
		String dlr5 = "";
		String dlr4 = "";
		String dlr3 = "";
		String dlr2 = "";
		String dlr1 = "";
		String dll8 = "";
		String dll7 = "";
		String dll6 = "";
		String dll5 = "";
		String dll4 = "";
		String dll3 = "";
		String dll2 = "";
		String dll1 = "";
		String mur8 = "";
		String mur7 = "";
		String mur6 = "";
		String mur5 = "";
		String mur4 = "";
		String mur3 = "";
		String mur2 = "";
		String mur1 = "";
		String mul8 = "";
		String mul7 = "";
		String mul6 = "";
		String mul5 = "";
		String mul4 = "";
		String mul3 = "";
		String mul2 = "";
		String mul1 = "";
		String mlr8 = "";
		String mlr7 = "";
		String mlr6 = "";
		String mlr5 = "";
		String mlr4 = "";
		String mlr3 = "";
		String mlr2 = "";
		String mlr1 = "";
		String mll8 = "";
		String mll7 = "";
		String mll6 = "";
		String mll5 = "";
		String mll4 = "";
		String mll3 = "";
		String mll2 = "";
		String mll1 = "";
		String uur8 = "";
		String uur7 = "";
		String uur6 = "";
		String uur5 = "";
		String uur4 = "";
		String uur3 = "";
		String uur2 = "";
		String uur1 = "";
		String uul8 = "";
		String uul7 = "";
		String uul6 = "";
		String uul5 = "";
		String uul4 = "";
		String uul3 = "";
		String uul2 = "";
		String uul1 = "";
		String ulr8 = "";
		String ulr7 = "";
		String ulr6 = "";
		String ulr5 = "";
		String ulr4 = "";
		String ulr3 = "";
		String ulr2 = "";
		String ulr1 = "";
		String ull8 = "";
		String ull7 = "";
		String ull6 = "";
		String ull5 = "";
		String ull4 = "";
		String ull3 = "";
		String ull2 = "";
		String ull1 = "";

		String sur8 = "";
		String sur7 = "";
		String sur6 = "";
		String sur5 = "";
		String sur4 = "";
		String sur3 = "";
		String sur2 = "";
		String sur1 = "";
		String sul8 = "";
		String sul7 = "";
		String sul6 = "";
		String sul5 = "";
		String sul4 = "";
		String sul3 = "";
		String sul2 = "";
		String sul1 = "";

		String slr8 = "";
		String slr7 = "";
		String slr6 = "";
		String slr5 = "";
		String slr4 = "";
		String slr3 = "";
		String slr2 = "";
		String slr1 = "";
		String sll8 = "";
		String sll7 = "";
		String sll6 = "";

		String sll5 = "";
		String sll4 = "";
		String sll3 = "";
		String sll2 = "";
		String sll1 = "";

		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(req);
		MasMedicalExaminationReportOnEntry masMedicalBoardProceedings = new MasMedicalExaminationReportOnEntry();

		Map<String, Object> generalMap = new HashMap<String, Object>();
		List<MasMedicalBoardExaminationDetail> masMedicalBoardDetails = new ArrayList<MasMedicalBoardExaminationDetail>();

		Vector<String> v1 = box.getVector(RELATION);

		Vector<String> v2 = box.getVector(AGE);

		Vector<String> v3 = box.getVector(HEALTH);

		Vector<String> v4 = box.getVector(CAUSE_OF_DEATH);

		Vector<String> v5 = box.getVector(DIED);

		Vector<String> v6 = box.getVector(SIRIAL_NO);

		for (int i = 0; i < v2.size(); i++) {

			MasMedicalBoardExaminationDetail masMedicalBoardDetail = new MasMedicalBoardExaminationDetail();
			masMedicalBoardDetail.setRelation(v1.get(i));

			masMedicalBoardDetail.setAge(v2.get(i));

			masMedicalBoardDetail.setHealth(v3.get(i));

			masMedicalBoardDetail.setCauseOfDeath(v4.get(i));

			masMedicalBoardDetail.setDied(v5.get(i));

			masMedicalBoardDetail.setSrNo(Integer.parseInt(v6.get(i)));

			masMedicalBoardDetails.add(masMedicalBoardDetail);

		}

		if (req.getParameter(YEARLY_SERIAL_NO) != null
				&& !(req.getParameter(YEARLY_SERIAL_NO).equals(""))) {
			yearlySerialNo = req.getParameter(YEARLY_SERIAL_NO);
		}
		if (req.getParameter(MONTHLY_SERIAL_NO) != null
				&& !(req.getParameter(MONTHLY_SERIAL_NO).equals(""))) {
			monthlySerialNo = req.getParameter(MONTHLY_SERIAL_NO);
		}

		if (req.getParameter(ENTRY_OF_DATE) != null
				&& !(req.getParameter(ENTRY_OF_DATE).equals(""))) {
			entryDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(ENTRY_OF_DATE));
		}
		if (req.getParameter(TYPE_OF_ENTRY) != null
				&& !(req.getParameter(TYPE_OF_ENTRY).equals(""))) {
			typeOfEntry = Integer.parseInt(req.getParameter(TYPE_OF_ENTRY));
		}
		if (req.getParameter(BATCH1_NO) != null
				&& !(req.getParameter(BATCH1_NO).equals(""))) {
			betchNo = req.getParameter(BATCH1_NO);
		}
		if (req.getParameter(CHEST_NO) != null
				&& !(req.getParameter(CHEST_NO).equals(""))) {
			chestNo = req.getParameter(CHEST_NO);
		}

		if (req.getParameter(ROLL_NO) != null
				&& !(req.getParameter(ROLL_NO).equals(""))) {
			rollNo = req.getParameter(ROLL_NO);
		}

		if (req.getParameter(MEDICAL_EXAM_HELD_AT) != null) {
			medicalExamHeld = Integer.parseInt(req
					.getParameter(MEDICAL_EXAM_HELD_AT));
		}

		if (req.getParameter(MEDICAL_STATUS) != null
				&& !(req.getParameter(MEDICAL_STATUS).equals(""))) {
			medicalStatus = req.getParameter(MEDICAL_STATUS);
		}
		if (req.getParameter(FULL_NAME) != null
				&& !(req.getParameter(FULL_NAME).equals(""))) {
			fullName = req.getParameter(FULL_NAME);
		}

		if (req.getParameter(DATE_OF_BIRTH) != null
				&& !(req.getParameter(DATE_OF_BIRTH).equals(""))) {
			dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DATE_OF_BIRTH));
		}

		if (req.getParameter(MARITIAL_STATUS) != null
				&& !(req.getParameter(MARITIAL_STATUS).equals(""))) {
			maritialStatus = Integer
					.parseInt(req.getParameter(MARITIAL_STATUS));
		}

		if (req.getParameter(SERVICE) != null
				&& !(req.getParameter(SERVICE).equals(""))) {
			service = req.getParameter(SERVICE);
		}

		if (req.getParameter(P_NO) != null
				&& !(req.getParameter(P_NO).equals(""))) {
			pNo = req.getParameter(P_NO);
		}

		if (req.getParameter(RANK) != null
				&& !(req.getParameter(RANK).equals(""))) {
			rank = req.getParameter(RANK);
		}

		if (req.getParameter(HOURS_OF_FLOWN) != null
				&& !(req.getParameter(HOURS_OF_FLOWN).equals(""))) {
			hoursOfFlown = req.getParameter(HOURS_OF_FLOWN);
		}
		if (req.getParameter(PERMANENT_ADDRESS) != null
				&& !(req.getParameter(PERMANENT_ADDRESS).equals(""))) {
			permanentAddress = req.getParameter(PERMANENT_ADDRESS);
		}

		if (req.getParameter(IDENTIFICATION_MARKS1) != null
				&& !(req.getParameter(IDENTIFICATION_MARKS1).equals(""))) {
			identification1 = req.getParameter(IDENTIFICATION_MARKS1);
		}

		if (req.getParameter(IDENTIFICATION_MARKS2) != null
				&& !(req.getParameter(IDENTIFICATION_MARKS2).equals(""))) {
			identification2 = req.getParameter(IDENTIFICATION_MARKS2);
		}

		if (req.getParameter(ARMS_CROPS) != null
				&& !(req.getParameter(ARMS_CROPS).equals(""))) {
			armsCrops = req.getParameter(ARMS_CROPS);
		}

		if (req.getParameter(DATE_OF_COMPLETION) != null
				&& !(req.getParameter(DATE_OF_COMPLETION).equals(""))) {
			dateOfCompletion = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DATE_OF_COMPLETION));
		}

		if (req.getParameter(DOCUMENT_FORWARD_DATE1) != null
				&& !(req.getParameter(DOCUMENT_FORWARD_DATE1).equals(""))) {
			documentForwardDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DOCUMENT_FORWARD_DATE1));

		}

		if (req.getParameter(DOCUMENT_FORWARD_TO) != null
				&& !(req.getParameter(DOCUMENT_FORWARD_TO).equals(""))) {
			documentForwardTo = req.getParameter(DOCUMENT_FORWARD_TO);
		}
		if (req.getParameter(DATE_OF_REPORTING) != null
				&& !(req.getParameter(DATE_OF_REPORTING).equals(""))) {
			dateOfReporting = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DATE_OF_REPORTING));

		}

		if (req.getParameter(FROM_WHERE_HE_REPORT) != null
				&& !(req.getParameter(FROM_WHERE_HE_REPORT).equals(""))) {
			fromWhereHeReport = req.getParameter(FROM_WHERE_HE_REPORT);
		}
		if (req.getParameter(HYPERTENSION) != null
				&& !(req.getParameter(HYPERTENSION).equals(""))) {
			hypertension = req.getParameter(HYPERTENSION);
		}
		if (req.getParameter(HEAR_DISEASE) != null
				&& !(req.getParameter(HEAR_DISEASE).equals(""))) {
			heartDisease = req.getParameter(HEAR_DISEASE);
		}
		if (req.getParameter(DIABETES) != null
				&& !(req.getParameter(DIABETES).equals(""))) {
			diabetes = req.getParameter(DIABETES);
		}
		if (req.getParameter(BLEEDING_DIORDER) != null
				&& !(req.getParameter(BLEEDING_DIORDER).equals(""))) {
			bleedingDisorder = req.getParameter(BLEEDING_DIORDER);
		}
		if (req.getParameter(MENTAL_DISEASE) != null
				&& !(req.getParameter(MENTAL_DISEASE).equals(""))) {
			mentalDisease = req.getParameter(MENTAL_DISEASE);
		}
		if (req.getParameter(NIGHT_BLINDNESS) != null
				&& !(req.getParameter(NIGHT_BLINDNESS).equals(""))) {
			nightBlindness = req.getParameter(NIGHT_BLINDNESS);
		}

		if (req.getParameter(ASTHAMA) != null
				&& !(req.getParameter(ASTHAMA).equals(""))) {
			asthama = req.getParameter(ASTHAMA);
		}

		if (req.getParameter(DISCHARGE_FROM) != null
				&& !(req.getParameter(DISCHARGE_FROM).equals(""))) {
			dischargeFrom = req.getParameter(DISCHARGE_FROM);

		}

		if (req.getParameter(PLEURISY) != null
				&& !(req.getParameter(PLEURISY).equals(""))) {
			plesury = req.getParameter(PLEURISY);
		}

		if (req.getParameter(EAR_DISEASE) != null
				&& !(req.getParameter(EAR_DISEASE).equals(""))) {
			earDieses = req.getParameter(EAR_DISEASE);
		}

		if (req.getParameter(RHEUMATISM) != null
				&& !(req.getParameter(RHEUMATISM).equals(""))) {
			rheumatism = req.getParameter(RHEUMATISM);
		}
		if (req.getParameter(FREQUENT_CAUGH) != null
				&& !(req.getParameter(FREQUENT_CAUGH).equals(""))) {
			frequentCough = req.getParameter(FREQUENT_CAUGH);
		}

		if (req.getParameter(CHRONIC_INDIGESTION) != null
				&& !(req.getParameter(CHRONIC_INDIGESTION).equals(""))) {
			chronicIndigestion = req.getParameter(CHRONIC_INDIGESTION);
		}
		if (req.getParameter(NERVOUS_BRAKDOWN) != null
				&& !(req.getParameter(NERVOUS_BRAKDOWN).equals(""))) {
			nervousBrakdown = req.getParameter(NERVOUS_BRAKDOWN);
		}

		if (req.getParameter(KIDENY_BLADDER) != null
				&& !(req.getParameter(KIDENY_BLADDER).equals(""))) {
			kidenyBladder = req.getParameter(KIDENY_BLADDER);
		}
		if (req.getParameter(FITS_FAINTING_ATTACKS) != null
				&& !(req.getParameter(FITS_FAINTING_ATTACKS).equals(""))) {
			fitsFaintinngAttacks = req.getParameter(FITS_FAINTING_ATTACKS);
		}
		if (req.getParameter(STD) != null
				&& !(req.getParameter(STD).equals(""))) {
			std = req.getParameter(STD);
		}

		if (req.getParameter(SEVERE_HEAD_INJURY) != null
				&& !(req.getParameter(SEVERE_HEAD_INJURY).equals(""))) {
			serveHeadInjury = req.getParameter(SEVERE_HEAD_INJURY);
		}

		if (req.getParameter(JOUNDICE) != null
				&& !(req.getParameter(JOUNDICE).equals(""))) {
			joundice = req.getParameter(JOUNDICE);
		}
		if (req.getParameter(SICKNESS) != null
				&& !(req.getParameter(SICKNESS).equals(""))) {
			sickness = req.getParameter(SICKNESS);
		}
		if (req.getParameter(BREAST_DISEASE) != null
				&& !(req.getParameter(BREAST_DISEASE).equals(""))) {
			breastDisease = req.getParameter(BREAST_DISEASE);
		}
		if (req.getParameter(TRACHOMA) != null
				&& !(req.getParameter(TRACHOMA).equals(""))) {
			trachoma = req.getParameter(TRACHOMA);
		}

		if (req.getParameter(AMENORRHOEA) != null
				&& !(req.getParameter(AMENORRHOEA).equals(""))) {
			amenorrhoea = req.getParameter(AMENORRHOEA);
		}
		if (req.getParameter(NIGHT_BINDNESS) != null
				&& !(req.getParameter(NIGHT_BINDNESS).equals(""))) {
			nightbindness = req.getParameter(NIGHT_BINDNESS);
		}
		if (req.getParameter(MENORRHAGIA) != null
				&& !(req.getParameter(MENORRHAGIA).equals(""))) {
			menirrhagia = req.getParameter(MENORRHAGIA);
		}
		if (req.getParameter(LASER_TREATEMENT) != null
				&& !(req.getParameter(LASER_TREATEMENT).equals(""))) {
			laserTeartement = req.getParameter(LASER_TREATEMENT);
		}
		if (req.getParameter(PREGNANCY) != null
				&& !(req.getParameter(PREGNANCY).equals(""))) {
			pregnancy = req.getParameter(PREGNANCY);
		}
		if (req.getParameter(EYE_DISEASE) != null
				&& !(req.getParameter(EYE_DISEASE).equals(""))) {
			eyeDisease = req.getParameter(EYE_DISEASE);
		}
		if (req.getParameter(REJECTED_AS_UNFIT) != null
				&& !(req.getParameter(REJECTED_AS_UNFIT).equals(""))) {
			rejectedAsUnfit = req.getParameter(REJECTED_AS_UNFIT);
		}
		if (req.getParameter(DISCHARGE_MEDICALLY_UNFIT) != null
				&& !(req.getParameter(DISCHARGE_MEDICALLY_UNFIT).equals(""))) {
			dischargeMedicallyUnfit = req
					.getParameter(DISCHARGE_MEDICALLY_UNFIT);
		}
		if (req.getParameter(ADIMMITED_IN_HOSPITAL_FOR_ILLNESS) != null
				&& !(req.getParameter(ADIMMITED_IN_HOSPITAL_FOR_ILLNESS)
						.equals(""))) {
			adimmitedInHospitalFirIllness = req
					.getParameter(ADIMMITED_IN_HOSPITAL_FOR_ILLNESS);
		}
		if (req.getParameter(ABORTION) != null
				&& !(req.getParameter(ABORTION).equals(""))) {
			abortion = req.getParameter(ABORTION);
		}

		if (req.getParameter(STATE_NATURE_OF_THE_DISEASE) != null
				&& !(req.getParameter(STATE_NATURE_OF_THE_DISEASE).equals(""))) {
			stateNature = req.getParameter(STATE_NATURE_OF_THE_DISEASE);
		}
		if (req.getParameter(OTHER_INFORMATION) != null
				&& !(req.getParameter(OTHER_INFORMATION).equals(""))) {
			otherInform = req.getParameter(OTHER_INFORMATION);
		}
		if (req.getParameter(HEIGHT_WITHOUT_SHOOSE) != null
				&& !(req.getParameter(HEIGHT_WITHOUT_SHOOSE).equals(""))) {
			height = (new BigDecimal(req.getParameter(HEIGHT_WITHOUT_SHOOSE)));
		}
		if (req.getParameter(ACTUAL_WEIGHT) != null
				&& !(req.getParameter(ACTUAL_WEIGHT).equals(""))) {
			weight = (new BigDecimal(req.getParameter(ACTUAL_WEIGHT)));
		}
		if (req.getParameter(ACCEPTABLE_KG) != null
				&& !(req.getParameter(ACCEPTABLE_KG).equals(""))) {
			acceptableKg = (new BigDecimal(req.getParameter(ACCEPTABLE_KG)));
		}
		if (req.getParameter(LEG_LENGTH) != null
				&& !(req.getParameter(LEG_LENGTH).equals(""))) {
			leglength = (new BigDecimal(req.getParameter(LEG_LENGTH)));
		}
		if (req.getParameter(APPEREANCE) != null
				&& !(req.getParameter(APPEREANCE).equals(""))) {
			appereance = req.getParameter(APPEREANCE);
		}
		if (req.getParameter(ALBUMIN) != null
				&& !(req.getParameter(ALBUMIN).equals(""))) {
			albumin = req.getParameter(ALBUMIN);
		}
		if (req.getParameter(SUGAR) != null
				&& !(req.getParameter(SUGAR).equals(""))) {
			sugar = req.getParameter(SUGAR);
		}
		if (req.getParameter(SP_GRAVITY) != null
				&& !(req.getParameter(SP_GRAVITY).equals(""))) {
			spGraviry = req.getParameter(SP_GRAVITY);
		}
		if (req.getParameter(HB_PERCENTAGE) != null
				&& !(req.getParameter(HB_PERCENTAGE).equals(""))) {
			hbPercentage = req.getParameter(HB_PERCENTAGE);
		}
		if (req.getParameter(PHYSIQUE) != null
				&& !(req.getParameter(PHYSIQUE).equals(""))) {
			physique = req.getParameter(PHYSIQUE);
		}

		if (req.getParameter(ANYOTHER_INV_CARRIED_OUT) != null
				&& !(req.getParameter(ANYOTHER_INV_CARRIED_OUT).equals(""))) {
			anyOtherInv = req.getParameter(ANYOTHER_INV_CARRIED_OUT);
		}
		if (req.getParameter(SKIN) != null
				&& !(req.getParameter(SKIN).equals(""))) {
			skin = req.getParameter(SKIN);
		}
		if (req.getParameter(ABDOMEN) != null
				&& !(req.getParameter(ABDOMEN).equals(""))) {
			abdomen = req.getParameter(ABDOMEN);
		}
		if (req.getParameter(HEART_SIZE) != null
				&& !(req.getParameter(HEART_SIZE).equals(""))) {
			heartSize = req.getParameter(HEART_SIZE);
		}
		if (req.getParameter(SOUND) != null
				&& !(req.getParameter(SOUND).equals(""))) {
			sound = req.getParameter(SOUND);
		}
		if (req.getParameter(RHYTHM) != null
				&& !(req.getParameter(RHYTHM).equals(""))) {
			rhythm = req.getParameter(RHYTHM);
		}
		if (req.getParameter(ARTERIAL_WALLS) != null
				&& !(req.getParameter(ARTERIAL_WALLS).equals(""))) {
			arterialWalls = req.getParameter(ARTERIAL_WALLS);
		}
		if (req.getParameter(PULSE_RATES) != null
				&& !(req.getParameter(PULSE_RATES).equals(""))) {
			pulseRates = req.getParameter(PULSE_RATES);
		}
		if (req.getParameter(BP1) != null
				&& !(req.getParameter(BP1).equals(""))) {
			bp = req.getParameter(BP1);
		}
		if (req.getParameter(FULL_EXPENSION) != null
				&& !(req.getParameter(FULL_EXPENSION).equals(""))) {
			fullExpension = req.getParameter(FULL_EXPENSION);
		}
		if (req.getParameter(RANGE_OF_EXPENSION) != null
				&& !(req.getParameter(RANGE_OF_EXPENSION).equals(""))) {
			rangeOfExpension = req.getParameter(RANGE_OF_EXPENSION);
		}

		if (req.getParameter(SELF_BALANCINF_R) != null
				&& !(req.getParameter(SELF_BALANCINF_R).equals(""))) {
			selfBalR = req.getParameter(SELF_BALANCINF_R);
		}
		if (req.getParameter(SELF_BALANCING_L) != null
				&& !(req.getParameter(SELF_BALANCING_L).equals(""))) {
			selfBalL = req.getParameter(SELF_BALANCING_L);
		}
		if (req.getParameter(SPEECH_MENTAL_CAPACITY) != null
				&& !(req.getParameter(SPEECH_MENTAL_CAPACITY).equals(""))) {
			speechMental = req.getParameter(SPEECH_MENTAL_CAPACITY);
		}
		if (req.getParameter(ENDOCRINE_CONDITION) != null
				&& !(req.getParameter(ENDOCRINE_CONDITION).equals(""))) {
			endocrinCond = req.getParameter(ENDOCRINE_CONDITION);
		}
		if (req.getParameter(OTHER_ABNORMALITIES) != null
				&& !(req.getParameter(OTHER_ABNORMALITIES).equals(""))) {
			otherAbnormalities = req.getParameter(OTHER_ABNORMALITIES);
		}
		if (req.getParameter(MEDICIN_REMARKS) != null
				&& !(req.getParameter(MEDICIN_REMARKS).equals(""))) {
			medicinRemarks = req.getParameter(MEDICIN_REMARKS);
		}
		if (req.getParameter(FINGER) != null
				&& !(req.getParameter(FINGER).equals(""))) {
			finger = req.getParameter(FINGER);
		}
		if (req.getParameter(HAND) != null
				&& !(req.getParameter(HAND).equals(""))) {
			hand = req.getParameter(HAND);
		}
		if (req.getParameter(WRIST) != null
				&& !(req.getParameter(WRIST).equals(""))) {
			wrist = req.getParameter(WRIST);
		}
		if (req.getParameter(ELBOWS) != null
				&& !(req.getParameter(ELBOWS).equals(""))) {
			elbows = req.getParameter(ELBOWS);
		}
		if (req.getParameter(SHOULDER_GIRDLES) != null
				&& !(req.getParameter(SHOULDER_GIRDLES).equals(""))) {
			shoulderGridles = req.getParameter(SHOULDER_GIRDLES);
		}
		if (req.getParameter(CERCIVAL) != null
				&& !(req.getParameter(CERCIVAL).equals(""))) {
			cercival = req.getParameter(CERCIVAL);
		}
		if (req.getParameter(DORSAL_VERTEBRATE) != null
				&& !(req.getParameter(DORSAL_VERTEBRATE).equals(""))) {
			dorsalVertebrate = req.getParameter(DORSAL_VERTEBRATE);
		}
		if (req.getParameter(HULLUX) != null
				&& !(req.getParameter(HULLUX).equals(""))) {
			hullux = req.getParameter(HULLUX);
		}
		if (req.getParameter(VALGUS) != null
				&& !(req.getParameter(VALGUS).equals(""))) {
			valgus = req.getParameter(VALGUS);
		}
		if (req.getParameter(RIGGUS) != null
				&& !(req.getParameter(RIGGUS).equals(""))) {
			riggus = req.getParameter(RIGGUS);
		}
		if (req.getParameter(FLAT_FEET) != null
				&& !(req.getParameter(FLAT_FEET).equals(""))) {
			flatFeet = req.getParameter(FLAT_FEET);
		}
		if (req.getParameter(JOINTS) != null
				&& !(req.getParameter(JOINTS).equals(""))) {
			joints = req.getParameter(JOINTS);
		}
		if (req.getParameter(PELVIS) != null
				&& !(req.getParameter(PELVIS).equals(""))) {
			pelvis = req.getParameter(PELVIS);
		}
		if (req.getParameter(GAIL) != null
				&& !(req.getParameter(GAIL).equals(""))) {
			gail = req.getParameter(GAIL);
		}
		if (req.getParameter(LUMBER_SCALER_VERTABRAC) != null
				&& !(req.getParameter(LUMBER_SCALER_VERTABRAC).equals(""))) {
			lumberScaler = req.getParameter(LUMBER_SCALER_VERTABRAC);
		}
		if (req.getParameter(ROCCYX_VARICOSE_VENIS) != null
				&& !(req.getParameter(ROCCYX_VARICOSE_VENIS).equals(""))) {
			roccyxVericose = req.getParameter(ROCCYX_VARICOSE_VENIS);
		}
		if (req.getParameter(HYDROCELE) != null
				&& !(req.getParameter(HYDROCELE).equals(""))) {
			hydrocele = req.getParameter(HYDROCELE);
		}
		if (req.getParameter(VARICOCELE) != null
				&& !(req.getParameter(VARICOCELE).equals(""))) {
			varicocele = req.getParameter(VARICOCELE);
		}
		if (req.getParameter(UNDER_SCENDED_TESTES) != null
				&& !(req.getParameter(UNDER_SCENDED_TESTES).equals(""))) {
			underScende = req.getParameter(UNDER_SCENDED_TESTES);
		}
		if (req.getParameter(HEMONHOIDS) != null
				&& !(req.getParameter(HEMONHOIDS).equals(""))) {
			hemonhoids = req.getParameter(HEMONHOIDS);
		}
		if (req.getParameter(HERNIA_MUSCLE) != null
				&& !(req.getParameter(HERNIA_MUSCLE).equals(""))) {
			herinaMusic = req.getParameter(HERNIA_MUSCLE);
		}
		if (req.getParameter(BREASTS) != null
				&& !(req.getParameter(BREASTS).equals(""))) {
			breasts = req.getParameter(BREASTS);
		}
		if (req.getParameter(SURGERY_REMARKS) != null
				&& !(req.getParameter(SURGERY_REMARKS).equals(""))) {
			surgeryRemarks = req.getParameter(SURGERY_REMARKS);
		}
		if (req.getParameter(RESPIRATORY_SYSTEM) != null
				&& !(req.getParameter(RESPIRATORY_SYSTEM).equals(""))) {
			respatorySystem = req.getParameter(RESPIRATORY_SYSTEM);
		}

		if (req.getParameter(WITH_GLASSES_DISTANT_R) != null
				&& !(req.getParameter(WITH_GLASSES_DISTANT_R).equals(""))) {
			withGlassesDistantR = req.getParameter(WITH_GLASSES_DISTANT_R);
		}
		if (req.getParameter(WITH_GLASSES_DISTANT_L) != null
				&& !(req.getParameter(WITH_GLASSES_DISTANT_L).equals(""))) {
			withglassesDistantL = req.getParameter(WITH_GLASSES_DISTANT_L);
		}
		if (req.getParameter(WITH_GLASSES_NEAR_R) != null
				&& !(req.getParameter(WITH_GLASSES_NEAR_R).equals(""))) {
			withGlassesNearR = req.getParameter(WITH_GLASSES_NEAR_R);
		}
		if (req.getParameter(WITH_GLASSES_NEAR_L) != null
				&& !(req.getParameter(WITH_GLASSES_NEAR_L).equals(""))) {
			withGlassesNearL = req.getParameter(WITH_GLASSES_NEAR_L);
		}
		if (req.getParameter(WITH_GLASSES_NEAR_CP) != null
				&& !(req.getParameter(WITH_GLASSES_NEAR_CP).equals(""))) {
			withGlassesNearCP = req.getParameter(WITH_GLASSES_NEAR_CP);

		}
		if (req.getParameter(WITHOUT_GLASSES_DISTANT_R) != null
				&& !(req.getParameter(WITHOUT_GLASSES_DISTANT_R).equals(""))) {
			withoutGlassesDistantR = req
					.getParameter(WITHOUT_GLASSES_DISTANT_R);
		}
		if (req.getParameter(WITHOUT_GLASSES_DISTANT_L) != null
				&& !(req.getParameter(WITHOUT_GLASSES_DISTANT_L).equals(""))) {
			withoutGlassesDistantL = req
					.getParameter(WITHOUT_GLASSES_DISTANT_L);
		}
		if (req.getParameter(WITHOUT_GLASSES_NEAR_R) != null
				&& !(req.getParameter(WITHOUT_GLASSES_NEAR_R).equals(""))) {
			withoutGlassesNearR = req.getParameter(WITHOUT_GLASSES_NEAR_R);
		}
		if (req.getParameter(WITHOUT_GLASSES_NEAR_L) != null
				&& !(req.getParameter(WITHOUT_GLASSES_NEAR_L).equals(""))) {
			withoutGlassesNearL = req.getParameter(WITHOUT_GLASSES_NEAR_L);
		}
		if (req.getParameter(WITHOUT_GLASSES_NEAR_CP) != null
				&& !(req.getParameter(WITHOUT_GLASSES_NEAR_CP).equals(""))) {
			withoutGlassesNearCP = req.getParameter(WITHOUT_GLASSES_NEAR_CP);
		}
		if (req.getParameter(CONVERGENCE_SC) != null
				&& !(req.getParameter(CONVERGENCE_SC).equals(""))) {
			convergenceCP = new BigDecimal(req.getParameter(CONVERGENCE_SC));
		}
		if (req.getParameter(CONVERGENCE_C) != null
				&& !(req.getParameter(CONVERGENCE_C).equals(""))) {
			convergenceC = new BigDecimal(req.getParameter(CONVERGENCE_C));

		}
		if (req.getParameter(ACCOMMODATION_R) != null
				&& !(req.getParameter(ACCOMMODATION_R).equals(""))) {
			accommodationR = req.getParameter(ACCOMMODATION_R);
		}
		if (req.getParameter(ACCOMMODATION_L) != null
				&& !(req.getParameter(ACCOMMODATION_L).equals(""))) {
			accommodationL = req.getParameter(ACCOMMODATION_L);
		}

		if (req.getParameter(EYE_REMARKS) != null
				&& !(req.getParameter(EYE_REMARKS).equals(""))) {
			eyeRemarks = req.getParameter(EYE_REMARKS);
		}
		if (req.getParameter(EYE_DATE) != null
				&& !(req.getParameter(EYE_DATE).equals(""))) {
			eyeDate = HMSUtil.dateFormatterDDMMYYYY(req.getParameter(EYE_DATE));
		}
		if (req.getParameter(HEARING_R_F_W) != null
				&& !(req.getParameter(HEARING_R_F_W).equals(""))) {
			hearingRFW = new BigDecimal(req.getParameter(HEARING_R_F_W));
		}
		if (req.getParameter(HEARING_L_F_W) != null
				&& !(req.getParameter(HEARING_L_F_W).equals(""))) {
			hearingLFW = new BigDecimal(req.getParameter(HEARING_L_F_W));
		}
		if (req.getParameter(HEARING_BOTH_FW) != null
				&& !(req.getParameter(HEARING_BOTH_FW).equals(""))) {
			hearingBothFW = new BigDecimal(req.getParameter(HEARING_BOTH_FW));
		}

		if (req.getParameter(HEARING_R_C_V) != null
				&& !(req.getParameter(HEARING_R_C_V).equals(""))) {
			hearingRCV = new BigDecimal(req.getParameter(HEARING_R_C_V));
		}
		if (req.getParameter(HEARING_L_C_V) != null
				&& !(req.getParameter(HEARING_L_C_V).equals(""))) {
			hearingLCV = new BigDecimal(req.getParameter(HEARING_L_C_V));
		}
		if (req.getParameter(HEARING_BOTH_CV) != null
				&& !(req.getParameter(HEARING_BOTH_CV).equals(""))) {
			hearingBothCV = new BigDecimal(req.getParameter(HEARING_BOTH_CV));
		}
		if (req.getParameter(INNER_EAR_R) != null
				&& !(req.getParameter(INNER_EAR_R).equals(""))) {
			innerEarR = req.getParameter(INNER_EAR_R);
		}
		if (req.getParameter(INNER_EAR_L) != null
				&& !(req.getParameter(INNER_EAR_L).equals(""))) {
			innerEarL = req.getParameter(INNER_EAR_L);
		}

		if (req.getParameter(AUDIOMETRY_RECORD) != null
				&& !(req.getParameter(AUDIOMETRY_RECORD).equals(""))) {
			audiometryRecord = req.getParameter(AUDIOMETRY_RECORD);
		}
		if (req.getParameter(NOSE) != null
				&& !(req.getParameter(NOSE).equals(""))) {
			nose = req.getParameter(NOSE);
		}
		if (req.getParameter(THROAT_EAR) != null
				&& !(req.getParameter(THROAT_EAR).equals(""))) {
			throatEar = req.getParameter(THROAT_EAR);
		}
		if (req.getParameter(EAR_REMARKS) != null
				&& !(req.getParameter(EAR_REMARKS).equals(""))) {
			earReamrks = req.getParameter(EAR_REMARKS);
		}
		if (req.getParameter(EAR_DATE) != null
				&& !(req.getParameter(EAR_DATE).equals(""))) {
			earDate = HMSUtil.dateFormatterDDMMYYYY(req.getParameter(EAR_DATE));
		}

		if (req.getParameter(EXTERNAL_EAR_R) != null
				&& !(req.getParameter(EXTERNAL_EAR_R).equals(""))) {
			externalEarR = req.getParameter(EXTERNAL_EAR_R);
		}
		if (req.getParameter(EXTERNAL_EAR_L) != null
				&& !(req.getParameter(EXTERNAL_EAR_L).equals(""))) {
			externalEarL = req.getParameter(EXTERNAL_EAR_L);
		}
		if (req.getParameter(MIDDLE_EAR_R) != null
				&& !(req.getParameter(MIDDLE_EAR_R).equals(""))) {
			middleEarR = req.getParameter(MIDDLE_EAR_R);
		}
		if (req.getParameter(MIDDLE_EAR_L) != null
				&& !(req.getParameter(MIDDLE_EAR_L).equals(""))) {
			middleEarL = req.getParameter(MIDDLE_EAR_L);
		}
		if (req.getParameter(ANY_EVIDENCE_OF_TRACHOMA) != null
				&& !(req.getParameter(ANY_EVIDENCE_OF_TRACHOMA).equals(""))) {
			evidienceOfTrachoma = req.getParameter(ANY_EVIDENCE_OF_TRACHOMA);
		}
		if (req.getParameter(BINOCULAR_VISION_GRADE) != null
				&& !(req.getParameter(BINOCULAR_VISION_GRADE).equals(""))) {
			binocular = req.getParameter(BINOCULAR_VISION_GRADE);
		}
		if (req.getParameter(MANIFEST_HYPERMETROPIA) != null
				&& !(req.getParameter(MANIFEST_HYPERMETROPIA).equals(""))) {
			manifestHypermetropia = req.getParameter(MANIFEST_HYPERMETROPIA);
		}
		if (req.getParameter(COVER_TEST) != null
				&& !(req.getParameter(COVER_TEST).equals(""))) {
			coverTest = req.getParameter(COVER_TEST);
		}
		if (req.getParameter(DIAPHRAGM_TEST) != null
				&& !(req.getParameter(DIAPHRAGM_TEST).equals(""))) {
			diaphragmTest = req.getParameter(DIAPHRAGM_TEST);
		}
		if (req.getParameter(FUND_MEDIA) != null
				&& !(req.getParameter(FUND_MEDIA).equals(""))) {
			fundMedia = req.getParameter(FUND_MEDIA);
		}
		if (req.getParameter(FIELDS) != null
				&& !(req.getParameter(FIELDS).equals(""))) {
			fields = req.getParameter(FIELDS);
		}
		if (req.getParameter(NIGHT_VISUAL_CAPACITY) != null
				&& !(req.getParameter(NIGHT_VISUAL_CAPACITY).equals(""))) {
			nightVisualCapacity = req.getParameter(NIGHT_VISUAL_CAPACITY);
		}
		if (req.getParameter(DENTAL_REMARKS) != null
				&& !(req.getParameter(DENTAL_REMARKS).equals(""))) {
			dentalRemarks = req.getParameter(DENTAL_REMARKS);
		}

		if (req.getParameter(DENTAL_DATE) != null
				&& !(req.getParameter(DENTAL_DATE).equals(""))) {
			dentalDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DENTAL_DATE));
		}
		if (req.getParameter(MENSTRUAL_HISTORY) != null
				&& !(req.getParameter(MENSTRUAL_HISTORY).equals(""))) {
			menstrualHistory = req.getParameter(MENSTRUAL_HISTORY);
		}
		if (req.getParameter(NO_OF_PREGNANCY) != null
				&& !(req.getParameter(NO_OF_PREGNANCY).equals(""))) {
			noOfPregnancy = Integer.parseInt(req.getParameter(NO_OF_PREGNANCY));
		}
		if (req.getParameter(NO_OF_ABORTION) != null
				&& !(req.getParameter(NO_OF_ABORTION).equals(""))) {
			noOfAbortion = Integer.parseInt(req.getParameter(NO_OF_ABORTION));
		}
		if (req.getParameter(NO_OF_CHILDREN) != null
				&& !(req.getParameter(NO_OF_CHILDREN).equals(""))) {
			noOfChildren = Integer.parseInt(req.getParameter(NO_OF_CHILDREN));
		}
		if (req.getParameter(DATE_OF_LASTCONFINEMENT) != null
				&& !(req.getParameter(DATE_OF_LASTCONFINEMENT).equals(""))) {
			lastCondinement = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DATE_OF_LASTCONFINEMENT));
		}
		if (req.getParameter(VAGINAL_DISCHARGE) != null
				&& !(req.getParameter(VAGINAL_DISCHARGE).equals(""))) {
			vaginalDischarge = req.getParameter(VAGINAL_DISCHARGE);
		}
		if (req.getParameter(PROLAPSE) != null
				&& !(req.getParameter(PROLAPSE).equals(""))) {
			prolapse = req.getParameter(PROLAPSE);
		}
		if (req.getParameter(USG_ABORTION) != null
				&& !(req.getParameter(USG_ABORTION).equals(""))) {
			usgAbortion = req.getParameter(USG_ABORTION);
		}
		if (req.getParameter(GYANAECOLOGY_RAMARKS) != null
				&& !(req.getParameter(GYANAECOLOGY_RAMARKS).equals(""))) {
			gyanaecologyRemarks = req.getParameter(GYANAECOLOGY_RAMARKS);
		}
		if (req.getParameter(GYANAECOLOGY_DATE) != null
				&& !(req.getParameter(GYANAECOLOGY_DATE).equals(""))) {
			gyanaecologyDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(GYANAECOLOGY_DATE));
		}
		if (req.getParameter(GYANAECOLOGY_RAMARKS) != null
				&& !(req.getParameter(GYANAECOLOGY_RAMARKS).equals(""))) {
			gyanaecologyRemarks = req.getParameter(GYANAECOLOGY_RAMARKS);
		}
		if (req.getParameter(MEDICAL_BOARD_EXAMINATION) != null
				&& !(req.getParameter(MEDICAL_BOARD_EXAMINATION).equals(""))) {
			medicalBoardExamination = req
					.getParameter(MEDICAL_BOARD_EXAMINATION);
		}
		if (req.getParameter(MEDICAL_BOARD_EXAMINATION_PLACE) != null
				&& !(req.getParameter(MEDICAL_BOARD_EXAMINATION_PLACE)
						.equals(""))) {

			medicalBoardExaminationPlace = Integer.parseInt(req
					.getParameter(MEDICAL_BOARD_EXAMINATION_PLACE));

		}
		if (req.getParameter(MEDICAL_BOARD_EXAMINATION_DATE) != null
				&& !(req.getParameter(MEDICAL_BOARD_EXAMINATION_DATE)
						.equals(""))) {
			medicalBoardExaminationDate = HMSUtil.dateFormatterDDMMYYYY((req
					.getParameter(MEDICAL_BOARD_EXAMINATION_DATE)));
		}
		if (req.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION) != null
				&& !(req.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION)
						.equals(""))) {
			subsequentMedicalBoardExam = req
					.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION);
		}
		if (req.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_PLACE) != null
				&& !(req
						.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_PLACE)
						.equals(""))) {
			subsequentMedicalBoardExamPlace = Integer.parseInt(req
					.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_PLACE));
		}
		if (req.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_DATE) != null
				&& !(req
						.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_DATE)
						.equals(""))) {
			subsequentMedicalBoardExamDate = HMSUtil.dateFormatterDDMMYYYY((req
					.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_DATE)));
		}

		if (req.getParameter(APPROVING_AUTHORITY) != null
				&& !(req.getParameter(APPROVING_AUTHORITY).equals(""))) {
			ApprovingAuthority = req.getParameter(APPROVING_AUTHORITY);
		}
		if (req.getParameter(APPROVING_AUTHORITY_PLACE) != null
				&& !(req.getParameter(APPROVING_AUTHORITY_PLACE).equals(""))) {
			ApprovingAuthorityPlace = Integer.parseInt(req
					.getParameter(APPROVING_AUTHORITY_PLACE));
		}
		if (req.getParameter(APPROVING_AUTHORITY_DATE) != null
				&& !(req.getParameter(APPROVING_AUTHORITY_DATE).equals(""))) {
			ApprovingAuthorityDate = HMSUtil.dateFormatterDDMMYYYY((req
					.getParameter(APPROVING_AUTHORITY_DATE)));
		}
		if (req.getParameter(LMP) != null
				&& !(req.getParameter(LMP).equals(""))) {
			lmp = (req.getParameter(LMP));
		}

		if (req.getParameter(SURGERY_DATE) != null
				&& !(req.getParameter(SURGERY_DATE).equals(""))) {
			surgeyDate = HMSUtil.dateFormatterDDMMYYYY((req
					.getParameter(SURGERY_DATE)));
		}

		if (req.getParameter(MEDICIN_EXAM_DATE) != null
				&& !(req.getParameter(MEDICIN_EXAM_DATE).equals(""))) {
			medicinExamDate = HMSUtil.dateFormatterDDMMYYYY((req
					.getParameter(MEDICIN_EXAM_DATE)));

		}
		if (req.getParameter(TOTAL_NO_OF_TEETH) != null
				&& !(req.getParameter(TOTAL_NO_OF_TEETH).equals(""))) {
			totalTeeth = req.getParameter(TOTAL_NO_OF_TEETH);

		}
		if (req.getParameter(DEFECTIVE_TEETH) != null
				&& !(req.getParameter(DEFECTIVE_TEETH).equals(""))) {
			totalDefectiveTeeth = req.getParameter(DEFECTIVE_TEETH);

		}
		if (req.getParameter(MISSING_TEETH) != null
				&& !(req.getParameter(MISSING_TEETH).equals(""))) {
			missingTeeth = req.getParameter(MISSING_TEETH);

		}
		if (req.getParameter(MISSING_UNSERVICABLE_TEETH) != null
				&& !(req.getParameter(MISSING_UNSERVICABLE_TEETH).equals(""))) {
			unserviceableTeeth = req.getParameter(MISSING_UNSERVICABLE_TEETH);

		}
		if (req.getParameter(DENTSL_POINT) != null
				&& !(req.getParameter(DENTSL_POINT).equals(""))) {
			DenstalPoint = req.getParameter(DENTSL_POINT);

		}

		if (req.getParameter(LAST_CHANGED_BY) != null) {
			lastChangedBy = req.getParameter(LAST_CHANGED_BY);
		}
		if (req.getParameter(LAST_CHANGED_DATE) != null) {
			lastChangedDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(LAST_CHANGED_DATE));
		}
		if (req.getParameter(LAST_CHANGED_TIME) != null) {
			lastChangedTime = req.getParameter(LAST_CHANGED_TIME);
		}
		// //////////////////////////////////

		if (req.getParameter(DUR_8) != null) {
			dur8 = (req.getParameter(DUR_8));

		} else {
			dur8 = "N";

		}

		if (req.getParameter(DUR_7) != null) {
			dur7 = (req.getParameter(DUR_7));

		} else {
			dur7 = "N";

		}
		if (req.getParameter(DUR_6) != null) {
			dur6 = (req.getParameter(DUR_6));

		} else {
			dur6 = "N";

		}
		if (req.getParameter(DUR_5) != null) {
			dur5 = (req.getParameter(DUR_5));

		} else {
			dur5 = "N";

		}

		if (req.getParameter(DUR_4) != null) {
			dur4 = (req.getParameter(DUR_4));
		} else {
			dur4 = "N";

		}
		if (req.getParameter(DUR_3) != null) {
			dur3 = (req.getParameter(DUR_3));

		} else {
			dur3 = "N";

		}
		if (req.getParameter(DUR_2) != null) {
			dur2 = (req.getParameter(DUR_2));

		} else {
			dur2 = "N";

		}
		if (req.getParameter(DUR_1) != null) {
			dur1 = (req.getParameter(DUR_1));

		} else {
			dur1 = "N";

		}

		if (req.getParameter(DUL_8) != null) {
			dul8 = (req.getParameter(DUL_8));
		} else {
			dul8 = "N";

		}
		if (req.getParameter(DUL_7) != null) {
			dul7 = (req.getParameter(DUL_7));

		} else {
			dul7 = "N";

		}
		if (req.getParameter(DUL_6) != null) {
			dul6 = (req.getParameter(DUL_6));
		} else {
			dul6 = "N";

		}
		if (req.getParameter(DUL_5) != null) {
			dul5 = (req.getParameter(DUL_5));
		} else {
			dul5 = "N";

		}
		if (req.getParameter(DUL_4) != null) {
			dul4 = (req.getParameter(DUL_4));
		} else {
			dul4 = "N";

		}
		if (req.getParameter(DUL_3) != null) {
			dul3 = (req.getParameter(DUL_3));
		} else {
			dul3 = "N";

		}
		if (req.getParameter(DUL_2) != null) {
			dul2 = (req.getParameter(DUL_2));
		} else {
			dul2 = "N";

		}
		if (req.getParameter(DUL_1) != null) {
			dul1 = (req.getParameter(DUL_1));
		} else {
			dul1 = "N";

		}

		if (req.getParameter(DLR_8) != null) {
			dlr8 = (req.getParameter(DLR_8));
		} else {
			dlr8 = "N";

		}
		if (req.getParameter(DLR_7) != null) {
			dlr7 = (req.getParameter(DLR_7));
		} else {
			dlr7 = "N";

		}
		if (req.getParameter(DLR_6) != null) {
			dlr6 = (req.getParameter(DLR_6));
		} else {
			dlr6 = "N";

		}
		if (req.getParameter(DLR_5) != null) {
			dlr5 = (req.getParameter(DLR_5));
		} else {
			dlr5 = "N";

		}
		if (req.getParameter(DLR_4) != null) {
			dlr4 = (req.getParameter(DLR_4));
		} else {
			dlr4 = "N";

		}
		if (req.getParameter(DLR_3) != null) {
			dlr3 = (req.getParameter(DLR_3));
		} else {
			dlr3 = "N";

		}
		if (req.getParameter(DLR_2) != null) {
			dlr2 = (req.getParameter(DLR_2));
		} else {
			dlr2 = "N";

		}

		if (req.getParameter(DLR_1) != null) {
			dlr1 = (req.getParameter(DLR_1));
		} else {
			dlr1 = "N";

		}

		if (req.getParameter(DLL_8) != null) {
			dll8 = (req.getParameter(DLL_8));
		} else {
			dll8 = "N";

		}
		if (req.getParameter(DLL_7) != null) {
			dll7 = (req.getParameter(DLL_7));
		} else {
			dll7 = "N";

		}

		if (req.getParameter(DLL_6) != null) {
			dll6 = (req.getParameter(DLL_6));
		} else {
			dll6 = "N";

		}
		if (req.getParameter(DLL_5) != null) {
			dll5 = (req.getParameter(DLL_5));
		} else {
			dll5 = "N";

		}
		if (req.getParameter(DLL_4) != null) {
			dll4 = (req.getParameter(DLL_4));
		} else {
			dll4 = "N";

		}
		if (req.getParameter(DLL_3) != null) {
			dll3 = (req.getParameter(DLL_3));
		} else {
			dll3 = "N";

		}
		if (req.getParameter(DLL_2) != null) {
			dll2 = (req.getParameter(DLL_2));
		} else {
			dll2 = "N";

		}
		if (req.getParameter(DLL_1) != null) {
			dll1 = (req.getParameter(DLL_1));
		} else {
			dll1 = "N";

		}
		// ///////////////////////////

		if (req.getParameter(UUR_8) != null) {
			uur8 = (req.getParameter(UUR_8));
		} else {
			uur8 = "N";

		}

		if (req.getParameter(UUR_7) != null) {
			uur7 = (req.getParameter(UUR_7));
		} else {
			uur7 = "N";

		}
		if (req.getParameter(UUR_6) != null) {
			uur6 = (req.getParameter(UUR_6));
		} else {
			uur6 = "N";

		}
		if (req.getParameter(UUR_5) != null) {
			uur5 = (req.getParameter(UUR_5));
		} else {
			uur5 = "N";

		}
		if (req.getParameter(UUR_4) != null) {
			uur4 = (req.getParameter(UUR_4));
		} else {
			uur4 = "N";

		}
		if (req.getParameter(UUR_3) != null) {
			uur3 = (req.getParameter(UUR_3));
		} else {
			uur3 = "N";

		}
		if (req.getParameter(UUR_2) != null) {
			uur2 = (req.getParameter(UUR_2));
		} else {
			uur2 = "N";

		}
		if (req.getParameter(UUR_1) != null) {
			uur1 = (req.getParameter(UUR_1));
		} else {
			uur1 = "N";

		}

		if (req.getParameter(UUL_8) != null) {
			uul8 = (req.getParameter(UUL_8));
		} else {
			uul8 = "N";

		}
		if (req.getParameter(UUL_7) != null) {
			uul7 = (req.getParameter(UUL_7));

		} else {
			uul7 = "N";

		}
		if (req.getParameter(UUL_6) != null) {
			uul6 = (req.getParameter(UUL_6));
		} else {
			uul6 = "N";

		}
		if (req.getParameter(UUL_5) != null) {
			uul5 = (req.getParameter(UUL_5));
		} else {
			uul5 = "N";

		}
		if (req.getParameter(UUL_4) != null) {
			uul4 = (req.getParameter(UUL_4));
		} else {
			uul4 = "N";

		}
		if (req.getParameter(UUL_3) != null) {
			uul3 = (req.getParameter(UUL_3));
		} else {
			uul3 = "N";

		}
		if (req.getParameter(UUL_2) != null) {
			uul2 = (req.getParameter(UUL_2));
		} else {
			uul2 = "N";

		}
		if (req.getParameter(UUL_1) != null) {
			uul1 = (req.getParameter(UUL_1));
		} else {
			uul1 = "N";

		}
		if (req.getParameter(ULR_8) != null) {
			ulr8 = (req.getParameter(ULR_8));
		} else {
			ulr8 = "N";

		}

		if (req.getParameter(ULR_7) != null) {
			ulr7 = (req.getParameter(ULR_7));
		} else {
			ulr7 = "N";

		}
		if (req.getParameter(ULR_6) != null) {
			ulr6 = (req.getParameter(ULR_6));
		} else {
			ulr6 = "N";

		}
		if (req.getParameter(ULR_5) != null) {
			ulr5 = (req.getParameter(ULR_5));
		} else {
			ulr5 = "N";

		}
		if (req.getParameter(ULR_4) != null) {
			ulr4 = (req.getParameter(ULR_4));
		} else {
			ulr4 = "N";

		}
		if (req.getParameter(ULR_3) != null) {
			ulr3 = (req.getParameter(ULR_3));
		} else {
			ulr3 = "N";

		}
		if (req.getParameter(ULR_2) != null) {
			ulr2 = (req.getParameter(ULR_2));
		} else {
			ulr2 = "N";

		}
		if (req.getParameter(ULR_1) != null) {
			ulr1 = (req.getParameter(ULR_1));
		} else {
			ulr1 = "N";

		}

		if (req.getParameter(ULL_8) != null) {
			ull8 = (req.getParameter(ULL_8));
		} else {
			ull8 = "N";

		}
		if (req.getParameter(ULL_7) != null) {
			ull7 = (req.getParameter(ULL_7));
		} else {
			ull7 = "N";

		}
		if (req.getParameter(ULL_6) != null) {
			ull6 = (req.getParameter(ULL_6));
		} else {
			ull6 = "N";

		}
		if (req.getParameter(ULL_5) != null) {
			ull5 = (req.getParameter(ULL_5));
		} else {
			ull5 = "N";

		}
		if (req.getParameter(ULL_4) != null) {
			ull4 = (req.getParameter(ULL_4));
		} else {
			ull4 = "N";

		}
		if (req.getParameter(ULL_3) != null) {
			ull3 = (req.getParameter(ULL_3));
		} else {
			ull3 = "N";

		}
		if (req.getParameter(ULL_2) != null) {
			ull2 = (req.getParameter(ULL_2));
		} else {
			ull2 = "N";

		}
		if (req.getParameter(ULL_1) != null) {
			ull1 = (req.getParameter(ULL_1));
		} else {
			ull1 = "N";

		}

		// ////////////////////////

		if (req.getParameter(MUR_8) != null) {
			mur8 = (req.getParameter(MUR_8));

		} else {
			mur8 = "N";

		}
		if (req.getParameter(MUR_7) != null) {
			mur7 = (req.getParameter(MUR_7));
		} else {
			mur7 = "N";

		}
		if (req.getParameter(MUR_6) != null) {
			mur6 = (req.getParameter(MUR_6));
		} else {
			mur6 = "N";

		}
		if (req.getParameter(MUR_5) != null) {
			mur5 = (req.getParameter(MUR_5));
		} else {
			mur5 = "N";

		}
		if (req.getParameter(MUR_4) != null) {
			mur4 = (req.getParameter(MUR_4));
		} else {
			mur4 = "N";

		}
		if (req.getParameter(MUR_3) != null) {
			mur3 = (req.getParameter(MUR_3));
		} else {
			mur3 = "N";

		}
		if (req.getParameter(MUR_2) != null) {
			mur2 = (req.getParameter(MUR_2));
		} else {
			mur2 = "N";

		}
		if (req.getParameter(MUR_1) != null) {
			mur1 = (req.getParameter(MUR_1));
		} else {
			mur1 = "N";

		}

		if (req.getParameter(MUL_8) != null) {
			mul8 = (req.getParameter(MUL_8));
		} else {
			mul8 = "N";

		}
		if (req.getParameter(MUL_7) != null) {
			mul7 = (req.getParameter(MUL_7));

		} else {
			mul7 = "N";

		}
		if (req.getParameter(MUL_6) != null) {
			mul6 = (req.getParameter(MUL_6));
		} else {
			mul6 = "N";

		}
		if (req.getParameter(MUL_5) != null) {
			mul5 = (req.getParameter(MUL_5));
		} else {
			mul5 = "N";

		}
		if (req.getParameter(MUL_4) != null) {
			mul4 = (req.getParameter(MUL_4));
		} else {
			mul4 = "N";

		}
		if (req.getParameter(MUL_3) != null) {
			mul3 = (req.getParameter(MUL_3));
		} else {
			mul3 = "N";

		}
		if (req.getParameter(MUL_2) != null) {
			mul2 = (req.getParameter(MUL_2));
		} else {
			mul2 = "N";

		}
		if (req.getParameter(MUL_1) != null) {
			mul1 = (req.getParameter(MUL_1));
		} else {
			mul1 = "N";

		}
		if (req.getParameter(MLR_8) != null) {
			mlr8 = (req.getParameter(MLR_8));
		} else {
			mlr8 = "N";

		}

		if (req.getParameter(MLR_7) != null) {
			mlr7 = (req.getParameter(MLR_7));
		} else {
			mlr7 = "N";

		}
		if (req.getParameter(MLR_6) != null) {
			mlr6 = (req.getParameter(MLR_6));
		} else {
			mlr6 = "N";

		}
		if (req.getParameter(MLR_5) != null) {
			mlr5 = (req.getParameter(MLR_5));
		} else {
			mlr5 = "N";

		}

		if (req.getParameter(MLR_4) != null) {
			mlr4 = (req.getParameter(MLR_4));
		} else {
			mlr4 = "N";

		}
		if (req.getParameter(MLR_3) != null) {
			mlr3 = (req.getParameter(MLR_3));
		} else {
			mlr3 = "N";

		}

		if (req.getParameter(MLR_2) != null) {
			mlr2 = (req.getParameter(MLR_2));
		} else {
			mlr2 = "N";

		}
		if (req.getParameter(MLR_1) != null) {
			mlr1 = (req.getParameter(MLR_1));
		} else {
			mlr1 = "N";

		}

		if (req.getParameter(MLL_8) != null) {
			mll8 = (req.getParameter(MLL_8));
		} else {
			mll8 = "N";

		}
		if (req.getParameter(MLL_7) != null) {
			mll7 = (req.getParameter(MLL_7));
		} else {
			mll7 = "N";

		}
		if (req.getParameter(MLL_6) != null) {
			mll6 = (req.getParameter(MLL_6));
		} else {
			mll6 = "N";

		}
		if (req.getParameter(MLL_5) != null) {
			mll5 = (req.getParameter(MLL_5));
		} else {
			mll5 = "N";

		}
		if (req.getParameter(MLL_4) != null) {
			mll4 = (req.getParameter(MLL_4));
		} else {
			mll4 = "N";

		}
		if (req.getParameter(MLL_3) != null) {
			mll3 = (req.getParameter(MLL_3));
		} else {
			mll3 = "N";

		}
		if (req.getParameter(MLL_2) != null) {
			mll2 = (req.getParameter(MLL_2));
		} else {
			mll2 = "N";

		}
		if (req.getParameter(MLL_1) != null) {
			mll1 = (req.getParameter(MLL_1));
		} else {
			mll1 = "N";

		}

		sur8 = dur8 + "" + mur8 + "" + uur8;

		sur7 = dur7 + "" + mur7 + "" + uur7;

		sur6 = dur6 + "" + mur6 + "" + uur6;
		sur5 = dur5 + "" + mur5 + "" + uur5;
		sur4 = dur4 + "" + mur4 + "" + uur4;
		sur3 = dur3 + "" + mur3 + "" + uur3;
		sur2 = dur2 + "" + mur2 + "" + uur2;
		sur1 = dur1 + "" + mur2 + "" + uur1;

		sul8 = dul8 + "" + mul8 + "" + uul8;
		sul7 = dul7 + "" + mul7 + "" + uul7;

		sul6 = dul6 + "" + mul6 + "" + uul6;
		sul5 = dul5 + "" + mul5 + "" + uul5;
		sul4 = dul4 + "" + mul4 + "" + uul4;
		sul3 = dul3 + "" + mul3 + "" + uul3;
		sul2 = dul2 + "" + mul2 + "" + uul2;
		sul1 = dul1 + "" + mul1 + "" + uul1;

		slr8 = dlr8 + "" + mlr8 + "" + ulr8;
		slr7 = dlr7 + "" + mlr7 + "" + ulr7;
		slr6 = dlr6 + "" + mlr6 + "" + ulr6;
		slr5 = dlr5 + "" + mlr5 + "" + ulr5;
		slr4 = dlr4 + "" + mlr4 + "" + ulr4;
		slr3 = dlr3 + "" + mlr3 + "" + ulr3;
		slr2 = dlr2 + "" + mlr2 + "" + ulr2;
		slr1 = dlr1 + "" + mlr2 + "" + ulr1;

		sll8 = dll8 + "" + mll8 + "" + ull8;
		sll7 = dll7 + "" + mll7 + "" + ull7;
		sll6 = dll6 + "" + mll6 + "" + ull6;
		sll5 = dll5 + "" + mll5 + "" + ull5;
		sll4 = dll4 + "" + mll4 + "" + ull4;
		sll3 = dll3 + "" + mll3 + "" + ull3;
		sll2 = dll2 + "" + mll2 + "" + ull2;
		sll1 = dll1 + "" + mll2 + "" + ull1;
		MbTypeOfEntryMaster mbTypeOfEntryMaster = new MbTypeOfEntryMaster();
		mbTypeOfEntryMaster.setId(typeOfEntry);
		generalMap.put("code", yearlySerialNo);
		// generalMap.put("name", betchNo);
		// generalMap.put("address", req.getParameter(TYPE_OF_ENTRY));

		// generalMap.put("pojoPropertyName", "BatchNo");
		generalMap.put("pojoPropertyCode", "YearlySerialNo");
		// generalMap.put("pojoPropertyAddress", "TypeOfEntry");
		generalMap.put("pojoName", "MasMedicalExaminationReportOnEntry");
		String message = "";
		String jsp = "";
		Map listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		Boolean successfullyAdded = false;
		List codeList = (List) listMap.get("duplicateGeneralCodeList");
		// List nameList = (List) listMap.get("duplicateGeneralNameList");
		// List typeOfEntryList = (List)
		// listMap.get("duplicateGeneralAddressList");
		if (codeList != null && codeList.size() > 0) {
			message = "Yearly Serial No Already Exist!";
			jsp = MEDICAL_BOARD_ERROR_MSG;
		} else {
			masMedicalBoardProceedings.setInnerEarL(innerEarL);
			masMedicalBoardProceedings.setHearingBothCv(hearingBothCV);
			masMedicalBoardProceedings.setDateSpecialExam(eyeDate);
			masMedicalBoardProceedings
					.setTotalDefectiveTeeth(totalDefectiveTeeth);
			masMedicalBoardProceedings.setTotalTeeth(totalTeeth);
			masMedicalBoardProceedings.setMissingTeeth(missingTeeth);
			masMedicalBoardProceedings.setUnservisableTeeth(unserviceableTeeth);
			masMedicalBoardProceedings.setDenstlPoint(DenstalPoint);
			masMedicalBoardProceedings.setYearlySerialNo(yearlySerialNo);
			masMedicalBoardProceedings.setMonthlySerialNo(monthlySerialNo);
			masMedicalBoardProceedings.setEntryDate(entryDate);

			masMedicalBoardProceedings.setTypeOfEntry(mbTypeOfEntryMaster);
			masMedicalBoardProceedings.setBatchNo(betchNo);
			masMedicalBoardProceedings.setChestNo(chestNo);
			masMedicalBoardProceedings.setRollNo(rollNo);
			MasUnit masUnit = new MasUnit();
			masUnit.setId(medicalExamHeld);
			masMedicalBoardProceedings.setMedicalExamHeldAt(masUnit);
			masMedicalBoardProceedings.setMedicalStatus(medicalStatus);
			masMedicalBoardProceedings.setNameInFull(fullName);
			masMedicalBoardProceedings.setDateOfBirth(dateOfBirth);
			MasMaritalStatus masMaritalStatus = new MasMaritalStatus();
			masMaritalStatus.setId(maritialStatus);
			masMedicalBoardProceedings.setMaritalStatus(masMaritalStatus);
		//	masMedicalBoardProceedings.setService(service);
			masMedicalBoardProceedings.setPNo(pNo);
	//		masMedicalBoardProceedings.setRank(rank);
			masMedicalBoardProceedings.setHoursOfFlown(hoursOfFlown);
			masMedicalBoardProceedings.setParmanentAddress(permanentAddress);
			masMedicalBoardProceedings.setIdentificationMarks1(identification1);
			masMedicalBoardProceedings.setIdentificationMarks2(identification2);
			masMedicalBoardProceedings.setArmsCorps(armsCrops);
			masMedicalBoardProceedings.setDateOfCompletion(dateOfCompletion);
			masMedicalBoardProceedings
					.setDocumentForwardDate(documentForwardDate);
			masMedicalBoardProceedings.setDateOfReporting(dateOfReporting);
			masMedicalBoardProceedings.setDocumentForwardTo(documentForwardTo);
			masMedicalBoardProceedings.setFromWhereHeReport(fromWhereHeReport);
			masMedicalBoardProceedings.setHypertension(hypertension);
			masMedicalBoardProceedings.setHeartDiabetes(heartDisease);
			masMedicalBoardProceedings.setDiabetes(diabetes);
			masMedicalBoardProceedings.setBleedingDisorder(bleedingDisorder);
			masMedicalBoardProceedings.setMentalDisease(mentalDisease);
			masMedicalBoardProceedings.setNightBlindness(nightBlindness);
			masMedicalBoardProceedings.setChronicBronchitis(asthama);
			masMedicalBoardProceedings.setDischargeFromEars(dischargeFrom);
			masMedicalBoardProceedings.setPleurisy(plesury);
			masMedicalBoardProceedings.setAnyOtherEarDisease(earDieses);
			masMedicalBoardProceedings
					.setRheumatismFrequentSorethroats(rheumatism);
			masMedicalBoardProceedings
					.setFrequentCoughColdSinusitis(frequentCough);
			masMedicalBoardProceedings
					.setChronicIndigestion(chronicIndigestion);
			masMedicalBoardProceedings
					.setNervousBreakdownMentalIllness(nervousBrakdown);
			masMedicalBoardProceedings.setKidneyBladderTrouble(kidenyBladder);
			masMedicalBoardProceedings
					.setFitsFaintingAttack(fitsFaintinngAttacks);
			masMedicalBoardProceedings.setStd(std);
			masMedicalBoardProceedings.setSevereHeadInjury(serveHeadInjury);
			masMedicalBoardProceedings.setJaundice(joundice);
			masMedicalBoardProceedings.setAirSeaCarTrainSickness(sickness);
			masMedicalBoardProceedings.setBreastDiseaseDischarge(breastDisease);
			masMedicalBoardProceedings.setTrachoma(trachoma);
			masMedicalBoardProceedings.setAmenorrhoeaDysmenonhoea(amenorrhoea);
			masMedicalBoardProceedings.setNightBindness(nightbindness);
			masMedicalBoardProceedings.setMenonhagia(menirrhagia);
			masMedicalBoardProceedings
					.setLaserTreatementSurgeryForEye(laserTeartement);
			masMedicalBoardProceedings.setPregnancy(pregnancy);
			masMedicalBoardProceedings.setAnyOtherEyeDisease(eyeDisease);
			masMedicalBoardProceedings.setAbortion(abortion);
			masMedicalBoardProceedings
					.setBeenrejectedAsMedicallyUnfitForAnyBranch(rejectedAsUnfit);
			masMedicalBoardProceedings
					.setDischargeAsMedicallyUnfitForAnyBranch(dischargeMedicallyUnfit);
			masMedicalBoardProceedings
					.setAdmittedInHospitalForAnyIllnessOperationOrInjury(adimmitedInHospitalFirIllness);

			masMedicalBoardProceedings
					.setStateTheNatureOfDiseaseDuration(stateNature);
			masMedicalBoardProceedings
					.setAnyOtherInformationAboutYourHealth(otherInform);
			masMedicalBoardProceedings.setHeight(height);
			masMedicalBoardProceedings.setWeight(weight);
			masMedicalBoardProceedings.setAcceptable(acceptableKg);
			masMedicalBoardProceedings.setLegLength(leglength);
			masMedicalBoardProceedings.setAppearance(appereance);
			masMedicalBoardProceedings.setAlbumin(albumin);
			masMedicalBoardProceedings.setSugar(sugar);
			masMedicalBoardProceedings.setSpGravity(spGraviry);
			masMedicalBoardProceedings.setHbPercentage(hbPercentage);
			masMedicalBoardProceedings.setAnyOtherInvCarriedOut(anyOtherInv);
			masMedicalBoardProceedings.setPhysique(physique);
			masMedicalBoardProceedings.setSkin(skin);
			masMedicalBoardProceedings.setAbdomen(abdomen);
			masMedicalBoardProceedings.setHeartSize(heartSize);
			masMedicalBoardProceedings.setSounds(sound);
			masMedicalBoardProceedings.setRhythm(rhythm);
			masMedicalBoardProceedings.setArterialWalls(arterialWalls);
			masMedicalBoardProceedings.setPulseRates(pulseRates);
			masMedicalBoardProceedings.setBp(bp);
			masMedicalBoardProceedings.setChestMeasurement(fullExpension);
			masMedicalBoardProceedings.setRangeOfExpension(rangeOfExpension);
			masMedicalBoardProceedings.setSelfBalancingR(selfBalR);
			masMedicalBoardProceedings.setSelfBalancingL(selfBalL);
			masMedicalBoardProceedings.setSpeechMentalCapacity(speechMental);
			masMedicalBoardProceedings.setEndocrineCondition(endocrinCond);
			masMedicalBoardProceedings
					.setAnyOtheAbnormalities(otherAbnormalities);
			masMedicalBoardProceedings.setRemarks(medicinRemarks);
			masMedicalBoardProceedings.setFingers(finger);
			masMedicalBoardProceedings.setHand(hand);
			masMedicalBoardProceedings.setWrists(wrist);
			masMedicalBoardProceedings.setElbows(elbows);
			masMedicalBoardProceedings.setShoulderGirdles(shoulderGridles);
			masMedicalBoardProceedings.setCervical(cercival);
			masMedicalBoardProceedings.setDorsalVertebrate(dorsalVertebrate);
			masMedicalBoardProceedings.setHullux(hullux);
			masMedicalBoardProceedings.setValgus(valgus);
			masMedicalBoardProceedings.setRigigus(riggus);
			masMedicalBoardProceedings.setFlatFeet(flatFeet);
			masMedicalBoardProceedings.setJoints(joints);
			masMedicalBoardProceedings.setPelvis(pelvis);
			masMedicalBoardProceedings.setGail(gail);
			masMedicalBoardProceedings.setLumber(lumberScaler);
			masMedicalBoardProceedings.setRoccyxVarocose(roccyxVericose);
			masMedicalBoardProceedings.setHydrocele(hydrocele);
			masMedicalBoardProceedings.setVaricocele(varicocele);
			masMedicalBoardProceedings.setUnderscendedTest(underScende);
			masMedicalBoardProceedings.setHemorrhoids(hemonhoids);
			masMedicalBoardProceedings.setHerniaMusic(herinaMusic);
			masMedicalBoardProceedings.setBreasts(breasts);
			masMedicalBoardProceedings.setRemarksLowerlimbs(surgeryRemarks);
			masMedicalBoardProceedings.setRespiratorySystem(respatorySystem);
			masMedicalBoardProceedings
					.setWithGlassesLDistant(withglassesDistantL);
			masMedicalBoardProceedings
					.setWithGlassesRDistant(withGlassesDistantR);
			masMedicalBoardProceedings
					.setWithoutGlassesLDistant(withoutGlassesDistantL);
			masMedicalBoardProceedings
					.setWthoutGlassesRDistant(withoutGlassesDistantR);
			masMedicalBoardProceedings
					.setWithGlassesLNearvision(withGlassesNearL);
			masMedicalBoardProceedings
					.setWithGlassesRNearvision(withGlassesNearR);
			masMedicalBoardProceedings
					.setWithoutGlassesLNearvision(withoutGlassesNearL);
			masMedicalBoardProceedings
					.setWithoutGlassesRNearvision(withoutGlassesNearR);
			masMedicalBoardProceedings
					.setEvidenceOfTrachoma(evidienceOfTrachoma);
			masMedicalBoardProceedings.setBinocularVisionGrade(binocular);
			masMedicalBoardProceedings
					.setManifestHypermetropia(manifestHypermetropia);
			masMedicalBoardProceedings.setCoverTest(coverTest);
			masMedicalBoardProceedings.setDiaphragmTest(diaphragmTest);
			masMedicalBoardProceedings.setFundAndMedia(fundMedia);
			masMedicalBoardProceedings.setFields(fields);
			masMedicalBoardProceedings
					.setNightVisualCapacity(nightVisualCapacity);
			masMedicalBoardProceedings.setConvergenceC(convergenceC);
			masMedicalBoardProceedings.setConvergenceSc(convergenceCP);
			masMedicalBoardProceedings.setAccommodationR(accommodationR);
			masMedicalBoardProceedings.setAccommodationL(accommodationL);
			masMedicalBoardProceedings.setRemarksSpecialExam(eyeRemarks);
			masMedicalBoardProceedings.setHearingRcv(hearingRCV);
			masMedicalBoardProceedings.setHearingLcv(hearingLCV);
			masMedicalBoardProceedings.setEarHearingRfw(hearingRFW);
			masMedicalBoardProceedings.setEarHearingLfw(hearingLFW);
			masMedicalBoardProceedings.setEarHearingBothFw(hearingBothFW);
			masMedicalBoardProceedings.setExternalEarR(externalEarR);
			masMedicalBoardProceedings.setExternalEarL(externalEarL);
			masMedicalBoardProceedings.setMiddleEarR(middleEarR);
			masMedicalBoardProceedings.setMiddleEar(middleEarL);

			masMedicalBoardProceedings.setInnerEarR(innerEarR);
			masMedicalBoardProceedings.setAudiometryRecord(audiometryRecord);
			masMedicalBoardProceedings.setNose(nose);
			masMedicalBoardProceedings.setThroat(throatEar);
			masMedicalBoardProceedings.setRemarksEar(earReamrks);
			masMedicalBoardProceedings.setEarDate(earDate);
			masMedicalBoardProceedings.setDateTeath(dentalDate);
			masMedicalBoardProceedings.setRemarksTeath(dentalRemarks);
			masMedicalBoardProceedings.setMenstrualHistory(menstrualHistory);
			masMedicalBoardProceedings.setNoOfPregnancies(noOfPregnancy);
			masMedicalBoardProceedings.setNoOfAbortions(noOfAbortion);
			masMedicalBoardProceedings.setNoOfChildren(noOfChildren);
			masMedicalBoardProceedings.setLastConfinementDate(lastCondinement);
			masMedicalBoardProceedings.setVaginalDischarge(vaginalDischarge);
			masMedicalBoardProceedings.setProlapse(prolapse);
			masMedicalBoardProceedings.setUsgAbdomen(usgAbortion);
			masMedicalBoardProceedings.setGynaecologyDate(gyanaecologyDate);
			masMedicalBoardProceedings
					.setRemarksGynaecology(gyanaecologyRemarks);
			masMedicalBoardProceedings
					.setMedicalBoardFindings(medicalBoardExamination);
			masMedicalBoardProceedings
					.setDateMedicalBoardExam(medicalBoardExaminationDate);
			//masMedicalBoardProceedings.setLmp(lmp);
			if (medicalBoardExaminationPlace != 0) {
				MasUnit masUnit1 = new MasUnit();
				masUnit1.setId(medicalBoardExaminationPlace);
				masMedicalBoardProceedings.setPlaceMedicalBoardExam(masUnit1);
			}
			masMedicalBoardProceedings
					.setMedicalBoardSubsequentFind(subsequentMedicalBoardExam);
			masMedicalBoardProceedings
					.setDateMedicalBoardSubsequent(subsequentMedicalBoardExamDate);
			if (subsequentMedicalBoardExamPlace != 0) {
				MasUnit masUnit2 = new MasUnit();
				masUnit2.setId(subsequentMedicalBoardExamPlace);
				masMedicalBoardProceedings
						.setPlaceMedicalBoardSubsequent(masUnit2);
			}
			masMedicalBoardProceedings
					.setApprovingAuthority(ApprovingAuthority);
			masMedicalBoardProceedings
					.setDateApprovingAuthority(ApprovingAuthorityDate);
			if (ApprovingAuthorityPlace != 0) {
				MasUnit masUnit3 = new MasUnit();
				masUnit3.setId(ApprovingAuthorityPlace);
				masMedicalBoardProceedings.setPlaceApprovingAuthority(masUnit3);
			}
			masMedicalBoardProceedings.setSurgeryDate(surgeyDate);
			masMedicalBoardProceedings.setMediceExamDate(medicinExamDate);
			masMedicalBoardProceedings
					.setNearVisionWithGlassCp(withGlassesNearCP);
			masMedicalBoardProceedings
					.setNearVisionWithoutGlassCp(withoutGlassesNearCP);
			masMedicalBoardProceedings.setUR1(sur1);
			masMedicalBoardProceedings.setUR2(sur2);
			masMedicalBoardProceedings.setUR3(sur3);
			masMedicalBoardProceedings.setUR4(sur4);
			masMedicalBoardProceedings.setUR5(sur5);
			masMedicalBoardProceedings.setUR6(sur6);
			masMedicalBoardProceedings.setUR7(sur7);
			masMedicalBoardProceedings.setUR8(sur8);

			masMedicalBoardProceedings.setUL1(sul1);
			masMedicalBoardProceedings.setUL2(sul2);
			masMedicalBoardProceedings.setUL3(sul3);
			masMedicalBoardProceedings.setUL4(sul4);
			masMedicalBoardProceedings.setUL5(sul5);
			masMedicalBoardProceedings.setUL6(sul6);
			masMedicalBoardProceedings.setUL7(sul7);
			masMedicalBoardProceedings.setUL8(sul8);

			masMedicalBoardProceedings.setLR1(slr1);
			masMedicalBoardProceedings.setLR2(slr2);
			masMedicalBoardProceedings.setLR3(slr3);
			masMedicalBoardProceedings.setLR4(slr4);
			masMedicalBoardProceedings.setLR5(slr5);
			masMedicalBoardProceedings.setLR6(slr6);
			masMedicalBoardProceedings.setLR7(slr7);
			masMedicalBoardProceedings.setLR8(slr8);

			masMedicalBoardProceedings.setLL1(sll1);
			masMedicalBoardProceedings.setLL2(sll2);
			masMedicalBoardProceedings.setLL3(sll3);
			masMedicalBoardProceedings.setLL4(sll4);
			masMedicalBoardProceedings.setLL5(sll5);
			masMedicalBoardProceedings.setLL6(sll6);
			masMedicalBoardProceedings.setLL7(sll7);
			masMedicalBoardProceedings.setLL8(sll8);
			masMedicalBoardProceedings.setLastChangedBy(lastChangedBy);
			masMedicalBoardProceedings.setLastChangedDate(lastChangedDate);
			masMedicalBoardProceedings.setLastChangedTime(lastChangedTime);

			successfullyAdded = medicalExaminationBoardHandlerService
					.addMedicalExaminationBoard(masMedicalBoardProceedings,
							masMedicalBoardDetails);
			message = "Record Added Successfully!Do You Want To Print !!";
			jsp = MEDICAL_BOARD_EXAM_MSG;
			if (!successfullyAdded) {
				message = "There is already an same entry for this Batch no and Chest no!!";
				jsp = MEDICAL_BOARD_ERROR_MSG;
			}
		}
		try {
			map = medicalExaminationBoardHandlerService
					.showMedicalExaminationBoardJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String medicalEntryNo = "";
		String medicalEntryNo1 = "";
		String userName = "";
		String userName1 = "";
		medicalEntryNo = medicalExaminationBoardHandlerService
				.generateMedicalEntryNumber(userName);
		medicalEntryNo1 = medicalExaminationBoardHandlerService
				.generateMedicalEntryNumber1(userName1);
		jsp += ".jsp";
		map.put("medicalEntryNo", medicalEntryNo);
		map.put("medicalEntryNo1", medicalEntryNo1);
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ////////////////////////////////////////////////////////////////////////////////////
	// search
	// /////////////////////////////////////////////////////////////////////////////////////

	Map<String, Object> map = new HashMap<String, Object>();

	public ModelAndView showMedicalExaminationBoardsSearchJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		String title = "";

		map = medicalExaminationBoardHandlerService
				.showMedicalExaminationBoardsSearchJsp();

		jsp = MEDICAL_EXAM_SEARCH_JSP;

		jsp += ".jsp";
		title = "Medical Examination Board Search";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printMedicalExaminationBoardsSearchJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		String title = "";

		map = medicalExaminationBoardHandlerService
				.showMedicalExaminationBoardsSearchJsp();

		jsp = RequestConstants.MEDICAL_BOARD_EXAM_PRINT_JSP;

		jsp += ".jsp";
		title = "Medical Examination Print";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchMedicalExaminationBoardSearch(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();

		String jsp = "";
		String title = "";
		MedicalExaminationBoardSearchDTO medicalExaminationBoardSearchDTO = new MedicalExaminationBoardSearchDTO();

		if (request.getParameter(YEARLY_SERIAL_NO) != null
				&& !(request.getParameter(YEARLY_SERIAL_NO).equals(""))) {
			medicalExaminationBoardSearchDTO.setYearlySearialNo(request
					.getParameter(YEARLY_SERIAL_NO));
		}
		if (request.getParameter(BATCH_NO) != null
				&& !(request.getParameter(BATCH_NO).equals(""))) {
			medicalExaminationBoardSearchDTO.setBatchNo(request
					.getParameter(BATCH_NO));

		}
		if (request.getParameter(CHEST_NO) != null
				&& !(request.getParameter(CHEST_NO).equals(""))) {
			medicalExaminationBoardSearchDTO.setChestNo(request
					.getParameter(CHEST_NO));
		}
		if (request.getParameter(ROLL_NO) != null
				&& !(request.getParameter(ROLL_NO).equals(""))) {
			medicalExaminationBoardSearchDTO.setRollNo(request
					.getParameter(ROLL_NO));
		}
		if (request.getParameter(SERVICE) != null
				&& !(request.getParameter(SERVICE).equals(""))) {
			medicalExaminationBoardSearchDTO.setService(request
					.getParameter(SERVICE));
		}
		String flag = "";
		if (request.getParameter(RequestConstants.FLAG_FOR_PRINT) != null
				&& !(request.getParameter(RequestConstants.FLAG_FOR_PRINT)
						.equals(""))) {
			flag = request.getParameter(RequestConstants.FLAG_FOR_PRINT);
		}
		if (flag.equalsIgnoreCase("y")) {
			jsp = RequestConstants.MEDICAL_BOARD_EXAM_PRINT_JSP;
		} else {
			jsp = MEDICAL_EXAM_SEARCH_JSP;
		}
		map = medicalExaminationBoardHandlerService
				.searchMedicalExaminationBoardSearch(medicalExaminationBoardSearchDTO);

		jsp += ".jsp";

		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Medical Examination Board Update Entry
	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private int instructionToCandidateId;

	public ModelAndView showMedicalExaminationBoardUpdateJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";

		String userName1 = "";
		Map map = new HashMap();
		String sampleCollectionDetailId = request
				.getParameter("sampleCollectionDetailId");
		int Id = Integer.parseInt(sampleCollectionDetailId);

		map = medicalExaminationBoardHandlerService
				.showMedicalExaminationBoardUpdateJsp(Id);
		jsp = MEDICAL_EXAMINATION_BOARD_UPDATE_JSP;

		jsp += ".jsp";
		// title = "complaint";
		map.put("contentJsp", jsp);

		// map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView medicalExaminationBoardUpdateToDatabase(
			HttpServletRequest req, HttpServletResponse res) {
		Box box = HMSUtil.getBox(req);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		String yearlySerialNo = "";
		Date entryDate = null;
		int typeOfEntry = 0;
		String betchNo = "";
		String chestNo = "";
		String rollNo = "";
		int medicalExamHeld = 0;
		String medicalStatus = "";
		String fullName = "";
		Date dateOfBirth = null;
		int maritialStatus = 0;
		String service = "";
		String pNo = "";
		String rank = "";
		String hoursOfFlown = "";
		String permanentAddress = "";
		String identification1 = "";
		String identification2 = "";
		String armsCrops = "";
		Date dateOfReporting = null;
		Date dateOfCompletion = null;
		Date documentForwardDate = null;
		String documentForwardTo = "";
		String fromWhereHeReport = "";
		int srNo = 0;
		String Relation = "";
		String age = "";
		String health = "";
		String couseOfDeath = "";
		String died = "";
		String hypertension = "";
		String heartDisease = "";
		String diabetes = "";
		String bleedingDisorder = "";
		String mentalDisease = "";
		String nightBlindness = "";

		String asthama = "";
		String dischargeFrom = "";
		String plesury = "";
		String earDieses = "";
		String rheumatism = "";
		String frequentCough = "";
		String chronicIndigestion = "";
		String nervousBrakdown = "";
		String kidenyBladder = "";
		String fitsFaintinngAttacks = "";
		String std = "";
		String serveHeadInjury = "";
		String joundice = "";
		String sickness = "";
		String breastDisease = "";
		String trachoma = "";
		String amenorrhoea = "";
		String nightbindness = "";
		String menirrhagia = "";
		String laserTeartement = "";
		String pregnancy = "";
		String abortion = "";
		String eyeDisease = "";
		String rejectedAsUnfit = "";
		String dischargeMedicallyUnfit = "";
		String adimmitedInHospitalFirIllness = "";
		String stateNature = "";
		String otherInform = "";
		BigDecimal height = new BigDecimal(0);
		BigDecimal weight = new BigDecimal(0);
		BigDecimal acceptableKg = new BigDecimal(0);
		BigDecimal leglength = new BigDecimal(0);
		String appereance = "";
		String albumin = "";
		String sugar = "";
		String spGraviry = "";
		String hbPercentage = "";
		String physique = "";
		String anyOtherInv = "";
		String skin = "";
		String abdomen = "";
		String heartSize = "";
		String sound = "";
		String rhythm = "";
		String arterialWalls = "";
		String pulseRates = "";
		String bp = "";
		String fullExpension = "";
		String rangeOfExpension = "";
		String selfBalR = "";
		String selfBalL = "";
		String speechMental = "";
		String endocrinCond = "";
		String otherAbnormalities = "";
		String medicinRemarks = "";
		String finger = "";
		String hand = "";
		String wrist = "";
		String elbows = "";
		String shoulderGridles = "";
		String cercival = "";
		String dorsalVertebrate = "";
		String hullux = "";
		String valgus = "";
		String riggus = "";
		String flatFeet = "";
		String joints = "";
		String pelvis = "";
		String gail = "";
		String lumberScaler = "";
		String roccyxVericose = "";
		String hydrocele = "";
		String varicocele = "";
		String underScende = "";
		String hemonhoids = "";
		String herinaMusic = "";
		String breasts = "";
		String surgeryRemarks = "";
		String respatorySystem = "";
		String message = "";
		String jsp = "";
		String url = "";
		String title = "";
		String withGlassesDistantR = "";
		String withglassesDistantL = "";
		String withGlassesNearR = "";
		String withGlassesNearL = "";
		String withGlassesNearCP = "";
		String withoutGlassesDistantR = "";
		String withoutGlassesDistantL = "";
		String withoutGlassesNearR = "";
		String withoutGlassesNearL = "";
		String withoutGlassesNearCP = "";
		BigDecimal convergenceCP = new BigDecimal(0);

		BigDecimal convergenceC = new BigDecimal(0);
		String accommodationR = "";
		String accommodationL = "";
		String eyeRemarks = "";
		Date eyeDate = null;
		BigDecimal hearingRFW = new BigDecimal(0);
		BigDecimal hearingLFW = new BigDecimal(0);
		BigDecimal hearingBothFW = new BigDecimal(0);
		BigDecimal hearingRCV = new BigDecimal(0);
		BigDecimal hearingLCV = new BigDecimal(0);
		BigDecimal hearingBothCV = new BigDecimal(0);

		String innerEarR = "";
		String innerEarL = "";
		String audiometryRecord = "";
		String nose = "";
		String throatEar = "";
		String earReamrks = "";
		Date earDate = null;
		String totalTeeth = "";
		String totalDefectiveTeeth = "";
		String missingTeeth = "";
		String DenstalPoint = "";
		String unserviceableTeeth = "";
		String externalEarR = "";
		String externalEarL = "";
		String middleEarR = "";
		String middleEarL = "";
		String evidienceOfTrachoma = "";
		String binocular = "";
		String manifestHypermetropia = "";
		String coverTest = "";
		String diaphragmTest = "";
		String fundMedia = "";
		String fields = "";
		String nightVisualCapacity = "";

		String dentalRemarks = "";
		Date dentalDate = null;
		String menstrualHistory = "";
		int noOfPregnancy = 0;
		int noOfAbortion = 0;
		int noOfChildren = 0;
		Date lastCondinement = null;
		String vaginalDischarge = "";
		String prolapse = "";
		String usgAbortion = "";
		String gyanaecologyRemarks = "";
		Date gyanaecologyDate = null;
		String medicalBoardExamination = "";
		int medicalBoardExaminationPlace = 0;
		Date medicalBoardExaminationDate = null;
		String subsequentMedicalBoardExam = "";
		int subsequentMedicalBoardExamPlace = 0;
		Date subsequentMedicalBoardExamDate = null;
		String ApprovingAuthority = "";
		int ApprovingAuthorityPlace = 0;
		Date ApprovingAuthorityDate = null;
		String lmp = "";

		Date medicinExamDate = null;
		Date surgeyDate = null;
		@SuppressWarnings("unchecked")
		String dur8 = "";
		String dur7 = "";
		String dur6 = "";
		String dur5 = "";
		String dur4 = "";
		String dur3 = "";
		String dur2 = "";
		String dur1 = "";
		String dul8 = "";
		String dul7 = "";
		String dul6 = "";
		String dul5 = "";
		String dul4 = "";
		String dul3 = "";
		String dul2 = "";
		String dul1 = "";
		String dlr8 = "";
		String dlr7 = "";
		String dlr6 = "";
		String dlr5 = "";
		String dlr4 = "";
		String dlr3 = "";
		String dlr2 = "";
		String dlr1 = "";
		String dll8 = "";
		String dll7 = "";
		String dll6 = "";
		String dll5 = "";
		String dll4 = "";
		String dll3 = "";
		String dll2 = "";
		String dll1 = "";
		String mur8 = "";
		String mur7 = "";
		String mur6 = "";
		String mur5 = "";
		String mur4 = "";
		String mur3 = "";
		String mur2 = "";
		String mur1 = "";
		String mul8 = "";
		String mul7 = "";
		String mul6 = "";
		String mul5 = "";
		String mul4 = "";
		String mul3 = "";
		String mul2 = "";
		String mul1 = "";
		String mlr8 = "";
		String mlr7 = "";
		String mlr6 = "";
		String mlr5 = "";
		String mlr4 = "";
		String mlr3 = "";
		String mlr2 = "";
		String mlr1 = "";
		String mll8 = "";
		String mll7 = "";
		String mll6 = "";
		String mll5 = "";
		String mll4 = "";
		String mll3 = "";
		String mll2 = "";
		String mll1 = "";
		String uur8 = "";
		String uur7 = "";
		String uur6 = "";
		String uur5 = "";
		String uur4 = "";
		String uur3 = "";
		String uur2 = "";
		String uur1 = "";
		String uul8 = "";
		String uul7 = "";
		String uul6 = "";
		String uul5 = "";
		String uul4 = "";
		String uul3 = "";
		String uul2 = "";
		String uul1 = "";
		String ulr8 = "";
		String ulr7 = "";
		String ulr6 = "";
		String ulr5 = "";
		String ulr4 = "";
		String ulr3 = "";
		String ulr2 = "";
		String ulr1 = "";
		String ull8 = "";
		String ull7 = "";
		String ull6 = "";
		String ull5 = "";
		String ull4 = "";
		String ull3 = "";
		String ull2 = "";
		String ull1 = "";

		String sur8 = "";
		String sur7 = "";
		String sur6 = "";
		String sur5 = "";
		String sur4 = "";
		String sur3 = "";
		String sur2 = "";
		String sur1 = "";
		String sul8 = "";
		String sul7 = "";
		String sul6 = "";
		String sul5 = "";
		String sul4 = "";
		String sul3 = "";
		String sul2 = "";
		String sul1 = "";

		String slr8 = "";
		String slr7 = "";
		String slr6 = "";
		String slr5 = "";
		String slr4 = "";
		String slr3 = "";
		String slr2 = "";
		String slr1 = "";
		String sll8 = "";
		String sll7 = "";
		String sll6 = "";

		String sll5 = "";
		String sll4 = "";
		String sll3 = "";
		String sll2 = "";
		String sll1 = "";
		int Id = 0;

		List<MedicalExaminationBoardDTO> medicalExaminationBoardDTOList = new ArrayList<MedicalExaminationBoardDTO>();
		List<MasMedicalBoardExaminationDetail> masMedicalExaminationBoardDetails = new ArrayList<MasMedicalBoardExaminationDetail>();

		Vector<String> v1 = box.getVector(MEDICAL_BOARD_DETAILS_ID);

		Vector<String> v2 = box.getVector(RELATION);

		Vector<String> v3 = box.getVector(AGE);

		Vector<String> v4 = box.getVector(HEALTH);

		Vector<String> v5 = box.getVector(CAUSE_OF_DEATH);

		Vector<String> v6 = box.getVector(DIED);

		Vector<String> v7 = box.getVector(SIRIAL_NO);

		for (int i = 0; i < v2.size(); i++) {
			MedicalExaminationBoardDTO medicalExaminationBoardDTO = new MedicalExaminationBoardDTO();
			medicalExaminationBoardDTO.setId(v1.get(i));

			medicalExaminationBoardDTO.setRelation(v2.get(i));
			medicalExaminationBoardDTO.setAge((v3.get(i)));
			medicalExaminationBoardDTO.setHealth(v4.get(i));
			medicalExaminationBoardDTO.setCouseOfDeath(v5.get(i));
			medicalExaminationBoardDTO.setDied(v6.get(i));
			medicalExaminationBoardDTO.setSrNo(v7.get(i));

			medicalExaminationBoardDTOList.add(medicalExaminationBoardDTO);

		}

		if (req.getParameter(ENTRY_OF_DATE) != null
				&& !(req.getParameter(ENTRY_OF_DATE).equals(""))) {
			entryDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(ENTRY_OF_DATE));
		}
		if (req.getParameter(TYPE_OF_ENTRY) != null
				&& !(req.getParameter(TYPE_OF_ENTRY).equals(""))) {
			typeOfEntry = Integer.parseInt(req.getParameter(TYPE_OF_ENTRY));
		}
		if (req.getParameter(BATCH1_NO) != null
				&& !(req.getParameter(BATCH1_NO).equals(""))) {
			betchNo = req.getParameter(BATCH1_NO);
		}
		if (req.getParameter(CHEST_NO) != null
				&& !(req.getParameter(CHEST_NO).equals(""))) {
			chestNo = req.getParameter(CHEST_NO);
		}

		if (req.getParameter(ROLL_NO) != null
				&& !(req.getParameter(ROLL_NO).equals(""))) {
			rollNo = req.getParameter(ROLL_NO);
		}

		if (req.getParameter(MEDICAL_EXAM_HELD_AT) != null
				&& !(req.getParameter(MEDICAL_EXAM_HELD_AT).equals(""))) {
			medicalExamHeld = Integer.parseInt(req
					.getParameter(MEDICAL_EXAM_HELD_AT));
		}

		if (req.getParameter(MEDICAL_STATUS) != null
				&& !(req.getParameter(MEDICAL_STATUS).equals(""))) {
			medicalStatus = req.getParameter(MEDICAL_STATUS);
		}
		if (req.getParameter(FULL_NAME) != null
				&& !(req.getParameter(FULL_NAME).equals(""))) {
			fullName = req.getParameter(FULL_NAME);
		}

		if (req.getParameter(DATE_OF_BIRTH) != null
				&& !(req.getParameter(DATE_OF_BIRTH).equals(""))) {
			dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DATE_OF_BIRTH));
		}

		if (req.getParameter(MARITIAL_STATUS) != null
				&& !(req.getParameter(MARITIAL_STATUS).equals(""))) {
			maritialStatus = Integer
					.parseInt(req.getParameter(MARITIAL_STATUS));
		}

		if (req.getParameter(SERVICE) != null
				&& !(req.getParameter(SERVICE).equals(""))) {
			service = req.getParameter(SERVICE);
		}

		if (req.getParameter(P_NO) != null
				&& !(req.getParameter(P_NO).equals(""))) {
			pNo = req.getParameter(P_NO);
		}

		if (req.getParameter(RANK) != null
				&& !(req.getParameter(RANK).equals(""))) {
			rank = req.getParameter(RANK);
		}

		if (req.getParameter(HOURS_OF_FLOWN) != null
				&& !(req.getParameter(HOURS_OF_FLOWN).equals(""))) {
			hoursOfFlown = req.getParameter(HOURS_OF_FLOWN);
		}
		if (req.getParameter(PERMANENT_ADDRESS) != null
				&& !(req.getParameter(PERMANENT_ADDRESS).equals(""))) {
			permanentAddress = req.getParameter(PERMANENT_ADDRESS);
		}

		if (req.getParameter(IDENTIFICATION_MARKS1) != null
				&& !(req.getParameter(IDENTIFICATION_MARKS1).equals(""))) {
			identification1 = req.getParameter(IDENTIFICATION_MARKS1);
		}

		if (req.getParameter(IDENTIFICATION_MARKS2) != null
				&& !(req.getParameter(IDENTIFICATION_MARKS2).equals(""))) {
			identification2 = req.getParameter(IDENTIFICATION_MARKS2);
		}

		if (req.getParameter(ARMS_CROPS) != null
				&& !(req.getParameter(ARMS_CROPS).equals(""))) {
			armsCrops = req.getParameter(ARMS_CROPS);
		}

		if (req.getParameter(DATE_OF_COMPLETION) != null
				&& !(req.getParameter(DATE_OF_COMPLETION).equals(""))) {
			dateOfCompletion = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DATE_OF_COMPLETION));
		}

		if (req.getParameter(DOCUMENT_FORWARD_DATE) != null
				&& !(req.getParameter(DOCUMENT_FORWARD_DATE).equals(""))) {
			documentForwardDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DOCUMENT_FORWARD_DATE));

		}

		if (req.getParameter(DOCUMENT_FORWARD_TO) != null
				&& !(req.getParameter(DOCUMENT_FORWARD_TO).equals(""))) {
			documentForwardTo = req.getParameter(DOCUMENT_FORWARD_TO);
		}
		if (req.getParameter(DATE_OF_REPORTING) != null
				&& !(req.getParameter(DATE_OF_REPORTING).equals(""))) {
			dateOfReporting = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DATE_OF_REPORTING));
		}

		if (req.getParameter(FROM_WHERE_HE_REPORT) != null
				&& !(req.getParameter(FROM_WHERE_HE_REPORT).equals(""))) {
			fromWhereHeReport = req.getParameter(FROM_WHERE_HE_REPORT);
		}
		if (req.getParameter(HYPERTENSION) != null
				&& !(req.getParameter(HYPERTENSION).equals(""))) {
			hypertension = req.getParameter(HYPERTENSION);
		}
		if (req.getParameter(HEAR_DISEASE) != null
				&& !(req.getParameter(HEAR_DISEASE).equals(""))) {
			heartDisease = req.getParameter(HEAR_DISEASE);
		}
		if (req.getParameter(DIABETES) != null
				&& !(req.getParameter(DIABETES).equals(""))) {
			diabetes = req.getParameter(DIABETES);
		}
		if (req.getParameter(BLEEDING_DIORDER) != null
				&& !(req.getParameter(BLEEDING_DIORDER).equals(""))) {
			bleedingDisorder = req.getParameter(BLEEDING_DIORDER);
		}
		if (req.getParameter(MENTAL_DISEASE) != null
				&& !(req.getParameter(MENTAL_DISEASE).equals(""))) {
			mentalDisease = req.getParameter(MENTAL_DISEASE);
		}
		if (req.getParameter(NIGHT_BLINDNESS) != null
				&& !(req.getParameter(NIGHT_BLINDNESS).equals(""))) {
			nightBlindness = req.getParameter(NIGHT_BLINDNESS);
		}

		if (req.getParameter(ASTHAMA) != null
				&& !(req.getParameter(ASTHAMA).equals(""))) {
			asthama = req.getParameter(ASTHAMA);
		}

		if (req.getParameter(DISCHARGE_FROM) != null
				&& !(req.getParameter(DISCHARGE_FROM).equals(""))) {
			dischargeFrom = req.getParameter(DISCHARGE_FROM);

		}

		if (req.getParameter(PLEURISY) != null
				&& !(req.getParameter(PLEURISY).equals(""))) {
			plesury = req.getParameter(PLEURISY);
		}

		if (req.getParameter(EAR_DISEASE) != null
				&& !(req.getParameter(EAR_DISEASE).equals(""))) {
			earDieses = req.getParameter(EAR_DISEASE);
		}

		if (req.getParameter(RHEUMATISM) != null
				&& !(req.getParameter(RHEUMATISM).equals(""))) {
			rheumatism = req.getParameter(RHEUMATISM);
		}
		if (req.getParameter(FREQUENT_CAUGH) != null
				&& !(req.getParameter(FREQUENT_CAUGH).equals(""))) {
			frequentCough = req.getParameter(FREQUENT_CAUGH);
		}

		if (req.getParameter(CHRONIC_INDIGESTION) != null
				&& !(req.getParameter(CHRONIC_INDIGESTION).equals(""))) {
			chronicIndigestion = req.getParameter(CHRONIC_INDIGESTION);
		}
		if (req.getParameter(NERVOUS_BRAKDOWN) != null
				&& !(req.getParameter(NERVOUS_BRAKDOWN).equals(""))) {
			nervousBrakdown = req.getParameter(NERVOUS_BRAKDOWN);
		}

		if (req.getParameter(KIDENY_BLADDER) != null
				&& !(req.getParameter(KIDENY_BLADDER).equals(""))) {
			kidenyBladder = req.getParameter(KIDENY_BLADDER);
		}
		if (req.getParameter(FITS_FAINTING_ATTACKS) != null
				&& !(req.getParameter(FITS_FAINTING_ATTACKS).equals(""))) {
			fitsFaintinngAttacks = req.getParameter(FITS_FAINTING_ATTACKS);
		}
		if (req.getParameter(STD) != null
				&& !(req.getParameter(STD).equals(""))) {
			std = req.getParameter(STD);
		}

		if (req.getParameter(SEVERE_HEAD_INJURY) != null
				&& !(req.getParameter(SEVERE_HEAD_INJURY).equals(""))) {
			serveHeadInjury = req.getParameter(SEVERE_HEAD_INJURY);
		}

		if (req.getParameter(JOUNDICE) != null
				&& !(req.getParameter(JOUNDICE).equals(""))) {
			joundice = req.getParameter(JOUNDICE);
		}
		if (req.getParameter(SICKNESS) != null
				&& !(req.getParameter(SICKNESS).equals(""))) {
			sickness = req.getParameter(SICKNESS);
		}
		if (req.getParameter(BREAST_DISEASE) != null
				&& !(req.getParameter(BREAST_DISEASE).equals(""))) {
			breastDisease = req.getParameter(BREAST_DISEASE);
		}
		if (req.getParameter(TRACHOMA) != null
				&& !(req.getParameter(TRACHOMA).equals(""))) {
			trachoma = req.getParameter(TRACHOMA);
		}

		if (req.getParameter(AMENORRHOEA) != null
				&& !(req.getParameter(AMENORRHOEA).equals(""))) {
			amenorrhoea = req.getParameter(AMENORRHOEA);
		}
		if (req.getParameter(NIGHT_BINDNESS) != null
				&& !(req.getParameter(NIGHT_BINDNESS).equals(""))) {
			nightbindness = req.getParameter(NIGHT_BINDNESS);
		}
		if (req.getParameter(MENORRHAGIA) != null
				&& !(req.getParameter(MENORRHAGIA).equals(""))) {
			menirrhagia = req.getParameter(MENORRHAGIA);
		}
		if (req.getParameter(LASER_TREATEMENT) != null
				&& !(req.getParameter(LASER_TREATEMENT).equals(""))) {
			laserTeartement = req.getParameter(LASER_TREATEMENT);
		}
		if (req.getParameter(PREGNANCY) != null
				&& !(req.getParameter(PREGNANCY).equals(""))) {
			pregnancy = req.getParameter(PREGNANCY);
		}
		if (req.getParameter(EYE_DISEASE) != null
				&& !(req.getParameter(EYE_DISEASE).equals(""))) {
			eyeDisease = req.getParameter(EYE_DISEASE);
		}
		if (req.getParameter(REJECTED_AS_UNFIT) != null
				&& !(req.getParameter(REJECTED_AS_UNFIT).equals(""))) {
			rejectedAsUnfit = req.getParameter(REJECTED_AS_UNFIT);
		}
		if (req.getParameter(DISCHARGE_MEDICALLY_UNFIT) != null
				&& !(req.getParameter(DISCHARGE_MEDICALLY_UNFIT).equals(""))) {
			dischargeMedicallyUnfit = req
					.getParameter(DISCHARGE_MEDICALLY_UNFIT);
		}
		if (req.getParameter(ADIMMITED_IN_HOSPITAL_FOR_ILLNESS) != null
				&& !(req.getParameter(ADIMMITED_IN_HOSPITAL_FOR_ILLNESS)
						.equals(""))) {
			adimmitedInHospitalFirIllness = req
					.getParameter(ADIMMITED_IN_HOSPITAL_FOR_ILLNESS);
		}
		if (req.getParameter(ABORTION) != null
				&& !(req.getParameter(ABORTION).equals(""))) {
			abortion = req.getParameter(ABORTION);
		}

		if (req.getParameter(STATE_NATURE_OF_THE_DISEASE) != null
				&& !(req.getParameter(STATE_NATURE_OF_THE_DISEASE).equals(""))) {
			stateNature = req.getParameter(STATE_NATURE_OF_THE_DISEASE);
		}
		if (req.getParameter(OTHER_INFORMATION) != null
				&& !(req.getParameter(OTHER_INFORMATION).equals(""))) {
			otherInform = req.getParameter(OTHER_INFORMATION);
		}
		if (req.getParameter(HEIGHT_WITHOUT_SHOOSE) != null
				&& !(req.getParameter(HEIGHT_WITHOUT_SHOOSE).equals(""))) {
			height = (new BigDecimal(req.getParameter(HEIGHT_WITHOUT_SHOOSE)));
		}
		if (req.getParameter(ACTUAL_WEIGHT) != null
				&& !(req.getParameter(ACTUAL_WEIGHT).equals(""))) {
			weight = (new BigDecimal(req.getParameter(ACTUAL_WEIGHT)));
		}
		if (req.getParameter(ACCEPTABLE_KG) != null
				&& !(req.getParameter(ACCEPTABLE_KG).equals(""))) {
			acceptableKg = (new BigDecimal(req.getParameter(ACCEPTABLE_KG)));
		}
		if (req.getParameter(LEG_LENGTH) != null
				&& !(req.getParameter(LEG_LENGTH).equals(""))) {
			leglength = (new BigDecimal(req.getParameter(LEG_LENGTH)));
		}
		if (req.getParameter(APPEREANCE) != null
				&& !(req.getParameter(APPEREANCE).equals(""))) {
			appereance = req.getParameter(APPEREANCE);
		}
		if (req.getParameter(ALBUMIN) != null
				&& !(req.getParameter(ALBUMIN).equals(""))) {
			albumin = req.getParameter(ALBUMIN);
		}
		if (req.getParameter(SUGAR) != null
				&& !(req.getParameter(SUGAR).equals(""))) {
			sugar = req.getParameter(SUGAR);
		}
		if (req.getParameter(SP_GRAVITY) != null
				&& !(req.getParameter(SP_GRAVITY).equals(""))) {
			spGraviry = req.getParameter(SP_GRAVITY);
		}
		if (req.getParameter(HB_PERCENTAGE) != null
				&& !(req.getParameter(HB_PERCENTAGE).equals(""))) {
			hbPercentage = req.getParameter(HB_PERCENTAGE);
		}
		if (req.getParameter(PHYSIQUE) != null
				&& !(req.getParameter(PHYSIQUE).equals(""))) {
			physique = req.getParameter(PHYSIQUE);
		}

		if (req.getParameter(ANYOTHER_INV_CARRIED_OUT) != null
				&& !(req.getParameter(ANYOTHER_INV_CARRIED_OUT).equals(""))) {
			anyOtherInv = req.getParameter(ANYOTHER_INV_CARRIED_OUT);
		}
		if (req.getParameter(SKIN) != null
				&& !(req.getParameter(SKIN).equals(""))) {
			skin = req.getParameter(SKIN);
		}
		if (req.getParameter(ABDOMEN) != null
				&& !(req.getParameter(ABDOMEN).equals(""))) {
			abdomen = req.getParameter(ABDOMEN);
		}
		if (req.getParameter(HEART_SIZE) != null
				&& !(req.getParameter(HEART_SIZE).equals(""))) {
			heartSize = req.getParameter(HEART_SIZE);
		}
		if (req.getParameter(SOUND) != null
				&& !(req.getParameter(SOUND).equals(""))) {
			sound = req.getParameter(SOUND);
		}
		if (req.getParameter(RHYTHM) != null
				&& !(req.getParameter(RHYTHM).equals(""))) {
			rhythm = req.getParameter(RHYTHM);
		}
		if (req.getParameter(ARTERIAL_WALLS) != null
				&& !(req.getParameter(ARTERIAL_WALLS).equals(""))) {
			arterialWalls = req.getParameter(ARTERIAL_WALLS);
		}
		if (req.getParameter(PULSE_RATES) != null
				&& !(req.getParameter(PULSE_RATES).equals(""))) {
			pulseRates = req.getParameter(PULSE_RATES);
		}
		if (req.getParameter(BP1) != null
				&& !(req.getParameter(BP1).equals(""))) {
			bp = req.getParameter(BP1);
		}
		if (req.getParameter(FULL_EXPENSION) != null
				&& !(req.getParameter(FULL_EXPENSION).equals(""))) {
			fullExpension = req.getParameter(FULL_EXPENSION);
		}
		if (req.getParameter(RANGE_OF_EXPENSION) != null
				&& !(req.getParameter(RANGE_OF_EXPENSION).equals(""))) {
			rangeOfExpension = req.getParameter(RANGE_OF_EXPENSION);
		}

		if (req.getParameter(SELF_BALANCINF_R) != null
				&& !(req.getParameter(SELF_BALANCINF_R).equals(""))) {
			selfBalR = req.getParameter(SELF_BALANCINF_R);
		}
		if (req.getParameter(SELF_BALANCING_L) != null
				&& !(req.getParameter(SELF_BALANCING_L).equals(""))) {
			selfBalL = req.getParameter(SELF_BALANCING_L);
		}
		if (req.getParameter(SPEECH_MENTAL_CAPACITY) != null
				&& !(req.getParameter(SPEECH_MENTAL_CAPACITY).equals(""))) {
			speechMental = req.getParameter(SPEECH_MENTAL_CAPACITY);
		}
		if (req.getParameter(ENDOCRINE_CONDITION) != null
				&& !(req.getParameter(ENDOCRINE_CONDITION).equals(""))) {
			endocrinCond = req.getParameter(ENDOCRINE_CONDITION);
		}
		if (req.getParameter(OTHER_ABNORMALITIES) != null
				&& !(req.getParameter(OTHER_ABNORMALITIES).equals(""))) {
			otherAbnormalities = req.getParameter(OTHER_ABNORMALITIES);
		}
		if (req.getParameter(MEDICIN_REMARKS) != null
				&& !(req.getParameter(MEDICIN_REMARKS).equals(""))) {
			medicinRemarks = req.getParameter(MEDICIN_REMARKS);
		}
		if (req.getParameter(FINGER) != null
				&& !(req.getParameter(FINGER).equals(""))) {
			finger = req.getParameter(FINGER);
		}
		if (req.getParameter(HAND) != null
				&& !(req.getParameter(HAND).equals(""))) {
			hand = req.getParameter(HAND);
		}
		if (req.getParameter(WRIST) != null
				&& !(req.getParameter(WRIST).equals(""))) {
			wrist = req.getParameter(WRIST);
		}
		if (req.getParameter(ELBOWS) != null
				&& !(req.getParameter(ELBOWS).equals(""))) {
			elbows = req.getParameter(ELBOWS);
		}
		if (req.getParameter(SHOULDER_GIRDLES) != null
				&& !(req.getParameter(SHOULDER_GIRDLES).equals(""))) {
			shoulderGridles = req.getParameter(SHOULDER_GIRDLES);
		}
		if (req.getParameter(CERCIVAL) != null
				&& !(req.getParameter(CERCIVAL).equals(""))) {
			cercival = req.getParameter(CERCIVAL);
		}
		if (req.getParameter(DORSAL_VERTEBRATE) != null
				&& !(req.getParameter(DORSAL_VERTEBRATE).equals(""))) {
			dorsalVertebrate = req.getParameter(DORSAL_VERTEBRATE);
		}
		if (req.getParameter(HULLUX) != null
				&& !(req.getParameter(HULLUX).equals(""))) {
			hullux = req.getParameter(HULLUX);
		}
		if (req.getParameter(VALGUS) != null
				&& !(req.getParameter(VALGUS).equals(""))) {
			valgus = req.getParameter(VALGUS);
		}
		if (req.getParameter(RIGGUS) != null
				&& !(req.getParameter(RIGGUS).equals(""))) {
			riggus = req.getParameter(RIGGUS);
		}
		if (req.getParameter(FLAT_FEET) != null
				&& !(req.getParameter(FLAT_FEET).equals(""))) {
			flatFeet = req.getParameter(FLAT_FEET);
		}
		if (req.getParameter(JOINTS) != null
				&& !(req.getParameter(JOINTS).equals(""))) {
			joints = req.getParameter(JOINTS);
		}
		if (req.getParameter(PELVIS) != null
				&& !(req.getParameter(PELVIS).equals(""))) {
			pelvis = req.getParameter(PELVIS);
		}
		if (req.getParameter(GAIL) != null
				&& !(req.getParameter(GAIL).equals(""))) {
			gail = req.getParameter(GAIL);
		}
		if (req.getParameter(LUMBER_SCALER_VERTABRAC) != null
				&& !(req.getParameter(LUMBER_SCALER_VERTABRAC).equals(""))) {
			lumberScaler = req.getParameter(LUMBER_SCALER_VERTABRAC);
		}
		if (req.getParameter(ROCCYX_VARICOSE_VENIS) != null
				&& !(req.getParameter(ROCCYX_VARICOSE_VENIS).equals(""))) {
			roccyxVericose = req.getParameter(ROCCYX_VARICOSE_VENIS);
		}
		if (req.getParameter(HYDROCELE) != null
				&& !(req.getParameter(HYDROCELE).equals(""))) {
			hydrocele = req.getParameter(HYDROCELE);
		}
		if (req.getParameter(VARICOCELE) != null
				&& !(req.getParameter(VARICOCELE).equals(""))) {
			varicocele = req.getParameter(VARICOCELE);
		}
		if (req.getParameter(UNDER_SCENDED_TESTES) != null
				&& !(req.getParameter(UNDER_SCENDED_TESTES).equals(""))) {
			underScende = req.getParameter(UNDER_SCENDED_TESTES);
		}
		if (req.getParameter(HEMONHOIDS) != null
				&& !(req.getParameter(HEMONHOIDS).equals(""))) {
			hemonhoids = req.getParameter(HEMONHOIDS);
		}
		if (req.getParameter(HERNIA_MUSCLE) != null
				&& !(req.getParameter(HERNIA_MUSCLE).equals(""))) {
			herinaMusic = req.getParameter(HERNIA_MUSCLE);
		}
		if (req.getParameter(BREASTS) != null
				&& !(req.getParameter(BREASTS).equals(""))) {
			breasts = req.getParameter(BREASTS);
		}
		if (req.getParameter(SURGERY_REMARKS) != null
				&& !(req.getParameter(SURGERY_REMARKS).equals(""))) {
			surgeryRemarks = req.getParameter(SURGERY_REMARKS);
		}
		if (req.getParameter(RESPIRATORY_SYSTEM) != null
				&& !(req.getParameter(RESPIRATORY_SYSTEM).equals(""))) {
			respatorySystem = req.getParameter(RESPIRATORY_SYSTEM);
		}

		if (req.getParameter(WITH_GLASSES_DISTANT_R) != null
				&& !(req.getParameter(WITH_GLASSES_DISTANT_R).equals(""))) {
			withGlassesDistantR = req.getParameter(WITH_GLASSES_DISTANT_R);
		}
		if (req.getParameter(WITH_GLASSES_DISTANT_L) != null
				&& !(req.getParameter(WITH_GLASSES_DISTANT_L).equals(""))) {
			withglassesDistantL = req.getParameter(WITH_GLASSES_DISTANT_L);
		}
		if (req.getParameter(WITH_GLASSES_NEAR_R) != null
				&& !(req.getParameter(WITH_GLASSES_NEAR_R).equals(""))) {
			withGlassesNearR = req.getParameter(WITH_GLASSES_NEAR_R);
		}
		if (req.getParameter(WITH_GLASSES_NEAR_L) != null
				&& !(req.getParameter(WITH_GLASSES_NEAR_L).equals(""))) {
			withGlassesNearL = req.getParameter(WITH_GLASSES_NEAR_L);
		}
		if (req.getParameter(WITH_GLASSES_NEAR_CP) != null
				&& !(req.getParameter(WITH_GLASSES_NEAR_CP).equals(""))) {
			withGlassesNearCP = req.getParameter(WITH_GLASSES_NEAR_CP);

		}
		if (req.getParameter(WITHOUT_GLASSES_DISTANT_R) != null
				&& !(req.getParameter(WITHOUT_GLASSES_DISTANT_R).equals(""))) {
			withoutGlassesDistantR = req
					.getParameter(WITHOUT_GLASSES_DISTANT_R);
		}
		if (req.getParameter(WITHOUT_GLASSES_DISTANT_L) != null
				&& !(req.getParameter(WITHOUT_GLASSES_DISTANT_L).equals(""))) {
			withoutGlassesDistantL = req
					.getParameter(WITHOUT_GLASSES_DISTANT_L);
		}
		if (req.getParameter(WITHOUT_GLASSES_NEAR_R) != null
				&& !(req.getParameter(WITHOUT_GLASSES_NEAR_R).equals(""))) {
			withoutGlassesNearR = req.getParameter(WITHOUT_GLASSES_NEAR_R);
		}
		if (req.getParameter(WITHOUT_GLASSES_NEAR_L) != null
				&& !(req.getParameter(WITHOUT_GLASSES_NEAR_L).equals(""))) {
			withoutGlassesNearL = req.getParameter(WITHOUT_GLASSES_NEAR_L);
		}
		if (req.getParameter(WITHOUT_GLASSES_NEAR_CP) != null
				&& !(req.getParameter(WITHOUT_GLASSES_NEAR_CP).equals(""))) {
			withoutGlassesNearCP = req.getParameter(WITHOUT_GLASSES_NEAR_CP);
		}
		if (req.getParameter(CONVERGENCE_SC) != null
				&& !(req.getParameter(CONVERGENCE_SC).equals(""))) {
			convergenceCP = new BigDecimal(req.getParameter(CONVERGENCE_SC));
		}
		if (req.getParameter(CONVERGENCE_C) != null
				&& !(req.getParameter(CONVERGENCE_C).equals(""))) {
			convergenceC = new BigDecimal(req.getParameter(CONVERGENCE_C));

		}
		if (req.getParameter(ACCOMMODATION_R) != null
				&& !(req.getParameter(ACCOMMODATION_R).equals(""))) {
			accommodationR = req.getParameter(ACCOMMODATION_R);
		}
		if (req.getParameter(ACCOMMODATION_L) != null
				&& !(req.getParameter(ACCOMMODATION_L).equals(""))) {
			accommodationL = req.getParameter(ACCOMMODATION_L);
		}

		if (req.getParameter(EYE_REMARKS) != null
				&& !(req.getParameter(EYE_REMARKS).equals(""))) {
			eyeRemarks = req.getParameter(EYE_REMARKS);
		}
		if (req.getParameter(EYE_DATE) != null
				&& !(req.getParameter(EYE_DATE).equals(""))) {
			eyeDate = HMSUtil.dateFormatterDDMMYYYY(req.getParameter(EYE_DATE));
		}
		if (req.getParameter(HEARING_R_F_W) != null
				&& !(req.getParameter(HEARING_R_F_W).equals(""))) {
			hearingRFW = new BigDecimal(req.getParameter(HEARING_R_F_W));
		}
		if (req.getParameter(HEARING_L_F_W) != null
				&& !(req.getParameter(HEARING_L_F_W).equals(""))) {
			hearingLFW = new BigDecimal(req.getParameter(HEARING_L_F_W));
		}
		if (req.getParameter(HEARING_BOTH_FW) != null
				&& !(req.getParameter(HEARING_BOTH_FW).equals(""))) {
			hearingBothFW = new BigDecimal(req.getParameter(HEARING_BOTH_FW));
		}

		if (req.getParameter(HEARING_R_C_V) != null
				&& !(req.getParameter(HEARING_R_C_V).equals(""))) {
			hearingRCV = new BigDecimal(req.getParameter(HEARING_R_C_V));
		}
		if (req.getParameter(HEARING_L_C_V) != null
				&& !(req.getParameter(HEARING_L_C_V).equals(""))) {
			hearingLCV = new BigDecimal(req.getParameter(HEARING_L_C_V));
		}
		if (req.getParameter(HEARING_BOTH_CV) != null
				&& !(req.getParameter(HEARING_BOTH_CV).equals(""))) {
			hearingBothCV = new BigDecimal(req.getParameter(HEARING_BOTH_CV));
		}
		if (req.getParameter(INNER_EAR_R) != null
				&& !(req.getParameter(INNER_EAR_R).equals(""))) {
			innerEarR = req.getParameter(INNER_EAR_R);
		}
		if (req.getParameter(INNER_EAR_L) != null
				&& !(req.getParameter(INNER_EAR_L).equals(""))) {
			innerEarL = req.getParameter(INNER_EAR_L);
		}

		if (req.getParameter(AUDIOMETRY_RECORD) != null
				&& !(req.getParameter(AUDIOMETRY_RECORD).equals(""))) {
			audiometryRecord = req.getParameter(AUDIOMETRY_RECORD);
		}
		if (req.getParameter(NOSE) != null
				&& !(req.getParameter(NOSE).equals(""))) {
			nose = req.getParameter(NOSE);
		}
		if (req.getParameter(THROAT_EAR) != null
				&& !(req.getParameter(THROAT_EAR).equals(""))) {
			throatEar = req.getParameter(THROAT_EAR);
		}
		if (req.getParameter(EAR_REMARKS) != null
				&& !(req.getParameter(EAR_REMARKS).equals(""))) {
			earReamrks = req.getParameter(EAR_REMARKS);
		}

		if (req.getParameter(EAR_DATE) != null
				&& !(req.getParameter(EAR_DATE).equals(""))) {
			earDate = HMSUtil.dateFormatterDDMMYYYY(req.getParameter(EAR_DATE));
		}

		if (req.getParameter(EXTERNAL_EAR_R) != null
				&& !(req.getParameter(EXTERNAL_EAR_R).equals(""))) {
			externalEarR = req.getParameter(EXTERNAL_EAR_R);
		}
		if (req.getParameter(EXTERNAL_EAR_L) != null
				&& !(req.getParameter(EXTERNAL_EAR_L).equals(""))) {
			externalEarL = req.getParameter(EXTERNAL_EAR_L);
		}
		if (req.getParameter(MIDDLE_EAR_R) != null
				&& !(req.getParameter(MIDDLE_EAR_R).equals(""))) {
			middleEarR = req.getParameter(MIDDLE_EAR_R);
		}
		if (req.getParameter(MIDDLE_EAR_L) != null
				&& !(req.getParameter(MIDDLE_EAR_L).equals(""))) {
			middleEarL = req.getParameter(MIDDLE_EAR_L);
		}
		if (req.getParameter(ANY_EVIDENCE_OF_TRACHOMA) != null
				&& !(req.getParameter(ANY_EVIDENCE_OF_TRACHOMA).equals(""))) {
			evidienceOfTrachoma = req.getParameter(ANY_EVIDENCE_OF_TRACHOMA);
		}
		if (req.getParameter(BINOCULAR_VISION_GRADE) != null
				&& !(req.getParameter(BINOCULAR_VISION_GRADE).equals(""))) {
			binocular = req.getParameter(BINOCULAR_VISION_GRADE);
		}
		if (req.getParameter(MANIFEST_HYPERMETROPIA) != null
				&& !(req.getParameter(MANIFEST_HYPERMETROPIA).equals(""))) {
			manifestHypermetropia = req.getParameter(MANIFEST_HYPERMETROPIA);
		}
		if (req.getParameter(COVER_TEST) != null
				&& !(req.getParameter(COVER_TEST).equals(""))) {
			coverTest = req.getParameter(COVER_TEST);
		}
		if (req.getParameter(DIAPHRAGM_TEST) != null
				&& !(req.getParameter(DIAPHRAGM_TEST).equals(""))) {
			diaphragmTest = req.getParameter(DIAPHRAGM_TEST);
		}
		if (req.getParameter(FUND_MEDIA) != null
				&& !(req.getParameter(FUND_MEDIA).equals(""))) {
			fundMedia = req.getParameter(FUND_MEDIA);
		}
		if (req.getParameter(FIELDS) != null
				&& !(req.getParameter(FIELDS).equals(""))) {
			fields = req.getParameter(FIELDS);
		}
		if (req.getParameter(NIGHT_VISUAL_CAPACITY) != null
				&& !(req.getParameter(NIGHT_VISUAL_CAPACITY).equals(""))) {
			nightVisualCapacity = req.getParameter(NIGHT_VISUAL_CAPACITY);
		}
		if (req.getParameter(DENTAL_REMARKS) != null
				&& !(req.getParameter(DENTAL_REMARKS).equals(""))) {
			dentalRemarks = req.getParameter(DENTAL_REMARKS);
		}

		if (req.getParameter(DENTAL_DATE) != null
				&& !(req.getParameter(DENTAL_DATE).equals(""))) {
			dentalDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DENTAL_DATE));
		}
		if (req.getParameter(MENSTRUAL_HISTORY) != null
				&& !(req.getParameter(MENSTRUAL_HISTORY).equals(""))) {
			menstrualHistory = req.getParameter(MENSTRUAL_HISTORY);
		}
		if (req.getParameter(NO_OF_PREGNANCY) != null
				&& !(req.getParameter(NO_OF_PREGNANCY).equals(""))) {
			noOfPregnancy = Integer.parseInt(req.getParameter(NO_OF_PREGNANCY));
		}
		if (req.getParameter(NO_OF_ABORTION) != null
				&& !(req.getParameter(NO_OF_ABORTION).equals(""))) {
			noOfAbortion = Integer.parseInt(req.getParameter(NO_OF_ABORTION));
		}
		if (req.getParameter(NO_OF_CHILDREN) != null
				&& !(req.getParameter(NO_OF_CHILDREN).equals(""))) {
			noOfChildren = Integer.parseInt(req.getParameter(NO_OF_CHILDREN));
		}
		if (req.getParameter(DATE_OF_LASTCONFINEMENT) != null
				&& !(req.getParameter(DATE_OF_LASTCONFINEMENT).equals(""))) {
			lastCondinement = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DATE_OF_LASTCONFINEMENT));
		}
		if (req.getParameter(VAGINAL_DISCHARGE) != null
				&& !(req.getParameter(VAGINAL_DISCHARGE).equals(""))) {
			vaginalDischarge = req.getParameter(VAGINAL_DISCHARGE);
		}
		if (req.getParameter(PROLAPSE) != null
				&& !(req.getParameter(PROLAPSE).equals(""))) {
			prolapse = req.getParameter(PROLAPSE);
		}
		if (req.getParameter(USG_ABORTION) != null
				&& !(req.getParameter(USG_ABORTION).equals(""))) {
			usgAbortion = req.getParameter(USG_ABORTION);
		}
		if (req.getParameter(GYANAECOLOGY_RAMARKS) != null
				&& !(req.getParameter(GYANAECOLOGY_RAMARKS).equals(""))) {
			gyanaecologyRemarks = req.getParameter(GYANAECOLOGY_RAMARKS);
		}
		if (req.getParameter(GYANAECOLOGY_DATE) != null
				&& !(req.getParameter(GYANAECOLOGY_DATE).equals(""))) {
			gyanaecologyDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(GYANAECOLOGY_DATE));
		}
		if (req.getParameter(GYANAECOLOGY_RAMARKS) != null
				&& !(req.getParameter(GYANAECOLOGY_RAMARKS).equals(""))) {
			gyanaecologyRemarks = req.getParameter(GYANAECOLOGY_RAMARKS);
		}
		if (req.getParameter(MEDICAL_BOARD_EXAMINATION) != null
				&& !(req.getParameter(MEDICAL_BOARD_EXAMINATION).equals(""))) {
			medicalBoardExamination = req
					.getParameter(MEDICAL_BOARD_EXAMINATION);
		}
		if (req.getParameter(MEDICAL_BOARD_EXAMINATION_PLACE) != null
				&& !(req.getParameter(MEDICAL_BOARD_EXAMINATION_PLACE)
						.equals(""))) {
			medicalBoardExaminationPlace = Integer.parseInt(req
					.getParameter(MEDICAL_BOARD_EXAMINATION_PLACE));
		}
		if (req.getParameter(MEDICAL_BOARD_EXAMINATION_DATE) != null
				&& !(req.getParameter(MEDICAL_BOARD_EXAMINATION_DATE)
						.equals(""))) {
			medicalBoardExaminationDate = HMSUtil.dateFormatterDDMMYYYY((req
					.getParameter(MEDICAL_BOARD_EXAMINATION_DATE)));
		}
		if (req.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION) != null
				&& !(req.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION)
						.equals(""))) {
			subsequentMedicalBoardExam = req
					.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION);
		}
		if (req.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_PLACE) != null
				&& !(req
						.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_PLACE)
						.equals(""))) {
			subsequentMedicalBoardExamPlace = Integer.parseInt(req
					.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_PLACE));
		}
		if (req.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_DATE) != null
				&& !(req
						.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_DATE)
						.equals(""))) {
			subsequentMedicalBoardExamDate = HMSUtil.dateFormatterDDMMYYYY((req
					.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_DATE)));
		}

		if (req.getParameter(APPROVING_AUTHORITY) != null
				&& !(req.getParameter(APPROVING_AUTHORITY).equals(""))) {
			ApprovingAuthority = req.getParameter(APPROVING_AUTHORITY);
		}
		if (req.getParameter(APPROVING_AUTHORITY_PLACE) != null
				&& !(req.getParameter(APPROVING_AUTHORITY_PLACE).equals(""))) {
			ApprovingAuthorityPlace = Integer.parseInt(req
					.getParameter(APPROVING_AUTHORITY_PLACE));
		}
		if (req.getParameter(APPROVING_AUTHORITY_DATE) != null
				&& !(req.getParameter(APPROVING_AUTHORITY_DATE).equals(""))) {
			ApprovingAuthorityDate = HMSUtil.dateFormatterDDMMYYYY((req
					.getParameter(APPROVING_AUTHORITY_DATE)));
		}
		if (req.getParameter(LMP) != null
				&& !(req.getParameter(LMP).equals(""))) {
			lmp = (req.getParameter(LMP));
		}
		if (req.getParameter(SURGERY_DATE) != null
				&& !(req.getParameter(SURGERY_DATE).equals(""))) {
			surgeyDate = HMSUtil.dateFormatterDDMMYYYY((req
					.getParameter(SURGERY_DATE)));
		}

		if (req.getParameter(MEDICIN_EXAM_DATE) != null
				&& !(req.getParameter(MEDICIN_EXAM_DATE).equals(""))) {
			medicinExamDate = HMSUtil.dateFormatterDDMMYYYY((req
					.getParameter(MEDICIN_EXAM_DATE)));

		}
		if (req.getParameter(TOTAL_NO_OF_TEETH) != null
				&& !(req.getParameter(TOTAL_NO_OF_TEETH).equals(""))) {
			totalTeeth = req.getParameter(TOTAL_NO_OF_TEETH);

		}
		if (req.getParameter(DEFECTIVE_TEETH) != null
				&& !(req.getParameter(DEFECTIVE_TEETH).equals(""))) {
			totalDefectiveTeeth = req.getParameter(DEFECTIVE_TEETH);

		}
		if (req.getParameter(MISSING_TEETH) != null
				&& !(req.getParameter(MISSING_TEETH).equals(""))) {
			missingTeeth = req.getParameter(MISSING_TEETH);

		}
		if (req.getParameter(MISSING_UNSERVICABLE_TEETH) != null
				&& !(req.getParameter(MISSING_UNSERVICABLE_TEETH).equals(""))) {
			unserviceableTeeth = req.getParameter(MISSING_UNSERVICABLE_TEETH);

		}
		if (req.getParameter(DENTSL_POINT) != null
				&& !(req.getParameter(DENTSL_POINT).equals(""))) {
			DenstalPoint = req.getParameter(DENTSL_POINT);

		}

		// //////////////////////////////////

		if (req.getParameter(DUR_8) != null) {
			dur8 = (req.getParameter(DUR_8));

		} else {
			dur8 = "N";

		}

		if (req.getParameter(DUR_7) != null) {
			dur7 = (req.getParameter(DUR_7));

		} else {
			dur7 = "N";

		}
		if (req.getParameter(DUR_6) != null) {
			dur6 = (req.getParameter(DUR_6));

		} else {
			dur6 = "N";

		}
		if (req.getParameter(DUR_5) != null) {
			dur5 = (req.getParameter(DUR_5));

		} else {
			dur5 = "N";

		}

		if (req.getParameter(DUR_4) != null) {
			dur4 = (req.getParameter(DUR_4));
		} else {
			dur4 = "N";

		}
		if (req.getParameter(DUR_3) != null) {
			dur3 = (req.getParameter(DUR_3));

		} else {
			dur3 = "N";

		}
		if (req.getParameter(DUR_2) != null) {
			dur2 = (req.getParameter(DUR_2));

		} else {
			dur2 = "N";

		}
		if (req.getParameter(DUR_1) != null) {
			dur1 = (req.getParameter(DUR_1));

		} else {
			dur1 = "N";

		}

		if (req.getParameter(DUL_8) != null) {
			dul8 = (req.getParameter(DUL_8));
		} else {
			dul8 = "N";

		}
		if (req.getParameter(DUL_7) != null) {
			dul7 = (req.getParameter(DUL_7));

		} else {
			dul7 = "N";

		}
		if (req.getParameter(DUL_6) != null) {
			dul6 = (req.getParameter(DUL_6));
		} else {
			dul6 = "N";

		}
		if (req.getParameter(DUL_5) != null) {
			dul5 = (req.getParameter(DUL_5));
		} else {
			dul5 = "N";

		}
		if (req.getParameter(DUL_4) != null) {
			dul4 = (req.getParameter(DUL_4));
		} else {
			dul4 = "N";

		}
		if (req.getParameter(DUL_3) != null) {
			dul3 = (req.getParameter(DUL_3));
		} else {
			dul3 = "N";

		}
		if (req.getParameter(DUL_2) != null) {
			dul2 = (req.getParameter(DUL_2));
		} else {
			dul2 = "N";

		}
		if (req.getParameter(DUL_1) != null) {
			dul1 = (req.getParameter(DUL_1));
		} else {
			dul1 = "N";

		}

		if (req.getParameter(DLR_8) != null) {
			dlr8 = (req.getParameter(DLR_8));
		} else {
			dlr8 = "N";

		}
		if (req.getParameter(DLR_7) != null) {
			dlr7 = (req.getParameter(DLR_7));
		} else {
			dlr7 = "N";

		}
		if (req.getParameter(DLR_6) != null) {
			dlr6 = (req.getParameter(DLR_6));
		} else {
			dlr6 = "N";

		}
		if (req.getParameter(DLR_5) != null) {
			dlr5 = (req.getParameter(DLR_5));
		} else {
			dlr5 = "N";

		}
		if (req.getParameter(DLR_4) != null) {
			dlr4 = (req.getParameter(DLR_4));
		} else {
			dlr4 = "N";

		}
		if (req.getParameter(DLR_3) != null) {
			dlr3 = (req.getParameter(DLR_3));
		} else {
			dlr3 = "N";

		}
		if (req.getParameter(DLR_2) != null) {
			dlr2 = (req.getParameter(DLR_2));
		} else {
			dlr2 = "N";

		}

		if (req.getParameter(DLR_1) != null) {
			dlr1 = (req.getParameter(DLR_1));
		} else {
			dlr1 = "N";

		}

		if (req.getParameter(DLL_8) != null) {
			dll8 = (req.getParameter(DLL_8));
		} else {
			dll8 = "N";

		}
		if (req.getParameter(DLL_7) != null) {
			dll7 = (req.getParameter(DLL_7));
		} else {
			dll7 = "N";

		}

		if (req.getParameter(DLL_6) != null) {
			dll6 = (req.getParameter(DLL_6));
		} else {
			dll6 = "N";

		}
		if (req.getParameter(DLL_5) != null) {
			dll5 = (req.getParameter(DLL_5));
		} else {
			dll5 = "N";

		}
		if (req.getParameter(DLL_4) != null) {
			dll4 = (req.getParameter(DLL_4));
		} else {
			dll4 = "N";

		}
		if (req.getParameter(DLL_3) != null) {
			dll3 = (req.getParameter(DLL_3));
		} else {
			dll3 = "N";

		}
		if (req.getParameter(DLL_2) != null) {
			dll2 = (req.getParameter(DLL_2));
		} else {
			dll2 = "N";

		}
		if (req.getParameter(DLL_1) != null) {
			dll1 = (req.getParameter(DLL_1));
		} else {
			dll1 = "N";

		}
		// ///////////////////////////

		if (req.getParameter(UUR_8) != null) {
			uur8 = (req.getParameter(UUR_8));
		} else {
			uur8 = "N";

		}

		if (req.getParameter(UUR_7) != null) {
			uur7 = (req.getParameter(UUR_7));
		} else {
			uur7 = "N";

		}
		if (req.getParameter(UUR_6) != null) {
			uur6 = (req.getParameter(UUR_6));
		} else {
			uur6 = "N";

		}
		if (req.getParameter(UUR_5) != null) {
			uur5 = (req.getParameter(UUR_5));
		} else {
			uur5 = "N";

		}
		if (req.getParameter(UUR_4) != null) {
			uur4 = (req.getParameter(UUR_4));
		} else {
			uur4 = "N";

		}
		if (req.getParameter(UUR_3) != null) {
			uur3 = (req.getParameter(UUR_3));
		} else {
			uur3 = "N";

		}
		if (req.getParameter(UUR_2) != null) {
			uur2 = (req.getParameter(UUR_2));
		} else {
			uur2 = "N";

		}
		if (req.getParameter(UUR_1) != null) {
			uur1 = (req.getParameter(UUR_1));
		} else {
			uur1 = "N";

		}

		if (req.getParameter(UUL_8) != null) {
			uul8 = (req.getParameter(UUL_8));
		} else {
			uul8 = "N";

		}
		if (req.getParameter(UUL_7) != null) {
			uul7 = (req.getParameter(UUL_7));

		} else {
			uul7 = "N";

		}
		if (req.getParameter(UUL_6) != null) {
			uul6 = (req.getParameter(UUL_6));
		} else {
			uul6 = "N";

		}
		if (req.getParameter(UUL_5) != null) {
			uul5 = (req.getParameter(UUL_5));
		} else {
			uul5 = "N";

		}
		if (req.getParameter(UUL_4) != null) {
			uul4 = (req.getParameter(UUL_4));
		} else {
			uul4 = "N";

		}
		if (req.getParameter(UUL_3) != null) {
			uul3 = (req.getParameter(UUL_3));
		} else {
			uul3 = "N";

		}
		if (req.getParameter(UUL_2) != null) {
			uul2 = (req.getParameter(UUL_2));
		} else {
			uul2 = "N";

		}
		if (req.getParameter(UUL_1) != null) {
			uul1 = (req.getParameter(UUL_1));
		} else {
			uul1 = "N";

		}
		if (req.getParameter(ULR_8) != null) {
			ulr8 = (req.getParameter(ULR_8));
		} else {
			ulr8 = "N";

		}

		if (req.getParameter(ULR_7) != null) {
			ulr7 = (req.getParameter(ULR_7));
		} else {
			ulr7 = "N";

		}
		if (req.getParameter(ULR_6) != null) {
			ulr6 = (req.getParameter(ULR_6));
		} else {
			ulr6 = "N";

		}
		if (req.getParameter(ULR_5) != null) {
			ulr5 = (req.getParameter(ULR_5));
		} else {
			ulr5 = "N";

		}
		if (req.getParameter(ULR_4) != null) {
			ulr4 = (req.getParameter(ULR_4));
		} else {
			ulr4 = "N";

		}
		if (req.getParameter(ULR_3) != null) {
			ulr3 = (req.getParameter(ULR_3));
		} else {
			ulr3 = "N";

		}
		if (req.getParameter(ULR_2) != null) {
			ulr2 = (req.getParameter(ULR_2));
		} else {
			ulr2 = "N";

		}
		if (req.getParameter(ULR_1) != null) {
			ulr1 = (req.getParameter(ULR_1));
		} else {
			ulr1 = "N";

		}

		if (req.getParameter(ULL_8) != null) {
			ull8 = (req.getParameter(ULL_8));
		} else {
			ull8 = "N";

		}
		if (req.getParameter(ULL_7) != null) {
			ull7 = (req.getParameter(ULL_7));
		} else {
			ull7 = "N";

		}
		if (req.getParameter(ULL_6) != null) {
			ull6 = (req.getParameter(ULL_6));
		} else {
			ull6 = "N";

		}
		if (req.getParameter(ULL_5) != null) {
			ull5 = (req.getParameter(ULL_5));
		} else {
			ull5 = "N";

		}
		if (req.getParameter(ULL_4) != null) {
			ull4 = (req.getParameter(ULL_4));
		} else {
			ull4 = "N";

		}
		if (req.getParameter(ULL_3) != null) {
			ull3 = (req.getParameter(ULL_3));
		} else {
			ull3 = "N";

		}
		if (req.getParameter(ULL_2) != null) {
			ull2 = (req.getParameter(ULL_2));
		} else {
			ull2 = "N";

		}
		if (req.getParameter(ULL_1) != null) {
			ull1 = (req.getParameter(ULL_1));
		} else {
			ull1 = "N";

		}

		// ////////////////////////

		if (req.getParameter(MUR_8) != null) {
			mur8 = (req.getParameter(MUR_8));

		} else {
			mur8 = "N";

		}
		if (req.getParameter(MUR_7) != null) {
			mur7 = (req.getParameter(MUR_7));
		} else {
			mur7 = "N";

		}
		if (req.getParameter(MUR_6) != null) {
			mur6 = (req.getParameter(MUR_6));
		} else {
			mur6 = "N";

		}
		if (req.getParameter(MUR_5) != null) {
			mur5 = (req.getParameter(MUR_5));
		} else {
			mur5 = "N";

		}
		if (req.getParameter(MUR_4) != null) {
			mur4 = (req.getParameter(MUR_4));
		} else {
			mur4 = "N";

		}
		if (req.getParameter(MUR_3) != null) {
			mur3 = (req.getParameter(MUR_3));
		} else {
			mur3 = "N";

		}
		if (req.getParameter(MUR_2) != null) {
			mur2 = (req.getParameter(MUR_2));
		} else {
			mur2 = "N";

		}
		if (req.getParameter(MUR_1) != null) {
			mur1 = (req.getParameter(MUR_1));
		} else {
			mur1 = "N";

		}

		if (req.getParameter(MUL_8) != null) {
			mul8 = (req.getParameter(MUL_8));
		} else {
			mul8 = "N";

		}
		if (req.getParameter(MUL_7) != null) {
			mul7 = (req.getParameter(MUL_7));

		} else {
			mul7 = "N";

		}
		if (req.getParameter(MUL_6) != null) {
			mul6 = (req.getParameter(MUL_6));
		} else {
			mul6 = "N";

		}
		if (req.getParameter(MUL_5) != null) {
			mul5 = (req.getParameter(MUL_5));
		} else {
			mul5 = "N";

		}
		if (req.getParameter(MUL_4) != null) {
			mul4 = (req.getParameter(MUL_4));
		} else {
			mul4 = "N";

		}
		if (req.getParameter(MUL_3) != null) {
			mul3 = (req.getParameter(MUL_3));
		} else {
			mul3 = "N";

		}
		if (req.getParameter(MUL_2) != null) {
			mul2 = (req.getParameter(MUL_2));
		} else {
			mul2 = "N";

		}
		if (req.getParameter(MUL_1) != null) {
			mul1 = (req.getParameter(MUL_1));
		} else {
			mul1 = "N";

		}
		if (req.getParameter(MLR_8) != null) {
			mlr8 = (req.getParameter(MLR_8));
		} else {
			mlr8 = "N";

		}

		if (req.getParameter(MLR_7) != null) {
			mlr7 = (req.getParameter(MLR_7));
		} else {
			mlr7 = "N";

		}
		if (req.getParameter(MLR_6) != null) {
			mlr6 = (req.getParameter(MLR_6));
		} else {
			mlr6 = "N";

		}
		if (req.getParameter(MLR_5) != null) {
			mlr5 = (req.getParameter(MLR_5));
		} else {
			mlr5 = "N";

		}

		if (req.getParameter(MLR_4) != null) {
			mlr4 = (req.getParameter(MLR_4));
		} else {
			mlr4 = "N";

		}
		if (req.getParameter(MLR_3) != null) {
			mlr3 = (req.getParameter(MLR_3));
		} else {
			mlr3 = "N";

		}

		if (req.getParameter(MLR_2) != null) {
			mlr2 = (req.getParameter(MLR_2));
		} else {
			mlr2 = "N";

		}
		if (req.getParameter(MLR_1) != null) {
			mlr1 = (req.getParameter(MLR_1));
		} else {
			mlr1 = "N";

		}

		if (req.getParameter(MLL_8) != null) {
			mll8 = (req.getParameter(MLL_8));
		} else {
			mll8 = "N";

		}
		if (req.getParameter(MLL_7) != null) {
			mll7 = (req.getParameter(MLL_7));
		} else {
			mll7 = "N";

		}
		if (req.getParameter(MLL_6) != null) {
			mll6 = (req.getParameter(MLL_6));
		} else {
			mll6 = "N";

		}
		if (req.getParameter(MLL_5) != null) {
			mll5 = (req.getParameter(MLL_5));
		} else {
			mll5 = "N";

		}
		if (req.getParameter(MLL_4) != null) {
			mll4 = (req.getParameter(MLL_4));
		} else {
			mll4 = "N";

		}
		if (req.getParameter(MLL_3) != null) {
			mll3 = (req.getParameter(MLL_3));
		} else {
			mll3 = "N";

		}
		if (req.getParameter(MLL_2) != null) {
			mll2 = (req.getParameter(MLL_2));
		} else {
			mll2 = "N";

		}
		if (req.getParameter(MLL_1) != null) {
			mll1 = (req.getParameter(MLL_1));
		} else {
			mll1 = "N";

		}

		if (req.getParameter("Id") != null
				&& !(req.getParameter("Id").equals(""))) {
			Id = Integer.parseInt(req.getParameter("Id"));
		}

		sur8 = dur8 + "" + mur8 + "" + uur8;

		sur7 = dur7 + "" + mur7 + "" + uur7;

		sur6 = dur6 + "" + mur6 + "" + uur6;
		sur5 = dur5 + "" + mur5 + "" + uur5;
		sur4 = dur4 + "" + mur4 + "" + uur4;
		sur3 = dur3 + "" + mur3 + "" + uur3;
		sur2 = dur2 + "" + mur2 + "" + uur2;
		sur1 = dur1 + "" + mur2 + "" + uur1;

		sul8 = dul8 + "" + mul8 + "" + uul8;
		sul7 = dul7 + "" + mul7 + "" + uul7;

		sul6 = dul6 + "" + mul6 + "" + uul6;
		sul5 = dul5 + "" + mul5 + "" + uul5;
		sul4 = dul4 + "" + mul4 + "" + uul4;
		sul3 = dul3 + "" + mul3 + "" + uul3;
		sul2 = dul2 + "" + mul2 + "" + uul2;
		sul1 = dul1 + "" + mul1 + "" + uul1;

		slr8 = dlr8 + "" + mlr8 + "" + ulr8;
		slr7 = dlr7 + "" + mlr7 + "" + ulr7;
		slr6 = dlr6 + "" + mlr6 + "" + ulr6;
		slr5 = dlr5 + "" + mlr5 + "" + ulr5;
		slr4 = dlr4 + "" + mlr4 + "" + ulr4;
		slr3 = dlr3 + "" + mlr3 + "" + ulr3;
		slr2 = dlr2 + "" + mlr2 + "" + ulr2;
		slr1 = dlr1 + "" + mlr2 + "" + ulr1;

		sll8 = dll8 + "" + mll8 + "" + ull8;
		sll7 = dll7 + "" + mll7 + "" + ull7;
		sll6 = dll6 + "" + mll6 + "" + ull6;
		sll5 = dll5 + "" + mll5 + "" + ull5;
		sll4 = dll4 + "" + mll4 + "" + ull4;
		sll3 = dll3 + "" + mll3 + "" + ull3;
		sll2 = dll2 + "" + mll2 + "" + ull2;
		sll1 = dll1 + "" + mll2 + "" + ull1;

		generalMap.put("Id", Id);
		generalMap.put("sur8", sur8);
		generalMap.put("sur7", sur7);
		generalMap.put("sur6", sur6);
		generalMap.put("sur5", sur5);
		generalMap.put("sur4", sur4);
		generalMap.put("sur3", sur3);
		generalMap.put("sur2", sur2);
		generalMap.put("sur1", sur1);

		generalMap.put("sul8", sul8);
		generalMap.put("sul7", sul7);
		generalMap.put("sul6", sul6);
		generalMap.put("sul5", sul5);
		generalMap.put("sul4", sul4);
		generalMap.put("sul3", sul3);
		generalMap.put("sul2", sul2);
		generalMap.put("sul1", sul1);

		generalMap.put("slr1", slr1);
		generalMap.put("slr2", slr2);
		generalMap.put("slr3", slr3);
		generalMap.put("slr4", slr4);
		generalMap.put("slr5", slr5);
		generalMap.put("slr6", slr6);
		generalMap.put("slr7", slr7);
		generalMap.put("slr8", slr8);

		generalMap.put("sll1", sll1);
		generalMap.put("sll2", sll2);
		generalMap.put("sll3", sll3);
		generalMap.put("sll4", sll4);
		generalMap.put("sll5", sll5);
		generalMap.put("sll6", sll6);
		generalMap.put("sll7", sll7);
		generalMap.put("sll8", sll8);

		generalMap.put("externalEarR", externalEarR);
		generalMap.put("externalEarL", externalEarL);
		generalMap.put("middleEarR", middleEarR);
		generalMap.put("middleEarL", middleEarL);
		generalMap.put("evidienceOfTrachoma", evidienceOfTrachoma);
		generalMap.put("binocular", binocular);
		generalMap.put("manifestHypermetropia", manifestHypermetropia);
		generalMap.put("coverTest", coverTest);
		generalMap.put("diaphragmTest", diaphragmTest);
		generalMap.put("fundMedia", fundMedia);
		generalMap.put("nightVisualCapacity", nightVisualCapacity);
		generalMap.put("withGlassesDistantR", withGlassesDistantR);
		generalMap.put("withglassesDistantL", withglassesDistantL);
		generalMap.put("withGlassesNearCP", withGlassesNearCP);
		generalMap.put("withGlassesNearL", withGlassesNearL);
		generalMap.put("withGlassesNearR", withGlassesNearR);
		generalMap.put("withoutGlassesDistantR", withoutGlassesDistantR);
		generalMap.put("withoutGlassesDistantL", withoutGlassesDistantL);
		generalMap.put("withoutGlassesNearCP", withoutGlassesNearCP);
		generalMap.put("withoutGlassesNearL", withoutGlassesNearL);
		generalMap.put("withoutGlassesNearR", withoutGlassesNearR);
		generalMap.put("convergenceCP", convergenceCP);
		generalMap.put("convergenceC", convergenceC);
		generalMap.put("accommodationR", accommodationR);
		generalMap.put("accommodationL", accommodationL);
		generalMap.put("eyeRemarks", eyeRemarks);
		generalMap.put("eyeDate", eyeDate);
		generalMap.put("hearingRFW", hearingRFW);
		generalMap.put("hearingLFW", hearingLFW);
		generalMap.put("hearingBothFW", hearingBothFW);
		generalMap.put("hearingRCV", hearingRCV);
		generalMap.put("hearingLCV", hearingLCV);
		generalMap.put("hearingBothCV", hearingBothCV);
		generalMap.put("innerEarR", innerEarR);
		generalMap.put("innerEarL", innerEarL);
		generalMap.put("audiometryRecord", audiometryRecord);
		generalMap.put("nose", nose);
		generalMap.put("throatEar", throatEar);
		generalMap.put("earReamrks", earReamrks);
		generalMap.put("earDate", earDate);

		generalMap.put("fields", fields);
		generalMap.put("entryDate", entryDate);
		generalMap.put("typeOfEntry", typeOfEntry);
		generalMap.put("betchNo", betchNo);
		generalMap.put("chestNo", chestNo);
		generalMap.put("rollNo", rollNo);
		generalMap.put("medicalExamHeld", medicalExamHeld);
		generalMap.put("medicalStatus", medicalStatus);
		generalMap.put("fullName", fullName);
		generalMap.put("dateOfBirth", dateOfBirth);
		generalMap.put("maritialStatus", maritialStatus);
		generalMap.put("service", service);
		generalMap.put("pNo", pNo);
		generalMap.put("rank", rank);
		generalMap.put("hoursOfFlown", hoursOfFlown);
		generalMap.put("permanentAddress", permanentAddress);
		generalMap.put("identification1", identification1);
		generalMap.put("identification2", identification2);
		generalMap.put("armsCrops", armsCrops);
		generalMap.put("dateOfCompletion", dateOfCompletion);
		generalMap.put("dateOfReporting", dateOfReporting);

		generalMap.put("documentForwardDate", documentForwardDate);
		generalMap.put("documentForwardTo", documentForwardTo);
		generalMap.put("fromWhereHeReport", fromWhereHeReport);
		generalMap.put("hypertension", hypertension);
		generalMap.put("heartDisease", heartDisease);
		generalMap.put("diabetes", diabetes);
		generalMap.put("bleedingDisorder", bleedingDisorder);
		generalMap.put("mentalDisease", mentalDisease);
		generalMap.put("nightBlindness", nightBlindness);
		generalMap.put("asthama", asthama);
		generalMap.put("dischargeFrom", dischargeFrom);
		generalMap.put("plesury", plesury);
		generalMap.put("earDieses", earDieses);
		generalMap.put("rheumatism", rheumatism);
		generalMap.put("frequentCough", frequentCough);
		generalMap.put("chronicIndigestion", chronicIndigestion);
		generalMap.put("nervousBrakdown", nervousBrakdown);
		generalMap.put("kidenyBladder", kidenyBladder);
		generalMap.put("fitsFaintinngAttacks", fitsFaintinngAttacks);
		generalMap.put("std", std);
		generalMap.put("serveHeadInjury", serveHeadInjury);
		generalMap.put("joundice", joundice);
		generalMap.put("sickness", sickness);
		generalMap.put("breastDisease", breastDisease);
		generalMap.put("trachoma", trachoma);
		generalMap.put("amenorrhoea", amenorrhoea);
		generalMap.put("nightbindness", nightbindness);
		generalMap.put("menirrhagia", menirrhagia);
		generalMap.put("laserTeartement", laserTeartement);
		generalMap.put("pregnancy", pregnancy);
		generalMap.put("eyeDisease", eyeDisease);
		generalMap.put("rejectedAsUnfit", rejectedAsUnfit);
		generalMap.put("dischargeMedicallyUnfit", dischargeMedicallyUnfit);
		generalMap.put("adimmitedInHospitalFirIllness",
				adimmitedInHospitalFirIllness);
		generalMap.put("abortion", abortion);

		generalMap.put("stateNature", stateNature);
		generalMap.put("otherInform", otherInform);
		generalMap.put("height", height);
		generalMap.put("weight", weight);
		generalMap.put("acceptableKg", acceptableKg);
		generalMap.put("leglength", leglength);
		generalMap.put("appereance", appereance);
		generalMap.put("albumin", albumin);
		generalMap.put("sugar", sugar);
		generalMap.put("spGraviry", spGraviry);
		generalMap.put("hbPercentage", hbPercentage);
		generalMap.put("physique", physique);
		generalMap.put("anyOtherInv", anyOtherInv);
		generalMap.put("skin", skin);
		generalMap.put("abdomen", abdomen);
		generalMap.put("heartSize", heartSize);
		generalMap.put("sound", sound);
		generalMap.put("rhythm", rhythm);
		generalMap.put("arterialWalls", arterialWalls);
		generalMap.put("pulseRates", pulseRates);
		generalMap.put("bp", bp);
		generalMap.put("fullExpension", fullExpension);
		generalMap.put("rangeOfExpension", rangeOfExpension);
		generalMap.put("selfBalR", selfBalR);
		generalMap.put("selfBalL", selfBalL);
		generalMap.put("speechMental", speechMental);
		generalMap.put("endocrinCond", endocrinCond);
		generalMap.put("otherAbnormalities", otherAbnormalities);
		generalMap.put("medicinRemarks", medicinRemarks);
		generalMap.put("finger", finger);
		generalMap.put("hand", hand);
		generalMap.put("wrist", wrist);
		generalMap.put("elbows", elbows);
		generalMap.put("shoulderGridles", shoulderGridles);
		generalMap.put("cercival", cercival);
		generalMap.put("dorsalVertebrate", dorsalVertebrate);
		generalMap.put("hullux", hullux);
		generalMap.put("valgus", valgus);
		generalMap.put("riggus", riggus);
		generalMap.put("flatFeet", flatFeet);
		generalMap.put("joints", joints);
		generalMap.put("pelvis", pelvis);
		generalMap.put("gail", gail);
		generalMap.put("lumberScaler", lumberScaler);
		generalMap.put("roccyxVericose", roccyxVericose);
		generalMap.put("hydrocele", hydrocele);
		generalMap.put("varicocele", varicocele);
		generalMap.put("underScende", underScende);
		generalMap.put("hemonhoids", hemonhoids);
		generalMap.put("herinaMusic", herinaMusic);
		generalMap.put("breasts", breasts);
		generalMap.put("surgeryRemarks", surgeryRemarks);
		generalMap.put("respatorySystem", respatorySystem);
		generalMap.put("dentalRemarks", dentalRemarks);
		generalMap.put("dentalDate", dentalDate);
		generalMap.put("menstrualHistory", menstrualHistory);
		generalMap.put("noOfPregnancy", noOfPregnancy);
		generalMap.put("noOfAbortion", noOfAbortion);
		generalMap.put("noOfChildren", noOfChildren);
		generalMap.put("lastCondinement", lastCondinement);
		generalMap.put("vaginalDischarge", vaginalDischarge);
		generalMap.put("prolapse", prolapse);
		generalMap.put("usgAbortion", usgAbortion);
		generalMap.put("gyanaecologyRemarks", gyanaecologyRemarks);
		generalMap.put("gyanaecologyDate", gyanaecologyDate);
		generalMap.put("medicalBoardExamination", medicalBoardExamination);
		generalMap.put("medicalBoardExaminationPlace",
				medicalBoardExaminationPlace);
		generalMap.put("medicalBoardExaminationDate",
				medicalBoardExaminationDate);
		generalMap
				.put("subsequentMedicalBoardExam", subsequentMedicalBoardExam);
		generalMap.put("subsequentMedicalBoardExamPlace",
				subsequentMedicalBoardExamPlace);
		generalMap.put("subsequentMedicalBoardExamDate",
				subsequentMedicalBoardExamDate);
		generalMap.put("ApprovingAuthority", ApprovingAuthority);
		generalMap.put("ApprovingAuthorityPlace", ApprovingAuthorityPlace);
		generalMap.put("ApprovingAuthorityDate", ApprovingAuthorityDate);
		generalMap.put("lmp", lmp);

		generalMap.put("surgeyDate", surgeyDate);
		generalMap.put("medicalExaminationBoardDTOList",
				medicalExaminationBoardDTOList);
		generalMap.put("totalTeeth", totalTeeth);
		generalMap.put("totalDefectiveTeeth", totalDefectiveTeeth);
		generalMap.put("missingTeeth", missingTeeth);
		generalMap.put("unserviceableTeeth", unserviceableTeeth);
		generalMap.put("DenstalPoint", DenstalPoint);
		generalMap.put("medicinExamDate", medicinExamDate);
		boolean dataUpdated = false;
		dataUpdated = medicalExaminationBoardHandlerService
				.medicalExaminationBoardUpdateToDatabase(generalMap);
		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";

		} else {
			message = "Record Cant Be Updated !!";

		}
		String medicalEntryNo = "";
		String medicalEntryNo1 = "";
		String userName = "";
		String userName1 = "";
		medicalEntryNo = medicalExaminationBoardHandlerService
				.generateMedicalEntryNumber(userName);
		medicalEntryNo1 = medicalExaminationBoardHandlerService
				.generateMedicalEntryNumber1(userName1);
		map = medicalExaminationBoardHandlerService
				.showMedicalExaminationBoardJsp();
		map.put("medicalEntryNo", medicalEntryNo);
		map.put("medicalEntryNo1", medicalEntryNo1);
		jsp = MEDICAL_EXAM_SEARCH_JSP;
		title = "update MedicalExamination Board ";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);

	}

	// print Button Method

	@SuppressWarnings("unchecked")
	public ModelAndView printMedicalBoard(HttpServletRequest request,
			HttpServletResponse response) {
		int Id = 0;
		Map<String, Object> parameters = new HashMap();
		Map<String, Object> connectionMap = medicalExaminationBoardHandlerService
				.getConnectionForReport();
		if (request.getParameter("Id") != null) {
			Id = Integer.parseInt(request.getParameter("Id"));
		

		}
		String medicalExamType = "";
		if(request.getParameter("medicalExamType")!= null){
			medicalExamType = request.getParameter("medicalExamType");
		}
		String reportType = "";
		if(request.getParameter("reportType")!= null){
			reportType = request.getParameter("reportType");
		}
		parameters.put("medical_examination_id", Id);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		
		String reportName = "";
		if(medicalExamType.equalsIgnoreCase("Annual Medical Exam(AFMSF-3B)")){
			reportName = "AnnualMedicalExaminationReport";
		}else	if(medicalExamType.equalsIgnoreCase("Primary/Extension Med. Exam(AFMSF-2A)")){
			reportName = "primarymedical_examinationreport";
		}else	if(medicalExamType.equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)")){
			reportName = "MedicalExamReportonreleasedischarge";
		}else	if(medicalExamType.equalsIgnoreCase("Prior To Proceedings Abroad Med. Exam(AFMSF-3B)")){
			reportName = "AnnualMedicalExaminationReport";
		}else	if(medicalExamType.equalsIgnoreCase("High Altitude Med. Exam(AFMSF-3B)")){
			reportName = "AnnualMedicalExaminationReport";
		}else	if(medicalExamType.equalsIgnoreCase("InitialMedicalBoardAFMSF15")){
			reportName = "Medical_board_proceedingsrecat";
		}else	if(medicalExamType.equalsIgnoreCase("Medical Board Review AFMSF 15")){
			reportName = "Medical_board_proceedingsrecat";
		}else	if(medicalExamType.equalsIgnoreCase("Medical Board Rel/Invalidment AFMSF 16")){
			reportName = "Medical_board_proceedings";
		}
		if(reportType.equalsIgnoreCase("Specialist"))
			reportName="Medical_Case_Sheet";
		System.out.println("medicalExamType------"+medicalExamType);
		System.out.println("reportName------"+reportName);
		try {
			
			HMSUtil.generateReport(reportName, parameters,
					(java.sql.Connection) connectionMap.get("con"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public ModelAndView printInitialMedicalExam(HttpServletRequest request,
			HttpServletResponse response) {
		int year = 0;
		int month = 0;
		String title = "INITIAL MEDICAL EXAMINATION REPORT: RESULT SHEET SSB CANDIDATES:";
		Map<String, Object> parameters = new HashMap();
		Map<String, Object> connectionMap = medicalExaminationBoardHandlerService
				.getConnectionForReport();
		if (request.getParameter("year") != null) {
			year = Integer.parseInt(request.getParameter("year"));

		}
		if (request.getParameter("month") != null) {
			month = Integer.parseInt(request.getParameter("month"));

		}
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		parameters.put("year", year);
		parameters.put("month", month);
		parameters.put("reporttitle", title);

		try {

			HMSUtil.generateReport("InitialMedicalExaminationReport",
					parameters, (java.sql.Connection) connectionMap.get("con"),
					response, getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Integer getInstructionToCandidateId() {
		return instructionToCandidateId;
	}

	public void setInstructionToCandidateId(
			Integer ctionTinstructionToCandidateIdoCandidateId) {
		this.instructionToCandidateId = ctionTinstructionToCandidateIdoCandidateId;
	}

	public MedicalExaminationBoardHandlerService getMedicalExaminationBoardHandlerService() {
		return medicalExaminationBoardHandlerService;
	}

	public void setMedicalExaminationBoardHandlerService(
			MedicalExaminationBoardHandlerService medicalExaminationBoardHandlerService) {
		this.medicalExaminationBoardHandlerService = medicalExaminationBoardHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}
	public ModelAndView addMedicalExaminationBoardAnnual(HttpServletRequest req,
			HttpServletResponse res) {

		String url = "";
		String serviceNo = "";
		String monthlySerialNo = "";
		Date entryDate = null;
		Date medicinExamDate = null;
		String lastChangedBy = "";
		String lastChangedTime = "";
		Date lastChangedDate = null;
		Date surgeyDate = null;
		int typeOfEntry = 0;
		String betchNo = "";
		String chestNo = "";
		String rollNo = "";
		int medicalExamHeld = 0;
		String medicalStatus = "";
		String fullName = "";
		Date dateOfBirth = null;
		int maritialStatus = 0;
		String service = "";
		String pNo = "";
		String rank = "";
		String hoursOfFlown = "";
		String permanentAddress = "";
		String identification1 = "";
		String identification2 = "";
		String armsCrops = "";
		Date dateOfReporting = null;
		Date dateOfCompletion = null;
		Date documentForwardDate = null;
		String documentForwardTo = "";
		String fromWhereHeReport = "";
		int srNo = 0;
		String Relation = "";
		String age = "";
		String health = "";
		String couseOfDeath = "";
		String died = "";
		String hypertension = "";
		String heartDisease = "";
		String diabetes = "";
		String bleedingDisorder = "";
		String mentalDisease = "";
		String nightBlindness = "";

		String asthama = "";
		String dischargeFrom = "";
		String plesury = "";
		String earDieses = "";
		String rheumatism = "";
		String frequentCough = "";
		String chronicIndigestion = "";
		String nervousBrakdown = "";
		String kidenyBladder = "";
		String fitsFaintinngAttacks = "";
		String std = "";
		String serveHeadInjury = "";
		String joundice = "";
		String sickness = "";
		String breastDisease = "";
		String trachoma = "";
		String amenorrhoea = "";
		String nightbindness = "";
		String menirrhagia = "";
		String laserTeartement = "";
		String pregnancy = "";
		String abortion = "";
		String eyeDisease = "";
		String rejectedAsUnfit = "";
		String dischargeMedicallyUnfit = "";
		String adimmitedInHospitalFirIllness = "";
		String stateNature = "";
		String otherInform = "";
		BigDecimal height = new BigDecimal(0);
		BigDecimal weight = new BigDecimal(0);
		BigDecimal acceptableKg = new BigDecimal(0);
		BigDecimal leglength = new BigDecimal(0);
		String appereance = "";
		String albumin = "";
		String sugar = "";
		String spGraviry = "";
		String hbPercentage = "";
		String physique = "";
		String anyOtherInv = "";
		String skin = "";
		String abdomen = "";
		String heartSize = "";
		String sound = "";
		String rhythm = "";
		String arterialWalls = "";
		String pulseRates = "";
		String bp = "";
		String fullExpension = "";
		String rangeOfExpension = "";
		String selfBalR = "";
		String selfBalL = "";
		String speechMental = "";
		String endocrinCond = "";
		String otherAbnormalities = "";
		String medicinRemarks = "";
		String finger = "";
		String hand = "";
		String wrist = "";
		String elbows = "";
		String shoulderGridles = "";
		String cercival = "";
		String dorsalVertebrate = "";
		String hullux = "";
		String valgus = "";
		String riggus = "";
		String flatFeet = "";
		String joints = "";
		String pelvis = "";
		String gail = "";
		String lumberScaler = "";
		String roccyxVericose = "";
		String hydrocele = "";
		String varicocele = "";
		String underScende = "";
		String hemonhoids = "";
		String herinaMusic = "";
		String breasts = "";
		String surgeryRemarks = "";
		String respatorySystem = "";

		String withGlassesDistantR = "";
		String withglassesDistantL = "";
		String withGlassesNearR = "";
		String withGlassesNearL = "";
		String withGlassesNearCP = "";
		String withoutGlassesDistantR = "";
		String withoutGlassesDistantL = "";
		String withoutGlassesNearR = "";
		String withoutGlassesNearL = "";
		String withoutGlassesNearCP = "";
		BigDecimal convergenceCP = new BigDecimal(0);

		BigDecimal convergenceC = new BigDecimal(0);
		String accommodationR = "";
		String accommodationL = "";
		String eyeRemarks = "";
		Date eyeDate = null;
		BigDecimal hearingRFW = new BigDecimal(0);
		BigDecimal hearingLFW = new BigDecimal(0);
		BigDecimal hearingBothFW = new BigDecimal(0);
		BigDecimal hearingRCV = new BigDecimal(0);
		BigDecimal hearingLCV = new BigDecimal(0);
		BigDecimal hearingBothCV = new BigDecimal(0);

		String innerEarR = "";
		String innerEarL = "";
		String audiometryRecord = "";
		String nose = "";
		String throatEar = "";
		String earReamrks = "";
		Date earDate = null;
		String externalEarR = "";
		String externalEarL = "";
		String middleEarR = "";
		String middleEarL = "";
		String evidienceOfTrachoma = "";
		String binocular = "";
		String manifestHypermetropia = "";
		String coverTest = "";
		String diaphragmTest = "";
		String fundMedia = "";
		String fields = "";
		String nightVisualCapacity = "";

		String dentalRemarks = "";
		Date dentalDate = null;
		String menstrualHistory = "";
		int noOfPregnancy = 0;
		int noOfAbortion = 0;
		int noOfChildren = 0;
		Date lastCondinement = null;
		String vaginalDischarge = "";
		String prolapse = "";
		String usgAbortion = "";
		String gyanaecologyRemarks = "";
		Date gyanaecologyDate = null;
		String medicalBoardExamination = "";
		int medicalBoardExaminationPlace = 0;
		Date medicalBoardExaminationDate = null;
		String subsequentMedicalBoardExam = "";
		int subsequentMedicalBoardExamPlace = 0;
		Date subsequentMedicalBoardExamDate = null;
		String ApprovingAuthority = "";
		int ApprovingAuthorityPlace = 0;
		Date ApprovingAuthorityDate = null;
		String lmp = "";
		String totalTeeth = "";
		String totalDefectiveTeeth = "";
		String missingTeeth = "";
		String DenstalPoint = "";
		String unserviceableTeeth = "";

		String dur8 = "";
		String dur7 = "";
		String dur6 = "";
		String dur5 = "";
		String dur4 = "";
		String dur3 = "";
		String dur2 = "";
		String dur1 = "";
		String dul8 = "";
		String dul7 = "";
		String dul6 = "";
		String dul5 = "";
		String dul4 = "";
		String dul3 = "";
		String dul2 = "";
		String dul1 = "";
		String dlr8 = "";
		String dlr7 = "";
		String dlr6 = "";
		String dlr5 = "";
		String dlr4 = "";
		String dlr3 = "";
		String dlr2 = "";
		String dlr1 = "";
		String dll8 = "";
		String dll7 = "";
		String dll6 = "";
		String dll5 = "";
		String dll4 = "";
		String dll3 = "";
		String dll2 = "";
		String dll1 = "";
		String mur8 = "";
		String mur7 = "";
		String mur6 = "";
		String mur5 = "";
		String mur4 = "";
		String mur3 = "";
		String mur2 = "";
		String mur1 = "";
		String mul8 = "";
		String mul7 = "";
		String mul6 = "";
		String mul5 = "";
		String mul4 = "";
		String mul3 = "";
		String mul2 = "";
		String mul1 = "";
		String mlr8 = "";
		String mlr7 = "";
		String mlr6 = "";
		String mlr5 = "";
		String mlr4 = "";
		String mlr3 = "";
		String mlr2 = "";
		String mlr1 = "";
		String mll8 = "";
		String mll7 = "";
		String mll6 = "";
		String mll5 = "";
		String mll4 = "";
		String mll3 = "";
		String mll2 = "";
		String mll1 = "";
		String uur8 = "";
		String uur7 = "";
		String uur6 = "";
		String uur5 = "";
		String uur4 = "";
		String uur3 = "";
		String uur2 = "";
		String uur1 = "";
		String uul8 = "";
		String uul7 = "";
		String uul6 = "";
		String uul5 = "";
		String uul4 = "";
		String uul3 = "";
		String uul2 = "";
		String uul1 = "";
		String ulr8 = "";
		String ulr7 = "";
		String ulr6 = "";
		String ulr5 = "";
		String ulr4 = "";
		String ulr3 = "";
		String ulr2 = "";
		String ulr1 = "";
		String ull8 = "";
		String ull7 = "";
		String ull6 = "";
		String ull5 = "";
		String ull4 = "";
		String ull3 = "";
		String ull2 = "";
		String ull1 = "";

		String sur8 = "";
		String sur7 = "";
		String sur6 = "";
		String sur5 = "";
		String sur4 = "";
		String sur3 = "";
		String sur2 = "";
		String sur1 = "";
		String sul8 = "";
		String sul7 = "";
		String sul6 = "";
		String sul5 = "";
		String sul4 = "";
		String sul3 = "";
		String sul2 = "";
		String sul1 = "";

		String slr8 = "";
		String slr7 = "";
		String slr6 = "";
		String slr5 = "";
		String slr4 = "";
		String slr3 = "";
		String slr2 = "";
		String slr1 = "";
		String sll8 = "";
		String sll7 = "";
		String sll6 = "";

		String sll5 = "";
		String sll4 = "";
		String sll3 = "";
		String sll2 = "";
		String sll1 = "";

		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(req);
		MasMedicalExaminationReportOnEntry masMedicalBoardProceedings = new MasMedicalExaminationReportOnEntry();

		Map<String, Object> generalMap = new HashMap<String, Object>();
		List<MasMedicalBoardExaminationDetail> masMedicalBoardDetails = new ArrayList<MasMedicalBoardExaminationDetail>();

		Vector<String> v1 = box.getVector(RELATION);

		Vector<String> v2 = box.getVector(AGE);

		Vector<String> v3 = box.getVector(HEALTH);

		Vector<String> v4 = box.getVector(CAUSE_OF_DEATH);

		Vector<String> v5 = box.getVector(DIED);

		Vector<String> v6 = box.getVector(SIRIAL_NO);

		for (int i = 0; i < v2.size(); i++) {

			MasMedicalBoardExaminationDetail masMedicalBoardDetail = new MasMedicalBoardExaminationDetail();
			masMedicalBoardDetail.setRelation(v1.get(i));

			masMedicalBoardDetail.setAge(v2.get(i));

			masMedicalBoardDetail.setHealth(v3.get(i));

			masMedicalBoardDetail.setCauseOfDeath(v4.get(i));

			masMedicalBoardDetail.setDied(v5.get(i));

			masMedicalBoardDetail.setSrNo(Integer.parseInt(v6.get(i)));

			masMedicalBoardDetails.add(masMedicalBoardDetail);

		}

		if (req.getParameter(SERVICE_NO) != null) {
			serviceNo = req.getParameter(SERVICE_NO);
		}
		if (req.getParameter(RANK) != null
				&& !(req.getParameter(RANK).equals(""))) {
			rank = req.getParameter(RANK);
		}

		if (req.getParameter(ENTRY_OF_DATE) != null
				&& !(req.getParameter(ENTRY_OF_DATE).equals(""))) {
			entryDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(ENTRY_OF_DATE));
		}
		if (req.getParameter(TYPE_OF_ENTRY) != null
				&& !(req.getParameter(TYPE_OF_ENTRY).equals(""))) {
			typeOfEntry = Integer.parseInt(req.getParameter(TYPE_OF_ENTRY));
		}
		if (req.getParameter(BATCH1_NO) != null
				&& !(req.getParameter(BATCH1_NO).equals(""))) {
			betchNo = req.getParameter(BATCH1_NO);
		}
		if (req.getParameter(CHEST_NO) != null
				&& !(req.getParameter(CHEST_NO).equals(""))) {
			chestNo = req.getParameter(CHEST_NO);
		}

		if (req.getParameter(ROLL_NO) != null
				&& !(req.getParameter(ROLL_NO).equals(""))) {
			rollNo = req.getParameter(ROLL_NO);
		}

		if (req.getParameter(MEDICAL_EXAM_HELD_AT) != null) {
			medicalExamHeld = Integer.parseInt(req
					.getParameter(MEDICAL_EXAM_HELD_AT));
		}

		if (req.getParameter(MEDICAL_STATUS) != null
				&& !(req.getParameter(MEDICAL_STATUS).equals(""))) {
			medicalStatus = req.getParameter(MEDICAL_STATUS);
		}
		if (req.getParameter(FULL_NAME) != null
				&& !(req.getParameter(FULL_NAME).equals(""))) {
			fullName = req.getParameter(FULL_NAME);
		}

		if (req.getParameter(DATE_OF_BIRTH) != null
				&& !(req.getParameter(DATE_OF_BIRTH).equals(""))) {
			dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DATE_OF_BIRTH));
		}

		if (req.getParameter(MARITIAL_STATUS) != null
				&& !(req.getParameter(MARITIAL_STATUS).equals(""))) {
			maritialStatus = Integer
					.parseInt(req.getParameter(MARITIAL_STATUS));
		}

		if (req.getParameter(SERVICE) != null
				&& !(req.getParameter(SERVICE).equals(""))) {
			service = req.getParameter(SERVICE);
		}

		if (req.getParameter(P_NO) != null
				&& !(req.getParameter(P_NO).equals(""))) {
			pNo = req.getParameter(P_NO);
		}

		if (req.getParameter(RANK) != null
				&& !(req.getParameter(RANK).equals(""))) {
			rank = req.getParameter(RANK);
		}

		if (req.getParameter(HOURS_OF_FLOWN) != null
				&& !(req.getParameter(HOURS_OF_FLOWN).equals(""))) {
			hoursOfFlown = req.getParameter(HOURS_OF_FLOWN);
		}
		if (req.getParameter(PERMANENT_ADDRESS) != null
				&& !(req.getParameter(PERMANENT_ADDRESS).equals(""))) {
			permanentAddress = req.getParameter(PERMANENT_ADDRESS);
		}

		if (req.getParameter(IDENTIFICATION_MARKS1) != null
				&& !(req.getParameter(IDENTIFICATION_MARKS1).equals(""))) {
			identification1 = req.getParameter(IDENTIFICATION_MARKS1);
		}

		if (req.getParameter(IDENTIFICATION_MARKS2) != null
				&& !(req.getParameter(IDENTIFICATION_MARKS2).equals(""))) {
			identification2 = req.getParameter(IDENTIFICATION_MARKS2);
		}

		if (req.getParameter(ARMS_CROPS) != null
				&& !(req.getParameter(ARMS_CROPS).equals(""))) {
			armsCrops = req.getParameter(ARMS_CROPS);
		}

		if (req.getParameter(DATE_OF_COMPLETION) != null
				&& !(req.getParameter(DATE_OF_COMPLETION).equals(""))) {
			dateOfCompletion = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DATE_OF_COMPLETION));
		}

		if (req.getParameter(DOCUMENT_FORWARD_DATE1) != null
				&& !(req.getParameter(DOCUMENT_FORWARD_DATE1).equals(""))) {
			documentForwardDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DOCUMENT_FORWARD_DATE1));

		}

		if (req.getParameter(DOCUMENT_FORWARD_TO) != null
				&& !(req.getParameter(DOCUMENT_FORWARD_TO).equals(""))) {
			documentForwardTo = req.getParameter(DOCUMENT_FORWARD_TO);
		}
		if (req.getParameter(DATE_OF_REPORTING) != null
				&& !(req.getParameter(DATE_OF_REPORTING).equals(""))) {
			dateOfReporting = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DATE_OF_REPORTING));

		}

		if (req.getParameter(FROM_WHERE_HE_REPORT) != null
				&& !(req.getParameter(FROM_WHERE_HE_REPORT).equals(""))) {
			fromWhereHeReport = req.getParameter(FROM_WHERE_HE_REPORT);
		}
		if (req.getParameter(HYPERTENSION) != null
				&& !(req.getParameter(HYPERTENSION).equals(""))) {
			hypertension = req.getParameter(HYPERTENSION);
		}
		if (req.getParameter(HEAR_DISEASE) != null
				&& !(req.getParameter(HEAR_DISEASE).equals(""))) {
			heartDisease = req.getParameter(HEAR_DISEASE);
		}
		if (req.getParameter(DIABETES) != null
				&& !(req.getParameter(DIABETES).equals(""))) {
			diabetes = req.getParameter(DIABETES);
		}
		if (req.getParameter(BLEEDING_DIORDER) != null
				&& !(req.getParameter(BLEEDING_DIORDER).equals(""))) {
			bleedingDisorder = req.getParameter(BLEEDING_DIORDER);
		}
		if (req.getParameter(MENTAL_DISEASE) != null
				&& !(req.getParameter(MENTAL_DISEASE).equals(""))) {
			mentalDisease = req.getParameter(MENTAL_DISEASE);
		}
		if (req.getParameter(NIGHT_BLINDNESS) != null
				&& !(req.getParameter(NIGHT_BLINDNESS).equals(""))) {
			nightBlindness = req.getParameter(NIGHT_BLINDNESS);
		}

		if (req.getParameter(ASTHAMA) != null
				&& !(req.getParameter(ASTHAMA).equals(""))) {
			asthama = req.getParameter(ASTHAMA);
		}

		if (req.getParameter(DISCHARGE_FROM) != null
				&& !(req.getParameter(DISCHARGE_FROM).equals(""))) {
			dischargeFrom = req.getParameter(DISCHARGE_FROM);

		}

		if (req.getParameter(PLEURISY) != null
				&& !(req.getParameter(PLEURISY).equals(""))) {
			plesury = req.getParameter(PLEURISY);
		}

		if (req.getParameter(EAR_DISEASE) != null
				&& !(req.getParameter(EAR_DISEASE).equals(""))) {
			earDieses = req.getParameter(EAR_DISEASE);
		}

		if (req.getParameter(RHEUMATISM) != null
				&& !(req.getParameter(RHEUMATISM).equals(""))) {
			rheumatism = req.getParameter(RHEUMATISM);
		}
		if (req.getParameter(FREQUENT_CAUGH) != null
				&& !(req.getParameter(FREQUENT_CAUGH).equals(""))) {
			frequentCough = req.getParameter(FREQUENT_CAUGH);
		}

		if (req.getParameter(CHRONIC_INDIGESTION) != null
				&& !(req.getParameter(CHRONIC_INDIGESTION).equals(""))) {
			chronicIndigestion = req.getParameter(CHRONIC_INDIGESTION);
		}
		if (req.getParameter(NERVOUS_BRAKDOWN) != null
				&& !(req.getParameter(NERVOUS_BRAKDOWN).equals(""))) {
			nervousBrakdown = req.getParameter(NERVOUS_BRAKDOWN);
		}

		if (req.getParameter(KIDENY_BLADDER) != null
				&& !(req.getParameter(KIDENY_BLADDER).equals(""))) {
			kidenyBladder = req.getParameter(KIDENY_BLADDER);
		}
		if (req.getParameter(FITS_FAINTING_ATTACKS) != null
				&& !(req.getParameter(FITS_FAINTING_ATTACKS).equals(""))) {
			fitsFaintinngAttacks = req.getParameter(FITS_FAINTING_ATTACKS);
		}
		if (req.getParameter(STD) != null
				&& !(req.getParameter(STD).equals(""))) {
			std = req.getParameter(STD);
		}

		if (req.getParameter(SEVERE_HEAD_INJURY) != null
				&& !(req.getParameter(SEVERE_HEAD_INJURY).equals(""))) {
			serveHeadInjury = req.getParameter(SEVERE_HEAD_INJURY);
		}

		if (req.getParameter(JOUNDICE) != null
				&& !(req.getParameter(JOUNDICE).equals(""))) {
			joundice = req.getParameter(JOUNDICE);
		}
		if (req.getParameter(SICKNESS) != null
				&& !(req.getParameter(SICKNESS).equals(""))) {
			sickness = req.getParameter(SICKNESS);
		}
		if (req.getParameter(BREAST_DISEASE) != null
				&& !(req.getParameter(BREAST_DISEASE).equals(""))) {
			breastDisease = req.getParameter(BREAST_DISEASE);
		}
		if (req.getParameter(TRACHOMA) != null
				&& !(req.getParameter(TRACHOMA).equals(""))) {
			trachoma = req.getParameter(TRACHOMA);
		}

		if (req.getParameter(AMENORRHOEA) != null
				&& !(req.getParameter(AMENORRHOEA).equals(""))) {
			amenorrhoea = req.getParameter(AMENORRHOEA);
		}
		if (req.getParameter(NIGHT_BINDNESS) != null
				&& !(req.getParameter(NIGHT_BINDNESS).equals(""))) {
			nightbindness = req.getParameter(NIGHT_BINDNESS);
		}
		if (req.getParameter(MENORRHAGIA) != null
				&& !(req.getParameter(MENORRHAGIA).equals(""))) {
			menirrhagia = req.getParameter(MENORRHAGIA);
		}
		if (req.getParameter(LASER_TREATEMENT) != null
				&& !(req.getParameter(LASER_TREATEMENT).equals(""))) {
			laserTeartement = req.getParameter(LASER_TREATEMENT);
		}
		if (req.getParameter(PREGNANCY) != null
				&& !(req.getParameter(PREGNANCY).equals(""))) {
			pregnancy = req.getParameter(PREGNANCY);
		}
		if (req.getParameter(EYE_DISEASE) != null
				&& !(req.getParameter(EYE_DISEASE).equals(""))) {
			eyeDisease = req.getParameter(EYE_DISEASE);
		}
		if (req.getParameter(REJECTED_AS_UNFIT) != null
				&& !(req.getParameter(REJECTED_AS_UNFIT).equals(""))) {
			rejectedAsUnfit = req.getParameter(REJECTED_AS_UNFIT);
		}
		if (req.getParameter(DISCHARGE_MEDICALLY_UNFIT) != null
				&& !(req.getParameter(DISCHARGE_MEDICALLY_UNFIT).equals(""))) {
			dischargeMedicallyUnfit = req
					.getParameter(DISCHARGE_MEDICALLY_UNFIT);
		}
		if (req.getParameter(ADIMMITED_IN_HOSPITAL_FOR_ILLNESS) != null
				&& !(req.getParameter(ADIMMITED_IN_HOSPITAL_FOR_ILLNESS)
						.equals(""))) {
			adimmitedInHospitalFirIllness = req
					.getParameter(ADIMMITED_IN_HOSPITAL_FOR_ILLNESS);
		}
		if (req.getParameter(ABORTION) != null
				&& !(req.getParameter(ABORTION).equals(""))) {
			abortion = req.getParameter(ABORTION);
		}

		if (req.getParameter(STATE_NATURE_OF_THE_DISEASE) != null
				&& !(req.getParameter(STATE_NATURE_OF_THE_DISEASE).equals(""))) {
			stateNature = req.getParameter(STATE_NATURE_OF_THE_DISEASE);
		}
		if (req.getParameter(OTHER_INFORMATION) != null
				&& !(req.getParameter(OTHER_INFORMATION).equals(""))) {
			otherInform = req.getParameter(OTHER_INFORMATION);
		}
		if (req.getParameter(HEIGHT_WITHOUT_SHOOSE) != null
				&& !(req.getParameter(HEIGHT_WITHOUT_SHOOSE).equals(""))) {
			height = (new BigDecimal(req.getParameter(HEIGHT_WITHOUT_SHOOSE)));
		}
		if (req.getParameter(ACTUAL_WEIGHT) != null
				&& !(req.getParameter(ACTUAL_WEIGHT).equals(""))) {
			weight = (new BigDecimal(req.getParameter(ACTUAL_WEIGHT)));
		}
		if (req.getParameter(ACCEPTABLE_KG) != null
				&& !(req.getParameter(ACCEPTABLE_KG).equals(""))) {
			acceptableKg = (new BigDecimal(req.getParameter(ACCEPTABLE_KG)));
		}
		if (req.getParameter(LEG_LENGTH) != null
				&& !(req.getParameter(LEG_LENGTH).equals(""))) {
			leglength = (new BigDecimal(req.getParameter(LEG_LENGTH)));
		}
		if (req.getParameter(APPEREANCE) != null
				&& !(req.getParameter(APPEREANCE).equals(""))) {
			appereance = req.getParameter(APPEREANCE);
		}
		if (req.getParameter(ALBUMIN) != null
				&& !(req.getParameter(ALBUMIN).equals(""))) {
			albumin = req.getParameter(ALBUMIN);
		}
		if (req.getParameter(SUGAR) != null
				&& !(req.getParameter(SUGAR).equals(""))) {
			sugar = req.getParameter(SUGAR);
		}
		if (req.getParameter(SP_GRAVITY) != null
				&& !(req.getParameter(SP_GRAVITY).equals(""))) {
			spGraviry = req.getParameter(SP_GRAVITY);
		}
		if (req.getParameter(HB_PERCENTAGE) != null
				&& !(req.getParameter(HB_PERCENTAGE).equals(""))) {
			hbPercentage = req.getParameter(HB_PERCENTAGE);
		}
		if (req.getParameter(PHYSIQUE) != null
				&& !(req.getParameter(PHYSIQUE).equals(""))) {
			physique = req.getParameter(PHYSIQUE);
		}

		if (req.getParameter(ANYOTHER_INV_CARRIED_OUT) != null
				&& !(req.getParameter(ANYOTHER_INV_CARRIED_OUT).equals(""))) {
			anyOtherInv = req.getParameter(ANYOTHER_INV_CARRIED_OUT);
		}
		if (req.getParameter(SKIN) != null
				&& !(req.getParameter(SKIN).equals(""))) {
			skin = req.getParameter(SKIN);
		}
		if (req.getParameter(ABDOMEN) != null
				&& !(req.getParameter(ABDOMEN).equals(""))) {
			abdomen = req.getParameter(ABDOMEN);
		}
		if (req.getParameter(HEART_SIZE) != null
				&& !(req.getParameter(HEART_SIZE).equals(""))) {
			heartSize = req.getParameter(HEART_SIZE);
		}
		if (req.getParameter(SOUND) != null
				&& !(req.getParameter(SOUND).equals(""))) {
			sound = req.getParameter(SOUND);
		}
		if (req.getParameter(RHYTHM) != null
				&& !(req.getParameter(RHYTHM).equals(""))) {
			rhythm = req.getParameter(RHYTHM);
		}
		if (req.getParameter(ARTERIAL_WALLS) != null
				&& !(req.getParameter(ARTERIAL_WALLS).equals(""))) {
			arterialWalls = req.getParameter(ARTERIAL_WALLS);
		}
		if (req.getParameter(PULSE_RATES) != null
				&& !(req.getParameter(PULSE_RATES).equals(""))) {
			pulseRates = req.getParameter(PULSE_RATES);
		}
		if (req.getParameter(BP1) != null
				&& !(req.getParameter(BP1).equals(""))) {
			bp = req.getParameter(BP1);
		}
		if (req.getParameter(FULL_EXPENSION) != null
				&& !(req.getParameter(FULL_EXPENSION).equals(""))) {
			fullExpension = req.getParameter(FULL_EXPENSION);
		}
		if (req.getParameter(RANGE_OF_EXPENSION) != null
				&& !(req.getParameter(RANGE_OF_EXPENSION).equals(""))) {
			rangeOfExpension = req.getParameter(RANGE_OF_EXPENSION);
		}

		if (req.getParameter(SELF_BALANCINF_R) != null
				&& !(req.getParameter(SELF_BALANCINF_R).equals(""))) {
			selfBalR = req.getParameter(SELF_BALANCINF_R);
		}
		if (req.getParameter(SELF_BALANCING_L) != null
				&& !(req.getParameter(SELF_BALANCING_L).equals(""))) {
			selfBalL = req.getParameter(SELF_BALANCING_L);
		}
		if (req.getParameter(SPEECH_MENTAL_CAPACITY) != null
				&& !(req.getParameter(SPEECH_MENTAL_CAPACITY).equals(""))) {
			speechMental = req.getParameter(SPEECH_MENTAL_CAPACITY);
		}
		if (req.getParameter(ENDOCRINE_CONDITION) != null
				&& !(req.getParameter(ENDOCRINE_CONDITION).equals(""))) {
			endocrinCond = req.getParameter(ENDOCRINE_CONDITION);
		}
		if (req.getParameter(OTHER_ABNORMALITIES) != null
				&& !(req.getParameter(OTHER_ABNORMALITIES).equals(""))) {
			otherAbnormalities = req.getParameter(OTHER_ABNORMALITIES);
		}
		if (req.getParameter(MEDICIN_REMARKS) != null
				&& !(req.getParameter(MEDICIN_REMARKS).equals(""))) {
			medicinRemarks = req.getParameter(MEDICIN_REMARKS);
		}
		if (req.getParameter(FINGER) != null
				&& !(req.getParameter(FINGER).equals(""))) {
			finger = req.getParameter(FINGER);
		}
		if (req.getParameter(HAND) != null
				&& !(req.getParameter(HAND).equals(""))) {
			hand = req.getParameter(HAND);
		}
		if (req.getParameter(WRIST) != null
				&& !(req.getParameter(WRIST).equals(""))) {
			wrist = req.getParameter(WRIST);
		}
		if (req.getParameter(ELBOWS) != null
				&& !(req.getParameter(ELBOWS).equals(""))) {
			elbows = req.getParameter(ELBOWS);
		}
		if (req.getParameter(SHOULDER_GIRDLES) != null
				&& !(req.getParameter(SHOULDER_GIRDLES).equals(""))) {
			shoulderGridles = req.getParameter(SHOULDER_GIRDLES);
		}
		if (req.getParameter(CERCIVAL) != null
				&& !(req.getParameter(CERCIVAL).equals(""))) {
			cercival = req.getParameter(CERCIVAL);
		}
		if (req.getParameter(DORSAL_VERTEBRATE) != null
				&& !(req.getParameter(DORSAL_VERTEBRATE).equals(""))) {
			dorsalVertebrate = req.getParameter(DORSAL_VERTEBRATE);
		}
		if (req.getParameter(HULLUX) != null
				&& !(req.getParameter(HULLUX).equals(""))) {
			hullux = req.getParameter(HULLUX);
		}
		if (req.getParameter(VALGUS) != null
				&& !(req.getParameter(VALGUS).equals(""))) {
			valgus = req.getParameter(VALGUS);
		}
		if (req.getParameter(RIGGUS) != null
				&& !(req.getParameter(RIGGUS).equals(""))) {
			riggus = req.getParameter(RIGGUS);
		}
		if (req.getParameter(FLAT_FEET) != null
				&& !(req.getParameter(FLAT_FEET).equals(""))) {
			flatFeet = req.getParameter(FLAT_FEET);
		}
		if (req.getParameter(JOINTS) != null
				&& !(req.getParameter(JOINTS).equals(""))) {
			joints = req.getParameter(JOINTS);
		}
		if (req.getParameter(PELVIS) != null
				&& !(req.getParameter(PELVIS).equals(""))) {
			pelvis = req.getParameter(PELVIS);
		}
		if (req.getParameter(GAIL) != null
				&& !(req.getParameter(GAIL).equals(""))) {
			gail = req.getParameter(GAIL);
		}
		if (req.getParameter(LUMBER_SCALER_VERTABRAC) != null
				&& !(req.getParameter(LUMBER_SCALER_VERTABRAC).equals(""))) {
			lumberScaler = req.getParameter(LUMBER_SCALER_VERTABRAC);
		}
		if (req.getParameter(ROCCYX_VARICOSE_VENIS) != null
				&& !(req.getParameter(ROCCYX_VARICOSE_VENIS).equals(""))) {
			roccyxVericose = req.getParameter(ROCCYX_VARICOSE_VENIS);
		}
		if (req.getParameter(HYDROCELE) != null
				&& !(req.getParameter(HYDROCELE).equals(""))) {
			hydrocele = req.getParameter(HYDROCELE);
		}
		if (req.getParameter(VARICOCELE) != null
				&& !(req.getParameter(VARICOCELE).equals(""))) {
			varicocele = req.getParameter(VARICOCELE);
		}
		if (req.getParameter(UNDER_SCENDED_TESTES) != null
				&& !(req.getParameter(UNDER_SCENDED_TESTES).equals(""))) {
			underScende = req.getParameter(UNDER_SCENDED_TESTES);
		}
		if (req.getParameter(HEMONHOIDS) != null
				&& !(req.getParameter(HEMONHOIDS).equals(""))) {
			hemonhoids = req.getParameter(HEMONHOIDS);
		}
		if (req.getParameter(HERNIA_MUSCLE) != null
				&& !(req.getParameter(HERNIA_MUSCLE).equals(""))) {
			herinaMusic = req.getParameter(HERNIA_MUSCLE);
		}
		if (req.getParameter(BREASTS) != null
				&& !(req.getParameter(BREASTS).equals(""))) {
			breasts = req.getParameter(BREASTS);
		}
		if (req.getParameter(SURGERY_REMARKS) != null
				&& !(req.getParameter(SURGERY_REMARKS).equals(""))) {
			surgeryRemarks = req.getParameter(SURGERY_REMARKS);
		}
		if (req.getParameter(RESPIRATORY_SYSTEM) != null
				&& !(req.getParameter(RESPIRATORY_SYSTEM).equals(""))) {
			respatorySystem = req.getParameter(RESPIRATORY_SYSTEM);
		}

		if (req.getParameter(WITH_GLASSES_DISTANT_R) != null
				&& !(req.getParameter(WITH_GLASSES_DISTANT_R).equals(""))) {
			withGlassesDistantR = req.getParameter(WITH_GLASSES_DISTANT_R);
		}
		if (req.getParameter(WITH_GLASSES_DISTANT_L) != null
				&& !(req.getParameter(WITH_GLASSES_DISTANT_L).equals(""))) {
			withglassesDistantL = req.getParameter(WITH_GLASSES_DISTANT_L);
		}
		if (req.getParameter(WITH_GLASSES_NEAR_R) != null
				&& !(req.getParameter(WITH_GLASSES_NEAR_R).equals(""))) {
			withGlassesNearR = req.getParameter(WITH_GLASSES_NEAR_R);
		}
		if (req.getParameter(WITH_GLASSES_NEAR_L) != null
				&& !(req.getParameter(WITH_GLASSES_NEAR_L).equals(""))) {
			withGlassesNearL = req.getParameter(WITH_GLASSES_NEAR_L);
		}
		if (req.getParameter(WITH_GLASSES_NEAR_CP) != null
				&& !(req.getParameter(WITH_GLASSES_NEAR_CP).equals(""))) {
			withGlassesNearCP = req.getParameter(WITH_GLASSES_NEAR_CP);

		}
		if (req.getParameter(WITHOUT_GLASSES_DISTANT_R) != null
				&& !(req.getParameter(WITHOUT_GLASSES_DISTANT_R).equals(""))) {
			withoutGlassesDistantR = req
					.getParameter(WITHOUT_GLASSES_DISTANT_R);
		}
		if (req.getParameter(WITHOUT_GLASSES_DISTANT_L) != null
				&& !(req.getParameter(WITHOUT_GLASSES_DISTANT_L).equals(""))) {
			withoutGlassesDistantL = req
					.getParameter(WITHOUT_GLASSES_DISTANT_L);
		}
		if (req.getParameter(WITHOUT_GLASSES_NEAR_R) != null
				&& !(req.getParameter(WITHOUT_GLASSES_NEAR_R).equals(""))) {
			withoutGlassesNearR = req.getParameter(WITHOUT_GLASSES_NEAR_R);
		}
		if (req.getParameter(WITHOUT_GLASSES_NEAR_L) != null
				&& !(req.getParameter(WITHOUT_GLASSES_NEAR_L).equals(""))) {
			withoutGlassesNearL = req.getParameter(WITHOUT_GLASSES_NEAR_L);
		}
		if (req.getParameter(WITHOUT_GLASSES_NEAR_CP) != null
				&& !(req.getParameter(WITHOUT_GLASSES_NEAR_CP).equals(""))) {
			withoutGlassesNearCP = req.getParameter(WITHOUT_GLASSES_NEAR_CP);
		}
		if (req.getParameter(CONVERGENCE_SC) != null
				&& !(req.getParameter(CONVERGENCE_SC).equals(""))) {
			convergenceCP = new BigDecimal(req.getParameter(CONVERGENCE_SC));
		}
		if (req.getParameter(CONVERGENCE_C) != null
				&& !(req.getParameter(CONVERGENCE_C).equals(""))) {
			convergenceC = new BigDecimal(req.getParameter(CONVERGENCE_C));

		}
		if (req.getParameter(ACCOMMODATION_R) != null
				&& !(req.getParameter(ACCOMMODATION_R).equals(""))) {
			accommodationR = req.getParameter(ACCOMMODATION_R);
		}
		if (req.getParameter(ACCOMMODATION_L) != null
				&& !(req.getParameter(ACCOMMODATION_L).equals(""))) {
			accommodationL = req.getParameter(ACCOMMODATION_L);
		}

		if (req.getParameter(EYE_REMARKS) != null
				&& !(req.getParameter(EYE_REMARKS).equals(""))) {
			eyeRemarks = req.getParameter(EYE_REMARKS);
		}
		if (req.getParameter(EYE_DATE) != null
				&& !(req.getParameter(EYE_DATE).equals(""))) {
			eyeDate = HMSUtil.dateFormatterDDMMYYYY(req.getParameter(EYE_DATE));
		}
		if (req.getParameter(HEARING_R_F_W) != null
				&& !(req.getParameter(HEARING_R_F_W).equals(""))) {
			hearingRFW = new BigDecimal(req.getParameter(HEARING_R_F_W));
		}
		if (req.getParameter(HEARING_L_F_W) != null
				&& !(req.getParameter(HEARING_L_F_W).equals(""))) {
			hearingLFW = new BigDecimal(req.getParameter(HEARING_L_F_W));
		}
		if (req.getParameter(HEARING_BOTH_FW) != null
				&& !(req.getParameter(HEARING_BOTH_FW).equals(""))) {
			hearingBothFW = new BigDecimal(req.getParameter(HEARING_BOTH_FW));
		}

		if (req.getParameter(HEARING_R_C_V) != null
				&& !(req.getParameter(HEARING_R_C_V).equals(""))) {
			hearingRCV = new BigDecimal(req.getParameter(HEARING_R_C_V));
		}
		if (req.getParameter(HEARING_L_C_V) != null
				&& !(req.getParameter(HEARING_L_C_V).equals(""))) {
			hearingLCV = new BigDecimal(req.getParameter(HEARING_L_C_V));
		}
		if (req.getParameter(HEARING_BOTH_CV) != null
				&& !(req.getParameter(HEARING_BOTH_CV).equals(""))) {
			hearingBothCV = new BigDecimal(req.getParameter(HEARING_BOTH_CV));
		}
		if (req.getParameter(INNER_EAR_R) != null
				&& !(req.getParameter(INNER_EAR_R).equals(""))) {
			innerEarR = req.getParameter(INNER_EAR_R);
		}
		if (req.getParameter(INNER_EAR_L) != null
				&& !(req.getParameter(INNER_EAR_L).equals(""))) {
			innerEarL = req.getParameter(INNER_EAR_L);
		}

		if (req.getParameter(AUDIOMETRY_RECORD) != null
				&& !(req.getParameter(AUDIOMETRY_RECORD).equals(""))) {
			audiometryRecord = req.getParameter(AUDIOMETRY_RECORD);
		}
		if (req.getParameter(NOSE) != null
				&& !(req.getParameter(NOSE).equals(""))) {
			nose = req.getParameter(NOSE);
		}
		if (req.getParameter(THROAT_EAR) != null
				&& !(req.getParameter(THROAT_EAR).equals(""))) {
			throatEar = req.getParameter(THROAT_EAR);
		}
		if (req.getParameter(EAR_REMARKS) != null
				&& !(req.getParameter(EAR_REMARKS).equals(""))) {
			earReamrks = req.getParameter(EAR_REMARKS);
		}
		if (req.getParameter(EAR_DATE) != null
				&& !(req.getParameter(EAR_DATE).equals(""))) {
			earDate = HMSUtil.dateFormatterDDMMYYYY(req.getParameter(EAR_DATE));
		}

		if (req.getParameter(EXTERNAL_EAR_R) != null
				&& !(req.getParameter(EXTERNAL_EAR_R).equals(""))) {
			externalEarR = req.getParameter(EXTERNAL_EAR_R);
		}
		if (req.getParameter(EXTERNAL_EAR_L) != null
				&& !(req.getParameter(EXTERNAL_EAR_L).equals(""))) {
			externalEarL = req.getParameter(EXTERNAL_EAR_L);
		}
		if (req.getParameter(MIDDLE_EAR_R) != null
				&& !(req.getParameter(MIDDLE_EAR_R).equals(""))) {
			middleEarR = req.getParameter(MIDDLE_EAR_R);
		}
		if (req.getParameter(MIDDLE_EAR_L) != null
				&& !(req.getParameter(MIDDLE_EAR_L).equals(""))) {
			middleEarL = req.getParameter(MIDDLE_EAR_L);
		}
		if (req.getParameter(ANY_EVIDENCE_OF_TRACHOMA) != null
				&& !(req.getParameter(ANY_EVIDENCE_OF_TRACHOMA).equals(""))) {
			evidienceOfTrachoma = req.getParameter(ANY_EVIDENCE_OF_TRACHOMA);
		}
		if (req.getParameter(BINOCULAR_VISION_GRADE) != null
				&& !(req.getParameter(BINOCULAR_VISION_GRADE).equals(""))) {
			binocular = req.getParameter(BINOCULAR_VISION_GRADE);
		}
		if (req.getParameter(MANIFEST_HYPERMETROPIA) != null
				&& !(req.getParameter(MANIFEST_HYPERMETROPIA).equals(""))) {
			manifestHypermetropia = req.getParameter(MANIFEST_HYPERMETROPIA);
		}
		if (req.getParameter(COVER_TEST) != null
				&& !(req.getParameter(COVER_TEST).equals(""))) {
			coverTest = req.getParameter(COVER_TEST);
		}
		if (req.getParameter(DIAPHRAGM_TEST) != null
				&& !(req.getParameter(DIAPHRAGM_TEST).equals(""))) {
			diaphragmTest = req.getParameter(DIAPHRAGM_TEST);
		}
		if (req.getParameter(FUND_MEDIA) != null
				&& !(req.getParameter(FUND_MEDIA).equals(""))) {
			fundMedia = req.getParameter(FUND_MEDIA);
		}
		if (req.getParameter(FIELDS) != null
				&& !(req.getParameter(FIELDS).equals(""))) {
			fields = req.getParameter(FIELDS);
		}
		if (req.getParameter(NIGHT_VISUAL_CAPACITY) != null
				&& !(req.getParameter(NIGHT_VISUAL_CAPACITY).equals(""))) {
			nightVisualCapacity = req.getParameter(NIGHT_VISUAL_CAPACITY);
		}
		if (req.getParameter(DENTAL_REMARKS) != null
				&& !(req.getParameter(DENTAL_REMARKS).equals(""))) {
			dentalRemarks = req.getParameter(DENTAL_REMARKS);
		}

		if (req.getParameter(DENTAL_DATE) != null
				&& !(req.getParameter(DENTAL_DATE).equals(""))) {
			dentalDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DENTAL_DATE));
		}
		if (req.getParameter(MENSTRUAL_HISTORY) != null
				&& !(req.getParameter(MENSTRUAL_HISTORY).equals(""))) {
			menstrualHistory = req.getParameter(MENSTRUAL_HISTORY);
		}
		if (req.getParameter(NO_OF_PREGNANCY) != null
				&& !(req.getParameter(NO_OF_PREGNANCY).equals(""))) {
			noOfPregnancy = Integer.parseInt(req.getParameter(NO_OF_PREGNANCY));
		}
		if (req.getParameter(NO_OF_ABORTION) != null
				&& !(req.getParameter(NO_OF_ABORTION).equals(""))) {
			noOfAbortion = Integer.parseInt(req.getParameter(NO_OF_ABORTION));
		}
		if (req.getParameter(NO_OF_CHILDREN) != null
				&& !(req.getParameter(NO_OF_CHILDREN).equals(""))) {
			noOfChildren = Integer.parseInt(req.getParameter(NO_OF_CHILDREN));
		}
		if (req.getParameter(DATE_OF_LASTCONFINEMENT) != null
				&& !(req.getParameter(DATE_OF_LASTCONFINEMENT).equals(""))) {
			lastCondinement = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DATE_OF_LASTCONFINEMENT));
		}
		if (req.getParameter(VAGINAL_DISCHARGE) != null
				&& !(req.getParameter(VAGINAL_DISCHARGE).equals(""))) {
			vaginalDischarge = req.getParameter(VAGINAL_DISCHARGE);
		}
		if (req.getParameter(PROLAPSE) != null
				&& !(req.getParameter(PROLAPSE).equals(""))) {
			prolapse = req.getParameter(PROLAPSE);
		}
		if (req.getParameter(USG_ABORTION) != null
				&& !(req.getParameter(USG_ABORTION).equals(""))) {
			usgAbortion = req.getParameter(USG_ABORTION);
		}
		if (req.getParameter(GYANAECOLOGY_RAMARKS) != null
				&& !(req.getParameter(GYANAECOLOGY_RAMARKS).equals(""))) {
			gyanaecologyRemarks = req.getParameter(GYANAECOLOGY_RAMARKS);
		}
		if (req.getParameter(GYANAECOLOGY_DATE) != null
				&& !(req.getParameter(GYANAECOLOGY_DATE).equals(""))) {
			gyanaecologyDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(GYANAECOLOGY_DATE));
		}
		if (req.getParameter(GYANAECOLOGY_RAMARKS) != null
				&& !(req.getParameter(GYANAECOLOGY_RAMARKS).equals(""))) {
			gyanaecologyRemarks = req.getParameter(GYANAECOLOGY_RAMARKS);
		}
		if (req.getParameter(MEDICAL_BOARD_EXAMINATION) != null
				&& !(req.getParameter(MEDICAL_BOARD_EXAMINATION).equals(""))) {
			medicalBoardExamination = req
					.getParameter(MEDICAL_BOARD_EXAMINATION);
		}
		if (req.getParameter(MEDICAL_BOARD_EXAMINATION_PLACE) != null
				&& !(req.getParameter(MEDICAL_BOARD_EXAMINATION_PLACE)
						.equals(""))) {

			medicalBoardExaminationPlace = Integer.parseInt(req
					.getParameter(MEDICAL_BOARD_EXAMINATION_PLACE));

		}
		if (req.getParameter(MEDICAL_BOARD_EXAMINATION_DATE) != null
				&& !(req.getParameter(MEDICAL_BOARD_EXAMINATION_DATE)
						.equals(""))) {
			medicalBoardExaminationDate = HMSUtil.dateFormatterDDMMYYYY((req
					.getParameter(MEDICAL_BOARD_EXAMINATION_DATE)));
		}
		if (req.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION) != null
				&& !(req.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION)
						.equals(""))) {
			subsequentMedicalBoardExam = req
					.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION);
		}
		if (req.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_PLACE) != null
				&& !(req
						.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_PLACE)
						.equals(""))) {
			subsequentMedicalBoardExamPlace = Integer.parseInt(req
					.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_PLACE));
		}
		if (req.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_DATE) != null
				&& !(req
						.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_DATE)
						.equals(""))) {
			subsequentMedicalBoardExamDate = HMSUtil.dateFormatterDDMMYYYY((req
					.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_DATE)));
		}

		if (req.getParameter(APPROVING_AUTHORITY) != null
				&& !(req.getParameter(APPROVING_AUTHORITY).equals(""))) {
			ApprovingAuthority = req.getParameter(APPROVING_AUTHORITY);
		}
		if (req.getParameter(APPROVING_AUTHORITY_PLACE) != null
				&& !(req.getParameter(APPROVING_AUTHORITY_PLACE).equals(""))) {
			ApprovingAuthorityPlace = Integer.parseInt(req
					.getParameter(APPROVING_AUTHORITY_PLACE));
		}
		if (req.getParameter(APPROVING_AUTHORITY_DATE) != null
				&& !(req.getParameter(APPROVING_AUTHORITY_DATE).equals(""))) {
			ApprovingAuthorityDate = HMSUtil.dateFormatterDDMMYYYY((req
					.getParameter(APPROVING_AUTHORITY_DATE)));
		}
		if (req.getParameter(LMP) != null
				&& !(req.getParameter(LMP).equals(""))) {
			lmp = (req.getParameter(LMP));
		}

		if (req.getParameter(SURGERY_DATE) != null
				&& !(req.getParameter(SURGERY_DATE).equals(""))) {
			surgeyDate = HMSUtil.dateFormatterDDMMYYYY((req
					.getParameter(SURGERY_DATE)));
		}

		if (req.getParameter(MEDICIN_EXAM_DATE) != null
				&& !(req.getParameter(MEDICIN_EXAM_DATE).equals(""))) {
			medicinExamDate = HMSUtil.dateFormatterDDMMYYYY((req
					.getParameter(MEDICIN_EXAM_DATE)));

		}
		if (req.getParameter(TOTAL_NO_OF_TEETH) != null
				&& !(req.getParameter(TOTAL_NO_OF_TEETH).equals(""))) {
			totalTeeth = req.getParameter(TOTAL_NO_OF_TEETH);

		}
		if (req.getParameter(DEFECTIVE_TEETH) != null
				&& !(req.getParameter(DEFECTIVE_TEETH).equals(""))) {
			totalDefectiveTeeth = req.getParameter(DEFECTIVE_TEETH);

		}
		if (req.getParameter(MISSING_TEETH) != null
				&& !(req.getParameter(MISSING_TEETH).equals(""))) {
			missingTeeth = req.getParameter(MISSING_TEETH);

		}
		if (req.getParameter(MISSING_UNSERVICABLE_TEETH) != null
				&& !(req.getParameter(MISSING_UNSERVICABLE_TEETH).equals(""))) {
			unserviceableTeeth = req.getParameter(MISSING_UNSERVICABLE_TEETH);

		}
		if (req.getParameter(DENTSL_POINT) != null
				&& !(req.getParameter(DENTSL_POINT).equals(""))) {
			DenstalPoint = req.getParameter(DENTSL_POINT);

		}

		if (req.getParameter(LAST_CHANGED_BY) != null) {
			lastChangedBy = req.getParameter(LAST_CHANGED_BY);
		}
		if (req.getParameter(LAST_CHANGED_DATE) != null) {
			lastChangedDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(LAST_CHANGED_DATE));
		}
		if (req.getParameter(LAST_CHANGED_TIME) != null) {
			lastChangedTime = req.getParameter(LAST_CHANGED_TIME);
		}
		// //////////////////////////////////

		if (req.getParameter(DUR_8) != null) {
			dur8 = (req.getParameter(DUR_8));

		} else {
			dur8 = "N";

		}

		if (req.getParameter(DUR_7) != null) {
			dur7 = (req.getParameter(DUR_7));

		} else {
			dur7 = "N";

		}
		if (req.getParameter(DUR_6) != null) {
			dur6 = (req.getParameter(DUR_6));

		} else {
			dur6 = "N";

		}
		if (req.getParameter(DUR_5) != null) {
			dur5 = (req.getParameter(DUR_5));

		} else {
			dur5 = "N";

		}

		if (req.getParameter(DUR_4) != null) {
			dur4 = (req.getParameter(DUR_4));
		} else {
			dur4 = "N";

		}
		if (req.getParameter(DUR_3) != null) {
			dur3 = (req.getParameter(DUR_3));

		} else {
			dur3 = "N";

		}
		if (req.getParameter(DUR_2) != null) {
			dur2 = (req.getParameter(DUR_2));

		} else {
			dur2 = "N";

		}
		if (req.getParameter(DUR_1) != null) {
			dur1 = (req.getParameter(DUR_1));

		} else {
			dur1 = "N";

		}

		if (req.getParameter(DUL_8) != null) {
			dul8 = (req.getParameter(DUL_8));
		} else {
			dul8 = "N";

		}
		if (req.getParameter(DUL_7) != null) {
			dul7 = (req.getParameter(DUL_7));

		} else {
			dul7 = "N";

		}
		if (req.getParameter(DUL_6) != null) {
			dul6 = (req.getParameter(DUL_6));
		} else {
			dul6 = "N";

		}
		if (req.getParameter(DUL_5) != null) {
			dul5 = (req.getParameter(DUL_5));
		} else {
			dul5 = "N";

		}
		if (req.getParameter(DUL_4) != null) {
			dul4 = (req.getParameter(DUL_4));
		} else {
			dul4 = "N";

		}
		if (req.getParameter(DUL_3) != null) {
			dul3 = (req.getParameter(DUL_3));
		} else {
			dul3 = "N";

		}
		if (req.getParameter(DUL_2) != null) {
			dul2 = (req.getParameter(DUL_2));
		} else {
			dul2 = "N";

		}
		if (req.getParameter(DUL_1) != null) {
			dul1 = (req.getParameter(DUL_1));
		} else {
			dul1 = "N";

		}

		if (req.getParameter(DLR_8) != null) {
			dlr8 = (req.getParameter(DLR_8));
		} else {
			dlr8 = "N";

		}
		if (req.getParameter(DLR_7) != null) {
			dlr7 = (req.getParameter(DLR_7));
		} else {
			dlr7 = "N";

		}
		if (req.getParameter(DLR_6) != null) {
			dlr6 = (req.getParameter(DLR_6));
		} else {
			dlr6 = "N";

		}
		if (req.getParameter(DLR_5) != null) {
			dlr5 = (req.getParameter(DLR_5));
		} else {
			dlr5 = "N";

		}
		if (req.getParameter(DLR_4) != null) {
			dlr4 = (req.getParameter(DLR_4));
		} else {
			dlr4 = "N";

		}
		if (req.getParameter(DLR_3) != null) {
			dlr3 = (req.getParameter(DLR_3));
		} else {
			dlr3 = "N";

		}
		if (req.getParameter(DLR_2) != null) {
			dlr2 = (req.getParameter(DLR_2));
		} else {
			dlr2 = "N";

		}

		if (req.getParameter(DLR_1) != null) {
			dlr1 = (req.getParameter(DLR_1));
		} else {
			dlr1 = "N";

		}

		if (req.getParameter(DLL_8) != null) {
			dll8 = (req.getParameter(DLL_8));
		} else {
			dll8 = "N";

		}
		if (req.getParameter(DLL_7) != null) {
			dll7 = (req.getParameter(DLL_7));
		} else {
			dll7 = "N";

		}

		if (req.getParameter(DLL_6) != null) {
			dll6 = (req.getParameter(DLL_6));
		} else {
			dll6 = "N";

		}
		if (req.getParameter(DLL_5) != null) {
			dll5 = (req.getParameter(DLL_5));
		} else {
			dll5 = "N";

		}
		if (req.getParameter(DLL_4) != null) {
			dll4 = (req.getParameter(DLL_4));
		} else {
			dll4 = "N";

		}
		if (req.getParameter(DLL_3) != null) {
			dll3 = (req.getParameter(DLL_3));
		} else {
			dll3 = "N";

		}
		if (req.getParameter(DLL_2) != null) {
			dll2 = (req.getParameter(DLL_2));
		} else {
			dll2 = "N";

		}
		if (req.getParameter(DLL_1) != null) {
			dll1 = (req.getParameter(DLL_1));
		} else {
			dll1 = "N";

		}
		// ///////////////////////////

		if (req.getParameter(UUR_8) != null) {
			uur8 = (req.getParameter(UUR_8));
		} else {
			uur8 = "N";

		}

		if (req.getParameter(UUR_7) != null) {
			uur7 = (req.getParameter(UUR_7));
		} else {
			uur7 = "N";

		}
		if (req.getParameter(UUR_6) != null) {
			uur6 = (req.getParameter(UUR_6));
		} else {
			uur6 = "N";

		}
		if (req.getParameter(UUR_5) != null) {
			uur5 = (req.getParameter(UUR_5));
		} else {
			uur5 = "N";

		}
		if (req.getParameter(UUR_4) != null) {
			uur4 = (req.getParameter(UUR_4));
		} else {
			uur4 = "N";

		}
		if (req.getParameter(UUR_3) != null) {
			uur3 = (req.getParameter(UUR_3));
		} else {
			uur3 = "N";

		}
		if (req.getParameter(UUR_2) != null) {
			uur2 = (req.getParameter(UUR_2));
		} else {
			uur2 = "N";

		}
		if (req.getParameter(UUR_1) != null) {
			uur1 = (req.getParameter(UUR_1));
		} else {
			uur1 = "N";

		}

		if (req.getParameter(UUL_8) != null) {
			uul8 = (req.getParameter(UUL_8));
		} else {
			uul8 = "N";

		}
		if (req.getParameter(UUL_7) != null) {
			uul7 = (req.getParameter(UUL_7));

		} else {
			uul7 = "N";

		}
		if (req.getParameter(UUL_6) != null) {
			uul6 = (req.getParameter(UUL_6));
		} else {
			uul6 = "N";

		}
		if (req.getParameter(UUL_5) != null) {
			uul5 = (req.getParameter(UUL_5));
		} else {
			uul5 = "N";

		}
		if (req.getParameter(UUL_4) != null) {
			uul4 = (req.getParameter(UUL_4));
		} else {
			uul4 = "N";

		}
		if (req.getParameter(UUL_3) != null) {
			uul3 = (req.getParameter(UUL_3));
		} else {
			uul3 = "N";

		}
		if (req.getParameter(UUL_2) != null) {
			uul2 = (req.getParameter(UUL_2));
		} else {
			uul2 = "N";

		}
		if (req.getParameter(UUL_1) != null) {
			uul1 = (req.getParameter(UUL_1));
		} else {
			uul1 = "N";

		}
		if (req.getParameter(ULR_8) != null) {
			ulr8 = (req.getParameter(ULR_8));
		} else {
			ulr8 = "N";

		}

		if (req.getParameter(ULR_7) != null) {
			ulr7 = (req.getParameter(ULR_7));
		} else {
			ulr7 = "N";

		}
		if (req.getParameter(ULR_6) != null) {
			ulr6 = (req.getParameter(ULR_6));
		} else {
			ulr6 = "N";

		}
		if (req.getParameter(ULR_5) != null) {
			ulr5 = (req.getParameter(ULR_5));
		} else {
			ulr5 = "N";

		}
		if (req.getParameter(ULR_4) != null) {
			ulr4 = (req.getParameter(ULR_4));
		} else {
			ulr4 = "N";

		}
		if (req.getParameter(ULR_3) != null) {
			ulr3 = (req.getParameter(ULR_3));
		} else {
			ulr3 = "N";

		}
		if (req.getParameter(ULR_2) != null) {
			ulr2 = (req.getParameter(ULR_2));
		} else {
			ulr2 = "N";

		}
		if (req.getParameter(ULR_1) != null) {
			ulr1 = (req.getParameter(ULR_1));
		} else {
			ulr1 = "N";

		}

		if (req.getParameter(ULL_8) != null) {
			ull8 = (req.getParameter(ULL_8));
		} else {
			ull8 = "N";

		}
		if (req.getParameter(ULL_7) != null) {
			ull7 = (req.getParameter(ULL_7));
		} else {
			ull7 = "N";

		}
		if (req.getParameter(ULL_6) != null) {
			ull6 = (req.getParameter(ULL_6));
		} else {
			ull6 = "N";

		}
		if (req.getParameter(ULL_5) != null) {
			ull5 = (req.getParameter(ULL_5));
		} else {
			ull5 = "N";

		}
		if (req.getParameter(ULL_4) != null) {
			ull4 = (req.getParameter(ULL_4));
		} else {
			ull4 = "N";

		}
		if (req.getParameter(ULL_3) != null) {
			ull3 = (req.getParameter(ULL_3));
		} else {
			ull3 = "N";

		}
		if (req.getParameter(ULL_2) != null) {
			ull2 = (req.getParameter(ULL_2));
		} else {
			ull2 = "N";

		}
		if (req.getParameter(ULL_1) != null) {
			ull1 = (req.getParameter(ULL_1));
		} else {
			ull1 = "N";

		}

		// ////////////////////////

		if (req.getParameter(MUR_8) != null) {
			mur8 = (req.getParameter(MUR_8));

		} else {
			mur8 = "N";

		}
		if (req.getParameter(MUR_7) != null) {
			mur7 = (req.getParameter(MUR_7));
		} else {
			mur7 = "N";

		}
		if (req.getParameter(MUR_6) != null) {
			mur6 = (req.getParameter(MUR_6));
		} else {
			mur6 = "N";

		}
		if (req.getParameter(MUR_5) != null) {
			mur5 = (req.getParameter(MUR_5));
		} else {
			mur5 = "N";

		}
		if (req.getParameter(MUR_4) != null) {
			mur4 = (req.getParameter(MUR_4));
		} else {
			mur4 = "N";

		}
		if (req.getParameter(MUR_3) != null) {
			mur3 = (req.getParameter(MUR_3));
		} else {
			mur3 = "N";

		}
		if (req.getParameter(MUR_2) != null) {
			mur2 = (req.getParameter(MUR_2));
		} else {
			mur2 = "N";

		}
		if (req.getParameter(MUR_1) != null) {
			mur1 = (req.getParameter(MUR_1));
		} else {
			mur1 = "N";

		}

		if (req.getParameter(MUL_8) != null) {
			mul8 = (req.getParameter(MUL_8));
		} else {
			mul8 = "N";

		}
		if (req.getParameter(MUL_7) != null) {
			mul7 = (req.getParameter(MUL_7));

		} else {
			mul7 = "N";

		}
		if (req.getParameter(MUL_6) != null) {
			mul6 = (req.getParameter(MUL_6));
		} else {
			mul6 = "N";

		}
		if (req.getParameter(MUL_5) != null) {
			mul5 = (req.getParameter(MUL_5));
		} else {
			mul5 = "N";

		}
		if (req.getParameter(MUL_4) != null) {
			mul4 = (req.getParameter(MUL_4));
		} else {
			mul4 = "N";

		}
		if (req.getParameter(MUL_3) != null) {
			mul3 = (req.getParameter(MUL_3));
		} else {
			mul3 = "N";

		}
		if (req.getParameter(MUL_2) != null) {
			mul2 = (req.getParameter(MUL_2));
		} else {
			mul2 = "N";

		}
		if (req.getParameter(MUL_1) != null) {
			mul1 = (req.getParameter(MUL_1));
		} else {
			mul1 = "N";

		}
		if (req.getParameter(MLR_8) != null) {
			mlr8 = (req.getParameter(MLR_8));
		} else {
			mlr8 = "N";

		}

		if (req.getParameter(MLR_7) != null) {
			mlr7 = (req.getParameter(MLR_7));
		} else {
			mlr7 = "N";

		}
		if (req.getParameter(MLR_6) != null) {
			mlr6 = (req.getParameter(MLR_6));
		} else {
			mlr6 = "N";

		}
		if (req.getParameter(MLR_5) != null) {
			mlr5 = (req.getParameter(MLR_5));
		} else {
			mlr5 = "N";

		}

		if (req.getParameter(MLR_4) != null) {
			mlr4 = (req.getParameter(MLR_4));
		} else {
			mlr4 = "N";

		}
		if (req.getParameter(MLR_3) != null) {
			mlr3 = (req.getParameter(MLR_3));
		} else {
			mlr3 = "N";

		}

		if (req.getParameter(MLR_2) != null) {
			mlr2 = (req.getParameter(MLR_2));
		} else {
			mlr2 = "N";

		}
		if (req.getParameter(MLR_1) != null) {
			mlr1 = (req.getParameter(MLR_1));
		} else {
			mlr1 = "N";

		}

		if (req.getParameter(MLL_8) != null) {
			mll8 = (req.getParameter(MLL_8));
		} else {
			mll8 = "N";

		}
		if (req.getParameter(MLL_7) != null) {
			mll7 = (req.getParameter(MLL_7));
		} else {
			mll7 = "N";

		}
		if (req.getParameter(MLL_6) != null) {
			mll6 = (req.getParameter(MLL_6));
		} else {
			mll6 = "N";

		}
		if (req.getParameter(MLL_5) != null) {
			mll5 = (req.getParameter(MLL_5));
		} else {
			mll5 = "N";

		}
		if (req.getParameter(MLL_4) != null) {
			mll4 = (req.getParameter(MLL_4));
		} else {
			mll4 = "N";

		}
		if (req.getParameter(MLL_3) != null) {
			mll3 = (req.getParameter(MLL_3));
		} else {
			mll3 = "N";

		}
		if (req.getParameter(MLL_2) != null) {
			mll2 = (req.getParameter(MLL_2));
		} else {
			mll2 = "N";

		}
		if (req.getParameter(MLL_1) != null) {
			mll1 = (req.getParameter(MLL_1));
		} else {
			mll1 = "N";

		}

		sur8 = dur8 + "" + mur8 + "" + uur8;

		sur7 = dur7 + "" + mur7 + "" + uur7;

		sur6 = dur6 + "" + mur6 + "" + uur6;
		sur5 = dur5 + "" + mur5 + "" + uur5;
		sur4 = dur4 + "" + mur4 + "" + uur4;
		sur3 = dur3 + "" + mur3 + "" + uur3;
		sur2 = dur2 + "" + mur2 + "" + uur2;
		sur1 = dur1 + "" + mur2 + "" + uur1;

		sul8 = dul8 + "" + mul8 + "" + uul8;
		sul7 = dul7 + "" + mul7 + "" + uul7;

		sul6 = dul6 + "" + mul6 + "" + uul6;
		sul5 = dul5 + "" + mul5 + "" + uul5;
		sul4 = dul4 + "" + mul4 + "" + uul4;
		sul3 = dul3 + "" + mul3 + "" + uul3;
		sul2 = dul2 + "" + mul2 + "" + uul2;
		sul1 = dul1 + "" + mul1 + "" + uul1;

		slr8 = dlr8 + "" + mlr8 + "" + ulr8;
		slr7 = dlr7 + "" + mlr7 + "" + ulr7;
		slr6 = dlr6 + "" + mlr6 + "" + ulr6;
		slr5 = dlr5 + "" + mlr5 + "" + ulr5;
		slr4 = dlr4 + "" + mlr4 + "" + ulr4;
		slr3 = dlr3 + "" + mlr3 + "" + ulr3;
		slr2 = dlr2 + "" + mlr2 + "" + ulr2;
		slr1 = dlr1 + "" + mlr2 + "" + ulr1;

		sll8 = dll8 + "" + mll8 + "" + ull8;
		sll7 = dll7 + "" + mll7 + "" + ull7;
		sll6 = dll6 + "" + mll6 + "" + ull6;
		sll5 = dll5 + "" + mll5 + "" + ull5;
		sll4 = dll4 + "" + mll4 + "" + ull4;
		sll3 = dll3 + "" + mll3 + "" + ull3;
		sll2 = dll2 + "" + mll2 + "" + ull2;
		sll1 = dll1 + "" + mll2 + "" + ull1;
		MbTypeOfEntryMaster mbTypeOfEntryMaster = new MbTypeOfEntryMaster();
		mbTypeOfEntryMaster.setId(typeOfEntry);
		generalMap.put("serviceNo", serviceNo);
		// generalMap.put("name", betchNo);
		// generalMap.put("address", req.getParameter(TYPE_OF_ENTRY));

		// generalMap.put("pojoPropertyName", "BatchNo");
		generalMap.put("pojoPropertyCode", "serviceNo");
		// generalMap.put("pojoPropertyAddress", "TypeOfEntry");
		generalMap.put("pojoName", "MasMedicalExaminationReportOnEntry");
		String message = "";
		String jsp = "";
		Map listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		Boolean successfullyAdded = false;
		List codeList = (List) listMap.get("duplicateGeneralCodeList");
		// List nameList = (List) listMap.get("duplicateGeneralNameList");
		// List typeOfEntryList = (List)
		// listMap.get("duplicateGeneralAddressList");
		if (codeList != null && codeList.size() > 0) {
			message = "Yearly Serial No Already Exist!";
			jsp = MEDICAL_BOARD_ERROR_MSG;
		} else {
			masMedicalBoardProceedings.setInnerEarL(innerEarL);
			masMedicalBoardProceedings.setHearingBothCv(hearingBothCV);
			masMedicalBoardProceedings.setDateSpecialExam(eyeDate);
			masMedicalBoardProceedings
					.setTotalDefectiveTeeth(totalDefectiveTeeth);
			masMedicalBoardProceedings.setTotalTeeth(totalTeeth);
			masMedicalBoardProceedings.setMissingTeeth(missingTeeth);
			masMedicalBoardProceedings.setUnservisableTeeth(unserviceableTeeth);
			masMedicalBoardProceedings.setDenstlPoint(DenstalPoint);
			masMedicalBoardProceedings.setYearlySerialNo(serviceNo);
			masMedicalBoardProceedings.setMonthlySerialNo(rank);
			masMedicalBoardProceedings.setEntryDate(entryDate);

			masMedicalBoardProceedings.setTypeOfEntry(mbTypeOfEntryMaster);
			masMedicalBoardProceedings.setBatchNo(betchNo);
			masMedicalBoardProceedings.setChestNo(chestNo);
			masMedicalBoardProceedings.setRollNo(rollNo);
			MasUnit masUnit = new MasUnit();
			masUnit.setId(medicalExamHeld);
			masMedicalBoardProceedings.setMedicalExamHeldAt(masUnit);
			masMedicalBoardProceedings.setMedicalStatus(medicalStatus);
			masMedicalBoardProceedings.setNameInFull(fullName);
			masMedicalBoardProceedings.setDateOfBirth(dateOfBirth);
			MasMaritalStatus masMaritalStatus = new MasMaritalStatus();
			masMaritalStatus.setId(maritialStatus);
			masMedicalBoardProceedings.setMaritalStatus(masMaritalStatus);
	//		masMedicalBoardProceedings.setService(service);
			masMedicalBoardProceedings.setPNo(pNo);
//			masMedicalBoardProceedings.setRank(rank);
			masMedicalBoardProceedings.setHoursOfFlown(hoursOfFlown);
			masMedicalBoardProceedings.setParmanentAddress(permanentAddress);
			masMedicalBoardProceedings.setIdentificationMarks1(identification1);
			masMedicalBoardProceedings.setIdentificationMarks2(identification2);
			masMedicalBoardProceedings.setArmsCorps(armsCrops);
			masMedicalBoardProceedings.setDateOfCompletion(dateOfCompletion);
			masMedicalBoardProceedings
					.setDocumentForwardDate(documentForwardDate);
			masMedicalBoardProceedings.setDateOfReporting(dateOfReporting);
			masMedicalBoardProceedings.setDocumentForwardTo(documentForwardTo);
			masMedicalBoardProceedings.setFromWhereHeReport(fromWhereHeReport);
			masMedicalBoardProceedings.setHypertension(hypertension);
			masMedicalBoardProceedings.setHeartDiabetes(heartDisease);
			masMedicalBoardProceedings.setDiabetes(diabetes);
			masMedicalBoardProceedings.setBleedingDisorder(bleedingDisorder);
			masMedicalBoardProceedings.setMentalDisease(mentalDisease);
			masMedicalBoardProceedings.setNightBlindness(nightBlindness);
			masMedicalBoardProceedings.setChronicBronchitis(asthama);
			masMedicalBoardProceedings.setDischargeFromEars(dischargeFrom);
			masMedicalBoardProceedings.setPleurisy(plesury);
			masMedicalBoardProceedings.setAnyOtherEarDisease(earDieses);
			masMedicalBoardProceedings
					.setRheumatismFrequentSorethroats(rheumatism);
			masMedicalBoardProceedings
					.setFrequentCoughColdSinusitis(frequentCough);
			masMedicalBoardProceedings
					.setChronicIndigestion(chronicIndigestion);
			masMedicalBoardProceedings
					.setNervousBreakdownMentalIllness(nervousBrakdown);
			masMedicalBoardProceedings.setKidneyBladderTrouble(kidenyBladder);
			masMedicalBoardProceedings
					.setFitsFaintingAttack(fitsFaintinngAttacks);
			masMedicalBoardProceedings.setStd(std);
			masMedicalBoardProceedings.setSevereHeadInjury(serveHeadInjury);
			masMedicalBoardProceedings.setJaundice(joundice);
			masMedicalBoardProceedings.setAirSeaCarTrainSickness(sickness);
			masMedicalBoardProceedings.setBreastDiseaseDischarge(breastDisease);
			masMedicalBoardProceedings.setTrachoma(trachoma);
			masMedicalBoardProceedings.setAmenorrhoeaDysmenonhoea(amenorrhoea);
			masMedicalBoardProceedings.setNightBindness(nightbindness);
			masMedicalBoardProceedings.setMenonhagia(menirrhagia);
			masMedicalBoardProceedings
					.setLaserTreatementSurgeryForEye(laserTeartement);
			masMedicalBoardProceedings.setPregnancy(pregnancy);
			masMedicalBoardProceedings.setAnyOtherEyeDisease(eyeDisease);
			masMedicalBoardProceedings.setAbortion(abortion);
			masMedicalBoardProceedings
					.setBeenrejectedAsMedicallyUnfitForAnyBranch(rejectedAsUnfit);
			masMedicalBoardProceedings
					.setDischargeAsMedicallyUnfitForAnyBranch(dischargeMedicallyUnfit);
			masMedicalBoardProceedings
					.setAdmittedInHospitalForAnyIllnessOperationOrInjury(adimmitedInHospitalFirIllness);

			masMedicalBoardProceedings
					.setStateTheNatureOfDiseaseDuration(stateNature);
			masMedicalBoardProceedings
					.setAnyOtherInformationAboutYourHealth(otherInform);
			masMedicalBoardProceedings.setHeight(height);
			masMedicalBoardProceedings.setWeight(weight);
			masMedicalBoardProceedings.setAcceptable(acceptableKg);
			masMedicalBoardProceedings.setLegLength(leglength);
			masMedicalBoardProceedings.setAppearance(appereance);
			masMedicalBoardProceedings.setAlbumin(albumin);
			masMedicalBoardProceedings.setSugar(sugar);
			masMedicalBoardProceedings.setSpGravity(spGraviry);
			masMedicalBoardProceedings.setHbPercentage(hbPercentage);
			masMedicalBoardProceedings.setAnyOtherInvCarriedOut(anyOtherInv);
			masMedicalBoardProceedings.setPhysique(physique);
			masMedicalBoardProceedings.setSkin(skin);
			masMedicalBoardProceedings.setAbdomen(abdomen);
			masMedicalBoardProceedings.setHeartSize(heartSize);
			masMedicalBoardProceedings.setSounds(sound);
			masMedicalBoardProceedings.setRhythm(rhythm);
			masMedicalBoardProceedings.setArterialWalls(arterialWalls);
			masMedicalBoardProceedings.setPulseRates(pulseRates);
			masMedicalBoardProceedings.setBp(bp);
			masMedicalBoardProceedings.setChestMeasurement(fullExpension);
			masMedicalBoardProceedings.setRangeOfExpension(rangeOfExpension);
			masMedicalBoardProceedings.setSelfBalancingR(selfBalR);
			masMedicalBoardProceedings.setSelfBalancingL(selfBalL);
			masMedicalBoardProceedings.setSpeechMentalCapacity(speechMental);
			masMedicalBoardProceedings.setEndocrineCondition(endocrinCond);
			masMedicalBoardProceedings
					.setAnyOtheAbnormalities(otherAbnormalities);
			masMedicalBoardProceedings.setRemarks(medicinRemarks);
			masMedicalBoardProceedings.setFingers(finger);
			masMedicalBoardProceedings.setHand(hand);
			masMedicalBoardProceedings.setWrists(wrist);
			masMedicalBoardProceedings.setElbows(elbows);
			masMedicalBoardProceedings.setShoulderGirdles(shoulderGridles);
			masMedicalBoardProceedings.setCervical(cercival);
			masMedicalBoardProceedings.setDorsalVertebrate(dorsalVertebrate);
			masMedicalBoardProceedings.setHullux(hullux);
			masMedicalBoardProceedings.setValgus(valgus);
			masMedicalBoardProceedings.setRigigus(riggus);
			masMedicalBoardProceedings.setFlatFeet(flatFeet);
			masMedicalBoardProceedings.setJoints(joints);
			masMedicalBoardProceedings.setPelvis(pelvis);
			masMedicalBoardProceedings.setGail(gail);
			masMedicalBoardProceedings.setLumber(lumberScaler);
			masMedicalBoardProceedings.setRoccyxVarocose(roccyxVericose);
			masMedicalBoardProceedings.setHydrocele(hydrocele);
			masMedicalBoardProceedings.setVaricocele(varicocele);
			masMedicalBoardProceedings.setUnderscendedTest(underScende);
			masMedicalBoardProceedings.setHemorrhoids(hemonhoids);
			masMedicalBoardProceedings.setHerniaMusic(herinaMusic);
			masMedicalBoardProceedings.setBreasts(breasts);
			masMedicalBoardProceedings.setRemarksLowerlimbs(surgeryRemarks);
			masMedicalBoardProceedings.setRespiratorySystem(respatorySystem);
			masMedicalBoardProceedings
					.setWithGlassesLDistant(withglassesDistantL);
			masMedicalBoardProceedings
					.setWithGlassesRDistant(withGlassesDistantR);
			masMedicalBoardProceedings
					.setWithoutGlassesLDistant(withoutGlassesDistantL);
			masMedicalBoardProceedings
					.setWthoutGlassesRDistant(withoutGlassesDistantR);
			masMedicalBoardProceedings
					.setWithGlassesLNearvision(withGlassesNearL);
			masMedicalBoardProceedings
					.setWithGlassesRNearvision(withGlassesNearR);
			masMedicalBoardProceedings
					.setWithoutGlassesLNearvision(withoutGlassesNearL);
			masMedicalBoardProceedings
					.setWithoutGlassesRNearvision(withoutGlassesNearR);
			masMedicalBoardProceedings
					.setEvidenceOfTrachoma(evidienceOfTrachoma);
			masMedicalBoardProceedings.setBinocularVisionGrade(binocular);
			masMedicalBoardProceedings
					.setManifestHypermetropia(manifestHypermetropia);
			masMedicalBoardProceedings.setCoverTest(coverTest);
			masMedicalBoardProceedings.setDiaphragmTest(diaphragmTest);
			masMedicalBoardProceedings.setFundAndMedia(fundMedia);
			masMedicalBoardProceedings.setFields(fields);
			masMedicalBoardProceedings
					.setNightVisualCapacity(nightVisualCapacity);
			masMedicalBoardProceedings.setConvergenceC(convergenceC);
			masMedicalBoardProceedings.setConvergenceSc(convergenceCP);
			masMedicalBoardProceedings.setAccommodationR(accommodationR);
			masMedicalBoardProceedings.setAccommodationL(accommodationL);
			masMedicalBoardProceedings.setRemarksSpecialExam(eyeRemarks);
			masMedicalBoardProceedings.setHearingRcv(hearingRCV);
			masMedicalBoardProceedings.setHearingLcv(hearingLCV);
			masMedicalBoardProceedings.setEarHearingRfw(hearingRFW);
			masMedicalBoardProceedings.setEarHearingLfw(hearingLFW);
			masMedicalBoardProceedings.setEarHearingBothFw(hearingBothFW);
			masMedicalBoardProceedings.setExternalEarR(externalEarR);
			masMedicalBoardProceedings.setExternalEarL(externalEarL);
			masMedicalBoardProceedings.setMiddleEarR(middleEarR);
			masMedicalBoardProceedings.setMiddleEar(middleEarL);

			masMedicalBoardProceedings.setInnerEarR(innerEarR);
			masMedicalBoardProceedings.setAudiometryRecord(audiometryRecord);
			masMedicalBoardProceedings.setNose(nose);
			masMedicalBoardProceedings.setThroat(throatEar);
			masMedicalBoardProceedings.setRemarksEar(earReamrks);
			masMedicalBoardProceedings.setEarDate(earDate);
			masMedicalBoardProceedings.setDateTeath(dentalDate);
			masMedicalBoardProceedings.setRemarksTeath(dentalRemarks);
			masMedicalBoardProceedings.setMenstrualHistory(menstrualHistory);
			masMedicalBoardProceedings.setNoOfPregnancies(noOfPregnancy);
			masMedicalBoardProceedings.setNoOfAbortions(noOfAbortion);
			masMedicalBoardProceedings.setNoOfChildren(noOfChildren);
			masMedicalBoardProceedings.setLastConfinementDate(lastCondinement);
			masMedicalBoardProceedings.setVaginalDischarge(vaginalDischarge);
			masMedicalBoardProceedings.setProlapse(prolapse);
			masMedicalBoardProceedings.setUsgAbdomen(usgAbortion);
			masMedicalBoardProceedings.setGynaecologyDate(gyanaecologyDate);
			masMedicalBoardProceedings
					.setRemarksGynaecology(gyanaecologyRemarks);
			masMedicalBoardProceedings
					.setMedicalBoardFindings(medicalBoardExamination);
			masMedicalBoardProceedings
					.setDateMedicalBoardExam(medicalBoardExaminationDate);
		//	masMedicalBoardProceedings.setLmp(lmp);
			if (medicalBoardExaminationPlace != 0) {
				MasUnit masUnit1 = new MasUnit();
				masUnit1.setId(medicalBoardExaminationPlace);
				masMedicalBoardProceedings.setPlaceMedicalBoardExam(masUnit1);
			}
			masMedicalBoardProceedings
					.setMedicalBoardSubsequentFind(subsequentMedicalBoardExam);
			masMedicalBoardProceedings
					.setDateMedicalBoardSubsequent(subsequentMedicalBoardExamDate);
			if (subsequentMedicalBoardExamPlace != 0) {
				MasUnit masUnit2 = new MasUnit();
				masUnit2.setId(subsequentMedicalBoardExamPlace);
				masMedicalBoardProceedings
						.setPlaceMedicalBoardSubsequent(masUnit2);
			}
			masMedicalBoardProceedings
					.setApprovingAuthority(ApprovingAuthority);
			masMedicalBoardProceedings
					.setDateApprovingAuthority(ApprovingAuthorityDate);
			if (ApprovingAuthorityPlace != 0) {
				MasUnit masUnit3 = new MasUnit();
				masUnit3.setId(ApprovingAuthorityPlace);
				masMedicalBoardProceedings.setPlaceApprovingAuthority(masUnit3);
			}
			masMedicalBoardProceedings.setSurgeryDate(surgeyDate);
			masMedicalBoardProceedings.setMediceExamDate(medicinExamDate);
			masMedicalBoardProceedings
					.setNearVisionWithGlassCp(withGlassesNearCP);
			masMedicalBoardProceedings
					.setNearVisionWithoutGlassCp(withoutGlassesNearCP);
			masMedicalBoardProceedings.setUR1(sur1);
			masMedicalBoardProceedings.setUR2(sur2);
			masMedicalBoardProceedings.setUR3(sur3);
			masMedicalBoardProceedings.setUR4(sur4);
			masMedicalBoardProceedings.setUR5(sur5);
			masMedicalBoardProceedings.setUR6(sur6);
			masMedicalBoardProceedings.setUR7(sur7);
			masMedicalBoardProceedings.setUR8(sur8);

			masMedicalBoardProceedings.setUL1(sul1);
			masMedicalBoardProceedings.setUL2(sul2);
			masMedicalBoardProceedings.setUL3(sul3);
			masMedicalBoardProceedings.setUL4(sul4);
			masMedicalBoardProceedings.setUL5(sul5);
			masMedicalBoardProceedings.setUL6(sul6);
			masMedicalBoardProceedings.setUL7(sul7);
			masMedicalBoardProceedings.setUL8(sul8);

			masMedicalBoardProceedings.setLR1(slr1);
			masMedicalBoardProceedings.setLR2(slr2);
			masMedicalBoardProceedings.setLR3(slr3);
			masMedicalBoardProceedings.setLR4(slr4);
			masMedicalBoardProceedings.setLR5(slr5);
			masMedicalBoardProceedings.setLR6(slr6);
			masMedicalBoardProceedings.setLR7(slr7);
			masMedicalBoardProceedings.setLR8(slr8);

			masMedicalBoardProceedings.setLL1(sll1);
			masMedicalBoardProceedings.setLL2(sll2);
			masMedicalBoardProceedings.setLL3(sll3);
			masMedicalBoardProceedings.setLL4(sll4);
			masMedicalBoardProceedings.setLL5(sll5);
			masMedicalBoardProceedings.setLL6(sll6);
			masMedicalBoardProceedings.setLL7(sll7);
			masMedicalBoardProceedings.setLL8(sll8);
			masMedicalBoardProceedings.setLastChangedBy(lastChangedBy);
			masMedicalBoardProceedings.setLastChangedDate(lastChangedDate);
			masMedicalBoardProceedings.setLastChangedTime(lastChangedTime);

			successfullyAdded = medicalExaminationBoardHandlerService
					.addMedicalExaminationBoard(masMedicalBoardProceedings,
							masMedicalBoardDetails);
			message = "Record Added Successfully!Do You Want To Print !!";
			jsp = MEDICAL_BOARD_EXAM_MSG;
			if (!successfullyAdded) {
				message = "There is already an same entry for this Batch no and Chest no!!";
				jsp = MEDICAL_BOARD_ERROR_MSG;
			}
		}
		try {
			map = medicalExaminationBoardHandlerService
					.showMedicalExaminationBoardJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String medicalEntryNo = "";
		String medicalEntryNo1 = "";
		String userName = "";
		String userName1 = "";
		medicalEntryNo = medicalExaminationBoardHandlerService
				.generateMedicalEntryNumber(userName);
		medicalEntryNo1 = medicalExaminationBoardHandlerService
				.generateMedicalEntryNumber1(userName1);
		jsp += ".jsp";
		map.put("medicalEntryNo", medicalEntryNo);
		map.put("medicalEntryNo1", medicalEntryNo1);
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
}