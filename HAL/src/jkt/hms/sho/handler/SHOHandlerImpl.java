package jkt.hms.sho.handler;

import java.util.Map;

import jkt.hms.sho.dataservice.SHODataService;

public class SHOHandlerImpl implements SHOHandler{

	SHODataService shoDataService=null;

	public SHODataService getShoDataService() {
		return shoDataService;
	}

	public void setShoDataService(SHODataService shoDataService) {
		this.shoDataService = shoDataService;
	}

	public Map<String, Object> showNotifiableDisease(
			Map<String, Object> mapDetail) {
		return shoDataService.showNotifiableDisease(mapDetail);
	}

	@Override
	public Map<String, Object> printNotifiableDisease(
			Map<String, Object> mapDetail) {
		return shoDataService.printNotifiableDisease(mapDetail);
	}

	@Override
	public Map<String, Object> getConnectionForReport() {
		return shoDataService.getConnectionForReport();
	}

	@Override
	public Map<String, Object> getHospitalName(Map<String, Object> mapHospital) {
		return shoDataService.getHospitalName(mapHospital);
	}

	@Override
	public Map<String, Object> viewNotifiableDiseaseDetails(
			Map<String, Object> mapDetail) {
		return shoDataService.viewNotifiableDiseaseDetails(mapDetail);
	}

	@Override
	public Map<String, Object> showLowMedCatPsychiatricPatientCounelingEntry(
			Map<String, Object> mapDetail) {
		return shoDataService.showLowMedCatPsychiatricPatientCounelingEntry(mapDetail);
	}

	@Override
	public Map<String, Object> getHinNoForDiseaseSHO(Map<String, Object> dataMap) {
		return shoDataService.getHinNoForDiseaseSHO(dataMap);
	}

	@Override
	public Map<String, Object> editLowMedCatPsychiatricPatientCouneling(
			Map<String, Object> generalMap) {
		return shoDataService.editLowMedCatPsychiatricPatientCouneling(generalMap);
	}

	@Override
	public Map<String, Object> showConfirmedCasesH1N1(
			Map<String, Object> mapDetail) {
		return shoDataService.showConfirmedCasesH1N1(mapDetail);
	}

	public Map<String, Object> getHinNoSHO(Map<String, Object> mapDetail) {
		return shoDataService.getHinNoSHO(mapDetail);
	}

	@Override
	public Map<String, Object> confirmedCasesH1N1Response(
			Map<String, Object> mapDetail) {
		return shoDataService.confirmedCasesH1N1Response(mapDetail);
	}

	public Map<String, Object> saveConfirmedCasesH1N1(
			Map<String, Object> mapDetail) {
		return shoDataService.saveConfirmedCasesH1N1(mapDetail);
	}

	public Map<String, Object> showWaterAnalysis(Map<String, Object> mapDetail) {
		return shoDataService.showWaterAnalysis(mapDetail);
	}

	@Override
	public Map<String, Object> saveWaterSampleForAnalysis(
			Map<String, Object> mapDetail) {
		return shoDataService.saveWaterSampleForAnalysis(mapDetail);
	}

	public Map<String, Object> showFeedBackOfCounselor(
			Map<String, Object> mapDetail) {
		return shoDataService.showFeedBackOfCounselor(mapDetail);
	}

	@Override
	public Map<String, Object> saveFeedbackCounselor(
			Map<String, Object> mapDetail) {
		return shoDataService.saveFeedbackCounselor(mapDetail);
	}

	@Override
	public Map<String, Object> saveOccupationalExposureHIV(
			Map<String, Object> mapDetail) {
		return shoDataService.saveOccupationalExposureHIV(mapDetail);
	}

	@Override
	public Map<String, Object> showOccupationalExposureHIV(
			Map<String, Object> mapDetail) {
		return shoDataService.showOccupationalExposureHIV(mapDetail);
	}

	@Override
	public Map<String, Object> saveBioMedicalWasteDisposalInspecting(
			Map<String, Object> mapDetail) {
		return shoDataService.saveBioMedicalWasteDisposalInspecting(mapDetail);
	}

	@Override
	public Map<String, Object> showBioMedicalWasteDisposalInspecting(
			Map<String, Object> mapDetail) {
		return shoDataService.showBioMedicalWasteDisposalInspecting(mapDetail);
	}

	@Override
	public Map<String, Object> saveMentalAndPhysicalRetardedChildren(
			Map<String, Object> mapDetail) {
		return shoDataService.saveMentalAndPhysicalRetardedChildren(mapDetail);
	}

	@Override
	public Map<String, Object> showMentalAndPhysicalRetardedChildren(
			Map<String, Object> mapDetail) {
		return shoDataService.showMentalAndPhysicalRetardedChildren(mapDetail);
	}

	@Override
	public Map<String, Object> saveAccommodation(Map<String, Object> mapDetail) {
		return shoDataService.saveAccommodation(mapDetail);
	}

	@Override
	public Map<String, Object> showAccommodation(Map<String, Object> mapDetail) {
		return shoDataService.showAccommodation(mapDetail);
	}

	@Override
	public Map<String, Object> showFoodHandler() {
		return shoDataService.showFoodHandler();
	}
}
