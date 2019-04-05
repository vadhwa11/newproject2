/**
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Class PurchaseOrderController.java –
 * Tables Used: store_po_detail, store_po_header
 * Purpose of the class - For Local Purchase (LP) of PVMS and NIV Items
 * @author  Deepti Tevatia
 * Create Date: 4th Feb,2008
 * Revision Date:      		Revision By:
 * @version 1.0
 * @see PurchaseOrderHandlerService.java, PurchaseOrderHandlerServiceImpl.java, PurchaseOrderDataService.java, PurchaseOrderDataServiceImpl.java
 **/
package jkt.hms.purchaseOrder.controller;

import static jkt.hms.util.RequestConstants.*;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasAuthorizer;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasManufacturer;
import jkt.hms.masters.business.MasStoreBrand;
import jkt.hms.masters.business.MasStoreBudget;
import jkt.hms.masters.business.MasStoreGroup;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStorePoDeliveryTerms;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.StorePoDetail;
import jkt.hms.masters.business.StorePoHeader;
import jkt.hms.masters.business.StoreSetup;
import jkt.hms.masters.business.StoreTenderM;
import jkt.hms.masters.business.StoreTenderProposal;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.purchaseOrder.handler.PurchaseOrderHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.JKTRequestUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class PurchaseOrderController extends MultiActionController {
	PurchaseOrderHandlerService purchaseOrderHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;

	HttpSession session = null;
	Map<String, Object> map = new HashMap<String, Object>();
	String jsp = "";
	String title = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	String userName = "";
	String currentDate = "";
	String currentTime = "";
	String message = "";

	public ModelAndView showPurchaseOrderJsp(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int deptId = 0;
		int hospitalId=0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		//map = purchaseOrderHandlerService.showPurchaseOrderJsp(deptId);   comment By Tirath For hospitalId

		dataMap.put("hospitalId", hospitalId);
		dataMap.put("deptId",deptId);


		map = purchaseOrderHandlerService.showPurchaseOrderJsp(dataMap);
		List<StorePoHeader>poNumberList = purchaseOrderHandlerService.getPoNumberList(deptId,hospitalId);
		jsp = LOCAL_PURCHASE_JSP;
		jsp = jsp + ".jsp";
		title = "Supply Order";
		map.put("contentJsp", jsp);
		map.put("title", title);
		String previousPage = "no";
		map.put("poNumberList", poNumberList);
		map.put("previousPage", previousPage);
		return new ModelAndView("index", "map", map);
	}
	// For Adding the New Local Purchase Order respective to a vendor
	@SuppressWarnings("deprecation")
	public ModelAndView submitPurchaseOrder(HttpServletRequest request,HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();

		int supplierId = 0;
		String poNumber = "";
		String quotationNo = "";
		String remarks = "";
		String payTerms = "";
		Date poDate = new Date();
		Date quotationDate = new Date();
		Date deliveryDate = new Date();
		String signingAuthority = "";
		String appVide = "";

		String deliveryTerms = "";
		int pageNo = 1;
		int noOfRecords = 0;
		int poId = 0;
		String date = "";
		String time = "";
		String buttonFlag = "";
		String loginName = "";
		String fileNo = "";
		String references="";
		String category="";
		String telephoneNo="";
		String codehead="";
		String requestType="";

		int departmentId = 0;
		int hospitalId=0;
		BigDecimal totalAmount = new BigDecimal(0);

		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
		}

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}

		StorePoHeader storePoHeader = new StorePoHeader();
		if (request.getParameter("buttonFlag") != null) {
			buttonFlag = request.getParameter("buttonFlag");
		}

		if (!request.getParameter(PO_ID).equals("0")) {
			poId = Integer.parseInt(request.getParameter(PO_ID));
		}
		if (request.getParameter(NO_OF_ROWS) != null) {
			noOfRecords = Integer.parseInt(request.getParameter(NO_OF_ROWS));
		}
		if (request.getParameter(PO_NO) != null) {
			poNumber = request.getParameter(PO_NO);
			box.put(PO_NO, poNumber);
		}
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (!poNumber.equals("") && poNumber != null) {
			poId = purchaseOrderHandlerService.getPurchaseOrderId(poNumber,hospitalId);
		}
		if (request.getParameter(PO_DATE) != null) {
			poDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(PO_DATE));
			box.put(PO_DATE, poDate);
		}
		if (!request.getParameter(SUPPLIER_ID).equals("0")) {
			supplierId = Integer.parseInt(request.getParameter(SUPPLIER_ID));
			box.put(SUPPLIER_ID, supplierId);
		}

		if (request.getParameter(DELIVERY_DATE) != null) {
			deliveryDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DELIVERY_DATE));
			box.put(DELIVERY_DATE, deliveryDate);
		}
		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
			box.put(REMARKS, remarks);
		}
		if (request.getParameter("approval") != null) {
			appVide = request.getParameter("approval");
			box.put("approval", appVide);
		}
		if(request.getParameter("references")!=null){
			references=request.getParameter("references");
		}
		if(request.getParameter("category")!=null){
			category=request.getParameter("category");
		}if(request.getParameter("telephoneNo")!=null){
			telephoneNo=request.getParameter("telephoneNo");
		}if(request.getParameter("codehead")!=null){
			codehead=request.getParameter("codehead");
		}if(request.getParameter("requestType")!=null){
			requestType=request.getParameter("requestType");
		}
		if(box.getString(LPO_SIGNING_AUTHORITY) !=null){
		signingAuthority = box.getString(LPO_SIGNING_AUTHORITY);
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		/*if (request.getParameter(QUOTATION_NO) != null) {
		quotationNo = request.getParameter(QUOTATION_NO);
		box.put(QUOTATION_NO, quotationNo);
	}
	if (request.getParameter(QUOTATION_DATE) != null) {
		quotationDate = HMSUtil.dateFormatterDDMMYYYY(request
				.getParameter(QUOTATION_DATE));
		box.put(QUOTATION_DATE, quotationDate);
	}*/
		/*if (request.getParameter(PAY_TERMS) != null) {
			payTerms = request.getParameter(PAY_TERMS);
			box.put(PAY_TERMS, payTerms);
		}
		if (request.getParameter(DELIVERY_TERMS) != null) {
			deliveryTerms = request.getParameter(DELIVERY_TERMS);
			box.put(DELIVERY_TERMS, deliveryTerms);
		}



		if (request.getParameter(FILE_NO) != null) {
			fileNo = request.getParameter(FILE_NO);
			box.put(FILE_NO, fileNo);
		}*/
		if (request.getParameter(TOTAL_AMOUNT) != null) {
			totalAmount = new BigDecimal(request.getParameter(TOTAL_AMOUNT));
			box.put(TOTAL_AMOUNT, totalAmount);
		}
		String headerStored = "no";
		if (pageNo == 1) {
			if (poId == 0) {
				storePoHeader.setPoNumber(poNumber);
				storePoHeader.setPoDate(poDate);

				MasStoreSupplier supplier = new MasStoreSupplier();
				MasHospital masHospital=new MasHospital();

				try
				{
					masHospital.setId(hospitalId);
					storePoHeader.setHospital(masHospital);
				}catch(Exception e)
				{

				}
				supplier.setId(supplierId);
				storePoHeader.setSupplier(supplier);
				storePoHeader.setDeliveryDate(deliveryDate);

				storePoHeader.setRemarks(remarks);
				storePoHeader.setAppVide(appVide);
				storePoHeader.setReferences(references);
				storePoHeader.setCategory(category);
				storePoHeader.setTelephoneNo(telephoneNo);
				storePoHeader.setCodehead(codehead);
				/*storePoHeader.setPayTerms(payTerms);
				storePoHeader.setQuotationNumber(quotationNo);
				storePoHeader.setQuotationDate(quotationDate);
				storePoHeader.setDeliveryTerms(deliveryTerms);
				storePoHeader.setNetAmount(totalAmount);*/
				storePoHeader.setSigningAuthority(signingAuthority);

				storePoHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
				storePoHeader.setLastChgTime(time);
				
				/**
				 * Commented by Ritu
				 * status=o is set from lp approval
				 */
				
		//		storePoHeader.setStatus("o");
				storePoHeader.setStatus("p");
				storePoHeader.setFileNo(fileNo);
				storePoHeader.setFlag("s");

				if (session.getAttribute("loginName") != null) {
					loginName = (String) session.getAttribute("loginName");
				}

				storePoHeader.setLastChgBy(loginName);

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				storePoHeader.setDepartment(masDepartment);

				storePoHeader.setPoTime(time);
			} else {
				String po_num = "";
				po_num = purchaseOrderHandlerService.getnextPurchaseOrder(
						poNumber, departmentId);
				box.put(PO_NO, po_num);
				storePoHeader.setPoNumber(po_num);
				storePoHeader.setPoDate(poDate);

				MasStoreSupplier supplier = new MasStoreSupplier();
				supplier.setId(supplierId);
				storePoHeader.setSupplier(supplier);

				storePoHeader.setQuotationNumber(quotationNo);
				storePoHeader.setQuotationDate(quotationDate);
				storePoHeader.setDeliveryDate(deliveryDate);
				storePoHeader.setRemarks(remarks);
				storePoHeader.setAppVide(appVide);
				storePoHeader.setPayTerms(payTerms);
				storePoHeader.setDeliveryTerms(deliveryTerms);

			//	storePoHeader.setNetAmount(totalAmount);
				storePoHeader.setSigningAuthority(signingAuthority);

				storePoHeader.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(date));
				storePoHeader.setLastChgTime(time);
				storePoHeader.setStatus("o");
				storePoHeader.setFileNo(fileNo);
				storePoHeader.setFlag("s");

				if (session.getAttribute("loginName") != null) {
					loginName = (String) session.getAttribute("loginName");
				}

				storePoHeader.setLastChgBy(loginName);

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				storePoHeader.setDepartment(masDepartment);

				storePoHeader.setPoTime(time);
				MasHospital masHospital=new MasHospital();
				masHospital.setId(hospitalId);
				storePoHeader.setHospital(masHospital);
			}
		} else {
			headerStored = "yes";
			infoMap.put("headerStored", headerStored);
			infoMap.put("totalAmount", totalAmount);
			storePoHeader.setId(poId);
			storePoHeader.setNetAmount(totalAmount);
		}
		int length = 0;

		BigDecimal[] quantityArr = new BigDecimal[noOfRecords-1];
		BigDecimal[] discountArr = new BigDecimal[noOfRecords-1];
		BigDecimal[] discountAmountArr = new BigDecimal[noOfRecords-1];
		BigDecimal[] amountArr = new BigDecimal[noOfRecords-1];



		BigDecimal[] actQuantityArr = new BigDecimal[noOfRecords-1];
		BigDecimal[] taxArr = new BigDecimal[noOfRecords-1];
		BigDecimal[] unitRateArr = new BigDecimal[noOfRecords-1];
		BigDecimal[] taxAmountArr = new BigDecimal[noOfRecords-1];
		

		/*BigDecimal[] exciseArr = new BigDecimal[10];*/
		//BigDecimal[] taxOqArr = new BigDecimal[10];

		// BigDecimal[] freeQtyArr = new BigDecimal[10];


		List<StorePoDetail> poDetailList = new ArrayList<StorePoDetail>();
		int patientIdArr[]=new int[noOfRecords-1];
		try {
			// int srNo[] =
			// JKTRequestUtils.getRequiredIntParameters(request,SR_NO);
			int itemIdArr[] = JKTRequestUtils.getRequiredIntParameters(request,	ITEM_ID);

			patientIdArr=JKTRequestUtils.getRequiredIntParameters(request,"prescription_id");


			Vector manufacturerIdArr = box.getVector(MANUFACTURER_ID);
			Vector brandIdArr = box.getVector(BRAND_ID);
			// int manufacturerIdArr[] =
			// JKTRequestUtils.getRequiredIntParameters(request,MANUFACTURER_ID);
			// int brandIdArr[] =
			// JKTRequestUtils.getRequiredIntParameters(request,BRAND_ID);
			// String freeItemArr[] =
			// JKTRequestUtils.getRequiredStringParameters(request,FREE_ITEM);
			//Vector freeItemArr = box.getVector(FREE_ITEM);

			String actQty[] = JKTRequestUtils.getRequiredStringParameters(
					request, ACTUAL_QTY);
			int actLen = actQty.length;
			for (int i = 0; i < noOfRecords-1; i++) {
				BigDecimal val = new BigDecimal(actQty[i]);
				actQuantityArr[i] = val;
			}

			String xx[] = JKTRequestUtils.getRequiredStringParameters(request,QUANTITY);
			int xxLen = xx.length;
			for (int i = 0; i < noOfRecords-1; i++) {
				BigDecimal val = new BigDecimal(xx[i]);
				quantityArr[i] = val;
			}

			String zz[] = JKTRequestUtils.getRequiredStringParameters(request,	DISCOUNT_PERCENTAGE);
			int zzLen = zz.length;
			for (int i = 0; i < noOfRecords-1; i++) {
				BigDecimal val = new BigDecimal(zz[i]);
				discountArr[i] = val;
			}
			String qq[] = JKTRequestUtils.getRequiredStringParameters(request,AMOUNT);
			int qqLen = qq.length;
			for (int i = 0; i < noOfRecords-1; i++) {
				BigDecimal val = new BigDecimal(qq[i]);
				amountArr[i] = val;
			}
			String dis[] = JKTRequestUtils.getRequiredStringParameters(request,DISCOUNT_AMOUNT);
			int disLen = dis.length;
			for (int i = 0; i < noOfRecords-1; i++) {
				BigDecimal val = new BigDecimal(dis[i]);
				discountAmountArr[i] = val;
			}

			String yy[] = JKTRequestUtils.getRequiredStringParameters(request,TAX_PERCENT);
			int yyLen = yy.length;
			for (int i = 0; i < noOfRecords-1; i++) {
				BigDecimal val = new BigDecimal(yy[i]);
				taxArr[i] = val;
			}

			 String tt[] =
			 JKTRequestUtils.getRequiredStringParameters(request, COST_PRICE);
			 int ttLen = tt.length; for( int i = 0 ;i < noOfRecords-1 ; i++) {
			 BigDecimal val = new BigDecimal(tt[i]); unitRateArr[i] = val; }


			/*
			 * String pp[] =
			 * JKTRequestUtils.getRequiredStringParameters(request, FREE_QTY);
			 * int ppLen = pp.length; for( int i = 0 ;i < ppLen ; i++){
			 * BigDecimal val = new BigDecimal(pp[i]); freeQtyArr[i] = val; }
			 */
			//Vector freeQtyArr = box.getVector(FREE_QTY);


			  String tax[] =JKTRequestUtils.getRequiredStringParameters(request,TAX_AMOUNT);
			  int taxLen = tax.length;
					  for( int i = 0 ;i <
					  noOfRecords-1 ; i++){
			BigDecimal val = new BigDecimal(tax[i]);
			 taxAmountArr[i] = val;
			 }


			/*String ed[] = JKTRequestUtils.getRequiredStringParameters(request,
					"exciseDuty");
			int edLen = ed.length;
			for (int i = 0; i < edLen; i++) {
				BigDecimal val = new BigDecimal(ed[i]);
				exciseArr[i] = val;
			}

			String taxOq[] = JKTRequestUtils.getRequiredStringParameters(
					request, "taxOq");
			int taxOqLen = taxOq.length;
			for (int i = 0; i < taxOqLen; i++) {
				BigDecimal val = new BigDecimal(taxOq[i]);
				taxOqArr[i] = val;
			}*/

			if (buttonFlag.equals("next")) {
				// if(buttonFlag != null){
				length = 10;
			} else {
				length = noOfRecords-1;
			}

			// get mdq, dispense type, rate per mdq
			Vector dispenseType = box.getVector("dipenseType");
			Vector mdq = box.getVector("mdq");
			Vector mrp = box.getVector("mrp");
			Vector BG=box.getVector("BG");


			//Vector otherTaxes = box.getVector("otherTaxes");
			//Vector ratePerMdq = box.getVector("ratePerMdq");


			for (int i = 0; i < length; i++) {
				if (itemIdArr[i] != 0) {
					StorePoDetail storePoDetail = new StorePoDetail();
					storePoDetail.setSerialNo(i + 1);
					MasStoreItem masItem = new MasStoreItem();
					masItem.setId(itemIdArr[i]);
					storePoDetail.setItem(masItem);
					storePoDetail.setQuantityOrdered(quantityArr[i]);
					storePoDetail.setDiscountPercent(discountArr[i]);
					storePoDetail.setDiscountAmount(discountAmountArr[i]);

					storePoDetail.setTaxPercent(taxArr[i]);
					storePoDetail.setTaxAmount(taxAmountArr[i]);
					storePoDetail.setAmount(amountArr[i]);

					if (manufacturerIdArr.get(i)!=null && !manufacturerIdArr.get(i).equals(""))
					{
						MasManufacturer masManufacturer = new MasManufacturer();
						masManufacturer.setId(Integer
								.parseInt(manufacturerIdArr.get(i).toString()));
						storePoDetail.setManufacturer(masManufacturer);
					}

					storePoDetail.setNotes("");
					
				//	storePoDetail.setQuantityReceived(null);
					if (brandIdArr.get(i)!=null && !brandIdArr.get(i).equals("")) {
						MasStoreBrand masStoreBrand = new MasStoreBrand();
						masStoreBrand.setId(Integer.parseInt(brandIdArr.get(i)
								.toString()));
						storePoDetail.setBrand(masStoreBrand);
					}
					if(patientIdArr[i]!=0)
					{
						storePoDetail.setPreId(patientIdArr[i]);
					}
					try {
						storePoDetail.setMrp(new BigDecimal(mrp.get(i).toString()));
					} catch (Exception e) {
						storePoDetail.setMrp(new BigDecimal(0));
					}

					storePoDetail.setLsoQty(actQuantityArr[i]);
					/*try {
						storePoDetail.setFreeQuantity(new BigDecimal(freeQtyArr
								.get(i).toString()));
					} catch (Exception e) {
						storePoDetail.setFreeQuantity(new BigDecimal("0"));
					}*/

					//storePoDetail.setTaxPerOQ(taxArr[i]);
						/*storePoDetail.setTaxAmtPerMdq(taxOqArr[i]);
					try {
						storePoDetail.setExciseDuty(exciseArr[i]);
					} catch (Exception e) {
						storePoDetail.setExciseDuty(new BigDecimal("0"));
					}*/

				//	storePoDetail.setTaxAmount(new BigDecimal("0"));

					storePoDetail.setUnitRate(unitRateArr[i]);

					/*if (freeItemArr.get(i).toString() != null) {
						storePoDetail
								.setFreeItem(freeItemArr.get(i).toString());
					}*/


					// add mdq, dispense type, rate per mdq

				storePoDetail.setDispType(dispenseType.get(i).toString());
				storePoDetail.setMdqValue(new BigDecimal(mdq.get(i).toString()));
				storePoDetail.setBrandedGeneric(BG.get(i).toString());
				/*try {
						storePoDetail.setRatePerMdq(new BigDecimal(ratePerMdq.get(i).toString()));
					} catch (Exception e) {
						storePoDetail.setRatePerMdq(new BigDecimal(0));
					}*/
					/*try {
						storePoDetail.setOtherTaxes(otherTaxes.get(i)
								.toString());
					} catch (Exception e) {
						storePoDetail.setOtherTaxes("");
					}
*/
					poDetailList.add(storePoDetail);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		infoMap.put("pageNo", pageNo);
		infoMap.put("poNumber", poNumber);
		infoMap.put("poId", poId);
		infoMap.put("storePoHeader", storePoHeader);
		infoMap.put("patientIdArr", patientIdArr);
		infoMap.put("poDetailList", poDetailList);
		infoMap.put("departmentId", departmentId);
		infoMap.put("quantityArr", quantityArr);
		infoMap.put("requestType", requestType);
		infoMap.put("hospitalId",hospitalId);
		dataMap.put("hospitalId",hospitalId);
		dataMap.put("deptId",departmentId);
		infoMap.put("noOfRecords",noOfRecords);

		dataMap.put("noOfRecords",noOfRecords);

		boolean flag = false;
		Map<String, Object> poMap = purchaseOrderHandlerService.submitPurchaseOrder(infoMap);
		// Map<String, Object> poMap = new HashMap<String, Object>();
		if (poMap.get("flag") != null) {
			flag = (Boolean) poMap.get("flag");
		}

		String messageTOBeVisibleToTheUser = "";
		String url = "";
		if (flag) {
			if (buttonFlag.equals("next")) {
				jsp = LOCAL_PURCHASE_JSP;
				messageTOBeVisibleToTheUser = "Supply Order has been done Successfully";
				map = purchaseOrderHandlerService
						.showPurchaseOrderJsp(dataMap);
				if (poMap.get("poId") != null) {
					poId = (Integer) poMap.get("poId");
				}
				List<StorePoHeader> poHeaderList = purchaseOrderHandlerService
						.getPoHeader(poId);
				map.put("poHeaderList", poHeaderList);
				pageNo = pageNo + 1;
				box.put("pageNo", pageNo);
				map.put("box", box);

			} else {
				url = "/hms/hms/purchaseOrder?method=showPurchaseOrderJsp";
				// jsp = STORES_MESSAGE_JSP;
				jsp = "localsupplyorderMessage";
				pageNo++;
				String Po_no = "";

				map.put("box", box);
				Po_no = box.getString(PO_NO);
				/*messageTOBeVisibleToTheUser = Po_no
						+ " Supply Order has been done Successfully.want to print Supply Order? ";*/

				messageTOBeVisibleToTheUser= "Supply Order "+Po_no+" saved successfully. ";
			}
		} else {
			//messageTOBeVisibleToTheUser = "Supply Order has not been done Successfully";
			messageTOBeVisibleToTheUser= "Supply Order not saved successfully. ";
			map.put("messageType", "failure");
		}

		url = "/hms/hms/purchaseOrder?method=showPurchaseOrderJsp";
		jsp += ".jsp";

		map.put("url", url);
		map.put("pageNo", pageNo);
		map.put("poNumber", poNumber);

		map.put("contentJsp", jsp);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView("index", "map", map);
	}

	// More Parameters of a PVMS/NIV Item that are Non-Mandatory Fields.

	public ModelAndView showMoreInfoPurchaseJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StorePoDetail> poDetailMoreInfoList = new ArrayList<StorePoDetail>();
		map = purchaseOrderHandlerService.getDetailsForMoreInfoPurchase();
		int rowNo = 0;
		int poDetailId = 0;

		if (request.getParameter("rowNo") != null) {
			rowNo = Integer.parseInt(request.getParameter("rowNo"));
		}
		if (request.getParameter("detailId") != null) {
			poDetailId = Integer.parseInt(request.getParameter("detailId"));
			poDetailMoreInfoList = purchaseOrderHandlerService
					.getPoDetailListForMoreInfoPurchase(poDetailId);
			map.put("poDetailMoreInfoList", poDetailMoreInfoList);
		}
		jsp = MORE_INFO_PURCHASE_JSP;
		title = "Supply Order";
		map.put("title", title);
		map.put("rowNo", rowNo);
		return new ModelAndView(jsp, "map", map);
	}

	// For Budget Status of a Local Purchase Order for a Particular Financial Year
	public ModelAndView showBudgetStatus(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreBudget> budgetStatusList = purchaseOrderHandlerService.getBudgetStatusList();
		jsp = BUDGET_STATUS_JSP;
		title = "Budget Status";
		map.put("budgetStatusList", budgetStatusList);
		return new ModelAndView(jsp, "map", map);
	}

	// Search For Local Purchase Order By PO No., Vendor Name, Between FromDate & To Date
	@SuppressWarnings("unchecked")
	public ModelAndView searchPO(HttpServletRequest request,HttpServletResponse response) throws IOException {

		String fromDate = "";
		String toDate = "";
		int supplierId = 0;
		int departmentId = 0;
		String includedJsp = "";
		int hospitalId=0;
		int poId = 0;
		String jsp = "poMain";
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		title = "View All P.O.";
		jsp += ".jsp";
		Map<String, Object> searchFieldMap = new HashMap<String, Object>();
		try {
			if (request.getParameter(FROM_DATE) != null) {
				fromDate = request.getParameter(FROM_DATE);
			}
			if (request.getParameter(TO_DATE) != null) {
				toDate = request.getParameter(TO_DATE);
			}
			if (request.getParameter(PO_ID) != null) {
				poId = Integer.parseInt(request.getParameter(PO_ID));
			}
			if (request.getParameter(SUPPLIER_ID) != null) {
				supplierId = Integer
						.parseInt(request.getParameter(SUPPLIER_ID));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> poMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();

		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		List<StorePoDetail> poDetailList = new ArrayList<StorePoDetail>();
		List<StorePoHeader> poHeaderList = new ArrayList<StorePoHeader>();

		searchFieldMap.put("fromDate", fromDate);
		searchFieldMap.put("toDate", toDate);
		searchFieldMap.put("poId", poId);
		searchFieldMap.put("supplierId", supplierId);
		searchFieldMap.put("departmentId", departmentId);
		searchFieldMap.put("hospitalId", hospitalId);

		poMap = (Map) purchaseOrderHandlerService.getViewAllMap(hospitalId);
		List<StorePoHeader> poNumberList = purchaseOrderHandlerService.getPoNumberList(deptId,hospitalId);
		supplierList = (List) poMap.get("supplierList");
		poDetailList = (List) poMap.get("poDetailList");
		poHeaderList = (List) poMap.get("poHeaderList");
		if (searchFieldMap.size() != 0) {
			map = purchaseOrderHandlerService.searchPO(searchFieldMap);
			includedJsp = "done";
		} else {
			//System.out.println("Enter value ");
		}

		map.put("poDetailList", poDetailList);
		map.put("poNumberList", poNumberList);
		map.put("supplierList", supplierList);
		map.put("poHeaderList", poHeaderList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("includedJsp", includedJsp);

		return new ModelAndView("index", "map", map);
	}

	// Modification of a Purchase Order on the basis of a particular search
	public ModelAndView poModifyJsp(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> purchaseMap = new HashMap<String, Object>();
		jsp = UPDATE_LOCAL_PURCHASE_JSP;
		jsp += ".jsp";
		int radio_str = 0;
		int hospitalId=0;
		int deptId = 0;
		int pageNo = 1;
		String buttonFlag = null;

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}

		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		if (request.getParameter("buttonFlag") != null) {
			buttonFlag = request.getParameter("buttonFlag");
		}
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}

		if (request.getParameter("ValueOfPage") != null) {
			pageNo = Integer.parseInt(request.getParameter("ValueOfPage"));
		}
		/*if (request.getParameter("parent") != null) {
			radio_str = Integer.parseInt(request.getParameter("parent"));
			map = (Map<String, Object>) purchaseOrderHandlerService
					.poModifyMap(radio_str, pageNo, buttonFlag);
		}*/

		dataMap.put("hospitalId", hospitalId);
		dataMap.put("deptId", deptId);

		int poDetailId=0;
		poDetailId = Integer.parseInt(request.getParameter(PO_DETAIL_ID));
		map = (Map<String, Object>) purchaseOrderHandlerService.poModifyMap(poDetailId, pageNo, buttonFlag);
		purchaseMap = purchaseOrderHandlerService.showPurchaseOrderJsp(dataMap);
		List<StorePoHeader> poNumberList = purchaseOrderHandlerService.getPoNumberList(deptId,hospitalId);
		map.put("purchaseMap", purchaseMap);
		map.put("pageNo", pageNo);
		map.put("poNumberList", poNumberList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("radio_str", radio_str);
		return new ModelAndView("index", "map", map);
	}

	// Updating the Purchase Order which already exists.
	@SuppressWarnings( { "deprecation", "unused", "unchecked" })
	public ModelAndView updatePurchaseOrder(HttpServletRequest request,HttpServletResponse response) throws ServletRequestBindingException {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		session = request.getSession();

		int supplierId = 0;
		String poNumber = "";
		String quotationNo = "";
		String remarks = "";
		String payTerms = "";
		Date poDate = new Date();
		Date quotationDate = new Date();
		Date deliveryDate = new Date();
		String signingAuthority = "";
		String appVide = "";

		String deliveryTerms = "";
		int pageNo = 1;
		int noOfRecords = 0;
		int poId = 0;
		String date = "";
		String time = "";
		String buttonFlag = "";
		String fileNo = "";
		int totalRecords = 0;
		int hospitalId=0;
		int departmentId = 0;
		int category=0;
		String telephoneNo="";
		String codehead="";
		String references="";



		BigDecimal totalAmount = new BigDecimal(0);

		String url = "";

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}

		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
		}


		String noDetailRecords = "";
		/** Represents */
		StorePoHeader storePoHeader = new StorePoHeader();
		if (request.getParameter(NO_DETAIL_RECORDS) != null) {
			noDetailRecords = (request.getParameter(NO_DETAIL_RECORDS));

		}
		if (request.getParameter("buttonFlag") != null) {
			buttonFlag = request.getParameter("buttonFlag");
		}
		if (request.getParameter("totalRecords") != null) {
			totalRecords = Integer.parseInt(request
					.getParameter("totalRecords"));
		}
		if (request.getParameter(PO_ID) != null) {
			poId = Integer.parseInt(request.getParameter(PO_ID));
		}
		if (request.getParameter(NO_OF_ROWS) != null) {
			noOfRecords = Integer.parseInt(request.getParameter(NO_OF_ROWS));
		}
		if (request.getParameter(PO_NO) != null) {
			poNumber = request.getParameter(PO_NO);
		}
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}

		if (request.getParameter(PO_DATE) != null) {
			poDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(PO_DATE));
		}
		if (!request.getParameter(SUPPLIER_ID).equals("0")) {
			supplierId = Integer.parseInt(request.getParameter(SUPPLIER_ID));
		}
		if (request.getParameter(QUOTATION_NO) != null) {
			quotationNo = request.getParameter(QUOTATION_NO);
		}
		if (request.getParameter(QUOTATION_DATE) != null) {
			quotationDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(QUOTATION_DATE));
		}
		if (request.getParameter(DELIVERY_DATE) != null) {
			deliveryDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DELIVERY_DATE));
		}
		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
		}

		if (request.getParameter("approval") != null) {
			appVide = request.getParameter("approval");
		}

		if (request.getParameter(PAY_TERMS) != null) {
			payTerms = request.getParameter(PAY_TERMS);
		}
		if (request.getParameter(DELIVERY_TERMS) != null) {
			deliveryTerms = request.getParameter(DELIVERY_TERMS);
		}
		if (request.getParameter(TOTAL_AMOUNT) != null) {
			totalAmount = new BigDecimal(request.getParameter(TOTAL_AMOUNT));
		}
		if (request.getParameter(FILE_NO) != null) {
			fileNo = request.getParameter(FILE_NO);
		}
		if(request.getParameter("category")!=null){
			category=Integer.parseInt(request.getParameter("category"));
		}
		if(request.getParameter("telephoneNo")!=null){

			telephoneNo=request.getParameter("telephoneNo");
		}
		if(request.getParameter("codehead")!=null){
			codehead=request.getParameter("codehead");
		}
		if(request.getParameter("references")!=null){
			references=request.getParameter("references");
		}

		signingAuthority = box.getString(LPO_SIGNING_AUTHORITY);

		/*
		 * Users user = (Users)session.getAttribute("users"); int userId =
		 * user.getId(); Users userObj = new Users(); userObj.setId(userId);
		 * storePoHeader.setLastChgBy(userObj);
		 */
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");

		String headerStored = "no";
		if (pageNo == 1) {
			storePoHeader.setId(poId);
			storePoHeader.setPoNumber(poNumber);
			storePoHeader.setPoDate(poDate);

			MasStoreSupplier supplier = new MasStoreSupplier();
			supplier.setId(supplierId);
			storePoHeader.setSupplier(supplier);

			MasHospital masHospital=new MasHospital();

			try
			{
				masHospital.setId(hospitalId);
				storePoHeader.setHospital(masHospital);
			}catch(Exception e)
			{

			}
			storePoHeader.setQuotationNumber(quotationNo);
			storePoHeader.setQuotationDate(quotationDate);
			storePoHeader.setRemarks(remarks);
			storePoHeader.setAppVide(appVide);
			storePoHeader.setPayTerms(payTerms);
			storePoHeader.setDeliveryTerms(deliveryTerms);
			storePoHeader.setSigningAuthority(signingAuthority);

			storePoHeader.setCategory(category+"");
			storePoHeader.setCodehead(codehead);
			storePoHeader.setTelephoneNo(telephoneNo);
			storePoHeader.setReferences(references);

			storePoHeader.setLastChgBy("Admin");
			storePoHeader.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			storePoHeader.setLastChgTime(time);
			storePoHeader.setStatus("o");
			storePoHeader.setDeliveryDate(deliveryDate);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			storePoHeader.setDepartment(masDepartment);

			storePoHeader.setNetAmount(totalAmount);
			storePoHeader.setPoTime(time);
			storePoHeader.setFileNo(fileNo);
			storePoHeader.setFlag("s");
			if (box.getInt("tender_id") != 0) {
				storePoHeader.setTenderM(new StoreTenderM(box
						.getInt("tender_id")));
			}
			if (box.getInt("group_id") != 0) {
				storePoHeader
						.setGroup(new MasStoreGroup(box.getInt("group_id")));
			}
		} else {
			headerStored = "yes";
			infoMap.put("headerStored", headerStored);
			infoMap.put("totalAmount", totalAmount);
			storePoHeader.setId(poId);
			storePoHeader.setPoNumber(poNumber);
			storePoHeader.setPoDate(poDate);

			MasStoreSupplier supplier = new MasStoreSupplier();
			supplier.setId(supplierId);
			storePoHeader.setSupplier(supplier);

			storePoHeader.setQuotationNumber(quotationNo);
			storePoHeader.setQuotationDate(quotationDate);
			storePoHeader.setRemarks(remarks);
			storePoHeader.setAppVide(appVide);
			storePoHeader.setPayTerms(payTerms);
			storePoHeader.setDeliveryTerms(deliveryTerms);
			storePoHeader.setSigningAuthority(signingAuthority);

			storePoHeader.setLastChgBy("Admin");
			storePoHeader.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			storePoHeader.setLastChgTime(time);
			storePoHeader.setStatus("o");
			storePoHeader.setDeliveryDate(deliveryDate);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			storePoHeader.setDepartment(masDepartment);

			storePoHeader.setNetAmount(totalAmount);
			storePoHeader.setPoTime(time);
			storePoHeader.setFileNo(fileNo);
			storePoHeader.setFlag("s");
			if (box.getInt("tender_id") != 0) {
				storePoHeader.setTenderM(new StoreTenderM(box
						.getInt("tender_id")));
			}
			if (box.getInt("group_id") != 0) {
				storePoHeader
						.setGroup(new MasStoreGroup(box.getInt("group_id")));
			}
		}
		int length = 0;

		BigDecimal[] quantityArr = new BigDecimal[200];
		BigDecimal[] actQquantityArr = new BigDecimal[200];
		BigDecimal[] taxArr = new BigDecimal[200];
	 	BigDecimal[] unitRateArr = new BigDecimal[200];
		BigDecimal[] discountArr = new BigDecimal[200];
		BigDecimal[] amountArr = new BigDecimal[200];
		BigDecimal[] discountAmountArr = new BigDecimal[200];
	//	BigDecimal[] exciseArr = new BigDecimal[200];
       BigDecimal[] taxOqArr = new BigDecimal[200];
       BigDecimal[] taxAmountArr = new BigDecimal[200];

		List<StorePoDetail> poDetailList = new ArrayList<StorePoDetail>();
		List<StorePoDetail> poDetailListAdd = new ArrayList<StorePoDetail>();

		int srNo[] = JKTRequestUtils.getRequiredIntParameters(request, SR_NO);
		int itemIdArr[] = JKTRequestUtils.getRequiredIntParameters(request,
				ITEM_ID);
		// int manufacturerIdArr[] =
		// JKTRequestUtils.getRequiredIntParameters(request,MANUFACTURER_ID);
		Vector manufacturerIdArr = box.getVector(MANUFACTURER_ID);
		// int brandIdArr[] =
		// JKTRequestUtils.getRequiredIntParameters(request,BRAND_ID);
		Vector brandIdArr = box.getVector(BRAND_ID);
		// String freeItemArr[] =
		// JKTRequestUtils.getRequiredStringParameters(request,FREE_ITEM);
		//Vector freeItemArr = box.getVector(FREE_ITEM);
	//	Vector freeQtyArr = box.getVector(FREE_QTY);

		length = srNo.length;

		String xx[] = JKTRequestUtils.getRequiredStringParameters(request,
				QUANTITY);
		int xxLen = xx.length;
		for (int i = 0; i < xxLen; i++) {
			BigDecimal val = new BigDecimal(xx[i]);
			quantityArr[i] = val;
		}
		String actQty[] = JKTRequestUtils.getRequiredStringParameters(request,ACTUAL_QTY);
		int actLen = actQty.length;
		for (int i = 0; i < actLen; i++) {
			BigDecimal val = new BigDecimal(actQty[i]);
			actQquantityArr[i] = val;
		}
		String yy[] = JKTRequestUtils.getRequiredStringParameters(request,TAX_PERCENT);
		int yyLen = yy.length;
		for (int i = 0; i < yyLen; i++) {
			BigDecimal val = new BigDecimal(yy[i]);
			taxArr[i] = val;
		}

		  String tt[] = JKTRequestUtils.getRequiredStringParameters(request,
				  COST_PRICE); int ttLen = tt.length;
		  for( int i = 0 ;i < ttLen ; i++) {
		  BigDecimal val = new BigDecimal(tt[i]); unitRateArr[i] = val; }

		String zz[] = JKTRequestUtils.getRequiredStringParameters(request,DISCOUNT_PERCENTAGE);
		int zzLen = zz.length;
		for (int i = 0; i < zzLen; i++) {
			BigDecimal val = new BigDecimal(zz[i]);
			discountArr[i] = val;
		}
		/*
		 * String pp[] = JKTRequestUtils.getRequiredStringParameters(request,
		 * FREE_QTY); int ppLen = pp.length; for( int i = 0 ;i < ppLen ; i++){
		 * BigDecimal val = new BigDecimal(pp[i]); freeQtyArr[i] = val; }
		 */
		String qq[] = JKTRequestUtils.getRequiredStringParameters(request,AMOUNT);
		int qqLen = qq.length;
		for (int i = 0; i < qqLen; i++) {
			BigDecimal val = new BigDecimal(qq[i]);
			amountArr[i] = val;
		}


		  String tax[] = JKTRequestUtils.getRequiredStringParameters(request, TAX_AMOUNT);
		  int taxLen = qq.length; for( int i = 0 ;i < taxLen; i++)
		  {
			  BigDecimal val = new BigDecimal(tax[i]);
			  taxAmountArr[i] =val;
		  }
		String dis[] = JKTRequestUtils.getRequiredStringParameters(request,
				DISCOUNT_AMOUNT);
		int disLen = qq.length;
		for (int i = 0; i < disLen; i++) {
         BigDecimal val = new BigDecimal(dis[i]);
			discountAmountArr[i] = val;
		}

		/*String ed[] = JKTRequestUtils.getRequiredStringParameters(request,
				"exciseDuty");
		int edLen = ed.length;
		for (int i = 0; i < edLen; i++) {
			BigDecimal val = new BigDecimal(ed[i]);
			exciseArr[i] = val;
		}

		String taxOq[] = JKTRequestUtils.getRequiredStringParameters(request,
				"taxOq");
		int taxOqLen = taxOq.length;
		for (int i = 0; i < taxOqLen; i++) {
			BigDecimal val = new BigDecimal(taxOq[i]);
			taxOqArr[i] = val;
		}*/
		// get mdq, dispense type, rate per mdq

		Vector mdq = box.getVector("mdq");
		Vector dispenseType = box.getVector("dipenseType");
		Vector ratePerMdq = box.getVector("ratePerMdq");
		Vector mrp = box.getVector("mrp");
		Vector otherTaxes = box.getVector("otherTaxes");

		if (noDetailRecords.equals("no")) {
			int idArrayLength = 0;
			int idArray[] = null;
			if (request.getParameter(DETAIL_ID) != null) {
				idArray = JKTRequestUtils.getRequiredIntParameters(request,
						DETAIL_ID);
				idArrayLength = idArray.length;
			}
			for (int i = 0; i < length; i++) {
				if (idArrayLength > 0) { // if any records in storePoDetails
					StorePoDetail storePoDetail = new StorePoDetail();
					storePoDetail.setId(idArray[i]);
					storePoDetail.setSerialNo(srNo[i]);

					MasStoreItem masItem = new MasStoreItem();
					masItem.setId(itemIdArr[i]);
					storePoDetail.setItem(masItem);

					storePoDetail.setQuantityOrdered(quantityArr[i]);
					storePoDetail.setLsoQty(actQquantityArr[i]);

					/*try {
						storePoDetail.setFreeQuantity(new BigDecimal(freeQtyArr
								.get(i).toString()));
					} catch (Exception e) {
						storePoDetail.setFreeQuantity(new BigDecimal("0"));
					}*/

					/*if (freeItemArr.get(i).toString() != null) {
						storePoDetail
								.setFreeItem(freeItemArr.get(i).toString());
					}
*/
					if (!manufacturerIdArr.get(i).equals("")) {
						MasManufacturer masManufacturer = new MasManufacturer();
						masManufacturer.setId(Integer
								.parseInt(manufacturerIdArr.get(i).toString()));
						storePoDetail.setManufacturer(masManufacturer);
					}

					if (!brandIdArr.get(i).equals("")) {
						MasStoreBrand masStoreBrand = new MasStoreBrand();
						masStoreBrand.setId(Integer.parseInt(brandIdArr.get(i)
								.toString()));
						storePoDetail.setBrand(masStoreBrand);
					}
					storePoDetail.setDispType(dispenseType.get(i).toString());
					storePoDetail.setMdqValue(new BigDecimal(mdq.get(i).toString()));


					/*storePoDetail.setTaxAmtPerMdq(taxOqArr[i]);
					storePoDetail.setTaxPerOQ(taxArr[i]);
					storePoDetail.setExciseDuty(exciseArr[i]);*/

					storePoDetail.setTaxPercent(taxArr[i]);
					storePoDetail.setTaxAmount(taxAmountArr[i]);
					storePoDetail.setDiscountAmount(discountAmountArr[i]);
					storePoDetail.setDiscountPercent(discountArr[i]);
					storePoDetail.setAmount(amountArr[i]);

					storePoDetail.setUnitRate(unitRateArr[i]);


					StorePoHeader po = new StorePoHeader();
					po.setId(poId);
					storePoDetail.setPo(po);

					storePoDetail.setNotes("");
					storePoDetail.setQuantityReceived(null);

					// mdq, dispense type, rate per mdq
					/*storePoDetail.setDispType(dispenseType.get(i).toString());
					storePoDetail.setMdqValue(new BigDecimal(mdq.get(i)
							.toString()));
					try {
						storePoDetail.setRatePerMdq(new BigDecimal(ratePerMdq
								.get(i).toString()));
					} catch (Exception e) {
						storePoDetail.setRatePerMdq(new BigDecimal(0));
					}*/
					try {
						storePoDetail.setMrp(new BigDecimal(mrp.get(i)
								.toString()));
					} catch (Exception e) {
						storePoDetail.setMrp(new BigDecimal(0));
					}
					storePoDetail.setOtherTaxes("");

					poDetailList.add(storePoDetail);

					idArrayLength--;
				} else {
					if (itemIdArr[i] != 0) { // grid records
						StorePoDetail storePoDetailAdd = new StorePoDetail();
						// storePoDetailAdd.setId(idArray[i]);
						storePoDetailAdd.setSerialNo(srNo[i]);

						MasStoreItem masItem = new MasStoreItem();
						masItem.setId(itemIdArr[i]);
						storePoDetailAdd.setItem(masItem);

						storePoDetailAdd.setQuantityOrdered(quantityArr[i]);
						storePoDetailAdd.setLsoQty(actQquantityArr[i]);

					/*	try {
							storePoDetailAdd.setFreeQuantity(new BigDecimal(
									freeQtyArr.get(i).toString()));
						} catch (Exception e) {
							storePoDetailAdd
									.setFreeQuantity(new BigDecimal("0"));
						}*/
						/*if (freeItemArr.get(i).toString() != null) {
							storePoDetailAdd.setFreeItem(freeItemArr.get(i)
									.toString());
						}*/

						if (!manufacturerIdArr.get(i).equals("")) {
							MasManufacturer masManufacturer = new MasManufacturer();
							masManufacturer.setId(Integer
									.parseInt(manufacturerIdArr.get(i)
											.toString()));
							storePoDetailAdd.setManufacturer(masManufacturer);
						}

						if (!brandIdArr.get(i).equals("")) {
							MasStoreBrand masStoreBrand = new MasStoreBrand();
							masStoreBrand.setId(Integer.parseInt(brandIdArr
									.get(i).toString()));
							storePoDetailAdd.setBrand(masStoreBrand);
						}


						storePoDetailAdd.setTaxAmtPerMdq(taxOqArr[i]);
						storePoDetailAdd.setTaxPerOQ(taxArr[i]);
						//storePoDetailAdd.setExciseDuty(exciseArr[i]);
						storePoDetailAdd.setAmount(amountArr[i]);
						storePoDetailAdd.setUnitRate(unitRateArr[i]);
						storePoDetailAdd.setDiscountPercent(discountArr[i]);
						storePoDetailAdd.setDiscountAmount(discountAmountArr[i]);
						storePoDetailAdd.setTaxPercent(taxArr[i]);
						storePoDetailAdd.setTaxAmount(taxAmountArr[i]);

						// mdq, dispense type, rate per mdq
						storePoDetailAdd.setDispType(dispenseType.get(i)
								.toString());
						storePoDetailAdd.setMdqValue(new BigDecimal(mdq.get(i)
								.toString()));
						try {
							storePoDetailAdd.setRatePerMdq(new BigDecimal(
									ratePerMdq.get(i).toString()));
						} catch (Exception e) {
							storePoDetailAdd.setRatePerMdq(new BigDecimal(0));
						}

						StorePoHeader po = new StorePoHeader();
						po.setId(poId);
						storePoDetailAdd.setPo(po);

						storePoDetailAdd.setNotes("");
						storePoDetailAdd.setQuantityReceived(null);

						try {
							storePoDetailAdd.setMrp(new BigDecimal(mrp.get(i)
									.toString()));
						} catch (Exception e) {
							storePoDetailAdd.setMrp(new BigDecimal(0));
						}


						//storePoDetailAdd.setOtherTaxes("");

						poDetailListAdd.add(storePoDetailAdd);
					}
				}

			}

		} else if (noDetailRecords.equals("yes")) { // next page grid records
			length = srNo.length;
			for (int i = 0; i < length; i++) {
				StorePoDetail storePoDetailAdd = new StorePoDetail();
				// storePoDetailAdd.setId(idArray[i]);
				storePoDetailAdd.setSerialNo(srNo[i]);

				MasStoreItem masItem = new MasStoreItem();
				masItem.setId(itemIdArr[i]);
				storePoDetailAdd.setItem(masItem);

				storePoDetailAdd.setQuantityOrdered(quantityArr[i]);
				/*storePoDetailAdd.setLsoQty(actQquantityArr[i]);
				try {
					storePoDetailAdd.setFreeQuantity(new BigDecimal(freeQtyArr
							.get(i).toString()));
				} catch (Exception e) {
					storePoDetailAdd.setFreeQuantity(new BigDecimal("0"));
				}

				if (freeItemArr.get(i).toString() != null) {
					storePoDetailAdd.setFreeItem(freeItemArr.get(i).toString());
				}
*/
				if (!manufacturerIdArr.get(i).equals("")) {
					MasManufacturer masManufacturer = new MasManufacturer();
					masManufacturer.setId(Integer.parseInt(manufacturerIdArr
							.get(i).toString()));
					storePoDetailAdd.setManufacturer(masManufacturer);
				}

				if (!brandIdArr.get(i).equals("")) {
					MasStoreBrand masStoreBrand = new MasStoreBrand();
					masStoreBrand.setId(Integer.parseInt(brandIdArr.get(i)
							.toString()));
					storePoDetailAdd.setBrand(masStoreBrand);
				}

				storePoDetailAdd.setTaxPercent(new BigDecimal("0"));
				/*storePoDetailAdd.setTaxAmtPerMdq(taxOqArr[i]);
				storePoDetailAdd.setTaxPerOQ(taxArr[i]);
				storePoDetailAdd.setExciseDuty(exciseArr[i]);*/
				storePoDetailAdd.setAmount(amountArr[i]);
				storePoDetailAdd.setUnitRate(unitRateArr[i]);
				storePoDetailAdd.setDiscountPercent(discountArr[i]);

				storePoDetailAdd.setTaxAmount(new BigDecimal("0"));
				storePoDetailAdd.setDiscountAmount(discountAmountArr[i]);
				StorePoHeader po = new StorePoHeader();
				po.setId(poId);
				storePoDetailAdd.setPo(po);

				storePoDetailAdd.setNotes("");
				storePoDetailAdd.setQuantityReceived(null);

				try {
					storePoDetailAdd.setRatePerMdq(new BigDecimal(ratePerMdq
							.get(i).toString()));
				} catch (Exception e) {
					storePoDetailAdd.setRatePerMdq(new BigDecimal(0));
				}

				// mdq, dispense type, rate per mdq
				storePoDetailAdd.setDispType(dispenseType.get(i).toString());
				storePoDetailAdd.setMdqValue(new BigDecimal(mdq.get(i).toString()));

				try {
					storePoDetailAdd.setMrp(new BigDecimal(mrp.get(i)
							.toString()));
				} catch (Exception e) {
					storePoDetailAdd.setMrp(new BigDecimal(0));
				}

				storePoDetailAdd.setOtherTaxes("");

				poDetailListAdd.add(storePoDetailAdd);

			}
		}
		infoMap.put("pageNo", pageNo);
		infoMap.put("poNumber", poNumber);
		infoMap.put("poId", poId);

		infoMap.put("storePoHeader", storePoHeader);
		infoMap.put("poDetailList", poDetailList);
		infoMap.put("poDetailListAdd", poDetailListAdd);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("deptId", departmentId);

		boolean flag = purchaseOrderHandlerService.updatePurchaseOrder(infoMap);

		String messageTOBeVisibleToTheUser = "";

		if (flag) {
			if (infoMap.get("poId") != null) {
				poId = (Integer) infoMap.get("poId");
				map = (Map<String, Object>) purchaseOrderHandlerService.poModifyMap(poId, pageNo, buttonFlag);
				map.put("poId", poId);
			}
			poDetailList = (List<StorePoDetail>) map.get("poDetailList");
			if (poDetailList.size() == 0) {
				noDetailRecords = "yes";
			}
			if ((poDetailList.size() != 0) || (buttonFlag.equals("next"))) {
				jsp = UPDATE_LOCAL_PURCHASE_JSP;
			}
			if (!(buttonFlag.equals("next"))) {
				jsp = STORES_MESSAGE_JSP;
				messageTOBeVisibleToTheUser = "Supply Order has been updated Successfully";
			}
			pageNo++;
		} else {
			jsp = STORES_MESSAGE_JSP;
			messageTOBeVisibleToTheUser = "Supply Order has not been updated Successfully";
			map.put("messageType", "failure");
			url = "/hms/hms/purchase?method=showPurchaseOrderJsp";
		}
		jsp += ".jsp";
		Map<String, Object> purchaseMap = purchaseOrderHandlerService
				.showPurchaseOrderJsp(dataMap);

		url = "/hms/hms/purchaseOrder?method=showPurchaseOrderJsp";

		map.put("url", url);
		map.put("poId", poId);
		map.put("purchaseMap", purchaseMap);
		map.put("pageNo", pageNo);
		map.put("poNumber", poNumber);
		map.put("noDetailRecords", noDetailRecords);

		map.put("contentJsp", jsp);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView("index", "map", map);
	}

	// Checking & Updating the Approval Authorities for Local Purchase Order.
	@SuppressWarnings("unused")
	public ModelAndView showApprovalAuthority(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();

		List<MasAuthorizer> authorityList = purchaseOrderHandlerService
				.getApprovalAuthoritiesList();

		title = "Approval Authority";
		jsp = APPROVAL_AUTHORITY_JSP;
		String[] checkId = null;
		int poId = 0;

		if (request.getParameter("poId") != null) {
			poId = Integer.parseInt(request.getParameter("poId"));
		}
		if (request.getParameterValues("checkId") != null) {
			checkId = request.getParameterValues("checkId");
		}

		map.put("poId", poId);
		map.put("authorityList", authorityList);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView(jsp, "map", map);
	}

	// Updating the Approval Authorities for Local Purchase Order.
	public ModelAndView submitApprovalAuthority(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();

		title = "Approval Authority";
		int counter = 0;
		int poId = 0;
		String approvalId = "";

		if (request.getParameter(PO_ID) != null) {
			poId = Integer.parseInt(request.getParameter(PO_ID));
		}
		if (request.getParameter("counter") != null) {
			counter = Integer.parseInt(request.getParameter("counter"));
		}

		StringBuffer approvalIds = new StringBuffer();
		for (int i = 0; i < counter; i++) {
			if (request.getParameter("id" + i) != null) {
				approvalId = request.getParameter("id" + i);
				approvalIds.append(approvalId + ",");
			}
		}

		boolean flag = false;
		if (approvalIds.length() != 0) {
			approvalIds.deleteCharAt(approvalIds.length() - 1);
			flag = purchaseOrderHandlerService.submitApprovalAuthority(
					approvalIds.toString(), poId);
		} else {
			flag = purchaseOrderHandlerService
					.submitApprovalAuthority("", poId);
		}

		String messageTOBeVisibleToTheUser = "";
		String url = "";
		if (flag == true) {
			messageTOBeVisibleToTheUser = "Approval Authorities has been submitted successfully.";
		} else {
			messageTOBeVisibleToTheUser = "Please First Select Any SO No.";
		}

		jsp = "messageForPurchase";
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("title", title);

		return new ModelAndView(jsp, "map", map);
	}

	// For selecting a PO Number For the Local Po Format Report.
	public ModelAndView showLocalPoFormatJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		title = "Local PO Format";
		session = request.getSession();

		int deptId = 0;
		int hospitalId=0;

		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}

		List<StorePoHeader> poNumberList = purchaseOrderHandlerService
				.getPoNumberList(deptId,hospitalId);
		jsp = LOCAL_PO_FORMAT_JSP;
		jsp = jsp + ".jsp";
		map.put("poNumberList", poNumberList);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView(jsp, "map", map);
	}

	// Generate a Local PO Format report on the basis PO Number.
	public ModelAndView generateLocalPoFormatReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String poNo = null;
		session = request.getSession();
		requestParameters.put(HOSPITAL_ID, session.getAttribute("hospitalId"));
		try {
			if (request.getParameter(PO_NO) != null
					&& !(request.getParameter(PO_NO).equals(""))) {
				poNo = request.getParameter(PO_NO);
				requestParameters.put("poNo", poNo);
			}
			// requestParameters.put(", 123);

		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = purchaseOrderHandlerService
				.getConnectionForReport();
		byte[] bytes = null;

		try {
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport(LOCAL_PO_FORMAT_REPORT),
					requestParameters, (Connection) connectionMap.get("con"));
		} catch (JRException e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment; filename="
				+ LOCAL_PO_FORMAT_REPORT + ".pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ModelAndView("index", "map", map);
	}

	// Method used for Jasper Report of Local Po Format.
	private JasperReport getCompiledReport(String fileName) throws JRException {

		File reportFile = new File(getServletContext().getRealPath(
				"/reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile.getPath());

		return jasperReport;
	}

	public ModelAndView showPORegisterReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		title = "PO Register Report";
		//List<MasStoreSupplier> supplierList = purchaseOrderHandlerService.getSupplierList();
		jsp = PO_REGISTER_REPORT_JSP;

	//	map.put("supplierList", supplierList);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generatePORegisterReport(HttpServletRequest request,
			HttpServletResponse response) {


		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String fileName = null;

		session = request.getSession();
		requestParameters.put(HOSPITAL_ID, session.getAttribute("hospitalId"));
		Date fromDate = null;
		Date toDate = null;
		String vendorName = "";
		int hospitalId = 0;
		String hospitalName = "";
		session = request.getSession();
		String query = "";
		requestParameters.put("hospitalId", session.getAttribute("hospitalId"));
		requestParameters.put("deptId", session.getAttribute("deptId"));

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			/*if (request.getParameter(VENDOR_NAME) != null
					&& !(request.getParameter(VENDOR_NAME).equals(""))) {
				vendorName = request.getParameter(VENDOR_NAME);
				requestParameters.put("supplierId", Integer
						.parseInt(vendorName));
			}
			if (!vendorName.equals("") && !vendorName.equals("0")) {
				query = query + "and a.supplier_id = '" + vendorName + "'";
			}*/
			if (query.length() > 0) {
				requestParameters.put("query", query);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		requestParameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		Map<String, Object> connectionMap = purchaseOrderHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport(LPO_REGISTER_REPORT, requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return null;
	}

	@SuppressWarnings( { "unused", "unchecked" })
	public ModelAndView generateABCAnalysisReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		List<StoreSetup> classList = new ArrayList<StoreSetup>();
		String fileName = null;
		String vendorName = "";
		int hospitalId = 0;
		String hospitalName = "";
		String fromDate="";
		String toDate="";
		session = request.getSession();
		requestParameters.put(HOSPITAL_ID, session.getAttribute("hospitalId"));

		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			/*fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));*/
			fromDate= request.getParameter(FROM_DATE);
			requestParameters.put("fromDate", fromDate);
		}
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			/*toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));*/
			toDate=request.getParameter(TO_DATE);
			requestParameters.put("toDate", toDate);
		}

		Map<String, Object> classMap = purchaseOrderHandlerService
				.getStoreSetUpDetails();
		if (classMap.get("classList") != null) {
			classList = (List<StoreSetup>) classMap.get("classList");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			hospitalName = purchaseOrderHandlerService
					.getHospitalName(hospitalId);
			requestParameters.put("hospitalName", hospitalName);
		}
		float costPriceForAClass = 0.0f;
		float costPriceForBClass = 0.0f;
		for (StoreSetup storeSetup : classList) {
			costPriceForAClass = storeSetup.getAClass();
			costPriceForBClass = storeSetup.getBClass();
		}
		float costPrice = 50000f;
		Map<String, Object> costMap = new HashMap<String, Object>();
		costMap.put("costPriceForAClass", costPriceForAClass);
		costMap.put("costPriceForBClass", costPriceForBClass);

		requestParameters.put("costPriceForAClass", costPriceForAClass);
		requestParameters.put("costPriceForBClass", costPriceForBClass);

		Map<String, Object> stockMap = purchaseOrderHandlerService
				.getStockDetails(costMap);
		Map<String, Object> connectionMap = purchaseOrderHandlerService
				.getConnectionForReport();
		Float sumOfStock = null;

		if (stockMap.get("sumOfStock") != null) {
			sumOfStock = (Float) stockMap.get("sumOfStock");
		}
		requestParameters.put("sumOfStock", sumOfStock);
		//if(true){
			Map<String, Object> abcItem = purchaseOrderHandlerService.getAbcItem(requestParameters);
			String flag=(String)request.getParameter("flag");
			if(flag!=null && flag.equalsIgnoreCase("j")){
			map.put("abcItem", abcItem);
			jsp="ABCJspReport";
			jsp=jsp+".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("indexB","map", map);
			}else{
				map.put("abcItem", abcItem);
				jsp="ABCJspReportExcel";
				//jsp=jsp+".jsp";
				map.put("contentJsp", jsp);
				return new ModelAndView(jsp,"map", map);
			}

		//}
		/*HMSUtil.generateReport(ABC_ANALYSIS_FINAL_REPORT, requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		System.out.println("After generating the report......");
		return new ModelAndView("index", "map", map);*/

	}

	public ModelAndView showDrugExpiryReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		title = "Drug Expiry Report";

		jsp = DRUG_EXPIRY_REPORT_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateDrugExpiryReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = purchaseOrderHandlerService.getConnectionForReport();
		String fromDate = "";
		int hospitalId = 0;
		int deptId = 0;
		String hospitalName = "";
		session = request.getSession();
		if (request.getParameter(FROM_DATE) != null	&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = request.getParameter(FROM_DATE);
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			map.put("hospitalId", hospitalId);
			hospitalName = purchaseOrderHandlerService.getHospitalName(hospitalId);
			map.put("hospitalName", hospitalName);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			
		}
		map.put("deptId", deptId);
		java.util.Date fromDate1=HMSUtil.convertStringTypeDateToDateType(fromDate);

		map.put("fromDate",fromDate1);

		Calendar cal = Calendar.getInstance();
		cal.setTime(fromDate1);
		int month = cal.get(Calendar.MONTH)+1;
		
		int year = cal.get(Calendar.YEAR);
		
		
		map.put("from_Date", fromDate);
		map.put("month", month);
		map.put("year", year);
		String flag = (String)request.getParameter("flag");
		if(flag.equalsIgnoreCase("j")){
		 Map<String, Object> expiryDrug =purchaseOrderHandlerService.getExpiryDrug(map);
		    map.put("expiryDrug", expiryDrug);
			String jsp="expiryDrugJspReport.jsp";
			map.put("contentJsp", jsp);
		return new ModelAndView("indexB","map", map);

		}else{
		HMSUtil.generateReport("Drug_Expiry_Report", map, (Connection) map.get("con"), response, getServletContext());
		// return new ModelAndView("index", "map", map);
		return null;
		}
	}

	public ModelAndView showPaymentTerms(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		title = "Payment Terms";

		List<MasStorePoDeliveryTerms> paymentDetailsList = purchaseOrderHandlerService
				.getPaymentDetails();

		jsp = PO_PAYMENT_TERMS_JSP;

		map.put("paymentDetailsList", paymentDetailsList);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showDeliveryTerms(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		title = "Delivery Terms";
		List<MasStorePoDeliveryTerms> deliveryDetailsList = purchaseOrderHandlerService
				.getDeliveryDetails();
		jsp = PO_DELIVERY_TERMS_JSP;

		map.put("deliveryDetailsList", deliveryDetailsList);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getItemListForPurchaseOrder(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----

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

		// --------------------------------------------------------------------------------
		String itemNameField = "";
		String autoHint = "";
		int poId = 0;

		Map<String, Object> dataMap1 = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			if (request.getParameter("poId") != null) {
				poId = Integer.parseInt("" + (request.getParameter("poId")));
			}
			List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
			dataMap1.put("autoHint", autoHint);
			dataMap1.put("deptId", deptId);
			dataMap1.put("userName", userName);
			dataMap1.put("hospitalId", hospitalId);
			dataMap1.put("poId", poId);
			map1 = purchaseOrderHandlerService.getItemListForPurchaseOrderMR(dataMap1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "result";
		return new ModelAndView(jsp, "map", map1);
	}
	
	public ModelAndView getItemListForPurchaseOrderForRC(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----

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

		// --------------------------------------------------------------------------------
		String itemNameField = "";
		String autoHint = "";
		int poId = 0;

		Map<String, Object> dataMap = new HashMap<String, Object>();
		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			if (request.getParameter("poId") != null) {
				poId = Integer.parseInt("" + (request.getParameter("poId")));
			}
			List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
			dataMap.put("autoHint", autoHint);
			dataMap.put("deptId", deptId);
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("poId", poId);
			map = purchaseOrderHandlerService.getItemListForPurchaseOrderForRC(dataMap);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "result";
		return new ModelAndView(jsp, "map", map);
	}
	
	/*
	 * public ModelAndView displayPaymentTerms(HttpServletRequest request,
	 * HttpServletResponse response){
	 * //System.out.println("PurchaseOrderController.displayPaymentTerms()");
	 * Map<String, Object> map = new HashMap<String, Object>();
	 *
	 * title = "Delivery Terms"; List<MasStorePoDeliveryTerms>
	 * deliveryDetailsList = purchaseOrderHandlerService.getDeliveryDetails();
	 * jsp = PO_PAYMENT_TERMS_JSP;
	 *
	 * int counter = 0; int poDeliveryTermId = 0;
	 *
	 * if(request.getParameter("counter") != null){ counter =
	 * Integer.parseInt(request.getParameter("counter")); }
	 * //System.out.println("counter-------"+counter); for (int i = 0; i <
	 * counter; i++) { if(request.getParameter("id"+i) != null){
	 * poDeliveryTermId = Integer.parseInt(request.getParameter("id"+i)); } }
	 * //System.out.println("poDeliveryTermsId-------"+poDeliveryTermId);
	 * List<MasStorePoDeliveryTerms> poDeliveryDescList =
	 * purchaseOrderHandlerService
	 * .getDescriptionForDeliveryTermId(poDeliveryTermId);
	 * //System.out.println("Size Back in CON----"+poDeliveryDescList.size());
	 *
	 * map.put("poDeliveryDescList", poDeliveryDescList);
	 *
	 * String desc = ""; if(request.getParameter(PO_DELIVERY_TERMS_DESC) !=
	 * null){ desc = request.getParameter(PO_DELIVERY_TERMS_DESC); }
	 * //map.put("deliveryDetailsList", deliveryDetailsList);
	 * map.put("contentJsp",jsp); map.put("title", title);
	 *
	 * return new ModelAndView(jsp,"map", map); }
	 *
	 * public ModelAndView displayDeliveryTerms(HttpServletRequest request,
	 * HttpServletResponse response){ Map<String, Object> map = new
	 * HashMap<String, Object>();
	 *
	 * title = "Delivery Terms"; List<MasStorePoDeliveryTerms>
	 * deliveryDetailsList = purchaseOrderHandlerService.getDeliveryDetails();
	 * jsp = PO_DELIVERY_TERMS_JSP; int counter = 0; int poDeliveryTermId = 0;
	 *
	 * if(request.getParameter("counter") != null){ counter =
	 * Integer.parseInt(request.getParameter("counter")); }
	 * //System.out.println("counter-------"+counter); for (int i = 0; i <
	 * counter; i++) { if(request.getParameter("id"+i) != null){
	 * poDeliveryTermId = Integer.parseInt(request.getParameter("id"+i)); } }
	 * //System.out.println("poDeliveryTermsId-------"+poDeliveryTermId);
	 * List<MasStorePoDeliveryTerms> poDeliveryDescList =
	 * purchaseOrderHandlerService
	 * .getDescriptionForDeliveryTermId(poDeliveryTermId);
	 * //System.out.println("Size Back in CON----"+poDeliveryDescList.size());
	 * map.put("poDeliveryDescList", poDeliveryDescList);
	 * //map.put("deliveryDetailsList", deliveryDetailsList);
	 * map.put("contentJsp",jsp); map.put("title", title);
	 *
	 * return new ModelAndView(jsp,"map", map); }
	 */

	/*
	 * public ModelAndView poViewAllJsp(HttpServletRequest request,
	 * HttpServletResponse response){
	 *
	 * Map<String, Object> map = new HashMap<String, Object>(); jsp =
	 * PO_VIEW_ALL_JSP; map=(Map)purchaseOrderHandlerService.getViewAllMap();
	 *
	 * title = "View All P.O."; map.put("contentJsp",jsp); map.put("title",
	 * title);
	 *
	 * return new ModelAndView(jsp,"map", map); } public ModelAndView
	 * poCreateJsp(HttpServletRequest request, HttpServletResponse response) {
	 *
	 * Map<String, Object> map = new HashMap<String, Object>();
	 * map=purchaseOrderHandlerService.showPurchaseOrderJsp(); //jsp =
	 * PO_CREATE_JSP; title = "PurchaseOrder"; map.put("contentJsp",jsp);
	 * map.put("title", title);
	 *
	 * return new ModelAndView(jsp,"map", map); }
	 *
	 * public ModelAndView poModifyJsp(HttpServletRequest request,
	 * HttpServletResponse response){
	 *
	 * Map<String, Object> map = new HashMap<String, Object>(); jsp =
	 * PO_MODIFY_JSP; jsp += ".jsp"; String radio_str=""; if
	 * (request.getParameter("parent") != null) { radio_str =
	 * request.getParameter("parent");
	 * map=(Map)purchaseOrderHandlerService.poModifyMap(radio_str); }
	 *
	 * //System.out.println("radio_str     map "+map.size());
	 * //System.out.println(" radio_str          ="+radio_str);
	 * map.put("contentJsp",jsp); map.put("title", title);
	 * map.put("radio_str",radio_str);
	 *
	 *
	 * //System.out.println("This is Po Modify-------------------- 2"); return new
	 * ModelAndView("index","map", map); }
	 *
	 *
	 * private String getTextFromFile(String filePath) { // Opens a text file
	 * and returns the text from it. StringBuffer contents = new StringBuffer();
	 *
	 * BufferedReader reader = null; try { reader = new BufferedReader(new
	 * FileReader(filePath)); String line = null; while ((line =
	 * reader.readLine()) != null){ contents.append(line);
	 * contents.append(System.getProperty("line.separator")); } } catch
	 * (FileNotFoundException ex1) {
	 * System.err.println("Invalid file path :"+ex1); } catch (IOException ex2){
	 * System.err.println("cannot read from the file :"+ex2); } finally { try {
	 * reader.close(); } catch (IOException ex3) {
	 * System.err.println("cannot close the file :"+ex3); } } return
	 * contents.toString(); }
	 *
	 *
	 * @SuppressWarnings("unchecked") public ModelAndView
	 * searchPO(HttpServletRequest request, HttpServletResponse response) throws
	 * IOException{
	 *
	 *
	 * //System.out.println("This is   poViewAllJsp-----------------------------");
	 *
	 * @SuppressWarnings("unused") String fromDate="";
	 *
	 * @SuppressWarnings("unused") String toDate="";
	 *
	 * @SuppressWarnings("unused") int supplierId=0; int departmentId=0; String
	 * includedJsp=""; int poNo=0;
	 *
	 * @SuppressWarnings("unused") String storeCode="";
	 *
	 * @SuppressWarnings("unused") String jsp="poMain";
	 *
	 * title = "View All P.O."; jsp += ".jsp"; Map<String,
	 * Object>searchFieldMap= new HashMap<String, Object>(); try{ if
	 * (request.getParameter(FROM_DATE) != null) { fromDate =
	 * request.getParameter(FROM_DATE);
	 * //System.out.println(" fromDate          ="+fromDate);
	 *
	 * } if (request.getParameter(TO_DATE) != null) { toDate =
	 * request.getParameter(TO_DATE);
	 * //System.out.println(" toDate          ="+toDate);
	 *
	 * } if (request.getParameter(PO_NO) != null) { poNo =Integer.parseInt(
	 * request.getParameter(PO_NO));
	 * //System.out.println(" poNo          ="+poNo);
	 *
	 * } if (request.getParameter(STORE_SUPPLIER_ID) != null) { supplierId
	 * =Integer.parseInt( request.getParameter(STORE_SUPPLIER_ID));
	 * //System.out.println(" supplierId          ="+supplierId);
	 *
	 * } }catch (Exception e) { //System.out.println("ex p in c "+e); }
	 * Map<String, Object>poMap= new HashMap<String, Object>(); Map<String,
	 * Object> map = new HashMap<String, Object>();
	 *
	 * @SuppressWarnings("unused") Map<String, Object>tempMap= new
	 * HashMap<String, Object>();
	 *
	 * List<MasStoreSupplier> supplierList= new ArrayList<MasStoreSupplier>();
	 * List<PoDetail> poDetailList = new ArrayList<PoDetail>(); List<PoHeader>
	 * poHeaderList = new ArrayList<PoHeader>();
	 *
	 * searchFieldMap.put("fromDate",fromDate);
	 * searchFieldMap.put("toDate",toDate); searchFieldMap.put("poNo",poNo);
	 * searchFieldMap.put("supplierId",supplierId);
	 * searchFieldMap.put("departmentId",departmentId);
	 *
	 *
	 * poMap=(Map)purchaseOrderHandlerService.getViewAllMap();
	 *
	 * supplierList=(List)poMap.get("supplierList");
	 * poDetailList=(List)poMap.get("poDetailList");
	 * poHeaderList=(List)poMap.get("poHeaderList");
	 *
	 *
	 * //System.out.println("searchFieldMap.size()           "+searchFieldMap.size(
	 * )); try{ if(searchFieldMap.size()!=0){
	 * map=purchaseOrderHandlerService.searchPO(searchFieldMap);
	 * //System.out.println("poMap  "+map.size()); includedJsp="done"; } else{
	 * //System.out.println("Enter value "); }
	 *
	 * }catch (Exception e) {
	 * //System.out.println("11111111111111111111111         "+e); }
	 * map.put("poDetailList", poDetailList); map.put("supplierList",
	 * supplierList); map.put("poHeaderList", poHeaderList);
	 * map.put("contentJsp",jsp); map.put("title", title);
	 * map.put("includedJsp", includedJsp);
	 *
	 * return new ModelAndView("index","map", map);
	 *
	 *
	 *
	 * } public ModelAndView addPurchaseOrder(HttpServletRequest request,
	 * HttpServletResponse response) { //System.out.println("in add po method");
	 * Map<String, Object> map = new HashMap<String, Object>(); StorePoHeader
	 * poHeader= new StorePoHeader(); StorePoDetail poDetail = new
	 * StorePoDetail(); int storeId=0; int supplierId=0; String poNumber="";
	 * String poReferenceNo=""; String remarks=""; String payTerms=""; String
	 * poTime=""; Date poDate = new Date(); String deliveryDate = ""; int
	 * itemId=0; String notes=""; String indentQty=""; String quantity="";
	 * String freeQty=""; String rate=""; String discount=""; String amount="";
	 * int salesTypeId=0; BigDecimal quantityOrdered=null; Date currentDate =
	 * new Date(); String changedBy = "";
	 *
	 *
	 * Map<String, Object> listMap=new HashMap<String, Object>(); Map<String,
	 * Object> generalMap = new HashMap<String, Object>();
	 *
	 *
	 * if (request.getParameter(DEPARTMENT_ID) != null) { storeId =
	 * Integer.valueOf(request.getParameter(DEPARTMENT_ID));
	 *
	 * } if (request.getParameter(STORE_SUPPLIER_ID) != null) { supplierId =
	 * Integer.valueOf(request.getParameter(STORE_SUPPLIER_ID)); } if
	 * (request.getParameter(ITEM_ID) != null) { itemId =
	 * Integer.valueOf(request.getParameter(ITEM_ID)); } if
	 * (request.getParameter(PO_NO) != null) { poNumber =
	 * request.getParameter(PO_NO); }
	 *
	 * if (request.getParameter(PO_DATE) != null) { poDate=
	 * HMSUtil.dateFormatterDDMMYYYY(request.getParameter(PO_DATE));
	 *
	 * }
	 *
	 * if (request.getParameter(PO_REFERENCE_NO) != null) { poReferenceNo=
	 * request.getParameter(PO_REFERENCE_NO);
	 *
	 * }
	 *
	 * if (request.getParameter(DELIVERY_DATE) != null) { deliveryDate=
	 * request.getParameter(DELIVERY_DATE);
	 *
	 * } if (request.getParameter(REMARKS) != null) { remarks=
	 * request.getParameter(REMARKS);
	 *
	 * } if (request.getParameter(PAY_TERMS) != null) { payTerms=
	 * request.getParameter(PAY_TERMS);
	 *
	 * }
	 *
	 * if (request.getParameter(PO_TIME) != null) { poTime=
	 * request.getParameter(PO_TIME);
	 *
	 * } if (request.getParameter(NOTES) != null) { notes=
	 * request.getParameter(NOTES);
	 *
	 * }
	 *
	 *
	 * if (request.getParameter(INDENT_QTY) != null) { indentQty=
	 * request.getParameter(INDENT_QTY); }
	 *
	 * if (request.getParameter(FREE_QTY) != null) { freeQty=
	 * request.getParameter(FREE_QTY); }
	 *
	 * if (request.getParameter(RATE) != null) { rate=
	 * request.getParameter(RATE); }
	 *
	 * if (request.getParameter(DISCOUNT) != null) { discount=
	 * request.getParameter(DISCOUNT); } if (request.getParameter(AMOUNT) !=
	 * null) { amount= request.getParameter(AMOUNT); }
	 *
	 * if (request.getParameter(SALES_TYPE_ID) != null) { salesTypeId=
	 * Integer.valueOf(request.getParameter(SALES_TYPE_ID)); }
	 *
	 * if(request.getParameter(CHANGED_BY) != null &&
	 * !(request.getParameter(CHANGED_BY).equals(""))){ changedBy =
	 * request.getParameter(CHANGED_BY);
	 *
	 * } if(request.getParameter(CHANGED_DATE) != null &&
	 * !(request.getParameter(CHANGED_DATE).equals(""))){ currentDate =
	 * HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE)); }
	 * if(request.getParameter(CHANGED_TIME) != null &&
	 * !(request.getParameter(CHANGED_TIME).equals(""))){ currentTime =
	 * request.getParameter(CHANGED_TIME);
	 * //System.out.println("currentTime____________"+currentTime); }
	 *
	 * if(request.getParameter(QUANTITY_ORDERED)!=null &&
	 * !(request.getParameter(QUANTITY_ORDERED).equals(""))){
	 * quantityOrdered=BigDecimal
	 * .valueOf(Double.parseDouble(request.getParameter(QUANTITY_ORDERED)));
	 *
	 * } if(request.getParameter(QUANTITY)!=null &&
	 * !(request.getParameter(QUANTITY).equals(""))){
	 * quantity=request.getParameter(QUANTITY); }
	 * if(request.getParameter("pojoName") != null){ pojoName =
	 * request.getParameter("pojoName");
	 *
	 * } if(request.getParameter("pojoPropertyName") != null){ pojoPropertyName
	 * = request.getParameter("pojoPropertyName");
	 *
	 * } if(request.getParameter("pojoPropertyCode") != null){ pojoPropertyCode
	 * = request.getParameter("pojoPropertyCode");
	 *
	 * } generalMap.put("poNumber", poNumber); generalMap.put("poDate", poDate);
	 * generalMap.put("poReferenceNo", poReferenceNo);
	 * generalMap.put("deliveryDate", deliveryDate); generalMap.put("remarks",
	 * remarks); generalMap.put("payTerms", payTerms); generalMap.put("poTime",
	 * poTime); generalMap.put("notes", notes); //generalMap.put("quantity",
	 * quantity); generalMap.put("indentQty", indentQty);
	 * generalMap.put("freeQty", freeQty); generalMap.put("rate", rate);
	 * generalMap.put("discount", discount); generalMap.put("amount", amount);
	 * generalMap.put("currentDate", currentDate); generalMap.put("currentTime",
	 * currentTime); generalMap.put("pojoName", pojoName);
	 * generalMap.put("quantityOrdered",quantityOrdered);
	 *
	 *
	 * boolean successfullyAdded = false; //poHeader.setPoNumber(poNumber);
	 * poHeader.setPoDate(poDate); poHeader.setPoTime(poTime);
	 * //poHeader.setReferenceNumber(poReferenceNo);
	 * poHeader.setDeliveryDate(deliveryDate); poHeader.setRemarks(remarks);
	 * poHeader.setPayTerms(payTerms); poHeader.setStatus("y");
	 * poHeader.setLastChgBy("admin"); poHeader.setLastChgDate(currentDate);
	 * poHeader.setLastChgTime(currentTime); poDetail.setNotes(notes);
	 * ////System.out.println("notes----------"+notes);
	 * poDetail.setQuantityOrdered(quantityOrdered);
	 *
	 * MasDepartment masDepartment = new MasDepartment();
	 * masDepartment.setId(storeId); poHeader.setDepartment(masDepartment);
	 *
	 * MasStoreSupplier masSupplier = new MasStoreSupplier();
	 * masSupplier.setId(supplierId); poHeader.setSupplier(masSupplier);
	 *
	 * MasStoreItem masItem = new MasStoreItem(); masItem.setId(itemId);
	 * poDetail.setItem(masItem);
	 *
	 * successfullyAdded =
	 * purchaseOrderHandlerService.addPurchaseOrder(poHeader,poDetail);
	 * if(successfullyAdded) { message="Record Added Successfully"; } else {
	 * message="Try Again !"; } //jsp = PO_CREATE_JSP; title = "Purchase Order";
	 * map.put("contentJsp",jsp); map.put("title", title); return new
	 * ModelAndView(jsp,"map", map); }
	 */

	// -------------------------------------Prints by
	// Mansi--------------------------------------

	public ModelAndView printLocalPoFormatJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String poNo = null;
		session = request.getSession();
		/*
		 * int departmentId = 0; if(session.getAttribute("deptId") != null){
		 * departmentId = (Integer)session.getAttribute("deptId"); }
		 */
		requestParameters.put("DEPT", session.getAttribute("deptId"));

		try {
			if (request.getParameter(PO_NO) != null
					&& !(request.getParameter(PO_NO).equals(""))) {
				poNo = request.getParameter(PO_NO);
				requestParameters.put("po_number", poNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = purchaseOrderHandlerService
				.getConnectionForReport();
		byte[] bytes = null;

		try {
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport(LOCAL_SUPPLY_ORDER_PRINT),
					requestParameters, (Connection) connectionMap.get("con"));
		} catch (JRException e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment; filename="
				+ LOCAL_SUPPLY_ORDER_PRINT + ".pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printLocalSupplyOrder(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> searchFieldMap = new HashMap<String, Object>();
		int deptId = 0;
		map = purchaseOrderHandlerService.getConnectionForReport();
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		searchFieldMap.put("poId", box.getInt("po_id"));
		int po_id = 0;
		if (box.get("po_id") != null && !box.get("po_id").equals("")) {
			po_id = box.getInt("po_id");
		}
		String po_number = "";
		if (po_id != 0) {

			po_number = purchaseOrderHandlerService.getPoNumber(po_id);
		}

		if (po_id != 0) {
			map.put("po_number", po_number);
			box.put(PO_NO, po_number);
		} else {
			map.put("po_number", box.getString(PO_NO));
		}
		int hospitalId=0;
		String hospitalName=null;
		String hospitalAddress=null;
		if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
			hospitalName = purchaseOrderHandlerService.getHospitalName(hospitalId);
			hospitalAddress = purchaseOrderHandlerService.getHospitalAddress(hospitalId);

		}
		map.put("hospitalId",hospitalId);
		map.put("DEPT", deptId);
		map.put("HOSP_NAME", hospitalName);
		map.put("HOSP_ADD", hospitalAddress);
		// map.put("po_number", box.getString(PO_NO));
	if(box.getString(PO_NO) != null && !box.getString(PO_NO).equals(""))
	{
	//	if(deptId == 24){
		//HMSUtil.generateReport("LocalSupplyOrderPrintForStores", map, (Connection)map.get("con"), response, getServletContext());
		HMSUtil.generateReport("Supply_order", map, (Connection)map.get("con"), response, getServletContext());
		//}else{
		//	HMSUtil.generateReport("LocalSupplyOrderPrintForStoresEchs", map, (Connection)map.get("con"), response, getServletContext());
		//}
	}
		return null;
	}

	public ModelAndView deletePurchaseOrderItem(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> purchaseMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> deleteMap = new HashMap<String, Object>();
		int radio_str = 0;
		int hospitalId=0;
		int deptId = 0;
		int pageNo = 1;
		String buttonFlag = null;
		deleteMap = purchaseOrderHandlerService.deletePurchaseOrderItem(box);

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}


		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		if (request.getParameter("buttonFlag") != null) {
			buttonFlag = request.getParameter("buttonFlag");
		}
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}

		if (request.getParameter("ValueOfPage") != null) {
			pageNo = Integer.parseInt(request.getParameter("ValueOfPage")) - 1;
		}
		if (request.getParameter("parent") != null) {
			radio_str = Integer.parseInt(request.getParameter("parent"));
			map = (Map<String, Object>) purchaseOrderHandlerService
					.poModifyMap(radio_str, pageNo, buttonFlag);
		}

		dataMap.put("hospitalId",hospitalId);
		dataMap.put("deptId",deptId);
		purchaseMap = purchaseOrderHandlerService.showPurchaseOrderJsp(dataMap);
		List<StorePoHeader> poNumberList = purchaseOrderHandlerService.getPoNumberList(deptId,hospitalId);

		map.put("purchaseMap", purchaseMap);
		map.put("pageNo", pageNo);
		map.put("poNumberList", poNumberList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("radio_str", radio_str);

		return new ModelAndView("index", "map", map);

		// map = purchaseOrderHandlerService.getConnectionForReport();

	}

	public ModelAndView cancelLSO(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		// List<StoreSetup> list = (List)map.get("storeSetupList");
		int hospitalId=0;
		int deptId = 0;
		String msg = "";
		boolean cancel = purchaseOrderHandlerService.cancelLso(box);

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}


		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		if (cancel) {
			msg = "Local SupplyOrder has been canceled successfully.";
		}

		dataMap.put("hospitalId",hospitalId);
		dataMap.put("deptId",deptId);
		map = purchaseOrderHandlerService.showPurchaseOrderJsp(dataMap);

		List<StorePoHeader> poNumberList = purchaseOrderHandlerService.getPoNumberList(deptId,hospitalId);

		jsp = LOCAL_PURCHASE_JSP;
		jsp = jsp + ".jsp";
		String previousPage = "no";
		title = "Supply Order";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("poNumberList", poNumberList);
		map.put("previousPage", previousPage);
		map.put("DEPT", deptId);
		map.put("msg", msg);
		return new ModelAndView("index", "map", map);
	}

	public void getCurVendorSoAmount(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreTenderProposal> sTPList = new ArrayList<StoreTenderProposal>();
		@SuppressWarnings("unused")
		List objectList = new ArrayList();
		int vendorId = 0;
		String soDate = null;
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if (request.getParameter("vendorId") != null) {
			vendorId = Integer.parseInt("" + request.getParameter("vendorId"));
		}

		if (request.getParameter("soDate") != null) {
			soDate = request.getParameter("soDate");
		}

		dataMap.put("vendorId", vendorId);
		dataMap.put("soDate", soDate);
		dataMap.put("deptId", deptId);

		try {
			if (vendorId != 0) {
				map = purchaseOrderHandlerService.getCurVendorSoAmount(dataMap);
			}
			BigDecimal rem = (BigDecimal) map.get("remain");

			StringBuffer sb = new StringBuffer();
			sb.append("<remain>");
			if (rem != null) {
				sb.append("<rem>" + rem + "</rem>");
			} else {
				sb.append("<rem>" + 0 + "</rem>");
			}
			sb.append("</remain>");
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

	public ModelAndView budgetReport(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = 0;
		String msg = "";
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		jsp = "budgetReport";
		jsp = jsp + ".jsp";
		title = "Budget Report";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getDetailForBudget(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = 0;
		String msg = "";
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		box.put("deptId", deptId);
		map = purchaseOrderHandlerService.getBudgetDetails(box);
		jsp = "subbudgetReport";
		title = "Budget Report";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView pendingLATList(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = 0;
		String msg = "";
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		box.put("deptId", deptId);
		map = purchaseOrderHandlerService.getpendingLATList(box);
		jsp = "pendingLATList";
		jsp = jsp + ".jsp";
		title = "Pending LAT";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView pendingSOCRVList(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = 0;
		String msg = "";
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		box.put("deptId", deptId);
		map = purchaseOrderHandlerService.pendingSOCRVList(box);
		jsp = "pendingSOCRVList";
		jsp = jsp + ".jsp";
		title = "Pending LAT";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showCloseCancelSOScreen(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "closeCancelSO.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB","map",map);
	}

	public ModelAndView getSupplyOrderNoAutocomplete(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session =request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		box.put("deptId", deptId);
		map = purchaseOrderHandlerService.getSupplyOrderNoAutocomplete(box);
		String jsp = "responseForSONumber";
		return new ModelAndView(jsp,"map",map);
	}

	public ModelAndView getSODetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session =request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		box.put("deptId", deptId);
		map = purchaseOrderHandlerService.getSODetails(box);
		String jsp = "responseForSODetails";
		return new ModelAndView(jsp,"map",map);
	}

	public ModelAndView closePOItem(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = purchaseOrderHandlerService.closePOItem(box);
		boolean flag = false;
		if(map.get("flag") != null){
			flag = (Boolean)map.get("flag");
		}
		String message = "";
		if(flag){
			message = "SO has been Closed.";
		}else{
			message = "Try Again!";
		}
		map.put("message", message);
		String jsp = "closeCancelSO.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB","map",map);
	}

	public ModelAndView cancelPOItem(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		boolean flag = false;
		flag = purchaseOrderHandlerService.cancelLso(box);

		String message = "";
		if(flag){
			message = "SO has been Cancelled.";
		}else{
			message = "Try Again!";
		}
		map.put("message", message);
		String jsp = "closeCancelSO.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB","map",map);
	}
	//ashutosh singh


	public ModelAndView generateExcelForVendor(HttpServletRequest request,HttpServletResponse response)
	   {
			Map<String, Object> requestParameters = new HashMap<String, Object>();
			int hospitalId = 0;
			int deptId = 0;
			Box box = HMSUtil.getBox(request);
			String hospitalName = "";
			String deptName = "";
			String query = "";
			String po_id="";
			List<MasStoreSupplier> supplierList=null;

			session = request.getSession();
			try {

				if (session.getAttribute("hospitalId") != null) {
					hospitalId = (Integer) session.getAttribute("hospitalId");
					hospitalName = purchaseOrderHandlerService.getHospitalName(hospitalId);
					requestParameters.put("hospitalName", hospitalName);
					requestParameters.put("hospitalId",hospitalId);
				}

				if (session.getAttribute("deptId") != null) {
					deptId = (Integer) session.getAttribute("deptId");
					requestParameters.put("deptId", deptId);
				}

				if (session.getAttribute("deptName") != null) {
					deptName = session.getAttribute("deptName").toString();
					requestParameters.put("deptName", deptName);
				}
			/*	if ((request.getParameter("sectionId") != null && (!request.getParameter("sectionId").equals("")))) {
					query =query +  "AND mas_store_section.section_id = '"
							+ request.getParameter("sectionId") + "' ";
				}

				if (request.getParameter("sectionId") != null &&(request.getParameter("pvmsNiv") != null && (!request.getParameter("pvmsNiv").equals("")))) {
					query = query + "AND mas_store_item.pvms_no = '"
							+ request.getParameter("pvmsNiv") + "' ";
				}*/
				if(request.getParameter("exl_po")!=null ){

					po_id=request.getParameter("exl_po");
				}

			/*	if ((request.getParameter("sectionId").equals(""))
					&&(request.getParameter("pvmsNiv") != null && (!request.getParameter("pvmsNiv").equals(""))))
				{
					query =query +"and mas_store_item.pvms_no = '"
											+ request.getParameter("pvmsNiv") + "' ";
				}*/
				requestParameters.put("query", query);
				requestParameters.put("po_id", po_id);
			}catch (Exception e)
			{
				e.printStackTrace();
			}

			HSSFWorkbook wb = new HSSFWorkbook();
			HttpSession session = request.getSession(true);

			try {

					map = purchaseOrderHandlerService.generateExcelToVendor(requestParameters);
				if(map.get("supplierList")!=null){
					supplierList=(List<MasStoreSupplier>) map.get("supplierList");
				}
				if(map.get("wb") != null){
					MasStoreSupplier mss=(MasStoreSupplier)supplierList.get(0);
					String SupplierName=mss.getSupplierName();
				wb = (HSSFWorkbook) map.get("wb");
				DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
				Date date = new Date();

				String strDateFormat = "hh:mm:ss a";
				SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
				String jk=sdf.format(date);
				String preDate=dateFormat.format(date);
				String xyz[]=preDate.split(" ");
				String abc[]=jk.split(":");
				String abcd=abc[0]+"-"+abc[1]+"-"+abc[2];
				String rgv[]=abc[2].split(" ");
				abc[2]=rgv[0]+rgv[1];
				preDate=xyz[0]+"-"+abc[0]+"."+abc[1]+"."+abc[2];
				String SupFirstName[]=SupplierName.split(" ");
				String file = "ExcelForVendor"+"_"+SupFirstName[0]+preDate+".xls";
				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-disposition", "attachment; filename="+ file);
				wb.write(response.getOutputStream());
				}
				}catch (IOException ioe) {
					ioe.printStackTrace();
			}
			return null;
		}
	
	
	
	
	
	
	public ModelAndView generateExcelForVendorSearch(HttpServletRequest request,HttpServletResponse response)
	   {
			Map<String, Object> requestParameters = new HashMap<String, Object>();
			int hospitalId = 0;
			int deptId = 0;
			Box box = HMSUtil.getBox(request);
			String hospitalName = "";
			String deptName = "";
			String query = "";
			String po_id="";
			List<MasStoreSupplier> supplierList=null;

			session = request.getSession();
			try {

				if (session.getAttribute("hospitalId") != null) {
					hospitalId = (Integer) session.getAttribute("hospitalId");
					hospitalName = purchaseOrderHandlerService.getHospitalName(hospitalId);
					requestParameters.put("hospitalName", hospitalName);
					requestParameters.put("hospitalId",hospitalId);
				}

				if (session.getAttribute("deptId") != null) {
					deptId = (Integer) session.getAttribute("deptId");
					requestParameters.put("deptId", deptId);
				}

				if (session.getAttribute("deptName") != null) {
					deptName = session.getAttribute("deptName").toString();
					requestParameters.put("deptName", deptName);
				}
			/*	if ((request.getParameter("sectionId") != null && (!request.getParameter("sectionId").equals("")))) {
					query =query +  "AND mas_store_section.section_id = '"
							+ request.getParameter("sectionId") + "' ";
				}

				if (request.getParameter("sectionId") != null &&(request.getParameter("pvmsNiv") != null && (!request.getParameter("pvmsNiv").equals("")))) {
					query = query + "AND mas_store_item.pvms_no = '"
							+ request.getParameter("pvmsNiv") + "' ";
				}*/
				if(request.getParameter("exl_po")!=null ){

					po_id=request.getParameter("exl_po");
				}

			/*	if ((request.getParameter("sectionId").equals(""))
					&&(request.getParameter("pvmsNiv") != null && (!request.getParameter("pvmsNiv").equals(""))))
				{
					query =query +"and mas_store_item.pvms_no = '"
											+ request.getParameter("pvmsNiv") + "' ";
				}*/
				requestParameters.put("query", query);
				requestParameters.put("po_id", po_id);
			}catch (Exception e)
			{
				e.printStackTrace();
			}

			HSSFWorkbook wb = new HSSFWorkbook();
			HttpSession session = request.getSession(true);

			try {

					//map = purchaseOrderHandlerService.generateExcelToVendor(requestParameters);
					
					map = purchaseOrderHandlerService.generateExcelToVendorSearch(requestParameters);
					
				if(map.get("supplierList")!=null){
					supplierList=(List<MasStoreSupplier>) map.get("supplierList");
				}
				if(map.get("wb") != null){
					MasStoreSupplier mss=(MasStoreSupplier)supplierList.get(0);
					String SupplierName=mss.getSupplierName();
				wb = (HSSFWorkbook) map.get("wb");
				DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
				Date date = new Date();

				String strDateFormat = "hh:mm:ss a";
				SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
				String jk=sdf.format(date);
				String preDate=dateFormat.format(date);
				String xyz[]=preDate.split(" ");
				String abc[]=jk.split(":");
				String abcd=abc[0]+"-"+abc[1]+"-"+abc[2];
				String rgv[]=abc[2].split(" ");
				abc[2]=rgv[0]+rgv[1];
				preDate=xyz[0]+"-"+abc[0]+"."+abc[1]+"."+abc[2];
				String SupFirstName[]=SupplierName.split(" ");
				String file = "ExcelForVendor"+"_"+SupFirstName[0]+preDate+".xls";
				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-disposition", "attachment; filename="+ file);
				wb.write(response.getOutputStream());
				}
				}catch (IOException ioe) {
					ioe.printStackTrace();
			}
			return null;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public PurchaseOrderHandlerService getPurchaseOrderHandlerService() {
		return purchaseOrderHandlerService;
	}

	public void setPurchaseOrderHandlerService(
			PurchaseOrderHandlerService purchaseOrderHandlerService) {
		this.purchaseOrderHandlerService = purchaseOrderHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(CommonMasterHandlerService commonMasterHandlerService)
	{
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	//ashutosh singh
	public ModelAndView showPurchaseOrderwithLPItemJsp(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int hospitalId=0;
		int deptId = 0;
		String requestType="";
		int rowLength=0;
		List ItemList = new ArrayList();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}

		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if(request.getParameter("requestType")!=null){
			requestType=request.getParameter("requestType");
		}
		if(request.getParameter("rowLenghtName")!=null){
			rowLength=Integer.parseInt(request.getParameter("rowLenghtName"));
		}

		try {
			int itemIdArr[] = JKTRequestUtils.getRequiredIntParameters(request,	ITEMS_TO_BE_ADDED);
			for(int i=0;i<itemIdArr.length;i++){
				ItemList.add(itemIdArr[i]);
			}

		} catch (ServletRequestBindingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dataMap.put("hospitalId",hospitalId);
		dataMap.put("deptId",deptId);

		map = purchaseOrderHandlerService.showPurchaseOrderJsp(dataMap);

		List<StorePoHeader>poNumberList = purchaseOrderHandlerService.getPoNumberList(deptId,hospitalId);
		List<MasStoreItem>itemList=purchaseOrderHandlerService.getLpItemList(ItemList);
		jsp = LOCAL_PURCHASE_LP_JSP;
		jsp = jsp + ".jsp";
		title = "Supply Order";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("requestType",requestType);
		String previousPage = "no";
		map.put("poNumberList", poNumberList);
		map.put("previousPage", previousPage);
		map.put("itemList",itemList);
		return new ModelAndView("index", "map", map);
	}

	// javed khan

	public ModelAndView generatePreProformaBReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> result=new HashMap<String, Object>();
		String po ="";
		String HOSP_NAME = "";
		String HOSP_ADD="";
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			HOSP_NAME = purchaseOrderHandlerService.getHospitalName(hospitalId);

			HOSP_ADD = purchaseOrderHandlerService.getHospitalAddress(hospitalId);


		}

		if (request.getParameter(PO_NO) != null
				&& !(request.getParameter(PO_NO).equals(""))) {
			po = request.getParameter(PO_NO);

		}

		//requestParameters = storesHandlerService.getProformaPrintMap(grnId);
		//requestParameters.put("grnId", grnId);

		// javed khan
		result=purchaseOrderHandlerService.getResultValue(po,hospitalId);
		 double BudgetAmt=new Double(result.get("BudgetAmt").toString());
		 double nivItem=new Double(result.get("nivItem").toString());
		 double pvmsItem=new Double(result.get("pvmsItem").toString());
		 double BrandItem=new Double(result.get("BrandItem").toString());
		 double genericItem=new Double(result.get("genericItem").toString());
		 double amtValueBrand=new Double(result.get("amtValueBrand").toString());
		 double disValueBrand=new Double(result.get("disValueBrand").toString());
		 double amtValueGen=new Double(result.get("amtValueGen").toString());
		 double disValueGen=new Double(result.get("disValueGen").toString());

		 requestParameters=purchaseOrderHandlerService.getConnectionForReport();

		byte[] bytes = null;
		/*try {

			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport("PROFORMA_B_LP"), requestParameters,
					(Connection) requestParameters.get("conn"));
		} catch (JRException e) {
			//System.out.println("e    " + e);
			e.printStackTrace();
		}
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();;
		}

		return new ModelAndView("indexB", "map", map);*/
		//String reportName = "PRE_PROFORMA_B_LP";
		String reportName = "PRE_PROFORMA_B_LP_NEW";
		requestParameters.put("poNo",po);
		// javed khan

		//String SUBREPORT_DIR="C:\\Documents and Settings\\javed.khan\\Desktop\\";
		requestParameters.put("HOSP_NAME", HOSP_NAME);
		requestParameters.put("HOSP_ADD", HOSP_ADD);
		requestParameters.put("BudgetAmt",BudgetAmt);
		requestParameters.put("nivItem",nivItem);
		requestParameters.put("pvmsItem",pvmsItem);
		requestParameters.put("BrandItem",BrandItem);
		requestParameters.put("genericItem",genericItem);
		requestParameters.put("amtValueBrand",amtValueBrand);
		requestParameters.put("disValueBrand",disValueBrand);
		requestParameters.put("amtValueGen",amtValueGen);
		requestParameters.put("disValueGen",disValueGen);
		requestParameters.put("hospitalId",hospitalId);

		//requestParameters.put("SUBREPORT_DIR",SUBREPORT_DIR);
		requestParameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
		"/reports/"));
		HMSUtil.generateReport(reportName, requestParameters,
				(Connection) requestParameters.get("con"), response,
				getServletContext());

		return null;
	}

	public ModelAndView showLPApprovalJsp(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int deptId = 0;
		int hospitalId=0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		//map = purchaseOrderHandlerService.showPurchaseOrderJsp(deptId);   comment By Tirath For hospitalId

		dataMap.put("hospitalId", hospitalId);
		dataMap.put("deptId",deptId);


		map = purchaseOrderHandlerService.showLPApprovalJsp(dataMap);
		jsp = "local_purchase_approval";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getSoDetailsForApproval(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int deptId = 0;
		int hospitalId=0;
		session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}

		box.put("hospitalId", hospitalId);
		box.put("deptId",deptId);
		map = purchaseOrderHandlerService.getSoDetailsForApproval(box);
		jsp = "responseForSOApproval";
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView approvePurchaseOrder(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int deptId = 0;
		int hospitalId=0;
		session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		box.put("empName", (String)session.getAttribute("empName"));
		box.put("hospitalId", hospitalId);
		box.put("deptId",deptId);
		map = purchaseOrderHandlerService.approvePurchaseOrder(box);
		boolean flag = false;
		if(map.get("flag")!=null){
			flag = (Boolean)map.get("flag");
		}
		String message = "";
		if(flag){
			message = "Supply Order  ' "+map.get("PONO")+" '  approved.";   // add by javed khan on 21-10-2013
			map.put("messageType", "success");

		}else{
			message = "Some problem occured. Try Again.";
			map.put("messageType", "failure");
		}
		map.put("messageTOBeVisibleToTheUser", message);
		map.put("box", box);
		jsp = "localsupplyorderMessage.jsp";
		map.put("flag", "approval");
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public void deletePoDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		
		map = purchaseOrderHandlerService.deletePoDetails(box);
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			if ((Boolean)map.get("flag") == true) {
				sb.append("<message>" + "Record Deleted" + "</message>");
			} else {
				sb.append("<message>" + 0 + "</message>");
			}
			sb.append("</item>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");

			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ModelAndView getItemListForPurchaseOrderForFAC(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----

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

		// --------------------------------------------------------------------------------
		String itemNameField = "";
		String autoHint = "";
		int poId = 0;

		Map<String, Object> dataMap1 = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			if (request.getParameter("poId") != null) {
				poId = Integer.parseInt("" + (request.getParameter("poId")));
			}
			List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
			dataMap1.put("autoHint", autoHint);
			dataMap1.put("deptId", deptId);
			dataMap1.put("userName", userName);
			dataMap1.put("hospitalId", hospitalId);
			dataMap1.put("poId", poId);
			map1 = purchaseOrderHandlerService.getItemListForPurchaseOrderForFAC(dataMap1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "result";
		return new ModelAndView(jsp, "map", map1);
	}
}
