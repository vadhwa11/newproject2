package jkt.hms.sho.handler;

import java.util.Map;

public interface SHOHandler {

	Map<String, Object> showNotifiableDisease(Map<String, Object> mapDetail);

	Map<String, Object> printNotifiableDisease(Map<String, Object> mapDetail);

	Map<String, Object> getHospitalName(Map<String, Object> mapHospital);

	Map<String, Object> getConnectionForReport();

	Map<String, Object> viewNotifiableDiseaseDetails(
			Map<String, Object> mapDetail);

	Map<String, Object> showLowMedCatPsychiatricPatientCounelingEntry(
			Map<String, Object> mapDetail);

	Map<String, Object> getHinNoForDiseaseSHO(Map<String, Object> dataMap);

	Map<String, Object> editLowMedCatPsychiatricPatientCouneling(
			Map<String, Object> generalMap);

	Map<String, Object> showConfirmedCasesH1N1(Map<String, Object> mapDetail);

	Map<String, Object> getHinNoSHO(Map<String, Object> mapDetail);

	Map<String, Object> confirmedCasesH1N1Response(Map<String, Object> mapDetail);

	Map<String, Object> saveConfirmedCasesH1N1(Map<String, Object> mapDetail);

	Map<String, Object> showWaterAnalysis(Map<String, Object> mapDetail);

	Map<String, Object> saveWaterSampleForAnalysis(Map<String, Object> mapDetail);

	Map<String, Object> showFeedBackOfCounselor(Map<String, Object> mapDetail);

	Map<String, Object> saveFeedbackCounselor(Map<String, Object> mapDetail);

	Map<String, Object> showOccupationalExposureHIV(
			Map<String, Object> mapDetail);

	Map<String, Object> saveOccupationalExposureHIV(
			Map<String, Object> mapDetail);

	Map<String, Object> showBioMedicalWasteDisposalInspecting(
			Map<String, Object> mapDetail);

	Map<String, Object> saveBioMedicalWasteDisposalInspecting(
			Map<String, Object> mapDetail);

	Map<String, Object> showMentalAndPhysicalRetardedChildren(
			Map<String, Object> mapDetail);

	Map<String, Object> saveMentalAndPhysicalRetardedChildren(
			Map<String, Object> mapDetail);

	Map<String, Object> showAccommodation(Map<String, Object> mapDetail);

	Map<String, Object> saveAccommodation(Map<String, Object> mapDetail);

	Map<String, Object> showFoodHandler();

}
