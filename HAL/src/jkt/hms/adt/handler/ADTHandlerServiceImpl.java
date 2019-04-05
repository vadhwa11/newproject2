package jkt.hms.adt.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Transaction;

import jkt.hms.adt.dataservice.ADTDataService;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class ADTHandlerServiceImpl implements ADTHandlerService {
	
	ADTDataService adtDataService = null;
	
	// Setters & Getters
	public ADTDataService getAdtDataService() {
		return adtDataService;
	}

	public void setAdtDataService(ADTDataService adtDataService) {
		this.adtDataService = adtDataService;
	}
	
	public Map<String, Object> getPatientDetails(Map<String, Object> mapForDs) {
		return adtDataService.getPatientDetails(mapForDs);
	}
	
	public Map<String, Object> getPatientDetailsHAL(Map<String, Object> mapForDs, Transaction tx, org.hibernate.Session ses) {
		return adtDataService.getPatientDetailsHAL(mapForDs, tx, ses);
	}
	
	public Map<String, Object> getAdmissionDetails(int hospitalId) {
		return adtDataService.getAdmissionDetails(hospitalId);
	}
	public Map<String, Object> getAdmissionDetailsHAL(int hospitalId, Transaction tx, org.hibernate.Session ses) {
		return adtDataService.getAdmissionDetailsHAL(hospitalId, tx, ses);
	}
	
	public Session getSes() {
		return adtDataService.getSes();
	}
	
	public HibernateTemplate getHibernateTemplateObject() {
		return adtDataService.getHibernateTemplateObject();
	}
	
	public Map<String, Object> submitAdmissionInformation(Map<String, Object> admissionMap) {
		return adtDataService.submitAdmissionInformation(admissionMap);
	}
	
	public Map<String, Object> submitAdmissionInformationHAL(Map<String, Object> admissionMap, Transaction tx, org.hibernate.Session ses) {
		return adtDataService.submitAdmissionInformationHAL(admissionMap, tx, ses);
	}
	
	public String getMotherName(String motherAdNo) {
		return adtDataService.getMotherName(motherAdNo);
	}
	public  Map<String, Object> saveAttachedAdmission(Map<String, Object> attachMap) {
		return adtDataService.saveAttachedAdmission(attachMap);
	}
	public Map<String, Object> getDetailsForMLC() {
		return adtDataService.getDetailsForMLC();
	}
	public Map<String, Object> getDetailsForMLCHAL(Transaction tx, org.hibernate.Session ses) {
		return adtDataService.getDetailsForMLCHAL(tx, ses);
	}
	public boolean submitMLCDetails(Box box) {
		return adtDataService.submitMLCDetails(box);
	}
	public String generateAdNumber(Map<String, Object> adMap) {
		return adtDataService.generateAdNumber(adMap);
	}
	
	public String generateTransactionSequence(Map<String, Object> map, org.hibernate.Session ses) throws Exception {
		return adtDataService.generateTransactionSequence(map, ses);
	}

	public String generateMLCNo(Map<String, Object> adMap) {
		return adtDataService.generateMLCNo(adMap);
	}
	
	public String generateMLCNoHAL(Map<String, Object> adMap, Transaction tx, org.hibernate.Session ses) {
		return adtDataService.generateMLCNoHAL(adMap, tx, ses);
	}
	
	public Map<String, Object> getPatientDetailsForTransfer(Map<String, Object> mapForDs) {
		return adtDataService.getPatientDetailsForTransfer(mapForDs);
	}

	public Map<String, Object> getTransferDetails(int hospitalId ) {
		return adtDataService.getTransferDetails(hospitalId );
	}
	
	public boolean submitTransferInformation(Map<String, Object> transferMap) {
		return adtDataService.submitTransferInformation(transferMap);
	}
	
	public Map<String, Object> getDischargeDetails() {
		return adtDataService.getDischargeDetails();
	}
	public Map<String, Object> getUserRights(Users userObj) {
		return adtDataService.getUserRights(userObj);
	}
	
	public Map<String, Object> submitDischargeInformation(Map<String, Object> dischargeMap) {
		return adtDataService.submitDischargeInformation(dischargeMap);
	}

	public List<MasDepartment> getDepartmentList() {
		return adtDataService.getDepartmentList();
	}

	public Map<String, Object> getDischargePatientList(Map<String, Object> dischargeMap) {
		return adtDataService.getDischargePatientList(dischargeMap);
	}
	
	public Map<String, Object> getAttachPatientDetails(Map<String, Object> attachPatientMap) {
		return adtDataService.getAttachPatientDetails(attachPatientMap);
	}
	
	public Map<String, Object> getAttachPatientDetailsHAL(Map<String, Object> attachPatientMap, Transaction tx, org.hibernate.Session ses) {
		return adtDataService.getAttachPatientDetailsHAL(attachPatientMap, tx, ses);
	}

	public Map<String, Object> dischargePatient(Map<String, Object> detailsMap) {
		return adtDataService.dischargePatient(detailsMap);
	}

	public Map<String, Object> showExpiryDetails(Map<String, Object> patientDetailsMap) {
		return adtDataService.showExpiryDetails(patientDetailsMap);
	}

	public boolean submitExpiryDetails(Map<String, Object> expiryDetilsMap) {
		return adtDataService.submitExpiryDetails(expiryDetilsMap);
	}

	public Map<String, Object> getConnectionForReport() {
		return adtDataService.getConnectionForReport() ;
	}

	public List getAdmissionNoList(Map<String, Object> detailsMap) {
		return adtDataService.getAdmissionNoList(detailsMap);
	}

	public List<Object> getHinNoList(String serviceNo) {
		return adtDataService.getHinNoList(serviceNo);
	}

	public Map<String, Object> getServiceTypeDepartmentCategory() {
		return adtDataService.getServiceTypeDepartmentCategory();
	}

	public Map<String, Object> getVisitDates(String hinNo) {
		return adtDataService.getVisitDates(hinNo);
	}

	public Map<String, Object> getDiagnosis(Date visitDate) {
		return adtDataService.getDiagnosis(visitDate);
	}

	public Map<String, Object> getPatientAdmissionDetailsForUpdate(String adNo) {
		return adtDataService.getPatientAdmissionDetailsForUpdate( adNo);
	}

	public boolean updateAdmissionInformation(Map<String, Object> parameterMap) {
		return adtDataService.updateAdmissionInformation(parameterMap);
	}

	public Map<String, Object> getMlcNo(String hinNo) {
		return adtDataService.getMLCNo(hinNo);
	}

	public Map<String, Object> getDetailsForSearch(int hospitalId) {
		return adtDataService.getDetailsForSearch(hospitalId);
	}

	public Map<String, Object> getPatientDetailsForDischarge(
			Map<String, Object> mapForDs) {
		return adtDataService.getPatientDetailsForDischarge(mapForDs);
	}

	public int getHospitalStaffSLNo() {
		return adtDataService.getHospitalStaffSLNo();
	}

	public boolean saveAdditionalInfoForDischarge(
			Map<String, Object> parameterMap) {
		return adtDataService.saveAdditionalInfoForDischarge(parameterMap);
	}

	public Map<String, Object> getPatientDiagnosis(String adNo, int inpatientId) {
		return adtDataService.getPatientDiagnosis(adNo, inpatientId);
	}

	public boolean cancelAdmissionInformation(Map<String, Object> parameterMap) {
		return adtDataService.cancelAdmissionInformation(parameterMap);
	}

	public Map<String, Object> getSiDiData(Map<String, Object> dataMap) {
		return adtDataService.getSiDiData(dataMap);
	}

	public Map<String, Object> getDiagnosisAndDocInit(Map<String, Object> dataMap) {
		return adtDataService.getDiagnosisAndDocInit(dataMap);
	}

	public Map<String, Object> chechBed(Map<String, Object> dataMap) {
		
		return adtDataService.chechBed(dataMap);
	}

	public Map<String, Object> checkAdNoDuplication(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return adtDataService.checkAdNoDuplication(dataMap);
	}
	
	public Map<String, Object> checkAdNoDuplicationHAL(Map<String, Object> dataMap, Transaction tx, org.hibernate.Session ses) {
		// TODO Auto-generated method stub
		return adtDataService.checkAdNoDuplicationHAL(dataMap, tx, ses);
	}

	public Map<String, Object> checkForDuplicateOfAdnoInAttach(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return adtDataService.checkForDuplicateOfAdnoInAttach(dataMap);
	}

	public Map<String, Object> getIcdWithIcdCode(Map<String, Object> dataMap) {
		return adtDataService.getIcdWithIcdCode(dataMap);
	}

	public Map<String, Object> getDischargeDetails(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return adtDataService.getDischargeDetails(dataMap);
	}

	public Map<String, Object> getDetailsOfDischarge(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		 return adtDataService.getDetailsOfDischarge(dataMap);
	}

	public Map<String, Object> updateDischarge(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return adtDataService.updateDischarge(dataMap);
	}

	public Map<String, Object> getICDDetails(Box box) {
		// TODO Auto-generated method stub
		return adtDataService.getICDDetails(box);
	}

	public Map<String, Object> searchExpiryDetails(Map<String, Object> dataMap) {
		return adtDataService.searchExpiryDetails(dataMap);
	}
	
	public boolean updateExpiryDetails(Map<String, Object> expiryDetilsMap) {
		return adtDataService.updateExpiryDetails(expiryDetilsMap);
	}

	public Map<String, Object> printExpiryDetails(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return adtDataService.printExpiryDetails(dataMap);
	}

	public Map<String, Object> searchPatientDischarge(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return adtDataService.searchPatientDischarge(dataMap);
	}

	public Map<String, Object> checkCancelAdmissionState(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return adtDataService.checkCancelAdmissionState(dataMap);
	}

	public Map<String, Object> checkOffLineAdNoDuplicationFor(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return adtDataService.checkOffLineAdNoDuplicationFor(dataMap);
	}

	public Map<String, Object> cancelDischarge(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return adtDataService.cancelDischarge(dataMap);
	}

	// added by  kalyan
	public Map<String, Object> showUnitValidateJsp(){
		return adtDataService.showUnitValidateJsp();
	} 


	public Map<String, Object> searchUnit(String unitName,String unitAddress){
		return adtDataService.searchUnit(unitName,unitAddress);
	}

	


	public Map<String, Object> getUnitDetails(int id) {
		return adtDataService.getUnitDetails(id);
	}

	
	public Map<String, Object> updateUnit(Map<String, Object> dataMap) {
		return adtDataService.updateUnit(dataMap);
	}
	
	public Map<String, Object> updateValidateUnit(Map<String, Object> dataMap,Box box) {
		return adtDataService.updateValidateUnit(dataMap,box);
	}
	
	public Map<String, Object> deleteValidateUnit(int unitId) {
		return adtDataService.deleteValidateUnit(unitId) ;
	}
	
	public Map<String, Object> getNewUnitDetails(Map<String, Object> dataMap) {
		return adtDataService.getNewUnitDetails(dataMap);
	}

	public Map<String, Object> showUnitSearchJsp(Box box) {
		// TODO Auto-generated method stub
		return adtDataService.showUnitSearchJsp(box);
	}
	public Map<String, Object> getMlcDetails(Map<String, Object> parameterMap) {
		return adtDataService.getMlcDetails(parameterMap);
	}
	
	public Map<String, Object> getFinalDischargePatientList(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return adtDataService.getFinalDischargePatientList(dataMap);
	}
	
	
	public Map<String, Object> canceldischargePatient(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return adtDataService.canceldischargePatient(dataMap);
	}

	public Map<String, Object> checkTodayTransactions(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return adtDataService.checkTodayTransactions(dataMap);
	}
	
	// added by  vineet
	public Map<String, Object> showTradeValidateJsp(){
		return adtDataService.showTradeValidateJsp();
	} 

	public Map<String, Object> getTradeDetails(int id)
	{
		return adtDataService.getTradeDetails(id);
	}
	
	
	public Map<String, Object> searchTrade(String tradeName)
	{	
		return adtDataService.searchTrade(tradeName);
	}
	public Map<String, Object> updateTrade(Map<String, Object> dataMap)
	{	
		return adtDataService.updateTrade(dataMap);
	}
	
	
	public Map<String, Object> updateValidateTrade(Map<String, Object> dataMap,Box box)
	{	
		return adtDataService.updateValidateTrade(dataMap,box);
	}
	
	public Map<String, Object> deleteValidateTrade(int unitId)
	{	
		return adtDataService.deleteValidateTrade(unitId);
	}
	public Map<String, Object> showTradeSearchJsp(Box box) {
		return adtDataService.showTradeSearchJsp(box);
	}

	public Map<String, Object> showInjuryReportJsp() {
		// TODO Auto-generated method stub
		return adtDataService.showInjuryReportJsp();
	}
	public void closeHibernateSession(){
		adtDataService.closeHibernateSession();
	}

	@Override
	public Map<String, Object> getHinNoForAdm(String serviceNo) {
		return adtDataService.getHinNoForAdm(serviceNo);
	}

	@Override
	public Map<String, Object> searchPatientTrack(Box box) {
		return adtDataService.searchPatientTrack(box);
	}

	@Override
	public Map<String, Object> getHinDetailsForAppointment(Box box) {
		return adtDataService.getHinDetailsForAppointment(box);
	}

	@Override
	public Map<String, Object> submitPatientAppointment(Box box) {
		return adtDataService.submitPatientAppointment(box);
	}

	@Override
	public boolean cancelPatientAppointment(Box box) {
		return adtDataService.cancelPatientAppointment(box);
	}

	@Override
	public Map<String, Object> searchAppointments(Box box) {
		return adtDataService.searchAppointments(box);
	}

	@Override
	public Map<String, Object> getPatientNamesForApp(Box box) {
		return adtDataService.getPatientNamesForApp(box);
	}

	@Override
	public Map<String, Object> getPatientDetailsForApp(Box box) {
		return adtDataService.getPatientDetailsForApp(box);
	}

	@Override
	public Map<String, Object> showIpAdmissionRegisterGraph(Box box) {
		return adtDataService.showIpAdmissionRegisterGraph(box);
	}

	@Override
	public Map<String, Object> showIPRegisterOnScreen(Box box) {
		return adtDataService.showIPRegisterOnScreen(box);
	}

	@Override
	public Map<String, Object> getBedStatus(Box box) {
		return adtDataService.getBedStatus(box);
	}

	//Map<String, Object> updateTrade(Map<String, Object> dataMap);

	@Override
	public Map<String, Object> cancelAdmission(Map<String, Object> dataMap) {
		return adtDataService.cancelAdmission(dataMap);
	}

}
