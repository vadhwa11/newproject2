package jkt.hms.masters.dataservice;

import java.util.Map;

import jkt.hms.masters.business.HrEmployeePayElements;
import jkt.hms.masters.business.HrEmployeePayStructure;
import jkt.hms.masters.business.MasCommand;
import jkt.hms.masters.business.MasEmpStatus;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDependent;
import jkt.hms.masters.business.MasFormation;
import jkt.hms.masters.business.MasMedicalCategory;
import jkt.hms.masters.business.MasOthersCategory;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRankCategory;
import jkt.hms.masters.business.MasRecordOfficeAddress;
import jkt.hms.masters.business.MasReferralDoctor;
import jkt.hms.masters.business.MasStation;
import jkt.hms.masters.business.MasStoreBrand;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.util.Box;

public interface PersonnelMasterDataService {
	// -------------------------------Employee
	// Dependent------------------------------------------
	boolean addEmployeeDependent(MasEmployeeDependent masEmployeeDependent,Map<String, Object> userMap);

	boolean editEmployeeDependent(Map<String, Object> generalMap);

	boolean deleteEmployeeDependent(int employeeDependentId,
			Map<String, Object> generalMap);

	Map<String, Object> generateEmployeeLogin(int employeeDependentId,
			Map<String, Object> generalMap);

	Map<String, Object> showEmployeeDependentJsp();

	Map<String, Object> searchEmployeeDependent(String employeeDependentCode,
			String employeeDpendantName);

	// ------------------------------- Emp Status
	// -----------------------------------

	boolean addEmpStatus(MasEmpStatus masEmpStatus);

	boolean deleteEmpStatus(int empStatusId, Map<String, Object> generalMap);

	boolean editEmpStatusToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchEmpStatus(String empStatusCode,
			String empStatusName);

	Map<String, Object> showEmpStatusJsp();

	// ------------------Referral Doctor -------------------

	boolean addReferralDoctor(MasReferralDoctor masReferralDoctor);

	boolean deleteReferralDoctor(int referralDoctorId,
			Map<String, Object> generalMap);

	boolean editReferralDoctorToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchReferralDoctor(String referralDoctorName);

	Map<String, Object> showReferralDoctorJsp();

	// -------------------------- Rank -------------------------------------
	boolean addRank(MasRank masRank);

	Map<String, Object> searchRank(String rankCode, String rankName);

	Map<String, Object> showRankJsp();

	boolean deleteRank(int rankId, Map<String, Object> generalMap);

	boolean editRankToDatabase(Map<String, Object> generalMap);

	// ---------------------------------
	// Formation-------------------------------------
	boolean addFormation(MasFormation masFormation);

	boolean deleteFormation(int formationId, Map<String, Object> generalMap);

	boolean editFormationToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchFormation(String formationCode,
			String formationName);

	Map<String, Object> showFormationJsp();

	// ------------------------------------------Trade-----------------------------------
	boolean addTrade(MasTrade masTrade);

	boolean deleteTrade(int tradeId, Map<String, Object> generalMap);

	boolean editTradeToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchTrade(String tradeName);

	Map<String, Object> showTradeJsp();

	// --------------------------------------Unit-------------------------------------
	boolean addUnit(MasUnit masUnit);

	boolean deleteUnit(int unitId, Map<String, Object> generalMap);

	boolean editUnitToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchUnit(String unitName);

	Map<String, Object> showUnitJsp();

	// ------------------------- Employee ----------------------------------
	Map<String, Object> showEmployeeJsp(int hospitalId);

	Map<String, Object> searchEmployee(String employeeCode, String firstName,
			String lastName,int hospitalId);

	boolean addEmployee(MasEmployee masEmployee,Map<String, Object> userMap);

	boolean editEmployeeToDatabase(Map<String, Object> generalMap);

	boolean deleteEmployee(int employeeId, Map<String, Object> generalMap);

	// ------------------------------------------Record Office Address
	// -------------------------------

	boolean addRecordOfficeAddress(MasRecordOfficeAddress masRecordOfficeAddress);

	boolean deleteRecordOfficeAddress(int recordOfficeAddressId,
			Map<String, Object> generalMap);

	boolean editRecordOfficeAddress(Map<String, Object> generalMap);

	Map<String, Object> searchRecordOfficeAddress(String recordOfficeAddress);

	Map<String, Object> showRecordOfficeAddressJsp();

	// --------------------------------------Rank Category---------------------

	boolean addRankCategory(MasRankCategory masRankCategory);

	boolean deleteRankCategory(int rankCategoryId,
			Map<String, Object> generalMap);

	boolean editRankCategoryToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchRankCategory(String rankCategoryCode,
			String rankCategoryName);

	Map<String, Object> showRankCategoryJsp();

