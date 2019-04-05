package jkt.hms.workservices.controller;

import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.DEPARTMENT_TYPE_ID;
import static jkt.hms.util.RequestConstants.LAST_CHANGED_BY;
import static jkt.hms.util.RequestConstants.LAST_CHANGED_DATE;
import static jkt.hms.util.RequestConstants.LAST_CHANGED_TIME;
import static jkt.hms.util.RequestConstants.MINOR_WORK_AUTHORITY;
import static jkt.hms.util.RequestConstants.MINOR_WORK_CATEGORY_ID;
import static jkt.hms.util.RequestConstants.MINOR_WORK_DETAIL;
import static jkt.hms.util.RequestConstants.MINOR_WORK_DETAIL_JSP;
import static jkt.hms.util.RequestConstants.MINOR_WORK_ESTIMATED_COST;
import static jkt.hms.util.RequestConstants.MINOR_WORK_PROPOSAL_CANCELLATION_JSP;
import static jkt.hms.util.RequestConstants.MINOR_WORK_PROPOSAL_CANCELLATION_REASON;
import static jkt.hms.util.RequestConstants.MINOR_WORK_PROPOSAL_CANCELLATION_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.MINOR_WORK_PROPOSAL_DATE;
import static jkt.hms.util.RequestConstants.MINOR_WORK_PROPOSAL_JSP;
import static jkt.hms.util.RequestConstants.MINOR_WORK_PROPOSAL_JUSTIFICATION;
import static jkt.hms.util.RequestConstants.MINOR_WORK_PROPOSAL_NO;
import static jkt.hms.util.RequestConstants.MINOR_WORK_PROPOSAL_NO_SEARCH;
import static jkt.hms.util.RequestConstants.MINOR_WORK_TYPE_ID;
import static jkt.hms.util.RequestConstants.USER_COMMENTS_JSP;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasMinorWorkProposal;
import jkt.hms.masters.business.MasWorkType;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.workservices.handler.MinorWorkDetailHandlerService;
import jkt.hms.workservices.handler.MinorWorkProposalHandlerService;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MinorWorkProposalController extends MultiActionController {
	private MinorWorkProposalHandlerService minorWorkProposalHandlerService = null;
	private MinorWorkDetailHandlerService minorWorkDetailHandlerService = null;
	private CommonMasterHandlerService commonMasterHandlerService = null;

	public ModelAndView showMinorWorkProposalJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";

		String minorlastChangedBy = "";

		String minorWorkNo = "";
		if (request.getParameter(LAST_CHANGED_BY) != null) {
			minorlastChangedBy = request.getParameter(LAST_CHANGED_BY);
		}
		map = minorWorkProposalHandlerService.showMinorWorkProposalJsp();
		minorWorkNo = minorWorkProposalHandlerService
				.generateMinorWorkNumber(minorlastChangedBy);
		map.put("minorWorkProposalNo", minorWorkNo);
		jsp = MINOR_WORK_PROPOSAL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		// map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addMinorWorkProposal(HttpServletRequest req,
			HttpServletResponse res) {
		Map<String, Object> map = new HashMap<String, Object>();
		String minorworkNo = "";
		Date minorworkDate = null;
		String minorworkTime = "";
		String workCategory = "";
		Integer workType = 0;
		String minorworkDetail = "";
		String justification = "";
		String jsp = "";
		String title = "";
		int departmentName = 0;
		String authority = "";
		String message = "";
		String minorlastChangedBy = "";
		String minorlastChangedTime = "";
		Date minorlastChangedDate = null;
		String minorestimatedCost = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String printFlag = "";
		MasMinorWorkProposal masMinorWorkProposal = new MasMinorWorkProposal();
		List masMinorWorkProposalList = new ArrayList();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		if (req.getParameter("proposalNo") != null) {
			minorworkNo = req.getParameter("proposalNo");
		}
		System.out.println("minorworkNo::"+minorworkNo);

		if (req.getParameter(MINOR_WORK_PROPOSAL_DATE) != null) {
			minorworkDate = HMSUtil.dateFormatterDDMMYYYY(req.getParameter(MINOR_WORK_PROPOSAL_DATE));
		}
		if (req.getParameter(DEPARTMENT_TYPE_ID) != null) {
			departmentName = Integer.parseInt(req.getParameter(DEPARTMENT_TYPE_ID));
		}
		if (req.getParameter(MINOR_WORK_AUTHORITY) != null) {
			authority = req.getParameter(MINOR_WORK_AUTHORITY);

		}
		if (req.getParameter(LAST_CHANGED_BY) != null) {
			minorlastChangedBy = req.getParameter(LAST_CHANGED_BY);
		}
		if (req.getParameter(LAST_CHANGED_DATE) != null) {
			minorlastChangedDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(LAST_CHANGED_DATE));
		}
		if (req.getParameter(LAST_CHANGED_TIME) != null) {
			minorlastChangedTime = req.getParameter(LAST_CHANGED_TIME);
		}
		if (req.getParameter(MINOR_WORK_CATEGORY_ID) != null) {
			workCategory = req.getParameter(MINOR_WORK_CATEGORY_ID);

		}
		if (req.getParameter(MINOR_WORK_ESTIMATED_COST) != null) {
			minorestimatedCost = req.getParameter(MINOR_WORK_ESTIMATED_COST);
		}
		if (req.getParameter(MINOR_WORK_TYPE_ID) != null) {
			workType = Integer.parseInt(req.getParameter(MINOR_WORK_TYPE_ID));

		}
		if (req.getParameter(MINOR_WORK_DETAIL) != null) {
			minorworkDetail = req.getParameter(MINOR_WORK_DETAIL);

		}

		if (req.getParameter(MINOR_WORK_PROPOSAL_JUSTIFICATION) != null) {
			justification = req.getParameter(MINOR_WORK_PROPOSAL_JUSTIFICATION);
		}
		if (req.getParameter("title") != null) {
			title = req.getParameter("title");
		}
		Box box = HMSUtil.getBox(req);
		dataMap.put("box", box);
		boolean successfullyAdded = false;
		masMinorWorkProposal.setMinorWorkProposalNo(minorworkNo);
		masMinorWorkProposal.setMinorWorkProposalDate(minorworkDate);
		masMinorWorkProposal.setStatus("y");
		masMinorWorkProposal.setLastChgBy(minorlastChangedBy);
		masMinorWorkProposal.setLastChgDate(minorlastChangedDate);
		masMinorWorkProposal.setLastChgTime(minorworkTime);
		masMinorWorkProposal.setEstimatedCost(minorestimatedCost);
		masMinorWorkProposal.setAuthority(authority);
		masMinorWorkProposal.setMinorWorkDetail(minorworkDetail);
		MasWorkType masworktype = new MasWorkType();
		MasDepartment masDept = new MasDepartment();

		masMinorWorkProposal.setWorkCategoryId(workCategory);
		masworktype.setId(workType);
		masMinorWorkProposal.setWorkType(masworktype);
		masDept.setId(departmentName);
		masMinorWorkProposal.setDepartment(masDept);
		masMinorWorkProposal.setJustification(justification);
		generalMap.put("code", minorworkNo);
		generalMap.put("pojoPropertyCode", "MinorWorkProposalNo");
		generalMap.put("pojoName", "MasMinorWorkProposal");
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		masMinorWorkProposalList = (List) listMap.get("duplicateGeneralCodeList");
		if (masMinorWorkProposalList == null || masMinorWorkProposalList.size() == 0) {
			successfullyAdded = minorWorkProposalHandlerService	.addMinorWorkProposal(masMinorWorkProposal, dataMap);
			generalMap.clear();
			if (req.getParameter("printFlag") != null) {
				printFlag = req.getParameter("printFlag");
			}

		} else {
			message = "Proposal No already exist !! ";
		}
		if (successfullyAdded) {
			message = "Record Added Successfully for Proposal No - "
					+ minorworkNo;

		} else {
			message += "Please Try Again !!";
		}

		if (req.getParameter(LAST_CHANGED_BY) != null) {
			minorlastChangedBy = req.getParameter(LAST_CHANGED_BY);
		}

		map = minorWorkProposalHandlerService.showMinorWorkProposalJsp();
		if (printFlag.equalsIgnoreCase("y")) {
			map.put("printFlag", printFlag);
			map.put("displayMessage", "y");
		}
		minorworkNo = minorWorkProposalHandlerService.generateMinorWorkNumber(minorlastChangedBy);
		map.put("minorWorkProposalNo", minorworkNo);
		jsp = MINOR_WORK_PROPOSAL_JSP;
		title = "Add minor Work Detail";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showMinorWorkProposalCancellation(
			HttpServletRequest req, HttpServletResponse res) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		map = minorWorkProposalHandlerService
				.showMinorWorkProposalCancellationJsp();
		jsp = MINOR_WORK_PROPOSAL_CANCELLATION_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		// map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}
    public ModelAndView popUpForProposalJsp(HttpServletRequest request,HttpServletResponse response){
    	Map<String, Object> map = new HashMap<String, Object>();
    	String jsp = "";
		map = minorWorkProposalHandlerService.popUpForProposalJsp();
        jsp = MINOR_WORK_PROPOSAL_CANCELLATION_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView(MINOR_WORK_PROPOSAL_CANCELLATION_SEARCH_JSP,
				"map", map);
    	
    }
	@SuppressWarnings("unchecked")
	public ModelAndView showPopUpProposalJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Box box = (Box)HMSUtil.getBox(request);
		map.put("box", box);
		String jsp = "";
		dataMap = minorWorkProposalHandlerService.showPopUpProposalJsp(map);
        jsp = MINOR_WORK_PROPOSAL_CANCELLATION_SEARCH_JSP;
		jsp += ".jsp";
		dataMap.put("contentJsp", jsp);
		return new ModelAndView(MINOR_WORK_PROPOSAL_CANCELLATION_SEARCH_JSP,
				"map", dataMap);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchMinorWorkDetailSearch(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		AgendaDTO minorWorkDetailSearchDTO = new AgendaDTO();
		if (!request.getParameter(MINOR_WORK_PROPOSAL_NO_SEARCH)
				.equalsIgnoreCase("")
				&& request.getParameter(MINOR_WORK_PROPOSAL_NO_SEARCH) != null) {
			minorWorkDetailSearchDTO.setMinorWorkNo(request
					.getParameter(MINOR_WORK_PROPOSAL_NO_SEARCH));
		}

		map = minorWorkProposalHandlerService
				.searchMinorWorkProposalCancellationSearch(minorWorkDetailSearchDTO);
		jsp = MINOR_WORK_PROPOSAL_CANCELLATION_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchMinorWorkDetailNew(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();
		List<MasWorkType> detailList = new ArrayList<MasWorkType>();

		String jsp = "";
		String finencialYear = "";

		String minorlastChangedBy = "";

		String minorWorkNo = "";
		if (request.getParameter(LAST_CHANGED_BY) != null) {
			minorlastChangedBy = request.getParameter(LAST_CHANGED_BY);
		}
		String title = "";
		AgendaDTO minorWorkDetailSearchDTO = new AgendaDTO();
		if (request.getParameter(MINOR_WORK_PROPOSAL_NO) != null
				&& !request.getParameter(MINOR_WORK_PROPOSAL_NO)
						.equalsIgnoreCase("")) {
			minorWorkDetailSearchDTO.setMinorWorkNo(request
					.getParameter(MINOR_WORK_PROPOSAL_NO));
		}
		detailMap = minorWorkDetailHandlerService.showMinorWorkDetailJsp();
		detailList = (List<MasWorkType>) detailMap.get("workTypeList");
		finencialYear = (String) detailMap.get("session");
		minorWorkNo = minorWorkDetailHandlerService
				.generateMinorWorkNumber(minorlastChangedBy);

		map = minorWorkProposalHandlerService
				.searchMinorWorkProposalCancellationSearch(minorWorkDetailSearchDTO);
		jsp = MINOR_WORK_DETAIL_JSP;
		jsp += ".jsp";
		map.put("workTypeList", detailList);
		map.put("minorWorkNo", minorWorkNo);
		map.put("search", "search");
		map.put("session", finencialYear);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchMinorWorkDetailNewForCompletion(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();
		List<MasWorkType> detailList = new ArrayList<MasWorkType>();

		String jsp = "";
		String finencialYear = "";

		String minorlastChangedBy = "";

		String minorWorkNo = "";
		if (request.getParameter(LAST_CHANGED_BY) != null) {
			minorlastChangedBy = request.getParameter(LAST_CHANGED_BY);
		}
		String title = "";
		AgendaDTO minorWorkDetailSearchDTO = new AgendaDTO();
		if (!request.getParameter(MINOR_WORK_PROPOSAL_NO_SEARCH)
				.equalsIgnoreCase("")
				&& request.getParameter(MINOR_WORK_PROPOSAL_NO_SEARCH) != null) {
			minorWorkDetailSearchDTO.setMinorWorkNo(request
					.getParameter(MINOR_WORK_PROPOSAL_NO_SEARCH));
		}
		detailMap = minorWorkDetailHandlerService.showMinorWorkDetailJsp();
		detailList = (List<MasWorkType>) detailMap.get("workTypeList");
		finencialYear = (String) detailMap.get("session");
		// This method is used in user comments screen thats why below is
		// commented
		// minorWorkNo =
		// minorWorkDetailHandlerService.generateMinorWorkNumber(minorlastChangedBy);

		map = minorWorkProposalHandlerService
				.searchMinorWorkDetail(minorWorkDetailSearchDTO);
		jsp = USER_COMMENTS_JSP;
		jsp += ".jsp";
		map.put("workTypeList", detailList);
		map.put("minorWorkNo", minorWorkNo);
		map.put("search", "search");
		map.put("session", finencialYear);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView cancleMinorWorkProposal(HttpServletRequest req,
			HttpServletResponse res) {
		Map<String, Object> map = new HashMap<String, Object>();
		String cancellationReason = "";
		String jsp = "";
		String title = "";
		String message = "";
		String minorlastChangedBy = "";
		String minorWorkNo = "";
		int id = 0;
		Date minorlastChangedDate = null;

		MasMinorWorkProposal masMinorWorkdetail = new MasMinorWorkProposal();

		if (req.getParameter(MINOR_WORK_PROPOSAL_CANCELLATION_REASON) != null) {
			cancellationReason = req
					.getParameter(MINOR_WORK_PROPOSAL_CANCELLATION_REASON);
		}
		if (req.getParameter(MINOR_WORK_PROPOSAL_CANCELLATION_REASON) != null) {
			cancellationReason = req
					.getParameter(MINOR_WORK_PROPOSAL_CANCELLATION_REASON);
		}
		if (req.getParameter(LAST_CHANGED_BY) != null) {
			minorlastChangedBy = req.getParameter(LAST_CHANGED_BY);
		}
		if (req.getParameter(LAST_CHANGED_DATE) != null) {
			minorlastChangedDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(LAST_CHANGED_DATE));
		}
		if (req.getParameter("title") != null) {
			title = req.getParameter("title");
		}

		if (req.getParameter(COMMON_ID) != null) {
			id = Integer.parseInt(req.getParameter(COMMON_ID));
		}
		boolean successfullyAdded = false;
		masMinorWorkdetail.setStatus("c");
		masMinorWorkdetail.setId(id);
		masMinorWorkdetail.setLastChgBy(minorlastChangedBy);
		masMinorWorkdetail.setLastChgDate(minorlastChangedDate);
		masMinorWorkdetail.setCancellationReason(cancellationReason);
		if (id != 0) {
			successfullyAdded = minorWorkProposalHandlerService
					.cancleMinorWorkProposal(masMinorWorkdetail);

			if (successfullyAdded) {
				message = "Record Updated Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else {
			message = "Please Try again";
		}
		if (req.getParameter(LAST_CHANGED_BY) != null) {
			minorlastChangedBy = req.getParameter(LAST_CHANGED_BY);
		}
		minorWorkNo = minorWorkProposalHandlerService
				.generateMinorWorkNumber(minorlastChangedBy);
		map.put("minorWorkProposalNo", minorWorkNo);
		jsp = MINOR_WORK_PROPOSAL_CANCELLATION_JSP;
		title = "Cancle Minor Work Proposal";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generatePerforma(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();

		int id = 0;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = minorWorkProposalHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		if (request.getParameter("id") != null
				&& !request.getParameter("id").equalsIgnoreCase("")) {
			id = Integer.parseInt(request.getParameter("id"));
		}
		//System.out.println("id" + id);
		parameters.put("id", id);

		try {
			HMSUtil.generateReport("MinorWorksProforma", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	/**
	 * @return the minorWorkProposalHandlerService
	 */
	public MinorWorkProposalHandlerService getMinorWorkProposalHandlerService() {
		return minorWorkProposalHandlerService;
	}

	/**
	 * @param minorWorkProposalHandlerService
	 *            the minorWorkProposalHandlerService to set
	 */
	public void setMinorWorkProposalHandlerService(
			MinorWorkProposalHandlerService minorWorkProposalHandlerService) {
		this.minorWorkProposalHandlerService = minorWorkProposalHandlerService;
	}

	/**
	 * @return the minorWorkDetailHandlerService
	 */
	public MinorWorkDetailHandlerService getMinorWorkDetailHandlerService() {
		return minorWorkDetailHandlerService;
	}

	/**
	 * @param minorWorkDetailHandlerService
	 *            the minorWorkDetailHandlerService to set
	 */
	public void setMinorWorkDetailHandlerService(
			MinorWorkDetailHandlerService minorWorkDetailHandlerService) {
		this.minorWorkDetailHandlerService = minorWorkDetailHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}
