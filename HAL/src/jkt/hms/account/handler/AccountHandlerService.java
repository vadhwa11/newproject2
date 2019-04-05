package jkt.hms.account.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.HrInsuranceDetails;
import jkt.hms.masters.business.HrMasFinancialYear;
import jkt.hms.masters.business.FaMasNarration;
import jkt.hms.masters.business.FaMasSubLed;
import jkt.hms.masters.business.MasApprovalStatus;
import jkt.hms.masters.business.MasBankMaster;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.util.Box;

public interface AccountHandlerService {

	Map<String, Object> showAccountsGroupMasterJsp(Map<String, Object> generalMap);

	Map<String, Object> showAccountSubGroup(Map<String, Object> generalMap);

	Map<String, Object> searchAccountSubGroup(Box box);

	Map<String, Object> showAccountMasterJsp(Map<String, Object> generalMap);

	Map<String, Object> addAccountMaster(Map<String, Object> generalMap);

	Map<String, Object> searchAccountMaster(Box box);

	Map<String, Object> getAccCodeForAccSubGrp(Box box);

	Map<String, Object> showAccountSubLedgerJsp(Map<String, Object> detailsMap);

	Map<String, Object> searchAccountGroup(Box box);

	Map<String, Object> addAccountSubLedger(Map<String, Object> generalMap);

	Map<String, Object> showCashVoucherJsp(Box box);

	Map<String, Object> getAccountCodeForAutoComplete(
			Map<String, Object> parameterMap);

	Map<String, Object> getSubLedgerForAccount(Map<String, Object> parameterMap);

	Map<String, Object> addVoucherNarration(FaMasNarration faMasNarration);

	Map<String, Object> getNarrationForAutoComplete(Map<String, Object> parameterMap);

	Map<String, Object> showAccountBalance(Box box);

	Map<String, Object> getAccountNarrationForAutoComplete(
			Map<String, Object> parameterMap);

	Map<String, Object> submitReceiptVoucher(Box box);

	Map<String, Object> showPaymentVoucherJsp(Box box);

	Map<String, Object> submitPaymentVoucher(Box box);

	Map<String, Object> showSalesVoucherJsp(Map<String, Object> generalMap);

	Map<String, Object> submitSalesVoucher(Box box);

	Map<String, Object> showSalesReturnVoucherJsp(Map<String, Object> generalMap);

	Map<String, Object> submitSalesReturnVoucher(Box box);

	Map<String, Object> showBankReconciliationJsp(int fYear);

	Map<String, Object> getBankAccountDetailsForReconciliation(Box box);

	boolean saveBankReconciliationDetails(Box box);

	Map<String, Object> showJournalVoucherJsp(Box box);

	Map<String, Object> submitJournalVoucher(Box box);

	Map<String, Object> showTrialBalanceReportJsp();

	Map<String, Object> getConnectionForReport();

	Map<String, Object> showPurchaseVoucherJsp(Map<String, Object> generalMap);

	Map<String, Object> submitPurchaseVoucher(Box box);

	Map<String, Object> showPurchaseReturnVoucherJsp(Map<String, Object> generalMap);

	Map<String, Object> submitPurchaseReturnVoucher(Box box);

	//Map<String, Object> editAccountMaster(int accountId);
	
	Map<String, Object> editAccountMaster(Box box);

	Map<String, Object> updateAccountMaster(Box box);

	//Map<String, Object> editAccountSubLedger(Box box);

	Map<String, Object> updateAccountSubLedger(Box box);

	//Map<String, Object> submitAccountsParameter(Box box);
	//------------------- Sub Led Repory By Mansi

	Map<String, Object> showSubLedJsp();

	//Map<String, Object> showAccountParameterJsp(int fYear);

	Map<String, Object> searchAccountSubLedger(Box box);

	List<HrMasFinancialYear> getFinancialYearDate(int fYearId);

	Map<String, Object> getOpeningBalance(Map<String, Object> generalMap);

	Map<String, Object> showCashRegisterJsp(Box box);

