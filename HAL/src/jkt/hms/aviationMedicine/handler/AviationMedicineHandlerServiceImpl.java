package jkt.hms.aviationMedicine.handler;

import java.util.Map;

import jkt.hms.aviationMedicine.dataservice.AviationMedicineDataService;
import jkt.hms.masters.business.AvAccident;
import jkt.hms.masters.business.AvAircraftAccident;
import jkt.hms.masters.business.AvAircrewRationHd;
import jkt.hms.masters.business.AvFlyingIncident;
import jkt.hms.masters.business.AvMedicalExamMaMo;
import jkt.hms.masters.business.AvPilotRegistrationHd;
import jkt.hms.masters.business.AvPreFlight;
import jkt.hms.masters.business.AvSpecialLocalFeature;
import jkt.hms.masters.business.AvTrainingStatusAircrew;
import jkt.hms.masters.business.AviAircrewMedicalLectures;
import jkt.hms.masters.business.AviCa34;
import jkt.hms.masters.business.AviCasualtyAirEvacuation;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.masters.business.AviFlyingClothingInspection;

public class AviationMedicineHandlerServiceImpl implements AviationMedicineHandlerService {
	
	AviationMedicineDataService aviationMedicineDataService = null;

	public AviationMedicineDataService getAviationMedicineDataService() {
		return aviationMedicineDataService;
	}

	public void setAviationMedicineDataService(
			AviationMedicineDataService aviationMedicineDataService) {
		this.aviationMedicineDataService = aviationMedicineDataService;
	}

	@Override
	public Map<String, Object> showCAForm34AJsp(int hospitalId) {
		return aviationMedicineDataService.showCAForm34AJsp(hospitalId);
	}

	@Override
	public Map<String, Object> showRenewableApplicationJsp(int hospitalId) {
		return aviationMedicineDataService.showRenewableApplicationJsp(hospitalId);
	}

	@Override
	public Map<String, Object> getConnectionForReport() {
		return aviationMedicineDataService.getConnectionForReport();
	}

	@Override
	public Map<String, Object> showAircrewMedicalLectureJsp(int hospitalId) {
		return aviationMedicineDataService.showAircrewMedicalLectureJsp(hospitalId);
	}

	@Override
	public Map<String, Object> showFlyingClothingInspectionJsp(int hospitalId) {
		return aviationMedicineDataService.showFlyingClothingInspectionJsp(hospitalId);
	}

	@Override
	public Map<String, Object> showCasualtyAirEvacuationJsp(int hospitalId) {
		return aviationMedicineDataService.showCasualtyAirEvacuationJsp(hospitalId);
	}

	@Override
	public Map<String, Object> showAircraftAccidentInvestigationJsp(
			int hospitalId) {
		return aviationMedicineDataService.showAircraftAccidentInvestigationJsp(hospitalId);
	}
	@Override
	public Map<String, Object> getWaitingAppointMedExamList(Map<String, Object> mapForDS) {
		return aviationMedicineDataService.getWaitingAppointMedExamList(mapForDS);
	}
	public Boolean submitAircrewMedicalLecture(AviAircrewMedicalLectures aviAircrewMedicalLectures
			,Map<String, Object> infoMap) {
		return aviationMedicineDataService.submitAircrewMedicalLecture(aviAircrewMedicalLectures,infoMap);
	}
	@Override
	public Map<String, Object> getMedExamWaitningList(Map<String, Object> mapForDs) {
		return aviationMedicineDataService.getMedExamWaitningList(mapForDs);
	}

	@Override
	public Boolean submitCheckedAppointment(Box box) {
		return aviationMedicineDataService.submitCheckedAppointment(box);
	}

	public Map<String, Object> getDetailBasedLicenceNo(Map<String, Object> mapForDs) {
		return aviationMedicineDataService.getDetailBasedLicenceNo(mapForDs);
	}

	@Override
	public Boolean submitCAForm34A(Map<String, Object> mapForDS) {
		return aviationMedicineDataService.submitCAForm34A(mapForDS);
	}
@Override
	public Map<String, Object> getServiceNoDetailsForReg(Box box) {
		return aviationMedicineDataService.getServiceNoDetailsForReg(box);
	}

	@Override
	public Map<String, Object> submitFlyingClothingInspectionJsp(Map<String, Object> infoMap) {
		return aviationMedicineDataService.submitFlyingClothingInspectionJsp(infoMap);
	}

