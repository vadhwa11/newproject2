package jkt.hms.mis.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import jkt.hms.mis.dataservice.MISDataService;
import jkt.hms.util.Box;

public class MISHandlerServiceImpl implements MISHandlerService {

	MISDataService misDataService = null;

	// ------------------------------- ED Return Form
	public Map<String, Object> showEDReturnsJsp() {
		return misDataService.showEDReturnsJsp();
	}

	/*public Map<String, Object> showEDReturns(String toDate, String fromDate,
			String category, String edStatus,int hospitalId) {
		return misDataService.showEDReturns(toDate, fromDate, category,edStatus,hospitalId);

	}*/

	public boolean submitNotifiableDiseaseJsp(Map map){
    	return misDataService.submitNotifiableDiseaseJsp(map);
    }
	public boolean submitSmoMalariaCase(Map map)
	 {
		return misDataService.submitSmoMalariaCase(map);
	 }
	public boolean submitFoodHandlerJsp(Map map)
	{
		return misDataService.submitFoodHandlerJsp(map);
	}
	public boolean submitCaseOfAttemptSuicideJsp(Map map)
	 {
		return misDataService.submitCaseOfAttemptSuicideJsp(map);
	 }
	public boolean submitPreventableDiseaseEntry(Map map)
	  {
		return misDataService.submitPreventableDiseaseEntry(map);
	  }
	public boolean submitAutomaticChloroform(Map map)
	  {
		return misDataService.submitAutomaticChloroform(map);
	  }
	public boolean submitAntiMalariaJsp(Map map)
	{
		return misDataService.submitAntiMalariaJsp(map);
	}
	public boolean submitActivitiesDetails(Map map)
	  {
		return misDataService.submitActivitiesDetails(map);
	  }
	public boolean submitSroEntry(Map map)
	  {
		return misDataService.submitSroEntry(map);
	  }
	public boolean submitSanitaryDefectNotes(Map map)
	 {
		return misDataService.submitSanitaryDefectNotes(map);
	 }
	public boolean submitSanitaryRoundJSP(Map map)
	 {
		return misDataService.submitSanitaryRoundJSP(map);
	 }
	public Map<String, Object> getPatientInfoForVisit(Box box) {
		return misDataService.getPatientInfoForVisit(box);
	}
    public boolean submitSchoolInspectionEntry(Map map)
    {
    	return misDataService.submitSchoolInspectionEntry(map);
    }
    public boolean submitMonitoringofADS(Map map)
      {
    	return misDataService.submitMonitoringofADS(map);
      }
    public boolean submitMentalPhysicalRetarded(Map map)
      {
    	return misDataService.submitMentalPhysicalRetarded(map);
      }
    public boolean submitNutritionExamination(Map map)
      {
    	return misDataService.submitNutritionExamination(map);
      }
    public boolean submitFeedbackCounselorJsp(Map map)
      {
    	return misDataService.submitFeedbackCounselorJsp(map);
      }
    public boolean submitMeetingHeldAgency(Map map)
    {
    	return misDataService.submitMeetingHeldAgency(map);
    }
	public boolean editEDReturnsToDatabase(Box box) {
		return misDataService.editEDReturnsToDatabase(box);
	}
  public boolean validateSmoMalariaCase(Map map)
    {
	  return misDataService.validateSmoMalariaCase(map);
    }
  public boolean submitVectorControlActivity(Map dataMap)
    {
	  return misDataService.submitVectorControlActivity(dataMap);
    }
  public boolean submitHealthPromotionActivityJsp(Map map)
    { 
	  return misDataService.submitHealthPromotionActivityJsp(map);
    }
  public boolean submitMonthlyWorkload(Map<String,Object> dataMap)
    {
	  return misDataService.submitMonthlyWorkload(dataMap);
    }
	public Map<String, Object> searchEDReturn(Date toDate, Date fromDate,
			String category) {
		return misDataService.searchEDReturn(toDate, fromDate, category);
	}

	// ------------------------- ED Return Report Form
	// ---------------------------

	public Map<String, Object> showEDreportsjsp() {

		return misDataService.showEDreportsjsp();
	}

	// ------------------- Patient Movement Order Report Form
	// -------------------

	public Map<String, Object> showPatientMovementOrderjsp() {
		return misDataService.showPatientMovementOrderjsp();
	}

