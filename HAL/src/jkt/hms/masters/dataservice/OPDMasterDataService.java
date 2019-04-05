package jkt.hms.masters.dataservice;

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
import jkt.hms.util.Box;

public interface OPDMasterDataService {

	// ****************************************** Start Of OPD Template by Mansi
	// ****************************//

	Map<String, Object> showOpdTemplateJsp();

	boolean addOpdTemplate(OpdTemplate opdTemplate);

	boolean editOpdTemplateToDatabase(Map<String, Object> generalMap);

	boolean deleteOpdTemplate(int templateId, Map<String, Object> generalMap);

	Map<String, Object> searchOpdTemplate(String templateCode,
			String templateName);

	// ****************************************** End Of OPD Template by Mansi
	// ****************************//

	// ****************************************** Start Of OPD Treatment Holiday
	// by Mansi ****************************//

	Map<String, Object> searchOpdHoliday(String holidayCode, String holidayName);

	Map<String, Object> showOpdHolidayJsp();

	boolean addOpdHoliday(OpdHoliday opdHoliday);

	boolean editOpdHolidayToDatabase(Map<String, Object> generalMap);

	boolean deleteOpdHoliday(int holidayId, Map<String, Object> generalMap);

	// ****************************************** Start Of OPD Treatment Holiday
	// by Mansi ****************************//

	// ****************************************** Start Of OPD Treatment
	// Template by Mansi ****************************//

	Map<String, Object> showOpdTemplateTreatmentJsp();

	boolean addOpdTemplateTreatment(OpdTemplateTreatment opdTemplateTreatment);

	boolean editOpdTemplateTreatment(Map<String, Object> generalMap);

	boolean deleteOpdTemplateTreatment(int templateTreatmentId,
			Map<String, Object> generalMap);

	Map<String, Object> searchOpdTemplateTreatment(String templateGroup);

	Map<String, Object> getTemplateGroup(int templateId, int deptId);

	Map<String, Object> fillItemsInGrid(Map<String, Object> dataMap);

	Map<String, Object> getItemList(Map<String, Object> map);

	// ****************************************** End Of OPD Treatment Template
	// by Mansi ****************************//

	Map<String, Object> searchOpdInstructionTreatment(
			String opdInstructionTreatmentCode,
			String opdInstructionTreatmentName);

	Map<String, Object> showOpdInstructionTreatmentJsp();

	boolean addOpdInstructionTreatment(
			OpdInstructionTreatment opdInstructionTreatment);

	boolean editOpdInstructionTreatmentToDatabase(Map<String, Object> generalMap);

	boolean deleteOpdInstructionTreatment(int opdInstructionTreatmentId,
			Map<String, Object> generalMap);

	// ---------------------------------------End of methods by
	// Vikas-----------------------------------

	Map<String, Object> getInvestigationTemplateGroup(int templateId, int deptId);

	Map<String, Object> fillChargeCodeInGrid(Map<String, Object> dataMap);

	Map<String, Object> getChargeCodeList(Map<String, Object> map);

	Map<String, Object> showOpdTemplateInvestigationJsp();

	boolean addOpdTemplateInvestigation(
			OpdTemplateInvestigation opdTemplateInvestigation);

	boolean editOpdTemplateInvestigation(Map<String, Object> generalMap);

	boolean deleteOpdTemplateInvestigation(int templateInvestigationId,
			Map<String, Object> generalMap);

	// ******************************************Start Methods by by Vishal
	// ****************************//
	// ------------------------Equipment
	// Master-----------------------------------------

	Map<String, Object> searchOpdEquipment(String equipmentCode,
			String equipmentName);

	Map<String, Object> showOpdEquipmentJsp();

	boolean addOpdEquipment(AppEquipmentMaster appEquipmentMaster);

	boolean editOpdEquipmentToDatabase(Map<String, Object> generalMap);

	boolean deleteOpdEquipment(int equipmentId, Map<String, Object> generalMap);

	// ------------------------Vaccine
	// Master-----------------------------------------

	Map<String, Object> searchOpdVaccin(String vaccinCode, String vaccinName);

	Map<String, Object> showOpdVaccinJsp();

	boolean addOpdVaccin(OpdVaccinMst opdVaccin);

	boolean editOpdVaccinToDatabase(Map<String, Object> generalMap);

	boolean deleteOpdVaccin(int vaccinId, Map<String, Object> generalMap);

	Map<String, Object> getConnection();

	// ****************************************** End Of Methods by Vishal
	// ****************************//

