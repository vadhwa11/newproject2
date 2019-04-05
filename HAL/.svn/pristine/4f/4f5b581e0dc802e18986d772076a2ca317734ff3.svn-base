package jkt.hms.stores.controller;

import static jkt.hms.util.RequestConstants.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasManufacturer;
import jkt.hms.masters.business.MasStoreAirForceDepot;
import jkt.hms.masters.business.MasStoreBrand;
import jkt.hms.masters.business.MasStoreGroup;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreMeScale;
import jkt.hms.masters.business.MasStoreSection;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.StoreAmcM;
import jkt.hms.masters.business.StoreAmcT;
import jkt.hms.masters.business.StoreBosM;
import jkt.hms.masters.business.StoreGrnM;
import jkt.hms.masters.business.StoreGrnT;
import jkt.hms.masters.business.StoreIndentM;
import jkt.hms.masters.business.StoreIndentT;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.StoreLoaninM;
import jkt.hms.masters.business.StoreLoaninT;
import jkt.hms.masters.business.StorePoDetail;
import jkt.hms.masters.business.StorePoHeader;
import jkt.hms.masters.business.StoreRepairCivilFirm;
import jkt.hms.masters.business.StoreTenderM;
import jkt.hms.masters.business.StoreWorkOrderM;
import jkt.hms.masters.business.StoreWorkOrderT;
import jkt.hms.stores.handler.NonExpendableStoresHandlerService;
import jkt.hms.stores.handler.StoresHandlerService;
import jkt.hms.masters.business.MasRepairStation;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.JKTRequestUtils;
import jkt.hms.util.RequestConstants;
import jkt.hms.util.typeConversion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
public class NonExpendableStoresController extends MultiActionController {

	StoresHandlerService storesHandlerService = null;
	NonExpendableStoresHandlerService nonExpendableStoresHandlerService = null;
	HttpSession session = null;
	Map<String, Object> map = new HashMap<String, Object>();
	String jsp = "";
	String title = "";

	// GRN jsp for non expendable items
	public ModelAndView showNeGrnJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = nonExpendableStoresHandlerService.showNeGrnJsp(box, dataMap);
		//jsp = NE_GRN_JSP;
		jsp=NON_EXPENDABLE_GRN_JSP;
		jsp = jsp + ".jsp";
		title = "GRN";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showNeGrnJsp1(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = nonExpendableStoresHandlerService.showNeGrnJsp(box, dataMap);
		jsp = NE_GRN_JSP;
		//jsp=NON_EXPENDABLE_GRN_JSP;
		jsp = jsp + ".jsp";
		title = "GRN";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	// More Parameters of a PVMS/NIV Item that are Non-Mandatory Fields.
	public ModelAndView showInfoOfNeGrnJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreGrnT> storeGrnTMoreInfoList = new ArrayList<StoreGrnT>();
		map = storesHandlerService.getDetailsForMoreInfoGrn();
		int rowNo = 0;
		int storeGrnTId = 0;

		if (request.getParameter("rowNo") != null) {
			rowNo = Integer.parseInt(request.getParameter("rowNo"));
		}
		if (request.getParameter("detailId") != null) {
			storeGrnTId = Integer.parseInt(request.getParameter("detailId"));
			storeGrnTMoreInfoList = nonExpendableStoresHandlerService
					.getStoreGrnTListForMoreInfo(storeGrnTId);
			map.put("storeGrnTMoreInfoList", storeGrnTMoreInfoList);
		}
		jsp = MORE_INFO_NE_GRN_JSP;
		title = "GRN";
		map.put("title", title);
		map.put("rowNo", rowNo);
		return new ModelAndView(jsp, "map", map);
	}