	public Map<String, Object> searchPatientMovementOrder(String disposal,
			String serviceNo) {
		return misDataService.searchPatientMovementOrder(disposal, serviceNo);
	}

	// ------------------------------- Afmsf-1 Def
	// -------------------------------

	public boolean editAfmsfDef(Map<String, Object> generalMap) {
		return misDataService.editAfmsfDef(generalMap);
	}

	public Map<String, Object> showAfmsfDef(Map<String, Object> generalMap) {
		return misDataService.showAfmsfDef(generalMap);
	}
	public Map<String, Object> getServiceNoDetailsForSho(Box box) {
		return misDataService.getServiceNoDetailsForSho(box) ;
	}
	
	public Map<String,Object> getServiceNoDetailsForADS(Box box)
	 {
		return misDataService.getServiceNoDetailsForADS(box);
	 }
	public Map<String,Object>getServiceNoDetailsForMentalPhysical(Box box)
	{
		return misDataService.getServiceNoDetailsForMentalPhysical(box);
	}
   public Map<String,Object> getServiceNoDetailsForSanitary(Box box)
    {
	   return misDataService.getServiceNoDetailsForSanitary(box);
    }

	public Map<String, Object> showAfmsfDefjsp(String afmsfType) {
		return misDataService.showAfmsfDefjsp(afmsfType);
	}

	// ------------------------------- Afmsf-1 Surplus
	// -------------------------------
	public boolean editAfmsfSurplus(Map<String, Object> generalMap) {
		return misDataService.editAfmsfSurplus(generalMap);
	}

	public Map<String, Object> showAfmsfSurplus(Map<String, Object> generalMap) {
		return misDataService.showAfmsfSurplus(generalMap);
	}

	public Map<String, Object> showAfmsfSurplusjsp() {
		return misDataService.showAfmsfSurplusjsp();
	}

	// ------------------------ Afmsf-1 AnnualMedicalExamination
	// -------------------------------
	public Map<String, Object> showAfmsfAnnualMedicalExaminationjsp() {
		return misDataService.showAfmsfAnnualMedicalExaminationjsp();
	}
	
	public Map<String, Object> getMedicalCategory() {
		return misDataService.getMedicalCategory();
	}

	public Map<String, Object> showAfmsfAnnualMedicalExamination(
			String serviceNo) {
		return misDataService.showAfmsfAnnualMedicalExamination(serviceNo);
	}

	public Map<String, Object> editAfmsfAnnualMedicalExamination(
			Map<String, Object> generalMap,Box box) {
		return misDataService.editAfmsfAnnualMedicalExamination(generalMap,box);
	}

	public boolean editFatalcase(Map<String, Object> generalMap) {
		return misDataService.editFatalCase(generalMap);
	}

	public Map<String, Object> showTotalAdmissionjsp() {
		return misDataService.showTotalAdmissionjsp();
	}

	public Map<String, Object> searchTotalAdmission(Date fromDate, Date toDate,	String serviceType) {
		return misDataService.searchTotalAdmission(fromDate, toDate,serviceType);
	}

	public Map<String, Object> showTotalDischargejsp() {
		return misDataService.showTotalDischargejsp();
	}

	public Map<String, Object> searchTotalDischarge() {
		return misDataService.searchTotalDischarge();
	}

	public Map<String, Object> showMonthlySickReportsjsp() {
		return misDataService.showMonthlySickReportsjsp();
	}

	public Map<String, Object> showMonthlySickDischargeReportjsp() {
		return misDataService.showMonthlySickDischargeReportjsp();
	}

	public List<Object> getAdmissionNoList(Map<String, Object> detailsMap) {
		return misDataService.getAdmissionNoList(detailsMap);
	}

	public List<Object> getHinNoList(String serviceNo) {
		return misDataService.getHinNoList(serviceNo);
	}

	public Map<String, Object> showFrwCases() {
		return misDataService.showFrwCases();
	}

	public Map<String, Object> submitFrwCases(Map<String, Object> generalMap) {
		return misDataService.submitFrwCases(generalMap);
	}

