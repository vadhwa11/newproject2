package jkt.hms.account.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hms.account.dataservice.AccountDataService;
import jkt.hms.masters.business.HrInsuranceDetails;
import jkt.hms.masters.business.HrMasFinancialYear;
import jkt.hms.masters.business.FaMasNarration;
import jkt.hms.masters.business.FaMasSubLed;
import jkt.hms.masters.business.MasApprovalStatus;
import jkt.hms.masters.business.MasBankMaster;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.util.Box;

public class AccountHandlerServiceImpl implements AccountHandlerService {
	AccountDataService accountDataService = null;

	public Map<String, Object> showAccountsGroupMasterJsp(Map<String, Object> generalMap) {

		return accountDataService.showAccountsGroupMasterJsp(generalMap);
	}

	public Map<String, Object> showAccountSubGroup(Map<String, Object> generalMap) {
		return accountDataService.showAccountSubGroup(generalMap);
	}

	public Map<String, Object> searchAccountSubGroup(Box box) {
		return accountDataService.searchAccountSubGroup(box);
	}

	public Map<String, Object> addAccountMaster(Map<String, Object> generalMap) {

		return accountDataService.addAccountMaster(generalMap);
	}

	public Map<String, Object> showAccountMasterJsp(Map<String, Object> generalMap) {

		return accountDataService.showAccountMasterJsp(generalMap);
	}

	public Map<String, Object> searchAccountMaster(Box box) {

		return accountDataService. searchAccountMaster(box);
	}

	public Map<String, Object> showAccountSubLedgerJsp(Map<String, Object> detailsMap) {
		return accountDataService.showAccountSubLedgerJsp(detailsMap);
	}

	public Map<String, Object> getAccCodeForAccSubGrp(Box box) {
		return accountDataService.getAccCodeForAccSubGrp(box);
	}

	public Map<String, Object> searchAccountGroup(Box box) {
		return accountDataService.searchAccountGroup(box);
	}

	public Map<String, Object> addAccountSubLedger(Map<String, Object> generalMap) {
		return accountDataService.addAccountSubLedger(generalMap) ;
	}
	public Map<String, Object> showCashVoucherJsp(Box box) {
		return accountDataService.showCashVoucherJsp(box);
	}
	public Map<String, Object> getAccountCodeForAutoComplete(Map<String, Object> parameterMap) {
		return accountDataService.getAccountCodeForAutoComplete(parameterMap) ;
	}
	public Map<String, Object> getSubLedgerForAccount(Map<String, Object> parameterMap) {
		return accountDataService.getSubLedgerForAccount(parameterMap);
	}

	public Map<String, Object> addVoucherNarration(FaMasNarration faMasNarration) {
		return accountDataService.addVoucherNarration(faMasNarration);
	}
	public Map<String, Object> getNarrationForAutoComplete(Map<String, Object> parameterMap) {
		return accountDataService.getNarrationForAutoComplete(parameterMap);
	}
	public Map<String, Object> showAccountBalance(Box box) {
		return accountDataService.showAccountBalance(box);
	}
	public Map<String, Object> getAccountNarrationForAutoComplete(Map<String, Object> parameterMap) {
		return accountDataService.getAccountNarrationForAutoComplete(parameterMap);
	}

	public Map<String, Object> submitReceiptVoucher(Box box) {
		return accountDataService.submitReceiptVoucher(box);
	}
	public Map<String, Object> showPaymentVoucherJsp(Box box) {

		return accountDataService.showPaymentVoucherJsp(box);
	}

	public Map<String, Object> submitPaymentVoucher(Box box) {
		return accountDataService.submitPaymentVoucher(box);
		}
	public Map<String, Object> showSalesVoucherJsp(Map<String, Object> generalMap) {
		return accountDataService.showSalesVoucherJsp(generalMap);
	}
	public Map<String, Object> submitSalesVoucher(Box box) {
		return accountDataService.submitSalesVoucher(box);
	}
	public Map<String, Object> showSalesReturnVoucherJsp(Map<String, Object> generalMap) {

		return accountDataService.showSalesReturnVoucherJsp(generalMap) ;
	}
	public Map<String, Object> submitSalesReturnVoucher(Box box) {

		return accountDataService.submitSalesReturnVoucher(box);
	}


	public Map<String, Object> showBankReconciliationJsp(int fYear) {
		return accountDataService.showBankReconciliationJsp(fYear);
	}