	Map<String, Object> searchOpdFrequency(String opdFrequencyCode,
			String opdFrequencyName);

	Map<String, Object> showOpdFrequencyJsp();

	boolean addOpdFrequency(MasOpdFrequency opdFrequency);

	boolean editOpdFrequencyToDatabase(Map<String, Object> generalMap);

	boolean deleteOpdFrequency(int opdFrequencyId,
			Map<String, Object> generalMap);

	Map<String, Object> showOpdPhysiotherapyTreatmentJsp();

	Map<String, Object> searchOpdPhysiotherapyTreatment(String treatmentCode,
			String treatmentName);

	boolean addOpdPhysiotherapyTreatment(
			MasPhysiotherapyTreatment masPhysiotherapyTreatment);

	boolean editOpdPhysiotherapyTreatmentToDatabase(
			Map<String, Object> generalMap);

	boolean deleteOpdPhysiotherapyTreatment(int treatmentId,
			Map<String, Object> generalMap);

	boolean addAllergyType(MasAllergyType masAllergyType);

	Map<String, Object> showAllergyTypeJsp();

	boolean submitDifferentialDisease(Box box);
	
	boolean editAllergyTypeToDatabase(Map<String, Object> generalMap);

	boolean deleteAllergyType(int allergyTypeId, Map<String, Object> generalMap);
	
	Map<String, Object> searchAllergyType(String allergyTypeCode,
			String allergyTypeName);
	
	

	boolean addFamilyHistory(PatientFamilyHistory patientFamilyHistory);

	Map<String, Object> showFamilyHistoryJsp();

	boolean deleteFamilyHistory(int familyHistoryId,
			Map<String, Object> generalMap);

	boolean editFamilyHistoryToDatabase(Map<String, Object> generalMap);

	Map<String, Object> searchFamilyHistory(String familyHistoryCode,
			String familyHistoryName);
	
	

	Map<String, Object> searchPresentComplaint(
			String patientPresentComplaintName);

	Map showPresentComplaintJsp();

	boolean addPresentComplaint(PatientFamilyHistory patientFamilyHistory);

	boolean editPresentComplaintToDatabase(Map<String, Object> generalMap);

	boolean deletePresentComplaint(int patientFamilyHistoryId,
			Map<String, Object> generalMap);
	
	Map<String, Object> showOpdQuestionnaireJsp();
	
	Map<String, Object> addOpdQuestionnaire(Box box);

	Map<String, Object> updateOpdQuestionnaire(Box box);
	
	Map<String, Object> searchOpdQuestionnaire(int departmentId);

	boolean deleteOpdQuestionnaire(int opdQuestionId,
			Map<String, Object> generalMap);

	Map<String, Object> showQuestionHeadingJsp();

	Map<String, Object> searchQuestionHeading(String questionHeadingCode,
			String questionHeadingName);

	boolean addQuestionHeading(MasQuestionHeading masQuestionHeading);

	boolean editQuestionHeadingToDatabase(Map<String, Object> generalMap);
	
	boolean deleteQuestionHeading(int questionHeadingId,
			Map<String, Object> generalMap);
	Map<String, Object> showQaOptionValueJsp();

	Map<String, Object> searchQaOptionValue(String qaOptionValueCode,
			String qaOptionValueName);

		
	boolean deleteQaOptionValue(int qaOptionValueId,
			Map<String, Object> generalMap);

	Map<String, Object> editQaOptionValueToDatabase(Box box);

	Map<String, Object> addQaOptionValue(Box box);
	
	Map<String, Object> getVaccinationList(Box box);
	
	Map<String, Object> checkExistingVaccineMaster(
			Map<String, Object> generalMap);

	Map<String, Object> showNewOpdVaccinJsp();
	
	Map<String, Object> checkExistingVaccineNewMaster(Map<String, Object> generalMap);
	
	boolean addOpdVaccinNew(MasVaccineItem masVaccine);
	
	boolean editNewOpdVaccinToDatabase(Map<String, Object> generalMap);
	
	boolean deleteNewOpdVaccin(int vaccinId, Map<String, Object> generalMap);
	
	Map<String, Object> showTreatmentAdviceJsp();

	Map<String, Object> searchTreatmentAdvice(String familyHistoryName);

	boolean addTreatmentAdvice(PatientFamilyHistory patientFamilyHistory);

	boolean editTreatmentAdviceToDatabase(Map<String, Object> generalMap);

	boolean deleteTreatmentAdvice(int treatmentAdviceId,
			Map<String, Object> generalMap);

	Map<String, Object> searchQaOptions(Box box);
	
	
}
