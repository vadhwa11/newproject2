package jkt.hms.FacilityManagement.controller;


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
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.hms.FacilityManagement.handler.FacilityManagementHandlerService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import ca.uhn.hl7v2.protocol.impl.ParseChecker;

public class FacilityManagementController extends MultiActionController {
	
	FacilityManagementHandlerService facilityManagementHandlerService = null;

	ADTHandlerService adtHandlerService = null;
	String jsp = "";
	String title = "";
	String message = "";
	String userName = "";
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = null;
	public ADTHandlerService getAdtHandlerService() {
		return adtHandlerService;
	}

	public void setAdtHandlerService(ADTHandlerService adtHandlerService) {
		this.adtHandlerService = adtHandlerService;
	}


	public FacilityManagementHandlerService getFacilityManagementHandlerService() {
		return facilityManagementHandlerService;
	}

	public void setFacilityManagementHandlerService(
			FacilityManagementHandlerService facilityManagementHandlerService) {
		this.facilityManagementHandlerService = facilityManagementHandlerService;
	}

	public ModelAndView showPendingListForEnterEquipmentDetailJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		Box box = HMSUtil.getBox(request);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();

		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if(request.getParameter("equipmentName") != null && !request.getParameter("equipmentName").equals("")){
			String itemName = request.getParameter("equipmentName");
			Integer index1 = itemName.lastIndexOf("[") + 1;
			int index2 = itemName.lastIndexOf("]");
			int itemId =Integer.parseInt(itemName.substring(index1, index2));
			box.put("itemId", itemId);
		}

		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		//Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = facilityManagementHandlerService.showPendingListForEnterEquipmentDetailJsp(box, dataMap);
		jsp = "pendingListForEnterEquipmentDetail";
		jsp = jsp + ".jsp";
		title = "Pending List for enter equipment detail";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showEquipmentDetailJsp(HttpServletRequest request,	HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();

		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
	
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		Map<String, Object> map = new HashMap<String, Object>();
		map = facilityManagementHandlerService.showEquipmentDetailJsp( dataMap);
		//map = procurementHandlerService.showPendingListForEnterEquipmentDetailJsp(box, dataMap);
		jsp = "equipmentDetail";
		jsp = jsp + ".jsp";
		title = "Pending List for enter equipment detail";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showWarrantyDetailJsp(HttpServletRequest request,
			HttpServletResponse response) {
		//
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		//map = procurementHandlerService.showManufactureDetailJsp(box);
		jsp = "warrantyDetailJsp";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showAccessoryDetailsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		//
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		//map = procurementHandlerService.showAccessoryDetailsJsp(box);
		jsp = "accessoryDetails";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView submitEquipmentDetails(HttpServletRequest request,
			HttpServletResponse response)
	{   Map<String, Object> dataMap = new HashMap<String, Object>();
		int deptId = 0;
		int hospitalId = 0;
		int userId=0;
		session = request.getSession();

		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (session.getAttribute("userId") != null) {
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		}

		dataMap.put("userId", userId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		Map<String, Object> map = new HashMap<String, Object>();
		map = facilityManagementHandlerService.submitEquipmentDetails(dataMap);
		map.putAll(facilityManagementHandlerService.showPendingListForEnterEquipmentDetailJsp(box, dataMap));;
		jsp = "pendingListForEnterEquipmentDetail";
		jsp = jsp + ".jsp";
		title = "Pending List for enter equipment detail";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView showCreateServiceRequestJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int hospitalId = 0;
		String flag="";
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detail = new HashMap<String, Object>();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			detail.put("hospitalId", hospitalId);
		}
		//map = maintenanceHandlerService.getDepartment(hospitalId);
		if (request.getParameter("ItemType") != null && request.getParameter("ItemType") != "") {
			detail.put("itemType", request.getParameter("ItemType"));
		}
		if (request.getParameter("Section") != null && request.getParameter("Section") != "") {
			detail.put("section", request.getParameter("Section"));
		}
		if (request.getParameter("Category") != null && request.getParameter("Category") != "") {
			detail.put("category", request.getParameter("Category"));
		}
		if (request.getParameter("Class") != null && request.getParameter("Class") != "") {
			detail.put("class", request.getParameter("Class"));
		}
		int searchDepartmentId =0;
		if (request.getParameter("department") != null && request.getParameter("department") != "") {
			detail.put("department", request.getParameter("department"));
			searchDepartmentId = Integer.parseInt(request.getParameter("department"));
		}
		
		if (request.getParameter("requestId") != null && request.getParameter("requestId") != "") {
			detail.put("requestId", request.getParameter("requestId"));
		}
		map.putAll(facilityManagementHandlerService.getEquipmentDetails(detail));
		jsp = "mCreateServiceRequest.jsp";
		title = "Create Service Request";
		map.put("eL", flag);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("searchDepartmentId", searchDepartmentId);
		return new ModelAndView("index", "map", map);
	}
	
    public ModelAndView showCreateServiceRequestDetails(HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> map=new HashMap<String, Object>();
    	Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId= 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			userId = (Integer) session.getAttribute("userId");
		}
		if(hospitalId>0){
			details.put("hospitalId", hospitalId);
		}
		if(userId>0){
			details.put("userId", userId);
		}
		if(request.getParameter("requestId")!=null){
			details.put("requestId", request.getParameter("requestId"));
		}
		if(request.getParameter("serviceRequestId")!=null){
			details.put("serviceRequestId", request.getParameter("serviceRequestId"));
		}
		map=facilityManagementHandlerService.getEquipmentDetails(details);
    	jsp = "mCreateServiceRequestDetails.jsp";
		title = "Condemnatione";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
    }
    
	public ModelAndView showEquipmentHistory(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map=new HashMap<String, Object>();
		Map<String, Object> details=new HashMap<String, Object>();
		int equipmentId=0;
		session=request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			details.put("hospitalId", hospitalId);
		}
		if(request.getParameter("eqId")!=null){
			details.put("eqId", Integer.parseInt(request.getParameter("eqId")));
			map=facilityManagementHandlerService.getEquipmentHistory(details);
		}
		jsp = "mEquipmentHistory.jsp";
		title = "Equipment History";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showEquipmentDashBoard(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map=new HashMap<String, Object>();
		Map<String, Object> details=new HashMap<String, Object>();
		int equipmentId=0;
		session=request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			details.put("hospitalId", hospitalId);
		}
		if(request.getParameter("eqId")!=null && request.getParameter("eqId")!=""){
			details.put("equipmentId", request.getParameter("eqId"));
			map=facilityManagementHandlerService.getEquipmentHistory(details);
		}
		if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!=""){
			details.put("fromDate", request.getParameter("fromDate"));
		}
		if(request.getParameter("toDate")!=null && request.getParameter("toDate")!=""){
			details.put("toDate", request.getParameter("toDate"));
		}
		map=facilityManagementHandlerService.equipmentDashBoard(details);
		jsp = "mEquipmentDashBoard.jsp";
		title = "Equipment History";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView submitCreateServiceRequest(HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int userId=0;
		int hospitalId=0;
		synchronized (session) {
			 userId = (Integer)session.getAttribute("userId");
			 hospitalId =  (Integer)session.getAttribute(HOSPITAL_ID);
		}
		if(request.getParameter("equipmentId")!=null && request.getParameter("equipmentId")!="")
		details.put("equipmentId", request.getParameter("equipmentId"));
		if(request.getParameter("warrantyStatus")!=null && request.getParameter("warrantyStatus")!="")
		details.put("warranty", request.getParameter("warrantyStatus"));
		if(request.getParameter("RequestType")!=null && request.getParameter("RequestType")!="")
		details.put("requestType", request.getParameter("RequestType"));
		if(request.getParameter("Priority")!=null && request.getParameter("Priority")!="")
		details.put("priority", request.getParameter("Priority"));
		if(request.getParameter("requiredDate")!=null && request.getParameter("requiredDate")!="")
		details.put("requiredDate", request.getParameter("requiredDate"));
		if(request.getParameter("description")!=null && request.getParameter("description")!="")
		details.put("description", request.getParameter("description"));
		if(userId!=0){details.put("userId", userId);}
		if(hospitalId!=0){details.put("hospitalId", hospitalId);}
		if(request.getParameter("lastChgDate")!=null && request.getParameter("lastChgDate")!=""){
			details.put("lastChgDate", request.getParameter("lastChgDate"));
		}
		if(request.getParameter("lastChgTime")!=null && request.getParameter("lastChgTime")!=""){
			details.put("lastChgTime", request.getParameter("lastChgTime"));
			}
		if(request.getParameter("amcId")!=null && request.getParameter("amcId")!=""){
			details.put("amcId", request.getParameter("amcId"));
			}
		if(request.getParameter("sms")!=null && request.getParameter("sms")!=""){
			details.put("sms", request.getParameter("sms"));
			}
		if(request.getParameter("mail")!=null && request.getParameter("mail")!=""){
			details.put("mail", request.getParameter("mail"));
			}
		if(request.getParameter("serviceRequestId")!=null && request.getParameter("serviceRequestId")!=null && !request.getParameter("serviceRequestId").equalsIgnoreCase("null")){
			details.put("serviceRequestId", request.getParameter("serviceRequestId"));
		}
		
		
			details.put("approval", request.getParameter("approval"));
			details.put("manufacture", request.getParameter("manufacture"));
		
		
		map=facilityManagementHandlerService.saveServiceDetails(details);
		map.putAll(facilityManagementHandlerService.getEquipmentDetails(details));
		//map.putAll(facilityManagementHandlerService.getDepartment(hospitalId));
		jsp = "mCreateServiceRequest.jsp";
		title="Service Request";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showPendingListForApprovalJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		int hospitalId = 0;
		int user = 0;
		session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			details.put("hospitalId", hospitalId);
			user = (Integer)session.getAttribute("userId");
			details.put("user", user);
		}
		if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!=""){
			details.put("fromDate", request.getParameter("fromDate"));
		}
		if(request.getParameter("toDate")!=null && request.getParameter("toDate")!=""){
			details.put("toDate", request.getParameter("toDate"));
		}
		if(request.getParameter("requestId")!=null && request.getParameter("requestId")!=""){
			details.put("requestId", request.getParameter("requestId"));
		}
		if(request.getParameter("itemCode")!=null && request.getParameter("itemCode")!=""){
			details.put("itemCode", request.getParameter("itemCode"));
		}
		if(request.getParameter("priority")!=null && request.getParameter("priority")!=""){
			details.put("priority", request.getParameter("priority"));
		}
		map=   facilityManagementHandlerService.getPendingServiceRequest(details);
		jsp = "mPendingListForApproval.jsp";
		title = "Pending List For Approval";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView serviceRequest(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detail = new HashMap<String, Object>();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			detail.put("hospitalId", hospitalId);
		}if(request.getParameter("requestId") != null){
			detail.put("requestId", request.getParameter("requestId"));
		}
		map=facilityManagementHandlerService.getRequestDetails(detail);
		jsp = "mServiceRequest.jsp";
		title = "Service Request";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView submitServiceRequest(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int departmentId = 0;
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			details.put("hospitalId", hospitalId);
			details.put("approvedBy", session.getAttribute("userId"));
		}
		if(request.getParameter("requestId")!=null){
			details.put("requestId", request.getParameter("requestId"));
		}
		if(request.getParameter("forwardTo")!=null){
			details.put("forwardTo", request.getParameter("forwardTo"));
		}
		if(request.getParameter("Remark")!=null){
			details.put("Remark", request.getParameter("Remark"));
		}
		if(request.getParameter("Status")!=null){
			details.put("status", request.getParameter("Status"));
		}
		map=facilityManagementHandlerService.saveServiceRequest(details);
		details.remove("requestId");
		map.putAll(facilityManagementHandlerService.getPendingServiceRequest(details));
		//map.putAll(facilityManagementHandlerService.getDepartment(hospitalId));
		jsp = "mPendingListForApproval.jsp";
		title = "Condemnatione";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showPendingListOfInspctionJsp(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			details.put("hospitalId", hospitalId);
		}
		if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!=""){
			details.put("fromDate", request.getParameter("fromDate"));
		}
		if(request.getParameter("toDate")!=null && request.getParameter("toDate")!=""){
			details.put("toDate", request.getParameter("toDate"));
		}
		if(request.getParameter("requestId")!=null && request.getParameter("requestId")!=""){
			details.put("requestId", request.getParameter("requestId"));
		}
		if(request.getParameter("itemCode")!=null && request.getParameter("itemCode")!=""){
			details.put("itemCode", request.getParameter("itemCode"));
		}
		if(request.getParameter("priority")!=null && request.getParameter("priority")!=""){
			details.put("priority", request.getParameter("priority"));
		}
		if(request.getParameter("RequestedFrom")!=null && request.getParameter("RequestedFrom")!=""){
			details.put("RequestedFrom", request.getParameter("RequestedFrom"));
		}
			map=facilityManagementHandlerService.getPendingListOfInspection(details);
			jsp = "mPendingListOfInspection.jsp";
			title = "Pending List Of Inspection";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
	
	
	public ModelAndView showAllPendingListOfInspctionJsp(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			details.put("hospitalId", hospitalId);
		}
			map=facilityManagementHandlerService.showAllPendingListOfInspctionJsp(details);
			jsp = "mPendingListOfInspection.jsp";
			title = "Pending List Of Inspection";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
	
	public ModelAndView showAssignResourceJsp(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detail = new HashMap<String, Object>();
		session=request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			detail.put("hospitalId", hospitalId);
		}
		if(request.getParameter("requestId")!=null){
			detail.put("requestId", request.getParameter("requestId"));
		}
			map=facilityManagementHandlerService.getAssignResource(detail);
			jsp = "mAssignResource.jsp";
			title = "Assign Resource";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
	
	public ModelAndView getResourceList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int departmentId = 0;
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (request.getParameter("department") != null) {
			departmentId = Integer.parseInt(request.getParameter("department"));
		}if (departmentId!=0) {
			details.put("departmentId", departmentId);
		}
		if (hospitalId != 0) {
			details.put("hospitalId", hospitalId);
		}
		map = facilityManagementHandlerService.getResourceList(details);
		String jsp = "populateResourceList";
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView submitAssignResorce(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			details.put("hospitalId", hospitalId);
		}
		if(request.getParameter("RequestNo")!=null && request.getParameter("RequestNo")!=""){
			details.put("RequestNo", request.getParameter("RequestNo"));
		}
		if(request.getParameter("Resource")!=null && request.getParameter("Resource")!=""){
			details.put("Resource", request.getParameter("Resource"));
		}
		if(request.getParameter("department")!=null && request.getParameter("department")!=""){
			details.put("department", request.getParameter("department"));
		}
		if(request.getParameter("ResourceRemark")!=null && request.getParameter("ResourceRemark")!=null){
			details.put("ResourceRemark", request.getParameter("ResourceRemark"));
		}
		if(request.getParameter("priorityId")!=null && !"".equalsIgnoreCase(request.getParameter("priorityId"))){
			details.put("priorityId", request.getParameter("priorityId"));
		}
		map = facilityManagementHandlerService.saveAssignResource(details);
		map.putAll(facilityManagementHandlerService.getPendingListOfInspection(details));
		jsp = "mPendingListOfInspection.jsp";
		title = "Pending Service Request";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView showPendingServiceRequestJsp(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null && session.getAttribute("userId")!=null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			details.put("hospitalId", hospitalId);
			details.put("user", (Integer)session.getAttribute("userId"));
			details.put("empId", (Integer)session.getAttribute("empId"));
		}
		if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!=""){
			details.put("fromDate", request.getParameter("fromDate"));
		}
		if(request.getParameter("toDate")!=null && request.getParameter("toDate")!=""){
			details.put("toDate", request.getParameter("toDate"));
		}
		if(request.getParameter("requestId")!=null && request.getParameter("requestId")!=""){
			details.put("requestId", request.getParameter("requestId"));
		}
		if(request.getParameter("itemCode")!=null && request.getParameter("itemCode")!=""){
			details.put("itemCode", request.getParameter("itemCode"));
		}
		if(request.getParameter("priority")!=null && request.getParameter("priority")!=""){
			details.put("priority", request.getParameter("priority"));
		}
		if(request.getParameter("ItemName")!=null && request.getParameter("ItemName")!=""){
			details.put("ItemName", request.getParameter("ItemName"));
		}
		if(request.getParameter("status")!=null && request.getParameter("status")!=""){
			details.put("status", request.getParameter("status"));
		}
		if(request.getParameter("flag")!=null && request.getParameter("flag")!=""){
			details.put("flag", request.getParameter("flag"));
		}
		map=facilityManagementHandlerService.getPendingServiceRequestList(details);
		jsp = "mPendingServiceRequest.jsp";
		title = "Pending Service Request";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showInspectionReport(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map=new HashMap<String, Object>();
		Map<String, Object> details=new HashMap<String, Object>();
		session=request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			details.put("hospitalId", hospitalId);
		}
		if(request.getParameter("requestId")!=null){
			details.put("requestId", request.getParameter("requestId"));
		}
		map=facilityManagementHandlerService.getInspectionDetails(details);
		jsp = "mInspectionReport.jsp";
		title = "Inspection Report";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView submitInspectionReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		List<Integer> mmCheckLists=new ArrayList<Integer>();
		List<Integer> allCheckLists=new ArrayList<Integer>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId= 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			userId = (Integer) session.getAttribute("userId");
		}
		if(hospitalId>0){
			details.put("hospitalId", hospitalId);
		}
		if(userId>0){
			details.put("userId", userId);
			details.put("user", userId);
		}
		
		details.put("empId", (Integer)session.getAttribute("empId"));
		
		if(request.getParameter("remarks")!=null && request.getParameter("remarks")!=""){
			details.put("remarks", request.getParameter("remarks"));
		}
		
		if(request.getParameter("CloseType")!=null && request.getParameter("CloseType")!=""){
			details.put("CloseType", request.getParameter("CloseType"));
		}
		if(request.getParameter("WorkOrderType")!=null && request.getParameter("WorkOrderType")!=""){
			details.put("WorkOrderType", request.getParameter("WorkOrderType"));
		}
		if(request.getParameter("ResourceRequirment")!=null && request.getParameter("ResourceRequirment")!=""){
			details.put("ResourceRequirment", request.getParameter("ResourceRequirment"));
		}
		if(request.getParameter("DescriptionOfWork")!=null && request.getParameter("DescriptionOfWork")!=""){
			details.put("DescriptionOfWork", request.getParameter("DescriptionOfWork"));
		}
		if(request.getParameter("obDate")!=null && request.getParameter("obDate")!=""){
			details.put("obDate", request.getParameter("obDate"));
		}
		if(request.getParameter("ObservationTime")!=null && request.getParameter("ObservationTime")!=""){
			details.put("ObservationTime", request.getParameter("ObservationTime"));
		}
		if(request.getParameter("ObservationRemark")!=null && request.getParameter("ObservationRemark")!=""){
			details.put("ObservationRemark", request.getParameter("ObservationRemark"));
		}
		if(request.getParameter("ServiceCost")!=null && request.getParameter("ServiceCost")!=""){
			details.put("ServiceCost", request.getParameter("ServiceCost"));
		}
		if(request.getParameter("MeterialCost")!=null && request.getParameter("MeterialCost")!=""){
			details.put("MeterialCost", request.getParameter("MeterialCost"));
		}
		/*if(request.getParameter("TotalDuration")!=null && request.getParameter("TotalDuration")!=""){
			details.put("TotalDuration", request.getParameter("TotalDuration"));
		}*/
		if(request.getParameter("PlannedCost")!=null && request.getParameter("PlannedCost")!=""){
			details.put("PlannedCost", request.getParameter("PlannedCost"));
		}
		if(request.getParameter("CostCenter")!=null && request.getParameter("CostCenter")!=""){
			details.put("CostCenter", request.getParameter("CostCenter"));
		}
		if(request.getParameter("AccountCode")!=null && request.getParameter("AccountCode")!=""){
			details.put("AccountCode", request.getParameter("AccountCode"));
		}
		if(request.getParameter("SupplierType")!=null && request.getParameter("SupplierType")!=""){
			details.put("SupplierType", request.getParameter("SupplierType"));
		}
		if(request.getParameter("SupplierName")!=null && request.getParameter("SupplierName")!=""){
			details.put("SupplierName", request.getParameter("SupplierName"));
		}
		if(request.getParameter("WorkOrderRemark")!=null && request.getParameter("WorkOrderRemark")!=""){
			details.put("WorkOrderRemark", request.getParameter("WorkOrderRemark"));
		}
		if(request.getParameter("type")!=null && request.getParameter("type")!=""){
			details.put("type", request.getParameter("type"));
		}
		if(request.getParameter("ServiceRequestId")!=null && request.getParameter("ServiceRequestId")!=""){
			details.put("ServiceRequestId", request.getParameter("ServiceRequestId"));
		}
		if(request.getParameter("equipmentId")!=null && request.getParameter("equipmentId")!=""){
			details.put("equipmentId", request.getParameter("equipmentId"));
		}
		if(request.getParameter("ActionType")!=null && request.getParameter("ActionType")!=""){
			details.put("ActionType", request.getParameter("ActionType"));
		}
		if(request.getParameter("WorkOrderRemark")!=null && request.getParameter("WorkOrderRemark")!=""){
			details.put("WorkOrderRemark", request.getParameter("WorkOrderRemark"));
		}
		if(request.getParameter("ObservationRemark")!=null && request.getParameter("ObservationRemark")!=""){
			details.put("ObservationRemark", request.getParameter("ObservationRemark"));
		}
		if(request.getParameter("PreventiveDoneOn")!=null && request.getParameter("PreventiveDoneOn")!=""){
			details.put("PreventiveDoneOn", request.getParameter("PreventiveDoneOn"));
		}
		if(request.getParameter("ScheduledDate")!=null && request.getParameter("ScheduledDate")!=""){
			details.put("ScheduledDate", request.getParameter("ScheduledDate"));
		}
		if(request.getParameter("ScheduledTime")!=null && request.getParameter("ScheduledTime")!=""){
			details.put("ScheduledTime", request.getParameter("ScheduledTime"));
		}
		if(request.getParameter("ContactPerson")!=null && request.getParameter("ContactPerson")!=""){
			details.put("ContactPerson", request.getParameter("ContactPerson"));
		}
		if(request.getParameter("OnHoldReason")!=null && request.getParameter("OnHoldReason")!=""){
			details.put("OnHoldReason", request.getParameter("OnHoldReason"));
		}
		if(request.getParameter("lastChgDate")!=null && request.getParameter("lastChgDate")!=""){
			details.put("lastChgDate", request.getParameter("lastChgDate"));
		}
		if(request.getParameter("lastChgTime")!=null && request.getParameter("lastChgTime")!=""){
			details.put("lastChgTime", request.getParameter("lastChgTime"));
		}
		
		if(request.getParameter("ItemId")!=null && request.getParameter("ItemId")!=""){
			details.put("ItemId", request.getParameterValues("ItemId"));
		}
		if(request.getParameter("RequiredQty")!=null && request.getParameter("RequiredQty")!=""){
			details.put("RequiredQty", request.getParameterValues("RequiredQty"));
		}
		if(request.getParameter("specification")!=null && request.getParameter("specification")!=""){
			details.put("specification", request.getParameterValues("specification"));
		}
		if(request.getParameterValues("checkList")!=null){
			for(int i=0;i<request.getParameterValues("checkList").length;i++){
				mmCheckLists.add(Integer.parseInt((String)request.getParameterValues("checkList")[i]));
			}
			details.put("mmCheckLists", mmCheckLists);
		}
		if(request.getParameterValues("AllCheckList")!=null){
			for(int i=0;i<request.getParameterValues("AllCheckList").length;i++){
				allCheckLists.add(Integer.parseInt((String)request.getParameterValues("AllCheckList")[i]));
			}
			details.put("AllCheckList", allCheckLists);
		}
		if(request.getParameter("ImergencyIndent")!=null && request.getParameter("ImergencyIndent")!=""){
			details.put("ImergencyIndent", request.getParameter("ImergencyIndent"));
		}
		if(request.getParameter("WORequiredDate")!=null && request.getParameter("WORequiredDate")!=""){
			details.put("WORequiredDate", request.getParameter("WORequiredDate"));
		}
		if(request.getParameter("PlannedEndDate")!=null && request.getParameter("PlannedEndDate")!=""){
			details.put("PlannedEndDate", request.getParameter("PlannedEndDate"));
		}
		if(request.getParameter("PlannedStartDate")!=null && request.getParameter("PlannedStartDate")!=""){
			details.put("PlannedStartDate", request.getParameter("PlannedStartDate"));
		}
		if(request.getParameter("Account")!=null && request.getParameter("Account")!=""){
			details.put("Account", request.getParameter("Account"));
		}
		
		if(request.getParameter("equipRecDate")!=null && request.getParameter("equipRecDate")!=""){
			details.put("equipRecDate", request.getParameter("equipRecDate"));
		}
		map=facilityManagementHandlerService.submitInspectionReport(details);
		map.putAll(facilityManagementHandlerService.getPendingServiceRequestList(details));
		jsp = "mPendingServiceRequest.jsp";
		title = "Condemnatione";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView showPreventiveMaintenanceJsp(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null && session.getAttribute("userId")!=null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			details.put("hospitalId", hospitalId);
			details.put("user", (Integer)session.getAttribute("userId"));
		}
		if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!=""){
			details.put("fromDate", request.getParameter("fromDate"));
		}
		if(request.getParameter("toDate")!=null && request.getParameter("toDate")!=""){
			details.put("toDate", request.getParameter("toDate"));
		}
		if(request.getParameter("ItemCode")!=null && request.getParameter("ItemCode")!=""){
			details.put("ItemCode", request.getParameter("ItemCode"));
		}
		if(request.getParameter("ItemName")!=null && request.getParameter("ItemName")!=""){
			details.put("ItemName", request.getParameter("ItemName"));
		}
		if(request.getParameter("ModelNo")!=null && request.getParameter("ModelNo")!=""){
			details.put("ModelNo", request.getParameter("ModelNo"));
		}
		if(request.getParameter("flag")!=null && request.getParameter("flag")!=""){
			details.put("flag", request.getParameter("flag"));
		}
		map=facilityManagementHandlerService.getPreventiveMaintenanceList(details);
		
		jsp = "mPreventiveMaintenance.jsp";
		title = "Preventive Maintenance";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	
	
	
}