	@Override
	public Boolean updateFlyingClothingInspectionJsp(
			AviFlyingClothingInspection aviFlyingClothingInspection,
			Map<String, Object> generalMap) {
		return aviationMedicineDataService.updateFlyingClothingInspectionJsp(aviFlyingClothingInspection, generalMap);
	}
	@Override
	public Map<String, Object> showWaitingForACForm34Jsp(Map<String, Object> mapforDs) {
		return aviationMedicineDataService.showWaitingForACForm34Jsp(mapforDs);
	}

	@Override
	public Map<String, Object> getWaitingCurrentCAForm34(Map<String, Object> mapForDs) {
		return aviationMedicineDataService.getWaitingCurrentCAForm34(mapForDs);
	}

	@Override
	public Map<String, Object> getWaitingForACForm34(Map<String, Object> detailsMap) {
		return aviationMedicineDataService.getWaitingForACForm34(detailsMap);
	}

	@Override
	public Boolean submitCancelAppointment(Box box) {
		return aviationMedicineDataService.submitCancelAppointment(box);
	}

	@Override
	public Map<String, Object> showWaitingListForExaminationMA(int hospitalId) {
		return aviationMedicineDataService.showWaitingListForExaminationMA(hospitalId);
	}

	@Override
	public Map<String, Object> showCivilAviationMedExamMAJsp(Map<String, Object> dataMap) {
		return aviationMedicineDataService.showCivilAviationMedExamMAJsp(dataMap);
	}

	@Override
	public Map<String, Object> getForAviationMA(Map<String, Object> detailsMap) {
		return aviationMedicineDataService.getForAviationMA(detailsMap);
	}

	@Override
	public Map<String, Object> submitAviationAccidentEntry(Map<String, Object> infoMap) {
		return aviationMedicineDataService.submitAviationAccidentEntry(infoMap);
	}

	@Override
	public Boolean submitAviationMA(AvMedicalExamMaMo avMedicalExamMaMo,Map<String, Object> infoMap) {
		return aviationMedicineDataService.submitAviationMA(avMedicalExamMaMo,infoMap);
	}

	@Override
	public Map<String, Object> getServiceNoDetailsForRegCasualty(Box box) {
		return aviationMedicineDataService.getServiceNoDetailsForRegCasualty(box);
	}
	@Override
	public Boolean updateCasualtyAirEvacuationJsp(
			AviCasualtyAirEvacuation aviCasualtyAirEvacuation,
			Map<String, Object> generalMap) {
		return aviationMedicineDataService.updateCasualtyAirEvacuationJsp(aviCasualtyAirEvacuation,generalMap);
	}
	public Boolean submitRenewableApplication(AviCa34 aviCa34, Patient patient,
			Visit visit, Map<String, Object> dataMap) {
		return aviationMedicineDataService.submitRenewableApplication(aviCa34,patient,visit,dataMap);
	}

	@Override
	public Boolean updateAviationMA(Map<String, Object> infoMap) {
		return aviationMedicineDataService.updateAviationMA(infoMap);
	}

	@Override
	public Map<String, Object> showWaitingListForExaminationMO(int hospitalId) {
		return aviationMedicineDataService.showWaitingListForExaminationMO(hospitalId);
	}

	@Override
	public AvMedicalExamMaMo loadAviationExamObj(int medExamMaMoId) {
		return aviationMedicineDataService.loadAviationExamObj(medExamMaMoId);
	}

	@Override
	public Map<String, Object> showCivilAviationMedExamMOJsp(Map<String, Object> dataMap) {
		return aviationMedicineDataService.showCivilAviationMedExamMOJsp(dataMap);
	}

	@Override
	public Map<String, Object> showCAForm34AReportJsp(int hospitalId) {
		return aviationMedicineDataService.showCAForm34AReportJsp(hospitalId);
	}

	@Override
	public Map<String, Object> fillItemsForLicenceNo(Map<String, Object> dataMap) {
		return aviationMedicineDataService.fillItemsForLicenceNo(dataMap);
	}

	@Override
	public boolean submitPMRFileTracking(Map<String, Object> parameterMap) {
		return aviationMedicineDataService.submitPMRFileTracking(parameterMap);
	}

