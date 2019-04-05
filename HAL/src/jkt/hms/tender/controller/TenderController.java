/**  
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Class TenderController.java 
 * Tendering Process 
 * Tables Used: store_tender_proposal, store_tender_m, store_tender_t, etc..
 * @author  Create Date: 20.03.2008  Name: Othivadivel K R 
 * Revision Date:      		Revision By: 
 * @version 1.0  
 * @see 
 **/

package jkt.hms.tender.controller;

import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.PO_NO;
import static jkt.hms.util.RequestConstants.PROPOSAL_ID;
import static jkt.hms.util.RequestConstants.SUPPLYNOFROM;
import static jkt.hms.util.RequestConstants.SUPPLYNOTO;
import static jkt.hms.util.RequestConstants.TENDER_ITEM_ID;
import static jkt.hms.util.RequestConstants.TENDER_LPO_NOTE_DATE;
import static jkt.hms.util.RequestConstants.TENDER_LPO_NOTE_PERIOD;
import static jkt.hms.util.RequestConstants.TENDER_LPO_OIC;
import static jkt.hms.util.RequestConstants.TENDER_NO;
import static jkt.hms.util.RequestConstants.TENDER_SUPPLIER_GROUP_ID;
import static jkt.hms.util.RequestConstants.TENDER_VENDOR_SUPPLIER_ID;
import static jkt.hms.util.RequestConstants.TO_DATE;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import jkt.hms.masters.business.StorePoHeader;
import jkt.hms.masters.business.StoreSetup;
import jkt.hms.masters.business.StoreTenderCommBidT;
import jkt.hms.masters.business.StoreTenderLocalPurchaseT;
import jkt.hms.masters.business.StoreTenderProposal;
import jkt.hms.masters.business.StoreTenderT;
import jkt.hms.masters.business.UserButtonRights;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.tender.handler.TenderHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class TenderController extends MultiActionController {

	TenderHandlerService tenderHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	String jsp = "";
	String title = "";
	String userName = null;
	String message = null;
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = null;

	public void setTenderHandlerService(
			TenderHandlerService tenderHandlerService) {
		this.tenderHandlerService = tenderHandlerService;
	}

	public ModelAndView showTenderCreationJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int deptId = Integer
				.parseInt(session.getAttribute("deptId").toString());
		box.put("deptId", deptId);
		map = tenderHandlerService.showTenderCreationJsp(box);
		jsp = "tenderCreation";
		jsp += ".jsp";
		title = "Tender Creation";
		map.put("contentJsp", jsp);
		map.put("pagedArray", null);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView createTenderMasterAndTransaction(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int deptId = Integer
				.parseInt(session.getAttribute("deptId").toString());
		box.put("deptId", deptId);
		if (!box.getString("flag").equalsIgnoreCase("proposals")) {
			map = tenderHandlerService.createTenderMasterAndTransaction(box);
		} else {
			map = tenderHandlerService
					.createTenderMasterAndTransactionForProposals(box);
		}
		jsp = "tenderCreation";
		jsp += ".jsp";
		title = "Tender Creation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showTenderCreationJspWithGridData(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		String pvmsNo = null;
		if (box.getString("flag").equals("fresh"))
			box.put("currPage", 1);
		int deptId = Integer
				.parseInt(session.getAttribute("deptId").toString());
		if (request.getParameter("pvmsNo") != null
				&& request.getParameter("pvmsNo").length() > 0) {
			pvmsNo = request.getParameter("pvmsNo");
			//System.out.println("value of pvms in controller---" + pvmsNo);
			box.put("pvmsNo", pvmsNo);
		}
		box.put("deptId", deptId);
		map = tenderHandlerService.getMMFGridData(box);
		jsp = "tenderCreation";
		jsp += ".jsp";
		title = "Tender Creation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("mmfyear", "created");
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView updateGridItems(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int deptId = Integer
				.parseInt(session.getAttribute("deptId").toString());
		box.put("deptId", deptId);
		map = tenderHandlerService.updateGridItems(box);
		jsp = "tenderCreation";
		jsp += ".jsp";
		title = "Tender Creation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteGridItems(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int deptId = Integer
				.parseInt(session.getAttribute("deptId").toString());
		box.put("deptId", deptId);
		map = tenderHandlerService.deleteGridItems(box);
		jsp = "tenderCreation";
		jsp += ".jsp";
		title = "Tender Creation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showAddTenderItemsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int deptId = Integer
				.parseInt(session.getAttribute("deptId").toString());
		boolean show = false;
		if (request.getParameter("showAll") != null) {
			if (request.getParameter("showAll").equals("true")) {
				show = true;
			}
		}

		box.put("show", show);
		box.put("deptId", deptId);
		map = tenderHandlerService.getItemDetails(box);
		jsp = "Tender_Items_Addition";
		title = "Add Tender Items";
		map.put("contentJsp", jsp);
		map.put("show", show);
		map.put("title", title);
		map.put("tender_no", box.get(TENDER_NO));
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showAddTenderItemsJspForNextRecords(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int deptId = Integer.parseInt(session.getAttribute("deptId").toString());
		box.put("deptId", deptId);
		int itemId = 0;
		if (request.getParameter("buttonName") != null) {
			Vector items = box.getVector(TENDER_ITEM_ID);
			int max = items.size() - 1;
			itemId = Integer.valueOf(items.get(max).toString());
			box.put("itemId", itemId);
		} else {

			itemId = Integer.parseInt(box.getString("itemIdForNextRecord"));
			box.put("itemId", itemId);
		}
		map = tenderHandlerService.getItemDetailsForNextRecord(box);
		jsp = "Tender_Items_Addition";
		title = "Add Tender Items";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("tender_no", box.get(TENDER_NO));
		map.put("internalIndentId", box.get("internalIndentId"));
		map.put("hiddenFieldForRecords", "true");
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView doAddTenderItems(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		boolean show = false;
		if (request.getParameter("showAll") != null) {
			if (request.getParameter("showAll").equals("true")) {
				show = true;
			}
		}
		box.put("show", show);
		if (!box.getString(TENDER_NO).equals(""))
			map = tenderHandlerService.doAddTenderItems(box);
		else
			map = tenderHandlerService.doAddTenderProposalItems(box);
		jsp = "Tender_Items_Addition";
		title = "Add Tender Items";
		map.put("hiddenFieldForRecords", box.get("hiddenFieldForRecords"));
		map.put("contentJsp", jsp);
		map.put("show", show);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showInvitationForTenderJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getInvitationForTenderDetails(box);
		jsp = "Tender_Invitation";
		jsp = jsp + ".jsp";
		title = "Invitation for Tender";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showInvitationForTenderJspWithGridData(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getInvitationTenderGridData(box);
		jsp = "Tender_Invitation";
		jsp = jsp + ".jsp";
		title = "Invitation for Tender";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printInvitationLetter(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.printInvitationLetter(box);
		jsp = "Tender_Invitation";
		jsp = jsp + ".jsp";
		title = "Invitation for Tender";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("Print_Report", "yes");
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showInvitationLetterReport(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.showInvitationLetterReport(box);
		HMSUtil.generateReport("Tender_Invitation_Letter", map,
				(Connection) map.get("conn"), response, getServletContext());
		jsp = "Tender_Invitation";
		jsp = jsp + ".jsp";
		title = "Invitation for Tender";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showDraftLetterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		if (box.getString("flag").equals("Update"))
			map = tenderHandlerService.getLetterContents(box);
		jsp = "Tender_Draft_Letter";
		title = "Tender Invitation Letter Drafting";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView addInvitationLetterDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.addInvitationLetterDetails(box);
		jsp = "Tender_Draft_Letter";
		title = "Tender Invitation Letter Drafting";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showTenderDocumentJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		String jspName = "";
		if (request.getParameter("jspName") != null) {
			jspName = (request.getParameter("jspName"));
		}
		map = tenderHandlerService.getDocumentForTenderDetails(box);

		if (!jspName.equals("PTI")) {
			jsp = "Tender_Document";
		} else {
			jsp = "previousTenderItems";
		}
		jsp += ".jsp";
		title = "Tender Document";
		map.put("contentJsp", jsp);
		map.put("pagedArray", null);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	//Tender Costing Report Print --Vishal
	public ModelAndView showTenderCostingReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		String jspName = "";
		if (request.getParameter("jspName") != null) {
			jspName = (request.getParameter("jspName"));
		}
		map = tenderHandlerService.getTenderDetailsForCosting(box);
		jsp = "tenderCostingReport";
		jsp += ".jsp";
		title = "Tender Costing";
		map.put("contentJsp", jsp);
		map.put("pagedArray", null);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView printTenderCostingReport(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		//Map<String, Object> parameters = new HashMap<String, Object>();
		
		int deptId = 0;
		String deptName = "";
		int tenderId =0;
		String tenderNo ="";
		try {
			  /*deptId = Integer.parseInt(session.getAttribute("deptId").toString());
					//System.out.println("deptId--"+deptId);*/
				
				map = tenderHandlerService.getConnectionForReport();
				if (request.getParameter(RequestConstants.TENDER_NO) != null) {
					tenderId = Integer.parseInt((request.getParameter(RequestConstants.TENDER_NO)));
					map.put("tender_id", tenderId);
				}
				if (request.getParameter("tenderStr") != null) {
					tenderNo = (request.getParameter("tenderStr"));
					map.put("tender_no", tenderNo);
					
				}
				if (request.getParameter("deptId") != null) {
					deptId = Integer.parseInt((request.getParameter("deptId")));
					map.put("department_id", deptId);
				}
				if (request.getParameter("deptName") != null) {
					deptName = (request.getParameter("deptName"));
					map.put("department_name", deptName);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			HMSUtil.generateReport("costingReport", map,
					(Connection) map.get("con"), response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		/*HMSUtil.generateReport("costingReport", map,
				(Connection) map.get("conn"), response, getServletContext());*/
		jsp = "tenderCostingReport";
		jsp = jsp + ".jsp";
		title = "Tender Costing";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	//Tender Costing Report Print --Vishal
	public ModelAndView showDocumentForTenderJspWithGridData(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		String jspName = "";
		map = tenderHandlerService.showDocumentForTenderJspWithGridData(box);
		if (request.getParameter("jspName") != null) {
			jspName = (request.getParameter("jspName"));
		}

		if (!jspName.equals("PTI")) {
			jsp = "Tender_Document";
		} else {
			jsp = "previousTenderItems";
		}
		jsp = jsp + ".jsp";
		title = "Tender Document";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printTenderDocument(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.printTenderDocument(box);
		jsp = "Tender_Document";
		jsp = jsp + ".jsp";
		title = "Tender Document";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printTenderDocumentReport(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.printTenderDocumentReport(box);
		map.put("PATH_TO_SUBREPORTS", getServletContext().getRealPath(
				"/reports/"));
		map.put("PATH_TO_IMAGES", getServletContext().getRealPath("/reports/"));
		map.put("group_name", box.getString("group") + ", Tender No: CHAFB/"
				+ map.get("tender_no").toString());
		map.put("tender_id", new Integer(box.getInt(TENDER_NO)));
		map.put("group_id", new Integer(box.getInt(TENDER_SUPPLIER_GROUP_ID)));
		if (!box.getString("document").equalsIgnoreCase("yes"))
			HMSUtil
					.generateReport("Tender_Document_Report", map,
							(Connection) map.get("conn"), response,
							getServletContext());
		else
			HMSUtil
					.generateReport("Tender_Document_Report1", map,
							(Connection) map.get("conn"), response,
							getServletContext());
		jsp = "Tender_Document";
		jsp = jsp + ".jsp";
		title = "Tender Document";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printTenderDocumentReportDrugSchedule(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.printTenderDocumentReport(box);
		map.put("tender_id", new Integer(box.getInt(TENDER_NO)));
		map.put("group_id", new Integer(box.getInt(TENDER_SUPPLIER_GROUP_ID)));

		if (box.getString("ReportType").equals("PTI")) {
			HMSUtil
					.generateReport("Tender_Document_Drugs_ScheduleForPTI",
							map, (Connection) map.get("conn"), response,
							getServletContext());
		} else {
			HMSUtil
					.generateReport("Tender_Document_Drugs_Schedule", map,
							(Connection) map.get("conn"), response,
							getServletContext());
		}
		jsp = "Tender_Document";
		jsp = jsp + ".jsp";
		title = "Tender Document";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showExportCDJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getGroupAndTenderComboDetails(box);
		jsp = "Tender_Export_CD";
		jsp += ".jsp";
		title = "Export CD";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView createScheduleSoftCopy(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		box.put("download_path", getServletContext().getRealPath("/download/"));
		map = tenderHandlerService.createScheduleSoftCopy(box);
		if (map.get("flag") != null
				&& map.get("flag").toString().equalsIgnoreCase("NoData")) {
			map.put("message", "No Data Found!....");
		} else {
			try {
				response.setContentType("application/zip");
				response.setHeader("Content-Disposition",
						"attachment; filename="
								+ map.get("download_path").toString());
				File f = new File(map.get("download_path").toString());
				InputStream in = new FileInputStream(f);
				ServletOutputStream outs = response.getOutputStream();
				int bit = 256;
				int i = 0;
				while ((bit) >= 0) {
					bit = in.read();
					outs.write(bit);
				}
				outs.flush();
				outs.close();
				in.close();
				if (f.exists())
					f.delete();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

		jsp = "Tender_Export_CD";
		jsp += ".jsp";
		title = "Export CD";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showTechnicalBidJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService
				.getGroupAndTenderAndSupplierComboDetails(box);
		jsp = "Tender_Technical_Bid";
		jsp += ".jsp";
		title = "Tender - Technical Bid";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getTenderGroupList(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService
				.getGroupAndTenderAndSupplierComboDetails(box);
		jsp = "Tender_Technical_Bid";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		title = "Tender - Technical Bid";
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getTenderSupplierList(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService
				.getGroupAndTenderAndSupplierComboDetails(box);
		jsp = "Tender_Technical_Bid";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		title = "Tender - Technical Bid";
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getTenderTechnicalBidGrid(HttpServletRequest request,
			HttpServletResponse response) {
		String pvmsNo = null;
		Box box = HMSUtil.getBox(request);
		if (box.getString("flag").equals("fresh"))
			box.put("currPage", 1);

		if (request.getParameter("pvmsNo") != null
				&& request.getParameter("pvmsNo").length() > 0) {
			pvmsNo = request.getParameter("pvmsNo");
			//System.out.println("value of pvms in controller---" + pvmsNo);
			box.put("pvmsNo", pvmsNo);
		}
		map = tenderHandlerService.getTenderTechnicalBidGrid(box);
		jsp = "Tender_Technical_Bid";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		title = "Tender - Technical Bid";
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView updateTechnicalBidGridItems(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.updateTechnicalBidGridItems(box);
		jsp = "Tender_Technical_Bid";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		title = "Tender - Technical Bid";
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showImportCDJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		jsp = "Tender_Import_CD";
		jsp += ".jsp";
		title = "Import CD";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", null);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView tenderImportCD(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		MultipartFormDataRequest mrequest = null;

		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Map<String, Object> uploadFileMap = new HashMap<String, Object>();

		String uploadURL = getServletContext().getRealPath("/upload/");

		String whiteList = "*.zip";

		// Long fileSizeLimit = 2097152l;

		List fileUploadedList = null;
		fileUploadedList = HMSUtil.uploadFile(mrequest, uploadURL, whiteList,
				box.getString("filename"));
		Boolean fileUploaded = false;
		if (fileUploadedList != null && fileUploadedList.size() != 0) {
			fileUploaded = (Boolean) fileUploadedList.get(0);
		}

		box.put("uploadURL", uploadURL);
		box.put("filename", box.getString("filename"));
		map = tenderHandlerService.tenderImportCD(box);
		if (map.get("flag") != null
				&& map.get("flag").toString().equalsIgnoreCase("Error")) {
			map
					.put(
							"message",
							"Errors Occured! Files are not Imported!.. Kindly Check the File Contents & Try Again!... (Refer User Manual)!...");
		} else if (map.get("flag") != null
				&& map.get("flag").toString().equalsIgnoreCase(
						"Already_Imported")) {
			map.put("message", "File(s) already Imported!...");
		} else if (map.get("flag") != null
				&& map.get("flag").toString().equalsIgnoreCase("Imported")) {
			map.put("message", "File(s) Successfully Imported!...");
		}

		jsp = "Tender_Import_CD";
		jsp += ".jsp";
		title = "Import CD";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showCommercialBidJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService
				.getGroupAndTenderAndSupplierComboDetailsForCommercialBid(box);
		jsp = "Tender_Commercial_Bid";
		jsp += ".jsp";
		title = "Tender - Commercial Bid";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getTenderGroupListForCommercial(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService
				.getGroupAndTenderAndSupplierComboDetailsForCommercialBid(box);
		jsp = "Tender_Commercial_Bid";
		jsp += ".jsp";
		title = "Tender - Commercial Bid";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showPvmsNomencaltureSearchJsp(
			HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("showUnitSearchJsp");
		Box box = HMSUtil.getBox(request);
		int tenderId = 0;
		int groupId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		if (request.getParameter("tenderId") != null) {
			tenderId = Integer.parseInt(request.getParameter("tenderId"));
			box.put("tenderId", tenderId);
		}
		if (request.getParameter("groupId") != null) {
			groupId = Integer.parseInt(request.getParameter("groupId"));
			box.put("groupId", groupId);
		}
		// //System.out.println("tender and group id in showPvmsNomencaltureSearchJsp----------"+tenderId+"---group id===="+groupId);

		map = tenderHandlerService.showPvmsNomencaltureSearchJsp(box);
		jsp = "pvmsNomenclatureSearch";
		map.put("tenderId", tenderId);
		map.put("groupId", groupId);
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
		// return null;
	}

	public ModelAndView getTenderItemListForCommercial(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService
				.getGroupAndTenderAndSupplierComboDetailsForCommercialBid(box);
		jsp = "Tender_Commercial_Bid";
		jsp += ".jsp";
		title = "Tender - Commercial Bid";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getTenderCommercialBidGrid(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (box.getString("flag").equals("fresh"))
			box.put("currPage", 1);
		map = tenderHandlerService.getTenderCommercialBidGrid(box);
		Users user = (Users) session.getAttribute("users");
		dataMap.put("users", user);
		Map<String, Object> newMap = commonMasterHandlerService
				.getUserButtonRights(dataMap);
		List<UserButtonRights> userRightsList = (List<UserButtonRights>) newMap
				.get("userRightsList");
		System.out
				.println("size of userRightsList in controller submit patient information====u====="
						+ userRightsList.size());
		map.put("userRightsList", userRightsList);
		jsp = "Tender_Commercial_Bid";
		jsp += ".jsp";
		title = "Tender - Commercial Bid";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView updateCommBidGridItems(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.updateCommBidGridItems(box);
		jsp = "Tender_Commercial_Bid";
		jsp += ".jsp";
		title = "Tender - Commercial Bid";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getTenderCommercialMarkingL1(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		//System.out.println(":box:" + box);
		map = tenderHandlerService.getTenderCommercialMarkingL1(box);
		jsp = "Tender_Commercial_Bid";
		jsp += ".jsp";
		title = "Tender - Commercial Bid";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView showHODRecommendationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getHODRecommendationDetails(box);
		jsp = "Tender_HOD_Recommendation";
		title = "HOD's Recommendation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView addHODRecommendation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.addHODRecommendation(box);
		jsp = "Tender_HOD_Recommendation";
		title = "HOD's Recommendation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showTenderLPO(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();

		Box box = HMSUtil.getBox(request);
		box.put("deptId", (Integer) session.getAttribute("deptId"));
		map = tenderHandlerService.showTenderLPO(box);
		jsp = "Tender_Local_Purchase_Order";
		jsp += ".jsp";
		title = "Tender - Local Purchase Order";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("flag", "new");
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getItemListForAutocomplete(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getItemListForAutocomplete(box);
		jsp = "result";
		return new ModelAndView(jsp, "map", map);
	}

	public void populateSupplierInTenderLPO(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		//System.out.println("box.getstring" + box);
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreTenderCommBidT> storeTenderCommBidTList = new ArrayList<StoreTenderCommBidT>();
		map = tenderHandlerService.populateSupplierInTenderLPO(box);

		if (map.get("storeTenderCommBidTList") != null) {
			storeTenderCommBidTList = (List) map.get("storeTenderCommBidTList");
		}

		StringBuffer sb = new StringBuffer();
		sb.append("<suppliers>");
		try {
			for (StoreTenderCommBidT storeTenderCommBidT : storeTenderCommBidTList) {
				sb.append("<supplier>");
				if (storeTenderCommBidT.getLcat().trim().equals("1")) {
					sb.append("<supplierId >"
							+ storeTenderCommBidT.getSupplier().getId()
							+ "</supplierId>");
					sb.append("<supplierName>"
							+ storeTenderCommBidT.getSupplier()
									.getSupplierName() + " [L"
							+ storeTenderCommBidT.getLcat().trim() + "] "
							+ "</supplierName>");
				} else {
					sb.append("<supplierId>"
							+ storeTenderCommBidT.getSupplier().getId()
							+ "</supplierId>");
					sb.append("<supplierName>"
							+ storeTenderCommBidT.getSupplier()
									.getSupplierName() + " [L"
							+ storeTenderCommBidT.getLcat().trim() + "] "
							+ "</supplierName>");
				}
				sb.append("</supplier>");
			}
			sb.append("</suppliers>");
			//System.out.println("sb" + sb);
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ModelAndView populateSupplierInTenderLPONote(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		//System.out.println("box.getstring" + box);
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreTenderCommBidT> storeTenderCommBidTList = new ArrayList<StoreTenderCommBidT>();
		map = tenderHandlerService.populateSupplierInTenderLPO(box);

		if (map.get("storeTenderCommBidTList") != null) {
			storeTenderCommBidTList = (List) map.get("storeTenderCommBidTList");
		}
		jsp = "Tender_local_purchase_order_responseList";
		jsp += ".jsp";

		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchForExistingNomenclature(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		if (!("").equals(request.getParameter(TENDER_LPO_NOTE_DATE))
				&& request.getParameter(TENDER_LPO_NOTE_DATE) != null)
			box.put(TENDER_LPO_NOTE_DATE, request
					.getParameter(TENDER_LPO_NOTE_DATE));
		if (!("").equals(request.getParameter(TENDER_LPO_NOTE_PERIOD))
				&& request.getParameter(TENDER_LPO_NOTE_PERIOD) != null)

			box.put(TENDER_LPO_NOTE_PERIOD, request
					.getParameter(TENDER_LPO_NOTE_PERIOD));
		if (!("").equals(request.getParameter(TENDER_LPO_OIC))
				&& request.getParameter(TENDER_LPO_OIC) != null)
			box.put(TENDER_LPO_OIC, request.getParameter(TENDER_LPO_OIC));
		if (!("").equals(request.getParameter(TENDER_NO))
				&& request.getParameter(TENDER_NO) != null)
			box.put(TENDER_NO, request.getParameter(TENDER_NO));

		map = tenderHandlerService.searchForExistingNomenclature(box);

		jsp = "searchWindowForPvms";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView createLPONoteMasterAndTransaction(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);

		session = request.getSession();
		int deptId = Integer
				.parseInt(session.getAttribute("deptId").toString());
		box.put("deptId", deptId);
		map = tenderHandlerService.createLPONoteMasterAndTransaction(box);
		jsp = "Tender_Local_Purchase_Order";
		jsp += ".jsp";
		title = "Tender LPO";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("flag", "existing");

		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getTenderSupplierListForLPNote(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getTenderSupplierListForLPNote(box);
		jsp = "showSuppliers";
		// jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		title = "Tender - Local Supply Order";
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showSupplyOrderSplitUpForLpoNote(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		//System.out.println("box " + box);

		session = request.getSession();
		map = tenderHandlerService.showSupplyOrderSplitUpForLpoNote(box);
		jsp = "Tender_LPO_Splitup_for_LPONote";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView generateLocalPurchaseOrderForLpoNote(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.generateLocalPurchaseOrderForLpoNote(box);
		//System.out.println("box values ingenerateLocalPurchaseOrderForLpoNote "+ box);
		map = tenderHandlerService.showSupplyOrderSplitUpForLpoNote(box);
		jsp = "Tender_LPO_Splitup_for_LPONote";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showLPONoteJspWithGridData(HttpServletRequest request,
			HttpServletResponse response) {
		int deptId = 24;
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer
					.parseInt(session.getAttribute("deptId").toString());
			box.put("deptId", deptId);
		}
		if (!("").equals(request.getParameter(TENDER_LPO_NOTE_DATE))
				&& request.getParameter(TENDER_LPO_NOTE_DATE) != null)
			box.put(TENDER_LPO_NOTE_DATE, request
					.getParameter(TENDER_LPO_NOTE_DATE));
		if (!("").equals(request.getParameter(TENDER_LPO_NOTE_PERIOD))
				&& request.getParameter(TENDER_LPO_NOTE_PERIOD) != null) {

			box.put(TENDER_LPO_NOTE_PERIOD, request
					.getParameter(TENDER_LPO_NOTE_PERIOD));

		}
		if (!("").equals(request.getParameter(TENDER_LPO_OIC))
				&& request.getParameter(TENDER_LPO_OIC) != null)
			box.put(TENDER_LPO_OIC, request.getParameter(TENDER_LPO_OIC));
		if (!("").equals(request.getParameter(TENDER_NO))
				&& request.getParameter(TENDER_NO) != null)
			box.put(TENDER_NO, request.getParameter(TENDER_NO));

		map = tenderHandlerService.getLPOGridData(box);
		jsp = "Tender_Local_Purchase_Order";
		jsp += ".jsp";
		title = "Tender LPO";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("flag", "existing");
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteLPOGridItems(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int deptId = Integer
				.parseInt(session.getAttribute("deptId").toString());
		box.put("deptId", deptId);
		map = tenderHandlerService.deleteLPOGridItems(box);
		jsp = "Tender_Local_Purchase_Order";
		jsp += ".jsp";
		title = "Tender LPO";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("flag", "existing");
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView updateLPOGridItems(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int deptId = Integer
				.parseInt(session.getAttribute("deptId").toString());
		box.put("deptId", deptId);
		map = tenderHandlerService.updateLPOGridItems(box);
		jsp = "Tender_Local_Purchase_Order";
		jsp += ".jsp";
		title = "Tender LPO";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("flag", "existing");
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printLPONote(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getConnection(box);
		map.put("noteNo", box.getString("noteNo"));
		HMSUtil.generateReport("Local_Purchase_Order_Note", map,
				(Connection) map.get("conn"), response, getServletContext());
		jsp = "Tender_Local_Purchase_Order";
		jsp = jsp + ".jsp";
		title = "Tender LPO";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printLocalSupplyOrderForLpoNote(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getStoreSetUpData(box);
		List<StoreSetup> list = (List) map.get("storeSetupList");
		map.put("DEPT", box.getInt("deptId"));
		map.put("po_number", box.getString(PO_NO));
		map.put("noteNo", "" + box.getInt("noteNo"));
		if (box.getInt("deptId") == list.get(0).getStoreExpendable().getId()) {
			HMSUtil
					.generateReport("LocalSupplyOrderPrintForLpoNote", map,
							(Connection) map.get("conn"), response,
							getServletContext());
		} else {
			HMSUtil
					.generateReport("LocaSupplyOrderPrintLpoNoteForEchs1", map,
							(Connection) map.get("conn"), response,
							getServletContext());
		}
		// map=tenderHandlerService.showSupplyOrderSplitUp(box);
		// jsp = "Tender_LPO_Splitup";
		// map.put("contentJsp",jsp);
		// map.put("title", title);
		// return new ModelAndView(jsp, "map", map);
		return null;
	}

	public ModelAndView showTenderPNC(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService
				.getGroupAndTenderAndSupplierComboDetailsForPNC(box);
		jsp = "Tender_PNC";
		jsp += ".jsp";
		title = "Tender - PNC";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getTenderGroupListForPNC(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService
				.getGroupAndTenderAndSupplierComboDetailsForPNC(box);
		jsp = "Tender_PNC";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		title = "Tender - PNC";
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getTenderSupplierListForPNC(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService
				.getGroupAndTenderAndSupplierComboDetailsForPNC(box);
		jsp = "Tender_PNC";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		title = "Tender - PNC";
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getTenderPNCGrid(HttpServletRequest request,
			HttpServletResponse response) {
		String pvmsNo = null;
		Box box = HMSUtil.getBox(request);
		if (box.getString("flag").equals("fresh"))
			box.put("currPage", 1);
		if (request.getParameter("pvmsNo") != null
				&& request.getParameter("pvmsNo").length() > 0) {
			pvmsNo = request.getParameter("pvmsNo");
			box.put("pvmsNo", pvmsNo);
		}
		map = tenderHandlerService.getTenderPNCGrid(box);
		jsp = "Tender_PNC";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		title = "Tender - PNC";
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView updatePNCGridItems(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.updatePNCGridItems(box);
		jsp = "Tender_PNC";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		title = "Tender - PNC";
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generateLocalPurchaseOrder(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.generateLocalPurchaseOrder(box);
		map = tenderHandlerService.showSupplyOrderSplitUp(box);
		jsp = "Tender_LPO_Splitup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView printTenderLocalPurchaseOrder(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getConnection(box);
		map.put("tender_id", box.getInt(TENDER_NO));
		map.put("group_id", box.getInt(TENDER_SUPPLIER_GROUP_ID));
		map.put("DEPT", box.getInt("deptId"));
		map.put("PATH_TO_SUBREPORTS", getServletContext().getRealPath(
				"/reports/"));
		HMSUtil.generateReport("Tender_Local_Supply_Order_Print", map,
				(Connection) map.get("conn"), response, getServletContext());
		jsp = "Tender_PNC";
		jsp = jsp + ".jsp";
		title = "Tender PNC";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printLocalSupplyOrder(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getStoreSetUpData(box);
		List<StoreSetup> list = (List) map.get("storeSetupList");
		map.put("DEPT", box.getInt("dept_id"));
		map.put("po_number", box.getString(PO_NO));
		map.put("tender_id", box.getInt("tender_id"));
		map.put("supplierid", box.getInt("supplier_id"));
		if (box.getInt("dept_id") == list.get(0).getStoreExpendable().getId()) {
			HMSUtil
					.generateReport("LocalSupplyOrderPrint", map,
							(Connection) map.get("conn"), response,
							getServletContext());
		} else {
			HMSUtil
					.generateReport("LocalSupplyOrderPrint_ECHS1", map,
							(Connection) map.get("conn"), response,
							getServletContext());
		}
		map = tenderHandlerService.showSupplyOrderSplitUp(box);
		jsp = "Tender_LPO_Splitup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView printReLocalSupplyOrder(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getStoreSetUpData(box);
		List<StoreSetup> list = (List) map.get("storeSetupList");
		map.put("DEPT", box.getInt("dept_id"));
		map.put("po_number", box.getString(PO_NO));
		map.put("tender_id", box.getInt("tender_id"));
		map.put("supplierid", box.getInt("supplier_id"));
		if (box.getInt("dept_id") == list.get(0).getStoreExpendable().getId()) {
			HMSUtil
					.generateReport("LocalReSupplyOrderPrint", map,
							(Connection) map.get("conn"), response,
							getServletContext());
		} else {
			HMSUtil
					.generateReport("LocalReSupplyOrderPrintForEchs", map,
							(Connection) map.get("conn"), response,
							getServletContext());
		}
		// map=tenderHandlerService.showSupplyOrderSplitUp(box);
		jsp = "Tender_LPO_Splitup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		// return new ModelAndView(jsp, "map", map);
		return null;
	}

	// *************************************** Chart Prior PNC Report
	// ************************************//

	public ModelAndView showChartPriorPNCJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getGroupAndTenderComboDetails(box);
		jsp = "Tender_Comparative_Prior_PNC";
		jsp += ".jsp";
		title = "Tender Comparative Prior PNC";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printReportChartPriorPNCJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getConnection(box);
		map.put("tender_id", box.getInt(TENDER_NO));
		map.put("group_id", box.getInt(TENDER_SUPPLIER_GROUP_ID));
		map.put("department_id", 24);
		map.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		HMSUtil.generateReport("Tender_Comparative_Chart_WithPriorPNC", map,
				(Connection) map.get("conn"), response, getServletContext());
		jsp = "Tender_Comparative_Prior_PNC";
		jsp += ".jsp";
		title = "Tender Comparative Prior PNC";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	// *************************************** Chart Post PNC Report
	// ************************************//

	public ModelAndView showChartPostPNCJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getGroupAndTenderComboDetails(box);
		jsp = "Tender_Comparative_Post_PNC";
		jsp += ".jsp";
		title = "Tender Comparative Post PNC";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printReportTenderComparativePostPNC(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getConnection(box);
		map.put("tender_id", box.getInt(TENDER_NO));
		map.put("group_id", box.getInt(TENDER_SUPPLIER_GROUP_ID));
		// map.put("department_id", box.getInt("deptId"));
		map.put("department_id", 24);
		map.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		HMSUtil.generateReport("Tender_Comparative_Chart_WithPostPNC", map,
				(Connection) map.get("conn"), response, getServletContext());
		jsp = "Tender_Comparative_Post_PNC";
		jsp += ".jsp";
		title = "Tender Comparative Post PNC";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showTenderForNomenclatureReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Tender For PVMS/NIV Report";
		jsp = "Tender_PVMS_NIV_Report";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getItemListForTenderForNomenclatureByAutocomplete(
			HttpServletRequest request, HttpServletResponse response) {

		int deptId = 0;
		session = request.getSession();
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		String itemNameField = "";
		String autoHint = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("requiredField") != null) {
			itemNameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(itemNameField) != null) {
			autoHint = (request.getParameter(itemNameField));
		}
		List<StoreTenderT> itemList = new ArrayList<StoreTenderT>();
		dataMap.put("autoHint", autoHint);
		dataMap.put("deptId", deptId);
		map = tenderHandlerService
				.getItemListForTenderForNomenclatureByAutocomplete(dataMap);
		jsp = "Tender_Autocomplete";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView generateTenderForNomenclatureReport(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		String pvmsNo = "";
		String brand = "";
		int itemId = 0;
		Date frDate = new Date();
		Date toDate = new Date();

		map = tenderHandlerService.getConnectionForReport();
		pvmsNo = box.getString("pvmsNo");
		// //System.out.println("::::::::::::"+box);
		if (request.getParameter("pvmsNo") != null) {
			pvmsNo = request.getParameter("pvmsNo");
		}

		if (box.getString(FROM_DATE) != null && box.getString(FROM_DATE) != "") {
			frDate = HMSUtil.convertStringTypeDateToDateType(box
					.getString(FROM_DATE));
		}
		if (box.getString(TO_DATE) != null && box.getString(TO_DATE) != "") {
			toDate = HMSUtil.convertStringTypeDateToDateType(box
					.getString(TO_DATE));
		}

		String Query = "";
		pvmsNo = box.getString("pvmsNo");

		Query = Query + "where  a.status != 'c' and b.cancelled is null and";
		if (!pvmsNo.equals("") && pvmsNo != null) {
			datamap = tenderHandlerService.getItemId(box);
			itemId = (Integer) datamap.get("itemId");
			Query = Query + "( b.item_id ='" + itemId + "' or k.pvms_no ='"
					+ pvmsNo + "' )";
		}

		if (request.getParameter("brand") != null) {
			brand = request.getParameter("brand").trim();
			if (brand.length() > 0) {
				Query = "where (b.item_id ='' or k.pvms_no ='' or cbt.brand_name = '"
						+ brand + "' or mb.brand_name = '" + brand + "' ) and b.cancelled is null";
			}

		}
		Query = Query + " and a.flag='s' and a.status != 'c' group by a.po_id";
		// //System.out.println("PvmsNo in controller"+box.getString("pvmsNo"));
		// //System.out.println(" box.getInt)in controller"+ itemId);
		//System.out.println("::::::::query:::::" + Query);

		map.put("pvmsNo", pvmsNo);
		map.put("item_id", itemId);
		map.put("Brand_name", brand);
		map.put("query", Query);
		HMSUtil.generateReport("Tender_PVMS_NIV_Supply_Order", map,
				(Connection) map.get("con"), response, getServletContext());
		return null;
	}

	public ModelAndView showFirmsL1Jsp(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getGroupAndTenderComboDetails(box);
		jsp = "Tender_Firms_Approved_L1";
		jsp += ".jsp";
		title = "Tender Firms Approved as L1";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generateTenderFirmsApprovedL1Report(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getConnection(box);
		map.put("tender_id", box.getInt(TENDER_NO));
		map.put("group_id", box.getInt(TENDER_SUPPLIER_GROUP_ID));
		if (box.getInt("deptId") == 38 || box.getInt("deptId") == 24) {
			map.put("department_id", 24);
		}
		int choice = box.getInt("pnc");
		map.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		if (choice == 1)
			HMSUtil
					.generateReport(
							"Tender_Firms_Approved_L1_Prior_PNC_SubReport",
							map, (Connection) map.get("conn"), response,
							getServletContext());
		else
			HMSUtil
					.generateReport(
							"Tender_Firms_Approved_L1_Post_PNC_SubReport", map,
							(Connection) map.get("conn"), response,
							getServletContext());
		jsp = "Tender_Firms_Approved_L1";
		jsp += ".jsp";
		title = "Tender Firms Approved as L1";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showNoQuotationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getGroupAndTenderComboDetails(box);
		jsp = "Tender_No_Quotation";
		jsp += ".jsp";
		title = "Tender Items with No Quotation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generateTenderItemsNoQuotationReport(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getConnection(box);
		map.put("tender_id", box.getInt(TENDER_NO));
		map.put("group_id", box.getInt(TENDER_SUPPLIER_GROUP_ID));
		// map.put("department_id", box.getInt("deptId"));
		if (box.getInt("deptId") == 38 || box.getInt("deptId") == 24) {
			map.put("department_id", 24);
		}
		HMSUtil.generateReport("tender_rep_not_quoted", map, (Connection) map
				.get("conn"), response, getServletContext());
		jsp = "Tender_No_Quotation";
		jsp += ".jsp";
		title = "Tender Items with No Quotation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showTenderForDisqualified(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getGroupAndTenderComboDetails(box);
		jsp = "Tender_Disqualified_Quotes";
		jsp += ".jsp";
		title = "Tender Disqualified Quotes";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generateTenderDisqualifiedQuotesReport(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getConnection(box);
		map.put("tender_id", box.getInt(TENDER_NO));
		map.put("group_id", box.getInt(TENDER_SUPPLIER_GROUP_ID));
		if (box.getInt("deptId") == 38 || box.getInt("deptId") == 24) {
			map.put("department_id", 24);
		}
		HMSUtil.generateReport("tender_rep_quotes_disqualified", map,
				(Connection) map.get("conn"), response, getServletContext());
		jsp = "Tender_Disqualified_Quotes";
		jsp += ".jsp";
		title = "Tender Disqualified Quotes";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showSingleQuotationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getGroupAndTenderComboDetails(box);
		jsp = "Tender_Single_Quotation";
		jsp += ".jsp";
		title = " Tender Single Quotation ";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generateTenderSingleQuotationReport(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getConnection(box);
		map.put("tender_id", box.getInt(TENDER_NO));
		map.put("group_id", box.getInt(TENDER_SUPPLIER_GROUP_ID));
		// map.put("department_id", box.getInt("deptId"));
		if (box.getInt("deptId") == 38 || box.getInt("deptId") == 24) {
			map.put("department_id", 24);
		}
		int choice = box.getInt("rsq");
		if (choice == 1)
			HMSUtil
					.generateReport("tender_rep_single_quotation", map,
							(Connection) map.get("conn"), response,
							getServletContext());
		else
			HMSUtil
					.generateReport("tender_resultant_single_quotation", map,
							(Connection) map.get("conn"), response,
							getServletContext());
		jsp = "Tender_Single_Quotation";
		jsp += ".jsp";
		title = " Tender Single Quotation ";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showTenderProposalJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		String pvmsNo = null;
		if (box.getString("flag").equals("fresh"))
			box.put("currPage", 1);
		int deptId = Integer
				.parseInt(session.getAttribute("deptId").toString());
		box.put("deptId", deptId);
		box.put("numOfRows", 15);
		box.put("pageCount", 10);
		if (request.getParameter("pvmsNo") != null
				&& request.getParameter("pvmsNo").length() > 0) {
			pvmsNo = request.getParameter("pvmsNo");
			//System.out.println("value of pvms in controller---" + pvmsNo);
			box.put("pvmsNo", pvmsNo);
		}
		map = tenderHandlerService.showTenderProposalJsp(box);
		jsp = "Tender_Proposal";
		jsp += ".jsp";
		title = "Tender Proposal";
		map.put("contentJsp", jsp);
		map.put("groupId", box.getInt("groupId"));
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView updateTenderProposalGridItems(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int deptId = Integer
				.parseInt(session.getAttribute("deptId").toString());
		box.put("deptId", deptId);
		map = tenderHandlerService.updateTenderProposalGridItems(box);
		jsp = "Tender_Proposal";
		jsp += ".jsp";
		title = "Tender Proposal";
		map.put("groupId", box.getInt("groupId"));
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteTenderProposalGridItems(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int deptId = Integer
				.parseInt(session.getAttribute("deptId").toString());
		box.put("deptId", deptId);
		map = tenderHandlerService.deleteTenderProposalGridItems(box);
		jsp = "Tender_Proposal";
		jsp += ".jsp";
		title = "Tender Proposal";
		map.put("groupId", box.getInt("groupId"));
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showLocalSupplyOrder(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getGroupAndTenderComboDetails(box);
		jsp = "Tender_LPO";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		title = "Tender - Local Supply Order";
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getTenderGroupListForLPO(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getGroupAndTenderComboDetails(box);
		jsp = "Tender_LPO";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		title = "Tender - Local Supply Order";
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getTenderSupplierListForLPO(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getTenderSupplierListForLPO(box);
		jsp = "Tender_LPO";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		title = "Tender - Local Supply Order";
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showSupplyOrderSplitUp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		//System.out.println("box " + box);
		session = request.getSession();
		map = tenderHandlerService.showSupplyOrderSplitUp(box);
		jsp = "Tender_LPO_Splitup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView cancelSupplyOrderItems(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.cancelSupplyOrderItems(box);
		map = tenderHandlerService.showSupplyOrderSplitUp(box);
		jsp = "Tender_LPO_Splitup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showLocalReSupplyOrder(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getGroupAndTenderComboDetails(box);
		jsp = "Tender_Re_LPO";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		title = "Tender - Local Re-Supply Order";
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getTenderGroupListForReLPO(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getGroupAndTenderComboDetails(box);
		jsp = "Tender_Re_LPO";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		title = "Tender - Local Re-Supply Order";
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getTenderSupplierListForReLPO(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getTenderSupplierListForReLPO(box);
		jsp = "Tender_Re_LPO";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		title = "Tender - Local Re-Supply Order";
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showReSupplyOrderSplitUp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		//System.out.println("box " + box);
		session = request.getSession();
		map = tenderHandlerService.showReSupplyOrderSplitUp(box);
		jsp = "Tender_Re_LPO_Splitup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView generateReLocalPurchaseOrder(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.generateReLocalPurchaseOrder(box);
		map = tenderHandlerService.showReSupplyOrderSplitUp(box);
		jsp = "Tender_Re_LPO_Splitup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView printTenderProposalItems(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		int deptId = Integer
				.parseInt(session.getAttribute("deptId").toString());
		map = tenderHandlerService.getConnection(box);
		map.put("deptId", deptId);
		map.put("groupId", box.getInt("groupId"));
		HMSUtil.generateReport("Tender_Proposal_Report", map, (Connection) map
				.get("conn"), response, getServletContext());
		box.put("deptId", deptId);
		box.put("numOfRows", 15);
		box.put("pageCount", 10);
		map = tenderHandlerService.showTenderProposalJsp(box);
		jsp = "Tender_Proposal";
		jsp += ".jsp";
		title = "Tender Proposal";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showReTenderProposalJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		String pvmsNo = null;
		if (box.getString("flag").equals("fresh"))
			box.put("currPage", 1);
		int deptId = Integer
				.parseInt(session.getAttribute("deptId").toString());
		box.put("deptId", deptId);
		box.put("numOfRows", 15);
		box.put("pageCount", 10);
		if (request.getParameter("pvmsNo") != null
				&& request.getParameter("pvmsNo").length() > 0) {
			pvmsNo = request.getParameter("pvmsNo");
			box.put("pvmsNo", pvmsNo);
		}
		map = tenderHandlerService.showReTenderProposalJsp(box);
		jsp = "Re_Tender_Proposal";
		jsp += ".jsp";
		title = "Re Tender Proposal";
		map.put("contentJsp", jsp);
		map.put("title", title);
		if (box.get(TENDER_NO) != null && box.getInt(TENDER_NO) != 0)
			map.put(TENDER_NO, box.getInt(TENDER_NO));
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView updateReTenderProposalGridItems(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int deptId = Integer
				.parseInt(session.getAttribute("deptId").toString());
		box.put("deptId", deptId);
		map = tenderHandlerService.updateReTenderProposalGridItems(box);
		jsp = "Re_Tender_Proposal";
		jsp += ".jsp";
		title = "Re Tender Proposal";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteReTenderProposalGridItems(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int deptId = Integer
				.parseInt(session.getAttribute("deptId").toString());
		box.put("deptId", deptId);
		map = tenderHandlerService.deleteReTenderProposalGridItems(box);
		jsp = "Re_Tender_Proposal";
		jsp += ".jsp";
		title = "Re Tender Proposal";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showAddReTenderItemsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int deptId = Integer
				.parseInt(session.getAttribute("deptId").toString());
		box.put("deptId", deptId);
		map = tenderHandlerService.getReTenderItemDetails(box);
		jsp = "Re_Tender_Items_Addition";
		title = "Add Re Tender Items";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("tender_no", box.getInt(TENDER_NO));
		map.put("proposal_id", box.getInt(PROPOSAL_ID));
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView doAddReTenderItems(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.doAddReTenderProposalItems(box);
		jsp = "Re_Tender_Items_Addition";
		title = "Add Re Tender Items";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView printReTenderProposalItems(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		int deptId = Integer
				.parseInt(session.getAttribute("deptId").toString());
		map = tenderHandlerService.getConnection(box);
		map.put("deptId", deptId);
		HMSUtil.generateReport("Re_Tender_Proposal_Report", map,
				(Connection) map.get("conn"), response, getServletContext());
		box.put("deptId", deptId);
		box.put("numOfRows", 15);
		box.put("pageCount", 10);
		map = tenderHandlerService.showReTenderProposalJsp(box);
		jsp = "Re_Tender_Proposal";
		jsp += ".jsp";
		title = "Tender Proposal";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showReTenderLocalSupplyOrder(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int deptId = Integer
				.parseInt(session.getAttribute("deptId").toString());
		box.put("dept", deptId);
		map = tenderHandlerService.getGroupAndTenderComboDetails(box);
		jsp = "Re_Tender_LPO";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		title = "Re Tender - Local Supply Order";
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getReTenderGroupListForLPO(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getGroupAndTenderComboDetails(box);
		jsp = "Re_Tender_LPO";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		title = "Re Tender - Local Supply Order";
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getReTenderSupplierListForLPO(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int deptId = Integer
				.parseInt(session.getAttribute("deptId").toString());
		box.put("dept", deptId);
		map = tenderHandlerService.getReTenderSupplierListForLPO(box);
		jsp = "Re_Tender_LPO";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		title = "Re Tender - Local Supply Order";
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showReTenderSupplyOrderSplitUp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		map = tenderHandlerService.showReTenderSupplyOrderSplitUp(box);
		jsp = "Re_Tender_LPO_Splitup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView generateReTenderLocalPurchaseOrder(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.generateReTenderLocalPurchaseOrder(box);
		map = tenderHandlerService.showReTenderSupplyOrderSplitUp(box);
		jsp = "Re_Tender_LPO_Splitup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView cancelReTenderSupplyOrderItems(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.cancelReTenderSupplyOrderItems(box);
		map = tenderHandlerService.showReTenderSupplyOrderSplitUp(box);
		jsp = "Re_Tender_LPO_Splitup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showReTenderReSupplyOrder(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getGroupAndTenderComboDetails(box);
		jsp = "Re_Tender_Re_LPO";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		title = "Re Tender - Local Re-Supply Order";
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getReTenderSupplierListForReLPO(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getReTenderSupplierListForReLPO(box);
		jsp = "Re_Tender_Re_LPO";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		title = "Re Tender - Local Re-Supply Order";
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showReTenderReSupplyOrderSplitUp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		map = tenderHandlerService.showReTenderReSupplyOrderSplitUp(box);
		jsp = "Re_Tender_Re_LPO_Splitup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView generateReTenderReLocalPurchaseOrder(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.generateReTenderReLocalPurchaseOrder(box);
		map = tenderHandlerService.showReTenderReSupplyOrderSplitUp(box);
		jsp = "Re_Tender_Re_LPO_Splitup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getReTenderGroupListForReLPO(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getGroupAndTenderComboDetails(box);
		jsp = "Re_Tender_Re_LPO";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		title = "Re Tender - Local Re-Supply Order";
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public void getImportProposals(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreTenderProposal> sTPList = new ArrayList<StoreTenderProposal>();
		@SuppressWarnings("unused")
		List objectList = new ArrayList();
		String groupId = null;
		if (request.getParameter("groupId") != null) {
			groupId = request.getParameter("groupId");
		}
		dataMap.put("groupId", groupId);

		try {
			if (!groupId.equals("") && groupId != null) {
				map = tenderHandlerService.getImportProposals(dataMap);
			}
			sTPList = (List) map.get("storeTenderProposalList");

			StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			if (sTPList != null) {
				if (sTPList.size() > 0) {
					sb.append("<STPStatus>" + "YES" + "</STPStatus>");
				} else {
					sb.append("<STPStatus>" + "NO" + "</STPStatus>");
				}
			} else {
				sb.append("<STPStatus>" + "NO" + "</STPStatus>");
			}
			sb.append("</item>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");

			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
			//System.out.println("sb        " + sb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ModelAndView showSupplyOrderSummary(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getGroupAndTenderComboDetails(box);
		jsp = "showSupplyOrderSummary";
		jsp += ".jsp";
		title = "Supply Order Summary";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generateSupplyOrderSummaryReport(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		//System.out.println("box:::" + box);
		session = request.getSession();
		int deptId = Integer
				.parseInt(session.getAttribute("deptId").toString());
		String deptName = (String) session.getAttribute("deptName");
		;
		map = tenderHandlerService.getConnection(box);
		Date frDate = new Date();
		Date toDate = new Date();
		String soNoFrom = "";
		String soNoTo = "";
		String groupId = "";
		String supplierName = "";
		String stringVariable = "";
		String groupName = "";
		if (request.getParameter(FROM_DATE) != null
				&& request.getParameter(FROM_DATE) != "") {
			frDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null
				&& request.getParameter(TO_DATE) != "") {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(SUPPLYNOFROM) != null
				&& request.getParameter(SUPPLYNOFROM) != "") {
			soNoFrom = (String) request.getParameter(SUPPLYNOFROM);
		}
		if (request.getParameter(SUPPLYNOTO) != null
				&& request.getParameter(SUPPLYNOTO) != "") {
			soNoTo = (String) request.getParameter(SUPPLYNOTO);
		}
		if (request.getParameter(TENDER_SUPPLIER_GROUP_ID) != null
				&& request.getParameter(TENDER_SUPPLIER_GROUP_ID) != "") {
			groupId = request.getParameter(TENDER_SUPPLIER_GROUP_ID);
		}
		if (request.getParameter(TENDER_VENDOR_SUPPLIER_ID) != null
				&& request.getParameter(TENDER_VENDOR_SUPPLIER_ID) != "") {
			supplierName = request.getParameter(TENDER_VENDOR_SUPPLIER_ID);
		}

		if (soNoFrom != "" && soNoTo != "") {
			stringVariable = stringVariable
					+ " and store_po_header.po_number between '" + soNoFrom
					+ "' and '" + soNoTo + "'";
		}
		if (groupId != "") {
			stringVariable = stringVariable
					+ " and mas_store_item.group_id = '" + groupId + "'";
		}

		if (supplierName != "") {
			stringVariable = stringVariable
					+ " and mas_store_supplier.supplier_name = '"
					+ supplierName + "'";
		}

		if (groupId != "") {
			if (request.getParameter("groupName") != null
					&& request.getParameter("groupName") != "") {
				groupName = request.getParameter("groupName");
			}
		} else {
			groupName = "All";
		}

		// //System.out.println("::::::::::::::::"+stringVariable);
		map.put("fromDate", frDate);
		map.put("SONoFrom", soNoFrom);
		map.put("SONoTo", soNoTo);
		map.put("toDate", toDate);
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("stringVariable", stringVariable);
		map.put("groupName", groupName);
		HMSUtil.generateReport("supply_order_summary", map, (Connection) map
				.get("conn"), response, getServletContext());
		return null;
	}

	public ModelAndView getSupplierListByAutocomplete(
			HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		String supplierNameField = "";
		String autoHint = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("requiredField") != null) {
			supplierNameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(supplierNameField) != null) {
			autoHint = (request.getParameter(supplierNameField));

		}
		dataMap.put("autoHint", autoHint);
		map = tenderHandlerService.getSuppliersListByAutocomplete(dataMap);
		jsp = "resultForSuppliers";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getReTenderGroupListForProposal(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int deptId = Integer
				.parseInt(session.getAttribute("deptId").toString());
		box.put("dept", deptId);
		map = tenderHandlerService
				.getGroupAndTenderComboDetailsForProposal(box);
		jsp = "Re_Tender_LPO";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		title = "Re Tender - Local Supply Order";
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getReTenderGroupListForProposalCancel(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService
				.getGroupAndTenderComboDetailsForProposal(box);
		jsp = "Re_Tender_Re_LPO";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		title = "Re Tender - Local Supply Order";
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showSupplyOrderPrint(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		// map=tenderHandlerService.getGroupAndTenderComboDetails(box);
		jsp = "supplierOrderPrint";
		jsp += ".jsp";
		title = "Supply Order";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateSupplyOrderPrintReport(HttpServletRequest request, HttpServletResponse response)
	{
		Box box = HMSUtil.getBox(request);
		Map<String, Object> datamap = new HashMap<String, Object>();
		List<StorePoHeader> sPHList =new ArrayList<StorePoHeader>();
		List<StoreTenderLocalPurchaseT> storeNoteList =new ArrayList<StoreTenderLocalPurchaseT>(); 
		List<StoreSetup> storeSetUpList =new ArrayList<StoreSetup>(); 
		session = request.getSession();
		int deptId = Integer.parseInt(session.getAttribute("deptId").toString());
		String deptName = (String)session.getAttribute("deptName");;
		map = tenderHandlerService.getConnection(box);
		String soNoFrom = "";
		int tender_id = 0;
		int supplier_id = 0;
		int dept_id = 0;
		int dept_id1 = 0;
		String storeType = "";
		String flag = "";
		int exp = 0;
		int echs = 0;
		String note = "";
		if(request.getParameter(SUPPLYNOFROM)!= null && request.getParameter(SUPPLYNOFROM) != "" ){
			soNoFrom =(String)request.getParameter(SUPPLYNOFROM);
		}
		if(request.getParameter("storetype")!= null && request.getParameter("storetype") != "" ){
			storeType =(String)request.getParameter("storetype");
		}
        if(storeType.equals("e")){
			dept_id1 = 24;
		}else{
			dept_id1= 38;
		}
		datamap =tenderHandlerService.getSupplyOrderDetail(soNoFrom,dept_id1);
        sPHList = (List) datamap.get("storePoHeader");
		storeNoteList = (List) datamap.get("stroeNote");
		storeSetUpList = (List) datamap.get("storeSet");
	
		for(StorePoHeader storePO : sPHList){
			if(storePO.getTenderM()  != null)
			 tender_id= storePO.getTenderM().getId();
			 supplier_id = storePO.getSupplier().getId();
			 dept_id = storePO.getDepartment().getId();
			 flag = storePO.getFlag();
		}
		for(StoreSetup storeSetUp : storeSetUpList){
			exp = storeSetUp.getStoreExpendable().getId();
			echs = storeSetUp.getStoreEchs().getId();
		}
		if(storeNoteList != null && storeNoteList.size() >0){
			StoreTenderLocalPurchaseT tendernote = (StoreTenderLocalPurchaseT) storeNoteList.get(0);
			note = tendernote.getStoreTenderLocalPurchaseM().getNoteNo().toString();
		}
		map.put("po_number",soNoFrom );
		map.put("tender_id",tender_id);
		map.put("deptId", dept_id1);
		map.put("DEPT", dept_id1);
		map.put("noteNo", ""+note);   
  	    map.put("supplierid",supplier_id);
		
		if(tender_id == 0 && sPHList != null && sPHList.size() > 0){
			if(dept_id1 == exp){
			HMSUtil.generateReport("LocalSupplyOrderPrintForStores", map, (Connection)map.get("conn"), response, getServletContext());
			}else{
			HMSUtil.generateReport("LocalSupplyOrderPrintForStoresEchs", map, (Connection)map.get("conn"), response, getServletContext());	
			}
			
		}else{
			if(storeNoteList != null && storeNoteList.size() > 0){
				if(dept_id1 == exp){
					HMSUtil.generateReport("LocalSupplyOrderPrintForLpoNote", map, (Connection)map.get("conn"), response, getServletContext());		   
				}else{
					HMSUtil.generateReport("LocaSupplyOrderPrintLpoNoteForEchs1", map, (Connection)map.get("conn"), response, getServletContext());
				}
			}else{
				if(flag.equals("r")){ 
					if(dept_id1 == exp){
						HMSUtil.generateReport("LocalReSupplyOrderPrint", map, (Connection)map.get("conn"), response, getServletContext());		   
					}else{
						HMSUtil.generateReport("LocalReSupplyOrderPrintForEchs", map, (Connection)map.get("conn"), response, getServletContext());
					}
				}else if(flag.equals("s")){
					if(dept_id1 == exp){
						HMSUtil.generateReport("LocalSupplyOrderPrint", map, (Connection)map.get("conn"), response, getServletContext());		   
					}else{
						HMSUtil.generateReport("LocalSupplyOrderPrint_ECHS1", map, (Connection)map.get("conn"), response, getServletContext());
					}
				}	
			}
		}
		return null;
	}

	public void getconfirmation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreTenderProposal> sTPList = new ArrayList<StoreTenderProposal>();
		List<StorePoHeader> sPHList = new ArrayList<StorePoHeader>();
		List<StoreTenderLocalPurchaseT> storeNoteList = new ArrayList<StoreTenderLocalPurchaseT>();
		@SuppressWarnings("unused")
		List objectList = new ArrayList();
		String soNo = null;
		String storeType = "";
		int dept_id1 = 0;
		if (request.getParameter("soNo") != null) {
			soNo = request.getParameter("soNo");
		}

		if (request.getParameter("dept") != null
				&& request.getParameter("dept") != "") {
			storeType = (String) request.getParameter("dept");
		}

		if (storeType.equals("e")) {
			dept_id1 = 24;
		} else {
			dept_id1 = 38;
		}

		try {
			if (!soNo.equals("") && soNo != null) {
				dataMap = tenderHandlerService.getSupplyOrderDetail(soNo,
						dept_id1);
			}
			sPHList = (List) dataMap.get("storePoHeader");
			storeNoteList = (List) dataMap.get("stroeNote");

			StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			if (sPHList != null) {
				if (sPHList.size() > 0) {
					sb.append("<STPStatus>" + "YES" + "</STPStatus>");
				} else {
					sb.append("<STPStatus>" + "NO" + "</STPStatus>");
				}
			} else {
				sb.append("<STPStatus>" + "NO" + "</STPStatus>");
			}
			sb.append("</item>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");

			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
			// //System.out.println("sb        "+sb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ModelAndView printReportForVendor(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		//System.out.println(":::::::::::" + box);
		try {

			map.put("tender_id", new Integer(box.getInt(TENDER_NO)));
			map.put("group_id", new Integer(box
					.getInt(TENDER_SUPPLIER_GROUP_ID)));
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = tenderHandlerService
				.getConnectionForReport();
		Map<String, Object> map = new HashMap<String, Object>();
		map = tenderHandlerService.getExcelSheetDataForVendor(box);
		if (map.get("flag") != null
				&& map.get("flag").toString().equalsIgnoreCase("NoData")) {
			map.put("message", "No Data Found!....");
		} else {

			try {

				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition",
						"attachment; filename="
								+ map.get("download_path").toString());
				File f = new File(map.get("download_path").toString());
				InputStream in = new FileInputStream(f);
				ServletOutputStream outs = response.getOutputStream();
				int bit = 256;
				int i = 0;
				while ((bit) >= 0) {
					bit = in.read();
					outs.write(bit);
				}
				outs.flush();
				outs.close();
				in.close();
				if (f.exists())
					f.delete();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		return null;
	}

	public ModelAndView printCancelLocalSupplyOrder(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getStoreSetUpData(box);
		List<StoreSetup> list = (List) map.get("storeSetupList");
		map.put("DEPT", box.getInt("dept_id"));
		map.put("po_number", box.getString(PO_NO));
		map.put("tender_id", box.getInt("tender_id"));
		map.put("supplierid", box.getInt("supplier_id"));
		if (box.getInt("dept_id") == list.get(0).getStoreExpendable().getId()) {
			HMSUtil
					.generateReport("LocalCancelSupplyOrderPrint", map,
							(Connection) map.get("conn"), response,
							getServletContext());
		} else {
			HMSUtil
					.generateReport("LocalCancelSupplyOrderPrint_ECHS1", map,
							(Connection) map.get("conn"), response,
							getServletContext());
		}
		map = tenderHandlerService.showSupplyOrderSplitUp(box);
		jsp = "Tender_LPO_Splitup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView printCancelReLocalSupplyOrder(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.getStoreSetUpData(box);
		List<StoreSetup> list = (List) map.get("storeSetupList");
		map.put("DEPT", box.getInt("dept_id"));
		map.put("po_number", box.getString(PO_NO));
		map.put("tender_id", box.getInt("tender_id"));
		map.put("supplierid", box.getInt("supplier_id"));
		if (box.getInt("dept_id") == list.get(0).getStoreExpendable().getId()) {
			HMSUtil
					.generateReport("LocalReCancelSupplyOrderPrint", map,
							(Connection) map.get("conn"), response,
							getServletContext());
		} else {
			HMSUtil
					.generateReport("LocalCancelReSupplyOrderPrintForEchs",
							map, (Connection) map.get("conn"), response,
							getServletContext());
		}
		// map=tenderHandlerService.showSupplyOrderSplitUp(box);
		jsp = "Tender_LPO_Splitup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		// return new ModelAndView(jsp, "map", map);
		return null;
	}

	public ModelAndView ImportLastTenderProposal(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		//System.out.println("box:::::::" + box);
		String pvmsNo = null;
		int hospitalId = 0;
		if (box.getString("flag").equals("fresh"))
			box.put("currPage", 1);
		int deptId = Integer
				.parseInt(session.getAttribute("deptId").toString());
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
		box.put("numOfRows", 15);
		box.put("pageCount", 10);
		/*
		 * if(request.getParameter("pvmsNo") != null &&
		 * request.getParameter("pvmsNo").length()>0) {
		 * pvmsNo=request.getParameter("pvmsNo"); box.put("pvmsNo", pvmsNo); }
		 */
		boolean proposal = tenderHandlerService.importLastTenderProposal(box);
		map = tenderHandlerService.showTenderProposalJsp(box);
		jsp = "Tender_Proposal";
		jsp += ".jsp";
		title = "Tender Proposal";
		map.put("contentJsp", jsp);
		map.put("groupId", box.getInt("groupId"));
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getTenders(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		String pvmsNo = null;
		if (box.getString("flag").equals("fresh"))
			box.put("currPage", 1);
		int deptId = Integer
				.parseInt(session.getAttribute("deptId").toString());
		box.put("deptId", deptId);
		box.put("numOfRows", 15);
		box.put("pageCount", 10);

		map = tenderHandlerService.getTenders(box);
		jsp = "Tender_Proposal";
		jsp += ".jsp";
		title = "Tender Proposal";
		map.put("contentJsp", jsp);
		map.put("groupId", box.getInt("groupId"));
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}
	//-----------Come from Noida----------------------------
	public ModelAndView cancelSupplyOrderItemsForLpoNote(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		map = tenderHandlerService.cancelSupplyOrderItemsForLpoNote(box);
		map = tenderHandlerService.showSupplyOrderSplitUpForLpoNote(box);
		jsp = "Tender_LPO_Splitup_for_LPONote";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

}
