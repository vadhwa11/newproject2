package jkt.hms.ot.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.AnesthesiaRecordDocument;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.util.Box;

@SuppressWarnings("unchecked")
public interface OTHandlerService {

	Map<String, Object> getPacClearanceList(Map mapForDS);

	Map<String, Object> searchpatient(Map mapForDS);

	Map<String, Object> showPreAnesthesiaForm(Map mapForDS);

	Map<String, Object> showAllergy(Box box, Map<String, Object> dataMap);
	
	Map<String, Object> submitPreAnesthesiaDetails(Map mapForDS);

	Map<String, Object> showWaitingListForSurgery(Map mapForDS);
	
	Map<String, Object> showPACClearedListForOTBooking(Map mapForDS);
	
	Map<String, Object> searchpatientForOTBooking(Map mapForDS);

	Map<String, Object> showOTBookingJsp(Map mapForDS);

	Map<String, Object> submitOTBookingDetails(Map mapForDS);

	Map<String, Object> getSurgeonListForAutoComplete(Map mapForDS);

	Map<String, Object> searchPatientDetailsForDisposal(Map mapForDS);

	Map<String, Object> showHumanBodyPartsDisposalJsp(Map mapForDS);

	boolean submitHumanBodyPartsDisposal(Map mapForDS);

	Map<String, Object> searchHumanBodyPartsDisposal(Map mapForDS);

	Map<String, Object> getEntryNoListForHumanBodyPartsDisposal(Map mapForDS);

	Map<String, Object> showEmergencyOTBookingJsp(Map mapForDS);

	Map<String, Object> searchPatientDetailsForEmergencyOTBooking(Map mapForDS);

	boolean submitEmergencyOTBookingDetails(Map mapForDS);

	Map<String, Object> getInvestigationDetails(Map mapForDS);

	Map<String, Object> searchOTPreAnesthesiaDetails(Map mapForDS);

	Map<String, Object> viewPreAnesthesiaDetails(Map mapForDS);

	/**
	 * -------------------------------- OT LIST CHANGE JSP
	 * ---------------------------------
	 * 
	 * @param mapForDS
	 * @return
	 */

	Map<String, Object> showOTListChangeJsp(Map<String, Object> mapForDS);

	Map<String, Object> getOTSchedule(Map<String, Object> mapForDS);

	Map<String, Object> changeOTSchedule(Map<String, Object> map);

	Map<String, Object> updateOTSchedule(Map<String, Object> mapForDS);

	Map<String, Object> getOTScheduleForUpdation(Map dataMap);
	
	Map<String, Object> cancelOTSchedule(Box box);

	/**
	 * -------------------------- PRE- ANAESTHESIA NOTES ENTRY PROCEDURE
	 * ----------------------
	 */

	Map<String, Object> searchOtPatientDetails(Map<String, Object> mapForDS);

	Map<String, Object> showPreAneaesthesiaProcNotesEntryJsp(
			Map<String, Object> mapForDS);

	Map<String, Object> submitPreAneaesthesiaProcNotesEntryJsp(Map<String, Object> mapForDS
			);

	Map<String, Object> getNomenclature(String storeItem);

	Map<String, Object> getStoreItemForAutoComplete(Map<String, Object> map);

	/**
	 * --------------------------------------OT Procedure Notes Entry
	 * ------------------------
	 * 
	 * @param mapForDS
	 * @return
	 */
	Map<String, Object> showOtProcedureNotesEntryJsp(
			Map<String, Object> mapForDS);

	Map<String, Object> getEmpNameForAutoComplete(Map<String, Object> map);

	Map<String, Object> submitOtProcedureNotesEntryJsp(Box box,
			List<Integer> employeeId);

	List<Object> getYearlySerialNoList(Map<String, Object> detailsMap);

	List<String> getOtProcHinNoList(String serviceNo);

	List<Object> getOtProcPatientDetailList(Map<String, Object> detailsMap);

	/**
	 * -------------------------------- OT Specimen JSP
	 * ---------------------------------
	 * 
	 * @param mapForDS
	 * @return
	 */

	Map<String, Object> searchSpecimenPatientDetails(
			Map<String, Object> mapForDS);

	Map<String, Object> showSpecimenJspForHin(Map<String, Object> mapForDS);

	// ----------------------------- Ot Post Anaesthesia Patient Details By
	// Mansi------------------------------

	Map<String, Object> searchPostAnaesthesiaPatientDetails(
			Map<String, Object> mapForDS);

	Map<String, Object> showPostAnaesthesiaJspForHin(
			Map<String, Object> mapForDS);

	String getYearlySeqForDisplay();

	String getMonthlySeqForDisplay();

	Map<String, Object> showPACDetailJsp(int orderNo, int hinId, int visitId);

	// Map<String, Object> showPACDetailJsp(int orderNo, int hinId);

	Map<String, Object> getChargeCodeValue(String chargeCodeName);

	Map<String, Object> getSurgeyForAutoComplete(Map<String, Object> mapForDS);

	Map<String, Object> getEmpValue(String empName);

	Map<String, Object> getSurgeonForAutoComplete(Map<String, Object> mapForDS);

	Map<String, Object> getItemValue(String nomenclature);

	Map<String, Object> getItemForAutoComplete(Map<String, Object> map);

	Map<String, Object> submitOtPostAnesthesiaProcedure(Map<String, Object> mapForDS,
			Box box);

