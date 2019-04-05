package jkt.hms.dental.dataservice;

import java.net.URL;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import jkt.hms.masters.business.DentalTreatmentDetail;
import jkt.hms.masters.business.DentalTreatmentHeader;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgOrderdt;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DgSampleCollectionDetails;
import jkt.hms.masters.business.DischargeIcdCode;
import jkt.hms.masters.business.InjAppointmentDetails;
import jkt.hms.masters.business.InjAppointmentHeader;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAnesthesia;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDisposal;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasIcd;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasMaritalStatus;
import jkt.hms.masters.business.MasNursingCare;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRankCategory;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasSection;
import jkt.hms.masters.business.MasServiceStatus;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreItemConversion;
import jkt.hms.masters.business.MasStoreSection;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.MasSystemDiagnosis;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.OpdPatientHistory;
import jkt.hms.masters.business.OpdTemplate;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientInvestigationDetails;
import jkt.hms.masters.business.PatientInvestigationHeader;
import jkt.hms.masters.business.PatientPrescriptionDetails;
import jkt.hms.masters.business.PatientPrescriptionHeader;
import jkt.hms.masters.business.ProcedureDetails;
import jkt.hms.masters.business.ProcedureHeader;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.opd.handler.OPDHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import static jkt.hms.util.RequestConstants.CONSULTING_DOCTOR;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.LAST_CHANGED_DATE;
import static jkt.hms.util.RequestConstants.LAST_CHANGED_TIME;
import static jkt.hms.util.RequestConstants.MARITAL_STATUS_ID;
import static jkt.hms.util.RequestConstants.MEDICINE;
import static jkt.hms.util.RequestConstants.MUR_8;
import static jkt.hms.util.RequestConstants.MUR_7;
import static jkt.hms.util.RequestConstants.MUR_6;
import static jkt.hms.util.RequestConstants.MUR_5;
import static jkt.hms.util.RequestConstants.MUR_4;
import static jkt.hms.util.RequestConstants.MUR_3;
import static jkt.hms.util.RequestConstants.MUR_2;
import static jkt.hms.util.RequestConstants.MUR_1;
import static jkt.hms.util.RequestConstants.MUL_8;
import static jkt.hms.util.RequestConstants.MUL_7;
import static jkt.hms.util.RequestConstants.MUL_6;
import static jkt.hms.util.RequestConstants.MUL_5;
import static jkt.hms.util.RequestConstants.MUL_4;
import static jkt.hms.util.RequestConstants.MUL_3;
import static jkt.hms.util.RequestConstants.MUL_2;
import static jkt.hms.util.RequestConstants.MUL_1;
import static jkt.hms.util.RequestConstants.MLR_8;
import static jkt.hms.util.RequestConstants.MLR_7;
import static jkt.hms.util.RequestConstants.MLR_6;
import static jkt.hms.util.RequestConstants.MLR_5;
import static jkt.hms.util.RequestConstants.MLR_4;
import static jkt.hms.util.RequestConstants.MLR_3;
import static jkt.hms.util.RequestConstants.MLR_2;
import static jkt.hms.util.RequestConstants.MLR_1;
import static jkt.hms.util.RequestConstants.MLL_8;
import static jkt.hms.util.RequestConstants.MLL_7;
import static jkt.hms.util.RequestConstants.MLL_6;
import static jkt.hms.util.RequestConstants.MLL_5;
import static jkt.hms.util.RequestConstants.MLL_4;
import static jkt.hms.util.RequestConstants.MLL_3;
import static jkt.hms.util.RequestConstants.MLL_2;
import static jkt.hms.util.RequestConstants.MLL_1;
import static jkt.hms.util.RequestConstants.RANK_CATEGORY_ID;
import static jkt.hms.util.RequestConstants.RELATION_ID;
import static jkt.hms.util.RequestConstants.SECTION_ID;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.SERVICE_STATUS_ID;
import static jkt.hms.util.RequestConstants.SERVICE_TYPE_ID;
import static jkt.hms.util.RequestConstants.SEX_ID;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.TRADE_ID;
import static jkt.hms.util.RequestConstants.UNIT_ID;
import static jkt.hms.util.RequestConstants.UUR_8;
import static jkt.hms.util.RequestConstants.UUR_7;
import static jkt.hms.util.RequestConstants.UUR_6;
import static jkt.hms.util.RequestConstants.UUR_5;
import static jkt.hms.util.RequestConstants.UUR_4;
import static jkt.hms.util.RequestConstants.UUR_3;
import static jkt.hms.util.RequestConstants.UUR_2;
import static jkt.hms.util.RequestConstants.UUR_1;
import static jkt.hms.util.RequestConstants.UUL_8;
import static jkt.hms.util.RequestConstants.UUL_7;
import static jkt.hms.util.RequestConstants.UUL_6;
import static jkt.hms.util.RequestConstants.UUL_5;
import static jkt.hms.util.RequestConstants.UUL_4;
import static jkt.hms.util.RequestConstants.UUL_3;
import static jkt.hms.util.RequestConstants.UUL_2;
import static jkt.hms.util.RequestConstants.UUL_1;
import static jkt.hms.util.RequestConstants.ULR_8;
import static jkt.hms.util.RequestConstants.ULR_7;
import static jkt.hms.util.RequestConstants.ULR_6;
import static jkt.hms.util.RequestConstants.ULR_5;
import static jkt.hms.util.RequestConstants.ULR_4;
import static jkt.hms.util.RequestConstants.ULR_3;
import static jkt.hms.util.RequestConstants.ULR_2;
import static jkt.hms.util.RequestConstants.ULR_1;
import static jkt.hms.util.RequestConstants.ULL_8;
import static jkt.hms.util.RequestConstants.ULL_7;
import static jkt.hms.util.RequestConstants.ULL_6;
import static jkt.hms.util.RequestConstants.ULL_5;
import static jkt.hms.util.RequestConstants.ULL_4;
import static jkt.hms.util.RequestConstants.ULL_3;
import static jkt.hms.util.RequestConstants.ULL_2;
import static jkt.hms.util.RequestConstants.ULL_1;
import static jkt.hms.util.RequestConstants.TOTAL_NO_OF_TEETH;
import static jkt.hms.util.RequestConstants.DEFECTIVE_TEETH;
import static jkt.hms.util.RequestConstants.DIAGNOSIS_ID;