	public Map<String, Object> getBankAccountDetailsForReconciliation(Box box) {
		return accountDataService.getBankAccountDetailsForReconciliation(box);
	}

	public boolean saveBankReconciliationDetails(Box box) {
		return accountDataService.saveBankReconciliationDetails(box) ;
	}

	
	public Map<String, Object> showJournalVoucherJsp(Box box) {
		
		return accountDataService.showJournalVoucherJsp(box);
	}


	public Map<String, Object> submitJournalVoucher(Box box) {
		return accountDataService.submitJournalVoucher(box);
	}

	public Map<String, Object> showTrialBalanceReportJsp() {

		return accountDataService.showTrialBalanceReportJsp();
	}
	/**
	 * Getter And Setter of BillingDataService
	 */
	public AccountDataService getAccountDataService() {
		return accountDataService;
	}

	public void setAccountDataService(AccountDataService accountDataService) {
		this.accountDataService = accountDataService;
	}

	public Map<String, Object> getConnectionForReport() {

		return accountDataService.getConnectionForReport();
	}

	public Map<String, Object> showPurchaseVoucherJsp(Map<String, Object> generalMap) {

		return accountDataService.showPurchaseVoucherJsp(generalMap);
	}

	public Map<String, Object> submitPurchaseVoucher(Box box) {

		return accountDataService.submitPurchaseVoucher(box);
	}

	public Map<String, Object> showPurchaseReturnVoucherJsp(Map<String, Object> generalMap) {

		return accountDataService.showPurchaseReturnVoucherJsp(generalMap);
	}

	public Map<String, Object> submitPurchaseReturnVoucher(Box box) {

		return accountDataService.submitPurchaseReturnVoucher(box);
	}

	public Map<String, Object> editAccountMaster(Box box) {

		return accountDataService.editAccountMaster(box);
	}

	public Map<String, Object> updateAccountMaster(Box box) {

		return accountDataService.updateAccountMaster(box);
	}

	
	public Map<String, Object> updateAccountSubLedger(Box box) {

		return accountDataService.updateAccountSubLedger(box);
	}
	/*public Map<String, Object> submitAccountsParameter(Box box) {

			return accountDataService.submitAccountsParameter(box);
		}*/

public Map<String, Object> searchAccountSubLedger(Box box) {

		return accountDataService.searchAccountSubLedger(box);
	}


	//------------------- Sub Led Repory By Mansi

	public Map<String, Object> showSubLedJsp() {
		return accountDataService.showSubLedJsp();
	}

	/*public Map<String, Object> showAccountParameterJsp(int fYear) {

		return accountDataService.showAccountParameterJsp(fYear);
	}*/

	public List<HrMasFinancialYear> getFinancialYearDate(int fYearId) {

		return accountDataService.getFinancialYearDate(fYearId);
	}

	public Map<String, Object> getOpeningBalance(Map<String, Object> generalMap) {

		return accountDataService.getOpeningBalance(generalMap);
	}

	public Map<String, Object> showCashRegisterJsp(Box box) {

		return accountDataService.showCashRegisterJsp(box);
	}

	public Map<String, Object> getBillingAmountForAccounts() {

		return accountDataService.getBillingAmountForAccounts();
	}

	public Map<String, Object> showBranchBalancePopupJsp() {

		return accountDataService.showBranchBalancePopupJsp();
	}

	public Map<String, Object> showBranchSubLedBalancePopupJsp() {

		return accountDataService.showBranchSubLedBalancePopupJsp();
	}

	public Map<String, Object> showVoucherMappingJsp(Box box) {

		return accountDataService.showVoucherMappingJsp(box);
	}

	public Map<String, Object> getVoucherList(Map<String, Object> generalMap) {

		return accountDataService.getVoucherList(generalMap);
	}

	public Map<String, Object> showBankRegisterJsp() {


		return accountDataService.showBankRegisterJsp();
	}

	public Map<String, Object> dispalySalesBillingAmount(Box box) {

		return accountDataService.dispalySalesBillingAmount(box);
	}

	public Map<String, Object> postSalesVoucherMapping(Box box) {

		return accountDataService.postSalesVoucherMapping(box);
	}

	public Map<String, Object> showIpSalesVoucherMappingJsp(Box box) {

		return accountDataService.showIpSalesVoucherMappingJsp(box);
	}