	public Map<String, Object> getDBConnection() {
		return misDataService.getDBConnection();
	}
	public Map<String, Object> showNotifiableDiseaseJsp(Map<String, Object> generalMap) {
		return misDataService.showNotifiableDiseaseJsp(generalMap);
	}
  public Map<String,Object>showMonitoringOfAds(Map<String,Object> map)
  {
	  return misDataService.showMonitoringOfAds(map);
  }
	/*public Map<String, Object> showNotifiableDisease(
			Map<String, Object> generalMap) {
		return misDataService.showNotifiableDisease(generalMap);
	}
*/
	public boolean editNotifiableDisease(Map<String, Object> generalMap) {
		return misDataService.editNotifiableDisease(generalMap);
	}

	public Map<String, Object> showNotifiableDiseaseReportJsp() {
		return misDataService.showNotifiableDiseaseReportJsp();
	}
	public Map<String, Object> showMalariaCaseReportJsp() {
		return misDataService.showMalariaCaseReportJsp();
	}

	public Map<String, Object> showBedStatisticsDetailReport(Map<String, Object> map) {
		return misDataService.showBedStatisticsDetailReport(map);
	}

	public Map<String, Object> showBedStatisticsSummary() {
		return misDataService.showBedStatisticsSummary();
	}
	public Map<String, Object> showDailyBedStatusReport() {
		return misDataService.showDailyBedStatusReport();
	}

	// -----------------------Birth Certificate-----------------------------
	public Map<String, Object> showBirth(int inpatientId) {
		return misDataService.showBirth(inpatientId);
	}

	public Map<String, Object> showBirthCertificateJsp() {
		return misDataService.showBirthCertificateJsp();
	}

	public Map<String, Object> addBirthCertificate(Map<String, Object> generalMap) {
		return misDataService.addBirthCertificate(generalMap);
	}

	public List<Object> getMotherHin(String serviceNo) {
		return misDataService.getMotherHin(serviceNo);
	}

	public Map<String, Object> getConnectionForReport() {
		return misDataService.getConnectionForReport();
	}

	public Map<String, Object> generateRegNumber(Map<String, Object> regMap) {
		return misDataService.generateRegNumber(regMap);
	}

	public Map<String, Object> showUpdateBirthCertificate(
			Map<String, Object> map) {

		return misDataService.showUpdateBirthCertificate(map);
	}

	public boolean submitUpdateBirthCertificate(Map<String, Object> generalMap) {
		return misDataService.submitUpdateBirthCertificate(generalMap);
	}
	public Map<String, Object> showDeathCertificateJsp() {
		return misDataService.showDeathCertificateJsp();
	}

	public Map<String, Object> showDeath(int inpatientid) {
		return misDataService.showDeath(inpatientid);
	}

	public List<Object> getExpiredHin(String serviceNo) {
		return misDataService.getExpiredHin(serviceNo);
	}
	public Map<String,Object> getPatientDetailForMalaria(Map<String,Object> mapForDS)
	 {
		return misDataService.getPatientDetailForMalaria(mapForDS);
	 }

	public Map<String, Object> addDeathCertificate(	Map<String, Object> generalMap) {
		return misDataService.addDeathCertificate(generalMap);
	}

	public Map<String, Object> showUpdateDeathCertificate(Map<String, Object> map) {
		return misDataService.showUpdateDeathCertificate(map);
	}

	public boolean submitUpdateDeathCertificate(Map<String, Object> generalMap) {
		return misDataService.submitUpdateDeathCertificate(generalMap);
	}

	public Map<String, Object> showIIBedStateReport(Map<String, Object> map) {
		return misDataService.showIIBedStateReport(map);
	}

	// ---------------------------------------------------------------------------------------------------------
	public MISDataService getMisDataService() {
		return misDataService;
	}

	public void setMisDataService(MISDataService misDataService) {
		this.misDataService = misDataService;
	}

	public Map<String, Object> showBedStatisticsSummaryjsp(
			Map<String, Object> map) {
		return misDataService.addDeathCertificate(map);
	}

	public Map<String, Object> chechBed(Map<String, Object> dataMap) {
		
		return misDataService.chechBed(dataMap);
	}

	public List<Object> getExpiredAdmissionNumberList(
			Map<String, Object> detailsMap) {
		
		return misDataService.getExpiredAdmissionNumberList(detailsMap);
	}

	public Map<String, Object> getHinAdNoDetailsFatalCase(
			Map<String, Object> detailsMap) {
		
		return misDataService.getHinAdNoDetailsFatalCase(detailsMap);
	}
	public Map<String, Object> getServiceNoDetailsForReg(Box box) {
		return misDataService.getServiceNoDetailsForSho(box) ;
	}