	// For adding Grn
	public ModelAndView submitGrn(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("SubmitGrnNonExpandableStore------>>>1111");
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		StoreGrnM storeGrnM = new StoreGrnM();
		StoreGrnT storeGrnT = new StoreGrnT();
		StoreItemBatchStock storeItemBatchStock = new StoreItemBatchStock();
		List addOrUpdate = new ArrayList();
		String grnNo = "";
		int rows = 0;
		String sourceOfSupply = "";
		Date grnDate = null;
		int grnId = 0;
		int unitId = 0;
		int indentId = 0;
		int poId = 0;
		String howReceived = "";
		Date dateReceivedSurplus = null;
		String rrNo = "";
		String modeOfConveyance = "";
		int employeeId = 0;
		String invoiceNo = "";
		Date invoiceDate = null;
		BigDecimal invoiceAmount = null;
		BigDecimal freightDuty = null;
		BigDecimal exciseDuty = null;
		BigDecimal octroi = null;
		BigDecimal customDuty = null;
		BigDecimal insuranceCharge = null;
		BigDecimal otherCharges = null;
		BigDecimal grnValue = null;
		BigDecimal roundOffValue = null;
		BigDecimal grnAmount = null;
		BigDecimal totalAmount = null;
		int supplierId = 0;
		String encodedBy = "";
		Date encodedDate = null;
		String lastChgBy = "A";
		Date lastChgDate = null;
		Date challanDate = null;
		String lastChgTime = "";
		String atSoNo = "";
		String remarks = "";
		String date = "";
		String time = "";
		String choice = "";
		int noOfRows = 0;
		int pageNo = 1;
		String buttonFlag = "";
		int meScaleId = 0;
		String technicalDetails = "";
		String amcContract = "";
		String technicalSpecification = "";
		String challanNo = "";
		int deptId = 0;
		int itemIdArray[]=null;
		int hospitalId = 0;
		String atSo = "";
		hospitalId = (Integer) session.getAttribute("hospitalId");
		
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		try {
			if (request.getParameter("pageNo") != null) {
				pageNo = Integer.parseInt(request.getParameter("pageNo"));
			}

			if (request.getParameter("noOfRows") != null) {
				noOfRows = Integer.parseInt(request.getParameter("noOfRows"));
			}

			if (request.getParameter(GRN_ID) != null) {
				grnId = Integer.parseInt(request.getParameter(GRN_ID));
			}

			if (!request.getParameter(EMPLOYEE_ID).equals("0")) {
				employeeId = Integer
						.parseInt(request.getParameter(EMPLOYEE_ID));
			}

			if (request.getParameter(ME_SCALE_ID)!=null) {
				meScaleId = Integer.parseInt(request.getParameter(ME_SCALE_ID));
			}

			if (request.getParameter(GRN_NO) != null) {
				grnNo = (request.getParameter(GRN_NO));
			}

			if (request.getParameter(TECHNICAL_DETAILS) != null) {
				technicalDetails = (request.getParameter(TECHNICAL_DETAILS));
			}

			if (request.getParameter(TECHNICAL_SPECIFICATION) != null) {
				technicalSpecification = (request
						.getParameter(TECHNICAL_SPECIFICATION));
			}

			if (request.getParameter(AMC_CONTRACT) != null) {
				amcContract = (request.getParameter(AMC_CONTRACT));
			}

			if (request.getParameter(INVOICE_NO) != null) {
				invoiceNo = (request.getParameter(INVOICE_NO));
			}
			if (request.getParameter(REMARKS) != null) {
				remarks = request.getParameter(REMARKS);
			}
			if (request.getParameter(RR_NO) != null) {
				rrNo = request.getParameter(RR_NO);
			}
			if (request.getParameter(MODE_OF_CONVEYANCE) != null) {
				modeOfConveyance = request.getParameter(MODE_OF_CONVEYANCE);
			}
			if (request.getParameter(SUPPLY_ORDER_NO) != null) {
				atSoNo = request.getParameter(SUPPLY_ORDER_NO);
			}
			if (request.getParameter(HOW_RECEIVED) != null) {
				howReceived = request.getParameter(HOW_RECEIVED);
			}
			if (request.getParameter(SOURCE_OF_SUPPLY) != null) {
				sourceOfSupply = request.getParameter(SOURCE_OF_SUPPLY);

			}
			// --- indent and supplier on basis of source of supply ---------
			if (request.getParameter(SOURCE_OF_SUPPLY).equals("g")) {
				if (request.getParameter(INDENT_ID) != null) {
					indentId = Integer.parseInt((request
							.getParameter(INDENT_ID)));
				}
			/*	if (request.getParameter(SUPPLIER_ID) != null) {
					supplierId = Integer.parseInt((request
							.getParameter(SUPPLIER_ID)));
				}*/
			} else if (request.getParameter(SOURCE_OF_SUPPLY).equals("b") || request.getParameter(SOURCE_OF_SUPPLY).equals("c") ) {

				if (request.getParameter(SUPPLIER_ID) != null) {
					supplierId = Integer.parseInt((request
							.getParameter(SUPPLIER_ID)));
					
					if (request.getParameter("supplierName") != null) {
						poId = Integer.parseInt((request
								.getParameter("supplierName")));
				}
				}
					
			}// added by javed khan
			else if (request.getParameter(SOURCE_OF_SUPPLY).equals("c") ) {

				if (request.getParameter(SUPPLIER_ID) != null) {
					supplierId = Integer.parseInt((request
							.getParameter(SUPPLIER_ID)));
					
					if (request.getParameter("SO_No") != null) {
						atSo = request.getParameter("SO_No");
								
				}
				}
					
			} 	
			else if (request.getParameter(SOURCE_OF_SUPPLY).equals("s")) {
				if (request.getParameter(INDENT_ID) != null) {
					indentId = Integer.parseInt((request
							.getParameter(INDENT_ID)));
				}
				/*if (request.getParameter(SUPPLIER_ID) != null) {
					supplierId = Integer.parseInt((request
							.getParameter(SUPPLIER_ID)));
				}*/
			} else if (request.getParameter(SOURCE_OF_SUPPLY).equals("a") || request.getParameter(SOURCE_OF_SUPPLY).equals("d")) {
				if (request.getParameter("UnitName") != null) {
					unitId = Integer.parseInt((request
							.getParameter("UnitName")));
				}

			} else if (request.getParameter(SOURCE_OF_SUPPLY).equals("m")) {
				if (request.getParameter(SUPPLIER_ID) != null) {
					supplierId = Integer.parseInt((request
							.getParameter(SUPPLIER_ID)));
				}
			}

			// ------- end of select

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String te = "";

			if (request.getParameter(GRN_DATE) != null) {
				te = (String) (request.getParameter(GRN_DATE));

				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(request.getParameter(GRN_DATE)));
				grnDate = java.sql.Date.valueOf(date4MySQL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			String teinvoice = "";
			if (request.getParameter(INVOICE_DATE) != null) {
				teinvoice = (String) (request.getParameter(INVOICE_DATE));

				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(request.getParameter(INVOICE_DATE)));
				invoiceDate = java.sql.Date.valueOf(date4MySQL);
				

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			String tedaterecd = "";
			if (request.getParameter(RECEIVED_DATE) != null) {
				tedaterecd = (String) (request.getParameter(RECEIVED_DATE));

				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(request.getParameter(RECEIVED_DATE)));
				dateReceivedSurplus = java.sql.Date.valueOf(date4MySQL);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");

		if (request.getParameter(INVOICE_AMOUNT) != null
				&& !request.getParameter(INVOICE_AMOUNT).equals("")) {
			invoiceAmount = new BigDecimal(request.getParameter(INVOICE_AMOUNT));
		} else {
			invoiceAmount = new BigDecimal(0);
		}
		if (request.getParameter(FREIGHT_DUTY) != null
				&& !request.getParameter(FREIGHT_DUTY).equals("")) {
			freightDuty = new BigDecimal(request.getParameter(FREIGHT_DUTY));
		} else {
			freightDuty = new BigDecimal(0);
		}
		if (request.getParameter(EXCISE_DUTY) != null
				&& !request.getParameter(EXCISE_DUTY).equals("")) {
			exciseDuty = new BigDecimal(request.getParameter(EXCISE_DUTY));
		} else {
			exciseDuty = new BigDecimal(0);
		}

		if (request.getParameter(OCTROI) != null
				&& !request.getParameter(OCTROI).equals("")) {
			octroi = new BigDecimal(request.getParameter(OCTROI));
		} else {
			octroi = new BigDecimal(0);
		}
		if (request.getParameter(CUSTOM_DUTY) != null
				&& !request.getParameter(CUSTOM_DUTY).equals("")) {
			customDuty = new BigDecimal(request.getParameter(CUSTOM_DUTY));
		} else {
			customDuty = new BigDecimal(0);
		}
		if (request.getParameter(INSURANCE_CHARGES) != null
				&& !request.getParameter(INSURANCE_CHARGES).equals("")) {
			insuranceCharge = new BigDecimal(request
					.getParameter(INSURANCE_CHARGES));
		} else {
			insuranceCharge = new BigDecimal(0);
		}

		if (request.getParameter(OTHER_CHARGES) != null
				&& !request.getParameter(OTHER_CHARGES).equals("")) {
			otherCharges = new BigDecimal(request.getParameter(OTHER_CHARGES));
		} else {
			otherCharges = new BigDecimal(0);
		}

		if (request.getParameter(GRN_VALUE) != null
				&& !request.getParameter(GRN_VALUE).equals("")) {
			grnValue = new BigDecimal(request.getParameter(GRN_VALUE));
		}
		if (request.getParameter(TOTAL_AMOUNT) != null
				&& !request.getParameter(TOTAL_AMOUNT).equals("")) {
			totalAmount = new BigDecimal(request.getParameter(TOTAL_AMOUNT));
		}

		String headerStored = "no";

		if (pageNo == 1) {

			storeGrnM.setGrnNo(grnNo);
			storeGrnM.setGrnStartNo(grnNo);
			storeGrnM.setCustomDuty(customDuty);
			storeGrnM.setDateReceivedSurplus(dateReceivedSurplus);
			// --- set on indent and supplier on basis of source of supply -----
			if (request.getParameter(SOURCE_OF_SUPPLY).equals("g")) {

				StoreIndentM storeIndentM = new StoreIndentM();
				storeIndentM.setId(indentId);
				storeGrnM.setIndent(storeIndentM);

				storeGrnM.setUnit(null);
				storeGrnM.setPo(null);
				storeGrnM.setSupplier(null);
			}

			else if (request.getParameter(SOURCE_OF_SUPPLY).equals("b") ) {

				MasStoreSupplier masStoreSupplier2 = new MasStoreSupplier();
				masStoreSupplier2.setId(supplierId);
				storeGrnM.setSupplier(masStoreSupplier2);
				StorePoHeader spoHeader=new StorePoHeader();
				spoHeader.setId(poId);
				storeGrnM.setPo(spoHeader);
				storeGrnM.setUnit(null);
				storeGrnM.setIndent(null);
				

			}// added by javed khan
			else if ( request.getParameter(SOURCE_OF_SUPPLY).equals("c")) {
				MasStoreSupplier masStoreSupplier2 = new MasStoreSupplier();
				masStoreSupplier2.setId(supplierId);
				storeGrnM.setSupplier(masStoreSupplier2);
				storeGrnM.setAtSoNo(atSo);
				storeGrnM.setUnit(null);
				storeGrnM.setIndent(null);
				

			}
			
			else if (request.getParameter(SOURCE_OF_SUPPLY).equals("s")) {
				StoreIndentM storeIndentM = new StoreIndentM();
				storeIndentM.setId(indentId);
				storeGrnM.setIndent(storeIndentM);

				storeGrnM.setUnit(null);
				storeGrnM.setPo(null);
				storeGrnM.setSupplier(null);
			}
			//else if (request.getParameter(SOURCE_OF_SUPPLY).equals("a") || request.getParameter(SOURCE_OF_SUPPLY).equals("d")) {
			else if (request.getParameter(SOURCE_OF_SUPPLY).equals("a") ) {
				
				MasStoreAirForceDepot masStoreAirForceDepot = new MasStoreAirForceDepot();
				masStoreAirForceDepot.setId(unitId);
				storeGrnM.setUnit(masStoreAirForceDepot);

				//storeGrnM.setSupplier(null);
				storeGrnM.setSupplier(null);
				storeGrnM.setIndent(null);
				storeGrnM.setPo(null);
			} // added by javed khan
			else if( request.getParameter(SOURCE_OF_SUPPLY).equals("d")){
				
				storeGrnM.setUnit(null);
				storeGrnM.setSupplier(null);
				storeGrnM.setIndent(null);
				storeGrnM.setPo(null);
			}
			else if (request.getParameter(SOURCE_OF_SUPPLY).equals("m")) {

				MasStoreSupplier masStoreSupplier2 = new MasStoreSupplier();
				masStoreSupplier2.setId(supplierId);
				storeGrnM.setSupplier(masStoreSupplier2);

				//storeGrnM.setUnit(null);
				
				storeGrnM.setIndent(null);
				storeGrnM.setPo(null);
				storeGrnM.setUnit(null);
			}
			// ----- end ----------
			storeGrnM.setInvoiceAmount(invoiceAmount);
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			storeGrnM.setEmployee(masEmployee);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);
			storeGrnM.setDepartment(masDepartment);
			storeGrnM.setRemarks(remarks);
			storeGrnM.setExciseDuty(exciseDuty);
			storeGrnM.setFreightDuty(freightDuty);
			storeGrnM.setGrnDate(grnDate);
			storeGrnM.setExciseDuty(exciseDuty);

			//MasStoreMeScale masStoreMeScale = new MasStoreMeScale();
			//masStoreMeScale.setId(meScaleId);
			//storeGrnM.setMeScale(masStoreMeScale);
			storeGrnM.setReceiveType(sourceOfSupply);

			storeGrnM.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			storeGrnM.setLastChgTime(time);
			//storeGrnM.setAtSoNo(atSoNo);
			if(!request.getParameter(GRN_VALUE).equals(""))
			{
			storeGrnM.setGrnValue(grnValue);
			}
			else
			{
				storeGrnM.setGrnValue(new BigDecimal(0));
			}
			storeGrnM.setHowReceived(howReceived);
			storeGrnM.setInsuranceCharge(insuranceCharge);
			storeGrnM.setInvoiceDate(invoiceDate);

			storeGrnM.setInvoiceNo(invoiceNo);
			storeGrnM.setModeOfConveyance(modeOfConveyance);
			storeGrnM.setOctroi(octroi);
			storeGrnM.setOtherCharges(otherCharges);
			storeGrnM.setReceiveType(sourceOfSupply);
			storeGrnM.setTechnicalDetails(technicalDetails);
			storeGrnM.setTechnicalSpecification(technicalSpecification);
			storeGrnM.setAmcContract(amcContract);
			storeGrnM.setGrnAmount(totalAmount);

			storeGrnM.setRrNo(rrNo);
			storeGrnM.setStatus("o");

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			storeGrnM.setHospital(masHospital);

			storeGrnM.setLastChgBy("admin");

		} else {
			headerStored = "yes";
			infoMap.put("headerStored", headerStored);
		}
		int length = 0;
		List<StoreGrnT> storeGrnTlist = new ArrayList<StoreGrnT>();

		try {

		/*	int srNo[] = JKTRequestUtils.getRequiredIntParameters(request,
					SR_NO);
			int itemIdArray[] = JKTRequestUtils.getRequiredIntParameters(
					request, ITEM_ID);
			int freeQty[] = JKTRequestUtils.getRequiredIntParameters(request,
					FREE_QTY);
		
			int manufacturerIdArray[] = JKTRequestUtils
					.getRequiredIntParameters(request, MANUFACTURER_ID);

			String lotNoArr[] = JKTRequestUtils.getRequiredStringParameters(
					request, LOT_NO);
			String batchNoArr[] = JKTRequestUtils.getRequiredStringParameters(
					request, BATCH_NO);
			String freeItemArr[] = JKTRequestUtils.getRequiredStringParameters(
					request, FREE_ITEM);
			/*
			String warrantyDate[] = JKTRequestUtils
					.getRequiredStringParameters(request, WARRANTY_DATE);
			String installationDate[] = JKTRequestUtils
					.getRequiredStringParameters(request, INSTALLATION_DATE);
			String amcStartDate[] = JKTRequestUtils
					.getRequiredStringParameters(request, AMC_START_DATE);
			String amcEndDate[] = JKTRequestUtils.getRequiredStringParameters(
					request, AMC_END_DATE);
			String acceptedModel[] = JKTRequestUtils
					.getRequiredStringParameters(request, ACCEPTED_MODEL);*/

			/*BigDecimal[] quantityReceivedArray = new BigDecimal[10];
			BigDecimal[] taxArr = new BigDecimal[10];
			BigDecimal[] unitRateArr = new BigDecimal[10];
			BigDecimal[] discountArr = new BigDecimal[10];
			BigDecimal[] amountArr = new BigDecimal[10];
			BigDecimal[] totAmountArr = new BigDecimal[10];
			BigDecimal[] costPrice = new BigDecimal[10];

			String yy[] = JKTRequestUtils.getRequiredStringParameters(request,
					TAX_PERCENT);
			int yyLen = yy.length;
			for (int i = 0; i < yyLen; i++) {
				BigDecimal val = new BigDecimal(yy[i]);
				taxArr[i] = val;
			}
			String tt[] = JKTRequestUtils.getRequiredStringParameters(request,
					UNIT_RATE);
			int ttLen = tt.length;
			for (int i = 0; i < ttLen; i++) {
				BigDecimal val = new BigDecimal(tt[i]);
				unitRateArr[i] = val;
			}
			String zz[] = JKTRequestUtils.getRequiredStringParameters(request,
					DISCOUNT_PERCENTAGE);
			int zzLen = zz.length;
			for (int i = 0; i < zzLen; i++) {
				BigDecimal val = new BigDecimal(zz[i]);
				discountArr[i] = val;
			}
			String qq[] = JKTRequestUtils.getRequiredStringParameters(request,
					AMOUNT);
			int qqLen = qq.length;
			for (int i = 0; i < qqLen; i++) {
				BigDecimal val = new BigDecimal(qq[i]);
				amountArr[i] = val;
			}
			String mm[] = JKTRequestUtils.getRequiredStringParameters(request,
					QUANTITY_RECEIVED);
			int mmLen = mm.length;
			for (int i = 0; i < mmLen; i++) {
				BigDecimal val = new BigDecimal(mm[i]);
				quantityReceivedArray[i] = val;
			}

			String gg[] = JKTRequestUtils.getRequiredStringParameters(request,
					COST_PRICE);
			int ggLen = gg.length;
			for (int i = 0; i < ggLen; i++) {
				BigDecimal val = new BigDecimal(gg[i]);
				costPrice[i] = val;
			}

			if (buttonFlag.equals("next")) {

				length = 10;
			} else {
				length = noOfRows;
			}

			/*for (int i = 0; i < length; i++) {
				if (itemIdArray[i] != 0) {

					StoreGrnT storeGrnTObj = new StoreGrnT();
					storeGrnTObj.setSerialNo(srNo[i]);
					storeGrnTObj.setFreeQty(freeQty[i]);

					if (freeItemArr[i].equalsIgnoreCase("y")) {
						storeGrnTObj.setFreeItem("y");
					} else {
						storeGrnTObj.setFreeItem("n");
					}
					MasStoreItem masItem = new MasStoreItem();
					masItem.setId(itemIdArray[i]);
					storeGrnTObj.setItem(masItem);

					if (manufacturerIdArray[i] != 0) {
						MasManufacturer masManufacturer = new MasManufacturer();
						masManufacturer.setId(manufacturerIdArray[i]);
						storeGrnTObj.setManufacturer(masManufacturer);
					}

					storeGrnTObj.setReceivedQty(quantityReceivedArray[i]);
					storeGrnTObj.setTax(taxArr[i]);
					storeGrnTObj.setAmountValue(amountArr[i]);
					storeGrnTObj.setUnitRate(unitRateArr[i]);
					storeGrnTObj.setBatchNo(batchNoArr[i]);
					storeGrnTObj.setLotNo(lotNoArr[i]);
					storeGrnTObj.setDiscount(discountArr[i]);
					/*storeGrnTObj.setWarrantyDate(warrantyDate[i]);
					storeGrnTObj.setInstallationDate(installationDate[i]);
					storeGrnTObj.setAmcEndDate(amcEndDate[i]);
					storeGrnTObj.setAmcStartDate(amcStartDate[i]);
					storeGrnTObj.setFinalCostPrice(costPrice[i]);
					storeGrnTObj.setAcceptedModel(acceptedModel[i]);
					
					storeGrnTlist.add(storeGrnTObj);
				}*/
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		infoMap.put("pageNo", pageNo);
		infoMap.put("grnNo", grnNo);
		infoMap.put("grnId", grnId);
	
		infoMap.put("addOrUpdate", addOrUpdate);
		infoMap.put("storeGrnM", storeGrnM);
		infoMap.put("storeItemBatchStock", storeItemBatchStock);
		infoMap.put("storeGrnTlist", storeGrnTlist);
		infoMap.put("deptId", deptId);
		infoMap.put("sourceOfSupply", sourceOfSupply);

		infoMap.put("box", box);
		// infoMap.put("userName", userName);
		 infoMap.put("hospitalId", hospitalId);
		infoMap.put("indentId", indentId);

		boolean flag = false;
		try {
			flag = nonExpendableStoresHandlerService.addGrns(infoMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (map.get("flag") != null) {
			flag = (Boolean) map.get("flag");
		}

		String messageTOBeVisibleToTheUser = "";
		if (flag) {
			if (buttonFlag.equals("next")) {
				jsp = NE_GRN_JSP;
				pageNo++;
				messageTOBeVisibleToTheUser = "CRV created Successfully !";
				map = nonExpendableStoresHandlerService.showNeGrnJsp(box,
						dataMap);
				if (map.get("grnId") != null) {
					grnId = (Integer) map.get("grnId");
				}
				List<StoreGrnM> grnMList = storesHandlerService.getGrn(grnId);
				map.put("grnMList", grnMList);

			} else {
				jsp = NE_GRN_JSP;
				pageNo++;
				messageTOBeVisibleToTheUser = "CRV created Successfully !";
			}
		} else {
			messageTOBeVisibleToTheUser = "CRV not created.";
		}
		dataMap.put("deptId", deptId);
		map = nonExpendableStoresHandlerService.showNeGrnJsp(box, dataMap);
		//jsp = "neGrn";
		
		//jsp=MESSAGE_NE_GRN_JSP;
		
		//jsp = CRV_JSP;
		
		jsp= "PrintCRVForNE";
		
		jsp += ".jsp";
		String url = "";
		String printUrl = "";
		url = "/hms/hms/neStores?method=showNeGrnJsp";
		printUrl = "/hms/hms/stores?method=printGrn&grnNo="+grnNo+"&deptId="+hospitalId;
		map.put("grnNo", grnNo);
		map.put("printUrl", printUrl);
		map.put("souceOfSupply",sourceOfSupply);
		map.put("pageNo", pageNo);
		map.put("contentJsp", jsp);
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView responseNeGrn(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String choice = "";
		int hospitalId = 0;
		hospitalId = (Integer) session.getAttribute("hospitalId");
		if (request.getParameter(SOURCE_OF_SUPPLY) != null) {
			choice = request.getParameter(SOURCE_OF_SUPPLY);
		}
		
		if(choice.equalsIgnoreCase("a") || choice.equalsIgnoreCase("b"))
		{     System.out.println("a------> and b----------> In if block");
			map = (Map<String, Object>) nonExpendableStoresHandlerService
			//.getListForNeGrn(choice);
			.getListForNeGrn1(choice,hospitalId);
			//jsp = INDENT_RESPONSE_JSP_FOR_NE_GRN;
			jsp = RESPONSE_FOR_NE_GRN_JSP;
			}
		else
		{
			System.out.println("a------> and b----------> In else block");
		    map = (Map<String, Object>) nonExpendableStoresHandlerService
			//.getListForNeGrn(choice);
				.getListForNeGrn1(choice,hospitalId);
		jsp = RESPONSE_FOR_NE_GRN_JSP;
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView responseIndentList(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		String choice = "";
		map = nonExpendableStoresHandlerService.getResponseIndentList(box);
		jsp = RESPONSE_INDENT_LIST_FOR_NE;
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView responseGridList(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		String choice = "";
		
		if(request.getParameter("indentId")!=null && !request.getParameter("indentId").equals(""))
		{
		int indentId=Integer.parseInt(request.getParameter("indentId"));
		map=nonExpendableStoresHandlerService.getindenList(indentId);
		}
		jsp = "gridForNe";
		return new ModelAndView(jsp, "map", map);
	}

	// For searching Grn on basis of GRN No
	public ModelAndView searchGrn(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String fromDate = "";
		String toDate = "";
		String grnNo = "";
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> tempMap = new HashMap<String, Object>();
		Map<String, Object> searchFieldMap = new HashMap<String, Object>();
		List<StoreGrnM> searchGrnList = new ArrayList<StoreGrnM>();
		try {
			if (request.getParameter(FROM_DATE) != null) {
				fromDate = request.getParameter(FROM_DATE);

			}
			if (request.getParameter(TO_DATE) != null) {
				toDate = request.getParameter(TO_DATE);

			}
			if (request.getParameter(GRN_NO) != null) {
				grnNo = request.getParameter(GRN_NO);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		searchFieldMap.put("fromDate", fromDate);
		searchFieldMap.put("toDate", toDate);
		searchFieldMap.put("grnNo", grnNo);
		try {
			tempMap = nonExpendableStoresHandlerService.showNeGrnJsp(box,
					dataMap);
			if (tempMap.get("searchGrnList") != null)
				searchGrnList = (List) tempMap.get("searchGrnList");
			map = nonExpendableStoresHandlerService.searchGrn(searchFieldMap);

			map.put("searchGrnList", searchGrnList);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		//jsp = SEARCH_NE_GRN_JSP;
		jsp = SEARCH_GRN_JSP;
		jsp = jsp + ".jsp";
		title = "GRN";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView modifyGrn(HttpServletRequest request,
			HttpServletResponse response) {

		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> purchaseMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		jsp = MODIFY_NE_GRN_JSP;
		jsp += ".jsp";
		int radio_str = 0;
		int deptId = 0;

		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		if (request.getParameter("parent") != null) {
			radio_str = Integer.parseInt(request.getParameter("parent"));
			map = (Map<String, Object>) nonExpendableStoresHandlerService
					.modifyGrn(radio_str, 0);
		}
		purchaseMap = nonExpendableStoresHandlerService.showNeGrnJsp(box,
				dataMap);
		List<StoreGrnM> grnList = storesHandlerService.getGrnList();

		map.put("purchaseMap", purchaseMap);
		map.put("grnList", grnList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("radio_str", radio_str);

		return new ModelAndView("index", "map", map);
	}

	// ------------------------------------- new grid
	// method---------------------------

	public ModelAndView getItemListForGrnByAutocomplete(
			HttpServletRequest request, HttpServletResponse response) {

		Box box = HMSUtil.getBox(request);
		String sos = box.getString("sourceOfSupply").trim();
		String itemNameField = "";
		String autoHint = "";
		String indentNo = "";
		int indentId = 0;
		int hospitalId = 0;
		int deptId = 0;
		String userName = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("requiredField") != null) {
			itemNameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(itemNameField) != null) {
			autoHint = (request.getParameter(itemNameField));
		}
		if (sos.equalsIgnoreCase("d") || (sos.equalsIgnoreCase("s"))) {
			if (request.getParameter("indentId") != null) {
				indentId = Integer.parseInt((request.getParameter("indentId")));
			}

		}
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		dataMap.put("autoHint", autoHint);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("indentId", indentId);
		dataMap.put("box", box);
		map = nonExpendableStoresHandlerService
				.getItemListForGrnByAutocomplete(dataMap);
		jsp = "result";
		return new ModelAndView(jsp, "map", map);
	}

	public void fillItemsForGrn(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		int deptId = 0;
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		Box box = HMSUtil.getBox(request);
		String itemNameField = "";
		String nomenclature = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("requiredField") != null) {
			nomenclature = (request.getParameter("requiredField"));
		}
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		dataMap.put("nomenclature", nomenclature);
		dataMap.put("deptId", deptId);
		map = nonExpendableStoresHandlerService.fillItemsForGrn(dataMap);
		if (map.get("itemList") != null) {
			itemList = (List) map.get("itemList");
		}

		StringBuffer sb = new StringBuffer();
		try {
			for (MasStoreItem masStoreItem : itemList) {

				sb.append("<item>");
				sb.append("<id>" + masStoreItem.getId() + "</id>");
				sb.append("<pvms>" + masStoreItem.getPvmsNo() + "</pvms>");
				sb.append("<au>"
						+ masStoreItem.getItemConversion().getItemUnitName()
						+ "</au>");
				sb.append("</item>");
			}

			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	// --------------------------------- NON EXPENDABLE LOAN IN
	// -----------------------
	public ModelAndView showNeLoanInJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = nonExpendableStoresHandlerService.showNeLoanInJsp(box, dataMap);
		jsp = NE_LOAN_IN_JSP;
		jsp = jsp + ".jsp";
		title = "Loan IN";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	// ===================== adding loanin ================================

	public ModelAndView submitLoanIn(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		StoreLoaninM storeLoaninM = new StoreLoaninM();
		StoreLoaninT storeLoaninT = new StoreLoaninT();
		StoreItemBatchStock storeItemBatchStock = new StoreItemBatchStock();

		String loanInNo = "";
		int rows = 0;
		int noOfRecords = 0;
		String receiveType = "";
		Date loanInDate = new Date();

		int loanInId = 0;
		int unitId = 0;
		int poId = 0;
		String howReceived = "";
		String challanNo = "";
		Date challanDate = new Date();
		Date dateReceivedSurplus = new Date();
		String rrNo = "";
		String modeOfConveyance = "";
		int employeeId = 0;
		BigDecimal freightDuty = null;
		BigDecimal exciseDuty = null;
		BigDecimal octroi = null;
		BigDecimal customDuty = null;
		BigDecimal insuranceCharge = null;
		BigDecimal otherCharges = null;
		BigDecimal grnValue = null;
		BigDecimal roundOffValue = null;
		BigDecimal grnAmount = null;
		BigDecimal totalAmount = null;
		int supplierId = 0;
		String encodedBy = "";
		Date encodedDate = null;
		String lastChgBy = "A";
		Date lastChgDate = null;
		String lastChgTime = "";
		String atSoNo = "";
		String buttonFlag = "";
		String remarks = "";
		String date = "";
		String time = "";
		int meScaleId = 0;
		String technicalDetails = "";
		String technicalSpecification = "";
		String amcContract = "";
		String extnIvNo = "";
		String periodFrom = "";
		int hospitalId = 0;
		String userName = "";
		int deptId = 0;
		int indentId = 0;

		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		int noOfRows = 0;
		int pageNo = 1;
		try {
			if (request.getParameter("pageNo") != null) {
				pageNo = Integer.parseInt(request.getParameter("pageNo"));

			}
			if (request.getParameter("buttonFlag") != null) {
				buttonFlag = request.getParameter("buttonFlag");

			}

			if (request.getParameter("noOfRows") != null) {
				noOfRows = Integer.parseInt(request.getParameter("noOfRows"));
			}
			if (request.getParameter(LOANIN_ID) != null) {
				loanInId = Integer.parseInt(request.getParameter(LOANIN_ID));

			}
			if (!request.getParameter(SUPPLIER_ID).equals("0")) {
				supplierId = Integer
						.parseInt(request.getParameter(SUPPLIER_ID));

			}

			if (!request.getParameter(EMPLOYEE_ID).equals("0")) {
				employeeId = Integer
						.parseInt(request.getParameter(EMPLOYEE_ID));

			}
			if (!request.getParameter(ME_SCALE_ID).equals("0")) {
				meScaleId = Integer.parseInt(request.getParameter(ME_SCALE_ID));

			}

			if (request.getParameter(EXTN_IV) != null) {
				extnIvNo = (request.getParameter(EXTN_IV));
			}
			if (request.getParameter(REMARKS) != null) {
				remarks = (request.getParameter(REMARKS));
			}
			if (request.getParameter(LOANIN_NO) != null) {
				loanInNo = (request.getParameter(LOANIN_NO));
			}

			if (request.getParameter(TECHNICAL_DETAILS) != null) {
				technicalDetails = (request.getParameter(TECHNICAL_DETAILS));
			}

			if (request.getParameter(TECHNICAL_SPECIFICATION) != null) {
				technicalSpecification = (request
						.getParameter(TECHNICAL_SPECIFICATION));
			}

			if (request.getParameter(AMC_CONTRACT) != null) {
				amcContract = (request.getParameter(AMC_CONTRACT));
			}

			if (request.getParameter(PERIOD_FROM) != null) {
				periodFrom = (request.getParameter(PERIOD_FROM));
			}
			if (pageNo != 1) {
			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		try {
			String te = "";

			if (request.getParameter(LOANIN_DATE) != null) {
				te = (String) (request.getParameter(LOANIN_DATE));

				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(request.getParameter(LOANIN_DATE)));
				loanInDate = java.sql.Date.valueOf(date4MySQL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");

		if (request.getParameter(GRN_VALUE) != null
				&& !request.getParameter(GRN_VALUE).equals("")) {
			grnValue = new BigDecimal(request.getParameter(GRN_VALUE));
		}

		if (request.getParameter(TOTAL_AMOUNT) != null
				&& !request.getParameter(TOTAL_AMOUNT).equals("")) {
			totalAmount = new BigDecimal(request.getParameter(TOTAL_AMOUNT));
		}

		String headerStored = "no";

		if (pageNo == 1) {
			storeLoaninM.setLoaninDate(loanInDate);
			storeLoaninM.setLoaninNo(loanInNo);
			storeLoaninM.setRemarks(remarks);

			MasStoreAirForceDepot masStoreAirForceDepot = new MasStoreAirForceDepot();
			masStoreAirForceDepot.setId(supplierId);
			storeLoaninM.setUnit(masStoreAirForceDepot);

			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			storeLoaninM.setEmployee(masEmployee);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);
			storeLoaninM.setDepartment(masDepartment);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(1);
			storeLoaninM.setHospital(masHospital);
			storeLoaninM.setRoundOffValue(roundOffValue);
			storeLoaninM.setLoaninValue(grnValue);
			storeLoaninM.setStatus("o");
			storeLoaninM.setLastChgBy("admin");
			storeLoaninM.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			storeLoaninM.setLastChgTime(time);
			storeLoaninM.setExtnIvNo(extnIvNo);
			storeLoaninM.setPeriodFrom(periodFrom);

			MasStoreMeScale masStoreMeScale = new MasStoreMeScale();
			masStoreMeScale.setId(meScaleId);
			storeLoaninM.setMeScale(masStoreMeScale);

		} else {

			headerStored = "yes";
			infoMap.put("headerStored", headerStored);
		}

		int length = 0;
		List<StoreLoaninT> storeLoaninTlist = new ArrayList<StoreLoaninT>();

		try {

			int srNo[] = JKTRequestUtils.getRequiredIntParameters(request,
					SR_NO);
			int itemIdArray[] = JKTRequestUtils.getRequiredIntParameters(
					request, ITEM_ID);
			int freeQty[] = JKTRequestUtils.getRequiredIntParameters(request,
					FREE_QTY);
			int manufacturerIdArray[] = JKTRequestUtils
					.getRequiredIntParameters(request, MANUFACTURER_ID);
			String lotNoArr[] = JKTRequestUtils.getRequiredStringParameters(
					request, LOT_NO);
			String batchNoArr[] = JKTRequestUtils.getRequiredStringParameters(
					request, BATCH_NO);
			String freeItemArr[] = JKTRequestUtils.getRequiredStringParameters(
					request, FREE_ITEM);
			String warrantyDate[] = JKTRequestUtils
					.getRequiredStringParameters(request, WARRANTY_DATE);
			String installationDate[] = JKTRequestUtils
					.getRequiredStringParameters(request, INSTALLATION_DATE);
			String amcStartDate[] = JKTRequestUtils
					.getRequiredStringParameters(request, AMC_START_DATE);
			String amcEndDate[] = JKTRequestUtils.getRequiredStringParameters(
					request, AMC_END_DATE);
			String acceptedModel[] = JKTRequestUtils
					.getRequiredStringParameters(request, ACCEPTED_MODEL);

			BigDecimal[] taxArr = new BigDecimal[10];
			BigDecimal[] unitRateArr = new BigDecimal[10];
			BigDecimal[] discountArr = new BigDecimal[10];
			BigDecimal[] amountArr = new BigDecimal[10];
			BigDecimal[] quantityReceivedArray = new BigDecimal[10];
			BigDecimal[] costPrice = new BigDecimal[10];

			String yy[] = JKTRequestUtils.getRequiredStringParameters(request,
					TAX_PERCENT);
			int yyLen = yy.length;
			for (int i = 0; i < yyLen; i++) {
				BigDecimal val = new BigDecimal(yy[i]);
				taxArr[i] = val;
			}
			String tt[] = JKTRequestUtils.getRequiredStringParameters(request,
					UNIT_RATE);
			int ttLen = tt.length;
			for (int i = 0; i < ttLen; i++) {
				BigDecimal val = new BigDecimal(tt[i]);
				unitRateArr[i] = val;
			}
			String zz[] = JKTRequestUtils.getRequiredStringParameters(request,
					DISCOUNT_PERCENTAGE);
			int zzLen = zz.length;
			for (int i = 0; i < zzLen; i++) {
				BigDecimal val = new BigDecimal(zz[i]);
				discountArr[i] = val;
			}
			String qq[] = JKTRequestUtils.getRequiredStringParameters(request,
					AMOUNT);
			int qqLen = qq.length;
			for (int i = 0; i < qqLen; i++) {
				BigDecimal val = new BigDecimal(qq[i]);
				amountArr[i] = val;
			}
			String mm[] = JKTRequestUtils.getRequiredStringParameters(request,
					QUANTITY_RECEIVED);
			int mmLen = qq.length;
			for (int i = 0; i < mmLen; i++) {
				BigDecimal val = new BigDecimal(mm[i]);
				quantityReceivedArray[i] = val;
			}

			String gg[] = JKTRequestUtils.getRequiredStringParameters(request,
					COST_PRICE);
			int ggLen = gg.length;
			for (int i = 0; i < ggLen; i++) {
				BigDecimal val = new BigDecimal(gg[i]);
				costPrice[i] = val;
			}

			if (buttonFlag.equals("next")) {
				// if(buttonFlag != null){
				length = 10;
			} else {
				length = noOfRows;
			}
			for (int i = 0; i < length; i++) {

				if (itemIdArray[i] != 0) {

					StoreLoaninT storeLoaninTObj = new StoreLoaninT();
					storeLoaninTObj.setSerialNo(srNo[i]);

					MasStoreItem masItem = new MasStoreItem();
					masItem.setId(itemIdArray[i]);
					storeLoaninTObj.setItem(masItem);

					storeLoaninTObj.setReceivedQty(quantityReceivedArray[i]);
					storeLoaninTObj.setTax(taxArr[i]);
					storeLoaninTObj.setDiscount(discountArr[i]);
					storeLoaninTObj.setAmountValue(amountArr[i]);
					storeLoaninTObj.setUnitRate(unitRateArr[i]);
					storeLoaninTObj.setBatchNo(batchNoArr[i]);
					storeLoaninTObj.setFreeQty(freeQty[i]);

					if (freeItemArr[i].equalsIgnoreCase("y")) {
						storeLoaninTObj.setFreeItem("y");
					} else {
						storeLoaninTObj.setFreeItem("n");
					}
					storeLoaninTObj.setLotNo(lotNoArr[i]);
					storeLoaninTObj.setAcceptedModel(acceptedModel[i]);
					storeLoaninTObj.setAmcEndDate(amcEndDate[i]);
					storeLoaninTObj.setAmcStartDate(amcStartDate[i]);
					storeLoaninTObj.setWarrantyDate(warrantyDate[i]);
					storeLoaninTObj.setInstallationDate(installationDate[i]);
					storeLoaninTObj.setFinalCostPrice(costPrice[i]);

					if (manufacturerIdArray[i] != 0) {
						MasManufacturer masManufacturer = new MasManufacturer();
						masManufacturer.setId(manufacturerIdArray[i]);
						storeLoaninTObj.setManufacturer(masManufacturer);
					}
					storeLoaninTlist.add(storeLoaninTObj);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		infoMap.put("pageNo", pageNo);
		infoMap.put("loanInNo", loanInNo);
		infoMap.put("loanInId", loanInId);
		infoMap.put("pageNo", pageNo);
		infoMap.put("storeLoaninM", storeLoaninM);
		infoMap.put("storeItemBatchStock", storeItemBatchStock);
		infoMap.put("storeLoaninTlist", storeLoaninTlist);
		infoMap.put("deptId", deptId);
		infoMap.put("userName", userName);
		infoMap.put("hospitalId", hospitalId);

		boolean flag = false;
		try {
			flag = nonExpendableStoresHandlerService.addLoanIn(infoMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		String messageTOBeVisibleToTheUser = "";

		if (flag) {

			pageNo++;
			messageTOBeVisibleToTheUser = "LoanIn Records Added Successfully";
		} else {
			
			messageTOBeVisibleToTheUser = "LoanIn Records Not Added, Some Error";
		}
		jsp = "neLoanIn";
		jsp += ".jsp";
		String url = "";
		url = "/hms/hms/neStores?method=showNeLoanInJsp";
		map.put("loanInNo", loanInNo);
		map.put("pageNo", pageNo);
		map.put("contentJsp", jsp);
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView("index", "map", map);

	}

	// More Parameters of a PVMS/NIV Item that are Non-Mandatory Fields.
	public ModelAndView showInfoOfNeLoanInJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreLoaninT> loanInMoreInfoList = new ArrayList<StoreLoaninT>();
		map = storesHandlerService.getDetailsForLoanIn();
		int rowNo = 0;
		int loaninDetailId = 0;

		if (request.getParameter("rowNo") != null) {
			rowNo = Integer.parseInt(request.getParameter("rowNo"));
		}
		if (request.getParameter("detailId") != null) {
			loaninDetailId = Integer.parseInt(request.getParameter("detailId"));
			loanInMoreInfoList = nonExpendableStoresHandlerService
					.getLoanInListForMoreInfo(loaninDetailId);
			map.put("loanInMoreInfoList", loanInMoreInfoList);
		}
		jsp = MORE_INFO_NE_LOANIN_JSP;
		title = "LOAN IN";
		map.put("title", title);
		map.put("rowNo", rowNo);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView searchLoanin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Box box = HMSUtil.getBox(request);
		String fromDate = "";
		String toDate = "";
		String loanInNo = "";
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> tempMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> searchFieldMap = new HashMap<String, Object>();
		List<StoreLoaninM> searchLoanInList = new ArrayList<StoreLoaninM>();
		try {
			if (request.getParameter(FROM_DATE) != null) {
				fromDate = request.getParameter(FROM_DATE);

			}
			if (request.getParameter(TO_DATE) != null) {
				toDate = request.getParameter(TO_DATE);

			}
			if (request.getParameter(LOANIN_NO) != null) {
				loanInNo = request.getParameter(LOANIN_NO);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		searchFieldMap.put("fromDate", fromDate);
		searchFieldMap.put("toDate", toDate);
		searchFieldMap.put("loanInNo", loanInNo);
		try {
			tempMap = nonExpendableStoresHandlerService.showNeLoanInJsp(box,
					dataMap);
			if (tempMap.get("searchLoanInList") != null)
				searchLoanInList = (List) tempMap.get("searchLoanInList");
			map = nonExpendableStoresHandlerService
					.searchLoanin(searchFieldMap);
			map.put("searchLoanInList", searchLoanInList);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		jsp = SEARCH__NE_LOANIN;
		jsp = jsp + ".jsp";
		title = "LOANIN";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView modifyLoanin(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> purchaseMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		jsp = MODIFY_NE_LOANIN_JSP;
		jsp += ".jsp";
		int radio_str = 0;
		int deptId = 0;

		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		if (request.getParameter("parent") != null) {
			radio_str = Integer.parseInt(request.getParameter("parent"));
			map = (Map<String, Object>) nonExpendableStoresHandlerService
					.modifyLoanin(radio_str, 0);
		}
		dataMap.put("deptId", deptId);
		purchaseMap = nonExpendableStoresHandlerService.showNeLoanInJsp(box,
				dataMap);
		List<StoreLoaninM> loaninList = nonExpendableStoresHandlerService
				.getloanList(dataMap);

		map.put("purchaseMap", purchaseMap);
		map.put("loaninList", loaninList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("radio_str", radio_str);

		return new ModelAndView("index", "map", map);
	}

	// ------------------------------------- new grid
	// method---------------------------

	public ModelAndView getItemListForLoanInByAutocomplete(
			HttpServletRequest request, HttpServletResponse response) {

		Box box = HMSUtil.getBox(request);
		String sos = box.getString("sourceOfSupply").trim();
		String itemNameField = "";
		String autoHint = "";
		int indentId = 0;
		int hospitalId = 0;
		int deptId = 0;
		String userName = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("requiredField") != null) {
			itemNameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(itemNameField) != null) {
			autoHint = (request.getParameter(itemNameField));
		}
		if (sos.equalsIgnoreCase("d") || (sos.equalsIgnoreCase("s"))) {
			if (request.getParameter("indentId") != null) {
				indentId = Integer.parseInt((request.getParameter("indentId")));
			}
		}
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		dataMap.put("autoHint", autoHint);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("indentId", indentId);
		dataMap.put("box", box);
		map = nonExpendableStoresHandlerService
				.getItemListForLoanInByAutocomplete(dataMap);
		jsp = "result";
		return new ModelAndView(jsp, "map", map);
	}

	public void fillItemsForLoanIn(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		int deptId = 0;
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		Box box = HMSUtil.getBox(request);
		String itemNameField = "";
		String nomenclature = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("requiredField") != null) {
			nomenclature = (request.getParameter("requiredField"));
		}
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		dataMap.put("nomenclature", nomenclature);
		dataMap.put("deptId", deptId);
		map = nonExpendableStoresHandlerService.fillItemsForLoanIn(dataMap);
		if (map.get("itemList") != null) {
			itemList = (List) map.get("itemList");
		}

		StringBuffer sb = new StringBuffer();
		try {
			for (MasStoreItem masStoreItem : itemList) {

				sb.append("<item>");
				sb.append("<id>" + masStoreItem.getId() + "</id>");
				sb.append("<pvms>" + masStoreItem.getPvmsNo() + "</pvms>");
				sb.append("<au>"
						+ masStoreItem.getItemConversion().getItemUnitName()
						+ "</au>");
				sb.append("</item>");
			}

			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// return new ModelAndView(jsp, "map", map);
	}

	// ================= WORK ORDER=======================
	public ModelAndView showWorkOrderJsp(HttpServletRequest request,HttpServletResponse response) {
		String userName = "";
		String departmentName = "";
		int deptId = 0;
		int hospitalId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();

		if (session.getAttribute("departmentName") != null)
			departmentName = (String) session.getAttribute("departmentName");
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("departmentName", departmentName);

		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreWorkOrderM> workOrderList = nonExpendableStoresHandlerService
				.getWorkOrderList();
		map = nonExpendableStoresHandlerService.showWorkOrderJsp(box, dataMap);
		jsp = WORK_ORDER_JSP;
		jsp = jsp + ".jsp";
		title = "WORK ORDER";
		map.put("workOrderList", workOrderList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getItemListForWorkOrderByAutocomplete(
			HttpServletRequest request, HttpServletResponse response) {

		Box box = HMSUtil.getBox(request);
		
		String itemNameField = "";
		String autoHint = "";
		int indentId = 0;
		int hospitalId = 0;
		int deptId = 0;
		String userName = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("requiredField") != null) {
			itemNameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(itemNameField) != null) {
			autoHint = (request.getParameter(itemNameField));
		}
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		dataMap.put("autoHint", autoHint);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("box", box);
		map = nonExpendableStoresHandlerService
				.getItemListForWorkOrderByAutocomplete(dataMap);
		//jsp = "result";
		jsp="resultForWorkOrder";
		return new ModelAndView(jsp, "map", map);
	}

	public void fillItemsForWorkOrder(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		Box box = HMSUtil.getBox(request);
		String itemNameField = "";
		String pvmsNo = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("pvmsNo") != null) {
			pvmsNo = (request.getParameter("pvmsNo"));
		}
		
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<StoreItemBatchStock> batchList = new ArrayList<StoreItemBatchStock>();

		dataMap.put("pvmsNo", pvmsNo);
		dataMap.put("deptId", deptId);
		map = nonExpendableStoresHandlerService.fillItemsForWorkOrder(dataMap);
		if (map.get("itemList") != null) {
			itemList = (List) map.get("itemList");
			
		}
		if (map.get("batchList") != null) {
			batchList = (List) map.get("batchList");
		}

		StringBuffer sb = new StringBuffer();
		try {
			for (MasStoreItem masStoreItem : itemList) {

				sb.append("<item>");
				sb.append("<id>" + masStoreItem.getId() + "</id>");
				sb.append("<pvms>" + masStoreItem.getPvmsNo() + "</pvms>");
			sb.append("<au>"
						+ masStoreItem.getItemConversion().getItemUnitName()
						+ "</au>");
				sb.append("<batchs>");
				for (StoreItemBatchStock batch : batchList) {
					sb.append("<batch>");
					sb.append("<batchId>" + batch.getBatchNo() + "</batchId>");
					sb.append("<batchName>" + batch.getBatchNo()
							+ "</batchName>");
					sb.append("</batch>");
				}
				sb.append("</batchs>");
				sb.append("</item>");
			}

			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView printWorkOrder(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "WORK ORDER REPORT";
		List<StoreWorkOrderM> workOrderList = nonExpendableStoresHandlerService.getWorkOrderList();
		jsp = WORK_ORDER_REPORT;
		jsp = jsp + ".jsp";
		map.put("workOrderList", workOrderList);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateWorkOrderReport(HttpServletRequest request,
			HttpServletResponse response) {/*
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		byte[] bytes = null;

		int workOrderId = 0;
		session = request.getSession();
		try {

			if (request.getParameter(WORK_ORDER_ID) != null
					&& !(request.getParameter(WORK_ORDER_ID).equals(""))) {
				workOrderId = Integer.parseInt(request
						.getParameter(WORK_ORDER_ID));
			}
			requestParameters.put("workOrderId", workOrderId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = nonExpendableStoresHandlerService
				.getConnectionForReport();
		try {
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport("work_order_performa"),
					requestParameters, (Connection) connectionMap.get("con"));

		} catch (JRException e) {

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
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	*/

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		byte[] bytes = null;

		String unitName ="";
		String workOrderNo="";
		HttpSession session = request.getSession();
		session = request.getSession();
		try {
			
			if (session.getAttribute("unitName") != null) {
				unitName = (String) session.getAttribute("unitName");
				//generalMap.put("unitName", unitName);
				requestParameters.put("unitName", unitName);
			}
			if (request.getParameter(WORK_ORDER_NO) != null
					&& !(request.getParameter(WORK_ORDER_NO).equals(""))) {
				workOrderNo = request.getParameter(WORK_ORDER_NO);
			}
			requestParameters.put("workOrderNo", workOrderNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = nonExpendableStoresHandlerService.getConnectionForReport();

        HMSUtil.generateReport("workOrder", requestParameters, (Connection)detailsMap.get("con"), response, getServletContext());
		return null;
	}

	// ========= common function for report

	private JasperReport getCompiledReport(String fileName) throws JRException {

		File reportFile = new File(getServletContext().getRealPath(
				"/reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile.getPath());

		return jasperReport;
	}

	// ==================== end of common function ==================
	/*public ModelAndView submitWorkOrder(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		StoreWorkOrderM storeWorkOrderM = new StoreWorkOrderM();
		StoreWorkOrderT storeWorkOrderT = new StoreWorkOrderT();
		int workOrderId = 0;
		Date workOrderDate = new Date();
		String encodedBy = "";
		Date encodedDate = null;
		String lastChgBy = "A";
		Date lastChgDate = null;
		String lastChgTime = "";
		int departmentId = 0;
		String date = "";
		String time = "";
		int noOfRows = 0;
		int pageNo = 1;
		String buttonFlag = "";
		int repairingCell = 0;
		int hospitalId = 0;
		String workOrderNo = "";
		String authority = "";
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
		try {
			if (request.getParameter("pageNo") != null) {
				pageNo = Integer.parseInt(request.getParameter("pageNo"));

			}
			if (request.getParameter(NO_OF_ROWS) != null) {
				noOfRows = Integer.parseInt(request.getParameter(NO_OF_ROWS));
			}
			if (request.getParameter(WORK_ORDER_ID) != null) {
				workOrderId = Integer.parseInt(request
						.getParameter(WORK_ORDER_ID));

			}

			if (request.getParameter(AUTHORITY) != null) {
				authority = request.getParameter(AUTHORITY);
			}
			if (request.getParameter(WORK_ORDER_NO) != null) {
				workOrderNo = request.getParameter(WORK_ORDER_NO);
			}
			if (request.getParameter(REPAIRING_CELL) != null) {
				repairingCell = Integer.parseInt(request.getParameter(REPAIRING_CELL));
			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}

		try {
			String te = "";

			if (request.getParameter(WORK_ORDER_DATE) != null) {
				te = (String) (request.getParameter(WORK_ORDER_DATE));

				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(request.getParameter(WORK_ORDER_DATE)));
				workOrderDate = java.sql.Date.valueOf(date4MySQL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		String headerStored = "no";
		MasRepairStation masRepairStation =new MasRepairStation();
		 if (pageNo == 1) {

			storeWorkOrderM.setAuthorityNo(authority);
			masRepairStation.setId(repairingCell);
			storeWorkOrderM.setRepairStation(masRepairStation);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);
			storeWorkOrderM.setDepartment(masDepartment);

			storeWorkOrderM.setWorkOrderDate(workOrderDate);
			storeWorkOrderM.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			storeWorkOrderM.setLastChgTime(time);
			storeWorkOrderM.setStatus("y");

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			storeWorkOrderM.setHospital(masHospital);

			storeWorkOrderM.setLastChgBy("admin");
			storeWorkOrderM.setStatus("o");
			storeWorkOrderM.setWorkOrderNo(workOrderNo);

		} else {
			headerStored = "yes";
			infoMap.put("headerStored", headerStored);
		}
		int length = 0;
		List<StoreWorkOrderT> storeWorkOrderTlist = new ArrayList<StoreWorkOrderT>();

		try {
			String srNo[] = JKTRequestUtils.getRequiredStringParameters(
					request, SR_NO);
			int itemIdArray[] = JKTRequestUtils.getRequiredIntParameters(
					request, ITEM_ID);
			String remarks[] = JKTRequestUtils.getRequiredStringParameters(
					request, REMARKS);
			String natureOfWork[] = JKTRequestUtils
					.getRequiredStringParameters(request, NATURE_OF_WORK);
			int quantityReceivedArray[] = JKTRequestUtils
					.getRequiredIntParameters(request, QUANTITY_RECEIVED);
			String batchNo[] = JKTRequestUtils.getRequiredStringParameters(
					request, BATCH_ID);

			if (buttonFlag.equals("next")) {
				// if(buttonFlag != null){
				length = 10;
			} else {
				length = noOfRows;
			}

			for (int i = 0; i < length; i++) {
				if (itemIdArray[i] != 0) {

					StoreWorkOrderT storeWOrderTObj = new StoreWorkOrderT();
					MasStoreItem masItem = new MasStoreItem();
					masItem.setId(itemIdArray[i]);
					storeWOrderTObj.setItem(masItem);

					storeWOrderTObj.setRemarks(remarks[i]);
					storeWOrderTObj.setSrNo(srNo[i]);
					storeWOrderTObj.setQuantity(quantityReceivedArray[i]);
					storeWOrderTObj.setNatureOfWork(natureOfWork[i]);
					storeWOrderTObj.setSerialNo(batchNo[i]);
					storeWorkOrderTlist.add(storeWOrderTObj);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		infoMap.put("pageNo", pageNo);
		infoMap.put("workOrderNo", workOrderNo);
		infoMap.put("workOrderId", workOrderId);
		infoMap.put("storeWorkOrderM", storeWorkOrderM);
		infoMap.put("storeWorkOrderTlist", storeWorkOrderTlist);
		infoMap.put("deptId", deptId);

		boolean flag = false;
		try {
			flag = nonExpendableStoresHandlerService.addWorkOrder(infoMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (map.get("flag") != null) {
			flag = (Boolean) map.get("flag");
		}
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		String messageTOBeVisibleToTheUser = "";

		if (flag) {
			if (buttonFlag.equals("next")) {
				jsp = WORK_ORDER_JSP;
				pageNo++;
				messageTOBeVisibleToTheUser = "Work Order  Entry has  been done Successfully";
				map = nonExpendableStoresHandlerService.showWorkOrderJsp(box,
						dataMap);
				if (map.get("workOrderId") != null) {
					workOrderId = (Integer) map.get("workOrderId");
				}

			} else {
				map = nonExpendableStoresHandlerService.showWorkOrderJsp(box,
						dataMap);
				if (map.get("workOrderId") != null) {
					workOrderId = (Integer) map.get("workOrderId");
				}
				map = nonExpendableStoresHandlerService.showWorkOrderJsp(box,
						dataMap);
				jsp = WORK_ORDER_JSP;
				pageNo++;
				messageTOBeVisibleToTheUser = "Work Order Entry has been done Successfully";
			}
		} else {
			messageTOBeVisibleToTheUser = "Work Order Entry has not been done Successfully";
		}

		jsp = "workOrder";
		jsp += ".jsp";
		String url = "";
		url = "/hms/hms/neStores?method=showWorkOrderJsp";
		// map.put("workOrderNo",workOrderNo);
		map.put("pageNo", pageNo);
		map.put("contentJsp", jsp);
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView("index", "map", map);

	}*/

	public ModelAndView searchWorkOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		// --------------------------------------------------------------------------------
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		List<StoreWorkOrderM> workOrderList = nonExpendableStoresHandlerService
				.getWorkOrderList();
	//	map = nonExpendableStoresHandlerService.showUpdateWorkOrder(dataMap);
		int workOrderId = 0;
		if (request.getParameter(WORK_ORDER_ID) != null) {
			workOrderId = Integer.parseInt(request.getParameter(WORK_ORDER_ID));

		}
		Box box = HMSUtil.getBox(request);

		box.put("workOrderId", workOrderId);
		int pageNo = 1;
		jsp = MODIFY_WORK_ORDER;
		jsp += ".jsp";
		int radio_str = 0;
		if (request.getParameter("workOrder1") != null) {
			radio_str = Integer.parseInt(request.getParameter("workOrder1"));
			infoMap.put("pageNo",pageNo);
			infoMap.put("hospitalId",hospitalId);
			infoMap.put("deptId",deptId);
			infoMap.put("radio_str",radio_str);
			map = (Map) nonExpendableStoresHandlerService.getWorkOrderModify(infoMap);
		}
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("radio_str", radio_str);
		map.put("workOrderList", workOrderList);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView showGrnReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		int deptId = 0;
		int hospitalId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();

		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);

		title = "GRN REPORT";
		List<StoreGrnM> crvNumberList = nonExpendableStoresHandlerService
				.getCrvNumberList(dataMap);
		jsp = NE_GRN_REPORT;
		jsp = jsp + ".jsp";
		map.put("crvNumberList", crvNumberList);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateCrvReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String grnNo = null;
		String flag = null;
		int deptId = 0;
		byte[] bytes = null;

		session = request.getSession();
		if (request.getParameter(GRN_NO) != null
				&& !(request.getParameter(GRN_NO).equals(""))) {
			grnNo = request.getParameter(GRN_NO);
		}

		deptId = (Integer) session.getAttribute("deptId");
		requestParameters = storesHandlerService.getDBConnection();
		requestParameters.put("Dept_ID", deptId);
		requestParameters.put("CRV_No", grnNo);
		Map<String, Object> connectionMap = storesHandlerService
				.getConnectionForReport();
		try {

			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport("CertificateReceiptVoucher"),
					requestParameters, (Connection) connectionMap.get("con"));

		} catch (JRException e) {

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
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);

	}
	public ModelAndView amcMaintenanceViewJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = nonExpendableStoresHandlerService.showAmcMaintenanceJsp(box);
		jsp = AMC_MAINTENANCE_JSP;
		jsp = jsp + ".jsp";
		title = "AMC";
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasStoreSupplier> suppList = new ArrayList<MasStoreSupplier>();
		List<String> entryNoList = new ArrayList<String>();
		List<StoreAmcM> docentryList = new ArrayList<StoreAmcM>();
		if (map.get("departmentList") != null)
			departmentList = (List) map.get("departmentList");
		suppList = nonExpendableStoresHandlerService.getSupplierList();
		docentryList = nonExpendableStoresHandlerService.getDocEntryNo();
		map.put("suppList", suppList);
		map.put("docentryList", docentryList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getNomenclature(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer departmentId = null;
		departmentId = Integer.parseInt(request.getParameter("departmentId"));
		map = nonExpendableStoresHandlerService.getNomenclature(departmentId);
		jsp = SHOW_AMC_NOMENCLATURE_JSP;
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getNomenclatureSearch(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer departmentId = null;
		departmentId = Integer.parseInt(request.getParameter("departmentId"));
		map = nonExpendableStoresHandlerService.getNomenclature(departmentId);
		jsp = SHOW_AMC_SEARCH_NOMENCLATURE_JSP;
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getPvmsNoAndGetSerialNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int nomenclatureId = 0;
		nomenclatureId = Integer.parseInt(request.getParameter("nomenclature"));
		map = nonExpendableStoresHandlerService
				.getPvmsNoAndGetSerialNo(nomenclatureId);
		jsp = SHOW_AMC_PVMS_AND_SERIALNO_JSP;
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getSerialNoforSearch(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int nomenclatureId = 0;
		nomenclatureId = Integer.parseInt(request.getParameter("nomenclature"));
		map = nonExpendableStoresHandlerService
				.getPvmsNoAndGetSerialNo(nomenclatureId);
		jsp = SHOW_AMC_SERIALNO_SEARCH_JSP;
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getSerialNoDetail(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		String serialNo = "";
		int itemId = 0;
		List<MasStoreSupplier> suppList = new ArrayList<MasStoreSupplier>();
		itemId = Integer.parseInt(request.getParameter("nomenclature"));
		serialNo = request.getParameter(SERIAL_NUMBER);
		map = nonExpendableStoresHandlerService.getSerialNoDetails(serialNo,
				itemId);
		suppList = nonExpendableStoresHandlerService.getSupplierList();
		map.put("suppList", suppList);
		jsp = SHOW_AMC_SERIALNO_DETAIL_JSP;
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView addOrUpdateAmcMaintenance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreAmcT> storeList = new ArrayList<StoreAmcT>();

		String supplyOrderNo = null;
		String crvNo = null;
		int id = 0;
		Date dofInstallation, fASDate, warantStartDate, warantEndDate, supptStartDate, supptEndDate = null;
		String dateofInstallation = "";
		String warrantyStartDate = null;
		String warrantyEndDate = null;
		String supportEndDate = null;
		String supportStartDate = null;
		Date fasd = null;
		Date amcEndDate = null;
		Date entDate = null;
		BigDecimal totalRecievedQty = null;
		String costOfEquipment = null;
		BigDecimal costEquipment = null;
		BigDecimal advBillAmount = null;
		BigDecimal balanceBillNo = null;
		BigDecimal balanceBillAmount = null;
		BigDecimal costAmc = null;
		String departmentCode = "";
		String pvmsNO = "";
		int itemId = 0;
		String serialNo = "";
		String entryDate = "";
		String firstAmcStartDate = "";
		String docEntryNo = "";
		Date wsd = null;
		Date wed = null;
		Date ssd = null;
		Date sed = null;
		Date installationDate = null;
		Date amcStartDate = null;
		Date advBDate = null;
		boolean flag1 = false;
		Date balanceBillDate = null;
		int noOfRows = 0;
		Date amcDtFrom = null;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = "";
		String time = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		Date lastChgDate = HMSUtil.convertStringTypeDateToDateType(date);
		String userid = "";
		int hospitalId = 0;
		int deptId = 0;
		int departmentId = 0;
		session = request.getSession();
		userid = (String) session.getAttribute("loginName");

		StoreAmcM storeAmcM = new StoreAmcM();

		MasDepartment masDepartment = new MasDepartment();
		MasDepartment masDepartment1 = new MasDepartment();
		MasStoreItem masStoreItem = new MasStoreItem();
		MasHospital masHospital = new MasHospital();
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		masHospital.setId(hospitalId);
		departmentId = (Integer) session.getAttribute("deptId");
		masDepartment1.setId(departmentId);
		try {

			if (request.getParameter("docentryno") != null) {
				docEntryNo = request.getParameter("docentryno");
			}
			if (request.getParameter("departmentId") != null) {
				departmentCode = request.getParameter("departmentId");
			}
			if (request.getParameter("nomenclature") != null) {
				itemId = Integer.parseInt(request.getParameter("nomenclature"));
			}
			if (request.getParameter(PVMS_NO) != null) {
				pvmsNO = request.getParameter(PVMS_NO);
			}
			if (request.getParameter(SERIAL_NUMBER) != null) {
				serialNo = request.getParameter(SERIAL_NUMBER);
			}
			if (request.getParameter(FIRST_AMC_START_DATE) != null) {
				firstAmcStartDate = (request.getParameter(FIRST_AMC_START_DATE));
			}
			if (request.getParameter(CRV) != null) {
				crvNo = (request.getParameter(CRV));
			}
			if (request.getParameter(ENTRY_DATE) != null) {
				entryDate = (request.getParameter(ENTRY_DATE));
			}
			if (request.getParameter(SUPPLY_ORDER_NO) != null) {
				supplyOrderNo = (request.getParameter(SUPPLY_ORDER_NO));
			}

			if (request.getParameter(COST) != null
					&& request.getParameter(COST) != "") {
				costOfEquipment = (request.getParameter(COST));
				if (costOfEquipment.equalsIgnoreCase("null")) {
					BigDecimal val = new BigDecimal(0);
					costEquipment = val;

				} else {
					BigDecimal val = new BigDecimal(costOfEquipment);
					costEquipment = val;

				}

			}

			if (request.getParameter(WARRANTY_DATE) != null) {
				warrantyStartDate = (request.getParameter(WARRANTY_DATE));
			}
			if (request.getParameter(WARRANTY_END_DATE) != null) {
				warrantyEndDate = (request.getParameter(WARRANTY_END_DATE));
			}
			if (request.getParameter(SUPPORT_START_DATE) != null) {
				supportStartDate = (request.getParameter(SUPPORT_START_DATE));
			}
			if (request.getParameter(SUPPORT_END_DATE) != null) {
				supportEndDate = (request.getParameter(SUPPORT_END_DATE));
			}
			if (request.getParameter(INSTALLATION_DATE) != null) {
				dateofInstallation = (request.getParameter(INSTALLATION_DATE));
			}
			if (request.getParameter(TOTAL_QUANTITY_RECIEVED) != null
					&& !request.getParameter(TOTAL_QUANTITY_RECIEVED)
							.equalsIgnoreCase("null")) {
				totalRecievedQty = new BigDecimal(request
						.getParameter(TOTAL_QUANTITY_RECIEVED));
			}

			if (entryDate != "" && entryDate != "0") {
				entDate = HMSUtil.convertStringTypeDateToDateType(entryDate);
			}
			if (firstAmcStartDate != "" && firstAmcStartDate != "0"
					&& !firstAmcStartDate.equalsIgnoreCase("null")) {
				fasd = HMSUtil
						.convertStringTypeDateToDateType(firstAmcStartDate);
			}
			if (warrantyStartDate != "" && warrantyStartDate != "0"
					&& !warrantyStartDate.equalsIgnoreCase("null")) {
				wsd = HMSUtil
						.convertStringTypeDateToDateType(warrantyStartDate);
			}
			if (warrantyEndDate != "" && warrantyEndDate != "0"
					&& !warrantyEndDate.equalsIgnoreCase("null")) {
				wed = HMSUtil.convertStringTypeDateToDateType(warrantyEndDate);
			}
			if (supportStartDate != "" && supportStartDate != "0"
					&& !supportStartDate.equalsIgnoreCase("null")) {
				ssd = HMSUtil.convertStringTypeDateToDateType(supportStartDate);
			}
			if (supportEndDate != "" && supportEndDate != "0"
					&& !supportEndDate.equalsIgnoreCase("null")) {
				sed = HMSUtil.convertStringTypeDateToDateType(supportEndDate);
			}
			if (dateofInstallation != "" && dateofInstallation != "0"
					&& !dateofInstallation.equalsIgnoreCase("null")) {
				installationDate = HMSUtil
						.convertStringTypeDateToDateType(dateofInstallation);
			}

			masDepartment.setDepartmentCode(departmentCode);
			masStoreItem.setId(itemId);
			// storeAmcM.setId(id);
			storeAmcM.setEntryDate(entDate);
			storeAmcM.setDepartment(masDepartment1);
			storeAmcM.setEquipmentDept(masDepartment1);
			storeAmcM.setItem(masStoreItem);
			storeAmcM.setSerialNo(serialNo);
			storeAmcM.setTotReceivedQty(totalRecievedQty);
			storeAmcM.setFirstAmcStartDate(fasd);
			storeAmcM.setEntryNo(docEntryNo);
			storeAmcM.setSupplyOrderNo(supplyOrderNo);
			storeAmcM.setCrvNo(crvNo);
			storeAmcM.setCostOfEquipment(costEquipment);
			storeAmcM.setDateOfInstallation(installationDate);
			storeAmcM.setWarrantyStartDate(wsd);
			storeAmcM.setWarrantyEndDate(wed);
			storeAmcM.setSupportStartDate(ssd);
			storeAmcM.setSupportEndDate(sed);
			storeAmcM.setLastChagTime(time);
			storeAmcM.setLastChgBy(userid);
			storeAmcM.setLastChgDate(lastChgDate);
			storeAmcM.setHospitalId(hospitalId);
			storeAmcM.setStatus("o");

			try {

				noOfRows = Integer.parseInt(request
						.getParameter("amcTDetailListSize"));
				String supplierCode[] = JKTRequestUtils
						.getRequiredStringParameters(request, AMC_CONTRACT);
				String amcDateFrom[] = JKTRequestUtils
						.getRequiredStringParameters(request, AMC_START_DATE);
				String amcDateTo[] = JKTRequestUtils
						.getRequiredStringParameters(request, AMC_END_DATE);
				String advBillNo[] = JKTRequestUtils
						.getRequiredStringParameters(request, ADDVANCE_BILL_NO);
				String advBillDate[] = JKTRequestUtils
						.getRequiredStringParameters(request,
								ADDVANCE_BILL_DATE);
				String balBillNo[] = JKTRequestUtils
						.getRequiredStringParameters(request, BALANCE_NO);
				String balBillDate[] = JKTRequestUtils
						.getRequiredStringParameters(request, BALANCE_BILL_DATE);
				String remarks[] = JKTRequestUtils.getRequiredStringParameters(
						request, REMARKS);

				BigDecimal[] costofAmc = new BigDecimal[10];
				BigDecimal[] advBillAmt = new BigDecimal[10];
				BigDecimal[] balBillAmt = new BigDecimal[10];

				String tt[] = JKTRequestUtils.getRequiredStringParameters(
						request, COST_OF_AMC);
				int ttLen = tt.length;
				for (int i = 0; i < ttLen; i++) {
					if (tt[i] != null || tt[i] != "") {
						BigDecimal val = new BigDecimal(tt[i]);
						costofAmc[i] = val;
					}
				}

				String zz[] = JKTRequestUtils.getRequiredStringParameters(
						request, ADDVANCE_BILL_AMOUNT);
				int zzLen = zz.length;
				for (int i = 0; i < zzLen; i++) {
					if (zz[i] != null || zz[i] != "") {
						BigDecimal val = new BigDecimal(zz[i]);
						advBillAmt[i] = val;
					}
				}
				String qq[] = JKTRequestUtils.getRequiredStringParameters(
						request, BALANCE_AMOUNT);
				int qqLen = qq.length;
				for (int i = 0; i < qqLen; i++) {
					BigDecimal val = new BigDecimal(qq[i]);
					balBillAmt[i] = val;
				}

				for (int j = 0; j < noOfRows; j++) {
					StoreAmcT storeAmcT = new StoreAmcT();

					MasStoreSupplier masStoreSupplier = new MasStoreSupplier();
					masStoreSupplier.setId(new Integer(supplierCode[j]));
					storeAmcT.setAmcCompany(masStoreSupplier);

					if (!amcDateFrom[j].equals("")) {
						amcStartDate = HMSUtil
								.dateFormatterDDMMYYYY(amcDateFrom[j]);
					}
					storeAmcT.setAmcStartDate(amcStartDate);

					if (!amcDateTo[j].equals("")) {
						amcEndDate = HMSUtil
								.dateFormatterDDMMYYYY(amcDateTo[j]);
					}
					storeAmcT.setAmcEndDate(amcEndDate);
					storeAmcT.setCostOfAmc(costofAmc[j]);
					storeAmcT.setAdvBillNo(advBillNo[j]);
					if (!advBillDate[j].equals("")) {

						advBDate = HMSUtil
								.dateFormatterDDMMYYYY(advBillDate[j]);
					}
					storeAmcT.setAdvBillDate(advBDate);

					storeAmcT.setAdvBillAmount(advBillAmt[j]);
					storeAmcT.setBalanceBillNo(balBillNo[j]);
					if (balBillDate[j] != "") {
						balanceBillDate = HMSUtil
								.dateFormatterDDMMYYYY(balBillDate[j]);
					}
					storeAmcT.setBalanceBillDate(balanceBillDate);
					storeAmcT.setBalanceBillAmount(balBillAmt[j]);
					storeAmcT.setRemarks(remarks[j]);
					storeAmcT.setAmcM(storeAmcM);
					storeList.add(storeAmcT);
				}
				try {
					flag1 = nonExpendableStoresHandlerService
							.addAmcMDetailsandaddAmcTDetails(storeAmcM,
									storeList);

				} catch (Exception e) {

				}

			} catch (Exception e) {

			}

			String messageTOBeVisibleToTheUser = "";
			if (flag1) {

				messageTOBeVisibleToTheUser = "Records Added Successfully";
			} else {
				
				messageTOBeVisibleToTheUser = "Records Not Added, Some Error";
			}
			jsp = "message";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView amcSearchResult(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> searchFieldMap = new HashMap<String, Object>();
		List<MasStoreSupplier> suppList = new ArrayList<MasStoreSupplier>();
		List<StoreAmcM> docentryList = new ArrayList<StoreAmcM>();
		List<StoreAmcT> amcTlist = new ArrayList<StoreAmcT>();
		List amcMaintenanceDetails = new ArrayList();
		StoreAmcM amcMDetails = null;
		String docEntryNo = "";
		int departmentCode = 0;
		int itemId = 0;
		String serialNo = "";
		if (request.getParameter("docentryno") != null) {
			docEntryNo = request.getParameter("docentryno");
		}
		if (request.getParameter("departmentId") != null
				&& request.getParameter("departmentId") != "") {
			departmentCode = Integer.parseInt(request
					.getParameter("departmentId"));
		}
		if (request.getParameter("nomenclature") != null
				&& request.getParameter("nomenclature") != "") {
			itemId = Integer.parseInt(request.getParameter("nomenclature"));
		}
		if (request.getParameter(SERIAL_NUMBER) != null
				&& request.getParameter("SERIAL_NUMBER") != "") {
			serialNo = request.getParameter(SERIAL_NUMBER);
		}
		searchFieldMap.put("docentryno", docEntryNo);
		searchFieldMap.put("departmentId", departmentCode);
		searchFieldMap.put("nomenclature", itemId);
		searchFieldMap.put("SERIAL_NUMBER", serialNo);
		map = nonExpendableStoresHandlerService.getNomenclature(departmentCode);
		suppList = nonExpendableStoresHandlerService.getSupplierList();
		docentryList = nonExpendableStoresHandlerService.getDocEntryNo();
		map = nonExpendableStoresHandlerService
				.getAmcSearchResult(searchFieldMap);
		if (map.get("amcMaintenanceDetails") != null) {
			amcMaintenanceDetails = (List) map.get("amcMaintenanceDetails");
			for (int i = 0; i < amcMaintenanceDetails.size(); i++) {
				amcMDetails = (StoreAmcM) amcMaintenanceDetails.get(i);
				int id = amcMDetails.getId();
				amcTlist = nonExpendableStoresHandlerService.getStoreAmcT(id);
			}
		}
		map.put("amcTDetailsList", amcTlist);
		map.put("suppList", suppList);
		map.put("docentryList", docentryList);

		jsp = AMC_MAINTENANCE_SEARCH_RESULT_JSP;
		jsp = jsp + ".jsp";
		title = "AMC";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView amcRepairViewJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		List<String> repairNoList = new ArrayList<String>();
		List<StoreRepairCivilFirm> storerepairList = new ArrayList<StoreRepairCivilFirm>();
		Map<String, Object> map = new HashMap<String, Object>();
		Integer departmentId = null;
		session = request.getSession();
		departmentId = (Integer) session.getAttribute("deptId");
		map = nonExpendableStoresHandlerService.getNomenclature(departmentId);
		jsp = AMC_REPAIR_JSP;
		jsp = jsp + ".jsp";
		title = "AMC";
		repairNoList = nonExpendableStoresHandlerService.getRepairNoList();
		storerepairList = nonExpendableStoresHandlerService.getRepairNo();
		map.put("repairNoList", repairNoList);
		map.put("storerepairList", storerepairList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getPvmsNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int nomenclatureId = 0;
		String itemName="";

		if (request.getParameter(NOMENCLATURE) != null
				&& !request.getParameter(NOMENCLATURE).equals("")) {
			itemName = request.getParameter(NOMENCLATURE);
		} 
		
		if(itemName!="")
		{
		int index1=itemName.lastIndexOf("[");
		int index2=itemName.lastIndexOf("]");
		index1=index1+1;
		nomenclatureId=Integer.parseInt(itemName.substring(index1, index2));
		}
		map = nonExpendableStoresHandlerService
				.getPvmsNoAndGetSerialNo(nomenclatureId);
		jsp = SHOW_AMC_PVMS_JSP;
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getSerialNoAmcRepairDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serialNo = "";
		int itemId = 0;
		List<MasStoreSupplier> suppList = new ArrayList<MasStoreSupplier>();
		itemId = Integer.parseInt(request.getParameter("itemId"));
		serialNo = request.getParameter(SERIAL_NUMBER);
		map = nonExpendableStoresHandlerService.getSerialNoDetails(serialNo,
				itemId);
		jsp = SHOW_AMC_SERIALNO_REPAIR_DETAIL_JSP;
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView addAmcRepair(HttpServletRequest request,
			HttpServletResponse response) {
		boolean flag = false;
		String messageTOBeVisibleToTheUser = "";
		StoreRepairCivilFirm storeRepairCivilFirm = null;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = "";
		String time = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		MasDepartment masDepartment = new MasDepartment();
		MasHospital masHospital = new MasHospital();
		String userid = "";
		int hospitalId = 0;
		int deptId = 0;
		session = request.getSession();
		userid = (String) session.getAttribute("loginName");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		deptId = (Integer) session.getAttribute("deptId");
		masHospital.setId(hospitalId);
		masDepartment.setId(deptId);
		String repairNo = "";
		String commandrepaircell = "";
		String repairDate = "";
		String certificatefromeme = "";
		int itemId = 0;
		String pvmsNo = "";
		String breakdownrepaircharges = "";
		String au = "";
		String reasonablenesscost = "";
		int quantity = 0;
		String costOfRepair = "";
		String nuumberoftimeseqpt = "";
		String crv = "";
		String serialNo = "";
		String sourceofreciept = "";
		String amceneteredlasttime = "";
		String quantitycondition = "";
		int quantityrequired = 0;
		String natureofrepair = "";
		String cost = "";
		String compartivequatations = "";
		String reasonforrecommending = "";
		BigDecimal costRepair = null;
		Date repdate = null;
		Date lastChgDate = HMSUtil.convertStringTypeDateToDateType(date);
		BigDecimal costofEquipment = null;
		BigDecimal reasonablecost = null;
		String itemName="";
		int id = 0;
		try {

			if (request.getParameter("repairno") != null) {
				repairNo = request.getParameter("repairno");
			}
			if (request.getParameter("REPAIR_CELL") != null) {
				commandrepaircell = request.getParameter("REPAIR_CELL");
			}
			if (request.getParameter("repairdate") != null) {
				repairDate = request.getParameter("repairdate");
				repdate = HMSUtil.convertStringTypeDateToDateType(repairDate);

			}
			if (request.getParameter("CERTIFICATE_FROM_DEPENDENT_EME") != null) {
				certificatefromeme = request
						.getParameter("CERTIFICATE_FROM_DEPENDENT_EME");
			}
			/*if (request.getParameter(NOMENCLATURE) != null) {
				itemId = Integer.parseInt(request.getParameter(NOMENCLATURE));
			}*/
			
			
			if (request.getParameter(NOMENCLATURE) != null) {
				itemName = request.getParameter(NOMENCLATURE);
			}
			
			
			if (request.getParameter("itemId") != null) {
				itemId = Integer.parseInt(request.getParameter("itemId"));
			}
			
			if (request.getParameter(PVMS_NO) != null) {
				pvmsNo = request.getParameter(PVMS_NO);
			}
			if (request.getParameter(SERIAL_NUMBER) != null) {
				serialNo = request.getParameter(SERIAL_NUMBER);
			}
			if (request.getParameter(BREAKDOWN_REPAIR_CHARGES) != null) {
				breakdownrepaircharges = (request
						.getParameter(BREAKDOWN_REPAIR_CHARGES));
			}
			if (request.getParameter(AU) != null) {
				au = (request.getParameter(AU));
			}
			if (request.getParameter(REASONABLENESS_OF_COST) != null || !request.getParameter(REASONABLENESS_OF_COST).equals("")) {
				reasonablenesscost = (request
						.getParameter(REASONABLENESS_OF_COST));
				BigDecimal val = new BigDecimal(reasonablenesscost);
				reasonablecost = val;
			}
			if (request.getParameter(QUANTITY) != null) {
				quantity = Integer.parseInt((request.getParameter(QUANTITY)));
			}

			if (request.getParameter(COST_OF_REPAIR) != null
					&& request.getParameter(COST_OF_REPAIR) != "") {
				costOfRepair = (request.getParameter(COST_OF_REPAIR));

			}
			if (request.getParameter(NUMBER_OF_TIMES_EQPT_WENT_OUT) != null) {
				nuumberoftimeseqpt = (request
						.getParameter(NUMBER_OF_TIMES_EQPT_WENT_OUT));
			}
			if (request.getParameter(CRV) != null) {
				crv = (request.getParameter(CRV));
			}
			if (request.getParameter(SOURCE_OF_RECIEPT) != null) {
				sourceofreciept = (request.getParameter(SOURCE_OF_RECIEPT));
			}
			if (request.getParameter(AMC_ENTERED_LAST_TIME) != null) {
				amceneteredlasttime = (request
						.getParameter(AMC_ENTERED_LAST_TIME));
			}
			if (request.getParameter(QUANTITY_HELD_WITH_CONDITION) != null) {
				quantitycondition = (request
						.getParameter(QUANTITY_HELD_WITH_CONDITION));
			}
			if (request.getParameter(QUANTITY_REQUIRED_TO_BE_REPAIRED) != null || !request.getParameter(QUANTITY_REQUIRED_TO_BE_REPAIRED).equalsIgnoreCase("")) {
				quantityrequired = Integer.parseInt(request
						.getParameter(QUANTITY_REQUIRED_TO_BE_REPAIRED));
			}
			if (request.getParameter(NATURE_OF_REPAIR) != null) {
				natureofrepair = (request.getParameter(NATURE_OF_REPAIR));
			}
			if (request.getParameter(COST) != null || !request.getParameter(COST).equals("")) {
				cost = (request.getParameter(COST));
				BigDecimal val = new BigDecimal(cost);
				costofEquipment = val;
			}
			if (request.getParameter(COMPARATIVE_STATEMENT_OF_QUATATIONS) != null) {
				compartivequatations = request
						.getParameter(COMPARATIVE_STATEMENT_OF_QUATATIONS);
			}
			if (request.getParameter(REASON_FOR_RECOMMENDING) != null) {
				reasonforrecommending = request
						.getParameter(REASON_FOR_RECOMMENDING);
			}
			try {
				/*if(itemName!="")
				{
				int index1=itemName.lastIndexOf("[");
				int index2=itemName.lastIndexOf("]");
				index1=index1+1;
				itemId=Integer.parseInt(itemName.substring(index1, index2));
				}*/
				storeRepairCivilFirm = new StoreRepairCivilFirm();
				MasStoreItem storeItem = new MasStoreItem();
				storeItem.setId(itemId);
				storeRepairCivilFirm.setRepairNo(repairNo);
				storeRepairCivilFirm.setRepairDate(repdate);
				storeRepairCivilFirm.setSerialNo(serialNo);
				storeRepairCivilFirm.setItem(storeItem);
				storeRepairCivilFirm.setCrvNo(crv);
				storeRepairCivilFirm.setQty(quantity);
				storeRepairCivilFirm.setSourceOfReceipt(sourceofreciept);
				storeRepairCivilFirm.setLastChgBy(userid);
				storeRepairCivilFirm.setLastChgDate(lastChgDate);
				storeRepairCivilFirm.setLastChgTime(time);
				storeRepairCivilFirm.setConditionOfItem(quantitycondition);
				storeRepairCivilFirm.setQtyRepair(quantityrequired);
				storeRepairCivilFirm.setBlrBerCertificate(certificatefromeme);
				storeRepairCivilFirm
						.setComparativeStatOfQuotation(compartivequatations);
				storeRepairCivilFirm.setCostOfEquipment(costofEquipment);
				storeRepairCivilFirm.setCostOfRepair(costOfRepair);
				storeRepairCivilFirm.setDepartment(masDepartment);
				storeRepairCivilFirm.setHospital(masHospital);
				storeRepairCivilFirm.setLastCostOfRepair(amceneteredlasttime);
				storeRepairCivilFirm.setNatureOfRepair(natureofrepair);
				storeRepairCivilFirm.setNoOfTimeOutorder(nuumberoftimeseqpt);
				storeRepairCivilFirm.setRepairBreakdown(breakdownrepaircharges);
				storeRepairCivilFirm.setReasonableOfRepairCost(reasonablecost);
				storeRepairCivilFirm
						.setReasonForRecommend(reasonforrecommending);
				storeRepairCivilFirm.setStatus("o");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		try {
			map = nonExpendableStoresHandlerService
					.addStoreRepairCivilFirm(storeRepairCivilFirm);

		} catch (Exception e) {
		}
		
		
		try {
			map = nonExpendableStoresHandlerService.getNomenclature(deptId);

		} catch (Exception e) {
		}
		
		jsp = AMC_REPAIR_JSP;
	//	jsp = SHOW_AMC_REPAIR_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateStoreRepairCivilFirm(HttpServletRequest request,
			HttpServletResponse response) {
		boolean flag = false;
		String messageTOBeVisibleToTheUser = "";
		StoreRepairCivilFirm storeRepairCivilFirm = null;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = "";
		String time = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		MasDepartment masDepartment = new MasDepartment();
		MasHospital masHospital = new MasHospital();
		String userid = "";
		int hospitalId = 0;
		int deptId = 0;
		session = request.getSession();
		userid = (String) session.getAttribute("loginName");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		deptId = (Integer) session.getAttribute("deptId");
		masHospital.setId(hospitalId);
		masDepartment.setId(deptId);
		String repairNo = "";
		String commandrepaircell = "";
		String repairDate = "";
		String certificatefromeme = "";
		int itemId = 0;
		String pvmsNo = "";
		String breakdownrepaircharges = "";
		String au = "";
		String reasonablenesscost = "";
		int quantity = 0;
		String costOfRepair = "";
		String nuumberoftimeseqpt = "";
		String crv = "";
		String serialNo = "";
		String sourceofreciept = "";
		String amceneteredlasttime = "";
		String quantitycondition = "";
		int quantityrequired = 0;
		String natureofrepair = "";
		String cost = "";
		String compartivequatations = "";
		String reasonforrecommending = "";
		BigDecimal costRepair = null;
		Date repdate = null;
		Date lastChgDate = HMSUtil.convertStringTypeDateToDateType(date);
		BigDecimal costofEquipment = null;
		BigDecimal reasonablecost = null;
		int id = 0;
		try {
			if (request.getParameter("repairid") != null
					&& request.getParameter("repairid") != "") {
				id = Integer.parseInt(request.getParameter("repairid"));
			}
			if (request.getParameter("repairno") != null) {
				repairNo = request.getParameter("repairno");
			}
			if (request.getParameter("REPAIR_CELL") != null) {
				commandrepaircell = request.getParameter("REPAIR_CELL");
			}
			if (request.getParameter("repairdate") != null) {
				repairDate = request.getParameter("repairdate");
				repdate = HMSUtil.convertStringTypeDateToDateType(repairDate);

			}
			if (request.getParameter("CERTIFICATE_FROM_DEPENDENT_EME") != null) {
				certificatefromeme = request
						.getParameter("CERTIFICATE_FROM_DEPENDENT_EME");
			}
			if (request.getParameter(NOMENCLATURE) != null) {
				itemId = Integer.parseInt(request.getParameter(NOMENCLATURE));
			}
			if (request.getParameter(PVMS_NO) != null) {
				pvmsNo = request.getParameter(PVMS_NO);
			}
			if (request.getParameter(SERIAL_NUMBER) != null) {
				serialNo = request.getParameter(SERIAL_NUMBER);
			}
			if (request.getParameter(BREAKDOWN_REPAIR_CHARGES) != null) {
				breakdownrepaircharges = (request
						.getParameter(BREAKDOWN_REPAIR_CHARGES));
			}
			if (request.getParameter(AU) != null) {
				au = (request.getParameter(AU));
			}
			if (request.getParameter(REASONABLENESS_OF_COST) != null) {
				reasonablenesscost = (request
						.getParameter(REASONABLENESS_OF_COST));
				BigDecimal val = new BigDecimal(reasonablenesscost);
				reasonablecost = val;
			}
			if (request.getParameter(QUANTITY) != null) {
				quantity = Integer.parseInt((request.getParameter(QUANTITY)));
			}

			if (request.getParameter(COST_OF_REPAIR) != null
					&& request.getParameter(COST_OF_REPAIR) != "") {
				costOfRepair = (request.getParameter(COST_OF_REPAIR));

			}
			if (request.getParameter(NUMBER_OF_TIMES_EQPT_WENT_OUT) != null) {
				nuumberoftimeseqpt = (request
						.getParameter(NUMBER_OF_TIMES_EQPT_WENT_OUT));
			}
			if (request.getParameter(CRV) != null) {
				crv = (request.getParameter(CRV));
			}
			if (request.getParameter(SOURCE_OF_RECIEPT) != null) {
				sourceofreciept = (request.getParameter(SOURCE_OF_RECIEPT));
			}
			if (request.getParameter(AMC_ENTERED_LAST_TIME) != null) {
				amceneteredlasttime = (request
						.getParameter(AMC_ENTERED_LAST_TIME));
			}
			if (request.getParameter(QUANTITY_HELD_WITH_CONDITION) != null) {
				quantitycondition = (request
						.getParameter(QUANTITY_HELD_WITH_CONDITION));
			}
			if (request.getParameter(QUANTITY_REQUIRED_TO_BE_REPAIRED) != null) {
				quantityrequired = Integer.parseInt(request
						.getParameter(QUANTITY_REQUIRED_TO_BE_REPAIRED));
			}
			if (request.getParameter(NATURE_OF_REPAIR) != null) {
				natureofrepair = (request.getParameter(NATURE_OF_REPAIR));
			}
			if (request.getParameter(COST) != null) {
				cost = (request.getParameter(COST));
				BigDecimal val = new BigDecimal(cost);
				costofEquipment = val;
			}
			if (request.getParameter(COMPARATIVE_STATEMENT_OF_QUATATIONS) != null) {
				compartivequatations = request
						.getParameter(COMPARATIVE_STATEMENT_OF_QUATATIONS);
			}
			if (request.getParameter(REASON_FOR_RECOMMENDING) != null) {
				reasonforrecommending = request
						.getParameter(REASON_FOR_RECOMMENDING);
			}
			try {

				storeRepairCivilFirm = new StoreRepairCivilFirm();
				MasStoreItem storeItem = new MasStoreItem();
				storeItem.setId(itemId);
				storeRepairCivilFirm.setRepairNo(repairNo);
				storeRepairCivilFirm.setId(id);
				storeRepairCivilFirm.setRepairDate(repdate);
				storeRepairCivilFirm.setSerialNo(serialNo);
				storeRepairCivilFirm.setItem(storeItem);
				storeRepairCivilFirm.setCrvNo(crv);
				storeRepairCivilFirm.setQty(quantity);
				storeRepairCivilFirm.setSourceOfReceipt(sourceofreciept);
				storeRepairCivilFirm.setLastChgBy(userid);
				storeRepairCivilFirm.setLastChgDate(lastChgDate);
				storeRepairCivilFirm.setLastChgTime(time);
				storeRepairCivilFirm.setConditionOfItem(quantitycondition);
				storeRepairCivilFirm.setQtyRepair(quantityrequired);
				storeRepairCivilFirm.setBlrBerCertificate(certificatefromeme);
				storeRepairCivilFirm
						.setComparativeStatOfQuotation(compartivequatations);
				storeRepairCivilFirm.setCostOfEquipment(costofEquipment);
				storeRepairCivilFirm.setCostOfRepair(costOfRepair);
				storeRepairCivilFirm.setDepartment(masDepartment);
				storeRepairCivilFirm.setHospital(masHospital);
				storeRepairCivilFirm.setLastCostOfRepair(amceneteredlasttime);
				storeRepairCivilFirm.setNatureOfRepair(natureofrepair);
				storeRepairCivilFirm.setNoOfTimeOutorder(nuumberoftimeseqpt);
				storeRepairCivilFirm.setRepairBreakdown(breakdownrepaircharges);
				storeRepairCivilFirm.setReasonableOfRepairCost(reasonablecost);
				storeRepairCivilFirm
						.setReasonForRecommend(reasonforrecommending);
				storeRepairCivilFirm.setStatus("Y");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		try {
			map = nonExpendableStoresHandlerService
					.updateStoreRepairCivilFirm(storeRepairCivilFirm);

		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = SHOW_AMC_REPAIR_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchAmcRepair(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int nomenclatureId = 0;
		String repairNO = "";
		List<MasStoreItem> nomenclatureList = new ArrayList<MasStoreItem>();
		List<StoreRepairCivilFirm> storerepairList = new ArrayList<StoreRepairCivilFirm>();
		Integer departmentId = null;
		session = request.getSession();
		departmentId = (Integer) session.getAttribute("deptId");
		map = nonExpendableStoresHandlerService.getNomenclature(departmentId);
		List<String> repairNoList = new ArrayList<String>();
		repairNoList = nonExpendableStoresHandlerService.getRepairNoList();
		if (map.get("nomenclatureList") != null)
			nomenclatureList = (List) map.get("nomenclatureList");
		if (request.getParameter("searchNomenclature") != null
				&& request.getParameter("searchNomenclature") != "") {
			nomenclatureId = Integer.parseInt(request
					.getParameter("searchNomenclature"));
		}

		if (request.getParameter("repairNo") != null
				&& request.getParameter("repairNo") != "") {
			repairNO = request.getParameter("repairNo");

		}
		map = nonExpendableStoresHandlerService.getAmcRepairDetails(
				nomenclatureId, repairNO);
		storerepairList = nonExpendableStoresHandlerService.getRepairNo();
		jsp = SHOW_AMC_REPAIR_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("repairNoList", repairNoList);
		map.put("title", title);
		map.put("nomenclatureList", nomenclatureList);
		map.put("storerepairList", storerepairList);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showBoardofSurveyJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}

		map = nonExpendableStoresHandlerService.showBoardOfSurvey();
		jsp = SHOW_BOARD_OF_SURVEY_JSP;
		jsp = jsp + ".jsp";
		title = "Board Of Survey";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView createAndImportBosData(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = nonExpendableStoresHandlerService.createAndImportBosData(box);
		jsp = SHOW_BOARD_OF_SURVEY_JSP;
		jsp = jsp + ".jsp";
		title = "Board Of Survey";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateGridItemsBos(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("updateGridItemsBos------->");
		Box box = HMSUtil.getBox(request);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		boolean flag = false;
		String message ="";
		flag = nonExpendableStoresHandlerService.updateGridItemsBos(box);
		
		if(flag)
		{
			message="Data Save Successfully";
		}
		else
		{ System.out.println("else");
			message="Data Save Successfully";
		}
		//jsp = SHOW_BOARD_OF_SURVEY_SEARCH_JSP;
		//jsp = SHOW_BOARD_OF_SURVEY_JSP;
		 jsp = "messageForBoardOfSurvey";
		jsp += ".jsp";
		title = "Board Of Survey";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchBosData(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String BosNo = request.getParameter(BOS_ID);
		map = nonExpendableStoresHandlerService.searchBosData(BosNo, box);
		jsp = SHOW_BOARD_OF_SURVEY_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateSearchGridItemsBos(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean updategrid = false;
		Box box = HMSUtil.getBox(request);
		map = nonExpendableStoresHandlerService.updateSearchGridItemsBos(box);
		jsp = SHOW_BOARD_OF_SURVEY_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getBosData(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		// Session-----
		session = request.getSession();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		// --------------------------------------------------------------------------------
		Box box = HMSUtil.getBox(request);
		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
		map = nonExpendableStoresHandlerService.getBosData(box);
		jsp = SHOW_BOARD_OF_SURVEY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printBoardOfSurvey(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String bosNo = "";
		int deptId = 0;
		String subPath = "";
		File reportFile = new File(getServletContext().getRealPath("/reports/"));
		if (request.getParameter(BOS_ID) != null) {
			bosNo = request.getParameter(BOS_ID);
		}
		if (request.getParameter("deptId") != null) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
		}
		detailsMap = nonExpendableStoresHandlerService.getConnectionForReport();
		parameters.put("Bos_No", bosNo);
		parameters.put("Dept_Id", deptId);
		subPath = reportFile.toString();
		parameters.put("SUBREPORT_DIR", subPath);
		try {
			byte bytes[] = null;
			try {
				bytes = JasperRunManager
						.runReportToPdf(
								getCompiledReport("NonExpendableMedicalStoresUnderBoardOfSurvey"),
								parameters, (Connection) detailsMap.get("con"));
			} catch (JRException e) {
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
				e.printStackTrace();
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index");

	}

	// ===================================================================================
	// =============== end of methods by hitesh
	// ======================================
	// ====================================================================================

	// *********************************************************************************************************************
	// ------------------------------------Start of Methods Written By Anand &
	// Vivek ------------------------------------------
	// ****************************************************************************************************************

	// ============================Start of ME Scale Equipment
	// Details==============================
	public ModelAndView deleteMeScaleItems(HttpServletRequest request,
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
		Box box = HMSUtil.getBox(request);
		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
		map = nonExpendableStoresHandlerService.deleteMeScaleItems(box);
		jsp = VIEW_ME_SCALE_JSP;
		jsp += ".jsp";
		title = "MMF Deletion ";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView viewMeScaleAdditionJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int meScaleMasterId = Integer.parseInt(box.get("meScaleMasterId"));
		// map = nonExpendableStoresHandlerService.getItemDetails(box);
		jsp = VIEW_ME_SCALE_ADDITION_JSP;
		map.put("contentJsp", jsp);
		map.put("meScaleMasterId", meScaleMasterId);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView addItemToMeScale(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
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
		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);

		map = nonExpendableStoresHandlerService.addItemToMeScale(box);
		jsp = VIEW_ME_SCALE_ADDITION_JSP;
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView searchItemsForMEScale(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
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
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		box.put("hospitalId", hospitalId);
		box.put("deptId", deptId);

		map = nonExpendableStoresHandlerService.searchItemsForMEScale(box);
		jsp = VIEW_ME_SCALE_ADDITION_JSP;
		title = "MMF Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getMeScaleDescription(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
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

		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int meScaleNumber = 0;
		String meScaleDescription = "";
		meScaleNumber = Integer.parseInt(request.getParameter(ME_SCALE_NUMBER));
		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
		map = nonExpendableStoresHandlerService.getMeScaleDescription(
				meScaleNumber, box);
		String meScaleDesc = "";
		meScaleDesc = "" + map.get("meScaleDesc");
		box.put("meScaleDesc", meScaleDesc);
		box.put("meScaleNumber", meScaleNumber);
		map.put("box", box);

		jsp = VIEW_ME_SCALE_JSP;
		jsp += ".jsp";
		map.put("title", title);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView getMeScaleData(HttpServletRequest request,
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

		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int meScaleNumber = 0;
		String meScaleDescription = "";
		meScaleNumber = Integer.parseInt(request.getParameter(ME_SCALE_NUMBER));
		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
		map = nonExpendableStoresHandlerService.getMeScaleData(box);
		String meScaleDesc = "";
		meScaleDesc = "" + map.get("meScaleDesc");
		box.put("meScaleDesc", meScaleDesc);
		box.put("meScaleNumber", meScaleNumber);
		map.put("box", box);

		jsp = VIEW_ME_SCALE_JSP;
		jsp += ".jsp";
		map.put("title", title);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateGridItemsInViewMeScale(
			HttpServletRequest request, HttpServletResponse response) {
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
		boolean flag = false;
		String messageTOBeVisibleToTheUser = "";
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		box.put("deptId", deptId);
		map = nonExpendableStoresHandlerService
				.updateGridItemsInViewMeScale(box);
		String meScaleDesc = "";
		meScaleDesc = "" + map.get("meScaleDesc");
		box.put("meScaleDesc", meScaleDesc);
		map.put("box", box);
		jsp = VIEW_ME_SCALE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView viewMeScaleJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);

		map = nonExpendableStoresHandlerService.viewMeScaleJsp();
		jsp = VIEW_ME_SCALE_JSP;
		jsp += ".jsp";
		title = "ViewMeScale";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}


	public ModelAndView showWorkRegisterReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = nonExpendableStoresHandlerService.showWorkRegisterReportJsp();
		String pvmsNo = "";
		if (request.getParameter(PVMS_NO) != null) {
			pvmsNo = request.getParameter(PVMS_NO);

		}
		title = "Work Order Register Report";
		jsp = WORK_ORDER_REGISTER_REPORT_JSP;
		jsp = jsp + ".jsp";
		map.put("pvmsNo", pvmsNo);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateWorkRegisterReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String pvmsNo = "";
		int hospitalId = 0;
		String hospitalName = "";
		session = request.getSession();
		requestParameters.put("DEPART", session.getAttribute("deptId"));
		try {

			// if(session.getAttribute("hospitalId") != null)
			// {
			// hospitalId = (Integer)session.getAttribute("hospitalId");
			// hospitalName = storesHandlerService.getHospitalName(hospitalId);
			// requestParameters.put("HOSP_NAME", hospitalName);
			// }

			if (request.getParameter(FROM_DATE) != null && !(request.getParameter(FROM_DATE).equals(""))) 
			{
				fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
				
				requestParameters.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) 
			{
				toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
				
				requestParameters.put("toDate", toDate);
			}
			if ((request.getParameter(PVMS_NO)) != null && !(request.getParameter(PVMS_NO).equals(""))) 
			{
				pvmsNo = (request.getParameter(PVMS_NO));
				
				requestParameters.put("pvmsNo", pvmsNo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = storesHandlerService.getConnectionForReport();
		
		try
		{
		HMSUtil.generateReport("workOrderAnalyticalReport", requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showReceiptRegisterReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Receipt Register Report";
		jsp = RECEIPT_REGISTER_REPORT_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showInternalIssueReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Internal Issue Report";
		jsp = INTERNAL_ISSUE_REPORT_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateInternalIssueReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		int hospitalId = 0;
		String hospitalName = "";

		session = request.getSession();
		requestParameters.put("DEPART", session.getAttribute("deptId"));
		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("FROM_DATE", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("TO_DATE", toDate);
			}
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				// hospitalName =
				// storesHandlerService.getHospitalName(hospitalId);
				requestParameters.put("HOSP_NAME", hospitalName);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = storesHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport(INTERNAL_ISSUE_REPORT, requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateActualStockReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		int hospitalId = 0;
		int departmentId = 0;
		

		session = request.getSession();
		try {

			if (session.getAttribute("departmentId") != null) {
				departmentId = (Integer) session.getAttribute("departmentId");
				
				requestParameters.put("departmentId", departmentId);
			}
			
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				
				requestParameters.put("hospital_id", hospitalId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

Map<String, Object> connectionMap = storesHandlerService.getConnectionForReport();

HMSUtil.generateReport("Actual_stock_Register", requestParameters, (Connection) connectionMap.get("con"), response, getServletContext());
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateReceiptRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		int hospitalId = 0;
		String hospitalName = "";

		session = request.getSession();
		requestParameters.put("DEPART", session.getAttribute("deptId"));
		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				// hospitalName =
				// storesHandlerService.getHospitalName(hospitalId);
				requestParameters.put("HOSP_NAME", hospitalName);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("FROM_DATE", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("TO_DATE", toDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = storesHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport(RECEIPT_REGISTER_REPORT, requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showSocReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "SOC Report";
		jsp = SOC_REPORT_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateSocReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		int hospitalId = 0;
		String hospitalName = "";

		session = request.getSession();
		requestParameters.put("DEPART", session.getAttribute("deptId"));
		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				// hospitalName =
				// storesHandlerService.getHospitalName(hospitalId);
				requestParameters.put("HOSP_NAME", hospitalName);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("From_Date", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("To_Date", toDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = storesHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport(SOC_REGISTER_REPORT, requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateNewWorkRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String workOrderNo = "";
		String workOrderNoForFormate = "";
		int hospitalId = 0;
		int count=0;
		String hospitalName = "";
		session = request.getSession();
		requestParameters.put("DEPART", session.getAttribute("deptId"));
		try {
			
			if ((request.getParameter(WORK_ORDER_NO)) != null
					&& !(request.getParameter(WORK_ORDER_NO).equals(""))) {
				workOrderNo = (request.getParameter(WORK_ORDER_NO));
				count=nonExpendableStoresHandlerService.countNo(workOrderNo);
				
				workOrderNoForFormate="1711/WO/"+workOrderNo;
				requestParameters.put("WORK_ORDER_NO", workOrderNo);
				requestParameters.put("workOrderNoForFormate", workOrderNoForFormate);
			}

		
		
		String NoOfItem=typeConversion.convertNumber11(""+count);
		//NoOfItem="(Item "+NoOfItem+" Only)";
		requestParameters.put("NoOfItem", NoOfItem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> connectionMap = storesHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport(WORK_ORDER_REGISTER_NEW_REPORT,
				requestParameters, (Connection) connectionMap.get("con"),
				response, getServletContext());
		return new ModelAndView("index", "map", map);
	}

	// ============================end of reports by abha

	// ============================Start of reports by Mansi

	public ModelAndView printAMCRepairJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String repairNo = null;
		session = request.getSession();
		requestParameters.put("Dept_Id", session.getAttribute("deptId"));
		try {
			if (request.getParameter("repairno") != null
					&& !(request.getParameter("repairno").equals(""))) {
				repairNo = request.getParameter("repairno");
				requestParameters.put("Repair_No", repairNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = storesHandlerService
				.getConnectionForReport();
		byte[] bytes = null;

		try {
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport(AMC_REPAIR_REPORT), requestParameters,
					(Connection) connectionMap.get("con"));
		} catch (JRException e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment; filename="
				+ AMC_REPAIR_REPORT + ".pdf");
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

	
	
	
	public ModelAndView getItemListForGrnByAutocompleteForNnExpendableGrn(
			HttpServletRequest request, HttpServletResponse response) {

		Box box = HMSUtil.getBox(request);
		String sos = box.getString("sourceOfSupply").trim();
		String itemNameField = "";
		String autoHint = "";
		String userName="";
		int indentId = 0;
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
		if (request.getParameter("requiredField") != null) {
			itemNameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(itemNameField) != null) {
			autoHint = (request.getParameter(itemNameField));
		}
		if (sos.equalsIgnoreCase("p") || (sos.equalsIgnoreCase("l"))
				|| (sos.equalsIgnoreCase("a"))) {
			if (request.getParameter("indentId") != null) {
				indentId = Integer.parseInt((request.getParameter("indentId")));
			}
		}
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		dataMap.put("autoHint", autoHint);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("indentId", indentId);
		dataMap.put("box", box);
		map = nonExpendableStoresHandlerService.getItemListForGrnByAutocompleteForNnExpendableGrn(dataMap);
		jsp = "result";
		return new ModelAndView(jsp, "map", map);
	}
	
	
	public ModelAndView responseNeGrnForIndent(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String choice = "";
		if (request.getParameter(SOURCE_OF_SUPPLY) != null) {
			choice = request.getParameter(SOURCE_OF_SUPPLY);
		}
		map = (Map<String, Object>) nonExpendableStoresHandlerService
				.getListForNeGrn(choice);
		jsp = INDENT_RESPONSE_JSP_FOR_NE_GRN;
		return new ModelAndView(jsp, "map", map);
	}

	
	public ModelAndView showOnchangeJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String,Object>map=new HashMap<String, Object>();
		jsp="onchangeJsp";
		
		jsp = jsp + ".jsp";
		title = "GRN";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
		
	}
	
	
	
	
	public void fillItemsForManufacturer(HttpServletRequest request,
			HttpServletResponse response) {
		
		session = request.getSession();
		int deptId = 0;
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		Box box = HMSUtil.getBox(request);
		int poId = box.getInt("poId");
		String itemNameField = "";
		int itemId  = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("requiredField") != null) {
			itemId = Integer.parseInt(request.getParameter("requiredField"));
		}
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<StorePoDetail> poList = new ArrayList<StorePoDetail>();
		dataMap.put("itemId", itemId);
		dataMap.put("deptId", deptId);
		dataMap.put("poId", poId);
		map = nonExpendableStoresHandlerService.fillItemsForGrn(dataMap);
		
		if (map.get("brandList") != null) {
			brandList = (List) map.get("brandList");
		}
		int manufacturerId=0;
		String manufacturerName="";
		if(brandList.size()>0)
		{
			manufacturerId=brandList.get(0).getManufacturer().getId();
			manufacturerName=brandList.get(0).getManufacturer().getManufacturerName();
		}

		StringBuffer sb = new StringBuffer();
		try {
				sb.append("<brands>");
				
					
					
					sb.append("<manufacturerId>"
							+ manufacturerId
							+ "</manufacturerId>");
					sb.append("<manufacturerName>"
							+ manufacturerName
							+ "</manufacturerName>");
					
				
				sb.append("</brands>");
				

			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// return new ModelAndView(jsp, "map", map);
	}
	
	
	
	
	
	public ModelAndView printNeGrnReport(HttpServletRequest request, HttpServletResponse response)
	{
		Box box = HMSUtil.getBox(request);
		Map<String, Object> datamap = new HashMap<String, Object>();
	
		session = request.getSession();
		int deptId = Integer.parseInt(session.getAttribute("deptId").toString());
		String deptName = (String)session.getAttribute("deptName");;
		map = nonExpendableStoresHandlerService.getConnectionForReport();
		String sourceOfSupply = "";
		String grnNo="";
		
	
		
		String note = "";
		if(box.get(SOURCE_OF_SUPPLY)!= null){
			sourceOfSupply =(String)box.get(SOURCE_OF_SUPPLY);
		}
		if(box.get(GRN_NO)!= null){
			grnNo =(String)box.get(GRN_NO);
		}
       
		
	
		
		
		map.put("grnNo",grnNo );
		map.put("deptId",deptId);
		 
  	  
		if(sourceOfSupply.equalsIgnoreCase("d")){
			
			HMSUtil.generateReport("AFMSD_NON_EXPENDABLE", map, (Connection)map.get("con"), response, getServletContext());
					
		}
		
		
		if(sourceOfSupply.equalsIgnoreCase("m")){
			
			HMSUtil.generateReport("Modernization_Non_Expendable_Grn", map, (Connection)map.get("con"), response, getServletContext());
					
		}
		
		if(sourceOfSupply.equalsIgnoreCase("p")){
			
			HMSUtil.generateReport("Modernization_Non_Expendable_Grn", map, (Connection)map.get("con"), response, getServletContext());
					
		}
		
		if(sourceOfSupply.equalsIgnoreCase("s")){
			
			HMSUtil.generateReport("Modernization_Non_Expendable_Grn", map, (Connection)map.get("con"), response, getServletContext());
					
		}
		
		if(sourceOfSupply.equalsIgnoreCase("g")){
			
			HMSUtil.generateReport("Modernization_Non_Expendable_Grn", map, (Connection)map.get("con"), response, getServletContext());
					
		}
		
		
		
		return null;
	}
	
	
	
	// Methods for show Insatallation Certificate Form By Tirath**********************************//
	
	
	public ModelAndView showInstallationCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		session = request.getSession();

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = nonExpendableStoresHandlerService.showInstallationCertificate(dataMap);
		//jsp = NE_GRN_JSP;
		jsp=INSTALLATION_CERTIFICATE_JSP;
		jsp = jsp + ".jsp";
		title = "GRN";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView responseNomenclature(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		int grnMId=0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		session = request.getSession();

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		if(request.getParameter("grnId")!=null)
		{
			grnMId=Integer.parseInt(request.getParameter("grnId"));
		}
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("grnMId", grnMId);

		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = nonExpendableStoresHandlerService.responseNomenclature(dataMap);
		//jsp = NE_GRN_JSP;
		jsp="responseInstalationCertificateJsp";
		//jsp = jsp + ".jsp";
		title = "GRN";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView updateInstallationDate(HttpServletRequest request,
			HttpServletResponse response)  {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		int grnMId=0;
		Date installationDate=null;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		session = request.getSession();
		
		try
		{
		SimpleDateFormat formatterIn = new SimpleDateFormat(
		"dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat(
		"yyyy-MM-dd");
		String date4MySQL = formatterOut.format(formatterIn.parse(request.getParameter(GRN_DATE)));
		installationDate = java.sql.Date.valueOf(date4MySQL);
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		if(request.getParameter(GRN_NO)!=null)
		{
			grnMId=Integer.parseInt(request.getParameter(GRN_NO));
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("installationDate", installationDate);
		dataMap.put("grnMId", grnMId);

		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		String messageTOBeVisibleToTheUser="";
		map = nonExpendableStoresHandlerService.updateInstallationDate(dataMap);
		if(map.get("flag").equals(true))
		{
			messageTOBeVisibleToTheUser="Installation Certificate Succefully Update!!";
		}
		else
		{
			messageTOBeVisibleToTheUser="Try Again!!";
		}
		jsp="messageForInstallationUpdateJsp";
		jsp += ".jsp";
		String url = "";
		url = "/hms/hms/neStores?method=showNeGrnJsp";
		map.put("grnMId", grnMId);
		map.put("contentJsp", jsp);
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView("index", "map", map);
	}
	
	/*******************************************--End--*******************************************/
	
	
	public ModelAndView showInitialDeficiencyIndentJspDepot(HttpServletRequest request,
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
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		Map<String, Object> map = new HashMap<String, Object>();
		map = nonExpendableStoresHandlerService.showInitialDeficiencyIndentJspDepot(dataMap);
		jsp = INITIAL_DEFICIENCY_INDENT_TO_DEPOT_JSP;
		jsp = jsp + ".jsp";
		title = "Indent";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}
	
	
	
	public void fillItemsForIndentToDepot(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
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
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String pvmsNo = "";
		List objectList = new ArrayList();
		try {
			if (request.getParameter("pvmsNo") != null) {
				pvmsNo = request.getParameter("pvmsNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		dataMap.put("pvmsNo", pvmsNo);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		map = nonExpendableStoresHandlerService.fillItemsForIndentToDepot(dataMap);
		if (map.get("objectList") != null) {
			objectList = (List) map.get("objectList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
				Object[] object = (Object[]) iterator.next();

				sb.append("<item>");
				sb.append("<id>" + object[0] + "</id>");
				sb.append("<pvms>" + object[1] + "</pvms>");
				if ((object[6] == null) || (object[6].equals("")))
					sb.append("<oldPvms>" + 0 + "</oldPvms>");
				else
					sb.append("<oldPvms>" + object[6] + "</oldPvms>");
				sb.append("<au>" + object[8] + "</au>");
				if (object[4] == null)
					sb.append("<stock>" + 0 + "</stock>");
				else
					sb.append("<stock>" + new BigDecimal("" + object[4])
							+ "</stock>");
				if (object[5] == null)
					sb.append("<qtyInMMF>" + 0 + "</qtyInMMF>");
				else
					sb.append("<qtyInMMF>" + new BigDecimal("" + object[5])
							+ "</qtyInMMF>");

				if (object[9] == null)
					sb.append("<section>" + 0 + "</section>");
				else
					sb.append("<section>" + object[9] + "</section>");
				sb.append("</item>");
			}
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

		// return new ModelAndView(jsp, "map", map);
	}
	
	
	
	public ModelAndView addNextOrSubmitIndentToDepot(
			HttpServletRequest request, HttpServletResponse response) {
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
		StoreIndentM storeIndentM = new StoreIndentM();
		@SuppressWarnings("unused")
		StoreIndentT storeIndentT = new StoreIndentT();
		String indentFrom = "";
		@SuppressWarnings("unused")
		Date indentDate = null;
		int supplyDepot = 0;
		@SuppressWarnings("unused")
		int sectionId = 12;
		String nrs = "";
		int rows = 0;
		@SuppressWarnings("unused")
		String indentType = "d";
		int departmentId = 1;
		String encodedBy = "";
		Date encodedDate = null;
		String lastChgBy = "";
		@SuppressWarnings("unused")
		Date lastChgDate = null;
		String lastChgTime = "";
		String indentOption = "";
		String patientDetails = "";
		String justificationNiv = "";
		String pacJustification = "";
		String pacForeignAdd = "";
		String authority = "";
		String buttonName = "";
		int indentId = 0;
		int serialNo = 0;
		int itemId = 1;
		int stockIn = 0;
		int qtyInDemand = 0;
		int qtyInMmf = 0;
		int qtyReceived = 0;
		int radioVal = 0;
		int noOfRows = 0;
		BigDecimal unitRate = null;
		String brandName = "";
		int manufactureId = 1;
		String marketedBy = "";
		BigDecimal totalCost = null;
		Date lastReceiptDate = null;
		BigDecimal lastReceiptQty = null;
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String successfullyAdded = "no";
		int pageNo = 1;
		String url = "";
		String url1 = "";
		String printUrl = "";
		int mmfForTheYear = 0;
		String indentNo = "";
		String address = "";
		try {
			if (request.getParameter("buttonName") != null) {
				buttonName = request.getParameter("buttonName");
			}
			if (request.getParameter(INDENT_ID) != null) {
				indentId = Integer.parseInt(request.getParameter(INDENT_ID));
			}

			if (request.getParameter(CHANGED_DATE) != null) {
				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(request.getParameter(CHANGED_DATE)));
				lastChgDate = java.sql.Date.valueOf(date4MySQL);
			}
			if (request.getParameter(CHANGED_BY) != null) {
				lastChgBy = request.getParameter(CHANGED_BY);
			}
			if (request.getParameter(CHANGED_TIME) != null) {
				lastChgTime = request.getParameter(CHANGED_TIME);
			}

			if (request.getParameter(NO_OF_ROWS) != null) {
				noOfRows = Integer.parseInt(request.getParameter(NO_OF_ROWS));
			}
			if (request.getParameter("pageNo") != null) {
				pageNo = Integer.parseInt(request.getParameter("pageNo"));
			}

			if (request.getParameter(INDENT_NO) != null) {
				indentNo = (request.getParameter(INDENT_NO));
			}
			if (request.getParameter(TYPE_OF_INDENT) != null) {
				indentOption = (request.getParameter(TYPE_OF_INDENT));
			}
			if (request.getParameter(INDENT_FROM) != null) {
				indentFrom = (request.getParameter(INDENT_FROM));
			}
			if (request.getParameter(SUPPLY_DEPOT) != null) {
				supplyDepot = Integer.parseInt(request
						.getParameter(SUPPLY_DEPOT));
			}
			if (request.getParameter(INDENT_DATE) != null) {
				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(request.getParameter(INDENT_DATE)));
				indentDate = java.sql.Date.valueOf(date4MySQL);
			}
			if (request.getParameter(NRS) != null) {
				nrs = (request.getParameter(NRS));
			}
			if (request.getParameter(SECTION_ID) != null) {
				sectionId = Integer.parseInt(""
						+ request.getParameter(SECTION_ID));
			}
			if (request.getParameter(AUTHORITY) != null) {
				authority = (request.getParameter(AUTHORITY));
			}
			if (request.getParameter(ADDRESS) != null) {
				address = (request.getParameter(ADDRESS));
			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		String headerStored = "no";

		if (pageNo == 1) {
			try {
				storeIndentM.setIndentNo(indentNo);
				storeIndentM.setIndentDate(indentDate);
				storeIndentM.setRequiredForm(indentFrom);
				MasStoreAirForceDepot masStoreSupplier = new MasStoreAirForceDepot();
				masStoreSupplier.setId(supplyDepot);
				storeIndentM.setSuppliedBy(masStoreSupplier);
				
				
				if(sectionId!=0){
					MasStoreSection masStoreSection = new MasStoreSection();
					masStoreSection.setId(sectionId);
					storeIndentM.setSection(masStoreSection);
					}
				storeIndentM.setNrs(nrs);
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				storeIndentM.setDepartment(masDepartment);
				storeIndentM.setIndentType(indentType);
				storeIndentM.setEncodedBy(encodedBy);
				storeIndentM.setEncodedDate(indentDate);
				storeIndentM.setLastChgBy(lastChgBy);
				storeIndentM.setLastChgDate(indentDate);
				storeIndentM.setLastChgTime(lastChgTime);
				storeIndentM.setStatus("o");
				storeIndentM.setIndentOption(indentOption);

				storeIndentM.setPatientDetails(patientDetails);
				storeIndentM.setJustificationNiv(justificationNiv);
				storeIndentM.setPacJustification(pacJustification);
				storeIndentM.setPacForeignAdd(pacForeignAdd);
				storeIndentM.setAuthority(authority);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				storeIndentM.setHospital(masHospital);
				storeIndentM.setMmfForTheYear(mmfForTheYear);
				storeIndentM.setIndentNo(indentNo);
				storeIndentM.setImported("n");
				storeIndentM.setPatientDetails(address);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			headerStored = "yes";
			infoMap.put("headerStored", headerStored);
		}

		int length = 0;
		List<StoreIndentT> storeIndentTlist = new ArrayList<StoreIndentT>(10);
		try {
			int srNo[] = JKTRequestUtils.getRequiredIntParameters(request,
					SR_NO);
			int departmentArray[] = JKTRequestUtils.getRequiredIntParameters(
					request, DEPARTMENT_ID_TEMP);
			int itemIdArray[] = JKTRequestUtils.getRequiredIntParameters(
					request, ITEM_ID);
			String qtyInHandStringArray[] = JKTRequestUtils
					.getRequiredStringParameters(request, QTY_IN_HAND);
			String qtyInMmfStringArray[] = JKTRequestUtils
					.getRequiredStringParameters(request, QTY_IN_MMF);
			String qtyDemandStringArray[] = JKTRequestUtils
					.getRequiredStringParameters(request, QTY_DEMAND);
			BigDecimal[] qtyInHandArray = new BigDecimal[10];
			BigDecimal[] qtyDemandArray = new BigDecimal[10];
			BigDecimal[] qtyInMmfArray = new BigDecimal[10];
			int xxLegnt = qtyInHandStringArray.length;

			for (int i = 0; i < xxLegnt; i++) {
				BigDecimal val = new BigDecimal(qtyInMmfStringArray[i]);
				qtyInMmfArray[i] = val;
			}
			for (int i = 0; i < xxLegnt; i++) {
				BigDecimal val = new BigDecimal(qtyDemandStringArray[i]);
				
				qtyDemandArray[i] = val;
			}
			for (int i = 0; i < xxLegnt; i++) {
				BigDecimal val = new BigDecimal(qtyInHandStringArray[i]);
				qtyInHandArray[i] = val;
			}

			if (buttonName.equals("next")) {
				length = 8;
			} else {
				length = noOfRows;
			}
			for (int i = 0; i < length; i++) {

				if (itemIdArray[i] != 0) {
					StoreIndentT storeIndentTObj = new StoreIndentT();
					storeIndentTObj.setSerialNo(srNo[i]);

					MasStoreItem masItem = new MasStoreItem();
					masItem.setId(itemIdArray[i]);
					storeIndentTObj.setItem(masItem);
					// storeIndentTObj.setStockIn(qtyInHandArray[i]);

					storeIndentTObj.setQtyInMmf(qtyInMmfArray[i]);
					storeIndentTObj.setQtyInDemand(qtyDemandArray[i]);
					storeIndentTObj.setQtyReceived(null);

					storeIndentTObj.setSection(null);
					storeIndentTObj.setStockIn(qtyInHandArray[i]);
					storeIndentTObj.setUnitRate(unitRate);
					storeIndentTObj.setBrand(null);
					MasManufacturer manufacturer = new MasManufacturer();
					manufacturer.setId(manufactureId);
					storeIndentTObj.setManufacture(manufacturer);
					storeIndentTObj.setMarketedBy(marketedBy);
					storeIndentTObj.setTotalCost(totalCost);
					storeIndentTObj.setLastReceiptDate(lastReceiptDate);
					storeIndentTObj.setLastReceiptQty(lastReceiptQty);
					storeIndentTlist.add(storeIndentTObj);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			dataMap.put("storeIndentM", storeIndentM);
			dataMap.put("storeIndentTlist", storeIndentTlist);
			dataMap.put("pageNo", pageNo);
			dataMap.put("indentId", indentId);
			dataMap.put("indentNo", indentNo);
			dataMap.put("deptId", deptId);
			dataMap.put("hospitalId", hospitalId);
			map = (Map) nonExpendableStoresHandlerService
					.addNextOrSubmitIndentToDepot(dataMap);
			if (map.get("indentId") != null)
				indentId = Integer.parseInt("" + map.get("indentId"));

			if (map.get("successfullyAdded") != null)
				successfullyAdded = "" + map.get("successfullyAdded");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String messageTOBeVisibleToTheUser = "";
		if (successfullyAdded.equals("yes")) {
			messageTOBeVisibleToTheUser = "Indent To Depot Records Added Successfully";
		} else {
			messageTOBeVisibleToTheUser = "Indent To Depot Records are Not Added";
			map.put("messageType", "failure");
		}
		if (buttonName.equals("next")) {
			jsp = INITIAL_DEFICIENCY_INDENT_TO_DEPOT_JSP;
		} else {
			//jsp = STORES_MESSAGE_JSP;
			//url = "/hms/hms/neStores?method=showInitialDeficiencyIndentJspDepot";
			//url1 = "/hms/hms/neStores?method=printInitialDeficiencyReport";
			
			jsp = STORES_MESSAGE_NE_JSP ;
			url = "/hms/hms/neStores?method=showIndentToDepoNe";
			printUrl = "/hms/hms/neStores?method=printIndentTODepoNe&indentNo="+indentNo+"&deptId="+deptId;
		}
		pageNo = pageNo + 1;
		jsp += ".jsp";
		map.put("indentNo", indentNo);
		map.put(" indentFrom", indentFrom);
		map.put("indentDate", indentDate);
		map.put("supplyDepot", supplyDepot);
		map.put("sectionId", sectionId);
		map.put("indentOption", indentOption);
		map.put("nrs", nrs);
		map.put("authority", authority);
		map.put("address", address);
		map.put("indentOption", indentOption);
		map.put("pageNo", pageNo);
		map.put("contentJsp", jsp);
		map.put("url", url);
		map.put("url1", url1);
		map.put("printUrl", printUrl);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchIndentDepot(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {

		// ---- ----------- Retriving User Name,Hospital Id,Department Id from
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
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
		int pageNo = 1;
		jsp = "modifyInitialDifficiencyIndentJsp";
		jsp += ".jsp";
		int radio_str = 0;
		if (request.getParameter(INDENT_NO_FOR_SEARCH) != null) {
			radio_str = Integer.parseInt(request
					.getParameter(INDENT_NO_FOR_SEARCH));
			//map = (Map) storesHandlerService.getIndentModifyMapForDepot(radio_str, pageNo , deptId);
		}
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("radio_str", radio_str);

		return new ModelAndView("indexB", "map", map);

	}
	
	
	
	public ModelAndView printIndentDepotJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int indentId = 0;
		if ((request.getParameter(INDENT_ID) != null)
				&& !(request.getParameter(INDENT_ID).equals(""))) {
			indentId = Integer.parseInt(request.getParameter(INDENT_ID));
		}
		Map parameters = new HashMap();
		parameters = storesHandlerService.getIndentDepotPrintMap(indentId);
		try {
			parameters.put("indentId", indentId);
			byte[] bytes = null;

			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport("initialDeficiencyIndentDepot"), parameters,
					(Connection) parameters.get("conn"));
			response.setHeader("Content-Disposition", "attachment; filename="
					+ "initialDeficiencyIndentDepot" + ".pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream;

			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("indexB", "map", map);
	}
	
	
	
	public ModelAndView responseSupplierNoForNeGrn(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String choice = "";
		int supplierId=0;
		supplierId=Integer.parseInt(request.getParameter("supplierId"));
	dataMap.put("supplierId", supplierId);
	
			map = (Map<String, Object>) nonExpendableStoresHandlerService
			.getSupplierListForNeGrn(dataMap);
			//jsp = INDENT_RESPONSE_JSP_FOR_NE_GRN;
			jsp = SUPPLIER_RESPONSE_JSP;
		
		
		return new ModelAndView(jsp, "map", map);
	}

	
	public ModelAndView responseGridListForPO(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		String choice = "";
		
		if(request.getParameter("poId")!=null && !request.getParameter("poId").equals(""))
		{
		int poId=Integer.parseInt(request.getParameter("poId"));
		map=nonExpendableStoresHandlerService.getPoList(poId);
		}
		jsp = "gridForNe";
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView printInitialDeficiencyReport(HttpServletRequest request, HttpServletResponse response)
	{
		Box box = HMSUtil.getBox(request);
		Map<String, Object> datamap = new HashMap<String, Object>();
	
		session = request.getSession();
		int deptId = Integer.parseInt(session.getAttribute("deptId").toString());
		String deptName = (String)session.getAttribute("deptName");;
		map = nonExpendableStoresHandlerService.getConnectionForReport();
		String sourceOfSupply = "";
		String indentNo="";
		
	
		
		String note = "";
		if(box.get("indentNo")!= null){
			indentNo =(String)box.get("indentNo");
		}
		
       
		
	
		
		
		map.put("indentNo",indentNo );
		map.put("deptId",deptId);
		 
  	  
	
			
			HMSUtil.generateReport("InitialDeficiencyReport", map, (Connection)map.get("con"), response, getServletContext());
					
		
		
		
		
		return null;
	}
	
	
	// ============================End of reports by Mansi
	// =====================================
	
	
	//----------------------------Financial Master---------------------------------	
	@SuppressWarnings("unchecked")
	public ModelAndView showRepairStationJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();
		
		int hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
		dataMap.put("hospitalId", hospitalId);
		map = nonExpendableStoresHandlerService.showRepairStationJsp(dataMap);
		jsp = "repairStation";
		jsp+= ".jsp" ;
		title = "Repair Station";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);		 
	}
	
	
	
	public StoresHandlerService getStoresHandlerService() {
		return storesHandlerService;
	}

	public void setStoresHandlerService(
			StoresHandlerService storesHandlerService) {
		this.storesHandlerService = storesHandlerService;
	}

	public NonExpendableStoresHandlerService getNonExpendableStoresHandlerService() {
		return nonExpendableStoresHandlerService;
	}

	public void setNonExpendableStoresHandlerService(
			NonExpendableStoresHandlerService nonExpendableStoresHandlerService) {
		this.nonExpendableStoresHandlerService = nonExpendableStoresHandlerService;
	}
	
	public ModelAndView showEquipmentListAMCJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();
		
		int hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
		dataMap.put("hospitalId", hospitalId);
		map = nonExpendableStoresHandlerService.showRepairStationJsp(dataMap);
		jsp = "equipmentListAmc";
		jsp+= ".jsp" ;
		title = "Equipment List for AMC";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);		 
	}
	
	public ModelAndView showMeScaleListAMCJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();
		
		int hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
		dataMap.put("hospitalId", hospitalId);
		map = nonExpendableStoresHandlerService.showRepairStationJsp(dataMap);
		jsp = "meScaleList";
		jsp+= ".jsp" ;
		title = "ME Scale List";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);		 
	}	
	public ModelAndView showEquipmentLoanOutEntry(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String userName="";
		int deptId = 0;
		int hospitalId=0;
		session = request.getSession();		
		if(session.getAttribute("hospitalId") != null)
		{
		 hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
		}
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptId", deptId);
		map = nonExpendableStoresHandlerService.showRepairStationJsp(dataMap);
		jsp = "equipmentLoanoutEntry";
		jsp+= ".jsp" ;
		title = "EquipmentLoanOut";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);		 
	}	
	
	
	public ModelAndView showDistributionOfItemJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();
		
		int hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
		dataMap.put("hospitalId", hospitalId);
		map = nonExpendableStoresHandlerService.showRepairStationJsp(dataMap);
		jsp = "distributionOfItem";
		jsp+= ".jsp" ;
		title = "Distribution Of Item";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);		 
	}
	
	// add javed khan
	
	
	public ModelAndView responseGridListForDGAFMS(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		String choice = "";
		map=nonExpendableStoresHandlerService.getManuList();
		/*if(request.getParameter("poId")!=null && !request.getParameter("poId").equals(""))
		{
		int poId=Integer.parseInt(request.getParameter("poId"));
		map=nonExpendableStoresHandlerService.getPoList(poId);
		}*/
		jsp = "gridDGAFMSForNe";
		return new ModelAndView(jsp, "map", map);
	}
	//------Added By Dipali----
	public ModelAndView submitWorkOrder(HttpServletRequest request,HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		StoreWorkOrderM storeWorkOrderM = new StoreWorkOrderM();
		StoreWorkOrderT storeWorkOrderT = new StoreWorkOrderT();
		int workOrderId = 0;
		Date workOrderDate = new Date();
		String encodedBy = "";
		Date encodedDate = null;
		String lastChgBy = "A";
		Date lastChgDate = null;
		String lastChgTime = "";
		int departmentId = 0;
		String date = "";
		String time = "";
		int noOfRows = 0;
		int pageNo = 1;
		String buttonFlag = "";
		int repairingCell = 0;
		int hospitalId = 0;
		String workOrderNo = "";
		String authority = "";
		String  repairStation= "";
		int issueBy = 0;
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
		try {
			/*if (request.getParameter("pageNo") != null) {
				pageNo = Integer.parseInt(request.getParameter("pageNo"));

			}
			if (request.getParameter(NO_OF_ROWS) != null) {
				noOfRows = Integer.parseInt(request.getParameter(NO_OF_ROWS));
			}*/
			if (request.getParameter(WORK_ORDER_ID) != null) {
				workOrderId = Integer.parseInt(request
						.getParameter(WORK_ORDER_ID));

			}

			if (request.getParameter(AUTHORITY) != null) {
				authority = request.getParameter(AUTHORITY);
			}
			if (request.getParameter("issueBy") != null && !request.getParameter("issueBy").equals("")) {
				issueBy = Integer.parseInt(request.getParameter("issueBy"));
			}
			if (request.getParameter(WORK_ORDER_NO) != null) {
				workOrderNo = request.getParameter(WORK_ORDER_NO);
			}
			if (request.getParameter(REPAIRING_CELL) != null) {
				repairingCell = Integer.parseInt(request.getParameter(REPAIRING_CELL));
			}
			if(request.getParameter("repairStation") != null)
			{
				repairStation= (request.getParameter("repairStation"));
				System.out.println("repairStation in Controller"+repairStation);
			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}

		try {
			String te = "";

			if (request.getParameter(WORK_ORDER_DATE) != null) {
				te = (String) (request.getParameter(WORK_ORDER_DATE));

				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(request.getParameter(WORK_ORDER_DATE)));
				workOrderDate = java.sql.Date.valueOf(date4MySQL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		String headerStored = "no";
		MasRepairStation masRepairStation =new MasRepairStation();
		// if (pageNo == 1) {

			storeWorkOrderM.setAuthorityNo(authority);
		if(issueBy !=0){
		MasEmployee masEmployee=new MasEmployee();
		masEmployee.setId(issueBy);
		storeWorkOrderM.setIssuedBy(masEmployee);
		}
		if(repairingCell !=0){
			masRepairStation.setId(repairingCell);
			storeWorkOrderM.setRepairStation(masRepairStation);
		}
		
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);
			storeWorkOrderM.setDepartment(masDepartment);

			storeWorkOrderM.setWorkOrderDate(workOrderDate);
			storeWorkOrderM.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			storeWorkOrderM.setLastChgTime(time);
			storeWorkOrderM.setStatus("y");

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			storeWorkOrderM.setHospital(masHospital);

			storeWorkOrderM.setLastChgBy("admin");
			storeWorkOrderM.setStatus("o");
			storeWorkOrderM.setWorkOrderNo(workOrderNo);
			//storeWorkOrderM.setRepairStation(repairStation)
   infoMap.put("storeWorkOrderM", storeWorkOrderM);
		/*} else {
			headerStored = "yes";
			infoMap.put("headerStored", headerStored);
		}*/
		int length = 0;
		List<StoreWorkOrderT> storeWorkOrderTlist = new ArrayList<StoreWorkOrderT>();

		try {
			/*String srNo[] = JKTRequestUtils.getRequiredStringParameters(
					request, SR_NO);
			int itemIdArray[] = JKTRequestUtils.getRequiredIntParameters(
					request, ITEM_ID);
			String remarks[] = JKTRequestUtils.getRequiredStringParameters(
					request, REMARKS);
			String natureOfWork[] = JKTRequestUtils
					.getRequiredStringParameters(request, NATURE_OF_WORK);
			int quantityReceivedArray[] = JKTRequestUtils
					.getRequiredIntParameters(request, QUANTITY_RECEIVED);
			String batchNo[] = JKTRequestUtils.getRequiredStringParameters(
					request, BATCH_ID);*/

			/*
			if (buttonFlag.equals("next")) {
				// if(buttonFlag != null){
				length = 10;
			} else {
				length = noOfRows;
			}
			 */
			List<Integer> itemIdList = new ArrayList<Integer>();
			List<String> srList = new ArrayList<String>();
			List<String>  serialNoList = new ArrayList<String>();
			List<Integer> quantityList = new ArrayList<Integer>();
			List<String> natureOfWorkList = new ArrayList<String>();
			List<String> parEqptList = new ArrayList<String>();
			List<String> remarksList = new ArrayList<String>();
			
			int hdb = 1;
			if (Integer.parseInt(request.getParameter("gridSize")) != 1) {
				hdb = Integer.parseInt(request.getParameter("gridSize"));
				
			}
			int j = 1;
			for (int i = 0; i < hdb; i++)
			{ 
				String pvmsNo = "";
				int itemId = 0;
				if (request.getParameter(ITEM_ID+ j) != null && !request.getParameter(ITEM_ID + j).equals("0")) {

					itemId = Integer.parseInt(request.getParameter(ITEM_ID + j));
						itemIdList.add(itemId);
				}
				String srNo="";
				if (request.getParameter(SR_NO+ j) != null && !request.getParameter(SR_NO + j).equals("")) {

					srNo = request.getParameter(SR_NO + j);
					srList.add(srNo);
				}
				String serialNo ="";
				if(request.getParameter(SERIAL_NO + j) != null && !request.getParameter(SERIAL_NO + j).equals("")){
					serialNo =request.getParameter(SERIAL_NO + j);
					serialNoList.add(serialNo);
				int quantity = 0;
				if(request.getParameter(QUANTITY_RECEIVED+ j) != null && !request.getParameter(QUANTITY_RECEIVED + j).equals("")){
					quantity = Integer.parseInt(request.getParameter(QUANTITY_RECEIVED + j));
					quantityList.add(quantity);
				}else {
					quantityList.add(0);
				}

				String natureWork = "";
				if(request.getParameter(NATURE_OF_WORK + j) != null && !request.getParameter(NATURE_OF_WORK + j).equals("")){
					natureWork = request.getParameter(NATURE_OF_WORK + j);
					natureOfWorkList.add(natureWork);
				}	else {
					natureOfWorkList.add("");
				}
				
				String particularEqp = "";
				if(request.getParameter(PARTICULAR_EQPT + j) != null && !request.getParameter(PARTICULAR_EQPT + j).equals("")){
					particularEqp = request.getParameter(PARTICULAR_EQPT+ j);
					parEqptList.add(particularEqp);
				}else{
					parEqptList.add("");
				}
			
				String remarks = "";
				if(request.getParameter(REMARKS + j) != null && !request.getParameter(REMARKS + j).equals("")){
					remarks = request.getParameter(REMARKS+ j);
					remarksList.add(remarks);
				}else {
					remarksList.add("");
				}


				j++;
			}
			/*for (int i = 0; i < length; i++) {
				if (itemIdArray[i] != 0) {

					StoreWorkOrderT storeWOrderTObj = new StoreWorkOrderT();
					MasStoreItem masItem = new MasStoreItem();
					masItem.setId(itemIdArray[i]);
					storeWOrderTObj.setItem(masItem);

					storeWOrderTObj.setRemarks(remarks[i]);
					storeWOrderTObj.setSrNo(srNo[i]);
					storeWOrderTObj.setQuantity(quantityReceivedArray[i]);
					storeWOrderTObj.setNatureOfWork(natureOfWork[i]);
					storeWOrderTObj.setSerialNo(batchNo[i]);
					storeWorkOrderTlist.add(storeWOrderTObj);
				}*/
			}
			infoMap.put("itemIdList", itemIdList);
			infoMap.put("serialNoList", serialNoList);
			infoMap.put("quantityList", quantityList);
			infoMap.put("natureOfWorkList",natureOfWorkList);
			infoMap.put("parEqptList", parEqptList);
			infoMap.put("remarksList", remarksList);
			infoMap.put("srList",srList);
		//infoMap.put("pageNo", pageNo);
		infoMap.put("workOrderNo", workOrderNo);
		infoMap.put("workOrderId", workOrderId);
		infoMap.put("storeWorkOrderM", storeWorkOrderM);
		infoMap.put("repairStation",repairStation);
		///infoMap.put("storeWorkOrderTlist", storeWorkOrderTlist);
		infoMap.put("deptId", deptId);
		infoMap.put("hospitalId", hospitalId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean flag = false;
		try {
			flag = nonExpendableStoresHandlerService.addWorkOrder(infoMap);

		} catch (Exception e) {
		e.printStackTrace();
		}
		if (map.get("flag") != null) {
			flag = (Boolean) map.get("flag");
		}
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		String messageTOBeVisibleToTheUser = "";

		if (flag) {
			if (buttonFlag.equals("next")) {
				jsp = WORK_ORDER_JSP;
				pageNo++;
				map = nonExpendableStoresHandlerService.showWorkOrderJsp(box,
						dataMap);
				if (map.get("workOrderId") != null) {
					workOrderId = (Integer) map.get("workOrderId");
				}
				messageTOBeVisibleToTheUser = "Work Order  Entry has  been done Successfully";

			} else {
				map = nonExpendableStoresHandlerService.showWorkOrderJsp(box,
						dataMap);
				if (map.get("workOrderId") != null) {
					workOrderId = (Integer) map.get("workOrderId");
				}
				map = nonExpendableStoresHandlerService.showWorkOrderJsp(box,
						dataMap);
				jsp = WORK_ORDER_JSP;
				pageNo++;
				messageTOBeVisibleToTheUser = "Work Order Entry has been done Successfully";
			}
		} else {
			messageTOBeVisibleToTheUser = "Work Order Entry has not been done Successfully";
		}

		jsp = "workOrder";
		jsp += ".jsp";
		String url = "";
		url = "/hms/hms/neStores?method=showWorkOrderJsp";
		// map.put("workOrderNo",workOrderNo);
		map.put("pageNo", pageNo);
		map.put("contentJsp", jsp);
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView("index", "map", map);

	}
	public ModelAndView updateWorkOrder(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		StoreWorkOrderT storeWorkOrderT = new StoreWorkOrderT();
		int workOrderId = 0;
		Date workOrderDate = new Date();
		String encodedBy = "";
		Date encodedDate = null;
		String lastChgBy = "A";
		Date lastChgDate = null;
		String lastChgTime = "";
		int departmentId = 0;
		String date = "";
		String time = "";
		int noOfRows = 0;
		int pageNo = 1;
		String buttonFlag = "";
		int repairingCell = 0;
		int hospitalId = 0;
		String workOrderNo = "";
		String authority = "";
		int issueBy = 0;
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
		try {
			/*if (request.getParameter("pageNo") != null) {
				pageNo = Integer.parseInt(request.getParameter("pageNo"));

			}
			if (request.getParameter(NO_OF_ROWS) != null) {
				noOfRows = Integer.parseInt(request.getParameter(NO_OF_ROWS));
			}*/
			if (request.getParameter(WORK_ORDER_ID) != null) {
				workOrderId = Integer.parseInt(request
						.getParameter(WORK_ORDER_ID));
				
			}
			StoreWorkOrderM storeWorkOrderM = new StoreWorkOrderM();
			storeWorkOrderM = nonExpendableStoresHandlerService.loadWorkOrderObj(workOrderId);

			if (request.getParameter(AUTHORITY) != null) {
				authority = request.getParameter(AUTHORITY);
			}
			if (request.getParameter("issueBy") != null && !request.getParameter("issueBy").equals("")) {
				issueBy = Integer.parseInt(request.getParameter("issueBy"));
			}
			if (request.getParameter(WORK_ORDER_NO) != null) {
				workOrderNo = request.getParameter(WORK_ORDER_NO);
			}
			if (request.getParameter(REPAIRING_CELL) != null) {
				repairingCell = Integer.parseInt(request.getParameter(REPAIRING_CELL));
			}		
			String te = "";

			if (request.getParameter(WORK_ORDER_DATE) != null) {
				te = (String) (request.getParameter(WORK_ORDER_DATE));

				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(request.getParameter(WORK_ORDER_DATE)));
				workOrderDate = java.sql.Date.valueOf(date4MySQL);
			}
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		String headerStored = "no";
		MasRepairStation masRepairStation =new MasRepairStation();
		// if (pageNo == 1) {

		storeWorkOrderM.setAuthorityNo(authority);
		if(issueBy !=0){
		MasEmployee masEmployee=new MasEmployee();
		masEmployee.setId(issueBy);
		storeWorkOrderM.setIssuedBy(masEmployee);
		}
		if(repairingCell !=0){
			masRepairStation.setId(repairingCell);
			storeWorkOrderM.setRepairStation(masRepairStation);
		}
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);
			storeWorkOrderM.setDepartment(masDepartment);

			storeWorkOrderM.setWorkOrderDate(workOrderDate);
			storeWorkOrderM.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			storeWorkOrderM.setLastChgTime(time);
			storeWorkOrderM.setStatus("y");

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			storeWorkOrderM.setHospital(masHospital);

			storeWorkOrderM.setLastChgBy("admin");
			storeWorkOrderM.setStatus("o");
			storeWorkOrderM.setWorkOrderNo(workOrderNo);
			infoMap.put("storeWorkOrderM", storeWorkOrderM);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		/*} else {
			headerStored = "yes";
			infoMap.put("headerStored", headerStored);
		}*/
		int length = 0;
		List<StoreWorkOrderT> storeWorkOrderTlist = new ArrayList<StoreWorkOrderT>();

		try {
			/*String srNo[] = JKTRequestUtils.getRequiredStringParameters(
					request, SR_NO);
			int itemIdArray[] = JKTRequestUtils.getRequiredIntParameters(
					request, ITEM_ID);
			String remarks[] = JKTRequestUtils.getRequiredStringParameters(
					request, REMARKS);
			String natureOfWork[] = JKTRequestUtils
					.getRequiredStringParameters(request, NATURE_OF_WORK);
			int quantityReceivedArray[] = JKTRequestUtils
					.getRequiredIntParameters(request, QUANTITY_RECEIVED);
			String batchNo[] = JKTRequestUtils.getRequiredStringParameters(
					request, BATCH_ID);*/

			/*
			if (buttonFlag.equals("next")) {
				// if(buttonFlag != null){
				length = 10;
			} else {
				length = noOfRows;
			}
			 */
			List<Integer> workDtIdList = new ArrayList<Integer>();
			List<Integer> itemIdList = new ArrayList<Integer>();
			List<String> srList = new ArrayList<String>();
			List<String>  serialNoList = new ArrayList<String>();
			List<Integer> quantityList = new ArrayList<Integer>();
			List<String> natureOfWorkList = new ArrayList<String>();
			List<String> parEqptList = new ArrayList<String>();
			List<String> remarksList = new ArrayList<String>();
			
			int hdb = 1;
			if (Integer.parseInt(request.getParameter("gridSize")) != 1) {
				hdb = Integer.parseInt(request.getParameter("gridSize"));
			}
			int j = 1;
			for (int i = 0; i < hdb; i++) {
				int workDtId = 0;
				if (request.getParameter(DETAIL_ID+ j) != null && !request.getParameter(DETAIL_ID + j).equals("0")) {

					workDtId = Integer.parseInt(request.getParameter(DETAIL_ID + j));
					workDtIdList.add(workDtId);
				}else{
					workDtIdList.add(0);
				}
				String pvmsNo = "";
				int itemId = 0;
				if (request.getParameter(ITEM_ID+ j) != null && !request.getParameter(ITEM_ID + j).equals("0")) {

					itemId = Integer.parseInt(request.getParameter(ITEM_ID + j));
						itemIdList.add(itemId);
				}
				String srNo="";
				if (request.getParameter(SR_NO+ j) != null && !request.getParameter(SR_NO + j).equals("")) {

					srNo = request.getParameter(SR_NO + j);
					srList.add(srNo);
				}
				String serialNo ="";
				if(request.getParameter(SERIAL_NO + j) != null && !request.getParameter(SERIAL_NO + j).equals("")){
					serialNo =request.getParameter(SERIAL_NO + j);
					serialNoList.add(serialNo);
				int quantity = 0;
				if(request.getParameter(QUANTITY_RECEIVED+ j) != null && !request.getParameter(QUANTITY_RECEIVED + j).equals("")){
					quantity = Integer.parseInt(request.getParameter(QUANTITY_RECEIVED + j));
					quantityList.add(quantity);
				}else {
					quantityList.add(0);
				}

				String natureWork = "";
				if(request.getParameter(NATURE_OF_WORK + j) != null && !request.getParameter(NATURE_OF_WORK + j).equals("")){
					natureWork = request.getParameter(NATURE_OF_WORK + j);
					natureOfWorkList.add(natureWork);
				}	else {
					natureOfWorkList.add("");
				}
				
				String particularEqp = "";
				if(request.getParameter(PARTICULAR_EQPT + j) != null && !request.getParameter(PARTICULAR_EQPT + j).equals("")){
					particularEqp = request.getParameter(PARTICULAR_EQPT+ j);
					parEqptList.add(particularEqp);
				}else{
					parEqptList.add("");
				}
			
				String remarks = "";
				if(request.getParameter(REMARKS + j) != null && !request.getParameter(REMARKS + j).equals("")){
					remarks = request.getParameter(REMARKS+ j);
					remarksList.add(remarks);
				}else {
					remarksList.add("");
				}


				j++;
			}
			/*for (int i = 0; i < length; i++) {
				if (itemIdArray[i] != 0) {

					StoreWorkOrderT storeWOrderTObj = new StoreWorkOrderT();
					MasStoreItem masItem = new MasStoreItem();
					masItem.setId(itemIdArray[i]);
					storeWOrderTObj.setItem(masItem);

					storeWOrderTObj.setRemarks(remarks[i]);
					storeWOrderTObj.setSrNo(srNo[i]);
					storeWOrderTObj.setQuantity(quantityReceivedArray[i]);
					storeWOrderTObj.setNatureOfWork(natureOfWork[i]);
					storeWOrderTObj.setSerialNo(batchNo[i]);
					storeWorkOrderTlist.add(storeWOrderTObj);
				}*/
			}
			infoMap.put("workDtIdList", workDtIdList);
			infoMap.put("itemIdList", itemIdList);
			infoMap.put("serialNoList", serialNoList);
			infoMap.put("quantityList", quantityList);
			infoMap.put("natureOfWorkList",natureOfWorkList);
			infoMap.put("parEqptList", parEqptList);
			infoMap.put("remarksList", remarksList);
			infoMap.put("srList",srList);
		//infoMap.put("pageNo", pageNo);
		infoMap.put("workOrderNo", workOrderNo);
		infoMap.put("workOrderId", workOrderId);
		
		///infoMap.put("storeWorkOrderTlist", storeWorkOrderTlist);
		infoMap.put("deptId", deptId);
		infoMap.put("hospitalId", hospitalId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean flag = false;
		try {
			flag = nonExpendableStoresHandlerService.updateWorkOrder(infoMap);

		} catch (Exception e) {
		e.printStackTrace();
		}
		if (map.get("flag") != null) {
			flag = (Boolean) map.get("flag");
		}
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		String messageTOBeVisibleToTheUser = "";

		if (flag) {
			if (buttonFlag.equals("next")) {
				jsp = WORK_ORDER_JSP;
				pageNo++;
				map = nonExpendableStoresHandlerService.showWorkOrderJsp(box,
						dataMap);
				if (map.get("workOrderId") != null) {
					workOrderId = (Integer) map.get("workOrderId");
				}
				messageTOBeVisibleToTheUser = "Work Order  Entry has  been done Successfully";

			} else {
				map = nonExpendableStoresHandlerService.showWorkOrderJsp(box,
						dataMap);
				if (map.get("workOrderId") != null) {
					workOrderId = (Integer) map.get("workOrderId");
				}
				map = nonExpendableStoresHandlerService.showWorkOrderJsp(box,
						dataMap);
				jsp = WORK_ORDER_JSP;
				pageNo++;
				messageTOBeVisibleToTheUser = "Work Order Entry has been done Successfully";
			}
		} else {
			messageTOBeVisibleToTheUser = "Work Order Entry has not been done Successfully";
		}

		jsp = "workOrder";
		jsp += ".jsp";
		String url = "";
		url = "/hms/hms/neStores?method=showWorkOrderJsp";
		// map.put("workOrderNo",workOrderNo);
		map.put("pageNo", pageNo);
		map.put("contentJsp", jsp);
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView("index", "map", map);

	}
	//---------Local Supply (NON-Expand) By dipali(05/09/2012)---
	public ModelAndView showNonPurchaseOrderJsp(HttpServletRequest request,HttpServletResponse response) {
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


		map = nonExpendableStoresHandlerService.showNonPurchaseOrderJsp(dataMap);
		List<StorePoHeader>poNumberList = nonExpendableStoresHandlerService.getPoNumberList(deptId,hospitalId);
		jsp = NON_LOCAL_PURCHASE_JSP;
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
	public ModelAndView submitNonLocalSupply(HttpServletRequest request,HttpServletResponse response) {
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
			poId = nonExpendableStoresHandlerService.getPurchaseOrderId(poNumber,hospitalId);
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
				storePoHeader.setStatus("o");
				storePoHeader.setFileNo(fileNo);
				storePoHeader.setFlag("s");
				storePoHeader.setTypeOfItem("N");

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
				po_num = nonExpendableStoresHandlerService.getnextPurchaseOrder(
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
				storePoHeader.setTypeOfItem("N");
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
	//	int patientIdArr[]=new int[noOfRecords-1];
		try {
			// int srNo[] =
			// JKTRequestUtils.getRequiredIntParameters(request,SR_NO);
			int itemIdArr[] = JKTRequestUtils.getRequiredIntParameters(request,	ITEM_ID);

		//	patientIdArr=JKTRequestUtils.getRequiredIntParameters(request,"prescription_id");
			Vector manufacturerIdArr = box.getVector(MANUFACTURER_ID);
			//Vector brandIdArr = box.getVector(BRAND_ID);
			// int manufacturerIdArr[] =
			// JKTRequestUtils.getRequiredIntParameters(request,MANUFACTURER_ID);
			// int brandIdArr[] =
			// JKTRequestUtils.getRequiredIntParameters(request,BRAND_ID);
			// String freeItemArr[] =
			// JKTRequestUtils.getRequiredStringParameters(request,FREE_ITEM);
			//Vector freeItemArr = box.getVector(FREE_ITEM);

			/*String actQty[] = JKTRequestUtils.getRequiredStringParameters(
					request, ACTUAL_QTY);
			int actLen = actQty.length;
			for (int i = 0; i < noOfRecords-1; i++) {
				BigDecimal val = new BigDecimal(actQty[i]);
				actQuantityArr[i] = val;
			}*/

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
		//	Vector dispenseType = box.getVector("dipenseType");
			//Vector mdq = box.getVector("mdq");
			Vector mrp = box.getVector("mrp");
		//	Vector BG=box.getVector("BG");


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
					/*if (brandIdArr.get(i)!=null && !brandIdArr.get(i).equals("")) {
						MasStoreBrand masStoreBrand = new MasStoreBrand();
						masStoreBrand.setId(Integer.parseInt(brandIdArr.get(i)
								.toString()));
						storePoDetail.setBrand(masStoreBrand);
					}*/
					/*if(patientIdArr[i]!=0)
					{
						storePoDetail.setPreId(patientIdArr[i]);
					}*/
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

				//storePoDetail.setDispType(dispenseType.get(i).toString());
				//storePoDetail.setMdqValue(new BigDecimal(mdq.get(i).toString()));
				//storePoDetail.setBrandedGeneric(BG.get(i).toString());
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
		//infoMap.put("patientIdArr", patientIdArr);
		infoMap.put("poDetailList", poDetailList);
		infoMap.put("departmentId", departmentId);
		infoMap.put("quantityArr", quantityArr);
		infoMap.put("requestType", requestType);
		infoMap.put("hospitalId",hospitalId);
		dataMap.put("hospitalId",hospitalId);
		dataMap.put("deptId",departmentId);
		infoMap.put("noOfRecords",noOfRecords);


		boolean flag = false;
		Map<String, Object> poMap = nonExpendableStoresHandlerService.submitNonPurchaseOrder(infoMap);
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
				map = nonExpendableStoresHandlerService
						.showNonPurchaseOrderJsp(dataMap);
				if (poMap.get("poId") != null) {
					poId = (Integer) poMap.get("poId");
				}
				List<StorePoHeader> poHeaderList = nonExpendableStoresHandlerService
						.getPoHeader(poId);
				map.put("poHeaderList", poHeaderList);
				pageNo = pageNo + 1;
				box.put("pageNo", pageNo);
				map.put("box", box);

			} else {
				url = "/hms/hms/purchaseOrder?method=showPurchaseOrderJsp";
				// jsp = STORES_MESSAGE_JSP;
				jsp = "non_localsupplyorderMessage";
				pageNo++;
				String Po_no = "";

				map.put("box", box);
				Po_no = box.getString(PO_NO);
				/*messageTOBeVisibleToTheUser = Po_no
						+ " Supply Order has been done Successfully.want to print Supply Order? ";*/

				messageTOBeVisibleToTheUser= "Supply Order saved successfully. ";
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
	public void fillItemsForNonLpo(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		// ------ Retriving User Name,Hospital Id,Department Id from Session
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
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String pvmsNo = "";
		try {
			if (request.getParameter("pvmsNo") != null) {
				pvmsNo = request.getParameter("pvmsNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		dataMap.put("pvmsNo", pvmsNo);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);

		map = nonExpendableStoresHandlerService.fillItemsForNonLpo(dataMap);
		if (map.get("itemList") != null) {
			itemList = (List<MasStoreItem>) map.get("itemList");
		}
		StringBuffer sb = new StringBuffer();
		for (MasStoreItem masStoreItem : itemList) {
			sb.append("<item>");
			sb.append("<id>" + masStoreItem.getId() + "</id>");
			sb.append("<pvms>" + masStoreItem.getPvmsNo() + "</pvms>");
			try {
				sb.append("<au>"
						+ masStoreItem.getItemConversion().getPurchaseUnit()
								.getUnitName() + "</au>");
			} catch (Exception e) {
				sb.append("<au>" + "-" + "</au>");
			}

			sb.append("</item>");
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
	public ModelAndView getItemListNonSupplyOrder(HttpServletRequest request,
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
			map = nonExpendableStoresHandlerService.getItemListNonSupplyOrder(dataMap);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "result";
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView searchPO(HttpServletRequest request,HttpServletResponse response) throws IOException {

		String fromDate = "";
		String toDate = "";
		int supplierId = 0;
		int departmentId = 0;
		String includedJsp = "";
		int hospitalId=0;
		int poId = 0;
		String jsp = "non_poMain";
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



		poMap = (Map) nonExpendableStoresHandlerService.getViewAllMap(hospitalId);
		List<StorePoHeader> poNumberList = nonExpendableStoresHandlerService.getPoNumberList(deptId,hospitalId);
		supplierList = (List) poMap.get("supplierList");
		poDetailList = (List) poMap.get("poDetailList");
		poHeaderList = (List) poMap.get("poHeaderList");
		if (searchFieldMap.size() != 0) {
			map = nonExpendableStoresHandlerService.searchPO(searchFieldMap);
			includedJsp = "done";
		} else {
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
	
	public ModelAndView poModifyJsp(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> purchaseMap = new HashMap<String, Object>();
		jsp = NON_UPDATE_LOCAL_PURCHASE_JSP;
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
		map = (Map<String, Object>) nonExpendableStoresHandlerService.poModifyMap(poDetailId, pageNo, buttonFlag);
		purchaseMap = nonExpendableStoresHandlerService.showNonPurchaseOrderJsp(dataMap);
		List<StorePoHeader> poNumberList = nonExpendableStoresHandlerService.getPoNumberList(deptId,hospitalId);
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
			storePoHeader.setTypeOfItem("N");
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
			storePoHeader.setTypeOfItem("N");
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
		//BigDecimal[] actQquantityArr = new BigDecimal[200];
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
		//Vector brandIdArr = box.getVector(BRAND_ID);
		// String freeItemArr[] =
		// JKTRequestUtils.getRequiredStringParameters(request,FREE_ITEM);
		//Vector freeItemArr = box.getVector(FREE_ITEM);
	//	Vector freeQtyArr = box.getVector(FREE_QTY);

		length = srNo.length;

		String xx[] = JKTRequestUtils.getRequiredStringParameters(request,QUANTITY);
		int xxLen = xx.length;
		for (int i = 0; i < xxLen; i++) {
			BigDecimal val = new BigDecimal(xx[i]);
			quantityArr[i] = val;
		}
		/*String actQty[] = JKTRequestUtils.getRequiredStringParameters(request,ACTUAL_QTY);
		int actLen = actQty.length;
		for (int i = 0; i < actLen; i++) {
			BigDecimal val = new BigDecimal(actQty[i]);
			actQquantityArr[i] = val;
		}*/
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

	//	Vector mdq = box.getVector("mdq");
	//	Vector dispenseType = box.getVector("dipenseType");
	//	Vector ratePerMdq = box.getVector("ratePerMdq");
		Vector mrp = box.getVector("mrp");
	//	Vector otherTaxes = box.getVector("otherTaxes");

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
					//storePoDetail.setLsoQty(actQquantityArr[i]);

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

					/*if (!brandIdArr.get(i).equals("")) {
						MasStoreBrand masStoreBrand = new MasStoreBrand();
						masStoreBrand.setId(Integer.parseInt(brandIdArr.get(i)
								.toString()));
						storePoDetail.setBrand(masStoreBrand);
					}*/
				//	storePoDetail.setDispType(dispenseType.get(i).toString());
				//	storePoDetail.setMdqValue(new BigDecimal(mdq.get(i).toString()));


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
				//	storePoDetail.setOtherTaxes("");

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
					//	storePoDetailAdd.setLsoQty(actQquantityArr[i]);

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

					/*	if (!brandIdArr.get(i).equals("")) {
							MasStoreBrand masStoreBrand = new MasStoreBrand();
							masStoreBrand.setId(Integer.parseInt(brandIdArr
									.get(i).toString()));
							storePoDetailAdd.setBrand(masStoreBrand);
						}

*/
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
						/*storePoDetailAdd.setDispType(dispenseType.get(i)
								.toString());
						storePoDetailAdd.setMdqValue(new BigDecimal(mdq.get(i)
								.toString()));
						try {
							storePoDetailAdd.setRatePerMdq(new BigDecimal(
									ratePerMdq.get(i).toString()));
						} catch (Exception e) {
							storePoDetailAdd.setRatePerMdq(new BigDecimal(0));
						}*/

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
/*
				if (!brandIdArr.get(i).equals("")) {
					MasStoreBrand masStoreBrand = new MasStoreBrand();
					masStoreBrand.setId(Integer.parseInt(brandIdArr.get(i)
							.toString()));
					storePoDetailAdd.setBrand(masStoreBrand);
				}*/

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

				/*try {
					storePoDetailAdd.setRatePerMdq(new BigDecimal(ratePerMdq
							.get(i).toString()));
				} catch (Exception e) {
					storePoDetailAdd.setRatePerMdq(new BigDecimal(0));
				}

				// mdq, dispense type, rate per mdq
				storePoDetailAdd.setDispType(dispenseType.get(i).toString());
				storePoDetailAdd.setMdqValue(new BigDecimal(mdq.get(i).toString()));*/

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

		boolean flag = nonExpendableStoresHandlerService.updatePurchaseOrder(infoMap);

		String messageTOBeVisibleToTheUser = "";

		if (flag) {
			if (infoMap.get("poId") != null) {
				poId = (Integer) infoMap.get("poId");
				map = (Map<String, Object>) nonExpendableStoresHandlerService.poModifyMap(poId, pageNo, buttonFlag);
				map.put("poId", poId);
			}
			poDetailList = (List<StorePoDetail>) map.get("poDetailList");
			if (poDetailList.size() == 0) {
				noDetailRecords = "yes";
			}
			if ((poDetailList.size() != 0) || (buttonFlag.equals("next"))) {
				jsp = NON_UPDATE_LOCAL_PURCHASE_JSP;
			}
			if (!(buttonFlag.equals("next"))) {
				jsp = NON_STORES_MESSAGE_JSP;
				messageTOBeVisibleToTheUser = "Supply Order has been updated Successfully";
			}
			pageNo++;
		} else {
			jsp = NON_STORES_MESSAGE_JSP;
			messageTOBeVisibleToTheUser = "Try Again !!";
			map.put("messageType", "failure");
			url = "/hms/hms/purchase?method=showPurchaseOrderJsp";
		}
		jsp += ".jsp";
		Map<String, Object> purchaseMap = nonExpendableStoresHandlerService
				.showNonPurchaseOrderJsp(dataMap);

		url = "/hms/hms/neStores?method=showNonPurchaseOrderJsp";

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
		deleteMap = nonExpendableStoresHandlerService.deletePurchaseOrderItem(box);

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
			map = (Map<String, Object>) nonExpendableStoresHandlerService
					.poModifyMap(radio_str, pageNo, buttonFlag);
		}

		dataMap.put("hospitalId",hospitalId);
		dataMap.put("deptId",deptId);
		purchaseMap = nonExpendableStoresHandlerService.showNonPurchaseOrderJsp(dataMap);
		List<StorePoHeader> poNumberList = nonExpendableStoresHandlerService.getPoNumberList(deptId,hospitalId);

		map.put("purchaseMap", purchaseMap);
		map.put("pageNo", pageNo);
		map.put("poNumberList", poNumberList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("radio_str", radio_str);

		return new ModelAndView("index", "map", map);

		// map = purchaseOrderHandlerService.getConnectionForReport();

	}
	public ModelAndView printLocalSupplyOrder(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> searchFieldMap = new HashMap<String, Object>();
		int deptId = 0;
		map = nonExpendableStoresHandlerService.getConnectionForReport();
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

			po_number = nonExpendableStoresHandlerService.getPoNumber(po_id);
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
			hospitalName = nonExpendableStoresHandlerService.getHospitalName(hospitalId);
			hospitalAddress = nonExpendableStoresHandlerService.getHospitalAddress(hospitalId);

		}
		map.put("hospitalId",hospitalId);
		map.put("DEPT", deptId);
		map.put("HOSP_NAME", hospitalName);
		map.put("HOSP_ADD", hospitalAddress);
		// map.put("po_number", box.getString(PO_NO));
	if(box.getString(PO_NO) != null && !box.getString(PO_NO).equals(""))
	{
		HMSUtil.generateReport("non_Supply_order", map, (Connection)map.get("con"), response, getServletContext());
	}
		return null;
	}
	//-----------End By Dipali--
	public ModelAndView responseGridListForOtherSource(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		String choice = "";
		map=nonExpendableStoresHandlerService.getManuList();
		/* if(request.getParameter("poId")!=null && !request.getParameter("poId").equals(""))
		{
		int poId=Integer.parseInt(request.getParameter("poId"));
		map=nonExpendableStoresHandlerService.getPoList(poId);
		}*/
		jsp = "gridDGAFMSForNe";
		return new ModelAndView(jsp, "map", map);
	}
	
	// add javed khan
	public ModelAndView showIndentToDepoNe(HttpServletRequest request,HttpServletResponse response) {
		// --- Retriving User Name,Hospital Id,Department Id from Session-----
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
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		Map<String, Object> map = new HashMap<String, Object>();
		map = nonExpendableStoresHandlerService.showIndentToDepoNe(dataMap);
		jsp = INDENT_TO_DEPOT_NE_JSP;
		jsp = jsp + ".jsp";
		title = "Indent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	
	// add javed khan
	
	public ModelAndView getItemListForIndentToDepot(HttpServletRequest request,
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
		int sectionId = 0;
		int indentId = 0;
		int sec=0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			if (request.getParameter("section") != null) {
				sectionId = Integer.parseInt(""
						+ (request.getParameter("section")));
			}
			
			if (request.getParameter("sec")!= null) {
				sec = Integer.parseInt(request.getParameter("sec"));
			}
			
			if (request.getParameter("indentId") != null) {
				indentId = Integer.parseInt(""
						+ (request.getParameter("indentId")));
			}
			List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
			dataMap.put("autoHint", autoHint);
			dataMap.put("deptId", deptId);
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("sectionId", sectionId);
			dataMap.put("indentId", indentId);
			dataMap.put("sec", sec);

			map = nonExpendableStoresHandlerService
					.getItemListForIndentToDepot(dataMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "result";
		return new ModelAndView(jsp, "map", map);
	}
	
	
	// add javed khan
	
	public ModelAndView printIndentTODepoNe(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String query = "";
	String indentNo="";
	int deptId = 0;
	int hospitalId = 0;  // javed khan
		try {
			if (request.getParameter("indentNo") != null
					&& (!request.getParameter("indentNo").equals(""))) {
				indentNo=request.getParameter("indentNo") ;
			}
			if (session.getAttribute("deptId") != null)
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			if (session.getAttribute("hospitalId") != null)
				hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));  // javed khan



		} catch (Exception e) {
			e.printStackTrace();
		}
		detailsMap = nonExpendableStoresHandlerService.getConnectionForReport();
		parameters.put("INDENT_NO", indentNo);
		parameters.put("DEPART", deptId);
		parameters.put("hospitalId", hospitalId);  // javed khan
		try {
			/*byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("Indent_To_Depot"),
						parameters, (Connection) detailsMap.get("con"));

			} catch (JRException e) {

				e.printStackTrace();
			}
			response.setHeader("Content-Disposition", "inline; filename="
					+ "dgInvestigationRequired" + ".pdf");
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = response.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}*/
			String reportName = "New_Indent_To_DepotNe";
			HMSUtil.generateReport(reportName, parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());

			return null;
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public ModelAndView generateExcelForDepotNe(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		int deptId = 0;
		Box box = HMSUtil.getBox(request);
		String hospitalName = "";
		String deptName = "";
		String indentNo="";
		try {

			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				hospitalName = storesHandlerService.getHospitalName(hospitalId);
				requestParameters.put("hospitalName", hospitalName);
				requestParameters.put("hospitalId", hospitalId);
			}

			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
				requestParameters.put("deptId", deptId);
			}

			if (session.getAttribute("deptName") != null) {
				deptName = session.getAttribute("deptName").toString();
				requestParameters.put("deptName", deptName);
			}

			if(request.getParameter("indentNo")!=null ){

				indentNo=request.getParameter("indentNo");
			}

			requestParameters.put("indentNo", indentNo);
		} catch (Exception e) {
			e.printStackTrace();
		}


			map = nonExpendableStoresHandlerService.generateExcelForDepotNe(requestParameters);
		if (map.get("flag") != null
				&& map.get("flag").toString().equalsIgnoreCase("NoData")) {
			map.put("message", "No Data Found!....");
		} else {

			try {

				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition",
						"attachment; filename="
								+

								map.get("download_path").toString());
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
	
	
	// added by  javed khan
	
	public ModelAndView newSearchIndentNe(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		int indentId = 0;

		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		// --------------------------------------------------------------------------------
		String fromDate = "";
		String toDate = "";
		String indentNo = "";

		int mmfYear = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> tempMap = new HashMap<String, Object>();
		Map<String, Object> searchFieldMap = new HashMap<String, Object>();
		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		try {
			/*if (request.getParameter(MMF_FOR_THE_YEAR) != null) {
				mmfYear = Integer.parseInt(request
						.getParameter(MMF_FOR_THE_YEAR));

			}*/
			if (request.getParameter(RequestConstants.INDENT_NO_FOR_SEARCH) != null) {
				indentId = Integer.parseInt(request
						.getParameter(RequestConstants.INDENT_NO_FOR_SEARCH));
				if (request.getParameter(FROM_DATE) != null  &&  !request.getParameter(FROM_DATE).equals("")) {
					 fromDate = request.getParameter(FROM_DATE);
					 searchFieldMap.put("fromDate", fromDate);
						
					}
					if (request.getParameter(TO_DATE) != null && !request.getParameter(TO_DATE).equals("")) {
						toDate = request.getParameter(TO_DATE);
						searchFieldMap.put("toDate", toDate);
						
					}


			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		//searchFieldMap.put("mmfYear", mmfYear);
		searchFieldMap.put("indentId", indentId);
		searchFieldMap.put("hospitalId", hospitalId);
		searchFieldMap.put("deptId", deptId);
		searchFieldMap.put("userName", userName);
		try {

			// tempMap = storesHandlerService.showIndent();
			//tempMap = storesHandlerService.showIndent(deptId);
			//if (tempMap.get("searchIndentList") != null)
				//searchIndentList = (List) tempMap.get("searchIndentList");
			map = nonExpendableStoresHandlerService.newSearchIndentNe(searchFieldMap);
			//map.put("searchIndentList", searchIndentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//jsp = SEARCH_INDENT_JSP;
		jsp = "newSearchIndentNe";
		jsp = jsp + ".jsp";
		title = "Indent";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView getItemListForDefectiveDrugsByAutocomplete(HttpServletRequest request, HttpServletResponse response)
	 {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String autoHint = "";
		String itemNameField = "";
		String userName="";
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

		if (request.getParameter("requiredField") != null) {
			itemNameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(itemNameField) != null) {
			autoHint = (request.getParameter(itemNameField));
		}

		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		dataMap.put("autoHint", autoHint);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		// dataMap.put("box", box);
		
		map = nonExpendableStoresHandlerService
				.getItemListForDefectiveDrugsByAutocomplete(dataMap);
		jsp = "resultjspForNenExp";
		//jsp = jsp + ".jsp";
		//map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	 }
	public ModelAndView getItemListForCondemnationByAutocomplete(HttpServletRequest request, HttpServletResponse response)
	 {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String autoHint = "";
		String itemNameField = "";
		String userName="";
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

		if (request.getParameter("requiredField") != null) {
			itemNameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(itemNameField) != null) {
			autoHint = (request.getParameter(itemNameField));
		}

		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		dataMap.put("autoHint", autoHint);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		
		map = nonExpendableStoresHandlerService
				.getItemListForCondemnationByAutocomplete(dataMap);
		jsp = "responseForCondemnation";
		//jsp = jsp + ".jsp";
		//map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	 }
	
	// Add by Sanjay Kumar
	
	public ModelAndView getItemListForDefectiveDrugsByAutocompleteForMeScale(HttpServletRequest request, HttpServletResponse response)
	 {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String autoHint = "";
		String itemNameField = "";
		String userName="";
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

		if (request.getParameter("requiredField") != null) {
			itemNameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(itemNameField) != null) {
			autoHint = (request.getParameter(itemNameField));
		}

		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		dataMap.put("autoHint", autoHint);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		// dataMap.put("box", box);
		map = nonExpendableStoresHandlerService
				.getItemListForDefectiveDrugsByAutocomplete(dataMap);
		//jsp = "resultjspForNenExp";
		jsp = "resultjspForNenExpMeScale";
		//jsp = jsp + ".jsp";
		//map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	 }
	
	//Add by Sanjay Yadav
	public void fillItemsForBoardofsurvey(HttpServletRequest request,
			HttpServletResponse response) {
		// ---- Retriving User Name,Hospital Id,Department Id from Session--
      
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
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<StoreItemBatchStock> batchList = new ArrayList<StoreItemBatchStock>();

		Box box = HMSUtil.getBox(request);
		String itemNameField = "";
		String pvmsNo = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("pvmsNo") != null) {
			pvmsNo = (request.getParameter("pvmsNo"));
		}
		dataMap.put("pvmsNo", pvmsNo);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		map = nonExpendableStoresHandlerService.fillItemsForDefectiveDrugs(dataMap);

		if (map.get("itemList") != null) {
			itemList = (List) map.get("itemList");
		}
		if (map.get("brandList") != null) {
			brandList = (List) map.get("brandList");
		}
		if (map.get("batchList") != null) {
			batchList = (List) map.get("batchList");
		}

		List<StoreItemBatchStock> batchListForTurnOver= new ArrayList<StoreItemBatchStock>();
		if (map.get("batchListForTurnOver") != null) {
			batchListForTurnOver = (List) map.get("batchListForTurnOver");
		}

		StringBuffer sb = new StringBuffer();
		try {
			for (StoreItemBatchStock batchStock : batchList) {
				sb.append("<item>");
				sb.append("<nomen>" + batchStock.getItem().getNomenclature() + "</nomen>"); // add javed khan
				sb.append("<id>" +  batchStock.getItem().getId() + "</id>");
				sb.append("<pvms>" +  batchStock.getItem().getPvmsNo() + "</pvms>");
				sb.append("<au>"
						+  batchStock.getItem().getItemConversion().getPurchaseUnit()
								.getUnitName() + "</au>");
				sb.append("<qty>"
						+  batchStock.getClosingStock()+ "</qty>");
				sb.append("</item>");
			}

			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	//
	
	public void fillItemsForMeScale(HttpServletRequest request,
			HttpServletResponse response) {
		// ---- Retriving User Name,Hospital Id,Department Id from Session--
      
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
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<StoreItemBatchStock> batchList = new ArrayList<StoreItemBatchStock>();

		Box box = HMSUtil.getBox(request);
		String itemNameField = "";
		String pvmsNo = "";
		BigDecimal qty =new BigDecimal(0);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("pvmsNo") != null) {
			pvmsNo = (request.getParameter("pvmsNo"));
		}
		dataMap.put("pvmsNo", pvmsNo);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		map = nonExpendableStoresHandlerService.fillItemsForDefectiveDrugs(dataMap);

		if (map.get("itemList") != null) {
			itemList = (List) map.get("itemList");
		}
		if (map.get("brandList") != null) {
			brandList = (List) map.get("brandList");
		}
		if (map.get("batchList") != null) {
			batchList = (List) map.get("batchList");
		}

		List<StoreItemBatchStock> batchListForTurnOver= new ArrayList<StoreItemBatchStock>();
		if (map.get("batchListForTurnOver") != null) {
			batchListForTurnOver = (List) map.get("batchListForTurnOver");
		}
		if (map.get("qty") != null) {
			qty = (BigDecimal) map.get("qty");
		}
		StringBuffer sb = new StringBuffer();
		try {
			for (MasStoreItem masStoreItem : itemList) {
				//System.out.println("Fill Me Scale In Controller---Test By Sanjay--->>>"+masStoreItem.getItemConversion().getItemUnitName());
				sb.append("<item>");
				sb.append("<nomen>" + masStoreItem.getNomenclature() + "</nomen>"); // add javed khan
				sb.append("<id>" + masStoreItem.getId() + "</id>");
				sb.append("<pvms>" + masStoreItem.getPvmsNo() + "</pvms>");
				sb.append("<au>"
						+ masStoreItem.getItemConversion().getItemUnitName()+ "</au>");
				sb.append("<qty>" + qty + "</qty>");
				sb.append("</item>");
			}

			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	// Add By Sanjay Kumar
	
	public void fillItemsForfillItemsForMeScale(HttpServletRequest request,	HttpServletResponse response)
	{		// ---- Retriving User Name,Hospital Id,Department Id from Session--
      
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
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<StoreItemBatchStock> batchList = new ArrayList<StoreItemBatchStock>();

		Box box = HMSUtil.getBox(request);
		String itemNameField = "";
		String pvmsNo = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("pvmsNo") != null) {
			pvmsNo = (request.getParameter("pvmsNo"));
		}
		dataMap.put("pvmsNo", pvmsNo);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		map = nonExpendableStoresHandlerService.fillItemsForDefectiveDrugs(dataMap);

		if (map.get("itemList") != null) {
			itemList = (List) map.get("itemList");
		}
		if (map.get("brandList") != null) {
			brandList = (List) map.get("brandList");
		}
		if (map.get("batchList") != null) {
			batchList = (List) map.get("batchList");
		}

		List<StoreItemBatchStock> batchListForTurnOver= new ArrayList<StoreItemBatchStock>();
		if (map.get("batchListForTurnOver") != null) {
			batchListForTurnOver = (List) map.get("batchListForTurnOver");
		}

		StringBuffer sb = new StringBuffer();
		try {
			for (MasStoreItem masStoreItem : itemList) {
				sb.append("<item>");
				sb.append("<nomen>" + masStoreItem.getNomenclature() + "</nomen>"); // add javed khan
				sb.append("<id>" + masStoreItem.getId() + "</id>");
				sb.append("<pvms>" + masStoreItem.getPvmsNo() + "</pvms>");
				sb.append("<au>"
						+ masStoreItem.getItemConversion().getItemUnitName() + "</au>");

				sb.append("</item>");
			}

			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	
	
	// Add By Sanjay Yadav
	
	/*public void fillItemsForIndentToDepot1(HttpServletRequest request,
			HttpServletResponse response) {
		// ---- Retriving User Name,Hospital Id,Department Id from Session--
      System.out.println("fillItemsForIndentToDepot In Store By Sanjay Kumar***********");
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
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<StoreItemBatchStock> batchList = new ArrayList<StoreItemBatchStock>();

		Box box = HMSUtil.getBox(request);
		String itemNameField = "";
		String pvmsNo = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("pvmsNo") != null) {
			pvmsNo = (request.getParameter("pvmsNo"));
		}
		dataMap.put("pvmsNo", pvmsNo);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		map = nonExpendableStoresHandlerService.fillItemsForDefectiveDrugs(dataMap);

		if (map.get("itemList") != null) {
			itemList = (List) map.get("itemList");
		}
		if (map.get("brandList") != null) {
			brandList = (List) map.get("brandList");
		}
		if (map.get("batchList") != null) {
			batchList = (List) map.get("batchList");
		}

		List<StoreItemBatchStock> batchListForTurnOver= new ArrayList<StoreItemBatchStock>();
		if (map.get("batchListForTurnOver") != null) {
			batchListForTurnOver = (List) map.get("batchListForTurnOver");
		}

		StringBuffer sb = new StringBuffer();
		try {
			for (MasStoreItem masStoreItem : itemList) {
				sb.append("<item>");
				sb.append("<nomen>" + masStoreItem.getNomenclature() + "</nomen>"); // add javed khan
				sb.append("<id>" + masStoreItem.getId() + "</id>");
				sb.append("<pvms>" + masStoreItem.getPvmsNo() + "</pvms>");
				sb.append("<au>"
						+ masStoreItem.getItemConversion().getPurchaseUnit()
								.getUnitName() + "</au>");

				sb.append("</item>");
			}

			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
//Method Add by Sanjay Yadav
	 public ModelAndView getItemListForIssueToDispensary(
			HttpServletRequest request, HttpServletResponse response) {
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
		int issueId = 0;
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			if ((request.getParameter("issueId") != null)
					&& !(request.getParameter("issueId").equals(""))) {
				issueId = Integer.parseInt(request.getParameter("issueId"));
			}

			List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
			dataMap.put("autoHint", autoHint);
			dataMap.put("deptId", deptId);
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("issueId", issueId);
			map = nonExpendableStoresHandlerService.getItemListForIssueToDispensary(dataMap);
			jsp = "resultjspForNenExp";
			jsp = jsp + ".jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}
	 //Add By Sanjay Yadav
	 public void fillItemsForIssueToDispensary(HttpServletRequest request,
				HttpServletResponse response) {
			Box box = HMSUtil.getBox(request);
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
			Map<String, Object> dataMap = new HashMap<String, Object>();
			String pvmsNo = "";
			try {
				if (request.getParameter("pvmsNo") != null) {
					pvmsNo = request.getParameter("pvmsNo");
				}

				List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
				dataMap.put("pvmsNo", pvmsNo);
				dataMap.put("deptId", deptId);
				dataMap.put("userName", userName);
				dataMap.put("hospitalId", hospitalId);
				map = nonExpendableStoresHandlerService.fillItemsForIssueToDispensary(dataMap);
				if (map.get("itemList") != null) {
					itemList = (List) map.get("itemList");
				}
				
				List<StoreItemBatchStock> batchList = new ArrayList<StoreItemBatchStock>();
				if (map.get("batchList") != null) {
					batchList = (List) map.get("batchList");
				}
				BigDecimal stock = new BigDecimal(0);
				if (map.get("stock") != null) {
					stock = (BigDecimal) map.get("stock");
				}

				StringBuffer sb = new StringBuffer();
				for (MasStoreItem masStoreItem : itemList) {
					sb.append("<item>");
					sb.append("<nomen>" + masStoreItem.getNomenclature() + "</nomen>");
					sb.append("<id>" + masStoreItem.getId() + "</id>");
					sb.append("<pvms>" + masStoreItem.getPvmsNo() + "</pvms>");
					if (masStoreItem.getItemConversion() != null)
						sb.append("<au>"
								+ masStoreItem.getItemConversion()
										.getPurchaseUnit().getUnitName() + "</au>");
					else
						sb.append("<au>" + "NA" + "</au>");
					sb
							.append("<name>" + masStoreItem.getNomenclature()
									+ "</name>");
					sb.append("<BrandG>" + masStoreItem.getBrandedGeneric() + "</BrandG>");
					sb.append("<stock>" + stock + "</stock>");
					sb.append("<batches>");
					for (StoreItemBatchStock batch : batchList) {
						sb.append("<batch>");
						sb.append("<batchId>" + batch.getId() + "</batchId>");
						sb.append("<batchName>" + batch.getBatchNo()
								+ "</batchName>");
						sb.append("</batch>");
					}
					sb.append("</batches>");


					sb.append("</item>");
				}

				/*
				 * BigDecimal stock = new BigDecimal(0); try { String s =
				 * (String)map.get("stock"); stock = new BigDecimal(s); }
				 * catch(Exception e) { stock = new BigDecimal(0); }
				 */

				/*
				 * sb.append("<stock>"); sb.append("<stk>");
				 * sb.append(stock.doubleValue()); sb.append("</stk>");
				 * sb.append("</stock>");
				 */
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
	
	 public ModelAndView submitMeScale(HttpServletRequest request,HttpServletResponse response)
	 {
		Map map=new HashMap<String,Object>(); 
		Map<String,Object> dataMap = new HashMap<String,Object>(); 
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		 int hospitalId = 0;
		    int departmentId = 0;
		    int hdb1 =1;
		    int itemId=0;
		
		Integer meScaleNumber= 0;
		List<String> meScaleDescription= new ArrayList<String>();
		List<String> itemCode = new ArrayList<String>();
		
		List<Integer> itemIdList = new ArrayList<Integer>();
		List<String> nameItem = new ArrayList<String>();
		List<String> au= new ArrayList<String>();
		List<BigDecimal> qty= new ArrayList<BigDecimal>();
		 if(session.getAttribute("hospitalId")!= null)
	      {	   hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));   
	     
	 	  }
	    if(session.getAttribute("deptId")!= null)
	      {
	 	   departmentId = Integer.parseInt(""+session.getAttribute("deptId")); 	
	 	   
	      }
	    
		if(request.getParameter("srNo")!= null)
		   {
		      hdb1 = Integer.parseInt(request.getParameter("srNo"));
		     		      
		   }
		for(int i=0; i<= hdb1; i++)
		{
			
			if (request.getParameter(ITEM_ID+ i) != null && !request.getParameter(ITEM_ID + i).equals("0")) {

				itemId = Integer.parseInt(request.getParameter(ITEM_ID + i));
									itemIdList.add(itemId);
			}
			
	    	if(request.getParameter("meScaleNumber") != null && !(request.getParameter("meScaleNumber").equals("")))
		    {
			   meScaleNumber= Integer.parseInt( request.getParameter("meScaleNumber"));
			  
		   }
		   if(request.getParameter("meScaleDescription"+i)!= null && !(request.getParameter("meScaleDescription"+i).equals("")))
		    {
			   meScaleDescription.add( request.getParameter("meScaleDescription"+i));
			   
		    }
		  if(request.getParameter("itemCode"+i)!= null && !(request.getParameter("itemCode"+i).equals("")))
		   {
			itemCode.add( request.getParameter("itemCode"+i));


		    }
		 
		  
		if(request.getParameter("nameItem"+i)!= null && !(request.getParameter("nameItem"+i).equals("")))
		{
			 nameItem.add(request.getParameter("nameItem"+i));
			
		}
		if(request.getParameter("au"+i)!= null && !(request.getParameter("au"+i).equals("")))
		{
			au.add( request.getParameter("au"+i));
			
		}
		
		if(request.getParameter("qty"+i)!= null && !(request.getParameter("qty"+i).equals("")))
		{
			qty.add(new BigDecimal( request.getParameter("qty"+i)));
			
		}
		}
		dataMap.put("meScaleNumber",meScaleNumber);
		dataMap.put("meScaleDescription",meScaleDescription);
		dataMap.put("itemCode",itemCode);
		dataMap.put("nameItem",nameItem);
		dataMap.put("itemIdList", itemIdList);
		dataMap.put("au",au);
		dataMap.put("qty",qty);
		dataMap.put("hdb1",hdb1);
		map.put("hdb1",hdb1);
		dataMap.put("departmentId", departmentId);
		dataMap.put("hospitalId",hospitalId);
		boolean successfullyAdded = false;
		successfullyAdded = nonExpendableStoresHandlerService.submitMeScale(dataMap);
		 
		 String message="";		 
		 if(successfullyAdded)
		 {
			 message = "Data saved Successfully. Do you want to print";
		 }
		 else
		  {
			 message="Try Again";
		  }
		 jsp="messageForMeScale";
		 jsp += ".jsp";
		 map.put("message", message);
		 map.put("contentJsp", jsp);
		 map.put("meScaleNumber", meScaleNumber);
			return new ModelAndView("indexB", "map", map);
		 
	 }

public void fillItemsForIndentToDepot1(HttpServletRequest request,
		HttpServletResponse response)
{
	// ---- Retriving User Name,Hospital Id,Department Id from Session--
  System.out.println("fillItemsForBoardofsurvey In Store By Sanjay Kumar!!!!!!!!!!!!");
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
	List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
	List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
	List<StoreItemBatchStock> batchList = new ArrayList<StoreItemBatchStock>();

	Box box = HMSUtil.getBox(request);
	String itemNameField = "";
	String pvmsNo = "";
	Map<String, Object> dataMap = new HashMap<String, Object>();
	if (request.getParameter("pvmsNo") != null) {
		pvmsNo = (request.getParameter("pvmsNo"));
	}
	dataMap.put("pvmsNo", pvmsNo);
	dataMap.put("deptId", deptId);
	dataMap.put("userName", userName);
	dataMap.put("hospitalId", hospitalId);
	map = nonExpendableStoresHandlerService.fillItemsForDefectiveDrugs(dataMap);

	if (map.get("itemList") != null) {
		itemList = (List) map.get("itemList");
	}
	if (map.get("brandList") != null) {
		brandList = (List) map.get("brandList");
	}
	if (map.get("batchList") != null) {
		batchList = (List) map.get("batchList");
	}
	

	List<StoreItemBatchStock> batchListForTurnOver= new ArrayList<StoreItemBatchStock>();
	if (map.get("batchListForTurnOver") != null) {
		batchListForTurnOver = (List) map.get("batchListForTurnOver");
	}
	BigDecimal stock = new BigDecimal(0);
	BigDecimal qtyMeScale = new BigDecimal(0);
	if (map.get("stock") != null) {
		stock = (BigDecimal) map.get("stock");
	}
	if (map.get("qty") != null) {
		qtyMeScale = (BigDecimal) map.get("qty");
	}

	StringBuffer sb = new StringBuffer();
	try {
		for (MasStoreItem masStoreItem : itemList) {
			sb.append("<item>");
			sb.append("<nomen>" + masStoreItem.getNomenclature() + "</nomen>"); // add javed khan
			sb.append("<id>" + masStoreItem.getId() + "</id>");
			sb.append("<pvms>" + masStoreItem.getPvmsNo() + "</pvms>");
			sb.append("<au>" + masStoreItem.getItemConversion().getItemUnitName() + "</au>");
			sb.append("<stock>" + stock + "</stock>");
			sb.append("<qtyMeScale>" + qtyMeScale + "</qtyMeScale>");
			
			sb.append("</item>");
		}

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
	} catch (Exception e) {
		e.printStackTrace();
	}
	try {
		response.getWriter().write(
				"<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");

	} catch (Exception e) 
	{
		e.printStackTrace();
	}
}
//--------By Dipali--

public ModelAndView getItemListForBoardOfSurveyAutocom(HttpServletRequest request, HttpServletResponse response)
{
	Map<String, Object> dataMap = new HashMap<String, Object>();
	Box box = HMSUtil.getBox(request);
	String autoHint = "";
	String itemNameField = "";
	String userName="";
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

	if (request.getParameter("requiredField") != null) {
		itemNameField = (request.getParameter("requiredField"));
	}
	if (request.getParameter(itemNameField) != null) {
		autoHint = (request.getParameter(itemNameField));
	}

	List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
	dataMap.put("autoHint", autoHint);
	dataMap.put("deptId", deptId);
	dataMap.put("userName", userName);
	dataMap.put("hospitalId", hospitalId);
	map = nonExpendableStoresHandlerService.getItemListForBoardOfSurveyAutocom(dataMap);
	jsp = "st_respForBoardOfSurvey";
	return new ModelAndView(jsp, "map", map);
}

public ModelAndView printForMeScaleReport(HttpServletRequest request, HttpServletResponse response)
{
	Box box = HMSUtil.getBox(request);
	Map<String, Object> datamap = new HashMap<String, Object>();

	session = request.getSession();
	int hospitalId = 0;
	int departmentId = Integer.parseInt(session.getAttribute("deptId").toString());
	if (session.getAttribute("hospitalId") != null)
		hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
	String deptName = (String)session.getAttribute("deptName");;
	map = nonExpendableStoresHandlerService.getConnectionForReport();
	int meScaleNo= 0;
	
	System.out.println("meScaleNumber=="+box.getInt("meScaleNumber"));
	if(box.getInt("meScaleNumber")!= 0){
		meScaleNo =(Integer)box.getInt("meScaleNumber");
	}		
	map.put("meScaleNo",meScaleNo );
	map.put("hospitalId",hospitalId );
	map.put("departmentId",departmentId); 			
	HMSUtil.generateReport("MeScaleReport", map, (Connection)map.get("con"), response, getServletContext());
			
	return null;
}
public ModelAndView getItemListForEquipmentLoanOut(HttpServletRequest request, HttpServletResponse response)
{
	Map<String, Object> dataMap = new HashMap<String, Object>();
	Box box = HMSUtil.getBox(request);
	String autoHint = "";
	String itemNameField = "";
	String userName="";
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

	if (request.getParameter("requiredField") != null) {
		itemNameField = (request.getParameter("requiredField"));
	}
	if (request.getParameter(itemNameField) != null) {
		autoHint = (request.getParameter(itemNameField));
	}

	dataMap.put("autoHint", autoHint);
	dataMap.put("deptId", deptId);
	dataMap.put("userName", userName);
	dataMap.put("hospitalId", hospitalId);
	map = nonExpendableStoresHandlerService.getItemListForEquipmentLoanOut(dataMap);
	jsp = "st_respEqupiLoanOut";
	return new ModelAndView(jsp, "map", map);
}


public void fillItemsForEquipmentLoanOut(HttpServletRequest request,
		HttpServletResponse response) {
	// ---- Retriving User Name,Hospital Id,Department Id from Session--
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
	List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
	List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
	List<StoreItemBatchStock> batchList = new ArrayList<StoreItemBatchStock>();

	Box box = HMSUtil.getBox(request);
	String itemNameField = "";
	String pvmsNo = "";
	Map<String, Object> dataMap = new HashMap<String, Object>();
	if (request.getParameter("pvmsNo") != null) {
		pvmsNo = (request.getParameter("pvmsNo"));
	}
	dataMap.put("pvmsNo", pvmsNo);
	dataMap.put("deptId", deptId);
	dataMap.put("userName", userName);
	dataMap.put("hospitalId", hospitalId);
	//map = nonExpendableStoresHandlerService.fillItemsForDefectiveDrugs(dataMap);
	map = nonExpendableStoresHandlerService.fillItemsForEquipmentLoanOut(dataMap);
	
	if (map.get("batchList") != null) {
		batchList = (List) map.get("batchList");
	}

	StringBuffer sb = new StringBuffer();
	try {
		for (StoreItemBatchStock batchStock : batchList) {
			sb.append("<item>");
			sb.append("<nomen>" + batchStock.getItem().getNomenclature() + "</nomen>"); // add javed khan
			sb.append("<id>" +  batchStock.getItem().getId() + "</id>");
			sb.append("<pvms>" +  batchStock.getItem().getPvmsNo() + "</pvms>");
			sb.append("<au>"
					+  batchStock.getItem().getItemConversion().getPurchaseUnit()
							.getUnitName() + "</au>");
			sb.append("<availableStock>"
					+  batchStock.getClosingStock()+ "</availableStock>");
			
			sb.append("<batches>");
			for (StoreItemBatchStock batch : batchList) {
				sb.append("<batch>");
				sb.append("<batchId>" + batch.getId() + "</batchId>");
				sb.append("<batchName>" + batch.getBatchNo()
						+ "</batchName>");
				sb.append("</batch>");
			}
			sb.append("</batches>");
			sb.append("</item>");
		}

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
	} catch (Exception e) {
		e.printStackTrace();
	}
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
//----By Kiran ME Scale Report


public ModelAndView showMeScaleReportJsp(HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	map = nonExpendableStoresHandlerService.showWorkRegisterReportJsp();
	
	title = "ME Scale Report";
	jsp = "meScaleReport";
	jsp = jsp + ".jsp";
	
	map.put("contentJsp", jsp);
	map.put("title", title);

	return new ModelAndView("index", "map", map);
}


public ModelAndView generateMeScaleReport(HttpServletRequest request,
		HttpServletResponse response) {

	Map<String, Object> requestParameters = new HashMap<String, Object>();
	
	
	int hospitalId = 0;
	int departmentId = 0;
	int meScaleNo = 0;
	
	session = request.getSession();
	
	if (session.getAttribute("deptId") != null)
		departmentId = Integer.parseInt("" + session.getAttribute("deptId"));
	
	requestParameters.put("departmentId", departmentId);
	
	hospitalId = (Integer)(session.getAttribute("hospitalId"));
	requestParameters.put("hospitalId", hospitalId);
	
	try {
			
		if ((request.getParameter("meScaleNo")) != null && !(request.getParameter("meScaleNo").equals(""))) 
		{
			meScaleNo = (Integer.parseInt(request.getParameter("meScaleNo")));
			requestParameters.put("meScaleNo", meScaleNo);
		}

	} catch (Exception e) {
		e.printStackTrace();
	}

	Map<String, Object> connectionMap = storesHandlerService.getConnectionForReport();
	
	try
	{
	HMSUtil.generateReport("MeScaleReport", requestParameters, (Connection) connectionMap.get("con"), response, getServletContext());
	}
	catch (Exception e) {
		e.printStackTrace();
	}

	return new ModelAndView("index", "map", map);
}


public ModelAndView printBOSJsp(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	title = "Board Of Survey REPORT";
	List<StoreBosM> storeBosMList = nonExpendableStoresHandlerService.printBOSJsp();
	jsp = PRINT_BOS_JSP;
	jsp = jsp + ".jsp";
	map.put("storeBosMList", storeBosMList);
	map.put("contentJsp", jsp);
	map.put("title", title);

	return new ModelAndView("index", "map", map);
}
public ModelAndView generatePrintBOSJsp(HttpServletRequest request,
		HttpServletResponse response) {
	
	Map<String, Object> requestParameters = new HashMap<String, Object>();
	byte[] bytes = null;


	String bosNo="";
	HttpSession session = request.getSession();
	session = request.getSession();
	try {

		if (request.getParameter(BOS_ID) != null
				&& !(request.getParameter(BOS_ID).equals(""))) {
			bosNo = request.getParameter(BOS_ID);
		}
		requestParameters.put("bosNo", bosNo);
	} catch (Exception e) {
		e.printStackTrace();
	}
	Map<String, Object> detailsMap = nonExpendableStoresHandlerService.getConnectionForReport();

    HMSUtil.generateReport("printBos", requestParameters, (Connection)detailsMap.get("con"), response, getServletContext());
	return null;
}
//----
public ModelAndView addBrandDetailsForEquipLoanOut(HttpServletRequest request,
		HttpServletResponse response) throws java.text.ParseException {
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
	Integer count = Integer.parseInt(""+request.getParameter("counter"));

	// --------------------------------------------------------------------------------
	Map map = new HashMap();
	Box box = HMSUtil.getBox(request);
	String messageTOBeVisibleToTheUser = "";
	box.put("hospitalId", hospitalId);
	box.put("deptId", deptId);
	box.put("count", count);
	map = nonExpendableStoresHandlerService.addBrandDetailsForEquipLoanOut(box);
	String successfullyAdded = "n";

	if (map.get("successfullyAdded") != null) {
		successfullyAdded = "" + map.get("successfullyAdded");
	}
	if (successfullyAdded.equals("y")) {
		messageTOBeVisibleToTheUser = "Equipment Loanout entry saved successfully.";
	} else {
		messageTOBeVisibleToTheUser = "Equipment Loanout not saved.";
	}
	//jsp = RequestConstants.EXIT_WINDOW;
	String url= "/hms/hms/neStores?method=showEquipmentLoanOutEntry";
	jsp="message.jsp";
	map.put("contentJsp", jsp);
	map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
	map.put("url", url);
	return new ModelAndView("indexB", "map", map);
}
public ModelAndView searchEquipmentLoanOut(HttpServletRequest request,
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
	int issueId = 0;
	if (request.getParameter(RequestConstants.ISSUE_UNIT_ID) != null) {
		issueId = Integer.parseInt(request.getParameter(ISSUE_UNIT_ID));
	}
	Map map = new HashMap();
	Box box = HMSUtil.getBox(request);
	box.put("issueId", issueId);
	box.put("deptId", deptId);
	if (issueId != 0)
		map = nonExpendableStoresHandlerService.searchEquipmentLoanOut(box);
	jsp = "searchEquipmentLoanOut";
	jsp = jsp + ".jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("indexB", "map", map);
}
}
