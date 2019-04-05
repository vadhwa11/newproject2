package jkt.hms.library.controller;
import static jkt.hms.util.RequestConstants.*;



import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.library.handler.LibraryHandlerService;
import jkt.hms.masters.business.LibBookIssueDetail;
import jkt.hms.masters.business.LibBookIssueHeader;
import jkt.hms.masters.business.LibBookReturnHd;
import jkt.hms.masters.business.LibCrvDt;
import jkt.hms.masters.business.LibJournalReceiptEntryDt;
import jkt.hms.masters.business.MasBook;
import jkt.hms.masters.business.MasBookCategory;
import jkt.hms.masters.business.MasBookClass;
import jkt.hms.masters.business.MasBookSubClass;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasPublisher;
import jkt.hms.masters.business.MasVendor;
import jkt.hms.masters.business.MlSupplyorderDetail;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class LibraryController extends MultiActionController {
	LibraryHandlerService libraryHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;

	public LibraryHandlerService getLibraryHandlerService() {
		return libraryHandlerService;
	}

	public void setLibraryHandlerService(
			LibraryHandlerService libraryHandlerService) {
		this.libraryHandlerService = libraryHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	// ------------------------------------------general-----------------------------------------------------------//
	HttpSession session = null;
	String jsp = "";
	String message = "";
	String title = "";
	String code = "";
	String name = "";
	String currentDate = "";
	String currentTime = "";
	String changedBy = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	String url = "";

	// ------------------------------------------general----------------------------------------------------------//

	/**
	 * --------------------------- method to show book category master
	 * -----------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showBookCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		map = libraryHandlerService.showBookCategory();
		jsp = BOOK_CATEGORY_JSP;
		jsp += ".jsp";
		title = "Book Category Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------------------ method to add book category
	 * master--------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView addBookCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasBookCategory masBookCategory = new MasBookCategory();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", code);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List bookCatCodeList = new ArrayList();
		List bookCatNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			bookCatCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			bookCatNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((bookCatCodeList.size() == 0 || bookCatCodeList == null)
				&& (bookCatNameList.size() == 0 || bookCatNameList == null)) {
			masBookCategory.setBookCategoryCode(code);
			masBookCategory.setBookCategoryName(name);
			masBookCategory.setStatus("y");
			masBookCategory.setLastChgBy(changedBy);
			masBookCategory.setLastChgDate(currentDate);
			masBookCategory.setLastChgTime(currentTime);
			successfullyAdded = libraryHandlerService
					.addBookCategory(masBookCategory);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((bookCatCodeList.size() != 0 || bookCatCodeList != null)
				|| (bookCatNameList.size() != 0) || bookCatNameList != null) {
			if ((bookCatCodeList.size() != 0 || bookCatCodeList != null)
					&& (bookCatNameList.size() == 0 || bookCatNameList == null)) {

				message = "Book Category Code  already exists.";
			} else if ((bookCatNameList.size() != 0 || bookCatNameList != null)
					&& (bookCatCodeList.size() == 0 || bookCatCodeList == null)) {

				message = "Book Category Name already exists.";
			} else if ((bookCatCodeList.size() != 0 || bookCatCodeList != null)
					&& (bookCatNameList.size() != 0 || bookCatNameList != null)) {

				message = "Book Category Code and Book Category Name already exist.";
			}
		}

		try {
			map = libraryHandlerService.showBookCategory();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BOOK_CATEGORY_JSP;
		title = "Add Book Category";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -------------------------------------- method to edit book Category
	 * -----------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView editBookCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String bookCategoryCode = "";
		String bookCategoryName = "";
		int bookCategoryId = 0;
		String changedTime = "";
		Date changedDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			bookCategoryId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			bookCategoryCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bookCategoryName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", bookCategoryId);
		generalMap.put("bookCategoryCode", bookCategoryCode);
		generalMap.put("name", bookCategoryName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List<MasBookCategory> existingBookCategoryNameList = (List<MasBookCategory>) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingBookCategoryNameList.size() == 0) {
			dataUpdated = libraryHandlerService.editBookCategory(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingBookCategoryNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/lib?method=showBookCategory";

		try {
			map = libraryHandlerService.showBookCategory();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BOOK_CATEGORY_JSP;
		title = "update Book Category";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------------------------ method to delete book Category
	 * ----------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView deleteBookCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int bookCategoryId = 0;
		String message = null;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			bookCategoryId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = libraryHandlerService.deleteBookCategory(bookCategoryId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/lib?method=showBookCategory";

		try {
			map = libraryHandlerService.showBookCategory();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BOOK_CATEGORY_JSP;
		title = "delete Book Category";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -------------------------------------- method to Search Book Category
	 * -----------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView searchBookCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String bookCategoryCode = null;
		String bookCategoryName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			bookCategoryCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bookCategoryName = request.getParameter(SEARCH_NAME);
		}

		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (searchRadio == 1) {
			bookCategoryCode = searchField;
			bookCategoryName = null;

		} else {
			bookCategoryCode = null;
			bookCategoryName = searchField;
		}
		map = libraryHandlerService.searchBookCategory(bookCategoryCode,
				bookCategoryName);

		jsp = BOOK_CATEGORY_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("bookCategoryCode", bookCategoryCode);
		map.put("bookCategoryName", bookCategoryName);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -------------------------------------- method to show bookclass Master
	 * ----------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showBookClass(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		map = libraryHandlerService.showBookClass();
		jsp = RequestConstants.BOOK_CLASS_JSP;
		jsp += ".jsp";
		title = "Book Class Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);

	}

	/**
	 * -------------------------------------- method to add Book Class Master
	 * -----------------------------------------
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView addBookClass(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int bookCategoryId = 0;
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}

		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}

		if (request.getParameter(RequestConstants.BOOK_CATEGORY_ID) != null) {
			bookCategoryId = Integer.parseInt(request
					.getParameter(RequestConstants.BOOK_CATEGORY_ID));
		}

		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", code);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List bookCodeList = new ArrayList();
		List bookNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			bookCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			bookNameList = (List) listMap.get("duplicateGeneralNameList");
		}

		if ((bookCodeList.size() == 0 || bookCodeList == null)
				&& (bookNameList.size() == 0 || bookNameList == null)) {
			dataMap.put("code", code);
			dataMap.put("name", name);
			dataMap.put("status", "y");
			dataMap.put("bookCategoryId", bookCategoryId);
			dataMap.put("changedBy", changedBy);
			dataMap.put("currentDate", currentDate);
			dataMap.put("currentTime", currentTime);
			Box box = HMSUtil.getBox(request);
			dataMap.put("box", box);
			map = libraryHandlerService.addBookClass(dataMap);
			saved = (Boolean) map.get("saved");
			if (saved == true) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((bookCodeList.size() != 0 || bookCodeList != null)
				|| (bookNameList.size() != 0) || bookNameList != null) {
			if ((bookCodeList.size() != 0 || bookCodeList != null)
					&& (bookNameList.size() == 0 || bookNameList == null)) {

				message = "Book Class Code  already exists.";
			} else if ((bookNameList.size() != 0 || bookNameList != null)
					&& (bookCodeList.size() == 0 || bookCodeList == null)) {

				message = "Book Class Name already exists.";
			} else if ((bookCodeList.size() != 0 || bookCodeList != null)
					&& (bookNameList.size() != 0 || bookNameList != null)) {

				message = "Book Class Code and Book Class Name already exist.";
			}

		}
		try {
			map = libraryHandlerService.showBookClass();

		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = RequestConstants.BOOK_CLASS_JSP;
		title = "Add Book Class";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -----------------------------------method to edit Book Class
	 * master---------------------------------------------
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView editBookClass(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int bookCategoryId = 0;
		int bookClassId = 0;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			bookClassId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}

		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}

		if (request.getParameter(RequestConstants.BOOK_CATEGORY_ID) != null) {
			bookCategoryId = Integer.parseInt(request
					.getParameter(RequestConstants.BOOK_CATEGORY_ID));
		}

		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("bookCategoryId", bookCategoryId);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("bookClassId", bookClassId);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		generalMap.put("changedBy", changedBy);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List<MasBookClass> existingBookClassList = (List<MasBookClass>) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingBookClassList.size() == 0) {
			dataUpdated = libraryHandlerService.editBookClass(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingBookClassList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/lib?method=showBookClass";

		try {
			map = libraryHandlerService.showBookClass();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RequestConstants.BOOK_CLASS_JSP;
		title = "update Book Class ";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------------------------- method to search book class Master
	 * ---------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView searchBookClass(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String bookClassCode = null;
		String bookClassName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			bookClassCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bookClassName = request.getParameter(SEARCH_NAME);
		}

		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (searchRadio == 1) {
			bookClassCode = searchField;
			bookClassName = null;

		} else {
			bookClassCode = null;
			bookClassName = searchField;
		}
		map = libraryHandlerService.searchBookClass(bookClassCode,
				bookClassName);

		jsp = RequestConstants.BOOK_CLASS_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("bookClassCode", bookClassCode);
		map.put("bookClassName", bookClassName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView deleteBookClass(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int bookClassId = 0;
		String message = null;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			bookClassId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = libraryHandlerService.deleteBookClass(bookClassId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/lib?method=showBookClass";

		try {
			map = libraryHandlerService.showBookClass();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RequestConstants.BOOK_CLASS_JSP;
		title = "delete Book Class Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -------------------------------------- method to show book subclass
	 * Master ----------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showBookSubClass(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		map = libraryHandlerService.showBookSubClass();
		jsp = RequestConstants.BOOK_SUB_CLASS_JSP;
		jsp += ".jsp";
		title = "Book Sub Class Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);

	}

	/**
	 * -------------------------------------- method to add Book sub Class
	 * Master -----------------------------------------
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView addBookSubClass(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int bookClassId = 0;
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}

		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}

		if (request.getParameter(RequestConstants.BOOK_CLASS_ID) != null) {
			bookClassId = Integer.parseInt(request
					.getParameter(RequestConstants.BOOK_CLASS_ID));
		}

		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", code);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List bookCodeList = new ArrayList();
		List bookNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			bookCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			bookNameList = (List) listMap.get("duplicateGeneralNameList");
		}

		if ((bookCodeList.size() == 0 || bookCodeList == null)
				&& (bookNameList.size() == 0 || bookNameList == null)) {
			dataMap.put("code", code);
			dataMap.put("name", name);
			dataMap.put("status", "y");
			dataMap.put("bookClassId", bookClassId);
			dataMap.put("changedBy", changedBy);
			dataMap.put("currentDate", currentDate);
			dataMap.put("currentTime", currentTime);
			Box box = HMSUtil.getBox(request);
			dataMap.put("box", box);
			map = libraryHandlerService.addBookSubClass(dataMap);
			saved = (Boolean) map.get("saved");
			if (saved == true) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((bookCodeList.size() != 0 || bookCodeList != null)
				|| (bookNameList.size() != 0) || bookNameList != null) {
			if ((bookCodeList.size() != 0 || bookCodeList != null)
					&& (bookNameList.size() == 0 || bookNameList == null)) {

				message = "Sub Class Code already exists.";
			} else if ((bookNameList.size() != 0 || bookNameList != null)
					&& (bookCodeList.size() == 0 || bookCodeList == null)) {

				message = "Sub Class Name already exists.";
			} else if ((bookCodeList.size() != 0 || bookCodeList != null)
					&& (bookNameList.size() != 0 || bookNameList != null)) {

				message = "Sub Class Code and Sub Class Name already exist.";
			}

		}
		try {
			map = libraryHandlerService.showBookSubClass();

		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = RequestConstants.BOOK_SUB_CLASS_JSP;
		title = "Add Book Sub Class";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -----------------------------------method to edit Book Sub Class
	 * master---------------------------------------------
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView editBookSubClass(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int bookClassId = 0;
		int bookSubClassId = 0;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			bookSubClassId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}

		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}

		if (request.getParameter(RequestConstants.BOOK_CLASS_ID) != null) {
			bookClassId = Integer.parseInt(request
					.getParameter(RequestConstants.BOOK_CLASS_ID));
		}

		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("bookSubClassId", bookSubClassId);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("bookClassId", bookClassId);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		generalMap.put("changedBy", changedBy);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List<MasBookSubClass> existingBookClassList = (List<MasBookSubClass>) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingBookClassList.size() == 0) {
			dataUpdated = libraryHandlerService.editBookSubClass(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingBookClassList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/lib?method=showBookSubClass";

		try {
			map = libraryHandlerService.showBookSubClass();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RequestConstants.BOOK_SUB_CLASS_JSP;
		title = "update Book Sub Class ";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------------------------- method to search book Sub class
	 * Master ---------------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView searchBookSubClass(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String bookSubClassCode = null;
		String bookSubClassName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			bookSubClassCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bookSubClassName = request.getParameter(SEARCH_NAME);
		}

		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (searchRadio == 1) {
			bookSubClassCode = searchField;
			bookSubClassName = null;

		} else {
			bookSubClassCode = null;
			bookSubClassName = searchField;
		}
		map = libraryHandlerService.searchBookSubClass(bookSubClassCode,
				bookSubClassName);

		jsp = RequestConstants.BOOK_SUB_CLASS_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("bookSubClassCode", bookSubClassCode);
		map.put("bookSubClassName", bookSubClassName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView deleteBookSubClass(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int bookSubClassId = 0;
		String message = null;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			bookSubClassId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = libraryHandlerService.deleteBookSubClass(bookSubClassId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/lib?method=showBookSubClass";

		try {
			map = libraryHandlerService.showBookSubClass();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RequestConstants.BOOK_SUB_CLASS_JSP;
		title = "delete Book Class Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ---------------------------------- methods for vendor
	 * master------------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showVendorMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		map = libraryHandlerService.showVendorMaster();
		jsp = RequestConstants.VENDOR;
		jsp += ".jsp";
		title = "Vendor Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addVendor(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int districtId = 0;
		int stateId = 0;
		String address1 = "";
		String address2 = "";
		String address3 = "";
		int pin = 0;
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}

		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}

		districtId = Integer.parseInt(request
				.getParameter(RequestConstants.DISTRICT_ID));

		stateId = Integer.parseInt(request
				.getParameter(RequestConstants.STATE_ID));

		if (request.getParameter(RequestConstants.PINCODE) != null
				&& !(request.getParameter(RequestConstants.PINCODE).equals(""))) {
			pin = Integer.parseInt(request
					.getParameter(RequestConstants.PINCODE));
		}
		if (request.getParameter(RequestConstants.ADDRESS) != null
				&& !(request.getParameter(RequestConstants.ADDRESS).equals(""))) {
			address1 = request.getParameter(RequestConstants.ADDRESS);
		}
		if (request.getParameter(RequestConstants.ADDRESS1) != null
				&& !(request.getParameter(RequestConstants.ADDRESS1).equals(""))) {
			address2 = request.getParameter(RequestConstants.ADDRESS1);
		}
		if (request.getParameter(RequestConstants.ADDRESS2) != null
				&& !(request.getParameter(RequestConstants.ADDRESS2).equals(""))) {
			address3 = request.getParameter(RequestConstants.ADDRESS2);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", code);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List vendorCodeList = new ArrayList();
		List vendorNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			vendorCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			vendorNameList = (List) listMap.get("duplicateGeneralNameList");
		}

		if ((vendorCodeList.size() == 0 || vendorCodeList == null)
				&& (vendorNameList.size() == 0 || vendorNameList == null)) {
			dataMap.put("code", code);
			dataMap.put("name", name);
			dataMap.put("status", "y");
			dataMap.put("stateId", stateId);
			dataMap.put("districtId", districtId);
			dataMap.put("currentDate", currentDate);
			dataMap.put("currentTime", currentTime);
			dataMap.put("pin", pin);
			dataMap.put("address1", address1);
			dataMap.put("address2", address2);
			dataMap.put("address3", address3);
			Box box = HMSUtil.getBox(request);
			dataMap.put("box", box);
			map = libraryHandlerService.addVendor(dataMap);
			saved = (Boolean) map.get("saved");
			if (saved == true) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((vendorCodeList.size() != 0 || vendorCodeList != null)
				|| (vendorNameList.size() != 0) || vendorNameList != null) {
			if ((vendorCodeList.size() != 0 || vendorCodeList != null)
					&& (vendorNameList.size() == 0 || vendorNameList == null)) {

				message = "Vendor Code  already exists.";
			} else if ((vendorNameList.size() != 0 || vendorNameList != null)
					&& (vendorCodeList.size() == 0 || vendorCodeList == null)) {

				message = "Vendor Name already exists.";
			} else if ((vendorCodeList.size() != 0 || vendorCodeList != null)
					&& (vendorNameList.size() != 0 || vendorNameList != null)) {

				message = "Vendor Code and Vendor Name already exist.";
			}

		}
		try {
			map = libraryHandlerService.showVendorMaster();

		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = RequestConstants.VENDOR;
		title = "Add Vendor";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView deleteVendor(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int vendorId = 0;
		String message = null;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			vendorId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = libraryHandlerService.deleteVendor(vendorId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/lib?method=showVendorMaster";

		try {
			map = libraryHandlerService.showVendorMaster();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RequestConstants.VENDOR;
		title = "delete Vendor";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchVendor(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String vendorCode = null;
		String vendorName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			vendorCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			vendorName = request.getParameter(SEARCH_NAME);
		}

		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (searchRadio == 1) {
			vendorCode = searchField;
			vendorName = null;

		} else {
			vendorCode = null;
			vendorName = searchField;
		}
		map = libraryHandlerService.searchVendor(vendorCode, vendorName);

		jsp = RequestConstants.VENDOR;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("vendorCode", vendorCode);
		map.put("vendorName", vendorName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editVendor(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int vendorId = 0;
		int districtId = 0;
		int stateId = 0;
		String address1 = "";
		String address2 = "";
		String address3 = "";
		int pin = 0;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			vendorId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}

		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}

		if (request.getParameter(RequestConstants.DISTRICT_ID) != null
				&& !(request.getParameter(RequestConstants.DISTRICT_ID)
						.equals("0"))) {
			districtId = Integer.parseInt(request
					.getParameter(RequestConstants.DISTRICT_ID));
		}
		if (request.getParameter(RequestConstants.STATE_ID) != null
				&& !(request.getParameter(RequestConstants.STATE_ID)
						.equals("0"))) {
			stateId = Integer.parseInt(request
					.getParameter(RequestConstants.STATE_ID));
		}

		if (request.getParameter(RequestConstants.PINCODE) != null
				&& !(request.getParameter(RequestConstants.PINCODE).equals(""))) {
			pin = Integer.parseInt(request
					.getParameter(RequestConstants.PINCODE));
		}
		if (request.getParameter(RequestConstants.ADDRESS) != null
				&& !(request.getParameter(RequestConstants.ADDRESS).equals(""))) {
			address1 = request.getParameter(RequestConstants.ADDRESS);
		}
		if (request.getParameter(RequestConstants.ADDRESS1) != null
				&& !(request.getParameter(RequestConstants.ADDRESS1).equals(""))) {
			address2 = request.getParameter(RequestConstants.ADDRESS1);
		}
		if (request.getParameter(RequestConstants.ADDRESS2) != null
				&& !(request.getParameter(RequestConstants.ADDRESS2).equals(""))) {
			address3 = request.getParameter(RequestConstants.ADDRESS2);
		}

		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("vendorId", vendorId);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		generalMap.put("changedBy", changedBy);
		if (stateId != '0') {
			generalMap.put("stateId", stateId);
		}
		if (districtId != '0') {
			generalMap.put("districtId", districtId);
		}
		generalMap.put("pin", pin);
		generalMap.put("address1", address1);
		generalMap.put("address2", address2);
		generalMap.put("address3", address3);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List<MasVendor> existingVendorList = (List<MasVendor>) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingVendorList.size() == 0) {
			dataUpdated = libraryHandlerService.editVendor(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingVendorList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/lib?method=showVendorMaster";

		try {
			map = libraryHandlerService.showVendorMaster();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RequestConstants.VENDOR;
		title = "update Vendor";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------------ methods for publisher master-------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showPublisherMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		map = libraryHandlerService.showPublisherMaster();
		jsp = RequestConstants.PUBLISHER;
		jsp += ".jsp";
		title = "Publisher Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addPublisher(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int districtId = 0;
		int stateId = 0;
		String address1 = "";
		String address2 = "";
		String address3 = "";
		int pin = 0;
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}

		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}

		districtId = Integer.parseInt(request
				.getParameter(RequestConstants.DISTRICT_ID));
		stateId = Integer.parseInt(request
				.getParameter(RequestConstants.STATE_ID));

		if (request.getParameter(RequestConstants.PINCODE) != null
				&& !(request.getParameter(RequestConstants.PINCODE).equals(""))) {
			pin = Integer.parseInt(request
					.getParameter(RequestConstants.PINCODE));
		}
		if (request.getParameter(RequestConstants.ADDRESS) != null
				&& !(request.getParameter(RequestConstants.ADDRESS).equals(""))) {
			address1 = request.getParameter(RequestConstants.ADDRESS);
		}
		if (request.getParameter(RequestConstants.ADDRESS1) != null
				&& !(request.getParameter(RequestConstants.ADDRESS1).equals(""))) {
			address2 = request.getParameter(RequestConstants.ADDRESS1);
		}
		if (request.getParameter(RequestConstants.ADDRESS2) != null
				&& !(request.getParameter(RequestConstants.ADDRESS2).equals(""))) {
			address3 = request.getParameter(RequestConstants.ADDRESS2);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", code);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List publisherCodeList = new ArrayList();
		List publisherNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			publisherCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			publisherNameList = (List) listMap.get("duplicateGeneralNameList");
		}

		if ((publisherCodeList.size() == 0 || publisherCodeList == null)
				&& (publisherNameList.size() == 0 || publisherNameList == null)) {
			dataMap.put("code", code);
			dataMap.put("name", name);
			dataMap.put("status", "y");
			dataMap.put("stateId", stateId);
			dataMap.put("districtId", districtId);
			dataMap.put("changedBy", changedBy);
			dataMap.put("currentDate", currentDate);
			dataMap.put("currentTime", currentTime);
			dataMap.put("pin", pin);
			dataMap.put("address1", address1);
			dataMap.put("address2", address2);
			dataMap.put("address3", address3);
			Box box = HMSUtil.getBox(request);
			dataMap.put("box", box);
			map = libraryHandlerService.addPublisher(dataMap);
			saved = (Boolean) map.get("saved");
			if (saved == true) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((publisherCodeList.size() != 0 || publisherCodeList != null)
				|| (publisherNameList.size() != 0) || publisherNameList != null) {
			if ((publisherCodeList.size() != 0 || publisherCodeList != null)
					&& (publisherNameList.size() == 0 || publisherNameList == null)) {

				message = "Publisher Code  already exists.";
			} else if ((publisherNameList.size() != 0 || publisherNameList != null)
					&& (publisherCodeList.size() == 0 || publisherCodeList == null)) {

				message = "Publisher Name already exists.";
			} else if ((publisherCodeList.size() != 0 || publisherCodeList != null)
					&& (publisherNameList.size() != 0 || publisherNameList != null)) {

				message = "Publisher Code and Publisher Name already exist.";
			}

		}
		try {
			map = libraryHandlerService.showPublisherMaster();

		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = RequestConstants.PUBLISHER;
		title = "Add Publisher";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchPublisher(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String publisherCode = null;
		String publisherName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			publisherCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			publisherName = request.getParameter(SEARCH_NAME);
		}

		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (searchRadio == 1) {
			publisherCode = searchField;
			publisherName = null;

		} else {
			publisherCode = null;
			publisherName = searchField;
		}
		map = libraryHandlerService.searchPublisher(publisherCode,
				publisherName);

		jsp = RequestConstants.PUBLISHER;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("publisherCode", publisherCode);
		map.put("publisherName", publisherName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editPublisher(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int publisherId = 0;
		int districtId = 0;
		int stateId = 0;
		String address1 = "";
		String address2 = "";
		String address3 = "";
		int pin = 0;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			publisherId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}

		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}

		if (request.getParameter(RequestConstants.DISTRICT_ID) != null) {
			districtId = Integer.parseInt(request
					.getParameter(RequestConstants.DISTRICT_ID));
		}
		if (request.getParameter(RequestConstants.STATE_ID) != null) {
			stateId = Integer.parseInt(request
					.getParameter(RequestConstants.STATE_ID));
		}

		if (request.getParameter(RequestConstants.PINCODE) != null
				&& !(request.getParameter(RequestConstants.PINCODE).equals(""))) {
			pin = Integer.parseInt(request
					.getParameter(RequestConstants.PINCODE));
		}
		if (request.getParameter(RequestConstants.ADDRESS) != null
				&& !(request.getParameter(RequestConstants.ADDRESS).equals(""))) {
			address1 = request.getParameter(RequestConstants.ADDRESS);
		}
		if (request.getParameter(RequestConstants.ADDRESS1) != null
				&& !(request.getParameter(RequestConstants.ADDRESS1).equals(""))) {
			address2 = request.getParameter(RequestConstants.ADDRESS1);
		}
		if (request.getParameter(RequestConstants.ADDRESS2) != null
				&& !(request.getParameter(RequestConstants.ADDRESS2).equals(""))) {
			address3 = request.getParameter(RequestConstants.ADDRESS2);
		}

		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("publisherId", publisherId);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("stateId", stateId);
		generalMap.put("districtId", districtId);
		generalMap.put("pin", pin);
		generalMap.put("address1", address1);
		generalMap.put("address2", address2);
		generalMap.put("address3", address3);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List<MasPublisher> existingVendorList = (List<MasPublisher>) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingVendorList.size() == 0) {
			dataUpdated = libraryHandlerService.editPublisher(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingVendorList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/lib?method=showPublisherMaster";

		try {
			map = libraryHandlerService.showPublisherMaster();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RequestConstants.PUBLISHER;
		title = "update Publisher";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView deletePublisher(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int publisherId = 0;
		String message = null;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			publisherId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = libraryHandlerService.deletePublisher(publisherId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/lib?method=showPublisherMaster";

		try {
			map = libraryHandlerService.showPublisherMaster();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RequestConstants.PUBLISHER;
		title = "delete Publisher";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------------ methods for book master-------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showBookMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		map = libraryHandlerService.showBookMaster();
		jsp = RequestConstants.BOOK;
		jsp += ".jsp";
		title = "Book Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addBook(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int bookCategoryId = 0;
		int bookClassId = 0;
		String authorName = "";
		String publicationYear = "";
		String edition = "";
		String location = "";
		int bookSubClassId = 0;
		String type = "";
		String volume = "";
		String pages = "";
		BigDecimal price = null;
		int deptId = 0;
		int publisherId = 0;
		Date purchaseDate = new Date();
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}

		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}

		if (request.getParameter(RequestConstants.BOOK_CATEGORY_ID) != null) {
			bookCategoryId = Integer.parseInt(request
					.getParameter(RequestConstants.BOOK_CATEGORY_ID));
		}
		if (request.getParameter(RequestConstants.BOOK_CLASS_ID) != null) {
			bookClassId = Integer.parseInt(request
					.getParameter(RequestConstants.BOOK_CLASS_ID));
		}

		if (request.getParameter(RequestConstants.BOOK_SUB_CLASS_ID) != null
				&& !(request.getParameter(RequestConstants.BOOK_SUB_CLASS_ID)
						.equals(""))) {
			bookSubClassId = Integer.parseInt(request
					.getParameter(RequestConstants.BOOK_SUB_CLASS_ID));
		}
		if (request.getParameter(RequestConstants.AUTHOR_NAME) != null
				&& !(request.getParameter(RequestConstants.AUTHOR_NAME)
						.equals(""))) {
			authorName = request.getParameter(RequestConstants.AUTHOR_NAME);
		}
		if (request.getParameter(RequestConstants.PUBLICATION_YEAR) != null
				&& !(request.getParameter(RequestConstants.PUBLICATION_YEAR)
						.equals(""))) {
			publicationYear = request
					.getParameter(RequestConstants.PUBLICATION_YEAR);
		}
		if (request.getParameter(RequestConstants.EDITION) != null
				&& !(request.getParameter(RequestConstants.EDITION).equals(""))) {
			edition = request.getParameter(RequestConstants.EDITION);
		}
		if (request.getParameter(RequestConstants.LOCATION) != null
				&& !(request.getParameter(RequestConstants.LOCATION).equals(""))) {
			location = request.getParameter(RequestConstants.LOCATION);
		}
		if (request.getParameter(RequestConstants.EDITION) != null
				&& !(request.getParameter(RequestConstants.EDITION).equals(""))) {
			type = request.getParameter(RequestConstants.EDITION);
		}
		if (request.getParameter(RequestConstants.VOLUME) != null
				&& !(request.getParameter(RequestConstants.VOLUME).equals(""))) {
			volume = request.getParameter(RequestConstants.VOLUME);
		}
		if (request.getParameter(RequestConstants.PAGES) != null
				&& !(request.getParameter(RequestConstants.PAGES).equals(""))) {
			pages = request.getParameter(RequestConstants.PAGES);
		}
		if (request.getParameter(RequestConstants.PRICE) != null
				&& !request.getParameter(RequestConstants.PRICE).equals("")) {
			price = new BigDecimal(request.getParameter(RequestConstants.PRICE));

		}
		if (request.getParameter(RequestConstants.DEPARTMENT_ID) != null
				&& !request.getParameter(RequestConstants.DEPARTMENT_ID)
						.equals("")) {
			deptId = Integer.parseInt(request
					.getParameter(RequestConstants.DEPARTMENT_ID));
		}

		if (request.getParameter(RequestConstants.PUBLISHER_ID) != null
				&& !request.getParameter(RequestConstants.PUBLISHER_ID).equals(
						"0")) {
			publisherId = Integer.parseInt(request
					.getParameter(RequestConstants.PUBLISHER_ID));
		}
		if (request.getParameter(RequestConstants.PURCHASE_DATE) != null
				&& !(request.getParameter(RequestConstants.PURCHASE_DATE)
						.equals("0"))) {
			purchaseDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(RequestConstants.PURCHASE_DATE));
		}

		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", code);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List bookCodeList = new ArrayList();
		List bookNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			bookCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			bookNameList = (List) listMap.get("duplicateGeneralNameList");
		}

		if ((bookCodeList.size() == 0 || bookCodeList == null)
				&& (bookNameList.size() == 0 || bookNameList == null)) {
			dataMap.put("code", code);
			dataMap.put("name", name);
			dataMap.put("status", "y");
			dataMap.put("bookCategoryId", bookCategoryId);
			dataMap.put("bookClassId", bookClassId);
			dataMap.put("bookSubClassId", bookSubClassId);
			dataMap.put("deptId", deptId);
			dataMap.put("publisherId", publisherId);
			dataMap.put("changedBy", changedBy);
			dataMap.put("currentDate", currentDate);
			dataMap.put("currentTime", currentTime);
			dataMap.put("authorName", authorName);
			dataMap.put("publicationYear", publicationYear);
			dataMap.put("purchaseDate", purchaseDate);
			dataMap.put("edition", edition);
			dataMap.put("location", location);
			dataMap.put("type", type);
			dataMap.put("volume", volume);
			dataMap.put("pages", pages);
			dataMap.put("price", price);

			Box box = HMSUtil.getBox(request);
			dataMap.put("box", box);
			map = libraryHandlerService.addBook(dataMap);
			saved = (Boolean) map.get("saved");
			if (saved == true) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((bookCodeList.size() != 0 || bookCodeList != null)
				|| (bookNameList.size() != 0) || bookNameList != null) {
			if ((bookCodeList.size() != 0 || bookCodeList != null)
					&& (bookNameList.size() == 0 || bookNameList == null)) {

				message = "Book Acc No.  already exists.";
			} else if ((bookNameList.size() != 0 || bookNameList != null)
					&& (bookCodeList.size() == 0 || bookCodeList == null)) {

				message = "Book Name already exists.";
			} else if ((bookCodeList.size() != 0 || bookCodeList != null)
					&& (bookNameList.size() != 0 || bookNameList != null)) {

				message = "Book Acc No. and Book Name already exist.";
			}

		}
		try {
			map = libraryHandlerService.showBookMaster();

		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = RequestConstants.BOOK;
		title = "Add BOOk";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView deleteBook(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int bookId = 0;
		String message = null;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			bookId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = libraryHandlerService.deleteBook(bookId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/lib?method=showBookMaster";

		try {
			map = libraryHandlerService.showBookMaster();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RequestConstants.BOOK;
		title = "delete Book";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String bookCode = null;
		String bookName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			bookCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bookName = request.getParameter(SEARCH_NAME);
		}

		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (searchRadio == 1) {
			bookCode = searchField;
			bookName = null;

		} else {
			bookCode = null;
			bookName = searchField;
		}
		map = libraryHandlerService.searchBook(bookCode, bookName);

		jsp = RequestConstants.BOOK;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("bookCode", bookCode);
		map.put("bookName", bookName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editBook(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int bookId = 0;
		int bookCategoryId = 0;
		int bookClassId = 0;
		String authorName = "";
		String publicationYear = "";
		String edition = "";
		String location = "";
		int bookSubClassId = 0;
		String type = "";
		String volume = "";
		String pages = "";
		BigDecimal price = null;
		int deptId = 0;
		int publisherId = 0;
		Date purchaseDate = new Date();

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			bookId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}

		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter(RequestConstants.BOOK_CATEGORY_ID) != null) {
			bookCategoryId = Integer.parseInt(request
					.getParameter(RequestConstants.BOOK_CATEGORY_ID));
		}
		if (request.getParameter(RequestConstants.BOOK_CLASS_ID) != null) {
			bookClassId = Integer.parseInt(request
					.getParameter(RequestConstants.BOOK_CLASS_ID));
		}

		if (request.getParameter(RequestConstants.BOOK_SUB_CLASS_ID) != null
				&& !(request.getParameter(RequestConstants.BOOK_SUB_CLASS_ID)
						.equals(""))) {
			bookSubClassId = Integer.parseInt(request
					.getParameter(RequestConstants.BOOK_SUB_CLASS_ID));
		}
		if (request.getParameter(RequestConstants.AUTHOR_NAME) != null
				&& !(request.getParameter(RequestConstants.AUTHOR_NAME)
						.equals(""))) {
			authorName = request.getParameter(RequestConstants.AUTHOR_NAME);
		}
		if (request.getParameter(RequestConstants.PUBLICATION_YEAR) != null
				&& !(request.getParameter(RequestConstants.PUBLICATION_YEAR)
						.equals(""))) {
			publicationYear = request
					.getParameter(RequestConstants.PUBLICATION_YEAR);
		}
		if (request.getParameter(RequestConstants.EDITION) != null
				&& !(request.getParameter(RequestConstants.EDITION).equals(""))) {
			edition = request.getParameter(RequestConstants.EDITION);
		}
		if (request.getParameter(RequestConstants.LOCATION) != null
				&& !(request.getParameter(RequestConstants.LOCATION).equals(""))) {
			location = request.getParameter(RequestConstants.LOCATION);
		}
		if (request.getParameter(RequestConstants.EDITION) != null
				&& !(request.getParameter(RequestConstants.EDITION).equals(""))) {
			type = request.getParameter(RequestConstants.EDITION);
		}
		if (request.getParameter(RequestConstants.VOLUME) != null
				&& !(request.getParameter(RequestConstants.VOLUME).equals(""))) {
			volume = request.getParameter(RequestConstants.VOLUME);
		}
		if (request.getParameter(RequestConstants.PAGES) != null
				&& !(request.getParameter(RequestConstants.PAGES).equals(""))) {
			pages = request.getParameter(RequestConstants.PAGES);
		}
		if (request.getParameter(RequestConstants.PRICE) != null
				&& !request.getParameter(RequestConstants.PRICE).equals("")) {
			price = new BigDecimal(request.getParameter(RequestConstants.PRICE));

		}
		if (request.getParameter(RequestConstants.DEPARTMENT_ID) != null
				&& !request.getParameter(RequestConstants.DEPARTMENT_ID)
						.equals("")) {
			deptId = Integer.parseInt(request
					.getParameter(RequestConstants.DEPARTMENT_ID));
		}

		if (request.getParameter(RequestConstants.PUBLISHER_ID) != null
				&& !request.getParameter(RequestConstants.PUBLISHER_ID).equals(
						"0")) {
			publisherId = Integer.parseInt(request
					.getParameter(RequestConstants.PUBLISHER_ID));
		}
		if (request.getParameter(RequestConstants.PURCHASE_DATE) != null
				&& !(request.getParameter(RequestConstants.PURCHASE_DATE)
						.equals("0"))) {
			purchaseDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(RequestConstants.PURCHASE_DATE));
		}

		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("bookId", bookId);
		generalMap.put("publisherId", publisherId);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("bookCategoryId", bookCategoryId);
		generalMap.put("bookClassId", bookClassId);
		generalMap.put("bookSubClassId", bookSubClassId);
		generalMap.put("deptId", deptId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("authorName", authorName);
		generalMap.put("publicationYear", publicationYear);
		generalMap.put("purchaseDate", purchaseDate);
		generalMap.put("edition", edition);
		generalMap.put("location", location);
		generalMap.put("type", type);
		generalMap.put("volume", volume);
		generalMap.put("pages", pages);
		generalMap.put("price", price);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List<MasBook> existingBookList = (List<MasBook>) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingBookList.size() == 0) {
			dataUpdated = libraryHandlerService.editBook(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingBookList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/lib?method=showBookMaster";

		try {
			map = libraryHandlerService.showBookMaster();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RequestConstants.BOOK;
		title = "update Book";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView supplyOrderEntry(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		Box box = HMSUtil.getBox(request);
		String entryNo = request.getParameter("entryNo");
		entryNo = libraryHandlerService.getSupplyOrderEntryNo(entryNo);

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		map = libraryHandlerService.SupplyOrderEntry(box, dataMap);
		jsp = RequestConstants.LIB_SUPPLY_ORDER_ENTRY;
		jsp = jsp + ".jsp";
		title = "Supply Order Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		if (entryNo != "") {
			map.put("entryNo", entryNo);
		}
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getBook(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		String nameField = "";
		String autoHint = "";
		if (request.getParameter("requiredField") != null) {
			nameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(nameField) != null) {
			autoHint = (request.getParameter(nameField));
		}

		parameterMap.put("autoHint", autoHint);

		map = libraryHandlerService.getBook(parameterMap);

		String jsp = "";
		jsp = "lib_responseForBook";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getBookForJournal(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		String nameField = "";
		String autoHint = "";
		if (request.getParameter("requiredField") != null) {
			nameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(nameField) != null) {
			autoHint = (request.getParameter(nameField));
		}

		parameterMap.put("autoHint", autoHint);

		map = libraryHandlerService.getBookForJournal(parameterMap);

		String jsp = "";
		jsp = "lib_responseForBook";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getBookNameForAutoComplete(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		String nameField = "";
		String autoHint = "";
		if (request.getParameter("requiredField") != null) {
			nameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(nameField) != null) {
			autoHint = (request.getParameter(nameField));
		}

		parameterMap.put("autoHint", autoHint);

		map = libraryHandlerService.getBookNameForAutoComplete(parameterMap);

		String jsp = "";
		jsp = "lib_responseStockBook";

		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unchecked")
	public void fillItemsForBook(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String bookName = "";

		try {
			if (request.getParameter("bookName") != null) {
				bookName = (request.getParameter("bookName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("bookName", bookName);
		StringBuffer sb = new StringBuffer();
		try {
			List<MasBook> bookList = new ArrayList<MasBook>();
			map = libraryHandlerService.fillItemsForBook(dataMap);
			if (map.get("bookList") != null) {
				bookList = (List) map.get("bookList");
			}

			sb.append("<items>");
			for (MasBook masBook : bookList) {
				int bookId = masBook.getId();
				String publication = masBook.getYearPublication();
				String edition = masBook.getEdition();
				String author = masBook.getAuthorName();
				BigDecimal cost = masBook.getPrice();
				sb.append("<item>");
				sb.append("<bookId>" + bookId + "</bookId>");

				if ((author == null) || (author.equals("")))
					sb.append("<author>" + "-" + "</author>");
				else
					sb.append("<author>" + author + "</author>");
				if ((publication == null) || (publication.equals("")))
					sb.append("<publication>" + "-" + "</publication>");
				else
					sb.append("<publication>" + publication + "</publication>");

				if (masBook.getPublisher() != null) {
					sb.append("<publisher>"
							+ masBook.getPublisher().getPublisherName()
							+ "</publisher>");
				} else {
					sb.append("<publisher>-</publisher>");
				}
				if (masBook.getPublisher() != null) {
					sb.append("<publisherId>" + masBook.getPublisher().getId()
							+ "</publisherId>");
				} else {
					sb.append("<publisherId></publisherId>");
				}
				if ((edition == null) || (edition.equals("")))
					sb.append("<edition>" + "-" + "</edition>");
				else
					sb.append("<edition>" + edition + "</edition>");

				if ((cost == null) || (cost.equals("")))
				{
					sb.append("<cost>" + "0.00" + "</cost>");
				}
				else{
					sb.append("<cost>" + cost + "</cost>");
				}
				sb.append("</item>");
			}
			sb.append("</items>");

		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public ModelAndView submitSupplyOrder(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		boolean saved = false;
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		List<MasVendor> vendorList = new ArrayList<MasVendor>();
		map = libraryHandlerService.SupplyOrderEntry(box, dataMap);
		vendorList = (ArrayList<MasVendor>) map.get("vendorList");
		map = libraryHandlerService.submitSupplyOrder(box, dataMap);
		saved = (Boolean) map.get("saved");
		if (saved == true) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}
		String entryNo = "";
		String temp = libraryHandlerService
				.generateSupplyOrderEntryNumber(diagMap);
		entryNo = request.getParameter("entryNo");
		entryNo = libraryHandlerService.getSupplyOrderEntryNo(entryNo);
		if (entryNo != "") {
			map.put("entryNo", entryNo);
		}

		jsp = RequestConstants.LIB_SUPPLY_ORDER_ENTRY;
		jsp += ".jsp";
		title = "Supply Order Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("vendorList", vendorList);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ---------- method to search for Supply Order Entry
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView searchSupplyOrderEntry(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		String supplyOrderNo = "";
		String quotationNo = "";
		String bookName = "";
		String accNo = "";
		int vendorId = 0;
		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		session = request.getSession();

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		Map<String, Object> dataMap = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		map = libraryHandlerService.SupplyOrderEntry(box, dataMap);
		if (request.getParameter(RequestConstants.SUPPLY_ORDER_NO) != null
				&& !(request.getParameter(RequestConstants.SUPPLY_ORDER_NO)
						.equals(""))) {
			supplyOrderNo = request
					.getParameter(RequestConstants.SUPPLY_ORDER_NO);
			mapForDs.put("supplyOrderNo", supplyOrderNo);
		}
		if (request.getParameter(RequestConstants.QUOTATION_NO) != null
				&& !(request.getParameter(RequestConstants.QUOTATION_NO)
						.equals(""))) {
			quotationNo = request.getParameter(RequestConstants.QUOTATION_NO);
			mapForDs.put("quotationNo", quotationNo);
		}
		if (request.getParameter(RequestConstants.BOOK_NAME) != null
				&& !(request.getParameter(RequestConstants.BOOK_NAME)
						.equals(""))) {
			bookName = request.getParameter(RequestConstants.BOOK_NAME);
			mapForDs.put("bookName", bookName);
		}
		if (request.getParameter(RequestConstants.BOOK_ACC_NO) != null
				&& !(request.getParameter(RequestConstants.BOOK_ACC_NO)
						.equals(""))) {
			accNo = request.getParameter(RequestConstants.BOOK_ACC_NO);
			mapForDs.put("accNo", accNo);
		}
		if (request.getParameter(RequestConstants.VENDOR_ID) != null
				&& !(request.getParameter(RequestConstants.VENDOR_ID)
						.equals(""))) {
			vendorId = Integer.parseInt(request
					.getParameter(RequestConstants.VENDOR_ID));
			mapForDs.put("vendorId", vendorId);
		}
		Map<String, Object> patientMap = new HashMap<String, Object>();
		patientMap = libraryHandlerService.getSupplyOrderDetails(mapForDs);

		jsp = RequestConstants.LIB_SEARCH_SUPPLY_ORDER_ENTRY + ".jsp";
		map.put("contentJsp", jsp);
		map.put("patientMap", patientMap);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------ method to update supply order entry
	 */
	/**
	 * ----------- method to update journal receipt entry
	 */
	public ModelAndView updateSupplyOrder(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		boolean saved = false;
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		String url = "";
		String entryNo = "";
		map = libraryHandlerService.updateSupplyOrder(box, dataMap);
		saved = (Boolean) map.get("saved");
		if (saved == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Try Again !!";
		}

		entryNo = libraryHandlerService.generateSupplyOrderEntryNumber(diagMap);
		if (entryNo != "") {
			map.put("entryNo", entryNo);
		}

		jsp = "messagelib";
		jsp += ".jsp";
		title = "Supply order Entry";
		url = "/hms/hms/lib?method=searchSupplyOrderEntry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("url", url);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------ method for journal receipt entry
	 */
	public ModelAndView journalReceipt(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		Box box = HMSUtil.getBox(request);
		String receiptNo = request.getParameter("receiptNo");
		receiptNo = libraryHandlerService.getJournalReceiptNumber(receiptNo);

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		map = libraryHandlerService.journalReceipt(box, dataMap);
		jsp = RequestConstants.LIB_JOURNAL_RECEIPT_ENTRY;
		jsp = jsp + ".jsp";
		title = "Journal Receipt Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		if (receiptNo != "") {
			map.put("receiptNo", receiptNo);
		}
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ---------- method for submitting records for journal entry
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView submitJournalReceiptEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		boolean saved = false;
		String receiptNo = "";
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		map = libraryHandlerService.submitJournalReceiptEntry(box, dataMap);
		saved = (Boolean) map.get("saved");
		if (saved == true) {
			message = "Journal receipt Entry Added successfully !!";
		} else {
			message = "Try Again !!";
		}



		try {
			Map<String, Object> diagMap = new HashMap<String, Object>();
			receiptNo =  libraryHandlerService.generateJournalReceiptNumber(diagMap);
			receiptNo = request.getParameter("receiptNo");
			receiptNo = libraryHandlerService.getJournalReceiptNumber(receiptNo);
			map = libraryHandlerService.journalReceipt(box, dataMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RequestConstants.LIB_JOURNAL_RECEIPT_ENTRY;
		title = "Journal Receipt Entry";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("receiptNo", receiptNo);
		return new ModelAndView("indexB", "map", map);
	/*	Map<String, Object> diagMap = new HashMap<String, Object>();
		receiptNo = libraryHandlerService.generateJournalReceiptNumber(diagMap);
		if (receiptNo != null) {
			map.put("receiptNo", receiptNo);
		}
		jsp = RequestConstants.LIB_JOURNAL_RECEIPT_ENTRY;
		jsp += ".jsp";
		title = "Journal Receipt Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);*/
	}

	/**
	 * ---------- method to search for journal receipt entry
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView searchJournalReceiptEntry(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		String receiptNo = "";
		String issueNo = "";
		String bookName = "";
		String accNo = "";
		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		session = request.getSession();

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		Map<String, Object> dataMap = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		if (request.getParameter(RequestConstants.RECEIPT_NO) != null
				&& !(request.getParameter(RequestConstants.RECEIPT_NO)
						.equals(""))) {
			receiptNo = request.getParameter(RequestConstants.RECEIPT_NO);
			mapForDs.put("receiptNo", receiptNo);
		}
		if (request.getParameter(RequestConstants.ISSUE_NO) != null
				&& !(request.getParameter(RequestConstants.ISSUE_NO).equals(""))) {
			issueNo = request.getParameter(RequestConstants.ISSUE_NO);
			mapForDs.put("issueNo", issueNo);
		}
		if (request.getParameter(RequestConstants.BOOK_NAME) != null
				&& !(request.getParameter(RequestConstants.BOOK_NAME)
						.equals(""))) {
			bookName = request.getParameter(RequestConstants.BOOK_NAME);
			mapForDs.put("bookName", bookName);
		}
		if (request.getParameter(RequestConstants.BOOK_ACC_NO) != null
				&& !(request.getParameter(RequestConstants.BOOK_ACC_NO)
						.equals(""))) {
			accNo = request.getParameter(RequestConstants.BOOK_ACC_NO);
			mapForDs.put("accNo", accNo);
		}
		System.out.println("receiptNo   in con " + receiptNo);
		Map<String, Object> patientMap = new HashMap<String, Object>();
		patientMap = libraryHandlerService.getjournalReceiptGrid(mapForDs);

		jsp = RequestConstants.LIB_SEARCH_JOURNAL_RECEIPT + ".jsp";
		map.put("contentJsp", jsp);
		map.put("patientMap", patientMap);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------ method for show update screen for supply order entry
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showEditSupplyOrderEntry(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<MlSupplyorderDetail> supplyDtList = new ArrayList<MlSupplyorderDetail>();
		int supplyId = 0;
		Box box = HMSUtil.getBox(request);
		if (request.getParameter("supplyId") != null
				&& !(request.getParameter("supplyId").equals("0"))) {
			supplyId = Integer.parseInt(request.getParameter("supplyId"));
			dataMap.put("supplyId", supplyId);
		}
		map = libraryHandlerService.getSupplyDetails(dataMap);
		if (dataMap.get("supplyDtList") != null) {
			supplyDtList = (List<MlSupplyorderDetail>) dataMap
					.get("supplyDtList");
		}
		map = libraryHandlerService.SupplyOrderEntry(box, dataMap);
		jsp = RequestConstants.LIB_UPDATE_SUPPLY_ORDER_ENTRY + ".jsp";
		map.put("contentJsp", jsp);
		map.put("supplyDtList", supplyDtList);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------ method for show update screen for journal receipt
	 * entry
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showEditJournalReceiptEntry(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<LibJournalReceiptEntryDt> journalDtList = new ArrayList<LibJournalReceiptEntryDt>();
		int receiptId = 0;
		Box box = HMSUtil.getBox(request);
		if (request.getParameter("receiptId") != null
				&& !(request.getParameter("receiptId").equals("0"))) {
			receiptId = Integer.parseInt(request.getParameter("receiptId"));
			dataMap.put("receiptId", receiptId);
		}
		map = libraryHandlerService.getJournalDetail(dataMap);
		if (dataMap.get("journalDtList") != null) {
			journalDtList = (List<LibJournalReceiptEntryDt>) dataMap
					.get("journalDtList");
		}
		map = libraryHandlerService.journalReceipt(box, dataMap);
		jsp = RequestConstants.LIB_UPDATE_JOURNAL_RECEIPT + ".jsp";
		map.put("contentJsp", jsp);
		map.put("journalDtList", journalDtList);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ----------- method to update journal receipt entry
	 */
	public ModelAndView updateJournalReceiptEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		boolean saved = false;
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		String url = "";
		String receiptNo = "";
		map = libraryHandlerService.updateJournalReceiptEntry(box, dataMap);
		saved = (Boolean) map.get("saved");
		if (saved == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Try Again !!";
		}

		receiptNo = libraryHandlerService.generateJournalReceiptNumber(diagMap);
		if (receiptNo != "") {
			map.put("receiptNo", receiptNo);
		}

		jsp = "messagelib";
		jsp += ".jsp";
		title = "Journal receipt Entry";
		url = "/hms/hms/lib?method=searchJournalReceiptEntry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("url", url);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -------------- method to show CRV
	 */
	public ModelAndView showCrv(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		Box box = HMSUtil.getBox(request);
		String crvNo = request.getParameter("crvNo");
		crvNo = libraryHandlerService.getCRVNo(crvNo);

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		map = libraryHandlerService.showCrv(box, dataMap);
		jsp = RequestConstants.LIB_CRV;
		jsp = jsp + ".jsp";
		title = "CRV Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		if (crvNo != "") {
			map.put("crvNo", crvNo);
		}
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public void fillItemsForCRV(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String bookName = "";

		try {
			if (request.getParameter("bookName") != null) {
				bookName = (request.getParameter("bookName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("bookName", bookName);
		StringBuffer sb = new StringBuffer();
		try {
			List<MasBook> bookList = new ArrayList<MasBook>();
			map = libraryHandlerService.fillItemsForBook(dataMap);
			if (map.get("bookList") != null) {
				bookList = (List) map.get("bookList");
			}

			sb.append("<items>");
			for (MasBook masBook : bookList) {
				int bookId = masBook.getId();
				String bookNo = masBook.getBookNo();
				String publication = masBook.getYearPublication();
				String author = masBook.getAuthorName();
				String volume = masBook.getVolume();

				sb.append("<item>");
				sb.append("<bookId>" + bookId + "</bookId>");
				sb.append("<bookNo>" + bookNo + "</bookNo>");
				if ((author == null) || (author.equals("")))
					sb.append("<author>" + "-" + "</author>");
				else
					sb.append("<author>" + author + "</author>");

				if (masBook.getPublisher() != null) {
					sb.append("<publisher>"
							+ masBook.getPublisher().getPublisherName()
							+ "</publisher>");
				} else {
					sb.append("<publisher>" + " - " + "</publisher>");
				}

				if (masBook.getPublisher() != null) {
					sb.append("<publisherId>" + masBook.getPublisher().getId()
							+ "</publisherId>");
				} else {
					sb.append("<publisherId>" + "" + "</publisherId>");
				}

				if ((publication == null) || (publication.equals("")))
					sb.append("<publication>" + "-" + "</publication>");
				else
					sb.append("<publication>" + publication + "</publication>");

				if ((volume != null) || (!volume.equals(""))) {
					sb.append("<volume>" + volume + "</volume>");
				} else {
					sb.append("<volume>" + "-" + "</volume>");
				}

				sb.append("</item>");
			}
			sb.append("</items>");

		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * ------------------ method to add crv
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView submitLibCrv(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		boolean saved = false;
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		BigDecimal billAmount = null;
		BigDecimal totalAmount = null;

		if (request.getParameter(RequestConstants.BILL_AMOUNT) != null
				&& !request.getParameter(RequestConstants.BILL_AMOUNT).equals(
						"")) {
			billAmount = new BigDecimal(request
					.getParameter(RequestConstants.BILL_AMOUNT));

		}
		if (request.getParameter(RequestConstants.TOTAL_AMOUNT) != null
				&& !request.getParameter(RequestConstants.TOTAL_AMOUNT).equals(
						"")) {
			totalAmount = new BigDecimal(request
					.getParameter(RequestConstants.TOTAL_AMOUNT));

		}
		dataMap.put("billAmount", billAmount);
		dataMap.put("totalAmount", totalAmount);
		List<MasVendor> vendorList = new ArrayList<MasVendor>();
		map = libraryHandlerService.SupplyOrderEntry(box, dataMap);
		vendorList = (ArrayList<MasVendor>) map.get("vendorList");
		map = libraryHandlerService.submitLibCrv(box, dataMap);
		saved = (Boolean) map.get("saved");
		if (saved == true) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}
		String crvNo = "";
		String temp = libraryHandlerService.generateCRVNumber(diagMap);
		crvNo = request.getParameter("crvNo");
		crvNo = libraryHandlerService.getCRVNo(crvNo);
		if (crvNo != "") {
			map.put("crvNo", crvNo);
		}

		jsp = RequestConstants.LIB_CRV;
		jsp += ".jsp";
		title = "CRV Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("vendorList", vendorList);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * --------------------method to search crv on basis of crv no
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView searchCrv(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		String crvNo = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		session = request.getSession();

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		Map<String, Object> dataMap = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		if (request.getParameter(RequestConstants.CRV) != null
				&& !(request.getParameter(RequestConstants.CRV).equals(""))) {
			crvNo = request.getParameter(RequestConstants.CRV);
			mapForDs.put("crvNo", crvNo);
		}
		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
			mapForDs.put("fromDate", fromDate);
		}

		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TO_DATE));
			mapForDs.put("toDate", toDate);
		}
		Map<String, Object> patientMap = new HashMap<String, Object>();
		patientMap = libraryHandlerService.getCrvGrid(mapForDs);

		jsp = RequestConstants.LIB_SEARCH_CRV + ".jsp";
		map.put("contentJsp", jsp);
		map.put("patientMap", patientMap);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------ method for show update screen for crv
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showEditLibCrv(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<LibCrvDt> crvDtList = new ArrayList<LibCrvDt>();
		int crvId = 0;
		Box box = HMSUtil.getBox(request);
		if (request.getParameter("crvId") != null
				&& !(request.getParameter("crvId").equals("0"))) {
			crvId = Integer.parseInt(request.getParameter("crvId"));
			dataMap.put("crvId", crvId);
		}
		map = libraryHandlerService.getCRVDetails(dataMap);
		if (dataMap.get("crvDtList") != null) {
			crvDtList = (List<LibCrvDt>) dataMap.get("crvDtList");
		}
		map = libraryHandlerService.showCrv(box, dataMap);
		jsp = RequestConstants.LIB_UPDATE_CRV + ".jsp";
		map.put("contentJsp", jsp);
		map.put("crvDtList", crvDtList);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -------------------method to update crv
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView updateLibCrv(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		List<LibCrvDt> crvDtList = new ArrayList<LibCrvDt>();
		boolean saved = false;
		BigDecimal billAmount = null;
		BigDecimal totalAmount = null;
		Box box = HMSUtil.getBox(request);
		if (request.getParameter(RequestConstants.BILL_AMOUNT) != null
				&& !request.getParameter(RequestConstants.BILL_AMOUNT).equals(
						"")) {
			billAmount = new BigDecimal(request
					.getParameter(RequestConstants.BILL_AMOUNT));

		}
		if (request.getParameter(RequestConstants.TOTAL_AMOUNT) != null
				&& !request.getParameter(RequestConstants.TOTAL_AMOUNT).equals(
						"")) {
			totalAmount = new BigDecimal(request
					.getParameter(RequestConstants.TOTAL_AMOUNT));

		}
		dataMap.put("totalAmount", totalAmount);
		dataMap.put("box", box);
		dataMap.put("billAmount", billAmount);
		String url = "";
		String crvNo = "";
		map = libraryHandlerService.updateLibCrv(box, dataMap);
		saved = (Boolean) map.get("saved");
		if (saved == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Try Again !!";
		}
		crvNo = libraryHandlerService.generateCRVNumber(diagMap);
		if (crvNo != "") {
			map.put("crvNo", crvNo);
		}
		map = libraryHandlerService.getCRVDetails(dataMap);
		if (dataMap.get("crvDtList") != null) {
			crvDtList = (List<LibCrvDt>) dataMap.get("crvDtList");
		}
		jsp = "messagelib";
		jsp += ".jsp";
		title = "CRV Entry";
		url = "/hms/hms/lib?method=searchCrv";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("url", url);
		map.put("crvDtList", crvDtList);
		return new ModelAndView("indexB", "map", map);
	}

	// =============================== end of methods by ABHA
	// -----------Methods By Dipali-----------------------
	public ModelAndView showBookIssueJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();

		map = (Map<String, Object>) libraryHandlerService.showBookIssueJsp();
		String issueSeqNo = "";
		issueSeqNo = request.getParameter("issueSeqNo");
		issueSeqNo = libraryHandlerService.getIssueSeqNoForDisplay(issueSeqNo);
		if (issueSeqNo != null) {
			map.put("issueSeqNo", issueSeqNo);
		}
		jsp = LIB_BOOK_ISSUE_JSP;
		jsp += ".jsp";
		title = "BookIssue";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public void fillServiceDetail(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		String serviceNo = "";

		try {
			if (request.getParameter("serviceNo") != null) {
				serviceNo = request.getParameter("serviceNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("serviceNo", serviceNo);
		map = libraryHandlerService.fillServiceDetail(dataMap);
		if (map.get("employeeList") != null) {
			employeeList = (List) map.get("employeeList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<items>");
			for (MasEmployee masEmployee : employeeList) {
				sb.append("<item>");
				sb.append("<employeeId>" + masEmployee.getId()
						+ "</employeeId>");
				sb.append("<name>" + masEmployee.getFirstName()+" "+ masEmployee.getMiddleName()+" "+masEmployee.getLastName()+ "</name>");

				if (masEmployee.getRank() != null) {
					sb.append("<rankId>" + masEmployee.getRank().getRankName()
							+ "</rankId>");
				} else {
					sb.append("<rankId>-</rankId>");
				}
				sb.append("</item>");
				break;
			}
			sb.append("</items>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<chargeCodes>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</chargeCodes>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public void fillAccNoForBook(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String bookName = "";
		try {
			if (request.getParameter("bookName") != null) {
				bookName = request.getParameter("bookName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("bookName", bookName);
		StringBuffer sb = new StringBuffer();
		try {
			List<MasBook> bookList = new ArrayList<MasBook>();
			map = libraryHandlerService.fillItemsForBook(dataMap);
			if (map.get("bookList") != null) {
				bookList = (List) map.get("bookList");
			}

			sb.append("<items>");
			for (MasBook masBook : bookList) {
				int bookId = masBook.getId();
				String bookNo = masBook.getBookNo();
				sb.append("<item>");
				sb.append("<bookId>" + bookId + "</bookId>");
				sb.append("<bookNo>" + bookNo + "</bookNo>");

				sb.append("</item>");
			}
			sb.append("</items>");

		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public ModelAndView submitBookIssue(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		int bookListLength = 0;

		List bookIssueDetailIdList = new ArrayList();
		List bookList = new ArrayList();
		List qtyList = new ArrayList();

		String userName = (String) session.getAttribute("userName");
		String date = "";
		String time = "";
		String changedBy = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		String issueSeqNo = "";
		int issuedBy = 0;
		int employeeId = 0;
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		LibBookIssueHeader bookIssueHeader = new LibBookIssueHeader();

		if (request.getParameter(ISSUED_BY) != null
				&& !request.getParameter(ISSUED_BY).equals("0")) {
			issuedBy = Integer.parseInt(request.getParameter(ISSUED_BY));
		}
		if (request.getParameter(EMPLOYEE_ID) != null
				&& !request.getParameter(EMPLOYEE_ID).equals("0")) {
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		if (request.getParameter(ISSUE_NO) != null) {
			issueSeqNo = request.getParameter(ISSUE_NO);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}

		if (employeeId != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			bookIssueHeader.setEmployee(masEmployee);
		}
		if (issuedBy != 0) {
			MasEmployee employee = new MasEmployee();
			employee.setId(issuedBy);
			bookIssueHeader.setIssuedBy(employee);
		}
		if (hospitalId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			bookIssueHeader.setHospital(masHospital);
		}
		String temp = libraryHandlerService.generateBookIssueNumber();
		bookIssueHeader.setIssueNo(issueSeqNo);
		bookIssueHeader.setIssueDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		bookIssueHeader.setLastChgBy(userName);
		bookIssueHeader.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		bookIssueHeader.setLastChgTime(time);
		infoMap.put("bookIssueHeader", bookIssueHeader);

		if (request.getParameter("hiddenValueCharge") != null) {
			bookListLength = Integer.parseInt(request
					.getParameter("hiddenValueCharge"));
		}System.out.println("bookListLength :"+bookListLength);
		int i = 1;
		for (int a = 1; a <= bookListLength; a++) {
			if (request.getParameter(BOOK_ID + a) != null
					&& !request.getParameter(BOOK_ID + a).equals("")) {
				bookList.add(request.getParameter(BOOK_ID + a));

			} else {
				bookList.add("");
			}
			if (request.getParameter(QUANTITY + i) != null
					&& !request.getParameter(QUANTITY + i).equals("")) {
				qtyList.add(request.getParameter(QUANTITY + i));

			} else {
				qtyList.add("");
			}
			if (request.getParameter(BOOK_ISSUE_DETAIL_ID + i) != null) {
				bookIssueDetailIdList.add(request
						.getParameter(BOOK_ISSUE_DETAIL_ID + i));
			} else {
				bookIssueDetailIdList.add("");
			}
			i++;
		}
		infoMap.put("issueSeqNo", issueSeqNo);
		infoMap.put("userName", userName);
		infoMap.put("bookList", bookList);
		infoMap.put("qtyList", qtyList);
		infoMap.put("bookIssueDetailIdList", bookIssueDetailIdList);

		boolean saved = false;
		String message = "";
		saved = libraryHandlerService.submitBookIssue(infoMap);
		if (saved) {
			message = "Book Issue Successfully !! ";
		} else {
			message = "Try Again!";
		}
		map = libraryHandlerService.showBookIssueJsp();

		map.put("message", message);

		String jsp = LIB_MSG_BOOK_ISSUE + ".jsp";
		map.put("contentJsp", jsp);
		map.put("issueSeqNo", issueSeqNo);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showSearchBookIssue(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();

		map = (Map<String, Object>) libraryHandlerService.showSearchBookIssue();
		jsp = LIB_SEARCH_BOOK_ISSUE;
		jsp += ".jsp";
		title = "BookIssue";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchUpdateBookIssueJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String issueNo = "";
		Date issueDate = null;
		int bookIssueHdId = 0;

		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
			mapForDs.put("serviceNo", serviceNo);
		}
		if (request.getParameter(ISSUE_DATE) != null
				&& !(request.getParameter(ISSUE_DATE).equals(""))) {
			issueDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(ISSUE_DATE));
			mapForDs.put("issueDate", issueDate);
		}
		if (request.getParameter(ISSUE_NO) != null
				&& !(request.getParameter(ISSUE_NO).equals(""))) {
			issueNo = request.getParameter(ISSUE_NO);
			mapForDs.put("issueNo", issueNo);
		}
		if (request.getParameter("bookIssueHdId") != null
				&& !(request.getParameter("bookIssueHdId").equals("0"))) {
			bookIssueHdId = Integer.parseInt(request
					.getParameter("bookIssueHdId"));
			mapForDs.put("bookIssueHdId", bookIssueHdId);
		}
		patientMap = libraryHandlerService.searchUpdateBookIssueJsp(mapForDs);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);

		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showUpdateBlookissue(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int bookIssueHdId = 0;
		if (request.getParameter("bookIssueHdId") != null
				&& !(request.getParameter("bookIssueHdId").equals("0"))) {
			bookIssueHdId = Integer.parseInt(request
					.getParameter("bookIssueHdId"));
			mapForDS.put("bookIssueHdId", bookIssueHdId);
		}

		if (bookIssueHdId != 0) {
			map = libraryHandlerService.showUpdateBlookissue(bookIssueHdId);
		}

		jsp = LIB_UPDATE_BOOK_ISSUE_JSP + ".jsp";
		map.put("contentJsp", jsp);
		map.put("bookIssueHdId", bookIssueHdId);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView updateBookIssue(HttpServletRequest request,HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		boolean saved = false;
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		String url = "";
		String issueSeqNo="";
		map = libraryHandlerService.updateBookIssue(box, dataMap);
		saved = (Boolean) map.get("saved");
		if (saved == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Try Again !!";
		}
		issueSeqNo = libraryHandlerService.generateBookIssueNumber();
		if (issueSeqNo != "") {
			map.put("issueSeqNo", issueSeqNo);
		}

		jsp = "messagelib";
		jsp += ".jsp";
		title = "Book Issue";
		url = "/hms/hms/lib?method=showSearchBookIssue";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("url", url);
		return new ModelAndView("indexB", "map", map);



	}






	// ----------------Book Stock Taking----------------

	public ModelAndView showBookStockTaking(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String stockSeqNo = "";
		stockSeqNo = libraryHandlerService.getStockTakingNoForDisplay("BSTN");
		map = libraryHandlerService.showBookStockTakingJsp();
		if (stockSeqNo != null) {
			map.put("stockSeqNo", stockSeqNo);
		}

		jsp = LIB_STOCK_TAKING_JSP;
		jsp += ".jsp";
		title = "BookIssue";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getGridDataForStockTaking(HttpServletRequest request,
			HttpServletResponse response) {

		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = libraryHandlerService.getGridDataForStockTaking(box);
		/*
		 * String stockSeqNo = ""; stockSeqNo =
		 * libraryHandlerService.getStockTakingNoForDisplay("BSTN"); if
		 * (stockSeqNo != null) { map.put("stockSeqNo", stockSeqNo); }
		 */
		jsp = LIB_STOCK_TAKING_JSP;
		jsp = jsp + ".jsp";
		title = "Stock Taking";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView submitBookStockTaking(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		boolean saved = false;
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		map = libraryHandlerService.submitBookStockTaking(box, dataMap);
		if (map.get("libHeaderId") != null) {
			box.put("libHeaderId", (Integer) map.get("libHeaderId"));
		}
		map.putAll(libraryHandlerService.getGridDataForStockTaking(box));
		saved = (Boolean) map.get("saved");
		if (saved == true) {
			message = "Record Added successfully !!";
		} else {
			message = "Try Again !!";
		}
		/*
		 * String stockSeqNo = ""; String temp =
		 * libraryHandlerService.generateStockTakingNumber(diagMap); if
		 * (stockSeqNo != "") { map.put("stockSeqNo", stockSeqNo); }
		 */
		jsp = RequestConstants.LIB_STOCK_TAKING_JSP;
		jsp += ".jsp";
		title = "LIB_STOCK_TAKING_JSP";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showUpdateBookStockTaking(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		jsp = LIB_SEARCH_BOOK_STOCK;
		jsp += ".jsp";
		title = "BookStock";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchUpdateBookStock(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String stockNo = "";
		Date stockDate = null;
		int bookStockHdId = 0;
		if (request.getParameter(DATE) != null
				&& !(request.getParameter(DATE).equals(""))) {
			stockDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DATE));
			mapForDs.put("stockDate", stockDate);
		}
		if (request.getParameter(STOCK_NO) != null
				&& !(request.getParameter(STOCK_NO).equals(""))) {
			stockNo = request.getParameter(STOCK_NO);
			mapForDs.put("stockNo", stockNo);
		}
		if (request.getParameter("bookStockHdId") != null
				&& !(request.getParameter("bookStockHdId").equals("0"))) {
			bookStockHdId = Integer.parseInt(request
					.getParameter("bookStockHdId"));
			mapForDs.put("bookStockHdId", bookStockHdId);
		}
		patientMap = libraryHandlerService.searchUpdateBookStock(mapForDs);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);

		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showUpdateBookStock(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int bookStockHdId = 0;
		if (request.getParameter("bookStockHdId") != null
				&& !(request.getParameter("bookStockHdId").equals("0"))) {
			bookStockHdId = Integer.parseInt(request
					.getParameter("bookStockHdId"));
			mapForDS.put("bookStockHdId", bookStockHdId);
		}
		if (bookStockHdId != 0) {
			map = libraryHandlerService.showUpdateBookStock(bookStockHdId);
		}
		jsp = LIB_UPDATE_BOOK_STOCK_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView updateBookStock(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);

		boolean bool = libraryHandlerService.updateBookStock(box);
		if (bool) {
			message = "Data  updated Successfully!!";
		} else {
			message = "Eror Occurred !! Try Again !!";
		}
		jsp = LIB_SEARCH_BOOK_STOCK;
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	// ---------Methods for reports----By Dipali--------------------

	public ModelAndView showBookIssueRegisterReprt(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		jsp = LIB_ISSUE_REGISET_REPORT;
		jsp += ".jsp";
		title = "Book Issue Register";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generateIssueRegisterReport(HttpServletRequest request,
			HttpServletResponse response) {
		String fromDate = null;
		String toDate = null;
		//Date fromDate = null;
		//Date toDate = null;
		String bookType = "";
		String query = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			if (request.getParameter(FROM_DATE) != null && !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE)));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType((request
								.getParameter(TO_DATE))));

			}
		/*	if (request.getParameter(FROM_DATE) != null && !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(FROM_DATE));
			}

			if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(TO_DATE));
			}*/
			System.out.println("fromDate--" + fromDate);
			query = " where issue_date between '" + fromDate + "' and '" + toDate + "'";
			query = query + " and status  = 'i'";
			if (request.getParameter(TYPE) != null
					&& !(request.getParameter(TYPE).equals("0"))) {
				if (!request.getParameter(TYPE).equalsIgnoreCase("All")) {
					bookType = request.getParameter(TYPE);
					query = query + " and types  = '" + bookType + "'";
				} else {
					bookType = "All";
				}
			}
			System.out.println("query  in cotroller  :" + query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = libraryHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("QUERY", query);
		parameters.put("type", bookType);
		//parameters.put("fromdate", fromDate);
		//parameters.put("todate", toDate);

		try {
			HMSUtil.generateReport("lib_JournalBookIssueRegister", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	public ModelAndView showJournalPendingRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		Map requestMap = new HashMap();
		map = libraryHandlerService.showBookPendingRegisterReport(map);
		jsp = LIB_BOOK_PENDING_REPORT;
		jsp += ".jsp";
		title = "Book Pending Report";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generateBookPendingReport(HttpServletRequest request,
			HttpServletResponse response) {

		String fromDate = null;
		String toDate = null;
		String bookType = "";
		String query = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE)));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType((request
								.getParameter(TO_DATE))));

			}
			System.out.println("fromDate--" + fromDate);
			query = " where issue_date between '" + fromDate + "' and '"
					+ toDate + "'";
			query = query + " and status  = 'i'";
			if (request.getParameter(TYPE) != null
					&& !(request.getParameter(TYPE).equals("0"))) {
				if (!request.getParameter(TYPE).equalsIgnoreCase("All")) {
					bookType = request.getParameter(TYPE);
					query = query + " and types  = '" + bookType + "'";
				} else {
					bookType = "All";
				}
			}
			System.out.println("query  in cotroller  :" + query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = libraryHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("QUERY", query);
		parameters.put("fromdate", fromDate);
		parameters.put("todate", toDate);
		parameters.put("type", bookType);

		try {
			HMSUtil.generateReport("lib_book_JournalPending", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}



	/**
	 * ----------------------- methods of reports by Abha
	 */
	public ModelAndView showNdfAccessionRegisterReprt(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = libraryHandlerService.showBookPendingRegisterReport(map);
		jsp = "ndf_register_report";
		jsp += ".jsp";
		title = "NDF Register Report";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showJournalRegisterReprt(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = libraryHandlerService.showBookPendingRegisterReport(map);
		jsp = "journal_receipt_register";
		jsp += ".jsp";
		title = "Journal Receipt Register Report";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView generateNdfReport(HttpServletRequest request,
			HttpServletResponse response) {
		String fromDate = null;
		String toDate = null;
		String query = "";
		int hospitalId = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		session = request.getSession();
		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE)));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType((request
								.getParameter(TO_DATE))));

			}
			fromDate = "'" + fromDate + "'";
			toDate = "'" + toDate + "'";
			System.out.println("fromDate  " + fromDate);
			System.out.println("toDate  " + toDate);
			// if (session.getAttribute("hospitalId") != null)
			// hospitalId = Integer.parseInt("" +
			// session.getAttribute("hospitalId"));
			query = " where lib_crv_hd.crv_date between '" + fromDate
					+ "' and '" + toDate + "'";
			// System.out.println("hospitalId  "+hospitalId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = libraryHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("QUERY", query);
		// parameters.put("hospitalId", hospitalId);

		try {

			HMSUtil.generateReport("ndf_accession_register", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView generateJournalReport(HttpServletRequest request,
			HttpServletResponse response) {
		Date fromDate = null;
		Date toDate = null;

		String query = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}

			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}

			query = " where lib_journal_receipt_entry_hd.receipt_date between '"
					+ fromDate + "' and '" + toDate + "'";

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = libraryHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("QUERY", query);
		try {

			HMSUtil.generateReport("journal_Receipt_Register", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// ====== end of methods by ABHA----------------



		/*@SuppressWarnings("unchecked")
		public ModelAndView supplyOrderEntryCRV(HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException,IllegalStateException {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> mapForDs = new HashMap<String, Object>();
			String supplyOrderNo = "";
			String userName = "";
			int hospitalId = 0;
			int deptId = 0;
			session = request.getSession();

			if (session.getAttribute("userName") != null)
				userName = (String) session.getAttribute("userName");
			if (session.getAttribute("hospitalId") != null)
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			if (session.getAttribute("deptId") != null)
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));

			Map<String, Object> dataMap = new HashMap<String, Object>();
			mapForDs.put("deptId", deptId);
			dataMap.put("deptId", deptId);
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("userName", userName);
			Box box = HMSUtil.getBox(request);
			dataMap.put("box", box);
			map = libraryHandlerService.SupplyOrderEntry(box, dataMap);
			if (request.getParameter(RequestConstants.SUPPLY_ORDER_NO) != null
					&& !(request.getParameter(RequestConstants.SUPPLY_ORDER_NO)
							.equals(""))) {
				supplyOrderNo = request
						.getParameter(RequestConstants.SUPPLY_ORDER_NO);
				mapForDs.put("supplyOrderNo", supplyOrderNo);
			}

			Map<String, Object> patientMap = new HashMap<String, Object>();
			patientMap = libraryHandlerService.getSupplyOrderDetailsCRV(mapForDs);

			jsp = RequestConstants.LIB_SEARCH_SUPPLY_ORDER_ENTRY + ".jsp";
			map.put("contentJsp", jsp);
			map.put("patientMap", patientMap);
			return new ModelAndView("indexB", "map", map);
		}*/
		@SuppressWarnings("unchecked")
		public ModelAndView supplyOrderEntryCRV(HttpServletRequest request,
				HttpServletResponse response) {

			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> dataMap = new HashMap<String, Object>();
			List<MlSupplyorderDetail> supplyDtList = new ArrayList<MlSupplyorderDetail>();
			int supplyId = 0;
			Box box = HMSUtil.getBox(request);
			if (request.getParameter(SUPPLY_ORDER_NO) != null
					&& !(request.getParameter(SUPPLY_ORDER_NO).equals("0"))) {
				supplyId = Integer.parseInt(request.getParameter(SUPPLY_ORDER_NO));
				dataMap.put("supplyId", supplyId);
			}

			map = libraryHandlerService.getSupplyDetails(dataMap);
			if (dataMap.get("supplyDtList") != null) {
				supplyDtList = (List<MlSupplyorderDetail>) dataMap.get("supplyDtList");
			}

			map = libraryHandlerService.SupplyOrderEntry(box, dataMap);

			jsp = SUPPLY_ORDER_NO_JSP;
			map.put("supplyDtList", supplyDtList);
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView(jsp, "map", map);

		}
		//--------------- Book Return--------

		public ModelAndView showBookReturnJsp(HttpServletRequest request,HttpServletResponse response)
		{

			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();

			session = request.getSession();

			map = (Map<String, Object>) libraryHandlerService.showBookReturnJsp();
			String returnSeqNo = "";
			returnSeqNo = request.getParameter("returnSeqNo");
			returnSeqNo = libraryHandlerService.getReturnSeqNoForDisplay(returnSeqNo);
			if (returnSeqNo != null) {
				map.put("returnSeqNo", returnSeqNo);
			}
			jsp = LIB_BOOK_RETURN_JSP;
			jsp += ".jsp";
			title = "Book Return";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("indexB", "map", map);
		}

		@SuppressWarnings("unchecked")
		public ModelAndView submitBookReturn(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> infoMap = new HashMap<String, Object>();
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			HttpSession session = request.getSession();
			int bookListLength = 0;
			List bookReturnDetailIdList = new ArrayList();
			List issueDtList = new ArrayList();
			List returnList = new ArrayList();

			String userName = (String) session.getAttribute("userName");
			String date = "";
			String time = "";
			String changedBy = "";
			date = (String) utilMap.get("currentDate");
			time = (String) utilMap.get("currentTime");
			String returnSeqNo = "";
			int receivedBy = 0;
			int issueHdId = 0;
			int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

			LibBookReturnHd bookReturnHd = new LibBookReturnHd();
			if (request.getParameter(RECEIVED_BY) != null
					&& !request.getParameter(RECEIVED_BY).equals("0")) {
				receivedBy = Integer.parseInt(request.getParameter(RECEIVED_BY));
			}
			if (request.getParameter(BOOK_ISSUE_HD_ID) != null
					&& !request.getParameter(BOOK_ISSUE_HD_ID).equals("0")) {
				issueHdId = Integer
						.parseInt(request.getParameter(BOOK_ISSUE_HD_ID));
			}
			if (request.getParameter(RETURN_NO) != null) {
				returnSeqNo = request.getParameter(RETURN_NO);
			}
			if (request.getParameter(CHANGED_BY) != null
					&& !(request.getParameter(CHANGED_BY).equals(""))) {
				changedBy = request.getParameter(CHANGED_BY);
			}

			if (receivedBy != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(receivedBy);
				bookReturnHd.setReceivedBy(masEmployee);
			}
			if (issueHdId != 0) {
				LibBookIssueHeader bookIssueHeader = new LibBookIssueHeader();
				bookIssueHeader.setId(issueHdId);
				bookReturnHd.setIssueHd(bookIssueHeader);
			}
			if (hospitalId != 0) {
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				bookReturnHd.setHospital(masHospital);
			}
			String temp = libraryHandlerService.generateBookReturnNumber();
			bookReturnHd.setReturnNo(returnSeqNo);
			bookReturnHd.setReturnDate(HMSUtil.convertStringTypeDateToDateType(date));
			bookReturnHd.setLastChgBy(userName);
			bookReturnHd.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
			bookReturnHd.setLastChgTime(time);
			infoMap.put("returnSeqNo", returnSeqNo);
			infoMap.put("bookReturnHd", bookReturnHd);

			if (request.getParameter("hiddenValueCharge") != null) {
				bookListLength = Integer.parseInt(request.getParameter("hiddenValueCharge"));
			}
			System.out.println("bookListLength---->"+bookListLength);
			int i = 1;
			for (int a = 1; a <= bookListLength; a++) {


				if (request.getParameter(BOOK_ISSUE_DETAIL_ID + a) != null
						&& !request.getParameter(BOOK_ISSUE_DETAIL_ID + a).equals(
								"0")) {
					issueDtList.add(request.getParameter(BOOK_ISSUE_DETAIL_ID + a));

				} else {
					issueDtList.add("");
				}
				if (request.getParameter(RETURN + i) != null
						&& !request.getParameter(RETURN + i).equals("")) {
					returnList.add(request.getParameter(RETURN + i));

				} else {
					returnList.add("");
				}

				if (request.getParameter(BOOK_RETURN_DT_ID + i) != null) {
					bookReturnDetailIdList.add(request
							.getParameter(BOOK_RETURN_DT_ID + i));
				} else {
					bookReturnDetailIdList.add("");
				}
				i++;
			}
			infoMap.put("issueDtList", issueDtList);
			infoMap.put("returnList", returnList);
			infoMap.put("bookReturnDetailIdList", bookReturnDetailIdList);

			System.out.println("returnList---->"+returnList.size());
			System.out.println("issueDtList---->"+issueDtList.size());

			boolean saved = false;
			String message = "";
			saved = libraryHandlerService.submitBookReturn(infoMap);
			if (saved) {
				message = "Book Return done Successfully !! ";
			} else {
				message = "Try Again!Either book already been returned or no book to return ";
			}
			map.put("message", message);

			String jsp = LIB_MSG_BOOK_RETURN + ".jsp";
			map.put("contentJsp", jsp);
			map.put("returnSeqNo", returnSeqNo);
			return new ModelAndView("indexB", "map", map);
		}

		public ModelAndView showSearchBookReturnJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();

			jsp = LIB_SEARCH_BOOK_RETURN_JSP;
			jsp += ".jsp";
			title = "SearchBookReturn";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("indexB", "map", map);
		}

		public ModelAndView fillIssueBookDetail(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			String issueNo = "";
			String flag = "";
			List<LibBookIssueDetail> issueDtList = new ArrayList<LibBookIssueDetail>();
			if (request.getParameter("issueNo") != null) {
				issueNo = request.getParameter("issueNo");
			}
			issueDtList = libraryHandlerService.fillIssueBookDetail(issueNo);
			if (issueDtList.size() > 0) {
				map.put("issueDtList", issueDtList);
			}
			String jsp = "lib_responseIssueDetail";
			return new ModelAndView(jsp, "map", map);
		}
		public ModelAndView searchUpdateBookReturnJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> mapForDs = new HashMap<String, Object>();
			Map<String, Object> patientMap = new HashMap<String, Object>();
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			String serviceNo = "";
			String returnNo = "";
			Date returnDate = null;
			int bookReturnHdId = 0;
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(RETURN_DATE) != null
					&& !(request.getParameter(RETURN_DATE).equals(""))) {
				returnDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(RETURN_DATE));
				mapForDs.put("returnDate", returnDate);
			}
			if (request.getParameter(RETURN_NO) != null
					&& !(request.getParameter(RETURN_NO).equals(""))) {
				returnNo = request.getParameter(RETURN_NO);
				mapForDs.put("returnNo", returnNo);
			}
			if (request.getParameter("bookReturnHdId") != null
					&& !(request.getParameter("bookReturnHdId").equals("0"))) {
				bookReturnHdId = Integer.parseInt(request
						.getParameter("bookReturnHdId"));
				mapForDs.put("bookReturnHdId", bookReturnHdId);
			}
			patientMap = libraryHandlerService.searchUpdateBookReturnJsp(mapForDs);
			map.put("patientMap", patientMap);
			map.put("detailsMap", detailsMap);
			map.put("contentJsp", jsp);

			return new ModelAndView("indexB", "map", map);
		}

		public ModelAndView showUpdateBookReturn(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();

			Map<String, Object> mapForDS = new HashMap<String, Object>();
			int bookReturnHdId = 0;
			if (request.getParameter("bookReturnHdId") != null
					&& !(request.getParameter("bookReturnHdId").equals("0"))) {
				bookReturnHdId = Integer.parseInt(request
						.getParameter("bookReturnHdId"));
				mapForDS.put("bookReturnHdId", bookReturnHdId);
			}
			if (bookReturnHdId != 0) {
				map = libraryHandlerService.showUpdateBookReturn(bookReturnHdId);
			}
			jsp = LIB_UPDATE_BOOK_RETURN_JSP + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("indexB", "map", map);
		}

		public ModelAndView updateBookReturn(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			Map<String, Object> map = new HashMap<String, Object>();
			session = request.getSession();
			Box box = HMSUtil.getBox(request);

			boolean bool = libraryHandlerService.updateBookReturn(box);
			if (bool) {
				message = "Data  updated Successfully!!";
			} else {
				message = "Eror Occurred !! Try Again !!";
			}
			jsp = LIB_SEARCH_BOOK_RETURN_JSP;
			jsp += ".jsp";
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("indexB", "map", map);

		}
		public void fillIssueDetail(HttpServletRequest request,	HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();

			Map<String, Object> dataMap = new HashMap<String, Object>();
			List<LibBookIssueHeader> issueHdList = new ArrayList<LibBookIssueHeader>();
			String issueNo = "";

			try {
				if (request.getParameter("issueNo") != null) {
					issueNo = request.getParameter("issueNo");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			dataMap.put("issueNo", issueNo);
			map = libraryHandlerService.fillIssueDetail(dataMap);
			if (map.get("issueHdList") != null) {
				issueHdList = (List) map.get("issueHdList");
			}
			StringBuffer sb = new StringBuffer();
			try {
				sb.append("<items>");
				for (LibBookIssueHeader bookIssueHeader : issueHdList) {
					sb.append("<item>");
					sb.append("<issueId>" + bookIssueHeader.getId() + "</issueId>");
					sb.append("<issueDate>"	+ HMSUtil.convertDateToStringWithoutTime(bookIssueHeader.getIssueDate()) + "</issueDate>");
					sb.append("<name>"+ bookIssueHeader.getEmployee().getFirstName()+" "+ bookIssueHeader.getEmployee().getMiddleName()+" "+bookIssueHeader.getEmployee().getLastName()+ "</name>");
					sb.append("<serviceNo>"	+ bookIssueHeader.getEmployee().getServiceNo() + "</serviceNo>");
					if (bookIssueHeader.getEmployee().getRank() != null) {
						sb.append("<rankId>" + bookIssueHeader.getEmployee().getRank().getId()+ "</rankId>");
						sb.append("<rankName>"+ bookIssueHeader.getEmployee().getRank().getRankName() + "</rankName>");
					}
					else {
						sb.append("<rankId>-</rankId>");
					}
					sb.append("</item>");
					break;
				}
				sb.append("</items>");
				response.setContentType("text/xml");
				response.setHeader("Cache-Control", "no-cache");
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			try {
				response.getWriter().write(
						"<?xml version='1.0' encoding='ISO-8859-1'?>");
				response.getWriter().write("<chargeCodes>");
				response.getWriter().write(sb.toString());
				response.getWriter().write("</chargeCodes>");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		//---------------------------- Book Stock Report by mansi

		@SuppressWarnings("unchecked")
		public ModelAndView showBookStockReport(HttpServletRequest request,	HttpServletResponse response) {


			Map<String, Object> map = new HashMap<String, Object>();
			map = libraryHandlerService.showBookMaster();
			jsp = RequestConstants.BOOK_STOCK_REPORT;
			jsp += ".jsp";
			title = "Book Master";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("indexB", "map", map);

		}
		public ModelAndView generateBookStockReport(HttpServletRequest request,HttpServletResponse response) {

			String bookType = "";
			String query = "";
			int bookCategoryId=0;
			int bookClassId=0;
			int bookSubClassId=0;
			int bookForDepId=0;
			int publisherId=0;


			try {
				query = " where mas_book.status = 'y' ";

				if (request.getParameter(TYPE) != null && !(request.getParameter(TYPE).equals("0")))
				{
					if (!request.getParameter(TYPE).equalsIgnoreCase(""))
					{
						bookType = request.getParameter(TYPE);
						query = " and mas_book.types  = '" + bookType + "'";
					}
					else
					{
						bookType = "All";
					}
				}
				if (request.getParameter(RequestConstants.PUBLISHER_ID) != null	&& !request.getParameter(RequestConstants.PUBLISHER_ID).equals("0"))
				{
					publisherId = Integer.parseInt(request.getParameter(RequestConstants.PUBLISHER_ID));
					query = query + " and mas_book.publisher_id= '"+ publisherId + "'";
				}
				if (request.getParameter(RequestConstants.BOOK_CATEGORY_ID) != null	&& !request.getParameter(RequestConstants.BOOK_CATEGORY_ID).equals("0"))
				{
					bookCategoryId = Integer.parseInt(request.getParameter(RequestConstants.BOOK_CATEGORY_ID));
					query = query + " and mas_book.book_category_id= '"+ bookCategoryId + "'";
				}

				if (request.getParameter(RequestConstants.BOOK_CLASS_ID) != null	&& !request.getParameter(RequestConstants.BOOK_CLASS_ID).equals("0"))
				{
					bookClassId = Integer.parseInt(request.getParameter(RequestConstants.BOOK_CLASS_ID));
					query = query + " and mas_book.book_class_id= '"+ bookClassId + "'";
				}

				if (request.getParameter(RequestConstants.BOOK_SUB_CLASS_ID) != null	&& !request.getParameter(RequestConstants.BOOK_SUB_CLASS_ID).equals("0"))
				{
					bookSubClassId = Integer.parseInt(request.getParameter(RequestConstants.BOOK_SUB_CLASS_ID));
					query = query + " and mas_book.book_sub_class_id= '"+ bookSubClassId + "'";
				}

				if (request.getParameter(RequestConstants.DEPARTMENT_ID) != null	&& !request.getParameter(RequestConstants.DEPARTMENT_ID).equals("0"))
				{
					bookForDepId = Integer.parseInt(request.getParameter(RequestConstants.DEPARTMENT_ID));
					query = query + " and mas_book.department_id= '"+ bookForDepId + "'";
				}


				System.out.println("query  in cotroller  :" + query);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			detailsMap = libraryHandlerService.getConnectionForReport();
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("QUERY", query);
			parameters.put("type", bookType);
	/*		parameters.put("bookCategoryId", bookCategoryId);
			parameters.put("bookClassId", bookClassId);
			parameters.put("bookSubClassId", bookSubClassId);
			parameters.put("bookForDepId", bookForDepId);
			parameters.put("publisherId", publisherId);*/


			try {
				HMSUtil.generateReport("lib_BookStockReport2", parameters,(Connection) detailsMap.get("con"), response,getServletContext());
			} catch (Exception e) {

				e.printStackTrace();
			}

			return null;
		}
}