	// -----------------------------------Brand
	// Master--------------------------------
	boolean addBrand(MasStoreBrand masBrand);

	boolean deleteBrand(int brandId, Map<String, Object> generalMap);

	boolean editBrandToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchBrand(String brandCode, String brandName);

	Map<String, Object> showBrandJsp(Box box);

	Map<String, Object> getConnection();

	int getItemId(String pvms);
	boolean addMedicalCategory(MasMedicalCategory masMedicalCategory);

	Map<String, Object> showMedicalCategoryJsp();

	boolean editMedicalCategory(Map<String, Object> generalMap);

	boolean deleteMedicalCategory(int medicalCategoryId,
			Map<String, Object> generalMap);

	Map<String, Object> searchMedicalCategory(String medicalCategoryName);
	/**
	 * showEmployeeTemplate
	 * @author Mukesh Narayan Singh 
	 * @param mapDetails
	 * @return map
	 */
	Map<String, Object> showEmployeeTemplate(Map<String, Object> mapDetails);

	Map<String, Object> showEmpSMCTransferJsp(Map<String, Object> datamap);

	Map<String, Object> updateEmployeeSMC(Box box);
	
//	------------------------- Command Master By Mansi on 1st Aug 2013------------------------------------------------

	
	Map<String, Object> showCommandJsp();

	boolean deleteCommand(int commandId, Map<String, Object> generalMap);

	boolean editCommandToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchCommand(String commandCode, String commandName);

	boolean addCommand(MasCommand masCommand);
	
//	------------------------- Station Master By Mansi on 1st Aug 2013------------------------------------------------


	Map<String, Object> showStationJsp();

	boolean addStation(MasStation masStation);

	Map<String, Object> searchStation(String stationCode, String stationName);

	boolean editStationToDatabase(Map<String, Object> generalMap);

	boolean deleteStation(int stationId, Map<String, Object> generalMap);

	Map<String, Object> getDepartmentList(Map<String, Object> dataMap);
	
	Map<String, Object> getGradeList(Map<String, Object> dataMap);
	
	Map<String, Object> checkForExisting(Map<String, Object> generalMap);
	
	Map<String, Object> getLocalStateList(Map<String, Object> dataMap);

	Map<String, Object> getPerStateList(Map<String, Object> dataMap);

	Map<String, Object> getLocalDistrictList(Map<String, Object> dataMap);

	Map<String, Object> getPerDistrictList(Map<String, Object> dataMap);
	
	Map<String, Object> getDepartmentForDisplay(int employeeId);
	
	Map<String, Object> displayImage(int employeeId);
	
	Map<String, Object> getDeptDivisionNameList(Map<String, Object> dataMap);

	Map<String, Object> checkEmpPBNo(Map<String, Object> dataMap);
	
	Map<String, Object> displayImageEmployeeDependent(int employeeDependentId);
	
	Map<String, Object> showEmployeeDependentReport(int hospitalId);

	Map<String, Object> displayImageCommon(Box box);
	
	Map<String, Object> showOthersCategoryJsp();

	Map<String, Object> searchOthersCategory(String othersCategoryCode,
			String othersCategoryName);

	boolean editOthersCategoryToDatabase(Map<String, Object> generalMap);

	boolean deleteOthersCategory(int othersCategoryId,
			Map<String, Object> generalMap);
	boolean addOthersCategory(MasOthersCategory masOthersCategory);
	
	Map<String, Object> getDepartmentNoList(Map<String, Object> dataMap);

	Map<String, Object> fillEmployee(Map<String, Object> dataMap);
	
	Map<String, Object> getEmployeeList(Map<String, Object> dataMap);
	
	Map<String, Object> getBloodGroupId(String bloodGroupCode);

	Map<String, Object> ReadImage(Box box);

	Map<String, Object> showEmployeePayStructureJsp(Map<String, Object> dataMap);

	Map<String, Object> searchEmployeePayStructure(Map<String, Object> dataMap);

	HrEmployeePayStructure getEmployeePayStructure(Integer employeePayStructureId);

	void addEmployeePayStructure(HrEmployeePayStructure employeePayStructure);

	boolean deleteEmployeePayStructure(int employeePayStructureId,Map<String, Object> generalMap);

	Map<String, Object> showEmployeePayElementsJsp(Map<String, Object> dataMap);

	Map<String, Object> searchEmployeePayElement(Map<String, Object> dataMap);

	HrEmployeePayElements getEmployeePayElement(Integer commonId);

	Map addEmployeePayElement(HrEmployeePayElements employeePayElement);

	Map<String, Object> returnSingleEmployeePayElement(Integer employeeId);

	boolean deleteEmployeePayElement(int employeePayElementId,Map<String, Object> generalMap);

}