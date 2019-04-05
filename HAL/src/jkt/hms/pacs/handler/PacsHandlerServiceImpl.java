package jkt.hms.pacs.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.pacs.controller.PacsPatient;
import jkt.hms.pacs.dataservice.PacsDataService;

public class PacsHandlerServiceImpl implements PacsHandlerService{
	PacsDataService pacsDataService = null;

	public PacsDataService getPacsDataService() {
		return pacsDataService;
	}
	
	public void setPacsDataService(PacsDataService pacsDataService) {
		this.pacsDataService = pacsDataService;
	}
	
	@Override
	public void deletePatient(int patientId) {
		
	}
	 
	@Override
	public List<PacsPatient> getAllPacsPatients(Map<String, Object> map) {
		return pacsDataService.getAllPacsPatients(map);
	}
	
	@Override
	public int getPacsPatientsCount(Map<String, Object> map) {
		return pacsDataService.getPacsPatientsCount(map);
	}

	@Override
	public Map<String, Object> getPreviousVisit(Map<String, Object> details) {
		return pacsDataService.getPreviousVisit(details);
	}
	
	@Override
	public Map<String, Object> getPacsAuthenticationService(
			Map<String, Object> dataMap) {
		return pacsDataService.getPacsAuthenticationService(dataMap);
	}
	
	@Override
	public Map<String, Object> getUsers(Map<String, Object> dataMap) {
		return pacsDataService.getUsers(dataMap);
	} 
	@Override
	public Map<String, Object> pacsRightSave(Map<String, Object> dataMap) {
		return pacsDataService.pacsRightSave(dataMap);
	}
	@Override
	public Map<String, Object> pacsRightsList(Map<String, Object> dataMap) {
		return pacsDataService.pacsRightsList(dataMap);
	}
	
	@Override
	public Map<String, Object> submitPacsTemplate(Map<String, Object> parameterMap) {
		return pacsDataService.submitPacsTemplate(parameterMap);
	}

	@Override
	public Map<String, Object> getTemplatesForAutoComplete(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return pacsDataService.getTemplatesForAutoComplete(map);
	}
 

	@Override
	public Map<String, Object> getsearchtemplates(Map<String, Object> parameterMap) {
		return pacsDataService.getsearchtemplates(parameterMap);
	}

	@Override
	public Map<String, Object> updatePacsTemplate(Map<String, Object> parameterMap) {
		return pacsDataService.updatePacsTemplate(parameterMap);
	}

	@Override
	public Map<String, Object> pacsPatientDetails(Map<String, Object> dataMap) {
		return pacsDataService.pacsPatientDetails(dataMap);
	}

	@Override
	public Map<String, Object> submitPatientHistory(Map<String, Object> parameterMap) {
		return pacsDataService.submitPatientHistory(parameterMap); 
	}

	@Override
	public Map<String, Object> downloadHistoryFile(Map<String, Object> parameterMap) {
		return pacsDataService.downloadHistoryFile(parameterMap); 
	}

	@Override
	public Map<String, Object> submitPatientReport(Map<String, Object> parameterMap) {
		return pacsDataService.submitPatientReport(parameterMap); 
	}

	@Override
	public Map<String, Object> pacsPatientReportDetails(Map<String, Object> parameterMap) {
		return pacsDataService.pacsPatientReportDetails(parameterMap); 
	}

	@Override
	public Map<String, Object> downloadReportFile(Map<String, Object> parameterMap) {
		return pacsDataService.downloadReportFile(parameterMap);
	}

	@Override
	public Map<String, Object> deleteReport(Map<String, Object> parameterMap) {
		return pacsDataService.deleteReport(parameterMap);
	}

	@Override
	public Map<String, Object> editReport(Map<String, Object> parameterMap) {
		return pacsDataService.editReport(parameterMap);
	}

	@Override
	public Map<String, Object> PrintPatientPacsReportDetails(Map<String, Object> dataMap) {
		return pacsDataService.PrintPatientPacsReportDetails(dataMap);
	}

	@Override
	public Map<String, Object> getsignatureDetails(Map<String, Object> dataMap) {
		return pacsDataService.getsignatureDetails(dataMap);
	}
	/*@Override
	public Map<String, Object> centralServerService(Map<String, Object> dataMap) {
		return pacsDataService.centralServerService(dataMap);
	}
	@Override
	public Map<String, Object> sendData(Map<String, Object> dataMap) {
		return pacsDataService.sendData(dataMap);
	}
	@Override
	public Map<String, Object> receiveDataServerToLean(
			Map<String, Object> dataMap) {
		return pacsDataService.receiveDataServerToLean(dataMap);
	}
	@Override
	public Map<String, Object> sendDataServerToLean(Map<String, Object> dataMap) {
		return pacsDataService.sendDataServerToLean(dataMap);
	}*/

	@Override
	public List<PacsPatient> getAllPacsPatientsforRadiologyReport(Map<String, Object> map) {
		return pacsDataService.getAllPacsPatientsforRadiologyReport(map);
	}
}
