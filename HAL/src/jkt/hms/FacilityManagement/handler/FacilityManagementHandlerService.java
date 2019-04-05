package jkt.hms.FacilityManagement.handler;

import java.util.Map;

import jkt.hms.util.Box;

public interface FacilityManagementHandlerService {

	Map<String, Object> showPendingListForEnterEquipmentDetailJsp(Box box,Map<String, Object> dataMap);
	Map<String, Object> showEquipmentDetailJsp(Map<String, Object> dataMap);
	Map<String, Object> submitEquipmentDetails( Map<String, Object> dataMap);
	Map<String, Object> getEquipmentDetails(Map<String, Object> details);
	Map<String, Object> getEquipmentHistory(Map<String, Object> details);
	Map<String, Object>  equipmentDashBoard(Map<String, Object> details);
	Map<String, Object> saveServiceDetails(Map<String, Object> details);
	Map<String, Object> getPendingServiceRequest(Map<String, Object> details);
	Map<String, Object> getRequestDetails(Map<String, Object> details);

	Map<String, Object> saveServiceRequest(Map<String, Object> details);
	Map<String, Object> getPendingListOfInspection(Map<String, Object> details);
	Map<String, Object> showAllPendingListOfInspctionJsp(Map<String, Object> details);
	Map<String, Object> getAssignResource(Map<String, Object> details);
	Map<String, Object> getResourceList(Map<String, Object> details);
	Map<String, Object> saveAssignResource(Map<String, Object> details);
	Map<String, Object> getPendingServiceRequestList(Map<String, Object> details);
	Map<String, Object> getInspectionDetails(Map<String, Object> details);
	Map<String, Object> submitInspectionReport(Map<String, Object> details);
	Map<String, Object>  getPreventiveMaintenanceList(Map<String, Object> details);
	
}