	public Map<String, Object> populateHinNo(Map<String, Object> dataMap) {
		
		return misDataService.populateHinNo(dataMap);
	}

	public Map<String, Object> getFRWDetails(Map<String, Object> dataMap) {
		
		return misDataService.getFRWDetails(dataMap);
	}

	public Map<String, Object> getHinAdNoFatalPanchanama(
			Map<String, Object> detailsMap) {
		
		return misDataService.getHinAdNoFatalPanchanama(detailsMap);
	}

	public Map<String, Object> showDeathInformation(
			Map<String, Object> detailsMap) {
		
		return misDataService.showDeathInformation(detailsMap);
	}

	public Map<String, Object> showEDreports(Map<String, Object> map) {
		
		return misDataService.showEDreports(map);
	}

	public Map<String, Object> getHinNoForDeficient(Map<String, Object> dataMap) {
		
		return misDataService.getHinNoForDeficient(dataMap);
	}

	public Map<String, Object> getHinNoForSurplus(Map<String, Object> dataMap) {
		
		return misDataService.getHinNoForSurplus(dataMap);
	}

	public Map<String, Object> showMisDailyReportJsp() {
		
		return misDataService.showMisDailyReportJsp();
	}

	public Map<String, Object> getHinAdNoForND(Map<String, Object> detailsMap) {
		
		return misDataService.getHinAdNoForND(detailsMap);
	}
    public Map<String, Object> getHinNoForMalariaCase(Map<String,Object> detailsMap)
     {
    	return misDataService.getHinNoForMalariaCase(detailsMap);
     }
    public Map<String, Object> getHinNoForFoodHandler(Map<String,Object>  detailsMap)
    {
    	return misDataService.getHinNoForFoodHandler(detailsMap);
    }
	public Map<String, Object> getResponceForAME(Map<String, Object> dataMap) {
		
		return misDataService.getResponceForAME(dataMap);
	}

	public Map<String, Object> getHiAdListForBD(Map<String, Object> detailsMap) {
		
		return misDataService.getHiAdListForBD(detailsMap);
	}

	public Map<String, Object> printPMO(Map<String, Object> detailsMap) {
		return misDataService.printPMO(detailsMap);
	}

	public Map<String, Object> bedStatisticsSummary(Map<String, Object> dataMap) {
		
		return misDataService.bedStatisticsSummary(dataMap);
	}

	// -------------------Total Admission in Excel Formate-----by
	// Kalyan-------------------//
	public Map<String, Object> totalAdmissionExcelSoftCopy(Box box) {
		
		return misDataService.totalAdmissionExcelSoftCopy(box);
	}

	// -----------T.A.Excel End ---------------//

	public Map<String, Object> totalDischargeExcelSoftCopy(Box box) {
		
		return misDataService.totalDischargeExcelSoftCopy(box);
	}

	public Map<String, Object> getTotalMisDailyReport(
			Map<String, Object> dataMap) {
		
		return misDataService.getTotalMisDailyReport(dataMap);
	}

	public Map<String, Object> closeExistingRecord(Box box) {
		
		return misDataService.closeExistingRecord(box);
	}

	public Map<String, Object> getExistingDetails(Box box) {
		
		return misDataService.getExistingDetails(box);
	}

	//------------Add By Diplai-------------------------------

	public Map<String, Object> submitAnnualMedicalExamination(Box box, Map<String, Object> dataMap) {
		return misDataService.submitAnnualMedicalExamination(box,dataMap);
	}

