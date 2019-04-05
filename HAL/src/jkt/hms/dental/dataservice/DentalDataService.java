package jkt.hms.dental.dataservice;

import java.util.Map;

import jkt.hms.util.Box;

public interface DentalDataService {

	Map<String, Object> getDentalWaitingList(Map<String, Object> mapForDs);

	Map<String, Object> getDentalPatientDataList(Map<String, Object> dataMap);

	Map<String, Object> submitDentalTreatmentDetails(Box box, Map<String, Object> mapForDS);

	Map<String, Object> getDentalProcedureForAutoComplete(Map<String, Object> map);

	Map<String, Object> getPreviousPatientVisitForDental(
			Map<String, Object> mapForDS);

	Map<String, Object> getOPDDetailsForOpdDentalUpdate(
			Map<String, Object> dataMap);

	Map<String, Object> getPatientOpdDentalDetails(Map<String, Object> dataMap);

	Map<String, Object> showDentalPopupTokenJsp(Map<String, Object> mapForDS);

	Map<String, Object> getDetailsForReport(int hospitalId);

	Map<String, Object> getDentalRegisterData(Box box);

	Map<String, Object> getConnectionForReport();

	Map<String, Object> getPocedureList(Map<String, Object> map);

}