	@Override
	public Map<String, Object> getForPMRList(Map<String, Object> mapForDS) {
		return aviationMedicineDataService.getForPMRList(mapForDS);
	}

	@Override
	public Map<String, Object> getDetailAfterSearch(Map<String, Object> mapForDs) {
		return aviationMedicineDataService.getDetailAfterSearch(mapForDs);
	}
@Override
	public Map<String, Object> showPaymentStatusJsp() {
		return aviationMedicineDataService.showPaymentStatusJsp();
	}
	@Override
	public Map<String, Object> getServiceNoDetailsForRegEquipmentInUse(Box box) {
		return aviationMedicineDataService.getServiceNoDetailsForRegEquipmentInUse(box);
	}
	@Override
	public AvAccident loadAviationAccident(int avAccidentId) {
		return aviationMedicineDataService.loadAviationAccident(avAccidentId);
	}

	@Override
	public Map<String, Object> submitEquipmentFactors(Map<String, Object> infoMap) {
		return aviationMedicineDataService.submitEquipmentFactors(infoMap);
	}

	@Override
	public Map<String, Object> submitAircraftAccident(
			Map<String, Object> infoMap) {
		return aviationMedicineDataService.submitAircraftAccident(infoMap);
	}

	@Override
	public AvAircraftAccident loadAircraftAccident(int avAccidentId) {
		return aviationMedicineDataService.loadAircraftAccident(avAccidentId);
	}

	@Override
	public AvFlyingIncident loadFlyingIncident(int avAccidentId) {
		return aviationMedicineDataService.loadFlyingIncident(avAccidentId);
	}

	@Override
	public Map<String, Object> submitFlyingIncident(Map<String, Object> infoMap) {
		return aviationMedicineDataService.submitFlyingIncident(infoMap);
	}

	@Override
	public Map<String, Object> getSerNoDetailForIncident(Box box) {
		return aviationMedicineDataService.getSerNoDetailForIncident(box);
	}

	@Override
	public Map<String, Object> showFlyingIncidentJsp() {
		return aviationMedicineDataService.showFlyingIncidentJsp();
	}

	@Override
	public Map<String, Object> getSerNoDetailForAccident(Box box) {
		return aviationMedicineDataService.getSerNoDetailForAccident(box);
	}

	@Override
	public Map<String, Object> submitTrainingStatusAirCrew(Map<String, Object> infoMap) {
		return aviationMedicineDataService.submitTrainingStatusAirCrew(infoMap);
	}

	@Override
	public Map<String, Object> getSerNoDetailForTraining(Box box) {
		return aviationMedicineDataService.getSerNoDetailForTraining(box);
	}

	@Override
	public AvTrainingStatusAircrew loadTrainingStatusAircrew(int avAccidentId) {
		return aviationMedicineDataService.loadTrainingStatusAircrew(avAccidentId);
	}

	@Override
	public Map<String, Object> submitSpecialLocalFeature(
			Map<String, Object> infoMap) {
		return aviationMedicineDataService.submitSpecialLocalFeature(infoMap);
	}

	@Override
	public AvPreFlight loadPreFlight(int avAccidentId) {
		return aviationMedicineDataService.loadPreFlight(avAccidentId);
	}

	@Override
	public Map<String, Object> submitPreFlight(Map<String, Object> infoMap) {
		return aviationMedicineDataService.submitPreFlight(infoMap);
	}

	@Override
	public Map<String, Object> getSerNoDetailPreFlight(Box box) {
		return aviationMedicineDataService.getSerNoDetailPreFlight(box);
	}

	@Override
	public Map<String, Object> getSerNoDetailForRation(Box box) {
		return aviationMedicineDataService.getSerNoDetailForRation(box);
	}

	@Override
	public AvAircrewRationHd loadAircrewRationHd(int avAccidentId) {
		return aviationMedicineDataService.loadAircrewRationHd(avAccidentId);
	}

	public Map<String, Object> submitAircrewRation(Map<String, Object> infoMap) {
		return aviationMedicineDataService.submitAircrewRation(infoMap);
	}

	@Override
	public Map<String, Object> displayPreFlightPhoto(String hinNo) {
		return aviationMedicineDataService.displayPreFlightPhoto(hinNo);
	}

	@Override
	public AvSpecialLocalFeature loadLocalFeature(int avAccidentId) {
		return aviationMedicineDataService.loadLocalFeature(avAccidentId);
	}

