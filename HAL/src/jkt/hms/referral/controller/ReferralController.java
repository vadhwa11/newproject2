package jkt.hms.referral.controller;

import static jkt.hms.util.RequestConstants.ADDRESS;
import static jkt.hms.util.RequestConstants.ADMISSION_NUMBER;
import static jkt.hms.util.RequestConstants.AGE;
import static jkt.hms.util.RequestConstants.BLOOD_GROUP_ID;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.CONSULTING_DOCTOR;
import static jkt.hms.util.RequestConstants.CONTACT_NUMBER;
import static jkt.hms.util.RequestConstants.DATE_OF_BIRTH;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DISTRICT;
import static jkt.hms.util.RequestConstants.EMPLOYEE_ID;
import static jkt.hms.util.RequestConstants.FILE_NAME;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.GENDER;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.HIN_NO_FOR_REPORT;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.MARITAL_STATUS_ID;
import static jkt.hms.util.RequestConstants.MOBILE_NO;
import static jkt.hms.util.RequestConstants.NEXT_OF_KIN_ADDRESS;
import static jkt.hms.util.RequestConstants.NEXT_OF_KIN_NAME;
import static jkt.hms.util.RequestConstants.NEXT_OF_KIN_PHONE_NO;
import static jkt.hms.util.RequestConstants.NEXT_OF_KIN_RELATION_ID;
import static jkt.hms.util.RequestConstants.OCCUPATION_ID;
import static jkt.hms.util.RequestConstants.OUTPUT_TO;
import static jkt.hms.util.RequestConstants.PERMANENT_ADDRESS;
import static jkt.hms.util.RequestConstants.P_FIRST_NAME;
import static jkt.hms.util.RequestConstants.P_LAST_NAME;
import static jkt.hms.util.RequestConstants.P_MIDDLE_NAME;
import static jkt.hms.util.RequestConstants.RANK_CATEGORY_ID;
import static jkt.hms.util.RequestConstants.RANK_ID;
import static jkt.hms.util.RequestConstants.RECORD_OFFICE_ADDRESS_ID;
import static jkt.hms.util.RequestConstants.REG_DATE;
import static jkt.hms.util.RequestConstants.REG_TIME;
import static jkt.hms.util.RequestConstants.RELATION_ID;
import static jkt.hms.util.RequestConstants.RELIGION_ID;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SECTION_ID;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.SERVICE_NO_FOR_REPORT;
import static jkt.hms.util.RequestConstants.SERVICE_STATUS_ID;
import static jkt.hms.util.RequestConstants.SERVICE_TYPE_ID;
import static jkt.hms.util.RequestConstants.SERV_BLD_GROUP;
import static jkt.hms.util.RequestConstants.SESSION_ID;
import static jkt.hms.util.RequestConstants.SEX_ID;
import static jkt.hms.util.RequestConstants.SR_AGE;
import static jkt.hms.util.RequestConstants.SR_AGE_UNIT;
import static jkt.hms.util.RequestConstants.SR_BLOOD_GROUP_ID;
import static jkt.hms.util.RequestConstants.SR_DOB;
import static jkt.hms.util.RequestConstants.SR_NEXT_OF_KIN_ADDRESS;
import static jkt.hms.util.RequestConstants.SR_NEXT_OF_KIN_NAME;
import static jkt.hms.util.RequestConstants.SR_NEXT_OF_KIN_PHONE_NO;
import static jkt.hms.util.RequestConstants.SR_NEXT_OF_KIN_RELATION_ID;
import static jkt.hms.util.RequestConstants.SR_SEX;
import static jkt.hms.util.RequestConstants.STATE;
import static jkt.hms.util.RequestConstants.S_FIRST_NAME;
import static jkt.hms.util.RequestConstants.S_LAST_NAME;
import static jkt.hms.util.RequestConstants.S_MIDDLE_NAME;
import static jkt.hms.util.RequestConstants.TELEPHONE_NO;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.TRADE_ID;
import static jkt.hms.util.RequestConstants.UNIT_ID;
import static jkt.hms.util.RequestConstants.USER_ID;
import static jkt.hms.util.RequestConstants.VISIT_ID;
import static jkt.hms.util.RequestConstants.VISIT_NUMBER_FOR_REPORT;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.sql.Connection;
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

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import jkt.hms.adt.handler.RegistrationHandlerService;
import jkt.hms.masters.business.Category;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasBloodGroup;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasMaritalStatus;
import jkt.hms.masters.business.MasOccupation;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRecordOfficeAddress;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasReligion;
import jkt.hms.masters.business.MasSession;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasTherapyType;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.ReferralPatientBilling;
import jkt.hms.masters.business.ReferralPatientDetails;
import jkt.hms.masters.business.ReferralPatientHeader;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.referral.handler.ReferralHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ReferralController extends MultiActionController {
	
	ReferralHandlerService referralHandlerService = null;
	
	public ModelAndView referralWaitingList(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = referralHandlerService.getInvoiceWaitingFilterData(box);
		String jsp="referralWaitingList";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	
	public ModelAndView referredPatientListForDoctor(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = referralHandlerService.getInvoiceWaitingFilterData(box);
		String jsp="referralWaitingListForDoctor";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	
	public ModelAndView getReferralWaitingList(HttpServletRequest request,
			HttpServletResponse response)
	{
		System.out.println("Hi=========================");
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();
		Box box = HMSUtil.getBox(request);

		box.put("hospitalId", hospitalId);

		String ExamType = "MedExam";
		box.put("ExamType", ExamType);
        
		map = referralHandlerService.getReferralWaitingList(box);

		if (map.get("OpdPatientDetailsEmpanelledList") != null) {
			OpdPatientDetailsEmpanelledList = (ArrayList) map.get("OpdPatientDetailsEmpanelledList");
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
			String treatmentType = "";

			for (OpdPatientDetails opdPatientDetails : OpdPatientDetailsEmpanelledList) {
				Patient list = new Patient();
				if(opdPatientDetails.getInpatient()!=null)
				{
					list = opdPatientDetails.getVisit().getHin();
					referredFrom = opdPatientDetails.getInpatient().getDepartment().getDepartmentName();
				}
				else
				{
					list = opdPatientDetails.getVisit().getHin();
					referredFrom = opdPatientDetails.getVisit().getDepartment().getDepartmentName();
				}
				if(opdPatientDetails.getReferralTreatmentType().equals("1"))
				{
					treatmentType = "OPD";
				}
				else
				{
					treatmentType = "Admission";
				}

				 
				if (counter != OpdPatientDetailsEmpanelledList.size()) {
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}
					
					pw.write("{\"opdId\": \""
							+ opdPatientDetails.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)			
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)			
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}

					pw.write("{\"opdId\": \""
							+ opdPatientDetails.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)			
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)			
							+ "\",\"totalRecords\":\"" + totalRecords + "\"}");
				}

				counter++;
				i++;
			}

			pw.write("]");

		}

		catch (Exception e) {
			OpdPatientDetailsEmpanelledList.clear();

			e.printStackTrace();
		}
		OpdPatientDetailsEmpanelledList.clear();
		return null;

	}
	
	public ModelAndView getReferralWaitingListForDoctor(HttpServletRequest request,
			HttpServletResponse response)
	{
		System.out.println("Hi=========================");
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int empId = (Integer) session.getAttribute("empId");
		List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();
		Box box = HMSUtil.getBox(request);

		box.put("hospitalId", hospitalId);
		box.put("empId", empId);

		String ExamType = "MedExam";
		box.put("ExamType", ExamType);
        
		map = referralHandlerService.getReferralWaitingListForDoctor(box);

		if (map.get("OpdPatientDetailsEmpanelledList") != null) {
			OpdPatientDetailsEmpanelledList = (ArrayList) map.get("OpdPatientDetailsEmpanelledList");
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
			String treatmentType = "";

			for (OpdPatientDetails opdPatientDetails : OpdPatientDetailsEmpanelledList) {
				Patient list = new Patient();
				if(opdPatientDetails.getVisit()!=null)
				{
					list = opdPatientDetails.getVisit().getHin();
					referredFrom = opdPatientDetails.getVisit().getDepartment().getDepartmentName();
				}else
				{
					list = opdPatientDetails.getInpatient().getHin();
					referredFrom = opdPatientDetails.getInpatient().getDepartment().getDepartmentName();
				}
				if(opdPatientDetails.getReferralTreatmentType().equals("1"))
				{
					treatmentType = "OPD";
				}
				else
				{
					treatmentType = "Admission";
				}

				 
				if (counter != OpdPatientDetailsEmpanelledList.size()) {
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}
					
					pw.write("{\"opdId\": \""
							+ opdPatientDetails.getId() 
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)			
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)			
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}

					pw.write("{\"opdId\": \""
							+ opdPatientDetails.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)			
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)			
							+ "\",\"totalRecords\":\"" + totalRecords + "\"}");
				}

				counter++;
				i++;
			}

			pw.write("]");

		}

		catch (Exception e) {
			OpdPatientDetailsEmpanelledList.clear();

			e.printStackTrace();
		}
		OpdPatientDetailsEmpanelledList.clear();
		return null;

	}
	
	public ModelAndView extensionWaitingList(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = referralHandlerService.getInvoiceWaitingFilterData(box);
		String jsp="extensionWaitingList";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	
	public ModelAndView getExtensionWaitingList(HttpServletRequest request,
			HttpServletResponse response)
	{
		System.out.println("Hi=========================");
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		List<ReferralPatientHeader> referralPatientHeaderExtensionList = new ArrayList<ReferralPatientHeader>();
		Box box = HMSUtil.getBox(request);

		box.put("hospitalId", hospitalId);

		String ExamType = "MedExam";
		box.put("ExamType", ExamType);
        
		map = referralHandlerService.getExtensionWaitingList(box);

		if (map.get("referralPatientHeaderExtensionList") != null) {
			referralPatientHeaderExtensionList = (ArrayList) map.get("referralPatientHeaderExtensionList");
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
			String treatmentType = "";

			for (ReferralPatientHeader referralPatientHeader : referralPatientHeaderExtensionList) {
				OpdPatientDetails opdPatientDetails = referralPatientHeader.getOpdPatientDetails();
				Patient list = new Patient();
				if(opdPatientDetails.getVisit()!=null)
				{
					list = opdPatientDetails.getVisit().getHin();
					referredFrom = opdPatientDetails.getVisit().getDepartment().getDepartmentName();
				}else
				{
					list = opdPatientDetails.getInpatient().getHin();
					referredFrom = opdPatientDetails.getInpatient().getDepartment().getDepartmentName();
				}
				if(opdPatientDetails.getReferralTreatmentType().equals("1"))
				{
					treatmentType = "OPD";
				}
				else
				{
					treatmentType = "Admission";
				}

				 
				if (counter != referralPatientHeaderExtensionList.size()) {
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
					if (referralPatientHeader.getDoctor().getFirstName() != null) {
						referredBy = referralPatientHeader.getDoctor().getFirstName();
					}

					if (referralPatientHeader.getDoctor().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ referralPatientHeader.getDoctor().getMiddleName();
					}
					if (referralPatientHeader.getDoctor().getLastName() != null) {
						referredBy = referredBy + " "
								+ referralPatientHeader.getDoctor().getLastName();
					}
					
					pw.write("{\"opdId\": \""
							+ opdPatientDetails.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)			
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)			
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}

					pw.write("{\"opdId\": \""
							+ opdPatientDetails.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)			
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)			
							+ "\",\"totalRecords\":\"" + totalRecords + "\"}");
				}

				counter++;
				i++;
			}

			pw.write("]");

		}

		catch (Exception e) {
			referralPatientHeaderExtensionList.clear();

			e.printStackTrace();
		}
		referralPatientHeaderExtensionList.clear();
		return null;

	}
	

	public ModelAndView invoiceWaitingListForHRDivision(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = referralHandlerService.getInvoiceWaitingFilterData(box);
		String jsp="invoiceWaitingListForHRDivision";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	

	public ModelAndView getInvoiceWaitingListForHRDivision(HttpServletRequest request,
			HttpServletResponse response)
	{
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();*/
		List<ReferralPatientHeader> referralPatientHeaderList = new ArrayList<ReferralPatientHeader>();
        Users user = (Users) session.getAttribute("users");		
		
		Box box = HMSUtil.getBox(request);
		box.put("userId", user.getId());

		box.put("hospitalId", hospitalId);

		String ExamType = "MedExam";
		box.put("ExamType", ExamType);
        
		map = referralHandlerService.getInvoiceWaitingListForHRDivision(box);

		/*if (map.get("OpdPatientDetailsEmpanelledList") != null) {
			OpdPatientDetailsEmpanelledList = (ArrayList) map.get("OpdPatientDetailsEmpanelledList");
		}*/
		
		if (map.get("referralPatientHeaderList") != null) {
			referralPatientHeaderList = (ArrayList) map.get("referralPatientHeaderList");
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
			String treatmentType = "";

			for (ReferralPatientHeader referralPatientHeader : referralPatientHeaderList) {
				OpdPatientDetails opdPatientDetails = referralPatientHeader.getOpdPatientDetails();
				Patient list = new Patient();
				if(opdPatientDetails.getVisit()!=null)
				{
					list = opdPatientDetails.getVisit().getHin();
					referredFrom = opdPatientDetails.getVisit().getDepartment().getDepartmentName();
				}else
				{
					list = opdPatientDetails.getInpatient().getHin();
					referredFrom = opdPatientDetails.getInpatient().getDepartment().getDepartmentName();
				}
				if(opdPatientDetails.getReferralTreatmentType().equals("1"))
				{
					treatmentType = "OPD";
				}
				else
				{
					treatmentType = "Admission";
				}
				 
				if (counter != referralPatientHeaderList.size()) {
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}

					pw.write("{\"opdId\": \""
							+ referralPatientHeader.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)			
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"impanelledHospital\": \""
							+ (opdPatientDetails.getImpanneledHospital() != null ? opdPatientDetails.getImpanneledHospital().getImpanneledHospitalName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
							+ "\",\"HIN\": \""
							+ (list.getHinNo() != null ? list.getHinNo() : "")
							+ "\",\"gender\": \""
							+ (list.getSex() != null ? list.getSex()
									.getAdministrativeSexName() : "")
							+ "\",\"name\": \""
							+ servicepatientName
							+ "\",\"approvalStatusCode\":\""
							+ (referralPatientHeader.getApprovalStatus()!=null?referralPatientHeader.getApprovalStatus():"")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)								
							+ "\",\"referralNo\":\""							
							+ (referralPatientHeader.getReferralNo()!=null?referralPatientHeader.getReferralNo():"")
							+ "\",\"coverNoteNo\":\""							
							+ (referralPatientHeader.getCovernoteNumber()!=null?referralPatientHeader.getCovernoteNumber():"")
							+ "\",\"coverNoteDate\":\""							
							+ (referralPatientHeader.getCovernoteDate()!=null?referralPatientHeader.getCovernoteDate():"")
							+ "\",\"adminBillAmt\":\""
							+ (referralPatientHeader.getAdminBillAmt()!=null?referralPatientHeader.getAdminBillAmt():"")
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}

					pw.write("{\"opdId\": \""
							+ referralPatientHeader.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)			
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"impanelledHospital\": \""
							+ (opdPatientDetails.getImpanneledHospital() != null ? opdPatientDetails.getImpanneledHospital().getImpanneledHospitalName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
							+ "\",\"HIN\": \""
							+ (list.getHinNo() != null ? list.getHinNo() : "")
							+ "\",\"gender\": \""
							+ (list.getSex() != null ? list.getSex()
									.getAdministrativeSexName() : "")
							+ "\",\"name\": \""
							+ servicepatientName
							+ "\",\"approvalStatusCode\":\""
							+ (referralPatientHeader.getApprovalStatus()!=null?referralPatientHeader.getApprovalStatus():"")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)
							
							+ "\",\"referralNo\":\""							
							+ (referralPatientHeader.getReferralNo()!=null?referralPatientHeader.getReferralNo():"")
							+ "\",\"coverNoteNo\":\""							
							+ (referralPatientHeader.getCovernoteNumber()!=null?referralPatientHeader.getCovernoteNumber():"")
							+ "\",\"coverNoteDate\":\""							
							+ (referralPatientHeader.getCovernoteDate()!=null?referralPatientHeader.getCovernoteDate():"")
							+ "\",\"adminBillAmt\":\""
							+ (referralPatientHeader.getAdminBillAmt()!=null?referralPatientHeader.getAdminBillAmt():"")
							+ "\",\"totalRecords\":\"" + totalRecords + "\"}");
				}

				counter++;
				i++;
			}

			pw.write("]");

		}

		catch (Exception e) {
			referralPatientHeaderList.clear();

			e.printStackTrace();
		}
		referralPatientHeaderList.clear();
		return null;

	}
	
	public ModelAndView invoiceWaitingListForHRDivisionRejected(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request); 
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);	
		Users user = (Users) session.getAttribute("users");		
		box.put("userId", user.getId());
		box.put("hospitalId", hospitalId);
		box.put("status", "RFA");
		map = referralHandlerService.getInvoiceWaitingFilterData(box);
		String jsp="invoiceWaitingListForHRDivisionRejected";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	
	public ModelAndView getInvoiceWaitingListForHRDivisionRejected(HttpServletRequest request,
			HttpServletResponse response)
	{
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();*/
		List<ReferralPatientHeader> referralPatientHeaderList = new ArrayList<ReferralPatientHeader>();
        Users user = (Users) session.getAttribute("users");		
		
		Box box = HMSUtil.getBox(request);
		box.put("userId", user.getId());

		box.put("hospitalId", hospitalId);

		String ExamType = "MedExam";
		box.put("ExamType", ExamType);
        
		map = referralHandlerService.getInvoiceWaitingListForHRDivisionRejected(box);

		/*if (map.get("OpdPatientDetailsEmpanelledList") != null) {
			OpdPatientDetailsEmpanelledList = (ArrayList) map.get("OpdPatientDetailsEmpanelledList");
		}*/
		
		if (map.get("referralPatientHeaderList") != null) {
			referralPatientHeaderList = (ArrayList) map.get("referralPatientHeaderList");
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
			String treatmentType = "";

			for (ReferralPatientHeader referralPatientHeader : referralPatientHeaderList) {
				OpdPatientDetails opdPatientDetails = referralPatientHeader.getOpdPatientDetails();
				Patient list = new Patient();
				if(opdPatientDetails.getVisit()!=null)
				{
					list = opdPatientDetails.getVisit().getHin();
					referredFrom = opdPatientDetails.getVisit().getDepartment().getDepartmentName();
				}else
				{
					list = opdPatientDetails.getInpatient().getHin();
					referredFrom = opdPatientDetails.getInpatient().getDepartment().getDepartmentName();
				}
				if(opdPatientDetails.getReferralTreatmentType().equals("1"))
				{
					treatmentType = "OPD";
				}
				else
				{
					treatmentType = "Admission";
				}
				 
				if (counter != referralPatientHeaderList.size()) {
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}

					pw.write("{\"opdId\": \""
							+ referralPatientHeader.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)			
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"impanelledHospital\": \""
							+ (opdPatientDetails.getImpanneledHospital() != null ? opdPatientDetails.getImpanneledHospital().getImpanneledHospitalName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
							+ "\",\"HIN\": \""
							+ (list.getHinNo() != null ? list.getHinNo() : "")
							+ "\",\"gender\": \""
							+ (list.getSex() != null ? list.getSex()
									.getAdministrativeSexName() : "")
							+ "\",\"name\": \""
							+ servicepatientName
							+ "\",\"approvalStatusCode\":\""
							+ (referralPatientHeader.getApprovalStatus()!=null?referralPatientHeader.getApprovalStatus():"")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)								
							+ "\",\"referralNo\":\""							
							+ (referralPatientHeader.getReferralNo()!=null?referralPatientHeader.getReferralNo():"")
							+ "\",\"coverNoteNo\":\""							
							+ (referralPatientHeader.getCovernoteNumber()!=null?referralPatientHeader.getCovernoteNumber():"")
							+ "\",\"coverNoteDate\":\""							
							+ (referralPatientHeader.getCovernoteDate()!=null?referralPatientHeader.getCovernoteDate():"")
							+ "\",\"adminBillAmt\":\""
							+ (referralPatientHeader.getAdminBillAmt()!=null?referralPatientHeader.getAdminBillAmt():"")
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}

					pw.write("{\"opdId\": \""
							+ referralPatientHeader.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)			
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"impanelledHospital\": \""
							+ (opdPatientDetails.getImpanneledHospital() != null ? opdPatientDetails.getImpanneledHospital().getImpanneledHospitalName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
							+ "\",\"HIN\": \""
							+ (list.getHinNo() != null ? list.getHinNo() : "")
							+ "\",\"gender\": \""
							+ (list.getSex() != null ? list.getSex()
									.getAdministrativeSexName() : "")
							+ "\",\"name\": \""
							+ servicepatientName
							+ "\",\"approvalStatusCode\":\""
							+ (referralPatientHeader.getApprovalStatus()!=null?referralPatientHeader.getApprovalStatus():"")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)
							
							+ "\",\"referralNo\":\""							
							+ (referralPatientHeader.getReferralNo()!=null?referralPatientHeader.getReferralNo():"")
							+ "\",\"coverNoteNo\":\""							
							+ (referralPatientHeader.getCovernoteNumber()!=null?referralPatientHeader.getCovernoteNumber():"")
							+ "\",\"coverNoteDate\":\""							
							+ (referralPatientHeader.getCovernoteDate()!=null?referralPatientHeader.getCovernoteDate():"")
							+ "\",\"adminBillAmt\":\""
							+ (referralPatientHeader.getAdminBillAmt()!=null?referralPatientHeader.getAdminBillAmt():"")
							+ "\",\"totalRecords\":\"" + totalRecords + "\"}");
				}

				counter++;
				i++;
			}

			pw.write("]");

		}

		catch (Exception e) {
			referralPatientHeaderList.clear();

			e.printStackTrace();
		}
		referralPatientHeaderList.clear();
		return null;

	}
	public ModelAndView invoiceWaitingListForFinanceDivision(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = referralHandlerService.getInvoiceWaitingFilterData(box);
		String jsp="invoiceWaitingListForFinanceDivision";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	
	public ModelAndView getInvoiceWaitingListForFinanceDivision(HttpServletRequest request,
			HttpServletResponse response)
	{
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();*/
		List<ReferralPatientHeader> referralPatientHeaderList = new ArrayList<ReferralPatientHeader>();
        Users user = (Users) session.getAttribute("users");		
		
		Box box = HMSUtil.getBox(request);
		box.put("userId", user.getId());

		box.put("hospitalId", hospitalId);

		String ExamType = "MedExam";
		box.put("ExamType", ExamType);
        
		map = referralHandlerService.getInvoiceWaitingListForFinanceDivision(box);

		/*if (map.get("OpdPatientDetailsEmpanelledList") != null) {
			OpdPatientDetailsEmpanelledList = (ArrayList) map.get("OpdPatientDetailsEmpanelledList");
		}*/
		
		if (map.get("referralPatientHeaderList") != null) {
			referralPatientHeaderList = (ArrayList) map.get("referralPatientHeaderList");
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
			String treatmentType = "";

			for (ReferralPatientHeader referralPatientHeader : referralPatientHeaderList) {
				OpdPatientDetails opdPatientDetails = referralPatientHeader.getOpdPatientDetails();
				Patient list = new Patient();
				if(opdPatientDetails.getVisit()!=null)
				{
					list = opdPatientDetails.getVisit().getHin();
					referredFrom = opdPatientDetails.getVisit().getDepartment().getDepartmentName();
				}else
				{
					list = opdPatientDetails.getInpatient().getHin();
					referredFrom = opdPatientDetails.getInpatient().getDepartment().getDepartmentName();
				}
				if(opdPatientDetails.getReferralTreatmentType().equals("1"))
				{
					treatmentType = "OPD";
				}
				else
				{
					treatmentType = "Admission";
				}
				 
				if (counter != referralPatientHeaderList.size()) {
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}

					pw.write("{\"opdId\": \""
							+ referralPatientHeader.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)			
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"impanelledHospital\": \""
							+ (opdPatientDetails.getImpanneledHospital() != null ? opdPatientDetails.getImpanneledHospital().getImpanneledHospitalName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)	
							+ "\",\"referralNo\":\""
							+ "\",\"referralNo\":\""							
							+ (referralPatientHeader.getReferralNo()!=null?referralPatientHeader.getReferralNo():"")
							+ "\",\"coverNoteNo\":\""							
							+ (referralPatientHeader.getCovernoteNumber()!=null?referralPatientHeader.getCovernoteNumber():"")
							+ "\",\"coverNoteDate\":\""							
							+ (referralPatientHeader.getCovernoteDate()!=null?referralPatientHeader.getCovernoteDate():"")
							+ "\",\"adminBillAmt\":\""
							+ (referralPatientHeader.getAdminBillAmt()!=null?referralPatientHeader.getAdminBillAmt():"")
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}

					pw.write("{\"opdId\": \""
							+ referralPatientHeader.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)			
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"impanelledHospital\": \""
							+ (opdPatientDetails.getImpanneledHospital() != null ? opdPatientDetails.getImpanneledHospital().getImpanneledHospitalName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)
							+ "\",\"referralNo\":\""
							+ "\",\"referralNo\":\""							
							+ (referralPatientHeader.getReferralNo()!=null?referralPatientHeader.getReferralNo():"")
							+ "\",\"coverNoteNo\":\""							
							+ (referralPatientHeader.getCovernoteNumber()!=null?referralPatientHeader.getCovernoteNumber():"")
							+ "\",\"coverNoteDate\":\""							
							+ (referralPatientHeader.getCovernoteDate()!=null?referralPatientHeader.getCovernoteDate():"")
							+ "\",\"adminBillAmt\":\""
							+ (referralPatientHeader.getAdminBillAmt()!=null?referralPatientHeader.getAdminBillAmt():"")
							+ "\",\"totalRecords\":\"" + totalRecords + "\"}");
				}

				counter++;
				i++;
			}

			pw.write("]");

		}

		catch (Exception e) {
			referralPatientHeaderList.clear();

			e.printStackTrace();
		}
		referralPatientHeaderList.clear();
		return null;

	}
	public ModelAndView invoiceWaitingListForGM(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Box box = HMSUtil.getBox(request);
		Users user = (Users) session.getAttribute("users");		
		box.put("userId", user.getId());
		box.put("hospitalId", hospitalId);
		box.put("status", "WCB");
		map = referralHandlerService.getInvoiceWaitingFilterData(box);
		String jsp="invoiceWaitingListForGM";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView invoiceWaitingListForDeductionFS(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Box box = HMSUtil.getBox(request);
		Users user = (Users) session.getAttribute("users");		
		box.put("userId", user.getId());
		box.put("hospitalId", hospitalId);
		box.put("status", "WCB");		
		map = referralHandlerService.getInvoiceWaitingFilterData(box);
		String jsp="invoiceWaitingListForDeductionFS";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView getInvoiceWaitingListForGM(HttpServletRequest request,
			HttpServletResponse response)
	{
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();*/
		List<ReferralPatientHeader> referralPatientHeaderList = new ArrayList<ReferralPatientHeader>();
        Users user = (Users) session.getAttribute("users");		
		
		Box box = HMSUtil.getBox(request);
		box.put("userId", user.getId());

		box.put("hospitalId", hospitalId);

		String ExamType = "MedExam";
		box.put("ExamType", ExamType);
        
		map = referralHandlerService.getInvoiceWaitingListForGM(box);

		/*if (map.get("OpdPatientDetailsEmpanelledList") != null) {
			OpdPatientDetailsEmpanelledList = (ArrayList) map.get("OpdPatientDetailsEmpanelledList");
		}*/
		
		if (map.get("referralPatientHeaderList") != null) {
			referralPatientHeaderList = (ArrayList) map.get("referralPatientHeaderList");
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
			String treatmentType = "";

			for (ReferralPatientHeader referralPatientHeader : referralPatientHeaderList) {
				OpdPatientDetails opdPatientDetails = referralPatientHeader.getOpdPatientDetails();
				/*System.out.println("referralPatientHeader"+referralPatientHeader.getId());*/
				Patient list = new Patient();
				if(opdPatientDetails.getVisit()!=null)
				{
					list = opdPatientDetails.getVisit().getHin();
					referredFrom = opdPatientDetails.getVisit().getDepartment().getDepartmentName();
				}else
				{
					list = opdPatientDetails.getInpatient().getHin();
					referredFrom = opdPatientDetails.getInpatient().getDepartment().getDepartmentName();
				}
				if(opdPatientDetails.getReferralTreatmentType().equals("1"))
				{
					treatmentType = "OPD";
				}
				else
				{
					treatmentType = "Admission";
				}
				 
				if (counter != referralPatientHeaderList.size()) {
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}

					pw.write("{\"headerId\": \""
							+ referralPatientHeader.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)			
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"impanelledHospital\": \""
							+ (opdPatientDetails.getImpanneledHospital() != null ? opdPatientDetails.getImpanneledHospital().getImpanneledHospitalName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)	
							+ "\",\"referralNo\":\""													
							+ (referralPatientHeader.getReferralNo()!=null?referralPatientHeader.getReferralNo():"")
							+ "\",\"noteSheetNo\":\""							
							+ (referralPatientHeader.getNoteSheetNo()!=null?referralPatientHeader.getNoteSheetNo():"")
							+ "\",\"noteSheetDate\":\""							
							+ (referralPatientHeader.getNoteSheetDate()!=null?referralPatientHeader.getNoteSheetDate():"")
							+ "\",\"dispatchNo\":\""							
							+ (referralPatientHeader.getDispatchNumber()!=null?referralPatientHeader.getDispatchNumber():"")
							+ "\",\"dispatchDate\":\""							
							+ (referralPatientHeader.getDispatchDate()!=null?referralPatientHeader.getDispatchDate():"")
							+ "\",\"coverNoteNo\":\""							
							+ (referralPatientHeader.getCovernoteNumber()!=null?referralPatientHeader.getCovernoteNumber():"")
							+ "\",\"coverNoteDate\":\""							
							+ (referralPatientHeader.getCovernoteDate()!=null?referralPatientHeader.getCovernoteDate():"")
							+ "\",\"deduction\":\""							
							+ (referralPatientHeader.getDeductionFromSalary()!=null?referralPatientHeader.getDeductionFromSalary():"")
							+ "\",\"adminBillAmt\":\""
							+ (referralPatientHeader.getAdminBillAmt()!=null?referralPatientHeader.getAdminBillAmt():"")
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}

					pw.write("{\"headerId\": \""
							+ referralPatientHeader.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)			
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"impanelledHospital\": \""
							+ (opdPatientDetails.getImpanneledHospital() != null ? opdPatientDetails.getImpanneledHospital().getImpanneledHospitalName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)	
							+ "\",\"referralNo\":\""														
							+ (referralPatientHeader.getReferralNo()!=null?referralPatientHeader.getReferralNo():"")
							+ "\",\"noteSheetNo\":\""							
							+ (referralPatientHeader.getNoteSheetNo()!=null?referralPatientHeader.getNoteSheetNo():"")
							+ "\",\"noteSheetDate\":\""							
							+ (referralPatientHeader.getNoteSheetDate()!=null?referralPatientHeader.getNoteSheetDate():"")
							+ "\",\"dispatchNo\":\""							
							+ (referralPatientHeader.getDispatchNumber()!=null?referralPatientHeader.getDispatchNumber():"")
							+ "\",\"dispatchDate\":\""							
							+ (referralPatientHeader.getDispatchDate()!=null?referralPatientHeader.getDispatchDate():"")
							+ "\",\"coverNoteNo\":\""							
							+ (referralPatientHeader.getCovernoteNumber()!=null?referralPatientHeader.getCovernoteNumber():"")
							+ "\",\"coverNoteDate\":\""							
							+ (referralPatientHeader.getCovernoteDate()!=null?referralPatientHeader.getCovernoteDate():"")
							+ "\",\"deduction\":\""							
							+ (referralPatientHeader.getDeductionFromSalary()!=null?referralPatientHeader.getDeductionFromSalary():"")
							+ "\",\"adminBillAmt\":\""
							+ (referralPatientHeader.getAdminBillAmt()!=null?referralPatientHeader.getAdminBillAmt():"")
							+ "\",\"totalRecords\":\"" + totalRecords + "\"}");
				}

				counter++;
				i++;
			}

			pw.write("]");

		}

		catch (Exception e) {
			referralPatientHeaderList.clear();

			e.printStackTrace();
		}
		referralPatientHeaderList.clear();
		return null;

	}
	
	
	public ModelAndView invoiceWaitingListForNoteSheet(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = referralHandlerService.getInvoiceWaitingFilterData(box);
		String jsp="invoiceWaitingListForNoteSheet";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	
	public ModelAndView getInvoiceWaitingListForNoteSheet(HttpServletRequest request,
			HttpServletResponse response)
	{
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();*/
		List<ReferralPatientHeader> referralPatientHeaderList = new ArrayList<ReferralPatientHeader>();
        Users user = (Users) session.getAttribute("users");		
		
		Box box = HMSUtil.getBox(request);
		box.put("userId", user.getId());

		box.put("hospitalId", hospitalId);

		String ExamType = "MedExam";
		box.put("ExamType", ExamType);
        
		map = referralHandlerService.getInvoiceWaitingListForNoteSheet(box);

		/*if (map.get("OpdPatientDetailsEmpanelledList") != null) {
			OpdPatientDetailsEmpanelledList = (ArrayList) map.get("OpdPatientDetailsEmpanelledList");
		}*/
		
		if (map.get("referralPatientHeaderList") != null) {
			referralPatientHeaderList = (ArrayList) map.get("referralPatientHeaderList");
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
			String treatmentType = "";

			for (ReferralPatientHeader referralPatientHeader : referralPatientHeaderList) {
				OpdPatientDetails opdPatientDetails = referralPatientHeader.getOpdPatientDetails();
				Patient list = new Patient();
				if(opdPatientDetails.getVisit()!=null)
				{
					list = opdPatientDetails.getVisit().getHin();
					referredFrom = opdPatientDetails.getVisit().getDepartment().getDepartmentName();
				}else
				{
					list = opdPatientDetails.getInpatient().getHin();
					referredFrom = opdPatientDetails.getInpatient().getDepartment().getDepartmentName();
				}
				if(opdPatientDetails.getReferralTreatmentType().equals("1"))
				{
					treatmentType = "OPD";
				}
				else
				{
					treatmentType = "Admission";
				}
				 
				if (counter != referralPatientHeaderList.size()) {
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}

					pw.write("{\"headerId\": \""
							+ referralPatientHeader.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)	
							+ "\",\"deptNo\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDepartmentNo() : "")
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"impanelledHospital\": \""
							+ (opdPatientDetails.getImpanneledHospital() != null ? opdPatientDetails.getImpanneledHospital().getImpanneledHospitalName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)	
							+ "\",\"referralNo\":\""
							+ "\",\"referralNo\":\""							
							+ (referralPatientHeader.getReferralNo()!=null?referralPatientHeader.getReferralNo():"")
							+ "\",\"coverNoteNo\":\""							
							+ (referralPatientHeader.getCovernoteNumber()!=null?referralPatientHeader.getCovernoteNumber():"")
							+ "\",\"coverNoteDate\":\""							
							+ (referralPatientHeader.getCovernoteDate()!=null?referralPatientHeader.getCovernoteDate():"")
							+ "\",\"adminBillAmt\":\""
							+ (referralPatientHeader.getAdminBillAmt()!=null?referralPatientHeader.getAdminBillAmt():"")
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}

					pw.write("{\"headerId\": \""
							+ referralPatientHeader.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)	
							+ "\",\"deptNo\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDepartmentNo() : "")
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"impanelledHospital\": \""
							+ (opdPatientDetails.getImpanneledHospital() != null ? opdPatientDetails.getImpanneledHospital().getImpanneledHospitalName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)	
							+ "\",\"referralNo\":\""
							+ "\",\"referralNo\":\""							
							+ (referralPatientHeader.getReferralNo()!=null?referralPatientHeader.getReferralNo():"")
							+ "\",\"coverNoteNo\":\""							
							+ (referralPatientHeader.getCovernoteNumber()!=null?referralPatientHeader.getCovernoteNumber():"")
							+ "\",\"coverNoteDate\":\""							
							+ (referralPatientHeader.getCovernoteDate()!=null?referralPatientHeader.getCovernoteDate():"")
							+ "\",\"adminBillAmt\":\""
							+ (referralPatientHeader.getAdminBillAmt()!=null?referralPatientHeader.getAdminBillAmt():"")
							+ "\",\"totalRecords\":\"" + totalRecords + "\"}");
				}

				counter++;
				i++;
			}

			pw.write("]");

		}

		catch (Exception e) {
			referralPatientHeaderList.clear();

			e.printStackTrace();
		}
		referralPatientHeaderList.clear();
		return null;

	}
	
	
	public ModelAndView invoiceWaitingListForFA(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		 Users user = (Users) session.getAttribute("users");
		 int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			
			
			box.put("userId", user.getId());
			box.put("hospitalId", hospitalId);
			box.put("status", "WFA");
		map = referralHandlerService.getInvoiceWaitingFilterData(box);
		String jsp="invoiceWaitingListForFA";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	
	public ModelAndView notesheetReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		 Users user = (Users) session.getAttribute("users");
		 int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			
			
			box.put("userId", user.getId());
			box.put("hospitalId", hospitalId);
			box.put("status", "WFA");
		map = referralHandlerService.getInvoiceWaitingFilterDataForReports(box);
		String jsp="notesheetReport";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	
	
	
	public ModelAndView getInvoiceWaitingListForFA(HttpServletRequest request,
			HttpServletResponse response)
	{
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();*/
		List<ReferralPatientHeader> referralPatientHeaderList = new ArrayList<ReferralPatientHeader>();
        Users user = (Users) session.getAttribute("users");		
		
		Box box = HMSUtil.getBox(request);
		box.put("userId", user.getId());

		box.put("hospitalId", hospitalId);

		String ExamType = "MedExam";
		box.put("ExamType", ExamType);
        
		map = referralHandlerService.getInvoiceWaitingListForFA(box);

		/*if (map.get("OpdPatientDetailsEmpanelledList") != null) {
			OpdPatientDetailsEmpanelledList = (ArrayList) map.get("OpdPatientDetailsEmpanelledList");
		}*/
		
		if (map.get("referralPatientHeaderList") != null) {
			referralPatientHeaderList = (ArrayList) map.get("referralPatientHeaderList");
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
			String treatmentType = "";

			for (ReferralPatientHeader referralPatientHeader : referralPatientHeaderList) {
				OpdPatientDetails opdPatientDetails = referralPatientHeader.getOpdPatientDetails();
				Patient list = new Patient();
				if(opdPatientDetails.getVisit()!=null)
				{
					list = opdPatientDetails.getVisit().getHin();
					referredFrom = opdPatientDetails.getVisit().getDepartment().getDepartmentName();
				}else
				{
					list = opdPatientDetails.getInpatient().getHin();
					referredFrom = opdPatientDetails.getInpatient().getDepartment().getDepartmentName();
				}
				if(opdPatientDetails.getReferralTreatmentType().equals("1"))
				{
					treatmentType = "OPD";
				}
				else
				{
					treatmentType = "Admission";
				}
				 
				if (counter != referralPatientHeaderList.size()) {
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}

					pw.write("{\"headerId\": \""
							+ referralPatientHeader.getId()
							+ "\",\"noteSheetNo\": \""
							+ (referralPatientHeader.getNoteSheetNo() != null ? referralPatientHeader.getNoteSheetNo() 
									: "")
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)			
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"impanelledHospital\": \""
							+ (opdPatientDetails.getImpanneledHospital() != null ? opdPatientDetails.getImpanneledHospital().getImpanneledHospitalName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)	
							+ "\",\"referralNo\":\""
							+ "\",\"referralNo\":\""							
							+ (referralPatientHeader.getReferralNo()!=null?referralPatientHeader.getReferralNo():"")
							+ "\",\"coverNoteNo\":\""							
							+ (referralPatientHeader.getCovernoteNumber()!=null?referralPatientHeader.getCovernoteNumber():"")
							+ "\",\"coverNoteDate\":\""							
							+ (referralPatientHeader.getCovernoteDate()!=null?referralPatientHeader.getCovernoteDate():"")
								+ "\",\"noteSheetNo\":\""							
							+ (referralPatientHeader.getNoteSheetNo()!=null?referralPatientHeader.getNoteSheetNo():"")
							+ "\",\"noteSheetDate\":\""							
							+ (referralPatientHeader.getNoteSheetDate()!=null?referralPatientHeader.getNoteSheetDate():"")
							+ "\",\"adminBillAmt\":\""
							+ (referralPatientHeader.getAdminBillAmt()!=null?referralPatientHeader.getAdminBillAmt():"")
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}

					pw.write("{\"headerId\": \""
							+ referralPatientHeader.getId()
							+ "\",\"noteSheetNo\": \""
							+ (referralPatientHeader.getNoteSheetNo() != null ? referralPatientHeader.getNoteSheetNo() 
									: "")
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)			
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"impanelledHospital\": \""
							+ (opdPatientDetails.getImpanneledHospital() != null ? opdPatientDetails.getImpanneledHospital().getImpanneledHospitalName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)	
							+ "\",\"referralNo\":\""
							+ "\",\"referralNo\":\""							
							+ (referralPatientHeader.getReferralNo()!=null?referralPatientHeader.getReferralNo():"")
							+ "\",\"coverNoteNo\":\""							
							+ (referralPatientHeader.getCovernoteNumber()!=null?referralPatientHeader.getCovernoteNumber():"")
							+ "\",\"coverNoteDate\":\""							
							+ (referralPatientHeader.getCovernoteDate()!=null?referralPatientHeader.getCovernoteDate():"")
							+ "\",\"noteSheetNo\":\""							
							+ (referralPatientHeader.getNoteSheetNo()!=null?referralPatientHeader.getNoteSheetNo():"")
							+ "\",\"noteSheetDate\":\""							
							+ (referralPatientHeader.getNoteSheetDate()!=null?referralPatientHeader.getNoteSheetDate():"")
							+ "\",\"adminBillAmt\":\""
							+ (referralPatientHeader.getAdminBillAmt()!=null?referralPatientHeader.getAdminBillAmt():"")
							+ "\",\"totalRecords\":\"" + totalRecords + "\"}");
				}

				counter++;
				i++;
			}

			pw.write("]");

		}

		catch (Exception e) {
			referralPatientHeaderList.clear();

			e.printStackTrace();
		}
		referralPatientHeaderList.clear();
		return null;

	}
	
	public ModelAndView invoiceWaitingListForPFD(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		 Users user = (Users) session.getAttribute("users");
		 int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			
			
			box.put("userId", user.getId());
			box.put("hospitalId", hospitalId);
			box.put("status", "PFD");
		map = referralHandlerService.getInvoiceWaitingFilterDataPFD(box);
		String jsp="invoiceWaitingListForPFD";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	
	public ModelAndView getInvoiceWaitingListForPFD(HttpServletRequest request,
			HttpServletResponse response)
	{
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();*/
		List<ReferralPatientHeader> referralPatientHeaderList = new ArrayList<ReferralPatientHeader>();
        Users user = (Users) session.getAttribute("users");		
		
		Box box = HMSUtil.getBox(request);
		box.put("userId", user.getId());

		box.put("hospitalId", hospitalId);

		String ExamType = "MedExam";
		box.put("ExamType", ExamType);
        
		map = referralHandlerService.getInvoiceWaitingListForPFD(box);

		/*if (map.get("OpdPatientDetailsEmpanelledList") != null) {
			OpdPatientDetailsEmpanelledList = (ArrayList) map.get("OpdPatientDetailsEmpanelledList");
		}*/
		
		if (map.get("referralPatientHeaderList") != null) {
			referralPatientHeaderList = (ArrayList) map.get("referralPatientHeaderList");
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
			String treatmentType = "";

			for (ReferralPatientHeader referralPatientHeader : referralPatientHeaderList) {
				OpdPatientDetails opdPatientDetails = referralPatientHeader.getOpdPatientDetails();
				Patient list = new Patient();
				if(opdPatientDetails.getVisit()!=null)
				{
					list = opdPatientDetails.getVisit().getHin();
					referredFrom = opdPatientDetails.getVisit().getDepartment().getDepartmentName();
				}else
				{
					list = opdPatientDetails.getInpatient().getHin();
					referredFrom = opdPatientDetails.getInpatient().getDepartment().getDepartmentName();
				}
				if(opdPatientDetails.getReferralTreatmentType().equals("1"))
				{
					treatmentType = "OPD";
				}
				else
				{
					treatmentType = "Admission";
				}
				 
				if (counter != referralPatientHeaderList.size()) {
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}

					pw.write("{\"headerId\": \""
							+ referralPatientHeader.getId()
							+ "\",\"noteSheetNo\": \""
							+ (referralPatientHeader.getNoteSheetNo() != null ? referralPatientHeader.getNoteSheetNo() 
									: "")
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)			
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"impanelledHospital\": \""
							+ (opdPatientDetails.getImpanneledHospital() != null ? opdPatientDetails.getImpanneledHospital().getImpanneledHospitalName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)	
							+ "\",\"referralNo\":\""
							+ "\",\"referralNo\":\""							
							+ (referralPatientHeader.getReferralNo()!=null?referralPatientHeader.getReferralNo():"")
							+ "\",\"coverNoteNo\":\""							
							+ (referralPatientHeader.getCovernoteNumber()!=null?referralPatientHeader.getCovernoteNumber():"")
							+ "\",\"coverNoteDate\":\""							
							+ (referralPatientHeader.getCovernoteDate()!=null?referralPatientHeader.getCovernoteDate():"")
								+ "\",\"noteSheetNo\":\""							
							+ (referralPatientHeader.getNoteSheetNo()!=null?referralPatientHeader.getNoteSheetNo():"")
							+ "\",\"noteSheetDate\":\""							
							+ (referralPatientHeader.getNoteSheetDate()!=null?referralPatientHeader.getNoteSheetDate():"")
							+ "\",\"adminBillAmt\":\""
							+ (referralPatientHeader.getAdminBillAmt()!=null?referralPatientHeader.getAdminBillAmt():"")
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}

					pw.write("{\"headerId\": \""
							+ referralPatientHeader.getId()
							+ "\",\"noteSheetNo\": \""
							+ (referralPatientHeader.getNoteSheetNo() != null ? referralPatientHeader.getNoteSheetNo() 
									: "")
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)			
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"impanelledHospital\": \""
							+ (opdPatientDetails.getImpanneledHospital() != null ? opdPatientDetails.getImpanneledHospital().getImpanneledHospitalName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)	
							+ "\",\"referralNo\":\""
							+ "\",\"referralNo\":\""							
							+ (referralPatientHeader.getReferralNo()!=null?referralPatientHeader.getReferralNo():"")
							+ "\",\"coverNoteNo\":\""							
							+ (referralPatientHeader.getCovernoteNumber()!=null?referralPatientHeader.getCovernoteNumber():"")
							+ "\",\"coverNoteDate\":\""							
							+ (referralPatientHeader.getCovernoteDate()!=null?referralPatientHeader.getCovernoteDate():"")
							+ "\",\"noteSheetNo\":\""							
							+ (referralPatientHeader.getNoteSheetNo()!=null?referralPatientHeader.getNoteSheetNo():"")
							+ "\",\"noteSheetDate\":\""							
							+ (referralPatientHeader.getNoteSheetDate()!=null?referralPatientHeader.getNoteSheetDate():"")
							+ "\",\"adminBillAmt\":\""
							+ (referralPatientHeader.getAdminBillAmt()!=null?referralPatientHeader.getAdminBillAmt():"")
							+ "\",\"totalRecords\":\"" + totalRecords + "\"}");
				}

				counter++;
				i++;
			}

			pw.write("]");

		}

		catch (Exception e) {
			referralPatientHeaderList.clear();

			e.printStackTrace();
		}
		referralPatientHeaderList.clear();
		return null;

	}

	
	public ModelAndView invoiceWaitingListForAll(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		
		HttpSession session = request.getSession();
		 Users user = (Users) session.getAttribute("users");
		 int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("userId", user.getId());
		box.put("hospitalId", hospitalId);
		/*box.put("status", "WFA");*/
		map = referralHandlerService.getInvoiceWaitingFilterData(box);
	    map.putAll(referralHandlerService.getInvoiceWaitingFilterDataForReports(box));
		String jsp="invoiceWaitingListForAll";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView accountedAndUnaccountedBills(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		
		HttpSession session = request.getSession();
		 Users user = (Users) session.getAttribute("users");
		 int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("userId", user.getId());
		box.put("hospitalId", hospitalId);
		/*box.put("status", "WFA");*/
		map = referralHandlerService.getInvoiceWaitingFilterData(box);
	    map.putAll(referralHandlerService.accountedAndUnaccountedBills(box, response));
		/*String jsp="invoiceWaitingListForAll";*/
		/*jsp += ".jsp";
		map.put("contentJsp", jsp);*/
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView invoiceWaitingListForAllDashboard(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		
		HttpSession session = request.getSession();
		 Users user = (Users) session.getAttribute("users");
		 int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("userId", user.getId());
		box.put("hospitalId", hospitalId);
		/*box.put("status", "WFA");*/
		map = referralHandlerService.getInvoiceWaitingFilterData(box);
	    map.putAll(referralHandlerService.getInvoiceWaitingFilterDataForReports(box));
	    map.put("divisionId", box.getInt("divisionId"));
	    map.put("paymentStatus", box.getString("paymentStatus"));
	    map.put("message", box.getString("message"));
		String jsp="invoiceWaitingListForAllDashboard";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView referralDashboard(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		
		HttpSession session = request.getSession();
		 Users user = (Users) session.getAttribute("users");
		 int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("userId", user.getId());
		box.put("hospitalId", hospitalId);
		/*box.put("status", "WFA");*/
		map = referralHandlerService.getInvoiceWaitingFilterData(box);
	    map.putAll(referralHandlerService.getInvoiceWaitingFilterDataForReports(box));
		String jsp="referralDashboard";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView getInvoiceWaitingListForAll(HttpServletRequest request,
			HttpServletResponse response)
	{
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();*/
		List<ReferralPatientHeader> referralPatientHeaderList = new ArrayList<ReferralPatientHeader>();
		Box box = HMSUtil.getBox(request);

		box.put("hospitalId", hospitalId);

		String ExamType = "MedExam";
		box.put("ExamType", ExamType);
        
		map = referralHandlerService.getInvoiceWaitingListForAll(box);

		/*if (map.get("OpdPatientDetailsEmpanelledList") != null) {
			OpdPatientDetailsEmpanelledList = (ArrayList) map.get("OpdPatientDetailsEmpanelledList");
		}*/
		
		if (map.get("referralPatientHeaderList") != null) {
			referralPatientHeaderList = (ArrayList) map.get("referralPatientHeaderList");
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
			String treatmentType = "";
			String approvalStatus = "";

			for (ReferralPatientHeader referralPatientHeader : referralPatientHeaderList) {
				OpdPatientDetails opdPatientDetails = referralPatientHeader.getOpdPatientDetails();
				Patient list = new Patient();
				if(opdPatientDetails.getVisit()!=null)
				{
					list = opdPatientDetails.getVisit().getHin();
					referredFrom = opdPatientDetails.getVisit().getDepartment().getDepartmentName();
				}else
				{
					list = opdPatientDetails.getInpatient().getHin();
					referredFrom = opdPatientDetails.getInpatient().getDepartment().getDepartmentName();
				}
				if(opdPatientDetails.getReferralTreatmentType().equals("1"))
				{
					treatmentType = "OPD";
				}
				else
				{
					treatmentType = "Admission";
				}
				if(referralPatientHeader.getApprovalStatus()!=null)
				{
					if(referralPatientHeader.getApprovalStatus().equalsIgnoreCase("WA"))
					{
						approvalStatus="Waiting For Medical Approval";
					}	
					else if(referralPatientHeader.getApprovalStatus().equalsIgnoreCase("PFD"))
					{
						approvalStatus="Pending for Dispatch To Payable";
					}	
					else if(referralPatientHeader.getApprovalStatus().equalsIgnoreCase("WCB"))
					{
						approvalStatus="Waiting For Consolidation of Bills";
					}	
					else if(referralPatientHeader.getApprovalStatus().equalsIgnoreCase("WNS"))
					{
						approvalStatus="Waiting For NoteSheet Generation";
					}					
					else if(referralPatientHeader.getApprovalStatus().equalsIgnoreCase("WHD"))
					{
						approvalStatus="Waiting For HR Division Approval";
					}	
					else if(referralPatientHeader.getApprovalStatus().equalsIgnoreCase("WFA"))
					{
						approvalStatus="Waiting For Finance Audit Approval";
					}	
					else if(referralPatientHeader.getApprovalStatus().equalsIgnoreCase("FA"))
					{
						approvalStatus="Approved By Finance Audit";
					}
					else if(referralPatientHeader.getApprovalStatus().equalsIgnoreCase("DLG"))
					{
						approvalStatus="Divisional Approval Letter Generated";
					}
					else if(referralPatientHeader.getApprovalStatus().equalsIgnoreCase("RHD"))
					{
						approvalStatus="Rejected By HR Division";
					}
					else if(referralPatientHeader.getApprovalStatus().equalsIgnoreCase("RFA"))
					{
						approvalStatus="Rejected By Finance Audit";
					}
					else if(referralPatientHeader.getApprovalStatus().equalsIgnoreCase("C"))
					{
						approvalStatus="Complete";
					}
					
					else if(referralPatientHeader.getApprovalStatus().equalsIgnoreCase("CBG"))
					{
						approvalStatus="Waiting For Document Upload";
					}
					
					else
					{
						approvalStatus="";
					}
				}
				else
				{
					approvalStatus="";
				}
					
				
				 
				if (counter != referralPatientHeaderList.size()) { 
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}

					pw.write("{\"opdId\": \""
							+ referralPatientHeader.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)			
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"impanelledHospital\": \""
							+ (opdPatientDetails.getImpanneledHospital() != null ? opdPatientDetails.getImpanneledHospital().getImpanneledHospitalName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)	
							+ "\",\"approvalStatus\":\""
							+ (approvalStatus)	
							+ "\",\"approvalStatusCode\":\""
							+ (referralPatientHeader.getApprovalStatus()!=null?referralPatientHeader.getApprovalStatus():"")
							+ "\",\"referralNo\":\""													
							+ (referralPatientHeader.getReferralNo()!=null?referralPatientHeader.getReferralNo():"")
							+ "\",\"noteSheetNo\":\""							
							+ (referralPatientHeader.getNoteSheetNo()!=null?referralPatientHeader.getNoteSheetNo():"")
							+ "\",\"noteSheetDate\":\""							
							+ (referralPatientHeader.getNoteSheetDate()!=null?referralPatientHeader.getNoteSheetDate():"")
							+ "\",\"dispatchNo\":\""							
							+ (referralPatientHeader.getDispatchNumber()!=null?referralPatientHeader.getDispatchNumber():"")
							+ "\",\"dispatchDate\":\""							
							+ (referralPatientHeader.getDispatchDate()!=null?referralPatientHeader.getDispatchDate():"")
							+ "\",\"coverNoteNo\":\""							
							+ (referralPatientHeader.getCovernoteNumber()!=null?referralPatientHeader.getCovernoteNumber():"")
							+ "\",\"coverNoteDate\":\""							
							+ (referralPatientHeader.getCovernoteDate()!=null?referralPatientHeader.getCovernoteDate():"")
							+ "\",\"adminBillAmt\":\""
							+ (referralPatientHeader.getAdminBillAmt()!=null?referralPatientHeader.getAdminBillAmt():"")
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}

					pw.write("{\"opdId\": \""
							+ referralPatientHeader.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)			
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"impanelledHospital\": \""
							+ (opdPatientDetails.getImpanneledHospital() != null ? opdPatientDetails.getImpanneledHospital().getImpanneledHospitalName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
							+ "\",\"HIN\": \""
							+ (list.getHinNo() != null ? list.getHinNo() : "")
							+ "\",\"gender\": \""
							+ (list.getSex() != null ? list.getSex()
									.getAdministrativeSexName() : "")
							+ "\",\"name\": \""
							+ servicepatientName
							+ "\",\"approvalStatus\":\""
							+ (approvalStatus)	
							+ "\",\"approvalStatusCode\":\""
							+ (referralPatientHeader.getApprovalStatus()!=null?referralPatientHeader.getApprovalStatus():"")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)	
							+ "\",\"referralNo\":\""							
							+ (referralPatientHeader.getReferralNo()!=null?referralPatientHeader.getReferralNo():"")
							+ "\",\"noteSheetNo\":\""							
							+ (referralPatientHeader.getNoteSheetNo()!=null?referralPatientHeader.getNoteSheetNo():"")
							+ "\",\"noteSheetDate\":\""							
							+ (referralPatientHeader.getNoteSheetDate()!=null?referralPatientHeader.getNoteSheetDate():"")
							+ "\",\"dispatchNo\":\""							
							+ (referralPatientHeader.getDispatchNumber()!=null?referralPatientHeader.getDispatchNumber():"")
							+ "\",\"dispatchDate\":\""							
							+ (referralPatientHeader.getDispatchDate()!=null?referralPatientHeader.getDispatchDate():"")
							+ "\",\"coverNoteNo\":\""							
							+ (referralPatientHeader.getCovernoteNumber()!=null?referralPatientHeader.getCovernoteNumber():"")
							+ "\",\"coverNoteDate\":\""							
							+ (referralPatientHeader.getCovernoteDate()!=null?referralPatientHeader.getCovernoteDate():"")
							+ "\",\"adminBillAmt\":\""
							+ (referralPatientHeader.getAdminBillAmt()!=null?referralPatientHeader.getAdminBillAmt():"")
							+ "\",\"totalRecords\":\"" + totalRecords + "\"}");
				}

				counter++;
				i++;
			}

			pw.write("]");

		}

		catch (Exception e) {
			referralPatientHeaderList.clear();

			e.printStackTrace();
		}
		referralPatientHeaderList.clear();
		return null;

	}
	
	public ModelAndView getReferralDashboardData(HttpServletRequest request,
			HttpServletResponse response)
	{
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		List<Object[]> dashboardData = new ArrayList<Object[]>();
		Box box = HMSUtil.getBox(request);

		box.put("hospitalId", hospitalId);

		String ExamType = "MedExam";
		box.put("ExamType", ExamType);
        
		map = referralHandlerService.getReferralDashboardData(box);

		/*if (map.get("OpdPatientDetailsEmpanelledList") != null) {
			OpdPatientDetailsEmpanelledList = (ArrayList) map.get("OpdPatientDetailsEmpanelledList");
		}*/
		
		if (map.get("dashboardData") != null) {
			dashboardData = (ArrayList) map.get("dashboardData");
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
			String treatmentType = "";
			String approvalStatus = "";

			for (Object[] divisionData : dashboardData) {
			
				if (counter != dashboardData.size()) {
				
					pw.write("{\"divisionId\": \""
							+ divisionData[0]
							+ "\",\"divisionName\": \""
							+ divisionData[1]
							+ "\",\"accountedReferral\": \""
							+ divisionData[2]
							+ "\",\"accountedBills\": \""
							+ divisionData[3]	
							+ "\",\"unAccountedReferral\": \""
							+ divisionData[4]											
							+ "\",\"unAccountedBills\": \""
							+ divisionData[5]							
							+ "\",\"totalRecords\":\"" + totalRecords + "\"},");

				} else {
					
					pw.write("{\"divisionId\": \""
							+ divisionData[0]
							+ "\",\"divisionName\": \""
							+ divisionData[1]
							+ "\",\"accountedReferral\": \""
							+ divisionData[2]
							+ "\",\"accountedBills\": \""
							+ divisionData[3]	
							+ "\",\"unAccountedReferral\": \""
							+ divisionData[4]											
							+ "\",\"unAccountedBills\": \""
							+ divisionData[5]							
							+ "\",\"totalRecords\":\"" + totalRecords + "\"}");

				}

				counter++;
				i++;
			}

			pw.write("]");

		}

		catch (Exception e) {
			dashboardData.clear();

			e.printStackTrace();
		}
		dashboardData.clear();
		return null;

	}
	
	
	public ModelAndView waitingListForReferralExtension(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		/*map = referralHandlerService.showTherapyTypeJsp();*/
		String jsp="waitingListForReferralExtension";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	
	public ModelAndView getWaitingListForReferralExtension(HttpServletRequest request,
			HttpServletResponse response)
	{
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();*/
		List<ReferralPatientHeader> referralPatientHeaderList = new ArrayList<ReferralPatientHeader>();
		Users user = (Users) session.getAttribute("users");		
		
		Box box = HMSUtil.getBox(request);
		box.put("userId", user.getId());

		box.put("hospitalId", hospitalId);

		String ExamType = "MedExam";
		box.put("ExamType", ExamType);
        
		map = referralHandlerService.getWaitingListForReferralExtension(box);

		/*if (map.get("OpdPatientDetailsEmpanelledList") != null) {
			OpdPatientDetailsEmpanelledList = (ArrayList) map.get("OpdPatientDetailsEmpanelledList");
		}*/
		
		if (map.get("referralPatientHeaderList") != null) {
			referralPatientHeaderList = (ArrayList) map.get("referralPatientHeaderList");
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
			String treatmentType = "";
			String approvalStatus = "";

			for (ReferralPatientHeader referralPatientHeader : referralPatientHeaderList) {
				OpdPatientDetails opdPatientDetails = referralPatientHeader.getOpdPatientDetails();
				Patient list = new Patient();
				if(opdPatientDetails.getVisit()!=null)
				{
					list = opdPatientDetails.getVisit().getHin();
					referredFrom = opdPatientDetails.getVisit().getDepartment().getDepartmentName();
				}else
				{
					list = opdPatientDetails.getInpatient().getHin();
					referredFrom = opdPatientDetails.getInpatient().getDepartment().getDepartmentName();
				}
				if(opdPatientDetails.getReferralTreatmentType().equals("1"))
				{
					treatmentType = "OPD";
				}
				else
				{
					treatmentType = "Admission";
				}
				if(referralPatientHeader.getApprovalStatus()!=null)
				{
					if(referralPatientHeader.getApprovalStatus().equalsIgnoreCase("WA"))
					{
						approvalStatus="Waiting For Admin Approval";
					}	
					else if(referralPatientHeader.getApprovalStatus().equalsIgnoreCase("WHD"))
					{
						approvalStatus="Waiting For HR Division Approval";
					}	
					else if(referralPatientHeader.getApprovalStatus().equalsIgnoreCase("WFD"))
					{
						approvalStatus="Waiting For Finance Division Approval";
					}	
					else if(referralPatientHeader.getApprovalStatus().equalsIgnoreCase("WGM"))
					{
						approvalStatus="Waiting For GM Approval";
					}
					else if(referralPatientHeader.getApprovalStatus().equalsIgnoreCase("GMA"))
					{
						approvalStatus="Approved";
					}
					else
					{
						approvalStatus="";
					}
				}
				else
				{
					approvalStatus="Waiting For Document Upload";
				}
					
				
				 
				if (counter != referralPatientHeaderList.size()) {
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}

					pw.write("{\"opdId\": \""
							+ opdPatientDetails.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)			
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"impanelledHospital\": \""
							+ (opdPatientDetails.getImpanneledHospital() != null ? opdPatientDetails.getImpanneledHospital().getImpanneledHospitalName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)	
							+ "\",\"approvalStatus\":\""
							+ (approvalStatus)	
							+ "\",\"referralNo\":\""
							+ "\",\"referralNo\":\""							
							+ (referralPatientHeader.getReferralNo()!=null?referralPatientHeader.getReferralNo():"")
							+ "\",\"coverNoteNo\":\""							
							+ (referralPatientHeader.getCovernoteNumber()!=null?referralPatientHeader.getCovernoteNumber():"")
							+ "\",\"coverNoteDate\":\""							
							+ (referralPatientHeader.getCovernoteDate()!=null?referralPatientHeader.getCovernoteDate():"")
							+ "\",\"adminBillAmt\":\""
							+ (referralPatientHeader.getAdminBillAmt()!=null?referralPatientHeader.getAdminBillAmt():"")
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}

					pw.write("{\"opdId\": \""
							+ opdPatientDetails.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)			
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"impanelledHospital\": \""
							+ (opdPatientDetails.getImpanneledHospital() != null ? opdPatientDetails.getImpanneledHospital().getImpanneledHospitalName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
							+ "\",\"HIN\": \""
							+ (list.getHinNo() != null ? list.getHinNo() : "")
							+ "\",\"gender\": \""
							+ (list.getSex() != null ? list.getSex()
									.getAdministrativeSexName() : "")
							+ "\",\"name\": \""
							+ servicepatientName
							+ "\",\"approvalStatus\":\""
							+ (approvalStatus)	
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)	
							+ "\",\"referralNo\":\""							
							+ (referralPatientHeader.getReferralNo()!=null?referralPatientHeader.getReferralNo():"")
							+ "\",\"coverNoteNo\":\""							
							+ (referralPatientHeader.getCovernoteNumber()!=null?referralPatientHeader.getCovernoteNumber():"")
							+ "\",\"coverNoteDate\":\""							
							+ (referralPatientHeader.getCovernoteDate()!=null?referralPatientHeader.getCovernoteDate():"")
							+ "\",\"adminBillAmt\":\""
							+ (referralPatientHeader.getAdminBillAmt()!=null?referralPatientHeader.getAdminBillAmt():"")
							+ "\",\"totalRecords\":\"" + totalRecords + "\"}");
				}

				counter++;
				i++;
			}

			pw.write("]");

		}

		catch (Exception e) {
			referralPatientHeaderList.clear();

			e.printStackTrace();
		}
		referralPatientHeaderList.clear();
		return null;

	}
	
	public ModelAndView invoiceWaitingList(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = referralHandlerService.getInvoiceWaitingFilterData(box);
		String jsp="invoiceWaitingList";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView invoiceWaitingListRejected(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = referralHandlerService.getInvoiceWaitingFilterData(box);
		String jsp="invoiceWaitingListRejected";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView invoiceWaitingListAlreadySend(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = referralHandlerService.getInvoiceWaitingFilterData(box);
		String jsp="invoiceWaitingListAlreadySend";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView getInvoiceWaitingList(HttpServletRequest request,
			HttpServletResponse response)
	{
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();*/
		List<ReferralPatientHeader> referralPatientHeaderList = new ArrayList<ReferralPatientHeader>();
		/*Set opdSet = new HashSet();*/
		Box box = HMSUtil.getBox(request);

		box.put("hospitalId", hospitalId);

		
        
		map = referralHandlerService.getInvoiceWaitingList(box);

		/*if (map.get("OpdPatientDetailsEmpanelledList") != null) {
			OpdPatientDetailsEmpanelledList = (ArrayList) map.get("OpdPatientDetailsEmpanelledList");
		}*/
		
		if (map.get("referralPatientHeaderList") != null) {
			referralPatientHeaderList = (ArrayList) map.get("referralPatientHeaderList");
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
			String treatmentType = "";
            
			for (ReferralPatientHeader referralPatientHeader : referralPatientHeaderList) {
				OpdPatientDetails opdPatientDetails = referralPatientHeader.getOpdPatientDetails();
				/*if(opdSet.add(opdPatientDetails.getId())){*/
				Patient list = new Patient();
				if(opdPatientDetails.getVisit()!=null)
				{
					list = opdPatientDetails.getVisit().getHin();
					referredFrom = opdPatientDetails.getVisit().getDepartment().getDepartmentName();
				}else
				{
					list = opdPatientDetails.getInpatient().getHin();
					referredFrom = opdPatientDetails.getInpatient().getDepartment().getDepartmentName();
				}
				if(opdPatientDetails.getReferralTreatmentType().equals("1"))
				{
					treatmentType = "OPD";
				}
				else
				{
					treatmentType = "Admission";
				}
				 
				if (counter != referralPatientHeaderList.size()) {
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}

					pw.write("{\"opdId\": \""
							+ referralPatientHeader.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)	
							+ "\",\"headerId\": \""
							+ (referralPatientHeader.getId())	
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"impanelledHospital\": \""
							+ (opdPatientDetails.getImpanneledHospital() != null ? opdPatientDetails.getImpanneledHospital().getImpanneledHospitalName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
							+ "\",\"HIN\": \""
							+ (list.getHinNo() != null ? list.getHinNo() : "")
							+ "\",\"gender\": \""
							+ (list.getSex() != null ? list.getSex()
									.getAdministrativeSexName() : "")
							+ "\",\"name\": \""
							+ servicepatientName
							
							+ "\",\"approvalStatusCode\":\""
							+ (referralPatientHeader.getApprovalStatus()!=null?referralPatientHeader.getApprovalStatus():"")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)
							+ "\",\"referralNo\":\""
							+ (referralPatientHeader.getReferralNo())	
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}

					pw.write("{\"opdId\": \""
							+ referralPatientHeader.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)			
							+ "\",\"headerId\": \""
							+ (referralPatientHeader.getId())	
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"impanelledHospital\": \""
							+ (opdPatientDetails.getImpanneledHospital() != null ? opdPatientDetails.getImpanneledHospital().getImpanneledHospitalName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
							+ "\",\"HIN\": \""
							+ (list.getHinNo() != null ? list.getHinNo() : "")
							+ "\",\"gender\": \""
							+ (list.getSex() != null ? list.getSex()
									.getAdministrativeSexName() : "")
							+ "\",\"name\": \""
							+ servicepatientName
							
							+ "\",\"approvalStatusCode\":\""
							+ (referralPatientHeader.getApprovalStatus()!=null?referralPatientHeader.getApprovalStatus():"")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)
							+ "\",\"referralNo\":\""
							+ (referralPatientHeader.getReferralNo())	
							+ "\",\"totalRecords\":\"" + totalRecords + "\"}");
				}
				i++;
			/*}*/
				
				counter++;
				
			}
			
			System.out.println("counter"+counter);

			pw.write("]");

		}

		catch (Exception e) {
			referralPatientHeaderList.clear();

			e.printStackTrace();
		}
		referralPatientHeaderList.clear();
		return null;

	}
	
	public ModelAndView getInvoiceWaitingListRejected(HttpServletRequest request,
			HttpServletResponse response)
	{
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();*/
		List<ReferralPatientHeader> referralPatientHeaderList = new ArrayList<ReferralPatientHeader>();
		/*Set opdSet = new HashSet();*/
		Box box = HMSUtil.getBox(request);

		box.put("hospitalId", hospitalId);

		
        
		map = referralHandlerService.getInvoiceWaitingListRejected(box);

		/*if (map.get("OpdPatientDetailsEmpanelledList") != null) {
			OpdPatientDetailsEmpanelledList = (ArrayList) map.get("OpdPatientDetailsEmpanelledList");
		}*/
		
		if (map.get("referralPatientHeaderList") != null) {
			referralPatientHeaderList = (ArrayList) map.get("referralPatientHeaderList");
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
			String treatmentType = "";
            
			for (ReferralPatientHeader referralPatientHeader : referralPatientHeaderList) {
				OpdPatientDetails opdPatientDetails = referralPatientHeader.getOpdPatientDetails();
				/*if(opdSet.add(opdPatientDetails.getId())){*/
				Patient list = new Patient();
				if(opdPatientDetails.getVisit()!=null)
				{
					list = opdPatientDetails.getVisit().getHin();
					referredFrom = opdPatientDetails.getVisit().getDepartment().getDepartmentName();
				}else
				{
					list = opdPatientDetails.getInpatient().getHin();
					referredFrom = opdPatientDetails.getInpatient().getDepartment().getDepartmentName();
				}
				if(opdPatientDetails.getReferralTreatmentType().equals("1"))
				{
					treatmentType = "OPD";
				}
				else
				{
					treatmentType = "Admission";
				}
				 
				if (counter != referralPatientHeaderList.size()) {
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}

					pw.write("{\"opdId\": \""
							+ referralPatientHeader.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)	
							+ "\",\"headerId\": \""
							+ (referralPatientHeader.getId())	
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"impanelledHospital\": \""
							+ (opdPatientDetails.getImpanneledHospital() != null ? opdPatientDetails.getImpanneledHospital().getImpanneledHospitalName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
							+ "\",\"HIN\": \""
							+ (list.getHinNo() != null ? list.getHinNo() : "")
							+ "\",\"gender\": \""
							+ (list.getSex() != null ? list.getSex()
									.getAdministrativeSexName() : "")
							+ "\",\"name\": \""
							+ servicepatientName
							
							+ "\",\"approvalStatusCode\":\""
							+ (referralPatientHeader.getApprovalStatus()!=null?referralPatientHeader.getApprovalStatus():"")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)
							+ "\",\"referralNo\":\""
							+ (referralPatientHeader.getReferralNo())	
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}

					pw.write("{\"opdId\": \""
							+ referralPatientHeader.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)			
							+ "\",\"headerId\": \""
							+ (referralPatientHeader.getId())	
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"impanelledHospital\": \""
							+ (opdPatientDetails.getImpanneledHospital() != null ? opdPatientDetails.getImpanneledHospital().getImpanneledHospitalName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
							+ "\",\"HIN\": \""
							+ (list.getHinNo() != null ? list.getHinNo() : "")
							+ "\",\"gender\": \""
							+ (list.getSex() != null ? list.getSex()
									.getAdministrativeSexName() : "")
							+ "\",\"name\": \""
							+ servicepatientName
							
							+ "\",\"approvalStatusCode\":\""
							+ (referralPatientHeader.getApprovalStatus()!=null?referralPatientHeader.getApprovalStatus():"")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)
							+ "\",\"referralNo\":\""
							+ (referralPatientHeader.getReferralNo())	
							+ "\",\"totalRecords\":\"" + totalRecords + "\"}");
				}
				i++;
			/*}*/
				
				counter++;
				
			}
			
			System.out.println("counter"+counter);

			pw.write("]");

		}

		catch (Exception e) {
			referralPatientHeaderList.clear();

			e.printStackTrace();
		}
		referralPatientHeaderList.clear();
		return null;

	}
	
	public ModelAndView getInvoiceWaitingListAlreadySend(HttpServletRequest request,
			HttpServletResponse response)
	{
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();*/
		List<ReferralPatientHeader> referralPatientHeaderList = new ArrayList<ReferralPatientHeader>();
		/*Set opdSet = new HashSet();*/
		Box box = HMSUtil.getBox(request);

		box.put("hospitalId", hospitalId);

		
        
		map = referralHandlerService.getInvoiceWaitingListAlreadySend(box);

		/*if (map.get("OpdPatientDetailsEmpanelledList") != null) {
			OpdPatientDetailsEmpanelledList = (ArrayList) map.get("OpdPatientDetailsEmpanelledList");
		}*/
		
		if (map.get("referralPatientHeaderList") != null) {
			referralPatientHeaderList = (ArrayList) map.get("referralPatientHeaderList");
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
			String treatmentType = "";
            
			for (ReferralPatientHeader referralPatientHeader : referralPatientHeaderList) {
				OpdPatientDetails opdPatientDetails = referralPatientHeader.getOpdPatientDetails();
				/*if(opdSet.add(opdPatientDetails.getId())){*/
				Patient list = new Patient();
				if(opdPatientDetails.getVisit()!=null)
				{
					list = opdPatientDetails.getVisit().getHin();
					referredFrom = opdPatientDetails.getVisit().getDepartment().getDepartmentName();
				}else
				{
					list = opdPatientDetails.getInpatient().getHin();
					referredFrom = opdPatientDetails.getInpatient().getDepartment().getDepartmentName();
				}
				if(opdPatientDetails.getReferralTreatmentType().equals("1"))
				{
					treatmentType = "OPD";
				}
				else
				{
					treatmentType = "Admission";
				}
				 
				if (counter != referralPatientHeaderList.size()) {
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}

					pw.write("{\"opdId\": \""
							+ referralPatientHeader.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)	
							+ "\",\"headerId\": \""
							+ (referralPatientHeader.getId())	
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"impanelledHospital\": \""
							+ (opdPatientDetails.getImpanneledHospital() != null ? opdPatientDetails.getImpanneledHospital().getImpanneledHospitalName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
							+ "\",\"HIN\": \""
							+ (list.getHinNo() != null ? list.getHinNo() : "")
							+ "\",\"gender\": \""
							+ (list.getSex() != null ? list.getSex()
									.getAdministrativeSexName() : "")
							+ "\",\"name\": \""
							+ servicepatientName
							
							+ "\",\"approvalStatusCode\":\""
							+ (referralPatientHeader.getApprovalStatus()!=null?referralPatientHeader.getApprovalStatus():"")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)
							+ "\",\"referralNo\":\""
							+ (referralPatientHeader.getReferralNo())	
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}

					pw.write("{\"opdId\": \""
							+ referralPatientHeader.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)			
							+ "\",\"headerId\": \""
							+ (referralPatientHeader.getId())	
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"impanelledHospital\": \""
							+ (opdPatientDetails.getImpanneledHospital() != null ? opdPatientDetails.getImpanneledHospital().getImpanneledHospitalName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
							+ "\",\"HIN\": \""
							+ (list.getHinNo() != null ? list.getHinNo() : "")
							+ "\",\"gender\": \""
							+ (list.getSex() != null ? list.getSex()
									.getAdministrativeSexName() : "")
							+ "\",\"name\": \""
							+ servicepatientName
							
							+ "\",\"approvalStatusCode\":\""
							+ (referralPatientHeader.getApprovalStatus()!=null?referralPatientHeader.getApprovalStatus():"")
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
							+ "\",\"treatmentType\":\""
							+ (treatmentType)
							+ "\",\"referralNo\":\""
							+ (referralPatientHeader.getReferralNo())	
							+ "\",\"totalRecords\":\"" + totalRecords + "\"}");
				}
				i++;
			/*}*/
				
				counter++;
				
			}
			
			System.out.println("counter"+counter);

			pw.write("]");

		}

		catch (Exception e) {
			referralPatientHeaderList.clear();

			e.printStackTrace();
		}
		referralPatientHeaderList.clear();
		return null;

	}
	
	public ModelAndView generateReferralLetterPage(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String jsp ="";
		String title ="";
		map = referralHandlerService.generateReferralLetterPage(box);
		Map<String, Object> detailsMap = new HashMap<String, Object>();		
		if(detailsMap.get("diagnosisList")!=null){
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		if(detailsMap.get("disabilityList")!=null){
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}
		jsp = "generateReferralLetterPage.jsp";

		title = "Patient Detail";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView generateExtensionLetterPage(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String jsp ="";
		String title ="";
		map = referralHandlerService.generateExtensionLetterPage(box);
		Map<String, Object> detailsMap = new HashMap<String, Object>();		
		if(detailsMap.get("diagnosisList")!=null){
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		if(detailsMap.get("disabilityList")!=null){
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}
		jsp = "generateExtensionLetterPage.jsp";

		title = "Patient Detail";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView generateInvoicePage(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String jsp ="";
		String title ="";
		map = referralHandlerService.generateInvoicePage(box);
		/*Map<String, Object> detailsMap = new HashMap<String, Object>();		
		if(detailsMap.get("diagnosisList")!=null){
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		if(detailsMap.get("disabilityList")!=null){
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}*/
		jsp = "generateInvoicePage.jsp";

		title = "Patient Detail";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView generateInvoicePageAlreadySend(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String jsp ="";
		String title ="";
		map = referralHandlerService.generateInvoicePageAlreadySend(box);
		/*Map<String, Object> detailsMap = new HashMap<String, Object>();		
		if(detailsMap.get("diagnosisList")!=null){
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		if(detailsMap.get("disabilityList")!=null){
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}*/
		jsp = "generateInvoicePageAlreadySend.jsp";

		title = "Patient Detail";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView generateExcelWaitingPage(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String jsp ="";
		String title ="";
		map = referralHandlerService.generateInvoicePage(box);
		/*Map<String, Object> detailsMap = new HashMap<String, Object>();		
		if(detailsMap.get("diagnosisList")!=null){
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		if(detailsMap.get("disabilityList")!=null){
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}*/
		jsp = "generateExcelWaitingPage.jsp";

		title = "Patient Detail";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView generateInvoicePageForHRDivision(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String jsp ="";
		String title ="";
		map = referralHandlerService.generateInvoicePageForHRDivision(box);
		/*Map<String, Object> detailsMap = new HashMap<String, Object>();		
		if(detailsMap.get("diagnosisList")!=null){
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		if(detailsMap.get("disabilityList")!=null){
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}*/
		jsp = "generateInvoicePageForHRDivision.jsp";

		title = "Patient Detail";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView generateInvoicePageForFinanceDivision(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String jsp ="";
		String title ="";
		map = referralHandlerService.generateInvoicePageForFinanceDivision(box);
		/*Map<String, Object> detailsMap = new HashMap<String, Object>();		
		if(detailsMap.get("diagnosisList")!=null){
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		if(detailsMap.get("disabilityList")!=null){
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}*/
		jsp = "generateInvoicePageForFinanceDivision.jsp";

		title = "Patient Detail";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView generateInvoicePageForGM(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String jsp ="";
		String title ="";
		map = referralHandlerService.generateInvoicePageForGM(box);
		/*Map<String, Object> detailsMap = new HashMap<String, Object>();		
		if(detailsMap.get("diagnosisList")!=null){
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		if(detailsMap.get("disabilityList")!=null){
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}*/
		jsp = "generateInvoicePageForGM.jsp";

		title = "Patient Detail";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView generateInvoicePageForAll(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String jsp ="";
		String title ="";
		map = referralHandlerService.generateInvoicePageForAll(box);
		/*Map<String, Object> detailsMap = new HashMap<String, Object>();		
		if(detailsMap.get("diagnosisList")!=null){
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		if(detailsMap.get("disabilityList")!=null){
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}*/
		jsp = "generateInvoicePageForAll.jsp";

		title = "Patient Detail";
		map.put("deducted", box.getString("deducted"));
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView generateInvoicePageForExtension(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String jsp ="";
		String title ="";
		map = referralHandlerService.generateInvoicePageForExtention(box);
		/*Map<String, Object> detailsMap = new HashMap<String, Object>();		
		if(detailsMap.get("diagnosisList")!=null){
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		if(detailsMap.get("disabilityList")!=null){
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}*/
		jsp = "generateInvoicePageForExtension.jsp";

		title = "Patient Detail";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	
	
	
	
	
	
	public ModelAndView excelWaitingList(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		/*map = referralHandlerService.showTherapyTypeJsp();*/
		String jsp="excelWaitingList";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView erpUpload(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		/*map = referralHandlerService.showTherapyTypeJsp();*/
		String jsp="erpUpload";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView erpUploadTemp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		/*map = referralHandlerService.showTherapyTypeJsp();*/
		String jsp="erpUploadTemp";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView getExcelWaitingList(HttpServletRequest request,
			HttpServletResponse response)
	{
		System.out.println("Hi=========================");
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		List<ReferralPatientHeader> referralPatientHeaderList = new ArrayList<ReferralPatientHeader>();
		Box box = HMSUtil.getBox(request);

		box.put("hospitalId", hospitalId);

		String ExamType = "MedExam";
		box.put("ExamType", ExamType);
        
		map = referralHandlerService.getExcelWaitingList(box);

		if (map.get("referralPatientHeaderList") != null) {
			referralPatientHeaderList = (ArrayList) map.get("referralPatientHeaderList");
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
			String servicepatientName = "";
			String referredBy = "";
			String excelStatus = "";
			String treatmentType = "";

			for (ReferralPatientHeader referralPatientHeader : referralPatientHeaderList) {
				OpdPatientDetails opdPatientDetails = referralPatientHeader.getOpdPatientDetails();
				Patient list = new Patient();
				if(opdPatientDetails.getVisit()!=null)
				{
					list = opdPatientDetails.getVisit().getHin();
					referredFrom = opdPatientDetails.getVisit().getDepartment().getDepartmentName();
				}else
				{
					list = opdPatientDetails.getInpatient().getHin();
					referredFrom = opdPatientDetails.getInpatient().getDepartment().getDepartmentName();
				}
				if(opdPatientDetails.getReferralTreatmentType().equals("1"))
				{
					treatmentType = "OPD";
				}
				else
				{
					treatmentType = "Admission";
				}
				 
				if (counter != referralPatientHeaderList.size()) {
					servicepatientName = "";
					referredBy = "";
					excelStatus = "";
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}
					if(referralPatientHeader.getExcelStatus().equals("EG"))
					{
						excelStatus = "Generated";
					}
					else 
					{
						excelStatus = "Not Generated";
					}

					pw.write("{\"opdId\": \""
							+ opdPatientDetails.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)			
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
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
							+ "\",\"excelStatus\":\""
							+ (excelStatus)	
							+ "\",\"treatmentType\":\""
							+ (treatmentType)	
							+ "\",\"referralNo\":\""
							+ (referralPatientHeader.getReferralNo())	
							+ "\",\"relation\":\""
							+ (list.getRelation() != null ? list
									.getRelation().getRelationName() : "")						
							+ "\",\"totalRecords\":\"" + totalRecords + "\"},");

				} else {
					servicepatientName = "";
					referredBy = "";
					excelStatus= "";
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
					if (opdPatientDetails.getEmployee().getFirstName() != null) {
						referredBy = opdPatientDetails.getEmployee().getFirstName();
					}

					if (opdPatientDetails.getEmployee().getMiddleName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getMiddleName();
					}
					if (opdPatientDetails.getEmployee().getLastName() != null) {
						referredBy = referredBy + " "
								+ opdPatientDetails.getEmployee().getLastName();
					}
					if(referralPatientHeader.getExcelStatus().equals("EG"))
					{
						excelStatus = "Generated";
					}
					else 
					{
						excelStatus = "Not Generated";
					}

					pw.write("{\"opdId\": \""
							+ opdPatientDetails.getId()
							+ "\",\"referredDate\": \""
							+ (opdPatientDetails.getReferredDate() != null ? HMSUtil
									.changeDateToddMMyyyy(opdPatientDetails.getReferredDate())
									: "")
							+ "\",\"referredFrom\": \""
							+ (referredFrom)		
							+ "\",\"referredBy\": \""
							+ (referredBy)			
							+ "\",\"employeeNo\": \""
							+ (list.getServiceNo() != null ? list.getServiceNo() : "")
							+ "\",\"division\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getDivision().getDivisionName(): "")
							+ "\",\"employeeType\": \""
							+ (list.getEmployee() != null ? list.getEmployee().getEmployeeType().getEmployeeTypeName() : "")
							+ "\",\"age\": \""
							+ (list.getDateOfBirth() != null ? HMSUtil.calculateAge(list.getDateOfBirth()) : "")
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
							+ "\",\"excelStatus\":\""
							+ (excelStatus)		
							+ "\",\"treatmentType\":\""
							+ (treatmentType)	
							+ "\",\"referralNo\":\""
							+ (referralPatientHeader.getReferralNo())	
							+ "\",\"relation\":\""
							+ (list.getRelation() != null ? list
									.getRelation().getRelationName() : "")						
							+ "\",\"totalRecords\":\"" + totalRecords + "\"}");
				}

				counter++;
				i++;
			}

			pw.write("]");

		}

		catch (Exception e) {
			referralPatientHeaderList.clear();

			e.printStackTrace();
		}
		referralPatientHeaderList.clear();
		return null;

	}
	
	@SuppressWarnings("unchecked")
	public synchronized ModelAndView submitReferralLetterPage(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		Box box = HMSUtil.getBox(request);

		Users user = (Users) session.getAttribute("users");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		box.put("userId", user.getId());
		int referralPatientDetailsId = 0;
				
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Boolean successfullyAdded = false;	

		System.out.println("before Submit");
		detailsMap = referralHandlerService.submitReferralLetterPage(box);
		
	
		if (detailsMap.get("succesfullyAdded") != null) {
			successfullyAdded = (Boolean) detailsMap.get("succesfullyAdded");
		}
		if (detailsMap.get("referralPatientDetailsId") != null) {
			referralPatientDetailsId = (Integer) detailsMap.get("referralPatientDetailsId");
		}
		if (detailsMap.get("flag") != null) {
			map.put("flag", detailsMap.get("flag"));
		}
		if (detailsMap.get("referralTreatmentType") != null) {
			map.put("referralTreatmentType", detailsMap.get("referralTreatmentType"));
		}
		String message;
		if (successfullyAdded == true) {
			message = "Patient referral saved Successfully.";
			
		}  else {
			message = "Some problem Occured! Try Again.";
			
		}
	

		dataMap.put("users", user);
			
		String jsp = "msgForGenerateReferralLetterPage.jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);		
		map.put("referralPatientDetailsId", referralPatientDetailsId);	
		
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public synchronized ModelAndView submitExtensionLetterPage(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		Box box = HMSUtil.getBox(request);

		Users user = (Users) session.getAttribute("users");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		box.put("userId", user.getId());
		int referralPatientDetailsId = 0;
				
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Boolean successfullyAdded = false;	

		System.out.println("before Submit");
		detailsMap = referralHandlerService.submitExtensionLetterPage(box);
		
	
		if (detailsMap.get("succesfullyAdded") != null) {
			successfullyAdded = (Boolean) detailsMap.get("succesfullyAdded");
		}
		if (detailsMap.get("referralPatientDetailsId") != null) {
			referralPatientDetailsId = (Integer) detailsMap.get("referralPatientDetailsId");
		}
		if (detailsMap.get("flag") != null) {
			map.put("flag", detailsMap.get("flag"));
		}
		if (detailsMap.get("referralTreatmentType") != null) {
			map.put("referralTreatmentType", detailsMap.get("referralTreatmentType"));
		}
		String message;
		if (successfullyAdded == true) {
			message = "Patient Extension Saved Successfully " +detailsMap.get("referral_no");
			
		}  else {
			message = "Some problem Occured! Try Again.";
			
		}
	

		dataMap.put("users", user);
			
		String jsp = "msgForGenerateExtensionLetterPage.jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);		
		map.put("referralPatientDetailsId", referralPatientDetailsId);	
		
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public synchronized ModelAndView submitInvoicePage(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		Box box = HMSUtil.getBox(request);

		Users user = (Users) session.getAttribute("users");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int referral_patient_details_id = 0;
		int referral_patient_header_id = 0;
		int referralClarrificationHeaderId = 0;
		box.put("hospitalId", hospitalId);
		box.put("userId", user.getId());
				
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Boolean successfullyAdded = false;	

		System.out.println("before Submit");
		detailsMap = referralHandlerService.submitInvoicePage(box);
		
	
		if (detailsMap.get("succesfullyAdded") != null) {
			successfullyAdded = (Boolean) detailsMap.get("succesfullyAdded");
		}
		
		if (detailsMap.get("referral_patient_details_id") != null) {
			referral_patient_details_id = (int) detailsMap.get("referral_patient_details_id");
		}
		if (detailsMap.get("referral_patient_header_id") != null) {
			referral_patient_header_id = (int) detailsMap.get("referral_patient_header_id");
		}
		if (detailsMap.get("referralClarrificationHeaderId") != null) {
			referralClarrificationHeaderId = (int) detailsMap.get("referralClarrificationHeaderId");
		}
		String message;
		if (successfullyAdded == true) {
			if(detailsMap.get("covernote_no")!=null && !((String)detailsMap.get("covernote_no")).equals(""))
			{
				message = "Cover Note Number Generated Successfully "+detailsMap.get("covernote_no");
			}
			else
			{
				message = "Patient Invoice saved Successfully.";
			}
			
			
		}  else {
			message = "Some problem Occured! Try Again.";
			
		}
	

		dataMap.put("users", user);
		System.out.println("referralClarrificationHeaderId"+referralClarrificationHeaderId);	
		String jsp = "msgForGenerateInvoicePage.jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);		
		map.put("url", "/hms/hms/referral?method=invoiceWaitingList");
		map.put("referral_patient_details_id", referral_patient_details_id);
		map.put("referral_patient_header_id", referral_patient_header_id);
		map.put("referralClarrificationHeaderId", referralClarrificationHeaderId);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public synchronized ModelAndView submitInvoicePageAlreadySend(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		Box box = HMSUtil.getBox(request);

		Users user = (Users) session.getAttribute("users");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int referral_patient_details_id = 0;
		int referral_patient_header_id = 0;
		int referralClarrificationHeaderId = 0;
		box.put("hospitalId", hospitalId);
		box.put("userId", user.getId());
				
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Boolean successfullyAdded = false;	

		System.out.println("before Submit");
		detailsMap = referralHandlerService.submitInvoicePageAlreadySend(box);
		
	
		if (detailsMap.get("succesfullyAdded") != null) {
			successfullyAdded = (Boolean) detailsMap.get("succesfullyAdded");
		}
		
		if (detailsMap.get("referral_patient_details_id") != null) {
			referral_patient_details_id = (int) detailsMap.get("referral_patient_details_id");
		}
		if (detailsMap.get("referral_patient_header_id") != null) {
			referral_patient_header_id = (int) detailsMap.get("referral_patient_header_id");
		}
		if (detailsMap.get("referralClarrificationHeaderId") != null) {
			referralClarrificationHeaderId = (int) detailsMap.get("referralClarrificationHeaderId");
		}
		String message;
		if (successfullyAdded == true) {
			if(detailsMap.get("covernote_no")!=null && !((String)detailsMap.get("covernote_no")).equals(""))
			{
				message = "Cover Note Number Generated Successfully "+detailsMap.get("covernote_no");
			}
			else
			{
				message = "Patient Invoice saved Successfully.";
			}
			
			
		}  else {
			message = "Some problem Occured! Try Again.";
			
		}
	

		dataMap.put("users", user);
		System.out.println("referralClarrificationHeaderId"+referralClarrificationHeaderId);	
		String jsp = "msgForGenerateInvoicePage.jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);		
		map.put("url", "/hms/hms/referral?method=invoiceWaitingListAlreadySend");
		map.put("referral_patient_details_id", referral_patient_details_id);
		map.put("referral_patient_header_id", referral_patient_header_id);
		map.put("referralClarrificationHeaderId", referralClarrificationHeaderId);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public synchronized ModelAndView generateExtension(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		Box box = HMSUtil.getBox(request);

		Users user = (Users) session.getAttribute("users");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int referral_patient_details_id = 0;
		box.put("hospitalId", hospitalId);
		box.put("userId", user.getId());
				
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Boolean successfullyAdded = false;	

		System.out.println("before Submit");
		detailsMap = referralHandlerService.generateExtension(box);
		
	
		if (detailsMap.get("succesfullyAdded") != null) {
			successfullyAdded = (Boolean) detailsMap.get("succesfullyAdded");
		}
		
		if (detailsMap.get("referral_patient_details_id") != null) {
			referral_patient_details_id = (int) detailsMap.get("referral_patient_details_id");
		}
		String message;
		if (successfullyAdded == true) {
			if(detailsMap.get("message")!=null && !((String)detailsMap.get("message")).equals(""))
			{
				message = (String)detailsMap.get("message");
			}
			else
			{
				message = "Extension generated successfully.";
			}
			
			
		}  else {
			message = "Some problem Occured! Try Again.";
			
		}
	

		dataMap.put("users", user);
			
		String jsp = "invoiceWaitingList.jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);		
		map.put("url", "/hms/hms/referral?method=invoiceWaitingList");
		map.put("referral_patient_details_id", referral_patient_details_id);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public synchronized ModelAndView updateReferralDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		Box box = HMSUtil.getBox(request);

		Users user = (Users) session.getAttribute("users");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int referral_patient_details_id = 0;
		box.put("hospitalId", hospitalId);
		box.put("userId", user.getId());
				
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Boolean successfullyAdded = false;	

		System.out.println("before Submit");
		detailsMap = referralHandlerService.updateReferralDetails(box);
		
	
		if (detailsMap.get("succesfullyAdded") != null) {
			successfullyAdded = (Boolean) detailsMap.get("succesfullyAdded");
		}
		
		if (detailsMap.get("referral_patient_details_id") != null) {
			referral_patient_details_id = (int) detailsMap.get("referral_patient_details_id");
		}
		String message;
		if (successfullyAdded == true) {
			if(detailsMap.get("message")!=null && !((String)detailsMap.get("message")).equals(""))
			{
				message = (String)detailsMap.get("message");
			}
			else
			{
				message = "Referral Details Updated Successfully.";
			}
			
			
		}  else {
			message = "Some problem Occured! Try Again.";
			
		}
	

		dataMap.put("users", user);
			
		String jsp = "invoiceWaitingList.jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);		
		map.put("url", "/hms/hms/referral?method=invoiceWaitingList");
		map.put("referral_patient_details_id", referral_patient_details_id);
		return new ModelAndView("index", "map", map);
	}

	
	@SuppressWarnings("unchecked")
	public synchronized void checkBillNo(HttpServletRequest request,
			HttpServletResponse response) {

		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));

		
	    String isDublicate = referralHandlerService.checkBillNo(box);
		System.out.println("isDublicate"+isDublicate);
	
		try {
			
			
			
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
			response.getWriter().write("<dublicateBill>");
			response.getWriter().write(isDublicate);
			response.getWriter().write("</dublicateBill>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@SuppressWarnings("unchecked")
	public synchronized ModelAndView submitInvoicePageForHRDivision(
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
			if(box.getString("flag").equals("rejected"))
			{
				message = "Cover Note Number Rejected Successfully.";
			}
			else{
				message = "Cover Note Number Approved Successfully.";
			}
			
			
		}  else {
			message = "Some problem Occured! Try Again.";
			
		}
	

		dataMap.put("users", user);
			
		String jsp = "msgForGenerateInvoicePage.jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);		
		map.put("url", "/hms/hms/referral?method=invoiceWaitingListForHRDivision");
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public synchronized ModelAndView submitInvoicePageForFinanceDivision(
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
		detailsMap = referralHandlerService.submitInvoicePageForFinanceDivision(box);
		
	
		if (detailsMap.get("succesfullyAdded") != null) {
			successfullyAdded = (Boolean) detailsMap.get("succesfullyAdded");
		}
		String message;
		if (successfullyAdded == true) {
			if(box.getString("flag").equals("rejected"))
			{
				message = "Patient Invoice Rejected Successfully.";
			}
			else{
				message = "Patient Invoice Approved Successfully.";
			}
			
		}  else {
			message = "Some problem Occured! Try Again.";
			
		}
	

		dataMap.put("users", user);
			
		String jsp = "msgForGenerateInvoicePage.jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);		
		map.put("url", "/hms/hms/referral?method=invoiceWaitingListForFinanceDivision");
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public synchronized ModelAndView submitInvoicePageForGM(
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
		detailsMap = referralHandlerService.submitInvoicePageForGM(box);
		
	
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
		map.put("url", "/hms/hms/referral?method=invoiceWaitingListForGM");
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public synchronized ModelAndView generateDivisionalApprovalLetter(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		Box box = HMSUtil.getBox(request);

		Users user = (Users) session.getAttribute("users");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		box.put("userId", user.getId());
		box.put("divisionId", session.getAttribute("divisionId"));
				
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Boolean successfullyAdded = false;	

		System.out.println("before Submit");
		detailsMap = referralHandlerService.generateDivisionalApprovalLetter(box, response);
		
	
		if (detailsMap.get("succesfullyAdded") != null) {
			successfullyAdded = (Boolean) detailsMap.get("succesfullyAdded");
		}
		String message;
		if (successfullyAdded == true) {
			message = "Divisional Approval Letter Generated Successfully " +detailsMap.get("consolidateNumber");
			/*showReferralReport(request, response);*/
			
		}  else {
			message = "Some problem Occured! Try Again.";
			
		}
	

		dataMap.put("users", user);
			
		String jsp = "msgForGenerateInvoicePage.jsp";
		/*String jsp = "invoiceWaitingListForGM.jsp";*/
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("flag", "Divisional_approval_letter");
		map.put("consolidatedNo", detailsMap.get("consolidateNumber"));
		map.put("url", "/hms/hms/referral?method=invoiceWaitingListForGM");
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showReferralExcelReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
		//map = storesHandlerService.showDrugExpiryList(hospitalId);
		Box box = HMSUtil.getBox(request);
		map = referralHandlerService.getInvoiceWaitingFilterData(box);
		String jsp = "";
		
		jsp = "referralExcelReport.jsp";
		map.put("contentJsp", jsp);
		
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView showReferralExcelBillingReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
		//map = storesHandlerService.showDrugExpiryList(hospitalId);
		Box box = HMSUtil.getBox(request);
		map = referralHandlerService.getInvoiceWaitingFilterData(box);
		String jsp = "";
		
		jsp = "referralExcelBillingReport.jsp";
		map.put("contentJsp", jsp);
		
		return new ModelAndView("index","map",map);
	}
	
	@SuppressWarnings("unchecked")
	public synchronized ModelAndView generateReferralExcelReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		Box box = HMSUtil.getBox(request);

		Users user = (Users) session.getAttribute("users");
		/*int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);*/
		/*box.put("hospitalId", hospitalId);*/
		box.put("userId", user.getId());
		/*box.put("divisionId", session.getAttribute("divisionId"));*/
				
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Boolean successfullyAdded = false;	

		System.out.println("before Submit");
		detailsMap = referralHandlerService.generateReferralExcelReport(box, response);
		
	
		if (detailsMap.get("succesfullyAdded") != null) {
			successfullyAdded = (Boolean) detailsMap.get("succesfullyAdded");
		}
		String message;
		if (successfullyAdded == true) {
			message = "Excel Report Generated Successfully ";
			/*showReferralReport(request, response);*/
			
		}  else {
			message = "Some problem Occured! Try Again.";
			
		}
	
		dataMap.put("users", user);
		/*
		map.put("contentJsp", jsp);*/
		map.put("message", message);		
		map.put("consolidatedNo", detailsMap.get("consolidateNumber"));		
		return new ModelAndView("index", "map", map);
	}
	
	

	@SuppressWarnings("unchecked")
	public synchronized ModelAndView generateReferralExcelBillingReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		Box box = HMSUtil.getBox(request);

		Users user = (Users) session.getAttribute("users");
		/*int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);*/
		/*box.put("hospitalId", hospitalId);*/
		box.put("userId", user.getId());
		/*box.put("divisionId", session.getAttribute("divisionId"));*/
				
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Boolean successfullyAdded = false;	

		System.out.println("before Submit");
		detailsMap = referralHandlerService.generateReferralExcelBillingReport(box, response);
		
	
		if (detailsMap.get("succesfullyAdded") != null) {
			successfullyAdded = (Boolean) detailsMap.get("succesfullyAdded");
		}
		String message;
		if (successfullyAdded == true) {
			message = "Excel Report Generated Successfully ";
			/*showReferralReport(request, response);*/
			
		}  else {
			message = "Some problem Occured! Try Again.";
			
		}
	
		dataMap.put("users", user);
		/*
		map.put("contentJsp", jsp);*/
		map.put("message", message);		
		map.put("consolidatedNo", detailsMap.get("consolidateNumber"));		
		return new ModelAndView("index", "map", map);
	}
	
	
	@SuppressWarnings("unchecked")
	public synchronized ModelAndView approveFinanceAudit(
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
		detailsMap = referralHandlerService.approveFinanceAudit(box);
		
	
		if (detailsMap.get("succesfullyAdded") != null) {
			successfullyAdded = (Boolean) detailsMap.get("succesfullyAdded");
		}
		String message;
		if (successfullyAdded == true) {
			message = "NoteSheet Approved Successfully ";
			/*showReferralReport(request, response);*/
			
		}  else {
			message = "Some problem Occured! Try Again.";
			
		}
	

		dataMap.put("users", user);
			
		String jsp = "msgForGenerateInvoicePage.jsp";
		/*String jsp = "invoiceWaitingListForGM.jsp";*/
		map.put("contentJsp", jsp);
		map.put("message", message);
//		map.put("flag", "Divisional_approval_letter");
		map.put("consolidatedNo", "");
		/*map.put("url", "/hms/hms/referral?method=invoiceWaitingListForGM");*/
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public synchronized ModelAndView revertToHRDivision(
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

		detailsMap = referralHandlerService.revertToHRDivision(box);
		
	
		if (detailsMap.get("succesfullyAdded") != null) {
			successfullyAdded = (Boolean) detailsMap.get("succesfullyAdded");
		}
		String message;
		if (successfullyAdded == true) {
			message = "Reverted Successfully ";
			/*showReferralReport(request, response);*/
			
		}  else {
			message = "Some problem Occured! Try Again.";
			
		}
	

		dataMap.put("users", user);
			
		String jsp = "msgForGenerateInvoicePage.jsp";
		/*String jsp = "invoiceWaitingListForGM.jsp";*/
		map.put("contentJsp", jsp);
		map.put("message", message);
//		map.put("flag", "Divisional_approval_letter");
		map.put("consolidatedNo", "");
		/*map.put("url", "/hms/hms/referral?method=invoiceWaitingListForGM");*/
		return new ModelAndView("index", "map", map);
	}
	
	
	@SuppressWarnings("unchecked")
	public synchronized ModelAndView submitDeduction(
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

		detailsMap = referralHandlerService.submitDeduction(box);
		
	
		if (detailsMap.get("succesfullyAdded") != null) {
			successfullyAdded = (Boolean) detailsMap.get("succesfullyAdded");
		}
		String message;
		if (successfullyAdded == true) {
			message = "Deducted Successfully ";
			/*showReferralReport(request, response);*/
			
		}  else {
			message = "Some problem Occured! Try Again.";
			
		}
	

		dataMap.put("users", user);
			
		String jsp = "invoiceWaitingListForDeductionFS.jsp";
		/*String jsp = "invoiceWaitingListForGM.jsp";*/
		map.put("contentJsp", jsp);
		map.put("message", message);
//		map.put("flag", "Divisional_approval_letter");
		map.put("consolidatedNo", "");
		/*map.put("url", "/hms/hms/referral?method=invoiceWaitingListForGM");*/
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public synchronized ModelAndView rejectFinanceAudit(
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
		detailsMap = referralHandlerService.rejectFinanceAudit(box);
		
	
		if (detailsMap.get("succesfullyAdded") != null) {
			successfullyAdded = (Boolean) detailsMap.get("succesfullyAdded");
		}
		String message;
		if (successfullyAdded == true) {
			message = "NoteSheet Rejected Successfully ";
			/*showReferralReport(request, response);*/
			
		}  else {
			message = "Some problem Occured! Try Again.";
			
		}
	

		dataMap.put("users", user);
			
		String jsp = "msgForGenerateInvoicePage.jsp";
		/*String jsp = "invoiceWaitingListForGM.jsp";*/
		map.put("contentJsp", jsp);
		map.put("message", message);
//		map.put("flag", "Divisional_approval_letter");
		map.put("consolidatedNo", "");
		/*map.put("url", "/hms/hms/referral?method=invoiceWaitingListForGM");*/
		return new ModelAndView("index", "map", map);
	}


	@SuppressWarnings("unchecked")
	public synchronized ModelAndView approveFinanceAuditPFD(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		Box box = HMSUtil.getBox(request);

		Users user = (Users) session.getAttribute("users");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		box.put("userId", user.getId());
		box.put("divisionId", session.getAttribute("divisionId"));
				
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Boolean successfullyAdded = false;	

		System.out.println("before Submit");
		detailsMap = referralHandlerService.approveFinanceAuditPFD(box);
		
	
		if (detailsMap.get("succesfullyAdded") != null) {
			successfullyAdded = (Boolean) detailsMap.get("succesfullyAdded");
		}
		String message;
		if (successfullyAdded == true) {
			message = "Dispatch Letter Generated Successfully "+detailsMap.get("dispatchNumber");
			/*showReferralReport(request, response);*/
			
		}  else {
			message = "Some problem Occured! Try Again.";
			
		}
	

		dataMap.put("users", user);
			
		String jsp = "msgForGenerateInvoicePage.jsp";
		/*String jsp = "invoiceWaitingListForGM.jsp";*/
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("flag", "Dispatch_letter");
		map.put("consolidatedNo", detailsMap.get("dispatchNumber"));
		map.put("url", "/hms/hms/referral?method=invoiceWaitingListForPFD");
		return new ModelAndView("index", "map", map);
	}

	
	@SuppressWarnings("unchecked")
	public synchronized ModelAndView generateNoteSheetLetter(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		Box box = HMSUtil.getBox(request);

		Users user = (Users) session.getAttribute("users");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		box.put("userId", user.getId());
		box.put("divisionId", session.getAttribute("divisionId"));
				
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Boolean successfullyAdded = false;	

		System.out.println("before Submit");
		detailsMap = referralHandlerService.generateNoteSheetLetter(box);
		
	
		if (detailsMap.get("succesfullyAdded") != null) {
			successfullyAdded = (Boolean) detailsMap.get("succesfullyAdded");
		}
		String message;
		if (successfullyAdded == true) {
			message = "Note Sheet Generated Successfully " +detailsMap.get("consolidateNumber");
			/*showReferralReport(request, response);*/
			
		}  else {
			message = "Some problem Occured! Try Again.";
			
		}
	

		dataMap.put("users", user);
			
		String jsp = "msgForGenerateInvoicePage.jsp";
		/*String jsp = "invoiceWaitingListForGM.jsp";*/
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("flag", "Note_sheet_letter");
		map.put("consolidatedNo", detailsMap.get("consolidateNumber"));
		map.put("url", "/hms/hms/referral?method=invoiceWaitingListForNoteSheet");
		return new ModelAndView("index", "map", map);
	}
	@SuppressWarnings("unchecked")
	public synchronized ModelAndView submitReferralExtension(
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
		detailsMap = referralHandlerService.submitReferralExtension(box);
		
	
		if (detailsMap.get("succesfullyAdded") != null) {
			successfullyAdded = (Boolean) detailsMap.get("succesfullyAdded");
		}
		String message;
		if (successfullyAdded == true) {
			message = "Patient Extension Saved Successfully.";
			
		}  else {
			message = "Some problem Occured! Try Again.";
			
		}
	

		dataMap.put("users", user);
			
		String jsp = "msgForGenerateInvoicePage.jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);		
		map.put("url", "/hms/hms/referral?method=waitingListForReferralExtension");
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings( { "unchecked", "unchecked" })
	public void showInvoiceReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String flag = "";
		int referralPatientDetailsId = 0;
		String referralTreatmentType="";
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		if (request.getParameter("referralPatientDetailsId") != null) {
			referralPatientDetailsId =Integer.parseInt(request.getParameter("referralPatientDetailsId"));
			flag = referralHandlerService.getReportFlag(referralPatientDetailsId);	
		}
		

		
		int hospitalIdForReport=0;
		
		if (request.getParameter("hospitalIdForReport") != null) {
			hospitalIdForReport =Integer.parseInt(request.getParameter("hospitalIdForReport"));
		}
		if (request.getParameter("referralTreatmentType") != null) {
			referralTreatmentType =request.getParameter("referralTreatmentType");
		}
		
		
		
		if(hospitalIdForReport != 0)
		{
			int hospitalId= hospitalIdForReport;
			parameters.put("hospitalId", hospitalId);
		}
		else
		{
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			parameters.put("hospitalId", hospitalId);
		}
		parameters.put("referral_patient_details_id", referralPatientDetailsId);
		
		//int hospitalId = (Integer) session.getAttribute("hospitalId");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		
		
		String userHome = getServletContext().getRealPath("");	         
        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
        parameters.put("path", imagePath);

		detailsMap = referralHandlerService.getConnectionForReport();	
		
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		try {
		
			if (flag.trim()!="" && flag.trim().equals("dependent") && referralTreatmentType.trim()!="" && referralTreatmentType.trim().equals("1")) {
				HMSUtil.generateReport("referral_note_dependent", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
			
			if ( flag.trim()!="" && flag.trim().equals("employee") && referralTreatmentType.trim()!="" && referralTreatmentType.trim().equals("1")) {
				HMSUtil.generateReport("referral_note_employee", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		
			if (flag.trim()!="" && flag.trim().equals("dependent") && referralTreatmentType.trim()!="" && referralTreatmentType.trim().equals("2") ) {
				HMSUtil.generateReport("referral_note_dependent_admission", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
			
			if ( flag.trim()!="" && flag.trim().equals("employee") && referralTreatmentType.trim()!="" && referralTreatmentType.trim().equals("2") ) {
				HMSUtil.generateReport("referral_note_employee_admission", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
	
	}
	
	
	@SuppressWarnings( { "unchecked", "unchecked" })
	public void generateClarrificationReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		int clarrificationHeaderId = 0;
		
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		if (request.getParameter("clarrificationHeaderId") != null) {
			clarrificationHeaderId =Integer.parseInt(request.getParameter("clarrificationHeaderId"));
			
		}
		

		
		int hospitalIdForReport=0;
		
		if (request.getParameter("hospitalIdForReport") != null) {
			hospitalIdForReport =Integer.parseInt(request.getParameter("hospitalIdForReport"));
		}
		
		
		
		
		if(hospitalIdForReport != 0)
		{
			int hospitalId= hospitalIdForReport;
			parameters.put("hospitalId", hospitalId);
		}
		else
		{
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			parameters.put("hospitalId", hospitalId);
		}
		parameters.put("clarrificationHeaderId", clarrificationHeaderId);
		
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		
		
		String userHome = getServletContext().getRealPath("");	         
        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
        parameters.put("path", imagePath);

		detailsMap = referralHandlerService.getConnectionForReport();	
		
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		try {
		
			HMSUtil.generateReport("referral_clarification", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
	
	}
	
	@SuppressWarnings( { "unchecked", "unchecked" })
	public void generateExcelForPortal(
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Hi=========================");
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String message = "Excel Generated Successfully";
		try {
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		List<List<Object[]>> sheetList = new ArrayList<List<Object[]>>();
		List<String> sheetNames = new ArrayList<String>();
		sheetNames.add("referral_header");
		sheetNames.add("referral_details");
		sheetNames.add("referral_billing");
		Box box = HMSUtil.getBox(request);

		box.put("hospitalId", hospitalId);
		String ExamType = "MedExam";
		box.put("ExamType", ExamType);        
		map = referralHandlerService.generateExcelForPortal(box);	
		map.put("sheetName", "Patient List");
		map.put("fileName", "Referred Patients");
		if(map.get("message")!=null)
		{
			message = (String)map.get("message");
		}
		else if (map.get("sheetList") != null ) {
			sheetList = (ArrayList) map.get("sheetList");			
				HMSUtil.excelWriter(sheetList, map, response, sheetNames);
		}
		else
		{
			message = "No Record Found!";
		}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message = "Some Error Has occured! Try Again.";
			}
		
       /* System.out.println("herer=============="+message);
		String jsp="excelWaitingList";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index","map",map);*/

	}
	
	@SuppressWarnings( { "unchecked", "unchecked" })
	public void generateExcelForBillsPaybal(
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Hi=========================");
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String message = "Excel Generated Successfully";
		try {
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		List<List<Object[]>> sheetList = new ArrayList<List<Object[]>>();
		List<String> sheetNames = new ArrayList<String>();
		sheetNames.add("referral_header");
		sheetNames.add("referral_details");
		sheetNames.add("referral_billing");
		Box box = HMSUtil.getBox(request);

		box.put("hospitalId", hospitalId);
		String ExamType = "MedExam";
		box.put("ExamType", ExamType);        
		map = referralHandlerService.generateExcelForBillsPaybal(box);	
		map.put("sheetName", "Patient List");
		map.put("fileName", "Referred Patients");
		if(map.get("message")!=null)
		{
			message = (String)map.get("message");
		}
		else if (map.get("sheetList") != null ) {
			sheetList = (ArrayList) map.get("sheetList");			
				HMSUtil.excelWriter(sheetList, map, response, sheetNames);
		}
		else
		{
			message = "No Record Found!";
		}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message = "Some Error Has occured! Try Again.";
			}
		
       /* System.out.println("herer=============="+message);
		String jsp="excelWaitingList";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index","map",map);*/

	}
	
	@SuppressWarnings("unchecked")
	public synchronized ModelAndView uploadExcelForHAL(
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Hi=========================");
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String message = "Excel Generated Successfully";
		try {
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		List<List<Object[]>> sheetList = new ArrayList<List<Object[]>>();
		List<String> sheetNames = new ArrayList<String>();
		sheetNames.add("referral_header");
		sheetNames.add("referral_details");
		sheetNames.add("referral_billing");
		Box box = HMSUtil.getBox(request);

		box.put("hospitalId", hospitalId);
		String ExamType = "MedExam";
		box.put("ExamType", ExamType);        
		map = referralHandlerService.uploadExcelForHAL(request);	
		map.put("sheetName", "Patient List");
		map.put("fileName", "Referred Patients");
		if((boolean)map.get("succesfullyAdded"))
		{
			message = "Excel Uploaded Sucessfully";
		}
		
		else
		{
			message = "Some Error Has occured! Try Again.";
		}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message = "Some Error Has occured! Try Again.";
			}
		
		String jsp = "msgForGenerateInvoicePage.jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);		
		map.put("url", "/hms/hms/referral?method=waitingListForReferralExtension");
		return new ModelAndView("index", "map", map);

	}
	
	@SuppressWarnings("unchecked")
	public synchronized ModelAndView submitERPUpload(
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Hi=========================");
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String message = "";
		try {
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		List<List<Object[]>> sheetList = new ArrayList<List<Object[]>>();
		List<String> sheetNames = new ArrayList<String>();
		sheetNames.add("referral_header");
		sheetNames.add("referral_details");
		sheetNames.add("referral_billing");
		Box box = HMSUtil.getBox(request);

		box.put("hospitalId", hospitalId);
		String ExamType = "MedExam";
		box.put("ExamType", ExamType);        
		map = referralHandlerService.submitERPUpload(request);	
		map.put("sheetName", "Patient List");
		map.put("fileName", "Referred Patients");
		
		if((map.get("message")!=null))
		{
			message = (String)map.get("message");
		}
		
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message = "Some Error Has occured! Try Again.";
			}
		
		String jsp = "erpUpload.jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);		
		/*map.put("url", "/hms/hms/referral?method=waitingListForReferralExtension");*/
		return new ModelAndView("index", "map", map);

	}
	
	
	@SuppressWarnings("unchecked")
	public synchronized ModelAndView submitERPUploadTemp(
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Hi=========================");
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String message = "";
		try {
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		List<List<Object[]>> sheetList = new ArrayList<List<Object[]>>();
		List<String> sheetNames = new ArrayList<String>();
		sheetNames.add("referral_header");
		sheetNames.add("referral_details");
		sheetNames.add("referral_billing");
		Box box = HMSUtil.getBox(request);

		box.put("hospitalId", hospitalId);
		String ExamType = "MedExam";
		box.put("ExamType", ExamType);        
		map = referralHandlerService.submitERPUploadTemp(request);	
		map.put("sheetName", "Patient List");
		map.put("fileName", "Referred Patients");
		
		if((map.get("message")!=null))
		{
			message = (String)map.get("message");
		}
		
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message = "Some Error Has occured! Try Again.";
			}
		
		String jsp = "erpUploadTemp.jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);		
		/*map.put("url", "/hms/hms/referral?method=waitingListForReferralExtension");*/
		return new ModelAndView("index", "map", map);

	}
	
	public ModelAndView showReferralReport(HttpServletRequest request,
			HttpServletResponse response) {
		/*Box box = HMSUtil.getBox(request);*/
		//System.out.println("request   " + box);
		
		Map<String, Object> parameters = new HashMap<String, Object>();		
		
		HttpSession session = request.getSession();
		String flag="";
		int headerId0 = 0;
		int checkboxCount =0;
		int referral_patient_header_id=0;
		String consolidatedNo="";
		
		try {
			parameters = referralHandlerService.getConnectionForReport();
			parameters.put(HOSPITAL_ID, session.getAttribute("hospitalId"));
			
			if (request.getParameter("flag") != null
					&& !(request.getParameter("flag").equals(""))) {
				flag = request.getParameter("flag");
			
			}
		/*	if(box.get("checkboxCount")!= null){
				checkboxCount = box.getInt("checkboxCount");
			}
			 for(int i = 0; i<checkboxCount; i++)
			   {	
				 if(box.get("headerId"+i)!=null && box.getInt("headerId"+i)!=0)
					{
					 if(i==(checkboxCount-1)){
						 referral_patient_header_id+=box.getInt("headerId"+i);
					 }
					 else
					 {
						 referral_patient_header_id+=box.getInt("headerId"+i)+","; 
					 }
					 
					}
			   }*/
			if (request.getParameter("referral_patient_header_id") != null
					&& !(request.getParameter("referral_patient_header_id").equals(""))) {
				referral_patient_header_id = Integer.parseInt(request.getParameter("referral_patient_header_id"));
				parameters.put("referral_patient_header_id", referral_patient_header_id);
			
			}
			if (request.getParameter("consolidatedNo") != null
					&& !(request.getParameter("consolidatedNo").equals(""))) {
				consolidatedNo = request.getParameter("consolidatedNo");
				parameters.put("consolidatedNo", consolidatedNo);
			
			}
			
			    System.out.println("consolidatedNo"+consolidatedNo);
				
			
			/*if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				clincialMap.put(SERVICE_NO, serviceNo);
			}*/
		
			
	

			/*parameters = dischargeHandlerService
					.getDischargeSummaryReportDetails(requestParameters);*/

			/*
			 * Following two parameters (hinNo, adNo) are used in the sql query
			 * which build in JASPER report Rest of the parameter values in the
			 * "parameter" map are used in Report Form
			 */
			int hospitalId=0;
			String hospitalName="";
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				/*hospitalName = dischargeHandlerService.getHospitalName(hospitalId);
				parameters.put("hospitalName", hospitalName);*/
				parameters.put("hospitalId", hospitalId);
			}
			String userHome = getServletContext().getRealPath("");	         
	        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
			parameters.put("path", imagePath);
			
			parameters.put("IMG_PATH", request.getSession().getServletContext().getRealPath("/jsp/images/humanBody.jpg"));
			parameters.put("SUBREPORT_DIR", getServletContext()
					.getRealPath("/reports/"));
			parameters.put("hospitalId", session.getAttribute("hospitalId"));
			if(flag.equalsIgnoreCase("covering_letter")){
			HMSUtil.generateReport("covering_letter",
					parameters, (Connection) parameters.get("conn"),
					response, getServletContext());}
			if(flag.equalsIgnoreCase("Divisional_approval_letter")){
				HMSUtil.generateReport("Divisional_approval_letter",
						parameters, (Connection) parameters.get("conn"),
						response, getServletContext());
				
				}
			if(flag.equalsIgnoreCase("Note_sheet_letter")){
				HMSUtil.generateReport("Note_sheet_letter",
						parameters, (Connection) parameters.get("conn"),
						response, getServletContext());
			
				}
			if(flag.equalsIgnoreCase("Dispatch_letter")){
				parameters.putAll(referralHandlerService.getMedicalHR()); 
				HMSUtil.generateReport("dispatch_letter",
						parameters, (Connection) parameters.get("conn"),
						response, getServletContext());
				
				}
			
	

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	
	
	
	
	public ReferralHandlerService getReferralHandlerService() {
		return referralHandlerService;
	}

	public void setReferralHandlerService(
			ReferralHandlerService referralHandlerService) {
		this.referralHandlerService = referralHandlerService;
	}
	
	
	public ModelAndView viewReferralLetterPage(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String jsp ="";
		String title ="";
		map = referralHandlerService.generateReferralLetterPage(box);
		Map<String, Object> detailsMap = new HashMap<String, Object>();		
		if(detailsMap.get("diagnosisList")!=null){
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		if(detailsMap.get("disabilityList")!=null){
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}
		jsp = "viewReferralLetterPage.jsp";

		title = "Patient Detail";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView DeleteFromDatabase_AddRemoveGrid(HttpServletRequest request, HttpServletResponse response)
	 {
	 	Map<String,Object> datamap = new HashMap<String,Object>();
	 	Box box = HMSUtil.getBox(request);	
	 	boolean bSuccessfullyDelete = false;
	 	datamap = referralHandlerService.DeleteFromDatabase_AddRemoveGrid(box);
	 	
	 	if(datamap.get("bSuccessfullyDelete")!= null)
	 	{
	 		bSuccessfullyDelete = (Boolean) datamap.get("bSuccessfullyDelete");
	 	}
	 	
	 	try
	 	{
	 		PrintWriter pw = response.getWriter();	
	 		if(bSuccessfullyDelete)
	 		pw.write("success~~"+bSuccessfullyDelete);
	 		else
	 			pw.write("failure~~"+bSuccessfullyDelete);
	 			
	 		
	 	}
	 	
	 	catch(Exception e)
	 	{		
	 		e.printStackTrace();
	 	}
	 	return null;
	 }

	
	

}