	public Map<String, Object> showAmeLmcReportJsp() {
		return misDataService.showAmeLmcReportJsp();
	}
	public Map<String, Object> showSilDilReportJsp() {

        return misDataService.showSilDilReportJsp();

  }
	public Map<String, Object> printSILDILStatusReport(Date fromDate,
			Date toDate) {
		
		return misDataService.printSILDILStatusReport(fromDate,toDate);
	}
	public List<Object> getAdmissionNoList1(Map<String, Object> map) {
		return misDataService.getAdmissionNoList1(map);
	}
	public Map<String, Object> searchMonthlySickExcelReport(Box box){
		return misDataService.searchMonthlySickExcelReport(box);
	}
	public Map<String, Object> searchMonthlySickExcelForm38BReport(Box box){
		return misDataService.searchMonthlySickExcelForm38BReport(box);
	}
	public boolean checkFRWDone(String ADNumber){
		return misDataService.checkFRWDone(ADNumber);
	}
	 public String getHospitalName(int hospitalId)
	 {
		 return misDataService.getHospitalName(hospitalId);
	 }
	 public Map<String, Object> getRankUnitSexList()
	 {
			
			return misDataService.getRankUnitSexList();
		}
	 public Map<String, Object> submitFatalDocument(Box box)
	 {
		 return misDataService.submitFatalDocument(box);
	 }
	 public Map<String, Object> getPatientDetails(Map<String, Object> dataMap)
	 {
		 return misDataService.getPatientDetails(dataMap);
	 }
	 public Map<String,Object> getDoctorList(Map<String,Object> mapForDS)
	  {
		 return misDataService.getDoctorList(mapForDS);
	  }
	 public Map<String,Object> getWaitingPatientList(Map mapForDs)
	   {
		 return misDataService.getWaitingPatientList(mapForDs);
	   }
	 public Map<String,Object> getPatientForValidate(Map mapForDS)
	    {
		  return misDataService.getPatientForValidate(mapForDS);
	    }
	 public Map<String, Object> displayFileUploadData(Map<String, Object> dataMap)
		{
			return misDataService.displayFileUploadData(dataMap);
		}
	 
	 public Map<String, Object> submitUploadDocumentsAreaForSho(Map<String, Object> dataMap)
		{
			return misDataService.submitUploadDocumentsAreaForSho(dataMap);
		} 
	 public boolean submitAccidentalDetailJsp(Map map)
	   {
		 return misDataService.submitAccidentalDetailJsp(map);
	   }
    public boolean submitFreeFromInfection(Map map)
    {
    	return misDataService.submitFreeFromInfection(map);
    }
    public boolean submitWaterSurveillanceJsp(Map map)
    {
    	return misDataService.submitWaterSurveillanceJsp(map);
    }
	@Override
	public Map<String, Object> showNotifiableDisease(Map<String, Object> generalMap) {
		return null;
		}

	@Override
	public Map<String, Object> getWaitingPatientListForcouncling(Map<String, Object> mapForDS) {
		return misDataService.getWaitingPatientListForcouncling(mapForDS);
	}

	@Override
	public Map<String, Object> getPatientForValidateCounselling(Map<String, Object> mapForDS) {
		return misDataService.getPatientForValidateCounselling(mapForDS);
	}
	public Map<String,Object> submitUploadDocumentsVectorControlForSho(Map<String,Object> dataMap)
	  {
		 return misDataService.submitUploadDocumentsVectorControlForSho(dataMap);
	  }
    public Map<String ,Object>getUploadDocumentDetails(Map<String,Object> dataMap)
      {
    	return misDataService.getUploadDocumentDetails(dataMap);
      }
    public Map<String,Object> getUploadDocumentShoData(Map<String,Object> dataMap)
      {
    	return misDataService.getUploadDocumentShoData(dataMap);
      }
	@Override
	public boolean validateSmoCounseling(Map<String, Object> map) {
		return misDataService.validateSmoCounseling(map);
	}

	@Override
	public boolean saveWaterSurvillanceDetails(Box box) {
		return misDataService.saveWaterSurvillanceDetails(box);
	}

	@Override
	public Map<String, Object> showFatalCasejsp(Map<String, Object> dataMap) {
		return misDataService.showFatalCasejsp(dataMap);
	}

