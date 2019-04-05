package jkt.hms.mis.handler;

import java.util.Date;

import java.util.List;
import java.util.Map;

import jkt.hms.util.Box;

public interface MISHandlerService {
	// -------------------------------- ED Return form
	Map<String, Object> showEDReturnsJsp();

	/*Map<String, Object> showEDReturns(String toDate, String fromDate,
			String category, String edStatus,int hospitalId);*/

	boolean editEDReturnsToDatabase(Box box);

	// -------------------------------- ED Return Report form
	Map<String, Object> showEDreportsjsp();
	
	Map<String, Object>getServiceNoDetailsForADS(Box box);
	Map<String,Object> getServiceNoDetailsForSanitary(Box box);
	Map<String,Object> getServiceNoDetailsForMentalPhysical(Box box);
	Map<String,Object> getServiceNoDetailsForAttemptSucide(Map<String,Object> mapForDS);
	Map<String, Object> searchEDReturn(Date toDate, Date fromDate,
			String category);

	// ---------------------------- Patient Movement Order Report form
	Map<String, Object> showPatientMovementOrderjsp();

	Map<String, Object> searchPatientMovementOrder(String disposal,
			String serviceNo);

	// ------------------------------- Afmsf-1 Def
	boolean editAfmsfDef(Map<String, Object> generalMap);

	Map<String, Object> showAfmsfDefjsp(String afmsfType);
	Map<String, Object> getPatientInfoForVisit(Box box);

	Map<String, Object> showAfmsfDef(Map<String, Object> map);

	// ------------------------------- Afmsf-1 Surplus
	Map<String, Object> showAfmsfSurplusjsp();

	Map<String, Object> showAfmsfSurplus(Map<String, Object> map);
    Map<String,Object> showMonitoringOfAds(Map<String,Object> map);
	boolean editAfmsfSurplus(Map<String, Object> generalMap);

	// --------------------- Afmsf-1 Annual Medical Examination
	Map<String, Object> showAfmsfAnnualMedicalExaminationjsp();
	
	Map<String, Object> getMedicalCategory();
	boolean submitNotifiableDiseaseJsp(Map map);
	boolean submitSmoMalariaCase(Map map);
	boolean submitFoodHandlerJsp(Map map);
    boolean submitPreventableDiseaseEntry(Map map);
    boolean submitAutomaticChloroform(Map map);
    boolean submitAntiMalariaJsp(Map map);
    boolean submitActivitiesDetails(Map map);
    boolean submitSroEntry(Map map);
    boolean submitSanitaryDefectNotes(Map map);
    boolean submitSanitaryRoundJSP(Map map);
    boolean submitSchoolInspectionEntry(Map map);
    boolean submitMonitoringofADS(Map map);
    boolean submitMentalPhysicalRetarded(Map map);
    boolean submitNutritionExamination(Map map);
    boolean submitFeedbackCounselorJsp(Map map);
    boolean submitMeetingHeldAgency(Map map);
    boolean submitCaseOfAttemptSuicideJsp(Map map);
    boolean validateSmoMalariaCase(Map map);
    boolean submitVectorControlActivity(Map map);
    boolean submitAccidentalDetailJsp(Map map);
    boolean submitFreeFromInfection(Map map);
    boolean submitWaterSurveillanceJsp(Map map);
    boolean submitHealthPromotionActivityJsp(Map map);
    boolean submitMonthlyWorkload(Map<String, Object> dataMap);
	Map<String, Object> showAfmsfAnnualMedicalExamination(String serviceNo);
	Map<String, Object> displayFileUploadData(Map<String, Object> dataMap);
	Map<String, Object> editAfmsfAnnualMedicalExamination(
			Map<String, Object> generalMap,Box box);

	Map<String, Object> showFatalCasejsp(Map<String, Object> dataMap);

	boolean editFatalcase(Map<String, Object> generalMap);