	Map<String, Object> getBillingAmountForAccounts();

	Map<String, Object> getVoucherList(Map<String, Object> generalMap);

	Map<String, Object> showBankRegisterJsp();

	Map<String, Object> showBranchBalancePopupJsp();

	Map<String, Object> showBranchSubLedBalancePopupJsp();

	Map<String, Object> showLedgerAnalysisJsp();


	Map<String, Object> showVoucherMappingJsp(Box box);

	Map<String, Object> dispalySalesBillingAmount(Box box);

	Map<String, Object> postSalesVoucherMapping(Box box);

	Map<String, Object> showIpSalesVoucherMappingJsp(Box box);

	Map<String, Object> dispalyIpSalesBillingAmount(Box box);

	Map<String, Object> postSalesIpVoucherMapping(Box box);

	Map<String, Object> dispalyRefundBillingAmount(Box box);

	Map<String, Object> postRefundVoucherMapping(Box box);

	Map<String, Object> displayAdvanceVoucherBillingAmount(Box box);

	Map<String, Object> postAdvanceVoucherMapping(Box box);

	Map<String, Object> dispalyFinalSettlementVoucherAmount(Box box);

	Map<String, Object> postFinalSettlementVoucherMapping(Box box);

	Map<String, Object> showfavoucherJsp(int fYearId);

	Map<String, Object> closingFinancialYear(Box box);


	Map<String, Object> showVoucherReportJsp();

	Map<String, Object> showAccountOpeningJsp(int branchId);

	Map<String, Object> saveAccountOpening(Box box);

	Map<String, Object> updateAccountOpening(Box box);

	Map<String, Object> deleteAccountOpening(Box box);

	int getFinancialYearList(Map<String, Object> generalMap);

	Map<String, Object> getOpeningBalanceFromOpeningEntry(
			Map<String, Object> generalMap);

	Map<String, Object> showLedgerBookJsp();

	//Map<String, Object> showAccountGroupBalance(Map<String, Object> generalMap);

	Map<String, Object> showAccountSubGroupBalance(
			Map<String, Object> generalMap);


	Map<String, Object> showAccountSubLedgerBalance(
			Map<String, Object> generalMap);

	//Map<String, Object> showAccountMasterBalance(Map<String, Object> generalMap);

	Map<String, Object> showAccountParameterJsp(int fYear);

	Map<String, Object> submitAccountsParameter(Box box);

	int getFinancialYearId(Date voucherDate);

	Map<String, Object> getAccountId(Map<String, Object> remap);

	Map<String, Object> showAccountBalanceall(Map<String, Object> remap);

	Map<String, Object> addAccountSubGroup(Map<String, Object> generalMap);

	Map<String, Object> editAccountSubGroup(Map<String, Object> generalMap);

	Map<String, Object> updateAccountSubGroup(Map<String, Object> generalMap);

	Map<String, Object> showLedgerJsp(Box box);

	Map<String, Object> displayLedgerBook(Box box);

	Map<String, Object> showSubLedgerPopupJsp(Map<String, Object> generalMap);

	Map<String, Object> getTrialBalance(Box box);

	Map<String, Object> getSubGroupWiseTrialBalance(Box box);

	Map<String, Object> getAccountWiseTrialBalance(Box box);

	Map<String, Object> getVoucherWiseWiseTrialBalance(Box box);

	Map<String, Object> displayCashBook(Box box);

	Map<String, Object> displayBankBook(Box box);

	Map<String, Object> showDayBookJsp(Box box);

	Map<String, Object> displayDayBook(Box box);

	Map<String, Object> showChequeDetailJsp(Box box);

	Map<String, Object> submitChequeDetail(Box box);

	Map<String, Object> showChequePrintingJsp(Box box);

	Map<String, Object> cancelCheque(Box box);

	Map<String, Object> getChequeDetail(Box box);

	Map<String, Object> showFixedDepositRegisterJsp(Box box);

	Map<String, Object> submitFixedDepositRegister(Box box);

	Map<String, Object> editFixedDepositRegister(Box box);