	@Override
	public Map<String, Object> showEDReturns(Map<String, Object> dataMap) {
		return misDataService.showEDReturns(dataMap);
	}
   public Map<String,Object> getMonthlyWorkloadDetails(Map<String,Object> mapForData)
   {
	   return misDataService.getMonthlyWorkloadDetails(mapForData);
   }

public Map<String, Object> showMotorCycleJsp() {
	return misDataService.showMotorCycleJsp();
}

public Map<String, Object> showFamilyHealthProgrammeJsp() {
	return misDataService.showFamilyHealthProgrammeJsp();
}

@Override
public boolean submitFamilyHealthProgrammeJsp(Map map) {
	return misDataService.submitFamilyHealthProgrammeJsp(map);
}

public Map<String,Object> getServiceNoDetailsForMortalityAmongstFamilies(String serviceNo)
{
	return misDataService.getServiceNoDetailsForMortalityAmongstFamilies(serviceNo);
}

@Override
public boolean submitMortalityAmongstFamiliesJsp(Map<String, Object> map) {
	return misDataService.submitMortalityAmongstFamiliesJsp(map);
}
public Map<String, Object> showFamilyHealthProgrammeReport() {

    return misDataService.showFamilyHealthProgrammeReport();

}

public String getCommandName(int commandId)
{
	 return misDataService.getCommandName(commandId);
}

@Override
public boolean submitActivityAgainstHiv(Map<String, Object> map) {
	
	return misDataService.submitActivityAgainstHiv(map);
}

@Override
public boolean submitBiomedicalwastemgtjsp(Map<String, Object> map) {
	return misDataService.submitBiomedicalwastemgtjsp(map);
}

@Override
public Map<String, Object> showBiomedicalwastemgtjsp(Map<String, Object> map) {
	return misDataService.showBiomedicalwastemgtjsp(map);
}

@Override
public Map<String, Object> getHinNoForNotifiableDisease(String serviceNo) {
	return misDataService.getHinNoForNotifiableDisease(serviceNo);
}

public Map<String,Object> getPatientDetailForNotifiableDisease(Map<String,Object> mapForDS)
{
	return misDataService.getPatientDetailForNotifiableDisease(mapForDS);
}

@Override
public Map<String,Object> getServiceNoDetailsForAttemptSucide(Map<String,Object> mapForDS)
{
	return misDataService.getServiceNoDetailsForAttemptSucide(mapForDS);
}

@Override
public Map<String, Object> getHinNoForAttemptSucide(String serviceNo) {
	return misDataService.getHinNoForAttemptSucide(serviceNo);
}

public Map<String, Object> getServiceNoDetailsForAccidentRider(String serviceNo) {
	return misDataService.getServiceNoDetailsForAccidentRider(serviceNo);
}

public Map<String,Object> getPatientDetailForAccidentalDetails(Map<String,Object> mapForDS)
{
	return misDataService.getPatientDetailForAccidentalDetails(mapForDS);
}

public Map<String, Object> getServiceNoDetailsForAccident(String serviceNo) {
	return misDataService.getServiceNoDetailsForAccident(serviceNo);
}

public Map<String,Object> getPatientDetailForAccidentalDetailsDriver(Map<String,Object> mapForDS)
{
	return misDataService.getPatientDetailForAccidentalDetailsDriver(mapForDS);
}

public Map<String,Object> getPatientDetailForMortality(Map<String,Object> mapForDS)
{
	return misDataService.getPatientDetailForMortality(mapForDS);
}

@Override
public Map<String, Object> updateDiagnosis(Box box) {
	return misDataService.updateDiagnosis(box);
}
@Override
public Map<String, Object> getHinNoForFreeFromInfection(String serviceNo) {
	return misDataService.getHinNoForFreeFromInfection(serviceNo);
}

@Override
public Map<String,Object> getServiceNoDetailsForFreeFromInfection(Map<String,Object> mapForDS)
{
	return misDataService.getServiceNoDetailsForFreeFromInfection(mapForDS);
}

@Override
public Map<String, Object> showDefeicientReportJsp() {
	return misDataService.showDefeicientReportJsp();
}

@Override
public Map<String, Object> getMonthlySickAdmissionDetails(Box box) {
	return misDataService.getMonthlySickAdmissionDetails(box);
}

@Override
public Map<String, Object> getServiceNoDetails(Box box) {
	return misDataService.getServiceNoDetails(box);
}

@Override
public Map<String, Object> submitMonthlySickAdmission(Box box) {
	return misDataService.submitMonthlySickAdmission(box);
}


public Map<String, Object> showMonthlyWorkLoadReport(Map<String, Object> map) {
	return misDataService.showMonthlyWorkLoadReport(map);
}

@Override
public Map<String, Object> getMonthlySickDischargeDetails(Box box) {
	return misDataService.getMonthlySickDischargeDetails(box);
}

@Override
public Map<String, Object> submitMonthlySickDischarge(Box box) {
	return misDataService.submitMonthlySickDischarge(box);
}

@Override
public Map<String, Object> getWaitingPatientListForNotifiable(Map<String, Object> mapForDS) {
	return misDataService.getWaitingPatientListForNotifiable(mapForDS);
}

@Override
public Map<String, Object> showNotifiableDiseaseWLJsp(Map<String, Object> generalMap) {
	return misDataService.showNotifiableDiseaseWLJsp(generalMap);
}

@Override
public boolean submitNotifiableDiseaseWLJsp(Map<String, Object> map) {
	return misDataService.submitNotifiableDiseaseWLJsp(map);
}

@Override
public boolean submitBreakDownJSP(Map<String, Object> map) {
	return misDataService.submitBreakDownJSP(map);
}

@Override
public Map<String, Object> showBreakDown(Map<String, Object> dataMap) {
	return misDataService.showBreakDown(dataMap);
}

@Override
public Map<String, Object> showShoAccommodation(Map<String, Object> dataMap) {
	return misDataService.showShoAccommodation(dataMap);
}

@Override
public Map<String, Object> showShoAntiFilaria(Map<String, Object> dataMap) {
	return misDataService.showShoAntiFilaria(dataMap);
}

@Override
public boolean submitShoAccommodationJSP(Map<String, Object> map) {
	return misDataService.submitShoAccommodationJSP(map);
}

@Override
public boolean submitShoAntiFilariaJSP(Map<String, Object> map) {
	return misDataService.submitShoAntiFilariaJSP(map);
}

@Override
public Map<String, Object> showShoConservancy(Map<String, Object> dataMap) {
	return misDataService.showShoConservancy(dataMap);
}

@Override
public boolean submitShoConservancyJSP(Map<String, Object> map) {
	return misDataService.submitShoConservancyJSP(map);
}

@Override
public Map<String, Object> showShoCatering(Map<String, Object> dataMap) {
	return misDataService.showShoCatering(dataMap);
}

@Override
public boolean submitShoCateringJSP(Map<String, Object> map) {
	return misDataService.submitShoCateringJSP(map);
}

@Override
public Map<String, Object> showSchoolHealth(Map<String, Object> dataMap) {
	return misDataService.showSchoolHealth(dataMap);
}

@Override
public boolean submitSchoolHealthJsp(Map<String, Object> map) {
	return misDataService.submitSchoolHealthJsp(map);
}

// By Mansi on 13 may 2013

@Override
public Map<String, Object> showAdmissionDeath(Map<String, Object> dataMap) {
	return misDataService.showAdmissionDeath(dataMap);
}

@Override
public Map<String, Object> submitAdmissionDeath(Box box, Map<String, Object> mapForDS) {
	return misDataService.submitAdmissionDeath(box, mapForDS);
}


//By Kiran
@Override
public Map<String, Object> showOfficerDetails(Map<String, Object> dataMap) {
	return misDataService.showOfficerDetails(dataMap);
}

@Override
public boolean submitLadyOfficerJsp(Map<String, Object> map) {
	return misDataService.submitLadyOfficerJsp(map);
}

@Override
public Map<String, Object> showIndustrialDisease(Map<String, Object> dataMap) {
	return misDataService.showIndustrialDisease(dataMap);
}

@Override
public boolean submitShoIndustrialDisease(Map<String, Object> map) {
	return misDataService.submitShoIndustrialDisease(map);
}

//--------- By Mansi on 17 May 2013

@Override
public Map<String, Object> showFamilyWelfareActivities(Map<String, Object> dataMap) {
	return misDataService.showFamilyWelfareActivities(dataMap);
}

@Override
public Map<String, Object> submitFamilyWelfareActivities(Box box,Map<String, Object> mapForDS) {
	return misDataService.submitFamilyWelfareActivities(box, mapForDS);
}

@Override
public Map<String, Object> showWorkService(Map<String, Object> dataMap) {
	return misDataService.showWorkService(dataMap);
}

@Override
public boolean submitWorkService(Map<String, Object> map) {
	return misDataService.submitWorkService(map);
}


@Override
public Map<String, Object> getSerNoDetailForIncident(Box box) {
	return misDataService.getSerNoDetailForIncident(box);
}

@Override
public Map<String, Object> fillAVServiceDetail(Map<String, Object> dataMap) {
	return misDataService.fillAVServiceDetail(dataMap);
}
}