	Map<String, Object> getItemListForAutoComplete(Map<String, Object> map);

	Map<String, Object> getItemList(Map<String, Object> map);

	Map<String, Object> showOtPostAnesthesiaProcedure(
			Map<String, Object> mapForDS);

	List<Object> getVisitNoList(Map<String, Object> detailsMap);

	List<Object> getHinNoList(String serviceNo);

	// ----------------------------- End------------------------------

	// ----------------------------- Specimen Dispatch Entry Patient Details By
	// Mansi------------------------------

	Map<String, Object> searchSpecimenDispatchEntryPatientDetails(
			Map<String, Object> mapForDS);

	Map<String, Object> showSpecimenDispatchEntryJspForHin(
			Map<String, Object> mapForDS);

	String getEntryNoForDisplay();

	boolean submitOtSpecimenDispatchEntry(Map<String, Object> mapForDS);

	List<Object> getEntryNoList(Map<String, Object> detailsMap);

	List<Object> getEntryHinNoList(String serviceNo);

	Map<String, Object> showOtSpecimenDispatchEntry(Map<String, Object> mapForDS);

	boolean updateOtSpecimenDispatchEntry(Map<String, Object> mapForDS);

	boolean updateOtPostAnesthesiaProcedure(Map<String, Object> mapForDS);

	Map<String, Object> showPACDetailInJsp(int orderNo, int hinId,
			int inpatientId);

	// ----------------------------- End------------------------------

	List<Object> getPreAnaesthesiaYearlySerialNoList(
			Map<String, Object> detailsMap);

	List<String> getPreAnaesthesiaHinNoList(String serviceNo);

	// ----------------------------- Common Report------------------------------
	Map<String, Object> getConnectionForReport();

	Map<String, Object> printPAC(int hinId);

	Map<String, Object> getDetailsForSurgeryEnquiry();

	Map<String, Object> getSurgeryDetailsForEnquiry(
			Map<String, Object> detailsMap);

	Map<String, Object> getSurgeryDetails(Box box);

	Map<String, Object> updateOtProcedureNotesEntryJsp(Box box,
			List<Integer> employeeId);

	Map<String, Object> getEmpValueForPostAnesthesia(
			Map<String, Object> mapForDs);

	Map<String, Object> orderSeqChange(Map<String, Object> mapForDs);

	Map<String, Object> getOtListData();

	Map<String, Object> updateOTChanges(Map<String, Object> mapForDs);

	Map<String, Object> getActualOTPerformedSchedule(
			Map<String, Object> mapForDS);

	Map<String, Object> updateSurgeryDoneStatus(Box box);

	boolean updateHumanBodyPartsDisposal(Map mapForDS);

	Map<String, Object> submitAnesthesiologist(Map<String, Object> mapForDs);

	Map<String, Object> getotAnesDetails(Date surDate);

	boolean updatePreAnesthesiaDetails(Map mapForDS);

	Map<String, Object> getActualOTPerformedScheduleForDisplay(
			Map<String, Object> mapForDS);
	public Map<String, Object>	getAnesthesiologistForAutoComplete(Map<String, Object> map);
	
	Map<String, Object> displayDepartmentOT(Box box);
	
	Map<String, Object> displayOtTable(Box box);
	
	Map<String, Object> fillMemberForName(Map dataMap);
	
	Map<String, Object> showCalenderForOt(Map<String, Object> mapForDS);
	
	Map<String, Object> checkSurgeryTime(Map<String, Object> dataMap);
	
	Map<String, Object> PACClearanceListForConsultation(Map<String, Object> dataMap);
	
	Map<String, Object>  showPreAnethesiaFormForAdvice(Map<String, Object> dataMap);
	
	boolean  submitDoctorAdviceForPACClearance(Map<String, Object> dataMap);
	
	Map<String, Object>  getAnesthesiaRecordWaitingList(Map<String, Object> dataMap);
	
	public List<UploadDocuments> getDocumentList(int uploadedDocumentId);	
	
	Map<String, Object> searchPreOperativeCheckList(Map<String, Object> mapForDS);
	
	Map<String, Object> showPreOperativeCheckListEntryJsp(
			Map<String, Object> mapForDS);

	Map<String, Object> submitPreOperativeCheckList(Map<String, Object> mapForDS);
	
	Map<String, Object> showPostAneaesthesiaProcNotesEntryJsp(
			Map<String, Object> mapForDS);
	
	Map<String, Object> showConsentFormEntryJsp(Map<String, Object> mapForDS);
	
	Map<String, Object> searchOtPatientConsentDetails(
			Map<String, Object> mapForDS);
	
	Map<String, Object> submitDocumentForOT(Map<String, Object> dataMap);
	
	Map<String, Object> transferToWardWaitingList(Map<String, Object> dataMap);
	
	Map<String, Object> showOtPatientToWard(Map<String, Object> dataMap);
	
	boolean submitTransferInformation(Map<String, Object> transferMap);

	String getHospitalName(int hospitalId);

	Map<String, Object> showOtBookingRegisterJsp();

	Map<String, Object> showNewCaseSheetJsp(Map<String, Object> dataMap);
	
	Map<String, Object> getPreAnesthesiaDeials(Map<String, Object> mapForDs);
	
	Map<String, Object> getPostAnesthesiaDeials(Map<String, Object> mapForDs); 
	
	
}
