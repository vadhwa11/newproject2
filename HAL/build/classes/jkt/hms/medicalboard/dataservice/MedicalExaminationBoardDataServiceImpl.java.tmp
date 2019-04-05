package jkt.hms.medicalboard.dataservice;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasMaritalStatus;
import jkt.hms.masters.business.MasMedicalBoardExaminationDetail;
import jkt.hms.masters.business.MasMedicalExaminationReportOnEntry;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.MbTypeOfEntryMaster;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.medicalboard.controller.MedicalExaminationBoardDTO;
import jkt.hms.medicalboard.controller.MedicalExaminationBoardSearchDTO;
import jkt.hms.util.HMSUtil;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MedicalExaminationBoardDataServiceImpl extends HibernateDaoSupport
		implements MedicalExaminationBoardDataService {
	public Map<String, Object> showMedicalExaminationBoardJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasMedicalExaminationReportOnEntry> medicalExaminationBoardList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		List<MbTypeOfEntryMaster> mbTypeOfEntryMaster = new ArrayList<MbTypeOfEntryMaster>();
		List<MasUnit> masUnitList = new ArrayList<MasUnit>();

		Session session = (Session) getSession();
		int id = 0;
		List<MasMaritalStatus> masMaritalStatusList = new ArrayList<MasMaritalStatus>();
		List<MasRank> masRankList = new ArrayList<MasRank>();
		mbTypeOfEntryMaster = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MbTypeOfEntryMaster");
		masUnitList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasUnit");
		medicalExaminationBoardList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasMedicalExaminationReportOnEntry");
		masMaritalStatusList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMaritalStatus");
		masRankList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasRank");
		map.put("medicalExaminationBoardList", medicalExaminationBoardList);
		map.put("mbTypeOfEntryMaster", mbTypeOfEntryMaster);
		map.put("masUnitList", masUnitList);
		map.put("masMaritalStatusList", masMaritalStatusList);
		map.put("masRankList", masRankList);
		// Criteria crit
		// =session.createCriteria(MasMedicalExaminationReportOnEntry.class);
		List list = new ArrayList();
		list = getHibernateTemplate().find(
				"select max(Id)from MasMedicalExaminationReportOnEntry");
		if (list != null && list.size() > 0 && list.get(0) != null) {
			id = Integer.parseInt(list.get(0).toString());
			map.put("id", id);
		}
		// //System.out.println("id------------------------------"+id);

		return map;

	}

	@SuppressWarnings("unchecked")
	public boolean addMedicalExaminationBoard(
			MasMedicalExaminationReportOnEntry masMedicalExaminationReportOnEntry,
			List<MasMedicalBoardExaminationDetail> masMedicalBoardExaminationDetail) {
		String date = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		List<TransactionSequence> medicalWorkNoList = new ArrayList<TransactionSequence>();

		date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		String[] currentDate = date.split("/");
		String currentMonth = currentDate[1];

		boolean successfullyAdded = false;
		HibernateTemplate hbt = getHibernateTemplate();

		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		boolean medicalExaminationBoard = false;
		try {
			hbt.save(masMedicalExaminationReportOnEntry);
			hbt.refresh(masMedicalExaminationReportOnEntry);
			medicalExaminationBoard = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		SessionFactory sessFactory = getSessionFactory();
		Session sess = sessFactory.openSession();
		String sqlQuery = "select max(id)from MasMedicalExaminationReportOnEntry";
		Query query = sess.createQuery(sqlQuery);
		List list = query.list();
		int id = Integer.parseInt(list.get(0).toString());
		sess.close();

		// org.springframework.orm.hibernate3.HibernateTemplate hbt =
		// getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		Session session = (Session) getSession();

		if (medicalExaminationBoard && masMedicalBoardExaminationDetail != null) {

			for (MasMedicalBoardExaminationDetail masMedicalExaminationBoardDetails : masMedicalBoardExaminationDetail) {
				MasMedicalExaminationReportOnEntry masMadicalExaminationBoard = new MasMedicalExaminationReportOnEntry();
				masMadicalExaminationBoard.setId(id);
				masMedicalExaminationBoardDetails
						.setMedicalExamination(masMadicalExaminationBoard);
				hbt.save(masMedicalExaminationBoardDetails);
			}
			successfullyAdded = true;
		}
		medicalWorkNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "MED")).list();
		// HibernateTemplate hbt2 = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (successfullyAdded) {
			for (TransactionSequence transactionSequence : medicalWorkNoList) {
				TransactionSequence obj = transactionSequence;
				int id2 = obj.getId();
				int seqNo = obj.getTransactionSequenceNumber();
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id2);
				transactionSequenceObj.setTransactionSequenceNumber(++seqNo);
				if (currentMonth.equalsIgnoreCase("01")) {
					transactionSequenceObj.setTransactionSequenceNumber(1);
					seqNo = 1;
				}
				hbt.update(transactionSequenceObj);
			}
		}
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public String generateMedicalEntryNumber(String userName) {
		List<TransactionSequence> medicalWorkNoList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		Session session = (Session) getSession();
		String entryNo = "";

		String date = "";
		date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		String[] currentDate = date.split("/");
		String currentMonth = currentDate[1];
		medicalWorkNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "MED")).list();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (medicalWorkNoList.size() > 0) {
			for (TransactionSequence transactionSequence : medicalWorkNoList) {
				TransactionSequence obj = transactionSequence;
				int id = obj.getId();
				int seqNo = obj.getTransactionSequenceNumber();

				entryNo = entryNo.concat(String.valueOf(seqNo));
				// entryNo1 = entryNo.concat("/").concat(currentMonth);
				entryNo = entryNo.concat("/").concat(currentYear);
			}
		} else if (medicalWorkNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("MasMedicalExamination");
			tsObj.setTransactionPrefix("MED");
			tsObj.setTransactionSequenceName("SerialNo");
			tsObj.setTransactionSequenceNumber(0);
			hbt.save(tsObj);
		}
		return entryNo;
	}

	public String generateMedicalEntryNumber1(String userName) {
		List<TransactionSequence> medicalWorkNoList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		Session session = (Session) getSession();
		String entryNo1 = "";

		String date = "";
		date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		String[] currentDate = date.split("/");
		String currentMonth = currentDate[1];
		medicalWorkNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "MED")).list();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (medicalWorkNoList.size() > 0) {
			for (TransactionSequence transactionSequence : medicalWorkNoList) {
				TransactionSequence obj = transactionSequence;
				int id = obj.getId();
				int seqNo = obj.getTransactionSequenceNumber();

				entryNo1 = entryNo1.concat(String.valueOf(seqNo));
				entryNo1 = entryNo1.concat("/").concat(currentMonth);

			}
		} else if (medicalWorkNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("MasMedicalExamination");
			tsObj.setTransactionPrefix("MED");
			tsObj.setTransactionSequenceName("SerialNo");
			tsObj.setTransactionSequenceNumber(0);
			hbt.save(tsObj);
		}

		return entryNo1;
	}

	// ///////////////////////////////////////////////////////////////////////////
	// search
	// ///////////////////////////////////////////////////////////////////////////

	@SuppressWarnings("unchecked")
	public Map<String, Object> showMedicalExaminationBoardsSearchJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasMedicalExaminationReportOnEntry> medicalExaminationBoardList = new ArrayList<MasMedicalExaminationReportOnEntry>();

		medicalExaminationBoardList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasMedicalExaminationReportOnEntry");

		map.put("medicalExaminationBoardList", medicalExaminationBoardList);

		return map;

	}

	public Map<String, Object> searchMedicalExaminationBoardSearch(
			MedicalExaminationBoardSearchDTO medicalExaminationBoardSearchDTO) {
		List<MasMedicalExaminationReportOnEntry> medicalExaminationBoardList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		Map<String, Object> medicalBoardSearchFieldsMap = new HashMap<String, Object>();

		String yearlySerialNo = "";
		String service = "";
		String batchNo = "";
		String chestNo = "";
		String rallNo = "";
		Session session = (Session) getSession();
		if (medicalExaminationBoardSearchDTO.getYearlySearialNo() != null) {

			yearlySerialNo = medicalExaminationBoardSearchDTO
					.getYearlySearialNo();

		}

		if (medicalExaminationBoardSearchDTO.getBatchNo() != null) {
			batchNo = medicalExaminationBoardSearchDTO.getBatchNo();

		}

		if (medicalExaminationBoardSearchDTO.getChestNo() != null) {
			chestNo = medicalExaminationBoardSearchDTO.getChestNo();

		}
		if (medicalExaminationBoardSearchDTO.getRollNo() != null) {
			rallNo = medicalExaminationBoardSearchDTO.getRollNo();

		}
		if (medicalExaminationBoardSearchDTO.getService() != null) {
			service = medicalExaminationBoardSearchDTO.getService();

		}

		try {
			Criteria crit = session
					.createCriteria(MasMedicalExaminationReportOnEntry.class);

			if (yearlySerialNo != null) {
				crit = crit.add(Restrictions.like("YearlySerialNo", "%"
						+ yearlySerialNo + "%"));

			}
			if (batchNo != null) {
				crit = crit.add(Restrictions.like("BatchNo", "%" + batchNo
						+ "%"));

			}

			if (chestNo != null) {
				crit = crit.add(Restrictions.like("ChestNo", chestNo + "%"));

			}
			if (rallNo != null) {
				crit = crit.add(Restrictions.like("RollNo", rallNo + "%"));

			}
			if (service != null) {
				crit = crit.add(Restrictions.like("Service", "%" + service
						+ "%"));

			}

			medicalExaminationBoardList = crit.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		medicalBoardSearchFieldsMap.put("medicalExaminationBoardList",
				medicalExaminationBoardList);
		return medicalBoardSearchFieldsMap;
	}

	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// update
	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public Map<String, Object> showMedicalExaminationBoardUpdateJsp(int Id) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasMedicalBoardExaminationDetail> medicalBoardExaminationDetailList = new ArrayList<MasMedicalBoardExaminationDetail>();
		List<MasMedicalExaminationReportOnEntry> medicalExaminationBoardList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		List<MbTypeOfEntryMaster> mbTypeOfEntryMaster = new ArrayList<MbTypeOfEntryMaster>();
		List<MasUnit> masUnitList = new ArrayList<MasUnit>();
		List<MasMaritalStatus> masMaritalStatusList = new ArrayList<MasMaritalStatus>();
		List<MasRank> masRankList = new ArrayList<MasRank>();
		medicalBoardExaminationDetailList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasMedicalBoardExaminationDetail mc where mc.MedicalExamination='"
								+ Id + "'");
		mbTypeOfEntryMaster = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MbTypeOfEntryMaster");
		masUnitList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasUnit");
		medicalExaminationBoardList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMedicalExaminationReportOnEntry  where Id='"
						+ Id + "'");
		masMaritalStatusList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMaritalStatus");
		masRankList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasRank");
		map.put("medicalBoardExaminationDetailList",
				medicalBoardExaminationDetailList);
		map.put("medicalExaminationBoardList", medicalExaminationBoardList);
		map.put("mbTypeOfEntryMaster", mbTypeOfEntryMaster);
		map.put("masUnitList", masUnitList);
		map.put("masMaritalStatusList", masMaritalStatusList);
		map.put("masRankList", masRankList);
		map.put("Id", Id);
		return map;

	}

	@SuppressWarnings( { "unused", "unchecked" })
	public boolean medicalExaminationBoardUpdateToDatabase(
			Map<String, Object> generalMap) {
		HibernateTemplate hbt1 = getHibernateTemplate();
		Session sess = (Session) getSession();
		boolean dataUpdated = false;
		int typeOfEntry = 0;
		String betchNo = "";
		String chestNo = "";
		String rollNo = "";
		int medicalExamHeld = 0;
		String medicalStatus = "";
		String fullName = "";
		Date dateOfBirth = null;
		int maritialStatus = 0;
		String service = "";
		String pNo = "";
		String rank = "";
		String hoursOfFlown = "";
		String permanentAddress = "";
		String identification1 = "";
		String identification2 = "";
		String armsCrops = "";
		Date dateOfReporting = null;
		Date dateOfCompletion = null;
		Date documentForwardDate = null;
		String documentForwardTo = "";
		String fromWhereHeReport = "";
		int srNo = 0;
		String Relation = "";
		String age = "";
		String health = "";
		String couseOfDeath = "";
		String died = "";
		String hypertension = "";
		String heartDisease = "";
		String diabetes = "";
		String bleedingDisorder = "";
		String mentalDisease = "";
		String nightBlindness = "";

		String asthama = "";
		String dischargeFrom = "";
		String plesury = "";
		String earDieses = "";
		String rheumatism = "";
		String frequentCough = "";
		String chronicIndigestion = "";
		String nervousBrakdown = "";
		String kidenyBladder = "";
		String fitsFaintinngAttacks = "";
		String std = "";
		String serveHeadInjury = "";
		String joundice = "";
		String sickness = "";
		String breastDisease = "";
		String trachoma = "";
		String amenorrhoea = "";
		String nightbindness = "";
		String menirrhagia = "";
		String laserTeartement = "";
		String pregnancy = "";
		String abortion = "";
		String eyeDisease = "";
		String rejectedAsUnfit = "";
		String dischargeMedicallyUnfit = "";
		String adimmitedInHospitalFirIllness = "";
		String stateNature = "";
		String otherInform = "";
		BigDecimal height = new BigDecimal(0);
		BigDecimal weight = new BigDecimal(0);
		BigDecimal acceptableKg = new BigDecimal(0);
		BigDecimal leglength = new BigDecimal(0);
		String appereance = "";
		String albumin = "";
		String sugar = "";
		String spGraviry = "";
		String hbPercentage = "";
		String physique = "";
		String anyOtherInv = "";
		String skin = "";
		String abdomen = "";
		String heartSize = "";
		String sound = "";
		String rhythm = "";
		String arterialWalls = "";
		String pulseRates = "";
		String bp = "";
		String fullExpension = "";
		String rangeOfExpension = "";
		String selfBalR = "";
		String selfBalL = "";
		String speechMental = "";
		String endocrinCond = "";
		String otherAbnormalities = "";
		String medicinRemarks = "";
		String finger = "";
		String hand = "";
		String wrist = "";
		String elbows = "";
		String shoulderGridles = "";
		String cercival = "";
		String dorsalVertebrate = "";
		String hullux = "";
		String valgus = "";
		String riggus = "";
		String flatFeet = "";
		String joints = "";
		String pelvis = "";
		String gail = "";
		String lumberScaler = "";
		String roccyxVericose = "";
		String hydrocele = "";
		String varicocele = "";
		String underScende = "";
		String hemonhoids = "";
		String herinaMusic = "";
		String breasts = "";
		String surgeryRemarks = "";
		String respatorySystem = "";
		String message = "";
		String jsp = "";
		String url = "";
		String title = "";
		String withGlassesDistantR = "";
		String withglassesDistantL = "";
		String withGlassesNearR = "";
		String withGlassesNearL = "";
		String withGlassesNearCP = "";
		String withoutGlassesDistantR = "";
		String withoutGlassesDistantL = "";
		String withoutGlassesNearR = "";
		String withoutGlassesNearL = "";
		String withoutGlassesNearCP = "";
		BigDecimal convergenceCP = new BigDecimal(0);

		BigDecimal convergenceC = new BigDecimal(0);
		String accommodationR = "";
		String accommodationL = "";
		String eyeRemarks = "";
		Date eyeDate = null;
		BigDecimal hearingRFW = new BigDecimal(0);
		BigDecimal hearingLFW = new BigDecimal(0);
		BigDecimal hearingBothFW = new BigDecimal(0);
		BigDecimal hearingRCV = new BigDecimal(0);
		BigDecimal hearingLCV = new BigDecimal(0);
		BigDecimal hearingBothCV = new BigDecimal(0);

		String innerEarR = "";

		String innerEarL = "";
		String audiometryRecord = "";
		String nose = "";
		String throatEar = "";
		String earReamrks = "";
		Date earDate = null;
		Date entryDate = null;
		String externalEarR = "";
		String externalEarL = "";
		String middleEarR = "";
		String middleEarL = "";
		String evidienceOfTrachoma = "";
		String binocular = "";
		String manifestHypermetropia = "";
		String coverTest = "";
		String diaphragmTest = "";
		String fundMedia = "";
		String fields = "";
		String nightVisualCapacity = "";

		String dentalRemarks = "";
		Date dentalDate = null;
		String menstrualHistory = "";
		int noOfPregnancy = 0;
		int noOfAbortion = 0;
		int noOfChildren = 0;
		Date lastCondinement = null;
		String vaginalDischarge = "";
		String prolapse = "";
		String usgAbortion = "";
		String gyanaecologyRemarks = "";
		Date gyanaecologyDate = null;
		String medicalBoardExamination = "";
		int medicalBoardExaminationPlace = 0;
		Date medicalBoardExaminationDate = null;
		String subsequentMedicalBoardExam = "";
		int subsequentMedicalBoardExamPlace = 0;
		Date subsequentMedicalBoardExamDate = null;
		String ApprovingAuthority = "";
		int ApprovingAuthorityPlace = 0;
		Date ApprovingAuthorityDate = null;
		Date surgeyDate = null;
		Date medicinExamDate = null;
		String lmp = "";
		String totalTeeth = "";
		String totalDefectiveTeeth = "";
		String missingTeeth = "";
		String DenstalPoint = "";
		String unserviceableTeeth = "";

		String dur8 = "";
		String dur7 = "";
		String dur6 = "";
		String dur5 = "";
		String dur4 = "";
		String dur3 = "";
		String dur2 = "";
		String dur1 = "";
		String dul8 = "";
		String dul7 = "";
		String dul6 = "";
		String dul5 = "";
		String dul4 = "";
		String dul3 = "";
		String dul2 = "";
		String dul1 = "";
		String dlr8 = "";
		String dlr7 = "";
		String dlr6 = "";
		String dlr5 = "";
		String dlr4 = "";
		String dlr3 = "";
		String dlr2 = "";
		String dlr1 = "";
		String dll8 = "";
		String dll7 = "";
		String dll6 = "";
		String dll5 = "";
		String dll4 = "";
		String dll3 = "";
		String dll2 = "";
		String dll1 = "";
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
		String mll3 = "";
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
		int Id = 0;

		Id = (Integer) generalMap.get("Id");

		sur8 = (String) generalMap.get("sur8");
		sur7 = (String) generalMap.get("sur7");
		sur6 = (String) generalMap.get("sur6");
		sur5 = (String) generalMap.get("sur5");
		sur4 = (String) generalMap.get("sur4");
		sur3 = (String) generalMap.get("sur3");
		sur2 = (String) generalMap.get("sur2");
		sur1 = (String) generalMap.get("sur1");

		sul8 = (String) generalMap.get("sul8");
		sul7 = (String) generalMap.get("sul7");
		sul6 = (String) generalMap.get("sul6");
		sul5 = (String) generalMap.get("sul5");
		sul4 = (String) generalMap.get("sul4");
		sul3 = (String) generalMap.get("sul3");
		sul2 = (String) generalMap.get("sul2");
		sul1 = (String) generalMap.get("sul1");

		slr1 = (String) generalMap.get("slr1");
		slr2 = (String) generalMap.get("slr2");
		slr3 = (String) generalMap.get("slr3");
		slr4 = (String) generalMap.get("slr4");
		slr5 = (String) generalMap.get("slr5");
		slr6 = (String) generalMap.get("slr6");
		slr7 = (String) generalMap.get("slr7");
		slr8 = (String) generalMap.get("slr8");

		sll1 = (String) generalMap.get("sll1");
		sll2 = (String) generalMap.get("sll2");
		sll3 = (String) generalMap.get("sll3");
		sll4 = (String) generalMap.get("sll4");
		sll5 = (String) generalMap.get("sll5");
		sll6 = (String) generalMap.get("sll6");
		sll7 = (String) generalMap.get("sll7");
		sll8 = (String) generalMap.get("sll8");

		externalEarR = (String) generalMap.get("externalEarR");
		externalEarL = (String) generalMap.get("externalEarL");
		middleEarR = (String) generalMap.get("middleEarR");
		middleEarL = (String) generalMap.get("middleEarL");
		evidienceOfTrachoma = (String) generalMap.get("evidienceOfTrachoma");
		binocular = (String) generalMap.get("binocular");
		manifestHypermetropia = (String) generalMap
				.get("manifestHypermetropia");
		coverTest = (String) generalMap.get("coverTest");
		diaphragmTest = (String) generalMap.get("diaphragmTest");
		fundMedia = (String) generalMap.get("fundMedia");
		nightVisualCapacity = (String) generalMap.get("nightVisualCapacity");
		withGlassesDistantR = (String) generalMap.get("withGlassesDistantR");
		withglassesDistantL = (String) generalMap.get("withglassesDistantL");
		withGlassesNearCP = (String) generalMap.get("withGlassesNearCP");
		withGlassesNearL = (String) generalMap.get("withGlassesNearL");
		withGlassesNearR = (String) generalMap.get("withGlassesNearR");
		withoutGlassesDistantR = (String) generalMap
				.get("withoutGlassesDistantR");
		withoutGlassesDistantL = (String) generalMap
				.get("withoutGlassesDistantL");
		withoutGlassesNearCP = (String) generalMap.get("withoutGlassesNearCP");
		withoutGlassesNearL = (String) generalMap.get("withoutGlassesNearL");
		withoutGlassesNearR = (String) generalMap.get("withoutGlassesNearR");
		convergenceCP = (BigDecimal) generalMap.get("convergenceCP");
		convergenceC = (BigDecimal) generalMap.get("convergenceC");
		accommodationR = (String) generalMap.get("accommodationR");
		accommodationL = (String) generalMap.get("accommodationL");
		eyeRemarks = (String) generalMap.get("eyeRemarks");
		eyeDate = (Date) generalMap.get("eyeDate");
		hearingRFW = (BigDecimal) generalMap.get("hearingRFW");
		hearingLFW = (BigDecimal) generalMap.get("hearingLFW");
		hearingBothFW = (BigDecimal) generalMap.get("hearingBothFW");
		hearingRCV = (BigDecimal) generalMap.get("hearingRCV");
		hearingLCV = (BigDecimal) generalMap.get("hearingLCV");
		hearingBothCV = (BigDecimal) generalMap.get("hearingBothCV");
		innerEarR = (String) generalMap.get("innerEarR");
		innerEarL = (String) generalMap.get("innerEarL");
		audiometryRecord = (String) generalMap.get("audiometryRecord");
		nose = (String) generalMap.get("nose");
		throatEar = (String) generalMap.get("throatEar");
		earReamrks = (String) generalMap.get("earReamrks");
		earDate = (Date) generalMap.get("earDate");

		entryDate = (Date) generalMap.get("entryDate");
		typeOfEntry = (Integer) generalMap.get("typeOfEntry");
		betchNo = (String) generalMap.get("betchNo");
		chestNo = (String) generalMap.get("chestNo");
		rollNo = (String) generalMap.get("rollNo");
		medicalExamHeld = (Integer) generalMap.get("medicalExamHeld");
		medicalStatus = (String) generalMap.get("medicalStatus");
		fullName = (String) generalMap.get("fullName");
		dateOfBirth = (Date) generalMap.get("dateOfBirth");
		maritialStatus = (Integer) generalMap.get("maritialStatus");
		service = (String) generalMap.get("service");
		pNo = (String) generalMap.get("pNo");
		rank = (String) generalMap.get("rank");
		hoursOfFlown = (String) generalMap.get("hoursOfFlown");
		permanentAddress = (String) generalMap.get("permanentAddress");
		identification1 = (String) generalMap.get("identification1");
		identification2 = (String) generalMap.get("identification2");
		armsCrops = (String) generalMap.get("armsCrops");
		dateOfCompletion = (Date) generalMap.get("dateOfCompletion");
		dateOfReporting = (Date) generalMap.get("dateOfReporting");

		documentForwardDate = (Date) generalMap.get("documentForwardDate");
		documentForwardTo = (String) generalMap.get("documentForwardTo");
		fromWhereHeReport = (String) generalMap.get("fromWhereHeReport");
		hypertension = (String) generalMap.get("hypertension");
		heartDisease = (String) generalMap.get("heartDisease");
		diabetes = (String) generalMap.get("diabetes");
		bleedingDisorder = (String) generalMap.get("bleedingDisorder");
		mentalDisease = (String) generalMap.get("mentalDisease");
		nightBlindness = (String) generalMap.get("nightBlindness");
		asthama = (String) generalMap.get("asthama");
		dischargeFrom = (String) generalMap.get("dischargeFrom");
		plesury = (String) generalMap.get("plesury");
		earDieses = (String) generalMap.get("earDieses");
		earDieses = (String) generalMap.get("rheumatism");
		frequentCough = (String) generalMap.get("frequentCough");
		chronicIndigestion = (String) generalMap.get("chronicIndigestion");
		nervousBrakdown = (String) generalMap.get("nervousBrakdown");
		kidenyBladder = (String) generalMap.get("kidenyBladder");
		fitsFaintinngAttacks = (String) generalMap.get("fitsFaintinngAttacks");
		std = (String) generalMap.get("std");
		serveHeadInjury = (String) generalMap.get("serveHeadInjury");
		joundice = (String) generalMap.get("joundice");
		sickness = (String) generalMap.get("sickness");
		breastDisease = (String) generalMap.get("breastDisease");
		trachoma = (String) generalMap.get("trachoma");
		amenorrhoea = (String) generalMap.get("amenorrhoea");
		nightbindness = (String) generalMap.get("nightbindness");
		menirrhagia = (String) generalMap.get("menirrhagia");
		laserTeartement = (String) generalMap.get("laserTeartement");
		pregnancy = (String) generalMap.get("pregnancy");
		eyeDisease = (String) generalMap.get("eyeDisease");
		rejectedAsUnfit = (String) generalMap.get("rejectedAsUnfit");
		dischargeMedicallyUnfit = (String) generalMap
				.get("dischargeMedicallyUnfit");
		adimmitedInHospitalFirIllness = (String) generalMap
				.get("adimmitedInHospitalFirIllness");
		abortion = (String) generalMap.get("abortion");
		respatorySystem = (String) generalMap.get("respatorySystem");
		stateNature = (String) generalMap.get("stateNature");
		otherInform = (String) generalMap.get("otherInform");
		height = (BigDecimal) generalMap.get("height");
		weight = (BigDecimal) generalMap.get("weight");
		acceptableKg = (BigDecimal) generalMap.get("acceptableKg");
		leglength = (BigDecimal) generalMap.get("leglength");
		appereance = (String) generalMap.get("appereance");
		albumin = (String) generalMap.get("albumin");
		sugar = (String) generalMap.get("sugar");
		spGraviry = (String) generalMap.get("spGraviry");
		hbPercentage = (String) generalMap.get("hbPercentage");
		physique = (String) generalMap.get("physique");
		anyOtherInv = (String) generalMap.get("anyOtherInv");
		skin = (String) generalMap.get("skin");
		abdomen = (String) generalMap.get("abdomen");
		heartSize = (String) generalMap.get("heartSize");
		sound = (String) generalMap.get("sound");
		rhythm = (String) generalMap.get("rhythm");
		arterialWalls = (String) generalMap.get("arterialWalls");
		pulseRates = (String) generalMap.get("pulseRates");
		bp = (String) generalMap.get("bp");
		fullExpension = (String) generalMap.get("fullExpension");
		rangeOfExpension = (String) generalMap.get("rangeOfExpension");
		selfBalR = (String) generalMap.get("selfBalR");
		selfBalL = (String) generalMap.get("selfBalL");
		speechMental = (String) generalMap.get("speechMental");
		endocrinCond = (String) generalMap.get("endocrinCond");
		otherAbnormalities = (String) generalMap.get("otherAbnormalities");
		medicinRemarks = (String) generalMap.get("medicinRemarks");
		finger = (String) generalMap.get("finger");
		hand = (String) generalMap.get("hand");
		wrist = (String) generalMap.get("wrist");
		elbows = (String) generalMap.get("elbows");
		shoulderGridles = (String) generalMap.get("shoulderGridles");
		cercival = (String) generalMap.get("cercival");
		dorsalVertebrate = (String) generalMap.get("dorsalVertebrate");
		hullux = (String) generalMap.get("hullux");
		valgus = (String) generalMap.get("valgus");
		riggus = (String) generalMap.get("riggus");
		flatFeet = (String) generalMap.get("flatFeet");
		joints = (String) generalMap.get("joints");
		pelvis = (String) generalMap.get("pelvis");
		gail = (String) generalMap.get("gail");
		lumberScaler = (String) generalMap.get("lumberScaler");
		roccyxVericose = (String) generalMap.get("roccyxVericose");
		hydrocele = (String) generalMap.get("hydrocele");
		varicocele = (String) generalMap.get("varicocele");
		underScende = (String) generalMap.get("underScende");
		hemonhoids = (String) generalMap.get("hemonhoids");
		herinaMusic = (String) generalMap.get("herinaMusic");
		breasts = (String) generalMap.get("breasts");
		surgeryRemarks = (String) generalMap.get("surgeryRemarks");
		dentalRemarks = (String) generalMap.get("dentalRemarks");
		dentalRemarks = (String) generalMap.get("dentalRemarks");
		dentalDate = (Date) generalMap.get("dentalDate");
		menstrualHistory = (String) generalMap.get("menstrualHistory");
		noOfPregnancy = (Integer) generalMap.get("noOfPregnancy");
		noOfAbortion = (Integer) generalMap.get("noOfAbortion");
		noOfChildren = (Integer) generalMap.get("noOfChildren");
		lastCondinement = (Date) generalMap.get("lastCondinement");
		vaginalDischarge = (String) generalMap.get("vaginalDischarge");
		prolapse = (String) generalMap.get("prolapse");
		usgAbortion = (String) generalMap.get("usgAbortion");
		gyanaecologyRemarks = (String) generalMap.get("gyanaecologyRemarks");
		gyanaecologyDate = (Date) generalMap.get("gyanaecologyDate");
		medicalBoardExamination = (String) generalMap
				.get("medicalBoardExamination");
		medicalBoardExaminationPlace = (Integer) generalMap
				.get("medicalBoardExaminationPlace");
		medicalBoardExaminationDate = (Date) generalMap
				.get("medicalBoardExaminationDate");
		subsequentMedicalBoardExam = (String) generalMap
				.get("subsequentMedicalBoardExam");
		subsequentMedicalBoardExamPlace = (Integer) generalMap
				.get("subsequentMedicalBoardExamPlace");
		subsequentMedicalBoardExamDate = (Date) generalMap
				.get("subsequentMedicalBoardExamDate");
		ApprovingAuthority = (String) generalMap.get("ApprovingAuthority");
		ApprovingAuthorityPlace = (Integer) generalMap
				.get("ApprovingAuthorityPlace");
		ApprovingAuthorityDate = (Date) generalMap
				.get("ApprovingAuthorityDate");
		lmp = (String) generalMap.get("lmp");
		surgeyDate = (Date) generalMap.get("surgeyDate");
		medicinExamDate = (Date) generalMap.get("medicinExamDate");
		totalTeeth = (String) generalMap.get("totalTeeth");
		totalDefectiveTeeth = (String) generalMap.get("totalDefectiveTeeth");
		missingTeeth = (String) generalMap.get("missingTeeth");
		unserviceableTeeth = (String) generalMap.get("unserviceableTeeth");
		DenstalPoint = (String) generalMap.get("DenstalPoint");
		fields = (String) generalMap.get("fields");
		MasMedicalExaminationReportOnEntry masMedicalExaminationReportOnEntry = (MasMedicalExaminationReportOnEntry) getHibernateTemplate()
				.load(MasMedicalExaminationReportOnEntry.class, Id);

		masMedicalExaminationReportOnEntry.setEntryDate(entryDate);
		MbTypeOfEntryMaster mbTypeOfEntryMaster = new MbTypeOfEntryMaster();
		mbTypeOfEntryMaster.setId(typeOfEntry);
		masMedicalExaminationReportOnEntry.setTypeOfEntry(mbTypeOfEntryMaster);
		masMedicalExaminationReportOnEntry.setBatchNo(betchNo);
		masMedicalExaminationReportOnEntry.setChestNo(chestNo);
		masMedicalExaminationReportOnEntry.setRollNo(rollNo);
		MasUnit masUnit = new MasUnit();
		masUnit.setId(medicalExamHeld);
		masMedicalExaminationReportOnEntry.setHearingBothCv(hearingBothCV);
		masMedicalExaminationReportOnEntry.setDateSpecialExam(eyeDate);
		masMedicalExaminationReportOnEntry.setTotalTeeth(totalTeeth);
		masMedicalExaminationReportOnEntry
				.setTotalDefectiveTeeth(totalDefectiveTeeth);
		masMedicalExaminationReportOnEntry.setMissingTeeth(missingTeeth);
		masMedicalExaminationReportOnEntry
				.setUnservisableTeeth(unserviceableTeeth);
		masMedicalExaminationReportOnEntry.setDenstlPoint(DenstalPoint);
		masMedicalExaminationReportOnEntry.setMedicalExamHeldAt(masUnit);
		masMedicalExaminationReportOnEntry.setMedicalStatus(medicalStatus);
		masMedicalExaminationReportOnEntry.setNameInFull(fullName);
		masMedicalExaminationReportOnEntry.setDateOfBirth(dateOfBirth);
		MasMaritalStatus masMaritalStatus = new MasMaritalStatus();
		masMaritalStatus.setId(maritialStatus);
		masMedicalExaminationReportOnEntry.setMaritalStatus(masMaritalStatus);
//		masMedicalExaminationReportOnEntry.setService(service);
		masMedicalExaminationReportOnEntry.setPNo(pNo);
//		masMedicalExaminationReportOnEntry.setRank(rank);
		masMedicalExaminationReportOnEntry.setHoursOfFlown(hoursOfFlown);
		masMedicalExaminationReportOnEntry
				.setParmanentAddress(permanentAddress);
		masMedicalExaminationReportOnEntry
				.setIdentificationMarks1(identification1);
		masMedicalExaminationReportOnEntry
				.setIdentificationMarks2(identification2);
		masMedicalExaminationReportOnEntry.setArmsCorps(armsCrops);
		masMedicalExaminationReportOnEntry
				.setDateOfCompletion(dateOfCompletion);
		masMedicalExaminationReportOnEntry
				.setDocumentForwardDate(documentForwardDate);
		masMedicalExaminationReportOnEntry.setDateOfReporting(dateOfReporting);

		masMedicalExaminationReportOnEntry
				.setDocumentForwardTo(documentForwardTo);
		masMedicalExaminationReportOnEntry
				.setFromWhereHeReport(fromWhereHeReport);
		masMedicalExaminationReportOnEntry.setHypertension(hypertension);
		masMedicalExaminationReportOnEntry.setHeartDiabetes(heartDisease);
		masMedicalExaminationReportOnEntry.setDiabetes(diabetes);
		masMedicalExaminationReportOnEntry
				.setBleedingDisorder(bleedingDisorder);
		masMedicalExaminationReportOnEntry.setMentalDisease(mentalDisease);
		masMedicalExaminationReportOnEntry.setNightBlindness(nightBlindness);
		masMedicalExaminationReportOnEntry.setChronicBronchitis(asthama);
		masMedicalExaminationReportOnEntry.setDischargeFromEars(dischargeFrom);
		masMedicalExaminationReportOnEntry.setPleurisy(plesury);
		masMedicalExaminationReportOnEntry.setAnyOtherEarDisease(earDieses);
		masMedicalExaminationReportOnEntry
				.setRheumatismFrequentSorethroats(rheumatism);
		masMedicalExaminationReportOnEntry
				.setFrequentCoughColdSinusitis(frequentCough);
		masMedicalExaminationReportOnEntry
				.setChronicIndigestion(chronicIndigestion);
		masMedicalExaminationReportOnEntry
				.setNervousBreakdownMentalIllness(nervousBrakdown);
		masMedicalExaminationReportOnEntry
				.setKidneyBladderTrouble(kidenyBladder);
		masMedicalExaminationReportOnEntry
				.setFitsFaintingAttack(fitsFaintinngAttacks);
		masMedicalExaminationReportOnEntry.setStd(std);
		masMedicalExaminationReportOnEntry.setSevereHeadInjury(serveHeadInjury);
		masMedicalExaminationReportOnEntry.setJaundice(joundice);
		masMedicalExaminationReportOnEntry.setAirSeaCarTrainSickness(sickness);
		masMedicalExaminationReportOnEntry
				.setBreastDiseaseDischarge(breastDisease);
		masMedicalExaminationReportOnEntry.setTrachoma(trachoma);
		masMedicalExaminationReportOnEntry
				.setAmenorrhoeaDysmenonhoea(amenorrhoea);
		masMedicalExaminationReportOnEntry.setNightBindness(nightbindness);
		masMedicalExaminationReportOnEntry.setMenonhagia(menirrhagia);
		masMedicalExaminationReportOnEntry
				.setLaserTreatementSurgeryForEye(laserTeartement);
		masMedicalExaminationReportOnEntry.setPregnancy(pregnancy);
		masMedicalExaminationReportOnEntry.setAnyOtherEyeDisease(eyeDisease);
		masMedicalExaminationReportOnEntry.setAbortion(abortion);
		masMedicalExaminationReportOnEntry
				.setBeenrejectedAsMedicallyUnfitForAnyBranch(rejectedAsUnfit);
		masMedicalExaminationReportOnEntry
				.setDischargeAsMedicallyUnfitForAnyBranch(dischargeMedicallyUnfit);
		masMedicalExaminationReportOnEntry
				.setAdmittedInHospitalForAnyIllnessOperationOrInjury(adimmitedInHospitalFirIllness);

		masMedicalExaminationReportOnEntry
				.setStateTheNatureOfDiseaseDuration(stateNature);
		masMedicalExaminationReportOnEntry
				.setAnyOtherInformationAboutYourHealth(otherInform);

		masMedicalExaminationReportOnEntry.setHeight(height);
		masMedicalExaminationReportOnEntry.setWeight(weight);
		masMedicalExaminationReportOnEntry.setAcceptable(acceptableKg);
		masMedicalExaminationReportOnEntry.setLegLength(leglength);
		masMedicalExaminationReportOnEntry.setAppearance(appereance);
		masMedicalExaminationReportOnEntry.setAlbumin(albumin);
		masMedicalExaminationReportOnEntry.setSugar(sugar);
		masMedicalExaminationReportOnEntry.setSpGravity(spGraviry);
		masMedicalExaminationReportOnEntry.setHbPercentage(hbPercentage);
		masMedicalExaminationReportOnEntry
				.setAnyOtherInvCarriedOut(anyOtherInv);
		masMedicalExaminationReportOnEntry.setPhysique(physique);
		masMedicalExaminationReportOnEntry.setSkin(skin);
		masMedicalExaminationReportOnEntry.setAbdomen(abdomen);
		masMedicalExaminationReportOnEntry.setHeartSize(heartSize);
		masMedicalExaminationReportOnEntry.setSounds(sound);
		masMedicalExaminationReportOnEntry.setRhythm(rhythm);
		masMedicalExaminationReportOnEntry.setArterialWalls(arterialWalls);
		masMedicalExaminationReportOnEntry.setPulseRates(pulseRates);
		masMedicalExaminationReportOnEntry.setBp(bp);
		masMedicalExaminationReportOnEntry.setChestMeasurement(fullExpension);
		masMedicalExaminationReportOnEntry
				.setRangeOfExpension(rangeOfExpension);
		masMedicalExaminationReportOnEntry.setSelfBalancingR(selfBalR);
		masMedicalExaminationReportOnEntry.setSelfBalancingL(selfBalL);
		masMedicalExaminationReportOnEntry
				.setSpeechMentalCapacity(speechMental);
		masMedicalExaminationReportOnEntry.setEndocrineCondition(endocrinCond);
		masMedicalExaminationReportOnEntry
				.setAnyOtheAbnormalities(otherAbnormalities);
		masMedicalExaminationReportOnEntry.setRemarks(medicinRemarks);
		masMedicalExaminationReportOnEntry.setFingers(finger);
		masMedicalExaminationReportOnEntry.setHand(hand);
		masMedicalExaminationReportOnEntry.setWrists(wrist);
		masMedicalExaminationReportOnEntry.setElbows(elbows);
		masMedicalExaminationReportOnEntry.setShoulderGirdles(shoulderGridles);
		masMedicalExaminationReportOnEntry.setCervical(cercival);
		masMedicalExaminationReportOnEntry
				.setDorsalVertebrate(dorsalVertebrate);
		masMedicalExaminationReportOnEntry.setHullux(hullux);
		masMedicalExaminationReportOnEntry.setValgus(valgus);
		masMedicalExaminationReportOnEntry.setRigigus(riggus);
		masMedicalExaminationReportOnEntry.setFlatFeet(flatFeet);
		masMedicalExaminationReportOnEntry.setJoints(joints);
		masMedicalExaminationReportOnEntry.setPelvis(pelvis);
		masMedicalExaminationReportOnEntry.setGail(gail);
		masMedicalExaminationReportOnEntry.setLumber(lumberScaler);
		masMedicalExaminationReportOnEntry.setRoccyxVarocose(roccyxVericose);
		masMedicalExaminationReportOnEntry.setHydrocele(hydrocele);
		masMedicalExaminationReportOnEntry.setVaricocele(varicocele);
		masMedicalExaminationReportOnEntry.setUnderscendedTest(underScende);
		masMedicalExaminationReportOnEntry.setHemorrhoids(hemonhoids);
		masMedicalExaminationReportOnEntry.setHerniaMusic(herinaMusic);
		masMedicalExaminationReportOnEntry.setBreasts(breasts);
		masMedicalExaminationReportOnEntry.setRemarksLowerlimbs(surgeryRemarks);
		masMedicalExaminationReportOnEntry
				.setRespiratorySystem(respatorySystem);
		masMedicalExaminationReportOnEntry
				.setWithGlassesLDistant(withglassesDistantL);
		masMedicalExaminationReportOnEntry
				.setWithGlassesRDistant(withGlassesDistantR);
		masMedicalExaminationReportOnEntry
				.setWithoutGlassesLDistant(withoutGlassesDistantL);
		masMedicalExaminationReportOnEntry
				.setWthoutGlassesRDistant(withoutGlassesDistantR);
		masMedicalExaminationReportOnEntry
				.setWithGlassesLNearvision(withGlassesNearL);
		masMedicalExaminationReportOnEntry
				.setWithGlassesRNearvision(withGlassesNearR);
		masMedicalExaminationReportOnEntry
				.setWithoutGlassesLNearvision(withoutGlassesNearL);
		masMedicalExaminationReportOnEntry
				.setWithoutGlassesRNearvision(withoutGlassesNearR);
		masMedicalExaminationReportOnEntry
				.setEvidenceOfTrachoma(evidienceOfTrachoma);
		masMedicalExaminationReportOnEntry.setBinocularVisionGrade(binocular);
		masMedicalExaminationReportOnEntry
				.setManifestHypermetropia(manifestHypermetropia);
		masMedicalExaminationReportOnEntry.setCoverTest(coverTest);
		masMedicalExaminationReportOnEntry.setDiaphragmTest(diaphragmTest);
		masMedicalExaminationReportOnEntry.setFundAndMedia(fundMedia);
		masMedicalExaminationReportOnEntry.setFields(fields);
		masMedicalExaminationReportOnEntry
				.setNightVisualCapacity(nightVisualCapacity);
		masMedicalExaminationReportOnEntry.setConvergenceC(convergenceC);
		masMedicalExaminationReportOnEntry.setConvergenceSc(convergenceCP);
		masMedicalExaminationReportOnEntry.setAccommodationR(accommodationR);
		masMedicalExaminationReportOnEntry.setAccommodationL(accommodationL);
		masMedicalExaminationReportOnEntry.setRemarksSpecialExam(eyeRemarks);
		masMedicalExaminationReportOnEntry.setHearingRcv(hearingRCV);
		masMedicalExaminationReportOnEntry.setHearingLcv(hearingLCV);
		masMedicalExaminationReportOnEntry.setEarHearingRfw(hearingRFW);
		masMedicalExaminationReportOnEntry.setEarHearingLfw(hearingLFW);
		masMedicalExaminationReportOnEntry.setEarHearingBothFw(hearingBothFW);
		masMedicalExaminationReportOnEntry.setExternalEarR(externalEarR);
		masMedicalExaminationReportOnEntry.setExternalEarL(externalEarL);
		masMedicalExaminationReportOnEntry.setMiddleEarR(middleEarR);
		masMedicalExaminationReportOnEntry.setMiddleEar(middleEarL);
		masMedicalExaminationReportOnEntry.setInnerEarR(innerEarR);
		masMedicalExaminationReportOnEntry
				.setAudiometryRecord(audiometryRecord);
		masMedicalExaminationReportOnEntry.setNose(nose);
		masMedicalExaminationReportOnEntry.setThroat(throatEar);
		masMedicalExaminationReportOnEntry.setRemarksEar(earReamrks);
		masMedicalExaminationReportOnEntry.setEarDate(earDate);
		masMedicalExaminationReportOnEntry.setDateTeath(dentalDate);
		masMedicalExaminationReportOnEntry.setRemarksTeath(dentalRemarks);
		masMedicalExaminationReportOnEntry
				.setMenstrualHistory(menstrualHistory);
		masMedicalExaminationReportOnEntry.setNoOfPregnancies(noOfPregnancy);
		masMedicalExaminationReportOnEntry.setNoOfAbortions(noOfAbortion);
		masMedicalExaminationReportOnEntry.setNoOfChildren(noOfChildren);
		masMedicalExaminationReportOnEntry
				.setLastConfinementDate(lastCondinement);
		masMedicalExaminationReportOnEntry
				.setVaginalDischarge(vaginalDischarge);
		masMedicalExaminationReportOnEntry.setProlapse(prolapse);
		masMedicalExaminationReportOnEntry.setUsgAbdomen(usgAbortion);
		masMedicalExaminationReportOnEntry.setGynaecologyDate(gyanaecologyDate);
		masMedicalExaminationReportOnEntry
				.setRemarksGynaecology(gyanaecologyRemarks);
		masMedicalExaminationReportOnEntry
				.setMedicalBoardFindings(medicalBoardExamination);
		masMedicalExaminationReportOnEntry
				.setDateMedicalBoardExam(medicalBoardExaminationDate);
		masMedicalExaminationReportOnEntry.setInnerEarL(innerEarL);
		//masMedicalExaminationReportOnEntry.setLmp(lmp);
		if (medicalBoardExaminationPlace != 0) {
			MasUnit masUnit1 = new MasUnit();
			masUnit1.setId(medicalBoardExaminationPlace);
			masMedicalExaminationReportOnEntry
					.setPlaceMedicalBoardExam(masUnit1);
		}
		masMedicalExaminationReportOnEntry
				.setMedicalBoardSubsequentFind(subsequentMedicalBoardExam);
		masMedicalExaminationReportOnEntry
				.setDateMedicalBoardSubsequent(subsequentMedicalBoardExamDate);
		if (subsequentMedicalBoardExamPlace != 0) {
			MasUnit masUnit2 = new MasUnit();
			masUnit2.setId(subsequentMedicalBoardExamPlace);
			masMedicalExaminationReportOnEntry
					.setPlaceMedicalBoardSubsequent(masUnit2);
		}
		masMedicalExaminationReportOnEntry
				.setApprovingAuthority(ApprovingAuthority);
		masMedicalExaminationReportOnEntry
				.setDateApprovingAuthority(ApprovingAuthorityDate);
		if (ApprovingAuthorityPlace != 0) {
			MasUnit masUnit3 = new MasUnit();
			masUnit3.setId(ApprovingAuthorityPlace);
			masMedicalExaminationReportOnEntry
					.setPlaceApprovingAuthority(masUnit3);
		}
		masMedicalExaminationReportOnEntry
				.setNearVisionWithGlassCp(withGlassesNearCP);
		masMedicalExaminationReportOnEntry
				.setNearVisionWithoutGlassCp(withoutGlassesNearCP);

		masMedicalExaminationReportOnEntry.setMediceExamDate(medicinExamDate);
		masMedicalExaminationReportOnEntry.setSurgeryDate(surgeyDate);
		masMedicalExaminationReportOnEntry.setUR1(sur1);
		masMedicalExaminationReportOnEntry.setUR2(sur2);
		masMedicalExaminationReportOnEntry.setUR3(sur3);
		masMedicalExaminationReportOnEntry.setUR4(sur4);
		masMedicalExaminationReportOnEntry.setUR5(sur5);
		masMedicalExaminationReportOnEntry.setUR6(sur6);
		masMedicalExaminationReportOnEntry.setUR7(sur7);
		masMedicalExaminationReportOnEntry.setUR8(sur8);

		masMedicalExaminationReportOnEntry.setUL1(sul1);
		masMedicalExaminationReportOnEntry.setUL2(sul2);
		masMedicalExaminationReportOnEntry.setUL3(sul3);
		masMedicalExaminationReportOnEntry.setUL4(sul4);
		masMedicalExaminationReportOnEntry.setUL5(sul5);
		masMedicalExaminationReportOnEntry.setUL6(sul6);
		masMedicalExaminationReportOnEntry.setUL7(sul7);
		masMedicalExaminationReportOnEntry.setUL8(sul8);

		masMedicalExaminationReportOnEntry.setLR1(slr1);
		masMedicalExaminationReportOnEntry.setLR2(slr2);
		masMedicalExaminationReportOnEntry.setLR3(slr3);
		masMedicalExaminationReportOnEntry.setLR4(slr4);
		masMedicalExaminationReportOnEntry.setLR5(slr5);
		masMedicalExaminationReportOnEntry.setLR6(slr6);
		masMedicalExaminationReportOnEntry.setLR7(slr7);
		masMedicalExaminationReportOnEntry.setLR8(slr8);

		masMedicalExaminationReportOnEntry.setLL1(sll1);
		masMedicalExaminationReportOnEntry.setLL2(sll2);
		masMedicalExaminationReportOnEntry.setLL3(sll3);
		masMedicalExaminationReportOnEntry.setLL4(sll4);
		masMedicalExaminationReportOnEntry.setLL5(sll5);
		masMedicalExaminationReportOnEntry.setLL6(sll6);
		masMedicalExaminationReportOnEntry.setLL7(sll7);
		masMedicalExaminationReportOnEntry.setLL8(sll8);

		Session session = getSession();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");

		hbt.setCheckWriteOperations(false);
		hbt.update(masMedicalExaminationReportOnEntry);
		hbt.flush();
		dataUpdated = true;

		// getting the second updated entity
		List<MedicalExaminationBoardDTO> mbiList = (List<MedicalExaminationBoardDTO>) generalMap
				.get("medicalExaminationBoardDTOList");

		// getting entity from the table
		List<MasMedicalBoardExaminationDetail> mbiListFromDatabase = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasMedicalBoardExaminationDetail as mc where mc.MedicalExamination ='"
								+ Id + "'");

		org.springframework.orm.hibernate3.HibernateTemplate hbt2 = getHibernateTemplate();
		hbt2.setFlushModeName("FLUSH_EAGER");
		hbt2.setCheckWriteOperations(false);
		org.hibernate.Transaction tx = null;
		if (mbiListFromDatabase != null && mbiList != null) {
			tx = sess.beginTransaction();
			int counter;
			for (MasMedicalBoardExaminationDetail mbResultOfAppealMedicalboardUnfitExpl : mbiListFromDatabase) {
				counter = 1;
				for (MedicalExaminationBoardDTO mbResultOfAppealMedicalboardUpdateDTO : mbiList) {
					if (!mbResultOfAppealMedicalboardUpdateDTO.getId().equals(
							"")
							&& mbResultOfAppealMedicalboardUnfitExpl.getId() == Integer
									.parseInt(mbResultOfAppealMedicalboardUpdateDTO
											.getId())) {

						try {
							MasMedicalBoardExaminationDetail masMedicalBoardExaminationDetailUpdate = (MasMedicalBoardExaminationDetail) getHibernateTemplate()
									.get(
											MasMedicalBoardExaminationDetail.class,
											mbResultOfAppealMedicalboardUnfitExpl
													.getId());
							masMedicalBoardExaminationDetailUpdate
									.setSrNo(Integer
											.parseInt(mbResultOfAppealMedicalboardUpdateDTO
													.getSrNo()));
							masMedicalBoardExaminationDetailUpdate
									.setRelation(mbResultOfAppealMedicalboardUpdateDTO
											.getRelation());
							masMedicalBoardExaminationDetailUpdate
									.setAge(mbResultOfAppealMedicalboardUpdateDTO
											.getAge());
							masMedicalBoardExaminationDetailUpdate
									.setHealth(mbResultOfAppealMedicalboardUpdateDTO
											.getHealth());

							masMedicalBoardExaminationDetailUpdate
									.setCauseOfDeath(mbResultOfAppealMedicalboardUpdateDTO
											.getCouseOfDeath());
							masMedicalBoardExaminationDetailUpdate
									.setDied(mbResultOfAppealMedicalboardUpdateDTO
											.getDied());

							hbt2.update(masMedicalBoardExaminationDetailUpdate);

							mbResultOfAppealMedicalboardUpdateDTO.setId("0");// updating
							// DTO in
							// mbiList
							counter++;
							break;

						} catch (Exception e) {
							e.printStackTrace();
						}
					} else if (mbResultOfAppealMedicalboardUpdateDTO.getId()
							.equals("0")
							&& mbiList.size() > counter) {
						counter++;
						continue;
					} else if (!mbResultOfAppealMedicalboardUpdateDTO.getId()
							.equals("")) {
						try {
							MasMedicalBoardExaminationDetail mbResultOfAppealMedicalboardUnfitExplUpdate = (MasMedicalBoardExaminationDetail) getHibernateTemplate()
									.get(
											MasMedicalBoardExaminationDetail.class,
											mbResultOfAppealMedicalboardUnfitExpl
													.getId());

							hbt2
									.delete(mbResultOfAppealMedicalboardUnfitExplUpdate);
							break;
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					}
				}

			}

			for (MedicalExaminationBoardDTO mbResultOfAppealMedicalboardUpdateDTO : mbiList) {

				if (mbResultOfAppealMedicalboardUpdateDTO.getId() != null
						&& mbResultOfAppealMedicalboardUpdateDTO.getId()
								.equals("")) {

					hbt2.setCheckWriteOperations(false);
					MasMedicalExaminationReportOnEntry mbResultOfAppealMedicalboardMaster1 = new MasMedicalExaminationReportOnEntry();
					MasMedicalBoardExaminationDetail mbResultOfAppealMedicalboardUnfitExplUpdate = new MasMedicalBoardExaminationDetail();
					mbResultOfAppealMedicalboardUnfitExplUpdate.setSrNo(Integer
							.parseInt(mbResultOfAppealMedicalboardUpdateDTO
									.getSrNo()));

					mbResultOfAppealMedicalboardUnfitExplUpdate
							.setRelation(mbResultOfAppealMedicalboardUpdateDTO
									.getRelation());
					mbResultOfAppealMedicalboardUnfitExplUpdate
							.setAge(mbResultOfAppealMedicalboardUpdateDTO
									.getAge());
					mbResultOfAppealMedicalboardUnfitExplUpdate
							.setHealth(mbResultOfAppealMedicalboardUpdateDTO
									.getHealth());
					mbResultOfAppealMedicalboardUnfitExplUpdate
							.setCauseOfDeath(mbResultOfAppealMedicalboardUpdateDTO
									.getCouseOfDeath());
					mbResultOfAppealMedicalboardUnfitExplUpdate
							.setDied(mbResultOfAppealMedicalboardUpdateDTO
									.getDied());
					mbResultOfAppealMedicalboardMaster1.setId(Id);
					mbResultOfAppealMedicalboardUnfitExplUpdate
							.setMedicalExamination(mbResultOfAppealMedicalboardMaster1);
					hbt.save(mbResultOfAppealMedicalboardUnfitExplUpdate);
				}
			}
			tx.commit();
			dataUpdated = true;

		}
		return dataUpdated;

	}

	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}
}
