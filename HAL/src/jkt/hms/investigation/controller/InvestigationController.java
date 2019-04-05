package jkt.hms.investigation.controller;

import static jkt.hms.util.RequestConstants.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;
import jkt.hms.investigation.handler.InvestigationHandlerService;
import jkt.hms.masters.business.DgFixedValue;
import jkt.hms.masters.business.DgMasCollection;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgNormalValue;
import jkt.hms.masters.business.DgOrderdt;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DgResultEntryDetail;
import jkt.hms.masters.business.DgResultEntryDetailSen;
import jkt.hms.masters.business.DgResultEntryHeader;
import jkt.hms.masters.business.DgSampleCollectionDetails;
import jkt.hms.masters.business.DgSampleCollectionHeader;
import jkt.hms.masters.business.DgSubMasInvestigation;
import jkt.hms.masters.business.DgTemplate;
import jkt.hms.masters.business.DgUom;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasSample;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.MasSubTest;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.StoreStockTakingM;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.hibernate.Session;
import org.springframework.web.bind.RequestUtils;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class InvestigationController extends MultiActionController {
	InvestigationHandlerService investigationHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	
	// -------------------------------------------------------------------------------------------------------------
	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	public InvestigationHandlerService getInvestigationHandlerService() {
		return investigationHandlerService;
	}

	public void setInvestigationHandlerService(
			InvestigationHandlerService investigationHandlerService) {
		this.investigationHandlerService = investigationHandlerService;
	}

	
	// -------------------------------------------------------------------------------------------------------------------
	String jsp = "";
	String title = "";
	String url = "";
	String currentTime = "";
	String pojoName = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String message = "";
	HttpSession session = null;
	Map<String, Object> map = new HashMap<String, Object>();

	// ----------------------- investigation master
	// ---------------------------------------
	/** method to show investigation master **/
	public ModelAndView showInvestigationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		int userId = 0;
		int mainChargecodeId = 0;
		int subChargecodeId = 0;
		int chargeCodeId = 0;
		String investigationName = "";
		String deptType = "";
		int pageNoTempFromBackButton = 0;

		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptType") != null)
			deptType = (String) session.getAttribute("deptType");
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		Box box = HMSUtil.getBox(request);
		box.put("deptId", deptId);
		Map<String, Object> map = new HashMap<String, Object>();
		if (request.getParameter(MAIN_CHARGECODE_ID) != null
				&& request.getParameter(MAIN_CHARGECODE_ID) != "") {
			mainChargecodeId = Integer.parseInt(request
					.getParameter(MAIN_CHARGECODE_ID));
		}
		if (request.getParameter("subChargecodeId") != null
				&& request.getParameter("subChargecodeId") != "") {
			subChargecodeId = Integer.parseInt(request
					.getParameter("subChargecodeId"));
		}
		if (request.getParameter(CHARGE_CODE_ID) != null) {
			chargeCodeId = Integer.parseInt(request
					.getParameter(CHARGE_CODE_ID));
		}
		if (request.getParameter(INVESTIGATION_NAME) != null) {
			investigationName = request.getParameter(INVESTIGATION_NAME);
		}
		if (request.getParameter("pageNoTempFromBackButton") != null) {
			pageNoTempFromBackButton = Integer.parseInt(request
					.getParameter("pageNoTempFromBackButton"));
		}

		map = investigationHandlerService.showInvestigationJsp(box);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("pageNoTempFromBackButton", pageNoTempFromBackButton);
		map.put("userName", userName);
		map.put("investigationName", investigationName);
		map.put("subChargecodeId", subChargecodeId);
		map.put("mainChargecodeId", mainChargecodeId);
		map.put("chargeCodeId", chargeCodeId);
		String jsp = INVESTIGATION_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public boolean checkInvestigationExsist(String investigationCode,
			String investigationName) {
		boolean investigationExsist = investigationHandlerService
				.checkInvestigationExsist(investigationCode, investigationName);
		return investigationExsist;
	}

	/** method to add investigations **/
	@SuppressWarnings( { "unchecked", "deprecation" })
	public ModelAndView addInvestigation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		MasSubTest masSubTest = new MasSubTest();
		HttpSession session = request.getSession();
		DgMasInvestigation dgmasInvestigation = new DgMasInvestigation();
		MasMainChargecode masMainChargecode = new MasMainChargecode();
		String checkBoxConfidence = null, checkBoxDischargeSummary = null, subTestRecords = null;
		Date currentDate = new Date();
		int mainChargecodeId = 0;
		int subChargecodeId = 0;
		int sampleId = 0;
		int unitOfMeasurementId = 0;
		String name = "";
		int chargeCodeId = 0;
		String normalValue = "";
		String numericOrString = "";
		String investigationType = "";
		String quantity = "";
		Box box = HMSUtil.getBox(request);
		String minNormalValue = "";
		String maxNormalValue = "";
		int collectionId = 0;
		int investigationId1 = 0;

		if (request.getParameter(NORMAL_VALUE) != null) {
			normalValue = request.getParameter(NORMAL_VALUE);

		}
		if (request.getParameter(MIN_NORMAL_VALUE) != null) {
			minNormalValue = request.getParameter(MIN_NORMAL_VALUE);

		}
		if (request.getParameter(MAX_NORMAL_VALUE) != null) {
			maxNormalValue = request.getParameter(MAX_NORMAL_VALUE);

		}
		if (request.getParameter(INVESTIGATION_NAME) != null) {
			name = request.getParameter(INVESTIGATION_NAME);

		}

		if (request.getParameter(INVESTIGATION_TYPE) != null) {
			investigationType = request.getParameter(INVESTIGATION_TYPE);

		}

		if (request.getParameter(QUANTITY) != null) {
			quantity = request.getParameter(QUANTITY);

		}
		String instruction = "";
		if(request.getParameter("instructions")!= null){
			instruction = request.getParameter("instructions");
		}
		if (request.getParameter(NUMERIC_OR_STRING) != null) {
			numericOrString = request.getParameter(NUMERIC_OR_STRING);
		}

		if (request.getParameter(MAIN_CHARGECODE_ID) != null) {
			mainChargecodeId = Integer.valueOf(request
					.getParameter(MAIN_CHARGECODE_ID));

		}
		if (request.getParameter(SUB_CHARGECODE_ID) != null) {
			subChargecodeId = Integer.parseInt(request
					.getParameter(SUB_CHARGECODE_ID));

		}
		if (request.getParameter("investigationId1") != null
				&& (!request.getParameter("investigationId1").equals("0"))) {
			investigationId1 = Integer.parseInt(request
					.getParameter("investigationId1"));
		}

		if (request.getParameter(SAMPLE_ID) != null
				&& (!request.getParameter(SAMPLE_ID).equals("0"))) {
			sampleId = Integer.parseInt(request.getParameter(SAMPLE_ID));
		}
		if (request.getParameter(CHARGE_CODE_ID) != null) {
			chargeCodeId = Integer.parseInt(request
					.getParameter(CHARGE_CODE_ID));

		}
		if (request.getParameter(COLLECTION_CENTER_ID) != null
				&& (!request.getParameter(COLLECTION_CENTER_ID).equals("0"))) {
			collectionId = Integer.parseInt(request
					.getParameter(COLLECTION_CENTER_ID));
		}
		if (request.getParameter(UNIT_OF_MEASUREMENT_ID) != null
				&& (!request.getParameter(UNIT_OF_MEASUREMENT_ID).equals("0"))) {
			unitOfMeasurementId = Integer.parseInt(request
					.getParameter(UNIT_OF_MEASUREMENT_ID));
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter("currentTime") != null
				&& !(request.getParameter("currentTime").equals(""))) {
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
		}

		checkBoxConfidence = RequestUtils.getStringParameter(request,
				CONFIDENTIAL, null);
		checkBoxDischargeSummary = RequestUtils.getStringParameter(request,
				DSICHARGE_SUMMARY, null);
		if (checkBoxConfidence == null) {
			dgmasInvestigation.setConfidential("n");
		} else {
			try {

				dgmasInvestigation.setConfidential(RequestUtils
						.getStringParameter(request, CONFIDENTIAL));
			} catch (ServletRequestBindingException e) {
				e.printStackTrace();
			}
		}
		if (checkBoxDischargeSummary == null) {
			dgmasInvestigation.setAppearInDischargeSummary("n");
		} else {
			try {
				dgmasInvestigation.setAppearInDischargeSummary(RequestUtils
						.getStringParameter(request, DSICHARGE_SUMMARY

						));
			} catch (ServletRequestBindingException e) {
				e.printStackTrace();
			}
		}
		String screenTest = "";
		if (request.getParameter(BLOOD_BANK_SCREEN) != null) {
			screenTest = "y";
		} else {
			screenTest = "n";
		}
		dgmasInvestigation.setBloodBankScreenTest(screenTest);
		String reactionTest = "";
		if (request.getParameter(BLOOD_REACTION_TEST) != null) {
			reactionTest = "y";
		} else {
			reactionTest = "n";
		}
		dgmasInvestigation.setBloodReactionTest(reactionTest);

		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");

		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		generalMap.put("name", name);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List chargeNameList = new ArrayList();
		if (listMap.get("duplicateGeneralNameList") != null) {
			chargeNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if (chargeNameList.size() == 0 || chargeNameList == null) {

			dgmasInvestigation.setId(investigationId1);
			dgmasInvestigation.setInvestigationName(name);
			dgmasInvestigation.setNormalValue(normalValue);

			dgmasInvestigation.setMinNormalValue(minNormalValue);
			dgmasInvestigation.setMaxNormalValue(maxNormalValue);
			if (unitOfMeasurementId != 0) {
				DgUom dgUom = new DgUom();
				dgUom.setId(unitOfMeasurementId);
				dgmasInvestigation.setUom(dgUom);
			}
			if (collectionId != 0) {
				DgMasCollection dgCollection = new DgMasCollection();
				dgCollection.setId(collectionId);
				dgmasInvestigation.setContainer(dgCollection);
			}

			masMainChargecode.setId(mainChargecodeId);
			dgmasInvestigation.setMainChargecode(masMainChargecode);
			dgmasInvestigation.setInvestigationType(investigationType);

			MasChargeCode masChargeCode = new MasChargeCode();
			masChargeCode.setId(chargeCodeId);
			dgmasInvestigation.setChargeCode(masChargeCode);

			MasSubChargecode massubChargecode = new MasSubChargecode();
			massubChargecode.setId(subChargecodeId);
			dgmasInvestigation.setSubChargecode(massubChargecode);

			if (sampleId != 0) {
				MasSample masSample = new MasSample();
				masSample.setId(sampleId);
				dgmasInvestigation.setSample(masSample);
			}
			dgmasInvestigation.setInstructions(instruction);
			dgmasInvestigation.setQuantity(quantity);
			dgmasInvestigation.setNumericOrString(numericOrString);
			dgmasInvestigation.setStatus("y");
			dgmasInvestigation.setLastChgBy("admin");
			dgmasInvestigation.setLastChgDate(currentDate);
			dgmasInvestigation.setLastChgTime(currentTime);
			successfullyAdded = investigationHandlerService
					.addInvestigation(dgmasInvestigation);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !";

			}
		} else if (chargeNameList.size() != 0 || chargeNameList != null) {
			if (chargeNameList.size() != 0 || chargeNameList != null) {
				message = "Charge Name already exists.";
			}
		}
		try {
			map = investigationHandlerService.showInvestigationJsp(box);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = INVESTIGATION_JSP;
		title = "Investigation";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	/** end of add investigation method **/

	/** start of search investigation method **/
	@SuppressWarnings("deprecation")
	public ModelAndView searchInvestigation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String investigationCode = null;
		String investigationName = null;
		String searchField = null;
		int searchModality=0;
		int deptId=0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		
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
			if (request.getParameter("searchModality") != null
					&& (!request.getParameter("searchModality").equals("0"))) {
				searchModality = Integer.parseInt(request.getParameter("searchModality"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (searchRadio == 1) {
			investigationName = searchField;
			searchModality = 0;
		} else {
			investigationName = null;
			
		}
		map = investigationHandlerService.searchInvestigation(searchModality, investigationName,deptId);
		jsp = INVESTIGATION_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("investigationCode", investigationCode);
		map.put("investigationName", investigationName);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView generateReportForInvestigationMasters(HttpServletRequest request, HttpServletResponse response)
	{	String hospitalName="";
		String jasper = "";
		if (request.getParameter(JASPER_FILE_NAME)!=null)
		{
			jasper = request.getParameter(JASPER_FILE_NAME);
		}
		int searchRadio = 0;
		String investigationName = null;
		System.out.println("jasper------------------"+jasper);
		int hospitalId=0;
		String searchField = null;
		int searchModality=0;
		String qry="";
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		if (request.getParameter(SEARCH_FIELD) != null
				&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
			searchField = request.getParameter(SEARCH_FIELD);
		}
		if (request.getParameter(SELECTED_RADIO) != null
				&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
			searchRadio = Integer.parseInt(request
					.getParameter(SELECTED_RADIO));
		}
		if (request.getParameter("searchModality") != null
				&& (!request.getParameter("searchModality").equals("0"))) {
			searchModality = Integer.parseInt(request.getParameter("searchModality"));
		}
		System.out.println(searchRadio+"-------------------------");
		if (searchRadio == 1) {
			investigationName = searchField;
			searchModality = 0;
			qry =" and  dg_mas_investigation.investigation_name like '%"+investigationName +"%'";
			
		} else if (searchRadio == 2) {
			investigationName = null;
			qry =" and  mas_sub_chargecode.sub_chargecode_id="+searchModality;
			
		}
		else{
			qry =" ";
		}
		int deptId=0;
		if (session.getAttribute("deptId") != null){
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			parameters.put("deptId", deptId);
		}

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			hospitalName = investigationHandlerService.getHospitalName(hospitalId);
			parameters.put("hospitalName", hospitalName);
			parameters.put("hospitalId", hospitalId);
			
		}
		parameters.put("qry", qry);
		String userHome = getServletContext().getRealPath("");	         
        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
        Map<String, Object> connectionMap  = investigationHandlerService.getConnectionForReport();
		parameters.put("path", imagePath);
		parameters.put("hospitalName", hospitalName);
		HMSUtil.generateReport(jasper, parameters, (Connection)connectionMap.get("conn"), response, getServletContext());
		return null;
	}


	/** end of search investigation method **/

	/** start of edit investigation method **/
	public ModelAndView editInvestigation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		DgMasInvestigation dgmasInvestigation = new DgMasInvestigation();
		String changedBy = "";
		String checkBoxConfidence = "", checkBoxDischargeSummary = "";
		String investigationName = "";
		int investigationId = 0;
		int chargeCodeId = 0;
		int mainChargeId = 0;
		int subChargeId = 0;
		int sampleId = 0;
		int unitOfResult = 0;
		String normalValue = "";
		String minNormalValue = "";
		String maxNormalValue = "";
		String numericOrString = "";
		String quantity = "";
		int collectionId = 0;
		String investigationType = "";
		String changedTime = "";

		Date changedDate = null;
		// ///////////////
		/*int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}*/
		HttpSession session = request.getSession();
		String deptType = "";
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}

		// ////////////////
		if (request.getParameter(INVESTIGATION_ID) != null
				&& (!request.getParameter(INVESTIGATION_ID).equals("0"))) {
			investigationId = Integer.parseInt(request
					.getParameter(INVESTIGATION_ID));
		}
		if (request.getParameter(MAIN_CHARGECODE_ID) != null
				&& (!request.getParameter(MAIN_CHARGECODE_ID).equals("0"))) {
			mainChargeId = Integer.parseInt(request
					.getParameter(MAIN_CHARGECODE_ID));
		}

		if (request.getParameter(SUB_CHARGECODE_ID) != null
				&& (!request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
			subChargeId = Integer.parseInt(request
					.getParameter(SUB_CHARGECODE_ID));
		}
		if (request.getParameter(CHARGE_CODE_ID) != null
				&& (!request.getParameter(CHARGE_CODE_ID).equals("0"))) {
			chargeCodeId = Integer.parseInt(request
					.getParameter(CHARGE_CODE_ID));
		}

		if (request.getParameter(INVESTIGATION_NAME) != null
				&& !(request.getParameter(INVESTIGATION_NAME).equals(""))) {
			investigationName = (request.getParameter(INVESTIGATION_NAME));
		}
		if (!deptType.equalsIgnoreCase("radio")) {
			if (request.getParameter(SAMPLE_ID) != null
					&& (!request.getParameter(SAMPLE_ID).equals("0"))) {
				sampleId = Integer.parseInt(request.getParameter(SAMPLE_ID));
			}

			if (request.getParameter(COLLECTION_CENTER_ID) != null
					&& (!request.getParameter(COLLECTION_CENTER_ID).equals("0"))) {
				collectionId = Integer.parseInt(request
						.getParameter(COLLECTION_CENTER_ID));
			}
			

			if (request.getParameter(UNIT_OF_MEASUREMENT_ID) != null
					&& (!request.getParameter(UNIT_OF_MEASUREMENT_ID).equals(
							"0"))) {
				unitOfResult = Integer.parseInt(request
						.getParameter(UNIT_OF_MEASUREMENT_ID));
			}

			if (request.getParameter(QUANTITY) != null
					&& !(request.getParameter(QUANTITY).equals(""))) {
				quantity = (request.getParameter(QUANTITY));
			}
			if (request.getParameter(NUMERIC_OR_STRING) != null
					&& !(request.getParameter(NUMERIC_OR_STRING).equals(""))) {
				numericOrString = (request.getParameter(NUMERIC_OR_STRING));
			}
			if (request.getParameter(NORMAL_VALUE) != null
					&& !(request.getParameter(NORMAL_VALUE).equals(""))) {
				normalValue = (request.getParameter(NORMAL_VALUE));
			}
			if (request.getParameter(MIN_NORMAL_VALUE) != null
					&& !(request.getParameter(MIN_NORMAL_VALUE).equals(""))) {
				minNormalValue = (request.getParameter(MIN_NORMAL_VALUE));
			}
			if (request.getParameter(MAX_NORMAL_VALUE) != null
					&& !(request.getParameter(MAX_NORMAL_VALUE).equals(""))) {
				maxNormalValue = (request.getParameter(MAX_NORMAL_VALUE));
			}
		}
		
		if (request.getParameter(INVESTIGATION_TYPE) != null
				&& !(request.getParameter(INVESTIGATION_TYPE).equals(""))) {
			investigationType = (request.getParameter(INVESTIGATION_TYPE));
		}
		if (request.getParameter(CONFIDENTIAL) != null
				&& !(request.getParameter(CONFIDENTIAL).equals(""))) {
			checkBoxConfidence = (request.getParameter(CONFIDENTIAL));
		}
		if (request.getParameter(DSICHARGE_SUMMARY) != null
				&& !(request.getParameter(DSICHARGE_SUMMARY).equals(""))) {
			checkBoxDischargeSummary = (request.getParameter(DSICHARGE_SUMMARY));
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

		String screenTest = "";
		String reactionTest = "";

		if (request.getParameter(BLOOD_BANK_SCREEN) != null) {
			screenTest = "y";
		} else {
			screenTest = "n";
		}

		if (request.getParameter(RequestConstants.BLOOD_REACTION_TEST) != null) {
			reactionTest = "y";
		} else {
			reactionTest = "n";
		}
		String instruction = "";
		if(request.getParameter("instructions")!= null){
			instruction = request.getParameter("instructions");
		}
		generalMap.put("screenTest", screenTest);
		generalMap.put("reactionTest", reactionTest);
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("investigationId", investigationId);
		generalMap.put("instruction", instruction);
		generalMap.put("mainChargeId", mainChargeId);
		generalMap.put("subChargeId", subChargeId);
		generalMap.put("chargeCodeId", chargeCodeId);
		generalMap.put("investigationName", investigationName);
		generalMap.put("minNormalValue", minNormalValue);
		generalMap.put("maxNormalValue", maxNormalValue);
		generalMap.put("investigationType", investigationType);
		generalMap.put("checkBoxConfidence", checkBoxConfidence);
		generalMap.put("checkBoxDischargeSummary", checkBoxDischargeSummary);
		generalMap.put("normalValue", normalValue);
		generalMap.put("numericOrString", numericOrString);
		generalMap.put("quantity", quantity);
		generalMap.put("unitOfResult", unitOfResult);
		generalMap.put("collectionId", collectionId);
		generalMap.put("sampleId", sampleId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingInvestigationNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingInvestigationNameList.size() == 0) {
			dataUpdated = investigationHandlerService
					.editInvestigation(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingInvestigationNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/investigation?method=showInvestigationJsp";
		Box box = HMSUtil.getBox(request);
		try {
			map = investigationHandlerService.showInvestigationJsp(box);

		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = INVESTIGATION_JSP;
		title = "edit Investigation";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}
	public ModelAndView showInstructionsPopupJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int investigationId = 0;
		if(request.getParameter(INVESTIGATION_ID)!= null && !request.getParameter(INVESTIGATION_ID).equals("")){
			investigationId =Integer.parseInt(request.getParameter(INVESTIGATION_ID));
			map = investigationHandlerService.showInstructionsPopupJsp(investigationId);	
		}
		String jsp = "instructionPopup";
		map.put("contentJsp", jsp);
		
		return new ModelAndView(jsp, "map", map);
	}


	/** end of edit investigation method **/

	/** start of delete investigation method **/
	@SuppressWarnings("deprecation")
	public ModelAndView deleteInvestigation(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int investigationId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		Box box = HMSUtil.getBox(request);
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}

		if (request.getParameter(INVESTIGATION_ID) != null
				&& !(request.getParameter(INVESTIGATION_ID).equals(""))) {
			investigationId = Integer.parseInt(request
					.getParameter(INVESTIGATION_ID));
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
		dataDeleted = investigationHandlerService.deleteInvestigation(
				investigationId, generalMap);
		if (dataDeleted == true) {

			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/investigation?method=showInvestigationJsp";
		try {
			map = investigationHandlerService.showInvestigationJsp(box);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = INVESTIGATION_JSP;
		title = "Delete Investigation";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	/** end of delete investigation method **/

	/** method for subInvestigation screen **/
	public ModelAndView showSubInvestigationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map dataMap = new HashMap<String, Object>();
		int mainChargecodeId = 0;
		int subChargeCodeId = 0;
		int chargeCodeId = 0;
		String investigationName = "";
		String confidential = "";
		String investigationType = "";
		String dischargeSummary = "";
		int sampleId = 0;
		String quantity = "";
		int collectionCenterId = 0;
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		map = investigationHandlerService.showInvestigationJsp(box);
		int pageNo = 1;
		int pageNoTemp = 0;
		// //////////////////
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		// /////////////////
		if (request.getParameter("pageNo") != null)
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		if (request.getParameter(MAIN_CHARGECODE_ID) != null
				&& request.getParameter(MAIN_CHARGECODE_ID) != "") {
			mainChargecodeId = Integer.parseInt(request
					.getParameter(MAIN_CHARGECODE_ID));
		}
		if (request.getParameter(SUB_CHARGECODE_ID) != null) {
			subChargeCodeId = Integer.parseInt(request
					.getParameter(SUB_CHARGECODE_ID));
		}
		if (request.getParameter(CHARGE_CODE_ID) != null) {
			chargeCodeId = Integer.parseInt(request
					.getParameter(CHARGE_CODE_ID));
		}

		if (request.getParameter(INVESTIGATION_NAME) != null) {
			investigationName = request.getParameter(INVESTIGATION_NAME);
		}
		if (request.getParameter(CONFIDENTIAL) != null) {
			confidential = request.getParameter(CONFIDENTIAL);
		}
		if (request.getParameter(QUANTITY) != null) {
			quantity = request.getParameter(QUANTITY);
		}
		if (request.getParameter(INVESTIGATION_TYPE) != null) {
			investigationType = request.getParameter(INVESTIGATION_TYPE);
		}
		if (request.getParameter(DSICHARGE_SUMMARY) != null) {
			dischargeSummary = request.getParameter(DSICHARGE_SUMMARY);
		}
		if (request.getParameter("pageNoTemp") != null) {
			pageNoTemp = Integer.parseInt(request.getParameter("pageNoTemp"));
		}

		if (deptId != 49) {
			if (request.getParameter(SAMPLE_ID) != null) {
				sampleId = Integer.parseInt(request.getParameter(SAMPLE_ID));
			}
			if (request.getParameter(COLLECTION_CENTER_ID) != null) {
				collectionCenterId = Integer.parseInt(request
						.getParameter(COLLECTION_CENTER_ID));
			}
		}
		List investigationList = new ArrayList();
		investigationList = investigationHandlerService.getChargeList(box);
		String jsp = "";
		if (investigationList.size() > 0) {
			jsp = "updateSubTest";
			map.put("investigationList", investigationList);
		} else {
			jsp = "investigationSubTest";
		}
		jsp += ".jsp";
		map.put("pageNoTemp", pageNoTemp);
		map.put("mainChargecodeId", mainChargecodeId);
		map.put("subChargeCodeId", subChargeCodeId);
		map.put("chargeCodeId", chargeCodeId);
		map.put("investigationName", investigationName);
		map.put("confidential", confidential);
		map.put("investigationType", investigationType);
		map.put("dischargeSummary", dischargeSummary);
		map.put("sampleId", sampleId);
		map.put("collectionCenterId", collectionCenterId);
		map.put("dataMap", dataMap);
		map.put("pageNo", pageNo);
		map.put("contentJsp", jsp);
		map.put("quantity", quantity);

		return new ModelAndView("index", "map", map);
	}

	/** end of method of subinvestigation screen **/

	/*
	 * public ModelAndView responseForSubCharge(HttpServletRequest request,
	 * HttpServletResponse response) { Map<String, Object> map = new
	 * HashMap<String, Object>(); Box box = HMSUtil.getBox(request);
	 * map=(Map<String
	 * ,Object>)investigationHandlerService.getResponseSubchargeList(box);
	 * jsp="responseForSubCharge"; return new ModelAndView(jsp,"map", map); }
	 */

	/*
	 * public ModelAndView responseForCharge(HttpServletRequest request,
	 * HttpServletResponse response) { Box box = HMSUtil.getBox(request);
	 * Map<String, Object> map = new HashMap<String, Object>(); map =
	 * investigationHandlerService.getChargeDetails(box);
	 * jsp=INVESTIGATION_CHARGE_JSP; return new ModelAndView(jsp,"map", map); }
	 */
	/*
	 * public ModelAndView showParameterJsp(HttpServletRequest request,
	 * HttpServletResponse response) { Box box = HMSUtil.getBox(request);
	 * Map<String, Object> map = new HashMap<String, Object>();
	 * map=investigationHandlerService.getParameterDetails(box); jsp =
	 * INVESTIGATION_SUBTEST_JSP; //jsp += ".jsp"; //map.put("contentJsp", jsp);
	 * return new ModelAndView(jsp, "map", map); }
	 */
	/*
	 * method to add the subtest
	 */
	/** method to add subTest **/
	public ModelAndView submitSubTest(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String message = null;
		String name = "";
		String addOnlyInSubMasInvesrigation = "";

		boolean dataSaved = false;
		Box box = HMSUtil.getBox(request);
		map = investigationHandlerService.showInvestigationJsp(box);
		if (map != null) {
			map.put("uomList", map.get("uomList"));
		}
		if (request.getParameter(INVESTIGATION_NAME) != null) {
			name = request.getParameter(INVESTIGATION_NAME);

		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");

		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		generalMap.put("name", name);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List chargeNameList = new ArrayList();
		if (listMap.get("duplicateGeneralNameList") != null) {
			chargeNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		if (chargeNameList == null || chargeNameList.size() == 0) {
			infoMap = investigationHandlerService.addSubTest(box, dataMap);
			if ((Boolean) infoMap.get("dataSaved") == true) {
				message = "Data Successfully Saved !!";
			} else {
				message = "Data cannot be saved !!";
			}
			jsp = "investigationSubTest";
		} else if (chargeNameList.size() != 0 || chargeNameList != null) {
			if (request.getParameter("addInSubMas") != null) {
				addOnlyInSubMasInvesrigation = request
						.getParameter("addInSubMas");

				dataMap.put("dgMasInvestigationListForUpdateList",
						chargeNameList);
				infoMap = investigationHandlerService
						.addSubTestWithoutAddingInMasInvestigation(box, dataMap);
				jsp = "investigationSubTest";

			} else {
				message = "Charge Name already exists.";
				jsp = "investigation";
			}
		}

		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		if (infoMap != null) {
			map
					.put("subInvestigationlist", infoMap
							.get("subInvestigationlist"));
		}
		return new ModelAndView("index", "map", map);
	}

	/** end of method to add subtest **/

	/** method to submit normal values **/
	public ModelAndView submitNormalValues(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String message = null;
		boolean dataSaved = false;
		Box box = HMSUtil.getBox(request);
		int amcTDetailsListSize = Integer.parseInt(request
				.getParameter("amcTDetailsListSize"));
		box.put("amcTDetailsListSize", amcTDetailsListSize);
		dataSaved = investigationHandlerService.submitNormalValues(box);
		if (dataSaved == true) {
			message = "Data Successfully Saved !!";
		} else {
			message = "Data cannot be saved !!";
		}
		jsp = "normalValue";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	/** end of method to submit normal values * */

	/** method to submit fixed values * */
	public ModelAndView submitFixedValues(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String message = null;
		boolean dataSaved = false;
		Box box = HMSUtil.getBox(request);
		dataSaved = investigationHandlerService.submitFixedValues(box);
		if (dataSaved == true) {
			message = "Data Successfully Saved !!";
		} else {
			message = "Data cannot be saved !!";
		}
		jsp = "fixedValue";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	/** end of method to submit fixed values **/

	/**
	 * start of method to submit template *
	 * 
	 * @throws IOException
	 */
	public ModelAndView submitTemplate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		DgMasInvestigation dgMasInv = new DgMasInvestigation();
		DgTemplate dgTemp = new DgTemplate();

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		InputStream in = null;
		String message = null;
		boolean dataSaved = false;
		if (map != null) {
			map = (Map) session.getAttribute("map");
		}
		int mainChargecodeId = 0;
		int chargeCodeId = 0;
		int subChargeCodeId = 0;
		int sampleId = 0;
		int collectionCenterId = 0;
		int unitOfMeasurementId = 0;
		String investigationName = "";
		String confidential = "";
		String investigationType = "";
		String dischargeSummary = "";
		byte result[] = null;
		String quantity = "";
		String minNormalValue = "";
		String maxNormalValue = "";
		String normalValue = "";
		byte data[] = null;
		mainChargecodeId = (Integer) map.get("mainChargecodeId");
		chargeCodeId = (Integer) map.get("chargeCodeId");
		subChargeCodeId = (Integer) map.get("subChargeCodeId");
		sampleId = (Integer) map.get("sampleId");
		collectionCenterId = (Integer) map.get("collectionCenterId");
		unitOfMeasurementId = (Integer) map.get("unitOfMeasurementId");
		investigationName = (String) map.get("investigationName");
		confidential = (String) map.get("confidential");
		investigationType = (String) map.get("investigationType");
		dischargeSummary = (String) map.get("dischargeSummary");
		quantity = (String) map.get("quantity");
		// result =(String)map.get("content");
		minNormalValue = (String) map.get("minNormalValue");
		maxNormalValue = (String) map.get("maxNormalValue");
		normalValue = (String) map.get("normalValue");

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		dgMasInv.setId(chargeCodeId);
		dgMasInv.setInvestigationName(investigationName);
		dgMasInv.setAppearInDischargeSummary(dischargeSummary);
		dgMasInv.setInvestigationType(investigationType);
		dgMasInv.setConfidential(confidential);
		dgMasInv.setNormalValue(normalValue);
		dgMasInv.setMinNormalValue(minNormalValue);
		dgMasInv.setMaxNormalValue(maxNormalValue);

		MasSubChargecode masSubChargecode = new MasSubChargecode();
		masSubChargecode.setId(subChargeCodeId);
		dgMasInv.setSubChargecode(masSubChargecode);

		MasChargeCode masChargeCode = new MasChargeCode();
		masChargeCode.setId(chargeCodeId);
		dgMasInv.setChargeCode(masChargeCode);

		MasMainChargecode masMainChargecode = new MasMainChargecode();
		masMainChargecode.setId(mainChargecodeId);
		dgMasInv.setMainChargecode(masMainChargecode);
		if (sampleId != 0) {
			MasSample masSample = new MasSample();
			masSample.setId(sampleId);
			dgMasInv.setSample(masSample);
		}
		if (collectionCenterId != 0) {
			DgMasCollection dgMasCollection = new DgMasCollection();
			dgMasCollection.setId(collectionCenterId);
			dgMasInv.setContainer(dgMasCollection);
		}
		if (unitOfMeasurementId != 0) {
			DgUom dgUom = new DgUom();
			dgUom.setId(unitOfMeasurementId);
			dgMasInv.setUom(dgUom);
		}
		dgMasInv.setStatus("y");
		dgMasInv.setQuantity(quantity);
		dgMasInv.setLastChgBy("admin");
		dgMasInv.setLastChgDate(date);
		dgMasInv.setLastChgTime(time);
		if (investigationType.contains("m")) {
			dgMasInv.setMultipleResults("y");
		} else {
			dgMasInv.setMultipleResults("n");
		}
		try {

			// File temprory=new
			// File(getServletContext().getRealPath("/temp/"+"temp.html") );
			// long length=temprory.length();
			// FileInputStream fis=new
			// FileInputStream(getServletContext().getRealPath("/temp/"+"temp.html"));
			// byte[] bytes = new byte[(int)length];
			//
			// // Read in the bytes
			// int offset = 0;
			// int numRead = 0;
			// while ( (offset < bytes.length)
			// &&
			// ( (numRead=fis.read(bytes, offset, bytes.length-offset)) >= 0) )
			// {
			//
			// offset += numRead;
			//
			// }
			//
			// // Ensure all the bytes have been read in
			// if (offset < bytes.length) {
			// throw new IOException("Could not completely read file " +
			// temprory.getName());
			// }
			//
			// fis.close();

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

			String tepmlateData = mrequest.getParameter("test2");
			InputStream fis1 = new FileInputStream(getServletContext()
					.getRealPath("jsp/pdf/appendingHtml.html"));
			File temprory2 = new File(getServletContext().getRealPath(
					"jsp/pdf/appendingHtml.html"));

			byte[] b1 = new byte[(int) temprory2.length()];
			int offset1 = 0;
			int numRead1 = 0;
			try {
				while ((offset1 < b1.length)
						&& ((numRead1 = fis1.read(b1, offset1, b1.length
								- offset1)) >= 0)) {

					offset1 += numRead1;

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fis1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String appendedHtml = new String(b1);
			String finalFile = appendedHtml + tepmlateData + "</body></html>";

		//	String bytes = (String)finalFile.getBytes();

			dgTemp.setResult(finalFile);


			// dgTemp.setResult(result);
			
			
			dgTemp.setChargeCode(masChargeCode);
			dataMap.put("dgMasInv", dgMasInv);
			dataMap.put("dgTemp", dgTemp);

			/* validation for not duplicate entry of charge name */
			String name = "";
			if (request.getParameter(INVESTIGATION_NAME) != null) {
				name = request.getParameter(INVESTIGATION_NAME);

			}
			if (request.getParameter("pojoName") != null) {
				pojoName = request.getParameter("pojoName");

			}
			if (request.getParameter("pojoPropertyName") != null) {
				pojoPropertyName = request.getParameter("pojoPropertyName");
			}
			generalMap.put("name", name);
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
			listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);

			List chargeNameList = new ArrayList();
			if (listMap.get("duplicateGeneralNameList") != null) {
				chargeNameList = (List) listMap.get("duplicateGeneralNameList");
			}
			if (chargeNameList.size() == 0 || chargeNameList == null) {
				dataSaved = investigationHandlerService.submitTemplate(dataMap);
				if (dataSaved == true) {
					message = "Template Successfully Saved !!";
					List<DgTemplate> templateList = new ArrayList<DgTemplate>();
					templateList = investigationHandlerService
							.getTemplateList(chargeCodeId);
					map.put("templateList", templateList);
				} else {
					message = "Template cannot be saved !!";
				}
				jsp = "template";
			} else if (chargeNameList.size() != 0 || chargeNameList != null) {
				message = "Charge Name already exists.";
				jsp = "investigation";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/** method to submit template **/

	/** start of method to show normal value screen **/
	/*public ModelAndView showNormalValue(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int rowNo = 0;
		int subTestId = 0;
		int chargeCodeId = 0;
		if (request.getParameter("rowNo") != null) {
			rowNo = Integer.parseInt(request.getParameter("rowNo"));
		}

		if (request.getParameter("subTestId") != null) {
			subTestId = Integer.parseInt(request.getParameter("subTestId"));
		}
		if (request.getParameter("chargeCodeId") != null) {
			chargeCodeId = Integer.parseInt(request
					.getParameter("chargeCodeId"));
		}
		List<DgNormalValue> normalValueList = new ArrayList<DgNormalValue>();
		map = investigationHandlerService.getNormalValueDetails(box);
		if (map.get("normalValueList") != null) {
			normalValueList = (List<DgNormalValue>) map.get("normalValueList");
		}
		if (normalValueList.size() > 0) {
			jsp = UPDATE_NORMAL_VALUE_JSP;
		} else {
			jsp = NORMAL_VALUE_JSP;
		}
		title = "Normal Value";
		map.put("title", title);
		map.put("rowNo", rowNo);
		map.put("subTestId", subTestId);
		map.put("chargeCodeId", chargeCodeId);
		map.put("normalValueList", normalValueList);
		return new ModelAndView(jsp, "map", map);
	}*/
	
	public ModelAndView showNormalValue(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int rowNo = 0;
		int subTestId = 0;
		int chargeCodeId = 0;
		if (request.getParameter("rowNo") != null) {
			rowNo = Integer.parseInt(request.getParameter("rowNo"));
		}
		if (request.getParameter("subTestId") != null) {
			subTestId = Integer.parseInt(request.getParameter("subTestId"));
		}
		if (request.getParameter("chargeCodeId") != null) {
			chargeCodeId = Integer.parseInt(request
					.getParameter("chargeCodeId"));
		}
		List<DgNormalValue> normalValueList = new ArrayList<DgNormalValue>();
		map = investigationHandlerService.getNormalValueDetails(box);
		if (map.get("normalValueList") != null) {
			normalValueList = (List<DgNormalValue>) map.get("normalValueList");
		}
		if (normalValueList.size() > 0) {
			jsp = UPDATE_NORMAL_VALUE_JSP;
		} else {
			jsp = NORMAL_VALUE_JSP;
		}
		title = "Normal Value";
		map.put("title", title);
		map.put("rowNo", rowNo);
		map.put("subTestId", subTestId);
		map.put("chargeCodeId", chargeCodeId);
		map.put("normalValueList", normalValueList);
		return new ModelAndView(jsp, "map", map);
	}

	/** end of method to show normal value screen **/

	/** start of method to show fixed value jsp **/
	/*public ModelAndView showFixedValue(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int rowNo = 0;
		int subTestId = 0;
		int chargeCodeId = 0;
		if (request.getParameter("rowNo") != null) {
			rowNo = Integer.parseInt(request.getParameter("rowNo"));
		}
		if (request.getParameter("subTestId") != null) {
			subTestId = Integer.parseInt(request.getParameter("subTestId"));
		}
		if (request.getParameter("chargeCodeId") != null) {
			chargeCodeId = Integer.parseInt(request
					.getParameter("chargeCodeId"));
		}
		List<DgFixedValue> fixedList = new ArrayList<DgFixedValue>();
		map = investigationHandlerService.getFixedList(box);
		if (map.get("fixedList") != null) {
			fixedList = (List<DgFixedValue>) map.get("fixedList");
		}
		if (fixedList.size() > 0) {
			jsp = UPDATE_FIXED_VALUE_JSP;
		} else {
			jsp = FIXED_VALUE_JSP;
		}
		title = "Fixed Value";
		map.put("title", title);
		map.put("rowNo", rowNo);
		map.put("subTestId", subTestId);
		map.put("chargeCodeId", chargeCodeId);
		map.put("fixedList", fixedList);
		return new ModelAndView(jsp, "map", map);
	}*/

	/** end of method to show fixed value jsp **/
	
	/** start of method to show fixed value jsp * */
	public ModelAndView showFixedValue(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int rowNo = 0;
		int subTestId = 0;
		int chargeCodeId = 0;
		if (request.getParameter("rowNo") != null) {
			rowNo = Integer.parseInt(request.getParameter("rowNo"));
		}
		if (request.getParameter("subTestId") != null) {
			subTestId = Integer.parseInt(request.getParameter("subTestId"));
		}
		if (request.getParameter("chargeCodeId") != null) {
			chargeCodeId = Integer.parseInt(request
					.getParameter("chargeCodeId"));
		}
		List<DgFixedValue> fixedList = new ArrayList<DgFixedValue>();
		map = investigationHandlerService.getFixedList(box);
		if (map.get("fixedList") != null) {
			fixedList = (List<DgFixedValue>) map.get("fixedList");
		}
		if (fixedList.size() > 0) {
			jsp = UPDATE_FIXED_VALUE_JSP;
		} else {
			jsp = FIXED_VALUE_JSP;
		}
		title = "Fixed Value";
		map.put("title", title);
		map.put("rowNo", rowNo);
		map.put("subTestId", subTestId);
		map.put("chargeCodeId", chargeCodeId);
		map.put("fixedList", fixedList);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView viewSubTest(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = investigationHandlerService.getParameterDetails(box);
		jsp = VIEW_SUBTEST_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showUpdateSubTest(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int chargeCodeId = 0;
		int subTestId = 0;
		int mainChargecodeId = 0;
		int subChargeCodeId = 0;
		if (request.getParameter(CHARGE_CODE_ID) != null) {
			chargeCodeId = Integer.parseInt(request
					.getParameter(CHARGE_CODE_ID));
		}
		if (request.getParameter(SUBTEST_ID) != null) {
			subTestId = Integer.parseInt(request.getParameter(SUBTEST_ID));
		}
		if (request.getParameter(MAIN_CHARGECODE_ID) != null) {
			mainChargecodeId = Integer.parseInt(request
					.getParameter(MAIN_CHARGECODE_ID));
		}

		if (request.getParameter(SUB_CHARGECODE_ID) != null) {
			subChargeCodeId = Integer.parseInt(request
					.getParameter(SUB_CHARGECODE_ID));
		}
		map = investigationHandlerService.showInvestigationJsp(box);
		List investigationList = new ArrayList();
		investigationList = investigationHandlerService.getChargeList(box);
		jsp = "updateSubTest";
		title = "update SubTest";
		jsp += ".jsp";
		map.put("investigationList", investigationList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("chargeCodeId", chargeCodeId);
		map.put("mainChargecodeId", mainChargecodeId);
		map.put("subChargeCodeId", subChargeCodeId);
		map.put("subTestId", subTestId);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateSubTest(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);

		String messageTOBeVisibleToTheUser = "";
		boolean dataUpdated = false;
		dataUpdated = investigationHandlerService.updateSubTest(box);
		if (dataUpdated == false) {
			messageTOBeVisibleToTheUser = "Sub Test Updated Successfully !!";
		} else {
			messageTOBeVisibleToTheUser = "Sub Test Cant Be Updated !!";
		}
		url = "/hms/hms/investigation?method=showInvestigationJsp";
		jsp = "message";
		title = "update SubTest";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("url", url);
		return new ModelAndView("index", "map", map);
	}

	// =============== for template ==================
	public ModelAndView showTemplateJsp(HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException,
			IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		int mainChargecodeId = 0;
		int subChargeCodeId = 0;
		int chargeCodeId = 0;
		String investigationName = "";
		String confidential = "";
		String investigationType = "";
		String dischargeSummary = "";
		int sampleId = 0;
		String quantity = "";
		int collectionCenterId = 0;
		int unitOfMeasurementId = 0;
		int pageNoTemp = 0;
		// ///////////////
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		// ////////////////

		Box box = HMSUtil.getBox(request);
		map = investigationHandlerService.showInvestigationJsp(box);
		if (request.getParameter(MAIN_CHARGECODE_ID) != null
				&& request.getParameter(MAIN_CHARGECODE_ID) != "") {
			mainChargecodeId = Integer.parseInt(request
					.getParameter(MAIN_CHARGECODE_ID));
		}
		if (request.getParameter(SUB_CHARGECODE_ID) != null) {
			subChargeCodeId = Integer.parseInt(request
					.getParameter(SUB_CHARGECODE_ID));
		}
		if (request.getParameter(CHARGE_CODE_ID) != null) {
			chargeCodeId = Integer.parseInt(request
					.getParameter(CHARGE_CODE_ID));
		}
		if (request.getParameter("pageNoTemp") != null) {
			pageNoTemp = Integer.parseInt(request.getParameter("pageNoTemp"));
		}
		if (deptId != 49) {
			if (request.getParameter(UNIT_OF_MEASUREMENT_ID) != null) {
				unitOfMeasurementId = Integer.parseInt(request
						.getParameter(UNIT_OF_MEASUREMENT_ID));
			}
			if (request.getParameter(SAMPLE_ID) != null) {
				sampleId = Integer.parseInt(request.getParameter(SAMPLE_ID));
			}
			if (request.getParameter(COLLECTION_CENTER_ID) != null) {
				collectionCenterId = Integer.parseInt(request
						.getParameter(COLLECTION_CENTER_ID));
			}
			if (request.getParameter(QUANTITY) != null) {
				quantity = request.getParameter(QUANTITY);
			}
		}
		if (request.getParameter(INVESTIGATION_NAME) != null) {
			investigationName = request.getParameter(INVESTIGATION_NAME);
		}
		if (request.getParameter(CONFIDENTIAL) != null) {
			confidential = request.getParameter(CONFIDENTIAL);
		}
		if (request.getParameter(INVESTIGATION_TYPE) != null) {
			investigationType = request.getParameter(INVESTIGATION_TYPE);
		}
		if (request.getParameter(DSICHARGE_SUMMARY) != null) {
			dischargeSummary = request.getParameter(DSICHARGE_SUMMARY);
		}
		List<DgTemplate> templateList = new ArrayList<DgTemplate>();
		templateList = investigationHandlerService
				.getTemplateList(chargeCodeId);
		String jsp = "";
		String format = "";
		new File(getServletContext().getRealPath("/temp/")).mkdir();
		File tempFile = new File(getServletContext().getRealPath(
				"/temp/" + "temp.html"));
		if (!tempFile.exists()) {
			tempFile.createNewFile();

		}
		if (templateList.size() > 0) {
			jsp = "updateTemplate";
			// code for saving template to server path

			map.put("templateList", templateList);
			// codde for adding appended html
			String appendingHtml = "";
			String templatedata = "";
			String templateData = new String(templateList.get(0).getResult());
			if (!templateData.contains("<html xmlns:")) {
				InputStream is = new FileInputStream(getServletContext()
						.getRealPath("jsp/pdf/appendingHtml.html"));
				File temprory1 = new File(getServletContext().getRealPath(
						"jsp/pdf/appendingHtml.html"));

				byte[] b3 = new byte[(int) temprory1.length()];
				int offset = 0;
				int numRead = 0;
				while ((offset < b3.length)
						&& ((numRead = is.read(b3, offset, b3.length - offset)) >= 0)) {

					offset += numRead;

				}

				File temprory = new File(getServletContext().getRealPath(
						"/temp/" + "temp.html"));
				appendingHtml = new String(b3);
				templatedata = new String(templateList.get(0).getResult());
				templatedata = appendingHtml + templatedata + "</body></html>";
				FileOutputStream fos = new FileOutputStream(getServletContext()
						.getRealPath("/temp/" + "temp.html"));
				fos.write(templatedata.getBytes());
				map.put("appendedHtml", appendingHtml);
				fos.close();

				is.close();

			} else {

				FileOutputStream fos = new FileOutputStream(getServletContext()
						.getRealPath("/temp/" + "temp.html"));
				fos.write(templateList.get(0).getResult().getBytes());

				fos.close();
			}

		} else {
			jsp = TEMPLATE_JSP;
		}
		title = "Template";
		jsp += ".jsp";
		map.put("pageNoTemp", pageNoTemp);
		map.put("mainChargecodeId", mainChargecodeId);
		map.put("subChargeCodeId", subChargeCodeId);
		map.put("chargeCodeId", chargeCodeId);
		map.put("investigationName", investigationName);
		map.put("confidential", confidential);
		map.put("investigationType", investigationType);
		map.put("dischargeSummary", dischargeSummary);
		map.put("sampleId", sampleId);
		map.put("collectionCenterId", collectionCenterId);
		map.put("contentJsp", jsp);
		map.put("quantity", quantity);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("unitOfMeasurementId", unitOfMeasurementId);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateTemplate(HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException,
			IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		int templateId = 0;
		String result = "";
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
		String tepmlateData = mrequest.getParameter("test2");
		InputStream fis1 = new FileInputStream(getServletContext().getRealPath(
				"jsp/pdf/appendingHtml.html"));
		File temprory2 = new File(getServletContext().getRealPath(
				"jsp/pdf/appendingHtml.html"));

		byte[] b1 = new byte[(int) temprory2.length()];
		int offset1 = 0;
		int numRead1 = 0;
		try {
			while ((offset1 < b1.length)
					&& ((numRead1 = fis1.read(b1, offset1, b1.length - offset1)) >= 0)) {

				offset1 += numRead1;

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fis1.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String appendedHtml = new String(b1);
		String finalFile = appendedHtml + tepmlateData + "</body></html>";

	//	byte[] bytes = finalFile.getBytes();

		// //System.out.println("tepmlateData1 23 "+tepmlateData);
		// File temprory=new
		// File(getServletContext().getRealPath("/temp/"+"temp.html") );
		// long length=temprory.length();
		// FileInputStream fis=new
		// FileInputStream(getServletContext().getRealPath("/temp/"+"temp.html"));
		// byte[] bytes = new byte[(int)length];
		//
		// // Read in the bytes
		// int offset = 0;
		// int numRead = 0;
		// while ( (offset < bytes.length)
		// &&
		// ( (numRead=fis.read(bytes, offset, bytes.length-offset)) >= 0) ) {
		//
		// offset += numRead;
		//
		// }
		//
		// // Ensure all the bytes have been read in
		// if (offset < bytes.length) {
		// throw new IOException("Could not completely read file " +
		// temprory.getName());
		// }
		//
		// fis.close();
		map.put("result", finalFile);

		if (mrequest.getParameter(TEMPLATE_ID) != null) {
			templateId = Integer.parseInt(mrequest.getParameter(TEMPLATE_ID));
		}

		map.put("templateId", templateId);
		map.put("result", finalFile);
		String messageTOBeVisibleToTheUser = "";
		boolean dataUpdated = false;
		dataUpdated = investigationHandlerService.updateTemplate(map);
		if (dataUpdated == true) {
			messageTOBeVisibleToTheUser = "Template Updated Successfully !!";
		} else {
			messageTOBeVisibleToTheUser = "Template Cant Be Updated !!";
		}
		url = "/hms/hms/investigation?method=showInvestigationJsp";
		jsp = "message";
		title = "update Template";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("url", url);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView showUpdateTemplateInMsword(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			Box box = HMSUtil.getBox(request);

			// Runtime rt = Runtime.getRuntime();
			// String a=System.getenv("windir") +"\\system32\\WINWORD.exe";
			// //System.out.println("templateUrl"+a);
			// try{
			// Process p =
			// rt.exec("\"c:\\Program Files\\Microsoft Office\\Office\\WINWORD.exe\" E:\\shailesh\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\HMS\\templates\\masterTemplates\\1-8-22.doc");
			// }
			// catch(Exception e){
			// e.printStackTrace();
			// }

			if (session.getAttribute("url") != null) {

				File tempFile = new File((String) session.getAttribute("url"));

				int lenght = (int) tempFile.length();
				byte data[] = new byte[lenght];

				ServletOutputStream out = response.getOutputStream();
				response.setContentLength(lenght);
				response.setContentType("application/msword");
				response.setHeader("Content-disposition",
						"attachment; filename=" + "Example.doc");
				// out.write(data, 0, lenght);
				InputStream in = new FileInputStream(tempFile);

				// File file=new File(box.getString("url"));
				bis = new BufferedInputStream(in);

				bos = new BufferedOutputStream(out);
				byte[] buff = new byte[2048];
				int bytesRead;
				// Simple read/write loop.
				while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
					bos.write(buff, 0, bytesRead);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}

		return null;

	}

	// ================================ methods for pending result entry
	// =============

	// ///////////////////

	public ModelAndView showPendingResultEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		detailsMap = investigationHandlerService.getDetailsForSearch(dataMap);
		patientMap = investigationHandlerService.getResultGrid(mapForDs);
		String jsp = PENDING_RESULT_ENTRY;
		jsp += ".jsp";

		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPendingResultEntryLabJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");


		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		mapForDs.put("hospitalId", hospitalId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		String flag="investigationForHalHospital";
		mapForDs.put("flag", flag);
		//detailsMap = investigationHandlerService.getDetailsForSearch(dataMap);
		patientMap = investigationHandlerService.getResultGridLab(mapForDs);

		String jsp = PENDING_RESULT_ENTRY_LAB;
		jsp += ".jsp";

		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	
	
	public ModelAndView showPendingResultEntryEmpanelledLabJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");


		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		mapForDs.put("hospitalId", hospitalId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		String flag="investigationForEmpanelledHospital";
		mapForDs.put("flag", flag);
		
		detailsMap = investigationHandlerService.getDetailsForSearch(dataMap);
		patientMap = investigationHandlerService.getResultGridLab(mapForDs);

		String jsp = PENDING_RESULT_ENTRY_EMPANELLED_LAB;
		jsp += ".jsp";

		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	

	// ///////////////////
	/*
	 * public ModelAndView showPendingResultEntryJsp(HttpServletRequest request,
	 * HttpServletResponse response){ String userName = ""; int deptId = 0; int
	 * hospitalId = 0; String deptName=""; session = request.getSession(); if
	 * (session.getAttribute("userName") != null) userName = (String)
	 * session.getAttribute("userName"); if (session.getAttribute("hospitalId")
	 * != null) hospitalId = Integer.parseInt("" +
	 * session.getAttribute("hospitalId")); if (session.getAttribute("deptId")
	 * != null) deptId = Integer.parseInt("" + session.getAttribute("deptId"));
	 * 
	 * if (session.getAttribute("deptName") != null) deptName =
	 * (String)session.getAttribute("deptName");
	 * 
	 * Map<String, Object> detailsMap = new HashMap<String, Object>();
	 * Map<String, Object> dataMap = new HashMap<String, Object>(); Map<String,
	 * Object> patientMap = new HashMap<String, Object>(); Map<String, Object>
	 * mapForDs = new HashMap<String, Object>(); mapForDs.put("deptId",deptId);
	 * dataMap.put("deptId", deptId); dataMap.put("hospitalId", hospitalId);
	 * dataMap.put("userName", userName); dataMap.put("deptName", deptName);
	 * detailsMap = investigationHandlerService.getDetailsForSearch(dataMap);
	 * patientMap = investigationHandlerService.getResultGrid(mapForDs); String
	 * jsp =PENDING_RESULT_ENTRY; jsp += ".jsp";
	 * 
	 * map.put("deptId",deptId); map.put("hospitalId", hospitalId);
	 * map.put("userName", userName); map.put("deptName", deptName);
	 * map.put("detailsMap", detailsMap); map.put("patientMap", patientMap);
	 * map.put("contentJsp", jsp); return new ModelAndView("index", "map", map);
	 * }
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatient(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<DgResultEntryDetail> dgResultEntryDetailListForResult = new ArrayList<DgResultEntryDetail>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serPersonFName = "";
		String patientFName = "";
		String serviceNo = "";
		String orderStatus = "";
		String adNo = "";
		String hinNo = "";
		int departmentId = 0;
		int inpatientId = 0;
		int subChargeCodeId = 0;
		int hinId = 0;
		String orderType = "";
		String flag = "";
		int sampleCollectionDetailId = 0;
		String diagnosisNo = "";
		int sampleHeaderId = 0;
		int userId = 0;
		String userName = "";
		int hospitalId = 0;
		String appendedHtml = "";
		int deptId = 0;
		String deptName = "";
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		try {

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))
					&& !(request.getParameter(INPATIENT_ID).equals(""))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
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
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				orderType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("orderType", orderType);
			}

			if (request.getParameter(DIAGNOSIS_NO) != null
					&& !(request.getParameter(DIAGNOSIS_NO).equals(""))) {
				diagnosisNo = request.getParameter(DIAGNOSIS_NO);
				mapForDs.put("diagnosisNo", diagnosisNo);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}

			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
			}

			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				mapForDs.put("departmentId", departmentId);
			}
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(ORDER_STATUS) != null
					&& !(request.getParameter(ORDER_STATUS).equals("0"))) {
				orderStatus = request.getParameter(ORDER_STATUS);
				mapForDs.put("orderStatus", orderStatus);
			}
			if (request.getParameter(SAMPLE_COLLECTION_DETAIL_ID) != null
					&& !(request.getParameter(SAMPLE_COLLECTION_DETAIL_ID)
							.equals("0"))) {
				sampleCollectionDetailId = Integer.parseInt(request
						.getParameter(SAMPLE_COLLECTION_DETAIL_ID));
				mapForDs.put("sampleCollectionDetailId",
						sampleCollectionDetailId);
			}
			if (request.getParameter("sampleHeaderId") != null
					&& !(request.getParameter("sampleHeaderId").equals("0"))) {
				sampleHeaderId = Integer.parseInt(request
						.getParameter("sampleHeaderId"));
				mapForDs.put("sampleHeaderId", sampleHeaderId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = investigationHandlerService.getPatientDetails(mapForDs);

		String jsp = "";
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDetailsList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDetailsList");

		}
		Map<String, Object> diagMap = new HashMap<String, Object>();
		diagMap.put("hospitalId", hospitalId);
		if (sampleCollectionDetailId != 0) {

			map = investigationHandlerService.getSampleCollectionDetails(
					sampleCollectionDetailId, deptId);
			List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
			if (map.get("sampleCollectionList") != null) {
				sampleCollectionList = (List<DgSampleCollectionDetails>) map
						.get("sampleCollectionList");
			}
			if (map.get("dgResultEntryDetailListForResult") != null) {
				dgResultEntryDetailListForResult = (List<DgResultEntryDetail>) map
						.get("dgResultEntryDetailListForResult");
			}

			DgMasInvestigation dgmasInvestigation = new DgMasInvestigation();
			Set<DgSubMasInvestigation> dgSubSet = new HashSet<DgSubMasInvestigation>();
			int invForDetail = 0;
			int inv = 0;
			String result = "";
			String resultType = "";
			String normalValue = "";
			for (DgSampleCollectionDetails dgSampleDetail : sampleCollectionList) {
				invForDetail = dgSampleDetail.getInvestigation().getId();
				normalValue = dgSampleDetail.getInvestigation()
						.getNormalValue();
				resultType = dgSampleDetail.getInvestigation()
						.getInvestigationType();
				// code added by shailesh

				if (resultType.equalsIgnoreCase("t")
						&& request.getAttribute("secondRequest") == null) {
					boolean flag1 = saveDatabaseContentToTheServerPath(dgSampleDetail
							.getInvestigation().getChargeCode().getId());
				}
				dgSubSet = dgSampleDetail.getInvestigation().getChargeCode()
						.getDgSubMasInvestigations();
				for (DgSubMasInvestigation dgMas : dgSubSet) {
					inv = dgMas.getInvestigation().getId();
					result = dgMas.getResultType();
				}
				if (resultType.equalsIgnoreCase("m")) {
					jsp = RESULT_ENTRY + ".jsp";
				} else if (resultType.equalsIgnoreCase("s")) {
					jsp = RESULT_ENTRY_SINGLE_PARAMETER_WITH_NORMAL_VALUE
							+ ".jsp";
				} else if (resultType.equalsIgnoreCase("t")) {
					new File(getServletContext().getRealPath("/temp/")).mkdir();
					DgTemplate dgTemplate = new DgTemplate();
					if (sampleCollectionList.get(0).getInvestigation()
							.getDgTemplates() != null
							&& sampleCollectionList.get(0).getInvestigation()
									.getDgTemplates().size() > 0) {
						for (DgTemplate dgTemplate1 : sampleCollectionList.get(
								0).getInvestigation().getDgTemplates()) {
							dgTemplate = dgTemplate1;
						}

					}
					if (dgTemplate != null
							|| dgResultEntryDetailListForResult.size() > 0) {
						// String result1=new String(dgTemplate.getResult());

						InputStream is = new FileInputStream(
								getServletContext().getRealPath(
										"jsp/pdf/appendingHtml.html"));
						File temprory1 = new File(getServletContext()
								.getRealPath("jsp/pdf/appendingHtml.html"));

						byte[] b3 = new byte[(int) temprory1.length()];
						int offset = 0;
						int numRead = 0;
						try {
							while ((offset < b3.length)
									&& ((numRead = is.read(b3, offset,
											b3.length - offset)) >= 0)) {

								offset += numRead;

							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							is.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						appendedHtml = new String(b3);

					}

					jsp = RESULT_ENTRY_SINGLE_PARAMETER + ".jsp";
				} else if (resultType.equalsIgnoreCase("v")) {
					detailsMap = investigationHandlerService
							.getDetails(dataMap);
					jsp = RESULT_ENTRY_SENSITIVE + ".jsp";
				}
			}
			String resultSeqNo = "";
			resultSeqNo = investigationHandlerService
					.generateResultNumber(diagMap);
			if (resultSeqNo != "") {
				map.put("resultSeqNo", resultSeqNo);
			}
		} else {
			// ////// Made Uncommented
			detailsMap = investigationHandlerService.getDetails(dataMap);
			jsp = PENDING_RESULT_ENTRY + ".jsp";

		}
		patientMap.put("patientList", patientList);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		map.put("dataMap", dataMap);
		map.put("deptName", deptName);
		map.put("appendedHtml", appendedHtml);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchPatientForLab(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {
		System.out.println("HAl Search");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String serPersonFName = "";
		String patientFName = "";
		String serviceNo = "";
		String orderStatus = "";
		String adNo = "";
		String hinNo = "";
		int departmentId = 0;
		int inpatientId = 0;
		int subChargeCodeId = 0;
		int hinId = 0;
		String orderType = "";
		String CombinedIds = "";
		String[] idsArray = new String[0];
		int sampleCollectionDetailId = 0;
		String diagnosisNo = "";
		int dgSampleHeaderId = 0;
		int subChargeId = 0;
		String userName = "";
		int hospitalId = 0;
		String appendedHtml = "";
		int deptId = 0;
		String deptName = "";
		String barCodeOrderNo="";
		session = request.getSession();

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		mapForDs.put("hospitalId", hospitalId);
		mapForDs.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		
		String flag="investigationForHalHospital";
		mapForDs.put("flag", flag);

		try {

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))
					&& !(request.getParameter(INPATIENT_ID).equals(""))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
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
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				orderType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("orderType", orderType);
			}
			if (request.getParameter(DIAGNOSIS_NO) != null
					&& !(request.getParameter(DIAGNOSIS_NO).equals(""))) {
				diagnosisNo = request.getParameter(DIAGNOSIS_NO);
				mapForDs.put("diagnosisNo", diagnosisNo);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}

			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
			}
			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				mapForDs.put("departmentId", departmentId);
			}
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(ORDER_STATUS) != null
					&& !(request.getParameter(ORDER_STATUS).equals("0"))) {
				orderStatus = request.getParameter(ORDER_STATUS);
				mapForDs.put("orderStatus", orderStatus);
			}
			if (request.getParameter(SAMPLE_COLLECTION_DETAIL_ID) != null
					&& !(request.getParameter(SAMPLE_COLLECTION_DETAIL_ID)
							.equals("0"))) {
				CombinedIds = request.getParameter(SAMPLE_COLLECTION_DETAIL_ID);
				mapForDs.put("sampleCollectionDetailId",
						sampleCollectionDetailId);
			}
			
			if (request.getParameter("barCodeOrderNo") != null)
					 {
				barCodeOrderNo = request.getParameter("barCodeOrderNo");
				mapForDs.put("barCodeOrderNo", barCodeOrderNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> diagMap = new HashMap<String, Object>();
		diagMap.put("hospitalId", hospitalId);
		List<Patient> patientList = new ArrayList<Patient>();
		String jsp = "";
		if (!CombinedIds.equals("")) {

			idsArray = CombinedIds.split(",");
			dgSampleHeaderId = Integer.parseInt(idsArray[0]);
			mapForDs.put("dgSampleHeaderId", dgSampleHeaderId);

			subChargeId = Integer.parseInt(idsArray[1]);
			mapForDs.put("subChargeId", subChargeId);

		}

		if (!CombinedIds.equals("")) {
			System.out.println("HAl Search1");
			// //////////////////////////////////////////////////////
			map = investigationHandlerService
					.getSampleCollectionDetailsForLab(mapForDs);
			// /////////////////////////////////////////////////////
			// map =
			// investigationHandlerService.getSampleCollectionDetails(sampleCollectionDetailId,
			// deptId);

			List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
			if (map.get("sampleCollectionList") != null) {
				sampleCollectionList = (List<DgSampleCollectionDetails>) map
						.get("sampleCollectionList");
			}
			if (sampleCollectionList.size() > 0) {
				
				jsp = RESULT_ENTRY_SINGLE_PARAMETER_LAB + ".jsp";
				
				List<String> resultSeqNoList = new ArrayList<String>();
				for (int i = 0; i < sampleCollectionList.size(); i++) {
					String resultSeqNo = "";
					resultSeqNo = investigationHandlerService
							.generateResultNumberForLab(diagMap);
					resultSeqNoList.add(resultSeqNo);
				}

				if (resultSeqNoList.size() > 0) {
					map.put("resultSeqNoList", resultSeqNoList);
				}
				map.put("CombinedIds", CombinedIds);
			}
		} else {
			/*
			 * if(session.getAttribute("boxForResultEntry") != null){
			 * session.removeAttribute("boxForResultEntry");
			 * session.setAttribute("boxForResultEntry",box); }else{
			 * session.setAttribute("boxForResultEntry",box); }
			 */

			// ////// Made Uncommented
			patientMap = investigationHandlerService
					.getPatientDetailsForLab(mapForDs);
			if (patientMap.get("patientDetailsList") != null) {
				patientList = (List<Patient>) patientMap
						.get("patientDetailsList");

			}
			//detailsMap = investigationHandlerService.getDetailsForLab(dataMap);
			jsp = PENDING_RESULT_ENTRY_LAB + ".jsp";
		}
		patientMap.put("patientList", patientList);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		map.put("dataMap", dataMap);
		map.put("deptName", deptName);
		map.put("appendedHtml", appendedHtml);
		return new ModelAndView("index", "map", map);
	}
	
	
	
	
	public ModelAndView searchPatientForEmpanelledLab(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {
		System.out.println("Empanelled Search");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serPersonFName = "";
		String patientFName = "";
		String serviceNo = "";
		String orderStatus = "";
		String adNo = "";
		String hinNo = "";
		int departmentId = 0;
		int inpatientId = 0;
		int subChargeCodeId = 0;
		int hinId = 0;
		String orderType = "";
		String CombinedIds = "";
		String[] idsArray = new String[0];
		int sampleCollectionDetailId = 0;
		String diagnosisNo = "";
		int dgSampleHeaderId = 0;
		int subChargeId = 0;
		String userName = "";
		int hospitalId = 0;
		String appendedHtml = "";
		int deptId = 0;
		String deptName = "";
		session = request.getSession();

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		mapForDs.put("hospitalId", hospitalId);
		mapForDs.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		
		String flag="investigationForEmpanelledHospital";
		mapForDs.put("flag", flag);

		try {

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))
					&& !(request.getParameter(INPATIENT_ID).equals(""))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
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
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				orderType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("orderType", orderType);
			}
			if (request.getParameter(DIAGNOSIS_NO) != null
					&& !(request.getParameter(DIAGNOSIS_NO).equals(""))) {
				diagnosisNo = request.getParameter(DIAGNOSIS_NO);
				mapForDs.put("diagnosisNo", diagnosisNo);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}

			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
			}
			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				mapForDs.put("departmentId", departmentId);
			}
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(ORDER_STATUS) != null
					&& !(request.getParameter(ORDER_STATUS).equals("0"))) {
				orderStatus = request.getParameter(ORDER_STATUS);
				mapForDs.put("orderStatus", orderStatus);
			}
			if (request.getParameter(SAMPLE_COLLECTION_DETAIL_ID) != null
					&& !(request.getParameter(SAMPLE_COLLECTION_DETAIL_ID)
							.equals("0"))) {
				CombinedIds = request.getParameter(SAMPLE_COLLECTION_DETAIL_ID);
				mapForDs.put("sampleCollectionDetailId",
						sampleCollectionDetailId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> diagMap = new HashMap<String, Object>();
		diagMap.put("hospitalId", hospitalId);
		List<Patient> patientList = new ArrayList<Patient>();
		String jsp = "";
		if (!CombinedIds.equals("")) {

			idsArray = CombinedIds.split(",");
			dgSampleHeaderId = Integer.parseInt(idsArray[0]);
			mapForDs.put("dgSampleHeaderId", dgSampleHeaderId);

			subChargeId = Integer.parseInt(idsArray[1]);
			mapForDs.put("subChargeId", subChargeId);

		}

		if (!CombinedIds.equals("")) {
			// //////////////////////////////////////////////////////
			map = investigationHandlerService
					.getSampleCollectionDetailsForLab(mapForDs);
			// /////////////////////////////////////////////////////
			// map =
			// investigationHandlerService.getSampleCollectionDetails(sampleCollectionDetailId,
			// deptId);

			List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
			if (map.get("sampleCollectionList") != null) {
				sampleCollectionList = (List<DgSampleCollectionDetails>) map
						.get("sampleCollectionList");
			}
			if (sampleCollectionList.size() > 0) {
				
				jsp = "resultEntryForSingleParameterEmpanelledLab.jsp";
				
				List<String> resultSeqNoList = new ArrayList<String>();
				for (int i = 0; i < sampleCollectionList.size(); i++) {
					String resultSeqNo = "";
					resultSeqNo = investigationHandlerService
							.generateResultNumberForLab(diagMap);
					resultSeqNoList.add(resultSeqNo);
				}

				if (resultSeqNoList.size() > 0) {
					map.put("resultSeqNoList", resultSeqNoList);
				}
				map.put("CombinedIds", CombinedIds);
			}
		} else {
			/*
			 * if(session.getAttribute("boxForResultEntry") != null){
			 * session.removeAttribute("boxForResultEntry");
			 * session.setAttribute("boxForResultEntry",box); }else{
			 * session.setAttribute("boxForResultEntry",box); }
			 */

			// ////// Made Uncommented
			patientMap = investigationHandlerService
					.getPatientDetailsForLab(mapForDs);
			if (patientMap.get("patientDetailsList") != null) {
				patientList = (List<Patient>) patientMap
						.get("patientDetailsList");

			}
			detailsMap = investigationHandlerService.getDetailsForLab(dataMap);
			jsp = PENDING_RESULT_ENTRY_LAB + ".jsp";
		}
		patientMap.put("patientList", patientList);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		map.put("dataMap", dataMap);
		map.put("deptName", deptName);
		map.put("appendedHtml", appendedHtml);
		return new ModelAndView("index", "map", map);
	}

	
	

	public ModelAndView searchPatientByBackButtonLab(
			HttpServletRequest request, HttpServletResponse response)
			throws FileNotFoundException, IllegalStateException {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serPersonFName = "";
		String patientFName = "";
		String serviceNo = "";
		String orderStatus = "";
		String adNo = "";
		String hinNo = "";
		int departmentId = 0;
		int inpatientId = 0;
		int subChargeCodeId = 0;
		int hinId = 0;
		String orderType = "";
		String flag = "";
		String CombinedIds = "";
		String[] idsArray = new String[0];
		int sampleCollectionDetailId = 0;
		String diagnosisNo = "";
		int sampleHeaderId = 0;
		int dgSampleHeaderId = 0;
		int subChargeId = 0;

		int userId = 0;
		String userName = "";
		int hospitalId = 0;
		String appendedHtml = "";
		int deptId = 0;
		String deptName = "";
		session = request.getSession();
		Box box = null;

		/*
		 * if(session.getAttribute("boxForResultEntry") != null){ box =
		 * (Box)session.getAttribute("boxForResultEntry"); }
		 */

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		try {
			if (box != null) {
				if (box.getString(HIN_NO) != null
						&& !(box.getString(HIN_NO).equals(""))) {
					hinNo = box.getString(HIN_NO);
					mapForDs.put("hinNo", hinNo);
				}
				if (box.getString(INPATIENT_ID) != null
						&& !(box.getString(INPATIENT_ID).equals("0"))
						&& !(box.getString(INPATIENT_ID).equals(""))) {
					inpatientId = Integer.parseInt(box.getString(INPATIENT_ID));
					mapForDs.put("inpatientId", inpatientId);
				}
				if (box.getString(FROM_DATE) != null
						&& !(box.getString(FROM_DATE).equals(""))) {
					fromDate = HMSUtil.dateFormatterDDMMYYYY(box
							.getString(FROM_DATE));
					mapForDs.put("fromDate", fromDate);
				}
				if (box.getString(TO_DATE) != null
						&& !(box.getString(TO_DATE).equals(""))) {
					toDate = HMSUtil.dateFormatterDDMMYYYY(box
							.getString(TO_DATE));
					mapForDs.put("toDate", toDate);
				}
				if (box.getString(PATIENT_TYPE) != null
						&& !(box.getString(PATIENT_TYPE).equals(""))) {
					orderType = box.getString(PATIENT_TYPE);
					mapForDs.put("orderType", orderType);
				}

				if (box.getString(DIAGNOSIS_NO) != null
						&& !(box.getString(DIAGNOSIS_NO).equals(""))) {
					diagnosisNo = box.getString(DIAGNOSIS_NO);
					mapForDs.put("diagnosisNo", diagnosisNo);
				}
				if (request.getParameter(SERVICE_NO) != null
						&& !(request.getParameter(SERVICE_NO).equals(""))) {
					serviceNo = request.getParameter(SERVICE_NO);
					mapForDs.put("serviceNo", serviceNo);
				}

				if (box.getString(SUB_CHARGECODE_ID) != null
						&& !(box.getString(SUB_CHARGECODE_ID).equals(""))
						&& !(box.getString(SUB_CHARGECODE_ID).equals("0"))) {
					subChargeCodeId = Integer.parseInt(box
							.getString(SUB_CHARGECODE_ID));
					mapForDs.put("subChargeCodeId", subChargeCodeId);
				}

				if (box.getString(S_FIRST_NAME) != null
						&& !(box.getString(S_FIRST_NAME).equals(""))) {
					serPersonFName = box.getString(S_FIRST_NAME);
					mapForDs.put("serPersonFName", serPersonFName);
				}
				if (box.getString(P_FIRST_NAME) != null
						&& !(box.getString(P_FIRST_NAME).equals(""))) {
					patientFName = box.getString(P_FIRST_NAME);
					mapForDs.put("patientFName", patientFName);
				}
				if (box.getString(AD_NO) != null
						&& !(box.getString(AD_NO).equals(""))) {
					adNo = box.getString(AD_NO);
					mapForDs.put("adNo", adNo);
				}
				if (box.getString(DEPARTMENT_ID) != null
						&& !(box.getString(DEPARTMENT_ID).equals(""))
						&& !(box.getString(DEPARTMENT_ID).equals("0"))) {
					departmentId = Integer.parseInt(box
							.getString(DEPARTMENT_ID));
					mapForDs.put("departmentId", departmentId);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = investigationHandlerService
				.getPatientDetailsForLab(mapForDs);

		String jsp = "";
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDetailsList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDetailsList");
		}

		detailsMap = investigationHandlerService.getDetailsForLab(dataMap);
		jsp = PENDING_RESULT_ENTRY_LAB + ".jsp";

		patientMap.put("patientList", patientList);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		map.put("dataMap", dataMap);
		map.put("deptName", deptName);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchForTemplateDetailsLab(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException,
			IllegalStateException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<DgResultEntryDetail> dgResultEntryDetailListForResult = new ArrayList<DgResultEntryDetail>();
		String CombinedIds = "";
		int sampleCollectionDetailId = 0;
		String jsp = "";
		int resultEnteredBy = 0;
		String userName = "";
		String resultSeqNo = "";
		int hospitalId = 0;
		String appendedHtml = "";
		int deptId = 0;
		String deptName = "";
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");

		Map<String, Object> dataMap = new HashMap<String, Object>();

		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		if (request.getParameter(DG_SAMPLE_DETAIL_ID_TEMPLATE) != null
				&& !(request.getParameter(DG_SAMPLE_DETAIL_ID_TEMPLATE)
						.equals("0"))) {
			sampleCollectionDetailId = Integer.parseInt(request
					.getParameter(DG_SAMPLE_DETAIL_ID_TEMPLATE));
			mapForDs.put("sampleCollectionDetailId", sampleCollectionDetailId);
			detailsMap
					.put("sampleCollectionDetailId", sampleCollectionDetailId);

		}
		if (request.getParameter(RESULT_NO_TEMPLATE) != null
				&& !(request.getParameter(RESULT_NO_TEMPLATE).equals("0"))) {
			resultSeqNo = (String) request.getParameter(RESULT_NO_TEMPLATE);
			mapForDs.put("resultSeqNo", resultSeqNo);
			detailsMap.put("resultSeqNo", resultSeqNo);
		}
		if (request.getParameter(RESULT_ENTERED_BY) != null
				&& !(request.getParameter(RESULT_ENTERED_BY).equals("0"))) {
			resultEnteredBy = Integer.parseInt(request
					.getParameter(RESULT_ENTERED_BY));
			mapForDs.put("resultEnteredBy", resultEnteredBy);
			detailsMap.put("resultEnteredBy", resultEnteredBy);
		}
		if (request.getParameter("CombinedIds") != null
				&& !(request.getParameter("CombinedIds").equals("0"))) {
			CombinedIds = (String) request.getParameter("CombinedIds");
			mapForDs.put("CombinedIds", CombinedIds);
			detailsMap.put("CombinedIds", CombinedIds);
		}
	

		mapForDs.put("deptId", deptId);

		if (sampleCollectionDetailId != 0) {
			// //////////////////////////////////////////////////////
			// map =
			// investigationHandlerService.getSampleCollectionDetailsForLab(mapForDs);

			// /////////////////////////////////////////////////////
			map = investigationHandlerService.getSampleCollectionDetails(
					sampleCollectionDetailId, deptId);
			List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
			if (map.get("sampleCollectionList") != null) {
				sampleCollectionList = (List<DgSampleCollectionDetails>) map
						.get("sampleCollectionList");
			}
			if (map.get("dgResultEntryDetailListForResult") != null) {
				dgResultEntryDetailListForResult = (List<DgResultEntryDetail>) map
						.get("dgResultEntryDetailListForResult");
			}

			String resultType = "";

			for (DgSampleCollectionDetails dgSampleDetail : sampleCollectionList) {
				resultType = dgSampleDetail.getInvestigation()
						.getInvestigationType();

				if (resultType.equalsIgnoreCase("t")) {
					new File(getServletContext().getRealPath("/temp/")).mkdir();
					try {
						File tempFile = new File(getServletContext()
								.getRealPath("/temp/" + "temp.html"));
						if (!tempFile.exists()) {
							tempFile.createNewFile();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}

					DgTemplate dgTemplate = new DgTemplate();
					if (sampleCollectionList.get(0).getInvestigation()
							.getDgTemplates() != null
							&& sampleCollectionList.get(0).getInvestigation()
									.getDgTemplates().size() > 0) {
						for (DgTemplate dgTemplate1 : sampleCollectionList.get(
								0).getInvestigation().getDgTemplates()) {
							dgTemplate = dgTemplate1;
						}
					}
					if (dgResultEntryDetailListForResult.size() > 0) {
						// String result1=new String(dgTemplate.getResult());
						InputStream is = new FileInputStream(
								getServletContext().getRealPath(
										"jsp/pdf/appendingHtml.html"));
						File temprory1 = new File(getServletContext()
								.getRealPath("jsp/pdf/appendingHtml.html"));

						byte[] b3 = new byte[(int) temprory1.length()];
						int offset = 0;
						int numRead = 0;
						try {
							while ((offset < b3.length)
									&& ((numRead = is.read(b3, offset,
											b3.length - offset)) >= 0)) {
								offset += numRead;
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							is.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						appendedHtml = new String(b3);
					}

					jsp = PENDING_RESULT_ENTRY_TEMPLATE + ".jsp";
				}

				/*
				 * String resultSeqNo =""; resultSeqNo =
				 * investigationHandlerService.generateResultNumber(diagMap);
				 * if(resultSeqNo != ""){
				 */
				// map.put("resultSeqNo", resultSeqNo);
				// }
			}
		}
		if (request.getParameter("diagNo") != null
				&& !(request.getParameter("diagNo").equals(""))) {
			map.put("diagNo", request.getParameter("diagNo"));
		}
		// patientMap.put("patientList", patientList);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		map.put("dataMap", dataMap);
		map.put("deptName", deptName);
		map.put("appendedHtml", appendedHtml);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchForSensitiveDetailsLab(
			HttpServletRequest request, HttpServletResponse response)
			throws FileNotFoundException, IllegalStateException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap1 = new HashMap<String, Object>();

		String CombinedIds = "";
		int sampleCollectionDetailId = 0;
		String jsp = "";
		int resultEnteredBy = 0;
		String userName = "";
		String resultSeqNo = "";
		int hospitalId = 0;

		int deptId = 0;
		String deptName = "";
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");

		Map<String, Object> dataMap = new HashMap<String, Object>();

		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		if (request.getParameter(DG_SAMPLE_DETAIL_ID_SENSITIVE) != null
				&& !(request.getParameter(DG_SAMPLE_DETAIL_ID_SENSITIVE)
						.equals("0"))) {
			sampleCollectionDetailId = Integer.parseInt(request
					.getParameter(DG_SAMPLE_DETAIL_ID_SENSITIVE));
			mapForDs.put("sampleCollectionDetailId", sampleCollectionDetailId);
			detailsMap1.put("sampleCollectionDetailId",
					sampleCollectionDetailId);

		}
		if (request.getParameter(RESULT_NO_SENSITIVE) != null
				&& !(request.getParameter(RESULT_NO_SENSITIVE).equals("0"))) {
			resultSeqNo = (String) request.getParameter(RESULT_NO_SENSITIVE);
			mapForDs.put("resultSeqNo", resultSeqNo);
			detailsMap1.put("resultSeqNo", resultSeqNo);
		}
		if (request.getParameter(RESULT_ENTERED_BY) != null
				&& !(request.getParameter(RESULT_ENTERED_BY).equals("0"))) {
			resultEnteredBy = Integer.parseInt(request
					.getParameter(RESULT_ENTERED_BY));
			mapForDs.put("resultEnteredBy", resultEnteredBy);
			detailsMap1.put("resultEnteredBy", resultEnteredBy);
		}
		if (request.getParameter("CombinedIds") != null
				&& !(request.getParameter("CombinedIds").equals("0"))) {
			CombinedIds = (String) request.getParameter("CombinedIds");
			mapForDs.put("CombinedIds", CombinedIds);
			detailsMap1.put("CombinedIds", CombinedIds);
		}

		mapForDs.put("deptId", deptId);

		if (sampleCollectionDetailId != 0) {
			map = investigationHandlerService.getSampleCollectionDetails(
					sampleCollectionDetailId, deptId);
			List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
			if (map.get("sampleCollectionList") != null) {
				sampleCollectionList = (List<DgSampleCollectionDetails>) map
						.get("sampleCollectionList");
			}

			String resultType = "";

			for (DgSampleCollectionDetails dgSampleDetail : sampleCollectionList) {
				resultType = dgSampleDetail.getInvestigation()
						.getInvestigationType();
				if (resultType.equalsIgnoreCase("v")) {
					detailsMap = investigationHandlerService
							.getDetails(dataMap);
					jsp = RESULT_ENTRY_SENSITIVE + ".jsp";
				}
			}
		}

		map.put("detailsMap", detailsMap);
		map.put("detailsMap1", detailsMap1);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		map.put("dataMap", dataMap);
		map.put("deptName", deptName);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitResultEntryForTempelateLab(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		boolean saved = false;
		int hospitalId = 0;
		String userName = "";
		MultipartFormDataRequest mrequest = null;
		String result = "";
		Box box = HMSUtil.getBox(request);
		String jsp = "";
		String messageTOBeVisibleToTheUser = "";
		String resultNo = "";
		String CombinedIds = "";
		HttpSession session = request.getSession();
		int sampleCollectionId = 0;
		int newSampleCollectionId = 0;
		String resultType = "";
		int deptId = 0;
		byte[] bytes = null;
		try {

			if (MultipartFormDataRequest.isMultipartFormData(request)) {
				try {

					mrequest = new MultipartFormDataRequest(request);
					if (mrequest.getParameter("test2") != null) {
						String tepmlateData = mrequest.getParameter("test2");
						InputStream fis1 = new FileInputStream(
								getServletContext().getRealPath(
										"jsp/pdf/appendingHtml.html"));
						File temprory2 = new File(getServletContext()
								.getRealPath("jsp/pdf/appendingHtml.html"));

						byte[] b1 = new byte[(int) temprory2.length()];
						int offset1 = 0;
						int numRead1 = 0;
						try {
							while ((offset1 < b1.length)
									&& ((numRead1 = fis1.read(b1, offset1,
											b1.length - offset1)) >= 0)) {

								offset1 += numRead1;

							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							fis1.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						String appendedHtml = new String(b1);
						String finalFile = appendedHtml + tepmlateData
								+ "</body></html>";

						bytes = finalFile.getBytes();
						result = new String(bytes);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (session.getAttribute("deptId") != null)
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));

			sampleCollectionId = box.getInt(DG_SAMPLE_DETAIL_ID);
			// Integer.parseInt(request.getParameter(DG_SAMPLE_DETAIL_ID));
			List<DgSampleCollectionDetails> patientList = new ArrayList<DgSampleCollectionDetails>();

			String reportEnteredFinally = "";

			if (request.getParameter("reportEnteredFinally") != null) {
				reportEnteredFinally = request
						.getParameter("reportEnteredFinally");
			}

			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				parameterMap.put("hospitalId", hospitalId);
			}
			if (session.getAttribute(LOGIN_NAME) != null) {
				userName = (String) session.getAttribute(LOGIN_NAME);
				parameterMap.put("userName", userName);
			}
			if (request.getParameter(RESULT_NO) != null) {
				resultNo = request.getParameter(RESULT_NO);
			}
			if (request.getParameter("combinedIds") != null) {
				CombinedIds = request.getParameter("combinedIds");
			}

			String filmSizeUsed = "";
			if (request.getParameter("filmSizeUsed") != null
					&& !request.getParameter("filmSizeUsed").equals("")) {
				filmSizeUsed = request.getParameter("filmSizeUsed");
			}
			int filmUsed = 0;
			if (request.getParameter("filmUsed") != null
					&& !request.getParameter("filmUsed").equals("")) {
				filmUsed = new Integer(request.getParameter("filmUsed"));
			}

			String remarks = "";
			if (request.getParameter(REMARKS) != null) {
				remarks = request.getParameter(REMARKS);
			}

			int subchargeId = 0;
			int mainChargeId = 0;

			int hinId = 0;
			int investigationId = 0;
			int inpatientId = 0;
			int testOrderNoForTemplate = 0;
			int employeeId = 0;
			int resultEnteredId = 0;
			int departId = 0;
			int chargeCodeId=0;
			
			if (request.getParameter("chargeCodeId") != null) {
				chargeCodeId = Integer.valueOf(request
						.getParameter("chargeCodeId"));
			}
			if (request.getParameter(MAIN_CHARGECODE_ID) != null) {
				mainChargeId = Integer.valueOf(request
						.getParameter(MAIN_CHARGECODE_ID));
			}
			if (request.getParameter(DEPARTMENT_ID) != null) {
				departId = Integer.valueOf(request.getParameter(DEPARTMENT_ID));
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null) {
				subchargeId = Integer.valueOf(request
						.getParameter(SUB_CHARGECODE_ID));
			}
			if (request.getParameter(HIN_ID) != null) {
				hinId = Integer.valueOf(request.getParameter(HIN_ID));
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals(""))) {
				inpatientId = Integer.valueOf(request
						.getParameter(INPATIENT_ID));
			}
			if (request.getParameter("testOrderNoForTemplate") != null
					&& !(request.getParameter("testOrderNoForTemplate")
							.equals(""))) {
				testOrderNoForTemplate = Integer.valueOf(request
						.getParameter("testOrderNoForTemplate"));
			}
			if (request.getParameter(SAMPLE_COLLECTION_ID) != null) {
				sampleCollectionId = Integer.valueOf(request
						.getParameter(SAMPLE_COLLECTION_ID));
			}
			if (request.getParameter(EMPLOYEE_ID) != null
					&& !("").equals(request.getParameter(EMPLOYEE_ID))) {
				employeeId = Integer.valueOf(request.getParameter(EMPLOYEE_ID));

			}
			if (!(request.getParameter(RESULT_ENTERED_BY).equals(""))
					&& request.getParameter(RESULT_ENTERED_BY) != null) {
				resultEnteredId = Integer.valueOf(request
						.getParameter(RESULT_ENTERED_BY));
			}
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTimeWithoutSc");
			Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
			DgResultEntryHeader dgResultEntryHeader = new DgResultEntryHeader();
			dgResultEntryHeader.setResultNo(resultNo);
			dgResultEntryHeader.setLastChgdBy(userName);
			dgResultEntryHeader.setLastChgdDate(date);
			dgResultEntryHeader.setLastChgdTime(time);
			dgResultEntryHeader.setRemarks(remarks);
			dgResultEntryHeader.setResultDate(date);
			if (reportEnteredFinally != null
					&& reportEnteredFinally.equals("true")) {
				dgResultEntryHeader.setResultStatus("P");
			} else {
				dgResultEntryHeader.setResultStatus("W");
			}
			// dgResultEntryHeader.setResultStatus("P");
			dgResultEntryHeader.setResultTime(time);

			MasMainChargecode masMainChargecode = new MasMainChargecode();
			masMainChargecode.setId(mainChargeId);
			dgResultEntryHeader.setMainChargecode(masMainChargecode);

			MasSubChargecode masSubChargecode = new MasSubChargecode();
			masSubChargecode.setId(subchargeId);
			dgResultEntryHeader.setSubChargecode(masSubChargecode);

			dgResultEntryHeader.setTestOrderNo(testOrderNoForTemplate);
			DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();
			dgSampleCollectionHeader.setId(sampleCollectionId);
			dgResultEntryHeader
					.setSampleCollectionHeader(dgSampleCollectionHeader);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departId);
			dgResultEntryHeader.setDepartment(masDepartment);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			dgResultEntryHeader.setMasHospital(masHospital);
			Patient patient = new Patient();
			patient.setId(hinId);
			dgResultEntryHeader.setPatient(patient);
			if (inpatientId != 0) {
				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				dgResultEntryHeader.setInpatient(inpatient);
			}
			if (employeeId != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(employeeId);
				dgResultEntryHeader.setEmployee(masEmployee);
			}
			if (resultEnteredId != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(resultEnteredId);
				dgResultEntryHeader.setEmployee(masEmployee);
			}
			if (request.getParameter(INVESTIGATION_ID) != null
					&& (!request.getParameter(INVESTIGATION_ID).equals("0"))) {
				investigationId = Integer.parseInt(request
						.getParameter(INVESTIGATION_ID));
				DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
				dgMasInvestigation.setId(investigationId);
				dgResultEntryHeader.setDgMasInvestigation(dgMasInvestigation);
			}

			parameterMap.put("dgResultEntryHeader", dgResultEntryHeader);
			// result = "";
			String additionalRemarks = "";
			int sample_Id = 0;

			int uomId = 0;
			// resultType= "";
			int sampleDetailId = 0;

			if (request.getParameter(RESULT_TYPE) != null) {
				resultType = request.getParameter(RESULT_TYPE);
			}

			// if (request.getParameter("test2") != null)
			// {
			// result = request.getParameter("test2");

			// }
			if (request.getParameter(ADDITIONAL_REMARKS) != null) {
				additionalRemarks = request.getParameter(ADDITIONAL_REMARKS);
			}

			if (request.getParameter(INVESTIGATION_ID) != null
					&& (!request.getParameter(INVESTIGATION_ID).equals("0"))) {
				investigationId = Integer.parseInt(request
						.getParameter(INVESTIGATION_ID));
			}

			if (request.getParameter(DG_SAMPLE_DETAIL_ID) != null
					&& (!request.getParameter(DG_SAMPLE_DETAIL_ID).equals(""))) {
				sampleDetailId = Integer.parseInt(request
						.getParameter(DG_SAMPLE_DETAIL_ID));
			}
			DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
			if (investigationId != 0) {

				if (investigationId != 0) {
					DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
					dgMasInvestigation.setId(investigationId);
					dgResultEntryDetail.setInvestigation(dgMasInvestigation);
				}
				if (chargeCodeId != 0) {
					MasChargeCode masChargeCode = new MasChargeCode();
					masChargeCode.setId(chargeCodeId);
					dgResultEntryDetail.setChargeCode(masChargeCode);
				}
				if (sampleDetailId != 0) {
					DgSampleCollectionDetails dgSample = new DgSampleCollectionDetails();
					dgSample.setId(sampleDetailId);
					dgResultEntryDetail.setSampleCollectionDetails(dgSample);
				}

				System.out.println("result="+result);
				System.out.println("additionalRemarks="+additionalRemarks);
				dgResultEntryDetail.setResult(result);
				dgResultEntryDetail.setResultEntry(dgResultEntryHeader);
				dgResultEntryDetail.setRemarks(additionalRemarks);
				dgResultEntryDetail.setResultType(resultType);
				if (reportEnteredFinally != null
						&& reportEnteredFinally.equals("true")) {
					dgResultEntryDetail.setResultDetailStatus("P");
				} else {
					dgResultEntryDetail.setResultDetailStatus("W");
				}

				// dgResultEntryDetail.setFilmUsed(filmUsed);
				// dgResultEntryDetail.setFilmSize(filmSizeUsed);
			}
			parameterMap.put("dgResultEntryDetail", dgResultEntryDetail);
			parameterMap.put("sampleDetailId", sampleDetailId);
			System.out.println(request.getParameter("uploadDocumentId")+"---in controller");
			if(request.getParameter("uploadDocumentId")!=null && !request.getParameter("uploadDocumentId").equals("")){
				parameterMap.put("uploadDocumentId", Integer.parseInt(request.getParameter("uploadDocumentId")));
				
			}
			
			if (reportEnteredFinally != null
					&& reportEnteredFinally.equals("true")) {
				map = investigationHandlerService
						.submitResultEntryForTemplate(parameterMap);
			} else {
				map = investigationHandlerService
						.submitResultEntryForTemplateTemparory(parameterMap);
			}

			saved = (Boolean) map.get("saved");
			if (reportEnteredFinally != null
					&& reportEnteredFinally.equals("true")) {
				if (saved == false) {
					messageTOBeVisibleToTheUser = "Result Entered. Do You Want To print?";
				} else {
					messageTOBeVisibleToTheUser = "Some Problem Occured.";
				}
				jsp = MESSAGE_FOR_RESULT_ENTRY + ".jsp";
			} else {
				if (saved == false) {
					messageTOBeVisibleToTheUser = "Result Entered. Do You Want To print?";
				} else {
					messageTOBeVisibleToTheUser = "Some Problem Occured.";
				}
				jsp = MESSAGE_FOR_WAITING_RESULT_ENTRY + ".jsp";
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		int dgSampleHeaderId = 0;
		int subChargeId = 0;
		String[] idsArray = new String[0];
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		diagMap.put("hospitalId", hospitalId);
		mapForDs.put("deptId", deptId);
		if (!CombinedIds.equals("")) {

			idsArray = CombinedIds.split(",");
			dgSampleHeaderId = Integer.parseInt(idsArray[0]);
			mapForDs.put("dgSampleHeaderId", dgSampleHeaderId);

			subChargeId = Integer.parseInt(idsArray[1]);
			mapForDs.put("subChargeId", subChargeId);

		}

		if (!CombinedIds.equals("")) {
			// //////////////////////////////////////////////////////
			map = investigationHandlerService
					.getSampleCollectionDetailsForLab(mapForDs);

			// /////////////////////////////////////////////////////
			// map =
			// investigationHandlerService.getSampleCollectionDetails(sampleCollectionDetailId,
			// deptId);

			List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
			if (map.get("sampleCollectionList") != null) {
				sampleCollectionList = (List<DgSampleCollectionDetails>) map
						.get("sampleCollectionList");
			}
			if (sampleCollectionList.size() > 0) {
				jsp = RESULT_ENTRY_SINGLE_PARAMETER_LAB + ".jsp";
				List<String> resultSeqNoList = new ArrayList<String>();
				for (int i = 0; i < sampleCollectionList.size(); i++) {
					String resultSeqNo = "";
					resultSeqNo = investigationHandlerService
							.generateResultNumberForLab(diagMap);
					resultSeqNoList.add(resultSeqNo);
				}

				if (resultSeqNoList.size() > 0) {
					map.put("resultSeqNoList", resultSeqNoList);
				}
				map.put("CombinedIds", CombinedIds);
			} else {
				String nextCombinedIds = "";
				if (!CombinedIds.equals("")) {
					String[] idArrString = new String[0];
					idArrString = CombinedIds.split(",");

					int subChargeIdTemp = Integer.parseInt(idArrString[1]);

					List<String> combinedListAll = new ArrayList<String>();
					combinedListAll = (List<String>) session
							.getAttribute("combinedListAll");

					if (combinedListAll.size() > 0) {
						combinedListAll.remove(CombinedIds);
					}
					for (String combinedIdsFromList : combinedListAll) {
						String[] idArray = new String[0];
						idArray = combinedIdsFromList.split(",");

						int subChargeIdFromList = Integer.parseInt(idArray[1]);
						if (subChargeIdFromList == subChargeIdTemp) {
							nextCombinedIds = combinedIdsFromList;
							break;
						}
					}
				}

				String url = "";
				url = "/hms/hms/investigation?method=searchPatientByBackButtonLab";
				map.put("messageTOBeVisibleToTheUser",
						messageTOBeVisibleToTheUser);
				map.put("url", url);

				map.put("nextCombinedIds", nextCombinedIds);
				map.put("CombinedIds", CombinedIds);
				map.put("newSampleCollectionId", newSampleCollectionId);
				map.put("sampleCollectionId", sampleCollectionId);
				jsp = MESSAGE_FOR_RESULT_ENTRY_LAB + ".jsp";

			}
		}

		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public boolean saveDatabaseContentToTheServerPath(int chargeCodeId)
			throws FileNotFoundException, IllegalStateException {
		boolean flag = false;
		List<DgTemplate> templateList = investigationHandlerService
				.getTemplateList(chargeCodeId);

		byte b[];
		new File(getServletContext().getRealPath("/temp/")).mkdir();
		File temprory = new File(getServletContext().getRealPath(
				"/temp/" + "temp.html"));

		FileOutputStream fos = new FileOutputStream(getServletContext()
				.getRealPath("/temp/" + "temp.html"));
		try {
			if (templateList.size() > 0) {
				fos.write(templateList.get(0).getResult().getBytes());
				flag = true;
			} else {
				fos.write(b = new byte[] { 1, 2, 3 });
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public ModelAndView submitResultEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();

		boolean saved = false;
		int hospitalId = 0;
		String userName = "";
		String messageTOBeVisibleToTheUser = "";
		HttpSession session = request.getSession();
		int sampleCollectionId = 0;
		int newSampleCollectionId = 0;
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (request.getParameter(DG_SAMPLE_DETAIL_ID) != null)
			sampleCollectionId = Integer.parseInt(request
					.getParameter(DG_SAMPLE_DETAIL_ID));

		List<DgSampleCollectionDetails> patientList = new ArrayList<DgSampleCollectionDetails>();

		patientList = (List<DgSampleCollectionDetails>) session
				.getAttribute("patientList");

		if (patientList.size() > 0) {
			for (Iterator iterator = patientList.iterator(); iterator.hasNext();) {
				DgSampleCollectionDetails dgSampleDetail = (DgSampleCollectionDetails) iterator
						.next();
				newSampleCollectionId = dgSampleDetail.getId();
				if (newSampleCollectionId == sampleCollectionId) {
					iterator.remove();
				}
			}

		}

		if (newSampleCollectionId != 0) {
			map = investigationHandlerService.getResultEntryForNext(
					newSampleCollectionId, deptId);
		}

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameterMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			parameterMap.put("userName", userName);
		}
		Box box = HMSUtil.getBox(request);
		parameterMap.put("box", box);
		map = investigationHandlerService.submitResultEntry(parameterMap);
		saved = (Boolean) map.get("saved");
		if (saved == true) {
			messageTOBeVisibleToTheUser = "Result Entered.Do You Want To print?";
		} else {
			messageTOBeVisibleToTheUser = "Some Problem Occured.";
		}
		String resultNo = "";
		if (map.get("resultNo") != null) {
			resultNo = (String) map.get("resultNo");
		}
		String resultType = "";
		if (map.get("resultType") != null) {
			resultType = (String) map.get("resultType");
		}
		String url = "";
		url = "/hms/hms/investigation?method=searchPatient";
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("resultType", resultType);
		map.put("resultNo", resultNo);
		map.put("url", url);
		map.put("sampleCollectionId", sampleCollectionId);
		map.put("newSampleCollectionId", newSampleCollectionId);
		String jsp = MESSAGE_FOR_RESULT_ENTRY + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// ====================== result entry for single parameter
	// =====================
	public ModelAndView submitResultEntryForSingleParameter(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();

		boolean saved = false;
		int hospitalId = 0;
		String userName = "";
		String messageTOBeVisibleToTheUser = "";
		HttpSession session = request.getSession();
		int sampleCollectionId = 0;
		int newSampleCollectionId = 0;
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		sampleCollectionId = Integer.parseInt(request
				.getParameter(DG_SAMPLE_DETAIL_ID));
		List<DgSampleCollectionDetails> patientList = new ArrayList<DgSampleCollectionDetails>();

		patientList = (List<DgSampleCollectionDetails>) session
				.getAttribute("patientList");

		if (patientList.size() > 0) {
			for (Iterator iterator = patientList.iterator(); iterator.hasNext();) {
				DgSampleCollectionDetails dgSampleDetail = (DgSampleCollectionDetails) iterator
						.next();
				newSampleCollectionId = dgSampleDetail.getId();
				if (newSampleCollectionId == sampleCollectionId) {
					iterator.remove();
				}
			}
		}
		Map<String, Object> patientMap = new HashMap<String, Object>();
		if (newSampleCollectionId != 0) {
			map = investigationHandlerService.getResultEntryForNext(
					newSampleCollectionId, deptId);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameterMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			parameterMap.put("userName", userName);
		}
		Box box = HMSUtil.getBox(request);
		parameterMap.put("box", box);
		map = investigationHandlerService
				.submitResultEntryForSingleParameter(parameterMap);
		saved = (Boolean) map.get("saved");
		if (saved == true) {
			messageTOBeVisibleToTheUser = "Result Entered.Do You Want To print?";
		} else {
			messageTOBeVisibleToTheUser = "Some Problem Occured.";
		}
		String resultNo = "";
		if (map.get("resultNo") != null) {
			resultNo = (String) map.get("resultNo");
		}
		String resultType = "";
		if (map.get("resultType") != null) {
			resultType = (String) map.get("resultType");
		}
		String url = "";
		url = "/hms/hms/investigation?method=searchPatient";
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("url", url);
		map.put("resultNo", resultNo);
		map.put("resultType", resultType);
		map.put("newSampleCollectionId", newSampleCollectionId);
		map.put("sampleCollectionId", sampleCollectionId);
		String jsp = MESSAGE_FOR_RESULT_ENTRY + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitResultEntryForAllInvestigationType(
			HttpServletRequest request, HttpServletResponse response) {	
		Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> parameterMap = new HashMap<String, Object>();

			boolean saved = false;
			int hospitalId = 0;
			String userName = "";
			String CombinedIds = "";
			String messageTOBeVisibleToTheUser = "";
			HttpSession session = request.getSession();

			if (request.getParameter("CombinedIds") != null) {
				CombinedIds = request.getParameter("CombinedIds");
			}

			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				parameterMap.put("hospitalId", hospitalId);
			}
			if (session.getAttribute(LOGIN_NAME) != null) {
				userName = (String) session.getAttribute(LOGIN_NAME);
				parameterMap.put("userName", userName);
			}
			Box box = HMSUtil.getBox(request);
			String order_no=box.get("OrderNo");
			parameterMap.put("box", box);
			
			
			
			
			
			// /////////////////// Submit For Investigation Type Single
			// /////////////////////////////
			map = investigationHandlerService
					.submitResultEntryForSingleParameterOnly(parameterMap);
			// /////////////////// Submit For Investigation Type Single
			// /////////////////////////////

			// /////////////////// Submit For Investigation Type Multiple
			// /////////////////////////////
			map = investigationHandlerService
					.submitResultEntryForMultipleInvestigationType(parameterMap);
			// /////////////////// Submit For Investigation Type Multiple
			// /////////////////////////////
			/**
			 * Added by Ritu for sample rejection
			 */
			map = investigationHandlerService.rejectTemplateSample(parameterMap);
			saved = (Boolean) map.get("saved");
			if (saved == true) {
				//messageTOBeVisibleToTheUser = "Result Entry done Successfully.Do You Want To print The Result.";
				messageTOBeVisibleToTheUser = "Result Entered.Do You Want To print?";
			}else {
				messageTOBeVisibleToTheUser = "Some Problem Occured.";
			}

			String nextCombinedIds = "";
			if (!CombinedIds.equals("")) {
				String[] idArrString = new String[0];
				idArrString = CombinedIds.split(",");

				int subChargeId = Integer.parseInt(idArrString[1]);

				List<String> combinedListAll = new ArrayList<String>();
				combinedListAll = (List<String>) session.getAttribute("combinedListAll");

				if (combinedListAll.size() > 0) {
					combinedListAll.remove(CombinedIds);
				}
				for (String combinedIdsFromList : combinedListAll) {
					String[] idArray = new String[0];
					idArray = combinedIdsFromList.split(",");

					int subChargeIdFromList = Integer.parseInt(idArray[1]);
					if (subChargeIdFromList == subChargeId) {
						nextCombinedIds = combinedIdsFromList;
						break;
					}
				}
			}
			
			String url = "";
			url = "/hms/hms/investigation?method=searchPatientByBackButtonLab";
			map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
			map.put("url", url);
			// map.put("resultType", resultType);
			map.put("CombinedIds", CombinedIds);
			map.put("nextCombinedIds", nextCombinedIds);
			map.put("order_no",order_no);
			String jsp = MESSAGE_FOR_RESULT_ENTRY_LAB + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);}
	
	
	public ModelAndView submitResultEntryForEmpanelledAllInvestigationType(
			HttpServletRequest request, HttpServletResponse response) {	
		Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> parameterMap = new HashMap<String, Object>();

			boolean saved = false;
			int hospitalId = 0;
			String userName = "";
			String CombinedIds = "";
			String messageTOBeVisibleToTheUser = "";
			HttpSession session = request.getSession();

			if (request.getParameter("CombinedIds") != null) {
				CombinedIds = request.getParameter("CombinedIds");
			}

			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				parameterMap.put("hospitalId", hospitalId);
			}
			if (session.getAttribute(LOGIN_NAME) != null) {
				userName = (String) session.getAttribute(LOGIN_NAME);
				parameterMap.put("userName", userName);
			}
			Box box = HMSUtil.getBox(request);
			String order_no=box.get("OrderNo");
			parameterMap.put("box", box);
			
			parameterMap.put("formSubmitFrom","Empanelled");
			
			
			
			
			
			// /////////////////// Submit For Investigation Type Single
			// /////////////////////////////
			map = investigationHandlerService
					.submitResultEntryForSingleParameterOnly(parameterMap);
			// /////////////////// Submit For Investigation Type Single
			// /////////////////////////////

			// /////////////////// Submit For Investigation Type Multiple
			// /////////////////////////////
			map = investigationHandlerService
					.submitResultEntryForMultipleInvestigationType(parameterMap);
			// /////////////////// Submit For Investigation Type Multiple
			// /////////////////////////////
			/**
			 * Added by Ritu for sample rejection
			 */
			map = investigationHandlerService.rejectTemplateSample(parameterMap);
			saved = (Boolean) map.get("saved");
			if (saved == true) {
				//messageTOBeVisibleToTheUser = "Result Entry done Successfully.Do You Want To print The Result.";
				messageTOBeVisibleToTheUser = "Empanelled Result Entered.Do You Want To print?";
			}else {
				messageTOBeVisibleToTheUser = "Some Problem Occured.";
			}

			String nextCombinedIds = "";
			if (!CombinedIds.equals("")) {
				String[] idArrString = new String[0];
				idArrString = CombinedIds.split(",");

				int subChargeId = Integer.parseInt(idArrString[1]);

				List<String> combinedListAll = new ArrayList<String>();
				combinedListAll = (List<String>) session.getAttribute("combinedListAll");

				if (combinedListAll.size() > 0) {
					combinedListAll.remove(CombinedIds);
				}
				for (String combinedIdsFromList : combinedListAll) {
					String[] idArray = new String[0];
					idArray = combinedIdsFromList.split(",");

					int subChargeIdFromList = Integer.parseInt(idArray[1]);
					if (subChargeIdFromList == subChargeId) {
						nextCombinedIds = combinedIdsFromList;
						break;
					}
				}
			}
			
			String url = "";
			url = "/hms/hms/investigation?method=searchPatientByBackButtonLab";
			map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
			map.put("url", url);
			// map.put("resultType", resultType);
			map.put("CombinedIds", CombinedIds);
			map.put("nextCombinedIds", nextCombinedIds);
			map.put("order_no",order_no);
			map.put("formSubmitFrom","Empanelled");
			String jsp = MESSAGE_FOR_RESULT_ENTRY_LAB + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);}

	// ------------------- methods for pending for result validation
	// -----------------------------

	public ModelAndView showPendingForResultValidationJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		String deptName = "";
		String deptType = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		if (session.getAttribute("deptType") != null)
			deptType = (String) session.getAttribute("deptType");

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		dataMap.put("deptId", deptId);
		mapForDs.put("deptId", deptId);
		mapForDs.put("deptType", deptType);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		detailsMap = investigationHandlerService
				.getDetailsForResultValidation(dataMap);

		patientMap = investigationHandlerService
				.getResultValidationGrid(mapForDs);
		String jsp = PENDING_RESULT_VALIDATION;
		jsp += ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPendingForResultValidationLabJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		String deptName = "";
		String deptType = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		if (session.getAttribute("deptType") != null)
			deptType = (String) session.getAttribute("deptType");

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		dataMap.put("deptId", deptId);
		mapForDs.put("hospitalId", hospitalId);
		mapForDs.put("deptId", deptId);
		mapForDs.put("deptType", deptType);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		detailsMap = investigationHandlerService
				.getDetailsForResultValidation(dataMap);

		patientMap = investigationHandlerService
				.getResultValidationLabGrid(mapForDs);
		String jsp = PENDING_RESULT_VALIDATION_LAB;
		jsp += ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPendingResultValidationForCorrectionLabJsp(
			HttpServletRequest request, HttpServletResponse response) {
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		String deptName = "";
		String deptType = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		if (session.getAttribute("deptType") != null)
			deptType = (String) session.getAttribute("deptType");

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		dataMap.put("deptId", deptId);
		mapForDs.put("deptId", deptId);
		mapForDs.put("deptType", deptType);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		detailsMap = investigationHandlerService
				.getDetailsForResultValidation(dataMap);

		patientMap = investigationHandlerService
				.getResultEntryCorrectionLabGrid(mapForDs);
		String jsp = RESULT_ENTRY_LIST_FOR_CORRECTION_LAB;
		jsp += ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForResultValidation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		int chargeCodeId = 0;
		String pType = "";
		String serPersonFName = "";
		String patientFName = "";
		Date fromDate = new Date();
		;
		Date toDate = new Date();
		String adNo = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		int hinId = 0;
		int resultId = 0;
		int resultEnteredByForTemplate = 0;
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		String appendedHtml = "";
		String userName = "";
		String diagnosisNo = "";
		String deptType = "";

		Box box = HMSUtil.getBox(request);
		// session.setAttribute("box", box);
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		mapForDs.put("deptId", deptId);
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
			mapForDs.put("deptType", deptType);
		}
		String flagForLab = "";
		String resultIdStringForTemplate = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		try {

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter("flagForLab") != null
					&& !(request.getParameter("flagForLab").equals(""))) {
				flagForLab = request.getParameter("flagForLab");
				// mapForDs.put("hinNo", hinNo);
			}
			
			if (request.getParameter("resultIdStringForTemplate") != null
					&& !(request.getParameter("resultIdStringForTemplate")
							.equals(""))) {
				resultIdStringForTemplate = request
						.getParameter("resultIdStringForTemplate");
				// mapForDs.put("hinNo", hinNo);
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

			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));
				mapForDs.put("chargeCodeId", chargeCodeId);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
			}
			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}

			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				mapForDs.put("departmentId", departmentId);
			}

			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(SAMPLE_ID) != null
					&& !(request.getParameter(SAMPLE_ID).equals("0"))) {
				sampleId = Integer.parseInt(request.getParameter(SAMPLE_ID));
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				orderType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("orderType", orderType);
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
			if (request.getParameter(RESULT_ID) != null
					&& !(request.getParameter(RESULT_ID).equals("0"))) {
				resultId = Integer.parseInt(request.getParameter(RESULT_ID));
				mapForDs.put("resultId", resultId);
			}

			if (request.getParameter(DIAGNOSIS_NO) != null
					&& !(request.getParameter(DIAGNOSIS_NO).equals(""))) {
				diagnosisNo = request.getParameter(DIAGNOSIS_NO);
				mapForDs.put("diagnosisNo", diagnosisNo);
			}
			if (request.getParameter("resultEnteredByForTemplate") != null
					&& !(request.getParameter("resultEnteredByForTemplate")
							.equals("")) && !(request.getParameter("resultEnteredByForTemplate")
									.equals("undefined"))) {
				resultEnteredByForTemplate = Integer.parseInt(request
						.getParameter("resultEnteredByForTemplate"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = "";
		int id = 0;
		List<Patient> patientList = new ArrayList<Patient>();
		if (resultId != 0) {
			map = investigationHandlerService.getResultEntryDetails(resultId,
					deptId);
			List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
			if (map.get("resultList") != null) {
				resultList = (List<DgResultEntryHeader>) map.get("resultList");
			}
			Set<DgResultEntryDetail> dgDetailSet = new HashSet<DgResultEntryDetail>();
			for (DgResultEntryHeader dgHeader : resultList) {
				dgDetailSet = dgHeader.getDgResultEntryDetails();
				id = dgHeader.getId();
			}
			if (resultList != null && resultList.get(0).getResultType() != null
					&& resultList.get(0).getResultType().equals("S")) {
				jsp = "sensitiveResultValidation";
			} else {
				for (DgResultEntryDetail dgResEntry : dgDetailSet) {
					if (dgResEntry.getInvestigation().getInvestigationType()
							.equals("s")) {
						jsp = RESULT_VALIDATION_ENTRY_SINGLE_PARAMETER + ".jsp";
					} else if (dgResEntry.getInvestigation()
							.getInvestigationType().equals("m")) {
						jsp = RESULT_VALIDATION_ENTRY + ".jsp";
					} else if (dgResEntry.getInvestigation()
							.getInvestigationType().equals("t")) {
						// code for coping template contents to server path
						new File(getServletContext().getRealPath("/temp/"))
								.mkdir();

						try {
							InputStream is = new FileInputStream(
									getServletContext().getRealPath(
											"jsp/pdf/appendingHtml.html"));
							File temprory1 = new File(getServletContext()
									.getRealPath("jsp/pdf/appendingHtml.html"));
							byte[] b3 = new byte[(int) temprory1.length()];
							int offset = 0;
							int numRead = 0;
							try {
								while ((offset < b3.length)
										&& ((numRead = is.read(b3, offset,
												b3.length - offset)) >= 0)) {

									offset += numRead;

								}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								is.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
							appendedHtml = new String(b3);
							if (request.getAttribute("secondRequest") == null) {
								File temprory = new File(getServletContext()
										.getRealPath("/temp/" + "temp.html"));

								FileOutputStream fos = null;
								try {
									fos = new FileOutputStream(
											getServletContext().getRealPath(
													"/temp/" + "temp.html"));
								} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IllegalStateException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								try {
									fos
											.write(dgResEntry.getResult()
													.getBytes());
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					
						if( flagForLab.equals("fromExam"))
							{
							jsp = RESULT_VALIDATION_ENTRY_TEMPLATE_MEDICALEXAM ;
							
						//	map.put("contentJsp", RESULT_VALIDATION_ENTRY_TEMPLATE_MEDICALEXAM);
							}else if (!flagForLab.equals("")&& flagForLab.equals("fromLab")) {
								map.put("contentJsp", RESULT_VALIDATION_ENTRY_TEMPLATE_LAB+".jsp" );
							    jsp = "index";
						} else {
							map.put("contentJsp", RESULT_VALIDATION_ENTRY_TEMPLATE+".jsp");
						    jsp = "index";
						}
					}
				}
			}
		} else {
			patientMap = investigationHandlerService
					.getPatientDetailsForResultValidation(mapForDs);
			if (patientMap.get("patientDetailsList") != null) {
				patientList = (List<Patient>) patientMap
						.get("patientDetailsList");
			}

			detailsMap = investigationHandlerService
					.getDetailsForResultValidation(dataMap);
			jsp = PENDING_RESULT_VALIDATION + ".jsp";
		}

		
		patientMap.put("patientList", patientList);
		map.put("resultId", resultId);
		map.put("resultIdStringForTemplate", resultIdStringForTemplate);
		map.put("resultEnteredByForTemplate", resultEnteredByForTemplate);
		map.put("appendedHtml", appendedHtml);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("id", id);
	//	map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForResultEntryModification(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		int chargeCodeId = 0;
		String pType = "";
		String serPersonFName = "";
		String patientFName = "";
		Date fromDate = new Date();
		;
		Date toDate = new Date();
		String adNo = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		int hinId = 0;
		int resultId = 0;
		int resultEnteredByForTemplate = 0;
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		String appendedHtml = "";
		String userName = "";
		String diagnosisNo = "";
		String deptType = "";

		Box box = HMSUtil.getBox(request);
		// session.setAttribute("box", box);
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		mapForDs.put("deptId", deptId);
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
			mapForDs.put("deptType", deptType);
		}
		String flagForLab = "";
		String resultIdStringForTemplate = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		try {

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter("flagForLab") != null
					&& !(request.getParameter("flagForLab").equals(""))) {
				flagForLab = request.getParameter("flagForLab");
				// mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter("resultIdStringForTemplate") != null
					&& !(request.getParameter("resultIdStringForTemplate")
							.equals(""))) {
				resultIdStringForTemplate = request
						.getParameter("resultIdStringForTemplate");
				// mapForDs.put("hinNo", hinNo);
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

			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));
				mapForDs.put("chargeCodeId", chargeCodeId);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
			}
			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}

			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				mapForDs.put("departmentId", departmentId);
			}

			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(SAMPLE_ID) != null
					&& !(request.getParameter(SAMPLE_ID).equals("0"))) {
				sampleId = Integer.parseInt(request.getParameter(SAMPLE_ID));
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				orderType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("orderType", orderType);
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
			if (request.getParameter(RESULT_ID) != null
					&& !(request.getParameter(RESULT_ID).equals("0"))) {
				resultId = Integer.parseInt(request.getParameter(RESULT_ID));
				mapForDs.put("resultId", resultId);
			}

			if (request.getParameter(DIAGNOSIS_NO) != null
					&& !(request.getParameter(DIAGNOSIS_NO).equals(""))) {
				diagnosisNo = request.getParameter(DIAGNOSIS_NO);
				mapForDs.put("diagnosisNo", diagnosisNo);
			}
			if (request.getParameter("resultEnteredByForTemplate") != null
					&& !(request.getParameter("resultEnteredByForTemplate")
							.equals(""))) {
				resultEnteredByForTemplate = Integer.parseInt(request
						.getParameter("resultEnteredByForTemplate"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsp = "";
		int id = 0;
		List<Patient> patientList = new ArrayList<Patient>();
		if (resultId != 0) {

			map = investigationHandlerService.getResultEntryForModification(
					resultId, deptId);
			List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
			if (map.get("resultList") != null) {
				resultList = (List<DgResultEntryHeader>) map.get("resultList");
			}
			Set<DgResultEntryDetail> dgDetailSet = new HashSet<DgResultEntryDetail>();
			for (DgResultEntryHeader dgHeader : resultList) {
				dgDetailSet = dgHeader.getDgResultEntryDetails();
				id = dgHeader.getId();
			}
			if (resultList != null && resultList.get(0).getResultType() != null
					&& resultList.get(0).getResultType().equals("S")) {
				jsp = "sensitiveResultEntryForModification.jsp";
			} else {
				for (DgResultEntryDetail dgResEntry : dgDetailSet) {
					if (dgResEntry.getInvestigation().getInvestigationType()
							.equals("s")) {
						jsp = RESULT_VALIDATION_ENTRY_SINGLE_PARAMETER + ".jsp";
					} else if (dgResEntry.getInvestigation()
							.getInvestigationType().equals("m")) {
						jsp = RESULT_VALIDATION_ENTRY + ".jsp";
					} else if (dgResEntry.getInvestigation()
							.getInvestigationType().equals("t")) {
						// code for coping template contents to server path
						new File(getServletContext().getRealPath("/temp/"))
								.mkdir();

						try {

							InputStream is = new FileInputStream(
									getServletContext().getRealPath(
											"jsp/pdf/appendingHtml.html"));
							File temprory1 = new File(getServletContext()
									.getRealPath("jsp/pdf/appendingHtml.html"));

							byte[] b3 = new byte[(int) temprory1.length()];
							int offset = 0;
							int numRead = 0;
							try {
								while ((offset < b3.length)
										&& ((numRead = is.read(b3, offset,
												b3.length - offset)) >= 0)) {

									offset += numRead;

								}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								is.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							appendedHtml = new String(b3);


							if (request.getAttribute("secondRequest") == null) {
								File temprory = new File(getServletContext()
										.getRealPath("/temp/" + "temp.html"));

								FileOutputStream fos = null;
								try {
									fos = new FileOutputStream(
											getServletContext().getRealPath(
													"/temp/" + "temp.html"));
								} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IllegalStateException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								try {

									fos
											.write(dgResEntry.getResult()
													.getBytes());

								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}

						if (!flagForLab.equals("")
								&& flagForLab.equals("fromLab")) {
							jsp = RESULT_ENTRY_TEMPLATE_FOR_MODIFICATION_LAB
									+ ".jsp";
						} else {
							jsp = RESULT_VALIDATION_ENTRY_TEMPLATE + ".jsp";
						}

					}
				}
			}
		} else {
			patientMap = investigationHandlerService
					.getPatientDetailsForResultEntryModification(mapForDs);
			if (patientMap.get("patientDetailsList") != null) {
				patientList = (List<Patient>) patientMap
						.get("patientDetailsList");
			}

			detailsMap = investigationHandlerService
					.getDetailsForResultValidation(dataMap);
			jsp = PENDING_RESULT_VALIDATION + ".jsp";
		}

		patientMap.put("patientList", patientList);
		map.put("resultId", resultId);
		map.put("resultIdStringForTemplate", resultIdStringForTemplate);
		map.put("resultEnteredByForTemplate", resultEnteredByForTemplate);
		map.put("appendedHtml", appendedHtml);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("id", id);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchPatientForResultValidationLab(
		HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = (HttpSession)request.getSession();
		String serviceNo = "";
		String hinNo = "";
		int chargeCodeId = 0;
		String serPersonFName = "";
		String patientFName = "";
		Date fromDate = null;
		
		Date toDate = null;
		String adNo = "";
		int departmentId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		int hinId = 0;
		String resultId = "";
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		String appendedHtml = "";
		String userName = "";
		String diagnosisNo = "";
		String deptType = "";
		String barCodeOrderNo="";

		// session.setAttribute("box", box);
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		mapForDs.put("deptId", deptId);
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
			mapForDs.put("deptType", deptType);
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		mapForDs.put("hospitalId", hospitalId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		try {

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
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

			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));
				mapForDs.put("chargeCodeId", chargeCodeId);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
			}
			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}

			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				mapForDs.put("departmentId", departmentId);
			}

			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				orderType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("orderType", orderType);
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
			if (request.getParameter(RESULT_ID) != null
					&& !(request.getParameter(RESULT_ID).equals("0"))) {
				resultId = (String) request.getParameter(RESULT_ID);
				mapForDs.put("resultId", resultId);
				dataMap.put("resultId", resultId);
			}

			if (request.getParameter(DIAGNOSIS_NO) != null
					&& !(request.getParameter(DIAGNOSIS_NO).equals(""))) {
				diagnosisNo = request.getParameter(DIAGNOSIS_NO);
				mapForDs.put("diagnosisNo", diagnosisNo);
			}
			if (request.getParameter("barCodeOrderNo") != null)
			{
				barCodeOrderNo = request.getParameter("barCodeOrderNo");
				mapForDs.put("barCodeOrderNo", barCodeOrderNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = "";
		List<Patient> patientList = new ArrayList<Patient>();

		Map<String, Object> diagMap = new HashMap<String, Object>();
		if (!resultId.equals("")) {
			map = investigationHandlerService.getResultEntryDetailsLab(dataMap);
			map.put("resultId", resultId);
			List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
			if (map.get("resultList") != null) {
				resultList = (List<DgResultEntryHeader>) map.get("resultList");
			}
			jsp = RESULT_VALIDATION_ENTRY_SINGLE_PARAMETER_LAB + ".jsp";
		} else {
			patientMap = investigationHandlerService
					.getPatientDetailsForResultValidationLab(mapForDs);
			if (patientMap.get("patientDetailsList") != null) {
				patientList = (List<Patient>) patientMap
						.get("patientDetailsList");
			}
			//detailsMap = investigationHandlerService.getDetailsForResultValidation(dataMap);
			jsp = PENDING_RESULT_VALIDATION_LAB + ".jsp";
		}

		patientMap.put("patientList", patientList);
		map.put("resultId", resultId);
		map.put("appendedHtml", appendedHtml);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView searchPatientForResultUpdationLab(
			HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> mapForDs = new HashMap<String, Object>();
			Map<String, Object> patientMap = new HashMap<String, Object>();
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			HttpSession session = (HttpSession)request.getSession();
			String serviceNo = "";
			String hinNo = "";
			int chargeCodeId = 0;
			String serPersonFName = "";
			String patientFName = "";
			Date fromDate = null;
			
			Date toDate = null;
			String adNo = "";
			int departmentId = 0;
			int subChargeCodeId = 0;
			String orderType = "";
			int hinId = 0;
			String resultId = "";
			int deptId = 0;
			int hospitalId = 0;
			String deptName = "";
			String appendedHtml = "";
			String userName = "";
			String diagnosisNo = "";
			String deptType = "";
			String barCodeOrderNo="";

			// session.setAttribute("box", box);
			session = request.getSession();
			if (session.getAttribute("userName") != null)
				userName = (String) session.getAttribute("userName");
			if (session.getAttribute("hospitalId") != null)
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			if (session.getAttribute("deptId") != null)
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			mapForDs.put("deptId", deptId);
			if (session.getAttribute("deptName") != null)
				deptName = (String) session.getAttribute("deptName");
			if (session.getAttribute("deptType") != null) {
				deptType = (String) session.getAttribute("deptType");
				mapForDs.put("deptType", deptType);
			}
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("deptId", deptId);
			mapForDs.put("hospitalId", hospitalId);
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("userName", userName);
			dataMap.put("deptName", deptName);

			try {

				if (request.getParameter(HIN_NO) != null
						&& !(request.getParameter(HIN_NO).equals(""))) {
					hinNo = request.getParameter(HIN_NO);
					mapForDs.put("hinNo", hinNo);
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

				if (request.getParameter(SERVICE_NO) != null
						&& !(request.getParameter(SERVICE_NO).equals(""))) {
					serviceNo = request.getParameter(SERVICE_NO);
					mapForDs.put("serviceNo", serviceNo);
				}
				if (request.getParameter(CHARGE_CODE_ID) != null
						&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
					chargeCodeId = Integer.parseInt(request
							.getParameter(CHARGE_CODE_ID));
					mapForDs.put("chargeCodeId", chargeCodeId);
				}
				if (request.getParameter(SUB_CHARGECODE_ID) != null
						&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
					subChargeCodeId = Integer.parseInt(request
							.getParameter(SUB_CHARGECODE_ID));
					mapForDs.put("subChargeCodeId", subChargeCodeId);
				}
				if (request.getParameter(S_FIRST_NAME) != null
						&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
					serPersonFName = request.getParameter(S_FIRST_NAME);
					mapForDs.put("serPersonFName", serPersonFName);
				}
				if (request.getParameter(P_FIRST_NAME) != null
						&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
					patientFName = request.getParameter(P_FIRST_NAME);
					mapForDs.put("patientFName", patientFName);
				}
				if (request.getParameter(AD_NO) != null
						&& !(request.getParameter(AD_NO).equals(""))) {
					adNo = request.getParameter(AD_NO);
					mapForDs.put("adNo", adNo);
				}

				if (request.getParameter(DEPARTMENT_ID) != null
						&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
					departmentId = Integer.parseInt(request
							.getParameter(DEPARTMENT_ID));
					mapForDs.put("departmentId", departmentId);
				}

				if (request.getParameter(HIN_ID) != null
						&& !(request.getParameter(HIN_ID).equals("0"))) {
					hinId = Integer.parseInt(request.getParameter(HIN_ID));
					mapForDs.put("hinId", hinId);
				}
				if (request.getParameter(PATIENT_TYPE) != null
						&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
					orderType = request.getParameter(PATIENT_TYPE);
					mapForDs.put("orderType", orderType);
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
				if (request.getParameter(RESULT_ID) != null
						&& !(request.getParameter(RESULT_ID).equals("0"))) {
					resultId = (String) request.getParameter(RESULT_ID);
					mapForDs.put("resultId", resultId);
					dataMap.put("resultId", resultId);
				}

				if (request.getParameter(DIAGNOSIS_NO) != null
						&& !(request.getParameter(DIAGNOSIS_NO).equals(""))) {
					diagnosisNo = request.getParameter(DIAGNOSIS_NO);
					mapForDs.put("diagnosisNo", diagnosisNo);
				}
				if (request.getParameter("barCodeOrderNo") != null)
				{
					barCodeOrderNo = request.getParameter("barCodeOrderNo");
					mapForDs.put("barCodeOrderNo", barCodeOrderNo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			String jsp = "";
			List<Patient> patientList = new ArrayList<Patient>();

			Map<String, Object> diagMap = new HashMap<String, Object>();
			if (!resultId.equals("")) {
				map = investigationHandlerService.getResultEntryDetailsLabForUpdation(dataMap);
				map.put("resultId", resultId);
				List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
				if (map.get("resultList") != null) {
					resultList = (List<DgResultEntryHeader>) map.get("resultList");
				}
				jsp = "resultUpdationEntryForSingleParameterLab.jsp";
			} else {
				patientMap = investigationHandlerService
						.getPatientDetailsForResultUpdationLab(mapForDs);
				if (patientMap.get("patientDetailsList") != null) {
					patientList = (List<Patient>) patientMap
							.get("patientDetailsList");
				}
				//detailsMap = investigationHandlerService.getDetailsForResultValidation(dataMap);
				jsp = "resultUpdationLab.jsp";
			}

			patientMap.put("patientList", patientList);
			map.put("resultId", resultId);
			map.put("appendedHtml", appendedHtml);
			map.put("detailsMap", detailsMap);
			map.put("patientMap", patientMap);
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}

	public ModelAndView searchPatientForResultEntryCorrectionLab(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		int chargeCodeId = 0;
		String serPersonFName = "";
		String patientFName = "";
		Date fromDate = new Date();
		;
		Date toDate = new Date();
		String adNo = "";
		int departmentId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		int hinId = 0;
		String resultId = "";
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		String appendedHtml = "";
		String userName = "";
		String diagnosisNo = "";
		String deptType = "";

		Box box = HMSUtil.getBox(request);
		// session.setAttribute("box", box);
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		mapForDs.put("deptId", deptId);
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
			mapForDs.put("deptType", deptType);
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		try {

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
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

			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));
				mapForDs.put("chargeCodeId", chargeCodeId);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
			}
			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}

			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				mapForDs.put("departmentId", departmentId);
			}

			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				orderType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("orderType", orderType);
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
			if (request.getParameter(RESULT_ID) != null
					&& !(request.getParameter(RESULT_ID).equals("0"))) {
				resultId = (String) request.getParameter(RESULT_ID);
				mapForDs.put("resultId", resultId);
				dataMap.put("resultId", resultId);
			}

			if (request.getParameter(DIAGNOSIS_NO) != null
					&& !(request.getParameter(DIAGNOSIS_NO).equals(""))) {
				diagnosisNo = request.getParameter(DIAGNOSIS_NO);
				mapForDs.put("diagnosisNo", diagnosisNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = investigationHandlerService
				.getPatientDetailsForResultEntryModificationLab(mapForDs);
		String jsp = "";
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDetailsList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDetailsList");
		}

		Map<String, Object> diagMap = new HashMap<String, Object>();
		if (!resultId.equals("")) {
			map = investigationHandlerService.getResultEntryDetailsLab(dataMap);
			map.put("resultId", resultId);
			List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
			if (map.get("resultList") != null) {
				resultList = (List<DgResultEntryHeader>) map.get("resultList");
			}
			jsp = RESULT_ENTRY_VALUES_FOR_CORRECTION_LAB + ".jsp";
		} else {
			detailsMap = investigationHandlerService
					.getResultEntryCorrectionLabGrid(dataMap);
			jsp = RESULT_ENTRY_LIST_FOR_CORRECTION_LAB + ".jsp";
		}

		patientMap.put("patientList", patientList);
		map.put("resultId", resultId);
		map.put("appendedHtml", appendedHtml);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitResultValidation(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String messageTOBeVisibleToTheUser = "";
		String url = "";
		int resultId = 0;
		int resultValidatedBy = 0;
		int newResultId = 0;
		String resultNo = "";
		String resultType = "";
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		if (request.getParameter("resultNo") != null) {
			resultNo = request.getParameter("resultNo");
		}

		if (request.getParameter("resultType") != null) {
			resultType = request.getParameter("resultType");
		}

		resultId = Integer.parseInt(request.getParameter(RESULT_ID));
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		patientList = (List<DgResultEntryHeader>) session
				.getAttribute("patientList");

		if (patientList.size() > 0) {
			for (Iterator iterator = patientList.iterator(); iterator.hasNext();) {
				DgResultEntryHeader dgResultEntryHeader = (DgResultEntryHeader) iterator
						.next();
				newResultId = dgResultEntryHeader.getId();
				if (newResultId == resultId) {
					iterator.remove();
				}
			}

		}
		Map<String, Object> patientMap = new HashMap<String, Object>();
		if (newResultId != 0) {
			map = investigationHandlerService.getResultEntryDetailsForNext(
					newResultId, deptId);
		}

		if (request.getParameter(RESULT_VALIDATED_BY) != null
				&& !request.getParameter(RESULT_VALIDATED_BY).equals("")) {
			resultValidatedBy = Integer.parseInt(request
					.getParameter(RESULT_VALIDATED_BY));
		}
		map = investigationHandlerService.getResultList(resultId);
		infoMap.put("box", box);

		infoMap.put("resultId", resultId);
		infoMap.put("resultValidatedBy", resultValidatedBy);
		boolean flag = false;
		try {
			flag = investigationHandlerService.submitResultValidation(infoMap);

			if (flag == false) {
				messageTOBeVisibleToTheUser = "Successfully Validated The Result. Do You want to Print. ";
			} else {
				messageTOBeVisibleToTheUser = "Some Problem occured.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsp = MESSAGE_FOR_RESULT_JSP + ".jsp";
		url = "/hms/hms/investigation?method=searchPatientForResultValidation";
		map.put("resultNo", resultNo);
		map.put("resultType", resultType);
		map.put("url", url);
		map.put("resultId", resultId);
		map.put("newResultId", newResultId);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// /================== validation for single parameter ===========

	public ModelAndView submitResultValidationForSingleParameter(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String url = "";
		int resultId = 0;
		int newResultId = 0;
		int resultValidatedBy = 0;
		String messageTOBeVisibleToTheUser = "";
		String resultNo = "";
		String resultType = "";
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (request.getParameter("resultNo") != null) {
			resultNo = request.getParameter("resultNo");
		}

		if (request.getParameter("resultType") != null) {
			resultType = request.getParameter("resultType");
		}
		resultId = Integer.parseInt(request.getParameter(RESULT_ID));
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();

		patientList = (List<DgResultEntryHeader>) session
				.getAttribute("patientList");

		if (patientList.size() > 0) {
			for (Iterator iterator = patientList.iterator(); iterator.hasNext();) {
				DgResultEntryHeader dgResultEntryHeader = (DgResultEntryHeader) iterator
						.next();
				newResultId = dgResultEntryHeader.getId();
				if (newResultId == resultId) {
					iterator.remove();
				}
			}

		}
		Map<String, Object> patientMap = new HashMap<String, Object>();
		if (newResultId != 0) {
			map = investigationHandlerService.getResultEntryDetailsForNext(
					newResultId, deptId);
		}
		if (request.getParameter(RESULT_VALIDATED_BY) != null
				&& !request.getParameter(RESULT_VALIDATED_BY).equals("")) {
			resultValidatedBy = Integer.parseInt(request
					.getParameter(RESULT_VALIDATED_BY));
		}
		map = investigationHandlerService.getResultList(resultId);
		infoMap.put("box", box);

		infoMap.put("resultId", resultId);
		infoMap.put("resultValidatedBy", resultValidatedBy);
		boolean flag = false;
		try {
			flag = investigationHandlerService
					.submitResultValidationForSingleParameter(infoMap);
			if (flag == false) {
				messageTOBeVisibleToTheUser = "Successfully Validated the result.Do you want to print.";
			} else {
				messageTOBeVisibleToTheUser = "Some Problem occured.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = MESSAGE_FOR_RESULT_JSP + ".jsp";
		url = "/hms/hms/investigation?method=searchPatientForResultValidation";
		map.put("resultNo", resultNo);
		map.put("resultType", resultType);
		map.put("url", url);
		map.put("resultId", resultId);
		map.put("newResultId", newResultId);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitResultValidationForAllInvestigationTypeLab(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String url = "";
		int resultId = 0;
		int newResultId = 0;
		int resultValidatedBy = 0;
		String messageTOBeVisibleToTheUser = "";
		String resultIdStringForTemplate = "";
		int validatedCheckBoxCountMultiple = 0;
		int validatedCheckBoxCountSingle = 0;
		String checkId1 = "";
		int deptId = 0;
		HttpSession session= request.getSession();
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		if (request.getParameter("validatedCheckBoxCountSingle") != null
				&& !request.getParameter("validatedCheckBoxCountSingle")
						.equals("")) {
			validatedCheckBoxCountSingle = Integer.parseInt(request
					.getParameter("validatedCheckBoxCountSingle"));
		}
		if (request.getParameter("validatedCheckBoxCountMultiple") != null
				&& !request.getParameter("validatedCheckBoxCountMultiple")
						.equals("")) {
			validatedCheckBoxCountMultiple = Integer.parseInt(request
					.getParameter("validatedCheckBoxCountMultiple"));
		}
		if (request.getParameter("resultIdStringForTemplate") != null) {
			resultIdStringForTemplate = (String) request
					.getParameter("resultIdStringForTemplate");
		}

		List<String> validatedListSingleType = new ArrayList<String>();
		List<String> validatedListMultipleType = new ArrayList<String>();
        String orderNo = "";
		for (int x = 0; x < validatedCheckBoxCountSingle; x++) {
			if (request.getParameter("checkIdSingleValue" + x) != null) {
				validatedListSingleType.add("y");
			} else {
				validatedListSingleType.add("n");
			}
		}
		for (int x = 0; x < validatedCheckBoxCountMultiple; x++) {
			if (request.getParameter("checkId" + x) != null) {
				if (request.getParameter("checkId" + x).equals("testValidate")) {
					validatedListMultipleType.add("testValidate");
				} else {
					validatedListMultipleType.add("y");
				}
			} else {
				validatedListMultipleType.add("n");
			}
		}

		if (request.getParameter(RESULT_VALIDATED_BY) != null
				&& !request.getParameter(RESULT_VALIDATED_BY).equals("")) {
			resultValidatedBy = Integer.parseInt(request
					.getParameter(RESULT_VALIDATED_BY));
		}
		
		if(request.getParameter(ORDER_NO)!= null && !(request.getParameter(ORDER_NO).equals("")))
		{
		  orderNo=	request.getParameter(ORDER_NO);
		 // System.out.println("orderNo in Investigation Controller====>>>2222222"+orderNo);
		}
		 box = HMSUtil.getBox(request);
		String OrderNo=box.get("OrderNo");
        System.out.println("OrderNo in InvestigationController submitResultValidationForAllinvestigationTypeLab========>>>>>"+OrderNo); 
		infoMap.put("box", box);
		infoMap.put("validatedListSingleType", validatedListSingleType);
		infoMap.put("validatedListMultipleType", validatedListMultipleType);

		infoMap.put("resultValidatedBy", resultValidatedBy);
		boolean flag = true;
		try {
			// /////////////////// Method To Submit Single Value Type
			// Investigation /////////////////////
			flag = investigationHandlerService
					.submitResultValidationForSingleParameterOnly(infoMap);
			// /////////////////// Method To Submit Single Value Type
			// Investigation /////////////////////

			// /////////////////// Method To Submit Multiple Value Type
			// Investigation /////////////////////
			flag = investigationHandlerService
					.submitResultValidationLab(infoMap);
			// /////////////////// Method To Submit Multiple Value Type
			// Investigation /////////////////////

			if (flag == true) {
				messageTOBeVisibleToTheUser = "Result validated.Do you want to print?";
			} else {
				messageTOBeVisibleToTheUser = "Some Problem occured.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String nextCombinedValidationIds = "";
		if (!resultIdStringForTemplate.equals("")) {
			String[] idArrString = new String[0];
			idArrString = resultIdStringForTemplate.split("@");

			int subChargeId = Integer.parseInt(idArrString[1]);

			List<String> pendingValidationListLabAll = new ArrayList<String>();
			pendingValidationListLabAll = (List<String>) session
					.getAttribute("pendingValidationListLabAll");

			if (pendingValidationListLabAll.size() > 0) {
				pendingValidationListLabAll.remove(resultIdStringForTemplate);
			}
			for (String combinedIdsFromList : pendingValidationListLabAll) {
				String[] idArray = new String[0];
				idArray = combinedIdsFromList.split("@");

				int subChargeIdFromList = Integer.parseInt(idArray[1]);
				if (subChargeIdFromList == subChargeId) {
					nextCombinedValidationIds = combinedIdsFromList;
					break;
				}
			}
		}
		if(request.getParameter("orderId")!=null && !request.getParameter("orderId").equals("")){
			map.put("orderId", Integer.parseInt(request.getParameter("orderId")));
		}
		String jsp = MESSAGE_FOR_RESULT_VALIDATION_LAB + ".jsp";
		map.put("orderNo",orderNo);    
		map.put("resultIdStringForTemplate", resultIdStringForTemplate);
		map.put("nextCombinedValidationIds", nextCombinedValidationIds);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView submitResultUpdationForAllInvestigationTypeLab(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String url = "";
		int resultId = 0;
		int newResultId = 0;
		int resultValidatedBy = 0;
		
		int resultUpdatedBy=0;
		String messageTOBeVisibleToTheUser = "";
		String resultIdStringForTemplate = "";
		int validatedCheckBoxCountMultiple = 0;
		int validatedCheckBoxCountSingle = 0;
		String checkId1 = "";
		int deptId = 0;
		HttpSession session= request.getSession();
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		if (request.getParameter("validatedCheckBoxCountSingle") != null
				&& !request.getParameter("validatedCheckBoxCountSingle")
						.equals("")) {
			validatedCheckBoxCountSingle = Integer.parseInt(request
					.getParameter("validatedCheckBoxCountSingle"));
		}
		if (request.getParameter("validatedCheckBoxCountMultiple") != null
				&& !request.getParameter("validatedCheckBoxCountMultiple")
						.equals("")) {
			validatedCheckBoxCountMultiple = Integer.parseInt(request
					.getParameter("validatedCheckBoxCountMultiple"));
		}
		if (request.getParameter("resultIdStringForTemplate") != null) {
			resultIdStringForTemplate = (String) request
					.getParameter("resultIdStringForTemplate");
		}

		List<String> validatedListSingleType = new ArrayList<String>();
		List<String> validatedListMultipleType = new ArrayList<String>();
        String orderNo = "";
		for (int x = 0; x < validatedCheckBoxCountSingle; x++) {
			if (request.getParameter("checkIdSingleValue" + x) != null) {
				validatedListSingleType.add("y");
			} else {
				validatedListSingleType.add("n");
			}
		}
		for (int x = 0; x < validatedCheckBoxCountMultiple; x++) {
			if (request.getParameter("checkId" + x) != null) {
				if (request.getParameter("checkId" + x).equals("testValidate")) {
					validatedListMultipleType.add("testValidate");
				} else {
					validatedListMultipleType.add("y");
				}
			} else {
				validatedListMultipleType.add("n");
			}
		}

		if (request.getParameter(RESULT_VALIDATED_BY) != null
				&& !request.getParameter(RESULT_VALIDATED_BY).equals("")) {
			resultValidatedBy = Integer.parseInt(request
					.getParameter(RESULT_VALIDATED_BY));
		}
		
		if (request.getParameter("resultUpdatedBy") != null
				&& !request.getParameter("resultUpdatedBy").equals("")) {
			resultUpdatedBy = Integer.parseInt(request
					.getParameter("resultUpdatedBy"));
		}
		
		if(request.getParameter(ORDER_NO)!= null && !(request.getParameter(ORDER_NO).equals("")))
		{
		  orderNo=	request.getParameter(ORDER_NO);
		 // System.out.println("orderNo in Investigation Controller====>>>2222222"+orderNo);
		}
		 box = HMSUtil.getBox(request);
		String OrderNo=box.get("OrderNo");
        System.out.println("OrderNo in InvestigationController submitResultValidationForAllinvestigationTypeLab========>>>>>"+OrderNo); 
		infoMap.put("box", box);
		infoMap.put("validatedListSingleType", validatedListSingleType);
		infoMap.put("validatedListMultipleType", validatedListMultipleType);

		infoMap.put("resultValidatedBy", resultValidatedBy);
		infoMap.put("resultUpdatedBy", resultUpdatedBy);
		boolean flag = true;
		try {
			// /////////////////// Method To Submit Single Value Type
			// Investigation /////////////////////
			flag = investigationHandlerService
					.submitResultValidationForSingleParameterOnly(infoMap);
			// /////////////////// Method To Submit Single Value Type
			// Investigation /////////////////////

			// /////////////////// Method To Submit Multiple Value Type
			// Investigation /////////////////////
			flag = investigationHandlerService
					.submitResultValidationLab(infoMap);
			// /////////////////// Method To Submit Multiple Value Type
			// Investigation /////////////////////

			if (flag == true) {
				messageTOBeVisibleToTheUser = "Result Updated Sucessfully.Do you want to print?";
			} else {
				messageTOBeVisibleToTheUser = "Some Problem occured.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String nextCombinedValidationIds = "";
		if (!resultIdStringForTemplate.equals("")) {
			String[] idArrString = new String[0];
			idArrString = resultIdStringForTemplate.split("@");

			int subChargeId = Integer.parseInt(idArrString[1]);

			List<String> pendingValidationListLabAll = new ArrayList<String>();
			pendingValidationListLabAll = (List<String>) session
					.getAttribute("pendingValidationListLabAll");

			if (pendingValidationListLabAll.size() > 0) {
				pendingValidationListLabAll.remove(resultIdStringForTemplate);
			}
			for (String combinedIdsFromList : pendingValidationListLabAll) {
				String[] idArray = new String[0];
				idArray = combinedIdsFromList.split("@");

				int subChargeIdFromList = Integer.parseInt(idArray[1]);
				if (subChargeIdFromList == subChargeId) {
					nextCombinedValidationIds = combinedIdsFromList;
					break;
				}
			}
		}
		if(request.getParameter("orderId")!=null && !request.getParameter("orderId").equals("")){
			map.put("orderId", Integer.parseInt(request.getParameter("orderId")));
		}
		String jsp = "messageForResultUpdationLab.jsp";
		map.put("orderNo",orderNo);    
		map.put("resultIdStringForTemplate", resultIdStringForTemplate);
		map.put("nextCombinedValidationIds", nextCombinedValidationIds);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitResultEntryForModificationLab(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String url = "";
		int resultId = 0;
		int newResultId = 0;
		int resultEnteredBy = 0;
		String messageTOBeVisibleToTheUser = "";
		String resultIdStringForTemplate = "";
		int validatedCheckBoxCountMultiple = 0;
		int validatedCheckBoxCountSingle = 0;
		String checkId1 = "";
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (request.getParameter("resultIdStringForTemplate") != null) {
			resultIdStringForTemplate = (String) request
					.getParameter("resultIdStringForTemplate");
		}

		if (request.getParameter(RESULT_ENTERED_BY) != null
				&& !request.getParameter(RESULT_ENTERED_BY).equals("")) {
			resultEnteredBy = Integer.parseInt(request
					.getParameter(RESULT_ENTERED_BY));
		}

		infoMap.put("box", box);

		infoMap.put("resultEnteredBy", resultEnteredBy);
		boolean flag = true;
		try {
			// /////////////////// Method To Submit Single Value Type
			// Investigation /////////////////////
			flag = investigationHandlerService
					.submitResultEntryForCorrectionSingleInvestigationType(infoMap);
			// /////////////////// Method To Submit Single Value Type
			// Investigation /////////////////////

			// /////////////////// Method To Submit Multiple Value Type
			// Investigation /////////////////////
			flag = investigationHandlerService
					.submitResultEntryLabForCorrectionMultipleType(infoMap);
			// /////////////////// Method To Submit Multiple Value Type
			// Investigation /////////////////////

			if (flag == true) {
				messageTOBeVisibleToTheUser = "Successfully Updated the result.Do you want to print.";
			} else {
				messageTOBeVisibleToTheUser = "Some Problem occured.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsp = MESSAGE_FOR_RESULT_ENTRY_CORRECTION_LAB + ".jsp";

		map.put("resultIdStringForTemplate", resultIdStringForTemplate);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// ======================== submit result validation for template
	// ================

	public ModelAndView submitResultValidationForTemplate(
			HttpServletRequest request, HttpServletResponse response) {
		MultipartFormDataRequest mrequest = null;
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String messageTOBeVisibleToTheUser = "";
		String url = "";
		String resultNo = "";
		String resultType = "";
		String result = "";
		String additionalRemarks = "";
		String validated = "";

		int resultId = 0;
		int newResultId = 0;
		int resultValidatedBy = 0;
		int deptId = 0;
		try {
			if (MultipartFormDataRequest.isMultipartFormData(request)) {
				mrequest = new MultipartFormDataRequest(request);
				// result=mrequest.getParameter("test2");
				String tepmlateData = mrequest.getParameter("test2");
				InputStream fis1 = new FileInputStream(getServletContext()
						.getRealPath("jsp/pdf/appendingHtml.html"));
				File temprory2 = new File(getServletContext().getRealPath(
						"jsp/pdf/appendingHtml.html"));

				byte[] b1 = new byte[(int) temprory2.length()];
				int offset1 = 0;
				int numRead1 = 0;
				try {
					while ((offset1 < b1.length)
							&& ((numRead1 = fis1.read(b1, offset1, b1.length
									- offset1)) >= 0)) {

						offset1 += numRead1;

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fis1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String appendedHtml = new String(b1);
				String finalFile = appendedHtml + tepmlateData
						+ "</body></html>";

				byte[] bytes = finalFile.getBytes();
				result = new String(bytes);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (request.getParameter("resultNo") != null) {
			resultNo = request.getParameter("resultNo");
		}

		if (request.getParameter("resultType") != null) {
			resultType = request.getParameter("resultType");
		}

		resultId = Integer.parseInt(request.getParameter(RESULT_ID));
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();

		patientList = (List<DgResultEntryHeader>) session
				.getAttribute("patientList");
		if (patientList.size() > 0) {
			for (Iterator iterator = patientList.iterator(); iterator.hasNext();) {
				DgResultEntryHeader dgResultEntryHeader = (DgResultEntryHeader) iterator
						.next();
				newResultId = dgResultEntryHeader.getId();
				if (newResultId == resultId) {
					iterator.remove();
				}
			}
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("resultNo", resultNo);
		dataMap.put("deptId", deptId);
		// String templateData="";
		// if(request.getParameter("test2")!=null){
		// templateData=request.getParameter("test2");
		// }
		dataMap.put("templateData", result);
		boolean flag1 = investigationHandlerService
				.updateResultTemplateForValidation(dataMap);
		Map<String, Object> patientMap = new HashMap<String, Object>();
		if (newResultId != 0) {
			map = investigationHandlerService.getResultEntryDetailsForNext(
					newResultId, deptId);
		}

		if (request.getParameter(RESULT_VALIDATED_BY) != null
				&& !request.getParameter(RESULT_VALIDATED_BY).equals("")) {
			resultValidatedBy = Integer.parseInt(request
					.getParameter(RESULT_VALIDATED_BY));
		}
		if (request.getParameter(ADDITIONAL_REMARKS) != null
				&& !request.getParameter(ADDITIONAL_REMARKS).equals("")) {
			additionalRemarks = request.getParameter(ADDITIONAL_REMARKS);
		}
		if (request.getParameter(VALIDATED) != null
				&& !request.getParameter(VALIDATED).equals("")) {
			validated = request.getParameter(VALIDATED);
		}

		map = investigationHandlerService.getResultList(resultId);
		infoMap.put("box", box);
		String jsp = MESSAGE_FOR_RESULT_JSP + ".jsp";

		infoMap.put("resultId", resultId);
		infoMap.put("resultValidatedBy", resultValidatedBy);
		infoMap.put("additionalRemarks", additionalRemarks);
		infoMap.put("validated", validated);

		boolean flag = false;
		try {
			flag = investigationHandlerService
					.submitResultValidationForTemplate(infoMap);
			if (flag == false) {
				messageTOBeVisibleToTheUser = "Successfully Validated the result.Do you want to print.";
			} else {
				messageTOBeVisibleToTheUser = "Some Problem occured";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		url = "/hms/hms/investigation?method=searchPatientForResultValidation";
		map.put("resultNo", resultNo);
		map.put("resultType", resultType);
		map.put("resultId", resultId);
		map.put("newResultId", newResultId);
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitResultValidationForTemplateLab(
			HttpServletRequest request, HttpServletResponse response) {
		MultipartFormDataRequest mrequest = null;
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String messageTOBeVisibleToTheUser = "";
		String url = "";
		String resultNo = "";
		String resultType = "";
		String result = "";
		String additionalRemarks = "";
		String validated = "";
		String resultIdStringForTemplate = "";

		int resultId = 0;
		int newResultId = 0;
		int resultValidatedBy = 0;
		int deptId = 0;
		try {
			if (MultipartFormDataRequest.isMultipartFormData(request)) {
				mrequest = new MultipartFormDataRequest(request);
				// result=mrequest.getParameter("test2");
				String tepmlateData = mrequest.getParameter("test2");
				InputStream fis1 = new FileInputStream(getServletContext()
						.getRealPath("jsp/pdf/appendingHtml.html"));
				File temprory2 = new File(getServletContext().getRealPath(
						"jsp/pdf/appendingHtml.html"));

				byte[] b1 = new byte[(int) temprory2.length()];
				int offset1 = 0;
				int numRead1 = 0;
				try {
					while ((offset1 < b1.length)
							&& ((numRead1 = fis1.read(b1, offset1, b1.length
									- offset1)) >= 0)) {

						offset1 += numRead1;

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fis1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String appendedHtml = new String(b1);
				String finalFile = appendedHtml + tepmlateData
						+ "</body></html>";

				byte[] bytes = finalFile.getBytes();
				result = new String(bytes);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (request.getParameter("resultNo") != null) {
			resultNo = request.getParameter("resultNo");
		}

		if (request.getParameter("resultType") != null) {
			resultType = request.getParameter("resultType");
		}
		if (request.getParameter("resultIdStringForTemplate") != null) {
			resultIdStringForTemplate = request
					.getParameter("resultIdStringForTemplate");
		}

		if (request.getParameter("resultId") != null) {
			resultId = Integer.parseInt(request.getParameter("resultId"));
		}

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("resultNo", resultNo);
		dataMap.put("deptId", deptId);
		// String templateData="";
		// if(request.getParameter("test2")!=null){
		// templateData=request.getParameter("test2");
		// }
		dataMap.put("templateData", result);
		dataMap.put("resultId", resultIdStringForTemplate);
		dataMap.put("resultIdToRemove", resultId);

		boolean flag1 = investigationHandlerService
				.updateResultTemplateForValidation(dataMap);
		Map<String, Object> patientMap = new HashMap<String, Object>();
		/*
		 * if( newResultId != 0){ map =
		 * investigationHandlerService.getResultEntryDetailsForNext
		 * (newResultId,deptId); }
		 */

		if (request.getParameter(RESULT_VALIDATED_BY) != null
				&& !request.getParameter(RESULT_VALIDATED_BY).equals("")) {
			resultValidatedBy = Integer.parseInt(request
					.getParameter(RESULT_VALIDATED_BY));
		}
		if (request.getParameter(ADDITIONAL_REMARKS) != null
				&& !request.getParameter(ADDITIONAL_REMARKS).equals("")) {
			additionalRemarks = request.getParameter(ADDITIONAL_REMARKS);
		}
		if (request.getParameter(VALIDATED) != null
				&& !request.getParameter(VALIDATED).equals("")) {
			validated = request.getParameter(VALIDATED);
		}

		// map=investigationHandlerService.getResultList(resultId);
		infoMap.put("box", box);
		String jsp = MESSAGE_FOR_RESULT_JSP + ".jsp";

		infoMap.put("resultId", resultId);
		infoMap.put("resultValidatedBy", resultValidatedBy);
		infoMap.put("additionalRemarks", additionalRemarks);
		infoMap.put("validated", validated);

		boolean flag = false;
		try {
			flag = investigationHandlerService
					.submitResultValidationForTemplate(infoMap);
			if (flag == false) {
				messageTOBeVisibleToTheUser = "Result validated. Do you want to print?";
			} else {
				messageTOBeVisibleToTheUser = "Some Problem occured";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!resultIdStringForTemplate.equals("")) {
			map = investigationHandlerService.getResultEntryDetailsLab(dataMap);
			map.put("resultId", resultIdStringForTemplate);
			List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
			if (map.get("resultList") != null) {
				resultList = (List<DgResultEntryHeader>) map.get("resultList");
				if (resultList.size() > 0) {
					jsp = RESULT_VALIDATION_ENTRY_SINGLE_PARAMETER_LAB + ".jsp";
				} else {
					String nextCombinedValidationIds = "";
					if (!resultIdStringForTemplate.equals("")) {
						String[] idArrString = new String[0];
						idArrString = resultIdStringForTemplate.split("@");

						int subChargeId = Integer.parseInt(idArrString[1]);

						List<String> pendingValidationListLabAll = new ArrayList<String>();
						pendingValidationListLabAll = (List<String>) session
								.getAttribute("pendingValidationListLabAll");

						if (pendingValidationListLabAll.size() > 0) {
							pendingValidationListLabAll
									.remove(resultIdStringForTemplate);
						}
						for (String combinedIdsFromList : pendingValidationListLabAll) {
							String[] idArray = new String[0];
							idArray = combinedIdsFromList.split("@");

							int subChargeIdFromList = Integer
									.parseInt(idArray[1]);
							if (subChargeIdFromList == subChargeId) {
								nextCombinedValidationIds = combinedIdsFromList;
								break;
							}
						}
					}

					map.put("nextCombinedValidationIds",
							nextCombinedValidationIds);
					map.put("template", "template");
					jsp = MESSAGE_FOR_RESULT_VALIDATION_LAB + ".jsp";
				}
			}
		}
		map.put("resultNo", resultNo);
		map.put("resultType", resultType);
		map.put("resultIdStringForTemplate", resultIdStringForTemplate);

		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitResultEntryModificationForTemplateLab(
			HttpServletRequest request, HttpServletResponse response) {
		MultipartFormDataRequest mrequest = null;
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String messageTOBeVisibleToTheUser = "";
		String url = "";
		String resultNo = "";
		String resultType = "";
		String result = "";
		String additionalRemarks = "";
		String validated = "";
		String resultIdStringForTemplate = "";

		int resultId = 0;
		int newResultId = 0;
		int resultEnteredBy = 0;
		int deptId = 0;
		try {
			if (MultipartFormDataRequest.isMultipartFormData(request)) {
				mrequest = new MultipartFormDataRequest(request);
				// result=mrequest.getParameter("test2");
				String tepmlateData = mrequest.getParameter("test2");
				InputStream fis1 = new FileInputStream(getServletContext()
						.getRealPath("jsp/pdf/appendingHtml.html"));
				File temprory2 = new File(getServletContext().getRealPath(
						"jsp/pdf/appendingHtml.html"));

				byte[] b1 = new byte[(int) temprory2.length()];
				int offset1 = 0;
				int numRead1 = 0;
				try {
					while ((offset1 < b1.length)
							&& ((numRead1 = fis1.read(b1, offset1, b1.length
									- offset1)) >= 0)) {

						offset1 += numRead1;

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fis1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String appendedHtml = new String(b1);
				String finalFile = appendedHtml + tepmlateData
						+ "</body></html>";

				byte[] bytes = finalFile.getBytes();
				result = new String(bytes);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (request.getParameter("resultNo") != null) {
			resultNo = request.getParameter("resultNo");
		}

		if (request.getParameter("resultType") != null) {
			resultType = request.getParameter("resultType");
		}
		if (request.getParameter("resultIdStringForTemplate") != null) {
			resultIdStringForTemplate = request
					.getParameter("resultIdStringForTemplate");
		}

		if (request.getParameter("resultId") != null) {
			resultId = Integer.parseInt(request.getParameter("resultId"));
		}

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("resultNo", resultNo);
		dataMap.put("deptId", deptId);
		// String templateData="";
		// if(request.getParameter("test2")!=null){
		// templateData=request.getParameter("test2");
		// }
		dataMap.put("templateData", result);
		dataMap.put("resultId", resultIdStringForTemplate);
		dataMap.put("resultIdToRemove", resultId);

		boolean flag1 = investigationHandlerService
				.updateResultTemplateForValidation(dataMap);
		Map<String, Object> patientMap = new HashMap<String, Object>();
		/*
		 * if( newResultId != 0){ map =
		 * investigationHandlerService.getResultEntryDetailsForNext
		 * (newResultId,deptId); }
		 */

		if (request.getParameter(RESULT_ENTERED_BY) != null
				&& !request.getParameter(RESULT_ENTERED_BY).equals("")) {
			resultEnteredBy = Integer.parseInt(request
					.getParameter(RESULT_ENTERED_BY));
		}
		if (request.getParameter(ADDITIONAL_REMARKS) != null
				&& !request.getParameter(ADDITIONAL_REMARKS).equals("")) {
			additionalRemarks = request.getParameter(ADDITIONAL_REMARKS);
		}
		if (request.getParameter(VALIDATED) != null
				&& !request.getParameter(VALIDATED).equals("")) {
			validated = request.getParameter(VALIDATED);
		}

		// map=investigationHandlerService.getResultList(resultId);
		infoMap.put("box", box);
		String jsp = MESSAGE_FOR_RESULT_ENTRY_CORRECTION_LAB + ".jsp";

		infoMap.put("resultId", resultId);
		infoMap.put("resultEnteredBy", resultEnteredBy);
		infoMap.put("additionalRemarks", additionalRemarks);
		infoMap.put("validated", validated);

		boolean flag = false;
		try {
			flag = investigationHandlerService
					.submitResultEntryForModificationTemplate(infoMap);
			if (flag == false) {
				messageTOBeVisibleToTheUser = "Successfully Validated the result.Do you want to print.";
			} else {
				messageTOBeVisibleToTheUser = "Some Problem occured";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!resultIdStringForTemplate.equals("")) {
			map = investigationHandlerService.getResultEntryDetailsLab(dataMap);
			map.put("resultId", resultIdStringForTemplate);
			List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
			if (map.get("resultList") != null) {
				resultList = (List<DgResultEntryHeader>) map.get("resultList");
				if (resultList.size() > 0) {
					jsp = RESULT_ENTRY_VALUES_FOR_CORRECTION_LAB + ".jsp";
				} else {
					jsp = MESSAGE_FOR_RESULT_ENTRY_CORRECTION_LAB + ".jsp";
				}
			}
		}
		map.put("resultNo", resultNo);
		map.put("resultType", resultType);
		map.put("resultIdStringForTemplate", resultIdStringForTemplate);

		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showReportCollectionJsp(HttpServletRequest request,
			HttpServletResponse response) {

		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		String deptName = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = investigationHandlerService
				.getDetailsForReportCollection(dataMap);
		patientMap = investigationHandlerService.getResultViewGrid(mapForDs);
		String jsp = REPORT_COLLECTION;
		jsp += ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		map.put("patientMap", patientMap);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForReportCollection(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		int chargeCodeId = 0;
		String pType = "";
		String serPersonFName = "";
		String patientFName = "";
		Date fromDate = new Date();
		;
		Date toDate = new Date();
		String adNo = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		int hinId = 0;
		int resultId = 0;
		String diagnosisNo = "";
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		int userId = 0;

		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		Map<String, Object> dataMap = new HashMap<String, Object>();
		mapForDs.put("deptId", deptId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("userId", userId);
		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
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
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));
				mapForDs.put("chargeCodeId", chargeCodeId);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
			}
			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				mapForDs.put("departmentId", departmentId);
			}
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(SAMPLE_ID) != null
					&& !(request.getParameter(SAMPLE_ID).equals("0"))) {
				sampleId = Integer.parseInt(request.getParameter(SAMPLE_ID));
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				orderType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("orderType", orderType);
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
			if (request.getParameter(RESULT_ID) != null
					&& !(request.getParameter(RESULT_ID).equals("0"))) {
				resultId = Integer.parseInt(request.getParameter(RESULT_ID));
				mapForDs.put("resultId", resultId);
			}
			if (request.getParameter(DIAGNOSIS_NO) != null
					&& !(request.getParameter(DIAGNOSIS_NO).equals(""))) {
				diagnosisNo = request.getParameter(DIAGNOSIS_NO);
				mapForDs.put("diagnosisNo", diagnosisNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		mapForDs.put("hospitalId", hospitalId);
		patientMap = investigationHandlerService
				.getPatientDetailsForReportCollection(mapForDs);
		String jsp = "";
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDetailsList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDetailsList");
		}
		Map<String, Object> mapForPatientDetailsDS = new HashMap<String, Object>();

		mapForPatientDetailsDS.put("resultId", resultId);
		mapForPatientDetailsDS.put("deptId", deptId);

		Map<String, Object> diagMap = new HashMap<String, Object>();
		if (resultId != 0) {
			map = investigationHandlerService
					.getResultDetails(mapForPatientDetailsDS);
			List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
			if (map.get("resultList") != null) {
				resultList = (List<DgResultEntryHeader>) map.get("resultList");
			}
			Set<DgResultEntryDetail> dgDetailSet = new HashSet<DgResultEntryDetail>();

			for (DgResultEntryHeader dgHeader : resultList) {
				dgDetailSet = dgHeader.getDgResultEntryDetails();
			}
			for (DgResultEntryDetail dgResEntry : dgDetailSet) {
				if (dgResEntry.getInvestigation().getInvestigationType()
						.equals("s")) {
					jsp = VIEW_REPORT_FOR_SINGLE_PARAMETER + ".jsp";
				} else if (dgResEntry.getInvestigation().getInvestigationType()
						.equals("m")) {
					jsp = VIEW_REPORT_COLLECTION + ".jsp";
				} else if (dgResEntry.getInvestigation().getInvestigationType()
						.equals("t")) {
					jsp = VIEW_REPORT_COLLECTION_FOR_TEMPLATE + ".jsp";
				}
			}
			List<DgResultEntryDetailSen> dgResultdetailSenList = new ArrayList<DgResultEntryDetailSen>();
			if (map.get("dgResultdetailSenList") != null) {
				dgResultdetailSenList = (List<DgResultEntryDetailSen>) map
						.get("dgResultdetailSenList");
				map.put("dgResultdetailSenList", dgResultdetailSenList);
				if (dgResultdetailSenList.size() > 0) {
					jsp = "viewReportCollectionForSen.jsp";
				}
			}
		} else {
			detailsMap = investigationHandlerService
					.getDetailsForReportCollection(dataMap);
			jsp = REPORT_COLLECTION + ".jsp";
		}
		patientMap.put("patientList", patientList);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		map.put("dataMap", dataMap);
		return new ModelAndView("index", "map", map);
	}

	// ===================== for getting file name ====================
	// ////////////////////////////////

	// changes in controller
	public ModelAndView getFileName(HttpServletRequest request,
			HttpServletResponse response) {
		String uploadURL = "";
		MultipartFormDataRequest mrequest = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if ((Map) request.getSession().getAttribute("map") != null)
				map = (Map) request.getSession().getAttribute("map");
		} catch (Exception e) {
			e.printStackTrace();

		}

		String filePath = "";
		String fileContent = "";
		UploadFile file = null;
		InputStream is = null;
		String Format = "";
		Properties properties = new Properties();
		FileOutputStream fos = null;
		ModelAndView mv1 = null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("file.properties");

		try {
			properties.load(resourcePath.openStream());
			uploadURL = properties.getProperty("uploadinvestigationfile");
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			new File(getServletContext().getRealPath("/temp/")).mkdir();
			if (MultipartFormDataRequest.isMultipartFormData(request)) {
				try {
					if (request.getParameter("browse") != null
							&& !request.getParameter("browse").equals("")) {
						map.put("browse", "browse");
					}
					if (request.getParameter("browseInResultEntry") != null
							&& !request.getParameter("browseInResultEntry")
									.equals("")) {
						session.setAttribute("browseInResultEntry",
								"browseInResultEntry");
						map.put("browse", "browse");
					}

					mrequest = new MultipartFormDataRequest(request);
					String temlateData = "";

					if (mrequest.getParameter("test2") != null
							&& !(mrequest.getParameter("test2").equals(""))) {
						temlateData = (mrequest.getParameter("test2")).trim();
						// code added for persisting the removed html code by
						// wysiwyg

						fos = new FileOutputStream(getServletContext()
								.getRealPath("/temp/" + "temp.html"));
						fos.write(temlateData.getBytes());
						fos.close();
						request.setAttribute("secondRequest", "secondRequest");
						if (request.getParameter("formName") != null) {

							if (request.getParameter("formName").equals(
									"sampleCollection")) {
								mv1 = searchPatient(request, response);
							} else {
								mv1 = searchPatientForResultValidation(request,
										response);
							}

						}

					}

					java.util.Hashtable files = mrequest.getFiles();

					if ((files != null) && (!files.isEmpty())) {
						file = (UploadFile) files.get(UPLOAD_FILENAME);

						// file.setContentType("text/html");
						try {
							is = file.getInpuStream();
						} catch (Exception e) {
							e.printStackTrace();
						}
						if (is != null) {
							File temprory = new File(getServletContext()
									.getRealPath("/temp/" + "temp.html"));

							fos = new FileOutputStream(temprory);
							byte[] buf = new byte[1024];
							int len;

							while ((len = is.read(buf)) > 0) {

								fos.write(buf, 0, len);

							}
							fos.close();
							is.close();
							// code for parseing html contents from the file
							File temprory1 = new File(getServletContext()
									.getRealPath("/temp/" + "temp.html"));
							InputStream fis = new FileInputStream(
									getServletContext().getRealPath(
											"/temp/" + "temp.html"));

							byte[] b3 = new byte[(int) temprory1.length()];
							int offset = 0;
							int numRead = 0;
							while ((offset < b3.length)
									&& ((numRead = fis.read(b3, offset,
											b3.length - offset)) >= 0)) {

								offset += numRead;

							}
							fis.close();

							// String appendedHtml=new String(b3);
							// //System.out.println("appendedHtml at file upload "+b3.length);
							// if(appendedHtml.contains("<div class=")){
							// //System.out.println("multipart data 2.5 ");
							// int index=appendedHtml.indexOf("<div class=");
							// appendedHtml=appendedHtml.substring(0, index);
							//						    	
							// map.put("appendedHtml", appendedHtml);
							//						    	 
							// }
							InputStream fis1 = new FileInputStream(
									getServletContext().getRealPath(
											"jsp/pdf/appendingHtml.html"));
							File temprory2 = new File(getServletContext()
									.getRealPath("jsp/pdf/appendingHtml.html"));

							byte[] b1 = new byte[(int) temprory2.length()];
							int offset1 = 0;
							int numRead1 = 0;
							try {
								while ((offset1 < b1.length)
										&& ((numRead1 = fis1.read(b1, offset1,
												b1.length - offset1)) >= 0)) {

									offset1 += numRead1;

								}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								fis1.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							String appendedHtml = new String(b1);
							map.put("appendedHtml", appendedHtml);
							is.close();

							if (request.getParameter("parameterName") != null) {
								mv1 = searchPatient(request, response);
							}
							fileContent = HMSUtil
									.getContent(getServletContext()
											.getRealPath("/temp/" + "temp.html"));

							// //System.out.println("fileContent
							// "+fileContent.length());

						} else {
							String parser = MultipartFormDataRequest.DEFAULTPARSER;
							Vector listeners = null;
							String encoding = "iso-8859-1";
							int uploadlimit = 1024 * 1024 * 1024;

							//System.out.println("multipartData");
							// try{
							// mrequest = new
							// MultipartFormDataRequest(request,listeners,
							// uploadlimit,parser, encoding);
							// }
							// catch(Exception e){
							// e.printStackTrace();
							// }
							String template = (mrequest.getParameter("test2"))
									.trim();

							fos = new FileOutputStream(getServletContext()
									.getRealPath("/temp/" + "temp.html"));
							fos.write(template.getBytes());
							fos.close();

						}

					}
					// else
					// {
					//				
					//				
					// //System.out.println("in lasdt else");
					// String parser = MultipartFormDataRequest.DEFAULTPARSER;
					// Vector listeners = null;
					// String encoding = "iso-8859-1";
					// int uploadlimit = 1024*1024*1024;
					//				
					// ////System.out.println("multipartData");
					// try{//MultipartRequest mr = new
					// MultipartRequest(request,getServletContext().getRealPath("/temp/"));
					// mrequest = new MultipartFormDataRequest(request);
					// }
					// catch(Exception e){
					// e.printStackTrace();
					//					
					// }
					// String template=mrequest.getParameter("test2");
					//				
					// ////System.out.println("multipartData.length()"+template);
					// FileOutputStream fos=new
					// FileOutputStream(getServletContext().getRealPath("/temp/"+"temp.html"));
					// fos.write( template.getBytes());
					//				
					//			    
					//				
					// }
				}

				catch (Exception e) {
					e.printStackTrace();
				}
			}

			fileContent = HMSUtil.getContent(getServletContext().getRealPath(
					"/temp/" + "temp.html"));


			map.put("content", fileContent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ///////////////////////// Finally added By Naresh
		finally {
			try {
				if (is != null) {
					is.close();
				}
				if (fos != null)
					fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// ///////////////////////////////////////
		// code added for persisting the removed html code by wysiwyg
		String appendedHtml1 = "";
		boolean flag = false;

		if (mrequest.getParameter("appendedHtml") != null
				&& !mrequest.getParameter("appendedHtml").equals("")) {
			if (mrequest.getParameter("browse").equals("")) {
				appendedHtml1 = mrequest.getParameter("appendedHtml");

				String template = mrequest.getParameter("test2");
				if (appendedHtml1 != null && !appendedHtml1.equals("")) {
					map.put("appendedHtml", appendedHtml1);
					try {
						fos = new FileOutputStream(getServletContext()
								.getRealPath("/temp/" + "temp.html"));
						template = appendedHtml1 + template + "</body></html>";

						fos.write(template.getBytes());
						fos.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		if (mv1 != null && request.getParameter("formName") != null) {
			return mv1;
		} else {
			return new ModelAndView("index", "map", map);
		}
	}

	// //////////////////////////////////////////////////
	public ModelAndView getFileNameForLab(HttpServletRequest request,
			HttpServletResponse response) {
		String uploadURL = "";
		MultipartFormDataRequest mrequest = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if ((Map) request.getSession().getAttribute("map") != null)
				map = (Map) request.getSession().getAttribute("map");
		} catch (Exception e) {
			e.printStackTrace();

		}

		String filePath = "";
		String fileContent = "";
		UploadFile file = null;
		InputStream is = null;
		String Format = "";
		Properties properties = new Properties();
		FileOutputStream fos = null;
		ModelAndView mv1 = null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("file.properties");

		try {
			properties.load(resourcePath.openStream());
			uploadURL = properties.getProperty("uploadinvestigationfile");
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			new File(getServletContext().getRealPath("/temp/")).mkdir();
			if (MultipartFormDataRequest.isMultipartFormData(request)) {
				try {
					if (request.getParameter("browse") != null
							&& !request.getParameter("browse").equals("")) {
						map.put("browse", "browse");
					}
					if (request.getParameter("browseInResultEntry") != null
							&& !request.getParameter("browseInResultEntry")
									.equals("")) {
						session.setAttribute("browseInResultEntry",
								"browseInResultEntry");
						map.put("browse", "browse");
					}

					mrequest = new MultipartFormDataRequest(request);
					String temlateData = "";

					if (mrequest.getParameter("test2") != null
							&& !(mrequest.getParameter("test2").equals(""))) {
						temlateData = (mrequest.getParameter("test2")).trim();
						// code added for persisting the removed html code by
						// wysiwyg

						fos = new FileOutputStream(getServletContext()
								.getRealPath("/temp/" + "temp.html"));
						fos.write(temlateData.getBytes());
						fos.close();
						request.setAttribute("secondRequest", "secondRequest");
						if (request.getParameter("formName") != null) {

							if (request.getParameter("formName").equals(
									"sampleCollection")) {
								mv1 = searchForTemplateDetailsLab(request,
										response);
							} else {
								mv1 = searchPatientForResultValidation(request,
										response);
							}

						}

					}

					java.util.Hashtable files = mrequest.getFiles();

					if ((files != null) && (!files.isEmpty())) {
						file = (UploadFile) files.get(UPLOAD_FILENAME);

						// file.setContentType("text/html");
						try {
							is = file.getInpuStream();
						} catch (Exception e) {
							e.printStackTrace();
						}
						if (is != null) {
							File temprory = new File(getServletContext()
									.getRealPath("/temp/" + "temp.html"));

							fos = new FileOutputStream(temprory);
							byte[] buf = new byte[1024];
							int len;

							while ((len = is.read(buf)) > 0) {

								fos.write(buf, 0, len);

							}
							fos.close();
							is.close();
							// code for parseing html contents from the file
							File temprory1 = new File(getServletContext()
									.getRealPath("/temp/" + "temp.html"));
							InputStream fis = new FileInputStream(
									getServletContext().getRealPath(
											"/temp/" + "temp.html"));

							byte[] b3 = new byte[(int) temprory1.length()];
							int offset = 0;
							int numRead = 0;
							while ((offset < b3.length)
									&& ((numRead = fis.read(b3, offset,
											b3.length - offset)) >= 0)) {

								offset += numRead;

							}
							fis.close();

							// String appendedHtml=new String(b3);
							// //System.out.println("appendedHtml at file upload "+b3.length);
							// if(appendedHtml.contains("<div class=")){
							// //System.out.println("multipart data 2.5 ");
							// int index=appendedHtml.indexOf("<div class=");
							// appendedHtml=appendedHtml.substring(0, index);
							//						    	
							// map.put("appendedHtml", appendedHtml);
							//						    	 
							// }
							InputStream fis1 = new FileInputStream(
									getServletContext().getRealPath(
											"jsp/pdf/appendingHtml.html"));
							File temprory2 = new File(getServletContext()
									.getRealPath("jsp/pdf/appendingHtml.html"));

							byte[] b1 = new byte[(int) temprory2.length()];
							int offset1 = 0;
							int numRead1 = 0;
							try {
								while ((offset1 < b1.length)
										&& ((numRead1 = fis1.read(b1, offset1,
												b1.length - offset1)) >= 0)) {

									offset1 += numRead1;

								}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								fis1.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							String appendedHtml = new String(b1);
							map.put("appendedHtml", appendedHtml);
							is.close();

							if (request.getParameter("parameterName") != null) {
								String parameterValue = request
										.getParameter("parameterName");
								if (parameterValue
										.equalsIgnoreCase("fromResultEntry")) {
									mv1 = searchForTemplateDetailsLab(request,
											response);
								} else {
									mv1 = searchPatient(request, response);
								}
							}
							fileContent = HMSUtil
									.getContent(getServletContext()
											.getRealPath("/temp/" + "temp.html"));


						} else {
							String parser = MultipartFormDataRequest.DEFAULTPARSER;
							Vector listeners = null;
							String encoding = "iso-8859-1";
							int uploadlimit = 1024 * 1024 * 1024;

							//System.out.println("multipartData");
							// try{
							// mrequest = new
							// MultipartFormDataRequest(request,listeners,
							// uploadlimit,parser, encoding);
							// }
							// catch(Exception e){
							// e.printStackTrace();
							// }
							String template = (mrequest.getParameter("test2"))
									.trim();

							fos = new FileOutputStream(getServletContext()
									.getRealPath("/temp/" + "temp.html"));
							fos.write(template.getBytes());
							fos.close();

						}

					}
					// else
					// {
					//				
					//				
					// //System.out.println("in lasdt else");
					// String parser = MultipartFormDataRequest.DEFAULTPARSER;
					// Vector listeners = null;
					// String encoding = "iso-8859-1";
					// int uploadlimit = 1024*1024*1024;
					//				
					// ////System.out.println("multipartData");
					// try{//MultipartRequest mr = new
					// MultipartRequest(request,getServletContext().getRealPath("/temp/"));
					// mrequest = new MultipartFormDataRequest(request);
					// }
					// catch(Exception e){
					// e.printStackTrace();
					//					
					// }
					// String template=mrequest.getParameter("test2");
					//				
					// ////System.out.println("multipartData.length()"+template);
					// FileOutputStream fos=new
					// FileOutputStream(getServletContext().getRealPath("/temp/"+"temp.html"));
					// fos.write( template.getBytes());
					//				
					//			    
					//				
					// }
				}

				catch (Exception e) {
					e.printStackTrace();
				}
			}

			fileContent = HMSUtil.getContent(getServletContext().getRealPath(
					"/temp/" + "temp.html"));

			map.put("content", fileContent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ///////////////////////// Finally added By Naresh
		finally {
			try {
				if (is != null) {
					is.close();
				}
				if (fos != null)
					fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// ///////////////////////////////////////
		// code added for persisting the removed html code by wysiwyg
		String appendedHtml1 = "";
		boolean flag = false;

		if (mrequest.getParameter("appendedHtml") != null
				&& !mrequest.getParameter("appendedHtml").equals("")) {
			if (mrequest.getParameter("browse").equals("")) {
				appendedHtml1 = mrequest.getParameter("appendedHtml");

				String template = mrequest.getParameter("test2");
				if (appendedHtml1 != null && !appendedHtml1.equals("")) {
					map.put("appendedHtml", appendedHtml1);
					try {
						fos = new FileOutputStream(getServletContext()
								.getRealPath("/temp/" + "temp.html"));
						template = appendedHtml1 + template + "</body></html>";

						fos.write(template.getBytes());
						fos.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		if (mv1 != null && request.getParameter("formName") != null) {
			return mv1;
		} else {
			return new ModelAndView("index", "map", map);
		}
	}

	// /////////////////////////////////////////////////
	// /////////////////////////////////
	// ===================== for getting file name ====================
	// ////////////////////////////////

	// changes in controller
	public ModelAndView getFileNameForController(HttpServletRequest request,
			HttpServletResponse response) {
		String uploadURL = "";
		MultipartFormDataRequest mrequest = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if ((Map) request.getSession().getAttribute("map") != null)
				map = (Map) request.getSession().getAttribute("map");
		} catch (Exception e) {
			e.printStackTrace();
		}

		String filePath = "";
		String fileContent = "";
		UploadFile file = null;
		InputStream is = null;
		String Format = "";
		Properties properties = new Properties();
		FileOutputStream fos = null;
		ModelAndView mv1 = null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("file.properties");

		try {
			properties.load(resourcePath.openStream());
			uploadURL = properties.getProperty("uploadinvestigationfile");
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			new File(getServletContext().getRealPath("/temp/")).mkdir();
			if (MultipartFormDataRequest.isMultipartFormData(request)) {
				try {
					mrequest = new MultipartFormDataRequest(request);
					String temlateData = "";
					if (mrequest.getParameter("test2") != null
							&& !(mrequest.getParameter("test2").equals(""))) {
						temlateData = (mrequest.getParameter("test2")).trim();
						// code added for persisting the removed html code by
						// wysiwyg
						fos = new FileOutputStream(getServletContext()
								.getRealPath("/temp/" + "temp.html"));
						fos.write(temlateData.getBytes());
						fos.close();
						request.setAttribute("secondRequest", "secondRequest");
						if (request.getParameter("formName") != null) {
							if (request.getParameter("formName").equals(
									"sampleCollection")) {
								mv1 = searchPatient(request, response);
							} else {
								mv1 = searchPatientForResultValidation(request,
										response);
							}
						}
					}
					java.util.Hashtable files = mrequest.getFiles();
					if ((files != null) && (!files.isEmpty())) {
						file = (UploadFile) files.get(UPLOAD_FILENAME);
						try {
							is = file.getInpuStream();
						} catch (Exception e) {
							e.printStackTrace();
						}
						if (is != null) {
							File temprory = new File(getServletContext()
									.getRealPath("/temp/" + "temp.html"));
							fos = new FileOutputStream(temprory);
							byte[] buf = new byte[1024];
							int len;
							while ((len = is.read(buf)) > 0) {
								fos.write(buf, 0, len);
							}
							fos.close();
							is.close();
							// code for parseing html contents from the file
							File temprory1 = new File(getServletContext()
									.getRealPath("/temp/" + "temp.html"));
							InputStream fis = new FileInputStream(
									getServletContext().getRealPath(
											"/temp/" + "temp.html"));
							byte[] b3 = new byte[(int) temprory1.length()];
							int offset = 0;
							int numRead = 0;
							while ((offset < b3.length)
									&& ((numRead = fis.read(b3, offset,
											b3.length - offset)) >= 0)) {
								offset += numRead;
							}
							fis.close();
							InputStream fis1 = new FileInputStream(
									getServletContext().getRealPath(
											"jsp/pdf/appendingHtml.html"));
							File temprory2 = new File(getServletContext()
									.getRealPath("jsp/pdf/appendingHtml.html"));
							byte[] b1 = new byte[(int) temprory2.length()];
							int offset1 = 0;
							int numRead1 = 0;
							try {
								while ((offset1 < b1.length)
										&& ((numRead1 = fis1.read(b1, offset1,
												b1.length - offset1)) >= 0)) {
									offset1 += numRead1;
								}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								fis1.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							String appendedHtml = new String(b1);
							map.put("appendedHtml", appendedHtml);
							is.close();
							if (request.getParameter("parameterName") != null) {
								mv1 = searchPatient(request, response);
							}
							fileContent = HMSUtil
									.getContent(getServletContext()
											.getRealPath("/temp/" + "temp.html"));
							// //System.out.println("fileContent
							// "+fileContent.length());
						} else {
							String parser = MultipartFormDataRequest.DEFAULTPARSER;
							Vector listeners = null;
							String encoding = "iso-8859-1";
							int uploadlimit = 1024 * 1024 * 1024;
							// try{
							// mrequest = new
							// MultipartFormDataRequest(request,listeners,
							// uploadlimit,parser, encoding);
							// }
							// catch(Exception e){
							// e.printStackTrace();
							// }
							String template = (mrequest.getParameter("test2"))
									.trim();

							fos = new FileOutputStream(getServletContext()
									.getRealPath("/temp/" + "temp.html"));
							fos.write(template.getBytes());
							fos.close();
						}

					}
					// else
					// {
					//
					//
					// //System.out.println("in lasdt else");
					// String parser = MultipartFormDataRequest.DEFAULTPARSER;
					// Vector listeners = null;
					// String encoding = "iso-8859-1";
					// int uploadlimit = 1024*1024*1024;
					//
					// ////System.out.println("multipartData");
					// try{//MultipartRequest mr = new
					// MultipartRequest(request,getServletContext().getRealPath("/temp/"));
					// mrequest = new MultipartFormDataRequest(request);
					// }
					// catch(Exception e){
					// e.printStackTrace();
					//
					// }
					// String template=mrequest.getParameter("test2");
					//
					// ////System.out.println("multipartData.length()"+template);
					// FileOutputStream fos=new
					// FileOutputStream(getServletContext().getRealPath("/temp/"+"temp.html"));
					// fos.write( template.getBytes());
					//
					//
					//
					// }
				}

				catch (Exception e) {
					e.printStackTrace();
				}
			}

			fileContent = HMSUtil.getContent(getServletContext().getRealPath(
					"/temp/" + "temp.html"));

			map.put("content", fileContent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ///////////////////////// Finally added By Naresh
		finally {
			try {
				if (is != null) {
					is.close();
				}
				if (fos != null)
					fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// ///////////////////////////////////////
		// code added for persisting the removed html code by wysiwyg
		String appendedHtml1 = "";
		boolean flag = false;

		if (mrequest.getParameter("appendedHtml") != null
				&& !mrequest.getParameter("appendedHtml").equals("")) {
			if (mrequest.getParameter("browse").equals("")) {
				appendedHtml1 = mrequest.getParameter("appendedHtml");

				String template = mrequest.getParameter("test2");
				if (appendedHtml1 != null && !appendedHtml1.equals("")) {
					map.put("appendedHtml", appendedHtml1);
					try {
						fos = new FileOutputStream(getServletContext()
								.getRealPath("/temp/" + "temp.html"));
						template = appendedHtml1 + template + "</body></html>";

						fos.write(template.getBytes());
						fos.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		if (mv1 != null && request.getParameter("formName") != null) {
			return mv1;
		} else {
			return new ModelAndView("index", "map", map);
		}
	}

	// /////////////////////////////////
	public ModelAndView saveIncrementlyTemplate(HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException,
			IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		String updatedTemplate = request.getParameter("test2");

		// File template=new
		// File(getServletContext().getRealPath("/temp/"+"temp.html"));
		FileOutputStream fos = new FileOutputStream(getServletContext()
				.getRealPath("/temp/" + "temp.html"));
		fos.write(updatedTemplate.getBytes());
		return null;
	}

	public ModelAndView showPrintResultEntry(HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException,
			IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		String resultNo = "";
		String resultType = "";
		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		int userId = 0;
		String deptName = "";
		try {

			if (session.getAttribute("hospitalId") != null)
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			if (session.getAttribute("deptId") != null)
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			if (session.getAttribute("deptName") != null)
				deptName = (String) session.getAttribute("deptName");
			if (session.getAttribute("userId") != null)
				userId = Integer.parseInt("" + session.getAttribute("userId"));
			if (request.getParameter(RESULT_NO) != null) {
				resultNo = request.getParameter(RESULT_NO);
			}
			if (request.getParameter(RESULT_TYPE) != null) {
				resultType = request.getParameter(RESULT_TYPE);
			}
			Map<String, Object> detailsMap1 = new HashMap<String, Object>();
			List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();

			detailsMap1 = investigationHandlerService
					.getResultEntryDetailsForTemplate(resultNo, deptId);
			dgResultdetailList = (List<DgResultEntryDetail>) detailsMap1
					.get("resultList");
			map.put("dgResultdetailList", dgResultdetailList);
			map.put("detailsMap1", detailsMap1);
			map.put("deptName", deptName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("resultEntryPrint", "map", map);

	}

	public ModelAndView printProvisionalResultEntry(HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException,
			IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		String resultNo = "";
		String resultType = "";
		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		int userId = 0;
		String deptName = "";
		int resultIdForReport = 0;
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		try {

			if (session.getAttribute("hospitalId") != null)
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			if (session.getAttribute("deptId") != null)
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			if (session.getAttribute("deptName") != null)
				deptName = (String) session.getAttribute("deptName");
			if (session.getAttribute("userId") != null)
				userId = Integer.parseInt("" + session.getAttribute("userId"));
			if (request.getParameter(RESULT_NO) != null) {
				resultNo = request.getParameter(RESULT_NO);
			}
			if (request.getParameter(RESULT_TYPE) != null) {
				resultType = request.getParameter(RESULT_TYPE);
			}
			if (request.getParameter("resultIdForReport") != null
					&& !request.getParameter("resultIdForReport").equals("")) {
				resultIdForReport = Integer.parseInt(request
						.getParameter("resultIdForReport"));

				mapForDs.put("resultIdForReport", resultIdForReport);
			}

			Map<String, Object> detailsMap1 = new HashMap<String, Object>();
			List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();

			detailsMap1 = investigationHandlerService
					.getProvisionalResultEntryDetailsForTemplate(
							resultIdForReport, deptId);
			dgResultdetailList = (List<DgResultEntryDetail>) detailsMap1
					.get("resultList");
			map.put("dgResultdetailList", dgResultdetailList);
			map.put("detailsMap1", detailsMap1);
			map.put("deptName", deptName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("resultEntryPrint", "map", map);

	}

	public ModelAndView showPrintResultValidation(HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException,
			IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		String resultNo = "";
		String resultType = "";
		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		int userId = 0;
		String deptName = "";
		try {

			if (session.getAttribute("hospitalId") != null)
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			if (session.getAttribute("deptId") != null)
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			if (session.getAttribute("deptName") != null)
				deptName = (String) session.getAttribute("deptName");
			if (session.getAttribute("userId") != null)
				userId = Integer.parseInt("" + session.getAttribute("userId"));
			if (request.getParameter(RESULT_NO) != null) {
				resultNo = request.getParameter(RESULT_NO);
			}
			if (request.getParameter(RESULT_TYPE) != null) {
				resultType = request.getParameter(RESULT_TYPE);
			}
			Map<String, Object> detailsMap1 = new HashMap<String, Object>();
			List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();

			detailsMap1 = investigationHandlerService
					.getResultEntryDetailsForTemplate(resultNo, deptId);
			dgResultdetailList = (List<DgResultEntryDetail>) detailsMap1
					.get("resultList");
			map.put("dgResultdetailList", dgResultdetailList);
			map.put("detailsMap1", detailsMap1);
			map.put("deptName", deptName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("resultValidationPrint", "map", map);
	}

	public ModelAndView showPrintResultValidationLab(
			HttpServletRequest request, HttpServletResponse response)
			throws IllegalStateException, IOException {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap1 = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		Map<String, Object> resultDetailsMap = new HashMap<String, Object>();
		List<Map<String, Object>> resultDetailsMapList = new ArrayList<Map<String, Object>>();

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}

		HttpSession session = request.getSession();
		String[] idsArray = new String[0];
		String deptName = "";
		String jsp = "";
		String combinedIds = "";
		int deptId = 0;
		String resultId = "";
		Integer dgSampleHeaderId = 0;
		Integer subChargeId = 0;

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (request.getParameter("resultIdStringForTemplate") != null) {
			resultId = request.getParameter("resultIdStringForTemplate");
			requestParameters.put("resultId", resultId);
		}

		detailsMap1 = investigationHandlerService
				.getDetailsForFinalReportByOrderNoLab(requestParameters);

		detailsMap1.put("flagForConfidential", "y");
		map.put("detailsMap1", detailsMap1);
		map.put("deptName", deptName);
		return new ModelAndView(VIEW_RESULT_VALIDATION_PRINT_BY_ORDER_NO_LAB,
				"map", map);
	}

	public ModelAndView showPrintResultModificationLab(
			HttpServletRequest request, HttpServletResponse response)
			throws IllegalStateException, IOException {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap1 = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		Map<String, Object> resultDetailsMap = new HashMap<String, Object>();
		List<Map<String, Object>> resultDetailsMapList = new ArrayList<Map<String, Object>>();

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}

		HttpSession session = request.getSession();
		String[] idsArray = new String[0];
		String deptName = "";
		String jsp = "";
		String combinedIds = "";
		int deptId = 0;
		String resultId = "";
		Integer dgSampleHeaderId = 0;
		Integer subChargeId = 0;

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (request.getParameter("resultIdStringForTemplate") != null) {
			resultId = request.getParameter("resultIdStringForTemplate");
			requestParameters.put("resultId", resultId);
		}

		requestParameters.put("resultStatusRequired", "P");
		detailsMap1 = investigationHandlerService
				.getDetailsForFinalReportByOrderNoLab(requestParameters);
		/*
		 * dgResultdetailList=(List<DgResultEntryDetail>)detailsMap1.get("resultList"
		 * ); List<DgResultEntryHeader> dgMultipleResultdetailList = new
		 * ArrayList<DgResultEntryHeader>();
		 * if(detailsMap1.get("dgMultipleResultdetailList") != null){
		 * dgMultipleResultdetailList =
		 * (List)detailsMap1.get("dgMultipleResultdetailList");
		 * for(DgResultEntryHeader dgResultEntryHeader :
		 * dgMultipleResultdetailList){ resultDetailsMap =
		 * investigationHandlerService
		 * .getResultEntryDetailsForMultipleResultType
		 * (dgResultEntryHeader.getId(), deptId);
		 * resultDetailsMapList.add(resultDetailsMap); }
		 * map.put("resultDetailsMapList", resultDetailsMapList); }
		 * map.put("dgResultdetailList",dgResultdetailList);
		 */
		detailsMap1.put("flagForConfidential", "y");
		map.put("detailsMap1", detailsMap1);
		map.put("deptName", deptName);
		return new ModelAndView(VIEW_RESULT_ENTRY_PRINT_LAB, "map", map);
	}

	// ============== submit result entry for tempelate
	// ==============================================================
	/** start of method of submit result entry for template **/
	public ModelAndView submitResultEntryForTempelate(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		boolean saved = false;
		int hospitalId = 0;
		String userName = "";
		MultipartFormDataRequest mrequest = null;
		String result = "";
		Box box = HMSUtil.getBox(request);
		String jsp = "";
		String messageTOBeVisibleToTheUser = "";
		String resultNo = "";
		HttpSession session = request.getSession();
		int sampleCollectionId = 0;
		int newSampleCollectionId = 0;
		String resultType = "";
		int deptId = 0;
		byte[] bytes = null;
		try {

			if (MultipartFormDataRequest.isMultipartFormData(request)) {
				try {

					mrequest = new MultipartFormDataRequest(request);
					if (mrequest.getParameter("test2") != null) {
						String tepmlateData = mrequest.getParameter("test2");
						InputStream fis1 = new FileInputStream(
								getServletContext().getRealPath(
										"jsp/pdf/appendingHtml.html"));
						File temprory2 = new File(getServletContext()
								.getRealPath("jsp/pdf/appendingHtml.html"));

						byte[] b1 = new byte[(int) temprory2.length()];
						int offset1 = 0;
						int numRead1 = 0;
						try {
							while ((offset1 < b1.length)
									&& ((numRead1 = fis1.read(b1, offset1,
											b1.length - offset1)) >= 0)) {

								offset1 += numRead1;

							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							fis1.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						String appendedHtml = new String(b1);
						String finalFile = appendedHtml + tepmlateData
								+ "</body></html>";

						bytes = finalFile.getBytes();
						result = new String(bytes);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (session.getAttribute("deptId") != null)
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));

			sampleCollectionId = box.getInt(DG_SAMPLE_DETAIL_ID);
			// Integer.parseInt(request.getParameter(DG_SAMPLE_DETAIL_ID));
			List<DgSampleCollectionDetails> patientList = new ArrayList<DgSampleCollectionDetails>();

			String reportEnteredFinally = "";

			if (request.getParameter("reportEnteredFinally") != null) {
				reportEnteredFinally = request
						.getParameter("reportEnteredFinally");
			}
			if (reportEnteredFinally != null
					&& reportEnteredFinally.equals("true")) {
				patientList = (List<DgSampleCollectionDetails>) session
						.getAttribute("patientList");

				if (patientList.size() > 0) {
					for (Iterator iterator = patientList.iterator(); iterator
							.hasNext();) {
						DgSampleCollectionDetails dgSampleDetail = (DgSampleCollectionDetails) iterator
								.next();
						newSampleCollectionId = dgSampleDetail.getId();
						if (newSampleCollectionId == sampleCollectionId) {
							iterator.remove();
						}
					}

				}
			}

			Map<String, Object> patientMap = new HashMap<String, Object>();
			if (newSampleCollectionId != 0) {
				map = investigationHandlerService.getResultEntryForNext(
						newSampleCollectionId, deptId);
			}
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				parameterMap.put("hospitalId", hospitalId);
			}
			if (session.getAttribute(LOGIN_NAME) != null) {
				userName = (String) session.getAttribute(LOGIN_NAME);
				parameterMap.put("userName", userName);
			}
			if (request.getParameter(RESULT_NO) != null) {
				resultNo = request.getParameter(RESULT_NO);
			}
			String filmSizeUsed = "";
			if (request.getParameter("filmSizeUsed") != null
					&& request.getParameter("filmSizeUsed") != "") {
				filmSizeUsed = request.getParameter("filmSizeUsed");
			}
			int filmUsed = 0;
			if (request.getParameter("filmUsed") != null
					&& !request.getParameter("filmUsed").equals("")) {
				filmUsed = new Integer(request.getParameter("filmUsed"));
			}

			String remarks = "";
			if (request.getParameter(REMARKS) != null) {
				remarks = request.getParameter(REMARKS);
			}

			int subchargeId = 0;
			int mainChargeId = 0;

			int hinId = 0;
			int investigationId = 0;
			int inpatientId = 0;
			int employeeId = 0;
			int resultEnteredId = 0;
			int departId = 0;
			if (request.getParameter(MAIN_CHARGECODE_ID) != null) {
				mainChargeId = Integer.valueOf(request
						.getParameter(MAIN_CHARGECODE_ID));
			}
			if (request.getParameter(DEPARTMENT_ID) != null) {
				departId = Integer.valueOf(request.getParameter(DEPARTMENT_ID));
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null) {
				subchargeId = Integer.valueOf(request
						.getParameter(SUB_CHARGECODE_ID));
			}
			if (request.getParameter(HIN_ID) != null) {
				hinId = Integer.valueOf(request.getParameter(HIN_ID));
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals(""))) {
				inpatientId = Integer.valueOf(request
						.getParameter(INPATIENT_ID));
			}
			if (request.getParameter(SAMPLE_COLLECTION_ID) != null) {
				sampleCollectionId = Integer.valueOf(request
						.getParameter(SAMPLE_COLLECTION_ID));
			}
			if (request.getParameter(EMPLOYEE_ID) != null
					&& !("").equals(request.getParameter(EMPLOYEE_ID))) {
				employeeId = Integer.valueOf(request.getParameter(EMPLOYEE_ID));

			}
			if (!(request.getParameter(RESULT_ENTERED_BY).equals(""))
					&& request.getParameter(RESULT_ENTERED_BY) != null) {
				resultEnteredId = Integer.valueOf(request
						.getParameter(RESULT_ENTERED_BY));
			}
			if (request.getParameter(INVESTIGATION_ID) != null
					&& (!request.getParameter(INVESTIGATION_ID).equals("0"))) {
				investigationId = Integer.parseInt(request
						.getParameter(INVESTIGATION_ID));
			}

			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTimeWithoutSc");
			Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
			DgResultEntryHeader dgResultEntryHeader = new DgResultEntryHeader();
			dgResultEntryHeader.setResultNo(resultNo);
			dgResultEntryHeader.setLastChgdBy(userName);
			dgResultEntryHeader.setLastChgdDate(date);
			dgResultEntryHeader.setLastChgdTime(time);
			dgResultEntryHeader.setRemarks(remarks);
			dgResultEntryHeader.setResultDate(date);
			if (reportEnteredFinally != null
					&& reportEnteredFinally.equals("true")) {
				dgResultEntryHeader.setResultStatus("P");
			} else {
				dgResultEntryHeader.setResultStatus("W");
			}
			// dgResultEntryHeader.setResultStatus("P");
			dgResultEntryHeader.setResultTime(time);

			MasMainChargecode masMainChargecode = new MasMainChargecode();
			masMainChargecode.setId(mainChargeId);
			dgResultEntryHeader.setMainChargecode(masMainChargecode);

			MasSubChargecode masSubChargecode = new MasSubChargecode();
			masSubChargecode.setId(subchargeId);
			dgResultEntryHeader.setSubChargecode(masSubChargecode);

			DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();
			dgSampleCollectionHeader.setId(sampleCollectionId);
			dgResultEntryHeader
					.setSampleCollectionHeader(dgSampleCollectionHeader);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departId);
			dgResultEntryHeader.setDepartment(masDepartment);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			dgResultEntryHeader.setMasHospital(masHospital);
			Patient patient = new Patient();
			patient.setId(hinId);
			dgResultEntryHeader.setPatient(patient);
			if (inpatientId != 0) {
				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				dgResultEntryHeader.setInpatient(inpatient);
			}
			if (employeeId != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(employeeId);
				dgResultEntryHeader.setEmployee(masEmployee);
			}
			if (resultEnteredId != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(resultEnteredId);
				dgResultEntryHeader.setEmployee(masEmployee);
			}
			if (investigationId != 0) {
				DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
				dgMasInvestigation.setId(investigationId);
				dgResultEntryHeader.setDgMasInvestigation(dgMasInvestigation);
			}
			parameterMap.put("dgResultEntryHeader", dgResultEntryHeader);
			// result = "";
			String additionalRemarks = "";
			int sample_Id = 0;

			int uomId = 0;
			// resultType= "";
			int sampleDetailId = 0;

			if (request.getParameter(RESULT_TYPE) != null) {
				resultType = request.getParameter(RESULT_TYPE);
			}

			// if (request.getParameter("test2") != null)
			// {
			// result = request.getParameter("test2");

			// }
			if (request.getParameter(ADDITIONAL_REMARKS) != null) {
				additionalRemarks = request.getParameter(ADDITIONAL_REMARKS);
			}

			if (request.getParameter(DG_SAMPLE_DETAIL_ID) != null
					&& (!request.getParameter(DG_SAMPLE_DETAIL_ID).equals(""))) {
				sampleDetailId = Integer.parseInt(request
						.getParameter(DG_SAMPLE_DETAIL_ID));
			}
			DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
			if (investigationId != 0) {
				if (investigationId != 0) {
					DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
					dgMasInvestigation.setId(investigationId);
					dgResultEntryDetail.setInvestigation(dgMasInvestigation);
				}
				if (investigationId != 0) {
					MasChargeCode masChargeCode = new MasChargeCode();
					masChargeCode.setId(investigationId);
					dgResultEntryDetail.setChargeCode(masChargeCode);
				}
				if (sampleDetailId != 0) {
					DgSampleCollectionDetails dgSample = new DgSampleCollectionDetails();
					dgSample.setId(sampleDetailId);
					dgResultEntryDetail.setSampleCollectionDetails(dgSample);
				}
System.out.println("result="+result);
				dgResultEntryDetail.setResult(result);
				dgResultEntryDetail.setResultEntry(dgResultEntryHeader);
				dgResultEntryDetail.setRemarks(additionalRemarks);
				dgResultEntryDetail.setResultType(resultType);
				if (reportEnteredFinally != null
						&& reportEnteredFinally.equals("true")) {
					dgResultEntryDetail.setResultDetailStatus("P");
				} else {
					dgResultEntryDetail.setResultDetailStatus("W");
				}

				// dgResultEntryDetail.setFilmUsed(filmUsed);
				// dgResultEntryDetail.setFilmSize(filmSizeUsed);
			}
			parameterMap.put("dgResultEntryDetail", dgResultEntryDetail);
			parameterMap.put("sampleDetailId", sampleDetailId);
			if (reportEnteredFinally != null
					&& reportEnteredFinally.equals("true")) {
				map = investigationHandlerService
						.submitResultEntryForTemplate(parameterMap);
			} else {
				map = investigationHandlerService
						.submitResultEntryForTemplateTemparory(parameterMap);
			}

			saved = (Boolean) map.get("saved");
			if (reportEnteredFinally != null
					&& reportEnteredFinally.equals("true")) {
				if (saved == false) {
					messageTOBeVisibleToTheUser = "Result Entered.Do You Want To print?";
				} else {
					messageTOBeVisibleToTheUser = "Some Problem Occured.";
				}
				jsp = MESSAGE_FOR_RESULT_ENTRY + ".jsp";
			} else {
				if (saved == false) {
					messageTOBeVisibleToTheUser = "Result Entered.Do You Want To print?";
				} else {
					messageTOBeVisibleToTheUser = "Some Problem Occured.";
				}
				jsp = MESSAGE_FOR_WAITING_RESULT_ENTRY + ".jsp";
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		String url = "";
		url = "/hms/hms/investigation?method=searchPatient";
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("url", url);
		map.put("resultType", resultType);
		map.put("resultNo", resultNo);
		map.put("sampleCollectionId", sampleCollectionId);
		map.put("newSampleCollectionId", newSampleCollectionId);

		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/** end of method of submit result entry for template **/

	/** new method of next functionality **/

	public ModelAndView nextForResultValidation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailMap = new HashMap<String, Object>();
		String messageTOBeVisibleToTheUser = "";
		Box box = null;
		String serviceNo = "";
		String hinNo = "";

		String pType = "";
		String serPersonFName = "";
		String patientFName = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String adNo = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		int hinId = 0;
		String diagnosisNo = "";
		int deptId = 0;
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		box = (Box) session.getAttribute("box");
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		mapForDs.put("deptId", deptId);

		if (box.get(HIN_NO) != null && !(box.get(HIN_NO).equals(""))) {
			hinNo = box.get(HIN_NO);
			mapForDs.put("hinNo", hinNo);
		}
		if (box.get(FROM_DATE) != null && !(box.get(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(box.get(FROM_DATE));
			mapForDs.put("fromDate", fromDate);
		}
		if (box.get(TO_DATE) != null && !(box.get(TO_DATE).equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(box.get(TO_DATE));
			mapForDs.put("toDate", toDate);
		}

		if (box.get(SERVICE_NO) != null && !(box.get(SERVICE_NO).equals(""))) {
			serviceNo = box.get(SERVICE_NO);
			mapForDs.put("serviceNo", serviceNo);
		}

		if (box.getInt(SUB_CHARGECODE_ID) != 0) {
			subChargeCodeId = box.getInt(SUB_CHARGECODE_ID);
			mapForDs.put("subChargeCodeId", subChargeCodeId);
		}
		if (box.get(S_FIRST_NAME) != null
				&& !(box.get(S_FIRST_NAME).equals(""))) {
			serPersonFName = box.get(S_FIRST_NAME);
			mapForDs.put("serPersonFName", serPersonFName);
		}
		if (box.get(P_FIRST_NAME) != null
				&& !(box.get(P_FIRST_NAME).equals(""))) {
			patientFName = box.get(P_FIRST_NAME);
			mapForDs.put("patientFName", patientFName);
		}
		if (box.get(AD_NO) != null && !(box.get(AD_NO).equals(""))) {
			adNo = box.get(AD_NO);
			mapForDs.put("adNo", adNo);
		}

		if (box.getInt(DEPARTMENT_ID) != 0) {
			departmentId = box.getInt(DEPARTMENT_ID);
			mapForDs.put("departmentId", departmentId);
		}

		if (box.getInt(HIN_ID) != 0) {
			hinId = box.getInt(HIN_ID);
			mapForDs.put("hinId", hinId);
		}
		if (box.getInt(SAMPLE_ID) != 0) {
			sampleId = box.getInt(SAMPLE_ID);
		}
		if (box.get(PATIENT_TYPE) != null
				&& !(box.get(PATIENT_TYPE).equals(""))) {
			orderType = box.get(PATIENT_TYPE);
			mapForDs.put("orderType", orderType);
		}
		if (box.get(FROM_DATE) != null && !(box.get(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(box.get(FROM_DATE));
			mapForDs.put("fromDate", fromDate);
		}
		if (box.get(TO_DATE) != null && !(box.get(TO_DATE).equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(box.get(TO_DATE));
			mapForDs.put("toDate", toDate);
		}

		if (box.get(DIAGNOSIS_NO) != null
				&& !(box.get(DIAGNOSIS_NO).equals(""))) {
			diagnosisNo = box.get(DIAGNOSIS_NO);
			mapForDs.put("diagnosisNo", diagnosisNo);
		}
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientDetailsList = new ArrayList<DgResultEntryHeader>();
		patientMap = investigationHandlerService
				.getPatientDetailsForResultValidation(mapForDs);
		patientDetailsList = (List<DgResultEntryHeader>) patientMap
				.get("patientDetailsList");
		int resultId = 0;
		int newResultId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (request.getParameter(RESULT_ID) != null) {
			resultId = Integer.parseInt(request.getParameter(RESULT_ID));
		}
		if (patientDetailsList.size() > 0) {

			for (Iterator iterator = patientDetailsList.iterator(); iterator
					.hasNext();) {
				DgResultEntryHeader dgResultEntryHeader = (DgResultEntryHeader) iterator
						.next();
				newResultId = dgResultEntryHeader.getId();
				if (newResultId == resultId) {
					iterator.remove();
				}
			}
		}

		Map<String, Object> map = new HashMap<String, Object>();
		Set<DgResultEntryDetail> dgDetailSet = new HashSet<DgResultEntryDetail>();
		if (newResultId != 0) {
			map = investigationHandlerService.getResultEntryDetailsForNext(
					newResultId, deptId);
		}
		if (newResultId == 0) {
			jsp = "messageForNewResult" + ".jsp";
			messageTOBeVisibleToTheUser = "No Records Found.";
		} else if (patientDetailsList.size() > 0) {
			for (DgResultEntryHeader dgHeader : patientDetailsList) {
				dgDetailSet = dgHeader.getDgResultEntryDetails();

			}
			for (DgResultEntryDetail dgResEntry : dgDetailSet) {

				if (dgResEntry.getResultType().equals("s")) {
					jsp = RESULT_VALIDATION_ENTRY_SINGLE_PARAMETER + ".jsp";
				} else if (dgResEntry.getResultType().equals("m")) {
					jsp = RESULT_VALIDATION_ENTRY + ".jsp";
				} else if (dgResEntry.getResultType().equals("t")) {
					jsp = RESULT_VALIDATION_ENTRY_TEMPLATE + ".jsp";
				}
			}
		}
		map.put("newResultId", newResultId);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView nextForResultValidationLab(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailMap = new HashMap<String, Object>();
		String messageTOBeVisibleToTheUser = "";
		Box box = null;
		String serviceNo = "";
		String hinNo = "";

		String pType = "";
		String serPersonFName = "";
		String patientFName = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String adNo = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		int hinId = 0;
		String diagnosisNo = "";
		int deptId = 0;
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();

		String nextCombinedValidationIds = "";
		String[] idsArray = new String[0];
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			mapForDs.put("deptId", deptId);
		}
		if (request.getParameter("nextCombinedValidationIds") != null) {
			nextCombinedValidationIds = request
					.getParameter("nextCombinedValidationIds");
			mapForDs.put("resultId", nextCombinedValidationIds);
		}
		if (!nextCombinedValidationIds.equals("")) {
			map = investigationHandlerService
					.getResultEntryDetailsLab(mapForDs);
			map.put("resultId", nextCombinedValidationIds);
			List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
			if (map.get("resultList") != null) {
				resultList = (List<DgResultEntryHeader>) map.get("resultList");
			}
			jsp = RESULT_VALIDATION_ENTRY_SINGLE_PARAMETER_LAB + ".jsp";
		} else {
			jsp = "messageForNewResultValidation" + ".jsp";
			messageTOBeVisibleToTheUser = "No Records Found.";
		}
		map.put("resultId", nextCombinedValidationIds);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/** for update Normal Value Screen **/
	public ModelAndView updateNormalValue(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String message = "";
		boolean dataUpdated = false;
		dataUpdated = investigationHandlerService.updateNormalValue(box);
		if (dataUpdated == false) {
			message = "Normal Value Updated Successfully.";
		} else {
			message = "Normal Value Cant Be Updated.";
		}
		url = "/hms/hms/investigation?method=showInvestigationJsp";
		jsp = "updateNormalValue";

		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	/** for update fixed values **/
	public ModelAndView updateFixedValues(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String message = "";
		boolean dataUpdated = false;
		dataUpdated = investigationHandlerService.updateFixedValues(box);
		if (dataUpdated == false) {
			message = "Fixed Value Updated Successfully.";
		} else {
			message = "Fixed Value Cant Be Updated.";
		}
		url = "/hms/hms/investigation?method=showInvestigationJsp";
		jsp = "updateFixedValue";

		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	/**
	 * For updating reports received records
	 * 
	 */
	public ModelAndView updateReceivedDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String url = "";
		int resultId = 0;
		int dispatchedId = 0;
		int relationId = 0;
		String receivedBy = "";
		String messageTOBeVisibleToTheUser = "";
		resultId = Integer.parseInt(request.getParameter(RESULT_ID));
		if (request.getParameter(DISPATCHED_BY) != null
				&& (!request.getParameter(DISPATCHED_BY).equals("0"))) {
			dispatchedId = Integer
					.parseInt(request.getParameter(DISPATCHED_BY));
		}
		if (request.getParameter(RELATION_ID) != null
				&& (!request.getParameter(RELATION_ID).equals("0"))) {
			relationId = Integer.parseInt(request.getParameter(RELATION_ID));
		}
		if (request.getParameter(RECEIVED_FROM) != null) {
			receivedBy = request.getParameter(RECEIVED_FROM);
		}
		map = investigationHandlerService.getResultList(resultId);
		infoMap.put("box", box);
		infoMap.put("resultId", resultId);
		infoMap.put("dispatchedId", dispatchedId);
		infoMap.put("relationId", relationId);
		infoMap.put("receivedBy", receivedBy);
		boolean flag = false;
		try {
			flag = investigationHandlerService.updateReceivedDetails(infoMap);
			if (flag == false) {
				messageTOBeVisibleToTheUser = "Report Collection Details Entered..";
			} else {
				messageTOBeVisibleToTheUser = "Some Problem occured.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = MESSAGE_JSP + ".jsp";
		url = "/hms/hms/investigation?method=searchPatientForReportCollection";
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// ========================================= end of methods by Abha
	// =====================================================================================
	/** new methods by mansi **/

	public ModelAndView showResultOrderNoJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		String deptName = "";
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		/*
		 * if(request.getParameter(FROM_DATE) != null &&
		 * !(request.getParameter(FROM_DATE).equals(""))){ fromDate =
		 * HMSUtil.dateFormatterDDMMYYYY(request.getParameter(FROM_DATE));
		 * mapForDs.put("fromDate", fromDate); }
		 * if(request.getParameter(TO_DATE) != null &&
		 * !(request.getParameter(TO_DATE).equals(""))){ toDate=
		 * HMSUtil.dateFormatterDDMMYYYY(request.getParameter(TO_DATE));
		 * mapForDs.put("toDate", toDate); }
		 */
		mapForDs.put("departmentId", deptId);
		mapForDs.put("fromDate", new Date());
		mapForDs.put("toDate", new Date());
		mapForDs.put("hospitalId", hospitalId);
		
		patientMap = investigationHandlerService.getPatientDetailsForResultValidationOrderNo(mapForDs);
		List<DgOrderhd> patientList = new ArrayList<DgOrderhd>();
		if (patientMap.get("patientDetailsList") != null) {
			patientList = (List<DgOrderhd>) patientMap
					.get("patientDetailsList");
		}
		patientMap.put("patientList", patientList);
		//detailsMap = investigationHandlerService.getDetailsForResultValidation(dataMap);

		String jsp = PENDING_RESULT_VALIDATION_ORDER_NO;
		jsp += ".jsp";

		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForResultValidationOrderNo(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		int chargeCodeId = 0;
		String pType = "";
		String serPersonFName = "";
		String patientFName = "";
		Date fromDate = null;
		
		Date toDate = null;
		String adNo = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		int hinId = 0;
		int resultId = 0;
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		String userName = "";
		String orderNo = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		try {

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}

			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));
				mapForDs.put("chargeCodeId", chargeCodeId);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
			}
			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}

			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				mapForDs.put("orderByDepartmentId", departmentId);
			}

			mapForDs.put("departmentId", deptId);

			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(SAMPLE_ID) != null
					&& !(request.getParameter(SAMPLE_ID).equals("0"))) {
				sampleId = Integer.parseInt(request.getParameter(SAMPLE_ID));
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				orderType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("orderType", orderType);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				mapForDs.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				mapForDs.put("toDate", toDate);
			}
			
			System.out.println("fromDatecc="+fromDate);
			
			System.out.println("toDatecc="+toDate);

			/*
			 * if(request.getParameter(FROM_DATE) != null &&
			 * !(request.getParameter(FROM_DATE).equals(""))){ fromDate =
			 * HMSUtil.dateFormatterDDMMYYYY(request.getParameter(FROM_DATE));
			 * mapForDs.put("fromDate", fromDate); }
			 * if(request.getParameter(TO_DATE) != null &&
			 * !(request.getParameter(TO_DATE).equals(""))){ toDate=
			 * HMSUtil.dateFormatterDDMMYYYY(request.getParameter(TO_DATE));
			 * mapForDs.put("toDate", toDate); }
			 */

			if (request.getParameter(RESULT_ID) != null
					&& !(request.getParameter(RESULT_ID).equals("0"))) {
				resultId = Integer.parseInt(request.getParameter(RESULT_ID));
				mapForDs.put("resultId", resultId);
			}

			if (request.getParameter(ORDER_NO) != null
					&& !(request.getParameter(ORDER_NO).equals(""))) {
				orderNo = request.getParameter(ORDER_NO);
				mapForDs.put("orderNo", orderNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		mapForDs.put("hospitalId", hospitalId);
		patientMap = investigationHandlerService
				.getPatientDetailsForResultValidationOrderNo(mapForDs);
		String jsp = "";
		int id = 0;
		List<DgOrderhd> patientList = new ArrayList<DgOrderhd>();
		if (patientMap.get("patientDetailsList") != null) {
			patientList = (List<DgOrderhd>) patientMap
					.get("patientDetailsList");
		}
		
		System.out.println("patientList="+patientList.size());
		detailsMap = investigationHandlerService
				.getDetailsForResultValidation(dataMap);
		jsp = PENDING_RESULT_VALIDATION_ORDER_NO + ".jsp";

		patientMap.put("patientList", patientList);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("deptId", deptId);
		map.put("id", id);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitResultValidationForSingleParameterOrderNo(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String url = "";
		int resultId = 0;
		int resultValidatedBy = 0;
		String messageTOBeVisibleToTheUser = "";
		resultId = Integer.parseInt(request.getParameter(RESULT_ID));
		if (request.getParameter(RESULT_VALIDATED_BY) != null
				&& !request.getParameter(RESULT_VALIDATED_BY).equals("")) {
			resultValidatedBy = Integer.parseInt(request
					.getParameter(RESULT_VALIDATED_BY));
		}
		map = investigationHandlerService.getResultList(resultId);
		infoMap.put("box", box);

		infoMap.put("resultId", resultId);
		infoMap.put("resultValidatedBy", resultValidatedBy);
		boolean flag = false;
		try {
			flag = investigationHandlerService
					.submitResultValidationForSingleParameter(infoMap);
			if (flag == false) {
				messageTOBeVisibleToTheUser = "Successfully Validated the result.Do you want to print.";
			} else {
				messageTOBeVisibleToTheUser = "Some Problem occured.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = MESSAGE_FOR_RESULT_ORDER_NO_JSP + ".jsp";
		url = "/hms/hms/investigation?method=searchPatientForResultValidationOrderNo";
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printviewResultEntryPrintOrderNoWiseLab(HttpServletRequest request, HttpServletResponse response)
	{
		
		String deptName = "";
		int deptId = 0;
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		Map<String,Object> parameters= new HashMap<String,Object>();
		Map<String,Object> detailsMap=new HashMap<String,Object>();
		detailsMap= investigationHandlerService.getConnectionForReport();
		HMSUtil.generateReport("viewResultEntryPrintOrderNoWiseLab", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		return null;
	}

	public ModelAndView submitResultValidationOrderNo(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String messageTOBeVisibleToTheUser = "";
		String url = "";
		int deptId = 0;
		int resultId = 0;
		int resultValidatedBy = 0;
		int newResultId = 0;
		resultId = Integer.parseInt(request.getParameter(RESULT_ID));
		List<DgResultEntryHeader> list = new ArrayList<DgResultEntryHeader>();
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		String listType = "";
		if (!(session.getAttribute("listType").equals(""))) {
			listType = session.getAttribute("listType").toString();
			if (listType.equals("currentTypeList")) {
				list = (List<DgResultEntryHeader>) session
						.getAttribute("ResultValidationList");
			} else if (listType.equals("searchTypeList")) {
				list = (List<DgResultEntryHeader>) session
						.getAttribute("patientList");
			}
			if (list.size() > 0) {
				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
					DgResultEntryHeader dgResultEntryHeader = (DgResultEntryHeader) iterator
							.next();
					newResultId = dgResultEntryHeader.getId();
					if (newResultId == resultId) {
						iterator.remove();
					}
				}
			}
		}
		Map<String, Object> patientMap = new HashMap<String, Object>();
		if (newResultId != 0) {
			map = investigationHandlerService.getResultEntryDetailsForNext(
					newResultId, deptId);
		}

		if (request.getParameter(RESULT_VALIDATED_BY) != null
				&& !request.getParameter(RESULT_VALIDATED_BY).equals("")) {
			resultValidatedBy = Integer.parseInt(request
					.getParameter(RESULT_VALIDATED_BY));
		}
		map = investigationHandlerService.getResultList(resultId);
		infoMap.put("box", box);

		infoMap.put("resultId", resultId);
		infoMap.put("resultValidatedBy", resultValidatedBy);
		boolean flag = false;
		try {
			flag = investigationHandlerService.submitResultValidation(infoMap);

			if (flag == false) {
				messageTOBeVisibleToTheUser = "Successfully Validated The Result. Do You want to Print. ";
			} else {
				messageTOBeVisibleToTheUser = "Some Problem occured.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsp = MESSAGE_FOR_RESULT_ORDER_NO_JSP + ".jsp";
		url = "/hms/hms/investigation?method=searchPatientForResultValidationOrderNo";
		map.put("url", url);
		map.put("resultId", resultId);
		map.put("newResultId", newResultId);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitResultValidationForTemplateOrderNo(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String messageTOBeVisibleToTheUser = "";
		String url = "";
		int resultId = 0;
		int resultValidatedBy = 0;
		resultId = Integer.parseInt(request.getParameter(RESULT_ID));
		if (request.getParameter(RESULT_VALIDATED_BY) != null
				&& !request.getParameter(RESULT_VALIDATED_BY).equals("")) {
			resultValidatedBy = Integer.parseInt(request
					.getParameter(RESULT_VALIDATED_BY));
		}
		map = investigationHandlerService.getResultList(resultId);
		infoMap.put("box", box);
		String jsp = MESSAGE_FOR_RESULT_ORDER_NO_JSP + ".jsp";
		infoMap.put("resultId", resultId);
		map.put("resultValidatedBy", resultValidatedBy);
		boolean flag = false;
		try {
			flag = investigationHandlerService
					.submitResultValidationForTemplate(infoMap);

			if (flag == false) {
				messageTOBeVisibleToTheUser = "Successfully Validated the result.Do you want to print.";
			} else {
				messageTOBeVisibleToTheUser = "Some Problem occured";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		url = "/hms/hms/investigation?method=searchPatientForResultValidationOrderNo";
		map.put("resultId", resultId);
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/** Report printing method */

	public ModelAndView printResultEntryReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String resultNo = "";
		String resultType = "";
		session = request.getSession();

		if (request.getParameter(RESULT_NO) != null) {
			resultNo = request.getParameter(RESULT_NO);
		}
		if (request.getParameter(RESULT_TYPE) != null) {
			resultType = request.getParameter(RESULT_TYPE);
		}
		detailsMap = investigationHandlerService.getConnectionForReport();
		parameters.put("resultNo", resultNo);
		parameters.put("resultType", resultType);
		parameters.put("dept_id", session.getAttribute("deptId"));
		try {
			if (resultType.equalsIgnoreCase("s")) {
				HMSUtil.generateReport("inv_Result_Single", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (resultType.equalsIgnoreCase("m")) {
				HMSUtil.generateReport("inv_Result_Mul", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (resultType.equalsIgnoreCase("t")) {
				Map<String, Object> detailsMap1 = new HashMap<String, Object>();
				List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
				detailsMap1 = investigationHandlerService
						.getResultEntryDetailsForTemplate(resultNo,
								(Integer) session.getAttribute("deptId"));
				if (detailsMap1 != null) {
					dgResultdetailList = (List<DgResultEntryDetail>) detailsMap1
							.get("resultList");

				}
		
				FileOutputStream fos = new FileOutputStream(getServletContext()
						.getRealPath("/temp/" + "temp.doc"));
				InputStream fis = new FileInputStream(new File(
						getServletContext().getRealPath("/temp/" + "temp.jpg")));

				File file = new File(getServletContext().getRealPath(
						"/temp/" + "temp.html"));
				// File file1=new
				// File(getServletContext().getRealPath("/temp/"+"temp.jpg"));
				BufferedInputStream bis = new BufferedInputStream(
						new FileInputStream(file), 4096);
				File targetFile = new File(getServletContext().getRealPath(
						"/temp/" + "temp.jpg"));
				BufferedOutputStream bos = new BufferedOutputStream(
						new FileOutputStream(targetFile), 4096);
				int theChar;
				while ((theChar = bis.read()) != -1) {
					bos.write(theChar);
				}
				bos.close();
				bis.close();

				long length = file.length();
				byte[] bytes = new byte[(int) length];

				// Read in the bytes
				int offset = 0;
				int numRead = 0;
				while ((offset < bytes.length)
						&& ((numRead = fis.read(bytes, offset, bytes.length
								- offset)) >= 0)) {

					offset += numRead;

				}

				// Ensure all the bytes have been read in
				if (offset < bytes.length) {
					throw new IOException("Could not completely read file "
							+ file.getName());
				}
				fos.write(bytes);

				ByteArrayInputStream bs = new ByteArrayInputStream(bytes);
				InputStream fis1 = new ByteArrayInputStream(bytes);

				java.sql.Blob b = new SerialBlob(bytes);

				parameters.put("binaryResult", getServletContext().getRealPath(
						"/temp/" + "24468563.jpg"));
				fis.close();

				fos.close();
				HMSUtil.generateReport("inv_Result_Tem", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (resultType.equalsIgnoreCase("v")) {
				HMSUtil.generateReport("inv_Result_sen", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ==========================Result Entry Report
	// Print======================================
	public ModelAndView printResultValidation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap1 = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		String query = "";
		int srn = 0;
		String src = "";
		int id = 0;
		String crit = "";
		String deptName = "";
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");

		try {
			if (request.getParameter("counta") != null) {
				srn = Integer.parseInt(request.getParameter("counta"));
			}

			// for(id = 0; id < srn; id++){ //for loop start
			src = ("parent");
			if ((request.getParameter(src) != null)
					&& !(request.getParameter(src).equals("0"))) {

				requestParameters.put("orderNo", request.getParameter(src));
				query = "where dg_orderhd.`order_no` = '"
						+ (request.getParameter(src)) + "'";
				// /////////////////////////
				detailsMap1 = investigationHandlerService
						.getAllValidatedTestForOrder(requestParameters);
				dgResultdetailList = (List<DgResultEntryDetail>) detailsMap1
						.get("resultList");
				map.put("dgResultdetailList", dgResultdetailList);
				map.put("detailsMap1", detailsMap1);
				map.put("deptName", deptName);
				// //////////////////////////////

				/*
				 * //System.out.println("at controller query====== " + query);
				 * //Made Commented requestParameters.put("SUBREPORT_DIR",
				 * getServletContext().getRealPath("/reports/"));
				 * requestParameters.put("QUERY",query);
				 * 
				 * Map<String, Object> connectionMap =
				 * investigationHandlerService.getConnectionForReport();
				 * HMSUtil.generateReport(DG_RESULT_SINGLE, requestParameters,
				 * (Connection)connectionMap.get("conn"), response,
				 * getServletContext());
				 */
			}
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("finalResultPrintForRadio", "map", map);
	}

	public ModelAndView printResultValidationLab(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap1 = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		Map<String, Object> resultDetailsMap = new HashMap<String, Object>();
		List<Map<String, Object>> resultDetailsMapList = new ArrayList<Map<String, Object>>();
		session = request.getSession();
		String query = "";
		String flag="";
		int srn = 0;
		String src = "";
		int id = 0;
		String crit = "";
		String deptName = "";
		int deptId = 0;
		String jsp="";
		int hinId=0;
		if (session.getAttribute("deptName") != null){
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		try {
			if (request.getParameter("counta") != null) {
				srn = Integer.parseInt(request.getParameter("counta"));
			}

			src = ("parent");
		/*	if ((request.getParameter(src) != null)
					&& !(request.getParameter(src).equals("0"))) {
				requestParameters.put("orderNo", request.getParameter(src));*/
			if (request.getParameter("orderNo") != null
					&& !request.getParameter("orderNo").isEmpty()) {
				requestParameters.put("orderNo", request.getParameter("orderNo"));
				
				
				// /////////////////////////
				//--Added By Manjul on 11/06/2012 to show result in MO
				if(request.getParameter("flag")!=null && request.getParameter("flag")!=""){
					flag=request.getParameter("flag");
					/*requestParameters.put("flag", flag);*/
				}
				if(request.getParameter("hinId")!=null && request.getParameter("hinId")!="" 
					&& !(request.getParameter("hinId").equals("0"))){
					hinId=Integer.parseInt(request.getParameter("hinId"));
					requestParameters.put("hinId", hinId);
				}
				if(flag.equalsIgnoreCase("MO")){
					jsp="finalResultPrintForLabForMo";
				}
				else{
					jsp="finalResultPrintForLab";
				}
				///////////////////////
				System.out.println("hinId="+hinId +" flag="+flag +" orderNo="+request.getParameter(src));
				detailsMap1 = investigationHandlerService
						.getAllValidatedTestForLabOrderNoWise(requestParameters);

				map.put("detailsMap1", detailsMap1);
				map.put("deptName", deptName);
				// //////////////////////////////
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//HMSUtil.generateReport("PatientPrescriptionFormat", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		//	HMSUtil.generateReportInWord("PatientPrescriptionFormat", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		//	return null;
		return new ModelAndView(jsp, "map", map);
	}

	// -------------Jasper Compiled Report
	// --------------------------------------
	private JasperReport getCompiledReport(String fileName) throws JRException {

		File reportFile = new File(getServletContext().getRealPath(
				"/reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile.getPath());

		return jasperReport;
	}

	/** NEW METHOD FOR RESULT ENTRY NEXT PATIENT SCREEN **/

	public ModelAndView nextForResultEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailMap = new HashMap<String, Object>();
		String messageTOBeVisibleToTheUser = "";
		Box box = null;
		String serviceNo = "";
		String hinNo = "";

		String pType = "";
		String serPersonFName = "";
		String patientFName = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String adNo = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		int hinId = 0;
		int inpatientId = 0;
		String diagnosisNo = "";
		String orderStatus = "";
		Map<String, Object> diagMap = new HashMap<String, Object>();
		String resultSeqNo = "";
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		int deptId = 0;
		box = (Box) session.getAttribute("box");
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		mapForDs.put("deptId", deptId);

		if (box.get(HIN_NO) != null && !(box.get(HIN_NO).equals(""))) {
			hinNo = box.get(HIN_NO);
			mapForDs.put("hinNo", hinNo);
		}
		if (box.getInt(INPATIENT_ID) != 0) {
			inpatientId = box.getInt(INPATIENT_ID);
			mapForDs.put("inpatientId", inpatientId);
		}
		if (box.get(FROM_DATE) != null && !(box.get(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(box.get(FROM_DATE));
			mapForDs.put("fromDate", fromDate);
		}
		if (box.get(TO_DATE) != null && !(box.get(TO_DATE).equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(box.get(TO_DATE));
			mapForDs.put("toDate", toDate);
		}

		if (box.get(SERVICE_NO) != null && !(box.get(SERVICE_NO).equals(""))) {
			serviceNo = box.get(SERVICE_NO);
			mapForDs.put("serviceNo", serviceNo);
		}
		if (box.get(ORDER_STATUS) != null
				&& !(box.get(ORDER_STATUS).equals(""))) {
			orderStatus = box.get(ORDER_STATUS);
			mapForDs.put("orderStatus", orderStatus);
		}
		if (box.getInt(SUB_CHARGECODE_ID) != 0) {
			subChargeCodeId = box.getInt(SUB_CHARGECODE_ID);
			mapForDs.put("subChargeCodeId", subChargeCodeId);
		}
		if (box.get(S_FIRST_NAME) != null
				&& !(box.get(S_FIRST_NAME).equals(""))) {
			serPersonFName = box.get(S_FIRST_NAME);
			mapForDs.put("serPersonFName", serPersonFName);
		}
		if (box.get(P_FIRST_NAME) != null
				&& !(box.get(P_FIRST_NAME).equals(""))) {
			patientFName = box.get(P_FIRST_NAME);
			mapForDs.put("patientFName", patientFName);
		}
		if (box.get(AD_NO) != null && !(box.get(AD_NO).equals(""))) {
			adNo = box.get(AD_NO);
			mapForDs.put("adNo", adNo);
		}

		if (box.getInt(DEPARTMENT_ID) != 0) {
			departmentId = box.getInt(DEPARTMENT_ID);
			mapForDs.put("departmentId", departmentId);
		}

		if (box.getInt(HIN_ID) != 0) {
			hinId = box.getInt(HIN_ID);
			mapForDs.put("hinId", hinId);
		}
		if (box.getInt(SAMPLE_ID) != 0) {
			sampleId = box.getInt(SAMPLE_ID);
		}
		if (box.get(PATIENT_TYPE) != null
				&& !(box.get(PATIENT_TYPE).equals(""))) {
			orderType = box.get(PATIENT_TYPE);
			mapForDs.put("orderType", orderType);
		}
		int sampleCollectionDetailId = 0;
		if (box.getInt(SAMPLE_COLLECTION_DETAIL_ID) != 0) {
			sampleCollectionDetailId = box.getInt(SAMPLE_COLLECTION_DETAIL_ID);
			mapForDs.put("sampleCollectionDetailId", sampleCollectionDetailId);
		}

		if (box.get(DIAGNOSIS_NO) != null
				&& !(box.get(DIAGNOSIS_NO).equals(""))) {
			diagnosisNo = box.get(DIAGNOSIS_NO);
			mapForDs.put("diagnosisNo", diagnosisNo);
		}
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<DgSampleCollectionDetails> patientDetailsList = new ArrayList<DgSampleCollectionDetails>();
		patientMap = investigationHandlerService.getPatientDetails(mapForDs);
		patientDetailsList = (List<DgSampleCollectionDetails>) patientMap
				.get("patientDetailsList");
		int sampleCollectionId = 0;
		int newSampleCollectionId = 0;
		if (request.getParameter(DG_SAMPLE_DETAIL_ID) != null) {
			sampleCollectionId = Integer.parseInt(request
					.getParameter(DG_SAMPLE_DETAIL_ID));
		}
		if (patientDetailsList.size() > 0) {

			for (Iterator iterator = patientDetailsList.iterator(); iterator
					.hasNext();) {
				DgSampleCollectionDetails dgSampleDetail = (DgSampleCollectionDetails) iterator
						.next();
				newSampleCollectionId = dgSampleDetail.getId();
				if (newSampleCollectionId == sampleCollectionId) {
					iterator.remove();
				}
			}
		}

		resultSeqNo = investigationHandlerService.generateResultNumber(diagMap);

		Map<String, Object> map = new HashMap<String, Object>();
		Set<DgResultEntryDetail> dgDetailSet = new HashSet<DgResultEntryDetail>();
		if (newSampleCollectionId != 0) {
			map = investigationHandlerService.getResultEntryForNext(
					newSampleCollectionId, deptId);
		}
		if (newSampleCollectionId == 0) {
			jsp = "messageForNewresultEntry" + ".jsp";
			messageTOBeVisibleToTheUser = "No Records Found.";
		} else if (patientDetailsList.size() > 0) {
			for (DgSampleCollectionDetails dgDet : patientDetailsList) {
				if (dgDet.getInvestigation().getInvestigationType()
						.equalsIgnoreCase("s")) {
					jsp = RESULT_ENTRY_SINGLE_PARAMETER_WITH_NORMAL_VALUE
							+ ".jsp";
				} else if (dgDet.getInvestigation().getInvestigationType()
						.equalsIgnoreCase("m")) {
					jsp = RESULT_ENTRY + ".jsp";
				} else if (dgDet.getInvestigation().getInvestigationType()
						.equalsIgnoreCase("t")) {
					jsp = RESULT_ENTRY_SINGLE_PARAMETER + ".jsp";
				}
			}
		}
		if (resultSeqNo != "") {
			map.put("resultSeqNo", resultSeqNo);
		}
		map.put("newSampleCollectionId", newSampleCollectionId);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView nextForResultEntryLab(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailMap = new HashMap<String, Object>();
		String messageTOBeVisibleToTheUser = "";
		Box box = null;
		String serviceNo = "";
		String hinNo = "";

		String pType = "";
		String serPersonFName = "";
		String patientFName = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String adNo = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		int hinId = 0;
		int inpatientId = 0;
		String diagnosisNo = "";
		String orderStatus = "";
		Map<String, Object> diagMap = new HashMap<String, Object>();

		Map<String, Object> mapForDs = new HashMap<String, Object>();
		List<DgResultEntryDetail> dgResultEntryDetailListForResult = new ArrayList<DgResultEntryDetail>();
		int deptId = 0;

		String nextCombinedIds = "";
		String[] idsArray = new String[0];
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			mapForDs.put("deptId", deptId);
		}
		if (request.getParameter("nextCombinedIds") != null) {
			nextCombinedIds = request.getParameter("nextCombinedIds");
		}
		diagMap.put("hospitalId", (Integer)session.getAttribute("hospitalId"));
		if (!nextCombinedIds.equals("")) {
			idsArray = nextCombinedIds.split(",");
			int dgSampleHeaderId = Integer.parseInt(idsArray[0]);
			mapForDs.put("dgSampleHeaderId", dgSampleHeaderId);

			int subChargeId = Integer.parseInt(idsArray[1]);
			mapForDs.put("subChargeId", subChargeId);
			// //////////////////////////////////////////////////////
			map = investigationHandlerService
					.getSampleCollectionDetailsForLab(mapForDs);
			// /////////////////////////////////////////////////////

			List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
			if (map.get("sampleCollectionList") != null) {
				sampleCollectionList = (List<DgSampleCollectionDetails>) map
						.get("sampleCollectionList");
			}
			if (map.get("dgResultEntryDetailListForResult") != null) {
				dgResultEntryDetailListForResult = (List<DgResultEntryDetail>) map
						.get("dgResultEntryDetailListForResult");
			}
			if (sampleCollectionList.size() > 0) {
				jsp = RESULT_ENTRY_SINGLE_PARAMETER_LAB + ".jsp";
				List<String> resultSeqNoList = new ArrayList<String>();
				for (int i = 0; i < sampleCollectionList.size(); i++) {
					String resultSeqNo = "";
					resultSeqNo = investigationHandlerService
							.generateResultNumberForLab(diagMap);
					resultSeqNoList.add(resultSeqNo);
				}
				if (resultSeqNoList.size() > 0) {
					map.put("resultSeqNoList", resultSeqNoList);
				}
				map.put("CombinedIds", nextCombinedIds);
			}
		} else {
			jsp = "messageForNewresultEntry" + ".jsp";
			messageTOBeVisibleToTheUser = "No Records Found.";
		}
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/** print report for result validation **/
	public ModelAndView printResultValidationReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String resultNo = "";
		String resultType = "";

		session = request.getSession();

		if (request.getParameter(RESULT_NO) != null) {
			resultNo = request.getParameter(RESULT_NO);
		}
		if (request.getParameter(RESULT_TYPE) != null) {
			resultType = request.getParameter(RESULT_TYPE);
		}
		detailsMap = investigationHandlerService.getConnectionForReport();
		parameters.put("resultNo", resultNo);
		parameters.put("resultType", resultType);
		parameters.put("dept_id", session.getAttribute("deptId"));
		try {
			if (resultType.equalsIgnoreCase("s")) {
				HMSUtil.generateReport("inv_Result_Single_val", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (resultType.equalsIgnoreCase("m")) {
				HMSUtil.generateReport("inv_Result_Mul_val", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (resultType.equalsIgnoreCase("t")) {
				HMSUtil.generateReport("inv_Result_Tem_val", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/** print PDFreport For Lab  **/
	public ModelAndView printLabReport(HttpServletRequest request,HttpServletResponse response)
	{   String deptName= "";
    	int  deptId= 0;
    	//String  order_no = "";
    	int orderId =0;
    	String currentDate="";
    	Map<String, Object> parameters = new HashMap<String, Object>();		
    	Map<String,Object> detailMap = new HashMap<String,Object>();
    	Map<String, Object> utilMap = new HashMap<String, Object>();
    	Date currentDate1 = new Date();
		 detailMap = investigationHandlerService.getConnectionForReport();  
		 utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		 currentDate = (String) utilMap.get("currentDate");
		 currentDate1=HMSUtil.convertStringTypeDateToDateType(currentDate);
    	if (request.getParameter("orderNo") != null	&& !(request.getParameter("orderNo").equals("")))
    	{
			//order_no = request.getParameter("orderNo");	
    		orderId = Integer.parseInt(request.getParameter("orderNo"));
			parameters.put("orderId", orderId);
			parameters.put("currentDate1", currentDate1);
		}else if (request.getParameter("parent") != null	&& !(request.getParameter("parent").equals("")))
    	{
			//order_no = request.getParameter("parent");	
			orderId = Integer.parseInt(request.getParameter("parent"));
			parameters.put("orderId", orderId);
			parameters.put("currentDate1", currentDate1);
		}			 
		 HMSUtil.generateReport("Lab_Result", parameters, (Connection) detailMap.get("conn"), response, getServletContext());
		return null;
	}
	// -------------------------------Start Methods developed by Vivek
	// --------------------------------------

	public ModelAndView getOrganismList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String orGroupId = "";
		if (request.getParameter("orGroupId") != null) {
			orGroupId = (request.getParameter("orGroupId"));
			dataMap.put("orGroupId", orGroupId);
		}
		map = investigationHandlerService.getOrganismList(dataMap);
		String jsp = ORGANISM_RESPONCE_JSP;
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getResultOrganismList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int resultId = 0;
		if (request.getParameter("resultId") != null) {
			resultId = new Integer(request.getParameter("resultId"));
			dataMap.put("resultId", resultId);
		}
		map = investigationHandlerService.getResultOrganismList(dataMap);
		String jsp = "resultValidationOrganism";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getSensitivityList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String orIds = "";
		if (request.getParameter("orIds") != null) {
			orIds = request.getParameter("orIds");
			dataMap.put("orIds", orIds);
		}
		map = investigationHandlerService.getSensitivityList(dataMap);
		String jsp = SENSITIVITY_RESPONCE_JSP;
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getResultSensitivityList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int resultId = 0;
		if (request.getParameter("resultId") != null) {
			resultId = new Integer(request.getParameter("resultId"));
			dataMap.put("resultId", resultId);
		}
		map = investigationHandlerService.getResultSensitivityList(dataMap);
		String jsp = "resultValidationSenstivity";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView saveSensitivity(HttpServletRequest request,
			HttpServletResponse response) {
		// Map<String, Object> dataMap = new HashMap<String, Object>();
		// map = investigationHandlerService.saveSensitivity(dataMap);
		// return new ModelAndView(jsp, "map", map);

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		boolean saved = false;
		int hospitalId = 0;
		String userName = "";
		String messageTOBeVisibleToTheUser = "";
		String resultNo = "";
		String CombinedIds = "";
		HttpSession session = request.getSession();
		int sampleCollectionId = 0;
		int newSampleCollectionId = 0;
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		sampleCollectionId = Integer.parseInt(request
				.getParameter(DG_SAMPLE_DETAIL_ID));
		Map<String, Object> patientMap = new HashMap<String, Object>();
		if (newSampleCollectionId != 0) {
			map = investigationHandlerService.getResultEntryForNext(
					newSampleCollectionId, deptId);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameterMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			parameterMap.put("userName", userName);
		}
		if (request.getParameter(RESULT_NO) != null) {
			resultNo = request.getParameter(RESULT_NO);
		}
		if (request.getParameter("CombinedIds") != null) {
			CombinedIds = request.getParameter("CombinedIds");
		}

		String remarks = "";
		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
		}
		String testOrderNoSensitive = "";
		if (request.getParameter(TEST_ORDER_NO_SENSITIVE_VALUE) != null) {
			testOrderNoSensitive = request
					.getParameter(TEST_ORDER_NO_SENSITIVE_VALUE);
		}

		int subchargeId = 0;
		int mainChargeId = 0;

		int hinId = 0;
		int inpatientId = 0;
		int employeeId = 0;
		int resultEnteredId = 0;
		int departId = 0;
		int investigationId = 0;

		if (request.getParameter(MAIN_CHARGECODE_ID) != null) {
			mainChargeId = Integer.valueOf(request
					.getParameter(MAIN_CHARGECODE_ID));
		}
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departId = Integer.valueOf(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(SUB_CHARGECODE_ID) != null) {
			subchargeId = Integer.valueOf(request
					.getParameter(SUB_CHARGECODE_ID));
		}
		if (request.getParameter(HIN_ID) != null) {
			hinId = Integer.valueOf(request.getParameter(HIN_ID));
		}
		if (request.getParameter(INPATIENT_ID) != null
				&& !(request.getParameter(INPATIENT_ID).equals(""))) {
			inpatientId = Integer.valueOf(request.getParameter(INPATIENT_ID));
		}
		if (request.getParameter(SAMPLE_COLLECTION_ID) != null) {
			sampleCollectionId = Integer.valueOf(request
					.getParameter(SAMPLE_COLLECTION_ID));
		}
		if (!(request.getParameter(EMPLOYEE_ID).equals(""))
				&& request.getParameter(EMPLOYEE_ID) != null) {
			employeeId = Integer.valueOf(request.getParameter(EMPLOYEE_ID));

		}
		if (!(request.getParameter(RESULT_ENTERED_BY).equals(""))
				&& request.getParameter(RESULT_ENTERED_BY) != null) {
			resultEnteredId = Integer.valueOf(request
					.getParameter(RESULT_ENTERED_BY));
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		DgResultEntryHeader dgResultEntryHeader = new DgResultEntryHeader();
		dgResultEntryHeader.setResultNo(resultNo);
		dgResultEntryHeader.setLastChgdBy(userName);
		dgResultEntryHeader.setLastChgdDate(date);
		dgResultEntryHeader.setLastChgdTime(time);
		dgResultEntryHeader.setRemarks(remarks);
		dgResultEntryHeader.setResultDate(date);
		dgResultEntryHeader.setResultStatus("P");
		dgResultEntryHeader.setResultTime(time);

		if (testOrderNoSensitive != null && !testOrderNoSensitive.equals("")) {
			dgResultEntryHeader.setTestOrderNo(Integer
					.parseInt(testOrderNoSensitive));
		}

		dgResultEntryHeader.setResultType("S");
		MasMainChargecode masMainChargecode = new MasMainChargecode();
		masMainChargecode.setId(mainChargeId);
		dgResultEntryHeader.setMainChargecode(masMainChargecode);

		MasSubChargecode masSubChargecode = new MasSubChargecode();
		masSubChargecode.setId(subchargeId);
		dgResultEntryHeader.setSubChargecode(masSubChargecode);

		DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();
		dgSampleCollectionHeader.setId(sampleCollectionId);
		dgResultEntryHeader.setSampleCollectionHeader(dgSampleCollectionHeader);

		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departId);
		dgResultEntryHeader.setDepartment(masDepartment);

		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		dgResultEntryHeader.setMasHospital(masHospital);
		Patient patient = new Patient();
		patient.setId(hinId);
		dgResultEntryHeader.setPatient(patient);
		if (inpatientId != 0) {
			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);
			dgResultEntryHeader.setInpatient(inpatient);
		}
		if (employeeId != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			dgResultEntryHeader.setEmployee(masEmployee);
		}
		if (resultEnteredId != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(resultEnteredId);
			dgResultEntryHeader.setEmployee(masEmployee);
		}
		if (request.getParameter(INVESTIGATION_ID) != null
				&& (!request.getParameter(INVESTIGATION_ID).equals("0"))) {
			investigationId = Integer.parseInt(request
					.getParameter(INVESTIGATION_ID));
			DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
			dgMasInvestigation.setId(investigationId);
			dgResultEntryHeader.setDgMasInvestigation(dgMasInvestigation);

		}

		parameterMap.put("dgResultEntryHeader", dgResultEntryHeader);
		String result = "";
		String additionalRemarks = "";
		int sample_Id = 0;

		int uomId = 0;
		String resultType = "";
		String sensitivity = "";
		int sampleDetailId = 0;

		String growthOption = "";
		if (request.getParameter("screenSens") != null) {
			growthOption = request.getParameter("screenSens");
			parameterMap.put("growthOption", growthOption);
		}
		if (request.getParameter(RESULT_TYPE) != null) {
			resultType = request.getParameter(RESULT_TYPE);
			parameterMap.put("resultType", resultType);
		}
		if (request.getParameter("result") != null) {
			result = request.getParameter("result");
			parameterMap.put("result", result);
		}

		String result2 = "";
		if (request.getParameter("result2") != null) {
			result2 = request.getParameter("result2");
			parameterMap.put("result2", result2);
		}
		String result1 = "";
		if (request.getParameter("result1") != null) {
			result1 = request.getParameter("result1");
			parameterMap.put("result1", result1);
		}
		String nosoc = "";
		if (request.getParameter("NOSOCOMIAL") != null) {
			nosoc = request.getParameter("NOSOCOMIAL");
			parameterMap.put("nosoc", nosoc);
		}
		if (request.getParameter(ADDITIONAL_REMARKS) != null) {
			additionalRemarks = request.getParameter(ADDITIONAL_REMARKS);
			parameterMap.put("additionalRemarks", additionalRemarks);
		}

		if (request.getParameter(INVESTIGATION_ID) != null
				&& (!request.getParameter(INVESTIGATION_ID).equals("0"))) {
			investigationId = Integer.parseInt(request
					.getParameter(INVESTIGATION_ID));
			parameterMap.put("investigationId", investigationId);
		}

		if (request.getParameter(DG_SAMPLE_DETAIL_ID) != null
				&& (!request.getParameter(DG_SAMPLE_DETAIL_ID).equals(""))) {
			sampleDetailId = Integer.parseInt(request
					.getParameter(DG_SAMPLE_DETAIL_ID));
			parameterMap.put("sampleDetailId", sampleDetailId);

		}
		if (request.getParameter("noOfSensitivity") != null) {

			Integer sq = new Integer(request.getParameter("noOfSensitivity"));
			String[] senArray = new String[sq];
			for (int ilop = 0; ilop < sq; ilop++) {
				if (request.getParameter("chkBoxSensitive" + (ilop + 1)) != null
						&& !request
								.getParameter("chkBoxSensitive" + (ilop + 1))
								.equals("")) {
					senArray[ilop] = (String) request
							.getParameter("chkBoxSensitive" + (ilop + 1));

				}
			}
			parameterMap.put("senArray", senArray);
			String[] resArray = new String[sq];
			for (int ilop = 0; ilop < sq; ilop++) {
				if (request.getParameter("res" + (ilop + 1)) != null
						&& !request.getParameter("res" + (ilop + 1)).equals("")) {
					resArray[ilop] = (String) request.getParameter("res"
							+ (ilop + 1));
				}
			}
			parameterMap.put("resArray", resArray);
		}
		map = investigationHandlerService.saveSensitivity(parameterMap);
		saved = (Boolean) map.get("saved");
		if (saved == false) {
			messageTOBeVisibleToTheUser = "Result Entered. Do You Want To print?";
		} else {
			messageTOBeVisibleToTheUser = "Some Problem Occured.";
		}

		/*
		 * 
		 * String url=""; url="/hms/hms/investigation?method=searchPatient";
		 * map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		 * map.put("url", url); map.put("result", result); map.put("result2",
		 * result2); map.put("resultNo", resultNo); map.put("resultType",
		 * resultType); map.put("sampleCollectionId", sampleCollectionId);
		 * map.put("newSampleCollectionId", newSampleCollectionId); String jsp =
		 * MESSAGE_FOR_RESULT_ENTRY+".jsp";
		 */

		int dgSampleHeaderId = 0;
		int subChargeId = 0;
		String[] idsArray = new String[0];
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		diagMap.put("hospitalId",hospitalId);
		mapForDs.put("deptId", deptId);
		if (!CombinedIds.equals("")) {

			idsArray = CombinedIds.split(",");
			dgSampleHeaderId = Integer.parseInt(idsArray[0]);
			mapForDs.put("dgSampleHeaderId", dgSampleHeaderId);

			subChargeId = Integer.parseInt(idsArray[1]);
			mapForDs.put("subChargeId", subChargeId);

		}

		if (!CombinedIds.equals("")) {
			// //////////////////////////////////////////////////////
			map = investigationHandlerService
					.getSampleCollectionDetailsForLab(mapForDs);

			// /////////////////////////////////////////////////////
			// map =
			// investigationHandlerService.getSampleCollectionDetails(sampleCollectionDetailId,
			// deptId);

			List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
			if (map.get("sampleCollectionList") != null) {
				sampleCollectionList = (List<DgSampleCollectionDetails>) map
						.get("sampleCollectionList");
			}
			if (sampleCollectionList.size() > 0) {
				jsp = RESULT_ENTRY_SINGLE_PARAMETER_LAB + ".jsp";
				List<String> resultSeqNoList = new ArrayList<String>();
				for (int i = 0; i < sampleCollectionList.size(); i++) {
					String resultSeqNo = "";
					resultSeqNo = investigationHandlerService
							.generateResultNumberForLab(diagMap);
					resultSeqNoList.add(resultSeqNo);
				}

				if (resultSeqNoList.size() > 0) {
					map.put("resultSeqNoList", resultSeqNoList);
				}
				map.put("CombinedIds", CombinedIds);
			} else {
				String nextCombinedIds = "";
				if (!CombinedIds.equals("")) {
					String[] idArrString = new String[0];
					idArrString = CombinedIds.split(",");

					int subChargeIdTemp = Integer.parseInt(idArrString[1]);

					List<String> combinedListAll = new ArrayList<String>();
					combinedListAll = (List<String>) session
							.getAttribute("combinedListAll");

					if (combinedListAll.size() > 0) {
						combinedListAll.remove(CombinedIds);
					}
					for (String combinedIdsFromList : combinedListAll) {
						String[] idArray = new String[0];
						idArray = combinedIdsFromList.split(",");

						int subChargeIdFromList = Integer.parseInt(idArray[1]);
						if (subChargeIdFromList == subChargeIdTemp) {
							nextCombinedIds = combinedIdsFromList;
							break;
						}
					}
				}

				String url = "";
				url = "/hms/hms/investigation?method=searchPatientByBackButtonLab";
				map.put("messageTOBeVisibleToTheUser",
						messageTOBeVisibleToTheUser);
				map.put("url", url);

				map.put("nextCombinedIds", nextCombinedIds);
				map.put("CombinedIds", CombinedIds);
				map.put("newSampleCollectionId", newSampleCollectionId);
				map.put("sampleCollectionId", sampleCollectionId);
				jsp = MESSAGE_FOR_RESULT_ENTRY_LAB + ".jsp";

			}
		}

		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitResultValidationForSensitivity(
			HttpServletRequest request, HttpServletResponse response) {

		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		boolean saved = false;
		int hospitalId = 0;
		String userName = "";
		String messageTOBeVisibleToTheUser = "";
		String resultNo = "";
		String resultIdStringForTemplate = "";
		HttpSession session = request.getSession();
		int sampleCollectionId = 0;
		int newSampleCollectionId = 0;
		int deptId = 0;
		int resultId = 0;
		int sampleDetailId = 0;
		int investigationId = 0;
		int resultValidatedBy = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		resultId = Integer.parseInt(request.getParameter(RESULT_ID));
		if (request.getParameter(RESULT_VALIDATED_BY) != null
				&& !request.getParameter(RESULT_VALIDATED_BY).equals("")) {
			resultValidatedBy = Integer.parseInt(request
					.getParameter(RESULT_VALIDATED_BY));
		}
		if (request.getParameter(INVESTIGATION_ID) != null
				&& !request.getParameter(INVESTIGATION_ID).equals("")) {
			investigationId = Integer.parseInt(request
					.getParameter(INVESTIGATION_ID));
			infoMap.put("investigationId", investigationId);
		}
		if (request.getParameter(SAMPLE_COLLECTION_DETAIL_ID) != null
				&& !request.getParameter(SAMPLE_COLLECTION_DETAIL_ID)
						.equals("")) {
			sampleDetailId = Integer.parseInt(request
					.getParameter(SAMPLE_COLLECTION_DETAIL_ID));
			infoMap.put("sampleDetailId", sampleDetailId);
		}

		infoMap.put("box", box);
		String remarks = "";

		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
		}
		infoMap.put("remarks", remarks);

		String result1 = "";
		if (request.getParameter("result1") != null) {
			result1 = request.getParameter("result1");
		}
		infoMap.put("result1", result1);
		String result2 = "";
		if (request.getParameter("result2") != null) {
			result2 = request.getParameter("result2");
		}
		infoMap.put("result2", result2);

		String growthOption = "";
		if (request.getParameter("growthOption") != null) {
			growthOption = (String) request.getParameter("growthOption");

		}
		if (request.getParameter("resultIdStringForTemplate") != null) {
			resultIdStringForTemplate = (String) request
					.getParameter("resultIdStringForTemplate");

		}

		String nosoc = "";
		if (request.getParameter("NOSOCOMIAL") != null) {
			nosoc = request.getParameter("NOSOCOMIAL");
			infoMap.put("nosoc", nosoc);
		}
		infoMap.put("growthOption", growthOption);
		infoMap.put("resultId", resultId);
		infoMap.put("resultValidatedBy", resultValidatedBy);

		if (request.getParameter("noOfSensitivity") != null) {

			Integer sq = new Integer(request.getParameter("noOfSensitivity"));
			String[] senArray = new String[sq];
			for (int ilop = 0; ilop < sq; ilop++) {
				if (request.getParameter("chkBoxSensitive" + (ilop + 1)) != null
						&& !request
								.getParameter("chkBoxSensitive" + (ilop + 1))
								.equals("")) {
					senArray[ilop] = request.getParameter("chkBoxSensitive"
							+ (ilop + 1));

				}
			}
			infoMap.put("senArray", senArray);
			String[] resArray = new String[sq];
			for (int ilop = 0; ilop < sq; ilop++) {
				if (request.getParameter("res" + (ilop + 1)) != null
						&& !request.getParameter("res" + (ilop + 1)).equals("")) {
					resArray[ilop] = (String) request.getParameter("res"
							+ (ilop + 1));
				}
			}
			infoMap.put("resArray", resArray);
		}
		/*
		 * if (request.getParameter("noOfOrg") != null) {
		 * //System.out.println(request.getParameter("noOfOrg")
		 * +"request.getParameter(noOfOrg) ");
		 * 
		 * Integer sq=new Integer(request.getParameter("noOfOrg")); Integer []
		 * grpArray= new Integer[sq]; for(int ilop=0;ilop<sq;ilop++) { if
		 * (request.getParameter("OrganismGpName"+(ilop+1)) != null &&
		 * !request.getParameter("OrganismGpName"+(ilop+1)).equals("")) {
		 * grpArray[ilop] = new
		 * Integer(request.getParameter("OrganismGpName"+(ilop+1)));
		 * //System.out.println(grpArray[ilop]+"grpArray[ilop]"); } }
		 * infoMap.put("grpArray",grpArray);
		 * 
		 * Integer [] orgArray= new Integer[sq]; for(int ilop=0;ilop<sq;ilop++)
		 * { if (request.getParameter("OrganismName"+(ilop+1)) != null &&
		 * !request.getParameter("OrganismName"+(ilop+1)).equals("")) {
		 * orgArray[ilop] = new
		 * Integer(request.getParameter("OrganismName"+(ilop+1)));
		 * //System.out.println(orgArray[ilop]+"orgArray[ilop]"); } }
		 * infoMap.put("orgArray",orgArray);
		 * 
		 * Integer [] senArray= new Integer[sq]; for(int ilop=0;ilop<sq;ilop++)
		 * { if (request.getParameter("antibioId"+(ilop+1)) != null &&
		 * !request.getParameter("antibioId"+(ilop+1)).equals("")) {
		 * senArray[ilop] = new
		 * Integer(request.getParameter("antibioId"+(ilop+1)));
		 * //System.out.println(senArray[ilop]+"senArray[ilop]"); } }
		 * infoMap.put("senArray",senArray);
		 * 
		 * String [] resArray= new String[sq]; for(int ilop=0;ilop<sq;ilop++) {
		 * if (request.getParameter("sensitivityResult"+(ilop+1)) != null &&
		 * !request.getParameter("sensitivityResult"+(ilop+1)).equals("")) {
		 * resArray[ilop]
		 * =(String)request.getParameter("sensitivityResult"+(ilop+1));
		 * //System.out.println("res[ilop]======="+resArray[ilop]); } }
		 * infoMap.put("resArray",resArray); }ssas
		 */
		boolean flag = false;
		try {
			flag = investigationHandlerService
					.submitResultValidationForSensitivity(infoMap);
			if (flag == false) {
				messageTOBeVisibleToTheUser = "Successfully Validated the result.Do you want to print.";
			} else {
				messageTOBeVisibleToTheUser = "Some Problem occured.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();

		dataMap.put("deptId", deptId);
		dataMap.put("resultId", resultIdStringForTemplate);

		if (!resultIdStringForTemplate.equals("")) {
			map = investigationHandlerService.getResultEntryDetailsLab(dataMap);
			map.put("resultId", resultIdStringForTemplate);
			List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
			if (map.get("resultList") != null) {
				resultList = (List<DgResultEntryHeader>) map.get("resultList");
				if (resultList.size() > 0) {
					jsp = RESULT_VALIDATION_ENTRY_SINGLE_PARAMETER_LAB + ".jsp";
				} else {
					String nextCombinedValidationIds = "";
					if (!resultIdStringForTemplate.equals("")) {
						String[] idArrString = new String[0];
						idArrString = resultIdStringForTemplate.split("@");

						int subChargeId = Integer.parseInt(idArrString[1]);

						List<String> pendingValidationListLabAll = new ArrayList<String>();
						pendingValidationListLabAll = (List<String>) session
								.getAttribute("pendingValidationListLabAll");

						if (pendingValidationListLabAll.size() > 0) {
							pendingValidationListLabAll
									.remove(resultIdStringForTemplate);
						}
						for (String combinedIdsFromList : pendingValidationListLabAll) {
							String[] idArray = new String[0];
							idArray = combinedIdsFromList.split("@");

							int subChargeIdFromList = Integer
									.parseInt(idArray[1]);
							if (subChargeIdFromList == subChargeId) {
								nextCombinedValidationIds = combinedIdsFromList;
								break;
							}
						}
					}

					map.put("nextCombinedValidationIds",
							nextCombinedValidationIds);
					jsp = MESSAGE_FOR_RESULT_VALIDATION_LAB + ".jsp";
				}
			}
		}
		map.put("resultIdStringForTemplate", resultIdStringForTemplate);

		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitResultEntryModificationForSensitivity(
			HttpServletRequest request, HttpServletResponse response) {

		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		boolean saved = false;
		int hospitalId = 0;
		String userName = "";
		String messageTOBeVisibleToTheUser = "";
		String resultNo = "";
		String resultIdStringForTemplate = "";
		HttpSession session = request.getSession();
		int sampleCollectionId = 0;
		int newSampleCollectionId = 0;
		int deptId = 0;
		int resultId = 0;
		int sampleDetailId = 0;
		int investigationId = 0;
		int resultEnteredBy = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		resultId = Integer.parseInt(request.getParameter(RESULT_ID));
		if (request.getParameter(RESULT_ENTERED_BY) != null
				&& !request.getParameter(RESULT_ENTERED_BY).equals("")) {
			resultEnteredBy = Integer.parseInt(request
					.getParameter(RESULT_ENTERED_BY));
		}
		if (request.getParameter(INVESTIGATION_ID) != null
				&& !request.getParameter(INVESTIGATION_ID).equals("")) {
			investigationId = Integer.parseInt(request
					.getParameter(INVESTIGATION_ID));
			infoMap.put("investigationId", investigationId);
		}
		if (request.getParameter(SAMPLE_COLLECTION_DETAIL_ID) != null
				&& !request.getParameter(SAMPLE_COLLECTION_DETAIL_ID)
						.equals("")) {
			sampleDetailId = Integer.parseInt(request
					.getParameter(SAMPLE_COLLECTION_DETAIL_ID));
			infoMap.put("sampleDetailId", sampleDetailId);
		}

		infoMap.put("box", box);
		String remarks = "";

		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
		}
		infoMap.put("remarks", remarks);

		String result1 = "";
		if (request.getParameter("result1") != null) {
			result1 = request.getParameter("result1");
		}
		infoMap.put("result1", result1);
		String result2 = "";
		if (request.getParameter("result2") != null) {
			result2 = request.getParameter("result2");
		}
		infoMap.put("result2", result2);

		String growthOption = "";
		if (request.getParameter("growthOption") != null) {
			growthOption = (String) request.getParameter("growthOption");

		}
		if (request.getParameter("resultIdStringForTemplate") != null) {
			resultIdStringForTemplate = (String) request
					.getParameter("resultIdStringForTemplate");

		}

		String nosoc = "";
		if (request.getParameter("NOSOCOMIAL") != null) {
			nosoc = request.getParameter("NOSOCOMIAL");
			infoMap.put("nosoc", nosoc);
		}
		infoMap.put("growthOption", growthOption);
		infoMap.put("resultId", resultId);
		infoMap.put("resultEnteredBy", resultEnteredBy);
		if (request.getParameter("noOfSensitivity") != null) {
			Integer sq = new Integer(request.getParameter("noOfSensitivity"));
			String[] senArray = new String[sq];
			for (int ilop = 0; ilop < sq; ilop++) {
				if (request.getParameter("chkBoxSensitive" + (ilop + 1)) != null
						&& !request
								.getParameter("chkBoxSensitive" + (ilop + 1))
								.equals("")) {
					senArray[ilop] = request.getParameter("chkBoxSensitive"
							+ (ilop + 1));
				}
			}
			infoMap.put("senArray", senArray);
			String[] resArray = new String[sq];
			for (int ilop = 0; ilop < sq; ilop++) {
				if (request.getParameter("res" + (ilop + 1)) != null
						&& !request.getParameter("res" + (ilop + 1)).equals("")) {
					resArray[ilop] = (String) request.getParameter("res"
							+ (ilop + 1));
				}
			}
			infoMap.put("resArray", resArray);
		}

		/*
		 * if (request.getParameter("noOfOrg") != null) {
		 * //System.out.println(request.getParameter("noOfOrg")
		 * +"request.getParameter(noOfOrg) "); Integer sq=new
		 * Integer(request.getParameter("noOfOrg")); Integer [] grpArray= new
		 * Integer[sq]; for(int ilop=0;ilop<sq;ilop++) { if
		 * (request.getParameter("OrganismGpName"+(ilop+1)) != null &&
		 * !request.getParameter("OrganismGpName"+(ilop+1)).equals("")) {
		 * grpArray[ilop] = new
		 * Integer(request.getParameter("OrganismGpName"+(ilop+1)));
		 * //System.out.println(grpArray[ilop]+"grpArray[ilop]"); } }
		 * infoMap.put("grpArray",grpArray);
		 * 
		 * 
		 * Integer [] orgArray= new Integer[sq]; for(int ilop=0;ilop<sq;ilop++)
		 * { if (request.getParameter("OrganismName"+(ilop+1)) != null &&
		 * !request.getParameter("OrganismName"+(ilop+1)).equals("")) {
		 * orgArray[ilop] = new
		 * Integer(request.getParameter("OrganismName"+(ilop+1)));
		 * //System.out.println(orgArray[ilop]+"orgArray[ilop]"); } }
		 * infoMap.put("orgArray",orgArray);
		 * 
		 * 
		 * 
		 * Integer [] senArray= new Integer[sq]; for(int ilop=0;ilop<sq;ilop++)
		 * { if (request.getParameter("antibioId"+(ilop+1)) != null &&
		 * !request.getParameter("antibioId"+(ilop+1)).equals("")) {
		 * senArray[ilop] = new
		 * Integer(request.getParameter("antibioId"+(ilop+1)));
		 * //System.out.println(senArray[ilop]+"senArray[ilop]"); } }
		 * infoMap.put("senArray",senArray); String [] resArray= new String[sq];
		 * for(int ilop=0;ilop<sq;ilop++) { if
		 * (request.getParameter("sensitivityResult"+(ilop+1)) != null &&
		 * !request.getParameter("sensitivityResult"+(ilop+1)).equals("")) {
		 * resArray[ilop]
		 * =(String)request.getParameter("sensitivityResult"+(ilop+1));
		 * //System.out.println("res[ilop]======="+resArray[ilop]); } }
		 * infoMap.put("resArray",resArray); }
		 */
		boolean flag = false;
		try {
			flag = investigationHandlerService
					.submitResultEntryModificationForSensitivity(infoMap);
			if (flag == false) {
				messageTOBeVisibleToTheUser = "Successfully Validated the result.Do you want to print.";
			} else {
				messageTOBeVisibleToTheUser = "Some Problem occured.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();

		dataMap.put("deptId", deptId);
		dataMap.put("resultId", resultIdStringForTemplate);

		if (!resultIdStringForTemplate.equals("")) {
			map = investigationHandlerService.getResultEntryDetailsLab(dataMap);
			map.put("resultId", resultIdStringForTemplate);
			List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
			if (map.get("resultList") != null) {
				resultList = (List<DgResultEntryHeader>) map.get("resultList");
				if (resultList.size() > 0) {
					jsp = RESULT_ENTRY_VALUES_FOR_CORRECTION_LAB + ".jsp";
				} else {
					jsp = MESSAGE_FOR_RESULT_ENTRY_CORRECTION_LAB + ".jsp";
				}
			}
		}
		map.put("resultIdStringForTemplate", resultIdStringForTemplate);

		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// -------------------------------End Methods developed by
	// Vivek------------------------------------------
	// -------------------------------------------------------------------------
	// -------------------------------------------------------------------------
	// ------------------- methods for updating Patient film Size
	// -----------------------------

	public ModelAndView showPatientUpdateFilmJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		String deptName = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		dataMap.put("deptId", deptId);
		mapForDs.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		detailsMap = investigationHandlerService
				.getDetailsForResultValidation(dataMap);
		patientMap = investigationHandlerService
				.getResultValidationAcceptedGrid(mapForDs);
		String jsp = UPDATE_PATINET_FILM_SIZE;
		jsp += ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// /////////////////////////////////////////////////////////////////////////

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForUpdateFilmSize(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		int chargeCodeId = 0;
		String pType = "";
		String serPersonFName = "";
		String patientFName = "";
		Date fromDate = new Date();
		;
		Date toDate = new Date();
		String adNo = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		int hinId = 0;
		int resultId = 0;
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		String userName = "";
		String diagnosisNo = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		mapForDs.put("deptId", deptId);
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		try {

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
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
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));
				mapForDs.put("chargeCodeId", chargeCodeId);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
			}
			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}

			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				mapForDs.put("departmentId", departmentId);
			}

			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(SAMPLE_ID) != null
					&& !(request.getParameter(SAMPLE_ID).equals("0"))) {
				sampleId = Integer.parseInt(request.getParameter(SAMPLE_ID));
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				orderType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("orderType", orderType);
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
			if (request.getParameter(RESULT_ID) != null
					&& !(request.getParameter(RESULT_ID).equals("0"))) {
				resultId = Integer.parseInt(request.getParameter(RESULT_ID));
				mapForDs.put("resultId", resultId);
			}

			if (request.getParameter(DIAGNOSIS_NO) != null
					&& !(request.getParameter(DIAGNOSIS_NO).equals(""))) {
				diagnosisNo = request.getParameter(DIAGNOSIS_NO);
				mapForDs.put("diagnosisNo", diagnosisNo);
			}
			mapForDs.put("identifySource", "filmUpdation");
		} catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = investigationHandlerService
				.getPatientDetailsForResultValidation(mapForDs);
		String jsp = "";
		int id = 0;
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDetailsList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDetailsList");
		}
		Map<String, Object> diagMap = new HashMap<String, Object>();
		if (resultId != 0) {

			map = investigationHandlerService.getResultEntryDetails(resultId,
					deptId);
			List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
			if (map.get("resultList") != null) {
				resultList = (List<DgResultEntryHeader>) map.get("resultList");
			}
			Set<DgResultEntryDetail> dgDetailSet = new HashSet<DgResultEntryDetail>();
			for (DgResultEntryHeader dgHeader : resultList) {
				dgDetailSet = dgHeader.getDgResultEntryDetails();
				id = dgHeader.getId();
			}
			if (resultList != null && resultList.get(0).getResultType() != null
					&& resultList.get(0).getResultType().equals("S")) {
				jsp = "resultValidationForSenstivity.jsp";
			} else {
				for (DgResultEntryDetail dgResEntry : dgDetailSet) {
					if (dgResEntry.getInvestigation().getInvestigationType()
							.equals("s")) {
						jsp = RESULT_VALIDATION_ENTRY_SINGLE_PARAMETER + ".jsp";
					} else if (dgResEntry.getInvestigation()
							.getInvestigationType().equals("m")) {
						jsp = RESULT_VALIDATION_ENTRY + ".jsp";
					} else if (dgResEntry.getInvestigation()
							.getInvestigationType().equals("t")) {
						jsp = RESULT_VALIDATION_ENTRY_TEMPLATE + ".jsp";
					}
				}
			}
		} else {
			detailsMap = investigationHandlerService
					.getDetailsForResultValidation(dataMap);
			jsp = UPDATE_PATINET_FILM_SIZE + ".jsp";
		}

		patientMap.put("patientList", patientList);
		map.put("resultId", resultId);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("id", id);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// ////////////////////////////////////////////////////////////////////////////

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForFilmValidation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		int chargeCodeId = 0;

		String serPersonFName = "";
		String patientFName = "";
		Date fromDate = new Date();
		;
		Date toDate = new Date();
		String adNo = "";
		int departmentId = 0;

		int subChargeCodeId = 0;
		String orderType = "";
		int hinId = 0;
		int resultId = 0;
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		String userName = "";
		String diagnosisNo = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		mapForDs.put("deptId", deptId);
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);

		String jsp = "";
		int id = 0;

		if (request.getParameter(RESULT_ID) != null
				&& !(request.getParameter(RESULT_ID).equals("0"))) {
			resultId = Integer.parseInt(request.getParameter(RESULT_ID));
		}

		Map<String, Object> diagMap = new HashMap<String, Object>();
		if (resultId != 0) {

			map = investigationHandlerService.getResultEntryDetails(resultId,
					deptId);
			List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
			if (map.get("resultList") != null) {
				resultList = (List<DgResultEntryHeader>) map.get("resultList");
			}
			Set<DgResultEntryDetail> dgDetailSet = new HashSet<DgResultEntryDetail>();
			for (DgResultEntryHeader dgHeader : resultList) {
				dgDetailSet = dgHeader.getDgResultEntryDetails();
				id = dgHeader.getId();
			}

			/*
			 * if(resultList!=null && resultList.get(0).getResultType()!=null &&
			 * resultList.get(0).getResultType().equals("S") ){ jsp =
			 * "resultValidationForSenstivity.jsp"; }else{
			 * for(DgResultEntryDetail dgResEntry :dgDetailSet) {
			 * if(dgResEntry.getInvestigation
			 * ().getInvestigationType().equals("s")){ jsp =
			 * RESULT_VALIDATION_ENTRY_SINGLE_PARAMETER+".jsp"; }else
			 * if(dgResEntry
			 * .getInvestigation().getInvestigationType().equals("m")){ jsp =
			 * RESULT_VALIDATION_ENTRY+".jsp"; }else
			 * if(dgResEntry.getInvestigation
			 * ().getInvestigationType().equals("t")){ jsp =
			 * RESULT_VALIDATION_ENTRY_TEMPLATE+".jsp"; } } }
			 */

		}
		jsp = UPDATE_FILM_SIZE_POP_UP;

		map.put("resultId", resultId);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("id", id);
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////

	public ModelAndView updatePatientFilmSize(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> mapForUpdateFilmDetailDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<String> filmSizeUsedList = new ArrayList<String>();
		List<Integer> filmUsedList = new ArrayList<Integer>();

		String serviceNo = "";
		String hinNo = "";
		int chargeCodeId = 0;

		String serPersonFName = "";
		String patientFName = "";
		Date fromDate = new Date();
		;
		Date toDate = new Date();
		String adNo = "";
		int departmentId = 0;

		int subChargeCodeId = 0;
		String orderType = "";
		int hinId = 0;
		int resultId = 0;
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		String userName = "";
		String diagnosisNo = "";
		String message = "";

		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("deptName", deptName);
		boolean saved = false;

		String jsp = "";
		int id = 0;

		if (request.getParameter(RESULT_ID) != null
				&& !(request.getParameter(RESULT_ID).equals("0"))) {
			resultId = Integer.parseInt(request.getParameter(RESULT_ID));
		}

		if (resultId != 0) {
			map = investigationHandlerService.getResultEntryDetails(resultId,
					deptId);
			List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
			if (map.get("resultList") != null) {
				resultList = (List<DgResultEntryHeader>) map.get("resultList");
			}
			Set<DgResultEntryDetail> dgDetailSet = new HashSet<DgResultEntryDetail>();
			DgResultEntryHeader dgResultEntryHeader = resultList.get(0);

			for (DgResultEntryHeader dgHeader : resultList) {
				dgDetailSet = dgHeader.getDgResultEntryDetails();
				id = dgHeader.getId();
			}

			int hdb = 1;
			String impression = "";
			Integer dgResultEntryDetailId = 0;
			if (Integer.parseInt(request.getParameter("hdb")) != 1) {
				hdb = Integer.parseInt(request.getParameter("hdb"));
			}
			if (request.getParameter("dgResultEntryDetailId") != null) {
				dgResultEntryDetailId = Integer.parseInt(request
						.getParameter("dgResultEntryDetailId"));
			}
			if (request.getParameter(IMPRESSION) != null) {
				impression = request.getParameter(IMPRESSION);
			}

			int j = 1;
			int noOfRows = 0;
			int filmUsed = 0;
			String filmSizeUsed = "";
			for (int i = 0; i < hdb; i++) {
				if (request.getParameter("filmSizeUsed" + j) != null
						&& !request.getParameter("filmSizeUsed" + j).equals("")) {
					if (request.getParameter("filmUsed" + j) != null
							&& !request.getParameter("filmUsed" + j).equals("")) {
						filmSizeUsed = request.getParameter("filmSizeUsed" + j);
						filmSizeUsedList.add(filmSizeUsed);

						filmUsed = Integer.parseInt(request
								.getParameter("filmUsed" + j));
						filmUsedList.add(filmUsed);
						noOfRows++;
					}
				}
				j++;
			}
			hdb = noOfRows;
			mapForUpdateFilmDetailDs.put("filmSizeUsedList", filmSizeUsedList);
			mapForUpdateFilmDetailDs.put("filmUsedList", filmUsedList);
			mapForUpdateFilmDetailDs.put("hdb", hdb);
			mapForUpdateFilmDetailDs.put("dgResultEntryDetailId",
					dgResultEntryDetailId);
			mapForUpdateFilmDetailDs.put("dgResultEntryHeaderId", resultId);
			mapForUpdateFilmDetailDs.put("impression", impression);

			map = investigationHandlerService
					.updateDgResultEntryHeader(mapForUpdateFilmDetailDs);

			saved = (Boolean) map.get("saved");

		}

		detailsMap = new HashMap<String, Object>();
		dataMap = new HashMap<String, Object>();
		patientMap = new HashMap<String, Object>();
		mapForDs = new HashMap<String, Object>();

		dataMap.put("deptId", deptId);
		mapForDs.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		detailsMap = investigationHandlerService
				.getDetailsForResultValidation(dataMap);
		patientMap = investigationHandlerService
				.getResultValidationGrid(mapForDs);

		jsp = "msgForFilmUpdate";
		// jsp += ".jsp";
		map.put("message", message);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);

		/*
		 * jsp = UPDATE_FILM_SIZE_POP_UP;
		 * 
		 * map.put("resultId", resultId); map.put("detailsMap", detailsMap);
		 * map.put("patientMap", patientMap); map.put("id", id);
		 * map.put("contentJsp", jsp); return new ModelAndView(jsp, "map", map);
		 */

	}

	public ModelAndView showValidatedConfidentialOrderSearch(
			HttpServletRequest request, HttpServletResponse response) {

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}

		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		String deptName = "";
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();

		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		mapForDs.put("fromDate", new Date());
		mapForDs.put("toDate", new Date());
		mapForDs.put("departmentId", deptId);

		patientMap = investigationHandlerService
				.getAllResultValidatedConfidentialOrders(mapForDs);

		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDetailsList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDetailsList");
		}
		patientMap.put("patientList", patientList);
		map.put("patientMap", patientMap);

		detailsMap = investigationHandlerService
				.getDetailsForResultValidation(dataMap);
		String jsp = VALIDATED_CONFIDENTIAL_ORDER_SEARCH_JSP;
		;
		jsp += ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchValidatedConfidentialOrderDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		int chargeCodeId = 0;
		String pType = "";
		String serPersonFName = "";
		String patientFName = "";
		Date fromDate = new Date();
		;
		Date toDate = new Date();
		String adNo = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		int hinId = 0;
		int resultId = 0;
		int deptId = 0;
		int hospitalId = 0;
		String deptName = "";
		String userName = "";
		String orderNo = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		try {

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}

			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(CHARGE_CODE_ID) != null
					&& !(request.getParameter(CHARGE_CODE_ID).equals("0"))) {
				chargeCodeId = Integer.parseInt(request
						.getParameter(CHARGE_CODE_ID));
				mapForDs.put("chargeCodeId", chargeCodeId);
			}
			if (request.getParameter(SUB_CHARGECODE_ID) != null
					&& !(request.getParameter(SUB_CHARGECODE_ID).equals("0"))) {
				subChargeCodeId = Integer.parseInt(request
						.getParameter(SUB_CHARGECODE_ID));
				mapForDs.put("subChargeCodeId", subChargeCodeId);
			}
			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}

			// if(request.getParameter(DEPARTMENT_ID) != null &&
			// !(request.getParameter(DEPARTMENT_ID).equals("0"))){
			// departmentId=
			// Integer.parseInt(request.getParameter(DEPARTMENT_ID)) ;
			// mapForDs.put("departmentId", departmentId);
			// }
			mapForDs.put("departmentId", deptId);
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(SAMPLE_ID) != null
					&& !(request.getParameter(SAMPLE_ID).equals("0"))) {
				sampleId = Integer.parseInt(request.getParameter(SAMPLE_ID));
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				orderType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("orderType", orderType);
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

			if (request.getParameter(RESULT_ID) != null
					&& !(request.getParameter(RESULT_ID).equals("0"))) {
				resultId = Integer.parseInt(request.getParameter(RESULT_ID));
				mapForDs.put("resultId", resultId);
			}

			if (request.getParameter(ORDER_NO) != null
					&& !(request.getParameter(ORDER_NO).equals(""))) {
				orderNo = request.getParameter(ORDER_NO);
				mapForDs.put("orderNo", orderNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = investigationHandlerService
				.getAllResultValidatedConfidentialOrders(mapForDs);
		String jsp = "";
		int id = 0;
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDetailsList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDetailsList");
		}
		detailsMap = investigationHandlerService
				.getDetailsForResultValidation(dataMap);
		jsp = VALIDATED_CONFIDENTIAL_ORDER_SEARCH_JSP + ".jsp";

		patientMap.put("patientList", patientList);
		map.put("detailsMap", detailsMap);
		map.put("deptId", deptId);
		map.put("patientMap", patientMap);
		map.put("id", id);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView populateDgResultEntryHeader(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		session = request.getSession();

		Map<String, Object> dataMap = new HashMap<String, Object>();

		patientMap = investigationHandlerService
				.populateAllDgresultEntryHeader(mapForDs);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printConfidentialResultValidation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap1 = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		String query = "";
		int srn = 0;
		String src = "";
		int id = 0;
		String crit = "";
		String deptName = "";
		session = request.getSession();
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		try {
			if (request.getParameter("counta") != null) {
				srn = Integer.parseInt(request.getParameter("counta"));
			}
			src = ("parent");
			if ((request.getParameter(src) != null)
					&& !(request.getParameter(src).equals("0"))) {
				requestParameters.put("orderNo", request.getParameter(src));
				query = "where dg_orderhd.`order_no` = '"
						+ (request.getParameter(src)) + "'";
				// /////////////////////////
				detailsMap1 = investigationHandlerService
						.getAllValidatedTestForOrder(requestParameters);
				dgResultdetailList = (List<DgResultEntryDetail>) detailsMap1
						.get("resultList");
				map.put("dgResultdetailList", dgResultdetailList);
				map.put("detailsMap1", detailsMap1);
				map.put("deptName", deptName);
				// /////////////////////////////
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("finalConfidentialResultPrintForRadiology",
				"map", map);
	}

	public ModelAndView printConfidentialResultValidationLab(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap1 = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		Map<String, Object> resultDetailsMap = new HashMap<String, Object>();
		List<Map<String, Object>> resultDetailsMapList = new ArrayList<Map<String, Object>>();

		String query = "";
		int srn = 0;
		String src = "";
		int id = 0;
		String crit = "";
		String deptName = "";
		int deptId = 0;
		session = request.getSession();
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		try {
			if (request.getParameter("counta") != null) {
				srn = Integer.parseInt(request.getParameter("counta"));
			}
			src = ("parent");
			if ((request.getParameter(src) != null)
					&& !(request.getParameter(src).equals("0"))) {
				requestParameters.put("orderNo", request.getParameter(src));
				detailsMap1 = investigationHandlerService
						.getAllValidatedTestForLabOrderNoWise(requestParameters);

				map.put("detailsMap1", detailsMap1);
				map.put("deptName", deptName);
				// /////////////////////////////
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("finalConfidentialResultPrintForLab", "map",
				map);
	}

	public ModelAndView showResultEntryReportJsp(HttpServletRequest request,
			HttpServletResponse response) {

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map = investigationHandlerService.getDetailsForSearch();
		jsp = RESULT_ENTRY_REPORT_SAPARATE + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchProvisionalResultEntryDetails(
			HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> resultEntryDetailMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientDiagnosisMap = new HashMap<String, Object>();

		String hinNo = "";
		int wardId = 0;
		String adNo = "";
		int inpatientId = 0;
		String serviceNo = "";
		session = request.getSession();
		try {

			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(WARD_ID) != null
					&& !(request.getParameter(WARD_ID).equals("0"))) {
				wardId = Integer.parseInt(request.getParameter(WARD_ID));
				mapForDs.put("wardId", wardId);
			}
			if (request.getParameter("inpatientId") != null) {
				inpatientId = Integer.parseInt(request
						.getParameter("inpatientId"));
				mapForDs.put("inpatientId", inpatientId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		resultEntryDetailMap = investigationHandlerService
				.searchProvisionalResultEntryDetails(mapForDs);
		map = investigationHandlerService.getDetailsForSearch();
		jsp = RESULT_ENTRY_REPORT_SAPARATE + ".jsp";

		map.put("resultEntryDetailMap", resultEntryDetailMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showFinalResultEntryReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map = investigationHandlerService.getDetailsForSearch();
		jsp = FINAL_RESULT_ENTRY_REPORT_SAPARATE + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchFinalResultEntryDetails(
			HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> resultEntryDetailMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientDiagnosisMap = new HashMap<String, Object>();

		String hinNo = "";
		int wardId = 0;
		String adNo = "";
		int inpatientId = 0;
		String serviceNo = "";
		session = request.getSession();
		try {

			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(WARD_ID) != null
					&& !(request.getParameter(WARD_ID).equals("0"))) {
				wardId = Integer.parseInt(request.getParameter(WARD_ID));
				mapForDs.put("wardId", wardId);
			}
			if (request.getParameter("inpatientId") != null) {
				inpatientId = Integer.parseInt(request
						.getParameter("inpatientId"));
				mapForDs.put("inpatientId", inpatientId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		resultEntryDetailMap = investigationHandlerService
				.searchFinalResultEntryDetails(mapForDs);
		map = investigationHandlerService.getDetailsForSearch();
		jsp = FINAL_RESULT_ENTRY_REPORT_SAPARATE + ".jsp";

		map.put("resultEntryDetailMap", resultEntryDetailMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printFinalResultEntry(HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException,
			IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		String resultNo = "";
		String resultType = "";
		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		int userId = 0;
		String deptName = "";
		int resultIdForReport = 0;
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		session = request.getSession();

		try {

			if (session.getAttribute("hospitalId") != null)
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			if (session.getAttribute("deptId") != null)
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			if (session.getAttribute("deptName") != null)
				deptName = (String) session.getAttribute("deptName");
			if (session.getAttribute("userId") != null)
				userId = Integer.parseInt("" + session.getAttribute("userId"));
			if (request.getParameter(RESULT_NO) != null) {
				resultNo = request.getParameter(RESULT_NO);
			}
			if (request.getParameter(RESULT_TYPE) != null) {
				resultType = request.getParameter(RESULT_TYPE);
			}
			if (request.getParameter("resultIdForReport") != null
					&& !request.getParameter("resultIdForReport").equals("")) {
				resultIdForReport = Integer.parseInt(request
						.getParameter("resultIdForReport"));

				mapForDs.put("resultIdForReport", resultIdForReport);
			}

			Map<String, Object> detailsMap1 = new HashMap<String, Object>();
			List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();

			detailsMap1 = investigationHandlerService
					.getProvisionalResultEntryDetailsForTemplate(
							resultIdForReport, deptId);
			dgResultdetailList = (List<DgResultEntryDetail>) detailsMap1
					.get("resultList");
			map.put("dgResultdetailList", dgResultdetailList);
			map.put("detailsMap1", detailsMap1);
			map.put("deptName", deptName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("resultValidationPrint", "map", map);

	}

	public ModelAndView showPatientHistory(HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException,
			IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		String resultNo = "";
		String resultType = "";
		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		int userId = 0;

		int investigationId = 0;
		int hinId = 0;

		String deptName = "";
		int resultIdForReport = 0;

		session = request.getSession();
		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
				mapForDs.put("hospitalId", hospitalId);
			}
			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
				mapForDs.put("deptId", deptId);
			}
			if (session.getAttribute("deptName") != null) {
				deptName = (String) session.getAttribute("deptName");
				mapForDs.put("deptName", deptName);
			}
			if (session.getAttribute("userId") != null) {
				userId = Integer.parseInt("" + session.getAttribute("userId"));
				mapForDs.put("userId", userId);
			}
			if (request.getParameter("investigationIdSingleValueSingleTest") != null) {
				investigationId = Integer.parseInt(request
						.getParameter("investigationIdSingleValueSingleTest"));
				mapForDs.put("investigationId", investigationId);
			}
			if (request.getParameter(HIN_ID) != null) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}

			Map<String, Object> detailsMap = new HashMap<String, Object>();
			List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();

			detailsMap = investigationHandlerService
					.getPatientHistory(mapForDs);
			jsp = "patientHistoryPrint";
			jsp = jsp + ".jsp";
			map.put("detailsMap", detailsMap);
			map.put("investigationId", investigationId);
			map.put("hinId", hinId);
			map.put("contentJsp", jsp);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPrintResultEntryForLab(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> Parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap1 = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		Map<String, Object> resultDetailsMap = new HashMap<String, Object>();
		List<Map<String, Object>> resultDetailsMapList = new ArrayList<Map<String, Object>>();

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}

		HttpSession session = request.getSession();
		String[] idsArray = new String[0];
		String deptName = "";
		String jsp = "";
		String combinedIds = "";
		int deptId = 0;
		Integer dgSampleHeaderId = 0;
		Integer subChargeId = 0;
		
		String formSubmitFrom ="HAL";
		
		if (request.getParameter("formSubmitFrom") != null) 
		{
			formSubmitFrom = request.getParameter("formSubmitFrom");
		}
		
		

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (request.getParameter("combinedIds") != null) {
			combinedIds = request.getParameter("combinedIds");
			Parameters.put("combinedIds", combinedIds);
		}
		if (!combinedIds.equals("")) {
			idsArray = combinedIds.split(",");

			dgSampleHeaderId = Integer.parseInt(idsArray[0]);
			Parameters.put("dgSampleHeaderId", dgSampleHeaderId);
			subChargeId = Integer.parseInt(idsArray[1]);
			Parameters.put("subChargeId", subChargeId);
		}
		
		if(!formSubmitFrom.equalsIgnoreCase("HAL"))
		{
			Parameters.put("resultStatus", "A");
		}
		else
		{
			Parameters.put("resultStatus", "P");
		}
		

		detailsMap1 = investigationHandlerService
				.getProvisionalReportDetailsOrderNoWiseLab(Parameters);
		//Map<String,Object> detailsMap=new HashMap<String,Object>();
		//detailsMap = investigationHandlerService.getConnectionForReport();
		detailsMap1.put("flagForConfidential", "y");
		map.put("detailsMap1", detailsMap1);
		map.put("deptName", deptName);
		//HMSUtil.generateReport("viewResultEntryPrintOrderNoWiseLab", Parameters,(Connection)detailsMap.get("conn"),response, getServletContext());
		return new ModelAndView(VIEW_RESULT_ENTRY_PRINT_ORDER_NO_WISE_LAB,
				"map", map);
		//return null;
	}

	public ModelAndView showResultEntryReportSearchJsp(
			HttpServletRequest request, HttpServletResponse response) {

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map = investigationHandlerService.getDetailsForSearch();
		jsp = SEARCH_RESULT_ENTRY_LAB + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchProvisionalResultEntryDetailsLab(
			HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> resultEntryDetailMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientDiagnosisMap = new HashMap<String, Object>();

		String hinNo = "";
		int wardId = 0;
		int deptId = 0;
		String adNo = "";
		int inpatientId = 0;
		String serviceNo = "";
		session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			mapForDs.put("deptId", deptId);
		}

		try {

			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(WARD_ID) != null
					&& !(request.getParameter(WARD_ID).equals("0"))) {
				wardId = Integer.parseInt(request.getParameter(WARD_ID));
				mapForDs.put("wardId", wardId);
			}
			if (request.getParameter("inpatientId") != null) {
				inpatientId = Integer.parseInt(request
						.getParameter("inpatientId"));
				mapForDs.put("inpatientId", inpatientId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		resultEntryDetailMap = investigationHandlerService
				.searchProvisionalResultEntryDetailsLab(mapForDs);
		map = investigationHandlerService.getDetailsForSearch();
		jsp = SEARCH_RESULT_ENTRY_LAB + ".jsp";

		map.put("resultEntryDetailMap", resultEntryDetailMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showSaparatePrintForResultEntryLab(
			HttpServletRequest request, HttpServletResponse response)
			throws IllegalStateException, IOException {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap1 = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		Map<String, Object> resultDetailsMap = new HashMap<String, Object>();
		List<Map<String, Object>> resultDetailsMapList = new ArrayList<Map<String, Object>>();

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}

		HttpSession session = request.getSession();
		String[] idsArray = new String[0];
		String deptName = "";
		String jsp = "";
		String combinedIds = "";
		int deptId = 0;
		String combinedIdsForReport = "";
		Integer dgSampleHeaderId = 0;
		Integer subChargeId = 0;

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (request.getParameter("combinedIdsForReport") != null) {
			combinedIdsForReport = request.getParameter("combinedIdsForReport");
			requestParameters.put("resultId", combinedIdsForReport);
		}
		requestParameters.put("resultStatusRequired", "P");

		detailsMap1 = investigationHandlerService
				.getDetailsForFinalReportByOrderNoLab(requestParameters);

		map.put("detailsMap1", detailsMap1);
		map.put("deptName", deptName);
		return new ModelAndView(VIEW_RESULT_ENTRY_PRINT_ORDER_NO_WISE_LAB,
				"map", map);
	}

	public ModelAndView showResultValidationReportSearchJsp(
			HttpServletRequest request, HttpServletResponse response) {

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map = investigationHandlerService.getDetailsForSearch();
		jsp = SEARCH_RESULT_VALIDATION_LAB + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchFinalResultEntryDetailsLab(
			HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> resultEntryDetailMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientDiagnosisMap = new HashMap<String, Object>();

		String hinNo = "";
		int wardId = 0;
		int deptId = 0;
		String adNo = "";
		int inpatientId = 0;
		String serviceNo = "";
		session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			mapForDs.put("deptId", deptId);
		}

		try {

			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(WARD_ID) != null
					&& !(request.getParameter(WARD_ID).equals("0"))) {
				wardId = Integer.parseInt(request.getParameter(WARD_ID));
				mapForDs.put("wardId", wardId);
			}
			if (request.getParameter("inpatientId") != null) {
				inpatientId = Integer.parseInt(request
						.getParameter("inpatientId"));
				mapForDs.put("inpatientId", inpatientId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		resultEntryDetailMap = investigationHandlerService
				.searchFinalResultEntryDetailsLab(mapForDs);
		map = investigationHandlerService.getDetailsForSearch();
		jsp = SEARCH_RESULT_VALIDATION_LAB + ".jsp";

		map.put("resultEntryDetailMap", resultEntryDetailMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showSaparatePrintForResultValidationLab(
			HttpServletRequest request, HttpServletResponse response)
			throws IllegalStateException, IOException {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap1 = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		Map<String, Object> resultDetailsMap = new HashMap<String, Object>();
		List<Map<String, Object>> resultDetailsMapList = new ArrayList<Map<String, Object>>();

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}

		HttpSession session = request.getSession();
		String[] idsArray = new String[0];
		String deptName = "";
		String jsp = "";
		String combinedIds = "";
		int deptId = 0;
		String combinedIdsForReport = "";
		Integer dgSampleHeaderId = 0;
		Integer subChargeId = 0;

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (request.getParameter("combinedIdsForReport") != null) {
			combinedIdsForReport = request.getParameter("combinedIdsForReport");
			requestParameters.put("resultId", combinedIdsForReport);
		}
		// requestParameters.put("resultStatusRequired", "P");

		detailsMap1 = investigationHandlerService
				.getDetailsForFinalReportByOrderNoLab(requestParameters);

		map.put("detailsMap1", detailsMap1);
		map.put("deptName", deptName);
		return new ModelAndView(VIEW_RESULT_VALIDATION_PRINT_BY_ORDER_NO_LAB,
				"map", map);
	}


	public ModelAndView printResultPrintingReport(HttpServletRequest request,
				HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> parameters = new HashMap<String, Object>();
			Map<String, Object> requestParameters = new HashMap<String, Object>();
			int srn = 0;
			String src = "";
			int id = 0;
			String crit = "";
			String deptName = "";
			int deptId = 0;
			String resultNo = "";
			String resultType = "";

			session = request.getSession();

			/*
			 * if (request.getParameter(RESULT_NO) != null) { resultNo =
			 * request.getParameter(RESULT_NO); }
			 */
			if (request.getParameter(RESULT_TYPE) != null) {
				resultType = request.getParameter(RESULT_TYPE);
			}

			/*
			 * if (session.getAttribute("deptId") != null) { deptId =
			 * Integer.parseInt("" + session.getAttribute("deptId")); }
			 */

			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}

			try {
				if (request.getParameter("counta") != null) {
					srn = Integer.parseInt(request.getParameter("counta"));
				}
				src = ("parent");
				if ((request.getParameter(src) != null)
						&& !(request.getParameter(src).equals(""))) {
					resultNo = request.getParameter(src);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			detailsMap = investigationHandlerService.getConnectionForReport();
			parameters.put("order_no", resultNo);
			parameters.put("resultType", resultType);
			parameters.put("dept_id", deptId);
			HMSUtil.generateReport("print_report", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
			/*
			 * try { if (resultType.equalsIgnoreCase("s")) {
			 * HMSUtil.generateReport("inv_Result_Single_val", parameters,
			 * (Connection) detailsMap.get("conn"), response, getServletContext());
			 * } else if (resultType.equalsIgnoreCase("m")) {
			 * HMSUtil.generateReport("inv_Result_Mul_val", parameters, (Connection)
			 * detailsMap.get("conn"), response, getServletContext()); } else if
			 * (resultType.equalsIgnoreCase("t")) {
			 * HMSUtil.generateReport("inv_Result_Tem_val", parameters, (Connection)
			 * detailsMap.get("conn"), response, getServletContext()); }
			 *
			 * } catch (Exception e) { e.printStackTrace(); }
			 */
			return null;
		}
	
	/**
	 * Method for upload document for Radiology and ECG
	 * Ritu Sahu
	 * 20 Aug 2012
	 */
	public ModelAndView openPopupForUpload(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String diagNo = "";
		String hin_no = "";
		int hospitalId;
		int visitId = 0;
		int hinId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			map.put("hospitalId", hospitalId);
		}
		if (request.getParameter("diagNo") != null) {
			diagNo = (String) request.getParameter("diagNo");
			map.put("diagNo", diagNo);
		}
		if (request.getParameter("hinId") != null && !request.getParameter("hinId").equals("0")) {
			hinId = Integer.parseInt(request.getParameter("hinId"));
			map.put("hinId", hinId);
		}
		int resultEntryId = 0;
		if (request.getParameter("resultEntryId") != null){
			resultEntryId = Integer.parseInt(request.getParameter("resultEntryId"));
			map.put("resultEntryId", resultEntryId);
		}
		if (request.getParameter("hinNo") != null) {
			hin_no = (String) request.getParameter("hinNo");
			map.put("hinNo", hin_no);
			dataMap.put("hinNo", hin_no);
		}
		dataMap = investigationHandlerService.viewUploadInvDocuments(map); 
		
		String jsp = "inv_uploadDocument";
		
		return new ModelAndView(jsp,"map",dataMap);
	}
	public ModelAndView uploadInvDocuments(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		MultipartFormDataRequest mrequest = null;
		String fileName = null;
		String message = null;
		String diagNo = "";
		String hin_no = "";
		String fileExtension = null;
		int hospitalId;
		int visitId = 0;
		int hinId = 0;
		String userName = "";
		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {

				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		HttpSession session = request.getSession();
		if (request.getParameter("hinNo") != null) {
			hin_no = (String) request.getParameter("hinNo");
		}else if (mrequest.getParameter("hinNo") != null) {
			hin_no = (String) mrequest.getParameter("hinNo");
		}

		if (request.getParameter("diagNo") != null) {
			diagNo = (String) request.getParameter("diagNo");
			box.put("diagNo", diagNo);

		}else if (mrequest.getParameter("diagNo") != null) {
			diagNo = (String) mrequest.getParameter("diagNo");
			box.put("diagNo", diagNo);

		}

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}
		if (request.getParameter("visitId") != null
				&& !request.getParameter("visitId").equals("0")) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}else if (mrequest.getParameter("visitId") != null
				&& !mrequest.getParameter("visitId").equals("0")) {
			visitId = Integer.parseInt(mrequest.getParameter("visitId"));
		}
		if (request.getParameter("hinId") != null
				&& !request.getParameter("hinId").equals("0")) {
			hinId = Integer.parseInt(request.getParameter("hinId"));
		}else if (mrequest.getParameter("hinId") != null
				&& !mrequest.getParameter("hinId").equals("0")) {
			hinId = Integer.parseInt(mrequest.getParameter("hinId"));
		}
		Map<String, Object> uploadFileMap = new HashMap<String, Object>();
		String userHome = getServletContext().getRealPath("");
		String fileSeparator = System.getProperty("file.separator");
		String uploadURL = userHome.substring(0, userHome
				.lastIndexOf(fileSeparator))
				+ fileSeparator
				+ "HMSDocumentFolder"
				+ fileSeparator
				+ "upload" + fileSeparator;
		HMSUtil.createFolderFroDocument(hin_no, uploadURL);
		String filename = box.getString("filename");
		
		StringTokenizer strToken = new StringTokenizer(filename, ".");

		String fileNameWithoutExt = strToken.nextToken();
		fileExtension = strToken.nextToken();
		
		
		String whiteList = "*." + fileExtension;
		try {
			HMSUtil.uploadFile(mrequest, uploadURL
					+ hin_no + fileSeparator, whiteList, filename);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int inpatientId = 0;
		if (request.getParameter("inpatientId") != null){
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
			box.put("inpatientId", inpatientId);
		}
		else if (mrequest.getParameter("inpatientId") != null){
			inpatientId = Integer.parseInt(mrequest.getParameter("inpatientId"));
			box.put("inpatientId", inpatientId);
		}else{
			box.put("inpatientId", 0);
		}
		box.put("hinId", hinId);
		box.put("uploadURL", uploadURL);
		box.put("hin_no", hin_no);
		box.put("fileSeparator", fileSeparator);
		map = investigationHandlerService.uploadInvDocuments(box);
		if (map.get("dataSaved").equals(true)) {
			message = "File Uploaded Sucessfully!!";
		} else {
			message = "Data Cannot be Saved !!";
		}
		map.put("message", message);
		map.put("visitId", visitId);
		map.put("inpatientId", inpatientId);
		jsp = "inv_uploadDocument";
		title = "Upload Documents";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}
	

	
	public ModelAndView uploadAndViewDocuments(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		int departmentId = 0;
		int hospitalId = 0;
		int hinId=0;
		String flag="n";	
		String uploadFrom ="NA";
		
		 MultipartFormDataRequest mrequest = null;
	     if (MultipartFormDataRequest.isMultipartFormData(request))
	        {
	             try
	             {
	                 mrequest = new MultipartFormDataRequest(request);
	             }
	             catch (UploadException e)
	             {
	                 e.printStackTrace();
	             }
	             catch (IOException e)
	             {
	                 e.printStackTrace();
	             }
	        }
	     if(mrequest.getParameter("hinId")!=null){
	    	 hinId= Integer.parseInt((String)mrequest.getParameter("hinId"));
	       	 details.put("hinId", Integer.parseInt((String)mrequest.getParameter("hinId")));
	        }
	     
	     if(mrequest.getParameter("uploadFrom")!=null){
	    	 uploadFrom= (String)mrequest.getParameter("uploadFrom");
	       	 details.put("uploadFrom", (String)mrequest.getParameter("uploadFrom"));
	        }
	     
	     if(mrequest.getParameter("visitId")!=null){
	    	
	       	 details.put("visitId", Integer.parseInt((String)mrequest.getParameter("visitId")));
	        }
	    
	     String filename = "";
	     String uploadURL="";
	     if(uploadFrom.equalsIgnoreCase("OPD"))
	     {
	    	 uploadURL = getServletContext().getRealPath("/UploadedDocuments/OPD/"+hinId+"/");
	     }
	     if(uploadFrom.equalsIgnoreCase("IP"))
	     {
	    	 uploadURL = getServletContext().getRealPath("/UploadedDocuments/IP/"+hinId+"/");
	     }
	    
	     String comments = "";
	     String fileExtension=null;
	     
	     if (mrequest.getParameter("department") != null) {
	 		departmentId = Integer.parseInt(request.getParameter("department"));
	 	}if (departmentId!=0) {
	 		details.put("departmentId", departmentId);
	 	}
	 	if(mrequest.getParameter("fileName")!= null){
	        filename = mrequest.getParameter("fileName");
	    }

	    
	    
	    if(mrequest.getParameter("flag")!=null){
	      	 flag = (String)mrequest.getParameter("flag");
	       }
	    details.put("flag", flag);
	    
	    if( mrequest.getParameter("comments")!= null){
	        comments = mrequest.getParameter("comments");
	        details.put("comments", comments);
	    }
	    details.put("uploadURL", uploadURL);
	    
	    if(flag.equalsIgnoreCase("y"))
	    {    
	      
	            List fileUploadedList = null;           
	            details.put("filename", filename);
	            StringTokenizer strToken=new StringTokenizer(filename,".");
	            Long fileSizeLimit = RequestConstants.MAX_FILE_SIZE;
	            filename=strToken.nextToken();
	            fileExtension=strToken.nextToken();
	            String whiteList = "*."+fileExtension;             
	            fileUploadedList = HMSUtil.uploadFileMaintenance(mrequest,uploadURL, whiteList,fileSizeLimit,filename);
	    }    
	         
	        
	     map = investigationHandlerService.uploadAndViewDocuments(details);
	     String jsp = "uploadAndViewDocuments";
	     String msg="File Successfuly Uploaded.";
	     //jsp += ".jsp";
	     //map.put("contentJsp", jsp);
	     map.put("message", msg);
	     
	     return new ModelAndView(jsp, "map", map);

	}
	
	public ModelAndView viewUploadDocuments(HttpServletRequest request ,HttpServletResponse response) throws SQLException {
    	Map<String, Object> map = new HashMap<String, Object>();
    	List<UploadDocuments> uploadDocuments = new ArrayList<UploadDocuments>();
    	
    	String filename=null;
    	String fileExtension=null;
    	String viewFrom="";
    	int hinId=0;
    	int uploadedDocumentId =0;
    
    	    Map<String, Object> uploadFileMap = new HashMap<String, Object>();
    	   
    	    if(request.getParameter("uploadedDocumentId")!= null){
    	    	uploadedDocumentId = Integer.parseInt(request.getParameter("uploadedDocumentId"));
    		}
    	    
    	    
    	    uploadDocuments = investigationHandlerService.getDocumentList(uploadedDocumentId);
    	    if(request.getParameter("filename")!= null){
    			filename = request.getParameter("filename");
    		}
    	    /*
    		if(request.getParameter("filename")!= null){
    			filename = request.getParameter("filename");
    		}
    		
    		if(request.getParameter("viewFrom")!= null){
    			viewFrom = request.getParameter("viewFrom");
    		}
    		if(request.getParameter("hinId")!= null){
    			hinId = Integer.parseInt(request.getParameter("hinId"));
    		}  	
    		
    		String uploadURL = getServletContext().getRealPath("/"); // general case
    		
    		if(viewFrom.equalsIgnoreCase("OPD"))
    		{
    			uploadURL = uploadURL+"/UploadedDocuments/OPD/"+hinId+"/"; 
    		}
    		if(viewFrom.equalsIgnoreCase("IP"))
    		{
    			uploadURL = uploadURL+"/UploadedDocuments/IP/"+hinId+"/"; 
    		}*/
    		
    		//System.out.println("uploadURL="+uploadURL);
    		
    		
    		
    	    StringTokenizer st1=new StringTokenizer(filename,".");
    		filename=st1.nextToken();
    		fileExtension=st1.nextToken();
    	   
    		try
    		   {
    			   if (fileExtension =="doc" || fileExtension =="docx" )
    			   {
    			   response.setContentType( "application/vnd.ms-word" );
    			   }
    			   else if (fileExtension == "xls" || fileExtension == "xlsx")
    				   
    			   {
    			   response.setContentType( "application/vnd.ms-excel" );
    			   }
    			   else if (fileExtension == "pdf")
    			   {
    			   response.setContentType( "application/pdf" );
    			   }else if (fileExtension.trim().equalsIgnoreCase("txt"))
    			   {
    			   response.setContentType( "text/plain" );
    			   }else if (fileExtension.trim().equalsIgnoreCase("ppt"))
    			   {
    			   response.setContentType( "application/ppt" );
    			   }else if (fileExtension == "png" )
    			   {
    			   response.setContentType( "image/png" );
    			   }else if (fileExtension == "jpeg" )
    			   {
    				   
    			   response.setContentType( "image/jpeg" );
    			   }else if (fileExtension == "wbmp" )
    			   {
    			   response.setContentType( "image/vnd.wap.wbmp" );
    			   }else if (fileExtension == "gif" )
    			   {
    			   response.setContentType( "image/gif");
    			   }else if (fileExtension == "jpg" )
    			   {
    			   response.setContentType( "image/jpg" );
    			   }
    			   else
    			   {
    			   response.setContentType( "application/octet-stream" );
    			   }
    		   
    		   response.setHeader ("Content-Disposition", "attachment;filename="+java.net.URLEncoder.encode(request.getParameter("filename"))+"");
    		   //File f = new File(uploadURL+""+filename+"."+fileExtension);
    		   for(UploadDocuments doc: uploadDocuments)
    		   {
    			   byte[] bytes = doc.getPatientDocument();
    			   Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
    			   InputStream in = blob.getBinaryStream();
                 
    	       
    	       response.getOutputStream().flush();
    	      ServletOutputStream outs = response.getOutputStream();
    	      
    	      // Create the byte array to hold the data
        	 
        
        	     int offset = 0;
        	     int numRead = 0;
        	     while (offset < bytes.length
        	    		 && (numRead=in.read(bytes, offset, bytes.length-offset)) >= 0) {
        	    	 offset += numRead;
        	     }
        
        	     if (offset < bytes.length) {
        	     }
        	     outs.write(bytes);
        	     in.close();
    	   } 
    		   }
    	   catch (IOException ioe) 
    	   {
    		   ioe.printStackTrace();
    	   }
       
    	 
    	
    		return null;
    	}
	
	
	public ModelAndView showPendingListofXRAY(HttpServletRequest request,HttpServletResponse response)
	{	
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();	
		HttpSession session = request.getSession();
		
		int deptId = 0;
		int hospitalId=0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}	

			
		jsp = "listofpendingInvestigationXRAY";
		jsp += ".jsp";
		title = "Pending List of XRAY";	
		
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptList",deptList);
			
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showPendingListofCT(HttpServletRequest request,HttpServletResponse response)
	{	
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();	
		HttpSession session = request.getSession();
		
		int deptId = 0;
		int hospitalId=0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}	

			
		jsp = "listofpendingInvestigationCT";
		jsp += ".jsp";
		title = "Pending List CT Scan";	
		
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptList",deptList);
			
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView showPendingListofUS(HttpServletRequest request,HttpServletResponse response)
	{	
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();	
		HttpSession session = request.getSession();
		
		int deptId = 0;
		int hospitalId=0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}	

			
		jsp = "listofpendingInvestigationUS";
		jsp += ".jsp";
		title = "Pending List of USG";	
		
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptList",deptList);
			
		return new ModelAndView("index", "map", map);
	}


	public ModelAndView getPendingListforRadiologyInvestigation(HttpServletRequest request,HttpServletResponse response)
		
	{
		
		Map<String,Object> map = new HashMap<String,Object>();
		List<DgOrderdt> orderList = new ArrayList<DgOrderdt>();		
		
		Box box = HMSUtil.getBox(request);	
		
		String unitType="";
		
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId =  (Integer)session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		}
		
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			box.put("deptId", deptId);
		}
		
		String flag = request.getParameter("flag"); // flag=DX/CT/US
		
		
	    box.put("flag", flag);
		
		
		
		map = investigationHandlerService.getPendingListforRadiologyInvestigation(box);
		
		if(map.get("orderList")!= null)
		{
			orderList = (List<DgOrderdt>) map.get("orderList");
		}
		
		int totalRecords = 0;
		if(map.get("totalRecords")!= null)
		{
			totalRecords = (Integer) map.get("totalRecords");
		}
		
		try
		{
			PrintWriter pw = response.getWriter();	
			
			pw.write("[");
			int counter=1;
			
			for(DgOrderdt list : orderList)
			{
				
				
			    if(counter != orderList.size())
			    {
			    	
			    	pw.write("{\"Id\": \""+list.getId()+"\",\"Date\": \""+(list.getCreatedon() != null?HMSUtil.changeDateToddMMyyyy(list.getCreatedon()):"")+"\",\"Age\": \""+(list.getOrderhd().getHin().getDateOfBirth()!= null?HMSUtil.calculateAge(list.getOrderhd().getHin().getDateOfBirth()):"")+"\",\"PatientId\": \""+(list.getOrderhd().getHin() != null?Integer.parseInt(list.getOrderhd().getHin().getHinNo()):"")+"\",\"Sex\": \""+(list.getOrderhd().getHin().getSex() != null?list.getOrderhd().getHin().getSex().getAdministrativeSexName():"")+"\",\"Name\": \""+(list.getOrderhd().getHin()!=null?list.getOrderhd().getHin().getPFirstName():"")+"\",\"Relation\":\""+(list.getOrderhd().getHin() != null?list.getOrderhd().getHin().getRelation().getRelationName():"")+"\",\"Investigation\":\""+(list.getInvestigation() != null?list.getInvestigation().getInvestigationName():"")+"\",\"Dept\": \""+(list.getOrderhd().getDepartment()!= null?list.getOrderhd().getDepartment().getDepartmentName():"")+"\",\"Doctor\": \""+(list.getOrderhd().getPrescribedBy()!= null?list.getOrderhd().getPrescribedBy().getFirstName():"")+"\",\"totalRecords\":\""+totalRecords+"\"},");
			    	
			    }
			    else
			    {		    	
			    	pw.write("{\"Id\": \""+list.getId()+"\",\"Date\": \""+(list.getCreatedon() != null?HMSUtil.changeDateToddMMyyyy(list.getCreatedon()):"")+"\",\"Age\": \""+(list.getOrderhd().getHin().getDateOfBirth()!= null?HMSUtil.calculateAge(list.getOrderhd().getHin().getDateOfBirth()):"")+"\",\"PatientId\": \""+(list.getOrderhd().getHin() != null?Integer.parseInt(list.getOrderhd().getHin().getHinNo()):"")+"\",\"Sex\": \""+(list.getOrderhd().getHin().getSex() != null?list.getOrderhd().getHin().getSex().getAdministrativeSexName():"")+"\",\"Name\": \""+(list.getOrderhd().getHin()!=null?list.getOrderhd().getHin().getPFirstName():"")+"\",\"Relation\":\""+(list.getOrderhd().getHin() != null?list.getOrderhd().getHin().getRelation().getRelationName():"")+"\",\"Investigation\":\""+(list.getInvestigation() != null?list.getInvestigation().getInvestigationName():"")+"\",\"Dept\": \""+(list.getOrderhd().getDepartment()!= null?list.getOrderhd().getDepartment().getDepartmentName():"")+"\",\"Doctor\": \""+(list.getOrderhd().getPrescribedBy()!= null?list.getOrderhd().getPrescribedBy().getFirstName():"")+"\",\"totalRecords\":\""+totalRecords+"\"}");
			    	
			    }
			
			    counter++;		
			}
			
			
			pw.write("]");
			
			
		}
		
		catch(Exception e)
		{
			orderList.clear();
			e.printStackTrace();
		}	
		orderList.clear();
		return null;		
		

	}
	
	public ModelAndView markCompleteRadiologyInvestigation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		Box box = HMSUtil.getBox(request);
        int userId = 0;
		if (session.getAttribute("userId") != null)
		{
			userId = (Integer)session.getAttribute("userId");
			box.put("userId", userId);
	    }
		map = investigationHandlerService.markCompleteRadiologyInvestigation(box);
		String flag = "";
		if (map.get("flag") != null) {
			flag = (String) map.get("flag");
		}

		try {
			PrintWriter pw = response.getWriter();
			pw.write("success~~~" + flag);

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	
	
}