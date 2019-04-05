package jkt.hms.masters.handler;

import java.util.Map;

import jkt.hms.masters.business.AppEquipmentMaster;
import jkt.hms.masters.business.MasAllergyType;
import jkt.hms.masters.business.MasOpdFrequency;
import jkt.hms.masters.business.MasPhysiotherapyTreatment;
import jkt.hms.masters.business.MasQaOptionValue;
import jkt.hms.masters.business.MasQuestionHeading;
import jkt.hms.masters.business.MasVaccineItem;
import jkt.hms.masters.business.OpdHoliday;
import jkt.hms.masters.business.OpdInstructionTreatment;
import jkt.hms.masters.business.OpdTemplate;
import jkt.hms.masters.business.OpdTemplateInvestigation;
import jkt.hms.masters.business.OpdTemplateTreatment;
import jkt.hms.masters.business.OpdVaccinMst;
import jkt.hms.masters.business.PatientFamilyHistory;
import jkt.hms.masters.dataservice.OPDMasterDataService;
import jkt.hms.util.Box;

public class OPDMasterHandlerServiceImpl implements OPDMasterHandlerService {

	OPDMasterDataService opdMasterDataService = null;

	// ****************************************** Start Of OPD Template by Mansi
	// ****************************//

	public boolean addOpdTemplate(OpdTemplate opdTemplate) {
		return opdMasterDataService.addOpdTemplate(opdTemplate);
	}

	public boolean deleteOpdTemplate(int templateId,
			Map<String, Object> generalMap) {
		return opdMasterDataService.deleteOpdTemplate(templateId, generalMap);
	}

	public boolean editOpdTemplateToDatabase(Map<String, Object> generalMap) {
		return opdMasterDataService.editOpdTemplateToDatabase(generalMap);
	}

	public Map<String, Object> showOpdTemplateJsp() {
		return opdMasterDataService.showOpdTemplateJsp();
	}

	public Map<String, Object> searchOpdTemplate(String templateCode,
			String templateName) {
		return opdMasterDataService.searchOpdTemplate(templateCode,
				templateName);
	}

	public boolean addOpdHoliday(OpdHoliday opdHoliday) {
		return opdMasterDataService.addOpdHoliday(opdHoliday);
	}

	public boolean deleteOpdHoliday(int holidayId,
			Map<String, Object> generalMap) {
		return opdMasterDataService.deleteOpdHoliday(holidayId, generalMap);
	}

	public boolean editOpdHolidayToDatabase(Map<String, Object> generalMap) {
		return opdMasterDataService.editOpdHolidayToDatabase(generalMap);
	}

	public Map<String, Object> searchOpdHoliday(String holidayCode,
			String holidayName) {
		return opdMasterDataService.searchOpdHoliday(holidayCode, holidayName);
	}

	public Map<String, Object> showOpdHolidayJsp() {
		return opdMasterDataService.showOpdHolidayJsp();
	}

	public Map<String, Object> showOpdTemplateTreatmentJsp() {
		return opdMasterDataService.showOpdTemplateTreatmentJsp();
	}

	// ****************************************** End Of OPD Template by Mansi
	// ****************************//

	// ****************************************** Start Of OPD Treatment
	// Template by Mansi ****************************//

	public boolean addOpdTemplateTreatment(
			OpdTemplateTreatment opdTemplateTreatment) {
		return opdMasterDataService
				.addOpdTemplateTreatment(opdTemplateTreatment);
	}

	public boolean deleteOpdTemplateTreatment(int templateTreatmentId,
			Map<String, Object> generalMap) {
		return opdMasterDataService.deleteOpdTemplateTreatment(
				templateTreatmentId, generalMap);
	}

	public boolean editOpdTemplateTreatment(Map<String, Object> generalMap) {
		return opdMasterDataService.editOpdTemplateTreatment(generalMap);
	}

	public Map<String, Object> searchOpdTemplateTreatment(String templateGroup) {
		return opdMasterDataService.searchOpdTemplateTreatment(templateGroup);
	}

