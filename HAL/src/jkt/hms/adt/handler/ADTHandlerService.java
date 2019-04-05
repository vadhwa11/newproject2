package jkt.hms.adt.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;

import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;

public interface ADTHandlerService {

	Map<String, Object> getPatientDetails(Map<String, Object> mapForDs);

	Map<String, Object> getAdmissionDetails(int hospitalId);

	Map<String, Object> submitAdmissionInformation(Map<String, Object> admissionMap);

	String getMotherName(String motherAdNo);

	Map<String, Object> saveAttachedAdmission(Map<String, Object> attachMap);
	
	Map<String, Object> getPatientDetailsForTransfer(Map<String, Object> mapForDs);

	Map<String, Object> getTransferDetails(int hospitalId );

	boolean submitTransferInformation(Map<String, Object> transferMap);

	Map<String, Object> getDischargeDetails();
	Map<String, Object> getUserRights(Users userObj);

	Map<String, Object> submitDischargeInformation(Map<String, Object> dischargeMap);

	Map<String, Object> getDetailsForMLC();

	boolean submitMLCDetails(Box box);

	String generateAdNumber(Map<String, Object> adMap);

	String generateMLCNo(Map<String, Object> adMap);

	List<MasDepartment> getDepartmentList();

	Map<String, Object> getDischargePatientList(Map<String, Object> dischargeMap);

	Map<String, Object> getAttachPatientDetails(Map<String, Object> attachPatientMap);
		
	Map<String, Object> dischargePatient(Map<String, Object> detailsMap);

	Map<String, Object> showExpiryDetails(Map<String, Object> patientDetailsMap);
	
	public boolean updateExpiryDetails(Map<String, Object> expiryDetilsMap) ;

	boolean submitExpiryDetails(Map<String, Object> expiryDetilsMap);

	Map<String, Object> getConnectionForReport();

	List getAdmissionNoList(Map<String, Object> detailsMap);

	List<Object> getHinNoList(String serviceNo);

	Map<String, Object> getServiceTypeDepartmentCategory();

	Map<String, Object> getVisitDates(String hinNo);

	Map<String, Object> getDiagnosis(Date visitDate);

	Map<String, Object> getPatientAdmissionDetailsForUpdate(String adNo);

	boolean updateAdmissionInformation(Map<String, Object> admissionMap);

	Map<String, Object> getMlcNo(String hinNo);

	Map<String, Object> getDetailsForSearch(int hospitalId);

	Map<String, Object> getPatientDetailsForDischarge(
			Map<String, Object> mapForDs);

	int getHospitalStaffSLNo();

	boolean saveAdditionalInfoForDischarge(Map<String, Object> parameterMap);

	Map<String, Object> getPatientDiagnosis(String adNo, int inpatientId);

	boolean cancelAdmissionInformation(Map<String, Object> parameterMap);

	Map<String, Object> getSiDiData(Map<String, Object> dataMap);

	Map<String, Object> getDiagnosisAndDocInit(Map<String, Object> dataMap);

	Map<String, Object> chechBed(Map<String, Object> dataMap);

	Map<String, Object> checkAdNoDuplication(Map<String, Object> dataMap);

	Map<String, Object> checkForDuplicateOfAdnoInAttach(Map<String, Object> dataMap);

	Map<String, Object> getIcdWithIcdCode(Map<String, Object> dataMap);

	Map<String, Object> getDischargeDetails(Map<String, Object> dataMap);

	Map<String, Object> getDetailsOfDischarge(Map<String, Object> dataMap);

	Map<String, Object> updateDischarge(Map<String, Object> dateMap);

	Map<String, Object> getICDDetails(Box box);

	Map<String, Object> searchExpiryDetails(Map<String, Object> dataMap);

	Map<String, Object> printExpiryDetails(Map<String, Object> dataMap);

	Map<String, Object> searchPatientDischarge(Map<String, Object> dataMap);

	Map<String, Object> checkCancelAdmissionState(Map<String, Object> dataMap);

	Map<String, Object> checkOffLineAdNoDuplicationFor(Map<String, Object> dataMap);

	Map<String, Object> cancelDischarge(Map<String, Object> dataMap);

	// added by  kalyan
	
	Map<String, Object> showUnitValidateJsp();
	
	Map<String, Object> searchUnit(String unitName, String unitAddress);

	Map<String, Object> getUnitDetails(int id);
	
	Map<String, Object> getNewUnitDetails(Map<String, Object> dataMap);

	Map<String, Object> showUnitSearchJsp(Box box);
	
	Map<String, Object> getMlcDetails(Map<String, Object> parameterMap);
	
	
	Map<String, Object> getFinalDischargePatientList(Map<String, Object> dataMap);
	
	Map<String, Object> canceldischargePatient(Map<String, Object> dataMap);
	
	Map<String, Object> checkTodayTransactions(Map<String, Object> dataMap);
	
	// added by  vineet
	Map<String, Object> showTradeValidateJsp();
	
	Map<String, Object> getTradeDetails(int id);
	
	Map<String, Object> updateUnit(Map<String, Object> dataMap);
	
	Map<String, Object> updateValidateUnit(Map<String, Object> dataMap,Box box);
	Map<String, Object> updateValidateTrade(Map<String, Object> dataMap,Box box);
	
	Map<String, Object> deleteValidateUnit(int unitId);
	Map<String, Object> searchTrade(String unitName);
	Map<String, Object> updateTrade(Map<String, Object> dataMap);
	Map<String, Object> deleteValidateTrade(int unitId);
	public Map<String, Object> showTradeSearchJsp(Box box);
	Map<String, Object> showInjuryReportJsp();
	public void closeHibernateSession();

	Map<String, Object> getHinNoForAdm(String serviceNo);

	Map<String, Object> searchPatientTrack(Box box);

	Map<String, Object> getHinDetailsForAppointment(Box box);

	Map<String, Object> submitPatientAppointment(Box box);

	boolean cancelPatientAppointment(Box box);

	Map<String, Object> searchAppointments(Box box);

	Map<String, Object> getPatientNamesForApp(Box box);

	Map<String, Object> getPatientDetailsForApp(Box box);

	Map<String, Object> showIpAdmissionRegisterGraph(Box box);

	Map<String, Object> showIPRegisterOnScreen(Box box);

	Map<String, Object> getBedStatus(Box box);

	String generateTransactionSequence(Map<String, Object> map, Session ses) throws Exception;

	Map<String, Object> checkAdNoDuplicationHAL(Map<String, Object> dataMap,
			Transaction tx, Session ses);

	Map<String, Object> submitAdmissionInformationHAL(
			Map<String, Object> admissionMap, Transaction tx, Session ses);

	Map<String, Object> getDetailsForMLCHAL(Transaction tx, Session ses);

	String generateMLCNoHAL(Map<String, Object> adMap, Transaction tx,
			Session ses);

	Map<String, Object> getPatientDetailsHAL(Map<String, Object> mapForDs,
			Transaction tx, Session ses);

	Map<String, Object> getAttachPatientDetailsHAL(
			Map<String, Object> attachPatientMap, Transaction tx, Session ses);

	Map<String, Object> getAdmissionDetailsHAL(int hospitalId, Transaction tx,
			Session ses);

	Session getSes();

	HibernateTemplate getHibernateTemplateObject();

	Map<String, Object> cancelAdmission(Map<String, Object> dataMap);
}
