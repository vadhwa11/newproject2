package jkt.hms.library.handler;

import java.util.List;
import java.util.Map;

import jkt.hms.library.dataservice.LibraryDataService;
import jkt.hms.masters.business.LibBookIssueDetail;
import jkt.hms.masters.business.MasBookCategory;
import jkt.hms.masters.dataservice.CommonMasterDataService;
import jkt.hms.util.Box;

public class LibraryHandlerServiceImpl implements LibraryHandlerService {
	LibraryDataService libraryDataService = null;

	public LibraryDataService getLibraryDataService() {
		return libraryDataService;
	}

	public void setLibraryDataService(LibraryDataService libraryDataService) {
		this.libraryDataService = libraryDataService;
	}

	CommonMasterDataService commonMasterDataService = null;

	public CommonMasterDataService getCommonMasterDataService() {
		return commonMasterDataService;
	}

	public void setCommonMasterDataService(
			CommonMasterDataService commonMasterDataService) {
		this.commonMasterDataService = commonMasterDataService;
	}

	// ----------------------------------------------------------------------------------------------
	public Map<String, Object> showBookCategory() {
		return libraryDataService.showBookCategory();
	}

	public boolean addBookCategory(MasBookCategory masBookCategory) {
		return libraryDataService.addBookCategory(masBookCategory);
	}

	public boolean deleteBookCategory(int bookCategoryId,
			Map<String, Object> generalMap) {
		return libraryDataService
				.deleteBookCategory(bookCategoryId, generalMap);
	}

	public boolean editBookCategory(Map<String, Object> generalMap) {
		return libraryDataService.editBookCategory(generalMap);
	}

	public Map<String, Object> searchBookCategory(String bookCategoryCode,
			String bookCategoryName) {
		return libraryDataService.searchBookCategory(bookCategoryCode,
				bookCategoryName);
	}

	public boolean deleteBookClass(int bookClassId,
			Map<String, Object> generalMap) {
		return libraryDataService.deleteBookClass(bookClassId, generalMap);
	}

	public boolean editBookClass(Map<String, Object> generalMap) {
		return libraryDataService.editBookClass(generalMap);
	}

	public Map<String, Object> searchBookClass(String bookClassCode,
			String bookClassName) {
		return libraryDataService.searchBookClass(bookClassCode, bookClassName);
	}

	public Map<String, Object> addBookClass(Map<String, Object> dataMap) {
		return libraryDataService.addBookClass(dataMap);
	}

	public Map<String, Object> showBookClass() {
		return libraryDataService.showBookClass();
	}

	public Map<String, Object> addBookSubClass(Map<String, Object> dataMap) {
		return libraryDataService.addBookSubClass(dataMap);
	}

	public boolean deleteBookSubClass(int bookSubClassId,
			Map<String, Object> generalMap) {
		return libraryDataService
				.deleteBookSubClass(bookSubClassId, generalMap);
	}

	public boolean editBookSubClass(Map<String, Object> generalMap) {
		return libraryDataService.editBookSubClass(generalMap);
	}

	public Map<String, Object> searchBookSubClass(String bookSubClassCode,
			String bookSubClassName) {
		return libraryDataService.searchBookSubClass(bookSubClassCode,
				bookSubClassName);
	}

	public Map<String, Object> showBookSubClass() {
		return libraryDataService.showBookSubClass();
	}

	public Map<String, Object> showVendorMaster() {
		return libraryDataService.showVendorMaster();
	}

	public boolean deleteVendor(int vendorId, Map<String, Object> generalMap) {
		return libraryDataService.deleteVendor(vendorId, generalMap);
	}

	public Map<String, Object> addVendor(Map<String, Object> dataMap) {
		return libraryDataService.addVendor(dataMap);
	}

	public boolean editVendor(Map<String, Object> generalMap) {
		return libraryDataService.editVendor(generalMap);
	}

	public Map<String, Object> searchVendor(String vendorCode, String vendorName) {
		return libraryDataService.searchVendor(vendorCode, vendorName);
	}

	public Map<String, Object> showPublisherMaster() {
		return libraryDataService.showPublisherMaster();
	}

	public Map<String, Object> addPublisher(Map<String, Object> dataMap) {
		return libraryDataService.addPublisher(dataMap);
	}

	public boolean deletePublisher(int publisherId,
			Map<String, Object> generalMap) {
		return libraryDataService.deletePublisher(publisherId, generalMap);
	}

	public boolean editPublisher(Map<String, Object> generalMap) {

		return libraryDataService.editPublisher(generalMap);
	}

	public Map<String, Object> searchPublisher(String publisherCode,
			String publisherName) {
		return libraryDataService.searchPublisher(publisherCode, publisherName);
	}

