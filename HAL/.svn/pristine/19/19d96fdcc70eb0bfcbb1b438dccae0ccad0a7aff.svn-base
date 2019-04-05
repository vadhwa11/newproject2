package jkt.hms.pacs.dataservice;

import java.util.List;
import java.util.Map;

import jkt.hms.pacs.controller.PacsPatient;

public interface PacsDataService {
	
	public List<PacsPatient> getAllPacsPatients(Map<String, Object> map);
	public int getPacsPatientsCount(Map<String, Object> map); 
	public void deletePatient(int patientId);
	public Map<String, Object> getPreviousVisit(Map<String, Object> details);
	public Map<String, Object> getPacsAuthenticationService(Map<String, Object> dataMap);
	public Map<String, Object> getUsers(Map<String, Object> dataMap);
	public Map<String, Object> pacsRightSave(Map<String, Object> dataMap);
	public Map<String, Object> pacsRightsList(Map<String, Object> dataMap); 
	public Map<String, Object> submitPacsTemplate(
			Map<String, Object> parameterMap);
	public Map<String, Object> getTemplatesForAutoComplete(
			Map<String, Object> map);
	public Map<String, Object> getsearchtemplates(
			Map<String, Object> parameterMap);
	public Map<String, Object> updatePacsTemplate(
			Map<String, Object> parameterMap);
	public Map<String, Object> pacsPatientDetails(Map<String, Object> dataMap);
	public Map<String, Object> submitPatientHistory(
			Map<String, Object> parameterMap);
	public Map<String, Object> downloadHistoryFile(
			Map<String, Object> parameterMap);
	public Map<String, Object> submitPatientReport(
			Map<String, Object> parameterMap);
	public Map<String, Object> pacsPatientReportDetails(
			Map<String, Object> parameterMap);
	public Map<String, Object> downloadReportFile(
			Map<String, Object> parameterMap);
	public Map<String, Object> deleteReport(Map<String, Object> parameterMap);
	public Map<String, Object> editReport(Map<String, Object> parameterMap);
	public Map<String, Object> PrintPatientPacsReportDetails(
			Map<String, Object> dataMap);
	public Map<String, Object> getsignatureDetails(Map<String, Object> dataMap);
	/*public Map<String, Object> centralServerService(Map<String, Object> dataMap); 
	public Map<String, Object> sendData(Map<String, Object> dataMap); 
	public Map<String, Object> sendDataServerToLean(Map<String, Object> dataMap); 
	public Map<String, Object> receiveDataServerToLean(Map<String, Object> dataMap);*/
	public List<PacsPatient> getAllPacsPatientsforRadiologyReport(
			Map<String, Object> map); 
}
