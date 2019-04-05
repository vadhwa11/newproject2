package jkt.hms.referral.handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import jkt.hms.masters.business.AppPatientAppointments;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasPatientType;
import jkt.hms.masters.business.MasTherapyType;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.referral.dataservice.ReferralDataService;
import jkt.hms.referral.handler.ReferralHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

public class ReferralHandlerServiceImpl implements ReferralHandlerService {

	ReferralDataService referralDataService = null;

	

	public ReferralDataService getReferralDataService() {
		return referralDataService;
	}



	public void setReferralDataService(ReferralDataService referralDataService) {
		this.referralDataService = referralDataService;
	}



	@Override
	public Map<String, Object> getReferralWaitingList(Box box) {
		return referralDataService.getReferralWaitingList(box);
	}
	
	@Override
	public Map<String, Object> getReferralWaitingListForDoctor(Box box) {
		return referralDataService.getReferralWaitingListForDoctor(box);
	}
	
	@Override
	public Map<String, Object> getExtensionWaitingList(Box box) {
		return referralDataService.getExtensionWaitingList(box);
	}
	
	@Override
	public Map<String, Object> getInvoiceWaitingList(Box box) {
		return referralDataService.getInvoiceWaitingList(box);
	}
	
	@Override
	public Map<String, Object> getInvoiceWaitingListRejected(Box box) {
		return referralDataService.getInvoiceWaitingListRejected(box);
	}
	
	@Override
	public Map<String, Object> getInvoiceWaitingListAlreadySend(Box box) {
		return referralDataService.getInvoiceWaitingListAlreadySend(box);
	}
	
	@Override
	public Map<String, Object> getInvoiceWaitingListForHRDivision(Box box) {
		return referralDataService.getInvoiceWaitingListForHRDivision(box);
	}
	
	@Override
	public Map<String, Object> getInvoiceWaitingListForHRDivisionRejected(Box box) {
		return referralDataService.getInvoiceWaitingListForHRDivisionRejected(box);
	}
	
	@Override
	public Map<String, Object> getInvoiceWaitingListForFinanceDivision(Box box) {
		return referralDataService.getInvoiceWaitingListForFinanceDivision(box);
	}
	
	@Override
	public Map<String, Object> getInvoiceWaitingListForGM(Box box) {
		return referralDataService.getInvoiceWaitingListForGM(box);
	}
	
	@Override
	public Map<String, Object> getInvoiceWaitingListForNoteSheet(Box box) {
		return referralDataService.getInvoiceWaitingListForNoteSheet(box);
	}
	

	@Override
	public Map<String, Object> getInvoiceWaitingListForFA(Box box) {
		return referralDataService.getInvoiceWaitingListForFA(box);
	}
	
	@Override
	public Map<String, Object> getInvoiceWaitingListForPFD(Box box) {
		return referralDataService.getInvoiceWaitingListForPFD(box);
	}
	
	@Override
	public Map<String, Object> getInvoiceWaitingFilterData(Box box) {
		return referralDataService.getInvoiceWaitingFilterData(box);
	}
	

	@Override
	public Map<String, Object> getInvoiceWaitingFilterDataForReports(Box box) {
		return referralDataService.getInvoiceWaitingFilterDataForReports(box);
	}
	
	@Override
	public Map<String, Object> accountedAndUnaccountedBills(Box box, HttpServletResponse response) {
		return referralDataService.accountedAndUnaccountedBills(box, response);
	}
	
	@Override
	public Map<String, Object> getInvoiceWaitingFilterDataPFD(Box box) {
		return referralDataService.getInvoiceWaitingFilterDataPFD(box);
	}
	
	@Override
	public Map<String, Object> getInvoiceWaitingListForAll(Box box) {
		return referralDataService.getInvoiceWaitingListForAll(box);
	}
	
	@Override
	public Map<String, Object> getReferralDashboardData(Box box) {
		return referralDataService.getReferralDashboardData(box);
	}
	
	@Override
	public Map<String, Object> getWaitingListForReferralExtension(Box box) {
		return referralDataService.getWaitingListForReferralExtension(box);
	}
	
	@Override
	public Map<String, Object> getExcelWaitingList(Box box) {
		return referralDataService.getExcelWaitingList(box);
	}
	
	@Override
	public Map<String, Object> generateReferralLetterPage(Box box) {
		return referralDataService.generateReferralLetterPage(box);
	}
	
	@Override
	public Map<String, Object> generateExtensionLetterPage(Box box) {
		return referralDataService.generateExtensionLetterPage(box);
	}
	
	@Override
	public Map<String, Object> generateInvoicePage(Box box) {
		return referralDataService.generateInvoicePage(box);
	}
	
	@Override
	public Map<String, Object> generateInvoicePageAlreadySend(Box box) {
		return referralDataService.generateInvoicePageAlreadySend(box);
	}
	
	
	@Override
	public Map<String, Object> generateInvoicePageForHRDivision(Box box) {
		return referralDataService.generateInvoicePageForHRDivision(box);
	}
	
