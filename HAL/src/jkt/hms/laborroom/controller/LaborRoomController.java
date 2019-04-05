package jkt.hms.laborroom.controller;


import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.PATIENT_NAME;
import static jkt.hms.util.RequestConstants.USER_ID;
import static jkt.hms.util.RequestConstants.LR_WAITING_LIST;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.LR_DETAILS_SUBMISSION_JSP;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.LR_TRANSFER_WAITING_LIST;
import static jkt.hms.util.RequestConstants.LR_PATIENT_Transfer_JSP;

/*;
import static jkt.hms.util.RequestConstants.;
*/








import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.adt.handler.ADTHandlerService;
import jkt.hms.laborroom.handler.LaborRoomHandlerService;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import ca.uhn.hl7v2.protocol.impl.ParseChecker;

public class LaborRoomController extends MultiActionController {
	
	LaborRoomHandlerService laborRoomHandlerService = null;
	ADTHandlerService adtHandlerService = null;
	String jsp = "";
	String title = "";
	String message = "";
	public ADTHandlerService getAdtHandlerService() {
		return adtHandlerService;
	}

	public void setAdtHandlerService(ADTHandlerService adtHandlerService) {
		this.adtHandlerService = adtHandlerService;
	}

	public LaborRoomHandlerService getLaborRoomHandlerService() {
		return laborRoomHandlerService;
	}

	public void setLaborRoomHandlerService(
			LaborRoomHandlerService laborRoomHandlerService) {
		this.laborRoomHandlerService = laborRoomHandlerService;
	}
	
