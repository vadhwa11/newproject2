package jkt.hms.monitoring.handler;

import java.util.Map;

import jkt.hms.monitoring.dataservice.MonitoringDataService;

public class MonitoringHandlerServiceImpl implements MonitoringHandlerService{

	MonitoringDataService monitoringDataService = null;
	
	public MonitoringDataService getMonitoringDataService() {
		return monitoringDataService;
	}
	public void setMonitoringDataService(MonitoringDataService monitoringDataService) {
		this.monitoringDataService = monitoringDataService;
	}

	@Override
	public Map<String, Object> getHealthMonitoringDetails(int userId) {
		return monitoringDataService.getHealthMonitoringDetails(userId);
	}
	@Override
	public Map<String, Object> getMedExamBoardMonitoringDetails(Integer userId) {
		return monitoringDataService.getMedExamBoardMonitoringDetails(userId);
	}
	@Override
	public Map<String, Object> getAvMedicineMonitoringDetails(Integer id) {
		return monitoringDataService.getAvMedicineMonitoringDetails(id);
	}
	@Override
	public Map<String, Object> getCmdHealthMonitoringDetails(int userId,int commandId) {
		return monitoringDataService.getCmdHealthMonitoringDetails(userId,commandId) ;
	}
	@Override
	public Map<String, Object> getCmdMedExamBoardDetails(int userId,int commandId) {
		return monitoringDataService.getCmdMedExamBoardDetails(userId, commandId);
	}
	@Override
	public Map<String, Object> getCmdAviMonitoringJsp(int userId, int commandId) {
		return monitoringDataService.getCmdAviMonitoringJsp(userId, commandId);
	}
	@Override
	public Map<String, Object> getSmcHealthMonitoringDetails(int userId,int hospitalId,int commandId) {
		return monitoringDataService.getSmcHealthMonitoringDetails(userId,hospitalId,commandId);
	}
	@Override
	public Map<String, Object> getSmcMedExamBoardDetails(int userId,int hospitalId,int commandId) {
		return monitoringDataService.getSmcMedExamBoardDetails(userId,hospitalId,commandId);
	}
	@Override
	public Map<String, Object> getSmcAviationDetails(int userId, int hospitalId,int commandId) {
		return monitoringDataService.getSmcAviationDetails(userId,hospitalId,commandId);
	}
	@Override
	public Map<String, Object> getAirHqStoregDetails(Integer userId) {
		return monitoringDataService.getAirHqStoregDetails(userId);
	}
	@Override
	public Map<String, Object> getCmdStoreMonitoringJsp(int userId,int commandId) {
		return monitoringDataService.getCmdStoreMonitoringJsp(userId,commandId);
	}
	@Override
	public Map<String, Object> getSMCStoreDetails(int userId, int hospitalId , int commandId) {
		return monitoringDataService.getSMCStoreDetails(userId, hospitalId, commandId);
	}
	@Override
	public Map<String, Object> getAirHqFWCDetails(Integer id) {
		return monitoringDataService.getAirHqFWCDetails(id);
	}
	@Override
	public Map<String, Object> getCmdFWCDetails(int userId, int commandId) {
		return monitoringDataService.getCmdFWCDetails(userId, commandId);
	}
	@Override
	public Map<String, Object> getSMCFWCDetails(int userId, int hospitalId,int commandId) {
		return monitoringDataService.getSMCFWCDetails(userId, hospitalId,commandId);
	}
	@Override
	public Map<String, Object> showStatsMonitoringJsp(Integer id) {
		return monitoringDataService.showStatsMonitoringJsp(id);
	}
	@Override
	public Map<String, Object> getCmdStatsDetails(int userId, int commandId) {
		return monitoringDataService.getCmdStatsDetails(userId, commandId) ;
	}
	@Override
	public Map<String, Object> getSmcStatsDetails(int userId, int hospitalId,int commandId) {
		return monitoringDataService.getSmcStatsDetails(userId, hospitalId,commandId);
	}
	
