package jkt.hms.FacilityManagement.handler;

import java.util.Map;


import jkt.hms.util.Box;


public class FacilityManagementHandlerServiceImpl implements FacilityManagementHandlerService {

	jkt.hms.FacilityManagement.dataservice.FacilityManagementDataService facilityManagementDataService = null;
	
	

	
	public jkt.hms.FacilityManagement.dataservice.FacilityManagementDataService getFacilityManagementDataService() {
		return facilityManagementDataService;
	}




	public void setFacilityManagementDataService(
			jkt.hms.FacilityManagement.dataservice.FacilityManagementDataService facilityManagementDataService) {
		this.facilityManagementDataService = facilityManagementDataService;
	}




	@Override
	public Map<String, Object> showPendingListForEnterEquipmentDetailJsp(
			Box box, Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return facilityManagementDataService.showPendingListForEnterEquipmentDetailJsp(box, dataMap);
	}
	
	public Map<String, Object> showEquipmentDetailJsp(
			 Map<String, Object> dataMap) {
		return facilityManagementDataService.showEquipmentDetailJsp(dataMap);
	}
	

	public Map<String, Object> submitEquipmentDetails(
			 Map<String, Object> dataMap) {
		return facilityManagementDataService.submitEquipmentDetails(dataMap);
	}
	


	public Map<String, Object> getEquipmentDetails(
			 Map<String, Object> dataMap) {
		return facilityManagementDataService.getEquipmentDetails(dataMap);
	}
	
	public Map<String, Object> getEquipmentHistory(
			 Map<String, Object> dataMap) {
		return facilityManagementDataService.getEquipmentHistory(dataMap);
	}
	
	public Map<String, Object> equipmentDashBoard(
			 Map<String, Object> dataMap) {
		return facilityManagementDataService.equipmentDashBoard(dataMap);
	}

	
	public Map<String, Object> saveServiceDetails(
			 Map<String, Object> dataMap) {
		return facilityManagementDataService.saveServiceDetails(dataMap);
	}
	public Map<String, Object> getPendingServiceRequest(
			 Map<String, Object> dataMap) {
		return facilityManagementDataService.getPendingServiceRequest(dataMap);
	}
	
	public Map<String, Object> getRequestDetails(
			 Map<String, Object> dataMap) {
		return facilityManagementDataService.getRequestDetails(dataMap);
	}
	

	public Map<String, Object> saveServiceRequest(
			 Map<String, Object> dataMap) {
		return facilityManagementDataService.saveServiceRequest(dataMap);
	}	public Map<String, Object> getPendingListOfInspection(
			 Map<String, Object> dataMap) {
		return facilityManagementDataService.getPendingListOfInspection(dataMap);
	}	public Map<String, Object> getAssignResource(
			 Map<String, Object> dataMap) {
		return facilityManagementDataService.getAssignResource(dataMap);
	}
	
	public Map<String, Object> getResourceList(
			 Map<String, Object> dataMap) {
		return facilityManagementDataService.getResourceList(dataMap);
	}
	
	
	public Map<String, Object> saveAssignResource(
			 Map<String, Object> dataMap) {
		return facilityManagementDataService.saveAssignResource(dataMap);
	}
	
	public Map<String, Object> getPendingServiceRequestList(
			 Map<String, Object> dataMap) {
		return facilityManagementDataService.getPendingServiceRequestList(dataMap);
	}
	public Map<String, Object> getInspectionDetails(
			 Map<String, Object> dataMap) {
		return facilityManagementDataService.getInspectionDetails(dataMap);
	}
	public Map<String, Object> submitInspectionReport(
			 Map<String, Object> dataMap) {
		return facilityManagementDataService.submitInspectionReport(dataMap);
	}
	
	public Map<String, Object> getPreventiveMaintenanceList(
			 Map<String, Object> dataMap) {
		return facilityManagementDataService.getPreventiveMaintenanceList(dataMap);
	}
	
	public Map<String, Object> showAllPendingListOfInspctionJsp(
			 Map<String, Object> dataMap) {
		return facilityManagementDataService.showAllPendingListOfInspctionJsp(dataMap);
	}
	
}
