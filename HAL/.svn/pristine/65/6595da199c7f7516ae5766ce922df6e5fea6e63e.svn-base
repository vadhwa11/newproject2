package jkt.hms.billing.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.BlPatientLedger;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;

public interface BillingHandlerService {

	List<Patient> getHinNo(String serviceNo);

	Map<String, Object> getPatientDetails(String adNo);

	Map<String, Object> getChargeCode(Map<String, Object> parameterMap);

	Map<String, Object> getMainAndSubCharge();

	Map<String, Object> fillItemsForChargeCode(Map<String, Object> dataMap);

	Map<String, Object> submitBillingDetails(Map<String, Object> infoMap);

	Map<String, Object> getPatientDetails(Map<String, Object> mapForDs);

	Map<String, Object> getDetailsForSearch();

	int getChargeSlipNo();

	String getSeqNoForDisplay(String prefix);

	List<BlPatientLedger> getDepositOfPatient(int inpatientId);

	Map<String, Object> submitDepositDetails(Map<String, Object> parameterMap);

	List<BlPatientLedger> getTotalAdvAndBillAmt(int inpatientId);

	Map<String, Object> submitBillingFinalSettlementDetails(Box box);

	Map<String, Object> getConnectionForReport();

	List<Inpatient> getAdNo(String hin);

	Map<String, Object> getPendingListOfPatient(Box box);

	Map<String, Object> getPatientDetailsForOpBilling(Map<String, Object> parameterMap);

	Map<String, Object> getChargeCodeDetails(String chargeCode, int hinId,
			int schemeId, int hospitalId);

	Map<String, Object> submitvisit(Visit v);

	String getage(String hinNo);

	int getVisitNo(String hinNo);

	Map<String, Object> submitBillServicingDetails(Map<String, Object> dataMap);

	Map<String, Object> getPendingListOfPatientOther(Box box);

	Map<String, Object> getOtherPatientDetailsForBilling(
			Map<String, Object> parameterMap);

	Map<String, Object> submitBillServicingDetailsOtherPatients(
			Map<String, Object> dataMap);
	
	

}
