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
import jkt.hms.masters.dataservice.SystemRelatedMasterDataService;

public class SystemRelatedMasterHandlerServiceImpl implements
		SystemRelatedMasterHandlerService {
	SystemRelatedMasterDataService systemRelatedMasterDataService = null;

	// ---------------------------------- Department Type
	// ------------------------------------

	public boolean addDepartmentType(MasDepartmentType masDepartmentType) {
		return systemRelatedMasterDataService
				.addDepartmentType(masDepartmentType);
	}

	public Map<String, Object> showDepartmentTypeJsp() {
		return systemRelatedMasterDataService.showDepartmentTypeJsp();
	}

	public Map<String, Object> searchDepartmentType(String departmentTypeCode,
			String departmentTypeName) {
		return systemRelatedMasterDataService.searchDepartmentType(
				departmentTypeCode, departmentTypeName);
	}

	public boolean editDepartmentTypeToDatabase(Map<String, Object> generalMap) {
		return systemRelatedMasterDataService
				.editDepartmentTypeToDatabase(generalMap);
	}

	public boolean deleteDepartmentType(int departmentTypeId,
			Map<String, Object> generalMap) {
		return systemRelatedMasterDataService.deleteDepartmentType(
				departmentTypeId, generalMap);
	}

	// -----------------------------------------------Transaction Type
	// -----------------------------

	public boolean addTransactionType(MasTransactionType masTransactionType) {
		return systemRelatedMasterDataService
				.addTransactionType(masTransactionType);
	}

	public Map<String, Object> searchTransactionType(
			String transactionTypeCode, String transactionTypeName) {
		return systemRelatedMasterDataService.searchTransactionType(
				transactionTypeCode, transactionTypeName);
	}

	public Map<String, Object> showTransactionTypeJsp() {
		return systemRelatedMasterDataService.showTransactionTypeJsp();
	}

	public boolean editTransactionTypeToDatabase(Map<String, Object> generalMap) {
		return systemRelatedMasterDataService
				.editTransactionTypeToDatabase(generalMap);
	}

	public boolean deleteTransactionType(int transactionTypeId,
			Map<String, Object> generalMap) {
		return systemRelatedMasterDataService.deleteTransactionType(
				transactionTypeId, generalMap);
	}

	// --------------------------------------------Frequency--------------------------------------

	public boolean addFrequency(MasFrequency masFrequency) {
		return systemRelatedMasterDataService.addFrequency(masFrequency);
	}

	public boolean deleteFrequency(int frequencyId,
			Map<String, Object> generalMap) {
		return systemRelatedMasterDataService.deleteFrequency(frequencyId,
				generalMap);
	}

	public boolean editFrequencyToDatabase(Map<String, Object> generalMap) {
		return systemRelatedMasterDataService
				.editFrequencyToDatabase(generalMap);
	}

	public Map<String, Object> searchFrequency(String frequencyCode,
			String frequencyName) {
		return systemRelatedMasterDataService.searchFrequency(frequencyCode,
				frequencyName);
	}

	public Map<String, Object> showFrequencyJsp() {
		return systemRelatedMasterDataService.showFrequencyJsp();
	}

	// ---------------------------------Department
	// Master----------------------------------------------

	public boolean addDepartment(MasDepartment masDepartment) {
		return systemRelatedMasterDataService.addDepartment(masDepartment);
	}

	public boolean deleteDepartment(int departmentId,
			Map<String, Object> generalMap) {
		return systemRelatedMasterDataService.deleteDepartment(departmentId,
				generalMap);
	}

	public boolean editDepartmentToDatabase(Map<String, Object> generalMap) {
		return systemRelatedMasterDataService
				.editDepartmentToDatabase(generalMap);
	}

	public Map<String, Object> searchDepartment(String departmentCode,
			String departmentName,int divisionIdSearch) {
		return systemRelatedMasterDataService.searchDepartment(departmentCode,
				departmentName,divisionIdSearch);
	}

	public Map<String, Object> showDepartmentJsp() {
		return systemRelatedMasterDataService.showDepartmentJsp();
	}

	// ---------------------------------Designation
	// Master----------------------------------------------

	public boolean addDesignation(MasDesignation masDesignation) {
		// TODO Auto-generated method stub
		return systemRelatedMasterDataService.addDesignation(masDesignation);
	}

	public Map<String, Object> showDesignationJsp() {
		// TODO Auto-generated method stub
		return systemRelatedMasterDataService.showDesignationJsp();
	}

	public Map<String, Object> searchDesignation(String designationCode,
			String designation) {
		// TODO Auto-generated method stub
		return systemRelatedMasterDataService.searchDesignation(
				designationCode, designation);
	}

	public boolean deleteDesignation(int designationId,
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return systemRelatedMasterDataService.deleteDesignation(designationId,
				generalMap);
	}

	public boolean editDesignation(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return systemRelatedMasterDataService.editDesignation(generalMap);
	}

	// -----------------------Group Master-----------------------

	public Map<String, Object> showGroupMaster() {
		// TODO Auto-generated method stub
		return systemRelatedMasterDataService.showGroupMaster();
	}

	public boolean addGroupMaster(GroupMaster groupMaster) {
		// TODO Auto-generated method stub
		return systemRelatedMasterDataService.addGroupMaster(groupMaster);
	}

	public Map<String, Object> searchGroupMaster(String groupCode,
			String groupName) {
		// TODO Auto-generated method stub
		return systemRelatedMasterDataService.searchGroupMaster(groupCode,
				groupName);
	}

	public boolean deleteGroupMaster(int groupId, Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return systemRelatedMasterDataService.deleteGroupMaster(groupId,
				generalMap);
	}

	public boolean editGroupMaster(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return systemRelatedMasterDataService.editGroupMaster(generalMap);
	}

	// ---------------------------------Commutation Weightage
	// Master---------------------

	public Map<String, Object> showCommutationWeightageMasterJsp() {
		// TODO Auto-generated method stub
		return systemRelatedMasterDataService
				.showCommutationWeightageMasterJsp();
	}

	public boolean addCommutationWeightageMaster(
			CommutationWeightage commutationWeightage) {
		// TODO Auto-generated method stub
		return systemRelatedMasterDataService
				.addCommutationWeightageMaster(commutationWeightage);
	}

	public Map<String, Object> searchCommutationWeightageMaster(
			String weightageCode, int age) {
		// TODO Auto-generated method stub
		return systemRelatedMasterDataService.searchCommutationWeightageMaster(
				weightageCode, age);
	}

	public boolean deleteCommutationWeightage(int commutationId,
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return systemRelatedMasterDataService.deleteCommutationWeightage(
				commutationId, generalMap);
	}

	public boolean editCommutationWeightage(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return systemRelatedMasterDataService
				.editCommutationWeightage(generalMap);
	}

	// ------------------------------------------------------------

	public SystemRelatedMasterDataService getSystemRelatedMasterDataService() {
		return systemRelatedMasterDataService;
	}

	public void setSystemRelatedMasterDataService(
			SystemRelatedMasterDataService systemRelatedMasterDataService) {
		this.systemRelatedMasterDataService = systemRelatedMasterDataService;
	}

	@Override
	public boolean addTransactionSequence(
			TransactionSequence transactionSequence) {
		return systemRelatedMasterDataService.addTransactionSequence(transactionSequence);
	}

	@Override
	public boolean editTransactionSequence(Map<String, Object> generalMap) {
		return systemRelatedMasterDataService.editTransactionSequence(generalMap);
	}

	@Override
	public Map<String, Object> existingMasters(Map<String, Object> generalMap) {
		return systemRelatedMasterDataService.existingMasters(generalMap);
	}

	@Override
	public Map<String, Object> showTransactionSequenceJsp() {
		return systemRelatedMasterDataService.showTransactionSequenceJsp();
	}
	
	//---------------------Leave Master-----------------------------	
		public Map<String, Object> showLeaveJsp() {
			return systemRelatedMasterDataService.showLeaveJsp();
		}
		public Map<String, Object> addLeave(HrMasLeave hrMasLeave) {
			return systemRelatedMasterDataService.addLeave(hrMasLeave);
		}
		public Map<String, Object> editLeave(Map<String, Object> generalMap) {
			return systemRelatedMasterDataService.editLeave(generalMap);
		}
		public Map<String, Object> searchLeave(String desription) {
			return systemRelatedMasterDataService.searchLeave(desription);
		}
		public Map<String, Object> deleteLeave(Map<String, Object> generalMap) {
			return systemRelatedMasterDataService.deleteLeave(generalMap);
		}
		public Map<String, Object> showHolidayMasterJsp() {
			
			return systemRelatedMasterDataService.showHolidayMasterJsp();
		}
		public Map<String, Object> addHolidayMaster(Holidaycalendar holidaycalendar) {
			
			return systemRelatedMasterDataService.addHolidayMaster(holidaycalendar);
		}
		public Map<String, Object> editHolidayMaster(Map<String, Object> generalMap) {
			
			return systemRelatedMasterDataService.editHolidayMaster(generalMap);
		}
		public Map<String, Object> deleteHolidayMaster(Map<String, Object> generalMap) {
			
			return systemRelatedMasterDataService.deleteHolidayMaster(generalMap) ;
		}
		public Map<String, Object> searchHolidayMaster(String name, String year) {
			
			return systemRelatedMasterDataService.searchHolidayMaster(name, year);
		}
		
		@Override
		public Map<String, Object> showReligionJsp() {
			return systemRelatedMasterDataService.showReligionJsp();
		}
		
		
		//*************************** Start of Course Master By Atul **************************************************************//	
			public Map<String, Object> showCourseMasterJsp() {
				return systemRelatedMasterDataService.showCourseMasterJsp();
			}
			public Map<String, Object> searchCourseMaster(String courseCode, String courseName){
				return systemRelatedMasterDataService.searchCourseMaster(courseCode, courseName);				
			}
			public boolean addCourseMaster(HrMasCourse hrMasCourse) {
				return systemRelatedMasterDataService.addCourseMaster(hrMasCourse);
			}
			public boolean editCourseMaster(Map<String, Object> map) {
				return systemRelatedMasterDataService.editCourseMaster(map);
			}
			public boolean deleteCourseMaster(int courseId,Map<String, Object> generalMap) {
				return systemRelatedMasterDataService.deleteCourseMaster(courseId,generalMap);
			}
			
			public Map checkForExistingMasters(Map<String, Object> generalMap) {
				return systemRelatedMasterDataService.checkForExistingMasters(generalMap);
			}
			//*************************** End of Course Master **************************************************************//	

			
			//*************************** Start of Qualification Master By Atul **************************************************************//
			
			public Map<String, Object> showQualificationMasterJsp(){
				return systemRelatedMasterDataService.showQualificationMasterJsp();
			}
			public boolean addQualificationMaster(HrMasQualification hrMasQualification) {
				return systemRelatedMasterDataService.addQualificationMaster(hrMasQualification);
			}
			public Map<String, Object> searchQualificationMaster(String qualificationCode, String qualificationName) {
				return systemRelatedMasterDataService.searchQualificationMaster(qualificationCode, qualificationName);
			}
			public boolean editQualificationMaster(Map<String, Object> generalMap) {
				return systemRelatedMasterDataService.editQualificationMaster(generalMap);
			}
			public boolean deleteQualificationMaster(int qualificationId,Map<String, Object> generalMap) {
				return systemRelatedMasterDataService.deleteQualificationMaster(qualificationId, generalMap);
			}
			
			//*************************** End of Qualification Master **************************************************************//	

			

			//****************************************** Start Of Institute Master by Atul ****************************//
			public Map<String, Object> showInstituteMasterJsp() {
				return systemRelatedMasterDataService.showInstituteMasterJsp();
			}
			public boolean addInstituteMaster(HrMasInstitute hrmasInstitute) {
				return systemRelatedMasterDataService.addInstituteMaster(hrmasInstitute);
			}
			public Map<String, Object> searchInstituteMaster(String instituteCode, String instituteName){
				return systemRelatedMasterDataService.searchInstituteMaster(instituteCode, instituteName);
			}
			public boolean editInstituteMaster(Map<String, Object> generalMap) {
				return systemRelatedMasterDataService.editInstituteMaster(generalMap);
			}
			public boolean deleteInstituteMaster(int instituteId,Map<String, Object> generalMap) {
				return systemRelatedMasterDataService.deleteInstituteMaster(instituteId, generalMap);
			}
			

}