		@Override
	public Map<String, Object> showCivilAviationPop(int cmdId) {
		return monitoringDataService.showCivilAviationPop(cmdId);
	}
	@Override
	public Map<String, Object> showMedLecturePop(int cmdId) {
		return monitoringDataService.showCivilAviationPop(cmdId);
	}
	@Override
	public Map<String, Object> showPreFlightMedCheckUpPop(int cmdId) {
		return monitoringDataService.showPreFlightMedCheckUpPop(cmdId);
	}
	
		
	@Override
	public Map<String, Object> showCivilAviationPopH(int cmdId,int hospitalId) {
		return monitoringDataService.showCivilAviationPopH(cmdId,hospitalId);
	}
	@Override
	public Map<String, Object> showMedLecturePopH(int cmdId,int hospitalId) {
		return monitoringDataService.showCivilAviationPopH(cmdId,hospitalId);
	}
	@Override
	public Map<String, Object> showPreFlightMedCheckUpPopH(int cmdId,int hospitalId) {
		return monitoringDataService.showPreFlightMedCheckUpPopH(cmdId,hospitalId);
	}
	
	@Override
	public Map<String, Object> showCivilAviationPopCH(int cmdId,int hospitalId) {
		return monitoringDataService.showCivilAviationPopCH(cmdId,hospitalId);
	}
	@Override
	public Map<String, Object> showMedLecturePopCH(int cmdId,int hospitalId) {
		return monitoringDataService.showCivilAviationPopCH(cmdId,hospitalId);
	}
	@Override
	public Map<String, Object> showPreFlightMedCheckUpPopCH(int cmdId,int hospitalId) {
		return monitoringDataService.showPreFlightMedCheckUpPopCH(cmdId,hospitalId);
	}
	@Override
	public Map<String, Object> showSilDilPop(int cmdId) {
		return monitoringDataService.showSilDilPop(cmdId);
	}
	@Override
	public Map<String, Object> showDeficientPop(int cmdId) {
		return monitoringDataService.showDeficientPop(cmdId);
	}
	@Override
	public Map<String, Object> showEdReturnsPop(int cmdId) {
		return monitoringDataService.showEdReturnsPop(cmdId);
	}
	@Override
	public Map<String, Object> showMonthlySickDetailsPop(int cmdId) {
		return monitoringDataService.showMonthlySickDetailsPop(cmdId);
	}
	@Override
	public Map<String, Object> showSurplusPop(int cmdId) {
		return monitoringDataService.showSurplusPop(cmdId);
	}
	@Override
	public Map<String, Object> showDeficientPopH(int cmdId, int hospitalId) {
	
		 return monitoringDataService.showDeficientPopH(cmdId, hospitalId);
	}
	@Override
	public Map<String, Object> showEdReturnsPopH(int cmdId, int hospitalId) {
		 return monitoringDataService.showEdReturnsPopH(cmdId, hospitalId);
	}
	@Override
	public Map<String, Object> showMonthlySickDetailsPopH(int cmdId, int hospitalId) {
		 return monitoringDataService.showMonthlySickDetailsPopH(cmdId, hospitalId);
	}
	@Override
	public Map<String, Object> showSilDilPopH(int cmdId, int hospitalId) {
		 return monitoringDataService.showSilDilPopH(cmdId, hospitalId);
	}
	@Override
	public Map<String, Object> showSurplusPopH(int cmdId, int hospitalId) {
		 return monitoringDataService.showSurplusPopH(cmdId, hospitalId);
	}
	
	public Map<String, Object> showDeficientPopCH(int cmdId, int hospitalId) {
		
		 return monitoringDataService.showDeficientPopCH(cmdId, hospitalId);
	}
	@Override
	public Map<String, Object> showEdReturnsPopCH(int cmdId, int hospitalId) {
		 return monitoringDataService.showEdReturnsPopCH(cmdId, hospitalId);
	}
	@Override
	public Map<String, Object> showMonthlySickDetailsPopCH(int cmdId, int hospitalId) {
		 return monitoringDataService.showMonthlySickDetailsPopCH(cmdId, hospitalId);
	}
	@Override
	public Map<String, Object> showSilDilPopCH(int cmdId, int hospitalId) {
		 return monitoringDataService.showSilDilPopCH(cmdId, hospitalId);
	}
	@Override
	public Map<String, Object> showSurplusPopCH(int cmdId, int hospitalId) {
		 return monitoringDataService.showSurplusPopCH(cmdId, hospitalId);
	}
	
	@Override
	public Map<String, Object> showServiceDetails(Map<String, Object> map) {
		return monitoringDataService.showServiceDetails(map);
	}
	@Override
	public Map<String, Object> showServiceDetailsAdmission(Map<String, Object> map) {
		return monitoringDataService.showServiceDetailsAdmission(map);
	}
	