	public Map<String, Object> getTemplateGroup(int templateId, int deptId) {
		return opdMasterDataService.getTemplateGroup(templateId, deptId);
	}

	public Map<String, Object> fillItemsInGrid(Map<String, Object> dataMap) {
		return opdMasterDataService.fillItemsInGrid(dataMap);
	}

	public Map<String, Object> getItemList(Map<String, Object> map) {
		return opdMasterDataService.getItemList(map);
	}

	// ****************************************** End Of OPD Treatment Template
	// by Mansi ****************************//

	public boolean addOpdInstructionTreatment(
			OpdInstructionTreatment opdInstructionTreatment) {
		return opdMasterDataService
				.addOpdInstructionTreatment(opdInstructionTreatment);
	}

	public boolean deleteOpdInstructionTreatment(int opdInstructionTreatmentId,
			Map<String, Object> generalMap) {
		return opdMasterDataService.deleteOpdInstructionTreatment(
				opdInstructionTreatmentId, generalMap);
	}

	public boolean editOpdInstructionTreatmentToDatabase(
			Map<String, Object> generalMap) {
		return opdMasterDataService
				.editOpdInstructionTreatmentToDatabase(generalMap);
	}

	public Map<String, Object> searchOpdInstructionTreatment(
			String opdInstructionTreatmentCode,
			String opdInstructionTreatmentName) {
		return opdMasterDataService.searchOpdInstructionTreatment(
				opdInstructionTreatmentCode, opdInstructionTreatmentName);
	}

	public Map<String, Object> showOpdInstructionTreatmentJsp() {
		return opdMasterDataService.showOpdInstructionTreatmentJsp();
	}

	// --------------------------------------------End of methods By
	// Vikas-------------------------------------

	public Map<String, Object> getInvestigationTemplateGroup(int templateId,
			int deptId) {
		return opdMasterDataService.getInvestigationTemplateGroup(templateId,
				deptId);
	}

	public Map<String, Object> fillChargeCodeInGrid(Map<String, Object> dataMap) {
		return opdMasterDataService.fillChargeCodeInGrid(dataMap);
	}

	public Map<String, Object> getChargeCodeList(Map<String, Object> map) {
		return opdMasterDataService.getChargeCodeList(map);
	}

	public Map<String, Object> showOpdTemplateInvestigationJsp() {
		return opdMasterDataService.showOpdTemplateInvestigationJsp();
	}

	public boolean addOpdTemplateInvestigation(
			OpdTemplateInvestigation opdTemplateInvestigation) {
		return opdMasterDataService
				.addOpdTemplateInvestigation(opdTemplateInvestigation);
	}

	public boolean deleteOpdTemplateInvestigation(int templateInvestigationId,
			Map<String, Object> generalMap) {
		return opdMasterDataService.deleteOpdTemplateInvestigation(
				templateInvestigationId, generalMap);
	}

	public boolean editOpdTemplateInvestigation(Map<String, Object> generalMap) {
		return opdMasterDataService.editOpdTemplateInvestigation(generalMap);
	}

	public OPDMasterDataService getOpdMasterDataService() {
		return opdMasterDataService;
	}

	public void setOpdMasterDataService(
			OPDMasterDataService opdMasterDataService) {
		this.opdMasterDataService = opdMasterDataService;
	}

	// ****************************************** Start of Equipment Master by
	// vishal****************************//
	// -----------------------Equipment master-------------
	public Map<String, Object> showOpdEquipmentJsp() {
		return opdMasterDataService.showOpdEquipmentJsp();
	}

	public Map<String, Object> searchOpdEquipment(String equipmentCode,
			String equipmentName) {
		return opdMasterDataService.searchOpdEquipment(equipmentCode,
				equipmentName);
	}

	public boolean addOpdEquipment(AppEquipmentMaster appEquipmentMaster) {
		return opdMasterDataService.addOpdEquipment(appEquipmentMaster);
	}

