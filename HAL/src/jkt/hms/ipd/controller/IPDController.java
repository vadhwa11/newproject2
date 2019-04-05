package jkt.hms.ipd.controller;

import static jkt.hms.util.RequestConstants.ADMISSION_NUMBER;
import static jkt.hms.util.RequestConstants.AD_NO;
import static jkt.hms.util.RequestConstants.ASP;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CLINICAL_CHART_JSP;
import static jkt.hms.util.RequestConstants.CLINICAL_SETUP_JSP;
import static jkt.hms.util.RequestConstants.DATE;
import static jkt.hms.util.RequestConstants.DATE_OF_WARD_MASTER;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID_TEMP;
import static jkt.hms.util.RequestConstants.DEPT_ID;
import static jkt.hms.util.RequestConstants.DIAGNOSIS_ID;
import static jkt.hms.util.RequestConstants.DISCHARGE_SLIP;
import static jkt.hms.util.RequestConstants.DUTY_NURSING_OFFICERS;
import static jkt.hms.util.RequestConstants.FOOD_TASTING;
import static jkt.hms.util.RequestConstants.FOOD_TASTING_JSP;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;
import static jkt.hms.util.RequestConstants.INTAKE;
import static jkt.hms.util.RequestConstants.INTAKE_DATE;
import static jkt.hms.util.RequestConstants.INTAKE_OUTPUT_JSP;
import static jkt.hms.util.RequestConstants.INTAKE_OUTPUT_PATIENT_SEARCH;
import static jkt.hms.util.RequestConstants.INTAKE_OUTPUT_REPORT_JSP;
import static jkt.hms.util.RequestConstants.INTAKE_REMARKS;
import static jkt.hms.util.RequestConstants.INTAKE_TIME;
import static jkt.hms.util.RequestConstants.IPD_RESPONSE_FOR_HIN_NO;
import static jkt.hms.util.RequestConstants.IPD_RESPONSE_INTAKE_OUTPUT_HIN_NO;
import static jkt.hms.util.RequestConstants.IV;
import static jkt.hms.util.RequestConstants.IV_COMBO;
import static jkt.hms.util.RequestConstants.MESSAGE_FOR_ADT_JSP;
import static jkt.hms.util.RequestConstants.MESSAGE_FOR_INTAKE_OUTPUT;
import static jkt.hms.util.RequestConstants.MODIFY_WARD_CONSUMPTION_JSP;
import static jkt.hms.util.RequestConstants.NURSING_CARE_ID;
import static jkt.hms.util.RequestConstants.NURSING_CARE_REPORT;
import static jkt.hms.util.RequestConstants.OPD_MSG_SURGERY_REQUISITION_FOR_INPATIENT;
import static jkt.hms.util.RequestConstants.OPD_RESPONSE_FOR_INVESTIGATION_JSP;
import static jkt.hms.util.RequestConstants.IPD_RESPONSE_FOR_SURGERY_REQUISITION_JSP;
import static jkt.hms.util.RequestConstants.OPD_SURGERY_REQUISITION_FOR_INPATIENT_JSP;
import static jkt.hms.util.RequestConstants.ORAL;
import static jkt.hms.util.RequestConstants.OUTPUT;
import static jkt.hms.util.RequestConstants.OUTPUT_DATE;
import static jkt.hms.util.RequestConstants.OUTPUT_REMARKS;
import static jkt.hms.util.RequestConstants.OUTPUT_TIME;
import static jkt.hms.util.RequestConstants.PATIENT_DIAGNOSIS_JSP;
import static jkt.hms.util.RequestConstants.PATIENT_ISSUE_JSP;
import static jkt.hms.util.RequestConstants.PATIENT_ISSUE_STOCK_DETAILS_JSP;
import static jkt.hms.util.RequestConstants.PATIENT_LIST_JSP;
import static jkt.hms.util.RequestConstants.REMARKS;
import static jkt.hms.util.RequestConstants.RESPONCE_FOR_PATIENT_DETAILS;
import static jkt.hms.util.RequestConstants.RESPONCE_FOR_WARD_DETAILS;
import static jkt.hms.util.RequestConstants.RESPONSE_DISCHARGE_AD_NO;
import static jkt.hms.util.RequestConstants.RESPONSE_FOR_ADMISSION_NO;
import static jkt.hms.util.RequestConstants.SEARCH_PATIENT_LIST_JSP;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.SERVICE_NUMBER;
import static jkt.hms.util.RequestConstants.SIL_DIL_JSP;
import static jkt.hms.util.RequestConstants.STOCK_DETAILS_JSP;
import static jkt.hms.util.RequestConstants.STOCK_UPDATED_MESSAGE_FOR_PI_JSP;
import static jkt.hms.util.RequestConstants.STOCK_UPDATED_MESSAGE_JSP;
import static jkt.hms.util.RequestConstants.STOOL;
import static jkt.hms.util.RequestConstants.STORES_MESSAGE_JSP;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.TREATMENT;
import static jkt.hms.util.RequestConstants.URINE;
import static jkt.hms.util.RequestConstants.USER_ID;
import static jkt.hms.util.RequestConstants.VIEW_CLINICAL_CHART;
import static jkt.hms.util.RequestConstants.VIEW_INTAKE_OUTPUT;
import static jkt.hms.util.RequestConstants.VIEW_PATIENT_ISSUE_JSP;
import static jkt.hms.util.RequestConstants.VIEW_STOCK_DETAILS_JSP;
import static jkt.hms.util.RequestConstants.VOM;
import static jkt.hms.util.RequestConstants.WAITING_LIST;
import static jkt.hms.util.RequestConstants.WARD_CONSUMPTION_ISSUE_STOCK_DETAILS_JSP;
import static jkt.hms.util.RequestConstants.WARD_CONSUMPTION_JSP;
import static jkt.hms.util.RequestConstants.WARD_LIST_JSP;
import static jkt.hms.util.RequestConstants.WARD_REMARKS_JSP;
import static jkt.hms.util.RequestConstants.Z03;
import static jkt.hms.util.RequestConstants.Z09;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.discharge.handler.DischargeHandlerService;
import jkt.hms.ipd.handler.IPDHandlerService;
import jkt.hms.lab.handler.LabHandlerService;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DischargeIcdCode;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.InpatientDocument;
import jkt.hms.masters.business.IpdIntake;
import jkt.hms.masters.business.IpdIntakeOutputChart;
import jkt.hms.masters.business.IpdMedicineIssueDetails;
import jkt.hms.masters.business.IpdMedicineIssueHeader;
import jkt.hms.masters.business.IpdOutput;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientInvestigationDetails;
import jkt.hms.masters.business.PatientPrescriptionDetails;
import jkt.hms.masters.business.ReferralPatientDetails;
import jkt.hms.masters.business.ReferralPatientHeader;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.UserButtonRights;
import jkt.hms.masters.business.Users;
import jkt.hms.pacs.dataservice.PacsHL7Service;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class IPDController extends MultiActionController {

	IPDHandlerService ipdHandlerService = null;
	LabHandlerService labHandlerService = null;
	DischargeHandlerService dischargeHandlerService = null;
	
	public DischargeHandlerService getDischargeHandlerService() {
		return dischargeHandlerService;
	}

	public void setDischargeHandlerService(
			DischargeHandlerService dischargeHandlerService) {
		this.dischargeHandlerService = dischargeHandlerService;
	}

	public LabHandlerService getLabHandlerService() {
		return labHandlerService;
	}

	public void setLabHandlerService(LabHandlerService labHandlerService) {
		this.labHandlerService = labHandlerService;
	}

	String jsp = "";
	String title = "";
	String userName = null;
	String message = null;
	Map<String, Object> map = new HashMap<String, Object>();

	/*
	 * method to show the patient list on main screen
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView showPatientListJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int deptId = 0;
		HttpSession session = request.getSession();
		int hospitalId=0;
		if(session.getAttribute(HOSPITAL_ID)!=null){
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);}
		Users users = (Users) session.getAttribute("users");
		dataMap.put("users", users);
//		map = ipdHandlerService.getUserButtonRights(dataMap);
	/*	List<UserButtonRights> userRightsList = (List<UserButtonRights>) map
				.get("userRightsList");*/
		if (request.getParameter("deptId") != null) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
			session.setAttribute("deptId", deptId);
		} else if(session.getAttribute("deptId")!=null){
			deptId = (Integer) session.getAttribute("deptId");
		}
		String title = request.getParameter("title");
		/*map = ipdHandlerService.getPatientList(deptId,hospitalId);*/
		map = ipdHandlerService.getPatientListAndNotification(deptId,hospitalId, users.getEmployee().getId());
		
		/**
		 * For getting ward sub menus
		 */
		//System.out.println("session.setAttribute)--"+session.getAttribute("appId"));
	/*	if(request.getParameter("appId")!=null){
			session.setAttribute("appId", request.getParameter("appId"));
		}*/
		
		/**
		 * 
		 */
		List set = (List) map.get("inpatientSet");
		map.put("inPatientSet", set);
	//	map.put("userRightsList", userRightsList);
		jsp = PATIENT_LIST_JSP;