	@Override
	public Map<String, Object> showSpecialLocalFeatureJsp() {
		return aviationMedicineDataService.showSpecialLocalFeatureJsp();
	}

	@Override
	public AviFlyingClothingInspection loadFlyingClothing(int avAccidentId) {
		return aviationMedicineDataService.loadFlyingClothing(avAccidentId);
	}

	@Override
	public Map<String, Object> fillAVServiceDetail(Map<String, Object> dataMap) {
		return aviationMedicineDataService.fillAVServiceDetail(dataMap);
	}

	@Override
	public Map<String, Object> getServicePersonName(String serviceNo,int serviceTypeId) {
		return aviationMedicineDataService.getServicePersonName(serviceNo,serviceTypeId);
	}

	@Override
	public Map<String, Object> showAircrewRationJsp() {
		return aviationMedicineDataService.showAircrewRationJsp();
	}
	@Override
	public Map<String, Object> submitCasualtyAirEvacuationJsp(Map<String, Object> infoMap) {
		return aviationMedicineDataService.submitCasualtyAirEvacuationJsp(infoMap);
	}

	@Override
	public AviCasualtyAirEvacuation loadCasualAirEvac(int avAccidentId) {
		return aviationMedicineDataService.loadCasualAirEvac(avAccidentId);
	}

	@Override
	public Map<String, Object> showPreFlightMedical(Map<String, Object> dataMap) {
		return aviationMedicineDataService.showPreFlightMedical(dataMap);
	}

	@Override
	public Map<String, Object> fillRegisterDetail(Map<String, Object> dataMap) {
		return aviationMedicineDataService.fillRegisterDetail(dataMap);
	}

	@Override
	public Map<String, Object> inactivePreFlight(Map<String, Object> infoMap) {
		return aviationMedicineDataService.inactivePreFlight(infoMap);
	}

	@Override
	public Map<String, Object> displayAVRegisPhoto(String serviceNo) {
		return aviationMedicineDataService.displayAVRegisPhoto(serviceNo);
	}

	@Override
	public Map<String, Object> updatePatientImage(Map<String, Object> mapDetails) {
		return aviationMedicineDataService.updatePatientImage(mapDetails);
	}

	@Override
	public Map<String, Object> getViewUploadImage(Map<String, Object> dataMap) {
		return aviationMedicineDataService.getViewUploadImage(dataMap);
	}

	@Override
	public Map<String, Object> showAircrewLectureRpt(int hospitalId,Map<String, Object> infoMap) {
		return aviationMedicineDataService.showAircrewLectureRpt(hospitalId,infoMap);
	}

	@Override
	public Map<String, Object> getLectureDate(Map<String, Object> dataMap) {
		return aviationMedicineDataService.getLectureDate(dataMap);
	}
	public Map<String, Object> submitUploadDocuments(
			Map<String, Object> generalMap) {
		return aviationMedicineDataService.submitUploadDocuments(generalMap);
	}

	@Override
	public Map<String, Object> viewUploadInvestDocument(
			Map<String, Object> dataMap) {
		return aviationMedicineDataService.viewUploadInvestDocument(dataMap);
	}

	@Override
	public Map<String, Object> viewUploadJsp(Map<String, Object> dataMap) {
		return aviationMedicineDataService.viewUploadJsp(dataMap);
	}

	
	//-------------- By Mansi on 8 March 2013
	@Override
	public Map<String, Object> showPilotRegistrationJsp(int hospitalId) {
		return aviationMedicineDataService.showPilotRegistrationJsp(hospitalId);
	}

	public Map<String, Object> fillAVPilotRegServiceDetail(	Map<String, Object> dataMap) {
		return aviationMedicineDataService.fillAVPilotRegServiceDetail(dataMap);
	}

	@Override
	public Boolean submitPilotRegistration(
			AvPilotRegistrationHd avPilotRegistrationHd,
			Map<String, Object> infoMap) {
		return aviationMedicineDataService.submitPilotRegistration(avPilotRegistrationHd, infoMap);
	}

	@Override
	public Map findPilotDetail(Box box) {
		return aviationMedicineDataService.findPilotDetail(box);
	}

	@Override
	public Map<String, Object> getAdjustmentList(int radioStr, int pageNo) {
		return aviationMedicineDataService.getAdjustmentList(radioStr, pageNo);
	}
	}
