package jkt.hms.masters.handler;

import java.util.Map;

import jkt.hms.masters.business.CommutationWeightage;
import jkt.hms.masters.business.GroupMaster;
import jkt.hms.masters.business.Holidaycalendar;
import jkt.hms.masters.business.HrMasCourse;
import jkt.hms.masters.business.HrMasInstitute;
import jkt.hms.masters.business.HrMasLeave;
import jkt.hms.masters.business.HrMasQualification;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDepartmentType;
import jkt.hms.masters.business.MasDesignation;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.MasTransactionType;
import jkt.hms.masters.business.TransactionSequence;

public interface SystemRelatedMasterHandlerService {
	// ---------------------------------------------- Department Type
	// ----------------------------------

	boolean addDepartmentType(MasDepartmentType departmentTypeMaster);

	Map<String, Object> searchDepartmentType(String departmentTypeCode,
			String departmentTypeName);

	Map<String, Object> showDepartmentTypeJsp();

	boolean editDepartmentTypeToDatabase(Map<String, Object> generalMap);

	boolean deleteDepartmentType(int departmentTypeId,
			Map<String, Object> generalMap);

	// ---------------------------------------------- Transaction Type
	// --------------------------------------

	boolean addTransactionType(MasTransactionType transactionTypeMaster);

	Map<String, Object> searchTransactionType(String transactionTypeCode,
			String transactionTypeName);

	Map<String, Object> showTransactionTypeJsp();

	boolean editTransactionTypeToDatabase(Map<String, Object> generalMap);

	boolean deleteTransactionType(int transactionTypeId,
			Map<String, Object> generalMap);

	// ----------------------------------------- Frequency
	// ---------------------------------------------

	boolean addFrequency(MasFrequency frequencyMaster);

	Map<String, Object> showFrequencyJsp();

	Map<String, Object> searchFrequency(String frequencyCode,
			String frequencyName);

	boolean editFrequencyToDatabase(Map<String, Object> generalMap);

	boolean deleteFrequency(int frequencyId, Map<String, Object> generalMap);

	// ---------------------------------Department Master----------------

	Map<String, Object> showDepartmentJsp();

	Map<String, Object> searchDepartment(String departmentCode,
			String departmentName, int divisionIdSearch);

	boolean addDepartment(MasDepartment masDepartment);

	boolean editDepartmentToDatabase(Map<String, Object> generalMap);

	boolean deleteDepartment(int departmentId, Map<String, Object> generalMap);

	// -------------------------------Designation
	// Master-------------------------
	Map<String, Object> showDesignationJsp();

	boolean addDesignation(MasDesignation masDesignation);

	Map<String, Object> searchDesignation(String designationCode,
			String designation);

	boolean deleteDesignation(int designationId, Map<String, Object> generalMap);

	boolean editDesignation(Map<String, Object> generalMap);

	// -------------------Group Master----------------------------------

	Map<String, Object> showGroupMaster();

	boolean addGroupMaster(GroupMaster groupMaster);

	Map<String, Object> searchGroupMaster(String groupCode, String groupName);

	boolean deleteGroupMaster(int groupId, Map<String, Object> generalMap);

	boolean editGroupMaster(Map<String, Object> generalMap);

	// /-----------------------Commutation weightage master------------------

	Map<String, Object> showCommutationWeightageMasterJsp();

	boolean addCommutationWeightageMaster(
			CommutationWeightage commutationWeightage);

	Map<String, Object> searchCommutationWeightageMaster(String weightageCode,
			int age);

	boolean deleteCommutationWeightage(int commutationId,
			Map<String, Object> generalMap);

	boolean editCommutationWeightage(Map<String, Object> generalMap);

	
	//----------------------- Transaction Sequence Master By Mansi 
	Map<String, Object> showTransactionSequenceJsp();

	Map<String, Object> existingMasters(Map<String, Object> generalMap);

	boolean addTransactionSequence(TransactionSequence transactionSequence);

	boolean editTransactionSequence(Map<String, Object> generalMap);
	
	//--------------Leave Master-----------------------------------	
		Map<String, Object> showLeaveJsp();

		 Map<String, Object> addLeave(HrMasLeave hrMasLeave);

		Map<String, Object> editLeave(Map<String, Object> generalMap);

		Map<String, Object> deleteLeave(Map<String, Object> generalMap);

		Map<String, Object> searchLeave(String desription);

		Map<String, Object> showHolidayMasterJsp();

		 Map<String, Object> addHolidayMaster(Holidaycalendar holidaycalendar);

		Map<String, Object> editHolidayMaster(Map<String, Object> generalMap);

		Map<String, Object> deleteHolidayMaster(Map<String, Object> generalMap);

		Map<String, Object> searchHolidayMaster(String name, String year);

		Map<String, Object> showReligionJsp();

		Map showCourseMasterJsp();

		Map<String, Object> searchCourseMaster(String courseCode,
				String courseName);

		Map<String, Object> checkForExistingMasters(
				Map<String, Object> generalMap);

		boolean addCourseMaster(HrMasCourse hrMasCourse);

		boolean deleteCourseMaster(int courseId, Map<String, Object> generalMap);

		boolean editCourseMaster(Map<String, Object> generalMap);
		
		//****************************************** Start Of Qualification Master by Atul ****************************//
		Map<String, Object> showQualificationMasterJsp();
	    boolean addQualificationMaster(HrMasQualification hrMasQualification);
	    Map<String, Object> searchQualificationMaster(String qualificationCode, String qualificationName);
	    boolean editQualificationMaster(Map<String, Object> generalMap);
	    boolean deleteQualificationMaster(int qualificationId, Map<String, Object> generalMap);
	    //****************************************** End Of Qualification Master by Atul ****************************//
	    

		//****************************************** Start Of Institute Master by Atul ****************************//
		
		Map<String, Object> showInstituteMasterJsp();
		boolean addInstituteMaster(HrMasInstitute hrmasInstitute);
		Map<String, Object> searchInstituteMaster(String instituteCode, String instituteName);
		boolean editInstituteMaster(Map<String, Object> generalMap);
		boolean deleteInstituteMaster(int instituteId, Map<String, Object> generalMap);
		

}
