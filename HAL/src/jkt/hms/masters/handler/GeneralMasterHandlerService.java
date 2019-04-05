package jkt.hms.masters.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAdmissionType;
import jkt.hms.masters.business.MasBlock;
import jkt.hms.masters.business.MasCaste;
import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasCurrency;
import jkt.hms.masters.business.MasDisposal;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasDivision;
import jkt.hms.masters.business.MasDocument;
import jkt.hms.masters.business.MasEmployeeType;
import jkt.hms.masters.business.MasGrade;
import jkt.hms.masters.business.MasImmunization;
import jkt.hms.masters.business.MasImpanneledHospital;
import jkt.hms.masters.business.MasMaritalStatus;
import jkt.hms.masters.business.MasOccupation;
import jkt.hms.masters.business.MasPostCode;
import jkt.hms.masters.business.MasProposedMPR;
import jkt.hms.masters.business.MasReference;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasReligion;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.MasUnitOfMeasurement;
import jkt.hms.masters.business.MasWardImpanneledHospital;
import jkt.hms.masters.business.MasZonal;

public interface GeneralMasterHandlerService {

	// ---------------------------- Title----------------------------

	Map<String, Object> showTitleJsp();

	Map<String, Object> searchTitle(String titleCode, String titleName);

	boolean addTitle(MasTitle masTitle);

	boolean editTitleToDatabase(Map<String, Object> generalMap);

	boolean deleteTitle(int titleId, Map<String, Object> generalMap);

	// -----------------------------Relation----------------------------------------------------
	Map<String, Object> searchRelation(String relationCode, String relationName);

	Map<String, Object> showRelationJsp();

	boolean addRelation(MasRelation masRelation);

	boolean editRelationToDatabase(Map<String, Object> generalMap);

	boolean deleteRelation(int relationId, Map<String, Object> generalMap);

	// --------------------RELIGION------------------------------------

	boolean addReligion(MasReligion masReligion);

	boolean deleteReligion(int religionId, Map<String, Object> generalMap);

	boolean editReligionToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchReligion(String titleCode, String titleName);

	Map<String, Object> showReligionJsp();

	// ---------------------------------Marital Status
	// ----------------------------------------

	Map<String, Object> showMaritalStatusJsp();

	Map<String, Object> searchMaritalStatus(String maritalStatusCode,
			String maritalStatusName);

	boolean addMaritalStatus(MasMaritalStatus masMaritalStatus);

	boolean editMaritalStatusToDatabase(Map<String, Object> generalMap);

	boolean deleteMaritalStatus(int maritalStatusId,
			Map<String, Object> generalMap);

	// -----------------------------Disposal------------------------------------------

	Map<String, Object> showDisposalJsp();

	Map<String, Object> searchDisposal(String disposalCode, String disposalName);

	boolean addDisposal(MasDisposal masDisposal);

	boolean editDisposalToDatabase(Map<String, Object> generalMap);

	boolean deleteDisposal(int disposalId, Map<String, Object> generalMap);

	// -----------------------------Disposal------------------------------------------

	Map<String, Object> showDocumentJsp();

	Map<String, Object> searchDocument(String documentCode, String documentName);

	boolean addDocument(MasDocument masdocument);

	boolean editDocumentToDatabase(Map<String, Object> generalMap);

	boolean deleteDocument(int documentId, Map<String, Object> generalMap);

	// ----------------------- Occupation-------------------------

	boolean addOccupation(MasOccupation masOccupation);

	boolean editUnitOfMeasurementToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchOccupation(String occupationCode,
			String occupationName);

	Map<String, Object> showOccupationJsp();

	boolean editOccupationToDatabase(Map<String, Object> generalMap);

	boolean deleteOccupation(int occupationId, Map<String, Object> generalMap);

	// ------------------------ Caste-----------------------------

	boolean addCaste(MasCaste masCaste);

	Map<String, Object> searchCaste(String casteCode, String casteName);

	Map<String, Object> showCasteJsp();

	boolean editCasteToDatabase(Map<String, Object> generalMap);

	boolean deleteCaste(int casteId, Map<String, Object> generalMap);

	// ---------------------- UnitOfMeasurement-----------------------

	boolean addUnitOfMeasurement(MasUnitOfMeasurement masUnitOfMeasurement);

	Map<String, Object> searchUnitOfMeasurement(String unitOfMeasurementCode,
			String unitOfMeasurementName);

	Map<String, Object> showUnitOfMeasurementJsp();

	boolean deleteUnitOfMeasurement(int unitOfMeasurementId,
			Map<String, Object> generalMap);

	// ----------------------- District-----------------------------------------

	boolean addDistrict(MasDistrict masDistrict);

	Map<String, Object> showDistrict();

	boolean editDistrict(Map<String, Object> generalMap);

	Map<String, Object> searchDistrict(String districtCode, String districtName);

	boolean deleteDistrict(int districtId, Map<String, Object> generalMap);

	// ------------------------------------Block--------------------------
	boolean addBlock(MasBlock masBlock);

	List<MasBlock> getBlockList();

	Map<String, Object> showBlock();

	boolean editBlock(Map<String, Object> generalMap);

	Map<String, Object> searchBlock(String blockCode, String blockName);

	boolean deleteBlock(int blockId, Map<String, Object> generalMap);

	// -----------------------Post Code--------------------------------
	boolean addPostCode(MasPostCode masPostCode);

	Map<String, Object> showPostCodeJsp();

	boolean editPostCode(Map<String, Object> generalMap);

	Map<String, Object> searchPostCode(String postCodeCode, String postCodeName);

