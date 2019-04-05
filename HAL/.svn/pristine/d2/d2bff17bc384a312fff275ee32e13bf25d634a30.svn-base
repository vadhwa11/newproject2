package jkt.hms.complaint.dataservice;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.ComplaintRegister;
import jkt.hms.masters.business.MasComplaintRegister;

public interface ComplaintDataService {
	// ///// Complaint Type//////////
	Map<String, Object> showComplaintTypeJsp();

	Map addComplaintType(Map<String, Object> dataMap);

	Map<String, Object> searchComplaintType(String complaintTypeCode,
			String complaintTypeName);

	boolean editComplaintTypeToDatabase(Map<String, Object> generalMap);

	boolean deleteComplaintType(int complaintId, Map<String, Object> generalMap);

	// ///// Complaint Register//////////
	Map<String, Object> showComplaintRegisterJsp(int empId);

	public String generateComplaintNo(Map<String, Object> infoMap);

	Map<String, Object> searchComplaintRegister(String complaintNo,
			String complaintDesc, int empId);

	boolean addComplaintRegister(MasComplaintRegister masComplaintRegister,
			List<ComplaintRegister> complaintRegister);

	// ///// Work Completion //////////
	Map<String, Object> showWorkCompletionJsp();

	boolean addWorkCompletion(MasComplaintRegister MasComplaintRegister,
			Map<String, Object> generalMap);

	public Map<String, Object> getRecordsForWorkCompletion(
			Map<String, Object> map);

	Map<String, Object> searchWorkCompletion(String complaintNo,
			String complaintDesc, String pdcOver, int deptId, int complaintType);

	// Connection Method for Report//

	public Map<String, Object> getConnectionForReport();

	// ///// Work Not Completion //////////
	Map<String, Object> showWorkNotCompletionJsp();

	Map<String, Object> searchWorkNotCompletion(String complaintNo,
			String complaintDesc);

	public Map<String, Object> getRecordsForWorkNotCompletion(
			Map<String, Object> map);

	boolean addMasComplaintRegister(MasComplaintRegister MasComplaintRegister);

	boolean addCommandantRemark(MasComplaintRegister MasComplaintRegister);

	// // Report Generation Method
	Map<String, Object> showComplaintRegister();

	Map<String, Object> showWorkCompletionRegister();

	public Map<String, Object> fillItemsForComplaintNo(
			Map<String, Object> dataMap);
}