	public boolean editOpdEquipmentToDatabase(Map<String, Object> generalMap) {
		return opdMasterDataService.editOpdEquipmentToDatabase(generalMap);
	}

	public boolean deleteOpdEquipment(int equipmentId,
			Map<String, Object> generalMap) {
		return opdMasterDataService.deleteOpdEquipment(equipmentId, generalMap);
	}

	// ----------------------Vaccin Master--------------------------------------
	public Map<String, Object> showOpdVaccinJsp() {
		return opdMasterDataService.showOpdVaccinJsp();
	}

	public Map<String, Object> searchOpdVaccin(String vaccinCode,
			String vaccinName) {
		return opdMasterDataService.searchOpdVaccin(vaccinCode, vaccinName);
	}

	public boolean addOpdVaccin(OpdVaccinMst opdVaccin) {
		return opdMasterDataService.addOpdVaccin(opdVaccin);
	}

	public boolean editOpdVaccinToDatabase(Map<String, Object> generalMap) {
		return opdMasterDataService.editOpdVaccinToDatabase(generalMap);
	}

	public boolean deleteOpdVaccin(int vaccinId, Map<String, Object> generalMap) {
		return opdMasterDataService.deleteOpdVaccin(vaccinId, generalMap);
	}

	// ****************************************** End Of Equipment Master by
	// Vishal ****************************//
	public Map<String, Object> getConnection() {
		return opdMasterDataService.getConnection();
	}

	// ****************************************** End Of OPD Treatment Template
	// by Mansi ****************************//

	public boolean addOpdFrequency(MasOpdFrequency opdFrequency) {
		return opdMasterDataService.addOpdFrequency(opdFrequency);
	}

	public boolean deleteOpdFrequency(int opdFrequencyId,
			Map<String, Object> generalMap) {
		return opdMasterDataService.deleteOpdFrequency(opdFrequencyId,
				generalMap);
	}

	public boolean editOpdFrequencyToDatabase(Map<String, Object> generalMap) {
		return opdMasterDataService.editOpdFrequencyToDatabase(generalMap);
	}

	public Map<String, Object> searchOpdFrequency(String opdFrequencyCode,
			String opdFrequencyName) {
		return opdMasterDataService.searchOpdFrequency(opdFrequencyCode,
				opdFrequencyName);
	}

	public Map<String, Object> showOpdFrequencyJsp() {
		return opdMasterDataService.showOpdFrequencyJsp();
	}

	public Map<String, Object> showOpdPhysiotherapyTreatmentJsp() {
		return opdMasterDataService.showOpdPhysiotherapyTreatmentJsp();
	}

	public Map<String, Object> searchOpdPhysiotherapyTreatment(
			String treatmentCode, String treatmentName) {
		return opdMasterDataService.searchOpdPhysiotherapyTreatment(
				treatmentCode, treatmentName);
	}

	public boolean addOpdPhysiotherapyTreatment(
			MasPhysiotherapyTreatment masPhysiotherapyTreatment) {
		return opdMasterDataService
				.addOpdPhysiotherapyTreatment(masPhysiotherapyTreatment);
	}

	public boolean editOpdPhysiotherapyTreatmentToDatabase(
			Map<String, Object> generalMap) {
		return opdMasterDataService
				.editOpdPhysiotherapyTreatmentToDatabase(generalMap);
	}

	public boolean deleteOpdPhysiotherapyTreatment(int treatmentId,
			Map<String, Object> generalMap) {
		return opdMasterDataService.deleteOpdPhysiotherapyTreatment(
				treatmentId, generalMap);
	}

	@Override
	public boolean addAllergyType(MasAllergyType masAllergyType) {
		
		return opdMasterDataService.addAllergyType(masAllergyType);
	}

	@Override
	public Map<String, Object> showAllergyTypeJsp() {
		// TODO Auto-generated method stub
		return opdMasterDataService.showAllergyTypeJsp();
	}

