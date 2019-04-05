/**  
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms
 * Class DischargeDataServiceImpl.java 
 * To feed discharge summary details 
 * Tables Used: discharge_items, discharge_items_category, discharge_summary, discharge_icd_code, mas_icd 
 * @author  Create Date: 11.02.2008 Name: Othivadivel K R 
 * Revision Date:      		Revision By: 
 * @version 1.0  
 * @see DischargeController.java, DischargeHandlerService.java, DischargeHandlerServiceImpl.java, DischargeDataService.java
 **/

package jkt.hms.discharge.dataservice;

import static jkt.hms.util.RequestConstants.ADMISSION_NUMBER;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.MEDICAL_OFFICER_ID;

import java.awt.BasicStroke;
import java.awt.Color;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import jkt.hms.masters.business.Category;
import jkt.hms.masters.business.Discharge;
import jkt.hms.masters.business.DischargeIcdCode;
import jkt.hms.masters.business.DischargeItemsCategory;
import jkt.hms.masters.business.DischargeSummary;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.IpdIntakeOutputChart;
import jkt.hms.masters.business.IpdTemperature;
import jkt.hms.masters.business.MasBed;
import jkt.hms.masters.business.MasBedStatus;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDischargeStatus;
import jkt.hms.masters.business.MasDisposedTo;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasIcd;
import jkt.hms.masters.business.MasImpanneledHospital;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasSystemDiagnosis;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.OpdPatientHistory;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientDischargeSlip;
import jkt.hms.masters.business.PatientInvestigationDetails;
import jkt.hms.masters.business.PatientInvestigationHeader;
import jkt.hms.masters.business.PatientPrescriptionDetails;
import jkt.hms.masters.business.PatientPrescriptionHeader;
import jkt.hms.masters.business.PhysioRequisitionDetail;
import jkt.hms.masters.business.PhysioRequisitionHeader;
import jkt.hms.masters.business.ProcedureDetails;
import jkt.hms.masters.business.ProcedureHeader;
import jkt.hms.masters.business.Transfer;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import net.sf.jasperreports.renderers.JFreeChartRenderer;
import oracle.jdbc.OracleTypes;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.RectangleInsets;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class DischargeDataServiceImpl extends HibernateDaoSupport implements
		DischargeDataService {

	@SuppressWarnings("unchecked")
	/*
	 * public Map<String, Object> getDischargePatientDetails(int inPatient) {
	 * List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
	 * Map<String ,Object> map= new HashMap<String, Object>(); Session session =
	 * (Session) getSession(); try {
	 * org.springframework.orm.hibernate3.HibernateTemplate hbt =
	 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_EAGER");
	 * hbt.setCheckWriteOperations(false); inPatientDetailList =
	 * session.createCriteria(Inpatient.class).add(Restrictions.eq("Id",
	 * inPatient)).list(); } catch (HibernateException e) { e.printStackTrace();
	 * } map.put("inPatientDetailList", inPatientDetailList); return map; }
	 */
	public Map<String, Object> getDischargePatientDetails(int inPatient,Box box) {
		List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		List<Integer> dischargeNoList = new ArrayList<Integer>();
		List<MasDisposedTo> disposedToList = new ArrayList<MasDisposedTo>();
		List<Category> categoryList = new ArrayList<Category>();
		List<MasDischargeStatus> dischargeStatusList= new ArrayList<MasDischargeStatus>();
		List<MasImpanneledHospital> masImpanneledHospitalList = new ArrayList<MasImpanneledHospital>();
		
		/*List<DischargeSummary> dischargeSummaryList = new ArrayList<DischargeSummary>();
		DischargeSummary dischargeSummaryObj = new DischargeSummary();
		Inpatient inPatientObj = new Inpatient();
		String admn_no = null;*/
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			inPatientDetailList = session.createCriteria(Inpatient.class).add(
					Restrictions.eq("Id", inPatient)).list();
			/*if (inPatientDetailList != null && inPatientDetailList.size() > 0) {
				inPatientObj = inPatientDetailList.get(0);
				admn_no = inPatientObj.getAdNo();
				dischargeSummaryList = hbt
						.find("from jkt.hms.masters.business.DischargeSummary as inp where inp.AdNo = '"
								+ admn_no + "'");
				if (dischargeSummaryList != null
						&& dischargeSummaryList.size() > 0) {
					dischargeSummaryObj = dischargeSummaryList.get(0);
					String category_name = dischargeSummaryObj.getItemCode()
							.getCategoryName();
					map.put("category_name", category_name);
				}
			}*/
			List<PatientPrescriptionDetails> ipdPrescriptionList = new ArrayList<PatientPrescriptionDetails>();
			List<PatientInvestigationDetails> ipdInvestigationList = new ArrayList<PatientInvestigationDetails>();
			List<DischargeIcdCode> ipIcdList = new ArrayList<DischargeIcdCode>();
			List<ProcedureDetails> ipdProcedureList = new ArrayList<ProcedureDetails>();
			List<Object[]> caseNotesList = new ArrayList<Object[]>();
			caseNotesList = session.createCriteria(OpdPatientDetails.class).add(Restrictions.eq("Inpatient.Id", inPatient)).addOrder(Order.desc("id")).setProjection(Projections.projectionList().add(Projections.property("CaseNotes")).add(Projections.property("id"))).setMaxResults(1).list();
			System.out.println("inPatientId="+inPatient);
			/*ipdPrescriptionList = session.createCriteria(PatientPrescriptionHeader.class).createAlias("Inpatient", "ip").add(Restrictions.eq("ip.Id", inPatient)).addOrder(Order.desc("Id")).list();
			ipdInvestigationList = session.createCriteria(PatientInvestigationHeader.class).createAlias("Inpatient", "ip").add(Restrictions.eq("ip.Id", inPatient)).addOrder(Order.desc("Id")).list();*/
			ipdPrescriptionList = session.createCriteria(PatientPrescriptionDetails.class).createAlias("Prescription", "p").createAlias("p.Inpatient", "ip").add(Restrictions.eq("ip.Id", inPatient)).addOrder(Order.desc("Id")).list();
			ipdInvestigationList = session.createCriteria(PatientInvestigationDetails.class).createAlias("InvestigationHeader", "ih").createAlias("ih.Inpatient", "ip").add(Restrictions.eq("ip.Id", inPatient)).addOrder(Order.desc("Id")).list();
			ipdProcedureList = session.createCriteria(ProcedureDetails.class).createAlias("ProcedureHeader", "p").createAlias("p.Inpatient", "ip").add(Restrictions.eq("ip.Id", box.getInt("parent"))).addOrder(Order.desc("Id")).list();
			System.out.println("ipdInvestigationList="+ipdInvestigationList.size());
			
			/**
			 * For getting last diagnosis for Discharge Summary
			 */
			int lastIPDId = 0;
			if(caseNotesList.size()>0){
				for(Object[] obj :caseNotesList){
					lastIPDId = (Integer)obj[1];
				}
			}
			ipIcdList = session.createCriteria(DischargeIcdCode.class).createAlias("Inpatient", "ip").add(Restrictions.eq("ip.Id", inPatient)).add(Restrictions.eq("OpdPatientDetails.id", lastIPDId)).addOrder(Order.desc("Id")).list();
			
			dischargeNoList = session.createCriteria(PatientDischargeSlip.class).setProjection(Projections.property("DischargeNo")).addOrder(Order.desc("Id")).list();
			
			
			List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
			int hinId = 0;
			hinId = inPatientDetailList.get(0).getHin().getId();
			diagnosisList = session.createCriteria(DischargeIcdCode.class).createAlias("Hin", "h").add(Restrictions.eq("h.Id", hinId)).addOrder(Order.desc("Id")).setMaxResults(1).list();
			
			masImpanneledHospitalList = session.createCriteria(MasImpanneledHospital.class)
					.add(Restrictions.eq("Status", "Y").ignoreCase())
					.list();
			
			map.put("diagnosisList", diagnosisList);
			map.put("masImpanneledHospitalList", masImpanneledHospitalList);
			
			map.put("ipdPrescriptionList", ipdPrescriptionList);
			map.put("ipdInvestigationList", ipdInvestigationList);
			map.put("ipIcdList",ipIcdList);
			map.put("ipdProcedureList",ipdProcedureList);
			map.put("dischargeNoList",dischargeNoList);
			map.put("caseNotesList",caseNotesList);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
		doctorList = session.createCriteria(MasEmployee.class).createAlias("Hospital", "h")
			.add(Restrictions.eq("h.Id", box.getInt(HOSPITAL_ID))).createAlias("EmpCategory", "ec")
			.add(Restrictions.eq("ec.EmpCategoryCode", empCategoryCodeForDoctor))
			.add(Restrictions.eq("Status","y")).addOrder(Order.asc("FirstName")).list();
		String contractCode = HMSUtil.getProperties("adt.properties","empStatusCodeForContract");
		Criteria cri = session.createCriteria(MasDisposedTo.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DisposedToName"));
		System.out.println("before");
		if(inPatientDetailList.get(0).getHin().getEmployee()!=null && inPatientDetailList.get(0).getHin().getEmployee().getEmployeeStatus().getEmpStatusCode().equalsIgnoreCase(contractCode))
		{
			cri.add(Restrictions.ne("DisposedToName", "Empanel").ignoreCase());
		}
		
		disposedToList = cri.list();
		
		categoryList =  session.createCriteria(Category.class).addOrder(Order.asc("Categories")).list();
		dischargeStatusList = session.createCriteria(MasDischargeStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DischargeStatusName")).list();
		
		
		map.put("doctorList", doctorList);
		map.put("disposedToList", disposedToList);
		map.put("categoryList", categoryList);
		map.put("inPatientDetailList", inPatientDetailList);
		map.put("dischargeStatusList", dischargeStatusList);
		return map;
	}

	public Map<String, Object> getAdmissionNumberList(Map requestParameters) {
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		boolean hinNoFound = false;
		String serviceNo = "";
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (requestParameters.get(SERVICE_NO) != null) {
				serviceNo = (String) requestParameters.get(SERVICE_NO)
						.toString().trim();
			}
			// int hospital_id = (Integer)requestParameters.get(HOSPITAL_ID);
			// hospitalList =
			// session.createCriteria(MasHospital.class).add(Restrictions.eq("Id",
			// hospital_id)).list();

			//System.out.println("service no ::::::::::" + serviceNo);
			inpatientList = session.createCriteria(Inpatient.class)
					.createAlias("Hin", "p").add(
							Restrictions.eq("p.ServiceNo", serviceNo)).list();

			//System.out.println("inpatientList size::::::"	+ inpatientList.size());
			if (inpatientList != null && inpatientList.size() > 0) {
				hinNoFound = true;
			}
			/*
			 * Set<Patient> patientSet = null; Set admissionNumbersSet = new
			 * TreeSet(); if (hospitalList != null && hospitalList.size() > 0)
			 * patientSet = (Set)hospitalList.get(0).getPatients();
			 * 
			 * for (Iterator iter = patientSet.iterator(); iter.hasNext();) {
			 * Patient patient = (Patient) iter.next();
			 * 
			 * if (requestParameters.get(SERVICE_NO)!=null &&
			 * requestParameters.get
			 * (SERVICE_NO).toString().trim().equalsIgnoreCase
			 * (patient.getServiceNo())) { hinNoFound = true; Set<Inpatient>
			 * inpatientSet = (Set)patient.getInpatients();
			 * map.put("inpatientSet", inpatientSet);
			 * 
			 * //Join using HQL
			 * 
			 * Query q =session.createQuery(
			 * "from jkt.hms.masters.business.DischargeSummary a join a.ItemCode b where a.Hin.HinNo='"
			 * + requestParameters.get(HIN_NO).toString() +"'"); Iterator pairs
			 * = q.list().iterator(); DischargeSummary a = null;
			 * DischargeItemsCategory b = null; while ( pairs.hasNext() ) {
			 * Object[] pair = (Object[]) pairs.next(); a = (DischargeSummary)
			 * pair[0]; b = (DischargeItemsCategory) pair[1];
			 * //System.out.println("admn no" + a.getAdNo() + "Category Name" +
			 * a.getItemCode().getCategoryName());
			 * admissionNumbersSet.add(a.getAdNo());
			 * map.put(a.getAdNo(),a.getItemCode().getCategoryName()); }
			 * //System.out.println("set values " + admissionNumbersSet);
			 * map.put("admissionNumbersSet", admissionNumbersSet); } }
			 */} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("inpatientSet", inpatientList);
		map.put("hinNoFound", hinNoFound);
		return map;
	}

	/*
	 * This method is used to get the input fields dynamically from the database
	 * depends upon the department(General, Obestetrics and Gynaecology &
	 * Pediatrics) which is selected by the User.
	 * 
	 * Phase I: (Implemented)
	 * 
	 * Diagnosis Details (ie.ICD Code and Name) of the concerned patient should
	 * be available to the Input Screen at the time of Entry. This Diagnosis
	 * Detail is retrieved using the tables discharge_icd_code and mas_icd.
	 * 
	 * 
	 * 
	 * Phase II: (To be implemented at a Later Stage)
	 * 
	 * Investigation Details should also be available to the Input Screen at the
	 * time of Data Entry. Investigation Details can be retrieved from the
	 * concerned tables.
	 */

	public Map<String, Object> getDischargeFields(Map requestParameters) {
		List<DischargeItemsCategory> dischargeItemsCategoryList = new ArrayList<DischargeItemsCategory>();
		List<DischargeSummary> dischargeSummaryList = new ArrayList<DischargeSummary>();
		Set<DischargeIcdCode> dischargeIcdCodeSet = null;
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		Map<String, Object> map = new HashMap<String, Object>();
		boolean isRecordAlreadyExists = false;
		String casetype = (String) requestParameters.get("casetype");
		String admissionNumber = (String) requestParameters
				.get(ADMISSION_NUMBER);
		String discharge_item_code = "";
		String reply = "";
		StringBuffer icd_code_and_name = new StringBuffer();
		int inpatientId = Integer.parseInt(requestParameters.get(INPATIENT_ID)
				.toString());

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			dischargeItemsCategoryList = hbt
					.find("from jkt.hms.masters.business.DischargeItemsCategory as inp where inp.CategoryName ='"
							+ casetype + "' order by inp.Orderno");
			dischargeSummaryList = hbt
					.find("from jkt.hms.masters.business.DischargeSummary as inp where inp.AdNo = '"
							+ admissionNumber.trim() + "'");
			inpatientList = hbt
					.find("from jkt.hms.masters.business.Inpatient as inp where inp.Id = "
							+ inpatientId);

			if (dischargeSummaryList.size() > 0)
				isRecordAlreadyExists = true;

			if (inpatientList != null && inpatientList.size() > 0) {
				dischargeIcdCodeSet = inpatientList.get(0)
						.getDischargeIcdCodes();

				for (Iterator iter = dischargeIcdCodeSet.iterator(); iter
						.hasNext();) {
					DischargeIcdCode dischargeIcdCode = (DischargeIcdCode) iter
							.next();
					if (dischargeIcdCode.getDiagnosisStatus().equalsIgnoreCase(
							"f")) {
						try {
							if (icd_code_and_name.length() > 0) {
								icd_code_and_name.append(", ");
								icd_code_and_name.append(dischargeIcdCode
										.getIcd().getIcdCode());
								icd_code_and_name.append(" ");
							} else {
								icd_code_and_name.append(dischargeIcdCode
										.getIcd().getIcdCode());
								icd_code_and_name.append(" ");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}

						try {
							icd_code_and_name.append(dischargeIcdCode.getIcd()
									.getIcdName());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} // dischargeIcdCodeSet Iterator for loop ends here
			}

			map.put("DIAG", icd_code_and_name.toString());

			for (int i = 0; i < dischargeSummaryList.size(); i++) {
				String code = dischargeSummaryList.get(i).getItemCode().getId()
						.toString();

				try {
					discharge_item_code = dischargeSummaryList.get(i)
							.getItemCode().getItemCode().getItemCode();
				} catch (Exception e) {
					discharge_item_code = "";
				}

				if (discharge_item_code.equalsIgnoreCase("DIAG")) {
					reply = icd_code_and_name.toString();
				} else {
					reply = dischargeSummaryList.get(i).getItemReply();
				}
				map.put(code, reply);
			} // dischargeSummaryList for loop ends here
			map.put("isRecordAlreadyExists", isRecordAlreadyExists);
		} // main try block ends here
		catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("dischargeItemsCategoryList", dischargeItemsCategoryList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> addDischargeSummary(Map requestDataMap,Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		List<DischargeItemsCategory> dischargeItemsCategoryList = new ArrayList<DischargeItemsCategory>();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		DischargeSummary dischargeSummary = null;
		OpdPatientDetails opdPatientDetails = new OpdPatientDetails();

		//String casetype = null;
		//String ad_no = null;
		//int hin_id = 0;
		//int hospital_id = 0;
		String message = null;
		Transaction tx = null;

		try {
			tx= session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Users user = new Users();
			user.setId(box.getInt("userId"));			
			PatientDischargeSlip patientDischargeSlip = new PatientDischargeSlip();
			patientDischargeSlip.setAdNo(box.getString(ADMISSION_NUMBER));
			Patient patient = new Patient();
			patient.setId(box.getInt(HIN_ID));
			patientDischargeSlip.setHin(patient);
			Inpatient inpatient = new Inpatient();
			inpatient.setId(box.getInt(INPATIENT_ID));
			patientDischargeSlip.setInpatient(inpatient);
			patientDischargeSlip.setHistoryExamination(box.getString("historyExamination"));
			patientDischargeSlip.setInvestigation(box.getString("investigation"));
			patientDischargeSlip.setDiagnosis(box.getString("diagnosis"));
			patientDischargeSlip.setProcedureDetails(box.get("procedureDetails"));
			patientDischargeSlip.setTreatment(box.getString("treatment"));
			patientDischargeSlip.setFollowUp(box.getString("followUp"));
			patientDischargeSlip.setDischargeDate(HMSUtil.convertStringTypeDateToDateType(box.getString("dischargeDate")));
			patientDischargeSlip.setDischargeTime(box.getString("dischargeTime"));
			patientDischargeSlip.setDischargeNo(box.getInt("dischargeNo"));
			patientDischargeSlip.setLastChgBy(user);
			patientDischargeSlip.setPatientCondition(box.getString("patientCondition"));
			patientDischargeSlip.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString("dischargeDate")));
			patientDischargeSlip.setLastChgTime(box.getString("dischargeTime"));
			if(box.getInt("medicalCategory")!=0){
				Category category = new Category();
				category.setCategoryid(box.getInt("medicalCategory"));
				patientDischargeSlip.setMedCategory(category);
			}
			if(box.getInt("dischargeTo")!=0){
				MasDisposedTo disposedTo = new MasDisposedTo();
				disposedTo.setId(box.getInt("dischargeTo"));
				patientDischargeSlip.setDischargeTo(disposedTo);
			}
			if(box.getInt("dischargeStatus")!=0){
				MasDischargeStatus dischargeStatus = new MasDischargeStatus();
				dischargeStatus.setId(box.getInt("dischargeStatus"));
				patientDischargeSlip.setDischargeStatus(dischargeStatus);
			}
			patientDischargeSlip.setMh(box.getString("mh"));
			patientDischargeSlip.setMhDepartment(box.getString("mhDepartment"));
			patientDischargeSlip.setReferredFor(box.getString("referredFor"));
			
			patientDischargeSlip.setInstructionToPatient(box.getString("instructionToPatient"));
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(box.getInt(MEDICAL_OFFICER_ID));
			patientDischargeSlip.setDoctor(masEmployee);
			
			if(box.getInt(HOSPITAL_ID)!=0){
				MasHospital hospital = new MasHospital();
				hospital.setId(box.getInt(HOSPITAL_ID));
				patientDischargeSlip.setHospital(hospital);
			}
			if(!box.getString("reviewDate").equals(""))
				patientDischargeSlip.setReviewOn(HMSUtil.convertStringTypeDateToDateType(box.getString("reviewDate")));
			
			hbt.save(patientDischargeSlip);
			
			
			Inpatient inpatientObj = (Inpatient)hbt.load(Inpatient.class, box.getInt(INPATIENT_ID));
			int bedId = inpatientObj.getBed().getId();
		
			inpatientObj.setAdStatus("D");
			inpatientObj.setStatus("n");
			inpatientObj.setDischargeDate(HMSUtil.convertStringTypeDateToDateType(box.getString("dischargeDate")));
			inpatientObj.setDischargeTime(box.getString("dischargeTime"));
			hbt.update(inpatientObj);
		
			session.createQuery("update OpdPatientDetails opd set opd.AdmissionAdvised = 'C' where Visit.Id= "+inpatientObj.getVisit().getId()).executeUpdate();
			
			

			Patient patientObj = (Patient)hbt.load(Patient.class, box.getInt(HIN_ID));
			System.out.println("box.getInt(HIN_ID)"+box.getInt(HIN_ID));
			System.out.println("box.getString()"+box.getString("patientCondition"));
			if(box.getString("patientCondition").equalsIgnoreCase("Dead")){
				patientObj.setPatientStatus("Expired");
			}else{
				patientObj.setPatientStatus("Out Patient");
			}
			patientObj.setPaymentStatus(null);
			patientObj.setInpatientNo(0);
			hbt.update(patientObj);

			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
			int bedStatusUnOccupiedId = Integer.parseInt(properties.getProperty("bedStatusUnOccupiedId"));
			
			/*List<Inpatient> patinetOnSameBed = new ArrayList<Inpatient>();
			patinetOnSameBed = session.createCriteria(Inpatient.class)
			.add(Restrictions.eq("Bed.Id", bedId)).list();
			if(patinetOnSameBed.size()==1)
			{*/
		
				MasBedStatus masBedStatus = new MasBedStatus();
				masBedStatus.setId(bedStatusUnOccupiedId);
				inpatientObj.getBed().setBedStatus(masBedStatus);
				/*masBed.setBedStatus(masBedStatus);*/
				hbt.flush();
			/*}
			*/
			
			// code start for referral by atul
			
			String  externalReferralType = HMSUtil.getProperties("adt.properties", "externalReferralType");
			MasDisposedTo masDischargeTo = (MasDisposedTo)session.load(MasDisposedTo.class, box.getInt("dischargeTo"));
			if(externalReferralType.equalsIgnoreCase(masDischargeTo.getDisposedToName()))
			{
						
						int referredHospitalId = 0;
						String patientAdvise = null;
						String referralNote = null;
						int referralPriority=0;
									
				
						if (box.get("patientAdvise") != null) {
							patientAdvise = (String) box.get("patientAdvise");
							opdPatientDetails.setPatientAdvise(patientAdvise);
							System.out.println("patientAdvise="+box.get("patientAdvise"));
						}

						
						Date referralDate = HMSUtil.convertStringTypeDateToDateType(box.getString("referVisitDate"));
						opdPatientDetails.setReferredDate(referralDate);
						
						if (box.get("remarksBYDoc") != null) {
							
							referralNote = (String) box.get("remarksBYDoc");
							
							opdPatientDetails.setReferralNotes(referralNote);
						}
						

							
							 opdPatientDetails.setReferredType(externalReferralType);
							 opdPatientDetails.setReferredStatus("y");							
							
				
								if (box.get("referhospital") != null) {
									referredHospitalId = (Integer) box.getInt("referhospital");
									MasImpanneledHospital msih = new MasImpanneledHospital();
									msih.setId(referredHospitalId);
									
									opdPatientDetails.setImpanneledHospital(msih);
									if (box.get("referdays") != null && !box.get("referdays").equals(""))
									{
										try{
											int referdays = box.getInt("referdays"); 
											Date referalTillDate=HMSUtil.addDaysToDate(box.getString("referVisitDate"), referdays);
											opdPatientDetails.setReferTillDate(referalTillDate);
											
										}catch(Exception e){
											e.printStackTrace();
										}
										
									}
									
									
								}
								opdPatientDetails.setInpatient(inpatient);		
								
								opdPatientDetails.setEmployee(masEmployee);
								
								MasHospital masHospitalObj = new MasHospital();
								masHospitalObj.setId(box.getInt("hospitalId"));
								opdPatientDetails.setHospital(masHospitalObj);
								
								
								opdPatientDetails.setConsultationTime(box.getString("dischargeTime"));
								opdPatientDetails.setConsultationDate(new Date());	
								opdPatientDetails.setOpdTime(box.getString("dischargeTime"));
								opdPatientDetails.setOpdDate(new Date());	
								opdPatientDetails.setEmpanelStatus("WR");
								opdPatientDetails.setReferralDays(box.getInt("referdays"));	
								opdPatientDetails.setReferralTreatmentType(box.getString("referral_treatment_type"));
								opdPatientDetails.setReferredFor(box.getString("referredFor"));
								opdPatientDetails.setVisit(inpatientObj.getVisit());		
								opdPatientDetails.setInitialDiagnosis("");					
								
								OpdPatientDetails opdLast = new OpdPatientDetails();
								/*for (Iterator collectionItr = inpatientObj.getOpdPatientDetails().iterator(); collectionItr.hasNext(); ) {
									opdLast = (OpdPatientDetails)collectionItr.next();
									}*/
								List<DischargeIcdCode> dicList  = new ArrayList<DischargeIcdCode>();
								dicList = session.createCriteria(DischargeIcdCode.class)
								.createAlias("OpdPatientDetails", "opd")
								.createAlias("opd.Inpatient", "ipd")
								.add(Restrictions.eq("ipd.Id", inpatientObj.getId()))
								.addOrder(Order.desc("Id")).list();
								
								if(dicList.size()==0)
								{
									 dicList = session.createCriteria(DischargeIcdCode.class)
											.createAlias("OpdPatientDetails", "opd")											
											.createAlias("opd.Visit", "v")
											.add(Restrictions.eq("v.Id", inpatientObj.getVisit().getId()))
											.addOrder(Order.desc("Id")).list();
								}
								
								
							
								
								System.out.println("opdLast"+dicList.size());
								
								
								hbt.save(opdPatientDetails);								 
								String icdNames = "";
								for(DischargeIcdCode dic : dicList){
									DischargeIcdCode dicNew = new DischargeIcdCode(dic);
									dicNew.setOpdPatientDetails(opdPatientDetails);
									System.out.println("opdPatientDetails"+opdPatientDetails.getId());
									icdNames+=dicNew.getIcd().getIcdName()+", ";
									hbt.save(dicNew);
									hbt.flush();
								}							
								if(!icdNames.equals("")){
									icdNames = icdNames.substring(0, (icdNames.length()-2));
								}
								
								opdPatientDetails.setIcd(icdNames);
								hbt.update(opdPatientDetails);
						
					}	
			
			
			
		
			
			
			// code end for referral by atul
			
			try {
				deptList = session.createCriteria(MasDepartment.class).add(
						Restrictions.eq("Id", Integer.parseInt(requestDataMap
								.get(DEPARTMENT_ID).toString()))).list();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			MasDepartment masDepartment = (MasDepartment) deptList.get(0);
			map.put("deptName", masDepartment.getDepartmentName());
			Set inPatientSet = (Set) masDepartment.getInpatients();
			String takeSetFromSessionInJsp = "false";
			map.put("takeSetFromSessionInJsp", takeSetFromSessionInJsp);
			map.put("inpatientSet", inPatientSet);
			message = "Discharge Slip added successfully .Do you want to print?";
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			List<PatientDischargeSlip> dischargeSummaryList = new ArrayList<PatientDischargeSlip>();
			dischargeSummaryList = session.createCriteria(PatientDischargeSlip.class).add(Restrictions.eq("Inpatient.Id",box.getInt(INPATIENT_ID))).list();
			String hospCrs = "";
			PatientDischargeSlip discharge = new PatientDischargeSlip();
			if(dischargeSummaryList.size() > 0){
				discharge = dischargeSummaryList.get(0);
			}
			List<Object[]> dischargeIcdList = new ArrayList<Object[]>();
			dischargeIcdList = session.createCriteria(DischargeIcdCode.class).createAlias("Inpatient", "ip").add(Restrictions.eq("ip.Id",inpatient.getId()))
				.createAlias("Icd", "icd").setProjection(Projections.distinct(Projections.projectionList().add(Projections.property("icd.IcdCode")).add(Projections.property("icd.IcdName"))))
						.list();
			String icds = "";
			String icdNames = "";
			if(dischargeIcdList.size() > 0){
				int i=1;
				for(Object[] dischargeIcdCode : dischargeIcdList){
						if(i!=1){
							icds +=" /";
							icdNames +=" /";
						}
						icds = icds.concat(dischargeIcdCode[0].toString());
						icdNames =icdNames.concat(dischargeIcdCode[1].toString());

					i++;
				}
			}
	
			
			tx.commit();
		} catch (Exception e) {
			message = "Record not Added!! Please Try Again...";
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}

		map.put("message", message);
		return map;
	}

	public Map<String, Object> getDischargeSummaryReportDetails(
			Map requestParameters) {
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		boolean dischargeSummaryReportDetailsExist = false;
		String casetype = "";
		String AdNo = "";
		String HinNo = "";
		String ServiceNo = "";
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			int hospital_id = (Integer) requestParameters.get(HOSPITAL_ID);
			hospitalList = session.createCriteria(MasHospital.class).add(
					Restrictions.eq("Id", hospital_id)).list();
			Set<Patient> patientSet = (Set) hospitalList.get(0).getPatients();
			if (requestParameters.get(ADMISSION_NUMBER) != null) {
				AdNo = requestParameters.get(ADMISSION_NUMBER).toString()
						.trim();
			}
			if (requestParameters.get(HIN_NO) != null) {
				HinNo = requestParameters.get(HIN_NO).toString().trim();
			}
			if (requestParameters.get(SERVICE_NO) != null) {
				ServiceNo = requestParameters.get(SERVICE_NO).toString().trim();
			}
			patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("ServiceNo", ServiceNo)).list();
			inpatientList = session.createCriteria(Inpatient.class)
					.createAlias("Hin", "p").add(
							Restrictions.eq("p.ServiceNo", ServiceNo)).add(
							Restrictions.eq("AdNo", AdNo)).list();
			if (inpatientList.size() > 0) {
				for (Patient patient : patientList) {
					Set<DischargeSummary> dischargeSummarySet = (Set) patient
							.getDischargeSummaries();
					for (DischargeSummary dischargeSummary : dischargeSummarySet) {
						dischargeSummaryReportDetailsExist = true;
						casetype = dischargeSummary.getItemCode()
								.getCategoryName();
						try {
							if (dischargeSummary.getItemCode().getItemCode()
									.getItemCode().equalsIgnoreCase("BWHT"))
								map.put("bodyWeight", dischargeSummary
										.getItemReply());
						} catch (Exception e) {
							map.put("bodyWeight", "-");
						}
						try {
							if (dischargeSummary.getItemCode().getItemCode()
									.getItemCode().equalsIgnoreCase("ANTH"))
								map.put("anthropometry", dischargeSummary
										.getItemReply());
						} catch (Exception e) {
							map.put("anthropometry", "-");
						}
						try {
							if (dischargeSummary.getItemCode().getItemCode()
									.getItemCode().equalsIgnoreCase("OFC"))
								map.put("ofc", dischargeSummary.getItemReply());
						} catch (Exception e) {
							map.put("ofc", "-");
						}

						try {
							if (dischargeSummary.getItemCode().getItemCode()
									.getItemCode().equalsIgnoreCase("WGHT"))
								map.put("weight", dischargeSummary
										.getItemReply());
						} catch (Exception e) {
							map.put("weight", "-");
						}
						try {
							if (dischargeSummary.getItemCode().getItemCode()
									.getItemCode().equalsIgnoreCase("HGHT"))
								map.put("height", dischargeSummary
										.getItemReply());
						} catch (Exception e) {
							map.put("height", "-");
						}
					}
					String patientName = "";
					patientName = patient.getPFirstName();
					if( patient.getPMiddleName()!= null)
						patientName += " "+ patient.getPMiddleName();
					if( patient.getPLastName()!= null)
						patientName += " "+ patient.getPLastName();
					map.put("patientName", patientName);
					map.put("serviceNo", patient.getServiceNo());

					if (patient.getRank() != null) {
						map.put("rank", patient.getRank().getRankName());
					} else {
						map.put("rank", "-");
					}

					if (patient.getRelation() != null) {
						map.put("relation", patient.getRelation()
								.getRelationName());
					} else {
						map.put("relation", "-");
					}
					if (patient.getSex() != null) {
						map.put("sex", patient.getSex()
								.getAdministrativeSexName());
					} else {
						map.put("sex", "-");
					}
					String servicePersonName = "";
					servicePersonName = patient.getSFirstName();
					if( patient.getSMiddleName()!= null)
						servicePersonName += " "+ patient.getSMiddleName();
					if( patient.getSLastName()!= null)
						servicePersonName += " "+ patient.getSLastName();
					
					map.put("servicePersonName", servicePersonName);
					if (patient.getUnit() != null) {
						map.put("unit", patient.getUnit().getUnitName());
					} else {
						map.put("unit", "-");
					}
					if (patient.getBloodGroup() != null) {
						map.put("bloodGroup", patient.getBloodGroup()
								.getBloodGroupName());
					} else {
						map.put("bloodGroup", "-");
					}
					if (patient.getAddress() != null) {
						map.put("address", patient.getAddress());
					} else {
						map.put("address", "-");
					}

				}
				SimpleDateFormat formatOut1 = new SimpleDateFormat("dd-MM-yyyy");
				SimpleDateFormat formatIn1 = new SimpleDateFormat("yyyy-MM-dd");
				for (Inpatient inpatient : inpatientList) {
					try {
						if (inpatient.getDateOfAddmission() != null)
							map.put("doa", formatOut1.format(formatIn1
									.parse(inpatient.getDateOfAddmission()
											.toString())));
						else
							map.put("doa", "-");
					} catch (ParseException e2) {
						e2.printStackTrace();
					}

					try {
						if (inpatient.getDischargeDate() != null)
							map.put("dod", formatOut1.format(formatIn1
									.parse(inpatient.getDischargeDate()
											.toString())));
						// map.put("dod",
						// inpatient.getDischargeDate().toString());
						else
							map.put("dod", "-");

					} catch (ParseException e2) {
						e2.printStackTrace();
					}

					map.put("age", inpatient.getAge());
				}
			}
			// InpatientList =
			// session.createCriteria(Inpatient.class).add(Restrictions.eq("Ad",
			// value))

			/*
			 * for (Iterator iter = patientSet.iterator(); iter.hasNext();) {
			 * Patient patient = (Patient) iter.next(); if
			 * (requestParameters.get
			 * (HIN_NO).toString().equalsIgnoreCase(patient.getHinNo())) {
			 * Set<DischargeSummary> dischargeSummarySet =
			 * (Set)patient.getDischargeSummaries(); for (Iterator iterator =
			 * dischargeSummarySet.iterator(); iterator.hasNext();) {
			 * DischargeSummary dischargeSummary = (DischargeSummary)
			 * iterator.next(); if
			 * (dischargeSummary.getAdNo().equalsIgnoreCase(requestParameters
			 * .get(ADMISSION_NUMBER).toString().trim())) {
			 * dischargeSummaryReportDetailsExist = true; casetype =
			 * dischargeSummary.getItemCode().getCategoryName(); try { if
			 * (dischargeSummary
			 * .getItemCode().getItemCode().getItemCode().equalsIgnoreCase
			 * ("BWHT")) map.put("bodyWeight", dischargeSummary.getItemReply());
			 * } catch(Exception e) { map.put("bodyWeight", "-"); }
			 * 
			 * try { if
			 * (dischargeSummary.getItemCode().getItemCode().getItemCode
			 * ().equalsIgnoreCase("ANTH")) map.put("anthropometry",
			 * dischargeSummary.getItemReply()); } catch(Exception e) {
			 * map.put("anthropometry", "-"); } try { if
			 * (dischargeSummary.getItemCode
			 * ().getItemCode().getItemCode().equalsIgnoreCase("OFC"))
			 * map.put("ofc", dischargeSummary.getItemReply()); }
			 * catch(Exception e) { map.put("ofc", "-"); }
			 * 
			 * try { if
			 * (dischargeSummary.getItemCode().getItemCode().getItemCode
			 * ().equalsIgnoreCase("WGHT")) map.put("weight",
			 * dischargeSummary.getItemReply()); } catch(Exception e) {
			 * map.put("weight", "-"); } try { if
			 * (dischargeSummary.getItemCode()
			 * .getItemCode().getItemCode().equalsIgnoreCase("HGHT"))
			 * map.put("height", dischargeSummary.getItemReply()); }
			 * catch(Exception e) { map.put("height", "-"); } } //end of
			 * Admission Number checking } //end of dischargeSummary iterator
			 * loop map.put("patientName", patient.getPFirstName() + " " +
			 * patient.getPMiddleName() + " " + patient.getPLastName());
			 * map.put("serviceNo", patient.getServiceNo());
			 * 
			 * try { map.put("rank",patient.getRank().getRankName()); }
			 * catch(Exception e) { map.put("rank","-"); }
			 * 
			 * try { map.put("relation",
			 * patient.getRelation().getRelationName()); } catch(Exception e) {
			 * map.put("relation", "-"); } try { map.put("sex",
			 * patient.getSex().getAdministrativeSexName()); } catch(Exception
			 * e) { map.put("sex", "-"); } map.put("servicePersonName",
			 * patient.getSFirstName() + " " + patient.getSMiddleName() + " " +
			 * patient.getSLastName()); try { map.put("unit",
			 * patient.getUnit().getUnitName()); } catch(Exception e) {
			 * map.put("unit", "-"); } try { map.put("bloodGroup",
			 * patient.getBloodGroup().getBloodGroupName()); } catch(Exception
			 * e) { map.put("bloodGroup", "-"); }
			 * 
			 * try { map.put("address", patient.getAddress()); } catch(Exception
			 * e) { map.put("address", "-"); }
			 * 
			 * 
			 * Set<Inpatient> inpatientSet = (Set)patient.getInpatients(); for
			 * (Iterator iterator = inpatientSet.iterator();
			 * iterator.hasNext();) { Inpatient inpatient= (Inpatient)
			 * iterator.next(); if
			 * (requestParameters.get(ADMISSION_NUMBER).toString
			 * ().equalsIgnoreCase(inpatient.getAdNo())) { if
			 * (inpatient.getDischargeDate()!=null) map.put("doa",
			 * inpatient.getDateOfAddmission().toString()); else map.put("doa",
			 * "-");
			 * 
			 * 
			 * if (inpatient.getDischargeDate()!=null) map.put("dod",
			 * inpatient.getDischargeDate().toString()); else map.put("dod",
			 * "-");
			 * 
			 * map.put("age", inpatient.getAge()); } } } //end of if block
			 * (hinNo checking) } //end of patientSet iterator loop
			 */} // end of try block
		catch (HibernateException e) {
			e.printStackTrace();
		}
		Connection con = session.connection();
		map.put("conn", con);
		map.put("dischargeSummaryReportDetailsExist", Boolean
				.valueOf(dischargeSummaryReportDetailsExist));
		map.put("casetype", casetype);
		return map;
	}

	/*public Map<String, Object> getClinicalSheetReportDetails(
			Map requestParameters) {
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<IpdIntakeOutputChart> ipdIntakeOutputChart = new ArrayList<IpdIntakeOutputChart>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<Transfer> transferList = new ArrayList<Transfer>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Set<DischargeIcdCode> dischargeIcdCodeSet = null;
		StringBuffer icd_code_and_name = new StringBuffer();
		try {
			String serviceNo = "";
			String AdNo = "";
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			serviceNo = requestParameters.get(SERVICE_NO).toString().trim();
			AdNo = requestParameters.get(ADMISSION_NUMBER).toString().trim();

			// int hospital_id = (Integer)requestParameters.get(HOSPITAL_ID);
			// hospitalList =
			// session.createCriteria(MasHospital.class).add(Restrictions.eq("Id",
			// hospital_id)).list();
			// ipdIntakeOutputChart =
			// session.createCriteria(IpdIntakeOutputChart.class).add(Restrictions.eq("AdNo",
			// requestParameters.get(ADMISSION_NUMBER).toString())).list();

			patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("ServiceNo", serviceNo)).list();
			inpatientList = session.createCriteria(Inpatient.class).add(
					Restrictions.eq("AdNo", AdNo)).list();

			if (inpatientList != null && inpatientList.size() > 0) {
				for (Patient patient : patientList) {
					map.put("serviceNo", patient.getServiceNo());
					if (patient.getRelation() != null) {
						map.put("relation", patient.getRelation()
								.getRelationName());
					} else {
						map.put("relation", "-");
					}
					if (patient.getSex() != null) {
						map.put("sex", patient.getSex()
								.getAdministrativeSexName());
					} else {
						map.put("sex", "-");
					}
					String sName="";
					sName=patient.getSFirstName();
					if(patient.getSMiddleName()!= null){
						sName += " "+patient.getSMiddleName();
					}
					if(patient.getSLastName()!= null){
						sName += " "+patient.getSLastName();
					}
					map.put("servicePersonName", sName);
					String pName="";
					pName=patient.getPFirstName();
					if(patient.getPMiddleName()!= null){
						pName += " "+patient.getPMiddleName();
					}
					if(patient.getPLastName()!= null){
						pName += " "+patient.getPLastName();
					}
					map.put("patientName",pName);
					if (patient.getUnit() != null) {
						map.put("unit", patient.getUnit().getUnitName());
					} else {
						map.put("unit", "-");
					}
					if (patient.getRank() != null) {
						map.put("rank", patient.getRank().getRankName());
					} else {
						map.put("rank", "-");
					}
				}
				for (Inpatient inpatient : inpatientList) {
					map.put("age", inpatient.getAge());

					if (inpatient.getDischargeDate() != null) {
						map.put("doa", inpatient.getDateOfAddmission()
								.toString());
					} else {
						map.put("doa", "-");
					}
					if (inpatient.getDischargeDate() != null) {
						map.put("dod", inpatient.getDischargeDate().toString());
					} else {
						map.put("dod", "-");
					}

					dischargeIcdCodeSet = inpatient.getDischargeIcdCodes();
					for (DischargeIcdCode icdCode : dischargeIcdCodeSet) {
						try {
							if (icd_code_and_name.length() > 0) {
								icd_code_and_name.append(", ");
								icd_code_and_name.append(icdCode.getIcd()
										.getIcdCode());
								icd_code_and_name.append(" ");
							} else {
								icd_code_and_name.append(icdCode.getIcd()
										.getIcdCode());
								icd_code_and_name.append(" ");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					map.put("diag", icd_code_and_name.toString());
				}

				transferList = session.createCriteria(Transfer.class)
						.createAlias("Hin", "p").add(
								Restrictions.eq("p.ServiceNo", serviceNo)).add(
								Restrictions.eq("AdNo", AdNo)).list();
				// transferList =
				// hbt.find("from jkt.hms.masters.business.Transfer as inp where inp.AdNo = '"+
				// requestParameters.get(ADMISSION_NUMBER).toString() +
				// "' and inp.Hin.ServiceNo='" +
				// requestParameters.get(SERVICE_NO).toString() +
				// "' order by inp.ListDate desc");

				if (transferList.size() > 0) {
					try {
						map.put("sil", transferList.get(0).getListDate()
								.toString());
					} catch (Exception e) {
						map.put("sil", "-");
					}
				} else {
					map.put("sil", "-");
				}

			}
			// Set<Patient> patientSet = (Set)hospitalList.get(0).getPatients();
			
			 * for (Iterator iter = patientSet.iterator(); iter.hasNext();) {
			 * Patient patient = (Patient) iter.next(); if
			 * (requestParameters.get
			 * (SERVICE_NO).toString().equalsIgnoreCase(patient.getServiceNo()))
			 * { map.put("patientName", patient.getPFirstName() + " " +
			 * patient.getPMiddleName() + " " + patient.getPLastName());
			 * map.put("serviceNo", patient.getServiceNo()); map.put("hinNo",
			 * patient.getHinNo()); try { map.put("relation",
			 * patient.getRelation().getRelationName()); } catch(Exception e) {
			 * map.put("relation", "-"); } try { map.put("sex",
			 * patient.getSex().getAdministrativeSexName()); } catch(Exception
			 * e) { map.put("sex", "-"); } map.put("servicePersonName",
			 * patient.getSFirstName() + " " + patient.getSMiddleName() + " " +
			 * patient.getSLastName()); try { map.put("unit",
			 * patient.getUnit().getUnitName()); } catch(Exception e) {
			 * map.put("unit", "-"); }
			 * 
			 * try { map.put("rank", patient.getRank().getRankName()); }
			 * catch(Exception e) { map.put("rank", "-"); }
			 * 
			 * 
			 * Set<Inpatient> inpatientSet = (Set)patient.getInpatients();
			 * 
			 * for (Iterator iterator = inpatientSet.iterator();
			 * iterator.hasNext();) { Inpatient inpatient= (Inpatient)
			 * iterator.next(); if
			 * (requestParameters.get(ADMISSION_NUMBER).toString
			 * ().equalsIgnoreCase(inpatient.getAdNo())) { map.put("age",
			 * inpatient.getAge());
			 * 
			 * if (inpatient.getDischargeDate()!=null) map.put("doa",
			 * inpatient.getDateOfAddmission().toString()); else map.put("doa",
			 * "-");
			 * 
			 * 
			 * if (inpatient.getDischargeDate()!=null) map.put("dod",
			 * inpatient.getDischargeDate().toString()); else map.put("dod",
			 * "-");
			 * 
			 * 
			 * dischargeIcdCodeSet = inpatient.getDischargeIcdCodes();
			 * 
			 * for (Iterator itr = dischargeIcdCodeSet.iterator();
			 * itr.hasNext();) { DischargeIcdCode dischargeIcdCode =
			 * (DischargeIcdCode) itr.next();
			 * 
			 * try { if (icd_code_and_name.length()>0) {
			 * icd_code_and_name.append(", ");
			 * icd_code_and_name.append(dischargeIcdCode.getIcd().getIcdCode());
			 * icd_code_and_name.append(" "); } else {
			 * icd_code_and_name.append(dischargeIcdCode.getIcd().getIcdCode());
			 * icd_code_and_name.append(" "); } } catch(Exception e) {
			 * e.printStackTrace(); } }
			 * map.put("diag",icd_code_and_name.toString()); } //end of if block
			 * (Admission Number Checking) } //end of inpatientSEt iterator loop
			 * 
			 * 
			 * Date of SIL/DIL should get from Transfer table. (if more than one
			 * records exists take the recent entry made against the
			 * corresponding Admission Number. If not present in Transfer table,
			 * get the Date of SIL/DIL from Inpatient table if exists, Otherwise
			 * no Date of SIL/DIL.
			 * 
			 * 
			 * transferList =hbt.find(
			 * "from jkt.hms.masters.business.Transfer as inp where inp.AdNo = '"
			 * + requestParameters.get(ADMISSION_NUMBER).toString() +
			 * "' and inp.Hin.ServiceNo='" +
			 * requestParameters.get(SERVICE_NO).toString() +
			 * "' order by inp.ListDate desc");
			 * 
			 * if (transferList.size() > 0 ) try { map.put("sil",
			 * transferList.get(0).getListDate().toString()); } catch(Exception
			 * e) { map.put("sil", "-"); } else map.put("sil", "-");
			 * 
			 * } //end of if block (hinNo checking) } //end of patientSet
			 * iterator loop
			 

			ipdIntakeOutputChart = session.createCriteria(
					IpdIntakeOutputChart.class).add(
					Restrictions.eq("AdNo", requestParameters.get(
							ADMISSION_NUMBER).toString())).list();
			TimeSeries series1 = new TimeSeries("Temperature", Minute.class);
			TimeSeries series2 = new TimeSeries("Pulse", Minute.class);
			TimeSeriesCollection dataset = new TimeSeriesCollection();

			if (ipdIntakeOutputChart.size() > 0) {
				Set<IpdTemperature> ipdTemperatureSet = (Set) ipdIntakeOutputChart
						.get(0).getIpdTemperatures();
				// for (Iterator iter = ipdTemperatureSet.iterator();
				// iter.hasNext();)
				for (IpdTemperature ipdTemperature : ipdTemperatureSet) {
					// IpdTemperature ipdTemperature = (IpdTemperature)
					// iter.next();
					float temp = 0;
					int pulse = 0;
					int hh = 0;
					int mm = 0;
					Hour hour = null;
					if (ipdTemperature.getTemperature() != null) {
						temp = ipdTemperature.getTemperature().floatValue();
					}

					if (ipdTemperature.getPulse() != null) {
						pulse = ipdTemperature.getPulse().intValue();
					}

					Date date = ipdTemperature.getIpdDate();
					String time = ipdTemperature.getTime();
					if (time != null) {
						hh = Integer.parseInt(time.substring(0, 2));
						mm = Integer.parseInt(time.substring(3, 5));
						hour = new Hour(hh, new Day(date));

						if (temp != 0)
							series1.addOrUpdate(new Minute(mm, hour), temp);

						if (pulse != 0)
							series2.addOrUpdate(new Minute(mm, hour), pulse);
					}
				}
				dataset.addSeries(series1);
				dataset.addSeries(series2);
			} else // if record not exists in ipd_input_output_chart
			{
				map.put("status", "nodata");
			}

			// JFreeChart tempchart = ChartFactory.createBarChart(arg0, arg1,
			// arg2, arg3, arg4, arg5, arg6, arg7);
			JFreeChart chart = ChartFactory.createTimeSeriesChart("", // title
					"Time", // x-axis label
					"Temperature / Pulse", // y-axis label
					dataset, // data
					true, // create legend?
					true, // generate tooltips?
					false // generate URLs?
					);

			chart.setBackgroundPaint(Color.white);

			XYPlot plot = (XYPlot) chart.getPlot();
			plot.setBackgroundPaint(Color.lightGray);
			plot.setDomainGridlinePaint(Color.white);
			plot.setRangeGridlinePaint(Color.white);
			plot.setAxisOffset(new RectangleInsets(1.0, 1.0, 1.0, 1.0));
			plot.setDomainCrosshairVisible(true);
			plot.setRangeCrosshairVisible(true);

			XYItemRenderer r = plot.getRenderer();
			if (r instanceof XYLineAndShapeRenderer) {
				XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
				renderer.setBaseShapesVisible(true);
				renderer.setBaseShapesFilled(true);
			}

			DateAxis axis = (DateAxis) plot.getDomainAxis();
			axis.setAutoRange(true);
			axis
					.setDateFormatOverride(new SimpleDateFormat(
							"d-MM-yyyy-hh:mma"));

			JFreeChartRenderer jfcRenderer = new JFreeChartRenderer(chart);
			map.put("jfcRenderer", jfcRenderer);
		} // end of try block
		catch (HibernateException e) {
			e.printStackTrace();
		}
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}*/

	public Map<String, Object> getClinicalSheetReportDetails(
			Map requestParameters) {
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<IpdIntakeOutputChart> ipdIntakeOutputChart = new ArrayList<IpdIntakeOutputChart>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<Transfer> transferList = new ArrayList<Transfer>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Set<DischargeIcdCode> dischargeIcdCodeSet = null;
		StringBuffer icd_code_and_name = new StringBuffer();
		try {
			String serviceNo = "";
			String AdNo = "";
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			serviceNo = requestParameters.get(SERVICE_NO).toString().trim();
			AdNo = requestParameters.get(ADMISSION_NUMBER).toString().trim();
			System.out.println(serviceNo+"--------------");
			System.out.println(AdNo+"--------------");
			patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("ServiceNo", serviceNo)).list();
			inpatientList = session.createCriteria(Inpatient.class).add(
					Restrictions.eq("AdNo", AdNo)).list();
			if (inpatientList != null && inpatientList.size() > 0) {
				for (Patient patient : patientList) {
					map.put("serviceNo", patient.getServiceNo());
					if (patient.getRelation() != null) {
						map.put("relation", patient.getRelation()
								.getRelationName());
					} else {
						map.put("relation", "-");
					}
					if (patient.getSex() != null) {
						map.put("sex", patient.getSex()
								.getAdministrativeSexName());
					} else {
						map.put("sex", "-");
					}
					String sName="";
					sName=patient.getSFirstName();
					if(patient.getSMiddleName()!= null){
						sName += " "+patient.getSMiddleName();
					}
					if(patient.getSLastName()!= null){
						sName += " "+patient.getSLastName();
					}
					map.put("servicePersonName", sName);
					String pName="";
					pName=patient.getPFirstName();
					if(patient.getPMiddleName()!= null){
						pName += " "+patient.getPMiddleName();
					}
					if(patient.getPLastName()!= null){
						pName += " "+patient.getPLastName();
					}
					map.put("patientName",pName);
					if (patient.getUnit() != null) {
						map.put("unit", patient.getUnit().getUnitName());
					} else {
						map.put("unit", "-");
					}
					if (patient.getRank() != null) {
						map.put("rank", patient.getRank().getRankName());
					} else {
						map.put("rank", "-");
					}
				}
				
				for (Inpatient inpatient : inpatientList) {
					map.put("age", inpatient.getAge());

					if (inpatient.getDischargeDate() != null) {
						map.put("doa", inpatient.getDateOfAddmission()
								.toString());
					} else {
						map.put("doa", "-");
					}
					if (inpatient.getDischargeDate() != null) {
						map.put("dod", inpatient.getDischargeDate().toString());
					} else {
						map.put("dod", "-");
					}

					dischargeIcdCodeSet = inpatient.getDischargeIcdCodes();
					for (DischargeIcdCode icdCode : dischargeIcdCodeSet) {
						try {
							if (icd_code_and_name.length() > 0) {
								icd_code_and_name.append(", ");
								icd_code_and_name.append(icdCode.getIcd()!=null?icdCode.getIcd().getIcdCode():"");
								icd_code_and_name.append(" ");
							} else {
								icd_code_and_name.append(icdCode.getIcd()!=null?icdCode.getIcd().getIcdCode():"");
								icd_code_and_name.append(" ");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					map.put("diag", icd_code_and_name.toString());
				}

				transferList = session.createCriteria(Transfer.class)
						.createAlias("Hin", "p").add(
								Restrictions.eq("p.ServiceNo", serviceNo)).add(
								Restrictions.eq("AdNo", AdNo)).list();
				if (transferList.size() > 0) {
					try {
						map.put("sil", transferList.get(0).getListDate()
								.toString());
					} catch (Exception e) {
						map.put("sil", "-");
					}
				} else {
					map.put("sil", "-");
				}

			}
		

			ipdIntakeOutputChart = session.createCriteria(
					IpdIntakeOutputChart.class).add(
					Restrictions.eq("AdNo", requestParameters.get(
							ADMISSION_NUMBER).toString())).addOrder(Order.asc("Time")).list();
			TimeSeries series1 = new TimeSeries("Temperature", Minute.class);
			TimeSeries series2 = new TimeSeries("Pulse", Minute.class);
			TimeSeriesCollection dataset = new TimeSeriesCollection();
			TimeSeriesCollection pdataset = new TimeSeriesCollection();
			if (ipdIntakeOutputChart.size() > 0) {
				Set<IpdTemperature> ipdTemperatureSet = (Set) ipdIntakeOutputChart
						.get(0).getIpdTemperatures();
				for (IpdTemperature ipdTemperature : ipdTemperatureSet) {
				//	double temp = 0;
					int pulse = 0;
					int hh = 0;
					int mm = 0;
					Hour hour = null;
					/*if (ipdTemperature.getTemperature() != null) {
						temp = ipdTemperature.getTemperature();
					}*/

					if (ipdTemperature.getPulse() != null) {
						pulse = ipdTemperature.getPulse().intValue();
					}

					Date date = ipdTemperature.getIpdDate();
					String time = ipdTemperature.getTime();
					if (time != null) {
						hh = Integer.parseInt(time.substring(0, 2));
						mm = Integer.parseInt(time.substring(3, 5));
						hour = new Hour(hh, new Day(date));

//						System.out.println("temp--- "+(Math.round(ipdTemperature.getTemperature().doubleValue()*100.0)/100.0));
						if (ipdTemperature.getTemperature().intValue() != 0)
							series1.addOrUpdate(new Minute(mm, hour), Math.round(ipdTemperature.getTemperature().doubleValue()*100.0)/100.0);

						if (pulse != 0)
							series2.addOrUpdate(new Minute(mm, hour), pulse);
						
					}
				}
				dataset.addSeries(series1);
				pdataset.addSeries(series2);
			} else // if record not exists in ipd_input_output_chart
			{
				map.put("status", "nodata");
			}

			
			JFreeChart chart = ChartFactory.createTimeSeriesChart("", // title
					"Time", // x-axis label
					"Temperature", // y-axis label
					dataset, // data
					true, // create legend?
					true, // generate tooltips?
					false // generate URLs?
					);

			chart.setBackgroundPaint(Color.white);

			XYPlot plot = (XYPlot) chart.getPlot();
			plot.setBackgroundPaint(Color.lightGray);
			plot.setDomainGridlinePaint(Color.white);
			plot.setRangeGridlinePaint(Color.white);
			plot.setAxisOffset(new RectangleInsets(1.0, 1.0, 1.0, 1.0));
			plot.setDomainCrosshairVisible(true);
			plot.setRangeCrosshairVisible(true);

			XYItemRenderer r = plot.getRenderer();
			if (r instanceof XYLineAndShapeRenderer) {
				XYLineAndShapeRenderer prenderer = (XYLineAndShapeRenderer) r;
				prenderer.setBaseShapesVisible(true);
				prenderer.setBaseShapesFilled(true);
			}

			DateAxis axis = (DateAxis) plot.getDomainAxis();
	//		axis.setAutoRange(true);
			axis
					.setDateFormatOverride(new SimpleDateFormat(
							"d-MM-yyyy-hh:mma"));

			JFreeChartRenderer jfcRenderer = new JFreeChartRenderer(chart);
			map.put("jfcRenderer", jfcRenderer);
			System.out.println(jfcRenderer+"--------------");
			JFreeChart pchart = ChartFactory.createTimeSeriesChart("", // title
					"Time", // x-axis label
					"Pulse", // y-axis label
					pdataset, // data
					true, // create legend?
					true, // generate tooltips?
					false // generate URLs?
					);

			pchart.setBackgroundPaint(Color.white);

			XYPlot pplot = (XYPlot) pchart.getPlot();
			pplot.setBackgroundPaint(Color.lightGray);
			pplot.setDomainGridlinePaint(Color.white);
			pplot.setRangeGridlinePaint(Color.white);
			pplot.setAxisOffset(new RectangleInsets(1.0, 1.0, 1.0, 1.0));
			pplot.setDomainCrosshairVisible(true);
			pplot.setRangeCrosshairVisible(true);

			XYItemRenderer pr = pplot.getRenderer();
			if (pr instanceof XYLineAndShapeRenderer) {
				XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) pr;
				renderer.setBaseShapesVisible(true);
				renderer.setBaseShapesFilled(true);
				
			}

			DateAxis paxis = (DateAxis) pplot.getDomainAxis();
			paxis.setAutoRange(true);
			paxis
					.setDateFormatOverride(new SimpleDateFormat(
							"d-MM-yyyy-hh:mma"));

			JFreeChartRenderer pjfcRenderer = new JFreeChartRenderer(pchart);
			map.put("pjfcRenderer", pjfcRenderer);
			
		} // end of try block
		catch (HibernateException e) {
			e.printStackTrace();
		}
		
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}
	public Map<String, Object> getSearchPatientComboDetails(
			Map requestParameters) {
		List<MasServiceType> masServiceTypeList = new ArrayList<MasServiceType>();
		List<MasRank> masRankList = new ArrayList<MasRank>();
		List<MasUnit> masUnitList = new ArrayList<MasUnit>();
		List<Patient> patientList = new ArrayList<Patient>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			masRankList = session.createCriteria(MasRank.class).list();
			masUnitList = session.createCriteria(MasUnit.class).list();
			masServiceTypeList = session.createCriteria(MasServiceType.class)
					.list();
			String queryString = null;
			queryString = "select inp from jkt.hms.masters.business.Patient as inp,jkt.hms.masters.business.Inpatient as inpatient where 1 = 1 ";

			if (requestParameters.get("deptId") != null
					&& requestParameters.get("deptId").toString().length() > 0) {
				queryString = queryString
						+ "and inp.Id = inpatient.Hin.Id and inpatient.Department.Id  = '"
						+ requestParameters.get("deptId") + "'";
			}
			if (requestParameters.get("adNo") != null
					&& requestParameters.get("adNo").toString().length() > 0) {
				queryString = queryString + "  and inpatient.AdNo = '"
						+ requestParameters.get("adNo") + "'";
			}

			if (requestParameters.get("serviceNo") != null
					&& requestParameters.get("serviceNo").toString().length() > 0) {
				queryString = queryString + " and inp.ServiceNo = '"
						+ requestParameters.get("serviceNo") + "'";
			}

			if (requestParameters.get("serviceType") != null
					&& requestParameters.get("serviceType").toString().length() > 0) {
				queryString = queryString
						+ " and inp.ServiceType.ServiceTypeCode = '"
						+ requestParameters.get("serviceType") + "'";
			}

			if (requestParameters.get("rank") != null
					&& requestParameters.get("rank").toString().length() > 0) {
				queryString = queryString + " and inp.Rank.RankCode= '"
						+ requestParameters.get("rank") + "'";
			}

			if (requestParameters.get("unit") != null
					&& requestParameters.get("unit").toString().length() > 0) {
				queryString = queryString + " and inp.Unit.Id = '"
						+ requestParameters.get("unit") + "'";
			}

			if (requestParameters.get("patientName") != null
					&& requestParameters.get("patientName").toString().length() > 0) {
				queryString = queryString + " and (inp.PFirstName like '%"
						+ requestParameters.get("patientName")
						+ "%' or inp.PMiddleName like '%"
						+ requestParameters.get("patientName")
						+ "%' or inp.PLastName like '%"
						+ requestParameters.get("patientName") + "%')";
			}

			if (requestParameters.get("servicePersonnelName") != null
					&& requestParameters.get("servicePersonnelName").toString()
							.length() > 0) {
				queryString = queryString + " and (inp.SFirstName like '%"
						+ requestParameters.get("servicePersonnelName")
						+ "%' or inp.SMiddleName like '%"
						+ requestParameters.get("servicePersonnelName")
						+ "%' or inp.SLastName like '%"
						+ requestParameters.get("servicePersonnelName") + "%')";
			}

			if (requestParameters.get("SearchFlag") != null
					&& requestParameters.get("SearchFlag").toString().equals(
							"true")) {
				//System.out.println("queryString  " + queryString);
				patientList = hbt.find(queryString);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("masServiceTypeList", masServiceTypeList);
		map.put("masUnitList", masUnitList);
		map.put("masRankList", masRankList);
		map.put("patientList", patientList);
		return map;
	}

	public Map<String, Object> showPatientDiagnosisJsp(Map<String, Object> map) {

		List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
		List<DischargeIcdCode> disList = new ArrayList<DischargeIcdCode>();
		List<MasIcd> icdNoList = new ArrayList<MasIcd>();
		Session session = (Session) getSession();
		int inPatientId = (Integer) map.get("inPatientId");
		try {
			inPatientDetailList = session.createCriteria(Inpatient.class).add(
					Restrictions.eq("Id", inPatientId)).list();
			// icdNoList=session.createCriteria(MasIcd.class).list();
			disList = session.createQuery(
					"select dis from DischargeIcdCode as dis where dis.Inpatient.Id='"
							+ inPatientId + "' order by dis.Id desc ").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("inPatientDetailList", inPatientDetailList);
		map.put("icdNoList", icdNoList);
		map.put("disList", disList);
		return map;

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

	public Map<String, Object> getClinicalSheetReportDetailsIPD(Map requestParameters) {
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<IpdIntakeOutputChart> ipdIntakeOutputChart = new ArrayList<IpdIntakeOutputChart>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<Transfer> transferList = new ArrayList<Transfer>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Set<DischargeIcdCode> dischargeIcdCodeSet = null;
		StringBuffer icd_code_and_name = new StringBuffer();
		try {
			String serviceNo = "";
			int inpatientId = 0;
			String AdNo ="";
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			serviceNo = requestParameters.get(SERVICE_NO).toString().trim();
			inpatientId= Integer.parseInt(requestParameters.get(ADMISSION_NUMBER).toString());
			
			patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("ServiceNo", serviceNo)).list();
			inpatientList = session.createCriteria(Inpatient.class).add(
					Restrictions.eq("Id", inpatientId)).list();
			
			if (inpatientList != null && inpatientList.size() > 0) {
		
				System.out.println("AdNo"+AdNo);
				for (Patient patient : patientList) {
					map.put("serviceNo", patient.getServiceNo());
					if (patient.getRelation() != null) {
						map.put("relation", patient.getRelation()
								.getRelationName());
					} else {
						map.put("relation", "-");
					}
					if (patient.getSex() != null) {
						map.put("sex", patient.getSex()
								.getAdministrativeSexName());
					} else {
						map.put("sex", "-");
					}
					String sName="";
					sName=patient.getSFirstName();
					if(patient.getSMiddleName()!= null){
						sName += " "+patient.getSMiddleName();
					}
					if(patient.getSLastName()!= null){
						sName += " "+patient.getSLastName();
					}
					map.put("servicePersonName", sName);
					String pName="";
					pName=patient.getPFirstName();
					if(patient.getPMiddleName()!= null){
						pName += " "+patient.getPMiddleName();
					}
					if(patient.getPLastName()!= null){
						pName += " "+patient.getPLastName();
					}
					map.put("patientName",pName);
					if (patient.getUnit() != null) {
						map.put("unit", patient.getUnit().getUnitName());
					} else {
						map.put("unit", "-");
					}
					if (patient.getRank() != null) {
						map.put("rank", patient.getRank().getRankName());
					} else {
						map.put("rank", "-");
					}
				}
				
				for (Inpatient inpatient : inpatientList) {
					map.put("age", inpatient.getAge());

					if (inpatient.getDischargeDate() != null) {
						map.put("doa", inpatient.getDateOfAddmission()
								.toString());
					} else {
						map.put("doa", "-");
					}
					if (inpatient.getDischargeDate() != null) {
						map.put("dod", inpatient.getDischargeDate().toString());
					} else {
						map.put("dod", "-");
					}

					dischargeIcdCodeSet = inpatient.getDischargeIcdCodes();
					for (DischargeIcdCode icdCode : dischargeIcdCodeSet) {
						try {
							if (icd_code_and_name.length() > 0) {
								icd_code_and_name.append(", ");
								icd_code_and_name.append(icdCode.getIcd()!=null?icdCode.getIcd().getIcdCode():"");
								icd_code_and_name.append(" ");
							} else {
								icd_code_and_name.append(icdCode.getIcd()!=null?icdCode.getIcd().getIcdCode():"");
								icd_code_and_name.append(" ");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					map.put("diag", icd_code_and_name.toString());
				}
System.out.println(inpatientId+"--------------");
System.out.println(serviceNo+"-------serviceNo-------");
				transferList = session.createCriteria(Transfer.class)
						.createAlias("Inpatient", "i").createAlias("Hin", "p").add(
								Restrictions.eq("p.ServiceNo", serviceNo)).add(
								Restrictions.eq("i.Id", inpatientId)).list();
				System.out.println(transferList.size()+"----transferList---------");
				if (transferList.size() > 0) {
					try {
						map.put("sil", transferList.get(0).getListDate()
								.toString());
					} catch (Exception e) {
						map.put("sil", "-");
					}
				} else {
					map.put("sil", "-");
				}

			}
		

			ipdIntakeOutputChart = session.createCriteria(IpdIntakeOutputChart.class).createAlias("Inpatient", "i")
					.add(Restrictions.eq("i.Id", inpatientId)).addOrder(Order.asc("Time")).list();
			TimeSeries series1 = new TimeSeries("Temperature", Minute.class);
			TimeSeries series2 = new TimeSeries("Pulse", Minute.class);
			TimeSeriesCollection dataset = new TimeSeriesCollection();
			TimeSeriesCollection pdataset = new TimeSeriesCollection();
			System.out.println(ipdIntakeOutputChart.size()+"----------------");
			if (ipdIntakeOutputChart.size() > 0) {
				Set<IpdTemperature> ipdTemperatureSet = (Set) ipdIntakeOutputChart
						.get(0).getIpdTemperatures();
				for (IpdTemperature ipdTemperature : ipdTemperatureSet) {
				//	double temp = 0;
					int pulse = 0;
					int hh = 0;
					int mm = 0;
					Hour hour = null;
					/*if (ipdTemperature.getTemperature() != null) {
						temp = ipdTemperature.getTemperature();
					}*/

					if (ipdTemperature.getPulse() != null) {
						pulse = ipdTemperature.getPulse().intValue();
					}

					Date date = ipdTemperature.getIpdDate();
					String time = ipdTemperature.getTime();
					if (time != null) {
						hh = Integer.parseInt(time.substring(0, 2));
						mm = Integer.parseInt(time.substring(3, 5));
						hour = new Hour(hh, new Day(date));

//						System.out.println("temp--- "+(Math.round(ipdTemperature.getTemperature().doubleValue()*100.0)/100.0));
						if (ipdTemperature.getTemperature().intValue() != 0)
							series1.addOrUpdate(new Minute(mm, hour), Math.round(ipdTemperature.getTemperature().doubleValue()*100.0)/100.0);

						if (pulse != 0)
							series2.addOrUpdate(new Minute(mm, hour), pulse);
						
					}
				}
				dataset.addSeries(series1);
				pdataset.addSeries(series2);
			} else // if record not exists in ipd_input_output_chart
			{
				map.put("status", "nodata");
			}

			
			JFreeChart chart = ChartFactory.createTimeSeriesChart("", // title
					"Time", // x-axis label
					"Temperature", // y-axis label
					dataset, // data
					true, // create legend?
					true, // generate tooltips?
					false // generate URLs?
					);

			chart.setBackgroundPaint(Color.white);

			XYPlot plot = (XYPlot) chart.getPlot();
			plot.setBackgroundPaint(Color.lightGray);
			plot.setDomainGridlinePaint(Color.white);
			plot.setRangeGridlinePaint(Color.white);
			plot.setAxisOffset(new RectangleInsets(1.0, 1.0, 1.0, 1.0));
			plot.setDomainCrosshairVisible(true);
			plot.setRangeCrosshairVisible(true);

			XYItemRenderer r = plot.getRenderer();
			if (r instanceof XYLineAndShapeRenderer) {
				XYLineAndShapeRenderer prenderer = (XYLineAndShapeRenderer) r;
				prenderer.setBaseShapesVisible(true);
				prenderer.setBaseShapesFilled(true);
			}

			DateAxis axis = (DateAxis) plot.getDomainAxis();
	//		axis.setAutoRange(true);
			axis
					.setDateFormatOverride(new SimpleDateFormat(
							"d-MM-yyyy-hh:mma"));

			JFreeChartRenderer jfcRenderer = new JFreeChartRenderer(chart);
			map.put("jfcRenderer", jfcRenderer);
			System.out.println(jfcRenderer+"-----------jfcRenderer---");
			JFreeChart pchart = ChartFactory.createTimeSeriesChart("", // title
					"Time", // x-axis label
					"Pulse", // y-axis label
					pdataset, // data
					true, // create legend?
					true, // generate tooltips?
					false // generate URLs?
					);

			pchart.setBackgroundPaint(Color.white);

			XYPlot pplot = (XYPlot) pchart.getPlot();
			pplot.setBackgroundPaint(Color.lightGray);
			pplot.setDomainGridlinePaint(Color.white);
			pplot.setRangeGridlinePaint(Color.white);
			pplot.setAxisOffset(new RectangleInsets(1.0, 1.0, 1.0, 1.0));
			pplot.setDomainCrosshairVisible(true);
			pplot.setRangeCrosshairVisible(true);

			XYItemRenderer pr = pplot.getRenderer();
			if (pr instanceof XYLineAndShapeRenderer) {
				XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) pr;
				renderer.setBaseShapesVisible(true);
				renderer.setBaseShapesFilled(true);
				
			}

			DateAxis paxis = (DateAxis) pplot.getDomainAxis();
			paxis.setAutoRange(true);
			paxis
					.setDateFormatOverride(new SimpleDateFormat(
							"d-MM-yyyy-hh:mma"));

			JFreeChartRenderer pjfcRenderer = new JFreeChartRenderer(pchart);
			map.put("pjfcRenderer", pjfcRenderer);
			System.out.println(pjfcRenderer+"------pjfcRenderer--------");
		} // end of try block
		catch (HibernateException e) {
			e.printStackTrace();
		}
		
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}
}