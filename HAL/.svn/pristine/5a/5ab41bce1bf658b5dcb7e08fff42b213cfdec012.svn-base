package jkt.hms.complaint.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.complaint.dataservice.ComplaintDataService;
import jkt.hms.masters.business.ComplaintRegister;
import jkt.hms.masters.business.MasComplaintRegister;

public class ComplaintHandlerServiceImpl implements ComplaintHandlerService {
	ComplaintDataService complaintDataService = null;

	public Map addComplaintType(Map<String, Object> dataMap) {
		return complaintDataService.addComplaintType(dataMap);
	}

	public boolean deleteComplaintType(int complaintId,
			Map<String, Object> generalMap) {
		return complaintDataService
				.deleteComplaintType(complaintId, generalMap);
	}

	public boolean editComplaintTypeToDatabase(Map<String, Object> generalMap) {
		return complaintDataService.editComplaintTypeToDatabase(generalMap);
	}

	public Map<String, Object> searchComplaintType(String complaintTypeCode,
			String complaintTypeName) {
		return complaintDataService.searchComplaintType(complaintTypeCode,
				complaintTypeName);
	}

	public Map<String, Object> showComplaintTypeJsp() {
		return complaintDataService.showComplaintTypeJsp();
	}

	public ComplaintDataService getComplaintDataService() {
		return complaintDataService;
	}

	public void setComplaintDataService(
			ComplaintDataService complaintDataService) {
		this.complaintDataService = complaintDataService;
	}

	public Map<String, Object> showComplaintRegisterJsp(int empId) {
		return complaintDataService.showComplaintRegisterJsp(empId);
	}

	public Map<String, Object> searchComplaintRegister(String complaintNo,
			String complaintDesc, int empId) {
		return complaintDataService.searchComplaintRegister(complaintNo,
				complaintDesc, empId);
	}

	public boolean addComplaintRegister(
			MasComplaintRegister masComplaintRegister,
			List<ComplaintRegister> complaintRegister) {
		return complaintDataService.addComplaintRegister(masComplaintRegister,
				complaintRegister);
	}

	public String generateComplaintNo(Map<String, Object> infoMap) {
		return complaintDataService.generateComplaintNo(infoMap);
	}

	public Map<String, Object> showWorkCompletionJsp() {
		return complaintDataService.showWorkCompletionJsp();
	}

	public Map<String, Object> searchWorkCompletion(String complaintNo,
			String complaintDesc, String pdcOver, int deptId, int complaintType) {
		return complaintDataService.searchWorkCompletion(complaintNo,
				complaintDesc, pdcOver, deptId, complaintType);
	}

	public boolean addWorkCompletion(MasComplaintRegister MasComplaintRegister,
			Map<String, Object> generalMap) {
		return complaintDataService.addWorkCompletion(MasComplaintRegister,
				generalMap);
	}

	public Map<String, Object> getRecordsForWorkCompletion(
			Map<String, Object> map) {
		return complaintDataService.getRecordsForWorkCompletion(map);
	}

	public Map<String, Object> getConnectionForReport() {
		return complaintDataService.getConnectionForReport();
	}

	public Map<String, Object> showWorkNotCompletionJsp() {
		return complaintDataService.showWorkNotCompletionJsp();
	}

	public Map<String, Object> searchWorkNotCompletion(String complaintNo,
			String complaintDesc) {
		return complaintDataService.searchWorkNotCompletion(complaintNo,
				complaintDesc);
	}

	public Map<String, Object> showComplaintRegister(int empId) {
		return complaintDataService.showComplaintRegisterJsp(empId);
	}

	public Map<String, Object> showWorkCompletionRegister() {
		return complaintDataService.showWorkCompletionRegister();
	}

	public boolean addMasComplaintRegister(
			MasComplaintRegister MasComplaintRegister) {
		return complaintDataService
				.addMasComplaintRegister(MasComplaintRegister);
	}

	public boolean addCommandantRemark(MasComplaintRegister MasComplaintRegister) {
		return complaintDataService.addCommandantRemark(MasComplaintRegister);
	}

	public Map<String, Object> getRecordsForWorkNotCompletion(
			Map<String, Object> map) {
		return complaintDataService.getRecordsForWorkNotCompletion(map);
	}

	public Map<String, Object> fillItemsForComplaintNo(
			Map<String, Object> dataMap) {

		return complaintDataService.fillItemsForComplaintNo(dataMap);
	}

}