	boolean deletePostCode(int postCodeId, Map<String, Object> generalMap);

	// ----------------------------------State
	// -------------------------------------

	boolean addState(MasState obj);

	Map<String, Object> showStateJsp();

	Map<String, Object> searchState(String stateCode, String stateName);

	boolean editState(Map<String, Object> generalMap);

	boolean deleteState(int stateId, Map<String, Object> generalMap);

	// ---------------currency-----------------------

	public boolean addCurrency(MasCurrency masCurrency);

	Map<String, Object> showCurrencyJsp();

	Map<String, Object> searchCurrency(String currencyCode, String currencyName);

	boolean editCurrencyToDatabase(Map<String, Object> generalMap);

	public boolean deleteCurrency(int currencyId, Map<String, Object> generalMap);

	// ---------------------country ------------------

	public boolean addCountry(MasCountry masCountry);

	Map<String, Object> showCountryJsp();

	boolean editCountryToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchCountry(String countryCode, String countryName);

	public boolean deleteCountry(int countryId, Map<String, Object> generalMap);

	// ---------------------- Reference ----------------------

	boolean addReference(MasReference referenceMaster);

	boolean deleteReference(int referenceId, Map<String, Object> generalMap);

	Map<String, Object> searchReference(String referenceCode,
			String referenceName);

	Map<String, Object> showReferenceJsp();

	boolean editReferenceToDatabase(Map<String, Object> generalMap);

	// -----------------------------Administrative
	// Sex------------------------------

	Map<String, Object> searchAdministrativeSex(String costCenterCode,
			String costCenterName);

	Map<String, Object> showAdministrativeSexJsp();

	boolean addAdministrativeSex(MasAdministrativeSex masAdministrativeSex);

	boolean editAdministrativeSexToDatabase(Map<String, Object> generalMap);

	boolean deleteAdministrativeSex(int costCenterId,
			Map<String, Object> generalMap);

	// -------------------------------Admission
	// Type----------------------------------

	Map<String, Object> showAdmissionTypeJsp();

	Map<String, Object> searchAdmissionType(String admissionTypeCode,
			String admissionTypeName);

	boolean addAdmissionType(MasAdmissionType masAdmissionType);

	boolean editAdmissionTypeToDatabase(Map<String, Object> generalMap);

	boolean deleteAdmissionType(int admissionTypeId,
			Map<String, Object> generalMap);

	Map<String, Object> getConnection();

	Map<String, Object> showImmunizationJsp();

	boolean addImmunization(MasImmunization masImmunization);

	boolean editImmunizationToDatabase(Map<String, Object> generalMap);

	boolean deleteImmunization(int immunizationId,
			Map<String, Object> generalMap);

	Map<String, Object> searchImmunization(String immunizationCode,String immunizationName);

	Map showDivisionJsp();

	boolean addDivision(MasDivision masDivision);

	boolean editDivisionToDatabase(Map<String, Object> generalMap);

	boolean deleteDivision(int divisionId, Map<String, Object> generalMap);

	Map<String, Object> searchDivision(String divisionCode, String divisionName);

	Map showGradeJsp();

	boolean addGrade(MasGrade masGrade);

	Map<String, Object> searchGrade(String gradeCode, String gradeName);

	boolean editGrade(Map<String, Object> generalMap);

	boolean deleteGrade(int gradeId, Map<String, Object> generalMap);

	Map<String, Object> showEmployeeTypeJsp();

	boolean deleteEmployeeType(int employeeTypeId,
			Map<String, Object> generalMap);

	boolean editEmployeeTypeToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchEmployeeType(String employeeTypeCode,
			String employeeTypeName);

	boolean addEmployeeType(MasEmployeeType masEmployeeType);
	
	
	public Map<String, Object> searchImpanneledHospital(String impanneledHospitalCode, String impanneledHospitalName);

	public Map<String, Object> showImpanneledHospitalJsp();

	public boolean deleteImpanneledHospital(int impanneledHospitalId,
			Map<String, Object> generalMap);

	public boolean editImpanneledHospitalToDatabase(
			Map<String, Object> generalMap);

	public boolean addImpanneledHospital(
			MasImpanneledHospital masImpanneledHospital);

	
	Map showZonalJsp();

	boolean addZonal(MasZonal masZonal);

	boolean editZonalToDatabase(Map<String, Object> generalMap);

	boolean deleteZonal(int zonalId, Map<String, Object> generalMap);

	Map<String, Object> searchZonal(String zonalCode, String zonalName);

	String getHospitalName(int hospitalId);

	Map<String, Object> showWardImpanneledHospitalJsp();

	Map<String, Object> checkForExistingWardImpanneledHospital(
			Map<String, Object> generalMap);

	boolean addWardImpanneledHospitalJsp(
			MasWardImpanneledHospital masWardImpanneledHospital);

	boolean editWardImpanneledHospital(Map<String, Object> generalMap);

	boolean deleteWardImpanneledHospital(int wardImpanneledHospitalId,
			Map<String, Object> generalMap);

	Map<String, Object> searchWardImpanneledHospital(
			int impanneledHospitalSearch);

	boolean addProposedMPR(MasProposedMPR masProposedMPR);

	Map<String, Object> showProposedMPRJsp();

	boolean editProposedMPRToDatabase(Map<String, Object> generalMap);

	boolean deleteProposedMPR(int proposedMPRId, Map<String, Object> generalMap);

	Map<String, Object> searchProposedMPR(String proposedMPRCode,
			String proposedMPRName);
}