//		jsp = "nursingStation";
		jsp += ".jsp";
		title = "Admitted Patient List";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		
		return new ModelAndView("indexB", "map", map);

	}
	
	public ModelAndView inpatientStatus(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		
		HttpSession session = request.getSession();
		 Users user = (Users) session.getAttribute("users");
		 int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("userId", user.getId());
		box.put("hospitalId", hospitalId);		
		String jsp="inpatientStatus";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView getInpatientStatus(HttpServletRequest request,
			HttpServletResponse response)
	{
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();*/
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		Box box = HMSUtil.getBox(request);

		box.put("hospitalId", hospitalId);

		String ExamType = "MedExam";
		box.put("ExamType", ExamType);
        
		map = ipdHandlerService.getInpatientStatus(box);

		/*if (map.get("OpdPatientDetailsEmpanelledList") != null) {
			OpdPatientDetailsEmpanelledList = (ArrayList) map.get("OpdPatientDetailsEmpanelledList");
		}*/
		
		if (map.get("inpatientList") != null) {
			inpatientList = (ArrayList) map.get("inpatientList");
		}

		int totalRecords = 0;
		if (map.get("totalRecords") != null) {
			totalRecords = (Integer) map.get("totalRecords");
		}

		try {
			PrintWriter pw = response.getWriter();

			pw.write("[");
			int counter = 1;
			int i = 0;			
			
			String status = "";
            System.out.println("inpatientList"+inpatientList.size());
			for (Inpatient inpatient : inpatientList) {
				
				Patient list = inpatient.getHin();
			
			
				if(inpatient.getAdStatus()!=null)
				{
					if(inpatient.getAdStatus().equalsIgnoreCase("W"))
					{
						status="Not Reported to Ward";
					}	
					else if(inpatient.getAdStatus().equalsIgnoreCase("A"))
					{
						status="Reported to Ward";
					}	
					else if(inpatient.getAdStatus().equalsIgnoreCase("WCB"))
					{
						status="Transfered Patient";
					}	
					else if(inpatient.getAdStatus().equalsIgnoreCase("WNS"))
					{
						status="In Operation Theater";
					}					
					else if(inpatient.getAdStatus().equalsIgnoreCase("WHD"))
					{
						status="In Labor Room";
					}		
					else if(inpatient.getAdStatus().equalsIgnoreCase("WHD"))
					{
						status="Ready for Discharge";

					}	
					else
					{
						status="";
					}
				}
				
					
				
				 
				if (counter != inpatientList.size()) {
					String servicepatientName = "";					
					if (list.getPFirstName() != null) {
						servicepatientName = list.getPFirstName();
					}

					if (list.getPMiddleName() != null) {
						servicepatientName = servicepatientName + " "
								+ list.getPMiddleName();
					}
					if (list.getPLastName() != null) {
						servicepatientName = servicepatientName + " "
								+ list.getPLastName();
					}
				

					pw.write("{\"opdId\": \""
							+ inpatient.getId()
							+ "\",\"admissionDate\": \""
							+ (inpatient.getDateOfAddmission() != null ? HMSUtil
									.changeDateToddMMyyyy(inpatient.getDateOfAddmission())
									: "")	
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")							
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getAge() != null ? list.getAge() : "")
							+ "\",\"HIN\": \""
							+ (list.getHinNo() != null ? list.getHinNo() : "")
							+ "\",\"gender\": \""
							+ (list.getSex() != null ? list.getSex()
									.getAdministrativeSexName() : "")
							+ "\",\"name\": \""
							+ servicepatientName
							+ "\",\"maritalStatus\": \""
							+ (list.getMaritalStatus() != null ? list
									.getMaritalStatus().getMaritalStatusName()
									: "-")
							+ "\",\"contactNo\":\""
							+ (list.getMobileNumber() != null ? list
									.getMobileNumber() : "")
							+ "\",\"relation\":\""
							+ (list.getRelation() != null ? list
									.getRelation().getRelationName() : "")								
							+ "\",\"status\":\""
							+ (status)	
							+ "\",\"ward\":\""
							+ (inpatient.getAdWardId() != null ? inpatient.getAdWardId().getDepartmentName(): "")		
							+ "\",\"bed\":\""													
							+ (inpatient.getBed() != null ? inpatient.getBed().getBedNo(): "")								
							+ "\",\"totalRecords\":\"" + totalRecords + "\"},");

				} else {
					String servicepatientName = "";
					String referredBy = "";
					if (list.getPFirstName() != null) {
						servicepatientName = list.getPFirstName();
					}

					if (list.getPMiddleName() != null) {
						servicepatientName = servicepatientName + " "
								+ list.getPMiddleName();
					}
					if (list.getPLastName() != null) {
						servicepatientName = servicepatientName + " "
								+ list.getPLastName();
					}
				

					pw.write("{\"opdId\": \""
							+ inpatient.getId()
							+ "\",\"admissionDate\": \""
							+ (inpatient.getDateOfAddmission() != null ? HMSUtil
									.changeDateToddMMyyyy(inpatient.getDateOfAddmission())
									: "")	
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")							
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getAge() != null ? list.getAge() : "")
							+ "\",\"HIN\": \""
							+ (list.getHinNo() != null ? list.getHinNo() : "")
							+ "\",\"gender\": \""
							+ (list.getSex() != null ? list.getSex()
									.getAdministrativeSexName() : "")
							+ "\",\"name\": \""
							+ servicepatientName
							+ "\",\"maritalStatus\": \""
							+ (list.getMaritalStatus() != null ? list
									.getMaritalStatus().getMaritalStatusName()
									: "-")
							+ "\",\"contactNo\":\""
							+ (list.getMobileNumber() != null ? list
									.getMobileNumber() : "")
							+ "\",\"relation\":\""
							+ (list.getRelation() != null ? list
									.getRelation().getRelationName() : "")								
							+ "\",\"status\":\""
							+ (status)	
							+ "\",\"ward\":\""
							+ (inpatient.getAdWardId() != null ? inpatient.getAdWardId().getDepartmentName(): "")		
							+ "\",\"bed\":\""													
							+ (inpatient.getBed() != null ? inpatient.getBed().getBedNo(): "")								
							+ "\",\"totalRecords\":\"" + totalRecords + "\"}");
				}

				counter++;
				i++;
			}

			pw.write("]");

		}

		catch (Exception e) {
			inpatientList.clear();

			e.printStackTrace();
		}
		inpatientList.clear();
		return null;

	}
	
	public ModelAndView checkMappedCharge(HttpServletRequest request,HttpServletResponse response) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		String chargeName=request.getParameter("chargeName");
		map.put("chargeName",chargeName);
		map.put("surgeryType",request.getParameter("surgeryCheck"));
		map = ipdHandlerService.checkMappedCharge(map);
		int count=(Integer)map.get("count");
		int chargecodeId=0;
		if(map.get("chargecodeId")!=null){
			 chargecodeId=(Integer)map.get("chargecodeId");
		}	 
		PrintWriter  out=response.getWriter();
		if(count>0)
			out.write("success|"+chargecodeId);
		else
			out.write("failed|0");
		jsp = IPD_RESPONSE_FOR_SURGERY_REQUISITION_JSP;
		return new ModelAndView(jsp, "map", map);
	}
	

	public ModelAndView getItemListForLoanoutByAutocompleteBalance(
			HttpServletRequest request, HttpServletResponse response) {
		try {
			String userName = "";
			int deptId = 0;
			int hospitalId = 0;

			HttpSession session = request.getSession();
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
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			int balanceId = 0;
			if (request.getParameter("balanceId") != null) {
				balanceId = Integer.parseInt(request.getParameter("balanceId"));
			}
			if (request.getParameter("itemGroupId") != null
					&& !request.getParameter("itemGroupId").equals("")) {
				int groupId = Integer.parseInt(request.getParameter("itemGroupId"));
				dataMap.put("groupId", groupId);
			}
			if (request.getParameter("itemTypeId") != null
					&& !request.getParameter("itemTypeId").equals("")) {
				int itemTypeId = Integer.parseInt(request
						.getParameter("itemTypeId"));
				dataMap.put("itemTypeId", itemTypeId);
			}
			if (request.getParameter("sectionId") != null
					&& !request.getParameter("sectionId").equals("")) {
				int sectionId = Integer.parseInt(request.getParameter("sectionId"));
				dataMap.put("sectionId", sectionId);
			}
			if (request.getParameter("categoryId") != null
					&& !request.getParameter("categoryId").equals("")) {
				int categoryId = Integer.parseInt(request
						.getParameter("categoryId"));
				dataMap.put("categoryId", categoryId);
			}
			if (request.getParameter("classId") != null
					&& !request.getParameter("classId").equals("")) {
				int classId = Integer.parseInt(request.getParameter("classId"));
				dataMap.put("classId", classId);
			}
			
			List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
			dataMap.put("autoHint", autoHint);
			dataMap.put("deptId", deptId);
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("balanceId", balanceId);
			map = ipdHandlerService
					.getItemListForLoanoutByAutocompleteBalance(dataMap);
			jsp = "result";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}
	
	
	public ModelAndView getReferedPatientList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute(DEPT_ID) != null)
		{
			box.put(DEPT_ID, (Integer) session.getAttribute(DEPT_ID));
		}
		if (session.getAttribute(HOSPITAL_ID) != null)
		{
			box.put(HOSPITAL_ID, (Integer) session.getAttribute(HOSPITAL_ID));
		}
		// map = ipdHandlerService.showCaseSheetJsp(box);
		int userId=0;
		if(session.getAttribute("userId")!=null){
			userId=(Integer)session.getAttribute("userId");
			box.put("userId",userId);
		}
		int hospitalId=0;
		hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
		map=ipdHandlerService.getReferalList(hospitalId,userId);
		
		String jsp="";
		jsp="internalReferalIP.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
		}

	/*
	 * method to search for the particular patient on the basis of admission
	 * number
	 */
	
	/*public ModelAndView showDetailsReferalRecord(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute(DEPT_ID) != null)
		{
			box.put(DEPT_ID, (Integer) session.getAttribute(DEPT_ID));
		}
		if (session.getAttribute(HOSPITAL_ID) != null)
		{
			box.put(HOSPITAL_ID, (Integer) session.getAttribute(HOSPITAL_ID));
		}
		// map = ipdHandlerService.showCaseSheetJsp(box);
		int userId=0;
		if(session.getAttribute("userId")!=null){
			userId=(Integer)session.getAttribute("userId");
			box.put("userId",userId);
		}
		int empId=0;
		if(session.getAttribute("empId")!=null){
			empId=(Integer)session.getAttribute("empId");
		}
		int remarksId=0;
		if(request.getParameter("reamrksId")!=null){
			remarksId=Integer.parseInt(request.getParameter("reamrksId"));
		}
		System.out.println("remarksId=222==="+remarksId);
		box.put("empId", empId);
		box.put("parent", remarksId);
		map = ipdHandlerService.showDetailsReferalRecord(box);
		map = ipdHandlerService.showCaseSheetJsp(box);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = ipdHandlerService
				.getPatientLatestDiagnosisAndDisability(box.getInt("parent"));
		if (detailsMap.get("diagnosisList") != null) {
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		if (detailsMap.get("disabilityList") != null) {
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}
		// String jsp = "ipdCaseSheet.jsp";
		String jsp = "ipdCaseSheetNew.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}*/
	
	
	public ModelAndView showDetailsReferalRecord(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box =HMSUtil.getBox(request);
		if(session.getAttribute("deptId")!=null)
		box.put("deptId", (Integer)session.getAttribute("deptId"));
		if(session.getAttribute("hospitalId")!=null)
			box.put("hospitalId", (Integer)session.getAttribute("hospitalId"));
//		map = ipdHandlerService.showCaseSheetJsp(box);
		map = ipdHandlerService.showNewCaseSheetJsp(box);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		/*detailsMap = ipdHandlerService.getPatientLatestDiagnosisAndDisability(box.getInt("parent"));*/
		System.out.println(box.getInt("parent"));
		if(detailsMap.get("diagnosisList")!=null){
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		if(detailsMap.get("disabilityList")!=null){
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}
//		String jsp = "ipdCaseSheet.jsp";
		String jsp = "ipdCaseSheetNewReferral";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}
	
	
	public ModelAndView searchPatient(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String takeSetFromSessionInJsp = "true";
		int adNo = Integer.parseInt(request.getParameter(ADMISSION_NUMBER));
		String serviceNumber = "";
		String hinNumber = null;
		String deptName = "";
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = (Integer) session.getAttribute("deptId");
		Users users = (Users) session.getAttribute("users");
		map.put("users", users);
		if (adNo > 0) {
			adNo = Integer.parseInt(request.getParameter(ADMISSION_NUMBER));
			map.put("adNo", adNo);
		}
		if (!request.getParameter(SERVICE_NUMBER).equals("")) {
			serviceNumber = request.getParameter(SERVICE_NUMBER);
			map.put("serviceNumber", serviceNumber);
		}
		if (!request.getParameter(HIN_NO).equals("")) {
			hinNumber = request.getParameter(HIN_NO);
			map.put("hinNumber", hinNumber);
		}
		if (request.getParameter("deptName") != null) {
			deptName = request.getParameter("deptName");
		}
		dataMap = ipdHandlerService.getUserButtonRights(map);
		List<UserButtonRights> userRightsList = (List<UserButtonRights>) dataMap
				.get("userRightsList");
		map.put("userRightsList", userRightsList);
		map.put("deptId", deptId);
		map = ipdHandlerService.searchPatient(map);
		jsp = SEARCH_PATIENT_LIST_JSP;
		jsp += ".jsp";
		title = "title";
		map.put("takeSetFromSessionInJsp", takeSetFromSessionInJsp);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/*
	 * method to show the nursing care setup screen for the purticular patient
	 * to set up the cares to be given to the patient with the number of times.
	 */
	public ModelAndView showNursingCareJsp(HttpServletRequest request,
			HttpServletResponse response) {

		@SuppressWarnings("unused")
		HttpSession session = request.getSession();
		int inPatient = Integer.parseInt(request.getParameter("parent"));
		Map<String, Object> map = new HashMap<String, Object>();
		String deptName = request.getParameter("deptName");
		map = ipdHandlerService.nursingCareSetup(inPatient);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = ipdHandlerService.getPatientLatestDiagnosisAndDisability(inPatient);
		if(detailsMap.get("diagnosisList")!=null){
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		if(detailsMap.get("disabilityList")!=null){
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}
		jsp = CLINICAL_SETUP_JSP;
		jsp += ".jsp";
		title = "Clinical Setup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptName", deptName);

		return new ModelAndView("indexB", "map", map);
	}

	/*
	 * method to add the nursing cares for the patient with the number of times
	 * per day to be given to the patient.
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView addNursingCare(HttpServletRequest request,
			HttpServletResponse response) {
		String takeSetFromSessionInJsp = "true";
		int deptId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> listmap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("deptId") != null) {
			deptId =  (Integer)(session.getAttribute("deptId"));
		}
		Users users = (Users) session.getAttribute("users");
		dataMap.put("users", users);
		map = ipdHandlerService.getUserButtonRights(dataMap);
		List<UserButtonRights> userRightsList = (List<UserButtonRights>) map
				.get("userRightsList");



		// map=ipdHandlerService.nursingCareSetup(inPatient);
		List list = new ArrayList();
		List frequencyList = new ArrayList();
		List nurSetupIdList = new ArrayList();
		List remarksList = new ArrayList();
		List durationList = new ArrayList();
		List noOfDaysList = new ArrayList();
		int hinId = Integer.parseInt(request.getParameter("hinId"));
		String deptName = request.getParameter("deptName");
		int inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		String admissionNumber = (String) session
				.getAttribute("admissionNumber");
		String[] frequency = request.getParameterValues("frequency");
		String[] str = request.getParameterValues("cares");
		String[] nurCareSetup = request.getParameterValues("nursingCareSetupId");
		String[] remarks = request.getParameterValues("remarks");
		String[] duration = request.getParameterValues("duration");
		String[] noOfDays = request.getParameterValues("noOfDays");
		/**
		 * Commented By Ritu on 20 Dec 2011
		 */
	/*	for (int j = 0; j < frequency.length; j++) {
			int frequencyId = Integer.parseInt(frequency[j]);
			//if (frequencyId != 0) {
				frequencyList.add(frequencyId);
			//}
		}
		if (str != null) {
			for (int i = 0; i < str.length; i++) {
				int nursingId = Integer.parseInt(str[i]);
				list.add(nursingId);
			}
		}
		for (int j = 0; j < nurCareSetup.length; j++) {
			int nurCareSetupId = Integer.parseInt(nurCareSetup[j]);
			//if (nurCareSetupId != 0) {
				nurSetupIdList.add(nurCareSetupId);
			//}
		}*/
		/**
		 * Added by Ritu for add row functionality in jsp
		 */
		int counter = Integer.parseInt(request.getParameter("counter"));		
		if(counter > 0) {
			for (int i = 0; i < counter; i++) {
				int frequencyId = Integer.parseInt(frequency[i]);
				frequencyList.add(frequencyId);
				int nursingId = Integer.parseInt(str[i]);
				list.add(nursingId);
				int nurCareSetupId = Integer.parseInt(nurCareSetup[i]);
				nurSetupIdList.add(nurCareSetupId);
				remarksList.add(remarks[i]);
				durationList.add(duration[i]);
				noOfDaysList.add(Integer.parseInt(noOfDays[i]));
			}
		}

		map.put("takeSetFromSessionInJsp", takeSetFromSessionInJsp);
		map.put("list", list);
		map.put("frequencyList", frequencyList);
		map.put("nurSetupIdList", nurSetupIdList);
		map.put("remarksList", remarksList);
		map.put("noOfDaysList", noOfDaysList);
		map.put("durationList", durationList);
		map.put("admissionNumber", admissionNumber);
		map.put("userName", userName);
		map.put("hinId", hinId);
		map.put("deptId", deptId);
		map.put("inpatientId", inpatientId);
		boolean successfullyAdded = ipdHandlerService.addNursingCare(map);
		if (successfullyAdded) {
			message = "Cares has been Setup Successfully !!";
		} else {
			message = "Try Again !!";
		}
		int hospitalId = (Integer)session.getAttribute("hospitalId");
		/*listmap = ipdHandlerService.getPatientList(deptId, hospitalId);*/
		listmap = ipdHandlerService.getPatientListAndNotification(deptId,hospitalId, users.getEmployee().getId());
		List set = (List) listmap.get("inpatientSet");
		listmap.put("inPatientSet", set);
		listmap.put("userRightsList", userRightsList);
		listmap.put("deptId", deptId);
		listmap.put("contentJsp", jsp);
		listmap.put("title", title);

		jsp = PATIENT_LIST_JSP;
		jsp += ".jsp";
		title = "Patient List";
		listmap.put("deptName", deptName);
		listmap.put("message", message);
		listmap.put("contentJsp", jsp);
		listmap.put("title", title);

		return new ModelAndView("indexB", "map", listmap);

	}
	
	/*
	 * Methods add the diet Setup
	*/
	public ModelAndView addDietSetup(HttpServletRequest request,HttpServletResponse response)
	 {
		int deptId=0;
		String patientName="";
		String hinNo="";
		int dietFor=0;
		int cont=0;
		int bedNo=0;
		int typeOfDiet=0;
		String diet="";
		String morningTea="";
		int hinId=0;
		int bedId=0;
		int inpatientId=0;
		int dietId= 0;
		String splIns="";
		String lunch="",eveningTea="",dinner="";
		int preparedBy=0;
		Map<String,Object> map= new HashMap<String,Object>();
		HttpSession session = request.getSession();
		if(request.getParameter("hiddenValue")!=null && request.getParameter("hiddenValue")!=""){
		cont = Integer.parseInt(request.getParameter("hiddenValue"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if(request.getParameter("dietFor")!=null){
			dietFor=Integer.parseInt(request.getParameter("dietFor"));
		}
		if(request.getParameter("preparedBy")!=null && request.getParameter("preparedBy")!=""){
			preparedBy=Integer.parseInt(request.getParameter("preparedBy"));
		}
		List<Integer> hinIdList = new ArrayList<Integer>();
		List<Integer> bedIdList = new ArrayList<Integer>();
		List<Integer> inpatientIdList = new ArrayList<Integer>();
		List<Integer> dietIdList = new ArrayList<Integer>();
		List<Integer> bedNoList = new ArrayList<Integer>();
		List<Integer> typeOfDietList = new ArrayList<Integer>();
		List<String> hinNoList = new ArrayList<String>();
		List<String> dietList = new ArrayList<String>();
		List<String> morningTeaList = new ArrayList<String>();
		List<String> lunchList = new ArrayList<String>();
		List<String> eveningTeaList = new ArrayList<String>();
		List<String> dinnerList = new ArrayList<String>();
		List<String> splInsList = new ArrayList<String>();
		int j=1;
		if(cont>0){
			for(int i=0;i<cont;i++){
		if(request.getParameter("patientName" + j)!=null && request.getParameter("patientName"+j)!=""){
		patientName = request.getParameter("patientName"+j);
		}
		if(request.getParameter("hinId"+j)!=null && request.getParameter("hinId"+j)!=""){
		hinId= Integer.parseInt(request.getParameter("hinId"+j));
		hinIdList.add(hinId);
		}
		if(request.getParameter("bedId"+j)!=null && request.getParameter("bedId"+j)!=""){
		bedId=Integer.parseInt(request.getParameter("bedId"+j));
		bedIdList.add(bedId);
		}
		if(request.getParameter("inpatientId"+j)!=null && request.getParameter("inpatientId"+j)!=""){
		inpatientId=Integer.parseInt(request.getParameter("inpatientId"+j));
		inpatientIdList.add(inpatientId);
		}
		if(request.getParameter("dietId"+j)!=null && request.getParameter("dietId"+j)!=""){
		dietId = Integer.parseInt(request.getParameter("dietId"+j));
		dietIdList.add(dietId);
		}
		if(request.getParameter("hinNo"+j)!=null && request.getParameter("hinNo"+j)!=""){		
		hinNo = (request.getParameter("hinNo"+j));
		hinNoList.add(hinNo);
		}
		if(request.getParameter("bedNo"+j)!=null && request.getParameter("bedNo"+j)!=""){
		bedNo = Integer.parseInt(request.getParameter("bedNo"+j));
		bedNoList.add(bedNo);
		}
		if(request.getParameter("typeOfDiet"+j)!=null && request.getParameter("typeOfDiet"+j)!=""){
		typeOfDiet =  Integer.parseInt(request.getParameter("typeOfDiet"+j));
		typeOfDietList.add(typeOfDiet);
		}
		if(request.getParameter("diet"+j)!=null && request.getParameter("diet"+j)!="" ){
		diet= request.getParameter("diet"+j);
		dietList.add(diet);
		}
		if(request.getParameter("morningTea"+j)!=null && request.getParameter("morningTea"+j)!=""){
	    morningTea = request.getParameter("morningTea"+j);
	    morningTeaList.add(morningTea);
		}
	    if(request.getParameter("lunch"+j)!=null && request.getParameter("lunch"+j)!=""){
	     lunch= request.getParameter("lunch"+j);
	     lunchList.add(lunch);
	    }
	    if(request.getParameter("eveningTea"+j)!=null && request.getParameter("eveningTea"+j)!=""){
	     eveningTea=request.getParameter("eveningTea"+j);
	     eveningTeaList.add(eveningTea);
	    }
	    if(request.getParameter("dinner"+j)!=null && request.getParameter("dinner"+j)!=""){
	     dinner= request.getParameter("dinner"+j);
	     dinnerList.add(dinner);
	    }
	    if(request.getParameter("splIns"+j)!=null){
	    	splIns= request.getParameter("splIns"+j);
	    	splInsList.add(splIns);
		    }
	    j++;
			}
			}
	    // System.out.println("dinner===========>>>>>"+dinner);
	    // map.put("patientName", patientName);
		map.put("deptId", deptId);
		map.put("dietFor", dietFor);
		map.put("userName", userName);
		map.put("cont", cont); 
		map.put("hinIdList", hinIdList);
	     map.put("bedIdList", bedIdList);
	     map.put("inpatientIdList", inpatientIdList);
	     map.put("dietIdList", dietIdList);
	     map.put("hinNoList", hinNoList);
	     map.put("bedNoList", bedNoList);
	     map.put("typeOfDietList", typeOfDietList);
	     map.put("dietList", dietList);
	     map.put("morningTeaList", morningTeaList);
	     map.put("lunchList", lunchList);
	     map.put("eveningTeaList", eveningTeaList);
	     map.put("dinnerList",  dinnerList);
	     map.put("splInsList",  splInsList);
	     boolean successfullyAdded = ipdHandlerService.addDietSetup(map);
	     if (successfullyAdded) {
				message = "Diet  Setup Has Been Successfully Save!! Do You Want To Print!!";
			} else {
				message = "Try Again !!";
			}
	     	jsp="message";
	     	jsp += ".jsp";
	     	String flag="dietSetup";
	     	String url = "/hms/hms/ipd?method=showPatientListJsp";
	     	map.put("flag", flag);
	     	map.put("url", url);
	 		map.put("messageTOBeVisibleToTheUser", message);
	 		map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("indexB", "map", map);
	 }

	/*
	 * method to show the food tasting jsp with showing the details if any entry
	 * is done regarding the food tasting for the purticular date.
	 */
	public ModelAndView showFoodTastingJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();

		int deptId = (Integer) session.getAttribute("deptId");
		String deptName = request.getParameter("deptName");
		map = ipdHandlerService.showFoodTesting(deptId);
		jsp = FOOD_TASTING_JSP;
		jsp += ".jsp";
		title = "Food Tasting";
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/*
	 * method to insert the record for food tasting for the purticular date.
	 */
	public ModelAndView insertFoodTesting(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		String takeSetFromSessionInJsp = "true";
		boolean successfullyAdded = false;
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = (Integer) session.getAttribute("deptId");
		String deptName = request.getParameter("deptName");
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		String breakFastStatus = request.getParameter("breakFastStatus");
		String lunchStatus = request.getParameter("lunchStatus");
		String dinnerStatus = request.getParameter("dinnerStatus");
		String breakFastDetails = request.getParameter("breakFastDetails");
		String lunchDetails = request.getParameter("lunchDetails");
		String dinnerDetails = request.getParameter("dinnerDetails");
		String breakFastTime = request.getParameter("breakFastTime");
		String breakFastRemarks = request.getParameter("breakFastRemarks");
		String breakFastCheckedByEmp = request
				.getParameter("breakFastCheckedBy");
		String lunchTime = request.getParameter("lunchTime");
		String lunchRemarks = request.getParameter("lunchRemarks");
		String lunchCheckedByEmp = request.getParameter("lunchCheckedBy");
		String dinnerTime = request.getParameter("dinnerTime");
		String dinnerRemarks = request.getParameter("dinnerRemarks");
		String dinnerCheckedByEmp = request.getParameter("dinnerCheckedBy");
		if (!(breakFastStatus.equals("")) && breakFastDetails.equals("unDone")) {
			map.put("breakFastStatus", breakFastStatus);
			map.put("breakFastTime", breakFastTime);
			map.put("breakFastRemarks", breakFastRemarks);
			map.put("breakFastCheckedByEmp", breakFastCheckedByEmp);
		}
		if (!(lunchStatus.equals("")) && lunchDetails.equals("unDone")) {

			map.put("lunchStatus", lunchStatus);
			map.put("lunchTime", lunchTime);
			map.put("lunchRemarks", lunchRemarks);
			map.put("lunchCheckedByEmp", lunchCheckedByEmp);
		}
		if (!(dinnerStatus.equals("")) && dinnerDetails.equals("unDone")) {
			map.put("dinnerStatus", dinnerStatus);

			map.put("dinnerTime", dinnerTime);
			map.put("dinnerRemarks", dinnerRemarks);
			map.put("dinnerCheckedByEmp", dinnerCheckedByEmp);
		}
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("userName", userName);
		successfullyAdded = ipdHandlerService.insertFoodTestingDetails(map);

		Users users = (Users) session.getAttribute("users");
		map.put("users", users);
		map = ipdHandlerService.getUserButtonRights(map);
		List<UserButtonRights> userRightsList = (List<UserButtonRights>) map
				.get("userRightsList");
		int hospitalId = (Integer)session.getAttribute("hospitalId");
		map = ipdHandlerService.getPatientList(deptId,hospitalId);
		List set = (List) map.get("inpatientSet");
		map.put("inPatientSet", set);
		if (successfullyAdded
				&& (breakFastDetails.equals("unDone")
						|| lunchDetails.equals("unDone") || dinnerDetails
						.equals("unDone"))) {
			message = "Food Tasting Details Added Successfully !!";
		} else if (successfullyAdded && breakFastDetails.equals("done")
				&& lunchDetails.equals("done") && dinnerDetails.equals("done")) {
			message = "Sorry ! Data Has Already been Entered for Food Details !!";
		} else {
			message = "Try Again !!";
		}
		jsp = PATIENT_LIST_JSP;
		jsp += ".jsp";
		title = "";
		map.put("userRightsList", userRightsList);
		map.put("takeSetFromSessionInJsp", takeSetFromSessionInJsp);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/*
	 * method to show the list of cares can be given to the purticular patient.
	 */
	/*public ModelAndView showNursingCareEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {

		// HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		String deptName = request.getParameter("deptName");
		map = ipdHandlerService.showCaresList();

		jsp = NURSING_CARE_ENTRY_JSP;
		jsp += ".jsp";
		title = "Nursing Entry";
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}*/

	/**
	 * method to enter the care given to the patient and show the detail of how
	 * many times the care has already been given and wheather the care has been
	 * given for the next time or not.
	 */

	/*public ModelAndView showNursingCareEntryDetailJsp(
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		int careId = Integer.parseInt(request.getParameter("cares"));
		String caretime = request.getParameter("caretime");
		String deptName = request.getParameter("deptName");
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = (Integer) session.getAttribute("deptId");
		map = ipdHandlerService.getPatientListOnBasisOfCare(careId, deptId);
		// Set set=(Set)map.get("patientSet");
		jsp = NURSING_CARE_ENTRY_DETAIL_JSP;
		// jsp += ".jsp";
		title = "Nursing Entry Detail";
		map.put("deptName", deptName);
		map.put("caretime", caretime);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}*/

	/**
	 * search method for all patient on basis of care and the list will be
	 * displayed and from the list of patient particular patient can be selected
	 * on the basis of admission number.
	 */

	/*public ModelAndView searchPatientOnBasisOfCare(HttpServletRequest request,
			HttpServletResponse response) {
		int nursingCareSetupId = 0;
		if (request.getParameter(RequestConstants.ADMISSION_NUMBER) != null) {
			nursingCareSetupId = Integer.parseInt(request
					.getParameter(RequestConstants.ADMISSION_NUMBER));

		}
		String deptName = request.getParameter("deptName");
		String caretime = request.getParameter("caretime");
		Map<String, Object> map = new HashMap<String, Object>();

		// int careId=(Integer)session.getAttribute("careId");
		map.put("nursingCareSetupId", nursingCareSetupId);
		// map.put("careId", careId);
		map = ipdHandlerService.searchPatientOnBasisOfCare(map);
		// Set set=(Set)map.get("patientSet");
		jsp = NURSING_CARE_ENTRY_JSP;
		jsp += ".jsp";
		title = "Nursing Entry Detail";
		map.put("deptName", deptName);
		map.put("caretime", caretime);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unused")
	public ModelAndView showNursingCareEntryDetailForPatientJsp(
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		int careId = Integer.parseInt(request.getParameter("cares"));
		String caretime = request.getParameter("caretime");
		int nursingId = Integer.parseInt(request.getParameter("nursingId"));
		// Map<String ,Object> map =new HashMap<String, Object>();
		map.put("nursingCareSetupId", nursingId);
		map = ipdHandlerService.searchPatientOnBasisOfCare(map);
		// Set set=(Set)map.get("patientSet");
		jsp = NURSING_CARE_ENTRY_DETAIL_JSP;
		// jsp += ".jsp";
		title = "Nursing Entry Detail";
		map.put("caretime", caretime);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}*/

	/*
	 * method to submit the details of the care given to all the patient and
	 * updating the database.
	 */

	/**
	 * New Method for show nursing care entry for single patient
	 * By Ritu
	 * Date 21 Dec 2011
	 */

	public ModelAndView showNewNursingCareEntryDetailsJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = ipdHandlerService.showNewNursingCareEntryDetailsJsp(box);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = ipdHandlerService.getPatientLatestDiagnosisAndDisability(box.getInt("parent"));
		if(detailsMap.get("diagnosisList")!=null){
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		if(detailsMap.get("disabilityList")!=null){
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}
		jsp = "nursingCareEntryDetails.jsp";

		title = "Nursing Entry Detail";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showDietEntryDetailsJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = ipdHandlerService.showDietEntryDetailsJsp(box);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = ipdHandlerService.getPatientLatestDiagnosisAndDisability(box.getInt("parent"));
		if(detailsMap.get("diagnosisList")!=null){
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		if(detailsMap.get("disabilityList")!=null){
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}
		jsp = "dietEntryDetails.jsp";

		title = "Nursing Entry Detail";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showConsultationEntryDetailsJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = ipdHandlerService.showConsultationEntryDetailsJsp(box);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = ipdHandlerService.getPatientLatestDiagnosisAndDisability(box.getInt("parent"));
		if(detailsMap.get("diagnosisList")!=null){
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		if(detailsMap.get("disabilityList")!=null){
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}
		jsp = "consultationEntryDetails.jsp";

		title = "Nursing Entry Detail";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView submitDietEntryDetails(
				HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession();
			int counter = Integer.parseInt(request.getParameter("counter"));
			Box box = HMSUtil.getBox(request);
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			Users users = (Users) session.getAttribute("users");
			int deptId = (Integer) session.getAttribute("deptId");
			String userName = (String) session.getAttribute("userName");
			map.put("users", users);
			map = ipdHandlerService.getUserButtonRights(map);
			System.out.println("request.geval"+request.getParameter("id"));
			System.out.println("request.geval"+request.getParameterValues("id"));
			List<UserButtonRights> userRightsList = (List<UserButtonRights>) map
					.get("userRightsList");

            System.out.println("request.getParamter"+request.getParameter("remarks0"));
			map.put("message", message);			
			map.put("hospitalId", hospitalId);			
			map.put("deptId", deptId);
			map.put("userName", userName);		
			
			boolean successfullyAdded = ipdHandlerService
					.submitDietEntryDetails(box);
			/*map = ipdHandlerService.getPatientList(deptId,hospitalId);*/
			map = ipdHandlerService.getPatientListAndNotification(deptId,hospitalId, users.getEmployee().getId());
			List set = (List) map.get("inpatientSet");
			map.put("inPatientSet", set);
			jsp = PATIENT_LIST_JSP;
			if (successfullyAdded) {
				message = "Diet has been submitted Successfully !!";
			} else {
				message = " Error Ocurred Please Try Again !!";
			}
			map.put("userRightsList", userRightsList);

			// jsp = NURSING_DETAILS_JSP;
			jsp += ".jsp";
			// title = "Nursing Details";
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("title", title);

			return new ModelAndView("indexB", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView submitConsultaionEntryDetails(
				HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession();
/*			int counter = Integer.parseInt(request.getParameter("counter"));*/
			Box box = HMSUtil.getBox(request);
			/*int hospitalId = (Integer) session.getAttribute("hospitalId");
			Users users = (Users) session.getAttribute("users");*/
			int deptId = (Integer) session.getAttribute("deptId");				
			
			boolean successfullyAdded = ipdHandlerService
					.submitConsultaionEntryDetails(box);
			int userId=0;
			if(session.getAttribute("userId")!=null){
				userId=(Integer)session.getAttribute("userId");
				box.put("userId",userId);
			}
			int hospitalId=0;
			hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
			map=ipdHandlerService.getReferalList(hospitalId,userId);
			/*map = ipdHandlerService.getPatientListAndNotification(deptId,hospitalId, users.getEmployee().getId());*/
			
			
			if (successfullyAdded) {
				message = "Consultation has been submitted Successfully !!";
			} else {
				message = " Error Ocurred Please Try Again !!";
			}
			
			jsp = "internalReferalIP.jsp";
			
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("title", title);

			return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView submitNursingCareEntryDetails(
				HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession();
			int counter = Integer.parseInt(request.getParameter("counter"));
			List nursingCareSetupIdList = new ArrayList();
			List careList = new ArrayList();
			List adNoList = new ArrayList();
			List hinIdList = new ArrayList();
			List ipdcaredetailIdList = new ArrayList();
			List timeOfCareList = new ArrayList();
			List careRemarksList = new ArrayList();
			List stopList = new ArrayList();
			
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			Users users = (Users) session.getAttribute("users");
			int deptId = (Integer) session.getAttribute("deptId");
			String userName = (String) session.getAttribute("userName");
			map.put("users", users);
			map = ipdHandlerService.getUserButtonRights(map);
			List<UserButtonRights> userRightsList = (List<UserButtonRights>) map
					.get("userRightsList");



			for (int j = 0; j < counter; j++) {
		//		String care = request.getParameter("care" + j);
				String timeOfCare = request.getParameter("careTime");
				String careRemarks = request.getParameter("careremarks" + j);
				int nursingcareSetupId = Integer.parseInt(request
						.getParameter("nursingId" + j));
				nursingCareSetupIdList.add(nursingcareSetupId);
				if (request.getParameter("care" + j) != null) {
					String careValue = request.getParameter("care" + j);
					String admissionNumber = request.getParameter("adNo" + j);
					int hin = Integer.parseInt(request.getParameter("hinId" + j));
					timeOfCareList.add(timeOfCare);
					careList.add(careValue);
					adNoList.add(admissionNumber);
					hinIdList.add(hin);
					careRemarksList.add(careRemarks);
					ipdcaredetailIdList.add(request.getParameter("ipdcaredetailId"
							+ j));
					
				}else{
					careList.add("");
					adNoList.add("");
					hinIdList.add("");
					careRemarksList.add("");
					ipdcaredetailIdList.add("");
					timeOfCareList.add("");
				}
				if(request.getParameter("stop"+j)!=null){
					stopList.add("y");
				}else{
					stopList.add("");
				}
			}
			map.put("message", message);
			map.put("nursingCareSetupIdList", nursingCareSetupIdList);
			map.put("careList", careList);
			map.put("adNoList", adNoList);
			map.put("hinIdList", hinIdList);
			map.put("hospitalId", hospitalId);
			map.put("ipdcaredetailIdList", ipdcaredetailIdList);
			map.put("deptId", deptId);
			map.put("userName", userName);
			map.put("timeOfCareList", timeOfCareList);
			map.put("careRemarksList", careRemarksList);
			map.put("stopList", stopList);
			boolean successfullyAdded = ipdHandlerService
					.submitNursingCareEntryDetails(map);
			/*map = ipdHandlerService.getPatientList(deptId,hospitalId);*/
			map = ipdHandlerService.getPatientListAndNotification(deptId,hospitalId, users.getEmployee().getId());
			List set = (List) map.get("inpatientSet");
			map.put("inPatientSet", set);
			jsp = PATIENT_LIST_JSP;
			if (successfullyAdded) {
				message = "Cares has been submitted Successfully !!";
			} else {
				message = " Error Ocurred Please Try Again !!";
			}
			map.put("userRightsList", userRightsList);

			// jsp = NURSING_DETAILS_JSP;
			jsp += ".jsp";
			// title = "Nursing Details";
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("title", title);

			return new ModelAndView("indexB", "map", map);
	}
	/*
	 * method to show the ward list for sealection and ajax is called on
	 * selecting the purticular ward.
	 */
	public ModelAndView showWardList(HttpServletRequest request,
			HttpServletResponse response) {

		int deptId = 0;
		HttpSession session = request.getSession();
		String buttonFlag = "";
		String issueNoOfWard = "";
		String fromDate = "";
		String toDate = "";
		Map<String, Object> map = new HashMap<String, Object>();
		String deptName = request.getParameter("deptName");
		int deptId1 = (Integer) session.getAttribute("deptId");
		map = ipdHandlerService.showWardList(deptName, deptId1);

		if (request.getParameter("buttonFlag") != null) {
			buttonFlag = request.getParameter("buttonFlag");
			int pageNo = Integer.parseInt(request.getParameter("pageNo"));
			if (buttonFlag.equals("next")) {
				deptId = Integer.parseInt(request.getParameter("deptId"));
				issueNoOfWard = request.getParameter("issueNoOfWard");
				fromDate = request.getParameter("fromDate");
				toDate = request.getParameter("toDate");
				pageNo++;
				map.put("pageNo", pageNo);
				map.put("deptId", deptId);
				map.put("buttonFlag", buttonFlag);
				map.put("issueNoOfWard", issueNoOfWard);
				map.put("fromDate", fromDate);
				map.put("toDate", toDate);
			}
		}

		jsp = WARD_LIST_JSP;
		jsp += ".jsp";
		title = "Ward Consumption";
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/*
	 * method to show the ward consumption screen withe grid populating while
	 * selecting the brand name and list of stock is displayed.
	 */

	public ModelAndView showWardConsumptionJsp(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		String issueNoOfWard = "";
		String buttonFlag = "";
		// int deptId=Integer.parseInt(request.getParameter("deptId"));
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		String deptName = request.getParameter("deptName");
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		String date = request.getParameter("date");
		String fromDate = "";
		String toDate = "";
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = request.getParameter(FROM_DATE);
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = request.getParameter(TO_DATE);
		}

		String time = request.getParameter("time");
		// String fromDate= request.getParameter(RequestConstants.FROM_DATE);
		// String toDate= request.getParameter(RequestConstants.TO_DATE);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("deptId", deptId);

		buttonFlag = request.getParameter("buttonFlag");
		if (!request.getParameter("buttonFlag").equals("")
				&& buttonFlag != null) {
			if (buttonFlag.equals("next")) {
				buttonFlag = request.getParameter("buttonFlag");
				issueNoOfWard = request.getParameter("issueNoOfWard");
				map.put("buttonFlag", buttonFlag);
				map.put("issueNoOfWard", issueNoOfWard);
			}
		}
		map = ipdHandlerService.showWardConsumptionJsp(map);

		jsp = WARD_CONSUMPTION_JSP;
		title = "Ward Consumption";
		map.put("pageNo", pageNo);
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("date", date);
		map.put("time", time);
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	/*
	 * method to open the pop up screen after selecting the brand name and
	 * window will populate the grid with the data and user can issue the
	 * quantity there onn the screen.
	 */
	public ModelAndView showStockDetailsJsp(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		String deptName = request.getParameter("deptName");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		int rowVal = Integer.parseInt(request.getParameter("rowVal"));

		int brandId = 0;
		if (request.getParameter("brandId") != null
				&& !request.getParameter("brandId").equals("")) {
			brandId = Integer.parseInt(request.getParameter("brandId"));
		}
		// int wardIssueNo=Integer.parseInt(request.getParameter("ipissueno"));
		// int
		// storeFyDocumentNoId=Integer.parseInt(request.getParameter("storeFyDocumentNoId"));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("deptName", deptName);
		map.put("deptId", deptId);
		map.put("brandId", brandId);
		map.put("rowVal", rowVal);
		map = ipdHandlerService.showStockDetailsJsp(map);

		jsp = STOCK_DETAILS_JSP;

		title = "Ward Consumption";
		map.put("deptId", deptId);

		map.put("date", date);
		map.put("time", time);
		// map.put("fromDateToDate", fromDateToDate);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	/*
	 * method to take the records from the jsp and passing those parameters to
	 * the dataservice layer for submitting the records whose quantity has been
	 * entered in the tesxt field.
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView submitWardConsumptionDetails(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List issQtyList = new ArrayList();
		List amountList = new ArrayList();
		List pvmsList = new ArrayList();
		List batchNumberList = new ArrayList();
		List brandNameList = new ArrayList();
		List expiryDateList = new ArrayList();
		List costPriceList = new ArrayList();
		List storeItemBatchStockIdList = new ArrayList();
		String itemId = request.getParameter("itemId");
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		String date = request.getParameter("date");
		String time = request.getParameter("time");

		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("toDate");

		int hospitalId = (Integer) session.getAttribute("hospitalId");
		String userName = (String) session.getAttribute("userName");
		int storeFyDocumentNoId = Integer.parseInt(request
				.getParameter("storeFyDocumentNoId"));
		int wardIssueNo = Integer.parseInt(request.getParameter("ipissueno"));
		int counter = Integer.parseInt(request.getParameter("counter"));
		for (int i = 0; i < counter; i++) {

			String str = request.getParameter("issueQty" + i);
			if (str.length() > 0) {
				// int qty=Integer.parseInt(request.getParameter("issueQty"+i));
				issQtyList.add(request.getParameter("issueQty" + i));
				pvmsList.add(itemId);
				batchNumberList.add(request.getParameter("batchNo" + i));
				brandNameList.add(request.getParameter("brandId" + i));
				expiryDateList.add(request.getParameter("expiryDate" + i));
				costPriceList.add(request.getParameter("costprice" + i));
				storeItemBatchStockIdList.add(request
						.getParameter("storeItemBatchStockId" + i));
				amountList.add(request.getParameter("amount" + i));
			}
		}
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("date", date);
		map.put("time", time);
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("userName", userName);
		map.put("pvmsList", pvmsList);
		map.put("batchNumberList", batchNumberList);
		map.put("brandNameList", brandNameList);
		map.put("expiryDateList", expiryDateList);
		map.put("issQtyList", issQtyList);
		map.put("costPriceList", costPriceList);
		map.put("amountList", amountList);
		map.put("storeItemBatchStockIdList", storeItemBatchStockIdList);
		map.put("storeFyDocumentNoId", storeFyDocumentNoId);
		map.put("wardIssueNo", wardIssueNo);
		boolean successfullyAdded = ipdHandlerService
				.submitWardConsumptionDetails(map);
		if (successfullyAdded) {
			message = "Stock  has been Updated Successfully !!";
		} else {
			message = "Error Ocurred Please Try Again!!";
		}
		jsp = STOCK_UPDATED_MESSAGE_JSP;

		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	/*
	 * This is the method to display a pop up screen with the records for the
	 * current issue number and the user can select the records for removing
	 * from the stock.
	 */

	public ModelAndView modifyWardConsumptionJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		int ipIssueNo = Integer.parseInt(request.getParameter("ipIssueNo"));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ipIssueNo", ipIssueNo);
		map = ipdHandlerService.modifyWardConsumptionJsp(map);

		jsp = MODIFY_WARD_CONSUMPTION_JSP;
		title = "Modify Ward Consumption";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	/*
	 * This is the method to delete the records for the current issue number and
	 * the user can select the records from the list and delete that and the
	 * stock will be updated for that record.
	 */

	public ModelAndView deleteStockDetails(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int ipIssueTId = Integer.parseInt(request.getParameter("parent"));
		map.put("ipIssueTId", ipIssueTId);
		boolean successfullyDeleted = ipdHandlerService.deleteStockDetails(map);

		if (successfullyDeleted) {
			message = "Stock  has been Deleted Successfully !!";
		} else {
			message = "Error Ocurred Please Try Again!!";
		}
		jsp = STOCK_UPDATED_MESSAGE_JSP;
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	/*
	 * This method is to view the stock details for the purticular issue number.
	 */
	public ModelAndView viewStockDetailsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		int ipIssueNo = Integer.parseInt(request.getParameter("issueNo"));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ipIssueNo", ipIssueNo);
		map = ipdHandlerService.modifyWardConsumptionJsp(map);

		jsp = VIEW_STOCK_DETAILS_JSP;
		title = "View Stock Details";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	/*
	 * method to show patient issue screen while taking the details from the
	 * patient list screen and passing those values to the dataservice layer.
	 */
	public ModelAndView showPatientIssueJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String buttonFlag = "";
		HttpSession session = request.getSession();
		int inPatientId = Integer.parseInt(request.getParameter("parent"));
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		String deptName = request.getParameter("deptName");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("inPatientId", inPatientId);
		map.put("deptId", deptId);

		if (request.getParameter("buttonFlag") != null) {
			buttonFlag = request.getParameter("buttonFlag");
			int pageNo = Integer.parseInt(request.getParameter("pageNo"));
			int issueNoOfPatient = Integer.parseInt(request
					.getParameter("issueNoOfPatient"));
			if (buttonFlag.equals("next")) {
				deptId = Integer.parseInt(request.getParameter("deptId"));
				pageNo++;
				map.put("pageNo", pageNo);
				map.put("deptId", deptId);
				map.put("buttonFlag", buttonFlag);
				map.put("issueNoOfPatient", issueNoOfPatient);
			}
		}
		map = ipdHandlerService.showPatientIssueJsp(map);
		jsp = PATIENT_ISSUE_JSP;
		jsp += ".jsp";
		title = "Patient Issue";
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}
	/*--------------------------Medicine Issue code by anamika------------------------------------------*/
	public ModelAndView showMedicineIssueDetailJsp(HttpServletRequest request,HttpServletResponse response) {
	  Map<String, Object> map = new HashMap<String, Object>();
	  HttpSession session = request.getSession();
	  int inPatientId = 0;
		if (request.getParameter("parent") != null
				&& request.getParameter("parent") != "") {
			inPatientId = Integer.parseInt(request.getParameter("parent"));
		}
		Box box = HMSUtil.getBox(request);
		int deptId = (Integer)(session.getAttribute("deptId"));
		box.put("inPatientId", inPatientId);
		box.put("deptId", deptId);
		map = ipdHandlerService.showMedicineIssueDetailJsp(box);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = ipdHandlerService.getPatientLatestDiagnosisAndDisability(box.getInt("parent"));
		if(detailsMap.get("diagnosisList")!=null){
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		if(detailsMap.get("disabilityList")!=null){
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}
		jsp = "medicine_issue_jsp";
		jsp += ".jsp";
		title = "Medicine Issue";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView getMedicineDetailList(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = ipdHandlerService.getMedicineDetailList(box);
		jsp = "responseForMedicineDetails";
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView submitMedicineIssueDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
		Users users = (Users) session.getAttribute("users");
		box.put("users", users);
		box.put("hospitalId", hospitalId);
		map = ipdHandlerService.submitMedicineIssueDetails(box);
		boolean flag = false;
		if(map.get("flag")!=null){
			flag = (Boolean)map.get("flag");
		}
		if(flag){
			map.put("message", "Record saved successfully.");
		}else{
			map.put("message", "Try again.");
		}
		jsp = "medicine_issue_jsp";
		jsp += ".jsp";
		title = "Medicine Issue";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView displayMedicineDetailList(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = ipdHandlerService.displayMedicineDetailList(box);
		jsp = "responseForViewMedicineIssueDetails";
		//jsp += ".jsp";
		return new ModelAndView(jsp, "map", map);
	}


 /*-----------------------------------------------------------------------------------------------------*/
	/*
	 * This method is to get the list of items in the grid for the auto complete
	 * functionality while entering the value for the Brand name it will show
	 * the list for the matching pattern and user can select from the list.
	 */
	public ModelAndView getItemList(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----

		int deptId = 0;
		int hospitalId = 0;

		HttpSession session = request.getSession();

		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		String itemNameField = "";
		String autoHint = "";

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			map.put("autoHint", autoHint);
			map.put("deptId", deptId);
			map.put("userName", userName);
			map = ipdHandlerService.getItemList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "responseInGrid";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getItemListForWardConsume(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----

		int deptId = 0;
		@SuppressWarnings("unused")
		int hospitalId = 0;

		HttpSession session = request.getSession();

		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		String itemNameField = "";
		String autoHint = "";

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			map.put("autoHint", autoHint);
			map.put("deptId", deptId);
			map.put("userName", userName);
			map = ipdHandlerService.getItemListForWardConsume(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "responseInGrid";
		return new ModelAndView(jsp, "map", map);
	}

	/*
	 * This method is for filing the items in the grid after selecting the value
	 * of Brand name in the grid it will populate the grid with the records
	 * corresponding to that pucticular Brand.
	 */
	@SuppressWarnings( { "unused", "unchecked" })
	public void fillItemsInGrid(HttpServletRequest request,
			HttpServletResponse response) {

		Box box = HMSUtil.getBox(request);
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		HttpSession session = request.getSession();
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
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
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
		map = ipdHandlerService.fillItemsInGrid(dataMap);
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
				// sb.append("<stockIn>" + stockIn + "</stockIn>");
				sb.append("</item>");
			}
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
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");

		} catch (Exception e) {
			e.printStackTrace();
		}

		// return new ModelAndView(jsp, "map", map);
	}

	/*
	 * method to show the stock details pop up window with the data loaded in
	 * the grid for issuing the quantity and updating the records.
	 */
	@SuppressWarnings("unused")
	public ModelAndView showPatientIssueStockDetailsJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int deptId = 0;
		deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		int rowVal = Integer.parseInt(request.getParameter("rowVal"));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("deptId", deptId);
		map.put("itemId", box.getInt("itemId"));

		map = ipdHandlerService.showStockDetailsJsp(map);
		map.put("rowVal", rowVal);
		jsp = PATIENT_ISSUE_STOCK_DETAILS_JSP;
		title = "Ward Consumption";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showWardConsumptionIssueStockDetailsJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int deptId = 0;
		int ipissueno = 0;
		String fromDate = "";
		String toDate = "";
		deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		int rowVal = Integer.parseInt(request.getParameter("rowVal"));

		if (request.getParameter("ipissueno") != null) {
			ipissueno = Integer.parseInt(request.getParameter("ipissueno"));
		}

		if (request.getParameter("fromDate") != null) {
			fromDate = request.getParameter("fromDate");
		}

		if (request.getParameter("todate") != null) {
			toDate = request.getParameter("todate");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("deptId", deptId);
		map.put("itemId", box.getInt("itemId"));

		map = ipdHandlerService.showStockDetailsJsp(map);
		map.put("rowVal", rowVal);
		jsp = WARD_CONSUMPTION_ISSUE_STOCK_DETAILS_JSP;
		title = "Ward Consumption";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("ipissueno", ipissueno);
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		return new ModelAndView(jsp, "map", map);
	}

	/*
	 * This method is for taking all the parameters from the form which displays
	 * the stock for thatBrand name including the parameters from the parent
	 * window of patient issue and tranfersthos values to the DS layer which
	 * will update the stock as well as entering the quantityissued for the
	 * purticular brand in master and trabnsaction tables.
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView submitPatientIssueDetails(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List issQtyList = new ArrayList();
		List amountList = new ArrayList();
		Box box = HMSUtil.getBox(request);
		// List pvmsList= new ArrayList();

		List batchNumberList = new ArrayList();
		List brandNameList = new ArrayList();
		List expiryDateList = new ArrayList();
		List costPriceList = new ArrayList();
		List storeItemBatchStockIdList = new ArrayList();
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		int hinId = 0;
		if ((request.getParameter("hinId") != null)
				&& (!request.getParameter("hinId").equals("")))
			hinId = Integer.parseInt(request.getParameter("hinId"));
		String admissionNumber = request.getParameter("admissionNumber");

		int hospitalId = (Integer) session.getAttribute("hospitalId");
		String userName = (String) session.getAttribute("userName");
		int storeFyDocumentNoId = 0;
		if ((request.getParameter("storeFyDocumentNoId") != null)
				&& (!request.getParameter("storeFyDocumentNoId").equals("")))
			storeFyDocumentNoId = Integer.parseInt(request
					.getParameter("storeFyDocumentNoId"));
		int patientIssueNo = 0;
		if ((request.getParameter("ipissueno") != null)
				&& (!request.getParameter("ipissueno").equals("")))
			patientIssueNo = Integer
					.parseInt(request.getParameter("ipissueno"));
		int counter = 0;
		if ((request.getParameter("counter") != null)
				&& (!request.getParameter("counter").equals("")))
			counter = Integer.parseInt(request.getParameter("counter"));
		for (int i = 0; i < counter; i++) {
			String str = request.getParameter("issueQty" + i);
			if (str.length() > 0) {
				// int qty=Integer.parseInt(request.getParameter("issueQty"+i));
				issQtyList.add(request.getParameter("issueQty" + i));
				// pvmsList.add(itemId);
				batchNumberList.add(request.getParameter("batchNo" + i));
				brandNameList.add(request.getParameter("brandId" + i));
				expiryDateList.add(request.getParameter("expiryDate" + i));
				costPriceList.add(request.getParameter("costprice" + i));
				storeItemBatchStockIdList.add(request
						.getParameter("storeItemBatchStockId" + i));
				amountList.add(request.getParameter("amount" + i));
			}
		}
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("date", date);
		map.put("time", time);
		map.put("itemId", itemId);
		map.put("userName", userName);
		// map.put("pvmsList", pvmsList);
		map.put("batchNumberList", batchNumberList);
		map.put("brandNameList", brandNameList);
		map.put("expiryDateList", expiryDateList);
		map.put("issQtyList", issQtyList);
		map.put("costPriceList", costPriceList);
		map.put("amountList", amountList);
		map.put("storeItemBatchStockIdList", storeItemBatchStockIdList);
		map.put("storeFyDocumentNoId", storeFyDocumentNoId);
		map.put("patientIssueNo", patientIssueNo);
		map.put("hinId", hinId);
		map.put("admissionNumber", admissionNumber);
		boolean successfullyAdded = ipdHandlerService
				.submitPatientIssueDetails(map);
		if (successfullyAdded) {
			message = "Stock  has been Updated Successfully !!";
		} else {
			message = "Error Ocurred Please Try Again!!";
		}
		jsp = STOCK_UPDATED_MESSAGE_FOR_PI_JSP;

		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView submitWardConsumptionIssueDetails(
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		List issQtyList = new ArrayList();
		List amountList = new ArrayList();

		// List pvmsList= new ArrayList();

		List batchNumberList = new ArrayList();
		List brandNameList = new ArrayList();
		List expiryDateList = new ArrayList();
		List costPriceList = new ArrayList();
		List storeItemBatchStockIdList = new ArrayList();
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		int hinId = 0;
		if ((request.getParameter("hinId") != null)
				&& (!request.getParameter("hinId").equals("")))
			hinId = Integer.parseInt(request.getParameter("hinId"));
		String admissionNumber = request.getParameter("admissionNumber");

		int hospitalId = (Integer) session.getAttribute("hospitalId");
		String userName = (String) session.getAttribute("userName");
		int storeFyDocumentNoId = 0;
		if ((request.getParameter("storeFyDocumentNoId") != null)
				&& (!request.getParameter("storeFyDocumentNoId").equals("")))
			storeFyDocumentNoId = Integer.parseInt(request
					.getParameter("storeFyDocumentNoId"));

		int patientIssueNo = 0;
		if ((request.getParameter("ipissueno") != null)
				&& (!request.getParameter("ipissueno").equals("")))
			patientIssueNo = Integer
					.parseInt(request.getParameter("ipissueno"));
		String fromDate = "";
		if (request.getParameter("fromDate") != null
				&& !request.getParameter("fromDate").equals(""))
			fromDate = request.getParameter("fromDate");

		String toDate = "";
		if (request.getParameter("toDate") != null
				&& !request.getParameter("toDate").equals(""))
			toDate = request.getParameter("toDate");

		int counter = 0;
		if ((request.getParameter("counter") != null)
				&& (!request.getParameter("counter").equals("")))
			counter = Integer.parseInt(request.getParameter("counter"));
		for (int i = 0; i < counter; i++) {
			String str = request.getParameter("issueQty" + i);
			if (str.length() > 0) {
				// int qty=Integer.parseInt(request.getParameter("issueQty"+i));
				issQtyList.add(request.getParameter("issueQty" + i));
				// pvmsList.add(itemId);
				batchNumberList.add(request.getParameter("batchNo" + i));
				brandNameList.add(request.getParameter("brandId" + i));
				expiryDateList.add(request.getParameter("expiryDate" + i));
				costPriceList.add(request.getParameter("costprice" + i));
				storeItemBatchStockIdList.add(request
						.getParameter("storeItemBatchStockId" + i));
				amountList.add(request.getParameter("amount" + i));
			}
		}
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("date", date);
		map.put("time", time);
		map.put("itemId", itemId);
		map.put("userName", userName);
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		// map.put("pvmsList", pvmsList);
		map.put("batchNumberList", batchNumberList);
		map.put("brandNameList", brandNameList);
		map.put("expiryDateList", expiryDateList);
		map.put("issQtyList", issQtyList);
		map.put("costPriceList", costPriceList);
		map.put("amountList", amountList);
		map.put("storeItemBatchStockIdList", storeItemBatchStockIdList);
		map.put("storeFyDocumentNoId", storeFyDocumentNoId);
		map.put("patientIssueNo", patientIssueNo);
		map.put("hinId", hinId);
		map.put("admissionNumber", admissionNumber);
		boolean successfullyAdded = ipdHandlerService
				.submitWardConsumptionIssueDetails(map);
		if (successfullyAdded) {
			message = "Stock  has been Updated Successfully !!";
		} else {
			message = "Error Ocurred Please Try Again!!";
		}
		jsp = STOCK_UPDATED_MESSAGE_FOR_PI_JSP;

		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	/*
	 * This method is for displaying the stock for the purticular patient with
	 * the admission number in the pop up window and the user can delete the
	 * records.
	 */
	@SuppressWarnings("unused")
	public ModelAndView showModifyPatientIssueJsp(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		int ipIssueNo = Integer.parseInt(request.getParameter("ipIssueNo"));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ipIssueNo", ipIssueNo);
		map = ipdHandlerService.modifyWardConsumptionJsp(map);

		jsp = MODIFY_WARD_CONSUMPTION_JSP;
		title = "Modify Ward Consumption";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	/*
	 * This method is to
	 */
	@SuppressWarnings("unused")
	public ModelAndView viewPatientIssueJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		String admissionNumber = request.getParameter("admissionNumber");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("admissionNumber", admissionNumber);
		map = ipdHandlerService.viewPatientIssueDetails(map);

		jsp = VIEW_PATIENT_ISSUE_JSP;
		title = "Modify Ward Consumption";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView showPatientDiagnosisJsp(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		int deptId = 0;
		int inPatientId = Integer.parseInt(request.getParameter("parent"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		String deptName = request.getParameter("deptName");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("inPatientId", inPatientId);
		map.put("deptId", deptId);
		map = ipdHandlerService.showPatientDiagnosisJsp(map);
		map.put("deptName", deptName);
		jsp = PATIENT_DIAGNOSIS_JSP;
		jsp += ".jsp";
		title = "Patient Diagnosis";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getICDList(HttpServletRequest request,
			HttpServletResponse response) {

		int deptId = 0;
		@SuppressWarnings("unused")
		int hospitalId = 0;

		HttpSession session = request.getSession();

		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		String itemNameField = "";
		String autoHint = "";
		String Z09 = "";
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter("XX") != null) {
				Z09 = (request.getParameter("XX"));
			}
			//System.out.println("Z09   ==============" + Z09);
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			map.put("autoHint", autoHint);
			map.put("deptId", deptId);
			map.put("userName", userName);
			map = ipdHandlerService.getICDList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "responseForSilDil";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView addPatientDiagnosisInformation(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int hinId = 0;
		int inpatientId = 0;
		String addEditTime = "";
		String deptName = "";
		Date addEditDate = null;
		String dType = "p";
		if (request.getParameter(HIN_ID) != null) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter("parent") != null) {
			dType = (request.getParameter("parent"));
		}
		int deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (request.getParameter(INPATIENT_ID) != null) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
		}
		if (request.getParameter("deptName") != null) {
			deptName = request.getParameter("deptName");
		}
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();

		Users users = (Users) session.getAttribute("users");
		map.put("users", users);
		map = ipdHandlerService.getUserButtonRights(map);
		List<UserButtonRights> userRightsList = (List<UserButtonRights>) map
				.get("userRightsList");

		if (request.getParameter("date") != null) {
			addEditDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter("date"));

		}
		if (request.getParameter("time") != null) {
			addEditTime = request.getParameter("time");

		}
		Map<String, Object> dischargeMap = new HashMap<String, Object>();

		int hdb = 1;
		if (Integer.parseInt(request.getParameter("hdb")) != 1) {
			hdb = Integer.parseInt(request.getParameter("hdb"));
		}

		String[] icdIdArr = new String[hdb];
		String diagnosisStatus[] = new String[hdb];
		String str = "";
		try {
			for (int i = 0; i < hdb; i++) {
				if (request.getParameter("icd" + str) != null) {
					String icd = request.getParameter("icd" + str);
					if (icd.length() > 0) {
						int index1 = icd.lastIndexOf("[");
						int index2 = icd.lastIndexOf("]");
						index1++;
						icdIdArr[i] = (icd.substring(index1, index2));
						diagnosisStatus[i] = request.getParameter("parent"
								+ str);
						str = (i + 1 + 1) + "";
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<DischargeIcdCode> icdCodeList = new ArrayList<DischargeIcdCode>();

		try {
			for (int i = 0; i < hdb; i++) {
				DischargeIcdCode dischargeIcdCode = new DischargeIcdCode();
				if (icdIdArr[i] != null && !icdIdArr[i].equals("")) {
					Patient patient = new Patient();
					patient.setId(hinId);
					dischargeIcdCode.setHin(patient);
					Inpatient inpatient = new Inpatient();
					inpatient.setId(inpatientId);
					dischargeIcdCode.setInpatient(inpatient);
					if (request.getParameter(Z03) != null) {
						dischargeIcdCode.setZ03("y");
					} else {
						dischargeIcdCode.setZ03("n");
					}
					if (request.getParameter(Z09) != null) {
						dischargeIcdCode.setZ09("y");
					} else {
						dischargeIcdCode.setZ09("n");
					}

					Users userObject = new Users();
					userObject.setId(userId);
					dischargeIcdCode.setAddEditBy(userObject);

					dischargeIcdCode.setAddEditDate(addEditDate);
					dischargeIcdCode.setAddEditTime(addEditTime);
					dischargeIcdCode.setStatus("y");
					dischargeIcdCode.setDiagnosisStatus(diagnosisStatus[i]);
					icdCodeList.add(dischargeIcdCode);
				}
			}
			dischargeMap.put("icdCodeList", icdCodeList);
			dischargeMap.put("icdIdArr", icdIdArr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String message = "";
		try {
			boolean dischargeInfoSave = false;
			dischargeInfoSave = ipdHandlerService
					.addPatientDiagnosisInformation(dischargeMap);
			if (dischargeInfoSave) {
				message = " Diagnosis Information has been submitted Successfully.";

			} else {
				message = "Problem Occured! Try Again.";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		if (dType.equals("f")) {
			map.put("inPatientId", inpatientId);
			map.put("deptId", deptId);
			map = ipdHandlerService.showPatientDiagnosisJsp(map);
			map.put("deptName", deptName);
			jsp = PATIENT_DIAGNOSIS_JSP;

		} else {
			jsp = PATIENT_LIST_JSP;
			map = ipdHandlerService.getPatientList(deptId,hospitalId);
			map.put("userRightsList", userRightsList);
			List set = (List) map.get("inpatientSet");
			map.put("inPatientSet", set);
		}
		jsp += ".jsp";

		map.put("deptName", deptName);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("parent", inpatientId);
		return new ModelAndView("indexB", "map", map);

}

	@SuppressWarnings("unused")
	public ModelAndView showSilDilJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int deptId = 0;
		HttpSession session = request.getSession();
		Users userObj = (Users)session.getAttribute("users");
		int inPatientId = Integer.parseInt(request.getParameter("parent"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
		String deptName = request.getParameter("deptName");
		Map<String, Object> map = new HashMap<String, Object>();
		if(userObj!= null){
			map.put("user", userObj);
		}
		map.put("inPatientId", inPatientId);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map = ipdHandlerService.showSilDilJsp(map);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = ipdHandlerService.getPatientLatestDiagnosisAndDisability(inPatientId);
		if(detailsMap.get("diagnosisList")!=null){
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		if(detailsMap.get("disabilityList")!=null){
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}
		map.put("deptName", deptName);
		jsp = SIL_DIL_JSP;
		jsp += ".jsp";
		title = "";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings( { "unused", "unchecked" })
	public ModelAndView submitSilDilStatus(HttpServletRequest request,
			HttpServletResponse response) {
		String conditionStatus = "";
		String patientCondition = "";
		String message = "";
		int hospitalId = 0;
		String adNo="";
		String hinNo="";
		String serviceNo="";
		if(request.getParameter("adNo") != null && !request.getParameter("adNo").equals("")){
			adNo = request.getParameter("adNo");
			}
		if(request.getParameter("hinNo") != null && !request.getParameter("hinNo").equals("")){
			hinNo = request.getParameter("hinNo");
			}
		if(request.getParameter("serviceNo") != null && !request.getParameter("serviceNo").equals("")){
			serviceNo = request.getParameter("serviceNo");
			}
		HttpSession session = request.getSession();
		if (session.getAttribute("hospitalId") != null){
			 hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		
		String diagnosisStatus = request.getParameter("parent");
		int inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		String deptName = request.getParameter("deptName");
		String date = request.getParameter("date");
		String treatment = request.getParameter("treatment");
		String condition = "";
		if(request.getParameter("condition") != null && !request.getParameter("condition").equals("")){
		 condition = request.getParameter("condition");
		}
		//String remarks = request.getParameter("remarks");
		String time = request.getParameter("time");
		String silDilTime = request.getParameter("silDilTime");
		String nokType = request.getParameter("nokType");
		String sil_dil_remarks = request.getParameter("remarks");
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		int hinId = Integer.parseInt(request.getParameter("hinId"));
		String adt = "";
		if (request.getParameter("adt") != null) {
			adt = (request.getParameter("adt"));
		}
		int placedBy = Integer.parseInt(request.getParameter("placedBy"));
		/*String icdCode = "";
		String icd = request.getParameter("icd");
		if (!icd.equals("")) {
			int index1 = icd.lastIndexOf("[");
			int index2 = icd.lastIndexOf("]");
			index1++;
			icdCode = "" + icd.substring(index1, index2);
		}*/
		String andNo = request.getParameter(AD_NO);

		String userName = request.getParameter("userName");
		Map<String, Object> map = new HashMap<String, Object>();

		String[] diagnosidIdArray = null;
		try {
			StringBuffer diagnosidStr = new StringBuffer();
			int tempdiagnosid = 0;
			if (request.getParameterValues(DIAGNOSIS_ID) != null) {
				diagnosidIdArray = (String[]) (request
						.getParameterValues(DIAGNOSIS_ID));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (diagnosisStatus.equals("normal")) {
			conditionStatus = "Normal";
			patientCondition = "Normal";
		} else {
			if (diagnosisStatus.equals("sil")) {
				conditionStatus = "SIL";
				patientCondition = "Critical";
			} else {
				conditionStatus = "DIL";
				patientCondition = "Critical";
			}
		}
		Users users = (Users) session.getAttribute("users");
		/*Users users = new Users();
		users.setId((Integer)session.getAttribute("userId"));*/
		/*System.out.println("userId"+session.getAttribute("userId"));*/
		map.put("users", users);
		map.put("patientCondition", patientCondition);
		map.put("conditionStatus", conditionStatus);
		map.put("condition", condition);
		//map.put("icdCode", icdCode);
		map.put("inpatientId", inpatientId);
		map.put("date", date);
		map.put("deptId", deptId);
		map.put("treatment", treatment);
		//map.put("remarks", remarks);
		map.put("time", time);
		map.put("userName", userName);
		map.put("silDilTime", silDilTime);
		map.put("placedBy", placedBy);
		map.put("nokType", nokType);
		map.put("hinId", hinId);
		map.put("deptName", deptName);
		map.put("diagnosidIdArray", diagnosidIdArray);
		map.put("sil_dil_remarks", sil_dil_remarks);
		boolean successfullyUpadated = ipdHandlerService.submitSilDilStatus(map);
		/*map = ipdHandlerService.getPatientList(deptId,hospitalId);*/
		map = ipdHandlerService.getPatientListAndNotification(deptId,hospitalId, users.getEmployee().getId());
		List set = (List) map.get("inpatientSet");
		map.put("inPatientSet", set);
		/*jsp = "messageForWard";*/
		jsp = PATIENT_LIST_JSP;
		String backUrl = "/hms/hms/ipd?method=showPatientListJsp";
		if (successfullyUpadated) {
			map.put("printUrl", "/hms/hms/ipd?method=showSilDilReport&adNo="+adNo+"&hinNo="+hinNo+"&serviceNo="+serviceNo);
			message = "Sil Dil Information saved Successfully !!";
		} else {
			message = " Error Ocurred Please Try Again !!";
		}
		map.put("backUrl", "/hms/hms/ipd?method=showPatientListJsp");
		//---------commented by anamika----------------
		/*if (successfullyUpadated) {
			if (adt.equals("yes"))
				jsp = MESSAGE_FOR_SILDIL_IN_ADT;
			else
				jsp = MESSAGE_FOR_SILDIL;
			message = " Sil Dil Information saved Successfully. Do you want to print ?";
		} else {
			if (adt.equals("yes"))
				jsp = MESSAGE_FOR_SILDIL_IN_ADT;
			else
				jsp = MESSAGE_FOR_SILDIL;
			message = "Error in Submitting the Information !!";
		}*/
		jsp += ".jsp";
		title = "";
		map.put("backUrl", backUrl);
		map.put("andNo", andNo);
		map.put("deptName", deptName);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);

	}

	// ------------------------------End of the methods written by
	// vikas---------------------------------

	// -------------------------------Nursing Clinical
	// Chart--------------------------------------
	/*public ModelAndView showNursingClinicalChartJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int departmentId = (Integer) session.getAttribute("deptId");
		String deptName = request.getParameter("deptName");
		map = ipdHandlerService.showNursingClinicalChartJsp(departmentId);
		String jsp = CLINICAL_CHART_JSP;
		jsp += ".jsp";
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

*/
	public ModelAndView showNewNursingClinicalChartJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = ipdHandlerService.showNewNursingClinicalChartJsp(box);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = ipdHandlerService.getPatientLatestDiagnosisAndDisability(box.getInt("parent"));
		if(detailsMap.get("diagnosisList")!=null){
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		if(detailsMap.get("disabilityList")!=null){
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}
		String jsp = CLINICAL_CHART_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}


	@SuppressWarnings( { "deprecation", "unchecked" })
	public ModelAndView submitNursingClinicalChart(HttpServletRequest request,
				HttpServletResponse response) {

			HttpSession session = request.getSession();
			if (session.getAttribute("userName") != null) {
				userName = (String) session.getAttribute("userName");
			}
			int deptId = (Integer) session.getAttribute("deptId");
			Map<String, Object> map = new HashMap<String, Object>();

			int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			Box box = HMSUtil.getBox(request);
			
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("box", box);
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("deptId", deptId);
			dataMap.put("userName", userName);
			boolean successfullyAdded = ipdHandlerService
					.addNursingClinicalChart(dataMap);

			Users users = (Users) session.getAttribute("users");
			dataMap.put("users", users);
			map = ipdHandlerService.getUserButtonRights(dataMap);
			List<UserButtonRights> userRightsList = (List<UserButtonRights>) map
					.get("userRightsList");


			if (successfullyAdded) {
				/*map = ipdHandlerService.getPatientList(deptId,hospitalId);*/
				map = ipdHandlerService.getPatientListAndNotification(deptId,hospitalId, users.getEmployee().getId());
				List set = (List) map.get("inpatientSet");
				map.put("inPatientSet", set);
				map.put("userRightsList", userRightsList);
				jsp = PATIENT_LIST_JSP;
				message = "Record Added Successfully !!";
			} else {
				/*map = ipdHandlerService.getPatientList(deptId,hospitalId);*/
				map = ipdHandlerService.getPatientListAndNotification(deptId,hospitalId, users.getEmployee().getId());
				List set = (List) map.get("inpatientSet");
				map.put("inPatientSet", set);
				map.put("userRightsList", userRightsList);
				jsp = PATIENT_LIST_JSP;
				message = " Error Ocurred Please Try Again !!";
			}

			jsp += ".jsp";
			title = "Clinical Chart";
			map.put("message", message);
			map.put("deptId", deptId);
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("indexB", "map", map);
		}


	@SuppressWarnings("unchecked")
	public ModelAndView showViewClinicalChartJsp(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String radio_str = "";
		int deptId = 0;
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		String deptName = request.getParameter("deptName");
		if (request.getParameter("parent") != null) {
			radio_str = request.getParameter("parent");
			dataMap.put("radio_str", radio_str);
			dataMap.put("deptId", deptId);
			map = (Map) ipdHandlerService.getViewClinicalChart(dataMap);
		}
		jsp = VIEW_CLINICAL_CHART;
		jsp += ".jsp";
		// map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("radio_str", radio_str);

		return new ModelAndView("indexB", "map", map);
	}

	// ------------------------------------------Intake/Output Chart Of
	// Particular Patient----------------------------------------

	public ModelAndView showIntakeOutputJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		int deptId = (Integer) session.getAttribute("deptId");
		int inPatient = Integer.parseInt(request.getParameter("parent"));
		String deptName = request.getParameter("deptName");
		Map<String, Object> map = new HashMap<String, Object>();
		map = ipdHandlerService.showIntakeOutputJsp(inPatient);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = ipdHandlerService.getPatientLatestDiagnosisAndDisability(inPatient);
		if(detailsMap.get("diagnosisList")!=null){
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		if(detailsMap.get("disabilityList")!=null){
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}
		jsp = INTAKE_OUTPUT_JSP;
		jsp += ".jsp";
		title = "IntakeOutput";
		map.put("deptName", deptName);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("inpatientId", inPatient);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings( { "deprecation", "unchecked" })
	public ModelAndView submitIntakeOutput(HttpServletRequest request,
			HttpServletResponse response) {
		String lastChgBy = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String lastChgDate = (String) utilMap.get("currentDate");
		String lastChgTime = (String) utilMap.get("currentTimeWithoutSc");
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		String intakeOutputTime = (String) utilMap.get("currentTimeWithoutSc");
		String intakeOutputDate = (String) utilMap.get("currenDate");
		HttpSession session = request.getSession();
		Users users = (Users)session.getAttribute("users");
		@SuppressWarnings("unused")
		Date temperatureDate = new Date();
		Date intakeDate = new Date();
		Date outputDate = new Date();
		int hinId = 0;
		String adNo = null;
		String treatment = null;
		@SuppressWarnings("unused")
		String currentTime;
		List ipdTemperatureObjList = new ArrayList();
		List ipdIntakeObjList = new ArrayList();
		List ipdOutputObjList = new ArrayList();
		
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		List list = new ArrayList();
		int departmentId = (Integer) session.getAttribute("deptId");

		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		IpdIntakeOutputChart ipdIntakeOutputChart = new IpdIntakeOutputChart();

		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		ipdIntakeOutputChart.setDepartment(masDepartment);

		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		ipdIntakeOutputChart.setHospital(masHospital);
		int inpatientId = 0;
		if (!request.getParameter("inpatientId").equals("0")) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);
			ipdIntakeOutputChart.setInpatient(inpatient);
		}
		if (!request.getParameter(HIN_ID).equals("0")) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			Patient patientObj = new Patient();
			patientObj.setId(hinId);
			ipdIntakeOutputChart.setHin(patientObj);
		}
		if (request.getParameter(AD_NO) != null) {
			adNo = String.valueOf(request.getParameter(AD_NO));
			Inpatient inpatientObj = new Inpatient();
			inpatientObj.setAdNo(adNo);
			ipdIntakeOutputChart.setAdNo(adNo);
		}
		if (request.getParameter(TREATMENT) != null) {
			treatment = request.getParameter(TREATMENT);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			lastChgBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			lastChgDate = request.getParameter(CHANGED_DATE);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			lastChgTime = request.getParameter(CHANGED_TIME);
		}
		ipdIntakeOutputChart.setLastChgBy(userName);

		ipdIntakeOutputChart.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(lastChgDate));
		ipdIntakeOutputChart.setLastChgTime(lastChgTime);
		ipdIntakeOutputChart.setIntakeDate(HMSUtil
				.convertStringTypeDateToDateType(intakeOutputDate));
		ipdIntakeOutputChart.setTime(intakeOutputTime);
		ipdIntakeOutputChart.setTreatment(treatment);
		ipdIntakeOutputChart.setIntakeDate(HMSUtil
				.convertStringTypeDateToDateType(currentDate));
		ipdIntakeOutputChart.setTime(time);
		int deptId = (Integer) session.getAttribute("deptId");
		Date[] temperatureDateArray = new Date[100];
		Date[] intakeDateArray = new Date[100];
		Date[] outputDateArray = new Date[100];
		/**
		 * Commented By Ritu on 23 Dec 2011
		 */

		// ----------------------------------Temperature
		// Grid------------------------------------------

		try {
			/*float[] temperatureArr = JKTRequestUtils
					.getRequiredFloatParameters(request, TEMPERATURE);
			String zz[] = JKTRequestUtils.getRequiredStringParameters(request,
					TEMPERATURE_DATE);
			int zzLegnt = zz.length;
			for (int i = 0; i < zzLegnt; i++) {

				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(zz[i]));
				temperatureDate = java.sql.Date.valueOf(date4MySQL);
				temperatureDateArray[i] = temperatureDate;
			}
			String[] temperatureTimeArr = JKTRequestUtils.getStringParameters(
					request, TEMPERATURE_TIME);
			int pulseArr[] = JKTRequestUtils.getIntParameters(request, PULSE);
			int respirationArr[] = JKTRequestUtils.getIntParameters(request,
					RESPIRATION);
			String[] bpArr = JKTRequestUtils.getStringParameters(request, BP);
			String[] temperatureRemarksArr = JKTRequestUtils
					.getStringParameters(request, TEMPERATURE_REMARKS);
			String[] bowelArr = JKTRequestUtils.getStringParameters(request,
					BOWEL);
			String[] painArr = JKTRequestUtils.getStringParameters(request,
					PAIN);
			String[] fhrArr = JKTRequestUtils.getStringParameters(request, FHR);

			int templength = temperatureArr.length;
			int pulselength = pulseArr.length;
			int resplength = respirationArr.length;
			int bplength = bpArr.length;

			if (pulselength != 0 || resplength != 0 || bplength != 0) {
				if (request.getParameter(CHANGED_BY) != null
						&& !(request.getParameter(CHANGED_BY).equals(""))) {
					lastChgBy = request.getParameter(CHANGED_BY);
				}
				if (request.getParameter(CHANGED_TIME) != null
						&& !(request.getParameter(CHANGED_TIME).equals(""))) {
					lastChgTime = request.getParameter(CHANGED_TIME);
				}

				for (int i = 0; i < temperatureArr.length; i++) {
					IpdTemperature ipdTemperature = new IpdTemperature();

					if (temperatureDateArray[i] != null) {
						ipdTemperature.setIpdDate(temperatureDateArray[i]);
					}
					if (temperatureArr[i] != 0) {
						ipdTemperature.setTemperature(temperatureArr[i]);
					}

					try {
						ipdTemperature.setPulse(pulseArr[i]);
					} catch (Exception e) {
						ipdTemperature.setPulse(0);
					}

					try {
						ipdTemperature.setRespiration(respirationArr[i]);
					} catch (Exception e) {
						ipdTemperature.setRespiration(0);
					}

					try {
						ipdTemperature.setBp(bpArr[i]);
					} catch (Exception e) {
						ipdTemperature.setBp("");
					}

					try {
						ipdTemperature.setRemarks(temperatureRemarksArr[i]);
					} catch (Exception e) {
						ipdTemperature.setRemarks("");
					}

					if (temperatureTimeArr[i] != null) {
						ipdTemperature.setTime(temperatureTimeArr[i]);
					}
					ipdTemperature.setLastChgBy(userName);
					try {
						ipdTemperature.setFhr(fhrArr[i]);
					} catch (Exception e) {
						ipdTemperature.setFhr("");
					}
					try {
						ipdTemperature.setPain(painArr[i]);
					} catch (Exception e) {
						ipdTemperature.setPain("");
					}
					try {
						ipdTemperature.setBowel(bowelArr[i]);
					} catch (Exception e) {
						ipdTemperature.setBowel("");
					}

					ipdTemperature.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(lastChgDate));
					ipdTemperature.setLastChgTime(lastChgTime);
					ipdTemperatureObjList.add(ipdTemperature);
				}
			}*/
			// ----------------------------------------Intake
			// Grid--------------------------------------
			String intakeArr[] = request.getParameterValues(INTAKE);
			String intakeTypeArr[] = request.getParameterValues("intakeType");
			String aa[] = request.getParameterValues(INTAKE_DATE);
			int aaLegnt = aa.length;
			for (int i = 0; i < aaLegnt; i++) {

				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(aa[i]));
				intakeDate = java.sql.Date.valueOf(date4MySQL);

				intakeDateArray[i] = intakeDate;
			}
			String ipdIntakeIdArr[] = request.getParameterValues("ipdIntakeId");
			String intakeTimeArr[] = request.getParameterValues(INTAKE_TIME);
			String[] oralArr = request.getParameterValues(ORAL);
			String[] ivCountArr = request.getParameterValues(IV);
			String[]  ivArr= request.getParameterValues(IV_COMBO);
			String intakeTotalArr[] = request.getParameterValues("intakeTotal");
			String[] intakeRemarksArr = request.getParameterValues(INTAKE_REMARKS);
			if (request.getParameter(CHANGED_BY) != null
					&& !(request.getParameter(CHANGED_BY).equals(""))) {
				lastChgBy = request.getParameter(CHANGED_BY);
			}
			if (request.getParameter(CHANGED_TIME) != null
					&& !(request.getParameter(CHANGED_TIME).equals(""))) {
				currentTime = request.getParameter(CHANGED_TIME);
			}
			int intakelength = intakeArr.length;
			int orallength = oralArr.length;
			int ivlength = ivArr.length;
			int ivcountlength = ivCountArr.length;
			if (intakelength != 0 || orallength != 0 || ivlength != 0
					|| ivcountlength != 0) {
				for (int i = 0; i < intakeArr.length; i++) {

					if(ipdIntakeIdArr[i].equals("")) {

					IpdIntake ipdIntake = new IpdIntake();

					if (intakeDateArray[i] != null) {
						ipdIntake.setIpdIntakeDate(intakeDateArray[i]);
					}
					try {
						ipdIntake.setIntake(intakeArr[i]);
					} catch (Exception e) {
						ipdIntake.setIntake("");
					}
					try {
						ipdIntake.setIntakeType(intakeTypeArr[i]);
					} catch (Exception e) {
						ipdIntake.setIntakeType("");
					}
					if (intakeTimeArr[i] != null) {
						ipdIntake.setTime(intakeTimeArr[i]);
					}
					try {
						ipdIntake.setOral(oralArr[i]);
					} catch (Exception e) {
						ipdIntake.setOral("");
					}
					try {
						ipdIntake.setIv(ivArr[i]);
					} catch (Exception e) {
						ipdIntake.setIv("");
					}
					try {
						ipdIntake.setIvCount(ivCountArr[i]);
					} catch (Exception e) {
						ipdIntake.setIvCount("");
					}
					try {
						ipdIntake.setIntakeTotal(new BigDecimal(intakeTotalArr[i]));
					} catch (Exception e) {
						ipdIntake.setIntakeTotal(new BigDecimal(0));
					}
					try {
						ipdIntake.setRemarks(intakeRemarksArr[i]);
					} catch (Exception e) {
						ipdIntake.setRemarks("");
					}
					ipdIntake.setLastChgBy(userName);
					ipdIntake.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(lastChgDate));
					ipdIntake.setLastChgTime(lastChgTime);
					ipdIntake.setDepartment(masDepartment);
					ipdIntakeObjList.add(ipdIntake);
					}
				}
			}
			// -----------------------------------------Output
			// Grid-------------------------------------------

			String ipdOutputIdArr[] = request.getParameterValues("ipdOutputId");
			String outputArr[] = request.getParameterValues(OUTPUT);
			String bb[] = request.getParameterValues(OUTPUT_DATE);
			int bbLegnt = bb.length;
			for (int i = 0; i < bbLegnt; i++) {

				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(bb[i]));
				outputDate = java.sql.Date.valueOf(date4MySQL);
				outputDateArray[i] = outputDate;
			}
			String outputTimeArr[] =request.getParameterValues(OUTPUT_TIME);
			String[] urineArr = request.getParameterValues(URINE);
			String[] stoolArr =request.getParameterValues(STOOL);
			String[] vomArr = request.getParameterValues(VOM);
			String[] aspArr = request.getParameterValues( ASP);
			String outputRemarksArr[] =request.getParameterValues(OUTPUT_REMARKS);
		/*	String drainTimeArr[] = request.getParameterValues(DRAIN_TIME);
			String[] drainArr = request.getParameterValues(DRAIN);
			String girthTimeArr[] = request.getParameterValues(GIRTH_TIME);
			String[] girthArr = request.getParameterValues(GIRTH);
			String insulinTimeArr[] = request.getParameterValues(INSULIN_TIME);
			String[] insulinArr = request.getParameterValues(INSULIN);
			String bloodsugarTimeArr[] =request.getParameterValues(BLOOD_SUGAR_TIME);
			String[] bloodSugarArr =request.getParameterValues(BLOOD_SUGAR);
			String drainRemarksArr[] = request.getParameterValues(DRAIN_REMARKS);*/
			if (request.getParameter(CHANGED_BY) != null
					&& !(request.getParameter(CHANGED_BY).equals(""))) {
				lastChgBy = request.getParameter(CHANGED_BY);
			}
			if (request.getParameter(CHANGED_TIME) != null
					&& !(request.getParameter(CHANGED_TIME).equals(""))) {
				currentTime = request.getParameter(CHANGED_TIME);
			}
			int outputlength = outputArr.length;
			int urinelength = urineArr.length;
			int stoollength = stoolArr.length;
			int vomlength = vomArr.length;
			int asplength = aspArr.length;
		/*	int drainlength = drainArr.length;
			int girthlength = girthArr.length;
			int insulinlength = insulinArr.length;
			int bloodsugarlength = bloodSugarArr.length;*/
		/*
			if (outputlength != 0 || urinelength != 0 || stoollength != 0
					|| vomlength != 0 || asplength != 0 || drainlength != 0
					|| girthlength != 0 || insulinlength != 0
					|| bloodsugarlength != 0) {
				int count = 0;
				if(outputlength > 0){
					count=outputlength;
				}else if(drainlength > 0){
					count=drainlength;
				}*/

			if (outputlength != 0 || urinelength != 0 || stoollength != 0
					|| vomlength != 0 || asplength != 0) {
				int count = 0;
				if(outputlength > 0){
					count=outputlength;
				}
				for (int i = 0; i < count; i++) {
					if(ipdOutputIdArr[i].equals("") && (!outputArr[i].equals("") )) {
					IpdOutput ipdOutput = new IpdOutput();

					if (outputlength>0 && outputDateArray[i] != null) {
						ipdOutput.setIpdOutputDate(outputDateArray[i]);
					}
					try {
						if(outputlength >0)
							ipdOutput.setOutput(outputArr[i]);
					} catch (Exception e) {
						ipdOutput.setOutput("");
					}
					if (urinelength > 0 && urineArr[i] != null) {
						ipdOutput.setUrine(urineArr[i]);
					}
					try {
						if(stoollength >0)
							ipdOutput.setStool(stoolArr[i]);
					} catch (Exception e) {
						ipdOutput.setStool("");
					}
					try {
						if(vomlength > 0)
							ipdOutput.setVom(vomArr[i]);
					} catch (Exception e) {
						ipdOutput.setVom("");
					}
					try {
						if(asplength > 0)
							ipdOutput.setAsp(aspArr[i]);
					} catch (Exception e) {
						ipdOutput.setAsp("");
					}
				/*	if (drainlength>0 && drainTimeArr[i] != null) {
						ipdOutput.setDrainTime(drainTimeArr[i]);
					}
					try {
						if(drainlength>0)
							ipdOutput.setDrain(drainArr[i]);
					} catch (Exception e) {
						ipdOutput.setDrain("");
					}
					if (girthlength > 0 && girthTimeArr[i] != null) {
						ipdOutput.setGirthTime(girthTimeArr[i]);
					}
					try {
						if(girthlength > 0)
							ipdOutput.setGirth(girthArr[i]);
					} catch (Exception e) {
						ipdOutput.setGirth("");
					}
					if (insulinlength > 0 && insulinTimeArr[i] != null) {
						ipdOutput.setInsulinTime(insulinTimeArr[i]);
					}
					try {
						if(insulinlength > 0 )
							ipdOutput.setInsulin(insulinArr[i]);
					} catch (Exception e) {
						ipdOutput.setInsulin("");
					}
					if (bloodsugarlength >0 && bloodsugarTimeArr[i] != null) {
						ipdOutput.setBloodSugarTime(bloodsugarTimeArr[i]);
					}
					try {
						if(bloodsugarlength >0)
							ipdOutput.setBloodSugar(bloodSugarArr[i]);
					} catch (Exception e) {
						ipdOutput.setBloodSugar("");
					}*/
					try {
						if(outputRemarksArr.length > 0)
							ipdOutput.setRemarks(outputRemarksArr[i]);
					} catch (Exception e) {
						ipdOutput.setRemarks("");
					}

					/*try {
						if(drainRemarksArr.length >0)
							ipdOutput.setDrainRemarks(drainRemarksArr[i]);
					} catch (Exception e) {
						ipdOutput.setDrainRemarks("");
					}*/
					if (outputlength > 0 && outputTimeArr[i] != null) {
						ipdOutput.setTime(outputTimeArr[i]);
					}
					ipdOutput.setLastChgBy(userName);
					ipdOutput.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(lastChgDate));
					ipdOutput.setLastChgTime(lastChgTime);
					ipdOutput.setDepartment(masDepartment);
					ipdOutputObjList.add(ipdOutput);

				}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("admissionNumber", adNo);
		objMap.put("ipdIntakeOutputChart", ipdIntakeOutputChart);
		if (ipdTemperatureObjList.size() > 0) {
			objMap.put("ipdTemperatureObjList", ipdTemperatureObjList);
		}
		if (ipdIntakeObjList.size() > 0) {
			objMap.put("ipdIntakeObjList", ipdIntakeObjList);
		}
		if (ipdOutputObjList.size() > 0) {
			objMap.put("ipdOutputObjList", ipdOutputObjList);
		}
		String message = "";
		boolean successfullyAdded = ipdHandlerService.addIntakeOutput(objMap);
		if (successfullyAdded) {

			/*map = ipdHandlerService.getPatientList(deptId,hospitalId);*/
			map = ipdHandlerService.getPatientListAndNotification(deptId,hospitalId, users.getEmployee().getId());
			List inpatientSet = (List) map.get("inpatientSet");
			map.put("inPatientSet", inpatientSet);
			map.put("andNo", adNo);
			map.put("inpatientId", inpatientId);
			jsp = MESSAGE_FOR_INTAKE_OUTPUT;
			message = "Record Added Successfully .Do you want to print ?";

		} else {
			/*map = ipdHandlerService.getPatientList(deptId,hospitalId);*/
			map = ipdHandlerService.getPatientListAndNotification(deptId,hospitalId, users.getEmployee().getId());
			List inpatientSet = (List) map.get("inpatientSet");
			map.put("inPatientSet", inpatientSet);
			jsp = MESSAGE_FOR_INTAKE_OUTPUT;
			message = " Error Ocurred Please Try Again !!";

		}

		jsp += ".jsp";
		title = "IntakeOutput";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("deptId", deptId);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showViewIntakeOutputJsp(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String radio_str = "";
		String deptName = "";
		int departmentId = 0;
		String jsp = "";
		try {
			departmentId = (Integer) session.getAttribute("deptId");
			deptName = request.getParameter("deptName");
			if (request.getParameter(AD_NO) != null) {
				radio_str = request.getParameter(AD_NO);
				map = (Map) ipdHandlerService.getViewIntakeOutput(radio_str);
			}
			jsp = VIEW_INTAKE_OUTPUT;
			jsp += ".jsp";

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptName", deptName);
		map.put("radio_str", radio_str);
		return new ModelAndView("indexB", "map", map);
	}

	// --------------------------------IntakeOutputChartReport----------------------------------
	public ModelAndView showIntakeOutputChartReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = "";
		String andNo = "";
		HttpSession session = request.getSession();

		if (request.getParameter("hinNo") != null
				&& !(request.getParameter("hinNo").equals(""))) {
			hinNo = (request.getParameter("hinNo"));
		}
		if (request.getParameter("andNo") != null
				&& !(request.getParameter("andNo").equals(""))) {
			andNo = (request.getParameter("andNo"));
		}
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		requestParameters.put(HIN_NO, hinNo);
		requestParameters.put(HOSPITAL_ID, session.getAttribute("hospitalId"));
//		map = ipdHandlerService.getAdmissionNumberList(requestParameters);
		jsp = INTAKE_OUTPUT_REPORT_JSP;
		jsp += ".jsp";
		title = "title";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("hinNo", hinNo);
		map.put("andNo", andNo);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showIntakeOutputChartReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String admissionNumber = null;
		Date toDate = new Date();
		Date fromDate = new Date();
		String reportType="";
		String serviceNo="";
		int hinId=0;
		String hinNo="";
		int hospitalId=0;
		String reportName="";
		byte[] bytes = null;
		HttpSession session = request.getSession();
		hospitalId=Integer.parseInt(""+session.getAttribute("hospitalId"));
		requestParameters.put(HOSPITAL_ID, hospitalId);
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter("adNo") != null
					&& !(request.getParameter("adNo").equals(""))) {
				admissionNumber = request.getParameter("adNo");
			}
			if (request.getParameter("serviceNo") != null
					&& !(request.getParameter("serviceNo").equals(""))) {
				serviceNo = request.getParameter("serviceNo");
			}
			if (request.getParameter("hinId") != null
					&& !(request.getParameter("hinId").equals(""))) {
				hinId = Integer.parseInt(request.getParameter("hinId"));
				hinNo=ipdHandlerService.getHinNoForCaseSheet(hinId,hospitalId);
			}
			if (request.getParameter("reportType") != null
					&& !(request.getParameter("reportType").equals(""))) {
				reportType = request.getParameter("reportType");
			}
			if(reportType.equalsIgnoreCase("summary")){
				reportName="IntakeOutputNew";
			}
			else if(reportType.equalsIgnoreCase("detail")){
				parameters=ipdHandlerService.runIntakeOutputProc(hinNo,serviceNo,hospitalId,admissionNumber);
				reportName="intake_output_details_register";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map = ipdHandlerService.getDBConnection();
	//	map.put("fromDate", fromDate);
	//	map.put("toDate", toDate);
		map.put("hinNo", hinNo);
		map.put("serviceNo", serviceNo);
		map.put("hospitalId", hospitalId);
		map.put("adNo", admissionNumber);
		String hospitalName="";
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			hospitalName = ipdHandlerService.getHospitalName(hospitalId);
			parameters.put("hospitalName", hospitalName);
			parameters.put("hospitalId", hospitalId);
		}
		String userHome = getServletContext().getRealPath("");	         
        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
        map.put("path", imagePath);
		map.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		//System.out.println("getServletContext().getRealPath "+ getServletContext().getRealPath("/reports/"));
		// try {
		//
		// bytes =
		// JasperRunManager.runReportToPdf(getCompiledReport("IntakeOutput"),
		// map,(Connection) map.get("conn"));
		// HMSUtil.generateReport("IntakeOutput", map,
		// (Connection)map.get("conn"), response, getServletContext());
		//
		// } catch (JRException e) {
		// e.printStackTrace();
		// }
		// response.setContentType("application/pdf");
		// response.setContentLength(bytes.length);
		// ServletOutputStream ouputStream;
		// try {
		// ouputStream = response.getOutputStream();
		// ouputStream.write(bytes, 0, bytes.length);
		// ouputStream.flush();
		// ouputStream.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		HMSUtil.generateReport(reportName, map, (Connection) map
				.get("conn"), response, getServletContext());
		return null;
	}

	public ModelAndView showPatientSearchJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();

		if (request.getParameter("serviceNo") != null
				&& request.getParameter("serviceNo") != "") {
			requestParameters.put("serviceNo", request
					.getParameter("serviceNo"));
		}

		if (request.getParameter("serviceType") != null
				&& request.getParameter("serviceType") != "") {
			requestParameters.put("serviceType", request
					.getParameter("serviceType"));
		}

		if (request.getParameter("rank") != null
				&& request.getParameter("rank") != "") {
			requestParameters.put("rank", request.getParameter("rank"));
		}

		if (request.getParameter("unit") != null
				&& request.getParameter("unit") != "") {
			requestParameters.put("unit", request.getParameter("unit"));
		}

		if (request.getParameter("patientName") != null
				&& request.getParameter("patientName") != "") {
			requestParameters.put("patientName", request
					.getParameter("patientName"));
		}

		if (request.getParameter("servicePersonnelName") != null
				&& request.getParameter("servicePersonnelName") != "") {
			requestParameters.put("servicePersonnelName", request
					.getParameter("servicePersonnelName"));
		}

		if (request.getParameter("SearchFlag") != null
				&& request.getParameter("SearchFlag") != "") {
			requestParameters.put("SearchFlag", request
					.getParameter("SearchFlag"));
		}
		if (request.getParameter("adNo") != null
				&& request.getParameter("adNo") != "") {
			requestParameters.put("adNo", request.getParameter("adNo"));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		requestParameters.put("deptId", deptId);
		map = ipdHandlerService.getSearchPatientComboDetails(requestParameters);
		jsp = INTAKE_OUTPUT_PATIENT_SEARCH;
		title = "Patient Search Screen";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	// --------------------------------Method for Admission
	// Number-----------------------------------
	public ModelAndView getAdmissionNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
			detailsMap.put("serviceNo", serviceNo);
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			detailsMap.put("hinNo", hinNo);
		}
		List<Object> admissionNoList = new ArrayList<Object>();
		List<Object> hinNoList = new ArrayList<Object>();
		String flag = "";

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}

		if (flag.equals("admission")) {
			admissionNoList = ipdHandlerService.getAdmissionNoList(detailsMap);
			map.put("admissionNoList", admissionNoList);
			jsp = RESPONSE_FOR_ADMISSION_NO;
		} else if (flag.equals("hin")) {
			hinNoList = ipdHandlerService.getHinNoList(serviceNo);
			map.put("hinNoList", hinNoList);
			jsp = IPD_RESPONSE_INTAKE_OUTPUT_HIN_NO;
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getAdmissionNumberList(HttpServletRequest request,
			HttpServletResponse response) {
		String serviceNo = null;
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		requestParameters.put(HOSPITAL_ID, session.getAttribute("hospitalId"));
		if (request.getParameter(SERVICE_NO) != null
				&& request.getParameter(SERVICE_NO) != "") {
			serviceNo = request.getParameter(SERVICE_NO);
			requestParameters.put(SERVICE_NO, serviceNo);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map = ipdHandlerService.getAdmissionNumberList(requestParameters);
		jsp = "ipdAdmissionNumberPopulate";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getAdmissionNoList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
			detailsMap.put("serviceNo", serviceNo);
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			detailsMap.put("hinNo", hinNo);
		}
		List<Object> admissionNoList = new ArrayList<Object>();
		List<Object> hinNoList = new ArrayList<Object>();
		String flag = "";

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}

		if (flag.equals("admission")) {
			admissionNoList = ipdHandlerService.getAdmissionNoList(detailsMap);
			map.put("admissionNoList", admissionNoList);
			jsp = RESPONSE_DISCHARGE_AD_NO;
		} else if (flag.equals("hin")) {
			hinNoList = ipdHandlerService.getHinNoList(serviceNo);
			map.put("hinNoList", hinNoList);
			jsp = IPD_RESPONSE_FOR_HIN_NO;
		}

		return new ModelAndView(jsp, "map", map);

	}

	// -----------------------------DischargeSlip
	// Report-------------------------------------------
	public ModelAndView showDischargeSlipJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = DISCHARGE_SLIP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showDischargeSlipReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> tempMap = new HashMap<String, Object>();
		int inpatientId = 0;
		int dischargeId = 0;
		try {
			if (request.getParameter(INPATIENT_ID) != null) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
			} else {
				if (request.getParameter("parent") != null) {
					dischargeId = Integer.parseInt(request
							.getParameter("parent"));
					tempMap.put("dischargeId", dischargeId);
					tempMap = ipdHandlerService.getIpIdFormDischargeId(tempMap);
					if (tempMap.get("inpatientId") != null) {
						inpatientId = Integer.parseInt(""
								+ tempMap.get("inpatientId"));
					}

				}
			}
			parameters.put("inpatientId", inpatientId);
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("inpatientId", inpatientId);
			detailsMap = ipdHandlerService.getDiagnosisAndDocumentInit(dataMap);
			String docInit = "";
			String diagnosis = "";
			String icdNos = "";
			List<DischargeIcdCode> dischargeIcdCodeList = new ArrayList<DischargeIcdCode>();
			List<InpatientDocument> inpatientDocumentList = new ArrayList<InpatientDocument>();
			dischargeIcdCodeList = (List<DischargeIcdCode>) detailsMap
					.get("dischargeIcdCodeList");

			inpatientDocumentList = (List<InpatientDocument>) detailsMap
					.get("inpatientDocumentList");
			for (InpatientDocument inpatientDocument : inpatientDocumentList) {
				docInit = docInit
						+ inpatientDocument.getDocument().getDocumentName()
						+ ",";
			}
			int inc = 1;
			for (DischargeIcdCode dischargeIcdCode : dischargeIcdCodeList) {
				if (dischargeIcdCode.getZ09().equals("y")) {
					diagnosis = diagnosis
							+ inc
							+ ". "
							+ dischargeIcdCode.getIcd().getIcdSubCategory()
									.getIcdSubCategoryName() + " : "
							+ dischargeIcdCode.getIcd().getIcdName()
							+ "{OLD},\n";
				} else if (dischargeIcdCode.getZ03().equals("y")) {
					diagnosis = diagnosis
							+ inc
							+ ". "
							+ dischargeIcdCode.getIcd().getIcdSubCategory()
									.getIcdSubCategoryName() + " : "
							+ dischargeIcdCode.getIcd().getIcdName()
							+ "{NAD},\n";
				} else {
					diagnosis = diagnosis
							+ inc
							+ ". "
							+ dischargeIcdCode.getIcd().getIcdSubCategory()
									.getIcdSubCategoryName() + " : "
							+ dischargeIcdCode.getIcd().getIcdName() + ",\n";
				}
				inc++;
			}
			int inc2 = 1;
			for (DischargeIcdCode dischargeIcdCode : dischargeIcdCodeList) {
				if (dischargeIcdCode.getZ09().equals("y")) {
					icdNos = icdNos + inc2 + ". "
							+ dischargeIcdCode.getIcd().getIcdCode()
							+ " : Z09,\n";
				} else {
					icdNos = icdNos + inc2 + ". "
							+ dischargeIcdCode.getIcd().getIcdCode() + ",\n";
				}
				inc2++;
			}
			parameters.put("docInit", docInit);
			parameters.put("diagnosis", diagnosis.toUpperCase());
			parameters.put("icdNos", icdNos);
			byte[] bytes = null;
			// try {
			// try {
			// bytes
			// =JasperRunManager.runReportToPdf(getCompiledReport("Hospital_Discharge_Slip"),parameters,(Connection)detailsMap.get("conn"));
			// HMSUtil.generateReport("Hospital_Discharge_Slip", map,
			// (Connection)map.get("conn"), response, getServletContext());
			// } catch (Exception e) {
			//
			// e.printStackTrace();
			// }
			// response.setContentType("application/pdf");
			// response.setContentLength(bytes.length);
			// ServletOutputStream ouputStream;
			//
			// ouputStream = response.getOutputStream();
			// ouputStream.write(bytes, 0, bytes.length);
			// ouputStream.flush();
			// ouputStream.close();
			// } catch (Exception e) {
			// e.printStackTrace();
			// }
			HMSUtil.generateReport("Hospital_Discharge_Slip", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ------------------------Food tasting
	// Report--------------------------------
	public ModelAndView showFoodTastingReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		map = ipdHandlerService.showFoodTastingReportJsp();
		jsp = FOOD_TASTING;
		jsp += ".jsp";
		title = "foodTastingReport";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showFoodTastingReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		int departmentId = 0;
		String stringVariable = "";
		Date toDate = null;
		Date fromDate = null;

		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (!request.getParameter(DEPARTMENT_ID).equals("0")) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
			stringVariable = "" + departmentId;
		} else
			stringVariable = "";

		detailsMap = ipdHandlerService.getDBConnection();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		// parameters.put("stringVariable", stringVariable);
		// try {
		// byte bytes[] = null;
		// try
		// {
		// bytes =
		// JasperRunManager.runReportToPdf(getCompiledReport("food_tasting"),parameters,(Connection)detailsMap.get("conn"));
		// HMSUtil.generateReport("food_tasting", parameters,
		// (Connection)map.get("conn"), response, getServletContext());
		// }
		// catch(JRException e)
		// {
		// e.printStackTrace();
		// }
		// response.setContentType("application/pdf");
		// response.setContentLength(bytes.length);
		// ServletOutputStream ouputStream;
		// try {
		// ouputStream = response.getOutputStream();
		// ouputStream.write(bytes, 0, bytes.length);
		// ouputStream.flush();
		// ouputStream.close();
		// } catch (IOException e)
		// {
		// e.printStackTrace();
		// }
		// } catch (IllegalStateException e) {
		// e.printStackTrace();
		// }
		HMSUtil.generateReport("food_tasting", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	// -----------------------------------NursingCare
	// Report------------------------------------------
	public ModelAndView showNursingCareReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		HttpSession session = request.getSession();
		String hinNo = "";
		int deptId = 0;
		int careType = 0;
		String serviceNo = "";
		int patientId = 0;
		int nursingCareType = 0;
		String admissionNumber = "";
		if (request.getParameter("cares") != null) {
			careType = Integer.parseInt("" + request.getParameter("cares"));
		}
		int counter = 0;
		if (request.getParameter("counter") != null)
			counter = Integer.parseInt(request.getParameter("counter"));

		int hin = 0;
		for (int j = 0; j < counter; j++) {
			patientId = Integer.parseInt(request.getParameter("hinId" + j));
			admissionNumber = request.getParameter("adNo" + j);
		}

		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		if (request.getParameter("cares") != null) {
			nursingCareType = Integer.parseInt(""
					+ request.getParameter("cares"));
		}

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("patientId", patientId);
		map = ipdHandlerService.showNursingCareReportJsp(dataMap);
		patientList = (List<Patient>) map.get("patientList");
		if (patientList.size() > 0)
			for (Patient patient : patientList) {
				hinNo = ("" + patient.getHinNo());
				serviceNo = "" + patient.getServiceNo();
			}

		jsp = NURSING_CARE_REPORT;
		jsp += ".jsp";
		title = "nursingCareReport";
		map.put("contentJsp", jsp);
		map.put("title", title);

		map.put("nursingCareType", nursingCareType);
		map.put("serviceNo", serviceNo);
		map.put("hinNo", hinNo);

		map.put("careType", careType);
		map.put("deptId", deptId);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showNursingCareReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String hinNo = "";
		String toDate = "";
		int nursingCareId = 0;
		String stringVariable = "";
		String adNo="";
		String serviceNo="";
		int hinId=0;
		String query="";
		String fromDate = "";
		int dept = 0;
		String reportName="";
		String outputTo="";
		String fileName="";
		int hospitalId=Integer.parseInt(""+session.getAttribute(HOSPITAL_ID));
		byte[] bytes = null;
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				//toDate = HMSUtil.convertStringTypeDateToDateType(request
					//	.getParameter(TO_DATE));
				toDate=request.getParameter(TO_DATE);
				query=query+" and ipdcaredetail.date_of_care <= to_date('"+toDate+"','dd/MM/yyyy')";
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = request.getParameter(FROM_DATE);
				query=query+" and ipdcaredetail.date_of_care >= to_date('"+fromDate+"','dd/MM/yyyy')";
			}
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals(""))) {
				dept = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			}
			if (request.getParameter(NURSING_CARE_ID)!=null && !request.getParameter(NURSING_CARE_ID).equals("0")) {
				nursingCareId = Integer.parseInt(request
						.getParameter(NURSING_CARE_ID));
				stringVariable = "" + nursingCareId;
				query=query +" and nursingcare_setup.nursing_id = "+nursingCareId;
			} else
				stringVariable = "";
			if (request.getParameter("serviceNo") != null && request.getParameter("serviceNo") != "") {
				serviceNo = request.getParameter("serviceNo");
				query=query +" and patient.SERVICE_NO='"+serviceNo+"'";
			}
			if (request.getParameter("hinId") != null && request.getParameter("hinId") != "") {
				hinId = Integer.parseInt(request.getParameter("hinId"));
				query=query +" and ipdcaredetail.HIN_ID="+hinId;
			}
			if (request.getParameter("adNo") != null && request.getParameter("adNo") != "") {
				adNo = request.getParameter("adNo");
				query=query +" and nursingcare_setup.AD_NO='"+adNo+"'";
			}
			if (request.getParameter(HIN_NO) != null) {
				hinNo = request.getParameter(HIN_NO);
				parameterMap.put("hinNo", hinNo);
				query=query+" and patient.hin_no='"+hinNo+"'";
			}
			if (request.getParameter("outputTo") != null && !request.getParameter("outputTo").equals("0")) {
				outputTo = request.getParameter("outputTo");
			}
			if (request.getParameter("flagReport") != null && request.getParameter("flagReport") != "") {
				reportName = request.getParameter("flagReport");
			}else{
				reportName="NursingCareReportWithoutDate";
			}
			
			if (request.getParameter("fileName") != null && !request.getParameter("fileName").equals("")) {
				fileName = request.getParameter("fileName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		//int deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		map = ipdHandlerService.getDBConnection();
		query=query +" order by ipdcaredetail.date_of_care,patientName";
		map.put("query", query);
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("Ward", dept);
		map.put("hinNo", hinNo);
		map.put("hospitalId", hospitalId);
		ServletOutputStream ouputStream;
		//map.put("nId", Integer.parseInt(stringVariable));

		// try {
		// bytes =
		// JasperRunManager.runReportToPdf(getCompiledReport("NursingCareReport"),
		// map,(Connection) map.get("conn"));
		// HMSUtil.generateReport("food_tasting", map,
		// (Connection)map.get("conn"), response, getServletContext());
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		// try {
		// response.setContentType("application/pdf");
		// response.setContentLength(bytes.length);
		// ServletOutputStream ouputStream;
		// ouputStream = response.getOutputStream();
		// ouputStream.write(bytes, 0, bytes.length);
		// ouputStream.flush();
		// ouputStream.close();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		if(outputTo.equals("w")){
			if(fileName.equals("")){
			HMSUtil.generateReportInWord(reportName, map, (Connection) map
					.get("conn"), response, getServletContext());
			}
			else{
			HMSUtil.generateReportInWordForWard(fileName,reportName, map, (Connection) map
					.get("conn"), response, getServletContext());
			}
			
		}else{
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport(reportName), map,
						(Connection) map.get("conn"));
			} catch (JRException e) {
				e.printStackTrace();
			}
			if(fileName.equals("")){
			response.setHeader("Content-Disposition", "attachment; filename="+reportName+".pdf");
			}else{
				response.setHeader("Content-Disposition", "attachment; filename="+fileName+".pdf");
			}
			response.setContentLength(bytes.length);
			
			try {
				ouputStream = response.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		return null;
	}

	// -------------------------------------------------------------------------------------------------------------

	public ModelAndView getHinNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		String flag = "";
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
			detailsMap.put("serviceNo", serviceNo);
		}
		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			detailsMap.put("hinNo", hinNo);
		}
		if (request.getParameter("flag") != null
				&& !(request.getParameter("flag").equals(""))) {
			flag = request.getParameter("flag");
			map.put("flag", flag);
		}

		List<Object> hinNoList = new ArrayList<Object>();
		hinNoList = ipdHandlerService.getHinNo(serviceNo);
		map.put("hinNoList", hinNoList);

		String jsp = "populateHinNoForUpdate";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getPatientName(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = "";
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}
		String patientName = "";
		patientName = ipdHandlerService.getMothersName(hinNo);

		String jsp = "populatePatientNameForUpdate";
		map.put("name", patientName);
		return new ModelAndView(jsp, "map", map);
	}

	// ------------------------ Common Method for Report
	// ---------------------------

	// ------Duty Nursing Officer report------------
	public ModelAndView showDutyNursingReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int deptId = 0;
		deptId = (Integer) session.getAttribute("deptId");

		map = ipdHandlerService.showDutyNursingReportJsp();
		jsp = DUTY_NURSING_OFFICERS;
		jsp += ".jsp";
		title = "DutyNursingReport";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showDutyNursingReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> SILDILMap = new HashMap<String, Object>();
		int departmentId = 0;
		Date date = new Date();

		if (request.getParameter(DATE) != null
				&& !(request.getParameter(DATE).equals(""))) {
			date = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE));
		}
		dataMap.put("date", date);
		if (!request.getParameter(DEPARTMENT_ID).equals("0")) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
			dataMap.put("departmentId", departmentId);
		}
		String departmentName = ipdHandlerService.getdepartmentName(dataMap);
		SILDILMap = ipdHandlerService.getSILDILData(dataMap);
		int silcount = (Integer) SILDILMap.get("silcount");
		int dilcount = (Integer) SILDILMap.get("dilcount");


		String deptName = departmentName;

		detailsMap = ipdHandlerService.getDBConnection();
		parameters.put("toDate", date);
		parameters.put("silcount", silcount);
		parameters.put("dilcount", dilcount);
		parameters.put("deptId", departmentId);
		parameters.put("department_name", deptName);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		// try {
		// byte bytes[] = null;
		// try
		// {
		// bytes =
		// JasperRunManager.runReportToPdf(getCompiledReport("DutyNursingOfficersReport"),parameters,(Connection)detailsMap.get("conn"));
		// HMSUtil.generateReport("DutyNursingOfficersReport", parameters,
		// (Connection)map.get("conn"), response, getServletContext());
		// }
		// catch(JRException e)
		// {
		// e.printStackTrace();
		// }
		// response.setContentType("application/pdf");
		// response.setContentLength(bytes.length);
		// ServletOutputStream ouputStream;
		// try {
		// ouputStream = response.getOutputStream();
		// ouputStream.write(bytes, 0, bytes.length);
		// ouputStream.flush();
		// ouputStream.close();
		// } catch (IOException e)
		// {
		// e.printStackTrace();
		// }
		// } catch (IllegalStateException e) {
		// e.printStackTrace();
		// }
		HMSUtil.generateReport("DutyNursingOfficersReport", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	private JasperReport getCompiledReport(String fileName) throws JRException {
		File reportFile = new File(getServletContext().getRealPath(
				"/reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile.getPath());
		return jasperReport;
	}



	public ModelAndView showSilDilJspInAdt(HttpServletRequest request,HttpServletResponse response) {
		int deptId = 0;
		String adt = "";
		HttpSession session = request.getSession();
		int inPatientId = Integer.parseInt(request.getParameter(AD_NO));
		Users userObj = (Users)session.getAttribute("users");
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (request.getParameter("adt") != null)
			adt = ("" + request.getParameter("adt"));
		String deptName = request.getParameter("deptName");
		Map<String, Object> map = new HashMap<String, Object>();
		if(userObj!= null){
			map.put("user", userObj);
		}
		map.put("inPatientId", inPatientId);
		map.put("deptId", deptId);
		map = ipdHandlerService.showSilDilJsp(map);
		map.put("deptName", deptName);
		jsp = SIL_DIL_JSP;
		jsp += ".jsp";
		title = "";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("adt", adt);
		return new ModelAndView("indexB", "map", map);
	}


	public ModelAndView getICDCodeList(HttpServletRequest request,
			HttpServletResponse response) {

		int deptId = 0;
		@SuppressWarnings("unused")
		int hospitalId = 0;

		HttpSession session = request.getSession();

		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		String itemNameField = "";
		String autoHint = "";

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			map.put("autoHint", autoHint);
			map.put("deptId", deptId);
			map.put("userName", userName);
			map = ipdHandlerService.getICDCodeList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "responseForSilDil2";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showWaitingList(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int deptId = 0;
		HttpSession session = request.getSession();
		try {
			if (session.getAttribute("deptId") != null)
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("deptId", deptId);
		map = ipdHandlerService.showWaitingList(dataMap);

		jsp = WAITING_LIST;
		jsp += ".jsp";
		List set = (List) map.get("inpatientSet");
		map.put("inPatientSet", set);
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView submitWaitingList(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int deptId = 0;
		String saved = "no";
		String messageTOBeVisibleToTheUser = "";
		String messageType = "success";
		HttpSession session = request.getSession();
		try {
			if (session.getAttribute("deptId") != null)
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		map = ipdHandlerService.submitWaitingList(dataMap);
		if (map.get("saved") != null) {
			saved = "" + map.get("saved");
		}
		if (saved.equals("yes")) {
			messageTOBeVisibleToTheUser = "Admitted Successfully";
		} else {
			messageTOBeVisibleToTheUser = "Some problem occured .Try again ...!";
		}
		jsp = STORES_MESSAGE_JSP;
		jsp += ".jsp";
		@SuppressWarnings("unused")
		List set = (List) map.get("inpatientSet");
		String url = "/hms/hms/ipd?method=showWaitingList";
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("messageType", messageType);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showWardRemarksJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		jsp = WARD_REMARKS_JSP;
		jsp += ".jsp";
		title = "";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView saveWardRemarks(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		HttpSession session = null;
		String saved = "";
		String message = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		Box box = HMSUtil.getBox(request);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		box.put("deptId", deptId);
		box.put("userName", userName);
		dataMap.put("box", box);
		map = ipdHandlerService.saveWardRemarks(dataMap);
		if (map.get("saved") != null) {
			saved = "" + map.get("saved");
		}
		if (saved.equals("yes")) {
			message = "Remarks Added Successfully";
		} else {
			message = "Some problem Occured .Try again.";
		}
		jsp = WARD_REMARKS_JSP;
		jsp += ".jsp";
		title = "";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getWardRemarksDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String remarksDate = "";
		jsp = RESPONCE_FOR_WARD_DETAILS;
		if (request.getParameter("remarksDate") != null
				&& !(request.getParameter("remarksDate").equals(""))) {
			remarksDate = (request.getParameter("remarksDate"));
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("remarksDate", remarksDate);
		map = ipdHandlerService.getWardRemarksDetails(dataMap);

		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showDutyNursingOfficersRemarks(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		int departmentId = 0;
		Date date = new Date();

		if (request.getParameter(DATE_OF_WARD_MASTER) != null
				&& !(request.getParameter(DATE_OF_WARD_MASTER).equals(""))) {
			date = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_WARD_MASTER));
		}
		if (request.getParameter(DEPARTMENT_ID_TEMP) != null) {
			departmentId = Integer.parseInt(request
					.getParameter(DEPARTMENT_ID_TEMP));

		}
		String deptName = "";
		if (!request.getParameter("deptNameForRemarks").equals("0")) {
			deptName = (request.getParameter("deptNameForRemarks"));

		}
		detailsMap = ipdHandlerService.getDBConnection();


		parameters.put("Date", date);
		parameters.put("Dept_Id", departmentId);
		parameters.put("wardName", deptName);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		// try {
		// byte bytes[] = null;
		// try
		// {
		// bytes =
		// JasperRunManager.runReportToPdf(getCompiledReport("wardremarksForOfficers"),parameters,(Connection)detailsMap.get("conn"));
		// HMSUtil.generateReport("wardremarksForOfficers", parameters,
		// (Connection)map.get("conn"), response, getServletContext());
		// }
		// catch(Exception e)
		// {
		// e.printStackTrace();
		// }
		// response.setContentType("application/pdf");
		// response.setContentLength(bytes.length);
		// ServletOutputStream ouputStream;
		// try {
		// ouputStream = response.getOutputStream();
		// ouputStream.write(bytes, 0, bytes.length);
		// ouputStream.flush();
		// ouputStream.close();
		// } catch (IOException e)
		// {
		// e.printStackTrace();
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		HMSUtil.generateReport("wardremarksForOfficers", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView showPatientRemarksJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int inpatientId = 0;
		Map<String, Object> mapForPr = new HashMap<String, Object>();
		Map<String, Object> patientDetails = new HashMap<String, Object>();

		if (request.getParameter("parent") != null) {
			inpatientId = Integer.parseInt(request.getParameter("parent"));
			mapForPr.put("inpatientId", inpatientId);
		}
		patientDetails = ipdHandlerService.getPatientDetails(mapForPr);

		map.put("patientDetails", patientDetails);
		String jsp = "";
		jsp = "patientRemarksJsp.jsp";

		title = "";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView submitPatientRemarksInformation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();

		int inpatientId = 0;
		String adNo = null;
		String remarks = null;
		String condition = null;
		String treatment = null;
		String postOpCase = null;
		String date = null;

		if (request.getParameter("inpatientId") != null) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
			dataMap.put("inpatientId", inpatientId);
		}

		if (request.getParameter(AD_NO) != null) {
			adNo = request.getParameter(AD_NO);
			dataMap.put("adNo", adNo);
		}
		if (request.getParameter("condition") != null) {
			condition = request.getParameter("condition");
			dataMap.put("condition", condition);
		}
		if (request.getParameter("treatment") != null) {
			treatment = request.getParameter("treatment");
			dataMap.put("treatment", treatment);
		}
		if (request.getParameter("postOpCase") != null) {
			postOpCase = request.getParameter("postOpCase");
			dataMap.put("postOpCase", postOpCase);
		}
		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
			dataMap.put("remarks", remarks);
		}
		if (request.getParameter(CHANGED_DATE) != null) {
			Date addEditDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CHANGED_DATE));
			dataMap.put("addEditDate", addEditDate);
		}

		if (request.getParameter(DATE) != null) {
			Date date1 = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE));
			dataMap.put("date", date1);
		}

		if (request.getParameter(CHANGED_TIME) != null) {
			String addEditTime = request.getParameter(CHANGED_TIME);
			dataMap.put("addEditTime", addEditTime);
		}
		if (request.getParameter(CHANGED_BY) != null) {
			String addEditBy = request.getParameter(CHANGED_BY);
			dataMap.put("addEditBy", addEditBy);
		}

		boolean dataStatus = false;

		if (inpatientId != 0) {
			map = ipdHandlerService.submitPatientRemarks(dataMap);
		}
		String message = "";
		dataStatus = (Boolean) map.get("dataStatus");

		if (dataStatus) {
			message = " Patient Remarks has been submitted Successfully.";
		} else {
			message = "Some problem Occured! Try Again.";
		}

		/*
		 * String jsp =""; jsp = "patientRemarksJsp.jsp";
		 */
		jsp = MESSAGE_FOR_ADT_JSP + ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getPatientRemarksDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String remarksDate = "";
		int patientId = 0;
		jsp = RESPONCE_FOR_PATIENT_DETAILS;
		if (request.getParameter("remarksDate") != null
				&& !(request.getParameter("remarksDate").equals(""))) {
			remarksDate = (request.getParameter("remarksDate"));
		}
		if (request.getParameter("patientId") != null
				&& !(request.getParameter("patientId").equals(""))) {
			patientId = Integer.parseInt(request.getParameter("patientId"));
		}

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("remarksDate", remarksDate);
		dataMap.put("patientId", patientId);
		map = ipdHandlerService.getPatientRemarksDetails(dataMap);

		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView copyLastRT(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int inpatientId = 0;
		Map<String, Object> mapForPr = new HashMap<String, Object>();
		Map<String, Object> patientDetails = new HashMap<String, Object>();

		if (request.getParameter("parent") != null) {
			inpatientId = Integer.parseInt(request.getParameter("parent"));
			mapForPr.put("inpatientId", inpatientId);
		}
		String status = "No";
		if (request.getParameter("RT") != null) {
			status = request.getParameter("RT");

		}
		mapForPr.put("status", status);

		patientDetails = ipdHandlerService.getPatientDetails(mapForPr);

		map.put("patientDetails", patientDetails);
		String jsp = "";
		jsp = "patientRemarksJsp.jsp";

		title = "";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// end patient remarks
	public ModelAndView showWardConsumptionReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = null;
		int deptId = 0;
		Date date = new Date();
		int issueId = 0;
		session = request.getSession();
		if (request.getParameter("issueNo") != null
				&& !(request.getParameter("issueNo").equals(""))) {
			issueId = Integer.parseInt(request.getParameter("issueNo"));
		}

		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		detailsMap = ipdHandlerService.getDBConnection();
		parameters.put("issueId", issueId);
		parameters.put("Date", date);
		parameters.put("deptId", deptId);
		HMSUtil.generateReport("WardConsumptionReport", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView acceptPatientToWard(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = 0;
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		deptId = (Integer) session.getAttribute("deptId");
		Box box = HMSUtil.getBox(request);
		box.put("deptId", deptId);
		Users users = (Users)session.getAttribute("users");
		boolean flag = false;
		flag = ipdHandlerService.acceptPatientToWard(box);

		/*map = ipdHandlerService.getPatientList(deptId,hospitalId);*/
		map = ipdHandlerService.getPatientListAndNotification(deptId,hospitalId, users.getEmployee().getId());
		List inpatientSet = (List) map.get("inpatientSet");
		map.put("inPatientSet", inpatientSet);
		jsp = PATIENT_LIST_JSP;
		jsp += ".jsp";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);

	}
	
	public ModelAndView transferPatientToLaborRoom(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = 0;
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		deptId = (Integer) session.getAttribute("deptId");
		Box box = HMSUtil.getBox(request);
		box.put("deptId", deptId);
		Users users = (Users)session.getAttribute("users");
		boolean flag = false;
		flag = ipdHandlerService.transferPatientToLaborRoom(box);

		/*map = ipdHandlerService.getPatientList(deptId,hospitalId);*/
		map = ipdHandlerService.getPatientListAndNotification(deptId,hospitalId, users.getEmployee().getId());
		List inpatientSet = (List) map.get("inpatientSet");
		map.put("inPatientSet", inpatientSet);
		jsp = PATIENT_LIST_JSP;
		jsp += ".jsp";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);

	}
	
	public ModelAndView transferPatientToOT(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = 0;
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		deptId = (Integer) session.getAttribute("deptId");
		Box box = HMSUtil.getBox(request);
		box.put("deptId", deptId);
		Users users = (Users)session.getAttribute("users");
		boolean flag = false;
		flag = ipdHandlerService.transferPatientToOT(box);

		/*map = ipdHandlerService.getPatientList(deptId,hospitalId);*/
		map = ipdHandlerService.getPatientListAndNotification(deptId,hospitalId, users.getEmployee().getId());
		List inpatientSet = (List) map.get("inpatientSet");
		map.put("inPatientSet", inpatientSet);
		jsp = PATIENT_LIST_JSP;
		jsp += ".jsp";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView showPatientKitIssueJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = ipdHandlerService.getPatientDetailsForKitIssue(box);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = ipdHandlerService.getPatientLatestDiagnosisAndDisability(box.getInt("parent"));
		
		if(detailsMap.get("diagnosisList")!=null){
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		if(detailsMap.get("disabilityList")!=null){
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}
		jsp="patientKitIssue.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getTemplateDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box =HMSUtil.getBox(request);
		map = ipdHandlerService.getTemplateDetails(box);
		return new ModelAndView("responseIPDKitIssue", "map", map);
	}

	public ModelAndView submitPatientKitIssue(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		Users users = (Users)session.getAttribute("users");
		box.put("userId", users.getId());
		int deptId = (Integer) session.getAttribute("deptId");

		datamap = ipdHandlerService.submitPatientKitIssue(box);
		boolean flag = false;
		if(datamap.get("flag")!=null) {
			flag = (Boolean)datamap.get("flag");
		}

		/*map = ipdHandlerService.getPatientList(deptId,hospitalId);*/
		map = ipdHandlerService.getPatientListAndNotification(deptId,hospitalId, users.getEmployee().getId());
		List set = (List) map.get("inpatientSet");
		map.put("inPatientSet", set);
		jsp = "messageForWard.jsp";
		String backUrl = "/hms/hms/ipd?method=showPatientListJsp";
		if (flag) {
			map.put("printUrl", "/hms/hms/ipd?method=printIssuedKitListReport&adNo="+box.getString("adNo")+"&hinNo="+box.getString("hinNo")+"&serviceNo="+box.getString("serviceNo")+"&hospitalId="+hospitalId+"&hinId="+box.getInt(HIN_ID));	
			message = "Linen Issue Details submitted successfully !!";
		} else {
			message = " Error Ocurred Please Try Again !!";
		}
		map.put("backUrl", backUrl);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showCaseSheetJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box =HMSUtil.getBox(request);
		if(session.getAttribute("deptId")!=null)
		box.put("deptId", (Integer)session.getAttribute("deptId"));
		if(session.getAttribute("hospitalId")!=null)
			box.put("hospitalId", (Integer)session.getAttribute("hospitalId"));
		if(session.getAttribute("empId")!=null)
			box.put("empId", (Integer)session.getAttribute("empId"));
//		map = ipdHandlerService.showCaseSheetJsp(box);
		map = ipdHandlerService.showNewCaseSheetJsp(box);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		/*detailsMap = ipdHandlerService.getPatientLatestDiagnosisAndDisability(box.getInt("parent"));*/
		System.out.println(box.getInt("parent"));
		if(detailsMap.get("diagnosisList")!=null){
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		if(detailsMap.get("disabilityList")!=null){
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}
//		String jsp = "ipdCaseSheet.jsp";
		String jsp = "ipdCaseSheetNew.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getLastOpdDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> orderDetailMap = new HashMap<String, Object>();
		Box box =HMSUtil.getBox(request);
		map = ipdHandlerService.getPreviousCaseSheetDetails(box);
		List<PatientInvestigationDetails> opdInvestigationList = new ArrayList<PatientInvestigationDetails>();
		if(map.get("opdInvestigationList") != null){
			opdInvestigationList=(List<PatientInvestigationDetails>)map.get("opdInvestigationList");
		}
		int dgOrderHdId = 0;
		Set<DgOrderhd> orderSet = new HashSet<DgOrderhd>();
		if(opdInvestigationList.size() > 0){
			for(PatientInvestigationDetails investigationDetails : opdInvestigationList){
				if(investigationDetails.getInvestigationHeader().getDgOrderhds()!=null){
					orderSet = investigationDetails.getInvestigationHeader().getDgOrderhds();
					for(DgOrderhd orderhd :orderSet){
						dgOrderHdId = orderhd.getId();
						break;
					}
				}
				break;
			}
		}
		mapForDs.put("dgOrderHdId", dgOrderHdId);
		mapForDs.put("hinId", box.getInt("hinId"));
		mapForDs.put("inPatientId", box.getInt(INPATIENT_ID));

		orderDetailMap = labHandlerService.getOrderDtMap(mapForDs);
		map.put("orderDetailMap", orderDetailMap);
		return new ModelAndView("responseForOpdDetailsForIP", "map", map);
	}
	
	

	public ModelAndView submitIpdCaseSheetDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		Box box =HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		box.put("deptId", (Integer) session.getAttribute("deptId"));
		Users users = (Users)session.getAttribute("users");
		box.put("userId", users.getId());
		box.put("userName", users.getUserName());
		box.put("empId", users.getEmployee().getId());
		int deptId = (Integer) session.getAttribute("deptId");
		
		//Treatment
		List<String> pvmsNoList = new ArrayList<String>();
		List<Integer> frequencyList = new ArrayList<Integer>();
		List<String> dosageList = new ArrayList<String>();
		List<String> remarksList = new ArrayList<String>();
		List<String> typeLeftRightList = new ArrayList<String>();
		List<String> instructionList = new ArrayList<String>();
		List<Integer> totalList = new ArrayList<Integer>();
		List<Integer> noOfDaysList = new ArrayList<Integer>();
		List<String> routeList = new ArrayList<String>();
		List<Integer> itemConversionList = new ArrayList<Integer>();
		List<Integer> itemClassList = new ArrayList<Integer>();
		List<String> itemDispensaryList = new ArrayList<String>();

		String[] diagnosisIdAray = null;

		if (request.getParameterValues(DIAGNOSIS_ID) != null) {
			diagnosisIdAray = (String[]) request
					.getParameterValues(DIAGNOSIS_ID);
		}
		System.out.println("dsfaf"+diagnosisIdAray);
		// System.out.println("this is array size"+diagnosisIdAray.length);
		// --------------commented by anamika------------------//
		/*
		 * String referredDept = ""; String[] referredToDeptArray = null; if
		 * (request.getParameterValues("referredDepartmentId") != null) {
		 * referredToDeptArray = (String[]) request
		 * .getParameterValues("referredDepartmentId"); for (int i = 0; i <
		 * referredToDeptArray.length; i++) { if (i == 0) referredDept =
		 * referredToDeptArray[i]; else referredDept = referredDept + "," +
		 * referredToDeptArray[i]; } }
		 */
		// System.out.println("referredDept-----" + referredDept);
		int nomenclaturehdb = 1;
		if (Integer.parseInt(request.getParameter("nomenclaturehdb")) != 1) {
			nomenclaturehdb = Integer.parseInt(request.getParameter("nomenclaturehdb"));
		}
		String[] pvmsArr = new String[nomenclaturehdb];
		Integer[] itemIdArr = new Integer[nomenclaturehdb];
		String otherMedicine = "";
		List<String> otherMedicineList = new ArrayList<String>();
		List<String> ctList = new ArrayList<String>();
		List<Integer> itemIdList = new ArrayList<Integer>();
		List<Integer> classificationList = new ArrayList<Integer>();
		List<BigDecimal> uomQtyList = new ArrayList<BigDecimal>();
		
		int j = 1;
		for (int i = 0; i < nomenclaturehdb; i++) {
			String pvmsNo = "";
			int itemId = 0;

			if (request.getParameter("itemId" + j) != null
					&& !request.getParameter("nomenclature" + j).equals("")) {
				itemId = Integer.parseInt(request.getParameter("itemId" + j));
				if (itemId != 0) {
					itemIdList.add(itemId);
				}

				if (request.getParameter("itemIdClassificationId" + j) != null
						&& !request.getParameter("itemIdClassificationId" + j)
								.equals("")) {
					classificationList.add(Integer.parseInt(request
							.getParameter("itemIdClassificationId" + j)));
				} else
					classificationList.add(0);
				/*otherMedicineList.add(otherMedicine);*/
			} else {
				if (request.getParameter("otherMedicine" + j) != null
						&& !request.getParameter("otherMedicine" + j)
								.equals("")) {
					otherMedicine = request.getParameter("otherMedicine" + j);
					otherMedicineList.add(otherMedicine);

				}

			}
			
			if((request.getParameter("itemId" + j) != null && !request.getParameter("nomenclature" + j).equals("")) || (request.getParameter("otherMedicine" + j) != null && !request.getParameter("otherMedicine" + j).equals("")) )
			{
			int itemConversionId = 0;
			if (request.getParameter("itemConversionId" + j) != null
					&& !request.getParameter("itemConversionId" + j).equals("")) {
				itemConversionId = Integer.parseInt(request
						.getParameter("itemConversionId" + j));
				itemConversionList.add(itemConversionId);
			}
			else
				itemConversionList.add(0);
			if (request.getParameter("itemClass" + j) != null
					&& !request.getParameter("itemClass" + j).equals("")) {
				itemClassList.add(Integer.parseInt(request
						.getParameter("itemClass" + j)));
			}
			else
				itemClassList.add(0);

			if (request.getParameter("dispensingUnit" + j) != null) {
				itemDispensaryList.add(request.getParameter("dispensingUnit"
						+ j));
			}
			else
				itemDispensaryList.add("");
			
			if (request.getParameter("uomQty" + j) != null) {
				uomQtyList.add(new BigDecimal(request.getParameter("uomQty"+ j)));
			}
			else
				uomQtyList.add(new BigDecimal(0));
			
			int frequencyId = 0;
			if (request.getParameter("frequency" + j) != null
					&& !request.getParameter("frequency" + j).equals("")) {
				frequencyId = Integer.parseInt(request.getParameter("frequency"
						+ j));
				frequencyList.add(frequencyId);
			} else {
				frequencyList.add(0);
			}
			if (request.getParameter("ct" + j) != null) {
				ctList.add("y");
			} else {
				ctList.add("n");
			}

			String route = "";
			if (request.getParameter("route" + j) != null
					&& !request.getParameter("route" + j).equals("")) {
				route = request.getParameter("route" + j);
				routeList.add(route);
			} else {
				routeList.add("");
			}

			BigDecimal frequenceValue = new BigDecimal("0");
			if (request.getParameter("frequencyValue" + j) != null
					&& !request.getParameter("frequencyValue" + j).equals("")) {
				frequenceValue = new BigDecimal(
						request.getParameter("frequencyValue" + j));
			}

			String dosage = "";
			if (request.getParameter("dosage" + j) != null
					&& !request.getParameter("dosage" + j).equals("")) {
				dosage = request.getParameter("dosage" + j);
				dosageList.add(dosage);
			} else {
				dosageList.add("");
			}
			if (request.getParameter("noOfDays" + j) != null
					&& !request.getParameter("noOfDays" + j).equals("")) {
				int noOfDays = Integer.parseInt(request.getParameter("noOfDays"
						+ j));
				noOfDaysList.add(noOfDays);
			} else {
				noOfDaysList.add(0);
			}
			if (request.getParameter("total" + j) != null
					&& !request.getParameter("total" + j).equals("")) {
				int total = Math.round(Float.parseFloat(request
						.getParameter("total" + j)));
				totalList.add(total);
			} else {
				totalList.add(0);
			}

			String remarks = "";
			if (request.getParameter("remarks" + j) != null
					&& !request.getParameter("remarks" + j).equals("")) {
				remarks = request.getParameter("remarks" + j);
				remarksList.add(remarks);
			} else {
				remarksList.add("");
			}
		}
			j++;
		}
		
		//capture NIP
					j =500;
					int n=itemIdList.size();
							int hdb = 1;
		if (Integer.parseInt(request.getParameter("hdb")) != 1) {
			hdb = Integer.parseInt(request.getParameter("hdb"));
		}
		
		for ( j = 500; j <=hdb; j++) {
			String pvmsNo = "";
			int itemId = 0;

			if (request.getParameter("itemId" + j) != null
					&& !request.getParameter("nomenclature" + j).equals("")) {
				itemId = Integer.parseInt(request.getParameter("itemId" + j));
				if (itemId != 0) {
					itemIdList.add(itemId);
				}

				if (request.getParameter("itemIdClassificationId" + j) != null
						&& !request.getParameter("itemIdClassificationId" + j)
								.equals("")) {
					classificationList.add(Integer.parseInt(request
							.getParameter("itemIdClassificationId" + j)));
				} else
					classificationList.add(0);
				/*otherMedicineList.add(otherMedicine);*/
			} else {
				if (request.getParameter("otherMedicine" + j) != null
						&& !request.getParameter("otherMedicine" + j)
								.equals("")) {
					otherMedicine = request.getParameter("otherMedicine" + j);
					otherMedicineList.add(otherMedicine);
					/*otherMedicineList.add(n,otherMedicine);*/

				}

			}
			
			if((request.getParameter("itemId" + j) != null && !request.getParameter("nomenclature" + j).equals("")) || (request.getParameter("otherMedicine" + j) != null && !request.getParameter("otherMedicine" + j).equals("")) )
			{
			int itemConversionId = 0;
			if (request.getParameter("itemConversionId" + j) != null
					&& !request.getParameter("itemConversionId" + j).equals("")) {
				itemConversionId = Integer.parseInt(request
						.getParameter("itemConversionId" + j));
				itemConversionList.add(itemConversionId);
			}
			else
				itemConversionList.add(0);
			if (request.getParameter("itemClass" + j) != null
					&& !request.getParameter("itemClass" + j).equals("")) {
				itemClassList.add(Integer.parseInt(request
						.getParameter("itemClass" + j)));
			}
			else
				itemClassList.add(0);
			if (request.getParameter("dispensingUnit" + j) != null) {
				itemDispensaryList.add(request.getParameter("dispensingUnit"
						+ j));
			}
			else
				itemDispensaryList.add("");
			
			if (request.getParameter("uomQty" + j) != null) {
				uomQtyList.add(new BigDecimal(request.getParameter("uomQty"+ j)));
			}
			else
				uomQtyList.add(new BigDecimal(0));
			
			int frequencyId = 0;
			if (request.getParameter("frequency" + j) != null
					&& !request.getParameter("frequency" + j).equals("")) {
				frequencyId = Integer.parseInt(request.getParameter("frequency"
						+ j));
				frequencyList.add(frequencyId);
			} else {
				frequencyList.add(0);
			}
			if (request.getParameter("ct" + j) != null) {
				ctList.add("y");
			} else {
				ctList.add("n");
			}

			String route = "";
			if (request.getParameter("route" + j) != null
					&& !request.getParameter("route" + j).equals("")) {
				route = request.getParameter("route" + j);
				routeList.add(route);
			} else {
				routeList.add("");
			}

			BigDecimal frequenceValue = new BigDecimal("0");
			if (request.getParameter("frequencyValue" + j) != null
					&& !request.getParameter("frequencyValue" + j).equals("")) {
				frequenceValue = new BigDecimal(
						request.getParameter("frequencyValue" + j));
			}

			String dosage = "";
			if (request.getParameter("dosage" + j) != null
					&& !request.getParameter("dosage" + j).equals("")) {
				dosage = request.getParameter("dosage" + j);
				dosageList.add(dosage);
			} else {
				dosageList.add("");
			}
			if (request.getParameter("noOfDays" + j) != null
					&& !request.getParameter("noOfDays" + j).equals("")) {
				int noOfDays = Integer.parseInt(request.getParameter("noOfDays"
						+ j));
				noOfDaysList.add(noOfDays);
			} else {
				noOfDaysList.add(0);
			}
			if (request.getParameter("total" + j) != null
					&& !request.getParameter("total" + j).equals("")) {
				int total = Math.round(Float.parseFloat(request
						.getParameter("total" + j)));
				totalList.add(total);
			} else {
				totalList.add(0);
			}

			String remarks = "";
			if (request.getParameter("remarks" + j) != null
					&& !request.getParameter("remarks" + j).equals("")) {
				remarks = request.getParameter("remarks" + j);
				remarksList.add(remarks);
			} else {
				remarksList.add("");
			}
		}
		}
		
		datamap.put("routeList", routeList);
		datamap.put("frequencyList", frequencyList);
		datamap.put("ctList", ctList);
		datamap.put("dosageList", dosageList);
		datamap.put("itemIdList", itemIdList);
		datamap.put("classificationList", classificationList);
		datamap.put("totalList", totalList);
		datamap.put("noOfDaysList", noOfDaysList);
		datamap.put("remarksList", remarksList);
		datamap.put("otherMedicineList", otherMedicineList);
		datamap.put("itemConversionList", itemConversionList);
		datamap.put("itemClassList", itemClassList);
		datamap.put("itemDispensaryList", itemDispensaryList);
		datamap.put("uomQtyList", uomQtyList);
		
		//end treatment
		
		//investigation 
		List<String> chargeCodeIdList = new ArrayList<String>();
		List<String> investigationDate = new ArrayList<String>();
		
		String clinicalNotes1 = "";
		if (request.getParameter("clinicalNotes1") != null
				&& !(request.getParameter("clinicalNotes1").equals(""))) {
			clinicalNotes1 = request.getParameter("clinicalNotes1");
		}
		int hiddenValue = 1;
		if (Integer.parseInt(request.getParameter("hiddenValue")) != 1) {
			hiddenValue = Integer.parseInt(request.getParameter("hiddenValue"));
		}
		int temp = 1;
		String[] chargeCodeIdArr = new String[hiddenValue];
		for (int i = 0; i < hiddenValue; i++) {
			if (request.getParameter("chargeCodeName" + temp) != null
					&& !request.getParameter("chargeCodeName" + temp)
							.equals("")) {

				String chargeCodeNameWithId = request
						.getParameter("chargeCodeName" + temp);
				int index1 = chargeCodeNameWithId.lastIndexOf("[");
				int index2 = chargeCodeNameWithId.lastIndexOf("]");
				index1++;
				String chargeCodeId = chargeCodeNameWithId.substring(index1,
						index2);
				if (!chargeCodeId.equals("")) {
					chargeCodeIdArr[i] = chargeCodeId;
					int qty = 1;
					// int
					// qty=Integer.parseInt(request.getParameter("qty"+temp));
					// String clinicalNotes =
					// request.getParameter("clinicalNotes" + temp);
				
					chargeCodeIdList.add(chargeCodeIdArr[i]);
					investigationDate.add(request.getParameter("investigationDate"+temp));
					// quantityList.add(qty);
					// clinicalList.add(clinicalNotes);

				}
			}
			temp++;
		}
		datamap.put("chargeCodeIdList", chargeCodeIdList);
		datamap.put("investigationDate", investigationDate);

		//end of investigation
		
		
		datamap.put("box", box);
		datamap = ipdHandlerService.submitIpdCaseSheetDetails(datamap);
		boolean flag = false;
		if(datamap.get("flag")!=null) {
			flag = (Boolean)datamap.get("flag");
		}

		List set = (List) map.get("inpatientSet");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		if (flag) {
			message = "Case Sheet Details submitted successfully. Do you want to print Case Sheet?";
			map.put("printUrl", "/hms/hms/discharge?method=showDischargeSummaryReport&flag=c&adNo="+box.getString("adNo")+"&hinNo="+box.getString("hinNo")+"&serviceNo="+box.getString("serviceNo")+"&fromDate="+currentDate);
			map.put("backUrl", "/hms/hms/ipd?method=showPatientListJsp");
		} else {
			message = " Error Ocurred Please Try Again !!";
		}
		
		 // Ranjesh Prasad: Pacs Integration Start
      /*  if (true) {
            PacsHL7Service pacsHL7Service = new PacsHL7Service();
            String query = "";
            // String query="and dt.amount='0.00' and dg.visit_id="+visitId;
            try {
                pacsHL7Service.sendService(query);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        
		jsp = "messageForWard.jsp";
		map.put("messageTOBeVisibleToTheUser", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView showHandTakeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		int deptId = 0;
		int inaptientId=0;
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		String deptName = "";
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		int userId = 0;
		if (session.getAttribute("userId") != null) {
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		}
		map.put("userId", userId);
		if (session.getAttribute("deptName") != null) {
			deptName = request.getParameter("deptName");
		}
		if(request.getParameter("parent")!=null && !request.getParameter("parent").equals(""))
		{
			inaptientId=Integer.parseInt(request.getParameter("parent"));
		}
		
		
		map.put("deptId", deptId);
		map.put(HOSPITAL_ID, hospitalId);
		map.put(INPATIENT_ID, inaptientId);
		
		map = ipdHandlerService.showHandTakeJsp(map);
		String entrySeqNo = request.getParameter("entrySeqNo");
		entrySeqNo = ipdHandlerService.getEntrySeqForDisplay("HEN");
		if (entrySeqNo != null) {
			map.put("entrySeqNo", entrySeqNo);
		}
		
		jsp = "handTakeOver.jsp";
		title = "Hand Take Over";
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public IPDHandlerService getIpdHandlerService() {
		return ipdHandlerService;
	}

	public void setIpdHandlerService(IPDHandlerService ipdHandlerService) {
		this.ipdHandlerService = ipdHandlerService;
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView submitHandTakeOver(HttpServletRequest request,
			HttpServletResponse response) {
		/*Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		
		
		IpdHandTakeOver ipdHandTakeOver = new IpdHandTakeOver();*/
		Box box=HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId=0;
		int departmentId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		 userId=(Integer)session.getAttribute(USER_ID);
		 departmentId=(Integer)session.getAttribute(DEPT_ID);
		 //int empId=(Integer)
		 box.put(HOSPITAL_ID, hospitalId);
		 box.put(USER_ID, userId);
		 box.put(DEPT_ID, departmentId);
		
		/*String entrySeqNo = "";
		String shiftStartFrom = "";
		String remarksPendingwork = "";
		int handOverId = 0;
		int takeOverId = 0;
		int hospitalId = 0;
		String date = "";
		date = (String) utilMap.get("currentDate");
		Date currentDate = new Date();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (hospitalId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			ipdHandTakeOver.setHospital(masHospital);
		}
		
		Inpatient inpatient=new Inpatient();
		inpatient.setIcdId(box.getInt(INPATIENT_ID));
		ipdHandTakeOver.setInpatient(inpatient);
		
		Patient patient=new Patient();
		patient.setId(box.getInt(HIN_ID));
		ipdHandTakeOver.setHin(patient);
		
		ipdHandTakeOver.setWardBedTransferRequired("n");
		
		
		ipdHandTakeOver.setEntryDate(HMSUtil.dateFormatterDDMMYYYY(request.getParameter(TRANSFER_DATE)));
		ipdHandTakeOver.setEntryTime(request.getParameter(TRANSFER_TIME));
		int fromDepartmentId=Integer.parseInt(request.getParameter(FROM_WARD));
		MasDepartment fromDepartment = new MasDepartment();
		fromDepartment.setId(fromDepartmentId);
		ipdHandTakeOver.setFromDepartment(fromDepartment);
		
		int handById= Integer.parseInt(request.getParameter("fromDoctor"));
		System.out.println("taken by id == "+handById);
		MasEmployee handBy=new MasEmployee();
		handBy.setId(handById);
		ipdHandTakeOver.setHandBy(handBy);
		
		int toDepartmentId=Integer.parseInt(request.getParameter(TO_WARD));
		MasDepartment toDepartment = new MasDepartment();
		fromDepartment.setId(toDepartmentId);
		ipdHandTakeOver.setDepartment(toDepartment);
		
		int takeById= Integer.parseInt(request.getParameter("doctorId"));
		System.out.println("taken by id == "+takeById);
		MasEmployee takeBy=new MasEmployee();
		handBy.setId(takeById);
		ipdHandTakeOver.setTakeBy(takeBy);
		
		
		int departmentId = (Integer) session.getAttribute("deptId");
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		ipdHandTakeOver.setDepartment(masDepartment);
		
		
		int authorisedById= Integer.parseInt(request.getParameter(AUTHORIZER_ID));
		System.out.println("taken by id == "+takeById);
		MasEmployee authorisedBy=new MasEmployee();
		authorisedBy.setId(authorisedById);
		ipdHandTakeOver.setAuthorisedBy(authorisedBy);

//		if (request.getParameter(ENTRY_NO) != null) {
//			entrySeqNo = request.getParameter(ENTRY_NO);
//		}
		 entrySeqNo = ipdHandlerService.generateEntryNumber();
		ipdHandTakeOver.setEntryNo(entrySeqNo);
		
		ipdHandTakeOver.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		ipdHandTakeOver.setLastChgTime((String)utilMap.get("currentTime"));
		Users users=new Users();
		users.setId((Integer)session.getAttribute(USER_ID));
		ipdHandTakeOver.setLastChgBy(users);*/

		/*if (request.getParameter(FROM_HAND_OVER) != null
				&& !request.getParameter(FROM_HAND_OVER).equals("0")) {
			handOverId = Integer.parseInt(request.getParameter(FROM_HAND_OVER));
		}
		MasEmployee fromHand = new MasEmployee();
		fromHand.setId(handOverId);
		ipdHandTakeOver.setHandBy(fromHand);

		if (request.getParameter(TO_HAND_OVER) != null
				&& !request.getParameter(TO_HAND_OVER).equals("0")) {
			takeOverId = Integer.parseInt(request.getParameter(TO_HAND_OVER));
		}
		MasEmployee takeHand = new MasEmployee();
		takeHand.setId(takeOverId);
		ipdHandTakeOver.setTakeBy(takeHand);

		if (request.getParameter(SHIFT_START_FROM) != null
				&& !request.getParameter(TO_HAND_OVER).equals("")) {
			shiftStartFrom = request.getParameter(SHIFT_START_FROM);
		}
		if (request.getParameter("ampm") != null
				&& !request.getParameter("ampm").equals("")) {
			shiftStartFrom = shiftStartFrom + " "
					+ request.getParameter("ampm");
		}
		ipdHandTakeOver.setShiftTime(shiftStartFrom);
		if (request.getParameter(REMARKS_PENDING_WORK) != null
				&& !request.getParameter(REMARKS_PENDING_WORK).equals("")) {
			remarksPendingwork = request.getParameter(REMARKS_PENDING_WORK);
		}
		ipdHandTakeOver.setRemarksPendingWork(remarksPendingwork);

		ipdHandTakeOver.setEntryDate(HMSUtil
				.convertStringTypeDateToDateType(date));*/
		boolean saved = false;
		String message = "";
		saved = ipdHandlerService.submitHandTakeOver(box);
		if (saved) {
			/*map = ipdHandlerService.getPatientList(departmentId, hospitalId,userId);*/
			map = ipdHandlerService.getPatientList(departmentId, hospitalId);
			List set = (List) map.get("inpatientSet");
			map.put("inPatientSet", set);

			jsp = "showPatientListNurse.jsp";
			message = "Patient Transferred Successfully !!";
		} else {
			/*map = ipdHandlerService.getPatientList(departmentId, hospitalId,userId);*/
			map = ipdHandlerService.getPatientList(departmentId, hospitalId);
			List set = (List) map.get("inpatientSet");
			map.put("inPatientSet", set);
			jsp = "showPatientListNurse.jsp";
			message = " Error Ocurred Please Try Again !!";
		}
		map.put("message", message);

		String jsp = PATIENT_LIST_JSP + ".jsp";
		map.put("contentJsp", jsp);
		//map.put("entrySeqNo", entrySeqNo);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitCareTransferAccepJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		Box box=HMSUtil.getBox(request);
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		int userId=(Integer)session.getAttribute(USER_ID);
		int empId=(Integer)session.getAttribute("empId");
		box.put(HOSPITAL_ID, hospitalId);
		box.put(DEPT_ID, deptId);
		box.put(USER_ID, userId);
		box.put("empId", empId);
		
		map=ipdHandlerService.submitcareTransferAcceeptance(box);
		
		map.putAll(ipdHandlerService.getCareTransferAccepJsp(box));
		jsp = "caretransferaccept";
		jsp += ".jsp";
		title = "Pending Acknowledge List";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	//---------By Kiran
	
	public ModelAndView showCareTransferAccepJsp(HttpServletRequest request,
			HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		Box box=HMSUtil.getBox(request);
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		int userId=(Integer)session.getAttribute(USER_ID);
		int empId=(Integer)session.getAttribute("empId");
		box.put(HOSPITAL_ID, hospitalId);
		box.put(DEPT_ID, deptId);
		box.put(USER_ID, userId);
		box.put("empId", empId);
		map=ipdHandlerService.getCareTransferAccepJsp(box);
		
//		map.putAll(ipdHandlerService.getDetailsForBedTransferAcceptance(box));
		
		
		jsp = "caretransferaccept";
		jsp += ".jsp";
		title = "Pending Acknowledge List";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showDietSetupJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box =HMSUtil.getBox(request);
		HttpSession session= request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			box.put("deptId", deptId);
		}
		box.put("hospitalId", Integer.parseInt("" + session.getAttribute("hospitalId")));
		map = ipdHandlerService.showDietSetupJsp(box);
		String jsp = "ipdDietSetup.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	//---------End By Kiran

	/********************* Method for Case Sheet Report By Tirath	***********************************/

	public ModelAndView showCaseSheetReport(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		jsp = "caseSheetJsp";
		jsp += ".jsp";
		
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPatientName(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		String paramName = "";
		String flag="";
		String flag1="";
		if (request.getParameter("paramName") != null) {
			paramName = request.getParameter("paramName");
		}

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}

		if (request.getParameter("flag1") != null) {
			flag1 = request.getParameter("flag1");
		}

		dataMap.put("hospitalId", hospitalId);
		dataMap.put("paramName", paramName);
		dataMap.put("flag", flag);
		dataMap.put("flag1", flag1);
		if(request.getParameter("discharge")!=null){
			dataMap.put("discharge", request.getParameter("discharge"));

		}
		map = ipdHandlerService.showPatientName(dataMap);
		if(flag.equalsIgnoreCase("s"))
		{
			jsp = "responseForPatientNameAndAdNo";
		}

		if(flag.equalsIgnoreCase("p"))
		{
			jsp = "responseForPatientNameAndAdNo1";
		}
		if(flag.equalsIgnoreCase("w"))
		{
			jsp = "responseForAdNo";
		}
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public ModelAndView showPatientMedicalCaseSheetReportForWard(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		int visiNo = 0;
		String serviceNo = "";
		String hinNo = "";
		String adNo="";
		int hinId=0;
		Date caseSheetDate=null;
		String flag1="";
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		System.out.println("hospitalId="+hospitalId);
		if (request.getParameter("adNo") != null) {
			adNo = request.getParameter("adNo");
		}
		if (request.getParameter(ADMISSION_NUMBER) != null) {
			adNo = request.getParameter("ADMISSION_NUMBER");
		}
		if (request.getParameter("serviceNo") != null) {
			serviceNo = request.getParameter("serviceNo");
		}
		if (request.getParameter("hinNo") != null) {
			hinNo = request.getParameter("hinNo");
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}
		if(request.getParameter("flag1")!=null && request.getParameter("flag1")!=""){
			flag1=request.getParameter("flag1");
			hinId=Integer.parseInt(request.getParameter("hinId"));
			hinNo=ipdHandlerService.getHinNoForCaseSheet(hinId,hospitalId);
		}
					
		if (request.getParameter(FROM_DATE) != null && request.getParameter(FROM_DATE) !="") {
			caseSheetDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap=ipdHandlerService.showPatientMedicalCaseSheetReportForWard(hinNo,hospitalId,adNo);
		            ipdHandlerService.runIntakeOutputProc(hinNo,serviceNo,hospitalId,adNo);
		if(!flag1.equals("") && request.getParameter(FROM_DATE) != null && request.getParameter(FROM_DATE) !=""){
			String dateDel=request.getParameter(FROM_DATE);
			map1=ipdHandlerService.deleteDateFromTable(dateDel,hinId);
		}
		detailsMap = ipdHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		String clinicalChart = "";
		String ioChart = "";
		if(request.getParameter("clinicalChart")!=null){
			clinicalChart=request.getParameter("clinicalChart");
		}
		if(request.getParameter("ioChart")!=null){
			ioChart=request.getParameter("ioChart");
		}
		/**
		 * for clinicalchart
		 */
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		requestParameters.put(ADMISSION_NUMBER, adNo);
		requestParameters.put("serviceNo", serviceNo);
		parameters = dischargeHandlerService.getClinicalSheetReportDetails(requestParameters);
		/**
		 * end
		 */
		parameters.put("hospitalId", hospitalId);
		parameters.put("adNo", adNo);
		parameters.put("caseSheetDate", caseSheetDate);
		parameters.put("serviceNo", serviceNo);
		parameters.put("hinNo", hinNo);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		parameters.put("clinicalChart", clinicalChart);
		parameters.put("ioChart", ioChart);
		parameters.put("PATH_TO_SUBREPORTS", getServletContext().getRealPath("/reports/"));
		HMSUtil.generateReport("case_sheet_ward_both", parameters,
				(Connection) detailsMap.get("conn"), response, getServletContext());
		
		return null;

	}
	
	

	public ModelAndView submitSurgeryRequisitionDetailsForInpatient(
			HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		boolean bool =false;
//		Map<String, Object> datamap = new HashMap<String, Object>();
		Box box =HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		box.put("deptId", (Integer) session.getAttribute("deptId"));
		Users users = (Users)session.getAttribute("users");
		box.put("userId", users.getId());
		box.put("userName", users.getUserName());
		box.put("empId", users.getEmployee().getId());
		int deptId = (Integer) session.getAttribute("deptId");
		
		try {
			map = ipdHandlerService.submitSurgeryRequisitionDetailsForInpatient(box);
			map.putAll(ipdHandlerService.showSurgeryRequisitionJspForHin(box));
			if(map.get("bool")!=null){
				bool=(Boolean)map.get("bool");
			}
			if (bool) {
				message = "Surgery Requisition Completed!";
				jsp = "opd_surgeryRequisitionForInpatient";
			} else {
				message = "Error Occured !! Try Again !!";
				jsp = "opd_surgeryRequisitionForInpatient";
			}
			jsp += ".jsp";
//			map.put("orderNo", orderNo);
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (RuntimeException e) {

			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}
	
	
	@SuppressWarnings("unused")
	public ModelAndView showSurgeryRequisitionJspFromPatientList(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId=0;
		if(session.getAttribute(DEPT_ID)!=null){
			deptId = (Integer) session.getAttribute(DEPT_ID);
		}
		int hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
		Box box=HMSUtil.getBox(request);
		box.put(DEPT_ID, deptId);
		box.put(HOSPITAL_ID, hospitalId);
//		
//		Map<String, Object> mapForDS = new HashMap<String, Object>();
		List<Patient> patientDetailList = new ArrayList<Patient>();
		 Map<String, Object> map = new HashMap<String, Object>();
//		String hinNo = request.getParameter("hinNo1");
//		int empId = (Integer) session.getAttribute("userId");
//		int orderNo = 0;
//		mapForDS.put("empId", empId);
//		mapForDS.put("hinNo", hinNo);
//		mapForDS.put(HOSPITAL_ID, hospitalId);
//		mapForDS.put("deptId", deptId);
//
//		try {
			map = ipdHandlerService.showSurgeryRequisitionJspForHin(box);
//			orderNo = (Integer) map.get("orderNo");
//
//			patientDetailList=(List<Patient>)map.get("patientDetailList");
//			if(patientDetailList.size()>0)
//			{
			jsp = OPD_SURGERY_REQUISITION_FOR_INPATIENT_JSP;
//			}
//			else
//			{
//				jsp="messageJspForOTReq";
//			}
			jsp += ".jsp";
//			map.put("deptId", deptId);
			map.put("contentJsp", jsp);
			map.put("title", title);
//			map.put("orderNo", orderNo);
//		} catch (RuntimeException e) {
//			e.printStackTrace();
//		}

		return new ModelAndView("index", "map", map);
		// return null;

	}

	public ModelAndView showPatientPrescriptionReportJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		jsp = "ipPrescriptionReport";
		jsp += ".jsp";
		title = "title";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPatientInvestigationReportJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		jsp = "ipInvestigationReport";
		jsp += ".jsp";
		title = "title";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printIPPrescriptionInvestReport(HttpServletRequest request, HttpServletResponse response) {
		String adNo="";

		if (request.getParameter("adNo") != null) {
			adNo = request.getParameter("adNo");
		}

		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = ipdHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("hospitalId", hospitalId);
		parameters.put("adNo", adNo);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		if(request.getParameter("flag")!=null && (request.getParameter("flag").equals("prescription"))){
		HMSUtil.generateReport("InpatientPrescriptionFormat", parameters,
				(Connection) detailsMap.get("conn"), response, getServletContext());
		}else if(request.getParameter("flag")!=null && (request.getParameter("flag").equals("investigation"))){
			HMSUtil.generateReport("InpatientInvestigationFormat", parameters,
					(Connection) detailsMap.get("conn"), response, getServletContext());
		}
		return null;
	}
	public ModelAndView printDietSetup(HttpServletRequest request,HttpServletResponse response)
	 {
		Map<String,Object> map = new HashMap<String,Object>();

		   int hinId=Integer.parseInt(request.getParameter("hinId"));
		   int bedId= Integer.parseInt(request.getParameter("bedId"));
		   int inpatientId= Integer.parseInt(request.getParameter("inpatientId"));
		   int dietId= Integer.parseInt(request.getParameter("dietId"));
		 String jsp = "printDietSetup";
		//jsp += ".jsp";
		// title = "tital";
		//map.put("contentJsp", jsp);
		return new ModelAndView("jsp","map",map);
	 }


	public ModelAndView showIPProcedureListJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int inpatientId = 0;
		if(request.getParameter("inpatientId")!=null){
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
			map.put("inpatientId", inpatientId);
		}
		int hinId=0;
		hinId = Integer.parseInt(request.getParameter("hinId"));
		int doctorId=0;
		doctorId = Integer.parseInt(request.getParameter("doctorId"));
		map.put("hospitalId", hospitalId);
		map.put("hinId", hinId);
		map.put("doctorId", doctorId);
		
		String jsp = "ipdProcedureAdvice";
		return new ModelAndView(jsp,"map",map);
	}

	public ModelAndView printDietReport(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId=0;
		int dietFor=0;
		String dateFor="";
		String timeFor="";
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (request.getParameter("deptId") != null) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
		}
		if (request.getParameter("dietFor") != null) {
			dietFor = Integer.parseInt(request.getParameter("dietFor"));
		}
		if (request.getParameter("dateFor") != null) {
			dateFor = request.getParameter("dateFor");
		}
		if (request.getParameter("timeFor") != null) {
			timeFor = request.getParameter("timeFor");
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = ipdHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("hospitalId", hospitalId);
		parameters.put("deptId", deptId);
		parameters.put("dietFor", dietFor);
		parameters.put("dateFor", dateFor);
		parameters.put("timeFor", timeFor);
		/*parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		if(request.getParameter("flag")!=null && (request.getParameter("flag").equals("prescription"))){
		HMSUtil.generateReport("InpatientPrescriptionFormat", parameters,
				(Connection) detailsMap.get("conn"), response, getServletContext());
		}else if(request.getParameter("flag")!=null && (request.getParameter("flag").equals("investigation"))){*/
			HMSUtil.generateReport("dailyDietSheetReportWard", parameters,
					(Connection) detailsMap.get("conn"), response, getServletContext());
		/*}*/
		return null;
	}
	
	public ModelAndView printIssuedKitListReport(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		//int hospitalId=0;
		String adNo="";
		String serviceNo="";
		String hinNo="";
		int hinId=0;
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (request.getParameter("adNo") != null && request.getParameter("adNo") !="") {
			adNo = request.getParameter("adNo");
		}
		if (request.getParameter("serviceNo") != null && request.getParameter("serviceNo") !="") {
			serviceNo = request.getParameter("serviceNo");
		}
		if (request.getParameter("hinNo") != null && request.getParameter("hinNo") !="") {
			hinNo = request.getParameter("hinNo");
		}

		String userHome = getServletContext().getRealPath("");	         
	    String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
	    
	    int departmentId=0;
		
		/*if (request.getParameter("flag1") != null && request.getParameter("flag1") !="") {
			hinId=Integer.parseInt(request.getParameter("hinId"));
			hinNo=ipdHandlerService.getHinNoForCaseSheet(hinId,hospitalId);
		}*/
		//if (request.getParameter("flag1") != null && request.getParameter("flag1") !="") {
		
		
			hinId=Integer.parseInt(request.getParameter("hinId"));
			hinNo=ipdHandlerService.getHinNoForCaseSheet(hinId,hospitalId);
		//}
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = ipdHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("path", imagePath);
		parameters.put("hospitalId", hospitalId);
		parameters.put("adNo", adNo);
		parameters.put("serviceNo", serviceNo);
		parameters.put("hinNo", hinNo);
		
		
		//parameters.put("timeFor", timeFor);
		/*parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		if(request.getParameter("flag")!=null && (request.getParameter("flag").equals("prescription"))){
		HMSUtil.generateReport("InpatientPrescriptionFormat", parameters,
				(Connection) detailsMap.get("conn"), response, getServletContext());
		}else if(request.getParameter("flag")!=null && (request.getParameter("flag").equals("investigation"))){*/
		
		/*	HMSUtil.generateReport("issuedKitListReport", parameters,
					(Connection) detailsMap.get("conn"), response, getServletContext());*/
		
		HMSUtil.generateReport("linen_form", parameters,
				(Connection) detailsMap.get("conn"), response, getServletContext());
		/*}*/
		return null;
	}
	public ModelAndView showSilDilReport(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		//int hospitalId=0;
		String adNo="";
		String serviceNo="";
		String hinNo="";
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (request.getParameter("adNo") != null && request.getParameter("adNo") !="") {
			adNo = request.getParameter("adNo");
		}
		if (request.getParameter("serviceNo") != null && request.getParameter("serviceNo") !="") {
			serviceNo = request.getParameter("serviceNo");
		}
		if (request.getParameter("hinNo") != null && request.getParameter("hinNo") !="") {
			hinNo = request.getParameter("hinNo");
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = ipdHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("hospitalId", hospitalId);
		parameters.put("adNo", adNo);
		parameters.put("serviceNo", serviceNo);
		parameters.put("hinNo", hinNo);
			HMSUtil.generateReport("patientSilDilReportWard", parameters,
					(Connection) detailsMap.get("conn"), response, getServletContext());
	
		return null;
	}
	public ModelAndView showPatientHinNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		String paramName = "";
		String flag="";
		if (request.getParameter("paramName") != null) {
			paramName = request.getParameter("paramName");
		}
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("paramName", paramName);
		dataMap.put("flag", flag);
		map = ipdHandlerService.showPatientHinNo(dataMap);
			jsp = "responseForHinNoWard";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showDrugConsumptionJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "nonDrugConsumption.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
		
	}
	public ModelAndView getItemBatchNo(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int deptId = 0;
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
		map = ipdHandlerService.getItemBatchNo(box);
		map.put("counter", box.getInt("counter"));
		String jsp ="responseForItemBatchNo";
		return  new ModelAndView(jsp,"map",map);
	}
	public void getBatchExpiryDate(HttpServletRequest request, HttpServletResponse response) {
		List<StoreItemBatchStock> batchList = new ArrayList<StoreItemBatchStock>();
		Box box = HMSUtil.getBox(request);
		int batchId = box.getInt("batchId");
		batchList = ipdHandlerService.getBatchExpiryDate(batchId);
		StringBuffer sb = new StringBuffer();
		try {
			StoreItemBatchStock batchStock = new StoreItemBatchStock();
			
			batchStock = batchList.get(0);
				sb.append("<item>");
				sb.append("<expiryDate>" + (batchStock.getExpiryDate()!=null && !(batchStock.getExpiryDate().equals(""))? HMSUtil.convertDateToStringWithoutTime(batchStock.getExpiryDate()):"") + "</expiryDate>");
				sb.append("<stock>" + (batchStock.getClosingStock()!=null?batchStock.getClosingStock():"") + "</stock>");
				sb.append("</item>");
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
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ModelAndView saveDrugConsumptionDetails(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		Box box =HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		box.put("deptId", (Integer) session.getAttribute("deptId"));
		Users users = (Users)session.getAttribute("users");
		box.put("userId", users.getId());
	
		datamap = ipdHandlerService.saveDrugConsumptionDetails(box);
		boolean flag = false;
		if(datamap.get("flag")!=null) {
			flag = (Boolean)datamap.get("flag");
		}
		String backUrl = "/hms/hms/ipd?method=showPatientListJsp";
		if (flag) {
			message = "Drug Consumption Details submitted successfully.";
			map.put("printUrl", "/hms/hms/ipd?method=printDrugConsuptionReport&consumptionDate="+box.getString("consumptionDate")+"&consumptionTime="+box.getString("consumptionTime")+"&hospitalId="+hospitalId);
		} else {
			message = " Error Ocurred Please Try Again !!";
		}
		jsp = "message.jsp";
		map.put("backUrl",backUrl);
		map.put("messageTOBeVisibleToTheUser", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showDateWiseDrugIssuedReportJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "dateWiseDrugIssueDetailsReport.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
		
	}
	
	public ModelAndView showDateWiseDrugIssuedReport(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String query="";
		String fromDate="";
		String toDate="";
		String nomenclature1="";
		int itemId=0;
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (request.getParameter(FROM_DATE) != null && request.getParameter(FROM_DATE) !="") {
			fromDate = request.getParameter(FROM_DATE);
		}
		if (request.getParameter(TO_DATE) != null && request.getParameter(TO_DATE) !="") {
			toDate = request.getParameter(TO_DATE);
		}
		if (request.getParameter("nomenclature1") != null && !request.getParameter("nomenclature1").equals("")) {
			nomenclature1 = request.getParameter("nomenclature1");
			int index1 = nomenclature1.lastIndexOf("[");
			int index2 = nomenclature1.lastIndexOf("]");
			index1++;
			itemId = Integer.parseInt(nomenclature1.substring(index1, index2));
			query=" and ppd.item_id="+itemId;
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = ipdHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("hospitalId", hospitalId);
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("query", query);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
			HMSUtil.generateReport("dateWiseDrugIssuedDetailsReport", parameters,
					(Connection) detailsMap.get("conn"), response, getServletContext());
	
		return null;
	}
	
	public ModelAndView showDateWisePatientWiseDrugIssuedReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "dateWisePatientWiseDrugIssuedDetails.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
		
	}
	
	public ModelAndView showPayrollDeductionJournal(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box =HMSUtil.getBox(request);
		map = ipdHandlerService.showPayrollDeductionJournal(box);
		String jsp = "showPayrollDeductionJournal.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
		
	}
	
	public ModelAndView printDateWisePatientWiseDrugIssuedReport(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String serviceNo="";
	/*	String fromDate="";
		String toDate="";*/
		Date fromDate = new Date();
		Date toDate = new Date();
		String adNo="";
		String hinNo="";	
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
//		String currentDate = (String) utilMap.get("currentDate");
		Date currentDate = new Date();
		int hinId;
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (request.getParameter(FROM_DATE) != null && request.getParameter(FROM_DATE) !="") {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}else{
			fromDate = currentDate;
		}
		if (request.getParameter(TO_DATE) != null && request.getParameter(TO_DATE) !="") {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}else{
			toDate = currentDate;
		}
		if (request.getParameter("serviceNo") != null && request.getParameter("serviceNo") !="") {
			serviceNo = request.getParameter("serviceNo");
		}
		if (request.getParameter("adNo") != null && request.getParameter("adNo") !="") {
			adNo = request.getParameter("adNo");
		}
		if (request.getParameter("hinId") != null && request.getParameter("hinId") !="") {
			hinId = Integer.parseInt(request.getParameter("hinId"));
			hinNo=ipdHandlerService.getHinNoForCaseSheet(hinId,hospitalId);
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = ipdHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("hospitalId", hospitalId);
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("hinNo", hinNo);
		parameters.put("adNo", adNo);
		parameters.put("serviceNo", serviceNo);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
			HMSUtil.generateReport("dateWisePatientWiseDrugIssuedDetailsReport", parameters,
					(Connection) detailsMap.get("conn"), response, getServletContext());
	
		return null;
	}
	
	public ModelAndView printPayrollDeductionJournalReport(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int divisionId=0;
	
		Date fromDate = new Date();
		Date toDate = new Date();			
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		Date currentDate = new Date();
		int hinId;
		int hospitalId = 0;
		String hospitalName = "";
		Map<String, Object> parameters = new HashMap<String, Object>();
		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				parameters.put("hospitalId", hospitalId);
				hospitalName = ipdHandlerService.getHospitalName(hospitalId);
				parameters.put("hospitalName", hospitalName);
			}	
		if (request.getParameter(FROM_DATE) != null && request.getParameter(FROM_DATE) !="") {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}else{
			fromDate = currentDate;
		}
		if (request.getParameter(TO_DATE) != null && request.getParameter(TO_DATE) !="") {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}else{
			toDate = currentDate;
		}
		if (request.getParameter("divisionId") != null && request.getParameter("divisionId") !="") {
			divisionId = Integer.parseInt(request.getParameter("divisionId"));
		}
	
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = ipdHandlerService.getDBConnection();
		

		parameters.put("hospitalId", hospitalId);
		parameters.put("divisionId", divisionId);
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("perDayAdmissionCost", Double.parseDouble(HMSUtil.getProperties("adt.properties", "perDayAdmissionCost")));
		
		String userHome = getServletContext().getRealPath("");	    
		String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
		parameters.put("path", imagePath);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		HMSUtil.generateReport("payroll_deduction_journal", parameters,
				(Connection) detailsMap.get("conn"), response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

	
	
		return null;
	}
	
	public ModelAndView showPatientDietReportJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "showPatientDietReportJsp.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
		
	}
	
	public ModelAndView printPatientDietReport(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String serviceNo="";
		String adNo="";
		String hinNo="";
		int hinId;
		int deptId= (Integer)(session.getAttribute("deptId"));
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (request.getParameter("serviceNo") != null && request.getParameter("serviceNo") !="") {
			serviceNo = request.getParameter("serviceNo");
		}
		if (request.getParameter("adNo") != null && request.getParameter("adNo") !="") {
			adNo = request.getParameter("adNo");
		}
		if (request.getParameter("hinId") != null && request.getParameter("hinId") !="") {
			hinId = Integer.parseInt(request.getParameter("hinId"));
			hinNo=ipdHandlerService.getHinNoForCaseSheet(hinId,hospitalId);
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = ipdHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("hospitalId", hospitalId);
		parameters.put("deptId", deptId);
		parameters.put("hinNo", hinNo);
		parameters.put("adNo", adNo);
		parameters.put("serviceNo", serviceNo);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
			HMSUtil.generateReport("dailyDietSheetReportWardBoth", parameters,
					(Connection) detailsMap.get("conn"), response, getServletContext());
	
		return null;
	}
	
	public ModelAndView showIssuedKitListReportJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "showIssuedKitListReportJsp.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
		
	}
	
	public ModelAndView printDrugConsuptionReport(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String consumptionDate="";
		String consumptionTime="";
		String toDate="";
		String fromDate="";
		String query="";
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (request.getParameter("consumptionDate") != null && request.getParameter("consumptionDate") !="") {
			consumptionDate = request.getParameter("consumptionDate");
			query=" and idc.CONSUMPTION_DATE=to_date('"+consumptionDate+"','dd/MM/yyyy')";
		}
		if (request.getParameter("consumptionTime") != null && request.getParameter("consumptionTime") !="") {
			consumptionTime = request.getParameter("consumptionTime");
			query=query +" and idc.CONSUMPTION_TIME='"+consumptionTime+"'";
		}
		if (request.getParameter(TO_DATE) != null && request.getParameter(TO_DATE) !="") {
			toDate = request.getParameter(TO_DATE);
		}
		if (request.getParameter(FROM_DATE) != null && request.getParameter(FROM_DATE) !="") {
			fromDate = request.getParameter(FROM_DATE);
			query=query+" and idc.CONSUMPTION_DATE between to_date('"+fromDate+"','dd/MM/yyyy') and to_date('"+toDate+"','dd/MM/yyyy') ";
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = ipdHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("hospitalId", hospitalId);
		parameters.put("query", query);
			HMSUtil.generateReport("nonDrugConsumptionReport", parameters,
					(Connection) detailsMap.get("conn"), response, getServletContext());
	
		return null;
	}
	
	public ModelAndView showNonDrugConsumptionReportJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "nonDrugConsumptionReportJsp.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
		
	}
	
	public void getItemStock(HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		box.put("deptId", (Integer)session.getAttribute("deptId"));
		box.put("hospitalId", (Integer)session.getAttribute("hospitalId"));
		map = ipdHandlerService.getItemStock(box);
		List<StoreItemBatchStock> itemBatchStockList = new ArrayList<StoreItemBatchStock>();
		if (map.get("itemBatchStockList") != null) {
			itemBatchStockList = (List) map.get("itemBatchStockList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			for (StoreItemBatchStock batchStock : itemBatchStockList) {
				sb.append("<item>");
				sb.append("<stock>" + batchStock.getClosingStock() + "</stock>");
				sb.append("<batchId>" + batchStock.getId() + "</batchId>");
				sb.append("</item>");
			}
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
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public ModelAndView getProcedureForDischargeSummary(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		
		int deptId = (Integer) session.getAttribute("deptId");
		int inPatientId = Integer.parseInt(request.getParameter("parent"));

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap.put("inPatientId", inPatientId);
		detailsMap.put("deptId", deptId);

		map = ipdHandlerService.getProcedureForDischargeSummary(detailsMap);
		map.put("inPatientId", inPatientId);
		

		jsp = "procedureForDischargeSummary";
		
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
		
	}

	public ModelAndView getTreatmentDetailsForDischargeSummary(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		
		int deptId = (Integer) session.getAttribute("deptId");
		int inPatientId = Integer.parseInt(request.getParameter("parent"));

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap.put("inPatientId", inPatientId);
		detailsMap.put("deptId", deptId);

		map = ipdHandlerService.getTreatmentDetailsForDischargeSummary(detailsMap);
		map.put("inPatientId", inPatientId);

		jsp = "treatmentForDischargeSummary";
		
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
		
	}
	/**
	 * Method to get prev Case Notes and Diagnosis for new IPD Case Sheet
	 */
	public ModelAndView getPrevCaseNoteDiagnosis(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box =HMSUtil.getBox(request);
		
		map = ipdHandlerService.getPrevCaseNoteDiagnosis(box);
		
		String jsp="responseCaseNotesDiagnosis";
		return new ModelAndView(jsp, "map", map);
	}
	/**
	 * Method to get prev treatment details for new IPD Case Sheet
	 */
	public ModelAndView getPrevTreatmentDetails(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box =HMSUtil.getBox(request);
		
		map = ipdHandlerService.getPrevTreatmentDetails(box);
		
		String jsp="responseTreatmentDetailsCaseSheet";
		return new ModelAndView(jsp, "map", map);
	}
	
	/**
	 * Method to get prev treatment details for new IPD Case Sheet
	 */
	public ModelAndView getPrevInvestigationDetails(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box =HMSUtil.getBox(request);
		map = ipdHandlerService.getPrevInvestigationDetails(box);
		String jsp="responseInvestigationDetailsCaseSheet";
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getPrevProcedureDetails(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box =HMSUtil.getBox(request);
		
		map = ipdHandlerService.getPrevProcedureDetails(box);
		
		String jsp="responseProcedureDetailsCaseSheet";
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getPrevPhysiotherapyDetails(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box =HMSUtil.getBox(request);
		
		map = ipdHandlerService.getPrevPhysiotherapyDetails(box);
		
		String jsp="responseTherapyDetailsCaseSheet";
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getPrevDietDetails(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box =HMSUtil.getBox(request);
		
		map = ipdHandlerService.getPrevDietDetails(box);
		
		String jsp="responseDietDetailsCaseSheet";
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getPrevConsultationDetails(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box =HMSUtil.getBox(request);
		
		map = ipdHandlerService.getPrevConsultationDetails(box);
		
		String jsp="responseConsultationDetailsCaseSheet";
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getTransferHistory(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box =HMSUtil.getBox(request);
		
		map = ipdHandlerService.getTransferHistory(box);
		
		String jsp="responseTransferHistoryCaseSheet";
		return new ModelAndView(jsp, "map", map);
	}
	
	public void showWardHelp(HttpServletRequest request,HttpServletResponse response) {

		
		String userHome = getServletContext().getRealPath("");
		String fileSeparator = System.getProperty("file.separator");
		String uploadURL = userHome
				+ fileSeparator
				+ "help"
				+ fileSeparator;
				
	
		
		try {
			
			response.setContentType("application/pdf");
			
			response.setHeader("Content-Disposition", "attachment;filename="
					+ java.net.URLEncoder.encode("Ward.pdf")
					+ "");

			File f = new File(uploadURL + "/Ward.pdf");
			InputStream in = new FileInputStream(f);
			response.getOutputStream().flush();
			ServletOutputStream outs = response.getOutputStream();

			long length = f.length();

			if (length > Integer.MAX_VALUE) {
				// File is too large
			}

			// Create the byte array to hold the data
			byte[] bytes = new byte[(int) length];

			int offset = 0;
			int numRead = 0;
			while (offset < bytes.length
					&& (numRead = in.read(bytes, offset, bytes.length - offset)) >= 0) {
				offset += numRead;
			}

			if (offset < bytes.length) {
			}
			outs.write(bytes);
			in.close();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	
	}
	
	public ModelAndView showDMADutyReportJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String jsp="dmaDutyReport.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public void printDMADutyReport(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		String fromTime="";
		String toTime="";
		Date fromDate= new Date();
		Date toDate=new Date();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (request.getParameter("fromTime") != null && !request.getParameter("fromTime").equals("")) {
			fromTime = request.getParameter("fromTime");
		}
		if (request.getParameter("toTime") != null && !request.getParameter("toTime").equals("")) {
			toTime = request.getParameter("toTime");
		}
		if (request.getParameter(FROM_DATE) != null && !request.getParameter(FROM_DATE).equals("")) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null && !request.getParameter(TO_DATE).equals("")) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}
		Users users = (Users) session.getAttribute("users");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("hospitalId", hospitalId);
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("fromTime", fromTime);
		parameters.put("toTime", toTime);
		parameters.put("dmaId", users.getId());

		ipdHandlerService.executeProcedureForDMADutyReport(parameters);
		detailsMap = ipdHandlerService.getDBConnection();
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
			HMSUtil.generateReport("DmaDutyReport", parameters,
					(Connection) detailsMap.get("conn"), response, getServletContext());
	
		
	}
	
	public ModelAndView showSpecialistOpinionJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box =HMSUtil.getBox(request);
		box.put("deptId", (Integer)session.getAttribute("deptId"));
		map = ipdHandlerService.showSpecialistOpinionJsp(box);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = ipdHandlerService.getPatientLatestDiagnosisAndDisability(box.getInt("parent"));
		if(detailsMap.get("diagnosisList")!=null){
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		if(detailsMap.get("disabilityList")!=null){
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}
		String jsp="ipdSpecialistOpenion.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView submitIpdSplcialistOpinion(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		Box box =HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		box.put("deptId", (Integer) session.getAttribute("deptId"));
		Users users = (Users)session.getAttribute("users");
		box.put("userId", users.getId());
		box.put("userName", users.getUserName());
		box.put("empId", users.getEmployee().getId());
		int deptId = (Integer) session.getAttribute("deptId");
		datamap = ipdHandlerService.submitIpdSplcialistOpinion(box);
		boolean flag = false;
		if(datamap.get("flag")!=null) {
			flag = (Boolean)datamap.get("flag");
		}
		/*map = ipdHandlerService.getPatientList(deptId,hospitalId);*/
		map = ipdHandlerService.getPatientListAndNotification(deptId,hospitalId, users.getEmployee().getId());

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		if (flag) {
			message = "Record Added successfully.";
		} else {
			message = " Error Ocurred. Please Try Again !!";
		}

		List set = (List) map.get("inpatientSet");
		map.put("inPatientSet", set);
		jsp = PATIENT_LIST_JSP+".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView viewSpecialistOpinion(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box =HMSUtil.getBox(request);
		map = ipdHandlerService.viewSpecialistOpinion(box);
		String jsp="viewIpdSpecialistOpenion";
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getSpecialistOpinionDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box =HMSUtil.getBox(request);
		map = ipdHandlerService.getSpecialistOpinionDetails(box);
		String jsp="viewIpdSpecialistOpenionDetails";
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView medicineIssuePage(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		/*int inpatientId = 0;
		if(request.getParameter("parent")!=null && request.getParameter("parent")!="")
		{
			inpatientId = Integer.parseInt(request.getParameter("parent"));
		}*/
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		map = ipdHandlerService.showDietEntryDetailsJsp(box);
		
		map.putAll(ipdHandlerService.getPatientLatestDiagnosisAndDisability(box.getInt("parent")));
		map.putAll(ipdHandlerService.showSurgeryRequisitionJspForHin(box));
		
		
		/*map.put("inpatientId", inpatientId);*/
		
		String jsp="medicineIssuePage";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	
	public ModelAndView getMedicineList(HttpServletRequest request,
			HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();*/
		List<PatientPrescriptionDetails> ppdList = new ArrayList<PatientPrescriptionDetails>();
		List<Object[]> dmiList = new ArrayList<Object[]>();
		

		box.put("hospitalId", hospitalId);

		String ExamType = "MedExam";
		box.put("ExamType", ExamType);
        
		map = ipdHandlerService.getMedicineList(box);

		/*if (map.get("OpdPatientDetailsEmpanelledList") != null) {
			OpdPatientDetailsEmpanelledList = (ArrayList) map.get("OpdPatientDetailsEmpanelledList");
		}*/
		
	/*	if (map.get("dmiList") != null) {
			dmiList = (ArrayList) map.get("dmiList");
			System.out.println("dmiList"+dmiList.size());
		}*/
		
		if (map.get("ppdList") != null) {
			ppdList = (ArrayList) map.get("ppdList");
			System.out.println("ppdList"+ppdList.size());
		}

		int totalRecords = 0;
		if (map.get("totalRecords") != null) {
			totalRecords = (Integer) map.get("totalRecords");
		}

		try {
			PrintWriter pw = response.getWriter();

			pw.write("[");
			int counter = 1;
			int i = 0;
			String referredFrom = "";
			int remainingQty = 0;

			for (PatientPrescriptionDetails list : ppdList) {		
				
							
				if(list.getQtyIssued()!=null)
				{
					remainingQty = list.getTotal()- list.getQtyIssued();
				}
				else
				{
					remainingQty = list.getTotal();
				}
				if (counter != ppdList.size()) {
					String nomenclature = "";
					String status = "";
					if (list.getItem() != null) {
						nomenclature = list.getItem().getNomenclature();
					}

					if (list.getItem() != null) {
						nomenclature += "["+list.getItem().getPvmsNo()+"]";
					}
					
					if (list.getItemStopStatus() == null || list.getItemStopStatus().equalsIgnoreCase("i")) {
						status="Pending for Issue";
					}
					
					else if (list.getItemStopStatus().equalsIgnoreCase("c")) {
						status="Completed";
					}
					
					else if (list.getItemStopStatus().equalsIgnoreCase("y")) {
						status="Stopped By Doctor";
					}

					pw.write("{\"headerId\": \""
							+ list.getId()
							+ "\",\"nomenclature\": \""
							+ (nomenclature)
							+ "\",\"prescriptionDate\": \""
						    + (list.getPrescription().getPrescriptionDate()!=null?HMSUtil.convertDateToStringTypeDateOnly(list.getPrescription().getPrescriptionDate()):"")
							+ "\",\"frequency\": \""
							+ (list.getFrequency()!=null?list.getFrequency().getFrequencyName():"")		
							+ "\",\"no_of_days\": \""
							+ (list.getNoOfDays()!=null?list.getNoOfDays():"")		
							+ "\",\"prescribedQuantity\": \""
							+ (list.getTotal()!=null?list.getTotal():0)
							+ "\",\"dosage\": \""
							+ (list.getDosage()!=null?list.getDosage():"")
							+ "\",\"issuedQuantity\": \""
							+ (list.getQtyIssued()!=null?list.getQtyIssued():0)
							+ "\",\"remainingQuantity\": \""
							+ remainingQty
							+ "\",\"status\": \""
							+ (status)												
							+ "\",\"totalRecords\":\"" + totalRecords + "\"},");

				} else {String nomenclature = "";
				String status = "";
				if (list.getItem() != null) {
					nomenclature = list.getItem().getNomenclature();
				}

				if (list.getItem() != null) {
					nomenclature += "["+list.getItem().getPvmsNo()+"]";
				}
				
				if (list.getItemStopStatus() == null || list.getItemStopStatus().equalsIgnoreCase("i")) {
					status="Pending for Issue";
				}
				
				else if (list.getItemStopStatus().equalsIgnoreCase("c")) {
					status="Completed";
				}
				
				else if (list.getItemStopStatus().equalsIgnoreCase("y")) {
					status="Stopped By Doctor";
				}

				pw.write("{\"headerId\": \""
						+ list.getId()
						+ "\",\"nomenclature\": \""
						+ (nomenclature)
						+ "\",\"prescriptionDate\": \""
					    + (list.getPrescription().getPrescriptionDate()!=null?HMSUtil.convertDateToStringTypeDateOnly(list.getPrescription().getPrescriptionDate()):"")
						+ "\",\"frequency\": \""
						+ (list.getFrequency()!=null?list.getFrequency().getFrequencyName():"")		
						+ "\",\"no_of_days\": \""
						+ (list.getNoOfDays()!=null?list.getNoOfDays():"")		
						+ "\",\"prescribedQuantity\": \""
						+ (list.getTotal()!=null?list.getTotal():0)
						+ "\",\"dosage\": \""
						+ (list.getDosage()!=null?list.getDosage():"")
						+ "\",\"issuedQuantity\": \""
						+ (list.getQtyIssued()!=null?list.getQtyIssued():0)
						+ "\",\"remainingQuantity\": \""
						+ remainingQty
						+ "\",\"status\": \""
						+ (status)												
						+ "\",\"totalRecords\":\"" + totalRecords + "\"}");

				
			}

				counter++;
				i++;
			

		}
			pw.write("]");
			System.out.println("pw"+pw);
			System.out.println("ppdList"+ppdList.size());
		}
		
		

		catch (Exception e) {
			ppdList.clear();
			e.printStackTrace();
		}
		ppdList.clear();
		return null;

	}
	
	/*public ModelAndView getMedicineEntryPage(HttpServletRequest request,
			HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();
		List<IpdMedicineIssueDetails> ipdMedicineIssueDetailsList = new ArrayList<IpdMedicineIssueDetails>();	

		box.put("hospitalId", hospitalId);

        
		map = ipdHandlerService.getMedicineEntryPage(box);

		if (map.get("OpdPatientDetailsEmpanelledList") != null) {
			OpdPatientDetailsEmpanelledList = (ArrayList) map.get("OpdPatientDetailsEmpanelledList");
		}
		
		if (map.get("ipdMedicineIssueDetailsList") != null) {
			ipdMedicineIssueDetailsList = (ArrayList) map.get("ipdMedicineIssueDetailsList");
		}

		int totalRecords = 0;
		if (map.get("totalRecords") != null) {
			totalRecords = (Integer) map.get("totalRecords");
		}

		try {
			PrintWriter pw = response.getWriter();

			pw.write("[");
			int counter = 1;
			int i = 0;
			String referredFrom = "";

			for (IpdMedicineIssueDetails list : ipdMedicineIssueDetailsList) {		
				
				
				 
				if (counter != ipdMedicineIssueDetailsList.size()) {
					String nomenclature = "";
					String status = "";
					if (list.getPatientPrescriptionDetails().getItem() != null) {
						nomenclature = list.getPatientPrescriptionDetails().getItem().getNomenclature();
					}

					if (list.getPatientPrescriptionDetails().getItem() != null) {
						nomenclature += "["+list.getPatientPrescriptionDetails().getItem().getPvmsNo()+"]";
					}
					
					if (list.getStatus().equalsIgnoreCase("i")) {
						status="Issue";
					}
					
					if (list.getStatus().equalsIgnoreCase("c")) {
						status="Issue Completed";
					}
					
					if (list.getStatus().equalsIgnoreCase("s")) {
						status="Stopped By Doctor";
					}

					pw.write("{\"headerId\": \""
							+ list.getId()
							+ "\",\"nomenclature\": \""
							+ (nomenclature)
							+ "\",\"frequency\": \""
							+ (list.getPatientPrescriptionDetails().getFrequency()!=null?list.getPatientPrescriptionDetails().getFrequency().getFrequencyName():"")		
							+ "\",\"no_of_days\": \""
							+ (list.getPatientPrescriptionDetails().getNoOfDays()!=null?list.getPatientPrescriptionDetails().getNoOfDays():"")		
							+ "\",\"prescribedQuantity\": \""
							+ (list.getPatientPrescriptionDetails().getTotal()!=null?list.getPatientPrescriptionDetails().getTotal():"")
							+ "\",\"issuedQuantity\": \""
							+ (list.getIssuedQuantity()!=null?list.getIssuedQuantity():"")
							+ "\",\"receivedQuantity\": \""
							+ (list.getPatientPrescriptionDetails().getQtyIssued()!=null?list.getPatientPrescriptionDetails().getQtyIssued():"")
							+ "\",\"status\": \""
							+ (status)												
							+ "\",\"totalRecords\":\"" + totalRecords + "\"},");

				} else {String nomenclature = "";
				String status = "";
				if (list.getPatientPrescriptionDetails().getItem() != null) {
					nomenclature = list.getPatientPrescriptionDetails().getItem().getNomenclature();
				}

				if (list.getPatientPrescriptionDetails().getItem() != null) {
					nomenclature += "["+list.getPatientPrescriptionDetails().getItem().getPvmsNo()+"]";
				}
				
				if (list.getStatus().equalsIgnoreCase("i")) {
					status="Issue";
				}
				
				if (list.getStatus().equalsIgnoreCase("c")) {
					status="Issue Completed";
				}
				
				if (list.getStatus().equalsIgnoreCase("s")) {
					status="Stopped By Doctor";
				}

				pw.write("{\"headerId\": \""
						+ list.getId()
						+ "\",\"nomenclature\": \""
						+ (nomenclature)
						+ "\",\"frequency\": \""
						+ (list.getPatientPrescriptionDetails().getFrequency()!=null?list.getPatientPrescriptionDetails().getFrequency().getFrequencyName():"")		
						+ "\",\"no_of_days\": \""
						+ (list.getPatientPrescriptionDetails().getNoOfDays()!=null?list.getPatientPrescriptionDetails().getNoOfDays():"")		
						+ "\",\"prescribedQuantity\": \""
						+ (list.getPatientPrescriptionDetails().getTotal()!=null?list.getPatientPrescriptionDetails().getTotal():"")
						+ "\",\"issuedQuantity\": \""
						+ (list.getIssuedQuantity()!=null?list.getIssuedQuantity():"")
						+ "\",\"receivedQuantity\": \""
						+ (list.getPatientPrescriptionDetails().getQtyIssued()!=null?list.getPatientPrescriptionDetails().getQtyIssued():"")
						+ "\",\"status\": \""
						+ (status)												
						+ "\",\"totalRecords\":\"" + totalRecords + "\"}");}

				counter++;
				i++;
			}

			pw.write("]");

		}

		catch (Exception e) {
			ipdMedicineIssueHeaderList.clear();
			e.printStackTrace();
		}
		ipdMedicineIssueHeaderList.clear();
		return null;

	}*/
	
	
	@SuppressWarnings("unused")
	public ModelAndView getMedicineEntryPage(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int headerId = Integer.parseInt(request.getParameter("headerId"));
		
		box.put("headerId", headerId);
		
		map = ipdHandlerService.getMedicineEntryPage(box);		

		
		jsp = "getMedicineEntryPage";
		title = "Medicine Entry";
		map.put("contentJsp", jsp);
	
		map.put("title", title);
		map.put("remainingQty", request.getParameter("remainingQty"));

		return new ModelAndView(jsp, "map", map);
	}
	

	
	@SuppressWarnings("unchecked")
	public synchronized ModelAndView submitMedicineEntryPage(
				HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession();

			Box box = HMSUtil.getBox(request);
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			Users users = (Users) session.getAttribute("users");
			int deptId = (Integer) session.getAttribute("deptId");	
			box.put("userId", users.getId());
			Map<String, Object> map = new HashMap<String, Object>();
			
			boolean successfullyAdded = ipdHandlerService
					.submitMedicineEntryPage(box);
			
		
			map = ipdHandlerService.getMedicineEntryPage(box);			
			
			/*List set = (List) map.get("inpatientSet");
			map.put("inPatientSet", set);*/
			
			if (successfullyAdded) {
				message = "Medicine Entry has been submitted Successfully !!";
			} else {
				message = " Error Ocurred Please Try Again !!";
			}
			
			jsp = "getMedicineEntryPage";
			title = "Medicine Entry";
			map.put("contentJsp", jsp);
			map.put("message", message);
			map.put("title", title);

			return new ModelAndView(jsp, "map", map);
	}
	/*
	@SuppressWarnings("unchecked")
	public synchronized ModelAndView submitMedicineEntryPage(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		Box box = HMSUtil.getBox(request);

		Users user = (Users) session.getAttribute("users");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		box.put("userId", user.getId());
				
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Boolean successfullyAdded = false;	

		System.out.println("before Submit");
		detailsMap = referralHandlerService.submitInvoicePageForHRDivision(box);
			
	
		if (detailsMap.get("succesfullyAdded") != null) {
			successfullyAdded = (Boolean) detailsMap.get("succesfullyAdded");
		}
		String message;
		if (successfullyAdded == true) {
			message = "Patient Invoice saved Successfully.";
			
		}  else {
			message = "Some problem Occured! Try Again.";
			
		}
	

		dataMap.put("users", user);
			
		String jsp = "msgForGenerateInvoicePage.jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);		
		
		return new ModelAndView("index", "map", map);
	}*/
	
	public ModelAndView showIntakeOutputChartReportIPD(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		int admissionNumber = 0;
		Date toDate = new Date();
		Date fromDate = new Date();
		String reportType="";
		String serviceNo="";
		int hinId=0;
		String hinNo="";
		int hospitalId=0;
		String reportName="";
		byte[] bytes = null;
		HttpSession session = request.getSession();
		hospitalId=Integer.parseInt(""+session.getAttribute("hospitalId"));
		requestParameters.put(HOSPITAL_ID, hospitalId);
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter("adNo") != null
					&& !(request.getParameter("adNo").equals(""))) {
				admissionNumber = Integer.parseInt(request.getParameter("adNo"));
			}
			if (request.getParameter("serviceNo") != null
					&& !(request.getParameter("serviceNo").equals(""))) {
				serviceNo = request.getParameter("serviceNo");
			}
			if (request.getParameter("hinId") != null
					&& !(request.getParameter("hinId").equals(""))) {
				hinId = Integer.parseInt(request.getParameter("hinId"));
				hinNo=ipdHandlerService.getHinNoForCaseSheet(hinId,hospitalId);
			}
			if (request.getParameter("reportType") != null
					&& !(request.getParameter("reportType").equals(""))) {
				reportType = request.getParameter("reportType");
			}
			if(reportType.equalsIgnoreCase("summary")){
				reportName="IntakeOutputNewIPD";
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		map = ipdHandlerService.getDBConnection();
	//	map.put("fromDate", fromDate);
	//	map.put("toDate", toDate);
		map.put("hinNo", hinNo);
		map.put("serviceNo", serviceNo);
		map.put("hospitalId", hospitalId);
		map.put("adNo", admissionNumber);
		String hospitalName="";
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			hospitalName = ipdHandlerService.getHospitalName(hospitalId);
			parameters.put("hospitalName", hospitalName);
			parameters.put("hospitalId", hospitalId);
		}
		String userHome = getServletContext().getRealPath("");	         
        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
        map.put("path", imagePath);
		map.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		//System.out.println("getServletContext().getRealPath "+ getServletContext().getRealPath("/reports/"));
		// try {
		//
		// bytes =
		// JasperRunManager.runReportToPdf(getCompiledReport("IntakeOutput"),
		// map,(Connection) map.get("conn"));
		// HMSUtil.generateReport("IntakeOutput", map,
		// (Connection)map.get("conn"), response, getServletContext());
		//
		// } catch (JRException e) {
		// e.printStackTrace();
		// }
		// response.setContentType("application/pdf");
		// response.setContentLength(bytes.length);
		// ServletOutputStream ouputStream;
		// try {
		// ouputStream = response.getOutputStream();
		// ouputStream.write(bytes, 0, bytes.length);
		// ouputStream.flush();
		// ouputStream.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		HMSUtil.generateReport(reportName, map, (Connection) map
				.get("conn"), response, getServletContext());
		return null;
	}
}
