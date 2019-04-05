package jkt.hms.dental.handler;

import java.util.Map;


import jkt.hms.dental.dataservice.DentalDataService;
import jkt.hms.util.Box;

public class DentalHandlerServiceImpl implements DentalHandlerService {
	DentalDataService dentalDataService = null;

	public DentalDataService getDentalDataService() {
		return dentalDataService;
	}

	public void setDentalDataService(DentalDataService dentalDataService) {
		this.dentalDataService = dentalDataService;
	}

	@Override
	public Map<String, Object> getDentalWaitingList(Map<String, Object> mapForDS) {
		
		return dentalDataService.getDentalWaitingList(mapForDS);
	}

	@Override
	public Map<String, Object> getDentalPatientDataList(Map<String, Object> dataMap) {
		
		return dentalDataService.getDentalPatientDataList(dataMap);
	}

	@Override
	public Map<String, Object> submitDentalTreatmentDetails(Box box,Map<String, Object> mapForDS) {
		
		return dentalDataService.submitDentalTreatmentDetails(box,mapForDS);
	}

	@Override
	public Map<String, Object> getDentalProcedureForAutoComplete(
			Map<String, Object> map) {
		
		return dentalDataService.getDentalProcedureForAutoComplete(map);
	}

	@Override
	public Map<String, Object> getPreviousPatientVisitForDental(Map<String, Object> mapForDS) {
		
		return dentalDataService.getPreviousPatientVisitForDental(mapForDS);
	}

	@Override
	public Map<String, Object> getOPDDetailsForOpdDentalUpdate(Map<String, Object> dataMap) {
		
		return dentalDataService.getOPDDetailsForOpdDentalUpdate(dataMap);
	}

	@Override
	public Map<String, Object> getPatientOpdDentalDetails(Map<String, Object> dataMap) {
		
		return dentalDataService.getPatientOpdDentalDetails(dataMap);
	}

	@Override
	public Map<String, Object> showDentalPopupTokenJsp(Map<String, Object> mapForDS) {
		
		return dentalDataService.showDentalPopupTokenJsp(mapForDS);
	}

	@Override
	public Map<String, Object> getDetailsForReport(int hospitalId) {
		
		return dentalDataService.getDetailsForReport(hospitalId);
	}

	@Override
	public Map<String, Object> getDentalRegisterData(Box box) {
		// TODO Auto-generated method stub
		return dentalDataService.getDentalRegisterData(box);
	}

	@Override
	public Map<String, Object> getConnectionForReport() {
		// TODO Auto-generated method stub
		return dentalDataService.getConnectionForReport();
	}

	@Override
	public Map<String, Object> getPocedureList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dentalDataService.getPocedureList(map);
	}

	
	
	
	
	
	
	
	

}
