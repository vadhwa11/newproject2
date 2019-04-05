package jkt.hms.payroll.handler;

import java.util.Map;

import jkt.hms.masters.business.HrAdvance;
import jkt.hms.masters.business.HrAdvanceDetail;
import jkt.hms.masters.business.HrArrear;
import jkt.hms.masters.business.HrArrearSalary;
import jkt.hms.masters.business.HrBonusDetail;
import jkt.hms.masters.business.HrLoanDetail;
import jkt.hms.masters.business.HrLoanHeader;
import jkt.hms.masters.business.HrReimbDetail;
import jkt.hms.masters.business.HrReimbHeader;
import jkt.hms.payroll.dataservice.LoanDataService;

public class LoanHandlerServiceImpl implements LoanHandlerService {
	LoanDataService loanDataService = null;

	public LoanDataService getLoanDataService() {
		return loanDataService;
	}

	public void setLoanDataService(LoanDataService loanDataService) {
		this.loanDataService = loanDataService;
	}

	public Map<String, Object> showLoanHeaderJsp(Map<String, Object> detailMap) {
		
		return loanDataService.showLoanHeaderJsp(detailMap);
	}

	public Map<String, Object> saveLoanHeader(HrLoanHeader hrLoanHeader) {
		
		return loanDataService.saveLoanHeader(hrLoanHeader);
	}

	public Map<String, Object> showLoanDetailJsp() {
		
		return loanDataService.showLoanDetailJsp();
	}

	public Map<String, Object> saveLoanDetail(HrLoanDetail hrLoanDetail) {
		
		return loanDataService.saveLoanDetail(hrLoanDetail);
	}

	public Map<String, Object> updateLoanHeader(Map<String, Object> generalMap) {
		
		return loanDataService.updateLoanHeader(generalMap);
	}

	public Map<String, Object> getLoanDetailFromAjax(int loanHeaderId) {
		
		return loanDataService.getLoanDetailFromAjax(loanHeaderId);
	}

	public Map<String, Object> editLoanDetail(Map<String, Object> generalMap) {
		
		return loanDataService.editLoanDetail(generalMap);
	}

	public Map<String, Object> showReimbHeaderJsp(Map<String, Object> detailMap) {
			
			return loanDataService.showReimbHeaderJsp(detailMap);
		}
	public Map<String, Object> saveReimbHeader(HrReimbHeader hrReimbHeader) {
		
		return loanDataService.saveReimbHeader(hrReimbHeader);
	}

	public Map<String, Object> updateReimbHeader(Map<String, Object> generalMap) {
	
		return loanDataService.updateReimbHeader(generalMap);
	}

	public Map<String, Object> showReimbDetailJsp(Map<String, Object> detailMap) {
		
		return loanDataService.showReimbDetailJsp(detailMap);
	}

	public Map<String, Object> saveReimbDetail(Map<String, Object> generalMap) {
		
		return loanDataService.saveReimbDetail(generalMap);
	}

	public Map<String, Object> updateReimbDetail(Map<String, Object> generalMap) {
		
		return loanDataService.updateReimbDetail(generalMap);
	}

	public Map<String, Object> showBonusDetailJsp(Map<String, Object> detailMap) {
		
		return loanDataService.showBonusDetailJsp(detailMap);
	}

	public Map<String, Object> saveBonusDetail(HrBonusDetail hrBonusDetail) {
		
		return loanDataService.saveBonusDetail(hrBonusDetail);
	}

	public Map<String, Object> updateBonusDetail(Map<String, Object> generalMap) {
		
		return loanDataService.updateBonusDetail(generalMap);
	}

	public Map<String, Object> showAdvanceJsp(Map<String, Object> detailMap) {
		
		return loanDataService.showAdvanceJsp(detailMap);
	}

	public Map<String, Object> saveAdvance(Map<String, Object> detailMap) {
		
		return loanDataService.saveAdvance(detailMap);
	}

public Map<String, Object> showAdvanceDetailJsp() {
		
		return loanDataService.showAdvanceDetailJsp();
	}

	public Map<String, Object> saveAdvanceDetail(HrAdvanceDetail hrAdvanceDetail) {
		
		return loanDataService.saveAdvanceDetail(hrAdvanceDetail);
	}

	public Map<String, Object> updateAdvance(Map<String, Object> generalMap) {
	
		return loanDataService.updateAdvance(generalMap);
	}

	public Map<String, Object> updateAdvanceDetail(Map<String, Object> generalMap) {
		
		return loanDataService.updateAdvanceDetail(generalMap);
	}

	public Map<String, Object> showArrearJsp() {
		
		return loanDataService.showArrearJsp();
	}

	public Map<String, Object> saveArrear(HrArrear hrArrear) {
		
		return loanDataService.saveArrear(hrArrear);
	}

	public Map<String, Object> updateArrear(Map<String, Object> generalMap) {
		
		return loanDataService.updateArrear(generalMap);
	}

	public Map<String, Object> showArrearSalaryJsp() {
		
		return loanDataService.showArrearSalaryJsp();
	}

	public Map<String, Object> saveArrearSalary(HrArrearSalary hrArrearSalary) {
		
		return loanDataService.saveArrearSalary(hrArrearSalary);
	}

	public Map<String, Object> updateArrearSalary(Map<String, Object> generalMap) {
		
		return loanDataService.updateArrearSalary(generalMap);
	}

	public Map<String, Object> showAdvanceStatementJsp() {
		
		return loanDataService.showAdvanceStatementJsp();
	}

	public Map<String, Object> getConnectionForReport() {
		
		return loanDataService.getConnectionForReport();
	}

	
	@Override
	public Map<String, Object> showloanstatement() {
		// TODO Auto-generated method stub
		return loanDataService.showloanstatement();
	}
	

	

	
	

	

	

}
