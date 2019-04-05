package jkt.hms.masters.dataservice;

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
import jkt.hms.util.Box;

public interface HospitalDetailsMasterDataService {

	// ------------------------------------Case Type--------------------------

	boolean addCaseType(MasCaseType masCaseType);

	boolean deleteCaseType(int caseTypeId, Map<String, Object> generalMap);

	boolean editCaseTypeToDatabase(Map<String, Object> generalMap);

	Map<String, Object> showCaseTypeJsp();

	Map<String, Object> searchCaseType(String caseTypeCode, String caseTypeName);

	// ----------------------Main Charge Code
	// --------------------------------------------

	boolean addMainChargecode(MasMainChargecode masMainChargecode);

	boolean deleteMainChargecode(int mainChargecodeId,
			Map<String, Object> generalMap);

	boolean editMainChargecodeToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchMainChargecode(String mainChargecodeCode,
			String mainChargecodeName);

	Map<String, Object> showMainChargecodeJsp();

	// -------------------------------Cost Center
	// -----------------------------------------

	Map<String, Object> showCostCenterJsp();

	Map<String, Object> searchCostCenter(String costCenterCode,
			String costCenterName);

	boolean addCostCenter(MasCostCenter masCostCenter);

	boolean deleteCostCenter(int costCenterId, Map<String, Object> generalMap);

	boolean editCostCenterToDatabase(Map<String, Object> generalMap);

	// --------------------------Major Category Code
	// ---------------------------------

	boolean addMajorCategoryCode(MasMajorCategoryCode masMajorCategoryCode);

	boolean deleteMajorCategoryCode(int majorCategoryCodeId,
			Map<String, Object> generalMap);

	boolean editMajorCategoryCodeToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchMajorCategoryCode(String majorCategoryCodeCode,
			String majorCategoryCodeName);

	Map<String, Object> showMajorCategoryCodeJsp();

	// ------------------------------------Death Cause------------------------

	boolean addDeathCause(MasDeathCause masDeathCause);

	boolean deleteDeathCause(int deathCauseId, Map<String, Object> generalMap);

	boolean editDeathCauseToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchDeathCause(String deathCauseCode,
			String deathCauseName);

	Map<String, Object> showDeathCauseJsp();

	// -------------------------------Patient
	// Status--------------------------------

	boolean deletePatientStatus(int patientStatusId,
			Map<String, Object> generalMap);

	boolean addPatientStatus(MasPatientStatus masPatientStatus);

	boolean editPatientStatusToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchPatientStatus(String patientStatusCode,
			String patientStatusName);

	Map<String, Object> showPatientStatusJsp();

	// ------------------------------------Bed Master
	// ----------------------------------------
	boolean addBed(MasBed masBed);

	boolean deleteBed(int bedId, Map<String, Object> generalMap);

	boolean editBedToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchBed(int depId, int hospitalId);

	Map<String, Object> showBedJsp(int hospitalId);

	// -----------------------Service
	// Status---------------------------------------------

	Map<String, Object> showServiceStatusJsp();

	Map<String, Object> searchServiceStatus(String serviceStatusCode,
			String serviceStatusName);

	boolean addServiceStatus(MasServiceStatus masServiceStatus);

	boolean deleteServiceStatus(int serviceStatusId,
			Map<String, Object> generalMap);

	boolean editServiceStatusToDatabase(Map<String, Object> generalMap);

	// ----------------------------------COMPLAINT-----------------------------

	boolean addComplaint(MasComplaint masComplaint);

	boolean editComplaintToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchComplaint(String complaintCode,
			String complaintName);

	Map<String, Object> showComplaintJsp();

	boolean deleteComplaint(int complaintId, Map<String, Object> generalMap);

	// -----------------------------COMPLICATION-----------------------

	boolean addComplication(MasComplication masComplication);

	Map<String, Object> showComplicationJsp();

	boolean editComplicationToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchComplication(String complicationCode,
			String complicationName);

	boolean deleteComplication(int complicationId,
			Map<String, Object> generalMap);

	// ----------------------------Authorizer
	// -----------------------------------

	boolean addAuthorizer(MasAuthorizer masAuthorizer);

	boolean editAuthorizerToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchAuthorizer(String authorizerCode,
			String authorizerName);

	Map<String, Object> showAuthorizerJsp();

	boolean deleteAuthorizer(int authorizerId, Map<String, Object> generalMap);

	// ---------------------------Room--------------------------------------

	List<MasDepartment> getDepartmentList();

	boolean addRoom(MasRoom masRoom);

	boolean editRoomToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchRoom(String roomCode);

	Map<String, Object> showRoomJsp();

	boolean deleteRoom(int roomId, Map<String, Object> generalMap);

	// -----------------------ICD Sub
	// Category-------------------------------------

	boolean addIcdSubCategory(MasIcdSubCategory masIcdSubCategory);

	boolean deleteIcdSubCategory(int icdSubCategoryId,
			Map<String, Object> generalMap);

	boolean editIcdSubCategoryToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchIcdSubCategory(String icdSubCategoryCode,
			String icdSubCategoryName);

