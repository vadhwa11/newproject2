package jkt.hms.billing.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.billing.dataservice.BillingDataService;
import jkt.hms.masters.business.BlPatientLedger;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;

public class BillingHandlerServiceImpl implements BillingHandlerService {

	BillingDataService billingDataService = null;

	/**
	 * Getter And Setter of BillingDataService
	 **/
	public BillingDataService getBillingDataService() {
		return billingDataService;
	}

	public void setBillingDataService(BillingDataService billingDataService) {
		this.billingDataService = billingDataService;
	}

	// -----------------------------------------------------------------------

	public List<Patient> getHinNo(String serviceNo) {
		return billingDataService.getHinNo(serviceNo);
	}

	public Map<String, Object> getPatientDetails(String adNo) {
		return billingDataService.getPatientDetails(adNo);
	}

	public Map<String, Object> getChargeCode(Map<String, Object> parameterMap) {
		return billingDataService.getChargeCode(parameterMap);
	}

	public Map<String, Object> getMainAndSubCharge() {
		return billingDataService.getMainAndSubCharge();
	}

	public Map<String, Object> fillItemsForChargeCode(
			Map<String, Object> dataMap) {
		return billingDataService.fillItemsForChargeCode(dataMap);
	}

	public Map<String, Object> submitBillingDetails(Map<String, Object> infoMap) {
		return billingDataService.submitBillingDetails(infoMap);
	}

	public Map<String, Object> getPatientDetails(Map<String, Object> mapForDs) {
		return billingDataService.getPatientDetails(mapForDs);
	}

	public Map<String, Object> getDetailsForSearch() {
		return billingDataService.getDetailsForSearch();
	}

	public int getChargeSlipNo() {
		return billingDataService.getChargeSlipNo();
	}

	public String getSeqNoForDisplay(String prefix) {
		return billingDataService.getSeqNoForDisplay(prefix);
	}

	public List<BlPatientLedger> getDepositOfPatient(int inpatientId) {
		return billingDataService.getDepositOfPatient(inpatientId);
	}

	public Map<String, Object> submitDepositDetails(
			Map<String, Object> parameterMap) {
		return billingDataService.submitDepositDetails(parameterMap);
	}

	public List<BlPatientLedger> getTotalAdvAndBillAmt(int inpatientId) {
		return billingDataService.getTotalAdvAndBillAmt(inpatientId);
	}

	public Map<String, Object> submitBillingFinalSettlementDetails(Box box) {
		return billingDataService.submitBillingFinalSettlementDetails(box);
	}

	public Map<String, Object> getConnectionForReport() {
		return billingDataService.getConnectionForReport();
	}

	public List<Inpatient> getAdNo(String hin) {
		return billingDataService.getAdNo(hin);
	}


	public Map<String, Object> getPendingListOfPatient(Box box) {
		// TODO Auto-generated method stub
		return billingDataService.getPendingListOfPatient(box);
	}
	
	@Override
	public Map<String, Object> getPendingListOfPatientOther(Box box) {
		// TODO Auto-generated method stub
		return billingDataService.getPendingListOfPatientOther(box);
	}

	@Override
	public Map<String, Object> getPatientDetailsForOpBilling(
			Map<String, Object> parameterMap) {
		
		return billingDataService.getPatientDetailsForOpBilling(parameterMap);
	}
	
	@Override
	public Map<String, Object> getOtherPatientDetailsForBilling(
			Map<String, Object> parameterMap) {
		
		return billingDataService.getOtherPatientDetailsForBilling(parameterMap);
	}

	@Override
	public Map<String, Object> getChargeCodeDetails(String chargeCode,
			int hinId, int schemeId, int hospitalId) {
		return billingDataService.getChargeCodeDetails(chargeCode, hinId,schemeId,hospitalId);
	}

	@Override
	public Map<String, Object> submitvisit(Visit v) {
		// TODO Auto-generated method stub
		return billingDataService.submitvisit(v);
	}

	@Override
	public String getage(String hinNo) {
		return billingDataService.getage(hinNo);
	}

	@Override
	public int getVisitNo(String hinNo) {
	
			return billingDataService.getVisitNo(hinNo);
		

	}

	@Override
	public Map<String, Object> submitBillServicingDetails(
			Map<String, Object> dataMap) {
		return billingDataService.submitBillServicingDetails(dataMap);
	}
	
	@Override
	public Map<String, Object> submitBillServicingDetailsOtherPatients(
			Map<String, Object> dataMap) {
		return billingDataService.submitBillServicingDetailsOtherPatients(dataMap);
	}
	
	
	
}