public class DentalDataServiceImpl extends HibernateDaoSupport implements DentalDataService {

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getDentalWaitingList(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> dentalWaitingList = new ArrayList<Visit>();
		@SuppressWarnings("unused")
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		Session session = (Session)getSession();
		Box box = null;
		if(mapForDs.get("box") != null){
			box = (Box)mapForDs.get("box");
		}
		int hospitalId  = 0;
		if(box.getInt("hospitalId") != 0){
			hospitalId =(Integer)box.getInt("hospitalId");
		}
		Date date = new Date();
		try {
			if (box.getInt("empId") != 0) {
				dentalWaitingList = session.createCriteria(Visit.class).add(
						Restrictions.eq("VisitDate", date)).add(
						Restrictions.eq("VisitStatus", "w"))
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("ReportingFor", "Dental")).addOrder(Order.asc("TokenNo")).list();
				map.put("empId", box.getInt("empId"));
			} else {
				dentalWaitingList = session.createCriteria(Visit.class).add(
						Restrictions.eq("VisitDate", date)).add(
						Restrictions.eq("VisitStatus", "w")).add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("ReportingFor", "Dental"))
						.addOrder(Order.asc("TokenNo")).list();
			}
			/*doctorList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
			.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", box.getInt("hospitalId"))).list();
			Map<String, Object> deptMap = getDepartmentNameFromId(deptId);
			if (deptMap.get("deptName") != null) {
				deptName = (String) deptMap.get("deptName");
			}*/
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("dentalWaitingList", dentalWaitingList);
		return map;
	}

	@Override
	public Map<String, Object> getDentalPatientDataList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit>dentalPatientDataList = new ArrayList<Visit>();
		List<MasFrequency>frequencyList = new ArrayList<MasFrequency>();
		List<MasAnesthesia> anesthesiaList = new ArrayList<MasAnesthesia>();
		List<DischargeIcdCode> dischargeIcdCodeList = new ArrayList<DischargeIcdCode>();
		List<MasServiceType> disposalTypeList = new ArrayList<MasServiceType>();
		Session session = (Session)getSession();
		int visitId = 0;
		if(dataMap.get("visitId") != null){
			visitId = (Integer)dataMap.get("visitId");
		}
		dentalPatientDataList = session.createCriteria(Visit.class).add(Restrictions.idEq(visitId)).list();
		frequencyList = session.createCriteria(MasFrequency.class).add(
				Restrictions.eq("Status", "y")).list();
		anesthesiaList = session.createCriteria(MasAnesthesia.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AnesthesiaName")).list();
		dischargeIcdCodeList = session.createCriteria(DischargeIcdCode.class).list();
		disposalTypeList = session.createCriteria(MasDisposal.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DisposalName")).list();
		map.put("disposalTypeList", disposalTypeList);
		map.put("dentalPatientDataList", dentalPatientDataList);
		map.put("frequencyList", frequencyList);
		map.put("anesthesiaList", anesthesiaList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> submitDentalTreatmentDetails(Box box,Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Transaction tx = null;
		String orderSeqNo = "";
		int hospitalId  = 0;
		int deptId = 0;
		List pvmsNoList = (List) mapForDS.get("pvmsNoList");
		List<Integer> frequencyList = (List) mapForDS.get("frequencyList");
		List<String> otherMedicineList = (List) mapForDS.get("otherMedicineList");
		List<String> ctList = (List) mapForDS.get("ctList");
		List<String> dosageList = (List) mapForDS.get("dosageList");
		List<String> typeLeftRightList = (List) mapForDS.get("typeLeftRightList");
		List<String> instructionList = (List) mapForDS.get("instructionList");
		List<String> routeList= (List) mapForDS.get("routeList");
		List<Integer> totalList = (List) mapForDS.get("totalList");
		List<Integer> noOfDaysList = (List) mapForDS.get("noOfDaysList");
		List<String> remarksList = (List) mapForDS.get("remarksList");
		List<Integer> itemIdList = new ArrayList<Integer>();
		List<String> chargeCodeIdList = (List) mapForDS.get("chargeCodeIdList");
		List<String> referToMhList = new ArrayList<String>();
		if((List)mapForDS.get("referToMhList") != null){
			referToMhList = (List)mapForDS.get("referToMhList");
		}
		int systemDiagnosisId = 0;
		if(mapForDS.get("systemDiagnosisId") != null){
			systemDiagnosisId = (Integer)mapForDS.get("systemDiagnosisId");
		}
		if(mapForDS.get("hospitalId") != null){
			hospitalId = (Integer)mapForDS.get("hospitalId");
		}
		if(mapForDS.get("deptId") != null){
			deptId = (Integer)mapForDS.get("deptId");
		}
		String[] diagnosisIdAray = null;
		if(mapForDS.get("diagnosisIdAray") != null){
		diagnosisIdAray = (String[]) mapForDS.get("diagnosisIdAray");
		}
		String referedToMH = "";
		if(mapForDS.get("referedToMH") != null){
		  referedToMH =(String) mapForDS.get("referedToMH");
		}
		String mhString = "";
		if(mapForDS.get("mh")!=null){
			mhString = (String) mapForDS.get("mh");
		}
		String mhDepartment = "";
		if(mapForDS.get("mhDepartment")!=null){
			mhDepartment = (String) mapForDS.get("mhDepartment");
		}
		String mhReferredFor = "";
		if(mapForDS.get("mhReferredFor")!=null){
			mhReferredFor = (String) mapForDS.get("mhReferredFor");
		}
		String disposal = "";
		if(mapForDS.get("disposal")!=null){
			disposal = (String) mapForDS.get("disposal");
		}
		String days = "";
		if(mapForDS.get("days")!=null){
			days = (String) mapForDS.get("days");
		}
		boolean succesfullyAdded = false;
		try {
			tx = session.beginTransaction();
			Patient patientObj = new Patient();
			MasHospital masHospital = new MasHospital();
			Visit visit=new Visit();
			MasDepartment masDepartment = new MasDepartment();
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentTimeWithoutSecond();
			String currentDate = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");
			OpdPatientDetails opdPatientDetails =  new OpdPatientDetails();
			OpdPatientHistory opdPatientHistory = new OpdPatientHistory();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if(box.getInt("visitId") != 0){
				Visit visitObj = new Visit();
				visitObj.setId(box.getInt("visitId"));
				opdPatientDetails.setVisit(visitObj);
			if(box.getInt("hospitalId") != 0){
				masHospital.setId(box.getInt("hospitalId"));
				opdPatientDetails.setHospital(masHospital);
			}
			if(box.getInt("empId") !=0){
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(box.getInt("empId"));
				opdPatientDetails.setEmployee(masEmployee);
			}
			opdPatientDetails.setDMainComplaint(box.getString("mainCompId"));
			opdPatientDetails.setDSince1(box.getString("since").concat(box.getString("sinceUnit")));
			opdPatientDetails.setDRemarks1(box.getString("sinceRemarks"));
			opdPatientDetails.setDAssociatedComplaint(box.getString("associatedComplaint"));
			opdPatientDetails.setDSince2(box.getString("associatedSince").concat(box.getString("associatedSince")));
			opdPatientDetails.setDRemarks2(box.getString("associatedRemarks"));
			opdPatientDetails.setNoOfTeeth(box.getInt(TOTAL_NO_OF_TEETH));
			opdPatientDetails.setNoOfDefectiveTeeth(box.getInt(DEFECTIVE_TEETH));
			opdPatientDetails.setNoOfDentalPoints(box.getInt("dentalPoints"));
			opdPatientDetails.setMissingTeeth(box.getInt("missingTeeth"));
			opdPatientDetails.setUnSaveableTeeth(box.getInt("unsaveableTeeth"));
			opdPatientDetails.setConditionOfGums(box.getString("conditionOfGums"));
			opdPatientDetails.setInitialDiagnosis(box.getString("workingDiagnosis"));
			opdPatientDetails.setDTreatment(box.getString("dentalTreatment"));
			opdPatientDetails.setDDtc(box.getString("dtc"));
			opdPatientDetails.setDTreatmentRemark(box.getString("treatmentRemarks"));
			opdPatientDetails.setAnesthesiaRemark(box.getString("anesthesiaRemark"));
			opdPatientDetails.setTeethExtracted(box.getInt("teethExtracted"));
			opdPatientDetails.setTeethConservesWithRt(box.getInt("teethConservesWithRt"));
			opdPatientDetails.setTeethConservesWithoutRt(box.getInt("teethConservesWithOutRt"));
			opdPatientDetails.setDenturesFittedNew(box.getInt("denturesFittedNew"));
			opdPatientDetails.setDenturesFittedRemodels(box.getInt("denturesFittedRemodels"));
			opdPatientDetails.setDenturesFittedRepairs(box.getInt("denturesFittedRepairs"));
			opdPatientDetails.setSpecialisedTreatment(box.getString("specialisedTreatment"));
			opdPatientDetails.setConsultationDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			opdPatientDetails.setConsultationTime(time);
			opdPatientDetails.setOpdDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			opdPatientDetails.setOpdTime(time);
			opdPatientDetails.setTotalMissingTeeth(box.getString("MissTeeth"));
			opdPatientDetails.setTotalUnsaveableTeeth(box.getString("UnserTeeth"));
			opdPatientDetails.setDentalValue(box.getString("dentalValue"));
			opdPatientDetails.setDisposal(disposal);
			opdPatientDetails.setDays(days);
			opdPatientDetails.setTreatableTooth(box.getString("treatableTooth"));
			if(box.getInt("anesthesiaId") != 0){
				MasAnesthesia masAnesthesia = new MasAnesthesia();
				masAnesthesia.setId(box.getInt("anesthesiaId"));
				opdPatientDetails.setAnesthesia(masAnesthesia);
			}
			if(systemDiagnosisId != 0){
				MasSystemDiagnosis systemDiagnosis = new MasSystemDiagnosis();
				systemDiagnosis.setId(systemDiagnosisId);
				opdPatientDetails.setSystemDiagnosis(systemDiagnosis);
			}
			if(!box.getString("teethRemarks").equals("")){
				opdPatientDetails.setMissingTeethRemark(box.getString("teethRemarks"));
			}
			if(!box.getString("nextVisiDate").equals("")){
				opdPatientDetails.setNextVisitDate(HMSUtil.convertStringTypeDateToDateType(box.getString("nextVisiDate")));
			}
			if(referedToMH.equals("y")){
				opdPatientDetails.setMh(mhString);
				opdPatientDetails.setMhDepartment(mhDepartment);
				opdPatientDetails.setMhReferredFor(mhReferredFor);
			}
		//---------------------code for Missing Teeth------------------------------//
				String mur8 = "";
				String mur7 = "";
				String mur6 = "";
				String mur5 = "";
				String mur4 = "";
				String mur3 = "";
				String mur2 = "";
				String mur1 = "";
				String mul8 = "";
				String mul7 = "";
				String mul6 = "";
				String mul5 = "";
				String mul4 = "";
				String mul3 = "";
				String mul2 = "";
				String mul1 = "";
				String mlr8 = "";
				String mlr7 = "";
				String mlr6 = "";
				String mlr5 = "";
				String mlr4 = "";
				String mlr3 = "";
				String mlr2 = "";
				String mlr1 = "";
				String mll8 = "";
				String mll7 = "";
				String mll6 = "";
				String mll5 = "";
				String mll4 = "";
				String mll3= "";
				String mll2 = "";
				String mll1 = "";
				String uur8 = "";
				String uur7 = "";
				String uur6 = "";
				String uur5 = "";
				String uur4 = "";
				String uur3 = "";
				String uur2 = "";
				String uur1 = "";
				String uul8 = "";
				String uul7 = "";
				String uul6 = "";
				String uul5 = "";
				String uul4 = "";
				String uul3 = "";
				String uul2 = "";
				String uul1 = "";
				String ulr8 = "";
				String ulr7 = "";
				String ulr6 = "";
				String ulr5 = "";
				String ulr4 = "";
				String ulr3 = "";
				String ulr2 = "";
				String ulr1 = "";
				String ull8 = "";
				String ull7 = "";
				String ull6 = "";
				String ull5 = "";
				String ull4 = "";
				String ull3 = "";
				String ull2 = "";
				String ull1 = "";
				if (!box.getString(MUR_8).equals("")) {
					mur8 = box.getString(MUR_8);
				} else {
					mur8 = "N";
				}
				if (!box.getString(MUR_7).equals("")) {
					mur7 = box.getString(MUR_7);
				} else {
					mur7 = "N";
				}
				if (!box.getString(MUR_6).equals("")) {
					mur6 = box.getString(MUR_6);
				} else {
					mur6 = "N";
				}
				if (!box.getString(MUR_5).equals("")) {
					mur5 = box.getString(MUR_5);
				} else {
					mur5 = "N";
				}
				if (!box.getString(MUR_4).equals("")) {
					mur4 = box.getString(MUR_4);
				} else {
					mur4 = "N";
				}
				if (!box.getString(MUR_3).equals("")) {
					mur3 = box.getString(MUR_3);
				} else {
					mur3 = "N";
				}
				if (!box.getString(MUR_2).equals("")) {
					mur2 = box.getString(MUR_2);
				} else {
					mur2 = "N";
				}
				if (!box.getString(MUR_1).equals("")) {
					mur1 = box.getString(MUR_1);
				} else {
					mur1 = "N";
				}
				if (!box.getString(MUL_8).equals("")) {
					mul8 = box.getString(MUL_8);
				} else {
					mul8 = "N";
				}
				if (!box.getString(MUL_7).equals("")) {
					mul7 = box.getString(MUL_7);
				} else {
					mul7 = "N";
				}
				if (!box.getString(MUL_6).equals("")) {
					mul6 = box.getString(MUL_6);
				} else {
					mul6 = "N";
				}
				if (!box.getString(MUL_5).equals("")) {
					mul5 = box.getString(MUL_5);
				} else {
					mul5 = "N";
				}
				if (!box.getString(MUL_4).equals("")) {
					mul4 = box.getString(MUL_4);
				} else {
					mul4 = "N";
				}
				if (!box.getString(MUL_3).equals("")) {
					mul3 = box.getString(MUL_3);
				} else {
					mul3 = "N";
				}
				if (!box.getString(MUL_2).equals("")) {
					mul2 = box.getString(MUL_2);
				} else {
					mul2 = "N";
				}
				if (!box.getString(MUL_1).equals("")) {
					mul1 = box.getString(MUL_1);
				} else {
					mul1 = "N";
				}
				if (!box.getString(MLR_8).equals("")) {
					mlr8 = box.getString(MLR_8);
				} else {
					mlr8 = "N";
				}
				if (!box.getString(MLR_7).equals("")) {
					mlr7 = box.getString(MLR_7);
				} else {
					mlr7 = "N";
				}
				if (!box.getString(MLR_6).equals("")) {
					mlr6 = box.getString(MLR_6);
				} else {
					mlr6 = "N";
				}
				if (!box.getString(MLR_5).equals("")) {
					mlr5 = box.getString(MLR_5);
				} else {
					mlr5 = "N";
				}
				if (!box.getString(MLR_4).equals("")) {
					mlr4 = box.getString(MLR_4);
				} else {
					mlr4 = "N";
				}
				if (!box.getString(MLR_3).equals("")) {
					mlr3= box.getString(MLR_3);
				} else {
					mlr3 = "N";
				}
				if (!box.getString(MLR_2).equals("")) {
					mlr2 = box.getString(MLR_2);
				} else {
					mlr2 = "N";
				}
				if (!box.getString(MLR_1).equals("")) {
					mlr1 = box.getString(MLR_1);
				} else {
					mlr1 = "N";
				}
				if (!box.getString(MLL_8).equals("")) {
					mll8 = box.getString(MLL_8);
				} else {
					mll8 = "N";
				}
				if (!box.getString(MLL_7).equals("")) {
					mll7 = box.getString(MLL_7);
				} else {
					mll7 = "N";
				}
				if (!box.getString(MLL_6).equals("")) {
					mll6 = box.getString(MLL_6);
				} else {
					mll6 = "N";
				}
				if (!box.getString(MLL_5).equals("")) {
					mll5 = box.getString(MLL_5);
				} else {
					mll5 = "N";
				}
				if (!box.getString(MLL_4).equals("")) {
					mll4 = box.getString(MLL_4);
				} else {
					mll4 = "N";
				}
				if (!box.getString(MLL_3).equals("")) {
					mll3 = box.getString(MLL_3);
				} else {
					mll3 = "N";
				}
				if (!box.getString(MLL_2).equals("")) {
					mll2 = box.getString(MLL_2);
				} else {
					mll2 = "N";
				}
				if (!box.getString(MLL_1).equals("")) {
					mll1 = box.getString(MLL_1);
				} else {
					mll1 = "N";
				}
				if (!box.getString(UUR_8).equals("")) {
					uur8 = box.getString(UUR_8);
				} else {
					uur8 = "N";
				}
				if (!box.getString(UUR_7).equals("")) {
					uur7 = box.getString(UUR_7);
				} else {
					uur7 = "N";
				}
				if (!box.getString(UUR_6).equals("")) {
					uur6 = box.getString(UUR_6);
				} else {
					uur6 = "N";
				}
				if (!box.getString(UUR_5).equals("")) {
					uur5 = box.getString(UUR_5);
				} else {
					uur5 = "N";
				}
				if (!box.getString(UUR_4).equals("")) {
					uur4 = box.getString(UUR_4);
				} else {
					uur4 = "N";
				}
				if (!box.getString(UUR_3).equals("")) {
					uur3 = box.getString(UUR_3);
				} else {
					uur3 = "N";
				}
				if (!box.getString(UUR_2).equals("")) {
					uur2 = box.getString(UUR_2);
				} else {
					uur2 = "N";
				}
				if (box.getString(UUR_1).equals("")) {
					uur1 = box.getString(UUR_1);
				} else {
					uur1 = "N";
				}
				if (!box.getString(UUL_8).equals("")) {
					uul8 = box.getString(UUL_8);
				} else {
					uul8 = "N";
				}
				if (box.getString(UUL_7).equals("")) {
					uul7 = box.getString(UUL_7);
				} else {
					uul7 = "N";
				}
				if (!box.getString(UUL_6).equals("")) {
					uul6 = box.getString(UUL_6);
				} else {
					uul6 = "N";
				}
				if (!box.getString(UUL_5).equals("")) {
					uul5 = box.getString(UUL_5);
				} else {
					uul5 = "N";
				}
				if (!box.getString(UUL_4).equals("")) {
					uul4 = box.getString(UUL_4);
				} else {
					uul4 = "N";
				}
				if (!box.getString(UUL_3).equals("")) {
					uul3 = box.getString(UUL_3);
				} else {
					uul3 = "N";
				}
				if (!box.getString(UUL_2).equals("")) {
					uul2 = box.getString(UUL_2);
				} else {
					uul2 = "N";
				}
				if (!box.getString(UUL_1).equals("")) {
					uul1 = box.getString(UUL_1);
				} else {
					uul1 = "N";
				}
				if (!box.getString(ULR_8).equals("")) {
					ulr8 = box.getString(UUL_8);
				} else {
					ulr8 = "N";
				}
				if (!box.getString(ULR_7).equals("")) {
					ulr7 = box.getString(UUL_7);
				} else {
					ulr7 = "N";
				}
				if (!box.getString(ULR_6).equals("")) {
					ulr6 = box.getString(UUL_6);
				} else {
					ulr6 = "N";
				}
				if (!box.getString(ULR_5).equals("")) {
					ulr5 = box.getString(UUL_5);
				} else {
					ulr5 = "N";
				}
				if (!box.getString(ULR_4).equals("")) {
					ulr4 = box.getString(UUL_4);
				} else {
					ulr4 = "N";
				}
				if (!box.getString(ULR_3).equals("")) {
					ulr3 = box.getString(UUL_3);
				} else {
					ulr3 = "N";
				}
				if (!box.getString(ULR_2).equals("")) {
					ulr2 = box.getString(UUL_2);
				} else {
					ulr2 = "N";
				}
				if (!box.getString(ULR_1).equals("")) {
					ulr1 = box.getString(UUL_1);
				} else {
					ulr1 = "N";
				}
				if (!box.getString(ULL_8).equals("")) {
					ull8 = box.getString(ULL_8);
				} else {
					ull8 = "N";
				}
				if (!box.getString(ULL_7).equals("")) {
					ull7 = box.getString(ULL_7);
				} else {
					ull7 = "N";
				}
				if (!box.getString(ULL_6).equals("")) {
					ull6 = box.getString(ULL_6);
				} else {
					ull6 = "N";
				}
				if (!box.getString(ULL_5).equals("")) {
					ull5 = box.getString(ULL_5);
				} else {
					ull5 = "N";
				}
				if (!box.getString(ULL_4).equals("")) {
					ull4 = box.getString(ULL_4);
				} else {
					ull4 = "N";
				}
				if (!box.getString(ULL_3).equals("")) {
					ull3 = box.getString(ULL_3);
				} else {
					ull3 = "N";
				}
				if (box.getString(ULL_2).equals("")) {
					ull2 = box.getString(ULL_2);
				} else {
					ull2 = "N";
				}
				if (!box.getString(ULL_1).equals("")) {
					ull8 = box.getString(ULL_1);
				} else {
					ull8 = "N";
				}
				String sur8 = "";
				String sur7 = "";
				String sur6 = "";
				String sur5 = "";
				String sur4 = "";
				String sur3 = "";
				String sur2 = "";
				String sur1 = "";
				String sul8 = "";
				String sul7 = "";
				String sul6 = "";
				String sul5 = "";
				String sul4 = "";
				String sul3 = "";
				String sul2 = "";
				String sul1 = "";
				String slr8 = "";
				String slr7 = "";
				String slr6 = "";
				String slr5 = "";
				String slr4 = "";
				String slr3 = "";
				String slr2 = "";
				String slr1 = "";
				String sll8 = "";
				String sll7 = "";
				String sll6 = "";

				String sll5 = "";
				String sll4 = "";
				String sll3 = "";
				String sll2 = "";
				String sll1 = "";
				sur8 = mur8 + "" + uur8;
				sur7 = mur7 + "" + uur7;
				sur6 = mur6 + "" + uur6;
				sur5 = mur5 + "" + uur5;
				sur4 = mur4 + "" + uur4;
				sur3 = mur3 + "" + uur3;
				sur2 = mur2 + "" + uur2;
				sur1 = mur2 + "" + uur1;
				sul8 = mul8 + "" + uul8;
				sul7 = mul7 + "" + uul7;
				sul6 = mul6 + "" + uul6;
				sul5 = mul5 + "" + uul5;
				sul4 = mul4 + "" + uul4;
				sul3 = mul3 + "" + uul3;
				sul2 = mul2 + "" + uul2;
				sul1 = mul1 + "" + uul1;
				slr8 = mlr8 + "" + ulr8;
				slr7 = mlr7 + "" + ulr7;
				slr6 = mlr6 + "" + ulr6;
				slr5 = mlr5 + "" + ulr5;
				slr4 = mlr4 + "" + ulr4;
				slr3 = mlr3 + "" + ulr3;
				slr2 = mlr2 + "" + ulr2;
				slr1 = mlr2 + "" + ulr1;
				sll8 = mll8 + "" + ull8;
				sll7 = mll7 + "" + ull7;
				sll6 = mll6 + "" + ull6;
				sll5 = mll5 + "" + ull5;
				sll4 = mll4 + "" + ull4;
				sll3 = mll3 + "" + ull3;
				sll2 = mll2 + "" + ull2;
				sll1 = mll2 + "" + ull1;
				opdPatientDetails.setUR1(sur1);
				opdPatientDetails.setUR2(sur2);
				opdPatientDetails.setUR3(sur3);
				opdPatientDetails.setUR4(sur4);
				opdPatientDetails.setUR5(sur5);
				opdPatientDetails.setUR6(sur6);
				opdPatientDetails.setUR7(sur7);
				opdPatientDetails.setUR8(sur8);

				opdPatientDetails.setUL1(sul1);
				opdPatientDetails.setUL2(sul2);
				opdPatientDetails.setUL3(sul3);
				opdPatientDetails.setUL4(sul4);
				opdPatientDetails.setUL5(sul5);
				opdPatientDetails.setUL6(sul6);
				opdPatientDetails.setUL7(sul7);
				opdPatientDetails.setUL8(sul8);

				opdPatientDetails.setLR1(slr1);
				opdPatientDetails.setLR2(slr2);
				opdPatientDetails.setLR3(slr3);
				opdPatientDetails.setLR4(slr4);
				opdPatientDetails.setLR5(slr5);
				opdPatientDetails.setLR6(slr6);
				opdPatientDetails.setLR7(slr7);
				opdPatientDetails.setLR8(slr8);

				opdPatientDetails.setLL1(sll1);
				opdPatientDetails.setLL2(sll2);
				opdPatientDetails.setLL3(sll3);
				opdPatientDetails.setLL4(sll4);
				opdPatientDetails.setLL5(sll5);
				opdPatientDetails.setLL6(sll6);
				opdPatientDetails.setLL7(sll7);
				opdPatientDetails.setLL8(sll8);
				hbt.save(opdPatientDetails);
		//-----------------------------------------------------------------------------
			
			opdPatientHistory.setVisitInpatientId(box.getInt("visitId"));
				
			masDepartment.setId(box.getInt("deptId"));
			opdPatientHistory.setDepartment(masDepartment);
			
			patientObj.setId(box.getInt("hinId"));
			opdPatientHistory.setHin(patientObj);
			opdPatientHistory.setOpdPatientDetails(opdPatientDetails);
			opdPatientHistory.setPresentComplain(box.getString("complaintDescriptions"));
			opdPatientHistory.setPresentAdvice(box.getString("presentAdvice"));
			hbt.save(opdPatientHistory);
			String query = "";
			List objectList = new ArrayList();
			if (diagnosisIdAray != null) {
				for (int i = 0; i < diagnosisIdAray.length; i++) {
					DischargeIcdCode dischargeIcdCode = new DischargeIcdCode();
					
					patientObj.setId(box.getInt("hinId"));
					dischargeIcdCode.setHin(patientObj);
					MasIcd masIcd = new MasIcd();
					if (diagnosisIdAray[i] != null) {
						if (!diagnosisIdAray[i].equals("0")) {
							query = "select icd_id from mas_icd where icd_code='"
									+ diagnosisIdAray[i] + "'";
							objectList = (List) session.createSQLQuery(query)
									.list();
							masIcd.setId(Integer.parseInt(""
									+ objectList.get(0)));
							dischargeIcdCode.setIcd(masIcd);
							dischargeIcdCode
									.setAddEditDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
							dischargeIcdCode.setAddEditTime(time);
							dischargeIcdCode.setStatus("y");
							dischargeIcdCode.setDiagnosisStatus("p");
							visit.setId(box.getInt("visitId"));
							dischargeIcdCode.setVisit(visit);
							dischargeIcdCode.setOpdPatientDetails(opdPatientDetails);
							hbt.save(dischargeIcdCode);
						}
					}
				}
			}
			//------------------------code procedure----------------------------
			ProcedureHeader procedureHeader = new ProcedureHeader();
		  if(box.getInt("procCount") != 0){
			patientObj.setId(box.getInt("hinId"));
			procedureHeader.setHin(patientObj);
		
			masHospital.setId(box.getInt("hospitalId"));
			procedureHeader.setHospital(masHospital);
			procedureHeader.setStatus("D");
			Users user = new Users();
			user.setId(box.getInt("userId"));
			procedureHeader.setLastChgBy(user);
			
			MasEmployee medicalOfficer =new MasEmployee();
			medicalOfficer.setId(box.getInt("empId"));
			procedureHeader.setMedicalOfficer(medicalOfficer);
			if(box.getInt("visitId")!=0){
				visit.setId(box.getInt("visitId"));
				procedureHeader.setVisit(visit);
			}
			procedureHeader.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			procedureHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			procedureHeader.setLastChgTime(box.getString("time"));
			hbt.save(procedureHeader);
			for (int j = 1; j <= box.getInt("procCount"); j++) {
				if(box.getInt("procedureId"+j)>0){
					ProcedureDetails procedureDetails = new ProcedureDetails();
					MasNursingCare nursingCare = new MasNursingCare();
					nursingCare.setId(box.getInt("procedureId"+j));
					procedureDetails.setNursingCare(nursingCare);
					procedureDetails.setProcedureHeader(procedureHeader);
					procedureDetails.setRemarks(box.getString("remarks"+j));
					procedureDetails.setStatus("D");
					hbt.save(procedureDetails);
				}
			}
		}
			//--------------------------End of the procedure code--------------------------------------
		//------------------------code for Dental Procedure-----------------------------------------------
			DentalTreatmentHeader dentalTreatmentHeader = new DentalTreatmentHeader();
			System.out.println("dentalCount======"+box.getInt("dentalCount"));
		  if(box.getInt("dentalCount") != 0){
			patientObj.setId(box.getInt("hinId"));
			dentalTreatmentHeader.setHin(patientObj);
		
			masHospital.setId(box.getInt("hospitalId"));
			dentalTreatmentHeader.setHospital(masHospital);
			
			
			if(box.getInt("visitId")!=0){
				visit.setId(box.getInt("visitId"));
				dentalTreatmentHeader.setVisit(visit);
			}
			if(box.getInt("deptId")!=0){
				masDepartment.setId(box.getInt("deptId"));
				dentalTreatmentHeader.setDepartment(masDepartment);
			}
			dentalTreatmentHeader.setTreatmentDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			dentalTreatmentHeader.setTreatmentTime("time");
			dentalTreatmentHeader.setOpdPatientDetail(opdPatientDetails);
			dentalTreatmentHeader.setStatus("y");
			hbt.save(dentalTreatmentHeader);
			for (int j = 1; j <= box.getInt("dentalCount"); j++) {
				if(!box.getString("teeth"+j).equals("")){
					DentalTreatmentDetail dentalTreatmentDetail = new DentalTreatmentDetail();
					if(!box.getString("teeth"+j).equals("")){
						dentalTreatmentDetail.setTeeth(box.getString("teeth"+j));
					}
					if(!box.getString("dentalTreatment"+j).equals("")){
						dentalTreatmentDetail.setTreatment(box.getString("dentalTreatment"+j));
					}
					if(!box.getString("dtc"+j).equals("")){
						dentalTreatmentDetail.setDtc(box.getString("dtc"+j));
					}
					if(!box.getString("remarks"+j).equals("")){
						dentalTreatmentDetail.setRemark(box.getString("remarks"+j));
					}
					dentalTreatmentDetail.setDentalTreatmentHeader(dentalTreatmentHeader);
					hbt.save(dentalTreatmentDetail);
				}
			}
		}
			//--------------------------End of the dental procedure code--------------------------------------
			//------------code for investigation------------------------------------
			String[] chargeCodeIdArr = new String[box.getInt("hiddenValue")];
			if (chargeCodeIdList.size() > 0) {
				Patient patient = new Patient();
				MasEmployee masEmployee2 = new MasEmployee();
				PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();
				patient.setId(box.getInt("hinId"));
				patientInvestigationHeader.setHin(patient);
			//	masDepartment.setId(box.getInt("departmentId"));
				masDepartment.setId(box.getInt("deptId"));
				patientInvestigationHeader.setDepartment(masDepartment);
				visit.setId(box.getInt("visitId"));
				patientInvestigationHeader.setVisit(visit);
				masHospital.setId(box.getInt("hospitalId"));
				patientInvestigationHeader.setHospital(masHospital);
				patientInvestigationHeader.setStatus("p");
				patientInvestigationHeader
						.setInvestigationDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				patientInvestigationHeader.setInvestigationTime(time);
				patientInvestigationHeader.setClinicalNotes(box.getString("clinicalNotes1"));
				patientInvestigationHeader.setOpdPatientDetails(opdPatientDetails);
				hbt.save(patientInvestigationHeader);

				DgOrderhd dgOrderhd = new DgOrderhd();
				dgOrderhd.setOrderDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				dgOrderhd.setOrderTime(time);
				masHospital.setId(box.getInt("hospitalId"));
				dgOrderhd.setHospital(masHospital);
				patient.setId(box.getInt("hinId"));
				dgOrderhd.setHin(patient);
				masDepartment.setId(box.getInt("deptId"));
				dgOrderhd.setDepartment(masDepartment);
				if (box.getInt("empId") != 0) {
					masEmployee2.setId(box.getInt("empId"));
					dgOrderhd.setPrescribedBy(masEmployee2);
				}
				dgOrderhd.setPatientType("OP");
				dgOrderhd.setTestType("Regular");
				dgOrderhd.setCreatedby(box.getString("userName"));
				dgOrderhd.setCreatedon(HMSUtil.convertStringTypeDateToDateType(currentDate));
				dgOrderhd.setOrderNo(box.getString("orderSeqNo"));
				if (box.getInt("visitId") != 0) {
					visit = new Visit();
					visit.setId(box.getInt("visitId"));
					dgOrderhd.setVisit(visit);
				}
				dgOrderhd.setClinicalNote(box.getString("clinicalNotes1"));
				dgOrderhd.setOrderStatus("P");
				dgOrderhd.setLabOrderStatus("P");
				dgOrderhd.setLastChgBy(box.getInt("userId"));
				dgOrderhd.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				dgOrderhd.setLastChgTime(time);
				dgOrderhd.setInvestigationRequestionNo(patientInvestigationHeader);
				hbt.save(dgOrderhd);
				for (int i = 0; i < chargeCodeIdList.size(); i++) {
					PatientInvestigationDetails patientInvestigationDetails = new PatientInvestigationDetails();
					patientInvestigationDetails
					.setInvestigationHeader(patientInvestigationHeader);
					MasChargeCode masChargeCode = new MasChargeCode();
					masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
					patientInvestigationDetails.setChargeCode(masChargeCode);
					patientInvestigationDetails.setReferToMh(referToMhList.get(i));
					hbt.save(patientInvestigationDetails);

					DgOrderdt dgOrderdt = new DgOrderdt();
					dgOrderdt.setOrderhd(dgOrderhd);
					masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
					dgOrderdt.setChargeCode(masChargeCode);
					dgOrderdt.setCreatedby(box.getString("userName"));
					dgOrderdt.setCreatedon(HMSUtil.convertStringTypeDateToDateType(currentDate));
					dgOrderdt.setLastChgBy(box.getInt("userId"));
					dgOrderdt.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
					dgOrderdt.setLastChgTime(time);
					// method written for taking out the values of mascharge
					// code and subcharge
					Map masChargeMap = getMasChargeCodeFromChargeId(Integer
							.parseInt(chargeCodeIdList.get(i)));
					MasChargeCode masChargeCodeObj = (MasChargeCode) masChargeMap
					.get("masChargeCode");
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
					dgOrderdt.setInvestigationToMH("n");
					dgOrderdt.setReferToMh(referToMhList.get(i));
					hbt.saveOrUpdate(dgOrderdt);
			}
		}
			//---------------------end of the code for investigation-----------------
	//-----------------------code for Treatment -------------------------------//
			PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();
			int item_category_id=0;
			if(pvmsNoList.size() > 0 || (otherMedicineList != null && otherMedicineList.size() > 0)){
				patientObj.setId(box.getInt("hinId"));
				patientPrescriptionHeader.setHin(patientObj);
				masDepartment.setId(box.getInt("deptId"));
				patientPrescriptionHeader.setDepartment(masDepartment);
				visit.setId(box.getInt("visitId"));
				patientPrescriptionHeader.setVisit(visit);
				masHospital.setId(box.getInt("hospitalId"));
				patientPrescriptionHeader.setHospital(masHospital);
				patientPrescriptionHeader.setStatus("p");
				patientPrescriptionHeader
						.setPrescriptionDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				patientPrescriptionHeader.setPrescriptionTime(time);
				/**
				 * Code By Ritu 
				 * Created Foreign key relation for emp id in Database
				 */
				MasEmployee employee = new MasEmployee();
				employee.setId(box.getInt("empId"));
				patientPrescriptionHeader.setEmp(employee);
				
				/**
				 * End of code by Ritu
				 */
				int prescriptionNo=getTransactionSequenceNoForPrescriptionNo(mapForDS);
				patientPrescriptionHeader.setPrescriptionNo(prescriptionNo);
				patientPrescriptionHeader.setOpdPatientDetails(opdPatientDetails);
				
				
				 /* This block is use for Check Injection in Prescription List*/
				 
				String sqlItemId="";
				
				for (int i = 0; i < pvmsNoList.size(); i++) {
					String pvmsNo = (String) pvmsNoList.get(i);
					int itemId = getItemIdFromPVMS(pvmsNo);
					if(i==0){
						sqlItemId=""+itemId;
					}else{
						sqlItemId +=" , "+itemId;
					}
					itemIdList.add(itemId);
				}
				List<MasStoreItem> masItemList=new ArrayList<MasStoreItem>();
				Properties properties = new Properties();
				URL resourcePath = Thread.currentThread().getContextClassLoader()
						.getResource("adt.properties");
				
				try {
					properties.load(resourcePath.openStream());

					String item_category_code = properties.getProperty("item_category_id");
					item_category_id=Integer.parseInt(item_category_code);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(!sqlItemId.equals(""))
					masItemList=hbt.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemCategory as ic where item.Id in ("+sqlItemId+") and ic.Id="+item_category_id);
				
				if(masItemList.size()>0){
					patientPrescriptionHeader.setInjectionStatus("p");
				}else{
					patientPrescriptionHeader.setInjectionStatus("n");
				}
				
				/* End Of Code This block is use for Check Injection in Prescription List*/
				 
				
				hbt.save(patientPrescriptionHeader);
			}
			if (pvmsNoList.size() > 0 ) {
				for (int i = 0; i < itemIdList.size(); i++) {
					
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
						if (totalList.get(i) != null && !totalList.get(i).equals("")) {
							patientPrescriptionDetails.setTotal(totalList.get(i));
						}
						patientPrescriptionDetails.setGivenQty(0);
									
					patientPrescriptionDetails.setPrescription(patientPrescriptionHeader);
				
					patientPrescriptionDetails.setDetailStatus("a");
					List<MasStoreItem> storeItemList=new ArrayList<MasStoreItem>();
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
					
					hbt.save(patientPrescriptionDetails);
					
					/**
					 * This Code is use for Injection Appointment
					 * Code By Ritu Sahu
					 * Date 07 Nov 2011
					 */
					
					if(storeItemList.size()>0){
						List<InjAppointmentHeader> injectionRegisterList=new ArrayList<InjAppointmentHeader>();
						injectionRegisterList=hbt.find("select inj from jkt.hms.masters.business.InjAppointmentHeader as inj join inj.Visit as visit where visit.Id="+box.getInt("visitId"));
						InjAppointmentHeader injectionAppointment = new InjAppointmentHeader();
						
						  if(injectionRegisterList.size()>0) /*means , Data is already available In InjectionRegister table */ 
						 
						if(injectionRegisterList.size()>0){
							for (InjAppointmentHeader injectionRegisterTemp : injectionRegisterList) {
								injectionAppointment.setId(injectionRegisterTemp.getId());
							}
						}else{
							injectionAppointment.setAppointmentDate(new Date());
							Patient patientInj = new Patient();
							patientInj.setId(box.getInt("hinId"));
							injectionAppointment.setHin(patientInj);
							Visit visitInj = new Visit();
							visitInj.setId(box.getInt("visitId"));
							injectionAppointment.setVisit(visitInj);
							MasHospital masHospitalInj = new MasHospital();
							masHospitalInj.setId(box.getInt("hospitalId"));
							injectionAppointment.setHospital(masHospitalInj);
							
							injectionAppointment.setStatus("p");
							injectionAppointment.setLastChgTime(time);
							Users user = new Users();
							user.setId(box.getInt(""));
							injectionAppointment.setLastChgBy(user);
							//injectionAppointment.setLastChgDate(date);
							injectionAppointment.setPrescription(patientPrescriptionHeader);
							hbt.save(injectionAppointment);
						}
						int freqCount=0;
						if(frequencyList.get(i) > 10){
							freqCount = 1;  /*if frequency is greater than 10 then only one entry will go in Injection Appointment table */
						}else{
							freqCount = frequencyList.get(i);
						}
						if(freqCount > 0){	
							for (int j = 1; j <= freqCount; j++) {
								InjAppointmentDetails injAppointmentDetails = new InjAppointmentDetails();
								injAppointmentDetails.setAppointmentTime(time);
								injAppointmentDetails.setDose(dosageList.get(i));
								MasFrequency frequency = new MasFrequency();
								frequency.setId(frequencyList.get(i));
								injAppointmentDetails.setFrequency(frequency);
								injAppointmentDetails.setRoute(routeList.get(i));
								MasStoreItem item = new MasStoreItem();
								item.setId(itemIdList.get(i));
								injAppointmentDetails.setItem(item);
								injAppointmentDetails.setInjAppointmentHeader(injectionAppointment);
								injAppointmentDetails.setNoOfDays(noOfDaysList.get(i));
								injAppointmentDetails.setPatientPrescriptionDetails(patientPrescriptionDetails);
								injAppointmentDetails.setStatus("p");
								hbt.save(injAppointmentDetails);
							}
						}
					}
					/**
					 * END Of COde
					 * This Code is use for Injection
					 * Code By Ritu Sahu
					 * Date 07 Nov 2011
					 */
				}
			}
			if(otherMedicineList != null && otherMedicineList.size() > 0){
				String sqlItemId="";
				int itemId = 0;
				List<MasStoreItem> itemCodeList = new ArrayList<MasStoreItem>();
				String otherItem = "";
				if(otherMedicineList.size() >0){
				for(int i = 0; i < otherMedicineList.size(); i++){
					MasStoreItem masItem = new MasStoreItem();
					if(otherMedicineList.get(i) != null){
						otherItem =(String)otherMedicineList.get(i);
						masItem.setNomenclature(otherMedicineList.get(i));
						MasStoreSection masStoreSection = new MasStoreSection();
						masStoreSection.setId(1);
						masItem.setSection(masStoreSection);
						masItem.setStatus("y");
						masItem.setBrandedGeneric("B");
						MasStoreItemConversion masStoreItemConversion = new MasStoreItemConversion();
						masStoreItemConversion.setId(1);
						masItem.setItemConversion(masStoreItemConversion);
						itemCodeList =session.createCriteria(MasStoreItem.class).add(Restrictions.like("PvmsNo", "NIV%"))
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
						}
						masItem.setPvmsNo(itemNo);
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
					/*if(injCategoryList.equals("y")){
						patientPrescriptionDetails.setInjectionStatus("p");
					}else{
						patientPrescriptionDetails.setInjectionStatus("n");
					}*/
					
					if(ctList.get(i).equals("y")){
						patientPrescriptionDetails.setCt("yes");
					}else{
						patientPrescriptionDetails.setCt("no");
					}
					
					
					hbt.save(patientPrescriptionDetails);
					
					/**
					 * This Code is use for Injection Appointment
					 * Code By Ritu Sahu
					 * Date 07 Nov 2011
					 */
					
					if(storeItemList.size()>0){
						List<InjAppointmentHeader> injectionRegisterList=new ArrayList<InjAppointmentHeader>();
						injectionRegisterList=hbt.find("select inj from jkt.hms.masters.business.InjAppointmentHeader as inj join inj.Visit as visit where visit.Id="+box.getInt("visitId"));
						InjAppointmentHeader injectionAppointment = new InjAppointmentHeader();
						
						 /* if(injectionRegisterList.size()>0) means , Data is already available In InjectionRegister table  */
						 
						if(injectionRegisterList.size()>0){
							for (InjAppointmentHeader injectionRegisterTemp : injectionRegisterList) {
								injectionAppointment.setId(injectionRegisterTemp.getId());
							}
						}else{
							injectionAppointment.setAppointmentDate(new Date());
							Patient patientInj = new Patient();
							patientInj.setId(box.getInt("hinId"));
							injectionAppointment.setHin(patientInj);
							Visit visitInj = new Visit();
							visitInj.setId(box.getInt("visitId"));
							injectionAppointment.setVisit(visitInj);
							MasHospital masHospitalInj = new MasHospital();
							masHospitalInj.setId(box.getInt("hospitalId"));
							injectionAppointment.setHospital(masHospitalInj);
							injectionAppointment.setStatus("p");
							injectionAppointment.setLastChgTime(time);
							Users user = new Users();
							user.setId(box.getInt("userId"));
							injectionAppointment.setLastChgBy(user);
							injectionAppointment.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
							injectionAppointment.setPrescription(patientPrescriptionHeader);
							hbt.save(injectionAppointment);
						}
						int freqCount=0;
						if(frequencyList.get(i) > 10){
							freqCount = 1; /* if frequency is greater than 10 then only one entry will go in Injection Appointment table*/
						}else{
							freqCount = frequencyList.get(i);
						}
						if(freqCount > 0){	
							for (int j = 1; j <= freqCount; j++) {
								InjAppointmentDetails injAppointmentDetails = new InjAppointmentDetails();
								injAppointmentDetails.setAppointmentTime(time);
								injAppointmentDetails.setDose(dosageList.get(i));
								MasFrequency frequency = new MasFrequency();
								frequency.setId(frequencyList.get(i));
								injAppointmentDetails.setFrequency(frequency);
								injAppointmentDetails.setRoute(routeList.get(i));
								MasStoreItem item = new MasStoreItem();
								item.setId(itemIdList.get(i));
								injAppointmentDetails.setItem(item);
								injAppointmentDetails.setInjAppointmentHeader(injectionAppointment);
								injAppointmentDetails.setNoOfDays(noOfDaysList.get(i));
								injAppointmentDetails.setPatientPrescriptionDetails(patientPrescriptionDetails);
								injAppointmentDetails.setStatus("p");
								hbt.save(injAppointmentDetails);
							}
						}
					}
					}
					/**
					 * END Of COde
					 * This Code is use for Injection
					 * Code By Ritu Sahu
					 * Date 07 Nov 2011
					 */
				}
			 }
			}
	//----------------update visit table---------------------------------------------------
			Visit visitObjToUpdate = (Visit) hbt.load(Visit.class, box.getInt("visitId"));
			visitObjToUpdate.setVisitStatus("C");
			if(box.getInt("empId")>0){
				MasEmployee doctor=new MasEmployee();
				doctor.setId(box.getInt("empId"));
				visitObjToUpdate.setDoctor(doctor);
			}
			hbt.update(visitObjToUpdate);
			//----------------------------------
			
		}
			succesfullyAdded = true;
			tx.commit();	
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		map.put("succesfullyAdded", succesfullyAdded);
		return map;
	}
	
	public Map<String, Object> getMasChargeCodeFromChargeId(int chargeId) {
		Session session = (Session) getSession();
		List<MasChargeCode> masChargeList = new ArrayList<MasChargeCode>();
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			Criteria crit = session.createCriteria(MasChargeCode.class).add(
					Restrictions.eq("Id", chargeId));
			masChargeList = crit.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		MasChargeCode masChargeCode = masChargeList.get(0);

		map.put("masChargeCode", masChargeCode);

		return map;
	}
	public int getTransactionSequenceNoForPrescriptionNo(Map mapForDS) {
		Session session = (Session) getSession();

		int userId = (Integer) mapForDS.get("userId");
		String userName = (String) mapForDS.get("userName");
		int hospitalId = (Integer)mapForDS.get("hospitalId");
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
		 TransactionSequence transactionSequence = orderNoList.get(0);
		 orderNo = transactionSequence.getTransactionSequenceNumber();
		 oldYear=transactionSequence.getMonth(); 
		 if(currentYearInt>oldYear)
		 {
			    orderNo=0;
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
	public int getItemIdFromPVMS(String pvmsNo) {
		List<MasStoreItem> itemIdList = new ArrayList<MasStoreItem>();
		Session session = (Session) getSession();
		int itemId = 0;
		try {
			itemIdList = session.createCriteria(MasStoreItem.class).add(
					Restrictions.eq("PvmsNo", pvmsNo)).list();
			MasStoreItem masStoreItem = itemIdList.get(0);
			itemId = masStoreItem.getId();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return itemId;
	}

	@Override
	public Map<String, Object> getDentalProcedureForAutoComplete(
			Map<String, Object> map) {
		Map<String, Object>dataMap = new HashMap<String, Object>();
		List<MasNursingCare> procedureList  = new ArrayList<MasNursingCare>();
		Session session = (Session)getSession();
		String str = (String)map.get("autoHint") ;
		procedureList = session.createCriteria(MasNursingCare.class).add(Restrictions.sqlRestriction("upper(nursing_name) like upper('"+str+"%')"))
						.add(Restrictions.eq("Status", "y")).add(Restrictions.eq("NursingType", "d")).list();
		dataMap.put("procedureList", procedureList);
		return dataMap;
	}

	@Override
	public Map<String, Object> getPreviousPatientVisitForDental(Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		List<Visit> patientPreviousVisitList = new ArrayList<Visit>();
		List<Object> patientInvestigationList = new ArrayList<Object>();
		List<Integer> maxVisitIdList = new ArrayList<Integer>();
		List<Integer> minVisitIdList = new ArrayList<Integer>();
		Map<String, Object> map = new HashMap<String, Object>();
		int hinId = (Integer) mapForDS.get("hinId");
		int visitNo = 0;
		if(mapForDS.get("visitNo")!=null)
			visitNo = (Integer) mapForDS.get("visitNo");
		try {
			Criteria crit = session.createCriteria(Visit.class).createAlias(
					"Hin", "hin").add(Restrictions.eq("hin.Id", hinId)).add(
					Restrictions.eq("VisitStatus", "C")).add(Restrictions.eq("ReportingFor", "Dental")).addOrder(
					Order.desc("VisitNo"));
			patientPreviousVisitList = crit.list();

			Criteria critMaxVisitId = session.createCriteria(Visit.class)
					.createAlias("Hin", "hin").add(
							Restrictions.eq("hin.Id", hinId)).add(Restrictions.eq("ReportingFor", "Dental")).add(
							Restrictions.lt("VisitNo", visitNo)).add(
							Restrictions.eq("VisitStatus", "C")).setProjection(
							Projections.max("Id")).addOrder(
							Order.desc("VisitNo"));
			maxVisitIdList = critMaxVisitId.list();
			String dental = "Dental";
			Criteria critMinVisitId = session.createCriteria(Visit.class)
					.createAlias("Hin", "hin").add(
							Restrictions.eq("hin.Id", hinId)).add(Restrictions.eq("ReportingFor", "Dental")).add(
							Restrictions.lt("VisitNo", visitNo)).add(
							Restrictions.eq("VisitStatus", "C")).setProjection(
							Projections.min("Id")).addOrder(
							Order.desc("VisitNo"));
			minVisitIdList = critMinVisitId.list();
			patientInvestigationList=getHibernateTemplate().find("select pih,visit,hin from jkt.hms.masters.business.PatientInvestigationHeader as pih join pih.Hin as hin join pih.Visit as visit where hin.Id="+hinId+" and visit.ReportingFor='"+dental+"'");
	

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("patientPreviousVisitList", patientPreviousVisitList);
		map.put("maxVisitIdList", maxVisitIdList);
		map.put("minVisitIdList", minVisitIdList);
		map.put("patientInvestigationList", patientInvestigationList);
		
		return map;
	}
	public Map<String, Object> getPatientOpdDentalDetails(Map<String, Object> dataMap) {
		
		int visitNo=0;
		int hinId = 0;
		String Nodatafound="yes";
		int current_visitNo=0;
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> visitNoList = new ArrayList<Visit>();
		List<Visit> visitNoList1 = new ArrayList<Visit>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<DischargeIcdCode> dischargeIcdCodeList = new ArrayList<DischargeIcdCode>();
		List<OpdPatientDetails> opdPatientDetailsList = new ArrayList<OpdPatientDetails>();
		List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
		PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();
		PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();
		List<PatientInvestigationHeader> patientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>();
		List<DgSampleCollectionDetails> dgSampleCollectionDetailsList = new ArrayList<DgSampleCollectionDetails>();

		List<PatientPrescriptionHeader> patientPrescriptionHeaderList = new ArrayList<PatientPrescriptionHeader>();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		DgOrderhd dgOrderhd = new DgOrderhd();
		List<OpdPatientHistory> opdPatientHistoryList = new ArrayList<OpdPatientHistory>();
		Session session = (Session) getSession();
		List<MasEmployee> doctarsList = new ArrayList<MasEmployee>();
		List<MasDisposal> disposalTypeList =new ArrayList<MasDisposal>();
		try {
			if (dataMap.get("visitNo") != null) {
				visitNo = (Integer) dataMap.get("visitNo");
			}
			if (dataMap.get("current_visitNo") != null) {
				current_visitNo = (Integer) dataMap.get("current_visitNo");
			}
			
			
			if (dataMap.get("hinId") != null) {
				hinId = (Integer) dataMap.get("hinId");
			}
			disposalTypeList = session.createCriteria(MasDisposal.class).add(Restrictions.eq("Status", "y")).list();
			visitNoList = (List<Visit>) session.createCriteria(Visit.class).add(Restrictions.eq("ReportingFor", "Dental"))
					.add(Restrictions.eq("VisitNo", visitNo))
					.createAlias("Hin", "h")
					.add(Restrictions.eq("h.Id", hinId)).list();


			Visit visit = new Visit();
			if (visitNoList != null && visitNoList.size() > 0) {
				visit = visitNoList.get(0);
			
			map.put("visit", visit);
			System.out.println("visitId===="+visit.getId());
			opdPatientDetailsList = (List<OpdPatientDetails>) session
					.createCriteria(OpdPatientDetails.class).createAlias(
							"Visit", "visit").add(
							Restrictions.eq("visit.Id", visit.getId())).list();

		//	System.out.println("opdPatientDetailsList opdPatientDetailsList.get(0).getReferredDept()"+ opdPatientDetailsList.get(0).getReferredDept());
			map.put("opdPatientDetailsList", opdPatientDetailsList);
			System.out.println("opdPatientDetailsList===="+opdPatientDetailsList.size());
			String referedDoctarsArray[];
			if (opdPatientDetailsList != null && opdPatientDetailsList.size() > 0) {
		
               if(opdPatientDetailsList.get(0).getReferredDept()!=null)
               {
				if (opdPatientDetailsList.get(0).getReferredDept()
						.contains(",")) {
					referedDoctarsArray = opdPatientDetailsList.get(0)
							.getReferredDept().split(",");

				} else {
					referedDoctarsArray = new String[1];
					referedDoctarsArray[0] = opdPatientDetailsList.get(0)
							.getReferredDept();
				}

				for (String reffredDoctars : referedDoctarsArray) {
					if (!reffredDoctars.equals("") && !reffredDoctars.equals("0")) {
						//System.out.println("reffredDoctars--12987 opd ds->"+reffredDoctars);
						MasDepartment masDepartment = (MasDepartment) session
								.load(MasDepartment.class, Integer
										.parseInt(reffredDoctars));

						doctarsList.addAll(masDepartment.getMasEmployees());
					}

				}
               }
				map.put("doctarsList", doctarsList);
			}

			opdPatientHistoryList = (List<OpdPatientHistory>) session
					.createCriteria(OpdPatientHistory.class)
					.add(Restrictions.eq("VisitInpatientId", visit.getId()))
					.add(Restrictions.eq("Hin.Id",hinId))
					.list();
			if (opdPatientHistoryList != null
					&& opdPatientHistoryList.size() > 0)
				map.put("opdPatientHistoryList", opdPatientHistoryList);

			dischargeIcdCodeList = (List<DischargeIcdCode>) session
					.createCriteria(DischargeIcdCode.class).createAlias(
							"Visit", "v").add(
							Restrictions.eq("v.Id", visit.getId()))
					.createAlias("Hin", "p").add(
							Restrictions.eq("p.Id", visit.getHin().getId()))
					.list();
			//System.out.println("dischargeIcdCodeList"	+ dischargeIcdCodeList.size());
			if (dischargeIcdCodeList != null && dischargeIcdCodeList.size() > 0)
				map.put("dischargeIcdCodeList", dischargeIcdCodeList);

			patientPrescriptionHeaderList = (List<PatientPrescriptionHeader>) session
					.createCriteria(PatientPrescriptionHeader.class)
					.createAlias("Visit", "v").add(
							Restrictions.eq("v.Id", visit.getId())).add(Restrictions.eq("v.ReportingFor", "Dental"))
					.createAlias("Hin", "p").add(
							Restrictions.eq("p.Id", visit.getHin().getId()))
					.list();
			if (patientPrescriptionHeaderList != null
					&& patientPrescriptionHeaderList.size() > 0) {
				patientPrescriptionHeader = patientPrescriptionHeaderList
						.get(0);
				map.put("patientPrescriptionHeader", patientPrescriptionHeader);
				System.out.println("patientPrescriptionHeaderList"+ patientPrescriptionHeaderList.size());
			}

			patientInvestigationHeaderList = (List<PatientInvestigationHeader>) session
					.createCriteria(PatientInvestigationHeader.class)
					.createAlias("Visit", "v").add(
							Restrictions.eq("v.Id", visit.getId())).add(Restrictions.eq("v.ReportingFor", "Dental"))
					.createAlias("Hin", "p").add(
							Restrictions.eq("p.Id", visit.getHin().getId()))
					.list();
			dgSampleCollectionDetailsList = (List<DgSampleCollectionDetails>) session
					.createCriteria(DgSampleCollectionDetails.class)
					.createAlias("SampleCollectionHeader", "sampleCollHeader")
					.createAlias("sampleCollHeader.Visit", "v").add(
							Restrictions.eq("v.Id", visit.getId())).add(Restrictions.eq("v.ReportingFor", "Dental"))
					.createAlias("sampleCollHeader.Hin", "p").add(
							Restrictions.eq("OrderStatus", "P")).add(
							Restrictions.eq("p.Id", visit.getHin().getId()))
					.list();
			if (dgSampleCollectionDetailsList.size() > 0) {
				map.put("dgSampleCollectionDetailsList",
						dgSampleCollectionDetailsList);
			}
			if (patientInvestigationHeaderList != null
					&& patientInvestigationHeaderList.size() > 0) {
				patientInvestigationHeader = patientInvestigationHeaderList
						.get(0);
				map.put("patientInvestigationHeader",
						patientInvestigationHeader);
			}

			dgOrderhdList = (List<DgOrderhd>) session.createCriteria(
					DgOrderhd.class).createAlias("Visit", "v").add(
					Restrictions.eq("v.Id", visit.getId())).add(Restrictions.eq("v.ReportingFor", "Dental")).createAlias("Hin",
					"p").add(Restrictions.eq("p.Id", visit.getHin().getId()))
					.list();
			
			if (dgOrderhdList != null && dgOrderhdList.size() > 0) {
				dgOrderhd = dgOrderhdList.get(0);
				map.put("dgOrderhd", dgOrderhd);
			}
			List<String> departmentTypeCode = new ArrayList<String>();
			
			deptList = session.createCriteria(MasDepartment.class).list();

			map.put("deptList", deptList);
			int deptId = 0;
			if (dataMap.get("deptId") != null) {
				deptId = (Integer) dataMap.get("deptId");
			}
			templateList = session.createCriteria(OpdTemplate.class)
					.createAlias("Department", "dept").add(
							Restrictions.eq("dept.Id", deptId)).list();
			map.put("templateList", templateList);
			frequencyList = session.createCriteria(MasFrequency.class).list();
			map.put("frequencyList", frequencyList);
			}else 
			{
				visitNoList1 = (List<Visit>) session.createCriteria(Visit.class).add(Restrictions.eq("v.ReportingFor", "Dental"))
				.add(Restrictions.eq("VisitNo", current_visitNo))
				.createAlias("Hin", "h")
				.add(Restrictions.eq("h.Id", hinId)).list();


		        Visit visit1 = new Visit();
		if (visitNoList1 != null && visitNoList1.size() > 0) {
			visit1 = visitNoList1.get(0);
		
		     map.put("visit", visit1);
	      	}
		        Nodatafound="no";
				
			}
			map.put("Nodatafound", Nodatafound);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("disposalTypeList", disposalTypeList);
		return map;
	
	}
	public Map<String, Object> getOPDDetailsForOpdDentalUpdate(Map mapForDS) {
		Session session = (Session) getSession();
		List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		//List<Visit> listOfPreviousVisit3 = new ArrayList<Visit>();
		//List<Visit> listOfPreviousVisit2 = new ArrayList<Visit>();
		//List<Visit> listOfPreviousVisit1 = new ArrayList<Visit>();

		//List<Visit> listOfOpd3 = new ArrayList<Visit>();
		//List<Visit> listOfOpd2 = new ArrayList<Visit>();
		//List<Visit> listOfOpd1 = new ArrayList<Visit>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		int deptId = (Integer) mapForDS.get("deptId");
		int visitId1 = (Integer) mapForDS.get("visitNo");
		int visitNo = 1;
		int hinId = (Integer) mapForDS.get("hinId");
		try {
			List<String> departmentTypeCode = new ArrayList<String>();
			

			deptList = session.createCriteria(MasDepartment.class).createAlias(
					"DepartmentType", "deptType").list();
			templateList = session.createCriteria(OpdTemplate.class)
					.createAlias("Department", "dept").add(
							Restrictions.eq("dept.Id", deptId)).list();
			frequencyList = session.createCriteria(MasFrequency.class).list();
			/*List<Visit> visitList = new ArrayList<Visit>();
			visitList = session.createCriteria(Visit.class).createAlias("Hin",
					"hin").add(Restrictions.eq("hin.Id", hinId)).add(
					Restrictions.eq("VisitNo", visitId1)).list();
            if(visitList!=null && visitList.size()>0)
            {
			visitNo = visitList.get(0).getVisitNo();
			int j = 1;
			for (int i = visitNo; i > 0; i--) {

				if (j == 1) {
					listOfPreviousVisit3 = session.createCriteria(Visit.class)
							.createAlias("Hin", "hin").add(
									Restrictions.eq("hin.Id", hinId)).add(
									Restrictions.eq("VisitNo", visitNo)).list();
					//System.out.println("listOfPreviousVisit3 "+ listOfPreviousVisit3.size());
					Visit visit = new Visit();
					int visitId = 0;
					if (listOfPreviousVisit3 != null
							&& listOfPreviousVisit3.size() > 0) {
						visit = (Visit) listOfPreviousVisit3.get(0);
						visitId = visit.getId();
					}

					listOfOpd3 = session
							.createCriteria(OpdPatientDetails.class)
							.createAlias("Visit", "visit").add(
									Restrictions.eq("visit.Id", visitId))
							.list();
					//System.out.println("listOfOpd3 " + listOfOpd3.size());
					visitNo = visitNo - 1;
					if (listOfOpd3.size() > 0) {
						map.put("listOfOpd3", listOfOpd3);
					}
				}
				if (j == 2) {
					listOfPreviousVisit2 = session.createCriteria(Visit.class)
							.createAlias("Hin", "hin").add(
									Restrictions.eq("hin.Id", hinId)).add(
									Restrictions.eq("VisitNo", visitNo)).list();
					Visit visit = new Visit();
					int visitId = 0;
					if (listOfPreviousVisit2 != null
							&& listOfPreviousVisit2.size() > 0) {
						visit = (Visit) listOfPreviousVisit2.get(0);
						visitId = visit.getId();
					}
					listOfOpd2 = session
							.createCriteria(OpdPatientDetails.class)
							.createAlias("Visit", "visit").add(
									Restrictions.eq("visit.Id", visitId))
							.list();
					visitNo = visitNo - 1;
					if (listOfOpd2.size() > 0) {
						map.put("listOfOpd2", listOfOpd2);
					}
				}
				if (j == 3) {
					listOfPreviousVisit1 = session.createCriteria(Visit.class)
							.createAlias("Hin", "hin").add(
									Restrictions.eq("hin.Id", hinId)).add(
									Restrictions.eq("VisitNo", visitNo)).list();
					Visit visit = new Visit();
					int visitId = 0;
					if (listOfPreviousVisit1 != null
							&& listOfPreviousVisit1.size() > 0) {
						visit = (Visit) listOfPreviousVisit1.get(0);
						visitId = visit.getId();
					}
					listOfOpd1 = session
							.createCriteria(OpdPatientDetails.class)
							.createAlias("Visit", "visit").add(
									Restrictions.eq("visit.Id", visitId))
							.list();
					visitNo = visitNo - 1;
					if (listOfOpd1.size() > 0) {
						map.put("listOfOpd1", listOfOpd1);
					}
					break;
				}
				j++;
			}
            }*/
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("deptList", deptList);
		map.put("templateList", templateList);
		map.put("frequencyList", frequencyList);
		return map;

	}

	@Override
	public Map<String, Object> showDentalPopupTokenJsp(Map<String, Object> mapForDS) {
			Map<String, Object> map = new HashMap<String, Object>();
			Session session = null;
			session = (Session) getSession();
			
			try{
				List<Object[]> minTokenList = new ArrayList<Object[]>();
				List<Visit> visitTokenList = new ArrayList<Visit>();
				List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
				List<Object[]> tokenList = new ArrayList<Object[]>();
				
				int deptId = 0;
				if(mapForDS.get("deptId")!=null){
					deptId = (Integer) mapForDS.get("deptId");
				}
				int hospitalId = 0;
				if(mapForDS.get("hospitalId")!=null){
					hospitalId = (Integer) mapForDS.get("hospitalId");
				}
				int empId = 0;
				if(mapForDS.get("empId")!=null){
					empId = (Integer) mapForDS.get("empId");
				}
				Date currentDate = new Date();
				String reportingDept[] = {"Dental"};
				/*List<Integer> tokenDisplayList = new ArrayList<Integer>();
				tokenDisplayList = session.createCriteria(TokenDisplay.class).setProjection(Projections.property("VisitId")).list();*/
				minTokenList = session.createCriteria(Visit.class).add(Restrictions.eq("VisitStatus", "w"))
				//.add(Restrictions.eq("Doctor.Id", empId))
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("VisitDate", currentDate))
				.add(Restrictions.in("ReportingFor", reportingDept)).add(Restrictions.eq("TokenStatus", "n"))
				.setProjection(Projections.projectionList().add(Projections.min("TokenNo")).add(Projections.groupProperty("Doctor.Id"))).list();
				if(minTokenList!=null && minTokenList.size()>0 && minTokenList.get(0)!=null){
					Integer[] token = new Integer[minTokenList.size()];
					int i=0;
					for (Object[] v : minTokenList) {
						token[i] = (Integer)v[0];
						i++;
					}
					
					
					tokenList = session.createCriteria(Visit.class).add(Restrictions.eq("VisitStatus", "w"))
					.createAlias("Doctor", "d")
					.createAlias("d.Rank", "dRank")
					.createAlias("Hin", "h")
					.createAlias("h.Rank", "pRank")
					.createAlias("h.Relation", "pRelation")
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("VisitDate", currentDate))
					.add(Restrictions.in("ReportingFor", reportingDept)).add(Restrictions.in("TokenNo", token))
					.setProjection(Projections.projectionList().add(Projections.property("RoomNo"))
					.add(Projections.property("dRank.RankName"))
					.add(Projections.property("d.FirstName"))
					.add(Projections.property("d.MiddleName"))
					.add(Projections.property("d.LastName"))
					.add(Projections.property("pRank.RankName"))
					.add(Projections.property("h.PFirstName"))
					.add(Projections.property("h.PMiddleName"))
					.add(Projections.property("h.PLastName"))
					.add(Projections.property("pRelation.RelationName"))
					.add(Projections.property("TokenNo"))
					.add(Projections.groupProperty("RoomNo"))
					.add(Projections.groupProperty("TokenNo"))
					.add(Projections.groupProperty("Doctor.Id"))
					.add(Projections.groupProperty("dRank.RankName"))
					.add(Projections.groupProperty("d.FirstName"))
					.add(Projections.groupProperty("d.MiddleName"))
					.add(Projections.groupProperty("d.LastName"))
					.add(Projections.groupProperty("pRank.RankName"))
					.add(Projections.groupProperty("h.PFirstName"))
					.add(Projections.groupProperty("h.PMiddleName"))
					.add(Projections.groupProperty("h.PLastName"))
					.add(Projections.groupProperty("pRelation.RelationName"))
					).list();
					
				}
				map.put("tokenList", tokenList);
			}catch (Exception e) {
				e.printStackTrace();
			}
			return map;
		}

	@Override
	public Map<String, Object> getDetailsForReport(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasServiceType> serviceTypeList = null;
		List<MasRank> rankList = null;
		List<MasRankCategory> rankCategoryList = null;
		List<Object[]> unitList = null;
		List<MasMaritalStatus> maritalStatusList = null;
		List<MasTrade> tradeList = null;
		List<MasEmployee> employeeList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasSection> sectionList = null;
		List<MasDisposal> disposalList = null;
		List<MasRelation> relationList= null;
		
		Session session = (Session)getSession();
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
		
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("Id")).list();
		rankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y"))
						.createAlias("Station", "station",CriteriaSpecification.LEFT_JOIN).setProjection(Projections.projectionList()
						.add(Projections.property("Id")).add(Projections.property("UnitName"))).addOrder(Order.asc("UnitName")).list();
		maritalStatusList = session.createCriteria(MasMaritalStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("MaritalStatusName")).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("EmpCategory", "ec")
						.add(Restrictions.eq("ec.EmpCategoryCode", empCategoryCodeForDoctor))
					.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.asc("FirstName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		sectionList = session.createCriteria(MasSection.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("SectionName")).list();
		disposalList = session.createCriteria(MasDisposal.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DisposalName")).list();
		relationList = session.createCriteria(MasRelation.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RelationName")).list();
		
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankList", rankList);
		map.put("rankCategoryList", rankCategoryList);
		map.put("unitList", unitList);
		map.put("maritalStatusList", maritalStatusList);
		map.put("tradeList", tradeList);
		map.put("employeeList", employeeList);
		map.put("sexList", sexList);
		map.put("sectionList", sectionList);
		map.put("disposalList", disposalList);
		map.put("relationList", relationList);
		return map;
	}

	@Override
	public Map<String, Object> getDentalRegisterData(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<Object[]> dentalRegisterList = new ArrayList<Object[]>();
		String qryStr = "";
		if(box.getInt(SERVICE_TYPE_ID)!=0){
//			qryStr += " and patient.service_type_id = "+box.getInt(SERVICE_TYPE_ID)+"";
			qryStr += " and patient.service_type_id =:serviceType";
		}
		if(box.getInt(SERVICE_STATUS_ID)!=0){
//			qryStr += " and patient.service_status_id = "+box.getInt(SERVICE_STATUS_ID)+"";
			qryStr += " and patient.service_status_id =:serviceStatus";
		}
		if(box.getInt("fromRankId")!=0 && box.getInt("toRankId")!=0){
		//	qryStr += " and patient.rank_id between "+box.getInt("fromRankId")+" and "+box.getInt("toRankId");
			qryStr += " and patient.rank_id between :fromRank and :toRank";
		}
		if(box.getInt(RANK_CATEGORY_ID)!=0){
//			qryStr += " and mas_rank.rank_category_id = "+box.getInt(RANK_CATEGORY_ID)+"";
			qryStr += " and mas_rank.rank_category_id =:rankCat";
		}
		if(box.getInt(TRADE_ID)!=0){
//			qryStr += " and patient.trade_id = "+box.getInt(TRADE_ID)+"";
			qryStr += " and patient.trade_id =:trade";
		}
		if(box.getInt(UNIT_ID)!=0){
//			qryStr += " and patient.unit_id = "+box.getInt(UNIT_ID)+"";
			qryStr += " and patient.unit_id =:unit";
		}
		if(box.getInt(SECTION_ID)!=0){
//			qryStr += " and patient.section_id = "+box.getInt(SECTION_ID)+"";
			qryStr += " and patient.section_id =:section";
		}
		if(box.getInt(MARITAL_STATUS_ID)!=0){
//			qryStr += " and patient.marital_status_id = "+box.getInt(MARITAL_STATUS_ID)+"";
			qryStr += " and patient.marital_status_id = :mrStatus";
		}
		if(box.getInt(SEX_ID)!=0){
//			qryStr += " and patient.sex_id = "+box.getInt(SEX_ID)+"";
			qryStr += " and patient.sex_id = :sex";
		}
		if(box.getInt(RELATION_ID)!=0){
			qryStr += " and patient.relation_id = :relation";
		}
		if (!(box.getString(SERVICE_NO).equals(""))) {
//			qryStr += " and patient.service_no='"+box.getString(SERVICE_NO)+"'";
			qryStr += " and patient.service_no=:srNo";
		}
		if (!(box.getString("fromAge").equals("")) && !(box.getString("fromAgeUnit").equals(""))
				&& !(box.getString("toAge").equals("")) && !(box.getString("toAgeUnit").equals(""))) {
			String fromAge = box.getString("fromAge");
			String toAge = box.getString("toAge");
		//	qry += " and patient.age>='"+fromAge+"' and patient.age<='"+toAge+"'";
			qryStr +=" and substr(patient.age,0,INSTR(patient.age,' ')) >=:fromAge " +
					" and  substr(patient.age,INSTR(patient.age,' ')+1,length(patient.age))=:fromAgeUnit" +
					" and substr(patient.age,0,INSTR(patient.age,' ')) <=:toAge " +
					" and  substr(patient.age,INSTR(patient.age,' ')+1,length(patient.age))=:toAgeUnit";
			
		}
		if(box.getInt(CONSULTING_DOCTOR)!=0){
			qryStr += " and visit.doctor_id =:doctor";
		}
		if ( !(box.getString("icd").equals(""))) {
			String icd = box.getString("icd");
			 int index1=icd.lastIndexOf("[");
			  int index2=icd.lastIndexOf("]");
			   index1++;
			   String icdCode =""+icd.substring(index1, index2);
			qryStr += " and icd.icd_code='"+icdCode+"'";
		}
		if ( !(box.getString("procedure").equals(""))) {
			String procedure = box.getString("procedure");
			 int index1=procedure.lastIndexOf("[");
			  int index2=procedure.lastIndexOf("]");
			   index1++;
			   int procedureId =Integer.parseInt(procedure.substring(index1, index2));
			qryStr += " and mas_nursing_care.nursing_id="+procedureId+" ";
		}
		if (!(box.getString("icdNo").equals(""))) {
//			qryStr += " and icd.icd_code='"+box.getString("icdNo")+"'";
			qryStr += " and icd.icd_code= :icdCode ";
		}
		if(!(box.getString("disposal").equals(""))){
			qryStr += " and opd.disposal = '"+box.getString("disposal")+"'";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		String qry = "";
		qry = "SELECT distinct visit.visit_date as visit_date,patient.service_no AS patient_service_no," +
		" (patient.p_first_name || ' ' || nvl(patient.p_middle_name,'') || ' ' || nvl(patient.p_last_name,''))AS patientName," +
		"  mas_relation.relation_name AS mas_relation_relation_name," +
		" mas_rank.rank_name AS mas_rank_rank_name,"+
		" (patient.s_first_name || ' ' || nvl(patient.s_middle_name,'')  || ' ' || nvl(patient.s_last_name,''))AS servicePersonName," +
		"  mas_unit.unit_name as unit_name," +
		" opd.initial_diagnosis as diagnosis," +
		" (emp_mas_rank.rank_name || ' ' || mas_employee.first_name|| ' ' || mas_employee.middle_name || ' ' || mas_employee.last_name)AS doctorName," +
		" (case when (nvl(opd.disposal,0) !='0' ) then (opd.disposal) else ' ' end) as disposal," +
		"  (case when (nvl(opd.days,0)!=0) then (opd.days || ' days') else ' '  end) as days," +
		" hospital.hospital_name as hospital_name,visit.visit_id" +
		" FROM " +
		" patient patient right JOIN visit visit ON patient.hin_id = visit.hin_id" +
		" LEFT OUTER JOIN mas_rank mas_rank ON patient.rank_id = mas_rank.rank_id" +
		" LEFT OUTER JOIN mas_unit mas_unit ON patient.unit_id = mas_unit.unit_id " +
		" LEFT OUTER JOIN mas_relation mas_relation ON patient.relation_id = mas_relation.relation_id" +
		" left outer join mas_hospital hospital on patient.hospital_id=hospital.hospital_id" +
		" left outer join mas_employee mas_employee on visit.doctor_id=mas_employee.employee_id" +
		" LEFT OUTER JOIN mas_rank emp_mas_rank ON mas_employee.rank_id = emp_mas_rank.rank_id"+
		" left outer join opd_patient_details opd on visit.visit_id=opd.visit_id" +
		" left outer join discharge_icd_code dic on visit.visit_id=dic.visit_id" +
		" left outer join mas_icd icd on dic.icd_id=icd.icd_id" +
		" left outer join procedure_header procedure_header on  procedure_header.visit_id = visit.visit_id " +
		" left outer join procedure_details procedure_details on  procedure_details.procedure_header_id = procedure_header.procedure_header_id " +
		" left outer join mas_nursing_care mas_nursing_care on mas_nursing_care.nursing_id = procedure_details.procedure_id " +
		" where visit.visit_date between '"+sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)))+"' and '"+sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)))+"' " +
		" and visit.hospital_id="+ box.getInt("hospitalId")+"  and reporting_for = 'Dental' " +qryStr+
		" order by visit.visit_date asc";
		
		SQLQuery sqlQry = session.createSQLQuery(qry);
		
		if(box.getInt(SERVICE_TYPE_ID)!=0){
			sqlQry.setParameter("serviceType", box.getInt(SERVICE_TYPE_ID));
		}
		if(box.getInt(SERVICE_STATUS_ID)!=0){
			sqlQry.setParameter("serviceStatus", box.getInt(SERVICE_STATUS_ID));
		}
		if(box.getInt("fromRankId")!=0 && box.getInt("toRankId")!=0){
			sqlQry.setParameter("fromRank", box.getInt("fromRankId"))
			.setParameter("toRank", box.getInt("toRankId"));
		}
		if(box.getInt(RANK_CATEGORY_ID)!=0){
			sqlQry.setParameter("rankCat", box.getInt(RANK_CATEGORY_ID));
		}
		if(box.getInt(TRADE_ID)!=0){
			sqlQry.setParameter("trade", box.getInt(TRADE_ID));
		}
		if(box.getInt(UNIT_ID)!=0){
			sqlQry.setParameter("unit", box.getInt(UNIT_ID));
		}
		if(box.getInt(SECTION_ID)!=0){
			sqlQry.setParameter("section", box.getInt(SECTION_ID));
		}
		if(box.getInt(MARITAL_STATUS_ID)!=0){
			sqlQry.setParameter("mrStatus", box.getInt(MARITAL_STATUS_ID));
		}
		if(box.getInt(SEX_ID)!=0){
			sqlQry.setParameter("sex", box.getInt(SEX_ID));
		}
		if(box.getInt(RELATION_ID)!=0){
			sqlQry.setParameter("relation", box.getInt(RELATION_ID));
		}
		if (!(box.getString(SERVICE_NO).equals(""))) {
			sqlQry.setParameter("srNo", box.getInt(SERVICE_NO));
		}
		if (!(box.getString("fromAge").equals("")) && !(box.getString("fromAgeUnit").equals(""))
				&& !(box.getString("toAge").equals("")) && !(box.getString("toAgeUnit").equals(""))) {
			sqlQry.setParameter("fromAge", box.getInt("fromAge"));
			sqlQry.setParameter("fromAgeUnit", box.getString("fromAgeUnit"));
			sqlQry.setParameter("toAge", box.getInt("toAge"));
			sqlQry.setParameter("toAgeUnit", box.getString("toAgeUnit"));
		}
		if(box.getInt(CONSULTING_DOCTOR)!=0){
			sqlQry.setParameter("doctor", box.getInt(CONSULTING_DOCTOR));
		}
		
		if (!(box.getString("icdNo").equals(""))) {
			sqlQry.setString("icdCode", box.getString("icdNo"));
		}
		dentalRegisterList = sqlQry.list();
			
		map.put("dentalRegisterList", dentalRegisterList);
		return map;
	}

	@Override
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection(
				);
		map.put("conn", con);
		return map;
	}

	@Override
	public Map<String, Object> getPocedureList(Map<String, Object> map) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasNursingCare> procedureList  = new ArrayList<MasNursingCare>();
		try {
			String str = (String)map.get("autoHint") ;
			procedureList = session.createCriteria(MasNursingCare.class).add(Restrictions.sqlRestriction("upper(nursing_name) like upper('"+str+"%')"))
							.add(Restrictions.eq("Status", "y")).add(Restrictions.eq("NursingType", "d")).list();
			dataMap.put("procedureList", procedureList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("procedureList", procedureList);
		return map;
	}

		
}
