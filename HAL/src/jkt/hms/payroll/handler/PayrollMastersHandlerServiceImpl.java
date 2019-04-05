package jkt.hms.payroll.handler;

import java.util.Map;

import jkt.hms.masters.business.HrMasBonus;
import jkt.hms.masters.business.HrMasItaxExemption;
import jkt.hms.masters.business.HrMasItaxSurcharge;
import jkt.hms.masters.business.HrMasLoan;
import jkt.hms.masters.business.HrMasPayElement;
import jkt.hms.masters.business.HrMasPayroll;
import jkt.hms.masters.business.HrMasReimbersement;
import jkt.hms.payroll.dataservice.PayrollMastersDataService;

public class PayrollMastersHandlerServiceImpl implements PayrollMastersHandlerService {

	PayrollMastersDataService payrollMastersDataService = null;

	public PayrollMastersDataService getPayrollMastersDataService() {
		return payrollMastersDataService;
	}

	public void setPayrollMastersDataService(
			PayrollMastersDataService payrollMastersDataService) {
		this.payrollMastersDataService = payrollMastersDataService;
	}
	

//Start code 
public Map<String, Object> showPayElementJsp() {
		
		return payrollMastersDataService.showPayElementJsp();
	}

@Override
public Map<String, Object> duplicatePayElement(Map<String, Object> generalMap) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.duplicatePayElement(generalMap);
}

@Override
public Map<String, Object> savePayElement(HrMasPayElement hrMasPayElement) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.savePayElement(hrMasPayElement);
}

public Map<String, Object> editPayElement(Map<String, Object> generalMap) {
	
	return payrollMastersDataService.editPayElement(generalMap);
}

@Override
public Map<String, Object> deletePayElement(Map<String, Object> generalMap) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.deletePayElement(generalMap);
}

@Override
public Map<String, Object> searchPayElement(String payElementCode,
		String payElementDescription) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.searchPayElement(payElementCode,payElementDescription);
}

@Override
public Map<String, Object> showPayrollJsp() {
	// TODO Auto-generated method stub
	return payrollMastersDataService.showPayrollJsp();
}

@Override
public Map<String, Object> checkForExistingMasters(
		Map<String, Object> generalMap) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.checkForExistingMasters(generalMap);
}

@Override
public Map<String, Object> savePayroll(HrMasPayroll hrMasPayroll) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.savePayroll(hrMasPayroll);
}

@Override
public Map<String, Object> editPayroll(Map<String, Object> generalMap) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.editPayroll(generalMap);
}

@Override
public Map<String, Object> deletePayroll(Map<String, Object> generalMap) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.deletePayroll(generalMap);
}

@Override
public Map<String, Object> searchPayroll(String payrollCode,
		String payrollDescription) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.searchPayroll(payrollCode,payrollDescription);
}

@Override
public Map<String, Object> showLoanJsp() {
	// TODO Auto-generated method stub
	return payrollMastersDataService.showLoanJsp();
}

@Override
public Map<String, Object> saveLoan(HrMasLoan hrMasLoan) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.saveLoan(hrMasLoan);
}

@Override
public Map<String, Object> editLoan(Map<String, Object> generalMap) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.editLoan(generalMap);
}

@Override
public Map<String, Object> deleteLoan(Map<String, Object> generalMap) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.deleteLoan(generalMap);
}

@Override
public Map<String, Object> searchLoan(String loanCode, String loanDescription) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.searchLoan(loanCode,loanDescription);
}

@Override
public Map<String, Object> showReimbersementJsp() {
	// TODO Auto-generated method stub
	return payrollMastersDataService.showReimbersementJsp();
}

@Override
public Map<String, Object> saveReimbersement(
		HrMasReimbersement hrMasReimbersement) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.saveReimbersement(hrMasReimbersement);
}

@Override
public Map<String, Object> editReimbersement(Map<String, Object> generalMap) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.editReimbersement(generalMap);
}

@Override
public Map<String, Object> deleteReimbersement(Map<String, Object> generalMap) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.deleteReimbersement(generalMap);
}

@Override
public Map<String, Object> searchReimbersement(String reimbCode,
		String reimbDescription) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.searchReimbersement(reimbCode,reimbDescription);
}

@Override
public Map<String, Object> saveBonus(HrMasBonus hrMasBonus) {
	
	return payrollMastersDataService.saveBonus(hrMasBonus);
}

@Override
public Map<String, Object> showBonusJsp() {
	
	return payrollMastersDataService.showBonusJsp();
}

@Override
public Map<String, Object> editBonus(Map<String, Object> generalMap) {
	
	return payrollMastersDataService.editBonus(generalMap);
}

@Override
public Map<String, Object> deleteBonus(Map<String, Object> generalMap) {
	
	return payrollMastersDataService.deleteBonus(generalMap);
}

@Override
public Map<String, Object> searchBonus(String bonusCode,String bonusDescription) {

	return payrollMastersDataService.searchBonus(bonusCode,bonusDescription) ;
}

@Override
public Map<String, Object> showIncomeTaxExemptJsp() {
	// TODO Auto-generated method stub
	return payrollMastersDataService.showIncomeTaxExemptJsp();
}

@Override
public Map<String, Object> searchIncomeTaxExemptMaster(String financialYear) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.searchIncomeTaxExemptMaster(financialYear);
}

@Override
public Map<String, Object> copyIncomeTaxExemptMaster(int copyFromYear,
		int copyToYear) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.copyIncomeTaxExemptMaster(copyFromYear, copyToYear);
}

@Override
public Map<String, Object> existingIncomeTaxExemptJsp(
		Map<String, Object> generalMap) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.existingIncomeTaxExemptJsp(generalMap);
}

@Override
public boolean addIncomeTaxExemptMaster(HrMasItaxExemption hrMasItaxExemption) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.addIncomeTaxExemptMaster(hrMasItaxExemption);
}

@Override
public boolean editIncomeTaxExemptMaster(Map<String, Object> generalMap) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.editIncomeTaxExemptMaster(generalMap);
}

@Override
public boolean deleteIncomeTaxExemptMaster(int slabid,
		Map<String, Object> generalMap) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.deleteIncomeTaxExemptMaster(slabid,generalMap);
}

@Override
public Map<String, Object> showIncomeTaxSurchargeJsp() {
	// TODO Auto-generated method stub
	return payrollMastersDataService.showIncomeTaxSurchargeJsp();
}

@Override
public Map<String, Object> copyIncomeTaxSurchargeJsp(int copyFromYear,
		int copyToYear) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.copyIncomeTaxSurchargeJsp(copyFromYear, copyToYear);
}

@Override
public Map<String, Object> searchIncomeTaxSurchargeJsp(String financialYear) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.searchIncomeTaxSurchargeJsp(financialYear);
}

@Override
public Map<String, Object> exitistingIncomeTaxSurchargeJsp(
		Map<String, Object> generalMap) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.exitistingIncomeTaxSurchargeJsp(generalMap);
}

@Override
public boolean addIncomeTaxSurchargeJsp(HrMasItaxSurcharge hrMasItaxSurcharge) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.addIncomeTaxSurchargeJsp(hrMasItaxSurcharge);
}

@Override
public boolean editIncomeTaxSurchargeJsp(Map<String, Object> generalMap) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.editIncomeTaxSurchargeJsp(generalMap);
}

@Override
public boolean deleteIncomeTaxSurchargeJsp(int id,
		Map<String, Object> generalMap) {
	// TODO Auto-generated method stub
	return payrollMastersDataService.deleteIncomeTaxSurchargeJsp(id, generalMap);
}
}