	public Map<String, Object> showBookMaster() {
		return libraryDataService.showBookMaster();
	}

	public Map<String, Object> addBook(Map<String, Object> dataMap) {
		return libraryDataService.addBook(dataMap);
	}

	public boolean deleteBook(int bookId, Map<String, Object> generalMap) {
		return libraryDataService.deleteBook(bookId, generalMap);
	}

	public Map<String, Object> searchBook(String bookCode, String bookName) {
		return libraryDataService.searchBook(bookCode, bookName);
	}

	public boolean editBook(Map<String, Object> generalMap) {
		return libraryDataService.editBook(generalMap);
	}

	public Map<String, Object> SupplyOrderEntry(Box box,
			Map<String, Object> dataMap) {
		return libraryDataService.SupplyOrderEntry(box, dataMap);
	}

	public Map<String, Object> getBook(Map<String, Object> parameterMap) {
		return libraryDataService.getBook(parameterMap);
	}

	public Map<String, Object> fillItemsForBook(Map<String, Object> dataMap) {
		return libraryDataService.fillItemsForBook(dataMap);
	}

	public String generateSupplyOrderEntryNumber(Map<String, Object> diagMap) {
		return libraryDataService.generateSupplyOrderEntryNumber(diagMap);
	}

	public Map<String, Object> submitSupplyOrder(Box box,
			Map<String, Object> dataMap) {
		return libraryDataService.submitSupplyOrder(box, dataMap);
	}

	public String generateJournalReceiptNumber(Map<String, Object> diagMap) {
		return libraryDataService.generateJournalReceiptNumber(diagMap);
	}

	public Map<String, Object> submitJournalReceiptEntry(Box box,
			Map<String, Object> dataMap) {
		return libraryDataService.submitJournalReceiptEntry(box, dataMap);
	}

	public Map<String, Object> getjournalReceiptGrid(
			Map<String, Object> mapForDs) {
		return libraryDataService.getjournalReceiptGrid(mapForDs);
	}

	public Map<String, Object> getJournalDetail(Map<String, Object> dataMap) {
		return libraryDataService.getJournalDetail(dataMap);
	}

	public Map<String, Object> updateJournalReceiptEntry(Box box,
			Map<String, Object> dataMap) {
		return libraryDataService.updateJournalReceiptEntry(box, dataMap);
	}

	public String getSupplyOrderEntryNo(String string) {
		return libraryDataService.getSupplyOrderEntryNo(string);
	}

	public String getJournalReceiptNumber(String string) {
		return libraryDataService.getJournalReceiptNumber(string);
	}

	public Map<String, Object> getBookNameForAutoComplete(
			Map<String, Object> parameterMap) {
		return libraryDataService.getBookNameForAutoComplete(parameterMap);
	}

	public Map<String, Object> getSupplyOrderDetails(
			Map<String, Object> mapForDs) {
		return libraryDataService.getSupplyOrderDetails(mapForDs);
	}

	public Map<String, Object> getSupplyDetails(Map<String, Object> dataMap) {
		return libraryDataService.getSupplyDetails(dataMap);
	}

	public Map<String, Object> updateSupplyOrder(Box box,
			Map<String, Object> dataMap) {
		return libraryDataService.updateSupplyOrder(box, dataMap);
	}

	public Map<String, Object> showCrv(Box box, Map<String, Object> dataMap) {
		return libraryDataService.showCrv(box, dataMap);
	}

	public Map<String, Object> submitLibCrv(Box box, Map<String, Object> dataMap) {
		return libraryDataService.submitLibCrv(box, dataMap);
	}

	public String generateCRVNumber(Map<String, Object> diagMap) {

		return libraryDataService.generateCRVNumber(diagMap);
	}

	public String getCRVNo(String string) {
		return libraryDataService.getCRVNo(string);
	}

	public Map<String, Object> getCrvGrid(Map<String, Object> mapForDs) {
		return libraryDataService.getCrvGrid(mapForDs);
	}

	public Map<String, Object> getCRVDetails(Map<String, Object> dataMap) {
		return libraryDataService.getCRVDetails(dataMap);
	}

	public Map<String, Object> updateLibCrv(Box box, Map<String, Object> dataMap) {
		return libraryDataService.updateLibCrv(box, dataMap);
	}

	public Map<String, Object> getBookForJournal(
			Map<String, Object> parameterMap) {

		return libraryDataService.getBookForJournal(parameterMap);
	}

	// -------------methods By Dipali-----------
	public Map<String, Object> fillServiceDetail(Map<String, Object> dataMap) {
		return libraryDataService.fillServiceDetail(dataMap);
	}

