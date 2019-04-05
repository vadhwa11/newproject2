package jkt.hms.ot.dataservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.ByteBuffer;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import jkt.hms.masters.business.AllergyDetail;
import jkt.hms.masters.business.AnesthesiaRecordDocument;
import jkt.hms.masters.business.BloodMasComponent;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgOrderdt;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DgResultEntryDetail;
import jkt.hms.masters.business.DgResultEntryHeader;
import jkt.hms.masters.business.DgSampleCollectionDetails;
import jkt.hms.masters.business.DgSampleCollectionHeader;
import jkt.hms.masters.business.DischargeIcdCode;
import jkt.hms.masters.business.InjAppointmentDetails;
import jkt.hms.masters.business.InjAppointmentHeader;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.IpdPatientDiet;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAllergyType;
import jkt.hms.masters.business.MasAnesthesia;
import jkt.hms.masters.business.MasBed;
import jkt.hms.masters.business.MasBedStatus;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDiet;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasIcd;
import jkt.hms.masters.business.MasImpanneledHospital;
import jkt.hms.masters.business.MasInjuryNature;
import jkt.hms.masters.business.MasItemClass;
import jkt.hms.masters.business.MasItemClassification;
import jkt.hms.masters.business.MasItemType;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasOpInstruction;
import jkt.hms.masters.business.MasOt;
import jkt.hms.masters.business.MasOtDistribution;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasStoreGroup;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreItemConversion;
import jkt.hms.masters.business.MasStoreSection;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.OpdPatientHistory;
import jkt.hms.masters.business.OpdSurgeryDetail;
import jkt.hms.masters.business.OpdSurgeryHeader;
import jkt.hms.masters.business.OpdTemplate;
import jkt.hms.masters.business.OtAnesthesiologist;
import jkt.hms.masters.business.OtBed;
import jkt.hms.masters.business.OtBookSurgeon;
import jkt.hms.masters.business.OtBooking;
import jkt.hms.masters.business.OtBookingDt;
import jkt.hms.masters.business.OtHumanBodyDisposal;
import jkt.hms.masters.business.OtMasChargeDetails;
import jkt.hms.masters.business.OtPostAnaesthesiaProcedure;
import jkt.hms.masters.business.OtPostOpInstruction;
import jkt.hms.masters.business.OtPreAnaesthesiaProNotesSub;
import jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain;
import jkt.hms.masters.business.OtPreAnesthesiaDetail;
import jkt.hms.masters.business.OtPreAnesthesiaHd;
import jkt.hms.masters.business.OtPreOpDrugsEntry;
import jkt.hms.masters.business.OtPreOpInstruction;
import jkt.hms.masters.business.OtProcedureNotesEntryDetail;
import jkt.hms.masters.business.OtProcedureNotesEntryHeader;
import jkt.hms.masters.business.OtSpecimenDispatchEntry;
import jkt.hms.masters.business.OtSurgeyPaAnesthesiologistDetail;
import jkt.hms.masters.business.OtSurgeyPaEmployeeDetail;
import jkt.hms.masters.business.OtSurgeyPaIvFluidsDetail;
import jkt.hms.masters.business.OtSurgeyPaPremedicationDetail;
import jkt.hms.masters.business.OtSurgeyPaProcedureDetail;
import jkt.hms.masters.business.OtSurgeyPaSurgeyDetail;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientFamilyHistory;
import jkt.hms.masters.business.PatientInvestigationHeader;
import jkt.hms.masters.business.PatientMedicalHistory;
import jkt.hms.masters.business.PatientPrescriptionDetails;
import jkt.hms.masters.business.PatientPrescriptionHeader;
import jkt.hms.masters.business.PreAnesthesiaConsultDoctorDt;
import jkt.hms.masters.business.PreAnesthesiaConsultDoctorHd;
import jkt.hms.masters.business.ProcedureDetails;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.StoreMaterialPurchaseReqT;
import jkt.hms.masters.business.StoreOpPatientIssueM;
import jkt.hms.masters.business.StoreOpPatientIssueT;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.Transfer;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ca.uhn.hl7v2.model.v21.segment.ADD;
import static jkt.hms.util.RequestConstants.AD_NO;
import static jkt.hms.util.RequestConstants.CURRENT_DATE;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.PATIENT_NAME;
import static jkt.hms.util.RequestConstants.GENDER;
import static jkt.hms.util.RequestConstants.USER_ID;
import static jkt.hms.util.RequestConstants.EMPLOYEE_ID;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.VISIT_ID;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;
import static jkt.hms.util.RequestConstants.OT_ID;
import static jkt.hms.util.RequestConstants.SURGERY_DATE;
import static jkt.hms.util.RequestConstants.OT_BOOKING_ID;;


@SuppressWarnings("unchecked")
public class OTDataServiceImpl extends HibernateDaoSupport implements
		OTDataService {

	// -----------------------methods changed by vikas----------------------

	public Map<String, Object> getPacClearanceList(Map mapForDS) {

		
	/*	
	 * Session session = (Session) getSession();List<OpdSurgeryHeader> pacList = new ArrayList<OpdSurgeryHeader>();
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");

		String patientStatus = "Pending";

		try {
			pacList = session.createCriteria(OpdSurgeryHeader.class).add(
					Restrictions.eq("PacStatus", patientStatus)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("pacList", pacList);
		return map;*/
		
		Session session = (Session) getSession();
		List<OpdSurgeryHeader> pacList = new ArrayList<OpdSurgeryHeader>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		Map<String, Object> map = new HashMap<String, Object>();
        //String uhid="";
        String pName="";
        String ipNo="";
        int gender=0;
        String empId = "";
		//String []patientStatus = {"Requested for consultation","pending", "Consultation received"};
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
/*		if(mapForDS.get(HIN_NO)!=null)
		{
			uhid=(String)mapForDS.get(HIN_NO);
		}
		*/
/*		if(mapForDS.get(AD_NO)!=null)
		{
			ipNo=(String)mapForDS.get(AD_NO);
		}*/
		


if(mapForDS.get(EMPLOYEE_ID)!=null)
{
	empId = (String)mapForDS.get(EMPLOYEE_ID);
}
		
		if(mapForDS.get(PATIENT_NAME)!=null)
		{
			pName=(String)mapForDS.get(PATIENT_NAME);
		}
		
		if(mapForDS.get(GENDER)!=null)
		{
			gender=(Integer)mapForDS.get(GENDER);
		}

		try {
	/*		List<String>aList=new ArrayList<String>();
			aList.add("A");
			aList.add("R");
			aList.add("O");*/
			Criteria criteria= session.createCriteria(OpdSurgeryHeader.class)
                     .createAlias("Hin", "h")
                    // .createAlias("Inpatient", "ip")
                     //.add(Restrictions.in("ip.AdStatus", aList))
					 .add(Restrictions.eq("Hospital.Id", hospitalId))
					  .add(Restrictions.eq("Status", "n")).addOrder(Order.desc("RequisitionDate")).addOrder(Order.desc("RequisitionTime"));
			
					 //.add(Restrictions.in("PacStatus", patientStatus));
			/*if(!uhid.equals(""))
			{
				criteria.add(Restrictions.eq("h.HinNo", uhid.toLowerCase()).ignoreCase());
			}*/
			if(!pName.equals(""))
			{
				criteria.add(Restrictions.like("h.PFirstName", pName.toLowerCase()+"%").ignoreCase());
			}
		
			if(empId!=null && !empId.equals(""))
			{
				criteria.add(Restrictions.eq("h.ServiceNo", empId));
			}
			
	/*		if(!ipNo.equals(""))
			{
				//criteria.createAlias("Inpatient", "ip");
				criteria.add(Restrictions.eq("ip.AdNo", ipNo.toLowerCase()).ignoreCase())
				
				;
			}*/
			if(gender!=0)
			{
				criteria.createAlias("h.Sex", "s");
				criteria.add(Restrictions.eq("s.Id", gender));
			}

			pacList=criteria.list();
			
			sexList=session.createCriteria(MasAdministrativeSex.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		
		
		map.put("pacList", pacList);
		map.put("sexList", sexList);
		return map;
	}

	public Map<String, Object> searchpatient(Map mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdSurgeryHeader> pacList = new ArrayList<OpdSurgeryHeader>();

		String serviceNo = "";
		String hinNo = "";
		String employeeName = "";
		String patientType = "";

		int deptId = 0;
		Session session = (Session) getSession();

		if (mapForDS.get("deptId") != null) {
			deptId = (Integer) mapForDS.get("deptId");
		}
		if (mapForDS.get("serviceNo") != null) {
			serviceNo = (String) mapForDS.get("serviceNo");
		}
		if (mapForDS.get("hinNo") != null) {
			hinNo = (String) mapForDS.get("hinNo");
		}
		if (mapForDS.get("patientType") != null) {
			patientType = (String) mapForDS.get("patientType");
			// //System.out.println("Service type name in ds---"+serviceTypeName+"-----department id in ds---"+deptId);
		}
		String pacStatus = "Pending";
		Criteria crit = session.createCriteria(OpdSurgeryHeader.class)
				.createAlias("Hin", "hin").add(
						Restrictions.eq("PacStatus", pacStatus));
		if (hinNo.equals("")) {
			if (!patientType.equals("")) {
				// //System.out.println("Serviceeeeeeeeee type name in ds---"+serviceTypeName+"-----department id in ds---"+deptId);
				crit = crit.add(Restrictions.eq("PatientStatus", patientType));
			}
			if (!serviceNo.equals("")) {
				//System.out.println("service number-----" + serviceNo);
				crit = crit.add(Restrictions.eq("hin.ServiceNo", serviceNo));
			}

		} else {
			crit = crit.add(Restrictions.eq("hin.HinNo", hinNo));
		}
		pacList = crit.list();
		//System.out.println("Size of list for patient search----"+ pacList.size() + "-- criteria--" + crit);
		map.put("pacList", pacList);

		return map;
	}

public Map<String, Object> showPreAnesthesiaForm(Map mapForDS) {
		
		Session session = (Session) getSession();
		List<OpdSurgeryHeader> opdSurgeryList = new ArrayList<OpdSurgeryHeader>();
		List<OpdPatientDetails>patientDetailsList=new ArrayList<OpdPatientDetails>();
		List<OtPreAnesthesiaHd>OtPreAnesthesiaDetailsList=new ArrayList<OtPreAnesthesiaHd>();
		List<OpdPatientHistory> opdPatientHistoryList = new ArrayList<OpdPatientHistory>();
		List<PatientPrescriptionHeader> patientPrescriptionHeaderList = new ArrayList<PatientPrescriptionHeader>();
		List<PatientPrescriptionDetails> patientPrescriptionDetailList = new ArrayList<PatientPrescriptionDetails>();
		//List<BloodMasComponent>BloodMasComponentList=new ArrayList<BloodMasComponent>();
		//List<Integer> opdPatientList = new ArrayList<Integer>();
		List<Integer> maxVisitFromPatientPresList = new ArrayList<Integer>();
		List<MasAnesthesia> anesthesiaList = new ArrayList<MasAnesthesia>();
		//List<MasEmployee>doctorList=new ArrayList<MasEmployee>();
		//List<MasInstituteDepartment>instituteDepartmentList=new ArrayList<MasInstituteDepartment>();
		List<MasDepartment>wardDepartment = new ArrayList<MasDepartment>();
		List<MasDepartment>deptList = new ArrayList<MasDepartment>();
		List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
		//List<DischargeIcdCode>icdList=new ArrayList<DischargeIcdCode>();
		List<PatientFamilyHistory>  medicalHistoryTemplate = new ArrayList<PatientFamilyHistory>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		String anesthesia="";
		
		int opdSurgeryId = (Integer) mapForDS.get("opdSurgeryId");
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		int visitId=0;
		int inpatient = 0;
		int departmentId = (Integer) mapForDS.get(DEPARTMENT_ID);;
		int docId = (Integer) mapForDS.get(EMPLOYEE_ID);
		
		opdSurgeryList = session.createCriteria(OpdSurgeryHeader.class)
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("Id", opdSurgeryId)).list();
		
		
		OpdSurgeryHeader opdSurgeryHeader = (OpdSurgeryHeader) opdSurgeryList
				.get(0);
		
		int hinId = opdSurgeryHeader.getHin().getId();
		visitId = opdSurgeryHeader.getVisit().getId();
		if(opdSurgeryHeader.getInpatient()!=null)
		inpatient = opdSurgeryHeader.getInpatient().getId();
		String icd="";
/*		//icdList=session.createCriteria(DischargeIcdCode.class).add(Restrictions.eq("Inpatient.Id", opdSurgeryHeader.getInpatient().getId())).list();
		
		
		
		// Set<String> uniqueIcdList = new HashSet<String>();
		for(DischargeIcdCode icd2:icdList){
			if(icd2.getIcd()!=null){
				uniqueIcdList.add(icd2.getIcd().getIcdName());
			}
		}
	
		for(String icd2:uniqueIcdList){
			icd=icd+"\n"+icd2;
		}
		*/
		
		if(opdSurgeryHeader.getHin()!=null)
		{
			List<DischargeIcdCode>icdList=new ArrayList<DischargeIcdCode>();
			icdList=session.createCriteria(DischargeIcdCode.class).add(Restrictions.eq("Hin.Id", opdSurgeryHeader.getHin().getId())).list();
			
			Set<MasIcd> uniqueIcdList=new HashSet <MasIcd>();
			for(DischargeIcdCode icd2:icdList){
				MasIcd masIcd = icd2.getIcd();
				if(icd2.getIcd()!=null){
					uniqueIcdList.add(masIcd);
					//System.out.println("ff"+icd2.getId());
				}
			}
			
		
			for(MasIcd icd2:uniqueIcdList){
				icd=icd+"\n"+icd2.getIcdName();
				
			}
		}
		
		
		
		List<Visit>visitList=new ArrayList<Visit>();
		visitList=session.createCriteria(Visit.class).add(Restrictions.eq("Hin.Id", hinId)).addOrder(Order.desc("Id")).setMaxResults(1).list();
		for(Visit visit:visitList){
			visitId=visit.getId();
		}
		patientPrescriptionDetailList=session.createCriteria(PatientPrescriptionDetails.class)
				.createAlias("Prescription", "Prescription")
				.createAlias("Prescription.Visit", "visit")
				.add(Restrictions.eq("visit.Id", visitId))
				//.add(Restrictions.eq("h.Id", hospitalId)) 
				.list();
		String wardDepartmentTypeCode = null;
		String departmentTypeCode = null;
		String departmentTypeCodeForOT = null;
		List<String > DeptCodeList =new ArrayList<String>();
		try
		{
			 wardDepartmentTypeCode = HMSUtil.getValuesFromPropertiesFile("adt.properties", "departmentTypeCodeForWard");
			 departmentTypeCode = HMSUtil.getValuesFromPropertiesFile("adt.properties", "departmentTypeCodeForOpd");
			 departmentTypeCodeForOT = HMSUtil.getValuesFromPropertiesFile("adt.properties", "departmentTypeCodeForOT");
			 
			 DeptCodeList.add(departmentTypeCode);
			 DeptCodeList.add(departmentTypeCodeForOT);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		wardDepartment = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status","y").ignoreCase())
				.createAlias("DepartmentType", "dt")
				.add(Restrictions.eq("dt.DepartmentTypeCode",wardDepartmentTypeCode))
				.addOrder(Order.asc("DepartmentName"))
				.list();
		
		deptList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y"))
				.createAlias("DepartmentType", "dt")
				.add(Restrictions.in("dt.DepartmentTypeCode",DeptCodeList))
			.addOrder(Order.asc("DepartmentName")).list();
		
		
		try {
			//System.out.println("jk"+hospitalId+"   >>>  "+opdSurgeryId);
			
			if (opdSurgeryHeader.getPatientStatus().equalsIgnoreCase(
					"Out Patient")) {
				//System.out.println("in if");
				 visitId = opdSurgeryHeader.getVisit().getId();
				opdPatientHistoryList = session
						.createCriteria(OpdPatientHistory.class)
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("VisitInpatientId", visitId))
						.list();
				/*patientPrescriptionHeaderList = session
						.createCriteria(PatientPrescriptionHeader.class)
						.createAlias("Visit", "visit")
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("visit.Id", visitId)).list();*/
				/*patientDetailsList=session
						.createCriteria(OpdPatientDetails.class)
						.createAlias("Visit", "visit")
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("visit.Id", visitId)).list();*/
				patientDetailsList = session.createCriteria(OpdPatientDetails.class)
						  .createAlias("Visit","v")
						  .createAlias("v.Hin", "hin")
						  .createAlias("Hospital","h")
						  .add(Restrictions.eq("hin.Id", hinId)) 
						  .add(Restrictions.eq("h.Id", hospitalId)) 
						  .addOrder(Order.desc("id"))
						  .setMaxResults(1).list();		
				} else {
				//System.out.println("in else");
				
				/*int inpatientId = opdSurgeryHeader.getInpatient().getId();
				Criteria crit = session.createCriteria(OpdPatientHistory.class)
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("VisitInpatientId", inpatientId));
				opdPatientHistoryList = crit.list();*/

				Criteria criteria = session
						.createCriteria(PatientPrescriptionHeader.class)
						.createAlias("Hin", "hin")
						.add(Restrictions.eq("hin.Id", hinId))
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.createAlias("Visit", "visit")
						 .createAlias("Inpatient", "inpatient");
				ProjectionList projectionList = Projections.projectionList();
				projectionList.add(Projections.max("visit.Id"));
				criteria.setProjection(projectionList);
				maxVisitFromPatientPresList = criteria.list();
				if (maxVisitFromPatientPresList.get(0) != null
						&& maxVisitFromPatientPresList.size() > 0) {
					 visitId = (Integer) maxVisitFromPatientPresList.get(0);
					patientPrescriptionHeaderList = session
							.createCriteria(PatientPrescriptionHeader.class)
							.createAlias("Visit", "visit")
							.add(Restrictions.eq("visit.Id", visitId)).list();

				}

				/*patientDetailsList=session
						.createCriteria(OpdPatientDetails.class)
						.createAlias("Inpatient", "visit")
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("visit.Id", inpatientId)).list();*/
				patientDetailsList = session.createCriteria(OpdPatientDetails.class)
						  .createAlias("Inpatient","v")
						  .createAlias("v.Hin", "hin")
						  .createAlias("Hospital","h")
						  .add(Restrictions.eq("hin.Id", hinId)) 
						  .add(Restrictions.eq("h.Id", hospitalId)) 
						  .addOrder(Order.desc("id"))
						  .setMaxResults(1).list();		
				
			}
			anesthesiaList = session.createCriteria(MasAnesthesia.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		/*	BloodMasComponentList=session.createCriteria(BloodMasComponent.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();*/
	/*		doctorList=session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.eq("EmpCategory.Id", 1)).list();*/
			if (patientPrescriptionHeaderList != null
					&& patientPrescriptionHeaderList.size() > 0) {
				PatientPrescriptionHeader patientPrescriptionHeader = (PatientPrescriptionHeader) patientPrescriptionHeaderList
						.get(0);
				int prescriptionId = patientPrescriptionHeader.getId();
				patientPrescriptionDetailList = session
						.createCriteria(PatientPrescriptionDetails.class)
						.createAlias("Prescription", "prescriptionId")
						.add(Restrictions.eq("prescriptionId.Id",
								prescriptionId)).list();
			}
			
			String tempCode = HMSUtil.getValuesFromPropertiesFile("adt.properties", "templateCodeForComplaintHistory");
			
			medicalHistoryTemplate =  session.createCriteria(PatientFamilyHistory.class).add(
					Restrictions.eq("Status", "y"))
					.add(Restrictions.eq("DepartmentId.Id", departmentId))
					.add(Restrictions.eq("TemplateCode", tempCode)).addOrder(Order.asc("PatientPresentComplaintName")).list();
							
			
			List<PatientMedicalHistory>  PatientMedicalHistory = new ArrayList<PatientMedicalHistory>();
			
			/*PatientMedicalHistory =  session.createCriteria(PatientMedicalHistory.class)
					.createAlias("PatientFamilyHistory","pfh")
					.createAlias("Hin", "hin")
					  .add(Restrictions.eq("hin.Id", hinId)) 
					.list();
			*/
			
			PatientMedicalHistory =  session.createCriteria(PatientMedicalHistory.class)
					  .add(Restrictions.eq("Hin.Id", hinId)) 
					.list();
			map.put("PatientMedicalHistory", PatientMedicalHistory);
			
			
			List <OpdSurgeryDetail> osdList =  new ArrayList <OpdSurgeryDetail>();
			
			String []pac_status = {"RC", "CR","OP"};
			osdList =  session.createCriteria(OpdSurgeryDetail.class)
					   .createAlias("OpdSurgery", "oph")
					   .add(Restrictions.eq("oph.Id", opdSurgeryHeader.getId()))
					   .add(Restrictions.in("AnestheisaPacStatus",pac_status))
					   .list();
			
	
					  //.add(Restrictions.in("Id", surgeryDtList )).list();  
			
	/*		OtPreAnesthesiaDetailsList = session.createCriteria(OtPreAnesthesiaDetails.class).add(Restrictions.eq("Hin.Id", opdSurgeryHeader.getHin().getId()))
					.add(Restrictions.ne("Visit.Id",visitId ))
					.list();
			for(OtPreAnesthesiaDetails OtPreAnesthesiaDetails:OtPreAnesthesiaDetailsList){
				anesthesia=anesthesia+","+OtPreAnesthesiaDetails.getAnashteicDetails();
			}
			
			OtPreAnesthesiaDetailsList.clear();*/
			if(osdList.size() > 0 )
			OtPreAnesthesiaDetailsList = session.createCriteria(OtPreAnesthesiaHd.class).add(Restrictions.eq("Id", osdList.get(0).getAnestheisaPac().getAnesthesiaHd().getId())).list();
			
			
			List<DgOrderdt > orderDtList = new ArrayList<DgOrderdt>();
			List<Integer> orderDtIdList =   new ArrayList<Integer>(); 
			if(OtPreAnesthesiaDetailsList.size() >0)
			{
				
				
				List<OtPreAnesthesiaDetail> procedureListForConsultation = session.createCriteria(OtPreAnesthesiaDetail.class).add(Restrictions.eq("AnesthesiaHd.Id", osdList.get(0).getAnestheisaPac().getAnesthesiaHd().getId())).list();
				
				String pacCode = HMSUtil.getProperties("adt.properties", "CodeForOTPAC");

			
				orderDtList = session.createCriteria(DgOrderdt.class)
						.createAlias("Orderhd", "hd")
						.createAlias("hd.Visit", "v")
						.add(Restrictions.eq("v.Id", visitId)).add(Restrictions.eq("OtStage", pacCode).ignoreCase())
						.list();
				map.put("orderDtList",orderDtList);	
				
				for(DgOrderdt dt: orderDtList)
				{
					orderDtIdList.add(dt.getId());
				}
				
				if(orderDtList.size() >0)
				{
				List<DgSampleCollectionDetails> dgSampleCollectionDetailsList = new ArrayList<DgSampleCollectionDetails>();
				dgSampleCollectionDetailsList = session.createCriteria(DgSampleCollectionDetails.class)
						           .add(Restrictions.in("Orderdt.Id", orderDtIdList))
						.list();
				map.put("dgSampleCollectionDetailsList",dgSampleCollectionDetailsList);
				
				}
				
			//if(OtPreAnesthesiaDetailsList.get(0).getConsultOtherDoctor().equalsIgnoreCase("y")){
				
				List<PreAnesthesiaConsultDoctorDt> consultList = new ArrayList<PreAnesthesiaConsultDoctorDt>();
				consultList = session.createCriteria(PreAnesthesiaConsultDoctorDt.class)
						.createAlias("ConsultDoctorIdHd", "hd")
						.createAlias("hd.OtPreAnesthesiaHd", "pachd")
						.add(Restrictions.eq("pachd.Id", osdList.get(0).getAnestheisaPac().getAnesthesiaHd().getId()))
						.addOrder(Order.desc("ConsultDate"))
						.addOrder(Order.desc("ConsultTime"))
						.list();
				map.put("consultList",consultList);
				//System.out.println("vvx"+consultList.size() +" ff "+osdList.get(0).getAnestheisaPac().getAnesthesiaHd().getId());
			//}
			
			
			
			int otPreAnesthesiaDetailsId = OtPreAnesthesiaDetailsList.get(0).getId();
			map.put("otPreAnesthesiaDetailsId",otPreAnesthesiaDetailsId);
			map.put("procedureListForConsultation",procedureListForConsultation);	
			}
			
			
			templateList = session.createCriteria(OpdTemplate.class)
					.createAlias("Department", "dept").add(Restrictions.eq("dept.Id", departmentId))
					.createAlias("Hospital", "hosp").add(Restrictions.eq("hosp.Id", hospitalId))
					.createAlias("Doctor", "doctor").add(Restrictions.eq("doctor.Id", docId))
					.add(Restrictions.eq("TemplateType", "I"))
					.add(Restrictions.eq("Status", "y")).list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("anesthesiaList", anesthesiaList);
		map.put("opdSurgeryList", opdSurgeryList);
		map.put("opdPatientHistoryList", opdPatientHistoryList);
		map.put("patientPrescriptionDetailList", patientPrescriptionDetailList);
		//map.put("BloodMasComponentList",BloodMasComponentList);
		//map.put("doctorList",doctorList);
		map.put("patientDetailsList",patientDetailsList);
		map.put("anesthesia",anesthesia);
		//map.put("instituteDepartmentList",instituteDepartmentList);
		map.put("icd", icd);
		map.put("medicalHistoryTemplate", medicalHistoryTemplate);
		map.put("wardDepartment",wardDepartment);
		map.put("deptList",deptList);
		map.put("OtPreAnesthesiaDetailsList",OtPreAnesthesiaDetailsList);
		map.put("templateList",templateList);
		
	
		
		
		return map;
		/*Session session = (Session) getSession();
		List<OpdSurgeryHeader> opdSurgeryList = new ArrayList<OpdSurgeryHeader>();
		List<OtPreAnesthesiaDetails> otPreAnesthesiaDetailsList = new ArrayList<OtPreAnesthesiaDetails>();

		List<OpdPatientHistory> opdPatientHistoryList = new ArrayList<OpdPatientHistory>();
		List<PatientPrescriptionHeader> patientPrescriptionHeaderList = new ArrayList<PatientPrescriptionHeader>();
		List<PatientPrescriptionDetails> patientPrescriptionDetailList = new ArrayList<PatientPrescriptionDetails>();
		List<Integer> maxVisitFromPatientPresList = new ArrayList<Integer>();
		Map<String, Object> map = new HashMap<String, Object>();

		int opdSurgeryId = (Integer) mapForDS.get("opdSurgeryId");
		int todaySeqNo = (Integer) mapForDS.get("todaySeqNo");
		Date currentDate = new Date();
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String date4MySQL = formatterOut.format((currentDate));
		java.sql.Date startDate = java.sql.Date.valueOf(date4MySQL);

		try {
			opdSurgeryList = session.createCriteria(OpdSurgeryHeader.class)
					.add(Restrictions.eq("Id", opdSurgeryId)).list();
			OpdSurgeryHeader opdSurgeryHeader = (OpdSurgeryHeader) opdSurgeryList.get(0);

			int orderNo = opdSurgeryHeader.getOrderNo();
			otPreAnesthesiaDetailsList = session.createCriteria(OtPreAnesthesiaDetails.class).add(
					Restrictions.eq("OrderNo", orderNo)).list();
			if (opdSurgeryHeader.getPatientStatus().equalsIgnoreCase("Out Patient")) {

				int visitId = opdSurgeryHeader.getVisit().getId();

				opdPatientHistoryList = session.createCriteria(OpdPatientHistory.class).add(
						Restrictions.eq("VisitInpatientId", visitId)).list();
				patientPrescriptionHeaderList = session.createCriteria(PatientPrescriptionHeader.class).
						createAlias("Visit","visit").add(Restrictions.eq("visit.Id", visitId)).list();
			} else {
				int hinId = opdSurgeryHeader.getHin().getId();
				int inpatientId = opdSurgeryHeader.getInpatient().getId();
				Criteria crit = session.createCriteria(OpdPatientHistory.class)
						.add(Restrictions.eq("VisitInpatientId", inpatientId));
				opdPatientHistoryList = crit.list();

				Criteria criteria = session.createCriteria(PatientPrescriptionHeader.class).
						createAlias("Hin","hin").add(Restrictions.eq("hin.Id", hinId))
						.createAlias("Visit", "visit");
				ProjectionList projectionList = Projections.projectionList();
				projectionList.add(Projections.max("visit.Id"));
				criteria.setProjection(projectionList);
				maxVisitFromPatientPresList = criteria.list();
				if (maxVisitFromPatientPresList.get(0) != null	&& maxVisitFromPatientPresList.size() > 0) {
					int visitId = (Integer) maxVisitFromPatientPresList.get(0);
					patientPrescriptionHeaderList = session.createCriteria(
							PatientPrescriptionHeader.class).createAlias(
							"Visit", "visit").add(Restrictions.eq("visit.Id", visitId)).list();
				}

			}
			if (patientPrescriptionHeaderList != null
					&& patientPrescriptionHeaderList.size() > 0) {
				PatientPrescriptionHeader patientPrescriptionHeader = (PatientPrescriptionHeader) patientPrescriptionHeaderList
						.get(0);
				int prescriptionId = patientPrescriptionHeader.getId();
				patientPrescriptionDetailList = session.createCriteria(
						PatientPrescriptionDetails.class).createAlias("Prescription", "prescriptionId")
						.add(Restrictions.eq("prescriptionId.Id", prescriptionId)).list();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		List<Integer> otSeqList = new ArrayList<Integer>();
		otSeqList = session.createCriteria(OtPreAnesthesiaDetails.class).add(
				Restrictions.eq("ChangedDate", startDate)).setProjection(Projections.projectionList().add(Projections
						.max("SlNo"))).list();
		if (otSeqList.size() > 0) {
			for (Integer maxOrderNo : otSeqList) {
				if ( maxOrderNo != null) {
					todaySeqNo = maxOrderNo + 1;
				} else {
					todaySeqNo = Integer.valueOf(1);
				}
			}
		} else {
			todaySeqNo = 1;
		}
		map.put("todaySeqNo", todaySeqNo);
		map.put("opdSurgeryList", opdSurgeryList);
		map.put("otPreAnesthesiaDetailsList", otPreAnesthesiaDetailsList);
		map.put("opdPatientHistoryList", opdPatientHistoryList);
		map.put("patientPrescriptionDetailList", patientPrescriptionDetailList);

		return map;*/
	}
	@Override
	public Map<String, Object> showAllergy(Box box, Map<String, Object> dataMap) {
		 Session session = (Session) getSession();
		    Map<String, Object> map = new HashMap<String, Object>();
		    int requestId=0;
		    if(box.get("requestId")!=null){
				requestId = Integer.parseInt(""+box.get("requestId"));}
	/*	    List<OpdPatientAllergyM> allergyMs=new ArrayList<OpdPatientAllergyM>();
		    List<OpdPatientAllergyT> allergyTs=new ArrayList<OpdPatientAllergyT>();
		    int requestId=0;
		 
		    System.out.println("requestId"+requestId);
				allergyTs=session.createCriteria(OpdPatientAllergyT.class,"allergyT")
						.createAlias("allergyT.OpdPatientAllergy", "allergyM")
					//	.createAlias("allergyM.Inpatient", "ip")
						.createAlias("allergyM.Hin", "hin")
						.add(Restrictions.eq("hin.Id", requestId)).list();*/
				
				List<AllergyDetail> allergyDetailsList = new ArrayList<AllergyDetail>();
				allergyDetailsList = session.createCriteria(AllergyDetail.class).createAlias("Hin", "hin").add(Restrictions.eq("hin.Id", requestId)).list();
				
				//List<MasAllergyType> allergyTypeList = new ArrayList<MasAllergyType>();
				//allergyTypeList = session.createCriteria(MasAllergyType.class).add(Restrictions.eq("Status", "y")).list();
				map.put("allergyTs", allergyDetailsList);
				
		return map;
	}

	public Map<String, Object> getInvestigationDetails(Map mapForDS) {
		Session session = (Session) getSession();
		List<DgOrderhd> dgOrderHList = new ArrayList<DgOrderhd>();
		List<DgSampleCollectionHeader> dgSampleCollectionList = new ArrayList<DgSampleCollectionHeader>();
		List<DgResultEntryHeader> dgResultEntryList = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();
		Map<String, Object> map = new HashMap<String, Object>();
		String patientStatus = (String) mapForDS.get("patientStatus");
		int hinId = (Integer) mapForDS.get("hinId");

		List resultEntryDetailList = new ArrayList();
		try {
			if (patientStatus.equals("Out Patient")) {
				int visitId = (Integer) mapForDS.get("visitId");
				dgOrderHList = session.createCriteria(DgOrderhd.class)
						.createAlias("Hin", "hin")
						.createAlias("Visit", "visit").add(
								Restrictions.eq("hin.Id", hinId)).add(
								Restrictions.eq("visit.Id", visitId)).list();
			} else {
				int inpatientId = (Integer) mapForDS.get("inpatientId");
				dgOrderHList = session.createCriteria(DgOrderhd.class)
						.createAlias("Hin", "hin").createAlias("Inpatient",
								"inpatient").add(
								Restrictions.eq("hin.Id", hinId)).add(
								Restrictions.eq("inpatient.Id", inpatientId))
						.list();
			}
			// //System.out.println("dgOrderHList----------------"+dgOrderHList.size());
			if (dgOrderHList != null && dgOrderHList.size() > 0) {
				DgOrderhd dgOrderhd = (DgOrderhd) dgOrderHList.get(0);
				int dgOrderhdId = dgOrderhd.getId();
				dgSampleCollectionList = session.createCriteria(
						DgSampleCollectionHeader.class).createAlias("Order",
						"order").add(Restrictions.eq("order.Id", dgOrderhdId))
						.list();

				DgSampleCollectionHeader dgSampleCollectionHeader = (DgSampleCollectionHeader) dgSampleCollectionList
						.get(0);
				int dgSampleColectionHeaderId = dgSampleCollectionHeader
						.getId();

				dgResultEntryList = session.createCriteria(
						DgResultEntryHeader.class).createAlias(
						"SampleCollectionHeader", "sampleCollectionHeader")
						.add(
								Restrictions.eq("sampleCollectionHeader.Id",
										dgSampleColectionHeaderId)).list();
				// //System.out.println("dgResultEntryList----------------"+dgResultEntryList.size());
				Iterator itr = dgResultEntryList.iterator();
				while (itr.hasNext()) {
					DgResultEntryHeader dgResultEntryHeader = (DgResultEntryHeader) itr
							.next();
					int dgResultEntryHeaderId = dgResultEntryHeader.getId();

					dgResultEntryDetailList = session.createCriteria(
							DgResultEntryDetail.class).createAlias(
							"ResultEntry", "resultEntry").add(
							Restrictions.eq("resultEntry.Id",
									dgResultEntryHeaderId)).list();
					resultEntryDetailList.add(dgResultEntryDetailList);
				}

			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		// //System.out.println("u rin resultEntryDetailList list method with list size----"+resultEntryDetailList.size());
		map.put("resultEntryDetailList", resultEntryDetailList);
		map.put("dgOrderHList", dgOrderHList);
		map.put("patientStatus", patientStatus);

		return map;
	}

	@SuppressWarnings("unused")
	public Map<String, Object>  submitPreAnesthesiaDetails(Map mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		boolean succesfullyAdded = false;
		Transaction tx = null;
		Box box = (Box) mapForDS.get("box");
		//List<OpdPatientHistory> opdPatientHistoryList = new ArrayList<OpdPatientHistory>();
		List<OpdSurgeryHeader> opdSurgeryList = new ArrayList<OpdSurgeryHeader>();
		List<OpdSurgeryHeader> opdSurgeryHeaderList = new ArrayList<OpdSurgeryHeader>();

		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			int deptId = box.getInt("deptId");
			int hinId = box.getInt("hinId");
			int hospitalId = (Integer) mapForDS.get("hospitalId");
			int visitId = box.getInt("visitId");
			int inpatientId = box.getInt("inPatientId");
			int userId = (Integer) mapForDS.get(USER_ID);
			int surgeryId =  box.getInt("surgerId");
			String patientStatus = box.getString("patientStatus");
			String summary="";
			int pendingDocId = 0;
			int pendingDeptId = 0;
			int consultDocId = 0;
			int consultDeptId = 0;
			String Remarks="";
			String arrangeBed1="";
			int wardName=0;
			String vent="";
			String remarksForBedArrangement="";
			String patientPosition="";
			String[] CareOf=null;
			int docId = 0;
			String fitForSurgery = box
			.getString("fitForSurgery");
			
			String surgeryDtStringArrary[] = (String[]) mapForDS.get("surgeryDtStringArrary");
			
			List<Integer> surgeryDtList = new ArrayList<Integer>();
			for(int a = 0 ; a<surgeryDtStringArrary.length; a++)
			{
				surgeryDtList.add(Integer.parseInt(surgeryDtStringArrary[a]));
			}
			
			
			if(mapForDS.get(EMPLOYEE_ID)!=null){
				docId=(Integer)mapForDS.get(EMPLOYEE_ID);
			}
			
			
			if(mapForDS.get("careOf")!=null){
				CareOf=(String[])mapForDS.get("careOf");
			}
			String careOf="";
			if(CareOf!=null && CareOf.length>0){
			for(String str:CareOf){
				if(str!=null && !str.equals("")){
				careOf+=""+str;
				}
			}
			}
			int unitForBloodComponent=0;
			if(box.getInt("unitForBloodComponent")!=0){
				unitForBloodComponent=box.getInt("unitForBloodComponent");
			}
			if(box.get("patientPosition")!=null){
				patientPosition=box.get("patientPosition");
			}
			
			if(box.get("arrangeBed1")!=null){
				arrangeBed1=box.get("arrangeBed1");
			}
			if(box.get("vent")!=null){
				vent=box.get("vent");
			}
			if(box.get("remarksForBedArrangement")!=null){
				remarksForBedArrangement=box.get("remarksForBedArrangement");
			}
			if(box.get("wardName")!=null && !box.get("wardName").equals("0")){
				wardName=box.getInt("wardName");
			}
			summary=box.getString("summary");
			String asaRisk = box.getString("asaRisk");
			if(box.getInt("pendingDeptName")!=0){
				pendingDeptId=box.getInt("pendingDeptName");
			}
			
			if(box.getInt("pendingDocName")!=0){
				pendingDocId=box.getInt("pendingDocName");
			}
			if(box.getString("remarks")!=null){
				Remarks=box.getString("remarks");
			}
			
			String referConsult = box.getString("refer_consult");
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String consultationTime = (String)utilMap.get("currentTimeWithoutSc");
			String consultationDate = (String) utilMap.get("currentDate");
			Date consultationDateToInsert = HMSUtil
					.convertStringTypeDateToDateType(consultationDate);
			
			//OpdPatientHistory opdPatientHistory = new OpdPatientHistory();
			OtPreAnesthesiaHd OtPreAnesthesiahd = new OtPreAnesthesiaHd();
		//	otPreAnesthesiaDetails.setBedArrangement(arrangeBed1);
			//otPreAnesthesiaDetails.setBedFlag(vent);
			//otPreAnesthesiaDetails.setRemarksBedArrangement(remarksForBedArrangement);
			//otPreAnesthesiaDetails.setCareOf(careOf);
		//	otPreAnesthesiaDetails.setPatientPosition(patientPosition);
			if(wardName!=0){
			MasDepartment dept=new MasDepartment();
			dept.setId(wardName);
			
			//otPreAnesthesiaDetails.setWard(dept);
			}
	
			
	/*		if(fitForSurgery!=null  && fitForSurgery.equalsIgnoreCase("n"))
			{
				if(pendingDeptId!=0){
					MasDepartment md1=new MasDepartment();
					md1.setId(pendingDeptId);
					otPreAnesthesiaDetails.setPendingDept(md1);
					}
				if(pendingDocId!=0){
				MasEmployee me1=new MasEmployee();
				me1.setId(pendingDocId);
				otPreAnesthesiaDetails.setPendingDoctor(me1);
				}
			}*/
			
			OtPreAnesthesiahd.setConsultOtherDoctor(referConsult);
		
			if(referConsult!=null  && referConsult.equalsIgnoreCase("n"))
			{
				OtPreAnesthesiahd.setFitForSurgery(fitForSurgery);
				OtPreAnesthesiahd.setReviewQp(box.get("reviewqp"));
				OtPreAnesthesiahd.setReviewBp(box.get("reviewbp"));
				OtPreAnesthesiahd.setReviewCvs(box.get("reviewcvs"));
				OtPreAnesthesiahd.setReviewRs(box.get("reviewrs"));
				OtPreAnesthesiahd.setReviewComplaints(box.get("review_complaints"));
				OtPreAnesthesiahd.setOther(summary);
				OtPreAnesthesiahd.setAsaRisk(asaRisk);
				OtPreAnesthesiahd.setRemark(Remarks);
				//here
			}
			
			//OpdSurgeryHeader opdSurgeryHeaderObj = new OpdSurgeryHeader();
			//String []pacStatus = {"Requested for consultation","pending", "Consultation received"};
				
			if (patientStatus.equalsIgnoreCase("Out Patient")) {
				/* opdPatientHistory.setVisitInpatientId(box.getInt("visitId")); */
				Visit visit = new Visit();
				visit.setId(visitId);
				OtPreAnesthesiahd.setVisit(visit);
				// opdSurgeryList =
				// session.createCriteria(OpdSurgeryHeader.class)
				// .createAlias("Visit", "visit")
				// .add(Restrictions.eq("visit.Id", visitId))
				// .add(Restrictions.eq("Hospital.Id", hospitalId))
				// .add(Restrictions.eq("PacStatus", "pending")).list();

				// changed for order id
				opdSurgeryList = session
						.createCriteria(OpdSurgeryHeader.class)
						.createAlias("Visit", "visit")
						.add(Restrictions.eq("visit.Id", visitId))
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("OrderNo", box.getInt("orderNo")))
					//	.add(Restrictions.eq("PacStatus", "pending").ignoreCase()).list();
						//.add(Restrictions.in("PacStatus", pacStatus)).
						.list();
						
								
			//	OpdSurgeryHeader opdSurgeryHeader = opdSurgeryList.get(0);
			//	int id = opdSurgeryHeader.getId();
				/*opdSurgeryHeaderObj = (OpdSurgeryHeader) hbt.load(
						OpdSurgeryHeader.class, surgeryId);*/
	
/*			if(fitForSurgery.equalsIgnoreCase("y"))	
			{
				opdSurgeryHeaderObj.setPacStatus("Cleared");
			}
			else
			{
				opdSurgeryHeaderObj.setPacStatus("Not Cleared");
			}
			
			hbt.update(opdSurgeryHeaderObj);*/
				
			} else {
				// opdPatientHistory.setVisitInpatientId(box.getInt("inPatientId"));
				Visit visit = new Visit();
				visit.setId(visitId);
				OtPreAnesthesiahd.setVisit(visit);
				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				OtPreAnesthesiahd.setInpatient(inpatient);
				// List otPreList=session.createQuery("select ot from
				// OtPreAnesthesiaDetails as ot where
				// ot.Inpatient.Id='"+inpatientId+"' and ot.ChangedDate=(select
				// max(ot.ChangedDate) from OtPreAnesthesiaDetails as ot where
				// ot.Inpatient.Id='"+inpatientId+"')").list();
				// OtPreAnesthesiaDetails
				// otObj=(OtPreAnesthesiaDetails)otPreList.get(0);
		/*		opdPatientHistoryList = session
						.createCriteria(OpdPatientHistory.class)
						.createAlias("Hin", "hin")
						.add(Restrictions.eq("hin.Id", hinId))
						.add(Restrictions.eq("VisitInpatientId", inpatientId))
						.list();*/
				// List opdSurgeryHList = session
				// .createQuery(
				// "select ot from OpdSurgeryHeader as ot  where ot.Inpatient.Id='"
				// + inpatientId
				// +
				// "' and ot.RequisitionDate=(select max(ot.RequisitionDate) from OpdSurgeryHeader as ot where ot.Inpatient.Id='"
				// + inpatientId + "')").list();

				// changed for order id
		/*		opdSurgeryList = session
						.createCriteria(OpdSurgeryHeader.class)
						.createAlias("Inpatient", "inpatient")
						.add(Restrictions.eq("inpatient.Id", inpatientId))
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("OrderNo", box.getInt("orderNo")))
											//	.add(Restrictions.eq("PacStatus", "pending").ignoreCase()).list();
						.add(Restrictions.in("PacStatus", pacStatus)).list();

				OpdSurgeryHeader opdObj = (OpdSurgeryHeader) opdSurgeryList
						.get(0);
				int opdId = opdObj.getId();*/
				
			/*	opdSurgeryHeaderObj = (OpdSurgeryHeader) hbt.load(
						OpdSurgeryHeader.class, surgeryId);*/

/*			if(fitForSurgery.equalsIgnoreCase("y"))	
			{
				opdSurgeryHeaderObj.setPacStatus("Cleared");
			}
			else
			{
				opdSurgeryHeaderObj.setPacStatus("Not Cleared");
			}
			
			hbt.update(opdSurgeryHeaderObj);*/
			
			
			 }
		
	/*		if (opdPatientHistoryList != null
					&& opdPatientHistoryList.size() > 0) {

				OpdPatientHistory opdPatientHistoryObj = opdPatientHistoryList
						.get(0);
				int opdPatientHistoryId = opdPatientHistoryObj.getId();
				OpdPatientHistory opdPatientHistory2 = (OpdPatientHistory) hbt
						.load(OpdPatientHistory.class, opdPatientHistoryId);
				opdPatientHistory2.setPersonalPresentHistory(box
						.getString("presentHistory"));
				opdPatientHistory2.setPersonalPastHistory(box
						.getString("pastHistory"));
				hbt.update(opdPatientHistory2);

			} else {
				// OpdPatientHistory opdPatientHistory1 = new
				// OpdPatientHistory();
				// if (patientStatus.equalsIgnoreCase("OutPatient")) {
				// opdPatientHistory.setVisitInpatientId(box
				// .getInt("visitId"));
				// } else {
				// opdPatientHistory.setVisitInpatientId(box
				// .getInt("inPatientId"));
				// }
				// Patient patient = new Patient();
				// patient.setId(hinId);
				// opdPatientHistory.setHin(patient);
				// MasDepartment masDepartment = new MasDepartment();
				// masDepartment.setId(deptId);
				// opdPatientHistory.setDepartment(masDepartment);
				// opdPatientHistory.setPersonalPresentHistory(box
				// .getString("pastHistory"));
				// opdPatientHistory.setPersonalPastHistory(box
				// .getString("presentHistory"));
				// MasHospital masHospital = new MasHospital();
				// masHospital.setId(hospitalId);
				// opdPatientHistory.setHospital(masHospital);
				// opdPatientHistory.setLastChgBy(box.getString("changedBy"));
				// opdPatientHistory.setLastChgDate(HMSUtil
				// .convertStringTypeDateToDateType(box
				// .getString("changedDate")));
				// opdPatientHistory.setLastChgTime(box.getString("changedTime"));
				// opdPatientHistory.setStatus("y");
				// opdPatientHistory.setIpOpPacStatus("PAC");
				// hbt.save(opdPatientHistory1);

				// changed by mritunjay
				if (patientStatus.equalsIgnoreCase("Out Patient")) {
					opdPatientHistory
							.setVisitInpatientId(visitId);
				} else {
					opdPatientHistory.setVisitInpatientId(box
							.getInt("inPatientId"));
				}
				Patient patient = new Patient();
				patient.setId(hinId);
				opdPatientHistory.setHin(patient);
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				opdPatientHistory.setDepartment(masDepartment);
				opdPatientHistory.setPersonalPresentHistory(box
						.getString("pastHistory"));
				opdPatientHistory.setPersonalPastHistory(box
						.getString("presentHistory"));
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				opdPatientHistory.setHospital(masHospital);
				Users users = new Users();
				users.setId(userId);
				//opdPatientHistory.setLastChgBy(userId);
				opdPatientHistory.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("changedDate")));
				opdPatientHistory.setLastChgTime(box.getString("changedTime"));
				opdPatientHistory.setStatus("y");
				opdPatientHistory.setIpOpPacStatus("PAC");
				hbt.save(opdPatientHistory);
			}
*/
			Patient patientObj = new Patient();
			patientObj.setId(hinId);
			MasDepartment masDepartmentObj = new MasDepartment();
			masDepartmentObj.setId(deptId);
			MasHospital masHospitalObj = new MasHospital();
			masHospitalObj.setId(hospitalId);
	/*		int anesId = box.getInt("anaestheticName");
			if (anesId != 0) {
				MasEmployee me = new MasEmployee();
				me.setId(anesId);
				otPreAnesthesiaDetails.setAnesthetic(me);
			}*/
			//otPreAnesthesiaDetails.setSmokingAlcohol(box.getString("smoking"));
		
			OtPreAnesthesiahd.setWeight(box.getString("weight"));
			OtPreAnesthesiahd.setBp(box.getString("bp"));
			OtPreAnesthesiahd.setPulse(box.getString("pulse"));
			OtPreAnesthesiahd.setPr(box.getString("pr"));
			
			OtPreAnesthesiahd.setPallor(box.getString("pallor"));
			OtPreAnesthesiahd.setCyanosis(box.getString("cyanosis"));
			//otPreAnesthesiaDetails.setClubbing(box.getString("clubbing"));
			OtPreAnesthesiahd.setIcetrus(box.getString("icetrus"));
			OtPreAnesthesiahd.setOedema(box.getString("oedema"));
			OtPreAnesthesiahd.setSpine(box.getString("spine"));
			//otPreAnesthesiaDetails.setThyroid(box.getString("thyroid"));
			OtPreAnesthesiahd.setNourishment(box.getString("nourishment"));
			OtPreAnesthesiahd.setBp(box.getString("bp"));
			OtPreAnesthesiahd.setAirway(box.getString("airway"));
			OtPreAnesthesiahd.setVenousAccess(box.getString("venous"));
			//otPreAnesthesiaDetails.setBreathSound(box.getString("breath"));
		//	otPreAnesthesiaDetails.setAdvSound(box.getString("advance"));
			OtPreAnesthesiahd.setAbdomen(box.getString("abdomen"));
			//otPreAnesthesiaDetails.setLiver(box.getString("liver"));
			OtPreAnesthesiahd.setSpleen(box.getString("spleen"));
			OtPreAnesthesiahd.setIcetrus(box.getString("icterus"));
		//	otPreAnesthesiaDetails.setAsaGrade(box.getString("asa"));
		//	otPreAnesthesiaDetails.setBlood(box.getString("blood"));
		//	otPreAnesthesiaDetails.setUnit(unitForBloodComponent);
			/*otPreAnesthesiaDetails.setHairPin(box.getString("hairPin"));
			otPreAnesthesiaDetails.setJewelStatus(box.getString("jewelName"));*/
			//otPreAnesthesiaDetails.setInstructions(box.getString("instructions"));
					

			//otPreAnesthesiaDetails.setS1(box.getString("s1"));
			//otPreAnesthesiaDetails.setS2(box.getString("s2"));
			//otPreAnesthesiaDetails.setS3(box.getString("s3"));
			//otPreAnesthesiaDetails.setS4(box.getString("s4"));
			OtPreAnesthesiahd.setOrderNo(box.getInt("orderNo"));
			OtPreAnesthesiahd.setHin(patientObj);

			OtPreAnesthesiahd.setDepartment(masDepartmentObj);
			OtPreAnesthesiahd.setHospital(masHospitalObj);
			OtPreAnesthesiahd.setPacDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString("changedDate")));
			Users users = new Users();
			users.setId(userId);
			
			/*added for HAL*/
			OtPreAnesthesiahd.setKoilonychia(box.get("koilonychia"));
			OtPreAnesthesiahd.setLymphadenopathy(box.get("lymphadenopathy"));
			OtPreAnesthesiahd.setMpc(box.get("mpc"));
			OtPreAnesthesiahd.setTmd(box.get("tmd"));
			OtPreAnesthesiahd.setTmj(box.get("tmj"));
			OtPreAnesthesiahd.setMo(box.get("mo"));
			OtPreAnesthesiahd.setEco(box.get("eco"));
			OtPreAnesthesiahd.setEcg(box.get("ecg"));
			OtPreAnesthesiahd.setChestXray(box.get("chestxray"));
			OtPreAnesthesiahd.setTeeth(box.get("teeth"));
			OtPreAnesthesiahd.setCvs(box.get("cvs"));
			OtPreAnesthesiahd.setRs(box.get("rs"));
			OtPreAnesthesiahd.setCns(box.get("cns"));
			OtPreAnesthesiahd.setAddtionalRemarks(box.get("additional_remarks"));
			OtPreAnesthesiahd.setReviewComplaints(box.get("review_complaints"));
			OtPreAnesthesiahd.setReviewQp(box.get("reviewqp"));
			OtPreAnesthesiahd.setReviewBp(box.get("reviewbp"));
			OtPreAnesthesiahd.setReviewCvs(box.get("reviewcvs"));
			OtPreAnesthesiahd.setReviewRs(box.get("reviewrs"));
			OtPreAnesthesiahd.setPreviousAnesthetics(box.get("anestheticDetails"));
			
			//otPreAnesthesiaDetails.setChangedBy(users);
			OtPreAnesthesiahd.setChangedDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString("changedDate")));
			OtPreAnesthesiahd.setChangedTime(box.getString("changedTime"));
			OtPreAnesthesiahd.setPatientType(box.get("patientType"));
			/*
			 * MasAnesthesia masAnesthesia=new MasAnesthesia();
			 * masAnesthesia.setId(box.getInt("grade"));
			 * otPreAnesthesiaDetails.setAnesthticTechnique(masAnesthesia);
			 */
			//String anaestheticPlanned = box.getString("anaesthicPlanned");
			String anaestheticPlanned = box.getString("grade1");
			String anaestheticPlannedTemp = "";
			OtPreAnesthesiahd.setConsentStatus("n");
	/*		anaestheticPlannedTemp = anaestheticPlanned.substring(
					anaestheticPlanned.length() - 1,
					anaestheticPlanned.length());
			if (anaestheticPlannedTemp.equals(",")) {
				anaestheticPlanned = anaestheticPlanned.substring(0,
						anaestheticPlanned.length() - 1);
			}
*/
			OtPreAnesthesiahd.setAnashteicDetails(anaestheticPlanned);
			//otPreAnesthesiaDetails.setDrugTreatment(box.getString("drugTherapy"));
			OpdSurgeryHeader opdSurgeryHeader = new OpdSurgeryHeader();
			opdSurgeryHeader = (OpdSurgeryHeader) hbt.load(
					OpdSurgeryHeader.class, surgeryId);
			
			//OtPreAnesthesiahd.setOpdSurgeryHeader(opdSurgeryHeader);
			OtPreAnesthesiahd.setStatus("n");
			hbt.save(OtPreAnesthesiahd);
			
			int OtPreAnesthesiahdId = OtPreAnesthesiahd.getId();
			map.put("otPreAnesthesiahdId", OtPreAnesthesiahdId);
			
			//save here
			if(referConsult!=null  && referConsult.equalsIgnoreCase("y"))
			{
				if(box.getInt("refereddept")!=0){
					consultDeptId=box.getInt("refereddept");
					consultDocId=box.getInt("refereddoctor");
				}
				
				//OpdSurgeryDetail osd = new OpdSurgeryDetail();
				
				List <OpdSurgeryDetail> osdList =  new ArrayList <OpdSurgeryDetail>();
			
				osdList =  session.createCriteria(OpdSurgeryDetail.class)
						  .add(Restrictions.in("Id", surgeryDtList )).list();
				for(OpdSurgeryDetail osd: osdList)
				{
					osd.setAnestheisaPacStatus("RC");
					hbt.save(osd);
				}
		/*		opdSurgeryHeader = (OpdSurgeryHeader) hbt.load(
						OpdSurgeryHeader.class, surgeryId);
				opdSurgeryHeader.setPacStatus("Requested for consultation");
				hbt.update(opdSurgeryHeader);*/
				
				opdSurgeryHeader.setId(surgeryId);
				PreAnesthesiaConsultDoctorHd consulthd = new PreAnesthesiaConsultDoctorHd();
				consulthd.setOtPreAnesthesiaHd(OtPreAnesthesiahd);
				MasHospital masHospital = new MasHospital();
				 masHospital.setId(hospitalId);
				consulthd.setHospital(masHospital);
				hbt.save(consulthd);

				int totalReferDepartment = box.getInt("hiddenValueRefer");
				 PreAnesthesiaConsultDoctorDt consultdt = null;
				 MasDepartment  md1= null;
				 MasEmployee me1 =null;
					
				 for(int i=1;i<=totalReferDepartment;i++){
					 if(box.get("referral_notes"+i)!=null && !box.getString("referral_notes"+i).isEmpty()){
						 
					 consultdt = new PreAnesthesiaConsultDoctorDt();
				 consultdt.setConsultDoctorIdHd(consulthd);
				 md1=new MasDepartment();
					md1.setId(box.getInt("refereddept"+i));
				 consultdt.setConsultedDepartment(md1);
				 consultdt.setReferralNotes(box.getString("referral_notes"+i));
				if(box.getInt("refereddoctor"+i)!=0){	
				  me1=new MasEmployee();
					me1.setId(box.getInt("refereddoctor"+i));
				 consultdt.setConsultedDoctor(me1);
				}
				 consultdt.setConsultDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.getString("changedDate")));
				 consultdt.setConsultTime(box.getString("changedTime"));
				  hbt.save(consultdt);
					 }
				 }
				  
			}
			else if(inpatientId==0)
			{
			
				//OpdSurgeryDetail osd = new OpdSurgeryDetail();
				
				List <OpdSurgeryDetail> osdList =  new ArrayList <OpdSurgeryDetail>();
			
				osdList =  session.createCriteria(OpdSurgeryDetail.class)
						  .add(Restrictions.in("Id", surgeryDtList )).list();
				for(OpdSurgeryDetail osd: osdList)
				{
					osd.setAnestheisaPacStatus("OP");
					hbt.save(osd);
				}
		/*		opdSurgeryHeader = (OpdSurgeryHeader) hbt.load(
						OpdSurgeryHeader.class, surgeryId);
				opdSurgeryHeader.setPacStatus("Requested for consultation");
				hbt.update(opdSurgeryHeader);*/
				
				opdSurgeryHeader.setId(surgeryId);
				  
			}
			else
			{
				List <OpdSurgeryDetail> osdList =  new ArrayList <OpdSurgeryDetail>();
				
				osdList =  session.createCriteria(OpdSurgeryDetail.class)
						  .add(Restrictions.in("Id", surgeryDtList )).list();
				
				for(OpdSurgeryDetail osd: osdList)
				{	
					if(fitForSurgery.equalsIgnoreCase("y"))	
					osd.setAnestheisaPacStatus("y");
					else
						osd.setAnestheisaPacStatus("NC");
					
					hbt.update(osd);
				}

				String [] pac_Status = {"y","NC"};
				int totalCompletedPac = session.createCriteria(OpdSurgeryDetail.class)
						  .add(Restrictions.eq("OpdSurgery.Id", surgeryId ))
						  .add(Restrictions.in("AnestheisaPacStatus", pac_Status))
						  .list().size();
				
				
				int totalSurgery = session.createCriteria(OpdSurgeryDetail.class)
						  .add(Restrictions.eq("OpdSurgery.Id", surgeryId ))
						  .list().size();
				if(totalCompletedPac == totalSurgery)
				{
					OpdSurgeryHeader oph = (OpdSurgeryHeader) hbt.load(OpdSurgeryHeader.class, surgeryId);
					oph.setStatus("y");
					hbt.update(oph);
				}
				
				
			}
			
			for(int a : surgeryDtList)
			{
				OtPreAnesthesiaDetail OtPreAnesthesiaDetail = new OtPreAnesthesiaDetail();
				OtPreAnesthesiaDetail.setAnesthesiaHd(OtPreAnesthesiahd);
				
				OpdSurgeryDetail sdt = (OpdSurgeryDetail)hbt.load(OpdSurgeryDetail.class, a);
				//sdt.setId(a);
				
				OtPreAnesthesiaDetail.setOpdSurgeryDetail(sdt);
				OtPreAnesthesiaDetail.setStatus("n");
				hbt.save(OtPreAnesthesiaDetail);

				sdt.setAnestheisaPac(OtPreAnesthesiaDetail);
				
				hbt.update(sdt);
			}
		
			int hiddenValue = box.getInt("hiddenValue");
			//System.out.println("hidden value"+hiddenValue);
			
		//	int hiddenValue = 1;
		/*	if (hiddenValue != 1) {
				hiddenValue = Integer.parseInt(request.getParameter("hiddenValue"));
			}*/
			
			
			//update medical history
			List<Integer> fhIdList = (List) mapForDS.get("fhIdList");
			List<String> statusList = (List) mapForDS.get("statusList");
			List<String> durationList = (List) mapForDS.get("durationList");
			List<PatientMedicalHistory> mhList = new  ArrayList<PatientMedicalHistory>();
			
			for(int i=0;i<fhIdList.size();i++){
				
				int fhId = Integer.parseInt(fhIdList.get(i).toString());
				PatientMedicalHistory mh = new PatientMedicalHistory();
				mhList =  session.createCriteria(PatientMedicalHistory.class)
						.add(Restrictions.eq("PatientFamilyHistory.Id", fhId))
						.add(Restrictions.eq("Hin.Id", hinId))
						.list(); 
				if(mhList.size() > 0)
				{		
						 mh = (PatientMedicalHistory) hbt
								.load(PatientMedicalHistory.class, mhList.get(0).getId());
						
						mh.setDiseaseStatus(statusList.get(i));
						mh.setDuration(durationList.get(i));
					    hbt.update(mh);		
				}
				else
				{
					PatientFamilyHistory ph = new PatientFamilyHistory();
					ph.setId(fhId);
					mh.setPatientFamilyHistory(ph);
					Patient patient = new Patient();
					patient.setId(hinId);
					mh.setHin(patient);
					mh.setDiseaseStatus(statusList.get(i));
					mh.setDuration(durationList.get(i));
					hbt.save(mh);	
				}
				
			}
			int temp = 1;
			String[] chargeCodeIdArr = new String[hiddenValue];
			List<String> chargeCodeIdList = new ArrayList<String>();
			List<String> investigationDateList = new ArrayList<String>();
			for (int i = 0; i < hiddenValue; i++) {
				if (box.get("chargeCodeName" + temp) != null
						&& !box.get("chargeCodeName" + temp)
								.equals("")) {

					String chargeCodeNameWithId = box.getString("chargeCodeName" + temp);
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
						investigationDateList.add(box.getString("investigationDate"+temp));
						//quantityList.add(qty);
						// clinicalList.add(clinicalNotes);
						
						
					}
				}
				temp++;
			}
			
			//investigation
			if (chargeCodeIdList.size() > 0) {
				
				

				List<Patient> patientList = null;  
				String patientTypeNameForHAL = null;
				String patientTypeNameForOther = null;
				String dgOrderBillingStatus = null;
				
		
					 patientTypeNameForHAL =  HMSUtil.getProperties("adt.properties", "patientTypeNameForHAL");
					 patientTypeNameForOther = HMSUtil.getProperties("adt.properties", "patientTypeNameForOther");
				
				Criteria crit = session.createCriteria(Patient.class).add(
						Restrictions.eq("Id", hinId));
				patientList = crit.list();
							
				
				if(patientList.size()>0)
				{
					if(patientList.get(0).getPatientType().getPatientTypeName().equals(patientTypeNameForHAL))
					{
						dgOrderBillingStatus ="y";
					}
					else if(patientList.get(0).getPatientType().getPatientTypeName().equals(patientTypeNameForOther))
					{
						if(patientList.get(0).getBillable().equals("y"))
						    dgOrderBillingStatus ="n";
						else if(patientList.get(0).getBillable().equals("n"))
							dgOrderBillingStatus ="y";
					}
				}

				  Map<String, Object> adMap = new HashMap<String, Object>();
			      adMap.put("tableObjectName", "DgOrderhd");            
		            adMap.put("isHospitalWise", "y");
		            adMap.put("hospitalId", hospitalId);
		            adMap.put("isYearly", "n");            
		            adMap.put("isMonthly", "n");
		            adMap.put("isPrefix", "n");
				//List<String> headerinvestigationDateList =  (List) mapForDS.get("investigationDate");
				;
				List<String> insertedDateList =  new ArrayList<>();
				for(String investigtionDate: investigationDateList)
				{
				if(!insertedDateList.contains(investigtionDate))	{
					insertedDateList.add(investigtionDate);
					utilMap = (Map)HMSUtil.getCurrentDateAndTime();
					DgOrderhd dgOrderhd = new DgOrderhd();
					dgOrderhd.setOrderDate(HMSUtil.convertStringTypeDateToDateType(investigtionDate));
					String pacCode = HMSUtil.getProperties("adt.properties", "CodeForOTPAC");
					Inpatient inpatient = new Inpatient();
					inpatient.setId(inpatientId);
					MasEmployee emp = new MasEmployee();
					emp.setId(docId);
					
					/*OpdSurgeryHeader opsSH = new OpdSurgeryHeader();
					opsSH.setId(surgeryId);*/
				
					dgOrderhd.setOrderTime(consultationTime);
					dgOrderhd.setHospital(masHospitalObj);
					dgOrderhd.setHin(patientObj);
					dgOrderhd.setDepartment(masDepartmentObj);
					dgOrderhd.setPrescribedBy(emp);
					
					//dgOrderhd.setSurgery(opsSH);
				
					
					if (patientStatus.equalsIgnoreCase("Out Patient"))
					{
						dgOrderhd.setVisit(new Visit(visitId));
						dgOrderhd.setPatientType("OP");
					}
					else
					{
						dgOrderhd.setInpatient(new Inpatient(inpatientId));
						dgOrderhd.setPatientType("IP");
					}
					
					dgOrderhd.setTestType("Regular");
					dgOrderhd.setCreatedby(box.getString("userName"));
					dgOrderhd.setCreatedon(new Date());
					dgOrderhd.setBillingStatus(dgOrderBillingStatus);
					//String orderSeqNo = generateOrderNumber(box.getInt("hospitalId"));
					
				
				      adMap.put("tableObjectName", "DgOrderhd");            
			            adMap.put("isHospitalWise", "y");
			            adMap.put("hospitalId", hospitalId);
			            adMap.put("isYearly", "n");            
			            adMap.put("isMonthly", "n");
			            adMap.put("isPrefix", "n");
					 //adtHandlerService.generateAdNumber(adMap);
					
					//String issueNo = generateTransactionSequence(adMap, session);
			            String orderSeqNo = HMSUtil.generateTransactionSequence(adMap, session, hbt);
					
					dgOrderhd.setOrderNo(orderSeqNo);
					//dgOrderhd.setInpatient(inpatient);
					
					dgOrderhd.setClinicalNote(box.getString("clinicalNotes1"));
					dgOrderhd.setOrderStatus("P");
					dgOrderhd.setLabOrderStatus("P");
					dgOrderhd.setLastChgBy(users);
					dgOrderhd.setLastChgDate(new Date());
					dgOrderhd.setLastChgTime(consultationTime);
					//dgOrderhd.setInvestigationRequestionNo(patientInvestigationHeader);
					hbt.save(dgOrderhd);
				
					for (int i = 0; i < chargeCodeIdList.size(); i++) {

						if(investigtionDate.equals(investigationDateList.get(i))){
							
							MasChargeCode masChargeCode = new MasChargeCode();
							masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
						
							DgOrderdt dgOrderdt = new DgOrderdt();
						dgOrderdt.setOtStage(pacCode);
						dgOrderdt.setOrderhd(dgOrderhd);
						masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
						dgOrderdt.setChargeCode(masChargeCode);
						//dgOrderdt.setOrderQty(quantityList.get(i));
						dgOrderdt.setBillingStatus(dgOrderBillingStatus);
						dgOrderdt.setCreatedby(box.getString("userName"));
						dgOrderdt.setCreatedon(new Date());
						dgOrderdt.setLastChgBy(users);
						
						dgOrderdt.setLastChgDate(new Date());
						dgOrderdt.setLastChgTime(consultationTime);
						dgOrderdt.setMsgSent("n");
						// method written for taking out the values of mascharge
						// code and subcharge

						List<MasChargeCode> masChargeList = new ArrayList<MasChargeCode>();
						masChargeList = session.createCriteria(MasChargeCode.class).add(
								Restrictions.eq("Id", Integer.parseInt(chargeCodeIdList.get(i)))).list();
						
						MasChargeCode masChargeCodeObj = masChargeList.get(0);
						int mainChargeId = masChargeCodeObj.getMainChargecode()
						.getId();
						int subChargeId = masChargeCodeObj.getSubChargecode()
						.getId();
						if (masChargeCodeObj.getMainChargecode()
								.getMainChargecodeCode().equalsIgnoreCase("Lab")) {
							dgOrderdt.setOrderStatus("P");
						} else {
							dgOrderdt.setOrderStatus("P");
						}
						MasMainChargecode masMainChargecode = new MasMainChargecode();
						masMainChargecode.setId(mainChargeId);
						dgOrderdt.setMainChargecode(masMainChargecode);
						MasSubChargecode masSubChargecode = new MasSubChargecode();
						masSubChargecode.setId(subChargeId);
						dgOrderdt.setSubChargeid(masSubChargecode);
						dgOrderdt.setInvestigation(new DgMasInvestigation(Integer.parseInt(chargeCodeIdList.get(i))));
						//dgOrderdt.setInvestigationToMH(referToMhList.get(i));
						dgOrderdt.setInvestigationToMh("n");
						//dgOrderdt.setReferToMh(referToMhList.get(i));
						dgOrderdt.setReferToMh("n");
						hbt.save(dgOrderdt);
					
						}//end date comparision
					}//inner dt loop
				//	headerinvestigationDateList.removeAll(Arrays.asList(investigtionDate));
				}
				}//outer loop for hd
				
				
			}
			succesfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}
		
		map.put("succesfullyAdded", succesfullyAdded);
		return map;

	}

	public boolean updatePreAnesthesiaDetails(Map mapForDS) {
		Session session = (Session) getSession();
		boolean succesfullyAdded = false;
		Transaction tx = null;
		Box box = (Box) mapForDS.get("box");
		List<OpdPatientHistory> opdPatientHistoryList = new ArrayList<OpdPatientHistory>();
		List<OpdSurgeryHeader> opdSurgeryList = new ArrayList<OpdSurgeryHeader>();
		//List<OpdSurgeryHeader> opdSurgeryHeaderList = new ArrayList<OpdSurgeryHeader>();

		try {
	        String surgeryDtStringArrary[] = (String[]) mapForDS.get("surgeryDtStringArrary");
			
			List<Integer> surgeryDtList = new ArrayList<Integer>();
			for(int a = 0 ; a<surgeryDtStringArrary.length; a++)
			{
				surgeryDtList.add(Integer.parseInt(surgeryDtStringArrary[a]));
			}
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			int otPreAnesthesiaDetailsId = box.getInt("otPreAnesthesiaDetailsId");
			int deptId = box.getInt("deptId");
			int hinId = box.getInt("hinId");
			int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
			int visitId = box.getInt("visitId");
			int inpatientId = box.getInt("inPatientId");
			int userId = (Integer) mapForDS.get(USER_ID);
			int surgeryId =  box.getInt("surgerId");
			String patientStatus = box.getString("patientStatus");
			String summary="";
			//int pendingDocId = 0;
			//int pendingDeptId = 0;
			int consultDocId = 0;
			int consultDeptId = 0;
			String Remarks="";
			//String arrangeBed1="";
			int wardName=0;
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String consultationTime = (String)utilMap.get("currentTimeWithoutSc");
			String consultationDate = (String)utilMap.get("currentDate");
			Date consultationDateToInsert = HMSUtil
					.convertStringTypeDateToDateType(consultationDate);
			//String vent="";
			//String remarksForBedArrangement="";
			//String patientPosition="";
			//String[] CareOf=null;
			int docId = 0;
			String fitForSurgery = box
			.getString("fitForSurgery");
			
			if(mapForDS.get(EMPLOYEE_ID)!=null){
				docId=(Integer)mapForDS.get(EMPLOYEE_ID);
			}
			
	/*		if(mapForDS.get("careOf")!=null){
				CareOf=(String[])mapForDS.get("careOf");
			}
			String careOf="";
			if(CareOf!=null && CareOf.length>0){
			for(String str:CareOf){
				if(str!=null && !str.equals("")){
				careOf+=""+str;
				}
			}
			}*/
			/*int unitForBloodComponent=0;
			if(box.getInt("unitForBloodComponent")!=0){
				unitForBloodComponent=box.getInt("unitForBloodComponent");
			}
			if(box.get("patientPosition")!=null){
				patientPosition=box.get("patientPosition");
			}
			
			if(box.get("arrangeBed1")!=null){
				arrangeBed1=box.get("arrangeBed1");
			}
			if(box.get("vent")!=null){
				vent=box.get("vent");
			}
			if(box.get("remarksForBedArrangement")!=null){
				remarksForBedArrangement=box.get("remarksForBedArrangement");
			}
			if(box.get("wardName")!=null && !box.get("wardName").equals("0")){
				wardName=box.getInt("wardName");
			}*/
			summary=box.getString("summary");
			String asaRisk=box.getString("asaRisk");
	/*		if(box.getInt("pendingDeptName")!=0){
				pendingDeptId=box.getInt("pendingDeptName");
			}
			
			if(box.getInt("pendingDocName")!=0){
				pendingDocId=box.getInt("pendingDocName");
			}*/
			if(box.getString("remarks")!=null){
				Remarks=box.getString("remarks");
			}
			
			String referConsult = box.getString("refer_consult");
			
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(docId);
	
			
			//OpdPatientHistory opdPatientHistory = new OpdPatientHistory();
			//OtPreAnesthesiaDetails otPreAnesthesiaDetails = new OtPreAnesthesiaDetails();
			OtPreAnesthesiaHd otPreAnesthesiaDetails = (OtPreAnesthesiaHd) hbt
					.load(OtPreAnesthesiaHd.class,	otPreAnesthesiaDetailsId);
			
		//	otPreAnesthesiaDetails.setBedArrangement(arrangeBed1);
			//otPreAnesthesiaDetails.setBedFlag(vent);
			//otPreAnesthesiaDetails.setRemarksBedArrangement(remarksForBedArrangement);
			//otPreAnesthesiaDetails.setCareOf(careOf);
		//	otPreAnesthesiaDetails.setPatientPosition(patientPosition);
		/*	if(wardName!=0){
			MasDepartment dept=new MasDepartment();
			dept.setId(wardName);
			
			//otPreAnesthesiaDetails.setWard(dept);
			}*/
			
			
	/*		if(fitForSurgery!=null  && fitForSurgery.equalsIgnoreCase("n"))
			{
				if(pendingDeptId!=0){
					MasDepartment md1=new MasDepartment();
					md1.setId(pendingDeptId);
					otPreAnesthesiaDetails.setPendingDept(md1);
					}
				if(pendingDocId!=0){
				MasEmployee me1=new MasEmployee();
				me1.setId(pendingDocId);
				otPreAnesthesiaDetails.setPendingDoctor(me1);
				}
			}*/
			if(box.getString("previousRefer").equalsIgnoreCase("y"))
			otPreAnesthesiaDetails.setConsultOtherDoctor("y");
			else
				otPreAnesthesiaDetails.setConsultOtherDoctor(referConsult);
		
			if(referConsult!=null  && referConsult.equalsIgnoreCase("n"))
			{
				otPreAnesthesiaDetails.setFitForSurgery(fitForSurgery);
			otPreAnesthesiaDetails.setReviewQp(box.get("reviewqp"));
			otPreAnesthesiaDetails.setReviewBp(box.get("reviewbp"));
			otPreAnesthesiaDetails.setReviewCvs(box.get("reviewcvs"));
			otPreAnesthesiaDetails.setReviewRs(box.get("reviewrs"));
			otPreAnesthesiaDetails.setReviewComplaints(box.get("review_complaints"));
			otPreAnesthesiaDetails.setOther(summary);
			otPreAnesthesiaDetails.setAsaRisk(asaRisk);
			otPreAnesthesiaDetails.setRemark(Remarks);
			
			}
			
			//OpdSurgeryHeader opdSurgeryHeaderObj = new OpdSurgeryHeader();
			
			//if(referConsult!=null  && referConsult.equalsIgnoreCase("n"))
			//{	
				String []pacStatus = {"RC","n", "CR", "OP"};
			if (patientStatus.equalsIgnoreCase("Out Patient")) {
				/* opdPatientHistory.setVisitInpatientId(box.getInt("visitId")); */
				Visit visit = new Visit();
				visit.setId(visitId);
				otPreAnesthesiaDetails.setVisit(visit);
				// opdSurgeryList =
				// session.createCriteria(OpdSurgeryHeader.class)
				// .createAlias("Visit", "visit")
				// .add(Restrictions.eq("visit.Id", visitId))
				// .add(Restrictions.eq("Hospital.Id", hospitalId))
				// .add(Restrictions.eq("PacStatus", "pending")).list();

				// changed for order id
				opdSurgeryList = session
						.createCriteria(OpdSurgeryHeader.class)
						.createAlias("Visit", "visit")
						.add(Restrictions.eq("visit.Id", visitId))
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("OrderNo", box.getInt("orderNo")))
						.add(Restrictions.in("PacStatus", pacStatus)
								).list();
				/*OpdSurgeryHeader opdSurgeryHeader = opdSurgeryList.get(0);
				int id = opdSurgeryHeader.getId();*/
		/*		opdSurgeryHeaderObj = (OpdSurgeryHeader) hbt.load(
						OpdSurgeryHeader.class, surgeryId);
				opdSurgeryHeaderObj.setPacStatus("Cleared");
				hbt.update(opdSurgeryHeaderObj);*/
			} else {
				// opdPatientHistory.setVisitInpatientId(box.getInt("inPatientId"));
				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				otPreAnesthesiaDetails.setInpatient(inpatient);
				// List otPreList=session.createQuery("select ot from
				// OtPreAnesthesiaDetails as ot where
				// ot.Inpatient.Id='"+inpatientId+"' and ot.ChangedDate=(select
				// max(ot.ChangedDate) from OtPreAnesthesiaDetails as ot where
				// ot.Inpatient.Id='"+inpatientId+"')").list();
				// OtPreAnesthesiaDetails
				// otObj=(OtPreAnesthesiaDetails)otPreList.get(0);
			/*	opdPatientHistoryList = session
						.createCriteria(OpdPatientHistory.class)
						.createAlias("Hin", "hin")
						.add(Restrictions.eq("hin.Id", hinId))
						.add(Restrictions.eq("VisitInpatientId", inpatientId))
						.list();*/
				// List opdSurgeryHList = session
				// .createQuery(
				// "select ot from OpdSurgeryHeader as ot  where ot.Inpatient.Id='"
				// + inpatientId
				// +
				// "' and ot.RequisitionDate=(select max(ot.RequisitionDate) from OpdSurgeryHeader as ot where ot.Inpatient.Id='"
				// + inpatientId + "')").list();

				// changed for order id
/*				
				opdSurgeryList = session
						.createCriteria(OpdSurgeryHeader.class)
						.createAlias("Inpatient", "inpatient")
						.add(Restrictions.eq("inpatient.Id", inpatientId))
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("OrderNo", box.getInt("orderNo")))
						.add(Restrictions.in("PacStatus", pacStatus)
								).list();

				OpdSurgeryHeader opdObj = (OpdSurgeryHeader) opdSurgeryList
						.get(0);
				int opdId = opdObj.getId();

				opdSurgeryHeaderObj = (OpdSurgeryHeader) hbt.load(
						OpdSurgeryHeader.class, opdId);
				opdSurgeryHeaderObj.setPacStatus("Cleared");
				hbt.update(opdSurgeryHeaderObj);*/
			 }
			//}
/*			if (opdPatientHistoryList != null
					&& opdPatientHistoryList.size() > 0) {

				OpdPatientHistory opdPatientHistoryObj = opdPatientHistoryList
						.get(0);
				int opdPatientHistoryId = opdPatientHistoryObj.getId();
				OpdPatientHistory opdPatientHistory2 = (OpdPatientHistory) hbt
						.load(OpdPatientHistory.class, opdPatientHistoryId);
				opdPatientHistory2.setPersonalPresentHistory(box
						.getString("presentHistory"));
				opdPatientHistory2.setPersonalPastHistory(box
						.getString("pastHistory"));
				hbt.update(opdPatientHistory2);

			} else {
				// OpdPatientHistory opdPatientHistory1 = new
				// OpdPatientHistory();
				// if (patientStatus.equalsIgnoreCase("OutPatient")) {
				// opdPatientHistory.setVisitInpatientId(box
				// .getInt("visitId"));
				// } else {
				// opdPatientHistory.setVisitInpatientId(box
				// .getInt("inPatientId"));
				// }
				// Patient patient = new Patient();
				// patient.setId(hinId);
				// opdPatientHistory.setHin(patient);
				// MasDepartment masDepartment = new MasDepartment();
				// masDepartment.setId(deptId);
				// opdPatientHistory.setDepartment(masDepartment);
				// opdPatientHistory.setPersonalPresentHistory(box
				// .getString("pastHistory"));
				// opdPatientHistory.setPersonalPastHistory(box
				// .getString("presentHistory"));
				// MasHospital masHospital = new MasHospital();
				// masHospital.setId(hospitalId);
				// opdPatientHistory.setHospital(masHospital);
				// opdPatientHistory.setLastChgBy(box.getString("changedBy"));
				// opdPatientHistory.setLastChgDate(HMSUtil
				// .convertStringTypeDateToDateType(box
				// .getString("changedDate")));
				// opdPatientHistory.setLastChgTime(box.getString("changedTime"));
				// opdPatientHistory.setStatus("y");
				// opdPatientHistory.setIpOpPacStatus("PAC");
				// hbt.save(opdPatientHistory1);

				// changed by mritunjay
				if (patientStatus.equalsIgnoreCase("Out Patient")) {
					opdPatientHistory
							.setVisitInpatientId(box.getInt("visitId"));
				} else {
					opdPatientHistory.setVisitInpatientId(box
							.getInt("inPatientId"));
				}
				Patient patient = new Patient();
				patient.setId(hinId);
				opdPatientHistory.setHin(patient);
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				opdPatientHistory.setDepartment(masDepartment);
				opdPatientHistory.setPersonalPresentHistory(box
						.getString("pastHistory"));
				opdPatientHistory.setPersonalPastHistory(box
						.getString("presentHistory"));
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				opdPatientHistory.setHospital(masHospital);
				Users users = new Users();
				users.setId(userId);
				//opdPatientHistory.setLastChgBy(userId);
				opdPatientHistory.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("changedDate")));
				opdPatientHistory.setLastChgTime(box.getString("changedTime"));
				opdPatientHistory.setStatus("y");
				opdPatientHistory.setIpOpPacStatus("PAC");
				hbt.save(opdPatientHistory);
			}*/

			Patient patientObj = new Patient();
			patientObj.setId(hinId);
			MasDepartment masDepartmentObj = new MasDepartment();
			masDepartmentObj.setId(deptId);
			MasHospital masHospitalObj = new MasHospital();
			masHospitalObj.setId(hospitalId);
	/*		int anesId = box.getInt("anaestheticName");
			if (anesId != 0) {
				MasEmployee me = new MasEmployee();
				me.setId(anesId);
				otPreAnesthesiaDetails.setAnesthetic(me);
			}*/
			//otPreAnesthesiaDetails.setSmokingAlcohol(box.getString("smoking"));
			//otPreAnesthesiaDetails.setPulse(box.getString("pulse"));
			otPreAnesthesiaDetails.setWeight(box.getString("weight"));
			otPreAnesthesiaDetails.setBp(box.getString("bp"));
			otPreAnesthesiaDetails.setPulse(box.getString("pulse"));
			otPreAnesthesiaDetails.setPr(box.getString("pr"));
			otPreAnesthesiaDetails.setPallor(box.getString("pallor"));
			otPreAnesthesiaDetails.setCyanosis(box.getString("cyanosis"));
			//otPreAnesthesiaDetails.setClubbing(box.getString("clubbing"));
			otPreAnesthesiaDetails.setIcetrus(box.getString("icetrus"));
			otPreAnesthesiaDetails.setOedema(box.getString("oedema"));
			otPreAnesthesiaDetails.setSpine(box.getString("spine"));
			//otPreAnesthesiaDetails.setThyroid(box.getString("thyroid"));
			otPreAnesthesiaDetails.setNourishment(box.getString("nourishment"));
			otPreAnesthesiaDetails.setBp(box.getString("bp"));
			otPreAnesthesiaDetails.setAirway(box.getString("airway"));
			otPreAnesthesiaDetails.setVenousAccess(box.getString("venous"));
			//otPreAnesthesiaDetails.setBreathSound(box.getString("breath"));
		//	otPreAnesthesiaDetails.setAdvSound(box.getString("advance"));
			otPreAnesthesiaDetails.setAbdomen(box.getString("abdomen"));
			//otPreAnesthesiaDetails.setLiver(box.getString("liver"));
			otPreAnesthesiaDetails.setSpleen(box.getString("spleen"));
			otPreAnesthesiaDetails.setIcetrus(box.getString("icterus"));
		//	otPreAnesthesiaDetails.setAsaGrade(box.getString("asa"));
		//	otPreAnesthesiaDetails.setBlood(box.getString("blood"));
		//	otPreAnesthesiaDetails.setUnit(unitForBloodComponent);
			/*otPreAnesthesiaDetails.setHairPin(box.getString("hairPin"));
			otPreAnesthesiaDetails.setJewelStatus(box.getString("jewelName"));*/
			//otPreAnesthesiaDetails.setInstructions(box.getString("instructions"));
					

			//otPreAnesthesiaDetails.setS1(box.getString("s1"));
			//otPreAnesthesiaDetails.setS2(box.getString("s2"));
			//otPreAnesthesiaDetails.setS3(box.getString("s3"));
			//otPreAnesthesiaDetails.setS4(box.getString("s4"));
			otPreAnesthesiaDetails.setOrderNo(box.getInt("orderNo"));
			otPreAnesthesiaDetails.setHin(patientObj);

			otPreAnesthesiaDetails.setDepartment(masDepartmentObj);
			otPreAnesthesiaDetails.setHospital(masHospitalObj);
			otPreAnesthesiaDetails.setPacDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString("changedDate")));
			Users users = new Users();
			users.setId(userId);
			
			/*added for HAL*/
			otPreAnesthesiaDetails.setKoilonychia(box.get("koilonychia"));
			otPreAnesthesiaDetails.setLymphadenopathy(box.get("lymphadenopathy"));
			otPreAnesthesiaDetails.setMpc(box.get("mpc"));
			otPreAnesthesiaDetails.setTmd(box.get("tmd"));
			otPreAnesthesiaDetails.setTmj(box.get("tmj"));
			otPreAnesthesiaDetails.setEco(box.get("eco"));
			otPreAnesthesiaDetails.setEcg(box.get("ecg"));
			otPreAnesthesiaDetails.setChestXray(box.get("chestxray"));
			otPreAnesthesiaDetails.setMo(box.get("mo"));
			otPreAnesthesiaDetails.setTeeth(box.get("teeth"));
			otPreAnesthesiaDetails.setCvs(box.get("cvs"));
			otPreAnesthesiaDetails.setRs(box.get("rs"));
			otPreAnesthesiaDetails.setCns(box.get("cns"));
			otPreAnesthesiaDetails.setAddtionalRemarks(box.get("additional_remarks"));
	
			
			
			//otPreAnesthesiaDetails.setChangedBy(users);
			otPreAnesthesiaDetails.setChangedDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString("changedDate")));
			otPreAnesthesiaDetails.setChangedTime(box.getString("changedTime"));
			otPreAnesthesiaDetails.setPatientType(box.get("patientType"));
			/*
			 * MasAnesthesia masAnesthesia=new MasAnesthesia();
			 * masAnesthesia.setId(box.getInt("grade"));
			 * otPreAnesthesiaDetails.setAnesthticTechnique(masAnesthesia);
			 */
			//String anaestheticPlanned = box.getString("anaesthicPlanned");
			String anaestheticPlanned = box.getString("grade1");
			//String anaestheticPlannedTemp = "";
			otPreAnesthesiaDetails.setConsentStatus("n");
	/*		anaestheticPlannedTemp = anaestheticPlanned.substring(
					anaestheticPlanned.length() - 1,
					anaestheticPlanned.length());
			if (anaestheticPlannedTemp.equals(",")) {
				anaestheticPlanned = anaestheticPlanned.substring(0,
						anaestheticPlanned.length() - 1);
			}
*/
			otPreAnesthesiaDetails.setAnashteicDetails(anaestheticPlanned);
			otPreAnesthesiaDetails.setPreviousAnesthetics(box.get("anestheticDetails"));
			//otPreAnesthesiaDetails.setDrugTreatment(box.getString("drugTherapy"));
					
			hbt.update(otPreAnesthesiaDetails);
			int anesthesiaId = otPreAnesthesiaDetails.getId();
			
			//save here
			if(referConsult!=null  && referConsult.equalsIgnoreCase("y"))
			{
				if(box.getInt("refereddept")!=0){
					consultDeptId=box.getInt("refereddept");
					consultDocId=box.getInt("refereddoctor");
				}
				
				//OpdSurgeryDetail osd = new OpdSurgeryDetail();
				
				List <OpdSurgeryDetail> osdList =  new ArrayList <OpdSurgeryDetail>();
			
				osdList =  session.createCriteria(OpdSurgeryDetail.class)
						  .add(Restrictions.in("Id", surgeryDtList )).list();
				for(OpdSurgeryDetail osd: osdList)
				{
					osd.setAnestheisaPacStatus("RC");
					hbt.save(osd);
				}
		/*		opdSurgeryHeader = (OpdSurgeryHeader) hbt.load(
						OpdSurgeryHeader.class, surgeryId);
				opdSurgeryHeader.setPacStatus("Requested for consultation");
				hbt.update(opdSurgeryHeader);*/
				
		/*		opdSurgeryHeader.setId(surgeryId);
				PreAnesthesiaConsultDoctorHd consulthd = new PreAnesthesiaConsultDoctorHd();
				consulthd.setOtPreAnesthesiaHd(OtPreAnesthesiahd);
				MasHospital masHospital = new MasHospital();
				 masHospital.setId(hospitalId);
				consulthd.setHospital(masHospital);
				hbt.save(consulthd);*/
					
				List<PreAnesthesiaConsultDoctorHd> consultDocHD =  session.createCriteria(PreAnesthesiaConsultDoctorHd.class)
						  .add(Restrictions.eq("OtPreAnesthesiaHd.Id", anesthesiaId )).list();
				
				PreAnesthesiaConsultDoctorHd consulthd = null;
				if(consultDocHD.size()==0)
				{
				//opdSurgeryHeader.setId(surgeryId);
				 consulthd = new PreAnesthesiaConsultDoctorHd();
				consulthd.setOtPreAnesthesiaHd(otPreAnesthesiaDetails);
				MasHospital masHospital = new MasHospital();
				 masHospital.setId(hospitalId);
				consulthd.setHospital(masHospital);
				hbt.save(consulthd);
		
				}
				else 
					consulthd = consultDocHD.get(0);
					
				
				
				int totalReferDepartment = box.getInt("hiddenValueRefer");
				
				
				 PreAnesthesiaConsultDoctorDt consultdt = null;
				 MasDepartment  md1= null;
				 MasEmployee me1 =null;
					
				 for(int i=1;i<=totalReferDepartment;i++){
					 if(box.get("referral_notes"+i)!=null && !box.getString("referral_notes"+i).isEmpty()){
						 
					 consultdt = new PreAnesthesiaConsultDoctorDt();
				 consultdt.setConsultDoctorIdHd(consulthd);
				 md1=new MasDepartment();
					md1.setId(box.getInt("refereddept"+i));
				 consultdt.setConsultedDepartment(md1);
				 consultdt.setReferralNotes(box.getString("referral_notes"+i));
				if(box.getInt("refereddoctor"+i)!=0){	
				  me1=new MasEmployee();
					me1.setId(box.getInt("refereddoctor"+i));
				 consultdt.setConsultedDoctor(me1);
				}
				 consultdt.setConsultDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.getString("changedDate")));
				 consultdt.setConsultTime(box.getString("changedTime"));
				  hbt.save(consultdt);
					 }
				 }
				  
				  
				  
			}
			else if(inpatientId==0)
			{
			
				//OpdSurgeryDetail osd = new OpdSurgeryDetail();
				
				List <OpdSurgeryDetail> osdList =  new ArrayList <OpdSurgeryDetail>();
			
				osdList =  session.createCriteria(OpdSurgeryDetail.class)
						  .add(Restrictions.in("Id", surgeryDtList )).list();
				for(OpdSurgeryDetail osd: osdList)
				{
					osd.setAnestheisaPacStatus("OP");
					hbt.save(osd);
				}
		/*		opdSurgeryHeader = (OpdSurgeryHeader) hbt.load(
						OpdSurgeryHeader.class, surgeryId);
				opdSurgeryHeader.setPacStatus("Requested for consultation");
				hbt.update(opdSurgeryHeader);*/
				
				
				  
			}
			else
			{
				List <OpdSurgeryDetail> osdList =  new ArrayList <OpdSurgeryDetail>();
				
				osdList =  session.createCriteria(OpdSurgeryDetail.class)
						  .add(Restrictions.in("Id", surgeryDtList )).list();
				
				for(OpdSurgeryDetail osd: osdList)
				{	
					if(fitForSurgery.equalsIgnoreCase("y"))	
					osd.setAnestheisaPacStatus("y");
					else
						osd.setAnestheisaPacStatus("NC");
					
					hbt.update(osd);
				}

				String [] pac_Status = {"y","NC"};
				int totalCompletedPac = session.createCriteria(OpdSurgeryDetail.class)
						  .add(Restrictions.eq("OpdSurgery.Id", surgeryId ))
						  .add(Restrictions.in("AnestheisaPacStatus", pac_Status))
						  .list().size();
				
				
				int totalSurgery = session.createCriteria(OpdSurgeryDetail.class)
						  .add(Restrictions.eq("OpdSurgery.Id", surgeryId ))
						  .list().size();
				if(totalCompletedPac == totalSurgery)
				{
					OpdSurgeryHeader oph = (OpdSurgeryHeader) hbt.load(OpdSurgeryHeader.class, surgeryId);
					oph.setStatus("y");
					hbt.update(oph);
				}
				
				
			}
			
	
			
			//update medical history
			List<Integer> fhIdList = (List) mapForDS.get("fhIdList");
			List<String> statusList = (List) mapForDS.get("statusList");
			List<String> durationList = (List) mapForDS.get("durationList");
			List<PatientMedicalHistory> mhList = new  ArrayList<PatientMedicalHistory>();
			
			for(int i=0;i<fhIdList.size();i++){
				
				int fhId = Integer.parseInt(fhIdList.get(i).toString());
				PatientMedicalHistory mh = new PatientMedicalHistory();
				mhList =  session.createCriteria(PatientMedicalHistory.class)
						.add(Restrictions.eq("PatientFamilyHistory.Id", fhId))
						.add(Restrictions.eq("Hin.Id", hinId))
						.list(); 
				if(mhList.size() > 0)
				{		
						 mh = (PatientMedicalHistory) hbt
								.load(PatientMedicalHistory.class, mhList.get(0).getId());
						
						mh.setDiseaseStatus(statusList.get(i));
						mh.setDuration(durationList.get(i));
					    hbt.update(mh);		
				}
				else
				{
					PatientFamilyHistory ph = new PatientFamilyHistory();
					ph.setId(fhId);
					mh.setPatientFamilyHistory(ph);
					Patient patient = new Patient();
					patient.setId(hinId);
					mh.setHin(patient);
					mh.setDiseaseStatus(statusList.get(i));
					mh.setDuration(durationList.get(i));
					hbt.save(mh);	
				}
				
			}
			
			
			int hiddenValue = box.getInt("hiddenValue");
			int dgOrderHdId = 0;
			
	/*		List<DgOrderhd> orderHdList = new ArrayList<DgOrderhd>();
			orderHdList = session.createCriteria(DgOrderhd.class)
					.add(Restrictions.eq("Surgery.Id", surgeryId)).list();
				
			List<Integer>surgerIdList =  new ArrayList<Integer> ();
			  for(DgOrderhd orderhd:orderHdList)
			  {
				  surgerIdList.add(orderhd.getId());  
			  }*/
			
			  //DgOrderdt
			 // List<DgOrderdt> DgOrderIdList = new ArrayList<DgOrderdt>();
	
			//session.createQuery("delete from DgOrderdt").setParameterList("Orderhd.Id", surgerIdList).executeUpdate();
			//session.createQuery("delete from DgOrderhd").setParameterList("Surgery", surgerIdList).executeUpdate();
			
			int temp = 1;
			String[] chargeCodeIdArr = new String[hiddenValue];
			List<String> chargeCodeIdList = new ArrayList<String>();
			List<Integer> prevDtList = new ArrayList<Integer>();
			List<String> investigationRemarksList = new ArrayList<String>();
			List<String> investigationDateList = new ArrayList<String>();
			
			 List<Integer> sampleCollectedInvestigationIdList = new ArrayList<Integer>();
				
				if(box.get("dgOrderHdId")!=null && box.getInt("dgOrderHdId")!=0)
				{
					dgOrderHdId =  box.getInt("dgOrderHdId");
					 List<DgOrderdt> sampleCollectedInvestigationList = session.createCriteria(DgOrderdt.class)
							.createAlias("Orderhd", "hd")
							.add(Restrictions.ne("OrderStatus", "p").ignoreCase())
		                  .add(Restrictions.eq("hd.Id", dgOrderHdId)).list();
		         for(DgOrderdt dgdt : sampleCollectedInvestigationList)   
		         {
		        	 sampleCollectedInvestigationIdList.add(dgdt.getId());
		         }
				}
			
			
			
			for (int i = 0; i < hiddenValue; i++) {
				if (box.get("chargeCodeName" + temp) != null
						&& !box.get("chargeCodeName" + temp)
								.equals("")) {

					String chargeCodeNameWithId = box.getString("chargeCodeName" + temp);
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
						//quantityList.add(qty);
						// clinicalList.add(clinicalNotes);
						investigationDateList.add(box.getString("investigationDate"+temp));
						
					}
				}

			
				if(box.get("dgOrderDtId" + temp) != null && !box.get("dgOrderDtId" +temp).equals("")){
					int orderDtId =  box.getInt("dgOrderDtId" + temp);
					prevDtList.add(orderDtId);
				}else{
					prevDtList.add(0);
				}
				

				if(box.get("investigationRemarks" + temp) != null && !box.get("investigationRemarks" +temp).equals("")){
					investigationRemarksList.add(box.getString("investigationRemarks" + temp));
				}else{
					investigationRemarksList.add("");
				}
				
				
				temp++;
			}
			
			
			//investigation
			if (chargeCodeIdList.size() > 0) {

				List<Patient> patientList = null;  
				String patientTypeNameForHAL = null;
				String patientTypeNameForOther = null;
				String dgOrderBillingStatus = null;
				List<Integer> totaldgDtIdList = new ArrayList<Integer>();
				List<Integer> totalDbHdIdList = new ArrayList<Integer>();
				//List<Integer> dbDgheaderIdList = new ArrayList<Integer>();
				List<Integer> dbDgheaderList = null;
		
					 patientTypeNameForHAL =  HMSUtil.getProperties("adt.properties", "patientTypeNameForHAL");
					 patientTypeNameForOther = HMSUtil.getProperties("adt.properties", "patientTypeNameForOther");
				
					 dbDgheaderList = session.createCriteria(DgOrderhd.class).add(
								Restrictions.eq("Createdon", consultationDateToInsert)).createAlias("Visit", "v").add(Restrictions.eq("v.Id",visitId))
								.setProjection(Projections.projectionList().add(Projections.groupProperty("Id")))
								.list();
					 
				Criteria crit = session.createCriteria(Patient.class).add(
						Restrictions.eq("Id", hinId));
				patientList = crit.list();
							
				
				if(patientList.size()!=0)
				{
					if(patientList.get(0).getPatientType().getPatientTypeName().equals(patientTypeNameForHAL))
					{
						dgOrderBillingStatus ="y";
					}
					else if(patientList.get(0).getPatientType().getPatientTypeName().equals(patientTypeNameForOther))
					{
						if(patientList.get(0).getBillable().equals("y"))
						    dgOrderBillingStatus ="n";
						else if(patientList.get(0).getBillable().equals("n"))
							dgOrderBillingStatus ="y";
					}
				}

				  Map<String, Object> adMap = new HashMap<String, Object>();
			      adMap.put("tableObjectName", "DgOrderhd");            
		            adMap.put("isHospitalWise", "y");
		            adMap.put("hospitalId", hospitalId);
		            adMap.put("isYearly", "n");            
		            adMap.put("isMonthly", "n");
		            adMap.put("isPrefix", "n");
				//List<String> headerinvestigationDateList =  (List) mapForDS.get("investigationDate");
				;
				List<String> insertedDateList =  new ArrayList<>();
				List <DgOrderhd> dgOrderList = null;
				 boolean updateHeaderStatus=false;
				for(String investigtionDate: investigationDateList)
				{
				if(!insertedDateList.contains(investigtionDate))	{
					insertedDateList.add(investigtionDate);
					//System.out.println("headerinvestigationDateList "+headerinvestigationDateList +" investigationDateList="+investigationDateList);
					
					dgOrderList = session.createCriteria(DgOrderhd.class).add(Restrictions.eq("OrderDate",HMSUtil.convertStringTypeDateToDateType(investigtionDate)))
							.createAlias("Visit", "v").add(Restrictions.eq("v.Id",visitId)).list();
					DgOrderhd dgOrderhd = null;
			
					if(dgOrderList.size()>0){
						 dgOrderhd = dgOrderList.get(0);
						 totalDbHdIdList.add(dgOrderhd.getId());	 
					}
					else{
						 dgOrderhd = new DgOrderhd();
							dgOrderhd.setBillingStatus(dgOrderBillingStatus);
							dgOrderhd.setPatientType("OP");
							dgOrderhd.setTestType("Regular");
							dgOrderhd.setCreatedby(box.getString("userName"));
							dgOrderhd.setCreatedon(consultationDateToInsert);
					       String orderSeqNo = HMSUtil.generateTransactionSequence(adMap, session, hbt);
							    dgOrderhd.setOrderNo(orderSeqNo);
						
								if (patientStatus.equalsIgnoreCase("Out Patient"))
								{
									dgOrderhd.setVisit(new Visit(visitId));
									dgOrderhd.setPatientType("OP");
								}
								else
								{
									dgOrderhd.setInpatient(new Inpatient(inpatientId));
									dgOrderhd.setPatientType("IP");
								}
								
							    
							dgOrderhd.setOrderStatus("P");
							dgOrderhd.setLabOrderStatus("P");
							dgOrderhd.setLastChgBy(users);
							dgOrderhd.setLastChgDate(consultationDateToInsert);
							dgOrderhd.setLastChgTime(consultationTime);
							dgOrderhd.setOrderDate(HMSUtil.convertStringTypeDateToDateType(investigtionDate));
							masHospitalObj.setId(hospitalId);
							dgOrderhd.setHospital(masHospitalObj);
							dgOrderhd.setOrderTime(consultationTime);
							
							patientObj.setId(hinId);
							dgOrderhd.setHin(patientObj);
					
							dgOrderhd.setDepartment(masDepartmentObj);
							dgOrderhd.setPrescribedBy(masEmployee);
							//dgOrderhd.setInvestigationRequestionNo(patientInvestigationHeader);
							if(mapForDS.get("otherInvestigation")!=null)
							dgOrderhd.setOtherInvestigation(mapForDS.get("otherInvestigation").toString().trim());
					
							hbt.save(dgOrderhd);
					}
					
					
					
					
				    updateHeaderStatus=false;
					for (int i = 0; i < chargeCodeIdList.size(); i++) {
						
						if(investigtionDate.equals(investigationDateList.get(i))){
						
						MasChargeCode masChargeCode = new MasChargeCode();
						masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
						
						
						DgOrderdt dgOrderdt = null;
						List<MasChargeCode> masChargeList = new ArrayList<MasChargeCode>();
						masChargeList = session.createCriteria(MasChargeCode.class).add(
								Restrictions.eq("Id", Integer.parseInt(chargeCodeIdList.get(i)))).list();
						
						MasChargeCode masChargeCodeObj = masChargeList.get(0);
						int mainChargeId = masChargeCodeObj.getMainChargecode()
						.getId();
						int subChargeId = masChargeCodeObj.getSubChargecode()
						.getId();
						if(prevDtList.get(i)!=0)
						{
							dgOrderdt = (DgOrderdt) hbt.load(DgOrderdt.class, prevDtList.get(i));
							dgOrderdt.setOtRemarks(investigationRemarksList.get(i).trim());
						}
						else
						{
							if(!updateHeaderStatus){
							dgOrderhd.setOrderStatus("p");
							hbt.update(dgOrderhd);}
							dgOrderdt = new DgOrderdt();
							dgOrderdt.setMsgSent("n");
						
							if (masChargeCodeObj.getMainChargecode()
									.getMainChargecodeCode().equalsIgnoreCase("Lab")) {
								dgOrderdt.setOrderStatus("P");
							} else {
								dgOrderdt.setOrderStatus("P");
							}
							dgOrderdt.setOtStage(HMSUtil.getProperties("adt.properties", "CodeForOTPAC"));
						}
											dgOrderdt.setOrderhd(dgOrderhd);
											masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
											dgOrderdt.setChargeCode(masChargeCode);
											//dgOrderdt.setOrderQty(quantityList.get(i));
											dgOrderdt.setBillingStatus(dgOrderBillingStatus);
											dgOrderdt.setCreatedby(box.getString("userName"));
											//dgOrderdt.setCreatedon(consultationDateToInsert);
											dgOrderdt.setCreatedon(HMSUtil.convertStringTypeDateToDateType(investigtionDate));
											
											dgOrderdt.setLastChgBy(users);
											dgOrderdt.setLastChgDate(consultationDateToInsert);
											dgOrderdt.setLastChgTime(consultationTime);
											
											// method written for taking out the values of mascharge
											// code and subcharge
									
											MasMainChargecode masMainChargecode = new MasMainChargecode();
											masMainChargecode.setId(mainChargeId);
											dgOrderdt.setMainChargecode(masMainChargecode);
											MasSubChargecode masSubChargecode = new MasSubChargecode();
											masSubChargecode.setId(subChargeId);
											dgOrderdt.setSubChargeid(masSubChargecode);
										
											List<DgMasInvestigation> invList = new ArrayList<DgMasInvestigation>();
											invList = session.createCriteria(DgMasInvestigation.class).add(Restrictions.eq("ChargeCode.Id", Integer.parseInt(chargeCodeIdList.get(i)))).list();
											int invId=0;
											for(DgMasInvestigation list: invList)
											{
												invId = list.getId();
											}
											dgOrderdt.setInvestigation(new DgMasInvestigation(invId));
											//dgOrderdt.setInvestigationToMH(referToMhList.get(i));
											dgOrderdt.setInvestigationToMh("n");
											//dgOrderdt.setReferToMh(referToMhList.get(i));
											dgOrderdt.setReferToMh("n");
											hbt.saveOrUpdate(dgOrderdt);
											
											totaldgDtIdList.add(dgOrderdt.getId());
						}//end date comparision
					}//inner dt loop
				//	headerinvestigationDateList.removeAll(Arrays.asList(investigtionDate));
				}
				}//outer loop for hd
				
				//totalDbHdIdList
			
				totaldgDtIdList.add(0);
				dbDgheaderList.add(0);
				List<DgOrderdt> deleteDgOrderDtList = session.createCriteria(DgOrderdt.class)
						//.add( Restrictions.not( Restrictions.in("Id", icdIdList)))
						.add(Restrictions.not(Restrictions.in("Id", totaldgDtIdList)))
						.add(Restrictions.in("Orderhd.Id",  dbDgheaderList))
						.list(); 
				//System.out.println("size "+icdIdList.size() +" opdpatientDetailId"+opdpatientDetailId );
				//System.out.println("deleteDisCodeIdList "+deleteDisCodeIdList.size());		   
				if(deleteDgOrderDtList.size() >0)
					{
						hbt.deleteAll(deleteDgOrderDtList);
					}
				
				if(dbDgheaderList.size()!=totalDbHdIdList.size())
				{
					
				List<Integer> deleteHdIdList = new ArrayList<>();
					List<DgOrderhd> deletedgHeaderList =null;
					for(int i:dbDgheaderList)
					{
						if(!totalDbHdIdList.contains(i))
						{
							deleteHdIdList.add(i);
					}
				}
			
					if(deleteHdIdList.size() >0){
					   deletedgHeaderList = session.createCriteria(DgOrderhd.class)
							.add(Restrictions.in("Id",  deleteHdIdList))
							.list();
					   
					   hbt.deleteAll(deletedgHeaderList);
					} 
			}
				
			
			}
			else
			{

				
				 List<Integer> dbDgheaderList = null;
				 dbDgheaderList = session.createCriteria(DgOrderhd.class).add(
							Restrictions.eq("Createdon", consultationDateToInsert)).createAlias("Visit", "v").add(Restrictions.eq("v.Id",visitId))
							.setProjection(Projections.projectionList().add(Projections.groupProperty("Id")))
							.list();
				 
						if(dbDgheaderList.size()>0)
						{
							 dgOrderHdId =  box.getInt("dgOrderHdId");
							List<Integer> deleteInvestigation = new ArrayList <Integer>();
							 List<DgOrderdt> deletedgorderDtList = session.createCriteria(DgOrderdt.class)
									.createAlias("Orderhd", "hd")
									//.add(Restrictions.ne("OrderStatus", "p").ignoreCase())
				                  .add(Restrictions.in("hd.Id", dbDgheaderList)).list();
				       
							 List<DgOrderhd> deletedgorderHdList = session.createCriteria(DgOrderhd.class)
										//.add(Restrictions.ne("OrderStatus", "p").ignoreCase())
					                  .add(Restrictions.in("Id", dbDgheaderList)).list();
							 
				         if(deletedgorderDtList.size() >0)
				        	 hbt.deleteAll(deletedgorderDtList);
				         if(deletedgorderHdList.size() >0)
				        	 hbt.deleteAll(deletedgorderHdList);
				         
					
						}
					
			}
			
			
	/*		if (chargeCodeIdList.size() > 0) {
			String pacCode = HMSUtil.getProperties("adt.properties", "CodeForOTPAC");
			//Inpatient inpatient = new Inpatient();
			//inpatient.setId(inpatientId);
			MasEmployee emp = new MasEmployee();
			emp.setId(docId);
			
			//OpdSurgeryHeader opsSH = new OpdSurgeryHeader();
			//opsSH.setId(surgeryId);
			
			
			DgOrderhd dgOrderhd = null;
			if(dgOrderHdId!=0)
				dgOrderhd = (DgOrderhd)hbt.load(DgOrderhd.class,dgOrderHdId);
			else
			{
				dgOrderhd= new DgOrderhd();
				Map<String, Object> adMap = new HashMap<String, Object>();
			      adMap.put("tableObjectName", "DgOrderhd");            
		            adMap.put("isHospitalWise", "y");
		            adMap.put("hospitalId", hospitalId);
		            adMap.put("isYearly", "n");            
		            adMap.put("isMonthly", "n");
		            adMap.put("isPrefix", "n");
		            String orderSeqNo = HMSUtil.generateTransactionSequence(adMap, session, hbt);
		        	dgOrderhd.setOrderNo(orderSeqNo);
			}
			
			dgOrderhd.setOrderDate(new Date());
			dgOrderhd.setOrderTime(consultationTime);
			dgOrderhd.setHospital(masHospitalObj);
			dgOrderhd.setHin(patientObj);
			dgOrderhd.setDepartment(masDepartmentObj);
			dgOrderhd.setPrescribedBy(emp);
			
		//	dgOrderhd.setSurgery(opsSH);
			
			if (patientStatus.equalsIgnoreCase("Out Patient"))
			{
				dgOrderhd.setVisit(new Visit(visitId));
				dgOrderhd.setPatientType("OP");
			}
			else
			{
				dgOrderhd.setInpatient(new Inpatient(inpatientId));
				dgOrderhd.setPatientType("IP");
			}
			
			dgOrderhd.setTestType("Regular");
			dgOrderhd.setCreatedby(box.getString("userName"));
			dgOrderhd.setCreatedon(new Date());

			//String orderSeqNo = generateOrderNumber(box.getInt("hospitalId"));
			
			
			dgOrderhd.setClinicalNote(box.getString("clinicalNotes1"));
			dgOrderhd.setOrderStatus("P");
			dgOrderhd.setLabOrderStatus("P");
			dgOrderhd.setLastChgBy(users);
			dgOrderhd.setLastChgDate(new Date());
			dgOrderhd.setLastChgTime(consultationTime);
			//dgOrderhd.setInvestigationRequestionNo(patientInvestigationHeader);
			hbt.saveOrUpdate(dgOrderhd);
			
			for (int i = 0; i < chargeCodeIdList.size(); i++) {
				

				if(prevDtList.get(i)!=0)
				{
					
					if(investigationRemarksList.get(i)!="")
					{
					 DgOrderdt dgOrderdt = (DgOrderdt) hbt.load(DgOrderdt.class, prevDtList.get(i));
					 dgOrderdt.setOtRemarks(investigationRemarksList.get(i).trim());
					 hbt.update(dgOrderhd);
					}
				     continue;
				}
					
				
					
				
				List<Patient> patientList = new ArrayList<Patient>();   
				String patientTypeNameForHAL = null;
				String patientTypeNameForOther = null;
				String dgOrderBillingStatus ="";
				
				Properties properties = new Properties();
				URL resourcePath = Thread.currentThread().getContextClassLoader()
						.getResource("adt.properties");
				try {
					properties.load(resourcePath.openStream());
					
					 patientTypeNameForHAL = properties.getProperty("patientTypeNameForHAL");;
					 patientTypeNameForOther = properties.getProperty("patientTypeNameForOther");;
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				Criteria crit = session.createCriteria(Patient.class).add(
						Restrictions.eq("Id", hinId));
				patientList = crit.list();
							
				
				if(patientList.size()!=0)
				{
					if(patientList.get(0).getPatientType().getPatientTypeName().equals(patientTypeNameForHAL))
					{
						dgOrderBillingStatus ="y";
					}
					else if(patientList.get(0).getPatientType().getPatientTypeName().equals(patientTypeNameForOther))
					{
						if(patientList.get(0).getBillable().equals("y"))
						    dgOrderBillingStatus ="n";
						else if(patientList.get(0).getBillable().equals("n"))
							dgOrderBillingStatus ="y";
					}
				}
	
				MasChargeCode masChargeCode = new MasChargeCode();
				//System.out.println("Integer.parseInt(chargeCodeIdList.get(i))--"+Integer.parseInt(chargeCodeIdList.get(i)));
				masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
				//System.out.println("Integer.parseInt(chargeCodeIdList.get(i))--");
			
				//patientInvestigationDetails.setQuantity(quantityList.get(i));
				//patientInvestigationDetails.setReferToMh(referToMhList.get(i));

				//patientInvestigationDetails.setClinicalNotes(clinicalList.get(i));

				DgOrderdt dgOrderdt = new DgOrderdt();
				dgOrderdt.setOtStage(pacCode);
				dgOrderdt.setOrderhd(dgOrderhd);
				masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
				dgOrderdt.setChargeCode(masChargeCode);
				//dgOrderdt.setOrderQty(quantityList.get(i));
				dgOrderdt.setBillingStatus(dgOrderBillingStatus);
				dgOrderdt.setCreatedby(box.getString("userName"));
				dgOrderdt.setCreatedon(new Date());
				dgOrderdt.setLastChgBy(users);
				
				dgOrderdt.setLastChgDate(new Date());
				dgOrderdt.setLastChgTime(consultationTime);
				dgOrderdt.setMsgSent("n");
				// method written for taking out the values of mascharge
				// code and subcharge

				List<MasChargeCode> masChargeList = new ArrayList<MasChargeCode>();
				masChargeList = session.createCriteria(MasChargeCode.class).add(
						Restrictions.eq("Id", Integer.parseInt(chargeCodeIdList.get(i)))).list();
				
				MasChargeCode masChargeCodeObj = masChargeList.get(0);
				int mainChargeId = masChargeCodeObj.getMainChargecode()
				.getId();
				int subChargeId = masChargeCodeObj.getSubChargecode()
				.getId();
				if (masChargeCodeObj.getMainChargecode()
						.getMainChargecodeCode().equalsIgnoreCase("Lab")) {
					dgOrderdt.setOrderStatus("P");
				} else {
					dgOrderdt.setOrderStatus("P");
				}
				MasMainChargecode masMainChargecode = new MasMainChargecode();
				masMainChargecode.setId(mainChargeId);
				dgOrderdt.setMainChargecode(masMainChargecode);
				MasSubChargecode masSubChargecode = new MasSubChargecode();
				masSubChargecode.setId(subChargeId);
				dgOrderdt.setSubChargeid(masSubChargecode);
				dgOrderdt.setInvestigation(new DgMasInvestigation(Integer.parseInt(chargeCodeIdList.get(i))));
				//dgOrderdt.setInvestigationToMH(referToMhList.get(i));
				dgOrderdt.setInvestigationToMh("n");
				//dgOrderdt.setReferToMh(referToMhList.get(i));
				dgOrderdt.setReferToMh("n");
				hbt.save(dgOrderdt);
				sampleCollectedInvestigationIdList.add(dgOrderdt.getId());
			 
			}//chargeList loop
			
			
			}
		
			sampleCollectedInvestigationIdList.addAll(prevDtList);
			sampleCollectedInvestigationIdList.add(0);
			         List<DgOrderdt> deleteDgOrderDtList = session.createCriteria(DgOrderdt.class)
					  //.add( Restrictions.not( Restrictions.in("Id", icdIdList)))
					 .add(Restrictions.not(Restrictions.in("Id",sampleCollectedInvestigationIdList)))
					.add(Restrictions.eq("Orderhd.Id", dgOrderHdId))
					.list(); 
			         
			         
			         
			//System.out.println("size "+icdIdList.size() +" opdpatientDetailId"+opdpatientDetailId );
			//System.out.println("deleteDisCodeIdList "+deleteDisCodeIdList.size());		   
		if(deleteDgOrderDtList.size() >0)
			{
				hbt.deleteAll(deleteDgOrderDtList);
			}
	//delete header if no row exists in dt	
		 deleteDgOrderDtList = session.createCriteria(DgOrderdt.class)
				  //.add( Restrictions.not( Restrictions.in("Id", icdIdList)))
				.add(Restrictions.eq("Orderhd.Id", dgOrderHdId))
				.list(); 
		       
		if(deleteDgOrderDtList.size()==0)
		{
			List<DgOrderhd>  deleteDgOrdeHdtList = session.createCriteria(DgOrderhd.class)
					  //.add( Restrictions.not( Restrictions.in("Id", icdIdList)))
					.add(Restrictions.eq("Id", dgOrderHdId))
					.list(); 
			try {
				hbt.deleteAll(deleteDgOrdeHdtList);
			} catch ( Exception e) {
			    e.printStackTrace();
			}
			
		}*/
		
			succesfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}
		return succesfullyAdded;
	}


	public Map<String, Object> showWaitingListForSurgery(Map mapForDS) {

		Session session = (Session) getSession();
		List<OtPreAnesthesiaHd> waitList = new ArrayList<OtPreAnesthesiaHd>();
		List<MasDepartment> department=new ArrayList<MasDepartment>();
		Map<String, Object> map = new HashMap<String, Object>();

		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		 //  String hin="";
		   String empId = "";
	        String pName="";
	       
/*		if(mapForDS.get(HIN_NO)!=null)
		{
			hin = (String)mapForDS.get(HIN_NO);
		}
		*/
		if(mapForDS.get(PATIENT_NAME)!=null)
		{
			pName = (String)mapForDS.get(PATIENT_NAME);
		}
				
		if(mapForDS.get(EMPLOYEE_ID)!=null)
		{
			empId = (String)mapForDS.get(EMPLOYEE_ID);
		}
		
		try {
			//List<String>aList=new ArrayList<String>();
			//aList.add("A");
			//aList.add("R");
			/*Criteria criteria = session.createCriteria(OpdSurgeryHeader.class,"opd")
					.createAlias("Hospital", "h")
					.createAlias("Inpatient", "ip")
                     .add(Restrictions.in("ip.AdStatus", aList))
					.add(Restrictions.eq("h.Id", hospitalId))
					.add(Restrictions.eq("opd.PacStatus", "cleared").ignoreCase())
					.add(Restrictions.eq("BookingStatus", "Pending").ignoreCase());
			*/
			
			Criteria criteria = session.createCriteria(OtPreAnesthesiaHd.class)
					.createAlias("Hospital", "h")
					/*.createAlias("Inpatient", "ip")
                     .add(Restrictions.in("ip.AdStatus", aList))*/
					.add(Restrictions.eq("h.Id", hospitalId))
					.add(Restrictions.eq("Status", "n").ignoreCase())
					.add(Restrictions.eq("FitForSurgery", "y").ignoreCase());
					//.add(Restrictions.eq("BookingStatus", "Pending").ignoreCase());
			
			//		.add(Restrictions.eq("Status", "P").ignoreCase());
			
		/*	if(hin!="")
			{
				criteria.createAlias("Hin", "patient").add(Restrictions.eq("patient.HinNo", hin));
			}*/
			
			if(!pName.equals(""))
			{
				criteria.createAlias("Hin", "patient").add(Restrictions.like("patient.PFirstName", pName.toLowerCase()+"%").ignoreCase());
			}
			
			
			if(empId!="")
			{
				criteria.createAlias("Hin", "patient").add(Restrictions.eq("patient.ServiceNo", empId));
			}
			
		
			waitList=criteria.list();
	/*		for(OtPreAnesthesiaHd hd : waitList)
			{
				System.out.println("id "+hd.getId()+" size "+hd.getOtPreAnesthesiaDetails().size());
			}*/
	
			  if(waitList.size()>0){
					List<OtPreAnesthesiaDetail > otPreAnesthesiaSurgery = new ArrayList<OtPreAnesthesiaDetail>();
					List<String > otPreAnesthesiaProcedureList = new ArrayList<String>();
				  for(OtPreAnesthesiaHd preAHD: waitList)
				  {
					  String proc ="";
				  otPreAnesthesiaSurgery = session.createCriteria(
							OtPreAnesthesiaDetail.class)
							//.createAlias("OpdSurgeryHeader", "OpdSurgeryHeader")
							.add(Restrictions.eq("AnesthesiaHd.Id",preAHD.getId()))
							.list();
				  int i = 1;
					  for(OtPreAnesthesiaDetail preADT:otPreAnesthesiaSurgery)
					  {
						 
						  if(i++>1)
							  proc +=" | ";
						  proc += preADT.getOpdSurgeryDetail().getChargeCode().getChargeCodeName();
					  }
					  otPreAnesthesiaProcedureList.add(proc);
				  }
				  
					map.put("otPreAnesthesiaProcedureList", otPreAnesthesiaProcedureList);
				}
			
			//session.createCriteria(.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			// department=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			// System.out.println(department.size()+"=============="+waitList.size());
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		
		map.put("department", department);
		map.put("waitList", waitList);
		return map;
	}
	
	public Map<String, Object> showPACClearedListForOTBooking(Map mapForDS) {
		Session session = (Session) getSession();
		//List<OpdSurgeryHeader> pacList = new ArrayList<OpdSurgeryHeader>();
		List<OtBooking> otList = new ArrayList<OtBooking>();
		List<MasOt> masOtList = new ArrayList<MasOt>();
		Map<String, Object> map = new HashMap<String, Object>();

		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		   String hin="";
		   String empId = "";
		   int otId = 0;
	        String pName="";
	        Date surgeryDate =null;
		
	        if(mapForDS.get(HIN_NO)!=null)
			{
				hin = (String)mapForDS.get(HIN_NO);
			}
			
			if(mapForDS.get(PATIENT_NAME)!=null)
			{
				pName = (String)mapForDS.get(PATIENT_NAME);
			}
					
			if(mapForDS.get(EMPLOYEE_ID)!=null)
			{
				empId = (String)mapForDS.get(EMPLOYEE_ID);
			}

			if(mapForDS.get(OT_ID)!=null)
			{
				otId = (Integer)mapForDS.get(OT_ID);
			}
	        
			if(mapForDS.get(SURGERY_DATE)!=null)
			{
				surgeryDate = HMSUtil
						.convertStringTypeDateToDateType(mapForDS.get(SURGERY_DATE).toString());
				
			}
	        
	//	String patientStatus = "Cleared";
		//String otBookingStatus = "y";
		try {
			/*pacList = session.createCriteria(OpdSurgeryHeader.class).add(
					Restrictions.eq("PacStatus", patientStatus)).list();*/
			masOtList = session.createCriteria(MasOt.class).add(
					Restrictions.eq("Status", "y")).list();
			 Criteria  criteria = session.createCriteria(OtBooking.class)
					       		    .createAlias("Hin", "patient")
					       			.createAlias("Ot", "ot")
					       			.add(Restrictions.eq("SurgeryStatus", "n"));
					       			//.add(Restrictions.eq("OtBookingStatus", otBookingStatus));
		
			if(!pName.equals(""))
			{
				criteria.add(Restrictions.like("patient.PFirstName", pName.toLowerCase()+"%").ignoreCase());
			}
			
			
			if(empId!="")
			{
				criteria.add(Restrictions.eq("patient.ServiceNo", empId));
			}
			
			
			if(otId!=0)
			{
				criteria.add(Restrictions.eq("ot.Id", otId));
			}

			if(surgeryDate!=null)
			{
				criteria.add(Restrictions.eq("SurgeryDate", surgeryDate));
			}
			otList = criteria.list();
			
			

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		//System.out.println("u rin pac clearance list method with list size----"+ pacList.size() +" "+otList.size() );
	/*	map.put("pacList", pacList);*/
		map.put("masOtList", masOtList);
		map.put("otList", otList);
		return map;
	}
	public Map<String, Object> searchpatientForOTBooking(Map mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdSurgeryHeader> pacList = new ArrayList<OpdSurgeryHeader>();
		List<OtBooking> otList = new ArrayList<OtBooking>();
		String serviceNo = "";
		String hinNo = "";
		String employeeName = "";
		String patientType = "";

		int deptId = 0;
		Session session = (Session) getSession();

		if (mapForDS.get("deptId") != null) {
			deptId = (Integer) mapForDS.get("deptId");
		}
		if (mapForDS.get("serviceNo") != null) {
			serviceNo = (String) mapForDS.get("serviceNo");
		}
		if (mapForDS.get("hinNo") != null) {
			hinNo = (String) mapForDS.get("hinNo");
		}
		if (mapForDS.get("patientType") != null) {
			patientType = (String) mapForDS.get("patientType");
			// //System.out.println("Service type name in ds---"+serviceTypeName+"-----department id in ds---"+deptId);
		}
		String patientStatus = "Cleared";
		String otBookingStatus = "c";
		
		
		otList = session.createCriteria(OtBooking.class).add(
				Restrictions.eq("OtBookingStatus", otBookingStatus)).list();
		
		Criteria crit = session.createCriteria(OpdSurgeryHeader.class).add(
						Restrictions.eq("PacStatus", patientStatus)).createAlias("Hin", "hin");
		if (hinNo.equals("")) {
			if (!patientType.equals("")) {
				crit = crit.add(Restrictions.eq("PatientStatus", patientType));
			}
			if (!serviceNo.equals("")) {
				//System.out.println("service number-----" + serviceNo);
				crit = crit.add(Restrictions.eq("hin.ServiceNo", serviceNo));
			}

		} else {
			crit = crit.add(Restrictions.eq("hin.HinNo", hinNo));
		}
		pacList = crit.list();
		//System.out.println("Size of list for patient search----"+ pacList.size() + "-- criteria--" + crit);
		
		map.put("pacList", pacList);
		map.put("otList", otList);

		return map;
	}
	public Map<String, Object> showOTBookingJsp(Map mapForDS) {
		Session session = (Session) getSession();
		List<OtPreAnesthesiaDetail> opdSurgeryList = new ArrayList<OtPreAnesthesiaDetail>();
		List<OpdSurgeryDetail> opdSurgeryDetailList = new ArrayList<OpdSurgeryDetail>();
		Map<String, Object> map = new HashMap<String, Object>();
	//	List<OtMasChargeDetails> otList = new ArrayList<OtMasChargeDetails>();
		List<MasOt> otl=new ArrayList<MasOt>();
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();
		List<OtBooking> otBookingList1 = new ArrayList<OtBooking>();
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		List<OtPreAnesthesiaHd> preAnesthesiaList = new ArrayList<OtPreAnesthesiaHd>();
	//	List<HospitalDoctorUnitM> doctorUnit = new ArrayList<HospitalDoctorUnitM>();
		
	//	List<OtMasUnitDay> otMasUnitDays = new ArrayList<OtMasUnitDay>();
		
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		
		int id = (Integer) mapForDS.get("PacHdId");
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		//int deptId=(Integer) mapForDS.get(DEPARTMENT_ID);
		//int empId=(Integer) mapForDS.get("empId");
		int bookingId = 0;
		//int unitId=0;
		int chargeCodeId = 0;
	//	String empCategory = "Doctor";
		try {
			//SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			//DateFormat f = new SimpleDateFormat("EEEE");
			//Date bookingDate=dateFormat.parse("22/09/2015");
			 Calendar now = Calendar.getInstance();
			    String[] strDays = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
			    String dayName = strDays[now.get(Calendar.DAY_OF_WEEK) - 1];
			     
			
		/*	 doctorUnit= session.createCriteria(HospitalDoctorUnitM.class,"um")
					//.createAlias("UnitM", "um")
			        .add(Restrictions.eq("um.Hospital.Id", hospitalId))
			        //.add(Restrictions.eq("Employee.Id", empId))
			        .add(Restrictions.eq("Status", "y").ignoreCase()).list();*/
			        //.setFirstResult(0)
			        //.setMaxResults(1).uniqueResult();
	
/*			otMasUnitDays=session.createCriteria(OtMasUnitDay.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Department.Id", deptId))
					//.add(Restrictions.eq("UnitM.Id", doctorUnit!=null?doctorUnit.getUnitM().getId():0))
					.add(Restrictions.eq("DayName",dayName))
					.list();*/

			otBookingList = session.createCriteria(OtBooking.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Id", bookingId)).list();

			otBookingList1 = session
					.createCriteria(OtBooking.class)
					.createAlias("Ot", "ot")
					.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
					//.add(Restrictions.eq("OtPostAnethesiaStatus", "n")
							//.ignoreCase()).list();
			/*
			 * .setProjection( Projections.property("ot.Id")).addOrder(
			 * Order.asc(("ot.Id"))).list();
			 */

			opdSurgeryList = session.createCriteria(OtPreAnesthesiaDetail.class)
					//.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("AnesthesiaHd.Id", id)).list();
if(opdSurgeryList.size() >0)
{
			opdSurgeryDetailList = session
					.createCriteria(OpdSurgeryDetail.class)
					.createAlias("OpdSurgery", "opdSurgery")
					.add(Restrictions.eq("opdSurgery.Hospital.Id", hospitalId))
					.add(Restrictions.eq("opdSurgery.Id", id)).list();
			if (opdSurgeryDetailList.size() > 0) {
				chargeCodeId = opdSurgeryDetailList.get(0).getChargeCode()
						.getId();
			}
		/*	otList = session.createCriteria(OtMasChargeDetails.class)
					.createAlias("ChargeCode", "chargeCode")
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("chargeCode.Id", chargeCodeId)).list();*/
			
			otl=session.createCriteria(MasOt.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			/*empList = session
					.createCriteria(MasEmployee.class)
					// .createAlias("Department", "dept")
					// .createAlias("EmpCategory", "empCategory")
					// .add(Restrictions.eq("dept.Id", deptId))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("EmpCategory.Id", 1))
					.addOrder(Order.asc("FirstName")).list();*/
		/*	OpdSurgeryHeader opdSurgeryHeader = (OpdSurgeryHeader) opdSurgeryList
					.get(0);*/
/*			if (opdSurgeryHeader.getPatientStatus().equals("InPatient")) {
				int inpatientId = opdSurgeryHeader.getInpatient().getId();
				// preAnesthesiaList = session
				// .createQuery(
				// "select ot from OtPreAnesthesiaDetails as ot  where ot.Inpatient.Id='"
				// + inpatientId
				// +
				// "' and ot.ChangedDate=(select max(ot.ChangedDate) from OtPreAnesthesiaDetails as ot where ot.Inpatient.Id='"
				// + inpatientId + "')").list();
				//
				preAnesthesiaList = session
						.createCriteria(OtPreAnesthesiaDetails.class)
						.createAlias("Inpatient", "inpatient")
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("OrderNo", id))
						.add(Restrictions.eq("inpatient.Id", inpatientId))
						.list();

				// preAnesthesiaList=session.createCriteria(OtPreAnesthesiaDetails.class).createAlias("Inpatient","inpatient").add(Restrictions.eq("Inpatient.Id",
				// inpatientId)).list();
			} else {
				int visitId = opdSurgeryHeader.getVisit().getId();
				// preAnesthesiaList = session
				// .createCriteria(OtPreAnesthesiaDetails.class)
				// .add(Restrictions.eq("Hospital.Id", hospitalId))
				// .createAlias("Visit", "visit")
				// .add(Restrictions.eq("visit.Id", visitId)).list();

				preAnesthesiaList = session
						.createCriteria(OtPreAnesthesiaDetails.class)
						.createAlias("Visit", "visit")
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("OrderNo", id))
						.add(Restrictions.eq("visit.Id", visitId)).list();
			}
			*/
		
		
			String departmentTypeCode = null;
			String departmentTypeCodeForOT = null;
			List<String > DeptCodeList =new ArrayList<String>();
			try
			{
				 departmentTypeCode = HMSUtil.getValuesFromPropertiesFile("adt.properties", "departmentTypeCodeForOpd");
				 departmentTypeCodeForOT = HMSUtil.getValuesFromPropertiesFile("adt.properties", "departmentTypeCodeForOT");
				 
				 DeptCodeList.add(departmentTypeCode);
				 DeptCodeList.add(departmentTypeCodeForOT);

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			if(opdSurgeryList.get(0).getAnesthesiaHd().getHin()!=null)
			{
				List<DischargeIcdCode>icdList=new ArrayList<DischargeIcdCode>();
				icdList=session.createCriteria(DischargeIcdCode.class).add(Restrictions.eq("Hin.Id", opdSurgeryList.get(0).getAnesthesiaHd().getHin().getId())).list();
				
				Set<MasIcd> uniqueIcdList=new HashSet <MasIcd>();
				for(DischargeIcdCode icd2:icdList){
					MasIcd masIcd = icd2.getIcd();
					if(icd2.getIcd()!=null){
						uniqueIcdList.add(masIcd);
						
					}
				}
				
				String icd="";
				for(MasIcd icd2:uniqueIcdList){
					icd=icd+"\n"+icd2.getIcdName();
				}
				
				map.put("icd", icd);
			}
			
			departmentList=session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.in("dt.DepartmentTypeCode",DeptCodeList))
					.addOrder(Order.asc("DepartmentName"))
					.list();

		//	map.put("doctorUnit", doctorUnit);	
}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("opdSurgeryDetailList", opdSurgeryDetailList);
		map.put("opdSurgeryList", opdSurgeryList);
		//map.put("otList", otList);
		map.put("empList", empList);
		map.put("preAnesthesiaList", preAnesthesiaList);
		map.put("otBookingList", otBookingList);
		map.put("otBookingList1", otBookingList1);
		map.put("otl", otl);
		map.put("surgeryId", chargeCodeId);		
		map.put("departmentList", departmentList);
		
	//	map.put("otMasUnitDays", otMasUnitDays);		
		
		
		return map;
	}


	public Map<String, Object> getSurgeonListForAutoComplete(Map mapForDS) {
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String empCategoryCode ="";
		try {
			// int deptId=(Integer)mapForDS.get("deptId");

			String str = "%" + mapForDS.get("autoHint") + "%";
			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
				
				empCategoryCode = properties.getProperty("empCategoryCodeForDoctor");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Criteria crit = session.createCriteria(MasEmployee.class)
					.createAlias("EmpCategory", "empCategory").add(
							Restrictions.eq("empCategory.EmpCategoryCode",
									empCategoryCode)).add(
							Restrictions.like("FirstName", str)).add(
							Restrictions.eq("Status", "y"));
			
			
/*			String empCategoryName = "Doctor";
			Criteria crit = session.createCriteria(MasEmployee.class)
					.createAlias("EmpCategory", "empCategory").add(
							Restrictions.eq("empCategory.EmpCategoryName",
									empCategoryName)).add(
							Restrictions.like("FirstName", str)).add(
							Restrictions.eq("Status", "y"));*/
			
			

			//crit.setFirstResult(0);
			//crit.setMaxResults(10);
			empList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("empList", empList);
		return map;
	}

	public Map<String, Object> submitOTBookingDetails(Map mapForDS) {
		Session session = (Session) getSession();
		String succesfullyAdded = "";
		String value = "";
		//String patientStatus = "";
		//String chargeName = "";
		String startTime = null;
		String endTime = null;
		String surgeryDate = "";
		String toTimeStr = "0";
		int loopCount = 1;

		OtMasChargeDetails otMasChargeDetails = new OtMasChargeDetails();
		//int surgeryId = 0;
		Transaction tx = null;
		Box box = (Box) mapForDS.get("box");
		int pacHdId = 0;
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		int userId = (Integer) mapForDS.get(USER_ID);
		int deptId = (Integer) mapForDS.get("departmentId");
		int opdSurgeryHeaderId = box.getInt("opdSurgeryHeaderId");
		 startTime = box.getString("startTime");
		 endTime = box.getString("endTime");
		
	//	int ChargeDetailSurgeryId = 0;
		List<OtBookingDt> otBookingList = new ArrayList<OtBookingDt>();
	//	List<OtMasChargeDetails> otMasChargeDetailsList = new ArrayList<OtMasChargeDetails>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		String surgeryDtStringArrary[] = (String[]) mapForDS.get("surgeryDtStringArrary");
		
		List<Integer> surgeryDtList = new ArrayList<Integer>();
		for(int a = 0 ; a<surgeryDtStringArrary.length; a++)
		{
			surgeryDtList.add(Integer.parseInt(surgeryDtStringArrary[a]));
		}
		
		
		try {
			pacHdId = box.getInt("pacHdId");
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
		/*	startTime = box.getString("surgeryTime");
			int toTime =0;
			if (box.getString("endTime") != null
					&& !box.getString("endTime").equals("")) {
				endTime = box.getString("endTime");
				
				toTime = Integer.parseInt(endTime.substring(0, 2));
			}*/
			int date = 0;
			int month = 0;

	/*		if (toTime >= 24) {
				endTime = "23:59";
				loopCount = 2;
				toTime = toTime - 24;
				if (toTime < 10) {
					toTimeStr = "0" + toTime + ":" + endTime.substring(3, 5);
				} else {
					toTimeStr = ((Integer) (toTime)).toString() + ":"
							+ endTime.substring(3, 5);
				}
	
			}
			*/
			surgeryDate = box.getString("tentativeDate");

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(surgeryDate));
			c.add(Calendar.DATE, 1); // number of days to add
			surgeryDate = sdf.format(c.getTime());
			int hinId = box.getInt(HIN_ID);
			/*chargeName = box.getString("chargeName");
			if (chargeName != null) {
				int index1 = chargeName.lastIndexOf("[");
				int index2 = chargeName.lastIndexOf("]");
				index1++;
				surgeryId = Integer.parseInt(chargeName.substring(index1,
						index2));

			}*/
			
			//surgeryId = box.getInt("surgeryId");
			//System.out.println("surgeryId==in ds==="+surgeryId);
			int orderNo = box.getInt("orderNo");
			// hinId----"+hinId+"--value ofsurgery--"+surgeryId+" value of order
			// no--"+orderNo);
			otBookingList = session
					.createCriteria(OtBookingDt .class)
					.add(Restrictions.in("OtPreAnesthesiaDetail.Id", surgeryDtList))
				//	.createAlias("Hin", "hinId")
					//.createAlias("ChargeCode", "chargeCode")
					//.add(Restrictions.eq("hinId.Id", hinId))
					//.add(Restrictions.eq("chargeCode.Id"))
					//.add(Restrictions.eq("OrderNo", ))
				//	.add(Restrictions.eq("OrderNo", orderNo))
					//.add(Restrictions.eq("Hospital.Id", hospitalId))
					//.add(Restrictions.eq("OpdSurseryHeader.Id",opdSurgeryHeaderId))
							
							.list();

		/*	otMasChargeDetailsList = session
					.createCriteria(OtMasChargeDetails.class)
					.createAlias("ChargeCode", "chargeCode")
					.add(Restrictions.eq("chargeCode.Id", surgeryId))
					//.add(Restrictions.eq("Hospital.Id", hospitalId))
					.list();*/

		/*	if (otMasChargeDetailsList.size() > 0) {
				ChargeDetailSurgeryId = otMasChargeDetailsList.get(0).getId();
			}*/
			//System.out.println("ChargeDetailSurgeryId===44=="+ChargeDetailSurgeryId);
			/*for (int i = 1; i <= loopCount; i++) {*/
			
			/*private jkt.hms.masters.business.Inpatient inpatient;
			private jkt.hms.masters.business.OtMasChargeDetails surgery;
			private jkt.hms.masters.business.MasDepartment department;
			private jkt.hms.masters.business.Patient hin;
			private jkt.hms.masters.business.HospitalDoctorUnitM unit;
			private jkt.hms.masters.business.MasOt ot;
			private jkt.hms.masters.business.MasChargeCode chargeCode;
			private jkt.hms.masters.business.OpdSurgeryHeader opdSurseryHeader;
			private jkt.hms.masters.business.MasBed bed;
			private jkt.hms.masters.business.MasHospital hospital;
			private jkt.hms.masters.business.Visit visit;
			private jkt.hms.masters.business.MasEmployee unitHead;
			private jkt.hms.masters.business.Users lastChgdBy;
			private jkt.hms.masters.business.MasEmployee bookedBy;*/
				if (otBookingList.size() == 0 || otBookingList == null) {
					OtBooking otBooking = new OtBooking();
					otBooking.setSurgeryDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.getString("tentativeDate")));
					otBooking.setSurgeryStartTime(startTime);
					otBooking.setSurgeryEndTime(endTime);
					/*MasChargeCode masChargeCode = new MasChargeCode();
					masChargeCode.setId(surgeryId);
					otBooking.setChargeCode(masChargeCode);*/

				//	chargeName = box.getString("chargeName");
				/*	if (surgeryId != 0) {
						otMasChargeDetails.setId(ChargeDetailSurgeryId);
						.setSurgery (otMasChargeDetails);
					}*/
					
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(box.getInt("bookedById"));
					otBooking.setBookedBy(masEmployee);
					
					/*HospitalDoctorUnitM doctorUnitM=(HospitalDoctorUnitM) hbt.get(HospitalDoctorUnitM.class, box.getInt("unitId"));
					otBooking.setUnit(doctorUnitM);*/
					
			/*		Set<HospitalDoctorUnitT> doctorUnitT=doctorUnitM.getHospitalDoctorUnitTs();
					if(doctorUnitT!=null)
					{
						for (HospitalDoctorUnitT hospitalDoctorUnitT : doctorUnitT) {
							if(hospitalDoctorUnitT.getHeadFleg()!=null && hospitalDoctorUnitT.getHeadFleg().equalsIgnoreCase("y") )
							{
								otBooking.setUnitHead(hospitalDoctorUnitT.getEmployee());
								break;
							}
							
						}
					}*/
					
					
					MasDepartment department=new MasDepartment();
					department.setId(box.getInt("departmentId"));
					otBooking.setDepartment(department);
					
					MasOt masot=new MasOt();
					masot.setId(box.getInt("otId"));
					otBooking.setOt(masot);
					
					MasBed masbed=new MasBed(); 
					masbed.setId(box.getInt("tableId"));
					otBooking.setBed(masbed);
					
					/*MasOt masOt = new MasOt();
					masOt.setId(box.getInt("ot"));
					otBooking.setOt(masOt);*/
					
					Patient patient = new Patient();
					patient.setId(box.getInt(HIN_ID));
					otBooking.setHin(patient);
					
					//patientStatus = box.getString("patientStatus");
				/*	if (box.getInt(VISIT_ID)!=0) {
						Visit visit = new Visit();
						visit.setId(box.getInt(VISIT_ID));
						otBooking.setVisit(visit);
					} else {
						Inpatient inpatient = new Inpatient();
						inpatient.setId(box.getInt(INPATIENT_ID));
						otBooking.setInpatient(inpatient);
					}*/
					if (box.getInt(VISIT_ID)!=0) {
						Visit visit = new Visit();
						visit.setId(box.getInt(VISIT_ID));
						otBooking.setVisit(visit);
					}
					if (box.getInt(INPATIENT_ID)!=0) {
						Inpatient inpatient = new Inpatient();
						inpatient.setId(box.getInt(INPATIENT_ID));
						otBooking.setInpatient(inpatient);
					}
					
					
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					otBooking.setHospital(masHospital);
					Users users = new Users();
					users.setId(userId);
					otBooking.setLastChgdBy(users);

					if (box.getString("changedDate") != null
							&& !box.getString("changedDate").equals("")) {
						otBooking.setLastChgdDate(HMSUtil
								.convertStringTypeDateToDateType(box
										.getString("changedDate")));
					}
					
					
					otBooking.setLastChgdTime(box.getString("changedTime"));
					otBooking.setOrderNo(box.getInt("orderNo"));
					//otBooking.setOtBookingStatus("y");
					otBooking.setOtPostAnethesiaStatus("n");
					otBooking.setOtPreAnesthesiaStatus("n");
					otBooking.setSurgeryStatus("n");
					otBooking.setBookingType(box.getString("bookingType"));
					//OpdSurgeryHeader opdSurgeryHeader1 = new OpdSurgeryHeader();
					//System.out.println("opdSurgeryHeaderId=in ds==="+opdSurgeryHeaderId);
				//	opdSurgeryHeader1.setId(opdSurgeryHeaderId);
					//otBooking.setOpdSurseryHeader(opdSurgeryHeader1);
					otBooking.setOrderNo(orderNo);
					otBooking.setOtRemarks(box.getString("ot_remarks"));
					hbt.save(otBooking);
				map.put("bookingId", otBooking.getId());
					for(int a : surgeryDtList)
					{
						OtBookingDt otBdt = new OtBookingDt();
						otBdt.setOtBookingHd(otBooking);;
						
						OtPreAnesthesiaDetail pacdt = (OtPreAnesthesiaDetail)hbt.load(OtPreAnesthesiaDetail.class, a);
						//sdt.setId(a);
						
						otBdt.setOtPreAnesthesiaDetail(pacdt);;
						otBdt.setStatus("n");
						hbt.save(otBdt);
																
						pacdt.setStatus("y");
						hbt.update(pacdt);

						OpdSurgeryDetail sdt = (OpdSurgeryDetail)hbt.load(OpdSurgeryDetail.class, pacdt.getOpdSurgeryDetail().getId());
						sdt.setStatus("n");
						sdt.setOtBookingDt(otBdt);
						hbt.update(sdt);
					}
					
					String [] pac_Status = {"y","c"};
					int totalCompletedPac = session.createCriteria(OtPreAnesthesiaDetail.class)
							  .add(Restrictions.eq("AnesthesiaHd.Id", pacHdId ))
							  .add(Restrictions.in("Status", pac_Status))
							  .list().size();
					int totalSurgery = session.createCriteria(OtPreAnesthesiaDetail.class)
							  .add(Restrictions.eq("AnesthesiaHd.Id", pacHdId ))
							  .list().size();
					if(totalCompletedPac == totalSurgery)
					{
						OtPreAnesthesiaHd pacHD = (OtPreAnesthesiaHd) hbt.load(OtPreAnesthesiaHd .class, pacHdId);
						pacHD.setStatus("y");
						hbt.update(pacHD);
					}

					// List opdSurgeryList = new ArrayList();
					// int id = 0;
					// patientStatus = box.getString("patientStatus");
					// if (patientStatus.equalsIgnoreCase("OutPatient")) {
					//
					// int visitId = box.getInt("visitId");
					// // opdSurgeryList = session
					// // .createCriteria(OpdSurgeryHeader.class)
					// // .createAlias("Visit", "visit")
					// // .add(Restrictions.eq("visit.Id", visitId))
					// // .list();
					// OpdSurgeryHeader opdSurgeryHeader = (OpdSurgeryHeader)
					// opdSurgeryList
					// .get(0);
					// id = opdSurgeryHeader.getId();
					// } else {
					//
					// int inpatientId = box.getInt("inPatientId");
					// List opdSurgeryHList = session
					// .createQuery(
					// "select ot from OpdSurgeryHeader as ot  where ot.Inpatient.Id='"
					// + inpatientId
					// +
					// "' and ot.RequisitionDate=(select max(ot.RequisitionDate) from OpdSurgeryHeader as ot where ot.Inpatient.Id='"
					// + inpatientId + "')").list();
					// OpdSurgeryHeader opdObj = (OpdSurgeryHeader)
					// opdSurgeryHList
					// .get(0);
					// id = opdObj.getId();
					// }
				/*	OpdSurgeryHeader opdSurgeryHeaderObj = (OpdSurgeryHeader) hbt
							.load(OpdSurgeryHeader.class, opdSurgeryHeaderId);
					opdSurgeryHeaderObj.setBookingStatus("Cleared");
					hbt.update(opdSurgeryHeaderObj);
*/
					if (mapForDS.get("empIdList") != null) {
						List empIdList = (List) mapForDS.get("empIdList");
						List<String> roleList = (List) mapForDS.get("roleList");
						//Iterator itr = empIdList.iterator();
						//while (itr.hasNext()) {
						
						for(int i=0;i<empIdList.size();i++){
						
							int empId = Integer.parseInt(empIdList.get(i).toString());
							OtBookSurgeon otBookSurgeon = new OtBookSurgeon();
							otBookSurgeon.setBooking(otBooking);
							MasEmployee masEmployee2 = new MasEmployee();
							masEmployee2.setId(empId);
							otBookSurgeon.setEmployee(masEmployee2);
							otBookSurgeon.setOrderNo(box.getInt("orderNo"));
							
							String role=roleList.get(i).toString();
							otBookSurgeon.setRole(role);
							
							hbt.save(otBookSurgeon);
						}
					}

					
					/* MasBed masbed1 =  (MasBed)hbt.load(MasBed.class, box.getInt("tableId"));
					 int bedstaus =Integer.parseInt(HMSUtil.getValuesFromPropertiesFile("adt.properties", "bedStatusOccupiedId".trim()));
					 MasBedStatus bedstatus =  (MasBedStatus)hbt.load(MasBedStatus.class, bedstaus);
					 masbed1.setBedStatus(bedstatus);
					 hbt.update(masbed1);*/
					
					value = "OT Booked For the Patient";
					succesfullyAdded = "true";
					map.put("succesfullyAdded", succesfullyAdded);
					map.put("value", value);

				} else {

					succesfullyAdded = "false";
					value = "OT is Already Booked For this Patient.";
					map.put("value", value);
					map.put("succesfullyAdded", succesfullyAdded);

				}

			/*}*/
		  tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			// --------Session Closing----------
			session.close();
		}

		return map;
	}

	public Map<String, Object> searchPatientDetailsForDisposal(Map mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> patientList = new ArrayList<Inpatient>();

		String serviceNo = "";
		String hinNo = "";

		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		String serviceFName = "";
		String serviceMName = "";
		String serviceLName = "";

		Session session = (Session) getSession();

		if (mapForDS.get("serviceNo") != null) {

			serviceNo = (String) mapForDS.get("serviceNo");
			//System.out.println("service number====" + serviceNo);
		}
		if (mapForDS.get("hinNo") != null) {

			hinNo = (String) mapForDS.get("hinNo");
			//System.out.println("HIN number====" + hinNo);
		}

		if (mapForDS.get("patientFName") != null) {
			patientFName = (String) mapForDS.get("patientFName");
		}
		if (mapForDS.get("patientMName") != null) {
			patientMName = (String) mapForDS.get("patientMName");
		}
		if (mapForDS.get("patientLName") != null) {
			patientLName = (String) mapForDS.get("patientLName");
		}
		if (mapForDS.get("serviceFName") != null) {
			serviceFName = (String) mapForDS.get("serviceFName");
		}
		if (mapForDS.get("serviceMName") != null) {
			serviceMName = (String) mapForDS.get("serviceMName");
		}
		if (mapForDS.get("serviceLName") != null) {
			serviceLName = (String) mapForDS.get("serviceLName");
		}

		String patientStatus = "A";
		// Criteria crit =
		// session.createCriteria(Patient.class).add(Restrictions.not(Expression.eq("PatientStatus",
		// patientStatus)));
		Criteria crit = session.createCriteria(OtBooking.class).add(
				Restrictions.eq("OtBookingStatus", "y"))
				.createAlias("Hin", "p");

		if (!serviceNo.equals("")) {
			crit = crit.add(Restrictions.eq("p.ServiceNo", serviceNo));
		}

		if (!patientFName.equals("")) {
			crit = crit.add(Restrictions.like("p.PFirstName", patientFName
					+ "%"));
		}
		if (!patientMName.equals("")) {
			crit = crit.add(Restrictions.like("p.PMiddleName", patientMName
					+ "%"));
		}
		if (!patientLName.equals("")) {
			crit = crit.add(Restrictions
					.like("p.PLastName", patientLName + "%"));
		}
		if (!serviceFName.equals("")) {
			crit = crit.add(Restrictions.like("p.SFirstName", serviceFName
					+ "%"));
		}
		if (!serviceMName.equals("")) {
			crit = crit.add(Restrictions.like("p.SMiddleName", serviceMName
					+ "%"));
		}
		if (!serviceLName.equals("")) {
			crit = crit.add(Restrictions
					.like("p.SLastName", serviceLName + "%"));
		}

		if (!hinNo.equals("")) {
			crit = crit.add(Restrictions.eq("p.HinNo", hinNo));
		}
		patientList = crit.list();
		map.put("patientList", patientList);
		return map;

	}

	public Map<String, Object> showHumanBodyPartsDisposalJsp(Map mapForDS) {
		List<OtBooking> patientDetailList = new ArrayList<OtBooking>();
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		List<TransactionSequence> entryNoList = new ArrayList<TransactionSequence>();
		List<OtHumanBodyDisposal> otHumanBodyPartsList = new ArrayList<OtHumanBodyDisposal>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String tableNameForTransactionSequence = "OtHumanBodyDisposal";
		int entryNo = 0;
		try {
			int otBookingId = (Integer) mapForDS.get("otBookingId");
			patientDetailList = session.createCriteria(OtBooking.class)
					// .createAlias("Hin","hin")
					.add(Restrictions.eq("Id", otBookingId)).add(
							Restrictions.eq("BodyPartsDisposalStatus", "n"))
					.list();
			if (patientDetailList.size() > 0) {
				entryNoList = session.createCriteria(TransactionSequence.class)
						.add(
								Restrictions.eq("Tablename",
										tableNameForTransactionSequence))
						.list();
				TransactionSequence transactionSequence = (TransactionSequence) entryNoList
						.get(0);
				entryNo = transactionSequence.getTransactionSequenceNumber();
				entryNo = entryNo + 1;
			} else {
				patientDetailList = session.createCriteria(OtBooking.class)
						.add(Restrictions.eq("Id", otBookingId))
						.add(Restrictions.eq("BodyPartsDisposalStatus", "y"))
						.list();

				otHumanBodyPartsList = session.createCriteria(
						OtHumanBodyDisposal.class).add(
						Restrictions.eq("OtBooking.Id", otBookingId)).list();
				map.put("otHumanBodyPartsList", otHumanBodyPartsList);
			}

			empList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).list();
			deptList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		map.put("empList", empList);
		map.put("deptList", deptList);
		map.put("entryNo", entryNo);

		return map;
	}

	public boolean submitHumanBodyPartsDisposal(Map mapForDS) {
		Session session = (Session) getSession();
		boolean succesfullyAdded = false;

		Transaction tx = null;
		Box box = (Box) mapForDS.get("box");
		List<TransactionSequence> entryNoList = new ArrayList<TransactionSequence>();
		String tableNameForTransactionSequence = "OtHumanBodyDisposal";
		int otBookingId = box.getInt("otBookingId");

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			OtHumanBodyDisposal otHumanBodyDisposal = new OtHumanBodyDisposal();
			otHumanBodyDisposal.setTissueOrgan(box.get("tissueOrgan"));
			Patient patient = new Patient();
			patient.setId(box.getInt("hinId"));
			otHumanBodyDisposal.setHin(patient);
			otHumanBodyDisposal.setEntryNo(box.getInt("entryNo"));

			OtBooking booking = new OtBooking();
			booking.setId(otBookingId);
			otHumanBodyDisposal.setOtBooking(booking);

			otHumanBodyDisposal
					.setClinicalNotes(box.getString("clinicalNotes"));
			otHumanBodyDisposal.setTimeOfDispatch(box
					.getString("timeOfDispatch"));

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(box.getInt("deptId"));
			otHumanBodyDisposal.setSpecimenDispatchedBy(masDepartment);

			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(box.getInt("empId"));
			otHumanBodyDisposal.setSpecimenRecievedBy(masEmployee);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("hospitalId"));
			otHumanBodyDisposal.setHospital(masHospital);

			otHumanBodyDisposal.setLasChgBy(box.getString("userName"));
			otHumanBodyDisposal.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString("changedDate")));
			otHumanBodyDisposal.setLastChgTime(box.getString("changedTime"));
			otHumanBodyDisposal.setDispatchDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString("dateOfDispatch")));

			hbt.save(otHumanBodyDisposal);
			entryNoList = session.createCriteria(TransactionSequence.class)
					.add(
							Restrictions.eq("Tablename",
									tableNameForTransactionSequence)).list();
			TransactionSequence transactionSequence = (TransactionSequence) entryNoList
					.get(0);
			int id = transactionSequence.getId();
			int entryNo = transactionSequence.getTransactionSequenceNumber();
			entryNo = entryNo + 1;
			TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
					.load(TransactionSequence.class, id);
			transactionSequenceObj.setTransactionSequenceNumber(entryNo);
			hbt.update(transactionSequenceObj);

			OtBooking otBooking = (OtBooking) hbt.load(OtBooking.class,
					otBookingId);
			otBooking.setBodyPartsDisposalStatus("y");
			hbt.update(otBooking);
			hbt.refresh(otBooking);

			succesfullyAdded = true;

			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return succesfullyAdded;
	}

	public boolean updateHumanBodyPartsDisposal(Map mapForDS) {
		Session session = (Session) getSession();
		boolean succesfullyAdded = false;

		Transaction tx = null;
		Integer disposalId = 0;

		Box box = (Box) mapForDS.get("box");
		disposalId = box.getInt("disposalId");

		List<TransactionSequence> entryNoList = new ArrayList<TransactionSequence>();
		String tableNameForTransactionSequence = "OtHumanBodyDisposal";
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			OtHumanBodyDisposal otHumanBodyDisposal = (OtHumanBodyDisposal) getHibernateTemplate()
					.get(OtHumanBodyDisposal.class, disposalId);

			otHumanBodyDisposal.setId(disposalId);

			// OtHumanBodyDisposal otHumanBodyDisposal= new
			// OtHumanBodyDisposal();
			otHumanBodyDisposal.setTissueOrgan(box.get("tissueOrgan"));
			Patient patient = new Patient();
			patient.setId(box.getInt("hinId"));
			otHumanBodyDisposal.setHin(patient);
			otHumanBodyDisposal.setEntryNo(box.getInt("entryNo"));
			otHumanBodyDisposal
					.setClinicalNotes(box.getString("clinicalNotes"));
			otHumanBodyDisposal.setTimeOfDispatch(box
					.getString("timeOfDispatch"));

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(box.getInt("deptId"));
			otHumanBodyDisposal.setSpecimenDispatchedBy(masDepartment);

			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(box.getInt("empId"));
			otHumanBodyDisposal.setSpecimenRecievedBy(masEmployee);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("hospitalId"));
			otHumanBodyDisposal.setHospital(masHospital);

			otHumanBodyDisposal.setLasChgBy(box.getString("userName"));
			otHumanBodyDisposal.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString("changedDate")));
			otHumanBodyDisposal.setLastChgTime(box.getString("changedTime"));
			otHumanBodyDisposal.setDispatchDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString("dateOfDispatch")));

			hbt.save(otHumanBodyDisposal);

			succesfullyAdded = true;

			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return succesfullyAdded;
	}

	public Map<String, Object> searchHumanBodyPartsDisposal(Map mapForDS) {
		List<OtBooking> patientDetailList = new ArrayList<OtBooking>();
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		List<OtHumanBodyDisposal> otHumanBodyPartsList = new ArrayList<OtHumanBodyDisposal>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		try {
			int hinId = (Integer) mapForDS.get("hinId");
			int entryNo = (Integer) mapForDS.get("entryNo");
			patientDetailList = session.createCriteria(OtBooking.class)
					.createAlias("Hin", "hin").add(
							Restrictions.eq("hin.Id", hinId)).list();
			empList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).list();
			deptList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
			otHumanBodyPartsList = session.createCriteria(
					OtHumanBodyDisposal.class).createAlias("Hin", "hin").add(
					Restrictions.eq("hin.Id", hinId)).add(
					Restrictions.eq("EntryNo", entryNo)).list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		map.put("empList", empList);
		map.put("deptList", deptList);
		map.put("otHumanBodyPartsList", otHumanBodyPartsList);
		return map;
	}

	public Map<String, Object> getEntryNoListForHumanBodyPartsDisposal(
			Map mapForDS) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<OtHumanBodyDisposal> otHumanBodyDisposalList = new ArrayList<OtHumanBodyDisposal>();
		int hinNo = Integer.parseInt("" + mapForDS.get("hinNo"));
		try {
			otHumanBodyDisposalList = session.createCriteria(
					OtHumanBodyDisposal.class).createAlias("Hin", "hin").add(
					Restrictions.eq("hin.id", hinNo)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("otHumanBodyDisposalList", otHumanBodyDisposalList);
		return map;
	}

	public Map<String, Object> searchPatientDetailsForEmergencyOTBooking(
			Map mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> patientList = new ArrayList<Inpatient>();

		String serviceNo = "";
		String hinNo = "";

		String patientFName = "";
		String patientMName = "";
		String patientLName = "";

		Session session = (Session) getSession();

		if (mapForDS.get("serviceNo") != null) {

			serviceNo = (String) mapForDS.get("serviceNo");
			//System.out.println("service number====" + serviceNo);
		}
		if (mapForDS.get("hinNo") != null) {

			hinNo = (String) mapForDS.get("hinNo");
			//System.out.println("HIN number====" + hinNo);
		}

		if (mapForDS.get("patientFName") != null) {
			patientFName = (String) mapForDS.get("patientFName");
		}
		if (mapForDS.get("patientMName") != null) {
			patientMName = (String) mapForDS.get("patientMName");
		}
		if (mapForDS.get("patientLName") != null) {
			patientLName = (String) mapForDS.get("patientLName");
		}

		Criteria crit = session.createCriteria(Patient.class);
		// Criteria crit =
		// session.createCriteria(Inpatient.class).add(Restrictions.eq("AdStatus",
		// patientStatus))
		// .createAlias("Hin", "p");
		if (hinNo != null && !hinNo.equals("")) {
			//System.out.println("HIN number in if block====" + hinNo);
			crit = crit.add(Restrictions.eq("HinNo", hinNo));
		} else {
			if (!serviceNo.equals("")) {
				//System.out.println("service number in else block===="	+ serviceNo);
				crit = crit.add(Restrictions.eq("ServiceNo", serviceNo));
			}

			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("PFirstName", patientFName
						+ "%"));
			}
			if (!patientMName.equals("")) {
				crit = crit.add(Restrictions.like("PMiddleName", patientMName
						+ "%"));
			}
			if (!patientLName.equals("")) {
				crit = crit.add(Restrictions.like("PLastName", patientLName
						+ "%"));
			}
		}
		patientList = crit.list();
		map.put("patientList", patientList);

		return map;
	}

	public Map<String, Object> showEmergencyOTBookingJsp(Map mapForDS) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasOt> otList = new ArrayList<MasOt>();
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		List<TransactionSequence> tranList = new ArrayList<TransactionSequence>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		int hinId = (Integer) mapForDS.get("hinId");
		int deptId = (Integer) mapForDS.get("deptId");
		String empCategory = "Doctor";
		String tableNameForOrderNo = "DgOrderhd";
		int orderNo = 0;
		String deptName = null;
		try {
			deptList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Id", deptId)).list();
			otList = session.createCriteria(MasOt.class).list();
			empList = session.createCriteria(MasEmployee.class).createAlias(
					"Department", "dept").createAlias("EmpCategory",
					"empCategory").add(Restrictions.eq("dept.Id", deptId))
					.add(
							Restrictions.eq("empCategory.EmpCategoryName",
									empCategory)).add(
							Restrictions.eq("Status", "y")).list();
			tranList = session.createCriteria(TransactionSequence.class).add(
					Restrictions.eq("Tablename", tableNameForOrderNo)).list();
			patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("Id", hinId)).list();
			TransactionSequence transactionSequence = (TransactionSequence) tranList
					.get(0);
			orderNo = transactionSequence.getTransactionSequenceNumber();
			MasDepartment masDepartment = deptList.get(0);
			deptName = masDepartment.getDepartmentName();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		// //System.out.println("u rin pac clearance list method with list size----"+opdSurgeryList.size());
		// //System.out.println("opdSurgeryDetailList=="+opdSurgeryDetailList.size());
		map.put("orderNo", orderNo);
		map.put("patientList", patientList);
		map.put("otList", otList);
		map.put("empList", empList);
		map.put("deptName", deptName);

		return map;
	}

	public boolean submitEmergencyOTBookingDetails(Map mapForDS) {
		Session session = (Session) getSession();
		boolean succesfullyAdded = false;

		Transaction tx = null;
		Box box = (Box) mapForDS.get("box");
		int deptId = (Integer) mapForDS.get("deptId");
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();

		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			int hinId = box.getInt("hinId");
			int surgeryId = box.getInt("chargeCode");
			int orderNo = box.getInt("orderNo");
			System.out
					.println("in submitEmergencyOTBookingDetails value of hinId----"
							+ hinId
							+ "--value ofsurgery--"
							+ surgeryId
							+ "  value of order no--" + orderNo);
			otBookingList = session.createCriteria(OtBooking.class)
					.createAlias("Hin", "hin").createAlias("ChargeCode",
							"chargeCode").add(Restrictions.eq("hin.Id", hinId))
					.add(Restrictions.eq("chargeCode.Id", surgeryId)).add(
							Restrictions.eq("OrderNo", orderNo)).list();
			//System.out.println("size of otBookingList above the loop--"+ otBookingList.size());
			if (otBookingList.size() == 0 || otBookingList == null) {

				OtBooking otBooking = new OtBooking();
				MasChargeCode masChargeCode = new MasChargeCode();
				masChargeCode.setId(box.getInt("chargeCode"));
				otBooking.setChargeCode(masChargeCode);
				otBooking.setSurgeryDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("surgeryDate")));
				otBooking.setSurgeryTime(box.getString("surgeryTime"));
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(box.getInt("empId"));
				otBooking.setBookedBy(masEmployee);
				MasOt masOt = new MasOt();
				masOt.setId(box.getInt("otId"));
				otBooking.setOt(masOt);
				Patient patient = new Patient();
				patient.setId(box.getInt("hinId"));
				otBooking.setHin(patient);

				MasHospital masHospital = new MasHospital();
				masHospital.setId(box.getInt("hospitalId"));
				otBooking.setHospital(masHospital);
				//otBooking.setLastChgdBy(box.getString("changedBy"));
				otBooking.setLastChgdDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("changedDate")));
				otBooking.setLastChgdTime(box.getString("changedTime"));
				otBooking.setOrderNo(box.getInt("orderNo"));
				otBooking.setOtBookingStatus("y");
				otBooking.setBookingType("E");
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				otBooking.setDepartment(masDepartment);
				hbt.save(otBooking);

				if (mapForDS.get("empIdList") != null) {
					List empIdList = (List) mapForDS.get("empIdList");
					Iterator itr = empIdList.iterator();
					while (itr.hasNext()) {
						int empId = (Integer) itr.next();
						OtBookSurgeon otBookSurgeon = new OtBookSurgeon();
						otBookSurgeon.setBooking(otBooking);
						MasEmployee masEmployee2 = new MasEmployee();
						masEmployee2.setId(empId);
						otBookSurgeon.setEmployee(masEmployee2);
						otBookSurgeon.setOrderNo(box.getInt("orderNo"));
						hbt.save(otBookSurgeon);
					}
				}
			}
			succesfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//System.out.println("Error ocurred!! please try again");
			e.printStackTrace();
		} finally {
			// --------Session Closing----------
			session.close();
		}

		return succesfullyAdded;
	}

	public Map<String, Object> searchOTPreAnesthesiaDetails(Map mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> patientList = new ArrayList<Inpatient>();

		String serviceNo = "";
		String hinNo = "";

		String patientFName = "";
		String patientMName = "";
		String patientLName = "";

		Session session = (Session) getSession();

		if (mapForDS.get("serviceNo") != null) {

			serviceNo = (String) mapForDS.get("serviceNo");
			//System.out.println("service number====" + serviceNo);
		}
		if (mapForDS.get("hinNo") != null) {

			hinNo = (String) mapForDS.get("hinNo");
			//System.out.println("HIN number====" + hinNo);
		}

		if (mapForDS.get("patientFName") != null) {
			patientFName = (String) mapForDS.get("patientFName");
		}
		if (mapForDS.get("patientMName") != null) {
			patientMName = (String) mapForDS.get("patientMName");
		}
		if (mapForDS.get("patientLName") != null) {
			patientLName = (String) mapForDS.get("patientLName");
		}

		String patientStatus = "A";
		// Criteria crit =
		// session.createCriteria(Patient.class).add(Restrictions.not(Expression.eq("PatientStatus",
		// patientStatus)));
		Criteria crit = session.createCriteria(OtPreAnesthesiaHd .class)
				.createAlias("Hin", "p");
		if (hinNo != null && !hinNo.equals("")) {
			//System.out.println("HIN number in if block====" + hinNo);
			crit = crit.add(Restrictions.eq("p.HinNo", hinNo));
		} else {
			if (!serviceNo.equals("")) {
				//System.out.println("service number in else block===="+ serviceNo);
				crit = crit.add(Restrictions.eq("p.ServiceNo", serviceNo));
			}

			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("p.PFirstName", patientFName
						+ "%"));
			}
			if (!patientMName.equals("")) {
				crit = crit.add(Restrictions.like("p.PMiddleName", patientMName
						+ "%"));
			}
			if (!patientLName.equals("")) {
				crit = crit.add(Restrictions.like("p.PLastName", patientLName
						+ "%"));
			}
		}
		patientList = crit.list();
		map.put("patientList", patientList);
		return map;
	}

	public Map<String, Object> viewPreAnesthesiaDetails(Map mapForDS) {
		Session session = (Session) getSession();
		List<OtPreAnesthesiaHd> otPreAnesthesiaDetailsList = new ArrayList<OtPreAnesthesiaHd>();
		List<OtPreAnesthesiaDetail > otPreAnesthesiaSurgeryList = new ArrayList<OtPreAnesthesiaDetail>();
		List<OtPreOpDrugsEntry> otPreOPDrugsList = new ArrayList<OtPreOpDrugsEntry>();
		List<OpdPatientHistory> opdPatientHistoryList = new ArrayList<OpdPatientHistory>();
		List<OtPreAnesthesiaHd>OtPreAnesthesiaDetailsList=new ArrayList<OtPreAnesthesiaHd>();

	    List<PatientFamilyHistory>  medicalHistoryTemplate = new ArrayList<PatientFamilyHistory>();
	    List<PatientMedicalHistory>  PatientMedicalHistory = new ArrayList<PatientMedicalHistory>();
		Map<String, Object> map = new HashMap<String, Object>();
		  int hospitalId = (Integer)mapForDS.get(HOSPITAL_ID);
		  int deptId = (Integer)mapForDS.get("deptId");
		  int surgeryId = (Integer)mapForDS.get("surgeryId");
          int count =1;
   	      //int docId = (Integer)mapForDS.get("docId");
	//	int preAnesthesiaDetailId = 0;
		 List<PreAnesthesiaConsultDoctorDt> requestList = new ArrayList<PreAnesthesiaConsultDoctorDt>();
		String icd="";
		String anesthesia =null;
		try {
			
		/*	
			otPreAnesthesiaDetailsList = session.createCriteria(
					OtPreAnesthesiaDetails.class).add(
					Restrictions.eq("Id", preAnesthesiaDetailId)).list();*/
			
			otPreAnesthesiaDetailsList = session.createCriteria(
					OtPreAnesthesiaHd.class)
					//.createAlias("OpdSurgeryHeader", "OpdSurgeryHeader")
					.add(Restrictions.eq("Id", surgeryId))
					.list();
			
			if(otPreAnesthesiaDetailsList.size() > 0)
			{
				
				otPreAnesthesiaSurgeryList = session.createCriteria(
						OtPreAnesthesiaDetail.class)
						//.createAlias("OpdSurgeryHeader", "OpdSurgeryHeader")
						.add(Restrictions.eq("AnesthesiaHd.Id", surgeryId))
						.list();
						
				OtPreAnesthesiaHd otPreAnesthesiaDetails = (OtPreAnesthesiaHd) otPreAnesthesiaDetailsList
								.get(0);
			//int otPreAnesthesiaDetailId = otPreAnesthesiaDetails.getId();
			/*otPreOPDrugsList = session.createCriteria(OtPreOpDrugsEntry.class)
					.createAlias("PreAnesthsiaDetails", "preAnesthsiaDetails")
					.add(
							Restrictions.eq("preAnesthsiaDetails.Id",
									otPreAnesthesiaDetailId)).list();*/

			int hinId = otPreAnesthesiaDetails.getHin().getId();
			int visitId  =0;
			if( otPreAnesthesiaDetails.getVisit()!=null)
			{
				visitId = otPreAnesthesiaDetails.getVisit().getId();
			}
			String patientStatus = otPreAnesthesiaDetails.getPatientStatus();
	/*		if (patientStatus!=null &&  patientStatus.equals("Out Patient")) {
				int visitId = otPreAnesthesiaDetails.getVisit().getId();
				opdPatientHistoryList = session.createCriteria(
						OpdPatientHistory.class).createAlias("Hin", "hin").add(
						Restrictions.eq("hin.Id", hinId)).add(
						Restrictions.eq("VisitInpatientId", visitId)).list();
			} else {*/
				/*int inpatientId = otPreAnesthesiaDetails.getInpatient().getId();*/
				opdPatientHistoryList = session.createCriteria(
						OpdPatientHistory.class).createAlias("Hin", "hin").add(
						Restrictions.eq("hin.Id", hinId))
					/*	.add(Restrictions.eq("VisitInpatientId", inpatientId))*/
						.list();
			//}
		
				List<DischargeIcdCode>icdList=new ArrayList<DischargeIcdCode>();
				icdList=session.createCriteria(DischargeIcdCode.class).add(Restrictions.eq("Hin.Id", hinId)).list();
				
				Set<MasIcd> uniqueIcdList=new HashSet <MasIcd>();
				for(DischargeIcdCode icd2:icdList){
					MasIcd masIcd = icd2.getIcd();
					if(icd2.getIcd()!=null){
						uniqueIcdList.add(masIcd);
					}
				}
				for(MasIcd icd2:uniqueIcdList){
					icd=icd+"\n"+icd2.getIcdName();
				}
			

			OtPreAnesthesiaDetailsList=session.createCriteria(OtPreAnesthesiaHd .class).add(Restrictions.eq("Hin.Id", otPreAnesthesiaDetails.getHin().getId())).list();
			for(OtPreAnesthesiaHd OtPreAnesthesiaDetails:OtPreAnesthesiaDetailsList){
				if(OtPreAnesthesiaDetails.getAnashteicDetails()!=null){
				  if(count==1){
					  anesthesia=OtPreAnesthesiaDetails.getAnashteicDetails();
				  }
				  else
				anesthesia=anesthesia+","+OtPreAnesthesiaDetails.getAnashteicDetails();
				}
			}
			
			   
		    if(otPreAnesthesiaSurgeryList.size()>0){
		    	List<OtPreAnesthesiaDetail> pacDt = session.createCriteria(OtPreAnesthesiaDetail.class).add(Restrictions.eq("Id", otPreAnesthesiaSurgeryList.get(0).getId())).list();
			    map.put("pacDt", pacDt);
				//procedureDetails.clear();
			}
		    
		    requestList = session.createCriteria(PreAnesthesiaConsultDoctorDt.class)
					   .createAlias("ConsultDoctorIdHd", "hd")
					   	   .createAlias("hd.OtPreAnesthesiaHd", "pacHd")
					    .createAlias("hd.Hospital", "hospital")
					     .createAlias("ConsultedDepartment", "dept")
					   .add(Restrictions.eq("hospital.Id",hospitalId))
					   .add(Restrictions.eq("pacHd.Id",surgeryId))
					     .add(Restrictions.eq("dept.Id",deptId))
					 /*  .createAlias("ConsultedDoctor", "emp")
					   .add(Restrictions.eq("emp.Id",docId))*/
					   .add(Restrictions.or(Restrictions.isNull("DoctorAdvice"), Restrictions.eq("DoctorAdvice","")))
					   .addOrder(Order.desc("ConsultDate"))
					   //.addOrder(Order.desc("ConsultTime"))
					   //.setMaxResults(1)
					.list();


		    	/*	PreAnesthesiaConsultDoctorDt consultDt = new PreAnesthesiaConsultDoctorDt();
					 consultDt = (PreAnesthesiaConsultDoctorDt) hbt.load(
							   PreAnesthesiaConsultDoctorDt.class, consultDtId);*/
		   
		        String tempCode = HMSUtil.getValuesFromPropertiesFile("adt.properties", "templateCodeForComplaintHistory");
				medicalHistoryTemplate =  session.createCriteria(PatientFamilyHistory.class).add(
						Restrictions.eq("Status", "y")).add(
								Restrictions.eq("TemplateCode", tempCode)).list();
				PatientMedicalHistory =  session.createCriteria(PatientMedicalHistory.class)
						  .add(Restrictions.eq("Hin.Id", hinId)) 
						.list();
				
   }	
			// //System.out.println("size of opdPatientHistoryList=============="+opdPatientHistoryList.size());
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		// //System.out.println("t opdPatientHistoryList asize----"+opdPatientHistoryList.size());
		map.put("otPreAnesthesiaDetailsList", otPreAnesthesiaDetailsList);
	//	map.put("otPreOPDrugsList", otPreOPDrugsList);
		map.put("opdPatientHistoryList", opdPatientHistoryList);
		map.put("anesthesia",anesthesia);
		map.put("icd", icd);
		map.put("otPreAnesthesiaSurgeryList", otPreAnesthesiaSurgeryList);
		map.put("otPreAnesthesiaSurgeryList", otPreAnesthesiaSurgeryList);
		map.put("requestList", requestList);
		map.put("medicalHistoryTemplate", medicalHistoryTemplate);
		map.put("PatientMedicalHistory", PatientMedicalHistory);
		
		
		
//System.out.println("ddd"+otPreAnesthesiaSurgeryList.size());		

		return map;
	}

	// -----------------------methods changed by vikas----------------------

	/**
	 * ------------------------------ Priyanka Garg
	 * --------------------------------
	 */
	public Map<String, Object> showOTListChangeJsp(Map mapForDS) {
		Session session = (Session) getSession();
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = (Integer) mapForDS.get("deptId");
		String empCategory = "Doctor";
		try {
			otBookingList = session.createCriteria(OtBooking.class).add(
					Restrictions.eq("OtBookingStatus", "y")).createAlias(
					"Department", "md").add(Restrictions.eq("md.Id", deptId))
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		//System.out.println("otBookingList----" + otBookingList.size());
		map.put("otBookingList", otBookingList);
		return map;
	}

	public Map<String, Object> getOTSchedule(Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		List<OtBooking> otList = new ArrayList<OtBooking>();
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();
		List<MasOt> masOtList = new ArrayList<MasOt>();
		List<OtAnesthesiologist> masAnesList = new ArrayList<OtAnesthesiologist>();
		List<MasEmployee> masEmpList = new ArrayList<MasEmployee>();
		Date otBookingDate = HMSUtil
				.convertStringTypeDateToDateType((String) mapForDS
						.get("bookingDate"));
		int otId = (Integer) mapForDS.get("otId");
		//System.out.println("otBookingDate-->" + otBookingDate);
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = (Integer) mapForDS.get("deptId");
		try {

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			otList = session.createCriteria(OtBooking.class).createAlias(
					"Department", "md").add(Restrictions.eq("md.Id", deptId))
					.createAlias("Ot", "mot").setProjection(
							Projections.distinct(Projections.projectionList()
									.add(Projections.property("mot.Id")))).add(
							Restrictions.eq("OtBookingStatus", "y")).list();

			/*
			 * otBookingList=session.createCriteria(OtBooking.class).add(Restrictions
			 * .eq("OtBookingStatus", "y")).createAlias("Department", "md")
			 * .add(
			 * Restrictions.eq("md.Id",deptId)).add(Restrictions.eq("SurgeryDate"
			 * ,otBookingDate )).list();
			 */
			otBookingList = session.createCriteria(OtBooking.class).add(
					Restrictions.eq("OtBookingStatus", "y")).add(
					Restrictions.eq("Ot.Id", otId)).add(
					Restrictions.eq("SurgeryDate", otBookingDate)).addOrder(
					Order.asc("SlNo")).list();
			masOtList = session.createCriteria(MasOt.class).add(
					Restrictions.eq("Status", "y")).list();
			masEmpList = session.createCriteria(MasEmployee.class).createAlias(
					"EmpCategory", "Cat").createAlias("Department", "Dept")
					.add(Restrictions.eq("Cat.EmpCategoryCode", "01")).add(
							Restrictions.eq("Dept.DepartmentCode", "Anaes1"))
					.add(Restrictions.eq("Status", "y")).list();

			masAnesList = session.createCriteria(OtAnesthesiologist.class).add(
					Restrictions.eq("SurgeryDate", otBookingDate)).list();
			/**
			 * ---- Assigning SlNo to each OT ------
			 */
			Iterator iteOtList = otList.iterator();
			while (iteOtList.hasNext()) {
				int ot = (Integer) iteOtList.next();
				int srNo = getMaxSlNo(otBookingList, ot);
				Iterator iteOtBookingList = otBookingList.iterator();
				while (iteOtBookingList.hasNext()) {
					OtBooking otBookingObj2 = (OtBooking) iteOtBookingList
							.next();
					if (otBookingObj2.getOt().getId() == ot) {
						if (otBookingObj2.getSlNo() == null) {
							srNo++;
							OtBooking otBookingObj3 = (OtBooking) hbt.load(
									OtBooking.class, otBookingObj2.getId());
							otBookingObj3.setSlNo(srNo);
							// hbt.saveOrUpdate(otBookingObj3);
						}
					}

				}

			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		//System.out.println("otBookingList-->" + otBookingList.size());
		map.put("otBookingList", otBookingList);
		map.put("masOtList", masOtList);
		map.put("masEmpList", masEmpList);
		map.put("masAnesList", masAnesList);
		return map;
	}

	public Map<String, Object> getActualOTPerformedSchedule(
			Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		List<OtBooking> otList = new ArrayList<OtBooking>();
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();
		List<MasOt> masOtList = new ArrayList<MasOt>();
		Date otBookingDate = HMSUtil
				.convertStringTypeDateToDateType((String) mapForDS
						.get("bookingDate"));

		// //System.out.println("otBookingDate-->"+otBookingDate);
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = (Integer) mapForDS.get("deptId");
		try {

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			otList = session.createCriteria(OtBooking.class).createAlias(
					"Department", "md").add(Restrictions.eq("md.Id", deptId))
					.createAlias("Ot", "mot").setProjection(
							Projections.distinct(Projections.projectionList()
									.add(Projections.property("mot.Id")))).add(
							Restrictions.eq("OtBookingStatus", "y")).list();

			otBookingList = session.createCriteria(OtBooking.class)
					.add(Restrictions.eq("OtBookingStatus", "y"))
					// .add(Restrictions.eq("Ot.Id", otId))
					.add(Restrictions.eq("SurgeryDate", otBookingDate))
					.addOrder(Order.asc("Ot.Id")).addOrder(Order.asc("SlNo"))
					.list();
			masOtList = session.createCriteria(MasOt.class).add(
					Restrictions.eq("Status", "y")).list();

			/**
			 * ---- Assigning SlNo to each OT ------
			 */
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		// //System.out.println("otBookingList-->"+otBookingList.size());
		map.put("otBookingList", otBookingList);
		map.put("masOtList", masOtList);
		return map;
	}

	public int getMaxSlNo(List<OtBooking> otBookingList, int ot) {
		int maxSlNo = 0;
		int temp = 0;
		Iterator iteOtBookingList = otBookingList.iterator();
		while (iteOtBookingList.hasNext()) {
			OtBooking otBookingObj = (OtBooking) iteOtBookingList.next();
			if (otBookingObj.getOt().getId() == ot
					&& otBookingObj.getSlNo() != null
					&& otBookingObj.getSlNo() != 0) {

				temp = otBookingObj.getSlNo();

			}
			if (temp > maxSlNo) {
				maxSlNo = temp;
			}
		}
		return maxSlNo;

	}

	public Map<String, Object> changeOTSchedule(Map<String, Object> map) {
		Session session = (Session) getSession();
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();
		List<OtBooking> otBookingList2 = new ArrayList<OtBooking>();
		List<MasOt> masOtList = new ArrayList<MasOt>();
		int bookingId = (Integer) map.get("bookingId");
		int deptId = (Integer) map.get("deptId");
	/*	Date otBookingDate = HMSUtil
				.convertStringTypeDateToDateType((String) map
						.get("bookingDate"));*/

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			otBookingList = session.createCriteria(OtBooking.class).add(
					Restrictions.eq("Id", bookingId)).list();
					otBookingList2 = session.createCriteria(OtBooking.class)
					//.add(Restrictions.eq("SurgeryDate", otBookingDate))
					.add(Restrictions.eq("OtBookingStatus", "y")).list();
			masOtList = session.createCriteria(MasOtDistribution.class).add(
					Restrictions.eq("Status", "y")).createAlias("Department",
					"md").add(Restrictions.eq("md.Id", deptId)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("otBookingList", otBookingList);
		map.put("otBookingList2", otBookingList2);
		
		map.put("masOtList", masOtList);
		return map;
	}

	
	@Override
	public Map<String, Object> getOTScheduleForUpdation(Map dataMap) {
		Session session = (Session) getSession();
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();
		List<OtBookSurgeon> surgeonList = new ArrayList<OtBookSurgeon>();
		List<OpdSurgeryHeader> opdSurgeryList = new ArrayList<OpdSurgeryHeader>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasOt> masOtList = new ArrayList<MasOt>();
		
		int hospitalId = (Integer) dataMap.get(HOSPITAL_ID);
		
		int bookingId = (Integer) dataMap.get("bookingId");


		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			String departmentTypeCode = null;
			String departmentTypeCodeForOT = null;
			List<String > DeptCodeList =new ArrayList<String>();
			try
			{
				
				 departmentTypeCode = HMSUtil.getValuesFromPropertiesFile("adt.properties", "departmentTypeCodeForOpd");
				 departmentTypeCodeForOT = HMSUtil.getValuesFromPropertiesFile("adt.properties", "departmentTypeCodeForOT");
				 
				 DeptCodeList.add(departmentTypeCode);
				 DeptCodeList.add(departmentTypeCodeForOT);

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y"))
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.in("dt.DepartmentTypeCode",DeptCodeList))
				.addOrder(Order.asc("DepartmentName")).list();
			
			otBookingList = session.createCriteria(OtBooking.class).add(
					Restrictions.eq("Id", bookingId))
					.add(Restrictions.eq("SurgeryStatus", "n")).list();
					//.add(Restrictions.eq("OtBookingStatus", "y")).list();
			
			if(otBookingList!=null && otBookingList.size() >0 && otBookingList.get(0).getOpdSurseryHeader() !=null)
			{
			opdSurgeryList = session.createCriteria(OpdSurgeryHeader.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Id", otBookingList.get(0).getOpdSurseryHeader().getId())).list();
			}
			
			surgeonList = session.createCriteria(OtBookSurgeon.class)
					.createAlias("Booking", "Booking")
					.add(Restrictions.eq("Booking.Id", bookingId))
					.list();
				/*	otBookingList2 = session.createCriteria(OtBooking.class)
					//.add(Restrictions.eq("SurgeryDate", otBookingDate))
					.add(Restrictions.eq("OtBookingStatus", "y")).list();*/
		

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		dataMap.put("opdSurgeryList", opdSurgeryList);
		dataMap.put("otBookingList", otBookingList);
		dataMap.put("surgeonList", surgeonList);
		
	     dataMap.put("departmentList", departmentList);
		
		dataMap.put("masOtList", masOtList);
		return dataMap;
	}
	
	public Map<String, Object> updateSurgeryDoneStatus(Box box) {
		Session session = (Session) getSession();
		boolean dataSaved = true;
		Map<String, Object> map = new HashMap<String, Object>();

		java.util.Vector<String> otBookingIds = box.getVector("bookingId");
		java.util.Vector<String> surgeryDoneStatusList = box
				.getVector("surgeryDoneStatus");
		java.util.Vector<String> surgeryStatusList = box
				.getVector("surgeryStatus");

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			for (int i = 0; i < otBookingIds.size(); i++) {
				int otBookingId = Integer
						.parseInt((String) otBookingIds.get(i));
				String surgeryDoneStatus = surgeryDoneStatusList.get(i);
				String surgeryStatus = surgeryStatusList.get(i);

				OtBooking otBooking = (OtBooking) hbt.load(OtBooking.class,
						otBookingId);
				otBooking.setSurgeryDoneStatus(surgeryDoneStatus);
				otBooking.setSurgeryStatus(surgeryStatus);

				hbt.update(otBooking);
				hbt.refresh(otBooking);
			}
		} catch (HibernateException e) {
			dataSaved = false;
			e.printStackTrace();
		}
		map.put("dataSaved", dataSaved);
		return map;
	}

	public Map<String, Object> updateOTSchedule(Map<String, Object> mapForDS) {
		Session session = (Session) getSession();

		boolean succesfullyAdded = false;
		String value = "";
		//String patientStatus = "";
		String chargeName = "";
		String startTime = null;
		String endTime = null;
		String surgeryDate = "";
		//String toTimeStr = "0";
		//int loopCount = 1;
		//int prevBedId =0;
	//	OtMasChargeDetails otMasChargeDetails = new OtMasChargeDetails();
		int surgeryId = 0;
		Transaction tx = null;
		Box box = (Box) mapForDS.get("box");
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		int userId = (Integer) mapForDS.get(USER_ID);
		int deptId = (Integer) mapForDS.get("departmentId");
		int opdSurgeryHeaderId = box.getInt("opdSurgeryHeaderId");
		
		/*if( box.get("prevBedId")!=null){
			prevBedId =  box.getInt("prevBedId");
		}*/
		
		 /*startTime = HMSUtil.convertStringToTime(box.getString("startTime"));
		 endTime = HMSUtil.convertStringToTime(box.getString("endTime"));*/
		
		//int ChargeDetailSurgeryId = 0;
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();
/*		List<OtMasChargeDetails> otMasChargeDetailsList = new ArrayList<OtMasChargeDetails>();*/
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
			 startTime = box.getString("startTime");
			 endTime = box.getString("endTime");
			
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			//int date = 0;
			//int month = 0;


			surgeryDate = box.getString("tentativeDate");

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(surgeryDate));
			c.add(Calendar.DATE, 1); // number of days to add
			surgeryDate = sdf.format(c.getTime());
			int hinId = box.getInt(HIN_ID);
					
			
			surgeryId = box.getInt(OT_BOOKING_ID);
			//System.out.println("surgeryId==in ds==="+surgeryId);
			int orderNo = box.getInt("orderNo");
			// hinId----"+hinId+"--value ofsurgery--"+surgeryId+" value of order
			// no--"+orderNo);
			otBookingList = session
					.createCriteria(OtBooking.class)
					.createAlias("Hin", "hinId")
				//	.createAlias("ChargeCode", "chargeCode")
					.add(Restrictions.eq("hinId.Id", hinId))
					//.add(Restrictions.eq("chargeCode.Id", surgeryId))
				//	.add(Restrictions.eq("OrderNo", orderNo))
					.add(Restrictions.eq("Id", surgeryId))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					/*.add(Restrictions.eq("OpdSurseryHeader.Id",
							opdSurgeryHeaderId))*/.list();

			/*otMasChargeDetailsList = session
					.createCriteria(OtMasChargeDetails.class)
					.createAlias("ChargeCode", "chargeCode")
					.add(Restrictions.eq("chargeCode.Id", surgeryId))
					//.add(Restrictions.eq("Hospital.Id", hospitalId))
					.list();*/

		/*	if (otMasChargeDetailsList.size() > 0) {
				ChargeDetailSurgeryId = otMasChargeDetailsList.get(0).getId();
			}*/
		//	System.out.println("ChargeDetailSurgeryId===44=="+ChargeDetailSurgeryId);
			/*for (int i = 1; i <= loopCount; i++) {*/
	
				if (otBookingList.size() >0) {
					OtBooking otBooking =(OtBooking) hbt.load(OtBooking.class, surgeryId);
					otBooking.setSurgeryDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.getString("tentativeDate")));
					/*otBooking.setSurgeryStartTime(startTime);
					otBooking.setSurgeryEndTime(endTime);*/
				/*	MasChargeCode masChargeCode = new MasChargeCode();
					masChargeCode.setId(surgeryId);
					otBooking.setChargeCode(masChargeCode);*/

					chargeName = box.getString("chargeName");
	
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(box.getInt("bookedById"));
					otBooking.setBookedBy(masEmployee);
					
				
					
					MasDepartment department=new MasDepartment();
					department.setId(deptId);
					otBooking.setDepartment(department);

					MasOt masot=new MasOt();
					masot.setId(box.getInt("otId"));
					otBooking.setOt(masot);
					
					MasBed masbed=new MasBed(); 
					masbed.setId(box.getInt("tableId"));
					otBooking.setBed(masbed);
		
					
					Patient patient = new Patient();
					patient.setId(box.getInt(HIN_ID));
					otBooking.setHin(patient);
					
					//patientStatus = box.getString("patientStatus");
				/*	if (box.getInt(VISIT_ID)!=0) {
						Visit visit = new Visit();
						visit.setId(box.getInt(VISIT_ID));
						otBooking.setVisit(visit);
					} else {
						Inpatient inpatient = new Inpatient();
						inpatient.setId(box.getInt(INPATIENT_ID));
						otBooking.setInpatient(inpatient);
					}*/
					if (box.getInt(INPATIENT_ID)!=0) {
						Inpatient inpatient = new Inpatient();
						inpatient.setId(box.getInt(INPATIENT_ID));
						otBooking.setInpatient(inpatient);
					}
					
					
					
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					otBooking.setHospital(masHospital);
					Users users = new Users();
					users.setId(userId);
					otBooking.setLastChgdBy(users);

					if (box.getString("changedDate") != null
							&& !box.getString("changedDate").equals("")) {
						otBooking.setLastChgdDate(HMSUtil
								.convertStringTypeDateToDateType(box
										.getString("changedDate")));
					}
					
					
					otBooking.setLastChgdTime(box.getString("changedTime"));
					otBooking.setOrderNo(box.getInt("orderNo"));
					otBooking.setOtBookingStatus("y");
					otBooking.setOtPostAnethesiaStatus("n");
					otBooking.setSurgeryStatus("n");
					otBooking.setBookingType(box.getString("bookingType"));
					OpdSurgeryHeader opdSurgeryHeader1 = new OpdSurgeryHeader();
					
					opdSurgeryHeader1.setId(opdSurgeryHeaderId);
					otBooking.setOpdSurseryHeader(opdSurgeryHeader1);
					otBooking.setOrderNo(orderNo);
					otBooking.setOtRemarks(box.getString("ot_remarks"));
					otBooking.setSurgeryStartTime(startTime);
					otBooking.setSurgeryEndTime(endTime);
					hbt.update(otBooking);

					if (mapForDS.get("empIdList") != null) {
						List empIdList = (List) mapForDS.get("empIdList");
						List<String> roleList = (List) mapForDS.get("roleList");
						//Iterator itr = empIdList.iterator();
						//while (itr.hasNext()) {
						
						for(int i=0;i<empIdList.size();i++){
						if(roleList.get(i).equalsIgnoreCase("surgeon")){
							int empId = Integer.parseInt(empIdList.get(i).toString());
							OtBookSurgeon otBookSurgeon = new OtBookSurgeon();
							otBookSurgeon.setBooking(otBooking);
							MasEmployee masEmployee2 = new MasEmployee();
							masEmployee2.setId(empId);
							otBookSurgeon.setEmployee(masEmployee2);
							otBookSurgeon.setOrderNo(box.getInt("orderNo"));
							
							String role=roleList.get(i).toString();
							otBookSurgeon.setRole(role);
							
							hbt.save(otBookSurgeon);
						}
						}
					}

					
					/* MasBed masbed1 =  (MasBed)hbt.load(MasBed.class, box.getInt("tableId"));
					 int bedstaus =Integer.parseInt(HMSUtil.getValuesFromPropertiesFile("adt.properties", "bedStatusOccupiedId".trim()));
					 MasBedStatus bedstatus =  (MasBedStatus)hbt.load(MasBedStatus.class, bedstaus);
					 masbed1.setBedStatus(bedstatus);
					 hbt.update(masbed1);*/
					 
					 
				/*	 if(prevBedId != box.getInt("tableId"))
					 {
						 masbed1 =  (MasBed)hbt.load(MasBed.class, prevBedId);
						  bedstaus =Integer.parseInt(HMSUtil.getValuesFromPropertiesFile("adt.properties", "bedStatusUnOccupiedId".trim()));
						  bedstatus =  (MasBedStatus)hbt.load(MasBedStatus.class, bedstaus);
						 masbed1.setBedStatus(bedstatus);
						 hbt.update(masbed1);
					 }*/
					
				
					succesfullyAdded = true;
					
				} 

			/*}*/
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			// --------Session Closing----------
			session.close();
		}
		map.put("succesfullyAdded", succesfullyAdded);
		return map;
		
		
		
		
		/*Map<String, Object> map = new HashMap<String, Object>();
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();
		List<OtBooking> otBookingList2 = new ArrayList<OtBooking>();
		List<OtBooking> otBookingList3 = new ArrayList<OtBooking>();
		List<MasOt> masOtList = new ArrayList<MasOt>();
		String changeCriteria = box.getString("changeCriteria");
		int bookingId = box.getInt("selectedId");
		int otId = box.getInt("selectedOtId");
		Date bookingDate = new Date();
		int slNo = 0;

		int swapSlno = 0;
		int currentSlno = box.getInt("selectedSlNo");
		int currentOt;
		Date currentBookingDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString("SelectedBookingDate"));
		int swapBookingId = 0;

		boolean dataSaved = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {

			if (changeCriteria.equals("bookingDate")) {
				bookingDate = HMSUtil.convertStringTypeDateToDateType(box
						.getString("newBookingDate"));
				if (bookingDate != null || !bookingDate.equals("")) {
					otBookingList3 = session.createCriteria(OtBooking.class)
							.add(Restrictions.eq("OtBookingStatus", "y"))
							.createAlias("Ot", "masOt").add(
									Restrictions.eq("masOt.Id", otId)).add(
									Restrictions.eq("SurgeryDate",
											currentBookingDate)).list();

					currentBookingDate = otBookingList3.get(0).getSurgeryDate();
					for (OtBooking otBooking : otBookingList3) {
						if (otBooking.getSlNo() > currentSlno) {
							OtBooking otBookingObj = (OtBooking) hbt.load(
									OtBooking.class, otBooking.getId());
							otBookingObj.setSlNo(otBooking.getSlNo() - 1);
							hbt.saveOrUpdate(otBookingObj);
						}
					}

					otBookingList2 = session.createCriteria(OtBooking.class)
							.add(Restrictions.eq("OtBookingStatus", "y"))
							.createAlias("Ot", "masOt").add(
									Restrictions.eq("masOt.Id", otId))
							.add(Restrictions.eq("SurgeryDate", bookingDate))
							.list();
					int maxSlno = getMaxSlNo(otBookingList2, otId);
					OtBooking otBooking = (OtBooking) hbt.load(OtBooking.class,
							bookingId);
					otBooking.setSlNo(maxSlno + 1);
					otBooking.setSurgeryDate(bookingDate);
					hbt.saveOrUpdate(otBooking);
				}

			} else if (changeCriteria.equals("otName")) {
				otBookingList3 = session
						.createCriteria(OtBooking.class)
						.add(Restrictions.eq("OtBookingStatus", "y"))
						.createAlias("Ot", "masOt")
						.add(Restrictions.eq("masOt.Id", otId))
						.add(Restrictions.eq("SurgeryDate", currentBookingDate))
						.list();
				currentBookingDate = otBookingList3.get(0).getSurgeryDate();
				for (OtBooking otBooking : otBookingList3) {
					if (otBooking.getSlNo() > currentSlno) {
						OtBooking otBookingObj = (OtBooking) hbt.load(
								OtBooking.class, otBooking.getId());
						otBookingObj.setSlNo(otBooking.getSlNo() - 1);
						hbt.saveOrUpdate(otBookingObj);
					}
				}
				otId = box.getInt("newOt");

				otBookingList2 = session
						.createCriteria(OtBooking.class)
						.add(Restrictions.eq("OtBookingStatus", "y"))
						.createAlias("Ot", "masOt")
						.add(Restrictions.eq("masOt.Id", otId))
						.add(Restrictions.eq("SurgeryDate", currentBookingDate))
						.list();
				int maxSlno = getMaxSlNo(otBookingList2, otId);
				OtBooking otBooking = (OtBooking) hbt.load(OtBooking.class,
						bookingId);
				otBooking.setSlNo(maxSlno + 1);
				MasOt masOt = new MasOt();
				masOt.setId(otId);
				otBooking.setOt(masOt);
				hbt.saveOrUpdate(otBooking);

			} else if (changeCriteria.equals("slNo")) {
				otBookingList = session.createCriteria(OtBooking.class).add(
						Restrictions.eq("Id", bookingId)).add(
						Restrictions.eq("OtBookingStatus", "y")).list();
				// //System.out.println("otlist===="+otBookingList.size());
				currentSlno = otBookingList.get(0).getSlNo();
				currentOt = otBookingList.get(0).getOt().getId();
				currentBookingDate = otBookingList.get(0).getSurgeryDate();
				slNo = box.getInt("newSlNo");
				OtBooking otBooking = new OtBooking();
				if (slNo != 0) {
					otBookingList2 = session.createCriteria(OtBooking.class)
							.add(Restrictions.eq("OtBookingStatus", "y")).add(
									Restrictions.eq("SlNo", slNo)).createAlias(
									"Ot", "masOt").add(
									Restrictions.eq("masOt.Id", otId)).list();
					swapBookingId = otBookingList2.get(0).getId();
					otBooking = (OtBooking) hbt.load(OtBooking.class,
							swapBookingId);
					otBooking.setSlNo(currentSlno);
					hbt.saveOrUpdate(otBooking);
					otBooking = (OtBooking) hbt
							.load(OtBooking.class, bookingId);
					otBooking.setSlNo(slNo);
					hbt.saveOrUpdate(otBooking);
				} else if (slNo == 0) {
					otBooking = (OtBooking) hbt
							.load(OtBooking.class, bookingId);
					otBooking.setSlNo(slNo);
					hbt.saveOrUpdate(otBooking);
				}

			}

			dataSaved = true;

		} catch (HibernateException e) {
			dataSaved = false;
			e.printStackTrace();
		}
		map.put("dataSaved", dataSaved);
		map.put("otBookingList", otBookingList);
		map.put("otBookingList2", otBookingList2);
		map.put("masOtList", masOtList);
		return map;*/
	}
	

	public Map<String, Object> cancelOTSchedule(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
	/*	List<OtBooking> otBookingList = new ArrayList<OtBooking>();
		List<OtBooking> otBookingList2 = new ArrayList<OtBooking>();*/
		List<OtBooking> otBookingList3 = new ArrayList<OtBooking>();
	//	List<MasOt> masOtList = new ArrayList<MasOt>();
		int bookingId = box.getInt("bookingId");
		int bed_id = 0;
		String cancelRemarks = box.getString("cancelOtRemarks");
		//int slNo = 0;

	/*	int currentSlno = 0;
		int currentOt;
		Date currentBookingDate = new Date();
		int swapBookingId = 0;*/

		boolean dataSaved = false;

		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			//System.out.println("bookingId---"+bookingId);
			
			OtBooking otBookingObj1 = (OtBooking) hbt.load(OtBooking.class,
					bookingId);
			//otBookingObj1.setOtBookingStatus("c");
			otBookingObj1.setSurgeryStatus("c");
			otBookingObj1.setCancelRemarks(cancelRemarks); 
			hbt.saveOrUpdate(otBookingObj1);
		
			//OtBookingDt
/*			String query = "update OtBookingDt set Status=? where OtBookingHd=?";
					Query q = session.createQuery(query);
					q.setString(1,"c");
					q.setInteger(2, bookingId);
					q.executeUpdate();
			hbt.update(q);*/
			
			List<OtBookingDt> otDTList = session.createCriteria(OtBookingDt.class).add(
					Restrictions.eq("OtBookingHd.Id", bookingId)).add(
					Restrictions.eq("Status", "n")).list();
			
			for( OtBookingDt otDt:otDTList)
			{
				OtBookingDt otBookingDt = (OtBookingDt) hbt.load(OtBookingDt.class,
						otDt.getId());
				otBookingDt.setStatus("c");
				hbt.update(otBookingDt);
				
				OpdSurgeryDetail osDT = (OpdSurgeryDetail) hbt.load(OpdSurgeryDetail.class,
						otDt.getOtPreAnesthesiaDetail().getOpdSurgeryDetail().getId());
				osDT.setSurgeryStatus("c");
				hbt.update(osDT);
			}
			
			
						
			otBookingList3 = session.createCriteria(OtBooking.class).add(
					Restrictions.eq("Id", bookingId)).add(
					Restrictions.eq("OtBookingStatus", "y")).list();
			
			if(otBookingList3!=null & otBookingList3.size() >0)
			{
				 bed_id = otBookingList3.get(0).getBed().getId();
				 MasBed masbed =  (MasBed)hbt.load(MasBed.class, bed_id);
				 int bedstaus =Integer.parseInt(HMSUtil.getValuesFromPropertiesFile("adt.properties", "bedStatusUnOccupiedId".trim()));
				 MasBedStatus bedstatus =  (MasBedStatus)hbt.load(MasBedStatus.class, bedstaus);
				 masbed.setBedStatus(bedstatus);
				 hbt.update(masbed);
			}

			// bookingDate=HMSUtil.convertStringTypeDateToDateType(box.getString("newBookingDate"));

			/*otBookingList3 = session.createCriteria(OtBooking.class).add(
					Restrictions.eq("Id", bookingId)).add(
					Restrictions.eq("OtBookingStatus", "y")).list();
			currentSlno = otBookingList3.get(0).getSlNo();
			currentOt = otBookingList3.get(0).getOt().getId();
			currentBookingDate = otBookingList3.get(0).getSurgeryDate();
			currentBookingDate = otBookingList3.get(0).getSurgeryDate();*/

		/*	otBookingList = session.createCriteria(OtBooking.class).add(
					Restrictions.gt("SlNo", currentSlno)).createAlias("Ot",
					"masOt").add(Restrictions.eq("masOt.Id", currentOt)).add(
					Restrictions.eq("SurgeryDate", currentBookingDate)).list();
			for (OtBooking otBooking : otBookingList) {
				OtBooking otBookingObj = (OtBooking) hbt.load(OtBooking.class,
						otBooking.getId());
				otBookingObj.setSlNo(otBooking.getSlNo() - 1);
				hbt.saveOrUpdate(otBookingObj);

			}*/
			tx.commit();
			dataSaved = true;
			
		}
		
		catch (Exception e) {
			dataSaved = false;
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}

		map.put("dataSaved", dataSaved);
		return map;
	}

	/**
	 * -------------------------- PRE- ANAESTHESIA NOTES ENTRY PROCEDURE
	 * ----------------------
	 */
	public Map<String, Object> searchOtPatientDetails(Map mapForDS) {
		Session session = (Session) getSession();
		//List<OpdSurgeryHeader> pacList = new ArrayList<OpdSurgeryHeader>();
		List<OtBooking> otList = new ArrayList<OtBooking>();
		List<MasOt> masOtList = new ArrayList<MasOt>();
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		   //String hin="";
		   String empId = "";
		   int otId = 0;
	        String pName="";
	        Date surgeryDate =null;
		
	     /*   if(mapForDS.get(HIN_NO)!=null)
			{
				hin = (String)mapForDS.get(HIN_NO);
			}*/
			
			if(mapForDS.get(PATIENT_NAME)!=null)
			{
				pName = (String)mapForDS.get(PATIENT_NAME);
			}
					
			if(mapForDS.get(EMPLOYEE_ID)!=null)
			{
				empId = (String)mapForDS.get(EMPLOYEE_ID);
			}

			if(mapForDS.get(OT_ID)!=null)
			{
				otId = (Integer)mapForDS.get(OT_ID);
			}
			if(mapForDS.get(SURGERY_DATE)!=null)
			{
				surgeryDate = HMSUtil
						.convertStringTypeDateToDateType(mapForDS.get(SURGERY_DATE).toString());
			}
	        
	//	String patientStatus = "Cleared";
		//String otBookingStatus = "y";
		List<String>aList=new ArrayList<String>();
		aList.add("A");
		aList.add("R");
		aList.add("O");
		try {
			/*pacList = session.createCriteria(OpdSurgeryHeader.class).add(
					Restrictions.eq("PacStatus", patientStatus)).list();*/
			masOtList = session.createCriteria(MasOt.class).add(
					Restrictions.eq("Status", "y")).list();
			 
			 Criteria  criteria = session.createCriteria(OtBooking.class)
				.createAlias("Hospital", "h")
				.createAlias("Hin", "hin")
				.createAlias("Inpatient", "ip",CriteriaSpecification.LEFT_JOIN)
				.add(Restrictions.eq("h.Id", hospitalId)).add(Restrictions.or(Restrictions.isNotNull("Visit"), Restrictions.in("ip.AdStatus", aList)))
				//.createAlias("OpdSurseryHeader", "osh")
				//.add(Restrictions.eq("OtBookingStatus", "y").ignoreCase())
				.add(Restrictions.eq("OtPreAnesthesiaStatus", "n").ignoreCase())
				.add(Restrictions.eq("SurgeryStatus", "n").ignoreCase())
				//.add(Restrictions.eq("osh.PacStatus", "cleared").ignoreCase())
				;
		/*	if(hin!="")
			{
				criteria.add(Restrictions.eq("patient.HinNo", hin));
			}*/
			
			if(!pName.equals(""))
			{
				criteria.add(Restrictions.like("hin.PFirstName", pName.toLowerCase()+"%").ignoreCase());
			}
			
			
			if(empId!="")
			{
				criteria.add(Restrictions.eq("hin.ServiceNo", empId));
			}
			
		
			if(surgeryDate!=null)
			{
				criteria.add(Restrictions.eq("SurgeryDate", surgeryDate));
			}
			
			if(otId!=0)
			{
				criteria.createAlias("Ot", "ot")
				.add(Restrictions.eq("ot.Id",otId));
			}
			otList = criteria.list();
			
			
			masOtList = session.createCriteria(MasOt.class).add(
					Restrictions.eq("Status", "y")).list();



		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("masOtList", masOtList);
		map.put("otList", otList);
		return map;

	}

	public Map<String, Object> showPreAneaesthesiaProcNotesEntryJsp(Map mapForDS) {
		Session session = (Session) getSession();
		List<OtBooking> patientDetailList = new ArrayList<OtBooking>();
		List<OtPreAnaesthesiaProcNotesMain> patientList = new ArrayList<OtPreAnaesthesiaProcNotesMain>();
		List<OtPreAnaesthesiaProcNotesMain> preAnesthesiaList = new ArrayList<OtPreAnaesthesiaProcNotesMain>();
		List<OtPreAnaesthesiaProcNotesMain> otList = new ArrayList<OtPreAnaesthesiaProcNotesMain>();
		List<OtPreAnaesthesiaProNotesSub> otDetailList = new ArrayList<OtPreAnaesthesiaProNotesSub>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<MasItemClass> masItemClassList = new ArrayList<MasItemClass>();
		List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
		 List<MasOpInstruction> preInstructionList = null;
		List maxId = new ArrayList();
		Map<String, Object> map = new HashMap<String, Object>();
		// String hinNo = "";
		int bookingId = 0;
		if (mapForDS.get("bookingId") != null) {
			bookingId = (Integer) mapForDS.get("bookingId");
		}
		int hospitalId = 0;
		if (mapForDS.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		}

		String yearlyNo = "";
		if (mapForDS.get("yearlySerialNo") != null) {
			yearlyNo = (String) mapForDS.get("yearlySerialNo");
			// hinNo = "";

		}

		int orderNo = 0;
		String yearlySerialNo = "";
		String monthSerialNo = "";
		String yearSeq = "";
		String monthSeq = "";
		String pastYear = "";
		String pastMonth = "";
		String anesthesiaDetails = "";
		try {
			if (bookingId != 0) {

				Criteria crit = session.createCriteria(OtBooking.class)
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("Id", bookingId));
				patientDetailList = crit.list();
				
				if(patientDetailList.get(0).getOtBookingDt().size() >0)
				anesthesiaDetails = ((OtBookingDt)(patientDetailList.get(0).getOtBookingDt().toArray()[0])).getOtPreAnesthesiaDetail().getAnesthesiaHd().getAnashteicDetails();
				
		/*		OtBooking booking = (OtBooking) session.createCriteria(OtBooking.class)
						.add(Restrictions.eq("OpdSurseryHeader.Id", bookingId))
						.add(Restrictions.eq("OtBookingStatus", "y").ignoreCase())
						.setFirstResult(0)
						.setMaxResults(1)
						.uniqueResult();
				
				map.put("booking", booking);*/
				
				
				if(patientDetailList.size() >0 && patientDetailList.get(0).getHin()!=null)
				{
					List<DischargeIcdCode>icdList=new ArrayList<DischargeIcdCode>();
					icdList=session.createCriteria(DischargeIcdCode.class).add(Restrictions.eq("Hin.Id", patientDetailList.get(0).getHin().getId())).list();
					
					Set<MasIcd> uniqueIcdList=new HashSet <MasIcd>();
					for(DischargeIcdCode icd2:icdList){
						MasIcd masIcd = icd2.getIcd();
						if(icd2.getIcd()!=null){
							uniqueIcdList.add(masIcd);
							
						}
					}
					
					String icd="";
					for(MasIcd icd2:uniqueIcdList){
						icd=icd+"\n"+icd2.getIcdName();
					}
					
					map.put("icd", icd);
				}
				
				
				
				try {
					maxId = session
							.createCriteria(OtPreAnaesthesiaProcNotesMain.class)
							.add(Restrictions.eq("Hospital.Id", hospitalId))
							.setProjection(
									Projections.projectionList().add(
											Projections.max("Id"))).list();

					preAnesthesiaList = session
							.createCriteria(OtPreAnaesthesiaProcNotesMain.class)
							.add(Restrictions.eq("Id", maxId.get(0))).list();
					// preAnesthesiaList=getHibernateTemplate().find("select
					// max(Id), YearlySerialNo,MonthlySerialNo from
					// OtPreAnaesthesiaProcNotesMain pac group by pac.Id");
				} catch (DataAccessException e) {
					e.printStackTrace();
				}

				Calendar calendar = Calendar.getInstance();

				if (preAnesthesiaList != null && preAnesthesiaList.size() > 0) {
					yearlySerialNo = preAnesthesiaList.get(0)
							.getYearlySerialNo();
					monthSerialNo = preAnesthesiaList.get(0)
							.getMonthlySerialNo();
					StringTokenizer st1 = new StringTokenizer(yearlySerialNo,
							"/");
					StringTokenizer st2 = new StringTokenizer(monthSerialNo,
							"/");
					while (st1.hasMoreTokens()) {
						yearSeq = st1.nextToken();
						pastYear = st1.nextToken();

						if (Integer.parseInt(pastYear) != calendar
								.get(Calendar.YEAR)) {

							yearlySerialNo = "1/" + calendar.get(Calendar.YEAR);
						} else {

							yearlySerialNo = Integer.parseInt(yearSeq) + 1
									+ "/" + pastYear;
						}
					}
					while (st2.hasMoreTokens()) {
						monthSeq = st2.nextToken();
						pastMonth = st2.nextToken();
						if (Integer.parseInt(pastMonth) != calendar
								.get(Calendar.MONTH) + 1) {
							monthSerialNo = "1/" + calendar.get(Calendar.MONTH)
									+ 1;
						} else {
							if (Integer.parseInt(pastYear) != calendar
									.get(Calendar.YEAR)) {
								monthSerialNo = "1/"
										+ (calendar.get(Calendar.MONTH) + 1);
							} else {
								monthSerialNo = Integer.parseInt(monthSeq) + 1
										+ "/" + pastMonth;
							}
						}
					}
				} else {
					yearlySerialNo = "1/" + calendar.get(Calendar.YEAR);
					monthSerialNo = "1/" + (calendar.get(Calendar.MONTH) + 1);
				}
			}
			if (!yearlyNo.equals("")) {
				otList = session
						.createCriteria(OtPreAnaesthesiaProcNotesMain.class)
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("YearlySerialNo", yearlyNo))
						.list();
				otDetailList = session
						.createCriteria(OtPreAnaesthesiaProNotesSub.class)
						.createAlias("PreAnaesthesiaMain", "header")
						.add(Restrictions
								.eq("header.Id", otList.get(0).getId())).list();
				map.put("otList", otList);
				map.put("otDetailList", otDetailList);
			}
			
			frequencyList = session.createCriteria(MasFrequency.class).add(
					Restrictions.eq("Status", "y")).list();
			  masItemClassList= session.createCriteria(MasItemClass.class).
						add(Restrictions.eq("Status", "y").ignoreCase())
						 .addOrder(Order.asc("ItemClassName")) .list(); 
			  itemConversionList = session.createCriteria(MasStoreItemConversion.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ItemUnitName")).list();
			  String CodeForPreOPInstruction =HMSUtil.getProperties("adt.properties", "CodeForPreOPInstruction");
			  preInstructionList = session.createCriteria(MasOpInstruction.class).add(Restrictions.eq("Status", "y"))
					  			.createAlias("Op", "op").add(Restrictions.eq("op.OpInsCode", CodeForPreOPInstruction)).list();
			  
			
			  
			  
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		map.put("patientList", patientList);
		map.put("yearlySerialNo", yearlySerialNo);
		map.put("monthSerialNo", monthSerialNo);
		map.put("frequencyList", frequencyList);	
		map.put("anesthesiaDetails",anesthesiaDetails);
		map.put("masItemClassList", masItemClassList);
		map.put("itemConversionList", itemConversionList);
		map.put("preInstructionList", preInstructionList);
		
		return map;
	}

	public Map<String, Object> getStoreItemForAutoComplete(Map mapForDS) {
		List<MasStoreItem> storeItemList = new ArrayList<MasStoreItem>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			// int deptId=(Integer)mapForDS.get("deptId");

			String str = "%" + mapForDS.get("autoHint") + "%";

			// String chargeType= "DIAG";
			Criteria crit = session.createCriteria(MasStoreItem.class).add(
					Restrictions.like("Nomenclature", str)).add(
					Restrictions.eq("Status", "y"));

			crit.setFirstResult(0);
			crit.setMaxResults(10);
			storeItemList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("storeItemList", storeItemList);
		return map;
	}

	public Map<String, Object> getNomenclature(String storeItem) {
		List<MasChargeCode> nomenclatureList = new ArrayList<MasChargeCode>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			nomenclatureList = session.createCriteria(MasStoreItem.class).add(
					Restrictions.eq("Nomenclature", storeItem)).add(
					Restrictions.eq("Status", "y")).list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("nomenclatureList", nomenclatureList);
		return map;
	}

	public Map<String, Object> submitPreAneaesthesiaProcNotesEntryJsp(Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		//Map<String, Object> mapForDS = new HashMap<String, Object>();
		// ------- variables declaration-------
		boolean dataSaved = false;
		//Vector dose = box.getVector("dose");
		//Vector route = box.getVector("route");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		String userName = "";
		if (mapForDS.get("userName") != null) {
			userName = (String) mapForDS.get("userName");
		}
		
		Box box = (Box) mapForDS.get("box");
		
		int opdSurgeryHeaderId = box.getInt("opdSurgeryHeaderId");
		
		int hinId = box.getInt("hinId");
		int orderNo = box.getInt("orderNo");
		int visitId = box.getInt(VISIT_ID);
		int bookingId = box.getInt("bookingId");
		int inpatientId = box.getInt(INPATIENT_ID);
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		String preOperativeAdvice = box.getString("preOperativeAdvice");
		String remarks = box.getString("remarks");
		String yearlySrNo = box.getString("yearlySqNo");
		String monthlySrNo = box.getString("monthlySqNo");
		
		List<Integer> itemIdList = (List<Integer>) mapForDS.get("itemIdList");
		List<Integer> frequencyList = (List) mapForDS.get("frequencyList");
		List<String> otherMedicineList = (List) mapForDS.get("otherMedicineList");
		List<String> nomenclatureList =  (List) mapForDS.get("nomenclatureList");
		List<Integer> itemConversionList = (List) mapForDS.get("itemConversionList");
		List<Integer> itemClassList = (List) mapForDS.get("itemClassList");
		List<String> itemDispensaryList = (List) mapForDS.get("itemDispensaryList");
		List<String> ctList = (List) mapForDS.get("ctList");

		List<String> dosageList = (List) mapForDS.get("dosageList");
		
		List<String> routeList = new ArrayList<String>();
		routeList= (List) mapForDS.get("routeList");
		List<Integer> totalList = (List) mapForDS.get("totalList");
		List<Integer> noOfDaysList = (List) mapForDS.get("noOfDaysList");
		List<String> remarksList = (List) mapForDS.get("remarksList");
		List<String> PreOpInstructionList = (List) mapForDS.get("PreOpInstructionList");
		String consultationTime = (String) box.get("currentTime");
		String consultationDate = (String) box.get("currentDate");
		Date consultationDateToInsert = HMSUtil
				.convertStringTypeDateToDateType(consultationDate);
		int departmentId = (Integer) mapForDS.get("deptId");
		int empId = 0;
		empId = (Integer) mapForDS.get("empId");
		int userId = (Integer) mapForDS.get(USER_ID);
		Users user = new Users();
		user.setId(userId);
		
		
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		

		MasEmployee employee = new MasEmployee();
		employee.setId(empId);
		

		Patient patient = new Patient();
		patient.setId(hinId);
		
		// ------ business logic-------
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;

		try {
		
			tx = session.beginTransaction();
			OtPreAnaesthesiaProcNotesMain otPreAnaesthesiaProcNotesMain = new OtPreAnaesthesiaProcNotesMain();

			otPreAnaesthesiaProcNotesMain.setHin(patient);
			otPreAnaesthesiaProcNotesMain
					.setPreOperativeAdvice(preOperativeAdvice);
			otPreAnaesthesiaProcNotesMain.setRemarks(remarks);
			otPreAnaesthesiaProcNotesMain.setYearlySerialNo(yearlySrNo);
			otPreAnaesthesiaProcNotesMain.setMonthlySerialNo(monthlySrNo);
			otPreAnaesthesiaProcNotesMain.setOrderNo(orderNo);
			if (hospitalId != 0) {
				otPreAnaesthesiaProcNotesMain.setHospital(masHospital);
			}
			if (bookingId != 0) {
				OtBooking otBooking = new OtBooking();
				otBooking.setId(bookingId);
				otPreAnaesthesiaProcNotesMain.setBooking(otBooking);
			}
			if (visitId != 0) {
				Visit otvisit = new Visit();
				otvisit.setId(visitId);
				otPreAnaesthesiaProcNotesMain.setVisit(otvisit);
			}

			otPreAnaesthesiaProcNotesMain.setLastChgBy(user);
			otPreAnaesthesiaProcNotesMain.setLastChgDate(date);
			otPreAnaesthesiaProcNotesMain.setLastChgTime(time);
			hbt.save(otPreAnaesthesiaProcNotesMain);

//save pre instruction
			//PreOpInstructionList
			
			List<OtPreOpInstruction> opInstructionList = new ArrayList<OtPreOpInstruction>();
			
			if(PreOpInstructionList.size()!=0)
			{
			for(String ins :PreOpInstructionList)
			{
				if(ins!=null && !ins.isEmpty()){
					OtPreOpInstruction opInstruction = new OtPreOpInstruction();
					opInstruction.setOtPreAnaesthesiaProcNotesMain(otPreAnaesthesiaProcNotesMain);
					opInstruction.setPreOpInstruction(ins);
					opInstructionList.add(opInstruction);
					
				}
			}
			
			hbt.saveOrUpdateAll(opInstructionList);
			}
		
	
//save prescription
			
			String preCode = HMSUtil.getProperties("adt.properties", "CodeForPreAnesthesia");
			Visit visit = null;
			   Inpatient inpatient = null;
				if(visitId!=0)
						{
					visit = new Visit();
					visit.setId(visitId);
						}
						if(inpatientId!=0)
						{
							inpatient = new Inpatient();
							inpatient.setId(inpatientId);
						}
	if (itemIdList.size() > 0 || otherMedicineList.size() >0) {	
			PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();;
			int item_class_id = 0;
			patientPrescriptionHeader.setNipStatus("n");
			/*	if(visitId!=0)
				{
					patientPrescriptionHeader.setVisit(visit);
				}*/
			/*	if(inpatientId!=0)
				{*/
					patientPrescriptionHeader.setInpatient(inpatient);
				//}
				patient.setId(hinId);
				patientPrescriptionHeader.setHin(patient);
				masDepartment.setId(departmentId);
				patientPrescriptionHeader.setDepartment(masDepartment);
				masHospital.setId(hospitalId);
				patientPrescriptionHeader.setHospital(masHospital);
				patientPrescriptionHeader.setStatus("p");
				patientPrescriptionHeader
						.setPrescriptionDate(consultationDateToInsert);
				patientPrescriptionHeader.setPrescriptionTime(consultationTime);

				employee.setId(empId);
				patientPrescriptionHeader.setEmp(employee);
		
				Map<String, Object> adMap = new HashMap<String, Object>();
			      adMap.put("tableObjectName", "PATIENT_PRESCRIPTION_HEADER");            
		            adMap.put("isHospitalWise", "y");
		            adMap.put("hospitalId", 1);
		            adMap.put("isYearly", "n");            
		            adMap.put("isMonthly", "n");
		            adMap.put("isPrefix", "n");
		    
			
			        int prescriptionNo = Integer.parseInt(HMSUtil.generateTransactionSequence(adMap, session, hbt));
				patientPrescriptionHeader.setPrescriptionNo(prescriptionNo);

				String sqlItemId="";

				for (int i = 0; i < itemIdList.size(); i++) {
	
					int itemId = (Integer)itemIdList.get(i);;
					if(i==0){
						sqlItemId=""+itemId;
					}else{
						sqlItemId +=" , "+itemId;
					}

				}
				List<MasStoreItem> masItemList=new ArrayList<MasStoreItem>();
				Properties properties = new Properties();
				URL resourcePath = Thread.currentThread().getContextClassLoader()
						.getResource("adt.properties");
				
				try {
					properties.load(resourcePath.openStream());
					String item_class_code = properties.getProperty("item_class_id");
					item_class_id=Integer.parseInt(item_class_code);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(!sqlItemId.equals(""))
					masItemList=hbt.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemCategory as ic where item.Id in ("+sqlItemId+") and ic.Id="+item_class_id);
				
				if(masItemList.size()>0){
					patientPrescriptionHeader.setInjectionStatus("p");
				}else{
					patientPrescriptionHeader.setInjectionStatus("n");
				}
				patientPrescriptionHeader.setOtherTreatment((String)mapForDS.get("otherTreatment"));
				hbt.save(patientPrescriptionHeader);
			

			
				for (int i = 0; i < itemIdList.size(); i++) {
					if(itemIdList.get(i) !=0){
					List<MasStoreItem> itemCodeList = new ArrayList<MasStoreItem>();
					PatientPrescriptionDetails patientPrescriptionDetails = new PatientPrescriptionDetails();
					patientPrescriptionDetails.setOtStage(preCode);
					if(itemIdList.get(i) != null){
						MasStoreItem masStoreItem = new MasStoreItem();
						masStoreItem.setId(itemIdList.get(i));
					patientPrescriptionDetails.setItem(masStoreItem);
					}
					if (frequencyList.get(i) != null && !frequencyList.get(i).equals("")) {
						MasFrequency masFrequency = new MasFrequency();
						masFrequency.setId(frequencyList.get(i));
						patientPrescriptionDetails.setFrequency(masFrequency);
						}
						if (dosageList.get(i) != null && !dosageList.get(i).equals("") && !dosageList.get(i).equals("0")) {
							patientPrescriptionDetails.setDosage(dosageList.get(i));
						}else{
							patientPrescriptionDetails.setDosage("0");
						}
						
						if (remarksList.get(i) != null && !remarksList.get(i).equals("")) {
							patientPrescriptionDetails.setRemarks(remarksList.get(i));
						}
	
						if (noOfDaysList.get(i) != null && !noOfDaysList.get(i).equals("")) {
							patientPrescriptionDetails.setNoOfDays(noOfDaysList.get(i));
						}
						if (routeList.get(i) != null && !routeList.get(i).equals("")) {
							patientPrescriptionDetails.setRoute(routeList.get(i));
						}
				
						if (totalList.get(i) != null && !totalList.get(i).equals("") && totalList.get(i) != 0) {
							patientPrescriptionDetails.setTotal(totalList.get(i));
						}else{
							patientPrescriptionDetails.setTotal(1);
						}
						patientPrescriptionDetails.setGivenQty(0);
	
					patientPrescriptionDetails.setPrescription(patientPrescriptionHeader);
				
					patientPrescriptionDetails.setDetailStatus("a");
					
					
		
					List<MasStoreItem> storeItemList=new ArrayList<MasStoreItem>();
				
					try {
						properties.load(resourcePath.openStream());
						String item_class_code = properties.getProperty("item_class_id");
						item_class_id=Integer.parseInt(item_class_code);
					} catch (Exception e) {
						e.printStackTrace();
					}
					storeItemList=hbt.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemClass as ic where item.Id="+itemIdList.get(i)+" and ic.Id="+item_class_id);
					if(storeItemList.size() > 0){
						patientPrescriptionDetails.setInjectionStatus("p");
					}else{
						patientPrescriptionDetails.setInjectionStatus("n");
					}
					
					hbt.save(patientPrescriptionDetails);
				}
				}
				
				//
				if(otherMedicineList.size() >0){
					String otherItem = "";
					patientPrescriptionHeader.setNipStatus("y");
					hbt.update(patientPrescriptionHeader);
					String nipCode = null;
					int itemClassificationId = 0;
					int groupId = 0;
					int sectionId = 0;
					int itemTypeId= 0;
					try
					{
						nipCode = HMSUtil.getProperties("adt.properties", "ItemClassificationCodeNIP");
						itemClassificationId = Integer.parseInt(HMSUtil.getProperties("adt.properties", "ItemClassificationId"));
						groupId = Integer.parseInt(HMSUtil.getProperties("adt.properties", "ItemGroupId"));
						sectionId = Integer.parseInt(HMSUtil.getProperties("adt.properties", "SectionIdForDrugs"));
						itemTypeId = Integer.parseInt(HMSUtil.getProperties("adt.properties", "ItemTypeId"));
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					int totalNip = session.createCriteria(MasStoreItem.class).createAlias("ItemClassification", "ic").add(Restrictions.eq("ic.Classification", nipCode)).add(Restrictions.eq("Hospital.Id", hospitalId)).list().size();
					
						
				for(int i = 0; i < otherMedicineList.size(); i++){
					MasStoreItem masItem = new MasStoreItem();
					if(otherMedicineList.get(i) != null && !otherMedicineList.get(i).equals("")){
						otherItem =(String)otherMedicineList.get(i);
						masItem.setNomenclature(otherMedicineList.get(i));
						MasStoreSection masStoreSection = new MasStoreSection();
						masStoreSection.setId(sectionId);
						masItem.setSection(masStoreSection);
						masItem.setStatus("y");
						masItem.setBrandedGeneric("B");
						
						if (itemConversionList.get(i) != null && !itemConversionList.get(i).equals("")) {
							MasStoreItemConversion masStoreItemConversion = new MasStoreItemConversion();
							masStoreItemConversion.setId(itemConversionList.get(i));
							masItem.setItemConversion(masStoreItemConversion);
							}
						
						if (itemClassList.get(i) != null && !itemClassList.get(i).equals("")) {
							 MasItemClass masItemClass = new MasItemClass();
							 masItemClass.setId(itemClassList.get(i));
							masItem.setItemClass(masItemClass);
							}
						
						if (itemDispensaryList.get(i) != null && !itemDispensaryList.get(i).equals("")) {
							masItem.setDispUnit(itemDispensaryList.get(i));
							}
						totalNip++;
						masItem.setPvmsNo(nipCode+totalNip);
						
						MasItemType masItemType = new MasItemType();
						masItemType.setId(itemTypeId);
						masItem.setItemType(masItemType);
					
						masHospital.setId(hospitalId);
						masItem.setHospital(masHospital);
						masItem.setHighValueDrug("n");
						MasItemClassification Mic = new MasItemClassification();
						Mic.setId(itemClassificationId);
						masItem.setItemClassification(Mic);
						MasStoreGroup msgrp = new MasStoreGroup();
						msgrp.setId(groupId);
						masItem.setGroup(msgrp);
						masItem.setLastChgBy(userName);
						masItem.setLastChgDate(date);
						masItem.setLastChgTime(time);
						
						hbt.save(masItem);
				
					PatientPrescriptionDetails patientPrescriptionDetails = new PatientPrescriptionDetails();
					patientPrescriptionDetails.setOtStage(preCode);
					if(masItem.getId() != null){
						MasStoreItem masStoreItem = new MasStoreItem();
						masStoreItem.setId(masItem.getId());
					patientPrescriptionDetails.setItem(masStoreItem);
					}
					if (frequencyList.get(i) != null && !frequencyList.get(i).equals("")) {
					MasFrequency masFrequency = new MasFrequency();
					masFrequency.setId(frequencyList.get(i));
					patientPrescriptionDetails.setFrequency(masFrequency);
					}
					if (dosageList.get(i) != null && !dosageList.get(i).equals("")) {
						patientPrescriptionDetails.setDosage(dosageList.get(i));
					}
					if (remarksList.get(i) != null && !remarksList.get(i).equals("")) {
					patientPrescriptionDetails.setRemarks(remarksList.get(i));
					}
					//patientPrescriptionDetails.setType(typeLeftRightList.get(i));
					if (noOfDaysList.get(i) != null && !noOfDaysList.get(i).equals("")) {
						patientPrescriptionDetails.setNoOfDays(noOfDaysList.get(i));
					}
					if (routeList.get(i) != null && !routeList.get(i).equals("")) {
						patientPrescriptionDetails.setRoute(routeList.get(i));
					}
					
					//patientPrescriptionDetails.setInstruction(instructionList.get(i));
					if (totalList.get(i) != null && !totalList.get(i).equals("")) {
						patientPrescriptionDetails.setTotal(totalList.get(i));
					}
					patientPrescriptionDetails.setPrescription(patientPrescriptionHeader);
					patientPrescriptionDetails.setGivenQty(0);
					patientPrescriptionDetails.setDetailStatus("a");
					List<MasStoreItem> storeItemList=new ArrayList<MasStoreItem>();
					
					if(ctList.get(i).equals("y")){
						patientPrescriptionDetails.setCt("yes");
					}else{
						patientPrescriptionDetails.setCt("no");
					}
					patientPrescriptionDetails.setInjectionStatus("n");
					hbt.save(patientPrescriptionDetails);
					
			
					}
			
				}
			}
				
				
			}
			
	
//Investigation
			int hiddenValue = box.getInt("hiddenValue");
			int temp = 1;
			String[] chargeCodeIdArr = new String[hiddenValue];
			List<String> chargeCodeIdList = new ArrayList<String>();
			
			for (int i = 0; i < hiddenValue; i++) {
				if (box.get("chargeCodeName" + temp) != null
						&& !box.get("chargeCodeName" + temp)
								.equals("")) {

					String chargeCodeNameWithId = box.getString("chargeCodeName" + temp);
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
						//quantityList.add(qty);
						// clinicalList.add(clinicalNotes);
						
						
					}
				}
				temp++;
			}
	
			if (chargeCodeIdList.size() > 0) {
			//investigation
			/*Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);*/
			MasEmployee emp = new MasEmployee();
			emp.setId(empId);
			
			//OpdSurgeryHeader opsSH = new OpdSurgeryHeader();
			//opsSH.setId(opdSurgeryHeaderId);
			

			DgOrderhd dgOrderhd = new DgOrderhd();
			if(visitId!=0)
			{
				dgOrderhd.setVisit(visit);
			}
			if(inpatientId!=0)
			{
				dgOrderhd.setInpatient(inpatient);
			}

			dgOrderhd.setOrderDate(new Date());
			dgOrderhd.setOrderTime(consultationTime);
			dgOrderhd.setHospital(masHospital);
			dgOrderhd.setHin(patient);
			dgOrderhd.setDepartment(masDepartment);
			dgOrderhd.setPrescribedBy(emp);
			
			//dgOrderhd.setSurgery(opsSH);
			dgOrderhd.setPatientType("IP");
			dgOrderhd.setTestType("Regular");
			dgOrderhd.setCreatedby(box.getString("userName"));
			dgOrderhd.setCreatedon(new Date());

			//String orderSeqNo = generateOrderNumber(box.getInt("hospitalId"));
			
			Map<String, Object> adMap = new HashMap<String, Object>();
		      adMap.put("tableObjectName", "DgOrderhd");            
	            adMap.put("isHospitalWise", "y");
	            adMap.put("hospitalId", hospitalId);
	            adMap.put("isYearly", "n");            
	            adMap.put("isMonthly", "n");
	            adMap.put("isPrefix", "n");
			 //adtHandlerService.generateAdNumber(adMap);
			
			//String issueNo = generateTransactionSequence(adMap, session);
	            String orderSeqNo = HMSUtil.generateTransactionSequence(adMap, session, hbt);
			
			dgOrderhd.setOrderNo(orderSeqNo);
			//dgOrderhd.setInpatient(inpatient);
			
			dgOrderhd.setClinicalNote(box.getString("clinicalNotes1"));
			dgOrderhd.setOrderStatus("P");
			dgOrderhd.setLabOrderStatus("P");
			dgOrderhd.setLastChgBy(user);
			dgOrderhd.setLastChgDate(new Date());
			dgOrderhd.setLastChgTime(consultationTime);
			//dgOrderhd.setInvestigationRequestionNo(patientInvestigationHeader);
			hbt.save(dgOrderhd);
			
			for (int i = 0; i < chargeCodeIdList.size(); i++) {
				
				List<Patient> patientList = new ArrayList<Patient>();   
				String patientTypeNameForHAL = null;
				String patientTypeNameForOther = null;
				String dgOrderBillingStatus ="";
				
				Properties properties = new Properties();
				URL resourcePath = Thread.currentThread().getContextClassLoader()
						.getResource("adt.properties");
				try {
					properties.load(resourcePath.openStream());
					
					 patientTypeNameForHAL = properties.getProperty("patientTypeNameForHAL");;
					 patientTypeNameForOther = properties.getProperty("patientTypeNameForOther");;
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				Criteria crit = session.createCriteria(Patient.class).add(
						Restrictions.eq("Id", hinId));
				patientList = crit.list();
							
				
				if(patientList.size()!=0)
				{
					if(patientList.get(0).getPatientType().getPatientTypeName().equals(patientTypeNameForHAL))
					{
						dgOrderBillingStatus ="y";
					}
					else if(patientList.get(0).getPatientType().getPatientTypeName().equals(patientTypeNameForOther))
					{
						if(patientList.get(0).getBillable().equals("y"))
						    dgOrderBillingStatus ="n";
						else if(patientList.get(0).getBillable().equals("n"))
							dgOrderBillingStatus ="y";
					}
				}
	
				MasChargeCode masChargeCode = new MasChargeCode();
				//System.out.println("Integer.parseInt(chargeCodeIdList.get(i))--"+Integer.parseInt(chargeCodeIdList.get(i)));
				masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));

				DgOrderdt dgOrderdt = new DgOrderdt();
				dgOrderdt.setOtStage(preCode);
				dgOrderdt.setOrderhd(dgOrderhd);
				masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
				dgOrderdt.setChargeCode(masChargeCode);
				//dgOrderdt.setOrderQty(quantityList.get(i));
				dgOrderdt.setBillingStatus(dgOrderBillingStatus);
				dgOrderdt.setCreatedby(box.getString("userName"));
				dgOrderdt.setCreatedon(new Date());
				dgOrderdt.setLastChgBy(user);
				
				dgOrderdt.setLastChgDate(new Date());
				dgOrderdt.setLastChgTime(consultationTime);
				dgOrderdt.setMsgSent("n");
				// method written for taking out the values of mascharge
				// code and subcharge

				List<MasChargeCode> masChargeList = new ArrayList<MasChargeCode>();
				masChargeList = session.createCriteria(MasChargeCode.class).add(
						Restrictions.eq("Id", Integer.parseInt(chargeCodeIdList.get(i)))).list();
				
				MasChargeCode masChargeCodeObj = masChargeList.get(0);
				int mainChargeId = masChargeCodeObj.getMainChargecode()
				.getId();
				int subChargeId = masChargeCodeObj.getSubChargecode()
				.getId();
				if (masChargeCodeObj.getMainChargecode()
						.getMainChargecodeCode().equalsIgnoreCase("Lab")) {
					dgOrderdt.setOrderStatus("P");
				} else {
					dgOrderdt.setOrderStatus("P");
				}
				MasMainChargecode masMainChargecode = new MasMainChargecode();
				masMainChargecode.setId(mainChargeId);
				dgOrderdt.setMainChargecode(masMainChargecode);
				MasSubChargecode masSubChargecode = new MasSubChargecode();
				masSubChargecode.setId(subChargeId);
				dgOrderdt.setSubChargeid(masSubChargecode);
				dgOrderdt.setInvestigation(new DgMasInvestigation(Integer.parseInt(chargeCodeIdList.get(i))));
				//dgOrderdt.setInvestigationToMH(referToMhList.get(i));
				dgOrderdt.setInvestigationToMh("n");
				//dgOrderdt.setReferToMh(referToMhList.get(i));
				dgOrderdt.setReferToMh("n");

				
				hbt.save(dgOrderdt);
			}
	
		}
			OtBooking otBooking = (OtBooking) hbt.load(OtBooking.class,
					bookingId);
			otBooking.setOtPreAnesthesiaStatus("y");
			hbt.update(otBooking);
			
			tx.commit();
			dataSaved = true;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}
		map.put("dataSaved", dataSaved);

		return map;
	}

	/**
	 * ------------------------- OT PROCEDURE NOTES ENTRY
	 * ------------------------------
	 */
	public Map<String, Object> showOtProcedureNotesEntryJsp(Map mapForDS) {
		Session session = (Session) getSession();
		List<OtBooking> patientDetailList = new ArrayList<OtBooking>();
		List<OtProcedureNotesEntryHeader> otList = new ArrayList<OtProcedureNotesEntryHeader>();
		List<OtProcedureNotesEntryDetail> otDetailList = new ArrayList<OtProcedureNotesEntryDetail>();
		List<OtProcedureNotesEntryHeader> otProcedureNotesList = new ArrayList<OtProcedureNotesEntryHeader>();
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();
		List<OtBookSurgeon> otBookSurgeaonList = new ArrayList<OtBookSurgeon>();
		// List<OtPreAnesthesiaDetails>otPreAnesthesiaDetailsList=new
		// ArrayList<OtPreAnesthesiaDetails>();
		List<MasAnesthesia> anaesthesiaList = new ArrayList<MasAnesthesia>();
		List maxId = new ArrayList();
		Map<String, Object> map = new HashMap<String, Object>();

		Integer otBookingId = 0;

		if (mapForDS.get("otBookingId") != null) {
			otBookingId = Integer
					.parseInt((String) mapForDS.get("otBookingId"));
		}
		String yearlyNo = "";
		if (mapForDS.get("yearlySerialNo") != null) {
			yearlyNo = (String) mapForDS.get("yearlySerialNo");
			// otBookingId = 0;

		}
		int orderNo = 0;
		String yearlySerialNo = "";
		String monthSerialNo = "";
		String yearSeq = "";
		String monthSeq = "";
		String pastYear = "";
		String pastMonth = "";

		anaesthesiaList = session.createCriteria(MasAnesthesia.class).add(
				Restrictions.eq("Status", "y")).list();
		if (otBookingId != 0) {

			Criteria crit = session.createCriteria(OtBooking.class)
			/*
			 * .createAlias("Hin", "p") .add(Restrictions.eq("p.HinNo", hinNo));
			 */
			.add(Restrictions.eq("Id", otBookingId)).add(
					Restrictions.eq("PostOpNotesSurgeryStatus", "n"));
			patientDetailList = crit.list();
			if (patientDetailList.size() > 0) {
				otBookSurgeaonList = session
						.createCriteria(OtBookSurgeon.class).createAlias(
								"Booking", "ot").add(
								Restrictions.eq("ot.Id", patientDetailList.get(
										0).getId())).list();
				/*
				 * otPreAnesthesiaDetailsList=session.createCriteria(OtPreAnesthesiaDetails
				 * .class).createAlias("Hin","p")
				 * .add(Restrictions.eq("p.HinNo",hinNo)).list();
				 */
				try {
					maxId = session.createCriteria(
							OtProcedureNotesEntryHeader.class).setProjection(
							Projections.projectionList().add(
									Projections.max("Id"))).list();

					otProcedureNotesList = session.createCriteria(
							OtProcedureNotesEntryHeader.class).add(
							Restrictions.eq("Id", maxId.get(0))).list();
					// preAnesthesiaList=getHibernateTemplate().find("select max(Id), YearlySerialNo,MonthlySerialNo from OtPreAnaesthesiaProcNotesMain pac group by pac.Id");

					Calendar calendar = Calendar.getInstance();

					if (otProcedureNotesList != null
							&& otProcedureNotesList.size() > 0) {
						yearlySerialNo = otProcedureNotesList.get(0)
								.getYearlySerialNo();
						monthSerialNo = otProcedureNotesList.get(0)
								.getMonthlySerialNo();
						StringTokenizer st1 = new StringTokenizer(
								yearlySerialNo, "/");
						StringTokenizer st2 = new StringTokenizer(
								monthSerialNo, "/");
						while (st1.hasMoreTokens()) {
							yearSeq = st1.nextToken();
							pastYear = st1.nextToken();

							if (Integer.parseInt(pastYear) != calendar
									.get(Calendar.YEAR)) {

								yearlySerialNo = "1/"
										+ calendar.get(Calendar.YEAR);
							} else {

								yearlySerialNo = Integer.parseInt(yearSeq) + 1
										+ "/" + pastYear;
							}
						}
						while (st2.hasMoreTokens()) {
							monthSeq = st2.nextToken();
							pastMonth = st2.nextToken();
							if (Integer.parseInt(pastMonth) != calendar
									.get(Calendar.MONTH) + 1) {
								monthSerialNo = "1/"
										+ calendar.get(Calendar.MONTH) + 1;
							} else {
								if (Integer.parseInt(pastYear) != calendar
										.get(Calendar.YEAR)) {
									monthSerialNo = "1/"
											+ (calendar.get(Calendar.MONTH) + 1);
								} else {
									monthSerialNo = Integer.parseInt(monthSeq)
											+ 1 + "/" + pastMonth;
								}
							}
						}
					} else {
						yearlySerialNo = "1/" + calendar.get(Calendar.YEAR);
						monthSerialNo = "1/"
								+ (calendar.get(Calendar.MONTH) + 1);
					}

				} catch (HibernateException e) {
					e.printStackTrace();
				} catch (DataAccessException e) {
					e.printStackTrace();
				}
				List<OtPreAnesthesiaHd> otPreAnaesthesiaDetailsList = new ArrayList<OtPreAnesthesiaHd>();
				/*
				 * crit = session.createCriteria(OtPreAnesthesiaDetails.class)
				 * .createAlias("Hin", "hin") .add(Restrictions.eq("hin.HinNo",
				 * hinNo)) .addOrder(Order.desc("Id"));
				 * 
				 * otPreAnaesthesiaDetailsList = crit.list();
				 */
				map.put("otPreAnaesthesiaDetailsList",
						otPreAnaesthesiaDetailsList);

				map.put("patientDetailList", patientDetailList);

				map.put("otBookSurgeaonList", otBookSurgeaonList);
				map.put("yearlySerialNo", yearlySerialNo);
				map.put("monthSerialNo", monthSerialNo);

			} else {
				otList = session.createCriteria(
						OtProcedureNotesEntryHeader.class).add(
						Restrictions.eq("OtBooking.Id", otBookingId)).list();
				otDetailList = session.createCriteria(
						OtProcedureNotesEntryDetail.class).createAlias(
						"OtProcedureHeader", "header").add(
						Restrictions.eq("header.Id", otList.get(0).getId()))
						.list();
				map.put("otList", otList);
				map.put("otDetailList", otDetailList);

			}

			// map.put("otPreAnesthesiaDetailsList",
			// otPreAnesthesiaDetailsList);
		}
		map.put("anaesthesiaList", anaesthesiaList);
		return map;
	}

	public Map<String, Object> getEmpNameForAutoComplete(Map mapForDS) {
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			// int deptId=(Integer)mapForDS.get("deptId");

			String str = "%" + mapForDS.get("autoHint") + "%";

			// String chargeType= "DIAG";
			Criteria crit = session.createCriteria(MasEmployee.class).add(
					Restrictions.like("FirstName", str)).createAlias(
					"EmpCategory", "empCat").add(
					Restrictions.eq("empCat.EmpCategoryCode", "01")).add(
					Restrictions.eq("Status", "y"));

			crit.setFirstResult(0);
			crit.setMaxResults(10);
			empList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("empList", empList);
		return map;
	}

	public Map<String, Object> submitOtProcedureNotesEntryJsp(Box box,
			List<Integer> employeeId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		// ------- variables declaration-------
		boolean dataSaved = false;
		int otPreAnaesthesiaProcNotesMainId = 0;
		int hinId = box.getInt("hinId");

		int orderNo = box.getInt("orderNo");
		int hospitalId = box.getInt("hospitalId");
		Date date = HMSUtil.convertStringTypeDateToDateType(box.get("date"));
		String surgeryFromTime = box.getString("surgeryFromTime");
		String surgeryToTime = box.getString("surgeryToTime");

		String anaesthesiaValue = box.getString("anaesthesiaId");
		// int anaesthesiaId=box.getInt("anaesthesiaId");

		String preOpOrders = box.getString("preOpOrders");
		String findings = box.getString("findings");
		String postOpOrders = box.getString("postOpOrders");
		String yearlySrNo = box.getString("yearlySerialNo");
		String monthlySrNo = box.getString("monthlySerialNo");
		String lastChgBy = box.getString("changedBy");
		String lastChgTime = box.getString("changedTime");
		Integer otBookingId = box.getInt("otBookingId");

		Date lastChgDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString("changedDate"));

		// ------ business logic-------
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			OtProcedureNotesEntryHeader otProcedureNotesEntryHeader = new OtProcedureNotesEntryHeader();

			Patient patient = new Patient();
			patient.setId(hinId);
			otProcedureNotesEntryHeader.setHin(patient);
			otProcedureNotesEntryHeader.setSurgeryFromTime(surgeryFromTime);
			otProcedureNotesEntryHeader.setSurgeryToTime(surgeryToTime);
			otProcedureNotesEntryHeader.setDate(date);
			OtBooking otBooking = new OtBooking();
			otBooking.setId(otBookingId);
			otProcedureNotesEntryHeader.setOtBooking(otBooking);
			/*
			 * if(anaesthesiaId != 0){ MasAnesthesia masAnesthesia=new
			 * MasAnesthesia(); masAnesthesia.setId(anaesthesiaId);
			 * otProcedureNotesEntryHeader.setAnaesthesia(masAnesthesia); }
			 */
			if (!anaesthesiaValue.equals("")) {
				otProcedureNotesEntryHeader
						.setAnaesthesiaValue(anaesthesiaValue);
			}

			otProcedureNotesEntryHeader.setPreOpOrders(preOpOrders);
			otProcedureNotesEntryHeader.setFindingsNProcedures(findings);
			otProcedureNotesEntryHeader.setPostOpOrders(postOpOrders);
			otProcedureNotesEntryHeader.setYearlySerialNo(yearlySrNo);
			otProcedureNotesEntryHeader.setMonthlySerialNo(monthlySrNo);
			otProcedureNotesEntryHeader.setLastChgBy(lastChgBy);
			otProcedureNotesEntryHeader.setLastChgDate(lastChgDate);
			otProcedureNotesEntryHeader.setLastChgTime(lastChgTime);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			otProcedureNotesEntryHeader.setHospital(masHospital);

			hbt.save(otProcedureNotesEntryHeader);

			for (int i = 0; i < employeeId.size(); i++) {
				OtProcedureNotesEntryDetail otProcedureNotesEntryDetail = new OtProcedureNotesEntryDetail();

				otProcedureNotesEntryDetail
						.setOtProcedureHeader(otProcedureNotesEntryHeader);

				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(employeeId.get(i));
				otProcedureNotesEntryDetail.setEmployee(masEmployee);

				hbt.save(otProcedureNotesEntryDetail);

			}
			OtBooking booking = (OtBooking) hbt.load(OtBooking.class,
					otBookingId);
			booking.setPostOpNotesSurgeryStatus("y");
			hbt.update(booking);
			hbt.refresh(booking);

			dataSaved = true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		map.put("dataSaved", dataSaved);
		map.put("yearlySrNo", yearlySrNo);

		return map;
	}

	public Map<String, Object> updateOtProcedureNotesEntryJsp(Box box,
			List<Integer> employeeId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		// ------- variables declaration-------
		boolean dataSaved = false;
		int hinId = box.getInt("hinId");

		int hospitalId = box.getInt("hospitalId");
		Date date = HMSUtil.convertStringTypeDateToDateType(box.get("date"));
		String surgeryFromTime = box.getString("surgeryFromTime");
		String surgeryToTime = box.getString("surgeryToTime");

		String anaesthesiaValue = box.getString("anaesthesiaId");
		// int anaesthesiaId=box.getInt("anaesthesiaId");

		String preOpOrders = box.getString("preOpOrders");
		String findings = box.getString("findings");
		String postOpOrders = box.getString("postOpOrders");
		String yearlySrNo = box.getString("yearlySerialNo");
		String monthlySrNo = box.getString("monthlySerialNo");
		String lastChgBy = box.getString("changedBy");
		String lastChgTime = box.getString("changedTime");
		List<OtProcedureNotesEntryHeader> otProcedureNotesEntryHeaderList = new ArrayList<OtProcedureNotesEntryHeader>();

		Date lastChgDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString("changedDate"));
		OtProcedureNotesEntryHeader otProcedureNotesEntryHeader = null;
		// ------ business logic-------
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			if (!yearlySrNo.equals("")) {
				Criteria crit = session.createCriteria(
						OtProcedureNotesEntryHeader.class).add(
						Restrictions.eq("YearlySerialNo", yearlySrNo));

				otProcedureNotesEntryHeaderList = crit.list();

				otProcedureNotesEntryHeader = otProcedureNotesEntryHeaderList
						.get(0);

				Patient patient = new Patient();
				patient.setId(hinId);
				otProcedureNotesEntryHeader.setHin(patient);
				otProcedureNotesEntryHeader.setSurgeryFromTime(surgeryFromTime);
				otProcedureNotesEntryHeader.setSurgeryToTime(surgeryToTime);
				otProcedureNotesEntryHeader.setDate(date);

				/*
				 * if(anaesthesiaId != 0){ MasAnesthesia masAnesthesia=new
				 * MasAnesthesia(); masAnesthesia.setId(anaesthesiaId);
				 * otProcedureNotesEntryHeader.setAnaesthesia(masAnesthesia); }
				 */
				if (!anaesthesiaValue.equals("")) {
					otProcedureNotesEntryHeader
							.setAnaesthesiaValue(anaesthesiaValue);
				}

				otProcedureNotesEntryHeader.setPreOpOrders(preOpOrders);
				otProcedureNotesEntryHeader.setFindingsNProcedures(findings);
				otProcedureNotesEntryHeader.setPostOpOrders(postOpOrders);
				otProcedureNotesEntryHeader.setYearlySerialNo(yearlySrNo);
				otProcedureNotesEntryHeader.setMonthlySerialNo(monthlySrNo);
				otProcedureNotesEntryHeader.setLastChgBy(lastChgBy);
				otProcedureNotesEntryHeader.setLastChgDate(lastChgDate);
				otProcedureNotesEntryHeader.setLastChgTime(lastChgTime);

				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				otProcedureNotesEntryHeader.setHospital(masHospital);

				hbt.save(otProcedureNotesEntryHeader);
				hbt.update(otProcedureNotesEntryHeader);

				Set<OtProcedureNotesEntryDetail> otProcedureNotesEntryDetailSet = otProcedureNotesEntryHeader
						.getOtProcedureNotesEntryDetails();

				Query deleteQuery = session
						.createQuery("delete from OtProcedureNotesEntryDetail where OtProcedureHeader.Id="
								+ otProcedureNotesEntryHeader.getId());
				int row = deleteQuery.executeUpdate();
				if (row == 0) {
					//System.out.println("Doesn't deleted any row!");
				} else {
					//System.out.println("Deleted	Row: " + row);
				}
				for (int i = 0; i < employeeId.size(); i++) {
					OtProcedureNotesEntryDetail otProcedureNotesEntryDetail = new OtProcedureNotesEntryDetail();

					otProcedureNotesEntryDetail
							.setOtProcedureHeader(otProcedureNotesEntryHeader);

					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(employeeId.get(i));
					otProcedureNotesEntryDetail.setEmployee(masEmployee);

					hbt.save(otProcedureNotesEntryDetail);
					hbt.update(otProcedureNotesEntryDetail);
				}

				dataSaved = true;
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		map.put("dataSaved", dataSaved);
		map.put("yearlySrNo", yearlySrNo);

		return map;
	}

	@SuppressWarnings("unchecked")
	public List<String> getOtProcHinNoList(String serviceNo) {
		Session session = (Session) getSession();
		List<String> hinList = new ArrayList<String>();

		try {

			hinList = session.createCriteria(OtProcedureNotesEntryHeader.class)
					.createAlias("Hin", "p").setProjection(
							Projections.distinct(Projections.projectionList()
									.add(Projections.property("p.HinNo"))))
					.add(Restrictions.eq("p.ServiceNo", serviceNo)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return hinList;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getYearlySerialNoList(Map<String, Object> detailsMap) {
		@SuppressWarnings("unchecked")
		Session session = (Session) getSession();
		String serviceNo = "";
		String hinNo = "";
		if (detailsMap.get("serviceNo") != null) {
			serviceNo = (String) detailsMap.get("serviceNo");
		}
		if (detailsMap.get("hinNo") != null) {
			hinNo = (String) detailsMap.get("hinNo");
		}

		List<Object> yearlySerialNoList = new ArrayList<Object>();

		try {
			if (!serviceNo.equals("")) {
				Criteria crit = session.createCriteria(
						OtProcedureNotesEntryHeader.class).createAlias("Hin",
						"p").add(Restrictions.eq("p.ServiceNo", serviceNo));
				yearlySerialNoList = crit.list();
				// vistList =
				// getHibernateTemplate().find("from Visit v join v.Hin as p where p.ServiceNo = '"+serviceNo+"'");
			}
			if (!hinNo.equals("")) {
				Criteria crit = session.createCriteria(
						OtProcedureNotesEntryHeader.class).createAlias("Hin",
						"p").add(Restrictions.eq("p.HinNo", hinNo));
				yearlySerialNoList = crit.list();
				// vistList =
				// getHibernateTemplate().find("from Visit v join v.Hin as p where p.HinNo = '"+hinNo+"'");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return yearlySerialNoList;

	}

	public List<Object> getOtProcPatientDetailList(
			Map<String, Object> detailsMap) {
		@SuppressWarnings("unchecked")
		Session session = (Session) getSession();
		String serviceNo = "";
		String hinNo = "";
		String yearlySerialNo = "";
		if (detailsMap.get("serviceNo") != null) {
			serviceNo = (String) detailsMap.get("serviceNo");
		}
		if (detailsMap.get("hinNo") != null) {
			hinNo = (String) detailsMap.get("hinNo");
		}
		if (detailsMap.get("yearlySerialNo") != null) {
			yearlySerialNo = (String) detailsMap.get("yearlySerialNo");
		}
		List<Object> patientDetailList = new ArrayList<Object>();
		try {
			if (!serviceNo.equals("")) {
				Criteria crit = session.createCriteria(
						OtProcedureNotesEntryHeader.class).createAlias("Hin",
						"p").add(Restrictions.eq("p.ServiceNo", serviceNo));
				patientDetailList = crit.list();
				// vistList =
				// getHibernateTemplate().find("from Visit v join v.Hin as p where p.ServiceNo = '"+serviceNo+"'");
			}
			if (!hinNo.equals("")) {
				Criteria crit = session.createCriteria(
						OtProcedureNotesEntryHeader.class).createAlias("Hin",
						"p").add(Restrictions.eq("p.HinNo", hinNo));
				patientDetailList = crit.list();
				// vistList =
				// getHibernateTemplate().find("from Visit v join v.Hin as p where p.HinNo = '"+hinNo+"'");
			}
			if (!yearlySerialNo.equals("")) {
				Criteria crit = session.createCriteria(
						OtProcedureNotesEntryHeader.class).add(
						Restrictions.eq("YearlySerialNo", yearlySerialNo));
				patientDetailList = crit.list();
				// vistList =
				// getHibernateTemplate().find("from Visit v join v.Hin as p where p.HinNo = '"+hinNo+"'");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return patientDetailList;

	}

	public List<String> getPreAnaesthesiaHinNoList(String serviceNo) {
		Session session = (Session) getSession();
		List<String> hinList = new ArrayList<String>();

		try {

			hinList = session.createCriteria(
					OtPreAnaesthesiaProcNotesMain.class)
					.createAlias("Hin", "p").setProjection(
							Projections.distinct(Projections.projectionList()
									.add(Projections.property("p.HinNo"))))
					.add(Restrictions.eq("p.ServiceNo", serviceNo)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return hinList;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getPreAnaesthesiaYearlySerialNoList(
			Map<String, Object> detailsMap) {
		@SuppressWarnings("unchecked")
		Session session = (Session) getSession();
		String serviceNo = "";
		String hinNo = "";
		if (detailsMap.get("serviceNo") != null) {
			serviceNo = (String) detailsMap.get("serviceNo");
		}
		if (detailsMap.get("hinNo") != null) {
			hinNo = (String) detailsMap.get("hinNo");
		}

		List<Object> yearlySerialNoList = new ArrayList<Object>();

		try {
			if (!serviceNo.equals("")) {
				Criteria crit = session.createCriteria(
						OtPreAnaesthesiaProcNotesMain.class).createAlias("Hin",
						"p").add(Restrictions.eq("p.ServiceNo", serviceNo));
				yearlySerialNoList = crit.list();
				// vistList =
				// getHibernateTemplate().find("from Visit v join v.Hin as p where p.ServiceNo = '"+serviceNo+"'");
			}
			if (!hinNo.equals("")) {
				Criteria crit = session.createCriteria(
						OtPreAnaesthesiaProcNotesMain.class).createAlias("Hin",
						"p").add(Restrictions.eq("p.HinNo", hinNo));
				yearlySerialNoList = crit.list();
				// vistList =
				// getHibernateTemplate().find("from Visit v join v.Hin as p where p.HinNo = '"+hinNo+"'");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return yearlySerialNoList;

	}

	public List<Object> getPreAnaesthseiaPatientDetailList(
			Map<String, Object> detailsMap) {
		@SuppressWarnings("unchecked")
		Session session = (Session) getSession();
		String serviceNo = "";
		String hinNo = "";
		String yearlySerialNo = "";
		if (detailsMap.get("serviceNo") != null) {
			serviceNo = (String) detailsMap.get("serviceNo");
		}
		if (detailsMap.get("hinNo") != null) {
			hinNo = (String) detailsMap.get("hinNo");
		}
		if (detailsMap.get("yearlySerialNo") != null) {
			yearlySerialNo = (String) detailsMap.get("yearlySerialNo");
		}
		List<Object> patientDetailList = new ArrayList<Object>();
		try {
			if (!serviceNo.equals("")) {
				Criteria crit = session.createCriteria(
						OtPreAnaesthesiaProcNotesMain.class).createAlias("Hin",
						"p").add(Restrictions.eq("p.ServiceNo", serviceNo));
				patientDetailList = crit.list();
				// vistList =
				// getHibernateTemplate().find("from Visit v join v.Hin as p where p.ServiceNo = '"+serviceNo+"'");
			}
			if (!hinNo.equals("")) {
				Criteria crit = session.createCriteria(
						OtPreAnaesthesiaProcNotesMain.class).createAlias("Hin",
						"p").add(Restrictions.eq("p.HinNo", hinNo));
				patientDetailList = crit.list();
				// vistList =
				// getHibernateTemplate().find("from Visit v join v.Hin as p where p.HinNo = '"+hinNo+"'");
			}
			if (!yearlySerialNo.equals("")) {
				Criteria crit = session.createCriteria(
						OtPreAnaesthesiaProcNotesMain.class).add(
						Restrictions.eq("YearlySerialNo", yearlySerialNo));
				patientDetailList = crit.list();
				// vistList =
				// getHibernateTemplate().find("from Visit v join v.Hin as p where p.HinNo = '"+hinNo+"'");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return patientDetailList;

	}

	// ------------------ BY MANSI ----------------
	public Map<String, Object> searchSpecimenPatientDetails(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();

		String serviceNo = "";
		String hinNo = "";

		String patientFName = "";
		String patientMName = "";
		String patientLName = "";

		Session session = (Session) getSession();

		if (mapForDS.get("serviceNo") != null) {
			serviceNo = (String) mapForDS.get("serviceNo");
		}
		if (mapForDS.get("hinNo") != null) {

			hinNo = (String) mapForDS.get("hinNo");
		}

		if (mapForDS.get("patientFName") != null) {
			patientFName = (String) mapForDS.get("patientFName");
		}
		if (mapForDS.get("patientMName") != null) {
			patientMName = (String) mapForDS.get("patientMName");
		}
		if (mapForDS.get("patientLName") != null) {
			patientLName = (String) mapForDS.get("patientLName");
		}

		String patientStatus = "Out Patient";
		Criteria crit = session.createCriteria(Patient.class)
				.add(
						Restrictions.not(Expression.eq("PatientStatus",
								patientStatus)));
		if (hinNo != null) {
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.eq("ServiceNo", serviceNo));
			}

			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("PFirstName", patientFName
						+ "%"));
			}
			if (!patientMName.equals("")) {
				crit = crit.add(Restrictions.like("PMiddleName", patientMName
						+ "%"));
			}
			if (!patientLName.equals("")) {
				crit = crit.add(Restrictions.like("PLastName", patientLName
						+ "%"));
			}
		} else {
			crit = crit.add(Restrictions.eq("HinNo", hinNo));
		}
		patientList = crit.list();
		map.put("patientList", patientList);
		return map;

	}

	public Map<String, Object> showSpecimenJspForHin(
			Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		List<Patient> patientDetailList = new ArrayList<Patient>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();

		Map<String, Object> map = new HashMap<String, Object>();
		String transactionSequenceName = "Surgery Requisition No";
		String departmentType = "Surgical";
		String hinNo = (String) mapForDS.get("hinNo");
		int entryNo = 0;
		try {

			Criteria crit = session.createCriteria(Patient.class).add(
					Restrictions.eq("HinNo", hinNo));
			patientDetailList = crit.list();
			departmentList = session.createCriteria(MasDepartment.class)
					.createAlias("DepartmentType", "deptType").add(
							Restrictions.eq("deptType.DepartmentTypeName",
									departmentType)).add(
							Restrictions.eq("Status", "y")).list();
			sequenceNoList = session.createCriteria(TransactionSequence.class)
					.add(
							Restrictions.eq("TransactionSequenceName",
									transactionSequenceName)).list();
			TransactionSequence transactionSequence = sequenceNoList.get(0);
			int sequenceNo = transactionSequence.getTransactionSequenceNumber();
			entryNo = sequenceNo + 1;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		map.put("departmentList", departmentList);
		map.put("entryNo", entryNo);

		return map;

	}

	/**
	 * ------------------------- OT Post Anaesthesia Patient Details By
	 * Mansi------------------------------
	 */

	public Map<String, Object> searchPostAnaesthesiaPatientDetails(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OtBooking> patientList = new ArrayList<OtBooking>();
		List<MasOt> masOtList = new ArrayList<MasOt>();
		
		Session session = (Session) getSession();

		   String empId = "";
		   int otId = 0;
	        String pName="";
	        Date surgeryDate =null;
		
			int hospitalId = 0;
			if (mapForDS.get(HOSPITAL_ID) != null) {
				hospitalId = (Integer)mapForDS.get(HOSPITAL_ID);
			}
	        
			if(mapForDS.get(PATIENT_NAME)!=null)
			{
				pName = (String)mapForDS.get(PATIENT_NAME);
			}
					
			if(mapForDS.get(EMPLOYEE_ID)!=null)
			{
				empId = (String)mapForDS.get(EMPLOYEE_ID);
			}

			if(mapForDS.get(OT_ID)!=null)
			{
				otId = (Integer)mapForDS.get(OT_ID);
			}
	        
			if(mapForDS.get(SURGERY_DATE)!=null)
			{
				surgeryDate = HMSUtil
						.convertStringTypeDateToDateType(mapForDS.get(SURGERY_DATE).toString());
				
			}
	
		Criteria crit =null;
		List<String>aList=new ArrayList<String>();
		aList.add("A");
		aList.add("R");
		aList.add("O");
		crit=
				session.createCriteria(OtBooking.class)
				.createAlias("Hospital", "h")
				.createAlias("Hin", "hin")
				.createAlias("Inpatient", "ip",CriteriaSpecification.LEFT_JOIN)
				.add(Restrictions.eq("h.Id", hospitalId)).add(Restrictions.or(Restrictions.isNotNull("Visit"), Restrictions.in("ip.AdStatus", aList)))
//				.add(Restrictions.in("ip.AdStatus", aList))
				//.createAlias("OpdSurseryHeader", "osh")
				//.add(Restrictions.eq("OtBookingStatus", "y").ignoreCase())
				.add(Restrictions.eq("OtPreAnesthesiaStatus", "y").ignoreCase())
				.add(Restrictions.eq("OtPostAnethesiaStatus", "n").ignoreCase())
				.add(Restrictions.eq("SurgeryStatus", "y").ignoreCase())
				//.add(Restrictions.eq("osh.PacStatus", "Cleared").ignoreCase());
	;
			/*	if(otProcedure.equalsIgnoreCase("yes"))
				{
					crit.add( Restrictions.eq("SurgeryStatus", "y").ignoreCase());
					crit.add(Restrictions.eq("OtPostAnethesiaStatus", "y").ignoreCase());
					crit.add(Restrictions.or(Restrictions.isNull("OtNoteProcedureStatus"), Restrictions.eq("OtNoteProcedureStatus", "n").ignoreCase()));

				}
				else if(otProcedure.equalsIgnoreCase("no"))
				{
					crit.add(Restrictions.or(Restrictions.isNull("SurgeryStatus"), Restrictions.eq("SurgeryStatus", "n").ignoreCase()));

				}*/
				//crit.setProjection(Projections.projectionList().add(Projections.property("OpdSurseryHeader")));
		

		if(!pName.equals(""))
		{
			crit.add(Restrictions.like("hin.PFirstName", pName.toLowerCase()+"%").ignoreCase());
		}
		
		
		if(empId!="")
		{
			crit.add(Restrictions.eq("hin.ServiceNo", empId));
		}
		
		
		if(otId!=0)
		{
			crit.createAlias("Ot", "ot")
			.add(Restrictions.eq("ot.Id",otId));
		}

		if(surgeryDate!=null)
		{
			crit.add(Restrictions.eq("SurgeryDate", surgeryDate));
		}
		patientList = crit.list();
		


		masOtList = session.createCriteria(MasOt.class).add(
						Restrictions.eq("Status", "y")).list();
		
		map.put("recordList", patientList);
		map.put("masOtList", masOtList);
		return map;

	}

	public Map<String, Object> showPostAnaesthesiaJspForHin(
			Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		List<OtBooking> patientDetailList = new ArrayList<OtBooking>();
		List<MasAnesthesia> anesthesiaList = new ArrayList<MasAnesthesia>();
		List<OtPostAnaesthesiaProcedure> otPostAnaesthesiaProcedureList = new ArrayList<OtPostAnaesthesiaProcedure>();
		List<OtPreAnesthesiaHd> otPreAnaesthesiaDetailsList = new ArrayList<OtPreAnesthesiaHd>();
		/*
		 * List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		 * List<TransactionSequence> sequenceNoList = new
		 * ArrayList<TransactionSequence>();
		 */
		Integer otPostId = 0;
		List<OtSurgeyPaEmployeeDetail> surgeyPaEmployeeDetailList = new ArrayList<OtSurgeyPaEmployeeDetail>();
		List<OtSurgeyPaSurgeyDetail> surgeyPaSurgeyDetailList = new ArrayList<OtSurgeyPaSurgeyDetail>();
		List<OtSurgeyPaAnesthesiologistDetail> surgeyPaAnesthesiologistDetailList = new ArrayList<OtSurgeyPaAnesthesiologistDetail>();
		List<OtSurgeyPaIvFluidsDetail> surgeyPaIvFluidsDetailList = new ArrayList<OtSurgeyPaIvFluidsDetail>();
		List<OtSurgeyPaPremedicationDetail> surgeyPaPremedicationDetailList = new ArrayList<OtSurgeyPaPremedicationDetail>();
		List<OtSurgeyPaProcedureDetail> surgeyPaProcedureDetailList = new ArrayList<OtSurgeyPaProcedureDetail>();

		Map<String, Object> map = new HashMap<String, Object>();
		/* String transactionSequenceName="Surgery Requisition No"; */
		/* String departmentType="Surgical"; */
		Integer otBookingId = Integer.parseInt((String) mapForDS
				.get("otBookingId"));
		/* int yearlySrNo=0; */
		try {

			Criteria crit = session.createCriteria(OtBooking.class)
			/*
			 * .createAlias("Hin", "hin") .add(Restrictions.eq("hin.HinNo",
			 * hinNo))
			 */
			.add(Restrictions.eq("Id", otBookingId)).add(
					Restrictions.eq("PostOpNotesAnaesthesiaStatus", "n"));
			patientDetailList = crit.list();

			anesthesiaList = session.createCriteria(MasAnesthesia.class).add(
					Restrictions.eq("Status", "y")).list();

			if (patientDetailList.size() == 0) {
				crit = session.createCriteria(OtPostAnaesthesiaProcedure.class)
				/*
				 * .createAlias("Hin", "hin") .add(Restrictions.eq("hin.HinNo",
				 * hinNo));
				 */
				.add(Restrictions.eq("OtBooking.Id", otBookingId));
				otPostAnaesthesiaProcedureList = crit.list();

				otPostId = otPostAnaesthesiaProcedureList.get(0).getId();

				if (otPostId != 0) {
					surgeyPaEmployeeDetailList = session.createCriteria(
							OtSurgeyPaEmployeeDetail.class).createAlias(
							"OtPostAnaesthesiaProcedure", "otPost").add(
							Restrictions.eq("otPost.Id", otPostId)).list();
					surgeyPaSurgeyDetailList = session.createCriteria(
							OtSurgeyPaSurgeyDetail.class).createAlias(
							"OtPostAnaesthesiaProcedure", "otPost").add(
							Restrictions.eq("otPost.Id", otPostId)).list();
					surgeyPaAnesthesiologistDetailList = session
							.createCriteria(
									OtSurgeyPaAnesthesiologistDetail.class)
							.createAlias("OtPostAnaesthesiaProcedure", "otPost")
							.add(Restrictions.eq("otPost.Id", otPostId)).list();
					surgeyPaIvFluidsDetailList = session.createCriteria(
							OtSurgeyPaIvFluidsDetail.class).createAlias(
							"OtPostAnaesthesiaProcedure", "otPost").add(
							Restrictions.eq("otPost.Id", otPostId)).list();
					surgeyPaPremedicationDetailList = session.createCriteria(
							OtSurgeyPaPremedicationDetail.class).createAlias(
							"OtPostAnaesthesiaProcedure", "otPost").add(
							Restrictions.eq("otPost.Id", otPostId)).list();
					surgeyPaProcedureDetailList = session.createCriteria(
							OtSurgeyPaProcedureDetail.class).createAlias(
							"OtPostAnaesthesiaProcedure", "otPost").add(
							Restrictions.eq("otPost.Id", otPostId)).list();
					anesthesiaList = session
							.createCriteria(MasAnesthesia.class).add(
									Restrictions.eq("Status", "y")).list();

					map.put("surgeyPaEmployeeDetailList",
							surgeyPaEmployeeDetailList);
					map.put("surgeyPaSurgeyDetailList",
							surgeyPaSurgeyDetailList);
					map.put("surgeyPaAnesthesiologistDetailList",
							surgeyPaAnesthesiologistDetailList);
					map.put("surgeyPaIvFluidsDetailList",
							surgeyPaIvFluidsDetailList);
					map.put("surgeyPaPremedicationDetailList",
							surgeyPaPremedicationDetailList);
					map.put("surgeyPaProcedureDetailList",
							surgeyPaProcedureDetailList);
					map.put("anesthesiaList", anesthesiaList);

				}
			}

			/*
			 * crit = session.createCriteria(OtPostAnaesthesiaProcedure.class)
			 * .createAlias("Hin", "hin") .add(Restrictions.eq("hin.HinNo",
			 * hinNo)); otPostAnaesthesiaProcedureList =crit.list();
			 */

			/*
			 * sequenceNoList=session.createCriteria(TransactionSequence.class).add
			 * (Restrictions.eq("TransactionSequenceName",
			 * transactionSequenceName)).list(); TransactionSequence
			 * transactionSequence=sequenceNoList.get(0); int
			 * sequenceNo=transactionSequence.getTransactionSequenceNumber();
			 * yearlySrNo=sequenceNo+1;
			 */
			if (otPostAnaesthesiaProcedureList.size() > 0) {
				map.put("otPostAnaesthesiaProcedureList",
						otPostAnaesthesiaProcedureList);
			}

			/*
			 * crit = session.createCriteria(OtPreAnesthesiaDetails.class)
			 * .createAlias("Hin", "hin") .add(Restrictions.eq("hin.HinNo",
			 * hinNo)) .addOrder(Order.desc("Id"));
			 * 
			 * otPreAnaesthesiaDetailsList = crit.list();
			 */
			map.put("otPreAnaesthesiaDetailsList", otPreAnaesthesiaDetailsList);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		map.put("anesthesiaList", anesthesiaList);
		/* map.put("yearlySrNo", yearlySrNo); */

		return map;

	}

	public String getYearlySeqForDisplay() {
		Map<String, Object> map = new HashMap<String, Object>();
		String yearlySrNo = "";
		List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
		List<OtPostAnaesthesiaProcedure> seqNoList = new ArrayList<OtPostAnaesthesiaProcedure>();
		String lastSeqNo = "";
		String stNo = "";
		String lastSeqYear = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(OtPostAnaesthesiaProcedure.class)
				.list();
		if (seqNoList.size() > 0) {
			for (OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure : seqNoList) {
				lastSeqNo = otPostAnaesthesiaProcedure.getYearlySlNo();
				//System.out.println("lastSeqNo----" + lastSeqNo);
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				stNo = str.nextToken();
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		orderSeqNoList = session.createCriteria(TransactionSequence.class).add(
				Restrictions.eq("TransactionPrefix", "YNO")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (orderSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : orderSeqNoList) {
				TransactionSequence obj = (TransactionSequence) orderSeqNoList
						.get(0);
				int id = obj.getId();
				Integer seqNo = 0;

				if (currentYear.equals(lastSeqYear)) {
					seqNo = obj.getTransactionSequenceNumber();
				} else {
					seqNo = 0;
				}
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(seqNo + 1);
				++seqNo;
				hbt.update(transactionSequenceObj);
				hbt.refresh(transactionSequenceObj);
				yearlySrNo = seqNo.toString().concat("/").concat(
						String.valueOf(lastSeqYear));
				//System.out.println("yearlySrNo----" + yearlySrNo);
			}
		} else if (orderSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("OtPostAnaesthesiaProcedure");
			tsObj.setTransactionPrefix("YNO");
			tsObj.setTransactionSequenceName("Year No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			yearlySrNo = yearlySrNo.concat("/").concat(
					String.valueOf(lastSeqYear));

		}

		return yearlySrNo;
	}

	public String getMonthlySeqForDisplay() {

		Map<String, Object> map = new HashMap<String, Object>();
		String monthlySrNo = "";
		List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
		List<OtPostAnaesthesiaProcedure> seqNoList = new ArrayList<OtPostAnaesthesiaProcedure>();
		String lastSeqNo = "";
		String stNo = "";
		String lastSeqYear = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentMonth = date.substring(date.indexOf("/") + 1, date
				.lastIndexOf("/"));
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(OtPostAnaesthesiaProcedure.class)
				.list();
		if (seqNoList.size() > 0) {
			for (OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure : seqNoList) {
				lastSeqNo = otPostAnaesthesiaProcedure.getMonthlySlNo();
				//System.out.println("lastSeqNo----" + lastSeqNo);
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				stNo = str.nextToken();
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentMonth;
		}
		orderSeqNoList = session.createCriteria(TransactionSequence.class).add(
				Restrictions.eq("TransactionPrefix", "MNO")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (orderSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : orderSeqNoList) {
				TransactionSequence obj = (TransactionSequence) orderSeqNoList
						.get(0);
				int id = obj.getId();
				Integer seqNo = 0;

				if (currentMonth.equals(lastSeqYear)) {
					seqNo = obj.getTransactionSequenceNumber();
				} else {
					seqNo = 0;
				}
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(seqNo + 1);
				++seqNo;
				hbt.update(transactionSequenceObj);
				hbt.refresh(transactionSequenceObj);
				monthlySrNo = seqNo.toString().concat("/").concat(
						String.valueOf(lastSeqYear));

			}
		} else if (orderSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("OtPostAnaesthesiaProcedure");
			tsObj.setTransactionPrefix("MNO");
			tsObj.setTransactionSequenceName("Month No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			monthlySrNo = monthlySrNo.concat("/").concat(
					String.valueOf(lastSeqYear));

		}

		return monthlySrNo;

	}

	public Map<String, Object> showPACDetailJsp(int orderNo, int hinId,
			int visitId) {
		Session session = (Session) getSession();
		List<OtPreAnesthesiaHd> otPreAnesthesiaDetailsList = new ArrayList<OtPreAnesthesiaHd>();
		List<OpdPatientHistory> opdPatientHistoryList = new ArrayList<OpdPatientHistory>();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			otPreAnesthesiaDetailsList = session.createCriteria(
					OtPreAnesthesiaHd.class).add(
					Restrictions.eq("OrderNo", orderNo)).list();
			opdPatientHistoryList = session.createCriteria(
					OpdPatientHistory.class).createAlias("Hin", "p").add(
					Restrictions.eq("p.Id", hinId)).add(
					Restrictions.eq("VisitInpatientId", visitId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("opdPatientHistoryList", opdPatientHistoryList);
		map.put("otPreAnesthesiaDetailsList", otPreAnesthesiaDetailsList);
		return map;
	}

	public Map<String, Object> getChargeCodeValue(String chargeCodeName) {
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			chargeCodeList = session.createCriteria(MasChargeCode.class).add(
					Restrictions.eq("ChargeCodeName", chargeCodeName)).list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("chargeCodeList", chargeCodeList);
		return map;
	}

	public Map<String, Object> getSurgeyForAutoComplete(
			Map<String, Object> mapForDS) {
		List<MasChargeCode> chargeList = new ArrayList<MasChargeCode>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {

			String str = "%" + mapForDS.get("autoHint") + "%";

			List<String> chargeTypeList = new ArrayList<String>();
			chargeTypeList.add("Surg");
			chargeTypeList.add("Surg2");

			Criteria crit = session.createCriteria(MasChargeCode.class)
					.createAlias("ChargeType", "charge").add(
							Restrictions.in("charge.ChargeTypeCode",
									chargeTypeList)).add(
							Restrictions.like("ChargeCodeName", str));

			crit.setFirstResult(0);
			crit.setMaxResults(10);
			chargeList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("chargeList", chargeList);
		return map;
	}

	public Map<String, Object> getEmpValue(String empName) {
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			empList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("FirstName", empName)).add(
					Restrictions.eq("Status", "y")).list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("empList", empList);
		return map;
	}

	public Map<String, Object> getEmpValueForPostAnesthesia(
			Map<String, Object> mapForDs) {
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		Map<String, Object> map = new HashMap<String, Object>();
		Integer empId = 0;
		String empName = "";

		if (mapForDs.get("empId") != null) {
			empId = (Integer) mapForDs.get("empId");
		}
		if (mapForDs.get("empName") != null) {
			empName = (String) mapForDs.get("empName");
		}

		Session session = (Session) getSession();
		try {
			empList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Id", empId)).add(
					Restrictions.eq("Status", "y")).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("empList", empList);
		return map;
	}

	public Map<String, Object> getSurgeonForAutoComplete(
			Map<String, Object> mapForDS) {
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {

			String str = "%" + mapForDS.get("autoHint") + "%";

			String empCategory = "01";
			Criteria crit = session.createCriteria(MasEmployee.class)
					.createAlias("EmpCategory", "ec").add(
							Restrictions.eq("ec.EmpCategoryCode", empCategory))
					.add(Restrictions.like("FirstName", str)).add(
							Restrictions.eq("Status", "y"));

			crit.setFirstResult(0);
			crit.setMaxResults(10);
			empList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("empList", empList);
		return map;
	}

	public Map<String, Object> getItemForAutoComplete(
			Map<String, Object> mapForDS) {
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {

			String str = "%" + mapForDS.get("autoHint") + "%";

			Criteria crit = session.createCriteria(MasStoreItem.class).add(
					Restrictions.like("Nomenclature", str));

			crit.setFirstResult(0);
			crit.setMaxResults(10);
			itemList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}

	public Map<String, Object> getItemValue(String nomenclature) {
		List<MasStoreItem> storeItemList = new ArrayList<MasStoreItem>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			storeItemList = session.createCriteria(MasStoreItem.class).add(
					Restrictions.eq("Nomenclature", nomenclature)).add(
					Restrictions.eq("Status", "y")).list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("storeItemList", storeItemList);
		//System.out.println("storeItemList-->" + storeItemList.size());
		return map;
	}

	public Map<String, Object> submitOtPostAnesthesiaProcedure(
			Map<String, Object> mapForDS, Box box) {
		
		

		Session session = (Session) getSession();
			Map<String, Object> map = new HashMap<String, Object>();
			//Map<String, Object> mapForDS = new HashMap<String, Object>();
			// ------- variables declaration-------
			boolean dataSaved = false;
			//Vector dose = box.getVector("dose");
			//Vector route = box.getVector("route");
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");
			Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
			String userName = "";
			if (mapForDS.get("userName") != null) {
				userName = (String) mapForDS.get("userName");
			}
			
			//Box box = (Box) mapForDS.get("box");
			int visitId = 0;
			int inpatientId = 0;
			
			if (box.get("visitId") != null) {
				 visitId = box.getInt("visitId");
			}
			if (box.get("inpatientId") != null) {
				inpatientId = box.getInt("inpatientId");
			}
			
			
			int opdSurgeryHeaderId = box.getInt("opdSurgeryHeaderId");
			
			int hinId = box.getInt("hinId");
			int orderNo = box.getInt("orderNo");
			int bookingId = box.getInt("bookingId");
			int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);

			String overall_assessment = box.getString("overall_assessment");
			String airway = box.getString("airway");
			String gcs = box.getString("gcs");
			String drowsy = box.getString("drowsy");
			String awake = box.getString("awake");
			String circulation = box.getString("circulation");
			String hr = box.getString("hr");
			String bp = box.getString("bp");
			String cvs = box.getString("cvs");
			String rs = box.getString("rs");
			String spo = box.getString("spo");
			String special_observation = box.getString("special_observation");
			String remarks  = box.getString("remarks");
			String patientStatus  = box.getString("patientStatus");
			
			//String yearlySrNo = box.getString("yearlySqNo");
			//String monthlySrNo = box.getString("monthlySqNo");
			
			List<Integer> itemIdList = (List<Integer>) mapForDS.get("itemIdList");
			List<Integer> frequencyList = (List) mapForDS.get("frequencyList");
			List<String> otherMedicineList = (List) mapForDS.get("otherMedicineList");
			List<String> nomenclatureList =  (List) mapForDS.get("nomenclatureList");
			List<Integer> itemConversionList = (List) mapForDS.get("itemConversionList");
			List<String> ctList = (List) mapForDS.get("ctList");
			List<Integer> itemClassList = (List) mapForDS.get("itemClassList");
			List<String> itemDispensaryList = (List) mapForDS.get("itemDispensaryList");
			List<String> dosageList = (List) mapForDS.get("dosageList");
			
			List<String> routeList = new ArrayList<String>();
			routeList= (List) mapForDS.get("routeList");
			List<Integer> totalList = (List) mapForDS.get("totalList");
			List<Integer> noOfDaysList = (List) mapForDS.get("noOfDaysList");
			List<String> remarksList = (List) mapForDS.get("remarksList");
			
			String consultationTime = (String) box.get("currentTime");
			String consultationDate = (String) box.get("currentDate");
			Date consultationDateToInsert = HMSUtil
					.convertStringTypeDateToDateType(consultationDate);
			int departmentId = (Integer) mapForDS.get("deptId");
			int empId = 0;
			empId = (Integer) mapForDS.get("empId");
			int userId = (Integer) mapForDS.get(USER_ID);
			Users user = new Users();
			user.setId(userId);
			
			
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			

			MasEmployee employee = new MasEmployee();
			employee.setId(empId);
			

			Patient patient = new Patient();
			patient.setId(hinId);
			
			// ------ business logic-------
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Transaction tx = null;
			int postAnaesthesiaProcedureId = 0;

			try {
			
				tx = session.beginTransaction();
				OtPostAnaesthesiaProcedure postAnaesthesiaProcedure = new OtPostAnaesthesiaProcedure();
				
//saving enterable fields
				
				postAnaesthesiaProcedure.setOverallAssessment(overall_assessment.trim());
				postAnaesthesiaProcedure.setAirway(airway);
				postAnaesthesiaProcedure.setGcs(gcs);
				postAnaesthesiaProcedure.setDrowsy(drowsy);
				postAnaesthesiaProcedure.setAwake(awake);
				postAnaesthesiaProcedure.setCirculation(circulation);
				postAnaesthesiaProcedure.setHr(hr);
				postAnaesthesiaProcedure.setBp(bp);
				postAnaesthesiaProcedure.setCvs(cvs);
				postAnaesthesiaProcedure.setRs(rs);
				postAnaesthesiaProcedure.setSp02(spo);
				postAnaesthesiaProcedure.setSpecialObservation(special_observation);
				postAnaesthesiaProcedure.setRemarks(remarks);
				
				
			/*	opdPatientDetails.setYearlySerialNo(yearlySrNo);
				opdPatientDetails.setMonthlySerialNo(monthlySrNo);*/
				//postAnaesthesiaProcedure.setOrderNo(orderNo);
	
				postAnaesthesiaProcedure.setHin(patient);
		
				if (hospitalId != 0) {
					postAnaesthesiaProcedure.setHospital(masHospital);
				}

				postAnaesthesiaProcedure.setLastChgBy(user);
				postAnaesthesiaProcedure.setLastChgDate(date);
				postAnaesthesiaProcedure.setLastChgTime(time);

				
				if (patientStatus.equalsIgnoreCase("In Patient")) {
					Inpatient inpatient = new Inpatient();
					inpatient.setId(inpatientId);
					postAnaesthesiaProcedure.setInpatient(inpatient);
				}

				if (patientStatus.equalsIgnoreCase("Out Patient") || patientStatus.equalsIgnoreCase("OP")) {
				
					Visit visit = new Visit();
					visit.setId(visitId);
					postAnaesthesiaProcedure.setVisit(visit);
				}
				
				OtBooking booking = new OtBooking();
				booking.setId(bookingId);
				postAnaesthesiaProcedure.setOtBooking(booking);
				
				hbt.save(postAnaesthesiaProcedure);
				
				postAnaesthesiaProcedureId = postAnaesthesiaProcedure.getId();
				
				//save pre instruction
				//PreOpInstructionList
				
				List<OtPostOpInstruction> opInstructionList = new ArrayList<OtPostOpInstruction>();
				List<String> PreOpInstructionList = (List) mapForDS.get("PreOpInstructionList");
				
				if(PreOpInstructionList.size()!=0)
				{
				for(String ins :PreOpInstructionList)
				{
					if(!ins.isEmpty()){
					      OtPostOpInstruction opInstruction = new OtPostOpInstruction();
						opInstruction.setOtPostAnaesthesiaProcedure(postAnaesthesiaProcedure);
						
						opInstruction.setPreOpInstruction(ins);
						opInstructionList.add(opInstruction);
					}
				}
				
				hbt.saveOrUpdateAll(opInstructionList);
				}
			
				
		/*int opHiddenValue = box.getInt("opHiddenValue");
			
				
				if(opHiddenValue>0)
				{
					List<OtPostOpInstruction> opInstructionList = new ArrayList<OtPostOpInstruction>();
					
					for(int i=1; i<= opHiddenValue;i++)
					{
						if(box.getString("opInstruction" +i)!=null && !box.getString("opInstruction" +i).isEmpty())
						{
							OtPostOpInstruction opInstruction = new OtPostOpInstruction();
							opInstruction.setOtPostAnaesthesiaProcedure(postAnaesthesiaProcedure);
							opInstruction.setPreOpInstruction(box.getString("opInstruction" +i));
							opInstructionList.add(opInstruction);
						}
					}
					
					hbt.saveOrUpdateAll(opInstructionList);
				}*/
					
				//save prescription
				
				String postAnesthesiaCode = HMSUtil.getProperties("adt.properties", "CodeForPostAnesthesia");
				Visit visit = null;
				   Inpatient inpatient = null;
					if(visitId!=0)
							{
						visit = new Visit();
						visit.setId(visitId);
							}
							if(inpatientId!=0)
							{
								inpatient = new Inpatient();
								inpatient.setId(inpatientId);
							}
		if (itemIdList.size() > 0 || otherMedicineList.size() >0) {	
				PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();;
				int item_class_id = 0;
				patientPrescriptionHeader.setNipStatus("n");
					
						patientPrescriptionHeader.setInpatient(inpatient);
					patient.setId(hinId);
					patientPrescriptionHeader.setHin(patient);
					masDepartment.setId(departmentId);
					patientPrescriptionHeader.setDepartment(masDepartment);
					masHospital.setId(hospitalId);
					patientPrescriptionHeader.setHospital(masHospital);
					patientPrescriptionHeader.setStatus("p");
					patientPrescriptionHeader
							.setPrescriptionDate(consultationDateToInsert);
					patientPrescriptionHeader.setPrescriptionTime(consultationTime);

					employee.setId(empId);
					patientPrescriptionHeader.setEmp(employee);
			
					Map<String, Object> adMap = new HashMap<String, Object>();
				      adMap.put("tableObjectName", "PATIENT_PRESCRIPTION_HEADER");            
			            adMap.put("isHospitalWise", "y");
			            adMap.put("hospitalId", 1);
			            adMap.put("isYearly", "n");            
			            adMap.put("isMonthly", "n");
			            adMap.put("isPrefix", "n");
			    
				
				        int prescriptionNo = Integer.parseInt(HMSUtil.generateTransactionSequence(adMap, session, hbt));
					patientPrescriptionHeader.setPrescriptionNo(prescriptionNo);

					String sqlItemId="";

					for (int i = 0; i < itemIdList.size(); i++) {
		
						int itemId = (Integer)itemIdList.get(i);;
						if(i==0){
							sqlItemId=""+itemId;
						}else{
							sqlItemId +=" , "+itemId;
						}

					}
					List<MasStoreItem> masItemList=new ArrayList<MasStoreItem>();
					Properties properties = new Properties();
					URL resourcePath = Thread.currentThread().getContextClassLoader()
							.getResource("adt.properties");
					
					try {
						properties.load(resourcePath.openStream());
						String item_class_code = properties.getProperty("item_class_id");
						item_class_id=Integer.parseInt(item_class_code);
					} catch (Exception e) {
						e.printStackTrace();
					}
					if(!sqlItemId.equals(""))
						masItemList=hbt.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemCategory as ic where item.Id in ("+sqlItemId+") and ic.Id="+item_class_id);
					
					if(masItemList.size()>0){
						patientPrescriptionHeader.setInjectionStatus("p");
					}else{
						patientPrescriptionHeader.setInjectionStatus("n");
					}
					patientPrescriptionHeader.setOtherTreatment((String)mapForDS.get("otherTreatment"));
					hbt.save(patientPrescriptionHeader);
				

				
					for (int i = 0; i < itemIdList.size(); i++) {
						if(itemIdList.get(i) !=0){
						List<MasStoreItem> itemCodeList = new ArrayList<MasStoreItem>();
						PatientPrescriptionDetails patientPrescriptionDetails = new PatientPrescriptionDetails();
						patientPrescriptionDetails.setOtStage(postAnesthesiaCode);
						if(itemIdList.get(i) != null){
							MasStoreItem masStoreItem = new MasStoreItem();
							masStoreItem.setId(itemIdList.get(i));
						patientPrescriptionDetails.setItem(masStoreItem);
						}
						if (frequencyList.get(i) != null && !frequencyList.get(i).equals("")) {
							MasFrequency masFrequency = new MasFrequency();
							masFrequency.setId(frequencyList.get(i));
							patientPrescriptionDetails.setFrequency(masFrequency);
							}
							if (dosageList.get(i) != null && !dosageList.get(i).equals("") && !dosageList.get(i).equals("0")) {
								patientPrescriptionDetails.setDosage(dosageList.get(i));
							}else{
								patientPrescriptionDetails.setDosage("0");
							}

							if (remarksList.get(i) != null && !remarksList.get(i).equals("")) {
								patientPrescriptionDetails.setRemarks(remarksList.get(i));
							}
		
							if (noOfDaysList.get(i) != null && !noOfDaysList.get(i).equals("")) {
								patientPrescriptionDetails.setNoOfDays(noOfDaysList.get(i));
							}
							if (routeList.get(i) != null && !routeList.get(i).equals("")) {
								patientPrescriptionDetails.setRoute(routeList.get(i));
							}
					
							if (totalList.get(i) != null && !totalList.get(i).equals("") && totalList.get(i) != 0) {
								patientPrescriptionDetails.setTotal(totalList.get(i));
							}else{
								patientPrescriptionDetails.setTotal(1);
							}
							patientPrescriptionDetails.setGivenQty(0);
		
						patientPrescriptionDetails.setPrescription(patientPrescriptionHeader);
					
						patientPrescriptionDetails.setDetailStatus("a");
						
						
			
						List<MasStoreItem> storeItemList=new ArrayList<MasStoreItem>();
					
						try {
							properties.load(resourcePath.openStream());
							String item_class_code = properties.getProperty("item_class_id");
							item_class_id=Integer.parseInt(item_class_code);
						} catch (Exception e) {
							e.printStackTrace();
						}
						storeItemList=hbt.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemClass as ic where item.Id="+itemIdList.get(i)+" and ic.Id="+item_class_id);
						if(storeItemList.size() > 0){
							patientPrescriptionDetails.setInjectionStatus("p");
						}else{
							patientPrescriptionDetails.setInjectionStatus("n");
						}
						
						hbt.save(patientPrescriptionDetails);
					}
					}
					
					//
					if(otherMedicineList.size() >0){
						String otherItem = "";
						patientPrescriptionHeader.setNipStatus("y");
						hbt.update(patientPrescriptionHeader);
						String nipCode = null;
						int itemClassificationId = 0;
						int groupId = 0;
						int sectionId = 0;
						int itemTypeId= 0;
						try
						{
							nipCode = HMSUtil.getProperties("adt.properties", "ItemClassificationCodeNIP");
							itemClassificationId = Integer.parseInt(HMSUtil.getProperties("adt.properties", "ItemClassificationId"));
							groupId = Integer.parseInt(HMSUtil.getProperties("adt.properties", "ItemGroupId"));
							sectionId = Integer.parseInt(HMSUtil.getProperties("adt.properties", "SectionIdForDrugs"));
							itemTypeId = Integer.parseInt(HMSUtil.getProperties("adt.properties", "ItemTypeId"));
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						int totalNip = session.createCriteria(MasStoreItem.class).createAlias("ItemClassification", "ic").add(Restrictions.eq("ic.Classification", nipCode)).add(Restrictions.eq("Hospital.Id", hospitalId)).list().size();
						
							
					for(int i = 0; i < otherMedicineList.size(); i++){
						MasStoreItem masItem = new MasStoreItem();
						if(otherMedicineList.get(i) != null && !otherMedicineList.get(i).equals("")){
							otherItem =(String)otherMedicineList.get(i);
							masItem.setNomenclature(otherMedicineList.get(i));
							MasStoreSection masStoreSection = new MasStoreSection();
							masStoreSection.setId(sectionId);
							masItem.setSection(masStoreSection);
							masItem.setStatus("y");
							masItem.setBrandedGeneric("B");
							
							if (itemConversionList.get(i) != null && !itemConversionList.get(i).equals("")) {
								MasStoreItemConversion masStoreItemConversion = new MasStoreItemConversion();
								masStoreItemConversion.setId(itemConversionList.get(i));
								masItem.setItemConversion(masStoreItemConversion);
								}
							
							if (itemClassList.get(i) != null && !itemClassList.get(i).equals("")) {
								 MasItemClass masItemClass = new MasItemClass();
								 masItemClass.setId(itemClassList.get(i));
								masItem.setItemClass(masItemClass);
								}
							
							if (itemDispensaryList.get(i) != null && !itemDispensaryList.get(i).equals("")) {
								masItem.setDispUnit(itemDispensaryList.get(i));
								}
							totalNip++;
							masItem.setPvmsNo(nipCode+totalNip);
							
							MasItemType masItemType = new MasItemType();
							masItemType.setId(itemTypeId);
							masItem.setItemType(masItemType);
						
							masHospital.setId(hospitalId);
							masItem.setHospital(masHospital);
							masItem.setHighValueDrug("n");
							MasItemClassification Mic = new MasItemClassification();
							Mic.setId(itemClassificationId);
							masItem.setItemClassification(Mic);
							MasStoreGroup msgrp = new MasStoreGroup();
							msgrp.setId(groupId);
							masItem.setGroup(msgrp);
							masItem.setLastChgBy(userName);
							masItem.setLastChgDate(date);
							masItem.setLastChgTime(time);
							
							hbt.save(masItem);
					
						PatientPrescriptionDetails patientPrescriptionDetails = new PatientPrescriptionDetails();
						patientPrescriptionDetails.setOtStage(postAnesthesiaCode);
						if(masItem.getId() != null){
							MasStoreItem masStoreItem = new MasStoreItem();
							masStoreItem.setId(masItem.getId());
						patientPrescriptionDetails.setItem(masStoreItem);
						}
						if (frequencyList.get(i) != null && !frequencyList.get(i).equals("")) {
						MasFrequency masFrequency = new MasFrequency();
						masFrequency.setId(frequencyList.get(i));
						patientPrescriptionDetails.setFrequency(masFrequency);
						}
						if (dosageList.get(i) != null && !dosageList.get(i).equals("")) {
							patientPrescriptionDetails.setDosage(dosageList.get(i));
						}
						if (remarksList.get(i) != null && !remarksList.get(i).equals("")) {
						patientPrescriptionDetails.setRemarks(remarksList.get(i));
						}
						//patientPrescriptionDetails.setType(typeLeftRightList.get(i));
						if (noOfDaysList.get(i) != null && !noOfDaysList.get(i).equals("")) {
							patientPrescriptionDetails.setNoOfDays(noOfDaysList.get(i));
						}
						if (routeList.get(i) != null && !routeList.get(i).equals("")) {
							patientPrescriptionDetails.setRoute(routeList.get(i));
						}
						
						//patientPrescriptionDetails.setInstruction(instructionList.get(i));
						if (totalList.get(i) != null && !totalList.get(i).equals("")) {
							patientPrescriptionDetails.setTotal(totalList.get(i));
						}
						patientPrescriptionDetails.setPrescription(patientPrescriptionHeader);
						patientPrescriptionDetails.setGivenQty(0);
						patientPrescriptionDetails.setDetailStatus("a");
						List<MasStoreItem> storeItemList=new ArrayList<MasStoreItem>();
						
						if(ctList.get(i).equals("y")){
							patientPrescriptionDetails.setCt("yes");
						}else{
							patientPrescriptionDetails.setCt("no");
						}
						
						patientPrescriptionDetails.setInjectionStatus("n");
						hbt.save(patientPrescriptionDetails);
						
				
						}
				
					}
				}
					
					
				}
				
		
	//Investigation
				int hiddenValue = box.getInt("hiddenValue");
				int temp = 1;
				String[] chargeCodeIdArr = new String[hiddenValue];
				List<String> chargeCodeIdList = new ArrayList<String>();
				
				for (int i = 0; i < hiddenValue; i++) {
					if (box.get("chargeCodeName" + temp) != null
							&& !box.get("chargeCodeName" + temp)
									.equals("")) {

						String chargeCodeNameWithId = box.getString("chargeCodeName" + temp);
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
							//quantityList.add(qty);
							// clinicalList.add(clinicalNotes);
							
							
						}
					}
					temp++;
				}
		
				if (chargeCodeIdList.size() > 0) {
				//investigation
				/*Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);*/
				MasEmployee emp = new MasEmployee();
				emp.setId(empId);
				
				//OpdSurgeryHeader opsSH = new OpdSurgeryHeader();
				//opsSH.setId(opdSurgeryHeaderId);
				

				DgOrderhd dgOrderhd = new DgOrderhd();
				if(visitId!=0)
				{
					dgOrderhd.setVisit(visit);
				}
				if(inpatientId!=0)
				{
					dgOrderhd.setInpatient(inpatient);
				}

				dgOrderhd.setOrderDate(new Date());
				dgOrderhd.setOrderTime(consultationTime);
				dgOrderhd.setHospital(masHospital);
				dgOrderhd.setHin(patient);
				dgOrderhd.setDepartment(masDepartment);
				dgOrderhd.setPrescribedBy(emp);
				
				//dgOrderhd.setSurgery(opsSH);
				dgOrderhd.setPatientType("IP");
				dgOrderhd.setTestType("Regular");
				dgOrderhd.setCreatedby(box.getString("userName"));
				dgOrderhd.setCreatedon(new Date());

				//String orderSeqNo = generateOrderNumber(box.getInt("hospitalId"));
				
				Map<String, Object> adMap = new HashMap<String, Object>();
			      adMap.put("tableObjectName", "DgOrderhd");            
		            adMap.put("isHospitalWise", "y");
		            adMap.put("hospitalId", hospitalId);
		            adMap.put("isYearly", "n");            
		            adMap.put("isMonthly", "n");
		            adMap.put("isPrefix", "n");
				 //adtHandlerService.generateAdNumber(adMap);
				
				//String issueNo = generateTransactionSequence(adMap, session);
		            String orderSeqNo = HMSUtil.generateTransactionSequence(adMap, session, hbt);
				
				dgOrderhd.setOrderNo(orderSeqNo);
				//dgOrderhd.setInpatient(inpatient);
				
				dgOrderhd.setClinicalNote(box.getString("clinicalNotes1"));
				dgOrderhd.setOrderStatus("P");
				dgOrderhd.setLabOrderStatus("P");
				dgOrderhd.setLastChgBy(user);
				dgOrderhd.setLastChgDate(new Date());
				dgOrderhd.setLastChgTime(consultationTime);
				//dgOrderhd.setInvestigationRequestionNo(patientInvestigationHeader);
				hbt.save(dgOrderhd);
				
				for (int i = 0; i < chargeCodeIdList.size(); i++) {
					
					List<Patient> patientList = new ArrayList<Patient>();   
					String patientTypeNameForHAL = null;
					String patientTypeNameForOther = null;
					String dgOrderBillingStatus ="";
					
					Properties properties = new Properties();
					URL resourcePath = Thread.currentThread().getContextClassLoader()
							.getResource("adt.properties");
					try {
						properties.load(resourcePath.openStream());
						
						 patientTypeNameForHAL = properties.getProperty("patientTypeNameForHAL");;
						 patientTypeNameForOther = properties.getProperty("patientTypeNameForOther");;
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
					Criteria crit = session.createCriteria(Patient.class).add(
							Restrictions.eq("Id", hinId));
					patientList = crit.list();
								
					
					if(patientList.size()!=0)
					{
						if(patientList.get(0).getPatientType().getPatientTypeName().equals(patientTypeNameForHAL))
						{
							dgOrderBillingStatus ="y";
						}
						else if(patientList.get(0).getPatientType().getPatientTypeName().equals(patientTypeNameForOther))
						{
							if(patientList.get(0).getBillable().equals("y"))
							    dgOrderBillingStatus ="n";
							else if(patientList.get(0).getBillable().equals("n"))
								dgOrderBillingStatus ="y";
						}
					}
		
					MasChargeCode masChargeCode = new MasChargeCode();
					//System.out.println("Integer.parseInt(chargeCodeIdList.get(i))--"+Integer.parseInt(chargeCodeIdList.get(i)));
					masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));

					DgOrderdt dgOrderdt = new DgOrderdt();
					dgOrderdt.setOtStage(postAnesthesiaCode);
					dgOrderdt.setOrderhd(dgOrderhd);
					masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
					dgOrderdt.setChargeCode(masChargeCode);
					//dgOrderdt.setOrderQty(quantityList.get(i));
					dgOrderdt.setBillingStatus(dgOrderBillingStatus);
					dgOrderdt.setCreatedby(box.getString("userName"));
					dgOrderdt.setCreatedon(new Date());
					dgOrderdt.setLastChgBy(user);
					
					dgOrderdt.setLastChgDate(new Date());
					dgOrderdt.setLastChgTime(consultationTime);
					dgOrderdt.setMsgSent("n");
					// method written for taking out the values of mascharge
					// code and subcharge

					List<MasChargeCode> masChargeList = new ArrayList<MasChargeCode>();
					masChargeList = session.createCriteria(MasChargeCode.class).add(
							Restrictions.eq("Id", Integer.parseInt(chargeCodeIdList.get(i)))).list();
					
					MasChargeCode masChargeCodeObj = masChargeList.get(0);
					int mainChargeId = masChargeCodeObj.getMainChargecode()
					.getId();
					int subChargeId = masChargeCodeObj.getSubChargecode()
					.getId();
					if (masChargeCodeObj.getMainChargecode()
							.getMainChargecodeCode().equalsIgnoreCase("Lab")) {
						dgOrderdt.setOrderStatus("P");
					} else {
						dgOrderdt.setOrderStatus("P");
					}
					MasMainChargecode masMainChargecode = new MasMainChargecode();
					masMainChargecode.setId(mainChargeId);
					dgOrderdt.setMainChargecode(masMainChargecode);
					MasSubChargecode masSubChargecode = new MasSubChargecode();
					masSubChargecode.setId(subChargeId);
					dgOrderdt.setSubChargeid(masSubChargecode);
					dgOrderdt.setInvestigation(new DgMasInvestigation(Integer.parseInt(chargeCodeIdList.get(i))));
					//dgOrderdt.setInvestigationToMH(referToMhList.get(i));
					dgOrderdt.setInvestigationToMh("n");
					//dgOrderdt.setReferToMh(referToMhList.get(i));
					dgOrderdt.setReferToMh("n");

					
					hbt.save(dgOrderdt);
				}
		
			}
				
				if (bookingId != 0) {
					OtBooking otBooking = (OtBooking) hbt.load(OtBooking.class,
							bookingId);
					otBooking.setOtPostAnethesiaStatus("y");
					hbt.update(otBooking);
				}
				
				tx.commit();
				dataSaved = true;
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();

			} finally {
				// --------Session Closing----------
				session.close();
			}
			map.put("dataSaved", dataSaved);
			map.put("postAnaesthesiaProcedureId", postAnaesthesiaProcedureId);
			
			return map;

		
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getItemListForAutoComplete(Map mapForDS) {
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			String str = "%" + mapForDS.get("autoHint") + "%";
			String query = "from MasStoreItem as mst where mst.Nomenclature like '"
					+ str + "' and mst.Status = 'y'";
			Query q = session.createQuery(query);
			q.setFirstResult(0);
			q.setMaxResults(10);
			itemList = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getItemList(Map<String, Object> map) {
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Session session = (Session) getSession();
		try {
			String str = map.get("autoHint") + "%";
			String query = "";

			query = "SELECT DISTINCT(sib.Nomenclature),sib.PvmsNo from MasStoreItem as sib where sib.Nomenclature like '"
					+ str + "' and sib.Status='y'";

			Query q = session.createQuery(query);
			q.setFirstResult(0);
			q.setMaxResults(10);
			itemList = q.list();
			Iterator itr = itemList.iterator();
			while (itr.hasNext()) {
				Object[] pair = (Object[]) itr.next();
				@SuppressWarnings("unused")
				String nomenclature = (String) pair[0];

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public int getItemIdFromPVMS(String pvmsNo) {
		List<MasStoreItem> itemIdList = new ArrayList<MasStoreItem>();
		Session session = (Session) getSession();
		int itemId = 0;
		try {
			itemIdList = session.createCriteria(MasStoreItem.class).add(
					Restrictions.eq("PvmsNo", pvmsNo)).add(
					Restrictions.eq("Status", "y")).list();
			//System.out.println("itemIdList--->" + itemIdList.size());
			MasStoreItem masStoreItem = itemIdList.get(0);
			itemId = masStoreItem.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return itemId;
	}

	public int getItemIdFromPVMS2(String pvmsNo2) {
		List<MasStoreItem> itemId2List = new ArrayList<MasStoreItem>();
		Session session = (Session) getSession();
		int item2Id = 0;
		try {
			itemId2List = session.createCriteria(MasStoreItem.class).add(
					Restrictions.eq("PvmsNo", pvmsNo2)).add(
					Restrictions.eq("Status", "y")).list();
			MasStoreItem masStoreItem = itemId2List.get(0);
			item2Id = masStoreItem.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return item2Id;
	}

	public int getItemIdFromPVMS3(String pvmsNo3) {
		List<MasStoreItem> itemId3List = new ArrayList<MasStoreItem>();
		Session session = (Session) getSession();
		int item3Id = 0;
		try {
			itemId3List = session.createCriteria(MasStoreItem.class).add(
					Restrictions.eq("PvmsNo", pvmsNo3)).add(
					Restrictions.eq("Status", "y")).list();

			MasStoreItem masStoreItem = itemId3List.get(0);
			item3Id = masStoreItem.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return item3Id;
	}

	public Map<String, Object> showOtPostAnesthesiaProcedure(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OtPostAnaesthesiaProcedure> otPostAnaesthesiaProcedureList = new ArrayList<OtPostAnaesthesiaProcedure>();
		List<OtSurgeyPaEmployeeDetail> surgeyPaEmployeeDetailList = new ArrayList<OtSurgeyPaEmployeeDetail>();
		List<OtSurgeyPaSurgeyDetail> surgeyPaSurgeyDetailList = new ArrayList<OtSurgeyPaSurgeyDetail>();
		List<OtSurgeyPaAnesthesiologistDetail> surgeyPaAnesthesiologistDetailList = new ArrayList<OtSurgeyPaAnesthesiologistDetail>();
		List<OtSurgeyPaIvFluidsDetail> surgeyPaIvFluidsDetailList = new ArrayList<OtSurgeyPaIvFluidsDetail>();
		List<OtSurgeyPaPremedicationDetail> surgeyPaPremedicationDetailList = new ArrayList<OtSurgeyPaPremedicationDetail>();
		List<OtSurgeyPaProcedureDetail> surgeyPaProcedureDetailList = new ArrayList<OtSurgeyPaProcedureDetail>();
		List<OtBooking> patientDetailList = new ArrayList<OtBooking>();
		List<MasAnesthesia> anesthesiaList = new ArrayList<MasAnesthesia>();

		String serviceNo = "";
		String hinNo = "";
		String visitNo = "";
		int otPostId = 0;
		Session session = (Session) getSession();

		if (mapForDS.get("serviceNo") != null) {
			serviceNo = (String) mapForDS.get("serviceNo");
		}
		if (mapForDS.get("hinNo") != null) {
			hinNo = (String) mapForDS.get("hinNo");
		}
		if (mapForDS.get("visitNo") != null) {
			visitNo = (String) mapForDS.get("visitNo");

		}
		//System.out.println("visitNo -----" + visitNo);
		//System.out.println("service number-----" + serviceNo);
		try {

			Criteria crit = session.createCriteria(OtBooking.class)
					.createAlias("Hin", "hin").add(
							Restrictions.eq("hin.HinNo", hinNo));
			patientDetailList = crit.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);

		Criteria crit = session
				.createCriteria(OtPostAnaesthesiaProcedure.class).createAlias(
						"Hin", "hin");
		if (!hinNo.equals("")) {
			if (visitNo != "") {

				crit = crit.add(Restrictions.eq("YearlySlNo", visitNo));

			}
			if (!serviceNo.equals("")) {

				crit = crit.add(Restrictions.eq("hin.ServiceNo", serviceNo));
			}

		} else {
			crit = crit.add(Restrictions.eq("hin.HinNo", hinNo));
		}
		otPostAnaesthesiaProcedureList = crit.list();

		for (Iterator iter = otPostAnaesthesiaProcedureList.iterator(); iter
				.hasNext();) {
			OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure = (OtPostAnaesthesiaProcedure) iter
					.next();

			otPostId = otPostAnaesthesiaProcedure.getId();
		}

		//System.out.println("otPostId-----" + otPostId);
		if (otPostId != 0) {
			surgeyPaEmployeeDetailList = session.createCriteria(
					OtSurgeyPaEmployeeDetail.class).createAlias(
					"OtPostAnaesthesiaProcedure", "otPost").add(
					Restrictions.eq("otPost.Id", otPostId)).list();
			surgeyPaSurgeyDetailList = session.createCriteria(
					OtSurgeyPaSurgeyDetail.class).createAlias(
					"OtPostAnaesthesiaProcedure", "otPost").add(
					Restrictions.eq("otPost.Id", otPostId)).list();
			surgeyPaAnesthesiologistDetailList = session.createCriteria(
					OtSurgeyPaAnesthesiologistDetail.class).createAlias(
					"OtPostAnaesthesiaProcedure", "otPost").add(
					Restrictions.eq("otPost.Id", otPostId)).list();
			surgeyPaIvFluidsDetailList = session.createCriteria(
					OtSurgeyPaIvFluidsDetail.class).createAlias(
					"OtPostAnaesthesiaProcedure", "otPost").add(
					Restrictions.eq("otPost.Id", otPostId)).list();
			surgeyPaPremedicationDetailList = session.createCriteria(
					OtSurgeyPaPremedicationDetail.class).createAlias(
					"OtPostAnaesthesiaProcedure", "otPost").add(
					Restrictions.eq("otPost.Id", otPostId)).list();
			surgeyPaProcedureDetailList = session.createCriteria(
					OtSurgeyPaProcedureDetail.class).createAlias(
					"OtPostAnaesthesiaProcedure", "otPost").add(
					Restrictions.eq("otPost.Id", otPostId)).list();
			anesthesiaList = session.createCriteria(MasAnesthesia.class).add(
					Restrictions.eq("Status", "y")).list();

			map.put("surgeyPaEmployeeDetailList", surgeyPaEmployeeDetailList);
			map.put("surgeyPaSurgeyDetailList", surgeyPaSurgeyDetailList);
			map.put("surgeyPaAnesthesiologistDetailList",
					surgeyPaAnesthesiologistDetailList);
			map.put("surgeyPaIvFluidsDetailList", surgeyPaIvFluidsDetailList);
			map.put("surgeyPaPremedicationDetailList",
					surgeyPaPremedicationDetailList);
			map.put("surgeyPaProcedureDetailList", surgeyPaProcedureDetailList);
			map.put("anesthesiaList", anesthesiaList);

		}
		map.put("otPostAnaesthesiaProcedureList",
				otPostAnaesthesiaProcedureList);

		return map;

	}

	@SuppressWarnings("unchecked")
	public List<Object> getHinNoList(String serviceNo) {
		Session session = (Session) getSession();
		List<Object> patientList = new ArrayList<Object>();

		try {

			patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("ServiceNo", serviceNo)).list();
			//System.out.println("patientList - " + patientList.size());
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return patientList;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getVisitNoList(Map<String, Object> detailsMap) {
		@SuppressWarnings("unchecked")
		Session session = (Session) getSession();
		String serviceNo = "";
		String hinNo = "";
		if (detailsMap.get("serviceNo") != null) {
			serviceNo = (String) detailsMap.get("serviceNo");
		}
		if (detailsMap.get("hinNo") != null) {
			hinNo = (String) detailsMap.get("hinNo");
		}
		List<Object> vistList = new ArrayList<Object>();

		try {
			if (!serviceNo.equals("")) {
				Criteria crit = session.createCriteria(
						OtPostAnaesthesiaProcedure.class).createAlias("Hin",
						"p").add(Restrictions.eq("p.ServiceNo", serviceNo));
				vistList = crit.list();
				// vistList =
				// getHibernateTemplate().find("from Visit v join v.Hin as p where p.ServiceNo = '"+serviceNo+"'");
			}
			if (!hinNo.equals("")) {
				Criteria crit = session.createCriteria(
						OtPostAnaesthesiaProcedure.class).createAlias("Hin",
						"p").add(Restrictions.eq("p.HinNo", hinNo));
				vistList = crit.list();
				// vistList =
				// getHibernateTemplate().find("from Visit v join v.Hin as p where p.HinNo = '"+hinNo+"'");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return vistList;

	}

	public String getEntryNoForDisplay() {
		String entryNo = "";
		int entrySeqNo = 0;
		List<TransactionSequence> seqNoList = new ArrayList<TransactionSequence>();
		String tableName = "";
		String prefix = "";
		String seqNoName = "";

		tableName = "OtSpecimenDispatchEntry";
		prefix = "SENO";
		seqNoName = "Specimen Entry No";

		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(TransactionSequence.class).add(
					Restrictions.eq("TransactionPrefix", prefix)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (seqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : seqNoList) {
				int id = transactionSequence.getId();
				int seqNo = transactionSequence.getTransactionSequenceNumber();
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				entrySeqNo = ++seqNo;
				transactionSequenceObj.setTransactionSequenceNumber(entrySeqNo);
				hbt.update(transactionSequenceObj);
			}
		} else if (seqNoList.size() == 0) {
			entrySeqNo = 1;
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename(tableName);
			tsObj.setTransactionPrefix(prefix);
			tsObj.setTransactionSequenceName(seqNoName);
			tsObj.setTransactionSequenceNumber(entrySeqNo);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");

			hbt.save(tsObj);
		}

		entryNo = String.valueOf(entrySeqNo);
		return entryNo;
	}

	public Map<String, Object> searchSpecimenDispatchEntryPatientDetails(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OtBooking> patientList = new ArrayList<OtBooking>();

		String serviceNo = "";
		String hinNo = "";

		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		String serviceFName = "";
		String serviceMName = "";
		String serviceLName = "";

		Session session = (Session) getSession();

		if (mapForDS.get("serviceNo") != null) {
			serviceNo = (String) mapForDS.get("serviceNo");
		}
		if (mapForDS.get("hinNo") != null) {

			hinNo = (String) mapForDS.get("hinNo");
		}

		if (mapForDS.get("patientFName") != null) {
			patientFName = (String) mapForDS.get("patientFName");
		}
		if (mapForDS.get("patientMName") != null) {
			patientMName = (String) mapForDS.get("patientMName");
		}
		if (mapForDS.get("patientLName") != null) {
			patientLName = (String) mapForDS.get("patientLName");
		}
		if (mapForDS.get("serviceFName") != null) {
			serviceFName = (String) mapForDS.get("serviceFName");
		}
		if (mapForDS.get("serviceMName") != null) {
			serviceMName = (String) mapForDS.get("serviceMName");
		}
		if (mapForDS.get("serviceLName") != null) {
			serviceLName = (String) mapForDS.get("serviceLName");
		}

		Criteria crit = session.createCriteria(OtBooking.class).createAlias(
				"Hin", "hin");
		if (hinNo != null) {
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.eq("hin.ServiceNo", serviceNo));
			}

			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("hin.PFirstName",
						patientFName + "%"));
			}
			if (!patientMName.equals("")) {
				crit = crit.add(Restrictions.like("hin.PMiddleName",
						patientMName + "%"));
			}
			if (!patientLName.equals("")) {
				crit = crit.add(Restrictions.like("hin.PLastName", patientLName
						+ "%"));
			}
			if (!serviceFName.equals("")) {
				crit = crit.add(Restrictions.like("hin.SFirstName",
						serviceFName + "%"));
			}
			if (!serviceMName.equals("")) {
				crit = crit.add(Restrictions.like("hin.SMiddleName",
						serviceMName + "%"));
			}
			if (!serviceLName.equals("")) {
				crit = crit.add(Restrictions.like("hin.SLastName", serviceLName
						+ "%"));
			}

		} else {
			crit = crit.add(Restrictions.eq("hin.HinNo", hinNo));
		}
		patientList = crit.list();
		map.put("patientList", patientList);
		return map;

	}

	public Map<String, Object> showSpecimenDispatchEntryJspForHin(
			Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		List<OtBooking> patientDetailList = new ArrayList<OtBooking>();
		List<MasEmployee> empByList = new ArrayList<MasEmployee>();
		List<MasEmployee> empRevList = new ArrayList<MasEmployee>();
		List<OtSpecimenDispatchEntry> otSpecimenDispatchEntryList = new ArrayList<OtSpecimenDispatchEntry>();
		// List<MasDepartment> departmentList = new ArrayList<MasDepartment>();

		Map<String, Object> map = new HashMap<String, Object>();
		Integer otBookingId = Integer.parseInt((String) mapForDS
				.get("otBookingId"));

		try {

			Criteria crit = session.createCriteria(OtBooking.class).add(
					Restrictions.eq("Id", otBookingId)).add(
					Restrictions.eq("SpecimenDispatchEntryStatus", "n"));
			patientDetailList = crit.list();

			empByList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).list();
			empRevList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).list();
			if (patientDetailList.size() == 0) {
				Criteria criteria = session.createCriteria(
						OtSpecimenDispatchEntry.class).add(
						Restrictions.eq("OtBooking.Id", otBookingId));
				otSpecimenDispatchEntryList = criteria.list();

				criteria = session.createCriteria(OtBooking.class).add(
						Restrictions.eq("Id", otBookingId)).add(
						Restrictions.eq("SpecimenDispatchEntryStatus", "y"));
				patientDetailList = criteria.list();

			}

			map.put("otSpecimenDispatchEntryList", otSpecimenDispatchEntryList);
			/*
			 * crit = session.createCriteria(OtSpecimenDispatchEntry.class)
			 * .createAlias("Hin", "hin") .add(Restrictions.eq("hin.HinNo",
			 * hinNo)); otSpecimenDispatchEntryList =crit.list();
			 */

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		map.put("empByList", empByList);
		map.put("empRevList", empRevList);

		return map;

	}

	public boolean submitOtSpecimenDispatchEntry(Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		boolean succesfullyAdded = false;

		int hinId = (Integer) mapForDS.get("hinId");
		int otBookingId = (Integer) mapForDS.get("otBookingId");
		int departmentId = (Integer) mapForDS.get("departmentId");
		int visitId = (Integer) mapForDS.get("visitId");
		int hospitalId = (Integer) mapForDS.get("hospitalId");
		int empBy = (Integer) mapForDS.get("empBy");
		int empRev = (Integer) mapForDS.get("empRev");

		String tissueOrgan = (String) mapForDS.get("tissueOrgan");
		String clinicalNotes = (String) mapForDS.get("clinicalNotes");
		String examinationRequired = (String) mapForDS
				.get("examinationRequired");
		String timeOfDispatch = (String) mapForDS.get("timeOfDispatch");
		String entryNo = (String) mapForDS.get("entryNo");

		String dateOfD = (String) mapForDS.get("dateOfDispatch");
		Date dateOfDispatch = HMSUtil.convertStringTypeDateToDateType(dateOfD);

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		String userName = (String) mapForDS.get("userName");
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			OtSpecimenDispatchEntry otSpecimenDispatchEntry = new OtSpecimenDispatchEntry();
			if (visitId != 0) {
				Visit visitObj = new Visit();
				visitObj.setId(visitId);
				otSpecimenDispatchEntry.setVisit(visitObj);
			}
			if (departmentId != 0) {
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				otSpecimenDispatchEntry.setDepartment(masDepartment);
			}
			if (hinId != 0) {
				Patient patient = new Patient();
				patient.setId(hinId);
				otSpecimenDispatchEntry.setHin(patient);
			}
			if (hospitalId != 0) {
				MasHospital masHospitalObj = new MasHospital();
				masHospitalObj.setId(hospitalId);
				otSpecimenDispatchEntry.setHospital(masHospitalObj);
			}

			otSpecimenDispatchEntry.setClinicalNotes(clinicalNotes);
			otSpecimenDispatchEntry.setExaminationRequired(examinationRequired);
			otSpecimenDispatchEntry.setTimeOfDispatch(timeOfDispatch);
			otSpecimenDispatchEntry.setTissueOrgan(tissueOrgan);
			otSpecimenDispatchEntry.setLastChgBy(userName);
			otSpecimenDispatchEntry.setLastChgDate(date);
			otSpecimenDispatchEntry.setLastChgTime(time);
			otSpecimenDispatchEntry.setStatus("y");
			otSpecimenDispatchEntry.setEntryNo(entryNo);

			OtBooking otBooking = new OtBooking();
			otBooking.setId(otBookingId);
			otSpecimenDispatchEntry.setOtBooking(otBooking);

			otSpecimenDispatchEntry
					.setOtSpecimenDispatchEntryDate(dateOfDispatch);

			if (empBy != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(empBy);
				otSpecimenDispatchEntry.setSpecimenDispatchedBy(masEmployee);
			}

			if (empRev != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(empRev);
				otSpecimenDispatchEntry.setSpecimenReceivedBy(masEmployee);
			}

			hbt.save(otSpecimenDispatchEntry);
			hbt.refresh(otSpecimenDispatchEntry);

			OtBooking booking = (OtBooking) hbt.load(OtBooking.class,
					otBookingId);
			booking.setSpecimenDispatchEntryStatus("y");
			hbt.update(booking);
			hbt.refresh(booking);

			succesfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}

		return succesfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getEntryHinNoList(String serviceNo) {
		Session session = (Session) getSession();
		List<Object> patientList = new ArrayList<Object>();

		try {

			patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("ServiceNo", serviceNo)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return patientList;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getEntryNoList(Map<String, Object> detailsMap) {
		@SuppressWarnings("unchecked")
		Session session = (Session) getSession();
		String serviceNo = "";
		String hinNo = "";
		if (detailsMap.get("serviceNo") != null) {
			serviceNo = (String) detailsMap.get("serviceNo");
		}
		if (detailsMap.get("hinNo") != null) {
			hinNo = (String) detailsMap.get("hinNo");
		}
		List<Object> vistList = new ArrayList<Object>();

		try {
			if (!serviceNo.equals("")) {
				Criteria crit = session.createCriteria(
						OtSpecimenDispatchEntry.class).createAlias("Hin", "p")
						.add(Restrictions.eq("p.ServiceNo", serviceNo));
				vistList = crit.list();
				// vistList =
				// getHibernateTemplate().find("from Visit v join v.Hin as p where p.ServiceNo = '"+serviceNo+"'");
			}
			if (!hinNo.equals("")) {
				Criteria crit = session.createCriteria(
						OtSpecimenDispatchEntry.class).createAlias("Hin", "p")
						.add(Restrictions.eq("p.HinNo", hinNo));
				vistList = crit.list();
				// vistList =
				// getHibernateTemplate().find("from Visit v join v.Hin as p where p.HinNo = '"+hinNo+"'");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return vistList;

	}

	public Map<String, Object> showOtSpecimenDispatchEntry(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OtSpecimenDispatchEntry> otSpecimenDispatchEntryList = new ArrayList<OtSpecimenDispatchEntry>();
		List<OtBooking> patientDetailList = new ArrayList<OtBooking>();
		List<MasEmployee> empByList = new ArrayList<MasEmployee>();
		List<MasEmployee> empRevList = new ArrayList<MasEmployee>();

		String serviceNo = "";
		String hinNo = "";
		String visitNo = "";
		int otPostId = 0;
		Session session = (Session) getSession();

		if (mapForDS.get("serviceNo") != null) {
			serviceNo = (String) mapForDS.get("serviceNo");
		}
		if (mapForDS.get("hinNo") != null) {
			hinNo = (String) mapForDS.get("hinNo");
		}
		if (mapForDS.get("visitNo") != null) {
			visitNo = (String) mapForDS.get("visitNo");

		}
		//System.out.println("visitNo -----" + visitNo);
		//System.out.println("service number-----" + serviceNo);
		try {

			Criteria crit = session.createCriteria(OtBooking.class)
					.createAlias("Hin", "hin").add(
							Restrictions.eq("hin.HinNo", hinNo));
			patientDetailList = crit.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);

		Criteria crit = session.createCriteria(OtSpecimenDispatchEntry.class)
				.createAlias("Hin", "hin");
		if (!hinNo.equals("")) {
			if (visitNo != "") {

				crit = crit.add(Restrictions.eq("EntryNo", visitNo));

			}
			if (!serviceNo.equals("")) {

				crit = crit.add(Restrictions.eq("hin.ServiceNo", serviceNo));
			}

		} else {
			crit = crit.add(Restrictions.eq("hin.HinNo", hinNo));
		}
		otSpecimenDispatchEntryList = crit.list();
		empByList = session.createCriteria(MasEmployee.class).add(
				Restrictions.eq("Status", "y")).list();
		empRevList = session.createCriteria(MasEmployee.class).add(
				Restrictions.eq("Status", "y")).list();

		map.put("otSpecimenDispatchEntryList", otSpecimenDispatchEntryList);
		map.put("empByList", empByList);
		map.put("empRevList", empRevList);
		return map;

	}

	public boolean updateOtSpecimenDispatchEntry(Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		boolean succesfullyAdded = false;

		int hinId = (Integer) mapForDS.get("hinId");
		int departmentId = (Integer) mapForDS.get("departmentId");
		int visitId = (Integer) mapForDS.get("visitId");
		int hospitalId = (Integer) mapForDS.get("hospitalId");
		int empBy = (Integer) mapForDS.get("empBy");
		int empRev = (Integer) mapForDS.get("empRev");
		int specimenId = (Integer) mapForDS.get("specimenId");
		String tissueOrgan = (String) mapForDS.get("tissueOrgan");
		String clinicalNotes = (String) mapForDS.get("clinicalNotes");
		String examinationRequired = (String) mapForDS
				.get("examinationRequired");
		String timeOfDispatch = (String) mapForDS.get("timeOfDispatch");
		String entryNo = (String) mapForDS.get("entryNo");

		String dateOfD = (String) mapForDS.get("dateOfDispatch");
		Date dateOfDispatch = HMSUtil.convertStringTypeDateToDateType(dateOfD);

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		String userName = (String) mapForDS.get("userName");

		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			OtSpecimenDispatchEntry otSpecimenDispatchEntry = (OtSpecimenDispatchEntry) getHibernateTemplate()
					.get(OtSpecimenDispatchEntry.class, specimenId);

			otSpecimenDispatchEntry.setId(specimenId);

			Visit visitObj = new Visit();
			visitObj.setId(visitId);
			otSpecimenDispatchEntry.setVisit(visitObj);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			otSpecimenDispatchEntry.setDepartment(masDepartment);

			Patient patient = new Patient();
			patient.setId(hinId);
			otSpecimenDispatchEntry.setHin(patient);

			MasHospital masHospitalObj = new MasHospital();
			masHospitalObj.setId(hospitalId);
			otSpecimenDispatchEntry.setHospital(masHospitalObj);

			otSpecimenDispatchEntry.setClinicalNotes(clinicalNotes);
			otSpecimenDispatchEntry.setExaminationRequired(examinationRequired);
			otSpecimenDispatchEntry.setTimeOfDispatch(timeOfDispatch);
			otSpecimenDispatchEntry.setTissueOrgan(tissueOrgan);
			otSpecimenDispatchEntry.setLastChgBy(userName);
			otSpecimenDispatchEntry.setLastChgDate(date);
			otSpecimenDispatchEntry.setLastChgTime(time);
			otSpecimenDispatchEntry.setStatus("y");
			otSpecimenDispatchEntry.setEntryNo(entryNo);
			otSpecimenDispatchEntry
					.setOtSpecimenDispatchEntryDate(dateOfDispatch);

			if (empBy != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(empBy);
				otSpecimenDispatchEntry.setSpecimenDispatchedBy(masEmployee);
			}

			if (empRev != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(empRev);
				otSpecimenDispatchEntry.setSpecimenReceivedBy(masEmployee);
			}
			hbt.saveOrUpdate(otSpecimenDispatchEntry);
			hbt.refresh(otSpecimenDispatchEntry);

			succesfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}

		return succesfullyAdded;
	}

	/**
	 * --------------------- Connection for DB ----------------------
	 */
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}

	public Map<String, Object> showPACDetailInJsp(int orderNo, int hinId,
			int inpatientId) {
		Session session = (Session) getSession();
		List<OtPreAnesthesiaHd> otPreAnesthesiaDetailsList = new ArrayList<OtPreAnesthesiaHd>();
		List<OpdPatientHistory> opdPatientHistoryList = new ArrayList<OpdPatientHistory>();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			otPreAnesthesiaDetailsList = session.createCriteria(
					OtPreAnesthesiaHd.class).add(
					Restrictions.eq("OrderNo", orderNo)).list();
			opdPatientHistoryList = session.createCriteria(
					OpdPatientHistory.class).createAlias("Hin", "p").add(
					Restrictions.eq("p.Id", hinId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("opdPatientHistoryList", opdPatientHistoryList);
		map.put("otPreAnesthesiaDetailsList", otPreAnesthesiaDetailsList);
		return map;
	}

	public boolean updateOtPostAnesthesiaProcedure(Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		boolean succesfullyAdded = false;
		List pvmsNoList = (List) mapForDS.get("pvmsNoList");
		List pvmsNoPrList = (List) mapForDS.get("pvmsNoPrList");
		List pvmsNoProList = (List) mapForDS.get("pvmsNoProList");
		List<String> dosageList = (List) mapForDS.get("dosageList");
		List<String> empNameList = (List) mapForDS.get("empNameList");
		List<String> empNameSList = (List) mapForDS.get("empNameSList");
		List<String> agePrList = (List) mapForDS.get("agePrList");
		List<String> catheterList = (List) mapForDS.get("catheterList");
		List<String> anesthesiaList = (List) mapForDS.get("anesthesiaList");
		List<String> levelList = (List) mapForDS.get("levelList");
		List<Integer> volumeList = (List) mapForDS.get("volumeList");
		List<String> chargeCodeList = (List) mapForDS.get("chargeCodeList");
		List<String> typeList = (List) mapForDS.get("typeList");
		List<String> routeList = (List) mapForDS.get("routeList");
		List<String> fluidNameList = (List) mapForDS.get("fluidNameList");
		int hinId = (Integer) mapForDS.get("hinId");
		int departmentId = (Integer) mapForDS.get("departmentId");
		// int visitId=(Integer)mapForDS.get("visitId");
		int hospitalId = (Integer) mapForDS.get("hospitalId");
		String anesthesia_value = (String) mapForDS.get("anesthesia_value");
		// int anesthesia_id=(Integer)mapForDS.get("anesthesia_id");
		int postId = (Integer) mapForDS.get("postId");
		String ett_lma = (String) mapForDS.get("ett_lma");
		int ett_lma_text = (Integer) mapForDS.get("ett_lma_text");
		String ecg = (String) mapForDS.get("ecg");
		String nibp = (String) mapForDS.get("nibp");
		String cvp = (String) mapForDS.get("cvp");
		String temp = (String) mapForDS.get("temp");
		String sp02 = (String) mapForDS.get("sp02");
		String labp = (String) mapForDS.get("labp");
		String anaesthesia_from_time = (String) mapForDS
				.get("anaesthesia_from_time");
		String anaesthesia_to_time = (String) mapForDS
				.get("anaesthesia_to_time");
		String yearlySlNo = (String) mapForDS.get("yearlySlNo");
		String monthlySlNo = (String) mapForDS.get("monthlySlNo");
		String surgey_from_time = (String) mapForDS.get("surgey_from_time");
		String surgey_to_time = (String) mapForDS.get("surgey_to_time");
		String uo = (String) mapForDS.get("uo");
		int neostigmine = (Integer) mapForDS.get("neostigmine");
		Integer glycophyrrolate = (Integer) mapForDS.get("glycophyrrolate");
		Integer others = (Integer) mapForDS.get("others");
		String recovery = (String) mapForDS.get("recovery");
		String risk_grade = (String) mapForDS.get("risk_grade");
		String e_others = (String) mapForDS.get("e_others");
		String remarks = (String) mapForDS.get("remarks");
		String dateOfP = (String) mapForDS.get("dateOfPost");
		String pre_assessment = (String) mapForDS.get("pre_assessment");
		Date dateOfPost = HMSUtil.convertStringTypeDateToDateType(dateOfP);

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		String userName = (String) mapForDS.get("userName");
		List<Integer> itemIdList = new ArrayList<Integer>();
		List<Integer> itemId2List = new ArrayList<Integer>();
		List<Integer> itemId3List = new ArrayList<Integer>();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			OtPostAnaesthesiaProcedure opdPatientDetails = (OtPostAnaesthesiaProcedure) getHibernateTemplate()
					.get(OtPostAnaesthesiaProcedure.class, postId);

			opdPatientDetails.setId(postId);
			opdPatientDetails.setPreOpAssessment(pre_assessment);

			/*
			 * Visit visitObj= new Visit(); visitObj.setId(visitId);
			 * opdPatientDetails.setVisit(visitObj);
			 */

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			opdPatientDetails.setDepartment(masDepartment);

			Patient patient = new Patient();
			patient.setId(hinId);
			opdPatientDetails.setHin(patient);

			MasHospital masHospitalObj = new MasHospital();
			masHospitalObj.setId(hospitalId);
			opdPatientDetails.setHospital(masHospitalObj);

			opdPatientDetails.setAnaesthesiaFromTime(anaesthesia_from_time);
			opdPatientDetails.setAnaesthesiaToTime(anaesthesia_to_time);
			opdPatientDetails.setCvp(cvp);
			opdPatientDetails.setEcg(ecg);
			opdPatientDetails.setEOthers(e_others);
			opdPatientDetails.setEttLma(ett_lma);
			//opdPatientDetails.setLastChgBy(userName);
			opdPatientDetails.setLastChgDate(date);
			opdPatientDetails.setLastChgTime(time);

			opdPatientDetails.setEttLmaText(ett_lma_text);

			opdPatientDetails.setDateOfPost(dateOfPost);

			opdPatientDetails.setGlycophyrrolate(glycophyrrolate);
			opdPatientDetails.setIabp(labp);
			opdPatientDetails.setMonthlySlNo(monthlySlNo);
			opdPatientDetails.setNeostigmine(neostigmine);
			opdPatientDetails.setNibp(nibp);
			opdPatientDetails.setOthers(others);
			opdPatientDetails.setRecovery(recovery);
			opdPatientDetails.setRemarks(remarks);
			opdPatientDetails.setRiskGrade(risk_grade);
			opdPatientDetails.setSp02(sp02);
			opdPatientDetails.setSurgeyFromTime(surgey_from_time);
			opdPatientDetails.setSurgeyToTime(surgey_to_time);
			opdPatientDetails.setTemp(temp);
			opdPatientDetails.setUo(uo);
			opdPatientDetails.setYearlySlNo(yearlySlNo);

			/*
			 * if(anesthesia_id != 0){ MasAnesthesia masAnesthesia = new
			 * MasAnesthesia(); masAnesthesia.setId(anesthesia_id);
			 * opdPatientDetails.setAnesthesia(masAnesthesia); }
			 */
			opdPatientDetails.setAnesthesiaValue(anesthesia_value);
			hbt.saveOrUpdate(opdPatientDetails);
			hbt.refresh(opdPatientDetails);

			// -----------------------------------------------------------------------------------

			// --------------values to be IvFluids----------------------

			if (pvmsNoList.size() > 0) {
				Query deleteQuery = session
						.createQuery("delete from OtSurgeyPaIvFluidsDetail "
								+ "where OtPostAnaesthesiaProcedure.Id="
								+ postId);
				int row = deleteQuery.executeUpdate();
				if (row == 0) {
					//System.out.println("Doesn't deleted any row!");
				} else {
					//System.out.println("Deleted	Row: " + row);
				}

				for (int i = 0; i < pvmsNoList.size(); i++) {
					String pvmsNo = (String) pvmsNoList.get(i);
					//System.out.println("pvmsNo-->" + pvmsNo);
					int itemId = getItemIdFromPVMS(pvmsNo);
					itemIdList.add(itemId);
				}
				for (int i = 0; i < itemIdList.size(); i++) {
					OtSurgeyPaIvFluidsDetail surgeyPaIvFluidsDetail = new OtSurgeyPaIvFluidsDetail();
					MasStoreItem masStoreItem = new MasStoreItem();
					masStoreItem.setId(itemIdList.get(i));
					surgeyPaIvFluidsDetail.setItem(masStoreItem);

					surgeyPaIvFluidsDetail
							.setSurgeyPaIvFluidsDetailVolume(volumeList.get(i));
					surgeyPaIvFluidsDetail
							.setSurgeyPaIvFluidsDetailFluidsName(fluidNameList
									.get(i));

					surgeyPaIvFluidsDetail
							.setOtPostAnaesthesiaProcedure(opdPatientDetails);
					hbt.save(surgeyPaIvFluidsDetail);
				}
			}

			// ----------value for Premedication------
			if (pvmsNoPrList.size() > 0) {
				Query deleteQuery = session
						.createQuery("delete from OtSurgeyPaPremedicationDetail "
								+ "where OtPostAnaesthesiaProcedure.Id="
								+ postId);
				int row = deleteQuery.executeUpdate();
				if (row == 0) {
					//System.out.println("Doesn't deleted any row!");
				} else {
					//System.out.println("Deleted	Row: " + row);
				}

				for (int i = 0; i < pvmsNoPrList.size(); i++) {
					String pvmsNoPr = (String) pvmsNoPrList.get(i);
					int item2Id = getItemIdFromPVMS2(pvmsNoPr);
					itemId2List.add(item2Id);
				}
				for (int i = 0; i < itemId2List.size(); i++) {
					OtSurgeyPaPremedicationDetail surgeyPaPremedicationDetail = new OtSurgeyPaPremedicationDetail();
					MasStoreItem masStoreItem = new MasStoreItem();
					masStoreItem.setId(itemId2List.get(i));
					surgeyPaPremedicationDetail.setItem(masStoreItem);
					surgeyPaPremedicationDetail
							.setSurgeyPaPremedicationDetailDosa(agePrList
									.get(i));
					surgeyPaPremedicationDetail
							.setSurgeyPaPremedicationDetailRoute(routeList
									.get(i));
					try {
						surgeyPaPremedicationDetail
								.setSurgeyPaPremedicationDetailType(typeList
										.get(i));
					} catch (Exception e) {
						e.printStackTrace();
					}

					surgeyPaPremedicationDetail
							.setOtPostAnaesthesiaProcedure(opdPatientDetails);

					hbt.save(surgeyPaPremedicationDetail);
				}
			}
			// ----------data for Procedure------
			if (pvmsNoProList.size() > 0) {
				Query deleteQuery = session
						.createQuery("delete from OtSurgeyPaProcedureDetail "
								+ "where OtPostAnaesthesiaProcedure.Id="
								+ postId);
				int row = deleteQuery.executeUpdate();
				if (row == 0) {
					//System.out.println("Doesn't deleted any row!");
				} else {
					//System.out.println("Deleted	Row: " + row);
				}

				for (int i = 0; i < pvmsNoProList.size(); i++) {
					String pvmsNoPro = (String) pvmsNoProList.get(i);
					int item3Id = getItemIdFromPVMS3(pvmsNoPro);
					itemId3List.add(item3Id);
				}
				for (int i = 0; i < itemId3List.size(); i++) {
					OtSurgeyPaProcedureDetail surgeyPaProcedureDetail = new OtSurgeyPaProcedureDetail();
					MasStoreItem masStoreItem = new MasStoreItem();
					masStoreItem.setId(itemId3List.get(i));
					surgeyPaProcedureDetail.setItem(masStoreItem);

					surgeyPaProcedureDetail
							.setSurgeyPaProcedureDetailAnesthesia(anesthesiaList
									.get(i));
					surgeyPaProcedureDetail
							.setSurgeyPaProcedureDetailCatheter(catheterList
									.get(i));
					surgeyPaProcedureDetail
							.setSurgeyPaProcedureDetailLevel(levelList.get(i));
					surgeyPaProcedureDetail
							.setSurgeyPaProcedureDetailDosa(dosageList.get(i));

					surgeyPaProcedureDetail
							.setOtPostAnaesthesiaProcedure(opdPatientDetails);

					hbt.save(surgeyPaProcedureDetail);
				}
			}

			// ----------data for Anesthesiologist------

			if (empNameList.size() > 0) {
				Query deleteQuery = session
						.createQuery("delete from OtSurgeyPaAnesthesiologistDetail "
								+ "where OtPostAnaesthesiaProcedure.Id="
								+ postId);
				int row = deleteQuery.executeUpdate();
				if (row == 0) {
					//System.out.println("Doesn't deleted any row!");
				} else {
					//System.out.println("Deleted	Row: " + row);
				}

				for (int i = 0; i < empNameList.size(); i++) {
					OtSurgeyPaAnesthesiologistDetail surgeyPaAnesthesiologistDetail = new OtSurgeyPaAnesthesiologistDetail();
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(Integer.parseInt(empNameList.get(i)));
					surgeyPaAnesthesiologistDetail.setEmployee(masEmployee);

					surgeyPaAnesthesiologistDetail
							.setOtPostAnaesthesiaProcedure(opdPatientDetails);
					hbt.save(surgeyPaAnesthesiologistDetail);
				}
			}

			// ----------data for Sergon------

			if (empNameSList.size() > 0) {
				Query deleteQuery = session
						.createQuery("delete from OtSurgeyPaEmployeeDetail "
								+ "where OtPostAnaesthesiaProcedure.Id="
								+ postId);
				int row = deleteQuery.executeUpdate();
				if (row == 0) {
					//System.out.println("Doesn't deleted any row!");
				} else {
					//System.out.println("Deleted	Row: " + row);
				}

				for (int i = 0; i < empNameSList.size(); i++) {
					OtSurgeyPaEmployeeDetail surgeyPaEmployeeDetail = new OtSurgeyPaEmployeeDetail();
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(Integer.parseInt(empNameSList.get(i)));
					surgeyPaEmployeeDetail.setEmployee(masEmployee);

					surgeyPaEmployeeDetail
							.setOtPostAnaesthesiaProcedure(opdPatientDetails);
					hbt.save(surgeyPaEmployeeDetail);
				}
			}
			// ----------data for chargeCodeIdList------

			if (chargeCodeList.size() > 0) {
				Query deleteQuery = session
						.createQuery("delete from OtSurgeyPaSurgeyDetail "
								+ "where OtPostAnaesthesiaProcedure.Id="
								+ postId);
				int row = deleteQuery.executeUpdate();
				if (row == 0) {
					//System.out.println("Doesn't deleted any row!");
				} else {
					//System.out.println("Deleted	Row: " + row);
				}

				for (int i = 0; i < chargeCodeList.size(); i++) {
					OtSurgeyPaSurgeyDetail surgeyPaSurgeyDetail = new OtSurgeyPaSurgeyDetail();
					MasChargeCode masChargeCode = new MasChargeCode();
					masChargeCode
							.setId(Integer.parseInt(chargeCodeList.get(i)));
					surgeyPaSurgeyDetail.setChargeCode(masChargeCode);
					surgeyPaSurgeyDetail
							.setOtPostAnaesthesiaProcedure(opdPatientDetails);
					hbt.save(surgeyPaSurgeyDetail);
				}
			}

			succesfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}

		return succesfullyAdded;
	}

	public Map<String, Object> printPAC(int hinId) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		Session session = (Session) getSession();
		try {
			inpatientList = session.createCriteria(Inpatient.class)
					.createAlias("Hin", "p").add(
							Restrictions.eq("AdStatus", "A")).add(
							Restrictions.eq("p.Id", hinId)).list();

			if (inpatientList.size() > 0) {
				returnMap.put("PatientStatus", "inpatient");

			} else {
				returnMap.put("PatientStatus", "outpatient");
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnMap;
	}

	public Map<String, Object> getDetailsForSurgeryEnquiry() {

		Map<String, Object> map = new HashMap<String, Object>();

		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		try {
			serviceTypeList = session.createCriteria(MasServiceType.class).add(
					Restrictions.eq("Status", "y")).list();
			rankList = session.createCriteria(MasRank.class).add(
					Restrictions.eq("Status", "y")).list();
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).list();
			stateList = session.createCriteria(MasState.class).add(
					Restrictions.eq("Status", "y")).list();
			districtList = session.createCriteria(MasDistrict.class).add(
					Restrictions.eq("Status", "y")).list();
			wardList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).createAlias(
					"DepartmentType", "dt").add(
					Restrictions.eq("dt.DepartmentTypeName", "Ward")).list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("serviceTypeList", serviceTypeList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("stateList", stateList);
		map.put("districtList", districtList);
		map.put("wardList", wardList);
		return map;
	}

	public Map<String, Object> getSurgeryDetailsForEnquiry(
			Map<String, Object> enquiryMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList1 = new ArrayList<Patient>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();

		String serviceNo = "";
		String hinNo = "";
		int serviceTypeId = 0;
		int rankId = 0;
		int unitId = 0;
		String serPersonFirstName = "";
		String serPersonMiddleName = "";
		String serPersonLastName = "";

		String patientName = "";
		String patientMiddleName = "";
		String patientLastName = "";

		int hinId = 0;
		String address = "";
		int districtId = 0;
		int stateId = 0;
		String adNo = "";
		String patientStatus = "";

		Session session = (Session) getSession();

		if (enquiryMap.get("serviceNo") != null) {
			serviceNo = (String) enquiryMap.get("serviceNo");
		}
		if (enquiryMap.get("hinNo") != null) {
			hinNo = (String) enquiryMap.get("hinNo");
		}
		if (enquiryMap.get("serviceTypeId") != null) {
			serviceTypeId = (Integer) enquiryMap.get("serviceTypeId");
		}
		if (enquiryMap.get("rankId") != null) {
			rankId = (Integer) enquiryMap.get("rankId");
		}
		if (enquiryMap.get("unitId") != null) {
			unitId = (Integer) enquiryMap.get("unitId");
		}

		if (enquiryMap.get("serPersonFirstName") != null) {
			serPersonFirstName = (String) enquiryMap.get("serPersonFirstName");
		}
		if (enquiryMap.get("serPersonMiddleName") != null) {
			serPersonMiddleName = (String) enquiryMap
					.get("serPersonMiddleName");
		}
		if (enquiryMap.get("serPersonLastName") != null) {
			serPersonLastName = (String) enquiryMap.get("serPersonLastName");
		}

		if (enquiryMap.get("patientName") != null) {
			patientName = (String) enquiryMap.get("patientName");
		}
		if (enquiryMap.get("patientMiddleName") != null) {
			patientMiddleName = (String) enquiryMap.get("patientMiddleName");
		}
		if (enquiryMap.get("patientLastName") != null) {
			patientLastName = (String) enquiryMap.get("patientLastName");
		}

		if (enquiryMap.get("hinId") != null) {
			hinId = (Integer) enquiryMap.get("hinId");
		}
		if (enquiryMap.get("address") != null) {
			address = (String) enquiryMap.get("address");
		}
		if (enquiryMap.get("districtId") != null) {
			districtId = (Integer) enquiryMap.get("districtId");
		}
		if (enquiryMap.get("stateId") != null) {
			stateId = (Integer) enquiryMap.get("stateId");
		}
		if (enquiryMap.get("adNo") != null) {
			adNo = (String) enquiryMap.get("adNo");
		}
		if (enquiryMap.get("patientStatus") != null) {
			patientStatus = (String) enquiryMap.get("patientStatus");
		}
		//System.out.println("stateId   " + stateId);

		try {
			Criteria crit = session.createCriteria(Patient.class);

			if (!serviceNo.equals("")) {
				crit = crit
						.add(Restrictions.like("ServiceNo", serviceNo + "%"));
			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.like("HinNo", hinNo + "%"));
			}
			if (!patientName.equals("")) {
				crit = crit.add(Restrictions.like("PFirstName", patientName
						+ "%"));
			}
			if (!patientMiddleName.equals("")) {
				crit = crit.add(Restrictions.like("PMiddleName",
						patientMiddleName + "%"));
			}
			if (!patientLastName.equals("")) {
				crit = crit.add(Restrictions.like("PLastName", patientLastName
						+ "%"));
			}

			if (!serPersonFirstName.equals("")) {
				crit = crit.add(Restrictions.like("SFirstName",
						serPersonFirstName + "%"));
			}
			if (!serPersonMiddleName.equals("")) {
				crit = crit.add(Restrictions.like("SMiddleName",
						serPersonMiddleName + "%"));
			}
			if (!serPersonLastName.equals("")) {
				crit = crit.add(Restrictions.like("SLastName",
						serPersonLastName + "%"));
			}

			if (!address.equals("")) {
				crit = crit.add(Restrictions.eq("Address", address + "%"));
			}
			if (serviceTypeId != 0) {
				crit = crit.createAlias("ServiceType", "st").add(
						Restrictions.eq("st.Id", serviceTypeId));
			}
			if (rankId != 0) {
				crit = crit.createAlias("Rank", "rank").add(
						Restrictions.eq("rank.Id", rankId));
			}
			if (unitId != 0) {
				crit = crit.createAlias("Unit", "unit").add(
						Restrictions.eq("unit.Id", unitId));
			}
			if (districtId != 0) {
				crit = crit.createAlias("District", "dist").add(
						Restrictions.eq("dist.Id", districtId));
			}
			if (stateId != 0) {
				crit = crit.createAlias("State", "state").add(
						Restrictions.eq("state.Id", stateId));
			}
			if (!adNo.equals("")) {
				crit = crit.createAlias("Inpatients", "ip").add(
						Restrictions.eq("ip.AdNo", adNo));
			}
			if (!patientStatus.equals("")) {
				//System.out.println(" patientStatus ===================   "+ patientStatus);
				if (patientStatus.equals("Expired")) {
					crit = crit
							.add(Restrictions.eq("PatientStatus", "Expired"));
				} else if (patientStatus.equals("In Patient")) {
					crit = crit.add(Restrictions.eq("PatientStatus",
							"In Patient"));
				} else if (patientStatus.equals("Out Patient")) {
					crit = crit.add(Restrictions.eq("PatientStatus",
							"Out Patient"));
				}
			}

			patientList = crit.list();
			/*
			 * List objectList=new ArrayList(); for(Patient patient :
			 * patientList1){ objectList.add(patient.getId()); }
			 * //System.out.println
			 * ("objectList::::::::::::"+objectList.toString()); otBookingList =
			 * session.createCriteria(OtBooking.class).createAlias("Hin", "p")
			 * .add(Restrictions.eq("Status", "y")).add(Restrictions.in("p.Id",
			 * objectList)).list();
			 * 
			 * List objectList1=new ArrayList(); for(OtBooking otBooking:
			 * otBookingList){ objectList1.add(otBooking.getHin().getId()); }
			 * 
			 * patientList =
			 * session.createCriteria(Patient.class).add(Restrictions.in("Id",
			 * objectList1)).list();
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("patientList  " + patientList.size());
		map.put("patientList", patientList);

		return map;
	}

	public Map<String, Object> getSurgeryDetails(Box box) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();
		List<OtBookSurgeon> otBookSurgeonList = new ArrayList<OtBookSurgeon>();
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		try {
			String date = (String) utilMap.get("currentDate");
			int hinId = box.getInt("hinNo");

			otBookingList = session.createCriteria(OtBooking.class)
					.createAlias("Hin", "p")
					.add(Restrictions.eq("p.Id", hinId)).add(
							Restrictions.ge("SurgeryDate", HMSUtil
									.convertStringTypeDateToDateType(date)))
					.list();
			List objectList = new ArrayList();
			for (OtBooking otBooking : otBookingList) {
				objectList.add(otBooking.getId());
			}
			if (objectList.size() > 0) {
				otBookSurgeonList = session.createCriteria(OtBookSurgeon.class)
						.add(Restrictions.in("Booking.Id", objectList)).list();
			}

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		returnMap.put("otBookingList", otBookingList);
		returnMap.put("otBookSurgeonList", otBookSurgeonList);

		return returnMap;
	}

	public Map<String, Object> orderSeqChange(Map<String, Object> reqMap) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();
		List<OtBooking> otseqBookingList = new ArrayList<OtBooking>();
		List<OtBookSurgeon> otBookSurgeonList = new ArrayList<OtBookSurgeon>();
		List<MasOt> masOtList = new ArrayList<MasOt>();
		List<OtAnesthesiologist> masAnesList = new ArrayList<OtAnesthesiologist>();
		List<MasEmployee> masEmpList = new ArrayList<MasEmployee>();
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String bookingDate = (String) reqMap.get("bookingDate");
		int bookingId = (Integer) reqMap.get("bookingId");
		int otId = (Integer) reqMap.get("otId");
		int seqId = (Integer) reqMap.get("seqId");
		String bookingTime = (String) reqMap.get("bookingTime");
		try {

			String date = (String) utilMap.get("currentDate");
			otseqBookingList = session.createCriteria(OtBooking.class).add(
					Restrictions.eq("SurgeryDate", HMSUtil
							.convertStringTypeDateToDateType(bookingDate)))
					.add(Restrictions.eq("Ot.Id", otId)).list();

			for (OtBooking otBooking : otseqBookingList) {

				if (otBooking.getSlNo() == seqId - 1) {
					OtBooking otBookingObj = (OtBooking) hbt.load(
							OtBooking.class, otBooking.getId());
					otBookingObj.setSlNo(otBooking.getSlNo() + 1);
					hbt.saveOrUpdate(otBookingObj);
				} else if (otBooking.getSlNo() == seqId) {
					OtBooking otBookingObj = (OtBooking) hbt.load(
							OtBooking.class, otBooking.getId());
					otBookingObj.setSlNo(otBooking.getSlNo() - 1);
					otBookingObj.setSurgeryDate(HMSUtil
							.convertStringTypeDateToDateType(bookingDate));
					// otBookingObj.setSurgeryTime(bookingTime);
					hbt.saveOrUpdate(otBookingObj);
				}
			}

			otBookingList = session.createCriteria(OtBooking.class).add(
					Restrictions.eq("SurgeryDate", HMSUtil
							.convertStringTypeDateToDateType(bookingDate)))
					.add(Restrictions.eq("Ot.Id", otId)).addOrder(
							Order.asc("SlNo")).list();

			List objectList = new ArrayList();
			for (OtBooking otBooking : otBookingList) {
				objectList.add(otBooking.getId());
			}
			if (objectList.size() > 0) {
				otBookSurgeonList = session.createCriteria(OtBookSurgeon.class)
						.add(Restrictions.in("Booking.Id", objectList)).list();
			}

			masOtList = session.createCriteria(MasOt.class).add(
					Restrictions.eq("Status", "y")).list();
			masEmpList = session.createCriteria(MasEmployee.class).createAlias(
					"EmpCategory", "Cat").createAlias("Department", "Dept")
					.add(Restrictions.eq("Cat.EmpCategoryCode", "01")).add(
							Restrictions.eq("Dept.DepartmentCode", "Anaes1"))
					.add(Restrictions.eq("Status", "y")).list();

			masAnesList = session.createCriteria(OtAnesthesiologist.class).add(
					Restrictions.eq("SurgeryDate", HMSUtil
							.convertStringTypeDateToDateType(bookingDate)))
					.list();

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dataMap.put("otBookingList", otBookingList);
		dataMap.put("otBookSurgeonList", otBookSurgeonList);
		dataMap.put("masOtList", masOtList);
		dataMap.put("masEmpList", masEmpList);
		dataMap.put("masAnesList", masAnesList);

		return dataMap;
	}

	public Map<String, Object> getOtListData() {

		Map<String, Object> map = new HashMap<String, Object>();

		List<MasOt> masOtList = new ArrayList<MasOt>();
		Session session = (Session) getSession();
		try {
			masOtList = session.createCriteria(MasOt.class).add(
					Restrictions.eq("Status", "y")).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("masOtList", masOtList);
		return map;
	}

	public Map<String, Object> updateOTChanges(Map<String, Object> reqMap) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();
		List<OtBooking> otseqBookingList = new ArrayList<OtBooking>();
		List<OtBookSurgeon> otBookSurgeonList = new ArrayList<OtBookSurgeon>();
		List<OtAnesthesiologist> masAnesList = new ArrayList<OtAnesthesiologist>();
		List<MasEmployee> masEmpList = new ArrayList<MasEmployee>();

		List<MasOt> masOtList = new ArrayList<MasOt>();
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String bookingDate = (String) reqMap.get("bookingDate");
		int bookingId = (Integer) reqMap.get("bookingId");
		int otId = (Integer) reqMap.get("otId");
		int seqId = (Integer) reqMap.get("seqId");
		String changeCriteria = (String) reqMap.get("changeCriteria");
		try {

			if (changeCriteria.equals("OtName")) {
				List<OtBooking> otexBookingList = new ArrayList<OtBooking>();
				otexBookingList = session.createCriteria(OtBooking.class).add(
						Restrictions.eq("SurgeryDate", HMSUtil
								.convertStringTypeDateToDateType(bookingDate)))
						.add(Restrictions.eq("Ot.Id", otId)).add(
								Restrictions.eq("Id", bookingId)).list();

				if (otexBookingList.size() == 0) {
					OtBooking otBookingObj = (OtBooking) hbt.load(
							OtBooking.class, bookingId);
					int eOtId = otBookingObj.getOt().getId();
					int eseq = otBookingObj.getSlNo();

					otseqBookingList = session
							.createCriteria(OtBooking.class)
							.add(
									Restrictions
											.eq(
													"SurgeryDate",
													HMSUtil
															.convertStringTypeDateToDateType(bookingDate)))
							.add(Restrictions.eq("Ot.Id", eOtId)).add(
									Restrictions.gt("SlNo", eseq)).list();

					for (OtBooking eotBooking : otseqBookingList) {
						OtBooking eotBookingObj = (OtBooking) hbt.load(
								OtBooking.class, eotBooking.getId());
						int eoseq = 0;
						eoseq = eotBookingObj.getSlNo();
						eotBookingObj.setSlNo(eoseq - 1);
						hbt.update(eotBookingObj);
					}
					List<OtBooking> nextotBookingList = new ArrayList<OtBooking>();
					nextotBookingList = session
							.createCriteria(OtBooking.class)
							.add(
									Restrictions
											.eq(
													"SurgeryDate",
													HMSUtil
															.convertStringTypeDateToDateType(bookingDate)))
							.add(Restrictions.eq("Ot.Id", otId)).addOrder(
									Order.desc("SlNo")).list();

					int seq = 0;
					if (nextotBookingList.size() > 0) {
						OtBooking otbooking = (OtBooking) nextotBookingList
								.get(0);
						seq = otbooking.getSlNo() + 1;
					} else {
						seq = 1;
					}

					OtBooking nextotBookingObj = (OtBooking) hbt.load(
							OtBooking.class, bookingId);
					// //System.out.println(":::::::::"+seq);
					nextotBookingObj.setSlNo(seq);
					nextotBookingObj.setOt(new MasOt(otId));
					nextotBookingObj.setSurgeryDate(HMSUtil
							.convertStringTypeDateToDateType(bookingDate));
					hbt.update(nextotBookingObj);
					hbt.refresh(nextotBookingObj);

				}
			} else if (changeCriteria.equals("StandBy")) {
				List<OtBooking> otstandBookingList = new ArrayList<OtBooking>();
				// //System.out.println("::::::::::"+bookingId);
				OtBooking otstBookingObj = (OtBooking) hbt.get(OtBooking.class,
						bookingId);
				// //System.out.println("otstbo:::");
				int stot = 0;
				int stseq = 0;

				stot = otstBookingObj.getOt().getId();

				stseq = otstBookingObj.getSlNo();
				otstBookingObj.setSlNo(0);
				otstBookingObj.setSurgeryDoneStatus("n");
				hbt.update(otstBookingObj);
				otstandBookingList = session
						.createCriteria(OtBooking.class)
						.add(
								Restrictions
										.eq(
												"SurgeryDate",
												HMSUtil
														.convertStringTypeDateToDateType(bookingDate)))
						.add(Restrictions.eq("Ot.Id", stot)).add(
								Restrictions.gt("SlNo", stseq)).list();

				for (OtBooking otBooking : otstandBookingList) {
					OtBooking otstnxBookingObj = (OtBooking) hbt.load(
							OtBooking.class, otBooking.getId());
					otstnxBookingObj.setSlNo(otBooking.getSlNo() - 1);
					hbt.update(otstnxBookingObj);
					hbt.refresh(otstnxBookingObj);
				}
			}
			otBookingList = session.createCriteria(OtBooking.class).add(
					Restrictions.eq("SurgeryDate", HMSUtil
							.convertStringTypeDateToDateType(bookingDate)))
					.add(Restrictions.eq("Ot.Id", otId)).addOrder(
							Order.asc("SlNo")).list();

			List objectList = new ArrayList();
			for (OtBooking otBooking : otBookingList) {
				objectList.add(otBooking.getId());
			}
			if (objectList.size() > 0) {
				otBookSurgeonList = session.createCriteria(OtBookSurgeon.class)
						.add(Restrictions.in("Booking.Id", objectList)).list();
			}
			masOtList = session.createCriteria(MasOt.class).add(
					Restrictions.eq("Status", "y")).list();
			masEmpList = session.createCriteria(MasEmployee.class).createAlias(
					"EmpCategory", "Cat").createAlias("Department", "Dept")
					.add(Restrictions.eq("Cat.EmpCategoryCode", "01")).add(
							Restrictions.eq("Dept.DepartmentCode", "Anaes1"))
					.add(Restrictions.eq("Status", "y")).list();

			masAnesList = session.createCriteria(OtAnesthesiologist.class).add(
					Restrictions.eq("SurgeryDate", HMSUtil
							.convertStringTypeDateToDateType(bookingDate)))
					.list();

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dataMap.put("otBookingList", otBookingList);
		dataMap.put("otBookSurgeonList", otBookSurgeonList);
		dataMap.put("masOtList", masOtList);
		dataMap.put("masEmpList", masEmpList);
		dataMap.put("masAnesList", masAnesList);
		return dataMap;
	}

	public Map<String, Object> submitAnesthesiologist(Map<String, Object> reqMap) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();
		List<OtAnesthesiologist> otAnesList = new ArrayList<OtAnesthesiologist>();
		List<OtBookSurgeon> otBookSurgeonList = new ArrayList<OtBookSurgeon>();
		List<MasOt> masOtList = new ArrayList<MasOt>();
		List<OtAnesthesiologist> masAnesList = new ArrayList<OtAnesthesiologist>();
		List<MasEmployee> masEmpList = new ArrayList<MasEmployee>();

		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String bookingDate = (String) reqMap.get("bookingDate");
		int otId = (Integer) reqMap.get("otId");
		try {

			int dateOfMonth, month, year;
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(HMSUtil
					.convertStringTypeDateToDateType(bookingDate));
			StringBuffer dateOnly = new StringBuffer();
			year = calendar.get(Calendar.YEAR);
			dateOnly.append(year);
			dateOnly.append("/");
			month = calendar.get(Calendar.MONTH) + 1;
			if (month < 10)
				dateOnly.append("0");
			dateOnly.append(month);
			dateOnly.append("/");
			dateOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
			if (dateOfMonth < 10)
				dateOnly.append("0");
			dateOnly.append(dateOfMonth);

			String hql = "delete from jkt.hms.masters.business.OtAnesthesiologist as a where a.SurgeryDate='"
					+ dateOnly + "'";
			Query query = session.createQuery(hql);
			int row = query.executeUpdate();
			if (reqMap.get("otAnesList") != null) {
				otAnesList = (List<OtAnesthesiologist>) reqMap
						.get("otAnesList");
			}
			if (otAnesList != null && otAnesList.size() > 0) {
				for (int i = 0; i < otAnesList.size(); i++) {
					OtAnesthesiologist otAnes = (OtAnesthesiologist) otAnesList
							.get(i);
					hbt.save(otAnes);
					hbt.refresh(otAnes);
				}
			}

			otBookingList = session.createCriteria(OtBooking.class).add(
					Restrictions.eq("SurgeryDate", HMSUtil
							.convertStringTypeDateToDateType(bookingDate)))
					.add(Restrictions.eq("Ot.Id", otId)).addOrder(
							Order.asc("SlNo")).list();

			List objectList = new ArrayList();
			for (OtBooking otBooking : otBookingList) {
				objectList.add(otBooking.getId());
			}
			if (objectList.size() > 0) {
				otBookSurgeonList = session.createCriteria(OtBookSurgeon.class)
						.add(Restrictions.in("Booking.Id", objectList)).list();
			}

			masOtList = session.createCriteria(MasOt.class).add(
					Restrictions.eq("Status", "y")).list();
			masEmpList = session.createCriteria(MasEmployee.class).createAlias(
					"EmpCategory", "Cat").createAlias("Department", "Dept")
					.add(Restrictions.eq("Cat.EmpCategoryCode", "01")).add(
							Restrictions.eq("Dept.DepartmentCode", "Anaes1"))
					.add(Restrictions.eq("Status", "y")).list();

			masAnesList = session.createCriteria(OtAnesthesiologist.class).add(
					Restrictions.eq("SurgeryDate", HMSUtil
							.convertStringTypeDateToDateType(bookingDate)))
					.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dataMap.put("otBookingList", otBookingList);
		// dataMap.put("otBookSurgeonList", otBookSurgeonList);
		dataMap.put("masOtList", masOtList);
		dataMap.put("masEmpList", masEmpList);
		dataMap.put("masAnesList", masAnesList);

		return dataMap;
	}

	public Map<String, Object> getotAnesDetails(Date surDate) {
		Map<String, Object> map = new HashMap<String, Object>();

		// List<MasOt> masOtList = new ArrayList<MasOt>();
		List<OtAnesthesiologist> otAnesList = new ArrayList<OtAnesthesiologist>();
		Session session = (Session) getSession();
		try {
			// masOtList =
			// session.createCriteria(MasOt.class).add(Restrictions.eq("Status",
			// "y")).list();
			otAnesList = session.createCriteria(OtAnesthesiologist.class).add(
					Restrictions.eq("SurgeryDate", surDate)).list();

			String anes = "";
			String pac = "";
			for (OtAnesthesiologist otAnes : otAnesList) {

				if (otAnes.getOt() != null) {
					anes = anes + "  \t" + otAnes.getOt().getOtCode() + " - ";
				} else if (otAnes.getOt() == null
						&& otAnes.getPac().equals("P")) {
					pac = pac + "PAC - ";
				}

				String name = "";
				if (otAnes.getAnes1Id() != null) {

					if (otAnes.getAnes1Id().getFirstName() != null) {
						name = name + otAnes.getAnes1Id().getFirstName();
					}
					if (otAnes.getAnes1Id().getMiddleName() != null) {
						name = name + otAnes.getAnes1Id().getMiddleName();
					}
					if (otAnes.getAnes1Id().getLastName() != null) {
						name = otAnes.getAnes1Id().getLastName();
					}
					if (name.length() > 0) {
						if (otAnes.getOt() != null) {
							anes = anes + name;
						} else if (otAnes.getOt() == null
								&& otAnes.getPac().equals("P")) {
							pac = pac + name;
						}
					}
				}
				String name1 = "";
				if (otAnes.getAnes2Id() != null) {
					if (otAnes.getAnes2Id().getFirstName() != null) {
						name1 = name1 + otAnes.getAnes2Id().getFirstName();
					}
					if (otAnes.getAnes2Id().getMiddleName() != null) {
						name1 = name1 + otAnes.getAnes2Id().getMiddleName();
					}
					if (otAnes.getAnes2Id().getLastName() != null) {
						name1 = otAnes.getAnes2Id().getLastName();
					}

					if (name1.length() > 0) {
						if (otAnes.getOt() != null) {
							if (name.length() > 0) {
								anes = anes + " / " + name1 + "  \t\t\t";
							} else {
								anes = anes + name1 + "  \t\t\t";
							}
						} else if (otAnes.getOt() == null
								&& otAnes.getPac().equals("P")) {
							if (name.length() > 0) {
								pac = pac + " / " + name1;
							} else {
								pac = pac + name1;
							}
						}
					}
				}
			}
			if (pac.length() > 0) {
				anes = anes + "\n\n               \t\t\t\t\t" + pac;
			}
			// //System.out.println("anes::::"+anes);
			map.put("anesData", anes);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	public Map<String, Object> getActualOTPerformedScheduleForDisplay(
			Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		List<OtBooking> otList = new ArrayList<OtBooking>();
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();
		String otBookingDate = "";
		List<OtBooking> otBookingCurrList = new ArrayList<OtBooking>();
		List<MasOt> masOtList = new ArrayList<MasOt>();
		OtBooking otBooking = null;

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String date4MySQL = "";
		try {
			otBookingDate = formatterOut.format(formatterIn.parse(date));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int size = 0;
		String otName = "";
		int nextOt = (Integer) mapForDS.get("nextOt");
		if (nextOt != 0) {
			size = nextOt;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = (Integer) mapForDS.get("deptId");
		try {
			Date otBookingDate1 = HMSUtil
					.convertStringTypeDateToDateType((String) mapForDS
							.get("bookingDate"));
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			masOtList = session.createCriteria(MasOt.class).add(
					Restrictions.eq("Status", "y")).list();

			otBookingList = session.createCriteria(OtBooking.class).add(
					Restrictions.eq("OtBookingStatus", "y")).add(
					Restrictions.eq("SurgeryDate", otBookingDate1)).addOrder(
					Order.asc("SlNo")).list();

			otBookingCurrList = session
					.createQuery(
							"select ot from OtBooking as ot where ot.OtBookingStatus='y' and ot.SurgeryDate= '"
									+ otBookingDate + "'").list();
			int otId = 0;
			if (otBookingList.size() > 0 && otBookingList != null) {
				OtBooking otBooking1 = (OtBooking) otBookingCurrList.get(size);
				otId = otBooking1.getOt().getId();
				otName = otBooking1.getOt().getOtName();
			}

			if (otBookingList.size() > 0) {
				otBooking = (OtBooking) otBookingList.get(size);
				if (otBookingList.size() > size + 1) {
					size = size + 1;
				} else {
					size = 0;
				}
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("otBookingList", otBookingList);
		map.put("otBooking", otBooking);
		map.put("masOtList", masOtList);
		map.put("nextsize", size);
		map.put("otName", otName);
		return map;
	}
	@Override
	public Map<String, Object> getAnesthesiologistForAutoComplete(Map<String, Object> map) {
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		Session session = (Session) getSession();
		try {

			String str = "%" + map.get("autoHint") + "%";

			Criteria crit = session.createCriteria(MasEmployee.class)
					.createAlias("Department", "dept").add(Restrictions.eq("dept.DepartmentName", "Anaesthesia"))
					.add(Restrictions.like("FirstName", str)).add(Restrictions.eq("Status", "y"));

			crit.setFirstResult(0);
			crit.setMaxResults(10);
			empList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("empList", empList);
		return map;
	}
	
	@Override
	public Map<String, Object> displayOtTable(Box box) {
		  Map<String, Object> map = new HashMap<String, Object>();
		List<OtBed> OtBedList = new ArrayList<OtBed>();
		 Session session = (Session) getSession();
		// Calendar now = Calendar.getInstance();
		   // String[] strDays = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		    //String dayName = strDays[now.get(Calendar.DAY_OF_WEEK) - 1];
		   // System.out.println("dayName is : " +dayName);
            int deptId = box.getInt("deptId");
            String bookingDate = (String) box.getString("surgeryDate");
            String startTime = (String) box.getString("startTime");
            String endTime = (String) box.getString("endTime");
		    int otId = 0;
		    otId = box.getInt("otId");
		    String minorOt =box.getString("minorOt");
		    int bedstaus =Integer.parseInt(HMSUtil.getValuesFromPropertiesFile("adt.properties", "bedStatusUnOccupiedId".trim()));
		/*    OtBedList = session.createCriteria(OtBed.class)
		    		.createAlias("Ot", "ot")
		    		.createAlias("Bed", "bed")
		    		.createAlias("Bed.Department", "dept")
		    		.createAlias("bed.BedStatus", "bedStatus")
						.add(Restrictions.eq("bedStatus.Id", bedstaus))
						.add(Restrictions.eq("dept.Id", deptId))
						.add(Restrictions.eq("ot.Id", otId))
		    			.list();*/
		    List<Integer> occupiedBed = new ArrayList<Integer>();
		    
		    if(minorOt!=null&& !minorOt.equalsIgnoreCase("y")){
		    List<OtBooking> otBookingList  = session.createCriteria(OtBooking.class)
		    		.createAlias("Ot", "ot")
		    /*		
		    		.createAlias("Bed", "bed")*/
		    		/*.createAlias("Bed.Department", "dept")
		    		.createAlias("bed.BedStatus", "bedStatus")*/
						.add(Restrictions.eq("SurgeryDate",HMSUtil.convertStringTypeDateToDateType(bookingDate)))
						 .add(Restrictions.or(Restrictions.between("SurgeryStartTime", startTime, endTime) ,Restrictions.between("SurgeryEndTime", startTime, endTime)))
						.add(Restrictions.eq("ot.Id", otId))
						.add(Restrictions.eq("SurgeryStatus", "n"))
		    			.list();
		    for(OtBooking otb: otBookingList)
		    	occupiedBed.add(otb.getBed().getId());
		    }
		    Criteria crit = session.createCriteria(OtBed.class)
		    		.createAlias("Ot", "ot")
		    		.createAlias("Bed", "bed")
		    		//.createAlias("Bed.Department", "dept")
		    		//.createAlias("bed.BedStatus", "bedStatus")
						//.add(Restrictions.eq("dept.Id", deptId))
		    					.add(Restrictions.eq("bed.BedStatus.Id", bedstaus))
						.add(Restrictions.eq("ot.Id", otId));
		    
						if(occupiedBed.size()>0)
							crit.add(Restrictions.not(Restrictions.in("bed.Id", occupiedBed)));
						
						OtBedList = crit.list(); 
		    			
		   

		 map.put("OtBedList", OtBedList);
		return map;
	}

	
	@Override
	public Map<String, Object> displayDepartmentOT(Box box) {
		  Map<String, Object> map = new HashMap<String, Object>();
		List<MasOt> MasOTList = new ArrayList<MasOt>();
		 Session session = (Session) getSession();
		 
		 Date surgeryDate = HMSUtil.convertStringTypeDateToDateType(box.getString("surgeryDate"));
		 
		 Calendar now = Calendar.getInstance();
		 now.setTime(surgeryDate);
		    String[] strDays = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		    String dayName = strDays[now.get(Calendar.DAY_OF_WEEK)-1];
		   //System.out.println("dayName is : " +dayName);
                     
		/*    MasOTList = session.createCriteria(MasOt.class).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
						.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
								//.add(Restrictions.eq("UnitM.Id", box.getInt("unitId")))
									.add(Restrictions.eq("DayName",dayName)).list();*/
		 //System.out.println("otMasUnitDayList=="+otMasUnitDayList.size());
		    MasOTList = session.createCriteria(MasOtDistribution.class)
		    		.createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id", box.getInt("deptId")))
							//.add(Restrictions.eq("UnitM.Id", box.getInt("unitId")))
								.add(Restrictions.eq("Days",dayName)).list();
		    
		 map.put("MasOTList", MasOTList);
		return map;
	}
	
	@Override
	public Map<String, Object> fillMemberForName(Map dataMap) {
	    Session session = (Session) getSession();
	    Map<String, Object> map = new HashMap<String, Object>();
	    List<MasEmployee> eList = new ArrayList<MasEmployee>();
	    String nameMember = null;
	    nameMember = "" + dataMap.get("nameMember");
	    int empId = (Integer)dataMap.get("empId");

	    try {
	        org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	        hbt.setFlushModeName("FLUSH_EAGER");
	        hbt.setCheckWriteOperations(false);
	        
	       /* eList = session.createCriteria(MasEmployee.class)
	        .add(Restrictions.like("FirstName", "%"+nameMember+"%").ignoreCase())
	        .add(Restrictions.eq("Status", "y").ignoreCase()).list();*/
	        
	        eList = session.createCriteria(MasEmployee.class)
	    	        .add(Restrictions.eq("Id", empId))
	    	        .add(Restrictions.eq("Status", "y").ignoreCase()).list();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	   
	    map.put("eList", eList);
	    return map;
	}
	
	@Override
	public Map<String, Object> showCalenderForOt(Map<String, Object> mapForDS) {
		 Session session = (Session) getSession();
		    Map<String, Object> map = new HashMap<String, Object>();
		    List<OtBooking> bookList = new ArrayList<OtBooking>();
		    //List<OtMasUnitDay> otMasUnitDayList=new ArrayList<OtMasUnitDay>();
		    List<MasOt> masOtList = new ArrayList<MasOt>();
		    int hospitalId=(Integer)mapForDS.get(HOSPITAL_ID);
		    //int deptId=(Integer)mapForDS.get(DEPARTMENT_ID);
		    //int empId=(Integer)mapForDS.get("empId");
		    int month=(Integer)mapForDS.get("month");
		    int year=(Integer)mapForDS.get("year");
		    int ot=(Integer)mapForDS.get(OT_ID);
		    Calendar calendar=Calendar.getInstance();
		    calendar.set(Calendar.DAY_OF_MONTH, 1); 
		    calendar.set(Calendar.MONTH, month); 
		    calendar.set(Calendar.YEAR, year);


		    
		   /* SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat f = new SimpleDateFormat("EEEE");
			Date bookingDate=dateFormat.parse("22/09/2015");*/
			
		/*	HospitalDoctorUnitT doctorUnit=(HospitalDoctorUnitT) session.createCriteria(HospitalDoctorUnitT.class)
					.createAlias("UnitM", "um")
			        .add(Restrictions.eq("um.Hospital.Id", hospitalId))
			        .add(Restrictions.eq("Employee.Id", empId))
			        .add(Restrictions.eq("Status", "y").ignoreCase())
			        .setFirstResult(0)
			        .setMaxResults(1).uniqueResult();*/

	/*		   
			otMasUnitDayList=session.createCriteria(OtMasUnitDay.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					//.add(Restrictions.eq("Department.Id", deptId))
					.add(Restrictions.eq("UnitM.Id", doctorUnit!=null?doctorUnit.getUnitM().getId():0))
					//.add(Restrictions.eq("DayName", f.format(bookingDate)))
					.list();
			*/
		/*	Set<String> workingDays=new HashSet<String>();
			for (OtMasUnitDay day : otMasUnitDayList) {
				workingDays.add(day.getDayName());
			}*/
		    
		    List<MasOtDistribution> distributionList  = new ArrayList<MasOtDistribution>();
		    distributionList = session.createCriteria(MasOtDistribution.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					//.add(Restrictions.eq("Department.Id", deptId))
					//.add(Restrictions.eq("UnitM.Id", doctorUnit!=null?doctorUnit.getUnitM().getId():0))
					//.add(Restrictions.eq("DayName", f.format(bookingDate)))
					.list();
		    
		    Set<String> workingDays=new HashSet<String>();
			for (MasOtDistribution day : distributionList) {
				workingDays.add(day.getDays());
			}
	
			Date fromDate=calendar.getTime();
			
			Date toDate=null;
			while (month==calendar.get(Calendar.MONTH)) {
				toDate=calendar.getTime();
				calendar.add(Calendar.DAY_OF_MONTH, 1);
			}
		
			
			Criteria crit = session.createCriteria(OtBooking.class)
				//	.add(Restrictions.in("OtBookingStatus", new String[]{"y","c","d"}))
					.add(Restrictions.between("SurgeryDate",fromDate,toDate));
					
			if(ot!=0)
			{
				crit.createAlias("Ot", "ot")
				.add(Restrictions.eq("ot.Id",ot));
			}
			
			bookList =  crit.list();
			
		
			
			
	  if(bookList.size() >0)
	  {
			 
			List <Integer> bookingIdList = new ArrayList <Integer>();
			for(OtBooking otBooking:bookList)
			{
				bookingIdList.add(otBooking.getId());
			}
			
			List <OtBookSurgeon> OtBookingSurgeon = new ArrayList <OtBookSurgeon>();
			OtBookingSurgeon = session.createCriteria(OtBookSurgeon.class)
					.add(Restrictions.in("Booking.Id", bookingIdList))
					.add(Restrictions.eq("Role", "Surgeon").ignoreCase())
					.list();
			  map.put("OtBookingSurgeon", OtBookingSurgeon);
	  }		
		//	List<Object[]> bookList1 = new ArrayList<Object[]>();
			

			masOtList = session.createCriteria(MasOt.class).add(
							Restrictions.eq("Status", "y")).list();
			
			/*maxAccIdList = session.createCriteria(FaMasAccount.class)
					.createAlias("AccountSubGroup", "subGrp").add(Restrictions.eq("subGrp.Id", accSubGrpId))
					.setProjection(Projections.max("Id"))
					.list();*/
			
		
					/*bookList1 = 	 session.createCriteria(OtBooking.class)
							.add(Restrictions.eq("SurgeryStatus", "y"))
							.setProjection(Projections.projectionList()									
		                            .add(Projections.property("SurgeryDate"))		                           
		                            .add(Projections.count("SurgeryDate"))   
		                            .add(Projections.groupProperty("SurgeryDate"))
		                    ).list();
					Date a = (Date) bookList1.get(0)[0];
					System.out.println(a +"");
	Map<String, String> completedSurgery = new HashMap<String, String>();
	Date surgeryDate =null;
					for(int i =0;i<bookList1.size(); i++)
					{
						surgeryDate = (Date) bookList1.get(i)[0];
						completedSurgery.put(HMSUtil.convertDateToStringTypeDateOnly(surgeryDate),bookList1.get(i)[1].toString());
						//String a = bookList1.get(0)[1].toString();
						//String b = bookList1.get(0)[0].toString();
					}
					*/
			/*System.out.println("hi"+bookList1.get(0)[1].toString());
			System.out.println("hi"+bookList1.get(0)[0].toString());
			System.out.println("hi"+bookList1.get(0));
			System.out.println("hi"+bookList1.get(0)==null);
			System.out.println("hi="+bookList1.get(0)[0].toString());
			Integer status =(Integer)(bookList1.get(0)[1]);*/
		    	  
		    map.put("bookList", bookList);
		  //  map.put("otMasUnitDayList", otMasUnitDayList);
		    map.put("workingDays", workingDays);
		    map.put("masOtList", masOtList);
		    
		    //map.put("completedSurgery", completedSurgery);
		    
		    
		    
		    
		return map;
	}
	
	@Override
	public Map<String, Object> checkSurgeryTime(Map<String, Object> mapForDS) {
		 Session session = (Session) getSession();
		    Map<String, Object> map = new HashMap<String, Object>();
		    List<OtBooking> bookList = new ArrayList<OtBooking>();
		    List<MasOt> masOtList = new ArrayList<MasOt>();
		    //int hospitalId=(Integer)mapForDS.get(HOSPITAL_ID);
		    boolean matched = false;
		    int otBookingId = 0;
		    String StartTime = (String) mapForDS.get("startTime");
		    String endTime = (String)mapForDS.get("endTime");
		    String surgeryDate = (String)mapForDS.get("surgeryDate");
		    if(mapForDS.get("otBookingId")!=null)
		    {
		    	otBookingId = (Integer)mapForDS.get("otBookingId");
		    }
		    
		   // Date DateStartTime = HMSUtil.convertStringToTime(StartTime);
		    //Date DateEndTime = HMSUtil.convertStringToTime(endTime);
		    
		    bookList = session.createCriteria(OtBooking.class)
	            .add(Restrictions.ne("Id",otBookingId))
		         .add(Restrictions.eq("SurgeryDate",HMSUtil.convertStringTypeDateToDateType(surgeryDate)))
		           .add(Restrictions.or(Restrictions.between("SurgeryStartTime", StartTime, endTime) ,Restrictions.between("SurgeryEndTime", StartTime, endTime)))
					.list();
		    
		    if( bookList.size()>0)
		    {
		    	matched = true;
		    	  map.put("bookList", bookList.get(0));
		    } 
		  
		    map.put("matched", matched);
		    
		    
		    
		return map;
	}
	
	@Override
	public Map<String, Object> PACClearanceListForConsultation(Map<String, Object> mapForDS) {
		 Session session = (Session) getSession();
		    Map<String, Object> map = new HashMap<String, Object>();
		    List<PreAnesthesiaConsultDoctorHd> requestList = new ArrayList<PreAnesthesiaConsultDoctorHd>();
		    List<MasOt> masOtList = new ArrayList<MasOt>();
		    int hospitalId = (Integer)mapForDS.get(HOSPITAL_ID);
		    int deptId = (Integer)mapForDS.get("deptId");
		   // int docId = (Integer)mapForDS.get("docId");
		    
		    List<PreAnesthesiaConsultDoctorDt> result = session.createCriteria(PreAnesthesiaConsultDoctorDt.class)
					   //.createAlias("ConsultDoctorIdHd.OtPreAnesthesiaHd", "pachd")
					   //.createAlias("pachd.OpdSurgeryHeader", "surgeryHeader")
					    .createAlias("ConsultedDepartment", "dept")
					    .add(Restrictions.eq("dept.Id",deptId))
					    //.createAlias("ConsultDoctorIdHd.Hospital", "hospital")
					   // .createAlias("ConsultedDoctor", "emp")
					  //  .add(Restrictions.ne("surgeryHeader.Status", "y").ignoreCase())
					    .createAlias("ConsultDoctorIdHd", "consulthd")
					    .add(Restrictions.isNotNull("consulthd.OtPreAnesthesiaHd"))
					    .add(Restrictions.or(Restrictions.isNull("DoctorAdvice"), Restrictions.eq("DoctorAdvice","") ))
					   // .add(Restrictions.eq("hospital.Id",hospitalId))
					  // .add(Restrictions.eq("emp.Id",docId))
					   	/*   .setProjection(Projections.projectionList()
							   .add(Projections.groupProperty("ConsultDoctorIdHd")))
							   .setResultTransformer(Transformers.aliasToBean(PreAnesthesiaConsultDoctorHd.class))*/
					.list();

		    
		    Set<Integer> consultDocHdIdList = new HashSet<Integer>();
		    for(PreAnesthesiaConsultDoctorDt consultdt: result){
		    	if(consultdt.getConsultDoctorIdHd()!=null)
		    	consultDocHdIdList.add(consultdt.getConsultDoctorIdHd().getId());
		    }
		    
		   if(consultDocHdIdList!=null && consultDocHdIdList.size() >0)
		   {
		    requestList = session.createCriteria(PreAnesthesiaConsultDoctorHd.class)
					   .add(Restrictions.in("Id",consultDocHdIdList)).list();
		   }
		   
		   Set<Integer> anesHdID = new HashSet<Integer>();
		   
		   for(PreAnesthesiaConsultDoctorHd CDhd :requestList){
			   anesHdID.add(CDhd.getOtPreAnesthesiaHd().getId());
			   
		   }
		   
		    if(requestList.size()>0){
		    	List<OtPreAnesthesiaHd> pacDt = session.createCriteria(OtPreAnesthesiaHd.class).add(Restrictions.in("Id", anesHdID)).list();
			    map.put("pacDt", pacDt);
				//procedureDetails.clear();
			}
		    
			  if(requestList.size()>0){
					List<OtPreAnesthesiaDetail > otPreAnesthesiaSurgery = new ArrayList<OtPreAnesthesiaDetail>();
					List<String > otPreAnesthesiaProcedureList = new ArrayList<String>();
				  for(PreAnesthesiaConsultDoctorHd preCHD: requestList)
				  {
					  String proc ="";
				  otPreAnesthesiaSurgery = session.createCriteria(
							OtPreAnesthesiaDetail.class)
							//.createAlias("OpdSurgeryHeader", "OpdSurgeryHeader")
							.add(Restrictions.eq("AnesthesiaHd.Id",preCHD.getOtPreAnesthesiaHd().getId()))
							.list();
				     
					  int i = 1;
					  for(OtPreAnesthesiaDetail preADT:otPreAnesthesiaSurgery)
					  {
					
						  if(i++>1)
							  proc +=" | ";
						      proc += preADT.getOpdSurgeryDetail().getChargeCode().getChargeCodeName();
						   
					  }
					  otPreAnesthesiaProcedureList.add(proc);
				  }
				  
					map.put("otPreAnesthesiaProcedureList", otPreAnesthesiaProcedureList);
				}
		    
		    
		    
		   //System.out.println("ff "+requestList.size());
		   
		  /* for (Object[] obj : result) {
		        //DownloadState downloadState = (DownloadState) obj[0];
		        //stateMap.put(downloadState.getDescription().toLowerCase() (Integer) obj[1]);
		    }*/
		   
	    //List<Integer> consultDocHdIdList =null;
		    
/*		    for(PreAnesthesiaConsultDoctorDt re: result)
		    {
		    	System.out.println(re.getConsultDoctorIdHd());
		    }
		    */
		    
		    
		  /*  List<Integer> ConsultDoctorIdHd = new ArrayList<Integer>(new HashSet());
		    for(PreAnesthesiaConsultDoctorDt doctdt: requestList)
			{
		    	ConsultDoctorIdHd.add(doctdt.getConsultDoctorIdHd().getId());
			}
		    
		    List<PreAnesthesiaConsultDoctorHd> ConsultDoctorIdHdList = new ArrayList<PreAnesthesiaConsultDoctorHd>();
		    if(ConsultDoctorIdHd.size()>0){
		    	ConsultDoctorIdHdList = session.createCriteria(PreAnesthesiaConsultDoctorHd.class).add(Restrictions.in("Id", ConsultDoctorIdHd)).list();
				//procedureDetails.clear();
			}
		    
		    if(ConsultDoctorIdHdList.size()>0){
		    	List<OtPreAnesthesiaDetail> pacDt = session.createCriteria(OtPreAnesthesiaDetail.class).add(Restrictions.eq("AnesthesiaHd.Id", ConsultDoctorIdHdList.get(0).getOtPreAnesthesiaHd().getId())).list();
			    map.put("pacDt", pacDt);
				//procedureDetails.clear();
			}
		    
		    
		    
		    
		    System.out.println("dt "+requestList.size() +" hd "+ ConsultDoctorIdHdList.size());
		    requestList = session.createCriteria(PreAnesthesiaConsultDoctorDt.class)
					   .createAlias("ConsultDoctorIdHd", "hd")
					   .createAlias("hd.OpdSurgeryHeader", "surgeryHeader")
					    .createAlias("hd.Hospital", "hospital")
					    .createAlias("ConsultedDoctor", "emp")
					    .add(Restrictions.ne("surgeryHeader.PacStatus", "cleared").ignoreCase())
					    .add(Restrictions.or(Restrictions.isNull("DoctorAdvice"), Restrictions.eq("DoctorAdvice","") ))
					   .add(Restrictions.eq("hospital.Id",hospitalId))
					   .add(Restrictions.eq("emp.Id",docId))
					.list();
		    
		    map.put("requestList", ConsultDoctorIdHdList);
		    */
		   map.put("requestList", requestList);
		return map;
	}
	
	@Override
	public Map<String, Object> showPreAnethesiaFormForAdvice(Map<String, Object> mapForDS) {
		 Session session = (Session) getSession();
		    Map<String, Object> map = new HashMap<String, Object>();
		    List<PreAnesthesiaConsultDoctorDt> requestList = new ArrayList<PreAnesthesiaConsultDoctorDt>();
		    List<MasOt> masOtList = new ArrayList<MasOt>();
		    int hospitalId = (Integer)mapForDS.get(HOSPITAL_ID);

		    int deptId = (Integer)mapForDS.get("deptId");
		  //  int docId = (Integer)mapForDS.get("docId");
		    int surgeryId = (Integer)mapForDS.get("deptId");
		    
	
		    requestList = session.createCriteria(PreAnesthesiaConsultDoctorDt.class)
					   .createAlias("ConsultDoctorIdHd", "hd")
					    .createAlias("hd.Hospital", "hospital")
					     .createAlias("ConsultedDepartment", "dept")
					   // .createAlias("ConsultedDoctor", "emp")
					   .add(Restrictions.eq("hospital.Id",hospitalId))
					   //.add(Restrictions.eq("emp.Id",docId))
					   .add(Restrictions.eq("dept.Id",deptId))
					.list();
		    

		    
		    map.put("requestList", requestList);
		    
		return map;
	}

	
	@Override
	public boolean submitDoctorAdviceForPACClearance(Map<String, Object> mapForDS) {
		 Session session = (Session) getSession();
		    Map<String, Object> map = new HashMap<String, Object>();
		    List<PreAnesthesiaConsultDoctorDt> requestList = new ArrayList<PreAnesthesiaConsultDoctorDt>();
		    List<MasOt> masOtList = new ArrayList<MasOt>();
		    int hospitalId = (Integer)mapForDS.get(HOSPITAL_ID);
		    int surgeryId = (Integer)mapForDS.get("surgeryId");
		    String doctorAdvice = (String)mapForDS.get("doctorAdvice");
		    List<Integer> dtIdList = new ArrayList<Integer>();
		    List<String> adviceList = new ArrayList<String>();
		    boolean succesfullyAdded = false;
			Transaction tx = null;	
			int deptId = (Integer)mapForDS.get("deptId");
		    int docId = (Integer)mapForDS.get("docId");
		    requestList = session.createCriteria(PreAnesthesiaConsultDoctorDt.class)
					   .createAlias("ConsultDoctorIdHd", "hd")
					   	   .createAlias("hd.OtPreAnesthesiaHd", "pacHd")
					    .createAlias("hd.Hospital", "hospital")
					   .add(Restrictions.eq("hospital.Id",hospitalId))
					   .add(Restrictions.eq("pacHd.Id",surgeryId))
					    .createAlias("ConsultedDepartment", "dept")
					    .add(Restrictions.eq("dept.Id",deptId))
					     /*  .createAlias("ConsultedDoctor", "emp")
					   .add(Restrictions.eq("emp.Id",docId))*/
					   .addOrder(Order.desc("ConsultDate"))
					   .addOrder(Order.desc("ConsultTime")).
					   
					   setMaxResults(1)
					.list();
		
		   if(requestList.size() >0)
		   {
			
			   
			 //  System.out.println(docId +" " +surgeryId);
			   int consultDtId = requestList.get(0).getId();
			   try {
				   dtIdList =(List<Integer>) mapForDS.get("dtIdList");
				   adviceList =(List<String>) mapForDS.get("adviceList");
				   MasEmployee masEmp =new MasEmployee();
				   masEmp.setId(docId);
				 
					tx = session.beginTransaction();
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					
					int j=0;
					   for(int i:dtIdList)
					   {
						   PreAnesthesiaConsultDoctorDt consultDt = (PreAnesthesiaConsultDoctorDt) hbt.load(
								   PreAnesthesiaConsultDoctorDt.class, i);
						   consultDt.setDoctorAdvice(adviceList.get(j));
						   consultDt.setConsultationRecBy(masEmp);
							 hbt.update(consultDt);
							 j++;
					   }
					
				/*	 PreAnesthesiaConsultDoctorDt consultDt = new PreAnesthesiaConsultDoctorDt();
					 consultDt = (PreAnesthesiaConsultDoctorDt) hbt.load(
							   PreAnesthesiaConsultDoctorDt.class, consultDtId);
					 
					 consultDt.setDoctorAdvice(doctorAdvice);
					 hbt.update(consultDt);*/
						
					 List <OtPreAnesthesiaDetail> paclist = new ArrayList<OtPreAnesthesiaDetail>();
					 paclist =  session.createCriteria(OtPreAnesthesiaDetail.class)
							.createAlias("AnesthesiaHd", "pacHd")
							.add(Restrictions.eq("pacHd.Id", surgeryId))
							.list();
					
					 for(OtPreAnesthesiaDetail pacDetail : paclist)
					 {
						 OpdSurgeryDetail surgeryDetail = null;
						 surgeryDetail = (OpdSurgeryDetail) hbt.load(
								  OpdSurgeryDetail.class, paclist.get(0).getOpdSurgeryDetail().getId());
						 surgeryDetail.setAnestheisaPacStatus("CR");
						  hbt.update(surgeryDetail);
					 }
					 
				/*	 OpdSurgeryHeader surgeryHeader = null;
					  surgeryHeader = (OpdSurgeryHeader) hbt.load(
					  OpdSurgeryHeader.class, surgeryId);
					  
					  
					  
					  surgeryHeader.setPacStatus("Consultation Received");
					  hbt.update(surgeryHeader);*/
						
		            tx.commit();
		        	 succesfullyAdded = true;
		        	 
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					e.printStackTrace();

				} finally {
					// --------Session Closing----------
					session.close();
				}
			  
		   }
			
		   return succesfullyAdded;
		  
		
	}
	
	
	@Override
	public Map<String, Object> getAnesthesiaRecordWaitingList(Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		//List<OpdSurgeryHeader> pacList = new ArrayList<OpdSurgeryHeader>();
		List<OtBooking> otList = new ArrayList<OtBooking>();
		List<MasOt> masOtList = new ArrayList<MasOt>();
		Map<String, Object> map = new HashMap<String, Object>();

		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		   //String hin="";
		   String empId = "";
		   int otId = 0;
	        String pName="";
	        Date surgeryDate =null;
		
	     /*   if(mapForDS.get(HIN_NO)!=null)
			{
				hin = (String)mapForDS.get(HIN_NO);
			}*/
			
			if(mapForDS.get(PATIENT_NAME)!=null)
			{
				pName = (String)mapForDS.get(PATIENT_NAME);
			}
					
			if(mapForDS.get(EMPLOYEE_ID)!=null)
			{
				empId = (String)mapForDS.get(EMPLOYEE_ID);
			}

			if(mapForDS.get(OT_ID)!=null)
			{
				otId = (Integer)mapForDS.get(OT_ID);
			}
	        
			if(mapForDS.get(SURGERY_DATE)!=null)
			{
				surgeryDate = HMSUtil
						.convertStringTypeDateToDateType(mapForDS.get(SURGERY_DATE).toString());
			}
	        
	//	String patientStatus = "Cleared";
		String otBookingStatus = "y";
		try {
			/*pacList = session.createCriteria(OpdSurgeryHeader.class).add(
					Restrictions.eq("PacStatus", patientStatus)).list();*/
			String []surgery_status = {"n", "y"};
			masOtList = session.createCriteria(MasOt.class).add(
					Restrictions.eq("Status", "y")).list();
			 Criteria  criteria = session.createCriteria(OtBooking.class)
					       		    .createAlias("Hin", "patient")
					       			//.add(Restrictions.eq("OtBookingStatus", otBookingStatus).ignoreCase())
					       		     .add(Restrictions.in("SurgeryStatus", surgery_status))
			 .add(Restrictions.eq("OtPreAnesthesiaStatus", "y").ignoreCase());
	
			
			if(!pName.equals(""))
			{
				criteria.add(Restrictions.like("patient.PFirstName", pName.toLowerCase()+"%").ignoreCase());
			}
			
			
			if(empId!="")
			{
				criteria.add(Restrictions.eq("patient.ServiceNo", empId));
			}
			
			
			if(otId!=0)
			{
				criteria.createAlias("Ot", "ot");
				criteria.add(Restrictions.eq("ot.Id", otId));
			}

			if(surgeryDate!=null)
			{
				criteria.add(Restrictions.eq("SurgeryDate", surgeryDate));
			}
			otList = criteria.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		//System.out.println("u rin pac clearance list method with list size----"+ pacList.size() +" "+otList.size() );
	/*	map.put("pacList", pacList);*/
		map.put("masOtList", masOtList);
		map.put("recordList", otList);
		return map;
	}
	

	
	@Override
	public List<UploadDocuments> getDocumentList(int uploadedDocumentId) {
		List<UploadDocuments> uploadDocuments = new ArrayList<UploadDocuments>();
		
		Session session = (Session) getSession();
		Criteria crit = null;
		uploadDocuments = session.createCriteria(UploadDocuments.class)
				.add(Restrictions.eq("Id", uploadedDocumentId))
				.addOrder(Order.asc("UploadDate"))
				.list();
		return uploadDocuments;
	}
	
	@Override
	public Map<String, Object> searchPreOperativeCheckList(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OtBooking> patientList = new ArrayList<OtBooking>();
		List<MasOt> masOtList = new ArrayList<MasOt>();
		
		Session session = (Session) getSession();

		   String empId = "";
		   int otId = 0;
	        String pName="";
	        Date surgeryDate =null;
		
			int hospitalId = 0;
			if (mapForDS.get(HOSPITAL_ID) != null) {
				hospitalId = (Integer)mapForDS.get(HOSPITAL_ID);
			}
			
	        
			if(mapForDS.get(PATIENT_NAME)!=null)
			{
				pName = (String)mapForDS.get(PATIENT_NAME);
			}
					
			if(mapForDS.get(EMPLOYEE_ID)!=null)
			{
				empId = (String)mapForDS.get(EMPLOYEE_ID);
			}

			if(mapForDS.get(OT_ID)!=null)
			{
				otId = (Integer)mapForDS.get(OT_ID);
			}
	        
			if(mapForDS.get(SURGERY_DATE)!=null)
			{
				surgeryDate = HMSUtil
						.convertStringTypeDateToDateType(mapForDS.get(SURGERY_DATE).toString());
				
			}
	
		Criteria crit =null;
		List<String>aList=new ArrayList<String>();
		aList.add("A");
		aList.add("R");
		aList.add("O");
		crit=
				session.createCriteria(OtBooking.class)
				.createAlias("Hospital", "h")
				.createAlias("Hin", "hin")
				.createAlias("Inpatient", "ip",CriteriaSpecification.LEFT_JOIN)
				.add(Restrictions.eq("h.Id", hospitalId))
				.add(Restrictions.or(Restrictions.isNotNull("Visit"), Restrictions.in("ip.AdStatus", aList)))
//				.add(Restrictions.in("ip.AdStatus", aList))
				//.createAlias("OpdSurseryHeader", "osh")
				//.add(Restrictions.eq("OtBookingStatus", "y").ignoreCase())
				.add(Restrictions.eq("SurgeryStatus", "n").ignoreCase())
				.add(Restrictions.eq("OtPreAnesthesiaStatus", "y").ignoreCase())
				//.add(Restrictions.eq("osh.PacStatus", "cleared").ignoreCase());
	;
			/*	if(otProcedure.equalsIgnoreCase("yes"))
				{
					crit.add( Restrictions.eq("SurgeryStatus", "y").ignoreCase());
					crit.add(Restrictions.eq("OtPostAnethesiaStatus", "y").ignoreCase());
					crit.add(Restrictions.or(Restrictions.isNull("OtNoteProcedureStatus"), Restrictions.eq("OtNoteProcedureStatus", "n").ignoreCase()));

				}
				else if(otProcedure.equalsIgnoreCase("no"))
				{
					crit.add(Restrictions.or(Restrictions.isNull("SurgeryStatus"), Restrictions.eq("SurgeryStatus", "n").ignoreCase()));

				}*/
				//crit.setProjection(Projections.projectionList().add(Projections.property("OpdSurseryHeader")));
		

		if(!pName.equals(""))
		{
			crit.add(Restrictions.like("hin.PFirstName", pName.toLowerCase()+"%").ignoreCase());
		}
		
		
		if(empId!="")
		{
			crit.add(Restrictions.eq("hin.ServiceNo", empId));
		}
		
		if(otId!=0)
		{
			crit.createAlias("Ot", "ot")
			.add(Restrictions.eq("ot.Id",otId));
		}

		if(surgeryDate!=null)
		{
			crit.add(Restrictions.eq("SurgeryDate", surgeryDate));
		}
		patientList = crit.list();
		


		masOtList = session.createCriteria(MasOt.class).add(
						Restrictions.eq("Status", "y")).list();
		
		map.put("recordList", patientList);
		map.put("masOtList", masOtList);
		return map;

	}
	
	
	@Override
	public Map<String, Object> showPreOperativeCheckListEntryJsp(
			Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		List<OtBooking> patientDetailList = new ArrayList<OtBooking>();
		List<OtBookSurgeon> surgeonList = new ArrayList<OtBookSurgeon>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<OtBookingDt> OtBookingDtList = new ArrayList<OtBookingDt>();
		  List<Integer> itemConversionList = (List) mapForDS.get("itemConversionList");
		  
		/*List<MasRelation> relationList = new ArrayList<MasRelation>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();*/
		Map<String, Object> map = new HashMap<String, Object>();
		/*String hinNo = "";
		if (mapForDS.get("hinNo") != null) {
			hinNo = (String) mapForDS.get("hinNo");
		}*/
		
		int bookingId = 0;
	
		if (mapForDS.get("bookingId") != null) {
			bookingId = (Integer) mapForDS.get("bookingId");
		}
		
		
		surgeonList = session.createCriteria(OtBookSurgeon.class)
				.createAlias("Booking", "Booking")
				.add(Restrictions.eq("Booking.SurgeryStatus", "n").ignoreCase())
				.add(Restrictions.eq("Booking.Id", bookingId))
				.list();
		patientDetailList = session.createCriteria(OtBooking.class)
				.add(Restrictions.eq("Id", bookingId)).list();

		frequencyList = session.createCriteria(MasFrequency.class).add(
							Restrictions.eq("Status", "y")).list();
		itemConversionList = session.createCriteria(MasStoreItemConversion.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ItemUnitName")).list();
		if(patientDetailList!=null && patientDetailList.size()>0)
		{
			//int opdSurgeryId =0;
			String anesthesiaDetails = null;
		//	opdSurgeryId = patientDetailList.get(0).getp;
			OtBookingDtList = session.createCriteria(OtBookingDt.class).add(
				Restrictions.eq("OtBookingHd.Id", patientDetailList.get(0).getId())).list();
		if(OtBookingDtList.size() > 0)
		{
			anesthesiaDetails = OtBookingDtList.get(0).getOtPreAnesthesiaDetail().getAnesthesiaHd().getAnashteicDetails();
			/*anesthesiaDetails = OtBookingDtList.get(0).getOtPreAnesthesiaDetail();*/
			map.put("anesthesiaDetails",anesthesiaDetails);
			
			
			
			if(patientDetailList.size() >0 && patientDetailList.get(0).getHin()!=null)
			{
				List<DischargeIcdCode>icdList=new ArrayList<DischargeIcdCode>();
				icdList=session.createCriteria(DischargeIcdCode.class).add(Restrictions.eq("Hin.Id", patientDetailList.get(0).getHin().getId())).list();
				
				Set<MasIcd> uniqueIcdList=new HashSet <MasIcd>();
				for(DischargeIcdCode icd2:icdList){
					MasIcd masIcd = icd2.getIcd();
					if(icd2.getIcd()!=null){
						uniqueIcdList.add(masIcd);
						
					}
				}
				
				String icd="";
				for(MasIcd icd2:uniqueIcdList){
					icd=icd+"\n"+icd2.getIcdName();
				}
				
				map.put("icd", icd);
			}
			
		}
		
		}
		map.put("frequencyList", frequencyList);	
		map.put("patientDetailList", patientDetailList);
		map.put("surgeonList", surgeonList);
		map.put("itemConversionList", itemConversionList);
		
		return map;

	}
	
	
	public Map<String, Object> submitPreOperativeCheckList(Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		//Map<String, Object> mapForDS = new HashMap<String, Object>();
		// ------- variables declaration-------
		boolean dataSaved = false;
		//Vector dose = box.getVector("dose");
		//Vector route = box.getVector("route");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		String userName = "";
		if (mapForDS.get("userName") != null) {
			userName = (String) mapForDS.get("userName");
		}
		
		Box box = (Box) mapForDS.get("box");
		
		int opdSurgeryHeaderId = box.getInt("opdSurgeryHeaderId");
		
		int hinId = box.getInt("hinId");
		int orderNo = box.getInt("orderNo");
		int visitId = box.getInt(VISIT_ID);
		int inpatientId = box.getInt(INPATIENT_ID);

		int bookingId = box.getInt("bookingId");
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		String preOperativeAdvice = box.getString("preOperativeAdvice");
		String remarks = box.getString("remarks");
		String yearlySrNo = box.getString("yearlySqNo");
		String monthlySrNo = box.getString("monthlySqNo");
		
		//List<Integer> itemIdList = (List<Integer>) mapForDS.get("itemIdList");
		//List<Integer> frequencyList = (List) mapForDS.get("frequencyList");
		//List<String> otherMedicineList = (List) mapForDS.get("otherMedicineList");
		//List<String> nomenclatureList =  (List) mapForDS.get("nomenclatureList");
		//List<Integer> itemConversionList = (List) mapForDS.get("itemConversionList");
		//List<String> ctList = (List) mapForDS.get("ctList");

		//List<String> dosageList = (List) mapForDS.get("dosageList");
		
		//List<String> routeList = new ArrayList<String>();
		//routeList= (List) mapForDS.get("routeList");
		//List<Integer> totalList = (List) mapForDS.get("totalList");
		//List<Integer> noOfDaysList = (List) mapForDS.get("noOfDaysList");
		//List<String> remarksList = (List) mapForDS.get("remarksList");
		
		String consultationTime = (String) box.get("currentTime");
		String consultationDate = (String) box.get("currentDate");
		Date consultationDateToInsert = HMSUtil
				.convertStringTypeDateToDateType(consultationDate);
		int departmentId = (Integer) mapForDS.get("deptId");
		int empId = 0;
		empId = (Integer) mapForDS.get("empId");
		int userId = (Integer) mapForDS.get(USER_ID);
		Users user = new Users();
		user.setId(userId);
		
		
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		

		MasEmployee employee = new MasEmployee();
		employee.setId(empId);
		

		Patient patient = new Patient();
		patient.setId(hinId);
		
		// ------ business logic-------
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		OtBooking otBooking =null;
		if (bookingId != 0) {
			 otBooking = new OtBooking();
			otBooking.setId(bookingId);
		}
		

		try {
		
			tx = session.beginTransaction();
			//OtPreAnaesthesiaProcNotesMain otPreAnaesthesiaProcNotesMain = new OtPreAnaesthesiaProcNotesMain();

		/*	otPreAnaesthesiaProcNotesMain.setHin(patient);
			otPreAnaesthesiaProcNotesMain
					.setPreOperativeAdvice(preOperativeAdvice);
			otPreAnaesthesiaProcNotesMain.setRemarks(remarks);
			otPreAnaesthesiaProcNotesMain.setYearlySerialNo(yearlySrNo);
			otPreAnaesthesiaProcNotesMain.setMonthlySerialNo(monthlySrNo);
			otPreAnaesthesiaProcNotesMain.setOrderNo(orderNo);
			if (hospitalId != 0) {
				otPreAnaesthesiaProcNotesMain.setHospital(masHospital);
			}
			if (bookingId != 0) {
				otPreAnaesthesiaProcNotesMain.setBooking(otBooking);
			}
			if (visitId != 0) {
				Visit otvisit = new Visit();
				otvisit.setId(visitId);
				otPreAnaesthesiaProcNotesMain.setVisit(otvisit);
			}

			otPreAnaesthesiaProcNotesMain.setLastChgBy(user);
			otPreAnaesthesiaProcNotesMain.setLastChgDate(date);
			otPreAnaesthesiaProcNotesMain.setLastChgTime(time);
			hbt.save(otPreAnaesthesiaProcNotesMain);*/
			
/*			int opHiddenValue = box.getInt("opHiddenValue");
		
			
			if(opHiddenValue>0)
			{
				List<OtPreOpInstruction> opInstructionList = new ArrayList<OtPreOpInstruction>();
				
				for(int i=1; i<= opHiddenValue;i++)
				{
					if(box.getString("opInstruction" +i)!=null && !box.getString("opInstruction" +i).isEmpty())
					{
						OtPreOpInstruction opInstruction = new OtPreOpInstruction();
						opInstruction.setOtPreAnaesthesiaProcNotesMain(otPreAnaesthesiaProcNotesMain);
						opInstruction.setPreOpInstruction(box.getString("opInstruction" +i));
						opInstructionList.add(opInstruction);
					}
				}
				
				hbt.saveOrUpdateAll(opInstructionList);
			}
				*/
			
			
			
		/*	if (mapForDS.get("empIdList") != null) {
				List empIdList = (List) mapForDS.get("empIdList");
				List<String> roleList = (List) mapForDS.get("roleList");
				//Iterator itr = empIdList.iterator();
				//while (itr.hasNext()) {
				
				List<OtBookSurgeon> otSurgeonList = session.createCriteria(OtBookSurgeon.class).add(
						Restrictions.like("Booking.Id", bookingId)).list();
				
				List<Integer>surgeonBookingIdList =  new ArrayList<Integer> ();
				  for(OtBookSurgeon bookingSurgeon:otSurgeonList)
				  {
					  surgeonBookingIdList.add(bookingSurgeon.getId());  
				  }
				
				  //DgOrderdt
				  
				  if(surgeonBookingIdList.size() >0)
				  {
				  
				   List<OtBookSurgeon> bookingSurgeonList = new ArrayList<OtBookSurgeon>();
			
				   bookingSurgeonList = session.createCriteria(OtBookSurgeon.class)
							.add(Restrictions.in("Id", surgeonBookingIdList)).list();
				
					if(bookingSurgeonList.size() > 0)
					{					
						hbt.deleteAll(bookingSurgeonList);					
					}
				
				  }
	
				for(int i=0;i<empIdList.size();i++){
				
					int empId1 = Integer.parseInt(empIdList.get(i).toString());
					OtBookSurgeon otBookSurgeon = new OtBookSurgeon();
					otBookSurgeon.setBooking(otBooking);
					MasEmployee masEmployee2 = new MasEmployee();
					masEmployee2.setId(empId1);
					otBookSurgeon.setEmployee(masEmployee2);
					otBookSurgeon.setOrderNo(box.getInt("orderNo"));
					
					String role=roleList.get(i).toString();
					otBookSurgeon.setRole(role);
					
					hbt.save(otBookSurgeon);
				}
			}*/
			
			/*PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();
			int item_class_id = 0;
			
			if(itemIdList.size() > 0){
				patientPrescriptionHeader.setHin(patient);
				patientPrescriptionHeader.setDepartment(masDepartment);
				Visit visit = new Visit();
				visit.setId(visitId);
				patientPrescriptionHeader.setVisit(visit);
			
				patientPrescriptionHeader.setHospital(masHospital);
				patientPrescriptionHeader.setStatus("p");
				patientPrescriptionHeader
						.setPrescriptionDate(consultationDateToInsert);
				patientPrescriptionHeader.setPrescriptionTime(consultationTime);
				patientPrescriptionHeader.setEmp(employee);
						
				Map<String, Object> adMap = new HashMap<String, Object>();
			      adMap.put("tableObjectName", "PATIENT_PRESCRIPTION_HEADER");            
		            adMap.put("isHospitalWise", "y");
		            adMap.put("hospitalId", 1);
		            adMap.put("isYearly", "n");            
		            adMap.put("isMonthly", "n");
		            adMap.put("isPrefix", "n");
		
		            int prescriptionNo = Integer.parseInt(HMSUtil.generateTransactionSequence(adMap, session, hbt));
				
				patientPrescriptionHeader.setPrescriptionNo(prescriptionNo);
	
				String sqlItemId="";

				for (int i = 0; i < itemIdList.size(); i++) {
				
					int itemId = (Integer)itemIdList.get(i);;
					if(i==0){
						sqlItemId=""+itemId;
					}else{
						sqlItemId +=" , "+itemId;
					}
			
				}
				List<MasStoreItem> masItemList=new ArrayList<MasStoreItem>();
				Properties properties = new Properties();
				URL resourcePath = Thread.currentThread().getContextClassLoader()
						.getResource("adt.properties");
				
				try {
					properties.load(resourcePath.openStream());
					String item_class_code = properties.getProperty("item_class_id");
					item_class_id=Integer.parseInt(item_class_code);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(!sqlItemId.equals(""))
					masItemList=hbt.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemCategory as ic where item.Id in ("+sqlItemId+") and ic.Id="+item_class_id);
				
				if(masItemList.size()>0){
					patientPrescriptionHeader.setInjectionStatus("p");
				}else{
					patientPrescriptionHeader.setInjectionStatus("n");
				}
			
				patientPrescriptionHeader.setOtherTreatment((String)mapForDS.get("otherTreatment"));
			
				OpdSurgeryHeader ot = new OpdSurgeryHeader();
				ot.setId(opdSurgeryHeaderId);
				patientPrescriptionHeader.setOtSurgery(ot);
				hbt.save(patientPrescriptionHeader);
			}
	*/
			
		/*	if (itemIdList.size() > 0 ) {
				for (int i = 0; i < itemIdList.size(); i++) {
					if(itemIdList.get(i) !=0){
					List<MasStoreItem> itemCodeList = new ArrayList<MasStoreItem>();
					PatientPrescriptionDetails patientPrescriptionDetails = new PatientPrescriptionDetails();
					if(itemIdList.get(i) != null){
						MasStoreItem masStoreItem = new MasStoreItem();
						masStoreItem.setId(itemIdList.get(i));
					patientPrescriptionDetails.setItem(masStoreItem);
					}
					if (frequencyList.get(i) != null && !frequencyList.get(i).equals("")) {
						MasFrequency masFrequency = new MasFrequency();
						masFrequency.setId(frequencyList.get(i));
						patientPrescriptionDetails.setFrequency(masFrequency);
						}
						if (dosageList.get(i) != null && !dosageList.get(i).equals("") && !dosageList.get(i).equals("0")) {
							patientPrescriptionDetails.setDosage(dosageList.get(i));
						}else{
							patientPrescriptionDetails.setDosage("0");
						}
						if (remarksList.get(i) != null && !remarksList.get(i).equals("")) {
							patientPrescriptionDetails.setRemarks(remarksList.get(i));
						}
						//patientPrescriptionDetails.setType(typeLeftRightList.get(i));
						if (noOfDaysList.get(i) != null && !noOfDaysList.get(i).equals("")) {
							patientPrescriptionDetails.setNoOfDays(noOfDaysList.get(i));
						}
						if (routeList.get(i) != null && !routeList.get(i).equals("")) {
							patientPrescriptionDetails.setRoute(routeList.get(i));
						}
						if (totalList.get(i) != null && !totalList.get(i).equals("")) {
							patientPrescriptionDetails.setTotal(Math.round(totalList.get(i).floatValue()));
						}
						if (totalList.get(i) != null && !totalList.get(i).equals("") && totalList.get(i) != 0) {
							patientPrescriptionDetails.setTotal(totalList.get(i));
						}else{
							patientPrescriptionDetails.setTotal(1);
						}
						patientPrescriptionDetails.setGivenQty(0);
					
					patientPrescriptionDetails.setPrescription(patientPrescriptionHeader);
				
					patientPrescriptionDetails.setDetailStatus("a");

					List<MasStoreItem> storeItemList=new ArrayList<MasStoreItem>();
					Properties properties = new Properties();
					URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
					try {
						properties.load(resourcePath.openStream());
						String item_class_code = properties.getProperty("item_class_id");
						item_class_id=Integer.parseInt(item_class_code);
					} catch (Exception e) {
						e.printStackTrace();
					}
					storeItemList=hbt.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemClass as ic where item.Id="+itemIdList.get(i)+" and ic.Id="+item_class_id);
					if(storeItemList.size() > 0){
						patientPrescriptionDetails.setInjectionStatus("p");
					}else{
						patientPrescriptionDetails.setInjectionStatus("n");
					}
					
					hbt.save(patientPrescriptionDetails);

		
				}
				}
			}*/
			
			//pre medication
			
			List<Integer> itemList = new ArrayList<Integer>();
			List<String> batchList = new ArrayList<String>();
			List<Integer> issuedStockList = new ArrayList<Integer>();
			
			itemList = (List<Integer>)mapForDS.get("itemList");
			issuedStockList = (List<Integer>)mapForDS.get("issuedStockList");
			batchList = (List<String>)mapForDS.get("batchList");
			

			String postSurgeryCode = HMSUtil.getProperties("adt.properties", "CodeForPostSurgery");
				Visit visit = null;
				   Inpatient inpatient = null;
					if(visitId!=0)
							{
						visit = new Visit();
						visit.setId(visitId);
							}
							if(inpatientId!=0)
							{
								inpatient = new Inpatient();
								inpatient.setId(inpatientId);
							}
			if(itemList.size() >0)
			{
			//	if(itemList!=null && itemList.size() >0)
				
				PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();
				patientPrescriptionHeader.setNipStatus("n");
				if(visitId!=0)
				{
					patientPrescriptionHeader.setVisit(visit);
				}
				if(inpatientId!=0)
				{
					patientPrescriptionHeader.setInpatient(inpatient);
				}
				if(itemList.size() > 0){
					patientPrescriptionHeader.setHin(patient);
					//masDepartment.setId(deptId);
			
					patientPrescriptionHeader.setDepartment(masDepartment);
				/*	Visit visit = new Visit();
					visit.setId(visitId);
					patientPrescriptionHeader.setVisit(visit);*/
				
					patientPrescriptionHeader.setHospital(masHospital);
					patientPrescriptionHeader.setStatus("I");
					patientPrescriptionHeader
							.setPrescriptionDate(consultationDateToInsert);
					patientPrescriptionHeader.setPrescriptionTime(consultationTime);
					patientPrescriptionHeader.setEmp(employee);
							
					Map<String, Object> adMap = new HashMap<String, Object>();
				      adMap.put("tableObjectName", "PATIENT_PRESCRIPTION_HEADER");            
			            adMap.put("isHospitalWise", "y");
			            adMap.put("hospitalId", 1);
			            adMap.put("isYearly", "n");            
			            adMap.put("isMonthly", "n");
			            adMap.put("isPrefix", "n");
			
			        int prescriptionNo = Integer.parseInt(HMSUtil.generateTransactionSequence(adMap, session, hbt));
					patientPrescriptionHeader.setPrescriptionNo(prescriptionNo);
					patientPrescriptionHeader.setDepartment(masDepartment);
				/*	OpdSurgeryHeader ot = new OpdSurgeryHeader();
					ot.setId(opdSurgeryHeaderId);
					patientPrescriptionHeader.setOtSurgery(ot);*/
					patientPrescriptionHeader.setOtherTreatment(box.getString("otherTreatment"));
					hbt.save(patientPrescriptionHeader);
					
					for (int k = 0; k < itemList.size(); k++) {
						
						if(itemList.get(k) !=0){
						//List<MasStoreItem> itemCodeList = new ArrayList<MasStoreItem>();
						PatientPrescriptionDetails patientPrescriptionDetails = new PatientPrescriptionDetails();
						patientPrescriptionDetails.setOtStage(postSurgeryCode);
						if(itemList.get(k) != null){
							MasStoreItem masStoreItem = new MasStoreItem();
							masStoreItem.setId(itemList.get(k));
						patientPrescriptionDetails.setItem(masStoreItem);
						}
						
						patientPrescriptionDetails.setGivenQty(issuedStockList.get(k));
						patientPrescriptionDetails.setPrescription(patientPrescriptionHeader);
						//patientPrescriptionDetails.setDetailStatus("a");
					
						hbt.save(patientPrescriptionDetails);
						
						List<StoreItemBatchStock>storeItemBatch=session.createCriteria(StoreItemBatchStock.class).add(Restrictions.eq("BatchNo",batchList.get(k))).add(Restrictions.eq("Item.Id", itemList.get(k))).list();
						StoreItemBatchStock stock=null; 
						
						if(storeItemBatch.size()>0){
							stock=storeItemBatch.get(0);
							stock.setClosingStock(stock.getClosingStock().subtract(new BigDecimal(issuedStockList.get(k))));
						}
						
						
						StoreOpPatientIssueM storeOpPatientIssueM = new StoreOpPatientIssueM();
						storeOpPatientIssueM.setDepartment(masDepartment);
						
				
					      adMap.put("tableObjectName", "StoreOpPatientIssueM");            
				            adMap.put("isHospitalWise", "y");
				            adMap.put("hospitalId", hospitalId);
				            adMap.put("isYearly", "y");            
				            adMap.put("isMonthly", "n");
				            adMap.put("isPrefix", "n");
						 //adtHandlerService.generateAdNumber(adMap);
						
						//String issueNo = generateTransactionSequence(adMap, session);
				            String issueNo = HMSUtil.generateTransactionSequence(adMap, session, hbt);
						storeOpPatientIssueM.setHospital(masHospital);
						storeOpPatientIssueM.setIssueDate(new Date());
						storeOpPatientIssueM.setIssueNo(issueNo);
						storeOpPatientIssueM.setStatus("y");
						storeOpPatientIssueM.setIssueType("I");
						storeOpPatientIssueM.setTypeOfIssue("P");
						hbt.save(storeOpPatientIssueM);
						
						StoreOpPatientIssueT storeOpPatientIssueT = new StoreOpPatientIssueT();
						storeOpPatientIssueT.setOpIssue(storeOpPatientIssueM);
						MasStoreItem masStoreItem = new MasStoreItem();
						masStoreItem.setId(itemList.get(k));
						storeOpPatientIssueT.setItemIdIssue(masStoreItem);
						storeOpPatientIssueT.setItemIdRequire(masStoreItem);
						storeOpPatientIssueT.setItem(masStoreItem);
						storeOpPatientIssueT.setBatchNo(batchList.get(k));
						storeOpPatientIssueT.setQtyIssued(new BigDecimal(issuedStockList.get(k)));
						storeOpPatientIssueT.setExpiryDate(stock.getExpiryDate());
						storeOpPatientIssueT.setPrescription(patientPrescriptionDetails);
						hbt.save(storeOpPatientIssueT);
				
						if(stock!=null){
							hbt.update(stock);
						}
						
					  }//prescription details and issued op
					}
					}// prescription header
				
			}
			
			
//treatment
			List<Integer> itemIdList = (List<Integer>) mapForDS.get("itemIdList");
			List<Integer> classificationList = (List<Integer>) mapForDS.get("classificationList");
			List<Integer> frequencyList = (List) mapForDS.get("frequencyList");
			List<String> dosageList = (List) mapForDS.get("dosageList");
			List<Integer> totalList = (List) mapForDS.get("totalList");
			List<Integer> noOfDaysList = (List) mapForDS.get("noOfDaysList");
			List<String> remarksList = (List) mapForDS.get("remarksList");
			
			PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();
			int item_class_id = 0;
			if(itemIdList.size() > 0){
			 patient = new Patient();
			patient.setId(hinId);
			patientPrescriptionHeader.setNipStatus("n");
			patientPrescriptionHeader.setHin(patient);
			 masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			patientPrescriptionHeader.setDepartment(masDepartment);
			 visit = new Visit();
			visit.setId(visitId);
			patientPrescriptionHeader.setVisit(visit);
			 masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			patientPrescriptionHeader.setHospital(masHospital);
			patientPrescriptionHeader.setStatus("p");
			patientPrescriptionHeader
					.setPrescriptionDate(consultationDateToInsert);
			patientPrescriptionHeader.setPrescriptionTime(consultationTime);
			/**
			 * Code By Ritu 
			 * Created Foreign key relation for emp id in Database
			 */
			 employee = new MasEmployee();
			employee.setId(empId);
			patientPrescriptionHeader.setEmp(employee);
			
			/**
			 * End of code by Ritu
			 */
			/*int prescriptionNo=getTransactionSequenceNoForPrescriptionNo(mapForDS);*/
        	Map<String, Object> adMap = new HashMap<String, Object>();
		      adMap.put("tableObjectName", "PATIENT_PRESCRIPTION_HEADER");            
	            adMap.put("isHospitalWise", "y");
	            adMap.put("hospitalId", hospitalId);
	            adMap.put("isYearly", "n");            
	            adMap.put("isMonthly", "n");
	            adMap.put("isPrefix", "n");
	
	        int prescriptionNo = Integer.parseInt(HMSUtil.generateTransactionSequence(adMap, session, hbt));
			patientPrescriptionHeader.setPrescriptionNo(prescriptionNo);
			//patientPrescriptionHeader.setOpdPatientDetails(opdPatientDetails);
			
			/*
			 * This block is use for Check Injection in Prescription List
			 */
			//----------------commented by anamika for itemId================
			String sqlItemId="";
		//	List<Integer> itemList = new ArrayList<Integer>();
			for (int i = 0; i < itemIdList.size(); i++) {
				/*String pvmsNo = (String) itemIdList.get(i);
				String nomenclature = (String) nomenclatureList.get(i);
				int itemId = getItemIdFromPVMS(nomenclature,pvmsNo,hospitalId);*/
				int itemId = (Integer)itemIdList.get(i);;
				if(i==0){
					sqlItemId=""+itemId;
				}else{
					sqlItemId +=" , "+itemId;
				}
			//	itemIdList.add(itemId);
			}
			List<MasStoreItem> masItemList=new ArrayList<MasStoreItem>();
			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			
			try {
				properties.load(resourcePath.openStream());
				String item_class_code = properties.getProperty("item_class_id");
				item_class_id=Integer.parseInt(item_class_code);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(!sqlItemId.equals(""))
				masItemList=hbt.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemCategory as ic where item.Id in ("+sqlItemId+") and ic.Id="+item_class_id+" and item.IssueFrom='i'");
			
			if(masItemList.size()>0){
				patientPrescriptionHeader.setInjectionStatus("p");
			}else{
				patientPrescriptionHeader.setInjectionStatus("n");
			}
			/*
			 * End Of Code This block is use for Check Injection in Prescription List
			 */
			patientPrescriptionHeader.setOtherTreatment((String)mapForDS.get("otherTreatment"));
			
	            int ItemClassificationIdForNIP = 0;
				ItemClassificationIdForNIP = Integer.parseInt(HMSUtil.getValuesFromPropertiesFile("adt.properties", "ItemClassificationId"));
	

			
						if(classificationList.contains(ItemClassificationIdForNIP))
						patientPrescriptionHeader.setNipStatus("y");
						else
							patientPrescriptionHeader.setNipStatus("n");
			
			hbt.save(patientPrescriptionHeader);
			
			

			for (int i = 0; i < itemIdList.size(); i++) {
				if(itemIdList.get(i) !=0){
				List<MasStoreItem> itemCodeList = new ArrayList<MasStoreItem>();
				PatientPrescriptionDetails patientPrescriptionDetails = new PatientPrescriptionDetails();
				if(itemIdList.get(i) != null){
					MasStoreItem masStoreItem = new MasStoreItem();
					masStoreItem.setId(itemIdList.get(i));
				patientPrescriptionDetails.setItem(masStoreItem);
				}
				if (frequencyList.get(i) != null && !frequencyList.get(i).equals("")) {
					MasFrequency masFrequency = new MasFrequency();
					masFrequency.setId(frequencyList.get(i));
					patientPrescriptionDetails.setFrequency(masFrequency);
					}
					if (dosageList.get(i) != null && !dosageList.get(i).equals("") && !dosageList.get(i).equals("0")) {
						patientPrescriptionDetails.setDosage(dosageList.get(i));
					}else{
						patientPrescriptionDetails.setDosage("0");
					}
					if (remarksList.get(i) != null && !remarksList.get(i).equals("")) {
						patientPrescriptionDetails.setRemarks(remarksList.get(i));
					}
					//patientPrescriptionDetails.setType(typeLeftRightList.get(i));
					if (noOfDaysList.get(i) != null && !noOfDaysList.get(i).equals("")) {
						patientPrescriptionDetails.setNoOfDays(noOfDaysList.get(i));
					}
				
					/*if (totalList.get(i) != null && !totalList.get(i).equals("")) {
						patientPrescriptionDetails.setTotal(Math.round(totalList.get(i).floatValue()));
					}*/
					if (totalList.get(i) != null && !totalList.get(i).equals("") && totalList.get(i) != 0) {
						patientPrescriptionDetails.setTotal(totalList.get(i));
					}else{
						patientPrescriptionDetails.setTotal(1);
					}
					patientPrescriptionDetails.setGivenQty(0);
				
				patientPrescriptionDetails.setPrescription(patientPrescriptionHeader);
			
				patientPrescriptionDetails.setDetailStatus("a");

				List<MasStoreItem> storeItemList=new ArrayList<MasStoreItem>();
					String item_class_code = HMSUtil.getProperties("adt.properties", "item_class_id");
					item_class_id=Integer.parseInt(item_class_code);
				
				storeItemList=hbt.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemClass as ic where item.Id="+itemIdList.get(i)+" and ic.Id="+item_class_id+" and item.IssueFrom='i'");
				if(storeItemList.size() > 0){
					patientPrescriptionDetails.setInjectionStatus("p");
				}else{
					patientPrescriptionDetails.setInjectionStatus("n");
				}
				patientPrescriptionDetails.setOtStage(postSurgeryCode);
				hbt.save(patientPrescriptionDetails);
			
			}
			}
		
			
			
			
		}
			
			
//Investigation
			
		
			int hiddenValue = box.getInt("hiddenValue");
			int temp = 1;
			String[] chargeCodeIdArr = new String[hiddenValue];
			List<String> chargeCodeIdList = new ArrayList<String>();
			
			for (int i = 0; i < hiddenValue; i++) {
				if (box.get("chargeCodeName" + temp) != null
						&& !box.get("chargeCodeName" + temp)
								.equals("")) {

					String chargeCodeNameWithId = box.getString("chargeCodeName" + temp);
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
						//quantityList.add(qty);
						// clinicalList.add(clinicalNotes);
						
						
					}
				}
				temp++;
			}
	
			if (chargeCodeIdList.size() > 0) {
			//investigation
			/*Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);*/
			MasEmployee emp = new MasEmployee();
			emp.setId(empId);
			
			/*OpdSurgeryHeader opsSH = new OpdSurgeryHeader();
			opsSH.setId(opdSurgeryHeaderId);*/
			

			DgOrderhd dgOrderhd = new DgOrderhd();
			if(visitId!=0)
			{
				dgOrderhd.setVisit(visit);
			}
			if(inpatientId!=0)
			{
				dgOrderhd.setInpatient(inpatient);
			}
			
			dgOrderhd.setOrderDate(new Date());
			dgOrderhd.setOrderTime(consultationTime);
			dgOrderhd.setHospital(masHospital);
			dgOrderhd.setHin(patient);
			dgOrderhd.setDepartment(masDepartment);
			dgOrderhd.setPrescribedBy(emp);
			
			//dgOrderhd.setSurgery(opsSH);
			dgOrderhd.setPatientType("IP");
			dgOrderhd.setTestType("Regular");
			dgOrderhd.setCreatedby(box.getString("userName"));
			dgOrderhd.setCreatedon(new Date());

			//String orderSeqNo = generateOrderNumber(box.getInt("hospitalId"));
			
			Map<String, Object> adMap = new HashMap<String, Object>();
		      adMap.put("tableObjectName", "DgOrderhd");            
	            adMap.put("isHospitalWise", "y");
	            adMap.put("hospitalId", hospitalId);
	            adMap.put("isYearly", "n");            
	            adMap.put("isMonthly", "n");
	            adMap.put("isPrefix", "n");
			 //adtHandlerService.generateAdNumber(adMap);
			
			//String issueNo = generateTransactionSequence(adMap, session);
	            String orderSeqNo = HMSUtil.generateTransactionSequence(adMap, session, hbt);
			
			dgOrderhd.setOrderNo(orderSeqNo);
			//dgOrderhd.setInpatient(inpatient);
			
			dgOrderhd.setClinicalNote(box.getString("clinicalNotes1"));
			dgOrderhd.setOrderStatus("P");
			dgOrderhd.setLabOrderStatus("P");
			dgOrderhd.setLastChgBy(user);
			dgOrderhd.setLastChgDate(new Date());
			dgOrderhd.setLastChgTime(consultationTime);
			//dgOrderhd.setInvestigationRequestionNo(patientInvestigationHeader);
			hbt.save(dgOrderhd);
			
			for (int i = 0; i < chargeCodeIdList.size(); i++) {
				
				List<Patient> patientList = new ArrayList<Patient>();   
				String patientTypeNameForHAL = null;
				String patientTypeNameForOther = null;
				String dgOrderBillingStatus ="";
				
				Properties properties = new Properties();
				URL resourcePath = Thread.currentThread().getContextClassLoader()
						.getResource("adt.properties");
				try {
					properties.load(resourcePath.openStream());
					
					 patientTypeNameForHAL = properties.getProperty("patientTypeNameForHAL");;
					 patientTypeNameForOther = properties.getProperty("patientTypeNameForOther");;
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				Criteria crit = session.createCriteria(Patient.class).add(
						Restrictions.eq("Id", hinId));
				patientList = crit.list();
							
				
				if(patientList.size()!=0)
				{
					if(patientList.get(0).getPatientType().getPatientTypeName().equals(patientTypeNameForHAL))
					{
						dgOrderBillingStatus ="y";
					}
					else if(patientList.get(0).getPatientType().getPatientTypeName().equals(patientTypeNameForOther))
					{
						if(patientList.get(0).getBillable().equals("y"))
						    dgOrderBillingStatus ="n";
						else if(patientList.get(0).getBillable().equals("n"))
							dgOrderBillingStatus ="y";
					}
				}
	
				MasChargeCode masChargeCode = new MasChargeCode();
				//System.out.println("Integer.parseInt(chargeCodeIdList.get(i))--"+Integer.parseInt(chargeCodeIdList.get(i)));
				masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));

				DgOrderdt dgOrderdt = new DgOrderdt();
				dgOrderdt.setOtStage(postSurgeryCode);
				dgOrderdt.setOrderhd(dgOrderhd);
				masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
				dgOrderdt.setChargeCode(masChargeCode);
				//dgOrderdt.setOrderQty(quantityList.get(i));
				dgOrderdt.setBillingStatus(dgOrderBillingStatus);
				dgOrderdt.setCreatedby(box.getString("userName"));
				dgOrderdt.setCreatedon(new Date());
				dgOrderdt.setLastChgBy(user);
				
				dgOrderdt.setLastChgDate(new Date());
				dgOrderdt.setLastChgTime(consultationTime);
				dgOrderdt.setMsgSent("n");
				// method written for taking out the values of mascharge
				// code and subcharge

				List<MasChargeCode> masChargeList = new ArrayList<MasChargeCode>();
				masChargeList = session.createCriteria(MasChargeCode.class).add(
						Restrictions.eq("Id", Integer.parseInt(chargeCodeIdList.get(i)))).list();
				
				MasChargeCode masChargeCodeObj = masChargeList.get(0);
				int mainChargeId = masChargeCodeObj.getMainChargecode()
				.getId();
				int subChargeId = masChargeCodeObj.getSubChargecode()
				.getId();
				if (masChargeCodeObj.getMainChargecode()
						.getMainChargecodeCode().equalsIgnoreCase("Lab")) {
					dgOrderdt.setOrderStatus("P");
				} else {
					dgOrderdt.setOrderStatus("P");
				}
				MasMainChargecode masMainChargecode = new MasMainChargecode();
				masMainChargecode.setId(mainChargeId);
				dgOrderdt.setMainChargecode(masMainChargecode);
				MasSubChargecode masSubChargecode = new MasSubChargecode();
				masSubChargecode.setId(subChargeId);
				dgOrderdt.setSubChargeid(masSubChargecode);
				dgOrderdt.setInvestigation(new DgMasInvestigation(Integer.parseInt(chargeCodeIdList.get(i))));
				//dgOrderdt.setInvestigationToMH(referToMhList.get(i));
				dgOrderdt.setInvestigationToMh("n");
				//dgOrderdt.setReferToMh(referToMhList.get(i));
				dgOrderdt.setReferToMh("n");
				hbt.save(dgOrderdt);
			}
	   
		}
		
			List<OtBookingDt> otDTList = session.createCriteria(OtBookingDt.class).add(
					Restrictions.eq("OtBookingHd.Id", bookingId)).add(
					Restrictions.eq("Status", "n")).list();
			
			OtBooking otBooking1 = (OtBooking) hbt.load(OtBooking.class,
					bookingId);
			otBooking1.setSurgeryStatus("y");
			otBooking1.setAdditionalNotes(box.getString("additional_notes"));
			
			if(otDTList.size() >0 && otDTList.get(0).getOtBookingHd()!=null && otDTList.get(0).getOtBookingHd().getInpatient()==null)
			{
				otBooking1.setPostOpNotesAnaesthesiaStatus("y");
				otBooking1.setSurgeryStatus("D");
			}
			
			hbt.update(otBooking1);
			
			for( OtBookingDt otDt:otDTList)
			{
				OtBookingDt otBookingDt = (OtBookingDt) hbt.load(OtBookingDt.class,
						otDt.getId());
				otBookingDt.setStatus("y");
				hbt.update(otBookingDt);
				
				OpdSurgeryDetail osDT = (OpdSurgeryDetail) hbt.load(OpdSurgeryDetail.class,
						otDt.getOtPreAnesthesiaDetail().getOpdSurgeryDetail().getId());
				osDT.setSurgeryStatus("y");
				hbt.update(osDT);
			}
			
			tx.commit();
			dataSaved = true;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}
		map.put("dataSaved", dataSaved);
		map.put("bookingId", bookingId);
		return map;
	}

	public Map<String, Object> showPostAneaesthesiaProcNotesEntryJsp(Map mapForDS) {
		Session session = (Session) getSession();
	//	List<OpdSurgeryHeader> patientDetailList = new ArrayList<OpdSurgeryHeader>();
		List<OtPreAnaesthesiaProcNotesMain> patientList = new ArrayList<OtPreAnaesthesiaProcNotesMain>();
		List<OtPreAnaesthesiaProcNotesMain> preAnesthesiaList = new ArrayList<OtPreAnaesthesiaProcNotesMain>();
		List<OtPreAnaesthesiaProcNotesMain> otList = new ArrayList<OtPreAnaesthesiaProcNotesMain>();
		List<OtPreAnaesthesiaProNotesSub> otDetailList = new ArrayList<OtPreAnaesthesiaProNotesSub>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<MasItemClass> masItemClassList = new ArrayList<MasItemClass>();
		List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
		List maxId = new ArrayList();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasOpInstruction> preInstructionList = null;
		// String hinNo = "";
		int bookingId = 0;
		if (mapForDS.get("bookingId") != null) {
			bookingId = (Integer) mapForDS.get("bookingId");
		}
		int hospitalId = 0;
		if (mapForDS.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		}
		String yearlyNo = "";
		if (mapForDS.get("yearlySerialNo") != null) {
			yearlyNo = (String) mapForDS.get("yearlySerialNo");
			// hinNo = "";

		}

		int orderNo = 0;
		String yearlySerialNo = "";
		String monthSerialNo = "";
		String yearSeq = "";
		String monthSeq = "";
		String pastYear = "";
		String pastMonth = "";
		String anesthesiaDetails ="";
		try {
			if (bookingId != 0) {

	/*			Criteria crit = session.createCriteria(OpdSurgeryHeader.class)
						.createAlias("Hin", "p")
						.add(Restrictions.eq("Id", bookingId));
				patientDetailList = crit.list();*/
				List<OtBooking> booking  = new ArrayList<OtBooking>();
				 booking = session.createCriteria(OtBooking.class)
						.add(Restrictions.eq("Id", bookingId))
						.add(Restrictions.eq("OtPostAnethesiaStatus", "n").ignoreCase()).list();
						
				
				map.put("bookingList", booking);
				
				
				if(booking.size() >0 && booking.get(0).getHin()!=null)
				{
					
					if(booking.get(0).getOtBookingDt().size() >0)
						anesthesiaDetails = ((OtBookingDt)(booking.get(0).getOtBookingDt().toArray()[0])).getOtPreAnesthesiaDetail().getAnesthesiaHd().getAnashteicDetails();

					List<DischargeIcdCode>icdList=new ArrayList<DischargeIcdCode>();
					icdList=session.createCriteria(DischargeIcdCode.class).add(Restrictions.eq("Hin.Id", booking.get(0).getHin().getId())).list();
					
					Set<MasIcd> uniqueIcdList=new HashSet <MasIcd>();
					for(DischargeIcdCode icd2:icdList){
						MasIcd masIcd = icd2.getIcd();
						if(icd2.getIcd()!=null){
							uniqueIcdList.add(masIcd);
							//System.out.println("ff"+icd2.getId());
						}
					}
					
					String icd="";
					for(MasIcd icd2:uniqueIcdList){
						icd=icd+"\n"+icd2.getIcdName();
					}
					
					map.put("icd", icd);
				}

				try {
					maxId = session
							.createCriteria(OtPreAnaesthesiaProcNotesMain.class)
							.add(Restrictions.eq("Hospital.Id", hospitalId))
							.setProjection(
									Projections.projectionList().add(
											Projections.max("Id"))).list();

					preAnesthesiaList = session
							.createCriteria(OtPreAnaesthesiaProcNotesMain.class)
							.add(Restrictions.eq("Id", maxId.get(0))).list();
					// preAnesthesiaList=getHibernateTemplate().find("select
					// max(Id), YearlySerialNo,MonthlySerialNo from
					// OtPreAnaesthesiaProcNotesMain pac group by pac.Id");
				} catch (DataAccessException e) {
					e.printStackTrace();
				}

				Calendar calendar = Calendar.getInstance();

				if (preAnesthesiaList != null && preAnesthesiaList.size() > 0) {
					yearlySerialNo = preAnesthesiaList.get(0)
							.getYearlySerialNo();
					monthSerialNo = preAnesthesiaList.get(0)
							.getMonthlySerialNo();
					StringTokenizer st1 = new StringTokenizer(yearlySerialNo,
							"/");
					StringTokenizer st2 = new StringTokenizer(monthSerialNo,
							"/");
					while (st1.hasMoreTokens()) {
						yearSeq = st1.nextToken();
						pastYear = st1.nextToken();

						if (Integer.parseInt(pastYear) != calendar
								.get(Calendar.YEAR)) {

							yearlySerialNo = "1/" + calendar.get(Calendar.YEAR);
						} else {

							yearlySerialNo = Integer.parseInt(yearSeq) + 1
									+ "/" + pastYear;
						}
					}
					while (st2.hasMoreTokens()) {
						monthSeq = st2.nextToken();
						pastMonth = st2.nextToken();
						if (Integer.parseInt(pastMonth) != calendar
								.get(Calendar.MONTH) + 1) {
							monthSerialNo = "1/" + calendar.get(Calendar.MONTH)
									+ 1;
						} else {
							if (Integer.parseInt(pastYear) != calendar
									.get(Calendar.YEAR)) {
								monthSerialNo = "1/"
										+ (calendar.get(Calendar.MONTH) + 1);
							} else {
								monthSerialNo = Integer.parseInt(monthSeq) + 1
										+ "/" + pastMonth;
							}
						}
					}
				} else {
					yearlySerialNo = "1/" + calendar.get(Calendar.YEAR);
					monthSerialNo = "1/" + (calendar.get(Calendar.MONTH) + 1);
				}
			}
			if (!yearlyNo.equals("")) {
				otList = session
						.createCriteria(OtPreAnaesthesiaProcNotesMain.class)
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("YearlySerialNo", yearlyNo))
						.list();
				otDetailList = session
						.createCriteria(OtPreAnaesthesiaProNotesSub.class)
						.createAlias("PreAnaesthesiaMain", "header")
						.add(Restrictions
								.eq("header.Id", otList.get(0).getId())).list();
			
			}
			
			frequencyList = session.createCriteria(MasFrequency.class).add(
					Restrictions.eq("Status", "y")).list();
			
			
			  masItemClassList= session.createCriteria(MasItemClass.class).
						add(Restrictions.eq("Status", "y").ignoreCase())
						 .addOrder(Order.asc("ItemClassName")) .list(); 


		  itemConversionList = session.createCriteria(MasStoreItemConversion.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ItemUnitName")).list();
		  String CodeForPreOPInstruction =HMSUtil.getProperties("adt.properties", "CodeForPostOPInstruction");
		  preInstructionList = session.createCriteria(MasOpInstruction.class).add(Restrictions.eq("Status", "y"))
		  			.createAlias("Op", "op").add(Restrictions.eq("op.OpInsCode", CodeForPreOPInstruction)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		//map.put("patientDetailList", patientDetailList);
		map.put("patientList", patientList);
		map.put("yearlySerialNo", yearlySerialNo);
		map.put("monthSerialNo", monthSerialNo);
		map.put("frequencyList", frequencyList);	
		map.put("masItemClassList", masItemClassList);
		map.put("itemConversionList", itemConversionList);
		map.put("preInstructionList", preInstructionList);
		map.put("otList", otList);
		map.put("otDetailList", otDetailList);
		map.put("anesthesiaDetails",anesthesiaDetails);
		return map;
	}
	
	@Override
	public Map<String, Object> showConsentFormEntryJsp(Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		List<OtBooking> patientDetailList = new ArrayList<OtBooking>();
	/*	List<MasRelation> relationList = new ArrayList<MasRelation>();*/
		Map<String, Object> map = new HashMap<String, Object>();
		int bookingId = 0;
		if (mapForDS.get("bookingId") != null) {
			bookingId = (Integer) mapForDS.get("bookingId");
		}
		patientDetailList = 
		 session.createCriteria(OtBooking.class)
			.add(Restrictions.eq("Id", bookingId))
			  .add(Restrictions.eq("SurgeryStatus", "n").ignoreCase())
			.add(Restrictions.eq("OtBookingStatus", "y").ignoreCase()).list();
	    

		map.put("bookingList", patientDetailList);
	//	map.put("relationList", relationList);
		return map;

	}
	@Override
	public Map<String, Object> searchOtPatientConsentDetails(
			Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<OtBooking> patientList = new ArrayList<OtBooking>();
		List<MasOt> masOtList = new ArrayList<MasOt>();

		   String empId = "";
		   int otId = 0;
	        String pName="";
	        Date surgeryDate =null;
		
			int hospitalId = 0;
			if (mapForDS.get(HOSPITAL_ID) != null) {
				hospitalId = (Integer)mapForDS.get(HOSPITAL_ID);
			}
			
	        
			if(mapForDS.get(PATIENT_NAME)!=null)
			{
				pName = (String)mapForDS.get(PATIENT_NAME);
			}
					
			if(mapForDS.get(EMPLOYEE_ID)!=null)
			{
				empId = (String)mapForDS.get(EMPLOYEE_ID);
			}

			if(mapForDS.get(OT_ID)!=null)
			{
				otId = (Integer)mapForDS.get(OT_ID);
			}
	        
			if(mapForDS.get(SURGERY_DATE)!=null)
			{
				surgeryDate = HMSUtil
						.convertStringTypeDateToDateType(mapForDS.get(SURGERY_DATE).toString());
			}
	
			List<OtPreAnesthesiaHd> OtPreAnesthesiaDetails = new ArrayList<OtPreAnesthesiaHd>();
			
		Criteria crit =null;

		/*OtPreAnesthesiaDetails  =session.createCriteria(OtPreAnesthesiaDetails.class)
				.add(Restrictions.eq("ConsentStatus", "n").ignoreCase()).list();*/
		
	/*	if(OtPreAnesthesiaDetails.size() >0)
		{*/
		/*	List <Integer> opdSHIdList = new ArrayList<Integer>();
			
			for(OtPreAnesthesiaDetails ad :OtPreAnesthesiaDetails){
	
				opdSHIdList.add(ad.getOpdSurgeryHeader().getId());
			}*/
		String []surgery_status = {"n", "y"};
			 crit = session.createCriteria(OtBooking.class)
				//.add(Restrictions.in("OpdSurseryHeader.Id", opdSHIdList)) 
				//.add(Restrictions.eq("OtBookingStatus", "y"))
					    .add(Restrictions.in("SurgeryStatus", surgery_status));
			    
			if(!pName.equals(""))
			{
				crit.add(Restrictions.like("hin.PFirstName", pName.toLowerCase()+"%").ignoreCase());
			}
			
			if(empId!="")
			{
				crit.add(Restrictions.eq("hin.ServiceNo", empId));
			}
			
			if(otId!=0)
			{
				crit.createAlias("Ot", "ot")
				.add(Restrictions.eq("ot.Id",otId));
			}
	
			if(surgeryDate!=null)
			{
				crit.add(Restrictions.eq("SurgeryDate", surgeryDate));
			}
			patientList = crit.list();
		
		//}

		masOtList = session.createCriteria(MasOt.class).add(
						Restrictions.eq("Status", "y")).list();
		
		map.put("recordList", patientList);
		map.put("masOtList", masOtList);
		
		
		return map;
	}
	
	@Override
	public Map<String, Object> submitDocumentForOT(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<UploadDocuments> uploadDocuments = new ArrayList<UploadDocuments>();
		Session session = (Session)getSession();
		int hinId = 0;
		int visitId =0;
		int inpatientId=0;
		String flag="n";
		String uploadType ="";
		String message="";
		//String uploadFrom ="NA";
		boolean fileuploaded=false;
		
		/*		if(generalMap.get("hinId")!= null){
			hinId =(Integer) generalMap.get("hinId");
		}
		if(generalMap.get("visitId")!= null){
			visitId =(Integer) generalMap.get("visitId");
		}
		if(generalMap.get("inpatientId")!= null){
			inpatientId =(Integer) generalMap.get("inpatientId");
		}
		if(generalMap.get("flag")!= null){
			flag =(String) generalMap.get("flag");
		}
		if(generalMap.get("uploadFrom")!= null){
			uploadFrom =(String) generalMap.get("uploadFrom");
		}*/
		
		
		String filename = "";
		if(generalMap.get("filename")!= null){
			filename =(String) generalMap.get("filename");
		}
		String uploadURL = "";
		if(generalMap.get("uploadURL")!= null){
			uploadURL =(String) generalMap.get("uploadURL");
		}
		String comments = "";
		if(generalMap.get("comments")!= null){
			comments =(String) generalMap.get("comments");
		}
		
		if(generalMap.get("flag")!= null){
			flag =(String) generalMap.get("flag");
		}
		if(generalMap.get("uploadType")!= null){
			uploadType =(String) generalMap.get("uploadType");
		}
		
		int bookingId = (Integer) generalMap.get("bookingId");
				
		int userId = (Integer) generalMap.get(USER_ID);
		if(flag.equalsIgnoreCase("y"))
		{	
			String fileExtension=null;
			 File file=null;
			 try { 
				 
				 Users users = new Users();
					users.setId(userId);
				 
					HibernateTemplate hbt=getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					//System.out.println(uploadURL+" -- "+filename);
					 file=new File(uploadURL + "/" + filename);
		    		 //System.out.println("path>>"+file.getPath());
		    		
		    	     FileInputStream is = new FileInputStream(file);
		    	     long length = file.length();
		    	     ByteBuffer byteBuff=null;
		    	   //  int modLength=length/
		    	     if (length > Integer.MAX_VALUE) {
		            // File is too large
		    	     }
		    	     // Create the byte array to hold the data
		    	     byte[] bytes = new byte[(int)length];
		    	     int offset = 0;
		    	     int numRead = 0;
		    	     while (offset < bytes.length
		    	    		 && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
		    	    	 offset += numRead;
		    	    	
		    	     }
		    
		    	     if (offset < bytes.length) {
		    	    	 throw new IOException("Could not completely read file "+file.getName());
		    	         
		    	     }
		    	     is.close();     
		    	
		    		  	Map<String, Object> utilMap = HMSUtil.getCurrentTimeWithoutSecond();
			    	     String time = (String) utilMap.get("currentTime");
		    	  
			    	     UploadDocuments document = new UploadDocuments();
		    	     document.setPatientDocument(bytes);
		    	     int indexNo = filename.lastIndexOf("."); 
		    	     String actualfileName = filename.substring(0, indexNo);
		    	     fileExtension = filename.substring(indexNo+1);
		    	     document.setFileName(actualfileName);
		    	     document.setFileExtension(fileExtension);
		    	     Date d= new Date();
		    	     document.setUploadDate(d);
		    	     OtBooking otBooking = new OtBooking();
		    	     otBooking.setId(bookingId);
		    	     document.setOtBooking(otBooking);
		    	     document.setDescription(comments);
		    	     document.setOtUploadType(uploadType);
		    	    document.setLastChgBy(users);
		    	     document.setLastChgDate(d);
		    	     document.setLastChgTime(time);
		    	     hbt.save(document);
		    	     hbt.flush();
		    	     hbt.refresh(document);	
		    	     message="File uploaded Sucessfully";
		    	     fileuploaded=true;
		    
		    }
			catch (Exception e) {
		    	e.printStackTrace();
		      System.err.println("Error: " + e.getMessage());
		      message="File is not uploaded Sucessfully, some error is occurred";
		      e.printStackTrace();
		    }
		
		}
		
		uploadDocuments = session.createCriteria(UploadDocuments.class).add(Restrictions.eq("OtUploadType", uploadType)).createAlias("OtBooking", "ot").add(Restrictions.eq("ot.Id", bookingId)).addOrder(Order.asc("UploadDate")).list();
		
		map.put("visitId", visitId);
		map.put("inpatientId", inpatientId);
		map.put("uploadDocuments", uploadDocuments);
		map.put("message", message);
		map.put("fileuploaded", fileuploaded);
		return map;

	}
	
	
	@Override
	public Map<String, Object> transferToWardWaitingList(
			Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<OtBooking> patientList = new ArrayList<OtBooking>();
		List<MasOt> masOtList = new ArrayList<MasOt>();

		   String empId = "";
		   int otId = 0;
	        String pName="";
	        Date surgeryDate =null;
		
			int hospitalId = 0;
			if (mapForDS.get(HOSPITAL_ID) != null) {
				hospitalId = (Integer)mapForDS.get(HOSPITAL_ID);
			}
			
	        
			if(mapForDS.get(PATIENT_NAME)!=null)
			{
				pName = (String)mapForDS.get(PATIENT_NAME);
			}
					
			if(mapForDS.get(EMPLOYEE_ID)!=null)
			{
				empId = (String)mapForDS.get(EMPLOYEE_ID);
			}

			if(mapForDS.get(OT_ID)!=null)
			{
				otId = (Integer)mapForDS.get(OT_ID);
			}
	        
			if(mapForDS.get(SURGERY_DATE)!=null)
			{
				surgeryDate = HMSUtil
						.convertStringTypeDateToDateType(mapForDS.get(SURGERY_DATE).toString());
			}
			
		Criteria crit =null;

			 crit = session.createCriteria(OtBooking.class)
					 .createAlias("Hin", "hin")
			//	.add(Restrictions.eq("OtBookingStatus", "y"))
			    .add(Restrictions.eq("SurgeryStatus", "y"))
			    .add(Restrictions.eq("OtPostAnethesiaStatus", "y"))
			 .add(Restrictions.eq("Hospital.Id", hospitalId));
			    
			if(!pName.equals(""))
			{
				crit.add(Restrictions.like("hin.PFirstName", pName.toLowerCase()+"%").ignoreCase());
			}
			
			if(empId!="")
			{
				crit.add(Restrictions.eq("hin.ServiceNo", empId));
			}
			
			if(otId!=0)
			{
				crit.createAlias("Ot", "ot")
				.add(Restrictions.eq("ot.Id",otId));
			}
	
			if(surgeryDate!=null)
			{
				crit.add(Restrictions.eq("SurgeryDate", surgeryDate));
			}
			patientList = crit.list();
		
		

		masOtList = session.createCriteria(MasOt.class).add(
						Restrictions.eq("Status", "y")).list();
		
		map.put("recordList", patientList);
		map.put("masOtList", masOtList);
		return map;
	}
	@Override
	public Map<String, Object> showOtPatientToWard(
			Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		List<OtBooking> patientDetailList = new ArrayList<OtBooking>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasBed> bedList = new ArrayList<MasBed>();
		List<Transfer> transferNoList = new ArrayList<Transfer>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		Map<String, Object> map = new HashMap<String, Object>();
		// String hinNo = "";
		int bookingId = 0;
		if (mapForDS.get("bookingId") != null) {
			bookingId = (Integer) mapForDS.get("bookingId");
		}
		int hospitalId = 0;
		if (mapForDS.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		}



		try {
			if (bookingId != 0) {
				
				 patientDetailList = session.createCriteria(OtBooking.class)
						.add(Restrictions.eq("Id", bookingId))
						//.add(Restrictions.eq("OtBookingStatus", "y").ignoreCase())
			    .add(Restrictions.eq("SurgeryStatus", "y").ignoreCase())
			    .add(Restrictions.eq("OtPostAnethesiaStatus", "y").ignoreCase()).list();
				 
					if(patientDetailList.size() >0 && patientDetailList.get(0).getHin()!=null)
					{
						List<DischargeIcdCode>icdList=new ArrayList<DischargeIcdCode>();
						icdList=session.createCriteria(DischargeIcdCode.class).add(Restrictions.eq("Hin.Id", patientDetailList.get(0).getHin().getId())).list();
						
						Set<MasIcd> uniqueIcdList=new HashSet <MasIcd>();
						for(DischargeIcdCode icd2:icdList){
							MasIcd masIcd = icd2.getIcd();
							if(icd2.getIcd()!=null){
								uniqueIcdList.add(masIcd);
							}
						}
						
						String icd="";
						for(MasIcd icd2:uniqueIcdList){
							icd=icd+"\n"+icd2.getIcdName();
						}
						
						map.put("icd", icd);
					}
				 
				 
				/*	String qry = "select distinct a.department_id, a.department_name,c.department_type_code from mas_department a left join mas_bed b on a.department_id=b.department_id" +
							" left join mas_department_type c on a.department_type_id=c.department_type_id"+
							" where c.department_type_name='Ward' and  b.hospital_id="+hospitalId+"  and a.status='y' order by a.department_name";
				departmentList = session.createSQLQuery(qry).list();*/
					String wardDepartmentTypeCode = null;
					try
					{
						//departmentCodeForICU = HMSUtil.getValuesFromPropertiesFile("adt.properties", "departmentCodeForICU");
						wardDepartmentTypeCode = HMSUtil.getValuesFromPropertiesFile("adt.properties", "departmentTypeCodeForWard");
						
						

					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					departmentList=session.createCriteria(MasDepartment.class)
							.add(Restrictions.eq("Status","y").ignoreCase())
							.createAlias("DepartmentType", "dt")
							.add(Restrictions.eq("dt.DepartmentTypeCode",wardDepartmentTypeCode) )
							.addOrder(Order.asc("DepartmentName"))
							.list();
					
				bedList = session.createCriteria(MasBed.class).add(Restrictions.eq("Status", "y")).list();
				transferNoList = session.createCriteria(Transfer.class).list();
			//	employeeList = session.createCriteria(MasEmployee.class).createAlias("Hospital", "hospital").add(Restrictions.eq("hospital.Id", hospitalId)).add(Restrictions.eq("Status", "y")).list();

			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		map.put("departmentList", departmentList);
		map.put("transferNoList", transferNoList);
		map.put("employeeList", employeeList);
	

		return map;
	}
	
	@SuppressWarnings("unchecked")
	public boolean submitTransferInformation(Map<String, Object> transferMap) {
		List<OtBooking> patientDetailList = new ArrayList<OtBooking>();
		boolean transferedSuccessfully = false;

		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}

		

		Session session = (Session)getSession();
		Transaction tx = null;
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();

		try {
			int userId = (Integer)transferMap.get("userId");
			int inpatientId = (Integer)transferMap.get("inpatientId");
			int otBookingId = (Integer)transferMap.get("otBookingId");
			int toWardId = (Integer)transferMap.get("toWardId");
			int toDoctorId = (Integer)transferMap.get("toDoctorId");
			int hospitalId = (Integer)transferMap.get("hospitalId");
			int toBedId = (Integer)transferMap.get("toBedId");
			String currentTime = (String)transferMap.get("currentTime");
			 Date currentDate =  HMSUtil.convertStringTypeDateToDateType(transferMap.get("currentDate").toString());
			
			
			
			int bedStatusOccupiedId = Integer.parseInt(properties.getProperty("bedStatusOccupiedId"));
			int bedStatusUnOccupiedId = Integer.parseInt(properties.getProperty("bedStatusUnOccupiedId"));
			//System.out.println("zffd "+bedStatusOccupiedId+" "+bedStatusUnOccupiedId);
			//System.out.println("transferedSuccessfully"+transferedSuccessfully);
	/*		
			Transfer transfer = (Transfer)transferMap.get("transfer");
			int fromBedId = (Integer)transferMap.get("fromBedId");
			
			String adNo = (String)transferMap.get("adNo");
			
			int adId = 0;
			*/
			

			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			 patientDetailList = session.createCriteria(OtBooking.class)
						//.add(Restrictions.eq("Id", otBookingId))
						.add(Restrictions.eq("Id", otBookingId))
						.add(Restrictions.eq("SurgeryStatus", "y").ignoreCase())
						.add(Restrictions.eq("OtPostAnethesiaStatus", "y").ignoreCase()).list();
		if(patientDetailList.size() >0)
		{
			OtBooking otBooking = patientDetailList.get(0);
			Inpatient inpatientObj = (Inpatient)hbt.load(Inpatient.class, inpatientId);
			
			if(toWardId !=otBooking.getInpatient().getDepartment().getId())
			{
			MasDepartment department = (MasDepartment) hbt.get(MasDepartment.class, toWardId);
			MasEmployee masEmp = (MasEmployee)  hbt.get(MasEmployee.class, toDoctorId);
			MasBed masBed = (MasBed)  hbt.get(MasBed.class, toBedId);
			
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);
			Users user = new Users();
			user.setId(userId);
			
			 Transfer patientTransfer = new Transfer();
			  int patientTransferNo = 0;
				List<Integer> otSeqList = new ArrayList<Integer>();
				otSeqList = session.createCriteria(Transfer.class)
						   .setProjection(Projections.projectionList().add(Projections
								.max("TransferNo"))).list();
			
				if(otSeqList.size()>0 && otSeqList.get(0)!=null)
				{
					for (Integer maxOrderNo : otSeqList) {
							patientTransferNo = maxOrderNo + 1;
						break;
					}
				}
				else
					patientTransferNo=1;
			patientTransfer.setTransferNo(patientTransferNo);
			patientTransfer.setHin(otBooking.getInpatient().getHin());
			patientTransfer.setAdNo(otBooking.getInpatient().getAdNo());
			patientTransfer.setFromBed(otBooking.getInpatient().getBed());
			patientTransfer.setFromDoctor(otBooking.getInpatient().getDoctor());
			patientTransfer.setFromWard(otBooking.getInpatient().getDepartment());
			patientTransfer.setToBed(masBed);
			patientTransfer.setToDoctor(masEmp);
			patientTransfer.setToWard(department);
			patientTransfer.setAdStatus("A");
			patientTransfer.setStatus("y");
			patientTransfer.setHospital(masHospital);
			patientTransfer.setInpatient(inpatient);
			patientTransfer.setAddEditBy(user);
			patientTransfer.setAddEditDate(currentDate);
			patientTransfer.setAddEditTime(currentTime);
			patientTransfer.setDateOfTransfer(currentDate);
			patientTransfer.setTimeOfTransfer(currentTime);
			patientTransfer.setTransferReason(transferMap.get("transferReason").toString().trim());
			hbt.save(patientTransfer);
			
			MasBed fromMasBed = (MasBed)hbt.load(MasBed.class, otBooking.getInpatient().getBed().getId());
			MasBedStatus fromMasBedStatus = new MasBedStatus();
			fromMasBedStatus.setId(bedStatusUnOccupiedId);
			fromMasBed.setBedStatus(fromMasBedStatus);
			hbt.update(fromMasBed);
		
			MasBed toMasBed = (MasBed)hbt.load(MasBed.class, toBedId);
			MasBedStatus toMasBedStatus = new MasBedStatus();
			toMasBedStatus.setId(bedStatusOccupiedId);
			toMasBed.setBedStatus(toMasBedStatus);
			hbt.update(toMasBed);
							 /*MasBed masbed=(MasBed) hbt.get(MasBed.class, otBooking.getBed().getId());
				
				 int bedstaus =Integer.parseInt(HMSUtil.getValuesFromPropertiesFile("adt.properties", "bedStatusUnOccupiedId".trim()));
				
				 MasBedStatus bedstatus =  (MasBedStatus)hbt.load(MasBedStatus.class, bedstaus);
				 masbed.setBedStatus(bedstatus);
				 
				 hbt.update(masbed);*/

			inpatientObj.setDepartment(department);
			inpatientObj.setDoctor(masEmp);
			inpatientObj.setBed(masBed);
			}
			
			OtBooking booking=(OtBooking) hbt.get(OtBooking.class, otBookingId);
			//booking.setOtBookingStatus("C");
			booking.setSurgeryStatus("d");
			hbt.update(booking);
			hbt.flush();
			
			inpatientObj.setSurgeryStatus("C");
			inpatientObj.setAdStatus("A");
			hbt.update(inpatientObj);
			transferedSuccessfully = true;
			tx.commit();
		  }
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			session.close();
		}

		return transferedSuccessfully;
	}
	public String getHospitalName(int hospitalId) {
		Session session = (Session) getSession();
		String hospitalName = "";
		List<MasHospital> list = session.createCriteria(MasHospital.class).add(
				Restrictions.eq("Status", "y")).add(
						Restrictions.eq("Id", hospitalId)).list();

		if (list != null && list.size() > 0) {
			MasHospital obj = (MasHospital) list.get(0);
			hospitalName = obj.getHospitalName();
		}
		return hospitalName;
	}
	
	public Map<String, Object> showOtBookingRegisterJsp() {
		 Session session = (Session) getSession();
		    Map<String, Object> map = new HashMap<String, Object>();
		
	
				
				List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
				masEmployeeList = session.createCriteria(MasEmployee.class).list();
				
	
				map.put("masEmployeeList", masEmployeeList);
			
		return map;
	}

	@Override
	public Map<String, Object> showNewCaseSheetJsp(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<OpdPatientDetails> opdDetailsList = new ArrayList<OpdPatientDetails>();
		List<OpdPatientDetails> ipdDetailsList = new ArrayList<OpdPatientDetails>();		
		List<PatientPrescriptionHeader> opdPrescriptionList = new ArrayList<PatientPrescriptionHeader>();
		List<PatientInvestigationHeader> opdInvestigationList = new ArrayList<PatientInvestigationHeader>();
		List<DischargeIcdCode> icdList = new ArrayList<DischargeIcdCode>();
	//	List<ProcedureHeader> opdProcedureList = new ArrayList<ProcedureHeader>();
	//	List<PhysioRequisitionHeader> opdPhysiotherapyList = new ArrayList<PhysioRequisitionHeader>();
		List<OpdPatientHistory> opdHistoryDetailsListForFollowUp = new ArrayList<OpdPatientHistory>();
		List<IpdPatientDiet> ipdPatientDietList= new ArrayList<IpdPatientDiet>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<PatientFamilyHistory> familyHistoryList = new ArrayList<PatientFamilyHistory>();
		List<MasIcd> masIcdList = new ArrayList<MasIcd>();
		List<MasDiet> dietTypeList = new ArrayList<MasDiet>();	
		List<OpdPatientDetails> caseSheetList = new ArrayList<OpdPatientDetails>();
		List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
		List<MasImpanneledHospital> masImpanneledHospitalList = new ArrayList<MasImpanneledHospital>();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		Box box = (Box) dataMap.get("box");
		Session session = (Session)getSession();
		
		
		
		
		
		
		String departmentTypeCode = null;
		String departmentTypeCodeForOpd=null;

		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");

		try {
			properties.load(resourcePath.openStream());
			/*wardDepartmentTypeCode = properties.getProperty("departmentTypeCodeForWard");*/
			departmentTypeCode = properties.getProperty("departmentTypeCodeForWard");
			departmentTypeCodeForOpd =  properties.getProperty("departmentTypeCodeForOpd");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		inpatientList =  session.createCriteria(Inpatient.class).add(Restrictions.idEq(box.getInt("parent"))).list();
		int hinId =0;
		Visit visit = null;
		if(inpatientList.size() >0)
				 hinId= inpatientList.get(0).getHin().getId();
		else if(box.get("parent")!=null)
		{
			List<OpdSurgeryHeader> opdList = session.createCriteria(OpdSurgeryHeader.class).add(Restrictions.eq("Id", box.getInt("opdSurgeryId"))).list();
			
			if(opdList.size() >0)
			{
			visit = opdList.get(0).getVisit();
			Patient patient = opdList.get(0).getHin();
			map.put("visit", visit);
			map.put("patient", patient);
			hinId =opdList.get(0).getHin().getId();
			}
		}
			
		opdDetailsList = session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "v").createAlias("v.Hin", "hin").add(Restrictions.eq("hin.Id", hinId))
		.addOrder(Order.desc("id")).setMaxResults(1).list();
		ipdDetailsList = session.createCriteria(OpdPatientDetails.class).createAlias("Inpatient", "ip").add(Restrictions.eq("ip.Id", box.getInt("parent")))
		.addOrder(Order.desc("id")).list();

		if(opdDetailsList.size() > 0) {
			int visitId = 0;
			visitId = opdDetailsList.get(0).getVisit().getId();
			//System.out.println("visitId"+visitId);
			
				opdPrescriptionList = session.createCriteria(PatientPrescriptionHeader.class).createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
				opdInvestigationList = session.createCriteria(PatientInvestigationHeader.class).createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
				icdList = session.createCriteria(DischargeIcdCode.class).createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
				//System.out.println("icdList"+icdList.size());
				//System.out.println("visitId1"+visitId);
		//		opdProcedureList = session.createCriteria(ProcedureHeader.class).createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
		//		opdPhysiotherapyList =  session.createCriteria(PhysioRequisitionHeader.class).createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
				opdHistoryDetailsListForFollowUp = session.createCriteria(OpdPatientHistory.class).createAlias("OpdPatientDetails", "details")
				.createAlias("details.Visit", "visit").add(Restrictions.eq("visit.Id", visitId)).list();
			
		}
		List<PatientPrescriptionHeader> ipdPrescriptionList = new ArrayList<PatientPrescriptionHeader>();
		List<PatientInvestigationHeader> ipdInvestigationList = new ArrayList<PatientInvestigationHeader>();
		List<DischargeIcdCode> ipIcdList = new ArrayList<DischargeIcdCode>();
	//	List<ProcedureHeader> ipdProcedureList = new ArrayList<ProcedureHeader>();
	//	List<NursingcareSetup> ipdProcedureList = new ArrayList<NursingcareSetup>();
	//	List<PhysioRequisitionHeader> ipdPhysiotherapyList = new ArrayList<PhysioRequisitionHeader>();
		List<OpdPatientHistory> ipdHistoryDetailsListForFollowUp = new ArrayList<OpdPatientHistory>();

		if(ipdDetailsList.size() > 0) {
			caseSheetList.addAll(ipdDetailsList);// to display all previous case list
	//		opdDetailsList.add(ipdDetailsList.get(0)); // to display latest case sheet details in todays case sheet
			int opdPatientDetailsId = 0;
			opdPatientDetailsId = ipdDetailsList.get(0).getId();
			ipdPrescriptionList = session.createCriteria(PatientPrescriptionHeader.class).createAlias("OpdPatientDetails", "ip").add(Restrictions.eq("ip.id", opdPatientDetailsId)).addOrder(Order.desc("Id")).setMaxResults(1).list();
			ipdInvestigationList = session.createCriteria(PatientInvestigationHeader.class).createAlias("OpdPatientDetails", "ip").add(Restrictions.eq("ip.id", opdPatientDetailsId)).addOrder(Order.desc("Id")).setMaxResults(1).list();
			/*ipIcdList = session.createCriteria(DischargeIcdCode.class).createAlias("OpdPatientDetails", "ip").add(Restrictions.eq("ip.id", opdPatientDetailsId)).addOrder(Order.desc("Id")).list();*/
			ipIcdList = session.createCriteria(DischargeIcdCode.class).createAlias("OpdPatientDetails", "ip").add(Restrictions.eq("ip.Inpatient.Id", box.getInt("parent"))).addOrder(Order.desc("Id")).list();			
	//		ipdProcedureList = session.createCriteria(NursingcareSetup.class).createAlias("Inpatient", "ip").add(Restrictions.eq("ip.Id", box.getInt("parent"))).addOrder(Order.desc("Id")).setMaxResults(1).list();
	//		ipdPhysiotherapyList =  session.createCriteria(PhysioRequisitionHeader.class).createAlias("OpdPatientDetails", "ip").add(Restrictions.eq("ip.id", opdPatientDetailsId)).addOrder(Order.desc("Id")).setMaxResults(1).list();
			ipdHistoryDetailsListForFollowUp = session.createCriteria(OpdPatientHistory.class).createAlias("OpdPatientDetails", "ip").add(Restrictions.eq("ip.id", opdPatientDetailsId)).list();

			ipdPatientDietList = session.createCriteria(IpdPatientDiet.class).createAlias("OpdPatientDetails", "ip").add(Restrictions.eq("ip.id", opdPatientDetailsId)).addOrder(Order.desc("Id")).setMaxResults(1).list();


		}
		ipdPrescriptionList.addAll(opdPrescriptionList);
		ipdInvestigationList.addAll(opdInvestigationList);
		ipIcdList.addAll(icdList);
//		ipdProcedureList.addAll(opdProcedureList);
//		ipdPhysiotherapyList.addAll(opdPhysiotherapyList);
		ipdHistoryDetailsListForFollowUp.addAll(opdHistoryDetailsListForFollowUp);
		
		caseSheetList.addAll(opdDetailsList); //to display opd case sheet
		frequencyList = session.createCriteria(MasFrequency.class).add(Restrictions.eq("Status", "y")).list();
		familyHistoryList = session.createCriteria(PatientFamilyHistory.class).add(Restrictions.eq("Status", "y")).list();
		masIcdList = session.createCriteria(MasIcd.class).add(Restrictions.eq("Status", "y")).list();
		dietTypeList = session.createCriteria(MasDiet.class).add(Restrictions.eq("Status", "y")).list();
		
		int hospitalId = box.getInt("hospitalId");
		templateList = session.createCriteria(OpdTemplate.class)
				.createAlias("Hospital", "hospital").add(Restrictions.eq("hospital.Id", hospitalId))
				.createAlias("Department", "dept").add(Restrictions.eq("dept.Id", box.getInt("deptId")))
				.add(Restrictions.eq("Status", "y")).list();
		masImpanneledHospitalList = session.createCriteria(MasImpanneledHospital.class)
				.add(Restrictions.eq("Status", "Y").ignoreCase())
				.list();
		deptList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y"))
				.createAlias("DepartmentType", "dt")
				.add(Restrictions.or(Restrictions.eq("dt.DepartmentTypeCode",departmentTypeCode), Restrictions.eq("dt.DepartmentTypeCode",departmentTypeCodeForOpd)))
				.createAlias("Hospital", "hos")
					.add(Restrictions.eq("hos.Id",hospitalId))
			.addOrder(Order.asc("DepartmentName")).list();
		
		map.put("masImpanneledHospitalList", masImpanneledHospitalList);
		map.put("deptList", deptList);
		map.put("templateList", templateList);
		map.put("caseSheetList", caseSheetList);
		map.put("inpatientList", inpatientList);
		map.put("opdDetailsList", opdDetailsList);
		map.put("ipdPrescriptionList", ipdPrescriptionList);
		map.put("ipdInvestigationList", ipdInvestigationList);
		map.put("ipIcdList", ipIcdList);
//		map.put("ipdProcedureList", ipdProcedureList);
//		map.put("ipdPhysiotherapyList", ipdPhysiotherapyList);
		map.put("ipdHistoryDetailsListForFollowUp", ipdHistoryDetailsListForFollowUp);
		map.put("ipdPatientDietList", ipdPatientDietList);
		map.put("frequencyList", frequencyList);
		map.put("familyHistoryList", familyHistoryList);
		map.put("masIcdList", masIcdList);
		map.put("dietTypeList", dietTypeList);
	
		
	//	map.put("opdProcedureList",opdProcedureList);

		return map;
	}	

	
	public Map<String, Object> getPreAnesthesiaDeials(Map mapForDS) {
		Session session = (Session) getSession();
		Criteria crit = null;
		List<OtPreAnaesthesiaProcNotesMain> preAnesthesiaList = new ArrayList<OtPreAnaesthesiaProcNotesMain>();
		List<OtPreOpInstruction> otPreOpInstructionList = new ArrayList<OtPreOpInstruction>();
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();
		List<PatientPrescriptionDetails> prescriptionList = new ArrayList<PatientPrescriptionDetails>();
		List<DgOrderdt> investigationList = new ArrayList<DgOrderdt>();
	
		Map<String, Object> map = new HashMap<String, Object>();
		  int hospitalId = (Integer)mapForDS.get(HOSPITAL_ID);
		    //int visitId = (Integer)mapForDS.get("visitId");
		    int inpatientId = (Integer)mapForDS.get("inpatientId");
		     int  bookingId = (Integer)mapForDS.get("bookingId");
	   // int docId = (Integer)mapForDS.get("docId");
	//	int preAnesthesiaDetailId = 0;
		 List<PreAnesthesiaConsultDoctorDt> requestList = new ArrayList<PreAnesthesiaConsultDoctorDt>();
		String icd="";
		//String anesthesia ="";
		try {
			
			
			otBookingList = session.createCriteria(OtBooking.class)
					
					.add(Restrictions.eq("id", bookingId))
					.add(Restrictions.eq("OtPreAnesthesiaStatus", "y").ignoreCase()).list();
		
			if(otBookingList.size()>0)
			{
		/*	
			otPreAnesthesiaDetailsList = session.createCriteria(
					OtPreAnesthesiaDetails.class).add(
					Restrictions.eq("Id", preAnesthesiaDetailId)).list();*/
			
				preAnesthesiaList = session.createCriteria(
						OtPreAnaesthesiaProcNotesMain.class)
						.add(Restrictions.eq("Booking.Id", bookingId))
						.list();
					//.createAlias("OpdSurgeryHeader", "OpdSurgeryHeader")
			
			if(preAnesthesiaList.size() > 0)
			{
				otPreOpInstructionList = session.createCriteria(
						OtPreOpInstruction.class)
						.add(Restrictions.eq("OtPreAnaesthesiaProcNotesMain.Id", preAnesthesiaList.get(0).getId()))
						.list();

				String preAnesCode = HMSUtil.getProperties("adt.properties", "CodeForPreAnesthesia");

				
				
				prescriptionList = session.createCriteria(PatientPrescriptionDetails.class)
						.createAlias("Prescription", "hd")
						.createAlias("hd.Inpatient", "ip")
						.add(Restrictions.eq("ip.Id", inpatientId))
						.add(Restrictions.eq("OtStage", preAnesCode).ignoreCase())
						.list();
				
				investigationList = session.createCriteria(DgOrderdt.class)
						.createAlias("Orderhd", "hd")
						.createAlias("hd.Inpatient", "ip")
						.add(Restrictions.eq("ip.Id", inpatientId))
						.add(Restrictions.eq("OtStage", preAnesCode).ignoreCase())
						.list();
				
			}
           }	
			// //System.out.println("size of opdPatientHistoryList=============="+opdPatientHistoryList.size());
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		// //System.out.println("t opdPatientHistoryList asize----"+opdPatientHistoryList.size());
	
		map.put("preAnesthesiaList", preAnesthesiaList);
		map.put("otPreOpInstructionList", otPreOpInstructionList);
		map.put("prescriptionList", prescriptionList);
		map.put("investigationList", investigationList);
		
		
		
//System.out.println("ddd"+otPreAnesthesiaSurgeryList.size());		

		return map;
	}

	public Map<String, Object> getPostAnesthesiaDeials(Map mapForDS) {
		Session session = (Session) getSession();
		Criteria crit = null;
		List<OtPostAnaesthesiaProcedure> postAnesthesiaList = new ArrayList<OtPostAnaesthesiaProcedure>();
		List<OtPostOpInstruction> otPostOpInstructionList = new ArrayList<OtPostOpInstruction>();
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();
		List<PatientPrescriptionDetails> prescriptionList = new ArrayList<PatientPrescriptionDetails>();
		List<DgOrderdt> investigationList = new ArrayList<DgOrderdt>();
	
		Map<String, Object> map = new HashMap<String, Object>();
		  int hospitalId = (Integer)mapForDS.get(HOSPITAL_ID);
		   // int visitId = (Integer)mapForDS.get("visitId");
		    int inpatientId = (Integer)mapForDS.get("inpatientId");
		     int  bookingId = (Integer)mapForDS.get("bookingId");
	   // int docId = (Integer)mapForDS.get("docId");
	//	int preAnesthesiaDetailId = 0;
		     
		 List<PreAnesthesiaConsultDoctorDt> requestList = new ArrayList<PreAnesthesiaConsultDoctorDt>();
		String icd="";
		//String anesthesia ="";
		try {
			
			
			otBookingList = session.createCriteria(OtBooking.class)
					
					.add(Restrictions.eq("id", bookingId))
					.add(Restrictions.eq("OtPreAnesthesiaStatus", "y").ignoreCase()).list();
			
			if(otBookingList.size()>0)
			{
		/*	
			otPreAnesthesiaDetailsList = session.createCriteria(
					OtPreAnesthesiaDetails.class).add(
					Restrictions.eq("Id", preAnesthesiaDetailId)).list();*/
			
				postAnesthesiaList = session.createCriteria(
						OtPostAnaesthesiaProcedure.class)
						.add(Restrictions.eq("OtBooking.Id", bookingId))
						.list();
					//.createAlias("OpdSurgeryHeader", "OpdSurgeryHeader")
			//System.out.println(postAnesthesiaList.size()+" "+postAnesthesiaList.get(0).getId());
			if(postAnesthesiaList.size() > 0)
			{
				otPostOpInstructionList = session.createCriteria(
						OtPostOpInstruction.class)
						.add(Restrictions.eq("OtPostAnaesthesiaProcedure.Id", postAnesthesiaList.get(0).getId()))
						.list();

				String postAnesCode = HMSUtil.getProperties("adt.properties", "CodeForPostAnesthesia");

				
				
				prescriptionList = session.createCriteria(PatientPrescriptionDetails.class)
						.createAlias("Prescription", "hd")
						.createAlias("hd.Inpatient", "ip")
						.add(Restrictions.eq("ip.Id", inpatientId))
						.add(Restrictions.eq("OtStage", postAnesCode).ignoreCase())
						.list();
				
				
				investigationList = session.createCriteria(DgOrderdt.class)
						.createAlias("Orderhd", "hd")
						.createAlias("hd.Inpatient", "ip")
						.add(Restrictions.eq("ip.Id", inpatientId))
						.add(Restrictions.eq("OtStage", postAnesCode).ignoreCase())
						.list();
				
			}
           }	
			// //System.out.println("size of opdPatientHistoryList=============="+opdPatientHistoryList.size());
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	
		map.put("postAnesthesiaList", postAnesthesiaList);
		map.put("otPostOpInstructionList", otPostOpInstructionList);
		map.put("prescriptionList", prescriptionList);
		map.put("investigationList", investigationList);
		return map;
	}


}
