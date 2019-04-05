package jkt.hms.masters.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.DiagParam;
import jkt.hms.masters.business.MasAuthorizer;
import jkt.hms.masters.business.MasBed;
import jkt.hms.masters.business.MasCaseType;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasComplaint;
import jkt.hms.masters.business.MasComplication;
import jkt.hms.masters.business.MasCostCenter;
import jkt.hms.masters.business.MasDeathCause;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDepartmentType;
import jkt.hms.masters.business.MasIcd;
import jkt.hms.masters.business.MasIcdMainCategory;
import jkt.hms.masters.business.MasIcdSubCategory;
import jkt.hms.masters.business.MasIcdcausegrp;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasMajorCategoryCode;
import jkt.hms.masters.business.MasPatientStatus;
import jkt.hms.masters.business.MasPatientType;
import jkt.hms.masters.business.MasRoom;
import jkt.hms.masters.business.MasServiceStatus;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasSession;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.dataservice.HospitalDetailsMasterDataService;
import jkt.hms.util.Box;

public class HospitalDetailsMasterHandlerServiceImpl implements
		HospitalDetailsMasterHandlerService {
	HospitalDetailsMasterDataService hospitalDetailsMasterDataService = null;

	// ----------------------------Cost Center
	// ------------------------------------------
	public Map<String, Object> showCostCenterJsp() {
		return hospitalDetailsMasterDataService.showCostCenterJsp();
	}

	public Map<String, Object> searchCostCenter(String costCenterCode,
			String costCenterName) {
		return hospitalDetailsMasterDataService.searchCostCenter(
				costCenterCode, costCenterName);
	}

	public boolean addCostCenter(MasCostCenter masCostCenter) {
		return hospitalDetailsMasterDataService.addCostCenter(masCostCenter);
	}

	public boolean deleteCostCenter(int costCenterId,
			Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.deleteCostCenter(costCenterId,
				generalMap);
	}

	public boolean editCostCenterToDatabase(Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService
				.editCostCenterToDatabase(generalMap);
	}

	// -----------------------Major Category Code
	// ---------------------------------------

	public boolean addMajorCategoryCode(
			MasMajorCategoryCode masMajorCategoryCode) {
		return hospitalDetailsMasterDataService
				.addMajorCategoryCode(masMajorCategoryCode);
	}

	public boolean deleteMajorCategoryCode(int majorCategoryCodeId,
			Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.deleteMajorCategoryCode(
				majorCategoryCodeId, generalMap);
	}

	public boolean editMajorCategoryCodeToDatabase(
			Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService
				.editMajorCategoryCodeToDatabase(generalMap);
	}

	public Map<String, Object> searchMajorCategoryCode(
			String majorCategoryCodeCode, String majorCategoryCodeName) {
		return hospitalDetailsMasterDataService.searchMajorCategoryCode(
				majorCategoryCodeCode, majorCategoryCodeName);
	}

	public Map<String, Object> showMajorCategoryCodeJsp() {
		return hospitalDetailsMasterDataService.showMajorCategoryCodeJsp();
	}

	// -----------------------------Death Cause-----------------------------

	public boolean editDeathCauseToDatabase(Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService
				.editDeathCauseToDatabase(generalMap);
	}

	public Map<String, Object> searchDeathCause(String deathCauseCode,
			String deathCauseName) {
		return hospitalDetailsMasterDataService.searchDeathCause(
				deathCauseCode, deathCauseName);
	}

	public Map<String, Object> showDeathCauseJsp() {
		return hospitalDetailsMasterDataService.showDeathCauseJsp();
	}

	public boolean deleteDeathCause(int deathCauseId,
			Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.deleteDeathCause(deathCauseId,
				generalMap);
	}

	public boolean addDeathCause(MasDeathCause masDeathCause) {
		return hospitalDetailsMasterDataService.addDeathCause(masDeathCause);
	}

	// ---------------------------------------Patient
	// Status-------------------------------------------
	public boolean addPatientStatus(MasPatientStatus masPatientStatus) {

		return hospitalDetailsMasterDataService
				.addPatientStatus(masPatientStatus);
	}

	public boolean deletePatientStatus(int patientStatusId,
			Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.deletePatientStatus(
				patientStatusId, generalMap);
	}

	public boolean editPatientStatusToDatabase(Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService
				.editPatientStatusToDatabase(generalMap);
	}

	public Map<String, Object> searchPatientStatus(String patientStatusCode,
			String patientStatusName) {
		return hospitalDetailsMasterDataService.searchPatientStatus(
				patientStatusCode, patientStatusName);
	}

	public Map<String, Object> showPatientStatusJsp() {
		return hospitalDetailsMasterDataService.showPatientStatusJsp();
	}

	// ---------------------------- Bed
	// Master-----------------------------------
	public boolean addBed(MasBed masBed) {
		return hospitalDetailsMasterDataService.addBed(masBed);
	}

	public boolean deleteBed(int bedId, Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.deleteBed(bedId, generalMap);
	}

	public boolean editBedToDatabase(Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.editBedToDatabase(generalMap);
	}

	public Map<String, Object> searchBed(int depId,int hospitalId) {
		return hospitalDetailsMasterDataService.searchBed(depId,hospitalId);
	}

	public Map<String, Object> showBedJsp(int hospitalId) {
		return hospitalDetailsMasterDataService.showBedJsp(hospitalId);
	}

	// ----------------Case Type-------------------

	public boolean addCaseType(MasCaseType masCaseType) {
		return hospitalDetailsMasterDataService.addCaseType(masCaseType);
	}

	public boolean deleteCaseType(int caseTypeId, Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.deleteCaseType(caseTypeId,
				generalMap);
	}

	public boolean editCaseTypeToDatabase(Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService
				.editCaseTypeToDatabase(generalMap);
	}

	public Map<String, Object> showCaseTypeJsp() {
		return hospitalDetailsMasterDataService.showCaseTypeJsp();
	}

	public Map<String, Object> searchCaseType(String caseTypeCode,
			String caseTypeName) {
		return hospitalDetailsMasterDataService.searchCaseType(caseTypeCode,
				caseTypeName);
	}

	// ------------------------Main Charge Code
	// ---------------------------------------------

	public boolean addMainChargecode(MasMainChargecode masMainChargecode) {
		return hospitalDetailsMasterDataService
				.addMainChargecode(masMainChargecode);
	}

	public boolean deleteMainChargecode(int mainChargecodeId,
			Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.deleteMainChargecode(
				mainChargecodeId, generalMap);
	}

	public boolean editMainChargecodeToDatabase(Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService
				.editMainChargecodeToDatabase(generalMap);
	}

	public Map<String, Object> searchMainChargecode(String mainChargecodeCode,
			String mainChargecodeName) {
		return hospitalDetailsMasterDataService.searchMainChargecode(
				mainChargecodeCode, mainChargecodeName);
	}

	public Map<String, Object> showMainChargecodeJsp() {
		return hospitalDetailsMasterDataService.showMainChargecodeJsp();
	}

	// -----------------------------------COMPLAINT------------------------------------------

	public boolean addComplaint(MasComplaint masComplaint) {
		return hospitalDetailsMasterDataService.addComplaint(masComplaint);
	}

	public boolean editComplaintToDatabase(Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService
				.editComplaintToDatabase(generalMap);
	}

	public Map<String, Object> searchComplaint(String complaintCode,
			String complaintName) {
		return hospitalDetailsMasterDataService.searchComplaint(complaintCode,
				complaintName);
	}

	public Map<String, Object> showComplaintJsp() {
		return hospitalDetailsMasterDataService.showComplaintJsp();
	}

	public boolean deleteComplaint(int complaintId,
			Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.deleteComplaint(complaintId,
				generalMap);
	}

	// ---------------------------------------complication--------------------

	public boolean addComplication(MasComplication masComplication) {
		return hospitalDetailsMasterDataService
				.addComplication(masComplication);
	}

	public Map<String, Object> showComplicationJsp() {
		return hospitalDetailsMasterDataService.showComplicationJsp();
	}

	public boolean editComplicationToDatabase(Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService
				.editComplicationToDatabase(generalMap);
	}

	public Map<String, Object> searchComplication(String complicationCode,
			String complicationName) {
		return hospitalDetailsMasterDataService.searchComplication(
				complicationCode, complicationName);
	}

	public boolean deleteComplication(int complicationId,
			Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.deleteComplication(
				complicationId, generalMap);
	}

	// ------------------------------authorizer--------------------------

	public boolean addAuthorizer(MasAuthorizer masAuthorizer) {
		return hospitalDetailsMasterDataService.addAuthorizer(masAuthorizer);
	}

	public boolean editAuthorizerToDatabase(Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService
				.editAuthorizerToDatabase(generalMap);
	}

	public Map<String, Object> searchAuthorizer(String authorizerCode,
			String authorizerName) {
		return hospitalDetailsMasterDataService.searchAuthorizer(
				authorizerCode, authorizerName);
	}

	public Map<String, Object> showAuthorizerJsp() {
		return hospitalDetailsMasterDataService.showAuthorizerJsp();
	}

	public boolean deleteAuthorizer(int authorizerId,
			Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.deleteAuthorizer(authorizerId,
				generalMap);
	}

	// ------------------------------Department------------------------

	public List<MasDepartmentType> getDepartmentTypeList() {
		return hospitalDetailsMasterDataService.getDepartmentTypeList();
	}

	public List<MasCostCenter> getCostCenterList() {
		return hospitalDetailsMasterDataService.getCostCenterList();
	}

	public boolean addDepartment(MasDepartment masDepartment) {
		return hospitalDetailsMasterDataService.addDepartment(masDepartment);
	}

	public boolean updateDepartment(Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.updateDepartment(generalMap);
	}

	public boolean deleteDepartment(int departmentId,
			Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.deleteDepartment(departmentId,
				generalMap);
	}

	// ----------------------- Room --------------------------------
	public List<MasDepartment> getDepartmentList() {
		return hospitalDetailsMasterDataService.getDepartmentList();
	}

	public boolean addRoom(MasRoom masRoom) {
		return hospitalDetailsMasterDataService.addRoom(masRoom);
	}

	public boolean editRoomToDatabase(Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.editRoomToDatabase(generalMap);
	}

	public Map<String, Object> searchRoom(String roomCode) {
		return hospitalDetailsMasterDataService.searchRoom(roomCode);
	}

	public Map<String, Object> showRoomJsp() {
		return hospitalDetailsMasterDataService.showRoomJsp();
	}

	public boolean deleteRoom(int roomId, Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.deleteRoom(roomId, generalMap);
	}

	// -----------------------ICD Sub Category
	// -------------------------------------

	public boolean addIcdSubCategory(MasIcdSubCategory masIcdSubCategory) {
		return hospitalDetailsMasterDataService
				.addIcdSubCategory(masIcdSubCategory);
	}

	public boolean deleteIcdSubCategory(int icdSubCategoryId,
			Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.deleteIcdSubCategory(
				icdSubCategoryId, generalMap);
	}

	public boolean editIcdSubCategoryToDatabase(Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService
				.editIcdSubCategoryToDatabase(generalMap);
	}

	public Map<String, Object> searchIcdSubCategory(String icdSubCategoryCode,
			String icdSubCategoryName) {
		return hospitalDetailsMasterDataService.searchIcdSubCategory(
				icdSubCategoryCode, icdSubCategoryName);
	}

	public Map<String, Object> showIcdSubCategoryJsp() {
		return hospitalDetailsMasterDataService.showIcdSubCategoryJsp();
	}

	// ---------------------------------Charge Code
	// --------------------------------

	public Map<String, Object> searchChargeCode(String chargeCodeCode,
			String chargeCodeName) {
		return hospitalDetailsMasterDataService.searchChargeCode(
				chargeCodeCode, chargeCodeName);
	}

	public Map<String, Object> showChargeCodeJsp() {
		return hospitalDetailsMasterDataService.showChargeCodeJsp();
	}

	public boolean addChargeCode(MasChargeCode masChargeCode) {
		return hospitalDetailsMasterDataService.addChargeCode(masChargeCode);
	}

	public boolean deleteSubTest(Integer subTestId) {
		return hospitalDetailsMasterDataService.deleteSubTest(subTestId);
	}

	public boolean deleteChargeCode(Integer chargeCodeId) {
		return hospitalDetailsMasterDataService.deleteChargeCode(chargeCodeId);
	}

	public boolean checkChargeCodeNameExsistForEditing(int chargeCodeId,
			String chargeCodeName) {
		return hospitalDetailsMasterDataService
				.checkChargeCodeNameExsistForEditing(chargeCodeId,
						chargeCodeName);
	}

	public boolean checkChargeCodeExsist(String chargeCodeCode,
			String chargeCodeName) {
		return hospitalDetailsMasterDataService.checkChargeCodeExsist(
				chargeCodeCode, chargeCodeName);
	}

	// public boolean editChargeCode(MasChargeCode masChargeCode,
	// List<MasSubTest> masSubTest, boolean subTesttobeDeleted) {
	// return hospitalDetailsMasterDataService.editChargeCode(masChargeCode,
	// masSubTest, subTesttobeDeleted);
	// }
	// --------------------------------sub charge code------------------------
	public boolean addSubCharge(MasSubChargecode maSubChargecode) {
		return hospitalDetailsMasterDataService.addSubCharge(maSubChargecode);
	}

	public Map<String, Object> searchSubCharge(String subChargecodeCode,
			String subChargecodeName) {
		return hospitalDetailsMasterDataService.searchSubCharge(
				subChargecodeCode, subChargecodeName);
	}

	public Map<String, Object> showSubChargeJsp() {
		return hospitalDetailsMasterDataService.showSubChargeJsp();
	}

	public boolean deleteSubCharge(Integer subChargecodeId,
			Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.deleteSubCharge(
				subChargecodeId, generalMap);
	}

	public boolean editSubChargeToDatabase(Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService
				.editSubChargeToDatabase(generalMap);
	}

	// ----------------------- ICD Main Category---------------------------
	public Map<String, Object> searchIcdMainCategory(
			String icdMainCategoryCode, String icdMaincategoryName) {
		return hospitalDetailsMasterDataService.searchIcdMainCategory(
				icdMainCategoryCode, icdMaincategoryName);
	}

	public Map<String, Object> showIcdMainCategoryJsp() {
		return hospitalDetailsMasterDataService.showIcdMainCategoryJsp();
	}

	public boolean addIcdMainCategory(MasIcdMainCategory masIcdMainCategory) {
		return hospitalDetailsMasterDataService
				.addIcdMainCategory(masIcdMainCategory);
	}

	public boolean editIcdMainCategoryToDatabase(Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService
				.editIcdMainCategoryToDatabase(generalMap);
	}

	public boolean deleteIcdMainCategory(int icdMainCategoryId,
			Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.deleteIcdMainCategory(
				icdMainCategoryId, generalMap);
	}

	// ----------------------- ICD -------------------------
	public Map<String, Object> showIcdJsp() {
		return hospitalDetailsMasterDataService.showIcdJsp();
	}

	public Map<String, Object> searchIcd(String icdCode, String icdName) {
		return hospitalDetailsMasterDataService.searchIcd(icdCode, icdName);
	}

	public boolean addIcd(MasIcd masIcd) {
		return hospitalDetailsMasterDataService.addIcd(masIcd);
	}

	public boolean editIcdToDatabase(Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.editIcdToDatabase(generalMap);
	}

	public boolean deleteIcd(int icdId, Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.deleteIcd(icdId, generalMap);
	}

	// ---------------------------------------Service
	// Type------------------------------------------

	public boolean addServiceType(MasServiceType masServiceType) {
		return hospitalDetailsMasterDataService.addServiceType(masServiceType);
	}

	public boolean deleteServiceType(int serviceTypeId,
			Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.deleteServiceType(
				serviceTypeId, generalMap);
	}

	public boolean editServiceTypeToDatabase(Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService
				.editServiceTypeToDatabase(generalMap);
	}

	public Map<String, Object> searchServiceType(String serviceTypeCode,
			String serviceTypeName) {
		return hospitalDetailsMasterDataService.searchServiceType(
				serviceTypeCode, serviceTypeName);
	}

	public Map<String, Object> showServiceTypeJsp() {
		return hospitalDetailsMasterDataService.showServiceTypeJsp();
	}

	// -------------------------------------Service
	// Status------------------------------------

	public Map<String, Object> showServiceStatusJsp() {
		return hospitalDetailsMasterDataService.showServiceStatusJsp();
	}

	public Map<String, Object> searchServiceStatus(String serviceStatusCode,
			String serviceStatusName) {
		return hospitalDetailsMasterDataService.searchServiceStatus(
				serviceStatusCode, serviceStatusName);
	}

	public boolean addServiceStatus(MasServiceStatus masServiceStatus) {
		return hospitalDetailsMasterDataService
				.addServiceStatus(masServiceStatus);
	}

	public boolean deleteServiceStatus(int serviceStatusId,
			Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.deleteServiceStatus(
				serviceStatusId, generalMap);
	}

	public boolean editServiceStatusToDatabase(Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService
				.editServiceStatusToDatabase(generalMap);
	}

	public Map<String, Object> getConnection() {
		return hospitalDetailsMasterDataService.getConnection();
	}

	// -----------------------patient Type-----------------------------------

	public boolean addPatientType(MasPatientType masPatientType) {
		return hospitalDetailsMasterDataService.addPatientType(masPatientType);
	}

	public boolean editPatientTypeToDatabase(Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService
				.editPatientTypeToDatabase(generalMap);
	}

	public Map<String, Object> searchPatientType(String patientTypeCode,
			String patientTypeName) {
		return hospitalDetailsMasterDataService.searchPatientType(
				patientTypeCode, patientTypeName);
	}

	public Map<String, Object> showPatientTypeJsp() {
		return hospitalDetailsMasterDataService.showPatientTypeJsp();
	}

	public boolean deletePatientType(int patientTypeId,
			Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.deletePatientType(
				patientTypeId, generalMap);
	}

	// ----------------------------Icd
	// Causegrp-----------------------------------
	public boolean addIcdCause(MasIcdcausegrp masIcdcausegrp) {
		return hospitalDetailsMasterDataService.addIcdCause(masIcdcausegrp);
	}

	public boolean deleteIcdCause(int causeId, Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.deleteIcdCause(causeId,
				generalMap);
	}

	public boolean editIcdCauseToDatabase(Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService
				.editIcdCauseToDatabase(generalMap);
	}

	public Map<String, Object> searchIcdCause(String causeCode, String causeName) {
		return hospitalDetailsMasterDataService.searchIcdCause(causeCode,
				causeName);
	}

	public Map<String, Object> showIcdCauseJsp() {
		return hospitalDetailsMasterDataService.showIcdCauseJsp();
	}

	// ------------------------------------------------------------------------

	public HospitalDetailsMasterDataService getHospitalDetailsMasterDataService() {
		return hospitalDetailsMasterDataService;
	}

	public void setHospitalDetailsMasterDataService(
			HospitalDetailsMasterDataService hospitalDetailsMasterDataService) {
		this.hospitalDetailsMasterDataService = hospitalDetailsMasterDataService;
	}

	public boolean deleteChargeCode1(int chargeCodeId,
			Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.deleteChargeCode1(chargeCodeId,
				generalMap);
	}

	public Map<String, Object> showParamJsp() {
		// TODO Auto-generated method stub
		return hospitalDetailsMasterDataService.showParamJsp();
	}

	public boolean editChargeCode(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return hospitalDetailsMasterDataService.editChargeCode(generalMap);
	}

	public boolean addDiagParam(DiagParam diagParam) {
		// TODO Auto-generated method stub
		return hospitalDetailsMasterDataService.addDiagParam(diagParam);
	}

	public boolean editDiagParam(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return hospitalDetailsMasterDataService.editDiagParam(generalMap);
	}

	public boolean deleteDiagParam(Integer diagId,
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return hospitalDetailsMasterDataService.deleteDiagParam(diagId,
				generalMap);
	}

	public Map<String, Object> getSubchargeList(Box box) {
		// TODO Auto-generated method stub
		return hospitalDetailsMasterDataService.getSubchargeList(box);
	}

	public Map searchSubChargeInDiagParam(String subChargecodeCode,
			String subChargecodeName) {
		// TODO Auto-generated method stub
		return hospitalDetailsMasterDataService.searchSubChargeInDiagParam(
				subChargecodeCode, subChargecodeName);
	}

	@Override
	public Map<String, Object> checkExistingBedNo(Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.checkExistingBedNo(generalMap);
	}

	
	

	@Override
	public boolean addSession(MasSession masSession) {
		return hospitalDetailsMasterDataService.addSession(masSession);
	}
	
	@Override
	public Map<String,Object> checkSession(Map<String,Object> dataMap) {
		return hospitalDetailsMasterDataService.checkSession(dataMap);
	}

	@Override
	public Map<String, Object> showSessionJsp(Box box) {
		return hospitalDetailsMasterDataService.showSessionJsp(box);
	}

	@Override
	public boolean editSessionToDatabase(Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.editSessionToDatabase(generalMap);
	}

	@Override
	public boolean deleteSession(int sessionId, Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.deleteSession(sessionId, generalMap);
	}

	@Override
	public Map<String, Object> searchSession(String sessionName) {
		return hospitalDetailsMasterDataService.searchSession(sessionName);
	}
	
	
	@Override
	public Map<String, Object> getHospitalName(Map<String, Object> mapForDs) {
		return hospitalDetailsMasterDataService.getHospitalName(mapForDs);
	}
	
	public Map checkForExistingMastersForHospital(Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService
				.checkForExistingMastersForHospital(generalMap);
	}
	// ---------------------------- Ot	// Master-----------------------------------
	public boolean addOt(MasBed masBed,int otId) {
		return hospitalDetailsMasterDataService.addOt(masBed,otId);
	}

	public boolean deleteOt(int bedId, Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.deleteOt(bedId, generalMap);
	}

	public boolean editOtToDatabase(Map<String, Object> generalMap) {
		return hospitalDetailsMasterDataService.editOtToDatabase(generalMap);
	}

	public Map<String, Object> searchOt(String bedNumber) {
		return hospitalDetailsMasterDataService.searchOt(bedNumber);
	}

	public Map<String, Object> showOtJsp() {
		return hospitalDetailsMasterDataService.showOtJsp();
	}
}