	@Override
	public Map<String, Object> showServiceDetailsAirCraft(Map<String, Object> map) {
		return monitoringDataService.showServiceDetailsAirCraft(map);
	}
	@Override
	public Map<String, Object> showServiceDetailsAdmissionH(Map<String, Object> map) {
		return monitoringDataService.showServiceDetailsAdmissionH(map);
	}
	@Override
	public Map<String, Object> showServiceDetailsAirCraftH(Map<String, Object> map) {
		return monitoringDataService.showServiceDetailsAirCraftH(map);
	}
	@Override
	public Map<String, Object> showServiceDetailsH(Map<String, Object> map) {
		return monitoringDataService.showServiceDetailsH(map);
	}
	@Override
	public Map<String, Object> showServiceDetailsAdmissionS(Map<String, Object> map) {
		return monitoringDataService.showServiceDetailsAdmissionS(map);
	}
	@Override
	public Map<String, Object> showServiceDetailsAirCraftS(Map<String, Object> map) {
		return monitoringDataService.showServiceDetailsAirCraftS(map);
	}
	@Override
	public Map<String, Object> showServiceDetailsS(Map<String, Object> map) {
		return monitoringDataService.showServiceDetailsS(map);
	}
	@Override
	public Map<String, Object> showServiceDetailsMB(Map<String, Object> map) {
		return monitoringDataService.showServiceDetailsMB(map);
	}
	@Override
	public Map<String, Object> showServiceDetailsME(Map<String, Object> map) {
		return monitoringDataService.showServiceDetailsME(map);
	}
	@Override
	public Map<String, Object> showServiceDetailsMbPend(Map<String, Object> map) {
		return monitoringDataService.showServiceDetailsMbPend(map);
	}
	@Override
	public Map<String, Object> showServiceDetailsMePend(Map<String, Object> map) {
		return monitoringDataService.showServiceDetailsMePend(map);
	}
	@Override
	public Map<String, Object> showServiceDetailsMBH(Map<String, Object> map) {
		return monitoringDataService.showServiceDetailsMBH(map);
	}
	@Override
	public Map<String, Object> showServiceDetailsMEH(Map<String, Object> map) {
		return monitoringDataService.showServiceDetailsMEH(map);
	}
	@Override
	public Map<String, Object> showServiceDetailsMbPendH(Map<String, Object> map) {
		return monitoringDataService.showServiceDetailsMbPendH(map);
	}
	@Override
	public Map<String, Object> showServiceDetailsMePendH(Map<String, Object> map) {
		return monitoringDataService.showServiceDetailsMePendH(map);
	}
	@Override
	public Map<String, Object> showServiceDetailsMBS(Map<String, Object> map) {
		return monitoringDataService.showServiceDetailsMBS(map);
	}
	@Override
	public Map<String, Object> showServiceDetailsMES(Map<String, Object> map) {
		return monitoringDataService.showServiceDetailsMES(map);
	}
	@Override
	public Map<String, Object> showServiceDetailsMbPendS(Map<String, Object> map) {
		return monitoringDataService.showServiceDetailsMbPendS(map);
	}
	@Override
	public Map<String, Object> showServiceDetailsMePendS(Map<String, Object> map) {
		return monitoringDataService.showServiceDetailsMePendS(map);
	}
	@Override
	public Map<String, Object> showAncVisitPop(int cmdId) {
		return monitoringDataService.showAncVisitPop(cmdId);
	}
	@Override
	public Map<String, Object> showPncVisitPop(int cmdId) {
		return monitoringDataService.showPncVisitPop(cmdId);
	}
	@Override
	public Map<String, Object> showAncVisitPopCH(int cmdId, int hospitalId) {
		return monitoringDataService.showAncVisitPopCH(cmdId, hospitalId);
	}
	@Override
	public Map<String, Object> showAncVisitPopH(int cmdId, int hospitalId) {
		return monitoringDataService.showAncVisitPopH(cmdId, hospitalId);
	}
	@Override
	public Map<String, Object> showPncVisitPopCH(int cmdId, int hospitalId) {
		return monitoringDataService.showPncVisitPopCH(cmdId, hospitalId);
	}
	@Override
	public Map<String, Object> showPncVisitPopH(int cmdId, int hospitalId) {
		return monitoringDataService.showPncVisitPopH(cmdId, hospitalId);
	}
	@Override
	public Map<String, Object> showAttemptSuicideCasesPop(int cmdId) {
		return monitoringDataService.showAttemptSuicideCasesPop(cmdId);
	}
	@Override
	public Map<String, Object> showAttemptSuicideCasesPopCH(int cmdId, int hospitalId) {
		return monitoringDataService.showAttemptSuicideCasesPopCH(cmdId, hospitalId);
	}
	@Override
	public Map<String, Object> showAttemptSuicideCasesPopH(int cmdId, int hospitalId) {
		return monitoringDataService.showAttemptSuicideCasesPopH(cmdId, hospitalId);
	}
	@Override
	public Map<String, Object> showMonthlyMalariaCasePop(int cmdId) {
		return monitoringDataService.showMonthlyMalariaCasePop(cmdId);
	}
	@Override
	public Map<String, Object> showMonthlyMalariaCasePopCH(int cmdId,
			int hospitalId) {
		return monitoringDataService.showMonthlyMalariaCasePopCH(cmdId, hospitalId);
	}
	@Override
	public Map<String, Object> showMonthlyMalariaCasePopH(int cmdId,
			int hospitalId) {
		return monitoringDataService.showMonthlyMalariaCasePopH(cmdId, hospitalId);
	}
	@Override
	public Map<String, Object> showNotifiableDiseasePop(int cmdId) {
		return monitoringDataService.showNotifiableDiseasePop(cmdId);
	}
	@Override
	public Map<String, Object> showNotifiableDiseasePopCH(int cmdId,
			int hospitalId) {
		return monitoringDataService.showNotifiableDiseasePopCH(cmdId, hospitalId);
	}
	@Override
	public Map<String, Object> showNotifiableDiseasePopH(int cmdId,
			int hospitalId) {
		return monitoringDataService.showNotifiableDiseasePopH(cmdId, hospitalId);
	}
	@Override
	public Map<String, Object> showRtaPop(int cmdId) {
		return monitoringDataService.showRtaPop(cmdId);
	}
	@Override
	public Map<String, Object> showRtaPopCH(int cmdId, int hospitalId) {
		return monitoringDataService.showRtaPopCH(cmdId, hospitalId);
	}
	@Override
	public Map<String, Object> showRtaPopH(int cmdId, int hospitalId) {
		return monitoringDataService.showRtaPopH(cmdId, hospitalId);
	}
	public Map<String, Object> getShoSmcMonitoringJsp(int userId,int hospitalId,int commandId) {
		return monitoringDataService.getShoSmcMonitoringJsp(userId,hospitalId,commandId);
	}
	