	Map<String, Object> showIcdSubCategoryJsp();

	// ---------------------------------Charge
	// Code---------------------------------

	Map<String, Object> searchChargeCode(String chargeCodeCode,
			String chargeCodeName);

	Map<String, Object> showChargeCodeJsp();

	boolean addChargeCode(MasChargeCode masChargeCode);

	boolean deleteSubTest(Integer subTestId);

	boolean deleteChargeCode(Integer chargeCodeId);

	boolean checkChargeCodeExsist(String chargeCodeCode,
			String chargeCodeDescription);

	boolean checkChargeCodeNameExsistForEditing(int chargeCodeId,
			String chargeCodeName);

	boolean editChargeCode(Map<String, Object> generalMap);

	// ------------------------------subcharge code ---------------------------

	Map<String, Object> showSubChargeJsp();

	boolean addSubCharge(MasSubChargecode masSubChargecode);

	Map<String, Object> searchSubCharge(String subChargecodeCode,
			String subChargecodeName);

	boolean editSubChargeToDatabase(Map<String, Object> generalMap);

	boolean deleteSubCharge(Integer subChargecodeId,
			Map<String, Object> generalMap);

	// ----------------------- ICD Main Category ----------------------------

	Map<String, Object> searchIcdMainCategory(String icdMainCategoryCode,
			String icdMainCategoryName);

	Map<String, Object> showIcdMainCategoryJsp();

	boolean addIcdMainCategory(MasIcdMainCategory masIcdMainCategory);

	boolean editIcdMainCategoryToDatabase(Map<String, Object> generalMap);

	boolean deleteIcdMainCategory(int icdMainCategoryId,
			Map<String, Object> generalMap);

	// --------------------- ICD ---------------------------------------
	Map<String, Object> showIcdJsp();

	Map<String, Object> searchIcd(String icdCode, String icdName);

	boolean addIcd(MasIcd masIcd);

	boolean editIcdToDatabase(Map<String, Object> generalMap);

	boolean deleteIcd(int icdId, Map<String, Object> generalMap);

	// -----------------------------Deaprtment---------------------------

	List<MasDepartmentType> getDepartmentTypeList();

	List<MasCostCenter> getCostCenterList();

	boolean addDepartment(MasDepartment masDepartment);

	boolean updateDepartment(Map<String, Object> generalMap);

	boolean deleteDepartment(int departmentId, Map<String, Object> generalMap);

	// ---------------------------Service
	// Type-------------------------------------

	boolean addServiceType(MasServiceType masServiceType);

	boolean deleteServiceType(int serviceTypeId, Map<String, Object> generalMap);

	boolean editServiceTypeToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchServiceType(String serviceTypeCode,
			String serviceTypeName);

	Map<String, Object> showServiceTypeJsp();

	Map<String, Object> getConnection();

	// -------------------------------------Patient
	// Type----------------------------------

	boolean addPatientType(MasPatientType masPatientType);

	boolean editPatientTypeToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchPatientType(String patientTypeCode,
			String patientTypeName);

	Map<String, Object> showPatientTypeJsp();

	boolean deletePatientType(int patientTypeId, Map<String, Object> generalMap);

	// -----------------------------Icd Cause Grp----------------------------
	boolean addIcdCause(MasIcdcausegrp masIcdcausegrp);

	boolean deleteIcdCause(int causeId, Map<String, Object> generalMap);

	boolean editIcdCauseToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchIcdCause(String causeCode, String causeName);

	Map<String, Object> showIcdCauseJsp();

	boolean deleteChargeCode1(int chargeCodeId, Map<String, Object> generalMap);

	/** methods for diag param **/
	Map<String, Object> showParamJsp();

	public boolean addDiagParam(DiagParam diagParam);

	public boolean editDiagParam(Map<String, Object> generalMap);

	public boolean deleteDiagParam(Integer diagId,
			Map<String, Object> generalMap);

	public Map<String, Object> getSubchargeList(Box box);

	public Map searchSubChargeInDiagParam(String subChargecodeCode,
			String subChargecodeName);

	Map<String, Object> checkExistingBedNo(Map<String, Object> generalMap);
	
	boolean addSession(MasSession masSession);

	Map<String, Object> showSessionJsp(Box box);
	
	Map<String, Object> checkSession(Map<String, Object> dataMap);

	boolean editSessionToDatabase(Map<String, Object> generalMap);

	boolean deleteSession(int sessionId, Map<String, Object> generalMap);

	Map<String, Object> searchSession(String sessionName);

	Map<String, Object> getHospitalName(Map<String, Object> mapForDs);
	

	
	Map<String, Object> showOtJsp();

	boolean deleteOt(int bedId, Map<String, Object> generalMap);

	boolean editOtToDatabase(Map<String, Object> generalMap);

	Map<String, Object> checkForExistingMastersForHospital(
			Map<String, Object> generalMap);

	Map<String, Object> searchOt(String bedNumber);

	boolean addOt(MasBed masBed,int otId);
}