	Map<String, Object> showTotalAdmissionjsp();

	Map<String, Object> searchTotalAdmission(Date fromDate, Date toDate,
			String serviceType);

	Map<String, Object> showTotalDischargejsp();

	Map<String, Object> searchTotalDischarge();

	Map<String, Object> showMonthlySickReportsjsp();

	Map<String, Object> showMonthlySickDischargeReportjsp();

	List<Object> getAdmissionNoList(Map<String, Object> detailsMap);

	List<Object> getHinNoList(String serviceNo);

	Map<String, Object> getDBConnection();

	/**
	 * -------------------------------- FRW CASES
	 */
	Map<String, Object> showFrwCases();

	Map<String, Object> submitFrwCases(Map<String, Object> generalMap);

	/**
	 * ------------------------ NOTIFIABLE DISEASE ENTRY FORM
	 */

	Map<String, Object> showNotifiableDiseaseJsp(Map<String, Object> generalMap);

	Map<String, Object> showNotifiableDisease(Map<String, Object> generalMap);

	boolean editNotifiableDisease(Map<String, Object> generalMap);

	/**
	 * ------------------------ NOTIFIABLE DISEASE REPORT FORM
	 */
	Map<String, Object> showNotifiableDiseaseReportJsp();

	/**
	 * ------------------------ MALARIA CASE REPORT ------------------------
	 */
	Map<String, Object> showMalariaCaseReportJsp();

	// -------------------------------- Bed Statistics Report form
	Map<String, Object> showBedStatisticsSummary();

	// --------------------------Daily Ward Wise Bed Status

	Map<String, Object> showDailyBedStatusReport();

	// ---------------------Birth Certificate--------------------------------

	Map<String, Object> showBirthCertificateJsp();

	Map<String, Object> addBirthCertificate(Map<String, Object> generalMap);

	List<Object> getMotherHin(String serviceNo);

	// ------------------Death Certificate--------------------------------------
	Map<String, Object> showDeathCertificateJsp();

	Map<String, Object> showBirth(int inpatientId);

	Map<String, Object> generateRegNumber(Map<String, Object> regMap);

	Map<String, Object> showDeath(int inpatientid);

	Map<String, Object> getConnectionForReport();

	Map<String, Object> addDeathCertificate(Map<String, Object> generalMap);

	List<Object> getExpiredHin(String serviceNo);
	Map<String,Object> getPatientDetailForMalaria(Map<String,Object> mapForDS);

	boolean submitUpdateDeathCertificate(Map<String, Object> generalMap);

	Map<String, Object> showUpdateDeathCertificate(Map<String, Object> map);

	Map<String, Object> showBedStatisticsSummaryjsp(Map<String, Object> map);

	Map<String, Object> showBedStatisticsDetailReport(Map<String, Object> map);

	Map<String, Object> showUpdateBirthCertificate(Map<String, Object> map);

	boolean submitUpdateBirthCertificate(Map<String, Object> generalMap);

	Map<String, Object> showIIBedStateReport(Map<String, Object> map);

	Map<String, Object> chechBed(Map<String, Object> dataMap);

	List<Object> getExpiredAdmissionNumberList(Map<String, Object> detailsMap);

	Map<String, Object> getHinAdNoDetailsFatalCase(
			Map<String, Object> detailsMap);

	Map<String, Object> populateHinNo(Map<String, Object> dataMap);

	Map<String, Object> getFRWDetails(Map<String, Object> dataMap);

	Map<String, Object> getHinAdNoFatalPanchanama(Map<String, Object> detailsMap);

	Map<String, Object> showDeathInformation(Map<String, Object> detailsMap);

	Map<String, Object> showEDreports(Map<String, Object> map);

	Map<String, Object> getHinNoForDeficient(Map<String, Object> dataMap);

	Map<String, Object> getHinNoForSurplus(Map<String, Object> dataMap);