		public Map<String, Object> showDefectiveDrug(Map<String, Object> map) {
		return monitoringDataService.showDefectiveDrug(map);
	}
	@Override
	public Map<String, Object> showPerformaB(Map<String, Object> map) {
		return monitoringDataService.showPerformaB(map);
	}
	@Override
	public Map<String, Object> showPerformaBPend(Map<String, Object> map) {
		return monitoringDataService.showPerformaBPend(map);
	}
	@Override
	public Map<String, Object> showDefectiveDrugH(Map<String, Object> map) {
		return monitoringDataService.showDefectiveDrugH(map);
	}
	@Override
	public Map<String, Object> showDefectiveDrugPendH(Map<String, Object> map) {
		return monitoringDataService.showDefectiveDrugPendH(map);
	}
	@Override
	public Map<String, Object> showPerformaBH(Map<String, Object> map) {
		return monitoringDataService.showPerformaBH(map);
	}
	@Override
	public Map<String, Object> showPerformaBPendH(Map<String, Object> map) {
		return monitoringDataService.showPerformaBPendH(map);
	}
	@Override
	public Map<String, Object> showDefectiveDrugPendS(Map<String, Object> map) {
		return monitoringDataService.showDefectiveDrugPendS(map);
	}
	@Override
	public Map<String, Object> showDefectiveDrugS(Map<String, Object> map) {
		return monitoringDataService.showDefectiveDrugS(map);
	}
	@Override
	public Map<String, Object> showPerformaBPendS(Map<String, Object> map) {
		return monitoringDataService.showPerformaBPendS(map);
	}
	@Override
	public Map<String, Object> showPerformaBS(Map<String, Object> map) {
		return monitoringDataService.showPerformaBS(map);
	}
	@Override
	public Map<String, Object> getShoMonitoringCmdJsp(int userId, int commandId) {
		return monitoringDataService.getShoMonitoringCmdJsp(userId, commandId);
	}

	@Override
	public Map<String, Object> getShoMonitoringJsp(int userId) {
		return monitoringDataService.getShoMonitoringJsp(userId);
	}
	@Override
	public Map<String, Object> getDBConnection() {
		return monitoringDataService.getDBConnection();
	}
	
}
