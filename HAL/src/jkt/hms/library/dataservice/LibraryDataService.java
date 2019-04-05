package jkt.hms.library.dataservice;

import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.LibBookIssueDetail;
import jkt.hms.masters.business.MasBookCategory;
import jkt.hms.util.Box;

public interface LibraryDataService {
	public Map<String, Object> showBookCategory();

	public Map<String, Object> searchBookCategory(String bookCategoryCode,
			String bookCategoryName);

	public boolean deleteBookCategory(int bookCategoryId,
			Map<String, Object> generalMap);

	public boolean editBookCategory(Map<String, Object> generalMap);

	public boolean addBookCategory(MasBookCategory masBookCategory);

	public Map<String, Object> showBookClass();

	public Map<String, Object> addBookClass(Map<String, Object> dataMap);

	public boolean editBookClass(Map<String, Object> generalMap);

	public Map<String, Object> searchBookClass(String bookClassCode,
			String bookClassName);

	public boolean deleteBookClass(int bookClassId,
			Map<String, Object> generalMap);

	public Map<String, Object> showBookSubClass();

	public Map<String, Object> addBookSubClass(Map<String, Object> dataMap);

	public boolean editBookSubClass(Map<String, Object> generalMap);

	public Map<String, Object> searchBookSubClass(String bookSubClassCode,
			String bookSubClassName);

	public boolean deleteBookSubClass(int bookSubClassId,
			Map<String, Object> generalMap);

	public Map<String, Object> showVendorMaster();

	public boolean deleteVendor(int vendorId, Map<String, Object> generalMap);

	public Map<String, Object> addVendor(Map<String, Object> dataMap);

	public boolean editVendor(Map<String, Object> generalMap);

	public Map<String, Object> searchVendor(String vendorCode, String vendorName);

	public Map<String, Object> showPublisherMaster();

	public Map<String, Object> addPublisher(Map<String, Object> dataMap);

	public boolean editPublisher(Map<String, Object> generalMap);

	public boolean deletePublisher(int publisherId,
			Map<String, Object> generalMap);

	public Map<String, Object> searchPublisher(String publisherCode,
			String publisherName);

	public Map<String, Object> showBookMaster();

	public Map<String, Object> addBook(Map<String, Object> dataMap);

	public boolean deleteBook(int bookId, Map<String, Object> generalMap);

	public Map<String, Object> searchBook(String bookCode, String bookName);

	public boolean editBook(Map<String, Object> generalMap);

	public Map<String, Object> SupplyOrderEntry(Box box,
			Map<String, Object> dataMap);

	public Map<String, Object> getBook(Map<String, Object> parameterMap);

	public Map<String, Object> fillItemsForBook(Map<String, Object> dataMap);

	public String generateSupplyOrderEntryNumber(Map<String, Object> diagMap);

	public Map<String, Object> submitSupplyOrder(Box box,
			Map<String, Object> dataMap);

	public Map<String, Object> getSupplyOrderDetails(
			Map<String, Object> mapForDs);

	public String generateJournalReceiptNumber(Map<String, Object> diagMap);

	public Map<String, Object> submitJournalReceiptEntry(Box box,
			Map<String, Object> dataMap);

	public Map<String, Object> getjournalReceiptGrid(
			Map<String, Object> mapForDs);

	public Map<String, Object> getJournalDetail(Map<String, Object> dataMap);

	public Map<String, Object> updateJournalReceiptEntry(Box box,
			Map<String, Object> dataMap);

	public String getSupplyOrderEntryNo(String string);

	public String getJournalReceiptNumber(String string);

	public Map<String, Object> getSupplyDetails(Map<String, Object> dataMap);

	public Map<String, Object> updateSupplyOrder(Box box,
			Map<String, Object> dataMap);

	public Map<String, Object> showCrv(Box box, Map<String, Object> dataMap);

	public Map<String, Object> submitLibCrv(Box box, Map<String, Object> dataMap);

	public String generateCRVNumber(Map<String, Object> diagMap);

	public String getCRVNo(String string);

	public Map<String, Object> getCrvGrid(Map<String, Object> mapForDs);

	public Map<String, Object> getCRVDetails(Map<String, Object> dataMap);

	public Map<String, Object> updateLibCrv(Box box, Map<String, Object> dataMap);

	public Map<String, Object> getBookForJournal(
			Map<String, Object> parameterMap);

	// ----Method By Dipali------
	public Map<String, Object> fillServiceDetail(Map<String, Object> dataMap);

	public String getIssueSeqNoForDisplay(String string);

	public Map<String, Object> showBookIssueJsp();

	public Map<String, Object> getBookNameForAutoComplete(
			Map<String, Object> parameterMap);

	public String generateBookIssueNumber();

	public boolean submitBookIssue(Map<String, Object> infoMap);

	public Map<String, Object> showSearchBookIssue();

	public Map<String, Object> searchUpdateBookIssueJsp(
			Map<String, Object> mapForDs);

	public Map<String, Object> showUpdateBlookissue(int bookIssueHdId);

	public Map<String, Object> showSearchBookReturnJs();

	public String getReturnSeqNoForDisplay();

	public Map<String, Object> showBookReturnJsp();

	public Map<String, Object> fillIssueDetail(Map<String, Object> dataMap);

	public List<LibBookIssueDetail> fillIssueBookDetail(String issueNo);

	public String generateBookReturnNumber();

	public boolean submitBookReturn(Map<String, Object> infoMap);

	public boolean updateBookIssue(Box box);

	public Map<String, Object> showSearchBookReturn();

	public Map<String, Object> showUpdateBookReturn(int bookReturnHdId);

	public Map<String, Object> searchUpdateBookReturnJsp(
			Map<String, Object> mapForDs);

	public boolean updateBookReturn(Box box);

	public String getStockTakingNoForDisplay(String string);

	public Map<String, Object> showBookStockTakingJsp();

	public Map<String, Object> showBookIssueRegisterReport(Map map);

	public Map<String, Object> showBookPendingRegisterReport(Map map);

	public Map<String, Object> getConnectionForReport();

	public Map<String, Object> importStockTakingData(Box box);

	public Map<String, Object> getGridDataForStockTaking(Box box);

	public Map<String, Object> searchUpdateBookStock(
			Map<String, Object> mapForDs);

	public Map<String, Object> showUpdateBookStock(int bookStockHdId);

	public boolean updateBookStock(Box box);

	public String generateStockTakingNumber(Map<String, Object> diagMap);

	public Map<String, Object> submitBookStockTaking(Box box,
			Map<String, Object> dataMap);

	public Map<String, Object> getSupplyOrderDetailsCRV(Map<String, Object> mapForDs);

	public Map<String, Object> updateBookIssue(Box box,
			Map<String, Object> dataMap);

	public Map<String, Object> journalReceipt(Box box,Map<String, Object> dataMap);


}