	Map<String, Object> showMisDailyReportJsp();

	Map<String, Object> getHinAdNoForND(Map<String, Object> detailsMap);
	
     Map<String,Object> getHinNoForMalariaCase(Map<String,Object> detailsMap); 
     Map<String,Object> getHinNoForFoodHandler(Map<String,Object> detailsMap);
	Map<String, Object> getResponceForAME(Map<String, Object> dataMap);

	Map<String, Object> getHiAdListForBD(Map<String, Object> detailsMap);

	Map<String, Object> printPMO(Map<String, Object> detailsMap);

	Map<String, Object> bedStatisticsSummary(Map<String, Object> dataMap);

	// -------------------Total Admission in Excel Formate-----by Kalyan
	Map<String, Object> totalAdmissionExcelSoftCopy(Box box);

	Map<String, Object> totalDischargeExcelSoftCopy(Box box);

	Map<String, Object> getTotalMisDailyReport(Map<String, Object> dataMap);
	
	Map<String, Object> closeExistingRecord(Box box);
	
	Map<String, Object> getExistingDetails(Box box);
	//-By Dipali--AnnualMedicalExamination

	Map<String, Object> submitAnnualMedicalExamination(Box box,Map<String, Object> dataMap);

	Map<String, Object> showAmeLmcReportJsp();
	 Map<String, Object> showSilDilReportJsp();
	 Map<String, Object> printSILDILStatusReport(Date fromDate, Date toDate);
	 List<Object> getAdmissionNoList1(Map<String, Object> map);
	 public Map<String, Object> searchMonthlySickExcelReport(Box box);
	 public Map<String, Object> searchMonthlySickExcelForm38BReport(Box box);
	 public boolean checkFRWDone(String ADNumber);
	 String getHospitalName(int hospitalId);
	 Map<String, Object> getRankUnitSexList();
	 Map<String, Object> submitFatalDocument(Box box);
	 Map<String, Object> getPatientDetails(Map<String, Object> dataMap);
	 Map<String,Object>getDoctorList(Map<String,Object> mapForDS);
	 Map<String,Object> getWaitingPatientList(Map mapForDS );
	 Map<String,Object> getPatientForValidate(Map mapForDS);
	 Map<String, Object> submitUploadDocumentsAreaForSho(Map<String, Object> dataMap);
	 Map<String, Object> getWaitingPatientListForcouncling(Map<String, Object> mapForDS);
	 Map<String, Object> getPatientForValidateCounselling(Map<String, Object> mapForDS);
	 Map<String,Object> submitUploadDocumentsVectorControlForSho(Map<String,Object> dataMap);
	 Map<String,Object> getUploadDocumentDetails(Map<String,Object> dataMap);
	 Map<String,Object> getUploadDocumentShoData(Map<String,Object> dataMap);
	 Map<String,Object> getMonthlyWorkloadDetails(Map<String,Object> mapForData);
     boolean validateSmoCounseling(Map<String, Object> map);

	boolean saveWaterSurvillanceDetails(Box box);

	Map<String, Object> showEDReturns(Map<String, Object> dataMap);
	
	//----by Kiran to get category details for 2 wheeler JSp
	
	Map<String, Object> showMotorCycleJsp();
	
	Map<String, Object> showFamilyHealthProgrammeJsp();

	boolean submitFamilyHealthProgrammeJsp(Map map);
	
	Map<String,Object> getServiceNoDetailsForMortalityAmongstFamilies(String serviceNo);

	boolean submitMortalityAmongstFamiliesJsp(Map<String, Object> map);
	Map<String, Object> showFamilyHealthProgrammeReport();
	String getCommandName(int commandId);

	boolean submitActivityAgainstHiv(Map<String, Object> map);

	boolean submitBiomedicalwastemgtjsp(Map<String, Object> map);

	Map<String, Object> showBiomedicalwastemgtjsp(Map<String, Object> map);
	