	@Override
	public boolean submitDifferentialDisease(Box box) {
		return opdMasterDataService.submitDifferentialDisease(box);
	}

	@Override
	public boolean editAllergyTypeToDatabase(Map<String, Object> generalMap) {
		return opdMasterDataService.editAllergyTypeToDatabase(generalMap);
	}

	@Override
	public boolean deleteAllergyType(int allergyTypeId,
			Map<String, Object> generalMap) {
		return opdMasterDataService.deleteAllergyType(allergyTypeId, generalMap);
	}

	@Override
	public Map<String, Object> searchAllergyType(String allergyTypeCode,
			String allergyTypeName) {
		return opdMasterDataService.searchAllergyType(allergyTypeCode, allergyTypeName);
	}

	@Override
	public boolean addFamilyHistory(PatientFamilyHistory patientFamilyHistory) {
		return opdMasterDataService.addFamilyHistory(patientFamilyHistory);
	}

	@Override
	public Map<String, Object> showFamilyHistoryJsp() {
		// TODO Auto-generated method stub
		return opdMasterDataService.showFamilyHistoryJsp();
	}

	@Override
	public boolean deleteFamilyHistory(int familyHistoryId,
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return opdMasterDataService.deleteFamilyHistory(familyHistoryId, generalMap);
	}

	@Override
	public boolean editFamilyHistoryToDatabase(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return opdMasterDataService.editFamilyHistoryToDatabase(generalMap);
	}

	@Override
	public Map<String, Object> searchFamilyHistory(String familyHistoryCode,
			String familyHistoryName) {
		// TODO Auto-generated method stub
		return opdMasterDataService.searchFamilyHistory(familyHistoryCode, familyHistoryName);
	}

	@Override
	public Map<String, Object> searchPresentComplaint(
			String patientPresentComplaintName) {
		// TODO Auto-generated method stub
		return opdMasterDataService.searchPresentComplaint(patientPresentComplaintName);
	}

	@Override
	public Map showPresentComplaintJsp() {
		// TODO Auto-generated method stub
		return opdMasterDataService.showPresentComplaintJsp();
	}

	@Override
	public boolean addPresentComplaint(PatientFamilyHistory patientFamilyHistory) {
		// TODO Auto-generated method stub
		return opdMasterDataService.addPresentComplaint(patientFamilyHistory);
	}

	@Override
	public boolean editPresentComplaintToDatabase(Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return opdMasterDataService.editPresentComplaintToDatabase(generalMap);
	}

	@Override
	public boolean deletePresentComplaint(int patientFamilyHistoryId,
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return opdMasterDataService.deletePresentComplaint(patientFamilyHistoryId, generalMap);
	}

	@Override
	public Map<String, Object> showOpdQuestionnaireJsp() {
		return opdMasterDataService.showOpdQuestionnaireJsp();
	}

	@Override
	public Map<String, Object> addOpdQuestionnaire(Box box) {
		return opdMasterDataService.addOpdQuestionnaire(box);
	}

	@Override
	public Map<String, Object> updateOpdQuestionnaire(Box box) {
		return opdMasterDataService.updateOpdQuestionnaire(box);
	}

	@Override
	public Map<String, Object> searchOpdQuestionnaire(int departmentId) {
		return opdMasterDataService.searchOpdQuestionnaire(departmentId);
	}

	@Override
	public boolean deleteOpdQuestionnaire(int opdQuestionId,
			Map<String, Object> generalMap) {
		return opdMasterDataService.deleteOpdQuestionnaire(opdQuestionId, generalMap);
	}

	@Override
	public Map<String, Object> showQuestionHeadingJsp() {
		return opdMasterDataService.showQuestionHeadingJsp();
	}

	@Override
	public Map<String, Object> searchQuestionHeading(
			String questionHeadingCode, String questionHeadingName) {
		return opdMasterDataService.searchQuestionHeading(questionHeadingCode, questionHeadingName);
	}