	@Override
	public Map<String, Object> generateInvoicePageForGM(Box box) {
		return referralDataService.generateInvoicePageForGM(box);
	}
	
	@Override
	public Map<String, Object> generateInvoicePageForAll(Box box) {
		return referralDataService.generateInvoicePageForAll(box);
	}
	
	@Override
	public Map<String, Object> generateInvoicePageForExtention(Box box) {
		return referralDataService.generateInvoicePageForExtention(box);
	}
	
	
	@Override
	public Map<String, Object> generateInvoicePageForFinanceDivision(Box box) {
		return referralDataService.generateInvoicePageForFinanceDivision(box);
	}
	
	@Override
	public Map<String, Object> submitReferralLetterPage(Box box) {
		return referralDataService.submitReferralLetterPage(box);
	}
	
	@Override
	public Map<String, Object> submitExtensionLetterPage(Box box) {
		return referralDataService.submitExtensionLetterPage(box);
	}
	
	@Override
	public Map<String, Object> submitInvoicePage(Box box) {
		return referralDataService.submitInvoicePage(box);
	}
	
	@Override
	public Map<String, Object> submitInvoicePageAlreadySend(Box box) {
		return referralDataService.submitInvoicePageAlreadySend(box);
	}
	
	@Override
	public Map<String, Object> generateExtension(Box box) {
		return referralDataService.generateExtension(box);
	}
	
	@Override
	public Map<String, Object> updateReferralDetails(Box box) {
		return referralDataService.updateReferralDetails(box);
	}
	
	@Override
	public Map<String, Object> submitInvoicePageForHRDivision(Box box) {
		return referralDataService.submitInvoicePageForHRDivision(box);
	}
	
	@Override
	public String checkBillNo(Box box) {
		return referralDataService.checkBillNo(box);
	}
	
	@Override
	public Map<String, Object> submitInvoicePageForFinanceDivision(Box box) {
		return referralDataService.submitInvoicePageForFinanceDivision(box);
	}
	
	@Override
	public Map<String, Object> submitInvoicePageForGM(Box box) {
		return referralDataService.submitInvoicePageForGM(box);
	}
	
	@Override
	public Map<String, Object> generateDivisionalApprovalLetter(Box box, HttpServletResponse response) {
		return referralDataService.generateDivisionalApprovalLetter(box, response);
	}
	
	@Override
	public Map<String, Object> generateReferralExcelReport(Box box, HttpServletResponse response) {
		return referralDataService.generateReferralExcelReport(box, response);
	}
	
	@Override
	public Map<String, Object> generateReferralExcelBillingReport(Box box, HttpServletResponse response) {
		return referralDataService.generateReferralExcelBillingReport(box, response);
	}
	
	@Override
	public Map<String, Object> approveFinanceAudit(Box box) {
		return referralDataService.approveFinanceAudit(box);
	}
	
	
	@Override
	public Map<String, Object> revertToHRDivision(Box box) {
		return referralDataService.revertToHRDivision(box);
	}
	
	@Override
	public Map<String, Object> submitDeduction(Box box) {
		return referralDataService.submitDeduction(box);
	}
	
	@Override
	public Map<String, Object> rejectFinanceAudit(Box box) {
		return referralDataService.rejectFinanceAudit(box);
	}
	
	@Override
	public Map<String, Object> approveFinanceAuditPFD(Box box) {
		return referralDataService.approveFinanceAuditPFD(box);
	}
	
	@Override
	public Map<String, Object> generateNoteSheetLetter(Box box) {
		return referralDataService.generateNoteSheetLetter(box);
	}
	
	@Override
	public Map<String, Object> submitReferralExtension(Box box) {
		return referralDataService.submitReferralExtension(box);
	}
	
	@Override
	public Map<String, Object> getConnectionForReport() {
		return referralDataService.getConnectionForReport();
	}
	
	@Override
	public Map<String, Object> getMedicalHR() {
		return referralDataService.getMedicalHR();
	}
	
	
	@Override
	public String getReportFlag(int referralPatientDetailsId) {
		return referralDataService.getReportFlag(referralPatientDetailsId);
	}
	
	
	@Override
	public Map<String, Object> generateExcelForPortal(Box box) {
		return referralDataService.generateExcelForPortal(box);
	}
	
	@Override
	public Map<String, Object> generateExcelForBillsPaybal(Box box) {
		return referralDataService.generateExcelForBillsPaybal(box);
	}
	
	@Override
	public Map<String, Object> uploadExcelForHAL(HttpServletRequest request) {
		return referralDataService.uploadExcelForHAL(request);
	}
	
	@Override
	public Map<String, Object> submitERPUpload(HttpServletRequest request) {
		return referralDataService.submitERPUpload(request);
	}
	
	
	@Override
	public Map<String, Object> submitERPUploadTemp(HttpServletRequest request) {
		return referralDataService.submitERPUploadTemp(request);
	}



	@Override
	public Map<String, Object> DeleteFromDatabase_AddRemoveGrid(Box box) {
		return referralDataService.DeleteFromDatabase_AddRemoveGrid(box);
	}
	
	



	
	
}