	public Map<String, Object> dispalyIpSalesBillingAmount(Box box) {

		return accountDataService.dispalyIpSalesBillingAmount(box);
	}

	public Map<String, Object> postSalesIpVoucherMapping(Box box) {

		return accountDataService.postSalesIpVoucherMapping(box);
	}

	public Map<String, Object> dispalyRefundBillingAmount(Box box) {

		return accountDataService.dispalyRefundBillingAmount(box) ;
	}

	public Map<String, Object> showLedgerAnalysisJsp() {


		return accountDataService.showLedgerAnalysisJsp();
	}

	public Map<String, Object> postRefundVoucherMapping(Box box) {

		return accountDataService.postRefundVoucherMapping(box);
	}

	public Map<String, Object> displayAdvanceVoucherBillingAmount(Box box) {

		return accountDataService.displayAdvanceVoucherBillingAmount(box);
	}

	public Map<String, Object> postAdvanceVoucherMapping(Box box) {

		return accountDataService.postAdvanceVoucherMapping(box);
	}

	public Map<String, Object> dispalyFinalSettlementVoucherAmount(Box box) {

		return accountDataService.dispalyFinalSettlementVoucherAmount(box);
	}

	public Map<String, Object> postFinalSettlementVoucherMapping(Box box) {

		return accountDataService.postFinalSettlementVoucherMapping(box);
	}

	public Map<String, Object> showfavoucherJsp(int fYearId) {

		return accountDataService.showfavoucherJsp(fYearId);
	}

	public Map<String, Object> closingFinancialYear(Box box) {

		return accountDataService.closingFinancialYear(box);
	}

		
	public Map<String, Object> showVoucherReportJsp() {
		// TODO Auto-generated method stub
		return accountDataService.showVoucherReportJsp();
	}

	
	public Map<String, Object> showAccountOpeningJsp(int branchId) {
		
		return accountDataService.showAccountOpeningJsp(branchId);
	}

	
	public Map<String, Object> saveAccountOpening(Box box) {
		
		return accountDataService.saveAccountOpening( box);
	}

	
	public Map<String, Object> updateAccountOpening(Box box) {
		
		return accountDataService.updateAccountOpening(box);
	}

	
	public Map<String, Object> deleteAccountOpening(Box box) {
		
		return accountDataService.deleteAccountOpening(box);
	}


	public int getFinancialYearList(Map<String, Object> generalMap) {
		
		return accountDataService.getFinancialYearList(generalMap);
	}


	
	public Map<String, Object>getOpeningBalanceFromOpeningEntry(Map<String, Object> generalMap) {
		
		return accountDataService.getOpeningBalanceFromOpeningEntry(generalMap);
	}

	
	public Map<String, Object> showLedgerBookJsp() {
		
		return accountDataService.showLedgerBookJsp();
	}

	
	/*public Map<String, Object> showAccountGroupBalance(Map<String, Object> generalMap) {
		
		return accountDataService.showAccountGroupBalance(generalMap);
	}*/

	
	public Map<String, Object> showAccountSubGroupBalance(Map<String, Object> generalMap) {
	
		return accountDataService.showAccountSubGroupBalance(generalMap);
	}


	public Map<String, Object> showAccountSubLedgerBalance(Map<String, Object> generalMap) {
		
		return accountDataService.showAccountSubLedgerBalance(generalMap) ;
	}

	
	/*public Map<String, Object> showAccountMasterBalance(
			Map<String, Object> generalMap) {
		
		return accountDataService.showAccountMasterBalance(generalMap);
	}*/

	
	public Map<String, Object> showAccountParameterJsp(int fYear) {
		
		return accountDataService.showAccountParameterJsp(fYear);
	}

	
	public Map<String, Object> submitAccountsParameter(Box box) {
		
		return accountDataService.submitAccountsParameter(box);
	}

	@Override
	public int getFinancialYearId(Date voucherDate) {
		return accountDataService.getFinancialYearId(voucherDate);
	}

	@Override
	public Map<String, Object> getAccountId(Map<String, Object> remap) {
		return accountDataService.getAccountId(remap);
	}

	@Override
	public Map<String, Object> showAccountBalanceall(Map<String, Object> remap) {
		return accountDataService.showAccountBalanceall(remap);
	}

	@Override
	public Map<String, Object> addAccountSubGroup(Map<String, Object> generalMap) {
	
		return accountDataService.addAccountSubGroup(generalMap);
	}