	Map<String, Object> updateFixedDepositRegister(Box box);

	Map<String, Object> showProfitAndLossAccountJsp(Box box);

	Map<String, Object> displayScheduleDetail(Box box);

	Map<String, Object> showBalanceSheet(Box box);

	Map<String, Object> showEMDRegisterJsp(Box box);

	Map<String, Object> submitEMDRegister(Box box);

	Map<String, Object> editEMDRegister(Box box);

	Map<String, Object> updateEmdDepositRegister(Box box);

	Map<String, Object> showAgingAnalysisJsp(Box box);

	Map<String, Object> displayAgingAnalysis(Box box);

	Map<String, Object> getCenterList(Box box);

	Map<String, Object> dispalyInvoiceBillingAmount(Box box);

	Map<String, Object> displayInvoiceSettlement(Box box);

	Map<String, Object> displayCashSettlement(Box box);

	Map<String, Object> displaySRNMapping(Box box);

	Map<String, Object> getHospitalName(Map<String, Object> mapForDs);

	Map<String, Object> getConnection();

	Map<String, Object> showPayrollMappingJsp(Box box);

	Map<String, Object> displayPayrollMapping(Box box);

	Map<String, Object> postInvoiceVoucherMapping(Box box);

	Map<String, Object> showEmployeePayrollPopupJsp(Box box);

	Map<String, Object> displayLegalApplicationMapping(Box box);

	Map<String, Object> postInvoiceSettlementVoucherMapping(Box box);

	Map<String, Object> postCashSettlementVoucherMapping(Box box);

	Map<String, Object> postSrnMapping(Box box);

	Map<String, Object> postPayrollVoucherMapping(Box box);

	Map<String, Object> showHrInsuranceDetailsJsp(Map<String, Object> generalMap);

	Map<String, Object> searchHrInsuranceDetailsJsp(String insuranceDetailsName);

	boolean addHrInsuranceDetails(HrInsuranceDetails hrInsuranceDetails);

	boolean editHrInsuranceDetailsToDatabase(Map<String, Object> generalMap);

	boolean deleteHrInsuranceDetails(int insuranceDetailsId,
			Map<String, Object> generalMap);

	Map<String, Object> displayProductionJournalVoucherMapping(Box box);


	Map<String, Object> generateExcelProfitAndLossAccountJsp(Box box);

	Map<String, Object> generateBalanceSheetJsp(Box box);

	Map<String, Object> displayMarketingMapping(Box box);

	Map<String, Object> showMarketingSubLedgerPopupJsp(
			Map<String, Object> generalMap);

	Map<String, Object> displayShareAllotmentMapping(Box box);

	Map<String, Object> displayShareAllotmentAdjustment(Box box);

	Map<String, Object> displayAllotmentReceiptVoucher(Box box);

	Map<String, Object> postMarketingMapping(Box box);

	Map<String, Object> postLegalApplicationMapping(Box box);

	Map<String, Object> postShareAllotmentMapping(Box box);

	Map<String, Object> displayShareCallMapping(Box box);

	Map<String, Object> showCashFlowStatementJsp(Box box);

	Map<String, Object> postShareCallMapping(Box box);

	Map<String, Object> postProductionMapping(Box box);

	Map<String, Object> showGrowerPaymentJsp(Box box);

	Map<String, Object> getPendingPaymentList(Box box);

	Map<String, Object> displayProductionPaymentJsp(Box box);

	Map<String, Object> submitProductionPaymentJsp(Box box);

	Map<String, Object> addAccountGroupNew(Map<String, Object> generalMap);

	Map<String, Object> updateAccountGroupNew(Box box);

	Map<String, Object> deleteAccountGroupNew(Box box);

	Map<String, Object> showAccountSubGroupNew(Map<String, Object> generalMap);

	Map<String, Object> addAccountSubGroupNew(Map<String, Object> generalMap);

	boolean updateAccountSubGroupNew(Map<String, Object> generalMap);

	boolean deleteAccountSubGroupNew(int accountGroupId,
			Map<String, Object> generalMap);

