package jkt.hms.monitoring.dataservice;

import java.util.Map;

public interface MonitoringDataService {
	Map<String, Object> getHealthMonitoringDetails(int userId);

	Map<String, Object> getMedExamBoardMonitoringDetails(Integer userId);

	Map<String, Object> getAvMedicineMonitoringDetails(Integer id);

	Map<String, Object> getCmdHealthMonitoringDetails(int userId, int commandId);

	Map<String, Object> getCmdMedExamBoardDetails(int userId, int commandId);

	Map<String, Object> getCmdAviMonitoringJsp(int userId, int commandId);


	Map<String, Object> getSmcHealthMonitoringDetails(int userId, int hospitalId, int commandId);

	Map<String, Object> getSmcMedExamBoardDetails(int userId, int hospitalId, int commandId);
	
	//Map<String, Object> getSmcMedExamBoardDetails(int userId, int hospitalId);

	Map<String, Object> getSmcAviationDetails(int userId, int hospitalId, int commandId);

	Map<String, Object> getAirHqStoregDetails(Integer userId);

	Map<String, Object> getCmdStoreMonitoringJsp(int userId, int commandId);

	Map<String, Object> getSMCStoreDetails(int userId, int hospitalId, int commandId);

	Map<String, Object> getAirHqFWCDetails(Integer id);

	Map<String, Object> getCmdFWCDetails(int userId, int commandId);

	Map<String, Object> getSMCFWCDetails(int userId, int hospitalId, int commandId);

	Map<String, Object> showStatsMonitoringJsp(Integer id);
	
	Map<String, Object> getCmdStatsDetails(int userId, int commandId);

	Map<String, Object> getSmcStatsDetails(int userId, int hospitalId, int commandId);
	
	Map<String, Object> showMedLecturePop(int cmdId);

	Map<String, Object> showPreFlightMedCheckUpPop(int cmdId);

	Map<String, Object> showCivilAviationPop(int cmdId);

	Map<String, Object> showMedLecturePopH(int cmdId, int hospitalId);

	Map<String, Object> showPreFlightMedCheckUpPopH(int cmdId,int hospitalId);

	Map<String, Object> showCivilAviationPopH(int cmdId,int hospitalId);
	
	
	Map<String, Object> showMedLecturePopCH(int cmdId, int hospitalId);

	Map<String, Object> showPreFlightMedCheckUpPopCH(int cmdId,int hospitalId);

	Map<String, Object> showCivilAviationPopCH(int cmdId,int hospitalId);

	Map<String, Object> showSilDilPop(int cmdId);
	
	Map<String, Object> showEdReturnsPop(int cmdId);

	Map<String, Object> showDeficientPop(int cmdId);

	Map<String, Object> showSurplusPop(int cmdId);

	Map<String, Object> showMonthlySickDetailsPop(int cmdId);
	
	Map<String, Object> showMonthlySickDetailsPopH(int cmdId, int hospitalId);

	Map<String, Object> showSurplusPopH(int cmdId, int hospitalId);

	Map<String, Object> showDeficientPopH(int cmdId, int hospitalId);

	Map<String, Object> showEdReturnsPopH(int cmdId, int hospitalId);

	Map<String, Object> showSilDilPopH(int cmdId, int hospitalId);
	
	Map<String, Object> showMonthlySickDetailsPopCH(int cmdId, int hospitalId);

	Map<String, Object> showSurplusPopCH(int cmdId, int hospitalId);

	Map<String, Object> showDeficientPopCH(int cmdId, int hospitalId);

	Map<String, Object> showEdReturnsPopCH(int cmdId, int hospitalId);

	Map<String, Object> showSilDilPopCH(int cmdId, int hospitalId);
	
	Map<String, Object> showServiceDetails(Map<String, Object> map);
	
	Map<String, Object> showServiceDetailsAdmission(Map<String, Object> map);

	Map<String, Object> showServiceDetailsAirCraft(Map<String, Object> map);

	Map<String, Object> showServiceDetailsAirCraftH(Map<String, Object> map);