	@Override
	public Map<String, Object> editAccountSubGroup(Map<String, Object> generalMap){
		
		return accountDataService.editAccountSubGroup(generalMap);
	}

	@Override
	public Map<String, Object> updateAccountSubGroup(Map<String, Object> generalMap) {
		
		return accountDataService.updateAccountSubGroup(generalMap);
	}

	@Override
	public Map<String, Object> showLedgerJsp(Box box) {
		
		return accountDataService.showLedgerJsp(box);
	}

	@Override
	public Map<String, Object> displayLedgerBook(Box box) {
		
		return accountDataService.displayLedgerBook(box);
	}

	@Override
	public Map<String, Object> showSubLedgerPopupJsp(Map<String, Object> generalMap) {
		
		return accountDataService.showSubLedgerPopupJsp(generalMap);
	}

	@Override
	public Map<String, Object> getTrialBalance(Box box) {
		
		return accountDataService.getTrialBalance(box);
	}

	@Override
	public Map<String, Object> getSubGroupWiseTrialBalance(Box box) {
		
		return accountDataService.getSubGroupWiseTrialBalance(box);
	}

	@Override
	public Map<String, Object> getAccountWiseTrialBalance(Box box) {
		
		return accountDataService.getAccountWiseTrialBalance(box);
	}

	@Override
	public Map<String, Object> getVoucherWiseWiseTrialBalance(Box box) {
		
		return accountDataService.getVoucherWiseWiseTrialBalance(box);
	}

	@Override
	public Map<String, Object> displayCashBook(Box box) {
	
		return accountDataService.displayCashBook(box);
	}

	@Override
	public Map<String, Object> displayBankBook(Box box) {
		
		return accountDataService.displayBankBook(box);
	}

	@Override
	public Map<String, Object> showDayBookJsp(Box box) {
		
		return accountDataService.showDayBookJsp(box);
	}

	@Override
	public Map<String, Object> displayDayBook(Box box) {
		
		return accountDataService.displayDayBook(box);
	}

	@Override
	public Map<String, Object> showChequeDetailJsp(Box box) {
		
		return accountDataService.showChequeDetailJsp(box);
	}

	@Override
	public Map<String, Object> submitChequeDetail(Box box) {
		
		return accountDataService.submitChequeDetail(box);
	}

	@Override
	public Map<String, Object> showChequePrintingJsp(Box box) {
		
		return accountDataService.showChequePrintingJsp(box);
	}

	@Override
	public Map<String, Object> cancelCheque(Box box) {
		
		return accountDataService.cancelCheque(box);
	}

	@Override
	public Map<String, Object> getChequeDetail(Box box) {
	
		return accountDataService.getChequeDetail(box);
	}

	@Override
	public Map<String, Object> showFixedDepositRegisterJsp(Box box) {
	
		return accountDataService.showFixedDepositRegisterJsp(box);
	}

	@Override
	public Map<String, Object> submitFixedDepositRegister(Box box) {
		
		return accountDataService.submitFixedDepositRegister(box);
	}

	@Override
	public Map<String, Object> editFixedDepositRegister(Box box) {
		
		return accountDataService.editFixedDepositRegister(box);
	}

	@Override
	public Map<String, Object> updateFixedDepositRegister(Box box) {
		
		return accountDataService.updateFixedDepositRegister(box);
	}

	@Override
	public Map<String, Object> showProfitAndLossAccountJsp(Box box) {
		
		return accountDataService.showProfitAndLossAccountJsp(box);
	}

	@Override
	public Map<String, Object> displayScheduleDetail(Box box) {
		
		return accountDataService.displayScheduleDetail(box);
	}

	@Override
	public Map<String, Object> showBalanceSheet(Box box) {
		
		return accountDataService.showBalanceSheet(box);
	}

	@Override
	public Map<String, Object> showEMDRegisterJsp(Box box) {
		
		return accountDataService.showEMDRegisterJsp(box);
	}

	@Override
	public Map<String, Object> submitEMDRegister(Box box) {
		
		return accountDataService.submitEMDRegister(box);
	}

	@Override
	public Map<String, Object> editEMDRegister(Box box) {
		
		return accountDataService.editEMDRegister(box);
	}

	@Override
	public Map<String, Object> updateEmdDepositRegister(Box box) {
		
		return accountDataService.updateEmdDepositRegister(box);
	}

	@Override
	public Map<String, Object> showAgingAnalysisJsp(Box box) {
	
		return accountDataService.showAgingAnalysisJsp(box);
	}

