package jkt.hms.ipd.dataservice;

import static jkt.hms.util.RequestConstants.ADMISSION_NUMBER;
import static jkt.hms.util.RequestConstants.AD_NO;
import static jkt.hms.util.RequestConstants.AUTHORIZER_ID;
import static jkt.hms.util.RequestConstants.BOWEL;
import static jkt.hms.util.RequestConstants.BP;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.DATE;
import static jkt.hms.util.RequestConstants.DEPT_ID;
import static jkt.hms.util.RequestConstants.FROM_WARD;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;
import static jkt.hms.util.RequestConstants.PAIN;
import static jkt.hms.util.RequestConstants.PATIENT_NAME;
import static jkt.hms.util.RequestConstants.PULSE;
import static jkt.hms.util.RequestConstants.REMARKS;
import static jkt.hms.util.RequestConstants.RESPIRATION;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.TEMPERATURE;
import static jkt.hms.util.RequestConstants.TIME;
import static jkt.hms.util.RequestConstants.TO_WARD;
import static jkt.hms.util.RequestConstants.TRANSFER_DATE;
import static jkt.hms.util.RequestConstants.TRANSFER_TIME;
import static jkt.hms.util.RequestConstants.USER_ID;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
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

import jkt.hms.masters.business.DepartmentMedicineIssue;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgOrderdt;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DgSampleCollectionDetails;
import jkt.hms.masters.business.Discharge;
import jkt.hms.masters.business.DischargeIcdCode;
import jkt.hms.masters.business.EmpScMapping;
import jkt.hms.masters.business.InjAppointmentDetails;
import jkt.hms.masters.business.InjAppointmentHeader;
/*import jkt.hms.masters.business.HospitalDoctorUnitM;*/
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.InpatientDocument;
import jkt.hms.masters.business.IpdDrugConsumption;
import jkt.hms.masters.business.IpdHandTakeOver;
import jkt.hms.masters.business.IpdIntake;
import jkt.hms.masters.business.IpdIntakeOutput;
import jkt.hms.masters.business.IpdIntakeOutputChart;
import jkt.hms.masters.business.IpdKitIssueDetails;
import jkt.hms.masters.business.IpdKitIssueHeader;
import jkt.hms.masters.business.IpdMedicineIssueDetails;
import jkt.hms.masters.business.IpdMedicineIssueHeader;
import jkt.hms.masters.business.IpdOutput;
import jkt.hms.masters.business.IpdPatientDiet;
import jkt.hms.masters.business.IpdSpecialistOpinion;
import jkt.hms.masters.business.IpdTemperature;
import jkt.hms.masters.business.Ipdcaredetail;
import jkt.hms.masters.business.KitIssueMasterTemplateM;
import jkt.hms.masters.business.KitIssueMasterTemplateT;
import jkt.hms.masters.business.MasBed;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDiet;
import jkt.hms.masters.business.MasDivision;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDepartment;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasIcd;
import jkt.hms.masters.business.MasImpanneledHospital;
import jkt.hms.masters.business.MasItemClass;
import jkt.hms.masters.business.MasItemClassification;
import jkt.hms.masters.business.MasItemType;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasMedicalExamFamilyHis;
import jkt.hms.masters.business.MasMedicalExaminationDetail;
import jkt.hms.masters.business.MasNursingCare;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRankCategory;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasStoreBrand;
import jkt.hms.masters.business.MasStoreGroup;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreItemConversion;
import jkt.hms.masters.business.MasStoreSection;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.MasSystemDiagnosis;
import jkt.hms.masters.business.MasTherapyType;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.MmMasRequestStatus;
import jkt.hms.masters.business.NursingcareSetup;
import jkt.hms.masters.business.NursingfoodTest;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.OpdPatientHistory;
import jkt.hms.masters.business.OpdSurgeryDetail;
import jkt.hms.masters.business.OpdSurgeryHeader;
import jkt.hms.masters.business.OpdTemplate;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientDetentionRegister;
import jkt.hms.masters.business.PatientDietIndoorDetail;
import jkt.hms.masters.business.PatientFamilyHistory;
import jkt.hms.masters.business.PatientInvestigationDetails;
import jkt.hms.masters.business.PatientInvestigationHeader;
import jkt.hms.masters.business.PatientPrescriptionDetails;
import jkt.hms.masters.business.PatientPrescriptionHeader;
import jkt.hms.masters.business.PatientRemarks;
import jkt.hms.masters.business.PhysioRequisitionDetail;
import jkt.hms.masters.business.PhysioRequisitionHeader;
import jkt.hms.masters.business.PreAnesthesiaConsultDoctorDt;
import jkt.hms.masters.business.PreAnesthesiaConsultDoctorHd;
import jkt.hms.masters.business.ProcedureDetails;
import jkt.hms.masters.business.ProcedureHeader;
import jkt.hms.masters.business.ReferralPatientDetails;
import jkt.hms.masters.business.ReferralPatientHeader;
import jkt.hms.masters.business.SilDilStatus;
import jkt.hms.masters.business.StoreFyDocumentNo;
import jkt.hms.masters.business.StoreIpIssueM;
import jkt.hms.masters.business.StoreIpIssueT;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.Transfer;
import jkt.hms.masters.business.UserButtonRights;
import jkt.hms.masters.business.UserEmpGroup;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.masters.business.WardRemarks;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.PatientCaseSheetDetails;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class IPDDataServiceImpl extends HibernateDaoSupport implements
IPDDataService {

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientList(int deptId, int hospitalId) {
		Session session = (Session) getSession();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		List<Inpatient> inPatientSet = new ArrayList<Inpatient>();
		List<MasBed> bedNoList = new ArrayList<MasBed>();
		List<OpdPatientDetails> opdDetailsList = new ArrayList<OpdPatientDetails>();

		Map<String, Object> map = new HashMap<String, Object>();
		String deptName = "";
		List objectList = new ArrayList();
		int waitingCount = 0;
		try {
			deptList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Id", deptId)).list();
			
			inPatientSet = session.createQuery("select ip from Inpatient as ip where ip.AdStatus in ('W','A','R') and  ip.Department.Id="
					+ deptId+" and ip.Hospital.Id="+hospitalId
					+ "order by (DateOfAddmission)desc").list();
			
			String qry = "select count(*) from inpatient where department_id='"
				+ deptId + "'  and ad_status='W' and hospital_id="+hospitalId;
			objectList = (List) session.createSQLQuery(qry).list();
			if (objectList.get(0) != null) {
				waitingCount = Integer.parseInt("" + objectList.get(0));
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		if (deptList.size() > 0) {
			MasDepartment masDepartment = (MasDepartment) deptList.get(0);
			deptName = masDepartment.getDepartmentName();
		}

		bedNoList = session.createCriteria(MasBed.class).createAlias("Department", "dept").add(Restrictions.eq("dept.Id", deptId))
					.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId))
					.addOrder(Order.asc("BedNo")).add(Restrictions.eq("Status", "y")).list();

		/**
		 * For getting opd details
		 * Added By Ritu
		 * 20 March 2012
		 */
		List<PatientCaseSheetDetails> caseSheetDetails = new ArrayList<PatientCaseSheetDetails>();
		if(inPatientSet.size() > 0){
			for (Inpatient inpatient : inPatientSet) {
			//	Set<PatientPrescriptionHeader> presHdSet = new HashSet<PatientPrescriptionHeader>();
				Set<PatientPrescriptionDetails> presDt = new HashSet<PatientPrescriptionDetails>();
			/*	Set<ProcedureHeader> procedureHeaderSet = new HashSet<ProcedureHeader>();
				Set<ProcedureDetails> procedureDetailsSet = new HashSet<ProcedureDetails>();*/
				List<NursingcareSetup> procedureList = new ArrayList<NursingcareSetup>();
				Set<PhysioRequisitionHeader> physioHeaderSet = new HashSet<PhysioRequisitionHeader>();
				Set<PhysioRequisitionDetail> physioDetailsSet = new HashSet<PhysioRequisitionDetail>();
				String treatment = "";
				String procedure = "";
				String physioTherapy = "";
				String nursingCare = "";
				String diagnosis = "";
				int inpatientId =inpatient.getId();
				int visitId=0;
				int hinId= inpatient.getHin().getId();
				List<OpdPatientDetails> patientOpdDtList = new ArrayList<OpdPatientDetails>();
				/**
				 * For Treatment
				 */
				List<PatientPrescriptionHeader> presHd = new ArrayList<PatientPrescriptionHeader>();
				presHd = session.createCriteria(PatientPrescriptionHeader.class).add(Restrictions.eq("Inpatient.Id", inpatientId)).addOrder(Order.desc("Id")).setMaxResults(1).list();
				if(presHd.size()==0){
					presHd = session.createCriteria(PatientPrescriptionHeader.class).add(Restrictions.eq("Hin.Id", inpatient.getHin().getId()))
					.addOrder(Order.desc("Id")).setMaxResults(1).list();
				}
				
				if(presHd.size()!=0){
					PatientPrescriptionHeader presHeader = presHd.get(0);
					if(presHeader.getPatientPrescriptionDetails()!=null){
						presDt = presHeader.getPatientPrescriptionDetails();
						if(presHeader.getVisit()!=null)
							visitId = presHeader.getVisit().getId();
					
						for(PatientPrescriptionDetails presDetails : presDt){
							if(!treatment.equals("")){
								treatment +=",<div class='clear'></div>";
							}
							treatment += presDetails.getItem().getNomenclature()+" "+presDetails.getFrequency().getFrequencyName();

						}
					}
				}
				
				
			/*	if(inpatient.getPatientPrescriptionHeaders()!=null && inpatient.getPatientPrescriptionHeaders().size() >0){
					presHdSet = inpatient.getPatientPrescriptionHeaders();

				}else{
					patientOpdDtList = session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "v").createAlias("v.Hin", "hin").add(Restrictions.eq("hin.Id", inpatient.getHin().getId()))
					.addOrder(Order.desc("id")).setMaxResults(1).list();
					if(patientOpdDtList.size() > 0){
						presHdSet = patientOpdDtList.get(0).getPatientPrescriptionHeaders();
					}
				}
				if(presHdSet.size() > 0){
					for(PatientPrescriptionHeader presHeader : presHdSet){
						if(presHeader.getPatientPrescriptionDetails()!=null){
							presDt = presHeader.getPatientPrescriptionDetails();
							if(presHeader.getInpatient()!=null)
								inpatientId = presHeader.getInpatient().getId();
							if(presHeader.getVisit()!=null)
								visitId = presHeader.getVisit().getId();
						}
					}
					if(presDt.size() > 0){
						for(PatientPrescriptionDetails presDetails : presDt){
							if(!treatment.equals("")){
								treatment +=",<div class='clear'></div>";
							}
							treatment += presDetails.getItem().getNomenclature()+" "+presDetails.getFrequency().getFrequencyName();

						}
					}
				}*/
				/**
				 * End Treatment
				 */
				/**
				 * For Procedure
				 */
				/*if(inpatient.getProcedureHeaders()!=null && inpatient.getProcedureHeaders().size() >0){
					procedureHeaderSet = inpatient.getProcedureHeaders();

				}else{
					if(patientOpdDtList.size() > 0){
						procedureHeaderSet = patientOpdDtList.get(0).getProcedureHeaders();
					}
				}
				if(procedureHeaderSet.size() > 0){
					for(ProcedureHeader procedureHeader : procedureHeaderSet){
						if(procedureHeader.getProcedureDetails()!=null){
							procedureDetailsSet = procedureHeader.getProcedureDetails();
						}
					}
					if(procedureDetailsSet.size() > 0){
						for(ProcedureDetails procDetails : procedureDetailsSet){
							if(!procedure.equals("")){
								procedure +=",<div class='clear'></div>";
							}
							procedure += procDetails.getNursingCare().getNursingName();

						}
					}
				}*/
				procedureList = session.createCriteria(NursingcareSetup.class).add(Restrictions.eq("Inpatient.Id", inpatient.getId())).list();
				if(procedureList.size() > 0){
					for(NursingcareSetup nursingcareSetup : procedureList){
						if(!procedure.equals("")){
							procedure +=",<div class='clear'></div>";
						}
						procedure += nursingcareSetup.getNursing().getNursingName();

					}
				}
				/**
				 * End Procedure
				 */
				/**
				 * For Physiotherapy
				 */
				
				if(inpatient.getPhysioRequisitionHeaders()!=null && inpatient.getPhysioRequisitionHeaders().size() >0){
					physioHeaderSet = inpatient.getPhysioRequisitionHeaders();

				}else{
					if(patientOpdDtList.size() > 0){
						physioHeaderSet = patientOpdDtList.get(0).getPhysioRequisitionHeaders();
					}
				}
				if(physioHeaderSet.size() > 0){
					for(PhysioRequisitionHeader physioHeader : physioHeaderSet){
						if(physioHeader.getPhysioRequisitionDetails()!=null){
							physioDetailsSet = physioHeader.getPhysioRequisitionDetails();
						}
					}
					if(physioDetailsSet.size() > 0){
						for(PhysioRequisitionDetail physioDetails : physioDetailsSet){
							if(!physioTherapy.equals("")){
								physioTherapy +=",<div class='clear'></div>";
							}
							if(physioDetails.getTharaphy() != null)
							{
								physioTherapy += physioDetails.getTharaphy().getTherapyTypeName();
							}
							

						}
					}
				}
				/**
				 * End Physiotherapy
				 */
				/**
				 * Nursing Care
				 */
				if(inpatient.getNursingcareSetups()!=null && inpatient.getNursingcareSetups().size() > 0){
					for(NursingcareSetup nursingcareSetup : inpatient.getNursingcareSetups()){
						if(!nursingCare.equals("")){
							nursingCare += ",";
						}
						if(nursingcareSetup.getNursing()!=null)
							nursingCare += nursingcareSetup.getNursing().getNursingName();


					}
				}else{
					List<OpdPatientHistory> patientOpdHistoryList = new ArrayList<OpdPatientHistory>();
					patientOpdHistoryList = session.createCriteria(OpdPatientHistory.class).createAlias("OpdPatientDetails", "opd").createAlias("opd.Visit", "v").createAlias("v.Hin", "hin").add(Restrictions.eq("hin.Id", inpatient.getHin().getId()))
					.addOrder(Order.desc("Id")).setMaxResults(1).list();
					if(patientOpdHistoryList.size() > 0){
						nursingCare += patientOpdHistoryList.get(0).getPresentAdvice();
					}
				}
				/**
				 * End
				 */
				/**
				 * Diagnosis
				 */
				Map<String,Object> dtMap = new HashMap<String, Object>();
				dtMap = getPatientLatestDiagnosisAndDisability(inpatientId);
				List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
				if(dtMap.get("diagnosisList")!=null){
					diagnosisList = (List<DischargeIcdCode>)dtMap.get("diagnosisList");
					if(diagnosisList.size()>0)
						diagnosis = diagnosisList.get(0).getIcd()!=null?diagnosisList.get(0).getIcd().getIcdName():"";

				/**
				 * End
				 */
				PatientCaseSheetDetails patientCaseSheetDetails = new PatientCaseSheetDetails();
				patientCaseSheetDetails.setInpatientId(inpatientId);
				patientCaseSheetDetails.setVisitId(visitId);
				patientCaseSheetDetails.setTreatmentDetails(treatment);
				patientCaseSheetDetails.setProcedureDetails(procedure);
				patientCaseSheetDetails.setPhysiotherapyDetails(physioTherapy);
				patientCaseSheetDetails.setNursingCareDetails(nursingCare);
				patientCaseSheetDetails.setDiagnosisDetails(diagnosis);
				patientCaseSheetDetails.setHinId(hinId);
				caseSheetDetails.add(patientCaseSheetDetails);
						
				}
			}
		}

		/**
		 * End
		 */
		map.put("caseSheetDetails", caseSheetDetails);
		map.put("inpatientSet", inPatientSet);
		map.put("deptName", deptName);
		map.put("waitingCount", waitingCount);
		map.put("bedNoList", bedNoList);
		map.put("opdDetailsList", opdDetailsList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientListAndNotification(int deptId, int hospitalId, int empId) {
		Session session = (Session) getSession();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		List<Inpatient> inPatientSet = new ArrayList<Inpatient>();
		List<Integer> idList = new ArrayList<Integer>();
		List<Transfer> transferList = new ArrayList<Transfer>();
		List<MasBed> bedNoList = new ArrayList<MasBed>();
		List<OpdPatientDetails> opdDetailsList = new ArrayList<OpdPatientDetails>();

		Map<String, Object> map = new HashMap<String, Object>();
		String deptName = "";
		List objectList = new ArrayList();
		int waitingCount = 0;
		try {
			deptList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Id", deptId)).list();
			
			inPatientSet = session.createQuery("select ip from Inpatient as ip where ip.AdStatus in ('W','A','R','O', 'L') and  ip.Department.Id="
					+ deptId+" and ip.Hospital.Id="+hospitalId
					+ "order by (DateOfAddmission)desc").list();
			for(Inpatient inpatient: inPatientSet){
				idList.add(inpatient.getId());
			}
			
			String qry = "select count(*) from inpatient where department_id='"
				+ deptId + "'  and ad_status='W' and hospital_id="+hospitalId;
			objectList = (List) session.createSQLQuery(qry).list();
			if (objectList.get(0) != null) {
				waitingCount = Integer.parseInt("" + objectList.get(0));
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		if (deptList.size() > 0) {
			MasDepartment masDepartment = (MasDepartment) deptList.get(0);
			deptName = masDepartment.getDepartmentName();
		}

		bedNoList = session.createCriteria(MasBed.class).createAlias("Department", "dept").add(Restrictions.eq("dept.Id", deptId))
					.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId))
					.addOrder(Order.asc("Id")).add(Restrictions.eq("Status", "y")).list();

		/**
		 * For getting opd details
		 * Added By Ritu
		 * 20 March 2012
		 */
		//code start for notification by atul
		
		List<PreAnesthesiaConsultDoctorDt> wardList = new ArrayList<PreAnesthesiaConsultDoctorDt>();
		
		wardList=session.createCriteria(PreAnesthesiaConsultDoctorDt.class)
				.add(Restrictions.eq("ConsultedDoctor.Id", empId))
				.add(Restrictions.eq("Status", "P").ignoreCase()).list();
		
		//code end for notification by atul
		
		List<PatientCaseSheetDetails> caseSheetDetails = new ArrayList<PatientCaseSheetDetails>();
		if(inPatientSet.size() > 0){
			transferList = session.createCriteria(Transfer.class ).add(Restrictions.in("Inpatient.Id", idList))
					.addOrder(Order.asc("Id")).list();
			for (Inpatient inpatient : inPatientSet) {
			//	Set<PatientPrescriptionHeader> presHdSet = new HashSet<PatientPrescriptionHeader>();
				Set<PatientPrescriptionDetails> presDt = new HashSet<PatientPrescriptionDetails>();
			/*	Set<ProcedureHeader> procedureHeaderSet = new HashSet<ProcedureHeader>();
				Set<ProcedureDetails> procedureDetailsSet = new HashSet<ProcedureDetails>();*/
				List<NursingcareSetup> procedureList = new ArrayList<NursingcareSetup>();
				Set<PhysioRequisitionHeader> physioHeaderSet = new HashSet<PhysioRequisitionHeader>();
				Set<PhysioRequisitionDetail> physioDetailsSet = new HashSet<PhysioRequisitionDetail>();
				String treatment = "";
				String procedure = "";
				String physioTherapy = "";
				String nursingCare = "";
				String diagnosis = "";
				int inpatientId =inpatient.getId();
				int visitId=0;
				int hinId= inpatient.getHin().getId();
				List<OpdPatientDetails> patientOpdDtList = new ArrayList<OpdPatientDetails>();
				/**
				 * For Treatment
				 */
				List<PatientPrescriptionHeader> presHd = new ArrayList<PatientPrescriptionHeader>();
				presHd = session.createCriteria(PatientPrescriptionHeader.class).add(Restrictions.eq("Inpatient.Id", inpatientId)).addOrder(Order.desc("Id")).setMaxResults(1).list();
				if(presHd.size()==0){
					presHd = session.createCriteria(PatientPrescriptionHeader.class).add(Restrictions.eq("Hin.Id", inpatient.getHin().getId()))
					.addOrder(Order.desc("Id")).setMaxResults(1).list();
				}
				
				if(presHd.size()!=0){
					PatientPrescriptionHeader presHeader = presHd.get(0);
					if(presHeader.getPatientPrescriptionDetails()!=null){
						presDt = presHeader.getPatientPrescriptionDetails();
						if(presHeader.getVisit()!=null)
							visitId = presHeader.getVisit().getId();
					
						for(PatientPrescriptionDetails presDetails : presDt){
							if(!treatment.equals("")){
								treatment +=",<div class='clear'></div>";
							}
							treatment += presDetails.getItem().getNomenclature()+" "+presDetails.getFrequency().getFrequencyName();

						}
					}
				}
				
				
			/*	if(inpatient.getPatientPrescriptionHeaders()!=null && inpatient.getPatientPrescriptionHeaders().size() >0){
					presHdSet = inpatient.getPatientPrescriptionHeaders();

				}else{
					patientOpdDtList = session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "v").createAlias("v.Hin", "hin").add(Restrictions.eq("hin.Id", inpatient.getHin().getId()))
					.addOrder(Order.desc("id")).setMaxResults(1).list();
					if(patientOpdDtList.size() > 0){
						presHdSet = patientOpdDtList.get(0).getPatientPrescriptionHeaders();
					}
				}
				if(presHdSet.size() > 0){
					for(PatientPrescriptionHeader presHeader : presHdSet){
						if(presHeader.getPatientPrescriptionDetails()!=null){
							presDt = presHeader.getPatientPrescriptionDetails();
							if(presHeader.getInpatient()!=null)
								inpatientId = presHeader.getInpatient().getId();
							if(presHeader.getVisit()!=null)
								visitId = presHeader.getVisit().getId();
						}
					}
					if(presDt.size() > 0){
						for(PatientPrescriptionDetails presDetails : presDt){
							if(!treatment.equals("")){
								treatment +=",<div class='clear'></div>";
							}
							treatment += presDetails.getItem().getNomenclature()+" "+presDetails.getFrequency().getFrequencyName();

						}
					}
				}*/
				/**
				 * End Treatment
				 */
				/**
				 * For Procedure
				 */
				/*if(inpatient.getProcedureHeaders()!=null && inpatient.getProcedureHeaders().size() >0){
					procedureHeaderSet = inpatient.getProcedureHeaders();

				}else{
					if(patientOpdDtList.size() > 0){
						procedureHeaderSet = patientOpdDtList.get(0).getProcedureHeaders();
					}
				}
				if(procedureHeaderSet.size() > 0){
					for(ProcedureHeader procedureHeader : procedureHeaderSet){
						if(procedureHeader.getProcedureDetails()!=null){
							procedureDetailsSet = procedureHeader.getProcedureDetails();
						}
					}
					if(procedureDetailsSet.size() > 0){
						for(ProcedureDetails procDetails : procedureDetailsSet){
							if(!procedure.equals("")){
								procedure +=",<div class='clear'></div>";
							}
							procedure += procDetails.getNursingCare().getNursingName();

						}
					}
				}*/
				procedureList = session.createCriteria(NursingcareSetup.class).add(Restrictions.eq("Inpatient.Id", inpatient.getId())).list();
				if(procedureList.size() > 0){
					for(NursingcareSetup nursingcareSetup : procedureList){
						if(!procedure.equals("")){
							procedure +=",<div class='clear'></div>";
						}
						procedure += nursingcareSetup.getNursing().getNursingName();

					}
				}
				/**
				 * End Procedure
				 */
				/**
				 * For Physiotherapy
				 */
				
				if(inpatient.getPhysioRequisitionHeaders()!=null && inpatient.getPhysioRequisitionHeaders().size() >0){
					physioHeaderSet = inpatient.getPhysioRequisitionHeaders();

				}else{
					if(patientOpdDtList.size() > 0){
						physioHeaderSet = patientOpdDtList.get(0).getPhysioRequisitionHeaders();
					}
				}
				if(physioHeaderSet.size() > 0){
					for(PhysioRequisitionHeader physioHeader : physioHeaderSet){
						if(physioHeader.getPhysioRequisitionDetails()!=null){
							physioDetailsSet = physioHeader.getPhysioRequisitionDetails();
						}
					}
					if(physioDetailsSet.size() > 0){
						for(PhysioRequisitionDetail physioDetails : physioDetailsSet){
							if(!physioTherapy.equals("")){
								physioTherapy +=",<div class='clear'></div>";
							}
							if(physioDetails.getTharaphy() != null)
							{
								physioTherapy += physioDetails.getTharaphy().getTherapyTypeName();
							}
							

						}
					}
				}
				/**
				 * End Physiotherapy
				 */
				/**
				 * Nursing Care
				 */
				if(inpatient.getNursingcareSetups()!=null && inpatient.getNursingcareSetups().size() > 0){
					for(NursingcareSetup nursingcareSetup : inpatient.getNursingcareSetups()){
						if(!nursingCare.equals("")){
							nursingCare += ",";
						}
						if(nursingcareSetup.getNursing()!=null)
							nursingCare += nursingcareSetup.getNursing().getNursingName();


					}
				}else{
					List<OpdPatientHistory> patientOpdHistoryList = new ArrayList<OpdPatientHistory>();
					patientOpdHistoryList = session.createCriteria(OpdPatientHistory.class).createAlias("OpdPatientDetails", "opd").createAlias("opd.Visit", "v").createAlias("v.Hin", "hin").add(Restrictions.eq("hin.Id", inpatient.getHin().getId()))
					.addOrder(Order.desc("Id")).setMaxResults(1).list();
					if(patientOpdHistoryList.size() > 0){
						nursingCare += patientOpdHistoryList.get(0).getPresentAdvice();
					}
				}
				/**
				 * End
				 */
				/**
				 * Diagnosis
				 */
				Map<String,Object> dtMap = new HashMap<String, Object>();
				dtMap = getPatientLatestDiagnosisAndDisability(inpatientId);
				List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
				if(dtMap.get("diagnosisList")!=null){
					diagnosisList = (List<DischargeIcdCode>)dtMap.get("diagnosisList");
					if(diagnosisList.size()>0)
						diagnosis = diagnosisList.get(0).getIcd()!=null?diagnosisList.get(0).getIcd().getIcdName():"";

				/**
				 * End
				 */
				PatientCaseSheetDetails patientCaseSheetDetails = new PatientCaseSheetDetails();
				patientCaseSheetDetails.setInpatientId(inpatientId);
				patientCaseSheetDetails.setVisitId(visitId);
				patientCaseSheetDetails.setTreatmentDetails(treatment);
				patientCaseSheetDetails.setProcedureDetails(procedure);
				patientCaseSheetDetails.setPhysiotherapyDetails(physioTherapy);
				patientCaseSheetDetails.setNursingCareDetails(nursingCare);
				patientCaseSheetDetails.setDiagnosisDetails(diagnosis);
				patientCaseSheetDetails.setHinId(hinId);
				caseSheetDetails.add(patientCaseSheetDetails);
						
				}
			}
			
		}

		/**
		 * End
		 */
		map.put("caseSheetDetails", caseSheetDetails);
		map.put("inpatientSet", inPatientSet);
		map.put("transferList", transferList);
		map.put("deptName", deptName);
		map.put("waitingCount", waitingCount);
		map.put("referCount",wardList.size());
		map.put("bedNoList", bedNoList);
		map.put("opdDetailsList", opdDetailsList);
		return map;
	}

	

	@Override
	public Map<String, Object> getInpatientStatus(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();	*/
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;	
		int hospitalId = box.getInt("hospitalId");
		String ServiceNo = box.getString("ServiceNo");
		String empNo ="";
		String paymentStatus ="";
		String deductionFS ="";
		int impHospitalId = 0;
        int rankCategoryId = 0;
        int divisionId = 0;
		if (box.getString("empNo") != null)
			empNo = box.getString("empNo");
		/*if (box.getString("paymentStatus") != null)
			paymentStatus = box.getString("paymentStatus");
		if (box.getString("deductionFS") != null)
			deductionFS = box.getString("deductionFS");
		if (box.get("impHospitalId") != null)
			impHospitalId = box.getInt("impHospitalId");
		if (box.get("rankCategoryId") != null)
			rankCategoryId = box.getInt("rankCategoryId");
		if (box.get("divisionId") != null)
			divisionId = box.getInt("divisionId");	
		*/
		if (box.getString("PN") != null)
			pageNo = Integer.parseInt(box.getString("PN"));	
		
		cr = session.createCriteria(Inpatient.class)						
				.add(Restrictions.ne("AdStatus", "D").ignoreCase())				
				.addOrder(Order.desc("LastChgDate"));
		
		 if (!empNo.equals("")) {
				cr.createAlias("Patient", "p");
				cr = cr.add(Restrictions.eq("p.ServiceNo", empNo));
			}
		/* if (paymentStatus.equals("C")) {
				
				cr = cr.add(Restrictions.eq("ApprovalStatus", "C").ignoreCase());
			}
		 else  if (paymentStatus.equals("P")) {
				
				cr = cr.add(Restrictions.ne("ApprovalStatus", "C").ignoreCase());
			}
			
			if (impHospitalId != 0 ) {
				cr = cr.createAlias("ToHospital", "th");
				cr = cr.add(Restrictions.eq("th.Id", impHospitalId));
			}
			
			if (rankCategoryId != 0 ) {
				cr = cr.createAlias("Hin", "hin");
				cr = cr.createAlias("hin.Employee", "emp");
				cr = cr.createAlias("emp.RankCategory", "rc");
				cr = cr.add(Restrictions.eq("rc.Id", rankCategoryId));
			}
			
			if (divisionId != 0 ) {
				
				cr = cr.add(Restrictions.eq("Division.Id", divisionId));
			}
			
			 if (deductionFS.equals("p")) {
					
				 cr = cr.add(Restrictions.and(Restrictions.gt("DeductionFromSalary", (new BigDecimal(0.0))), Restrictions.isNotNull("DeductionFromSalary")));
				}
			 else if (deductionFS.equals("n")) {
					
					cr = cr.add(Restrictions.or(Restrictions.eq("DeductionFromSalary", (new BigDecimal(0.0))), Restrictions.isNull("DeductionFromSalary")));
				}
			 */
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		inpatientList = cr.list();
		
		System.out.println("totalMatches"+totalMatches.size());
		System.out.println("totalMatches"+inpatientList.size());

		int totalRecords = totalMatches.size();
		totalMatches.clear();	
		/*map.put("OpdPatientDetailsEmpanelledList", OpdPatientDetailsEmpanelledList);*/
		map.put("inpatientList", inpatientList);	
		map.put("totalRecords", totalRecords);
		
				
		return map;
	}
	
	@Override
	public Map<String, Object> showHandTakeJsp(Map<String, Object> map) {
		Session session = (Session) getSession();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeListDoctor = new ArrayList<MasEmployee>();
		List<MasEmployeeDepartment> masEmployeeDepartmentList = new ArrayList<MasEmployeeDepartment>();
//		List<MasEmployee> employeeLoginList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<IpdHandTakeOver> ipdHandTakeOverList = new ArrayList<IpdHandTakeOver>();
		List<Object[]> doctorList = new ArrayList<Object[]>();
		int deptId = 0;
		int userId = 0;
		int inpatientId=0;
		if (map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
		}
		if (map.get("userId") != null) {
			userId = (Integer) map.get("userId");
		}
		if (map.get(INPATIENT_ID) != null) {
			inpatientId = (Integer) map.get(INPATIENT_ID);
		}
		
		
		String emp_code_doctor = null;
		String mas_department_type_ward=null;
		String mmMasRequestStatusPending=null;
		String	mmMasRequestStatusApproved=null;
		String	mmMasRequestStatusReject=null;
		
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("table_constant.properties");
		URL resourcePath1 = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			/*Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			emp_code_doctor = prop.getProperty("mas_emp_category_doctor");
			mas_department_type_ward=prop.getProperty("mas_department_type_ward");*/
			
			Properties prop1 = new Properties();
			prop1.load(new FileInputStream(new File(resourcePath1.getFile())));
			emp_code_doctor = prop1.getProperty("empCategoryCodeForDoctor");
			mas_department_type_ward=prop1.getProperty("departmentTypeCodeForWard");
			mmMasRequestStatusPending=prop1.getProperty("mmMasRequestStatusPending");
			mmMasRequestStatusApproved=prop1.getProperty("mmMasRequestStatusApproved");
			mmMasRequestStatusReject=prop1.getProperty("mmMasRequestStatusReject");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Inpatient inpatient=(Inpatient) session.load(Inpatient.class, inpatientId);
		
		int hospitalid = (Integer) map.get(HOSPITAL_ID);
		/*employeeLoginList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "Y"))
				.add(Restrictions.eq("Hospital.Id", hospitalid))
				.add(Restrictions.eq("EmpCategory.Id", 2))
				.addOrder(Order.asc("FirstName")).list();*/
		
		/*departmentList = session
				.createCriteria(MasInstituteDepartment.class,"msd")
				.createAlias("msd.Department", "md")
				.createAlias("md.DepartmentType", "mdt")
				.createAlias("msd.Institute", "mh")
				.add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase())
				.add(Restrictions.eq("mdt.DepartmentTypeCode", mas_department_type_ward.toLowerCase()).ignoreCase())
				.add(Restrictions.eq("md.Status", "y".toLowerCase()).ignoreCase())
				.add(Restrictions.eq("mh.Id", hospitalid))
				.setProjection(Projections.projectionList().add(Projections.property("msd.Department"))).list();*/
		
		departmentList = session
				.createCriteria(MasDepartment.class)				
				.createAlias("DepartmentType", "mdt")				
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("mdt.DepartmentTypeCode", mas_department_type_ward.toLowerCase()).ignoreCase())
				.add(Restrictions.eq("mdt.Status", "y").ignoreCase())
				.add(Restrictions.eq("Hospital.Id", hospitalid))
				.list();
		
		 
		masEmployeeDepartmentList = session.createCriteria(MasEmployeeDepartment.class)
				.createAlias("Employee", "employee")
				.createAlias("employee.Hospital", "h")
				.add(Restrictions.eq("h.Id", hospitalid))
				.createAlias("employee.EmpCategory", "ecat")
				//.createAlias("Department", "d")
				.add(Restrictions.eq("employee.Status", "y").ignoreCase())				
				.add(Restrictions.eq("ecat.EmpCategoryCode", emp_code_doctor).ignoreCase())
				/*.add(Restrictions.or(Restrictions.like("ServiceCentreId", "%,"+deptId+",%"), 
						Restrictions.or(Restrictions.like("ServiceCentreId", "%"+deptId+",%"),
								Restrictions.like("ServiceCentreId", "%,"+deptId+"%"))) )*/
//				.setProjection(Projections.projectionList().add(Projections.groupProperty("Employee")))
				/*.addOrder(Order.asc("employee.EmployeeName"))*/
				.list();
		for (MasEmployeeDepartment empScMapping : masEmployeeDepartmentList) {
			Object[] array=new Object[3];
			array[0]=empScMapping.getEmployee().getId();
			array[1]=(empScMapping.getEmployee().getFirstName()+" ")
					+(empScMapping.getEmployee().getMiddleName()!=null?empScMapping.getEmployee().getMiddleName()+" ":"")
					+(empScMapping.getEmployee().getLastName()!=null?empScMapping.getEmployee().getLastName()+" ":"");
			array[2]=empScMapping.getDepartment().getId();
			doctorList.add(array);
		}
		
		
		/*employeeList=session.createCriteria(EmpScMapping.class)
		.createAlias("Employee", "employee")
		.createAlias("employee.Hospital", "h")
		.createAlias("employee.EmpCategory", "ecat")		
		.add(Restrictions.eq("employee.Status", "y").ignoreCase())
		.add(Restrictions.eq("h.Id", hospitalid))
		.add(Restrictions.eq("ecat.EmpCategoryCode", emp_code_doctor.toLowerCase()).ignoreCase())		
		.setProjection(Projections.projectionList().add(Projections.groupProperty("Employee")))		
		.list();*/
		employeeList=session.createCriteria(MasEmployee.class)				
				.createAlias("Hospital", "h")
				.createAlias("EmpCategory", "ecat")		
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("h.Id", hospitalid))
				.add(Restrictions.eq("ecat.EmpCategoryCode", emp_code_doctor).ignoreCase())						
				.list();
		

		/*employeeList = session.createCriteria(MasEmployee.class)
				.createAlias("Hospital", "h")
				.createAlias("Department", "d")
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("h.Id", hospitalid))
				.add(Restrictions.eq("d.Id", deptId))
				.addOrder(Order.asc("FirstName")).list();*/
		
		ipdHandTakeOverList = session.createCriteria(IpdHandTakeOver.class)
				.createAlias("Hospital", "h")
				.createAlias("RequestStatus", "rs")
				.createAlias("FromDepartment", "d")
				.add(Restrictions.eq("h.Id", hospitalid))
				.add(Restrictions.in("rs.StatusCode", new String[]{mmMasRequestStatusPending,mmMasRequestStatusReject}))
				.add(Restrictions.eq("d.Id", deptId))
				.list();

		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("inpatient", inpatient);
		map.put("employeeListDoctor", employeeListDoctor);
		map.put("ipdHandTakeOverList", ipdHandTakeOverList);
		map.put("doctorList", doctorList);
		return map;
	}
	
	@Override
	public String getEntrySeqForDisplay(String string) {
		List<Integer> entrySeqNoList = new ArrayList<Integer>();
		List<IpdHandTakeOver> seqNoList = new ArrayList<IpdHandTakeOver>();
		String entrySeqNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			seqNoList = session.createCriteria(IpdHandTakeOver.class).list();
			if (seqNoList.size() > 0) {
				for (IpdHandTakeOver ipdHandTakeOver : seqNoList) {
					lastSeqNo = ipdHandTakeOver.getEntryNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			entrySeqNoList = session
					.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "HEN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (entrySeqNoList.get(0) == null || entrySeqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("IpdHandTakeOver");
				tsObj.setTransactionPrefix("HEN");
				tsObj.setTransactionSequenceName("Entry No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				entrySeqNo = String.valueOf(1);
			} else if (entrySeqNoList.size() > 0) {
				for (Integer maxOrderNo : entrySeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
						entrySeqNo = String.valueOf(maxOrderNo + 1);
					} else {
						entrySeqNo = String.valueOf(1);
						lastSeqYear = currentYear;
					}
				}
			}
			entrySeqNo = entrySeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return entrySeqNo;
	}
	
	@Override
	public boolean submitHandTakeOver(Box box) {
		boolean saved = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		
		Session session=(Session)getSession();
		
		
		String mmMasRequestStatusPending=null;
		
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			mmMasRequestStatusPending=prop.getProperty("mmMasRequestStatusPending");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		
		String entrySeqNo = "";
		int hospitalId = 0;
		String date = "";
		date = (String) utilMap.get("currentDate");
		Date currentDate = new Date();
		
		IpdHandTakeOver ipdHandTakeOver = new IpdHandTakeOver();

			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt(HOSPITAL_ID));
			ipdHandTakeOver.setHospital(masHospital);
		
			System.out.println("taken by id == "+box.getInt(INPATIENT_ID));
		Inpatient inpatient=new Inpatient();
		inpatient.setId(box.getInt(INPATIENT_ID));
		ipdHandTakeOver.setInpatient(inpatient);
		
		Patient patient=new Patient();
		patient.setId(box.getInt(HIN_ID));
		ipdHandTakeOver.setHin(patient);
		
		ipdHandTakeOver.setWardBedTransferRequired("n");
		
		
		ipdHandTakeOver.setEntryDate(HMSUtil.dateFormatterDDMMYYYY(box.getString(TRANSFER_DATE)));
		ipdHandTakeOver.setEntryTime(box.getString(TRANSFER_TIME));
		int fromDepartmentId=box.getInt(FROM_WARD);
		MasDepartment fromDepartment = new MasDepartment();
		fromDepartment.setId(fromDepartmentId);
		ipdHandTakeOver.setFromDepartment(fromDepartment);
		
		int handById= box.getInt("fromDoctor");
		MasEmployee handBy=new MasEmployee();
		handBy.setId(handById);
		ipdHandTakeOver.setHandBy(handBy);
		
		int toDepartmentId=box.getInt(TO_WARD);
		MasDepartment toDepartment = new MasDepartment();
		toDepartment.setId(toDepartmentId);
		ipdHandTakeOver.setDepartment(toDepartment);
		
		int takeById= box.getInt("doctorId");
		MasEmployee takeBy=new MasEmployee();
		takeBy.setId(takeById);
		ipdHandTakeOver.setTakeBy(takeBy);
		
		
		int departmentId = box.getInt(TO_WARD);
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		ipdHandTakeOver.setDepartment(masDepartment);
		
		
		int authorisedById= box.getInt(AUTHORIZER_ID);
		MasEmployee authorisedBy=new MasEmployee();
		authorisedBy.setId(authorisedById);
		ipdHandTakeOver.setAuthorisedBy(authorisedBy);

		/*entrySeqNo = generateEntryNumber();*/
		entrySeqNo = "1";
		ipdHandTakeOver.setEntryNo(entrySeqNo);
		
		ipdHandTakeOver.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		ipdHandTakeOver.setLastChgTime((String)utilMap.get("currentTime"));
		Users users=new Users();
		users.setId(box.getInt(USER_ID));
		ipdHandTakeOver.setLastChgBy(users);
		
		MmMasRequestStatus masRequestStatus=(MmMasRequestStatus) session.createCriteria(MmMasRequestStatus.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("StatusCode", mmMasRequestStatusPending).ignoreCase()).uniqueResult();
		
		ipdHandTakeOver.setRequestStatus(masRequestStatus);
		
		
		hbt.save(ipdHandTakeOver);
		hbt.flush();
		hbt.clear();
		saved = true;
		return saved;
	}
	
	@Override
	public Map<String, Object> getCareTransferAccepJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		Session session = (Session) getSession();
		List<IpdHandTakeOver> ipdHandTakeOverList = new ArrayList<IpdHandTakeOver>();
		int deptId = box.getInt(DEPT_ID);
		
		String mmMasRequestStatusPending=null;
		URL resourcePath1 = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			
			Properties prop1 = new Properties();
			prop1.load(new FileInputStream(new File(resourcePath1.getFile())));
			mmMasRequestStatusPending=prop1.getProperty("mmMasRequestStatusPending");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int hospitalid = box.getInt(HOSPITAL_ID);
		ipdHandTakeOverList = session.createCriteria(IpdHandTakeOver.class)
				.createAlias("Hospital", "h")
				.createAlias("RequestStatus", "rs")
				.createAlias("Department", "d")
				.add(Restrictions.eq("h.Id", hospitalid))
				.add(Restrictions.in("rs.StatusCode", new String[]{mmMasRequestStatusPending}))
				.add(Restrictions.eq("d.Id", deptId))
				.list();

		map.put("ipdHandTakeOverList", ipdHandTakeOverList);
		return map;
	}
	
	@Override
	public Map<String, Object> submitcareTransferAcceeptance(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		boolean status=false;
		String message="";
		
		String mmMasRequestStatusApproved=null;
		String mmMasRequestStatusReject=null;
		URL resourcePath1 = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		List<Transfer> transferNoList = new ArrayList<Transfer>();
		try {
			
			Properties prop1 = new Properties();
			prop1.load(new FileInputStream(new File(resourcePath1.getFile())));
			mmMasRequestStatusApproved=prop1.getProperty("mmMasRequestStatusApproved");
			mmMasRequestStatusReject=prop1.getProperty("mmMasRequestStatusReject");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			
			IpdHandTakeOver ipdHandTakeOver=(IpdHandTakeOver) hbt.load(IpdHandTakeOver.class, box.getInt("handoverId"));
			if(!box.getString("Accept").equals("") && box.getString("Accept").equals("1"))
			{
				Inpatient inpatient=ipdHandTakeOver.getInpatient();
				MmMasRequestStatus masRequestStatus=(MmMasRequestStatus) session.createCriteria(MmMasRequestStatus.class)
						.add(Restrictions.eq("Status", "y").ignoreCase())
						.add(Restrictions.eq("StatusCode", mmMasRequestStatusApproved).ignoreCase()).uniqueResult();
				ipdHandTakeOver.setRequestStatus(masRequestStatus);
				ipdHandTakeOver.setRemarksPendingWork(box.getString(REMARKS));
				inpatient.setDoctor(ipdHandTakeOver.getTakeBy());
				
				if(!box.getString("transferRequired").equals("") && box.getString("transferRequired").equals("1"))
				{
					ipdHandTakeOver.setWardBedTransferRequired("y");
					String transferType="ward";
					Transfer transfer = new Transfer();
					transfer.setInpatient(inpatient);
					transfer.setHin(inpatient.getHin());
					transfer.setAdNo(inpatient.getAdNo());
					MasHospital hospital=new MasHospital();
					hospital.setId(box.getInt(HOSPITAL_ID));
					transfer.setHospital(hospital);
					transfer.setFromWard(inpatient.getDepartment());
					transfer.setFromBed(inpatient.getBed());
					transfer.setRequestStatus("p");
					transfer.setTransferType(transferType);
					transfer.setTransferReason("Doctor Request");
					transferNoList = session.createCriteria(Transfer.class)
							.addOrder(Order.desc("Id")).setMaxResults(1).list();
					if(transferNoList!=null && transferNoList.size()>0)
					{
						transfer.setTransferNo(transferNoList.get(0).getTransferNo());
					}
					else
					{
						transfer.setTransferNo(1);
					}
						MasDepartment toDepartment=new MasDepartment();
						toDepartment.setId((Integer)box.getInt(DEPT_ID));
						transfer.setToWard(toDepartment);
					
					/*MasEmployee authorizer=new MasEmployee();
					authorizer.setId(box.getInt(AUTHORIZER_ID));
					transfer.setAuthorizedBy(authorizer);*/
					
					
					transfer.setDateOfTransfer(ipdHandTakeOver.getEntryDate());
					transfer.setTimeOfTransfer(ipdHandTakeOver.getEntryTime());
					transfer.setAdStatus(inpatient.getAdStatus());
					transfer.setStatus("y");
					Users users=new Users();
					users.setId(box.getInt(USER_ID));
					transfer.setAddEditBy(users);
					Map<String, Object> utilMap = new HashMap<String, Object>();
					utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
					String date2 = (String) utilMap.get("currentDate");
					String time = (String) utilMap.get("currentTime");
					transfer.setAddEditDate(HMSUtil.convertStringTypeDateToDateType(date2));
					transfer.setAddEditTime(time);
					hbt.save(transfer);
				}
				hbt.update(inpatient);
				hbt.update(ipdHandTakeOver);
				status=true;
				 message="Accepted Successfully.";
			}
			else if(!box.getString("Accept").equals("") && box.getString("Accept").equals("2"))
			{
				MmMasRequestStatus masRequestStatus=(MmMasRequestStatus) session.createCriteria(MmMasRequestStatus.class)
						.add(Restrictions.eq("Status", "y").ignoreCase())
						.add(Restrictions.eq("StatusCode", mmMasRequestStatusReject).ignoreCase()).uniqueResult();
				ipdHandTakeOver.setRequestStatus(masRequestStatus);
				ipdHandTakeOver.setRemarksPendingWork(box.getString(REMARKS));
				if(!box.getString("transferRequired").equals("") && box.getString("transferRequired").equals("1"))
				{
					ipdHandTakeOver.setWardBedTransferRequired("y");
				}
				hbt.update(ipdHandTakeOver);
				status=true;
				message="Rejected Successfully.";
			}

			tx.commit();
			hbt.flush();
			hbt.clear();
		}
		catch(Exception exception)
		{
			 status=false;
			 message="Error occured. Please try afer some time!!!";
			 tx.rollback();
			 exception.printStackTrace();
		}
		System.out.println("message is == "+message);
		map.put("message", message);
		map.put("status", status);
		return map;
	}
	
	@Override
	public Map<String, Object> getReferalList(int hospitalId, int userId) {
		Session session=(Session)getSession();
		Map<String,Object>map=new HashMap<String,Object>();
		List<WardRemarks>wardReamrks=new ArrayList<WardRemarks>();
		List<Users>userList=new ArrayList<Users>();
		userList=session.createCriteria(Users.class).add(Restrictions.eq("Id", userId)).list();
		int empId=0;
		for(Users users:userList){
			empId=users.getEmployee().getId();
		}		
		List<WardRemarks>wardList=new ArrayList<WardRemarks>();
		wardList=session.createCriteria(PreAnesthesiaConsultDoctorDt.class).add(Restrictions.eq("ConsultedDoctor.Id", empId)).add(Restrictions.eq("Status", "P").ignoreCase()).list();
		map.put("wardList",wardList);
		return map;
	}
	
	public Map<String, Object>checkMappedCharge(Map<String, Object> map){
		List<MasChargeCode> masChargeCodes = new ArrayList<MasChargeCode>();
		Criteria crit =null;
		Session session = (Session) getSession();		
		String chargeName =(String)map.get("chargeName");
		String subChargeCode =null;
		if(map.get("surgeryType")!=null)
			subChargeCode = (String)map.get("surgeryType");
		String mainChargeCodeForSurgery = HMSUtil.getProperties("adt.properties", "mainChargeCodeForSurgery");
		/*List chargeTypeList=new ArrayList();
		chargeTypeList.add(10);*/
		/*chargeTypeList.add(11);*/
		crit = session.createCriteria(MasChargeCode.class)
				.createAlias("MainChargecode", "mcc")
					
				.add(Restrictions.eq("mcc.MainChargecodeCode",mainChargeCodeForSurgery).ignoreCase())
				.add(Restrictions.like("ChargeCodeName", "%"+chargeName+"%"));
				if(subChargeCode!=null)
				{
					crit.createAlias("SubChargecode", "scc")
				.add(Restrictions.eq("scc.SubChargecodeCode",subChargeCode).ignoreCase());
				}
				
				
		masChargeCodes	= crit.list();
		if(masChargeCodes.size()>0){
			map.put("chargecodeId", masChargeCodes.get(0).getId());
		}
		map.put("count", masChargeCodes.size());
		map.put("chargeList", masChargeCodes);
		return map;
	}
	

	public Map<String, Object> getItemListForLoanoutByAutocompleteBalance(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		try {

			Session session = (Session) getSession();
			String pvmsNo = null;
			int deptId = 0;
			int balanceId = 0;
			int hospitalId = 0;
			int groupId = 0;
			int itemTypeId = 0;
			int sectionId = 0;
			int categoryId = 0;
			int classId = 0;
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
			balanceId = Integer.parseInt("" + dataMap.get("balanceId"));
			if(dataMap.get("groupId")!= null){
				groupId =(Integer)dataMap.get("groupId");
			}
			if(dataMap.get("itemTypeId")!= null){
				itemTypeId =(Integer)dataMap.get("itemTypeId");
			}
			if(dataMap.get("sectionId")!= null){
				sectionId =(Integer)dataMap.get("sectionId");
			}
			if(dataMap.get("categoryId")!= null){
				categoryId =(Integer)dataMap.get("categoryId");
			}
			if(dataMap.get("classId")!= null){
				classId =(Integer)dataMap.get("classId");
			}
			
			List objectList = new ArrayList();
			List objectList1 = new ArrayList();
			try {
				String str = (String) dataMap.get("autoHint") + "%";
				String qry = "SELECT t.item_id FROM store_balance_t t,store_balance_m m where t.store_balance_m_id='"
						+ balanceId + "' and m.id=t.store_balance_m_id ";
				objectList = (List) session.createSQLQuery(qry).list();
		if (objectList.size() != 0) {

					Criteria c = session
							.createCriteria(MasStoreItem.class)
							.add(Restrictions.like("Nomenclature", str).ignoreCase())
							.add(Restrictions.not(Restrictions.in("Id",
									objectList)));

					c.setFirstResult(0);
					c.setMaxResults(10);
					itemList = c.list();
		} else {
			Criteria c = session.createCriteria(MasStoreItem.class)
					.add(Restrictions.like("Nomenclature", str).ignoreCase())
					;
					if (groupId != 0) {
						c = c.add(Restrictions.eq("Group.Id", groupId));
					}
					if (itemTypeId != 0) {
						c = c.add(Restrictions.eq("ItemType.Id",itemTypeId));
					}
					if (sectionId != 0) {
						c = c.add(Restrictions.eq("Section.Id",sectionId));
					}
					if (categoryId != 0) {
						c = c.add(Restrictions.eq("ItemCategory.Id",categoryId));
					}
					if (classId != 0) {
						c = c.add(Restrictions.eq("ItemClass.Id",classId));
					}
					c.setFirstResult(0);
					c.setMaxResults(10);
					itemList = c.list();
				}
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			map.put("itemList", itemList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	
	@SuppressWarnings( { "unused", "unchecked" })
	public Map<String, Object> searchPatient(Map map) {
		Session session = (Session) getSession();
		List patientList = new ArrayList();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setCheckWriteOperations(false);
		hbt.setFlushModeName("FLUSH_EAGER");
		int id = 0;
		int deptId = (Integer) map.get("deptId");
		String serviceNumber = "";
		String hinNumber = "";
		List<Inpatient> inPatientSet = new ArrayList<Inpatient>();
		try {
			if (map.get("adNo") != null) {
				id = (Integer) map.get("adNo");
				// patientList=getHibernateTemplate().find(" from jkt.hms.masters.business.Inpatient as inPatient where inPatient.Id = "+id
				// +" ");
				patientList = session.createCriteria(Inpatient.class).add(
						Restrictions.eq("Id", id)).list();
				Inpatient inpatient = (Inpatient) patientList.get(0);
				inPatientSet.add(inpatient);
			}

			if (map.get("serviceNumber") != null) {
				serviceNumber = (String) map.get("serviceNumber");
				patientList = session.createQuery(
						"select ip from Inpatient as ip where ip.Department.Id="
						+ deptId + " and ip.Hin.ServiceNo='"
						+ serviceNumber + "'").list();
				if (patientList.size() > 0) {
					Iterator itr = patientList.iterator();
					while (itr.hasNext()) {
						Inpatient inpatient = (Inpatient) itr.next();
						inPatientSet.add(inpatient);
					}
				}
			}
			if (map.get("hinNumber") != null) {
				hinNumber = (String) map.get("hinNumber");
				patientList = session.createQuery(
						"select ip from Inpatient as ip where  ip.Department.Id="
						+ deptId + " and ip.Hin.HinNo='" + hinNumber
						+ "'").list();
				if (patientList.size() > 0) {
					Inpatient inpatient = (Inpatient) patientList.get(0);
					inPatientSet.add(inpatient);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		}
		map.put("inPatientSet", inPatientSet);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> nursingCareSetup(int hin) {

		String admissionNumber = null;
		List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
		List<MasNursingCare> nursingCareList = new ArrayList<MasNursingCare>();
		List<NursingcareSetup> nursingCareSetupList = new ArrayList<NursingcareSetup>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			inPatientDetailList = session.createCriteria(Inpatient.class).add(
					Restrictions.eq("Id", hin)).list();
			nursingCareList = session.createCriteria(MasNursingCare.class)
			.list();
			frequencyList = session.createCriteria(MasFrequency.class).add(Restrictions.eq("Status", "y")).list();
			if (inPatientDetailList != null) {
				Inpatient inpatient = (Inpatient) inPatientDetailList.get(0);
				admissionNumber = inpatient.getAdNo();
			}
			nursingCareSetupList = session.createCriteria(
					NursingcareSetup.class).add(
							Restrictions.eq("AdNo", admissionNumber)).list();
		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		map.put("frequencyList", frequencyList);
		map.put("nursingCareSetupList", nursingCareSetupList);
		map.put("inPatientDetailList", inPatientDetailList);
		map.put("nursingCareList", nursingCareList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean addNursingCare(Map map) {
		boolean succesfullyAdded = false;
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();

		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		Date dateToInsert = HMSUtil.convertStringTypeDateToDateType(date);
		String time = (String) utilMap.get("currentTimeWithoutSc");
		String admissionNumber = (String) map.get("admissionNumber");
		String userName = (String) map.get("userName");
		List nursingIdList = (List) map.get("list");
		List frequencyList = (List) map.get("frequencyList");
		List nurSetupIdList = (List) map.get("nurSetupIdList");
		List remarksList = (List) map.get("remarksList");
		List durationList = (List) map.get("durationList");
		List noOfDaysList = (List) map.get("noOfDaysList");
		int hinId = (Integer) map.get("hinId");
		int deptId = (Integer) map.get("deptId");
		MasDepartment department = new MasDepartment();
		department.setId(deptId);
		int inpatientId = (Integer) map.get("inpatientId");
		Transaction tx = null;
		try {
			tx= session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			// String
			// hql="delete from jkt.hms.masters.business.NursingcareSetup as ncs where ncs.AdNo = '"+admissionNumber+"'";
			// Query query = session.createQuery(hql);
			// int row = query.executeUpdate();
			/*	String hql = "delete from jkt.hms.masters.business.NursingcareSetup as ncs where ncs.AdNo like :adNo";
			Query query = session.createQuery(hql).setParameter("adNo",
					admissionNumber);
			@SuppressWarnings("unused")
			int row = query.executeUpdate();*/



			int i = 0;
			for (int j = 0; j < nursingIdList.size(); j++) {

				if(Integer.parseInt(frequencyList.get(i).toString()) != 0){
					if(Integer.parseInt(nurSetupIdList.get(i).toString()) != 0){
						int nurSetupId = Integer.parseInt(nurSetupIdList.get(i).toString()) ;
						NursingcareSetup nursingcareSetup = (NursingcareSetup)hbt.load(NursingcareSetup.class, nurSetupId);
						MasFrequency masFrequency = new MasFrequency();
						masFrequency.setId((Integer) frequencyList.get(i));
						nursingcareSetup.setFrequency(masFrequency);
						nursingcareSetup.setRemarks(remarksList.get(i).toString());
						nursingcareSetup.setDuration(durationList.get(i).toString());
						nursingcareSetup.setNoOfDays((Integer)noOfDaysList.get(i));
						nursingcareSetup.setLastChgBy(userName);
						nursingcareSetup.setLastChgTime(time);
						nursingcareSetup.setLastChgDate(dateToInsert);
						nursingcareSetup.setDepartment(department);
						try {
							hbt.update(nursingcareSetup);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else{
						NursingcareSetup nursingcareSetup = new NursingcareSetup();
						Integer nursId = Integer.parseInt(nursingIdList.get(i).toString());

						MasNursingCare masNursingCare = new MasNursingCare();
						masNursingCare.setId(nursId);
						nursingcareSetup.setNursing(masNursingCare);

						nursingcareSetup.setAdNo(admissionNumber);
						nursingcareSetup.setLastChgBy(userName);
						nursingcareSetup.setLastChgTime(time);
						nursingcareSetup.setLastChgDate(dateToInsert);
						Patient patient = new Patient();
						patient.setId(hinId);
						nursingcareSetup.setHin(patient);

						MasFrequency masFrequency = new MasFrequency();
						masFrequency.setId((Integer) frequencyList.get(i));
						nursingcareSetup.setFrequency(masFrequency);
						nursingcareSetup.setRemarks(remarksList.get(i).toString());
						nursingcareSetup.setDuration(durationList.get(i).toString());
						nursingcareSetup.setNoOfDays((Integer)noOfDaysList.get(i));
						Inpatient inpatient = new Inpatient();
						inpatient.setId(inpatientId);						
						nursingcareSetup.setInpatient(inpatient);
						nursingcareSetup.setDepartment(department);
						hbt.save(nursingcareSetup);
					}
					i++;
				}
				// Caresummary caresummary= new Caresummary();
				// caresummary.setAdNo(admissionNumber);
				// caresummary.setDateOfCare(dateToInsert);
				// caresummary.setNoOfTimes(0);
				// caresummary.setNursing(masNursingCare);
				// hbt.save(caresummary);
				// getHibernateTemplate().save(patient);
			}
			succesfullyAdded = true;
			tx.commit();
		}catch (HibernateException e){
			e.printStackTrace();
			if(tx!= null)
				tx.rollback();

			session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return succesfullyAdded;
	}

	public boolean addDietSetup(Map map)
	{ 
		boolean succesfullyAdded = false;
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		Date dt = new Date();
		Date dateToInsert = HMSUtil.convertStringTypeDateToDateType(date);
		/*String dateToInsert1 = HMSUtil.changeDateToddMMyyyy(dateToInsert);

		Date date1 = Calendar.getInstance().getTime();
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String today = formatter.format(date1);
		Date date2 =HMSUtil.convertStringTypeDateToDateType(date);*/
		int deptId = (Integer)map.get("deptId");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		String userName=(String)map.get("userName");
		int dietFor= (Integer) map.get("dietFor");
		int cont=(Integer)map.get("cont");
		List<Integer> hinIdList = (List)map.get("hinIdList");
		List<Integer> bedIdList = (List)map.get("bedIdList");
		List<Integer> inpatientIdList = (List)map.get("inpatientIdList");
		List<Integer> typeOfDietList = (List)map.get("typeOfDietList");
		List<String> dietList = (List)map.get("dietList");
		List<String> morningTeaList = (List)map.get("morningTeaList");
		List<String> lunchList = (List)map.get("lunchList");
		List<String> eveningTeaList = (List)map.get("eveningTeaList");
		List<String> dinnerList = (List)map.get("dinnerList");
		List<String> splInsList = (List)map.get("splInsList");
		List<Integer> patIdList = new ArrayList<Integer>();
		List<Integer> dietIdList =(List)map.get("dietIdList");
		List<PatientDietIndoorDetail> patientDietList = new ArrayList<PatientDietIndoorDetail>();
		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			for(int i=0;i<cont;i++){

				/*String hql=("select pdi from PatientDietIndoorDetail as pdi where department_id= "+deptId+
						" and pdi.Inpatient= "+inpatientIdList.get(i)+" and pdi.Hin= "+hinIdList.get(i)+" and " +
						" pdi.MN= "+dietFor+" and pdi.LastChgDate= to_date('"+date+"','dd/mm/yyyy') order by pdi.Id asc");

				patientDietList=session.createQuery(hql).list();*/
				
				patientDietList=session.createCriteria(PatientDietIndoorDetail.class)
						.add(Restrictions.eq("Department.Id", deptId))
						.add(Restrictions.eq("Inpatient.Id", inpatientIdList.get(i)))
						.add(Restrictions.eq("Hin.Id", hinIdList.get(i)))
						.add(Restrictions.eq("MN", dietFor))
						.add(Restrictions.eq("LastChgDate", dt))
						.addOrder(Order.asc("Id")).list();
				if(patientDietList.size()>0){

					/*PatientDietIndoorDetail patDetailList = (PatientDietIndoorDetail) getHibernateTemplate()
 			   .load(PatientDietIndoorDetail.class, patientDietList.get(0).getId());*/

					String sql = "delete from patient_diet_indoor_detail where id= "+patientDietList.get(0).getId();
					Query query = session.createSQLQuery(sql);
					query.executeUpdate();
					/*if(hinIdList.get(i)!=null && hinIdList.get(i)>0){
           	    Patient pat = new Patient();
           	    pat.setId(hinIdList.get(i));
           	    patDetailList.setHin(pat);
           	    }
           	    if(bedIdList.get(i)!=null && bedIdList.get(i)>0){
           	    MasBed mBed = new MasBed();
           	    mBed.setId(bedIdList.get(i));
           	    patDetailList.setBed(mBed);
           	    }
           	    if(inpatientIdList.get(i)!=null && inpatientIdList.get(i)>0){
           	    Inpatient inPat = new Inpatient();
           	    inPat.setId(inpatientIdList.get(i));
           	    patDetailList.setInpatient(inPat);
           	    }
           	    if(typeOfDietList.size()>0){
           	    if(typeOfDietList.get(i)!=null && typeOfDietList.get(i)>0){
           	    MasDiet mDiet = new MasDiet();
           	    mDiet.setId(typeOfDietList.get(i));
           	    patDetailList.setDietId(mDiet);
           	    }else if(typeOfDietList.get(i).equals("0") && dietIdList.get(i)!=null && !dietIdList.get(i).equals("0")){
           	    	MasDiet mDiet2 = new MasDiet();
               	    mDiet2.setId(dietIdList.get(i));
               	    patDetailList.setDietId(mDiet2);
           	    }
           	    }
           	    if(bedIdList.get(i)!=null && bedIdList.get(i)>0){
           	    MasBed mBed = new MasBed();
           	    mBed.setId(bedIdList.get(i));
           	    patDetailList.setBed(mBed);
           	    }
           	 if(dietList.size()>0){
           	    if(dietList.get(i)!=null && dietList.get(i)!="" && !dietList.get(i).equals("0")){
           	    patDetailList.setDiet(dietList.get(i));
           	    }
           	 }
           	    if(morningTeaList.size()>0){
           	    if(morningTeaList.get(i)!=null && morningTeaList.get(i)!="" && !morningTeaList.get(i).equals("0")){
           	    patDetailList.setMorningTeaBread(morningTeaList.get(i));
                }
           	    }
           	    if(lunchList.size()>0){
           	    if(lunchList.get(i)!=null && lunchList.get(i)!="" && !lunchList.get(i).equals("0")){
           	    patDetailList.setLunch(lunchList.get(i));
            	}
           	    }
           	    if(eveningTeaList.size()>0){
           	    if(eveningTeaList.get(i)!=null && eveningTeaList.get(i)!="" && !eveningTeaList.get(i).equals("0")){
           	    patDetailList.setEveningTea(eveningTeaList.get(i));
            	}
           	    }
           	    if(dinnerList.size()>0){
           	    if(dinnerList.get(i)!=null && dinnerList.get(i)!="" && !dinnerList.get(i).equals("0")){
           	    patDetailList.setDinner(dinnerList.get(i));
             	}
           	    }
           	    if(splInsList.size()>0){
           	    if(splInsList.get(i)!=null && splInsList.get(i)!=""){
           	    patDetailList.setSpecialInst(splInsList.get(i));
             	}
           	    }
           	    MasDepartment md =new MasDepartment();
           	    md.setId(deptId);
           	    patDetailList.setDepartment(md);
           	   patDetailList.setLastChgBy(userName);
           	   patDetailList.setLastChgDate(dateToInsert);
           	   patDetailList.setLastChgTime(time);
           	   patDetailList.setStatus("y");
           	   patDetailList.setMN(dietFor);
           	   hbt.update(patDetailList);
           	   hbt.refresh(patDetailList);
					 */

				}
				PatientDietIndoorDetail patientDietIndoorDetail = new PatientDietIndoorDetail();
				if(hinIdList.get(i)!=null && hinIdList.get(i)>0){
					Patient pat = new Patient();
					pat.setId(hinIdList.get(i));
					patientDietIndoorDetail.setHin(pat);
				}
				if(bedIdList.get(i)!=null && bedIdList.get(i)>0){
					MasBed mBed = new MasBed();
					mBed.setId(bedIdList.get(i));
					patientDietIndoorDetail.setBed(mBed);
				}
				if(inpatientIdList.get(i)!=null && inpatientIdList.get(i)>0){
					Inpatient inPat = new Inpatient();
					inPat.setId(inpatientIdList.get(i));
					patientDietIndoorDetail.setInpatient(inPat);
				}
				if(typeOfDietList.size()>0){
					if(typeOfDietList.get(i)!=null && typeOfDietList.get(i)>0 ){
						MasDiet mDiet = new MasDiet();
						mDiet.setId(typeOfDietList.get(i));
						patientDietIndoorDetail.setDietId(mDiet);
					}
				}

				if(dietList.size()>0){
					if(dietList.get(i)!=null && dietList.get(i)!="" && !dietList.get(i).equals("0")){
						patientDietIndoorDetail.setDiet(dietList.get(i));
					}
				}
				if(morningTeaList.size()>0){
					if(morningTeaList.get(i)!=null && morningTeaList.get(i)!="" && !morningTeaList.get(i).equals("0")){
						patientDietIndoorDetail.setMorningTeaBread(morningTeaList.get(i));
					}
				}
				if(lunchList.size()>0){
					if(lunchList.get(i)!=null && lunchList.get(i)!="" && !lunchList.get(i).equals("0")){
						patientDietIndoorDetail.setLunch(lunchList.get(i));
					}
				}
				if(eveningTeaList.size()>0){
					if(eveningTeaList.get(i)!=null && eveningTeaList.get(i)!="" && !eveningTeaList.get(i).equals("0")){
						patientDietIndoorDetail.setEveningTea(eveningTeaList.get(i));
					}
				}
				if(dinnerList.size()>0){
					if(dinnerList.get(i)!=null && dinnerList.get(i)!="" && !dinnerList.get(i).equals("0")){
						patientDietIndoorDetail.setDinner(dinnerList.get(i));
					}
				}
				if(splInsList.size()>0){
					if(splInsList.get(i)!=null && splInsList.get(i)!=""){
						patientDietIndoorDetail.setSpecialInst(splInsList.get(i));
					}
				}
				MasDepartment md1 =new MasDepartment();
				md1.setId(deptId);
				patientDietIndoorDetail.setDepartment(md1);
				patientDietIndoorDetail.setLastChgBy(userName);
				patientDietIndoorDetail.setLastChgDate(dateToInsert);
				patientDietIndoorDetail.setLastChgTime(time);
				patientDietIndoorDetail.setStatus("y");
				patientDietIndoorDetail.setMN(dietFor);

				hbt.save(patientDietIndoorDetail);
				hbt.refresh(patientDietIndoorDetail);
			}

			succesfullyAdded = true;
		}
		catch(Exception e)
		{e.printStackTrace();}
		return   succesfullyAdded;
	}

	@SuppressWarnings( { "unused", "unchecked" })
	public Map<String, Object> showFoodTesting(int deptId) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Date date = new Date();
		List<NursingfoodTest> foodDetailList = new ArrayList<NursingfoodTest>();
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			foodDetailList = session.createCriteria(NursingfoodTest.class).add(
					Restrictions.eq("Fooddate", date)).list();
			empList = session
			.createQuery(
					"select emp from MasEmployee as emp where emp.EmpCategory.Id=" + 2)
					.list();
			map.put("foodDetailList", foodDetailList);
			map.put("empList", empList);
		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean insertFoodTestingDetails(Map map) {

		boolean dataInserted = false;
		@SuppressWarnings("unused")
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		Date dateToInsert = HMSUtil.convertStringTypeDateToDateType(date);

		int deptId = (Integer) map.get("deptId");
		String userName = (String) map.get("userName");
		@SuppressWarnings("unused")
		List<NursingfoodTest> foodDetailList = new ArrayList<NursingfoodTest>();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);

			if (map.get("breakFastStatus") != null) {
				NursingfoodTest nursingfoodTest = new NursingfoodTest();
				String breakFastTime = (String) map.get("breakFastTime");
				String breakFastStatus = (String) map.get("breakFastStatus");
				String breakFastRemarks = (String) map.get("breakFastRemarks");
				String breakFastCheckedByEmp = (String) map
				.get("breakFastCheckedByEmp");
				nursingfoodTest.setFoodname("BreakFast");
				nursingfoodTest.setFoodstatus(breakFastStatus);

				nursingfoodTest.setDepartment(masDepartment);
				nursingfoodTest.setFooddate(dateToInsert);
				nursingfoodTest.setFoodtime(breakFastTime);
				nursingfoodTest.setRemarks(breakFastRemarks);
				nursingfoodTest.setTestedby(breakFastCheckedByEmp);
				nursingfoodTest.setLastChgBy(userName);
				nursingfoodTest.setLastChgDate(dateToInsert);
				nursingfoodTest.setLastChgTime(time);
				hbt.save(nursingfoodTest);
			}
			if (map.get("lunchStatus") != null) {
				NursingfoodTest nursingfoodTest = new NursingfoodTest();
				String lunchTime = (String) map.get("lunchTime");
				String lunchStatus = (String) map.get("lunchStatus");
				String lunchRemarks = (String) map.get("lunchRemarks");
				String lunchCheckedByEmp = (String) map
				.get("lunchCheckedByEmp");
				nursingfoodTest.setFoodname("Lunch");
				nursingfoodTest.setFoodstatus(lunchStatus);
				nursingfoodTest.setDepartment(masDepartment);
				nursingfoodTest.setFooddate(dateToInsert);
				nursingfoodTest.setFoodtime(lunchTime);
				nursingfoodTest.setRemarks(lunchRemarks);
				nursingfoodTest.setTestedby(lunchCheckedByEmp);
				nursingfoodTest.setLastChgBy(userName);
				nursingfoodTest.setLastChgDate(dateToInsert);
				nursingfoodTest.setLastChgTime(time);
				hbt.save(nursingfoodTest);
			}
			if (map.get("dinnerStatus") != null) {
				NursingfoodTest nursingfoodTest = new NursingfoodTest();
				String dinnerTime = (String) map.get("dinnerTime");
				String dinnerStatus = (String) map.get("dinnerStatus");
				String dinnerRemarks = (String) map.get("dinnerRemarks");
				String dinnerCheckedByEmp = (String) map
				.get("dinnerCheckedByEmp");
				nursingfoodTest.setFoodname("Dinner");
				nursingfoodTest.setFoodstatus(dinnerStatus);
				nursingfoodTest.setDepartment(masDepartment);
				nursingfoodTest.setFooddate(dateToInsert);
				nursingfoodTest.setFoodtime(dinnerTime);
				nursingfoodTest.setRemarks(dinnerRemarks);
				nursingfoodTest.setTestedby(dinnerCheckedByEmp);
				nursingfoodTest.setLastChgBy(userName);
				nursingfoodTest.setLastChgDate(dateToInsert);
				nursingfoodTest.setLastChgTime(time);
				hbt.save(nursingfoodTest);

			}
			dataInserted = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataInserted;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showCaresList() {
		List<MasNursingCare> nursingCareList = new ArrayList<MasNursingCare>();

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			nursingCareList = session.createCriteria(MasNursingCare.class)
			.list();
		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		map.put("nursingCareList", nursingCareList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientListOnBasisOfCare(int careId,
			int deptId) {
		List showList = new ArrayList();
		List admissionNumberList = new ArrayList();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			// Criteria nursinCareSetupCriteria =
			// session.createCriteria(NursingcareSetup.class)

			// .createCriteria(NursingcareSetup.PROP_NURSING)
			// .add(Expression.eq(MasNursingCare.PROP_ID, careId));

			// showList = nursinCareSetupCriteria.list();

			showList = session.createQuery(
					"select ncs from  NursingcareSetup as ncs where ncs.Nursing.Id="
					+ careId + "and ncs.Inpatient.Department.Id="
					+ deptId).list();
			admissionNumberList.addAll(showList);

			for (Object object3 : showList) {
				NursingcareSetup nursingcareSetup = (NursingcareSetup) object3;
				@SuppressWarnings("unused")
				Set<Ipdcaredetail> ipdcaredetails = nursingcareSetup
				.getIpdcaredetails();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("showList", showList);
		map.put("admissionNumberList", admissionNumberList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchPatientOnBasisOfCare(Map map) {

		List showList = new ArrayList();
		int nursingCareSetupId = 0;
		int nursingId = 0;
		Session session = (Session) getSession();
		// careId=(Integer)map.get("careId");
		nursingCareSetupId = (Integer) map.get("nursingCareSetupId");
		// Map<String ,Object> newMap= new HashMap<String, Object>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Criteria nursinCareSetupCriteria = session.createCriteria(
					NursingcareSetup.class)
					.add(
							Expression.eq(NursingcareSetup.PROP_ID,
									nursingCareSetupId));
			showList = nursinCareSetupCriteria.list();
			NursingcareSetup nursingcareSetup = (NursingcareSetup) showList
			.get(0);
			nursingId = nursingcareSetup.getNursing().getId();
		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		map.put("showList", showList);
		map.put("nursingId", nursingId);

		return map;
	}
	
	
	@SuppressWarnings( { "unchecked" })
	public boolean submitMedicineEntryPage(Box box) {

		boolean succesfullyAdded = false;

		
		Transaction tx = null;
		Session session = (Session)getSession();
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			int frequency = box.getInt("frequency");			
			int no_of_days = box.getInt("no_of_days");
			int headerId = box.getInt("headerId");
			int dmiId = box.getInt("dmiId");
			int issued = 0;
			int dosage = 0;
			Users user = new Users();
			user.setId(box.getInt("userId"));
			
			
			System.out.println("headerId"+headerId);
			PatientPrescriptionDetails ppd = (PatientPrescriptionDetails)session.load(PatientPrescriptionDetails.class, headerId);
			if(ppd.getDosage()!=null && !ppd.getDosage().trim().equals(""))
			{
				dosage = Integer.parseInt(ppd.getDosage());
			}
			
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			
			
						
			StoreItemBatchStock batchStock = (StoreItemBatchStock)session.load(StoreItemBatchStock.class, dmiId);
			
			String time = (String) utilMap.get("currentTimeWithoutSc");
			
			for(int i=1; i<=no_of_days; i++)
			{
				for(int j=1; j<=frequency; j++)
				{
					IpdMedicineIssueDetails ipdMedicineIssueDetails = new IpdMedicineIssueDetails();
					if(box.getString("dose"+i+j)!=null && box.getString("dose"+i+j).trim().equals("y"))
					{
						ipdMedicineIssueDetails.setPatientPrescriptionDetails(ppd);
						ipdMedicineIssueDetails.setIssueDate(HMSUtil.convertStringTypeDateToDateType(box.getString("date"+i)));
						ipdMedicineIssueDetails.setIssueTime(box.getString("dose_time"+i+j));
						ipdMedicineIssueDetails.setDose("dose"+i+j);
						ipdMedicineIssueDetails.setIssued("y");
						ipdMedicineIssueDetails.setLastChgBy(user);
						ipdMedicineIssueDetails.setLastChgDate(new Date());
						ipdMedicineIssueDetails.setLastChgTime(time);
						ipdMedicineIssueDetails.setBatchStock(batchStock);
						ipdMedicineIssueDetails.setRemarks(box.getString("remarks"+i));
						
						/*ipdMedicineIssueDetails.setIssueDate();*/
						issued += dosage;
						hbt.saveOrUpdate(ipdMedicineIssueDetails);
					}
					
				}
			}
		
			BigDecimal issuedBig = new BigDecimal(issued).setScale(2, BigDecimal.ROUND_HALF_UP);
			if(batchStock.getClosingStock().compareTo(issuedBig)==-1)
			{
				
				issuedBig = batchStock.getClosingStock();	
				
			}
			if((issuedBig.intValue()+(ppd.getQtyIssued()!=null?ppd.getQtyIssued():0)) >= ppd.getTotal())
			{
				issuedBig =  new BigDecimal((ppd.getTotal() - (ppd.getQtyIssued()!=null?ppd.getQtyIssued():0))).setScale(2, BigDecimal.ROUND_HALF_UP);
			}
			
		
			
		
				
				ppd.setQtyIssued(issuedBig.intValue());
				
				if(ppd.getQtyIssued()>=ppd.getTotal())
				{
					ppd.setItemStopStatus("c");
				}
							
				hbt.update(ppd);
				
				
		
			batchStock.setClosingStock(batchStock.getClosingStock().subtract(issuedBig));
			batchStock.setIssueQty((batchStock.getIssueQty()!=null?batchStock.getIssueQty():new BigDecimal(0.0)).add(issuedBig));
			hbt.update(batchStock);
			
			
			
			
			
		
			
			succesfullyAdded = true;
			tx.commit();
		} catch (HibernateException e) {
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();

		}

		return succesfullyAdded;
	}
	
	@SuppressWarnings( { "unchecked" })
	public boolean submitDietEntryDetails(Box box) {

		boolean succesfullyAdded = false;

		
		Transaction tx = null;
		Session session = (Session)getSession();
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			int counter = (box.getInt("counter")-1);			
			Inpatient inpatient = new Inpatient();
			System.out.println("box.parent"+box.getInt("id"));
			inpatient.setId(box.getInt("inpatientId"));
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			PatientDietIndoorDetail patientDietIndoorDetail = new PatientDietIndoorDetail();
			List<PatientDietIndoorDetail> patientDietIndoorDetailList = new ArrayList<PatientDietIndoorDetail>();
						
			
			String date = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTimeWithoutSc");
			patientDietIndoorDetailList = session.createCriteria(PatientDietIndoorDetail.class)
			.add(Restrictions.eq("EntryDate", new Date()))
			.add(Restrictions.eq("Inpatient.Id", box.getInt("inpatientId"))).list();
			
			if(patientDietIndoorDetailList.size()>0)
			{
				patientDietIndoorDetail = patientDietIndoorDetailList.get(0);
			}
			if(box.getString("breakfast"+counter)!=null && box.get("breakfast"+counter).trim().equals("breakfast"))
			{
				patientDietIndoorDetail.setMorningTeaBread("Y");
				patientDietIndoorDetail.setBreakfastTime(time);
			}
			
			if(box.getString("lunch"+counter)!=null && box.get("lunch"+counter).trim().equals("lunch"))
			{
				patientDietIndoorDetail.setLunch("Y");
				patientDietIndoorDetail.setLunchTime(time);
			}
			
			if(box.getString("dinner"+counter)!=null && box.get("dinner"+counter).trim().equals("dinner"))
			{
				patientDietIndoorDetail.setDinner("Y");
				patientDietIndoorDetail.setDinnerTime(time);
			}
			
			if(box.getString("remarks"+counter)!=null && !box.get("remarks"+counter).trim().equals(""))
			{
				patientDietIndoorDetail.setSpecialInst(box.get("remarks"+counter));
			}
			
			
			
			patientDietIndoorDetail.setLastChgDate(new Date());
			patientDietIndoorDetail.setEntryDate(new Date());
			patientDietIndoorDetail.setLastChgTime(time);
			patientDietIndoorDetail.setLastChgBy("jktuser");			
			patientDietIndoorDetail.setStatus("y");
			patientDietIndoorDetail.setInpatient(inpatient);
			hbt.saveOrUpdate(patientDietIndoorDetail);
			
			succesfullyAdded = true;
			tx.commit();
		} catch (HibernateException e) {
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();

		}

		return succesfullyAdded;
	}

	
	@SuppressWarnings( { "unchecked" })
	public boolean submitConsultaionEntryDetails(Box box) {

		boolean succesfullyAdded = false;

		
		Transaction tx = null;
		Session session = (Session)getSession();
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			int consultDoctorDtId = box.getInt("consultDoctorDtId");
			String consultationBYDoc = box.getString("consultationBYDoc");
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();			
			String time = (String) utilMap.get("currentTimeWithoutSc");
			PreAnesthesiaConsultDoctorDt consultDoctorDt = new PreAnesthesiaConsultDoctorDt();					
			consultDoctorDt = (PreAnesthesiaConsultDoctorDt)session.load(PreAnesthesiaConsultDoctorDt.class, consultDoctorDtId);
			consultDoctorDt.setDoctorAdvice(consultationBYDoc);
			consultDoctorDt.setConsultDate(new Date());
			consultDoctorDt.setConsultTime(time);
			consultDoctorDt.setStatus("C");		    
			hbt.update(consultDoctorDt);
			
			succesfullyAdded = true;
			tx.commit();
		} catch (HibernateException e) {
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();

		}

		return succesfullyAdded;
	}
	
	@SuppressWarnings( { "unchecked" })
	public boolean submitNursingCareEntryDetails(Map map) {

		boolean succesfullyAdded = false;

		List<String> careList = (List) map.get("careList");
		List<String> adNoList = (List) map.get("adNoList");
		List nursingCareSetupIdList = (List) map.get("nursingCareSetupIdList");
		List hinIdList = (List) map.get("hinIdList");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		Date dateToInsert = HMSUtil.convertStringTypeDateToDateType(date);
		List ipdcaredetailIdList = (List) map.get("ipdcaredetailIdList");
		List timeOfCareList = (List) map.get("timeOfCareList");
		List careRemarksList = (List) map.get("careRemarksList");
		List stopList = (List) map.get("stopList");
		Transaction tx = null;
		Session session = (Session)getSession();
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Iterator itr = careList.iterator();
			int i = 0;
			while (itr.hasNext()) {
				String care = (String) itr.next();
				if(!care.equals("")){
					if (care.equals("one")) {
						String userName = (String) map.get("userName");
						int hospitalId = (Integer) map.get("hospitalId");
						int deptId = (Integer) map.get("deptId");
						@SuppressWarnings("unused")
						String admissionNumber = adNoList.get(i);
						Ipdcaredetail ipdcaredetail = new Ipdcaredetail();
						ipdcaredetail.setAdNo(adNoList.get(i));
						MasDepartment masDepartment = new MasDepartment();
						masDepartment.setId(deptId);
						ipdcaredetail.setDepartment(masDepartment);
						MasHospital masHospital = new MasHospital();
						masHospital.setId(hospitalId);
						ipdcaredetail.setHospital(masHospital);
						Patient patient = new Patient();
						patient.setId((Integer) hinIdList.get(i));
						ipdcaredetail.setHin(patient);
						NursingcareSetup nursingcareSetup = new NursingcareSetup();
						nursingcareSetup.setId((Integer)nursingCareSetupIdList.get(i));
						ipdcaredetail.setNursingcareSetup(nursingcareSetup);
						ipdcaredetail.setCare1("y");
						ipdcaredetail.setDateOfCare(dateToInsert);
						ipdcaredetail.setCare1Time((String) timeOfCareList.get(i));
						ipdcaredetail.setLastChgBy(userName);
						ipdcaredetail.setLastChgDate(dateToInsert);
						ipdcaredetail.setLastChgTime(time);
						if (careRemarksList.get(i) != "") {
							ipdcaredetail.setRemarks((String) careRemarksList
									.get(i));
						} else {
							ipdcaredetail.setRemarks("");
						}
						hbt.save(ipdcaredetail);
					} else {
						String ipdcaredetailId = (String) ipdcaredetailIdList
						.get(i);
						int ipdId = Integer.parseInt(ipdcaredetailId);
						Ipdcaredetail ipdcaredetailObj = (Ipdcaredetail) hbt.load(
								Ipdcaredetail.class, ipdId);
						if (care.equals("two")) {
							ipdcaredetailObj.setCare2("y");
							ipdcaredetailObj.setCare2Time((String) timeOfCareList
									.get(i));
						}
						if (care.equals("three")) {
							ipdcaredetailObj.setCare3("y");
							ipdcaredetailObj.setCare3Time((String) timeOfCareList
									.get(i));
						}
						if (care.equals("four")) {
							ipdcaredetailObj.setCare4("y");
							ipdcaredetailObj.setCare4Time((String) timeOfCareList
									.get(i));
						}
						if (care.equals("five")) {
							ipdcaredetailObj.setCare5("y");
							ipdcaredetailObj.setCare5Time((String) timeOfCareList
									.get(i));
						}
						if (care.equals("six")) {
							ipdcaredetailObj.setCare6("y");
							ipdcaredetailObj.setCare6Time((String) timeOfCareList
									.get(i));
						}
						if (care.equals("seven")) {
							ipdcaredetailObj.setCare7("y");
							ipdcaredetailObj.setCare7Time((String) timeOfCareList
									.get(i));
						}
						if (care.equals("eight")) {
							ipdcaredetailObj.setCare8("y");
							ipdcaredetailObj.setCare8Time((String) timeOfCareList
									.get(i));
						}
						if (care.equals("nine")) {
							ipdcaredetailObj.setCare9("y");
							ipdcaredetailObj.setCare9Time((String) timeOfCareList
									.get(i));
						}
						if (care.equals("ten")) {
							ipdcaredetailObj.setCare10("y");
							ipdcaredetailObj.setCare10Time((String) timeOfCareList
									.get(i));
						}
						if (care.equals("eleven")) {
							ipdcaredetailObj.setCare11("y");
							ipdcaredetailObj.setCare11Time((String) timeOfCareList
									.get(i));
						}
						if (care.equals("twelve")) {
							ipdcaredetailObj.setCare12("y");
							ipdcaredetailObj.setCare12Time((String) timeOfCareList
									.get(i));
						}
						if (careRemarksList.get(i) != "") {
							ipdcaredetailObj.setRemarks((String) careRemarksList
									.get(i));
						} else {
							ipdcaredetailObj.setRemarks("");
						}
						hbt.update(ipdcaredetailObj);
					}
				}
				if (!stopList.get(i).equals("") && stopList.get(i).equals("y")) {
					NursingcareSetup nursingcareSetup = (NursingcareSetup)hbt.load(NursingcareSetup.class, (Integer)nursingCareSetupIdList.get(i));
					nursingcareSetup.setStop("y");
					hbt.update(nursingcareSetup);
				} 
				
				i++;
			}
			succesfullyAdded = true;
			tx.commit();
		} catch (HibernateException e) {
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();

		}

		return succesfullyAdded;
	}

	/*
	 * List of ward/department from master table
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> showWardList(String deptName, int deptId) {

		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		List ipIssueNo = new ArrayList();
		List issueNoList = new ArrayList();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		// int departmentTypeId=10;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			// deptList = session.createCriteria(MasDepartment.class).list();
			deptList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("DepartmentName", deptName)).list();
			// deptList=session.createQuery("select md from MasDepartment  as md where md.DepartmentName="+deptName).list();
			issueNoList = session.createQuery(
					"select sim from  StoreIpIssueM as sim where sim.Department.Id="
					+ deptId
					+ "and sim.IssueType='w' order by sim.Id desc")
					.list();
		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		map.put("deptList", deptList);
		map.put("issueNoList", issueNoList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showWardConsumptionJsp(Map map) {

		List listOfItemsInStock = new ArrayList();
		List ipIssueNo = new ArrayList();

		List issueNoList = new ArrayList();
		Session session = (Session) getSession();
		int deptId = (Integer) map.get("deptId");
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			// listOfItemsInStock =
			// session.createQuery("select sib,  sum(sib.ClosingStock) from StoreItemBatchStock as sib where sib.Department.Id="+deptId+
			// "group by sib.BatchNo,sib.CostPrice,sib.Brand.Id ").list();
			String ss= "from StoreFyDocumentNo as syd where syd.Department.Id="+deptId;
			Query q = session.createQuery(ss);
			ipIssueNo=q.list();
			// brandList =
			// session.createQuery("select Distinct(sib.Brand.Id),sib.Brand.BrandName from  StoreItemBatchStock as sib where sib.Department.Id="+deptId).list();
			String sss= "from StoreIpIssueM as sim where sim.IssueType='w'";
			Query qq = session.createQuery(sss);
			issueNoList=qq.list();
			if (map.get("buttonFlag") != null) {
				String issueNoOfWardFromJsp = (String) map.get("issueNoOfWard");
				int issueNoOfWard = Integer.parseInt(issueNoOfWardFromJsp);
				map.put("issueNoOfWard", issueNoOfWard);
			} else {

				if (ipIssueNo.size() > 0) {
					int issueNoOfWard;
					StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) ipIssueNo.get(0);
					if((storeFyDocumentNo.getIssueInPatientNo()) == null){
						issueNoOfWard=0;
					}else{
						issueNoOfWard = storeFyDocumentNo.getIssueInPatientNo();

					}
					issueNoOfWard = issueNoOfWard + 1;
					map.put("issueNoOfWard", issueNoOfWard);

				}
			}
			if (ipIssueNo.size() == 0) {
				StoreFyDocumentNo storeFyDocumentNo = new StoreFyDocumentNo();
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				storeFyDocumentNo.setDepartment(masDepartment);
				storeFyDocumentNo.setIssueWardNo(0);
				hbt.save(storeFyDocumentNo);
			}

		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		} 
		map.put("ipIssueNo", ipIssueNo);
		map.put("issueNoList", issueNoList);

		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> showStockDetailsJsp(Map map) {
		List listOfItemsInStock = new ArrayList();
		Session session = (Session) getSession();
		int deptId = (Integer) map.get("deptId");
		int itemId = (Integer) map.get("itemId");
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			@SuppressWarnings("unused")
			Criteria c = session.createCriteria(StoreFyDocumentNo.class).add(
					Restrictions.eq("Department.Id", deptId));
			listOfItemsInStock = session
			.createQuery(
					"select sum(sib.ClosingStock), sib.Item.Id,sib.Item.PvmsNo,sib.Item.Nomenclature,sib.Id," +
					"sib.BatchNo,sib.ExpiryDate,sib.CostPrice,sib.Brand.Id,sib.Brand.BrandName,sib.Item.ItemConversion.ItemUnitName" +
					" from StoreItemBatchStock as sib where sib.Department.Id="
					+ deptId
					+ " and sib.Item.Id="
					+ itemId
					+ "group by sib.Item.Id,sib.Item.PvmsNo,sib.Item.Nomenclature,sib.Id," +
			"sib.BatchNo,sib.ExpiryDate,sib.CostPrice,sib.Brand.Id,sib.Brand.BrandName,sib.Item.ItemConversion.ItemUnitName")
			.list();
		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		map.put("listOfItemsInStock", listOfItemsInStock);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean submitWardConsumptionDetails(Map map) {
		Session session = (Session) getSession();
		boolean succesfullyAdded = false;
		Date fromDateToInsert = null;
		// String issueType="w";
		List<String> pvmsList = (List) map.get("pvmsList");
		List<String> batchNumberList = (List) map.get("batchNumberList");
		List brandNameList = (List) map.get("brandNameList");
		List expiryDateList = (List) map.get("expiryDateList");
		List issQtyList = (List) map.get("issQtyList");
		List costPriceList = (List) map.get("costPriceList");
		List amountList = (List) map.get("amountList");
		List storeItemBatchStockIdList = (List) map
		.get("storeItemBatchStockIdList");
		String date = (String) map.get("date");
		int deptId = (Integer) map.get("deptId");
		int hospitalId = (Integer) map.get("hospitalId");
		String time = (String) map.get("time");
		String userName = (String) map.get("userName");
		int storeFyDocumentNoId = (Integer) map.get("storeFyDocumentNoId");
		int wardIssueNo = (Integer) map.get("wardIssueNo");
		if (map.get("fromDate") != "") {
			String fromDate = (String) map.get("fromDate");
			fromDateToInsert = HMSUtil
			.convertStringTypeDateToDateType(fromDate);

		}

		String toDate = (String) map.get("toDate");
		Date toDateInsert = HMSUtil.convertStringTypeDateToDateType(toDate);
		Date dateToInsert = HMSUtil.convertStringTypeDateToDateType(date);

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) hbt.load(
					StoreFyDocumentNo.class, storeFyDocumentNoId);
			StoreIpIssueM storeIpIssueM = null;
			int wardIssueNoFromDB = storeFyDocumentNo.getIssueWardNo();
			if (wardIssueNoFromDB != wardIssueNo) {
				storeFyDocumentNo.setIssueWardNo(wardIssueNo);
				hbt.update(storeFyDocumentNo);

				storeIpIssueM = new StoreIpIssueM();
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				storeIpIssueM.setDepartment(masDepartment);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				storeIpIssueM.setHospital(masHospital);
				storeIpIssueM.setIpIssueDate(dateToInsert);
				storeIpIssueM.setIssueType("w");
				storeIpIssueM.setIpIssueNo("" + wardIssueNo);
				storeIpIssueM.setFromdate(fromDateToInsert);
				storeIpIssueM.setTodate(toDateInsert);
				storeIpIssueM.setLastChgBy(userName);
				storeIpIssueM.setLastChgDate(dateToInsert);
				storeIpIssueM.setLastChgTime(time);
				hbt.save(storeIpIssueM);
			} else {
				List storeIpIssueMList = session.createQuery(
						"select sim from StoreIpIssueM as sim where sim.IpIssueNo="
						+ wardIssueNo + " and sim.IssueType='w'")
						.list();
				storeIpIssueM = (StoreIpIssueM) storeIpIssueMList.get(0);
			}
			// hbt.save(storeIpIssueM);
			// Iterator itr= issQtyList.iterator();
			int i = 0;
			for (int j = 0; i < issQtyList.size(); j++)
				// while(itr.hasNext())
			{

				BigDecimal totalQtyIssued;
				StoreIpIssueT storeIpIssueT = new StoreIpIssueT();
				storeIpIssueT.setIpIssue(storeIpIssueM);
				MasStoreItem masStoreItem = new MasStoreItem();
				masStoreItem
				.setId(Integer.parseInt(pvmsList.get(i).toString()));
				storeIpIssueT.setItem(masStoreItem);
				storeIpIssueT.setBatchNo(batchNumberList.get(i));
				MasStoreBrand masStoreBrand = new MasStoreBrand();
				masStoreBrand
				.setId(Integer.parseInt("" + brandNameList.get(i)));
				storeIpIssueT.setBrand(masStoreBrand);
				String expiryDate = (String) expiryDateList.get(i);

				Date expiryDateToInsert = HMSUtil
				.convertStringTypeDateToDateType(expiryDate);
				storeIpIssueT.setExpiryDate(expiryDateToInsert);
				BigDecimal issuedQtyFromJsp = new BigDecimal(""
						+ issQtyList.get(i));
				storeIpIssueT.setQtyIssued(issuedQtyFromJsp);
				BigDecimal bigDecimal2 = new BigDecimal(""
						+ costPriceList.get(i));
				storeIpIssueT.setRate(bigDecimal2);
				BigDecimal bigDecimal3 = new BigDecimal("" + amountList.get(i));
				storeIpIssueT.setAmount(bigDecimal3);
				// hbt.save(storeIpIssueT);

				int storeItemBatchStockId = Integer.parseInt(""
						+ storeItemBatchStockIdList.get(i));
				StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock) hbt
				.load(StoreItemBatchStock.class, storeItemBatchStockId);
				BigDecimal qtyIssued = (BigDecimal) storeItemBatchStock
				.getIssueQty();
				// //System.out.println("Quantity issued in submitWardConsumptionDetails===***********"+qtyIssued+"====value of issued quantity in list=== "+issuedQtyFromJsp);
				// BigDecimal issQty=(BigDecimal)issQtyList.get(i);
				if (qtyIssued != null) {
					totalQtyIssued = qtyIssued.add(issuedQtyFromJsp);
				} else {
					totalQtyIssued = issuedQtyFromJsp;
				}

				BigDecimal closingStock = (BigDecimal) storeItemBatchStock
				.getClosingStock();
				closingStock = closingStock.subtract(issuedQtyFromJsp);
				storeItemBatchStock.setIssueQty(totalQtyIssued);
				storeItemBatchStock.setClosingStock(closingStock);

				// hbt.save(storeIpIssueM);
				hbt.save(storeIpIssueT);
				hbt.update(storeItemBatchStock);

				i++;
			}

			succesfullyAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return succesfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> modifyWardConsumptionjsp(Map map) {
		Session session = (Session) getSession();
		int ipIssueNo = (Integer) map.get("ipIssueNo");
		List storeIpIssueMList = session.createQuery(
				"select sim from StoreIpIssueM as sim where sim.IpIssueNo="
				+ ipIssueNo).list();
		if (storeIpIssueMList.size() > 0) {
			StoreIpIssueM storeIpIssueM = (StoreIpIssueM) storeIpIssueMList
			.get(0);
			int storeIpIssueMId = storeIpIssueM.getId();
			List storeIpIssueTList = session.createQuery(
					"select sit from StoreIpIssueT as sit where sit.IpIssue.Id="
					+ storeIpIssueMId).list();
			map.put("storeIpIssueTList", storeIpIssueTList);
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteStockDetails(Map map) {

		BigDecimal totalQtyIssued;
		boolean sucessfullyDeleted = false;
		Session session = (Session) getSession();
		// int brandId=(Integer)map.get("brandId");
		int ipIssueTId = (Integer) map.get("ipIssueTId");

		// String batchNo=(String)map.get("batchNo");
		// BigDecimal costPrice= new BigDecimal(""+map.get("costPrice"));
		// BigDecimal qtyIssued= new BigDecimal(""+map.get("qtyIssued"));
		// int qtyIssued=(Integer)map.get("qtyIssued");

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			StoreIpIssueT storeIpIssueT = (StoreIpIssueT) hbt.load(
					StoreIpIssueT.class, ipIssueTId);
			int brandId = storeIpIssueT.getBrand().getId();
			String batchNo = storeIpIssueT.getBatchNo();
			BigDecimal costPrice = storeIpIssueT.getRate();
			BigDecimal qtyIssued = storeIpIssueT.getQtyIssued();

			String hql = "delete from StoreIpIssueT as sit where sit.Id like :ipIssueTId";
			Query query = session.createQuery(hql).setParameter("ipIssueTId",
					ipIssueTId);
			@SuppressWarnings("unused")
			int row = query.executeUpdate();

			List storeItemBatchStockList = session.createQuery(
					"select sib  from StoreItemBatchStock as sib where sib.BatchNo='"
					+ batchNo + "' and sib.Brand.Id=" + brandId
					+ "and sib.CostPrice=" + costPrice).list();
			StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock) storeItemBatchStockList
			.get(0);
			BigDecimal qtyIssuedFromDB = (BigDecimal) storeItemBatchStock
			.getIssueQty();
			if (qtyIssued != null) {
				totalQtyIssued = qtyIssuedFromDB.subtract(qtyIssued);
			} else {
				totalQtyIssued = qtyIssuedFromDB;
			}
			BigDecimal closingStock = (BigDecimal) storeItemBatchStock
			.getClosingStock();
			closingStock = closingStock.add(qtyIssued);

			storeItemBatchStock.setIssueQty(totalQtyIssued);
			storeItemBatchStock.setClosingStock(closingStock);
			hbt.update(storeItemBatchStock);

			sucessfullyDeleted = true;
		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return sucessfullyDeleted;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showPatientIssueJsp(Map map) {
		List listOfItemsInStock = new ArrayList();
		List ipIssueNo = new ArrayList();
		// List brandList=new ArrayList();
		List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
		Session session = (Session) getSession();
		int deptId = (Integer) map.get("deptId");
		int inPatientId = (Integer) map.get("inPatientId");
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			inPatientDetailList = session.createCriteria(Inpatient.class).add(
					Restrictions.eq("Id", inPatientId)).list();
			/*	listOfItemsInStock = session
					.createQuery(
							"select sib,  sum(sib.OpeningBalanceQty) from StoreItemBatchStock as sib where sib.Department.Id="
									+ deptId
									+ "group by rollup(sib) ")
					.list();*/
			ipIssueNo = session.createQuery(
					"select syd from StoreFyDocumentNo as syd where syd.Department.Id="
					+ deptId).list();
			// brandList =
			// session.createQuery("select Distinct(sib.Brand.Id),sib.Brand.BrandName from  StoreItemBatchStock as sib where sib.Department.Id="+deptId).list();

			/*
			 * Iterator iterator=listOfItemsInStock.iterator();
			 * while(iterator.hasNext()) { Object[] pair = (Object[])
			 * iterator.next(); StoreItemBatchStock storeItemBatchStock =
			 * (StoreItemBatchStock) pair[0]; BigDecimal qtyInHand =
			 * (BigDecimal) pair[1]; String
			 * pvmsNo=storeItemBatchStock.getItem().getPvmsNo();
			 * //System.out.println
			 * ("Batch number of the item====="+storeItemBatchStock
			 * .getBatchNo()+
			 * "  Quantity for the purticular item====="+qtyInHand); }
			 */
			if (map.get("buttonFlag") != null) {

				int issueNoOfPatient = (Integer) map.get("issueNoOfPatient");
				map.put("issueNoOfPatient", issueNoOfPatient);
			} else {
				if (ipIssueNo.size() > 0) {
					StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) ipIssueNo
					.get(0);
					int issueNoOfPatient = storeFyDocumentNo
					.getIssueInPatientNo();
					issueNoOfPatient = issueNoOfPatient + 1;
					map.put("issueNoOfPatient", issueNoOfPatient);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("listOfItemsInStock", listOfItemsInStock);
		map.put("ipIssueNo", ipIssueNo);
		// map.put("brandList", brandList);
		map.put("inPatientDetailList", inPatientDetailList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getItemList(Map map) {

		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		// List<StoreItemBatchStock> itemList1 = new
		// ArrayList<StoreItemBatchStock>();
		Session session = (Session) getSession();
		int deptId = 0;
		deptId = Integer.parseInt("" + map.get("deptId"));

		try {
			String str = map.get("autoHint") + "%";
			/*
			 * String qry=
			 * "SELECT DISTINCT BRAND_NAME,brand_id  FROM mas_store_brand m, store_item_batch_stock s"
			 * +
			 * "where  m.brand_id = s.brand_id and    m.brand_name like 'b%'and    s.department_id =1 and  s.closing_stock > 0"
			 * ;
			 */
			String query = "SELECT DISTINCT (sib.Item.Nomenclature),sib.Item.PvmsNo from  StoreItemBatchStock as sib where sib.Department.Id="
				+ deptId
				+ "  and  upper(sib.Item.Nomenclature) like upper('"
				+ str
				+ "')";
			// String query=
			// "SELECT DISTINCT (sib.Brand.BrandName),sib.Brand.Id from  StoreItemBatchStock as sib where sib.Department.Id="+deptId+" and  sib.Brand.BrandName like '"+str+"'";
			Query q = session.createQuery(query);
			q.setFirstResult(0);
			q.setMaxResults(10);
			itemList = q.list();
			// Criteria c = session.createCriteria(
			// StoreItemBatchStock.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
			// .createAlias("Brand", "brand")
			// .add(Restrictions.like("brand.BrandName",str));
			// .createAlias("Department", "dept")
			// .add(Restrictions.eq("dept.Id", deptId));
			//	  	  	
			// c.setFirstResult(0);
			// c.setMaxResults(10);
			// itemList = c.list();

			Iterator itr = itemList.iterator();
			while (itr.hasNext()) {
				Object[] pair = (Object[]) itr.next();
				String brandName = (String) pair[0];
			}

		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		map.put("itemList", itemList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> fillItemsInGrid(Map map) {

		// List<MasStoreBrand> itemList= new ArrayList<MasStoreBrand>();
		Session session = (Session) getSession();
		String pvmsNo = (String) map.get("fillItemsInGrid");
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		List objectList = new ArrayList();
		int deptId = 0;
		try {
			if (map.get("deptId") != null) {
				deptId = Integer.parseInt("" + map.get("deptId"));
			}
			String str = "" + map.get("pvmsNo");
			Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.eq("PvmsNo", str));
			itemList = c.list();
			map.put("itemList", itemList);
		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean submitPatientIssueDetails(Map map) {

		Session session = (Session) getSession();
		boolean succesfullyAdded = false;
		// String fromDateToDate= null;
		// List<String> pvmsList=(List)map.get("pvmsList");
		int itemId = (Integer) map.get("itemId");
		List<String> batchNumberList = (List) map.get("batchNumberList");
		List brandNameList = (List) map.get("brandNameList");
		List expiryDateList = (List) map.get("expiryDateList");
		List issQtyList = (List) map.get("issQtyList");
		List costPriceList = (List) map.get("costPriceList");
		List amountList = (List) map.get("amountList");
		List storeItemBatchStockIdList = (List) map
		.get("storeItemBatchStockIdList");
		String date = (String) map.get("date");
		int deptId = (Integer) map.get("deptId");
		int hospitalId = (Integer) map.get("hospitalId");
		String time = (String) map.get("time");
		String userName = (String) map.get("userName");
		int storeFyDocumentNoId = (Integer) map.get("storeFyDocumentNoId");
		int patientIssueNo = (Integer) map.get("patientIssueNo");
		int hinId = (Integer) map.get("hinId");
		String admissionNumber = (String) map.get("admissionNumber");
		Date dateToInsert = HMSUtil.convertStringTypeDateToDateType(date);
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			// if(storeFyDocumentNoId!=0)
			StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) hbt.load(
					StoreFyDocumentNo.class, storeFyDocumentNoId);
			StoreIpIssueM storeIpIssueM = null;
			int patientIssueNoFromDB = storeFyDocumentNo.getIssueInPatientNo();
			if (patientIssueNoFromDB != patientIssueNo) {
				storeFyDocumentNo.setIssueInPatientNo(patientIssueNo);
				hbt.update(storeFyDocumentNo);

				storeIpIssueM = new StoreIpIssueM();
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				storeIpIssueM.setDepartment(masDepartment);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				storeIpIssueM.setHospital(masHospital);
				storeIpIssueM.setIpIssueDate(dateToInsert);
				storeIpIssueM.setIssueType("p");
				storeIpIssueM.setIpIssueNo("" + patientIssueNo);
				storeIpIssueM.setAdNo(admissionNumber);
				Patient patient = new Patient();
				patient.setId(hinId);
				storeIpIssueM.setHin(patient);

				storeIpIssueM.setLastChgBy(userName);
				storeIpIssueM.setLastChgDate(dateToInsert);
				storeIpIssueM.setLastChgTime(time);
				hbt.save(storeIpIssueM);
			} else {
				List storeIpIssueMList = session.createQuery(
						"select sim from StoreIpIssueM as sim where sim.IpIssueNo="
						+ patientIssueNo + " and sim.IssueType='p'")
						.list();
				storeIpIssueM = (StoreIpIssueM) storeIpIssueMList.get(0);
			}
			int i = 0;
			for (int j = 0; i < issQtyList.size(); j++) {
				BigDecimal totalQtyIssued;
				StoreIpIssueT storeIpIssueT = new StoreIpIssueT();
				storeIpIssueT.setIpIssue(storeIpIssueM);
				MasStoreItem masStoreItem = new MasStoreItem();
				// masStoreItem.setId(Integer.parseInt(pvmsList.get(i)));
				masStoreItem.setId(itemId);
				storeIpIssueT.setItem(masStoreItem);
				storeIpIssueT.setBatchNo(batchNumberList.get(i));
				MasStoreBrand masStoreBrand = new MasStoreBrand();
				masStoreBrand
				.setId(Integer.parseInt("" + brandNameList.get(i)));
				storeIpIssueT.setBrand(masStoreBrand);
				String expiryDate = (String) expiryDateList.get(i);

				Date expiryDateToInsert = HMSUtil
				.convertStringTypeDateToDateType(expiryDate);
				storeIpIssueT.setExpiryDate(expiryDateToInsert);
				BigDecimal issuedQtyFromJsp = new BigDecimal(""
						+ issQtyList.get(i));
				storeIpIssueT.setQtyIssued(issuedQtyFromJsp);
				BigDecimal bigDecimal2 = new BigDecimal(""
						+ costPriceList.get(i));
				storeIpIssueT.setRate(bigDecimal2);
				BigDecimal bigDecimal3 = new BigDecimal("" + amountList.get(i));
				storeIpIssueT.setAmount(bigDecimal3);
				// hbt.save(storeIpIssueT);

				int storeItemBatchStockId = Integer.parseInt(""
						+ storeItemBatchStockIdList.get(i));
				StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock) hbt
				.load(StoreItemBatchStock.class, storeItemBatchStockId);
				BigDecimal qtyIssued = (BigDecimal) storeItemBatchStock
				.getIssueQty();
				// BigDecimal issQty=(BigDecimal)issQtyList.get(i);
				if (qtyIssued != null) {
					totalQtyIssued = qtyIssued.add(issuedQtyFromJsp);
				} else {
					totalQtyIssued = issuedQtyFromJsp;
				}

				BigDecimal closingStock = (BigDecimal) storeItemBatchStock
				.getClosingStock();
				closingStock = closingStock.subtract(issuedQtyFromJsp);
				storeItemBatchStock.setIssueQty(totalQtyIssued);
				storeItemBatchStock.setClosingStock(closingStock);
				// hbt.save(storeIpIssueM);
				hbt.save(storeIpIssueT);
				hbt.update(storeItemBatchStock);
				i++;
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

	public boolean submitWardConsumptionIssueDetails(Map<String, Object> map) {

		Session session = (Session) getSession();
		boolean succesfullyAdded = false;
		// String fromDateToDate= null;
		// List<String> pvmsList=(List)map.get("pvmsList");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();

		String currentDate = (String) utilMap.get("currentDate");
		int itemId = (Integer) map.get("itemId");
		List<String> batchNumberList = (List) map.get("batchNumberList");
		List brandNameList = (List) map.get("brandNameList");
		List expiryDateList = (List) map.get("expiryDateList");
		List issQtyList = (List) map.get("issQtyList");
		List costPriceList = (List) map.get("costPriceList");
		List amountList = (List) map.get("amountList");
		List storeItemBatchStockIdList = (List) map
		.get("storeItemBatchStockIdList");
		String date = (String) map.get("date");
		String fromDate = (String) map.get("fromDate");
		String toDate = (String) map.get("toDate");
		int deptId = (Integer) map.get("deptId");
		int hospitalId = (Integer) map.get("hospitalId");
		String time = (String) map.get("time");
		String userName = (String) map.get("userName");
		int storeFyDocumentNoId = 1;
		int patientIssueNo = 1;
		int patientIssueNoFromDB = 0;
		patientIssueNo = (Integer) map.get("patientIssueNo");
		int hinId = (Integer) map.get("hinId");
		String admissionNumber = (String) map.get("admissionNumber");
		Date dateToInsert = HMSUtil
		.convertStringTypeDateToDateType(currentDate);
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			// if(storeFyDocumentNoId!=0)
			StoreFyDocumentNo storeFyDocumentNo = null;
			List<StoreFyDocumentNo> storeFyList = new ArrayList<StoreFyDocumentNo>();
			storeFyList = session.createCriteria(StoreFyDocumentNo.class).add(
					Restrictions.eq("Department.Id", deptId)).list();
			if (storeFyList.size() > 0) {
				storeFyDocumentNo = (StoreFyDocumentNo) storeFyList.get(0);
			}
			StoreIpIssueM storeIpIssueM = null;
			if (storeFyDocumentNo.getIssueInPatientNo() != null) {
				patientIssueNoFromDB = storeFyDocumentNo.getIssueInPatientNo();
			}
			if (patientIssueNoFromDB != patientIssueNo) {

				storeIpIssueM = new StoreIpIssueM();
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				storeIpIssueM.setDepartment(masDepartment);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				storeIpIssueM.setHospital(masHospital);
				storeIpIssueM.setIpIssueDate(dateToInsert);
				storeIpIssueM.setIssueType("w");
				storeIpIssueM.setIpIssueNo("" + patientIssueNo);
				storeIpIssueM.setAdNo(admissionNumber);

				storeIpIssueM.setLastChgBy(userName);
				storeIpIssueM.setLastChgDate(dateToInsert);
				storeIpIssueM.setLastChgTime(time);
				storeIpIssueM.setFromdate(HMSUtil
						.convertStringTypeDateToDateType(fromDate));
				storeIpIssueM.setTodate(HMSUtil
						.convertStringTypeDateToDateType(toDate));
				hbt.save(storeIpIssueM);
				storeFyDocumentNo.setIssueInPatientNo(patientIssueNo);
				hbt.update(storeFyDocumentNo);
				hbt.refresh(storeFyDocumentNo);
			} else {
				List storeIpIssueMList = session.createQuery(
						"select sim from StoreIpIssueM as sim where sim.IpIssueNo="
						+ patientIssueNo + " and sim.IssueType='w'")
						.list();
				if (storeIpIssueMList.size() > 0) {
					storeIpIssueM = (StoreIpIssueM) storeIpIssueMList.get(0);
				}
			}
			// Iterator itr= issQtyList.iterator();
			int i = 0;
			if (storeIpIssueM != null) {
				for (int j = 0; i < issQtyList.size(); j++)

				{

					BigDecimal totalQtyIssued;
					StoreIpIssueT storeIpIssueT = new StoreIpIssueT();
					storeIpIssueT.setIpIssue(storeIpIssueM);
					MasStoreItem masStoreItem = new MasStoreItem();
					// masStoreItem.setId(Integer.parseInt(pvmsList.get(i)));
					masStoreItem.setId(itemId);
					storeIpIssueT.setItem(masStoreItem);
					storeIpIssueT.setBatchNo(batchNumberList.get(i));
					MasStoreBrand masStoreBrand = new MasStoreBrand();
					masStoreBrand.setId(Integer.parseInt(""
							+ brandNameList.get(i)));
					storeIpIssueT.setBrand(masStoreBrand);
					String expiryDate = (String) expiryDateList.get(i);

					Date expiryDateToInsert = HMSUtil
					.convertStringTypeDateToDateType(expiryDate);
					storeIpIssueT.setExpiryDate(expiryDateToInsert);
					BigDecimal issuedQtyFromJsp = new BigDecimal(""
							+ issQtyList.get(i));
					storeIpIssueT.setQtyIssued(issuedQtyFromJsp);
					BigDecimal bigDecimal2 = new BigDecimal(""
							+ costPriceList.get(i));
					storeIpIssueT.setRate(bigDecimal2);
					BigDecimal bigDecimal3 = new BigDecimal(""
							+ amountList.get(i));
					storeIpIssueT.setAmount(bigDecimal3);
					// hbt.save(storeIpIssueT);

					int storeItemBatchStockId = Integer.parseInt(""
							+ storeItemBatchStockIdList.get(i));
					StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock) hbt
					.load(StoreItemBatchStock.class,
							storeItemBatchStockId);
					BigDecimal qtyIssued = (BigDecimal) storeItemBatchStock
					.getIssueQty();
					// BigDecimal issQty=(BigDecimal)issQtyList.get(i);
					if (qtyIssued != null) {
						totalQtyIssued = qtyIssued.add(issuedQtyFromJsp);
					} else {
						totalQtyIssued = issuedQtyFromJsp;
					}

					BigDecimal closingStock = (BigDecimal) storeItemBatchStock
					.getClosingStock();
					closingStock = closingStock.subtract(issuedQtyFromJsp);
					storeItemBatchStock.setIssueQty(totalQtyIssued);
					storeItemBatchStock.setClosingStock(closingStock);

					// hbt.save(storeIpIssueM);
					hbt.save(storeIpIssueT);
					hbt.update(storeItemBatchStock);

					i++;
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

	@SuppressWarnings("unchecked")
	public Map<String, Object> viewPatientIssueDetails(Map map) {

		Session session = (Session) getSession();

		String admissionNumber = (String) map.get("admissionNumber");
		List<StoreIpIssueT> storeIpIssueTList = new ArrayList<StoreIpIssueT>();
		// List storeIpIssueMList =
		// session.createQuery("select sim from StoreIpIssueM as sim where sim.AdNo="+admissionNumber).list();
		List storeIpIssueMList = session.createCriteria(StoreIpIssueM.class)
		.add(Restrictions.eq("AdNo", admissionNumber)).list();
		Iterator itr = storeIpIssueMList.iterator();
		while (itr.hasNext())
			// if(storeIpIssueMList.size() > 0)
		{
			StoreIpIssueM storeIpIssueM = (StoreIpIssueM) itr.next();
			int storeIpIssueMId = storeIpIssueM.getId();
			List listOfValues = session.createQuery(
					"select sit from StoreIpIssueT as sit where sit.IpIssue.Id="
					+ storeIpIssueMId
					+ " order by sit.ExpiryDate desc  ").list();
			if (listOfValues.size() > 0) {
				Iterator listOfValuesItr = listOfValues.iterator();
				while (listOfValuesItr.hasNext()) {
					StoreIpIssueT storeIpIssueT = (StoreIpIssueT) listOfValuesItr
					.next();
					storeIpIssueTList.add(storeIpIssueT);
				}

			}
		}
		map.put("storeIpIssueTList", storeIpIssueTList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showPatientDiagnosisJsp(Map map) {
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
		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		} 
		map.put("inPatientDetailList", inPatientDetailList);
		map.put("icdNoList", icdNoList);
		map.put("disList", disList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getICDList(Map map) {

		List<MasIcd> itemList = new ArrayList<MasIcd>();
		Session session = (Session) getSession();
		@SuppressWarnings("unused")
		int deptId = 0;
		deptId = Integer.parseInt("" + map.get("deptId"));
		try {
			String str = "%" + map.get("autoHint") + "%";
			try {
				Criteria c = session.createCriteria(MasIcd.class).add(
						Restrictions.eq("Status", "y")).createAlias(
								"IcdSubCategory", "sub").add(
										Restrictions.or(Restrictions.like("IcdName", str),
												Restrictions
												.like("sub.IcdSubCategoryName", str)));
				c.setFirstResult(0);
				c.setMaxResults(40);
				itemList = c.list();
				if (itemList.size() == 0) {
					String query = "select icd from MasIcd as icd , MasIcdSubCategory as sub where sub.Id =icd.IcdSubCategory.Id and concat(sub.IcdSubCategoryName,':',icd.IcdName) like '"
						+ str + "'";
					Query q = session.createQuery(query);
					q.setFirstResult(0);
					q.setMaxResults(40);
					itemList = q.list();
				}
			}catch (HibernateException e){
				e.printStackTrace();
				session.close();
			} catch (Exception e) {
				e.printStackTrace();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean addPatientDiagnosisInformation(Map map) {
		boolean saved = false;
		List<DischargeIcdCode> icdCodeList = new ArrayList<DischargeIcdCode>();
		if (map.get("icdCodeList") != null) {
			icdCodeList = (List<DischargeIcdCode>) map.get("icdCodeList");
		}
		String[] icdIdArr = null;
		if (map.get("icdIdArr") != null) {
			icdIdArr = (String[]) map.get("icdIdArr");
		}
		@SuppressWarnings("unused")
		Inpatient inpatient = new Inpatient();
		@SuppressWarnings("unused")
		Session session = (Session) getSession();
		try {

			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			String query = "";
			List objectList = new ArrayList();
			if (icdCodeList.size() > 0) {
				for (int i = 0; i < icdCodeList.size(); i++) {
					DischargeIcdCode dischargeIcdCode = new DischargeIcdCode();
					dischargeIcdCode = (DischargeIcdCode) icdCodeList.get(i);
					MasIcd masIcd = new MasIcd();
					query = "select icd_id from mas_icd where icd_code='"
						+ icdIdArr[i] + "'";
					objectList = (List) session.createSQLQuery(query).list();
					masIcd.setId(Integer.parseInt("" + objectList.get(0)));
					dischargeIcdCode.setIcd(masIcd);
					hbt.save(dischargeIcdCode);
					hbt.refresh(dischargeIcdCode);
					saved = true;
				}
			}
		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return saved;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showSilDilJsp(Map map) {
		List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
		List<SilDilStatus> siList = new ArrayList<SilDilStatus>();
		List<MasIcd> icdNoList = new ArrayList<MasIcd>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<Users> userList = new ArrayList<Users>();
		List<UserEmpGroup> userRights = new ArrayList<UserEmpGroup>();
		Session session = (Session) getSession();
		Users user = null;
		int inPatientId = (Integer) map.get("inPatientId");
		if(map.get("user") != null){
			user = (Users) map.get("user");
		}
		int hospitalId = 0;
		if(map.get("hospitalId")!=null){
			hospitalId = (Integer)map.get("hospitalId");
		}
		try {
			inPatientDetailList = session.createCriteria(Inpatient.class).add(
					Restrictions.eq("Id", inPatientId)).list();
			// icdNoList=session.createCriteria(MasIcd.class).list();
			siList = session.createQuery("select sil from SilDilStatus as sil where sil.Inpatient.Id='"
					+ inPatientId + "' order by sil.Id desc").list();

			userList = session.createCriteria(Users.class).add(Restrictions.eq("Status", "y"))
					                          .createAlias("Employee", "emp").addOrder(Order.asc("emp.FirstName")).list();
			employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.asc("FirstName")).list();
			userRights = session.createCriteria(UserEmpGroup.class)
			.add(Restrictions.eq("Status", "y"))
			.add(Restrictions.eq("User.Id", user.getId()))
			.add(Restrictions.eq("EmpGroup.id", 1)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		}
		map.put("inPatientDetailList", inPatientDetailList);
		map.put("icdNoList", icdNoList);
		map.put("employeeList", employeeList);
		map.put("userList", userList);
		map.put("siList", siList);
		map.put("userRights", userRights);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean submitSilDilStatus(Map map) {
		boolean successfullyUpdated = false;
		int inpatientId = (Integer) map.get("inpatientId");
		//String icdCode = "" + map.get("icdCode");
		String patientCondition = (String) map.get("patientCondition");
		String conditionStatus = (String) map.get("conditionStatus");
		String date = (String) map.get("date");
		String silDilTime = (String) map.get("silDilTime");
		String nokType = (String) map.get("nokType");
		String sil_dil_remarks = "";
		int deptId = (Integer) map.get("deptId");
		int hinId = (Integer) map.get("hinId");
		String[] diagnosidIdArray = null;
		int placedBy = (Integer) map.get("placedBy");
		//String remarks = "";
		int multiIcdId = 0;
		String condition = "";
		if(map.get("condition") != null){
			condition = (String) map.get("condition");
		}

		String str = "";
		/*if (map.get("remarks")!= null) {
			remarks = (String) map.get("remarks");
		}*/
		String treatment = "";
		if (map.get("treatment") != null) {
			treatment = (String) map.get("treatment");
		}

		if (map.get("sil_dil_remarks") != null) {
			sil_dil_remarks = (String) map.get("sil_dil_remarks");
		}
		if (map.get("diagnosidIdArray") != null) {
			diagnosidIdArray = (String[]) map.get("diagnosidIdArray");
		}
		String time = (String) map.get("time");
		String userName = (String) map.get("userName");
		Date listDate = HMSUtil.convertStringTypeDateToDateType(date);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();

		String currentTime = (String) utilMap.get("currentTimeWithoutSc");
		List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
		Session session = (Session) getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			inPatientDetailList = session.createCriteria(Inpatient.class).add(
					Restrictions.eq("Id", inpatientId)).list();
			Inpatient inpatient = (Inpatient) inPatientDetailList.get(0);
			inpatient.setPatientCondition(patientCondition);
			inpatient.setConditionStatus(conditionStatus);
			inpatient.setListDate(listDate);
			inpatient.setListTime(silDilTime);
			hbt.update(inpatient);
			hbt.refresh(inpatient);
			String query = "";
			List objectList = new ArrayList();
			if (diagnosidIdArray != null) {
				for (int i = 0; i < diagnosidIdArray.length; i++) {
					if (diagnosidIdArray[i].equals("0")) {
						continue;
					}
					query = "select icd_id from mas_icd where icd_code='"
						+ diagnosidIdArray[i] + "'";
					objectList = (List) session.createSQLQuery(query).list();
					multiIcdId = (Integer.parseInt("" + objectList.get(0)));
					// ------Storing Multiple Diagnosis------------
					SilDilStatus silDilStatus = new SilDilStatus();
					Inpatient inpatientObj = new Inpatient();
					inpatientObj.setId(inpatientId);
					silDilStatus.setInpatient(inpatientObj);
					if (multiIcdId != 0) {
						MasIcd masIcd = new MasIcd();
						masIcd.setId(multiIcdId);
						silDilStatus.setIcd(masIcd);
					}
					silDilStatus.setConditionStatus(conditionStatus);
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(deptId);
					silDilStatus.setDepartment(masDepartment);
					silDilStatus.setTreatment(treatment);
					silDilStatus.setRemarks(condition);
					silDilStatus.setLastChgBy(userName);
					silDilStatus.setLastChgDate(listDate);
					silDilStatus.setLastChgTime(silDilTime);
					silDilStatus.setNok(nokType);
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(placedBy);
					silDilStatus.setPlacedBy(masEmployee);
					silDilStatus.setSil_dil_Remarks(sil_dil_remarks);
					hbt.save(silDilStatus);
					hbt.refresh(silDilStatus);
					DischargeIcdCode dischargeIcdCode = new DischargeIcdCode();

					Inpatient inpatient2 = new Inpatient();
					inpatient2.setId(inpatientId);
					dischargeIcdCode.setInpatient(inpatient);

					Patient patient = new Patient();
					patient.setId(hinId);
					dischargeIcdCode.setHin(patient);
					if (multiIcdId != 0) {
						MasIcd masIcd2 = new MasIcd();
						masIcd2.setId(multiIcdId);
						dischargeIcdCode.setIcd(masIcd2);
					}
					try {
						Users users =(Users)map.get("users");	
						System.out.println("usersid"+users.getId());
						dischargeIcdCode.setAddEditBy(users);
					} catch (Exception e) {
						e.printStackTrace();
					}
					dischargeIcdCode.setZ03("n");
					dischargeIcdCode.setZ09("n");
					dischargeIcdCode.setStatus("y");
					dischargeIcdCode.setDiagnosisStatus("p");
					dischargeIcdCode.setAddEditTime(time);
					dischargeIcdCode.setAddEditDate(listDate);
					hbt.save(dischargeIcdCode);
					hbt.refresh(dischargeIcdCode);

				}
			} else {

				SilDilStatus silDilStatus = new SilDilStatus();
				Inpatient inpatientObj = new Inpatient();
				inpatientObj.setId(inpatientId);
				silDilStatus.setInpatient(inpatientObj);
				/*try {
					if (!icdCode.equals("")) {
						query = "select icd_id from mas_icd where icd_code='"
								+ icdCode + "'";
						objectList = (List) session.createSQLQuery(query)
								.list();
						MasIcd masIcd = new MasIcd();
						masIcd.setId(Integer.parseInt("" + objectList.get(0)));
						silDilStatus.setIcd(masIcd);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}*/
				silDilStatus.setConditionStatus(conditionStatus);
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				silDilStatus.setDepartment(masDepartment);
				silDilStatus.setTreatment(treatment);
				silDilStatus.setRemarks(condition);
				silDilStatus.setLastChgBy(userName);
				silDilStatus.setLastChgDate(listDate);
				silDilStatus.setLastChgTime(silDilTime);
				silDilStatus.setNok(nokType);
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(placedBy);
				silDilStatus.setPlacedBy(masEmployee);
				silDilStatus.setSil_dil_Remarks(sil_dil_remarks);
				hbt.save(silDilStatus);
				hbt.refresh(silDilStatus);
				DischargeIcdCode dischargeIcdCode = new DischargeIcdCode();

				Inpatient inpatient2 = new Inpatient();
				inpatient2.setId(inpatientId);
				dischargeIcdCode.setInpatient(inpatient);

				Patient patient = new Patient();
				patient.setId(hinId);
				dischargeIcdCode.setHin(patient);
				/*try {
					if (!icdCode.equals("")) {
						query = "select icd_id from mas_icd where icd_code='"
								+ icdCode + "'";
						objectList = (List) session.createSQLQuery(query)
								.list();
						MasIcd masIcd2 = new MasIcd();
						masIcd2.setId(Integer.parseInt("" + objectList.get(0)));
						dischargeIcdCode.setIcd(masIcd2);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}*/
				Users users =(Users)map.get("users");
				System.out.println("usersid"+users.getId());
				dischargeIcdCode.setAddEditBy(users);
				dischargeIcdCode.setZ03("n");
				dischargeIcdCode.setZ09("n");
				dischargeIcdCode.setStatus("y");
				dischargeIcdCode.setDiagnosisStatus("p");
				dischargeIcdCode.setAddEditTime(time);
				dischargeIcdCode.setAddEditDate(listDate);
				hbt.save(dischargeIcdCode);
				hbt.refresh(dischargeIcdCode);
			}
			successfullyUpdated = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();

			e.printStackTrace();
		}

		return successfullyUpdated;
	}

	// -------------------------------Nursing Clinical
	// Chart-------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showNursingClinicalChartJsp(int departmentId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		inpatientList = getHibernateTemplate()
		.find(
				"from jkt.hms.masters.business.Inpatient as ip where ip.AdStatus = 'A' and ip.Department.Id="
				+ departmentId);
		/*	
		Session session = (Session)getSession();
		List<IpdIntakeOutputChart> searchIpdClinicalChartList = new ArrayList<IpdIntakeOutputChart>();
		List<IpdTemperature> ipdTempList = new ArrayList<IpdTemperature>();
		List<IpdTemperature> ipdTemperatureList = new ArrayList<IpdTemperature>();
		try {
			Date currentDate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			String date = sdf.format(currentDate);
			searchIpdClinicalChartList = session.createCriteria(IpdIntakeOutputChart.class).list();
			if(searchIpdClinicalChartList.size() > 0){
					for (IpdIntakeOutputChart ipChart : searchIpdClinicalChartList) {
							ipdTemperatureList = session.createCriteria(IpdTemperature.class).createAlias("Intakeoutput", "io").add(Restrictions.eq("io.Id", ipChart.getId())).add(Restrictions.eq("IpdDate", currentDate)).setMaxResults(1).list();
							if(ipdTemperatureList.size() > 0)
								ipdTempList.add(ipdTemperatureList.get(0));

				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("ipdTempList", ipdTempList);*/
		map.put("inpatientList", inpatientList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean addNursingClinicalChart(Map<String, Object> dataMap) {
		boolean successfullyAdded = false;
		@SuppressWarnings("unused")
		List<Object> intakeList = new ArrayList<Object>();
		@SuppressWarnings("unused")
		List tempList = new ArrayList();
		if (dataMap.get("intakeList") != null) {
			intakeList = (List) dataMap.get("intakeList");
		}
		if (dataMap.get("tempList") != null) {
			tempList = (List) dataMap.get("tempList");
		}
		Box box = (Box)dataMap.get("box");
		int deptId = 0;
		if(dataMap.get("deptId")!=null){
			deptId=(Integer)dataMap.get("deptId");
		}
		int hospitalId = 0;
		if(dataMap.get("hospitalId")!=null){
			hospitalId=(Integer)dataMap.get("hospitalId");
		}
		String userName = "";
		if(dataMap.get("userName")!=null){
			userName = (String)dataMap.get("userName");
		}
		Session session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		Transaction transaction = null;
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String lastChgDate = (String) utilMap.get("currentDate");
		String lastChgTime = (String) utilMap.get("currentTimeWithoutSc");
		String currentDate = (String) utilMap.get("currentDate");
		int counter = box.getInt("counter");

		try {
			transaction = session.beginTransaction();
			List<Integer> objectList = new ArrayList<Integer>();
			
			/*String qry = "SELECT intakeoutput_id FROM ipd_intake_output_chart where ad_no='"
				+ box.getString(AD_NO) + "'";
				objectList = (List) session.createSQLQuery(qry).list();*/
			
			objectList  = session.createCriteria(IpdIntakeOutputChart.class).add(Restrictions.eq("AdNo", box.getString(AD_NO) ))
							.setProjection(Projections.property("Id")).list();
			
			IpdIntakeOutputChart ipdIntakeOutputChart = new IpdIntakeOutputChart();
			if (objectList.size() == 0) {
				ipdIntakeOutputChart
				.setDepartment(new MasDepartment(deptId));
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				ipdIntakeOutputChart.setHospital(masHospital);
				Patient patientObj = new Patient();
				patientObj.setId(box.getInt(HIN_ID));
				ipdIntakeOutputChart.setHin(patientObj);
				Inpatient inpatient = new Inpatient();
				inpatient.setId(box.getInt(INPATIENT_ID));
				ipdIntakeOutputChart.setInpatient(inpatient);

				ipdIntakeOutputChart.setAdNo(box.getString(AD_NO));
				ipdIntakeOutputChart.setLastChgBy(userName);
				ipdIntakeOutputChart.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(lastChgDate));
				ipdIntakeOutputChart.setLastChgTime(lastChgTime);
				ipdIntakeOutputChart.setIntakeDate(HMSUtil
						.convertStringTypeDateToDateType(lastChgDate));
				ipdIntakeOutputChart.setTime(box.getString(CHANGED_TIME));
				ipdIntakeOutputChart.setTreatment("");
				ipdIntakeOutputChart.setIntakeDate(HMSUtil
						.convertStringTypeDateToDateType(currentDate));
				
				hbt.save(ipdIntakeOutputChart);
			}else{
				ipdIntakeOutputChart.setId(Integer.parseInt(objectList.get(0).toString()));
			}
			
			
			if(counter > 0){
				for(int i=1;i<=counter;i++){
					if(box.getInt("ipdTemperatureId"+i)==0){
						IpdTemperature ipdTemperature = new IpdTemperature();
						ipdTemperature.setIpdDate(HMSUtil
								.convertStringTypeDateToDateType(box.getString("ipdDate"+i)));
						ipdTemperature.setTemperature(box.getFloat(TEMPERATURE+i));
						try {
							ipdTemperature.setPulse(box.getInt(PULSE+i));
						} catch (Exception e) {
							ipdTemperature.setPulse(0);
						}
						try {
							ipdTemperature.setRespiration(box.getInt(RESPIRATION+i));
						} catch (Exception e) {
							ipdTemperature.setRespiration(0);
						}
						try {
							ipdTemperature.setBp(box.getString(BP+i));
						} catch (Exception e) {
							ipdTemperature.setBp("");
						}
						// ---New Fields Added
						try {
							if (!box.getString(BOWEL+i).equals(""))
								ipdTemperature.setBowel(box.getString(BOWEL+i));
						} catch (Exception e) {
							ipdTemperature.setBowel("");
						}
						try {
							if (!box.getString("o2Saturation"+i).equals(""))
								ipdTemperature.setO2Saturation(box.getString("o2Saturation"+i));
						} catch (Exception e) {
							ipdTemperature.setO2Saturation("");
						}
						try {
							if (!box.getString(PAIN+i).equals("emptyString"))
								ipdTemperature.setPain(box.getString(PAIN+i));
						} catch (Exception e) {
							ipdTemperature.setPain("");
						}

						try {
							ipdTemperature.setTime(box.getString(CHANGED_TIME+i));
						} catch (Exception e) {
							ipdTemperature.setTime("");
						}

						ipdTemperature.setLastChgBy(userName);
						ipdTemperature.setLastChgDate(HMSUtil
								.convertStringTypeDateToDateType(lastChgDate));
						ipdTemperature.setLastChgTime(lastChgTime);

						ipdTemperature.setIntakeoutput(ipdIntakeOutputChart);
                        ipdTemperature.setDepartment(new MasDepartment(deptId));
						hbt.save(ipdTemperature);
					}else{
						IpdTemperature ipdTemperature = (IpdTemperature)hbt.load(IpdTemperature.class, box.getInt("ipdTemperatureId"+i));
						ipdTemperature.setTime(box.getString(CHANGED_TIME+i));
						ipdTemperature.setDepartment(new MasDepartment(deptId));
						hbt.update(ipdTemperature);
					}
				}
			}
			transaction.commit();
			successfullyAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();

		}
		
		/*try {
			transaction = session.beginTransaction();
			if (intakeList.size() > 0) {
				for (int i = 0; i < intakeList.size(); i++) {
					IpdIntakeOutputChart ipdIntakeOutputChart = (IpdIntakeOutputChart) intakeList
					.get(i);
					IpdTemperature ipdTemperature = (IpdTemperature) tempList
					.get(i);
					String qry = "SELECT intakeoutput_id FROM ipd_intake_output_chart where ad_no='"
						+ ipdIntakeOutputChart.getAdNo() + "'";
					List objectList = new ArrayList();
					objectList = (List) session.createSQLQuery(qry).list();
					if (objectList.size() > 0) {
						ipdTemperature
						.setIntakeoutput(new IpdIntakeOutputChart(
								Integer
								.parseInt(""
										+ objectList.get(0))));
						hbt.save(ipdTemperature);
					} else {
						hbt.save(ipdIntakeOutputChart);
						ipdTemperature.setIntakeoutput(ipdIntakeOutputChart);
						hbt.save(ipdTemperature);
					}
				}

			}
			transaction.commit();
			successfullyAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();

		}*/

		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map getViewClinicalChart(Map<String, Object> dataMap) {
		String radio_str = "";
		int deptId = 0;
		String deptName = "";
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();

		if (dataMap.get("radio_str") != null) {
			radio_str = "" + dataMap.get("radio_str");
		}
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		deptList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Id", deptId)).list();
		for (MasDepartment department : deptList) {
			deptName = "" + department.getDepartmentName();
		}
		Map map = new HashMap();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<IpdTemperature> ipdTemperatureList = new ArrayList<IpdTemperature>();
		List<IpdIntakeOutputChart> ipdIntakeOutputChartList = new ArrayList<IpdIntakeOutputChart>();

		inpatientList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.Inpatient as ip where ip.AdNo = '"
				+ radio_str + "'");
		ipdIntakeOutputChartList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.IpdIntakeOutputChart as md where md.AdNo = '"
				+ radio_str + "'  ");

		int intakeId = 0;
		for (IpdIntakeOutputChart ipdIntakeOutputChart : ipdIntakeOutputChartList) {
			intakeId = Integer.parseInt("" + ipdIntakeOutputChart.getId());
		}
		ipdTemperatureList = getHibernateTemplate()
		.find(
				"from jkt.hms.masters.business.IpdTemperature as md where md.Intakeoutput.Id = '"
				+ intakeId + "' order by md.Id desc ");
		map.put("inpatientList", inpatientList);
		map.put("ipdTemperatureList", ipdTemperatureList);
		map.put("ipdIntakeOutputChartList", ipdIntakeOutputChartList);
		map.put("deptName", deptName);
		return map;
	}

	// ---------------------------------Intake/Output
	// Chart----------------------------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showIntakeOutputJsp(int inPatient) {

		String admissionNumber = null;
		List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
		List<IpdIntakeOutputChart> intakeOutputList = new ArrayList<IpdIntakeOutputChart>();
		List<IpdIntake> intakeList = new ArrayList<IpdIntake>();
		List<IpdOutput> outputList = new ArrayList<IpdOutput>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String hinNo = "";
		try {
			inPatientDetailList = session.createCriteria(Inpatient.class).add(
					Restrictions.eq("Id", inPatient)).list();

			if (inPatientDetailList != null) {
				Inpatient inpatient = (Inpatient) inPatientDetailList.get(0);
				admissionNumber = inpatient.getAdNo();
				hinNo = ("" + inpatient.getHinNo());
			}
			/*intakeOutputList = session.createCriteria(IpdIntakeOutput.class)
					.add(Restrictions.eq("AdNo", admissionNumber)).list();*/
			/*intakeOutputList = session.createCriteria(IpdIntakeOutputChart.class).createAlias("Inpatient", "ip").add(
					Restrictions.eq("ip.Id", inPatient)).list();
			 */
			intakeList = session.createCriteria(IpdIntake.class).createAlias("Intakeoutput", "io").createAlias("io.Inpatient", "ip").add(
					Restrictions.eq("ip.Id", inPatient)).list();

			outputList = session.createCriteria(IpdOutput.class).createAlias("Intakeoutput", "io").createAlias("io.Inpatient", "ip").add(
					Restrictions.eq("ip.Id", inPatient)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		}
		map.put("intakeOutputList", intakeOutputList);
		map.put("inPatientDetailList", inPatientDetailList);
		map.put("intakeList", intakeList);
		map.put("outputList", outputList);
		map.put("hinNo", hinNo);
		return map;
	}

	public boolean addIntakeOutput(Map<String, Object> map) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		List ipdTemperatureObjList = new ArrayList();
		List ipdIntakeObjList = new ArrayList();
		List ipdOutputObjList = new ArrayList();
		IpdIntakeOutputChart ipdIntakeOutputChart = new IpdIntakeOutputChart();
		String admissionNumber = (String) map.get("admissionNumber");

		if (map.get("ipdTemperatureObjList") != null) {
			ipdTemperatureObjList = (List) map.get("ipdTemperatureObjList");
		}
		if (map.get("ipdIntakeObjList") != null) {
			ipdIntakeObjList = (List) map.get("ipdIntakeObjList");
		}

		if (map.get("ipdOutputObjList") != null) {
			ipdOutputObjList = (List) map.get("ipdOutputObjList");
		}

		if (map.get("ipdIntakeOutputChart") != null) {
			ipdIntakeOutputChart = (IpdIntakeOutputChart) map
			.get("ipdIntakeOutputChart");
		}

		int id = 0;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			List<IpdIntakeOutputChart> ipdIntakeOutputChartList = new ArrayList<IpdIntakeOutputChart>();
			ipdIntakeOutputChartList = hbt
			.find("from jkt.hms.masters.business.IpdIntakeOutputChart as inp where inp.AdNo = '"
					+ admissionNumber + "'");
			IpdIntakeOutputChart ipdChart = null;
			if (ipdIntakeOutputChartList.size() > 0) {
				ipdChart = (IpdIntakeOutputChart) hbt.load(
						IpdIntakeOutputChart.class, ipdIntakeOutputChartList
						.get(0).getId());
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				id = ipdChart.getId();
				ipdChart.setTreatment(ipdIntakeOutputChart.getTreatment());
				ipdChart.setIntakeDate(ipdIntakeOutputChart.getIntakeDate());
				ipdChart.setTime(ipdIntakeOutputChart.getTime());
				hbt.update(ipdChart);

			} else {
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.save(ipdIntakeOutputChart);
				id = ipdIntakeOutputChart.getId();
			}

			if (ipdTemperatureObjList.size() > 0) {
				for (int i = 0; i < ipdTemperatureObjList.size(); i++) {
					IpdTemperature ipdTemperature = new IpdTemperature();
					ipdTemperature = (IpdTemperature) ipdTemperatureObjList
					.get(i);
					IpdIntakeOutputChart ipdIntakeOutputChart1 = new IpdIntakeOutputChart();
					ipdIntakeOutputChart1.setId(id);
					ipdTemperature.setIntakeoutput(ipdIntakeOutputChart1);
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.save(ipdTemperature);
				}
			}

			if (ipdIntakeObjList.size() > 0) {
				for (int i = 0; i < ipdIntakeObjList.size(); i++) {
					IpdIntake ipdIntake = new IpdIntake();
					ipdIntake = (IpdIntake) ipdIntakeObjList.get(i);
					IpdIntakeOutputChart ipdIntakeOutputChart2 = new IpdIntakeOutputChart();
					ipdIntakeOutputChart2.setId(id);
					ipdIntake.setIntakeoutput(ipdIntakeOutputChart2);
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.save(ipdIntake);
				}
			}
			if (ipdOutputObjList.size() > 0) {
				for (int i = 0; i < ipdOutputObjList.size(); i++) {
					IpdOutput ipdOutput = new IpdOutput();
					ipdOutput = (IpdOutput) ipdOutputObjList.get(i);
					IpdIntakeOutputChart ipdIntakeOutputChart3 = new IpdIntakeOutputChart();
					ipdIntakeOutputChart3.setId(id);
					ipdOutput.setIntakeoutput(ipdIntakeOutputChart3);
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.save(ipdOutput);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		successfullyAdded = true;

		return successfullyAdded;
	}

	// ---------------------------------IntakeOutputChartReport---------------------------------

	public Map<String, Object> showIntakeOutputChartReport(
			Map<String, Object> requestParameters) {
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			int hospital_id = (Integer) requestParameters.get(HOSPITAL_ID);
			hospitalList = session.createCriteria(MasHospital.class).add(
					Restrictions.eq("Id", hospital_id)).list();
			Set<Patient> patientSet = (Set) hospitalList.get(0).getPatients();
			for (Iterator iter = patientSet.iterator(); iter.hasNext();) {
				Patient patient = (Patient) iter.next();
				if (requestParameters.get(HIN_NO).toString().equalsIgnoreCase(
						patient.getHinNo())) {
					Set<IpdIntakeOutput> intakeOutputSet = (Set) patient
					.getIpdIntakeOutputs();
					map.put("patientName", patient.getTitle() + " "
							+ patient.getPFirstName() + " "
							+ patient.getPMiddleName() + " "
							+ patient.getPLastName());
					map.put("serviceNo", patient.getServiceNo());

					try {
						map.put("rank", patient.getRank().getRankName());
					} catch (Exception e) {
						map.put("rank", "-");
					}
					map.put("servicePersonName", patient.getTitle() + " "
							+ patient.getSFirstName() + " "
							+ patient.getSMiddleName() + " "
							+ patient.getSLastName());
					try {
						map.put("unit", patient.getUnit().getUnitName());
					} catch (Exception e) {
						map.put("unit", "-");
					}

					Set<Inpatient> inpatientSet = (Set) patient.getInpatients();
					for (Iterator iterator = inpatientSet.iterator(); iterator
					.hasNext();) {
						Inpatient inpatient = (Inpatient) iterator.next();
						if (requestParameters.get(ADMISSION_NUMBER).toString()
								.equalsIgnoreCase(inpatient.getAdNo())) {
							if (inpatient.getDischargeDate() != null)
								map.put("doa", inpatient.getDateOfAddmission()
										.toString());
							else
								map.put("doa", " ");

							map.put("age", inpatient.getAge());
						}
					}
				} // end of if block (hinNo checking)
			} // end of patientSet iterator loop
		} // end of try block
		catch (HibernateException e) {
			e.printStackTrace();
		}
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}

	// ------------------------------Method For Admission
	// Number---------------------------
	public Map<String, Object> getAdmissionNumberList(
			Map<String, Object> requestParameters) {
		//		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String department = null;
		boolean hinNoFound = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			int hospital_id = (Integer) requestParameters.get(HOSPITAL_ID);
			String serviceNo = "";
			if (requestParameters.get(SERVICE_NO) != null){
				serviceNo = (String)requestParameters.get(SERVICE_NO);
			}
			if(!serviceNo.equals("")){
				/*	patientList = getHibernateTemplate().find("from Patient  p where p.ServiceNo = '"
								+ serviceNo + "'");
			if(patientList.size() > 0){
				for(Patient patient : patientList){
					Set<Inpatient> inpatientSet = (Set) patient.getInpatients();
					if (inpatientSet != null && inpatientSet.size() > 0) {
						for (Iterator iterator = inpatientSet.iterator(); iterator
								.hasNext();) {
							Inpatient inpatient = (Inpatient) iterator
									.next();
							try {
								department = inpatient.getDepartment()
										.getDepartmentName();
								break;
							} catch (Exception e) {
								department = "";
							}
						}
					}
					map.put("department", department);
					map.put("inpatientSet", inpatientSet);

					}
				}*/
				/*inpatientList = getHibernateTemplate().find("from Inpatient ip join ip.Hin p where p.ServiceNo = '"
						+ serviceNo + "' and ip.AdStatus='A'");*/
				inpatientList = session.createCriteria(Inpatient.class).createAlias("Hin", "h").add(Restrictions.eq("h.ServiceNo", serviceNo)).add(Restrictions.eq("AdStatus", "A")).list();
			}
			/*hospitalList = session.createCriteria(MasHospital.class).add(
					Restrictions.eq("Id", hospital_id)).list();
			Set<Patient> patientSet = null;
			System.out.println("hospitalList--- "+hospitalList.size());
			if (hospitalList != null && hospitalList.size() > 0)
				patientSet = (Set) hospitalList.get(0).getPatients();
			for (Iterator iter = patientSet.iterator(); iter.hasNext();) {
				Patient patient = (Patient) iter.next();
				System.out.println("requestParameters.get(SERVICE_NO)------- "+requestParameters.get(SERVICE_NO));
				if (requestParameters.get(SERVICE_NO) != null)
					if (requestParameters.get(SERVICE_NO).toString().trim()
							.equalsIgnoreCase(patient.getServiceNo())) {
						hinNoFound = true;
						Set<Inpatient> inpatientSet = (Set) patient
								.getInpatients();
						System.out.println("inpatientSet---- "+inpatientSet.size());
						// Get the department/ward
						if (inpatientSet != null && inpatientSet.size() > 0) {
							for (Iterator iterator = inpatientSet.iterator(); iterator
									.hasNext();) {
								Inpatient inpatient = (Inpatient) iterator
										.next();
								try {
									department = inpatient.getDepartment()
											.getDepartmentName();
									break;
								} catch (Exception e) {
									department = "";
								}
							}
						}
						map.put("department", department);
						map.put("inpatientSet", inpatientSet);
					}
			}*/
			map.put("inpatientList", inpatientList);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		}
		map.put("hinNoFound", hinNoFound);
		return map;
	}

	// --------------------------------Food tasting
	// Report-------------------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showFoodTastingReportJsp() {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> showList = new ArrayList<Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		try {
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		}
		java.sql.Connection con = session.connection();
		map.put("departmentList", departmentList);
		map.put("con", con);
		return map;
	}

	@SuppressWarnings( { "deprecation", "unchecked" })
	public Map<String, Object> showNursingCareReportJsp(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		int patientId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasNursingCare> nursingCareList = new ArrayList<MasNursingCare>();
		if (dataMap.get("patientId") != null) {
			patientId = Integer.parseInt("" + dataMap.get("patientId"));
		}
		try {

			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("DepartmentName")).list();
			nursingCareList = session.createCriteria(MasNursingCare.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("NursingName")).list();
			if (patientId > 0) {
				patientList = session.createCriteria(Patient.class).add(
						Restrictions.eq("Id", patientId)).list();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		}
		java.sql.Connection con = session.connection();
		map.put("patientList", patientList);
		map.put("departmentList", departmentList);
		map.put("nursingCareList", nursingCareList);
		map.put("con", con);
		return map;
	}

	// -------------------------Discharge
	// Slip-------------------------------------
	@SuppressWarnings("unchecked")
	public List getAdmissionNoList(Map<String, Object> detailsMap) {
		String serviceNo = "";
		String hinNo = "";
		if (detailsMap.get("serviceNo") != null) {
			serviceNo = (String) detailsMap.get("serviceNo");
		}
		if (detailsMap.get("hinNo") != null) {
			hinNo = (String) detailsMap.get("hinNo");
		}
		List<Object> inpatientList = new ArrayList<Object>();
		Session session = (Session) getSession();
		try {
			/*
			 * Code Changed By Mukesh as Named Parameter
			 * Date 15 Aug 2012
			 */
			if (!serviceNo.equals("")) {
				/*inpatientList = getHibernateTemplate().find(
						"from Inpatient ip join ip.Hin as p where p.ServiceNo = '"
						+ serviceNo + "'");*/
				Query inpatientQry = session.createQuery("from Inpatient ip join ip.Hin as p where p.ServiceNo =:serviceNo");
				inpatientQry.setString("serviceNo",serviceNo);
				inpatientList = inpatientQry.list();
			}
			if (!hinNo.equals("")) {
				/*inpatientList = getHibernateTemplate().find(
						"from Inpatient ip join ip.Hin as p where p.HinNo = '"
						+ hinNo + "'");*/
				Query inpatientQry = session.createQuery("from Inpatient ip join ip.Hin as p where p.HinNo = =:hinNo");
				inpatientQry.setString("hinNo",hinNo);
				inpatientList = inpatientQry.list();
			}
			// inpatientList =
			// session.createCriteria(Inpatient.class).createAlias("Hin",
			// "p").add(Restrictions.eq("p.ServiceNo", serviceNo)).list();

		} catch (HibernateException e) {
			e.printStackTrace();

		}
		return inpatientList;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getHinNoList(String serviceNo) {
		Session session = (Session) getSession();
		List<Object> patientList = new ArrayList<Object>();

		try {
			patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("ServiceNo", serviceNo)).list();


		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		}
		return patientList;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getSearchPatientComboDetails(
			Map<String, Object> requestParameters) {
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
				patientList = hbt.find(queryString);
			}
		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		map.put("masServiceTypeList", masServiceTypeList);
		map.put("masUnitList", masUnitList);
		map.put("masRankList", masRankList);
		map.put("patientList", patientList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public String getMothersName(String motherHinNo) {
		List<Patient> list = new ArrayList<Patient>();
		String motherName = "";
		Session session = (Session) getSession();
		try {
			list = session.createCriteria(Patient.class).add(
					Restrictions.eq("HinNo", motherHinNo)).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.close();
		}
		if (list.size() > 0) {
			Patient patient = list.get(0);
			motherName = patient.getPFirstName() +" "+(patient.getPMiddleName()!=null?patient.getPMiddleName():"" )+ " " + (patient.getPLastName()!=null?patient.getPLastName():"");
		}
		return motherName;
	}

	public List<Object> getHinNo(String serviceNo) {
		Session session = (Session) getSession();
		List<Object> patientList = new ArrayList<Object>();

		try {
			if (!serviceNo.equals("")) {
				patientList = session.createCriteria(Patient.class).add(
						Restrictions.eq("ServiceNo", serviceNo)).add(
								Restrictions.not(Restrictions.eq("PatientStatus",
								"Expired"))).list();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		}
		return patientList;
	}

	public Map getViewIntakeOutput(String radio_str) {
		Map map = new HashMap();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<IpdIntakeOutputChart> ipdIntakeOutputList = new ArrayList<IpdIntakeOutputChart>();
		inpatientList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.Inpatient as ip where ip.AdNo = '"
				+ radio_str + "' order by ip.Id desc");
		ipdIntakeOutputList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.IpdIntakeOutputChart as md where md.AdNo = '"
				+ radio_str + "' order by md.Id desc");
		map.put("inPatientDetailList", inpatientList);
		map.put("ipdIntakeOutputList", ipdIntakeOutputList);

		return map;
	}

	// public Map<String, Object> getDBConnection() {
	// Map<String, Object> map = new HashMap<String, Object>();
	// Session session = (Session) getSession();
	// Connection conn = session.connection();
	// map.put("conn", conn);
	// return map;
	// }
	public Map<String, Object> getItemListForWardConsume(Map<String, Object> map) {
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Session session = (Session) getSession();
		int deptId = 0;
		deptId = Integer.parseInt("" + map.get("deptId"));
		try {
			String str = map.get("autoHint") + "%";
			/*
			 * String qry=
			 * "SELECT DISTINCT BRAND_NAME,brand_id  FROM mas_store_brand m, store_item_batch_stock s"
			 * +
			 * "where  m.brand_id = s.brand_id and    m.brand_name like 'b%'and    s.department_id =1 and  s.closing_stock > 0"
			 * ;
			 */
			String query = "SELECT DISTINCT (sib.Item.Nomenclature),sib.Item.PvmsNo from  StoreItemBatchStock as sib where sib.Department.Id="
				+ deptId
				+ "  and  upper(sib.Item.Nomenclature) like upper('"
				+ str
				+ "') and sib.Item.DangerousDrug !='y' and sib.Item.ControlledDrug !='y'";
			// String query=
			// "SELECT DISTINCT (sib.Brand.BrandName),sib.Brand.Id from  StoreItemBatchStock as sib where sib.Department.Id="+deptId+" and  sib.Brand.BrandName like '"+str+"'";
			Query q = session.createQuery(query);
			q.setFirstResult(0);
			q.setMaxResults(10);
			itemList = q.list();
			// Criteria c = session.createCriteria(
			// StoreItemBatchStock.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
			// .createAlias("Brand", "brand")
			// .add(Restrictions.like("brand.BrandName",str));
			// .createAlias("Department", "dept")
			// .add(Restrictions.eq("dept.Id", deptId));
			//			  	  	
			// c.setFirstResult(0);
			// c.setMaxResults(10);
			// itemList = c.list();

			Iterator itr = itemList.iterator();
			while (itr.hasNext()) {
				Object[] pair = (Object[]) itr.next();
				String brandName = (String) pair[0];

			}

		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		map.put("itemList", itemList);
		return map;

	}

	public Map<String, Object> showDutyNursingReportJsp() {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> showList = new ArrayList<Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		try {
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("DepartmentName")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		}
		java.sql.Connection con = session.connection();
		map.put("departmentList", departmentList);
		map.put("con", con);
		return map;
	}

	public Map<String, Object> getDBConnection() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection conn = session.connection();
		map.put("conn", conn);
		return map;
	}

	@SuppressWarnings( { "unchecked", "deprecation" })
	public Map<String, Object> getDiagnosisAndDocumentInit(
			Map<String, Object> dataMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<DischargeIcdCode> dischargeIcdCodeList = new ArrayList<DischargeIcdCode>();
		List<InpatientDocument> inpatientDocumentList = new ArrayList<InpatientDocument>();
		int inpatientId = Integer.parseInt("" + dataMap.get("inpatientId"));
		Session session = (Session) getSession();
		Connection conn = session.connection();
		dischargeIcdCodeList = (List<DischargeIcdCode>) session.createCriteria(
				DischargeIcdCode.class).add(
						Restrictions.eq("Inpatient.Id", inpatientId)).add(
								Restrictions.eq("DiagnosisStatus", "f")).list();
		inpatientDocumentList = (List<InpatientDocument>) session
		.createCriteria(InpatientDocument.class).add(
				Restrictions.eq("Inpatient.Id", inpatientId)).list();

		detailsMap.put("inpatientDocumentList", inpatientDocumentList);
		detailsMap.put("dischargeIcdCodeList", dischargeIcdCodeList);
		detailsMap.put("conn", conn);
		return detailsMap;
	}

	public Map<String, Object> getICDCodeList(Map<String, Object> map) {
		List<MasIcd> itemList = new ArrayList<MasIcd>();
		Session session = (Session) getSession();
		int deptId = 0;
		deptId = Integer.parseInt("" + map.get("deptId"));
		try {
			String str = "%" + map.get("autoHint") + "%";
			String query = "from MasIcd as icd where icd.IcdCode like '" + str
			+ "'";
			Query q = session.createQuery(query);
			q.setFirstResult(0);
			q.setMaxResults(10);
			itemList = q.list();
			Iterator itr = itemList.iterator();
			while (itr.hasNext()) {
				MasIcd MasIcd = (MasIcd) itr.next();
				String icdName = (String) MasIcd.getIcdName();
			}
		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		map.put("itemList", itemList);
		return map;

	}

	public Map<String, Object> showWaitingList(Map<String, Object> dataMap) {

		Session session = (Session) getSession();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		List<Inpatient> inPatientSet = new ArrayList<Inpatient>();
		Map<String, Object> map = new HashMap<String, Object>();
		String takeSetFromSessionInJsp = "";
		String deptName = "";
		int deptId = 0;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		try {
			deptList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Id", deptId)).list();
			inPatientSet = session.createQuery(
					"select ip from Inpatient as ip where ip.AdStatus='W' and ip.Department.Id="
					+ deptId + "order by (DateOfAddmission)desc")
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		}

		if (deptList.size() > 0) {
			MasDepartment masDepartment = (MasDepartment) deptList.get(0);
			deptName = masDepartment.getDepartmentName();
			takeSetFromSessionInJsp = "false";
		}
		Iterator itr = inPatientSet.iterator();
		while (itr.hasNext()) {
			Inpatient inPatient = (Inpatient) itr.next();
			String dateOfAdmissionInString = HMSUtil
			.changeDateToddMMyyyy(inPatient.getDateOfAddmission());
		}

		map.put("takeSetFromSessionInJsp", takeSetFromSessionInJsp);
		map.put("inpatientSet", inPatientSet);
		map.put("deptName", deptName);

		return map;

	}

	public Map<String, Object> submitWaitingList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Box box = (Box) dataMap.get("box");
		Vector waitingId = box.getVector("parent");
		Transaction transaction = null;
		String saved = "no";
		try {
			transaction = session.beginTransaction();
			for (int i = 0; i < waitingId.size(); i++) {
				String qry = "update inpatient as ip set ip.ad_status='A' where inpatient_id='"
					+ Integer.parseInt(waitingId.get(i).toString()) + "' ";
				Query query2 = session.createSQLQuery(qry);
				int row2 = query2.executeUpdate();
			}
			transaction.commit();
			saved = "yes";
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
			;
		}
		map.put("saved", saved);
		return map;
	}

	public Map<String, Object> getWardRemarksDetails(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<WardRemarks> wardRemarksList = new ArrayList<WardRemarks>();
		String remarksDate = "";
		try {
			if (dataMap.get("remarksDate") != null) {
				remarksDate = "" + dataMap.get("remarksDate");
			}
			SimpleDateFormat formatterIn2 = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut2 = new SimpleDateFormat("yyyy-MM-dd");
			String date4MySQL2 = formatterOut2.format(formatterIn2
					.parse(remarksDate));
			org.hibernate.Session session = getSession();
			wardRemarksList = (List<WardRemarks>) session.createCriteria(
					WardRemarks.class).add(
							Restrictions.eq("RemarksDate", java.sql.Date.valueOf(""
									+ date4MySQL2))).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("wardRemarksList", wardRemarksList);
		return map;
	}

	public Map<String, Object> saveWardRemarks(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = null;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		int departmentId = 0;
		String date = "";
		String lastChgBy = "";
		String currentTime = "";
		String saved = "no";
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		currentTime = (String) utilMap.get("currentTimeWithoutSc");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		if (box.get("deptId") != null) {
			departmentId = Integer.parseInt("" + box.get("deptId"));
		}

		try {
			WardRemarks wardRemarks = new WardRemarks();
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String date4MySQL = formatterOut.format(formatterIn.parse(""
					+ box.get(DATE)));
			wardRemarks.setRemarksDate(java.sql.Date.valueOf(date4MySQL));
			wardRemarks.setRemarksTime("" + box.get(TIME));
			wardRemarks.setRemarks("" + box.get(REMARKS));
			if (departmentId != 0)
				wardRemarks.setDepartment(new MasDepartment(departmentId));
			if (box.get("userName") != null) {
				Users user = new Users();
				user.setId(box.getInt("userId"));
				wardRemarks.setLastChgBy(user);
			}

			SimpleDateFormat formatterIn2 = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut2 = new SimpleDateFormat("yyyy-MM-dd");
			String date4MySQL2 = formatterOut2.format(formatterIn2.parse(date));
			wardRemarks.setLastChgDate(java.sql.Date.valueOf(date4MySQL2));
			wardRemarks.setLastChgTime(currentTime);
			hbt.save(wardRemarks);
			saved = "yes";
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("saved", saved);
		return map;
	}

	public Map<String, Object> getIpIdFormDischargeId(
			Map<String, Object> tempMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		int dischargeId = 0;
		if (tempMap.get("dischargeId") != null) {
			dischargeId = Integer.parseInt("" + tempMap.get("dischargeId"));
		}
		org.hibernate.Session session = getSession();
		List<Discharge> dischargeList = new ArrayList<Discharge>();
		try {
			dischargeList = session.createCriteria(Discharge.class).add(
					Restrictions.eq("Id", dischargeId)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		}
		String adNo = "";
		for (Discharge discharge : dischargeList) {
			adNo = discharge.getAdNo();
		}
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		try {
			inpatientList = session.createCriteria(Inpatient.class).add(
					Restrictions.eq("AdNo", adNo)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		}
		int inpatientId = 0;
		for (Inpatient inpatient : inpatientList) {
			inpatientId = Integer.parseInt("" + inpatient.getId());
		}
		map.put("inpatientId", inpatientId);
		return map;
	}

	public Map<String, Object> getPatientDetails(Map<String, Object> tempMap) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> inPatientList = new ArrayList<Object>();
		String remarks = "";
		String treatment = "";
		String status = "";
		List<PatientRemarks> patientRemarksList = new ArrayList<PatientRemarks>();
		int inpatientId = 0;

		if (tempMap.get("inpatientId") != null) {
			inpatientId = (Integer) tempMap.get("inpatientId");
		}
		if (tempMap.get("status") != null) {
			status = (String) tempMap.get("status");
		}
		List objectList = new ArrayList();
		objectList.add("A");
		try {
			Criteria crit = session.createCriteria(Inpatient.class).add(
					Restrictions.in("AdStatus", objectList));

			if (inpatientId != 0) {
				crit = crit.add(Restrictions.idEq(inpatientId));
			}
			inPatientList = crit.list();

			patientRemarksList = (List<PatientRemarks>) session.createCriteria(
					PatientRemarks.class).add(
							Restrictions.eq("Inpatient.Id", inpatientId)).addOrder(
									Order.desc("Id")).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.close();
		}

		if (status.equals("Yes")) {
			if (patientRemarksList != null && patientRemarksList.size() > 0) {
				PatientRemarks patientRemarks = (PatientRemarks) patientRemarksList
				.get(0);
				remarks = patientRemarks.getRemarks();
				treatment = patientRemarks.getTreatment();

			}
		}
		map.put("inPatientList", inPatientList);
		map.put("remarks", remarks);
		map.put("treatment", treatment);
		return map;
	}

	public Map<String, Object> submitPatientRemarks(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<SilDilStatus> siList = new ArrayList<SilDilStatus>();
		SilDilStatus silDilStatus = new SilDilStatus();

		Session session = (Session) getSession();
		int inpatientId = 0;
		String adNo = null;
		String remarks = null;
		String condition = null;
		String treatment = null;
		String postOpCase = "n";
		String addEditTime = null;
		Date addEditDate = null;
		Date date = null;
		String addEditBy = null;
		boolean dataStatus = false;
		Transaction tx = null;

		HibernateTemplate hbt = getHibernateTemplate();
		if (dataMap.get("inpatientId") != null) {
			inpatientId = (Integer) dataMap.get("inpatientId");
		}
		if (dataMap.get("adNo") != null) {
			adNo = (String) dataMap.get("adNo");
		}
		if (dataMap.get("remarks") != null) {
			remarks = (String) dataMap.get("remarks");
		}
		if (dataMap.get("condition") != null) {
			condition = (String) dataMap.get("condition");
		}
		if (dataMap.get("treatment") != null) {
			treatment = (String) dataMap.get("treatment");
		}
		if (dataMap.get("postOpCase") != null) {
			postOpCase = (String) dataMap.get("postOpCase");
		}
		if (dataMap.get("addEditDate") != null) {
			addEditDate = (Date) dataMap.get("addEditDate");
		}
		if (dataMap.get("date") != null) {
			date = (Date) dataMap.get("date");
		}
		if (dataMap.get("addEditTime") != null) {
			addEditTime = (String) dataMap.get("addEditTime");
		}
		if (dataMap.get("addEditBy") != null) {
			addEditBy = (String) dataMap.get("addEditBy");
		}
		try {
			tx = session.beginTransaction();
			// hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (inpatientId != 0) {

				siList = (List<SilDilStatus>) session.createCriteria(
						SilDilStatus.class).add(
								Restrictions.eq("Inpatient.Id", inpatientId)).addOrder(
										Order.desc("Id")).list();

				if (siList.size() > 0) {
					SilDilStatus silDil = (SilDilStatus) siList.get(0);
					silDilStatus = (SilDilStatus) hbt.load(SilDilStatus.class,
							silDil.getId());
					silDilStatus.setRemarks(condition);
					hbt.update(silDilStatus);
				}

				PatientRemarks patientRemarks = new PatientRemarks();
				if (remarks != null) {
					patientRemarks.setRemarks(remarks);
				}
				if (postOpCase != null) {
					if (postOpCase.equals("y")) {
						patientRemarks.setPostOpCase(postOpCase);
					} else {
						patientRemarks.setPostOpCase("n");
					}
				}

				patientRemarks.setLastChgDate(date);
				patientRemarks.setLastChgTime(addEditTime);
				patientRemarks.setLastChgBy(addEditBy);

				if (condition != null) {
					patientRemarks.setPatientCondition(condition);
				}
				if (treatment != null) {
					patientRemarks.setTreatment(treatment);
				}
				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				patientRemarks.setInpatient(inpatient);
				hbt.save(patientRemarks);
				tx.commit();
				dataStatus = true;
			}
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();

			e.printStackTrace();
		}

		map.put("dataStatus", dataStatus);
		return map;
	}

	public Map<String, Object> getPatientRemarksDetails(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<PatientRemarks> patientRemarksList = new ArrayList<PatientRemarks>();
		org.hibernate.Session session = getSession();
		String remarksDate = "";
		int patientId = 0;
		try {
			if (dataMap.get("remarksDate") != null) {
				remarksDate = "" + dataMap.get("remarksDate");
			}

			if (dataMap.get("patientId") != null) {
				patientId = (Integer) dataMap.get("patientId");
			}

			SimpleDateFormat formatterIn2 = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut2 = new SimpleDateFormat("yyyy-MM-dd");
			String date4MySQL2 = formatterOut2.format(formatterIn2
					.parse(remarksDate));

			patientRemarksList = (List<PatientRemarks>) session.createCriteria(
					PatientRemarks.class).add(
							Restrictions.eq("Inpatient.Id", patientId)).add(
									Restrictions.eq("LastChgDate", java.sql.Date.valueOf(""
											+ date4MySQL2))).addOrder(Order.asc("Id")).list();

		} catch (Exception e) {
			e.printStackTrace();

		}
		map.put("patientRemarksList", patientRemarksList);
		return map;
	}

	public String getdepartmentName(Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		String departmentName = "";
		int departmentId = 0;

		if (dataMap.get("departmentId") != null) {
			departmentId = (Integer) dataMap.get("departmentId");
		}
		try {
			Criteria crit = session.createCriteria(MasDepartment.class);
			if (departmentId != 0) {
				crit = crit.add(Restrictions.idEq(departmentId));
			}
			departmentList = crit.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.close();
		}
		MasDepartment department = (MasDepartment) departmentList.get(0);
		departmentName = department.getDepartmentName();
		return departmentName;
	}

	// -------------------method added by vikas for button rights--------------

	public Map<String, Object> getUserButtonRights(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<UserButtonRights> userRightsList = new ArrayList<UserButtonRights>();
		Users users = (Users) dataMap.get("users");
		int userId = users.getId();
		try {
			userRightsList = session.createCriteria(UserButtonRights.class)
			.createAlias("User", "user").add(
					Restrictions.eq("user.Id", userId)).list();

			map.put("userRightsList", userRightsList);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		}
		return map;
	}

	public Map<String, Object> getSILDILData(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<SilDilStatus> silDilList = new ArrayList<SilDilStatus>();
		int departmentId = 0;
		Date reportDate = null;

		if (dataMap.get("departmentId") != null) {
			departmentId = (Integer) dataMap.get("departmentId");
		}

		if (dataMap.get("date") != null) {
			reportDate = (Date) dataMap.get("date");
		}
		int dateOfMonth, month, year;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(reportDate);
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

		String Query = "select s.inpatient_id,s.condition_status,s.last_chg_date,s.department_id,i.discharge_date"
			+ " from sil_dil_status s,inpatient i where s.inpatient_id = i.inpatient_id"
			+ " and i.date_of_addmission <= '"
			+ dateOnly
			+ "'"
			+ " and (i.discharge_date >= '"
			+ dateOnly
			+ "' or i.discharge_date is null)"
			+ " and i.ad_status != 'C'  and i.department_id = "
			+ departmentId
			+ " "
			+ " group by s.inpatient_id,s.condition_status,s.last_chg_date,s.department_id,i.discharge_date order by s.inpatient_id ";
		List objectList = session.createSQLQuery(Query).list();
		String sildil = "";
		int silcount = 0;
		int dilcount = 0;
		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
			Object[] obj = (Object[]) iterator.next();
			if (sildil.length() > 0) {
				sildil = sildil + "," + obj[0].toString();
			} else {
				sildil = obj[0].toString();
			}

			String subQuery = "select case when(select condition_status from sil_dil_status where inpatient_id = '"
				+ obj[0].toString()
				+ "'"
				+ " and last_chg_date <= '"
				+ dateOnly
				+ "' order by id desc limit 0,1) != 'Normal' then "
				+ " (select condition_status from sil_dil_status where inpatient_id = '"
				+ obj[0].toString()
				+ "' "
				+ " and last_chg_date <= '"
				+ dateOnly
				+ "' order by id desc limit 0,1) else '' end from dual";
			List subObjectList = session.createSQLQuery(subQuery).list();
			for (Iterator iterator1 = subObjectList.iterator(); iterator1
			.hasNext();) {
				String status = iterator1.next().toString();
				if (!status.equals("")) {
					if (status.equals("SIL")) {
						silcount = silcount + 1;
					} else {
						dilcount = dilcount + 1;
					}
				}
			}

		}

		map.put("silcount", silcount);
		map.put("dilcount", dilcount);
		return map;
	}

	@Override
	public Map<String, Object> showNewNursingCareEntryDetailsJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<NursingcareSetup> nursingCareSetupList = new ArrayList<NursingcareSetup>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		inpatientList =  session.createCriteria(Inpatient.class).add(Restrictions.idEq(box.getInt("parent"))).list();
		nursingCareSetupList = session.createCriteria(NursingcareSetup.class).createAlias("Inpatient", "ip").add(Restrictions.eq("ip.Id", box.getInt("parent"))).list();
		map.put("nursingCareSetupList", nursingCareSetupList);
		map.put("inpatientList", inpatientList);
		return map;
	}

	@Override
	public Map<String, Object> showDietEntryDetailsJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<PatientDietIndoorDetail> patientDietIndoorDetailList = new ArrayList<PatientDietIndoorDetail>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		inpatientList =  session.createCriteria(Inpatient.class).add(Restrictions.idEq(box.getInt("parent"))).list();
		patientDietIndoorDetailList = session.createCriteria(PatientDietIndoorDetail.class).createAlias("Inpatient", "ip").add(Restrictions.eq("ip.Id", box.getInt("parent"))).list();
		map.put("patientDietIndoorDetailList", patientDietIndoorDetailList);
		map.put("inpatientList", inpatientList);
		return map;
	}
	
	@Override
	public Map<String, Object> showConsultationEntryDetailsJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		/*List<PatientDietIndoorDetail> patientDietIndoorDetailList = new ArrayList<PatientDietIndoorDetail>();*/
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<PreAnesthesiaConsultDoctorDt> consultDoctorDtList = new ArrayList<PreAnesthesiaConsultDoctorDt>();
		inpatientList =  session.createCriteria(Inpatient.class).add(Restrictions.idEq(box.getInt("parent"))).list();
		consultDoctorDtList =  session.createCriteria(PreAnesthesiaConsultDoctorDt.class)
				.createAlias("ConsultDoctorIdHd", "hd")
				.add(Restrictions.eq("hd.Inpatient.Id",box.getInt("parent")))
				.addOrder(Order.desc("Id")).list();
		/*patientDietIndoorDetailList = session.createCriteria(PatientDietIndoorDetail.class).createAlias("Inpatient", "ip").add(Restrictions.eq("ip.Id", box.getInt("parent"))).list();
		map.put("patientDietIndoorDetailList", patientDietIndoorDetailList);*/
		map.put("inpatientList", inpatientList);
		map.put("consultDoctorDtList", consultDoctorDtList);
		return map;
	}
	
	@Override
	public Map<String, Object> showNewNursingClinicalChartJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<IpdTemperature> patientClinicalChartList = new ArrayList<IpdTemperature>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		inpatientList =  session.createCriteria(Inpatient.class).add(Restrictions.idEq(box.getInt("parent"))).list();
		patientClinicalChartList = session.createCriteria(IpdTemperature.class).createAlias("Intakeoutput", "io").createAlias("io.Inpatient", "ip").add(Restrictions.eq("ip.Id", box.getInt("parent"))).addOrder(Order.asc("IpdDate")).addOrder(Order.asc("Time")).list();
		map.put("patientClinicalChartList", patientClinicalChartList);
		map.put("inpatientList", inpatientList);
		return map;
	}

	@Override
	public boolean acceptPatientToWard(Box box) {
		boolean flag = false;
		int inpatientId = box.getInt("parent");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setCheckWriteOperations(false);
		hbt.setFlushModeName("FLUSH_EAGER");
		try {
			Inpatient inpatient = (Inpatient)hbt.load(Inpatient.class, inpatientId);
			inpatient.setAdStatus("A");
			hbt.update(inpatient);
			flag = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public boolean transferPatientToLaborRoom(Box box) {
		boolean flag = false;
		int inpatientId = box.getInt("parent");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setCheckWriteOperations(false);
		hbt.setFlushModeName("FLUSH_EAGER");
		try {
			Inpatient inpatient = (Inpatient)hbt.load(Inpatient.class, inpatientId);
			inpatient.setAdStatus("L");
			inpatient.setDeliveryStatus("n");
			hbt.update(inpatient);
			flag = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public boolean transferPatientToOT(Box box) {
		boolean flag = false;
		int inpatientId = box.getInt("parent");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setCheckWriteOperations(false);
		hbt.setFlushModeName("FLUSH_EAGER");
		try {
			Inpatient inpatient = (Inpatient)hbt.load(Inpatient.class, inpatientId);
			inpatient.setAdStatus("O");			
			hbt.update(inpatient);
			flag = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public Map<String, Object> showPayrollDeductionJournal(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		
		List<MasDivision> divisionList = new ArrayList<MasDivision>();
		
		
		Session session = (Session) getSession();
		
		int hospitalId = box.getInt("hospitalId");
		
		
		
		
		divisionList = session.createCriteria(MasDivision.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("DivisionName")).list();
		
		
		
		map.put("divisionList", divisionList);
		
		
		
		return map;
	}

	@Override
	public Map<String, Object> getPatientDetailsForKitIssue(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<KitIssueMasterTemplateM> templateList = new ArrayList<KitIssueMasterTemplateM>();
		List<IpdKitIssueHeader> ipdKitIssueList = new ArrayList<IpdKitIssueHeader>();
		inpatientList =  session.createCriteria(Inpatient.class).add(Restrictions.idEq(box.getInt("parent"))).list();
		templateList = session.createCriteria(KitIssueMasterTemplateM.class).add(Restrictions.eq("Status", "y")).list();
		ipdKitIssueList = session.createCriteria(IpdKitIssueHeader.class).createAlias("Inpatient", "ip").add(Restrictions.eq("ip.Id", box.getInt("parent"))).list();
		map.put("inpatientList", inpatientList);
		map.put("templateList", templateList);
		map.put("ipdKitIssueList", ipdKitIssueList);
		return map;
	}

	@Override
	public Map<String, Object> getTemplateDetails(Box box) {	
		Map<String, Object> map = new HashMap<String, Object>();
		List<KitIssueMasterTemplateT> kitIssueDetailsList = new ArrayList<KitIssueMasterTemplateT>();
		Session session = (Session) getSession();
		kitIssueDetailsList = session.createCriteria(KitIssueMasterTemplateT.class).createAlias("Template", "t").add(Restrictions.eq("t.Id", box.getInt("kitIssueMasterId"))).list();
		map.put("kitIssueDetailsList", kitIssueDetailsList);
		return map;}

	@Override
	public Map<String, Object> submitPatientKitIssue(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = false;
		int inpatientId = box.getInt("parent");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setCheckWriteOperations(false);
		hbt.setFlushModeName("FLUSH_EAGER");
		Session session = (Session)getSession();
		Transaction tx= null;
		IpdKitIssueHeader ipdKitIssueHeader = new IpdKitIssueHeader();
		try {
			tx = session.beginTransaction();
			if(box.getInt("ipdKitIssueHeaderId")==0){
				Patient hin = new Patient();
				hin.setId(box.getInt(HIN_ID));
				ipdKitIssueHeader.setHin(hin);
				Inpatient inpatient = new Inpatient();
				inpatient.setId(box.getInt(INPATIENT_ID));
				ipdKitIssueHeader.setInpatient(inpatient);
				MasHospital hospital = new MasHospital();
				hospital.setId(box.getInt("hospitalId"));
				ipdKitIssueHeader.setHospital(hospital);
				/*KitIssueMasterTemplateM template = new KitIssueMasterTemplateM();
				template.setId(box.getInt("kitIssueMasterId"));
				ipdKitIssueHeader.setTemplate(template);*/
				Users user = new Users();
				user.setId(box.getInt("userId"));
				ipdKitIssueHeader.setLastChgBy(user);
				ipdKitIssueHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				ipdKitIssueHeader.setLastChgTime(box.getString(CHANGED_TIME));
				hbt.save(ipdKitIssueHeader);
			}else{
				ipdKitIssueHeader.setId(box.getInt("ipdKitIssueHeaderId"));

			}

			int counter = box.getInt("hdb");
			if(counter >0 ) {
				for (int i = 1; i <= counter; i++) {
					if(!box.getString("itemName"+i).equals("") && box.getInt("kitIssueDetailsId"+i)==0){
						IpdKitIssueDetails kitIssueDetails = new IpdKitIssueDetails();
						/*kitIssueDetails.setItemName(box.getString("itemName"+i));*/
						MasStoreItem masStoreItem = new MasStoreItem();
						masStoreItem.setId(box.getInt("itemId"+i));
						kitIssueDetails.setQuantity(box.getInt("issueQuantity"+i));
						kitIssueDetails.setItem(masStoreItem);
						
						kitIssueDetails.setIpdKitIssueHeader(ipdKitIssueHeader);
						hbt.save(kitIssueDetails);
					}
				}

			}
			flag = true;
			tx.commit();
		} catch (DataAccessException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		map.put("flag", flag);
		return map;
	}

	@Override
	public Map<String, Object> showCaseSheetJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<OpdPatientDetails> opdDetailsList = new ArrayList<OpdPatientDetails>();
		List<OpdPatientDetails> ipdDetailsList = new ArrayList<OpdPatientDetails>();		
		List<PatientPrescriptionHeader> opdPrescriptionList = new ArrayList<PatientPrescriptionHeader>();
		List<PatientInvestigationHeader> opdInvestigationList = new ArrayList<PatientInvestigationHeader>();
		List<DischargeIcdCode> icdList = new ArrayList<DischargeIcdCode>();
		List<ProcedureHeader> opdProcedureList = new ArrayList<ProcedureHeader>();
		List<PhysioRequisitionHeader> opdPhysiotherapyList = new ArrayList<PhysioRequisitionHeader>();
		List<OpdPatientHistory> opdHistoryDetailsListForFollowUp = new ArrayList<OpdPatientHistory>();
		List<IpdPatientDiet> ipdPatientDietList= new ArrayList<IpdPatientDiet>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<PatientFamilyHistory> familyHistoryList = new ArrayList<PatientFamilyHistory>();
		List<MasIcd> masIcdList = new ArrayList<MasIcd>();
		List<MasDiet> dietTypeList = new ArrayList<MasDiet>();	
		List<OpdPatientDetails> caseSheetList = new ArrayList<OpdPatientDetails>();
		List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();

		Session session = (Session)getSession();
		inpatientList =  session.createCriteria(Inpatient.class).add(Restrictions.idEq(box.getInt("parent"))).list();
		int hinId= inpatientList.get(0).getHin().getId();
		opdDetailsList = session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "v").createAlias("v.Hin", "hin").add(Restrictions.eq("hin.Id", hinId))
		.addOrder(Order.desc("id")).setMaxResults(1).list();
		ipdDetailsList = session.createCriteria(OpdPatientDetails.class).createAlias("Inpatient", "ip").add(Restrictions.eq("ip.Id", box.getInt("parent")))
		.addOrder(Order.desc("id")).list();

		if(opdDetailsList.size() > 0) {
			int visitId = 0;
			visitId = opdDetailsList.get(0).getVisit().getId();
			if(ipdDetailsList.size() == 0) {
				opdPrescriptionList = session.createCriteria(PatientPrescriptionHeader.class).createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
				opdInvestigationList = session.createCriteria(PatientInvestigationHeader.class).createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
				icdList = session.createCriteria(DischargeIcdCode.class).createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
				opdProcedureList = session.createCriteria(ProcedureHeader.class).createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
				opdPhysiotherapyList =  session.createCriteria(PhysioRequisitionHeader.class).createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
				opdHistoryDetailsListForFollowUp = session.createCriteria(OpdPatientHistory.class).createAlias("OpdPatientDetails", "details")
				.createAlias("details.Visit", "visit").add(Restrictions.eq("visit.Id", visitId)).list();
			}
			caseSheetList.addAll(opdDetailsList); //to display opd case sheet
		}

		if(ipdDetailsList.size() > 0) {
			caseSheetList.addAll(ipdDetailsList);// to display all previous case list
			opdDetailsList.add(ipdDetailsList.get(0)); // to display latest case sheet details in todays case sheet
			int opdPatientDetailsId = 0;
			opdPatientDetailsId = ipdDetailsList.get(0).getId();
			List<PatientPrescriptionHeader> ipdPrescriptionList = new ArrayList<PatientPrescriptionHeader>();
			List<PatientInvestigationHeader> ipdInvestigationList = new ArrayList<PatientInvestigationHeader>();
			List<DischargeIcdCode> ipIcdList = new ArrayList<DischargeIcdCode>();
			List<ProcedureHeader> ipdProcedureList = new ArrayList<ProcedureHeader>();
			List<PhysioRequisitionHeader> ipdPhysiotherapyList = new ArrayList<PhysioRequisitionHeader>();
			List<OpdPatientHistory> ipdHistoryDetailsListForFollowUp = new ArrayList<OpdPatientHistory>();
			ipdPrescriptionList = session.createCriteria(PatientPrescriptionHeader.class).createAlias("OpdPatientDetails", "ip").add(Restrictions.eq("ip.id", opdPatientDetailsId)).addOrder(Order.desc("Id")).setMaxResults(1).list();
			ipdInvestigationList = session.createCriteria(PatientInvestigationHeader.class).createAlias("OpdPatientDetails", "ip").add(Restrictions.eq("ip.id", opdPatientDetailsId)).addOrder(Order.desc("Id")).setMaxResults(1).list();
			ipIcdList = session.createCriteria(DischargeIcdCode.class).createAlias("OpdPatientDetails", "ip").add(Restrictions.eq("ip.id", opdPatientDetailsId)).addOrder(Order.desc("Id")).list();
			ipdProcedureList = session.createCriteria(ProcedureHeader.class).createAlias("OpdPatientDetails", "ip").add(Restrictions.eq("ip.id", opdPatientDetailsId)).addOrder(Order.desc("Id")).setMaxResults(1).list();
			ipdPhysiotherapyList =  session.createCriteria(PhysioRequisitionHeader.class).createAlias("OpdPatientDetails", "ip").add(Restrictions.eq("ip.id", opdPatientDetailsId)).addOrder(Order.desc("Id")).setMaxResults(1).list();
			ipdHistoryDetailsListForFollowUp = session.createCriteria(OpdPatientHistory.class).createAlias("OpdPatientDetails", "ip").add(Restrictions.eq("ip.id", opdPatientDetailsId)).list();

			ipdPatientDietList = session.createCriteria(IpdPatientDiet.class).createAlias("OpdPatientDetails", "ip").add(Restrictions.eq("ip.id", opdPatientDetailsId)).addOrder(Order.desc("Id")).setMaxResults(1).list();

			opdPrescriptionList.addAll(ipdPrescriptionList);
			opdInvestigationList.addAll(ipdInvestigationList);
			icdList.addAll(ipIcdList);
			opdProcedureList.addAll(ipdProcedureList);
			opdPhysiotherapyList.addAll(ipdPhysiotherapyList);
			opdHistoryDetailsListForFollowUp.addAll(ipdHistoryDetailsListForFollowUp);

		}
		frequencyList = session.createCriteria(MasFrequency.class).add(Restrictions.eq("Status", "y")).list();
		familyHistoryList = session.createCriteria(PatientFamilyHistory.class).add(Restrictions.eq("Status", "y")).list();
		masIcdList = session.createCriteria(MasIcd.class).add(Restrictions.eq("Status", "y")).list();
		dietTypeList = session.createCriteria(MasDiet.class).add(Restrictions.eq("Status", "y")).list();
		templateList = session.createCriteria(OpdTemplate.class)
		.createAlias("Department", "dept").add(
				Restrictions.eq("dept.Id", box.getInt("deptId"))).add(
						Restrictions.eq("Status", "y")).list();
		map.put("caseSheetList", caseSheetList);
		map.put("inpatientList", inpatientList);
		map.put("opdDetailsList", opdDetailsList);
		map.put("opdPrescriptionList", opdPrescriptionList);
		map.put("opdInvestigationList", opdInvestigationList);
		map.put("icdList", icdList);
		map.put("opdProcedureList", opdProcedureList);
		map.put("opdPhysiotherapyList", opdPhysiotherapyList);
		map.put("opdHistoryDetailsListForFollowUp", opdHistoryDetailsListForFollowUp);
		map.put("ipdPatientDietList", ipdPatientDietList);
		map.put("frequencyList", frequencyList);
		map.put("familyHistoryList", familyHistoryList);
		map.put("masIcdList", masIcdList);
		map.put("dietTypeList", dietTypeList);
		return map;
	}

	public Map<String, Object> getPreviousCaseSheetDetails(Box box){
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdPatientDetails> opdDetailsList = new ArrayList<OpdPatientDetails>();
		List<OpdPatientDetails> ipdDetailsList = new ArrayList<OpdPatientDetails>();

		List<PatientPrescriptionDetails> opdPrescriptionList = new ArrayList<PatientPrescriptionDetails>();
		List<PatientInvestigationDetails> opdInvestigationList = new ArrayList<PatientInvestigationDetails>();
		List<DischargeIcdCode> icdList = new ArrayList<DischargeIcdCode>();
		List<ProcedureDetails> opdProcedureList = new ArrayList<ProcedureDetails>();
		List<PhysioRequisitionDetail> opdPhysiotherapyList = new ArrayList<PhysioRequisitionDetail>();
		List<OpdPatientHistory> opdHistoryDetailsListForFollowUp = new ArrayList<OpdPatientHistory>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<MasMedicalExamFamilyHis> familyHistoryList = new ArrayList<MasMedicalExamFamilyHis>();
		List<IpdPatientDiet> ipdPatientDietList= new ArrayList<IpdPatientDiet>();

		Session session = (Session)getSession();
		int hinId = box.getInt("hinId");
		opdDetailsList = session.createCriteria(OpdPatientDetails.class).add(Restrictions.idEq(box.getInt("opdPatientDetailsId"))).list();

		/*if(opdDetailsList.size() > 0) {
			int visitId = 0;
			if(opdDetailsList.get(0).getVisit()!=null) {
				visitId = opdDetailsList.get(0).getVisit().getId();
				hinId = opdDetailsList.get(0).getVisit().getHin().getId();
				opdPrescriptionList = session.createCriteria(PatientPrescriptionDetails.class).createAlias("Prescription", "p").createAlias("p.Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
				opdInvestigationList = session.createCriteria(PatientInvestigationDetails.class).createAlias("InvestigationHeader", "ih").createAlias("ih.Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
				icdList = session.createCriteria(DischargeIcdCode.class).createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
				opdProcedureList = session.createCriteria(ProcedureDetails.class).createAlias("ProcedureHeader", "p").createAlias("p.Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
				opdPhysiotherapyList =  session.createCriteria(PhysioRequisitionDetail.class).createAlias("PhysioRequisitionHeader", "p").createAlias("p.Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
				opdHistoryDetailsListForFollowUp = session.createCriteria(OpdPatientHistory.class).createAlias("OpdPatientDetails", "details")
				.createAlias("details.Visit", "visit").add(Restrictions.eq("visit.Id", visitId)).list();
			}else if( opdDetailsList.get(0).getInpatient()!=null) {
				int inpatientId = opdDetailsList.get(0).getInpatient().getId();
				hinId = opdDetailsList.get(0).getInpatient().getHin().getId();
				opdPrescriptionList = session.createCriteria(PatientPrescriptionDetails.class).createAlias("Prescription", "p").createAlias("p.Inpatient", "ip").add(Restrictions.eq("ip.Id", inpatientId)).list();
				opdInvestigationList = session.createCriteria(PatientInvestigationDetails.class).createAlias("InvestigationHeader", "ih").createAlias("ih.Inpatient", "ip").add(Restrictions.eq("ip.Id",inpatientId)).list();
				icdList = session.createCriteria(DischargeIcdCode.class).createAlias("Inpatient", "ip").add(Restrictions.eq("ip.Id", inpatientId)).list();
				opdProcedureList = session.createCriteria(ProcedureDetails.class).createAlias("ProcedureHeader", "p").createAlias("p.Inpatient", "ip").add(Restrictions.eq("ip.Id", inpatientId)).list();
				opdPhysiotherapyList =  session.createCriteria(PhysioRequisitionDetail.class).createAlias("PhysioRequisitionHeader", "p").createAlias("p.Inpatient", "ip").add(Restrictions.eq("ip.Id", inpatientId)).list();
				opdHistoryDetailsListForFollowUp = session.createCriteria(OpdPatientHistory.class).createAlias("OpdPatientDetails", "details")
				.createAlias("details.Inpatient", "ip").add(Restrictions.eq("ip.Id", inpatientId)).list();

			}
		}*/
		opdPrescriptionList = session.createCriteria(PatientPrescriptionDetails.class).createAlias("Prescription", "p").createAlias("p.OpdPatientDetails", "opd").add(Restrictions.eq("opd.id", box.getInt("opdPatientDetailsId"))).list();
		opdInvestigationList = session.createCriteria(PatientInvestigationDetails.class).createAlias("InvestigationHeader", "ih").createAlias("ih.OpdPatientDetails", "opd").add(Restrictions.eq("opd.id", box.getInt("opdPatientDetailsId"))).list();
		icdList = session.createCriteria(DischargeIcdCode.class).createAlias("OpdPatientDetails", "opd").add(Restrictions.eq("opd.id", box.getInt("opdPatientDetailsId"))).list();
		opdProcedureList = session.createCriteria(ProcedureDetails.class).createAlias("ProcedureHeader", "p").createAlias("p.OpdPatientDetails", "opd").add(Restrictions.eq("opd.id", box.getInt("opdPatientDetailsId"))).list();
		opdPhysiotherapyList =  session.createCriteria(PhysioRequisitionDetail.class).createAlias("PhysioRequisitionHeader", "p").createAlias("p.OpdPatientDetails", "opd").add(Restrictions.eq("opd.id", box.getInt("opdPatientDetailsId"))).list();
		opdHistoryDetailsListForFollowUp = session.createCriteria(OpdPatientHistory.class).createAlias("OpdPatientDetails", "opd").add(Restrictions.eq("opd.id", box.getInt("opdPatientDetailsId"))).list();
		ipdPatientDietList = session.createCriteria(IpdPatientDiet.class).createAlias("OpdPatientDetails", "opd").add(Restrictions.eq("opd.id", box.getInt("opdPatientDetailsId"))).list();

		frequencyList = session.createCriteria(MasFrequency.class).add(Restrictions.eq("Status", "y")).list();
		familyHistoryList = session.createCriteria(MasMedicalExamFamilyHis.class).createAlias("Hin", "h").add(Restrictions.eq("h.Id", hinId)).list();

		map.put("opdDetailsList", opdDetailsList);
		map.put("opdPrescriptionList", opdPrescriptionList);
		map.put("opdInvestigationList", opdInvestigationList);
		map.put("icdList", icdList);
		map.put("opdProcedureList", opdProcedureList);
		map.put("opdPhysiotherapyList", opdPhysiotherapyList);
		map.put("opdHistoryDetailsListForFollowUp", opdHistoryDetailsListForFollowUp);
		map.put("ipdPatientDietList", ipdPatientDietList);
		map.put("frequencyList", frequencyList);
		map.put("familyHistoryList", familyHistoryList);
		return map;
	}

	@Override
	public synchronized Map<String, Object> submitIpdCaseSheetDetails(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		boolean flag = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setCheckWriteOperations(false);
		hbt.setFlushModeName("FLUSH_EAGER");
		Session session = (Session)getSession();
		Transaction tx= null;
		Date date = new Date();
		try {
			Box box = (Box)dataMap.get("box");
			Map<String,Object> utilMap = new HashMap<String,Object>();
			List<Integer> itemIdList = (List<Integer>) dataMap.get("itemIdList");
			List<Integer> classificationList = (List<Integer>) dataMap.get("classificationList");
			List<Integer> frequencyList = (List) dataMap.get("frequencyList");
			List<String> otherMedicineList = (List) dataMap.get("otherMedicineList");
			List<Integer> itemConversionList = (List) dataMap.get("itemConversionList");
			List<Integer> itemClassList = (List) dataMap.get("itemClassList");
			List<String> itemDispensaryList = (List) dataMap.get("itemDispensaryList");
			List<BigDecimal> uomQtyList =(List) dataMap.get("uomQtyList");
			List<String> ctList = (List) dataMap.get("ctList");
			List<String> dosageList = (List) dataMap.get("dosageList");
			List<String> routeList = new ArrayList<String>();
			routeList= (List) dataMap.get("routeList");
			List<Integer> totalList = (List) dataMap.get("totalList");
			List<Integer> noOfDaysList = (List) dataMap.get("noOfDaysList");
			List<String> remarksList = (List) dataMap.get("remarksList");

			List<String> chargeCodeIdList = (List) dataMap.get("chargeCodeIdList");
			List<String> investigationDateList = (List) dataMap.get("investigationDate");
			
			int hospitalId= box.getInt("hospitalId");
			int empId = box.getInt("empId");
			int inpatientId = box.getInt("inpatientId");
			int departmentId = box.getInt("deptId");
			int hinId = box.getInt("hinId");
			
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String consultationTime = (String)utilMap.get("currentTimeWithoutSc");

			int physioRequisitionHeaderId = 0;
			int procedureHeaderId = 0;
			String nipCode = null;
			int itemClassificationId = 0;
			int groupId = 0;
			int sectionId = 0;
			int itemTypeId= 0;
			physioRequisitionHeaderId = box.getInt("physioRequisitionHeaderId");
			procedureHeaderId = box.getInt("procedureHeaderId");


			tx = session.beginTransaction();
			OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
			Inpatient inpatient = new Inpatient();
			/*List<WardRemarks>wardreamarksList=new ArrayList<WardRemarks>();
			  wardreamarksList=session.createCriteria(WardRemarks.class).add(Restrictions.eq("Inpatient.Id", box.getInt("inpatientId"))).add(Restrictions.eq("Status", "P").ignoreCase())
					  //.add(Restrictions.eq("Doctor.Id", employeeId))
					  .list();
			  
			  System.out.println("wardreamarksList=="+wardreamarksList.size());*/
			
			
			// code start for referral by atul
			
			  int referredDept = 0;
				if(box.getInt("referdepartment") != 0 && box.get("referdepartment") != null){
					referredDept = (Integer)box.getInt("referdepartment");
				}
				
			int referral = 0;
			System.out.println(box.get("referral"));
			if (((Integer) box.getInt("referral")) != 0) {
					if(box.get("referral")!=null)
					{
						try
						{
							referral = (Integer)box.getInt("referral");
						}
						catch(NumberFormatException e)
						{
							e.printStackTrace();
						}
					}
					
					if(referral==1)
					{
						
						Patient patientObj = (Patient)hbt.load(Patient.class, box.getInt("hinId"));
						patientObj.setPaymentStatus(null);
							hbt.update(patientObj);
							
						
						int referredByDoctorId = 0;
						int referredDepartmentId = 0;
						int referredHospitalId = 0;

						String referTo = null;
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
						
						if (box.get("referralNote") != null) {
							
							referralNote = (String) box.get("referralNote");
							
							opdPatientDetails.setReferralNotes(referralNote);
						}
						

						if (((Integer) box.getInt("referdepartment")) != 0) {
							referredDepartmentId = (Integer) box.getInt("referdepartment");
							MasDepartment referedDepartment = new MasDepartment();
							referedDepartment.setId(referredDepartmentId);
							opdPatientDetails.setReferredDeptInt(referedDepartment);
							
							if (((Integer) box.getInt("refereddoctor")) != 0) {
								referredByDoctorId = (Integer) box.getInt("refereddoctor");
								MasEmployee emp = new MasEmployee();
								emp.setId(referredByDoctorId);
								opdPatientDetails.setReferredDoctorInt(emp);
							}
							
							if(box.get("referralPriority") != null){
								referralPriority = (Integer)box.getInt("referralPriority");
								opdPatientDetails.setReferralPriority(referralPriority);
							}

							
						}

					
						
						if (box.get("referTo") != null && !box.get("referTo").equals("")) {
							 referTo =box.get("referTo");
							 opdPatientDetails.setReferredType(referTo);
							 opdPatientDetails.setReferredStatus("y");							
							if(referTo.equalsIgnoreCase("empanel")){
				
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
								
							
								
							}
						}
						
						
						
			
						
						
					}
				
			}
			
			
			
			
			
			// code end for referral by atul
			
			
			
			
			
			
			
			
			inpatient.setId(box.getInt("inpatientId"));
			opdPatientDetails.setInpatient(inpatient);
			MasEmployee masEmployee = new MasEmployee();
			if (box.getInt("empId") != 0) {
				masEmployee.setId(box.getInt("empId"));
				opdPatientDetails.setEmployee(masEmployee);
			}
			MasHospital masHospitalObj = new MasHospital();
			masHospitalObj.setId(box.getInt("hospitalId"));
			opdPatientDetails.setHospital(masHospitalObj);
			opdPatientDetails.setHeight(box.getString("height"));
			opdPatientDetails.setWhr(box.getString("whr"));
			opdPatientDetails.setVweight(box.getString("weight"));
			opdPatientDetails.setIdealWeight(box.getString("idealWeight"));
			opdPatientDetails.setPulse(box.getString("pulse"));
			opdPatientDetails.setBp(box.getString("bp"));
			if (box.getString("temperature")!=null) {
				opdPatientDetails.setTemperature(box.getString("temperature"));
			}
			opdPatientDetails.setConsultationTime(consultationTime);
			opdPatientDetails.setConsultationDate(new Date());
			opdPatientDetails.setInitialDiagnosis(box.getString("initialDiagnosis"));
			opdPatientDetails.setOpdDate(new Date());
			opdPatientDetails.setOpdTime(consultationTime);
			opdPatientDetails.setOnExamination(box.getString("onExamination"));
			opdPatientDetails.setRr(box.getString("rr"));
			opdPatientDetails.setBmi(box.getString("bmi"));
			opdPatientDetails.setCaseNotes(box.getString("clinicalNotes"));
			if(box.get("deptId") != null){							
				MasDepartment department = new MasDepartment();
				department.setId((Integer)box.getInt("deptId"));
				opdPatientDetails.setDepartment(department);
			}
	/*		int systemDiagnosisId = 0;
			if(!box.getString("systemDiagnosis").equals("")){
				String sysDiagnosis =box.getString("systemDiagnosis");
				int index1 = sysDiagnosis.lastIndexOf("[");
				int index2 = sysDiagnosis.lastIndexOf("]");
				index1++;
				systemDiagnosisId =Integer.parseInt(sysDiagnosis.substring(index1, index2));
				MasSystemDiagnosis systemDiagnosis = new MasSystemDiagnosis();
				systemDiagnosis.setId(systemDiagnosisId);
				opdPatientDetails.setSystemDiagnosis(systemDiagnosis);
			}*/
			
			
			if(box.getString("pregnancy")!=null && box.getString("pregnancy").equalsIgnoreCase("y") )
			{
				
				opdPatientDetails.setPregnancy("y");
				opdPatientDetails.setLmpDate(HMSUtil.convertStringTypeDateToDateType(box.getString("lmp_date")));
				opdPatientDetails.setEddDate(HMSUtil.convertStringTypeDateToDateType(box.getString("edd")));
				
			}
			hbt.save(opdPatientDetails);

			// --------------- values to be Opd Patient
			// History--------------------

			OpdPatientHistory opdPatientHistory = new OpdPatientHistory();

			MasDepartment md = new MasDepartment();
			/*md.setId(box.getInt("deptId"));
			opdPatientHistory.setDepartment(md);*/

			MasHospital mh = new MasHospital();
			mh.setId(box.getInt("hospitalId"));
			opdPatientHistory.setHospital(mh);

			Patient p = new Patient();
			p.setId(box.getInt("hinId"));
			opdPatientHistory.setHin(p);


			opdPatientHistory.setLastChgTime(consultationTime);
			opdPatientHistory.setLastChgBy(box.getString("userName"));

			opdPatientHistory.setStatus("y");
			opdPatientHistory.setLastChgDate(new Date());

			opdPatientHistory.setPresentComplain(box.getString("presentComplain"));
			opdPatientHistory.setPastMedicalHistory(box.getString("pastMedicalHistory"));
			opdPatientHistory.setRiskFactor(box.getString("riskFactor"));

			opdPatientHistory.setIpOpPacStatus("IP");

			opdPatientHistory.setOpdPatientDetails(opdPatientDetails);
			opdPatientHistory.setInpatient(inpatient);
			/*if(wardreamarksList.size()>0){*/
				/*MasDepartment md = new MasDepartment();*/
			if(referredDept!=0){
				md.setId(referredDept);
				opdPatientHistory.setDepartment(md);
			}else{
				/*MasDepartment md = new MasDepartment();*/
				md.setId(box.getInt("deptId"));
				opdPatientHistory.setDepartment(md);
			}
			hbt.save(opdPatientHistory);

			Vector familyHistoryArray = box.getVector("familyHistory");

			if(familyHistoryArray!=null && familyHistoryArray.size() > 0) {
				for (int i = 0; i < familyHistoryArray.size(); i++) {
					if(Integer.parseInt(familyHistoryArray.get(i).toString())!=0) {
						MasMedicalExamFamilyHis masExamFamilyHis = new MasMedicalExamFamilyHis();
						masExamFamilyHis.setHin(p);
						PatientFamilyHistory familyHistory = new PatientFamilyHistory();
						familyHistory.setId(Integer.parseInt(familyHistoryArray.get(i).toString()));
						masExamFamilyHis.setPatientFamilyHistory(familyHistory);
						hbt.save(masExamFamilyHis);
					}
				}
			}

			String query = "";
			/*List objectList = new ArrayList();*/
			List<Object[]> objectList = new ArrayList<Object[]>();
			Vector diagnosisIdAray = box.getVector("diagnosisId");
			String icdNames ="";
			if (diagnosisIdAray != null) {
				for (int i = 0; i < diagnosisIdAray.size(); i++) {
					DischargeIcdCode dischargeIcdCode = new DischargeIcdCode();
					dischargeIcdCode.setHin(p);
					MasIcd masIcd = new MasIcd();

					if (diagnosisIdAray.get(i) != null) {
						if (!diagnosisIdAray.get(i).equals("0")) {
							query = "select icd_id, icd_name from mas_icd where icd_code='"
								+ diagnosisIdAray.get(i) + "'";
							objectList = (List<Object[]>) session.createSQLQuery(query).list();
							System.out.println("objectList.get(0)[0]"+objectList.get(0)[0]);
							masIcd.setId(Integer.parseInt(objectList.get(0)[0].toString()));
							icdNames+=objectList.get(0)[1]+", ";
							dischargeIcdCode.setIcd(masIcd);
							dischargeIcdCode
							.setAddEditDate(new Date());
							dischargeIcdCode.setAddEditTime(consultationTime);
							dischargeIcdCode.setStatus("y");
							dischargeIcdCode.setDiagnosisStatus("p");
							dischargeIcdCode.setInpatient(inpatient);
							dischargeIcdCode.setOpdPatientDetails(opdPatientDetails);
							hbt.save(dischargeIcdCode);
						}
					}
				}
				
			}
			if(!icdNames.equals("")){
				icdNames = icdNames.substring(0, (icdNames.length()-2));
			}
			
			opdPatientDetails.setIcd(icdNames);
			hbt.update(opdPatientDetails);
			//Treartment
			PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();
			int item_class_id = 0;
			if(itemIdList.size() > 0){
				
				Patient patient = new Patient();
				patient.setId(hinId);
				patientPrescriptionHeader.setNipStatus("n");
				patientPrescriptionHeader.setHin(patient);
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				patientPrescriptionHeader.setDepartment(masDepartment);
				Inpatient ip = new Inpatient();
				ip.setId(inpatientId);
				patientPrescriptionHeader.setInpatient(inpatient);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				patientPrescriptionHeader.setHospital(masHospital);
				patientPrescriptionHeader.setStatus("p");
				patientPrescriptionHeader
						.setPrescriptionDate(date);
				patientPrescriptionHeader.setPrescriptionTime(consultationTime);
				/**
				 * Code By Ritu 
				 * Created Foreign key relation for emp id in Database
				 */
				MasEmployee employee = new MasEmployee();
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
				patientPrescriptionHeader.setOpdPatientDetails(opdPatientDetails);
				
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
				patientPrescriptionHeader.setOtherTreatment(box.getString("otherTreatment"));
				
		            int ItemClassificationIdForNIP = 0;
					ItemClassificationIdForNIP = Integer.parseInt(HMSUtil.getValuesFromPropertiesFile("adt.properties", "ItemClassificationId"));
		
	
					for(int iCId :classificationList)
					{
						if(iCId==ItemClassificationIdForNIP)
						{
							patientPrescriptionHeader.setNipStatus("y");
							break;
						}
					}
				
				hbt.save(patientPrescriptionHeader);
			}/** else part added by Ritu for other treatment details **/
	/*		else if(itemIdList.size() == 0 && mapForDS.get("otherTreatment")!=null && !(mapForDS.get("otherTreatment")).equals("")){

				Patient patient = new Patient();
				patient.setId(hinId);
				patientPrescriptionHeader.setHin(patient);
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				patientPrescriptionHeader.setDepartment(masDepartment);
				Visit visit = new Visit();
				visit.setId(visitId);
				patientPrescriptionHeader.setVisit(visit);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				patientPrescriptionHeader.setHospital(masHospital);
				patientPrescriptionHeader.setStatus("p");
				patientPrescriptionHeader
						.setPrescriptionDate(consultationDateToInsert);
				patientPrescriptionHeader.setPrescriptionTime(consultationTime);
				
				MasEmployee employee = new MasEmployee();
				employee.setId(empId);
				patientPrescriptionHeader.setEmp(employee);
				//int prescriptionNo=getTransactionSequenceNoForPrescriptionNo(mapForDS);
				Map<String, Object> adMap = new HashMap<String, Object>();
			      adMap.put("tableObjectName", "PATIENT_PRESCRIPTION_HEADER");            
		            adMap.put("isHospitalWise", "y");
		            adMap.put("hospitalId", 1);
		            adMap.put("isYearly", "n");            
		            adMap.put("isMonthly", "n");
		            adMap.put("isPrefix", "n");
		
		        int prescriptionNo = Integer.parseInt(HMSUtil.generateTransactionSequence(adMap, session, hbt));
				
			

				patientPrescriptionHeader.setPrescriptionNo(prescriptionNo);
				patientPrescriptionHeader.setOpdPatientDetails(opdPatientDetails);
		
				patientPrescriptionHeader.setInjectionStatus("n");
				patientPrescriptionHeader.setOtherTreatment((String)mapForDS.get("otherTreatment"));
				
				hbt.save(patientPrescriptionHeader);
			
				
			}*/
			if (itemIdList.size() > 0 ) {
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
						/*if (totalList.get(i) != null && !totalList.get(i).equals("")) {
							patientPrescriptionDetails.setTotal(Math.round(totalList.get(i).floatValue()));
						}*/
						if (totalList.get(i) != null && !totalList.get(i).equals("") && totalList.get(i) != 0) {
							patientPrescriptionDetails.setTotal(totalList.get(i));
						}else{
							patientPrescriptionDetails.setTotal(1);
						}
						patientPrescriptionDetails.setGivenQty(0);
					
					
					//patientPrescriptionDetails.setType(typeLeftRightList.get(i));
					
					//patientPrescriptionDetails.setInstruction(instructionList.get(i));
					
					
					patientPrescriptionDetails.setPrescription(patientPrescriptionHeader);
				
					patientPrescriptionDetails.setDetailStatus("a");
					
					
			/*		List<MasStoreItem> storeItemList=new ArrayList<MasStoreItem>();
					storeItemList=hbt.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemCategory as ic where item.Id="+itemIdList.get(i)+" and ic.Id="+item_category_id);
					if(storeItemList.size() > 0){
						patientPrescriptionDetails.setInjectionStatus("p");
					}else{
						patientPrescriptionDetails.setInjectionStatus("n");
					}
					if(ctList.get(i).equals("y")){
						patientPrescriptionDetails.setCt("yes");
					}else{
						patientPrescriptionDetails.setCt("no");
					}
					*/
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
					storeItemList=hbt.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemClass as ic where item.Id="+itemIdList.get(i)+" and ic.Id="+item_class_id+" and item.IssueFrom='i'");
					if(storeItemList.size() > 0){
						patientPrescriptionDetails.setInjectionStatus("p");
					}else{
						patientPrescriptionDetails.setInjectionStatus("n");
					}
					
			/*		if(visitObjToUpdate!=null && visitObjToUpdate.getVisitStatus().equalsIgnoreCase("p") && parkPrescriptionIds!=null && !parkPrescriptionIds.get(i).equals(0)){
						hbt.update(patientPrescriptionDetails);
					}else{
						hbt.save(patientPrescriptionDetails);
					}*/
					
					hbt.save(patientPrescriptionDetails);
						//opdPatientListObject.add(patientPrescriptionDetails);
						//prevent insulin for nursing station and available in pharmacy only in readonly mod
	
					
					IpdMedicineIssueHeader imh = new IpdMedicineIssueHeader();
					imh.setPatientPrescriptionDetails(patientPrescriptionDetails);
					imh.setIssuedQuantity(0);
					imh.setStatus("i");
					Users user = new Users();
					user.setId(box.getInt("userId"));
					imh.setLastChgBy(user);
					imh.setLastChgDate(new Date());
					imh.setLastChgTime(consultationTime);
					hbt.save(imh);
					hbt.flush();
					
					/**
					 * This Code is use for Injection Appointment
					 * Code By Ritu Sahu
					 * Date 07 Nov 2011
					 */
					

					/**
					 * END Of COde
					 * This Code is use for Injection
					 * Code By Ritu Sahu
					 * Date 07 Nov 2011
					 */
				}
				}
			}
			//-------------code by anamika for detention-----------------------//
	
			//-------------------------------------------------
			if(otherMedicineList != null && otherMedicineList.size() > 0){
				String sqlItemId="";
				int itemId = 0;
				/*PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();
				Patient patient = new Patient();
				patient.setId(hinId);
				patientPrescriptionHeader.setHin(patient);
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				patientPrescriptionHeader.setDepartment(masDepartment);
				Visit visit = new Visit();
				visit.setId(visitId);
				patientPrescriptionHeader.setVisit(visit);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				patientPrescriptionHeader.setHospital(masHospital);
				patientPrescriptionHeader.setStatus("p");
				patientPrescriptionHeader
						.setPrescriptionDate(consultationDateToInsert);
				patientPrescriptionHeader.setPrescriptionTime(consultationTime);
				*//**
				 * Code By Ritu 
				 * Created Foreign key relation for emp id in Database
				 *//*
				MasEmployee employee = new MasEmployee();
				employee.setId(empId);
				patientPrescriptionHeader.setEmp(employee);
				
				*//**
				 * End of code by Ritu
				 *//*
				int prescriptionNo=getTransactionSequenceNoForPrescriptionNo(mapForDS);
				patientPrescriptionHeader.setPrescriptionNo(prescriptionNo);
		
				for(int i = 0; i < injCategoryList.size(); i++){
					if(injCategoryList.get(i).equals("y")){
						patientPrescriptionHeader.setInjectionStatus("p");
						break;
					}else{
						patientPrescriptionHeader.setInjectionStatus("n");
					}
				}
				
				 * End Of Code This block is use for Check Injection in Prescription List
				 
				
				hbt.save(patientPrescriptionHeader);*/

				//List<MasStoreItem> itemCodeList = new ArrayList<MasStoreItem>();
				String otherItem = "";
				if(otherMedicineList.size() >0){
					
					if(patientPrescriptionHeader.getId()==null)
					{
						Patient patient = new Patient();
						patient.setId(hinId);
						patientPrescriptionHeader.setHin(patient);
						MasDepartment masDepartment = new MasDepartment();
						masDepartment.setId(departmentId);
						patientPrescriptionHeader.setDepartment(masDepartment);
						Inpatient ip = new Inpatient();
						ip.setId(inpatientId);
						patientPrescriptionHeader.setInpatient(inpatient);
						MasHospital masHospital = new MasHospital();
						masHospital.setId(hospitalId);
						patientPrescriptionHeader.setHospital(masHospital);
						patientPrescriptionHeader.setStatus("p");
						patientPrescriptionHeader
								.setPrescriptionDate(date);
						patientPrescriptionHeader.setPrescriptionTime(consultationTime);
						
						MasEmployee employee = new MasEmployee();
						employee.setId(empId);
						patientPrescriptionHeader.setEmp(employee);
						//int prescriptionNo=getTransactionSequenceNoForPrescriptionNo(mapForDS);
						Map<String, Object> adMap = new HashMap<String, Object>();
					      adMap.put("tableObjectName", "PATIENT_PRESCRIPTION_HEADER");            
				            adMap.put("isHospitalWise", "y");
				            adMap.put("hospitalId", 1);
				            adMap.put("isYearly", "n");            
				            adMap.put("isMonthly", "n");
				            adMap.put("isPrefix", "n");
				
				        int prescriptionNo = Integer.parseInt(HMSUtil.generateTransactionSequence(adMap, session, hbt));
						
					

						patientPrescriptionHeader.setPrescriptionNo(prescriptionNo);
						patientPrescriptionHeader.setOpdPatientDetails(opdPatientDetails);
				
						patientPrescriptionHeader.setInjectionStatus("n");
						patientPrescriptionHeader.setOtherTreatment(box.getString("otherTreatment"));
						hbt.save(patientPrescriptionHeader);
					}
					patientPrescriptionHeader.setNipStatus("y");
					hbt.update(patientPrescriptionHeader);
				
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
					
						int k=0;
				for(int i = itemIdList.size(); i <otherMedicineList.size()+itemIdList.size(); i++){
					MasStoreItem masItem = new MasStoreItem();
					if(otherMedicineList.get(k) != null && !otherMedicineList.get(k).equals("")){
						otherItem =(String)otherMedicineList.get(k);
						masItem.setNomenclature(otherMedicineList.get(k));
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
						
						if (uomQtyList .get(i) != null && !uomQtyList .get(i).equals("")) {
							masItem.setADispQty(uomQtyList .get(i));
							}
						System.out.println("uomQtyList="+uomQtyList);
						totalNip++;
						masItem.setPvmsNo(nipCode+totalNip);
						
						MasItemType masItemType = new MasItemType();
						masItemType.setId(itemTypeId);
						masItem.setItemType(masItemType);
						MasHospital masHospital = new MasHospital();
						masHospital.setId(hospitalId);
						masItem.setHospital(masHospital);
						masItem.setHighValueDrug("n");
						MasItemClassification Mic = new MasItemClassification();
						Mic.setId(itemClassificationId);
						masItem.setItemClassification(Mic);
						MasStoreGroup msgrp = new MasStoreGroup();
						msgrp.setId(groupId);
						masItem.setGroup(msgrp);
						//masItem.setLastChgBy(userName);
						masItem.setLastChgDate(date);
						masItem.setLastChgTime(consultationTime);
						
						/*itemCodeList =session.createCriteria(MasStoreItem.class).add(Restrictions.like("PvmsNo", "NIV%")).add(Restrictions.eq("Hospital.Id", hospitalId))
						.addOrder(Order.desc("Id")).setMaxResults(1).list();
						String itemNo = "";
						if(itemCodeList.size()>0){
							MasStoreItem masStoreItem =itemCodeList.get(0);
							String itemCode = masStoreItem.getPvmsNo();
							StringTokenizer str = new StringTokenizer(itemCode, "/");
							String itemNivCode = "";
							while (str.hasMoreTokens()) {

								itemNivCode = str.nextToken();

							}
							int itemNiv =Integer.parseInt(itemNivCode)+1;
							itemNo = "NIV/"+itemNiv;
						}else{
							itemNo = "NIV/011"; 
						}*/
						//masItem.setPvmsNo("temp");
						
						hbt.save(masItem);
						

				
					PatientPrescriptionDetails patientPrescriptionDetails = new PatientPrescriptionDetails();
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
					patientPrescriptionDetails.setInjectionStatus("n");
					
					if(ctList.get(i).equals("y")){
						patientPrescriptionDetails.setCt("yes");
					}else{
						patientPrescriptionDetails.setCt("no");
					}
					
					
					hbt.save(patientPrescriptionDetails);
					IpdMedicineIssueHeader imh = new IpdMedicineIssueHeader();
					imh.setPatientPrescriptionDetails(patientPrescriptionDetails);
					imh.setIssuedQuantity(0);
					imh.setStatus("i");
					Users user = new Users();
					user.setId(box.getInt("userId"));
					imh.setLastChgBy(user);
					imh.setLastChgDate(new Date());
					imh.setLastChgTime(consultationTime);
					hbt.save(imh);
					hbt.flush();
				
					/**
					 * This Code is use for Injection Appointment
					 * Code By Ritu Sahu
					 * Date 07 Nov 2011
					 */
					
	
					}
					/**
					 * END Of COde
					 * This Code is use for Injection
					 * Code By Ritu Sahu
					 * Date 07 Nov 2011
					 */
					k++;
					
				}
			}
			}
			
			//end treatment
			
			
			
		/*	int hdb = box.getInt("hdb");
			boolean otherDrug = false;
			for (int l = 1; l <= hdb; l++) {				
				if(!box.getString("otherMedicine"+l).trim().equals("")){
					otherDrug = true;
					break;
				}
			}
			System.out.println("otherDrug"+otherDrug);
			
			List<Integer> itemIdList = new ArrayList<Integer>();
			String sqlItemId="";
			for (int i = 1; i <= hdb; i++) {
				
				System.out.println("box.getString(nomenclaturei)"+box.getString("nomenclature"+i));
				if(!box.getString("nomenclature"+i).equals("")){
				
				int itemId =box.getInt("itemId"+i);
				
				if(sqlItemId.equals("")){
					sqlItemId=""+itemId;
				}else{
					sqlItemId +=" , "+itemId;
				}
				itemIdList.add(itemId);
				}else{
					itemIdList.add(0);
				
				}
			}
			
			PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();
			int item_class_id = 0;
			
			
			int totalNip = 0;
			String otherItem = "";
			if(otherDrug==false){
				if(!box.getString("nomenclature"+1).trim().equals("") || !box.getString("otherMedicine"+1).trim().equals(""))
				{
				patientPrescriptionHeader.setNipStatus("n");
				patientPrescriptionHeader.setHin(p);				
				patientPrescriptionHeader.setDepartment(md);				
				patientPrescriptionHeader.setInpatient(inpatient);				
				patientPrescriptionHeader.setHospital(masHospitalObj);
				patientPrescriptionHeader.setStatus("p");
				patientPrescriptionHeader.setPrescriptionDate(new Date());
				patientPrescriptionHeader.setPrescriptionTime(consultationTime);				
				patientPrescriptionHeader.setEmp(masEmployee);
				
	        	Map<String, Object> adMap = new HashMap<String, Object>();
			      adMap.put("tableObjectName", "PATIENT_PRESCRIPTION_HEADER");            
		            adMap.put("isHospitalWise", "y");
		            adMap.put("hospitalId", masHospitalObj.getId());
		            adMap.put("isYearly", "n");            
		            adMap.put("isMonthly", "n");
		            adMap.put("isPrefix", "n");
		
		        int prescriptionNo = Integer.parseInt(HMSUtil.generateTransactionSequence(adMap, session, hbt));
				patientPrescriptionHeader.setPrescriptionNo(prescriptionNo);
				patientPrescriptionHeader.setOpdPatientDetails(opdPatientDetails);
				
				
				
				
				
				
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
				
				
				hbt.save(patientPrescriptionHeader);
			}}
			else if(otherDrug){
				if(!box.getString("nomenclature"+1).trim().equals("") || !box.getString("otherMedicine"+1).trim().equals(""))
				{
				patientPrescriptionHeader.setNipStatus("y");
				
				
				try
				{
					nipCode = HMSUtil.getProperties("adt.properties", "ItemClassificationCodeNIP");
					itemClassificationId = Integer.parseInt(HMSUtil.getProperties("adt.properties", "ItemClassificationId"));
					groupId = Integer.parseInt(HMSUtil.getProperties("adt.properties", "ItemGroupId"));
					System.out.println("ItemGroupIdIn"+groupId);
					sectionId = Integer.parseInt(HMSUtil.getProperties("adt.properties", "SectionIdForDrugs"));
					System.out.println("sectionId"+sectionId);
					itemTypeId = Integer.parseInt(HMSUtil.getProperties("adt.properties", "ItemTypeId"));
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				totalNip = session.createCriteria(MasStoreItem.class).createAlias("ItemClassification", "ic").add(Restrictions.eq("ic.Classification", nipCode)).add(Restrictions.eq("Hospital.Id", mh.getId())).list().size();
				
				

				patientPrescriptionHeader.setHin(p);				
				patientPrescriptionHeader.setDepartment(md);				
				patientPrescriptionHeader.setInpatient(inpatient);				
				patientPrescriptionHeader.setHospital(masHospitalObj);
				patientPrescriptionHeader.setStatus("p");
				patientPrescriptionHeader.setPrescriptionDate(new Date());
				patientPrescriptionHeader.setPrescriptionTime(consultationTime);				
				patientPrescriptionHeader.setEmp(masEmployee);
				
				Map<String, Object> adMap = new HashMap<String, Object>();
			      adMap.put("tableObjectName", "PATIENT_PRESCRIPTION_HEADER");            
		            adMap.put("isHospitalWise", "y");
		            adMap.put("hospitalId", masHospitalObj.getId());
		            adMap.put("isYearly", "n");            
		            adMap.put("isMonthly", "n");
		            adMap.put("isPrefix", "n");
		
		        int prescriptionNo = Integer.parseInt(HMSUtil.generateTransactionSequence(adMap, session, hbt));
				
			

				patientPrescriptionHeader.setPrescriptionNo(prescriptionNo);
				patientPrescriptionHeader.setOpdPatientDetails(opdPatientDetails);
		
				patientPrescriptionHeader.setInjectionStatus("n");
				
				
				
				hbt.save(patientPrescriptionHeader);
			
				
			}}
			
			System.out.println("itemIdList"+itemIdList.size());

				for (int i = 1; i <= itemIdList.size(); i++) {
				    System.out.println("box.getString(nomenclaturei)"+box.getString("nomenclature"+i));
				    System.out.println("itemIdList.get(i-1)"+itemIdList.get(i-1));
					if(!box.getString("nomenclature"+i).trim().equals("") && box.getString("otherMedicine"+i).trim().equals("")){
						List<MasStoreItem> itemCodeList = new ArrayList<MasStoreItem>();
						PatientPrescriptionDetails patientPrescriptionDetails = new PatientPrescriptionDetails();
						if(itemIdList.get((i-1)) != null){
							MasStoreItem masStoreItem = new MasStoreItem();
							masStoreItem.setId(itemIdList.get(i-1));
						patientPrescriptionDetails.setItem(masStoreItem);
						}
						if (box.get("frequency"+i) != null && !box.getString("frequency"+i).equals("")) {
							MasFrequency masFrequency = new MasFrequency();
							masFrequency.setId(box.getInt("frequency"+i));
							patientPrescriptionDetails.setFrequency(masFrequency);
							}
							if (box.get("dosage"+i) != null && !box.getString("dosage"+i).equals("") && !box.getString("dosage"+i).equals("0")) {
								patientPrescriptionDetails.setDosage(box.getString("dosage"+i));
							}else{
								patientPrescriptionDetails.setDosage("0");
							}
							if (box.get("remarks"+i) != null && !box.getString("remarks"+i).equals("")) {
								patientPrescriptionDetails.setRemarks(box.getString("remarks"+i));
							}
							
							if (box.get("noOfDays"+i) != null && !box.getString("noOfDays"+i).equals("")) {
								patientPrescriptionDetails.setNoOfDays(box.getInt("noOfDays"+i));
							}
							if (box.get("route"+i) != null && !box.getString("route"+i).equals("")) {
								patientPrescriptionDetails.setRoute(box.getString("route"+i));
							}
							
							if (box.get("total"+i) != null && !box.getString("total"+i).equals("") && box.getInt("total"+i) != 0) {
								patientPrescriptionDetails.setTotal(box.getInt("total"+i));
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
						storeItemList=hbt.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemClass as ic where item.Id="+itemIdList.get(i-1)+" and ic.Id="+item_class_id);
						if(storeItemList.size() > 0){
							patientPrescriptionDetails.setInjectionStatus("p");
						}else{
							patientPrescriptionDetails.setInjectionStatus("n");
						}
			
						
						hbt.save(patientPrescriptionDetails);
						
                        // insert in ipd_medicine_issue table
						
						IpdMedicineIssueHeader imh = new IpdMedicineIssueHeader();
						imh.setPatientPrescriptionDetails(patientPrescriptionDetails);
						imh.setIssuedQuantity(0);
						imh.setStatus("i");
						Users user = new Users();
						user.setId(box.getInt("userId"));
						imh.setLastChgBy(user);
						imh.setLastChgDate(new Date());
						imh.setLastChgTime(consultationTime);						
						hbt.save(imh);
						hbt.flush();
						
						
					}
					else if(box.getString("nomenclature"+i).trim().equals("") && !box.getString("otherMedicine"+i).trim().equals(""))
					{
						otherItem = "";
						MasStoreItem masItem = new MasStoreItem();
						if(box.get("itemConversionId"+i) != null && !box.getString("itemConversionId"+i).trim().equals("")){
							otherItem =box.getString("otherMedicine"+i);
							masItem.setNomenclature(otherItem);
							MasStoreSection masStoreSection = new MasStoreSection();
							masStoreSection.setId(sectionId);
							masItem.setSection(masStoreSection);
							masItem.setStatus("y");
							masItem.setBrandedGeneric("B");
							
							if (box.get("itemConversionId"+i) != null && !box.getString("itemConversionId"+i).trim().equals("")) {
								MasStoreItemConversion masStoreItemConversion = new MasStoreItemConversion();
								masStoreItemConversion.setId(box.getInt("itemConversionId"+i));
								masItem.setItemConversion(masStoreItemConversion);
								}
							
							if (box.get("itemClass"+i) != null && !box.getString("itemClass"+i).trim().equals("")) {
								 MasItemClass masItemClass = new MasItemClass();
								 masItemClass.setId(box.getInt("itemClass"+i));
								masItem.setItemClass(masItemClass);
								}
							
							if (box.get("dispensingUnit"+i) != null && !box.getString("dispensingUnit"+i).trim().equals("")) {
								masItem.setDispUnit(box.getString("dispensingUnit"+i));
								}
							totalNip++;
							masItem.setPvmsNo(nipCode+totalNip);
							
							MasItemType masItemType = new MasItemType();
							masItemType.setId(itemTypeId);
							masItem.setItemType(masItemType);
							
							
							masItem.setHospital(mh);
							masItem.setHighValueDrug("n");
							MasItemClassification Mic = new MasItemClassification();
							Mic.setId(itemClassificationId);
							masItem.setItemClassification(Mic);
							MasStoreGroup msgrp = new MasStoreGroup();
							msgrp.setId(groupId);
							System.out.println("groupId"+groupId);
							masItem.setGroup(msgrp);
							masItem.setLastChgBy(box.getString("userName"));
							masItem.setLastChgDate(new Date());
							masItem.setLastChgTime(consultationTime);
							
						
							
							hbt.save(masItem);
							

					
						PatientPrescriptionDetails patientPrescriptionDetails = new PatientPrescriptionDetails();
						if(masItem.getId() != null){
							MasStoreItem masStoreItem = new MasStoreItem();
							masStoreItem.setId(masItem.getId());
						patientPrescriptionDetails.setItem(masStoreItem);
						}
						if (box.get("frequency"+i) != null && !box.getString("frequency"+i).equals("")) {
							MasFrequency masFrequency = new MasFrequency();
							masFrequency.setId(box.getInt("frequency"+i));
							patientPrescriptionDetails.setFrequency(masFrequency);
							}
							if (box.get("dosage"+i) != null && !box.getString("dosage"+i).equals("") && !box.getString("dosage"+i).equals("0")) {
								patientPrescriptionDetails.setDosage(box.getString("dosage"+i));
							}else{
								patientPrescriptionDetails.setDosage("0");
							}
							if (box.get("remarks"+i) != null && !box.getString("remarks"+i).equals("")) {
								patientPrescriptionDetails.setRemarks(box.getString("remarks"+i));
							}
							
							if (box.get("noOfDays"+i) != null && !box.getString("noOfDays"+i).equals("")) {
								patientPrescriptionDetails.setNoOfDays(box.getInt("noOfDays"+i));
							}
							if (box.get("route"+i) != null && !box.getString("route"+i).equals("")) {
								patientPrescriptionDetails.setRoute(box.getString("route"+i));
							}
							
							if (box.get("total"+i) != null && !box.getString("total"+i).equals("") && box.getInt("total"+i) != 0) {
								patientPrescriptionDetails.setTotal(box.getInt("total"+i));
							}else{
								patientPrescriptionDetails.setTotal(1);
							}
						patientPrescriptionDetails.setPrescription(patientPrescriptionHeader);
						patientPrescriptionDetails.setGivenQty(0);
						patientPrescriptionDetails.setDetailStatus("a");
						List<MasStoreItem> storeItemList=new ArrayList<MasStoreItem>();
						if(injCategoryList.equals("y")){
							patientPrescriptionDetails.setInjectionStatus("p");
						}else{
							patientPrescriptionDetails.setInjectionStatus("n");
						}
						
						if(ctList.get(i).equals("y")){
							patientPrescriptionDetails.setCt("yes");
						}else{
							patientPrescriptionDetails.setCt("no");
						}
						
						
						hbt.save(patientPrescriptionDetails);
						
						
						// insert in ipd_medicine_issue table
						
						IpdMedicineIssueHeader imh = new IpdMedicineIssueHeader();
						imh.setPatientPrescriptionDetails(patientPrescriptionDetails);
						imh.setIssuedQuantity(0);
						imh.setStatus("i");
						Users user = new Users();
						user.setId(box.getInt("userId"));
						imh.setLastChgBy(user);
						imh.setLastChgDate(new Date());
						imh.setLastChgTime(consultationTime);
						hbt.save(imh);
						hbt.flush();
						
					
						}
					
						
					}
					
				}
				*/
				

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
							
				
				if(patientList.size()!=0)
				{
					if(patientList.get(0).getPatientType().getPatientTypeName().equals(patientTypeNameForHAL))
					{
						dgOrderBillingStatus ="y";
					}
					else if(patientList.get(0).getPatientType().getPatientTypeName().equals(patientTypeNameForOther))
					{
						if(patientList.get(0).getBillable().equals("y"))
						    dgOrderBillingStatus ="y"; // change by vinay on 5th octber 2018  
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
					//System.out.println("headerinvestigationDateList "+headerinvestigationDateList +" investigationDateList="+investigationDateList);
					DgOrderhd dgOrderhd = new DgOrderhd();
					dgOrderhd.setOrderDate(HMSUtil.convertStringTypeDateToDateType(investigtionDate));
					dgOrderhd.setOrderTime(consultationTime);
					masHospitalObj.setId(hospitalId);
					dgOrderhd.setHospital(masHospitalObj);
					Patient patient = new Patient();
					patient.setId(hinId);
					dgOrderhd.setHin(patient);
					dgOrderhd.setDepartment(new MasDepartment(departmentId));
					if (empId != 0) {
						masEmployee.setId(empId);
						dgOrderhd.setPrescribedBy(masEmployee);
					}
				
					dgOrderhd.setBillingStatus(dgOrderBillingStatus);
					dgOrderhd.setPatientType("IP");
					dgOrderhd.setTestType("Regular");
					dgOrderhd.setCreatedby(box.getString("userName"));
					dgOrderhd.setCreatedon(date);
			       String orderSeqNo = HMSUtil.generateTransactionSequence(adMap, session, hbt);
					    dgOrderhd.setOrderNo(orderSeqNo);
					    Inpatient ip = new Inpatient();
						ip.setId(inpatientId);
						dgOrderhd.setInpatient(ip);
					dgOrderhd.setClinicalNote(box.getString("clinicalNotes1"));
					dgOrderhd.setOrderStatus("P");
					dgOrderhd.setLabOrderStatus("P");
					dgOrderhd.setLastChgBy(new Users(box.getInt("userId")));
					dgOrderhd.setLastChgDate(date);
					dgOrderhd.setLastChgTime(consultationTime);
					//dgOrderhd.setInvestigationRequestionNo(patientInvestigationHeader);
					if(box.get("otherInvestigation")!=null)
					dgOrderhd.setOtherInvestigation(box.getString("otherInvestigation").toString().trim());
			
					hbt.save(dgOrderhd);
				
					for (int i = 0; i < chargeCodeIdList.size(); i++) {
System.out.println(i+" headerList="+investigtionDate +" invdate="+investigationDateList.get(i));
						if(investigtionDate.equals(investigationDateList.get(i))){
							
						
						
						MasChargeCode masChargeCode = new MasChargeCode();
						masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
						
											DgOrderdt dgOrderdt = new DgOrderdt();
											dgOrderdt.setOrderhd(dgOrderhd);
											masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
											dgOrderdt.setChargeCode(masChargeCode);
											//dgOrderdt.setOrderQty(quantityList.get(i));
											dgOrderdt.setBillingStatus(dgOrderBillingStatus);
											dgOrderdt.setCreatedby(box.getString("userName"));
											//dgOrderdt.setCreatedon(consultationDateToInsert);
											dgOrderdt.setCreatedon(HMSUtil.convertStringTypeDateToDateType(investigtionDate));
											dgOrderdt.setLastChgBy(new Users(box.getInt("userId")));
											dgOrderdt.setLastChgDate(date);
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
											hbt.save(dgOrderdt);
						}//end date comparision
					}//inner dt loop
				//	headerinvestigationDateList.removeAll(Arrays.asList(investigtionDate));
				}
				}//outer loop for hd
				
			}
			
			
			
/*			
			int hiddenValue = box.getInt("hiddenValue");
			String chargeCodeName = "";
			for (int l = 1; l <= hiddenValue; l++) {
				chargeCodeName = box.getString("chargeCodeName"+l);
				if(!chargeCodeName.equals("")){
					break;
				}
			}
			if (!chargeCodeName.equals("")) {

				PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();
				patientInvestigationHeader.setHin(p);
				patientInvestigationHeader.setDepartment(md);
				patientInvestigationHeader.setInpatient(inpatient);
				patientInvestigationHeader.setHospital(masHospitalObj);
				patientInvestigationHeader.setStatus("p");
				patientInvestigationHeader.setInvestigationDate(new Date());
				patientInvestigationHeader.setInvestigationTime(consultationTime);
				patientInvestigationHeader.setClinicalNotes(box.getString("clinicalNotes1"));
				patientInvestigationHeader.setOpdPatientDetails(opdPatientDetails);
				hbt.save(patientInvestigationHeader);

				DgOrderhd dgOrderhd = new DgOrderhd();
				dgOrderhd.setOrderDate(new Date());
				dgOrderhd.setOrderTime(consultationTime);
				dgOrderhd.setHospital(masHospitalObj);
				dgOrderhd.setHin(p);
				dgOrderhd.setDepartment(md);
				dgOrderhd.setPrescribedBy(masEmployee);

				dgOrderhd.setPatientType("IP");
				dgOrderhd.setTestType("Regular");
				dgOrderhd.setCreatedby(box.getString("userName"));
				dgOrderhd.setCreatedon(new Date());
                 
				Map<String, Object> adMap = new HashMap<String, Object>();
				adMap.put("tableObjectName", "DgOrderhd");
				adMap.put("isHospitalWise", "y");
				adMap.put("hospitalId", 1);
				adMap.put("isYearly", "y");
				adMap.put("isMonthly", "n");
				adMap.put("isPrefix", "n");

				String orderSeqNo = HMSUtil.generateTransactionSequence(adMap, session, hbt);

				
				String orderSeqNo = generateOrderNumber(box.getInt("hospitalId"));
				dgOrderhd.setOrderNo(orderSeqNo);
				dgOrderhd.setInpatient(inpatient);

				dgOrderhd.setClinicalNote(box.getString("clinicalNotes1"));
				dgOrderhd.setOrderStatus("P");
				dgOrderhd.setLabOrderStatus("P");
				Users user = new Users();
				user.setId(box.getInt("userId"));
				dgOrderhd.setLastChgBy(user);
				dgOrderhd.setLastChgDate(new Date());
				dgOrderhd.setLastChgTime(consultationTime);
				dgOrderhd.setInvestigationRequestionNo(patientInvestigationHeader);
				hbt.save(dgOrderhd);
				for (int i = 1; i <= hiddenValue; i++) {
					if(!box.getString("chargeCodeName" + i).equals("")){
					PatientInvestigationDetails patientInvestigationDetails = new PatientInvestigationDetails();
					patientInvestigationDetails.setInvestigationHeader(patientInvestigationHeader);
					String chargeCodeNameWithId =box.getString("chargeCodeName" + i);
					int index1 = chargeCodeNameWithId.lastIndexOf("[");
					int index2 = chargeCodeNameWithId.lastIndexOf("]");
					index1++;
					String chargeCodeId = chargeCodeNameWithId.substring(index1,index2);
					MasChargeCode masChargeCode = new MasChargeCode();
					masChargeCode.setId(Integer.parseInt(chargeCodeId));
					patientInvestigationDetails.setChargeCode(masChargeCode);
					patientInvestigationDetails.setQuantity(1);   // default quantity is 1
					patientInvestigationDetails.setReferToMh(box.getString("referToMh"+i));

					hbt.save(patientInvestigationDetails);

					DgOrderdt dgOrderdt = new DgOrderdt();
					dgOrderdt.setOrderhd(dgOrderhd);
					masChargeCode.setId(Integer.parseInt(chargeCodeId));
					dgOrderdt.setChargeCode(masChargeCode);
					dgOrderdt.setOrderQty(1);

					dgOrderdt.setCreatedby(box.getString("userName"));
					dgOrderdt.setCreatedon(new Date());
					
					dgOrderdt.setLastChgBy(user);
					dgOrderdt.setLastChgDate(new Date());
					dgOrderdt.setLastChgTime(consultationTime);
					// method written for taking out the values of mascharge
					// code and subcharge
					List<MasChargeCode> masChargeList = new ArrayList<MasChargeCode>();
					masChargeList = session.createCriteria(MasChargeCode.class).add(
							Restrictions.eq("Id", Integer.parseInt(chargeCodeId))).list();

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
					
					// Added By Vinay 
					List<DgMasInvestigation> invList = new ArrayList<DgMasInvestigation>();
					invList = session.createCriteria(DgMasInvestigation.class).add(Restrictions.eq("ChargeCode.Id", Integer.parseInt(chargeCodeId))).list();
					int invId=0;
					for(DgMasInvestigation list: invList)
					{
						invId = list.getId();
					}
					dgOrderdt.setInvestigation(new DgMasInvestigation(invId));
					
					
					dgOrderdt.setInvestigationToMh("n");
					dgOrderdt.setBillingStatus("y");
					dgOrderdt.setReferToMh(box.getString("referToMh"+i));
					dgOrderdt.setMsgSent("n");
					hbt.save(dgOrderdt);
					}
				}
			}*/

			/**
			 * For Procedures
			 */
			int procCount = box.getInt("procCount");
			if(procCount > 0) {
				for (int j = 1; j <= procCount; j++) {
					if(box.getInt("procedureId"+j)!=0){
					NursingcareSetup nursingcareSetup = new NursingcareSetup();
					MasNursingCare masNursingCare = new MasNursingCare();
					masNursingCare.setId(box.getInt("procedureId"+j));
					nursingcareSetup.setNursing(masNursingCare);

					nursingcareSetup.setAdNo(box.getString("adNo"));
					nursingcareSetup.setLastChgBy(box.getString("userName"));
					nursingcareSetup.setLastChgTime(consultationTime);
					nursingcareSetup.setLastChgDate(new Date());
					nursingcareSetup.setHin(p);
					MasFrequency masFrequency = new MasFrequency();
					masFrequency.setId(box.getInt("procfrequency"+j));
					nursingcareSetup.setFrequency(masFrequency);
					nursingcareSetup.setRemarks(box.getString("procRemarks"+j));
					nursingcareSetup.setDuration(box.getString("procDuration"+j));
					nursingcareSetup.setNoOfDays(box.getInt("procNoOfDays"+j));
					nursingcareSetup.setInpatient(inpatient);
					if(box.get("deptId") != null){							
						MasDepartment department = new MasDepartment();
						department.setId((Integer)box.getInt("deptId"));
						nursingcareSetup.setDepartment(department);
					}

					hbt.save(nursingcareSetup);
					}
				}
			}
			/*boolean procFlag = false;
			if(procCount > 0) {
				for (int j = 1; j <= procCount; j++) {
					if(box.getInt("procedureId"+j)>0){
						procFlag= true;
						break;
					}
				}
				if(procFlag) {
					ProcedureHeader procedureHeader = new ProcedureHeader();
					try {
						procedureHeader.setHin(p);
						procedureHeader.setHospital(masHospitalObj);
						procedureHeader.setStatus("p");
						Users user = new Users();
						user.setId(box.getInt("userId"));
						procedureHeader.setLastChgBy(user);
						procedureHeader.setMedicalOfficer(masEmployee);
						procedureHeader.setInpatient(inpatient);
						procedureHeader.setRequisitionDate(new Date());
						procedureHeader.setLastChgDate(new Date());
						procedureHeader.setLastChgTime(consultationTime);
						procedureHeader.setOpdPatientDetails(opdPatientDetails);
						hbt.save(procedureHeader);
					} catch (Exception e) {
						e.printStackTrace();
					}

					for (int j = 1; j <= procCount; j++) {
						if(box.getInt("procedureId"+j)>0){
							ProcedureDetails procedureDetails = new ProcedureDetails();
							MasNursingCare nursingCare = new MasNursingCare();
							nursingCare.setId(box.getInt("procedureId"+j));
							procedureDetails.setNursingCare(nursingCare);
							procedureDetails.setProcedureHeader(procedureHeader);
							procedureDetails.setRemarks(box.getString("procRemarks"+j));
							procedureDetails.setStatus("p");
							hbt.save(procedureDetails);
						}
					}
				}
			}*/
			 /**
			 * For Physiotherapy
			 */
			int therapyCount = box.getInt("therapyCount");
			boolean therapyFlag = false;
			if(therapyCount > 0) {
				for (int j = 1; j <= therapyCount; j++) {
					if(box.getInt("therapyId"+j)>0){
						therapyFlag= true;
						break;
					}
				}
				if(therapyFlag) {
					PhysioRequisitionHeader physioRequisitionHeader = new PhysioRequisitionHeader();

					physioRequisitionHeader.setHin(p);

					physioRequisitionHeader.setHospital(masHospitalObj);

					physioRequisitionHeader.setStatus("p");
					physioRequisitionHeader.setFlag("OPD");
					physioRequisitionHeader.setPatientType("IP");

					Users user = new Users();
					user.setId(box.getInt("userId"));
					physioRequisitionHeader.setLastChgBy(user);

					physioRequisitionHeader.setMedicalOfficer(masEmployee);

					physioRequisitionHeader.setInpatient(inpatient);
					physioRequisitionHeader.setReqDate(new Date());
					physioRequisitionHeader.setLastChgDate(new Date());
					physioRequisitionHeader.setLastChgTime(consultationTime);
					physioRequisitionHeader.setReqTime(consultationTime);
					physioRequisitionHeader.setOpdPatientDetails(opdPatientDetails);
					hbt.save(physioRequisitionHeader);

					for (int j = 1; j <= therapyCount; j++) {
						PhysioRequisitionDetail physioRequisitionDetail = new PhysioRequisitionDetail();
						MasTherapyType masTherapyType = new MasTherapyType();
						masTherapyType.setId(box.getInt("therapyId"+j));
						physioRequisitionDetail.setTharaphy(masTherapyType);
						physioRequisitionDetail.setPhysioRequisitionHeader(physioRequisitionHeader);
						MasFrequency masFrequency = new MasFrequency();
						masFrequency.setId(box.getInt("frequencyId"+j));
						physioRequisitionDetail.setFrequency(masFrequency);
						physioRequisitionDetail.setRemark(box.getString("remarks"+j));
						physioRequisitionDetail.setDuration(box.getString("duration"+j));
						physioRequisitionDetail.setNoOfDays(box.getInt("phyNoOfDays"+j));

						hbt.save(physioRequisitionDetail);
						//hbt.refresh(procedureDetails);
					}
				}
			}

			/*if(physioRequisitionHeaderId!=0){
				PhysioRequisitionHeader requisitionHeader = (PhysioRequisitionHeader)hbt.load(PhysioRequisitionHeader.class, physioRequisitionHeaderId);
				requisitionHeader.setOpdPatientDetails(opdPatientDetails);
				requisitionHeader.setReqTime(consultationTime);
				requisitionHeader.setLastChgTime(consultationTime);
				hbt.update(requisitionHeader);

			}
			if(procedureHeaderId!=0){
				ProcedureHeader procedureHeader = (ProcedureHeader)hbt.load(ProcedureHeader.class, procedureHeaderId);
				procedureHeader.setOpdPatientDetails(opdPatientDetails);
				procedureHeader.setLastChgTime(consultationTime);
				hbt.update(procedureHeader);

			}
*/
			if(box.getInt("dietType")!=0){
				IpdPatientDiet patientDiet = new IpdPatientDiet();
				MasDiet diet = new MasDiet();
				diet.setId(box.getInt("dietType"));
				patientDiet.setDiet(diet);
				patientDiet.setSplInstructions(box.getString("splInstructions"));
				patientDiet.setInpatient(inpatient);
				Users user = new Users();
				user.setId(box.getInt("userId"));
				patientDiet.setLastChgBy(user);
				patientDiet.setLastChgDate(new Date());
				patientDiet.setLastChgTime(consultationTime);
				patientDiet.setOpdPatientDetails(opdPatientDetails);
				hbt.save(patientDiet);
			}
			Inpatient ip = (Inpatient)hbt.load(Inpatient.class, box.getInt("inpatientId"));
			if(!box.getString("readyToDischarge").equals("")){
				ip.setAdStatus("R");
			}else{
				ip.setAdStatus("A");
			}
			if(box.getInt("dietType")!=0){
				MasDiet diet = new MasDiet();
				diet.setId(box.getInt("dietType"));
				ip.setDiet(diet);
			}
			ip.setRemarks(box.getString("splInstructions"));
			hbt.update(ip);

/*			if(box.getString("referral").equals("1")){
				if(box.getString("referTo").equalsIgnoreCase("Internal")){
				WardRemarks wardReamrks=new WardRemarks();	
				wardReamrks.setHospital(masHospitalObj);
				Users user = new Users();
				user.setId(box.getInt("userId"));
				wardReamrks.setInpatient(inpatient);
				wardReamrks.setLastChgBy(user);				
				wardReamrks.setLastChgDate(new Date());
				wardReamrks.setLastChgTime(consultationTime);
				wardReamrks.setRemarksDate(new Date());
				wardReamrks.setRemarksTime(consultationTime);
				//wardReamrks.set
				
				int doctorId=0;
				if(box.getInt("refereddoctor")!=0)
				{
					doctorId=box.getInt("refereddoctor");
				}
				if(box.getString("remarksBYDoc")!=null){
				wardReamrks.setRemarks(box.getString("remarksBYDoc"));
				
				}
				MasEmployee me=new MasEmployee();
				me.setId(doctorId);
				wardReamrks.setDoctor(me);
				wardReamrks.setStatus("P");
				hbt.save(wardReamrks);
				}
			}*/
			
			/*for(WardRemarks WardRemarks:wardreamarksList){
				WardRemarks.setStatus("C");
				WardRemarks.setRemarks(WardRemarks.getRemarks().concat(box.getString("newRemarks")));
				hbt.update(WardRemarks);
			}*/
			
			// code for referral consultaion starts
			
			if(box.getString("referral").equals("1")){
				if(box.getString("referTo").equalsIgnoreCase("Internal")){
				/*WardRemarks wardReamrks=new WardRemarks();*/	
				PreAnesthesiaConsultDoctorHd preAnesthesiaConsultDoctorHd = new PreAnesthesiaConsultDoctorHd();
				List<PreAnesthesiaConsultDoctorHd> preAnesthesiaConsultDoctorHdList = new ArrayList<PreAnesthesiaConsultDoctorHd>();
				preAnesthesiaConsultDoctorHdList =session.createCriteria(PreAnesthesiaConsultDoctorHd.class)
						.add(Restrictions.eq("Inpatient.Id", inpatient.getId())).list();
				if(preAnesthesiaConsultDoctorHdList.size()>0)
				{
					 preAnesthesiaConsultDoctorHd = preAnesthesiaConsultDoctorHdList.get(0);
				}
				else
				{
					preAnesthesiaConsultDoctorHd.setInpatient(inpatient);
					preAnesthesiaConsultDoctorHd.setHospital(masHospitalObj);
					hbt.save(preAnesthesiaConsultDoctorHd);
					hbt.flush();
				}
				int doctorId=0;
				if(box.getInt("refereddoctor")!=0)
				{
					doctorId=box.getInt("refereddoctor");
				}
				MasEmployee me=new MasEmployee();
				me.setId(doctorId);
				PreAnesthesiaConsultDoctorDt preAnesthesiaConsultDoctordt = new PreAnesthesiaConsultDoctorDt();
				preAnesthesiaConsultDoctordt.setConsultDoctorIdHd(preAnesthesiaConsultDoctorHd);
				preAnesthesiaConsultDoctordt.setConsultedDoctor(me);
				/*preAnesthesiaConsultDoctordt.setConsultDate(new Date());
				preAnesthesiaConsultDoctordt.setConsultTime(consultationTime);	*/
				Users user = (Users)session.load(Users.class, box.getInt("userId"));
				preAnesthesiaConsultDoctordt.setOpdPatientDetails(opdPatientDetails);
				if (((Integer) box.getInt("referdepartment")) != 0) {
					int referredDepartmentId = (Integer) box.getInt("referdepartment");
					MasDepartment referedDepartment = new MasDepartment();
					referedDepartment.setId(referredDepartmentId);
					preAnesthesiaConsultDoctordt.setConsultedDepartment(referedDepartment);
					
				}
				
				if(box.getString("remarksBYDoc")!=null){
					preAnesthesiaConsultDoctordt.setReferralNotes(box.getString("remarksBYDoc"));
				
				}
				
				preAnesthesiaConsultDoctordt.setStatus("P");
				hbt.save(preAnesthesiaConsultDoctordt);
				}
			}
			
			//code for referral consultaion ends
			
			//code for stop prescription starts
			
			int tCount = 0;
			int tRow=0;
			tCount = box.getInt("tCount");
			
			for(int i=1; i<=tCount; i++)
			{
				tRow = box.getInt("tRow"+i);
				for(int j=1; j<=tRow; j++)
				{
					if(box.get("stop"+i+j)!=null & !box.get("stop"+i+j).trim().equals(""))
					{
						/*IpdMedicineIssueHeader ipdMedicineIssueHeader = new IpdMedicineIssueHeader(); 
						ipdMedicineIssueHeader = (IpdMedicineIssueHeader)session.createCriteria(IpdMedicineIssueHeader.class)
								.add(Restrictions.eq("PatientPrescriptionDetails.Id", box.getInt("stop"+i+j))).list().get(0);*/
						PatientPrescriptionDetails ppd = (PatientPrescriptionDetails)session.load(PatientPrescriptionDetails.class, box.getInt("stop"+i+j));
						ppd.setItemStopStatus("y");
						ppd.setItemStopDate(new Date());
						Users user = (Users)session.load(Users.class, box.getInt("userId"));
						ppd.setItemStopBy(user.getEmployee());
						/*ipdMedicineIssueHeader.setStatus("s");*/
						hbt.update(ppd);
					/*	hbt.update(ipdMedicineIssueHeader);		*/				
						hbt.flush();
					}
				}
			}
			 
			//code for stop prescription ends
			
			flag = true;
			tx.commit();

		}catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		map.put("flag", flag);
		return map;
	}

	public int getTransactionSequenceNoForPrescriptionNo(Map mapForDS) {
		Session session = (Session) getSession();

		int userId = (Integer) mapForDS.get("userId");
		int hospitalId = (Integer) mapForDS.get("hospitalId");
		String userName = (String) mapForDS.get("userName");
		List<TransactionSequence> orderNoList = new ArrayList<TransactionSequence>();
		String tableName = "PATIENT_PRESCRIPTION_HEADER";
		int currentYearInt=-1;
		int orderNo=0;
		int oldYear=-1;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		currentYearInt=Integer.parseInt(currentYear);
		String currentMonth = date.substring(date.indexOf("/") + 1, date
				.lastIndexOf("/"));
		TransactionSequence tranSeq=new TransactionSequence();
		tranSeq.setTransactionSequenceName("PrescriptionNo");
		tranSeq.setTransactionPrefix("PRNO");
		tranSeq.setTablename(tableName);
		tranSeq.setCreatedby(userName);
		tranSeq.setStatus("y");
		//MasServiceType masserType=new MasServiceType();
		tranSeq.setServiceType(null);
		tranSeq.setMonth(currentYearInt);
		//Transaction tx = null;

		try {
			//	tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			try {

				Criteria crit = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("Tablename", tableName)).add(Restrictions.eq("Hospital.Id", hospitalId));
				orderNoList = crit.list();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			if(orderNoList!=null && orderNoList.size()>0)
			{
				TransactionSequence transactionSequence = (TransactionSequence)hbt.load(TransactionSequence.class, orderNoList.get(0).getId());
				orderNo = transactionSequence.getTransactionSequenceNumber();
				oldYear=transactionSequence.getMonth(); 
				if(currentYearInt>oldYear)
				{
					orderNo=1;
					transactionSequence.setMonth(currentYearInt);
					transactionSequence.setCreatedby(userName);
					transactionSequence.setTransactionSequenceNumber(orderNo);
					hbt.update(transactionSequence);
				}else
				{      
					orderNo=orderNo+1;
					transactionSequence.setCreatedby(userName);
					transactionSequence.setTransactionSequenceNumber(orderNo);
					hbt.update(transactionSequence);
				}
			}else
			{
				MasHospital hospital = new MasHospital();
				hospital.setId(hospitalId);
				tranSeq.setHospital(hospital);
				tranSeq.setTransactionSequenceNumber(orderNo);
				hbt.save(tranSeq);
			}
			//	tx.commit();
		} catch (Exception e) {
			//if (tx != null)
			//	tx.rollback();
			e.printStackTrace();

		} finally {
			// --------Session Closing----------

		}
		return orderNo;

	}

	public String generateOrderNumber(int hospitalId ) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = "";

		Session session = (Session) getSession();
		String orderSeqNo = "";
		date = (String) utilMap.get("currentDate");
		String currentyear = "";
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		String lastOrderNo = "";
		String lastOrderYear = "";
		int seqNo = 1;
		List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
		/*
		orderNoList = session.createCriteria(DgOrderhd.class).list();
		for (DgOrderhd dgOrderhd : orderNoList) {
			lastOrderNo = dgOrderhd.getOrderNo();
		}
		System.out.println("lastOrderNo i ----"+lastOrderNo);
		StringTokenizer str = new StringTokenizer(lastOrderNo, "/");
		while (str.hasMoreTokens()) {

			lastOrderYear = str.nextToken();

		}
		System.out.println("lastOrderYear i ----"+lastOrderYear);
		 */
		try {
			orderSeqNoList = session.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionPrefix", "ON")).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (orderSeqNoList.size() > 0) {
		//	for (TransactionSequence transactionSequence : orderSeqNoList) {
				TransactionSequence obj = (TransactionSequence) orderSeqNoList
				.get(0);
				int id = obj.getId();
				String seqNoStr=obj.getTransactionSequenceNumber().toString();
				lastOrderYear=obj.getMonth().toString();
				if (currentYear.equals(lastOrderYear)) {

					seqNo = Integer.parseInt(seqNoStr);
				} else {
					seqNo = 0;
					lastOrderYear=currentYear;
				}
				seqNo=seqNo+1;
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
				.load(TransactionSequence.class, id);

				orderSeqNo = orderSeqNo.concat(String.valueOf(seqNo));
				//orderSeqNo = orderSeqNo.concat("/").concat(String.valueOf(lastOrderYear));
				transactionSequenceObj.setTransactionSequenceNumber(Integer.parseInt(orderSeqNo));
				transactionSequenceObj.setMonth(Integer.parseInt(lastOrderYear));
				hbt.update(transactionSequenceObj);
				hbt.refresh(transactionSequenceObj);

			//}
		} else if (orderSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("DgOrderhd");
			tsObj.setTransactionPrefix("ON");
			tsObj.setTransactionSequenceName("Order No");
			orderSeqNo = orderSeqNo.concat(String.valueOf(seqNo));
			//orderSeqNo = orderSeqNo.concat("/").concat(String.valueOf(currentYear));
			lastOrderYear=currentYear;
			tsObj.setTransactionSequenceNumber(Integer.parseInt(orderSeqNo));
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			tsObj.setHospital(hospital);
			tsObj.setMonth(Integer.parseInt(currentYear));
			hbt.save(tsObj);
		}
		orderSeqNo = orderSeqNo.concat("/").concat(String.valueOf(lastOrderYear));
		return orderSeqNo;
	}
	/*------------------------------code for Medicine Issue by anamika-------------------------------*/
	@Override
	public Map<String, Object> showMedicineIssueDetailJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<PatientPrescriptionDetails> patientPresriptionDetailList = new ArrayList<PatientPrescriptionDetails>();
		List<PatientPrescriptionDetails> opdPatientPresriptionList = new ArrayList<PatientPrescriptionDetails>();
		List<StoreItemBatchStock> itemBatchStockList = new ArrayList<StoreItemBatchStock>();
		List<StoreIpIssueT> ipIssueDetailList = new ArrayList<StoreIpIssueT>();
		List<OpdPatientDetails> opdDetailsList = new ArrayList<OpdPatientDetails>(); 
		List ipIssueNo = new ArrayList();
		Session session = (Session)getSession();

		ipIssueNo = session.createQuery(
				"select syd from StoreFyDocumentNo as syd where syd.Department.Id="+ box.getInt("deptId")).list();
		if (ipIssueNo.size() > 0) {
			StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) ipIssueNo
			.get(0);
			int issueNoOfPatient = storeFyDocumentNo.getIssueInPatientNo();
			issueNoOfPatient = issueNoOfPatient + 1;
			map.put("issueNoOfPatient", issueNoOfPatient);
		}
		inPatientDetailList = session.createCriteria(Inpatient.class).add(Restrictions.eq("Id", box.getInt("inPatientId"))).list();
		int hinId = inPatientDetailList.get(0).getHin().getId();
		frequencyList = session.createCriteria(MasFrequency.class).add(Restrictions.eq("Status", "y")).list();
		patientPresriptionDetailList = session.createCriteria(PatientPrescriptionDetails.class)
		.createAlias("Prescription", "header").createAlias("header.Inpatient", "ip")
		.add(Restrictions.eq("ip.Id", box.getInt("inPatientId")))
		.add(Restrictions.neProperty("Total","GivenQty"))
		.list();

		//	Integer[] itemId = null;
		List<Integer> itemId = new ArrayList<Integer>();
		if(patientPresriptionDetailList.size()>0){
			//itemId = new Integer[patientPresriptionDetailList.size()];
			int i=0;
			for(PatientPrescriptionDetails patientPrescriptionDetails :patientPresriptionDetailList){
				if(patientPrescriptionDetails.getItem() != null){
					if(patientPrescriptionDetails.getItem().getId() != 0){
						itemId.add(patientPrescriptionDetails.getItem().getId());
					}
				}
				i++;
			}


		}
		//else{  // fetching details from OPD in case of patient coming from OPD
		opdDetailsList = session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "v").createAlias("v.Hin", "hin").add(Restrictions.eq("hin.Id", hinId))
		.addOrder(Order.desc("id")).setMaxResults(1).list();
		if(opdDetailsList.size()>0){
			int opddetailsId = opdDetailsList.get(0).getId() ;
			opdPatientPresriptionList =session.createCriteria(PatientPrescriptionDetails.class)
			.createAlias("Prescription", "header").createAlias("header.OpdPatientDetails", "opd")
			.add(Restrictions.eq("opd.id", opddetailsId)).add(Restrictions.neProperty("Total","GivenQty"))
			.list();

			if(opdPatientPresriptionList.size() > 0){
				//itemId = new Integer[opdPatientPresriptionList.size()];
				int i=0;
				for(PatientPrescriptionDetails patientPrescriptionDetails :opdPatientPresriptionList){
					if(patientPrescriptionDetails.getItem() != null){
						if(patientPrescriptionDetails.getItem().getId() != 0){
							itemId.add(patientPrescriptionDetails.getItem().getId());
							//	itemId[i] = patientPrescriptionDetails.getItem().getId();
						}
					}
					i++;
				}
				patientPresriptionDetailList.addAll(opdPatientPresriptionList);

			}
		}
		//	}
		if(itemId!=null && itemId.size() > 0){
			itemBatchStockList = session.createCriteria(StoreItemBatchStock.class).createAlias("Item", "item").add(Restrictions.in("item.Id", itemId))
			.add(Restrictions.eq("Department.Id", box.getInt("deptId"))).add(Restrictions.ne("ClosingStock", new BigDecimal(0))).list();
		}
		ipIssueDetailList = session.createCriteria(StoreIpIssueT.class).createAlias("IpIssue", "header")
		.createAlias("header.Inpatient", "inpatient").add(Restrictions.eq("inpatient.Id",  box.getInt("inPatientId"))).list();

		map.put("inPatientDetailList", inPatientDetailList);
		map.put("ipIssueDetailList", ipIssueDetailList);
		map.put("frequencyList", frequencyList);

		map.put("patientPresriptionDetailList", patientPresriptionDetailList);
		map.put("itemBatchStockList", itemBatchStockList);
		map.put("ipIssueNo", ipIssueNo);
		return map;
	}

	/*------------------------------code for Medicine Issue by anamika-------------------------------*/

	@Override
	public Map<String, Object> getMedicineList(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		/*List<OpdPatientDetails> OpdPatientDetailsEmpanelledList = new ArrayList<OpdPatientDetails>();	*/
		List<PatientPrescriptionDetails> ppdList = new ArrayList<PatientPrescriptionDetails>();
	/*	List<Object[]> dmiList = new ArrayList<Object[]>();	*/	
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;	
		int hospitalId = box.getInt("hospitalId");
		int inpatientId = box.getInt("inpatientId");
		int wardId = box.getInt("wardId");
		System.out.println("inpatientId"+inpatientId);
		
		if (box.getString("PN") != null)
			pageNo = Integer.parseInt(box.getString("PN"));	
		
		String[] statusArray = {"i", "c", "s"};
		/*cr = session.createCriteria(IpdMedicineIssueHeader.class)
				.createAlias("PatientPrescriptionDetails", "ppd")
				.createAlias("ppd.Prescription", "pph")
				.add(Restrictions.eq("pph.Inpatient.Id", inpatientId))
				.add(Restrictions.in("Status", statusArray));*/
		
		cr = session.createCriteria(PatientPrescriptionDetails.class)
				.createAlias("Prescription", "pph")			
				.add(Restrictions.eq("pph.Inpatient.Id", inpatientId));
				/*.add(Restrictions.in("Status", statusArray));*/
		
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		ppdList = cr.list();
		
	

		int totalRecords = totalMatches.size();
		totalMatches.clear();	
		
	/*	dmiList = session.createCriteria(DepartmentMedicineIssue.class)
		.add(Restrictions.eq("Department.Id", wardId))			
			.setProjection(Projections.projectionList()
					.add(Projections.property("Item.Id"))
					.add(Projections.sum("QtyRemaining"))
					.add(Projections.groupProperty("Item.Id"))).list();	*/
		
		map.put("ppdList", ppdList);
		/*map.put("dmiList", dmiList);	*/
		
		map.put("totalRecords", totalRecords);
		
				
		return map;
	}
	
	@Override
	public Map<String, Object> getMedicineEntryPage(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		/*List<DepartmentMedicineIssue> departmentMedicineIssueList = new ArrayList<DepartmentMedicineIssue>();*/
		List<IpdMedicineIssueDetails> ipdMedicineIssueDetailsList = new ArrayList<IpdMedicineIssueDetails>();
		PatientPrescriptionDetails ppd = new PatientPrescriptionDetails();
		List<StoreItemBatchStock> batchList=new ArrayList<StoreItemBatchStock>();
		Session session = (Session) getSession();
		Date expiryDate = HMSUtil.getExpiryDateYYYYMMDD();	
		String expiryStr = HMSUtil.convertDateToStringFormat(expiryDate, "yyyy-MM-dd");
		int headerId = 0;
		if(box.get("headerId")!=null){
			headerId =  box.getInt("headerId");
		}
		int itemId = 0;
		if(box.get("itemId")!=null){
			itemId =  box.getInt("itemId");
		}
		/*int hospitalId = box.getInt("hospitalId");*/
		
		
		ipdMedicineIssueDetailsList = session.createCriteria(IpdMedicineIssueDetails.class)
				.add(Restrictions.eq("PatientPrescriptionDetails.Id", headerId)).list();
		
		ppd = (PatientPrescriptionDetails)session.load(PatientPrescriptionDetails.class, headerId);
				
		
		if(ipdMedicineIssueDetailsList!=null && ppd!=null)
		{
			/*departmentMedicineIssueList = session.createCriteria(DepartmentMedicineIssue.class)
					.add(Restrictions.eq("Department.Id", ipdMedicineIssueHeaderList.get(0).getPatientPrescriptionDetails().getPrescription().getInpatient().getDepartment().getId()))
					.add(Restrictions.eq("Item.Id", ipdMedicineIssueHeaderList.get(0).getPatientPrescriptionDetails().getItem().getId())).list();;
					*/
					
					String query="from StoreItemBatchStock sibs where sibs.ExpiryDate>'"+expiryStr+"' and Item.Id="+ppd.getItem().getId()+" and sibs.ClosingStock>0 and Department.Id="+ppd.getPrescription().getInpatient().getDepartment().getId()+" order by sibs.ExpiryDate asc ";
					batchList=session.createQuery(query).list();
					System.out.println("batchList"+batchList.size());
		}
		
		
		/*map.put("departmentMedicineIssueList", departmentMedicineIssueList);*/
		map.put("batchList", batchList);
		map.put("ipdMedicineIssueDetailsList", ipdMedicineIssueDetailsList);
		map.put("ppd", ppd);	

		
				
		return map;
	}
	
		
	@Override
	public Map<String, Object> getMedicineDetailList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PatientPrescriptionDetails>patientPresriptionDetailList = new ArrayList<PatientPrescriptionDetails>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		Session session = (Session)getSession();
		patientPresriptionDetailList = session.createCriteria(PatientPrescriptionDetails.class)
		.add(Restrictions.eq("Prescription.Id", box.getInt("prescriptionHeaderId"))).list();

		frequencyList = session.createCriteria(MasFrequency.class).add(Restrictions.eq("Status", "y")).list();
		map.put("patientPresriptionDetailList", patientPresriptionDetailList);
		map.put("frequencyList", frequencyList);
		return map;
	}

	@Override
	public Map<String, Object> submitMedicineIssueDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Transaction tx = null;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean flag = false;
		try {
			tx = session.beginTransaction();
			StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) hbt.load(
					StoreFyDocumentNo.class, box.getInt("storeFyDocumentNoId"));
			int patientIssueNoFromDB = storeFyDocumentNo.getIssueInPatientNo();
			if (patientIssueNoFromDB != box.getInt("issueNo")) {
				storeFyDocumentNo.setIssueInPatientNo(box.getInt("issueNo"));
				hbt.update(storeFyDocumentNo);
				int count = box.getInt("count");
				StoreIpIssueM storeIpIssueM = new StoreIpIssueM();
				Patient patient = new Patient();
				patient.setId(box.getInt("hinId"));
				storeIpIssueM.setHin(patient);
				Inpatient inpatient = new Inpatient();
				inpatient.setId(box.getInt("inPatientId"));
				storeIpIssueM.setInpatient(inpatient);


				storeIpIssueM.setIpIssueNo("" + box.getInt("issueNo"));
				MasHospital hospital = new MasHospital();
				hospital.setId(box.getInt("hospitalId"));
				storeIpIssueM.setHospital(hospital);
				Users user = new Users();
				user.setId(box.getInt("userId"));
				storeIpIssueM.setLastChgBy("admin");
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(box.getInt("deptId"));
				storeIpIssueM.setDepartment(masDepartment);
				storeIpIssueM.setIpIssueDate(HMSUtil.convertStringTypeDateToDateType(box.getString("issueDate")));
				storeIpIssueM.setIpIssueTime(box.getString("issueTime"));
				storeIpIssueM.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				storeIpIssueM.setLastChgTime(box.getString(CHANGED_TIME));
				hbt.save(storeIpIssueM);
				for (int j = 1; j < count; j++) {
					StoreIpIssueT storeIpIssueT = new StoreIpIssueT();

					if(box.getString("issued"+j).equals("y")){
						if(box.getInt("batchId"+j) != 0){
							
							System.out.println("batchId="+box.getInt("batchId"+j));
							StoreItemBatchStock storeItemBatchStock = new StoreItemBatchStock();
							storeItemBatchStock.setId(box.getInt("batchId"+j));
							storeIpIssueT.setBatch(storeItemBatchStock);
							MasStoreItem storeItem = new MasStoreItem();
							storeItem.setId(box.getInt("item"+j));
							storeIpIssueT.setItem(storeItem);
							storeIpIssueT.setIpIssue(storeIpIssueM);
							storeIpIssueT.setExpiryDate(HMSUtil.convertStringTypeDateToDateType(box.getString("expiryDate"+j)));
							PatientPrescriptionDetails patientPrescriptionDetails= new PatientPrescriptionDetails();
							patientPrescriptionDetails.setId(box.getInt("prescriptionDetailId"+j));
							storeIpIssueT.setPrescriptionDetail(patientPrescriptionDetails);

							BigDecimal qty = new BigDecimal(box.getInt("dosage"+j));
							storeIpIssueT.setQtyIssued( new BigDecimal(box.getInt("dosage"+j)));

							//-------------update StoreItem batch Stock-----------------
							StoreItemBatchStock itemBatchStock = (StoreItemBatchStock) hbt.load(StoreItemBatchStock.class, box.getInt("batchId"+j));
							BigDecimal qtyIssued = (BigDecimal) itemBatchStock.getIssueQty();
							BigDecimal totalQtyIssued  = new BigDecimal(0);
							if (qtyIssued != null) {
								totalQtyIssued = qtyIssued.add( new BigDecimal(box.getInt("dosage"+j)));
							} else {
								totalQtyIssued =  new BigDecimal(box.getInt("dosage"+j));
							}
							BigDecimal closingStock = new BigDecimal(0);
							BigDecimal issueQty = new BigDecimal(0);
							if(itemBatchStock.getClosingStock()!=null){
								closingStock = (BigDecimal) itemBatchStock.getClosingStock();
								closingStock = closingStock.subtract(new BigDecimal(box.getInt("dosage"+j)));
								if(itemBatchStock.getIssueQty()!=null){
									issueQty = itemBatchStock.getIssueQty();
								}
								itemBatchStock.setIssueQty(totalQtyIssued);
								itemBatchStock.setClosingStock(closingStock);
								hbt.update(itemBatchStock);
							}
							//-----------------update Patient Prescription Detail-----------------//
							PatientPrescriptionDetails prescriptionDetails = (PatientPrescriptionDetails)hbt.load(PatientPrescriptionDetails.class, box.getInt("prescriptionDetailId"+j));
							int givenQty = prescriptionDetails.getGivenQty();
							int totalGivenQty = 0;
							if(givenQty != 0){
								totalGivenQty = givenQty + box.getInt("dosage"+j); 
							}else{
								totalGivenQty = box.getInt("dosage"+j);
							}
							prescriptionDetails.setGivenQty(totalGivenQty);
							hbt.update(prescriptionDetails);
							//------------------------------------------
							hbt.save(storeIpIssueT);

						}
					}
				}
			}
			tx.commit();
			flag=true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map = showMedicineIssueDetailJsp(box);
		map.put("flag", flag);
		return map;
	}

	@Override
	public Map<String, Object> displayMedicineDetailList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreIpIssueT> ipIssueDetailList = new ArrayList<StoreIpIssueT>();
		Session session = (Session)getSession();
		ipIssueDetailList = session.createCriteria(StoreIpIssueT.class).createAlias("IpIssue", "header")
		.createAlias("header.Inpatient", "inpatient").add(Restrictions.eq("inpatient.Id",  box.getInt("inPatientId"))).list();
		map = showMedicineIssueDetailJsp(box);
		map.put("ipIssueDetailList", ipIssueDetailList);
		return map;
	}


	/*********************** Method For Show Patient Name *****************************/

	@Override
	public Map<String, Object> showPatientName(Map<String,Object>dataMap) {
		Map<String, Object>map  = new HashMap<String, Object>();
		List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
		int hinId=0;
		List<Patient> patientList = new ArrayList<Patient>();
		String paramName=(String)dataMap.get("paramName");
		String flag=(String)dataMap.get("flag");
		String flag1="";
		if(dataMap.get("flag1")!=null && dataMap.get("flag1")!=""){
			flag1=(String)dataMap.get("flag1");
		}
		Session session = (Session)getSession();
		if(flag.equalsIgnoreCase("s"))
		{
			patientList = session.createCriteria(Patient.class)
			.add(Restrictions.eq("ServiceNo",paramName)).list();
			map.put("patientList", patientList);
			map.put("flag", flag);
		}

		if(flag.equalsIgnoreCase("p") || flag.equalsIgnoreCase("w"))
		{
			if(dataMap.get("paramName")!=null)
			{
				hinId=Integer.parseInt(dataMap.get("paramName").toString());
			}
			Criteria crit = null;
			crit = session.createCriteria(Inpatient.class)
			.add(Restrictions.eq("Hin.Id", hinId));
			if(dataMap.get("discharge") == null && !flag1.equals("k") && !flag1.equals("j")){
				//crit = crit.add(Restrictions.eq("AdStatus", "A"));
			}
			inPatientDetailList = crit.list();

			map.put("inPatientDetailList", inPatientDetailList);
			map.put("flag", flag);
			map.put("flag1", flag1);
		}



		//map.put("patientPrescriptionHeaderList", patientPrescriptionHeaderList);
		return map;
	}

	@Override
	public Map<String, Object> showPatientMedicalCaseSheetReportForWard(
			String hinNo,int hospitalId,String adNo) {
		Session session = (Session)getSession();
		Connection con = session.connection();
		//String sql = "{call casesheet(?)}";
		//Connection conn = null;
		//Properties properties = new Properties();
		// Set the value for the IN parameter
		//URL resourcePathHIC = Thread.currentThread().getContextClassLoader().getResource("jdbc.properties");
		//try {
		//	properties.load(resourcePathHIC.openStream());
		//} catch (Exception e) {
		//	e.printStackTrace();
		//}
		//String hicDB = "jdbc:oracle:thin:@192.168.203.195:1521:XE";
		//String hicUser ="hms";
		//String hicPwd = "hms";
		try {
			//				CallableStatement cals = con.prepareCall(sql);
			//		cals.setString(1, hinNo);

			//Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			//conn = DriverManager.getConnection(hicDB, hicUser, hicPwd);
			//CallableStatement cals = conn.prepareCall("{call casesheet(?)}");
			CallableStatement cals = con.prepareCall("{call casesheet(?,?,?)}");
			
			System.out.println("hinNo="+hinNo);
			System.out.println("hospitalId="+hospitalId);
			cals.setString(1, hinNo.trim());
			cals.setInt(2, hospitalId);
			cals.setString(3, adNo);
			cals.execute();
			//	cals.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}// catch (InstantiationException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		//} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		//	e.printStackTrace();
		//} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		return null;
	}

	@Override
	public Map<String, Object> showDietSetupJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<OpdPatientDetails> opdDetailsList = new ArrayList<OpdPatientDetails>();
		List<OpdPatientDetails> ipdDetailsList = new ArrayList<OpdPatientDetails>();		
		List<IpdPatientDiet> ipdPatientDietList= new ArrayList<IpdPatientDiet>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<PatientDietIndoorDetail> patientDietList = new ArrayList<PatientDietIndoorDetail>();
		List<PatientDietIndoorDetail> patientDietList1 = new ArrayList<PatientDietIndoorDetail>();
		List<IpdPatientDiet> ipdDietList = new ArrayList<IpdPatientDiet>();
		List<Integer> inpIdList = new ArrayList<Integer>();
		List<MasDiet> dietTypeList = new ArrayList<MasDiet>();	
		int hospitalId = box.getInt("hospitalId");
		
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
		.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");


		Map dateMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) dateMap.get("currentDate");

		Session session = (Session)getSession();
		inpatientList =  session.createCriteria(Inpatient.class).createAlias("Department", "dep")
		.add(Restrictions.eq("dep.Id", box.getInt("deptId")))
		.add(Restrictions.eq("AdStatus", "A"))
		.addOrder(Order.asc("Id")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Hospital.Id", hospitalId)).add(
				Restrictions.eq("Status", "y"))
				.createAlias("EmpCategory", "empCat")
				.add(Restrictions.like("empCat.EmpCategoryCode", empCategoryCodeForDoctor)).list();
		for(Inpatient inpList: inpatientList){
			inpIdList.add(inpList.getId());
		}
		if(inpIdList.size()>0){
			patientDietList = session.createCriteria(PatientDietIndoorDetail.class)
			.createAlias("Inpatient", "inp")
			.add(Restrictions.in("inp.Id", inpIdList))
			.add(Restrictions.eq("LastChgDate", HMSUtil.convertStringTypeDateToDateType(date)))
			.add(Restrictions.eq("MN", 1)).createAlias("Department", "dept")
			.add(Restrictions.eq("dept.Id", box.getInt("deptId")))
			.addOrder(Order.asc("inp.Id")).list();

			patientDietList1 = session.createCriteria(PatientDietIndoorDetail.class)
			.createAlias("Inpatient", "inp")
			.add(Restrictions.in("inp.Id", inpIdList))
			.add(Restrictions.eq("LastChgDate", HMSUtil.convertStringTypeDateToDateType(date)))
			.add(Restrictions.eq("MN", 2)).createAlias("Department", "dept")
			.add(Restrictions.eq("dept.Id", box.getInt("deptId")))
			.addOrder(Order.asc("inp.Id")).list();

			ipdDietList=session.createCriteria(IpdPatientDiet.class)
			.createAlias("Inpatient", "ip").add(Restrictions.in("ip.Id", inpIdList))
			.addOrder(Order.asc("ip.Id")).list();
		}

		dietTypeList = session.createCriteria(MasDiet.class).add(Restrictions.eq("Status", "y")).list();
		/*		patientDietIndoorDetail
		if(ipdDetailsList.size() > 0) {
			System.out.println("ipdDetailsList size in ds --- "+ipdDetailsList.size());
			caseSheetList.addAll(ipdDetailsList);// to display all previous case list
			opdDetailsList.add(ipdDetailsList.get(0)); // to display latest case sheet details in todays case sheet
			int opdPatientDetailsId = 0;
			opdPatientDetailsId = ipdDetailsList.get(0).getId();
			List<PatientPrescriptionHeader> ipdPrescriptionList = new ArrayList<PatientPrescriptionHeader>();
			List<PatientInvestigationHeader> ipdInvestigationList = new ArrayList<PatientInvestigationHeader>();
			List<DischargeIcdCode> ipIcdList = new ArrayList<DischargeIcdCode>();
			List<ProcedureHeader> ipdProcedureList = new ArrayList<ProcedureHeader>();
			List<PhysioRequisitionHeader> ipdPhysiotherapyList = new ArrayList<PhysioRequisitionHeader>();
			List<OpdPatientHistory> ipdHistoryDetailsListForFollowUp = new ArrayList<OpdPatientHistory>();
			ipdPrescriptionList = session.createCriteria(PatientPrescriptionHeader.class).createAlias("OpdPatientDetails", "ip").add(Restrictions.eq("ip.id", opdPatientDetailsId)).addOrder(Order.desc("Id")).setMaxResults(1).list();
			ipdInvestigationList = session.createCriteria(PatientInvestigationHeader.class).createAlias("OpdPatientDetails", "ip").add(Restrictions.eq("ip.id", opdPatientDetailsId)).addOrder(Order.desc("Id")).setMaxResults(1).list();
			ipIcdList = session.createCriteria(DischargeIcdCode.class).createAlias("OpdPatientDetails", "ip").add(Restrictions.eq("ip.id", opdPatientDetailsId)).addOrder(Order.desc("Id")).list();
			ipdProcedureList = session.createCriteria(ProcedureHeader.class).createAlias("OpdPatientDetails", "ip").add(Restrictions.eq("ip.id", opdPatientDetailsId)).addOrder(Order.desc("Id")).setMaxResults(1).list();
			ipdPhysiotherapyList =  session.createCriteria(PhysioRequisitionHeader.class).createAlias("OpdPatientDetails", "ip").add(Restrictions.eq("ip.id", opdPatientDetailsId)).addOrder(Order.desc("Id")).setMaxResults(1).list();
			ipdHistoryDetailsListForFollowUp = session.createCriteria(OpdPatientHistory.class).createAlias("OpdPatientDetails", "ip").add(Restrictions.eq("ip.id", opdPatientDetailsId)).list();

			ipdPatientDietList = session.createCriteria(IpdPatientDiet.class).createAlias("OpdPatientDetails", "ip").add(Restrictions.eq("ip.id", opdPatientDetailsId)).addOrder(Order.desc("Id")).setMaxResults(1).list();

			opdPrescriptionList.addAll(ipdPrescriptionList);
			opdInvestigationList.addAll(ipdInvestigationList);
			icdList.addAll(ipIcdList);
			opdProcedureList.addAll(ipdProcedureList);
			opdPhysiotherapyList.addAll(ipdPhysiotherapyList);
			opdHistoryDetailsListForFollowUp.addAll(ipdHistoryDetailsListForFollowUp);

		}
		frequencyList = session.createCriteria(MasFrequency.class).add(Restrictions.eq("Status", "y")).list();
		familyHistoryList = session.createCriteria(PatientFamilyHistory.class).add(Restrictions.eq("Status", "y")).list();
		masIcdList = session.createCriteria(MasIcd.class).add(Restrictions.eq("Status", "y")).list();
		dietTypeList = session.createCriteria(MasDiet.class).add(Restrictions.eq("Status", "y")).list();
		 */
		map.put("patientDietList1", patientDietList1);
		map.put("ipdDietList", ipdDietList);
		map.put("dietTypeList", dietTypeList);
		map.put("patientDietList", patientDietList);
		map.put("employeeList", employeeList);
		map.put("inpatientList", inpatientList);
		map.put("ipdPatientDietList", ipdPatientDietList);

		return map;
	}

	@Override
	public Map<String, Object> getPatientLatestDiagnosisAndDisability(int inpatientId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
		List<MasMedicalExaminationDetail> disabilityList = new ArrayList<MasMedicalExaminationDetail>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		Session session = (Session)getSession();
		inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.idEq(inpatientId)).list();
		int hinId = 0;
		hinId = inpatientList.get(0).getHin().getId();
		diagnosisList = session.createCriteria(DischargeIcdCode.class).createAlias("Hin", "h").add(Restrictions.eq("h.Id", hinId)).addOrder(Order.desc("Id")).setMaxResults(1).list();
		disabilityList = session.createCriteria(MasMedicalExaminationDetail.class).createAlias("MasMedicalReport", "mer")
		.add(Restrictions.eq("mer.Hin.Id", hinId)).add(Restrictions.isNotNull("MasIcd")).addOrder(Order.desc("Serviceid")).setMaxResults(1).list();
		map.put("diagnosisList", diagnosisList);
		map.put("disabilityList", disabilityList);
		return map;
	}

	@Override
	public Map<String, Object> getItemBatchNo(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreItemBatchStock> batchList = new ArrayList<StoreItemBatchStock>();
		int deptId = box.getInt("deptId");
		int hospitalId = box.getInt("hospitalId");
		String pvmsNo =  box.getString("pvmsNo");
		Session session = (Session)getSession();
		batchList = session.createCriteria(StoreItemBatchStock.class).createAlias("Item", "item").add(Restrictions.eq("item.PvmsNo", pvmsNo))
		.createAlias("Department", "dept").add(Restrictions.eq("dept.Id", deptId)).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).list();
		map.put("batchList", batchList);
		return map;
	}

	@Override
	public List<StoreItemBatchStock> getBatchExpiryDate(int batchId) {
		List<StoreItemBatchStock> batchList = new ArrayList<StoreItemBatchStock>();
		Session session = (Session)getSession();
		batchList = session.createCriteria(StoreItemBatchStock.class).add(Restrictions.idEq(batchId)).list();
		return batchList;
	}

	@Override
	public Map<String, Object> saveDrugConsumptionDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List patientList = new ArrayList();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setCheckWriteOperations(false);
		hbt.setFlushModeName("FLUSH_EAGER");
		Transaction tx = null;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		boolean flag = false;
		try {
			tx= session.beginTransaction();
			int counter = box.getInt("hdb");
			if(counter > 0){
				for(int i=1;i<=counter;i++){
					if(box.getInt("itemId"+i)!=0 && box.getInt("batchId"+i)!=0){
						IpdDrugConsumption ipdDrugConsumption = new IpdDrugConsumption();
						ipdDrugConsumption.setConsumptionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("consumptionDate")));
						ipdDrugConsumption.setConsumptionTime(box.getString("consumptionTime"));
						MasStoreItem storeItem=new MasStoreItem();
						storeItem.setId(box.getInt("itemId"+i));
						ipdDrugConsumption.setItem(storeItem);
						StoreItemBatchStock batchStock = new StoreItemBatchStock();
						batchStock.setId(box.getInt("batchId"+i));
						ipdDrugConsumption.setBatchStock(batchStock);
						if(!box.getString("expiryDate"+i).equals("")){
							ipdDrugConsumption.setExpiryDate(HMSUtil.convertStringTypeDateToDateType(box.getString("expiryDate"+i)));
						}
						ipdDrugConsumption.setStockQty(new BigDecimal(box.getString("stockQty"+i)));
						ipdDrugConsumption.setQtyConsumed(new BigDecimal(box.getString("consumedQty"+i)));
						MasDepartment department = new MasDepartment();
						department.setId(box.getInt("deptId"));
						ipdDrugConsumption.setDepartment(department);
						MasHospital hospital = new MasHospital();
						hospital.setId(box.getInt("hospitalId"));
						ipdDrugConsumption.setHospital(hospital);
						Users user = new Users();
						user.setId(box.getInt("userId"));
						ipdDrugConsumption.setLastChgBy(user);
						ipdDrugConsumption.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
						ipdDrugConsumption.setLastChgTime(time);

						hbt.save(ipdDrugConsumption);

						StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock)hbt.load(StoreItemBatchStock.class, box.getInt("batchId"+i));
						BigDecimal closingStock = new BigDecimal(0);
						BigDecimal issueQty = new BigDecimal(0);
						if(storeItemBatchStock.getClosingStock()!=null){
							closingStock = storeItemBatchStock.getClosingStock();
						}
						if(storeItemBatchStock.getIssueQty()!=null){
							issueQty = storeItemBatchStock.getIssueQty();
						}
						if(closingStock.compareTo(new BigDecimal(0)) > 0 ){
							closingStock = closingStock.subtract(new BigDecimal(box.getString("consumedQty"+i)));
							storeItemBatchStock.setClosingStock(closingStock);
						}
						issueQty = issueQty.add(new BigDecimal(box.getString("consumedQty"+i)));

						storeItemBatchStock.setIssueQty(issueQty);
						hbt.update(storeItemBatchStock);



					}

				}



			}
			flag = true;
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		map.put("flag", flag);
		return map;
	}


	@Override
	public Map<String, Object> showPatientHinNo(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<Object[]> patientList = new ArrayList<Object[]>();
		String flag="";
		if(dataMap.get("flag")!=null && dataMap.get("flag")!="" ){
			flag=(String)dataMap.get("flag");
		}
		String serviceNo=(String)dataMap.get("paramName");
		int hospitalId=(Integer)dataMap.get("hospitalId");
		try {
			patientList = session.createCriteria(Inpatient.class)
			.createAlias("Hin", "hin").add(Restrictions.eq("hin.ServiceNo", serviceNo))
			.createAlias("hin.Relation", "hinRel")
			.createAlias("Hospital", "hos").add(Restrictions.eq("hos.Id", hospitalId))
			.setProjection(Projections.distinct(Projections.projectionList()
					.add(Projections.property("hin.Id"))
					.add(Projections.property("hin.HinNo"))
					.add(Projections.property("hin.PFirstName"))
					.add(Projections.property("hin.PMiddleName"))
					.add(Projections.property("hin.PLastName"))
					.add(Projections.property("hinRel.RelationName"))
					//.add(Projections.property("hin.Relation.RelationName"))		
			)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		}
		map.put("patientList", patientList);
		map.put("flag", flag);
		return map;
	}

	@Override
	public String getHinNoForCaseSheet(int hinId,int hospitalId) {
		Session session = (Session)getSession();
		List<Patient> patientList = new ArrayList<Patient>();
		String hinNo1="";
		try{
			patientList=session.createCriteria(Patient.class)
			.add(Restrictions.eq("Id", hinId))
			.createAlias("Hospital", "hosp")
			.add(Restrictions.eq("hosp.Id", hospitalId)).list();
			if(patientList.size()>0){
				for(Patient pat:patientList){
					hinNo1=pat.getHinNo();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return hinNo1;
	}
	

	@SuppressWarnings("unchecked")
	public Map<String, Object> showSurgeryRequisitionJspForHin(Box box) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();


		
		List<Inpatient> inpatientSurgeryList = new ArrayList<Inpatient>();
		/*List<HospitalDoctorUnitM>hospitalDoctorUnitMList=new ArrayList<HospitalDoctorUnitM>();*/
		String hinNo = box.getString(HIN_NO);
//		int empId = (Integer) mapForDS.get("empId");
		int deptId = box.getInt(DEPT_ID);
		int hospitalId = box.getInt(HOSPITAL_ID);
		int unit=box.getInt("unit");
		String ipNo=box.getString(AD_NO);
		String patientName=box.getString(PATIENT_NAME);
		int inpatientId=box.getInt("parent");
		
		int orderNo = 0;
		
		try {
			
		/*	hospitalDoctorUnitMList=session.createCriteria(HospitalDoctorUnitM.class)
					   .add(Restrictions.eq("Status","y").ignoreCase())
					   .add(Restrictions.eq("Hospital.Id", hospitalId))
					   .list();
			*/
			
			
			
			
			Criteria crit = session.createCriteria(Inpatient.class,"ip")
					/*.createAlias("ip.Department", "dp")
					.createAlias("ip.Hin", "hin")
					.createAlias("ip.Hospital", "hospital")
					.add(Restrictions.or(Restrictions.eq("ip.AdStatus", "A").ignoreCase(), Restrictions.eq("ip.AdStatus", "O").ignoreCase()))
					.add(Restrictions.eq("dp.Id", deptId))*/
					.add(Restrictions.eq("ip.Id", inpatientId));
			
		/*	if(!hinNo.equals(""))
			{
				crit.add(Restrictions.eq("hin.HinNo", hinNo));
			}
			if(!ipNo.equals(""))
			{
				crit.add(Restrictions.eq("ip.AdNo", ipNo));
			}
			if(!patientName.equals(""))
			{
				
				patientName = patientName.replaceAll("  ", "%");
				patientName.trim();
				patientName = patientName.replaceAll(" ", "%").toLowerCase();
				Criterion rest1 = Restrictions.or(
						Restrictions.like("hin.PFirstName",
								"%" + patientName + "%").ignoreCase(),
						Restrictions.like("hin.PMiddleName",
								"%" + patientName + "%").ignoreCase());
				rest1 = Restrictions.or(rest1,
						Restrictions
								.like("hin.PLastName", "%" + patientName + "%")
								.ignoreCase());
				crit = crit.add(rest1);
				
			}*/
			
			inpatientSurgeryList=crit.list();
			
			List<OpdSurgeryDetail> surgeryDetailList=new ArrayList<OpdSurgeryDetail>();
			if(inpatientSurgeryList.size()>0){
				Inpatient inpatient=inpatientSurgeryList.get(0);
				System.out.println("inpatientList "+inpatientSurgeryList.size());
								
				surgeryDetailList=session.createCriteria(OpdSurgeryDetail.class)
						.createAlias("OpdSurgery", "OpdSurgeryHeader")
				          .createAlias("OpdSurgeryHeader.Inpatient", "ip")
				          .add(Restrictions.eq("ip.Id", inpatient.getId()))
				         .add(Restrictions.eq("OpdSurgeryHeader.Hospital.Id", hospitalId)).list();
				
			System.out.println("surgeryDetailList "+surgeryDetailList.size());
				map.put("surgeryDetailList", surgeryDetailList);
			}
		
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	    System.out.println("inpatientSurgeryList"+inpatientSurgeryList.size());
		map.put("inpatientSurgeryList", inpatientSurgeryList);
		
		return map;
	}
	

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitSurgeryRequisitionDetailsForInpatient(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean succesfullyAdded = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setCheckWriteOperations(false);
		hbt.setFlushModeName("FLUSH_EAGER");
		Session session = (Session)getSession();
		Transaction tx= null;
		int orderNo=0;
		try {
			Map<String,Object> utilMap = new HashMap<String,Object>();
			Map<String,Object> mapForDS= new HashMap<String,Object>();
			mapForDS.put("userId", box.getInt("userId"));
			mapForDS.put("userName", box.getString("userName"));
			mapForDS.put("hospitalId", box.getInt("hospitalId"));
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String currentTime = (String)utilMap.get("currentTime");
			String currentDate = (String)utilMap.get("currentDate");

			tx = session.beginTransaction();
			
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(box.getInt("empId"));
			
			MasHospital masHospitalObj = new MasHospital();
			masHospitalObj.setId(box.getInt("hospitalId"));
			
			MasDepartment md=new MasDepartment();
			md.setId(box.getInt(DEPT_ID));
			
		int proscedurehiddenValue = box.getInt("procCount");
		String proscedureName = "";
		for (int l = 1; l <= proscedurehiddenValue; l++) {
			if( box.getString("surgeryradio"+l)!=null &&  !box.getString("surgeryradio"+l).equals(""))
			{
				List<OpdSurgeryHeader> opdSurgeryHeaderList= new ArrayList<OpdSurgeryHeader>();
				OpdSurgeryHeader opdSurgeryHeader=null;	
				if(box.getInt(INPATIENT_ID)!=0){
					/*Inpatient inpatient = new Inpatient();
					inpatient.setId(box.getInt(INPATIENT_ID+l));
					opdSurgeryHeader.setInpatient(inpatient);*/
					opdSurgeryHeaderList = session.createCriteria(OpdSurgeryHeader.class)
	                        .add(Restrictions.eq("Inpatient.Id",box.getInt(INPATIENT_ID))).list();
					if(opdSurgeryHeaderList.size()==0)
						{
						opdSurgeryHeader = new OpdSurgeryHeader();
						}
					else
					{
						opdSurgeryHeader = opdSurgeryHeaderList.get(0);
					}
					
					Inpatient inpatient = (Inpatient)session.get(Inpatient.class, box.getInt(INPATIENT_ID));		
					/*inpatient.setAdStatus("O");
					hbt.update(inpatient);*/
					opdSurgeryHeader.setInpatient(inpatient);
					opdSurgeryHeader.setVisit(inpatient.getVisit());
					
					
				}				
			 Patient p=new Patient();
			 p.setId(box.getInt(HIN_ID));
			List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
			
			opdSurgeryHeader.setHin(p);
			opdSurgeryHeader.setEmployee(masEmployee);
			opdSurgeryHeader.setPrescribedDepartment(md);
			opdSurgeryHeader.setHospital(masHospitalObj);
			opdSurgeryHeader.setRequisitionDate(HMSUtil.dateFormatterDDMMYYYY(currentDate));
			opdSurgeryHeader.setRequisitionTime(currentTime);
			opdSurgeryHeader.setPatientStatus("In Patient");
			
			opdSurgeryHeader.setPacStatus(box.getString("pacstatus"+l));
			opdSurgeryHeader.setBookingStatus(box.getString("pacstatus"+l));
			/*opdSurgeryHeader.setBillingStatus("Pending");
			opdSurgeryHeader.setBillingStatus("n");*/
			opdSurgeryHeader.setStatus("n");
			
			
			/* String transactionSequenceName = "Surgery Requisition No";
			 sequenceNoList = session
                        .createCriteria(TransactionSequence.class)
                        .add(Restrictions.eq("TransactionSequenceName",
                                transactionSequenceName)).list();
                TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList
                        .get(0);
                orderNo = transactionSequence
                        .getTransactionSequenceNumber();
                orderNo = orderNo + 1;
                int id = transactionSequence.getId();
                TransactionSequence transactionSequence2 = (TransactionSequence) hbt
                        .load(TransactionSequence.class, id);
                transactionSequence2.setTransactionSequenceNumber(orderNo);
                hbt.update(transactionSequence2);
                */
			
			mapForDS.put("tableObjectName", "OpdSurgeryHeader");			
			mapForDS.put("isHospitalWise", "y");
			mapForDS.put("hospitalId", masHospitalObj.getId());
			mapForDS.put("isYearly", "n");			
			mapForDS.put("isMonthly", "n");
			mapForDS.put("isPrefix", "n");
			/*mapForDS.put("transactionPrefixProperty", "transactionPrefixForIPD");*/
			orderNo = Integer.parseInt(HMSUtil.generateTransactionSequence(mapForDS, session, hbt));
                
                
                opdSurgeryHeader.setOrderNo(orderNo);
                hbt.saveOrUpdate(opdSurgeryHeader);
                
                OpdSurgeryDetail opdSurgeryDetail=new OpdSurgeryDetail();
				MasChargeCode masChargeCode=new MasChargeCode();
				masChargeCode.setId(box.getInt("procedureId"+l));
				opdSurgeryDetail.setChargeCode(masChargeCode);
				opdSurgeryDetail.setOpdSurgery(opdSurgeryHeader);
				opdSurgeryDetail.setAnestheisaPacStatus("n");
				opdSurgeryDetail.setSurgeryStatus("n");
				opdSurgeryDetail.setDepartment(md);
				//opdSurgeryDetail.setTentativeDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("tentativeDate"+l)));
				//opdSurgeryDetail.setRemarks(box.getString("procRemarks"+i));
				hbt.save(opdSurgeryDetail);
				
//----------------------------------------------------------------------------				
				
				/*if(box.getInt("visitId")!=0){
					OpdPatientDetails OpdPatientDetails=new OpdPatientDetails();
				Visit visit=new Visit();
				visit.setId(box.getInt("visitId"));
				OpdPatientDetails.setVisit(visit);
				OpdPatientDetails.setHospital(masHospitalObj);
				OpdPatientDetails.setConsultationDate(new Date());
				OpdPatientDetails.setConsultationTime(currentTime);
				OpdPatientDetails.setOpdDate(new Date());
				OpdPatientDetails.setOpdTime(currentTime);
				if(box.getString("arname")!=null){
					OpdPatientDetails.setAdmissionAdvised(box.getString("arname"));
				}
				if(box.getString("arname")!=null){
					OpdPatientDetails.setAdmissionDate(HMSUtil.convertStringTypeDateToDateType((box.getString("arname"))));
				}
				if(box.getString("ward")!=null){
					MasDepartment md21=new MasDepartment();
					md21.setId(Integer.parseInt(box.getString("ward")));
					OpdPatientDetails.setAdmissionWard(md21);
					
				}
				
				hbt.save(OpdPatientDetails);
				}*/
		}
		
		}
		succesfullyAdded = true;
		tx.commit();
	} catch (Exception e) {
		if (tx != null) {
			tx.rollback();
		}
		e.printStackTrace();
		succesfullyAdded = false;
	}

	finally {
		// --------Session Closing----------
		session.close();
	}
		map.put("bool", succesfullyAdded);
		map.put("orderNo", orderNo);
		return map;
	}


	@Override
	public Map<String, Object> deleteDateFromTable(String dateDel,int hinId) {
		Session session = (Session)getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int k=0;
		try{
			String sql = "delete from temp_case_sheet where opd_date not in( to_date('"+dateDel+"','dd/mm/yyyy'))  and hin_id="+hinId;
			Query query = session.createSQLQuery(sql);
			k = query.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		map.put("k", k);
		return map;
	}

	@Override
	public Map<String, Object> runIntakeOutputProc(String hinNo, String serviceNo,
			int hospitalId, String admissionNumber) {
		Session session = (Session)getSession();
		Connection con = session.connection();
		try {
			CallableStatement cals = con.prepareCall("{call intakeoutput(?,?,?,?)}");
			cals.setString(1, hinNo);
			cals.setString(2, serviceNo);
			cals.setInt(3, hospitalId);
			cals.setString(4, admissionNumber);
			cals.execute();
			cals.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<String, Object> getItemStock(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreItemBatchStock> itemBatchStockList = new ArrayList<StoreItemBatchStock>();
		Session session = (Session)getSession();
		itemBatchStockList = session.createCriteria(StoreItemBatchStock.class)
						.add(Restrictions.eq("Item.Id", box.getInt("itemId")))
						.add(Restrictions.eq("BarcodeNo", box.get("barcode")))
						.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
						.list();

		/*//if(!box.getString("barcode").equals(""))
		//{
		itemBatchStockList = session.createCriteria(StoreItemBatchStock.class).createAlias("Item", "item").add(Restrictions.eq("item.Id", box.getInt("itemId")))
		.add(Restrictions.eq("Department.Id", box.getInt("deptId"))).add(Restrictions.eq("BarcodeNo",box.getString("barcode") )).list();
		}else if(box.getInt("batchNo")!=0){
			itemBatchStockList = session.createCriteria(StoreItemBatchStock.class).createAlias("Item", "item").add(Restrictions.eq("item.Id", box.getInt("itemId")))
			.add(Restrictions.eq("Department.Id", box.getInt("deptId"))).add(Restrictions.idEq(box.getInt("batchNo") )).list();

		}*/
		map.put("itemBatchStockList", itemBatchStockList);
		return map;
	}

	@Override
	public Map<String, Object> getProcedureForDischargeSummary(Map<String, Object> detailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<String> procedureList = new ArrayList<String>();
		int inpatientId = (Integer)detailsMap.get("inPatientId");
		Session session = (Session)getSession();
		procedureList = session.createCriteria(NursingcareSetup.class).createAlias("Nursing", "n").add(Restrictions.eq("n.NursingType", "p")).add(Restrictions.eq("Inpatient.id", inpatientId))
			.setProjection(Projections.distinct(Projections.property("n.NursingName"))).list();
		map.put("procedureList", procedureList);
		return map;
	}

	@Override
	public Map<String, Object> getTreatmentDetailsForDischargeSummary(Map<String, Object> detailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<String> prescriptionList = new ArrayList<String>();
		int inpatientId = (Integer)detailsMap.get("inPatientId");
		Session session = (Session)getSession();
		prescriptionList = session.createCriteria(PatientPrescriptionDetails.class).createAlias("Prescription", "p").createAlias("Item", "i").add(Restrictions.eq("p.Inpatient.id", inpatientId))
				.setProjection(Projections.distinct(Projections.property("i.Nomenclature"))).list();
		map.put("prescriptionList", prescriptionList);
		return map;
	}

	@Override
	public Map<String, Object> showNewCaseSheetJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<OpdPatientDetails> opdDetailsList = new ArrayList<OpdPatientDetails>();
		List<OpdPatientDetails> ipdDetailsList = new ArrayList<OpdPatientDetails>();		
		List<PatientPrescriptionHeader> opdPrescriptionList = new ArrayList<PatientPrescriptionHeader>();
		List<PatientInvestigationHeader> opdInvestigationList = new ArrayList<PatientInvestigationHeader>();
		List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
		List<MasStoreItemConversion> itemConversionList1 = new ArrayList<MasStoreItemConversion>();
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
		List<MasItemClass> masItemClassList = new ArrayList<MasItemClass>();
		List<MasItemClass> masItemClassList1 = new ArrayList<MasItemClass>();
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
		int hinId= inpatientList.get(0).getHin().getId();
		opdDetailsList = session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "v").createAlias("v.Hin", "hin").add(Restrictions.eq("hin.Id", hinId))
		.addOrder(Order.desc("id")).setMaxResults(1).list();
		ipdDetailsList = session.createCriteria(OpdPatientDetails.class).createAlias("Inpatient", "ip").add(Restrictions.eq("ip.Id", box.getInt("parent")))
		.addOrder(Order.desc("id")).list();

		if(opdDetailsList.size() > 0) {
			int visitId = 0;
			visitId = opdDetailsList.get(0).getVisit().getId();
			System.out.println("visitId"+visitId);
			
				opdPrescriptionList = session.createCriteria(PatientPrescriptionHeader.class).createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
				opdInvestigationList = session.createCriteria(PatientInvestigationHeader.class).createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
				icdList = session.createCriteria(DischargeIcdCode.class).createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
				System.out.println("icdList"+icdList.size());
				System.out.println("visitId1"+visitId);
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
				.createAlias("Doctor", "dt").add(Restrictions.eq("dt.Id", box.getInt("empId")))
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

		String []ItemClassIdForTopInDropDown =  properties.getProperty("ItemClassIdForTopInDropDown").trim().split(",");
		String []ItemConversionIdForTopInDropDown = properties.getProperty("ItemConversionIdForTopInDropDown").trim().split(",");
		masItemClassList= session.createCriteria(MasItemClass.class).
				add(Restrictions.eq("Status", "y").ignoreCase())
				 .addOrder(Order.asc("ItemClassName")) .list(); 
		
		for(MasItemClass ms:masItemClassList){
		  for(int i=0;i <ItemClassIdForTopInDropDown.length;i++)
		  {
			  if(Integer.parseInt(ItemClassIdForTopInDropDown[i])==ms.getId())
				  masItemClassList1.add(ms);
		  }
		  if(masItemClassList1.size()==ItemClassIdForTopInDropDown.length)
			  break;
		}
		
		masItemClassList.removeAll(masItemClassList1);
		masItemClassList.addAll(0, masItemClassList1);
		
		itemConversionList = session.createCriteria(MasStoreItemConversion.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ItemUnitName")).list();
		
		for(MasStoreItemConversion IC:itemConversionList){
			  for(int i=0;i <ItemConversionIdForTopInDropDown.length;i++)
			  {
				  if(Integer.parseInt(ItemConversionIdForTopInDropDown[i])==IC.getId())
					  itemConversionList1.add(IC);
			  }
			  if(itemConversionList1.size()==ItemConversionIdForTopInDropDown.length)
				  break;
			}
		itemConversionList.removeAll(itemConversionList1);
		itemConversionList.addAll(0, itemConversionList1);
		
		map.put("masImpanneledHospitalList", masImpanneledHospitalList);
		map.put("itemConversionList", itemConversionList);
		map.put("masItemClassList", masItemClassList);
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
	@Override
	public Map<String, Object> getPrevCaseNoteDiagnosis(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdPatientDetails> opdDetailsList = new ArrayList<OpdPatientDetails>();
		List<OpdPatientDetails> ipdDetailsList = new ArrayList<OpdPatientDetails>();
		List<OpdPatientDetails> caseSheetList = new ArrayList<OpdPatientDetails>();
		List<DischargeIcdCode> icdList = new ArrayList<DischargeIcdCode>();
		
		Session session = (Session)getSession();
		int hinId= box.getInt("hinId");
		opdDetailsList = session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "v").createAlias("v.Hin", "hin").add(Restrictions.eq("hin.Id", hinId))							
				            .addOrder(Order.desc("id")).setMaxResults(1).list();
		
		
		ipdDetailsList = session.createCriteria(OpdPatientDetails.class).createAlias("Inpatient", "ip").add(Restrictions.eq("ip.Id", box.getInt("parent")))
					.addOrder(Order.desc("id")).list();

		if(opdDetailsList.size() > 0) {
	
		  icdList = session.createCriteria(DischargeIcdCode.class).createAlias("Hin", "h").add(Restrictions.eq("h.Id", hinId)).list();
			System.out.println("jdjd"+icdList.size());
		
		}

		if(ipdDetailsList.size() > 0) {
			caseSheetList.addAll(ipdDetailsList);// to display all previous case sheet
			int opdPatientDetailsId = 0;
			opdPatientDetailsId = ipdDetailsList.get(0).getId();
			List<DischargeIcdCode> ipIcdList = new ArrayList<DischargeIcdCode>();
			ipIcdList = session.createCriteria(DischargeIcdCode.class).createAlias("Inpatient", "ip").add(Restrictions.eq("ip.id", box.getInt("parent"))).addOrder(Order.desc("Id")).list();
			
			/*icdList.addAll(ipIcdList);*/
			icdList.addAll(ipIcdList);
			
		}
		caseSheetList.addAll(opdDetailsList);
		map.put("caseSheetList", caseSheetList);
		map.put("icdList", icdList);
		
	
		return map;
	}

	@Override
	public Map<String, Object> getPrevTreatmentDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdPatientDetails> opdDetailsList = new ArrayList<OpdPatientDetails>();
		List<OpdPatientDetails> ipdDetailsList = new ArrayList<OpdPatientDetails>();
		List<PatientPrescriptionHeader> prescripionList = new ArrayList<PatientPrescriptionHeader>();
		List<PatientPrescriptionHeader> opdPrescriptionList = new ArrayList<PatientPrescriptionHeader>();
		
		Session session = (Session)getSession();
		int hinId= box.getInt("hinId");
		opdDetailsList = session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "v").createAlias("v.Hin", "hin").add(Restrictions.eq("hin.Id", hinId))
						.addOrder(Order.desc("id")).setMaxResults(1).list();
	
		int surgeryId = 0;
		
		if(box.get("opdSurgeryId")!=null)
		{
			surgeryId =box.getInt("opdSurgeryId");
		}
		
		if(opdDetailsList.size() > 0) {
			int visitId = 0;
			visitId = opdDetailsList.get(0).getVisit().getId();
			opdPrescriptionList = session.createCriteria(PatientPrescriptionHeader.class).createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
			/*opdPrescriptionList = session.createCriteria(PatientPrescriptionHeader.class).createAlias("Hin", "h").add(Restrictions.eq("h.Id", hinId)).list();*/
		}
		System.out.println("opdPrescriptionList"+opdPrescriptionList.size());

		List<PatientPrescriptionHeader> ipPrescriptionList = new ArrayList<PatientPrescriptionHeader>();
		ipPrescriptionList = session.createCriteria(PatientPrescriptionHeader.class).createAlias("Inpatient", "ip").add(Restrictions.eq("ip.id", box.getInt("parent"))).addOrder(Order.desc("Id")).list();
		System.out.println("ipPrescriptionList"+ipPrescriptionList.size());		
		prescripionList.addAll(ipPrescriptionList);
		prescripionList.addAll(opdPrescriptionList);
		
		
		
		
		map.put("prescripionList", prescripionList);
	
		return map;
	}

	@Override
	public Map<String, Object> getPrevInvestigationDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdPatientDetails> opdDetailsList = new ArrayList<OpdPatientDetails>();
		List<DgOrderhd> investigationList = new ArrayList<DgOrderhd>();
		List<DgOrderhd> opdInvestigationList = new ArrayList<DgOrderhd>();
		List<DgSampleCollectionDetails> dgSampleCollectionDetailsList = new ArrayList<DgSampleCollectionDetails>();
		int surgeryId = 0;
		
		if(box.get("opdSurgeryId")!=null)
		{
			surgeryId =box.getInt("opdSurgeryId");
		}
		
		Session session = (Session)getSession();
		int hinId= box.getInt("hinId");
		opdDetailsList = session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "v").createAlias("v.Hin", "hin").add(Restrictions.eq("hin.Id", hinId))
						.addOrder(Order.desc("id")).setMaxResults(1).list();
	

		if(opdDetailsList.size() > 0) {
			int visitId = 0;
			visitId = opdDetailsList.get(0).getVisit().getId();
			//opdInvestigationList = session.createCriteria(DgOrderhd.class).createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
			opdInvestigationList = session.createCriteria(DgOrderhd.class).createAlias("Visit", "v").add(Restrictions.eq("Hin.Id", hinId)).list();
			
			
		}
		List<DgOrderhd> ipInvetsigationList = new ArrayList<DgOrderhd>();
		ipInvetsigationList = session.createCriteria(DgOrderhd.class).createAlias("Inpatient", "ip").add(Restrictions.eq("ip.id", box.getInt("parent"))).addOrder(Order.desc("Id")).list();
		
		List<DgOrderhd> otInvetsigationList = new ArrayList<DgOrderhd>();
		otInvetsigationList = session.createCriteria(DgOrderhd.class).createAlias("Surgery", "ot").add(Restrictions.eq("ot.id", surgeryId)).addOrder(Order.desc("Id")).list();
		
		
		investigationList.addAll(ipInvetsigationList);
		investigationList.addAll(opdInvestigationList);
		investigationList.addAll(otInvetsigationList); 
		
		dgSampleCollectionDetailsList = session.createCriteria(DgSampleCollectionDetails.class).list();
		map.put("investigationList", investigationList);
		map.put("dgSampleCollectionDetailsList", dgSampleCollectionDetailsList);
		return map;
	}

	@Override
	public Map<String, Object> getPrevProcedureDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdPatientDetails> opdDetailsList = new ArrayList<OpdPatientDetails>();
/*		List<ProcedureHeader> procedureList = new ArrayList<ProcedureHeader>();*/	
		List<ProcedureHeader> opdProcedureList = new ArrayList<ProcedureHeader>();

		Session session = (Session)getSession();
		int hinId= box.getInt("hinId");
		opdDetailsList = session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "v").createAlias("v.Hin", "hin").add(Restrictions.eq("hin.Id", hinId))
						.addOrder(Order.desc("id")).setMaxResults(1).list();
	

		if(opdDetailsList.size() > 0) {
			int visitId = 0;
			visitId = opdDetailsList.get(0).getVisit().getId();
			opdProcedureList = session.createCriteria(ProcedureHeader.class).createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
			
		}
	
		List<NursingcareSetup> ipProcedureList = new ArrayList<NursingcareSetup>();
		ipProcedureList = session.createCriteria(NursingcareSetup.class).createAlias("Inpatient", "ip").add(Restrictions.eq("ip.id", box.getInt("parent"))).addOrder(Order.desc("Id")).list();
			
		map.put("ipProcedureList", ipProcedureList);
		map.put("opdProcedureList", opdProcedureList);
		return map;
	}

	@Override
	public Map<String, Object> getPrevDietDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<IpdPatientDiet> dietDetailsList = new ArrayList<IpdPatientDiet>();
		
		Session session = (Session)getSession();
			
		dietDetailsList = session.createCriteria(IpdPatientDiet.class).createAlias("Inpatient", "ip").add(Restrictions.eq("ip.id", box.getInt("parent"))).addOrder(Order.desc("Id")).list();
			
		map.put("dietDetailsList", dietDetailsList);
		return map;
	}
	
	@Override
	public Map<String, Object> getPrevConsultationDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PreAnesthesiaConsultDoctorDt> consultDoctorDtList = new ArrayList<PreAnesthesiaConsultDoctorDt>();
		
		Session session = (Session)getSession();			
		consultDoctorDtList = session.createCriteria(PreAnesthesiaConsultDoctorDt.class)
				.createAlias("ConsultDoctorIdHd", "hd")
				.createAlias("hd.Inpatient", "ip")
				.add(Restrictions.eq("ip.id", box.getInt("parent")))				
				.addOrder(Order.desc("Id")).list();			
		map.put("consultDoctorDtList", consultDoctorDtList);
		return map;
	}
	
	@Override
	public Map<String, Object> getTransferHistory(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Transfer> transferList = new ArrayList<Transfer>();
		
		Session session = (Session)getSession();			
		transferList = session.createCriteria(Transfer.class)
				.createAlias("Inpatient", "ip")				
				.add(Restrictions.eq("ip.id", box.getInt("parent")))				
				.addOrder(Order.desc("Id")).list();			
		map.put("transferList", transferList);
		return map;
	}

	@Override
	public Map<String, Object> getPrevPhysiotherapyDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdPatientDetails> opdDetailsList = new ArrayList<OpdPatientDetails>();
		List<PhysioRequisitionHeader> therapyList = new ArrayList<PhysioRequisitionHeader>();
		List<PhysioRequisitionHeader> opdTherapyList = new ArrayList<PhysioRequisitionHeader>();
		
		Session session = (Session)getSession();
		int hinId= box.getInt("hinId");
		opdDetailsList = session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "v").createAlias("v.Hin", "hin").add(Restrictions.eq("hin.Id", hinId))
						.addOrder(Order.desc("id")).setMaxResults(1).list();
	

		if(opdDetailsList.size() > 0) {
			int visitId = 0;
			visitId = opdDetailsList.get(0).getVisit().getId();
			opdTherapyList = session.createCriteria(PhysioRequisitionHeader.class).createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
			
		}

	
		List<PhysioRequisitionHeader> ipTherapyList = new ArrayList<PhysioRequisitionHeader>();
		ipTherapyList = session.createCriteria(PhysioRequisitionHeader.class).createAlias("Inpatient", "ip").add(Restrictions.eq("ip.id", box.getInt("parent"))).addOrder(Order.desc("Id")).list();
			
		therapyList.addAll(ipTherapyList);
		therapyList.addAll(opdTherapyList); 
		
		
		map.put("therapyList", therapyList);
		return map;
	}

	public void executeProcedureForDMADutyReport(Map<String, Object> parameters) {
		Session session = (Session)getSession();
		Connection con = session.connection();
		String fromTime= (String)parameters.get("fromTime");
		String toTime=(String)parameters.get("toTime");
		Date fromDate= (Date)parameters.get("fromDate");
		Date toDate=(Date)parameters.get("toDate");
		int hospitalId =(Integer)parameters.get("hospitalId");
		int dmaId = (Integer)parameters.get("dmaId");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		try {
			
			CallableStatement cals = con.prepareCall("{call dma_duty_details(?,?,?,?,?,?)}");
			cals.setString(1,  sdf.format(fromDate));
			cals.setString(2,  sdf.format(toDate));
			cals.setString(3, fromTime);
			cals.setString(4, toTime);
			cals.setInt(5, hospitalId);
			cals.setInt(6, dmaId);
			cals.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Map<String, Object> showSpecialistOpinionJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		Session session = (Session)getSession();
		inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.idEq(box.getInt("parent"))).list();
		map.put("inpatientList", inpatientList);
		return map;
	}

	@Override
	public Map<String, Object> submitIpdSplcialistOpinion(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setCheckWriteOperations(false);
		hbt.setFlushModeName("FLUSH_EAGER");
		
		Transaction tx = null;
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		
		boolean flag = false;
		try {
			tx = session.beginTransaction();
			IpdSpecialistOpinion ipdSpecialistOpinion = new IpdSpecialistOpinion();
			ipdSpecialistOpinion.setCourseOfIllness(box.getString("courseOfIllness"));
			ipdSpecialistOpinion.setGeneralExam(box.getString("generalExam"));
			ipdSpecialistOpinion.setWeight(box.getString("weight"));
			ipdSpecialistOpinion.setHeight(box.getString("height"));
			ipdSpecialistOpinion.setBmi(box.getString("bmi"));
			ipdSpecialistOpinion.setIdealWeight(box.getString("idealWeight"));
			ipdSpecialistOpinion.setTemperature(box.getString("temperature"));
			ipdSpecialistOpinion.setPulse(box.getString("pulse"));
			ipdSpecialistOpinion.setBp(box.getString("bp"));
			ipdSpecialistOpinion.setRr(box.getString("rr"));
			ipdSpecialistOpinion.setGeneralPhysicalExam(box.getString("generalPhysicalExam"));
			ipdSpecialistOpinion.setCardiovascularSyatem(box.getString("cardiovascularSystem"));
			ipdSpecialistOpinion.setRespiratorySystem(box.getString("respiratorySystem"));
			ipdSpecialistOpinion.setGastroIntestinalSystem(box.getString("gastroIntestinalSystem"));
			ipdSpecialistOpinion.setCentralNervousSystem(box.getString("centralNervousSystem"));
			ipdSpecialistOpinion.setSpecialistOpenion(box.getString("SpecilaistOpinion"));
			ipdSpecialistOpinion.setTreatmentAdvice(box.getString("SpecilaistTreatmentAdvice"));
			Inpatient inpatient = new Inpatient();
			inpatient.setId(box.getInt("inpatientId"));
			ipdSpecialistOpinion.setInpatient(inpatient);
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			ipdSpecialistOpinion.setHospital(hospital);
			
			ipdSpecialistOpinion.setMo(box.getString("mo"));
			
			Users user = new Users();
			user.setId(box.getInt("userId"));
			ipdSpecialistOpinion.setLastChgBy(user);
			
			ipdSpecialistOpinion.setLastChangedDate(HMSUtil.convertStringTypeDateToDateType(date));
			ipdSpecialistOpinion.setLastChangedTime(time);
			
			hbt.save(ipdSpecialistOpinion);
			
			
			tx.commit();
			flag = true;
		} catch (Exception e) {
			if(tx!=null)
				tx.rollback();
		}
		map.put("flag", flag);
		return map;
	}

	@Override
	public Map<String, Object> getSpecialistOpinionDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<IpdSpecialistOpinion> splOpinionList = new ArrayList<IpdSpecialistOpinion>();
		
		splOpinionList = session.createCriteria(IpdSpecialistOpinion.class).add(Restrictions.idEq(box.getInt("ipdSpecialistOpinionId"))).list();
		map.put("splOpinionList", splOpinionList);
		return map;
	}

	@Override
	public Map<String, Object> viewSpecialistOpinion(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<IpdSpecialistOpinion> splOpinionList = new ArrayList<IpdSpecialistOpinion>();
		
		splOpinionList = session.createCriteria(IpdSpecialistOpinion.class).add(Restrictions.eq("Inpatient.Id", box.getInt("inpatientId"))).list();
		map.put("splOpinionList", splOpinionList);
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
}