	Map<String, Object> getHinNoForNotifiableDisease(String serviceNo);
	Map<String,Object> getPatientDetailForNotifiableDisease(Map<String,Object> mapForDS);
	Map<String, Object> getHinNoForAttemptSucide(String serviceNo);
	Map<String,Object> getServiceNoDetailsForSho(Box box);
	Map<String, Object> getServiceNoDetailsForAccidentRider(String serviceNo);
	Map<String,Object> getPatientDetailForAccidentalDetails(Map<String,Object> mapForDS);
	Map<String, Object> getServiceNoDetailsForAccident(String serviceNo);
	Map<String,Object> getPatientDetailForAccidentalDetailsDriver(Map<String,Object> mapForDS);
	Map<String,Object> getPatientDetailForMortality(Map<String,Object> mapForDS);

	Map<String, Object> updateDiagnosis(Box box);

	
	Map<String, Object> getHinNoForFreeFromInfection(String serviceNo);
	Map<String,Object> getServiceNoDetailsForFreeFromInfection(Map<String,Object> mapForDS);

	Map<String, Object> showDefeicientReportJsp();

	Map<String, Object> getMonthlySickAdmissionDetails(Box box);

	Map<String, Object> getServiceNoDetails(Box box);

	Map<String, Object> submitMonthlySickAdmission(Box box);

	Map<String, Object> getMonthlySickDischargeDetails(Box box);

	Map<String, Object> submitMonthlySickDischarge(Box box);


	Map<String, Object> showMonthlyWorkLoadReport(Map<String, Object> map);

	//-- by kiran for notifiable waiting list
	
	Map<String, Object> getWaitingPatientListForNotifiable(Map<String, Object> mapForDS);

	Map<String, Object> showNotifiableDiseaseWLJsp(Map<String, Object> generalMap);

	boolean submitNotifiableDiseaseWLJsp(Map<String, Object> map);

	boolean submitBreakDownJSP(Map<String, Object> map);

	Map<String, Object> showBreakDown(Map<String, Object> dataMap);

	Map<String, Object> showShoAccommodation(Map<String, Object> dataMap);

	Map<String, Object> showShoAntiFilaria(Map<String, Object> dataMap);

	boolean submitShoAccommodationJSP(Map<String, Object> map);

	boolean submitShoAntiFilariaJSP(Map<String, Object> map);

	Map<String, Object> showShoConservancy(Map<String, Object> dataMap);

	boolean submitShoConservancyJSP(Map<String, Object> map);

	Map<String, Object> showShoCatering(Map<String, Object> dataMap);

	boolean submitShoCateringJSP(Map<String, Object> map);
	
	Map<String, Object> showSchoolHealth(Map<String, Object> dataMap);

	boolean submitSchoolHealthJsp(Map<String, Object> map);
	
	//--------- By Mansi on 13 May 2013

	Map<String, Object> showAdmissionDeath(Map<String, Object> dataMap);

	Map<String, Object> submitAdmissionDeath(Box box,Map<String, Object> mapForDS);

	Map<String, Object> showOfficerDetails(Map<String, Object> dataMap);

	boolean submitLadyOfficerJsp(Map<String, Object> map);

	Map<String, Object> showIndustrialDisease(Map<String, Object> dataMap);

	boolean submitShoIndustrialDisease(Map<String, Object> map);

	//--------- By Mansi on 17 May 2013
	
	Map<String, Object> showFamilyWelfareActivities(Map<String, Object> dataMap);

	Map<String, Object> submitFamilyWelfareActivities(Box box,Map<String, Object> mapForDS);

	Map<String, Object> showWorkService(Map<String, Object> dataMap);

	boolean submitWorkService(Map<String, Object> map);

	Map<String, Object> getSerNoDetailForIncident(Box box);

	Map<String, Object> fillAVServiceDetail(Map<String, Object> dataMap);

}