	@Override
	public Map<String, Object> displayAgingAnalysis(Box box) {
		
		return accountDataService.displayAgingAnalysis(box);
	}

	@Override
	public Map<String, Object> getCenterList(Box box) {
		
		return accountDataService.getCenterList(box);
	}

	@Override
	public Map<String, Object> dispalyInvoiceBillingAmount(Box box) {
		
		return accountDataService.dispalyInvoiceBillingAmount(box);
	}

	@Override
	public Map<String, Object> displayInvoiceSettlement(Box box) {
		
		return accountDataService.displayInvoiceSettlement(box);
	}

	@Override
	public Map<String, Object> displayCashSettlement(Box box) {
	
		return accountDataService.displayCashSettlement(box);
	}

	@Override
	public Map<String, Object> displaySRNMapping(Box box) {
		// TODO Auto-generated method stub
		return accountDataService.displaySRNMapping(box);
	}

	@Override
	public Map<String, Object> getHospitalName(Map<String, Object> mapForDs) {
		return accountDataService.getHospitalName(mapForDs);
	}

	@Override
	public Map<String, Object> getConnection() {
		return accountDataService.getConnection();
	}

	@Override
	public Map<String, Object> showPayrollMappingJsp(Box box) {
		
		return accountDataService.showPayrollMappingJsp(box);
	}

	@Override
	public Map<String, Object> displayPayrollMapping(Box box) {
	
		return accountDataService.displayPayrollMapping(box);
	}

	@Override
	public Map<String, Object> postInvoiceVoucherMapping(Box box) {
		
		return accountDataService.postInvoiceVoucherMapping(box);
	}

	@Override
	public Map<String, Object> showEmployeePayrollPopupJsp(Box box) {
	
		return accountDataService.showEmployeePayrollPopupJsp(box);
	}

	@Override
	public Map<String, Object> displayLegalApplicationMapping(Box box) {
		
		return accountDataService.displayLegalApplicationMapping(box);
	}

	@Override
	public Map<String, Object> postInvoiceSettlementVoucherMapping(Box box) {
		
		return accountDataService.postInvoiceSettlementVoucherMapping(box);
	}

	@Override
	public Map<String, Object> postCashSettlementVoucherMapping(Box box) {
		
		return accountDataService.postCashSettlementVoucherMapping(box);
	}

	@Override
	public Map<String, Object> postSrnMapping(Box box) {
		
		return accountDataService.postSrnMapping(box);
	}

	@Override
	public Map<String, Object> postPayrollVoucherMapping(Box box) {
		
		return accountDataService.postPayrollVoucherMapping(box);
	}

	@Override
	public Map<String, Object> showHrInsuranceDetailsJsp(
			Map<String, Object> generalMap) {
		return accountDataService.showHrInsuranceDetailsJsp(generalMap);
	}

	@Override
	public Map<String, Object> searchHrInsuranceDetailsJsp(
			String insuranceDetailsName) {
		return accountDataService.searchHrInsuranceDetailsJsp(insuranceDetailsName);
	}

	@Override
	public boolean addHrInsuranceDetails(HrInsuranceDetails hrInsuranceDetails) {
		return accountDataService.addHrInsuranceDetails(hrInsuranceDetails);
	}

	@Override
	public boolean editHrInsuranceDetailsToDatabase(
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return accountDataService.editHrInsuranceDetailsToDatabase(generalMap);
	}

	@Override
	public boolean deleteHrInsuranceDetails(int insuranceDetailsId,
			Map<String, Object> generalMap) {
		return accountDataService.deleteHrInsuranceDetails(insuranceDetailsId, generalMap);
	}

	@Override
	public Map<String, Object> displayProductionJournalVoucherMapping(Box box) {
		
		return accountDataService.displayProductionJournalVoucherMapping(box);
	}

	@Override
	public Map<String, Object> generateExcelProfitAndLossAccountJsp(Box box) {
		return accountDataService.generateExcelProfitAndLossAccountJsp(box);
	}
	@Override
	public Map<String, Object> generateBalanceSheetJsp(Box box) {
		return accountDataService.generateBalanceSheetJsp(box);
	}

	@Override
	public Map<String, Object> displayMarketingMapping(Box box) {
		
		return accountDataService.displayMarketingMapping(box);
	}

