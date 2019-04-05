package jkt.hms.referral.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hms.util.Box;

public interface ReferralHandlerService {

	Map<String, Object> getReferralWaitingList(Box box);

	Map<String, Object> generateReferralLetterPage(Box box);

	Map<String, Object> submitReferralLetterPage(Box box);

	Map<String, Object> getExcelWaitingList(Box box);

	Map<String, Object> getInvoiceWaitingList(Box box);

	Map<String, Object> generateInvoicePage(Box box);

	Map<String, Object> submitInvoicePage(Box box);

	Map<String, Object> getConnectionForReport();

	String getReportFlag(int referralPatientDetailsId);

	Map<String, Object> getInvoiceWaitingListForHRDivision(Box box);

	Map<String, Object> generateInvoicePageForHRDivision(Box box);

	Map<String, Object> submitInvoicePageForHRDivision(Box box);

	Map<String, Object> submitInvoicePageForFinanceDivision(Box box);

	Map<String, Object> submitInvoicePageForGM(Box box);

	Map<String, Object> getInvoiceWaitingListForFinanceDivision(Box box);

	Map<String, Object> getInvoiceWaitingListForGM(Box box);

	Map<String, Object> generateInvoicePageForFinanceDivision(Box box);

	Map<String, Object> generateInvoicePageForGM(Box box);

	Map<String, Object> generateExcelForPortal(Box box);
	
	Map<String, Object> uploadExcelForHAL(HttpServletRequest request);

	Map<String, Object> getInvoiceWaitingListForAll(Box box);

	Map<String, Object> generateInvoicePageForAll(Box box);

	Map<String, Object> generateInvoicePageForExtention(Box box);

	Map<String, Object> getWaitingListForReferralExtension(Box box);

	Map<String, Object> submitReferralExtension(Box box);

	Map<String, Object> getExtensionWaitingList(Box box);

	Map<String, Object> generateExtensionLetterPage(Box box);

	Map<String, Object> submitExtensionLetterPage(Box box);

	Map<String, Object> generateDivisionalApprovalLetter(Box box, HttpServletResponse response);

	Map<String, Object> getInvoiceWaitingFilterData(Box box);

	Map<String, Object> submitERPUpload(HttpServletRequest request);

	Map<String, Object> generateExtension(Box box);

	Map<String, Object> getReferralWaitingListForDoctor(Box box);

	Map<String, Object> DeleteFromDatabase_AddRemoveGrid(Box box);

	Map<String, Object> updateReferralDetails(Box box);

	Map<String, Object> generateInvoicePageAlreadySend(Box box);

	Map<String, Object> getInvoiceWaitingListAlreadySend(Box box);

	Map<String, Object> submitInvoicePageAlreadySend(Box box);

	String checkBillNo(Box box);

	Map<String, Object> getInvoiceWaitingListForNoteSheet(Box box);

	Map<String, Object> generateNoteSheetLetter(Box box);

	Map<String, Object> getInvoiceWaitingListForFA(Box box);

	Map<String, Object> approveFinanceAudit(Box box);

	Map<String, Object> getInvoiceWaitingListRejected(Box box);

	Map<String, Object> generateExcelForBillsPaybal(Box box);

	Map<String, Object> getInvoiceWaitingFilterDataPFD(Box box);

	Map<String, Object> getInvoiceWaitingListForPFD(Box box);

	Map<String, Object> approveFinanceAuditPFD(Box box);

	Map<String, Object> getInvoiceWaitingListForHRDivisionRejected(Box box);

	Map<String, Object> rejectFinanceAudit(Box box);

	Map<String, Object> getInvoiceWaitingFilterDataForReports(Box box);

	Map<? extends String, ? extends Object> getMedicalHR();

	Map<String, Object> revertToHRDivision(Box box);

	Map<String, Object> submitDeduction(Box box);

	Map<String, Object> generateReferralExcelReport(Box box,
			HttpServletResponse response);

	Map<String, Object> generateReferralExcelBillingReport(Box box,
			HttpServletResponse response);

	Map<String, Object> getReferralDashboardData(Box box);

	Map<? extends String, ? extends Object> accountedAndUnaccountedBills(Box box, HttpServletResponse response);

	Map<String, Object> submitERPUploadTemp(HttpServletRequest request);

	

	

	
}