	public ModelAndView LaborRoomWaitingList(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		

	      if (session.getAttribute(USER_ID) != null) {
				mapForDS.put(USER_ID, (Integer) session.getAttribute(USER_ID));
			}
	     
		  if (session.getAttribute(HOSPITAL_ID) != null) {
				mapForDS.put(HOSPITAL_ID, (Integer) session.getAttribute(HOSPITAL_ID));
			}
		  
			if(request.getParameter(PATIENT_NAME)!=null && !request.getParameter(PATIENT_NAME).equals(""))
			{
				mapForDS.put(PATIENT_NAME, request.getParameter(PATIENT_NAME));
			}
			if(request.getParameter(SERVICE_NO) !=null && !request.getParameter(SERVICE_NO).equals("")){
				mapForDS.put(SERVICE_NO, request.getParameter(SERVICE_NO));
			}
			map =  laborRoomHandlerService.getLRWaitingList(mapForDS);
		jsp = LR_WAITING_LIST;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showLaborRoomSubmitJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		
	      if (session.getAttribute(USER_ID) != null) {
				mapForDS.put(USER_ID, (Integer) session.getAttribute(USER_ID));
			}
	     
		  if (session.getAttribute(HOSPITAL_ID) != null) {
				mapForDS.put(HOSPITAL_ID, (Integer) session.getAttribute(HOSPITAL_ID));
			}
		  
			if(request.getParameter(PATIENT_NAME)!=null && !request.getParameter(PATIENT_NAME).equals(""))
			{
				mapForDS.put(PATIENT_NAME, request.getParameter(PATIENT_NAME));
			}
			
			if(request.getParameter(SERVICE_NO) !=null && !request.getParameter(SERVICE_NO).equals("")){
				mapForDS.put(SERVICE_NO, request.getParameter(SERVICE_NO));
			}
			
			if(request.getParameter("inpatientId") !=null && !request.getParameter("inpatientId").equals("")){
				mapForDS.put("inpatientId", Integer.parseInt(request.getParameter("inpatientId")));
			}
			
			map =  laborRoomHandlerService.showLaborRoomSubmitJsp(mapForDS);
			
		jsp = LR_DETAILS_SUBMISSION_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView addMotherBabyDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Box box=HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();	
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		int hdb = 1;
		if (Integer.parseInt(request.getParameter("hdb")) != 1) {
			hdb = Integer.parseInt(request.getParameter("hdb"));
		}
		
	
		List<Integer> itemList = new ArrayList<Integer>();
		List<String> batchList = new ArrayList<String>();
		List<Integer> issuedStockList = new ArrayList<Integer>();
		for (int j = 1; j <=hdb; j++) {
			String pvmsNo = "";
			int itemId = 0;
			if (request.getParameter("nomenclature" + j) != null && !request.getParameter("nomenclature" + j).equals("")) {

				String nomenclature = request.getParameter("nomenclature" + j);
				/*StringTokenizer strToken = new StringTokenizer(c, "[");
				String nomen= strToken.nextToken();*/
				String nomen = request.getParameter("nomenclature" + j).substring(0, request.getParameter("nomenclature" + j).indexOf("["));
				
				 int index1 = nomenclature.lastIndexOf("(");
				 int index2 = nomenclature.lastIndexOf(")");
			
				 index1++;
				 itemId =Integer.parseInt(nomenclature.substring(index1, index2));
	
				 
					String batch = "";
					if(request.getParameter("batch" + j) != null && !request.getParameter("batch" + j).equals("")){
						batch = request.getParameter("batch" + j);
					}
					
					int issuedStock = 0;
					if(request.getParameter("dosage" + j) != null && !request.getParameter("dosage" + j).equals("")){
						issuedStock = Integer.parseInt(request.getParameter("dosage" + j));
					}
					 
					  itemList.add(itemId);
					  issuedStockList.add(issuedStock);
					  batchList.add(batch);
				 
			}
		}
		
		mapForDs.put("itemList",itemList);
		mapForDs.put("issuedStockList",issuedStockList);
		mapForDs.put("batchList",batchList);
		
		int hinId = 0;
		String motherName="";
		int inpatientId = 0;
	/*	String bloodLoss = "";
		String placenta = "";
		String treatment = "";
		Date dateOnSet = new Date();
		String timeOnSet = "";
		String purperium = "";
		String motherCondition = "";
		int pulse = 0;
		int perineum = 0;
		String bP = "";
		String bp2="";
		int masEmpIdConductedBy = 0;
		int masEmpIdAssistedBy = 0;*/
		int hospitalId = 0;
/*		String additionalNotes = "";
		String complications = "";*/
		int patientTypeId=0;
		String hiNumber="";
		String bplStatus="";
		String nationalDobStatus="";
		int hinIdMother=0;
		try {

			if (session.getAttribute("hospitalId") != null){
				hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
				mapForDs.put("hospitalId", hospitalId);
			}
			if (session.getAttribute("userId") != null){
				int userId = Integer.parseInt(session.getAttribute("userId").toString());
				box.put("userId", userId);
			}
			
			if (session.getAttribute("deptId") != null){
				int deptId = Integer.parseInt(session.getAttribute("deptId").toString());
				box.put("deptId", deptId);
			}
			/*if (request.getParameter(CONDUCTED_BY) != null
					&& !(request.getParameter(CONDUCTED_BY).equals(""))) {
				masEmpIdConductedBy = Integer.parseInt(request
						.getParameter(CONDUCTED_BY));
				mapForDs.put("masEmpIdConductedBy", masEmpIdConductedBy);
			}
			if (request.getParameter(ASSISTED_BY) != null
					&& !(request.getParameter(ASSISTED_BY).equals(""))) {
				masEmpIdAssistedBy = Integer.parseInt(request
						.getParameter(ASSISTED_BY));
				mapForDs.put("masEmpIdAssistedBy", masEmpIdAssistedBy);
			}*/
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals(""))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(INPATIENT_ID) != null) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
			}
			/*if (request.getParameter(BLOOD_LOSS) != null
					&& !(request.getParameter(BLOOD_LOSS).equals(""))) {
				bloodLoss = request.getParameter(BLOOD_LOSS);
				mapForDs.put("bloodLoss", bloodLoss);
			}
			if (request.getParameter(PLACENTA) != null
					&& !(request.getParameter(PLACENTA).equals(""))) {
				placenta = request.getParameter(PLACENTA);
				mapForDs.put("placenta", placenta);
			}
			if (request.getParameter(TREATMENT) != null
					&& !(request.getParameter(TREATMENT).equals(""))) {
				treatment = request.getParameter(TREATMENT);
				mapForDs.put("treatment", treatment);
			}
			if (request.getParameter(DATE_ON_SET) != null
					&& !(request.getParameter(DATE_ON_SET).equals(""))) {
				dateOnSet = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(DATE_ON_SET));
				mapForDs.put("dateOnSet", dateOnSet);
			}
			if (request.getParameter(TIME_ON_SET) != null
					&& !(request.getParameter(TIME_ON_SET).equals(""))) {
				timeOnSet = request.getParameter(TIME_ON_SET);
				mapForDs.put("timeOnSet", timeOnSet);
			}
			if (request.getParameter(PUERPERIUM) != null
					&& !(request.getParameter(PUERPERIUM).equals(""))) {
				purperium = request.getParameter(PUERPERIUM);
				mapForDs.put("purperium", purperium);
			}
			if (request.getParameter(MOTHER_CONDITION) != null
					&& !(request.getParameter(MOTHER_CONDITION).equals(""))) {
				motherCondition = request.getParameter(MOTHER_CONDITION);
				mapForDs.put("motherCondition", motherCondition);
			}
			if (request.getParameter(PULSE) != null
					&& !(request.getParameter(PULSE).equals(""))) {
				pulse = Integer.parseInt(request.getParameter(PULSE));
				mapForDs.put("pulse", pulse);
			}
			if (request.getParameter(PERINEUM) != null
					&& !(request.getParameter(PERINEUM).equals(""))) {
				perineum = Integer.parseInt(request.getParameter(PERINEUM));
				mapForDs.put("perineum", perineum);
			}
			if (request.getParameter(BP) != null
					&& !(request.getParameter(BP).equals(""))) {
				bP = request.getParameter(BP);
				mapForDs.put("bP", bP);
			}
			if (request.getParameter("bp2") != null
					&& !(request.getParameter("bp2").equals(""))) {
				bp2 = request.getParameter("bp2");
				mapForDs.put("bp2", bp2);
			}
			
			if (request.getParameter(ADDITIONAL_NOTES) != null
					&& !(request.getParameter(ADDITIONAL_NOTES).equals(""))) {
				additionalNotes = request.getParameter(ADDITIONAL_NOTES);
				mapForDs.put("additionalNotes", additionalNotes);
			}
			if (request.getParameter(COMPLICATIONS) != null
					&& !(request.getParameter(COMPLICATIONS).equals(""))) {
				complications = request.getParameter(COMPLICATIONS);
				mapForDs.put("complications", complications);
			}*/
		
			if (request.getParameter(PATIENT_NAME) != null
					&& !(request.getParameter(PATIENT_NAME).equals(""))) {
				motherName = request.getParameter(PATIENT_NAME);
			
			}
			if (request.getParameter("hinIdMother") != null && !request.getParameter("hinIdMother").equals("0")) {
				hinIdMother = Integer.parseInt(request.getParameter("hinIdMother"));
				
			}
			
			if (request.getParameter("patientTypeId") != null && !request.getParameter("patientTypeId").equals("0")) {
				patientTypeId = Integer.parseInt(request
						.getParameter("patientTypeId"));
				
			}
			mapForDs.put("patientTypeId", patientTypeId);
			if (request.getParameter("bplStatus") != null) {
				bplStatus = request
						.getParameter("bplStatus");
				mapForDs.put("bplStatus", bplStatus);
			}
			if (request.getParameter("hiNumber") != null) {
				hiNumber = request
						.getParameter("hiNumber");
				mapForDs.put("hiNumber", hiNumber);
			}
			
			if (request.getParameter("nationalDobStatus") != null) {
				nationalDobStatus = request
						.getParameter("nationalDobStatus");
				mapForDs.put("nationalDobStatus", nationalDobStatus);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	
		mapForDs.put("box", box);
		map = laborRoomHandlerService.addMotherDetails(mapForDs);
		String message = "";
		if(map.get("msg")!=null)
		 message= (String)map.get("msg");
		
		
		
		//message = "Baby Details Added Successfully !!";
		
		jsp = "msg_baby" + ".jsp";
		map.put("message", message);
		map.put("hinIdMother", hinIdMother);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}
	
	public void displayAU(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem>itemMasterList = new ArrayList<MasStoreItem>();
		String pvmsNo ="";
		String age = "";
		HttpSession session = request.getSession();
		int docId = (Integer)session.getAttribute("empId");
		boolean highValueMedicineFlag = false; 
		
		//System.out.println("fg "+request.getParameter("hinId"));
		
		int hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		dataMap.put("deptId",deptId);
	
		
		if(request.getParameter("pvmsNo") != null){
			pvmsNo = request.getParameter("pvmsNo");
		}
		dataMap.put("hospitalId",hospitalId);
		dataMap.put("pvmsNo",pvmsNo);
		dataMap.put("docId",docId);
		
		map = laborRoomHandlerService.displayStockNBatch(dataMap);
		if(map.get("itemMasterList") != null){
			itemMasterList=(List<MasStoreItem>)map.get("itemMasterList");
		}
		String au = "";
		String dispensingUnit = "";
		BigDecimal actualDispensingQty = new BigDecimal(0);
		String dangerousDrug = "";
		String getHighValueMedicine = "";
		if(itemMasterList.size()>0){
			MasStoreItem storeItem= itemMasterList.get(0);
			if(storeItem.getItemConversion() != null){
			 au =(String) storeItem.getItemConversion().getItemUnitName();
			}
			if(storeItem.getDispUnit() != null && !storeItem.getDispUnit().equals("")){
				dispensingUnit = storeItem.getDispUnit();
			 }
			if(storeItem.getADispQty() != null && storeItem.getADispQty().compareTo(new BigDecimal(0))>0){
				actualDispensingQty = storeItem.getADispQty();
			}
			if(storeItem.getDangerousDrug()!=null){
				dangerousDrug = storeItem.getDangerousDrug();
			}
		//code by Babita	
			if(storeItem.getHighValueDrug()!=null){
				getHighValueMedicine = storeItem.getHighValueDrug();
			}
			//end
		 }
		BigDecimal closingstock = new BigDecimal(0.0);
		if(map.get("closingstock") != null){
			closingstock= (BigDecimal)map.get("closingstock");
		}
		
		List<StoreItemBatchStock> batchList = new ArrayList<StoreItemBatchStock>();
		if(map.get("batchList") != null){
			batchList=(List<StoreItemBatchStock>)map.get("batchList");
		}
		
		String batchString = "";
		for(StoreItemBatchStock batch :batchList)
		{
			batchString += batch.getId() +"@"+ batch.getBatchNo() +"#";
		}
		
		StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			if(dispensingUnit != null && !dispensingUnit.equals("")){
				sb.append("<au>" +dispensingUnit + "</au>");
			}else{
				sb.append("<au>" +au + "</au>");
			}
			sb.append("<actualDispensingQty>" +actualDispensingQty + "</actualDispensingQty>");
			sb.append("<stock>" +closingstock + "</stock>");
			sb.append("<dangerousDrug>" +dangerousDrug + "</dangerousDrug>");
			
			sb.append("<highValueMedicine>" +getHighValueMedicine + "</highValueMedicine>");
			sb.append("<batchString>" +batchString + "</batchString>");
		    sb.append("</item>");
	

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ModelAndView transferPatientWaitingList(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		
	      if (session.getAttribute(USER_ID) != null) {
				mapForDS.put(USER_ID, (Integer) session.getAttribute(USER_ID));
			}
	     
		  if (session.getAttribute(HOSPITAL_ID) != null) {
				mapForDS.put(HOSPITAL_ID, (Integer) session.getAttribute(HOSPITAL_ID));
			}
			if(request.getParameter(PATIENT_NAME)!=null && !request.getParameter(PATIENT_NAME).equals(""))
			{
				mapForDS.put(PATIENT_NAME, request.getParameter(PATIENT_NAME));
			}
			if(request.getParameter(SERVICE_NO) !=null && !request.getParameter(SERVICE_NO).equals("")){
				mapForDS.put(SERVICE_NO, request.getParameter(SERVICE_NO));
			}
			map =  laborRoomHandlerService.getTransferPatientWaitingList(mapForDS);
			
		jsp = LR_TRANSFER_WAITING_LIST;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView transferPatientJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		
	      if (session.getAttribute(USER_ID) != null) {
				mapForDS.put(USER_ID, (Integer) session.getAttribute(USER_ID));
			}
	     
		  if (session.getAttribute(HOSPITAL_ID) != null) {
				mapForDS.put(HOSPITAL_ID, (Integer) session.getAttribute(HOSPITAL_ID));
			}
			if(request.getParameter(PATIENT_NAME)!=null && !request.getParameter(PATIENT_NAME).equals(""))
			{
				mapForDS.put(PATIENT_NAME, request.getParameter(PATIENT_NAME));
			}
			if(request.getParameter(SERVICE_NO) !=null && !request.getParameter(SERVICE_NO).equals("")){
				mapForDS.put(SERVICE_NO, request.getParameter(SERVICE_NO));
			}
			
			if(request.getParameter("inpatientId") !=null && !request.getParameter("inpatientId").equals("")){
				mapForDS.put("inpatientId", Integer.parseInt(request.getParameter("inpatientId")));
			}
			
			map =  laborRoomHandlerService.getTransferPatientDetails(mapForDS);
			
		jsp = LR_PATIENT_Transfer_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView submitLrPatientTransfer(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Box box=HMSUtil.getBox(request);
	      if (session.getAttribute(USER_ID) != null) {
				mapForDS.put(USER_ID, (Integer) session.getAttribute(USER_ID));
			}
	     
		  if (session.getAttribute(HOSPITAL_ID) != null) {
				mapForDS.put(HOSPITAL_ID, (Integer) session.getAttribute(HOSPITAL_ID));
			}
		  
		  if (session.getAttribute("empId") != null) {
				mapForDS.put("empId", (Integer) session.getAttribute("empId"));
			}
		  
		  if (session.getAttribute("deptId") != null){
				int deptId = Integer.parseInt(session.getAttribute("deptId").toString());
				mapForDS.put("deptId", deptId);
			}
			if(request.getParameter(PATIENT_NAME)!=null && !request.getParameter(PATIENT_NAME).equals(""))
			{
				mapForDS.put(PATIENT_NAME, request.getParameter(PATIENT_NAME));
			}
			if(request.getParameter(SERVICE_NO) !=null && !request.getParameter(SERVICE_NO).equals("")){
				mapForDS.put(SERVICE_NO, request.getParameter(SERVICE_NO));
			}
			
			mapForDS.put("box", box);
			map =  laborRoomHandlerService.submitPatientTransfer(mapForDS);
		   
		   boolean transferedSuccessfully = false;
			if(map.get("saved")!=null)
			{
				transferedSuccessfully = (Boolean) map.get("saved");
				if (transferedSuccessfully) {
					message=" Patient has been transferred Successfully.";
				}else{
					message = "Some problem Occured! Try Again.";
				}
				
			}
			
			map =  laborRoomHandlerService.getTransferPatientWaitingList(mapForDS);
		jsp = LR_TRANSFER_WAITING_LIST;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showAvailableBedStatus(HttpServletRequest request,
			HttpServletResponse response) {
		
		Box box = HMSUtil.getBox(request);
		HttpSession session =request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		box.put("hospitalId", hospitalId);
		Map<String, Object> map = new HashMap<String, Object>();
		map = adtHandlerService.getBedStatus(box);
		String jsp = "lr_bed_selection";
		map.put("contentJsp", jsp);
		//map.put("chargeCodeId", box.getInt("chargeCodeId"));
		map.put("hinNo", box.getString("hinNo"));
		map.put("bedNoFieldId", box.getString("bedNoFieldId"));
		map.put("bedIdFieldId", box.getString("bedIdFieldId"));
	
		return new ModelAndView(jsp, "map", map);
	}

}