	@Override
	public Map<String, Object> showMarketingSubLedgerPopupJsp(
			Map<String, Object> generalMap) {
		
		return accountDataService.showMarketingSubLedgerPopupJsp(generalMap);
	}

	@Override
	public Map<String, Object> displayShareAllotmentMapping(Box box) {
		
		return accountDataService.displayShareAllotmentMapping(box);
	}

	@Override
	public Map<String, Object> displayShareAllotmentAdjustment(Box box) {
		
		return accountDataService.displayShareAllotmentAdjustment(box);
	}

	@Override
	public Map<String, Object> displayAllotmentReceiptVoucher(Box box) {
		
		return accountDataService.displayAllotmentReceiptVoucher(box);
	}

	@Override
	public Map<String, Object> postMarketingMapping(Box box) {
	
		return accountDataService.postMarketingMapping(box);
	}

	@Override
	public Map<String, Object> postLegalApplicationMapping(Box box) {
	
		return accountDataService.postLegalApplicationMapping(box);
	}

	@Override
	public Map<String, Object> postShareAllotmentMapping(Box box) {
		
		return accountDataService.postShareAllotmentMapping(box);
	}

	@Override
	public Map<String, Object> displayShareCallMapping(Box box) {
		
		return accountDataService.displayShareCallMapping(box);
	}

	@Override
	public Map<String, Object> showCashFlowStatementJsp(Box box) {
		
		return accountDataService.showCashFlowStatementJsp(box);
	}

	@Override
	public Map<String, Object> postShareCallMapping(Box box) {
		
		return accountDataService.postShareCallMapping(box);
	}

	@Override
	public Map<String, Object> postProductionMapping(Box box) {
		
		return accountDataService.postProductionMapping(box);
	}

	@Override
	public Map<String, Object> showGrowerPaymentJsp(Box box) {
	
		return accountDataService.showGrowerPaymentJsp(box);
	}
	
	@Override
	public MasStoreFinancial getFinancialYear() {
	
		return accountDataService.getFinancialYear();
	}

	@Override
	public Map<String, Object> getPendingPaymentList(Box box) {
		
		return accountDataService.getPendingPaymentList(box);
	}

	@Override
	public Map<String, Object> displayProductionPaymentJsp(Box box) {
		
		return accountDataService.displayProductionPaymentJsp(box);
	}

	@Override
	public Map<String, Object> submitProductionPaymentJsp(Box box) {
		
		return accountDataService.submitProductionPaymentJsp(box);
	}

	@Override
	public Map<String, Object> addAccountGroupNew(Map<String, Object> generalMap) {
		return accountDataService.addAccountGroupNew( generalMap);
	}

	@Override
	public Map<String, Object> updateAccountGroupNew(Box box) {
		return accountDataService.updateAccountGroupNew(box);
	}

	@Override
	public Map<String, Object> deleteAccountGroupNew(Box box) {
		return accountDataService.deleteAccountGroupNew(box);
	}

	@Override
	public Map<String, Object> showAccountSubGroupNew(Map<String, Object> generalMap) {
		return accountDataService.showAccountSubGroupNew(generalMap);
	}

	@Override
	public Map<String, Object> addAccountSubGroupNew(Map<String, Object> generalMap) {
		return accountDataService.addAccountSubGroupNew(generalMap);
	}

	@Override
	public boolean updateAccountSubGroupNew(Map<String, Object> generalMap) {
		return accountDataService.updateAccountSubGroupNew(generalMap);
	}

	@Override
	public boolean deleteAccountSubGroupNew(int accountGroupId,Map<String, Object> generalMap) {
		return accountDataService.deleteAccountSubGroupNew(accountGroupId,generalMap);
		}

	@Override
	public Map<String, Object> searchAccountGroupNew(Map<String, Object> generalMap) {
		return accountDataService.searchAccountGroupNew(generalMap);
	}

	@Override
	public Map<String, Object> searchAccountSubGroup(Map<String, Object> generalMap) {
		return accountDataService.searchAccountSubGroup(generalMap);
	}

	@Override
	public Map<String, Object> showAccountMasterNew(Map<String, Object> generalMap) {
		return accountDataService.showAccountMasterNew(generalMap) ;
	}

	@Override
	public boolean editAccountMasterNew(Map<String, Object> generalMap) {
		return accountDataService.editAccountMasterNew(generalMap);
	}

	@Override
	public boolean editAccountMaster(Map<String, Object> generalMap) {
		return accountDataService.editAccountMaster(generalMap);
	}

