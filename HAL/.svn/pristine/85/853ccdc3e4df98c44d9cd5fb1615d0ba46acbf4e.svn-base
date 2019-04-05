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
import jkt.hms.masters.dataservice.GeneralMasterDataService;


public class GeneralMasterHandlerServiceImpl implements
		GeneralMasterHandlerService {

	GeneralMasterDataService generalMasterDataService = null;

	// ----------------------------------------Title
	// ---------------------------------------------------
	public boolean addTitle(MasTitle masTitle) {
		return generalMasterDataService.addTitle(masTitle);
	}

	public boolean editTitleToDatabase(Map<String, Object> generalMap) {
		return generalMasterDataService.editTitleToDatabase(generalMap);
	}

	public boolean deleteTitle(int titleId, Map<String, Object> generalMap) {
		return generalMasterDataService.deleteTitle(titleId, generalMap);
	}

	public Map<String, Object> searchTitle(String titleCode, String titleName) {
		return generalMasterDataService.searchTitle(titleCode, titleName);
	}

	public Map<String, Object> showTitleJsp() {
		return generalMasterDataService.showTitleJsp();
	}

	// ---------------------------Occupation----------------------

	public boolean addOccupation(MasOccupation masOccupation) {
		return generalMasterDataService.addOccupation(masOccupation);
	}

	public boolean editOccupationToDatabase(Map<String, Object> generalMap) {
		return generalMasterDataService.editOccupationToDatabase(generalMap);
	}

	public Map<String, Object> searchOccupation(String occupationCode,
			String occupationName) {
		return generalMasterDataService.searchOccupation(occupationCode,
				occupationName);
	}

	public Map<String, Object> showOccupationJsp() {
		return generalMasterDataService.showOccupationJsp();
	}

	public boolean deleteOccupation(int occupationId,
			Map<String, Object> generalMap) {
		return generalMasterDataService.deleteOccupation(occupationId,
				generalMap);
	}

	// ------------------------------Caste----------------------
	public boolean addCaste(MasCaste masCaste) {
		return generalMasterDataService.addCaste(masCaste);
	}

	public Map<String, Object> searchCaste(String casteCode, String casteName) {
		return generalMasterDataService.searchCaste(casteCode, casteName);
	}

	public Map<String, Object> showCasteJsp() {
		return generalMasterDataService.showCasteJsp();
	}

	public boolean editCasteToDatabase(Map<String, Object> generalMap) {
		return generalMasterDataService.editCasteToDatabase(generalMap);
	}

	public boolean deleteCaste(int casteId, Map<String, Object> generalMap) {
		return generalMasterDataService.deleteCaste(casteId, generalMap);
	}

	// --------------------------------Relation --------------------------------

	public boolean addRelation(MasRelation masRelation) {
		return generalMasterDataService.addRelation(masRelation);
	}

	public boolean deleteRelation(int relationId, Map<String, Object> generalMap) {
		return generalMasterDataService.deleteRelation(relationId, generalMap);
	}

	public boolean editRelationToDatabase(Map<String, Object> generalMap) {
		return generalMasterDataService.editRelationToDatabase(generalMap);
	}

	public Map<String, Object> searchRelation(String relationCode,
			String relationName) {
		return generalMasterDataService.searchRelation(relationCode,
				relationName);
	}

	public Map<String, Object> showRelationJsp() {
		return generalMasterDataService.showRelationJsp();
	}

	// --------------------------------------Religion-------------------------------------------

	public boolean editReligionToDatabase(Map<String, Object> generalMap) {
		return generalMasterDataService.editReligionToDatabase(generalMap);
	}

	public Map<String, Object> showReligionJsp() {
		return generalMasterDataService.showReligionJsp();
	}

	public boolean addReligion(MasReligion masReligion) {
		return generalMasterDataService.addReligion(masReligion);
	}

	public boolean deleteReligion(int religionId, Map<String, Object> generalMap) {
		return generalMasterDataService.deleteReligion(religionId, generalMap);
	}

	public Map<String, Object> searchReligion(String religionCode,
			String religionName) {
		return generalMasterDataService.searchReligion(religionCode,
				religionName);
	}

	// ----------------------------------------Marital Status
	// ----------------------------------------------------------

	public boolean addMaritalStatus(MasMaritalStatus masMaritalStatus) {
		return generalMasterDataService.addMaritalStatus(masMaritalStatus);
	}

	public boolean deleteMaritalStatus(int maritalStatusId,
			Map<String, Object> generalMap) {
		return generalMasterDataService.deleteMaritalStatus(maritalStatusId,
				generalMap);
	}

	public boolean editMaritalStatusToDatabase(Map<String, Object> generalMap) {
		return generalMasterDataService.editMaritalStatusToDatabase(generalMap);
	}

	public Map<String, Object> searchMaritalStatus(String maritalStatusCode,
			String maritalStatusName) {
		return generalMasterDataService.searchMaritalStatus(maritalStatusCode,
				maritalStatusName);
	}

	public Map<String, Object> showMaritalStatusJsp() {
		return generalMasterDataService.showMaritalStatusJsp();
	}

	// -------------------------------------Disposal---------------------------------------------

	public Map<String, Object> showDisposalJsp() {
		return generalMasterDataService.showDisposalJsp();
	}

	public Map<String, Object> searchDisposal(String disposalCode,
			String disposalName) {
		return generalMasterDataService.searchDisposal(disposalCode,
				disposalName);
	}

	public boolean addDisposal(MasDisposal masDisposal) {
		return generalMasterDataService.addDisposal(masDisposal);
	}

	public boolean deleteDisposal(int disposalId, Map<String, Object> generalMap) {
		return generalMasterDataService.deleteDisposal(disposalId, generalMap);
	}

	public boolean editDisposalToDatabase(Map<String, Object> generalMap) {
		return generalMasterDataService.editDisposalToDatabase(generalMap);
	}

	// ----------------------------------------Document-------------------------------

	public Map<String, Object> showDocumentJsp() {
		return generalMasterDataService.showDocumentJsp();
	}

	public Map<String, Object> searchDocument(String documentCode,
			String documentName) {
		return generalMasterDataService.searchDocument(documentCode,
				documentName);
	}

	public boolean addDocument(MasDocument masDocument) {
		return generalMasterDataService.addDocument(masDocument);
	}

	public boolean deleteDocument(int documentId, Map<String, Object> generalMap) {
		return generalMasterDataService.deleteDocument(documentId, generalMap);
	}

	public boolean editDocumentToDatabase(Map<String, Object> generalMap) {
		return generalMasterDataService.editDocumentToDatabase(generalMap);
	}

	// ---------------------------------UnitOfMeasurementMaster------------------------------------------

	public boolean addUnitOfMeasurement(
			MasUnitOfMeasurement masUnitOfMeasurement) {
		return generalMasterDataService
				.addUnitOfMeasurement(masUnitOfMeasurement);
	}

	public Map<String, Object> searchUnitOfMeasurement(
			String unitOfMeasurementCode, String unitOfMeasurementName) {
		return generalMasterDataService.searchUnitOfMeasurement(
				unitOfMeasurementCode, unitOfMeasurementName);
	}

	public Map<String, Object> showUnitOfMeasurementJsp() {
		return generalMasterDataService.showUnitOfMeasurementJsp();
	}

	public boolean editUnitOfMeasurementToDatabase(
			Map<String, Object> generalMap) {
		return generalMasterDataService
				.editUnitOfMeasurementToDatabase(generalMap);
	}

	public boolean deleteUnitOfMeasurement(int unitOfMeasurementId,
			Map<String, Object> generalMap) {
		return generalMasterDataService.deleteUnitOfMeasurement(
				unitOfMeasurementId, generalMap);
	}

	// ----------------------------- District
	// -------------------------------------------------------

	public boolean addDistrict(MasDistrict masDistrict) {
		return generalMasterDataService.addDistrict(masDistrict);
	}

	public boolean editDistrict(Map<String, Object> generalMap) {
		return generalMasterDataService.editDistrict(generalMap);
	}

	public Map<String, Object> searchDistrict(String districtCode,
			String districtName) {
		return generalMasterDataService.searchDistrict(districtCode,
				districtName);
	}

	public Map<String, Object> showDistrict() {
		return generalMasterDataService.showDistrict();
	}

	public boolean deleteDistrict(int districtId, Map<String, Object> generalMap) {
		return generalMasterDataService.deleteDistrict(districtId, generalMap);
	}

	// -----------------------------Block------------------------------------
	public boolean addBlock(MasBlock masBlock) {
		return generalMasterDataService.addBlock(masBlock);
	}

	public boolean deleteBlock(int blockId, Map<String, Object> generalMap) {
		return generalMasterDataService.deleteBlock(blockId, generalMap);
	}

	public boolean editBlock(Map<String, Object> generalMap) {
		return generalMasterDataService.editBlock(generalMap);
	}

	public Map<String, Object> searchBlock(String blockCode, String blockName) {
		return generalMasterDataService.searchBlock(blockCode, blockName);
	}

	public Map<String, Object> showBlock() {
		return generalMasterDataService.showBlock();
	}

	// -----------------------------PostCode---------------------------------------------

	public boolean addPostCode(MasPostCode masPostCode) {
		return generalMasterDataService.addPostCode(masPostCode);
	}

	public boolean deletePostCode(int postCodeId, Map<String, Object> generalMap) {
		return generalMasterDataService.deletePostCode(postCodeId, generalMap);
	}

	public boolean editPostCode(Map<String, Object> generalMap) {
		return generalMasterDataService.editPostCode(generalMap);
	}

	public Map<String, Object> searchPostCode(String postCodeCode,
			String postCodeName) {
		return generalMasterDataService.searchPostCode(postCodeCode,
				postCodeName);
	}

	public Map<String, Object> showPostCodeJsp() {
		return generalMasterDataService.showPostCodeJsp();
	}

	// ------------------------State
	// ---------------------------------------------

	public boolean addState(MasState masState) {
		return generalMasterDataService.addState(masState);
	}

	public boolean deleteState(int stateId, Map<String, Object> generalMap) {
		return generalMasterDataService.deleteState(stateId, generalMap);
	}

	public boolean editState(Map<String, Object> generalMap) {
		return generalMasterDataService.editState(generalMap);
	}

	public Map<String, Object> searchState(String stateCode, String stateName) {
		return generalMasterDataService.searchState(stateCode, stateName);
	}

	public Map<String, Object> showStateJsp() {
		return generalMasterDataService.showStateJsp();
	}

	// ---------------------currency----------------------
	public boolean addCurrency(MasCurrency masCurrency) {
		return generalMasterDataService.addCurrency(masCurrency);
	}

	public boolean editCurrencyToDatabase(Map<String, Object> generalMap) {
		return generalMasterDataService.editCurrencyToDatabase(generalMap);
	}

	public Map<String, Object> searchCurrency(String currencyCode,
			String currencyName) {
		return generalMasterDataService.searchCurrency(currencyCode,
				currencyName);
	}

	public Map<String, Object> showCurrencyJsp() {
		return generalMasterDataService.showCurrencyJsp();
	}

	public boolean deleteCurrency(int currencyId, Map<String, Object> generalMap) {
		return generalMasterDataService.deleteCurrency(currencyId, generalMap);
	}

	// ------------------------------country-----------------

	public boolean addCountry(MasCountry masCountry) {
		return generalMasterDataService.addCountry(masCountry);
	}

	public boolean editCountryToDatabase(Map<String, Object> generalMap) {
		return generalMasterDataService.editCountryToDatabase(generalMap);
	}

	public Map<String, Object> searchCountry(String countryCode,
			String countryName) {
		return generalMasterDataService.searchCountry(countryCode, countryName);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showCountryJsp() {
		return generalMasterDataService.showCountryJsp();
	}

	public boolean deleteCountry(int countryId, Map<String, Object> generalMap) {
		return generalMasterDataService.deleteCountry(countryId, generalMap);
	}

	// --------------------

	public List<MasBlock> getBlockList() {
		return generalMasterDataService.getBlockList();
	}

	// ---------------------------------Reference
	// Master----------------------------------------

	public boolean addReference(MasReference masReference) {
		return generalMasterDataService.addReference(masReference);
	}

	public boolean deleteReference(int referenceId,
			Map<String, Object> generalMap) {
		return generalMasterDataService
				.deleteReference(referenceId, generalMap);
	}

	public boolean editReferenceToDatabase(Map<String, Object> generalMap) {
		return generalMasterDataService.editReferenceToDatabase(generalMap);
	}

	public Map<String, Object> searchReference(String referenceCode,
			String referenceName) {
		return generalMasterDataService.searchReference(referenceCode,
				referenceName);
	}

	public Map<String, Object> showReferenceJsp() {
		return generalMasterDataService.showReferenceJsp();
	}

	// ----------------------------Administrative
	// Sex----------------------------------------

	public Map<String, Object> showAdministrativeSexJsp() {
		return generalMasterDataService.showAdministrativeSexJsp();
	}

	public Map<String, Object> searchAdministrativeSex(
			String administrativeSexCode, String administrativeSexName) {
		return generalMasterDataService.searchAdministrativeSex(
				administrativeSexCode, administrativeSexName);
	}

	public boolean addAdministrativeSex(
			MasAdministrativeSex masAdministrativeSex) {
		return generalMasterDataService
				.addAdministrativeSex(masAdministrativeSex);
	}

	public boolean deleteAdministrativeSex(int administrativeSexId,
			Map<String, Object> generalMap) {
		return generalMasterDataService.deleteAdministrativeSex(
				administrativeSexId, generalMap);
	}

	public boolean editAdministrativeSexToDatabase(
			Map<String, Object> generalMap) {
		return generalMasterDataService
				.editAdministrativeSexToDatabase(generalMap);
	}

	// ------------------------------Admission
	// Type---------------------------------
	public boolean addAdmissionType(MasAdmissionType masAdmissionType) {
		return generalMasterDataService.addAdmissionType(masAdmissionType);
	}

	public boolean deleteAdmissionType(int admissionTypeId,
			Map<String, Object> generalMap) {
		return generalMasterDataService.deleteAdmissionType(admissionTypeId,
				generalMap);
	}

	public boolean editAdmissionTypeToDatabase(Map<String, Object> generalMap) {
		return generalMasterDataService.editAdmissionTypeToDatabase(generalMap);
	}

	public Map<String, Object> searchAdmissionType(String admissionTypeCode,
			String admissionTypeName) {
		return generalMasterDataService.searchAdmissionType(admissionTypeCode,
				admissionTypeName);
	}

	public Map<String, Object> showAdmissionTypeJsp() {
		return generalMasterDataService.showAdmissionTypeJsp();
	}

	public Map<String, Object> getConnection() {
		return generalMasterDataService.getConnection();
	}

	// ----------------------------------------------------------------------

	public GeneralMasterDataService getGeneralMasterDataService() {
		return generalMasterDataService;
	}

	public void setGeneralMasterDataService(
			GeneralMasterDataService generalMasterDataService) {
		this.generalMasterDataService = generalMasterDataService;
	}

	@Override
	public Map<String, Object> showImmunizationJsp() {
		return generalMasterDataService.showImmunizationJsp();
	}

	@Override
	public boolean addImmunization(MasImmunization masImmunization) {
		return generalMasterDataService.addImmunization(masImmunization);
	}

	@Override
	public boolean editImmunizationToDatabase(Map<String, Object> generalMap) {
		return generalMasterDataService.editImmunizationToDatabase(generalMap);
	}

	@Override
	public boolean deleteImmunization(int immunizationId,Map<String, Object> generalMap) {
		return generalMasterDataService.deleteImmunization(immunizationId, generalMap);
	}

	@Override
	public Map<String, Object> searchImmunization(String immunizationCode,String immunizationName) {
		return generalMasterDataService.searchImmunization(immunizationCode,immunizationName);
	}

	@Override
	public Map showDivisionJsp() {
		// TODO Auto-generated method stub
		return  generalMasterDataService.showDivisionJsp();
	}

	@Override
	public boolean addDivision(MasDivision masDivision) {
		// TODO Auto-generated method stub
		return  generalMasterDataService.addDivision(masDivision);
	}

	@Override
	public boolean editDivisionToDatabase(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return  generalMasterDataService.editDivisionToDatabase(generalMap);
	}

	@Override
	public boolean deleteDivision(int divisionId, Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return  generalMasterDataService.deleteDivision(divisionId, generalMap);
	}
	public Map<String, Object> searchDivision(String divisionCode,
			String divisionName) {
		return generalMasterDataService.searchDivision(divisionCode,
				divisionName);
	}

	@Override
	public Map showGradeJsp() {
		// TODO Auto-generated method stub
		return   generalMasterDataService.showGradeJsp();
	}

	@Override
	public boolean addGrade(MasGrade masGrade) {
		// TODO Auto-generated method stub
		 return  generalMasterDataService.addGrade(masGrade);
	}

	@Override
	public Map<String, Object> searchGrade(String gradeCode, String gradeName) {
		// TODO Auto-generated method stub
		 return  generalMasterDataService.searchGrade(gradeCode, gradeName);
	}

	@Override
	public boolean editGrade(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		 return  generalMasterDataService.editGrade(generalMap);
	}

	@Override
	public boolean deleteGrade(int gradeId, Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		 return  generalMasterDataService.deleteGrade(gradeId, generalMap);
	}

	@Override
	public Map<String, Object> showEmployeeTypeJsp() {
		// TODO Auto-generated method stub
		return generalMasterDataService.showEmployeeTypeJsp();
	}

	@Override
	public boolean deleteEmployeeType(int employeeTypeId,
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return generalMasterDataService.deleteEmployeeType(employeeTypeId, generalMap);
	}

	@Override
	public boolean editEmployeeTypeToDatabase(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return generalMasterDataService.editEmployeeTypeToDatabase(generalMap);
	}

	@Override
	public Map<String, Object> searchEmployeeType(String employeeTypeCode,
			String employeeTypeName) {
		// TODO Auto-generated method stub
		return generalMasterDataService.searchEmployeeType(employeeTypeCode, employeeTypeName);
	}

	@Override
	public boolean addEmployeeType(MasEmployeeType masEmployeeType) {
		// TODO Auto-generated method stub
		return generalMasterDataService.addEmployeeType(masEmployeeType);
	}

	@Override
	public Map<String, Object> searchImpanneledHospital(
			String impanneledHospitalCode, String impanneledHospitalName) {
		// TODO Auto-generated method stub
		return generalMasterDataService.searchImpanneledHospital(impanneledHospitalCode, impanneledHospitalName);
	}

	@Override
	public Map<String, Object> showImpanneledHospitalJsp() {
		// TODO Auto-generated method stub
		return generalMasterDataService.showImpanneledHospitalJsp();
	}

	@Override
	public boolean deleteImpanneledHospital(int impanneledHospitalId,
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return generalMasterDataService.deleteImpanneledHospital(impanneledHospitalId, generalMap);
	}

	@Override
	public boolean editImpanneledHospitalToDatabase(
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return generalMasterDataService.editImpanneledHospitalToDatabase(generalMap);
	}

	@Override
	public boolean addImpanneledHospital(
			MasImpanneledHospital masImpanneledHospital) {
		// TODO Auto-generated method stub
		return generalMasterDataService.addImpanneledHospital(masImpanneledHospital);
	}

	@Override
	public Map showZonalJsp() {
		// TODO Auto-generated method stub
		return  generalMasterDataService.showZonalJsp();
	}

	@Override
	public boolean addZonal(MasZonal masZonal) {
		// TODO Auto-generated method stub
		return  generalMasterDataService.addZonal(masZonal);
	}

	@Override
	public boolean editZonalToDatabase(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return  generalMasterDataService.editZonalToDatabase(generalMap);
	}

	@Override
	public boolean deleteZonal(int zonalId, Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return  generalMasterDataService.deleteZonal(zonalId, generalMap);
	}
	public Map<String, Object> searchZonal(String zonalCode,
			String zonalName) {
		return generalMasterDataService.searchZonal(zonalCode,
				zonalName);
	}

	@Override
	public String getHospitalName(int hospitalId) {
		return generalMasterDataService.getHospitalName(hospitalId);
	}

	@Override
	public Map<String, Object> showWardImpanneledHospitalJsp() {
		return generalMasterDataService.showWardImpanneledHospitalJsp();
	}

	@Override
	public Map<String, Object> checkForExistingWardImpanneledHospital(
			Map<String, Object> generalMap) {
		return generalMasterDataService.checkForExistingWardImpanneledHospital(generalMap);
	}

	@Override
	public boolean addWardImpanneledHospitalJsp(
			MasWardImpanneledHospital masWardImpanneledHospital) {
		return generalMasterDataService.addWardImpanneledHospitalJsp(masWardImpanneledHospital);
	}

	@Override
	public boolean editWardImpanneledHospital(Map<String, Object> generalMap) {
		return generalMasterDataService.editWardImpanneledHospital(generalMap);
	}

	@Override
	public boolean deleteWardImpanneledHospital(int wardImpanneledHospitalId,
			Map<String, Object> generalMap) {
		return generalMasterDataService.deleteWardImpanneledHospital(wardImpanneledHospitalId, generalMap);
	}

	@Override
	public Map<String, Object> searchWardImpanneledHospital(
			int impanneledHospitalSearch) {
		return generalMasterDataService.searchWardImpanneledHospital(impanneledHospitalSearch);
	}
	
	@Override
	public Map showProposedMPRJsp() {
		// TODO Auto-generated method stub
		return  generalMasterDataService.showProposedMPRJsp();
	}

	@Override
	public boolean addProposedMPR(MasProposedMPR masProposedMPR) {
		// TODO Auto-generated method stub
		return  generalMasterDataService.addProposedMPR(masProposedMPR);
	}

	@Override
	public boolean editProposedMPRToDatabase(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return  generalMasterDataService.editProposedMPRToDatabase(generalMap);
	}

	@Override
	public boolean deleteProposedMPR(int proposedMPRId, Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return  generalMasterDataService.deleteProposedMPR(proposedMPRId, generalMap);
	}
	public Map<String, Object> searchProposedMPR(String proposedMPRCode,
			String proposedMPRName) {
		return generalMasterDataService.searchProposedMPR(proposedMPRCode,
				proposedMPRName);
	}
}