	Map<String, Object> showServiceDetailsAdmissionH(Map<String, Object> map);

	Map<String, Object> showServiceDetailsH(Map<String, Object> map);

	Map<String, Object> showServiceDetailsAirCraftS(Map<String, Object> map);

	Map<String, Object> showServiceDetailsAdmissionS(Map<String, Object> map);

	Map<String, Object> showServiceDetailsS(Map<String, Object> map);

	Map<String, Object> showServiceDetailsMbPend(Map<String, Object> map);

	Map<String, Object> showServiceDetailsMB(Map<String, Object> map);

	Map<String, Object> showServiceDetailsMePend(Map<String, Object> map);

	Map<String, Object> showServiceDetailsME(Map<String, Object> map);

	Map<String, Object> showServiceDetailsMbPendH(Map<String, Object> map);

	Map<String, Object> showServiceDetailsMBH(Map<String, Object> map);

	Map<String, Object> showServiceDetailsMePendH(Map<String, Object> map);

	Map<String, Object> showServiceDetailsMEH(Map<String, Object> map);
	
	Map<String, Object> showServiceDetailsMbPendS(Map<String, Object> map);

	Map<String, Object> showServiceDetailsMBS(Map<String, Object> map);

	Map<String, Object> showServiceDetailsMePendS(Map<String, Object> map);

	Map<String, Object> showServiceDetailsMES(Map<String, Object> map);
	
	Map<String, Object> showPerformaB(Map<String, Object> map);

	Map<String, Object> showPncVisitPop(int cmdId);

	Map<String, Object> showAncVisitPop(int cmdId);
	
	
	Map<String, Object> showPncVisitPopH(int cmdId, int hospitalId);

	Map<String, Object> showAncVisitPopH(int cmdId, int hospitalId);
	
	Map<String, Object> showPncVisitPopCH(int cmdId, int hospitalId);

	Map<String, Object> showAncVisitPopCH(int cmdId, int hospitalId);
	
	
	Map<String, Object> showMonthlyMalariaCasePop(int cmdId);

	Map<String, Object> showRtaPop(int cmdId);

	Map<String, Object> showAttemptSuicideCasesPop(int cmdId);

	Map<String, Object> showNotifiableDiseasePop(int cmdId);

	Map<String, Object> showMonthlyMalariaCasePopH(int cmdId, int hospitalId);

	Map<String, Object> showRtaPopH(int cmdId, int hospitalId);

	Map<String, Object> showAttemptSuicideCasesPopH(int cmdId, int hospitalId);

	Map<String, Object> showNotifiableDiseasePopH(int cmdId, int hospitalId);

	Map<String, Object> showMonthlyMalariaCasePopCH(int cmdId, int hospitalId);

	Map<String, Object> showRtaPopCH(int cmdId, int hospitalId);

	Map<String, Object> showAttemptSuicideCasesPopCH(int cmdId, int hospitalId);

	Map<String, Object> showNotifiableDiseasePopCH(int cmdId, int hospitalId);
	
	Map<String, Object> getShoSmcMonitoringJsp(int userId, int hospitalId,int commandId);
	
	
	Map<String, Object> showPerformaBPend(Map<String, Object> map);

	Map<String, Object> showDefectiveDrug(Map<String, Object> map);
	
	Map<String, Object> showPerformaBH(Map<String, Object> map);

	Map<String, Object> showPerformaBPendH(Map<String, Object> map);

	Map<String, Object> showDefectiveDrugH(Map<String, Object> map);

	Map<String, Object> showDefectiveDrugPendH(Map<String, Object> map);
	
	Map<String, Object> showPerformaBS(Map<String, Object> map);

	Map<String, Object> showPerformaBPendS(Map<String, Object> map);

	Map<String, Object> showDefectiveDrugS(Map<String, Object> map);

	Map<String, Object> showDefectiveDrugPendS(Map<String, Object> map);
	
	Map<String, Object> getShoMonitoringJsp(int userId);

	Map<String, Object> getShoMonitoringCmdJsp(int userId, int commandId);

	Map<String, Object> getDBConnection();
}