	@Override
	public Map<String, Object> submitOpeningBalance(Box box) {
		return accountDataService.submitOpeningBalance(box);
	}

	@Override
	public Map<String, Object> getConsolidatedTransactionDetails(Box box) {
		return accountDataService.getConsolidatedTransactionDetails(box);
	}

	@Override
	public List<Object[]> getAccountList(Box box) {
		return accountDataService.getAccountList(box);
	}

	@Override
	public List<Object[]> getSubledgerList(Box box) {
		return accountDataService.getSubledgerList(box);
	}

	@Override
	public Map<String, Object> getTransactionHistory(Box box) {
		return accountDataService.getTransactionHistory(box);
	}

	@Override
	public Map<String, Object> getConsolidatedBudgetOfDivision(Box box) {
		return accountDataService.getConsolidatedBudgetOfDivision(box);
	}

	@Override
	public List<Object[]> GetBudgetAmountForEachCentre(Box box) {
		return accountDataService.GetBudgetAmountForEachCentre(box);
	}

	@Override
	public Map<String, Object> GetBudgetComponentAmount(Box box) {
		return accountDataService.GetBudgetComponentAmount(box);
	}

	@Override
	public Map<String, Object> updateBudgetComponentAmount(Box box) {
		return accountDataService.updateBudgetComponentAmount(box);
	}

	@Override
	public Map<String, Object> submitFinalBudget(Box box) {
		return accountDataService.submitFinalBudget(box);
	}

	@Override
	public boolean approveFinalAccountsBudget(Box box) {
		return accountDataService.approveFinalAccountsBudget(box);
	}

	@Override
	public Map<String, Object> getGrowerPurchasePaymentHistory(Box box) {
		return accountDataService.getGrowerPurchasePaymentHistory(box);
	}

	@Override
	public int getAccountSubGroup(int accountId) {
		return accountDataService.getAccountSubGroup(accountId);
	}

	@Override
	public Map<String, Object> getBilingTransactionHistory(Box box) {
		return accountDataService.getBilingTransactionHistory(box);
	}

	@Override
	public Map<String, Object> getSalesTransactionHistory(Box box) {
		return accountDataService.getSalesTransactionHistory(box);
	}

	@Override
	public String getLocationName(int locationId) {
		return accountDataService.getLocationName(locationId);
	}

	@Override
	public Map<String, Object> showStatementProfitAndLossAcJsp(
			Map<String, Object> datamap) {
		return accountDataService.showStatementProfitAndLossAcJsp(datamap);
	}

	@Override
	public Map<String, Object> showStatementPLACJsp(
			Map<String, Object> generalMap) {
		return accountDataService.showStatementPLACJsp(generalMap);
	}

	@Override
	public boolean deleteAccount(int accountId, Map<String, Object> generalMap) {
		return accountDataService.deleteAccount(accountId, generalMap);
	}

	@Override
	public Map<String, Object> showScheduleMasterJsp(Map<String, Object> generalMap) {
		 return accountDataService.showScheduleMasterJsp(generalMap);
	}

	@Override
	public Map<String, Object> addScheduleMaster(Map<String, Object> generalMap) {
		return accountDataService.addScheduleMaster(generalMap);
	}

	@Override
	public Map<String, Object> updateScheduleMaster(Map<String, Object> generalMap) {
		return accountDataService.updateScheduleMaster(generalMap);
	}

	@Override
	public Map<String, Object> getScheduleList(Map<String, Object> dataMap) {
		return accountDataService.getScheduleList(dataMap);
	}

	@Override
	public Map<String, Object> deleteScheduleMaster(Map<String, Object> generalMap) {
		return accountDataService.deleteScheduleMaster(generalMap);
	}

	@Override
	public Map<String, Object> getSubGroupList(Map<String, Object> dataMap) {
		return accountDataService.getSubGroupList(dataMap);
	}

	@Override
	public Map<String, Object> displayScheduleDetailForProfitAndLoss(Box box) {
		return accountDataService.displayScheduleDetailForProfitAndLoss(box);
	}

	@Override
	public boolean editAccountSubLedger(Map<String, Object> generalMap) {
		return accountDataService.editAccountSubLedger(generalMap);
	}

	@Override
	public boolean deleteAccountSubLedger(int subLedgerId,
			Map<String, Object> generalMap) {
		return accountDataService.deleteAccountSubLedger(subLedgerId,generalMap);
	}