	public String getIssueSeqNoForDisplay(String string) {
		return libraryDataService.getIssueSeqNoForDisplay(string);
	}

	public Map<String, Object> showBookIssueJsp() {
		return libraryDataService.showBookIssueJsp();
	}

	public String generateBookIssueNumber() {
		return libraryDataService.generateBookIssueNumber();
	}

	public boolean submitBookIssue(Map<String, Object> infoMap) {
		return libraryDataService.submitBookIssue(infoMap);
	}

	public Map<String, Object> showSearchBookIssue() {
		return libraryDataService.showSearchBookIssue();
	}

	public Map<String, Object> searchUpdateBookIssueJsp(
			Map<String, Object> mapForDs) {
		return libraryDataService.searchUpdateBookIssueJsp(mapForDs);
	}

	public Map<String, Object> showUpdateBlookissue(int bookIssueHdId) {
		return libraryDataService.showUpdateBlookissue(bookIssueHdId);
	}

	public Map<String, Object> showSearchBookReturnJs() {
		return libraryDataService.showSearchBookReturnJs();
	}

	public String getReturnSeqNoForDisplay(String string) {
		return libraryDataService.getReturnSeqNoForDisplay();
	}

	public Map<String, Object> showBookReturnJsp() {
		return libraryDataService.showBookReturnJsp();
	}

	public Map<String, Object> fillIssueDetail(Map<String, Object> dataMap) {
		return libraryDataService.fillIssueDetail(dataMap);
	}

	public List<LibBookIssueDetail> fillIssueBookDetail(String issueNo) {
		return libraryDataService.fillIssueBookDetail(issueNo);
	}

	public String generateBookReturnNumber() {
		return libraryDataService.generateBookReturnNumber();
	}

	public boolean submitBookReturn(Map<String, Object> infoMap) {
		return libraryDataService.submitBookReturn(infoMap);
	}

	public boolean updateBookIssue(Box box) {
		return libraryDataService.updateBookIssue(box);
	}

	public Map<String, Object> searchUpdateBookReturnJsp(
			Map<String, Object> mapForDs) {
		return libraryDataService.searchUpdateBookReturnJsp(mapForDs);
	}

	public Map<String, Object> showSearchBookReturn() {
		return libraryDataService.showSearchBookReturn();
	}

	public Map<String, Object> showUpdateBookReturn(int bookReturnHdId) {
		return libraryDataService.showUpdateBookReturn(bookReturnHdId);
	}

	public boolean updateBookReturn(Box box) {
		return libraryDataService.updateBookReturn(box);
	}

	public String getStockTakingNoForDisplay(String string) {
		return libraryDataService.getStockTakingNoForDisplay(string);
	}

	public Map<String, Object> showBookStockTakingJsp() {
		return libraryDataService.showBookStockTakingJsp();
	}

	public Map<String, Object> showBookIssueRegisterReport(Map map) {
		return libraryDataService.showBookIssueRegisterReport(map);
	}

	public Map<String, Object> showBookPendingRegisterReport(Map map) {
		return libraryDataService.showBookPendingRegisterReport(map);
	}

	public Map<String, Object> getConnectionForReport() {
		return libraryDataService.getConnectionForReport();
	}

	public Map<String, Object> getGridDataForStockTaking(Box box) {
		return libraryDataService.getGridDataForStockTaking(box);
	}

	public Map<String, Object> searchUpdateBookStock(
			Map<String, Object> mapForDs) {
		return libraryDataService.searchUpdateBookStock(mapForDs);
	}

	public Map<String, Object> showUpdateBookStock(int bookStockHdId) {
		return libraryDataService.showUpdateBookStock(bookStockHdId);
	}

	public boolean updateBookStock(Box box) {
		return libraryDataService.updateBookStock(box);
	}

	public String generateStockTakingNumber(Map<String, Object> diagMap) {
		return libraryDataService.generateStockTakingNumber(diagMap);
	}

	public Map<String, Object> submitBookStockTaking(Box box,
			Map<String, Object> dataMap) {
		return libraryDataService.submitBookStockTaking(box, dataMap);
	}

	@Override
	public Map<String, Object> getSupplyOrderDetailsCRV(
			Map<String, Object> mapForDs) {
		return libraryDataService.getSupplyOrderDetailsCRV(mapForDs);
	}

	@Override
	public Map<String, Object> updateBookIssue(Box box,
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return libraryDataService.updateBookIssue(box,dataMap);
	}

	public Map<String, Object> journalReceipt(Box box,	Map<String, Object> dataMap) {
		return libraryDataService.journalReceipt(box,dataMap);
	}
}
