package jkt.hms.payroll.dataservice;

import java.util.Map;

import jkt.hms.masters.business.HrMasBonus;
import jkt.hms.masters.business.HrMasItaxExemption;
import jkt.hms.masters.business.HrMasItaxSurcharge;
import jkt.hms.masters.business.HrMasLoan;
import jkt.hms.masters.business.HrMasPayElement;
import jkt.hms.masters.business.HrMasPayroll;
import jkt.hms.masters.business.HrMasReimbersement;

public interface PayrollMastersDataService {
	
	//Start Code 
	
	Map<String, Object> showPayElementJsp();
	Map<String, Object> duplicatePayElement(Map<String, Object> generalMap);
	Map<String, Object> savePayElement(HrMasPayElement hrMasPayElement);
	Map<String, Object> editPayElement(Map<String, Object> generalMap);
	Map<String, Object> deletePayElement(Map<String, Object> generalMap);
	Map<String, Object> searchPayElement(String payElementCode, String payElementDescription);
	Map<String, Object> showPayrollJsp();
	Map<String, Object> checkForExistingMasters(Map<String, Object> generalMap);
	Map<String, Object> savePayroll(HrMasPayroll hrMasPayroll);
	Map<String, Object> editPayroll(Map<String, Object> generalMap);
	Map<String, Object> deletePayroll(Map<String, Object> generalMap);
	Map<String, Object> searchPayroll(String payrollCode, String payrollDescription);
	Map<String, Object> showLoanJsp();
	Map<String, Object> saveLoan(HrMasLoan hrMasLoan);
	Map<String, Object> editLoan(Map<String, Object> generalMap);
	Map<String, Object> deleteLoan(Map<String, Object> generalMap);
	Map<String, Object> searchLoan(String loanCode, String loanDescription);
	Map<String, Object> showReimbersementJsp();
	Map<String, Object> saveReimbersement(HrMasReimbersement hrMasReimbersement);
	Map<String, Object> editReimbersement(Map<String, Object> generalMap);
	Map<String, Object> deleteReimbersement(Map<String, Object> generalMap);
	Map<String, Object> searchReimbersement(String reimbCode,
			String reimbDescription);
	Map<String, Object> showBonusJsp();
	Map<String, Object> saveBonus(HrMasBonus hrMasBonus);
	Map<String, Object> editBonus(Map<String, Object> generalMap);
	Map<String, Object> deleteBonus(Map<String, Object> generalMap);
	Map<String, Object> searchBonus(String bonusCode, String bonusDescription);
	Map<String, Object> showIncomeTaxExemptJsp();
	Map<String, Object> searchIncomeTaxExemptMaster(String financialYear);
	Map<String, Object> copyIncomeTaxExemptMaster(int copyFromYear,int copyToYear);
	Map<String, Object> existingIncomeTaxExemptJsp(Map<String, Object> generalMap);
	boolean addIncomeTaxExemptMaster(HrMasItaxExemption hrMasItaxExemption);
	boolean editIncomeTaxExemptMaster(Map<String, Object> generalMap);
	boolean deleteIncomeTaxExemptMaster(int slabid,Map<String, Object> generalMap);
	Map<String, Object> showIncomeTaxSurchargeJsp();
	Map<String, Object> copyIncomeTaxSurchargeJsp(int copyFromYear,int copyToYear);
	Map<String, Object> searchIncomeTaxSurchargeJsp(String financialYear);
	Map<String, Object> exitistingIncomeTaxSurchargeJsp(Map<String, Object> generalMap);
	boolean addIncomeTaxSurchargeJsp(HrMasItaxSurcharge hrMasItaxSurcharge);
	boolean editIncomeTaxSurchargeJsp(Map<String, Object> generalMap);
	boolean deleteIncomeTaxSurchargeJsp(int id, Map<String, Object> generalMap);
}