	@Override
	public Map<String, Object> searchScheduleMaster(Box box) {
		return accountDataService.searchScheduleMaster(box);
	}

	@Override
	public Map<String, Object> showBankJsp() {
		return accountDataService.showBankJsp();
	}

	@Override
	public Map<String, Object> searchBank(String bankCode, String bankName) {
		// TODO Auto-generated method stub
		return accountDataService.searchBank(bankCode,bankName);
	}

	@Override
	public boolean addBank(MasBankMaster masBank) {
		// TODO Auto-generated method stub
		return accountDataService.addBank(masBank);
	}

	@Override
	public boolean editBankToDatabase(Map<String, Object> editBankToDatabase) {
		// TODO Auto-generated method stub
		return accountDataService.editBankToDatabase(editBankToDatabase);
	}

	@Override
	public boolean deleteBank(int bankId, Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return accountDataService.deleteBank(bankId, generalMap);
	}

	@Override
	public String getAccountCode(int accountId) {
		// TODO Auto-generated method stub
		return accountDataService.getAccountCode(accountId);
	}

	@Override
	public Map<String, Object> pendingListForVoucherApproval(Box box) {
		// TODO Auto-generated method stub
		return accountDataService.pendingListForVoucherApproval(box);
	}

	@Override
	public Map<String, Object> getDataForVoucherApproval(
			Map<String, Object> map) {
		// TODO Auto-generated method stub
		return accountDataService.getDataForVoucherApproval(map);
	}

	@Override
	public Map<String, Object> displayRskPaymentVoucherDetails(Box box) {
		// TODO Auto-generated method stub
		return accountDataService.displayRskPaymentVoucherDetails(box);
	}

	@Override
	public List<FaMasSubLed> getSubLedListForAccountId(int accountId,
			int locationId) {
		// TODO Auto-generated method stub
		return accountDataService.getSubLedListForAccountId(accountId,locationId);
	}

	@Override
	public Map<String, Object> getSubledgerTransactionDetails(Box box) {
		// TODO Auto-generated method stub
		return accountDataService.getSubledgerTransactionDetails(box);
	}

	@Override
	public List<FaMasSubLed> getSubledgerDetails(Box box) {
		// TODO Auto-generated method stub
		return accountDataService.getSubledgerDetails(box);
	}

	@Override
	public List<MasApprovalStatus> getApprovalStatus() {
		// TODO Auto-generated method stub
		return accountDataService.getApprovalStatus();
	}

	@Override
	public Map<String, Object> submitPaymentVoucherApproval(Box box) {
		// TODO Auto-generated method stub
		return accountDataService.submitPaymentVoucherApproval(box);
	}

	@Override
	public Map<String, Object> getpendingListForReceiptVoucherAcceptance(Box box) {
		// TODO Auto-generated method stub
		return accountDataService.getpendingListForReceiptVoucherAcceptance(box);
	}

	@Override
	public Map<String, Object> getDataForReceiptVoucherAcceptance(
			Map<String, Object> generalMap) {
		// TODO Auto-generated method stub
		return accountDataService.getDataForReceiptVoucherAcceptance(generalMap);
	}

	@Override
	public Map<String, Object> submitReceiptVoucherAcceptance(Box box) {
		// TODO Auto-generated method stub
		return accountDataService.submitReceiptVoucherAcceptance(box);
	}

	@Override
	public Map<String, Object> submitJournalVoucherApproval(Box box) {
		// TODO Auto-generated method stub
		return accountDataService.submitJournalVoucherApproval(box);
	}

	@Override
	public List<MasStoreSupplier> getsupplierList(String unitType,int locationId) {
		// TODO Auto-generated method stub
		return accountDataService.getsupplierList(unitType,locationId);
	}

	@Override
	public Map<String, Object> submitSalesVoucherApproval(Box box) {
		// TODO Auto-generated method stub
		return accountDataService.submitSalesVoucherApproval(box);
	}

	@Override
	public Map<String, Object> submitPurchaseReturnVoucherApproval(Box box) {
		// TODO Auto-generated method stub
		return accountDataService.submitPurchaseReturnVoucherApproval(box);
	}

	@Override
	public Map<String, Object> submitReceiptVoucherApproval(Box box) {
		// TODO Auto-generated method stub
		return accountDataService.submitReceiptVoucherApproval(box);
	}

	

}