	Map<String, Object> searchAccountGroupNew(Map<String, Object> generalMap);

	Map<String, Object> searchAccountSubGroup(Map<String, Object> generalMap);

	Map<String, Object> showAccountMasterNew(Map<String, Object> generalMap);

	boolean editAccountMasterNew(Map<String, Object> generalMap);

	boolean editAccountMaster(Map<String, Object> generalMap);

	Map<String, Object> submitOpeningBalance(Box box);

	Map<String, Object> getConsolidatedTransactionDetails(Box box);

	List<Object[]> getAccountList(Box box);

	List<Object[]> getSubledgerList(Box box);

	Map<String, Object> getTransactionHistory(Box box);

	Map<String, Object> getConsolidatedBudgetOfDivision(Box box);

	List<Object[]> GetBudgetAmountForEachCentre(Box box);

	Map<String, Object> GetBudgetComponentAmount(Box box);

	Map<String, Object> updateBudgetComponentAmount(Box box);

	Map<String, Object> submitFinalBudget(Box box);

	boolean approveFinalAccountsBudget(Box box);

	Map<String, Object> getGrowerPurchasePaymentHistory(Box box);

	int getAccountSubGroup(int accountId);

	Map<String, Object> getBilingTransactionHistory(Box box);

	Map<String, Object> getSalesTransactionHistory(Box box);

	String getLocationName(int locationId);

	Map<String, Object> showStatementProfitAndLossAcJsp(Map<String, Object> datamap);

	Map<String, Object> showStatementPLACJsp(Map<String, Object> generalMap);

	boolean deleteAccount(int accountId, Map<String, Object> generalMap);

	Map<String, Object> showScheduleMasterJsp(Map<String, Object> generalMap);

	Map<String, Object> addScheduleMaster(Map<String, Object> generalMap);

	Map<String, Object> updateScheduleMaster(Map<String, Object> generalMap);

	Map<String, Object> getScheduleList(Map<String, Object> dataMap);

	Map<String, Object> deleteScheduleMaster(Map<String, Object> generalMap);

	Map<String, Object> getSubGroupList(Map<String, Object> dataMap);

	Map<String, Object> displayScheduleDetailForProfitAndLoss(Box box);

	boolean editAccountSubLedger(Map<String, Object> generalMap);

	boolean deleteAccountSubLedger(int subLedgerId, Map<String, Object> generalMap);

	Map<String, Object> searchScheduleMaster(Box box);

	Map<String, Object> showBankJsp();

	Map<String, Object> searchBank(String bankCode, String bankName);

	boolean addBank(MasBankMaster masBank);

	boolean editBankToDatabase(Map<String, Object> generalMap);

	boolean deleteBank(int bankId, Map<String, Object> generalMap);

	String getAccountCode(int accountId);

	Map<String, Object> pendingListForVoucherApproval(Box box);

	Map<String, Object> getDataForVoucherApproval(Map<String, Object> map);

	Map<String, Object> displayRskPaymentVoucherDetails(Box box);

	List<FaMasSubLed> getSubLedListForAccountId(int accountId, int locationId);

	Map<String, Object> getSubledgerTransactionDetails(Box box);

	List<FaMasSubLed> getSubledgerDetails(Box box);

	List<MasApprovalStatus> getApprovalStatus();

	Map<String, Object> submitPaymentVoucherApproval(Box box);

	Map<String, Object> getpendingListForReceiptVoucherAcceptance(Box box);

	Map<String, Object> getDataForReceiptVoucherAcceptance(Map<String, Object> generalMap);

	Map<String, Object> submitReceiptVoucherAcceptance(Box box);

	Map<String, Object> submitJournalVoucherApproval(Box box);

	List<MasStoreSupplier> getsupplierList(String unitType,int locationId);

	Map<String, Object> submitSalesVoucherApproval(Box box);

	Map<String, Object> submitPurchaseReturnVoucherApproval(Box box);

	Map<String, Object> submitReceiptVoucherApproval(Box box);

	MasStoreFinancial getFinancialYear();



}