	@Override
	public boolean addQuestionHeading(MasQuestionHeading masQuestionHeading) {
		return opdMasterDataService.addQuestionHeading(masQuestionHeading);
	}

	@Override
	public boolean editQuestionHeadingToDatabase(Map<String, Object> generalMap) {
		return opdMasterDataService.editQuestionHeadingToDatabase(generalMap);
	}

	@Override
	public boolean deleteQuestionHeading(int questionHeadingId,
			Map<String, Object> generalMap) {
		return opdMasterDataService.deleteQuestionHeading(questionHeadingId, generalMap);
	}
	@Override
	public Map<String, Object> showQaOptionValueJsp() {
		return opdMasterDataService.showQaOptionValueJsp();
	}

	@Override
	public Map<String, Object> searchQaOptionValue(
			String qaOptionValueCode, String qaOptionValueName) {
		return opdMasterDataService.searchQaOptionValue(qaOptionValueCode, qaOptionValueName);
	}

	
	@Override
	public Map<String, Object> searchQaOptions(
			Box box) {
		return opdMasterDataService.searchQaOptions(box);
	}
	
	
	@Override
	public boolean deleteQaOptionValue(int qaOptionValueId,
			Map<String, Object> generalMap) {
		return opdMasterDataService.deleteQaOptionValue(qaOptionValueId, generalMap);
	}

	@Override
	public Map<String, Object> editQaOptionValueToDatabase(Box box) {
		// TODO Auto-generated method stub
		return opdMasterDataService.editQaOptionValueToDatabase(box);
	}

	@Override
	public Map<String, Object> addQaOptionValue(Box box) {
		return opdMasterDataService.addQaOptionValue(box);
	}
	
	@Override
	public Map<String, Object> getVaccinationList(Box box) { 
		return opdMasterDataService.getVaccinationList(box);
	}
	public Map checkExistingVaccineMaster(Map<String, Object> generalMap) {
		return opdMasterDataService.checkExistingVaccineMaster(generalMap);
	}

	public  Map<String, Object>showNewOpdVaccinJsp() {
		// TODO Auto-generated method stub
		return opdMasterDataService.showNewOpdVaccinJsp();

	}	
	
	public  Map<String, Object>checkExistingVaccineNewMaster(Map<String, Object> mapForDS) {
		// TODO Auto-generated method stub
		return opdMasterDataService.checkExistingVaccineNewMaster(mapForDS);

	}	
	public  boolean addOpdVaccinNew(MasVaccineItem masVaccine) {
		return opdMasterDataService.addOpdVaccinNew(masVaccine);

	}

	public boolean editNewOpdVaccinToDatabase(Map<String, Object> generalMap) {
		return opdMasterDataService.editNewOpdVaccinToDatabase(generalMap);
	}

	public boolean deleteNewOpdVaccin(int vaccinId, Map<String, Object> generalMap) {
		return opdMasterDataService.deleteNewOpdVaccin(vaccinId, generalMap);
	}

	@Override
	public Map<String, Object> showTreatmentAdviceJsp() {
		return opdMasterDataService.showTreatmentAdviceJsp();
	}

	@Override
	public Map<String, Object> searchTreatmentAdvice(String familyHistoryName) {
		return opdMasterDataService.searchTreatmentAdvice(familyHistoryName);
	}

	@Override
	public boolean addTreatmentAdvice(PatientFamilyHistory patientFamilyHistory) {
		return opdMasterDataService.addTreatmentAdvice(patientFamilyHistory);
	}

	@Override
	public boolean editTreatmentAdviceToDatabase(Map<String, Object> generalMap) {
		return opdMasterDataService.editTreatmentAdviceToDatabase(generalMap);
	}

	@Override
	public boolean deleteTreatmentAdvice(int treatmentAdviceId,
			Map<String, Object> generalMap) {
		return opdMasterDataService.deleteTreatmentAdvice(treatmentAdviceId, generalMap);
	}

}