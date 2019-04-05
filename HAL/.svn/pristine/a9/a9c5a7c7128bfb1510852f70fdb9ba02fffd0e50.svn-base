package jkt.hms.masters.handler;

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
import jkt.hms.masters.dataservice.PersonnelMasterDataService;
import jkt.hms.util.Box;

public class PersonnelMasterHandlerServiceImpl implements
		PersonnelMasterHandlerService {
	PersonnelMasterDataService personnelMasterDataService = null;

	// ------------------------------ Emp Status-----------------

	public boolean addEmpStatus(MasEmpStatus masEmpStatus) {
		return personnelMasterDataService.addEmpStatus(masEmpStatus);
	}

	public boolean deleteEmpStatus(int empStatusId,
			Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteEmpStatus(empStatusId,
				generalMap);
	}

	public boolean editEmpStatusToDatabase(Map<String, Object> generalMap) {
		return personnelMasterDataService.editEmpStatusToDatabase(generalMap);
	}

	public Map<String, Object> searchEmpStatus(String empStatusCode,
			String empStatusName) {
		return personnelMasterDataService.searchEmpStatus(empStatusCode,
				empStatusName);
	}

	public Map<String, Object> showEmpStatusJsp() {
		return personnelMasterDataService.showEmpStatusJsp();
	}

	public Map<String, Object> generateEmployeeLogin(int empStatusId,
			Map<String, Object> generalMap) {
		return personnelMasterDataService.generateEmployeeLogin(empStatusId,
				generalMap);
	}

	// ------------------------------ Employee Dependent-----------------------

	public Map<String, Object> showEmployeeDependentJsp() {
		return personnelMasterDataService.showEmployeeDependentJsp();
	}

	public boolean addEmployeeDependent(
			MasEmployeeDependent masEmployeeDependent,Map<String, Object> userMap) {
		return personnelMasterDataService
				.addEmployeeDependent(masEmployeeDependent,userMap);
	}

	public boolean deleteEmployeeDependent(int employeeDependentId,
			Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteEmployeeDependent(
				employeeDependentId, generalMap);
	}

	public boolean editEmployeeDependent(Map<String, Object> generalMap) {
		return personnelMasterDataService.editEmployeeDependent(generalMap);
	}

	public Map<String, Object> searchEmployeeDependent(
			String employeeDependentCode, String employeeDependentName) {
		return personnelMasterDataService.searchEmployeeDependent(
				employeeDependentCode, employeeDependentName);
	}

	// --------------------------------ReferralDoctor---------------------------------------
	public boolean addReferralDoctor(MasReferralDoctor masReferralDoctor) {
		return personnelMasterDataService.addReferralDoctor(masReferralDoctor);
	}

	public boolean deleteReferralDoctor(int referralDoctorId,
			Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteReferralDoctor(
				referralDoctorId, generalMap);
	}

	public boolean editReferralDoctorToDatabase(Map<String, Object> generalMap) {
		return personnelMasterDataService
				.editReferralDoctorToDatabase(generalMap);
	}

	public Map<String, Object> searchReferralDoctor(String referralDoctorName) {
		return personnelMasterDataService
				.searchReferralDoctor(referralDoctorName);
	}

	public Map<String, Object> showReferralDoctorJsp() {
		return personnelMasterDataService.showReferralDoctorJsp();
	}

	// -------------------------------- Rank
	// --------------------------------------
	public boolean addRank(MasRank masRank) {
		return personnelMasterDataService.addRank(masRank);
	}

	public boolean deleteRank(int rankId, Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteRank(rankId, generalMap);
	}

	public boolean editRankToDatabase(Map<String, Object> generalMap) {
		return personnelMasterDataService.editRankToDatabase(generalMap);
	}

	public Map<String, Object> searchRank(String rankCode, String rankName) {
		return personnelMasterDataService.searchRank(rankCode, rankName);
	}

	public Map<String, Object> showRankJsp() {
		return personnelMasterDataService.showRankJsp();
	}

	// ---------------------------------Formation---------------------------------------

	public boolean addFormation(MasFormation masFormation) {
		return personnelMasterDataService.addFormation(masFormation);
	}

	public boolean deleteFormation(int formationId,
			Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteFormation(formationId,
				generalMap);
	}

	public boolean editFormationToDatabase(Map<String, Object> generalMap) {
		return personnelMasterDataService.editFormationToDatabase(generalMap);
	}

	public Map<String, Object> searchFormation(String formationCode,
			String formationName) {
		return personnelMasterDataService.searchFormation(formationCode,
				formationName);
	}

	public Map<String, Object> showFormationJsp() {
		return personnelMasterDataService.showFormationJsp();
	}

	// ---------------------------------Employee ---------------------------

	public boolean addEmployee(MasEmployee masEmployee,Map<String, Object> userMap) {
		return personnelMasterDataService.addEmployee(masEmployee,userMap);
	}

	public boolean deleteEmployee(int employeeId, Map<String, Object> generalMap) {
		return personnelMasterDataService
				.deleteEmployee(employeeId, generalMap);
	}

	public boolean editEmployeeToDatabase(Map<String, Object> generalMap) {
		return personnelMasterDataService.editEmployeeToDatabase(generalMap);
	}

	public Map<String, Object> showEmployeeJsp(int hospitalId) {
		return personnelMasterDataService.showEmployeeJsp(hospitalId);
	}

	public Map<String, Object> searchEmployee(String employeeCode,
			String firstName, String lastName,int hospitalId) {
		return personnelMasterDataService.searchEmployee(employeeCode,
				firstName, lastName,hospitalId);
	}

	// ---------------------------------------Trade--------------------------
	public boolean addTrade(MasTrade masTrade) {
		return personnelMasterDataService.addTrade(masTrade);
	}

	public boolean deleteTrade(int tradeId, Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteTrade(tradeId, generalMap);
	}

	public boolean editTradeToDatabase(Map<String, Object> generalMap) {
		return personnelMasterDataService.editTradeToDatabase(generalMap);
	}

	public Map<String, Object> searchTrade(String tradeName) {
		return personnelMasterDataService.searchTrade(tradeName);
	}

	public Map<String, Object> showTradeJsp() {
		return personnelMasterDataService.showTradeJsp();
	}

	// -----------------------------------------Unit-----------------------------------
	public boolean addUnit(MasUnit masUnit) {
		return personnelMasterDataService.addUnit(masUnit);
	}

	public boolean deleteUnit(int unitId, Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteUnit(unitId, generalMap);
	}

	public boolean editUnitToDatabase(Map<String, Object> generalMap) {
		return personnelMasterDataService.editUnitToDatabase(generalMap);
	}

	public Map<String, Object> searchUnit(String unitName) {
		return personnelMasterDataService.searchUnit(unitName);
	}

	public Map<String, Object> showUnitJsp() {
		return personnelMasterDataService.showUnitJsp();
	}

	// ------------------------------------------Record Office Address
	// -------------------------------
	public boolean addRecordOfficeAddress(
			MasRecordOfficeAddress masRecordOfficeAddress) {
		return personnelMasterDataService
				.addRecordOfficeAddress(masRecordOfficeAddress);
	}

	public boolean editRecordOfficeAddress(Map<String, Object> generalMap) {
		return personnelMasterDataService.editRecordOfficeAddress(generalMap);
	}

	public boolean deleteRecordOfficeAddress(int recordOfficeAddressId,
			Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteRecordOfficeAddress(
				recordOfficeAddressId, generalMap);
	}

	public Map<String, Object> searchRecordOfficeAddress(
			String recordOfficeAddress) {
		return personnelMasterDataService
				.searchRecordOfficeAddress(recordOfficeAddress);
	}

	public Map<String, Object> showRecordOfficeAddressJsp() {
		return personnelMasterDataService.showRecordOfficeAddressJsp();
	}

	// -----------------------------Rank
	// Category----------------------------------------
	public boolean addRankCategory(MasRankCategory masRankCategory) {
		return personnelMasterDataService.addRankCategory(masRankCategory);
	}

	public boolean deleteRankCategory(int rankCategoryId,
			Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteRankCategory(rankCategoryId,
				generalMap);
	}

	public boolean editRankCategoryToDatabase(Map<String, Object> generalMap) {
		return personnelMasterDataService
				.editRankCategoryToDatabase(generalMap);
	}

	public Map<String, Object> searchRankCategory(String rankCategoryCode,
			String rankCategoryName) {
		return personnelMasterDataService.searchRankCategory(rankCategoryCode,
				rankCategoryName);
	}

	public Map<String, Object> showRankCategoryJsp() {
		return personnelMasterDataService.showRankCategoryJsp();
	}

	// -----------------------------Brand
	// Master-------------------------------------

	public boolean addBrand(MasStoreBrand masBrand) {
		return personnelMasterDataService.addBrand(masBrand);
	}

	public boolean deleteBrand(int brandId, Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteBrand(brandId, generalMap);
	}

	public boolean editBrandToDatabase(Map<String, Object> generalMap) {
		return personnelMasterDataService.editBrandToDatabase(generalMap);
	}

	public Map<String, Object> searchBrand(String brandCode, String brandName) {
		return personnelMasterDataService.searchBrand(brandCode, brandName);
	}

	public Map<String, Object> showBrandJsp(Box box) {
		return personnelMasterDataService.showBrandJsp(box);
	}

	public Map<String, Object> getConnection() {
		return personnelMasterDataService.getConnection();
	}

	// ---------------------------------------------------------------------------------------
	public PersonnelMasterDataService getPersonnelMasterDataService() {
		return personnelMasterDataService;
	}

	public void setPersonnelMasterDataService(
			PersonnelMasterDataService personnelMasterDataService) {
		this.personnelMasterDataService = personnelMasterDataService;
	}

	public int getItemId(String pvms) {
		return personnelMasterDataService.getItemId(pvms);
	}
	public Map<String, Object> showMedicalCategoryJsp() {
		
		return personnelMasterDataService.showMedicalCategoryJsp();
	}
	public boolean addMedicalCategory(MasMedicalCategory masMedicalCategory) {
		
		return personnelMasterDataService.addMedicalCategory(masMedicalCategory);
	}

	public boolean editMedicalCategory(Map<String, Object> generalMap) {
		
		return personnelMasterDataService.editMedicalCategory(generalMap);
	}

	public boolean deleteMedicalCategory(int medicalCategoryId,Map<String, Object> generalMap) {
		
		return personnelMasterDataService.deleteMedicalCategory(medicalCategoryId,generalMap);
	}

	public Map<String, Object> searchMedicalCategory(String medicalCategoryName) {
		
		return personnelMasterDataService.searchMedicalCategory(medicalCategoryName);
	}

	@Override
	public Map<String, Object> showEmployeeTemplate(
			Map<String, Object> mapDetails) {
		return personnelMasterDataService.showEmployeeTemplate(mapDetails);
	}

	@Override
	public Map<String, Object> showEmpSMCTransferJsp(Map<String, Object> datamap) {
		return personnelMasterDataService.showEmpSMCTransferJsp(datamap);
	}

	@Override
	public Map<String, Object> updateEmployeeSMC(Box box) {
		return personnelMasterDataService.updateEmployeeSMC(box) ;
	}
	
//	------------------------- Command Master By Mansi on 1st Aug 2013------------------------------------------------

	@Override
	public boolean addCommand(MasCommand masCommand) {
		return personnelMasterDataService.addCommand(masCommand);
	}

	@Override
	public boolean deleteCommand(int commandId, Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteCommand(commandId, generalMap);
	}

	@Override
	public boolean editCommandToDatabase(Map<String, Object> generalMap) {
		return personnelMasterDataService.editCommandToDatabase(generalMap);
	}

	@Override
	public Map<String, Object> searchCommand(String commandCode,
			String commandName) {
		return personnelMasterDataService.searchCommand(commandCode, commandName);
	}

	@Override
	public Map<String, Object> showCommandJsp() {
		return personnelMasterDataService.showCommandJsp();
	}

	
//	------------------------- Station Master By Mansi on 1st Aug 2013------------------------------------------------

	
	@Override
	public boolean addStation(MasStation masStation) {
		return personnelMasterDataService.addStation(masStation);	}

	@Override
	public boolean deleteStation(int stationId, Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteStation(stationId, generalMap);	}

	@Override
	public boolean editStationToDatabase(Map<String, Object> generalMap) {
		return personnelMasterDataService.editStationToDatabase(generalMap);	}

	@Override
	public Map<String, Object> searchStation(String stationCode,
			String stationName) {
		return personnelMasterDataService.searchStation(stationCode, stationName);	}

	@Override
	public Map<String, Object> showStationJsp() {
		return personnelMasterDataService.showStationJsp();	}

	@Override
	public Map<String, Object> getDepartmentList(Map<String, Object> dataMap) {
		return personnelMasterDataService.getDepartmentList(dataMap);
	}


	@Override
	public Map<String, Object> getGradeList(Map<String, Object> dataMap) {
		return personnelMasterDataService.getGradeList(dataMap);
	}

	@Override
	public Map<String, Object> checkForExisting(Map<String, Object> generalMap) {
		return personnelMasterDataService.checkForExisting(generalMap);
	}

	@Override
	public Map<String, Object> getLocalStateList(Map<String, Object> dataMap) {
		return personnelMasterDataService.getLocalStateList(dataMap);
	}

	@Override
	public Map<String, Object> getPerStateList(Map<String, Object> dataMap) {
		return personnelMasterDataService.getPerStateList(dataMap);
	}

	@Override
	public Map<String, Object> getLocalDistrictList(Map<String, Object> dataMap) {
		return personnelMasterDataService.getLocalDistrictList(dataMap);
	}

	@Override
	public Map<String, Object> getPerDistrictList(Map<String, Object> dataMap) {
		return personnelMasterDataService.getPerDistrictList(dataMap);
	}

	@Override
	public Map<String, Object> getDepartmentForDisplay(int employeeId) {
		return personnelMasterDataService.getDepartmentForDisplay(employeeId);
	}

	@Override
	public Map<String, Object> displayImage(int employeeId) {
		return personnelMasterDataService.displayImage(employeeId);
	}

	@Override
	public Map<String, Object> getDeptDivisionNameList(
			Map<String, Object> dataMap) {
		return personnelMasterDataService.getDeptDivisionNameList(dataMap);
	}

	@Override
	public Map<String, Object> checkEmpPBNo(Map<String, Object> dataMap) {
		return personnelMasterDataService.checkEmpPBNo(dataMap);
	}

	@Override
	public Map<String, Object> displayImageEmployeeDependent(
			int employeeDependentId) {
		return personnelMasterDataService.displayImageEmployeeDependent(employeeDependentId);
	}
	
	@Override
	public Map<String, Object> displayImageCommon(Box box) {
		return personnelMasterDataService.displayImageCommon(box) ;
	}

	@Override
	public Map<String, Object> showEmployeeDependentReport(int hospitalId) {
		return personnelMasterDataService.showEmployeeDependentReport(hospitalId);
	}

	@Override
	public Map<String, Object> showOthersCategoryJsp() {
		return personnelMasterDataService.showOthersCategoryJsp();
	}

	@Override
	public Map<String, Object> searchOthersCategory(String othersCategoryCode,
			String othersCategoryName) {
		return personnelMasterDataService.searchOthersCategory(othersCategoryCode, othersCategoryName);
	}

	@Override
	public boolean editOthersCategoryToDatabase(Map<String, Object> generalMap) {
		return personnelMasterDataService.editOthersCategoryToDatabase(generalMap);
	}

	@Override
	public boolean deleteOthersCategory(int othersCategoryId,
			Map<String, Object> generalMap) {
		return personnelMasterDataService.deleteOthersCategory(othersCategoryId, generalMap);
	}

	@Override
	public boolean addOthersCategory(MasOthersCategory masOthersCategory) {
		return personnelMasterDataService.addOthersCategory(masOthersCategory);
	}

	@Override
	public Map<String, Object> getDepartmentNoList(Map<String, Object> dataMap) {
		return personnelMasterDataService.getDepartmentNoList(dataMap);
	}

	@Override
	public Map<String, Object> fillEmployee(Map<String, Object> dataMap) {
		return personnelMasterDataService.fillEmployee(dataMap);
	}

	@Override
	public Map<String, Object> getEmployeeList(Map<String, Object> dataMap) {
		return personnelMasterDataService.getEmployeeList(dataMap);
	}

	@Override
	public Map<String, Object> getBloodGroupId(String bloodGroupCode) {
		return personnelMasterDataService.getBloodGroupId(bloodGroupCode);
	}

	@Override
	public Map<String, Object> ReadImage(Box box) {
		return personnelMasterDataService.ReadImage(box);
		
	}

	@Override
	public Map<String, Object> showEmployeePayStructureJsp(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return personnelMasterDataService.showEmployeePayStructureJsp(dataMap);
	}

	@Override
	public Map<String, Object> searchEmployeePayStructure(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return personnelMasterDataService.searchEmployeePayStructure(dataMap);
	}

	@Override
	public HrEmployeePayStructure getEmployeePayStructure(
			Integer employeePayStructureId) {
		// TODO Auto-generated method stub
		return personnelMasterDataService.getEmployeePayStructure(employeePayStructureId);
	}

	@Override
	public void addEmployeePayStructure(
			HrEmployeePayStructure employeePayStructure) {
		// TODO Auto-generated method stub
		personnelMasterDataService.addEmployeePayStructure(employeePayStructure);
	}

	@Override
	public boolean deleteEmployeePayStructure(int employeePayStructureId,
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return personnelMasterDataService.deleteEmployeePayStructure(employeePayStructureId, generalMap);
	}

	@Override
	public Map<String, Object> showEmployeePayElementsJsp(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return personnelMasterDataService.showEmployeePayElementsJsp(dataMap);
	}

	@Override
	public Map<String, Object> searchEmployeePayElement(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return personnelMasterDataService.searchEmployeePayElement(dataMap);
	}

	@Override
	public HrEmployeePayElements getEmployeePayElement(Integer commonId) {
		// TODO Auto-generated method stub
		return personnelMasterDataService.getEmployeePayElement(commonId);
	}

	@Override
	public Map addEmployeePayElement(HrEmployeePayElements employeePayElement) {
		// TODO Auto-generated method stub
		return personnelMasterDataService.addEmployeePayElement(employeePayElement);
	}

	@Override
	public Map<String, Object> returnSingleEmployeePayElement(Integer employeeId) {
		// TODO Auto-generated method stub
		return personnelMasterDataService.returnSingleEmployeePayElement(employeeId);
	}

	@Override
	public boolean deleteEmployeePayElement(int employeePayElementId,
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return personnelMasterDataService.deleteEmployeePayElement(employeePayElementId, generalMap);
	}
	
}
