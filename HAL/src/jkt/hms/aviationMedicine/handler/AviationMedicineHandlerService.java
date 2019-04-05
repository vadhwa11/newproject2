package jkt.hms.aviationMedicine.handler;

import java.util.Map;

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
import jkt.hms.masters.business.AviFlyingClothingInspection;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;


public interface AviationMedicineHandlerService {

	Map<String, Object> showCAForm34AJsp(int hospitalId);

	Map<String, Object> showRenewableApplicationJsp(int hospitalId);

	Map<String, Object> getConnectionForReport();

	Map<String, Object> showAircrewMedicalLectureJsp(int hospitalId);

	Map<String, Object> showFlyingClothingInspectionJsp(int hospitalId);

	Map<String, Object> showCasualtyAirEvacuationJsp(int hospitalId);

	Map<String, Object> showAircraftAccidentInvestigationJsp(int hospitalId);

	Map<String, Object> getWaitingAppointMedExamList(Map<String, Object> mapForDS);

	Map<String, Object> getMedExamWaitningList(Map<String, Object> mapForDs);

	Boolean submitAircrewMedicalLecture(AviAircrewMedicalLectures aviAircrewMedicalLectures, Map<String, Object> infoMap);

	Boolean submitCheckedAppointment(Box box);

	Map<String, Object> getDetailBasedLicenceNo(Map<String, Object> mapForDs);

	Boolean submitCAForm34A(Map<String, Object> mapForDs);
	
	Map<String, Object> getServiceNoDetailsForReg(Box box);

	Map<String, Object> submitFlyingClothingInspectionJsp(Map<String, Object> infoMap);

	Boolean updateFlyingClothingInspectionJsp(
			AviFlyingClothingInspection aviFlyingClothingInspection,
			Map<String, Object> generalMap);

	Map<String, Object>  submitCasualtyAirEvacuationJsp(Map<String, Object> infoMap);
	
	Boolean updateCasualtyAirEvacuationJsp(AviCasualtyAirEvacuation aviCasualtyAirEvacuation,
			Map<String, Object> generalMap);

	Map<String, Object> getServiceNoDetailsForRegCasualty(Box box);

	Map<String, Object> showWaitingForACForm34Jsp(Map<String, Object> mapforDs);

	Map<String, Object> getWaitingForACForm34(Map<String, Object> detailsMap);

	Map<String, Object> getWaitingCurrentCAForm34(Map<String, Object> mapForDs);

	Boolean submitCancelAppointment(Box box);

	Map<String, Object> showWaitingListForExaminationMA(int hospitalId);

	Map<String, Object> showCivilAviationMedExamMAJsp(Map<String, Object> dataMap);

	Map<String, Object> submitAviationAccidentEntry(Map<String, Object> infoMap);

	Map<String, Object> getForAviationMA(Map<String, Object> detailsMap);

	Boolean submitAviationMA(AvMedicalExamMaMo avMedicalExamMaMo,Map<String, Object> infoMap);

	Boolean submitRenewableApplication(AviCa34 aviCa34, Patient patient,
			Visit visit, Map<String, Object> dataMap);

	Boolean updateAviationMA(Map<String, Object> infoMap);

	Map<String, Object> showWaitingListForExaminationMO(int hospitalId);

	AvMedicalExamMaMo loadAviationExamObj(int medExamMaMoId);

	Map<String, Object> showCivilAviationMedExamMOJsp(Map<String, Object> dataMap);

	Map<String, Object> showCAForm34AReportJsp(int hospitalId);

	Map<String, Object> fillItemsForLicenceNo(Map<String, Object> dataMap);

	boolean submitPMRFileTracking(Map<String, Object> parameterMap);

	Map<String, Object> getForPMRList(Map<String, Object> mapForDS);

	Map<String, Object> getDetailAfterSearch(Map<String, Object> mapForDs);

Map<String, Object> showPaymentStatusJsp();

	Map<String, Object> getServiceNoDetailsForRegEquipmentInUse(Box box);
	
	AvAccident loadAviationAccident(int avAccidentId);

	Map<String, Object> submitEquipmentFactors(Map<String, Object> infoMap);

	Map<String, Object> submitAircraftAccident(Map<String, Object> infoMap);

	AvAircraftAccident loadAircraftAccident(int avAccidentId);

	AvFlyingIncident loadFlyingIncident(int avAccidentId);

	Map<String, Object> submitFlyingIncident(Map<String, Object> infoMap);

	Map<String, Object> getSerNoDetailForIncident(Box box);

	Map<String, Object> showFlyingIncidentJsp();

	Map<String, Object> getSerNoDetailForAccident(Box box);

	Map<String, Object> submitTrainingStatusAirCrew(Map<String, Object> infoMap);

	AvTrainingStatusAircrew loadTrainingStatusAircrew(int avAccidentId);

	Map<String, Object> getSerNoDetailForTraining(Box box);

	Map<String, Object> submitSpecialLocalFeature(Map<String, Object> infoMap);

	AvPreFlight loadPreFlight(int avAccidentId);

	Map<String, Object> submitPreFlight(Map<String, Object> infoMap);

	Map<String, Object> getSerNoDetailPreFlight(Box box);

	Map<String, Object> getSerNoDetailForRation(Box box);

	AvAircrewRationHd loadAircrewRationHd(int avAccidentId);

	Map<String, Object> submitAircrewRation(Map<String, Object> infoMap);

	Map<String, Object> displayPreFlightPhoto(String hinNo);

	AvSpecialLocalFeature loadLocalFeature(int avAccidentId);

	Map<String, Object> showSpecialLocalFeatureJsp();

	AviFlyingClothingInspection loadFlyingClothing(int avAccidentId);

	Map<String, Object> fillAVServiceDetail(Map<String, Object> dataMap);

	Map<String, Object> getServicePersonName(String serviceNo, int serviceTypeId);

	Map<String, Object> showAircrewRationJsp();

	Map<String, Object> showAircrewLectureRpt(int hospitalId, Map<String, Object> infoMap);

	AviCasualtyAirEvacuation loadCasualAirEvac(int avAccidentId);

	Map<String, Object> showPreFlightMedical(Map<String, Object> dataMap);

	Map<String, Object> fillRegisterDetail(Map<String, Object> dataMap);

	Map<String, Object> inactivePreFlight(Map<String, Object> infoMap);

	Map<String, Object> displayAVRegisPhoto(String serviceNo);

	Map<String, Object> updatePatientImage(Map<String, Object> mapDetails);

	Map<String, Object> getViewUploadImage(Map<String, Object> dataMap);

	Map<String, Object> getLectureDate(Map<String, Object> dataMap);

	Map<String, Object> submitUploadDocuments(Map<String, Object> generalMap);

	Map<String, Object> viewUploadInvestDocument(Map<String, Object> dataMap);

	Map<String, Object> viewUploadJsp(Map<String, Object> dataMap);
	
	
	//-------------- By Mansi on 8 March 2013

	Map<String, Object> showPilotRegistrationJsp(int hospitalId);

	Map<String, Object> fillAVPilotRegServiceDetail(Map<String, Object> dataMap);

	Boolean submitPilotRegistration(AvPilotRegistrationHd avPilotRegistrationHd,Map<String, Object> infoMap);

	Map findPilotDetail(Box box);

	Map<String, Object> getAdjustmentList(int radioStr, int pageNo);

}